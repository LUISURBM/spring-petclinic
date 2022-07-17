package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.profamilia.hc.view.constantes.IConstantes;


/** @author Hibernate CodeGenerator */
public class Chdetaentcito implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChdetaentcitoPK comp_id;

    /** persistent field */
    private String hdecetapa;

    /** nullable persistent field */
    private String hdecresultado;

    /** persistent field */
    private Integer hdenclinica;

    /** persistent field */
    private String hdecoperador;

    /** persistent field */
    private Date hdedfechamod;

    /** nullable persistent field */
    private Date hdedfechaentreg;

    /** nullable persistent field */
    private Chentregacitol chentregacitol;

    /** nullable persistent field */
    private Cncitologi cncitologi;

    /** nullable persistent field */
    private String hdecresultado2;

    /** nullable persistent field */
    private String descEtapa;

    private boolean itemSelected;


    /** default constructor */
    public Chdetaentcito() {
        comp_id = new ChdetaentcitoPK();
    }


    public org.profamilia.hc.model.dto.ChdetaentcitoPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChdetaentcitoPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHdecetapa() {
        return this.hdecetapa;
    }

    public void setHdecetapa(String hdecetapa) {
        this.hdecetapa = hdecetapa;
    }

    public String getHdecresultado() {
        return this.hdecresultado;
    }

    public void setHdecresultado(String hdecresultado) {
        this.hdecresultado = hdecresultado;
    }

    public Integer getHdenclinica() {
        return this.hdenclinica;
    }

    public void setHdenclinica(Integer hdenclinica) {
        this.hdenclinica = hdenclinica;
    }

    public String getHdecoperador() {
        return this.hdecoperador;
    }

    public void setHdecoperador(String hdecoperador) {
        this.hdecoperador = hdecoperador;
    }

    public Date getHdedfechamod() {
        return this.hdedfechamod;
    }

    public void setHdedfechamod(Date hdedfechamod) {
        this.hdedfechamod = hdedfechamod;
    }

    public Date getHdedfechaentreg() {
        return this.hdedfechaentreg;
    }

    public void setHdedfechaentreg(Date hdedfechaentreg) {
        this.hdedfechaentreg = hdedfechaentreg;
    }

    public org.profamilia.hc.model.dto.Chentregacitol getChentregacitol() {
        return this.chentregacitol;
    }

    public void setChentregacitol(org.profamilia.hc.model.dto.Chentregacitol chentregacitol) {
        this.chentregacitol = chentregacitol;
    }

    public void setCncitologi(Cncitologi cncitologi) {
        this.cncitologi = cncitologi;
    }

    public Cncitologi getCncitologi() {
        return cncitologi;
    }

    public void setDescEtapa(String descEtapa) {
        this.descEtapa = descEtapa;
    }

    public String getDescEtapa() {

        if (this.hdecetapa.equalsIgnoreCase(IConstantes.CITOLOGIA_ENV_LECTURA_UNO)) {
            this.setDescEtapa("Enviada Primera Lectura");
        } else if (this.hdecetapa.equalsIgnoreCase(IConstantes.CITOLOGIA_REG_LECTURA_UNO)) {
            this.setDescEtapa("Registro Primera Lectura");
        } else if (this.hdecetapa.equalsIgnoreCase(IConstantes.CITOLOGIA_ENV_LECTURA_DOS)) {
            this.setDescEtapa("Enviada Segunda Lectura");
        } else if (this.hdecetapa.equalsIgnoreCase(IConstantes.CITOLOGIA_REG_LECTURA_DOS)) {
            this.setDescEtapa("Registro Segunda Lectura");
        } else if (this.hdecetapa.equalsIgnoreCase(IConstantes.CITOLOGIA_ENTREGADA_USUARIO)) {
            this.setDescEtapa("Entregada Usuaria");
        } else {
            this.setDescEtapa("---");
        }

        return descEtapa;
    }

    public void setHdecresultado2(String hdecresultado2) {
        this.hdecresultado2 = hdecresultado2;
    }

    public String getHdecresultado2() {
        return hdecresultado2;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }

    public boolean isItemSelected() {
        return itemSelected;
    }
}
