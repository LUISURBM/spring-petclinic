package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;


/** @author Hibernate CodeGenerator */
public class Chformulamed implements Serializable {

    /** identifier field */
    private ChformulamedPK id;

    /** nullable persistent field */
    private String hfocmedicament;

    /** nullable persistent field */
    private String hfoctratramien;

    /** nullable persistent field */
    private String hfocviadminotr;

    /** nullable persistent field */
    private Integer hfocadosis;

    /** nullable persistent field */
    private Date hfodfecregistr;

    /** nullable persistent field */
    private String hfocoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hfoccontraindi;

    /** nullable persistent field */
    private String hfocviadministr;
    
    /** nullable persistent field */
    private String hfoctiposerv; 
    
    /** identifier field */
    private Integer hfonllave;
    
    private String  hfocdescform;
    
    private String hfoccodisap;
    
    private String  hfoccodiatc;
    
    private String hfoccodicum;


    private boolean modoconsulta;
    
    private boolean imprimir;     
    
    private String  hfocunidmedi;
    
    private String  hfocfrecuenc;
    
    private Integer hfonfrecuenc;
    
    private String  hfocduracion;
    
    private Integer hfonduracion;
    
    private String hfocconcentr;
    
    private String hfocformafarma;
    
    private String hfocventmostra;
    
    private String hfocconcimedic;
    
    private String hfocalerta;


    /** default constructor */
    public Chformulamed() {
     
    }


    /**
     * @param id
     */
    public void setId(ChformulamedPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChformulamedPK getId() {
        return id;
    }

    /**
     * @param hfocmedicament
     */
    public void setHfocmedicament(String hfocmedicament) {
        this.hfocmedicament = hfocmedicament;
    }

    /**
     * @return
     */
    public String getHfocmedicament() {
        return hfocmedicament;
    }

    /**
     * @param hfoctratramien
     */
    public void setHfoctratramien(String hfoctratramien) {
        this.hfoctratramien = hfoctratramien;
    }

    /**
     * @return
     */
    public String getHfoctratramien() {
        return hfoctratramien;
    }

    /**
     * @param hfocviadminotr
     */
    public void setHfocviadminotr(String hfocviadminotr) {
        this.hfocviadminotr = hfocviadminotr;
    }

    /**
     * @return
     */
    public String getHfocviadminotr() {
        return hfocviadminotr;
    }

    /**
     * @param hfocadosis
     */
    public void setHfocadosis(Integer hfocadosis) {
        this.hfocadosis = hfocadosis;
    }

    /**
     * @return
     */
    public Integer getHfocadosis() {
        return hfocadosis;
    }

    /**
     * @param hfodfecregistr
     */
    public void setHfodfecregistr(Date hfodfecregistr) {
        this.hfodfecregistr = hfodfecregistr;
    }

    /**
     * @return
     */
    public Date getHfodfecregistr() {
        return hfodfecregistr;
    }

    /**
     * @param hfocoperador
     */
    public void setHfocoperador(String hfocoperador) {
        this.hfocoperador = hfocoperador;
    }

    /**
     * @return
     */
    public String getHfocoperador() {
        return hfocoperador;
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

    /**
     * @param hfoccontraindi
     */
    public void setHfoccontraindi(String hfoccontraindi) {
        this.hfoccontraindi = hfoccontraindi;
    }

    /**
     * @return
     */
    public String getHfoccontraindi() {
        return hfoccontraindi;
    }

    /**
     * @param hfocviadministr
     */
    public void setHfocviadministr(String hfocviadministr) {
        this.hfocviadministr = hfocviadministr;
    }

    /**
     * @return
     */
    public String getHfocviadministr() {
        return hfocviadministr;
    }

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    public boolean isModoconsulta() {
        modoconsulta = false;
        if (this.id != null && this.id.getHfolconsulta() != null) {
            modoconsulta = true;
        }
        return modoconsulta;
    }


    /**
     * @return
     */
    public boolean isImprimir() {
        return imprimir;
    }

    /**
     * @param valueChangeEvent
     */
    public void setImprimir(ValueChangeEvent valueChangeEvent){
        setImprimir((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param imprimir
     */
    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    /**
     * @param hfoctiposerv
     */
    public void setHfoctiposerv(String hfoctiposerv) {
        this.hfoctiposerv = hfoctiposerv;
    }

    /**
     * @return
     */
    public String getHfoctiposerv() {
        return hfoctiposerv;
    }

    public void setHfonllave(Integer hfonllave) {
        this.hfonllave = hfonllave;
    }

    public Integer getHfonllave() {
        return hfonllave;
    }

    public void setHfocunidmedi(String hfocunidmedi) {
        this.hfocunidmedi = hfocunidmedi;
    }

    public String getHfocunidmedi() {
        return hfocunidmedi;
    }

    public void setHfocfrecuenc(String hfocfrecuenc) {
        this.hfocfrecuenc = hfocfrecuenc;
    }

    public String getHfocfrecuenc() {
        return hfocfrecuenc;
    }

    public void setHfonfrecuenc(Integer hfonfrecuenc) {
        this.hfonfrecuenc = hfonfrecuenc;
    }

    public Integer getHfonfrecuenc() {
        return hfonfrecuenc;
    }

    public void setHfocduracion(String hfocduracion) {
        this.hfocduracion = hfocduracion;
    }

    public String getHfocduracion() {
        return hfocduracion;
    }

    public void setHfonduracion(Integer hfonduracion) {
        this.hfonduracion = hfonduracion;
    }

    public Integer getHfonduracion() {
        return hfonduracion;
    }

    public void setHfocconcentr(String hfocconcentr) {
        this.hfocconcentr = hfocconcentr;
    }

    public String getHfocconcentr() {
        return hfocconcentr;
    }

    public void setHfocformafarma(String hfocformafarma) {
        this.hfocformafarma = hfocformafarma;
    }

    public String getHfocformafarma() {
        return hfocformafarma;
    }

    public void setHfocventmostra(String hfocventmostra) {
        this.hfocventmostra = hfocventmostra;
    }

    public String getHfocventmostra() {
        return hfocventmostra;
    }

    public void setHfocdescform(String hfocdescform) {
        this.hfocdescform = hfocdescform;
    }

    public String getHfocdescform() {
        return hfocdescform;
    }

    public void setHfoccodisap(String hfoccodisap) {
        this.hfoccodisap = hfoccodisap;
    }

    public String getHfoccodisap() {
        return hfoccodisap;
    }

    public void setHfoccodiatc(String hfoccodiatc) {
        this.hfoccodiatc = hfoccodiatc;
    }

    public String getHfoccodiatc() {
        return hfoccodiatc;
    }

    public void setHfoccodicum(String hfoccodicum) {
        this.hfoccodicum = hfoccodicum;
    }

    public String getHfoccodicum() {
        return hfoccodicum;
    }

    public void setHfocconcimedic(String hfocconcimedic) {
        this.hfocconcimedic = hfocconcimedic;
    }

    public String getHfocconcimedic() {
        return hfocconcimedic;
    }

    public void setHfocalerta(String hfocalerta) {
        this.hfocalerta = hfocalerta;
    }

    public String getHfocalerta() {
        return hfocalerta;
    }
}
