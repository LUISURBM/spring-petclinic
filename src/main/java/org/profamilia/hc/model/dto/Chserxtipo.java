package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chserxtipo implements Serializable {

    /** identifier field */
    private ChserxtipoPK comp_id;

    /** persistent field */
    private String hstcestado;

    /** persistent field */
    private String hstcoperador;

    /** persistent field */
    private Date hstdfechregi;

    private String descServicio;

    /** nullable persistent field */
    private Integer version;

 

    /** default constructor */
    public Chserxtipo() {
    
        comp_id = new ChserxtipoPK();
    }

  

    public ChserxtipoPK getComp_id() {
        return this.comp_id;
    }


    public void setComp_id(ChserxtipoPK comp_id) {
        this.comp_id = comp_id;
    }

    public ChserxtipoPK get_comp_id() {
        return comp_id;
    }

    public void setHstcestado(String hstcestado) {
        this.hstcestado = hstcestado;
    }

    public String getHstcestado() {
        return hstcestado;
    }

    public void setHstcoperador(String hstcoperador) {
        this.hstcoperador = hstcoperador;
    }

    public String getHstcoperador() {
        return hstcoperador;
    }

    public void setHstdfechregi(Date hstdfechregi) {
        this.hstdfechregi = hstdfechregi;
    }

    public Date getHstdfechregi() {
        return hstdfechregi;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setDescServicio(String descServicio) {
        this.descServicio = descServicio;
    }

    public String getDescServicio() {
        return descServicio;
    }
}
