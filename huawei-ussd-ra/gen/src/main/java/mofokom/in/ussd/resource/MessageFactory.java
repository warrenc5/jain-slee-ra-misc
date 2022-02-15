    package mofokom.in.ussd.resource;
    import mofokom.in.ussd.*;
    import javax.annotation.Generated;
    @Generated(value={})
    public interface MessageFactory {
      UssdBind createUssdBind();
        UssdBindResp createUssdBindResp();
        UssdUnBind createUssdUnBind();
        UssdUnBindResp createUssdUnBindResp();
        UssdShake createUssdShake();
        UssdShakeResp createUssdShakeResp();
        UssdBegin createUssdBegin();
        UssdContinue createUssdContinue();
        UssdEnd createUssdEnd();
        UssdAbort createUssdAbort();
        UssdSwitch createUssdSwitch();
        UssdChargeInd createUssdChargeInd();
        UssdChargeIndResp createUssdChargeIndResp();
    }
