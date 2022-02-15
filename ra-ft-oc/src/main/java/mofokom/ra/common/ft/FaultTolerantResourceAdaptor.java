/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.ra.common.ft;

import com.opencloud.rhino.facilities.replicatedstorage.ReplicatedStorageException;
import com.opencloud.rhino.facilities.replicatedstorage.ReplicatedStorageFacility;
import com.opencloud.rhino.resourceadaptor.ReplicatingResourceAdaptor;
import java.io.IOException;
import java.io.Serializable;
import javax.slee.facilities.Tracer;
import javax.slee.resource.*;

/**
 *
 * @author wozza
 */
public abstract class FaultTolerantResourceAdaptor implements ReplicatingResourceAdaptor, FaultTolerant {

    //OC
    private ReplicatedStorageFacility facility;
    private ReplicatedMap db;
    private Tracer tracer;
    private ResourceAdaptorContext raContext;

    public void setResourceAdaptorContext(ResourceAdaptorContext raContext) {
        this.tracer = raContext.getTracer(raContext.getEntityName());
        this.raContext = raContext;
    }

    //OC
    public void adoptActivities(ActivityHandle[] ahs) {
        for (ActivityHandle handle : ahs) {
            Serializable activtyData = null;
            try {
                activtyData = db.get(ahs);
            } catch (IOException ex) {
                tracer.severe(ex.getMessage(), ex);
            } catch (ClassNotFoundException ex) {
                tracer.severe(ex.getMessage(), ex);
            } catch (ReplicatedStorageException ex) {
                tracer.severe(ex.getMessage(), ex);
            }
            try {
                this.reassociateActivity(handle, activtyData);
            } catch (Exception ex) {
                tracer.severe(ex.getMessage(), ex);
            }
        }
    }

    public void raConfigure(ConfigProperties properties) {
        if (facility == null)
            facility = (ReplicatedStorageFacility) properties.getProperty(ReplicatedStorageFacility.CONFIG_PROPERTY_NAME).getValue();
    }

    public ReplicatedMap getReplicatedMap() {

        if (db == null)
            db = new ReplicatedMap(facility.getReplicatedStorage(raContext.getEntityName()));
        return db;
    }
    protected String getToleranceProvider() {
        return "Opencloud";
    }

}