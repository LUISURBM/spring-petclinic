package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChepicrisiPK implements Serializable {

    /** identifier field */
    private Long heplnumero;

    /** identifier field */
    private Integer hepnconsec; 


    /** default constructor */
    public ChepicrisiPK() {
    }

    /**
     * @return
     */
    public Long getHeplnumero() {
        return this.heplnumero;
    }

    /**
     * @param heplnumero
     */
    public void setHeplnumero(Long heplnumero) {
        this.heplnumero = heplnumero;
    }


    /**
     * @return
     */
    public Long get_heplnumero() {
        return heplnumero;
    }

    /**
     * @param hepnconsec
     */
    public void setHepnconsec(Integer hepnconsec) {
        this.hepnconsec = hepnconsec;
    }

    /**
     * @return
     */
    public Integer getHepnconsec() {
        return hepnconsec;
    }
}
