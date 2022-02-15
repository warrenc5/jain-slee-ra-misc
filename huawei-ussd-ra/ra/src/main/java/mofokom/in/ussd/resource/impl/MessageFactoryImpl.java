package mofokom.in.ussd.resource.impl;

import javax.annotation.Generated;
import static mofokom.in.ussd.impl.util.Util.setup;
import mofokom.in.ussd.resource.*;
import mofokom.in.ussd.impl.*;
import mofokom.in.ussd.*;

@Generated(value = {})
public class MessageFactoryImpl implements MessageFactory {

    public UssdBind createUssdBind() {
        UssdBindImpl cmd = new UssdBindImpl();
        setup(cmd);
        return cmd;
    }

    public UssdBindResp createUssdBindResp() {
        UssdBindRespImpl cmd = new UssdBindRespImpl();
        setup(cmd);
        return cmd;
    }

    public UssdUnBind createUssdUnBind() {
        UssdUnBindImpl cmd = new UssdUnBindImpl();
        setup(cmd);
        return cmd;
    }

    public UssdUnBindResp createUssdUnBindResp() {
        UssdUnBindRespImpl cmd = new UssdUnBindRespImpl();
        setup(cmd);
        return cmd;
    }

    public UssdShake createUssdShake() {
        UssdShakeImpl cmd = new UssdShakeImpl();
        setup(cmd);
        return cmd;
    }

    public UssdShakeResp createUssdShakeResp() {
        UssdShakeRespImpl cmd = new UssdShakeRespImpl();
        setup(cmd);
        return cmd;
    }

    public UssdBegin createUssdBegin() {
        UssdBeginImpl cmd = new UssdBeginImpl();
        setup(cmd);
        return cmd;
    }

    public UssdContinue createUssdContinue() {
        UssdContinueImpl cmd = new UssdContinueImpl();
        setup(cmd);
        return cmd;
    }

    public UssdEnd createUssdEnd() {
        UssdEndImpl cmd = new UssdEndImpl();
        setup(cmd);
        return cmd;
    }

    public UssdAbort createUssdAbort() {
        UssdAbortImpl cmd = new UssdAbortImpl();
        setup(cmd);
        return cmd;
    }

    public UssdSwitch createUssdSwitch() {
        UssdSwitchImpl cmd = new UssdSwitchImpl();
        setup(cmd);
        return cmd;
    }

    public UssdChargeInd createUssdChargeInd() {
        UssdChargeIndImpl cmd = new UssdChargeIndImpl();
        setup(cmd);
        return cmd;
    }

    public UssdChargeIndResp createUssdChargeIndResp() {
        UssdChargeIndRespImpl cmd = new UssdChargeIndRespImpl();
        setup(cmd);
        return cmd;
    }

    @Override
    public UssdContinue createUssdContinue(AbstractUssdCommand command) {
        UssdContinue cont = this.createUssdContinue();
        cont.setServiceCode(command.getServiceCode()); //have to specify this other wise no route
        cont.setUssdVersion(command.getUssdVersion());
        cont.setReceiverCB(command.getSenderCB());
        cont.setMsIsdn(command.getMsIsdn());
        return cont;
    }

    @Override
    public UssdEnd createUssdEnd(AbstractUssdCommand command) {
        UssdEnd end = this.createUssdEnd();
        end.setServiceCode(command.getServiceCode()); //have to specify this other wise no route
        end.setUssdVersion(command.getUssdVersion());
        end.setReceiverCB(command.getSenderCB());
        end.setMsIsdn(command.getMsIsdn());
        return end;
    }
}
