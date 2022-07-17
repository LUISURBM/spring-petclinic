package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantit implements Serializable {

    /** identifier field */
    private Long haninconsulta;

    /** persistent field */
    private String hanicrefiere;

    /** nullable persistent field */
    private String hanicdesc;

    /** persistent field */
    private Date hanidfecreg;

    /** persistent field */
    private String hanicusuareg;

    /** nullable persistent field */
    private String version;

    /** full constructor */
    public Chantit(Long haninconsulta, String hanicrefiere, String hanicdesc, Date hanidfecreg, String hanicusuareg, String version) {
        this.haninconsulta = haninconsulta;
        this.hanicrefiere = hanicrefiere;
        this.hanicdesc = hanicdesc;
        this.hanidfecreg = hanidfecreg;
        this.hanicusuareg = hanicusuareg;
        this.version = version;
    }

    /** default constructor */
    public Chantit() {
    }

    /** minimal constructor */
    public Chantit(Long haninconsulta, String hanicrefiere, Date hanidfecreg, String hanicusuareg) {
        this.haninconsulta = haninconsulta;
        this.hanicrefiere = hanicrefiere;
        this.hanidfecreg = hanidfecreg;
        this.hanicusuareg = hanicusuareg;
    }

    /** 
     * 		       Consulta asociada
     * 		    
     */
    public Long getHaninconsulta() {
        return this.haninconsulta;
    }

    public void setHaninconsulta(Long haninconsulta) {
        this.haninconsulta = haninconsulta;
    }

    public String getHanicrefiere() {
        return this.hanicrefiere;
    }

    public void setHanicrefiere(String hanicrefiere) {
        this.hanicrefiere = hanicrefiere;
    }

    public String getHanicdesc() {
        return this.hanicdesc;
    }

    public void setHanicdesc(String hanicdesc) {
        this.hanicdesc = hanicdesc;
    }

    public Date getHanidfecreg() {
        return this.hanidfecreg;
    }

    public void setHanidfecreg(Date hanidfecreg) {
        this.hanidfecreg = hanidfecreg;
    }

    public String getHanicusuareg() {
        return this.hanicusuareg;
    }

    public void setHanicusuareg(String hanicusuareg) {
        this.hanicusuareg = hanicusuareg;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("haninconsulta", getHaninconsulta())
            .toString();
    }

}
