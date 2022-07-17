package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChpermitemaPK implements Serializable {

    /** identifier field */
    private Integer hptncodigclini;

    /** identifier field */
    private Integer hptncodigtema;

    /** identifier field */
    private String hptcusuarpamec;

    

    /** default constructor */
    public ChpermitemaPK() {
    }


    /**
     * @param hptncodigclini
     */
    public void setHptncodigclini(Integer hptncodigclini) {
        this.hptncodigclini = hptncodigclini;
    }

    /**
     * @return
     */
    public Integer getHptncodigclini() {
        return hptncodigclini;
    }

    /**
     * @param hptncodigtema
     */
    public void setHptncodigtema(Integer hptncodigtema) {
        this.hptncodigtema = hptncodigtema;
    }

    /**
     * @return
     */
    public Integer getHptncodigtema() {
        return hptncodigtema;
    }

    /**
     * @param hptcusuarpamec
     */
    public void setHptcusuarpamec(String hptcusuarpamec) {
        this.hptcusuarpamec = hptcusuarpamec;
    }

    /**
     * @return
     */
    public String getHptcusuarpamec() {
        return hptcusuarpamec;
    }
}
