package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class Agendamiento implements Serializable {

    public BigDecimal id;
    public Chusuario id_paciente;
    public BigDecimal id_profesional;
    public BigDecimal id_sede;
    public BigDecimal tipo_convenio;
    public String id_convenio;
    public BigDecimal tipo_cita;
    public Cpservicio especialidad;
    public Date fecha_deseada;
    public Date fecha_agenda;
    public String hora_agenda;
    public BigDecimal subagenda;
    public BigDecimal estado;
    public String usuario_mod;
    public Date fecha_mod;
    public Integer version;
    public Integer estado_agenda;
    public Integer motivo_cancelacion;
    public String desc_cancelacion;
    public String hora_agenda_fin;
    public String hora_fin;
    public String desc_cita;
    public boolean tieneConsulta;
    public String desConsulta;
    public Date fecha_atencion;
    public Long consulta_cln;
   


    public Agendamiento() {
    }


    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

  

    public void setTipo_convenio(BigDecimal tipo_convenio) {
        this.tipo_convenio = tipo_convenio;
    }

    public BigDecimal getTipo_convenio() {
        return tipo_convenio;
    }

    public void setId_convenio(String id_convenio) {
        this.id_convenio = id_convenio;
    }

    public String getId_convenio() {
        return id_convenio;
    }

    public void setTipo_cita(BigDecimal tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public BigDecimal getTipo_cita() {
        return tipo_cita;
    }

    public void setFecha_deseada(Date fecha_deseada) {
        this.fecha_deseada = fecha_deseada;
    }

    public Date getFecha_deseada() {
        return fecha_deseada;
    }

    public void setFecha_agenda(Date fecha_agenda) {
        this.fecha_agenda = fecha_agenda;
    }

    public Date getFecha_agenda() {
        return fecha_agenda;
    }

    public void setHora_agenda(String hora_agenda) {
        this.hora_agenda = hora_agenda;
    }

    public String getHora_agenda() {
        return hora_agenda;
    }

    public void setSubagenda(BigDecimal subagenda) {
        this.subagenda = subagenda;
    }

    public BigDecimal getSubagenda() {
        return subagenda;
    }

    public void setEstado(BigDecimal estado) {
        this.estado = estado;
    }

    public BigDecimal getEstado() {
        return estado;
    }

    public void setUsuario_mod(String usuario_mod) {
        this.usuario_mod = usuario_mod;
    }

    public String getUsuario_mod() {
        return usuario_mod;
    }

    public void setFecha_mod(Date fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public Date getFecha_mod() {
        return fecha_mod;
    }

    public void setEstado_agenda(Integer estado_agenda) {
        this.estado_agenda = estado_agenda;
    }

    public Integer getEstado_agenda() {
        return estado_agenda;
    }

    public void setMotivo_cancelacion(Integer motivo_cancelacion) {
        this.motivo_cancelacion = motivo_cancelacion;
    }

    public Integer getMotivo_cancelacion() {
        return motivo_cancelacion;
    }

    public void setDesc_cancelacion(String desc_cancelacion) {
        this.desc_cancelacion = desc_cancelacion;
    }

    public String getDesc_cancelacion() {
        return desc_cancelacion;
    }

    public void setHora_agenda_fin(String hora_agenda_fin) {
        this.hora_agenda_fin = hora_agenda_fin;
    }

    public String getHora_agenda_fin() {
        return hora_agenda_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setDesc_cita(String desc_cita) {
        this.desc_cita = desc_cita;
    }

    public String getDesc_cita() {
        return desc_cita;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setId_profesional(BigDecimal id_profesional) {
        this.id_profesional = id_profesional;
    }

    public BigDecimal getId_profesional() {
        return id_profesional;
    }

    public void setId_sede(BigDecimal id_sede) {
        this.id_sede = id_sede;
    }

    public BigDecimal getId_sede() {
        return id_sede;
    }

    public void setId_paciente(Chusuario id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Chusuario getId_paciente() {
        return id_paciente;
    }

    public void setEspecialidad(Cpservicio especialidad) {
        this.especialidad = especialidad;
    }

    public Cpservicio getEspecialidad() {
        return especialidad;
    }

    public void setTieneConsulta(boolean tieneConsulta) {
        this.tieneConsulta = tieneConsulta;
    }

    public boolean isTieneConsulta() {
        return tieneConsulta;
    }

    public void setDesConsulta(String desConsulta) {
        this.desConsulta = desConsulta;
    }

    public String getDesConsulta() {
        return desConsulta;
    }

    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public Date getFecha_atencion() {
        return fecha_atencion;
    }

    public void setConsulta_cln(Long consulta_cln) {
        this.consulta_cln = consulta_cln;
    }

    public Long getConsulta_cln() {
        return consulta_cln;
    }
}
