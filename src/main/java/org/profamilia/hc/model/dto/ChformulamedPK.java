package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChformulamedPK implements Serializable {

    /** identifier field */
    private Long hfolconsulta;

    /** identifier field */
    private Integer hfonconsecut;




    /** default constructor */
    public ChformulamedPK() {
    }


    public void setHfolconsulta(Long hfolconsulta) {
        this.hfolconsulta = hfolconsulta;
    }

    public Long getHfolconsulta() {
        return hfolconsulta;
    }

    public void setHfonconsecut(Integer hfonconsecut) {
        this.hfonconsecut = hfonconsecut;
    }

    public Integer getHfonconsecut() {
        return hfonconsecut;
    }

}
