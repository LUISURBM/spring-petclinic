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
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.registro.ProgramarCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarCirugiasProgramarBean extends BaseBean {

    private List<Chusuario> lstUsuarios;

    private List<Chcirugprogr> lstCirugiasProgramadas;

    private HtmlDataTable dtConsultaUsuario;

    private HtmlDataTable dtConsultaCirugias;

    private Chusuario usuario;


    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ProgramarCirugiaBean programar;



    public ConsultarCirugiasProgramarBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
        programar = 
                (ProgramarCirugiaBean)FacesUtils.getManagedBean("programarCirugiaBean");


    }


    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Chusuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Chusuario> getLstUsuarios() {
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
     * @param lstCirugiasProgramadas
     */
    public void setLstCirugiasProgramadas(List<Chcirugprogr> lstCirugiasProgramadas) {
        this.lstCirugiasProgramadas = lstCirugiasProgramadas;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstCirugiasProgramadas() {
        return lstCirugiasProgramadas;
    }

    /**
     * @param dtConsultaCirugias
     */
    public void setDtConsultaCirugias(HtmlDataTable dtConsultaCirugias) {
        this.dtConsultaCirugias = dtConsultaCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultaCirugias() {
        return dtConsultaCirugias;
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
                            serviceLocator.getClinicoService().getUsuarios(usuario);
                    dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
            } catch (ModelException e) {
                e.printStackTrace();
            }


        } else {
            lstUsuarios = new ArrayList<Chusuario>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * @return
     */
    public String consultar() {
        Chusuario usuarioAux;
        usuarioAux = null;

        usuarioAux = (Chusuario)dtConsultaUsuario.getRowData();
        
       
            if (programar != null) {
                programar.setUsuario(usuarioAux);
                programar.cargarConsultas();
            }
            
            DatosBasicosUsuarioCirugiaBean datosBasicosUsuario;
            
            datosBasicosUsuario = 
                    (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
                    
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");
                    
            if(datosBasicosUsuario!= null && encabezado != null){
                datosBasicosUsuario.setUsuario(usuarioAux);
              
                
            }

            return BeanNavegacion.RUTA_IR_PROGRAMACION_CIRUGIA;
       

      
    }
    public String volver() {
        
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_PROGRAMACION_CIRUGIA;
    }
}
