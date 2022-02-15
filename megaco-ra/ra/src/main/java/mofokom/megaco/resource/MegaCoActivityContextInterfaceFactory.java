/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource;

import javax.megaco.UserId;
import javax.slee.ActivityContextInterface;
import javax.slee.UnrecognizedActivityException;

/**
 *
 * @author wozza
 */
public interface MegaCoActivityContextInterfaceFactory {

    public ActivityContextInterface getActivityContextInterface(UserId userId) throws UnrecognizedActivityException;

    public ActivityContextInterface getActivityContextInterface(AssociationId activity) throws UnrecognizedActivityException;

    public ActivityContextInterface getActivityContextInterface(javax.megaco.message.ContextInfo activity) throws UnrecognizedActivityException;

    public ActivityContextInterface getActivityContextInterface(javax.megaco.message.Termination activity) throws UnrecognizedActivityException;

    public ActivityContextInterface getActivityContextInterface(javax.megaco.message.ContextInfoReq activity) throws UnrecognizedActivityException;

    public ActivityContextInterface getActivityContextInterface(javax.megaco.message.ContextInfoResp activity) throws UnrecognizedActivityException;

    public ActivityContextInterface getActivityContextInterface(javax.megaco.message.CommandReq activity) throws UnrecognizedActivityException;

   public ActivityContextInterface getActivityContextInterface(javax.megaco.message.CommandResp activity) throws UnrecognizedActivityException;

   public ActivityContextInterface getActivityContextInterface(javax.megaco.AssociationEvent activity) throws UnrecognizedActivityException;
}
