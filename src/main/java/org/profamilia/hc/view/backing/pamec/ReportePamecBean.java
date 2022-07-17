package org.profamilia.hc.view.backing.pamec;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
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

import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReportePamecBean extends BaseBean  implements JRDataSource{


    private Integer wanno; 
    
    private Integer wcodigoTema; 
    
    private List lstTema; 
    
    private Integer wcodclin; 
    
    private List lstClinica; 
    
    private boolean generoReporte; 
    
    private int index;
    
    private List<Object[]> lstReporte; 

    public ReportePamecBean() {
    }
    
    public void init(){
        wanno = 2013; 
    }
    
    
    public boolean next() {
        index++;
        if (lstReporte != null)
            return index < lstReporte.size();
        else
            return false;

        }

    public Object getFieldValue(JRField jrField) {
        Object value = null;
        Object[] aux = null;
        
           BigDecimal codigo_tema = null; 
           String descripcion_tema = ""; 
           BigDecimal codigo_indicador = null; 
           String descripcion_indicador= ""; 
           BigDecimal codigo_pregunta = null; 
           String descripcion_pregunta= ""; 
           BigDecimal clinica = null; 
           BigDecimal anno = null;
           BigDecimal enero = null;
           BigDecimal febrero = null;
           BigDecimal marzo = null;
           BigDecimal abril = null;
           BigDecimal mayo = null;
           BigDecimal junio = null;
           BigDecimal julio = null;
           BigDecimal agosto = null;
           BigDecimal septiembre = null;
           BigDecimal  octubre = null;
           BigDecimal noviembre = null;
           BigDecimal diciembre = null;

        if(index < lstReporte.size()){
            aux = lstReporte.get(index);    
        }
        
        if(aux != null){
            codigo_tema = (BigDecimal)aux[0]; 
            descripcion_tema = (String)aux[1]; 
            codigo_indicador = (BigDecimal)aux[2]; 
            descripcion_indicador = (String)aux[3]; 
            codigo_pregunta = (BigDecimal)aux[4]; 
            descripcion_pregunta = (String)aux[5]; 
            clinica = (BigDecimal)aux[6]; 
            anno = (BigDecimal)aux[7]; 
            enero = (BigDecimal)aux[8]; 
            febrero = (BigDecimal)aux[9]; 
            marzo = (BigDecimal)aux[10]; 
            abril = (BigDecimal)aux[11]; 
            mayo = (BigDecimal)aux[12]; 
            junio = (BigDecimal)aux[13]; 
            julio = (BigDecimal)aux[14]; 
            agosto = (BigDecimal)aux[15]; 
            septiembre = (BigDecimal)aux[16]; 
            octubre = (BigDecimal)aux[17]; 
            noviembre = (BigDecimal)aux[18]; 
            diciembre = (BigDecimal)aux[19]; 

        }
        
        
        String fieldName = jrField.getName();
        
        if (fieldName.equals("CODIGO_TEMA"))
            value = codigo_tema;
        else if (fieldName.equals("DESCRIPCION_TEMA"))
            value = descripcion_tema;
        else if (fieldName.equals("CODIGO_INDICADOR"))
            value = codigo_indicador;
        else if (fieldName.equals("DESCRIPCION_INDICADOR"))
            value = descripcion_indicador;
        else if (fieldName.equals("CODIGO_PREGUNTA"))
            value = codigo_pregunta;
        else if (fieldName.equals("DESCRIPCION_PREGUNTA"))
            value = descripcion_pregunta;  
        else if (fieldName.equals("CLINICA"))
            value = clinica;  
        else if (fieldName.equals("ANNO"))
            value = anno;  
        else if (fieldName.equals("ENERO"))
            value = enero;  
        else if (fieldName.equals("FEBRERO"))
            value = febrero;  
        else if (fieldName.equals("MARZO"))
            value = marzo;  
        else if (fieldName.equals("ABRIL"))
            value = abril;  
        else if (fieldName.equals("MAYO"))
            value = mayo;  
        else if (fieldName.equals("JUNIO"))
            value = junio;  
        else if (fieldName.equals("JULIO"))
            value = julio;  
        else if (fieldName.equals("AGOSTO"))
            value = agosto;  
        else if (fieldName.equals("SEPTIEMBRE"))
            value = septiembre;  
        else if (fieldName.equals("OCTUBRE"))
            value = octubre;  
        else if (fieldName.equals("NOVIEMBRE"))
            value = noviembre;  
        else if (fieldName.equals("DICIEMBRE"))
            value = diciembre;  
    

        return value;
        }


    /**
     * @param wcodigoTema
     */
    public void setWcodigoTema(Integer wcodigoTema) {
        this.wcodigoTema = wcodigoTema;
    }

    /**
     * @return
     */
    public Integer getWcodigoTema() {
        return wcodigoTema;
    }

    /**
     * @param lstTema
     */
    public void setLstTema(List lstTema) {
        this.lstTema = lstTema;
    }

    /**
     * @return
     */
    public List getLstTema() {
    
    if(lstTema == null || lstTema.isEmpty()){
        lstTema = new ArrayList();
        ArrayList<Chpamectema> lstTemaAux = null;
        try {
            lstTemaAux = 
                    (ArrayList<Chpamectema>)this.serviceLocator.getCirugiaService().getListaTemasPamec(); 
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstTemaAux!= null && !lstTemaAux.isEmpty()) {

            Iterator it = lstTemaAux.iterator();
            int i = 0;
            lstTema.add(new SelectItem(0, "Todas los Temas"));
            while (it.hasNext()) {
                it.next();
                lstTema.add(new SelectItem(lstTemaAux.get(i).getHptncodigo(), 
                                             lstTemaAux.get(i).getHptcdescripcio()));
                i++;
            }
        }
        }

        return lstTema;
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

    /**
     * @param lstClinica
     */
    public void setLstClinica(List lstClinica) {
        this.lstClinica = lstClinica;
    }

    /**
     * @return
     */
    public List getLstClinica() {
        if (lstClinica == null || lstClinica.isEmpty()) {
            lstClinica = new ArrayList();
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
                lstClinica.add(new SelectItem(0, "Todas las Clinicas"));
                while (it.hasNext()) {
                    it.next();
                    lstClinica.add(new SelectItem(lstClinicaAux.get(i).getCclncodigo(), 
                                                 lstClinicaAux.get(i).getCclcnombre()));
                    i++;
                }
            }
        }

        return lstClinica;
        }


    /**
     * @param wanno
     */
    public void setWanno(Integer wanno) {
        this.wanno = wanno;
    }

    /**
     * @return
     */
    public Integer getWanno() {
        return wanno;
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
     * @return
     */
     public void generarReporte() {

         index = -1;
         try {
             lstReporte = 
                     this.serviceLocator.getCirugiaService().getReportePamec(wcodclin, 
                                                                                   wcodigoTema, 
                                                                                   wanno);
         } catch (ModelException e) {
             e.printStackTrace();
         }

         if (lstReporte == null || lstReporte.isEmpty()) {
             FacesUtils.addErrorMessage(MSG_NO_RESULTADO_CONSULTA);
             generoReporte = false;
         } else {
         
             try {

                 URL url = 
                     FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reportePamec.jasper");


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
                                                     "Reporte_Pamec" + 
                                                     Calendar.getInstance().getTimeInMillis() + 
                                                     ".xls", false);
                     generoReporte = true;


                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 FacesUtils.addErrorMessage("No se genero el reporte " + 
                                            e.getMessage());
             }


         }
     }

 
}
