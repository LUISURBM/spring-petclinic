package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;

public class ReportePruebasRapidasBean extends BaseBean implements JRDataSource {

    private Date fechaInicial; 
    
    private Date fechaFinal; 
    
    private boolean generoReporte;
    
    private int index; 
    
    private List lstTipoReporte; 
    
    private String tipoSelect; 
    
    private List listaProfesionalesClinica;
    
    private List<SelectItem> lstSala;

    private List<Chusuario> lstUsuarios;
    
    private BigDecimal wcodmed;
    
    private Integer numeroSala;
    
    private String wservicio; 
    
    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;    
    
    private boolean existenCriterios;
    
    private Chusuario usuario;
    
    private HtmlDataTable dtConsultaUsuario;
    
    String CODIGO_MEDICO; 
    
    String NOMBRE_MEDICO; 
    
    String ETAPA; 
    
    String HISTORIA_MANUAL; 
    
    String CODIGO_SERVICIO; 
    
    String DESCRIPCION_SERVICIO; 
    
    Long NUMERO_CONSULTA; 
    
    String FECHA_CONSULTA; 
    
    Date FECHA_CIERRE;
    
    Long MINUTOS_ATENCION; 
    
    Date FECHA_INICIO; 
    
    private List lstClinicas; 
    private Integer wcodclin; 
    
    Date FECHA_FACTURACION; 
    
    String CLINICA;
    
    BigDecimal NUMERO_DOCUMENTO; 
    
    private Integer clinicaSelect;

    private List<Object[]> listaRegistros;
    
    private String tdoc;
    
    private Long numDoc;
    
    private List<SelectItem> listResultado;
    
    private List<SelectItem> listResultadoReactiva;


    public ReportePruebasRapidasBean() {
    }
    
    public void init(){
        listTipoIdentificacion = new ArrayList<SelectItem>();
        usuario = new Chusuario();
        tipoSelect = "R"; 
    }

