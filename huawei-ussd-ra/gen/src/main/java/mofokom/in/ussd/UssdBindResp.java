        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * The following table defines of the syntax of UssdBindResp.
*
        *
        **/
        @Generated(value={})
        public interface UssdBindResp extends UssdCommand {
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
        }
