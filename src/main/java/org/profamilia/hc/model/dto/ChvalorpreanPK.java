package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChvalorpreanPK implements Serializable {

    /** identifier field */
    private Long hvplconsulta;

    /** identifier field */
    private String hvpctiposerv;


    /** default constructor */
    public ChvalorpreanPK() {
    }


    /**
     * @param hvplconsulta
     */
    public void setHvplconsulta(Long hvplconsulta) {
        this.hvplconsulta = hvplconsulta;
    }

    /**
     * @return
     */
    public Long getHvplconsulta() {
        return hvplconsulta;
    }


    /**
     * @param hvpctiposerv
     */
    public void setHvpctiposerv(String hvpctiposerv) {
        this.hvpctiposerv = hvpctiposerv;
    }

    /**
     * @return
     */
    public String getHvpctiposerv() {
        return hvpctiposerv;
    }


}
