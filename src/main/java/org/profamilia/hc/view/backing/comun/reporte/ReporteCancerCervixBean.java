package org.profamilia.hc.view.backing.comun.reporte;



import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

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
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoprof;
import org.profamilia.hc.model.dto.ReporteCervixDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteCancerCervixBean extends BaseBean implements JRDataSource {
  
    private List<ReporteCervixDTO> listaRegistros;

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer clinicaSelect;
    
    private Integer contratoSelect;

    private List lstClinicas;

    private int index ;

    private boolean existeInformacion;

    private boolean generoReporte;

    private boolean disableClinicas;
    
    private List<SelectItem>lstContratos ;
    

  

  
  
 
   
   
   
    public ReporteCancerCervixBean() {
       
    }
    
 
    /**
     * @return
     */
    public String volverInicio() {
        FacesUtils.resetManagedBean("reporteReferenciaBean");
        return "home";
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (listaRegistros != null)
            return index < listaRegistros.size();
        else
            return false;

    }
  

  

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


   



    public void init() {
    index =-1;
        listaRegistros = new ArrayList();
        lstContratos = new ArrayList<SelectItem>();
        getLstClinicas();
        generoReporte = false;
        existeInformacion = false;

    }

    public void consultarRegistros() {
        try {
            generoReporte = false;
       
                listaRegistros = 
                        this.serviceLocator.getReporteService().reporteSaludTotal(clinicaSelect.longValue(), 
                                                                                          fechaInicial, 
                                                                                          fechaFinal,contratoSelect.longValue());
            

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
     
        if (fieldName.equals("NUM_CONTRATO")) {
            value = listaRegistros.get(index).getNumeroContrato();
            return value;
        }
        if (fieldName.equals("PRIMER_NOMBRE")) {
            value = listaRegistros.get(index).getPrimerNombre();
            return value;
        }
        if (fieldName.equals("TIPO_IDENT")) {
            value = listaRegistros.get(index).getTipoIden();
            return value;
        }
        if (fieldName.equals("NUM_IDENT")) {
            value = listaRegistros.get(index).getNumeroIden();
            return value;
        }
        if (fieldName.equals("SEG_NOMBRE")) {
            value = listaRegistros.get(index).getSegundoNombre();
            return value;
        }
        if (fieldName.equals("PRIMER_APELLIDO")) {
            value = listaRegistros.get(index).getPrimerApellido();
            return value;
        }
        if (fieldName.equals("SEG_APELLIDO")) {
            value = listaRegistros.get(index).getSegundoApellido();
            return value;
        }
        if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = listaRegistros.get(index).getFechaNacimiento();
            return value;
        }
        if (fieldName.equals("TIPO_AFILIACION")) {
            value = listaRegistros.get(index).getTipoAfiliacion();
            return value;
        }
        if (fieldName.equals("CLIN_ATENCION")) {
            value = listaRegistros.get(index).getClincia();
            return value;
        }
        if (fieldName.equals("CODIGO_CLIN")) {
            value = listaRegistros.get(index).getCodigoAutClin();
            return value;
        }
        if (fieldName.equals("FECHA_AVPH")) {
            value = listaRegistros.get(index).getFechaAdmisionVPH();
            return value;
        }
        if (fieldName.equals("FECHA_TVPH")) {
            value = listaRegistros.get(index).getFechaTomaVPH();
            return value;
        }
        if (fieldName.equals("RESULTADO_VPH")) {
            value = listaRegistros.get(index).getResultadoVPH();
            return value;
        }
        if (fieldName.equals("GENOTIPIFICACION")) {
            value = listaRegistros.get(index).getGenotipificacion();
            return value;
        }
        if (fieldName.equals("FECHA_RLIQUIDA")) {
            value = listaRegistros.get(index).getFechaCitoLiquida();
            return value;
        }
        if (fieldName.equals("RESULTADO")) {
            value = listaRegistros.get(index).getCelulasEscamosas();
            return value;
        }
        if (fieldName.equals("FECHA_COLP")) {
            value = listaRegistros.get(index).getFechaColposcopia();
            return value;
        }
        if (fieldName.equals("FECHA_TOMCOLP")) {
            value = listaRegistros.get(index).getFechaTomaColposcopia();
            return value;
        }
        if (fieldName.equals("IMP_DIAGNOSTICA")) {
            value = listaRegistros.get(index).getImpresionColposcopia();
            return value;
        }
        if (fieldName.equals("RESULTADO_GINECO")) {
            value = null;
            if("P".equals(listaRegistros.get(index).getResultadoPatologia())){
            value = "Positivo";
            }
           else  if("N".equals(listaRegistros.get(index).getResultadoPatologia())){
            value = "Negativo";
            }
           
            return value;
        }
        if (fieldName.equals("RESULTADO_BIOPSIA")) {
            value = resultadoBiopsia(listaRegistros.get(index).getResultadoBiopsia());
            return value;
        }
        if (fieldName.equals("DES_RESULTADO")) {
            value = listaRegistros.get(index).getDescripcionPatologia();
            return value;
        }
        if (fieldName.equals("FECHA_PCRIOTERAPIA")) {
            value = listaRegistros.get(index).getFechaCrio() ;
            return value;
        }
        if (fieldName.equals("FECHA_PCONIZACION")) {
            value = listaRegistros.get(index).getFechaConizacion() ;
            return value;
        }
        if (fieldName.equals("FECHA_PHISTERECTOMIA")) {
            value = listaRegistros.get(index).getFechaHistero();  
            return value;
        }
        if (fieldName.equals("BD_SALUDTOTAL")) {
            value = listaRegistros.get(index).getBdSaludTotal();  
            return value;
        }

        return value;
    }
    public String resultadoBiopsia(String biopsia){
        if (("NN").equals(biopsia)) {
            biopsia = "Negativo para neoplasia";
        } else if (("IV").equals(biopsia)) {
            biopsia = "Infecci�n por VPH";
        } else if (("NB").equals(biopsia)) {
            biopsia = "NIC de bajo grado (NIC) I";
        } else if (("NA").equals(biopsia)) {
            biopsia = "NIC de alto grado: (NIC II - NIC III)";
        } else if (("NM").equals(biopsia)) {
            biopsia = 
                    "Neoplasia micro infiltrante: escamocelular o adenocarcinoma";
        } else if (("NI").equals(biopsia)) {
            biopsia = 
                    "Neoplasia Infiltrante: escamocelular o adenocarcinoma";
        } else if (("BE").equals(biopsia)) {
            biopsia = "Benigna";
        } else if (("AT").equals(biopsia)) {
            biopsia = "At�pica (Indeterminada)";
        } else if (("MS").equals(biopsia)) {
            biopsia = "Malignidad sospechosa/probable";
        } else if (("MA").equals(biopsia)) {
            biopsia = "Maligna";
        } else if (("NS").equals(biopsia)) {
            biopsia = "No Satisfactoria";
        }
        else{
            biopsia = "No Realizada";
        }
        return biopsia;
    }


    public void generarArchivoCsv() {
    consultarRegistros();
        index = -1;
        if (listaRegistros == null || listaRegistros.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                String nombreArchivo = "ReporteSaludTotal";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteSaludTotal.jasper");

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
                                                    nombreArchivo +" "+ 
                                                    new Date() + 
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

    public void setClinicaSelect(Integer clinicaSelect) {
        this.clinicaSelect = clinicaSelect;
    }

    public Integer getClinicaSelect() {
        return clinicaSelect;
    }

    public void setLstClinicas(List lstClinicas) {
        this.lstClinicas = lstClinicas;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setExisteInformacion(boolean existeInformacion) {
        this.existeInformacion = existeInformacion;
    }

    public boolean isExisteInformacion() {
        return existeInformacion;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setDisableClinicas(boolean disableClinicas) {
        this.disableClinicas = disableClinicas;
    }

    public boolean isDisableClinicas() {
        return disableClinicas;
    }

    public void setListaRegistros(List<ReporteCervixDTO> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<ReporteCervixDTO> getListaRegistros() {
        return listaRegistros;
    }

    public void setLstContratos(List<SelectItem> lstContratos) {
        this.lstContratos = lstContratos;
    }

    public List<SelectItem> getLstContratos() {
        if(lstContratos == null || lstContratos.isEmpty()){
            lstContratos = new ArrayList<SelectItem>();
            lstContratos.add(new SelectItem(0,"Todos los Contratos"));
            lstContratos.add(new SelectItem(41001374,"41001374"));
            lstContratos.add(new SelectItem(41001375,"41001375"));
           
        }
        return lstContratos;
    }


    public void setContratoSelect(Integer contratoSelect) {
        this.contratoSelect = contratoSelect;
    }

    public Integer getContratoSelect() {
        return contratoSelect;
    }
}
