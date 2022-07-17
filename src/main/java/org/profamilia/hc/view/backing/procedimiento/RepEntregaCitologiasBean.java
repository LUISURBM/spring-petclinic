//=======================================================================
// ARCHIVO RepEntregaCitologiasBean.java
// FECHA CREACI�N: 27/09/2010
// AUTOR: Jhon Carranza Silva
// Descripci�n: Reporte correspondiente a la entrega de los resultados de
// la citologia a la usuaria.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.io.ByteArrayOutputStream;

import java.lang.Object;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RepEntregaCitologiasBean
//=======================================================================
public class RepEntregaCitologiasBean extends BaseBean implements JRDataSource {

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

    public RepEntregaCitologiasBean() {
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

        if (this.tipoReporte.equalsIgnoreCase("CE")) {

            if (fieldName.equals("IDLISTADO")) {
                value = (BigDecimal)reporte[0];
                return value;
            }

            if (fieldName.equals("FORMATO")) {
                value = (BigDecimal)reporte[1];
                return value;
            }
            
            if (fieldName.equals("NUMERO")) {
                value = (BigDecimal)reporte[6];
                return value;
            }

            else if (fieldName.equals("FECHA_TOMA")) {
                value = (Date)reporte[2];
                return value;
            }

            else if (fieldName.equals("IDENTIFICACION")) {
                value = (String)reporte[3];
                return value;
            }

            else if (fieldName.equals("USUARIO")) {
                value = (String)reporte[4];
                return value;
            }

            else if (fieldName.equals("FECHA_ENTREGA")) {
                value = (Date)reporte[5];
                return value;
            }

        } else {


            if (fieldName.equals("IDLISTADO")) {
                value = (BigDecimal)reporte[0];
                return value;
            }

            else if (fieldName.equals("FECHA_ENVIO_LECT1")) {
                value = (Date)reporte[1];
                return value;
            }

            else if (fieldName.equals("LAB_LECT1")) {
                value = (BigDecimal)reporte[2] + " - " + (String)reporte[3];
                return value;
            }

            else if (fieldName.equals("FECHA_ENVIO_LECT2")) {
                value = (Date)reporte[4];
                return value;
            }

            else if (fieldName.equals("LAB_LECT2")) {
                value = (BigDecimal)reporte[5] + " - " + (String)reporte[6];
                return value;
            }

            else if (fieldName.equals("CENTRO_LISTADO")) {
                value = (BigDecimal)reporte[7] + " - " + (String)reporte[8];
                return value;
            }

            if (fieldName.equals("FORMATO")) {
                value = (BigDecimal)reporte[9];
                return value;
            }
            
            if (fieldName.equals("NUMERO")) {
                value = (BigDecimal)reporte[16];
                return value;
            }

            else if (fieldName.equals("FECHA_TOMA")) {
                value = (Date)reporte[10];
                return value;
            }

            else if (fieldName.equals("IDENTIFICACION")) {
                value = (String)reporte[11];
                return value;
            }

            else if (fieldName.equals("USUARIO")) {
                value = (String)reporte[12];
                return value;
            }

            else if (fieldName.equals("ETAPA")) {
                value = (String)reporte[13];
                return value;
            }

            else if (fieldName.equals("RES_LECT1")) {
                value = (String)reporte[14];
                return value;
            }

            else if (fieldName.equals("RES_LECT2")) {
                value = (String)reporte[15];
                return value;
            }


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
        generoReporte = false;
        generoReporte_CE = false;


        Calendar fechaActual = GregorianCalendar.getInstance();
        fechaActual.set(Calendar.HOUR_OF_DAY, 0);
        fechaActual.set(Calendar.MINUTE, 0);
        fechaActual.set(Calendar.SECOND, 0);
        fechaActual.set(Calendar.MILLISECOND, 0);

        if (fechaFinal.compareTo(fechaInicial) < 0) {
            FacesUtils.addInfoMessage(MSG_VALIDACION_FECHA_MENOR);
        } else {

            if (this.tipoReporte.equalsIgnoreCase("CE")) {

                try {

                    listaCitologias = 
                            this.serviceLocator.getClinicoService().getCitologiasEntregadas(fechaInicial, 
                                                                                            fechaFinal, 
                                                                                            this.getClinica().getCclncodigo().intValue());

                } catch (ModelException de) {
                    FacesUtils.addErrorMessage(null, de.getMessage(), 
                                               MSG_NO_CONSULTA);
                } catch (Exception e) {
                    FacesUtils.addErrorMessage(null, e.getMessage(), 
                                               MSG_NO_CONSULTA);
                }

                if (listaCitologias.isEmpty()) {
                    FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
                } else {

                    try {

                       URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteCitologiasEntregas.jasper");
                        URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
                        URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
                        URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
                        if (url != null) {

                            Map reportParams = new HashMap();
                            reportParams.put("CENTRO", 
                                             this.getClinica().getCclcnombre());
                            reportParams.put("COD_CENTRO", 
                                             this.getClinica().getCclncodigo());
                            reportParams.put("FECHA_INICIAL", fechaInicial);
                            reportParams.put("FECHA_FINAL", fechaFinal);
                            reportParams.put("IMAGE_PROFAMILIA", url_profamilia);
                            reportParams.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                            reportParams.put("IMAGE_SUPER_VERTICAL", url_super_vertical);

                            byte[] bytes;
                            
                            JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                            bytes = 
                                    JasperRunManager.runReportToPdf(report,
                                                                    reportParams, 
                                                                    (JRDataSource)this);
                            PdfServletUtils.showPdfDocument(bytes, 
                                                            "List_Entrega_Citologias" + 
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

            } else {


                try {

                    listaCitologias = 
                            this.serviceLocator.getClinicoService().getSeguimientoCitologias(fechaInicial, 
                                                                                             fechaFinal, this.getClinica().getCclncodigo());

                } catch (ModelException de) {
                    FacesUtils.addErrorMessage(null, de.getMessage(), 
                                               MSG_NO_CONSULTA);
                } catch (Exception e) {
                    FacesUtils.addErrorMessage(null, e.getMessage(), 
                                               MSG_NO_CONSULTA);
                }

                if (listaCitologias.isEmpty()) {
                    FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
                } else {


                    try {

                       URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteSeguimientoCitologias.jasper");


                        if (url != null) {

                            Map parameters = new HashMap();
                            
                            JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                            
                            JasperPrint jasperPrint = 
                                JasperFillManager.fillReport(report, 
                                                             parameters, 
                                                             (JRDataSource)this);
                            ByteArrayOutputStream baos = 
                                new ByteArrayOutputStream();
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
                                                            "List_Seguimiento_Citologias" + 
                                                            Calendar.getInstance().getTimeInMillis() + 
                                                            ".xls", false);
                            generoReporte = true;
                            generoReporte_CE = false;


                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        FacesUtils.addErrorMessage("No se genero el reporte " + 
                                                   e.getMessage());
                    }


                }


            }

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
}

