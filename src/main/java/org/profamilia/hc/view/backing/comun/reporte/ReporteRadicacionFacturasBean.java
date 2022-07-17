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


public class ReporteRadicacionFacturasBean extends BaseBean implements JRDataSource {

    private Date fechaInicial; 
    
    private Date fechaFinal; 
    
    private boolean generoReporte;
    
    private List<Object[]> lstReporte; 
    
    private int index; 
    
 
    
    BigDecimal NUMERO_FACTURA; 
    
    BigDecimal CLINICA; 
    
    String NOMBRE_CLINICA; 
    
    Date FECHA_FACTURA;
    
    BigDecimal NUMERO_CONTRATO; 
    
    BigDecimal VALOR_ENTIDAD; 
    
    BigDecimal VALOR_DONANTE; 
    
    BigDecimal VALOR_SUBTOTAL; 
    
    BigDecimal VALOR_ABONO; 
    
    BigDecimal VALOR_DESCUENTO; 
    
    BigDecimal VALOR_IVA; 
    
    BigDecimal NUMERO_CUENTA_COBRO; 
    
    Date FECHA_CUENTA_COBRO;
    
    Date FECHA_RADICACION;
    
    String NUMERO_RADICACION; 
    
    String RADICADA; 
    
    String NOMBRE_CONTRATO;
    
    String Codigo_Contrato;
    
    




    public ReporteRadicacionFacturasBean() {
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
         
    
         if(fieldName.equals("NUMERO_FACTURA"))
             value = NUMERO_FACTURA;
             
             
         else if(fieldName.equals("CLINICA"))
             value = CLINICA;
         else if(fieldName.equals("NOMBRE_CLINICA"))
             value = NOMBRE_CLINICA;
         else if(fieldName.equals("FECHA_FACTURA"))
             value = FECHA_FACTURA;
         else if(fieldName.equals("NUMERO_CONTRATO"))
             value = NUMERO_CONTRATO;
         else if(fieldName.equals("VALOR_ENTIDAD"))
             value = VALOR_ENTIDAD;
         else if(fieldName.equals("VALOR_DONANTE"))
             value = VALOR_DONANTE;
         else if(fieldName.equals("VALOR_SUBTOTAL"))
             value = VALOR_SUBTOTAL;
         else if(fieldName.equals("VALOR_ABONO"))
             value = VALOR_ABONO;
         else if(fieldName.equals("VALOR_DESCUENTO"))
             value = VALOR_DESCUENTO;
         else if(fieldName.equals("VALOR_IVA"))
             value = VALOR_IVA;
         else if(fieldName.equals("NUMERO_CUENTA_COBRO"))
             value = NUMERO_CUENTA_COBRO;
         else if(fieldName.equals("FECHA_CUENTA_COBRO"))
             value = FECHA_CUENTA_COBRO;
         else if(fieldName.equals("FECHA_RADICACION"))
             value = FECHA_RADICACION;
         else if(fieldName.equals("NUMERO_RADICACION"))
             value = NUMERO_RADICACION;
             
             
         else if(fieldName.equals("RADICADA"))
             value = RADICADA;
         
         else if(fieldName.equals("NOMBRE_CONTRATO")){
             value = NOMBRE_CONTRATO;
         }
             
         
         

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

        
      
            NUMERO_FACTURA = null;  
            CLINICA = null; 
            NOMBRE_CLINICA = null; 
            FECHA_FACTURA = null; 
            NUMERO_CONTRATO = null; 
            VALOR_ENTIDAD = null; 
            VALOR_DONANTE = null; 
            VALOR_SUBTOTAL = null; 
            VALOR_ABONO = null; 
            VALOR_DESCUENTO = null; 
            VALOR_IVA = null; 
            NUMERO_CUENTA_COBRO = null; 
            FECHA_CUENTA_COBRO = null; 
            FECHA_RADICACION = null; 
            NUMERO_RADICACION = null; 
            RADICADA = null; 
            NOMBRE_CONTRATO = null;
            


        
        Object[] aux = lstReporte.get(indexAux); 
        
        
        if(aux != null){
            if(aux[0]!= null){
                NUMERO_FACTURA = new BigDecimal(aux[0].toString());     
            }
            
                if(aux[1]!= null){
                    CLINICA = new BigDecimal(aux[1].toString());     
                }
                
                
                if(aux[2]!= null){
                    NOMBRE_CLINICA = aux[2].toString();     
                }
                
                if(aux[3]!= null){
                    FECHA_FACTURA = (Date)aux[3];     
                }
                
                
                if(aux[4]!= null){
                    NUMERO_CONTRATO = new BigDecimal(aux[4].toString());     
                    NOMBRE_CONTRATO = obtenerNombreContrato(new String(aux[4].toString()));
                }
                
                
                if(aux[5]!= null){
                    VALOR_ENTIDAD = new BigDecimal(aux[5].toString());     
                }
                
                
                if(aux[6]!= null){
                    VALOR_DONANTE = new BigDecimal(aux[6].toString());     
                }
                
            
                if(aux[7]!= null){
                    VALOR_SUBTOTAL = new BigDecimal(aux[7].toString());     
                }
                
                
                
                    if(aux[8]!= null){
                        VALOR_ABONO = new BigDecimal(aux[8].toString());     
                    }
                
                    if(aux[9]!= null){
                        VALOR_DESCUENTO = new BigDecimal(aux[9].toString());     
                    }
                
                    if(aux[10]!= null){
                        VALOR_IVA = new BigDecimal(aux[10].toString());     
                    }
                
                    if(aux[11]!= null){
                        NUMERO_CUENTA_COBRO = new BigDecimal(aux[11].toString());     
                    }
                    
                    
                if(aux[12]!= null){
                    FECHA_CUENTA_COBRO = (Date)aux[12];     
                }
                
                if(aux[13]!= null){
                    FECHA_RADICACION = (Date)aux[13];     
                }
                
                if(aux[14]!= null){
                    NUMERO_RADICACION = aux[14].toString();     
                }
                
                if(aux[16]!= null){
                    RADICADA = aux[16].toString().toString();     
                }
                
                
                
             
                
              
            }

        }
        
        
     
    public void generarReporte()
    {
        
        
        
        index = -1;
        
        
        String urlAux = ""; 
        generoReporte = false;
        String nombSalida = "ReporteRadicacionFacturas"+new Date();


        urlAux = "/reports/reporteRadicacionFacturas.jasper";



                try {
                    lstReporte = this.serviceLocator.getClinicoService().getReporteRadicacionFacturas(fechaInicial,fechaFinal);
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
        
     
    }


    private String obtenerNombreContrato(String numcontra){
        String nomContra = "";
        
        try {
            nomContra = serviceLocator.getCirugiaService().getNombreContrato(numcontra);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        return nomContra;
    }
    
    
  


}
