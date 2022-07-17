package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;

import java.util.List;

public class GrupoLaboratorio {
	
    String nombre;
    List<Analito> analito;
    
    public GrupoLaboratorio(){
    
    
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setAnalito(List<Analito> analito) {
        this.analito = analito;
    }

    public List<Analito> getAnalito() {
        return analito;
    }
}
