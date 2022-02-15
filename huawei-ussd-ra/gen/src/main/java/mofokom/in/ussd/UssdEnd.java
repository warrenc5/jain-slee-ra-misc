        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * UssdEnd is used to indicate the end of a USSD session.
* It can be sent by the USSD service application only.
* UssdEnd indicates that a USSD session ends normally.
*
The following table defines the syntax of UssdEnd.
*
        *
        **/
        @Generated(value={})
        public interface UssdEnd extends UssdCommand {
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
        * Operation type of a USSD session
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
        * Consistent with that of UssdBegin
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
        * Coding scheme of a USSD string
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
