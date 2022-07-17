package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.ControlLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCanalizacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuariosIngresadosBean extends BaseBean {

    private List<Chingresoenf> lstUsuariosIngresados;

    private List<SelectItem> listTipoIdentificacion;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuario;

    private Chingresoenf ingresoSelect;

    public ConsultarUsuariosIngresadosBean() {

    }

    public void init() {
        lstUsuariosIngresados = new ArrayList<Chingresoenf>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
    }

    /**
     * @param lstUsuariosIngresados
     */
    public void setLstUsuariosIngresados(List<Chingresoenf> lstUsuariosIngresados) {
        this.lstUsuariosIngresados = lstUsuariosIngresados;
    }

    /**
     * @return
     */
    public List<Chingresoenf> getLstUsuariosIngresados() {
        return lstUsuariosIngresados;
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
     * @param param
     */
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }

    /**
     * @param dtConsultaUsuario
     */
    public void setDtConsultaUsuario(HtmlDataTable dtConsultaUsuario) {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultaUsuario() {
        return dtConsultaUsuario;
    }

    /**
     * @return
     */
    public String registrarLiquidos() {
        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        Chcirugprogr cirugia;
        DatosBasicosUsuarioBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        cirugia = null;

        try {
            cirugia = 
                    serviceLocator.getClinicoService().getProgramarCirugia(ingresoSelect.getId().getHielnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        ControlLiquidosBean control;
        control = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");

        if (control != null && cirugia != null) {
            control.setCirugia(cirugia);
            control.setEsIngreso(false);
            control.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        return BeanNavegacion.RUTA_IR_CONTROL_LIQUIDOS;
    }

    /**
     * @return
     */
    public String registrarMedicamentos() {
        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        Chcirugprogr cirugia;
        cirugia = null;

        try {
            cirugia = 
                    serviceLocator.getClinicoService().getProgramarCirugia(ingresoSelect.getId().getHielnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        RegistrarMedicamentosBean medicamentosBean;
        medicamentosBean = null;
        medicamentosBean = 
                (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
        if (medicamentosBean != null && cirugia != null) {
            medicamentosBean.setCirugia(cirugia);
            medicamentosBean.init();
        }

        return BeanNavegacion.RUTA_IR_REGISTRO_MEDICAMENTOS;
    }


    /**
     * @return
     */
    public String registrarSignosVitales() {
        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        RegistrarSignosVitalesBean signosVitalesBean;
        Chcirugprogr cirugia;
        cirugia = null;
        signosVitalesBean = 
                (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
        try {
            if (ingresoSelect != null) {
                cirugia = 
                        serviceLocator.getClinicoService().getProgramarCirugia(ingresoSelect.getId().getHielnumero());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (signosVitalesBean != null && cirugia != null) {
            signosVitalesBean.setCirugia(cirugia);
            signosVitalesBean.setEsIngreso(false);
            signosVitalesBean.init();
        }


        return BeanNavegacion.RUTA_IR_SIGNOS_VITALES_CONTROL;
    }

    /**
     * @return
     */
    public String registrarCanalizacion() {
        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        RegistrarCanalizacionBean canalizacionBean;
        Chcirugprogr cirugia;
        cirugia = null;

        canalizacionBean = 
                (RegistrarCanalizacionBean)FacesUtils.getManagedBean("registrarCanalizacionBean");

        try {
            if (ingresoSelect != null) {
                cirugia = 
                        serviceLocator.getClinicoService().getProgramarCirugia(ingresoSelect.getId().getHielnumero());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (canalizacionBean != null && cirugia != null) {
            canalizacionBean.setCirugia(cirugia);
            canalizacionBean.setEsIngreso(false);
            canalizacionBean.init();
        }


        return BeanNavegacion.RUTA_IR_CANALIZACION_CONTROL;
    }

    /**
     * @return
     */
    public String registrarNotasEnfermeria() {
        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        Chcirugprogr cirugia;
        cirugia = null;
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("consultarResumenEnfermeriaCirugiaBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        DatosBasicosUsuarioBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");


        try {
            cirugia = 
                    serviceLocator.getClinicoService().getProgramarCirugia(ingresoSelect.getId().getHielnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }


    public String registrarSalidaEnfermeria() {
        ingresoSelect = (Chingresoenf)dtConsultaUsuario.getRowData();
        Chcirugprogr cirugia;
        cirugia = null;
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("consultarResumenEnfermeriaCirugiaBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        DatosBasicosUsuarioBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");


        try {
            cirugia = 
                    serviceLocator.getClinicoService().getProgramarCirugia(ingresoSelect.getId().getHielnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.setEsSalida(true);
            notaBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }


    public void buscarPacientesIngresados() {

        try {
            lstUsuariosIngresados = 
                    this.serviceLocator.getCirugiaService().getPacientesIngresados(usuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


}
