package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chautoinfopsic implements Serializable {

    /** identifier field */
    private Long haiplnumero;

    /** persistent field */
    private Long haipnnumerconsu;

    /** persistent field */
    private String haipcmotivsolic;

    /** nullable persistent field */
    private String haipcaceptsolic;

    /** nullable persistent field */
    private String haipcmotivrecha;

    /** nullable persistent field */
    private Date haipdfechainici;

    /** nullable persistent field */
    private Date haipdfechafinal;

    /** nullable persistent field */
    private Integer haipnclinica;

    /** nullable persistent field */
    private Date haipdfechasolic;

    /** nullable persistent field */
    private String haipcoperasolic;

    /** nullable persistent field */
    private Date haipdfecharespu;

    /** nullable persistent field */
    private String haipcoperarespu;

    /** nullable persistent field */
    private Integer version;
    
    private String haipcservicio;
    
    private String haipcnombserv;
    
    private String haipcnombpaci;  
    
    private Long haipnnumeiden; 
    
    private String haipctipoiden;
    
    private String haipcetapa;
    
    
    /** nullable persistent field */
    private Date haipdfechaconsu;
    
    private String nombreClinica; 

   
    /** default constructor */
    public Chautoinfopsic() {
    }


    public void setHaiplnumero(Long haiplnumero) {
        this.haiplnumero = haiplnumero;
    }

    public Long getHaiplnumero() {
        return haiplnumero;
    }

    public void setHaipnnumerconsu(Long haipnnumerconsu) {
        this.haipnnumerconsu = haipnnumerconsu;
    }

    public Long getHaipnnumerconsu() {
        return haipnnumerconsu;
    }

    public void setHaipcmotivsolic(String haipcmotivsolic) {
        this.haipcmotivsolic = haipcmotivsolic;
    }

    public String getHaipcmotivsolic() {
        return haipcmotivsolic;
    }

    public void setHaipcaceptsolic(String haipcaceptsolic) {
        this.haipcaceptsolic = haipcaceptsolic;
    }

    public String getHaipcaceptsolic() {
        return haipcaceptsolic;
    }

    public void setHaipcmotivrecha(String haipcmotivrecha) {
        this.haipcmotivrecha = haipcmotivrecha;
    }

    public String getHaipcmotivrecha() {
        return haipcmotivrecha;
    }

    public void setHaipdfechainici(Date haipdfechainici) {
        this.haipdfechainici = haipdfechainici;
    }

    public Date getHaipdfechainici() {
        return haipdfechainici;
    }

    public void setHaipdfechafinal(Date haipdfechafinal) {
        this.haipdfechafinal = haipdfechafinal;
    }

    public Date getHaipdfechafinal() {
        return haipdfechafinal;
    }

    public void setHaipnclinica(Integer haipnclinica) {
        this.haipnclinica = haipnclinica;
    }

    public Integer getHaipnclinica() {
        return haipnclinica;
    }

    public void setHaipdfechasolic(Date haipdfechasolic) {
        this.haipdfechasolic = haipdfechasolic;
    }

    public Date getHaipdfechasolic() {
        return haipdfechasolic;
    }

    public void setHaipcoperasolic(String haipcoperasolic) {
        this.haipcoperasolic = haipcoperasolic;
    }

    public String getHaipcoperasolic() {
        return haipcoperasolic;
    }

    public void setHaipdfecharespu(Date haipdfecharespu) {
        this.haipdfecharespu = haipdfecharespu;
    }

    public Date getHaipdfecharespu() {
        return haipdfecharespu;
    }

    public void setHaipcoperarespu(String haipcoperarespu) {
        this.haipcoperarespu = haipcoperarespu;
    }

    public String getHaipcoperarespu() {
        return haipcoperarespu;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHaipcservicio(String haipcservicio) {
        this.haipcservicio = haipcservicio;
    }

    public String getHaipcservicio() {
        return haipcservicio;
    }

    public void setHaipcnombserv(String haipcnombserv) {
        this.haipcnombserv = haipcnombserv;
    }

    public String getHaipcnombserv() {
        return haipcnombserv;
    }

    public void setHaipcnombpaci(String haipcnombpaci) {
        this.haipcnombpaci = haipcnombpaci;
    }

    public String getHaipcnombpaci() {
        return haipcnombpaci;
    }

    public void setHaipnnumeiden(Long haipnnumeiden) {
        this.haipnnumeiden = haipnnumeiden;
    }

    public Long getHaipnnumeiden() {
        return haipnnumeiden;
    }

    public void setHaipctipoiden(String haipctipoiden) {
        this.haipctipoiden = haipctipoiden;
    }

    public String getHaipctipoiden() {
        return haipctipoiden;
    }

    public void setHaipdfechaconsu(Date haipdfechaconsu) {
        this.haipdfechaconsu = haipdfechaconsu;
    }

    public Date getHaipdfechaconsu() {
        return haipdfechaconsu;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setHaipcetapa(String haipcetapa) {
        this.haipcetapa = haipcetapa;
    }

    public String getHaipcetapa() {
        return haipcetapa;
    }
}
