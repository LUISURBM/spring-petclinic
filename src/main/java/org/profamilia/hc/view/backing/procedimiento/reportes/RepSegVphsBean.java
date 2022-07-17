//=======================================================================
// ARCHIVO RepSegVphsBean.java
// FECHA CREACI�N: 13/09/2010 - 29/08/2013
// AUTOR: Jhon Carranza Silva - Carlos Andres Vargas Roa
// Descripci�n: Reporte correspondiente al seguimineto de las citologias
// que se entregan a los diferentes laboratorios.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento.reportes;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chdetaentvph;
import org.profamilia.hc.model.dto.Chentregavph;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RepSegVphsBean
//=======================================================================

public class RepSegVphsBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Date fechaInicial;

    private Date fechaFinal;

    private Date fechaEnvio;

    private boolean generoReporte;

    private boolean generoReporte_CE;

    private String tipoLectura;

    private String tipoReporte;

    private List listaVphs = new ArrayList();

    private int index = -1;

    private boolean generarArch;
    
    String NUMERO_FAC;

    String archivo;
    
    Long secList = 0L;

    public RepSegVphsBean() {
    }

    public void init() {
        generoReporte = false;
        generoReporte_CE = false;
        listaVphs = new ArrayList();
        tipoReporte = "CE";
        generarArch = false; 
    }

    // ACTIONS

     /**
      * @param jrField
      * @return
      */
     public Object getFieldValue(JRField jrField) {
        
         Object value = null;
         String fieldName = jrField.getName();
         Object[] a = new Object[listaVphs.size()];
         a = (Object[])listaVphs.get(index);

         if (this.tipoReporte.equalsIgnoreCase("CE")) {
             if (fieldName.equals("FORMATO")) {
                 value = (BigDecimal)a[0];
                 return value;
             }
             if (fieldName.equals("NUMERO")) {
                 value = (BigDecimal)a[9];
                 return value;
             }
             if (fieldName.equals("FECHA_REG")) {
                 value = (Date)a[1];
                 return value;
             } else if (fieldName.equals("FECHA_TOMA")) {
                 value = (Date)a[2];
                 return value;
             } else if (fieldName.equals("IDENTIFICACION")) {
                 value = (String)a[3] + " " + (BigDecimal)a[4];
                 return value;
             } else if (fieldName.equals("USUARIO")) {
                 value = (String)a[5] + " " + (((String)a[6] == null) ? "" : (String)a[6]) + 
                         " " + (String)a[7] + " " + 
                         (((String)a[8] == null) ? "" : (String)a[8]);
                 return value;
             } else if (fieldName.equals("PROFESIONAL_TOMA")) {
                 value = (String)a[10];
                 return value;
             }
         } else {
             if (fieldName.equals("CCINCONSEC")) {
                 value = formatearDecimal((BigDecimal)a[11]) ;
                 return value;
             } else if (fieldName.equals("CCINCLINIC")) {
                 value = formatearDecimal((BigDecimal)a[12]);
                 return value;
             } else if (fieldName.equals("CCICTIPIDE")) {
                 value = (String)a[13];
                 return value;
             } else if (fieldName.equals("CCIANUMIDE")) {
                 value = formatearDecimal((BigDecimal)a[14]);
                 return value;
             } else if (fieldName.equals("CCICPRINOM")) {
                 value = (String)a[15];
                 return value;
             } else if (fieldName.equals("CCICSEGNOM")) {
                 value = (String)a[16];
                 return value;
             } else if (fieldName.equals("CCICPRIAPE")) {
                 value = (String)a[17];
                 return value;
             } else if (fieldName.equals("CCICSEGAPE")) {
                 value = (String)a[18];
                 return value;
             } else if (fieldName.equals("CCINEDAD")) {
                 value = formatearDecimal((BigDecimal)a[19]);
                 return value;
             } else if (fieldName.equals("CCICTIPAFI")) {
                 value = (String)a[20];
                 return value;
             } else if (fieldName.equals("CCICASEGUR")) {
                 value = (String)a[21];
                 return value;
             } else if (fieldName.equals("CCIDFECCIT")) {
                 value = formatearCampo((Date)a[22]);
                 return value;
             } else if (fieldName.equals("NUMERO_FAC")) {
                 value = obtenerDatosReporte((BigDecimal)a[23]);
                 return value;
             } else if (fieldName.equals("CCINTIPDOC")) {
                 value = formatearDecimal((BigDecimal)a[24]);
                 return value;
             } else if (fieldName.equals("CCINNUMDOC")) {
                 value = formatearDecimal((BigDecimal)a[25]);
                 return value;
             } else if (fieldName.equals("CTMCTOMADA")) {
                 value = (String)a[26];
                 return value;
             } else if (fieldName.equals("CTMCNOMTOM")) {
                 value = (String)a[27];
                 return value;
             } else if (fieldName.equals("CTMCESQUEM")) {
                 value = (String)a[28];
                 return value;
             } else if (fieldName.equals("CTMDULTMEN")) {
                 value = formatearCampo((Date)a[29]);
                 return value;
             } else if (fieldName.equals("CTMDULTPAR")) {
                 value = formatearCampo((Date)a[30]);
                 return value;
             } else if (fieldName.equals("CTMNGESTAC")) {
                 value = formatearDecimal((BigDecimal)a[31]);
                 return value;
             } else if (fieldName.equals("CTMNPARTOS")) {
                 value = formatearDecimal((BigDecimal)a[32]);
                 return value;
             } else if (fieldName.equals("CTMNABORTO")) {
                 value = formatearDecimal((BigDecimal)a[33]);
                 return value;
             } else if (fieldName.equals("CTMCEMBARA")) {
                 value = (String)a[34];
                 return value;
             } else if (fieldName.equals("CTMNEDAREL")) {
                 value = formatearDecimal((BigDecimal)a[35]);
                 return value;
             } else if (fieldName.equals("CTMCMETPLA")) {
                 value = (String)a[36];
                 return value;
             } else if (fieldName.equals("CTMCOTRMET")) {
                 value = (String)a[37];
                 return value;
             } else if (fieldName.equals("CTMNTIEMET")) {
                 value = formatearDecimal((BigDecimal)a[38]);
                 return value;
             } else if (fieldName.equals("CTMDULTCIT")) {
                 value = formatearCampo((Date)a[39]);
                 return value;
             } else if (fieldName.equals("CTMCULTRES")) {
                 value = (String)a[40];
                 return value;
             } else if (fieldName.equals("CTMCOTRHAL")) {
                 value = (String)a[41];
                 return value;
             } else if (fieldName.equals("CTMCPNINGU")) {
                 value = (String)a[42];
                 return value;
             } else if (fieldName.equals("CTMCPCAUTE")) {
                 value = (String)a[43];
                 return value;
             } else if (fieldName.equals("CTMDPCAUTE")) {
                 value = formatearCampo((Date)a[44]);
                 return value;
             } else if (fieldName.equals("CTMCPHISTE")) {
                 value = (String)a[45];
                 return value;
             } else if (fieldName.equals("CTMDPHISTE")) {
                 value = formatearCampo((Date)a[46]);
                 return value;
             } else if (fieldName.equals("CTMCPCONIZ")) {
                 value = (String)a[47];
                 return value;
             } else if (fieldName.equals("CTMDPCONIZ")) {
                 value = formatearCampo((Date)a[48]);
                 return value;
             } else if (fieldName.equals("CTMCPRADIO")) {
                 value = (String)a[49];
                 return value;
             } else if (fieldName.equals("CTMDPRADIO")) {
                 value = formatearCampo((Date)a[50]);
                 return value;
             } else if (fieldName.equals("CTMCPBIOPS")) {
                 value = (String)a[51];
                 return value;
             } else if (fieldName.equals("CTMDPBIOPS")) {
                 value = formatearCampo((Date)a[52]);
                 return value;
             } else if (fieldName.equals("CTMCPCRIOT")) {
                 value = (String)a[53];
                 return value;
             } else if (fieldName.equals("CTMDPCRIOT")) {
                 value = formatearCampo((Date)a[54]);
                 return value;
             } else if (fieldName.equals("CTMCPATA")) {
                 value = (String)a[55];
                 return value;
             } else if (fieldName.equals("CTMDPATA")) {
                 value = formatearCampo((Date)a[56]);
                 return value;
             } else if (fieldName.equals("CTMCPOTRO")) {
                 value = (String)a[57];
                 return value;
             } else if (fieldName.equals("CTMDPOTRO")) {
                 value = formatearCampo((Date)a[58]);
                 return value;
             } else if (fieldName.equals("CTMCPDOTRO")) {
                 value = (String)a[59];
                 return value;
             } else if (fieldName.equals("CTMCPVAPOR")) {
                 value = (String)a[60];
                 return value;
             } else if (fieldName.equals("CTMDPVAPOR")) {
                 value = formatearCampo((Date)a[61]);
                 return value;
             } else if (fieldName.equals("CTMCPHORMO")) {
                 value = (String)a[62];
                 return value;
             } else if (fieldName.equals("CTMDPHORMO")) {
                 value = formatearCampo((Date)a[63]);
                 return value;
             } else if (fieldName.equals("CTMCASPCUE")) {
                 value = (String)a[64];
                 value = value.toString().replace(",","|");
                 return value;
             } else if (fieldName.equals("CTMCOBSTOM")) {
                 value = (String)a[65];
                 if (value != null) {
                     value = value.toString().replace(","," ").replace("\""," ").replace("\n"," ");
                 }
                 return value;
             } else if (fieldName.equals("CTMCCOMVPH")) {
                 value = (String)a[66];
                 return value;
             } else if (fieldName.equals("CTMCLACTAN")) {
                 value = (String)a[67];
                 return value;
             } else if (fieldName.equals("CTMNNUMERO")) {
                 value = formatearDecimal((BigDecimal)a[68]);
                 return value;
             }
         }
         return value;
    }

    public String obtenerDatosReporte(BigDecimal codigo) {
        String numfact = ""; 
        if (codigo != null) {
            numfact = codigo.toString();
            if (numfact != null && numfact.length() > 6) {
                numfact = numfact.substring(numfact.length() - 6, numfact.length());
            }
        }
        return numfact; 
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < listaVphs.size());
    }

    public void generarListaEntrega() {
        index = -1;
        generoReporte = false;
        generoReporte_CE = false;

        Calendar fechaActual = GregorianCalendar.getInstance();
        fechaActual.set(Calendar.HOUR_OF_DAY, 0);
        fechaActual.set(Calendar.MINUTE, 0);
        fechaActual.set(Calendar.SECOND, 0);
        fechaActual.set(Calendar.MILLISECOND, 0);

        if (fechaFinal.compareTo(fechaInicial) < 0) {
            FacesUtils.addInfoMessage(MSG_VALIDACION_FECHA_MENOR);
        } else if (fechaEnvio.compareTo(fechaActual.getTime()) < 0) {
            FacesUtils.addInfoMessage("Fecha de Envio: " + MSG_VAL_FECHA_ACTUAL);
        } else {
            tipoReporte = "CE";
            try {
                tipoLectura = "PL"; // Primera Lectura.
                listaVphs = 
                       this.serviceLocator.getClinicoService().getVphLectura(fechaInicial, fechaFinal, 
                                                                                   this.getClinica().getCclncodigo().intValue(), 
                                                                                   this.tipoLectura);
            } catch (ModelException de) {
               FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
            } catch (Exception e) {
               FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            }

            if (listaVphs.isEmpty()) {
               FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            } else {
                try {
                    URL url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaVphs.jasper");
                    URL url_profamilia = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                    URL url_super_horizontal = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                    URL url_super_vertical = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                    if (url != null) {
                        Cpprofesio profe = 
                           this.serviceLocator.getClinicoService().getProfesionalesLectura(this.getClinica().getCclncodigo(), 
                                                                                               null);
                        Set listChdatosvph = new HashSet();
                        for (Object vph: (List)listaVphs) {
                             Object[] a = (Object[])vph;
                             Chdetaentvph detalle = new Chdetaentvph();
                             BigDecimal consecutivo;
                             if (a[0] == null) {
                                 consecutivo = new BigDecimal(0);
                             } else {
                                 consecutivo = (BigDecimal) a[0];
                             }
                             detalle.getComp_id().setHdenvph(consecutivo.longValue());
                             detalle.setHdecetapa(IConstantes.VPH_ENV_LECTURA);
                             detalle.setHdecoperador(this.getUsuarioSystem().getCurcusuari());
                             detalle.setHdedfechamod(new Date());
                             detalle.setHdenclinica(this.getClinica().getCclncodigo());
                             listChdatosvph.add(detalle);
                        }
                        
                        Chentregavph entregavph = new Chentregavph();
                        entregavph.setHevdfechaenvio(fechaEnvio);
                        entregavph.setHevcoperador(this.getUsuarioSystem().getCurcusuari());
                        entregavph.setHevdfechamod(new Date());
                        entregavph.setHevnclinica(this.getClinica().getCclncodigo());
                        entregavph.setHevnlablectura(profe.getCpfncodigo().longValue());
                        entregavph.setChdetaentvphs(listChdatosvph);
           
                        secList = 
                            this.serviceLocator.getClinicoService().saveListaEntregaVph(entregavph);

                        Map reportParams = new HashMap();
                        reportParams.put("CENTRO", this.getClinica().getCclcnombre());
                        reportParams.put("COD_CENTRO", this.getClinica().getCclncodigo());
                        reportParams.put("FECHA_ENVIO", fechaEnvio);
                        reportParams.put("LABORATORIO", profe.getCpfcnombre());
                        reportParams.put("ID_LISTADO", secList);
                        reportParams.put("IMAGE_PROFAMILIA", url_profamilia);
                        reportParams.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                        reportParams.put("IMAGE_SUPER_VERTICAL", url_super_vertical);

                        archivo = "CT" + formatearCampoFe(new Date()) + "_" + this.getClinica().getCclncodigo() 
                                  + "_" + listaVphs.size() + "_" + secList.intValue();
                        JasperReport report = (JasperReport)JRLoader.loadObject(url);
                        byte[] bytes;
                        bytes = JasperRunManager.runReportToPdf(report, reportParams, 
                                                                (JRDataSource)this);
                                                                
                        PdfServletUtils.showPdfDocument(bytes, archivo + ".pdf", false);

                        generoReporte_CE = true;
                    }
                } catch (ModelException me) {
                    me.printStackTrace();
                    FacesUtils.addErrorMessage("No se genero el reporte " + me.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No se genero el reporte " + e.getMessage());
                }
                
                if (generoReporte_CE  
                    && this.getClinica().getCclncodigo() != 36 && this.getClinica().getCclncodigo() != 39
                    && this.getClinica().getCclncodigo() != 41 && this.getClinica().getCclncodigo() != 76 
                    && this.getClinica().getCclncodigo() != 35 && this.getClinica().getCclncodigo() != 34 
                    && this.getClinica().getCclncodigo() != 38) {
//                    this.generarArchivoCsv();
                    generarArch = true;
                }
            }
        }
    }

    public void generarArchivoCsv() {
       index = -1;
       tipoReporte = "LB";
       if (listaVphs.isEmpty()) {
           FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
       } else {
           try {
               URL url = 
                   FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaCitologiaLaboratorio2.jasper");

               if (url != null) {
                   Map parameters = new HashMap();
                   JasperReport report = (JasperReport)JRLoader.loadObject(url);

                   JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, 
                                             (JRDataSource)this);
                   ByteArrayOutputStream baos = new ByteArrayOutputStream();
                   JRCsvExporter exporter = new JRCsvExporter();
                   exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, jasperPrint);
                   exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, baos);
                   exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ",");
                   exporter.exportReport();
                   CsvServletUtils.showCsvDocument(baos.toByteArray(), archivo + ".csv", false);

/*                   if (Ftp.conectar("192.168.25.14","citologias","pr0f42018")) {
                       Ftp.cambiarDirectorio("enviados");
                       Ftp.subirArchivo(baos.toByteArray(), archivo + ".csv" );
                       Ftp.cambiarDirectorio("..");
                       Ftp.cambiarDirectorio("historico");
                       Ftp.subirArchivo(baos.toByteArray(), archivo + ".csv" );
                       Ftp.desconectar();
                   }
*/                   generoReporte = true;
                   generoReporte_CE = false;

               }
           } catch (Exception e) {
               e.printStackTrace();
               FacesUtils.addErrorMessage("No se genero el archivo " + e.getMessage());
           }
        }
    }

    //ACCESSORS

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

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
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


    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }


    public void setGenerarArch(boolean generarArch) {
        this.generarArch = generarArch;
    }

    public boolean isGenerarArch() {
        return generarArch;
    }
}

