package javax.megaco.message.descriptor;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The TimeStamp object is a class that shall be used to set the time and date
 * at which the event was detected within the observed event descriptor. This is
 * an independent class derived from java.util.Object and shall not have any
 * derived classes.  per ISO 8601:2004

 */
public class TimeStamp implements Serializable {

    private GregorianCalendar gc;
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int min;
    private final int sec;
    private final int milli;

    /**
     * Constructs a timestamp object that contains the date and time. This shall
     * be used within the observed event to detect the time at which the event
     * was detected.
     *
     * @param year -
     * @param month - index of month, starting from 0 for January
     * @param day - day of month
     * @param hour - 24h format hour
     * @param min -
     * @param sec - parameter is set.
     */
    public TimeStamp(int year, int month, int day, int hour, int min, int sec, int milli) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.milli = milli;
    }

    /**
     * The method is used the to retrieve the year from the absolute date set.
     *
     * @return year - The integer value of the year.
     */
    public int getYear() {
        return year;
    }

    /**
     * The method can be used the to retrieve month set in the object.
     *
     * @return month - Integer value of the month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * The method can be used the to retrieve day set in the object.
     *
     * @return day - Integer value of the day.
     */
    public int getDay() {
        return day;
    }

    /**
     * The method is used the to retrieve the hour from the absolute time set.
     *
     * @return hour - The integer value of the hour.
     */
    public int getHour() {
        return hour;
    }

    /**
     * The method is used the to retrieve the minutes from the absolute time
     * set.
     *
     * @return minutes - The integer value of the minutes.
     */
    public int getMinutes() {
        return min;
    }

    /**
     * The method is used the to retrieve the secs from the absolute time set.
     *
     * @return secs - The integer value of the secs.
     */
    public int getSecs() {
        return sec;
    }
    private static transient DateFormat f;

    public Date validate() {
        //System.out.println("**" + sec + " " + milli);
        if (gc == null) {
            gc = new GregorianCalendar();
            gc.setLenient(false);

            gc.set(gc.YEAR, year);
            gc.set(gc.MONTH, month - 1);
            gc.set(gc.DAY_OF_MONTH, day);
            gc.set(gc.HOUR_OF_DAY, hour-1);
            gc.set(gc.MINUTE, min);
            gc.set(gc.SECOND, sec);
            gc.set(gc.MILLISECOND, milli);
        }

        // here we validate
        return gc.getTime();

    }

    /**
     *
     * @return
     */
    public String toStringEncode() {
        if (f == null)
            f = new SimpleDateFormat("yyyyMMdd'T'HHmmssSS");

        return f.format(validate());
    }



public String toString() {
 StringBuilder bob = new StringBuilder();
bob.append("TimeStamp:");

if(gc !=null)
bob.append("gc=").append(gc).append(",");
bob.append("year=").append(year).append(",");
bob.append("month=").append(month).append(",");
bob.append("day=").append(day).append(",");
bob.append("hour=").append(hour).append(",");
bob.append("min=").append(min).append(",");
bob.append("sec=").append(sec).append(",");
bob.append("milli=").append(milli).append(",");

return bob.append(";").toString(); 
}




public boolean equals(Object oo) { 
 if(this == oo) return true;


if (oo == null || (!this.getClass().isAssignableFrom(oo.getClass()) || !oo.getClass().getName().equals(this.getClass().getName()))) return false; 
javax.megaco.message.descriptor.TimeStamp o = (javax.megaco.message.descriptor.TimeStamp)oo;
if((gc !=null && o.gc == null) ||(gc == null && o.gc != null) ) return false;
if(gc ==null && o.gc == null) return true ; else if(gc !=null && o.gc != null)
if (gc != null && o.gc !=null && !gc.equals(o.gc)) return false;
if (year != o.year) return false;
if (month != o.month) return false;
if (day != o.day) return false;
if (hour != o.hour) return false;
if (min != o.min) return false;
if (sec != o.sec) return false;
if (milli != o.milli) return false;

return true;
}




}
