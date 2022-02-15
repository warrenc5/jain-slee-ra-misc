/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mofokom.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author wozza
 */
@Entity(name="MyTestEntity")
@Table(name="MyTestEntity" )
public class MyTestEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String Other;

    /**
     * Get the value of Other
     *
     * @return the value of Other
     */
    public String getOther() {
        return Other;
    }

    /**
     * Set the value of Other
     *
     * @param Other new value of Other
     */
    public void setOther(String Other) {
        this.Other = Other;
    }

    protected String value;

    /**
     * Get the value of value
     *
     * @return the value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of value
     *
     * @param value new value of value
     */
    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date stamp;

    /**
     * Get the value of stamp
     *
     * @return the value of stamp
     */
    public Date getStamp() {
        return stamp;
    }

    /**
     * Set the value of stamp
     *
     * @param stamp new value of stamp
     */
    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyTestEntity))
            return false;
        MyTestEntity other = (MyTestEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "test.jpa.MyTestEntity[id=" + id + "]";
    }

}
