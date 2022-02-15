/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.mgcp.resource.impl;

import java.io.Serializable;
import mofokom.in.mgcp.resource.MGCPActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;

/**
 *
 * @author wozza
 */
public class MGCPActivityImpl<T,O extends Serializable,R> extends AbstractSynchronousTransaction<T,O,R> implements MGCPActivity {

    public MGCPActivityImpl(T attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}