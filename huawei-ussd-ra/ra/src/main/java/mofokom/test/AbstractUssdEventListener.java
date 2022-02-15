package mofokom.test;

import java.io.IOException;
import java.util.logging.Logger;
import mofokom.in.ussd.CommandID;
import mofokom.in.ussd.UssdBegin;
import mofokom.in.ussd.UssdChargeInd;
import mofokom.in.ussd.UssdCommand;
import mofokom.in.ussd.UssdContinue;
import mofokom.in.ussd.UssdOpType;
import mofokom.in.ussd.UssdVersion;
import mofokom.in.ussd.impl.util.UssdConnectionListener;
import mofokom.in.ussd.impl.util.UssdConnection;
import mofokom.in.ussd.resource.impl.MessageFactoryImpl;

/**
 *
 * @author wozza
 */
public class AbstractUssdEventListener implements UssdConnectionListener {

    private static final Logger logger =  Logger.getLogger(AbstractUssdEventListener.class.getName());
    private UssdConnection connection;

    public AbstractUssdEventListener() {
    }

    public void connected(UssdConnection connection) {
        logger.info("connected");
        this.connection = connection;
    }

    public void exception(UssdConnection connection, Exception ex) {
        ex.printStackTrace();
    }

    public void disconnected(UssdConnection connection) {
        logger.info("ran");
    }

    public void received(UssdCommand cmd) {
        logger.info("received:" + cmd.toString());
        if (cmd.getCommandID() == CommandID.UssdBegin.intValue()) {
            UssdContinue cont = new MessageFactoryImpl().createUssdContinue();
            UssdBegin begin = (UssdBegin) cmd;

            UssdChargeInd charge = new MessageFactoryImpl().createUssdChargeInd();

            charge.setChargeRatio(1);
            charge.setChargeSource("321");
            charge.setReceiverCB(begin.getSenderCB());
            charge.setChargeType(1);
            charge.setChargeLocation(2);

                       //cont.setCommandID(CommandID.UssdEnd.intValue());

            cont.setCodeScheme(15);
            cont.setMsIsdn(begin.getMsIsdn());
            cont.setUssdVersion(UssdVersion.PHASE_I.intValue());
            cont.setReceiverCB(begin.getSenderCB());
            cont.setServiceCode(begin.getServiceCode());
            cont.setUssdOpType(UssdOpType.Response.intValue());
            cont.setUssdString("1. Accepted\n 2. Rejected");

            try {
                connection.send(cont);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }

             try {
                connection.send(charge);
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/



        }
        if (cmd.getCommandID() == CommandID.UssdContinue.intValue()) {
            UssdContinue begin = (UssdContinue) cmd;
            UssdContinue cont = new MessageFactoryImpl().createUssdContinue();
            //cont.setCommandID(CommandID.UssdEnd.intValue());


            cont.setCodeScheme(15);
            cont.setMsIsdn(begin.getMsIsdn());
            cont.setUssdVersion(begin.getUssdVersion());
            cont.setReceiverCB(begin.getSenderCB());
            //           cont.setServiceCode(begin.getServiceCode());
            cont.setUssdOpType(UssdOpType.Response.intValue());

            cont.setUssdString("Continued");

            try {
                connection.send(cont);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
