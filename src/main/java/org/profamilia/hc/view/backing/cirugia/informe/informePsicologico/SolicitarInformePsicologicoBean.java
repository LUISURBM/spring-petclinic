//=======================================================================
// ARCHIVO SolicitarAnulacionBean.java
// FECHA CREACI�N: 26/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Consulta de Usuarios para solicitar autorizacion aclaraci�n 
//=======================================================================
 package org.profamilia.hc.view.backing.cirugia.informe.informePsicologico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.exceptions.NoFoundMailException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.AlertaEmail;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE SolicitarAnulacionBean
//=======================================================================

public class SolicitarInformePsicologicoBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private Integer edad;

    private boolean renderInformacionUsuario;


    StringBuffer sbuffer = new StringBuffer();

    private Long numeroUsuario;

    /** Almacena el numero de la consulta*/
    private Long numeroConsulta;

    /** Almacena la consulta seleccionada*/
    private Chconsulta consultaClone;

    private HtmlDataTable dtFolios;

    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFolios;

    private int selectedIndex;

    private boolean renderBuscador;

    private UIInput itNumeroUsuario;

    private String nombreUsuario;

    BuscadorUsuariosBean buscador;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private List lstDescripcion;

    private HtmlDataTable dtDescripcionAclaracion;

    private Chautoinfopsic autoriza;

    private DatosBasicosUsuarioBean datosBasicosUsuario;
    
    private AlertaEmail email = new AlertaEmail();
    
    private String recipientTo;
    
    private String recipientCc;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public SolicitarInformePsicologicoBean() {
    }

    public void init() {


        sbuffer = new StringBuffer();
        lstFolios = new ArrayList<Chconsulta>();

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();

        if (usuario == null) {
            usuario = new Chusuario();
        }

        autoriza = new Chautoinfopsic();

    }

    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
    }


    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Boton Secundarios
    //-----------------------------------------------------------------------


    public void consultarInformePsicologico() {
        try {
            if (numeroUsuario != null) {
                lstDescripcion = 
                        this.serviceLocator.getCirugiaService().getSolicitudFoliosInformePsicologico(numeroUsuario, userName());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

 

    public String solicitarAclaracion() {
        try {
            //recipientTo ="pmsierra@profamilia.org.co";
            //recipientCc ="carolina.beltran@profamilia.org.co";
            recipientTo ="daniel.ochoa@profamilia.org.co";
            recipientCc ="diana.forero@profamilia.org.co";
            autoriza.setHaipcetapa("VG");
            this.serviceLocator.getCirugiaService().saveAutorizacionInformePsicologico(autoriza);
            email.sendSolicitudMailInformePsicologico(autoriza,recipientTo,recipientCc);
            FacesUtils.addInfoMessage(MSG_ADICION);
            return BeanNavegacion.RUTA_HOME;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
            return BeanNavegacion.RUTA_ACTUAL;
        } catch (NoFoundMailException e) {
            e.getMessage();
            FacesUtils.addErrorMessage(e.getMessage());
            return BeanNavegacion.RUTA_ACTUAL;
        }

    }


    /**
     * @return
     */
    public String volverConsulta() {
        FacesUtils.resetManagedBean("solicitarInformePsicologicoBean");
        return BeanNavegacion.RUTA_IR_INICIO;
    }


    /**
     * @return
     */
    public String volverDescripcion() {
        FacesUtils.resetManagedBean("solicitarInformePsicologicoBean");
        return BeanNavegacion.RUTA_IR_SOLICITUD_INFORME_PSICOLOGICO;
    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
        nombreUsuario = "";
        usuario = new Chusuario();
        lstFolios = new ArrayList<Chconsulta>();
        if (numeroUsuario != null)
            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }

            lstDescripcion = new ArrayList();

            usuario = usuarioAux;

        }
    }


    /**
     * @return
     */
    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;

        usuario = new Chusuario();
        nombreUsuario = "";
        lstFolios = new ArrayList<Chconsulta>();

        buscador = 
                (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }

        lstDescripcion = new ArrayList();
        renderBuscador = false;

    }


    //-----------------------------------------------------------------------
    //  ACCESORIOS
    //-----------------------------------------------------------------------

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
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    /**
     * @param consultaClone
     */
    public void setConsultaClone(Chconsulta consultaClone) {
        this.consultaClone = consultaClone;
    }

    /**
     * @return
     */
    public Chconsulta getConsultaClone() {
        return consultaClone;
    }

    /**
     * @param dtFolios
     */
    public void setDtFolios(HtmlDataTable dtFolios) {
        this.dtFolios = dtFolios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFolios() {
        return dtFolios;
    }

    /**
     * @param lstFolios
     */
    public void setLstFolios(List<Chconsulta> lstFolios) {
        this.lstFolios = lstFolios;
    }

    /**
     * @return
     */
    public List<Chconsulta> getLstFolios() {
        return lstFolios;
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
    public List getListSexos() {
        if (listSexos.size() == 0) {
            ArrayList<Chsexo> listSexoAux = null;
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

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil.size() == 0) {
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
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
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
        return numeroUsuario;
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
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    /**
     * @param itNumeroUsuario
     */
    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    /**
     * @return
     */
    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }


    /**
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param renderInformacionUsuario
     */
    public void setRenderInformacionUsuario(boolean renderInformacionUsuario) {
        this.renderInformacionUsuario = renderInformacionUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderInformacionUsuario() {
        renderInformacionUsuario = false;
        if (usuario != null && usuario.getHuslnumero() != null) {
            renderInformacionUsuario = true;
        }
        return renderInformacionUsuario;
    }


    /**
     * @param lstDescripcion
     */
    public void setLstDescripcion(List lstDescripcion) {
        this.lstDescripcion = lstDescripcion;
    }

    /**
     * @return
     */
    public List getLstDescripcion() {
        return lstDescripcion;
    }

    /**
     * @param dtDescripcionAclaracion
     */
    public void setDtDescripcionAclaracion(HtmlDataTable dtDescripcionAclaracion) {
        this.dtDescripcionAclaracion = dtDescripcionAclaracion;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtDescripcionAclaracion() {
        return dtDescripcionAclaracion;
    }

    /**
       * @return
       */
      public String aclaracionInformePsicologico() {

          Chconsulta aux = null;
          autoriza = new Chautoinfopsic();
         
          aux = (Chconsulta)dtDescripcionAclaracion.getRowData();
       
          Chautornota autorAux = null;


          datosBasicosUsuario = 
                  (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
          datosBasicosUsuario.setUsuario(usuario);
          datosBasicosUsuario.inicializarUsuario();
          
          Calendar fechafina = Calendar.getInstance();
          fechafina.add(Calendar.DAY_OF_YEAR,3);


          if (aux.getHcolnumero() != null) {
              autoriza.setHaipcoperasolic(userName());
              autoriza.setHaipdfechasolic(new Date());
              autoriza.setHaipnclinica(getClinica().getCclncodigo());
              autoriza.setHaipnnumerconsu(aux.getHcolnumero());
              autoriza.setHaipdfechainici(new Date());
              autoriza.setHaipdfechafinal(fechafina.getTime());
              if(aux.getHcocservicio()!= null){
                  autoriza.setHaipcservicio(aux.getHcocservicio().getCsvccodigo());    
                  autoriza.setHaipcnombserv(aux.getHcocservicio().getCsvcnombre());
              }
              
              if(aux.getHcolusuario() != null ){
                  autoriza.setHaipcnombpaci(aux.getHcolusuario().getHuscprimernomb() +  aux.getHcolusuario().getHuscprimerapel());
                  autoriza.setHaipnnumeiden(aux.getHcolusuario().getHusanumeiden());           
                  autoriza.setHaipctipoiden(aux.getHcolusuario().getHusetipoiden());
                  
              }
              
              autoriza.setHaipdfechaconsu(aux.getHcodfecregistr());
              
              
          }

          try {
              autorAux = 
                      this.serviceLocator.getCirugiaService().getAutorizacionInformePsicologico(autoriza);
          } catch (ModelException e) {
              e.printStackTrace();
          }

          if (autorAux == null) {
              return BeanNavegacion.RUTA_SOLICITAR_INFORME_PSICOLOGICO;
          } else {
              FacesUtils.addErrorMessage(MSG_SOLICITUD_INFORME_PSICOLOGICO_EN_PROCESO);
              return BeanNavegacion.RUTA_ACTUAL;
          }

      }

 
    public void setAutoriza(Chautoinfopsic autoriza) {
        this.autoriza = autoriza;
    }

    public Chautoinfopsic getAutoriza() {
        return autoriza;
    }
}


