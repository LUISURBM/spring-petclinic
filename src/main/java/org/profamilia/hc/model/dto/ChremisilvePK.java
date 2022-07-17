package org.profamilia.hc.model.dto;

import java.io.Serializable;



/** @author Hibernate CodeGenerator */
public class ChremisilvePK implements Serializable {

    /** identifier field */
    private Long hrilconsulta;

    /** identifier field */
    private String hrictiposerv;

    /** full constructor */
    public ChremisilvePK(Long hrilconsulta, String hrictiposerv) {
        this.hrilconsulta = hrilconsulta;
        this.hrictiposerv = hrictiposerv;
    }

    /** default constructor */
    public ChremisilvePK() {
    }

    /**
     * @return
     */
    public Long getHrilconsulta() {
        return this.hrilconsulta;
    }

    /**
     * @param hrilconsulta
     */
    public void setHrilconsulta(Long hrilconsulta) {
        this.hrilconsulta = hrilconsulta;
    }

    /**
     * @return
     */
    public String getHrictiposerv() {
        return this.hrictiposerv;
    }

    /**
     * @param hrictiposerv
     */
    public void setHrictiposerv(String hrictiposerv) {
        this.hrictiposerv = hrictiposerv;
    }


}
