package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chnoticia implements Serializable {

    /** identifier field */
    private Integer hnoncodnot;

    /** persistent field */
    private String hnocnomnot;

    /** persistent field */
    private String hnoclinnot;

    /** persistent field */
    private String hnocusuareg;

    /** persistent field */
    private Date hnodfecreg;

    /** persistent field */
    private String hnocestado;
    
    /** persistent field */
    private String hnocdesnot;


    /** full constructor */
    public Chnoticia(Integer hnoncodnot, String hnocnomnot, String hnoclinnot, String hnocusuareg, Date hnodfecreg, String hnocestado) {
        this.hnoncodnot = hnoncodnot;
        this.hnocnomnot = hnocnomnot;
        this.hnoclinnot = hnoclinnot;
        this.hnocusuareg = hnocusuareg;
        this.hnodfecreg = hnodfecreg;
        this.hnocestado = hnocestado;
    }

    /** default constructor */
    public Chnoticia() {
    }

    /** 
     * 		       Secuencia noticia
     * 		    
     */
    public Integer getHnoncodnot() {
        return this.hnoncodnot;
    }

    public void setHnoncodnot(Integer hnoncodnot) {
        this.hnoncodnot = hnoncodnot;
    }

    public String getHnocnomnot() {
        return this.hnocnomnot;
    }

    public void setHnocnomnot(String hnocnomnot) {
        this.hnocnomnot = hnocnomnot;
    }

    public String getHnoclinnot() {
        return this.hnoclinnot;
    }

    public void setHnoclinnot(String hnoclinnot) {
        this.hnoclinnot = hnoclinnot;
    }

    public String getHnocusuareg() {
        return this.hnocusuareg;
    }

    public void setHnocusuareg(String hnocusuareg) {
        this.hnocusuareg = hnocusuareg;
    }

    public Date getHnodfecreg() {
        return this.hnodfecreg;
    }

    public void setHnodfecreg(Date hnodfecreg) {
        this.hnodfecreg = hnodfecreg;
    }

    public String getHnocestado() {
        return this.hnocestado;
    }

    public void setHnocestado(String hnocestado) {
        this.hnocestado = hnocestado;
    }
    

    public String toString() {
        return new ToStringBuilder(this)
            .append("hnoncodnot", getHnoncodnot())
            .toString();
    }

    public void setHnocdesnot(String hnocdesnot) {
        this.hnocdesnot = hnocdesnot;
    }

    public String getHnocdesnot() {
        return hnocdesnot;
    }
}
