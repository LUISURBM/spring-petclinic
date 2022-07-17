package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;

public class ReportePorcentajeManualBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private boolean generoReporte;

    private List<Object[]> lstReporte;

    private int index;

    private List lstTipoReporte;

    private String tipoSelect;

    private List listaProfesionalesClinica;

    private List<SelectItem> lstSala;


    private BigDecimal wcodmed;

    private Integer numeroSala;

    private String wservicio;


    String CODIGO_MEDICO;

    String NOMBRE_MEDICO;

    String ETAPA;

    String HISTORIA_MANUAL;

    String CODIGO_SERVICIO;

    String DESCRIPCION_SERVICIO;

    Long NUMERO_CONSULTA;

    String FECHA_CONSULTA;

    Date FECHA_CIERRE;

    Date FECHA_INICIO;

    Long MINUTOS_ATENCION;
    
    Long DOCUMENTO;


    public ReportePorcentajeManualBean() {
    }

    public void init() {
        tipoSelect = "R";
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
        if (fieldName.equals("CODIGO_MEDICO"))
            value = CODIGO_MEDICO;
        else if (fieldName.equals("NOMBRE_MEDICO"))
            value = NOMBRE_MEDICO;

        else if (fieldName.equals("ETAPA"))
            value = ETAPA;

        else if (fieldName.equals("HISTORIA_MANUAL"))
            value = HISTORIA_MANUAL;

        else if (fieldName.equals("CODIGO_SERVICIO"))
            value = CODIGO_SERVICIO;

        else if (fieldName.equals("DESCRIPCION_SERVICIO"))
            value = DESCRIPCION_SERVICIO;

        else if (fieldName.equals("NUMERO_CONSULTA"))
            value = NUMERO_CONSULTA;

        else if (fieldName.equals("FECHA_CONSULTA"))
            value = FECHA_CONSULTA;


        else if (fieldName.equals("FECHA_CIERRE"))
            value = FECHA_CIERRE;


        else if (fieldName.equals("FECHA_INICIO"))
            value = FECHA_INICIO;

        else if (fieldName.equals("MINUTOS_ATENCION"))
            value = MINUTOS_ATENCION;

        else if (fieldName.equals("DOCUMENTO"))
            value = DOCUMENTO;

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

        CODIGO_MEDICO = null;
        NOMBRE_MEDICO = "Historias Sin Asignar";
        ETAPA = null;
        HISTORIA_MANUAL = null;
        NUMERO_CONSULTA = null;
        CODIGO_SERVICIO = null;
        DESCRIPCION_SERVICIO = null;
        FECHA_CIERRE = null;
        FECHA_INICIO = null;
        MINUTOS_ATENCION = null;
        DOCUMENTO = null;


        Object[] aux = lstReporte.get(indexAux);


        if (aux != null) {
            if (aux[1] != null) {
                CODIGO_MEDICO = aux[1].toString();
            }

            if (aux[3] != null) {
                NOMBRE_MEDICO = aux[3].toString();
            }

            if (aux[2] != null) {
                ETAPA = aux[2].toString();
                HISTORIA_MANUAL = "N";
            } else {
                HISTORIA_MANUAL = "S";
            }

            if (aux[4] != null) {
                NUMERO_CONSULTA = new Long(aux[4].toString());
            }

            if (aux[5] != null) {
                CODIGO_SERVICIO = aux[5].toString();
            }

            if (aux[6] != null) {
                DESCRIPCION_SERVICIO = aux[6].toString();
            }

            if (aux[7] != null) {
                FECHA_CONSULTA = aux[7].toString();
            }

            if (aux[8] != null) {
                FECHA_CIERRE = (Date)aux[8];
            }

            if (aux[9] != null) {
                FECHA_INICIO = (Date)aux[9];
            }

            if (aux[13] != null) {
                DOCUMENTO = new Long(aux[13].toString());
            }

            if (FECHA_CIERRE != null && FECHA_INICIO != null) {
                MINUTOS_ATENCION = obtenerDuracion(FECHA_INICIO, FECHA_CIERRE);
            }

        }

    }


    public void generarReporte() {
        index = -1;


        String urlAux = "";
        generoReporte = false;
        String nombSalida = "";

        if (tipoSelect != null) {
            if (tipoSelect.equals("R")) {
                urlAux = "/reports/reportePorcentajeManual.jasper";
                nombSalida = "ReportePorcentajeSistema";
            } else if (tipoSelect.equals("D")) {
                urlAux = "/reports/reporteDetalladoManualClinica.jasper";
                nombSalida = "ReportePorcentajeSistemaDetallado";
            }
        }

        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getReportePorcentajeManual(fechaInicial, 
                                                                                       fechaFinal, 
                                                                                       this.getClinica().getCclncodigo(), 
                                                                                       wcodmed, 
                                                                                       numeroSala, 
                                                                                       wservicio);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        try {
            if (lstReporte != null && !lstReporte.isEmpty()) {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(urlAux);
                java.net.URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                java.net.URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                java.net.URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                   url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", getClinica().getCclcnombre());
                    parameters.put("FECHA_INICIAL", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);
                    parameters.put("MEDICO_PARAMETRO", wcodmed);
                    parameters.put("SALA_PARAMETRO", numeroSala);
                    parameters.put("SERVICIO_PARAMETRO", wservicio);
                    generoReporte = true;

                        JasperReport report = 
                            (JasperReport)JRLoader.loadObject(url);

                        JasperPrint jasperPrint = 
                            JasperFillManager.fillReport(report, parameters, 
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
                                                    nombSalida + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                        
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       (e.getMessage()).toString());
        }
    }


    /**
     * @param lstTipoReporte
     */
    public void setLstTipoReporte(List lstTipoReporte) {
        this.lstTipoReporte = lstTipoReporte;
    }

    /**
     * @return
     */
    public List getLstTipoReporte() {
        if (lstTipoReporte == null || lstTipoReporte.isEmpty()) {
            lstTipoReporte = new ArrayList();
            lstTipoReporte.add(new SelectItem("R", "Resumido"));
            lstTipoReporte.add(new SelectItem("D", "Detallado"));
        }
        return lstTipoReporte;
    }

    /**
     * @param tipoSelect
     */
    public void setTipoSelect(String tipoSelect) {
        this.tipoSelect = tipoSelect;
    }

    /**
     * @return
     */
    public String getTipoSelect() {
        return tipoSelect;
    }

    /**
     * @param listaProfesionalesClinica
     */
    public void setListaProfesionalesClinica(List listaProfesionalesClinica) {
        this.listaProfesionalesClinica = listaProfesionalesClinica;
    }

    /**
     * @return
     */
    public List getListaProfesionalesClinica() {

        if (listaProfesionalesClinica == null) {
            listaProfesionalesClinica = new ArrayList<Cpprofesio>();
            listaProfesionalesClinica.add(new SelectItem("", 
                                                         "Todos los M�dicos"));
            try {

                List<Cpprofesio> tabla = 
                    this.serviceLocator.getClinicoService().getListaProfesionalesClinica(this.getClinica().getCclncodigo());
                for (Cpprofesio combo: tabla) {
                    listaProfesionalesClinica.add(new SelectItem(combo.getId().getCpfncodigo(), 
                                                                 combo.getCpfcnombre()));
                }
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }
        }


        return listaProfesionalesClinica;

    }

    /**
     * @param wcodmed
     */
    public void setWcodmed(BigDecimal wcodmed) {
        this.wcodmed = wcodmed;
    }

    /**
     * @return
     */
    public BigDecimal getWcodmed() {
        return wcodmed;
    }

    /**
     * @param lstSala
     */
    public void setLstSala(List<SelectItem> lstSala) {
        this.lstSala = lstSala;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstSala() {
        List listSalaAux;
        listSalaAux = null;


        if (lstSala == null || lstSala.isEmpty()) {
            lstSala = new ArrayList<SelectItem>();

            try {
                listSalaAux = 
                        this.getServiceLocator().getClinicoService().getSalasEspera(this.getClinica().getCclncodigo(), 
                                                                                    userName());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            lstSala.add(new SelectItem("", "Todas las salas"));


            if (listSalaAux != null && !listSalaAux.isEmpty()) {
                Iterator iter = listSalaAux.iterator();

                while (iter.hasNext()) {
                    Object[] a = (Object[])iter.next();
                    Integer codigosala = new Integer(a[0].toString());
                    String descrisala = a[1].toString();
                    lstSala.add(new SelectItem(codigosala, descrisala));

                }
            }

        }
        return lstSala;
    }


    /**
     * @param numeroSala
     */
    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    /**
     * @return
     */
    public Integer getNumeroSala() {
        return numeroSala;
    }

    /**
     * @param wservicio
     */
    public void setWservicio(String wservicio) {
        this.wservicio = wservicio;
    }

    /**
     * @return
     */
    public String getWservicio() {
        return wservicio;
    }

    public long obtenerDuracion(Date fechaInicial, Date fechaFinal) {

        long diffMinutes = 0;
        Calendar calIni = Calendar.getInstance();
        Calendar calFin = Calendar.getInstance();

        if (fechaInicial != null && fechaFinal != null) {
            calIni.setTime(fechaInicial);
            calFin.setTime(fechaFinal);

            // conseguir la representacion de la fecha en milisegundos  
            long milis1 = calIni.getTimeInMillis();
            long milis2 = calFin.getTimeInMillis();
            // calcular la diferencia en milisengundos  
            long diff = milis2 - milis1;
            // calcular la diferencia en minutos  
            diffMinutes = diff / (60 * 1000);
        }

        return diffMinutes;
    }

}