     /**
      * @return
      */
     public boolean next() {
                    index++;
             if(listaRegistros != null)
                 return index < listaRegistros.size();
             else
                 return false;
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

    
    
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Object[] b = new Object[listaRegistros.size()];
        b = listaRegistros.get(index);

        if (fieldName.equals("FECHA")) {
            value = formatearCampo(b[0]);
            return  fechaVencimiento((String)value);
        }else if (fieldName.equals("CLINICA")) {
            value = formatearCampo(b[1]);
            return value;
        }else if (fieldName.equals("TDOC")) {
            value = formatearCampo(b[2]);
            return value;
        }
         else if (fieldName.equals("NUM_IDEN")) {
            value = formatearCampo(b[3]);                
            return value;
        } 
        else if (fieldName.equals("NOM_PACIENTE")) {
            value = formatearCampo(b[4])+ " " + formatearCampo(b[5])+ " "  + formatearCampo(b[6])  + " " + formatearCampo(b[7]);           
            return value;
        }
        else if (fieldName.equals("EDAD")) {
            value = formatearCampo(b[8]); ;
            return value;
        }
        else if (fieldName.equals("SEXO")) {
            value = formatearCampo(b[9]); ;
            return value;
        }
        else if (fieldName.equals("GENERO")) {
            value = formatearCampo(b[10]); ;
            return value;
        }
        else if (fieldName.equals("TELEFONO")) {
            value = formatearCampo(b[11]); ;
            return value;
        } 
        else if (fieldName.equals("DEPARTAMENTO")) {
            value = formatearCampo(b[12]); ;
            return value;
        }
        else if (fieldName.equals("MUNICIPIO")) {
            value = formatearCampo(b[13]); ;
            return value;
        }
        else if (fieldName.equals("TEMPERATURA")) {
            value = formatearCampo(b[14]); ;
            return value;
        }
        else if (fieldName.equals("HEPAB")) {
            value = formatearCampo(b[15]); ;
            return resultados((String)value);
        }
        else if (fieldName.equals("M_HEPAB")) {
            value = formatearCampo(b[20]); ;
            return value;
        }
        else if (fieldName.equals("L_HEPAB")) {
            value = formatearCampo(b[25]); ;
            return value;
        }
        else if (fieldName.equals("RI_HEPAB")) {
            value = formatearCampo(b[30]);
            return value;
        }
        else if (fieldName.equals("FV_HEPAB")) {
            value = formatearCampo(b[35]); ;
            return  fechaVencimiento((String)value);
        }
        else if (fieldName.equals("RES_HEPAB")) {        
            value = formatearCampo(b[40]); ;            
            return resultados((String)value);
        }
        else if (fieldName.equals("HEPAC")) {
            value = b[16];
            return resultados((String)value);
        }
        else if (fieldName.equals("M_HEPAC")) {
            value = formatearCampo(b[21]); ;
            return value;
        }
        else if (fieldName.equals("L_HEPAC")) {
            value = formatearCampo(b[26]); ;
            return value;
        }
        else if (fieldName.equals("RI_HEPAC")) {
            value = formatearCampo(b[31]); ;
            return value;
        }
        else if (fieldName.equals("FV_HEPAC")) {
            value = formatearCampo(b[36]); ;
            return  fechaVencimiento((String)value);
        }
        else if (fieldName.equals("RES_HEPAC")) {
            value = formatearCampo(b[41]); ;            
            return resultados((String)value);
        }
        else if (fieldName.equals("EMBARAZO")) {
            value = formatearCampo(b[17]); ;
            return resultados((String)value);
        }
        else if (fieldName.equals("M_EMBARAZO")) {
            value = formatearCampo(b[22]); ;
            return value;
        }
        else if (fieldName.equals("L_EMBARAZO")) {
            value = formatearCampo(b[27]); ;
            return value;
        }
        else if (fieldName.equals("RI_EMBARAZO")) {
            value = formatearCampo(b[32]); ;
            return value;
        }
        else if (fieldName.equals("FV_EMBARAZO")) {
            value = formatearCampo(b[37]); ;
            return  fechaVencimiento((String)value);
        }
        else if (fieldName.equals("RES_EMBARAZO")) {
            value = formatearCampo(b[42]); ;            
            return resultados((String)value);
        }
        else if (fieldName.equals("SIFILIS")) {
            value = formatearCampo(b[18]); ;
            return resultados((String)value);
        }
        else if (fieldName.equals("M_SIFILIS")) {
            value = formatearCampo(b[23]); ;
            return value;
        }
        else if (fieldName.equals("L_SIFILIS")) {
            value = formatearCampo(b[28]);
            return value;
        }
        else if (fieldName.equals("RI_SIFILIS")) {
            value = formatearCampo(b[33]); ;
            return value;
        }
        else if (fieldName.equals("FV_SIFILIS")) {
            value = formatearCampo(b[38]); ;
            return fechaVencimiento((String)value);
        }
        else if (fieldName.equals("RES_SIFILIS")) {
            value = formatearCampo(b[43]); ;            
            return resultados((String)value);
        }
        else if (fieldName.equals("VIH")) {
            value = formatearCampo(b[19]); ;
            return resultados((String)value);
        }
        else if (fieldName.equals("M_VIH")) {
            value = formatearCampo(b[24]); ;
            return value;
        }
        else if (fieldName.equals("L_VIH")) {
            value = formatearCampo(b[29]); ;
            return value;
        }
        else if (fieldName.equals("RI_VIH")) {
            value = formatearCampo(b[34]); ;
            return value;
        }
        else if (fieldName.equals("FV_VIH")) {
            value = formatearCampo(b[39]); ;
            return  fechaVencimiento((String)value);
        }
        else if (fieldName.equals("RES_VIH")) {
            value = formatearCampo(b[44]); ;            
            return resultados((String)value);
        }        
        else if (fieldName.equals("NOM_PROFE")) {
            value = formatearCampo(b[45]); ;
            return value;
        } 
        else if (fieldName.equals("CARGO")) {
            value = formatearCampo(b[46]); ;
            return value;
        } 
        else if (fieldName.equals("OBSERVACIONES")) {
            value = formatearCampo(b[47]); ;
            return value;
        } 
        return value;
    }
    public Date fechaVencimiento(String fechaParam){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
               Date fechaDate = null;
               try {
                   fechaDate = formato.parse(fechaParam);
        return fechaDate;
        } catch (ParseException e) {
             return null;
        }
    }
    
