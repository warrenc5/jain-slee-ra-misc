        package mofokom.in.ussd.marker;
        import javax.annotation.Generated;
        /**
        *
        * The UssdString field indicates an information string of a USSD session.
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
        *
        **/
        @Generated(value={})
        public interface UssdString {
        }
