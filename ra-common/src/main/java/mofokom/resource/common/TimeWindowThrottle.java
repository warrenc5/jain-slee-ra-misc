/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.common;

import java.util.concurrent.atomic.AtomicLong;
import javax.slee.facilities.AlarmFacility;
import javax.slee.facilities.AlarmLevel;

/**
 *
 * @author wozza
 */
public class TimeWindowThrottle {

    private AtomicLong throttle;
    private long then;
    private final long maxTps;
    private String alarmId;
    private final AlarmFacility alarm;

    public TimeWindowThrottle(AlarmFacility alarm, long maxTps) {
        this.alarm = alarm;
        throttle = new AtomicLong(0);
        this.maxTps = maxTps;

    }

    public synchronized void incrementOrWait() throws InterruptedException {
        if (then == 0)
            then = System.currentTimeMillis();

        if (maxTps > 0 && throttle.getAndIncrement() > maxTps) {
            throttle.set(0L);

            long now = System.currentTimeMillis();
            long timeTaken = now - then;
            long t = 0;

            if ((t = (1000L - timeTaken)) > 0) {
                alarmId = alarm.raiseAlarm("", "", AlarmLevel.MAJOR, "Throttling " + t + "ms.");
                Thread.currentThread().sleep(Math.max(t, 50));
            }
        } else if (alarmId != null)
            alarm.clearAlarm(alarmId);
    }
}
