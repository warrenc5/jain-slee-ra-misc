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
 *         &lt;element ref="{}msid"/>
 *         &lt;choice>
 *           &lt;element ref="{}pd"/>
 *           &lt;element ref="{}poserr"/>
 *         &lt;/choice>
 *         &lt;element ref="{}gsm_net_param" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "msid",
    "pd",
    "poserr",
    "gsmNetParam"
})
@XmlRootElement(name = "pos")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
public class Pos
    implements Serializable, Cloneable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Msid msid;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Pd pd;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected Poserr poserr;
    @XmlElement(name = "gsm_net_param")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected GsmNetParam gsmNetParam;

    /**
     * Gets the value of the msid property.
     * 
     * @return
     *     possible object is
     *     {@link Msid }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Msid getMsid() {
        return msid;
    }

    /**
     * Sets the value of the msid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Msid }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setMsid(Msid value) {
        this.msid = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetMsid() {
        return (this.msid!= null);
    }

    /**
     * Gets the value of the pd property.
     * 
     * @return
     *     possible object is
     *     {@link Pd }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Pd getPd() {
        return pd;
    }

    /**
     * Sets the value of the pd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pd }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setPd(Pd value) {
        this.pd = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetPd() {
        return (this.pd!= null);
    }

    /**
     * Gets the value of the poserr property.
     * 
     * @return
     *     possible object is
     *     {@link Poserr }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public Poserr getPoserr() {
        return poserr;
    }

    /**
     * Sets the value of the poserr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Poserr }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setPoserr(Poserr value) {
        this.poserr = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetPoserr() {
        return (this.poserr!= null);
    }

    /**
     * Gets the value of the gsmNetParam property.
     * 
     * @return
     *     possible object is
     *     {@link GsmNetParam }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public GsmNetParam getGsmNetParam() {
        return gsmNetParam;
    }

    /**
     * Sets the value of the gsmNetParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link GsmNetParam }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setGsmNetParam(GsmNetParam value) {
        this.gsmNetParam = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetGsmNetParam() {
        return (this.gsmNetParam!= null);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public String toString() {
        StringBuilder buffy;
        buffy = new StringBuilder();
        buffy.append("Pos{");
        buffy.append("msid=");
        if (msid == null) {
            buffy.append("<null>");
        } else {
            buffy.append(msid.toString());
        }
        buffy.append(",");
        buffy.append("pd=");
        if (pd == null) {
            buffy.append("<null>");
        } else {
            buffy.append(pd.toString());
        }
        buffy.append(",");
        buffy.append("poserr=");
        if (poserr == null) {
            buffy.append("<null>");
        } else {
            buffy.append(poserr.toString());
        }
        buffy.append(",");
        buffy.append("gsmNetParam=");
        if (gsmNetParam == null) {
            buffy.append("<null>");
        } else {
            buffy.append(gsmNetParam.toString());
        }
        buffy.append(",");
        buffy.append("}");
        return buffy.toString();
    }

}
