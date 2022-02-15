/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl;

import java.util.logging.Logger;

/**
 *
 * @author wozza
 */
public class Util {
    public static boolean STRICT= false;

    private static Logger log = Logger.getLogger("mofokom.air.model");
    public static void mandatoryMissing(String name, String section) throws IllegalArgumentException {
        StringBuilder buffy = new StringBuilder("Mandatory parameter missing, ");
        buffy.append(name);
        buffy.append(", see Section ");
        buffy.append(section);
        if (STRICT)
            throw new IllegalArgumentException(buffy.toString());
        else
            log.warning(buffy.toString());
    }

}
