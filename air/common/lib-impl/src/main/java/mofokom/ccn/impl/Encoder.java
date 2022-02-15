/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import mofokom.ccn.Marker;
import mofokom.ccn.impl.xmlrpc.IMethodCall;
import mofokom.ccn.impl.xmlrpc.IMethodResponse;

/**
 *
 * @author wozza
 */
public abstract class Encoder {

    public abstract void encode(String name, int param) ;
    public abstract void encode(String name, String param) ;
    public abstract void encode(String name, Date param) ;
    public abstract void encode(String name, Calendar param) ;
    public abstract void encode(String name, boolean param) ;
    public abstract void encode(String name, Marker param) ;
    public abstract void encode(String name, java.util.List param) ;

    public void start(String string, Marker marker) {
        if (marker instanceof IMethodCall || marker instanceof IMethodResponse)
            processAsMessage(string, marker);
        else
            processAsMap(string,marker);
    }

    public abstract void processAsMessage(String string, Marker marker) ;

    public abstract void processAsMap(String string, Marker marker) ;

    public abstract Object getObject() ;


}
