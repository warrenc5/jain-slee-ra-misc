        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * UssdBind is used for the USSD service application to log in to the USSDC, to go through authentication, and to establish a network connection.
* Prior to a USSD session, the USSD service application must perform a Bind operation, requesting to log in to the USSDC.
* During login, the account name and login password of the USSD service application must be provided.
* Whether the USSD service application passes the authentication, the USSDC sends a response message UssdBindResp to the USSD service application.
*
UssBind can be sent only by the USSD service application to the USSDC; UssdBindResp can be sent only by the USSDC to the USSD service application.
*
The following table defines the syntax of UssdBind.
*
        *
        **/
        @Generated(value={})
        public interface UssdBind extends UssdCommand {
	      /**
        *
        * Login account name of the service application.
* 
        *<br/>
        * Reference 4.2.1
        * <br/>
        * Length 11
        *
        * @see  mofokom.in.ussd.marker.AccountName AccountName
        * <br/>
        *
        **/
        public void setAccountName(java.lang.String value);
        public java.lang.String getAccountName();
	      /**
        *
        * Login account password of the service application.
* 
        *<br/>
        * Reference 4.2.2
        * <br/>
        * Length 9
        *
        * @see  mofokom.in.ussd.marker.Password Password
        * <br/>
        *
        **/
        public void setPassword(java.lang.String value);
        public java.lang.String getPassword();
	      /**
        *
        * Reserved
        *<br/>
        * Reference 4.2.3
        * <br/>
        * Length 13
        *
        * @see  mofokom.in.ussd.marker.SystemType SystemType
        * <br/>
        *
        **/
        public void setSystemType(java.lang.String value);
        public java.lang.String getSystemType();
	      /**
        *
        * Interface version.
* The current version is 0x10
        *<br/>
        * Reference 4.2.4
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.InterfaceVersion InterfaceVersion
        * <br/>
        *
        **/
        public void setInterfaceVersion(int value);
        public int getInterfaceVersion();
        }
