        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * UssdShake is used for handshaking between the USSD service application and the USSDC.
* Upon receipt of a UssdShake message from the USSD service application, the USSDC sends a response message UssdShakeResp.
* The USSD service application periodically (at an interval of a maximum of five seconds) sends a UssdShake message to the USSDC, and checks whether a UssdShakeResp message is received to determine whether the session between the USSD service application and the USSDC is functioning.
* To determine whether its session with the USSD service application is functioning, the USSDC checks whether it has received a UssShake message.
*
The following table defines the syntax of UssdShake.
*
        *
        **/
        @Generated(value={})
        public interface UssdShake extends UssdCommand {
        }
