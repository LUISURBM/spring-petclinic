//=======================================================================
// ARCHIVO Reporte Ilve
// FECHA CREACI�N: 07/10/2015
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Reporte Ilve Solicitado por Medellin (Angela Faria Soto)
//=======================================================================
package org.profamilia.hc.view.backing.comun.reporte;

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
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE Reporte Ilve
//=======================================================================
public class ReporteIlveNacionalBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstIVE;
    private Integer wcodclin;
    private List lstClinicas;


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE REPORTE
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ReporteIlveNacionalBean() {

    }


    //-----------------------------------------------------------------------
    //  REPORT
    //-----------------------------------------------------------------------


    public boolean next() {
        index++;
        if (lstIVE != null)
            return index < lstIVE.size();
        else
            return false;
    }

    public Object getFieldValue(JRField jrField) {
        Object value = null;
        Object a[] = null;
        String fieldName = jrField.getName();
        if (lstIVE.get(index) != null)
            a = (Object[])lstIVE.get(index);


        if (fieldName.equals("NUMERO_USUARIO_ILVE")) {
            value = a[0];
        } else if (fieldName.equals("TIPO_DOC")) {
            value = a[1];
        } else if (fieldName.equals("NUM_IDEN")) {
            value = a[2];
        } else if (fieldName.equals("NOMBRE1")) {
            value = a[3];
        } else if (fieldName.equals("NOMBRE2")) {
            value = a[4];
        } else if (fieldName.equals("APELLIDO1")) {
            value = a[5];
        } else if (fieldName.equals("APELLIDO2")) {
            value = a[6];
        } else if (fieldName.equals("FECHA_NAC")) {
            value = a[7];
        } else if (fieldName.equals("EDAD")) {
            value = a[8];
        } else if (fieldName.equals("ESTADO_CIVIL")) {
            value = a[9];
        } else if (fieldName.equals("ETNIA")) {
            value = a[10];
        } else if (fieldName.equals("NIVEL_EDUCATIVO")) {
            value = a[11];
        } else if (fieldName.equals("OCUPACION")) {
            value = a[12];
        } else if (fieldName.equals("TELEFONO")) {
            value = a[13];
        } else if (fieldName.equals("CELULAR")) {
            value = a[14];
        } else if (fieldName.equals("ESTRATO")) {
            value = a[15];
        } else if (fieldName.equals("NOMBRE_MUNICIPIO")) {
            value = a[16];
        } else if (fieldName.equals("NOMBRE_DEPAR")) {
            value = a[17];
        } else if (fieldName.equals("AREA_PROCE")) {
            value = a[18];
        } else if (fieldName.equals("NACIONALIDAD")) {
            value = a[19];
        } else if (fieldName.equals("DESC_ENTIDAD")) {
            value = a[20];
        } else if (fieldName.equals("TIPO_AFILIACION")) {
            value = a[21];
        } else if (fieldName.equals("SUFRE_VIOL")) {
            value = a[22];
        } else if (fieldName.equals("COD_CLINICA_CONS")) {
            value = a[23];
        } else if (fieldName.equals("FECHA_CONSULTA")) {
            value = a[24];
        } else if (fieldName.equals("COD_MED_CONS")) {
            value = a[25];
        } else if (fieldName.equals("NOM_MED_CONS")) {
            value = a[26];
        } else if (fieldName.equals("NUM_FACTURA")) {
            value = a[27];
        } else if (fieldName.equals("FUR")) {
            value = a[28];
        } else if (fieldName.equals("SEMANA_EMBARAZO")) {
            value = a[29];
        } else if (fieldName.equals("ANTE_GESTA")) {
            value = a[30];
        } else if (fieldName.equals("ANTE_PARTO")) {
            value = a[31];
        } else if (fieldName.equals("ANTE_ABORTO")) {
            value = a[32];
        } else if (fieldName.equals("ANTE_CESAREA")) {
            value = a[33];
        } else if (fieldName.equals("ANTE_VIVO")) {
            value = a[34];
        } else if (fieldName.equals("ANTE_PLANI")) {
            Object valor = new Object();
            if(a[35]!=null){
                valor = a[35];
                valor = valor.toString();
                value = valor;
            }
        } else if (fieldName.equals("CAUSAL")) {
            value = a[36];
        } else if (fieldName.equals("DESCDP")) {
            value = a[37];
        } else if (fieldName.equals("DIAG_PRINCI")) {
            value = a[38];
        } else if (fieldName.equals("DESCREL1")) {
            value = a[39];
        } else if (fieldName.equals("DIAG_REL1")) {
            value = a[40];
        } else if (fieldName.equals("DESCREL2")) {
            value = a[41];
        } else if (fieldName.equals("DIAG_REL2")) {
            value = a[42];
        } else if (fieldName.equals("DESCREL3")) {
            value = a[43];
        } else if (fieldName.equals("DIAG_REL3")) {
            value = a[44];
        } else if (fieldName.equals("TIPO_PROC")) {
            value = a[45];
        } else if (fieldName.equals("CODIGO_CUPS")) {
            value = a[46];
        } else if (fieldName.equals("ESCOGE_VOLUNTARIAMENTE")) {
            value = a[47];
        } else if (fieldName.equals("COD_CLINICA_PRO")) {
            value = a[48];
        } else if (fieldName.equals("NOM_MED_PROC")) {
            value = a[49];
        } else if (fieldName.equals("CARGO_MED_PROC")) {
            value = a[50];
        } else if (fieldName.equals("FECHA_PROCEDIMIENTO")) {
            value = a[51];
        } else if (fieldName.equals("NUMERO_FACTURA")) {
            value = a[52];
        }

        return value;
    }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

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

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public void setLstIVE(List lstIVE) {
        this.lstIVE = lstIVE;
    }

    public List getLstIVE() {
        return lstIVE;
    }

    public void setWcodclin(Integer wcodclin) {
        this.wcodclin = wcodclin;
    }

    public Integer getWcodclin() {
        return wcodclin;
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


    //-----------------------------------------------------------------------
    //  Bot�n Secundario
    //-----------------------------------------------------------------------

    public String volverInicio() {
        FacesUtils.resetManagedBean("reporteIlveNacionalBean");
        return "home";
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    public void generarReporteIlve() {
        index = -1;
        generoReporte = false;
        try {
            lstIVE = 
                    serviceLocator.getClinicoService().getReporteIlveNal(fechaInicial, 
                                                                         fechaFinal, 
                                                                         wcodclin);

            if (lstIVE != null && !lstIVE.isEmpty()) {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteIVENal.jasper");
                /*  java.net.URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                 java.net.URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                 java.net.URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");
                 if(url != null)
                 {
                     Map parameters = new HashMap();
                     parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                     parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                     parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                     parameters.put("FECHA", new Date());
                     parameters.put("CENTRO", getClinica().getCclcnombre());
                     parameters.put("FECHA_INICIAL", fechaInicial);
                     parameters.put("FECHA_FINAL", fechaFinal);
                     generoReporte = true;
                     JasperReport report = (JasperReport)JRLoader.loadObject(url);
                     byte bytes[] = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                     PdfServletUtils.showPdfDocument(bytes, (new StringBuilder()).append("AntecedentesGinecologicos").append(Calendar.getInstance().getTimeInMillis()).append(".pdf").toString(), false);
                 }

                 */

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
                                                    "reporteIveNacional" + ".xls", 
                                                    false);

                    generoReporte = true;
                }


            } else {
                FacesUtils.addErrorMessage("No existen resultados con esos criterios de busqueda");
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar el reporte ").append(e.getMessage()).toString());
        }

    }


}
