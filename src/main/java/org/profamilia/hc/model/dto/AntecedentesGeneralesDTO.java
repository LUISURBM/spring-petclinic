package org.profamilia.hc.model.dto;

import java.util.Date;

public class AntecedentesGeneralesDTO {

    private String tipoAntecedente;
    private String descripcionAntecedente;
    private Date fechaRegistro;

    public AntecedentesGeneralesDTO() {
    }


    public void setTipoAntecedente(String tipoAntecedente) {
        this.tipoAntecedente = tipoAntecedente;
    }

    public String getTipoAntecedente() {
        return tipoAntecedente;
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
