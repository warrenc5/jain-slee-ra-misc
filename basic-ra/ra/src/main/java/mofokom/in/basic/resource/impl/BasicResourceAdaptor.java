/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.basic.resource.impl;

import java.util.Collection;
import java.util.HashSet;
import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import mofokom.in.basic.resource.BasicResourceAdaptorInterface;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.TransactionException;

/**
 *
 * @author wozza
 */
public class BasicResourceAdaptor extends AbstractResourceAdaptor implements BasicResourceAdaptorInterface {


    public BasicActivityImpl createActivity(Object activityObject) {
        BasicActivityImpl<Object,Object> activity = new BasicActivityImpl<Object,Object>(activityObject, this.hashCode(), sequence.getNextSequenceNumber());
        return activity;
    }

    @Override
    public void processTransactionFailure(TransactionException transactionException) {
    }

    @Override
    public Object getResourceAdaptorInterface(String className) {
        return this;
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        return Arrays.asList();
    }
}
