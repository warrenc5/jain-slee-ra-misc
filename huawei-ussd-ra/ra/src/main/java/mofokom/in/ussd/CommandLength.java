        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        *<pre>
        * The CommandLength field indicates the number of bytes of a USSD service application service protocol message.
* CommandLength comprises two parts: message header and message body, inclusive of the length of the CommandLength field.
* 
The CommandID field indicates the type of a USSD service application protocol message.
* The following table lists the types of the USSD service application protocol messages and the values of the messages.
* 
CommandID
The CommandStatus field indicates the status of a successful or faulty USSD service application protocol message.
* If a message does not use the CommandStatus field, set the field to NULL.
*
The SenderCB field indicates the session control identifier of the sender.
* During a USSD session, SenderCB is used for the sender to identify the current session.
* The receiver returns the original value of this field in a response message to the ReceiverCB field.
* If a message does not use the field, set the field to 0xFFFFFFFF.
*
The ReceiverCB field indicates the session control identifier of the receiver.
* During a USSD session, ReceiverCB is used for the receiver to identify the current session.
* If a message does not use the field, set the field to 0xFFFFFFFF.
*
The AccountName field indicates the account name of the USSD service application which is to log in to the USSDC.
*
The Password field indicates the password the USSD service application uses to log in to the USSDC.
* This field is used for the USSDC to authenticate the USSD service application.
*
The SystemType field indicates the type of the USSD service application.
* At present, this field is not ready for use yet.
*
The InterfaceVersion field indicates the version of the USSD service application protocol.
* The current version is 0x10.
*
The UssdVersion field indicates the version of the USSD session.
* Currently, there are three versions of USSD session: PHASE I, PHASE II, and PHASE II+.
* The specification of the PHASE II+ version is being drafted and not ready for use yet.
* The following table lists the values of the three USSD versions:
UssdVersion
The UssdOpType field indicates the operation types of a USSD session.
* There are four operation types: Request, Notify, Response, and Release.
* In different types of sessions, the values of this field follow these regulations: 
1.
*	UssdBegin corresponds to two operation types: Request and Notify.
* The operation type of the UssdBegin session initiated by a mobile station can be Request only.
* The operation type of the UssdBegin session initiated by the service party can be Request or Notify.
*
2.
*	UssdContinue corresponds to three operation types: Request, Notify, and Response.
* The operation type of the UssdContinue session initiated by a mobile station can be Response only.
* The operation type of the UssdContinue session initiated by the service party can be Request or Notify.
*
3.
*	UssdEnd corresponds to two types: Request and Release.
* If the sender of a session is a mobile station, the operation type of UssdEnd can be Response only.
* If the sender of the session is the service party, the operation type of UssdEnd can be Release only.
*
The following table lists the values of the operation types of the UssdOpType field:
UssdOpType
The MsIsdn field indicates the number of the mobile station in a session.
*
The ServiceCode field indicates the service code of a USSD session.
* This field is not used in UssdBegin sessions initiated by mobile stations, but is used only in UssdBegin sessions initiated by the service party.
* In UssdSwitch, this field indicates the target service code to switch a session to.
* For the value range of the service code, refer to the GSM02.
*90 protocol.
*
Note: This field is not used now because this field length is only 4 characters, but the real length of s service code usually exceeds 4 characters.
*If the session iniated by MS, the service code should be parsed from the field UssdString.
*
The CodeScheme field indicates the coding scheme of a USSD string.
* For the detailed coding scheme, refer to GSM03.
*38.
*To a session initiated by the USSD service party, this field indicates what scheme the USSDC uses to code a USSD string.
* To a session initiated by the USSDC to the USSD service application, this fielsd can be ignored.
* The USSDC communicates with the USSD service application using plain codes.
* Common coding schemes include:
0x0F (seven-digit code), 0x48 (sixteen-digit code), and 0x44 (eight-digit code).
*
The UssdString field indicates an information string of a USSD session.
* In a USSDBegin session message initiated by a mobile station, the format of UssdString is: Preample+SC+*+SI+#, where the preamble consists of any combination of 1 to 3 digits of * and #, SC is the service code, SI is a service information string, * is a separator, and # is the terminator.
* In other session messages, UssdString can contain any content.
* 
If CodeScheme designates the seven-digit coding scheme, the maximum length of UssdString is 182 characters.
* If CodeScheme designates the eight-digit coding scheme, the maximum length of UssdString is 160 characters.
* If CodeScheme designates the sixteen-digit coding scheme, the maximum length of UssdString is 80 characters (160 bytes).
*
If the network side initiates the session UssdBegin, the format of UssdString is:@ + service code + @ + specific USSD parameter information.
* If UssdString is not in the aforementioned format, the service code must be entered in ServiceCode.
*
In case of a service switching message UssdSwitch, the format of UssdString is:@ + service code + @ + specific USSD parameter information.
* If UssdString is not in the aforementioned format, the target service code to switch to must be entered in ServiceCode.
*
The SwitchMode field indicates the modes of service switching.
* It comprises two switching modes:0: global switching and 1: local switching.
* Global switching means that the service switching is implemented by the USSD central office where the service application resides.
* Local switching means that the service switching is implemented by the service platform (or the USSDC) directly connecting the service application.
*
The ChargeRatio field indicates the charging ratio of the charging indication.
* Its unit is fen (0.
*01 yuan).
* The value 0 means free of charge.
* 
The ChargeType field indicates the charging types of the charging indication.
* Currently, this field includes the following charging types:0: free, 1: per message, 2: per monthly flat rate, and 3: per monthly flat rate for downlink.
*
The ChargeSource field indicates the identifier of the charging source.
* The service party interprets the specific implication of the contents of this field.
* 
The ChargeLocation field indicates the location where bills are generated.
* There are the following three cases: 1: Both the USSDC and the USSD service platform generate bills.
* 2: Only the USSDC generates bills.
* 3: Only the USSD service platform generates bills.
*
        *</pre>
        *
        **/
        @Generated(value={})
        public enum CommandLength {
            UssdBind(0x00000065),
UssdUnBind(0x00000066),
UssdBindResp(0x00000067),
UssdUnBindResp(0x00000068),
UssdBegin(0x0000006F),
UssdContinue(0x00000070),
UssdEnd(0x00000071),
UssdAbort(0x00000072),
UssdSwitch(0x00000074),
UssdChargeInd(0x00000075),
UssdChargeIndResp(0x00000076),
UssdShake(0x00000083),
UssdShakeResp(0x00000084),
PHASE_I(0x10),
PHASE_II(0x20),
PHASE_II_PLUS(0x25),
Request(0x01),
Notify(0x02),
Response(0x03),
Release(0x04),
;
            int i;
            CommandLength(int i) {
              this.i = i;
            }
            public int intValue() {
              return i;
            }
            public static CommandLength forInt(int i) {
              for(CommandLength e: values()){
                if(e.intValue() == i)
                  return e;
              }
              throw new IllegalArgumentException(new StringBuilder("Unknown value").append(i).toString());
            }
        }
