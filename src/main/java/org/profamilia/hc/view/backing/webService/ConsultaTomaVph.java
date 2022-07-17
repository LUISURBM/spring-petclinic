package org.profamilia.hc.view.backing.webService;
// Generated 5/12/2018 03:36:24 PM by Hibernate Tools 3.2.2.GA


public class ConsultaTomaVph implements java.io.Serializable {

    private String usuario;
    private String password;
    private String NumeroOrden;
    private String IdentificacionPaciente;

    public ConsultaTomaVph() {
    }

    public ConsultaTomaVph(String usuario, String password, String NumeroOrden, String IdentificacionPaciente) {
        this.usuario = usuario;
        this.password = password;
        this.NumeroOrden = NumeroOrden;
        this.IdentificacionPaciente = IdentificacionPaciente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroOrden() {
        return NumeroOrden;
    }

    public void setNumeroOrden(String NumeroOrden) {
        this.NumeroOrden = NumeroOrden;
    }

    public String getIdentificacionPaciente() {
        return IdentificacionPaciente;
    }

    public void setIdentificacionPaciente(String IdentificacionPaciente) {
        this.IdentificacionPaciente = IdentificacionPaciente;
    }

}
