package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcertmedicoPK implements Serializable {

    /** identifier field */
    private Long hcmlconsulta;

    /** identifier field */
    private String hcmctipocert;

    /** identifier field */
    private String hcmctiposervi;

    /** identifier field */
    private Integer hcmnconsecutiv;


    /** default constructor */
    public ChcertmedicoPK() {
    }


    public void setHcmlconsulta(Long hcmlconsulta) {
        this.hcmlconsulta = hcmlconsulta;
    }

    public Long getHcmlconsulta() {
        return hcmlconsulta;
    }

    public void setHcmctipocert(String hcmctipocert) {
        this.hcmctipocert = hcmctipocert;
    }

    public String getHcmctipocert() {
        return hcmctipocert;
    }

    public void setHcmctiposervi(String hcmctiposervi) {
        this.hcmctiposervi = hcmctiposervi;
    }

    public String getHcmctiposervi() {
        return hcmctiposervi;
    }

    public void setHcmnconsecutiv(Integer hcmnconsecutiv) {
        this.hcmnconsecutiv = hcmnconsecutiv;
    }

    public Integer getHcmnconsecutiv() {
        return hcmnconsecutiv;
    }
}
