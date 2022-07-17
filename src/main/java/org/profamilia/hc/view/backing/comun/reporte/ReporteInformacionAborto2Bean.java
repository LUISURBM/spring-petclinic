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
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteInformacionAborto2Bean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer wcodclin;

    private boolean generoReporte;

    private List<Object[]> lstReporte;

    private int index;

    private List lstClinicas;

    BigDecimal EDAD;
    String FACTOR_SANGRE;
    String GRUPO_SANGUINEO;
    String ASEGURAMIENTO;
    BigDecimal SEM_EMB_ULT_MEST;
    BigDecimal NUMERO_GESTACIONES;
    BigDecimal NUMERO_CESARIAS;
    BigDecimal NUMERO_ABORTOS;
    BigDecimal NUMERO_PARTOS;
    String METODO_PLANIFICA_ANTERIOR;
    String METODO_PLANIFICA_POSTERIOR;
    Date FECHA_PROCEDIMIENTO;
    BigDecimal COD_CLININICA;
    String NOMBRE_CLINICA;


    public ReporteInformacionAborto2Bean() {
    }

    public void init() {
        inicializarReporteInformacionAborto2();
    }

    public void inicializarReporteInformacionAborto2() {
        lstClinicas = new ArrayList();
    }

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

        if (fieldName.equals("EDAD"))
            value = EDAD;
        else if (fieldName.equals("FACTOR_SANGRE"))
            value = FACTOR_SANGRE;
        else if (fieldName.equals("GRUPO_SANGUINEO"))
            value = GRUPO_SANGUINEO;
        else if (fieldName.equals("ASEGURAMIENTO"))
            value = ASEGURAMIENTO;
        else if (fieldName.equals("SEM_EMB_ULT_MEST"))
            value = SEM_EMB_ULT_MEST;
        else if (fieldName.equals("NUMERO_GESTACIONES"))
            value = NUMERO_GESTACIONES;
        else if (fieldName.equals("NUMERO_CESARIAS"))
            value = NUMERO_CESARIAS;
        else if (fieldName.equals("NUMERO_ABORTOS"))
            value = NUMERO_ABORTOS;
        else if (fieldName.equals("NUMERO_PARTOS"))
            value = NUMERO_PARTOS;
        else if (fieldName.equals("METODO_PLANIFICA_ANTERIOR"))
            value = METODO_PLANIFICA_ANTERIOR;
        else if (fieldName.equals("METODO_PLANIFICA_POSTERIOR"))
            value = METODO_PLANIFICA_POSTERIOR;
        else if (fieldName.equals("FECHA_PROCEDIMIENTO"))
            value = FECHA_PROCEDIMIENTO;
        else if (fieldName.equals("COD_CLININICA"))
            value = COD_CLININICA;
        else if (fieldName.equals("NOMBRE_CLINICA"))
            value = NOMBRE_CLINICA;
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

        EDAD = null;
        FACTOR_SANGRE = null;
        GRUPO_SANGUINEO = null;
        ASEGURAMIENTO = null;
        SEM_EMB_ULT_MEST = null;
        NUMERO_GESTACIONES = null;
        NUMERO_CESARIAS = null;
        NUMERO_ABORTOS = null;
        NUMERO_PARTOS = null;
        METODO_PLANIFICA_ANTERIOR = null;
        METODO_PLANIFICA_POSTERIOR = null;
        FECHA_PROCEDIMIENTO = null;
        COD_CLININICA = null;
        NOMBRE_CLINICA = null;

        Object[] aux = lstReporte.get(indexAux);

        if (aux != null) {
            if (aux[0] != null) {
                EDAD =  new BigDecimal (aux[0].toString());
            }

            if (aux[1] != null) {
                FACTOR_SANGRE = aux[1].toString();
            }

            if (aux[2] != null) {
                GRUPO_SANGUINEO = aux[2].toString();
            }

            if (aux[3] != null) {
                ASEGURAMIENTO = aux[3].toString();
            }

            if (aux[4] != null) {
                SEM_EMB_ULT_MEST = new BigDecimal(aux[4].toString());
            }

            if (aux[5] != null) {
                NUMERO_GESTACIONES = new BigDecimal(aux[5].toString());
            }

            if (aux[6] != null) {
                NUMERO_CESARIAS = new BigDecimal(aux[6].toString());
            }

            if (aux[7] != null) {
                NUMERO_ABORTOS = new BigDecimal(aux[7].toString());
            }

            if (aux[8] != null) {
                NUMERO_PARTOS = new BigDecimal(aux[8].toString());
            }

            if (aux[9] != null) {
                METODO_PLANIFICA_ANTERIOR = aux[9].toString();
            }

            if (aux[10] != null) {
                METODO_PLANIFICA_POSTERIOR = aux[10].toString();
            }

            if (aux[11] != null) {
                FECHA_PROCEDIMIENTO = (Date)aux[11];
            }
            
            if (aux[12] != null) {
                COD_CLININICA = new BigDecimal(aux[12].toString());
            }
            
            if (aux[13] != null) {
                NOMBRE_CLINICA = aux[13].toString();
            }

        }
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


    public void setWcodclin(Integer wcodclin) {
        this.wcodclin = wcodclin;
    }

    public Integer getWcodclin() {
        return wcodclin;
    }

    public void generarReporte() {


        index = -1;


        String urlAux = "";
        generoReporte = false;
        String nombSalida = "ReporteInformacionAborto2_" + new Date();


        urlAux = "/reports/reporteInformacionAborto2.jasper";


        try {
        lstReporte = this.serviceLocator.getClinicoService().getReporteInformacionAborto2(fechaInicial,fechaFinal,wcodclin);
         } catch (ModelException e) {
           e.printStackTrace();
         }

        if (lstReporte != null && !lstReporte.isEmpty()) {
            try {

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
        } else {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }


    }


}
