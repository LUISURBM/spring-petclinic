package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteComplEnfermBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private int index;
    private Integer clinicaSelect;
    private List lstClinicas;
    private List<Object[]> lstReporte;
    private boolean existeInformacion;
    private boolean generoReporte;


    public void init() {
        index = -1;
        clinicaSelect = 0;
        generoReporte = false;
       
    }

    public ReporteComplEnfermBean() {

    }

    public void generarReporte() {
        index = -1;
                existeInformacion = false;
        generoReporte = false;

                try {
                    lstReporte = 
                            this.serviceLocator.getClinicoService().getReporteComplEnfer(fechaInicial, 
                                                                                         fechaFinal, 
                                                                                         clinicaSelect);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

        if (lstReporte != null && !lstReporte.isEmpty()) {
            existeInformacion = true;
        } else {
            FacesUtils.addErrorMessage("No existen datos");
            existeInformacion = false;
        }
             
    }
    
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Object[] b = new Object[lstReporte.size()];
        b = lstReporte.get(index);

        if (fieldName.equals("FECHA_REGISTRO")) {
            value = b[0];
            return value;
        }else if (fieldName.equals("CODIGO_SERVICIO")) {
            value = b[1];
            return value;
        }else if (fieldName.equals("NOMBRE_SERVICIO")) {
            value = b[2].toString();
            return value;
        } else if (fieldName.equals("CLINICA")) {
            value = b[3].toString();
            return value;
        } else if (fieldName.equals("NOMBRE_CLINICA")) {
            value =  b[4].toString();
            return value;
        } else if (fieldName.equals("PERSONA_ATIENDE")) {
            value =  b[5].toString();
            return value;
        } else if (fieldName.equals("TIPO_IDENTIFICACION")) {
            value =  b[6].toString();
            return value;
        } else if (fieldName.equals("NUMERO_IDENTIFICACION")) {
            value =  b[7].toString();
            return value;
        } else if (fieldName.equals("NOTA_REGISTRADA")) {
            value = b[8].toString();
            return value;
        }
        return value;
    }

    public void generarArchivoCsv() {
        index = -1;
        if (lstReporte == null || lstReporte.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                String nombreArchivo = "RegistroComplemetarioEnfermeria";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteRegistroComplEnferm.jasper");

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
                                                    nombreArchivo + ".csv", 
                                                    false);

                    generoReporte = true;

                }
            } catch (Exception e) {
                generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }


        /**
         * @return
         */
        public boolean next() {
            index++;
            return (index < lstReporte.size());
        }

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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public void setLstClinicas(List lstClinicas) {
        this.lstClinicas = lstClinicas;
    }

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
                        lstClinicas.add(new SelectItem(0,"TODOS"));
                        Iterator it = lstClinicaAux.iterator();
                        int i = 0;
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

    public void setLstReporte(List<Object[]> lstReporte) {
        this.lstReporte = lstReporte;
    }

    public List<Object[]> getLstReporte() {
        return lstReporte;
    }

    public void setExisteInformacion(boolean existeInformacion) {
        this.existeInformacion = existeInformacion;
    }

    public boolean isExisteInformacion() {
        return existeInformacion;
    }


    public void setClinicaSelect(Integer clinicaSelect) {
        this.clinicaSelect = clinicaSelect;
    }

    public Integer getClinicaSelect() {
        return clinicaSelect;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }
}
