package org.profamilia.hc.view.backing.webService.saludTotal.dto;

public class DatoRespuesta {

    private String error;
    private String descripcion;
    private String resultadoLC;
    private String xml;
    
    public DatoRespuesta() {
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setResultadoLC(String resultadoLC) {
        this.resultadoLC = resultadoLC;
    }

    public String getResultadoLC() {
        return resultadoLC;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getXml() {
        return xml;
    }
}
