package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaEnfermeria;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCanalizacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class ListaCirugiasProgramadasCheckBean extends BaseBean {

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

    private Chdetacirpro detaciru;

    private Long numeroConsulta;

    private Cpservicio servicio;

    private String nombreServicio;

    private List<Chcirugprogr> lstCirugiasCompleta;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ListaCirugiasProgramadasCheckBean() {

    }


    public void init() {
        FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
        lstCirugias = new ArrayList<Chcirugprogr>();
        lstCirugiasCompleta = new ArrayList<Chcirugprogr>();
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


                    try {
                        detaciru = 
                                this.getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (detaciru != null) {
                        try {
                            servicio = 
                                    this.getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }


                    }
                    if (servicio != null && !servicio.equals("")) {
                        nombreServicio = servicio.getCsvcnombre();
                    }


                    ciru.setNombreServicio(nombreServicio);
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
        FacesUtils.resetManagedBean("registrarCanalizacionBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        FacesUtils.resetManagedBean("registrarSignosVitalesBean");
        FacesUtils.resetManagedBean("menuIngresoEnfermeriaBean");

        cirugia = (Chcirugprogr)this.dtCirugias.getRowData();
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

        datosBasicosUsuarioCirugiaBean = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        datosBasicosUsuarioCirugiaBean.setUsuario(cirugia.getHcplusuario());
        datosBasicosUsuarioCirugiaBean.inicializarUsuario();


        if (ingresoBean != null) {
            ingresoBean.setCirugia(cirugia);
            ingresoBean.init();
        }
        if (signos != null) {
            signos.setCirugia(cirugia);
            signos.setEsIngreso(true);
            signos.init();
        }
        if (liquidos != null) {
            liquidos.setCirugia(cirugia);
            liquidos.setEsIngreso(true);
            liquidos.init();
        }
        if (canalizacion != null) {
            canalizacion.setCirugia(cirugia);
            canalizacion.setEsIngreso(true);
            canalizacion.init();
        }
        if (nota != null) {
            nota.setCirugia(cirugia);
            nota.setEsIngreso(true);
            nota.init();
        }
        if (controlMedicamentos != null) {
            controlMedicamentos.setCirugia(cirugia);
            controlMedicamentos.init();
        }


        try {
            this.serviceLocator.getCirugiaService().updateIngresoCirugia(cirugia.getHcplnumero());


        } catch (ModelException e) {
            e.printStackTrace();
        }


        return BeanNavegacion.RUTA_IR_INGRESO_ENFERMERIA;
    }

    public void setDetaciru(Chdetacirpro detaciru) {
        this.detaciru = detaciru;
    }

    public Chdetacirpro getDetaciru() {
        return detaciru;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
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
}
