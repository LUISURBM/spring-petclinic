//=======================================================================
// ARCHIVO 
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcuestanest;
import org.profamilia.hc.model.dto.ChcuestanestPK;
import org.profamilia.hc.model.dto.Chpreguanest;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================
public class CuestionarioPreanestesiaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List<Chpreguanest> lstPreguntasAnestesia;

    private List lstOpciones;

    private List<Chcuestanest> lstCuestionario;

    private HtmlDataTable dtCuestionario;

    /** Almacena el numero de cigarrillos que fuma en el dia el Usuario */
    private Integer fumadia;

    /** Almacena las observaciones Adicionales*/
    private String observacion;

    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public CuestionarioPreanestesiaUsuarioBean() {
    }


    public void init() {
        nextAction = "";
        inicializarCuestionario();
    }

    public void inicializarCuestionario() {
        Long numeroConsulta;
        numeroConsulta = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }

        if (numeroConsulta != null) {
            try {
                lstCuestionario = 
                        this.getServiceLocator().getClinicoService().getCuestionarioPreanestesia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }


        if (lstPreguntasAnestesia == null || lstPreguntasAnestesia.isEmpty()) {
            lstPreguntasAnestesia = new ArrayList<Chpreguanest>();
            try {
                lstPreguntasAnestesia = 
                        this.serviceLocator.getClinicoService().getPreguntasAnestesia();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstCuestionario == null || lstCuestionario.isEmpty()) {
            lstCuestionario = new ArrayList<Chcuestanest>();
        } else {

            Iterator it = lstCuestionario.iterator();

            while (it.hasNext()) {
                Chcuestanest cuesAux = (Chcuestanest)it.next();
                if (cuesAux != null) {
                    if (lstPreguntasAnestesia != null && 
                        !lstPreguntasAnestesia.isEmpty()) {
                        Iterator it2 = lstPreguntasAnestesia.iterator();
                        while (it2.hasNext()) {
                            Chpreguanest preguntaAux = 
                                (Chpreguanest)it2.next();
                            if (preguntaAux != null) {
                                if (preguntaAux.getHpancodigo().equals(cuesAux.getHcanpregunta())) {
                                    preguntaAux.setHpacrespuesta(cuesAux.getHcacrespuesta());
                                    preguntaAux.setHpacanotacion(cuesAux.getHcacanotacion());
                                    observacion = cuesAux.getHcacobservacio();
                                                        
                                }
                            }
                        }
                    }


                }
            }

        }

    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


    /**
     * @param lstPreguntasAnestesia
     */
    public void setLstPreguntasAnestesia(List<Chpreguanest> lstPreguntasAnestesia) {
        this.lstPreguntasAnestesia = lstPreguntasAnestesia;
    }

    /**
     * @return
     */
    public List<Chpreguanest> getLstPreguntasAnestesia() {
        return lstPreguntasAnestesia;
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
     * @param dtCuestionario
     */
    public void setDtCuestionario(HtmlDataTable dtCuestionario) {
        this.dtCuestionario = dtCuestionario;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCuestionario() {
        return dtCuestionario;
    }

    /**
     * @param fumadia
     */
    public void setFumadia(Integer fumadia) {
        this.fumadia = fumadia;
    }

    /**
     * @return
     */
    public Integer getFumadia() {
        return fumadia;
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


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la bade de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Long numero;
        numero = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            numero = new Long(consulta.getCconnumero());
        }

        if (numero != null) {
            try {
                lstCuestionario = 
                        this.getServiceLocator().getClinicoService().getCuestionarioPreanestesia(numero);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstCuestionario != null && !lstCuestionario.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * @param observacion
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return
     */
    public String getObservacion() {
        return observacion;
    }

    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void changeTodosSi() {
        if (lstPreguntasAnestesia != null && 
            !lstPreguntasAnestesia.isEmpty()) {
            Iterator it = lstPreguntasAnestesia.iterator();
            while (it.hasNext()) {
                Chpreguanest pregunta = (Chpreguanest)it.next();
                pregunta.setHpacrespuesta("S");
             }
        }
    }

    public void changeTodosNo() {
        if (lstPreguntasAnestesia != null && 
            !lstPreguntasAnestesia.isEmpty()) {
            Iterator it = lstPreguntasAnestesia.iterator();
            while (it.hasNext()) {
                Chpreguanest pregunta = (Chpreguanest)it.next();
                pregunta.setHpacrespuesta("N");
         }
        }
    }

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------


    /**
     * @return
     */
    public String aceptar() {
        Chpreguanest preguntaAux;
        Chcuestanest cuestionarioAux;
        ChcuestanestPK idCuestionario;
        Long numeroConsulta = null;
        navigationRule = "";

        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }

        if (lstPreguntasAnestesia != null && 
            !lstPreguntasAnestesia.isEmpty()) {
            lstCuestionario = new ArrayList<Chcuestanest>();
            Iterator it;
            it = lstPreguntasAnestesia.iterator();
            while (it.hasNext()) {
                preguntaAux = null;
                cuestionarioAux = new Chcuestanest();
                idCuestionario = new ChcuestanestPK();
                preguntaAux = (Chpreguanest)it.next();
                idCuestionario.setHcactiposerv(TIPO_CONSULTA);
                idCuestionario.setHcanconsecut(preguntaAux.getHpancodigo());
                idCuestionario.setHcalconsulta(numeroConsulta);
                cuestionarioAux.setId(idCuestionario);
                cuestionarioAux.setHcacoperador(userName());
                cuestionarioAux.setHcacrespuesta(preguntaAux.getHpacrespuesta());
                cuestionarioAux.setHcadfecregistr(new Date());
                cuestionarioAux.setHcanpregunta(preguntaAux.getHpancodigo());
                cuestionarioAux.setHcacanotacion(preguntaAux.getHpacanotacion());
                cuestionarioAux.setHcacobservacio(observacion);


                lstCuestionario.add(cuestionarioAux);

            }
        }
        try {
            this.serviceLocator.getClinicoService().saveCuestionarioPreanestesia(lstCuestionario, 
                                                                                 numeroConsulta);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
        return navigationRule;
    }
}
