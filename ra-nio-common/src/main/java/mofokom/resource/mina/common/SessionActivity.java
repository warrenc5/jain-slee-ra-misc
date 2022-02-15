/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.mina.common;

import java.io.Serializable;
import mofokom.resource.common.AbstractTransaction;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author wozza
 */
public class SessionActivity extends AbstractTransaction<IoSession, Serializable> {

    public SessionActivity(IoSession attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }


}
