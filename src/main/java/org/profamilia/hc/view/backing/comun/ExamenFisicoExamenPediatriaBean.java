//=======================================================================
// ARCHIVO ExamenFisicoExamenPediatriaBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jhon carranza
// Descripci�n: Datos correspondientes al examen fisico de pediatria
// patologica.
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpediexamen;
import org.profamilia.hc.model.dto.ChpediexamenPK;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ExamenFisicoExamenPediatriaBean
//=======================================================================
public class ExamenFisicoExamenPediatriaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chpediexamen examen;

    private List<SelectItem> lstEstadoGeneral;

    private List<SelectItem> lstEstadoRespiratorio;

    private List<SelectItem> lstEstadoHidratacion;

    private List<SelectItem> lstEstadoConciencia;

    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ExamenFisicoExamenPediatriaBean() {

    }

    public void init() {
        nextAction = "";
        inicializarExamenPediatria();

    }

    public void inicializarExamenPediatria() {

        try {
            examen = 
                    serviceLocator.getClinicoService().getExamenPediatria(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (examen == null) {
            examen = new Chpediexamen();
        }
    }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


    /**
     * @param examen
     */
    public void setExamen(Chpediexamen examen) {
        this.examen = examen;
    }

    /**
     * @return
     */
    public Chpediexamen getExamen() {
        return examen;
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
     * @param lstEstadoGeneral
     */
    public void setLstEstadoGeneral(List<SelectItem> lstEstadoGeneral) {
        this.lstEstadoGeneral = lstEstadoGeneral;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstEstadoGeneral() {
        if (lstEstadoGeneral == null || lstEstadoGeneral.isEmpty()) {
            lstEstadoGeneral = new ArrayList<SelectItem>();
            lstEstadoGeneral.add(new SelectItem("B", "Bueno"));
            lstEstadoGeneral.add(new SelectItem("R", "Regular"));
            lstEstadoGeneral.add(new SelectItem("M", "Malo"));
        }
        return lstEstadoGeneral;
    }

    /**
     * @param lstEstadoRespiratorio
     */
    public void setLstEstadoRespiratorio(List<SelectItem> lstEstadoRespiratorio) {
        this.lstEstadoRespiratorio = lstEstadoRespiratorio;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstEstadoRespiratorio() {
        if (lstEstadoRespiratorio == null || lstEstadoRespiratorio.isEmpty()) {
            lstEstadoRespiratorio = new ArrayList<SelectItem>();
            lstEstadoRespiratorio.add(new SelectItem("S", "Si"));
            lstEstadoRespiratorio.add(new SelectItem("N", "No"));
        }
        return lstEstadoRespiratorio;
    }

    /**
     * @param lstEstadoHidratacion
     */
    public void setLstEstadoHidratacion(List<SelectItem> lstEstadoHidratacion) {
        this.lstEstadoHidratacion = lstEstadoHidratacion;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstEstadoHidratacion() {
        if (lstEstadoHidratacion == null || lstEstadoHidratacion.isEmpty()) {
            lstEstadoHidratacion = new ArrayList<SelectItem>();
            lstEstadoHidratacion.add(new SelectItem("H", "Hidratado"));
            lstEstadoHidratacion.add(new SelectItem("D", "Deshidratado"));

        }
        return lstEstadoHidratacion;
    }

    /**
     * @param lstEstadoConciencia
     */
    public void setLstEstadoConciencia(List<SelectItem> lstEstadoConciencia) {
        this.lstEstadoConciencia = lstEstadoConciencia;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstEstadoConciencia() {
        if (lstEstadoConciencia == null || lstEstadoConciencia.isEmpty()) {
            lstEstadoConciencia = new ArrayList<SelectItem>();
            lstEstadoConciencia.add(new SelectItem("N", "Normal"));
            lstEstadoConciencia.add(new SelectItem("A", "Alterado"));
        }
        return lstEstadoConciencia;
    }


    //-----------------------------------------------------------------------
    //  ESVALIDO
    //-----------------------------------------------------------------------

    public boolean esValido() {
        boolean esvalido = false;
        Chpediexamen examenAux;
        examenAux = null;

        try {
            examenAux = 
                    serviceLocator.getClinicoService().getExamenPediatria(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (examenAux != null) {
            esvalido = true;
        }
        return esvalido;
    }


    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------


    public String guardarExamenPediatria() {
        ChpediexamenPK id = new ChpediexamenPK();
        navigationRule = "";
        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHpelconsulta(new Long(consulta.getCconnumero()));
            id.setHpectiposervi(TIPO_CONSULTA);
            examen.setId(id);
        }


        examen.setHpecoperador(userName());
        examen.setHpedfecregistr(new Date());


        try {
            this.serviceLocator.getClinicoService().saveExamenPediatria(examen);
            FacesUtils.addInfoMessage(MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            navigationRule = null;
            e.printStackTrace();
        }

        return navigationRule;
    }


}
