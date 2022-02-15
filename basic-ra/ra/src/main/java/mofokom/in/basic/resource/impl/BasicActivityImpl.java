/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.basic.resource.impl;

import mofokom.in.basic.resource.BasicActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;

/**
 *
 * @author wozza
 */
public class BasicActivityImpl<T,R> extends AbstractSynchronousTransaction<T,R> implements BasicActivity {

    public BasicActivityImpl(T attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}