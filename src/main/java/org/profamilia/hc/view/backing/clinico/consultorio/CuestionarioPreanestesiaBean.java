//=======================================================================
// ARCHIVO 
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcuestanest;
import org.profamilia.hc.model.dto.ChcuestanestPK;
import org.profamilia.hc.model.dto.Chpreguanest;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================
public class CuestionarioPreanestesiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List<Chpreguanest> lstPreguntasAnestesia;

    private List lstOpciones;

    private List<Chcuestanest> lstCuestionario;

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;

    private HtmlDataTable dtCuestionario;

    /** Almacena el numero de cigarrillos que fuma en el dia el Usuario */
    private Integer fumadia;

    /** Almacena las observaciones Adicionales*/
    private String observacion;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public CuestionarioPreanestesiaBean() {
    }


    public void init() {
        Long numeroConsulta;
        numeroConsulta = null;
        lstOpciones = new ArrayList();

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosUsuario.getConsulta().getCconnumero());
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
        if (lstOpciones.size() == 0) {
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


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la bade de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Long numero;
        numero = null;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            numero = new Long(datosUsuario.getConsulta().getCconnumero());
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

        if (datosUsuario != null && datosUsuario.getConsulta() != null && 
            datosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosUsuario.getConsulta().getCconnumero());
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
            return BeanNavegacion.RUTA_IR_EXAMEN_PREANESTESIA;
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            return BeanNavegacion.RUTA_ACTUAL;
        }

    }


}
