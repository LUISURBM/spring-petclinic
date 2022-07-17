package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChdetaldescrPK implements Serializable {

    /** identifier field */
    private Long hddlnumero;
    
    
    /** persistent field */
    private Integer hddnconsec; 


    /** default constructor */
    public ChdetaldescrPK() {
    }


    /**
     * @param hddlnumero
     */
    public void setHddlnumero(Long hddlnumero) {
        this.hddlnumero = hddlnumero;
    }

    /**
     * @return
     */
    public Long getHddlnumero() {
        return hddlnumero;
    }

    /**
     * @param hddnconsec
     */
    public void setHddnconsec(Integer hddnconsec) {
        this.hddnconsec = hddnconsec;
    }

    /**
     * @return
     */
    public Integer getHddnconsec() {
        return hddnconsec;
    }
}
