        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * BaseCommand
        *
        **/
        @Generated(value={})
        public interface UssdCommand {
	      /**
        *
        * Defines the size of the whole message packet
        *<br/>
        * Reference 4.1.1
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.CommandLength CommandLength
        * <br/>
        *
        **/
        public void setCommandLength(int value);
        public int getCommandLength();
	      /**
        *
        * Message identifier of UssdBind 
        *<br/>
        * Reference 4.1.2
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.CommandID CommandID
        * <br/>
        *
        **/
        public void setCommandID(int value);
        public int getCommandID();
	      /**
        *
        * UssdBind is not in use.
* Set to NULL
        *<br/>
        * Reference 4.1.3
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.CommandStatus CommandStatus
        * <br/>
        *
        **/
        public void setCommandStatus(int value);
        public int getCommandStatus();
	      /**
        *
        * UssdBind is not in use.
* Set to 0xFFFFFFFF
        *<br/>
        * Reference 4.1.4
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.SenderCB SenderCB
        * <br/>
        *
        **/
        public void setSenderCB(int value);
        public int getSenderCB();
	      /**
        *
        * UssdBind is not in use.
* Set to 0xFFFFFFFF
        *<br/>
        * Reference 4.1.5
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.ReceiverCB ReceiverCB
        * <br/>
        *
        **/
        public void setReceiverCB(int value);
        public int getReceiverCB();
        }
