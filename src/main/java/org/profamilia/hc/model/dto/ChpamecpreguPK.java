package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChpamecpreguPK implements Serializable {

    /** identifier field */
    private Integer hppncodigo;

    /** identifier field */
    private Integer hppncodigtema;

    /** identifier field */
    private Integer hppncodigindic;

  

    /** default constructor */
    public ChpamecpreguPK() {
    }


    /**
     * @param hppncodigo
     */
    public void setHppncodigo(Integer hppncodigo) {
        this.hppncodigo = hppncodigo;
    }

    /**
     * @return
     */
    public Integer getHppncodigo() {
        return hppncodigo;
    }

    /**
     * @param hppncodigtema
     */
    public void setHppncodigtema(Integer hppncodigtema) {
        this.hppncodigtema = hppncodigtema;
    }

    /**
     * @return
     */
    public Integer getHppncodigtema() {
        return hppncodigtema;
    }

    /**
     * @param hppncodigindic
     */
    public void setHppncodigindic(Integer hppncodigindic) {
        this.hppncodigindic = hppncodigindic;
    }

    /**
     * @return
     */
    public Integer getHppncodigindic() {
        return hppncodigindic;
    }
}
