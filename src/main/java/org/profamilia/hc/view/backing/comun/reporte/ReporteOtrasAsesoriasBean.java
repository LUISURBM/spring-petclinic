package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.net.URL;

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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chasesoria;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteOtrasAsesoriasBean extends BaseBean implements JRDataSource {


    private Date fechaInicial;

    private Date fechaFinal;

    private List<Chasesoria> lstAsesoria;

    private int index;

    private boolean generoReporte;


    public ReporteOtrasAsesoriasBean() {
    }

    public void init() {

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

    public boolean next() {
        index++;
        return (index < 1);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        Object value = null;


        return value;
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
     * @param lstAsesoria
     */
    public void setLstAsesoria(List<Chasesoria> lstAsesoria) {
        this.lstAsesoria = lstAsesoria;
    }

    /**
     * @return
     */
    public List<Chasesoria> getLstAsesoria() {
        return lstAsesoria;
    }


    /**
     * @return
     */
    public void aceptar() {

       

        index = -1;
        try {
            lstAsesoria = 
                    this.serviceLocator.getClinicoService().getListaOtrasAsesorias(fechaInicial, 
                                                                                   fechaFinal, 
                                                                                   getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lstAsesoria != null && !lstAsesoria.isEmpty()) {
            for (Chasesoria aseso: lstAsesoria) {
                if (aseso.getHasdfechanacim() != null) {
                    aseso.setEdadPaciente(calcularEdad(aseso.getHasdfechanacim(), new Date()));
                } else {
                    aseso.setEdadPaciente(0);
                }


            }
        }


        if (lstAsesoria == null || lstAsesoria.isEmpty()) {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADO_CONSULTA);
            generoReporte = false;
        } else {

            try {

                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/ReportAsesoriaNormal.jasper");


                if (url != null) {

                    Map parameters = new HashMap();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    JRBeanCollectionDataSource dataSource = 
                        new JRBeanCollectionDataSource(lstAsesoria);

                    JasperPrint jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     dataSource);
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
                                                    "Reporte_Otras_asesorias" + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                    generoReporte = true;


                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el reporte " + 
                                           e.getMessage());
            }


        }
    }


}
