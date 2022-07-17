package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChreferenciaPK implements Serializable {

    /** identifier field */
    private Long hrelconsulta;

    /** identifier field */
    private String hrectiposervi;

    /** identifier field */
    private Integer hrenconsecutiv;


    /** default constructor */
    public ChreferenciaPK() {
    }


    public void setHrelconsulta(Long hrelconsulta) {
        this.hrelconsulta = hrelconsulta;
    }

    public Long getHrelconsulta() {
        return hrelconsulta;
    }

    public void setHrectiposervi(String hrectiposervi) {
        this.hrectiposervi = hrectiposervi;
    }

    public String getHrectiposervi() {
        return hrectiposervi;
    }

    public void setHrenconsecutiv(Integer hrenconsecutiv) {
        this.hrenconsecutiv = hrenconsecutiv;
    }

    public Integer getHrenconsecutiv() {
        return hrenconsecutiv;
    }
}
