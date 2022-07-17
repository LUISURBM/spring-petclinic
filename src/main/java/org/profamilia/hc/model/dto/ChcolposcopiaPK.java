package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcolposcopiaPK implements Serializable {


    /** identifier field */
    private Long hcllconsulta;

    /** identifier field */
    private String hclctiposervi;


    public ChcolposcopiaPK() {
    }

    /**
     * @param hcllconsulta
     */
    public void setHcllconsulta(Long hcllconsulta) {
        this.hcllconsulta = hcllconsulta;
    }

    /**
     * @return
     */
    public Long getHcllconsulta() {
        return hcllconsulta;
    }

    /**
     * @param hclctiposervi
     */
    public void setHclctiposervi(String hclctiposervi) {
        this.hclctiposervi = hclctiposervi;
    }

    /**
     * @return
     */
    public String getHclctiposervi() {
        return hclctiposervi;
    }
}
