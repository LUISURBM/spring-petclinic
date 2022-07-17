package org.profamilia.hc.view.backing.cirugia.consulta;

import java.io.ByteArrayOutputStream;

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

import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteHonorariosCirugiaBean extends BaseBean implements JRDataSource {


    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstDatosHonorariosCirugia;
    
    private Cpprofesio anestesiologo;


    public ReporteHonorariosCirugiaBean() {
    }

    public void init() {
        index = -1;
        generoReporte = false;
    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        if (lstDatosHonorariosCirugia != null)
            return index < lstDatosHonorariosCirugia.size();
        else
            return false;
    }

    public Object getFieldValue(JRField jrField) {
        Object value = null;
        Object a[] = null;
        String fieldName = jrField.getName();
        if (lstDatosHonorariosCirugia.get(index) != null)
            a = (Object[])lstDatosHonorariosCirugia.get(index);

        if (fieldName.equals("NUMERO_DESCR"))
            if (a[0] != null)
                value = a[0].toString();
            else
                value = "";


        else if (fieldName.equals("TIEMPO_HORAS")) {
            if (a[1] != null)
                value = a[1].toString();
            else
                value = "";
        } else if (a[2] != null)
            value = a[2].toString();
        else
            value = "";
        if (fieldName.equals("CODIGO_ANESTESIOLOGO")) {
//            if (a[3] != null)
//                value = a[3].toString();
            if (a[9] != null) {
                anestesiologo = null;            
                try {
                    anestesiologo =
                        serviceLocator.getClinicoService().getProfesionalPorUsuario(a[9].toString(),
                                                                                    this.getClinica().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (anestesiologo == null ||  anestesiologo.getId().getCpfncodigo() == null || 
                    anestesiologo.getId().getCpfncodigo().intValue() == 0) {
                    value = a[9].toString();
                } else {
                    value = anestesiologo.getId().getCpfncodigo().toString();
                }
            }
            else
                value = "";
        } else if (fieldName.equals("NOMBRE_ANESTESIOLOGO")) {
//            if (a[4] != null)
//                value = a[4].toString();
            if (a[9] != null) {
                anestesiologo = null;            
                try {
                    anestesiologo =
                        serviceLocator.getClinicoService().getProfesionalPorUsuario(a[9].toString(),
                                                                         this.getClinica().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if(anestesiologo != null && anestesiologo.getCpfcnombre() != null ){
                    value = anestesiologo.getCpfcnombre();    
                }
                
                
            }
            else
                value = "";
        } else  if (fieldName.equals("CODIGO_CIRUJANO")) {
            if (a[5] != null)
                value = a[5].toString();
            else
                value = "";
        }
        if (fieldName.equals("NOMBRE_CIRUJANO")) {
            if (a[6] != null)
                value = a[6].toString();
            else
                value = "";
        } else  if (fieldName.equals("CODIGO_AYUDANTE")) {
            if (a[7] != null)
                value = a[7].toString();
            else
                value = "";
        }
        if (fieldName.equals("NOMBRE_AYUDANTE")) {
            if (a[8] != null)
                value = a[8].toString();
            else
                value = "";
        }else if (fieldName.equals("OPERADOR")) {
            if (a[9] != null)
                value = a[9].toString();
            else
                value = "";
        } else if (fieldName.equals("FECHA_REGISTRO")) {
            if (a[10] != null)
                value = a[10].toString();
            else
                value = "";
        } else if (fieldName.equals("CODIGO_SERVICIO")) {
            if (a[11] != null)
                value = a[11].toString();
            else
                value = "";
        } else if (fieldName.equals("NOMBRE_SERVICIO")) {
            if (a[12] != null)
                value = a[12].toString();
            else
                value = "";
        }else if (fieldName.equals("CODIGO_SERVICIO_PRA")) {
            if (a[13] != null)
                value = a[13].toString();
            else
                value = "";
        } else if (fieldName.equals("NOMBRE_SERVICIO_PRA")) {
            if (a[14] != null)
                value = a[14].toString();
            else
                value = "";
        } else if (fieldName.equals("USUARIO")) {
            if (a[15] != null)
                value = a[15].toString();
            else
                value = "";
        } else if (fieldName.equals("NUMERO_IDEN")) {
            if (a[16] != null)
                value = a[16].toString();
            else
                value = "";
        }

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
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return
     */
    public int getIndex() {
        return index;
    }


    public void setLstDatosHonorariosCirugia(List lstDatosHonorariosCirugia) {
        this.lstDatosHonorariosCirugia = lstDatosHonorariosCirugia;
    }

    public List getLstDatosHonorariosCirugia() {
        return lstDatosHonorariosCirugia;
    }


    public String generarReporte() {

        index = -1;
        generoReporte = false;

        try {
            lstDatosHonorariosCirugia = 
                    this.serviceLocator.getClinicoService().getListaCirugiasHonorarios(fechaInicial, 
                                                                                       fechaFinal, this.getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }

        try {
            if (lstDatosHonorariosCirugia != null && 
                !lstDatosHonorariosCirugia.isEmpty()) {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteDatosHonorariosCirugia.jasper");
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
                    generoReporte = true;
                  
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
                                                                        "ReporteDatosHonorariosCirugia" + 
                                                                        ".csv", false);
                  
         
                   
                }
            } else {
                FacesUtils.addErrorMessage("No existen resultados con esos criterios de busqueda");
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar el reporte ").append(e.getMessage()).toString());
        }


        return null;
    }


}
