package org.profamilia.hc.view.backing.webService;
// Generated 5/12/2018 03:36:24 PM by Hibernate Tools 3.2.2.GA


/**
 * CfdetafacturaDTO generated by hbm2java
 */
public class RegistroTomaVph implements java.io.Serializable {

    private String usuario;
    private String password;
    private String NumeroDeOrden;
    private String IdentificacionDelPaciente;
    private String NombreDelPaciente;
    private String FechaDeNacimiento;
    private String Cliente;
    private String fechaDeAdmision;
    private String CampoDeMuestra1;

    public RegistroTomaVph(String usuario, String password, String NumeroDeOrden, String IdentificacionDelPaciente, String NombreDelPaciente, String FechaDeNacimiento, String Cliente, String fechaDeAdmision,String CampoDeMuestra1) {
        this.usuario = usuario;
        this.password = password;
        this.NumeroDeOrden = NumeroDeOrden;
        this.IdentificacionDelPaciente = IdentificacionDelPaciente;
        this.NombreDelPaciente = NombreDelPaciente;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Cliente = Cliente;
        this.fechaDeAdmision = fechaDeAdmision;
        this.CampoDeMuestra1 = CampoDeMuestra1;
    }

    public RegistroTomaVph() {
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

    public String getNumeroDeOrden() {
        return NumeroDeOrden;
    }

    public void setNumeroDeOrden(String NumeroDeOrden) {
        this.NumeroDeOrden = NumeroDeOrden;
    }

    public String getIdentificacionDelPaciente() {
        return IdentificacionDelPaciente;
    }

    public void setIdentificacionDelPaciente(String IdentificacionDelPaciente) {
        this.IdentificacionDelPaciente = IdentificacionDelPaciente;
    }

    public String getNombreDelPaciente() {
        return NombreDelPaciente;
    }

    public void setNombreDelPaciente(String NombreDelPaciente) {
        this.NombreDelPaciente = NombreDelPaciente;
    }

    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getFechaDeAdmision() {
        return fechaDeAdmision;
    }

    public void setFechaDeAdmision(String fechaDeAdmision) {
        this.fechaDeAdmision = fechaDeAdmision;
    }

    public String getCampoDeMuestra1() {
        return CampoDeMuestra1;
    }

    public void setCampoDeMuestra1(String CampoDeMuestra1) {
        this.CampoDeMuestra1 = CampoDeMuestra1;
    }
   
}
