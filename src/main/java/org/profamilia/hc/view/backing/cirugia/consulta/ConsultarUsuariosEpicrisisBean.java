package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEpicrisisBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuariosEpicrisisBean extends BaseBean {

    private List<Chcirugprogr> lstUsuariosIngresados;

    private List<SelectItem> listTipoIdentificacion;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuario;

    private Chcirugprogr cirugiaSelect;


    public ConsultarUsuariosEpicrisisBean() {

    }

    public void init() {
        lstUsuariosIngresados = new ArrayList<Chcirugprogr>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();

    }

    /**
     * @param lstUsuariosIngresados
     */
    public void setLstUsuariosIngresados(List<Chcirugprogr> lstUsuariosIngresados) {
        this.lstUsuariosIngresados = lstUsuariosIngresados;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstUsuariosIngresados() {
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
    public String registrarEpicrisis() {
        DatosBasicosUsuarioBean datosBasicosAux = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("registrarEpicrisisBean");
        cirugiaSelect = (Chcirugprogr)dtConsultaUsuario.getRowData();
        Long numerocirugia = null;

        if (cirugiaSelect != null) {
            numerocirugia = cirugiaSelect.getHcplnumero();
        }

        RegistrarEpicrisisBean epicrisisBean = null;
        epicrisisBean = 
                (RegistrarEpicrisisBean)FacesUtils.getManagedBean("registrarEpicrisisBean");

        if (epicrisisBean != null && cirugiaSelect != null) {
            epicrisisBean.setCirugiaSelect(cirugiaSelect);
            epicrisisBean.setNumerocirugia(numerocirugia);
            epicrisisBean.cargarDatos();
        }


        if (datosBasicosAux != null && cirugiaSelect != null) {
            datosBasicosAux.setUsuario(cirugiaSelect.getHcplusuario());
        }

        return BeanNavegacion.RUTA_IR_REGISTRAR_EPICRISIS;
    }


    public void buscarPacientesIngresados() {

        try {
            lstUsuariosIngresados = 
                    this.serviceLocator.getClinicoService().getCirugiaProgramadaEpicrisis(usuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


}
