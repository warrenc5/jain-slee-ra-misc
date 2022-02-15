          package mofokom.ccn.vs.vsip.resource.impl;
          import mofokom.ccn.*;
          import mofokom.ccn.vs.vsip.resource.*;
          import mofokom.ccn.vs.vsip.om.impl.*;
          import mofokom.ccn.air.resource.impl.AbstractAIRResourceAdaptor;
          import mofokom.ccn.resource.ResourceAdaptorUsageParameters;
          import mofokom.ccn.impl.*;
          import mofokom.ccn.impl.xmlrpc.*;
          import mofokom.resource.common.AbstractTransaction;
          import javax.slee.EventTypeID;
          import java.util.Set;
          import java.util.HashSet;
          import java.util.Arrays;
          import mofokom.ccn.vs.vsip.om.*;
          import javax.annotation.Generated;
          import java.io.IOException;
          @Generated(value={})
          public class VSIPResourceAdaptor extends AbstractAIRResourceAdaptor  implements VSIPResourceAdaptorInterface {
            VSIPObjectFactory objFactory ;
            public VSIPObjectFactory getVSIPObjectFactory(){
              if (objFactory == null){
                objFactory = new VSIPObjectFactoryImpl();
                }
              return objFactory;
            }
            @Override
            public AbstractTransaction createActivity(Object o) {
              return new VSIPActivityImpl((Codeable)o,this.hashCode(),sequence.getNextSequenceNumber()); 
            }
            @Override
            public Object getResourceAdaptorInterface(String className) {
              return this;
            }
            private VSIPActivity sendMessage(VSIPResourceAdaptorUsageParameters usage,long then,Marker codeable) throws IOException {
              boolean e = false;
              try {
                VSIPActivityImpl txn = (VSIPActivityImpl)super.sendRequest (codeable);
                return txn;
              } catch (Exception ex) {
              e = true;
                throw new IOException(ex);
            } finally {
              if(e){
              usage.incrementTxNOK(1L);
              usage.sampleLatencyTxNOK(System.currentTimeMillis()-then);
              }else {
              usage.incrementTxOK(1L);
              usage.sampleLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
            }
   @Override
    public Set<EventTypeID> getEventTypeSet() {
        Set set = new HashSet();
        set.addAll(Arrays.asList(new EventTypeID[]{
        }));
        return set;
    }
          @Override
        public VSIPActivity sendGetVoucherDetailsMessage(GetVoucherDetails getVoucherDetails) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getVoucherDetails);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetVoucherDetailsTxNOK(1L);
              usage.sampleGetVoucherDetailsLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetVoucherDetailsTxOK(1L);
              usage.sampleGetVoucherDetailsLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetVoucherHistoryMessage(GetVoucherHistory getVoucherHistory) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getVoucherHistory);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetVoucherHistoryTxNOK(1L);
              usage.sampleGetVoucherHistoryLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetVoucherHistoryTxOK(1L);
              usage.sampleGetVoucherHistoryLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendUpdateVoucherStateMessage(UpdateVoucherState updateVoucherState) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,updateVoucherState);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementUpdateVoucherStateTxNOK(1L);
              usage.sampleUpdateVoucherStateLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementUpdateVoucherStateTxOK(1L);
              usage.sampleUpdateVoucherStateLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendLoadVoucherCheckMessage(LoadVoucherCheck loadVoucherCheck) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,loadVoucherCheck);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementLoadVoucherCheckTxNOK(1L);
              usage.sampleLoadVoucherCheckLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementLoadVoucherCheckTxOK(1L);
              usage.sampleLoadVoucherCheckLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGenerateVoucherMessage(GenerateVoucher generateVoucher) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,generateVoucher);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGenerateVoucherTxNOK(1L);
              usage.sampleGenerateVoucherLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGenerateVoucherTxOK(1L);
              usage.sampleGenerateVoucherLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetGenerateVoucherTaskInfoMessage(GetGenerateVoucherTaskInfo getGenerateVoucherTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getGenerateVoucherTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetGenerateVoucherTaskInfoTxNOK(1L);
              usage.sampleGetGenerateVoucherTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetGenerateVoucherTaskInfoTxOK(1L);
              usage.sampleGetGenerateVoucherTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendLoadVoucherBatchFileMessage(LoadVoucherBatchFile loadVoucherBatchFile) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,loadVoucherBatchFile);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementLoadVoucherBatchFileTxNOK(1L);
              usage.sampleLoadVoucherBatchFileLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementLoadVoucherBatchFileTxOK(1L);
              usage.sampleLoadVoucherBatchFileLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetLoadVoucherBatchFileTaskInfoMessage(GetLoadVoucherBatchFileTaskInfo getLoadVoucherBatchFileTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getLoadVoucherBatchFileTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetLoadVoucherBatchFileTaskInfoTxNOK(1L);
              usage.sampleGetLoadVoucherBatchFileTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetLoadVoucherBatchFileTaskInfoTxOK(1L);
              usage.sampleGetLoadVoucherBatchFileTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetVoucherBatchFilesListMessage(GetVoucherBatchFilesList getVoucherBatchFilesList) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getVoucherBatchFilesList);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetVoucherBatchFilesListTxNOK(1L);
              usage.sampleGetVoucherBatchFilesListLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetVoucherBatchFilesListTxOK(1L);
              usage.sampleGetVoucherBatchFilesListLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendChangeVoucherStateMessage(ChangeVoucherState changeVoucherState) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,changeVoucherState);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementChangeVoucherStateTxNOK(1L);
              usage.sampleChangeVoucherStateLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementChangeVoucherStateTxOK(1L);
              usage.sampleChangeVoucherStateLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetChangeVoucherStateTaskInfoMessage(GetChangeVoucherStateTaskInfo getChangeVoucherStateTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getChangeVoucherStateTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetChangeVoucherStateTaskInfoTxNOK(1L);
              usage.sampleGetChangeVoucherStateTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetChangeVoucherStateTaskInfoTxOK(1L);
              usage.sampleGetChangeVoucherStateTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendPurgeVouchersMessage(PurgeVouchers purgeVouchers) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,purgeVouchers);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementPurgeVouchersTxNOK(1L);
              usage.samplePurgeVouchersLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementPurgeVouchersTxOK(1L);
              usage.samplePurgeVouchersLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetPurgeVouchersTaskInfoMessage(GetPurgeVouchersTaskInfo getPurgeVouchersTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getPurgeVouchersTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetPurgeVouchersTaskInfoTxNOK(1L);
              usage.sampleGetPurgeVouchersTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetPurgeVouchersTaskInfoTxOK(1L);
              usage.sampleGetPurgeVouchersTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGenerateVoucherDetailsReportMessage(GenerateVoucherDetailsReport generateVoucherDetailsReport) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,generateVoucherDetailsReport);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGenerateVoucherDetailsReportTxNOK(1L);
              usage.sampleGenerateVoucherDetailsReportLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGenerateVoucherDetailsReportTxOK(1L);
              usage.sampleGenerateVoucherDetailsReportLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetGenerateVoucherDetailsReportTaskInfoMessage(GetGenerateVoucherDetailsReportTaskInfo getGenerateVoucherDetailsReportTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getGenerateVoucherDetailsReportTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetGenerateVoucherDetailsReportTaskInfoTxNOK(1L);
              usage.sampleGetGenerateVoucherDetailsReportTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetGenerateVoucherDetailsReportTaskInfoTxOK(1L);
              usage.sampleGetGenerateVoucherDetailsReportTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGenerateVoucherDistributionReportMessage(GenerateVoucherDistributionReport generateVoucherDistributionReport) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,generateVoucherDistributionReport);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGenerateVoucherDistributionReportTxNOK(1L);
              usage.sampleGenerateVoucherDistributionReportLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGenerateVoucherDistributionReportTxOK(1L);
              usage.sampleGenerateVoucherDistributionReportLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetGenerateVoucherDistributionReportTaskInfoMessage(GetGenerateVoucherDistributionReportTaskInfo getGenerateVoucherDistributionReportTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getGenerateVoucherDistributionReportTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetGenerateVoucherDistributionReportTaskInfoTxNOK(1L);
              usage.sampleGetGenerateVoucherDistributionReportTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetGenerateVoucherDistributionReportTaskInfoTxOK(1L);
              usage.sampleGetGenerateVoucherDistributionReportTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGenerateVoucherUsageReportMessage(GenerateVoucherUsageReport generateVoucherUsageReport) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,generateVoucherUsageReport);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGenerateVoucherUsageReportTxNOK(1L);
              usage.sampleGenerateVoucherUsageReportLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGenerateVoucherUsageReportTxOK(1L);
              usage.sampleGenerateVoucherUsageReportLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendGetGenerateVoucherUsageReportTaskInfoMessage(GetGenerateVoucherUsageReportTaskInfo getGenerateVoucherUsageReportTaskInfo) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,getGenerateVoucherUsageReportTaskInfo);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementGetGenerateVoucherUsageReportTaskInfoTxNOK(1L);
              usage.sampleGetGenerateVoucherUsageReportTaskInfoLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementGetGenerateVoucherUsageReportTaskInfoTxOK(1L);
              usage.sampleGetGenerateVoucherUsageReportTaskInfoLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendDeleteTaskMessage(DeleteTask deleteTask) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,deleteTask);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementDeleteTaskTxNOK(1L);
              usage.sampleDeleteTaskLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementDeleteTaskTxOK(1L);
              usage.sampleDeleteTaskLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendReserveVoucherMessage(ReserveVoucher reserveVoucher) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,reserveVoucher);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementReserveVoucherTxNOK(1L);
              usage.sampleReserveVoucherLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementReserveVoucherTxOK(1L);
              usage.sampleReserveVoucherLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
          @Override
        public VSIPActivity sendEndReservationMessage(EndReservation endReservation) throws java.io.IOException  {
          long then = System.currentTimeMillis();
VSIPResourceAdaptorUsageParameters usage = (VSIPResourceAdaptorUsageParameters) super.raContext.getDefaultUsageParameterSet();
              boolean e = false;
          try{
              return sendMessage(usage,then,endReservation);
            }catch (IOException x) {
              e = true;
              throw x;
            } finally {
              if(e){
              usage.incrementEndReservationTxNOK(1L);
              usage.sampleEndReservationLatencyTxNOK(System.currentTimeMillis()-then);
              }else{
              usage.incrementEndReservationTxOK(1L);
              usage.sampleEndReservationLatencyTxOK(System.currentTimeMillis()-then);
              }
            }
          }
        }
