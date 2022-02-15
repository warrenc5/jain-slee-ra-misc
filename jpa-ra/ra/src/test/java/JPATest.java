/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.slee.ServiceID;
import junit.framework.Assert;
import org.junit.Ignore;
import test.jpa.Car;
import test.jpa.Person;
import java.sql.DriverManager;
import java.util.Map;
import java.util.HashMap;
import javax.naming.Context;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.slee.SbbLocalObject;
import java.util.Date;
import test.jpa.MyTestEntity;
import javax.persistence.EntityManager;
import org.junit.Test;
import mofokom.jpa.resource.impl.JPAResourceAdaptor;
import java.util.Arrays;
import javax.slee.resource.ConfigProperties.Property;
import java.security.NoSuchProviderException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import javax.slee.facilities.EventLookupFacility;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.ResourceAdaptorContext;
import javax.slee.resource.SleeEndpoint;
import mofokom.deadlock.DeadlockMain;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.*;

/**
 *
 * @author wozza
 */
public class JPATest {

    private ServiceID testServiceID = new ServiceID("test", "test", "test");

    private ServiceID getTestServiceID() {
        return testServiceID;
    }

    private static class MyDataSource implements javax.sql.DataSource, Remote, Serializable {

        private final Connection conn;

        public MyDataSource(Connection conn) {
            this.conn = conn;
        }

        public Connection getConnection() throws SQLException {
            return conn;
        }

        public Connection getConnection(String username, String password) throws SQLException {
            return conn;
        }

        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        public void setLogWriter(PrintWriter out) throws SQLException {
        }

