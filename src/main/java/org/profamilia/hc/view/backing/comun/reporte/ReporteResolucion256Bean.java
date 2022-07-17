//=======================================================================
// ARCHIVO Reporte Ilve
// FECHA CREACI�N: 07/10/2015
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Reporte Ilve Solicitado por Medellin (Angela Faria Soto)
//=======================================================================
package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

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
public class ReporteResolucion256Bean extends BaseBean implements JRDataSource {

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lst256;
    private Integer wcodclin;
    private List lstClinicas;


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE REPORTE
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ReporteResolucion256Bean() {

    }


    //-----------------------------------------------------------------------
    //  REPORT
    //-----------------------------------------------------------------------


    public boolean next() {
        index++;
        if (lst256 != null)
            return index < lst256.size();
        else
            return false;
    }

    public Object getFieldValue(JRField jrField) {
        Object value = null;
        Object a[] = null;
        String fechaNacForm = null;
        String fechaProForm = null;
        String fechaSolForm = null;
        String CodMuni = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("00000");

        String fieldName = jrField.getName();
        if (lst256.get(index) != null)
            a = (Object[])lst256.get(index);


        if (fieldName.equals("CLINICA")) {
            value = a[0];
        } else if (fieldName.equals("MES")) {
            if (a[1].equals("01")) {
                value = "Enero";
            } else if (a[1].equals("02")) {
                value = "Febrero";
            } else if (a[1].equals("03")) {
                value = "Marzo";
            } else if (a[1].equals("04")) {
                value = "Abril";
            } else if (a[1].equals("05")) {
                value = "Mayo";
            } else if (a[1].equals("06")) {
                value = "Junio";
            } else if (a[1].equals("07")) {
                value = "Julio";
            } else if (a[1].equals("08")) {
                value = "Agosto";
            } else if (a[1].equals("09")) {
                value = "Septiembre";
            } else if (a[1].equals("10")) {
                value = "Octubre";
            } else if (a[1].equals("11")) {
                value = "Noviembre";
            } else if (a[1].equals("12")) {
                value = "Diciembre";
            }

        } else if (fieldName.equals("TIPO_DOC")) {
            value = a[2];
        } else if (fieldName.equals("NUM_IDEN")) {
            value = a[3];
        } else if (fieldName.equals("FECHA_NAC")) {
            fechaNacForm = 
                    (new StringBuilder()).append(dateFormat.format(a[4])).toString();
            value = fechaNacForm;
        } else if (fieldName.equals("SEXO")) {
            if (a[5].equals("F")) {
                a[5] = "M";
            } else if (a[5].equals("M")) {
                a[5] = "H";
            }
            value = a[5];
        } else if (fieldName.equals("NOMBRE1")) {
            value = soloLetras((String) a[6]);
        } else if (fieldName.equals("NOMBRE2")) {
            value = soloLetras((String)a[7]);
        } else if (fieldName.equals("APELLIDO1")) {
            value = soloLetras((String)a[8]);
        } else if (fieldName.equals("APELLIDO2")) {
            value = soloLetras((String)a[9]);
        } else if (fieldName.equals("TIPO_ENTIDAD")) {
            value = a[10];
        } else if (fieldName.equals("COD_MUNICIPIO")) {
            value = a[11];
        } else if (fieldName.equals("COD_PROCEDIMIENTO")) {
            if (a[12].toString().substring(0, 1).equals("S")) {
                a[12] = a[12].toString().substring(1, 7);
            }
            value = a[12];
        } else if (fieldName.equals("FECHA_SOLICITUD_PROC")) {
            fechaSolForm = 
                    (new StringBuilder()).append(dateFormat.format(a[13])).toString();
            value = fechaSolForm;
        } else if (fieldName.equals("FECHA_PROCEDIMIENTO")) {
            fechaProForm = 
                    (new StringBuilder()).append(dateFormat.format(a[14])).toString();
            value = fechaProForm;
        } else if (fieldName.equals("REALIZO_PROCEDIMIENTO")) {
            Object valor = new Object();
            if (a[15] != null) {
                valor = a[15];
                valor = valor.toString();
                if (valor.equals("S")) {
                    valor = "1";
                } else if (valor.equals("N")) {
                    valor = "2";
                }
                value = valor;
            }
        } else if (fieldName.equals("CAUSA_NO_PRO")) {
            value = a[16];
        } else if (fieldName.equals("REPROGAMO")) {
            Object valor = new Object();
            if (a[17] != null) {
                valor = a[17];
                valor = valor.toString();
                if (valor.equals("S")) {
                    valor = "1";
                } else if (valor.equals("N")) {
                    valor = "2";
                }
                value = valor;
            }
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


    public void setLst256(List lst256) {
        this.lst256 = lst256;
    }

    public List getLst256() {
        return lst256;
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


    public void generarReporte256() {
        index = -1;
        generoReporte = false;
        try {
            lst256 = 
                    serviceLocator.getClinicoService().getReporteResolucion256(fechaInicial, 
                                                                               fechaFinal, 
                                                                               wcodclin);

            if (lst256 != null && !lst256.isEmpty()) {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporte256.jasper");

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
                                                    "reporte" + ".xls", false);

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
    
    public String soloLetras(String campo) {
       String letras = "abcdefghijklmn�opqrstuvwxyz ABCDEFGHIJKLMN�OPQRSTUVWXYZ";
       String wnuevo = "";
       if (campo != null) {
           for (int i = 0; i < campo.length(); i++) {
               if (letras.contains(campo.substring(i,i+1))) {
                    wnuevo = wnuevo + campo.substring(i,i+1);
               }
           }
       }
       return wnuevo;
    }
    


}
