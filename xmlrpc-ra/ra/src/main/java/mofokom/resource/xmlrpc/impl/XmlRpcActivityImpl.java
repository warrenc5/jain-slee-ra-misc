/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.xmlrpc.impl;

import java.io.Serializable;
import mofokom.resource.xmlrpc.XmlRpcActivity;
import mofokom.resource.common.AbstractSynchronousTransaction;

/**
 *
 * @author wozza
 */
public class XmlRpcActivityImpl<T,R> extends AbstractSynchronousTransaction<T,Serializable,R> implements XmlRpcActivity {

    public XmlRpcActivityImpl(T attachment, int ra, int seq) {
        super(attachment, ra, seq);
    }
}