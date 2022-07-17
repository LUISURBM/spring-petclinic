//=======================================================================
// ARCHIVO ControlSinCostoUsuarioBean.java
// FECHA CREACI�N: 10/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la conducta de control sin
// costo.
//=======================================================================

package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsprogra;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontroladi;
import org.profamilia.hc.model.dto.ChcontroladiPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorControlesBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ControlSinCostoUsuarioBean
//=======================================================================

public class ControlSinCostoUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Variable que almacena la fecha del control */
    private Date fechaControl;

    /** Variable que almacena la hora de la consulta seleccionada*/
    private String horaSelect;

    /** Variable que almacena los minutos de la consulta seleccionada*/
    private String minutoSelect;

    /** Variable que almacena true si ya se genero el control*/
    private boolean generoContol;

    /** Variable que almacena true si  la pagina se muestra en modo de consulta */
    private boolean modoconsulta;

    /** Almacena el indice donde va el reporte*/
    private int index = -1;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHora;

    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutos;

    /** Almacena la consulta que se crea a partir de la facturaci�n */
    private Cnconsclin consultaclinico;
    
    private String codigoCups;
    
    private HtmlDataTable dtControl;
    
    /** Almacena el Control Adicional a persistir */
    //private Chcontroladi controlAdi;
    
    /** Almacena el Control Adicional a persistir */
    private List<Chcontroladi> lstControlAdi;

    Long NUMERO_DOCUMENTO;

    String NOMBRE;

    String CODIGO_CUPS;

    String DIA;

    String MES;

    String ANO;

    String TIPO_DOCUMENTO;
    
    String NOMBRE_PROFESIONAL;
    
    String TIPOID_PROFESIONAL;
    
    BigDecimal NUMID_PROFESIONAL;
   
    
    String REGISTRO_MEDICO = null;
    
    String ESPECIALIDAD = null;
    
    Date FECHA_INICIAL;
    
    //Se ingresan estos campos para cotejarlos con los del Reporte
    
