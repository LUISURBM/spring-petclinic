package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class CpservanexPK implements Serializable {

    /** identifier field */
    private String csacservic;

    /** identifier field */
    private String csacserane;



    /** default constructor */
    public CpservanexPK() {
    }

    /**
     * @return
     */
    public String getCsacservic() {
        return this.csacservic;
    }

    /**
     * @param csacservic
     */
    public void setCsacservic(String csacservic) {
        this.csacservic = csacservic;
    }

    /**
     * @return
     */
    public String getCsacserane() {
        return this.csacserane;
    }

    /**
     * @param csacserane
     */
    public void setCsacserane(String csacserane) {
        this.csacserane = csacserane;
    }

}
