        package mofokom.in.ussd.marker;
        import javax.annotation.Generated;
        /**
        *
        * The ServiceCode field indicates the service code of a USSD session.
* This field is not used in UssdBegin sessions initiated by mobile stations, but is used only in UssdBegin sessions initiated by the service party.
* In UssdSwitch, this field indicates the target service code to switch a session to.
* For the value range of the service code, refer to the GSM02.
*90 protocol.
*
Note: This field is not used now because this field length is only 4 characters, but the real length of s service code usually exceeds 4 characters.
*If the session iniated by MS, the service code should be parsed from the field UssdString.
*
        *
        **/
        @Generated(value={})
        public interface ServiceCode {
        }
