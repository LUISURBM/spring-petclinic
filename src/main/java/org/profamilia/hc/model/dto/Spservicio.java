package org.profamilia.hc.model.dto;

import java.math.BigDecimal;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.event.ValueChangeEvent;


public class Spservicio implements java.io.Serializable   {
   
   
   
   private String codigoservi;
   private String nombreservi;
   private String valorservi;
   private String descjovenservi;
   private String descjovenadulservi;
   private String descempleado;
   private String lugarservi;
   private Integer cantservi;


    public void setCodigoservi(String codigoservi) {
        this.codigoservi = codigoservi;
    }

    public String getCodigoservi() {
        return codigoservi;
    }

    public void setNombreservi(String nombreservi) {
        this.nombreservi = nombreservi;
    }

    public String getNombreservi() {
        return nombreservi;
    }

    public void setValorservi(String valorservi) {
        this.valorservi = valorservi;
    }

    public String getValorservi() {
        return valorservi;
    }

    public void setDescjovenservi(String descjovenservi) {
        this.descjovenservi = descjovenservi;
    }

    public String getDescjovenservi() {
        return descjovenservi;
    }

    public void setDescjovenadulservi(String descjovenadulservi) {
        this.descjovenadulservi = descjovenadulservi;
    }

    public String getDescjovenadulservi() {
        return descjovenadulservi;
    }

    public void setDescempleado(String descempleado) {
        this.descempleado = descempleado;
    }

    public String getDescempleado() {
        return descempleado;
    }


    public void setLugarservi(String lugarservi) {
        this.lugarservi = lugarservi;
    }

    public String getLugarservi() {
        return lugarservi;
    }
    public void setLugarservi(ValueChangeEvent valueChangeEvent) {
        setLugarservi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param cantservi
     */
    public void setCantservi(Integer cantservi) {
        this.cantservi = cantservi;
    }

    /**
     * @return
     */
    public Integer getCantservi() {
        return cantservi;
    }


    
}