//    String OBSERVACIONES;
//    
//    String HISTORIA;
//    
//    String CONTROL_ADICIONAL;

    private Integer tipoHistoria;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String tipoServicio;

    private String menuBean;

    private Long numeroConsulta;
    
    private List lstServicioDestino;
    
    private boolean renderControl;
    
    static final int ACTIVAR_ORDEN_CONTROLES = 0;
    static final int ACTIVAR_BUSCADOR_CONTROLES = 1;
    
    private List<Cpservicio> lstControles;
    private List<Cpservicio> auxLstServiciosConsulta99;
    private List lstServiciosConsulta99;
    
    private HtmlDataTable dtServicios;

    BuscadorControlesBean buscadorControles;

    private boolean mostrarControles;

    private int selectedIndex;

    private Cpservicio controlServicio;

    private Cpservicio control;
    private String  codigoControlServicio;
    private String observaciones;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ControlSinCostoUsuarioBean() {
    }

    public void init() {
        lstControles = new ArrayList<Cpservicio>();
        controlServicio = new Cpservicio();
        modoconsulta = false;
        renderControl = false; 
        dtControl = new HtmlDataTable();
        inicializarControlSinCosto();
    }

    //ACTIONS    

    public void inicializarControlSinCosto() {

        generoContol = false;
        renderControl = false;
        
        try {
            if (numeroConsulta != null) {
                lstControlAdi = this.serviceLocator.getClinicoService().getControlAdicional(numeroConsulta);
                lstControles = new ArrayList<Cpservicio>();
                if (lstControlAdi !=null && !lstControlAdi.isEmpty()) {
                    List<String> codigosServicios = new ArrayList<String>();
                    for (Chcontroladi controlAdi: lstControlAdi) {
                        String codigo = controlAdi.getComp_id().getHcacservicio().toUpperCase();
                        codigosServicios.add(codigo);
                        
                        Cpservicio servicio = this.serviceLocator.getClinicoService().getServicioPorId(codigo);
                        servicio.setObservaciones(controlAdi.getHcacobserv());
                        servicio.setAgregado(true);
                        servicio.setFechaAgregado(controlAdi.getHcadfecreg());
                        servicio.setOperadorAgregado(controlAdi.getHcacoperador());
                        servicio.setClinicaAgregado(controlAdi.getHcanclinica());
                        servicio.setTipoServicioAgregado(controlAdi.getHcactiposervi());
                        lstControles.add(servicio);
                    }
                    try {
                        consultaclinico = this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstControlAdi == null) {
            lstControlAdi = new ArrayList<Chcontroladi>();
            modoconsulta = false;
        } else {
            if (lstControlAdi != null && !lstControlAdi.isEmpty()) {
                modoconsulta = true;
            }
        }
    }

    public boolean esValido() {
        boolean esValido = false;
        Chconsprogra controlAux = null;
        if (numeroConsulta != null) {
            try {
                controlAux = 
                        this.serviceLocator.getClinicoService().getControl(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (controlAux != null) {
                esValido = true;
            } else {
                esValido = false;
            }

        }
        return esValido;
    }


    public void generarControl() {

        this.index = -1;
        Calendar fechacalendar = Calendar.getInstance();
        if (fechaControl != null && horaSelect != null && 
            minutoSelect != null) {
            Integer hora = new Integer(horaSelect);
            Integer minuto = new Integer(minutoSelect);
            fechacalendar.setTime(fechaControl);
            fechacalendar.set(Calendar.HOUR_OF_DAY, hora);
            fechacalendar.set(Calendar.MINUTE, minuto);
            fechaControl = fechacalendar.getTime();
        }
        
    }
    
    public void printControlSinCosto(){
        try {
            this.index = -1;
            obtenerDatosReporte();
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/Control.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                bytes = 
                        JasperRunManager.runReportToPdf(report, 
                                                        parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                modoconsulta = true;
                generoContol = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    
    public void generarControlAdicional() {
        this.index = -1;
        if (numeroConsulta != null) {
            if (lstControles != null && usuario != null && !lstControles.isEmpty()) {
                for (Cpservicio servicio: lstControles) {
                    Chcontroladi controlAdi = new Chcontroladi();
                    controlAdi.setComp_id(new ChcontroladiPK());
                    controlAdi.getComp_id().setHcalnumero(numeroConsulta);
                    controlAdi.getComp_id().setHcacservicio(servicio.getCsvccodigo());
                    controlAdi.setHcacobserv(servicio.getObservaciones());
                    if (!servicio.isAgregado()) {
                        controlAdi.setHcadfecreg(new Date());
                        controlAdi.setHcacoperador(userName());
                        controlAdi.setHcanclinica(this.getClinica().getCclncodigo());
                        controlAdi.setHcactiposervi(TIPO_CONSULTA);
                    } else {
                        controlAdi.setHcadfecreg(servicio.getFechaAgregado());
                        controlAdi.setHcacoperador(servicio.getOperadorAgregado());
                        controlAdi.setHcanclinica(servicio.getClinicaAgregado());
                        controlAdi.setHcactiposervi(servicio.getTipoServicioAgregado());
                    }
                    lstControlAdi.add(controlAdi);
                }
            }
        }
        if (!lstControlAdi.isEmpty()) {
            try {
                for (Chcontroladi controlAdi: lstControlAdi) {
                    this.getServiceLocator().getClinicoService().saveControlAdicional(controlAdi);
                }
                printControlAdicional();
                FacesUtils.resetManagedBean("buscadorControlesBean");
                //FacesUtils.resetManagedBean("controlSinCostoUsuarioBean");
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
        }
    }
    
    public void printControlAdicional(){
        try {
            this.index = -1;
            obtenerDatosReporte();
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GS-CS-EC-064_V02_01.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, "Documento" 
                        + Calendar.getInstance().getTimeInMillis() +  ".pdf", false);
                modoconsulta = true;
                generoContol = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " +  e.getMessage());
        }
    }

    /**
     * @return
     * @throws JRException
     */
    public boolean next() throws JRException {
        index++;
        return index < lstControles.size();
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
            return value;
        }

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
            return value;
        }
        if (fieldName.equals("CODIGO_CUPS")) {
            value = CODIGO_CUPS;
            return value;
        }

        if (fieldName.equals("DIA")) {
            value = DIA;
            return value;
        }
        if (fieldName.equals("MES")) {
            value = MES;
            return value;
        }
        if (fieldName.equals("ANO")) {
            value = ANO;
            return value;
        }
        if (fieldName.equals("HORA")) {
            value = horaSelect;
            return value;
        }
        if (fieldName.equals("MINUTO")) {
            value = minutoSelect;
            return value;
        }
        
        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("TIPOID_PROFESIONAL")) {
            value = TIPOID_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("NUMID_PROFESIONAL")) {
            value = NUMID_PROFESIONAL;
            return value;
        }
        
        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
            return value;
        }
        
        if (fieldName.equals("ESPECIALIDAD")) {
            value = ESPECIALIDAD;
            return value;
        }
        
        if(fieldName.equals("FECHA_INICIAL")){
            value = FECHA_INICIAL;
            return value;
        }
        
        
        if (fieldName.equals("HISTORIA")) {
            value = /*TIPO_DOCUMENTO + " - " + */ NUMERO_DOCUMENTO.toString();
            return value;
        }
        
        if (fieldName.equals("CONTROL_ADICIONAL")) {
            value = lstControles.get(index).getCsvccodigo() + " - " + 
                    lstControles.get(index).getCsvcnombre();
            return value;
        }
        
        if (fieldName.equals("OBSERVACIONES")) {
            value = lstControles.get(index).getObservaciones();
            return value;
        }

        return null;

    }

    public void obtenerDatosReporte() {
        if (usuario != null) {
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
        }
        
        if (userName() != null) {
            Cpprofesio profesional;
            profesional = null;
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                       getClinica().getCclncodigo());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                TIPOID_PROFESIONAL=profesional.getCpfctipide();
                NUMID_PROFESIONAL=profesional.getCpfacedula();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
            }
        }

        if (fechaControl != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaControl);
            Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
            Integer mesact = calendar.get(Calendar.MONTH) + 1;
            Integer anoact = calendar.get(calendar.YEAR);

            if (diaact.compareTo(10) < 0) {
                DIA = "0" + diaact.toString();
            } else {
                DIA = diaact.toString();
            }

            if (mesact.compareTo(10) < 0) {
                MES = "0" + mesact.toString();
            } else {
                MES = mesact.toString();
            }

            ANO = anoact.toString();

        }
        if(numeroConsulta !=null){
            Chconsulta consulta;
            consulta = null;
            try {
                 consulta = serviceLocator.getClinicoService().getConsultaActual(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(consulta!=null){
            FECHA_INICIAL= consulta.getHcodfecinicio();
            }
            
        }
        
        
    }

    // ACCESSORS

    /**
     * @param fechaControl
     */
    public void setFechaControl(Date fechaControl) {
        this.fechaControl = fechaControl;
    }

    /**
     * @return
     */
    public Date getFechaControl() {
        return fechaControl;
    }

    /**
     * @param horaSelect
     */
    public void setHoraSelect(String horaSelect) {
        this.horaSelect = horaSelect;
    }

    /**
     * @return
     */
    public String getHoraSelect() {
        return horaSelect;
    }

    /**
     * @param minutoSelect
     */
    public void setMinutoSelect(String minutoSelect) {
        this.minutoSelect = minutoSelect;
    }

    /**
     * @return
     */
    public String getMinutoSelect() {
        return minutoSelect;
    }

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
    }

    /**
     * @param generoContol
     */
    public void setGeneroContol(boolean generoContol) {
        this.generoContol = generoContol;
    }

    /**
     * @return
     */
    public boolean isGeneroContol() {
        return generoContol;
    }


    /**
     * @param listHora
     */
    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List<SelectItem> getListHora() {
        if (listHora == null || listHora.isEmpty()) {
            listHora = new ArrayList<SelectItem>();
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem("06", "06"));
            listHora.add(new SelectItem("07", "07"));
            listHora.add(new SelectItem("08", "08"));
            listHora.add(new SelectItem("09", "09"));
            listHora.add(new SelectItem("10", "10"));
            listHora.add(new SelectItem("11", "11"));
            listHora.add(new SelectItem("12", "12"));
            listHora.add(new SelectItem("13", "13"));
            listHora.add(new SelectItem("14", "14"));
            listHora.add(new SelectItem("15", "15"));
            listHora.add(new SelectItem("16", "16"));
            listHora.add(new SelectItem("17", "17"));
            listHora.add(new SelectItem("18", "18"));
            listHora.add(new SelectItem("19", "19"));
            listHora.add(new SelectItem("20", "20"));

        }
        return listHora;
    }

    /**
     * @param lstMinutos
     */
    public void setLstMinutos(List<SelectItem> lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstMinutos() {
        if (lstMinutos == null || lstMinutos.isEmpty()) {
            lstMinutos = new ArrayList<SelectItem>();
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem("00", "00"));
            lstMinutos.add(new SelectItem("05", "05"));
            lstMinutos.add(new SelectItem("10", "10"));
            lstMinutos.add(new SelectItem("15", "15"));
            lstMinutos.add(new SelectItem("20", "20"));
            lstMinutos.add(new SelectItem("25", "25"));
            lstMinutos.add(new SelectItem("30", "30"));
            lstMinutos.add(new SelectItem("35", "35"));
            lstMinutos.add(new SelectItem("40", "40"));
            lstMinutos.add(new SelectItem("45", "45"));
            lstMinutos.add(new SelectItem("50", "50"));
            lstMinutos.add(new SelectItem("55", "55"));
        }
        return lstMinutos;
    }
    
    /**
     * @param consultaclinico
     */
    public void setConsultaclinico(Cnconsclin consultaclinico) {
        this.consultaclinico = consultaclinico;
    }

    /**
     * @return
     */
    public Cnconsclin getConsultaclinico() {
        return consultaclinico;
    }

    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
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
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
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
     * @param lstServicioDestino
     */
    public void setLstServicioDestino(List lstServicioDestino) {
        this.lstServicioDestino = lstServicioDestino;
    }

    /**
     * @return
     */
    public List getLstServicioDestino() {
        return lstServicioDestino;
    }

    /**
     * @param renderControl
     */
    public void setRenderControl(boolean renderControl) {
        this.renderControl = renderControl;
    }

    /**
     * @return
     */
    public boolean isRenderControl() {
        return renderControl;
    }
    
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setMostrarControles(boolean mostrarControles) {
        this.mostrarControles = mostrarControles;
    }

    public boolean isMostrarControles() {
        return mostrarControles;
    }

    public void setLstControles(List<Cpservicio> lstControles) {
        this.lstControles = lstControles;
    }

    public List<Cpservicio> getLstControles() {
        return lstControles;
    }

    public List getLstServiciosConsulta99() {
        if (lstServiciosConsulta99 == null) {
            consultarServiciosTipoConsulta99();
        }
        return lstServiciosConsulta99;
    }

    public void setLstServiciosConulta99(List lstServiciosConulta99) {
        this.lstServiciosConsulta99 = lstServiciosConulta99;
    }

    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void setCodigoCups(String codigoCups) {
        this.codigoCups = codigoCups;
    }

    public String getCodigoCups() {
        return codigoCups;
    }

    public HtmlDataTable getDtControl() {
        return dtControl;
    }

    public void setDtControl(HtmlDataTable dtControl) {
        this.dtControl = dtControl;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------    

    public void consultarControles() {
        FacesUtils.resetManagedBean("buscadorControlesBean");
        BuscadorControlesBean controles;
        controles = 
                (BuscadorControlesBean)FacesUtils.getManagedBean("buscadorControlesBean");
        if (controles != null) {
            controles.init();
            if (usuario != null) {
                controles.getServicio().setCsvcsexo(usuario.getHusesexo());
            }
        }
        selectedIndex = ACTIVAR_BUSCADOR_CONTROLES;
        mostrarControles = true;
    }
    
    public void eliminarControl() {
        Cpservicio servicioSelec;
        servicioSelec = (Cpservicio)dtServicios.getRowData();
        lstControles.remove(servicioSelec);
            
    }
    
    public void findControlServicio() {
       Cpservicio servicio = null;
         try {
         if(controlServicio != null && controlServicio.getCsvccodigo() != null){
            servicio = this.serviceLocator.getClinicoService().getServicioPorId(controlServicio.getCsvccodigo().toUpperCase());      
         }
       
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (servicio != null) {
            controlServicio = servicio;
        } else {
            controlServicio = new Cpservicio();
        }
    }

        
    public void aceptarControlesServicio() {
        for (Cpservicio servicio: auxLstServiciosConsulta99) {
            if (servicio.getCsvccodigo().equals(codigoControlServicio)) {
                servicio.setObservaciones(observaciones);
                lstControles = new ArrayList<Cpservicio>();
                lstControles.add(servicio);
                break;
            }
        }
        
        if (lstControles != null) {
            generarControlAdicional();
            inicializarControlSinCosto();
            mostrarControles = false;
            selectedIndex = ACTIVAR_ORDEN_CONTROLES;
        }
    }


    public void consultarServiciosTipoConsulta99() {
        //99 -> ValoracionesYControles
        //dtServicios.setFirst(0);
        try {
            auxLstServiciosConsulta99
                    = this.serviceLocator.getClinicoService().getServiciosPorTipoConsulta(99L);
            if (auxLstServiciosConsulta99 != null && !auxLstServiciosConsulta99.isEmpty()) {
                lstServiciosConsulta99 = new ArrayList();
                lstServiciosConsulta99.add(new SelectItem("", "Seleccione una opci�n ..."));
                for (Cpservicio servicio : auxLstServiciosConsulta99) {
                    lstServiciosConsulta99.add(new SelectItem(servicio.getCsvccodigo(), servicio.getCsvcnombre()));
                }
                //            while (it.hasNext()) {
                //                it.next();
                //                lstRegiCompAnteriores.add(
                //                    new SelectItem(auxLstRegiCompAnteriores.get(i).getHrclnumero(),
                //                        dateFormat.format(auxLstRegiCompAnteriores.get(i).getHrcdfecreg())
                //                ));
                //                i++;
            }
        }
        catch (ModelException e) {
                e.printStackTrace();
        }
    }
        
    public void aceptarControlesServicio_ANTERIOR() {
        buscadorControles = 
                (BuscadorControlesBean)FacesUtils.getManagedBean("buscadorControlesBean");
        if (buscadorControles != null) {
            lstControles = buscadorControles.getLstControlSelec();
            generarControlAdicional();
            inicializarControlSinCosto();
            mostrarControles = false;
            selectedIndex = ACTIVAR_ORDEN_CONTROLES;
        }
        
    }
        
    public void agregarControlServicio() {
        boolean controlYaGenerado = false;
        for(Cpservicio servicio : lstControles) {
            if(servicio.getCsvccodigo().equals(controlServicio.getCsvccodigo())) {
                controlYaGenerado = true;
                break;
            }
        }
        if (controlServicio != null && ! controlYaGenerado) {
            lstControles.add(controlServicio);
            generarControlAdicional();
            inicializarControlSinCosto();
            controlServicio = new Cpservicio();
        }
    }

    public void setLstControlAdi(List<Chcontroladi> lstControlAdi) {
        this.lstControlAdi = lstControlAdi;
    }

    public List<Chcontroladi> getLstControlAdi() {
        return lstControlAdi;
    }

    public void setControlServicio(Cpservicio controlServicio) {
        this.controlServicio = controlServicio;
    }

    public Cpservicio getControlServicio() {
        return controlServicio;
    }

     /**
      * @param valueChangeEvent
      */
     public void setCsvccodigo(ValueChangeEvent valueChangeEvent) {
         controlServicio.setCsvccodigo((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         findControlServicio();
     }

    public Cpservicio getControl() {
        return control;
    }

    public void setControl(Cpservicio control) {
        this.control = control;
    }

    public String getCodigoControlServicio() {
        return codigoControlServicio;
    }

    public void setCodigoControlServicio(String codigoControlServicio) {
        this.codigoControlServicio = codigoControlServicio;
        //Guardar
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void seleccionarControl() {
        control = (Cpservicio)dtControl.getRowData();
        if (control != null && control.getFechaAgregado() != null) {
            fechaControl = control.getFechaAgregado();
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(fechaControl);
            int hora;
            int minuto;

            hora = fechaaux.get(Calendar.HOUR_OF_DAY);
            minuto = fechaaux.get(Calendar.MINUTE);

            if (hora < 10) {
                horaSelect = "0" + hora;
            } else {
                horaSelect = hora + "";
            }
            if (minuto < 10) {
                minutoSelect = "0" + minuto;
            } else {
                minutoSelect = minuto + "";
            }
        }
        renderControl = true; 
    }
     
     
}

