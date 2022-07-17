package org.profamilia.hc.view.backing.clinico.consultas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.ModificarDatosUsuarioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarUsuarioBean extends BaseBean {

    private List<Chusuario> lstUsuarios;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuarioSelect;

    private Chusuario usuario;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ModificarDatosUsuarioBean modificarUsuario;

    ConsultarFoliosDocumento cosultas;

    ConsultarFoliosCitologiaBean consultaCitologia;

    ConsultarFoliosVphBean consultaVph;

    /** Almacena la edad del usuario*/
    private Integer edad;

    private Integer menu;

    private Integer consecutivoCito;
    
    private Chusuario usuarioConsecutivo;
    
    private Integer menuTuberculina=55;

    public ConsultarUsuarioBean() {
    }

    public void init() {
        inicializarConsultarUsuario();  
    }
    
    
    public void inicializarConsultarUsuario(){
        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
        usuarioConsecutivo = new Chusuario();
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
                        serviceLocator.getClinicoService().getUsuarios(usuario);
                dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
                if (lstUsuarios == null || lstUsuarios.isEmpty()) {
                    FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
                }
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
        
        if (usuarioConsecutivo != null && usuarioConsecutivo.getHuslnumero() != null) {
            usuarioAux = usuarioConsecutivo;
        } else {
            usuarioAux = (Chusuario)dtConsultaUsuario.getRowData();
        }
        
        if (menu != null) {
            if (menu.equals(IConstantes.MENU_MODIFICAR_DATOS_USUARIO)) {
                modificarUsuario = 
                        (ModificarDatosUsuarioBean)FacesUtils.getManagedBean("modificarDatosUsuarioBean");
                if (modificarUsuario != null && usuarioAux != null) {
                    modificarUsuario.setUsuario(usuarioAux);
                    modificarUsuario.setAfiliacion(usuarioAux.getHusetipoafilia());
                    modificarUsuario.setDepartamentoSelect(usuarioAux.getHusndepartamen().toString());
                    modificarUsuario.setCiudad(usuarioAux.getHusnciudad().toString());
                    if (usuarioAux.getHusdfechanacim() != null) {
                        edad = calcularEdad(usuarioAux.getHusdfechanacim(), new Date());
                        modificarUsuario.setEdad(edad);
                        modificarUsuario.setFechaNacimiento(usuarioAux.getHusdfechanacim());
                    }
                    if (usuarioAux.getHusnocupacion() != null)
                        modificarUsuario.setOcupacionSelect(usuarioAux.getHusnocupacion().toString());

                    return BeanNavegacion.RUTA_IR_MODIFICAR_DATOS_USUARIO;
                }
            }
            
            if (menu == MENU_MODIFICAR_CITOLOGIA) { 
                FacesUtils.resetManagedBean("consultarFoliosVphBean");
                FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
                consultaCitologia = 
                        (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
                consultaCitologia.setUsuario(usuarioAux);
                return BeanNavegacion.RUTA_IR_MODIFICAR_LECTURA_CITOLOGIA;
            }

            if (menu.equals(IConstantes.MENU_REIMPRIMIR_DOCUMENTOS)) {
                FacesUtils.resetManagedBean("consultarFoliosDocumentoBean");
                cosultas = 
                        (ConsultarFoliosDocumento)FacesUtils.getManagedBean("consultarFoliosDocumentoBean");
                if (cosultas != null && usuarioAux != null) {
                    cosultas.setUsuario(usuarioAux);
                    return BeanNavegacion.RUTA_IR_CONSULTAR_FOLIOS_DOCUMENTO;
                }

            }

            if (menu.equals(IConstantes.MENU_LECTURA_CITOLOGIA)) {
                consultaCitologia = 
                        (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
                consultaCitologia.setUsuario(usuarioAux);
                return BeanNavegacion.RUTA_IR_REGISTRAR_LECTURA_CITOLOGIA;
            }

            if (menu.equals(IConstantes.MENU_LECTURA_VPH)) {
                consultaVph = 
                        (ConsultarFoliosVphBean)FacesUtils.getManagedBean("consultarFoliosVphBean");
                consultaVph.setUsuario(usuarioAux);
                consultaVph.setTipoLectura(MENU_LECTURA_VPH);
                return BeanNavegacion.RUTA_IR_REGISTRAR_LECTURA_VPH;
            }
            if (menu.equals(IConstantes.MENU_MODIFICAR_VPH)) {
                FacesUtils.resetManagedBean("consultarFoliosVphBean");
                FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
                consultaCitologia = 
                        (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
                consultaCitologia.setUsuario(usuarioAux);
                consultaVph = 
                        (ConsultarFoliosVphBean)FacesUtils.getManagedBean("consultarFoliosVphBean");
                consultaVph.setUsuario(usuarioAux);
                consultaVph.setTipoLectura(MENU_MODIFICAR_VPH);
                return BeanNavegacion.RUTA_IR_MODIFICAR_LECTURA_VPH;
            }
            if (menu.equals(IConstantes.MENU_LECTURA_VPH_CITOLOGIA)) {
                consultaVph = 
                        (ConsultarFoliosVphBean)FacesUtils.getManagedBean("consultarFoliosVphBean");
                consultaVph.setUsuario(usuarioAux);
                consultaVph.setTipoLectura(MENU_LECTURA_VPH_CITOLOGIA);
                return BeanNavegacion.RUTA_IR_REGISTRAR_LECTURA_VPH_CITOLOGIA;
            }

            if (menu.equals(IConstantes.MENU_ENTREGA_CITOLOGIA)) {
                return BeanNavegacion.RUTA_IR_REGISTRAR_ENTREGA_CITOLOGIA;
            }

        }


        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * @return
     */
    public String consultarConsecutivoCitologia() {
        Cncitologi cito = null;
        Cnconsclin consultaClinica = null;
        List<Cnconsclin> consultaClinicaList = new ArrayList();

        try {
            if (consecutivoCito != null) {
                cito = serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivoCito);
            if(cito != null && cito.getCcinconsec() != null){   
                Long numeroUsuario = cito.getCcilusuario().getHuslnumero();
                usuarioConsecutivo= serviceLocator.getClinicoService().getUsuarioPorPk(numeroUsuario);
                consultaClinica = serviceLocator.getClinicoService().getConsultaClinicaPorId(cito.getCcilconcli().toString());
                if(consultaClinica != null && consultaClinica.getCconnumero()!= null){            
                consultaClinicaList = serviceLocator.getClinicoService().getCnconsclinLecturaXAdmision(numeroUsuario,consultaClinica.getCconnumdoc());
                }
                if(consultaClinicaList != null && !consultaClinicaList.isEmpty()){
                    consultaCitologia = 
                            (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
                    consultaCitologia.setUsuario(usuarioConsecutivo);
                    consultaCitologia.setLstConsClin(consultaClinicaList);
                    return BeanNavegacion.RUTA_IR_REGISTRAR_LECTURA_CITOLOGIA;
                }else{
                    FacesUtils.addErrorMessage("No se encontro lectura relacionada al numero de consecutivo.");
                }  
            }else{
                FacesUtils.addErrorMessage("No se encontro citologia relacionada con el numero de consecutivo.");
            }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }


    public void setConsecutivoCito(Integer consecutivoCito) {
        this.consecutivoCito = consecutivoCito;
    }

    public Integer getConsecutivoCito() {
        return consecutivoCito;
    }

    /**
     * @return
     */
    public String consultarUs() {
        Chusuario usuarioAux;
        usuarioAux = null;
        
        if (usuarioConsecutivo != null && usuarioConsecutivo.getHuslnumero() != null) {
            usuarioAux = usuarioConsecutivo;
        } else {
            usuarioAux = (Chusuario)dtConsultaUsuario.getRowData();
        }
        if (menuTuberculina.equals(IConstantes.HISTORIA_TOMA_TUBERCULINA)) {
            consultaCitologia = 
                    (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
            consultaCitologia.setUsuario(usuarioAux);
            
            return BeanNavegacion.RUTA_IR_MODIFICAR_DATOS_USUARIO_TUBERCULINA;
        }

                       
           
        return BeanNavegacion.RUTA_IR_MODIFICAR_DATOS_USUARIO_TUBERCULINA;
    }

    public void setMenuTuberculina(Integer menuTuberculina) {
        this.menuTuberculina = menuTuberculina;
    }

    public Integer getMenuTuberculina() {
        return menuTuberculina;
    }
}
