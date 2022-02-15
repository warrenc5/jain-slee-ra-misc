/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.ussd.impl.util;

import mofokom.in.ussd.UssdCommand;

/**
 *
 * @author wozza
 */
public interface UssdEventListener extends java.util.EventListener {

    void received(UssdCommand cmd);

}
