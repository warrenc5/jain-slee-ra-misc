package mofokom.resource.mlp.impl;

import com.mofokom.j4mlp.element.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import javax.slee.EventTypeID;
import javax.slee.resource.ResourceAdaptorContext;
import mofokom.resource.common.AbstractTransaction;
import mofokom.resource.common.TransactionException;
import mofokom.resource.common.TransportException;
import mofokom.resource.mlp.MLPResourceAdaptorInterface;
import mofokom.resource.http.common.AbstractJAXBResourceAdaptor;
import mofokom.resource.mlp.MLPActivity;

public class MLPResourceAdaptor extends AbstractJAXBResourceAdaptor<MLPActivityImpl, MLPResourceAdaptorUsageParameters> {

    private MLPResourceAdaptorImpl raInterface;
    private static EventTypeID slir, emerep, emelia, emelir, tlrep, tlra, tlrsa, tlrsr, tlrr, slrep, slirep, slia;
    private ConcurrentHashMap<String, MLPActivityImpl> requestMap;
    private ThreadLocal<SimpleDateFormat> sdf = null;

    @Override
    public void unsetResourceAdaptorContext() {
        super.unsetResourceAdaptorContext();
        sdf = null;
        requestMap = null;
    }

    @Override
    public void raInactive() {
        super.raInactive();
        requestMap.clear();
    }

    @Override
    public void raActive() {
        super.raActive();
        this.requestMap = new ConcurrentHashMap<String, MLPActivityImpl>(super.activityDimension);
    }



    @Override
    protected void endActivity(AbstractTransaction activity) {
        super.endActivity(activity);
        requestMap.remove(activity.getActivityHandle().getAttachment());
    }

    @Override
    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
        VERSION = raContext.getResourceAdaptorTypes()[0].getVersion();
        super.setResourceAdaptorContext(raContext);
        this.raInterface = new MLPResourceAdaptorImpl();
        sdf = new ThreadLocal<SimpleDateFormat>() {

            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("YYYYMMDDHHmmSS Z");
            }
        };

        slir = new EventTypeID("Standard Location Immediate Request", VENDOR, VERSION);
        slrep = new EventTypeID("Standard Location Report", VENDOR, VERSION);
        slia = new EventTypeID("Standard Location Immediate Answer", VENDOR, VERSION);
        slirep = new EventTypeID("StandardLocation Immediate Report", VENDOR, VERSION);
        emerep = new EventTypeID("Emergency Location Report", VENDOR, VERSION);
        emelia = new EventTypeID("Emergency Location Immediate Answer", VENDOR, VERSION);
        emelir = new EventTypeID("Emergency Location Immediate Request", VENDOR, VERSION);
        tlrep = new EventTypeID("Triggered Location Reporting Report", VENDOR, VERSION);
        tlra = new EventTypeID("Triggered Location Reporting Answer", VENDOR, VERSION);
        tlrsa = new EventTypeID("Triggered Location Reporting Stop Answer", VENDOR, VERSION);
        tlrsr = new EventTypeID("Triggered Location Reporting Stop Request", VENDOR, VERSION);
        tlrr = new EventTypeID("Triggered Location Reporting Request", VENDOR, VERSION);

    }

    @Override
    public EventTypeID getEventTypeForResponse(MLPActivityImpl txn, Object o) {

        tracer.info("get event for response " + o.getClass().getName());

        if (o instanceof Slir)
            return slir;
        else if (o instanceof Slia)
            return slia;
        else if (o instanceof Slirep)
            return slirep;
        else if (o instanceof Slir)
            return slir;
        else if (o instanceof Slrep)
            return slrep;
        else if (o instanceof Tlrr)
            return tlrr;
        else if (o instanceof Tlrsr)
            return tlrsr;
        else if (o instanceof Tlrsa)
            return tlrsa;
        else if (o instanceof Tlra)
            return tlra;
        else if (o instanceof Tlrep)
            return tlrep;
        else if (o instanceof EmeLir)
            return emelir;
        else if (o instanceof EmeLia)
            return emelia;
        else if (o instanceof Emerep)
            return emerep;

        return null;
    }

    @Override
    public MLPActivityImpl createActivity(Object o) {

        String requestId = null;
        MLPActivityImpl txn;

        if (o instanceof Slirep)
            requestId = ((Slirep) o).getReqId();
        else if (o instanceof Tlrep)
            requestId = ((Tlrep) o).getReqId();
        else {
        }

        //NOTE this will use the same activity in client/server mode
        if (requestId != null) {
            txn = requestMap.get(requestId);
            if (txn != null)
                return txn;
        }

        //TODO set timeouts for requests TLRR?? and when to end activity
        txn = new MLPActivityImpl((Serializable) o, this.hashCode(), sequence.getNextSequenceNumber());

        return txn;
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return raInterface;
    }

    @Override
    public Object optionalDecodeResponse(MLPActivityImpl txn, Object response) throws Exception {

        processRequestIdForActivity(txn, response);
        return response;
    }

    @Override
    public Object optionalEncodeRequest(MLPActivityImpl txn, Object request) throws Exception {

        processRequestIdForActivity(txn, request);

        StopTime stopTime = null;
        if (request instanceof Tlrr) {
            stopTime = ((Tlrr) request).getStopTime();
            if (stopTime != null) {
                Date when = null;
                when = sdf.get().parse(new StringBuilder(stopTime.getContent()).append(' ').append(stopTime.getUtcOff()).toString());
                super.scheduleEndActivity(txn, when);
            }
        }

        return request;
    }

    @Override
    public Collection getEventTypeSet() {
        return Arrays.asList(new EventTypeID[]{slir, emerep, emelia, emelir, tlrep, tlra, tlrsa, tlrsr, tlrr, slrep, slirep, slia});
    }

    @Override
    public Class getFactoryClass() {
        return Slir.class;
    }

    @Override
    public void processTransactionFailure(MLPActivityImpl txn, TransportException transportError) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void processTransactionFailure(TransactionException transactionException) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void processRequestIdForActivity(MLPActivityImpl txn, Object o) {
        String requestId = null;

        if (o instanceof Slia)
            requestId = ((Slia) o).getReqId();
        if (o instanceof Tlra)
            requestId = ((Tlra) o).getReqId();
        if (o instanceof Tlrsa)
            requestId = ((Tlrsa) o).getReqId();

        if (requestId != null) {
            requestMap.put(requestId, txn);
            txn.getActivityHandle().setAttachment(requestId);
        }
    }



    private class MLPResourceAdaptorImpl implements MLPResourceAdaptorInterface {

        public MLPActivity sendEmeLia(EmeLia request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendEmerep(Emerep request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendEmeLir(EmeLir request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendSlir(Slir request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendSlia(Slia request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendSlirep(Slirep request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendTlrr(Tlrr request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendTlrsl(Tlrsr request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendTla(Tlra request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendTlrep(Tlrep request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendTlrsr(Tlrsr request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }

        public MLPActivity sendTlrsa(Tlrsa request) {
            return MLPResourceAdaptor.this.sendRequest(request);
        }
    }
}
