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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for eme_event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eme_event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}eme_pos" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="eme_trigger" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="EME_ORG"/>
 *             &lt;enumeration value="EME_REL"/>
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
@XmlType(name = "eme_event", propOrder = {
    "emePos"
})
@XmlSeeAlso({
    Emerep.class
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
public class EmeEvent
    implements Serializable, Cloneable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "eme_pos", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected List<EmePos> emePos;
    @XmlAttribute(name = "eme_trigger", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    protected String emeTrigger;

    /**
     * Gets the value of the emePos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emePos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmePos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmePos }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public List<EmePos> getEmePos() {
        if (emePos == null) {
            emePos = new ArrayList<EmePos>();
        }
        return this.emePos;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetEmePos() {
        return ((this.emePos!= null)&&(!this.emePos.isEmpty()));
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void unsetEmePos() {
        this.emePos = null;
    }

    /**
     * Gets the value of the emeTrigger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public String getEmeTrigger() {
        return emeTrigger;
    }

    /**
     * Sets the value of the emeTrigger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public void setEmeTrigger(String value) {
        this.emeTrigger = value;
    }

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2013-03-27T04:24:15+11:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-792")
    public boolean isSetEmeTrigger() {
        return (this.emeTrigger!= null);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public String toString() {
        StringBuilder buffy;
        buffy = new StringBuilder();
        buffy.append("EmeEvent{");
        buffy.append("emePos=");
        if (emePos == null) {
            buffy.append("<null>");
        } else {
            buffy.append("[");
            for (Object e: emePos) {
                if (e instanceof JAXBElement) {
                    buffy.append((((JAXBElement) e).getValue()+","));
                } else {
                    buffy.append((e.toString()+","));
                }
            }
            buffy.append("]");
        }
        buffy.append(",");
        buffy.append("emeTrigger=");
        if (emeTrigger == null) {
            buffy.append("<null>");
        } else {
            buffy.append(emeTrigger.toString());
        }
        buffy.append(",");
        buffy.append("}");
        return buffy.toString();
    }

}
