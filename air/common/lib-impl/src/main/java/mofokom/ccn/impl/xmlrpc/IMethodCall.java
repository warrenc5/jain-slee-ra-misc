/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl.xmlrpc;

import mofokom.ccn.impl.Codeable;

/**
 *
 * @author wozza
 */
public interface IMethodCall extends Codeable {
    Class<? extends IMethodResponse> forFaultResponse() ;
    Class<? extends IMethodResponse> forMethodResponse() ;
}