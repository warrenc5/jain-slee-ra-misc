package mofokom.sap.resource;

import java.net.InetAddress;
import java.net.UnknownHostException;

public interface Config
{

    public void setAddress(String address);

    public String getAddress();

    public void setLocalAddress(String address);

    public String getLocalAddress();

    public void setBitRateLimit(Long bitRateLimit);

    public Long getBitRateLimit();

    public void setMaximumDatagramSize(Integer maximumDatagramSize);

    public Integer getMaximumDatagramSize();

    public void setMinimumTransmitDelay(Integer retransmitMinDelay);

    public Integer getMinimumTransmitDelay();

    public void setMulticastPort(Integer portNumber);

    public Integer getMulticastPort();

    public void setLoopbackEnabled(Boolean isLoopbackEnabled);

    public Boolean getLoopbackEnabled();

    public void setMaximumCancellationRetransmits(Integer maximumCancellationRetransmits);

    public Integer getMaximumCancellationRetransmits();

    public Byte getTTL();

    public void setTTL(final Byte TTL);


}
