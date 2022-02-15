/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource.impl.codec;

import mofokom.resource.mina.common.codec.AbstractABNFProtocolDecoder;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author wozza
 */
public class ABNFProtocolDecoder extends AbstractABNFProtocolDecoder {

    public ABNFProtocolDecoder(IoSession is) {
        this.addMessageDecoder(new MessagePacketizer());
    }
}