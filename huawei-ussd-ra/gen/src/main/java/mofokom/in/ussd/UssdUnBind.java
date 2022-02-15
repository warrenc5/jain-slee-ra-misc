        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * UssdUnBind is used for the USSD service application to log out from the USSDC.
*Upon receipt of a UssdUnBind request, the USSDC sends a response message UssdUnBindResp to the USSD service application, indicating the result of the logout operation.
*
UssdUnBind is sent by the USSD service application to the USSDC; UssdUnBindResp is sent by the USSDC to the USSD service application.
*
The following table defines the syntax of UssdUnBind.
*
        *
        **/
        @Generated(value={})
        public interface UssdUnBind extends UssdCommand {
        }
