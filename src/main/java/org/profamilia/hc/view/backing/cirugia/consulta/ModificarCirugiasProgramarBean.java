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
import org.profamilia.hc.view.backing.cirugia.comun.CambiarCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.comun.MantenimientoCirugiasBean;
import org.profamilia.hc.view.backing.cirugia.registro.ModificarProgramacionBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ModificarCirugiasProgramarBean extends BaseBean {

    private List<Chcirugprogr> lstUsuarios;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuario;
    
    private Chcirugprogr cirugia;


    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ModificarProgramacionBean modificar;



    public ModificarCirugiasProgramarBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
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
        FacesUtils.resetManagedBean("modificarProgramacionBean");
        Long numeroCirugia = null; 
              Chcirugprogr cirugiaSelect = null;
              ModificarProgramacionBean modificar = 
                  (ModificarProgramacionBean)FacesUtils.getManagedBean("modificarProgramacionBean");
                  
        MantenimientoCirugiasBean mantenimientoCirugia = (MantenimientoCirugiasBean)FacesUtils.getManagedBean("mantenimientoCirugiasBean");
        
        CambiarCirugiaBean cambiarCirugia = (CambiarCirugiaBean)FacesUtils.getManagedBean("cambiarCirugiaBean");
        
        
        DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");
                  
              cirugiaSelect = (Chcirugprogr)dtConsultaUsuario.getRowData();
              cirugia = cirugiaSelect;
              
              if (cirugiaSelect != null && modificar != null && datosUsuarioCirugia != null && encabezado != null) {
                  modificar.setProgramacion(cirugiaSelect);
                  modificar.cargarConsultas();
                  usuario = cirugiaSelect.getHcplusuario(); 
                  numeroCirugia = cirugiaSelect.getHcplnumero(); 
                  datosUsuarioCirugia.setUsuario(usuario);
                  encabezado.setCirugia(cirugia);
                  encabezado.inicializarCirugiasProgramadas();
                  
              }
              
        if(mantenimientoCirugia != null && numeroCirugia!= null){
            mantenimientoCirugia.setNumeroCirugia(numeroCirugia);
            mantenimientoCirugia.setUsuario(usuario);
            mantenimientoCirugia.cargarConsultas();
        }
        
        if(cambiarCirugia != null && numeroCirugia!= null){
            cambiarCirugia.setNumeroCirugia(numeroCirugia);
            cambiarCirugia.setUsuario(usuario);
            cambiarCirugia.cargarConsultas();
        }
              
              return BeanNavegacion.RUTA_IR_MODIFICAR_PROGRAMACION;
    }

    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
    }
}
