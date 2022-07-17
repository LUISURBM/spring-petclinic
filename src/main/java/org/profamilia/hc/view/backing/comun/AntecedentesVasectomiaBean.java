//=======================================================================
// ARCHIVO AntecedenteGinecologicoBean.java
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano
// Descripcion: permite registrar antecedentes ginecologicos 
// para un Usuario de una Histroia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.comun;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantecvasec;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chparaclinic;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE AntecedenteGinecologicoBean
//=======================================================================
public class AntecedentesVasectomiaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chantecvasec antecedente;
    private Integer tipoHistoria;
    private String navigationRule;
    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;
    private String nextAction;
    private Long numeroConsulta;
    private List lstOpciones;
    private boolean mostrarAntecedentes;
    private boolean mostrarOtraRazon;
    private boolean mostrarOtroMetodo;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    public AntecedentesVasectomiaBean() {
        inicializarOtrosAntecedentes();


    }


    public void inicializarOtrosAntecedentes() {

        mostrarAntecedentes = false;
        mostrarOtraRazon = false;
        mostrarOtroMetodo = false;

        if (numeroConsulta != null) {

            try {
                antecedente = 
                        this.serviceLocator.getClinicoService().getAntecedenteVasectomia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (antecedente != null) {

            if (antecedente.getHavcvaseante() != null && 
                antecedente.getHavcvaseante().equals("S")) {
                mostrarAntecedentes = true;
            } else {
                mostrarAntecedentes = false;
            }


            if (antecedente.getHavcrazoproc() != null && antecedente.getHavcrazoproc().equals("OT")) {
                mostrarOtraRazon = true;
            } else {
                mostrarOtraRazon = false;
            }

            if (antecedente.getHavcmetoplan() != null && antecedente.getHavcmetoplan().equals("OT")) {
                mostrarOtroMetodo = true;
            } else {
                mostrarOtroMetodo = false;
            }


        } else {

            antecedente = new Chantecvasec();
        }

    }

    public boolean esValido() {
        boolean esValido = false;
        Chantecvasec aux = null;
        if (numeroConsulta != null) {

            try {
                aux = 
this.serviceLocator.getClinicoService().getAntecedenteVasectomia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (aux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    // AJAX
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setNuevosAntecedentes(ValueChangeEvent valueChangeEvent) {
        antecedente.setHavcvaseante((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setAntecedente(Chantecvasec antecedente) {
        this.antecedente = antecedente;
    }

    public Chantecvasec getAntecedente() {
        return antecedente;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }
        return lstOpciones;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }


    //-----------------------------------------------------------------------
    //  METODO PRINCIPAL
    //-----------------------------------------------------------------------


    public String aceptar() {
        navigationRule = "";

        antecedente.setHavcoperador(userName());
        antecedente.setHavdfecregistr(new Date());
        antecedente.setHavlconsulta(numeroConsulta);

        if (antecedente != null) {
            try {
                this.getServiceLocator().getClinicoService().saveAntecedentesVasectomia(antecedente);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            } catch (ModelException e) {
                navigationRule = "";
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
            catch (Exception ex) {
                           navigationRule = "";
                           return capturaError(ex,IConstantes.ERROR_GUARDADO);
            }
        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_VALIDACION_ANTECEDENTES);
        }

        return navigationRule;

    }


    public void changeOtrosAntecedentes() {
        if (antecedente.getHavcvaseante().equals("S")) {
            mostrarAntecedentes = true;
        } else {
            mostrarAntecedentes = false;
        }
    }

    public void changeOtraRazon() {
        if (antecedente.getHavcrazoproc().equals("OT")) {
            mostrarOtraRazon = true;
        } else {
            mostrarOtraRazon = false;
        }
    }

    public void ChangeOtroMetodo() {
        if (antecedente.getHavcmetoplan().equals("OT")) {
            mostrarOtroMetodo = true;
        } else {
            mostrarOtroMetodo = false;
        }
    }


    public void setMostrarAntecedentes(boolean mostrarAntecedentes) {
        this.mostrarAntecedentes = mostrarAntecedentes;
    }

    public boolean isMostrarAntecedentes() {
        return mostrarAntecedentes;
    }

    public void setMostrarOtraRazon(boolean mostrarOtraRazon) {
        this.mostrarOtraRazon = mostrarOtraRazon;
    }

    public boolean isMostrarOtraRazon() {
        return mostrarOtraRazon;
    }

    public void setMostrarOtroMetodo(boolean mostrarOtroMetodo) {
        this.mostrarOtroMetodo = mostrarOtroMetodo;
    }

    public boolean isMostrarOtroMetodo() {
        return mostrarOtroMetodo;
    }
}
