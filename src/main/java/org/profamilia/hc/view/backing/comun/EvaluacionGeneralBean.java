//=======================================================================
// ARCHIVO EvaluacionGeneralBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la Evaluacion General
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chevalugener;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=================================================================
//  CLASE EvaluacionGeneralBean
//=======================================================================
/**
 * EvaluacionGeneralBean: Permite registrar los Datos correspondientes a los antecedentes psicologicos
 * @author Jos� Andr�s Riano jariano@profamilia.org.co
 * 
 */
public class

EvaluacionGeneralBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chevalugener evaluacion;

    private String tipoServicio;
    private Long numeroConsulta;
    private Integer tipoHistoria;
    private Chusuario usuario;
    private String nextAction;
    private String menuBean;

    private String navigationRule;

    private List lstAreaCognitiva;

    private List lstAreaAfectiva;

    private List<String> lstAreaCognitivaSelect;

    private List<String> lstAreaAfectivaSelect;

    private List lstOpciones;

    private boolean renderApoyoFamiliar;

    private boolean renderCanales;

    private boolean renderLaboral;

    private boolean renderRelaciones;
    
    private String ObservacionesExamenMental;
    
    private boolean renderComunicacionAdicional;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    public EvaluacionGeneralBean() {
    }

    //ACTIONS

    public void init() {
        lstAreaCognitivaSelect = new ArrayList<String>();
        lstAreaAfectivaSelect = new ArrayList<String>();
        renderComunicacionAdicional = false;

    }

    public void inicializarEvaluacion() {
        if (numeroConsulta != null) {

            try {
                evaluacion = 
                        this.getServiceLocator().getClinicoService().getEvaluacionGeneral(numeroConsulta, 
                                                                                          TIPO_CONSULTA);

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }

        if (evaluacion == null) {
            evaluacion = new Chevalugener();
        } else {


            if (evaluacion.getHegcapoyofamil() != null && 
                evaluacion.getHegcapoyofamil().equals("S")) {
                renderApoyoFamiliar = true;
                renderComunicacionAdicional=true;
            } else {
                renderApoyoFamiliar = false;
                renderComunicacionAdicional=false;
            }


            if (evaluacion.getHegccanalcomun() != null && 
                evaluacion.getHegccanalcomun().equals("N")) {
                renderCanales = true;
            } else {
                renderCanales = false;
            }

            if (evaluacion.getHegcproblestud() != null && 
                evaluacion.getHegcproblestud().equals("S")) {
                renderLaboral = true;
            } else {
                renderLaboral = false;
            }


            if (evaluacion.getHegcrelacapoyo() != null && 
                evaluacion.getHegcrelacapoyo().equals("S")) {
                renderRelaciones = true;
            } else {
                renderRelaciones = false;
            }

            if (evaluacion.getHegcareacogni() != null && 
                !evaluacion.getHegcareacogni().equals("")) {
                StringTokenizer stk = 
                    new StringTokenizer(evaluacion.getHegcareacogni(), ",");
                String areacogniAux = null;

                while (stk.hasMoreTokens()) {
                    areacogniAux = "";
                    areacogniAux = stk.nextToken();
                    if (areacogniAux != null) {
                        lstAreaCognitivaSelect.add(areacogniAux);
                    }
                }

            }


            if (evaluacion.getHegcareaafect() != null && 
                !evaluacion.getHegcareaafect().equals("")) {
                StringTokenizer stk = 
                    new StringTokenizer(evaluacion.getHegcareaafect(), ",");
                String areaafectAux = null;

                while (stk.hasMoreTokens()) {
                    areaafectAux = "";
                    areaafectAux = stk.nextToken();
                    if (areaafectAux != null) {
                        lstAreaAfectivaSelect.add(areaafectAux);
                    }
                }

            }
            if (evaluacion.getHegcapoyofamil() != null && 
                evaluacion.getHegcapoyofamil().equals("S")) {
                renderComunicacionAdicional = true;
            } else {
                renderComunicacionAdicional = false;
    
            }


        }


    }

    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------   

    public String guardarEvaluacion() {
        navigationRule = "";
        String areaCognitiva;
        String areaAfectiva;
        areaCognitiva = "";
        areaAfectiva = "";

        if (numeroConsulta != null) {
            evaluacion.getId().setHegctiposerv(tipoServicio);
            evaluacion.getId().setHeglconsulta(numeroConsulta);
            evaluacion.setHegcoperador(userName());
            evaluacion.setHegdfecreg(new Date());
        }
        
        
        if (evaluacion.getHegcapoyofamil() == null || !evaluacion.getHegcapoyofamil().equals("S")) {
            evaluacion.setHegccualapoyo(null);
        }

        if (evaluacion.getHegccanalcomun() == null || !evaluacion.getHegccanalcomun().equals("N")) {
            evaluacion.setHegccualcanal(null);
        } 

        if (evaluacion.getHegcproblestud() == null || !evaluacion.getHegcproblestud().equals("S")) {
            evaluacion.setHegccualprobl(null);
        } 

        if (evaluacion.getHegcrelacapoyo() == null || !evaluacion.getHegcrelacapoyo().equals("S")) {
            evaluacion.setHegccualrelac(null);
        } 


        if (lstAreaCognitivaSelect != null && 
            !lstAreaCognitivaSelect.isEmpty()) {
            for (String areacog: lstAreaCognitivaSelect) {
                areaCognitiva = areaCognitiva + areacog + ",";
            }
            if (areaCognitiva != null && areaCognitiva.length() > 2) {
                areaCognitiva = 
                        areaCognitiva.substring(0, areaCognitiva.length() - 1);
                evaluacion.setHegcareacogni(areaCognitiva);
            }
        }

        if (lstAreaAfectivaSelect != null && 
            !lstAreaAfectivaSelect.isEmpty()) {
            for (String areaafec: lstAreaAfectivaSelect) {
                areaAfectiva = areaAfectiva + areaafec + ",";
            }

            if (areaAfectiva != null && areaAfectiva.length() > 2) {
                areaAfectiva = 
                        areaAfectiva.substring(0, areaAfectiva.length() - 1);
                evaluacion.setHegcareaafect(areaAfectiva);
            }
        }

        try {
            this.serviceLocator.getClinicoService().saveEvaluacionGeneral(evaluacion);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }

        return navigationRule;
    }


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Chevalugener evaluacionAux = null;

        if (numeroConsulta != null) {
            try {
                evaluacionAux = 
                        this.getServiceLocator().getClinicoService().getEvaluacionGeneral(numeroConsulta, 
                                                                                          TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (evaluacionAux != null) {
            return true;
        }

        return false;
    }

    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------


    /**
     * @param valueChangeEvent
     */
    public void setHegcapoyofamil(ValueChangeEvent valueChangeEvent) {
        evaluacion.setHegcapoyofamil((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHegccanalcomun(ValueChangeEvent valueChangeEvent) {
        evaluacion.setHegccanalcomun((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHegcproblestud(ValueChangeEvent valueChangeEvent) {
        evaluacion.setHegcproblestud((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHegcrelacapoyo(ValueChangeEvent valueChangeEvent) {
        evaluacion.setHegcrelacapoyo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeApoyoFamiliar() {
        if (evaluacion != null && evaluacion.getHegcapoyofamil() != null && 
            evaluacion.getHegcapoyofamil().equals("S")) {
            renderApoyoFamiliar = true;
            renderComunicacionAdicional = true;
        } else {
            renderApoyoFamiliar = false;
            renderComunicacionAdicional =false;
        }
    }

    public void changeCanales() {
        if (evaluacion != null && evaluacion.getHegccanalcomun() != null && 
            evaluacion.getHegccanalcomun().equals("N")) {
            renderCanales = true;
        } else {
            renderCanales = false;
        }
    }

    public void changeLaboral() {
        if (evaluacion != null && evaluacion.getHegcproblestud() != null && 
            evaluacion.getHegcproblestud().equals("S")) {
            renderLaboral = true;
        } else {
            renderLaboral = false;
        }
    }

    public void changeRelaciones() {
        if (evaluacion != null && evaluacion.getHegcrelacapoyo() != null && 
            evaluacion.getHegcrelacapoyo().equals("S")) {
            renderRelaciones = true;
        } else {
            renderRelaciones = false;
        }
    }


    //-----------------------------------------------------------------------
    //  get/set
    //-----------------------------------------------------------------------

    /**
     * @param evaluacion
     */
    public void setEvaluacion(Chevalugener evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * @return
     */
    public Chevalugener getEvaluacion() {
        return evaluacion;
    }

    /**
     * @param lstAreaCognitiva
     */
    public void setLstAreaCognitiva(List lstAreaCognitiva) {
        this.lstAreaCognitiva = lstAreaCognitiva;
    }

    /**
     * @return
     */
    public List getLstAreaCognitiva() {

        if (lstAreaCognitiva == null || lstAreaCognitiva.isEmpty()) {
            lstAreaCognitiva = new ArrayList();
            lstAreaCognitiva.add(new SelectItem("DI", "Disperso"));
            lstAreaCognitiva.add(new SelectItem("OR", "Orientado"));
            lstAreaCognitiva.add(new SelectItem("PC", "Pensamientos Claros"));
            lstAreaCognitiva.add(new SelectItem("TP", 
                                                "Trastornos del Pensamiento "));
            lstAreaCognitiva.add(new SelectItem("LC", "Lenguaje Claro"));
            lstAreaCognitiva.add(new SelectItem("IS", "Ideaci�n Suicida"));
            lstAreaCognitiva.add(new SelectItem("TS", 
                                                "Trastornos en el sue�o"));

        }
        return lstAreaCognitiva;
    }

    /**
     * @param lstAreaAfectiva
     */
    public void setLstAreaAfectiva(List lstAreaAfectiva) {
        this.lstAreaAfectiva = lstAreaAfectiva;
    }

    /**
     * @return
     */
    public List getLstAreaAfectiva() {
        if (lstAreaAfectiva == null || lstAreaAfectiva.isEmpty()) {
            lstAreaAfectiva = new ArrayList();
            lstAreaAfectiva.add(new SelectItem("TRA", "Tranquilo"));
            lstAreaAfectiva.add(new SelectItem("ANS", "Ansioso"));
            lstAreaAfectiva.add(new SelectItem("SDD", 
                                               "Sentimientos de desesperanza"));
            lstAreaAfectiva.add(new SelectItem("ANG", "Angustiado "));
            lstAreaAfectiva.add(new SelectItem("TRI", "Triste"));
            lstAreaAfectiva.add(new SelectItem("CON", "Confundido"));
            lstAreaAfectiva.add(new SelectItem("DES", "Desorientado"));
            lstAreaAfectiva.add(new SelectItem("TEM", "Temerosa/o "));
            lstAreaAfectiva.add(new SelectItem("EXP", "Explosivo"));
            lstAreaAfectiva.add(new SelectItem("APL", "Afecto Plano"));
        }
        return lstAreaAfectiva;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
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
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }


    /**
     * @param lstAreaCognitivaSelect
     */
    public void setLstAreaCognitivaSelect(List<String> lstAreaCognitivaSelect) {
        this.lstAreaCognitivaSelect = lstAreaCognitivaSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaCognitivaSelect() {
        return lstAreaCognitivaSelect;
    }

    /**
     * @param renderApoyoFamiliar
     */
    public void setRenderApoyoFamiliar(boolean renderApoyoFamiliar) {
        this.renderApoyoFamiliar = renderApoyoFamiliar;
    }

    /**
     * @return
     */
    public boolean isRenderApoyoFamiliar() {
        return renderApoyoFamiliar;
    }

    /**
     * @param renderCanales
     */
    public void setRenderCanales(boolean renderCanales) {
        this.renderCanales = renderCanales;
    }

    /**
     * @return
     */
    public boolean isRenderCanales() {
        return renderCanales;
    }

    /**
     * @param renderLaboral
     */
    public void setRenderLaboral(boolean renderLaboral) {
        this.renderLaboral = renderLaboral;
    }

    /**
     * @return
     */
    public boolean isRenderLaboral() {
        return renderLaboral;
    }

    /**
     * @param renderRelaciones
     */
    public void setRenderRelaciones(boolean renderRelaciones) {
        this.renderRelaciones = renderRelaciones;
    }

    /**
     * @return
     */
    public boolean isRenderRelaciones() {
        return renderRelaciones;
    }

    /**
     * @param lstAreaAfectivaSelect
     */
    public void setLstAreaAfectivaSelect(List<String> lstAreaAfectivaSelect) {
        this.lstAreaAfectivaSelect = lstAreaAfectivaSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaAfectivaSelect() {
        return lstAreaAfectivaSelect;
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
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }


    public void setObservacionesExamenMental(String observacionesExamenMental) {
        this.ObservacionesExamenMental = observacionesExamenMental;
    }

    public String getObservacionesExamenMental() {
        return ObservacionesExamenMental;
    }

    public void setRenderComunicacionAdicional(boolean renderComunicacionAdicional) {
        this.renderComunicacionAdicional = renderComunicacionAdicional;
    }

    public boolean isRenderComunicacionAdicional() {
        return renderComunicacionAdicional;
    }
}
