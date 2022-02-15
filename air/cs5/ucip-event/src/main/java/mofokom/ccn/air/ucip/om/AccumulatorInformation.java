	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.3.2.1
        *
        **/
        @Generated(value={})
        public interface AccumulatorInformation extends Marker,Serializable {
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
        /**
        *   Section Reference 6.10
        **/
        public java.util.Calendar getAccumulatorStartDate(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.10
        **/
        public void setAccumulatorStartDate(java.util.Calendar accumulatorStartDate);
        /**
        *   Section Reference 6.6
        **/
        public java.util.Calendar getAccumulatorEndDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.6
        **/
        public void setAccumulatorEndDate(java.util.Calendar accumulatorEndDate);
        }
