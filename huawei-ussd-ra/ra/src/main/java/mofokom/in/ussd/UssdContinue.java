        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * UssdContinue can be sent either by a mobile station or by the USSD service application to continue a USSD session with the USSDC.
*
The following table defines the syntax of UssdContinue.
*
        *
        **/
        @Generated(value={})
        public interface UssdContinue extends AbstractUssdCommand {
	      /**
        *
        * Consistent with that of UssdBegin
        *<br/>
        * Reference 4.2.5
        * <br/>
        * Length 1
        *
        * @see  mofokom.in.ussd.marker.InterfaceVersion InterfaceVersion
        * <br/>
        *
        **/
        public void setUssdVersion(int value);
        public int getUssdVersion();
	      /**
        *
        * Operation type of USSD session
        *<br/>
        * Reference 4.2.6
        * <br/>
        * Length 1
        *
        * @see  mofokom.in.ussd.UssdOpType UssdOpType
        * <br/>
        *
        **/
        public void setUssdOpType(int value);
        public int getUssdOpType();
	      /**
        *
        * Consistent with that of UssdBegin
        *<br/>
        * Reference 4.2.7
        * <br/>
        * Length 21
        *
        * @see  mofokom.in.ussd.marker.MsIsdn MsIsdn
        * <br/>
        *
        **/
        public void setMsIsdn(java.lang.String value);
        public java.lang.String getMsIsdn();
	      /**
        *
        * UssdContinue is not in use.
*  Set to NULL
        *<br/>
        * Reference 4.2.8
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.ServiceCode ServiceCode
        * <br/>
        *
        **/
        public void setServiceCode(java.lang.String value);
        public java.lang.String getServiceCode();
	      /**
        *
        * Coding scheme of USSD string
        *<br/>
        * Reference 4.2.9
        * <br/>
        * Length 1
        *
        * @see  mofokom.in.ussd.marker.CodeScheme CodeScheme
        * <br/>
        *
        **/
        public void setCodeScheme(int value);
        public int getCodeScheme();
	      /**
        *
        * A USSD string
        *<br/>
        * Reference 4.2.10
        * <br/>
        * Length 182
        *
        * @see  mofokom.in.ussd.marker.UssdString UssdString
        * <br/>
        *
        **/
        public void setUssdString(java.lang.String value);
        public java.lang.String getUssdString();
        }
