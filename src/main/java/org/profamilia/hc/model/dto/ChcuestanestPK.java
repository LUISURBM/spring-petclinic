package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcuestanestPK implements Serializable {

    /** identifier field */
    private Long hcalconsulta;

    /** identifier field */
    private String hcactiposerv;

    /** identifier field */
    private Integer hcanconsecut;


    /** default constructor */
    public ChcuestanestPK() {
    }


    /**
     * @param hcalconsulta
     */
    public void setHcalconsulta(Long hcalconsulta) {
        this.hcalconsulta = hcalconsulta;
    }

    /**
     * @return
     */
    public Long getHcalconsulta() {
        return hcalconsulta;
    }

    /**
     * @param hcactiposerv
     */
    public void setHcactiposerv(String hcactiposerv) {
        this.hcactiposerv = hcactiposerv;
    }

    /**
     * @return
     */
    public String getHcactiposerv() {
        return hcactiposerv;
    }

    /**
     * @param hcanconsecut
     */
    public void setHcanconsecut(Integer hcanconsecut) {
        this.hcanconsecut = hcanconsecut;
    }

    /**
     * @return
     */
    public Integer getHcanconsecut() {
        return hcanconsecut;
    }
}
