package org.profamilia.hc.view.backing.comun.reporte;



import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

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

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoprof;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteReferenciasbBean extends BaseBean implements JRDataSource {
  
    private List<Object[]> listaRegistros;

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer clinicaSelect;

    private List lstClinicas;

    private int index ;

    private boolean existeInformacion;

    private boolean generoReporte;

    private boolean disableClinicas;
  

  
  
 
   
   
   
    public ReporteReferenciasbBean() {
       
    }
    
 
    /**
     * @return
     */
    public String volverInicio() {
        FacesUtils.resetManagedBean("reporteReferenciaBean");
        return "home";
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (listaRegistros != null)
            return index < listaRegistros.size();
        else
            return false;

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


   



    public void init() {
    index =-1;
        listaRegistros = new ArrayList();
        getLstClinicas();
        generoReporte = false;
        existeInformacion = false;

    }

    public void consultarRegistros() {
        try {
            generoReporte = false;
            if (clinicaSelect != 0) {
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getReporteReferencia(clinicaSelect, 
                                                                                          fechaInicial, 
                                                                                          fechaFinal);
            } else {
                listaRegistros = 
                this.serviceLocator.getClinicoService().getReporteReferencia(0, 
                                                                                  fechaInicial, 
                                                                                  fechaFinal);
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

        if (fieldName.equals("FECHA_ATENCION")) {
            value = b[0];
            return value;
        }else if (fieldName.equals("CLINICA")) {
            value = b[1]+" - "+b[2];
            return value;
        }else if (fieldName.equals("IDENTIFICACION")) {
            value = b[3].toString()+" - "+b[4];
            return value;
        }
         else if (fieldName.equals("NOMBRE_PACIENTE")) {
            value = 
                    b[5].toString(); 
               
            return value;
        } 
        else if (fieldName.equals("CODIGO_SERVICIO")) {
            value = (String)b[6];
            return value;
        }
        else if (fieldName.equals("NOMBRE_SERVICIO")) {
            value = (String)b[7];
            return value;
        }
        else if (fieldName.equals("OPERADOR")) {
            value = (String)b[8];
            return value;
        }
        else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = b[9].toString();
            return value;
        }
        else if (fieldName.equals("SERVICIO_REMITE")) {
            value = b[10].toString();
            return value;
        } 
        return value;
    }


    public void generarArchivoCsv() {
    consultarRegistros();
        index = -1;
        if (listaRegistros == null || listaRegistros.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                String nombreArchivo = "ReporteReferenciaPacientes";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteReferencia.jasper");

                if (url != null) {
                    Map parameters = new HashMap();

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
                                                    "Reporte_Referencia" + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);

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

    public void setClinicaSelect(Integer clinicaSelect) {
        this.clinicaSelect = clinicaSelect;
    }

    public Integer getClinicaSelect() {
        return clinicaSelect;
    }

    public void setLstClinicas(List lstClinicas) {
        this.lstClinicas = lstClinicas;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setExisteInformacion(boolean existeInformacion) {
        this.existeInformacion = existeInformacion;
    }

    public boolean isExisteInformacion() {
        return existeInformacion;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setDisableClinicas(boolean disableClinicas) {
        this.disableClinicas = disableClinicas;
    }

    public boolean isDisableClinicas() {
        return disableClinicas;
    }
}
