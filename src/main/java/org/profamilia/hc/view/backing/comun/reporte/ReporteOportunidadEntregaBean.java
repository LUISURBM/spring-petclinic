package org.profamilia.hc.view.backing.comun.reporte;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.model.SelectItem;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteOportunidadEntregaBean extends BaseBean implements JRDataSource{


    private Date fechaInicial; 
    
    private Date fechaFinal; 
    
    private List lstTipoReporte; 
    
    private  List<Object[]> lstCitologia; 
    
    private int index;
    
    private boolean generoReporte; 
    
    private String tipoSelect; 
    
    private Integer totalLeidas;
    
    
    String TIPO_DOCUMENTO; 
    String NUMERO_DOCUMENTO; 
    String NOMBRE_PACIENTE; 
    String FECHA_TOMA; 
    String FECHA_ENTREGA; 
    String ESTADO_CITOLOGIA; 
    String RESULTADO_CITOLOGIA = ""; 
    
    
    

    public ReporteOportunidadEntregaBean() {
    }
    
    public void init(){
        
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
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @return
     */
    public boolean next() {
                   index++;
            if(lstCitologia != null)
                return index < lstCitologia.size();
            else
                return false;
        }

    /**
     * @param jrField
     * @return
     */
     public Object getFieldValue(JRField jrField){
         Object value = null;
         String fieldName = jrField.getName();
         obtenerDatosReporte(index); 
         if(fieldName.equals("TIPO_DOCUMENTO"))
             value = TIPO_DOCUMENTO; 
         else
         if(fieldName.equals("NUMERO_DOCUMENTO"))
             value = NUMERO_DOCUMENTO;
         else
         if(fieldName.equals("NOMBRE_PACIENTE"))
             value = NOMBRE_PACIENTE;
         else
         if(fieldName.equals("FECHA_TOMA"))
             value = FECHA_TOMA;
         else
         if(fieldName.equals("FECHA_ENTREGA"))
             value = FECHA_ENTREGA;
             
         else
         if(fieldName.equals("ESTADO_CITOLOGIA"))
             value = ESTADO_CITOLOGIA;
             
         else
         if(fieldName.equals("RESULTADO_CITOLOGIA"))
             value = RESULTADO_CITOLOGIA;

         return value;
     }

    /**
     * @param lstTipoReporte
     */
    public void setLstTipoReporte(List lstTipoReporte) {
        this.lstTipoReporte = lstTipoReporte;
    }

    /**
     * @return
     */
    public List getLstTipoReporte() {
       if(lstTipoReporte== null || lstTipoReporte.isEmpty()){
           lstTipoReporte = new ArrayList(); 
           lstTipoReporte.add(new SelectItem("R","Resumido")); 
           lstTipoReporte.add(new SelectItem("D","Detallado")); 
       }
        return lstTipoReporte;
    }

    /**
     * @param totalLeidas
     */
    public void setTotalLeidas(Integer totalLeidas) {
        this.totalLeidas = totalLeidas;
    }

    /**
     * @return
     */
    public Integer getTotalLeidas() {
        return totalLeidas;
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
    
    
    public void obtenerDatosReporte(int indexAux){
        TIPO_DOCUMENTO = ""; 
        NUMERO_DOCUMENTO = ""; 
        NOMBRE_PACIENTE = ""; 
        FECHA_TOMA = ""; 
        FECHA_ENTREGA = ""; 
        ESTADO_CITOLOGIA = ""; 
        RESULTADO_CITOLOGIA = ""; 
        
        Object[] aux = lstCitologia.get(indexAux); 
        
        
        if(aux != null){
            TIPO_DOCUMENTO = aux[1].toString(); 
            NUMERO_DOCUMENTO =  aux[2].toString(); 
            NOMBRE_PACIENTE = NOMBRE_PACIENTE + aux[3].toString();
            
            if(aux[4]!= null && !aux[4].toString().equals("")){
                NOMBRE_PACIENTE  = NOMBRE_PACIENTE + " " + aux[4].toString(); 
            }
            if(aux[5]!= null && !aux[5].toString().equals("")){
                NOMBRE_PACIENTE  = NOMBRE_PACIENTE + " " + aux[5].toString(); 
            }
            if(aux[6]!= null && !aux[6].toString().equals("")){
                NOMBRE_PACIENTE  = NOMBRE_PACIENTE + " " + aux[6].toString(); 
            }
            
            if(aux[7]!= null){
                FECHA_TOMA = aux[7].toString();     
            }
            
            if(aux[8]!= null){
                FECHA_ENTREGA = aux[8].toString();
                ESTADO_CITOLOGIA = "E"; 
            }
            
            if(aux[9]!= null){
            
                       
            String resultaux = ""; 
            resultaux = aux[9].toString(); 
            
            if(resultaux!= null && !resultaux.equals("")){
            
             if(resultaux.equals("6.1")){
                 RESULTADO_CITOLOGIA = "Negativa para lesi�n intraepitelial"; 
             }else if(resultaux.equals("6.2")){
                 RESULTADO_CITOLOGIA = "Anormalidades celulares epiteliales"; 
             }
                
            }else{
                RESULTADO_CITOLOGIA  = ""; 
            }
                
            
            
            }

        }
        
        
        
    }
    
    
    
    public void aceptar()
    {
        index = -1;
        
        totalLeidas = 0; 
        
        String urlAux = ""; 
        
        try {
          lstCitologia =   this.serviceLocator.getClinicoService().getOportunidadEntregaGeneral(fechaInicial,fechaFinal,getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(lstCitologia!= null){
            for(Object[] citologia: lstCitologia){
                if(citologia[9]!=null){
                    totalLeidas++; 
                }
            }
        }
       
         if(tipoSelect!= null){
           if(tipoSelect.equals("R")){
                urlAux = "/reports/reporteOportunidadEntregaResumido.jasper";
            }else if(tipoSelect.equals("D")){
                urlAux = "/reports/reporteOportunidadEntrega.jasper";
            }            
        }

        try
        {
            if(lstCitologia != null && !lstCitologia.isEmpty())
            {
                java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource(urlAux);
                java.net.URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                java.net.URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud_horizontal.gif");
                java.net.URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/logosupersalud.gif");
                if(url != null)
                {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("FECHA", new Date());
                    parameters.put("CENTRO", getClinica().getCclcnombre());
                    parameters.put("FECHA_INICIAL", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);
                    parameters.put("TOTAL_LEIDAS", totalLeidas);
                    generoReporte = true;
                    JasperReport report = (JasperReport)JRLoader.loadObject(url);
                    byte bytes[] = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "ReporteOportunidadEntrega" +  
                                                    ".pdf", false);
                    
                }
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + (e.getMessage()).toString());
        }
    }


    
}
