package org.profamilia.hc.view.backing.clinico.consultorio;

import java.math.BigDecimal;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcontrolpre;
import org.profamilia.hc.model.dto.ChcontrolprePK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGinecoObstetricosBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ExamenFisicoPrenatal extends BaseBean {


    private Chcontrolpre control;

    private List lstNormal;

    private List lstOpciones;

    private List lstResultado;

    private boolean habilitarAlturaUterina;

    private boolean habilitarFCF;

    private boolean habilitarmovimientoFetal;

    private boolean habilitarpresentacionFetal;


    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

    /**Almacena el bean de Antecedentes Ginecologicos */

    AntecedentesGinecoObstetricosBean antecedentes;

    private boolean existeParcial;


    /** Almacena true si la temperatura es Febril*/
    private boolean esFebril;

    private List lstTemperatura;

    Date fechaUltimaRegla;

    private Integer semanaGestacion;

    private Integer tipoHistoria;


    public ExamenFisicoPrenatal() {
  
    }

    public void init() {
        control = new Chcontrolpre();
        lstNormal = new ArrayList();
        lstOpciones = new ArrayList();
        lstResultado = new ArrayList();
        lstTemperatura = new ArrayList();


        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");


        antecedentes = 
                (AntecedentesGinecoObstetricosBean)FacesUtils.getManagedBean("antecedentesObsteticosBean");

     
        if (semanaGestacion != null) {
            // Si estamos en la semana 15 o superior se pide la alturauterina
            if (semanaGestacion.compareTo(15) >= 0) {
                habilitarAlturaUterina = true;
            } else {
                habilitarAlturaUterina = false;
            }
            // Si estamos en la semana 18 o superior pedimos la frecuencia cardiaca fetal
            if (semanaGestacion.compareTo(18) >= 0) {
                habilitarFCF = true;
            } else {
                habilitarFCF = false;
            }
            // Si estamos en la semana 20 o superior pedimos el movimiento fetal
            if (semanaGestacion.compareTo(20) >= 0) {
                habilitarmovimientoFetal = true;
            } else {
                habilitarmovimientoFetal = false;
            }

            // Si estamos en la semana 32 o superior pedimos la presentaci�n fetal
            if (semanaGestacion.compareTo(32) >= 0) {
                habilitarpresentacionFetal = true;
            } else {
                habilitarpresentacionFetal = false;
            }

        }

        if (datosUsuario != null && datosUsuario.getConsulta() != null) {
            try {
                control = 
                        this.serviceLocator.getClinicoService().getControlPrenatal(datosUsuario.getConsulta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (control == null) {
            control = new Chcontrolpre();
        }
    }

    /**
     * @param control
     */
    public void setControl(Chcontrolpre control) {
        this.control = control;
    }

    /**
     * @return
     */
    public Chcontrolpre getControl() {
        return control;
    }

    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    /**
     * @param lstNormal
     */
    public void setLstNormal(List lstNormal) {
        this.lstNormal = lstNormal;
    }

    /**
     * @return
     */
    public List getLstNormal() {
        if (lstNormal.size() == 0) {
            lstNormal.add(new SelectItem("N", "Normal"));
            lstNormal.add(new SelectItem("A", "Anormal"));

        }

        return lstNormal;
    }

    public void setTalla(ValueChangeEvent valueChangeEvent) {
        control.setHcpatalla((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setTipoTempSelect(ValueChangeEvent valueChangeEvent) {
        control.setHcpetipotemper((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }

    public void setLstResultado(List lstResultado) {
        this.lstResultado = lstResultado;
    }

    public List getLstResultado() {
        if (lstResultado.size() == 0) {
            lstResultado.add(new SelectItem("+", "+"));
            lstResultado.add(new SelectItem("-", "-"));

        }

        return lstResultado;
    }


    /**
     * @param esFebril
     */
    public void setEsFebril(boolean esFebril) {
        this.esFebril = esFebril;
    }

    /**
     * @return
     */
    public boolean isEsFebril() {
        return esFebril;
    }

    /**
     * @param existeParcial
     */
    public void setExisteParcial(boolean existeParcial) {
        this.existeParcial = existeParcial;
    }

    /**
     * @return
     */
    public boolean isExisteParcial() {
        return existeParcial;
    }

    /**
     * @param habilitarAlturaUterina
     */
    public void setHabilitarAlturaUterina(boolean habilitarAlturaUterina) {
        this.habilitarAlturaUterina = habilitarAlturaUterina;
    }

    /**
     * @return
     */
    public boolean isHabilitarAlturaUterina() {
        return habilitarAlturaUterina;
    }

    /**
     * @param habilitarFCF
     */
    public void setHabilitarFCF(boolean habilitarFCF) {
        this.habilitarFCF = habilitarFCF;
    }

    /**
     * @return
     */
    public boolean isHabilitarFCF() {
        return habilitarFCF;
    }

    /**
     * @param habilitarmovimientoFetal
     */
    public void setHabilitarmovimientoFetal(boolean habilitarmovimientoFetal) {
        this.habilitarmovimientoFetal = habilitarmovimientoFetal;
    }

    /**
     * @return
     */
    public boolean isHabilitarmovimientoFetal() {
        return habilitarmovimientoFetal;
    }

    /**
     * @param habilitarpresentacionFetal
     */
    public void setHabilitarpresentacionFetal(boolean habilitarpresentacionFetal) {
        this.habilitarpresentacionFetal = habilitarpresentacionFetal;
    }

    /**
     * @return
     */
    public boolean isHabilitarpresentacionFetal() {
        return habilitarpresentacionFetal;
    }


    /**
     * @param semanaGestacion
     */
    public void setSemanaGestacion(Integer semanaGestacion) {
        this.semanaGestacion = semanaGestacion;
    }

    /**
     * @return
     */
    public Integer getSemanaGestacion() {
        return semanaGestacion;
    }


    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chcontrolpre controlAux = null;
        if (datosUsuario != null && datosUsuario.getConsulta() != null) {
            try {
                controlAux = 
                        this.serviceLocator.getClinicoService().getControlPrenatal(datosUsuario.getConsulta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (controlAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    public void calcularIMC() {
        String imcStr = null;
        BigDecimal talla = null;
        BigDecimal peso = null;
        String masacor = null;
        if (control != null) {
            talla = control.getHcpatalla();
            peso = control.getHcpapeso();
        }

        double imc = 0;
        if (talla != null && peso != null) {
            if (talla.doubleValue() != 0 && peso.doubleValue() != 0) {
                imc = 
peso.doubleValue() / ((talla.doubleValue()) * (talla.doubleValue()));
            }

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            imcStr = nf.format(imc);
            if (imcStr != null && !imcStr.equals("")) {
                masacor = imcStr.replace(",", ".");
            } else {
                masacor = null;
            }

            if (masacor != null) {
                control.setHcpaimc(new BigDecimal(masacor));
            }

        }

    }


    /**
     * @param lstTemperatura
     */
    public void setLstTemperatura(List lstTemperatura) {
        this.lstTemperatura = lstTemperatura;
    }

    /**
     * @return
     */
    public List getLstTemperatura() {
        if (lstTemperatura.size() == 0) {
            lstTemperatura.add(new SelectItem("", "Seleccione una opci�n"));
            lstTemperatura.add(new SelectItem("A", "Afebril"));
            lstTemperatura.add(new SelectItem("F", "Febril"));
        }
        return lstTemperatura;
    }

    public void changeTemperatura() {
        if (control != null && control.getHcpetipotemper().equals("F")) {
            esFebril = true;
        } else {
            esFebril = false;
        }
    }


    


    public void aceptar() {

        ChcontrolprePK id = new ChcontrolprePK();

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            Long idConsulta = 
                new Long(datosUsuario.getConsulta().getCconnumero());
            id.setHcplconsulta(idConsulta);
            id.setHcpctiposervi(TIPO_CONSULTA);
            control.setId(id);
            control.setHcplconsulprin(idConsulta);
        }


        control.setHcpdfecharegis(new Date());
        control.setHcpcoperador(userName());
        try {
            this.serviceLocator.getClinicoService().saveControlPrenatal(control);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
    }


   
}
