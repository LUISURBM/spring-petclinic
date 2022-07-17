package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcontmedanePK implements Serializable {

    /** identifier field */
    private Long hmalconsulta;

    /** identifier field */
    private Integer hmanconsecut;

    /** identifier field */
    private String hmactiposerv;

   
    /** default constructor */
    public ChcontmedanePK() {
    }


    /**
     * @param hmalconsulta
     */
    public void setHmalconsulta(Long hmalconsulta) {
        this.hmalconsulta = hmalconsulta;
    }

    /**
     * @return
     */
    public Long getHmalconsulta() {
        return hmalconsulta;
    }

    /**
     * @param hmanconsecut
     */
    public void setHmanconsecut(Integer hmanconsecut) {
        this.hmanconsecut = hmanconsecut;
    }

    /**
     * @return
     */
    public Integer getHmanconsecut() {
        return hmanconsecut;
    }

    /**
     * @param hmactiposerv
     */
    public void setHmactiposerv(String hmactiposerv) {
        this.hmactiposerv = hmactiposerv;
    }

    /**
     * @return
     */
    public String getHmactiposerv() {
        return hmactiposerv;
    }
}
