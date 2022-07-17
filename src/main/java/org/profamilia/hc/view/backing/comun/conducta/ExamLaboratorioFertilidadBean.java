//=======================================================================
// ARCHIVO ExamLaboratorioUsuarioBean.java
// FECHA CREACI�N: 02/08/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al examen de laboratorio.
//=======================================================================

package org.profamilia.hc.view.backing.comun.conducta;

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

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//==============================================================================
//  CLASE ExamLaboratorioUsuarioBean
//==============================================================================

public class ExamLaboratorioFertilidadBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private int index = -1;

    private boolean generoDocPDF;

    private boolean modoConsulta;

    private String descripcionRemision;

    private List lstExamenesLaboratorios;

    private HtmlDataTable dtServicios;

    /** Lista que almacena las remisiones que se le ordenaron al usuario */
    private List<Chexamelabor> lstRemision;
    
    /** Lista que almacena las remisiones que se le ordenaron al usuario */
    private List<Chexamelabor> lstRemisionEnfermedadesIniciales;

    /** Almacena la tabla de las remisiones  */
    private HtmlDataTable dtRemision;
    
    
    /** Almacena la tabla de las remisiones  */
    private HtmlDataTable dtRemisionEnfermedadesIniciales;
    

    /** Almacena la remision a eliminar del data table  */
    private Chexamelabor remisionClon;

    /** Variable que almacena el laboratorio que se desea buscar */
    private Cpservicio servicio;

    private Integer tipoHistoria;

    private boolean esCirugia;

    private String tipoServicio;

    private Integer consecutivo;

    private Chimprdiag impresionDiagnostica;

    String NOMBRES;

    String PRIMER_APELLIDO;

    String SEGUNDO_APELLIDO;

    String TIPO_DOCUMENTO;

    Long NUMERO_DOCUMENTO;

    String DIAGNOSTICO_PRINCIPAL;

    String DIAGNOSTICO_SECUNDARIO;

    String CODIGO_CIE10;

    String TIPO_USUARIO;

    String ANO;

    String MES;

    String DIA;

    Integer EDAD;
    
    String NOMBRE_PROFESIONAL;
    
    String REGISTRO_MEDICO; 

    Date fecha;

    String CODIGO_CIE10_PRINCIPAL;

    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private String cie10Principal;
    
    private boolean renderEnfermedadesIniciales; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------    

    public ExamLaboratorioFertilidadBean() {
    }

    //ACTIONS 

    public void init() {

        generoDocPDF = false;
        modoConsulta = false;
        servicio = new Cpservicio();
        lstExamenesLaboratorios = new ArrayList();
        inicializarExamLaboratorio();
        inicializarEnfermedadesIniciales();
    }

    public void inicializarExamLaboratorio() {
        generoDocPDF = false;
        try {
            lstRemision = 
                    this.serviceLocator.getClinicoService().getExamenesLaboratorios(numeroConsulta, 
                                                                                    tipoServicio, 
                                                                                    consecutivo);

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstRemision == null || lstRemision.isEmpty()) {
            modoConsulta = false;
            lstRemision = new ArrayList<Chexamelabor>();
        } else {
            descripcionRemision = (lstRemision.get(0)).getHelcobservacio();
            modoConsulta = true;
        }

    }


    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //--------------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        List<Chexamelabor> lstRemisionAux = null;
        if (numeroConsulta != null) {
            try {
                lstRemisionAux = 
                        this.serviceLocator.getClinicoService().getExamenesLaboratoriosConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstRemisionAux == null || lstRemisionAux.isEmpty()) {
                esValido = false;
            } else {
                esValido = true;
            }
        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------    

    public void agregarRemision() {
        Chexamelabor remision;
        Cpservicio servicioSelect = null;
        Cpservicio servicioObject = null;
        if (dtServicios != null) {
            servicioSelect = (Cpservicio)this.dtServicios.getRowData();


            try {
                if (servicioSelect != null && 
                    servicioSelect.getCsvccodigo() != null) {
                    servicioObject = 
                            this.serviceLocator.getClinicoService().getServicioPorId(servicioSelect.getCsvccodigo());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        remision = new Chexamelabor();
        if (servicioObject != null) {

            remision.setCpservicio(servicioObject);
            remision.setHeldfecregistr(new Date());
            remision.setHelcoperador(userName());

            lstRemision.add(remision);
            servicio = new Cpservicio();

        } else {
            FacesUtils.addErrorMessage("Debe Registrar todos los datos");
        }

        
    }

    public void eliminarRemision() {
        this.remisionClon = (Chexamelabor)this.dtRemision.getRowData();
        this.lstRemision.remove(remisionClon);
        FacesUtils.addInfoMessage(IMsg.MSG_ELIMINACION);
    }
    
    
    public void adicionarRemisionEnfermedadesIniciales() {
        this.remisionClon = (Chexamelabor)this.dtRemisionEnfermedadesIniciales.getRowData();
        this.lstRemisionEnfermedadesIniciales.remove(remisionClon);
        lstRemision.add(remisionClon);
        FacesUtils.addInfoMessage(IMsg.MSG_ELIMINACION);
    }
    


    public void consultarLaboratorios() {
        dtServicios.setFirst(0);
        try {
            lstExamenesLaboratorios = 
                    this.serviceLocator.getClinicoService().getExamenesLaboratorioFertilidadPorCriterios(servicio);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
    
    public void inicializarEnfermedadesIniciales(){
        lstRemisionEnfermedadesIniciales = new ArrayList<Chexamelabor>();
        Cpservicio servAux = null;
        Chexamelabor examAux = new Chexamelabor();
        examAux.setModoconsulta(false);
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906916");
        
        if(servAux != null){
            examAux.setCpservicio(servAux);
            lstRemisionEnfermedadesIniciales.add(examAux);    
        }


        servAux = null;
        examAux = new Chexamelabor();
        examAux.setModoconsulta(false);
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");

        servAux = getServicioXCodigo("S906249");

        if(servAux != null){
                    examAux.setCpservicio(servAux);
                    lstRemisionEnfermedadesIniciales.add(examAux);    
                }
                
        servAux = null;  
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906225");
        
        if(servAux != null){
            examAux.setCpservicio(servAux);
            lstRemisionEnfermedadesIniciales.add(examAux);    
        }
        
   
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906127");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906317");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906206");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906215");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S906020");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S904105");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S904107");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S904503");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S904902");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        servAux = null;
        examAux = new Chexamelabor();
        examAux.setHeldfecregistr(new Date());
        examAux.setHelcoperador(userName());
        examAux.setHelcobservacio(" ");
        
        servAux = getServicioXCodigo("S904108");
        
        if(servAux != null){
        examAux.setCpservicio(servAux);
        lstRemisionEnfermedadesIniciales.add(examAux);
        }
        
        
        
    }
    
    
    
    public Cpservicio getServicioXCodigo(String wcodser){
        Cpservicio  servicioSelect = null;
    
        if (wcodser != null) {
            try {
                
                    servicioSelect = 
                            this.serviceLocator.getClinicoService().getServicioPorId(wcodser);
                

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        return servicioSelect;
    }
    

    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("APELLIDO1")) {
            value = PRIMER_APELLIDO;
            return value;
        }

        if (fieldName.equals("APELLIDO2")) {
            value = SEGUNDO_APELLIDO;
            return value;
        }
        if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
            return value;
        }
        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
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
        if (fieldName.equals("TIPO_REMISION")) {
            value = lstRemision.get(index).getCpservicio().getCsvcnombre();
            return value;
        }

        if (fieldName.equals("DESCRIPCION_REMISION")) {
            value = descripcionRemision;
            return value;
        }

        if (fieldName.equals("EDAD")) {
            value = EDAD;
            return value;
        }
        if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
            value = DIAGNOSTICO_PRINCIPAL;
            return value;
        }

        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
            return value;
        }

        return null;

    }

    public boolean next() throws JRException {
        index++;
        return (index < lstRemision.size());
    }


    public void obtenerDatosReporteConsulta() {
        if (usuario != null) {

            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

            }

            if (cie10Principal != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = cie10Principal.toUpperCase();
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = 
                            CODIGO_CIE10_PRINCIPAL + " " + diagprin.getCdccdescri();
                }
            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHusetipoafilia() != null) {

                if (usuario.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuario.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuario.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuario.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuario.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuario.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }


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
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
            }
        }


        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
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


    public void obtenerDatosReporteCirugia() {

        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario != null) {
            usuarioAux = usuario;

        }

        if (usuarioAux != null) {

            if (usuarioAux.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuarioAux.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

            }
            if (impresionDiagnostica != null && 
                impresionDiagnostica.getHidcdiagprin() != null) {
                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = 
                        impresionDiagnostica.getHidcdiagprin().toUpperCase();

                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = 
                            CODIGO_CIE10_PRINCIPAL + " " + diagprin.getCdccdescri();
                }
            }

            if (usuarioAux.getHuscprimernomb() != null) {
                NOMBRES = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuarioAux.getHuscsegundnomb();
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuarioAux.getHuscsegundapel();
            }
            if (usuarioAux.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuarioAux.getHusetipoiden().toString();
            }
            if (usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }
            if (usuarioAux.getHusetipoafilia() != null) {

                if (usuarioAux.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuarioAux.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuarioAux.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuarioAux.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuarioAux.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuarioAux.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }


            }

        }


        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
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


    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------

    public void generarRemision() {
        this.index = -1;
        this.index = -1;

        if (lstRemision.size() != 0) {


            try {
                this.serviceLocator.getClinicoService().saveListExamenesLaboratorioCirugia(lstRemision, 
                                                                                           numeroConsulta, 
                                                                                           tipoServicio, 
                                                                                           consecutivo, 
                                                                                           descripcionRemision);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
            }
            try {
                if (!esCirugia) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }

                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/RemisionFertilidad.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_FERTILIDAD);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                   url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);
                    modoConsulta = true;
                    generoDocPDF = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }

        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_EXISTEN_EXAMENES);
        }

    }

    // ACCESSORS

    /**
     * @param generoDocPDF
     */
    public void setGeneroDocPDF(boolean generoDocPDF) {
        this.generoDocPDF = generoDocPDF;
    }

    /**
     * @return
     */
    public boolean isGeneroDocPDF() {
        return generoDocPDF;
    }


    /**
     * @param modoConsulta
     */
    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    /**
     * @return
     */
    public boolean isModoConsulta() {
        return modoConsulta;
    }

    /**
     * @param lstExamenesLaboratorios
     */
    public void setLstExamenesLaboratorios(List lstExamenesLaboratorios) {
        this.lstExamenesLaboratorios = lstExamenesLaboratorios;
    }

    /**
     * @return
     */
    public List getLstExamenesLaboratorios() {
        return lstExamenesLaboratorios;
    }

    /**
     * @param descripcionRemision
     */
    public void setDescripcionRemision(String descripcionRemision) {
        this.descripcionRemision = descripcionRemision;
    }

    /**
     * @return
     */
    public String getDescripcionRemision() {
        return descripcionRemision;
    }

    /**
     * @param lstRemision
     */
    public void setLstRemision(List<Chexamelabor> lstRemision) {
        this.lstRemision = lstRemision;
    }

    /**
     * @return
     */
    public List<Chexamelabor> getLstRemision() {
        return lstRemision;
    }

    /**
     * @param dtRemision
     */
    public void setDtRemision(HtmlDataTable dtRemision) {
        this.dtRemision = dtRemision;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtRemision() {
        return dtRemision;
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
     * @param esCirugia
     */
    public void setEsCirugia(boolean esCirugia) {
        this.esCirugia = esCirugia;
    }

    /**
     * @return
     */
    public boolean isEsCirugia() {
        return esCirugia;
    }

    /**
     * @param dtServicios
     */
    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtServicios() {
        return dtServicios;
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
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param impresionDiagnostica
     */
    public void setImpresionDiagnostica(Chimprdiag impresionDiagnostica) {
        this.impresionDiagnostica = impresionDiagnostica;
    }

    /**
     * @return
     */
    public Chimprdiag getImpresionDiagnostica() {
        return impresionDiagnostica;
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
     * @param cie10Principal
     */
    public void setCie10Principal(String cie10Principal) {
        this.cie10Principal = cie10Principal;
    }

    /**
     * @return
     */
    public String getCie10Principal() {
        return cie10Principal;
    }

    public void setRenderEnfermedadesIniciales(boolean renderEnfermedadesIniciales) {
        this.renderEnfermedadesIniciales = renderEnfermedadesIniciales;
    }

    public boolean isRenderEnfermedadesIniciales() {
        return renderEnfermedadesIniciales;
    }

    public void setRenderEnfermedadesIniciales(ValueChangeEvent valueChangeEvent) {
        setRenderEnfermedadesIniciales((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setLstRemisionEnfermedadesIniciales(List<Chexamelabor> lstRemisionEnfermedadesIniciales) {
        this.lstRemisionEnfermedadesIniciales = lstRemisionEnfermedadesIniciales;
    }

    public List<Chexamelabor> getLstRemisionEnfermedadesIniciales() {
        return lstRemisionEnfermedadesIniciales;
    }

    public void setDtRemisionEnfermedadesIniciales(HtmlDataTable dtRemisionEnfermedadesIniciales) {
        this.dtRemisionEnfermedadesIniciales = dtRemisionEnfermedadesIniciales;
    }

    public HtmlDataTable getDtRemisionEnfermedadesIniciales() {
        return dtRemisionEnfermedadesIniciales;
    }
}
