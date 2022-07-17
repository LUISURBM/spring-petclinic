 //=======================================================================
 // ARCHIVO ReporteControlCitologiasNalBean.java
 // FECHA CREACI�N: 22/08/2012
 // AUTOR: Jos� Andr�s Riano Rinc�n
 // Descripci�n: 
 //=======================================================================
 package org.profamilia.hc.view.backing.procedimiento.reportes;

 import java.io.ByteArrayOutputStream;

 import java.lang.Object;

 import java.math.BigDecimal;

 import java.net.URL;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.GregorianCalendar;
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
 import net.sf.jasperreports.engine.JasperRunManager;
 import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
 import net.sf.jasperreports.engine.export.JRXlsExporter;
 import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
 import net.sf.jasperreports.engine.util.JRLoader;

 import org.profamilia.hc.model.dto.Cpclinica;
 import org.profamilia.hc.model.dto.Cpentidadadm;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
 import org.profamilia.hc.view.util.FacesUtils;
 import org.profamilia.hc.view.util.PdfServletUtils;
 import org.profamilia.hc.view.util.XlsServletUtils;


 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //=======================================================================
 //  CLASE ReporteControlCitologiasBean
 //=======================================================================
 public class ReporteControlCitologiasNalBean extends BaseBean implements JRDataSource {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------

     private Date fechaInicial;

     private Date fechaFinal;

     private boolean generoReporte;

     private boolean generoReporte_CE;

     private List listaCitologias = new ArrayList();

     private int index = -1;

     private String tipoReporte;
     
     
     private List lstClinicas; 
     private Integer wcodclin; 


     public ReporteControlCitologiasNalBean() {
     }

     public void init() {

         generoReporte = false;
         generoReporte_CE = false;
         listaCitologias = new ArrayList();
         tipoReporte = "SE";

     }

     // ACTIONS

     /**
      * @param jrField
      * @return
      */
     public Object getFieldValue(JRField jrField) {

         Object value = null;
         String fieldName = jrField.getName();

         Object[] reporte = new Object[listaCitologias.size()];
         reporte = (Object[])listaCitologias.get(index);


            if (fieldName.equals("ID_CITOLOGIA")) {
                 value = (BigDecimal)reporte[0];
                 return value;
             }

             if (fieldName.equals("NOMBRE_USUARIO")) {
                 value = (String)reporte[1];
                 return value;
             }

             if (fieldName.equals("FECHA_TOMA")) {
                 value =  (Date)reporte[2];
                 return value;
             }

             else if (fieldName.equals("IDENTIFICACION")) {
                 value = (String)reporte[3];
                 return value;
             }

            else if (fieldName.equals("NUMERO")) {
                 value =  (BigDecimal)reporte[4];
                 return value;
             }

             else if (fieldName.equals("EDAD")) {
                 value =  (BigDecimal)reporte[5];
                 return value;
             }
             
         else if (fieldName.equals("NUMERO_FACTURA")) {
             value =  (String)reporte[6];
             return value;
         }
         
         else if (fieldName.equals("TELEFONO")) {
             value =  (String)reporte[7];
             return value;
         }
         
         else if (fieldName.equals("DIRECCION")) {
             value =  (String)reporte[8];
             return value;
         }
         
         else if (fieldName.equals("ASEGURADORA")) {
             value = obtenerAseguradora((String)reporte[9]);
             return value;
         }
         
         else if (fieldName.equals("CATEGORIZACION")) {
             value =  obtenerDescripcionCitologia("cncitolect","clcccatego",(String)reporte[10]);
             return value;
         }
         
         else if (fieldName.equals("RESULTADO_CCU")) {
             value =  obtenerDescripcionCitologia("cncitolect","clcccalmue",(String)reporte[11]);
             return value;
         }
         
         else if (fieldName.equals("FECHA_ENTREGA")) {
             value = (Date)reporte[12];
             return value;
         }
         
         else if (fieldName.equals("ESQUEMA")) {
             value = obtenerDescripcionCitologia("cncitotoma","ctmcesquem",(String)reporte[13]);
             return value;
         }
         
         else if (fieldName.equals("PERSONA_RECIBE")) {
             value =  (String)reporte[14];
             return value;
         }
         

         return value;
     }

     /**
      * @return
      */
     public boolean next() {
         index++;
         return (index < listaCitologias.size());
     }

     public void generarListaEntrega() {
         index = -1;
         generoReporte_CE = false;

          

                try {

                     listaCitologias = 
                             this.serviceLocator.getClinicoService().getLibroControlCitologia(fechaInicial, 
                                                                                             fechaFinal, 
                                                                                             wcodclin);

                 } catch (ModelException de) {
                     FacesUtils.addErrorMessage(null, de.getMessage(), 
                                                MSG_NO_CONSULTA);
                 } catch (Exception e) {
                     FacesUtils.addErrorMessage(null, e.getMessage(), 
                                                MSG_NO_CONSULTA);
                 }

                

                     try {

                         URL url = 
                             FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteLibroControlCitologias.jasper");
                        
                         if (url != null) {

                             Map reportParams = new HashMap();
                             reportParams.put("CENTRO", 
                                              this.getClinica().getCclcnombre());
                             reportParams.put("COD_CENTRO", 
                                              this.getClinica().getCclncodigo());
                             reportParams.put("FECHA_INICIAL", fechaInicial);
                             reportParams.put("FECHA_FINAL", fechaFinal);
                            

                             byte[] bytes;

                             JasperReport report = 
                                 (JasperReport)JRLoader.loadObject(url);
                             bytes = 
                                     JasperRunManager.runReportToPdf(report, reportParams, 
                                                                     (JRDataSource)this);
                             PdfServletUtils.showPdfDocument(bytes, 
                                                             "Reporte_Control_Citologias" + 
                                                             Calendar.getInstance().getTimeInMillis() + 
                                                             ".pdf", false);
                             generoReporte = false;
                             generoReporte_CE = true;


                         }
                     } catch (Exception e) {
                         e.printStackTrace();
                         FacesUtils.addErrorMessage("No se genero el reporte " + 
                                                    e.getMessage());
                     }

                 }

     public void generarListaEntregaXls() {
         index = -1;
         generoReporte_CE = false;

         try {
             listaCitologias = this.serviceLocator.getClinicoService().getLibroControlCitologia(fechaInicial, 
                                                                                      fechaFinal, 
                                                                                      wcodclin);
         } catch (ModelException de) {
             FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
         } catch (Exception e) {
             FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
         }

         try {
             URL url = 
                 FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteLibroControlCitologias.jasper");

             if (url != null) {

                 Map reportParams = new HashMap();
                 reportParams.put("CENTRO", this.getClinica().getCclcnombre());
                 reportParams.put("COD_CENTRO", 
                                  this.getClinica().getCclncodigo());
                 reportParams.put("FECHA_INICIAL", fechaInicial);
                 reportParams.put("FECHA_FINAL", fechaFinal);

                 JRBeanCollectionDataSource dataSource = 
                     new JRBeanCollectionDataSource(listaCitologias);

                 JasperReport report = 
                     (JasperReport)JRLoader.loadObject(url);

                 JasperPrint jasperPrint = 
                     JasperFillManager.fillReport(report, reportParams, 
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
                                                 "Reporte_Control_Citologias" + 
                                                 Calendar.getInstance().getTimeInMillis() + 
                                                 ".xls", false);

                 generoReporte = false;
                 generoReporte_CE = true;


             }
         } catch (Exception e) {
             e.printStackTrace();
             FacesUtils.addErrorMessage("No se genero el reporte " + 
                                        e.getMessage());
         }

     }


     //ACCESSORS

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
      * @param tipoReporte
      */
     public void setTipoReporte(String tipoReporte) {
         this.tipoReporte = tipoReporte;
     }

     /**
      * @return
      */
     public String getTipoReporte() {
         return tipoReporte;
     }

     /**
      * @param generoReporte_CE
      */
     public void setGeneroReporte_CE(boolean generoReporte_CE) {
         this.generoReporte_CE = generoReporte_CE;
     }

     /**
      * @return
      */
     public boolean isGeneroReporte_CE() {
         return generoReporte_CE;
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


     
     private String obtenerAseguradora(String codigo){
     String nombreAseguradora = ""; 
         if (codigo != null && !codigo.equals("")) {
             Cpentidadadm aseguradora;
             aseguradora = null;

             try {
                 aseguradora = 
                         serviceLocator.getClinicoService().getAseguradoraPorCodigo(codigo);
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (aseguradora != null) {
                 nombreAseguradora = aseguradora.getCeacnombre();
             }

         }
         return nombreAseguradora; 
     }
     
     
     
     private String obtenerDescripcionCitologia(String cdictabla, String cdiccampo, String cdicvalor){
         String nombreAseguradora = ""; 
             if (cdictabla != null && !cdictabla.equals("")) {
                 
                 try {
                     nombreAseguradora = 
                             serviceLocator.getClinicoService().getDescripcionParametrosCitologia(cdictabla,cdiccampo,cdicvalor);
                 } catch (ModelException e) {
                     e.printStackTrace();
                 }
             }
             return nombreAseguradora; 
         }
         
 }

