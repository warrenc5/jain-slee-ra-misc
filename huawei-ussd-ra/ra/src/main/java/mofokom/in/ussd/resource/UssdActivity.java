/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.ussd.resource;

import java.util.List;
import javax.slee.Address;

/**
 *
 * @author wozza
 */
public interface UssdActivity {

    List getCommandHistory();

    boolean isMobileTerminating();

    Address getServiceCode();
}
