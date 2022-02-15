	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.2
        *
        **/
        @Generated(value={})
        public interface AccumulatorSelection extends Marker,Serializable {
        /**
        *   Section Reference 6.8
        **/
        public java.lang.Integer getAccumulatorIDFirst(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.8
        **/
        public void setAccumulatorIDFirst(java.lang.Integer accumulatorIDFirst);
        /**
        *   Section Reference 6.9
        **/
        public java.lang.Integer getAccumulatorIDLast(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.9
        **/
        public void setAccumulatorIDLast(java.lang.Integer accumulatorIDLast);
        }
