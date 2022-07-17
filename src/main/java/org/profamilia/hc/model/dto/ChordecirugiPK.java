package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChordecirugiPK implements Serializable {

    /** identifier field */
    private Long hoclconsulta;

    /** identifier field */
    private String hocctiposervi;

    /** identifier field */
    private Integer hocnconsecutiv;


    /** default constructor */
    public ChordecirugiPK() {
    }


    public void setHoclconsulta(Long hoclconsulta) {
        this.hoclconsulta = hoclconsulta;
    }

    public Long getHoclconsulta() {
        return hoclconsulta;
    }

    public void setHocctiposervi(String hocctiposervi) {
        this.hocctiposervi = hocctiposervi;
    }

    public String getHocctiposervi() {
        return hocctiposervi;
    }

    public void setHocnconsecutiv(Integer hocnconsecutiv) {
        this.hocnconsecutiv = hocnconsecutiv;
    }

    public Integer getHocnconsecutiv() {
        return hocnconsecutiv;
    }
}
