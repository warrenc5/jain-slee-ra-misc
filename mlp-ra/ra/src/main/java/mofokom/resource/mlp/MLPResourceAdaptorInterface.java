package mofokom.resource.mlp;

import com.mofokom.j4mlp.element.EmeLia;
import com.mofokom.j4mlp.element.EmeLir;
import com.mofokom.j4mlp.element.Emerep;
import com.mofokom.j4mlp.element.Slia;
import com.mofokom.j4mlp.element.Slir;
import com.mofokom.j4mlp.element.Slirep;
import com.mofokom.j4mlp.element.Tlra;
import com.mofokom.j4mlp.element.Tlrep;
import com.mofokom.j4mlp.element.Tlrr;
import com.mofokom.j4mlp.element.Tlrsa;
import com.mofokom.j4mlp.element.Tlrsr;

public interface MLPResourceAdaptorInterface {


    /*
     *
     The emergency location immediate service is used to retrieve the position of a mobile subscriber that is involved in an
emergency call or have initiated an emergency service in some other way.
The service consists of the following messages:
-   Emergency Location Immediate Request
-   Emergency Location Immediate Answer

     * @see 5.2.3.4 Emergency Location Immediate Service
     */
    MLPActivity sendEmeLir(EmeLir request);
    MLPActivity sendEmeLia(EmeLia request);
    MLPActivity sendEmerep(Emerep request);
    /*
This is a standard service for requesting the location of one or more Mobile Subscribers. The service is used when a location
response is required immediately (within a set time).
When a lot of positioning reports are requested, it may take an unacceptably long time to get all the responses from the
network. If the Location Server supports it the LCS Client can define how to receive the location responses, either at the time
of the response to the request, or individually using one or more connections initiated by the Location Server.
The extended service supports a number of different formats for describing the location of the mobile subscriber. It has also
support for requesting a certain Quality of Service, Type of location and priority.
The service consists of the following messages:
-    Standard Location Immediate Request
-    Standard Location Immediate Answer
-    Standard Location Immediate Report
     *
     * @see 5.2.3.2 Standard Location Immediate Service
     */

    MLPActivity sendSlir(Slir request);
    MLPActivity sendSlia(Slia request);
    MLPActivity sendSlirep(Slirep request);

    /*
     *
     * The triggered location reporting service is used when an application wants the position of several MSs to be tracked. The
triggers could be:
-    The periodicity of reporting defined by an interval time
-    An MS action, defined as the event "UE available" in 3GPP [23.271].
The report will be triggered when one of the pre-defined MS's actions occurred or the time interval elapses. The service
consists of the following messages:
-    Triggered Location Reporting Request
-    Triggered Location Reporting Answer
-    Triggered Location Report
-    Triggered Location Reporting Stop Request
-    Triggered Location Reporting Stop Answer


     * @see 5.2.3.9 Triggered Location Reporting Service
     */

    MLPActivity sendTlrr(Tlrr request);
    MLPActivity sendTla(Tlra request);
    MLPActivity sendTlrep(Tlrep request);
    MLPActivity sendTlrsr(Tlrsr request);
    MLPActivity sendTlrsa(Tlrsa request);

}
