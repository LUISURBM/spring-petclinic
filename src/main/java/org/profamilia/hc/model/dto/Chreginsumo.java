package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chreginsumo implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChreginsumoPK id;

    /** persistent field */
    private String hricservicio;

    /** nullable persistent field */
    private String hricobserv;

    /** nullable persistent field */
    private Date hridfecregistr;

    /** persistent field */
    private String hricutilizo;

    /** nullable persistent field */
    private Integer version;
    

    /** default constructor */
    public Chreginsumo() {
    }

    public org.profamilia.hc.model.dto.ChreginsumoPK getId() {
        return this.id;
    }

    public void setId(org.profamilia.hc.model.dto.ChreginsumoPK id) {
        this.id = id;
    }

    public String getHricservicio() {
        return this.hricservicio;
    }

    public void setHricservicio(String hricservicio) {
        this.hricservicio = hricservicio;
    }

    public String getHricobserv() {
        return this.hricobserv;
    }

    public void setHricobserv(String hricdescripc) {
        this.hricobserv = hricdescripc;
    }

    public Date getHridfecregistr() {
        return this.hridfecregistr;
    }

    public void setHridfecregistr(Date hridfecregistr) {
        this.hridfecregistr = hridfecregistr;
    }

    public String getHricutilizo() {
        return this.hricutilizo;
    }

    public void setHricutilizo(String hricutilizo) {
        this.hricutilizo = hricutilizo;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Chreginsumo) ) return false;
        Chreginsumo castOther = (Chreginsumo) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
