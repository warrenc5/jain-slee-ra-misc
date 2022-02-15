/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource;

import java.util.TooManyListenersException;
import javax.megaco.*;
import javax.megaco.association.*;
import javax.megaco.message.CommandReq;
import javax.megaco.message.CommandResp;
import javax.megaco.message.ContextInfoReq;
import javax.megaco.message.ContextInfoResp;
import javax.sdp.SdpParseException;
import javax.sdp.SessionDescription;

/**
 *
 * @author wozza
 */
public interface MegaCoResourceAdaptorInterface extends MegacoProvider {

    public boolean isSynchronousSupported();

    /**
     * adds a JAIN MEGACO Listener, with a unique user Id, to the list of Event
     * Listeners registered on an implementation of the MegacoProvider
     * interface. The stack shall allocate the assoc handle which would be used
     * by the listener for subsequent communication with the stack.
     *
     * @param listener
     * @param UserId
     * @return
     * @throws TooManyListenersException
     * @throws IllegalArgumentException
     * @throws InvalidUserIdException
     * @throws AssocHandleExhaustedException
     */
    @Override
    public int addMegacoListener(MegacoListener listener, UserId UserId) throws TooManyListenersException, InvalidUserIdException, AssocHandleExhaustedException, IllegalArgumentException;

    /**
     * Returns an object reference to Association handle with reference to the
     * userId.
     *
     * @param UserId
     * @return
     * @throws NonExistentAssocException
     */
    @Override
    public int getAssocHandle(UserId UserId) throws NonExistentAssocException;

    /**
     * Returns an object reference to the underlying JAIN MEGACO Stack to which
     * this JAIN MEGACO Provider is bound.
     *
     * @return
     */
    @Override
    public MegacoStack getMegacoStack();

    /**
     * Removes the user Id with which the Listener has been registered with the
     * Provider. If the specified Listener is registered with the Provider, with
     * the only user Id corresponding to which the user Id is provided, then
     * removes the Listener from the list of Event Listeners.
     *
     * @param listener
     * @param assocHandle
     * @throws IllegalArgumentException
     */
    @Override
    public void removeMegacoListener(MegacoListener listener, int assocHandle) throws IllegalArgumentException;

    /**
     *
     * @param sessionDescription
     * @return
     * @throws SdpParseException
     */
    SessionDescription createSessionDescription(String sessionDescription) throws SdpParseException;

    /**
     *
     * @return
     */
    String getProtocolVersion();

    /**
     * Sends a Association event MEGACO commands to the MEGACO stack.
     *
     * @param jainMegacoAssocEvent
     */
    @Override
    void sendMegacoAssocEvent(AssociationEvent jainMegacoAssocEvent);

    void sendMegacoAssocEvent(AssociationEvent... jainMegacoAssocEvent);

    /**
     * Sends a Command event MEGACO commands and responses into the MEGACO
     * stack.
     *
     * @param jainMegacoCmdEvent
     * @return An integer value corresponding to the transaction handle
     * identifier.
     */
    @Override
    int sendMegacoCmdEvent(CommandEvent jainMegacoCmdEvent);

    /**
     * Sends a Command event MEGACO commands and responses into the MEGACO
     * stack. Setting isFirst command in action and isLast command in
     * transaction
     *
     * @param jainMegacoCmdEvent
     * @return An integer value corresponding to the transaction handle
     * identifier.
     */
    int[] sendMegacoCmdEvent(CommandEvent... jainMegacoCmdEvent);

    /**
     *
     * @param id
     * @return
     */
    int generateContextId(int exchangeId, int assocHandle);

    int getExchangeId();

    AssociationConfigReq newAssociationConfigReq(UserId userId) throws NonExistentAssocException;

    AssociationConfigResp newAssociationConfigResp(AssociationConfigReq request);

    AssociationInd newAssociationInd(UserId userId, AssocIndReason reason) throws NonExistentAssocException;

    ContextInfoReq newContextInfoReq(CreateTxnResp response);

    ContextInfoResp newContextInfoResp(ContextInfoReq request);

    CreateAssocReq newCreateAssocReq(UserId userId) throws NonExistentAssocException;

    CreateAssocResp newCreateAssocResp(CreateAssocReq request);

    CreateTxnReq newCreateTxnReq(UserId userId) throws NonExistentAssocException;

    CreateTxnResp newCreateTxnResp(CreateTxnReq request);

    DeleteAssocReq newDeleteAssocReq(UserId userId) throws NonExistentAssocException;

    DeleteAssocResp newDeleteAssocResp(DeleteAssocReq request);

    DeleteTxnReq newDeleteTxnReq(UserId userId, CreateTxnResp response) throws NonExistentAssocException;

    DeleteTxnResp newDeleteTxnResp(DeleteTxnReq request);

    CommandReq newMegacoCmdReqAdd(CreateTxnResp response);

    CommandReq newMegacoCmdReqAuditCap(CreateTxnResp response);

    CommandReq newMegacoCmdReqAuditVal(CreateTxnResp response);

    CommandReq newMegacoCmdReqModify(CreateTxnResp response);

    CommandReq newMegacoCmdReqMove(CreateTxnResp response);

    CommandReq newMegacoCmdReqNotify(CreateTxnResp response);

    CommandReq newMegacoCmdReqSrvChng(CreateTxnResp response);

    CommandReq newMegacoCmdReqSubtract(CreateTxnResp response);

    CommandResp newMegacoCmdRespAdd(CommandReq request);

    CommandResp newMegacoCmdRespAuditCap(CommandReq request);

    CommandResp newMegacoCmdRespAuditVal(CommandReq request);

    CommandResp newMegacoCmdRespModify(CommandReq request);

    CommandResp newMegacoCmdRespMove(CommandReq request);

    CommandResp newMegacoCmdRespNotify(CommandReq request);

    CommandResp newMegacoCmdRespSrvChng(CommandReq request);

    CommandResp newMegacoCmdRespSubtract(CommandReq request);

    ModifyAssocReq newModifyAssocReq(UserId userId) throws NonExistentAssocException;

    ModifyAssocResp newModifyAssocResp(ModifyAssocReq request);
}