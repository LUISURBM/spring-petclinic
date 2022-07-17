package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;


public class Servicio {

     String tipoatencion;
     String nap;
     String tipoayudadx;
     String codservicio;
     String nombreservicio;
     String nombreprofesional;
     String fechaservicio;
     String resultado;
     GrupoLaboratorio grupolaboratorio;
     
     public Servicio(){
     
     
     }

    public void setTipoatencion(String tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public String getTipoatencion() {
        return tipoatencion;
    }

    public void setNap(String nap) {
        this.nap = nap;
    }

    public String getNap() {
        return nap;
    }

    public void setTipoayudadx(String tipoayudadx) {
        this.tipoayudadx = tipoayudadx;
    }

    public String getTipoayudadx() {
        return tipoayudadx;
    }

    public void setCodservicio(String codservicio) {
        this.codservicio = codservicio;
    }

    public String getCodservicio() {
        return codservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreprofesional(String nombreprofesional) {
        this.nombreprofesional = nombreprofesional;
    }

    public String getNombreprofesional() {
        return nombreprofesional;
    }

    public void setFechaservicio(String fechaservicio) {
        this.fechaservicio = fechaservicio;
    }

    public String getFechaservicio() {
        return fechaservicio;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setGrupolaboratorio(GrupoLaboratorio grupolaboratorio) {
        this.grupolaboratorio = grupolaboratorio;
    }

    public GrupoLaboratorio getGrupolaboratorio() {
        return grupolaboratorio;
    }
}
