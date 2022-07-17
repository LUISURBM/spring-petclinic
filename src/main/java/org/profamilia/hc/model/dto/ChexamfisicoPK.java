package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChexamfisicoPK implements Serializable {

    /** identifier field */
    private Long heflconsulta;

    /** identifier field */
    private String hefctiposervi;
    
    /** identifier field */
    private Integer hefnconsecutiv;



    /** default constructor */
    public ChexamfisicoPK() {
    }


    /**
     * @param heflconsulta
     */
    public void setHeflconsulta(Long heflconsulta) {
        this.heflconsulta = heflconsulta;
    }

    /**
     * @return
     */
    public Long getHeflconsulta() {
        return heflconsulta;
    }

    /**
     * @param hefctiposervi
     */
    public void setHefctiposervi(String hefctiposervi) {
        this.hefctiposervi = hefctiposervi;
    }

    /**
     * @return
     */
    public String getHefctiposervi() {
        return hefctiposervi;
    }

    /**
     * @param hefnconsecutiv
     */
    public void setHefnconsecutiv(Integer hefnconsecutiv) {
        this.hefnconsecutiv = hefnconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHefnconsecutiv() {
        return hefnconsecutiv;
    }
}
