package mofokom.resource.mlp.impl;


import mofokom.resource.http.common.HttpUsageParameters;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wozza
 */
public interface MLPResourceAdaptorUsageParameters extends HttpUsageParameters {

    public void incrementSlirTXOK(long l);
    public void incrementSlirTXNOK(long l);

    public void incrementSliaTXOK(long l);
    public void incrementSliaTXNOK(long l);

    public void incrementSlrepRXOK(long l);
    public void incrementSlrepRXNOK(long l);

    public void incrementSlirepRXOK(long l);
    public void incrementSlirepRXNOK(long l);

    public void incrementTlrrTXOK(long l);
    public void incrementTlrrTXNOK(long l);

    public void incrementTlraRXOK(long l);
    public void incrementTlraRXNOK(long l);

    public void incrementTlsrTXOK(long l);
    public void incrementTlsrTXNOK(long l);

    public void incrementElirTXOK(long l);
    public void incrementElirTXNOK(long l);

    public void incrementEliaRXOK(long l);
    public void incrementEliaRXNOK(long l);

    public void incrementElirepRXOK(long l);
    public void incrementElirepRXNOK(long l);

}
