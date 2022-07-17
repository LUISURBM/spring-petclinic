package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChpamecindicPK implements Serializable {

    /** identifier field */
    private Integer hpincodigo;

    /** identifier field */
    private Integer hpincodigtema;

 

    /** default constructor */
    public ChpamecindicPK() {
    }


    /**
     * @param hpincodigo
     */
    public void setHpincodigo(Integer hpincodigo) {
        this.hpincodigo = hpincodigo;
    }

    /**
     * @return
     */
    public Integer getHpincodigo() {
        return hpincodigo;
    }

    /**
     * @param hpincodigtema
     */
    public void setHpincodigtema(Integer hpincodigtema) {
        this.hpincodigtema = hpincodigtema;
    }

    /**
     * @return
     */
    public Integer getHpincodigtema() {
        return hpincodigtema;
    }
}
