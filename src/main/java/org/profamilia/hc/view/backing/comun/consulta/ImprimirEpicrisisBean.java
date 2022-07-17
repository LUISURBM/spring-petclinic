package org.profamilia.hc.view.backing.comun.consulta;

import java.io.File;

import java.math.BigDecimal;

import java.net.URL;


import java.sql.Time;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdescrquiru;
import org.profamilia.hc.model.dto.Chepicrisi;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cningrilve;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;

public class ImprimirEpicrisisBean extends BaseBean implements JRDataSource {

    private boolean generoReporte;
    
    private int index;

    /** Lista con los detalles de la rendici�n de gastos de viaje */
    private List datos;

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

    private List<Object[]> lstDescDetalle; // QUITAR
    
    private List<Chepicrisi> lstEpicrisis;

    
    private Cpprofesio cirujano;

    private HtmlDataTable dtEpicrisis;


    public ImprimirEpicrisisBean() {        
    }

    public void init() {
        index = -1;

        sbuffer = new StringBuffer();
        lstFolios = new ArrayList<Chconsulta>();

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();

        if (usuario == null) {
            usuario = new Chusuario();
        }


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


    public void consultarRegistros(){
        try {
        if(numeroUsuario != null){
            lstEpicrisis = this.serviceLocator.getCirugiaService().getLstEpicrisisByUser(numeroUsuario);
        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    /**
     * @return
     */
    public String volverConsulta() {
        FacesUtils.resetManagedBean("solicitarAutorizacionRegistrosBean");
        return BeanNavegacion.RUTA_IR_INICIO;
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
        renderBuscador = false;

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



        
    public String generar(){   
        index  = -1;
        Chepicrisi epicrisis = (Chepicrisi)dtEpicrisis.getRowData();    
        String ServicioIgr = "";
        String ServicioEgr = "";
        String[] serIngreso = null;
        String[] serEgreso = null; 
        Crdgncie10 diagpresu = null;

        //Obtiene el encabezado de la descripcion
        //descripcion = this.serviceLocator.getCirugiaService().getDescripcionQuirurgica(((BigDecimal)detalleDesc[0]).longValue());              
        //Obtiene informacion de cirujano
        
         
        
        if(epicrisis.getHepcserviingre()!=null)
            serIngreso =  epicrisis.getHepcserviingre().split(",");
            
        if(epicrisis.getHepcserviegres()!=null)
            serEgreso =  epicrisis.getHepcserviingre().split(",");
       
        try {  
        
            //Arma el String con los servicios de ingreso
            for(String ser: serIngreso){                
                if(ser != null && !ser.equals("")){
                    Cpservicio aux = this.serviceLocator.getClinicoService().getServicioPorId(ser); 
                
                    ServicioIgr += aux.getCsvcnombre()+", ";
                }
            }
            
            if(ServicioIgr.length() > 2)
                ServicioIgr = ServicioIgr.substring(0,ServicioIgr.length() - 2);
            
            //Arma el String con los servicios de Egresos
            for(String ser: serEgreso){                
                if(ser != null && !ser.equals("")){
                    Cpservicio aux = this.serviceLocator.getClinicoService().getServicioPorId(ser);                 
                    ServicioEgr += aux.getCsvcnombre()+", ";
                }
            }
            
            if(ServicioEgr.length() > 2)
                ServicioEgr = ServicioEgr.substring(0,ServicioEgr.length() - 2);
                
                
            diagpresu =  this.serviceLocator.getClinicoService().getCIE10PorCodigo(epicrisis.getHepcdiagingnpresu().toUpperCase());
            
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
     
        File reportFile = new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/DescripcionEpicrisis.jasper"));

            if (reportFile.exists()) {            
                Map parameters = new HashMap();
                byte[] bytes = null;
                try {       
                    URL imagen =  FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                    parameters.put("IMAGEN", imagen);
                    parameters.put("NO_HISTORIA", usuario.getHusanumeiden().toString());
                    parameters.put("PER_APELLIDO",usuario.getHuscprimerapel());
                    parameters.put("SDO_APELLIDO",usuario.getHuscsegundapel());
                    parameters.put("NOMBRES",usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb());
                    parameters.put("EDAD",calcularEdad(usuario.getHusdfechanacim(), epicrisis.getHepdfecregistr()));
                    parameters.put("SEXO",usuario.getHusesexo());
                    parameters.put("CAMA_NO","N/A");
                    parameters.put("TIPO_USUARIO","N/A");
                    parameters.put("FECHA_ING",epicrisis.getHepdfechaingre());
                    parameters.put("FECHA_EGR",epicrisis.getHepdfechaegres());
                    parameters.put("HORA_EGRESO",epicrisis.getHepdfechaegres());
                    parameters.put("NO_HORAS",calculaHorasDiferencia(epicrisis.getHepdfechaingre(), epicrisis.getHepdfechaegres()));
                    parameters.put("SERVICIO_ING", ServicioIgr);//
                    parameters.put("SERVICIO_EGR", ServicioEgr);//
                    parameters.put("MOTIVO",epicrisis.getHepcmotivocons());
                    parameters.put("ESTADO_INGRESO",epicrisis.getHepcestaingres());
                    parameters.put("ENFERMEDAD_ACTUAL",epicrisis.getHepcenfeactual());
                    parameters.put("ANTECEDENTES",epicrisis.getHepcantecedent());
                    parameters.put("RXS",epicrisis.getHepcrevisistem());
                    parameters.put("HALLAZGOS",epicrisis.getHepchallaexafi());
                    parameters.put("DIAGNOSTICO",diagpresu.getCdccdescri());
                    parameters.put("CONDUCTA",epicrisis.getHepcconducta());
                    parameters.put("EVOLUCION",epicrisis.getHepcevolucion());
                    parameters.put("EXAMEN",epicrisis.getHepcexamapoyo());
                    parameters.put("CONDICIONES_PACIENTE",epicrisis.getHepccondegres());                    
                    
                    bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, (JRDataSource)this);                    
                    PdfServletUtils.showPdfDocument(bytes,"DescripcionQuirurgica.pdf", false);                    
                    setGeneroReporte(true);    
                    
                    
                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar Reporte Descripcion Quirurgica. " + 
                                               ex.getMessage());
                    setGeneroReporte(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar reporte Descripcion Quirurgica. " + 
                                               ex.getMessage());
                    setGeneroReporte(false);    
                }
            }
        
        return null;
    }

    public void setData(List datos) {
        this.datos = datos;
    }

    public List getData() {
        return datos;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
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
     * @param lstDescripcion
     */
    public void setLstDescDetalle(List lstDescripcion) {
        this.lstDescDetalle = lstDescripcion;
    }

    /**
     * @return
     */
    public List getLstDescDetalle() {
        return lstDescDetalle;
    }

    /**
     * @param dtEpicrisis
     */
    public void setDtEpicrisis(HtmlDataTable dtEpicrisis) {
        this.dtEpicrisis = dtEpicrisis;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtEpicrisis() {
        return dtEpicrisis;
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
    

    public boolean next() {
        index++;
        System.out.println("********************* Index " + index);
        return (index < 1);
    }

    public Object getFieldValue(JRField jrField) {
        return null;
    }


    public void setLstEpicrisis(List<Chepicrisi> lstEpicrisis) {
        this.lstEpicrisis = lstEpicrisis;
    }

    public List<Chepicrisi> getLstEpicrisis() {
        return lstEpicrisis;
    }
}
