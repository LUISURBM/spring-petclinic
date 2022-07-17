package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.CerrarAnestesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.EvolucionBean;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaMedicoBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarAnetesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarControlViaAereaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarLiquidosAnestesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentoAnestesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedidaProfilacticaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMonitoriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesAnestesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarTecnicaAnestesiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuAnestesiaBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuEvolucionMedicoBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuIngresoMedicoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaCirugiasMedicoBean extends BaseBean {


    private List<Chcirugprogr> lstCirugiasIngresadas;

    private HtmlDataTable dtCirugia;

    private HtmlDataTable dtCirugiaQuirofano;
    
    private HtmlDataTable dtCirugiaRecuperacion;

    /**Variable que almacena el usuario de la consulta */
    private Chusuario usuario;

    private boolean esIngresoMedico;

    private boolean esEvolucion;

    private boolean esEpicrisis;

    private boolean esRegistroAnestesia;


    private Chdetacirpro detaConsul;

    private String servicioDetalle;

    private Cpservicio servicio;

    private String rutaNavegation;

    private boolean ligadura;

    private boolean renderOtrasCirugias;

    private UIInput itNumeroUsuario;

    private Chdetacirpro detalleCirugia;

    private Chdetacirpro detaciru;

    private Long numeroConsulta;

    private String nombreServicio;

    private List<Chcirugprogr> lstCirugiasCompleta;

    private Date fechaAnterior;

    private Chcirugprogr orden;

    private Chcirugprogr ordenCirugia;

    private String etapaIngreso;

    private String etapaPenQuiro;
    
    private Date fechaCirugia;

    private List<Chcirugprogr> lstCirugiasIngresoEnfermeria;
    
    private List<Chcirugprogr> lstCirugiasEnRecuperacion;

    private List<Chcirugprogr> lstCirugiasPendienteQuirofano;
    
    private List<Chcirugprogr> lstCirugiasPendienteRecuperacion;

    private List<Chcirugprogr> lstCirugiasSiguienteQuirofano;

    private List<Chcirugprogr> lstCirugiasCompletaIngreso;
    
    private List<Chcirugprogr> lstCirugiasCompletaRecuperacion;


    public ListaCirugiasMedicoBean() {

    }

    public void init() {
        usuario = new Chusuario();
        fechaCirugia = new Date();
        cargarCirugias();
    }

    public void cargarCirugias() {


        ligadura = false;
        renderOtrasCirugias = false;
        lstCirugiasIngresadas = new ArrayList<Chcirugprogr>();
        lstCirugiasIngresoEnfermeria = new ArrayList<Chcirugprogr>();
        lstCirugiasPendienteQuirofano = new ArrayList<Chcirugprogr>();
        lstCirugiasCompletaIngreso = new ArrayList<Chcirugprogr>();
        lstCirugiasSiguienteQuirofano = new ArrayList<Chcirugprogr>();
        lstCirugiasCompleta = new ArrayList<Chcirugprogr>();
        lstCirugiasCompletaRecuperacion = new ArrayList<Chcirugprogr>();
        lstCirugiasEnRecuperacion = new ArrayList<Chcirugprogr>();
        etapaIngreso = "IE";
        etapaPenQuiro = "PQ";
        fechaCirugia = new Date();
        cargarListasCirugia(fechaCirugia);

    }
    
    
    
    public String cargarListasCirugia(Date fechaCirugia1){
        try {

            if (esRegistroAnestesia) {

                lstCirugiasIngresoEnfermeria = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasAnestesia(getClinica().getCclncodigo(), 
                                                                                                ETAPA_CIRUGIA_PENDIENTE_QUIROFANO, 
                                                                                                null, fechaCirugia1, getUsuarioSystem().getCurnprofes());

                lstCirugiasPendienteQuirofano = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasAnestesia(getClinica().getCclncodigo(), 
                                                                                                ETAPA_CIRUGIA_EN_QUIROFANO, 
                                                                                                null, fechaCirugia1, getUsuarioSystem().getCurnprofes());
                                                                                                
                lstCirugiasEnRecuperacion =
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasAnestesia(getClinica().getCclncodigo(),
                                                                                                ETAPA_CIRUGIA_EN_RECUPERACION,
                                                                                                null, fechaCirugia1, getUsuarioSystem().getCurnprofes());
                                                                                                
                                                                                                
                if (lstCirugiasPendienteQuirofano != null && 
                    !lstCirugiasPendienteQuirofano.isEmpty()) {
                    lstCirugiasSiguienteQuirofano.add(lstCirugiasPendienteQuirofano.get(0));
                }
                
                
                
            } else {

                lstCirugiasIngresoEnfermeria = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(), 
                                                                                              ETAPA_CIRUGIA_PENDIENTE_QUIROFANO,
                                                                                              null, fechaCirugia1,getUsuarioSystem().getCurnprofes());

                lstCirugiasPendienteQuirofano = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(), 
                                                                                              ETAPA_CIRUGIA_EN_QUIROFANO, 
                                                                                              null, fechaCirugia1,getUsuarioSystem().getCurnprofes());
                                                                                              
                lstCirugiasEnRecuperacion = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(),
                                                                                              ETAPA_CIRUGIA_EN_RECUPERACION,
                                                                                              null, fechaCirugia1,getUsuarioSystem().getCurnprofes());

                if (lstCirugiasPendienteQuirofano != null && 
                    !lstCirugiasPendienteQuirofano.isEmpty()) {
                    lstCirugiasSiguienteQuirofano.add(lstCirugiasPendienteQuirofano.get(0));
                }
                
                
             
            }

        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        return null;
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
     * @param esIngresoMedico
     */
    public void setEsIngresoMedico(boolean esIngresoMedico) {
        this.esIngresoMedico = esIngresoMedico;
    }

    /**
     * @return
     */
    public boolean isEsIngresoMedico() {
        return esIngresoMedico;
    }

    /**
     * @param esEvolucion
     */
    public void setEsEvolucion(boolean esEvolucion) {
        this.esEvolucion = esEvolucion;
    }

    /**
     * @return
     */
    public boolean isEsEvolucion() {
        return esEvolucion;
    }

    /**
     * @param esEpicrisis
     */
    public void setEsEpicrisis(boolean esEpicrisis) {
        this.esEpicrisis = esEpicrisis;
    }

    /**
     * @return
     */
    public boolean isEsEpicrisis() {
        return esEpicrisis;
    }

    /**
     * @param esRegistroAnestesia
     */
    public void setEsRegistroAnestesia(boolean esRegistroAnestesia) {
        this.esRegistroAnestesia = esRegistroAnestesia;
    }

    /**
     * @return
     */
    public boolean isEsRegistroAnestesia() {
        return esRegistroAnestesia;
    }

    /**
     * @param lstCirugiasIngresadas
     */
    public void setLstCirugiasIngresadas(List<Chcirugprogr> lstCirugiasIngresadas) {
        this.lstCirugiasIngresadas = lstCirugiasIngresadas;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstCirugiasIngresadas() {
        return lstCirugiasIngresadas;
    }

    /**
     * @param dtCirugia
     */
    public void setDtCirugia(HtmlDataTable dtCirugia) {
        this.dtCirugia = dtCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugia() {
        return dtCirugia;
    }


    /**
     * @return
     */
    public String registrarEvolucion() {
        String navegationRule = "";

        FacesUtils.resetManagedBean("evolucionBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        FacesUtils.resetManagedBean("recomedacionCirugiaBean");
        FacesUtils.resetManagedBean("autorizacionServicioUsuarioBean");

        DatosBasicosUsuarioCirugiaBean datosUsuarios = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        EvolucionBean evolucion;
        Chevolucion evolucionObject;

        evolucionObject = null;

        MenuEvolucionMedicoBean menu = 
            (MenuEvolucionMedicoBean)FacesUtils.getManagedBean("menuEvolucionMedicoBean");

        Chcirugprogr cirugia = null;

        try {
            cirugia = (Chcirugprogr)dtCirugia.getRowData();


            if (cirugia != null){
                datosUsuarios.setUsuario(cirugia.getHcplusuario());
                datosUsuarios.inicializarUsuario();
                encabezado.setCirugia(cirugia);
                encabezado.inicializarCirugiasProgramadas();
            }

            evolucion = 
                    (EvolucionBean)FacesUtils.getManagedBean("evolucionBean");

            if (menu != null && cirugia != null) {
                menu.setCirugia(cirugia);
                menu.init();
            }

            if (evolucion != null && cirugia != null) {

                evolucionObject = 
                        this.serviceLocator.getClinicoService().getEvolucionSinCerrar(cirugia.getHcplnumero(), 
                                                                                      userName());
                if (evolucionObject != null) {
                    FacesUtils.addErrorMessage(IMsg.MSG_EVOLUCION_SIN_CERRAR);
                }

                evolucion.setCirugia(cirugia);
                evolucion.setEvolucion(evolucionObject);
                evolucion.inicializarEvolucion();
                navegationRule = BeanNavegacion.RUTA_IR_EVOLUCION_MEDICO;
            }


        } catch (ModelException e) {
            navegationRule = "";
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        } catch (Exception ex) {
            navegationRule = "";
            return capturaError(ex,IConstantes.ERROR_COSNULTA);
        }


        return navegationRule;
    }


    public String registrarEvolucionQuirofano() {
        String navegationRule = "";

        FacesUtils.resetManagedBean("evolucionBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("recomedacionUsuarioBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        RecomedacionUsuarioBean recomendacion = (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomendacion.init();
        
        resetConducta();
        
        resetConducta();

        DatosBasicosUsuarioCirugiaBean datosUsuarios = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        EvolucionBean evolucion;
        Chevolucion evolucionObject;

        evolucionObject = null;

        MenuEvolucionMedicoBean menu = 
            (MenuEvolucionMedicoBean)FacesUtils.getManagedBean("menuEvolucionMedicoBean");

        Chcirugprogr cirugia = null;

        try {
            cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();


            if (cirugia != null)
                datosUsuarios.setUsuario(cirugia.getHcplusuario());
                datosUsuarios.inicializarUsuario();
                encabezado.setCirugia(cirugia);
                encabezado.inicializarCirugiasProgramadas();

            evolucion = 
                    (EvolucionBean)FacesUtils.getManagedBean("evolucionBean");

            if (menu != null && cirugia != null) {
                menu.setCirugia(cirugia);
                menu.init();
            }

            if (evolucion != null && cirugia != null) {

                evolucionObject = 
                        this.serviceLocator.getClinicoService().getEvolucionSinCerrar(cirugia.getHcplnumero(), 
                                                                                      userName());
                if (evolucionObject != null) {
                    FacesUtils.addErrorMessage(IMsg.MSG_EVOLUCION_SIN_CERRAR);
                }

                evolucion.setCirugia(cirugia);
                evolucion.setEvolucion(evolucionObject);
                evolucion.inicializarEvolucion();
                navegationRule = BeanNavegacion.RUTA_IR_EVOLUCION_MEDICO;
            }


        } catch (ModelException e) {
            navegationRule = "";
            FacesUtils.addErrorMessage("ERROR ::::: " + e.getMessage());
        } catch (Exception ex) {
            navegationRule = "";
            FacesUtils.addErrorMessage("ERROR ::::: " + ex.getMessage());
        }


        return navegationRule;
    }
    
    
    public String registrarEvolucionRecuperacion() {
        String navegationRule = "";
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        FacesUtils.resetManagedBean("evolucionBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("recomedacionUsuarioBean");
        
        RecomedacionUsuarioBean recomendacion = (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomendacion.init();
        
        resetConducta();
        DatosBasicosUsuarioCirugiaBean datosUsuarios = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        EvolucionBean evolucion;
        Chevolucion evolucionObject;

        evolucionObject = null;

        MenuEvolucionMedicoBean menu = 
            (MenuEvolucionMedicoBean)FacesUtils.getManagedBean("menuEvolucionMedicoBean");

        Chcirugprogr cirugia = null;

        try {
            cirugia = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();


            if (cirugia != null)
                datosUsuarios.setUsuario(cirugia.getHcplusuario());
                datosUsuarios.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();

            evolucion = 
                    (EvolucionBean)FacesUtils.getManagedBean("evolucionBean");

            if (menu != null && cirugia != null) {
                menu.setCirugia(cirugia);
                menu.init();
            }

            if (evolucion != null && cirugia != null) {

                evolucionObject = 
                        this.serviceLocator.getClinicoService().getEvolucionSinCerrar(cirugia.getHcplnumero(), 
                                                                                      userName());
                if (evolucionObject != null) {
                    FacesUtils.addErrorMessage(IMsg.MSG_EVOLUCION_SIN_CERRAR);
                }

                evolucion.setCirugia(cirugia);
                evolucion.setEvolucion(evolucionObject);
                evolucion.inicializarEvolucion();
                navegationRule = BeanNavegacion.RUTA_IR_EVOLUCION_MEDICO;
            }


        } catch (ModelException e) {
            navegationRule = "";
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        } catch (Exception ex) {
            navegationRule = "";
            return capturaError(ex,IConstantes.ERROR_COSNULTA);
        }


        return navegationRule;
    }


    /**
     * @return
     */
    public String registrarIngreso() {
    
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        IngresoCirugiaMedicoBean ingresoMedico;
        DatosBasicosUsuarioBean datosUsuarios = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        MenuIngresoMedicoBean menu = 
            (MenuIngresoMedicoBean)FacesUtils.getManagedBean("menuIngresoMedicoBean");

        Chcirugprogr cirugia;
        cirugia = null;

        cirugia = (Chcirugprogr)dtCirugia.getRowData();


        if (cirugia != null){
            datosUsuarios.setUsuario(cirugia.getHcplusuario());
            datosUsuarios.inicializarUsuario();
        }

        ingresoMedico = 
                (IngresoCirugiaMedicoBean)FacesUtils.getManagedBean("ingresoCirugiaMedicoBean");

        if (ingresoMedico != null && cirugia != null) {
            ingresoMedico.setCirugia(cirugia);
            ingresoMedico.init();
        }


        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.setUsuario(cirugia.getHcplusuario());
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String registrarIngresoQuirofano() {
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        IngresoCirugiaMedicoBean ingresoMedico;
        DatosBasicosUsuarioBean datosUsuarios = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        MenuIngresoMedicoBean menu = 
            (MenuIngresoMedicoBean)FacesUtils.getManagedBean("menuIngresoMedicoBean");

        Chcirugprogr cirugia;
        cirugia = null;

        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();


        if (cirugia != null){
            datosUsuarios.setUsuario(cirugia.getHcplusuario());
            datosUsuarios.inicializarUsuario();
        }

        ingresoMedico = 
                (IngresoCirugiaMedicoBean)FacesUtils.getManagedBean("ingresoCirugiaMedicoBean");

        if (ingresoMedico != null && cirugia != null) {
            ingresoMedico.setCirugia(cirugia);
            ingresoMedico.init();
        }


        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.setUsuario(cirugia.getHcplusuario());
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_INGRESO_MEDICO;
    }
    
    
    
    
    
    
    /**
     * @return
     */
    public String registrarIngresoRecuperacion() {
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        IngresoCirugiaMedicoBean ingresoMedico;
        DatosBasicosUsuarioBean datosUsuarios = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        MenuIngresoMedicoBean menu = 
            (MenuIngresoMedicoBean)FacesUtils.getManagedBean("menuIngresoMedicoBean");

        Chcirugprogr cirugia;
        cirugia = null;

        cirugia = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();


        if (cirugia != null)
            datosUsuarios.setUsuario(cirugia.getHcplusuario());
            datosUsuarios.inicializarUsuario();


        ingresoMedico = 
                (IngresoCirugiaMedicoBean)FacesUtils.getManagedBean("ingresoCirugiaMedicoBean");

        if (ingresoMedico != null && cirugia != null) {
            ingresoMedico.setCirugia(cirugia);
            ingresoMedico.init();
        }


        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.setUsuario(cirugia.getHcplusuario());
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_INGRESO_MEDICO;
    }

    
    
    


    /**
     * @return
     */
    public String registrarAnestesia() throws ModelException {
        resetAnestesia();
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        RegistrarAnetesiaBean anestesiaBean = 
            (RegistrarAnetesiaBean)FacesUtils.getManagedBean("registrarAnetesiaBean");

        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        RegistrarMedidaProfilacticaBean regisPosicion = 
            (RegistrarMedidaProfilacticaBean)FacesUtils.getManagedBean("registrarMedidaProfilacticaBean");

        RegistrarSignosVitalesAnestesiaBean signosBean = 
            (RegistrarSignosVitalesAnestesiaBean)FacesUtils.getManagedBean("registrarSignosVitalesAnestesiaBean");

        RegistrarMonitoriaBean monitoriaBean = 
            (RegistrarMonitoriaBean)FacesUtils.getManagedBean("registrarMonitoriaBean");

        RegistrarLiquidosAnestesiaBean liquidosBean = 
            (RegistrarLiquidosAnestesiaBean)FacesUtils.getManagedBean("registrarLiquidosAnestesiaBean");

        RegistrarControlViaAereaBean registrarViaBean = 
            (RegistrarControlViaAereaBean)FacesUtils.getManagedBean("registrarControlViaAereaBean");
            
        RegistrarTecnicaAnestesiaBean registrarTecnicaBean = 
            (RegistrarTecnicaAnestesiaBean)FacesUtils.getManagedBean("registrarTecnicaAnestesiaBean");
            

        CerrarAnestesiaBean cerrarBean = 
            (CerrarAnestesiaBean)FacesUtils.getManagedBean("cerrarAnestesiaBean");

        MenuAnestesiaBean menuAnestesia = 
            (MenuAnestesiaBean)FacesUtils.getManagedBean("menuAnestesiaBean");


        RegistrarMedicamentoAnestesiaBean medicamentoBean = 
            (RegistrarMedicamentoAnestesiaBean)FacesUtils.getManagedBean("registrarMedicamentoAnestesiaBean");

        Chcirugprogr cirugia;
        cirugia = null;

        cirugia = (Chcirugprogr)dtCirugia.getRowData();

        detaConsul = 
                this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());

        if (detaConsul != null) {
            servicioDetalle = detaConsul.getId().getHdccservicio();

            servicio = 
                    this.serviceLocator.getClinicoService().getServicioPorId(servicioDetalle);

        }

        if (servicio != null && servicio.getCsvntiphis() != null && servicio.getCsvntiphis() != null && servicio.getCsvntiphis()!= null && servicio.getCsvntiphis()!= null && servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_LIGADURA_POR_BIPOLAR)) {

            ligadura = true;
            renderOtrasCirugias = false;
    

            DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


            if (cirugia != null) {

                datosUsuarioCirugia.setUsuario(cirugia.getHcplusuario());
                datosUsuarioCirugia.inicializarUsuario();


                if (anestesiaBean != null && cirugia != null) {
                    anestesiaBean.setCirugia(cirugia);
                    anestesiaBean.initRegisgtrarAnestesia();
                }

                if (encabezado != null && cirugia != null) {
                    encabezado.setCirugia(cirugia);
                    encabezado.inicializarCirugiasProgramadas();
                }

                if (regisPosicion != null && cirugia != null) {
                    regisPosicion.setNumeroCirugia(cirugia.getHcplnumero());
                    regisPosicion.setTipoServicio(TIPO_HOSPITALIZACION);

                    regisPosicion.cargarDatos();
                }

                if (signosBean != null && cirugia != null) {
                    signosBean.setCirugia(cirugia);
                    signosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    signosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    signosBean.cargarDatos();
                }

                if (monitoriaBean != null && cirugia != null) {
                    monitoriaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    monitoriaBean.cargarDatos();
                }

                if (liquidosBean != null && cirugia != null) {

                    liquidosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    liquidosBean.setUsuario(cirugia.getHcplusuario());
                    liquidosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    liquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    liquidosBean.setCirugia(cirugia);
                    liquidosBean.cargarDatos();
                }

                if (medicamentoBean != null && cirugia != null) {

                    medicamentoBean.setNumeroCirugia(cirugia.getHcplnumero());
                    medicamentoBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    medicamentoBean.cargarDatos();
                }

                if (registrarViaBean != null && cirugia != null) {
                    registrarViaBean.setCirugia(cirugia);
                    registrarViaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarViaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarViaBean.cargarDatos();
                }
                
                
                if(registrarTecnicaBean != null){
                    registrarTecnicaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarTecnicaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarTecnicaBean.cargarDatos();
                }

                if (cerrarBean != null && cirugia != null) {

                    cerrarBean.setNumeroCirugia(cirugia.getHcplnumero());
                    cerrarBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    cerrarBean.cargarDatos();
                }

               // FacesUtils.resetManagedBean("menuAnestesiaBean");
                menuAnestesia.setLigadura(ligadura);
                menuAnestesia.setRenderOtrasCirugias(renderOtrasCirugias);
                menuAnestesia.setUsuario(cirugia.getHcplusuario());
                menuAnestesia.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                menuAnestesia.setCirugia(cirugia);
                menuAnestesia.init();


                try {
                    this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }


            }


        } else {
            ligadura = true;
            renderOtrasCirugias = true;

            DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

            if (cirugia != null) {

                datosUsuarioCirugia.setUsuario(cirugia.getHcplusuario());
                datosUsuarioCirugia.inicializarUsuario();

                if (anestesiaBean != null && cirugia != null) {
                    anestesiaBean.setCirugia(cirugia);
                    anestesiaBean.initRegisgtrarAnestesia();
                }

                if (encabezado != null && cirugia != null) {
                    encabezado.setCirugia(cirugia);
                    encabezado.inicializarCirugiasProgramadas();
                }

                if (regisPosicion != null && cirugia != null) {
                    regisPosicion.setNumeroCirugia(cirugia.getHcplnumero());
                    regisPosicion.setTipoServicio(TIPO_HOSPITALIZACION);
                    regisPosicion.setRenderOtrasCirugias(renderOtrasCirugias);
                    regisPosicion.cargarDatos();
                }

                if (signosBean != null && cirugia != null) {
                    signosBean.setCirugia(cirugia);
                    signosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    signosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    signosBean.cargarDatos();
                }

                if (monitoriaBean != null && cirugia != null) {
                    monitoriaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    monitoriaBean.cargarDatos();
                }

                if (liquidosBean != null && cirugia != null) {

                    liquidosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    liquidosBean.setUsuario(cirugia.getHcplusuario());
                    liquidosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    liquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    liquidosBean.setCirugia(cirugia);
                    liquidosBean.cargarDatos();
                }

                if (medicamentoBean != null && cirugia != null) {

                    medicamentoBean.setNumeroCirugia(cirugia.getHcplnumero());
                    medicamentoBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    medicamentoBean.cargarDatos();
                }

                if (registrarViaBean != null && cirugia != null) {
                    registrarViaBean.setCirugia(cirugia);
                    registrarViaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarViaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarViaBean.cargarDatos();
                }
                
                
                if(registrarTecnicaBean != null){
                    registrarTecnicaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarTecnicaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarTecnicaBean.cargarDatos();
                }
                

                if (cerrarBean != null && cirugia != null) {

                    cerrarBean.setNumeroCirugia(cirugia.getHcplnumero());
                    cerrarBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    cerrarBean.cargarDatos();
                }

                //FacesUtils.resetManagedBean("menuAnestesiaBean");
                menuAnestesia.setLigadura(ligadura);
                menuAnestesia.setRenderOtrasCirugias(renderOtrasCirugias);
                menuAnestesia.setUsuario(cirugia.getHcplusuario());
                menuAnestesia.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                menuAnestesia.setCirugia(cirugia);
                menuAnestesia.init();


                try {
                    this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }


            }

        }
        return BeanNavegacion.RUTA_IR_REGISTRAR_ANESTESIA;
    }


    /**
     * @return
     */
    public String registrarAnestesiaRecuperacion() throws ModelException {
        resetAnestesia();
        FacesUtils.resetManagedBean("registrarMedidaProfilacticaBean");
        FacesUtils.resetManagedBean("registrarMonitoriaBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        RegistrarAnetesiaBean anestesiaBean = 
            (RegistrarAnetesiaBean)FacesUtils.getManagedBean("registrarAnetesiaBean");

        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        RegistrarMedidaProfilacticaBean regisPosicion = 
            (RegistrarMedidaProfilacticaBean)FacesUtils.getManagedBean("registrarMedidaProfilacticaBean");

        RegistrarSignosVitalesAnestesiaBean signosBean = 
            (RegistrarSignosVitalesAnestesiaBean)FacesUtils.getManagedBean("registrarSignosVitalesAnestesiaBean");

        RegistrarMonitoriaBean monitoriaBean = 
            (RegistrarMonitoriaBean)FacesUtils.getManagedBean("registrarMonitoriaBean");

        RegistrarLiquidosAnestesiaBean liquidosBean = 
            (RegistrarLiquidosAnestesiaBean)FacesUtils.getManagedBean("registrarLiquidosAnestesiaBean");

        RegistrarControlViaAereaBean registrarViaBean = 
            (RegistrarControlViaAereaBean)FacesUtils.getManagedBean("registrarControlViaAereaBean");
            
        RegistrarTecnicaAnestesiaBean registrarTecnicaBean = 
            (RegistrarTecnicaAnestesiaBean)FacesUtils.getManagedBean("registrarTecnicaAnestesiaBean");    

        CerrarAnestesiaBean cerrarBean = 
            (CerrarAnestesiaBean)FacesUtils.getManagedBean("cerrarAnestesiaBean");

        MenuAnestesiaBean menuAnestesia = 
            (MenuAnestesiaBean)FacesUtils.getManagedBean("menuAnestesiaBean");


        RegistrarMedicamentoAnestesiaBean medicamentoBean = 
            (RegistrarMedicamentoAnestesiaBean)FacesUtils.getManagedBean("registrarMedicamentoAnestesiaBean");

        Chcirugprogr cirugia;
        cirugia = null;

        cirugia = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();

        detaConsul = 
                this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());

        if (detaConsul != null) {
            servicioDetalle = detaConsul.getId().getHdccservicio();

            servicio = 
                    this.serviceLocator.getClinicoService().getServicioPorId(servicioDetalle);

        }

        if (servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_LIGADURA_POR_BIPOLAR)) {

            ligadura = true;
            renderOtrasCirugias = false;


            DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


            if (cirugia != null) {

                datosUsuarioCirugia.setUsuario(cirugia.getHcplusuario());
                datosUsuarioCirugia.setNumeroCirugia(cirugia.getHcplnumero());
                datosUsuarioCirugia.inicializarUsuario();


                if (anestesiaBean != null && cirugia != null) {
                    anestesiaBean.setCirugia(cirugia);
                    anestesiaBean.initRegisgtrarAnestesia();
                }

                if (encabezado != null && cirugia != null) {
                    encabezado.setCirugia(cirugia);
                    encabezado.inicializarCirugiasProgramadas();
                }

                if (regisPosicion != null && cirugia != null) {
                    regisPosicion.setNumeroCirugia(cirugia.getHcplnumero());
                    regisPosicion.setTipoServicio(TIPO_HOSPITALIZACION);

                    regisPosicion.cargarDatos();
                }

                if (signosBean != null && cirugia != null) {
                    signosBean.setCirugia(cirugia);
                    signosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    signosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    signosBean.cargarDatos();
                }

                if (monitoriaBean != null && cirugia != null) {
                    monitoriaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    monitoriaBean.cargarDatos();
                }

                if (liquidosBean != null && cirugia != null) {

                    liquidosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    liquidosBean.setUsuario(cirugia.getHcplusuario());
                    liquidosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    liquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    liquidosBean.setCirugia(cirugia);
                    liquidosBean.cargarDatos();
                }

                if (medicamentoBean != null && cirugia != null) {

                    medicamentoBean.setNumeroCirugia(cirugia.getHcplnumero());
                    medicamentoBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    medicamentoBean.cargarDatos();
                }

                if (registrarViaBean != null && cirugia != null) {
                    registrarViaBean.setCirugia(cirugia);
                    registrarViaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarViaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarViaBean.cargarDatos();
                }
                
                
                if(registrarTecnicaBean != null){
                    registrarTecnicaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarTecnicaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarTecnicaBean.cargarDatos();
                }
                

                if (cerrarBean != null && cirugia != null) {

                    cerrarBean.setNumeroCirugia(cirugia.getHcplnumero());
                    cerrarBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    cerrarBean.cargarDatos();
                }


                menuAnestesia.setLigadura(ligadura);
                menuAnestesia.setRenderOtrasCirugias(renderOtrasCirugias);
                menuAnestesia.setUsuario(cirugia.getHcplusuario());
                menuAnestesia.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                menuAnestesia.setCirugia(cirugia);
                menuAnestesia.init();


                try {
                    this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }


            }


        } else {

            ligadura = true;
            renderOtrasCirugias = true;

            DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


            if (cirugia != null) {

                datosUsuarioCirugia.setUsuario(cirugia.getHcplusuario());
                datosUsuarioCirugia.inicializarUsuario();


                if (anestesiaBean != null && cirugia != null) {
                    anestesiaBean.setCirugia(cirugia);
                    anestesiaBean.initRegisgtrarAnestesia();
                }

                if (encabezado != null && cirugia != null) {
                    encabezado.setCirugia(cirugia);
                    encabezado.inicializarCirugiasProgramadas();
                }

                if (regisPosicion != null && cirugia != null) {
                    regisPosicion.setNumeroCirugia(cirugia.getHcplnumero());
                    regisPosicion.setTipoServicio(TIPO_HOSPITALIZACION);
                    regisPosicion.setRenderOtrasCirugias(renderOtrasCirugias);
                    regisPosicion.cargarDatos();
                }

                if (signosBean != null && cirugia != null) {
                    signosBean.setCirugia(cirugia);
                    signosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    signosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    signosBean.cargarDatos();
                }

                if (monitoriaBean != null && cirugia != null) {
                    monitoriaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    monitoriaBean.setRenderOtrasCirugias(renderOtrasCirugias);
                    monitoriaBean.cargarDatos();
                }

                if (liquidosBean != null && cirugia != null) {

                    liquidosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    liquidosBean.setUsuario(cirugia.getHcplusuario());
                    liquidosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    liquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    liquidosBean.setCirugia(cirugia);
                    liquidosBean.cargarDatos();
                }

                if (medicamentoBean != null && cirugia != null) {

                    medicamentoBean.setNumeroCirugia(cirugia.getHcplnumero());
                    medicamentoBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    medicamentoBean.cargarDatos();
                }

                if (registrarViaBean != null && cirugia != null) {
                    registrarViaBean.setCirugia(cirugia);
                    registrarViaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarViaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarViaBean.cargarDatos();
                }
                
                
                if(registrarTecnicaBean != null){
                    registrarTecnicaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarTecnicaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarTecnicaBean.cargarDatos();
                }

                if (cerrarBean != null && cirugia != null) {

                    cerrarBean.setNumeroCirugia(cirugia.getHcplnumero());
                    cerrarBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    cerrarBean.cargarDatos();
                }

                //FacesUtils.resetManagedBean("menuAnestesiaBean");
                menuAnestesia.setLigadura(ligadura);
                menuAnestesia.setRenderOtrasCirugias(renderOtrasCirugias);
                menuAnestesia.setUsuario(cirugia.getHcplusuario());
                menuAnestesia.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                menuAnestesia.setCirugia(cirugia);
                menuAnestesia.init();


                try {
                    this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }


            }


        }
        return BeanNavegacion.RUTA_IR_REGISTRAR_ANESTESIA;
    }






    /**
     * @return
     */
    public String registrarAnestesiaQuirofano() throws ModelException {
        resetAnestesia();
        FacesUtils.resetManagedBean("registrarMedidaProfilacticaBean");
        FacesUtils.resetManagedBean("registrarMonitoriaBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        RegistrarAnetesiaBean anestesiaBean = 
            (RegistrarAnetesiaBean)FacesUtils.getManagedBean("registrarAnetesiaBean");

        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        RegistrarMedidaProfilacticaBean regisPosicion = 
            (RegistrarMedidaProfilacticaBean)FacesUtils.getManagedBean("registrarMedidaProfilacticaBean");

        RegistrarSignosVitalesAnestesiaBean signosBean = 
            (RegistrarSignosVitalesAnestesiaBean)FacesUtils.getManagedBean("registrarSignosVitalesAnestesiaBean");

        RegistrarMonitoriaBean monitoriaBean = 
            (RegistrarMonitoriaBean)FacesUtils.getManagedBean("registrarMonitoriaBean");
            
        RegistrarTecnicaAnestesiaBean registrarTecnicaBean = 
            (RegistrarTecnicaAnestesiaBean)FacesUtils.getManagedBean("registrarTecnicaAnestesiaBean");

        RegistrarLiquidosAnestesiaBean liquidosBean = 
            (RegistrarLiquidosAnestesiaBean)FacesUtils.getManagedBean("registrarLiquidosAnestesiaBean");

        RegistrarControlViaAereaBean registrarViaBean = 
            (RegistrarControlViaAereaBean)FacesUtils.getManagedBean("registrarControlViaAereaBean");

        CerrarAnestesiaBean cerrarBean = 
            (CerrarAnestesiaBean)FacesUtils.getManagedBean("cerrarAnestesiaBean");

        MenuAnestesiaBean menuAnestesia = 
            (MenuAnestesiaBean)FacesUtils.getManagedBean("menuAnestesiaBean");


        RegistrarMedicamentoAnestesiaBean medicamentoBean = 
            (RegistrarMedicamentoAnestesiaBean)FacesUtils.getManagedBean("registrarMedicamentoAnestesiaBean");

        Chcirugprogr cirugia;
        cirugia = null;

        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();

        detaConsul = 
                this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());

        if (detaConsul != null) {
            servicioDetalle = detaConsul.getId().getHdccservicio();

            servicio = 
                    this.serviceLocator.getClinicoService().getServicioPorId(servicioDetalle);

        }

        if (servicio.getCsvntiphis().equals(IConstantes.CIRUGIA_LIGADURA_POR_BIPOLAR)) {

            ligadura = true;
            renderOtrasCirugias = false;


            DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


            if (cirugia != null) {

                datosUsuarioCirugia.setUsuario(cirugia.getHcplusuario());
                datosUsuarioCirugia.setNumeroCirugia(cirugia.getHcplnumero());
                datosUsuarioCirugia.inicializarUsuario();


                if (anestesiaBean != null && cirugia != null) {
                    anestesiaBean.setCirugia(cirugia);
                    anestesiaBean.initRegisgtrarAnestesia();
                }

                if (encabezado != null && cirugia != null) {
                    encabezado.setCirugia(cirugia);
                    encabezado.inicializarCirugiasProgramadas();
                }

                if (regisPosicion != null && cirugia != null) {
                    regisPosicion.setNumeroCirugia(cirugia.getHcplnumero());
                    regisPosicion.setTipoServicio(TIPO_HOSPITALIZACION);

                    regisPosicion.cargarDatos();
                }

                if (signosBean != null && cirugia != null) {
                    signosBean.setCirugia(cirugia);
                    signosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    signosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    signosBean.cargarDatos();
                }

                if (monitoriaBean != null && cirugia != null) {
                    monitoriaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    monitoriaBean.cargarDatos();
                }

                if (liquidosBean != null && cirugia != null) {

                    liquidosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    liquidosBean.setUsuario(cirugia.getHcplusuario());
                    liquidosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    liquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    liquidosBean.setCirugia(cirugia);
                    liquidosBean.cargarDatos();
                }

                if (medicamentoBean != null && cirugia != null) {

                    medicamentoBean.setNumeroCirugia(cirugia.getHcplnumero());
                    medicamentoBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    medicamentoBean.cargarDatos();
                }

                if (registrarViaBean != null && cirugia != null) {
                    registrarViaBean.setCirugia(cirugia);
                    registrarViaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarViaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarViaBean.cargarDatos();
                }
                
                if(registrarTecnicaBean != null){
                    registrarTecnicaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarTecnicaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarTecnicaBean.cargarDatos();
                }
                

                if (cerrarBean != null && cirugia != null) {

                    cerrarBean.setNumeroCirugia(cirugia.getHcplnumero());
                    cerrarBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    cerrarBean.cargarDatos();
                }


                menuAnestesia.setLigadura(ligadura);
                menuAnestesia.setRenderOtrasCirugias(renderOtrasCirugias);
                menuAnestesia.setUsuario(cirugia.getHcplusuario());
                menuAnestesia.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                menuAnestesia.setCirugia(cirugia);
                menuAnestesia.init();


                try {
                    this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }


            }


        } else {

            ligadura = true;
            renderOtrasCirugias = true;

            DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


            if (cirugia != null) {

                datosUsuarioCirugia.setUsuario(cirugia.getHcplusuario());
                datosUsuarioCirugia.inicializarUsuario();

                if (anestesiaBean != null && cirugia != null) {
                    anestesiaBean.setCirugia(cirugia);
                    anestesiaBean.initRegisgtrarAnestesia();
                }

                if (encabezado != null && cirugia != null) {
                    encabezado.setCirugia(cirugia);
                    encabezado.inicializarCirugiasProgramadas();
                }

                if (regisPosicion != null && cirugia != null) {
                    regisPosicion.setNumeroCirugia(cirugia.getHcplnumero());
                    regisPosicion.setTipoServicio(TIPO_HOSPITALIZACION);
                    regisPosicion.setRenderOtrasCirugias(renderOtrasCirugias);
                    regisPosicion.cargarDatos();
                }

                if (signosBean != null && cirugia != null) {
                    signosBean.setCirugia(cirugia);
                    signosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    signosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    signosBean.cargarDatos();
                }

                if (monitoriaBean != null && cirugia != null) {
                    monitoriaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    monitoriaBean.setRenderOtrasCirugias(renderOtrasCirugias);
                    monitoriaBean.cargarDatos();
                }

                if (liquidosBean != null && cirugia != null) {

                    liquidosBean.setNumeroCirugia(cirugia.getHcplnumero());
                    liquidosBean.setUsuario(cirugia.getHcplusuario());
                    liquidosBean.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                    liquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    liquidosBean.setCirugia(cirugia);
                    liquidosBean.cargarDatos();
                }

                if (medicamentoBean != null && cirugia != null) {

                    medicamentoBean.setNumeroCirugia(cirugia.getHcplnumero());
                    medicamentoBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    medicamentoBean.cargarDatos();
                }

                if (registrarViaBean != null && cirugia != null) {
                    registrarViaBean.setCirugia(cirugia);
                    registrarViaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarViaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarViaBean.cargarDatos();
                }
                
                
                if(registrarTecnicaBean != null){
                    registrarTecnicaBean.setNumeroCirugia(cirugia.getHcplnumero());
                    registrarTecnicaBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    registrarTecnicaBean.cargarDatos();
                }

                if (cerrarBean != null && cirugia != null) {

                    cerrarBean.setNumeroCirugia(cirugia.getHcplnumero());
                    cerrarBean.setTipoServicio(TIPO_HOSPITALIZACION);
                    cerrarBean.cargarDatos();
                }

                //FacesUtils.resetManagedBean("menuAnestesiaBean");
                menuAnestesia.setLigadura(ligadura);
                menuAnestesia.setRenderOtrasCirugias(renderOtrasCirugias);
                menuAnestesia.setUsuario(cirugia.getHcplusuario());
                menuAnestesia.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
                menuAnestesia.setCirugia(cirugia);
                menuAnestesia.init();


                try {
                    this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }


            }


        }
        return BeanNavegacion.RUTA_IR_REGISTRAR_ANESTESIA;
    }









    private void resetAnestesia() {

        FacesUtils.resetManagedBean("registrarLiquidosAnestesiaBean");
        FacesUtils.resetManagedBean("cerrarAnestesiaBean");
        FacesUtils.resetManagedBean("registrarMedicamentoAnestesiaBean");
        FacesUtils.resetManagedBean("registrarAnetesiaBean");
        FacesUtils.resetManagedBean("registrarMedidaProfilacticaBean");
        FacesUtils.resetManagedBean("registrarMonitoriaBean");
        FacesUtils.resetManagedBean("registrarSignosVitalesAnestesiaBean");
        FacesUtils.resetManagedBean("registrarTecnicaAnestesiaBean");
        FacesUtils.resetManagedBean("registrarControlViaAereaBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        FacesUtils.resetManagedBean("evolucionBean");
        FacesUtils.resetManagedBean("examenFisicoUsuarioBean");
        FacesUtils.resetManagedBean("impresionDiagnosticaUsuarioBean");
        FacesUtils.resetManagedBean("recomedacionUsuarioBean");
        resetConducta();


    }
    
    
    private void resetConducta() {
        FacesUtils.resetManagedBean("anatomiaPatolUsuarioBean");
        FacesUtils.resetManagedBean("recomedacionUsuarioBean");
        FacesUtils.resetManagedBean("referenciaUsuarioBean");
        FacesUtils.resetManagedBean("certAsistenciaUsuarioBean");
        FacesUtils.resetManagedBean("certMedicoUsuarioBean");
        FacesUtils.resetManagedBean("controlSinCostoUsuarioBean");
        FacesUtils.resetManagedBean("examElectrofisioUsuarioBean");
        FacesUtils.resetManagedBean("examImagenUsuarioBean");
        FacesUtils.resetManagedBean("examLaboratorioUsuarioBean");
        FacesUtils.resetManagedBean("formulaMedicaUsuarioBean");
        FacesUtils.resetManagedBean("hospitalizacionUsuarioBean");
        FacesUtils.resetManagedBean("incapacidadUsuarioBean");
        FacesUtils.resetManagedBean("interConsultaUsuarioBean");
        FacesUtils.resetManagedBean("ordenCirugiaUsuarioBean");
        FacesUtils.resetManagedBean("reservaSangreUsuarioBean");
        FacesUtils.resetManagedBean("buscadorMedicamentoBean");
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
        FacesUtils.resetManagedBean("buscadorCie10");
        FacesUtils.resetManagedBean("buscadorCirugiasReservaBean");
        FacesUtils.resetManagedBean("buscadorCirugiasBean");
        // CIRUGIA NUEVO
        FacesUtils.resetManagedBean("formulaLiquidosBean");
        FacesUtils.resetManagedBean("formulaHospitalizacionBean");

    }

    public void setDetaConsul(Chdetacirpro detaConsul) {
        this.detaConsul = detaConsul;
    }

    public Chdetacirpro getDetaConsul() {
        return detaConsul;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setServicioDetalle(String servicioDetalle) {
        this.servicioDetalle = servicioDetalle;
    }

    public String getServicioDetalle() {
        return servicioDetalle;
    }


    public void setRutaNavegation(String rutaNavegation) {
        this.rutaNavegation = rutaNavegation;
    }

    public String getRutaNavegation() {
        return rutaNavegation;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }

    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }

    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }

    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }


    public void setOrdenCirugia(Chcirugprogr ordenCirugia) {
        this.ordenCirugia = ordenCirugia;
    }

    public Chcirugprogr getOrdenCirugia() {
        return ordenCirugia;
    }

    public void setOrden(Chcirugprogr orden) {
        this.orden = orden;
    }

    public Chcirugprogr getOrden() {
        return orden;
    }


    public void setEtapaIngreso(String etapaIngreso) {
        this.etapaIngreso = etapaIngreso;
    }

    public String getEtapaIngreso() {
        return etapaIngreso;
    }

    public void setEtapaPenQuiro(String etapaPenQuiro) {
        this.etapaPenQuiro = etapaPenQuiro;
    }

    public String getEtapaPenQuiro() {
        return etapaPenQuiro;
    }

    public void setLstCirugiasIngresoEnfermeria(List<Chcirugprogr> lstCirugiasIngresoEnfermeria) {
        this.lstCirugiasIngresoEnfermeria = lstCirugiasIngresoEnfermeria;
    }

    public List<Chcirugprogr> getLstCirugiasIngresoEnfermeria() {
        return lstCirugiasIngresoEnfermeria;
    }

    public void setLstCirugiasPendienteQuirofano(List<Chcirugprogr> lstCirugiasPendienteQuirofano) {
        this.lstCirugiasPendienteQuirofano = lstCirugiasPendienteQuirofano;
    }

    public List<Chcirugprogr> getLstCirugiasPendienteQuirofano() {
        return lstCirugiasPendienteQuirofano;
    }

    public void setLstCirugiasCompletaIngreso(List<Chcirugprogr> lstCirugiasCompletaIngreso) {
        this.lstCirugiasCompletaIngreso = lstCirugiasCompletaIngreso;
    }

    public List<Chcirugprogr> getLstCirugiasCompletaIngreso() {
        return lstCirugiasCompletaIngreso;
    }


    public void setDtCirugiaQuirofano(HtmlDataTable dtCirugiaQuirofano) {
        this.dtCirugiaQuirofano = dtCirugiaQuirofano;
    }

    public HtmlDataTable getDtCirugiaQuirofano() {
        return dtCirugiaQuirofano;
    }

    public void setLstCirugiasSiguienteQuirofano(List<Chcirugprogr> lstCirugiasSiguienteQuirofano) {
        this.lstCirugiasSiguienteQuirofano = lstCirugiasSiguienteQuirofano;
    }

    public List<Chcirugprogr> getLstCirugiasSiguienteQuirofano() {
        return lstCirugiasSiguienteQuirofano;
    }

    public void setLstCirugiasEnRecuperacion(List<Chcirugprogr> lstCirugiasEnRecuperacion) {
        this.lstCirugiasEnRecuperacion = lstCirugiasEnRecuperacion;
    }

    public List<Chcirugprogr> getLstCirugiasEnRecuperacion() {
        return lstCirugiasEnRecuperacion;
    }

    public void setDtCirugiaRecuperacion(HtmlDataTable dtCirugiaRecuperacion) {
        this.dtCirugiaRecuperacion = dtCirugiaRecuperacion;
    }

    public HtmlDataTable getDtCirugiaRecuperacion() {
        return dtCirugiaRecuperacion;
    }

    /**
     * @param lstCirugiasPendienteRecuperacion
     */
    public void setLstCirugiasPendienteRecuperacion(List<Chcirugprogr> lstCirugiasPendienteRecuperacion) {
        this.lstCirugiasPendienteRecuperacion = lstCirugiasPendienteRecuperacion;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstCirugiasPendienteRecuperacion() {
        return lstCirugiasPendienteRecuperacion;
    }

    /**
     * @param fechaCirugia
     */
    public void setFechaCirugia(Date fechaCirugia) {
        this.fechaCirugia = fechaCirugia;
    }

    /**
     * @return
     */
    public Date getFechaCirugia() {
        return fechaCirugia;
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setFechaCirugia(ValueChangeEvent valueChangeEvent) {
        setFechaCirugia((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    public void changeCirugia() {
        if (fechaCirugia != null && getClinica() != null) {
                cargarListasCirugia(fechaCirugia);
            } 
        }
    


    
    
}
