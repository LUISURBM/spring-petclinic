package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChformulaespPK implements Serializable {

    /** identifier field */
    private Long hfelconsulta;

    /** identifier field */
    private Integer hfenconsecut;

    /** identifier field */
    private String hfectiposerv;

    /** identifier field */
    private Integer hfenllave;


    /** default constructor */
    public ChformulaespPK() {
    }


    /**
     * @param hfelconsulta
     */
    public void setHfelconsulta(Long hfelconsulta) {
        this.hfelconsulta = hfelconsulta;
    }

    /**
     * @return
     */
    public Long getHfelconsulta() {
        return hfelconsulta;
    }

    /**
     * @param hfenconsecut
     */
    public void setHfenconsecut(Integer hfenconsecut) {
        this.hfenconsecut = hfenconsecut;
    }

    /**
     * @return
     */
    public Integer getHfenconsecut() {
        return hfenconsecut;
    }

    /**
     * @param hfectiposerv
     */
    public void setHfectiposerv(String hfectiposerv) {
        this.hfectiposerv = hfectiposerv;
    }

    /**
     * @return
     */
    public String getHfectiposerv() {
        return hfectiposerv;
    }

    /**
     * @param hfenllave
     */
    public void setHfenllave(Integer hfenllave) {
        this.hfenllave = hfenllave;
    }

    /**
     * @return
     */
    public Integer getHfenllave() {
        return hfenllave;
    }
}
