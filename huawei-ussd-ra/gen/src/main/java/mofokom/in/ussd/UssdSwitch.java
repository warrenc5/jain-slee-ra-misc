        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * USSDSwitch is used for switching a USSD session from a USSD service to another.
* UssdSwitch can be sent only by the USSD service application to the USSDC.
* After the USSD service application sends UssdSwitch, it should close the local resources of the current session.
* Upon receipt of UssdSwitch, the USSDC closes the session with the original service, and reestablishes the connection with the USSD service designated by UssdSwitch.
* The session between the USSDC and the mobile station remains.
* 
The following table defines the syntax of UssdSwitch.
*
        *
        **/
        @Generated(value={})
        public interface UssdSwitch extends UssdCommand {
	      /**
        *
        * Switch mode
        *<br/>
        * Reference 4.2.11
        * <br/>
        * Length 1
        *
        * @see  mofokom.in.ussd.marker.SwitchMode SwitchMode
        * <br/>
        *
        **/
        public void setSwitchMode(int value);
        public int getSwitchMode();
	      /**
        *
        * Number of mobile station
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
        * Target service code to switch to
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
