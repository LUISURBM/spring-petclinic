 //=======================================================================
 // ARCHIVO RepSegCitologiasBean.java
 // FECHA CREACI�N: 13/09/2010 - 29/08/2013
 // AUTOR:  
 // Descripci�n: Reporte correspondiente al seguimineto de las citologias
 // que se entregan a los diferentes laboratorios.
 //=======================================================================

 package org.profamilia.hc.view.backing.procedimiento.reportes;

 import java.io.ByteArrayOutputStream;

 import java.math.BigDecimal;

 import java.net.URL;

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.GregorianCalendar;
 import java.util.HashMap;
 import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
 import java.util.Map;
 import java.util.Set;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

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

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chdetaentcito;
 import org.profamilia.hc.model.dto.Chentregacitol;
 import org.profamilia.hc.model.dto.Chusuario;
 import org.profamilia.hc.model.dto.Cncitologi;
 import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.ReportCitologiaDTO;
import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IConstantes;
 import org.profamilia.hc.view.util.CsvServletUtils;
 import org.profamilia.hc.view.util.FacesUtils;
 import org.profamilia.hc.view.util.PdfServletUtils;


 //=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //=======================================================================
 //  CLASE RepSegCitologiasBean
 //=======================================================================

 public class RepSegCitologiasBean extends BaseBean implements JRDataSource {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------

     private Date fechaInicial;

     private Date fechaFinal;

     private Date fechaEnvio;

     private boolean generoReporte;

     private boolean generoReporte_CE;

     private String tipoLectura;

     private Integer tipoHistoria;

     private String tipoReporte;

     private List listaCitologias = new ArrayList();

     private int index = -1;

     private boolean generarArch;
     
     String NUMERO_FAC;

     String archivo;
     
     BigDecimal secList = new BigDecimal(0);
     
     private String labelPantalla;
     
     private boolean renderCsv;
     
    private HtmlDataTable dtLstCitologia;
    
    private boolean renderSeleccion;
    
    private List<ReportCitologiaDTO> listaCitologiasSeleccionadas = new ArrayList();
    private int selectedIndex;
    private boolean renderBuscador;
    private Long numeroUsuario;
    
    private  int ACTIVAR_BUSCADOR = 1;
    private UIInput itNumeroUsuario;
    private  int ACTIVAR_BEAN = 0;
    private Chusuario usuario;
    BuscadorUsuariosBean buscador;
    private String nombreUsuario;
    private boolean renderUsu;
    private String tipoId;
    private Long numeroId;
    private boolean resultado;
    
    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;
    
    private HtmlDataTable dtLstCitologiaUsuario;
    private List listaCitologiasSeleccionadasUsuario = new ArrayList();
    private List listaCitologiasSeleccionadasUsuarioData = new ArrayList();
    private ReportCitologiaDTO reporteCitologiaObjeto;
    private List<ReportCitologiaDTO> listaObjecto= new ArrayList();
    private List<ReportCitologiaDTO> listaObjectoSeleccionadas= new ArrayList();
    private List<ReportCitologiaDTO> listaObjectoUsuario= new ArrayList();
    private boolean existeLista= false;
    private boolean reporteGeneradoPDF=false;
    private boolean reporteGeneradoCSV=false;

     public RepSegCitologiasBean() {
     }

     public void init() {
         generoReporte = false;
         generoReporte_CE = false;
         reporteGeneradoPDF=false;
         reporteGeneradoCSV=true;
         listaCitologias = new ArrayList();
         tipoReporte = "CE";
         generarArch = false; 
         labelPantalla = "";
         renderCsv = false; 
         if(tipoHistoria != null){
             if(tipoHistoria.equals(HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)){
                 labelPantalla = "Envio resultados Citologia Convencional";
                 renderCsv = true;
             }else if(tipoHistoria.equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA)){
                 labelPantalla = "Envio resultados VPH";
                 renderCsv = false;
             }else if(tipoHistoria.equals(HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA)){
                 labelPantalla = "Envio resultados Citologia en Base Liquida";
                 renderCsv = false;
             }else{
                 renderCsv = false;
                 labelPantalla = "Error";
             }
         }
         dtLstCitologia = new HtmlDataTable();
         dtLstCitologiaUsuario = new HtmlDataTable();
            renderUsu=false;
            reporteCitologiaObjeto= new ReportCitologiaDTO();
        }

     // ACTIONS

      /**
       * @param jrField
       * @return
       */
      public Object getFieldValue(JRField jrField) {
         
          Object value = null;
          String fieldName = jrField.getName();
        // Object[] b = new Object[listaCitologias.size()];
        ReportCitologiaDTO report= new ReportCitologiaDTO();
          
         // b = (Object[])listaCitologias.get(index);
         report= listaCitologiasSeleccionadas.get(index);

          if (this.tipoReporte.equalsIgnoreCase("CE")) {
              
              Cncitotoma toma = null;
              try {
              toma = this.serviceLocator.getClinicoService().getTomaCitologia(Integer.parseInt(report.getCcinconsec().toString()));
              } catch (ModelException e) {
                  e.printStackTrace();
                  FacesUtils.addErrorMessage("No se pudo consultar Toma " + e.getMessage());
             }
              if (fieldName.equals("consecutivoProcedimiento")) {//FORMATO
                  value = Long.parseLong(report.getCcinconsec().toString());
                  return value;
              } else if (fieldName.equals("identificacionUsuario")) {//IDENTIFICACION
                   value =report.getCcictipide().toString() + " " + report.getCcianumide().toString();
                  return value;
              } else if (fieldName.equals("nombreUsuario")) {//USUARIO
                  value = report.getCcicprinom().toString() + " "
                     + ((report.getCcicsegnom() == null) ? "" : report.getCcicsegnom().toString())
                     + " " + report.getCcicpriape().toString() + " "
                     + ((report.getCcicsegape() == null) ? "" : report.getCcicsegape().toString());
                  return value;
              } else if (fieldName.equals("fechaToma")) {//FECHA_TOMA -> FECHA_Citologia
                  if (toma!= null) {
                     value = toma.getCtmdfectom();
                  }
                  value = report.getFechaReg();
                  return value;
              } else if (fieldName.equals("tomaNombreProfesional")) {//PROFESIONAL_TOMA
                  if (toma!= null) {
                     value = toma.getCtmcusureg();
                  }
                  return value;
                } else if (fieldName.equals("contrato")) {//CONTRATO
                    if (toma!= null) {
                       value = report.getNombreContrato();
                    }
                    return value;
                
                
            } else if (fieldName.equals("aplicaBaseLiquida")) { //Aplica Base Liquida
                if (report.getBaseLiq()!=0) {
                    try {
                        List<Cfdetafactura> listaDetafactura = 
                            this.getServiceLocator().getClinicoService().validacionTomaPaquete(report.getBaseLiq());
                        if (listaDetafactura != null && 
                            !listaDetafactura.isEmpty()) {
                            report.setAplicabl("SI");
                            value=report.getAplicabl();
                            return value;
                        } else {
                            report.setAplicabl("N0");
                            value=report.getAplicabl();
                            return value;
                        }

                    } catch (ModelException e) {
                        e.printStackTrace();
                        FacesUtils.addErrorMessage("No se pudo consultar Toma " + 
                                                   e.getMessage());
                    }
                } else {
                            report.setAplicabl("N0");
                            value=report.getAplicabl();
                            return value;
                        }
            }
            

        } else {
              if (fieldName.equals("CCINCONSEC")) {
                  value = formatearDecimal(report.getCcinconsec()) ;
                  return value;
              } else if (fieldName.equals("CCINCLINIC")) {
                  value = formatearDecimal(report.getCcinclinic());
                  return value;
              } else if (fieldName.equals("CCICTIPIDE")) {
                  value = report.getCcictipide();
                  return value;
              } else if (fieldName.equals("CCIANUMIDE")) {
                  value = formatearDecimal(report.getCcianumide());
                  return value;
              } else if (fieldName.equals("CCICPRINOM")) {
                  value = report.getCcicprinom();
                  return value;
              } else if (fieldName.equals("CCICSEGNOM")) {
                  value = report.getCcicsegnom();
                  return value;
              } else if (fieldName.equals("CCICPRIAPE")) {
                  value = report.getCcicpriape();
                  return value;
              } else if (fieldName.equals("CCICSEGAPE")) {
                  value = report.getCcicsegape();
                  return value;
              } else if (fieldName.equals("CCINEDAD")) {
                  value = formatearDecimal(report.getCcinedad());
                  return value;
              } else if (fieldName.equals("CCICTIPAFI")) {
                  value = report.getCcictipafi();
                  return value;
              } else if (fieldName.equals("CCICASEGUR")) {
                  value = report.getCcicasegur();
                  return value;
              } else if (fieldName.equals("CCIDFECCIT")) {
                  value = formatearCampo(report.getCcidfeccit());
                  return value;
              } else if (fieldName.equals("NUMERO_FAC")) {
                  value = obtenerDatosReporte(report.getNumero_fac());
                  return value;
              } else if (fieldName.equals("CCINTIPDOC")) {
                  value = formatearDecimal(report.getCcintipdoc());
                  return value;
              } else if (fieldName.equals("CCINNUMDOC")) {
                  value = formatearDecimal(report.getCcinnumdoc());
                  return value;
              } else if (fieldName.equals("CTMCTOMADA")) {
                  value = report.getCtmctomada();
                  return value;
              } else if (fieldName.equals("CTMCNOMTOM")) {
                  value = report.getCtmcnomtom();
                  return value;
              } else if (fieldName.equals("CTMCESQUEM")) {
                  value = report.getCtmcesquem();
                  return value;
              } else if (fieldName.equals("CTMDULTMEN")) {
                  value = formatearCampo(report.getCtmdultmen());
                  return value;
              } else if (fieldName.equals("CTMDULTPAR")) {
                  value = formatearCampo(report.getCtmdultpar());
                  return value;
              } else if (fieldName.equals("CTMNGESTAC")) {
                  value = formatearDecimal(report.getCtmngestac());
                  return value;
              } else if (fieldName.equals("CTMNPARTOS")) {
                  value = formatearDecimal(report.getCtmnpartos());
                  return value;
              } else if (fieldName.equals("CTMNABORTO")) {
                  value = formatearDecimal(report.getCtmnaborto());
                  return value;
              } else if (fieldName.equals("CTMCEMBARA")) {
                  value = report.getCtmcembara();
                  return value;
              } else if (fieldName.equals("CTMNEDAREL")) {
                  value = formatearDecimal(report.getCtmnedarel());
                  return value;
              } else if (fieldName.equals("CTMCMETPLA")) {
                  value = report.getCtmcmetpla();
                  return value;
              } else if (fieldName.equals("CTMCOTRMET")) {
                  value = report.getCtmcotrmet();
                  return value;
              } else if (fieldName.equals("CTMNTIEMET")) {
                  value = formatearDecimal(report.getCtmntiemet());
                  return value;
              } else if (fieldName.equals("CTMDULTCIT")) {
                  value = formatearCampo(report.getCtmdultcit());
                  return value;
              } else if (fieldName.equals("CTMCULTRES")) {
                  value = report.getCtmcultres();
                  return value;
              } else if (fieldName.equals("CTMCOTRHAL")) {
                  value = report.getCtmcotrhal();
                  return value;
              } else if (fieldName.equals("CTMCPNINGU")) {
                  value = report.getCtmcpningu();
                  return value;
              } else if (fieldName.equals("CTMCPCAUTE")) {
                  value = report.getCtmcpcaute();
                  return value;
              } else if (fieldName.equals("CTMDPCAUTE")) {
                  value = formatearCampo(report.getCtmdpcaute());
                  return value;
              } else if (fieldName.equals("CTMCPHISTE")) {
                  value = report.getCtmcphiste();
                  return value;
              } else if (fieldName.equals("CTMDPHISTE")) {
                  value = formatearCampo(report.getCtmdphiste());
                  return value;
              } else if (fieldName.equals("CTMCPCONIZ")) {
                  value = report.getCtmcpconiz();
                  return value;
              } else if (fieldName.equals("CTMDPCONIZ")) {
                  value = formatearCampo(report.getCtmdpconiz());
                  return value;
              } else if (fieldName.equals("CTMCPRADIO")) {
                  value = report.getCtmcpradio();
                  return value;
              } else if (fieldName.equals("CTMDPRADIO")) {
                  value = formatearCampo(report.getCtmdpradio());
                  return value;
              } else if (fieldName.equals("CTMCPBIOPS")) {
                  value = report.getCtmcpbiops();
                  return value;
              } else if (fieldName.equals("CTMDPBIOPS")) {
                  value = formatearCampo(report.getCtmdpbiops());
                  return value;
              } else if (fieldName.equals("CTMCPCRIOT")) {
                  value = report.getCtmcpcriot();
                  return value;
              } else if (fieldName.equals("CTMDPCRIOT")) {
                  value = formatearCampo(report.getCtmdpcriot());
                  return value;
              } else if (fieldName.equals("CTMCPATA")) {
                  value = report.getCtmcpata();
                  return value;
              } else if (fieldName.equals("CTMDPATA")) {
                  value = formatearCampo(report.getCtmdpata());
                  return value;
              } else if (fieldName.equals("CTMCPOTRO")) {
                  value = report.getCtmcpotro();
                  return value;
              } else if (fieldName.equals("CTMDPOTRO")) {
                  value = formatearCampo(report.getCtmdpotro());
                  return value;
              } else if (fieldName.equals("CTMCPDOTRO")) {
                  value = report.getCtmcpdotro();
                  return value;
              } else if (fieldName.equals("CTMCPVAPOR")) {
                  value = report.getCtmcpvapor();
                  return value;
              } else if (fieldName.equals("CTMDPVAPOR")) {
                  value = formatearCampo(report.getCtmdpvapor());
                  return value;
              } else if (fieldName.equals("CTMCPHORMO")) {
                  value = report.getCtmcphormo();
                  return value;
              } else if (fieldName.equals("CTMDPHORMO")) {
                  value = formatearCampo(report.getCtmdphormo());
                  return value;
              } else if (fieldName.equals("CTMCASPCUE")) {
                  value = report.getCtmcaspcue();
                  value = value.toString().replace(",","|");
                  return value;
              } else if (fieldName.equals("CTMCOBSTOM")) {
                  value = report.getCtmcobstom();
                  if (value != null) {
                      value = value.toString().replace(","," ");
                  }
                  return value;
              } else if (fieldName.equals("CTMCCOMVPH")) {
                  value = report.getCtmccomvph();
                  return value;
              } else if (fieldName.equals("CTMCLACTAN")) {
                  value = report.getCtmclactan();
                  return value;
              } else if (fieldName.equals("CONTRATO")) {
                      value = report.getNombreContrato();
                      return value;
                } else if (fieldName.equals("baseLiquida")) {
                          value = report.getAplicabl();
                          return value;
               } else if (fieldName.equals("CTMNNUMERO")) {
                  value = formatearDecimal(report.getCtmnnumero());
                  return value;
              }
          }
          return value;
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

     /**
     * @return
     */
    public boolean next() {
            index++;
            return (index < listaCitologiasSeleccionadas.size());
    }
     
     public void generarListaEntrega() {
             index = -1;
             generoReporte = false;
             generoReporte_CE = false;
             
             adicionaListaGeneral();
             if (listaCitologiasSeleccionadas.isEmpty()) {
                    FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
                    
                 } else {
                     try {
                         URL urlAux;
                         //URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaCitologias.jasper");
                          if (!tipoHistoria.equals(IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA)) {
                               urlAux = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaProcedimientos.jasper");
                          }else{
                               urlAux = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaProcedimientosVPH.jasper");
                          }
                          
                         URL url = urlAux;
                         URL url_profamilia = 
                             FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                         if (url != null) {
                             Cpprofesio profe = 
                                this.serviceLocator.getClinicoService().getProfesionalesLectura(this.getClinica().getCclncodigo(), 
                                                                                                    null);
                             Set listCncitologi = new HashSet();
                            // for (Object citologia: listaCitologiasSeleccionadas) {
                             //     Object[] a = (Object[])citologia;
                                 for (ReportCitologiaDTO citologia: listaCitologiasSeleccionadas) {
                                   //   Object[] a = (Object[])citologia;
                                
                                  Chdetaentcito detalle = new Chdetaentcito();
                                //  detalle.getComp_id().setHdencitologia(new BigDecimal(a[0].toString()));
                                 detalle.getComp_id().setHdencitologia(citologia.getCcinconsec());
                                  detalle.setHdecetapa(IConstantes.CITOLOGIA_ENV_LECTURA_UNO);
                                  detalle.setHdecoperador(this.getUsuarioSystem().getCurcusuari());
                                  detalle.setHdedfechamod(new Date());
                                  detalle.setHdenclinica(this.getClinica().getCclncodigo());
                                  listCncitologi.add(detalle);
                             }
                             
                             Chentregacitol entregacitol = new Chentregacitol();
                             entregacitol.setHecdfechaenvio(fechaEnvio);
                             entregacitol.setHeccoperador(this.getUsuarioSystem().getCurcusuari());
                             entregacitol.setHecdfechamod(new Date());
                             entregacitol.setHecnclinica(this.getClinica().getCclncodigo());
                             entregacitol.setHecnlablectura1(profe.getCpfncodigo());
                             entregacitol.setChdetaentcitos(listCncitologi);
                
                             secList = this.serviceLocator.getClinicoService().saveListaEntregaCitologia(entregacitol);

                             Map parameters = new HashMap();
                             if (tipoHistoria.equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)) {
                                 parameters.put("nombreFormato", "FORMATO RELACI�N CITOLOG�A CONVENCIONAL");
                                 parameters.put("laboratorio", profe.getCpfcnombre());
                             }
                             if (tipoHistoria.equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA)) {
                                 parameters.put("nombreFormato", "FORMATO RELACI�N CITOLOG�A BASE L�QUIDA");
                                 parameters.put("laboratorio", "Patolab");
                             }
                             if (tipoHistoria.equals(IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA)) {
                                 parameters.put("nombreFormato", "FORMATO RELACI�N TIPIFICACIONES");
                                 parameters.put("laboratorio", "Laboratorio Profamilia");
                             }
                             parameters.put("nombreClinica", this.getClinica().getCclcnombre());
                             parameters.put("codigoClinica", this.getClinica().getCclncodigo());
                             parameters.put("fechaEnvio", fechaEnvio);
                             parameters.put("consecutivoListado", secList.longValue());
                             parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                             
                             archivo = "CT" + formatearCampoFe(new Date()) + "_" + this.getClinica().getCclncodigo() 
                                       + "_" + listaCitologiasSeleccionadas.size() + "_" + secList.intValue();
                             JasperReport report = (JasperReport)JRLoader.loadObject(url);
                             byte[] bytes;
                             bytes = JasperRunManager.runReportToPdf(report, parameters, 
                                                                     (JRDataSource)this);
                                                                     
                             PdfServletUtils.showPdfDocument(bytes, archivo + ".pdf", false);

                             generoReporte_CE = true;
                             if (tipoHistoria.equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA) ||
                                    tipoHistoria.equals(IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA)) {  
                                 listaCitologiasSeleccionadas.clear();
                                 listaObjecto.clear();
                                 fechaInicial= null;
                                 fechaFinal=null;
                                 fechaEnvio=null;
                                
                             }
                             reporteGeneradoPDF=true;
                             
                         }
                     } catch (ModelException me) {
                         me.printStackTrace();
                         FacesUtils.addErrorMessage("No se genero el reporte " + me.getMessage());
                     } catch (Exception e) {
                         e.printStackTrace();
                         FacesUtils.addErrorMessage("No se genero el reporte " + e.getMessage());
                     }
                     
                     if (generoReporte_CE  
                         && this.getClinica().getCclncodigo() != 36 && this.getClinica().getCclncodigo() != 39
                         && this.getClinica().getCclncodigo() != 41 && this.getClinica().getCclncodigo() != 76 
                         && this.getClinica().getCclncodigo() != 35 && this.getClinica().getCclncodigo() != 34 
                         && this.getClinica().getCclncodigo() != 38) {
     //                    this.generarArchivoCsv();
                         generarArch = true;
                     }
                 }
             }
         

     public void generarArchivoCsv() {
        index = -1;
        tipoReporte = "LB";
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
                    reporteGeneradoCSV=true;

 /*                   if (Ftp.conectar("192.168.25.14","citologias","pr0f42018")) {
                        Ftp.cambiarDirectorio("enviados");
                        Ftp.subirArchivo(baos.toByteArray(), archivo + ".csv" );
                        Ftp.cambiarDirectorio("..");
                        Ftp.cambiarDirectorio("historico");
                        Ftp.subirArchivo(baos.toByteArray(), archivo + ".csv" );
                        Ftp.desconectar();
                    }
 */                   generoReporte = true;
                    generoReporte_CE = false;

                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + e.getMessage());
            }
         }
     }

    public void listaCitologias() {
        generoReporte = false;
        generoReporte_CE = false;
        reporteGeneradoPDF=false;
        reporteGeneradoCSV=false;
        listaCitologias.clear();
        listaObjecto.clear();
        Calendar fechaActual = GregorianCalendar.getInstance();
        fechaActual.set(Calendar.HOUR_OF_DAY, 0);
        fechaActual.set(Calendar.MINUTE, 0);
        fechaActual.set(Calendar.SECOND, 0);
        fechaActual.set(Calendar.MILLISECOND, 0);

        if (fechaFinal.compareTo(fechaInicial) < 0) {
            FacesUtils.addInfoMessage(MSG_VALIDACION_FECHA_MENOR);
        } else if (fechaEnvio.compareTo(fechaActual.getTime()) < 0) {
            FacesUtils.addInfoMessage("Fecha de Envio: " + 
                                      MSG_VAL_FECHA_ACTUAL);
        } else {
            tipoReporte = "CE";
            List<Integer> listaTipoHistoria = Arrays.asList(tipoHistoria);
            try {
                tipoLectura = "PL"; // Primera Lectura.
                listaCitologias = 
                        this.serviceLocator.getClinicoService().getCitologiaLectura(fechaInicial, 
                                                                                    fechaFinal, 
                                                                                    this.getClinica().getCclncodigo().intValue(), 
                                                                                    this.tipoLectura, 
                                                                                    listaTipoHistoria);
                                                                                    
            if(!listaCitologias.isEmpty()){
                  ListadoConvertObject(); 
                  
            }

                /*listaCitologias = this.serviceLocator.getClinicoService().getCitologiaExtendedEntregableBetweenFechaClinica(
                         fechaInicial, fechaFinal,  this.getClinica().getCclncodigo().intValue(), listaTipoHistoria
                         );*/
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }
        }
    }
    
      
    
    public void adicionaListaGeneral(){
        listaCitologiasSeleccionadas= new ArrayList();
     for(ReportCitologiaDTO o: listaObjecto){
        if(o.isItemSelect()){
            listaCitologiasSeleccionadas.add(o);
        }
       
     }
        resultado=false;
        renderUsu=false;
    }
    
    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("mostrarBuscadorUsuarios");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
    }
    
    /**
     * @return
     */
    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;
        usuario = new Chusuario();
        nombreUsuario = "";
        generoReporte = false;

        buscador = 
                (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }
        renderBuscador = false;
    }

    
    public void buscarUsuario(){
  
        renderUsu=true;
    }
    
    
    public void listaCitologiasBusquedaUsuario() {

            tipoReporte = "CE";
            List<Integer> listaTipoHistoria = Arrays.asList(tipoHistoria);
            try {
                tipoLectura = "PL"; // Primera Lectura.
                listaCitologiasSeleccionadasUsuario = 
                        this.serviceLocator.getClinicoService().getCitologiaLecturaUsuario(tipoId, 
                                                                                    numeroId, 
                                                                                    this.getClinica().getCclncodigo().intValue(), 
                                                                                    this.tipoLectura, 
                                                                                    listaTipoHistoria);

            
               if(!listaCitologiasSeleccionadasUsuario.isEmpty()){
                   ListadoConvertObjectUsuario();
               resultado=true;
               }
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }
        }
    
    
    
    public void adicionarCitolUsua(){
        ReportCitologiaDTO reporteCitologiaObjetoUsuario= new ReportCitologiaDTO();
        reporteCitologiaObjetoUsuario = (ReportCitologiaDTO)dtLstCitologiaUsuario.getRowData();
        verificarListado(reporteCitologiaObjetoUsuario);
          if (existeLista) {
              renderUsu=false;
              tipoId= null;
              numeroId=null;
              resultado=false;
              listaObjectoUsuario = new ArrayList(); 
          } else {
              reporteCitologiaObjetoUsuario.setItemSelect(true);
              listaObjecto.add(reporteCitologiaObjetoUsuario);
              renderUsu=false;
              tipoId= null;
              numeroId=null;
              resultado=false;
              listaObjectoUsuario = new ArrayList();
          }
      }
      
      public void verificarListado(ReportCitologiaDTO reporteCitologiaObjetoUsuario){
        for(ReportCitologiaDTO ob: listaObjecto){
            if(ob.getCcinconsec().equals(reporteCitologiaObjetoUsuario.getCcinconsec())){
                existeLista=true;
                break;
            }
            else{
            existeLista=false;
            }
        }
      }


    public void ListadoConvertObject() {
        
        for(Object ob:listaCitologias) {
            reporteCitologiaObjeto= new ReportCitologiaDTO();
            Object[] a = (Object[])ob;
            reporteCitologiaObjeto.setCcinconsec((BigDecimal)a[11]);
            reporteCitologiaObjeto.setCcinclinic((BigDecimal)a[12]);
            reporteCitologiaObjeto.setCcictipide((String)a[13]);
            reporteCitologiaObjeto.setCcianumide((BigDecimal)a[14]);
            reporteCitologiaObjeto.setCcicprinom((String)a[15]);
            reporteCitologiaObjeto.setCcicsegnom((String)a[16]);
            reporteCitologiaObjeto.setCcicpriape((String)a[17]);
            reporteCitologiaObjeto.setCcicsegape((String)a[18]);
            reporteCitologiaObjeto.setCcinedad((BigDecimal)a[19]);
            reporteCitologiaObjeto.setCcictipafi((String)a[20]);
            reporteCitologiaObjeto.setCcicasegur((String)a[21]);
            reporteCitologiaObjeto.setCcidfeccit ((Date)a[22]);
            reporteCitologiaObjeto.setCcintipdoc((BigDecimal)a[24]);
            reporteCitologiaObjeto.setCcinnumdoc((BigDecimal)a[25]);
            reporteCitologiaObjeto.setCtmctomada((String)a[26]);
            reporteCitologiaObjeto.setCtmcnomtom((String)a[27]);
            reporteCitologiaObjeto.setCtmcesquem((String)a[28]);
            reporteCitologiaObjeto.setCtmdultmen((Date)a[29]);
            reporteCitologiaObjeto.setCtmdultpar((Date)a[30]);
            reporteCitologiaObjeto.setCtmngestac((BigDecimal)a[31]);
            reporteCitologiaObjeto.setCtmnpartos((BigDecimal)a[32]);
            reporteCitologiaObjeto.setCtmnaborto((BigDecimal)a[33]);
            reporteCitologiaObjeto.setCtmcembara((String)a[34]);
            reporteCitologiaObjeto.setCtmnedarel((BigDecimal)a[35]);
            reporteCitologiaObjeto.setCtmcmetpla((String)a[36]);
            reporteCitologiaObjeto.setCtmcotrmet((String)a[37]);
            reporteCitologiaObjeto.setCtmntiemet((BigDecimal)a[38]);
            reporteCitologiaObjeto.setCtmdultcit ((Date)a[39]);
            reporteCitologiaObjeto.setCtmcultres((String)a[40]);
            reporteCitologiaObjeto.setCtmcotrhal((String)a[41]);
            reporteCitologiaObjeto.setCtmcpningu((String)a[42]);
            reporteCitologiaObjeto.setCtmcpcaute((String)a[43]);
            reporteCitologiaObjeto.setCtmdpcaute((Date)a[44]);
            reporteCitologiaObjeto.setCtmcphiste((String)a[45]);
            reporteCitologiaObjeto.setCtmdphiste((Date)a[46]);
            reporteCitologiaObjeto.setCtmcpconiz((String)a[47]);
            reporteCitologiaObjeto.setCtmdpconiz((Date)a[48]);
            reporteCitologiaObjeto.setCtmcpradio((String)a[49]);
            reporteCitologiaObjeto.setCtmdpradio((Date)a[50]);
            reporteCitologiaObjeto.setCtmcpbiops((String)a[51]);
            reporteCitologiaObjeto.setCtmdpbiops((Date)a[52]);
            reporteCitologiaObjeto.setCtmcpcriot((String)a[53]);
            reporteCitologiaObjeto.setCtmdpcriot((Date)a[54]);
            reporteCitologiaObjeto.setCtmcpata((String)a[55]);
            reporteCitologiaObjeto.setCtmdpata((Date)a[56]);
            reporteCitologiaObjeto.setCtmcpotro((String)a[57]);
            reporteCitologiaObjeto.setCtmdpotro((Date)a[58]);
            reporteCitologiaObjeto.setCtmcpdotro((String)a[59]);
            reporteCitologiaObjeto.setCtmcpvapor((String)a[60]);
            reporteCitologiaObjeto.setCtmdpvapor((Date)a[61]);
            reporteCitologiaObjeto.setCtmcphormo((String)a[62]);
            reporteCitologiaObjeto.setCtmdphormo((Date)a[63]);
            reporteCitologiaObjeto.setCtmcaspcue((String)a[64]);
            reporteCitologiaObjeto.setCtmcobstom((String)a[65]);
            reporteCitologiaObjeto.setCtmccomvph((String)a[66]);
            reporteCitologiaObjeto.setCtmclactan((String)a[67]);
            reporteCitologiaObjeto.setCtmnnumero((BigDecimal)a[68]);
            reporteCitologiaObjeto.setFechaReg((Date)a[2]);
            reporteCitologiaObjeto.setBaseLiq(Integer.parseInt(a[69].toString()));
            reporteCitologiaObjeto.setNombreContrato(a[70].toString());
            listaObjecto.add(reporteCitologiaObjeto);
        }
         
      }
      
    public void ListadoConvertObjectUsuario() {
        
        for(Object ob:listaCitologiasSeleccionadasUsuario) {
            reporteCitologiaObjeto= new ReportCitologiaDTO();
            Object[] b = (Object[])ob;
            reporteCitologiaObjeto.setCcinconsec((BigDecimal)b[11]);
            reporteCitologiaObjeto.setCcinclinic((BigDecimal)b[12]);
            reporteCitologiaObjeto.setCcictipide((String)b[13]);
            reporteCitologiaObjeto.setCcianumide((BigDecimal)b[14]);
            reporteCitologiaObjeto.setCcicprinom((String)b[15]);
            reporteCitologiaObjeto.setCcicsegnom((String)b[16]);
            reporteCitologiaObjeto.setCcicpriape((String)b[17]);
            reporteCitologiaObjeto.setCcicsegape((String)b[18]);
            reporteCitologiaObjeto.setCcinedad((BigDecimal)b[19]);
            reporteCitologiaObjeto.setCcictipafi((String)b[20]);
            reporteCitologiaObjeto.setCcicasegur((String)b[21]);
            reporteCitologiaObjeto.setCcidfeccit ((Date)b[22]);
            reporteCitologiaObjeto.setCcintipdoc((BigDecimal)b[24]);
            reporteCitologiaObjeto.setCcinnumdoc((BigDecimal)b[25]);
            reporteCitologiaObjeto.setCtmctomada((String)b[26]);
            reporteCitologiaObjeto.setCtmcnomtom((String)b[27]);
            reporteCitologiaObjeto.setCtmcesquem((String)b[28]);
            reporteCitologiaObjeto.setCtmdultmen((Date)b[29]);
            reporteCitologiaObjeto.setCtmdultpar((Date)b[30]);
            reporteCitologiaObjeto.setCtmngestac((BigDecimal)b[31]);
            reporteCitologiaObjeto.setCtmnpartos((BigDecimal)b[32]);
            reporteCitologiaObjeto.setCtmnaborto((BigDecimal)b[33]);
            reporteCitologiaObjeto.setCtmcembara((String)b[34]);
            reporteCitologiaObjeto.setCtmnedarel((BigDecimal)b[35]);
            reporteCitologiaObjeto.setCtmcmetpla((String)b[36]);
            reporteCitologiaObjeto.setCtmcotrmet((String)b[37]);
            reporteCitologiaObjeto.setCtmntiemet((BigDecimal)b[38]);
            reporteCitologiaObjeto.setCtmdultcit ((Date)b[39]);
            reporteCitologiaObjeto.setCtmcultres((String)b[40]);
            reporteCitologiaObjeto.setCtmcotrhal((String)b[41]);
            reporteCitologiaObjeto.setCtmcpningu((String)b[42]);
            reporteCitologiaObjeto.setCtmcpcaute((String)b[43]);
            reporteCitologiaObjeto.setCtmdpcaute((Date)b[44]);
            reporteCitologiaObjeto.setCtmcphiste((String)b[45]);
            reporteCitologiaObjeto.setCtmdphiste((Date)b[46]);
            reporteCitologiaObjeto.setCtmcpconiz((String)b[47]);
            reporteCitologiaObjeto.setCtmdpconiz((Date)b[48]);
            reporteCitologiaObjeto.setCtmcpradio((String)b[49]);
            reporteCitologiaObjeto.setCtmdpradio((Date)b[50]);
            reporteCitologiaObjeto.setCtmcpbiops((String)b[51]);
            reporteCitologiaObjeto.setCtmdpbiops((Date)b[52]);
            reporteCitologiaObjeto.setCtmcpcriot((String)b[53]);
            reporteCitologiaObjeto.setCtmdpcriot((Date)b[54]);
            reporteCitologiaObjeto.setCtmcpata((String)b[55]);
            reporteCitologiaObjeto.setCtmdpata((Date)b[56]);
            reporteCitologiaObjeto.setCtmcpotro((String)b[57]);
            reporteCitologiaObjeto.setCtmdpotro((Date)b[58]);
            reporteCitologiaObjeto.setCtmcpdotro((String)b[59]);
            reporteCitologiaObjeto.setCtmcpvapor((String)b[60]);
            reporteCitologiaObjeto.setCtmdpvapor((Date)b[61]);
            reporteCitologiaObjeto.setCtmcphormo((String)b[62]);
            reporteCitologiaObjeto.setCtmdphormo((Date)b[63]);
            reporteCitologiaObjeto.setCtmcaspcue((String)b[64]);
            reporteCitologiaObjeto.setCtmcobstom((String)b[65]);
            reporteCitologiaObjeto.setCtmccomvph((String)b[66]);
            reporteCitologiaObjeto.setCtmclactan((String)b[67]);
            reporteCitologiaObjeto.setCtmnnumero((BigDecimal)b[68]);
            reporteCitologiaObjeto.setFechaReg((Date)b[2]);
            reporteCitologiaObjeto.setBaseLiq(Integer.parseInt(b[69].toString()));
            reporteCitologiaObjeto.setNombreContrato(b[70].toString());
            listaObjectoUsuario.add(reporteCitologiaObjeto);
        }
         
      }
      
      public void seleccionTodos(){
      if(!reporteGeneradoPDF){
        for(ReportCitologiaDTO rep:listaObjecto){
        rep.setItemSelect(true);
         if(!listaCitologiasSeleccionadas.contains(rep)){
                listaCitologiasSeleccionadas.add(rep);
            }
        }
        }
      }
      
        public void seleccionNinguno(){
            if(!reporteGeneradoPDF){
            for(ReportCitologiaDTO rep:listaObjecto){
            rep.setItemSelect(false);
             listaCitologiasSeleccionadas.remove(rep);
            
            }
            }
        }

     //ACCESSORS

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

     public void setFechaEnvio(Date fechaEnvio) {
         this.fechaEnvio = fechaEnvio;
     }

     public Date getFechaEnvio() {
         return fechaEnvio;
     }

     public Integer getTipoHistoria() {
         return tipoHistoria;
     }

     public void setTipoHistoria(Integer tipoHistoria) {
         this.tipoHistoria = tipoHistoria;
     }

     /**
      * @param tipoReporte
      */
     public void setTipoReporte(String tipoReporte) {
         this.tipoReporte = tipoReporte;
     }

     /**
      * @return
      */
     public String getTipoReporte() {
         return tipoReporte;
     }

     /**
      * @param generoReporte_CE
      */
     public void setGeneroReporte_CE(boolean generoReporte_CE) {
         this.generoReporte_CE = generoReporte_CE;
     }

     /**
      * @return
      */
     public boolean isGeneroReporte_CE() {
         return generoReporte_CE;
     }


     public void setGeneroReporte(boolean generoReporte) {
         this.generoReporte = generoReporte;
     }

     public boolean isGeneroReporte() {
         return generoReporte;
     }


     public void setGenerarArch(boolean generarArch) {
         this.generarArch = generarArch;
     }

     public boolean isGenerarArch() {
         return generarArch;
     }

    public void setLabelPantalla(String labelPantalla) {
        this.labelPantalla = labelPantalla;
    }

    public String getLabelPantalla() {
        return labelPantalla;
    }

    public void setRenderCsv(boolean renderCsv) {
        this.renderCsv = renderCsv;
    }

    public boolean isRenderCsv() {
        return renderCsv;
    }

    public void setDtLstCitologia(HtmlDataTable dtLstCitologia) {
        this.dtLstCitologia = dtLstCitologia;
    }

    public HtmlDataTable getDtLstCitologia() {
        return dtLstCitologia;
    }

    public void setListaCitologias(List listaCitologias) {
        this.listaCitologias = listaCitologias;
    }

    public List getListaCitologias() {
        return listaCitologias;
    }

    public void setRenderSeleccion(boolean renderSeleccion) {
        this.renderSeleccion = renderSeleccion;
    }

    public boolean isRenderSeleccion() {
        return renderSeleccion;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderSeleccion(ValueChangeEvent valueChangeEvent) {
        reporteCitologiaObjeto = (ReportCitologiaDTO)dtLstCitologia.getRowData();
       ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        
    }

   

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setACTIVAR_BUSCADOR(int aCTIVAR_BUSCADOR) {
        this.ACTIVAR_BUSCADOR = aCTIVAR_BUSCADOR;
    }

    public int getACTIVAR_BUSCADOR() {
        return ACTIVAR_BUSCADOR;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }

    public void setACTIVAR_BEAN(int aCTIVAR_BEAN) {
        this.ACTIVAR_BEAN = aCTIVAR_BEAN;
    }

    public int getACTIVAR_BEAN() {
        return ACTIVAR_BEAN;
    }

    public void setBuscador(BuscadorUsuariosBean buscador) {
        this.buscador = buscador;
    }

    public BuscadorUsuariosBean getBuscador() {
        return buscador;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setRenderUsu(boolean renderUsu) {
        this.renderUsu = renderUsu;
    }

    public boolean isRenderUsu() {
        return renderUsu;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setNumeroId(Long numeroId) {
        this.numeroId = numeroId;
    }

    public Long getNumeroId() {
        return numeroId;
    }

    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }
        return listTipoIdentificacion;
    }

    public void setDtLstCitologiaUsuario(HtmlDataTable dtLstCitologiaUsuario) {
        this.dtLstCitologiaUsuario = dtLstCitologiaUsuario;
    }

    public HtmlDataTable getDtLstCitologiaUsuario() {
        return dtLstCitologiaUsuario;
    }

    public void setListaCitologiasSeleccionadasUsuario(List listaCitologiasSeleccionadasUsuario) {
        this.listaCitologiasSeleccionadasUsuario = listaCitologiasSeleccionadasUsuario;
    }

    public List getListaCitologiasSeleccionadasUsuario() {
        return listaCitologiasSeleccionadasUsuario;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setListaCitologiasSeleccionadasUsuarioData(List listaCitologiasSeleccionadasUsuarioData) {
        this.listaCitologiasSeleccionadasUsuarioData = listaCitologiasSeleccionadasUsuarioData;
    }

    public List getListaCitologiasSeleccionadasUsuarioData() {
        return listaCitologiasSeleccionadasUsuarioData;
    }

    public void setListaObjecto(List<ReportCitologiaDTO> listaObjecto) {
        this.listaObjecto = listaObjecto;
    }

    public List<ReportCitologiaDTO> getListaObjecto() {
        return listaObjecto;
    }

    public void setReporteCitologiaObjeto(ReportCitologiaDTO reporteCitologiaObjeto) {
        this.reporteCitologiaObjeto = reporteCitologiaObjeto;
    }

    public ReportCitologiaDTO getReporteCitologiaObjeto() {
        return reporteCitologiaObjeto;
    }

    public void setListaObjectoSeleccionadas(List<ReportCitologiaDTO> listaObjectoSeleccionadas) {
        this.listaObjectoSeleccionadas = listaObjectoSeleccionadas;
    }

    public List<ReportCitologiaDTO> getListaObjectoSeleccionadas() {
        return listaObjectoSeleccionadas;
    }

    public void setListaCitologiasSeleccionadas(List<ReportCitologiaDTO> listaCitologiasSeleccionadas) {
        this.listaCitologiasSeleccionadas = listaCitologiasSeleccionadas;
    }

    public List<ReportCitologiaDTO> getListaCitologiasSeleccionadas() {
        return listaCitologiasSeleccionadas;
    }

    public void setListaObjectoUsuario(List<ReportCitologiaDTO> listaObjectoUsuario) {
        this.listaObjectoUsuario = listaObjectoUsuario;
    }

    public List<ReportCitologiaDTO> getListaObjectoUsuario() {
        return listaObjectoUsuario;
    }

    public void setExisteLista(boolean existeLista) {
        this.existeLista = existeLista;
    }

    public boolean isExisteLista() {
        return existeLista;
    }


    public void setReporteGeneradoPDF(boolean reporteGeneradoPDF) {
        this.reporteGeneradoPDF = reporteGeneradoPDF;
    }

    public boolean isReporteGeneradoPDF() {
        return reporteGeneradoPDF;
    }

    public void setReporteGeneradoCSV(boolean reporteGeneradoCSV) {
        this.reporteGeneradoCSV = reporteGeneradoCSV;
    }

    public boolean isReporteGeneradoCSV() {
        return reporteGeneradoCSV;
    }
}

