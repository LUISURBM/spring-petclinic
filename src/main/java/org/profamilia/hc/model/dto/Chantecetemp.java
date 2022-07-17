package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


/** @author Hibernate CodeGenerator */
public class Chantecetemp implements Serializable {

    /** identifier field */
    private ChantecetempPK id;

    /** nullable persistent field */
    private Integer hatnpregunta;

    /** nullable persistent field */
    private String haterespuest;

    /** nullable persistent field */
    private String hatcmetodoplan;

    /** nullable persistent field */
    private Date hatdfecregistr;

    /** nullable persistent field */
    private String hatcoperador;

    /** nullable persistent field */
    private Integer version;

    /** Variable que almacena la descripcion de la pregunta */
    private

    String hatcdescripc;

    /** Almacena una lista con las opciones de Si o No */
    private List lstOpciones;

    private String codigoprincipal;


    /** default constructor */
    public Chantecetemp() {
    }


    public Integer getHatnpregunta() {
        return this.hatnpregunta;
    }

    public void setHatnpregunta(Integer hatnpregunta) {
        this.hatnpregunta = hatnpregunta;
    }

    public String getHaterespuest() {
        return this.haterespuest;
    }

    public void setHaterespuest(String haterespuest) {
        this.haterespuest = haterespuest;
    }

    public void setHaterespuest(ValueChangeEvent valueChangeEvent) {
        setHaterespuest((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public Date getHatdfecregistr() {
        return this.hatdfecregistr;
    }

    public void setHatdfecregistr(Date hatdfecregistr) {
        this.hatdfecregistr = hatdfecregistr;
    }

    public String getHatcoperador() {
        return this.hatcoperador;
    }

    public void setHatcoperador(String hatcoperador) {
        this.hatcoperador = hatcoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public void setHatcdescripc(String hatcdescripc) {
        this.hatcdescripc = hatcdescripc;
    }

    public String getHatcdescripc() {

        if (this.hatnpregunta.equals(1)) {
            hatcdescripc = 
                    "Recibi� usted informaci�n o asesor�a sobre todos los " + 
                    "m�todos temporales de planificaci�n familiar? ";
        }
        if (this.hatnpregunta.equals(2)) {
            hatcdescripc = 
                    "Recibi� usted informaci�n o asesor�a sobre todos los " + 
                    "m�todos definitivos de planificaci�n familiar?";
        }
        if (this.hatnpregunta.equals(3)) {
            hatcdescripc = "Est� usted embarazada o cree que lo est�?";
        }
        if (this.hatnpregunta.equals(4)) {
            hatcdescripc = "Su �ltima menstruaci�n fue normal? ";
        }
        if (this.hatnpregunta.equals(5)) {
            hatcdescripc = 
                    "Usted o su pareja utilizan actualmente un m�todo de planificaci�n familiar?";
        }
        if (this.hatnpregunta.equals(6)) {
            hatcdescripc = 
                    "Sabe usted que los m�todos temporales pueden " + "fallar aun us�ndolos consistentemente?";
        }
        if (this.hatnpregunta.equals(7)) {
            hatcdescripc = 
                    "Recibi� informaci�n suficiente para suscribir el consentimiento" + 
                    " informado para el m�todo temporal solicitado? ";
        }

        return hatcdescripc;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }
        return lstOpciones;
    }

    public void setId(ChantecetempPK id) {
        this.id = id;
    }

    public ChantecetempPK getId() {
        return id;
    }

    public void setHatcmetodoplan(String hatcmetodoplan) {
        this.hatcmetodoplan = hatcmetodoplan;
    }

    public String getHatcmetodoplan() {
        return hatcmetodoplan;
    }

    public void setCodigoprincipal(String codigoprincipal) {
        this.codigoprincipal = codigoprincipal;
    }

    public String getCodigoprincipal() {
        return codigoprincipal;
    }
}
