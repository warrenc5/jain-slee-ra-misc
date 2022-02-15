/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mofokom.ccn.Marker;
import mofokom.ccn.impl.xmlrpc.IMethodResponse;

/**
 *
 * @author wozza
 */
public abstract class Decoder {
    protected boolean fault;


    public abstract List<? extends Marker> decodeList(String string, Class<? extends Marker> clazz) throws InstantiationException, IllegalAccessException;;
    public abstract Codeable decode(String string, Class<? extends Marker> clazz) throws InstantiationException, IllegalAccessException;
    public abstract Integer decodeInteger(String string) ;
    public abstract int decodeInt(String string) ;
    public abstract String decodeString(String string) ;
    public abstract Date decodeDate(String string) ;
    public abstract Calendar decodeCalendar(String string) ;
    public abstract Boolean decodeBoolean(String string) ;
    public abstract List<Integer> decodeIntegerList(String string) ;

    public void start(String string, Marker marker) {
        if(marker instanceof IMethodResponse)
            processAsMessage(string,marker);
        else
            processAsMap(string,marker);
    }

    public abstract void processAsMessage(String string, Marker marker) ;

    public abstract void processAsMap(String string, Marker marker) ;

    public boolean isFault() {
        return fault;
    }

}