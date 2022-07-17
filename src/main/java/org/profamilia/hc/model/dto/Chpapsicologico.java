package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chpapsicologico implements Serializable {

    /** identifier field */
    private Long hppnconsulta;

    /** nullable persistent field */
    private String hppcobservacion;

    /** nullable persistent field */
    private Date hppdfecreg;

    /** nullable persistent field */
    private String hppcusuario;

    /** nullable persistent field */
    private Long hppnpaciente;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chpapsicologico(Long hppnconsulta, String hppcobservacion, Date hppdfecreg, String hppcusuario, Long hppnpaciente, Integer version) {
        this.hppnconsulta = hppnconsulta;
        this.hppcobservacion = hppcobservacion;
        this.hppdfecreg = hppdfecreg;
        this.hppcusuario = hppcusuario;
        this.hppnpaciente = hppnpaciente;
        this.version = version;
    }

    /** default constructor */
    public Chpapsicologico() {
    }

    /** minimal constructor */
    public Chpapsicologico(Long hppnconsulta) {
        this.hppnconsulta = hppnconsulta;
    }

    /** 
     * 		       NUMERO CONSULTA
     * 		    
     */
    public Long getHppnconsulta() {
        return this.hppnconsulta;
    }

    public void setHppnconsulta(Long hppnconsulta) {
        this.hppnconsulta = hppnconsulta;
    }

    public String getHppcobservacion() {
        return this.hppcobservacion;
    }

    public void setHppcobservacion(String hppcobservacion) {
        this.hppcobservacion = hppcobservacion;
    }

    public Date getHppdfecreg() {
        return this.hppdfecreg;
    }

    public void setHppdfecreg(Date hppdfecreg) {
        this.hppdfecreg = hppdfecreg;
    }

    public String getHppcusuario() {
        return this.hppcusuario;
    }

    public void setHppcusuario(String hppcusuario) {
        this.hppcusuario = hppcusuario;
    }

    public Long getHppnpaciente() {
        return this.hppnpaciente;
    }

    public void setHppnpaciente(Long hppnpaciente) {
        this.hppnpaciente = hppnpaciente;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hppnconsulta", getHppnconsulta())
            .toString();
    }

}
