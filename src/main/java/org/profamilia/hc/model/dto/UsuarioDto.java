package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Set;


public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private String nombre;
    private Set<String> roles;
    private org.profamilia.hc.model.dto.Cpclinica cpclinica;

    public UsuarioDto() {
        cpclinica = new Cpclinica();
    }

    public UsuarioDto(String login, String password, Set<String> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCpclinica(Cpclinica cpclinica) {
        this.cpclinica = cpclinica;
    }

    public Cpclinica getCpclinica() {
        return cpclinica;
    }
}
