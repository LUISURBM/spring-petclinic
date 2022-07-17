package org.profamilia.hc.model.dto;

import java.util.List;


public class Chhistoimpre {

    /** Almacena el objeto del usuario */
    private Chusuario usuario;

    /** Almacena el objeto Motivo Consulta*/
    private Chmotivocon motivo;

    /** Almacena los antecedentes Generales*/
    private List<Chantecegene> antecedenteGeneral;

    /** Almacena los antecedentes Ginecologicos */
    private Chantegineco antecedenteGineco;

    /** Almacena el Examen Fisico*/
    private Chexamfisico examen;

    /** Almacena el objeto Impresion Diagnostica*/
    private Chimprdiag impresion;

    /** Almacena el objeto conducta*/
    private Chconducta conducta;

    public Chhistoimpre() {
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMotivo(Chmotivocon motivo) {
        this.motivo = motivo;
    }

    public Chmotivocon getMotivo() {
        return motivo;
    }

    public void setAntecedenteGeneral(List<Chantecegene> antecedenteGeneral) {
        this.antecedenteGeneral = antecedenteGeneral;
    }

    public List<Chantecegene> getAntecedenteGeneral() {
        return antecedenteGeneral;
    }

    public void setAntecedenteGineco(Chantegineco antecedenteGineco) {
        this.antecedenteGineco = antecedenteGineco;
    }

    public Chantegineco getAntecedenteGineco() {
        return antecedenteGineco;
    }

    public void setExamen(Chexamfisico examen) {
        this.examen = examen;
    }

    public Chexamfisico getExamen() {
        return examen;
    }

    public void setImpresion(Chimprdiag impresion) {
        this.impresion = impresion;
    }

    public Chimprdiag getImpresion() {
        return impresion;
    }

    public void setConducta(Chconducta conducta) {
        this.conducta = conducta;
    }

    public Chconducta getConducta() {
        return conducta;
    }
}
