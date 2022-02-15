        package mofokom.in.ussd.marker;
        import javax.annotation.Generated;
        /**
        *
        * The SenderCB field indicates the session control identifier of the sender.
* During a USSD session, SenderCB is used for the sender to identify the current session.
* The receiver returns the original value of this field in a response message to the ReceiverCB field.
* If a message does not use the field, set the field to 0xFFFFFFFF.
*
        *
        **/
        @Generated(value={})
        public interface SenderCB {
        }
