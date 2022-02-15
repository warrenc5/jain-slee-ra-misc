/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.megaco.MegacoStack;
import javax.megaco.NonExistentAssocException;
import javax.megaco.UserId;
import javax.megaco.association.*;
import javax.megaco.message.*;
import mofokom.megaco.resource.MegaCoResourceAdaptorInterface;
import mofokom.resource.mina.common.AbstractMinaResourceAdaptor;

/**
 *
 * @author wozza
 */
public abstract class ObjectFactory extends AbstractMinaResourceAdaptor<MegaCoActivityImpl, Serializable, MegaCoResourceAdaptorUsageParameters> implements MegaCoResourceAdaptorInterface, MegacoStack
{

    public ObjectFactory() {
    }

    @Override
    public AssociationConfigReq newAssociationConfigReq(UserId userId) throws NonExistentAssocException {
        AssociationConfigReq result = new AssociationConfigReq(raContext.getEntityName(), this.getAssocHandle(userId));
        super.startNewActivitySuspended(null);
        return result;
    }

    @Override
    public AssociationConfigResp newAssociationConfigResp(AssociationConfigReq request) {
        return new AssociationConfigResp(raContext.getEntityName(), request.getAssocHandle());
    }

    @Override
    public AssociationInd newAssociationInd(UserId userId,AssocIndReason reason) throws NonExistentAssocException {
        return new AssociationInd(raContext.getEntityName(), this.getAssocHandle(userId), reason);
    }

    @Override
    public CreateAssocReq newCreateAssocReq(UserId userId) throws NonExistentAssocException {
        int associationHandle = this.getAssocHandle(userId);
        CreateAssocReq createAssocReq = new CreateAssocReq(raContext.getEntityName(), associationHandle);
        createAssocReq.setEndcodingFormat(EncodingFormat.TEXT); //TODO make dynamic
        return createAssocReq;
    }

    @Override
    public CreateAssocResp newCreateAssocResp(CreateAssocReq request) {
        return new CreateAssocResp(raContext.getEntityName(), request.getAssocHandle());
    }

    @Override
    public CreateTxnReq newCreateTxnReq(UserId userId) throws NonExistentAssocException {
        return new CreateTxnReq(raContext.getEntityName(), getAssocHandle(userId),  getExchangeId());
    }

    @Override
    public CreateTxnResp newCreateTxnResp(CreateTxnReq request) {
        return new CreateTxnResp(raContext.getEntityName(), request.getAssocHandle(), request.getExchangeId());
    }

    @Override
    public DeleteAssocReq newDeleteAssocReq(UserId userId) throws NonExistentAssocException {
        return new DeleteAssocReq(raContext.getEntityName(),this.getAssocHandle(userId));
    }

    @Override
    public DeleteAssocResp newDeleteAssocResp(DeleteAssocReq request) {
        return new DeleteAssocResp(raContext.getEntityName(), request.getAssocHandle());
    }

    @Override
    public DeleteTxnReq newDeleteTxnReq(UserId userId,CreateTxnResp response) throws NonExistentAssocException {
        if(response ==null)
            throw new NonExistentAssocException();
        DeleteTxnReq deleteTxnReq = new DeleteTxnReq(raContext.getEntityName(), this.getAssocHandle(userId));
        deleteTxnReq.setTxnHandle(response.getTxnHandle());
        return deleteTxnReq;
    }

    @Override
    public DeleteTxnResp newDeleteTxnResp(DeleteTxnReq request) {
        return new DeleteTxnResp(raContext.getEntityName(), request.getAssocHandle(),request.getTxnHandle());
    }

    @Override
    public ModifyAssocReq newModifyAssocReq(UserId userId) throws NonExistentAssocException {
        return new ModifyAssocReq(raContext.getEntityName(), this.getAssocHandle(userId));
    }

    @Override
    public ModifyAssocResp newModifyAssocResp(ModifyAssocReq request) {
        return new ModifyAssocResp(raContext.getEntityName(), request.getAssocHandle());
    }

