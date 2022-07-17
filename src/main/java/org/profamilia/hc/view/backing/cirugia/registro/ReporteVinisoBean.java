package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.ByteArrayOutputStream;


import java.math.BigDecimal;

import java.net.URL;

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

public class ReporteVinisoBean extends BaseBean implements JRDataSource {


    private List<Object[]> listaRegistros;

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer clinicaSelect;

    private List listaClinicas;

    private int index = -1;

    private boolean existeInformacion;

    private boolean generoReporte;

    private boolean disableClinicas;


    public ReporteVinisoBean() {
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
                        this.serviceLocator.getClinicoService().getRegistrosSegTelefonico(Long.parseLong(clinicaSelect.toString()), 
                                                                                          fechaInicial, 
                                                                                          fechaFinal);
            } else {
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getRegistrosSegTelefonico(0L, 
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

        if (fieldName.equals("FECHA_CIRUGIA")) {
            value = b[0];
            return value;
        }else if (fieldName.equals("FECHA_VINISO")) {
            value = b[1];
            return value;
        }else if (fieldName.equals("CLINICA")) {
            value = b[2].toString();
            return value;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = b[9].toString() + " " + b[10].toString();
            return value;
        } else if (fieldName.equals("NOMBRE_PACIENTE")) {
            value = 
                    b[5].toString() + " " + ((b[6] == null) ? "" : b[6].toString()) + 
                    " " + b[7].toString() + " " + 
                    ((b[8] == null) ? "" : b[8].toString());
            return value;
        } else if (fieldName.equals("CODIGO_SERVICIO")) {
            value = (String)b[3];
            return value;
        } else if (fieldName.equals("NOMBRE_SERVICIO")) {
            value = (String)b[4];
            return value;
        } else if (fieldName.equals("CELULAR")) {
            value = ((b[11] == null) ? "" : b[11].toString());
            return value;
        } else if (fieldName.equals("TELEFONO")) {
            value = ((b[12] == null) ? "" : b[12].toString());
            return value;
        } else if (fieldName.equals("HSTCRECCOLORO")) {
            value = (String)b[25];
            return value;
        } else if (fieldName.equals("HSTCDOLORMEDI")) {
            value = (String)b[26];
            return value;
        } else if (fieldName.equals("HSTCCALORHERI")) {
            value = (String)b[27];
            return value;
        } else if (fieldName.equals("HSTCENROHERID")) {
            value = (String)b[28];
            return value;
        } else if (fieldName.equals("HSTCSALISANHER")) {
            value = (String)b[29];
            return value;
        } else if (fieldName.equals("HSTCSALIPUSHER")) {
            value = (String)b[30];
            return value;
        } else if (fieldName.equals("HSTCSALILIQHER")) {
            value = (String)b[31];
            return value;
        } else if (fieldName.equals("HSTCMALOLORHE")) {
            value = (String)b[32];
            return value;
        } else if (fieldName.equals("HSTCPREMOLEST")) {
            value = (String)b[33];
            return value;
        } else if (fieldName.equals("HSTCCUALMOLES")) {
            value = (String)b[34];
            return value;
        } else if (fieldName.equals("HSTCOBSERADIC")) {
            value = (String)b[35];
            return value;
        } else if (fieldName.equals("HSTCOBSERVACI")) {
            value = (String)b[36];
            return value;
        } else if (fieldName.equals("HSTCENROSITIO")) {
            value = (String)b[37];
            return value;
        } else if (fieldName.equals("HSTCPRESEDOLO")) {
            value = (String)b[38];
            return value;
        } else if (fieldName.equals("HSTCRECUCANAL")) {
            value = (String)b[39];
            return value;
        } else if (fieldName.equals("HSTCPUSSAVENA")) {
            value = (String)b[40];
            return value;
        } else if (fieldName.equals("HSTCPRESMOLES")) {
            value = (String)b[41];
            return value;
        } else if (fieldName.equals("HSTCMOLESCUAL")) {
            value = (String)b[42];
            return value;
        } else if (fieldName.equals("HSTCOBSERVADI")) {
            value = (String)b[43];
            return value;
        } else if (fieldName.equals("HSTCOBSERACIO")) {
            value = (String)b[44];
            return value;
        } else if (fieldName.equals("HSTCASICONPOS")) {
            value = (String)b[45];
            return value;
        } else if (fieldName.equals("HSTCSIGANTCON")) {
            value = (String)b[46];
            return value;
        } else if (fieldName.equals("HSTCORDEANTIV")) {
            value = (String)b[47];
            return value;
        } else if (fieldName.equals("HSTCCUALANTIV")) {
            value = (String)b[48];
            return value;
        } else if (fieldName.equals("HSTCMEDIMEDIC")) {
            value = (String)b[49];
            return value;
        } else if (fieldName.equals("HSTCMEDPOSPR")) {
            value = (String)b[50];
            return value;
        } else if (fieldName.equals("HSTCCUALHOSP")) {
            value = (String)b[51];
            return value;
        } else if (fieldName.equals("HSTCDIERMEDIC")) {
            value = (String)b[52];
            return value;
        } else if (fieldName.equals("HSTCCUALMEDIC")) {
            value = (String)b[53];
            return value;
        } else if (fieldName.equals("HSTCDEPUTRATA")) {
            value = (String)b[54];
            return value;
        } else if (fieldName.equals("HSTCRECOEMITI")) {
            value = (String)b[55];
            return value;
        } else if (fieldName.equals("HSTCRECOMEND")) {
            value = (String)b[56];
            return value;
        }else if (fieldName.equals("HSTCNOASICONPOS")) {
            value = (String)b[57];
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
                String nombreArchivo = "RegistrosSeguimientoTelefonico";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteViniso.jasper");

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

    public void setDisableClinicas(boolean disableClinicas) {
        this.disableClinicas = disableClinicas;
    }

    public boolean isDisableClinicas() {
        return disableClinicas;
    }
}
