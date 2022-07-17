package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChremihospitPK implements Serializable {

    /** identifier field */
    private Long hrhlconsulta;

    /** identifier field */
    private String hrhctiposervi;

    /** identifier field */
    private Integer hrhnconsecutiv;

    /** default constructor */
    public ChremihospitPK() {
    }


    public void setHrhlconsulta(Long hrhlconsulta) {
        this.hrhlconsulta = hrhlconsulta;
    }

    public Long getHrhlconsulta() {
        return hrhlconsulta;
    }

    public void setHrhctiposervi(String hrhctiposervi) {
        this.hrhctiposervi = hrhctiposervi;
    }

    public String getHrhctiposervi() {
        return hrhctiposervi;
    }

    public void setHrhnconsecutiv(Integer hrhnconsecutiv) {
        this.hrhnconsecutiv = hrhnconsecutiv;
    }

    public Integer getHrhnconsecutiv() {
        return hrhnconsecutiv;
    }
}
