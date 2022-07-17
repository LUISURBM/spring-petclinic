package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;

public class IPS {

     String nit;
     String nombre;
     String fechageneracion;
     String codigoips;
     String email;
     Afiliado afiliado;


    public IPS(){
    
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechageneracion(String fechageneracion) {
        this.fechageneracion = fechageneracion;
    }

    public String getFechageneracion() {
        return fechageneracion;
    }

    public void setCodigoips(String codigoips) {
        this.codigoips = codigoips;
    }

    public String getCodigoips() {
        return codigoips;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }
}
