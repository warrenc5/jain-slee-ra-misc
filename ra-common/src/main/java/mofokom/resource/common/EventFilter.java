/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.slee.EventTypeID;
import javax.slee.ServiceID;
import javax.slee.resource.ReceivableService;
import javax.slee.resource.ReceivableService.ReceivableEvent;

/**
 *
 * @author wozza
 */
public class EventFilter {

    protected Set<EventTypeID> eventTypeSet;
    protected Set<EventTypeID> eventTypeMaskSet;
    protected Set<EventTypeID> initialEventTypeMaskSet;

    public EventFilter(Collection<EventTypeID> eventTypeSet) {
        serviceEventTypeMap = new HashMap<ServiceID, ReceivableEvent[]>();
        eventTypeMaskSet = new HashSet<EventTypeID>();
        this.eventTypeSet = new HashSet<EventTypeID>();
        if(eventTypeSet!=null)
            this.eventTypeSet.addAll(eventTypeSet);
    }

    private Map<ServiceID, ReceivableEvent[]> serviceEventTypeMap;

    public void serviceActive(ReceivableService serviceInfo) {
        serviceEventTypeMap.put(serviceInfo.getService(), serviceInfo.getReceivableEvents());
        calculateEvenTypeSet();
    }

    public void serviceStopping(ReceivableService serviceInfo) {
        Set<ReceivableEvent> receivableEvents = new HashSet<ReceivableEvent>();
        for (ReceivableEvent e : serviceInfo.getReceivableEvents()) {
            if (!e.isInitialEvent())
                receivableEvents.add(e);
        }
        serviceEventTypeMap.put(serviceInfo.getService(), receivableEvents.toArray(new ReceivableEvent[receivableEvents.size()]));
        calculateEvenTypeSet();
    }

    public void serviceInactive(ReceivableService serviceInfo) {
        serviceEventTypeMap.remove(serviceInfo.getService());
        calculateEvenTypeSet();
    }

    private synchronized void calculateEvenTypeSet() {
        if (eventTypeSet == null)
            return;

        for (ServiceID s : serviceEventTypeMap.keySet()) {
            for (ReceivableEvent e : serviceEventTypeMap.get(s)) {
                if (eventTypeSet.contains(e.getEventType())) {
                    eventTypeMaskSet.add(e.getEventType());
                }
            }
        }
    }

    boolean isEventSupressed(EventTypeID eventTypeID) {
        return eventTypeSet != null && !eventTypeMaskSet.contains(eventTypeID);
    }
}
