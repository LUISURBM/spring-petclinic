package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;

public class Analito {

    String nombre;
    String valor;
    String unidad;
    String observaciones;
    Referencia referencia;


    public Analito() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public Referencia getReferencia() {
        return referencia;
    }
}
