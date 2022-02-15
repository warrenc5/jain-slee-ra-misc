/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.in.telnet.event;

import mofokom.resource.telnet.common.TelnetCommand;

/**
 *
 * @author wozza
 */
public class TelNetEvent {
    
    TelnetCommand command;
    byte[] data;

    public TelnetCommand getCommand() {
        return command;
    }

    public void setCommand(TelnetCommand command) {
        this.command = command;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
