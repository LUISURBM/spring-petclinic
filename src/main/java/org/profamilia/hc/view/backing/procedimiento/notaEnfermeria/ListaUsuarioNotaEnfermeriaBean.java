package org.profamilia.hc.view.backing.procedimiento.notaEnfermeria;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Agendamiento;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiasProgramadasBean;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaEnfermeria;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesPendientesBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCanalizacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaValoracionCaidasBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuIngresoEnfermeriaBean;
import org.profamilia.hc.view.backing.webService.TomaVphWS;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaUsuarioNotaEnfermeriaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** */
    private Date fechaActual;

    /** Almacena el usuario  */
    private String usuarioSelect;

    private String msg_sin_registros;

    /** Almacena true si existen consultas para el dia */
    boolean existeConsulta;

    private List<Chcirugprogr> lstCirugias;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtCirugias;

    /** Almacena el bean de ingreso a Cirugia*/
    private IngresoCirugiaEnfermeria ingresoBean;

    private RegistrarSignosVitalesBean signos;

    private IngresoLiquidosBean liquidos;

    private RegistrarCanalizacionBean canalizacion;

    private RegistrarNotaEnfermeriaBean nota;

    private RegistrarMedicamentosBean controlMedicamentos;

    private DatosBasicosUsuarioCirugiaBean datosBasicosUsuarioCirugiaBean;

    private List<Chdetacirpro> detaciru;

    private Long numeroConsulta;

    private Cpservicio servicio;

    private String nombreServicio;

    private List<Chcirugprogr> lstCirugiasCompleta;
    //------------------------------------------------------        
    private boolean busquedaXCedula;

    private String numeroIdentificacion;

    /** Lista de Usuarios */
    private List<Cnconsclin> lstUsuarios;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;

    /** Clone de Consulta */
    private Cnconsclin consultaClone;

    private Boolean notaEnferProceConsul;

    private CierreNotaEnfemeriaProcedimientoBean cierreNotaEnfemeriaProcedimientoBean;

    private boolean renderCerrarIngreso;
    
    private RegistrarEscalaValoracionCaidasBean escalaValoracionCaidas;
    
    private OtrasOrdenesPendientesBean otrasOrdenes;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaUsuarioNotaEnfermeriaBean() throws IOException {
        lstUsuarios = new ArrayList<Cnconsclin>();
        dtConsultas = new HtmlDataTable();
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
        numeroIdentificacion = null;
        busquedaXCedula = false;

    }


    public void init() {

    }

    public String buscarConsultas() {
        if (fechaActual != null && getClinica() != null) {
            busquedaXCedula = true;
            if ("".equals(numeroIdentificacion)) {
                numeroIdentificacion = null;
            }
            try {
                if (numeroIdentificacion == null) {
                    this.lstUsuarios = 
                            this.serviceLocator.getClinicoService().getConsultasDiaNotaEnfermeria(fechaActual, 
                                                                                                  getClinica().getCclncodigo());
                    if (!lstUsuarios.isEmpty()) {
                        existeConsulta = true;
                        for (Cnconsclin consulta: lstUsuarios) {

                            Chconsulta chconsulta = new Chconsulta();

                            try {
                                chconsulta = 
                                        this.getServiceLocator().getClinicoService().getConsultaActual(consulta.getCconnumero().longValue());
                            } catch (ModelException e) {
                                return capturaError(e,IConstantes.ERROR_COSNULTA);
                            }
                            if (chconsulta != null && 
                                chconsulta.getHcoeetapa().equals("CE")) {
                                consulta.setRenderCerrarIngreso(true);
                            } else {
                                consulta.setRenderCerrarIngreso(false);
                            }
                        }
                    } else {
                        existeConsulta = false;
                    }

                } else {
                    this.lstUsuarios = 
                            this.serviceLocator.getClinicoService().getConsultasDiaNotaEnfermeriaXNumIden(getClinica().getCclncodigo(), 
                                                                                                          numeroIdentificacion);
                    if (!lstUsuarios.isEmpty()) {
                        existeConsulta = true;
                        for (Cnconsclin consulta: lstUsuarios) {

                            Chconsulta chconsulta = new Chconsulta();

                            try {
                                chconsulta = 
                                        this.getServiceLocator().getClinicoService().getConsultaActual(consulta.getCconnumero().longValue());
                            } catch (ModelException e) {
                                return capturaError(e,IConstantes.ERROR_COSNULTA);
                            }
                            if (chconsulta != null && 
                                chconsulta.getHcoeetapa().equals("CE")) {
                                consulta.setRenderCerrarIngreso(true);
                            } else {
                                consulta.setRenderCerrarIngreso(false);
                            }
                        }
                    } else {
                        existeConsulta = false;
                    }

                    numeroIdentificacion = null;
                }

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        return null;
    }

    public String atenderUsuario() {
        Chcirugprogr cirugia = new Chcirugprogr();
        DatosBasicosUsuarioBean datosBasicosUsuarioBean;
        FacesUtils.resetManagedBean("ingresoCirugiaEnfermeria");
        FacesUtils.resetManagedBean("ingresoLiquidosBean");
        FacesUtils.resetManagedBean("controlLiquidosBean");
        FacesUtils.resetManagedBean("administracionLiquidosBean");
        FacesUtils.resetManagedBean("registrarCanalizacionBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        FacesUtils.resetManagedBean("registrarSignosVitalesBean");
        FacesUtils.resetManagedBean("menuIngresoEnfermeriaBean");
        FacesUtils.resetManagedBean("cierreNotaEnfemeriaProcedimientoBean");
        FacesUtils.resetManagedBean("registrarEscalaValoracionCaidasBean");
        FacesUtils.resetManagedBean("otrasOrdenesPendientesBean");

        List<Cnconsclin> lstConsclin = new ArrayList();
        notaEnferProceConsul = true;
        
        boolean existeProgramacion = false; 
        
        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();

        lstConsclin.add(consultaClone);

        cirugia.setHcplnumero(consultaClone.getCconnumero().longValue());
        Chusuario usuario;
        usuario = null;
        
        if(consultaClone != null && consultaClone.getCconnumero() != null){
            try {
                existeProgramacion = serviceLocator.getCirugiaService().verificarProgramacionCirugia(consultaClone.getCconnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if(!existeProgramacion){

                   

                    try {
                        usuario = 
                                this.getServiceLocator().getClinicoService().getUsuario(consultaClone.getCcolusuario().getHuslnumero());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }
                    cirugia.setHcplusuario(usuario);

                    ingresoBean = 
                            (IngresoCirugiaEnfermeria)FacesUtils.getManagedBean("ingresoCirugiaEnfermeria");
                    signos = 
                            (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
                    liquidos = 
                            (IngresoLiquidosBean)FacesUtils.getManagedBean("ingresoLiquidosBean");
                    canalizacion = 
                            (RegistrarCanalizacionBean)FacesUtils.getManagedBean("registrarCanalizacionBean");
                    nota = 
            (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
                    controlMedicamentos = 
                            (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
                    cierreNotaEnfemeriaProcedimientoBean = 
                            (CierreNotaEnfemeriaProcedimientoBean)FacesUtils.getManagedBean("cierreNotaEnfemeriaProcedimientoBean");
                            
                    escalaValoracionCaidas = 
                        (RegistrarEscalaValoracionCaidasBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasBean");
                        
                    otrasOrdenes =
                    (OtrasOrdenesPendientesBean)FacesUtils.getManagedBean("otrasOrdenesPendientesBean");
                        
                    datosBasicosUsuarioCirugiaBean = 
                            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
                    datosBasicosUsuarioCirugiaBean.setUsuario(cirugia.getHcplusuario());
                    datosBasicosUsuarioCirugiaBean.inicializarUsuario();

                    if (ingresoBean != null) {
                        ingresoBean.setCirugia(cirugia);
                        ingresoBean.setTipoServicio(TIPO_PROCEDIMIENTO);
                        ingresoBean.setNotaEnfeProce(true);
                        ingresoBean.init();
                    }
                    if (signos != null) {
                        signos.setCirugia(cirugia);
                        signos.setEsIngreso(true);
                        signos.setNotaEnfeProce(true);
                        signos.init();
                        signos.setTipoServicio(TIPO_PROCEDIMIENTO);

                    }
                    if (liquidos != null) {
                        liquidos.setCirugia(cirugia);
                        liquidos.setEsIngreso(true);
                        liquidos.setNotaEnfeProce(true);
                        liquidos.init();
                        liquidos.setTipoServicio(TIPO_PROCEDIMIENTO);
                    }
                    if (canalizacion != null) {
                        canalizacion.setCirugia(cirugia);
                        canalizacion.setEsIngreso(true);
                        canalizacion.setNotaEnfeProce(true);
                        canalizacion.init();
                        canalizacion.setTipoServicio(TIPO_PROCEDIMIENTO);
                    }
                    if (nota != null) {
                        nota.setCirugia(cirugia);
                        nota.setEsIngreso(true);
                        nota.setNotaEnfeProce(true);
                        nota.init();
                        nota.setTipoServicio(TIPO_PROCEDIMIENTO);
                    }
                    if (controlMedicamentos != null) {
                        controlMedicamentos.setCirugia(cirugia);
                        controlMedicamentos.setNotaEnfeProce(true);
                        controlMedicamentos.init();
                        controlMedicamentos.setTipoServicio(TIPO_PROCEDIMIENTO);
                    }
                    
                    if (escalaValoracionCaidas != null) {
                        escalaValoracionCaidas.setCirugia(cirugia);
                        escalaValoracionCaidas.setNotaEnfeProce(true);
                        escalaValoracionCaidas.init();
                    }

                    if (otrasOrdenes != null) {
                        otrasOrdenes.setCirugia(cirugia);
                        otrasOrdenes.setEsIngreso(true);
                        otrasOrdenes.init();
                    }
                    
                    
                    if (cierreNotaEnfemeriaProcedimientoBean != null) {
                        cierreNotaEnfemeriaProcedimientoBean.setConsulta(consultaClone);
                    }

                    Chingresoenf ingresoCirugia = null;
                    try {
                        ingresoCirugia = 
                                this.serviceLocator.getClinicoService().getIngresoEnfermeria(cirugia.getHcplnumero());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }

                    if (ingresoCirugia == null) {
                        if (ingresoBean.esValido()) {
                            return BeanNavegacion.RUTA_IR_INGRESO_SIGNOS_VITALES;
                        } else {
                            return BeanNavegacion.RUTA_IR_INGRESO_ENFERMERIA;
                        }
                    }else{
                        FacesUtils.addErrorMessage("Ya existe un ingreso de enfermeria por cirugia, no se puede realizar por procedimiento.");
                        
                    }
                    return BeanNavegacion.RUTA_ACTUAL;            
        }else{
            FacesUtils.addErrorMessage("Existe una programaci�n de cirug�a, si tiene que realiza por este m�dulo, cancele la programaci�n para realizar por esta opci�n (Procedimientos)");
            return BeanNavegacion.RUTA_ACTUAL;            
        }

    }
    
    
    public String cierreNotaEnfermeria() {
    
        this.consultaClone = (Cnconsclin)this.dtConsultas.getRowData();
        Long numConsulta = 
            Long.parseLong(consultaClone.getCconnumero().toString());
        Chconsulta chconsulta = new Chconsulta();

        try {
            chconsulta = 
                    this.getServiceLocator().getClinicoService().getConsultaActual(numConsulta);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        chconsulta.setHcoccieringr("S");
        
        try {
            this.getServiceLocator().getClinicoService().saveConsulta(chconsulta);
            FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
            return BeanNavegacion.RUTA_IR_LISTA_USUARIO_NOTA_ENFERMERIA;
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_GUARDADO);
        }
    }

    /**
     * @param fechaActual
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     * @return
     */
    public Date getFechaActual() {
        return fechaActual;
    }


    /**
     * @param usuarioSelect
     */
    public void setUsuarioSelect(String usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    /**
     * @return
     */
    public String getUsuarioSelect() {
        return usuarioSelect;
    }


    /**
     * @param existeConsulta
     */
    public void setExisteConsulta(boolean existeConsulta) {
        this.existeConsulta = existeConsulta;
    }

    /**
     * @return
     */
    public boolean isExisteConsulta() {
        return existeConsulta;
    }

    /**
     * @param msg_sin_registros
     */
    public void setMsg_sin_registros(String msg_sin_registros) {
        this.msg_sin_registros = msg_sin_registros;
    }

    /**
     * @return
     */
    public String getMsg_sin_registros() {
        return msg_sin_registros;
    }


    /**
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    // Value Change Listener

    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    // Acciones AJAX

    public void changeConsultas() {

    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setLstCirugiasCompleta(List<Chcirugprogr> lstCirugiasCompleta) {
        this.lstCirugiasCompleta = lstCirugiasCompleta;
    }

    public List<Chcirugprogr> getLstCirugiasCompleta() {
        return lstCirugiasCompleta;
    }

    public void setLstCirugias(List<Chcirugprogr> lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    public List<Chcirugprogr> getLstCirugias() {
        return lstCirugias;
    }

    public void setDetaciru(List<Chdetacirpro> detaciru) {
        this.detaciru = detaciru;
    }

    public List<Chdetacirpro> getDetaciru() {
        return detaciru;
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setIngresoBean(IngresoCirugiaEnfermeria ingresoBean) {
        this.ingresoBean = ingresoBean;
    }

    public IngresoCirugiaEnfermeria getIngresoBean() {
        return ingresoBean;
    }

    public void setSignos(RegistrarSignosVitalesBean signos) {
        this.signos = signos;
    }

    public RegistrarSignosVitalesBean getSignos() {
        return signos;
    }

    public void setLiquidos(IngresoLiquidosBean liquidos) {
        this.liquidos = liquidos;
    }

    public IngresoLiquidosBean getLiquidos() {
        return liquidos;
    }

    public void setCanalizacion(RegistrarCanalizacionBean canalizacion) {
        this.canalizacion = canalizacion;
    }

    public RegistrarCanalizacionBean getCanalizacion() {
        return canalizacion;
    }

    public void setNota(RegistrarNotaEnfermeriaBean nota) {
        this.nota = nota;
    }

    public RegistrarNotaEnfermeriaBean getNota() {
        return nota;
    }

    public void setControlMedicamentos(RegistrarMedicamentosBean controlMedicamentos) {
        this.controlMedicamentos = controlMedicamentos;
    }

    public RegistrarMedicamentosBean getControlMedicamentos() {
        return controlMedicamentos;
    }

    public void setDatosBasicosUsuarioCirugiaBean(DatosBasicosUsuarioCirugiaBean datosBasicosUsuarioCirugiaBean) {
        this.datosBasicosUsuarioCirugiaBean = datosBasicosUsuarioCirugiaBean;
    }

    public DatosBasicosUsuarioCirugiaBean getDatosBasicosUsuarioCirugiaBean() {
        return datosBasicosUsuarioCirugiaBean;
    }

    public void setBusquedaXCedula(boolean busquedaXCedula) {
        this.busquedaXCedula = busquedaXCedula;
    }

    public boolean isBusquedaXCedula() {
        return busquedaXCedula;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setLstUsuarios(List<Cnconsclin> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public List<Cnconsclin> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setDtConsultas(HtmlDataTable dtConsultas) {
        this.dtConsultas = dtConsultas;
    }

    public HtmlDataTable getDtConsultas() {
        return dtConsultas;
    }

    public void setConsultaClone(Cnconsclin consultaClone) {
        this.consultaClone = consultaClone;
    }

    public Cnconsclin getConsultaClone() {
        return consultaClone;
    }

    public void setNotaEnferProceConsul(Boolean notaEnferProceConsul) {
        this.notaEnferProceConsul = notaEnferProceConsul;
    }

    public Boolean getNotaEnferProceConsul() {
        return notaEnferProceConsul;
    }

    public void setCierreNotaEnfemeriaProcedimientoBean(CierreNotaEnfemeriaProcedimientoBean cierreNotaEnfemeriaProcedimientoBean) {
        this.cierreNotaEnfemeriaProcedimientoBean = 
                cierreNotaEnfemeriaProcedimientoBean;
    }

    public CierreNotaEnfemeriaProcedimientoBean getCierreNotaEnfemeriaProcedimientoBean() {
        return cierreNotaEnfemeriaProcedimientoBean;
    }

    public void setRenderCerrarIngreso(boolean renderCerrarIngreso) {
        this.renderCerrarIngreso = renderCerrarIngreso;
    }

    public boolean isRenderCerrarIngreso() {
        return renderCerrarIngreso;
    }

    public void setEscalaValoracionCaidas(RegistrarEscalaValoracionCaidasBean escalaValoracionCaidas) {
        this.escalaValoracionCaidas = escalaValoracionCaidas;
    }

    public RegistrarEscalaValoracionCaidasBean getEscalaValoracionCaidas() {
        return escalaValoracionCaidas;
    }


    public void setOtrasOrdenes(OtrasOrdenesPendientesBean otrasOrdenes) {
        this.otrasOrdenes = otrasOrdenes;
    }

    public OtrasOrdenesPendientesBean getOtrasOrdenes() {
        return otrasOrdenes;
    }
}
