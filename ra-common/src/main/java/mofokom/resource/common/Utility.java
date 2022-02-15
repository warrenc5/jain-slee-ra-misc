/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.common;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wozza
 */
public class Utility {

    public static URI[] toURIArray(String ... uriString) throws URISyntaxException{
        URI[] uriArray = new URI[uriString.length];
        int i = 0;
        for(String s : uriString) {
            uriArray[i++] = new URI(s.trim());
        }
        return uriArray;
    }

    public static URI[] getUdpScheme(URI ... uriArray){
        Set<URI> uriResultArray = new HashSet<URI>();
        for(URI uri : uriArray) {
            if(uri.getScheme()!=null && uri.getScheme().equals("udp"))
                uriResultArray.add(uri);
        }
        return uriResultArray.toArray(new URI[uriResultArray.size()]);
    }

    public static URI[] getTcpScheme(URI ... uriArray){
        Set<URI> uriResultArray = new HashSet<URI>();
        for(URI uri : uriArray) {
            if(uri.getScheme()!=null && uri.getScheme().equals("tcp"))
                uriResultArray.add(uri);
        }
        return uriResultArray.toArray(new URI[uriResultArray.size()]);
    }


    public static URI[] getSctpScheme(URI ... uriArray){
        Set<URI> uriResultArray = new HashSet<URI>();
        for(URI uri : uriArray) {
            if(uri.getScheme()!=null && uri.getScheme().equals("sctp"))
                uriResultArray.add(uri);
        }
        return uriResultArray.toArray(new URI[uriResultArray.size()]);
    }

    public static SocketAddress[] toSocketAddress(URI ... uriArray){
        SocketAddress[] socketAddressArray = new SocketAddress[uriArray.length];
        int i = 0;
        for(URI uri : uriArray) {
            //socketAddressArray[i++] = InetSocketAddress.createUnresolved(uri.getHost(),uri.getPort());
            if(uri.getPort() == -1)
                socketAddressArray[i++] = new InetSocketAddress(uri.getHost(),0);
            else
                socketAddressArray[i++] = new InetSocketAddress(uri.getHost(),uri.getPort());
        }
        return socketAddressArray;
    }

    public static SocketAddress[] toSocketAddress(String ... uriString) throws URISyntaxException {
        URI[] uriArray = Utility.toURIArray(uriString);
        SocketAddress[] socketArray = Utility.toSocketAddress(uriArray);
        return socketArray;
    }
}
