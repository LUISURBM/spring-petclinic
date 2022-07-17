package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChdispoaplicPK implements Serializable {

    /** identifier field */
    private Long hdalconsulta;

    /** identifier field */
    private String hdactiposerv;


    /** default constructor */
    public ChdispoaplicPK() {
    }

    /**
     * @param hdalconsulta
     */
    public void setHdalconsulta(Long hdalconsulta) {
        this.hdalconsulta = hdalconsulta;
    }

    /**
     * @return
     */
    public Long getHdalconsulta() {
        return hdalconsulta;
    }

    /**
     * @param hdactiposerv
     */
    public void setHdactiposerv(String hdactiposerv) {
        this.hdactiposerv = hdactiposerv;
    }

    /**
     * @return
     */
    public String getHdactiposerv() {
        return hdactiposerv;
    }
}
