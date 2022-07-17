
package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.math.BigDecimal;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.registro.DescripcionQuirurgicaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuDescripcionBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaCirugiaDescripcionQuirurgicaBean extends BaseBean {


    private List<Chcirugprogr> lstCirugiasIngresadas;

    private List<Chcirugprogr> lstCirugiasRecuperacion;

    private List<Chcirugprogr> lstCirugiasPendientes;

    private List<Chcirugprogr> lstDescripcionesRealizadas;

    private HtmlDataTable dtCirugia;

    private HtmlDataTable dtCirugiaPendientes;

    private HtmlDataTable dtCirugiaRecuperacion;


    private HtmlDataTable dtCirugiaAnterior;

    private Chusuario usuario;

    private List<Chdetacirpro> detaciru;

    private Long numeroConsulta;

    private String nombreServicio;

    private List<Chcirugprogr> lstCirugiasCompletaAnterior;

    private Cpservicio servicio;

    private Date fechaHoy;

    private BigDecimal wcodmed;

    public ListaCirugiaDescripcionQuirurgicaBean() {

    }

    public void init() {
        lstCirugiasIngresadas = new ArrayList<Chcirugprogr>();
        lstCirugiasRecuperacion = new ArrayList<Chcirugprogr>();
        lstCirugiasPendientes = new ArrayList<Chcirugprogr>();
        lstDescripcionesRealizadas = new ArrayList<Chcirugprogr>();

        lstCirugiasCompletaAnterior = new ArrayList<Chcirugprogr>();
        usuario = new Chusuario();
        cargarCirugias();
    }

    public void cargarCirugias() {
        fechaHoy = new Date();
        System.out.println("fecha" + " " + fechaHoy);
        cargarListasCirugia(fechaHoy);
        cargarListasCirugiaRecuperacion(fechaHoy);
        cargarListasCirugiaPendientes(fechaHoy);

    }


    public String cargarListasCirugia(Date fechaHoy1) {
        try {
            // CIRUGIAS PARA REGISTRO
            lstCirugiasIngresadas = 
                    this.serviceLocator.getCirugiaService().getCirugiasProgramadasDescripcionQuirurgica(getClinica().getCclncodigo(), 
                                                                                                        fechaHoy1, 
                                                                                                        true, 
                                                                                                        getUsuarioSystem().getCurnprofes(), 
                                                                                                        ETAPA_CIRUGIA_EN_QUIROFANO);


        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (lstCirugiasIngresadas != null && 
            !lstCirugiasIngresadas.isEmpty()) {

            for (Chcirugprogr ciru: lstCirugiasIngresadas) {
                numeroConsulta = ciru.getHcplnumero();
                String nombreServicio1 = "";

                try {
                    detaciru = 
                            this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }

                if (detaciru != null) {
                    for (Chdetacirpro detalle: detaciru) {
                        try {
                            servicio = 
                                    this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                        } catch (ModelException e) {
                            return capturaError(e,IConstantes.ERROR_COSNULTA);
                        }


                        if (servicio != null && !servicio.equals("")) {

                            nombreServicio1 = 
                                    nombreServicio1 + " - " + servicio.getCsvcnombre();

                        }

                    }
                }

                ciru.setNombreServicio(nombreServicio1);


            }


        }

        return null;
    }


    public String cargarListasCirugiaRecuperacion(Date fechaHoy1) {
        try {


            lstCirugiasRecuperacion = 
                    this.serviceLocator.getCirugiaService().getCirugiasProgramadasDescripcionQuirurgica(getClinica().getCclncodigo(), 
                                                                                                        fechaHoy1, 
                                                                                                        true, 
                                                                                                        getUsuarioSystem().getCurnprofes(), 
                                                                                                        ETAPA_CIRUGIA_EN_RECUPERACION);


        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (lstCirugiasRecuperacion != null && 
            !lstCirugiasRecuperacion.isEmpty()) {

            for (Chcirugprogr ciru: lstCirugiasRecuperacion) {
                numeroConsulta = ciru.getHcplnumero();
                String nombreServicio1 = "";

                try {
                    detaciru = 
                            this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }

                for (Chdetacirpro detalle: detaciru) {
                    try {
                        servicio = 
                                this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }


                    if (servicio != null && !servicio.equals("")) {

                        nombreServicio1 = 
                                nombreServicio1 + " - " + servicio.getCsvcnombre();

                    }

                }


                ciru.setNombreServicio(nombreServicio1);


            }


        }
        return null;

    }


    public String cargarListasCirugiaPendientes(Date fechaHoy1) {
        try {


            lstCirugiasPendientes = 
                    this.serviceLocator.getCirugiaService().getCirugiasProgramadasDescripcionQuirurgica(getClinica().getCclncodigo(), 
                                                                                                        fechaHoy1, 
                                                                                                        true, 
                                                                                                        getUsuarioSystem().getCurnprofes(), 
                                                                                                        ETAPA_CIRUGIA_PENDIENTE_QUIROFANO);


        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }

        if (lstCirugiasPendientes != null && 
            !lstCirugiasPendientes.isEmpty()) {

            for (Chcirugprogr ciru: lstCirugiasPendientes) {
                numeroConsulta = ciru.getHcplnumero();
                String nombreServicio1 = "";


                try {
                    detaciru = 
                            this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }

                for (Chdetacirpro detalle: detaciru) {
                    try {
                        servicio = 
                                this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }


                    if (servicio != null && !servicio.equals("")) {

                        nombreServicio1 = 
                                nombreServicio1 + " - " + servicio.getCsvcnombre();

                    }

                }


                ciru.setNombreServicio(nombreServicio1);


            }


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


    public String seleccionarDescripcion() {
        
        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        
        Chcirugprogr cirugiaSelect = null;
        cirugiaSelect = (Chcirugprogr)dtCirugia.getRowData();
        Chcirugprogr cirugia = null;
        cirugia = cirugiaSelect;
        DetalleDescripcionQuirurgicaBean descripcionBean = null;
        DatosBasicosUsuarioCirugiaBean datosUsuariosBean = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        FacesUtils.resetManagedBean("menuDescripcionBean");
        FacesUtils.resetManagedBean("detalleDescripcionQuirurgicaBean");

        if (cirugia.getHcpctipoaneste().equals("6")) {
            try {
                this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }


        if (datosUsuariosBean != null && cirugiaSelect != null && 
            encabezado != null && cirugiaSelect.getHcplusuario() != null) {
            datosUsuariosBean.setUsuario(cirugia.getHcplusuario());
            datosUsuariosBean.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        descripcionBean = 
                (DetalleDescripcionQuirurgicaBean)FacesUtils.getManagedBean("detalleDescripcionQuirurgicaBean");
        if (descripcionBean != null && cirugiaSelect != null && 
            cirugiaSelect.getHcplusuario() != null) {
            descripcionBean.setUsuario(cirugiaSelect.getHcplusuario());
            descripcionBean.setCirugiaObject(cirugiaSelect);
            descripcionBean.setGeneroReporte(false);
            descripcionBean.inicializarCirugiasDescripcionQuirurgica();
        }

        return BeanNavegacion.RUTA_REGISTRAR_DETALLE_DESCRIPCION_QUIRURGICA;
    }


    public String seleccionarDescripcionRecuperacion() {

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        
        Chcirugprogr cirugiaSelect = null;
        cirugiaSelect = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();
        Chcirugprogr cirugia = null;
        cirugia = cirugiaSelect;
        DetalleDescripcionQuirurgicaBean descripcionBean = null;
        DatosBasicosUsuarioCirugiaBean datosUsuariosBean = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        FacesUtils.resetManagedBean("menuDescripcionBean");
        FacesUtils.resetManagedBean("detalleDescripcionQuirurgicaBean");


        if (datosUsuariosBean != null && cirugiaSelect != null && 
            encabezado != null && cirugiaSelect.getHcplusuario() != null) {
            datosUsuariosBean.setUsuario(cirugia.getHcplusuario());
            datosUsuariosBean.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        descripcionBean = 
                (DetalleDescripcionQuirurgicaBean)FacesUtils.getManagedBean("detalleDescripcionQuirurgicaBean");
        if (descripcionBean != null && cirugiaSelect != null && 
            cirugiaSelect.getHcplusuario() != null) {
            descripcionBean.setUsuario(cirugiaSelect.getHcplusuario());
            descripcionBean.setCirugiaObject(cirugiaSelect);
            descripcionBean.setGeneroReporte(false);
            descripcionBean.inicializarCirugiasDescripcionQuirurgica();
        }


        return BeanNavegacion.RUTA_REGISTRAR_DETALLE_DESCRIPCION_QUIRURGICA;
    }


    public String seleccionarDescripcionPendientes() {

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        
        Chcirugprogr cirugiaSelect = null;
        cirugiaSelect = (Chcirugprogr)dtCirugiaPendientes.getRowData();
        Chcirugprogr cirugia = null;
        cirugia = cirugiaSelect;
        DetalleDescripcionQuirurgicaBean descripcionBean = null;
        DatosBasicosUsuarioCirugiaBean datosUsuariosBean = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        FacesUtils.resetManagedBean("menuDescripcionBean");
        FacesUtils.resetManagedBean("detalleDescripcionQuirurgicaBean");

        if (cirugia.getHcpctipoaneste().equals("6")) {
            try {
                this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }


        if (datosUsuariosBean != null && cirugiaSelect != null && 
            encabezado != null && cirugiaSelect.getHcplusuario() != null) {
            datosUsuariosBean.setUsuario(cirugia.getHcplusuario());
            datosUsuariosBean.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        descripcionBean = 
                (DetalleDescripcionQuirurgicaBean)FacesUtils.getManagedBean("detalleDescripcionQuirurgicaBean");
        if (descripcionBean != null && cirugiaSelect != null && 
            cirugiaSelect.getHcplusuario() != null) {
            descripcionBean.setUsuario(cirugiaSelect.getHcplusuario());
            descripcionBean.setCirugiaObject(cirugiaSelect);
            descripcionBean.setGeneroReporte(false);
            descripcionBean.inicializarCirugiasDescripcionQuirurgica();
        }



        return BeanNavegacion.RUTA_REGISTRAR_DETALLE_DESCRIPCION_QUIRURGICA;
    }


    public String seleccionarDescripcionAnterior() {

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        
        Chcirugprogr cirugiaSelect = null;
        cirugiaSelect = (Chcirugprogr)dtCirugiaAnterior.getRowData();
        Chcirugprogr cirugia = null;
        cirugia = cirugiaSelect;
        DetalleDescripcionQuirurgicaBean descripcionBean = null;
        DatosBasicosUsuarioCirugiaBean datosUsuariosBean = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        FacesUtils.resetManagedBean("menuDescripcionBean");
        FacesUtils.resetManagedBean("detalleDescripcionQuirurgicaBean");

        if (cirugia.getHcpctipoaneste().equals("6")) {
            try {
                this.serviceLocator.getCirugiaService().updateIngresoQuirofano(cirugia.getHcplnumero());


            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }


        if (datosUsuariosBean != null && cirugiaSelect != null && 
            encabezado != null && cirugiaSelect.getHcplusuario() != null) {
            datosUsuariosBean.setUsuario(cirugia.getHcplusuario());
            datosUsuariosBean.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        descripcionBean = 
                (DetalleDescripcionQuirurgicaBean)FacesUtils.getManagedBean("detalleDescripcionQuirurgicaBean");
        if (descripcionBean != null && cirugiaSelect != null && 
            cirugiaSelect.getHcplusuario() != null) {
            descripcionBean.setUsuario(cirugiaSelect.getHcplusuario());
            descripcionBean.setCirugiaObject(cirugiaSelect);
            descripcionBean.setGeneroReporte(false);
            descripcionBean.inicializarCirugiasDescripcionQuirurgica();
        }


        return BeanNavegacion.RUTA_REGISTRAR_DETALLE_DESCRIPCION_QUIRURGICA;
    }


    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setFechaHoy(Date fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    public Date getFechaHoy() {
        return fechaHoy;
    }


    /**
     * @param valueChangeEvent
     */
    public void setFechaHoy(ValueChangeEvent valueChangeEvent) {
        setFechaHoy((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeCirugia() {
        if (fechaHoy != null && getClinica() != null) {
            cargarListasCirugia(fechaHoy);
            cargarListasCirugiaRecuperacion(fechaHoy);
            cargarListasCirugiaPendientes(fechaHoy);
        }
    }


    public void setLstDescripcionesRealizadas(List<Chcirugprogr> lstDescripcionesRealizadas) {
        this.lstDescripcionesRealizadas = lstDescripcionesRealizadas;
    }

    public List<Chcirugprogr> getLstDescripcionesRealizadas() {
        return lstDescripcionesRealizadas;
    }

    public void setLstCirugiasCompletaAnterior(List<Chcirugprogr> lstCirugiasCompletaAnterior) {
        this.lstCirugiasCompletaAnterior = lstCirugiasCompletaAnterior;
    }

    public List<Chcirugprogr> getLstCirugiasCompletaAnterior() {
        return lstCirugiasCompletaAnterior;
    }

    public void setDtCirugiaAnterior(HtmlDataTable dtCirugiaAnterior) {
        this.dtCirugiaAnterior = dtCirugiaAnterior;
    }

    public HtmlDataTable getDtCirugiaAnterior() {
        return dtCirugiaAnterior;
    }

    public void setWcodmed(BigDecimal wcodmed) {
        this.wcodmed = wcodmed;
    }

    public BigDecimal getWcodmed() {
        return wcodmed;
    }

    public void setDtCirugiaRecuperacion(HtmlDataTable dtCirugiaRecuperacion) {
        this.dtCirugiaRecuperacion = dtCirugiaRecuperacion;
    }

    public HtmlDataTable getDtCirugiaRecuperacion() {
        return dtCirugiaRecuperacion;
    }

    public void setLstCirugiasRecuperacion(List<Chcirugprogr> lstCirugiasRecuperacion) {
        this.lstCirugiasRecuperacion = lstCirugiasRecuperacion;
    }

    public List<Chcirugprogr> getLstCirugiasRecuperacion() {
        return lstCirugiasRecuperacion;
    }

    public void setDtCirugiaPendientes(HtmlDataTable dtCirugiaPendientes) {
        this.dtCirugiaPendientes = dtCirugiaPendientes;
    }

    public HtmlDataTable getDtCirugiaPendientes() {
        return dtCirugiaPendientes;
    }

    public void setLstCirugiasPendientes(List<Chcirugprogr> lstCirugiasPendientes) {
        this.lstCirugiasPendientes = lstCirugiasPendientes;
    }

    public List<Chcirugprogr> getLstCirugiasPendientes() {
        return lstCirugiasPendientes;
    }

    public void setDetaciru(List<Chdetacirpro> detaciru) {
        this.detaciru = detaciru;
    }

    public List<Chdetacirpro> getDetaciru() {
        return detaciru;
    }
}
