/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.telnet.common;

/**
 *
 * @author wozza
 */
public enum TelnetCommand {


    SE(0xF0),//    End of subnegotiation parameters.
    NOP(241),//    No operation.
    DATA_MARK(242),//    The data stream portion of a Synch.
    //                  This should always be accompanied
    //                   by a TCP Urgent notification.
    BREAK(243),//    NVT character BRK.
    INTERRUPT_PROCESS(244),//    The function IP.
    ABORT_OUTPUT(245),//    The function AO.
    ARE_YOU_THERE(246),//    The function AYT.
    ERASE_CHARACTER(247),//    The function EC.
    ERASE_LINE(248),//    The function EL.
    GO_AHEAD(249),//    The GA signal.
    SB(0xFA),//    Indicates that what follows is
    //                    subnegotiation of the indicated
    //                     option.
    WILL(251),//    Indicates the desire to begin
    //                      performing, or confirmation that
    //                       you are now performing, the
    //                        indicated option.
    WONT(252),//    Indicates the refusal to perform,
    //                         or continue performing, the
    //                          indicated option.
    DO(253),//    Indicates the request that the
    //                           other party perform, or confirmation that you are expecting
    //                            the other party to perform, the
    //                             indicated option.
    DONT(0xFE),//    Indicates the demand that the
    //                                 other party stop performing,
    //                                or confirmation that you are no
    //                               longer expecting the other party
    //                              to perform, the indicated option.
    IAC(0xFF),//    Data Byte 255.
    ;

    private int data;

    TelnetCommand(int d) {
        this.data = d;
    }

    public int getData() {
        return data;
    }

    public byte byteValue() {
        return (byte)data;
    }

    public static final TelnetCommand[] COMMAND_ARE_YOU_THERE = new TelnetCommand[]{IAC,ARE_YOU_THERE};
}