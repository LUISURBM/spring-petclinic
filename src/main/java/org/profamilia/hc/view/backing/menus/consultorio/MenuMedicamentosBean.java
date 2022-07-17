package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionMedicamentoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosAdicionalesMedicamentoBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaMedicamentosBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;


public class MenuMedicamentosBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private AplicacionMedicamentoBean aplicacionBean;

    private AntecedentesUsuarioBean antecedentes;

    private AntecedentesGeneralesUsuarioBean antecedentesGenerales;
    
    private DatosAdicionalesMedicamentoBean datosAdicionalesMedicamentosBean;

    private boolean renderAntecedentesGenerales;
    
    private Integer tipoHistoria;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderAplicacion;

    private boolean renderAntecedentes;

    private boolean renderCerrarConsulta;

    private Long numeroConsulta;

    private String sexo;
    
    private boolean renderVacunacion;
    
    private boolean renderAdministracion; 
    
    private boolean primeraConsulta;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;
        
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;    
    
    private ListaMedicamentosBean listaMedicamentosBean;
    
    private boolean renderDatosAdicionales;


    public MenuMedicamentosBean() {
    }


    public void init() {
        renderVacunacion = false; 

        // DATOS BASICOS USUARIO
         primeraConsulta = false;
         renderEscalaCaidas = false;
         renderDatosAdicionales = false;

        
        
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
            try {
                primeraConsulta = 
                        this.getServiceLocator().getClinicoService().esPrimeraConsulta(datosBasicosUsuario.getUsuario());
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
        if(datosBasicosUsuario != null){
            tipoHistoria = datosBasicosUsuario.getTipoHistoria();
        }
        if(tipoHistoria != null){
            if(tipoHistoria.equals(IConstantes.HISTORIA_VACUNACION)){
                renderVacunacion = true; 
            }
        }
        if(!renderVacunacion){
            if(primeraConsulta){
                    datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_MEDICAMENTOS);
                    renderAntecedentesGenerales = datosBasicosUsuario.esValido();
                }else{
                   
                   datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_MEDICAMENTOS);    
                   renderAntecedentes = datosBasicosUsuario.esValido();
               }
        }
        else{
            datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_DATOS_ADICIONALES_MEDICAMENTO);
            renderDatosAdicionales = datosBasicosUsuario.esValido();
        }
       
                       
        datosBasicosUsuario.setMenuBean("menuMedicamentosBean");

        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());

        }
        
        if(renderVacunacion){
        datosAdicionalesMedicamentosBean =
        (DatosAdicionalesMedicamentoBean)FacesUtils.getManagedBean("datosAdicionalesMedicamentoBean");
        datosAdicionalesMedicamentosBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               datosAdicionalesMedicamentosBean.setUsuario(datosBasicosUsuario.getUsuario());
           }
        datosAdicionalesMedicamentosBean.setMenuBean("menuMedicamentosBean");
        datosAdicionalesMedicamentosBean.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_MEDICAMENTOS);
        datosAdicionalesMedicamentosBean.init();
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(datosBasicosUsuario.getConsulta().getCconnumero().longValue());
           registrarEscalaValoracionCaidasBean.setMenuBean("menuMedicamentosBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_APLICACION_MEDICAMENTO);
           registrarEscalaValoracionCaidasBean.init();
           renderEscalaCaidas = datosAdicionalesMedicamentosBean.esValido();
        }
        else{
            registrarEscalaValoracionCaidasBean = 
                      (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
                      registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
                   if (datosBasicosUsuario != null &&
                      datosBasicosUsuario.getUsuario() != null && 
                      datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
                          registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
                      }
                      registrarEscalaValoracionCaidasBean.setNumeroConsulta(datosBasicosUsuario.getConsulta().getCconnumero().longValue());
                      registrarEscalaValoracionCaidasBean.setMenuBean("menuMedicamentosBean");
                      registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_APLICACION_MEDICAMENTO);
                      registrarEscalaValoracionCaidasBean.init();
                      renderEscalaCaidas = registrarEscalaValoracionCaidasBean.esValido();
        }
        listaMedicamentosBean= (ListaMedicamentosBean)FacesUtils.getManagedBean("listaMedicamentosBean");
        
        aplicacionBean = 
                (AplicacionMedicamentoBean)FacesUtils.getManagedBean("aplicacionMedicamentoBean");
        aplicacionBean.setUsuario(datosBasicosUsuario.getUsuario());
        if(primeraConsulta)        {
              aplicacionBean.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_MEDICAMENTO);
              renderAntecedentesGenerales = datosBasicosUsuario.esValido();
          }else{
              
              aplicacionBean.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_MEDICAMENTO);    
              renderAntecedentes = datosBasicosUsuario.esValido();
          }
        aplicacionBean.setMenuBean("menuMedicamentosBean");
        aplicacionBean.setListaMedicamento(listaMedicamentosBean);
        aplicacionBean.setNumeroConsulta(numeroConsulta);
        aplicacionBean.setConclin(datosBasicosUsuario.getConsulta());
        aplicacionBean.setTipoServicio(TIPO_CONSULTA);
        aplicacionBean.setTipoHistoria(tipoHistoria);
        aplicacionBean.setEsVacunacion(renderVacunacion);
        aplicacionBean.setServicio(datosBasicosUsuario.getServicio().getCsvcnombre());
        aplicacionBean.setConsecutivo(1);
        aplicacionBean.inicalizarAplicacionBean();
        renderCerrarConsulta = aplicacionBean.esValido();  

        // ANTECEDENTES


        antecedentes = 
         (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
        antecedentes.setTipoServicio(TIPO_CONSULTA);
        antecedentes.setNumeroConsulta(numeroConsulta);
        antecedentes.setTipoHistoria(HISTORIA_SALUD_SEXUAL);
        antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentes.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_MEDICAMENTO);
        antecedentes.setMenuBean("menuMedicamentosBean");
        antecedentes.inicializarAntecedentes();
        if(primeraConsulta){
        renderAdministracion = antecedentes.esValido();
            renderCerrarConsulta = antecedentes.esValido();
        }


        // ANTECEDENTES GENERALES
        antecedentesGenerales = 
                (AntecedentesGeneralesUsuarioBean)FacesUtils.getManagedBean("antecedentesGeneralesUsuarioBean");
        antecedentesGenerales.setTipoServicio(TIPO_CONSULTA);
        antecedentesGenerales.setTipoHistoria(HISTORIA_SALUD_SEXUAL);
        antecedentesGenerales.setNumeroConsulta(numeroConsulta);
        antecedentesGenerales.setNextAction(BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_MEDICAMENTO);
        antecedentesGenerales.setMenuBean("menuMedicamentosBean");
        antecedentesGenerales.inicializarAntecedentes();
        if(!primeraConsulta)        {
        renderAdministracion = antecedentesGenerales.esValido();
        renderCerrarConsulta = antecedentesGenerales.esValido();
        }
        
        





        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuMedicamentosBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(true);
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        
        renderPausarConsulta=false;
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            renderPausarConsulta = datosBasicosUsuario.esValido();
        }
        
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
           tiempoAtencion =datosBasicosUsuario.esValido();
           if (tiempoAtencion) {
               
               try {
                   List<Chtiempaten> chtiempatenList = new ArrayList<Chtiempaten>();
                   chtiempatenList = 
                           getServiceLocator().getClinicoService().consultarTiempoAtencionVigentesXconsulta(numeroConsulta);
                   if (chtiempatenList.isEmpty()) {
                       Chtiempaten chtiempatenAux = new Chtiempaten();
                       chtiempatenAux.setCtanconsulta(numeroConsulta);
                       chtiempatenAux.setCtacetapa("AB");
                       chtiempatenAux.setCtacestado("VG");
                       chtiempatenAux.setCtadhora(new Date());
                       chtiempatenAux.setCtadfechregi(new Date());
                       chtiempatenAux.setCtancausa(0);
                       chtiempatenAux.setCtacusuareg(getUsuarioSystem().getCurcusuari());
                       chtiempatenAux.setCtancodmed(Integer.parseInt(getUsuarioSystem().getCurnprofes().toString()));
                       this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempatenAux);
                   }
               } catch (ModelException e) {
                   e.printStackTrace();
               }
           }
        }

        // PAUSAR CONSULTA
         if(IConstantes.ACTIVAR_PAUSAR_CONSULTA){
             if(renderPausarConsulta){
             pausarConsulta = 
                     (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                  pausarConsulta.setNumeroConsulta(numeroConsulta);
                  if(numeroConsulta != null){
                      pausarConsulta.init();
                      pausarConsulta.getCausasPausarConsultas();
                  }
              }
         }
		
		renderServiciosAdmision =false;
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
    
    public String irPausarConsultaMedicamentos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_PAUSAR_CONSULTA_MEDICAMENTOS;
    }

    // APLICACION CERVIX 

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

 
    /**
     * @return
     */
    public String irAntecedentesGeneralesMedicamento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_MEDICAMENTO;
    }
    
    public String irAntecedenteMedicamento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_MEDICAMENTO;
    }


    public String irDatosMedicamento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_MEDICAMENTO;
    }

    public String irActividadMedicamento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ACTIVIDAD_MEDICAMENTO;
    }
    
    public String irAdministrarMedicamento() {
        inicializarUsuario();
        FacesUtils.resetManagedBean("AplicacionMedicamentoBean");
        return BeanNavegacion.RUTA_IR_APLICACION_MEDICAMENTO;
    }

    public String irCerrarMedicamento() {
        if (cerrarConsultaUsuarioBean != null) {
            cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        }
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_MEDICAMENTO;
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
     * @param renderAplicacion
     */
    public void setRenderAplicacion(boolean renderAplicacion) {
        this.renderAplicacion = renderAplicacion;
    }

    /**
     * @return
     */
    public boolean isRenderAplicacion() {
        return renderAplicacion;
    }

    /**
     * @param renderCerrarConsulta
     */
    public void setRenderCerrarConsulta(boolean renderCerrarConsulta) {
        this.renderCerrarConsulta = renderCerrarConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderCerrarConsulta() {
        return renderCerrarConsulta;
    }

    public void setRenderAntecedentesGenerales(boolean renderAntecedentesGenerales) {
        this.renderAntecedentesGenerales = renderAntecedentesGenerales;
    }

    public boolean isRenderAntecedentesGenerales() {
        return renderAntecedentesGenerales;
    }


    public void setRenderAntecedentes(boolean renderAntecedentes) {
        this.renderAntecedentes = renderAntecedentes;
    }

    public boolean isRenderAntecedentes() {
        return renderAntecedentes;
    }


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setRenderVacunacion(boolean renderVacunacion) {
        this.renderVacunacion = renderVacunacion;
    }

    public boolean isRenderVacunacion() {
        return renderVacunacion;
    }

    public void setRenderAdministracion(boolean renderAdministracion) {
        this.renderAdministracion = renderAdministracion;
    }

    public boolean isRenderAdministracion() {
        return renderAdministracion;
    }
    

    public void setRenderPausarConsulta(boolean renderPausarConsulta) {
        this.renderPausarConsulta = renderPausarConsulta;
    }

    public boolean isRenderPausarConsulta() {
        return renderPausarConsulta;
    }

    public void setPausarConsulta(PausarConsultaBean pausarConsulta) {
        this.pausarConsulta = pausarConsulta;
    }

    public PausarConsultaBean getPausarConsulta() {
        return pausarConsulta;
    }
	
	public String irServiciosAdmisionMedicamentos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SERVICIOS_ADMISION_MEDICAMENTOS;
    }

    public void setRenderServiciosAdmision(boolean renderServiciosAdmision) {
        this.renderServiciosAdmision = renderServiciosAdmision;
    }

    public boolean isRenderServiciosAdmision() {
        return renderServiciosAdmision;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasMedicamentos() {
        inicializarUsuario();
        FacesUtils.resetManagedBean("registrarEscalaValoracionCaidasCEBean");
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_MEDICAMENTOS;
    }


    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
    
    public String irDatosBasicosAdicionales() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_ADICIONALES_MEDICAMENTO;
    }


    public void setRenderDatosAdicionales(boolean renderDatosAdicionales) {
        this.renderDatosAdicionales = renderDatosAdicionales;
    }

    public boolean isRenderDatosAdicionales() {
        return renderDatosAdicionales;
    }
}
