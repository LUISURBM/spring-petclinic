package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
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
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteMedicamentoVacunaBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer wcodclin;

    private boolean generoReporte;

    private List<Object[]> lstReporte;
    
    private UIInput mnuCodclin;

    private int index;

    private List lstClinicas;

    Date FECHA_CNS;
    BigDecimal CLINICA_COD;
    String CLINICA_NOM;
    String TIPO_ID;
    BigDecimal NUMERO_ID;
    String SERVICIO_COD;
    String SERVICIO_NOM;
    String DESCRI;
    String PRESENTACION;
    String PRESENTACION_NOM;
    String VIA_ADM;
    String VIA_NOM;
    String VIA_OTR;
    String LOTE;
    String SITIO;
    String SITIO_NOM;
    Date FECHA_VEN;
    BigDecimal DOSIS;
    String OPERADOR;
    String LABORATORIO;
    String HISTORIA;
    String MEDIDA;
    String MEDIDA_NOM;
    BigDecimal VACUNA;
    String OBSERVACION;
    String COMPLICACION;
    String REACCION;
    String COMPLICACION_CUAL;
    String REACCION_CUAL;

    public ReporteMedicamentoVacunaBean() {
    }

    public void init() {
        inicializarReporteMedicamentoVacuna();
    }

    public void inicializarReporteMedicamentoVacuna() {
        lstClinicas = new ArrayList();

        setWcodclin(this.getClinica().getCclncodigo());
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

        if (fieldName.equals("FECHA_CNS"))
            value = FECHA_CNS;
        else if (fieldName.equals("CLINICA_COD"))
            value = CLINICA_COD;
        else if (fieldName.equals("CLINICA_NOM"))
            value = CLINICA_NOM;
        else if (fieldName.equals("TIPO_ID"))
            value = TIPO_ID;
        else if (fieldName.equals("NUMERO_ID"))
            value = NUMERO_ID;
        else if (fieldName.equals("SERVICIO_COD"))
            value = SERVICIO_COD;
        else if (fieldName.equals("SERVICIO_NOM"))
            value = SERVICIO_NOM;
        else if (fieldName.equals("DESCRI"))
            value = DESCRI;
        else if (fieldName.equals("PRESENTACION"))
            value = PRESENTACION;
        else if (fieldName.equals("PRESENTACION_NOM"))
            value = PRESENTACION_NOM;
        else if (fieldName.equals("VIA_ADM"))
            value = VIA_ADM;
        else if (fieldName.equals("VIA_NOM"))
            value = VIA_NOM;
        else if (fieldName.equals("VIA_OTR"))
            value = VIA_OTR;
        else if (fieldName.equals("LOTE"))
            value = LOTE;
        else if (fieldName.equals("SITIO"))
            value = SITIO;
        else if (fieldName.equals("SITIO_NOM"))
            value = SITIO_NOM;
        else if (fieldName.equals("FECHA_VEN"))
            value = FECHA_VEN;
        else if (fieldName.equals("DOSIS"))
            value = DOSIS;
        else if (fieldName.equals("OPERADOR"))
            value = OPERADOR;
        else if (fieldName.equals("LABORATORIO"))
            value = LABORATORIO;
        else if (fieldName.equals("HISTORIA"))
            value = HISTORIA;
        else if (fieldName.equals("MEDIDA"))
            value = MEDIDA;
        else if (fieldName.equals("MEDIDA_NOM"))
            value = MEDIDA_NOM;
        else if (fieldName.equals("VACUNA"))
            value = VACUNA;
        else if (fieldName.equals("OBSERVACION"))
            value = OBSERVACION;
        else if (fieldName.equals("COMPLICACION"))
            value = COMPLICACION;
        else if (fieldName.equals("REACCION"))
            value = REACCION;
        else if (fieldName.equals("COMPLICACION_CUAL"))
            value = COMPLICACION_CUAL;
        else if (fieldName.equals("REACCION_CUAL"))
            value = REACCION_CUAL;
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

        FECHA_CNS = null;
        CLINICA_COD = null;
        CLINICA_NOM = null;
        TIPO_ID = null;
        NUMERO_ID = null;
        SERVICIO_COD = null;
        SERVICIO_NOM = null;
        DESCRI = null;
        PRESENTACION = null;
        PRESENTACION_NOM = null;
        VIA_ADM = null;
        VIA_NOM = null;
        VIA_OTR = null;
        LOTE = null;
        SITIO = null;
        SITIO_NOM = null;
        FECHA_VEN = null;
        DOSIS = null;
        OPERADOR = null;
        LABORATORIO = null;
        HISTORIA = null;
        MEDIDA = null;
        MEDIDA_NOM = null;
        VACUNA = null;
        OBSERVACION = null;
        COMPLICACION = null;
        REACCION = null;
        COMPLICACION_CUAL = null;
        REACCION_CUAL = null;

        Object[] aux = lstReporte.get(indexAux);
        if (aux != null) {
            if (aux[0] != null) 
                FECHA_CNS = (Date) aux[0];
            if (aux[1] != null) 
                CLINICA_COD = (BigDecimal)aux[1];
            if (aux[2] != null) 
                CLINICA_NOM = aux[2].toString();
            if (aux[3] != null) 
                TIPO_ID = aux[3].toString();
            if (aux[4] != null) 
                NUMERO_ID = (BigDecimal) aux[4];
            if (aux[5] != null) 
                SERVICIO_COD = aux[5].toString();
            if (aux[6] != null)
                SERVICIO_NOM = aux[6].toString();
            if (aux[7] != null)
                DESCRI = aux[7].toString();
            if (aux[8] != null) {
                PRESENTACION = aux[8].toString();
                if (PRESENTACION.equals("AMPO")) 
                   PRESENTACION_NOM = "Ampolla";
                else if (PRESENTACION.equals("CREM"))
                   PRESENTACION_NOM = "Crema";
                else if (PRESENTACION.equals("DIU"))
                   PRESENTACION_NOM = "Diu";
                else if (PRESENTACION.equals("EMUL"))
                   PRESENTACION_NOM = "Emulsiones";
                else if (PRESENTACION.equals("GOTA"))
                   PRESENTACION_NOM = "Gota";
                else if (PRESENTACION.equals("IMSU"))
                   PRESENTACION_NOM = "Implante Subdermico";
                else if (PRESENTACION.equals("INTR"))
                   PRESENTACION_NOM = "Intrauterino";
                else if (PRESENTACION.equals("INYE"))
                   PRESENTACION_NOM = "Inyectable";
                else if (PRESENTACION.equals("JEPR"))
                   PRESENTACION_NOM = "Jeringa Prellena";
                else if (PRESENTACION.equals("OVUL"))
                   PRESENTACION_NOM = "Ovulo";
                else if (PRESENTACION.equals("POLV"))
                   PRESENTACION_NOM = "Polvo";
                else if (PRESENTACION.equals("SOLU"))
                   PRESENTACION_NOM = "Solucion Liquida";
                else if (PRESENTACION.equals("SUSP"))
                   PRESENTACION_NOM = "Suspensi�n";
                else if (PRESENTACION.equals("TABL"))
                   PRESENTACION_NOM = "Tableta";
                else if (PRESENTACION.equals("CAPS"))
                   PRESENTACION_NOM = "Capsulas";
                else if (PRESENTACION.equals("IMPL"))
                   PRESENTACION_NOM = "Implante";
                else if (PRESENTACION.equals("INH"))
                   PRESENTACION_NOM = "Inhalable";
                else if (PRESENTACION.equals("N/A"))
                   PRESENTACION_NOM = "No Aplica";
            }
            if (aux[9] != null) {
                VIA_ADM = aux[9].toString();
                if (VIA_ADM.equals("IM")) 
                   VIA_NOM = "Intramuscular";
                else if (VIA_ADM.equals("IV"))
                   VIA_NOM = "Intravenosa";
                else if (VIA_ADM.equals("VO"))
                   VIA_NOM = "Oral";
                else if (VIA_ADM.equals("VV"))
                   VIA_NOM = "Vaginal";
                else if (VIA_ADM.equals("VP"))
                   VIA_NOM = "Parenteral";
                else if (VIA_ADM.equals("VR"))
                   VIA_NOM = "Rectal";
                else if (VIA_ADM.equals("Vsc"))
                   VIA_NOM = "Subcutanea";
                else if (VIA_ADM.equals("Vsl"))
                   VIA_NOM = "Sublingual";
                else if (VIA_ADM.equals("Vn"))
                   VIA_NOM = "Nasal";
                else if (VIA_ADM.equals("Vt"))
                   VIA_NOM = "Topica";
                else if (VIA_ADM.equals("INH"))
                   VIA_NOM = "Inhalatoria";
                else if (VIA_ADM.equals("VOF"))
                   VIA_NOM = "Oftalmica";
                else if (VIA_ADM.equals("VOT"))
                   VIA_NOM = "Otica";
                else if (VIA_ADM.equals("VTO"))
                   VIA_NOM = "Topica";
                else if (VIA_ADM.equals("N/A"))
                   VIA_NOM = "No Aplica";
            }
            if (aux[10] != null)
                VIA_OTR = aux[10].toString();
            if (aux[11] != null)
                LOTE = aux[11].toString();
            if (aux[12] != null) {
                SITIO = aux[12].toString();
                if (SITIO.equals("GD")) 
                   SITIO_NOM = "Gl�teo Derecho";
                else if (SITIO.equals("GI"))
                   SITIO_NOM = "Gl�teo Izquierdo";
                else if (SITIO.equals("DD"))
                   SITIO_NOM = "Deltoides Derecho";
                else if (SITIO.equals("DI"))
                   SITIO_NOM = "Deltoides Izquierdo";
                else if (SITIO.equals("MD"))
                   SITIO_NOM = "Muslo Derecho";
                else if (SITIO.equals("MI"))
                   SITIO_NOM = "Muslo Izquierdo";
                else if (SITIO.equals("PE"))
                   SITIO_NOM = "Periumbilical";
                else if (SITIO.equals("NA"))
                   SITIO_NOM = "No Aplica";
            }
            if (aux[13] != null)
                FECHA_VEN = (Date) aux[13];
            if (aux[14] != null) 
                DOSIS = (BigDecimal) aux[14];
            if (aux[15] != null) 
                OPERADOR = aux[15].toString();
            if (aux[16] != null) 
                LABORATORIO = aux[16].toString();
            if (aux[17] != null)
                HISTORIA = aux[17].toString();
            if (aux[18] != null) {
                MEDIDA = aux[18].toString();
                if (MEDIDA.equals("g")) 
                   MEDIDA_NOM = "Gramo";
                else if (MEDIDA.equals("G"))
                   MEDIDA_NOM = "Gramo";
                else if (MEDIDA.equals("G/L"))
                   MEDIDA_NOM = "Gramo/Litro";
                else if (MEDIDA.equals("g/mL"))
                   MEDIDA_NOM = "Gramo X Mililitro";
                else if (MEDIDA.equals("mcg"))
                   MEDIDA_NOM = "Microgramo";
                else if (MEDIDA.equals("mg"))
                   MEDIDA_NOM = "Miligramo";
                else if (MEDIDA.equals("mg/mL"))
                   MEDIDA_NOM = "Microgramo X Mililitro";
                else if (MEDIDA.equals("MEQ/ML"))
                   MEDIDA_NOM = "MEQ/ML";
                else if (MEDIDA.equals("MG/MCG"))
                   MEDIDA_NOM = "MG/MCG";
                else if (MEDIDA.equals("mcg/ML"))
                   MEDIDA_NOM = "mcg/ML";
                else if (MEDIDA.equals("MCG"))
                   MEDIDA_NOM = "MCG";
                else if (MEDIDA.equals("MG-G"))
                   MEDIDA_NOM = "MG-G";
                else if (MEDIDA.equals("mL"))
                   MEDIDA_NOM = "Mililitro";
                else if (MEDIDA.equals("UI"))
                   MEDIDA_NOM = "Unidad Internacional";
                else if (MEDIDA.equals("UI/ML"))
                   MEDIDA_NOM = "Unidad Internacional/ Mililitro";
                else if (MEDIDA.equals("%"))
                   MEDIDA_NOM = "Porcentaje";
            }
            if (aux[19] != null)
                VACUNA = (BigDecimal) aux[19];
            if (aux[20] != null)
                OBSERVACION = aux[20].toString();
            if (aux[21] != null)
                COMPLICACION = aux[21].toString();
            if (aux[22] != null)
                REACCION = aux[22].toString();
            if (aux[23] != null)
                COMPLICACION_CUAL = aux[23].toString();
            if (aux[24] != null)
                REACCION_CUAL = aux[24].toString();
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

    /**
     * @param valueChangeEvent
     */
    public void setWcodclin(ValueChangeEvent valueChangeEvent) {
        setWcodclin((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
        String nombSalida = "ReporteMedicamentoVacuna_" + new Date();

        urlAux = "/reports/reporteMedVacuna.jasper";

        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getMedicamentoVacuna(fechaInicial, 
                                                                                          fechaFinal, 
                                                                                          wcodclin);
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
                    SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");

                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                   url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", wcodclin);
                    parameters.put("FECHA_INICIAL", formatFecha.format(fechaInicial));
                    parameters.put("FECHA_FINAL", formatFecha.format(fechaFinal));

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

    public void setMnuCodclin(UIInput mnuCodclin) {
        this.mnuCodclin = mnuCodclin;
    }

    public UIInput getMnuCodclin() {
        return mnuCodclin;
    }


}
