package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChresersangrPK implements Serializable {

    /** identifier field */
    private Long hrslconsulta;

    /** identifier field */
    private String hrsctiposervi;

    /** identifier field */
    private Integer hrscconsecutiv;


    /** default constructor */
    public ChresersangrPK() {
    }


    public void setHrslconsulta(Long hrslconsulta) {
        this.hrslconsulta = hrslconsulta;
    }

    public Long getHrslconsulta() {
        return hrslconsulta;
    }

    public void setHrsctiposervi(String hrsctiposervi) {
        this.hrsctiposervi = hrsctiposervi;
    }

    public String getHrsctiposervi() {
        return hrsctiposervi;
    }

    public void setHrscconsecutiv(Integer hrscconsecutiv) {
        this.hrscconsecutiv = hrscconsecutiv;
    }

    public Integer getHrscconsecutiv() {
        return hrscconsecutiv;
    }
}
