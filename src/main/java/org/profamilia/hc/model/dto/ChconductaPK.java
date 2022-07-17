package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChconductaPK implements Serializable {

    /** identifier field */
    private Long hcnlconsulta;

    /** identifier field */
    private String hcnctiposervi;

    /** identifier field */
    private Integer hcnnconsecutiv;


    /** default constructor */
    public ChconductaPK() {
    }


    /**
     * @param hcnlconsulta
     */
    public void setHcnlconsulta(Long hcnlconsulta) {
        this.hcnlconsulta = hcnlconsulta;
    }

    /**
     * @return
     */
    public Long getHcnlconsulta() {
        return hcnlconsulta;
    }

    /**
     * @param hcnctiposervi
     */
    public void setHcnctiposervi(String hcnctiposervi) {
        this.hcnctiposervi = hcnctiposervi;
    }

    /**
     * @return
     */
    public String getHcnctiposervi() {
        return hcnctiposervi;
    }

    /**
     * @param hcnnconsecutiv
     */
    public void setHcnnconsecutiv(Integer hcnnconsecutiv) {
        this.hcnnconsecutiv = hcnnconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHcnnconsecutiv() {
        return hcnnconsecutiv;
    }
}
