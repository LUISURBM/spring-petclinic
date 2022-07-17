package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaEnfermeria;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCanalizacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaValoracionCaidasBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuIngresoEnfermeriaBean;
import org.profamilia.hc.view.backing.procedimiento.notaEnfermeria.ListaUsuarioNotaEnfermeriaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaCirugiasProgramadasBean extends BaseBean {

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
    
    private CuestionarioCovidBean cuestionario;


    private RegistrarNotaEnfermeriaBean nota;

    private RegistrarMedicamentosBean controlMedicamentos;

    private DatosBasicosUsuarioCirugiaBean datosBasicosUsuarioCirugiaBean;

    private List<Chdetacirpro> detaciru;

    private Long numeroConsulta;

    private Cpservicio servicio;

    private String nombreServicio;

    private List<Chcirugprogr> lstCirugiasCompleta;
    
    private MenuIngresoEnfermeriaBean menuIngresoEnfermeria;
    
    private RegistrarEscalaValoracionCaidasBean escalaValoracionCaidas;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaCirugiasProgramadasBean() {

    }


    public void init() {
        FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
        lstCirugias = new ArrayList<Chcirugprogr>();
        lstCirugiasCompleta = new ArrayList<Chcirugprogr>();
        
        String nombreServicio2 = null;
        if (getClinica() != null) {
            fechaActual = new Date();

            try {
                this.lstCirugias = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasIngresoEnfermeria(this.getClinica().getCclncodigo(), 
                                                                                                        fechaActual);

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstCirugias != null && !lstCirugias.isEmpty()) {

                for (Chcirugprogr ciru: lstCirugias) {
                    numeroConsulta = ciru.getHcplnumero();
                    String nombreServicio1 = "";


                    try {
                        detaciru = 
                                this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (detaciru != null) {
                        for(Chdetacirpro detalle: detaciru){
                            try {
                                servicio = 
                                        this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                       
                       
                        if (servicio != null && !servicio.equals("")) {
                           
                                nombreServicio1 = nombreServicio1 + " - " + servicio.getCsvcnombre() ;
                          
                        }

                        }
                    }

                    ciru.setNombreServicio(nombreServicio1);
                    lstCirugiasCompleta.add(ciru); // ADICIONANDO UN OBEJO


                }
                lstCirugiasCompleta = lstCirugias;

            }


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


    public String atenderUsuario() {
        Chcirugprogr cirugia;
        DatosBasicosUsuarioBean datosBasicosUsuarioBean;
        FacesUtils.resetManagedBean("ingresoCirugiaEnfermeria");
        FacesUtils.resetManagedBean("ingresoLiquidosBean");
        FacesUtils.resetManagedBean("controlLiquidosBean");
        FacesUtils.resetManagedBean("registrarCanalizacionBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        FacesUtils.resetManagedBean("registrarSignosVitalesBean");
        FacesUtils.resetManagedBean("menuIngresoEnfermeriaBean");
        FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
        FacesUtils.resetManagedBean("registrarEscalaValoracionCaidasBean");
        FacesUtils.resetManagedBean("cuestionarioCovidBean");
        datosBasicosUsuarioBean = (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        


        cirugia = (Chcirugprogr)this.dtCirugias.getRowData();
        
        
        if(datosBasicosUsuarioBean != null && cirugia != null && cirugia.getHcplusuario() != null){
            datosBasicosUsuarioBean.setUsuario(cirugia.getHcplusuario());
            datosBasicosUsuarioBean.mensaje();
        }
        
        ingresoBean = 
                (IngresoCirugiaEnfermeria)FacesUtils.getManagedBean("ingresoCirugiaEnfermeria");
        signos = 
                (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
        liquidos = 
                (IngresoLiquidosBean)FacesUtils.getManagedBean("ingresoLiquidosBean");
        canalizacion = 
                (RegistrarCanalizacionBean)FacesUtils.getManagedBean("registrarCanalizacionBean");
                
        cuestionario = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        nota = 
    (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        controlMedicamentos = 
                (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
        
        escalaValoracionCaidas = 
            (RegistrarEscalaValoracionCaidasBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasBean");        

        datosBasicosUsuarioCirugiaBean = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        datosBasicosUsuarioCirugiaBean.setUsuario(cirugia.getHcplusuario());
        datosBasicosUsuarioCirugiaBean.inicializarUsuario();

        if (ingresoBean != null) {
            ingresoBean.setCirugia(cirugia);
            ingresoBean.setTipoServicio(null);
            ingresoBean.setNotaEnfeProce(false);
            ingresoBean.init();
        }
        if (signos != null) {
            signos.setCirugia(cirugia);
            signos.setEsIngreso(true);
            signos.setNotaEnfeProce(false);
            signos.init();
            signos.setTipoServicio(null);
        }
        if (liquidos != null) {
            liquidos.setCirugia(cirugia);
            liquidos.setEsIngreso(true);
            liquidos.setNotaEnfeProce(false);
            liquidos.init();
            liquidos.setTipoServicio(null);
        }
        if (canalizacion != null) {
            canalizacion.setCirugia(cirugia);
            canalizacion.setEsIngreso(true);
            canalizacion.setNotaEnfeProce(false);
            canalizacion.init();
            canalizacion.setTipoServicio(null);
        }
        if (nota != null) {
            nota.setCirugia(cirugia);
            nota.setEsIngreso(true);
            nota.setNotaEnfeProce(false);
            nota.init();
            nota.setTipoServicio(null);
        }
        if (controlMedicamentos != null) {
            controlMedicamentos.setCirugia(cirugia);
            controlMedicamentos.setNotaEnfeProce(false);
            controlMedicamentos.init();
            controlMedicamentos.setTipoServicio(null);
        }
        
        if (escalaValoracionCaidas != null) {
            escalaValoracionCaidas.setCirugia(cirugia);
            escalaValoracionCaidas.setNotaEnfeProce(false);
            escalaValoracionCaidas.init();
        }
        
        if(cuestionario != null){
            cuestionario.setNumeroUsuario(cirugia.getHcplusuario().getHuslnumero());
            cuestionario.setNumeroConsulta(cirugia.getHcplnumero());
            cuestionario.init();
        }

        Chingresoenf ingresoProcedimiento = null;
        try {
            ingresoProcedimiento = 
                    this.serviceLocator.getClinicoService().getIngresoEnfermeriaProcedimiento(cirugia.getHcplnumero());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        if (ingresoProcedimiento == null) {
            try {
                this.serviceLocator.getCirugiaService().updateIngresoCirugia(cirugia.getHcplnumero());

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }


            return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_INGRESO_ENFERMERIA;
        } else {
            FacesUtils.addErrorMessage("Ya existe un ingreso de enfermeria por procedimiento, no se puede realizar por cirugia."); 
        }
        
        return BeanNavegacion.RUTA_ACTUAL;

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

    public void setMenuIngresoEnfermeria(MenuIngresoEnfermeriaBean menuIngresoEnfermeria) {
        this.menuIngresoEnfermeria = menuIngresoEnfermeria;
    }

    public MenuIngresoEnfermeriaBean getMenuIngresoEnfermeria() {
        return menuIngresoEnfermeria;
    }
}
