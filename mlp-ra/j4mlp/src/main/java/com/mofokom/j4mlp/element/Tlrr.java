//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.27 at 04:24:15 PM EST 
//


package com.mofokom.j4mlp.element;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}msids"/>
 *         &lt;element ref="{}interval" minOccurs="0"/>
 *         &lt;element ref="{}start_time" minOccurs="0"/>
 *         &lt;element ref="{}stop_time" minOccurs="0"/>
 *         &lt;element ref="{}tlrr_event" minOccurs="0"/>
 *         &lt;element ref="{}qop" minOccurs="0"/>
 *         &lt;element ref="{}geo_info" minOccurs="0"/>
 *         &lt;element ref="{}pushaddr" minOccurs="0"/>
 *         &lt;element ref="{}loc_type" minOccurs="0"/>
 *         &lt;element ref="{}prio" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ver" default="3.0.0">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="3.0.0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "msids",
    "interval",
    "startTime",
    "stopTime",
    "tlrrEvent",
    "qop",
    "geoInfo",
    "pushaddr",
    "locType",
    "prio"
})
@XmlRootElement(name = "tlrr")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
public class Tlrr
    implements Serializable, Cloneable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Msids msids;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected String interval;
    @XmlElement(name = "start_time")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected StartTime startTime;
    @XmlElement(name = "stop_time")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected StopTime stopTime;
    @XmlElement(name = "tlrr_event")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected MsAction tlrrEvent;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Qop qop;
    @XmlElement(name = "geo_info")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected CoordinateReferenceSystem geoInfo;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Pushaddr pushaddr;
    @XmlElement(name = "loc_type")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected LocType locType;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Prio prio;
    @XmlAttribute
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected String ver;

    /**
     * Gets the value of the msids property.
     * 
     * @return
     *     possible object is
     *     {@link Msids }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Msids getMsids() {
        return msids;
    }

    /**
     * Sets the value of the msids property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msids }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setMsids(Msids value) {
        this.msids = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetMsids() {
        return (this.msids!= null);
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public String getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setInterval(String value) {
        this.interval = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetInterval() {
        return (this.interval!= null);
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link StartTime }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public StartTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartTime }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setStartTime(StartTime value) {
        this.startTime = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetStartTime() {
        return (this.startTime!= null);
    }

    /**
     * Gets the value of the stopTime property.
     * 
     * @return
     *     possible object is
     *     {@link StopTime }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public StopTime getStopTime() {
        return stopTime;
    }

    /**
     * Sets the value of the stopTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopTime }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setStopTime(StopTime value) {
        this.stopTime = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetStopTime() {
        return (this.stopTime!= null);
    }

    /**
     * Gets the value of the tlrrEvent property.
     * 
     * @return
     *     possible object is
     *     {@link MsAction }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public MsAction getTlrrEvent() {
        return tlrrEvent;
    }

    /**
     * Sets the value of the tlrrEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsAction }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setTlrrEvent(MsAction value) {
        this.tlrrEvent = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetTlrrEvent() {
        return (this.tlrrEvent!= null);
    }

    /**
     * Gets the value of the qop property.
     * 
     * @return
     *     possible object is
     *     {@link Qop }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Qop getQop() {
        return qop;
    }

    /**
     * Sets the value of the qop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Qop }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setQop(Qop value) {
        this.qop = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetQop() {
        return (this.qop!= null);
    }

    /**
     * Gets the value of the geoInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CoordinateReferenceSystem }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public CoordinateReferenceSystem getGeoInfo() {
        return geoInfo;
    }

    /**
     * Sets the value of the geoInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinateReferenceSystem }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setGeoInfo(CoordinateReferenceSystem value) {
        this.geoInfo = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetGeoInfo() {
        return (this.geoInfo!= null);
    }

    /**
     * Gets the value of the pushaddr property.
     * 
     * @return
     *     possible object is
     *     {@link Pushaddr }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Pushaddr getPushaddr() {
        return pushaddr;
    }

    /**
     * Sets the value of the pushaddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pushaddr }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setPushaddr(Pushaddr value) {
        this.pushaddr = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetPushaddr() {
        return (this.pushaddr!= null);
    }

    /**
     * Gets the value of the locType property.
     * 
     * @return
     *     possible object is
     *     {@link LocType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public LocType getLocType() {
        return locType;
    }

    /**
     * Sets the value of the locType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setLocType(LocType value) {
        this.locType = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetLocType() {
        return (this.locType!= null);
    }

    /**
     * Gets the value of the prio property.
     * 
     * @return
     *     possible object is
     *     {@link Prio }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Prio getPrio() {
        return prio;
    }

    /**
     * Sets the value of the prio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prio }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setPrio(Prio value) {
        this.prio = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetPrio() {
        return (this.prio!= null);
    }

    /**
     * Gets the value of the ver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public String getVer() {
        if (ver == null) {
            return "3.0.0";
        } else {
            return ver;
        }
    }

    /**
     * Sets the value of the ver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setVer(String value) {
        this.ver = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetVer() {
        return (this.ver!= null);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public String toString() {
        StringBuilder buffy;
        buffy = new StringBuilder();
        buffy.append("Tlrr{");
        buffy.append("msids=");
        if (msids == null) {
            buffy.append("<null>");
        } else {
            buffy.append(msids.toString());
        }
        buffy.append(",");
        buffy.append("interval=");
        if (interval == null) {
            buffy.append("<null>");
        } else {
            buffy.append(interval.toString());
        }
        buffy.append(",");
        buffy.append("startTime=");
        if (startTime == null) {
            buffy.append("<null>");
        } else {
            buffy.append(startTime.toString());
        }
        buffy.append(",");
        buffy.append("stopTime=");
        if (stopTime == null) {
            buffy.append("<null>");
        } else {
            buffy.append(stopTime.toString());
        }
        buffy.append(",");
        buffy.append("tlrrEvent=");
        if (tlrrEvent == null) {
            buffy.append("<null>");
        } else {
            buffy.append(tlrrEvent.toString());
        }
        buffy.append(",");
        buffy.append("qop=");
        if (qop == null) {
            buffy.append("<null>");
        } else {
            buffy.append(qop.toString());
        }
        buffy.append(",");
        buffy.append("geoInfo=");
        if (geoInfo == null) {
            buffy.append("<null>");
        } else {
            buffy.append(geoInfo.toString());
        }
        buffy.append(",");
        buffy.append("pushaddr=");
        if (pushaddr == null) {
            buffy.append("<null>");
        } else {
            buffy.append(pushaddr.toString());
        }
        buffy.append(",");
        buffy.append("locType=");
        if (locType == null) {
            buffy.append("<null>");
        } else {
            buffy.append(locType.toString());
        }
        buffy.append(",");
        buffy.append("prio=");
        if (prio == null) {
            buffy.append("<null>");
        } else {
            buffy.append(prio.toString());
        }
        buffy.append(",");
        buffy.append("ver=");
        if (ver == null) {
            buffy.append("<null>");
        } else {
            buffy.append(ver.toString());
        }
        buffy.append(",");
        buffy.append("}");
        return buffy.toString();
    }

}