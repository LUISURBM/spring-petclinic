package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.profamilia.hc.view.constantes.IConstantes;


/** @author Hibernate CodeGenerator */
public class Chdetaentpatol implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChdetaentpatolPK comp_id;

    /** persistent field */
    private String hepcetapa;

    /** nullable persistent field */
    private String hepcresultado;

    /** persistent field */
    private Integer hepnclinica;

    /** persistent field */
    private String hepcoperador;

    /** persistent field */
    private Date hepdfechamod;

    /** nullable persistent field */
    private Date hepdfechaentreg;

    /** nullable persistent field */
    private Chentregapatol chentregapatol;
    
    private Chotraspatolog chotraspatolog;
    
    /** nullable persistent field */
    private String descEtapa;
    
    /** nullable persistent field */
    private String hepcrecibido;
    
    private boolean itemSelected;
    
    private String descPatologia;

    /** default constructor */
    public Chdetaentpatol() {
        comp_id = new ChdetaentpatolPK();
    }

    public org.profamilia.hc.model.dto.ChdetaentpatolPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChdetaentpatolPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHepcetapa() {
        return this.hepcetapa;
    }

    public void setHepcetapa(String hepcetapa) {
        this.hepcetapa = hepcetapa;
    }

    public String getHepcresultado() {
        return this.hepcresultado;
    }

    public void setHepcresultado(String hepcresultado) {
        this.hepcresultado = hepcresultado;
    }

    public Integer getHepnclinica() {
        return this.hepnclinica;
    }

    public void setHepnclinica(Integer hepnclinica) {
        this.hepnclinica = hepnclinica;
    }

    public String getHepcoperador() {
        return this.hepcoperador;
    }

    public void setHepcoperador(String hepcoperador) {
        this.hepcoperador = hepcoperador;
    }

    public Date getHepdfechamod() {
        return this.hepdfechamod;
    }

    public void setHepdfechamod(Date hepdfechamod) {
        this.hepdfechamod = hepdfechamod;
    }

    public Date getHepdfechaentreg() {
        return this.hepdfechaentreg;
    }

    public void setHepdfechaentreg(Date hepdfechaentreg) {
        this.hepdfechaentreg = hepdfechaentreg;
    }

    public org.profamilia.hc.model.dto.Chentregapatol getChentregapatol() {
        return this.chentregapatol;
    }

    public void setChentregapatol(org.profamilia.hc.model.dto.Chentregapatol chentregapatol) {
        this.chentregapatol = chentregapatol;
    }

    public void setChotraspatolog(Chotraspatolog chotraspatolog) {
        this.chotraspatolog = chotraspatolog;
    }

    public Chotraspatolog getChotraspatolog() {
        return chotraspatolog;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }

    public boolean isItemSelected() {
        return itemSelected;
    }
    
    public void setDescEtapa(String descEtapa) {
        this.descEtapa = descEtapa;
    }

    public String getDescEtapa() {

        if (this.hepcetapa.equalsIgnoreCase(IConstantes.PATOLOGIA_ENV_LAB)) {
            this.setDescEtapa("Enviada Laboratorio");
        } else if (this.hepcetapa.equalsIgnoreCase(IConstantes.PATOLOGIA_REG_DIA)) {
            this.setDescEtapa("Registrado Diagnistico");
        } 
        else if (this.hepcetapa.equalsIgnoreCase(IConstantes.NO_RECIBIDO)) {
            this.setDescEtapa("No Recibida");
        } 
        else if (this.hepcetapa.equalsIgnoreCase(IConstantes.PATOLOGIA_ENT_USU)) {
            this.setDescEtapa("Entregada Usuario");
        } else {
            this.setDescEtapa("---");
        }

        return descEtapa;
    }
    
    public String getDescPatologia() {

        if (this.hepcresultado.equalsIgnoreCase(IConstantes.POSITIVO)) {
            this.setDescPatologia("Positivo");
        } else if (this.hepcresultado.equalsIgnoreCase(IConstantes.NEGATIVO)) {
            this.setDescPatologia("Negativo");
        }else {
            this.setDescPatologia("---");
        }

        return descPatologia;
    }
    
    public void setDescPatologia(String descPatologia) {
        this.descPatologia = descPatologia;
    }

    public void setHepcrecibido(String hepcrecibido) {
        this.hepcrecibido = hepcrecibido;
    }

    public String getHepcrecibido() {
        return hepcrecibido;
    }


}
