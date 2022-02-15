/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.directory.resource.impl;

import mofokom.in.directory.resource.DirectoryActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;

/**
 *
 * @author wozza
 */
public class DirectoryActivityImpl<T,R> extends AbstractSynchronousTransaction<T,R> implements DirectoryActivity {

    public DirectoryActivityImpl(T attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}