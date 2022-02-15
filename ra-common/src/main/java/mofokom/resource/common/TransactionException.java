/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.resource.common;

/**
 *
 * @author wozza
 */
public class TransactionException extends RuntimeException{

    public TransactionException(Throwable ex) {
        super(ex);
    }
}