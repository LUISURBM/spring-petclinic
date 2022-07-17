package org.profamilia.hc.view.backing.webService;
// Generated 5/12/2018 03:36:24 PM by Hibernate Tools 3.2.2.GA



public class RegistraEpicienterResult implements java.io.Serializable {

    private String GlosaRespuesta;
    private Integer codRespuesta;

    public RegistraEpicienterResult(String GlosaRespuesta, Integer codRespuesta) {
        this.GlosaRespuesta = GlosaRespuesta;
        this.codRespuesta = codRespuesta;
    }

    public RegistraEpicienterResult() {
    }

    public String getGlosaRespuesta() {
        return GlosaRespuesta;
    }

    public void setGlosaRespuesta(String GlosaRespuesta) {
        this.GlosaRespuesta = GlosaRespuesta;
    }

    public Integer getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(Integer codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    @Override
    public String toString() {
        return "RegistraEpicienterResult{" + "GlosaRespuesta=" + GlosaRespuesta + ", codRespuesta=" + codRespuesta + '}';
    }

}
