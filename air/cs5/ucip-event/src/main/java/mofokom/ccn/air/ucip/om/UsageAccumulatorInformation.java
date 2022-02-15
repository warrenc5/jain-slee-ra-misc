	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.10.2.6
        *
        **/
        @Generated(value={})
        public interface UsageAccumulatorInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.7
        **/
        public java.lang.Integer getAccumulatorID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.7
        **/
        public void setAccumulatorID(java.lang.Integer accumulatorID);
        /**
        *   Section Reference 6.11
        **/
        public java.lang.Integer getAccumulatorValue(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.11
        **/
        public void setAccumulatorValue(java.lang.Integer accumulatorValue);
        }
