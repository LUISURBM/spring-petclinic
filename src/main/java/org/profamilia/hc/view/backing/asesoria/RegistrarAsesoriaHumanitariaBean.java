//=======================================================================
// ARCHIVO Registrar Asesoria Colombia humanitaria
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registro asesoria Colombia humanitaria
//=======================================================================

package org.profamilia.hc.view.backing.asesoria;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chasesohuman;
import org.profamilia.hc.model.dto.Chasesoria;

import org.profamilia.hc.model.dto.Chsexo;

import org.profamilia.hc.model.dto.Chtipoaseso;
import org.profamilia.hc.model.dto.Chusuario;

import org.profamilia.hc.model.dto.Cpdonante;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  CLASE RegistrarAsesoriaHumanitariaBean
//=======================================================================
public class RegistrarAsesoriaHumanitariaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

   
    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la asesoria que se desea guardar */
    private Chasesohuman asesoria;
    
    /** DataTable la asesoria que se desea guardar */
    private HtmlDataTable dtMisAsesorias; 
    
    /** Almacena la lista de donantes */
    private  List<SelectItem> lstDonantes; 
    
    private List lstTipoAsesoria; 
    
    private List<String> lstTipoAsesoriaSelect; 

    /** Almacena la edad del usuario*/
    private Integer edad;

    private String nextAction;

    private String navegationRule;

    private String menuBean;

    private boolean renderUsuario;

    private boolean renderRegistrar;

    private List<Chusuario> lstUsuarios;

    private Chusuario usuario;

    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;

    static final int ACTIVAR_SELECCIONAR_USUARIOS = 1;

    private String msg_existe_asesoria;

    private boolean navegarAsesoria;

    private boolean navegarSeguimiento;

    private boolean renderSelecionarUsuario;

    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;
    
    private Date wfechasesoria; 
    
    private Integer wfinanciador; 
    
    private UIInput itNumeroIdentificacion;
    
    private List<Chasesohuman> lstAsesoriaHumanitaria; 
    
    private boolean deshabilitarEdad; 


   

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarAsesoriaHumanitariaBean() {

    }


    // ACTIONS

    public void init() {
        asesoria = new Chasesohuman();
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        lstTipoAsesoriaSelect = new ArrayList<String>();

        try {
            lstAsesoriaHumanitaria = this.serviceLocator.getClinicoService().getAsesoriaHumanitariaXUsuario(userName(),getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------


    public void changeEdad() {
        if (asesoria != null && asesoria.getHahdfechanacim() != null) {
            deshabilitarEdad = true; 
            setEdad(calcularEdad(asesoria.getHahdfechanacim(), new Date()));
           
        }else{
            deshabilitarEdad = true; 
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        asesoria.setHahdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

  


    /**
     * @param valueChangeEvent
     */
    public void setHahanumeiden(ValueChangeEvent valueChangeEvent) {
        asesoria.setHahanumeiden((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }


    public void buscadorUsuario() {
        renderUsuario = false;
        renderRegistrar = false;
        lstUsuarios = new ArrayList<Chusuario>();
        boolean wexito = true;
        deshabilitarEdad = false; 
        String url = "body:formAsesoriaHumanitaria:panelTabDatosOtraAsesoria:";

        if (asesoria.getHahetipoiden() == null || 
            asesoria.getHahetipoiden().equals("")) {
            FacesUtils.addErrorMessage(url + "tipoIde", MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }


        if (asesoria.getHahanumeiden() == null) {
            FacesUtils.addErrorMessage(url + "itNumeroIdentificacion", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }

        if (wexito) {
            if (asesoria != null) {

                try {
                    lstUsuarios = 
                            this.serviceLocator.getClinicoService().getUsuarios(asesoria.getHahetipoiden(), 
                                                                                asesoria.getHahanumeiden());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (lstUsuarios != null && !lstUsuarios.isEmpty()) {

                    if (lstUsuarios.size() == 1) {
                        usuario = lstUsuarios.get(0);
                        renderUsuario = true;

                        if (usuario != null) {
                            asesoria.setHahanumeiden(usuario.getHusanumeiden());
                            asesoria.setHahcprimerapel(usuario.getHuscprimerapel());
                            asesoria.setHahcprimernomb(usuario.getHuscprimernomb());
                            asesoria.setHahcsegundnomb(usuario.getHuscsegundnomb());
                            asesoria.setHahcsegundapel(usuario.getHuscsegundapel());
                            asesoria.setHahdfechanacim(usuario.getHusdfechanacim());
                            asesoria.setHahlnumusu(usuario.getHuslnumero());
                            asesoria.setHahesexo(usuario.getHusesexo());
                            if(usuario.getHusdfechanacim()!= null){
                                deshabilitarEdad = true;     
                            }
                            
                        }


                    } else if (lstUsuarios.size() > 1) {

                        renderSelecionarUsuario = true;
                        selectedIndex = ACTIVAR_SELECCIONAR_USUARIOS;
                    }

                } else {
                    asesoria.setHahlnumusu(0L);
                    asesoria.setHahcprimernomb(null);
                    asesoria.setHahcprimerapel(null);
                    asesoria.setHahcsegundnomb(null);
                    asesoria.setHahcsegundapel(null);
                    asesoria.setHahdfechanacim(null);
                    asesoria.setHahesexo(null);
                    renderRegistrar = true;
                }

            }
        }


    }


    public void resetDatos() {
        asesoria = new Chasesohuman(); 
        edad = null; 
        nextAction = ""; 
        navegationRule = ""; 
        renderUsuario = false; 
        renderRegistrar = false; 
        usuario = new Chusuario(); 
        navegarAsesoria = false; 
        navegarSeguimiento = false; 

        renderSelecionarUsuario = false; 
        calendarFechaNacimiento = new UIInput(); 
        itNumeroIdentificacion.setValue(null); 
        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");

    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


    /**
     * @param dtMisAsesorias
     */
    public void setDtMisAsesorias(HtmlDataTable dtMisAsesorias) {
         this.dtMisAsesorias = dtMisAsesorias;
     }

    /**
     * @return
     */
    public HtmlDataTable getDtMisAsesorias() {
         return dtMisAsesorias;
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
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
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
     * @param itNumeroIdentificacion
     */
    public void setItNumeroIdentificacion(UIInput itNumeroIdentificacion) {
        this.itNumeroIdentificacion = itNumeroIdentificacion;
    }

    /**
     * @return
     */
    public UIInput getItNumeroIdentificacion() {
        return itNumeroIdentificacion;
    }

  

    /**
     * @param param
     */
    public void setListSexos(List<SelectItem> param) {
        this.listSexos = param;
    }

    /**
     * @return La lista de los sexos que existen
     */
    public List<SelectItem> getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
            listSexos = new ArrayList<SelectItem>();
            ArrayList<Chsexo> listSexoAux = null;
            listSexos.add(new SelectItem("","Seleccione..."));
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;
                }
            }
        }
        return listSexos;
    }


   

  
    
    /**
     * @param lstDonantes
     */
    public void setLstDonantes(List<SelectItem> lstDonantes) {
        this.lstDonantes = lstDonantes;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstDonantes() {
        if (lstDonantes == null || lstDonantes.isEmpty()) {
            lstDonantes = new ArrayList<SelectItem>();
            ArrayList<Cpdonante> listDonanteAux = null;
            try {
                listDonanteAux = 
                        (ArrayList<Cpdonante>)this.getServiceLocator().getClinicoService().getDonante(); 
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listDonanteAux.isEmpty()) {

                Iterator it = listDonanteAux.iterator();
                int i = 0;
                lstDonantes.add(new SelectItem("","Seleccione una opci�n"));
                while (it.hasNext()) {
                    it.next();
                    lstDonantes.add(new SelectItem(listDonanteAux.get(i).getCdnncodigo(), 
                                                       listDonanteAux.get(i).getCdncdescri()));
                    i++;
                }
            }
        }
        return lstDonantes;
        }


    /**
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {
        return edad;
    }


    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }


    /**
     * @param renderUsuario
     */
    public void setRenderUsuario(boolean renderUsuario) {
        this.renderUsuario = renderUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderUsuario() {
        return renderUsuario;
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
     * @param renderRegistrar
     */
    public void setRenderRegistrar(boolean renderRegistrar) {
        this.renderRegistrar = renderRegistrar;
    }

    /**
     * @return
     */
    public boolean isRenderRegistrar() {
        return renderRegistrar;
    }

    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
    }


    /**
     * @param msg_existe_asesoria
     */
    public void setMsg_existe_asesoria(String msg_existe_asesoria) {
        this.msg_existe_asesoria = msg_existe_asesoria;
    }

    /**
     * @return
     */
    public String getMsg_existe_asesoria() {
        return msg_existe_asesoria;
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
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
     * @param navegarAsesoria
     */
    public void setNavegarAsesoria(boolean navegarAsesoria) {
        this.navegarAsesoria = navegarAsesoria;
    }

    /**
     * @return
     */
    public boolean isNavegarAsesoria() {
        return navegarAsesoria;
    }

    /**
     * @param navegarSeguimiento
     */
    public void setNavegarSeguimiento(boolean navegarSeguimiento) {
        this.navegarSeguimiento = navegarSeguimiento;
    }

    /**
     * @return
     */
    public boolean isNavegarSeguimiento() {
        return navegarSeguimiento;
    }

    /**
     * @param renderSelecionarUsuario
     */
    public void setRenderSelecionarUsuario(boolean renderSelecionarUsuario) {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderSelecionarUsuario() {
        return renderSelecionarUsuario;
    }

    /**
     * @param calendarFechaNacimiento
     */
    public void setCalendarFechaNacimiento(UIInput calendarFechaNacimiento) {
        this.calendarFechaNacimiento = calendarFechaNacimiento;
    }

    /**
     * @return
     */
    public UIInput getCalendarFechaNacimiento() {
        return calendarFechaNacimiento;
    }

  

    /**
     * @param asesoria
     */
    public void setAsesoria(Chasesohuman asesoria) {
        this.asesoria = asesoria;
    }

    /**
     * @return
     */
    public Chasesohuman getAsesoria() {
        return asesoria;
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
     * @param lstTipoAsesoria
     */
    public void setLstTipoAsesoria(List lstTipoAsesoria) {
        this.lstTipoAsesoria = lstTipoAsesoria;
    }

    /**
     * @return
     */
    public List getLstTipoAsesoria() {
        if (lstTipoAsesoria == null || lstTipoAsesoria.isEmpty()) {
            lstTipoAsesoria = new ArrayList<SelectItem>();
            ArrayList<Chtipoaseso> tipoAsesoriaList;
            tipoAsesoriaList = null;


            try {
                tipoAsesoriaList = 
                        (ArrayList<Chtipoaseso>)serviceLocator.getClinicoService().getTipoAsesoria();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            Iterator it = tipoAsesoriaList.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                lstTipoAsesoria.add(new SelectItem(tipoAsesoriaList.get(i).getHtaecodigo(), 
                                            tipoAsesoriaList.get(i).getHtacdescripcio()));
                i++;
            }

        }
        return lstTipoAsesoria;
        }

    /**
     * @param lstTipoAsesoriaSelect
     */
    public void setLstTipoAsesoriaSelect(List<String> lstTipoAsesoriaSelect) {
        this.lstTipoAsesoriaSelect = lstTipoAsesoriaSelect;
    }

    /**
     * @return
     */
    public List<String> getLstTipoAsesoriaSelect() {
        return lstTipoAsesoriaSelect;
    }

    /**
     * @param wfechasesoria
     */
    public void setWfechasesoria(Date wfechasesoria) {
        this.wfechasesoria = wfechasesoria;
    }

    /**
     * @return
     */
    public Date getWfechasesoria() {
        return wfechasesoria;
    }

    /**
     * @param wfinanciador
     */
    public void setWfinanciador(Integer wfinanciador) {
        this.wfinanciador = wfinanciador;
    }

    /**
     * @return
     */
    public Integer getWfinanciador() {
        return wfinanciador;
    }

    /**
     * @param lstAsesoriaHumanitaria
     */
    public void setLstAsesoriaHumanitaria(List<Chasesohuman> lstAsesoriaHumanitaria) {
        this.lstAsesoriaHumanitaria = lstAsesoriaHumanitaria;
    }

    /**
     * @return
     */
    public List<Chasesohuman> getLstAsesoriaHumanitaria() {
        return lstAsesoriaHumanitaria;
    }

    /**
     * @param deshabilitarEdad
     */
    public void setDeshabilitarEdad(boolean deshabilitarEdad) {
        this.deshabilitarEdad = deshabilitarEdad;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarEdad() {
        return deshabilitarEdad;
    }

    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    public void agregarUsuario() {
        usuario = (Chusuario)dtConsultaUsuario.getRowData();
        if (usuario != null) {
            asesoria.setHahanumeiden(usuario.getHusanumeiden());
            
            asesoria.setHahcprimerapel(usuario.getHuscprimerapel());
            asesoria.setHahcprimernomb(usuario.getHuscprimernomb());
            asesoria.setHahcsegundnomb(usuario.getHuscsegundnomb());
            asesoria.setHahcsegundapel(usuario.getHuscsegundapel());
            asesoria.setHahdfechanacim(usuario.getHusdfechanacim());
            asesoria.setHahlnumusu(usuario.getHuslnumero());
        }

    }


    public String seleccionarUsuario() {
        renderSelecionarUsuario = false;
        renderUsuario = true;
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        return BeanNavegacion.RUTA_ACTUAL;

    }


    /**
     * @return
     */
    public String guardarUsuario() {
        boolean wexito;
        wexito = true;
        asesoria.setHahcoperador(userName());
        asesoria.setHahdfecregistr(new Date());
        asesoria.setHaheestado(ESTADO_VIGENTE);
        asesoria.setHahnclinica(getClinica().getCclncodigo());
        String url = "body:formAsesoriaHumanitaria:panelTabDatosOtraAsesoria:"; 
        
        if(lstTipoAsesoriaSelect == null || lstTipoAsesoriaSelect.isEmpty())
        {
            FacesUtils.addErrorMessage(url+"mnuTipoAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        
        if(wfechasesoria == null){
            FacesUtils.addErrorMessage(url+"fechaAsesoriaHumanitaria", "El campo es obligatorio");
            wexito = false;
        }
        
        if(wfinanciador == null){
            FacesUtils.addErrorMessage(url+"menuDonanteAsesoriaHumanitaria", "El campo es obligatorio");
            wexito = false;
        }
        
        if(asesoria.getHahetipoiden() == null || asesoria.getHahetipoiden().equals("") ){
            FacesUtils.addErrorMessage(url+"tipoIdeOtraAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        
        if(asesoria.getHahanumeiden() == null ){
            FacesUtils.addErrorMessage(url+"itNumeroIdentificacionOtraAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        
        if(asesoria.getHahcprimernomb() == null || asesoria.getHahcprimernomb().equals("") ){
            FacesUtils.addErrorMessage(url+"primerNombreOtraAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        if(asesoria.getHahcprimerapel() == null || asesoria.getHahcprimerapel().equals("") ){
            FacesUtils.addErrorMessage(url+"primerApellidoOtraAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        if(asesoria.getHahnedad() == null){
            FacesUtils.addErrorMessage(url+"inputEdadOtraAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        if(asesoria.getHahesexo() == null || asesoria.getHahesexo().equals("")){
            FacesUtils.addErrorMessage(url+"radioSexoOtraAsesoria", "El campo es obligatorio");
            wexito = false;
        }
        
        if(wfechasesoria != null){
            asesoria.setHahdfechaaseso(wfechasesoria);
        }
        
        if(wfinanciador != null){
            asesoria.setHahnfinanciado(wfinanciador);
        }
        
        
        navegationRule = ""; 
        String wtipoaseso = ""; 
      
        if(lstTipoAsesoriaSelect != null && !lstTipoAsesoriaSelect.isEmpty())
        {
            for(String codigo: lstTipoAsesoriaSelect){
              
                wtipoaseso = wtipoaseso + "" + codigo +","; 
            }

            if(wtipoaseso != null && wtipoaseso.length() > 1)
            {
                wtipoaseso = wtipoaseso.substring(0, wtipoaseso.length() - 1);
                asesoria.setHahetipoaseso(wtipoaseso);
            }
        }
        
      
        
      if(wexito){
          try {
              this.serviceLocator.getClinicoService().saveAsesoriaHunanitaria(asesoria);
              lstAsesoriaHumanitaria = this.serviceLocator.getClinicoService().getAsesoriaHumanitariaXUsuario(userName(),getClinica().getCclncodigo());
              navegationRule = BeanNavegacion.RUTA_IR_REGISTRAR_OTRAS_ASESORIAS;
              resetDatos();
              FacesUtils.addInfoMessage(MSG_ADICION);
          } catch (ModelException e) {
              navegationRule = BeanNavegacion.RUTA_ACTUAL;
              FacesUtils.addErrorMessage(MSG_NO_ADICION + " " + e.getMessage());
          }
      }
        
        return navegationRule;
    }

    public void anularAsesoria() {
        boolean wanular = true; 
        Chasesohuman asesoriaAux = (Chasesohuman)dtMisAsesorias.getRowData(); 
        asesoriaAux.setHaheestado(ESTADO_ANULADO);
        
        if(asesoriaAux.getHaheestado()!= null && asesoriaAux.getHaheestado().equals(ESTADO_ANULADO)){
            FacesUtils.addErrorMessage("La asesoria ya esta anulada");
            wanular = false; 
        }
        
        if(wanular){
            try {
                this.serviceLocator.getClinicoService().saveAsesoriaHunanitaria(asesoriaAux);
                FacesUtils.addInfoMessage(MSG_ANULACION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ANULACION);
               e.printStackTrace();
            }    
        }

        
    }

   
}
