package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChresulparacPK implements Serializable {

    /** identifier field */
    private Long hrplconsulta;

    /** identifier field */
    private String hrpctiposervi;

    /** default constructor */
    public ChresulparacPK() {
    }


    /**
     * @param hrplconsulta
     */
    public void setHrplconsulta(Long hrplconsulta) {
        this.hrplconsulta = hrplconsulta;
    }

    /**
     * @return
     */
    public Long getHrplconsulta() {
        return hrplconsulta;
    }

    /**
     * @param hrpctiposervi
     */
    public void setHrpctiposervi(String hrpctiposervi) {
        this.hrpctiposervi = hrpctiposervi;
    }

    /**
     * @return
     */
    public String getHrpctiposervi() {
        return hrpctiposervi;
    }
}
