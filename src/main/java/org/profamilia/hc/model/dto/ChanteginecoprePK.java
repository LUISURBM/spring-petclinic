package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChanteginecoprePK implements Serializable {

    /** identifier field */
    private Long haglconsulta;

    /** full constructor */
    public ChanteginecoprePK(Long haglconsulta) {
        this.haglconsulta = haglconsulta;
    }

    /** default constructor */
    public ChanteginecoprePK() {
    }

    public Long getHaglconsulta() {
        return this.haglconsulta;
    }

    public void setHaglconsulta(Long haglconsulta) {
        this.haglconsulta = haglconsulta;
    }
 }
