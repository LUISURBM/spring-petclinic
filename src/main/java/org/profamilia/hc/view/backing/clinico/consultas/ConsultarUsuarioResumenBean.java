package org.profamilia.hc.view.backing.clinico.consultas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuarioResumenBean extends BaseBean {

    private List<Chusuario> lstUsuarios;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuarioSelect;

    private Chusuario usuario;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ConsultarFoliosBean resumen;


    public ConsultarUsuarioResumenBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
    }


    public void setLstUsuarios(List<Chusuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public List<Chusuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

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


    public void setDtConsultaUsuario(HtmlDataTable dtConsultaUsuario) {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    public HtmlDataTable getDtConsultaUsuario() {
        return dtConsultaUsuario;
    }

    public void setUsuarioSelect(Chusuario usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    public Chusuario getUsuarioSelect() {
        return usuarioSelect;
    }


    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }


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
                        serviceLocator.getClinicoService().getUsuarios(usuario);
                dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstUsuarios == null || lstUsuarios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }

        } else {
            lstUsuarios = new ArrayList<Chusuario>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


        return BeanNavegacion.RUTA_ACTUAL;
    }

    public String consultarResumen() {
        // Obtenemos el usuario seleccionado 
        resumen = 
                (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        usuarioSelect = (Chusuario)this.dtConsultaUsuario.getRowData();
        dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
        if (resumen != null && usuarioSelect != null) {
            resumen.setUsuario(usuarioSelect);
        }
        return BeanNavegacion.RUTA_MOSTRAR_RESUMEN;
    }

}
