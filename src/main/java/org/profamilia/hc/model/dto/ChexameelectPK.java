package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChexameelectPK implements Serializable {

    /** identifier field */
    private Long heelconsulta;

    /** identifier field */
    private Integer heenconsecuti;

    /** identifier field */
    private String heectiposervi;

    /** identifier field */
    private Integer heenllave;


    /** default constructor */
    public ChexameelectPK() {
    }


    public void setHeelconsulta(Long heelconsulta) {
        this.heelconsulta = heelconsulta;
    }

    public Long getHeelconsulta() {
        return heelconsulta;
    }

    public void setHeenconsecuti(Integer heenconsecuti) {
        this.heenconsecuti = heenconsecuti;
    }

    public Integer getHeenconsecuti() {
        return heenconsecuti;
    }

    public void setHeectiposervi(String heectiposervi) {
        this.heectiposervi = heectiposervi;
    }

    public String getHeectiposervi() {
        return heectiposervi;
    }

    public void setHeenllave(Integer heenllave) {
        this.heenllave = heenllave;
    }

    public Integer getHeenllave() {
        return heenllave;
    }
}
