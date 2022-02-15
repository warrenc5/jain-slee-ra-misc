/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.sap.resource;

import mofokom.resource.common.UsageParameters;

/**
 *
 * @author wozza
 */
public interface Usage extends UsageParameters{
    //these are statistics

    Long getCumulativeRetransmitSize();

    Integer getScheduledAnnouncements();

    Long getAverageRetransmitDelay();
}
