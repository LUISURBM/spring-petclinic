//=======================================================================
// ARCHIVO AplicacionVacunaCervixBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la vacunaci�n de C�rvix
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.Date;

import org.profamilia.hc.model.dto.Chcervaaplic;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=================================================================
//  CLASE AplicacionVacunaCervixBean
//=======================================================================
public class AplicacionVacunaCervixBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario; 
    private Chcervaaplic aplicacion;
    private Chcervaaplic apliprimdosis; 
    private Chcervaaplic aplisegudosis; 
    private String nextAction; 
    private String menuBean; 
    private Long numeroConsulta; 
    private String tipoServicio; 
    private String navigationRule; 
    private Integer numeroDosis; 
    private Date fecharegistro; 
    private boolean renderprimdosis; 
    private boolean rendersegudosis; 
    private String nombreprimdosis;
    private String nombresegudosis;
    
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------
    public AplicacionVacunaCervixBean() {
    }
    
    public void init(){
        
    }
    //ACTIONS

    public void inicalizarAplicacionBean() {
    
        if(usuario!= null && usuario.getHuslnumero()!= null){


            try {
                apliprimdosis = this.serviceLocator.getClinicoService().getAplicacionCervixPrimera(usuario.getHuslnumero());
            } catch (ModelException e) {
               e.printStackTrace();
            }

            try {
                aplisegudosis = this.serviceLocator.getClinicoService().getAplicacionCervixSegunda(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }


        if (apliprimdosis != null) {
            renderprimdosis = true;
            Cpusuario usuarioprim = null;

            try {
                if (apliprimdosis.getHcacoperador() != null) {
                    usuarioprim = 
                            this.serviceLocator.getClinicoService().getUsuarioPorId(apliprimdosis.getHcacoperador().toUpperCase());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (usuarioprim != null && usuarioprim.getCurcnombre() != null) {
                nombreprimdosis = usuarioprim.getCurcnombre();
            }

        } else {
            renderprimdosis = false;
        }


        if (aplisegudosis != null) {
            Cpusuario usuariosegun = null;

            try {
                if (aplisegudosis.getHcacoperador() != null) {
                    usuariosegun = 
                            this.serviceLocator.getClinicoService().getUsuarioPorId(aplisegudosis.getHcacoperador().toUpperCase());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (usuariosegun != null && usuariosegun.getCurcnombre() != null) {
                nombresegudosis = usuariosegun.getCurcnombre();
            }
            rendersegudosis = true;
        } else {
            rendersegudosis = false;
        }


        if (numeroConsulta != null) {

            try {
                aplicacion = 
                        this.getServiceLocator().getClinicoService().getAplicacionCervix(numeroConsulta, 
                                                                                         TIPO_CONSULTA);

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }

        if (aplicacion == null) {
            aplicacion = new Chcervaaplic();
            fecharegistro = new Date();
        } else {
            fecharegistro = aplicacion.getHcadfecregistr();
        }

    }
    
    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 
    
    public String guardar(){
        navigationRule = "";

       if(numeroDosis!= null) {
        if (numeroConsulta != null) {
            aplicacion.getId().setHcactiposervi(tipoServicio);
            aplicacion.getId().setHcalconsulta(numeroConsulta);
            aplicacion.setHcacnumerdosis(numeroDosis);
            aplicacion.setHcacoperador(userName());
            aplicacion.setHcadfecregistr(fecharegistro);
        }

        try {

            this.serviceLocator.getClinicoService().saveAplicacionCervix(aplicacion);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
       }else{
           FacesUtils.addErrorMessage(MSG_NUMERO_DOSIS_NO_ASIGNADO);
           navigationRule = ""; 
       }

        return navigationRule;
        }
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    
    public boolean esValido(){
        Long numero;
        numero = null;
        Chcervaaplic aplicacionAux = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                aplicacionAux = 
                        this.getServiceLocator().getClinicoService().getAplicacionCervix(numero, 
                                                                                              TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (aplicacionAux != null) {
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
    
    
     
     //-----------------------------------------------------------------------
     //  Accesorios
     //-----------------------------------------------------------------------
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
     * @param aplicacion
     */
    public void setAplicacion(Chcervaaplic aplicacion) {
        this.aplicacion = aplicacion;
    }

    /**
     * @return
     */
    public Chcervaaplic getAplicacion() {
        return aplicacion;
    }

    /**
     * @param numeroDosis
     */
    public void setNumeroDosis(Integer numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    /**
     * @return
     */
    public Integer getNumeroDosis() {
        return numeroDosis;
    }

    /**
     * @param fecharegistro
     */
    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    /**
     * @return
     */
    public Date getFecharegistro() {
        return fecharegistro;
    }

    /**
     * @param apliprimdosis
     */
    public void setApliprimdosis(Chcervaaplic apliprimdosis) {
        this.apliprimdosis = apliprimdosis;
    }

    /**
     * @return
     */
    public Chcervaaplic getApliprimdosis() {
        return apliprimdosis;
    }

    /**
     * @param aplisegudosis
     */
    public void setAplisegudosis(Chcervaaplic aplisegudosis) {
        this.aplisegudosis = aplisegudosis;
    }

    /**
     * @return
     */
    public Chcervaaplic getAplisegudosis() {
        return aplisegudosis;
    }

    /**
     * @param renderprimdosis
     */
    public void setRenderprimdosis(boolean renderprimdosis) {
        this.renderprimdosis = renderprimdosis;
    }

    /**
     * @return
     */
    public boolean isRenderprimdosis() {
        return renderprimdosis;
    }

    /**
     * @param rendersegudosis
     */
    public void setRendersegudosis(boolean rendersegudosis) {
        this.rendersegudosis = rendersegudosis;
    }

    /**
     * @return
     */
    public boolean isRendersegudosis() {
        return rendersegudosis;
    }

    /**
     * @param nombreprimdosis
     */
    public void setNombreprimdosis(String nombreprimdosis) {
        this.nombreprimdosis = nombreprimdosis;
    }

    /**
     * @return
     */
    public String getNombreprimdosis() {
        return nombreprimdosis;
    }

    /**
     * @param nombresegudosis
     */
    public void setNombresegudosis(String nombresegudosis) {
        this.nombresegudosis = nombresegudosis;
    }

    /**
     * @return
     */
    public String getNombresegudosis() {
        return nombresegudosis;
    }
}
