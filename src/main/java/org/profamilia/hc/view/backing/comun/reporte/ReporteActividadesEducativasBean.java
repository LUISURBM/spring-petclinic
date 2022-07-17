//=======================================================================
// ARCHIVO Reporte Actividades Educativas
// FECHA CREACI�N: 06/10/2015
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Reporte Actividades Educativas
//=======================================================================
 package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

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
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ReporteActividadesEducativasBean
//=======================================================================
public class ReporteActividadesEducativasBean extends BaseBean  implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstActividadEducativa;




    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE REPORTE
    //-----------------------------------------------------------------------

  



    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ReporteActividadesEducativasBean() {

    }




    //-----------------------------------------------------------------------
    //  REPORT
    //-----------------------------------------------------------------------
    


         public boolean next()
         {
             index++;
             if(lstActividadEducativa != null)
                 return index < lstActividadEducativa.size();
             else
                 return false;
         }

         public Object getFieldValue(JRField jrField){
             Object value = null;
             Object a[] = null;
             String fieldName = jrField.getName();
             if(lstActividadEducativa.get(index) != null)
                 a = (Object[])lstActividadEducativa.get(index);
           
           
             if(fieldName.equals("NUMERO_ASESORIA"))
                 value = a[0];
             else if(fieldName.equals("FECHA_ASESORIA")){
                 value = a[1];
             } else if(fieldName.equals("HORA_INICIAL")){
                 value = a[2];
             } else if(fieldName.equals("HORA_FINAL")){
                 value = a[3];
             } else if(fieldName.equals("LUGAR"))
             {
                 value = a[4];
             } else if(fieldName.equals("TIPO"))
             {
                 value = a[5];
             } else if(fieldName.equals("DESC_TIPO"))
             {
                 value = a[6];
             } else if(fieldName.equals("NATURALEZA"))
             {
                 value = a[7];
             } else if(fieldName.equals("DESC_NATURA"))
             {
                 value = a[8];
             } else if(fieldName.equals("PROYECTO"))
             {
                 value = a[9];
             } else if(fieldName.equals("EJES_TEMATICOS"))
             {
                 value = a[10]; 
             } else if(fieldName.equals("DESC_EJES")){
                 value = a[11];
             }else if(fieldName.equals("PERSONA_CONTACTO")){
                 value = a[12];
             }else if(fieldName.equals("DIRECCION_CONTACTO")){
                 value = a[13];
             }else if(fieldName.equals("TELEFONO_CONTACTO")){
                 value = a[14];
             }else if(fieldName.equals("POBLACION")){
                 value = a[15];
             }else if(fieldName.equals("DESC_POBLA")){
                 value = a[16];
             }else if(fieldName.equals("CONDICION")){
                 value = a[17];
             }else if(fieldName.equals("DESC_CONDICION")){
                 value = a[18];
             }else if(fieldName.equals("ETNIA")){
                 value = a[19];
             }else if(fieldName.equals("NUMERO_HOMBRES")){
                 value = a[20];
             }else if(fieldName.equals("NUMERO_MUJERES")){
                 value = a[21];
             }else if(fieldName.equals("VALOR_ACTIVIDAD")){
                 value = a[22];
             }else if(fieldName.equals("ASESOR")){
                 String codUsuario = (String)a[23]; 
                 value = obtenerUsuario(codUsuario) ;
             }else if(fieldName.equals("COD_CLINICA")){
                value =  a[24]; 
             }else if(fieldName.equals("DESC_CLINICA")){
                value =  a[25]; 
             }
                 
             return value;
         }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

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

     public void setGeneroReporte(boolean generoReporte) {
         this.generoReporte = generoReporte;
     }

     public boolean isGeneroReporte() {
         return generoReporte;
     }

     public void setIndex(int index) {
         this.index = index;
     }

     public int getIndex() {
         return index;
     }
     
    public void setLstActividadEducativa(List lstActividadEducativa) {
        this.lstActividadEducativa = lstActividadEducativa;
    }

    public List getLstActividadEducativa() {
        return lstActividadEducativa;
    }

    //-----------------------------------------------------------------------
    //  Bot�n Secundario
    //-----------------------------------------------------------------------
  
    public String volverInicio()
    {
        FacesUtils.resetManagedBean("reporteActividadesEducativasBean");
        return "home";
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


     public void generarReporteActividadesEducativas()
     {
         index = -1;
         generoReporte = false;
         try
         {
             lstActividadEducativa = serviceLocator.getClinicoService().getReporteActividadesEducativas(fechaInicial, fechaFinal, getClinica().getCclncodigo());
             
             if(lstActividadEducativa != null && !lstActividadEducativa.isEmpty())
             {
                 java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteActividadesEducativas.jasper");
                /* java.net.URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                 java.net.URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                 java.net.URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");
                 if(url != null)
                 {
                     Map parameters = new HashMap();
                     parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                     parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                     parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                     parameters.put("FECHA", new Date());
                     parameters.put("CENTRO", getClinica().getCclcnombre());
                     parameters.put("FECHA_INICIAL", fechaInicial);
                     parameters.put("FECHA_FINAL", fechaFinal);
                     generoReporte = true;
                     JasperReport report = (JasperReport)JRLoader.loadObject(url);
                     byte bytes[] = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                     PdfServletUtils.showPdfDocument(bytes, (new StringBuilder()).append("AntecedentesGinecologicos").append(Calendar.getInstance().getTimeInMillis()).append(".pdf").toString(), false);
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
                                                   "reporteActividadesEducativas" + 
                                                   ".xls", false);

                   generoReporte = true;
                 }
              
                 
                 
                 
                 
             } else
             {
                 FacesUtils.addErrorMessage("No existen resultados con esos criterios de busqueda");
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
             FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar el reporte ").append(e.getMessage()).toString());
         }
       
     }


  
}
