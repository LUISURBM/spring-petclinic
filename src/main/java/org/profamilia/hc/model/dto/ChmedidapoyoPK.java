package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChmedidapoyoPK implements Serializable {

    /** identifier field */
    private Long hmalconsulta;

    /** identifier field */
    private String hmactiposervi;

    /** identifier field */
    private Integer hmanconsecutiv;


    /** default constructor */
    public ChmedidapoyoPK() {
    }


    public void setHmalconsulta(Long hmalconsulta) {
        this.hmalconsulta = hmalconsulta;
    }

    public Long getHmalconsulta() {
        return hmalconsulta;
    }

    public void setHmactiposervi(String hmactiposervi) {
        this.hmactiposervi = hmactiposervi;
    }

    public String getHmactiposervi() {
        return hmactiposervi;
    }

    public void setHmanconsecutiv(Integer hmanconsecutiv) {
        this.hmanconsecutiv = hmanconsecutiv;
    }

    public Integer getHmanconsecutiv() {
        return hmanconsecutiv;
    }
}
