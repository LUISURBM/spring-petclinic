package org.profamilia.hc.view.backing.asesoria.consulta;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.*;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;

public class ReporteMisAsesoriasIlveBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstClinicas;
    private Integer wcodclin;
    private List<Object[]> lstReporte;

    Date FECHA_ASESORIA;
    BigDecimal CLINICA;
    BigDecimal NUMERO_IDENTIFICACION;
    BigDecimal EDAD;
    String TELEFONO;
    String CELULAR;

    String CLASE_REMISION;
    String USUARIO_REGISTRO;
    String LOGIN_REGISTRO;
    String OTRA_REMISION_;
    BigDecimal NUMERO_EDAD_GESTACIONAL;
    String NOMBRE_PACIENTE;


    public void init() {
        index = -1;

        if (getUsuarioSystem() != null && 
            getUsuarioSystem().getCurnclinic() != null) {
            wcodclin = getUsuarioSystem().getCurnclinic();
        }

    }

    public ReporteMisAsesoriasIlveBean() {
        init();
    }

    /**
     * @return
     */
    public String volverInicio() {
        FacesUtils.resetManagedBean("reporteAsesoriaIlveBean");
        return "home";
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
        Object[] aux = null;
        if (index < lstReporte.size()) {
            aux = lstReporte.get(index);
        }

        resetDatos();
        obtenerDatos(aux);

        String fieldName = jrField.getName();
        if (fieldName.equals("FECHA_ASESORIA"))
            value = FECHA_ASESORIA;
        else if (fieldName.equals("CLINICA"))
            value = CLINICA;
        else if (fieldName.equals("NUMERO_IDENTIFICACION"))
            value = NUMERO_IDENTIFICACION;
        else if (fieldName.equals("EDAD"))
            value = EDAD;

        else if (fieldName.equals("TELEFONO"))
            value = TELEFONO;
        else if (fieldName.equals("CELULAR"))
            value = CELULAR;
        else if (fieldName.equals("CLASE_REMISION"))
            value = CLASE_REMISION;
        else if (fieldName.equals("USUARIO_REGISTRO"))
            value = USUARIO_REGISTRO;
        else if (fieldName.equals("LOGIN_REGISTRO"))
            value = LOGIN_REGISTRO;
        else if (fieldName.equals("OTRA_REMISION_"))
            value = OTRA_REMISION_;
        else if (fieldName.equals("NUMERO_EDAD_GESTACIONAL"))
            value = NUMERO_EDAD_GESTACIONAL;
        else if (fieldName.equals("NOMBRE_PACIENTE"))
            value = NOMBRE_PACIENTE;
        return value;
    }


    public void resetDatos() {
        FECHA_ASESORIA = null;
        CLINICA = null;
        NUMERO_IDENTIFICACION = null;
        EDAD = null;
        TELEFONO = null;
        CELULAR = null;
        CLASE_REMISION = null;
        USUARIO_REGISTRO = null;
        LOGIN_REGISTRO = null;
        OTRA_REMISION_ = null;
        NUMERO_EDAD_GESTACIONAL = null;
        NOMBRE_PACIENTE = null;

    }

    public void obtenerDatos(Object[] aseaux) {
        if (aseaux != null) {
            FECHA_ASESORIA = ((Date)aseaux[0]);
            CLINICA = ((BigDecimal)aseaux[1]);
            NUMERO_IDENTIFICACION = (BigDecimal)aseaux[2];
            EDAD = (BigDecimal)aseaux[3];


            if (((String)aseaux[7]).equals("S")) {
                CLASE_REMISION = "Otra Remisi�n";
            } else if (((String)aseaux[8]).equals("S")) {
                CLASE_REMISION = "Indecisi�n";
            } else if (((String)aseaux[9]).equals("S")) {
                CLASE_REMISION = "Capacidad Pago Limitada";
            } else if (((String)aseaux[10]).equals("S")) {
                CLASE_REMISION = "Va a usar EPS";
            } else if (((String)aseaux[11]).equals("S")) {
                CLASE_REMISION = "Va a usar otra IPS";
            } else if (((String)aseaux[12]).equals("S")) {
                CLASE_REMISION = "No aplica causal";
            } else if (((String)aseaux[13]).equals("S")) {
                CLASE_REMISION = "Remisi�n por edad Gestacional";
            } else if (((String)aseaux[14]).equals("S")) {
                CLASE_REMISION = "Desea continuar embarazo";
            } else if (((String)aseaux[15]).equals("S")) {
                CLASE_REMISION = "Opta Ilve";
            } else if (((String)aseaux[16]).equals("S")) {
                CLASE_REMISION = "Aplaza Decisi�n";
            }


            USUARIO_REGISTRO = obtenerNombre((String)aseaux[17], CLINICA);
            LOGIN_REGISTRO = formatearCampo((String)aseaux[17]);
            OTRA_REMISION_ = formatearCampo((String)aseaux[18]);
            NUMERO_EDAD_GESTACIONAL = (BigDecimal)aseaux[19];
            TELEFONO = formatearCampo((String)aseaux[20]);
            CELULAR = formatearCampo((String)aseaux[21]);
            NOMBRE_PACIENTE = formatearCampo((String)aseaux[22]);


        }


    }


    public String obtenerNombre(String usuario, BigDecimal codclinica) {

        String nombreUsuario = "";
        Cpprofesio profes = null;

        if (usuario != null && codclinica != null) {
            try {
                profes = 
                        this.serviceLocator.getClinicoService().getProfesionalPorUsuario(usuario, 
                                                                                         codclinica.intValue());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (profes != null) {
                nombreUsuario = profes.getCpfcnombre();
            }
        }


        return nombreUsuario;
    }


    public String generarAsesoriaIlve() {

        index = -1;
        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getReporteMisAsesoraIlve(wcodclin, 
                                                                                     fechaInicial, 
                                                                                     fechaFinal, 
                                                                                     userName());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_REPORTES);
        }

        if (lstReporte == null || lstReporte.isEmpty()) {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADO_CONSULTA);
            generoReporte = false;
        } else {
            try {

                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteMisAsesoriasIlve.jasper");


                /*    if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    bytes =
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                    PdfServletUtils.showPdfDocument(bytes,
                                                    "Resumen_Otra_Asesoria" + ".pdf",
                                                    false);
                    generoReporte = true;


*/


                if (url != null) {

                    Map parameters = new HashMap();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    JasperPrint jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRCsvExporter exporter = new JRCsvExporter();
                    exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, 
                                          jasperPrint);
                    exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, 
                                          baos);
                    exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, 
                                          ",");

                    exporter.exportReport();

                    CsvServletUtils.showCsvDocument(baos.toByteArray(), 
                                                    "Resumen_Otra_Asesoria" + 
                                                    ".csv", false);

                    generoReporte = true;


                }


            } catch (Exception e) {
                return capturaError(e,IConstantes.ERROR_REPORTES);
            }

        }
        return null;
    }

   
}
