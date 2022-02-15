/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.ussd.resource;

import java.io.IOException;
import mofokom.in.ussd.UssdBegin;
import mofokom.in.ussd.UssdCommand;

/**
 *
 * @author wozza
 */
public interface UssdResourceAdaptorSbbInterface {

    MessageFactory getMessageFactory();
    void send(UssdCommand command) throws IOException;
    UssdActivity send(UssdBegin command) throws IOException;
    void send(UssdActivity activity,UssdCommand command) throws IOException;
    String errorForCommandStatus(int statusCode);

}
