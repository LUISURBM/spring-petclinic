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

import org.profamilia.hc.model.dto.Clcomserv;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;
import org.profamilia.hc.view.util.CsvServletUtils;


public class ReporteEnvioEmailBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private List<Object[]> lstReporte;
    private int index;

    private BigDecimal CONSECUTIVO;
    private BigDecimal CONSULTA;
    private Date FECHA_CONSULTA;
    private String SERVICIO;
    private String NOMBRE_SERVICIO;
    private BigDecimal CLINICA;
    private String NOMBRE_CLINICA;
    private String CORREO_ELECTRONICO;
    private String TIPO_CORREO;
    private String ETAPA;
    private String ERROR;
    private Date FECHA_REGISTRO;
    private String USUARIO_REGISTRO;
    private Date FECHA_ENVIO;
    private String USUARIO_ENVIA;

    private String nombSalida;

    public ReporteEnvioEmailBean() {
    }

    public void init() {
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

        if (fieldName.equals("CONSECUTIVO"))
            value = CONSECUTIVO;
        else if (fieldName.equals("CONSULTA"))
            value = CONSULTA;
        else if (fieldName.equals("FECHA_CONSULTA"))
            value = FECHA_CONSULTA;
        else if (fieldName.equals("SERVICIO"))
            value = SERVICIO;
        else if (fieldName.equals("NOMBRE_SERVICIO"))
            value = NOMBRE_SERVICIO;
        else if (fieldName.equals("CLINICA"))
            value = CLINICA;
        else if (fieldName.equals("NOMBRE_CLINICA"))
            value = NOMBRE_CLINICA;
        else if (fieldName.equals("CORREO_ELECTRONICO"))
            value = CORREO_ELECTRONICO;
        else if (fieldName.equals("TIPO_CORREO"))
            value = TIPO_CORREO;
        else if (fieldName.equals("ETAPA"))
            value = ETAPA;
        else if (fieldName.equals("ERROR"))
            value = ERROR;
        else if (fieldName.equals("FECHA_REGISTRO"))
            value = FECHA_REGISTRO;
        else if (fieldName.equals("USUARIO_REGISTRO"))
            value = USUARIO_REGISTRO;
        else if (fieldName.equals("FECHA_ENVIO"))
            value = FECHA_ENVIO;
        else if (fieldName.equals("USUARIO_ENVIA"))
            value = USUARIO_ENVIA;

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
        CONSECUTIVO = null;
        CONSULTA = null;
        FECHA_CONSULTA = null;
        SERVICIO = null;
        NOMBRE_SERVICIO = null;
        CLINICA = null;
        NOMBRE_CLINICA = null;
        CORREO_ELECTRONICO = null;
        TIPO_CORREO = null;
        ETAPA = null;
        ERROR = null;
        FECHA_REGISTRO = null;
        USUARIO_REGISTRO = null;
        FECHA_ENVIO = null;
        USUARIO_ENVIA = null;

        Object[] aux = lstReporte.get(indexAux);
        if (aux != null) {
            if (aux[0] != null) 
                CONSECUTIVO = (BigDecimal) aux[0];
            if (aux[1] != null) 
                CONSULTA = (BigDecimal) aux[1];
            if (aux[2] != null) 
                FECHA_CONSULTA = (Date) aux[2];
            if (aux[3] != null) 
                SERVICIO = aux[3].toString();
            if (aux[4] != null) 
                NOMBRE_SERVICIO = aux[4].toString();
            if (aux[5] != null) 
                CLINICA = (BigDecimal) aux[5];
            if (aux[6] != null) 
                NOMBRE_CLINICA = aux[6].toString();
            if (aux[7] != null) 
                CORREO_ELECTRONICO =  aux[7].toString();
            if (aux[8] != null) 
                TIPO_CORREO = aux[8].toString();
            if (aux[9] != null) 
                ETAPA = aux[9].toString();
            if (aux[10] != null) 
                ERROR = aux[10].toString();
            if (aux[11] != null) 
                FECHA_REGISTRO = (Date) aux[11];
            if (aux[12] != null) 
                USUARIO_REGISTRO = aux[12].toString();
            if (aux[13] != null) 
                FECHA_ENVIO = (Date) aux[13];
            if (aux[14] != null) 
                USUARIO_ENVIA = aux[14].toString();
        }
    }


    public void generarReporte() {
        index = -1;
        generoReporte = false;
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd_hhmmss"); 
        nombSalida = "EnvioEmail" + dt.format(new Date());
        generoReporte = false;

        lstReporte = null;
        try {
            lstReporte = 
                    this.serviceLocator.getReporteService().getReporteEnvioEmail(fechaInicial, fechaFinal);

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstReporte != null && !lstReporte.isEmpty()) {

            try {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEnvioEmail.jasper");

                if (url != null) {
                    Map parameters = new HashMap();
                    JasperReport report = (JasperReport)JRLoader.loadObject(url);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRXlsExporter exporter = new JRXlsExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
                    exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);

                    exporter.exportReport();
                    XlsServletUtils.showXlsDocument(baos.toByteArray(), nombSalida + Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                    generoReporte = true;

                    FacesUtils.addInfoMessage("Reporte generado exitosamente");
                }
            } catch (Exception e) {
                FacesUtils.addErrorMessage("No se genero el reporte " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }
    }
    
    public void setNombSalida(String nombSalida) {
        this.nombSalida = nombSalida;
    }

    public String getNombSalida() {
        return nombSalida;
    }
}
