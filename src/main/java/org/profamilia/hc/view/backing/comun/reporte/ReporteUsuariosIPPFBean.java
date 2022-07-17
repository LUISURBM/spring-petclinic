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
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Clcateippf;
import org.profamilia.hc.model.dto.Clcomserv;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.CsvServletUtils;


public class ReporteUsuariosIPPFBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private String periodo;

    private boolean generoReporte;
    
    private boolean generoDetallado;

    private List<Object[]> lstReporte;

    private List<Clcomserv> lstServicio;

    private int index;


    private String CLINICA;
    private String PERIODO;
    private String SERVICIO_IPPF;
    private String SERVICIO;
    private String GENERO;
    private String PREFIJO_SERVICIO;
    private String SUFIJO_SERVICIO;
    private BigDecimal EDAD;
    private String USUARIO;
    private String USUARIO_REG;
    private String USUARIO_GENERA;
    private Date FECHA_ACTUALIZACION;
    private String DESCRIPCION_SERVICIO;
    private String TIPO_ORGNIT;
    private String PAQUETE;
    private String INTEXT;
    private String SUBCATEGORIA;

    private String nombSalida;

    public ReporteUsuariosIPPFBean() {
    }

    public void init() {
        lstServicio = new ArrayList<Clcomserv>();
        generoDetallado = false;
        periodo = "M";
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
        else if (fieldName.equals("PERIODO"))
            value = PERIODO;
        else if (fieldName.equals("GENERO"))
            value = GENERO;
        else if (fieldName.equals("SERVICIO"))
            value = SERVICIO;
        else if (fieldName.equals("SERVICIO_IPPF"))
            value = SERVICIO_IPPF;
        else if (fieldName.equals("USUARIO"))
            value = USUARIO;
        else if (fieldName.equals("USUARIO_REG"))
            value = USUARIO_REG;
        else if (fieldName.equals("PREFIJO_SERVICIO"))
            value = PREFIJO_SERVICIO;
        else if (fieldName.equals("SUFIJO_SERVICIO"))
            value = SUFIJO_SERVICIO;
        else if (fieldName.equals("EDAD"))
            value = EDAD;
        else if (fieldName.equals("USUARIO_GENERA"))
            value = USUARIO_GENERA;
        else if (fieldName.equals("FECHA_ACTUALIZACION"))
            value = FECHA_ACTUALIZACION;
        else if (fieldName.equals("DESCRIPCION_SERVICIO"))
            value = DESCRIPCION_SERVICIO;
        else if (fieldName.equals("TIPO_ORGNIT"))
            value = TIPO_ORGNIT;
        else if (fieldName.equals("PAQUETE"))
            value = PAQUETE;
        else if (fieldName.equals("INTEXT"))
            value = INTEXT;
        else if (fieldName.equals("SUBCATEGORIA"))
            value = SUBCATEGORIA;

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
        PERIODO = null;
        SERVICIO_IPPF = null;
        SERVICIO = null;
        PREFIJO_SERVICIO = null;
        USUARIO = null;
        USUARIO_REG = null;
        EDAD = null;
        SUFIJO_SERVICIO = null;
        GENERO = null;
        USUARIO_GENERA = "sysadb";
        FECHA_ACTUALIZACION = null;
        DESCRIPCION_SERVICIO = null;
        TIPO_ORGNIT = null;
        PAQUETE = null;
        INTEXT = null;
        SUBCATEGORIA = null;

        Object[] aux = lstReporte.get(indexAux);
        if (aux != null) {
            if (aux[0] != null) {
                if (periodo.equals("M")) {
                    if (aux[1].toString().length() == 1) {
                        PERIODO = aux[0].toString() + "0" + aux[1].toString();
                    } else {
                        PERIODO = aux[0].toString() + aux[1].toString();
                    }
                } else {
                    PERIODO = aux[0].toString();
                }
            }
            if (aux[2] != null) 
                SERVICIO_IPPF = (aux[2].toString());
            if (aux[3] != null) 
                USUARIO = aux[3].toString();
            if (aux[4] != null)
                TIPO_ORGNIT = (String)aux[4];
            if (aux[5] != null)
               SUBCATEGORIA = (String)aux[5];
            if (aux[6] != null) 
                CLINICA = aux[6].toString();
        }
    }


    public void generarReporte() {
        index = -1;
        generoReporte = false;
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd_hhmmss"); 
        nombSalida = "UsuariosIppf" + dt.format(new Date());
        generoReporte = false;

        if (lstReporte != null && !lstReporte.isEmpty()) {

            try {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteUsuariosIppf.jasper");
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
        generoReporte = false;
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd_hhmmss"); 
        nombSalida = "reporteUsuariosIppfDet" + dt.format(new Date());

        List<Object[]> lstReporteAux = null;
        try {
            lstReporteAux = 
                    this.serviceLocator.getClinicoService().getReporteUsuariosIppf(fechaInicial, 
                                                                                    fechaFinal, periodo);

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstReporteAux != null && !lstReporteAux.isEmpty()) {
            lstReporte = new ArrayList<Object[]>();
            lstReporte.addAll(lstReporteAux);

/*            for (Object[] objeto: lstReporteAux) {
                if (objeto[6] != null) {
                    Object[] temaAux = new Object[6];
                    temaAux[0] = objeto[0].toString();
                    temaAux[1] = objeto[1].toString();
                    temaAux[2] = objeto[6].toString();
                    temaAux[3] = objeto[3].toString();
                    temaAux[4] = objeto[4].toString();
                    temaAux[5] = objeto[7].toString();
                    lstReporte.add(temaAux);
                }
            }
*/            

            try {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteUsuariosIppfDet.jasper");
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

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }
}
