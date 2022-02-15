/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mofokom.megaco.resource;

/**
 *
 * @author wozza
 */
public enum ServiceChangeReason {

    SERVICE_RESTORED("5.2.1", 900),
    COLD_BOOT("5.2.2", 901),
    WARM_BOOT("5.2.3", 902),
    MGC_DIRECTED_CHANGE("5.2.4", 903),
    TERMINATION_MALFUNCTIONING("5.2.5", 904),
    TERMINATION_TAKEN_OUT_OF_SERVICE("5.2.6", 905),
    LOSS_OF_LOWER_LAYER_CONNECTIVITY_DOWNSTREAM_SYNC("5.2.7", 906),
    TRANSMISSION_FAILURE("5.2.8", 907),
    MG_IMPENDING_FAILURE("5.2.9", 908),
    MGC_IMPENDING_FAILURE("5.2.10", 909),
    MEDIA_CAPABILITY_FAILURE("5.2.11", 910),
    MODEM_CAPABILITY_FAILURE("5.2.12", 911),
    MUX_CAPABILITY_FAILURE("5.2.13", 912),
    SIGNAL_CAPABILITY_FAILURE("5.2.14", 913),
    EVENT_CAPABILITY_FAILURE("5.2.15", 914),
    STATE_LOSS("5.2.16", 915),
    PACKAGES_CHANGE("5.2.17", 916),
    CAPABILITIES_CHANGE("5.2.18", 917),
    CANCEL_GRACEFUL("5.2.19", 918),
    WARM_FAILOVER("5.2.20", 919),
    COLD_FAILOVER("5.2.21", 920);
    private String reference;
    private int code;

    private ServiceChangeReason(String reference,int code) {
        this.code=code;
        this.reference=reference;
    }


    public ServiceChangeReason forCode(int code){
        for(ServiceChangeReason e : values()){
            if(e.code == code)
                return e;
        }
        throw new IllegalArgumentException("No service change reason for code : " + code);
    }
}
