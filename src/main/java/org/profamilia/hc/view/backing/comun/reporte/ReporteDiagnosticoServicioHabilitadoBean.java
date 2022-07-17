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
import org.profamilia.hc.model.dto.Cvcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteDiagnosticoServicioHabilitadoBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer wcodclin;

    private Integer codcontrato;

    private List lstContratos;

    private boolean generoReporte;

    private List<Object[]> lstReporte;
    
    private UIInput mnuCodclin;

    private int index;

    private List lstClinicas;

    private List lstTipoUsuarios;

    BigDecimal CLINICA;
    BigDecimal GRUPO_HABILITADO;
    String NOMBRE_HABILITADO;
    String DIAGNOSTICO;
    String NOMBRE_DIAGNOSTICO;
    BigDecimal CANTIDAD;

    public ReporteDiagnosticoServicioHabilitadoBean() {
    }

    public void init() {
        inicializarReporteFacturacionContrato();
    }

    public void inicializarReporteFacturacionContrato() {
        lstClinicas = new ArrayList();
        lstTipoUsuarios = new ArrayList();

        setWcodclin(this.getClinica().getCclncodigo());
    }

    /**
     * @return
     */

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

        if (fieldName.equals("CLINICA"))
            value = CLINICA;
        else if (fieldName.equals("GRUPO_HABILITADO"))
            value = GRUPO_HABILITADO;
        else if (fieldName.equals("NOMBRE_HABILITADO"))
            value = NOMBRE_HABILITADO;
        else if (fieldName.equals("DIAGNOSTICO"))
            value = DIAGNOSTICO;
        else if (fieldName.equals("NOMBRE_DIAGNOSTICO"))
            value = NOMBRE_DIAGNOSTICO;
        else if (fieldName.equals("CANTIDAD"))
            value = CANTIDAD;
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

    public void setCodcontrato(Integer codcontrato) {
        this.codcontrato = codcontrato;
    }

    public Integer getCodcontrato() {
        return codcontrato;
    }

    public void setLstContratos(List lstContratos) {
        this.lstContratos = lstContratos;
    }

    public List getLstContratos() {
        return lstContratos;
    }

    public void obtenerDatosReporte(int indexAux) {

        CLINICA = null;
        GRUPO_HABILITADO = null;
        NOMBRE_HABILITADO = null;
        DIAGNOSTICO = null;
        NOMBRE_DIAGNOSTICO = null;
        CANTIDAD = null;

        Object[] aux = lstReporte.get(indexAux);

        if (aux != null) {
            if (aux[0] != null) {
                CLINICA = (BigDecimal) aux[0];
            }
            if (aux[1] != null) {
                GRUPO_HABILITADO = (BigDecimal)aux[1];
            }
            if (aux[2] != null) {
                NOMBRE_HABILITADO = aux[2].toString();
            }
            if (aux[3] != null) {
                DIAGNOSTICO = aux[3].toString();
            }
            if (aux[4] != null) {
                NOMBRE_DIAGNOSTICO = aux[4].toString();
            }
            if (aux[5] != null) {
                CANTIDAD = (BigDecimal) aux[5];
            }
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

    /**
     * @param param
     */
    public void changeClinica() {
        getLstTipoUsuarios();
    }


    /**
     * @param param
     */
    public void setLstTipoUsuarios(List<SelectItem> param) {
        this.lstTipoUsuarios = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstTipoUsuarios() {
       lstTipoUsuarios = new ArrayList<SelectItem>();
       ArrayList<Cvcontrato> lstTipoUsuariosAux = null;
       try {
           lstTipoUsuariosAux = 
                (ArrayList<Cvcontrato>)this.serviceLocator.getClinicoService().getCvcontratoClinico(getWcodclin());
       } catch (ModelException e) {
           e.printStackTrace();
       }

       if (lstTipoUsuariosAux != null && !lstTipoUsuariosAux.isEmpty()) {
          Iterator it = lstTipoUsuariosAux.iterator();
          int i = 0;
          lstTipoUsuarios.add(new SelectItem(0, "Todos los Contratos"));
          while (it.hasNext()) {
              it.next();
              if (wcodclin.intValue() == 0) {
                  lstTipoUsuarios.add(new SelectItem(lstTipoUsuariosAux.get(i).getId().getCcnnnumero(), 
                                 "Cl�nica " + lstTipoUsuariosAux.get(i).getId().getCcnnclinic() + 
                                 " - " +lstTipoUsuariosAux.get(i).getId().getCcnnnumero().toString() + " " + 
                                 lstTipoUsuariosAux.get(i).getCcncdescri()));
              } else {
                  lstTipoUsuarios.add(new SelectItem(lstTipoUsuariosAux.get(i).getId().getCcnnnumero(), 
                                 lstTipoUsuariosAux.get(i).getId().getCcnnnumero().toString() + " " + 
                                 lstTipoUsuariosAux.get(i).getCcncdescri()));
              }
              i++;
          }
        }
        return lstTipoUsuarios;
    }

    public void generarReporte() {
        index = -1;

        String urlAux = "";
        generoReporte = false;
        String nombSalida = "ReporteDiagnosticoServicioHabilitado_" + new Date();

        urlAux = "/reports/reporteDiagSrvHabilitado.jasper";

        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getDiagnosticosSrvHabilitados(fechaInicial, 
                                                                                          fechaFinal, 
                                                                                          codcontrato, 
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
                    parameters.put("CONTRATO", codcontrato);
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