    public String resultados(String value){
    String temp = null;
        if(value != null){
            if(value.equals("RE")){
                temp = "Reactiva";
            }else if(value.equals("NR")){
                temp = "No Reactiva";
            }else if(value.equals("NE")){
                temp = "Negativo";
            }else if(value.equals("PO")){
                temp = "Positivo";
            }else if(value.equals("P")){
                temp = "Positivo";
            }else if(value.equals("R")){
                temp = "Reactiva";
            }
            else if(value.equals("S")){
                temp = "Si";
            }
            else if(value.equals("N")){
                temp = "No";
            }
            
            
        }
        return temp;
    }
     
    public void generarArchivoCsv() {
    consultarRegistros();
        index = -1;
        if (listaRegistros == null || listaRegistros.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                String nombreArchivo = "ReportePruebasRapidas";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reportePruebasRapidas.jasper");

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
                                                            "Reporte_pruebas_rapidas" + 
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

    
    
   

    /**
     * @param lstTipoReporte
     */
    public void setLstTipoReporte(List lstTipoReporte) {
        this.lstTipoReporte = lstTipoReporte;
    }


    /**
     * @param tipoSelect
     */
    public void setTipoSelect(String tipoSelect) {
        this.tipoSelect = tipoSelect;
    }

    /**
     * @return
     */
    public String getTipoSelect() {
        return tipoSelect;
    }

    /**
     * @param listaProfesionalesClinica
     */
    public void setListaProfesionalesClinica(List listaProfesionalesClinica) {
        this.listaProfesionalesClinica = listaProfesionalesClinica;
    }

    /**
     * @param wcodmed
     */
    public void setWcodmed(BigDecimal wcodmed) {
        this.wcodmed = wcodmed;
    }

    /**
     * @return
     */
    public BigDecimal getWcodmed() {
        return wcodmed;
    }

    /**
     * @param lstSala
     */
    public void setLstSala(List<SelectItem> lstSala) {
        this.lstSala = lstSala;
    }

    /**
     * @param wservicio
     */
    public void setWservicio(String wservicio) {
        this.wservicio = wservicio;
    }

    /**
     * @return
     */
    public String getWservicio() {
        return wservicio;
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
     * @param wcodclin
     */
    public void setWcodclin(Integer wcodclin) {
        this.wcodclin = wcodclin;
    }

    /**
     * @return
     */
    public Integer getWcodclin() {
        return wcodclin;
    }
    
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
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
    
    public void setLstUsuarios(List<Chusuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public List<Chusuario> getLstUsuarios() {
        return lstUsuarios;
    }
    
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }
    
    public void setDtConsultaUsuario(HtmlDataTable dtConsultaUsuario) {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    public HtmlDataTable getDtConsultaUsuario() {
        return dtConsultaUsuario;
    }
    
    public void consultarRegistros(){
        try{
                listaRegistros = this.serviceLocator.getClinicoService().getReportePruebasRapidas(clinicaSelect, fechaInicial,  fechaFinal, tdoc, numDoc);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setClinicaSelect(Integer clinicaSelect) {
        this.clinicaSelect = clinicaSelect;
    }

    public Integer getClinicaSelect() {
        return clinicaSelect;
    }


    public void setListaRegistros(List<Object[]> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<Object[]> getListaRegistros() {
        return listaRegistros;
    }


    public void setTdoc(String tdoc) {
        this.tdoc = tdoc;
    }

    public String getTdoc() {
        return tdoc;
    }

    public void setNumDoc(Long numDoc) {
        this.numDoc = numDoc;
    }

    public Long getNumDoc() {
        return numDoc;
    }
    
}
