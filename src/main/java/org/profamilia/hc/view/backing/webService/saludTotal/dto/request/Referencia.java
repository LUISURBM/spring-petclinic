package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;

public class Referencia {
  
     String descripcion;
     String valorminimo;
     String valormaximo;
     String observaciones;
     
     public Referencia(){
     
     }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setValorminimo(String valorminimo) {
        this.valorminimo = valorminimo;
    }

    public String getValorminimo() {
        return valorminimo;
    }

    public void setValormaximo(String valormaximo) {
        this.valormaximo = valormaximo;
    }

    public String getValormaximo() {
        return valormaximo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