        public void setLoginTimeout(int seconds) throws SQLException {
        }

        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }
    }
    JPAResourceAdaptor ra;
    ConfigProperties properties;
    Tracer tracer;
    private Properties props;
    private Connection conn;

    public JPATest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws NoSuchProviderException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NamingException, Exception {

        DeadlockMain.deactivate();

        ra = mock(JPAResourceAdaptor.class);
        ResourceAdaptorContext context = mock(ResourceAdaptorContext.class);
        properties = new ConfigProperties();
        SleeEndpoint se = mock(SleeEndpoint.class);
        EventLookupFacility elf = mock(EventLookupFacility.class);
        tracer = mock(Tracer.class);


        // ABSTRACT RA METHODS
        Answer pa = new Answer() {

            public Object answer(InvocationOnMock invocation) throws Throwable {
                LogFactory.getLog("Test").info("-" + Arrays.asList(invocation.getArguments()));
                return null;
            }
        };

        doReturn(Boolean.TRUE).when(tracer).isInfoEnabled();
        doReturn(Boolean.TRUE).when(tracer).isFineEnabled();
        doAnswer(pa).when(tracer).fine(anyString());
        doAnswer(pa).when(tracer).info(anyString());
        doAnswer(pa).when(tracer).info(anyString(), any(Throwable.class));
        doAnswer(pa).when(tracer).warning(anyString());
        doAnswer(pa).when(tracer).severe(anyString(), (Throwable) anyObject());

        doReturn(tracer).when(context).getTracer(anyString());
        doReturn(se).when(context).getSleeEndpoint();
        doReturn(elf).when(context).getEventLookupFacility();

        doCallRealMethod().when(ra).raConfigure(properties);
        doCallRealMethod().when(ra).raActive();
        doCallRealMethod().when(ra).setResourceAdaptorContext((ResourceAdaptorContext) anyObject());
        doCallRealMethod().when(ra).unsetResourceAdaptorContext();
        DataSource ds = setupDB();
        DataSource ds_unmanaged = setupDB();

        final Map<String, DataSource> dsMap = new HashMap<String, DataSource>();
        dsMap.put("openjpa", ds);
        dsMap.put("openjpa2", ds_unmanaged);

        doAnswer(new Answer() {

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                DataSource ds = dsMap.get(invocation.getArguments()[1]);
                Assert.assertFalse(ds.getConnection().isClosed());
                return ds;
            }
        }).when(ra).lookupDataSource(any(Context.class), anyString());

        properties.addProperty(new Property("PERSISTENCE_UNIT_NAME", String.class.getName(), "openjpa"));
        properties.addProperty(new Property("DATASOURCE_NAME", String.class.getName(), "openjpa"));
        properties.addProperty(new Property("DATASOURCE_UNMANAGED_NAME", String.class.getName(), "openjpa2"));
        properties.addProperty(new Property("ACTIVITY_DIMENSION", Integer.class.getName(), 5));
        properties.addProperty(new Property("REMOTE_COMMIT_LISTENER", Boolean.class.getName(), false));
        properties.addProperty(new Property("USE_MANAGED_TRANSACTIONS", Boolean.class.getName(), true));
        //doCallRealMethod().when(ra).getEntityManager(any(ServiceID.class), any(SbbLocalObject.class));
        doCallRealMethod().when(ra).getEntityManagerFactory(any(ServiceID.class), any(SbbLocalObject.class));

        Map configMap = new HashMap();
        configMap.put("openjpa.jdbc.DBDictionary", "derby");
        doReturn(configMap).when(ra).getConfigurationMap();

        // RA SBB INTERFACE METHODS

        /*activityEnded(javax.slee.resource.ActivityHandle);
        activityUnreferenced(javax.slee.resource.ActivityHandle);
        queryLiveness(javax.slee.resource.ActivityHandle);
        getActivity(javax.slee.resource.ActivityHandle);
        getActivityHandle(java.lang.Object);
        getMarshaler();
        fireTimeoutEvent(java.lang.Object);
        doCallRealMethod().when(ra).fireEvent(anyString(),
        statusMessage(int);
        doCallRealMethod().when(ra).update(ie.omk.smpp.Connection,
        administrativeRemove(javax.slee.resource.ActivityHandle);
        eventProcessingFailed(javax.slee.resource.ActivityHandle,
        eventProcessingSuccessful(javax.slee.resource.ActivityHandle,
        eventUnreferenced(javax.slee.resource.ActivityHandle,
        raActive();
        raConfigurationUpdate(javax.slee.resource.ConfigProperties);
        doCallRealMethod().when(ra).raConfigure(javax.slee.resource.ConfigProperties);
        doCallRealMethod().when(ra).raInactive();
        doCallRealMethod().when(ra).raStopping();
        doCallRealMethod().when(ra).raUnconfigure();
        doCallRealMethod().when(ra).raVerifyConfiguration(javax.slee.resource.ConfigProperties)
        serviceActive(javax.slee.resource.ReceivableService);
        serviceStopping(javax.slee.resource.ReceivableService);
        serviceInactive(javax.slee.resource.ReceivableService);
         *
         */

        //START
        ra.setResourceAdaptorContext(context);
        ra.raConfigure(properties);
        ra.raActive();


    }

    @After
    public void tearDown() {
        ra.raUnconfigure();
        ra.raStopping();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException ex) {
        }
        ra.raInactive();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException ex) {
        }

    }
    public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public String protocol = "jdbc:derby:derbyDB;create=true;databaseName=test";

    private DataSource setupDB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NamingException, Exception {
        Class.forName(driver, true, JPATest.class.getClassLoader()).newInstance();
        props = new Properties();
//        props.put("java.naming.factory.initial","com.sun.jndi.rmi.registry.RegistryContextFactory");

        System.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        System.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        //NamingBeanImpl jnpServer = new NamingBeanImpl();
        //jnpServer.start();

        org.apache.derby.jdbc.EmbeddedDataSource eds = new org.apache.derby.jdbc.EmbeddedDataSource();
        conn = DriverManager.getConnection(protocol, props);
        Assert.assertFalse(conn.isClosed());
        MyDataSource myDataSource = new MyDataSource(conn);
        return myDataSource;
        // new InitialContext().bind("MyDataSource", myDataSource);
    }

    @Test
    public void testOneToMany() {
        EntityManager entityManager = ra.getEntityManagerFactory(getTestServiceID(), mock(SbbLocalObject.class)).createEntityManager();
        entityManager.getTransaction().begin();
        Long carId;
        Person p = null;
        Car c = null;

        if (p == null) {
            System.out.println("creating");
            p = new Person();
            p.setName("Warren");
            c = new Car();
            c.setName("VW");
            p.getCars().add(c);
            //entityManager.persist(c);
            entityManager.persist(p);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("created person " + p.getId() + " , car " + c.getId());

        }
        Long pId = p.getId();
        System.out.println("deleting");
        entityManager = ra.getEntityManagerFactory(getTestServiceID(), mock(SbbLocalObject.class)).createEntityManager();
        entityManager.getTransaction().begin();

        p = entityManager.find(Person.class, pId);

        Assert.assertNotNull(p);

        Assert.assertNotNull(p.getCars().get(0));
        Assert.assertNotNull(p.getCars().get(0).getPerson());

        c = p.getCars().remove(0);
        Assert.assertNotNull(c);
        entityManager.remove(c);
        entityManager.merge(p);
        entityManager.getTransaction().commit();
        entityManager.close();

        carId = c.getId();
        System.out.println("deleted car " + carId);

        Assert.assertNotNull(carId);

        entityManager = ra.getEntityManagerFactory(getTestServiceID(), mock(SbbLocalObject.class)).createEntityManager();
        Assert.assertNull(entityManager.find(Car.class, carId));
        entityManager.close();
    }

    @Test
    @Ignore
    public void testRA() {
        EntityManager entityManager = ra.getEntityManagerFactory(getTestServiceID(), mock(SbbLocalObject.class)).createEntityManager();
        MyTestEntity e = entityManager.find(MyTestEntity.class, new Long(1));
        if (e == null) {
            e = new MyTestEntity();
            e.setId(new Long(1));
            System.out.println("!!!!!!!!!!!!!!!!!!!!" + e.getId());
        } else
            System.out.println("******************** " + e.getStamp());

        e.setStamp(new Date());
        entityManager.merge(e);
        entityManager.close();
    }
}
