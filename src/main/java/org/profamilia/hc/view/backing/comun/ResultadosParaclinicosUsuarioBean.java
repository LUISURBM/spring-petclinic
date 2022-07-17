//=======================================================================
// ARCHIVO 
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

import java.util.Date;

import org.profamilia.hc.model.dto.Chresulparac;
import org.profamilia.hc.model.dto.ChresulparacPK;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


public class ResultadosParaclinicosUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chresulparac resultado;

    private boolean wexito;

    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ResultadosParaclinicosUsuarioBean() {
    }

    public void init() {
        resultado = new Chresulparac();
        nextAction = "";
        inicizalizarResultados();
    }

    public void inicizalizarResultados() {
        Long numeroConsulta;
        numeroConsulta = null;
        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }

        if (numeroConsulta != null) {
            try {
                resultado = 
                        this.getServiceLocator().getClinicoService().getResultadosParaclinicos(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (resultado == null) {
            resultado = new Chresulparac();
        }

    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param resultado
     */
    public void setResultado(Chresulparac resultado) {
        this.resultado = resultado;
    }

    /**
     * @return
     */
    public Chresulparac getResultado() {
        return resultado;
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

    //* Esta Clase No Tiene AJAX

    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        Long numero;
        numero = null;
        Chresulparac resultadoAux;
        resultadoAux = null;


        if (consulta != null && consulta.getCconnumero() != null) {
            numero = new Long(consulta.getCconnumero());
        }

        if (numero != null) {
            try {
                resultadoAux = 
                        this.getServiceLocator().getClinicoService().getResultadosParaclinicos(numero);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (resultadoAux != null) {
            return true;
        }

        return false;
    }

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public String aceptar() {

        wexito = true;
        navigationRule = "";

        if (resultado != null) {
            if (resultado.getHrpnhemoglobin() != null && 
                resultado.getHrpnhemoglobin().compareTo(new BigDecimal(100)) >= 
                0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itHemoglobina", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }

            if (resultado.getHrpnhematocrit() != null && 
                resultado.getHrpnhematocrit().compareTo(new BigDecimal(100)) >= 
                0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itHematocrito", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }

            if (resultado.getHrpnpt() != null && 
                resultado.getHrpnpt().compareTo(new BigDecimal(100)) >= 0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itPt", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }

            if (resultado.getHrpninr() != null && 
                resultado.getHrpninr().compareTo(new BigDecimal(10)) >= 0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itInr", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }

            if (resultado.getHrpnptt() != null && 
                resultado.getHrpnptt().compareTo(new BigDecimal(100)) >= 0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itPtt", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }
            if (resultado.getHrpnglicemipre() != null && 
                resultado.getHrpnglicemipre().compareTo(new BigDecimal(1000)) >= 
                0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itGlicemiaPre", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }

            if (resultado.getHrpnglicemipos() != null && 
                resultado.getHrpnglicemipos().compareTo(new BigDecimal(1000)) >= 
                0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itGlicemiaPos", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }


            if (resultado.getHrpnnitroureic() != null && 
                resultado.getHrpnnitroureic().compareTo(new BigDecimal(100)) >= 
                0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itNitrogeno", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }

            if (resultado.getHrpnncreatinin() != null && 
                resultado.getHrpnncreatinin().compareTo(new BigDecimal(100)) >= 
                0) {
                wexito = false;
                FacesUtils.addErrorMessage("body:formResultadosParaclinicos:panelTabResultadosParaclinicos:itCreatinina", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
            }


        } else {
            wexito = false;
        }


        Long numeroConsulta = null;
        ChresulparacPK id = new ChresulparacPK();


        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }

        if (numeroConsulta != null) {
            id.setHrplconsulta(numeroConsulta);
            id.setHrpctiposervi(TIPO_CONSULTA);
            resultado.setId(id);
        }
        resultado.setHrpcoperador(userName());
        resultado.setHrpdfecregistr(new Date());
        if (wexito) {
            try {
                this.getServiceLocator().getClinicoService().saveResultadosParaclinicos(resultado);
                FacesUtils.addInfoMessage(MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            } catch (ModelException e) {
                navigationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
        } else {
            navigationRule = "";
        }
        return navigationRule;
    }


}
