/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.slee.Address;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.ReceivableService;
import org.apache.cxf.service.model.BindingInfo;
import org.junit.Test;
import static org.junit.Assert.*;
import mofokom.jaxws.resource.impl.AbstractCXFResourceAdaptor;
import javax.slee.facilities.Tracer;
import javax.slee.resource.*;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Response;
import junit.framework.Assert;
import mofokom.jaxws.resource.impl.AsyncSleeInterceptor;
import mofokom.jaxws.resource.impl.WebServiceActivityImpl;
import mofokom.cxf.transport.slee.SleeHTTPConduit;
import mofokom.cxf.transport.slee.SleeHTTPDestination;
import mofokom.cxf.transport.slee.SleeTransportFactory;
import mofokom.resource.common.AbstractResourceAdaptor;
import mofokom.resource.common.SimpleFuture;
import mofokom.resource.http.common.AbstractHttpResourceAdaptor;
import mofokom.slee.testfw.resource.MockResourceAdaptor;
import org.apache.cxf.binding.http.HttpBindingFactory;
import org.apache.cxf.binding.http.HttpConstants;
import org.apache.cxf.binding.http.URIMapper;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.*;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.support.JaxWsServiceFactoryBean;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.tools.common.ToolConstants;
import org.apache.cxf.tools.common.ToolContext;
import org.apache.cxf.tools.java2wsdl.processor.JavaToWSDLProcessor;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.impl.AddressingPropertiesImpl;
import org.apache.http.nio.protocol.NHttpRequestHandler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author wozza
 */
public class CXFTest {

    static MockResourceAdaptor<AbstractCXFResourceAdaptor, SampleResourceAdaptorInterface, SampleResourceAdaptorUsageParameters, SampleActivityContextInterface> mockRa;
    static ConfigProperties properties;
    static Tracer tracer;

    public CXFTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        mockRa = new MockResourceAdaptor<AbstractCXFResourceAdaptor, SampleResourceAdaptorInterface, SampleResourceAdaptorUsageParameters, SampleActivityContextInterface>(AbstractCXFResourceAdaptor.class, SampleResourceAdaptorInterface.class, SampleResourceAdaptorUsageParameters.class, SampleActivityContextInterface.class) {

            @Override
            public void onAnyEvent(ActivityHandle ah, FireableEventType fet, Object o, Address adrs, ReceivableService rs) {
                tracer.info("Got one " + fet.getEventType().toString() + " " + o.getClass());
                Object activity = mockRa.getResourceAdaptor().getActivity(ah);
                Assert.assertNotNull(o);
                System.out.println("setting for activity : " + activity.hashCode());
                ((SimpleFuture) ((WebServiceActivityImpl) activity).getSynchronousResult()).set(o);
                mockRa.getResourceAdaptor().activityEnded(ah);
            }
        };

        mockRa.configureLogging(CXFTest.class.getClassLoader());
        mockRa.configureFromProperties("raConfig.properties");

        // RA SBB INTERFACE METHODS

        //mockRa.listSbbInterfaceMethods();
        mockRa.doCallRealMethods(AbstractHttpResourceAdaptor.class);
        mockRa.doCallRealMethods(AbstractCXFResourceAdaptor.class);
        mockRa.doCallRealMethods(AbstractResourceAdaptor.class);
        mockRa.doCallRealMethods(NHttpRequestHandler.class);
        mockRa.doCallRealMethods(ResourceAdaptor.class);

        mockRa.start();

        while (!mockRa.getResourceAdaptor().isServerRunning()) {
            mockRa.pause(500L);
        };




        //TODO start listener and test with soap ui

    }

    @AfterClass
    public static void tearDownClass() {
        mockRa.stop();
    }

    @Test
    @Ignore
    public void testTransport() {
        SleeTransportFactory.registerTransport();
    }
    static SampleService implementor;

    @Test
    public void testServerUsingWSFactory() throws InterruptedException {

        final SampleServiceInterface proxy = (SampleServiceInterface) Proxy.newProxyInstance(SampleServiceInterface.class.getClassLoader(), new Class[]{SampleServiceInterface.class}, new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                mockRa.getResourceAdaptor().webserviceOperationRequest(method, args);
                return null;
            }
        });
        Answer answer = new Answer() {

            public Object answer(InvocationOnMock invocation) throws Throwable {
                Method method = proxy.getClass().getMethod(invocation.getMethod().getName(), invocation.getMethod().getParameterTypes());
                return method.invoke(((SampleServiceInterface) proxy), invocation.getArguments());
            }
        };

        implementor = mock(SampleService.class);

        assertNotNull(implementor);

        /*
         * doAnswer(answer).when(implementor).doSomethingSimple();
         * doAnswer(answer).when(implementor).doSomethingResponse(any(SimplePojo.class));
         * doAnswer(answer).when(implementor).doSomething(any(SimplePojo.class));
         *
         */

        doCallRealMethod().when(implementor).doSomethingSimple();
        doCallRealMethod().when(implementor).doSomethingResponse(any(SimplePojo.class));
        doCallRealMethod().when(implementor).doSomething(any(SimplePojo.class));

        ServerFactoryBean svrFactory = new JaxWsServerFactoryBean(new JaxWsServiceFactoryBean() {

            @Override
            protected void initializeDefaultInterceptors() {
            }
        });
