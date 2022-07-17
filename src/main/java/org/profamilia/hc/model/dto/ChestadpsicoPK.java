package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChestadpsicoPK implements Serializable {

    /** identifier field */
    private Long heplconsulta;

    /** identifier field */
    private String hepctiposerv;

  
    /** default constructor */
    public ChestadpsicoPK() {
    }


    /**
     * @param heplconsulta
     */
    public void setHeplconsulta(Long heplconsulta) {
        this.heplconsulta = heplconsulta;
    }

    /**
     * @return
     */
    public Long getHeplconsulta() {
        return heplconsulta;
    }

    /**
     * @param hepctiposerv
     */
    public void setHepctiposerv(String hepctiposerv) {
        this.hepctiposerv = hepctiposerv;
    }

    /**
     * @return
     */
    public String getHepctiposerv() {
        return hepctiposerv;
    }
}
