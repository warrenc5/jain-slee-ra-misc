/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.ccn.impl;

/**
 *
 * @author wozza
 */
public interface Codeable {
            void encode(Encoder encoder) ;
            void decode(Decoder decoder) throws InstantiationException, IllegalAccessException;

}