//        org.apache.cxf.CXF.EndpointImpl CXFEndpointImpl = (org.apache.CXF.CXF.EndpointImpl)CXFEndpoint;
        svrFactory.setServiceClass(SampleServiceInterface.class);
        svrFactory.setAddress("http://localhost:9000/helloWorld");
        svrFactory.setServiceBean(implementor);

        svrFactory.getInInterceptors().add(new LoggingInInterceptor());
        svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());

        WSAddressingFeature wsAddressingFeature = new WSAddressingFeature();
        wsAddressingFeature.setAddressingRequired(false);
        svrFactory.getFeatures().add(wsAddressingFeature);
        svrFactory.setStart(false);

        Server server = svrFactory.create();
        int index = -1;

        AsyncSleeInterceptor interceptor = null;

        server.getEndpoint().getService().setExecutor(new ThreadPoolExecutor(3, 3, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100)));

        mockRa.getTracer().info("**************" + server.getEndpoint().getService().getInvoker().toString());
//      server.getEndpoint().getService().setInvoker(new NullInvoker(implementor));
        assertNotNull(server);
        SleeHTTPDestination sleeDestination = (SleeHTTPDestination) server.getDestination();
        assertNotNull(sleeDestination);

        mockRa.getResourceAdaptor().getTransportFactory().setDestination(sleeDestination);
        /*
         * ServerConfig serverConfig = new ServerConfig();
         * serverConfig.setMessageTimeToLive(1000);
         * jmsDestination.setServerConfig(serverConfig);
         *
         */

        List<Interceptor<? extends Message>> in = server.getEndpoint().getInInterceptors();
        List<Interceptor<? extends Message>> out = server.getEndpoint().getOutInterceptors();

//        tracer.info("in->"+in.toString());
        //       tracer.info("out->" +out.toString());
        for (Interceptor i : in) {
            if (i instanceof ServiceInvokerInterceptor)
                index = in.indexOf(i);
        }
        if (index == -1)
            in.add(interceptor = new AsyncSleeInterceptor(mockRa.getResourceAdaptor()));
        else
            in.set(index, interceptor = new AsyncSleeInterceptor(mockRa.getResourceAdaptor()));
        in.add(new OutgoingChainInterceptor());
        in.add(new OneWayProcessorInterceptor());
        /*
         * index = -1;
         * for (Interceptor i : out) {
         * if (i instanceof ServiceInvokerInterceptor)
         * index = out.indexOf(i);
         * }
         * if (index == -1)
         * out.add(interceptor);
         * else
         * out.set(index, interceptor);
         *
         */
        server.start();

