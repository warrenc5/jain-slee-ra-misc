/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl;

import java.util.Arrays;
import java.util.Collection;
import javax.slee.EventTypeID;
import javax.slee.UnrecognizedEventException;
import javax.slee.resource.FireableEventType;

/**
 *
 * @author wozza
 */
public abstract class EventSet extends ObjectFactory {

    protected FireableEventType eventTypeTransactionPending, eventTypeTransactionAcknowledge, eventTypeCommandEvent, eventTypeCommandReq, eventTypeCommandResp, eventTypeAddCommandReq, eventTypeAddCommandResp, eventTypeMoveCommandReq, eventTypeMoveCommandResp, eventTypeModifyCommandReq, eventTypeModifyCommandResp, eventTypeSrvChangeCommandReq, eventTypeSrvChangeCommandResp, eventTypeNotifyCommandReq, eventTypeNotifyCommandResp, eventTypeAuditValCommandReq, eventTypeAuditValCommandResp, eventTypeAuditCapCommandReq, eventTypeAuditCapCommandResp, eventTypeSubtractCommandReq, eventTypeSubtractCommandResp, eventTypeContextInfoReq, eventTypeContextInfoResp, eventTypevent, eventTypeCreateAssocReq, eventTypeCreateAssocResp, eventTypeDeleteAssocReq, eventTypeDeleteAssocResp, eventTypeModifyAssocReq, eventTypeModifyAssocResp, eventTypeAssociationInd, eventTypeAssociationConfigReq, eventTypeAssociationConfigResp, eventTypeDeleteTxnReq, eventTypeDeleteTxnResp, eventTypeCreateTxnReq, eventTypeCreateTxnResp, eventTypeAnalogLineSPkgAnalogLineSFlashEvt, eventTypeAnalogLineSPkgAnalogLineSOffEvt, eventTypeAnalogLineSPkgAnalogLineSOnEvt, eventTypeContinuityPkgContComplEvt, eventTypeCPToneDetPkgCPToneDetBtEvt, eventTypeCPToneDetPkgCPToneDetCrEvt, eventTypeCPToneDetPkgCPToneDetCtEvt, eventTypeCPToneDetPkgCPToneDetCwtEvt, eventTypeCPToneDetPkgCPToneDetDtEvt, eventTypeCPToneDetPkgCPToneDetPtEvt, eventTypeCPToneDetPkgCPToneDetRtEvt, eventTypeCPToneDetPkgCPToneDetSitEvt, eventTypeCPToneDetPkgCPToneDetWtEvt, eventTypeDTMFDetPkgDTMFDetCeEvt, eventTypeGenericPkgGenCauseEvent, eventTypeGenericPkgGenSigComplEvent, eventTypeNetworkPkgNetworkNetfailEvt, eventTypeNetworkPkgNetworkQualertEvt, eventTypeRTPPkgRTPPltransEvt, eventTypeToneDetPkgToneEtdEvent, eventTypeToneDetPkgToneLtdEvent, eventTypeToneDetPkgToneStdEvent;

    public EventSet() {
    }

    @Override
    public Collection<EventTypeID> getEventTypeSet() throws UnrecognizedEventException {
        eventTypeTransactionAcknowledge = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransactionAcknowledge", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeTransactionPending = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("TransactionPending", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));

        eventTypeCommandEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CommandEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAddCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AddCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAddCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AddCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeMoveCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MoveCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeMoveCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("MoveCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeModifyCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ModifyCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeModifyCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ModifyCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeSrvChangeCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("SrvChangeCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeSrvChangeCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("SrvChangeCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeNotifyCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NotifyCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeNotifyCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NotifyCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAuditValCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditValCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAuditValCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditValCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAuditCapCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditCapCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAuditCapCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AuditCapCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeSubtractCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("SubtractCommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));

        eventTypeSubtractCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("SubtractCommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));

        eventTypeCommandReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CommandReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCommandResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CommandResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));

        eventTypeContextInfoReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ContextInfoReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeContextInfoResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ContextInfoResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypevent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AssociationEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCreateAssocReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CreateAssocReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCreateAssocResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CreateAssocResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeDeleteAssocReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DeleteAssocReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeDeleteAssocResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DeleteAssocResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeModifyAssocReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ModifyAssocReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeModifyAssocResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ModifyAssocResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAssociationInd = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AssociationInd", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAssociationConfigReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AssociationConfigReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAssociationConfigResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AssociationConfigResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeDeleteTxnReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DeleteTxnReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeDeleteTxnResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DeleteTxnResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCreateTxnReq = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CreateTxnReq", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCreateTxnResp = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CreateTxnResp", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAnalogLineSPkgAnalogLineSFlashEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AnalogLineSPkg.AnalogLineSFlashEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAnalogLineSPkgAnalogLineSOffEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AnalogLineSPkg.AnalogLineSOffEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeAnalogLineSPkgAnalogLineSOnEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("AnalogLineSPkg.AnalogLineSOnEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeContinuityPkgContComplEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ContinuityPkg.ContComplEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetBtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetBtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetCrEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetCrEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetCtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetCtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetCwtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetCwtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetDtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetDtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetPtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetPtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetRtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetRtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetSitEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetSitEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeCPToneDetPkgCPToneDetWtEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("CPToneDetPkg.CPToneDetWtEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeDTMFDetPkgDTMFDetCeEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("DTMFDetPkg.DTMFDetCeEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeGenericPkgGenCauseEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("GenericPkg.GenCauseEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeGenericPkgGenSigComplEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("GenericPkg.GenSigComplEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeNetworkPkgNetworkNetfailEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NetworkPkg.NetworkNetfailEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeNetworkPkgNetworkQualertEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("NetworkPkg.NetworkQualertEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeRTPPkgRTPPltransEvt = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("RTPPkg.RTPPltransEvt", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeToneDetPkgToneEtdEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ToneDetPkg.ToneEtdEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeToneDetPkgToneLtdEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ToneDetPkg.ToneLtdEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        eventTypeToneDetPkgToneStdEvent = super.raContext.getEventLookupFacility().getFireableEventType(new EventTypeID("ToneDetPkg.ToneStdEvent", super.raContext.getResourceAdaptorTypes()[0].getVendor(), super.raContext.getResourceAdaptorTypes()[0].getVersion()));
        return Arrays.asList(
                eventTypeTransactionAcknowledge.getEventType(),
                eventTypeTransactionPending.getEventType(),
                eventTypeCommandEvent.getEventType(),
                eventTypeCommandReq.getEventType(),
                eventTypeCommandResp.getEventType(),
                eventTypeAddCommandReq.getEventType(),
                eventTypeAddCommandResp.getEventType(),
                eventTypeMoveCommandReq.getEventType(),
                eventTypeMoveCommandResp.getEventType(),
                eventTypeModifyCommandReq.getEventType(),
                eventTypeModifyCommandResp.getEventType(),
                eventTypeSrvChangeCommandReq.getEventType(),
                eventTypeSrvChangeCommandResp.getEventType(),
                eventTypeNotifyCommandReq.getEventType(),
                eventTypeNotifyCommandResp.getEventType(),
                eventTypeAuditValCommandReq.getEventType(),
                eventTypeAuditValCommandResp.getEventType(),
                eventTypeAuditCapCommandReq.getEventType(),
                eventTypeAuditCapCommandResp.getEventType(),
                eventTypeSubtractCommandReq.getEventType(),
                eventTypeSubtractCommandResp.getEventType(),
                eventTypeContextInfoReq.getEventType(),
                eventTypeContextInfoResp.getEventType(),
                eventTypevent.getEventType(),
                eventTypeCreateAssocReq.getEventType(),
                eventTypeCreateAssocResp.getEventType(),
                eventTypeDeleteAssocReq.getEventType(),
                eventTypeDeleteAssocResp.getEventType(),
                eventTypeModifyAssocReq.getEventType(),
                eventTypeModifyAssocResp.getEventType(),
                eventTypeAssociationInd.getEventType(),
                eventTypeAssociationConfigReq.getEventType(),
                eventTypeAssociationConfigResp.getEventType(),
                eventTypeDeleteTxnReq.getEventType(),
                eventTypeDeleteTxnResp.getEventType(),
                eventTypeCreateTxnReq.getEventType(),
                eventTypeCreateTxnResp.getEventType(),
                eventTypeAnalogLineSPkgAnalogLineSFlashEvt.getEventType(),
                eventTypeAnalogLineSPkgAnalogLineSOffEvt.getEventType(),
                eventTypeAnalogLineSPkgAnalogLineSOnEvt.getEventType(),
                eventTypeContinuityPkgContComplEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetBtEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetCrEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetCtEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetCwtEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetDtEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetPtEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetRtEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetSitEvt.getEventType(),
                eventTypeCPToneDetPkgCPToneDetWtEvt.getEventType(),
                eventTypeDTMFDetPkgDTMFDetCeEvt.getEventType(),
                eventTypeGenericPkgGenCauseEvent.getEventType(),
                eventTypeGenericPkgGenSigComplEvent.getEventType(),
                eventTypeNetworkPkgNetworkNetfailEvt.getEventType(),
                eventTypeNetworkPkgNetworkQualertEvt.getEventType(),
                eventTypeRTPPkgRTPPltransEvt.getEventType(),
                eventTypeToneDetPkgToneEtdEvent.getEventType(),
                eventTypeToneDetPkgToneLtdEvent.getEventType(),
                eventTypeToneDetPkgToneStdEvent.getEventType());
    }
}
