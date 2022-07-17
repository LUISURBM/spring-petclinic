package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chparameduca implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChparameducaPK id;

    /** persistent field */
    private String hpecdescripcion;

    /** persistent field */
    private String hpecestado;

    /** persistent field */
    private Date hpedfechregi;

    /** persistent field */
    private String hpecusuaregi;

    /** nullable persistent field */
    private Integer version;

  

    /** default constructor */
    public Chparameduca() {
    }


    public void setId(ChparameducaPK id) {
        this.id = id;
    }

    public ChparameducaPK getId() {
        return id;
    }

    public void setHpecdescripcion(String hpecdescripcion) {
        this.hpecdescripcion = hpecdescripcion;
    }

    public String getHpecdescripcion() {
        return hpecdescripcion;
    }

    public void setHpecestado(String hpecestado) {
        this.hpecestado = hpecestado;
    }

    public String getHpecestado() {
        return hpecestado;
    }

    public void setHpedfechregi(Date hpedfechregi) {
        this.hpedfechregi = hpedfechregi;
    }

    public Date getHpedfechregi() {
        return hpedfechregi;
    }

    public void setHpecusuaregi(String hpecusuaregi) {
        this.hpecusuaregi = hpecusuaregi;
    }

    public String getHpecusuaregi() {
        return hpecusuaregi;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}
