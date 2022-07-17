package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chautornota implements Serializable {

    /** identifier field */
    private Long hanlnumero;

    /** persistent field */
    private Long hannnumerconsu;

    /** persistent field */
    private String hancmotivsolic;

    /** nullable persistent field */
    private String hancaceptsolic;

    /** nullable persistent field */
    private String hancmotivrecha;

    /** nullable persistent field */
    private Date handfechainici;

    /** nullable persistent field */
    private Date handfechafinal;

    /** nullable persistent field */
    private Integer hannclinica;

    /** nullable persistent field */
    private Date handfechasolic;

    /** nullable persistent field */
    private String hancoperasolic;

    /** nullable persistent field */
    private Date handfecharespu;

    /** nullable persistent field */
    private String hadcoperarespu;

    /** nullable persistent field */
    private Integer version;
    
    private String hancservicio;
    
    private String hancnombserv;
    
    private String hancnombpaci;  
    
    private Long hannnumeiden; 
    
    private String hanctipoiden;
    
    /** nullable persistent field */
    private Date handfechaconsu;
    
    private String nombreClinica; 

   
    /** default constructor */
    public Chautornota() {
    }


    public void setHanlnumero(Long hanlnumero) {
        this.hanlnumero = hanlnumero;
    }

    public Long getHanlnumero() {
        return hanlnumero;
    }

    public void setHannnumerconsu(Long hannnumerconsu) {
        this.hannnumerconsu = hannnumerconsu;
    }

    public Long getHannnumerconsu() {
        return hannnumerconsu;
    }

    public void setHancmotivsolic(String hancmotivsolic) {
        this.hancmotivsolic = hancmotivsolic;
    }

    public String getHancmotivsolic() {
        return hancmotivsolic;
    }

    public void setHancaceptsolic(String hancaceptsolic) {
        this.hancaceptsolic = hancaceptsolic;
    }

    public String getHancaceptsolic() {
        return hancaceptsolic;
    }

    public void setHancmotivrecha(String hancmotivrecha) {
        this.hancmotivrecha = hancmotivrecha;
    }

    public String getHancmotivrecha() {
        return hancmotivrecha;
    }

    public void setHandfechainici(Date handfechainici) {
        this.handfechainici = handfechainici;
    }

    public Date getHandfechainici() {
        return handfechainici;
    }

    public void setHandfechafinal(Date handfechafinal) {
        this.handfechafinal = handfechafinal;
    }

    public Date getHandfechafinal() {
        return handfechafinal;
    }

    public void setHannclinica(Integer hannclinica) {
        this.hannclinica = hannclinica;
    }

    public Integer getHannclinica() {
        return hannclinica;
    }

    public void setHandfechasolic(Date handfechasolic) {
        this.handfechasolic = handfechasolic;
    }

    public Date getHandfechasolic() {
        return handfechasolic;
    }

    public void setHancoperasolic(String hancoperasolic) {
        this.hancoperasolic = hancoperasolic;
    }

    public String getHancoperasolic() {
        return hancoperasolic;
    }

    public void setHandfecharespu(Date handfecharespu) {
        this.handfecharespu = handfecharespu;
    }

    public Date getHandfecharespu() {
        return handfecharespu;
    }

    public void setHadcoperarespu(String hadcoperarespu) {
        this.hadcoperarespu = hadcoperarespu;
    }

    public String getHadcoperarespu() {
        return hadcoperarespu;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHancservicio(String hancservicio) {
        this.hancservicio = hancservicio;
    }

    public String getHancservicio() {
        return hancservicio;
    }

    public void setHancnombserv(String hancnombserv) {
        this.hancnombserv = hancnombserv;
    }

    public String getHancnombserv() {
        return hancnombserv;
    }

    public void setHancnombpaci(String hancnombpaci) {
        this.hancnombpaci = hancnombpaci;
    }

    public String getHancnombpaci() {
        return hancnombpaci;
    }

    public void setHannnumeiden(Long hannnumeiden) {
        this.hannnumeiden = hannnumeiden;
    }

    public Long getHannnumeiden() {
        return hannnumeiden;
    }

    public void setHanctipoiden(String hanctipoiden) {
        this.hanctipoiden = hanctipoiden;
    }

    public String getHanctipoiden() {
        return hanctipoiden;
    }

    public void setHandfechaconsu(Date handfechaconsu) {
        this.handfechaconsu = handfechaconsu;
    }

    public Date getHandfechaconsu() {
        return handfechaconsu;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }
}
