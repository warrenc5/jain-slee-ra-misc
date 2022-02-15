package mofokom.cxf.transport.slee;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;

import javax.annotation.Resource;
import mofokom.jaxws.resource.impl.AbstractCXFResourceAdaptor;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.http.*;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.log4j.Logger;

public class SleeTransportFactory extends HTTPTransportFactory
        implements ConduitInitiator, DestinationFactory {

    public static final String TRANSPORT_ID = "http://jaxws.mofokom.biz/transports/slee";
    public static final String MESSAGE_FILTER_PROPERTIES = SleeTransportFactory.class.getName() + ".filterProperties";
    public static final String MESSAGE_INCLUDE_PROPERTIES = SleeTransportFactory.class.getName() + ".includeProperties";
    private static final Logger logger = Logger.getLogger(SleeTransportFactory.class.getName());
    private static final Set<String> URI_PREFIXES = new HashSet<String>();
    private static AbstractCXFResourceAdaptor ra;

    static {
        URI_PREFIXES.add("http://");
        URI_PREFIXES.add("https://");
    }
    private static SleeTransportFactory sleeTransport;
    private Map<String, Destination> destinations = new HashMap<String, Destination>();
    private Set<String> messageFilterProperties;
    private Set<String> messageIncludeProperties;
    private Set<String> uriPrefixes = new HashSet<String>(URI_PREFIXES);
    private static SleeHTTPDestination sleeDestination;
    private static ConcurrentMap<String, EndpointInfo> endpointMap;
    private static SleeHTTPConduit conduit;

    public SleeTransportFactory(Bus bus, DestinationRegistry registry) {
        super(bus, registry);
        List<String> ids = new ArrayList<String>();
        endpointMap = new ConcurrentHashMap<String, EndpointInfo>();

        ids.add(TRANSPORT_ID);
        setTransportIds(ids);

        messageFilterProperties = new HashSet<String>();
        messageIncludeProperties = new HashSet<String>();
        messageFilterProperties.add(Message.REQUESTOR_ROLE);
        messageIncludeProperties.add(Message.INBOUND_MESSAGE);
        //messageIncludeProperties.add(Message.PROTOCOL_HEADERS);
        messageIncludeProperties.add(Message.ENCODING);
        messageIncludeProperties.add(Message.CONTENT_TYPE);
        messageIncludeProperties.add(Message.ACCEPT_CONTENT_TYPE);
        messageIncludeProperties.add(Message.RESPONSE_CODE);
        messageIncludeProperties.add(Message.REQUEST_URI);
        this.setMessageFilterProperties(messageFilterProperties);
        this.setMessageIncludeProperties(messageIncludeProperties);
    }

    @Resource(name = "jaxws")
    public void setBus(Bus b) {
        super.setBus(b);
    }

    /*
     * public Destination getDestination(EndpointInfo ei) throws IOException {
     * return getDestination(ei, createReference(ei));
     * }
     *
     * protected Destination getDestination(EndpointInfo ei,
     * EndpointReferenceType reference)
     * throws IOException {
     * Destination d = destinations.get(reference.getAddress().getValue());
     * if (d == null) {
     * d = createDestination(ei, reference);
     * destinations.put(reference.getAddress().getValue(), d);
     * }
     * return d;
     * }
     *
     * private Destination createDestination(EndpointInfo ei, EndpointReferenceType reference) {
     * LOG.info("Creating destination for address " + reference.getAddress().getValue());
     * return new LocalDestination(this, reference, ei);
     * }
     *
     * void remove(LocalDestination destination) {
     * destinations.remove(destination);
     * }
     */
    public Conduit getConduit() throws IOException {
        return conduit;
    }
    @Override
    public Conduit getConduit(EndpointInfo ei) throws IOException {
        //return new SleeConduit(this, createReference(ei));//, (LocalDestination)getDestination(ei));
        return getConduit(ei, createReference(ei));//, (LocalDestination)getDestination(ei));
    }

    @Override
    public Conduit getConduit(EndpointInfo ei, EndpointReferenceType target) throws IOException {
        Bus bus1 = BusFactory.getThreadDefaultBus();
        logger.info("get conduit");

        return conduit = new SleeHTTPConduit(ra, bus1, ei, target);
        //, (LocalDestination)getDestination(ei, target));
    }

    private EndpointReferenceType createReference(EndpointInfo ei) {
        EndpointReferenceType epr = new EndpointReferenceType();
        AttributedURIType address = new AttributedURIType();
        address.setValue(ei.getAddress());
        epr.setAddress(address);
        return epr;
    }

    public EndpointInfo lookupEndPoint(String address) {
        if (!endpointMap.containsKey(address))
            throw new NullPointerException("no endpoint");
        return endpointMap.get(address);
    }

    public Set<String> getUriPrefixes() {
        return uriPrefixes;
    }

    public void setUriPrefixes(Set<String> s) {
        uriPrefixes = s;
    }

    public Set<String> getMessageFilterProperties() {
        return messageFilterProperties;
    }

    public void setMessageFilterProperties(Set<String> props) {
        this.messageFilterProperties = props;
    }

    public Set<String> getIncludeMessageProperties() {
        return messageIncludeProperties;
    }

    public void setMessageIncludeProperties(Set<String> props) {
        this.messageIncludeProperties = props;
    }

    public void copy(Message message, Message copy) {
        Set<String> filter = CastUtils.cast((Set) message.get(MESSAGE_FILTER_PROPERTIES));
        if (filter == null)
            filter = messageFilterProperties;

        Set<String> includes = CastUtils.cast((Set) message.get(MESSAGE_INCLUDE_PROPERTIES));
        if (includes == null)
            includes = messageIncludeProperties;

        // copy all the contents
        for (Map.Entry<String, Object> e : message.entrySet()) {
            if ((includes.contains(e.getKey())
                    || messageIncludeProperties.contains(e.getKey()))
                    && !filter.contains(e.getKey()))
                copy.put(e.getKey(), e.getValue());
        }
    }

    @Override
    public Destination getDestination(EndpointInfo ei) throws IOException {
        logger.info("destination for endpoint address " + ei.getAddress());
        logger.info("destination for endpoint transport id" + ei.getTransportId());
        //TODO here you know what services you have for local loop.
        endpointMap.put(ei.getAddress(), ei);
        Bus bus = BusFactory.getThreadDefaultBus();
        sleeDestination = new SleeHTTPDestination(bus, registry, ei, "/", false);

        return sleeDestination;

    }

    public static void registerTransport() {
        logger.info("register transport ");

        Bus bus = BusFactory.getThreadDefaultBus();

        if (bus == null) {
            BusFactory.newInstance().createBus();
            BusFactory.setThreadDefaultBus(bus);
            BusFactory.setDefaultBus(bus);
        }

        DestinationRegistry registry = null;

        if (registry == null)
            registry = new DestinationRegistryImpl();

        sleeTransport = new SleeTransportFactory(bus, registry);

        HttpDestinationFactory destFac = new HttpDestinationFactory() {

            @Override
            public AbstractHTTPDestination createDestination(EndpointInfo endpointInfo, Bus bus, DestinationRegistry registry) throws IOException {

                logger.info("create destination " + endpointInfo.getAddress());
                URI uri = null;
                try {
                    uri = new URI(endpointInfo.getAddress());
                } catch (URISyntaxException ex) {
                    java.util.logging.Logger.getLogger(SleeTransportFactory.class.getName()).log(Level.SEVERE, null, ex);
                }

                sleeDestination = new SleeHTTPDestination(bus, registry, endpointInfo, uri.getPath(), true);

                return sleeDestination;
            }
        };

        HTTPConduitFactory conduitFac = new HTTPConduitFactory() {

            public HTTPConduit createConduit(HTTPTransportFactory f, EndpointInfo localInfo, EndpointReferenceType target) throws IOException {

                Bus bus1 = BusFactory.getThreadDefaultBus();
                logger.info("get conduit");

                conduit = new SleeHTTPConduit(ra,bus1, localInfo, target);
                return conduit;
            }
        };

        bus.setExtension(destFac, HttpDestinationFactory.class);
        bus.setExtension(conduitFac, HTTPConduitFactory.class);

        DestinationFactoryManagerImpl dfm = bus.getExtension(DestinationFactoryManagerImpl.class);
        dfm = new DestinationFactoryManagerImpl(bus);
        dfm.registerDestinationFactory("http://jaxws.apache.org/transports/http", sleeTransport);
        dfm.registerDestinationFactory("http://jaxws.apache.org/transports/http/configuration", sleeTransport);

        ConduitInitiatorManager extension = bus.getExtension(ConduitInitiatorManager.class);
        extension.registerConduitInitiator("http://jaxws.apache.org/transports/http", sleeTransport);
        extension.registerConduitInitiator("http://jaxws.apache.org/transports/http/configuration", sleeTransport);

    }

    public SleeHTTPDestination getDestination(String uri) {
        while (sleeDestination == null) {
            throw new NullPointerException("no destination registered for uri : " + uri);
        }

        logger.info("get destination");

        return sleeDestination;
    }

    public static SleeTransportFactory getSleeTransport() {
        logger.info("******** transport ");
        if (sleeTransport == null)
            registerTransport();
        return sleeTransport;
    }

    public static AbstractCXFResourceAdaptor getRa() {
        return ra;
    }

    public static void setRa(AbstractCXFResourceAdaptor ra) {
        SleeTransportFactory.ra = ra;
    }

    public void setDestination(SleeHTTPDestination sleeDestination) {
        this.sleeDestination = sleeDestination;
    }
}
