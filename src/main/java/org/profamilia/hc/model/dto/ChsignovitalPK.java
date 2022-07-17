package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChsignovitalPK implements Serializable {

    /** identifier field */
    private Long hsvlconsulta;

    /** identifier field */
    private Integer hsvlconsecutiv;


    /** default constructor */
    public ChsignovitalPK() {
    }

    /**
     * @return
     */
    public Long getHsvlconsulta() {
        return this.hsvlconsulta;
    }

    /**
     * @param hsvlconsulta
     */
    public void setHsvlconsulta(Long hsvlconsulta) {
        this.hsvlconsulta = hsvlconsulta;
    }

    /**
     * @return
     */
    public Integer getHsvlconsecutiv() {
        return this.hsvlconsecutiv;
    }

    /**
     * @param hsvlconsecutiv
     */
    public void setHsvlconsecutiv(Integer hsvlconsecutiv) {
        this.hsvlconsecutiv = hsvlconsecutiv;
    }

  


}
