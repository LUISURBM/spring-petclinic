//=======================================================================
// ARCHIVO ListaEspermogramaBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano
// Descripcion: Permite visualizar la lista de usuarios para espermograma
// para un Usuario de una Historia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.clinico.consultorio;

import java.math.BigDecimal;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlogimpresi;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.backing.clinico.consultas.DatosHistoriaBean;
import org.profamilia.hc.view.backing.comun.AplicacionEspermogramaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IConstantes;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
 import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  CLASE ListaEspermogramaBean.java
//=======================================================================
public class ListaEspermogramaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private boolean renderFolio;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;


    private int selectedIndex;
    private boolean renderBuscador;
    /** Almacena true si genero el folio seleccionado */
    private boolean generoHistoria;
    private Chusuario usuario;
    private String nombreUsuario;
    private boolean renderConsulta;
    BuscadorUsuariosBean buscador;
    private Long numeroUsuario;
    private boolean mostrarReporte;
    private HtmlDataTable dtFolios;
    private Cnconsclin consulta;    
    

    private UIInput itNumeroUsuario;
    private boolean renderInformacionUsuario;

    /** Lista que almacena las consultas de un Usuario */
    private List<Cnconsclin> lstFolios;
    /** Lista de sexos */
    private List<SelectItem> listSexos;
    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Fecha presente */
    private Date fechaActual;


    /** Lista de Usuarios */
    private List<Cnconsclin> lstUsuarios;

    /** Almacena el Bean de Datos de Usuario*/
    DatosBasicosUsuarioBean datosUsuario;
    
    /** Almacena true si existen consultas para el dia */
    private boolean existeConsulta;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtConsultas;


    /**Variable que almacena el tipo de servicio de la consulta */
    private Cpservicio servicio;
    
    /** Clone de Consulta */
    private Cnconsclin consultaClone;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena el mensaje si no encuentra registros**/
    private String msg_sin_registros;

    /** Menu de Administracion*/
    private List menuAdmin;

    /** Menu de Historias */

    /** Ruta de Navegaci�n */
    private String rutaNavegacion;

    private AplicacionEspermogramaBean espermogramaBean;
    
    private DatosBasicosUsuarioBean datosBasicosUsuario;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    // ACTIONS BEAN

    public ListaEspermogramaBean() {
    }
    
    public void init(){
        lstUsuarios = new ArrayList<Cnconsclin>();
        msg_sin_registros = IConstantes.MSG_SIN_CONSULTAR;
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        generoHistoria = false;
        renderFolio = false;
        if (usuario == null) {
            usuario = new Chusuario();
        }
        renderConsulta = false;
    }
    
    public void changeConsultas() {
        if (fechaActual != null && getClinica() != null) {
            try {
                this.lstUsuarios = 
                        this.serviceLocator.getClinicoService().getConsultasEspermogramaDia(fechaActual, 
                                                                                getClinica().getCclncodigo(), 
                                                                                getUsuarioSystem().getCurnprofes());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param fechaActual
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Date getFechaActual() {
        return fechaActual;
    }

    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Cnconsclin> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstUsuarios() {
        return lstUsuarios;
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
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }

    /**
     * @param consultaClone
     */
    public void setConsultaClone(Cnconsclin consultaClone) {
        this.consultaClone = consultaClone;
    }

    /**
     * @return
     */
    public Cnconsclin getConsultaClone() {
        return consultaClone;
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
     * @param msg_sin_registros
     */
    public void setMsg_sin_registros(String msg_sin_registros) {
        this.msg_sin_registros = msg_sin_registros;
    }

    /**
     * @return
     */
    public String getMsg_sin_registros() {
        return msg_sin_registros;
    }

    /**
     * @param menuAdmin
     */
    public void setMenuAdmin(List menuAdmin) {
        this.menuAdmin = menuAdmin;
    }

    /**
     * @return
     */
    public List getMenuAdmin() {
        return menuAdmin;
    }

    /**
     * @param rutaNavegacion
     */
    public void setRutaNavegacion(String rutaNavegacion) {
        this.rutaNavegacion = rutaNavegacion;
    }

    /**
     * @return
     */
    public String getRutaNavegacion() {
        return rutaNavegacion;
    }

    /**
     * @param existeConsulta
     */
    public void setExisteConsulta(boolean existeConsulta) {
        this.existeConsulta = existeConsulta;
    }

    /**
     * @return
     */
    public boolean isExisteConsulta() {
        if (lstUsuarios.size() > 0) {
            existeConsulta = true;
        } else {
            existeConsulta = false;
            if (fechaActual != null) {
                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                String fechaCons = sdf.format(fechaActual);
                msg_sin_registros = 
                        IConstantes.NO_EXISTEN_ESPERMOGRAMAS_PARA_LA_FECHA + 
                        fechaCons;
            }
        }
        return existeConsulta;
        }
        
        
    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("mostrarBuscadorUsuarios");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
    }

    /**
     * @return
     */
    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;
        renderFolio = false;
        mostrarReporte = false;
        usuario = new Chusuario();
        nombreUsuario = "";
        lstFolios = new ArrayList<Cnconsclin>();
        renderConsulta = true;

        buscador = (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }
        renderBuscador = false;
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
     * @return
     */
    public String volverConsulta() {
        FacesUtils.resetManagedBean("consultarUsuarioResumenBean");
        FacesUtils.resetManagedBean("listaEspermogramaBean");
        FacesUtils.resetManagedBean("mostrarBuscadorUsuarios");

        renderFolio = false;
        mostrarReporte = false;
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }

    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        renderFolio = false;
        mostrarReporte = false;
        nombreUsuario = "";
        usuario = new Chusuario();
        lstFolios = new ArrayList<Cnconsclin>();
        if (numeroUsuario != null)
            try {
                usuarioAux = this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario =  nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }
            usuario = usuarioAux;
        }
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

    public void setRenderConsulta(boolean renderConsulta) {
        this.renderConsulta = renderConsulta;
    }

    public boolean isRenderConsulta() {
        return renderConsulta;
    }

    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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

    public String SeleccionarEspermograma() {
        BigDecimal numeroFactura = null; 
        
        consulta = null;

        if (dtFolios != null && dtFolios.getRowData() != null) {
            consulta = (Cnconsclin)this.dtFolios.getRowData();
        }

        if(consulta != null && consulta.getCconnumero() != null ){
            try {
                numeroFactura = this.serviceLocator.getClinicoService().getNumeroFactura(consulta.getCconnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        datosBasicosUsuario.setUsuario(usuario);
        datosBasicosUsuario.inicializarUsuario();

        if (consulta != null) {
            FacesUtils.resetManagedBean("aplicacionEspermogramaBean");
            espermogramaBean = 
                    (AplicacionEspermogramaBean)FacesUtils.getManagedBean("aplicacionEspermogramaBean");

            if(espermogramaBean != null && consulta!= null ){
                espermogramaBean = 
                        (AplicacionEspermogramaBean)FacesUtils.getManagedBean("aplicacionEspermogramaBean");
                espermogramaBean.setUsuario(usuario);
                espermogramaBean.setTipoServicio(TIPO_CONSULTA);
                espermogramaBean.setConsulta(consulta);
                espermogramaBean.setNextAction(BeanNavegacion.RUTA_IR_CONTROL_VASECTOMIA);
                espermogramaBean.setMenuBean("menuEspermogramaEnfermeriaBean");
                espermogramaBean.inicalizarAplicacionBean();
                return BeanNavegacion.RUTA_IR_ESPERMOGRAMA;

            }
        }
        return BeanNavegacion.RUTA_ACTUAL;
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

    public void consultarFoliosUsuario() {
        if (usuario != null && usuario.getHuslnumero() != null) {
            lstFolios = new ArrayList<Cnconsclin>();
            try {
                lstFolios = this.getServiceLocator().getClinicoService().getFoliosEspermogramaVasectomia(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstFolios == null || lstFolios.isEmpty()) {
            FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
        }
    }
    
    /**
     * @param lstFolios
     */
    public void setLstFolios(List<Cnconsclin> lstFolios) {
        this.lstFolios = lstFolios;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstFolios() {
        return lstFolios;
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
                listSexoAux = (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
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
                listTipoIdentificacion.add(new SelectItem("", "Seleccione una opci�n ..."));
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


    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }
}
