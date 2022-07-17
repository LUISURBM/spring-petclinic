package org.profamilia.hc.model.dto;

import java.io.Serializable;



/** @author Hibernate CodeGenerator */
public class ChimprdiagPK implements Serializable {

    /** identifier field */
    private Long hidlconsulta;

    /** identifier field */
    private String hidctiposervi;
    
    
    /** nullable persistent field */
    private Integer hidnconsecutiv;

 

    /** default constructor */
    public ChimprdiagPK() {
    }


    /**
     * @param hidlconsulta
     */
    public void setHidlconsulta(Long hidlconsulta) {
        this.hidlconsulta = hidlconsulta;
    }

    /**
     * @return
     */
    public Long getHidlconsulta() {
        return hidlconsulta;
    }

    /**
     * @param hidctiposervi
     */
    public void setHidctiposervi(String hidctiposervi) {
        this.hidctiposervi = hidctiposervi;
    }

    /**
     * @return
     */
    public String getHidctiposervi() {
        return hidctiposervi;
    }

    /**
     * @param hidnconsecutiv
     */
    public void setHidnconsecutiv(Integer hidnconsecutiv) {
        this.hidnconsecutiv = hidnconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHidnconsecutiv() {
        return hidnconsecutiv;
    }
}
