package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReportesServiciosSinFacturaBean extends BaseBean implements JRDataSource {

    private Date fechaInicial; 
    
    private Date fechaFinal; 
    
    private boolean generoReporte;
    
    private List<Object[]> lstReporte; 
    
    private int index; 
    
 
    
    
        private BigDecimal CLINICA;
        private Date FECHA_CONSULTA;
        private BigDecimal TIPO_DOC;
        private String DESCRIPCION_DOC;
        private String SERVICIO;
        private String NOMBRE_SERVICIO;
        private BigDecimal CANTIDAD;
        private BigDecimal  VALOR_SERVICIO;
        private String USUARIO_REG;




    public ReportesServiciosSinFacturaBean() {
    }
    
    public void init(){
    }

    /**
     * @return
     */
     /**
      * @return
      */
     public boolean next() {
                    index++;
             if(lstReporte != null)
                 return index < lstReporte.size();
             else
                 return false;
         }


    /**
     * @param jrField
     * @return
     */
     public Object getFieldValue(JRField jrField){
         Object value = null;
         String fieldName = jrField.getName();
         obtenerDatosReporte(index); 
         
    
         if(fieldName.equals("CLINICA"))
             value = CLINICA;
             
             
         else if(fieldName.equals("FECHA_CONSULTA"))
             value = FECHA_CONSULTA;
         else if(fieldName.equals("TIPO_DOC"))
             value = TIPO_DOC;
         else if(fieldName.equals("DESCRIPCION_DOC"))
             value = DESCRIPCION_DOC;
         else if(fieldName.equals("SERVICIO"))
             value = SERVICIO;
         else if(fieldName.equals("NOMBRE_SERVICIO"))
             value = NOMBRE_SERVICIO;
         else if(fieldName.equals("CANTIDAD"))
             value = CANTIDAD;
         else if(fieldName.equals("VALOR_SERVICIO"))
             value = VALOR_SERVICIO;
         else if(fieldName.equals("USUARIO_REG"))
             value = USUARIO_REG;
        
         

         return value;
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
     * @param lstReporte
     */
    public void setLstReporte(List<Object[]> lstReporte) {
        this.lstReporte = lstReporte;
    }

    /**
     * @return
     */
    public List<Object[]> getLstReporte() {
        return lstReporte;
    }
    
    
    public void obtenerDatosReporte(int indexAux){

        
      
            
                CLINICA = null;
                FECHA_CONSULTA= null;
                TIPO_DOC= null;
                DESCRIPCION_DOC= null;
                SERVICIO= null;
                NOMBRE_SERVICIO= null;
                CANTIDAD= null;
                VALOR_SERVICIO= null;
                USUARIO_REG= null;

        
        Object[] aux = lstReporte.get(indexAux); 
        
         
        
        if(aux != null){
            if(aux[0]!= null){
                CLINICA = new BigDecimal(aux[0].toString());         
            }
            
                if(aux[1]!= null){
                    FECHA_CONSULTA = (Date)(aux[1]);     
                }
                
                if(aux[2]!= null){
                    TIPO_DOC = new BigDecimal(aux[2].toString());         
                }
                
                if(aux[3]!= null){
                    DESCRIPCION_DOC = (aux[3].toString());         
                }
                
                if(aux[4]!= null){
                    DESCRIPCION_DOC = (aux[4].toString());         
                }
                
                if(aux[5]!= null){
                    SERVICIO = (aux[5].toString());         
                }
                if(aux[6]!= null){
                    NOMBRE_SERVICIO = (aux[6].toString());         
                }
                
                if(aux[7]!= null){
                    SERVICIO = (aux[7].toString());         
                }
                
                if(aux[8]!= null){
                    TIPO_DOC = new BigDecimal(aux[8].toString());         
                }
                
                if(aux[9]!= null){
                    VALOR_SERVICIO = new BigDecimal(aux[9].toString());         
                }
                if(aux[10]!= null){
                    USUARIO_REG = (aux[10].toString());         
                }

            }

        }
        
        
     
    public void generarReporte()
    {
        
        
        
        index = -1;
        
        
        String urlAux = ""; 
        generoReporte = false;
        String nombSalida = "ReporteServicioSinFactura"+new Date();


        urlAux = "/reports/reporteServiciosSinFactura.jasper";



                try {
                    lstReporte = this.serviceLocator.getClinicoService().getReporteServiciosSinFactura(fechaInicial,fechaFinal);
                } catch (ModelException e) {
                   e.printStackTrace();
                }
               
       
        if(lstReporte != null && !lstReporte.isEmpty()){
            try {

                java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource(urlAux);
                java.net.URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                java.net.URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                java.net.URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");

                if (url != null) {

                   
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", getClinica().getCclcnombre());
                    parameters.put("FECHA_INICIAL", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);
  

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
                                                    nombSalida + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                    generoReporte = true;
                    
                    FacesUtils.addInfoMessage("Mensaje generado exitosamente");


                }
            } catch (Exception e) {
             
                FacesUtils.addErrorMessage("No se genero el reporte " + 
                                           e.getMessage());
                e.printStackTrace();
            }
        }else{
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }
        
            if(lstReporte != null){
                System.out.println("Tamano de la lista " + lstReporte.size());
            }else{
                System.out.println("Tamano de la lista  0" );
            }
        
     
    }

    
    
  


}
