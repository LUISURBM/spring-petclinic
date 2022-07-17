package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.Date;

import java.util.List;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PruebasRapidasBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuPruebasRapidasBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;
    
    private PruebasRapidasBean pruebasRapidas;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderToma;

    private boolean renderCerrar;
       
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;

    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
                    
    private boolean renderServiciosAdmision;


    public void init() {

        // DATOS BASICOS USUARIO
        
        Chantegineco antecedentes;
        antecedentes = null;
        
        Long numeroConsulta = null; 
        
    
        
        datosBasicosUsuario = 
                       (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_REGISTRO_TOMA_PRUEBAS_RAPIDAS);
        datosBasicosUsuario.setMenuBean("menuPruebasRapidasBean");
        renderToma = datosBasicosUsuario.esValido();

        datosBasicosUsuario.setUsuario(datosBasicosUsuario.getUsuario());
        
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());
        }
        
        pruebasRapidas = (PruebasRapidasBean)FacesUtils.getManagedBean("pruebasRapidasBean");
        pruebasRapidas.setConsulta(datosBasicosUsuario.getConsulta());
        pruebasRapidas.setUsuario(datosBasicosUsuario.getUsuario());
        pruebasRapidas.setMenuBean("menuPruebasRapidasBean");
        //PruebasRapidas.setMenuBean("menuTomaPruebasRapidasBean");    
        renderCerrar = pruebasRapidas.esValido();
        pruebasRapidas.inicializarDatos();


        renderServiciosAdmision = false;
        // SERVICIOS ADMISION
        if (IConstantes.ACTIVAR_SERVICIOS_ADMISION) {
            if (datosBasicosUsuario.getConsulta() != null) {
                Long tipoDocuentoAdmision = 
                    datosBasicosUsuario.getConsulta().getCcontipdoc().getCtdnnumero().longValue();
                if (tipoDocuentoAdmision == 
                    IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    renderServiciosAdmision = datosBasicosUsuario.esValido();
                    if (renderServiciosAdmision) {
                        confirmarServiciosAdmision = 
                                (ConfirmarServiciosAdmisionBean)FacesUtils.getManagedBean("confirmarServiciosAdmisionBean");
                        confirmarServiciosAdmision.setNumeroAdmision(datosBasicosUsuario.getConsulta().getCconnumdoc().longValue());
                        if (confirmarServiciosAdmision.getNumeroAdmision() != 
                            null) {
                            confirmarServiciosAdmision.init();
                            confirmarServiciosAdmision.setConsulta(datosBasicosUsuario.getConsulta());
                            confirmarServiciosAdmision.setUsuario(datosBasicosUsuario.getUsuario());
                            confirmarServiciosAdmision.consultarServiciosAdmision();
                            List<Cfdetafactura> cfdetafacturaList = 
                                confirmarServiciosAdmision.getCfdetafacturaList();
                            if (cfdetafacturaList == null || 
                                cfdetafacturaList.isEmpty()) {
                                renderServiciosAdmision = false;
                            }
                        }
                    }
                }
            }
        }


    }


    /**
     * @return
     */
    public String irDatosPruebasRapidas() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_USUARIO_PRUEBAS_RAPIDAS;
    }


    /**
     * @return
     */
    public String irTomaPruebasRapidas() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REGISTRO_TOMA_PRUEBAS_RAPIDAS;
    }
    
    /**
     * @return
     */
    public String irCierrePruebasRapidas() {
        inicializarUsuario();
        if(pruebasRapidas !=null){
             pruebasRapidas.setGeneroReporte(false);         
        }
        return BeanNavegacion.RUTA_IR_PRUEBAS_RAPIDAS;
    }
    
    
   

    public void inicializarUsuario() {
        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
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
     * @param renderCerrar
     */
    public void setRenderCerrar(boolean renderCerrar) {
        this.renderCerrar = renderCerrar;
    }

    /**
     * @return
     */
    public boolean isRenderCerrar() {
        return renderCerrar;
    }

    /**
     * @param renderToma
     */
    public void setRenderToma(boolean renderToma) {
        this.renderToma = renderToma;
    }

    /**
     * @return
     */
    public boolean isRenderToma() {
        return renderToma;
    }

  

   
    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
    
    public String irServiciosAdmisionPruebasRapidas() {
    inicializarUsuario();
    return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_PRUEBAS_RAPIDAS;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
    this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
    return renderServiciosAdmision;
    }
  
}
