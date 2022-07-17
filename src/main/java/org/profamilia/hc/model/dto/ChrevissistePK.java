package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChrevissistePK implements Serializable {

    /** identifier field */
    private Long hrslconsulta;

    /** identifier field */
    private String hrsctiposervi;


    /**
     * @param hrslconsulta
     */
    public void setHrslconsulta(Long hrslconsulta) {
        this.hrslconsulta = hrslconsulta;
    }

    /**
     * @return
     */
    public Long getHrslconsulta() {
        return hrslconsulta;
    }

    /**
     * @param hrsctiposervi
     */
    public void setHrsctiposervi(String hrsctiposervi) {
        this.hrsctiposervi = hrsctiposervi;
    }

    /**
     * @return
     */
    public String getHrsctiposervi() {
        return hrsctiposervi;
    }
}
