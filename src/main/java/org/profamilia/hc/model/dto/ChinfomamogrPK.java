package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChinfomamogrPK implements Serializable {

    /** identifier field */
    private Long himlconsulta;

    /** identifier field */
    private String himctipoinform;

    /** identifier field */
    private String himctiposervi;

    /** full constructor */
    public ChinfomamogrPK(Long himlconsulta, String himctipoinform, 
                          String himctiposervi) {
        this.himlconsulta = himlconsulta;
        this.himctipoinform = himctipoinform;
        this.himctiposervi = himctiposervi;
    }

    /** default constructor */
    public ChinfomamogrPK() {
    }

    public Long getHimlconsulta() {
        return this.himlconsulta;
    }

    public void setHimlconsulta(Long himlconsulta) {
        this.himlconsulta = himlconsulta;
    }

    public String getHimctipoinform() {
        return this.himctipoinform;
    }

    public void setHimctipoinform(String himctipoinform) {
        this.himctipoinform = himctipoinform;
    }

    public String getHimctiposervi() {
        return this.himctiposervi;
    }

    public void setHimctiposervi(String himctiposervi) {
        this.himctiposervi = himctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("himlconsulta", 
                                                getHimlconsulta()).append("himctipoinform", 
                                                                          getHimctipoinform()).append("himctiposervi", 
                                                                                                      getHimctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChinfomamogrPK))
            return false;
        ChinfomamogrPK castOther = (ChinfomamogrPK)other;
        return new EqualsBuilder().append(this.getHimlconsulta(), 
                                          castOther.getHimlconsulta()).append(this.getHimctipoinform(), 
                                                                              castOther.getHimctipoinform()).append(this.getHimctiposervi(), 
                                                                                                                    castOther.getHimctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHimlconsulta()).append(getHimctipoinform()).append(getHimctiposervi()).toHashCode();
    }

}
