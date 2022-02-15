/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.in.ussd.resource.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.slee.Address;
import javax.slee.AddressPlan;
import mofokom.in.ussd.UssdBegin;
import mofokom.in.ussd.UssdCommand;
import mofokom.in.ussd.resource.UssdActivity;
import mofokom.resource.common.AbstractTransaction;

/**
 *
 * @author wozza
 */
public class UssdActivityImpl extends AbstractTransaction<UssdCommand,Serializable> implements UssdActivity {

    private final UssdCommand command;
    private List<UssdCommand> commandHistory;
    private boolean mobileTerminating = false;

    public UssdActivityImpl(UssdCommand command,int ra, int seq) {
        super(command, ra, seq);
        this.command = command;
        this.getActivityHandle().setAttachment(command.getSenderCB());
    }

    public List getCommandHistory() {
        if(commandHistory==null)
            commandHistory = new ArrayList<UssdCommand>();
        return commandHistory;
    }

    public boolean isMobileTerminating() {
        return mobileTerminating;
    }

    public void setMobileTerminating(boolean mobileTerminating) {
        this.mobileTerminating = mobileTerminating;
    }

    public Address getServiceCode(){
        if(super.getAttachment() ==null)
            return null;
        return new Address(AddressPlan.E164, ((UssdBegin) super.getAttachment()).getServiceCode());
    }
    

}