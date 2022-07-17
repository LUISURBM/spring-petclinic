package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChitemmaterPK implements Serializable {

    /** identifier field */
    private Long himlcodiginstr;

    /** identifier field */
    private Integer himncodigmater;



    /** default constructor */
    public ChitemmaterPK() {
    }

    /**
     * @return
     */
    public Long getHimlcodiginstr() {
        return this.himlcodiginstr;
    }

    /**
     * @param himlcodiginstr
     */
    public void setHimlcodiginstr(Long himlcodiginstr) {
        this.himlcodiginstr = himlcodiginstr;
    }

    /**
     * @return
     */
    public Integer getHimncodigmater() {
        return this.himncodigmater;
    }

    /**
     * @param himncodigmater
     */
    public void setHimncodigmater(Integer himncodigmater) {
        this.himncodigmater = himncodigmater;
    }


}
