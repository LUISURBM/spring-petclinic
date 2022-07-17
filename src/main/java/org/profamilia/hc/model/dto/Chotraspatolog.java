package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;

import org.profamilia.hc.model.BasicBean;
import org.profamilia.hc.view.constantes.IConstantes;

/** @author Hibernate CodeGenerator */
public class Chotraspatolog  extends BasicBean implements Serializable {

    /** identifier field */
    private Integer chopnconsec;

    /** persistent field */
    private Integer chopntipodoc;

    /** persistent field */
    private Integer chopnnumdoc;

    /** persistent field */
    private Integer chopnclinorig;

    /** persistent field */
    private String chopccodiserv;

    /** nullable persistent field */
    private String chopcobspatol;

    /** persistent field */
    private String chopcoperador;

    /** persistent field */
    private Date chopdfechareg;
    
    /** persistent field */
    private String chopcdiagn;
    
    private boolean itemSelected;
    
    private String tipoIden;
    
    private Long numInden;
    
    private String nombusuario;
    
    private String nombClinica;
    
    private String nombServcio;
    
    private Long idListado;
    
    private String etapapatol;
    
    private String descetapa;  
    
    private Integer idLab;
    
    private String laboratorio;  
    
    private String descTipoDoc; 
    
    private String chopcnombrerecl;
    
    private String chopcparentesco;
    
    private Date chopdfechaent;
    

    /** default constructor */
    public Chotraspatolog() {
    }

    /** 
     * 		       Secuencia de la patologia.
     * 		    
     */
    public Integer getChopnconsec() {
        return this.chopnconsec;
    }

    public void setChopnconsec(Integer chopnconsec) {
        this.chopnconsec = chopnconsec;
    }

    public Integer getChopntipodoc() {
        return this.chopntipodoc;
    }

    public void setChopntipodoc(Integer chopntipodoc) {
        this.chopntipodoc = chopntipodoc;
    }

    public Integer getChopnnumdoc() {
        return this.chopnnumdoc;
    }

    public void setChopnnumdoc(Integer chopnnumdoc) {
        this.chopnnumdoc = chopnnumdoc;
    }

    public String getChopccodiserv() {
        return this.chopccodiserv;
    }

    public void setChopccodiserv(String chopccodiserv) {
        this.chopccodiserv = chopccodiserv;
    }

    public String getChopcobspatol() {
        return this.chopcobspatol;
    }

    public void setChopcobspatol(String chopcobspatol) {
        this.chopcobspatol = chopcobspatol;
    }

    public String getChopcoperador() {
        return this.chopcoperador;
    }

    public void setChopcoperador(String chopcoperador) {
        this.chopcoperador = chopcoperador;
    }

    public Date getChopdfechareg() {
        return this.chopdfechareg;
    }

    public void setChopdfechareg(Date chopdfechareg) {
        this.chopdfechareg = chopdfechareg;
    }

    public void setChopnclinorig(Integer chopnclinorig) {
        this.chopnclinorig = chopnclinorig;
    }

    public Integer getChopnclinorig() {
        return chopnclinorig;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }

    public boolean isItemSelected() {
        return itemSelected;
    }
    
    
    public void setDescetapa(String descetapa) {
        this.descetapa = descetapa;
    }    
    
    public String getDescetapa() {

        if (this.etapapatol.equalsIgnoreCase(IConstantes.PATOLOGIA_ENV_LAB)) {
            this.setDescetapa("Enviada Laboratorio");
        } else if (this.etapapatol.equalsIgnoreCase(IConstantes.PATOLOGIA_REG_DIA)) {
            this.setDescetapa("Registrado Diagnostico");
        } 
        else if (this.etapapatol.equalsIgnoreCase(IConstantes.NO_RECIBIDO)) {
            this.setDescetapa("No Recibida");
        }         
        else if (this.etapapatol.equalsIgnoreCase(IConstantes.PATOLOGIA_ENT_USU)) {
            this.setDescetapa("Entregada Usuario(a)");
        } else {
            this.setDescetapa("---");
        }
        return descetapa;
        
    }

    public void setTipoIden(String tipoIden) {
        this.tipoIden = tipoIden;
    }

    public String getTipoIden() {
        return tipoIden;
    }

    public void setNumInden(Long numInden) {
        this.numInden = numInden;
    }

    public Long getNumInden() {
        return numInden;
    }

    public void setNombusuario(String nombusuario) {
        this.nombusuario = nombusuario;
    }

    public String getNombusuario() {
        return nombusuario;
    }

    public void setNombClinica(String nombClinica) {
        this.nombClinica = nombClinica;
    }

    public String getNombClinica() {
        return nombClinica;
    }

    public void setNombServcio(String nombServcio) {
        this.nombServcio = nombServcio;
    }

    public String getNombServcio() {
        return nombServcio;
    }

    public void setIdListado(Long idListado) {
        this.idListado = idListado;
    }

    public Long getIdListado() {
        return idListado;
    }

    public void setEtapapatol(String etapapatol) {
        this.etapapatol = etapapatol;
    }

    public String getEtapapatol() {
        return etapapatol;
    }

    public void setIdLab(Integer idLab) {
        this.idLab = idLab;
    }

    public Integer getIdLab() {
        return idLab;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setDescTipoDoc(String descTipoDoc) {
        this.descTipoDoc = descTipoDoc;
    }

    public String getDescTipoDoc() {
    
        if(this.chopntipodoc != null){
        
        if(this.chopntipodoc.intValue() == 2)
            descTipoDoc = "FACTURA DE SERVICIOS";
        else if(this.chopntipodoc.intValue() == 51)
                descTipoDoc = "FACTURA DE VENTA";
        else if(this.chopntipodoc.intValue() == 2)
                descTipoDoc = "COMPROBANTE MANUAL";
        else
            descTipoDoc = "DESCONOCIDO";
        }
    
        return descTipoDoc;
    }

    public void setChopcdiagn(String chopcdiagn) {
        this.chopcdiagn = chopcdiagn;
    }

    public String getChopcdiagn() {
        return chopcdiagn;
    }

    public void setChopcnombrerecl(String chopcnombrerecl) {
        this.chopcnombrerecl = chopcnombrerecl;
    }

    public String getChopcnombrerecl() {
        return chopcnombrerecl;
    }

    public void setChopcparentesco(String chopcparentesco) {
        this.chopcparentesco = chopcparentesco;
    }

    public String getChopcparentesco() {
        return chopcparentesco;
    }

    public void setChopdfechaent(Date chopdfechaent) {
        this.chopdfechaent = chopdfechaent;
    }

    public Date getChopdfechaent() {
        return chopdfechaent;
    }
}
