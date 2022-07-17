//=======================================================================
// ARCHIVO ResultadoLecturaUnoBean.java
// FECHA CREACI�N: 16/09/2010
// AUTOR: Jhon Carranza Silva
// Descripci�n: Registro de los resultados de la primera lectura.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;

import javax.faces.component.html.HtmlDataTable;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chdetaentcito;
import org.profamilia.hc.model.dto.Chentregacitol;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ResultadoLecturaUnoBean
//=======================================================================
public class ResultadoLecturaUnoBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Integer idListado;

    private HtmlDataTable dtListadoCitologias;

    List<Chdetaentcito> listadoCitologias = new ArrayList<Chdetaentcito>();

    private String tipoLectura;

    /**
     * Actualizacion Resultados de Citologias 
     */
    private

    Integer idListado_mod;

    private String tipoLectura_mod;

    List<Chdetaentcito> listadoCitologias_mod = new ArrayList<Chdetaentcito>();

    List<Chdetaentcito> listadoCitologias_sel = new ArrayList<Chdetaentcito>();

    private HtmlDataTable dtlistadoCitologias_mod;

    private String imprimeListado;

    private int index = -1;

    private boolean generoReporte;
    
    private List listaCitologias = new ArrayList();
    
    private boolean generarCSV;



    public ResultadoLecturaUnoBean() {
    }

    public void init() {
        listadoCitologias = new ArrayList<Chdetaentcito>();
        listadoCitologias_mod = new ArrayList<Chdetaentcito>();
        listadoCitologias_sel = new ArrayList<Chdetaentcito>();
        imprimeListado = "N";

    }

    // ACTIONS

    public void generarListadoCitologias_mod() {
        listadoCitologias_mod = new ArrayList<Chdetaentcito>();
        tipoLectura_mod = "";
        generoReporte = false;
        generarCSV=false;

        try {
            listadoCitologias_mod = 
                    (ArrayList<Chdetaentcito>)this.serviceLocator.getClinicoService().getListadoCitologias(idListado_mod, 
                                                                                                           tipoLectura_mod);
            

            if (listadoCitologias_mod.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            }else{
                int resultCompare = listadoCitologias_mod.get(0).getCncitologi().getCcintiphis().compareTo(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA);
                if(resultCompare == 0){
                    generarCSV=true;
                }else {
                    generarCSV=false;
                }
            }

        } catch (ModelException de) {
            de.printStackTrace();
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

    }

    public void generarListadoCitologias() {
        listadoCitologias = new ArrayList<Chdetaentcito>();
        try {
            listadoCitologias = 
                    (ArrayList<Chdetaentcito>)this.serviceLocator.getClinicoService().getListadoCitologias(idListado, 
                                                                                                           tipoLectura);

            if (listadoCitologias.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            }

        } catch (ModelException de) {
            de.printStackTrace();
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

    }


    public void guardarListadoCitologias() {
        boolean exito = true;
        for (Chdetaentcito detalleEntCito: listadoCitologias) {

            boolean selTipoLectura;
            boolean selEtapa = false;

            if (this.tipoLectura.equalsIgnoreCase(PRIMERA_LECTURA)) {
                selTipoLectura = 
                        detalleEntCito.getHdecresultado().equalsIgnoreCase("") || 
                        detalleEntCito.getHdecresultado() == null;
                selEtapa = 
                        detalleEntCito.getHdecetapa().equalsIgnoreCase("") || 
                        detalleEntCito.getHdecetapa() == null;
            } else {
                selTipoLectura = 
                        detalleEntCito.getHdecresultado2().equalsIgnoreCase("") || 
                        detalleEntCito.getHdecresultado2() == null;
            }

            if (selTipoLectura || selEtapa) {
                FacesUtils.addErrorMessage(MSG_RESULTADOS_INGRESADOS);
                exito = false;
                break;
            }
        }

        if (exito) {
            try {

                if (this.tipoLectura.equalsIgnoreCase(PRIMERA_LECTURA)) {
                    for (Chdetaentcito detalleentrega: listadoCitologias) {
                        detalleentrega.setHdecetapa(CITOLOGIA_REG_LECTURA_UNO);
                    }
                } else {
                    for (Chdetaentcito detalleentrega: listadoCitologias) {
                        detalleentrega.setHdecetapa(CITOLOGIA_REG_LECTURA_DOS);
                    }
                }


                this.serviceLocator.getClinicoService().saveDetalleListaCitologias(listadoCitologias);
                FacesUtils.addInfoMessage(MSG_ADICION);

            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_ADICION);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_ADICION);
            }
        }

    }


    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (this.tipoLectura_mod.equalsIgnoreCase(PRIMERA_LECTURA_MOD)) {
            Cncitologi citologia = (listadoCitologias_sel.get(index)).getCncitologi();
/*
            if (fieldName.equals("FORMATO")) {
                value = new BigDecimal((Integer)citologia.getCcinconsec());
                return value;
            } else if (fieldName.equals("NUMERO")) {
                value = new BigDecimal((Integer)citologia.getCcinnumero());
                return value;
            } else if (fieldName.equals("FECHA_REG")) {
                value = citologia.getCcidfecreg();
                return value;
            } else if (fieldName.equals("FECHA_TOMA")) {
                value = citologia.getCcidfeccit();
                return value;
            } else if (fieldName.equals("IDENTIFICACION")) {
                value = citologia.getCcictipide() + " " + citologia.getCcianumide();
                return value;
            } else if(fieldName.equals("PROFESIONAL_TOMA")){
                value = "";
            } else if (fieldName.equals("USUARIO")) {
                value = citologia.getCcicprinom() + " " + ((citologia.getCcicsegnom() == null) ? "" :
                        citologia.getCcicsegnom()) + " " + citologia.getCcicpriape() + " " +
                        ((citologia.getCcicsegape() == null) ? "" : citologia.getCcicsegape());
                return value;
            }
            */
            Cncitotoma toma = null;
            try {
                toma = this.serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se pudo consultar Toma " + 
                                           e.getMessage());
            }
            if (fieldName.equals("consecutivoProcedimiento")) { //FORMATO
                value = Long.parseLong(citologia.getCcinconsec().toString());
                return value;
            } else if (fieldName.equals("identificacionUsuario")) { //IDENTIFICACION
                value = citologia.getCcictipide() + " " + citologia.getCcianumide();
                return value;
            } else if (fieldName.equals("nombreUsuario")) { //USUARIO
             value = citologia.getCcicprinom() + " " + ((citologia.getCcicsegnom() == null) ? "" :
                     citologia.getCcicsegnom()) + " " + citologia.getCcicpriape() + " " +
                     ((citologia.getCcicsegape() == null) ? "" : citologia.getCcicsegape());
             return value;
            } else if (fieldName.equals("fechaToma")) { //FECHA_TOMA -> FECHA_Citologia
                if (toma != null) {
                    value = toma.getCtmdfectom();
                }
                return value;
            } else if (fieldName.equals("tomaNombreProfesional")) { //PROFESIONAL_TOMA
                if (toma != null) {
                    value = toma.getCtmcusureg();
                }
                return value;
            } else if (fieldName.equals("aplicaBaseLiquida")) { //Aplica Base Liquida
                if (citologia != null) {
                    try {
                        List<Cfdetafactura> listaDetafactura = 
                            this.getServiceLocator().getClinicoService().validacionTomaPaquete(Integer.parseInt(citologia.getCcilconcli().toString()));
                        if (listaDetafactura != null && 
                            !listaDetafactura.isEmpty()) {
                            return "SI";
                        } else {
                            return "NO";
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                        FacesUtils.addErrorMessage("No se pudo consultar Toma " + 
                                                   e.getMessage());
                    }
                }
            }
        } else if (this.tipoLectura_mod.equalsIgnoreCase("ArchivoEnvio")) {
            Object[] a = new Object[listaCitologias.size()];
            a = (Object[])listaCitologias.get(index);

            if (fieldName.equals("CCINCONSEC")) {
                value = formatearDecimal((BigDecimal)a[11]) ;
                return value;
            } else if (fieldName.equals("CCINCLINIC")) {
                value = formatearDecimal((BigDecimal)a[12]);
                return value;
            } else if (fieldName.equals("CCICTIPIDE")) {
                value = (String)a[13];
                return value;
            } else if (fieldName.equals("CCIANUMIDE")) {
                value = formatearDecimal((BigDecimal)a[14]);
                return value;
            } else if (fieldName.equals("CCICPRINOM")) {
                value = (String)a[15];
                return value;
            } else if (fieldName.equals("CCICSEGNOM")) {
                value = (String)a[16];
                return value;
            } else if (fieldName.equals("CCICPRIAPE")) {
                value = (String)a[17];
                return value;
            } else if (fieldName.equals("CCICSEGAPE")) {
                value = (String)a[18];
                return value;
            } else if (fieldName.equals("CCINEDAD")) {
                value = formatearDecimal((BigDecimal)a[19]);
                return value;
            } else if (fieldName.equals("CCICTIPAFI")) {
                value = (String)a[20];
                return value;
            } else if (fieldName.equals("CCICASEGUR")) {
                value = (String)a[21];
                return value;
            } else if (fieldName.equals("CCIDFECCIT")) {
                value = formatearCampo((Date)a[22]);
                return value;
            } else if (fieldName.equals("NUMERO_FAC")) {
                value = obtenerDatosReporte((BigDecimal)a[23]);
                return value;
            } else if (fieldName.equals("CCINTIPDOC")) {
                value = formatearDecimal((BigDecimal)a[24]);
                return value;
            } else if (fieldName.equals("CCINNUMDOC")) {
                value = formatearDecimal((BigDecimal)a[25]);
                return value;
            } else if (fieldName.equals("CTMCTOMADA")) {
                value = (String)a[26];
                return value;
            } else if (fieldName.equals("CTMCNOMTOM")) {
                value = (String)a[27];
                return value;
            } else if (fieldName.equals("CTMCESQUEM")) {
                value = (String)a[28];
                return value;
            } else if (fieldName.equals("CTMDULTMEN")) {
                value = formatearCampo((Date)a[29]);
                return value;
            } else if (fieldName.equals("CTMDULTPAR")) {
                value = formatearCampo((Date)a[30]);
                return value;
            } else if (fieldName.equals("CTMNGESTAC")) {
                value = formatearDecimal((BigDecimal)a[31]);
                return value;
            } else if (fieldName.equals("CTMNPARTOS")) {
                value = formatearDecimal((BigDecimal)a[32]);
                return value;
            } else if (fieldName.equals("CTMNABORTO")) {
                value = formatearDecimal((BigDecimal)a[33]);
                return value;
            } else if (fieldName.equals("CTMCEMBARA")) {
                value = (String)a[34];
                return value;
            } else if (fieldName.equals("CTMNEDAREL")) {
                value = formatearDecimal((BigDecimal)a[35]);
                return value;
            } else if (fieldName.equals("CTMCMETPLA")) {
                value = (String)a[36];
                return value;
            } else if (fieldName.equals("CTMCOTRMET")) {
                value = (String)a[37];
                return value;
            } else if (fieldName.equals("CTMNTIEMET")) {
                value = formatearDecimal((BigDecimal)a[38]);
                return value;
            } else if (fieldName.equals("CTMDULTCIT")) {
                value = formatearCampo((Date)a[39]);
                return value;
            } else if (fieldName.equals("CTMCULTRES")) {
                value = (String)a[40];
                return value;
            } else if (fieldName.equals("CTMCOTRHAL")) {
                value = (String)a[41];
                return value;
            } else if (fieldName.equals("CTMCPNINGU")) {
                value = (String)a[42];
                return value;
            } else if (fieldName.equals("CTMCPCAUTE")) {
                value = (String)a[43];
                return value;
            } else if (fieldName.equals("CTMDPCAUTE")) {
                value = formatearCampo((Date)a[44]);
                return value;
            } else if (fieldName.equals("CTMCPHISTE")) {
                value = (String)a[45];
                return value;
            } else if (fieldName.equals("CTMDPHISTE")) {
                value = formatearCampo((Date)a[46]);
                return value;
            } else if (fieldName.equals("CTMCPCONIZ")) {
                value = (String)a[47];
                return value;
            } else if (fieldName.equals("CTMDPCONIZ")) {
                value = formatearCampo((Date)a[48]);
                return value;
            } else if (fieldName.equals("CTMCPRADIO")) {
                value = (String)a[49];
                return value;
            } else if (fieldName.equals("CTMDPRADIO")) {
                value = formatearCampo((Date)a[50]);
                return value;
            } else if (fieldName.equals("CTMCPBIOPS")) {
                value = (String)a[51];
                return value;
            } else if (fieldName.equals("CTMDPBIOPS")) {
                value = formatearCampo((Date)a[52]);
                return value;
            } else if (fieldName.equals("CTMCPCRIOT")) {
                value = (String)a[53];
                return value;
            } else if (fieldName.equals("CTMDPCRIOT")) {
                value = formatearCampo((Date)a[54]);
                return value;
            } else if (fieldName.equals("CTMCPATA")) {
                value = (String)a[55];
                return value;
            } else if (fieldName.equals("CTMDPATA")) {
                value = formatearCampo((Date)a[56]);
                return value;
            } else if (fieldName.equals("CTMCPOTRO")) {
                value = (String)a[57];
                return value;
            } else if (fieldName.equals("CTMDPOTRO")) {
                value = formatearCampo((Date)a[58]);
                return value;
            } else if (fieldName.equals("CTMCPDOTRO")) {
                value = (String)a[59];
                return value;
            } else if (fieldName.equals("CTMCPVAPOR")) {
                value = (String)a[60];
                return value;
            } else if (fieldName.equals("CTMDPVAPOR")) {
                value = formatearCampo((Date)a[61]);
                return value;
            } else if (fieldName.equals("CTMCPHORMO")) {
                value = (String)a[62];
                return value;
            } else if (fieldName.equals("CTMDPHORMO")) {
                value = formatearCampo((Date)a[63]);
                return value;
            } else if (fieldName.equals("CTMCASPCUE")) {
                value = (String)a[64];
                value = value.toString().replace(",","|");
                return value;
            } else if (fieldName.equals("CTMCOBSTOM")) {
                value = (String)a[65];
                if (value != null) {
                    value = value.toString().replace(","," ").replace("\""," ").replace("\n"," ");
                }
                return value;
            } else if (fieldName.equals("CTMCCOMVPH")) {
                value = (String)a[66];
                return value;
            } else if (fieldName.equals("CTMCLACTAN")) {
                value = (String)a[67];
                return value;
            } else if (fieldName.equals("CTMNNUMERO")) {
                value = formatearDecimal((BigDecimal)a[68]);
                return value;
            }
            
            
            
            
        } else {

            Chdetaentcito detaentcito = listadoCitologias_sel.get(index);
            String motivo = "";
            if (fieldName.equals("FORMATO")) {
                value = detaentcito.getCncitologi().getCcinconsec();
                return value;
            } else if (fieldName.equals("MOTIVO_ENVIO")) {
                if (detaentcito.getHdecresultado().equalsIgnoreCase("P")) {
                    motivo = "Segunda Lectura";
                } else if (detaentcito.getHdecresultado().equalsIgnoreCase("N")) {
                    motivo = "Control de Calidad";
                } else if (detaentcito.getHdecresultado().equalsIgnoreCase("NR")) {
                    motivo = "No Recibido";
                } else {
                    motivo = "";
                }
                value = motivo;
                return value;
            } else if (fieldName.equals("FECHA_TOMA")) {
                value = detaentcito.getCncitologi().getCcidfeccit();
                return value;
            } else if (fieldName.equals("IDENTIFICACION")) {
                value = detaentcito.getCncitologi().getCcictipide() + " " + detaentcito.getCncitologi().getCcianumide();
                return value;
            } else if (fieldName.equals("USUARIO")) {
                value = detaentcito.getCncitologi().getCcicprinom() + " " 
                        + ((detaentcito.getCncitologi().getCcicsegnom() == null) ? "" : 
                        detaentcito.getCncitologi().getCcicsegnom()) + " " + detaentcito.getCncitologi().getCcicpriape() + 
                        " " + ((detaentcito.getCncitologi().getCcicsegape() == null) ? "" : detaentcito.getCncitologi().getCcicsegape());
                return value;
            }
        }

        return value;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (this.tipoLectura_mod.equalsIgnoreCase("ArchivoEnvio")) {
            return (index < listaCitologias.size());
        } else {
            return (index < listadoCitologias_sel.size());
        }
    }


    public void guardarListadoCitologias_mod() {

        index = -1;
        generoReporte = false;
        tipoLectura_mod = PRIMERA_LECTURA_MOD;

        boolean exito = true;
        for (Chdetaentcito detalleEntCito: listadoCitologias_mod) {


            boolean selTipoLectura;
            boolean selEtapa = false;


            if (this.tipoLectura_mod.equalsIgnoreCase(PRIMERA_LECTURA_MOD)) {
                selTipoLectura = 
                        detalleEntCito.getHdecresultado().equalsIgnoreCase("") || 
                        detalleEntCito.getHdecresultado() == null;
                selEtapa = 
                        detalleEntCito.getHdecetapa().equalsIgnoreCase("") || 
                        detalleEntCito.getHdecetapa() == null;
            } else {
                selTipoLectura = 
                        detalleEntCito.getHdecresultado2().equalsIgnoreCase("") || 
                        detalleEntCito.getHdecresultado2() == null;
            }

            if (selTipoLectura || selEtapa) {
                FacesUtils.addErrorMessage(MSG_RESULTADOS_INGRESADOS);
                exito = false;
                break;
            }
        }

        if (exito) {
            try {

                this.serviceLocator.getClinicoService().saveDetalleListaCitologias(listadoCitologias_mod);
                FacesUtils.addInfoMessage(MSG_ACTUALIZACION);

                if (imprimeListado.equalsIgnoreCase("S")) {

                    listadoCitologias_sel = new ArrayList<Chdetaentcito>();

                    for (Chdetaentcito detalleentrega: listadoCitologias_mod) {
                        if (detalleentrega.isItemSelected()) {
                            listadoCitologias_sel.add(detalleentrega);
                        }
                    }

                    for (Chdetaentcito detalleentrega: listadoCitologias_sel) {

                        String resultado = null;

                        if (this.tipoLectura_mod.equalsIgnoreCase(PRIMERA_LECTURA_MOD)) {
                            resultado = detalleentrega.getHdecresultado();
                        } else {
                            resultado = detalleentrega.getHdecresultado2();
                        }

                        /*if( resultado.equalsIgnoreCase(NO_RECIBIDO)){
                            FacesUtils.addErrorMessage(MSG_RESULTADOS_ENVIO);
                            exito = false;
                            break;
                        }*/

                    }

                    if (listadoCitologias_sel.size() == 0) {
                        FacesUtils.addErrorMessage(MSG_VALIDACION_SELECCION_REQUERIDO);
                        exito = false;
                    }

                    if (exito) {

                        BigDecimal labLectura = null;
                        String pathReporte = null;
                        Date fechaEnvio = null;
                        String nameReporte = null;

                        Chentregacitol entregacitol = 
                            listadoCitologias_sel.get(0).getChentregacitol();

                        if (this.tipoLectura_mod.equalsIgnoreCase(PRIMERA_LECTURA_MOD)) {

                            labLectura = entregacitol.getHecnlablectura1();
                            pathReporte = 
                                    "/reports/reporteCopiaEntregaCitologias.jasper";
                            fechaEnvio = entregacitol.getHecdfechaenvio();
                            nameReporte = "lectura_uno";

                        } else {

                            labLectura = entregacitol.getHecnlablectura2();
                            pathReporte = 
                                    "/reports/reporteCitologiasLecturaDos.jasper";
                            fechaEnvio = entregacitol.getHecdfechaenvio2();
                            nameReporte = "lectura_dos";

                        }

                        Cpprofesio profe = 
                            this.serviceLocator.getClinicoService().getProfesionalXCodigo(labLectura + 
                                                                                            "", 
                                                                                          entregacitol.getHecnclinica());
                        Cpclinica centro = 
                            this.serviceLocator.getClinicoService().getClinica(entregacitol.getHecnclinica());
                        URL url = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(pathReporte);
                        URL url_profamilia = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                        URL url_super_horizontal = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                        URL url_super_vertical = 
                            FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);


                        if (url != null) {

                            Map reportParams = new HashMap();
                            reportParams.put("CENTRO", centro.getCclcnombre());
                            reportParams.put("COD_CENTRO", 
                                             centro.getCclncodigo());
                            reportParams.put("FECHA_ENVIO", fechaEnvio);
                            reportParams.put("LABORATORIO", 
                                             profe.getCpfcnombre());
                            reportParams.put("ID_LISTADO", 
                                             entregacitol.getHeclidentificador());
                            reportParams.put("IMAGE_PROFAMILIA", 
                                             url_profamilia);
                            reportParams.put("IMAGE_SUPER_HORIZONTAL", 
                                             url_super_horizontal);
                            reportParams.put("IMAGE_SUPER_VERTICAL", 
                                             url_super_vertical);

                            JasperReport report = 
                                (JasperReport)JRLoader.loadObject(url);

                            byte[] bytes;
                            bytes = 
                                    JasperRunManager.runReportToPdf(report, reportParams, 
                                                                    (JRDataSource)this);
                            PdfServletUtils.showPdfDocument(bytes, 
                                                            nameReporte + 
                                                            centro.getCclncodigo() + 
                                                            "_" + 
                                                            Calendar.getInstance().getTimeInMillis() + 
                                                            ".pdf", false);
                            generoReporte = true;

                        }
                    }

                }


            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_ACTUALIZACION);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_ACTUALIZACION);
            }
        }

    }


    public void generarArchivo() {
       index = -1;
       generoReporte = false;
       tipoLectura_mod = "ArchivoEnvio";
       String archivo = "";
       listaCitologias = new ArrayList();

        try {
            tipoLectura = "PL"; // Primera Lectura.
            listaCitologias = 
                   this.serviceLocator.getClinicoService().getEnvioCitologiaLectura(idListado_mod);
                   
            archivo = "CT" + formatearCampoFe(new Date()) + "_" + this.getClinica().getCclncodigo() 
                      + "_" + listaCitologias.size() + "_" + idListado_mod;
       
        } catch (ModelException de) {
           FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
           FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

        if (listaCitologias.isEmpty()) {
           FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaCitologiaLaboratorio2.jasper");

                if (url != null) {
                    Map parameters = new HashMap();
                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, 
                                         (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRCsvExporter exporter = new JRCsvExporter();
                    exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, baos);
                    exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ",");
                    exporter.exportReport();
                    CsvServletUtils.showCsvDocument(baos.toByteArray(), archivo + ".csv", false);

/*                   if (Ftp.conectar("192.168.25.14","citologias","pr0f42018")) {
                   Ftp.cambiarDirectorio("enviados");
                   Ftp.subirArchivo(baos.toByteArray(), archivo + ".csv" );
                   Ftp.cambiarDirectorio("..");
                   Ftp.cambiarDirectorio("historico");
                   Ftp.subirArchivo(baos.toByteArray(), archivo + ".csv" );
                   Ftp.desconectar();
               }
*/                   generoReporte = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + e.getMessage());
            }
        }
    }















    public void reimprimirListado() {
       index = -1;
       generoReporte = false;
       tipoLectura_mod = PRIMERA_LECTURA_MOD;

       boolean exito = true;
  
       if (exito) {
           try {
               listadoCitologias_sel = new ArrayList<Chdetaentcito>();

               for (Chdetaentcito detalleentrega: listadoCitologias_mod) {
                    listadoCitologias_sel.add(detalleentrega);
               }

               for (Chdetaentcito detalleentrega: listadoCitologias_sel) {
                    String resultado = null;
                    if (this.tipoLectura_mod.equalsIgnoreCase(PRIMERA_LECTURA_MOD)) {
                        resultado = detalleentrega.getHdecresultado();
                    } else {
                        resultado = detalleentrega.getHdecresultado2();
                    }
               }

               if (listadoCitologias_sel.size() == 0) {
                    FacesUtils.addErrorMessage(MSG_VALIDACION_SELECCION_REQUERIDO);
                    exito = false;
               }

               if (exito) {
                    BigDecimal labLectura = null;
                    String pathReporte = null;
                    Date fechaEnvio = null;
                    String nameReporte = null;

                    Chentregacitol entregacitol = listadoCitologias_sel.get(0).getChentregacitol();
                    Cncitologi citologia = listadoCitologias_sel.get(0).getCncitologi();

                    if (this.tipoLectura_mod.equalsIgnoreCase(PRIMERA_LECTURA_MOD)) {
                         labLectura = entregacitol.getHecnlablectura1();
                         pathReporte = "/reports/reporteEntregaProcedimientos.jasper";
                         fechaEnvio = entregacitol.getHecdfechaenvio();
                         nameReporte = "lectura_uno";
                    } else {
                         labLectura = entregacitol.getHecnlablectura2();
                         pathReporte = "/reports/reporteCitologiasLecturaDos.jasper";
                         fechaEnvio = entregacitol.getHecdfechaenvio2();
                         nameReporte = "lectura_dos";
                    }

                    Cpprofesio profe = 
                         this.serviceLocator.getClinicoService().getProfesionalXCodigo(labLectura + "", 
                                                                                          entregacitol.getHecnclinica());
                    Cpclinica centro = 
                         this.serviceLocator.getClinicoService().getClinica(entregacitol.getHecnclinica());
                    URL url = 
                         FacesUtils.getFacesContext().getExternalContext().getResource(pathReporte);
                    URL url_profamilia = 
                         FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
                    URL url_super_horizontal = 
                         FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                    URL url_super_vertical = 
                         FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

                    if (url != null) {

                        Map parameters = new HashMap();
                        if (citologia.getCcintiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
                            parameters.put("nombreFormato", 
                                           "FORMATO RELACI�N CITOLOG�A CONVENCIONAL");
                            parameters.put("laboratorio", 
                                           profe.getCpfcnombre());
                        }
                        if (citologia.getCcintiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA)) {
                            parameters.put("nombreFormato", 
                                           "FORMATO RELACI�N CITOLOG�A BASE L�QUIDA");
                            parameters.put("laboratorio", "Patolab");
                        }
                        if (citologia.getCcintiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA)) {
                            parameters.put("nombreFormato", 
                                           "FORMATO RELACI�N TIPIFICACIONES");
                            parameters.put("laboratorio", 
                                           "Laboratorio Profamilia");
                            pathReporte = "/reports/reporteEntregaProcedimientosVPH.jasper";
                            url = FacesUtils.getFacesContext().getExternalContext().getResource(pathReporte);
                        }
                        parameters.put("nombreClinica", 
                                       centro.getCclcnombre());
                        parameters.put("codigoClinica", 
                                       centro.getCclncodigo());
                        parameters.put("fechaEnvio", fechaEnvio);
                        parameters.put("consecutivoListado", 
                                       entregacitol.getHeclidentificador());
                        parameters.put("IMAGE_PROFAMILIA", url_profamilia);


                      /*  Map reportParams = new HashMap();
                         reportParams.put("CENTRO", centro.getCclcnombre());
                         reportParams.put("COD_CENTRO", centro.getCclncodigo());
                         reportParams.put("FECHA_ENVIO", fechaEnvio);
                         reportParams.put("LABORATORIO", profe.getCpfcnombre());
                         reportParams.put("ID_LISTADO", entregacitol.getHeclidentificador());
                         reportParams.put("IMAGE_PROFAMILIA", url_profamilia);
                         reportParams.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                         reportParams.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                      */
                         JasperReport report = (JasperReport)JRLoader.loadObject(url);

                         byte[] bytes;
                         bytes = JasperRunManager.runReportToPdf(report, parameters, 
                                                                (JRDataSource)this);
                         PdfServletUtils.showPdfDocument(bytes, entregacitol.getHeclidentificador() + centro.getCclncodigo() + 
                                                         "_" + Calendar.getInstance().getTimeInMillis() + 
                                                         ".pdf", false);
                         generoReporte = true;

                    }
               }

            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_ACTUALIZACION);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_ACTUALIZACION);
            }
        }
    }

    //ACCESSORS

    /**
     * @param idListado
     */
    public void setIdListado(Integer idListado) {
        this.idListado = idListado;
    }

    /**
     * @return
     */
    public Integer getIdListado() {
        return idListado;
    }

    /**
     * @param listadoCitologias
     */
    public void setListadoCitologias(List<Chdetaentcito> listadoCitologias) {
        this.listadoCitologias = listadoCitologias;
    }

    /**
     * @return
     */
    public List<Chdetaentcito> getListadoCitologias() {
        return listadoCitologias;
    }

    /**
     * @param dtListadoCitologias
     */
    public void setDtListadoCitologias(HtmlDataTable dtListadoCitologias) {
        this.dtListadoCitologias = dtListadoCitologias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtListadoCitologias() {
        return dtListadoCitologias;
    }

    /**
     * @param tipoLectura
     */
    public void setTipoLectura(String tipoLectura) {
        this.tipoLectura = tipoLectura;
    }

    /**
     * @return
     */
    public String getTipoLectura() {
        return tipoLectura;
    }

    /**
     * @param idListado_mod
     */
    public void setIdListado_mod(Integer idListado_mod) {
        this.idListado_mod = idListado_mod;
    }

    /**
     * @return
     */
    public Integer getIdListado_mod() {
        return idListado_mod;
    }

    /**
     * @param tipoLectura_mod
     */
    public void setTipoLectura_mod(String tipoLectura_mod) {
        this.tipoLectura_mod = tipoLectura_mod;
    }

    /**
     * @return
     */
    public String getTipoLectura_mod() {
        return tipoLectura_mod;
    }

    /**
     * @param listadoCitologias_mod
     */
    public void setListadoCitologias_mod(List<Chdetaentcito> listadoCitologias_mod) {
        this.listadoCitologias_mod = listadoCitologias_mod;
    }

    /**
     * @return
     */
    public List<Chdetaentcito> getListadoCitologias_mod() {
        return listadoCitologias_mod;
    }

    /**
     * @param dtlistadoCitologias_mod
     */
    public void setDtlistadoCitologias_mod(HtmlDataTable dtlistadoCitologias_mod) {
        this.dtlistadoCitologias_mod = dtlistadoCitologias_mod;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtlistadoCitologias_mod() {
        return dtlistadoCitologias_mod;
    }

    /**
     * @param imprimeListado
     */
    public void setImprimeListado(String imprimeListado) {
        this.imprimeListado = imprimeListado;
    }

    /**
     * @return
     */
    public String getImprimeListado() {
        return imprimeListado;
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
    
    public String obtenerDatosReporte(BigDecimal codigo) {
        String numfact = ""; 
        if (codigo != null) {
            numfact = codigo.toString();
            if (numfact != null && numfact.length() > 6) {
                numfact = numfact.substring(numfact.length() - 6, numfact.length());
            }
        }
        return numfact; 
    }

    public void setGenerarCSV(boolean generarCSV) {
        this.generarCSV = generarCSV;
    }

    public boolean isGenerarCSV() {
        return generarCSV;
    }
}

