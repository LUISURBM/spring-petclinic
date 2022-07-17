package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcontrmedicPK implements Serializable {

    /** identifier field */
    private Long hcmlconsulta;

    /** identifier field */
    private Integer hcmnconsecut;

    /** identifier field */
    private Integer hcmnevoluconse;

    /** identifier field */
    private Integer hcmnnumerdosis;


    /** default constructor */
    public ChcontrmedicPK() {
    }


    /**
     * @param hcmlconsulta
     */
    public void setHcmlconsulta(Long hcmlconsulta) {
        this.hcmlconsulta = hcmlconsulta;
    }

    /**
     * @return
     */
    public Long getHcmlconsulta() {
        return hcmlconsulta;
    }

    /**
     * @param hcmnconsecut
     */
    public void setHcmnconsecut(Integer hcmnconsecut) {
        this.hcmnconsecut = hcmnconsecut;
    }

    /**
     * @return
     */
    public Integer getHcmnconsecut() {
        return hcmnconsecut;
    }


    /**
     * @param hcmnevoluconse
     */
    public void setHcmnevoluconse(Integer hcmnevoluconse) {
        this.hcmnevoluconse = hcmnevoluconse;
    }

    /**
     * @return
     */
    public Integer getHcmnevoluconse() {
        return hcmnevoluconse;
    }

    /**
     * @param hcmnnumerdosis
     */
    public void setHcmnnumerdosis(Integer hcmnnumerdosis) {
        this.hcmnnumerdosis = hcmnnumerdosis;
    }

    /**
     * @return
     */
    public Integer getHcmnnumerdosis() {
        return hcmnnumerdosis;
    }
}