    @Override
    public CommandReq newMegacoCmdReqAdd(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqAdd(raContext.getEntityName(), response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true);
    }

    @Override
    public CommandReq newMegacoCmdReqAuditCap(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqAuditCap(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true);
    }

    @Override
    public CommandReq newMegacoCmdReqAuditVal(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqAuditVal(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true);
    }

    @Override
    public CommandReq newMegacoCmdReqModify(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqModify(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true); 
    }

    @Override
    public CommandReq newMegacoCmdReqMove(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqMove(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true);
    }

    @Override
    public CommandReq newMegacoCmdReqNotify(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqNotify(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true);
    }

    @Override
    public CommandReq newMegacoCmdReqSrvChng(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqSrvChng(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true); 
    }

    @Override
    public CommandReq newMegacoCmdReqSubtract(CreateTxnResp response) {
        return CommandReq.MegacoCmdReqSubtract(raContext.getEntityName(),response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(),response.getTxnHandle()), false, true); 
    }

    @Override
    public CommandResp newMegacoCmdRespAdd(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_ADD_REQ)
            throw new IllegalArgumentException("Argument must be add CommandRequest");
        return CommandResp.MegacoCmdRespAdd(raContext.getEntityName(), request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespAuditCap(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_AUDIT_CAP_REQ)
            throw new IllegalArgumentException("Argument must be AuditCap CommandRequest");
        return CommandResp.MegacoCmdRespAuditCap(raContext.getEntityName(), request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespAuditVal(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_AUDIT_VAL_REQ)
            throw new IllegalArgumentException("Argument must be AuditVal CommandRequest");
        return CommandResp.MegacoCmdRespAuditVal(raContext.getEntityName(), request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespModify(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_MODIFY_REQ)
            throw new IllegalArgumentException("Argument must be Modify CommandRequest");
        return CommandResp.MegacoCmdRespModify(raContext.getEntityName(), request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespMove(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_MOVE_REQ)
            throw new IllegalArgumentException("Argument must be Move CommandRequest");
        return CommandResp.MegacoCmdRespMove(raContext.getEntityName(), request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespNotify(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_NOTIFY_REQ)
            throw new IllegalArgumentException("Argument must be Notify CommandRequest");
        return CommandResp.MegacoCmdRespNotify(raContext.getEntityName(),request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespSrvChng(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_SERVICE_CHANGE_REQ)
            throw new IllegalArgumentException("Argument must be Service Change CommandRequest");
        return CommandResp.MegacoCmdRespSrvChng(raContext.getEntityName(),request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public CommandResp newMegacoCmdRespSubtract(CommandReq request) {
        if(request.getCommandIdentifier()!=CmdRequestType.M_SUBTRACT_REQ)
            throw new IllegalArgumentException("Argument must be Subtract CommandRequest");
        return CommandResp.MegacoCmdRespSubtract(raContext.getEntityName(),request.getAssocHandle(),request.getTxnHandle(),request.getActionHandle(),true,false);
    }

    @Override
    public ContextInfoReq newContextInfoReq(CreateTxnResp response) {
        return new ContextInfoReq(raContext.getEntityName(), response.getAssocHandle(), response.getTxnHandle(), generateActionId(response.getAssocHandle(), response.getTxnHandle()), false);
    }

    @Override
    public ContextInfoResp newContextInfoResp(ContextInfoReq request) {
        return new ContextInfoResp(raContext.getEntityName(), request.getAssocHandle(), request.getTxnHandle(), request.getActionHandle() , false);
    }

    public int generateContextId(int exchangeId, int assocHandle) {
        return contextSequence.getAndIncrement();
    }

    protected int generateTransactionId(int assocHandle) {
        return transactionSequence.getAndIncrement();
    }

    protected int generateActionId(int assocHandle, int txnHandle) {
        return actionSequence.getAndIncrement();
    }

    AtomicInteger associationSequence,actionSequence,transactionSequence,contextSequence; 
    protected int generateAssociationId(UserId userId) {
        return associationSequence.getAndIncrement();
    }

    @Override
    public abstract int getExchangeId() ;

}
