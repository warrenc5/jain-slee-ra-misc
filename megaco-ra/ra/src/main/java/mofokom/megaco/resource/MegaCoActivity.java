/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.megaco.resource;

import java.util.concurrent.Future;
import javax.megaco.AssociationEvent;

/**
 *
 * @author wozza
 */
public interface MegaCoActivity {

     public Future<? extends AssociationEvent> getSynchronousResult() ;

}
