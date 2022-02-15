          package mofokom.ccn.air.acip.value;
        /**
        *   Section Reference 6.49
        *
        **/
          public enum ResponseCodeValueRange {
            SUCCESSFUL(0,"Successful"),
            OK_BUT_SUPERVISION_PERIOD_EXCEEDED(1,"Ok but supervision period exceeded"),
            OK_BUT_SERVICE_FEE_PERIOD_EXCEEDED(2,"Ok but service fee period exceeded"),
            OTHER_ERROR(100,"Other Error"),
            NOT_USED(101,"Not used"),
            SUBSCRIBER_NOT_FOUND(102,"Subscriber not found"),
            ACCOUNT_BARRED_FROM_REFILL(103,"Account barred from refill"),
            TEMPORARY_BLOCKED(104,"Temporary blocked"),
            DEDICATED_ACCOUNT_NOT_ALLOWED(105,"Dedicated account not allowed"),
            DEDICATED_ACCOUNT_NEGATIVE(106,"Dedicated account negative"),
            VOUCHER_STATUS_USED_BY_SAME(107,"Voucher status used by same"),
            VOUCHER_STATUS_USED_BY_DIFFERENT(108,"Voucher status used by different"),
            VOUCHER_STATUS_UNAVAILABLE(109,"Voucher status unavailable"),
            VOUCHER_STATUS_EXPIRED(110,"Voucher status expired"),
            VOUCHER_STATUS_STOLEN_OR_MISSING(111,"Voucher status stolen or missing"),
            VOUCHER_STATUS_DAMAGED(112,"Voucher status damaged"),
            VOUCHER_STATUS_PENDING(113,"Voucher status pending"),
            VOUCHER_TYPE_NOT_ACCEPTED(114,"Voucher type not accepted"),
            REFILL_NOT_ACCEPTED(115,"Refill not accepted"),
            SERVICE_CLASS_CHANGE_NOT_ALLOWED(117,"Service class change not allowed"),
            INVALID_VOUCHER_ACTIVATION_CODE(119,"Invalid voucher activation code"),
            INVALID_REFILL_PROFILE(120,"Invalid refill profile"),
            SUPERVISION_PERIOD_TOO_LONG(121,"Supervision period too long"),
            SERVICE_FEE_PERIOD_TOO_LONG(122,"Service fee period too long"),
            MAX_CREDIT_LIMIT_EXCEEDED(123,"Max credit limit exceeded"),
            BELOW_MINIMUM_BALANCE(124,"Below minimum balance"),
            ACCOUNT_NOT_ACTIVE(126,"Account not active"),
            ACCUMULATOR_NOT_AVAILABLE(127,"Accumulator not available"),
            INVALID_PIN_CODE(128,"Invalid PIN code"),
            FAF_NUMBER_DOES_NOT_EXIST(129,"Faf number does not exist"),
            FAF_NUMBER_NOT_ALLOWED_(130,"Faf number not allowed,"),
            SERVICE_CLASS_LIST_EMPTY(133,"Service class list empty"),
            ACCUMULATOR_OVERFLOW(134,"Accumulator overflow"),
            ACCUMULATOR_UNDERFLOW(135,"Accumulator underflow"),
            DATE_ADJUSTMENT_ERROR(136,"Date adjustment error"),
            GET_BALANCE_AND_DATE_NOT_ALLOWED(137,"Get balance and date not allowed"),
            NO_PIN_CODE_REGISTERED(138,"No PIN code registered"),
            DEDICATED_ACCOUNT_NOT_DEFINED(139,"Dedicated account not defined"),
            INVALID_OLD_SERVICE_CLASS(140,"Invalid old Service Class"),
            INVALID_LANGUAGE(141,"Invalid language"),
            SUBSCRIBER_ALREADY_INSTALLED(142,"Subscriber already installed"),
            INVALID_MASTER_SUBSCRIBER(143,"Invalid master subscriber"),
            SUBSCRIBER_ALREADY_ACTIVATED(144,"Subscriber already activated"),
            ALREADY_LINKED_SUBORDINATE(145,"Already linked subordinate"),
            ALREADY_LINKED_AS_MASTER(146,"Already linked as master"),
            INVALID_OLD_COMMUNITY_LIST(147,"Invalid old community list"),
            INVALID_NEW_COMMUNITY_LIST(148,"Invalid new community list"),
            INVALID_PROMOTION_PLAN_END_DATE(149,"Invalid promotion plan end date"),
            INVALID_PROMOTION_PLAN_ID(150,"Invalid promotion plan id"),
            PROMOTION_PLAN_NOT_FOUND(151,"Promotion plan not found"),
            DEBLOCKING_OF_EXPIRED_ACCOUNT(152,"Deblocking of expired account"),
            DEDICATED_ACCOUNT_MAX_CREDIT_LIMIT_EXCEEDED(153,"Dedicated account max credit limit exceeded"),
            INVALID_OLD_SC_DATE(154,"Invalid old SC date"),
            INVALID_NEW_SERVICE_CLASS(155,"Invalid new service class"),
            DELETE_SUBSCRIBER_FAILED(156,"Delete subscriber failed"),
            INVALID_ACCOUNT_HOME_REGION(157,"Invalid account home region"),
            MAXIMUM_NUMBER_OF_ALLOCATED_PROMOTION_PLANS_ALREADY_REACHED(158,"Maximum number of allocated promotion plans already reached"),
            CHARGED_FAF_NOT_ACTIVE_FOR_SERVICE_CLASS(159,"Charged FaF not active for service class"),
            OPERATION_NOT_ALLOWED_FROM_CURRENT_LOCATION(160,"Operation not allowed from current location"),
            FAILED_TO_GET_LOCATION_INFORMATION(161,"Failed to get location information"),
            OTHER_ERROR_NO_RETRY(999,"Other Error No Retry"),
            ;
            private java.lang.Integer value;
            private String description;
            private ResponseCodeValueRange(java.lang.Integer value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.Integer getValue() {
              return this.value;
            }
            public static ResponseCodeValueRange forValue(java.lang.Integer value){
              for(ResponseCodeValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No ResponseCodeValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
