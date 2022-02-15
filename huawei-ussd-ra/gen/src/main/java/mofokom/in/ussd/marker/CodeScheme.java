        package mofokom.in.ussd.marker;
        import javax.annotation.Generated;
        /**
        *
        * The CodeScheme field indicates the coding scheme of a USSD string.
* For the detailed coding scheme, refer to GSM03.
*38.
*To a session initiated by the USSD service party, this field indicates what scheme the USSDC uses to code a USSD string.
* To a session initiated by the USSDC to the USSD service application, this fielsd can be ignored.
* The USSDC communicates with the USSD service application using plain codes.
* Common coding schemes include:
0x0F (seven-digit code), 0x48 (sixteen-digit code), and 0x44 (eight-digit code).
*
        *
        **/
        @Generated(value={})
        public interface CodeScheme {
        }
