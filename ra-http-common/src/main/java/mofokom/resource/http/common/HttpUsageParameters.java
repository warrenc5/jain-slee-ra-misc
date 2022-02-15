package mofokom.resource.http.common;

import javax.slee.usage.SampleStatistics;
import mofokom.resource.common.UsageParameters;

public interface HttpUsageParameters extends UsageParameters{

    public void incrementConnectionsOpened(long l);
    public void incrementFatalIOExceptions(long l);
    public void incrementProtocolExceptions(long l);
    public void incrementConnectionTimeout(long l);

    public void incrementConnectionClose(long l);

    public void incrementTxOK(long l);

    public void incrementRxOK(long l);

    public void incrementTxNOK(long l);

    public void incrementRxNOK(long l);

    /*
    public long getConnectionsOpened();
    public long getFatalIOExceptions();
    public long getProtocolExceptions();
    public long getConnectionTimeout();
    public long getConnectionClose();


    public long getRxOK();

    public long getTxNOK();

    public long getTxOK();

    public long getRxNOK();

    public SampleStatistics getLatencyTxOK();

    public SampleStatistics getLatencyRxOK();

    public SampleStatistics getLatencyTxNOK();

    public SampleStatistics getLatencyRxNOK();

     *
     */
    public void sampleLatencyTxOK(long l);

    public void sampleLatencyRxOK(long l);

    public void sampleLatencyTxNOK(long l);

    public void sampleLatencyRxNOK(long l);

}
