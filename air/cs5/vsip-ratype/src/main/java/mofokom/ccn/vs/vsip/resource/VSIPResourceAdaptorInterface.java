          package mofokom.ccn.vs.vsip.resource;
          import mofokom.ccn.*;
          import mofokom.ccn.vs.vsip.om.*;
          import javax.annotation.Generated;
          import java.io.IOException;
          @Generated(value={})
        public interface VSIPResourceAdaptorInterface {
          public VSIPObjectFactory getVSIPObjectFactory();
        public VSIPActivity sendGetVoucherDetailsMessage(GetVoucherDetails getVoucherDetails) throws java.io.IOException ;
        public VSIPActivity sendGetVoucherHistoryMessage(GetVoucherHistory getVoucherHistory) throws java.io.IOException ;
        public VSIPActivity sendUpdateVoucherStateMessage(UpdateVoucherState updateVoucherState) throws java.io.IOException ;
        public VSIPActivity sendLoadVoucherCheckMessage(LoadVoucherCheck loadVoucherCheck) throws java.io.IOException ;
        public VSIPActivity sendGenerateVoucherMessage(GenerateVoucher generateVoucher) throws java.io.IOException ;
        public VSIPActivity sendGetGenerateVoucherTaskInfoMessage(GetGenerateVoucherTaskInfo getGenerateVoucherTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendLoadVoucherBatchFileMessage(LoadVoucherBatchFile loadVoucherBatchFile) throws java.io.IOException ;
        public VSIPActivity sendGetLoadVoucherBatchFileTaskInfoMessage(GetLoadVoucherBatchFileTaskInfo getLoadVoucherBatchFileTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendGetVoucherBatchFilesListMessage(GetVoucherBatchFilesList getVoucherBatchFilesList) throws java.io.IOException ;
        public VSIPActivity sendChangeVoucherStateMessage(ChangeVoucherState changeVoucherState) throws java.io.IOException ;
        public VSIPActivity sendGetChangeVoucherStateTaskInfoMessage(GetChangeVoucherStateTaskInfo getChangeVoucherStateTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendPurgeVouchersMessage(PurgeVouchers purgeVouchers) throws java.io.IOException ;
        public VSIPActivity sendGetPurgeVouchersTaskInfoMessage(GetPurgeVouchersTaskInfo getPurgeVouchersTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendGenerateVoucherDetailsReportMessage(GenerateVoucherDetailsReport generateVoucherDetailsReport) throws java.io.IOException ;
        public VSIPActivity sendGetGenerateVoucherDetailsReportTaskInfoMessage(GetGenerateVoucherDetailsReportTaskInfo getGenerateVoucherDetailsReportTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendGenerateVoucherDistributionReportMessage(GenerateVoucherDistributionReport generateVoucherDistributionReport) throws java.io.IOException ;
        public VSIPActivity sendGetGenerateVoucherDistributionReportTaskInfoMessage(GetGenerateVoucherDistributionReportTaskInfo getGenerateVoucherDistributionReportTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendGenerateVoucherUsageReportMessage(GenerateVoucherUsageReport generateVoucherUsageReport) throws java.io.IOException ;
        public VSIPActivity sendGetGenerateVoucherUsageReportTaskInfoMessage(GetGenerateVoucherUsageReportTaskInfo getGenerateVoucherUsageReportTaskInfo) throws java.io.IOException ;
        public VSIPActivity sendDeleteTaskMessage(DeleteTask deleteTask) throws java.io.IOException ;
        public VSIPActivity sendReserveVoucherMessage(ReserveVoucher reserveVoucher) throws java.io.IOException ;
        public VSIPActivity sendEndReservationMessage(EndReservation endReservation) throws java.io.IOException ;
        }
