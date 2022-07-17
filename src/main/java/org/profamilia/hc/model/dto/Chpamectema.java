package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpamectema implements Serializable {

    /** identifier field */
    private Integer hptncodigo;

    /** persistent field */
    private String hptcdescripcio;

    /** nullable persistent field */
    private String hptcestado;

    /** nullable persistent field */
    private Date hptdfecregistr;

    /** nullable persistent field */
    private String hptcoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private Boolean renderTema;

   
    /** default constructor */
    public Chpamectema() {
    }


    /**
     * @param hptncodigo
     */
    public void setHptncodigo(Integer hptncodigo) {
        this.hptncodigo = hptncodigo;
    }

    /**
     * @return
     */
    public Integer getHptncodigo() {
        return hptncodigo;
    }

    /**
     * @param hptcdescripcio
     */
    public void setHptcdescripcio(String hptcdescripcio) {
        this.hptcdescripcio = hptcdescripcio;
    }

    /**
     * @return
     */
    public String getHptcdescripcio() {
        return hptcdescripcio;
    }

    /**
     * @param hptcestado
     */
    public void setHptcestado(String hptcestado) {
        this.hptcestado = hptcestado;
    }

    /**
     * @return
     */
    public String getHptcestado() {
        return hptcestado;
    }

    /**
     * @param hptdfecregistr
     */
    public void setHptdfecregistr(Date hptdfecregistr) {
        this.hptdfecregistr = hptdfecregistr;
    }

    /**
     * @return
     */
    public Date getHptdfecregistr() {
        return hptdfecregistr;
    }

    /**
     * @param hptcoperador
     */
    public void setHptcoperador(String hptcoperador) {
        this.hptcoperador = hptcoperador;
    }

    /**
     * @return
     */
    public String getHptcoperador() {
        return hptcoperador;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    public void setRenderTema(Boolean renderTema) {
        this.renderTema = renderTema;
    }

    public Boolean getRenderTema() {
        return renderTema;
    }
}
