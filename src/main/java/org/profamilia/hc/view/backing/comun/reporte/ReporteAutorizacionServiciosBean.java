package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoprof;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteAutorizacionServiciosBean extends BaseBean implements JRDataSource {
  
  private Date fechaInicial;
  private Date fechaFinal;
  private int index;
  private List lstClinicas;
  private Integer wcodclin;
  private List<Object[]> lstReporte;
  private boolean generoReporte;
  private Cpempresa empresa;
  private Integer EmprePromilia;
  private boolean generoAutorizacion;
  Cpprofesio profesio;
  String tipprofesio;
  
  BigDecimal CONSECUTIVO;
  String NOMBRE_SOLICITANTE;
  String TIPO_DOCUMENTO_PRESTADOR;
  BigDecimal NIT_SOLICITANTE;
  Integer CODIGO_SOLICITANTE;
  String ENTIDAD_ADMINISTRADORA;
  String APELLIDOS;
  String NOMBRES;
  String TIPO_IDENTI;
  BigDecimal DOCUMENTO_PACIENTE;
  String GENERO_PACIENTE;
  Date FECHA_NACIMIENTO;
  String TELEFONOMOVIL_PACIENTE;
  String TELEFONOFIJO_PACIENTE;
  String CORREO_PACIENTE;
  Date FECHA_ATENCION;
  String ORIGEN_ATENCION;
  String CODIGO_CUPS;
  String DESCRIPCION_SERVICIO;
  BigDecimal CANTIDAD_SERVICIO;
  String PRIORIDAD_ATENCION;
  Date FECHA_SOLICITUD;
  String RECOMENDACIONES;
  String JUSTIFICACION_CLINICA;
  String DIAGNOSTICO_PRINCIPAL;
  String DESCRIPCION_PRINCIPAL; 
  String NOMBRE_PROFESIONAL;
  String CARGO_SOLICITASERV;
  String TIPO_DOCUMENTO;
  String NUMERO_MEDICO;
  String TELEFONO_MEDICO;
  String NOMBRE_PACIENTE;
  String USUARIO_MEDICO;
  
  
  
  public void init(){
      index = -1;
     
      
  }
   
   
   
    public ReporteAutorizacionServiciosBean() {
       
    }
    
    public void iniciaAutorizacion(){
        generoAutorizacion = false;
        EmprePromilia = 1;


        empresa = new Cpempresa();
        try {
            empresa = 
                    this.serviceLocator.getClinicoService().getEmpresa(EmprePromilia);


        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        
      
        
        
    }
    /**
     * @return
     */
    public String volverInicio() {
        FacesUtils.resetManagedBean("reporteAutorizacionServiciosBean");
        return "home";
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (lstReporte != null)
            return index < lstReporte.size();
        else
            return false;

    }
  

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setLstClinicas(List lstClinicas) {
        this.lstClinicas = lstClinicas;
    }

    public List getLstClinicas() {
        if (lstClinicas == null || lstClinicas.isEmpty()) {
            lstClinicas = new ArrayList();
            ArrayList<Cpclinica> lstClinicaAux = null;
            try {
                lstClinicaAux = 
                        (ArrayList<Cpclinica>)this.serviceLocator.getClinicoService().getClinicas();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstClinicaAux.isEmpty()) {

                Iterator it = lstClinicaAux.iterator();
                int i = 0;
                lstClinicas.add(new SelectItem(0, "Todas las Clinicas"));
                while (it.hasNext()) {
                    it.next();
                    lstClinicas.add(new SelectItem(lstClinicaAux.get(i).getCclncodigo(), 
                                                   lstClinicaAux.get(i).getCclcnombre()));
                    i++;
                }
            }
        }
    
    
    
        return lstClinicas;
    }


   


    public void setWcodclin(Integer wcodclin) {
        this.wcodclin = wcodclin;
    }

    public Integer getWcodclin() {
        return wcodclin;
   
   
    }
   
   public void resetDatos(){
       NOMBRE_SOLICITANTE = null;
       TIPO_DOCUMENTO_PRESTADOR = null;
       NIT_SOLICITANTE = null;
       CODIGO_SOLICITANTE = null;
       ENTIDAD_ADMINISTRADORA = null;
       APELLIDOS = null;
        NOMBRES = null;
        TIPO_IDENTI = null;
        DOCUMENTO_PACIENTE = null;
        GENERO_PACIENTE = null;
        FECHA_NACIMIENTO = null;
        TELEFONOMOVIL_PACIENTE = null;
        TELEFONOFIJO_PACIENTE = null;
        CORREO_PACIENTE = null;
        FECHA_ATENCION = null;
        ORIGEN_ATENCION = null;
        CODIGO_CUPS = null;
        DESCRIPCION_SERVICIO = null;
        CANTIDAD_SERVICIO = null;
        PRIORIDAD_ATENCION = null;
        FECHA_SOLICITUD = null;
        RECOMENDACIONES = null;
        JUSTIFICACION_CLINICA = null;
        DIAGNOSTICO_PRINCIPAL = null;
        DESCRIPCION_PRINCIPAL = null; 
        NOMBRE_PROFESIONAL = null;
        CARGO_SOLICITASERV = null;
        TIPO_DOCUMENTO = null;
        NUMERO_MEDICO = null;
        TELEFONO_MEDICO = null;
       CONSECUTIVO = new BigDecimal(0);
   }
   
   
   
   
   
       /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        Object value = null;
        Object[] autoriaux = null;
        if(index < lstReporte.size()){
            autoriaux = lstReporte.get(index);    
        }
        
        resetDatos();
        obtenerDatos(autoriaux);

        String fieldName = jrField.getName();
        if (fieldName.equals("CONSECUTIVO"))
            value = CONSECUTIVO;
        else if (fieldName.equals("NOMBRE_SOLICITANTE"))
            value = NOMBRE_SOLICITANTE;
        else if (fieldName.equals("NIT_SOLICITANTE"))
            value = NIT_SOLICITANTE;
        else if (fieldName.equals("CODIGO_SOLICITANTE"))
            value = CODIGO_SOLICITANTE;
        else if (fieldName.equals("ENTIDAD_ADMINISTRADORA"))
            value = ENTIDAD_ADMINISTRADORA;
        else if (fieldName.equals("NOMBRE_PACIENTE"))
            value = NOMBRE_PACIENTE;
        else if (fieldName.equals("TIPO_IDENTI"))
            value = TIPO_IDENTI;
        else if (fieldName.equals("DOCUMENTO_PACIENTE"))
            value = DOCUMENTO_PACIENTE;
        else if (fieldName.equals("GENERO_PACIENTE"))
            value = GENERO_PACIENTE;
        else if (fieldName.equals("FECHA_NACIMIENTO"))
            value = FECHA_NACIMIENTO;
        else if (fieldName.equals("TELEFONOMOVIL_PACIENTE"))
            value = TELEFONOMOVIL_PACIENTE;
        else if (fieldName.equals("TELEFONOFIJO_PACIENTE"))
            value = TELEFONOFIJO_PACIENTE;
        else if (fieldName.equals("CORREO_PACIENTE"))
            value = CORREO_PACIENTE;
        else if (fieldName.equals("FECHA_ATENCION"))
            value = FECHA_ATENCION;
        else if (fieldName.equals("ORIGEN_ATENCION"))
            value = ORIGEN_ATENCION;
        else if (fieldName.equals("CODIGO_CUPS"))
            value = CODIGO_CUPS;
        else if (fieldName.equals("DESCRIPCION_SERVICIO"))
            value = DESCRIPCION_SERVICIO;
        else if (fieldName.equals("CANTIDAD_SERVICIO"))
            value = CANTIDAD_SERVICIO;
        else if (fieldName.equals("PRIORIDAD_ATENCION"))
            value = PRIORIDAD_ATENCION;
        else if (fieldName.equals("FECHA_SOLICITUD"))
            value = FECHA_SOLICITUD;
        else if (fieldName.equals("RECOMENDACIONES"))
            value = RECOMENDACIONES;
        else if(fieldName.equals("JUSTIFICACION_CLINICA"))
            value = JUSTIFICACION_CLINICA;
        else if(fieldName.equals("DIAGNOSTICO_PRINCIPAL"))
            value = DIAGNOSTICO_PRINCIPAL;
        else if(fieldName.equals("DESCRIPCION_PRINCIPAL"))
            value = DESCRIPCION_PRINCIPAL;
        else if(fieldName.equals("NOMBRE_PROFESIONAL"))
            value = NOMBRE_PROFESIONAL;
        else if(fieldName.equals("CARGO_SOLICITASERV"))
            value = CARGO_SOLICITASERV;
        else if(fieldName.equals("TIPO_DOCUMENTO"))    
            value = TIPO_DOCUMENTO;
        else if(fieldName.equals("NUMERO_MEDICO"))
            value = NUMERO_MEDICO;
        else if(fieldName.equals("TELEFONO_MEDICO"))
            value = TELEFONO_MEDICO;
        else if(fieldName.equals("TIPO_DOCUMENTO_PRESTADOR"))
            value = TIPO_DOCUMENTO_PRESTADOR;



        return value;
    }

    public void obtenerDatos(Object[] autoriaux){
    
        if (empresa != null) {
            if (empresa.getCemcnombre() != null) {
                NOMBRE_SOLICITANTE = empresa.getCemcnombre();
            }

            if (empresa.getCemanit() != null) {
                NIT_SOLICITANTE = empresa.getCemanit();
            }

        }
        TIPO_DOCUMENTO_PRESTADOR = "NIT";
        USUARIO_MEDICO = formatearCampo((String)autoriaux[21]);
        
        try{
            profesio = 
                    this.serviceLocator.getClinicoService().getProfesionalPorUsuario(USUARIO_MEDICO, wcodclin);
        }catch(ModelException e){
            e.printStackTrace();
        }
        
        
        if(profesio != null){
            if(profesio.getCpfcnombre() != null){
                NOMBRE_PROFESIONAL = profesio.getCpfcnombre();
            }
            if(profesio.getCpfcregmedic() != null){
                NUMERO_MEDICO = profesio.getCpfcregmedic();
            }
            
            if(profesio.getCpfntippro() != null){
                try {
                    tipprofesio =
                            this.serviceLocator.getClinicoService().getDescripcionTipoProfesional(profesio.getCpfntippro());
                }catch(ModelException e){
                    e.printStackTrace();
                }
                
                CARGO_SOLICITASERV = tipprofesio;
            }
       
        }
       
    
      if(autoriaux != null){
          CONSECUTIVO = (BigDecimal)autoriaux[0];  
          ENTIDAD_ADMINISTRADORA = formatearCampo((String)autoriaux[1]);
          NOMBRE_PACIENTE = formatearCampo((String)autoriaux[2]);
          TIPO_IDENTI = formatearCampo((String)autoriaux[3]);
          DOCUMENTO_PACIENTE = (BigDecimal)autoriaux[4];
          GENERO_PACIENTE = formatearCampo((String)autoriaux[5]);
          FECHA_NACIMIENTO = (Date)autoriaux[6];
          TELEFONOMOVIL_PACIENTE = formatearCampo((String)autoriaux[7]);
          TELEFONOFIJO_PACIENTE = formatearCampo((String)autoriaux[8]);
          CORREO_PACIENTE = formatearCampo((String)autoriaux[9]);
          FECHA_ATENCION = (Date)autoriaux[10];
          ORIGEN_ATENCION = formatearCampo((String)autoriaux[11]);
          CODIGO_CUPS = formatearCampo((String)autoriaux[12]);
          DESCRIPCION_SERVICIO = formatearCampo((String)autoriaux[13]);
          CANTIDAD_SERVICIO = (BigDecimal)autoriaux[14];
          PRIORIDAD_ATENCION = (String)autoriaux[15];
          FECHA_SOLICITUD = (Date)autoriaux[16];
          RECOMENDACIONES = (String)autoriaux[17];
          JUSTIFICACION_CLINICA = (String)autoriaux[18];
          DIAGNOSTICO_PRINCIPAL = (String)autoriaux[19];
          DESCRIPCION_PRINCIPAL = (String)autoriaux[20];
          
          }
    }
    
    
    public void generarAutorizacion() {
        iniciaAutorizacion();

        index = -1;
        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getReporteAutorizacionServicios(wcodclin, 
                                                                                  fechaInicial, 
                                                                                  fechaFinal);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstReporte == null || lstReporte.isEmpty()) {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADO_CONSULTA);
            generoReporte = false;
        } else {
        

            try {

                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteAutorizacionServicios.jasper");

    
                if (url != null) {

                    Map parameters = new HashMap();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    JasperPrint jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRXlsExporter exporter = new JRXlsExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                          jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, 
                                          baos);
                    exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, 
                                          Boolean.FALSE);
                    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, 
                                          Boolean.TRUE);
                    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, 
                                          Boolean.FALSE);

                    exporter.exportReport();
                    XlsServletUtils.showXlsDocument(baos.toByteArray(), 
                                                    "Autorizacion_Servicios" + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                    generoReporte = true;


                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el reporte " + 
                                           e.getMessage());
            }


        }
    }


    public void setEmpresa(Cpempresa empresa) {
        this.empresa = empresa;
    }

    public Cpempresa getEmpresa() {
        return empresa;
    }

    public void setEmprePromilia(Integer emprePromilia) {
        this.EmprePromilia = emprePromilia;
    }

    public Integer getEmprePromilia() {
        return EmprePromilia;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }
}
