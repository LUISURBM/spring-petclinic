package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chcorreo implements Serializable {

    /** identifier field */
    private Long hcnconsec;

    /** persistent field */
    private Integer hcncontrato;

    /** persistent field */
    private String hcccorreo;

    /** persistent field */
    private String hccdocum;

    /** persistent field */
    private String hccestado;

    /** persistent field */
    private String hccusuareg;

    /** persistent field */
    private Date hcdfecreg;

    /** nullable persistent field */
    private BigDecimal version;
    
    /**no persistent field*/
    private String descripcion;
    
    /**no persistent field*/
    private String estado;
    
    /**no persistent field*/
    private String documento;

    /** full constructor */
    public Chcorreo(Long hcnconsec, Integer hcncontrato, String hcccorreo, String hccdocum, String hccestado, String hccusuareg, Date hcdfecreg, BigDecimal version) {
        this.hcnconsec = hcnconsec;
        this.hcncontrato = hcncontrato;
        this.hcccorreo = hcccorreo;
        this.hccdocum = hccdocum;
        this.hccestado = hccestado;
        this.hccusuareg = hccusuareg;
        this.hcdfecreg = hcdfecreg;
        this.version = version;
    }

    /** default constructor */
    public Chcorreo() {
    }

    /** minimal constructor */
    public Chcorreo(Long hcnconsec, Integer hcncontrato, String hcccorreo, String hccdocum, String hccestado, String hccusuareg, Date hcdfecreg) {
        this.hcnconsec = hcnconsec;
        this.hcncontrato = hcncontrato;
        this.hcccorreo = hcccorreo;
        this.hccdocum = hccdocum;
        this.hccestado = hccestado;
        this.hccusuareg = hccusuareg;
        this.hcdfecreg = hcdfecreg;
    }

    /** 
     * 		       SECUENCIA PARAMTRIZACION
     * 		    
     */
    public Long getHcnconsec() {
        return this.hcnconsec;
    }

    public void setHcnconsec(Long hcnconsec) {
        this.hcnconsec = hcnconsec;
    }

    public Integer getHcncontrato() {
        return this.hcncontrato;
    }

    public void setHcncontrato(Integer hcncontrato) {
        this.hcncontrato = hcncontrato;
    }

    public String getHcccorreo() {
        return this.hcccorreo;
    }

    public void setHcccorreo(String hcccorreo) {
        this.hcccorreo = hcccorreo;
    }

    public String getHccdocum() {
        return this.hccdocum;
    }

    public void setHccdocum(String hccdocum) {
        this.hccdocum = hccdocum;
    }

    public String getHccestado() {
        return this.hccestado;
    }

    public void setHccestado(String hccestado) {
        this.hccestado = hccestado;
    }

    public String getHccusuareg() {
        return this.hccusuareg;
    }

    public void setHccusuareg(String hccusuareg) {
        this.hccusuareg = hccusuareg;
    }

    public Date getHcdfecreg() {
        return this.hcdfecreg;
    }

    public void setHcdfecreg(Date hcdfecreg) {
        this.hcdfecreg = hcdfecreg;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }
    

    public String toString() {
        return new ToStringBuilder(this)
            .append("hcnconsec", getHcnconsec())
            .toString();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(String estado) {
    
        this.estado = estado;
    }

    public String getEstado() {
        estado = "Inactivo";
        if(hccestado.equals("VG")){
            estado = "Activo";
        }
        return estado;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
    if(hccdocum.equals("VPH")){
        documento = "Lectura VPH";
    }
        return documento;
    }
}
