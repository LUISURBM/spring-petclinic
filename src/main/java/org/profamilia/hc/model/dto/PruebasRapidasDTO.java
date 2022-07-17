package org.profamilia.hc.model.dto;

import java.util.Date;


public class PruebasRapidasDTO {

   private String nombrePrueba;
   private String marca;
   private String lote;
   private String registroInvima;
   private String fechaVencimiento;
   private String resultado1;
   private String resultado2;
   private String nombrePersona;
   private String numIdentificacion;
   private String valorRes1;
   private String valorRes2;
   private String responsable;
   private Date fechaRegistro;
   

    public PruebasRapidasDTO() {
    }


    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getLote() {
        return lote;
    }

    public void setRegistroInvima(String registroInvima) {
        this.registroInvima = registroInvima;
    }

    public String getRegistroInvima() {
        return registroInvima;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setResultado1(String resultado1) {
        this.resultado1 = resultado1;
    }

    public String getResultado1() {
        return resultado1;
    }

    public void setResultado2(String resultado2) {
        this.resultado2 = resultado2;
    }

    public String getResultado2() {
        return resultado2;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setValorRes1(String valorRes1) {
        this.valorRes1 = valorRes1;
    }

    public String getValorRes1() {
        return valorRes1;
    }

    public void setValorRes2(String valorRes2) {
        this.valorRes2 = valorRes2;
    }

    public String getValorRes2() {
        return valorRes2;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getResponsable() {
        return responsable;
    }


    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
}
