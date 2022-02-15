/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.SynchronousQueue;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;

/**
 *
 * @author wozza
 */
public class DefaultMarshaller<O> implements javax.slee.resource.Marshaler {

    public static byte[] serialize(Serializable key) throws IOException {
        ByteArrayOutputStream baos;
        ObjectOutputStream oos = new ObjectOutputStream(baos = new ByteArrayOutputStream(2048));
        oos.writeObject(key);
        return baos.toByteArray();
    }

    public static Serializable deserialize(byte[] value) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(value));
        return (Serializable) ois.readObject();
    }

    private InputStream dummyIn = new ByteArrayInputStream(new byte[0]);
    private OutputStream dummyOut = new ByteArrayOutputStream();
    private SynchronousQueue<ByteBuffer> queue = new SynchronousQueue<ByteBuffer>();

    public int getEstimatedEventSize(FireableEventType eventType, Object event) {
        return 1024;
    }

    public ByteBuffer getEventBuffer(FireableEventType eventType, Object event) {
        ByteBuffer buffy = queue.poll();
        if (buffy == null)
            buffy = ByteBuffer.allocate(1024);
        try {
            marshalSerializable(event, buffy);
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        return buffy;
    }

    public void releaseEventBuffer(FireableEventType eventType, Object event, ByteBuffer buffer) {

        buffer.flip();
        
        if(queue.size()<1000)
            queue.offer(buffer);

    }

    public void marshalEvent(FireableEventType eventType, Object event, final DataOutput out) throws IOException {
        marshalSerializable(event,out);
   }

    public Object unmarshalEvent(FireableEventType eventType, DataInput in) throws IOException {
        try {
            return unmarshalSerializable(Class.forName(eventType.getEventClassName(), false, eventType.getEventClassLoader()), in);
        } catch (ClassNotFoundException ex) {
            throw new IOException(ex);
        } catch (InstantiationException ex) {
            throw new IOException(ex);
        } catch (IllegalAccessException ex) {
            throw new IOException(ex);
        }
    }

    public int getEstimatedHandleSize(ActivityHandle handle) {
        return 512;
    }

    public void marshalHandle(ActivityHandle handle, DataOutput out) throws IOException {
        marshalSerializable(handle, out);
    }

    public ActivityHandle unmarshalHandle(DataInput in) throws IOException {
        try {
            return (ActivityHandle) unmarshalSerializable(TransactionHandle.class, in);
        } catch (ClassNotFoundException ex) {
            throw new IOException(ex);
        } catch (InstantiationException ex) {
            throw new IOException(ex);
        } catch (IllegalAccessException ex) {
            throw new IOException(ex);
        }
    }

    private void marshalSerializable(Object event, final DataOutput out) throws IOException {
        java.io.Externalizable e = (Externalizable) event;
        e.writeExternal(new ObjectOutputStream(dummyOut) {
            @Override
            public void write(int val) throws IOException {
                out.write(val);
            }
        });
    }

    private void marshalSerializable(Object event, final ByteBuffer buffy) throws IOException {
        java.io.Externalizable e = (Externalizable) event;
        e.writeExternal(new ObjectOutputStream(dummyOut) {
            @Override
            public void write(int val) throws IOException {
                buffy.put((byte)val);
            }
        });
    }

    private Serializable unmarshalSerializable(Class clazz, final DataInput in) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        java.io.Externalizable e = (Externalizable) clazz.newInstance();
        e.readExternal(new ObjectInputStream(dummyIn) {
            @Override
            public int read() throws IOException {
                return in.readByte();
            }
        });
        return e;
    }
}