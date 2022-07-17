//=======================================================================
// ARCHIVO SolicitarAnulacionBean.java
// FECHA CREACI�N: 26/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la Solicitud de Anulacion de una consulta.
//=======================================================================
package org.profamilia.hc.view.backing.comun.administracion;
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

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chsolicanula;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  CLASE SolicitarAnulacionBean
//=======================================================================
public class SolicitarAnulacionBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Date fechaConsulta;

    private String tipoIdentificacion;

    private HtmlDataTable dtConsultas;

    private Long numeroIdentificacion;

    private Chsolicanula solicitud;

    private Long numeroUsuario;

    private List<SelectItem> listTipoIdentificacion;

    private List<Chconsulta> lstConsultas;

    private Chconsulta consultaSelect;

    private String nombreUsuario;

    private boolean renderBuscador;

    private boolean renderConsultaSeleccionada;

    private int selectedIndex;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    BuscadorUsuariosBean buscador;

    private Chusuario usuario;

    private UIInput itNumeroUsuario; 


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public SolicitarAnulacionBean() {
    }

    public void init() {
        solicitud = new Chsolicanula();
        renderConsultaSeleccionada = false;
    }


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Reporte Jasper
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
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

        }
    }

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public String aceptar() {
        boolean wexito = true;

        if (consultaSelect == null) {
            wexito = false;
            FacesUtils.addErrorMessage(MSG_ADICIONAR_CONSULTA_ANULACION);
        }

        if (solicitud != null && 
            (solicitud.getHsacobsermedic() == null || solicitud.getHsacobsermedic().equals(""))) {
            wexito = false;
            FacesUtils.addErrorMessage("body:gestionSolicitarAnulacion:panelSolicitarAnulacion:itObservaAnulacionConsulta", 
                                       MSG_CAMPO_OBLIGATORIO);

        }

        if (wexito) {
            Chusuario usuarioAux = null;


            try {
                usuarioAux = this.serviceLocator.getClinicoService().getUsuario(consultaSelect.getHcolusuario().getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            solicitud.getId().setHsactiposervi(consultaSelect.getHcoctiposervi());
            solicitud.getId().setHsalconsulta(consultaSelect.getHcolnumero());
            solicitud.setHsacetapa(ETAPA_VIGENTE);
            solicitud.setHsacoperaregis(userName());
            solicitud.setHsadfecharegis(new Date());
            solicitud.setHsanclinica(consultaSelect.getHconclinica());
            if(usuarioAux!= null){
                solicitud.setHsalusuario(usuarioAux);    
            }
            
            solicitud.setHsacservicio(consultaSelect.getHcocservicio());
            
            
            try {
                this.serviceLocator.getClinicoService().saveSolicitudAnulacion(solicitud);
                return BeanNavegacion.RUTA_HOME;
            }
            catch (Exception e) {
                FacesUtils.addErrorMessage("ERROR:  " + e.getMessage());
                return BeanNavegacion.RUTA_ACTUAL;
                
            }
           

        }
        return BeanNavegacion.RUTA_ACTUAL;

    }


    //-----------------------------------------------------------------------
    //  Boton Secundarios
    //-----------------------------------------------------------------------

    public void buscarConsultas() {
        boolean wexito = true;
        lstConsultas = null;
        consultaSelect = null;

        if (numeroUsuario == null) {
            wexito = false;
            FacesUtils.addErrorMessage("body:gestionSolicitarAnulacion:panelSolicitarAnulacion:idtipoAnula", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (fechaConsulta == null) {
            wexito = false;
            FacesUtils.addErrorMessage("body:gestionSolicitarAnulacion:panelSolicitarAnulacion:calendarFechaAnular", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (wexito) {
            consultaSelect = null;
            try {
                lstConsultas = 
                        this.serviceLocator.getClinicoService().getConsultasCerradasProfesional(userName(), 
                                                                                                numeroUsuario, 
                                                                                                fechaConsulta);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (lstConsultas == null || lstConsultas.isEmpty()) {
                FacesUtils.addErrorMessage(MSG_NO_RESULTADO_CONSULTA);
            }
        }

    }

    public void aceptarSolicitud() {
        consultaSelect = (Chconsulta)dtConsultas.getRowData();
    }


    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
    }

    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;
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
        renderBuscador = false;

    }


    //-----------------------------------------------------------------------
    //  ACCESORIOS
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public String volverConsulta() {
        return BeanNavegacion.RUTA_HOME;
    }

    /**
     * @param fechaConsulta
     */
    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    /**
     * @return
     */
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * @param tipoIdentificacion
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * @return
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * @param numeroIdentificacion
     */
    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * @return
     */
    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * @param solicitud
     */
    public void setSolicitud(Chsolicanula solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return
     */
    public Chsolicanula getSolicitud() {
        return solicitud;
    }

    /**
     * @param listTipoIdentificacion
     */
    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
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
     * @param lstConsultas
     */
    public void setLstConsultas(List<Chconsulta> lstConsultas) {
        this.lstConsultas = lstConsultas;
    }

    /**
     * @return
     */
    public List<Chconsulta> getLstConsultas() {
        return lstConsultas;
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
     * @param dtConsultas
     */
    public void setDtConsultas(HtmlDataTable dtConsultas) {
        this.dtConsultas = dtConsultas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultas() {
        return dtConsultas;
    }


    /**
     * @param consultaSelect
     */
    public void setConsultaSelect(Chconsulta consultaSelect) {
        this.consultaSelect = consultaSelect;
    }

    /**
     * @return
     */
    public Chconsulta getConsultaSelect() {
        return consultaSelect;
    }

    /**
     * @param renderConsultaSeleccionada
     */
    public void setRenderConsultaSeleccionada(boolean renderConsultaSeleccionada) {
        this.renderConsultaSeleccionada = renderConsultaSeleccionada;
    }

    /**
     * @return
     */
    public boolean isRenderConsultaSeleccionada() {
        renderConsultaSeleccionada = true;
        if (consultaSelect == null) {
            renderConsultaSeleccionada = false;
        }
        return renderConsultaSeleccionada;
    }


}
