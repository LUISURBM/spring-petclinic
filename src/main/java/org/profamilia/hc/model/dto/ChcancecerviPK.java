package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcancecerviPK implements Serializable {

    /** identifier field */
    private Long hcclconsulta;

    /** identifier field */
    private String hccctiposerv;

    /** default constructor */
    public ChcancecerviPK() {
    }


    /**
     * @param hcclconsulta
     */
    public void setHcclconsulta(Long hcclconsulta) {
        this.hcclconsulta = hcclconsulta;
    }

    /**
     * @return
     */
    public Long getHcclconsulta() {
        return hcclconsulta;
    }

    /**
     * @param hccctiposerv
     */
    public void setHccctiposerv(String hccctiposerv) {
        this.hccctiposerv = hccctiposerv;
    }

    /**
     * @return
     */
    public String getHccctiposerv() {
        return hccctiposerv;
    }
}
