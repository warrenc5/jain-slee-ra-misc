	
        package mofokom.ccn.vs.vsip.resource.impl;
          import mofokom.ccn.vs.vsip.resource.*;
          import mofokom.ccn.vs.vsip.om.impl.*;
          import mofokom.ccn.air.resource.impl.ObjectFactory;
          import mofokom.ccn.vs.vsip.om.*;
          import javax.annotation.Generated;
        @Generated(value={})
        class VSIPObjectFactoryImpl implements VSIPObjectFactory, ObjectFactory {
          @Override
        public Fault createFault()  {
            return new FaultImpl();
          }
          @Override
        public GetVoucherDetails createGetVoucherDetails()  {
            return new GetVoucherDetailsImpl();
          }
          @Override
        public GetVoucherHistory createGetVoucherHistory()  {
            return new GetVoucherHistoryImpl();
          }
          @Override
        public UpdateVoucherState createUpdateVoucherState()  {
            return new UpdateVoucherStateImpl();
          }
          @Override
        public LoadVoucherCheck createLoadVoucherCheck()  {
            return new LoadVoucherCheckImpl();
          }
          @Override
        public GenerateVoucher createGenerateVoucher()  {
            return new GenerateVoucherImpl();
          }
          @Override
        public GetGenerateVoucherTaskInfo createGetGenerateVoucherTaskInfo()  {
            return new GetGenerateVoucherTaskInfoImpl();
          }
          @Override
        public LoadVoucherBatchFile createLoadVoucherBatchFile()  {
            return new LoadVoucherBatchFileImpl();
          }
          @Override
        public GetLoadVoucherBatchFileTaskInfo createGetLoadVoucherBatchFileTaskInfo()  {
            return new GetLoadVoucherBatchFileTaskInfoImpl();
          }
          @Override
        public GetVoucherBatchFilesList createGetVoucherBatchFilesList()  {
            return new GetVoucherBatchFilesListImpl();
          }
          @Override
        public ChangeVoucherState createChangeVoucherState()  {
            return new ChangeVoucherStateImpl();
          }
          @Override
        public GetChangeVoucherStateTaskInfo createGetChangeVoucherStateTaskInfo()  {
            return new GetChangeVoucherStateTaskInfoImpl();
          }
          @Override
        public PurgeVouchers createPurgeVouchers()  {
            return new PurgeVouchersImpl();
          }
          @Override
        public GetPurgeVouchersTaskInfo createGetPurgeVouchersTaskInfo()  {
            return new GetPurgeVouchersTaskInfoImpl();
          }
          @Override
        public GenerateVoucherDetailsReport createGenerateVoucherDetailsReport()  {
            return new GenerateVoucherDetailsReportImpl();
          }
          @Override
        public GetGenerateVoucherDetailsReportTaskInfo createGetGenerateVoucherDetailsReportTaskInfo()  {
            return new GetGenerateVoucherDetailsReportTaskInfoImpl();
          }
          @Override
        public GenerateVoucherDistributionReport createGenerateVoucherDistributionReport()  {
            return new GenerateVoucherDistributionReportImpl();
          }
          @Override
        public GetGenerateVoucherDistributionReportTaskInfo createGetGenerateVoucherDistributionReportTaskInfo()  {
            return new GetGenerateVoucherDistributionReportTaskInfoImpl();
          }
          @Override
        public GenerateVoucherUsageReport createGenerateVoucherUsageReport()  {
            return new GenerateVoucherUsageReportImpl();
          }
          @Override
        public GetGenerateVoucherUsageReportTaskInfo createGetGenerateVoucherUsageReportTaskInfo()  {
            return new GetGenerateVoucherUsageReportTaskInfoImpl();
          }
          @Override
        public DeleteTask createDeleteTask()  {
            return new DeleteTaskImpl();
          }
          @Override
        public ReserveVoucher createReserveVoucher()  {
            return new ReserveVoucherImpl();
          }
          @Override
        public EndReservation createEndReservation()  {
            return new EndReservationImpl();
          }
        }
