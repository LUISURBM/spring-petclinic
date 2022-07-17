package org.profamilia.hc.view.backing.procedimiento.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosCitologiaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosDocumento;
import org.profamilia.hc.view.backing.clinico.consultorio.ModificarDatosUsuarioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuariosCitologia extends BaseBean {

    private List<Cncitologi> lstUsuarios;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuarioSelect;

    private Chusuario usuario;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ModificarDatosUsuarioBean modificarUsuario;

    ConsultarFoliosDocumento cosultas;

    ConsultarFoliosCitologiaBean consultaCitologia;

    /** Almacena la edad del usuario*/
    private Integer edad;

    private Integer menu;


    public ConsultarUsuariosCitologia() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
    }


    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Cncitologi> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Cncitologi> getLstUsuarios() {
        return lstUsuarios;
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
     * @param usuarioSelect
     */
    public void setUsuarioSelect(Chusuario usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    /**
     * @return
     */
    public Chusuario getUsuarioSelect() {
        return usuarioSelect;
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
     * @param menu
     */
    public void setMenu(Integer menu) {
        this.menu = menu;
    }

    /**
     * @return
     */
    public Integer getMenu() {
        return menu;
    }


    /**
     * @return
     */
    public String consultarUsuario() {
        existenCriterios = true;
        if (usuario == null) {
            existenCriterios = false;
        }

        if (usuario != null) {
            if (((usuario.getHusanumeiden() == null || 
                  usuario.getHusanumeiden().equals("")) && 
                 (usuario.getHuscprimernomb() == null || 
                  usuario.getHuscprimernomb().equals("")) && 
                 (usuario.getHuscsegundnomb() == null || 
                  usuario.getHuscsegundnomb().equals("")) && 
                 (usuario.getHuscprimerapel() == null || 
                  usuario.getHuscprimerapel().equals("")) && 
                 (usuario.getHuscsegundapel() == null || 
                  usuario.getHuscsegundapel().equals("")))) {
                existenCriterios = false;
            }

        }

        if (existenCriterios) {
            try {
                lstUsuarios = 
                        serviceLocator.getClinicoService().getUsuariosCitologia(usuario);
                dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
                if (lstUsuarios == null || lstUsuarios.isEmpty()) {
                    FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

        } else {
            lstUsuarios = new ArrayList<Cncitologi>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * @return
     */
    public String consultar() {
        Cncitologi citologiaAux;
        Chusuario usuarioAux;
        usuarioAux = null;
        citologiaAux = null;
        citologiaAux = (Cncitologi)dtConsultaUsuario.getRowData();
        if (citologiaAux != null) {
            usuarioAux = citologiaAux.getCcilusuario();
        }

        if (menu != null && usuarioAux != null) {
            if (menu.equals(IConstantes.MENU_LECTURA_CITOLOGIA)) {
                consultaCitologia = 
                        (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
                consultaCitologia.setUsuario(usuarioAux);
                return BeanNavegacion.RUTA_IR_REGISTRAR_LECTURA_CITOLOGIA;
            }

            if (menu.equals(IConstantes.MENU_ENTREGA_CITOLOGIA)) {
                return BeanNavegacion.RUTA_IR_REGISTRAR_ENTREGA_CITOLOGIA;
            }

        }


        return BeanNavegacion.RUTA_ACTUAL;
    }


}
