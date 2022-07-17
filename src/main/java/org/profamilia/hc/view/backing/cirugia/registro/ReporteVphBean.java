package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.ByteArrayOutputStream;


import java.math.BigDecimal;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
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
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;

public class ReporteVphBean extends BaseBean implements JRDataSource {


    private List<Object[]> listaRegistros;

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer clinicaSelect;

    private List listaClinicas;

    private int index = -1;

    private boolean existeInformacion;

    private boolean generoReporte;



    public ReporteVphBean() {
    }


    public void init() {
        listaRegistros = new ArrayList();
        listaClinicas = new ArrayList();
        generoReporte = false;
        existeInformacion = false;
        clinicaSelect = getUsuarioSystem().getCurnclinic();

    }

    public void consultarRegistros() {
        try {
            generoReporte = false;
            if (clinicaSelect != 0) {
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getRegistrosVPH(Long.parseLong(clinicaSelect.toString()), 
                                                                                          fechaInicial, 
                                                                                          fechaFinal);
            } else {
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getRegistrosVPH(0L,fechaInicial,fechaFinal);
            }

            if (listaRegistros != null && !listaRegistros.isEmpty()) {
                existeInformacion = true;
            } else {
                FacesUtils.addErrorMessage("No existen datos");
                existeInformacion = false;
            }
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage());
            existeInformacion = false;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            existeInformacion = false;
        }

    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Object[] b = new Object[listaRegistros.size()];
        b = listaRegistros.get(index);

        if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = b[0].toString();
            return value;
        }else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = b[1].toString();
            return value;
        }else if (fieldName.equals("PRIMER_NOMBRE")) {
            value = ((b[2] == null) ? "" : b[2].toString());
            return value;
        } else if (fieldName.equals("SEGUNDO_NOMBRE")) {
            value = ((b[3] == null) ? "" : b[3].toString());
            return value;
        } else if (fieldName.equals("PRIMER_APELLIDO")) {
            value = ((b[4] == null) ? "" : b[4].toString());
            return value;
        } else if (fieldName.equals("SEGUNDO_APELLIDO")) {
            value = ((b[5] == null) ? "" : b[5].toString());
            return value;
        }else if (fieldName.equals("CLINICA")) {
            value = b[6].toString();
            return value;
        } else if (fieldName.equals("FECHA_TOMA")) {
            value = b[7];
            return value;
        } else if (fieldName.equals("FECHA_GENERACION_ENVIO")) {
            value = b[9] ;
            return value;
        } else if (fieldName.equals("RESULTADO_PRUEBA")) {
            value = (String)b[8];
            return value;
        } 
        return value;
    }


    public void generarArchivoCsv() {
        index = -1;
        if (listaRegistros == null || listaRegistros.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                String nombreArchivo = "Informe Laboratorio VPH";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteVph.jasper");

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
        return (index < listaRegistros.size());
    }

    public void setListaRegistros(List<Object[]> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<Object[]> getListaRegistros() {
        return listaRegistros;
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

    public void setListaClinicas(List listaClinicas) {
        this.listaClinicas = listaClinicas;
    }

    public List getListaClinicas() {
        if (listaClinicas == null || listaClinicas.isEmpty()) {
            listaClinicas = new ArrayList();
            ArrayList<Cpclinica> lstClinicaAux = null;
            try {
                lstClinicaAux = 
                        (ArrayList<Cpclinica>)this.serviceLocator.getClinicoService().getClinicas();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstClinicaAux.isEmpty()) {
                listaClinicas.add(new SelectItem(0,"TODOS"));
                Iterator it = lstClinicaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listaClinicas.add(new SelectItem(lstClinicaAux.get(i).getCclncodigo(), 
                                                     lstClinicaAux.get(i).getCclcnombre()));
                    i++;
                }
            }
        }

        return listaClinicas;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }


    public void setClinicaSelect(Integer clinicaSelect) {
        this.clinicaSelect = clinicaSelect;
    }

    public Integer getClinicaSelect() {
        return clinicaSelect;
    }

    public void setExisteInformacion(boolean existeInformacion) {
        this.existeInformacion = existeInformacion;
    }

    public boolean isExisteInformacion() {
        return existeInformacion;
    }

}
