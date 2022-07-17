package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

public class Chciruganula implements Serializable {


    private ChciruganulaPK id;
    
    /** nullable persistent field */
    private Date hcadfechaciran;
    
    /** nullable persistent field */
    private Date hcadfechaanula;
    
    /** nullable persistent field */
    private String hcacoperanula;
    
    /** nullable persistent field */
    private String hcacobseranula;
    
    /** nullable persistent field */
    private String hcacmotivanula;
    
    private String nombrePaciente;
    
    private Long numeroIdentificacion;
    
    private String procedimiento; 
    
 
    
    /** nullable persistent field */
    private Integer version;




    public Chciruganula() {
    id = new ChciruganulaPK();
    }
    
    /**
     * @param id
     */
    public void setId(ChciruganulaPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChciruganulaPK getId() {
        return id;
    }


    public void setHcadfechaciran(Date hcadfechaciran) {
        this.hcadfechaciran = hcadfechaciran;
    }

    public Date getHcadfechaciran() {
        return hcadfechaciran;
    }

    public void setHcadfechaanula(Date hcadfechaanula) {
        this.hcadfechaanula = hcadfechaanula;
    }

    public Date getHcadfechaanula() {
        return hcadfechaanula;
    }

    

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHcacoperanula(String hcacoperanula) {
        this.hcacoperanula = hcacoperanula;
    }

    public String getHcacoperanula() {
        return hcacoperanula;
    }

    public void setHcacobseranula(String hcacobseranula) {
        this.hcacobseranula = hcacobseranula;
    }

    public String getHcacobseranula() {
        return hcacobseranula;
    }

    public void setHcacmotivanula(String hcacmotivanula) {
        this.hcacmotivanula = hcacmotivanula;
    }

    public String getHcacmotivanula() {
        return hcacmotivanula;
    }


    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getProcedimiento() {
        return procedimiento;
    }
}
