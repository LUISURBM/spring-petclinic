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
import org.profamilia.hc.view.backing.cirugia.comun.AdicionarCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.comun.MantenimientoCirugiasBean;
import org.profamilia.hc.view.backing.cirugia.registro.ModificarProgramacionBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuarioAgregarBean extends BaseBean {

    private List<Chcirugprogr> lstUsuarios;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuario;


    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    



    public ConsultarUsuarioAgregarBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
        dtConsultaUsuario = new HtmlDataTable(); 
      }


    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Chcirugprogr> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstUsuarios() {
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
     * @return
     */
    public String buscarUsuarioProgramacion() {
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
                 (usuario.getHuscsegundnomb() == null || 
                  usuario.getHuscsegundnomb().equals("")) && 
                 (usuario.getHuscsegundapel() == null || 
                  usuario.getHuscsegundapel().equals("")))) {
                existenCriterios = false;
            }

        }

        if (existenCriterios) {


            try {
                lstUsuarios = 
                        serviceLocator.getCirugiaService().getCirugiasModificarProgramadas(usuario);
                dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstUsuarios == null || lstUsuarios.isEmpty()) {
                FacesUtils.addErrorMessage(MSG_SIN_DATOS_REPROGRAMAR_CIRUGIA);
            }


        } else {
            lstUsuarios = new ArrayList<Chcirugprogr>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * @return
     */
    public String consultar() {
        FacesUtils.resetManagedBean("adicionarCirugiaBean");
        Long numeroCirugia = null; 
              Chcirugprogr cirugiaSelect = null;
    
       AdicionarCirugiaBean adicionarBean = 
                  (AdicionarCirugiaBean)FacesUtils.getManagedBean("adicionarCirugiaBean");
                  
        MantenimientoCirugiasBean mantenimientoCirugia = (MantenimientoCirugiasBean)FacesUtils.getManagedBean("mantenimientoCirugiasBean");
    
                  
              cirugiaSelect = (Chcirugprogr)dtConsultaUsuario.getRowData();
              if (cirugiaSelect != null && adicionarBean != null) {
                  adicionarBean.setProgramacion(cirugiaSelect);
                  adicionarBean.cargarConsultas();
                  usuario = cirugiaSelect.getHcplusuario(); 
                  numeroCirugia = cirugiaSelect.getHcplnumero(); 
              }
              
        if(mantenimientoCirugia != null && numeroCirugia!= null){
            mantenimientoCirugia.setNumeroCirugia(numeroCirugia);
            mantenimientoCirugia.setUsuario(usuario);
            mantenimientoCirugia.setRenderIconEliminar(true);
            mantenimientoCirugia.cargarConsultas();
        }
              
              return BeanNavegacion.RUTA_IR_ADICIONAR_CIRUGIA;
    }
}
