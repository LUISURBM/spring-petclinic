package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChproceconsuPK implements Serializable {

    /** identifier field */
    private Long hpclconsulta;

    /** identifier field */
    private String hpcctiposervi;


    /** default constructor */
    public ChproceconsuPK() {
    }


    public void setHpclconsulta(Long hpclconsulta) {
        this.hpclconsulta = hpclconsulta;
    }

    public Long getHpclconsulta() {
        return hpclconsulta;
    }

    public void setHpcctiposervi(String hpcctiposervi) {
        this.hpcctiposervi = hpcctiposervi;
    }

    public String getHpcctiposervi() {
        return hpcctiposervi;
    }
}
