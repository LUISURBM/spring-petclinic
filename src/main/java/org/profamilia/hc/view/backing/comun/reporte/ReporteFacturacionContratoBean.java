package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cvcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteFacturacionContratoBean extends BaseBean implements JRDataSource {

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


    String ESTADO;
    BigDecimal NUMERO_FACTURA;
    String CODIGO_SERVICIO;
    String NOMBRE_SERVICIO;
    String TIPO_DOCUMENTO;
    BigDecimal NUMERO_DOCUMENTO;
    String NOMBRES;
    Date FECHA_FACTURA;
    String CLASE_FACTURA;
    BigDecimal VALOR_TOTAL;
    BigDecimal NUMERO_CONTRATO;
    String NOMBRE_CONTRATO;
    BigDecimal CODIGO_CLINICA;
    String NOMBRE_CLINICA;

    public ReporteFacturacionContratoBean() {
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


        if (fieldName.equals("ESTADO"))
            value = ESTADO;


        else if (fieldName.equals("NUMERO_FACTURA"))
            value = NUMERO_FACTURA;
        else if (fieldName.equals("CODIGO_SERVICIO"))
            value = CODIGO_SERVICIO;
        else if (fieldName.equals("NOMBRE_SERVICIO"))
            value = NOMBRE_SERVICIO;
        else if (fieldName.equals("TIPO_DOCUMENTO"))
            value = TIPO_DOCUMENTO;
        else if (fieldName.equals("NUMERO_DOCUMENTO"))
            value = NUMERO_DOCUMENTO;
        else if (fieldName.equals("NOMBRES"))
            value = NOMBRES;
        else if (fieldName.equals("FECHA_FACTURA"))
            value = FECHA_FACTURA;
        else if (fieldName.equals("CLASE_FACTURA"))
            value = CLASE_FACTURA;
        else if (fieldName.equals("VALOR_TOTAL"))
            value = VALOR_TOTAL;
        else if (fieldName.equals("NUMERO_CONTRATO"))
            value = NUMERO_CONTRATO;
        else if (fieldName.equals("NOMBRE_CONTRATO"))
            value = NOMBRE_CONTRATO;
        else if (fieldName.equals("CODIGO_CLINICA"))
            value = CODIGO_CLINICA;
        else if (fieldName.equals("NOMBRE_CLINICA"))
            value = NOMBRE_CLINICA;
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

        ESTADO = null;
        NUMERO_FACTURA = null;
        CODIGO_SERVICIO = null;
        NOMBRE_SERVICIO = null;
        TIPO_DOCUMENTO = null;
        NUMERO_DOCUMENTO = null;
        NOMBRES = null;
        FECHA_FACTURA = null;
        CLASE_FACTURA = null;
        VALOR_TOTAL = null;
        NUMERO_CONTRATO = null;
        NOMBRE_CONTRATO = null;
        CODIGO_CLINICA = null;
        NOMBRE_CLINICA = null;

        Object[] aux = lstReporte.get(indexAux);

        if (aux != null) {
            if (aux[0] != null) {
                ESTADO = aux[0].toString();
            }

            if (aux[1] != null) {
                NUMERO_FACTURA = new BigDecimal(aux[1].toString());
            }


            if (aux[2] != null) {
                CODIGO_SERVICIO = aux[2].toString();
            }

            if (aux[3] != null) {
                NOMBRE_SERVICIO = aux[3].toString();
            }


            if (aux[4] != null) {
                TIPO_DOCUMENTO = aux[4].toString();

            }


            if (aux[5] != null) {
                NUMERO_DOCUMENTO = new BigDecimal(aux[5].toString());
            }


            if (aux[6] != null) {
                NOMBRES = aux[6].toString();
            }


            if (aux[7] != null) {
                FECHA_FACTURA = (Date)aux[7];
            }


            if (aux[8] != null) {
                CLASE_FACTURA = aux[8].toString();
            }

            if (aux[9] != null) {
                VALOR_TOTAL = new BigDecimal(aux[9].toString());
            }

            if (aux[10] != null) {
                NUMERO_CONTRATO = new BigDecimal(aux[10].toString());
            }

            if (aux[11] != null) {
                NOMBRE_CONTRATO = aux[11].toString();
            }


            if (aux[12] != null) {
                CODIGO_CLINICA = new BigDecimal(aux[12].toString());
            }

            if (aux[13] != null) {
                NOMBRE_CLINICA = aux[13].toString();
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
//           lstTipoUsuariosAux = 
//                (ArrayList<Cpcontrato>)this.serviceLocator.getClinicoService().getTipoUsuarioClinico(getWcodclin());
           lstTipoUsuariosAux = 
                (ArrayList<Cvcontrato>)this.serviceLocator.getClinicoService().getCvcontratoClinico(getWcodclin());
       } catch (ModelException e) {
           e.printStackTrace();
       }

       if (lstTipoUsuariosAux != null && !lstTipoUsuariosAux.isEmpty()) {
          Iterator it = lstTipoUsuariosAux.iterator();
          int i = 0;
          lstTipoUsuarios.add(new SelectItem("", "Seleccione una opci�n ..."));
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
        String nombSalida = "ReporteFacturasXContrato_" + new Date();


        urlAux = "/reports/reporteFacturasPorContrato.jasper";


        try {
            lstReporte = 
                    this.serviceLocator.getClinicoService().getReporteFacturacionContrato(fechaInicial, 
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


                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                   url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", getClinica().getCclcnombre());
                    parameters.put("FECHA_INICIAL", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);


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
