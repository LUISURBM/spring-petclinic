package org.profamilia.hc.model.dto;

import java.math.BigDecimal;


/**
 * 
 */
public class

CcdetasapId implements java.io.Serializable {


    private BigDecimal cdfnnumero;
    private Integer cdfnconsec;


    // Constructors

    /** default constructor */
    public CcdetasapId() {
    }


    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public BigDecimal getCdfnnumero() {
        return this.cdfnnumero;
    }

    public void setCdfnnumero(BigDecimal cdfnnumero) {
        this.cdfnnumero = cdfnnumero;
    }


    public Integer getCdfnconsec() {
        return this.cdfnconsec;
    }

    public void setCdfnconsec(Integer cdfnconsec) {
        this.cdfnconsec = cdfnconsec;
    }


    // no tiene llave compuesta.


}
