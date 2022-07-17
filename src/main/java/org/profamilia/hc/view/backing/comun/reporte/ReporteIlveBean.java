//=======================================================================
// ARCHIVO Reporte Ilve
// FECHA CREACI�N: 07/10/2015
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Reporte Ilve Solicitado por Medellin (Angela Faria Soto)
//=======================================================================
 package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

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

import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE Reporte Ilve
//=======================================================================
public class ReporteIlveBean extends BaseBean  implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstIVE;




    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE REPORTE
    //-----------------------------------------------------------------------

  



    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ReporteIlveBean() {

    }




    //-----------------------------------------------------------------------
    //  REPORT
    //-----------------------------------------------------------------------
    


         public boolean next()
         {
             index++;
             if(lstIVE != null)
                 return index < lstIVE.size();
             else
                 return false;
         }

    public Object getFieldValue(JRField jrField){
        Object value = null;
        Object a[] = null;
        String fieldName = jrField.getName();
        if(lstIVE.get(index) != null)
            a = (Object[])lstIVE.get(index);


    if (fieldName.equals("TIPO_DOC")) {
       value = a[0];
    } else if (fieldName.equals("NUM_IDEN")) {
       value = a[1];
    } else if (fieldName.equals("NOMBRES")) {
       value = a[2];
    } else if (fieldName.equals("APELLIDOS")) {
       value = a[3];
    } else if (fieldName.equals("FECHA_NAC")) {
       value = a[4];
    } else if (fieldName.equals("EDAD")) {
       value = a[5];
    } else if (fieldName.equals("ESTADO_CIVIL")) {
       value = a[6];
    } else if (fieldName.equals("NIVEL_EDUCATIVO")) {
       value = a[7];
    } else if (fieldName.equals("TELEFONO")) {
       value = a[8];
    } else if (fieldName.equals("CELULAR")) {
       value = a[9];
    } else if (fieldName.equals("ESTRATO")) {
       value = a[10];
    } else if (fieldName.equals("ETNIA")) {
       value = a[11];
    } else if (fieldName.equals("NOMBRE_MUNICIPIO")) {
       value = a[12];
    } else if (fieldName.equals("NOMBRE_DEPAR")) {
       value = a[13];
    } else if (fieldName.equals("AREA_PROCE")) {
       value = a[14];
    } else if (fieldName.equals("TIPO_AFILIACION")) {
       value = a[15];
    } else if (fieldName.equals("DESC_ENTIDAD")) {
       value = a[16];
    } else if (fieldName.equals("NUM_FACTURA")) {
       value = a[17];
    } else if (fieldName.equals("FECHA_CONSULTA")) {
       value = a[18];
    } else if (fieldName.equals("FUR")) {
       value = a[19];
    } else if (fieldName.equals("CAUSAL")) {
       value = a[20];
    } else if (fieldName.equals("ANTE_ABORTO")) {
       value = a[21];
    } else if (fieldName.equals("ANTE_GESTA")) {
       value = a[22];
    } else if (fieldName.equals("ANTE_PARTO")) {
       value = a[23];
    } else if (fieldName.equals("ANTE_PLANI")) {
       Object valor = new Object();
       if(a[24]!=null){
           valor = a[24];
           valor = valor.toString();
           value = valor;
       }
    } else if (fieldName.equals("DIAG_PRINCI")) {
       value = a[25];
    } else if (fieldName.equals("DIAG_REL1")) {
       value = a[26];
    } else if (fieldName.equals("DIAG_REL2")) {
       value = a[27];
    } else if (fieldName.equals("DIAG_REL3")) {
       value = a[28];
    } else if (fieldName.equals("MODO_TERMINACION")) {
       value = a[29];
    } else if (fieldName.equals("SEMANA_EMBARAZO")) {
       value = a[30];
    } else if (fieldName.equals("CLINICA")) {
       value = a[31];
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

    //-----------------------------------------------------------------------
    //  Bot�n Secundario
    //-----------------------------------------------------------------------
  
    public String volverInicio()
    {
        FacesUtils.resetManagedBean("reporteIlveBean");
        return "home";
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


     public void generarReporteIlve()
     {
         index = -1;
         generoReporte = false;
         try
         {
             lstIVE = serviceLocator.getClinicoService().getReporteIlve(fechaInicial, fechaFinal, getClinica().getCclncodigo());
             
             if(lstIVE != null && !lstIVE.isEmpty())
             {
                 java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteIVE.jasper");
               /*  java.net.URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
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
                 }
                 
                 */
                 
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
                                                   "reporteIve" + 
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
