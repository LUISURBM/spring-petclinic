package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chfragesperma implements Serializable {

    /** identifier field */
    private Long cfelconsulta;

    /** nullable persistent field */
    private Long cfelnumepaci;

    /** nullable persistent field */
    private String cfecusuaregi;

    /** nullable persistent field */
    private Date cfetfechregi;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Integer cfelnumexam;

    /** nullable persistent field */
    private String cfectipomuest;

    /** nullable persistent field */
    private Date cfedfechtoma;

    /** nullable persistent field */
    private Date cfedfechinfor;

    /** nullable persistent field */
    private String cfecmediremi;

    /** nullable persistent field */
    private Integer cfelnesinfrag;

    /** nullable persistent field */
    private Integer cfelneconfrag;

    /** nullable persistent field */
    private Double cfenidf;

    /** nullable persistent field */
    private Double cfenporcentaje;

    /** nullable persistent field */
    private String cfecconsidera;

    /** nullable persistent field */
    private String cfecusuaprofes;

    /** full constructor */
    public Chfragesperma(Long cfelconsulta, Long cfelnumepaci, String cfecusuaregi, Date cfetfechregi, Integer version, Integer cfelnumexam, String cfectipomuest, Date cfedfechtoma, Date cfedfechinfor, String cfecmediremi, Integer cfelnesinfrag, Integer cfelneconfrag, Double cfenidf, Double cfenporcentaje, String cfecconsidera, String cfecusuaprofes) {
        this.cfelconsulta = cfelconsulta;
        this.cfelnumepaci = cfelnumepaci;
        this.cfecusuaregi = cfecusuaregi;
        this.cfetfechregi = cfetfechregi;
        this.version = version;
        this.cfelnumexam = cfelnumexam;
        this.cfectipomuest = cfectipomuest;
        this.cfedfechtoma = cfedfechtoma;
        this.cfedfechinfor = cfedfechinfor;
        this.cfecmediremi = cfecmediremi;
        this.cfelnesinfrag = cfelnesinfrag;
        this.cfelneconfrag = cfelneconfrag;
        this.cfenidf = cfenidf;
        this.cfenporcentaje = cfenporcentaje;
        this.cfecconsidera = cfecconsidera;
        this.cfecusuaprofes = cfecusuaprofes;
    }

    /** default constructor */
    public Chfragesperma() {
    }

    /** minimal constructor */
    public Chfragesperma(Long cfelconsulta) {
        this.cfelconsulta = cfelconsulta;
    }

    /** 
     * 		       NUMERO DE CONSULTA
     * 		    
     */
    public Long getCfelconsulta() {
        return this.cfelconsulta;
    }

    public void setCfelconsulta(Long cfelconsulta) {
        this.cfelconsulta = cfelconsulta;
    }

    public Long getCfelnumepaci() {
        return this.cfelnumepaci;
    }

    public void setCfelnumepaci(Long cfelnumepaci) {
        this.cfelnumepaci = cfelnumepaci;
    }

    public String getCfecusuaregi() {
        return this.cfecusuaregi;
    }

    public void setCfecusuaregi(String cfecusuaregi) {
        this.cfecusuaregi = cfecusuaregi;
    }

    public Date getCfetfechregi() {
        return this.cfetfechregi;
    }

    public void setCfetfechregi(Date cfetfechregi) {
        this.cfetfechregi = cfetfechregi;
    }



    public Integer getCfelnumexam() {
        return this.cfelnumexam;
    }

    public void setCfelnumexam(Integer cfelnumexam) {
        this.cfelnumexam = cfelnumexam;
    }

    public String getCfectipomuest() {
        return this.cfectipomuest;
    }

    public void setCfectipomuest(String cfectipomuest) {
        this.cfectipomuest = cfectipomuest;
    }

    public Date getCfedfechtoma() {
        return this.cfedfechtoma;
    }

    public void setCfedfechtoma(Date cfedfechtoma) {
        this.cfedfechtoma = cfedfechtoma;
    }

    public Date getCfedfechinfor() {
        return this.cfedfechinfor;
    }

    public void setCfedfechinfor(Date cfedfechinfor) {
        this.cfedfechinfor = cfedfechinfor;
    }

    public String getCfecmediremi() {
        return this.cfecmediremi;
    }

    public void setCfecmediremi(String cfecmediremi) {
        this.cfecmediremi = cfecmediremi;
    }

    public Integer getCfelnesinfrag() {
        return this.cfelnesinfrag;
    }

    public void setCfelnesinfrag(Integer cfelnesinfrag) {
        this.cfelnesinfrag = cfelnesinfrag;
    }

    public Integer getCfelneconfrag() {
        return this.cfelneconfrag;
    }

    public void setCfelneconfrag(Integer cfelneconfrag) {
        this.cfelneconfrag = cfelneconfrag;
    }

  
    public Double getCfenporcentaje() {
        return this.cfenporcentaje;
    }

    public void setCfenporcentaje(Double cfenporcentaje) {
        this.cfenporcentaje = cfenporcentaje;
    }

    public String getCfecconsidera() {
        return this.cfecconsidera;
    }

    public void setCfecconsidera(String cfecconsidera) {
        this.cfecconsidera = cfecconsidera;
    }

    public String getCfecusuaprofes() {
        return this.cfecusuaprofes;
    }

    public void setCfecusuaprofes(String cfecusuaprofes) {
        this.cfecusuaprofes = cfecusuaprofes;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cfelconsulta", getCfelconsulta())
            .toString();
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }


    public void setCfenidf(Double cfenidf) {
        this.cfenidf = cfenidf;
    }

    public Double getCfenidf() {
        return cfenidf;
    }
}
