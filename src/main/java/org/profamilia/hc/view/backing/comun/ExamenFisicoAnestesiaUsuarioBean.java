//=======================================================================
// ARCHIVO 
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chexafisane;
import org.profamilia.hc.model.dto.ChexafisanePK;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================
public class ExamenFisicoAnestesiaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    /** Almacena el examen fisico que se va a guardar  */
    private Chexafisane examen;


    /** Almacena true si los datos ingresados son correctos*/
    private boolean exito;

    /** Almacena true si la historia es de pediatria  */
    private boolean esPediatria;

    private boolean tieneprotesissuperior;

    private boolean tieneprotesisinferior;

    private Integer tipoHistoria;

    private List lstOpciones;

    private List lstTipoProtesis;

    private List lstGradoProtesis;

    private List lstMallampati;

    private List lstMovilidadAnterior;

    private List lstMovilidadAtlanto;

    private List lstEvaluacion;

    private List lstMovilidadProtesis;

    private boolean mostrarProtesis;

    private UIInput mnuGradoProtesisInferior;

    private UIInput mnuMovilidadInferior;

    private UIInput mnuGradoSuperior;

    private UIInput mnuMovilidadSuperior;

    private UIInput checkProtesisInferior;

    private UIInput checkProtesisSuperior;


    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;
    


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ExamenFisicoAnestesiaUsuarioBean() {
    }

    public void init() {
        examen = new Chexafisane();
        nextAction = "";
        inicializarExamenAnestesia();
    }

    public void inicializarExamenAnestesia() {
        try {
            examen = 
                    this.getServiceLocator().getClinicoService().getExamenFisicoAnestesia(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (examen == null) {
            examen = new Chexafisane();
        } else {
          
           
           if (examen.getHeactieneprote() != null && 
                examen.getHeactieneprote().equals("S")) {
                mostrarProtesis = true;
            } else {
                mostrarProtesis = false;
            }
            
            
            if (examen.getHeactieneprosu()!= null && examen.getHeactieneprosu().equals("S")) {
                    tieneprotesissuperior = true; 
            }else{
                tieneprotesissuperior = false; 
            }
            
            if (examen.getHeactieneproin()!= null && examen.getHeactieneproin().equals("S")) {
                    tieneprotesisinferior = true; 
            }else{
                tieneprotesisinferior = false; 
            }
            
        

        }

    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


     /**
     * @param examen
     */
    public void setExamen(Chexafisane examen) {
        this.examen = examen;
    }

    /**
     * @return
     */
    public Chexafisane getExamen() {
        return examen;
    }

    /**
     * @param esPediatria
     */
    public void setEsPediatria(boolean esPediatria) {
        this.esPediatria = esPediatria;
    }

    /**
     * @return
     */
    public boolean isEsPediatria() {
        return esPediatria;
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
     * @return
     */
    public UIInput getMnuGradoProtesisInferior() {
        return mnuGradoProtesisInferior;
    }

    /**
     * @param mnuMovilidadInferior
     */
    public void setMnuMovilidadInferior(UIInput mnuMovilidadInferior) {
        this.mnuMovilidadInferior = mnuMovilidadInferior;
    }

    /**
     * @return
     */
    public UIInput getMnuMovilidadInferior() {
        return mnuMovilidadInferior;
    }

    /**
     * @param mnuGradoSuperior
     */
    public void setMnuGradoSuperior(UIInput mnuGradoSuperior) {
        this.mnuGradoSuperior = mnuGradoSuperior;
    }

    /**
     * @return
     */
    public UIInput getMnuGradoSuperior() {
        return mnuGradoSuperior;
    }

    /**
     * @param mnuMovilidadSuperior
     */
    public void setMnuMovilidadSuperior(UIInput mnuMovilidadSuperior) {
        this.mnuMovilidadSuperior = mnuMovilidadSuperior;
    }

    /**
     * @return
     */
    public UIInput getMnuMovilidadSuperior() {
        return mnuMovilidadSuperior;
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

    /**
     * @param lstTipoProtesis
     */
    public void setLstTipoProtesis(List lstTipoProtesis) {
        this.lstTipoProtesis = lstTipoProtesis;
    }

    /**
     * @return
     */
    public List getLstTipoProtesis() {
        if (lstTipoProtesis == null || lstTipoProtesis.isEmpty()) {
            lstTipoProtesis = new ArrayList();
            lstTipoProtesis.add(new SelectItem("I", "Inferior"));
            lstTipoProtesis.add(new SelectItem("S", "Superior"));
        }
        return lstTipoProtesis;
    }

    /**
     * @param lstGradoProtesis
     */
    public void setLstGradoProtesis(List lstGradoProtesis) {
        this.lstGradoProtesis = lstGradoProtesis;
    }

    /**
     * @return
     */
    public List getLstGradoProtesis() {
        if (lstGradoProtesis == null || lstGradoProtesis.isEmpty()) {
            lstGradoProtesis = new ArrayList();
            lstGradoProtesis.add(new SelectItem("P", "Parcial"));
            lstGradoProtesis.add(new SelectItem("T", "Total"));
        }
        return lstGradoProtesis;
    }

    /**
     * @param lstMallampati
     */
    public void setLstMallampati(List lstMallampati) {
        this.lstMallampati = lstMallampati;
    }

    /**
     * @return
     */
    public List getLstMallampati() {
        if (lstMallampati == null || lstMallampati.isEmpty()) {
            lstMallampati = new ArrayList();
            lstMallampati.add(new SelectItem("", "Seleccione una Opci�n"));
            lstMallampati.add(new SelectItem("I", "Grado I"));
            lstMallampati.add(new SelectItem("II", "Grado II"));
            lstMallampati.add(new SelectItem("III", "Grado III"));
            lstMallampati.add(new SelectItem("IV", "Grado IV"));
        }
        return lstMallampati;
    }

    /**
     * @param lstMovilidadAnterior
     */
    public void setLstMovilidadAnterior(List lstMovilidadAnterior) {
        this.lstMovilidadAnterior = lstMovilidadAnterior;
    }

    /**
     * @return
     */
    public List getLstMovilidadAnterior() {
        if (lstMovilidadAnterior == null || lstMovilidadAnterior.isEmpty()) {
            lstMovilidadAnterior = new ArrayList();
            lstMovilidadAnterior.add(new SelectItem("", 
                                                    "Seleccione una Opci�n"));
            lstMovilidadAnterior.add(new SelectItem("A", 
                                                    "Dientes inferiores pasan m�s adelante que los dientes superiores"));
            lstMovilidadAnterior.add(new SelectItem("B", 
                                                    "Dientes superiores e inferiores se encuentran a la misma altura"));
            lstMovilidadAnterior.add(new SelectItem("C", 
                                                    "Los dientes inferiores no pasan los superiores"));

        }
        return lstMovilidadAnterior;
    }

    /**
     * @param lstMovilidadAtlanto
     */
    public void setLstMovilidadAtlanto(List lstMovilidadAtlanto) {
        this.lstMovilidadAtlanto = lstMovilidadAtlanto;
    }

    /**
     * @return
     */
    public List getLstMovilidadAtlanto() {
        if (lstMovilidadAtlanto == null || lstMovilidadAtlanto.isEmpty()) {
            lstMovilidadAtlanto = new ArrayList();
            lstMovilidadAtlanto.add(new SelectItem("", 
                                                   "Seleccione una Opci�n"));
            lstMovilidadAtlanto.add(new SelectItem("1", 
                                                   "Normal. Dedo �ndice izquierdo m�s alto que el derecho"));
            lstMovilidadAtlanto.add(new SelectItem("2", 
                                                   "Limitaci�n. Dedos a la misma altura"));
            lstMovilidadAtlanto.add(new SelectItem("3", 
                                                   "Severa limitaci�n. Izquierdo m�s bajo que derecho"));
        }
        return lstMovilidadAtlanto;
    }

    /**
     * @param lstEvaluacion
     */
    public void setLstEvaluacion(List lstEvaluacion) {
        this.lstEvaluacion = lstEvaluacion;
    }

    /**
     * @return
     */
    public List getLstEvaluacion() {
        if (lstEvaluacion == null || lstEvaluacion.isEmpty()) {
            lstEvaluacion = new ArrayList();
            lstEvaluacion.add(new SelectItem("F", "F�cil"));
            lstEvaluacion.add(new SelectItem("D", "Dif�cil"));
        }
        return lstEvaluacion;
    }

    /**
     * @param mostrarProtesis
     */
    public void setMostrarProtesis(boolean mostrarProtesis) {
        this.mostrarProtesis = mostrarProtesis;
    }

    /**
     * @return
     */
    public boolean isMostrarProtesis() {
        return mostrarProtesis;
    }


    /**
     * @param tieneprotesissuperior
     */
    public void setTieneprotesissuperior(boolean tieneprotesissuperior) {
        this.tieneprotesissuperior = tieneprotesissuperior;
    }

    /**
     * @return
     */
    public boolean isTieneprotesissuperior() {
        return tieneprotesissuperior;
    }

    /**
     * @param tieneprotesisinferior
     */
    public void setTieneprotesisinferior(boolean tieneprotesisinferior) {
        this.tieneprotesisinferior = tieneprotesisinferior;
    }

    /**
     * @return
     */
    public boolean isTieneprotesisinferior() {
        return tieneprotesisinferior;
    }

    /**
     * @param lstMovilidadProtesis
     */
    public void setLstMovilidadProtesis(List lstMovilidadProtesis) {
        this.lstMovilidadProtesis = lstMovilidadProtesis;
    }

    /**
     * @return
     */
    public List getLstMovilidadProtesis() {
        if (lstMovilidadProtesis == null || lstMovilidadProtesis.isEmpty()) {
            lstMovilidadProtesis = new ArrayList();
            lstMovilidadProtesis.add(new SelectItem("M", "Movil"));
            lstMovilidadProtesis.add(new SelectItem("F", "Fija"));

        }
        return lstMovilidadProtesis;
    }

    /**
     * @param mnuGradoProtesisInferior
     */
    public void setMnuGradoProtesisInferior(UIInput mnuGradoProtesisInferior) {
        this.mnuGradoProtesisInferior = mnuGradoProtesisInferior;
    }


    /**
     * @param checkProtesisInferior
     */
    public void setCheckProtesisInferior(UIInput checkProtesisInferior) {
        this.checkProtesisInferior = checkProtesisInferior;
    }

    /**
     * @return
     */
    public UIInput getCheckProtesisInferior() {
        return checkProtesisInferior;
    }

    /**
     * @param checkProtesisSuperior
     */
    public void setCheckProtesisSuperior(UIInput checkProtesisSuperior) {
        this.checkProtesisSuperior = checkProtesisSuperior;
    }

    /**
     * @return
     */
    public UIInput getCheckProtesisSuperior() {
        return checkProtesisSuperior;
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
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
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

    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setHeactieneprote(ValueChangeEvent valueChangeEvent) {
        examen.setHeactieneprote((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneprotesisinferior(ValueChangeEvent valueChangeEvent) {
        setTieneprotesisinferior((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneprotesissuperior(ValueChangeEvent valueChangeEvent) {
        setTieneprotesissuperior((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


  


    public void changeProtesis() {
        if (examen != null && examen.getHeactieneprote() != null && 
            examen.getHeactieneprote().equals("S")) {
            mostrarProtesis = true;
        } else {
            mostrarProtesis = false;
            tieneprotesisinferior = false;
            tieneprotesissuperior = false;
            checkProtesisInferior.setValue(null);
            checkProtesisSuperior.setValue(null);
        }

    }

    public void changeProtesisInferior() {
        if (tieneprotesisinferior) {
            examen.setHeactieneproin("S");
        } else {
            examen.setHeactieneproin("N");
            examen.setHeacgradoproin(null);
            examen.setHeacmovilproin(null);
            mnuGradoProtesisInferior.setValue(null);
            mnuMovilidadInferior.setValue(null);
        }
    }

    public void changeProtesisSuperior() {
        if (tieneprotesissuperior) {
            examen.setHeactieneprosu("S");
        } else {
            examen.setHeactieneprosu("N");
            mnuGradoSuperior.setValue(null);
            mnuMovilidadSuperior.setValue(null);
            examen.setHeacgradoprosu(null);
            examen.setHeacmovilprosu(null);
        }
    }

   

   


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la bade de datos
    //------------------------------------------------------------------------------------------------


    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chexafisane examenAux = null;
        if (consulta != null) {
            try {
                examenAux = 
                        this.getServiceLocator().getClinicoService().getExamenFisicoAnestesia(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (examenAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public String aceptar() {

        ChexafisanePK id = new ChexafisanePK();
        navigationRule = "";

        if (tieneprotesisinferior) {
            examen.setHeactieneproin("S");
        } else {
            examen.setHeactieneproin("N");
        }

        if (tieneprotesissuperior) {
            examen.setHeactieneprosu("S");
        } else {
            examen.setHeactieneprosu("N");
        }
        exito = true;
            

        if (exito) {
            if (consulta != null && consulta.getCconnumero() != null) {
                id.setHealconsulta(new Long(consulta.getCconnumero()));
                id.setHeactiposervi(tipoServicio);
                examen.setId(id);
            }
            examen.setHeacoperador(userName());
            examen.setHeadfecregistr(new Date());
            


            try {
                this.getServiceLocator().getClinicoService().saveExamenFisicoAnestesia(examen);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = null;
                e.printStackTrace();

            }


        }


        return navigationRule;
    }

}
