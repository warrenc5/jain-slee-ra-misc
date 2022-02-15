	
        package mofokom.ccn.air.ucip.om;
        import mofokom.ccn.*;
        import java.util.Date;
        import java.util.List;
        import java.util.ArrayList;
        import java.io.Serializable;
        import javax.annotation.Generated;
        /**
        *   Section Reference 5.16.9
        *
        **/
        @Generated(value={})
        public interface DedicatedAccountSelection extends Marker,Serializable {
        /**
        *   Section Reference 6.28
        **/
        public java.lang.Integer getDedicatedAccountIDFirst(); 
        /**
        *  
        *    Mandatory
         *   Section Reference 6.28
        **/
        public void setDedicatedAccountIDFirst(java.lang.Integer dedicatedAccountIDFirst);
        /**
        *   Section Reference 6.29
        **/
        public java.lang.Integer getDedicatedAccountIDLast(); 
        /**
        *  
        *    Optional
         *   Section Reference 6.29
        **/
        public void setDedicatedAccountIDLast(java.lang.Integer dedicatedAccountIDLast);
        }
