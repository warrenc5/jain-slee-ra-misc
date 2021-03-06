//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.27 at 04:24:15 PM EST 
//


package com.mofokom.j4mlp.element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;choice>
 *           &lt;element ref="{}msids"/>
 *           &lt;sequence maxOccurs="unbounded">
 *             &lt;element ref="{}msid"/>
 *             &lt;element ref="{}gsm_net_param"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element ref="{}qop" minOccurs="0"/>
 *         &lt;element ref="{}geo_info" minOccurs="0"/>
 *         &lt;element ref="{}loc_type" minOccurs="0"/>
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
    "msidAndGsmNetParam",
    "qop",
    "geoInfo",
    "locType"
})
@XmlRootElement(name = "eme_lir")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
public class EmeLir
    implements Serializable, Cloneable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    private final static long serialVersionUID = 1L;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Msids msids;
    @XmlElements({
        @XmlElement(name = "gsm_net_param", type = GsmNetParam.class),
        @XmlElement(name = "msid", type = Msid.class)
    })
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected List<Object> msidAndGsmNetParam;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Qop qop;
    @XmlElement(name = "geo_info")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected CoordinateReferenceSystem geoInfo;
    @XmlElement(name = "loc_type")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected LocType locType;
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
     * Gets the value of the msidAndGsmNetParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msidAndGsmNetParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsidAndGsmNetParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GsmNetParam }
     * {@link Msid }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public List<Object> getMsidAndGsmNetParam() {
        if (msidAndGsmNetParam == null) {
            msidAndGsmNetParam = new ArrayList<Object>();
        }
        return this.msidAndGsmNetParam;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetMsidAndGsmNetParam() {
        return ((this.msidAndGsmNetParam!= null)&&(!this.msidAndGsmNetParam.isEmpty()));
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void unsetMsidAndGsmNetParam() {
        this.msidAndGsmNetParam = null;
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
        buffy.append("EmeLir{");
        buffy.append("msids=");
        if (msids == null) {
            buffy.append("<null>");
        } else {
            buffy.append(msids.toString());
        }
        buffy.append(",");
        buffy.append("msidAndGsmNetParam=");
        if (msidAndGsmNetParam == null) {
            buffy.append("<null>");
        } else {
            buffy.append("[");
            for (Object e: msidAndGsmNetParam) {
                if (e instanceof JAXBElement) {
                    buffy.append((((JAXBElement) e).getValue()+","));
                } else {
                    buffy.append((e.toString()+","));
                }
            }
            buffy.append("]");
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
        buffy.append("locType=");
        if (locType == null) {
            buffy.append("<null>");
        } else {
            buffy.append(locType.toString());
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
