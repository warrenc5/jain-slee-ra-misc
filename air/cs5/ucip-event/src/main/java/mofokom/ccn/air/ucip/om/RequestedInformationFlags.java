	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.13
        *
        **/
        @Generated(value={})
        public interface RequestedInformationFlags extends Marker,Serializable {
        /**
        *   Section Reference 6.79
        **/
        public java.lang.Boolean getRequestMasterAccountBalanceFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.79
        **/
        public void setRequestMasterAccountBalanceFlag(java.lang.Boolean requestMasterAccountBalanceFlag);
        /**
        *   Section Reference 6.17
        **/
        public java.lang.Boolean getAllowedServiceClassChangeDateFlag(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.17
        **/
        public void setAllowedServiceClassChangeDateFlag(java.lang.Boolean allowedServiceClassChangeDateFlag);
        }
