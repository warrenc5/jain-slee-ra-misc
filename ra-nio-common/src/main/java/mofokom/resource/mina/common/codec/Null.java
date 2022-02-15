/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.resource.mina.common.codec;

/**
 *
 * @author wozza
 */
public class Null {
    Class nullClass;
    boolean array =false; 

    public Null(Class nullClass) {
        this.nullClass = nullClass;
    }

    public Null(Class nullClass, boolean array) {
        array=true;
        this.nullClass = nullClass;
    }

    public Class getNullClass() {
        return nullClass;
    }

    
    
}
