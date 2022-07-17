package org.profamilia.hc.view.backing.webService.saludTotal.dto.request;

import java.util.List;


public class Afiliado {

    String documento;
    String tipodocumento;
    String nombresusuario;
    String apellidosusuario;
    String encabezado;
    List<Clasificacion> clasificacion;

    public Afiliado() {

    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setNombresusuario(String nombresusuario) {
        this.nombresusuario = nombresusuario;
    }

    public String getNombresusuario() {
        return nombresusuario;
    }

    public void setApellidosusuario(String apellidosusuario) {
        this.apellidosusuario = apellidosusuario;
    }

    public String getApellidosusuario() {
        return apellidosusuario;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setClasificacion(List<Clasificacion> clasificacion) {
        this.clasificacion = clasificacion;
    }

    public List<Clasificacion> getClasificacion() {
        return clasificacion;
    }
}
