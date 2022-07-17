package org.profamilia.hc.view.backing.clinico.consultas;

import java.io.ByteArrayOutputStream;


import java.math.BigDecimal;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
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

import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.webService.CodigoQRClient;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.ModuleConfig;
import org.profamilia.hc.view.util.PDFMerger;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultaEtiquetaVphBean extends BaseBean implements JRDataSource {


    private List<Object[]> listaRegistros;

    private Date fecha;

    private Integer clinicaSelect;

    private List listaClinicas;

    private int index = -1;

    private boolean existeInformacion;

    private boolean generoReporte;

    private boolean disableClinicas;
    
    private String NOMBRE;
    private String TIPO_IDENTIFICACION;
    private String NUMERO_IDENTIFICACION;
    private String FECHA_TOMA;
    private String NUMERO_CITOLOGIA_VPH;
    private String CLINICA;
    
    private Cncitologi citologia;
    
    private static int NUMERO_COPIAS = 1;
    
    private Cncitotoma toma;
    
    private CodigoQRClient codigoQRClient;
    
    private UIInput itDescripcion;
    
    private Date fecha2;


    public ConsultaEtiquetaVphBean() {
    }


    public void init() {
        listaRegistros = new ArrayList();
        listaClinicas = new ArrayList();
        generoReporte = false;
        existeInformacion = false;
        clinicaSelect = getUsuarioSystem().getCurnclinic();
        fecha= null;
        fecha2=null;

    }


    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        }else if (fieldName.equals("TIPO_IDENTIFICACION")) {
            value = TIPO_IDENTIFICACION;
        }else if (fieldName.equals("NUMERO_IDENTIFICACION")) {
            value = NUMERO_IDENTIFICACION;
        }else if (fieldName.equals("FECHA_TOMA")) {
            value = FECHA_TOMA;
        }else if (fieldName.equals("NUMERO_CITOLOGIA_VPH")) {
            value = NUMERO_CITOLOGIA_VPH;
        }else if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        }

        return value;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }
    
    public void generarReporteCodigoQR() {
        Integer consecutivo;
        consecutivo = 0;
        ModuleConfig config = new ModuleConfig();
        List<Object[]> listatoma = null;
        toma = null;
        Integer pagact_pdf = 0;
        Boolean consumo =false;
        List<byte[]> pdfs = new ArrayList<byte[]>();

        if (clinicaSelect != null && fecha != null && fecha2 != null) {
            try {
                //citologia =  serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo);
                //toma = serviceLocator.getClinicoService().getTomaCitologia(consecutivo);
                 listatoma = serviceLocator.getClinicoService().getTomaVphXclinicaAndFecha(fecha,fecha2,clinicaSelect);
                
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        try {
            if (listatoma != null && !listatoma.isEmpty()) {
            for(Object[] cito : listatoma){
                 index = -1;
                 clearCodigoQRVPH();
                 SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
                 NOMBRE=cito[1]+" "+cito[2];
                 TIPO_IDENTIFICACION = cito[3].toString();
                 NUMERO_IDENTIFICACION = cito[4].toString();
                 FECHA_TOMA = df.format(cito[5]);
                 NUMERO_CITOLOGIA_VPH = cito[0].toString();
                 if (cito[6] != null) {
                     try {
                         Cpclinica clinica = 
                             this.serviceLocator.getClinicoService().getClinica(Integer.parseInt(cito[6].toString()));
                         CLINICA = clinica.getCclcnombre();
                     } catch (ModelException e) {
                         e.printStackTrace();
                     }
                 }
                 String respuesta = "";
                 if (!consumo) {
                codigoQRClient = new CodigoQRClient();
                     respuesta = 
                    codigoQRClient.generarCodigoQRLista(listatoma);
                     if (respuesta.equals(IConstantes.OK_REQUEST)) {
                         consumo = true;
                     }else{
                         throw new Exception("Error en el web service etiquetas : "+ respuesta);
                     }
                 }

                if (consumo) {
                    index = -1;
                    URL url = null;
                    
                    String url_codigo_QR = 
                        config.getUbicacionCodigoQR()+ cito[0].toString() + 
                            ".png";

                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/CodigoQRCitologiaVPH.jasper");

                    if (url != null) {
                        Map parameters = new HashMap();
                        parameters.put("CODIGO_QR", url_codigo_QR);
                        byte[] bytes;
                        

                        JasperReport report = 
                            (JasperReport)JRLoader.loadObject(url);

                        bytes = 
                                JasperRunManager.runReportToPdf(report, parameters, 
                                                                (JRDataSource)this);
                                                                
                        if(bytes != null){
                            pagact_pdf += PDFMerger.paginasTotalPDF(bytes);
                            pdfs.add(bytes);
                        }
                        
                    }
                } else {
                    generoReporte = false;
                    FacesUtils.addErrorMessage("No se puedo generar codigo QR-Respuesta:" + 
                                               respuesta);
                }
             }
                if (pdfs != null && !pdfs.isEmpty()) {
                    byte[] resul;
                    byte[] result;
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    resul = PDFMerger.concatBytePDFs(pdfs, output);
                    result = PDFMerger.adicionarPieTotalPaginas(resul, output);

                    PdfServletUtils.showPdfDocument(result, 
                                                    "StickerToma.pdf", 
                                                    false);
                }

                generoReporte = true;
            } else {
                generoReporte = false;
                FacesUtils.addErrorMessage("No existe Toma");
            }
           
        } catch (Exception e) {
            generoReporte = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
    
    public void obtenerDatosReporteQR() {
        SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        NOMBRE=citologia.getCcicprinom()+" "+citologia.getCcicpriape();
        TIPO_IDENTIFICACION = citologia.getCcictipide();
        NUMERO_IDENTIFICACION = citologia.getCcianumide().toString();
        FECHA_TOMA = df.format(toma.getCtmdfecreg());
        NUMERO_CITOLOGIA_VPH = citologia.getCcinconsec().toString();
        if (toma.getCtmnclinic()  != null) {
            try {
                Cpclinica clinica = 
                    this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                CLINICA = clinica.getCclcnombre();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    
    }
    
    public void clearCodigoQRVPH() {
        NOMBRE="";
        TIPO_IDENTIFICACION="";
        NUMERO_IDENTIFICACION="";
        FECHA_TOMA="";
        NUMERO_CITOLOGIA_VPH="";
        CLINICA="";
    }

    public void setListaRegistros(List<Object[]> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<Object[]> getListaRegistros() {
        return listaRegistros;
    }

    public void setFecha(Date fechaInicial) {
        this.fecha = fechaInicial;
    }

    public Date getFecha() {
        return fecha;
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

    public void setToma(Cncitotoma toma) {
        this.toma = toma;
    }

    public Cncitotoma getToma() {
        return toma;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Date getFecha2() {
        return fecha2;
    }
}
