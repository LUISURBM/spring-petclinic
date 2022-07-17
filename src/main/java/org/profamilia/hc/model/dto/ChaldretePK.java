package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChaldretePK implements Serializable {

    /** identifier field */
    private Long hallconsulta;

    /** identifier field */
    private Integer hallconsecutiv;

    /** default constructor */
    public ChaldretePK() {
    }

    /**
     * @param hallconsulta
     */
    public void setHallconsulta(Long hallconsulta) {
        this.hallconsulta = hallconsulta;
    }

    /**
     * @return
     */
    public Long getHallconsulta() {
        return hallconsulta;
    }

    /**
     * @param hallconsecutiv
     */
    public void setHallconsecutiv(Integer hallconsecutiv) {
        this.hallconsecutiv = hallconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHallconsecutiv() {
        return hallconsecutiv;
    }
}
