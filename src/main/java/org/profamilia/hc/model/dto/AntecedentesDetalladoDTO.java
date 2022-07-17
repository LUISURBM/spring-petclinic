package org.profamilia.hc.model.dto;

import java.util.Date;

public class AntecedentesDetalladoDTO {

    private String tipoAntecedente;
    private String nombreAntecedente;
    private String descripcionAntecedente;
    private Date fechaRegistro;

    public AntecedentesDetalladoDTO() {
    }


    public void setTipoAntecedente(String tipoAntecedente) {
        this.tipoAntecedente = tipoAntecedente;
    }

    public String getTipoAntecedente() {
        return tipoAntecedente;
    }

    public void setNombreAntecedente(String nombreAntecedente) {
        this.nombreAntecedente = nombreAntecedente;
    }

    public String getNombreAntecedente() {
        return nombreAntecedente;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setDescripcionAntecedente(String descripcionAntecedente) {
        this.descripcionAntecedente = descripcionAntecedente;
    }

    public String getDescripcionAntecedente() {
        return descripcionAntecedente;
    }
}
