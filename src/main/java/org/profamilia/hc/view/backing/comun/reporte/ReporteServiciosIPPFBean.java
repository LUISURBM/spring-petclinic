package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
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
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.dto.Clcomserv;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;
import org.profamilia.hc.view.util.CsvServletUtils;


public class ReporteServiciosIPPFBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private boolean generoReporte;
    
    private boolean generoDetallado;

    private List<Object[]> lstReporte;

    private List<Clcomserv> lstServicio;

    private int index;


    private String CLINICA;
    private Date FECHA_CONSULTA;
    private BigDecimal TIPO_DOC;
    private String SERVICIO_IPPF;
    private String SERVICIO;
    private String GENERO;
    private String PREFIJO_SERVICIO;
    private String SUFIJO_SERVICIO;
    private BigDecimal EDAD;
    private BigDecimal CANTIDAD;
    private BigDecimal VALOR_SERVICIO;
    private String USUARIO_REG;
    private String CODIGO_UID;
    private String ATRIBUTO;
    private BigDecimal NUMERO_SERVICIOS;
    private String USUARIO_GENERA;
    private Date FECHA_ACTUALIZACION;
    private String COMENTARIO;
    private String SEGUIMIENTO;
    private String DESCRIPCION_SERVICIO;
    private String TIPO_ORGNIT;
    private String PAQUETE;
    private String INTEXT;
    private String SUMCUE;

    private String nombSalida;

    public ReporteServiciosIPPFBean() {
    }

    public void init() {
        lstServicio = new ArrayList<Clcomserv>();
        generoDetallado = false;
    }

    /**
     * @return
     */

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
        String fieldName = jrField.getName();
        obtenerDatosReporte(index);

        if (fieldName.equals("CLINICA"))
            value = CLINICA;

        else if (fieldName.equals("FECHA_CONSULTA"))
            value = FECHA_CONSULTA;
        else if (fieldName.equals("TIPO_DOC"))
            value = TIPO_DOC;
        else if (fieldName.equals("GENERO"))
            value = GENERO;
        else if (fieldName.equals("SERVICIO"))
            value = SERVICIO;
        else if (fieldName.equals("SERVICIO_IPPF"))
            value = SERVICIO_IPPF;
        else if (fieldName.equals("CANTIDAD"))
            value = CANTIDAD;
        else if (fieldName.equals("VALOR_SERVICIO"))
            value = VALOR_SERVICIO;
        else if (fieldName.equals("USUARIO_REG"))
            value = USUARIO_REG;
        else if (fieldName.equals("PREFIJO_SERVICIO"))
            value = PREFIJO_SERVICIO;
        else if (fieldName.equals("SUFIJO_SERVICIO"))
            value = SUFIJO_SERVICIO;
        else if (fieldName.equals("EDAD"))
            value = EDAD;
        else if (fieldName.equals("CODIGO_UID"))
            value = CODIGO_UID;
        else if (fieldName.equals("ATRIBUTO"))
            value = ATRIBUTO;
        else if (fieldName.equals("NUMERO_SERVICIOS"))
            value = NUMERO_SERVICIOS;
        else if (fieldName.equals("USUARIO_GENERA"))
            value = USUARIO_GENERA;
        else if (fieldName.equals("FECHA_ACTUALIZACION"))
            value = FECHA_ACTUALIZACION;
        else if (fieldName.equals("COMENTARIO"))
            value = COMENTARIO;
        else if (fieldName.equals("SEGUIMIENTO"))
            value = SEGUIMIENTO;
        else if (fieldName.equals("DESCRIPCION_SERVICIO"))
            value = DESCRIPCION_SERVICIO;
        else if (fieldName.equals("TIPO_ORGNIT"))
            value = TIPO_ORGNIT;
        else if (fieldName.equals("PAQUETE"))
            value = PAQUETE;
        else if (fieldName.equals("INTEXT"))
            value = INTEXT;
        else if (fieldName.equals("SUMCUE"))
            value = SUMCUE;

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

    public void obtenerDatosReporte(int indexAux) {
        CLINICA = null;
        FECHA_CONSULTA = null;
        TIPO_DOC = null;
        SERVICIO_IPPF = null;
        SERVICIO = null;
        PREFIJO_SERVICIO = null;
        CANTIDAD = null;
        VALOR_SERVICIO = null;
        USUARIO_REG = null;
        EDAD = null;
        SUFIJO_SERVICIO = " ";
        GENERO = null;
        CODIGO_UID = null;
        ATRIBUTO = null;
        NUMERO_SERVICIOS = new BigDecimal(0);
        USUARIO_GENERA = null;
        FECHA_ACTUALIZACION = null;
        COMENTARIO = null;
        SEGUIMIENTO = null;
        DESCRIPCION_SERVICIO = null;
        TIPO_ORGNIT = null;
        PAQUETE = null;
        INTEXT = null;
        SUMCUE = null;

        Object[] aux = lstReporte.get(indexAux);
        if (aux != null) {
            if (aux[0] != null) 
                SERVICIO = (aux[0].toString());
            if (aux[1] != null) 
                GENERO = (aux[1].toString());
            if (aux[2] != null) 
                EDAD = new BigDecimal(aux[2].toString());
            if (EDAD != null && GENERO != null) 
                CODIGO_UID = (String)(aux[11].toString());
            if (aux[3] != null) 
                FECHA_CONSULTA = (Date)(aux[3]);
            if (aux[4] != null) 
                SERVICIO_IPPF = (aux[4].toString());
            if (aux[5] != null) 
                PREFIJO_SERVICIO = (aux[5].toString());
            if (aux[6] != null) 
                SUFIJO_SERVICIO = (aux[6].toString());
            if (aux[7] != null) 
                CLINICA = (aux[7].toString());
            if (aux[8] != null) 
                NUMERO_SERVICIOS = new BigDecimal(aux[8].toString());
            if (aux[3] != null) {
                FECHA_ACTUALIZACION = (Date)(aux[3]);
            } else {
                FECHA_CONSULTA = FECHA_ACTUALIZACION;
            }

            ATRIBUTO = "";
            USUARIO_GENERA = "sysadb";
            COMENTARIO = "";
            SEGUIMIENTO = "FALSE";

            if (aux[9] != null) 
                DESCRIPCION_SERVICIO = (String)aux[9];
            if (aux[10] != null)
                TIPO_ORGNIT = (String)aux[10];
            if (aux[12] != null)
                PAQUETE = (String)aux[12];
            if (aux[13] != null)
                INTEXT = (String)aux[13];
            if (aux[14] != null)
               SUMCUE = (String)aux[14];
        }
    }


    public void generarReporte() {
        index = -1;
        generoReporte = false;
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd_hhmmss"); 
        nombSalida = "ServiciosIppf" + dt.format(new Date());
        generoReporte = false;

        if (lstReporte != null && !lstReporte.isEmpty()) {

            try {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteServiciosIppf.jasper");
                java.net.URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                java.net.URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                java.net.URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", getClinica().getCclcnombre());
                    parameters.put("FECHA_INICIAL", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);

                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRCsvExporter exporter = new JRCsvExporter();
                    exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, baos);
                    exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ",");

                    exporter.exportReport();
                    CsvServletUtils.showCsvDocument(baos.toByteArray(), nombSalida + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".csv", false);
                    generoReporte = true;

                    FacesUtils.addInfoMessage("Mensaje generado exitosamente");
                }
            } catch (Exception e) {
                FacesUtils.addErrorMessage("No se genero el reporte " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }
    }
    
    public void generarReporteDet() {
        index = -1;
        Integer wivefarser = 4;
        generoReporte = false;
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd_hhmmss"); 
        nombSalida = "reporteServiciosIppfDet" + dt.format(new Date());

        List<Object[]> lstReporteAux = null;
        try {
            lstReporteAux = 
                    this.serviceLocator.getClinicoService().getReporteServiciosIppf(fechaInicial, 
                                                                                    fechaFinal,wivefarser);

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstReporteAux != null && !lstReporteAux.isEmpty()) {
            lstReporte = new ArrayList<Object[]>();
            lstReporte.addAll(lstReporteAux);
/*            String servicioIppf = "";
            
            for (Object[] objeto: lstReporteAux) {
                servicioIppf = (String)objeto[4];
                if (servicioIppf != null) {
*/                
                    /* Para adicionar si violencia */
/*                    if (objeto[4].toString().equals("2181110141000")) {
                        Object[] temaAux = new Object[15];
                        temaAux[0] = (objeto[0].toString());
                        temaAux[1] = objeto[1].toString();
                        temaAux[2] = objeto[2].toString();
                        temaAux[3] = objeto[3];
                        temaAux[4] = objeto[4].toString();
                        temaAux[5] = "REF";
                        temaAux[6] = objeto[6].toString();
                        temaAux[7] = objeto[7].toString();
                        temaAux[8] = objeto[8].toString();
                        temaAux[9] = objeto[9].toString();
                        temaAux[10] = objeto[10].toString();
                        temaAux[11] = objeto[11].toString();
                        temaAux[12] = objeto[12].toString();
                        temaAux[13] = objeto[13].toString();
                        temaAux[14] = objeto[14].toString();
                        lstReporte.add(temaAux);
                        
                    }
*/
/*                    List<Clcomserv> lstServicio1 = new ArrayList<Clcomserv>();
                    try {
                        lstServicio1 = 
                            this.serviceLocator.getClinicoService().getCodigoServiIppf(servicioIppf);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (lstServicio1 != null && !lstServicio1.isEmpty()) {
                        for (Clcomserv servicio: lstServicio1) {
                            Object[] temaAux = new Object[15];
                            temaAux[0] = (objeto[0].toString());
                            temaAux[1] = objeto[1].toString();
                            temaAux[2] = objeto[2].toString();
                            temaAux[3] = objeto[3];
                            temaAux[4] = servicio.getCodigonuevo();
                            temaAux[5] = objeto[5].toString();
                            temaAux[6] = objeto[6].toString();
                            temaAux[7] = objeto[7].toString();
                            temaAux[8] = objeto[8].toString();
                            temaAux[9] = objeto[9].toString();
                            temaAux[10] = objeto[10].toString();
                            temaAux[11] = objeto[11].toString();
                            temaAux[12] = objeto[12].toString();
                            temaAux[13] = objeto[13].toString();
                            temaAux[14] = objeto[14].toString();
                            lstReporte.add(temaAux);
   //                            objeto[4] = servicio.getCodigonuevo();
    //                            lstReporte.add(objeto);
                        }
                    }
                }
            }
*/
            try {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteServiciosIppfDet.jasper");
                java.net.URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                java.net.URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                java.net.URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", getClinica().getCclcnombre());
                    parameters.put("FECHA_INICIAL", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);

                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRCsvExporter exporter = new JRCsvExporter();
                    exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, baos);
                    exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ",");

                    exporter.exportReport();
                    CsvServletUtils.showCsvDocument(baos.toByteArray(), nombSalida + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".csv", false);
                    generoReporte = true;
                    generoDetallado = true;

                    FacesUtils.addInfoMessage("Mensaje generado exitosamente");
                }
            } catch (Exception e) {
                FacesUtils.addErrorMessage("No se genero el reporte " + e.getMessage());
                e.printStackTrace();
            }
            
        } else {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }
    }


    public void setGeneroDetallado(boolean generoDetallado) {
        this.generoDetallado = generoDetallado;
    }

    public boolean isGeneroDetallado() {
        return generoDetallado;
    }


    public void setNombSalida(String nombSalida) {
        this.nombSalida = nombSalida;
    }

    public String getNombSalida() {
        return nombSalida;
    }
}
