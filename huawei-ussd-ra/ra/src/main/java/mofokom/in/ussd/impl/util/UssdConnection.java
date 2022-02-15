/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.ussd.impl.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import mofokom.in.ussd.UssdCommand;
import mofokom.in.ussd.impl.UssdCommandImpl;
import mofokom.test.AbstractUssdEventListener;

/**
 *
 * @author wozza
 */
public class UssdConnection {

    public InetSocketAddress address;
    private Socket socket;
    private final UssdConnectionListener listener;
    private static final Logger logger =  Logger.getLogger(UssdConnection.class.getName());

    public UssdConnection(InetSocketAddress address, UssdConnectionListener listener) {
        this.address = address;
        this.listener = listener;
    }

    public void start(boolean tcpNoDelay, int timeout, int bufferSize, boolean keepAlive) throws IOException {
        socket = new Socket();
        socket.setTcpNoDelay(tcpNoDelay);
        socket.setSoTimeout(timeout);
        if (bufferSize > 0) {
            socket.setReceiveBufferSize(bufferSize);
            socket.setSendBufferSize(bufferSize);
        }

        socket.setKeepAlive(keepAlive);
        socket.setReuseAddress(true);

        socket.connect(address);

        logger.info("connected " + socket.toString() + " " + socket.getReceiveBufferSize() + " " + socket.getSendBufferSize());

        new Thread() {

            @Override
            public void run() {
                while (!socket.isConnected()) {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException ex) {
                    }
                }

                listener.connected(UssdConnection.this);

                logger.info("connected " + socket.isConnected());
                ByteBuffer bb = ByteBuffer.allocate(500);
                while (socket.isConnected() && !socket.isClosed()) {
                    InputStream in = null;
                    UssdConnection.this.sleep(200L);
                    try {
                        in = socket.getInputStream();

                        bb = Util.waitOnInput(in, bb, listener);
                    } catch (ClassNotFoundException ex) {
                        listener.exception(UssdConnection.this, ex);
                        ex.printStackTrace();
                    } catch (InstantiationException ex) {
                        listener.exception(UssdConnection.this, ex);
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        listener.exception(UssdConnection.this, ex);
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        listener.exception(UssdConnection.this, ex);
                        ex.printStackTrace();
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
                listener.disconnected(UssdConnection.this);
            }
        }.start();
    }

    public Socket getSocket() {
        return socket;
    }

    public void send(UssdCommand cmd) throws IOException {
        if(cmd == null)
            throw new NullPointerException("cannot send null");
        try {
            logger.info("<" + ((UssdCommandImpl) cmd).toString());
            send(((UssdCommandImpl) cmd).toByteArray());
        } catch (Exception x) {
            logger.info("err:  " + ((UssdCommandImpl) cmd).toString());
            x.printStackTrace();
            throw new IOException(x);
        }
    }

    public void send(byte[] data) throws IOException {

        /*
        logger.info("write " + data.length);
        for (byte b : data) {
        logger.info("(byte)" + b + ",");
        //logger.info("b" + socket.isConnected() + " " + socket.isClosed());
        //socket.getOutputStream().write(data);
        //socket.getOutputStream().flush();
        //logger.info("a" + socket.isConnected() + " " + socket.isClosed());
         }*/
        if(!socket.isConnected())
            throw new IOException("socket is not connected");
        socket.getOutputStream().write(data);
        socket.getOutputStream().flush();

    }

    public void end() throws IOException {
        if (!socket.isConnected()) {
            logger.info("close");
            socket.close();
        } else {
            logger.info("already closed");
        }
    }

    private void sleep(long l) {
        try {
            Thread.currentThread().sleep(l);
        } catch (Exception ex) {
        }
    }
}
