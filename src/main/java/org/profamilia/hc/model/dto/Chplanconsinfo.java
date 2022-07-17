package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chplanconsinfo implements Serializable {

    /** identifier field */
    private Long hpcinconsec;

    /** nullable persistent field */
    private String hpciccodigo;

    /** nullable persistent field */
    private String hpcicnombre;

    /** nullable persistent field */
    private String hpcicestado;

    /** nullable persistent field */
    private Date hpcidfechregi;

    /** nullable persistent field */
    private String hpcicusuaregi;

    /** nullable persistent field */
    private Integer version;
    
    private boolean modoconsulta;

    /** full constructor */
    public Chplanconsinfo(Long hpcinconsec, String hpciccodigo, String hpcicnombre, String hpcicestado, Date hpcidfechregi, String hpcicusuaregi, Integer version) {
        this.hpcinconsec = hpcinconsec;
        this.hpciccodigo = hpciccodigo;
        this.hpcicnombre = hpcicnombre;
        this.hpcicestado = hpcicestado;
        this.hpcidfechregi = hpcidfechregi;
        this.hpcicusuaregi = hpcicusuaregi;
        this.version = version;
    }

    /** default constructor */
    public Chplanconsinfo() {
    }

    /** minimal constructor */
    public Chplanconsinfo(Long hpcinconsec) {
        this.hpcinconsec = hpcinconsec;
    }

    public Long getHpcinconsec() {
        return this.hpcinconsec;
    }

    public void setHpcinconsec(Long hpcinconsec) {
        this.hpcinconsec = hpcinconsec;
    }

    public String getHpciccodigo() {
        return this.hpciccodigo;
    }

    public void setHpciccodigo(String hpciccodigo) {
        this.hpciccodigo = hpciccodigo;
    }

    public String getHpcicnombre() {
        return this.hpcicnombre;
    }

    public void setHpcicnombre(String hpcicnombre) {
        this.hpcicnombre = hpcicnombre;
    }

    public String getHpcicestado() {
        return this.hpcicestado;
    }

    public void setHpcicestado(String hpcicestado) {
        this.hpcicestado = hpcicestado;
    }

    public Date getHpcidfechregi() {
        return this.hpcidfechregi;
    }

    public void setHpcidfechregi(Date hpcidfechregi) {
        this.hpcidfechregi = hpcidfechregi;
    }

    public String getHpcicusuaregi() {
        return this.hpcicusuaregi;
    }

    public void setHpcicusuaregi(String hpcicusuaregi) {
        this.hpcicusuaregi = hpcicusuaregi;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hpcinconsec", getHpcinconsec())
            .toString();
    }

    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    public boolean isModoconsulta() {
        return modoconsulta;
    }
}
