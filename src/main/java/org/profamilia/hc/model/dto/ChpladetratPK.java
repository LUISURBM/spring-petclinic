package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChpladetratPK implements Serializable {

    /** identifier field */
    private Long hptlconsulta;

    /** identifier field */
    private String hptctiposervi;

  

    /** default constructor */
    public ChpladetratPK() {
    }


    /**
     * @param hptlconsulta
     */
    public void setHptlconsulta(Long hptlconsulta) {
        this.hptlconsulta = hptlconsulta;
    }

    /**
     * @return
     */
    public Long getHptlconsulta() {
        return hptlconsulta;
    }

    /**
     * @param hptctiposervi
     */
    public void setHptctiposervi(String hptctiposervi) {
        this.hptctiposervi = hptctiposervi;
    }

    /**
     * @return
     */
    public String getHptctiposervi() {
        return hptctiposervi;
    }
}
