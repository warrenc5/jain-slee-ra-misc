
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wozza
 */
@XmlRootElement
public class SimplePojo {

    public SimplePojo(String value) {
        this.value = value;
    }

    public SimplePojo() {
    }

    
    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

   

    @Override
    public String toString() {
        return "SimplePojo{" + "value=" + value + '}';
    }


}
