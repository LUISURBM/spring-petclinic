package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;


public class Clasificacion {
    String nombre;
    Servicio servicio;
    
    public Clasificacion (){
    
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }
}
