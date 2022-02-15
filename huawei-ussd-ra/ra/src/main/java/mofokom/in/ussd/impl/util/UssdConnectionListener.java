/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.ussd.impl.util;

/**
 *
 * @author wozza
 */
public interface UssdConnectionListener extends UssdEventListener {

    void connected(UssdConnection connection);
    void exception(UssdConnection connection,Exception ex);
    void disconnected(UssdConnection connection);

}
