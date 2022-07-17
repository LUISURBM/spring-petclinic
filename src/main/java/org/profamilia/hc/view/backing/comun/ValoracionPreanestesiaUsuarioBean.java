//=======================================================================
// ARCHIVO 
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chvalorprean;
import org.profamilia.hc.model.dto.ChvalorpreanPK;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


public class ValoracionPreanestesiaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chvalorprean valoracion;

    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ValoracionPreanestesiaUsuarioBean() {
    }

    public void init() {
       
        nextAction = "";
        inicializarValoracionPreanestesia();
    }

    public void inicializarValoracionPreanestesia() {

     
        

        try {
            valoracion = 
                    this.getServiceLocator().getClinicoService().getValoracionPreanestesia(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (valoracion == null) {
            valoracion = new Chvalorprean();
        } 
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


  

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
     * @param valoracion
     */
    public void setValoracion(Chvalorprean valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * @return
     */
    public Chvalorprean getValoracion() {
        return valoracion;
    }

    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chvalorprean valoracionAux = null;
        if (consulta != null) {
            try {
                valoracionAux = 
                        this.getServiceLocator().getClinicoService().getValoracionPreanestesia(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (valoracionAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o  Botones Secundarios
    //-----------------------------------------------------------------------




    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------

    public String generarValoracion() {

        String codigosCirugias = "";
        navigationRule = "";
        ChvalorpreanPK id = new ChvalorpreanPK();
            valoracion.setHvpcoperador(userName());
            valoracion.setHvpcintervenci(codigosCirugias);
            valoracion.setHvpdfecregistr(new Date());
            
        if (consulta != null && consulta.getCconnumero() != null) {
                       id.setHvplconsulta(new Long(consulta.getCconnumero()));
                       id.setHvpctiposerv(TIPO_CONSULTA);
                       valoracion.setId(id);
                   }

            try {
                serviceLocator.getClinicoService().saveValoracionAnestesia(valoracion);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                e.printStackTrace();

            }

       
        return navigationRule;
    }


}
