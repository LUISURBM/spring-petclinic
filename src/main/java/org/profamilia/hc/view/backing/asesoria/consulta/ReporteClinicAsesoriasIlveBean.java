package org.profamilia.hc.view.backing.asesoria.consulta;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.*;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;

public class ReporteClinicAsesoriasIlveBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstClinicas;
    private Integer wcodclin;
    private List<Object[]> lstReporte;

    Date FECHA_ASESORIA;
    BigDecimal CLINICA;
    BigDecimal NUMERO_IDENTIFICACION;
    BigDecimal EDAD;
    String TELEFONO; 
    String CELULAR; 
    
    String CLASE_REMISION; 
    String USUARIO_REGISTRO;
    String LOGIN_REGISTRO;
    String OTRA_REMISION_;
    BigDecimal NUMERO_EDAD_GESTACIONAL;
    String NOMBRE_USUARIO;
   String MOTIVO_CONOCIMIENTO_PROGRAMA;
    String INTERVENCION_ASESORIA;
    String TIPO_INTERVENCION;
    String OTRA_REMISION;
    String INDECISION;
    String CAPACIDAD_PAGO_LIMITADA;
    String VA_USAR_EPS;
    String VA_USAR_OTRA_IPS;
    String NO_APLICA_CAUSAL;
    String REMISION_POR_EDAD_GESTACIONAL;
    String DESEA_CONTINUAR_EMBARAZO;
    String OPTA_ILVE;
    String APLAZA_DECISION;
 
    BigDecimal NUMERO_SEGUI;
    Date FECHA_SEGUI;
    BigDecimal NUMERO_EDAD_GES_SEGUI;
    String MOTIVO_APLAZA_DECI_SEGUI; 
    String  OTRA_CONDUCTA_SEGUI;
    String  OTRA_REMISION_SEGUI;
    String  INDECISION_SEGUI;
    String  CAPACIDAD_PAGO_LIMITADA_SEGUI;
    String  VA_USAR_EPS_SEGUI;
    String  VA_USAR_OTRA_IPS_SEGUI;
    String  NO_APLICA_CAUSAL_SEGUI;
    String REMISION_POR_EDAD_GES_SEGUI;
    String DESEA_CONTINUAR_EMBARAZO_SEGUI;
    String OPTA_ILVE_SEGUI;
    String APLAZA_DECISION_SEGUI;
    String ASESOR_SEGUI;
    String SEGUIMIENTO;
    BigDecimal SEMANAS_ESTIMADAS_SEGUI;
    Date FECHA_ECOGRAFIA_SEGUI;
    BigDecimal SEMANAS_ECOGRAFIA_SEGUI;
    String TIPO_SERVICIO_SEGUI;
    String NOMBRE_INSTITUCION_SEGUI;
    String NOMBRE_CONTACTO_SEGUI;
    BigDecimal TELEFONO_CONTACTO;
    String CONFIRMA_PROCEDIMIENTO;
    String LUGAR_PROCEDIMIENTO;
    String METODO_ANTICONCEPCION;
    String NOMBRE_SERVICIO;


    public void init() {
        index = -1;
        
        if(getUsuarioSystem() != null && getUsuarioSystem().getCurnclinic() != null){
            wcodclin = getUsuarioSystem().getCurnclinic(); 
        }
       
    }

    public ReporteClinicAsesoriasIlveBean() {
        init();
    }

    /**
     * @return
     */
    public String volverInicio() {
        FacesUtils.resetManagedBean("reporteClinicAsesoriaIlveBean");
        return "home";
    }

    /**
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
    }


    /**
     * @param lstClinicas
     */
    public void setLstClinicas(List lstClinicas) {
        this.lstClinicas = lstClinicas;
    }

    /**
     * @return
     */
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


    /**
     * @param wcodclin
     */
    public void setWcodclin(Integer wcodclin) {
        this.wcodclin = wcodclin;
    }

    /**
     * @return
     */
    public Integer getWcodclin() {
        return wcodclin;
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

    /**
     * @param jrField
     * @return
     */
     public Object getFieldValue(JRField jrField) {
         Object value = null;
         Object[] aux = null;
         if(index < lstReporte.size()){
             aux = lstReporte.get(index);    
         }
         
         resetDatos();
         obtenerDatos(aux);

         String fieldName = jrField.getName();
         if (fieldName.equals("FECHA_ASESORIA"))
             value = FECHA_ASESORIA;
         else if (fieldName.equals("CLINICA"))
             value = CLINICA;
         else if (fieldName.equals("NUMERO_IDENTIFICACION"))
             value = NUMERO_IDENTIFICACION;
         else if (fieldName.equals("EDAD"))
             value = EDAD;
         else if (fieldName.equals("MOTIVO_CONOCIMIENTO_PROGRAMA"))
             value = MOTIVO_CONOCIMIENTO_PROGRAMA;
         else if (fieldName.equals("INTERVENCION_ASESORIA"))
             value = INTERVENCION_ASESORIA;
         else if (fieldName.equals("TIPO_INTERVENCION"))
             value = TIPO_INTERVENCION;
         else if (fieldName.equals("OTRA_REMISION"))
             value = OTRA_REMISION;
         else if (fieldName.equals("INDECISION"))
             value = INDECISION;
         else if (fieldName.equals("CAPACIDAD_PAGO_LIMITADA"))
             value = CAPACIDAD_PAGO_LIMITADA;
         else if (fieldName.equals("VA_USAR_EPS"))
             value = VA_USAR_EPS;
         else if (fieldName.equals("VA_USAR_OTRA_IPS"))
             value = VA_USAR_OTRA_IPS;
         else if (fieldName.equals("NO_APLICA_CAUSAL"))
             value = NO_APLICA_CAUSAL;
         else if (fieldName.equals("REMISION_POR_EDAD_GESTACIONAL"))
             value = REMISION_POR_EDAD_GESTACIONAL;
         else if (fieldName.equals("DESEA_CONTINUAR_EMBARAZO"))
             value = DESEA_CONTINUAR_EMBARAZO;
         else if (fieldName.equals("OPTA_ILVE"))
             value = OPTA_ILVE;
         else if (fieldName.equals("APLAZA_DECISION"))
             value = APLAZA_DECISION;
         else if (fieldName.equals("USUARIO_REGISTRO"))
             value = USUARIO_REGISTRO;
         else if (fieldName.equals("LOGIN_REGISTRO"))
             value = LOGIN_REGISTRO;
         else if (fieldName.equals("OTRA_REMISION_"))
             value = OTRA_REMISION_;
         else if (fieldName.equals("NUMERO_EDAD_GESTACIONAL"))
             value = NUMERO_EDAD_GESTACIONAL;
         else if (fieldName.equals("NUMERO_SEGUI"))
             value = NUMERO_SEGUI;  
         else if (fieldName.equals("FECHA_SEGUI"))
             value = FECHA_SEGUI;   
         else if (fieldName.equals("NUMERO_EDAD_GES_SEGUI"))
             value = NUMERO_EDAD_GES_SEGUI;   
         else if (fieldName.equals("MOTIVO_APLAZA_DECI_SEGUI"))
             value = MOTIVO_APLAZA_DECI_SEGUI;   
         else if (fieldName.equals("OTRA_CONDUCTA_SEGUI"))
             value = OTRA_CONDUCTA_SEGUI;   
         else if (fieldName.equals("OTRA_REMISION_SEGUI"))
             value = OTRA_REMISION_SEGUI;   
         else if (fieldName.equals("INDECISION_SEGUI"))
             value = INDECISION_SEGUI;   
         else if (fieldName.equals("CAPACIDAD_PAGO_LIMITADA_SEGUI"))
             value = CAPACIDAD_PAGO_LIMITADA_SEGUI;   
         else if (fieldName.equals("VA_USAR_EPS_SEGUI"))
             value = VA_USAR_EPS_SEGUI;   
         else if (fieldName.equals("VA_USAR_OTRA_IPS_SEGUI"))
             value = VA_USAR_OTRA_IPS_SEGUI;   
         else if (fieldName.equals("NO_APLICA_CAUSAL_SEGUI"))
             value = NO_APLICA_CAUSAL_SEGUI;   
         else if (fieldName.equals("REMISION_POR_EDAD_GES_SEGUI"))
             value = REMISION_POR_EDAD_GES_SEGUI;   
         else if (fieldName.equals("DESEA_CONTINUAR_EMBARAZO_SEGUI"))
             value = DESEA_CONTINUAR_EMBARAZO_SEGUI;   
         else if (fieldName.equals("OPTA_ILVE_SEGUI"))
             value = OPTA_ILVE_SEGUI;   
         else if (fieldName.equals("APLAZA_DECISION_SEGUI"))
             value = APLAZA_DECISION_SEGUI;  
         else if (fieldName.equals("ASESOR_SEGUI"))
             value = ASESOR_SEGUI;   
         else if (fieldName.equals("SEGUIMIENTO"))
             value = SEGUIMIENTO;   
         else if (fieldName.equals("SEMANAS_ESTIMADAS_SEGUI"))
             value = SEMANAS_ESTIMADAS_SEGUI;   
         else if (fieldName.equals("FECHA_ECOGRAFIA_SEGUI"))
             value = FECHA_ECOGRAFIA_SEGUI;   
         else if (fieldName.equals("SEMANAS_ECOGRAFIA_SEGUI"))
             value = SEMANAS_ECOGRAFIA_SEGUI;   
         else if (fieldName.equals("TIPO_SERVICIO_SEGUI"))
             value = TIPO_SERVICIO_SEGUI;   
         else if (fieldName.equals("NOMBRE_INSTITUCION_SEGUI"))
             value = NOMBRE_INSTITUCION_SEGUI;   
         else if (fieldName.equals("NOMBRE_CONTACTO_SEGUI"))
             value = NOMBRE_CONTACTO_SEGUI;   
         else if (fieldName.equals("TELEFONO_CONTACTO"))
             value = TELEFONO_CONTACTO;   
         else if (fieldName.equals("CONFIRMA_PROCEDIMIENTO"))
             value = CONFIRMA_PROCEDIMIENTO;   
         else if (fieldName.equals("LUGAR_PROCEDIMIENTO"))
             value = LUGAR_PROCEDIMIENTO;   
         else if (fieldName.equals("METODO_ANTICONCEPCION"))
             value = METODO_ANTICONCEPCION;   
         else if (fieldName.equals("NOMBRE_SERVICIO"))
             value = NOMBRE_SERVICIO;  

         return value;
     }




 
 
    public void resetDatos() {
        FECHA_ASESORIA = null;
        CLINICA = null;
        NUMERO_IDENTIFICACION = null;
        EDAD = null;
        MOTIVO_CONOCIMIENTO_PROGRAMA = null;
        INTERVENCION_ASESORIA = null;
        TIPO_INTERVENCION = null;
        OTRA_REMISION = null;
        INDECISION = null;
        CAPACIDAD_PAGO_LIMITADA = null;
        VA_USAR_EPS = null;
        VA_USAR_OTRA_IPS = null;
        NO_APLICA_CAUSAL = null;
        REMISION_POR_EDAD_GESTACIONAL = null;
        DESEA_CONTINUAR_EMBARAZO = null;
        OPTA_ILVE = null;
        APLAZA_DECISION = null;
        USUARIO_REGISTRO = null;
        LOGIN_REGISTRO = null;
        OTRA_REMISION_ = null;
        NUMERO_EDAD_GESTACIONAL = null;
        NUMERO_SEGUI = null; 
        FECHA_SEGUI = null; 
        NUMERO_EDAD_GES_SEGUI = null; 
        MOTIVO_APLAZA_DECI_SEGUI = null;  
        OTRA_CONDUCTA_SEGUI = null; 
        OTRA_REMISION_SEGUI = null; 
        INDECISION_SEGUI = null; 
        CAPACIDAD_PAGO_LIMITADA_SEGUI = null; 
        VA_USAR_EPS_SEGUI = null; 
        VA_USAR_OTRA_IPS_SEGUI = null; 
        NO_APLICA_CAUSAL_SEGUI = null; 
        REMISION_POR_EDAD_GES_SEGUI = null; 
        DESEA_CONTINUAR_EMBARAZO_SEGUI = null; 
        OPTA_ILVE_SEGUI = null; 
        APLAZA_DECISION_SEGUI = null; 
        ASESOR_SEGUI = null; 
        SEGUIMIENTO = null; 
        SEMANAS_ESTIMADAS_SEGUI = null; 
        FECHA_ECOGRAFIA_SEGUI = null; 
        SEMANAS_ECOGRAFIA_SEGUI = null; 
        TIPO_SERVICIO_SEGUI = null; 
        NOMBRE_INSTITUCION_SEGUI = null; 
        NOMBRE_CONTACTO_SEGUI = null; 
        TELEFONO_CONTACTO = null; 
        CONFIRMA_PROCEDIMIENTO = null; 
        LUGAR_PROCEDIMIENTO = null; 
        METODO_ANTICONCEPCION = null; 
        NOMBRE_SERVICIO = null; 

    }

    public void obtenerDatos(Object[] aseaux) {
    if(aseaux!= null){
        FECHA_ASESORIA = ((Date)aseaux[0]);
        CLINICA = ((BigDecimal)aseaux[1]);
        NUMERO_IDENTIFICACION = (BigDecimal)aseaux[2];
        EDAD = (BigDecimal)aseaux[3];
        MOTIVO_CONOCIMIENTO_PROGRAMA = obtenerConocimiento((BigDecimal)aseaux[4]); 
        INTERVENCION_ASESORIA = obtenerIntervencion((BigDecimal)aseaux[5]); 
        TIPO_INTERVENCION = obtenerIntervencion((BigDecimal)aseaux[6]); 
        OTRA_REMISION = formatearCampo((String)aseaux[7]);
        INDECISION = formatearCampo((String)aseaux[8]);
        CAPACIDAD_PAGO_LIMITADA = formatearCampo((String)aseaux[9]);
        VA_USAR_EPS = formatearCampo((String)aseaux[10]);
        VA_USAR_OTRA_IPS = formatearCampo((String)aseaux[11]);
        NO_APLICA_CAUSAL = formatearCampo((String)aseaux[12]);
        REMISION_POR_EDAD_GESTACIONAL = formatearCampo((String)aseaux[13]);
        DESEA_CONTINUAR_EMBARAZO = formatearCampo((String)aseaux[14]);
        OPTA_ILVE = formatearCampo((String)aseaux[15]);
        APLAZA_DECISION = formatearCampo((String)aseaux[16]);
        USUARIO_REGISTRO = obtenerNombre((String)aseaux[17],CLINICA);
        LOGIN_REGISTRO = formatearCampo((String)aseaux[17]);
        OTRA_REMISION_=  formatearCampo((String)aseaux[18]);  
        NUMERO_EDAD_GESTACIONAL=  (BigDecimal)aseaux[19];    
        NUMERO_SEGUI =  (BigDecimal)aseaux[20]; 
        FECHA_SEGUI =  (Date)aseaux[21]; 
        NUMERO_EDAD_GES_SEGUI =  (BigDecimal)aseaux[22]; 
        MOTIVO_APLAZA_DECI_SEGUI =  formatearCampo((String)aseaux[23]);  
        OTRA_CONDUCTA_SEGUI =  formatearCampo((String)aseaux[24]); 
        OTRA_REMISION_SEGUI =  formatearCampo((String)aseaux[25]); 
        INDECISION_SEGUI =  formatearCampo((String)aseaux[26]); 
        CAPACIDAD_PAGO_LIMITADA_SEGUI =  formatearCampo((String)aseaux[27]); 
        VA_USAR_EPS_SEGUI =  formatearCampo((String)aseaux[28]); 
        VA_USAR_OTRA_IPS_SEGUI =  formatearCampo((String)aseaux[29]); 
        NO_APLICA_CAUSAL_SEGUI =  formatearCampo((String)aseaux[30]); 
        REMISION_POR_EDAD_GES_SEGUI =  formatearCampo((String)aseaux[31]); 
        DESEA_CONTINUAR_EMBARAZO_SEGUI =  formatearCampo((String)aseaux[32]); 
        OPTA_ILVE_SEGUI =  formatearCampo((String)aseaux[33]); 
        APLAZA_DECISION_SEGUI =  formatearCampo((String)aseaux[34]); 
        ASESOR_SEGUI =  formatearCampo((String)aseaux[49]); 
        SEGUIMIENTO =  formatearCampo((String)aseaux[36]); 
        SEMANAS_ESTIMADAS_SEGUI =  (BigDecimal)aseaux[37]; 
        FECHA_ECOGRAFIA_SEGUI =  (Date)aseaux[38]; 
        SEMANAS_ECOGRAFIA_SEGUI =  (BigDecimal)aseaux[39]; 
        TIPO_SERVICIO_SEGUI =  formatearCampo((String)aseaux[40]); 
        NOMBRE_INSTITUCION_SEGUI =  formatearCampo((String)aseaux[41]); 
        NOMBRE_CONTACTO_SEGUI =  formatearCampo((String)aseaux[42]); 
        TELEFONO_CONTACTO =  (BigDecimal)aseaux[43]; 
        CONFIRMA_PROCEDIMIENTO =  formatearCampo((String)aseaux[44]); 
        LUGAR_PROCEDIMIENTO =  formatearCampo((String)aseaux[45]); 
        METODO_ANTICONCEPCION =  formatearCampo((String)aseaux[46]); 
        NOMBRE_SERVICIO =  formatearCampo((String)aseaux[47]); 
        
        
    }
      

    }
    
    
    public String obtenerNombre(String usuario, BigDecimal codclinica){
    
        String nombreUsuario = ""; 
        Cpprofesio profes = null;
        
        if(usuario!= null && codclinica!= null){
            try {
                profes = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(usuario,codclinica.intValue());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
            
            if(profes!= null){
                nombreUsuario = profes.getCpfcnombre(); 
            }
        }
        
        
        return nombreUsuario; 
    }
        
        
    
    private String obtenerIntervencion(BigDecimal codigo){
        Integer codigoAux = null; 
        String descripcionIntervencion = ""; 
        if(codigo!= null){
            codigoAux = codigo.intValue(); 
        }


        try {
            descripcionIntervencion =  this.serviceLocator.getClinicoService().getDescripcionIntervencionAsesoriaXid(codigoAux);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return descripcionIntervencion;
    }
    
    private String obtenerConocimiento(BigDecimal codigo){
    String desConocimiento = ""; 
    Integer codigoAux = null; 
    if(codigo!=null){
        codigoAux = codigo.intValue(); 
    }
       try {
            desConocimiento = this.serviceLocator.getClinicoService().getDescripcionConocimientoAvise(codigoAux);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return desConocimiento;
    }


    
  

    public String generarAsesoriaIlve() {

        index = -1;
        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getReporteClinicAsesoraIlve(wcodclin, 
                                                                                  fechaInicial, 
                                                                                  fechaFinal);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_REPORTES);
        }

        if (lstReporte == null || lstReporte.isEmpty()) {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADO_CONSULTA);
            generoReporte = false;
        } else {
            try {
                
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteClinicAsesoriasIlve.jasper");
            /*    URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);*/
               
               
             /*   if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Resumen_Asesoria_MiClinica" + ".pdf", 
                                                    false);
                    generoReporte = true;

                }*/
                
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
                                                  "Resumen_Asesoria_MiClinica" + 
                                                  ".csv", false);

                  generoReporte = true;
   }
            } catch (Exception e) {
                return capturaError(e,IConstantes.ERROR_REPORTES);
            }

        }
        return null;
    }


}
