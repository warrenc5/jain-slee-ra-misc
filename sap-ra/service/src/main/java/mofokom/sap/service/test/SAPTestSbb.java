package mofokom.sap.service.test;

import javax.slee.*;

import javax.sdp.*;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.slee.facilities.Tracer;

import sap.Announcer;
import sap.event.AnnouncementEvent;

public abstract class SAPTestSbb implements Sbb {

        private Tracer log;
        private SbbContext context;

        public SbbContext getContext() {
                return context;
        }

        public void setSbbContext(javax.slee.SbbContext context) {
                this.context = context;
                log = context.getTracer(context.getSbb().getName());
        }
        public void setTracer(Tracer tracer) {
                log = tracer;
        }

        public void unsetSbbContext() {
        }

        public void sbbCreate() throws javax.slee.CreateException {
        }

        public void sbbPostCreate() throws javax.slee.CreateException {
        }

        public void sbbActivate() {
        }

        public void sbbPassivate() {
        }

        public void sbbLoad() {
        }

        public void sbbStore() {
        }

        public void sbbRemove() {
        }

        public void sbbExceptionThrown(java.lang.Exception exception, java.lang.Object o, javax.slee.ActivityContextInterface aci) {
        }

        public void sbbRolledBack(javax.slee.RolledBackContext context) {
        }

        public void onServiceStarted(javax.slee.serviceactivity.ServiceStartedEvent event, ActivityContextInterface aci) {
                log.info("SAP relay service online");
                //TODO: maybe replay all sessions to stack?
                try {
                        Announcer provider = getProvider();
                        SdpFactory factory = SdpFactory.getInstance();

                        SessionDescription session = factory.createSessionDescription();

                        session.setOrigin(factory.createOrigin("wozza", "localhost"));
                        session.getOrigin().setSessionId(999);
                        log.info("sending " + session.toString());
                        provider.sessionAnnouncement(session);
                } catch (NamingException xN) {
                        xN.printStackTrace();
                } catch (IOException xIO) {
                        xIO.printStackTrace();
                } catch (SdpException xS) {
                        xS.printStackTrace();
                }

                aci.detach(getContext().getSbbLocalObject());
        }

        public void onAnnouncement(AnnouncementEvent event, ActivityContextInterface aci) {
                //TODO maybe store it in a database?
                log.info("onAnnouncement event : " + getCounter());
                log.info("received " + event.getSessionDescription().toString());
                aci.detach(context.getSbbLocalObject());

                if (getCounter() < 3) {
                        setCounter(getCounter() + 1);
                        return;
                }

                try {
                        Announcer provider = getProvider();
                        provider.sessionDeletion(event.getSessionDescription());
                } catch (NamingException xN) {
                        xN.printStackTrace();
                } catch (IOException xIO) {
                        xIO.printStackTrace();
                } catch (SdpException xS) {
                        xS.printStackTrace();
                }
        }

        public void onDeleteAnnouncement(AnnouncementEvent event, ActivityContextInterface aci) {
                //TODO: maybe delte from database if there?

                log.info("onDeleteAnnouncement event");
                /*
                try{
                }catch(NamingException xN){
                xN.printStackTrace();
                }catch(IOException xIO){
                xIO.printStackTrace();
                }catch(SdpException xS){
                xS.printStackTrace();
                }
                 */
        }

        public abstract int getCounter();

        public abstract void setCounter(int i);

        public Announcer getProvider() throws NamingException {
                return (Announcer) new InitialContext().lookup("java:comp/env/slee/resources/sap/1.0.0/sap");
        }
}
