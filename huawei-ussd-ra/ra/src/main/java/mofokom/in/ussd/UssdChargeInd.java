        package mofokom.in.ussd;
        import javax.annotation.Generated;
        /**
        *
        * UssdChargeInd is used for the USSD service application to request the USSDC to generate a bill of charge.
* UssdChargeInd can be sent only by the USSD service application to the USSDC.
*
The following table defines the syntax of UssdChargeInd.
*
        *
        **/
        @Generated(value={})
        public interface UssdChargeInd extends UssdCommand {
	      /**
        *
        * Charging ratio (unit: fen)
        *<br/>
        * Reference 4.2.12
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.ChargeRatio ChargeRatio
        * <br/>
        *
        **/
        public void setChargeRatio(int value);
        public int getChargeRatio();
	      /**
        *
        * Charging type
        *<br/>
        * Reference 4.2.13
        * <br/>
        * Length 4
        *
        * @see  mofokom.in.ussd.marker.ChargeType ChargeType
        * <br/>
        *
        **/
        public void setChargeType(int value);
        public int getChargeType();
	      /**
        *
        * Charging source ID
        *<br/>
        * Reference 4.2.14
        * <br/>
        * Length 21
        *
        * @see  mofokom.in.ussd.marker.ChargeSource ChargeSource
        * <br/>
        *
        **/
        public void setChargeSource(java.lang.String value);
        public java.lang.String getChargeSource();
	      /**
        *
        * Location of charging
        *<br/>
        * Reference 4.2.15
        * <br/>
        * Length 1
        *
        * @see  mofokom.in.ussd.marker.ChargeLocation ChargeLocation
        * <br/>
        *
        **/
        public void setChargeLocation(int value);
        public int getChargeLocation();
        }
