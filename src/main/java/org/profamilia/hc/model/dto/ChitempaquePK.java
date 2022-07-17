package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChitempaquePK implements Serializable {

    /** identifier field */
    private Long hiplcodiginstr;

    /** identifier field */
    private Integer hipncodigpaque;


    /** default constructor */
    public ChitempaquePK() {
    }

    /**
     * @param hiplcodiginstr
     */
    public void setHiplcodiginstr(Long hiplcodiginstr) {
        this.hiplcodiginstr = hiplcodiginstr;
    }

    /**
     * @return
     */
    public Long getHiplcodiginstr() {
        return hiplcodiginstr;
    }

    /**
     * @param hipncodigpaque
     */
    public void setHipncodigpaque(Integer hipncodigpaque) {
        this.hipncodigpaque = hipncodigpaque;
    }

    /**
     * @return
     */
    public Integer getHipncodigpaque() {
        return hipncodigpaque;
    }
}