//        Assert.assertNotNull(implementor.getWsContext());
        //       Assert.assertNull(implementor.getWsContext().getMessageContext());
        mockRa.pause(2500L);

        testQuickClient();
    }

    @Test
    @Ignore
    public void testPublish() {
        System.out.println("Starting Server");
        SampleService implementor = new SampleService();
        String address = "http://localhost:9000/helloWorld";
        Endpoint.publish(address, implementor);
    }

    @Test
    @Ignore
    public void generateWSDL() throws IOException {
        testTransport();

        JavaToWSDLProcessor javaToWSDL = new JavaToWSDLProcessor();

        File tmpDir = new File(System.getProperty("java.io.tmpdir"));

        assertTrue(tmpDir.exists());


        File f = new File(tmpDir, SampleServiceInterface.class.getName());
        f.mkdir();
        assertTrue(f.isDirectory());
        assertTrue(f.exists());

        System.out.println(f.getAbsolutePath());

        ToolContext env = new ToolContext();
        env.put(ToolConstants.CFG_OUTPUTDIR, f.getAbsolutePath());
        env.put(ToolConstants.CFG_CREATE_XSD_IMPORTS, Boolean.TRUE);
        env.put(ToolConstants.CFG_CLASSNAME, SampleServiceInterface.class.getName());
        env.put(ToolConstants.CFG_SOAP12, Boolean.TRUE);
        env.put(ToolConstants.CFG_ADDRESS, "http://localhost:9000/helloWorld");

        env.put(ToolConstants.CFG_WSDL, Boolean.TRUE);
        javaToWSDL.setEnvironment(env);
        //javaToWSDL.generate(server.getEndpoint().getService().getServiceInfos().get(0), f);
        javaToWSDL.process();

        assertTrue(f.exists());
        assertTrue(f.length() > 0);

        /*
         * <arg value="-o"/>
         * <arg value="hello.wsdl"/>
         * <arg value="service.Greeter"/>
         * <classpath>
         * <path refid="CXF.classpath"/>
         * </classpath>
         * </java>
         *
         */
    }

    //@Test
    public void testQuickClient() throws InterruptedException {
        Thread t = new Thread() {

            public void run() {
                mockRa.pause(1000L);
                JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
                factory.getInInterceptors().add(new LoggingInInterceptor());
                factory.getOutInterceptors().add(new LoggingOutInterceptor());

                factory.setServiceClass(SampleServiceClientAsyncInterface.class);
                factory.setAddress("http://localhost:9000/helloWorld");
                boolean useAddressing = false;
                if (useAddressing) {
                    WSAddressingFeature wsaf = new WSAddressingFeature();
                    factory.getFeatures().add(wsaf);

                }


                //String messageId = new AttributedURIType().setValue(null);
                //maps.setMessageID(messageId);

                //factory.getInInterceptors().add(new DatabindingInSetupInterceptor());
                //factory.getOutInterceptors().add(new DatabindingOutSetupInterceptor());

                //factory.setAddress("slee://");
                final SampleServiceClientAsyncInterface sampleService = (SampleServiceClientAsyncInterface) factory.create();
                Assert.assertNotNull(sampleService);

                Client client = ClientProxy.getClient(sampleService);
                ((Client) client).getRequestContext().put("ACTIVITY", "HELLO :)");
                Conduit conduit = client.getConduit();

                // client.getInInterceptors().add(new DatabindingInSetupInterceptor());
                //client.getOutInterceptors().add(new DatabindingOutSetupInterceptor());
                URIMapper mapper = new URIMapper();
                client.getEndpoint().getService().setExecutor(new ThreadPoolExecutor(3, 3, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100)));

                if (useAddressing) {
                    AddressingProperties maps = new AddressingPropertiesImpl();
                    EndpointReferenceType ref = new EndpointReferenceType();
                    AttributedURIType add = new AttributedURIType();
                    add.setValue("http://localhost:9000/decoupled_endpoint");
                    ref.setAddress(add);
                    maps.setReplyTo(ref);
                    maps.setFaultTo(ref);
                    client.getRequestContext().put("javax.xml.ws.addressing.context", maps);
                }

                HttpBindingFactory bfactory = new HttpBindingFactory();
                BindingInfo bi = bfactory.createBindingInfo(client.getEndpoint().getService(), client.getEndpoint().getService().getName().getNamespaceURI(), HttpConstants.POST);

                for (BindingOperationInfo info : bi.getOperations()) {
                    mapper.bind(info, info.getName().getNamespaceURI(), HttpConstants.POST);
                }


                client.getEndpoint().getService().put(URIMapper.class.getName(), mapper);


                Assert.assertNotNull(conduit);
                Assert.assertNotNull(client);

                /*
                 * Object reply1 = sampleService.doSomethingSimple();
                 * verify(implementor,atLeastOnce()).doSomethingSimple();
                 *
                 * System.err.println("REPLY:" + reply1);
                 * Assert.assertNotNull(reply1);
                 *
                 */

                String request = "HHEEEEEEY :):):):):):):)";
                SimplePojo reply = null;


                Response<SimplePojo> response = null;

                try {
                    response = sampleService.doSomethingAsync(new SimplePojo(request));
                    response.get(5000, TimeUnit.MILLISECONDS);
                } catch (Exception x) {
                    mockRa.getTracer().info("EEk", x);
                }

                Future<?> replyFuture = null;
                AsyncHandler async = new AsyncHandler() {

                    public void handleResponse(Response res) {
                        mockRa.getTracer().info("ok %%% response" + res.toString());
                    }
                };

                try {
                    replyFuture = sampleService.doSomethingAsync(new SimplePojo(request), async);
                    replyFuture.get(3000, TimeUnit.MILLISECONDS);
                } catch (Exception x) {
                    mockRa.getTracer().info("EEk", x);
                }

                verify(implementor, atLeastOnce()).doSomething(any(SimplePojo.class));
                System.err.println("1st REPLY:" + reply);

                try {
                    reply = sampleService.doSomething(new SimplePojo(request));
                } catch (Exception x) {
                    mockRa.getTracer().info("EEk", x);
                }

                verify(implementor, atLeastOnce()).doSomething(any(SimplePojo.class));
                System.err.println("2nd REPLY:" + reply);

                Thread.dumpStack();
                Assert.assertNotNull(reply);
                Assert.assertNotNull(reply.getValue());
                Assert.assertEquals(reply.getValue(), request);
            }
        };
        t.start();
        t.join();
    }

    @Test
    @Ignore
    public void testClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(SampleServiceInterface.class);
        factory.setAddress("http://localhost:9000/helloWorld");

        //factory.setAddress("slee://");
        SampleServiceInterface sampleService = (SampleServiceInterface) factory.create();
        Assert.assertNotNull(sampleService);

        Client client = ClientProxy.getClient(sampleService);
        SleeHTTPConduit conduit = (SleeHTTPConduit) client.getConduit();

        Assert.assertNotNull(conduit);
        Assert.assertNotNull(client);

        //Object reply = sampleService.doSomething();
        //System.err.println("REPLY:" + reply);
        //Assert.assertNotNull(reply);
    }

    @Test
    @Ignore
    public void waitForClient() throws InterruptedException {
        this.testServerUsingWSFactory();
        mockRa.pause(30000L);
    }
}
