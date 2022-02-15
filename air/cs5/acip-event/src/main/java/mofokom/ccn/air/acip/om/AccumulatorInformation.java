	
        package mofokom.ccn.air.acip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.7.1.1
        *
        **/
        @Generated(value={})
        public interface AccumulatorInformation extends Marker,Serializable {
        /**
        *   Section Reference 6.4
        **/
        public java.lang.Integer getAccumulatorID(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.4
        **/
        public void setAccumulatorID(java.lang.Integer accumulatorID);
        /**
        *   Section Reference 6.7
        **/
        public java.lang.Integer getAccumulatorValueRelative(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.7
        **/
        public void setAccumulatorValueRelative(java.lang.Integer accumulatorValueRelative);
        /**
        *   Section Reference 6.6
        **/
        public java.lang.Integer getAccumulatorValueAbsolute(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.6
        **/
        public void setAccumulatorValueAbsolute(java.lang.Integer accumulatorValueAbsolute);
        /**
        *   Section Reference 6.5
        **/
        public java.util.Calendar getAccumulatorStartDate(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.5
        **/
        public void setAccumulatorStartDate(java.util.Calendar accumulatorStartDate);
        }
