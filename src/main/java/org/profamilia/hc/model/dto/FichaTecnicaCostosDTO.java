package org.profamilia.hc.model.dto;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;


public class FichaTecnicaCostosDTO {

    private String codigoServicio;
    private String nombreServicio;
    private String lote;
    private List<SelectItem>lstLotes;
    private Date fechaVencimiento;
    private String utilizo;
    private boolean renderFecha;
    private String trazador;
    private Long cantidad;
    private String cargo;
    private String codigoInsumo;
    private String unidadUso;
    public FichaTecnicaCostosDTO() {
    }


    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getLote() {
        return lote;
    }

    public void setLstLotes(List<SelectItem> lstLotes) {
        this.lstLotes = lstLotes;
    }

    public List<SelectItem> getLstLotes() {
        return lstLotes;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setUtilizo(String utilizo) {
        this.utilizo = utilizo;
    }

    public String getUtilizo() {
        return utilizo;
    }

    public void setRenderFecha(boolean renderFecha) {
        this.renderFecha = renderFecha;
    }

    public boolean isRenderFecha() {
        return renderFecha;
    }

    public void setTrazador(String trazador) {
        this.trazador = trazador;
    }

    public String getTrazador() {
        return trazador;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCodigoInsumo(String codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setUnidadUso(String unidadUso) {
        this.unidadUso = unidadUso;
    }

    public String getUnidadUso() {
        return unidadUso;
    }
}
