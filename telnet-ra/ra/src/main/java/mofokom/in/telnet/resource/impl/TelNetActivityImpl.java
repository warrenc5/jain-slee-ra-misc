/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.telnet.resource.impl;

import java.io.Serializable;
import mofokom.in.telnet.resource.TelNetActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;

/**
 *
 * @author wozza
 */
public class TelNetActivityImpl<T,AO extends Serializable,R> extends AbstractSynchronousTransaction<T,AO,R> implements TelNetActivity {

    public TelNetActivityImpl(T attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}