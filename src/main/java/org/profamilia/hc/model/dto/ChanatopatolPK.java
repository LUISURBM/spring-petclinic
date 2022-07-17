package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChanatopatolPK implements Serializable {

    /** identifier field */
    private Long haplconsulta;

    /** identifier field */
    private String hapctiposervi;

    /** identifier field */
    private Integer hapnconsecutiv;


    /** default constructor */
    public ChanatopatolPK() {
    }


    public void setHaplconsulta(Long haplconsulta) {
        this.haplconsulta = haplconsulta;
    }

    public Long getHaplconsulta() {
        return haplconsulta;
    }

    public void setHapctiposervi(String hapctiposervi) {
        this.hapctiposervi = hapctiposervi;
    }

    public String getHapctiposervi() {
        return hapctiposervi;
    }

    public void setHapnconsecutiv(Integer hapnconsecutiv) {
        this.hapnconsecutiv = hapnconsecutiv;
    }

    public Integer getHapnconsecutiv() {
        return hapnconsecutiv;
    }
}
