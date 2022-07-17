package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chevoluconsu implements Serializable {

    /** identifier field */
    private ChevoluconsuPK id;

    /** nullable persistent field */
    private String heccdescripc;

    /** nullable persistent field */
    private String heccoperador;

    /** nullable persistent field */
    private Date hecdfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Integer hecnactividad;


    /** default constructor */
    public Chevoluconsu() {
    }

    public void setId(ChevoluconsuPK id) {
        this.id = id;
    }

    public ChevoluconsuPK getId() {
        return id;
    }

    public void setHeccdescripc(String heccdescripc) {
        this.heccdescripc = heccdescripc;
    }

    public String getHeccdescripc() {
        return heccdescripc;
    }

    public void setHeccoperador(String heccoperador) {
        this.heccoperador = heccoperador;
    }

    public String getHeccoperador() {
        return heccoperador;
    }

    public void setHecdfecregistr(Date hecdfecregistr) {
        this.hecdfecregistr = hecdfecregistr;
    }

    public Date getHecdfecregistr() {
        return hecdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHecnactividad(Integer hecnactividad) {
        this.hecnactividad = hecnactividad;
    }

    public Integer getHecnactividad() {
        return hecnactividad;
    }
}
