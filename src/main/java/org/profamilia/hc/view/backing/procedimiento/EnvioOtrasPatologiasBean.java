//=======================================================================
// ARCHIVO EnvioOtrasPatologiasBean.java
// FECHA CREACI�N: 11/01/2011
// AUTOR: Jhon Carranza Silva
// Descripci�n: Registro envio de otras patologias a laboratorios.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chdetaentpatol;
import org.profamilia.hc.model.dto.Chentregapatol;
import org.profamilia.hc.model.dto.Chprofpatol;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE EnvioOtrasPatologiasBean
//=======================================================================
public class EnvioOtrasPatologiasBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Date fechaInicial;
    
    private Date fechaFinal;
    
    private Date fechaEnvio;
    
    private boolean generoReporte;
    
    private List listaPatologias = new ArrayList();
    
    private int index = -1;
    
    private String idCentro;

    /** Lista  de Centros */
    private List listCentros;
    
    private String idPatologos;

    /** Lista  de Patologos */
    private List listPatologos;

    public EnvioOtrasPatologiasBean() {
    }
    
    public void init() {  
    
        generoReporte= false;
        listaPatologias = new ArrayList();
        
        fillCentros();
        this.listPatologos = new ArrayList();
        idCentro = this.getClinica().getCclncodigo().toString();
        changeCentros();
        
    }
    
    // ACTIONS
    
     /**
      * @param jrField
      * @return
      */
     public Object getFieldValue(JRField jrField) {
     
         Object value = null;
         String fieldName = jrField.getName();          
 
         Object[] a = (Object[])listaPatologias.get(index);

         if (fieldName.equals("FORMATO")) {            
             value = (BigDecimal)a[0];
             return value;
         }
         
         if (fieldName.equals("FECHA_REG")) {            
             value = (Date)a[1];
             return value;
         }
         
         else if (fieldName.equals("COD_SERVICIO")) {
             value = (String)a[6] + " - "+ (String)a[7];
             return value;
         }
         
         else if (fieldName.equals("IDENTIFICACION")) {
             value = (String)a[8] + " " + (BigDecimal)a[9];
             return value;
         }

         else if (fieldName.equals("USUARIO")) {
             value = (String)a[10];
             return value;
         }
         
         else if (fieldName.equals("GRUPO")) {
             value = (BigDecimal)a[11];
             return value;
         }
         
         else if (fieldName.equals("PATOLOGO")) {
             value = (String)a[12];
             return value;
         }

         return value;
     }    
    
     /**
      * @return
      */
     public boolean next() {
         index++;
         return (index < listaPatologias.size());
     }
    
    public void generarListaEntrega() {
        index = -1;
        generoReporte = false;
        
        Calendar fechaActual = GregorianCalendar.getInstance();
        fechaActual.set(Calendar.HOUR_OF_DAY, 0);
        fechaActual.set(Calendar.MINUTE, 0);
        fechaActual.set(Calendar.SECOND, 0);
        fechaActual.set(Calendar.MILLISECOND, 0);
        
        if(fechaFinal.compareTo(fechaInicial) < 0 ){
            FacesUtils.addInfoMessage(MSG_VALIDACION_FECHA_MENOR);
        }else if (fechaEnvio.compareTo(fechaActual.getTime()) < 0) {
            FacesUtils.addInfoMessage("Fecha de Envio: "+ MSG_VAL_FECHA_ACTUAL);
        }else{        
        
            try {
           
                listaPatologias = this.serviceLocator.getClinicoService().getPatologiasLectura(fechaInicial, fechaFinal, new Integer(this.idCentro), new Integer(this.idPatologos));

            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            }
            
            if (listaPatologias.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            }else{

                try {
            
                   URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaPatologias.jasper");
                    URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
                    URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
                    URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
                    if (url != null ) {
                    
                        JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                    

                                    
                                                    
                                            
                            Set listChotraspatolog = new HashSet();
                            
                            if(!listaPatologias.isEmpty()){
                            
                                for(Object patologias: (List)listaPatologias){
                                
                                    Object[] a = (Object[])patologias;
                                    Chdetaentpatol detalle = new Chdetaentpatol();                        
                                    detalle.getComp_id().setHepnpatologia((BigDecimal)a[0]);   
                                    detalle.setHepcetapa(IConstantes.PATOLOGIA_ENV_LAB);
                                    detalle.setHepcoperador(this.getUsuarioSystem().getCurcusuari());
                                    detalle.setHepdfechamod(new Date());
                                    detalle.setHepnclinica(this.getClinica().getCclncodigo());   
                                    
                                    listChotraspatolog.add(detalle);
                                
                                }           
                                            
                            
                            Chentregapatol entregapatol = new Chentregapatol();
                            entregapatol.setHepdfechaenvio(fechaEnvio);
                            entregapatol.setHepcoperador(this.getUsuarioSystem().getCurcusuari());
                            entregapatol.setHepdfechamod(new Date());
                            entregapatol.setHepnclinica(new Integer(this.idCentro));
                            entregapatol.setHepnlablectura(new Integer(this.idPatologos));
                            entregapatol.setChdetaentpatols(listChotraspatolog);                
                            
                            BigDecimal secList = this.serviceLocator.getClinicoService().saveListaEntregaPatologia(entregapatol);  
                            
                            Cpclinica clinica_origen = serviceLocator.getClinicoService().getClinica(new Integer(this.idCentro)); 
                            
                            
                            Map reportParams = new HashMap();
                            reportParams.put("CENTRO", clinica_origen.getCclcnombre());
                            reportParams.put("COD_CENTRO", new Integer(this.idCentro));
                            reportParams.put("FECHA_ENVIO", fechaEnvio );                 
                            reportParams.put("LABORATORIO", new Integer(this.idPatologos));
                            reportParams.put("ID_LISTADO", secList.longValue());
                            reportParams.put("IMAGE_PROFAMILIA", url_profamilia);
                            reportParams.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                            reportParams.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                            
                            
                            byte[] bytes;
                            bytes = JasperRunManager.runReportToPdf(report, reportParams, (JRDataSource)this);
                            PdfServletUtils.showPdfDocument(bytes, "lectura_OP_"+this.getClinica().getCclncodigo()+"_"+ Calendar.getInstance().getTimeInMillis() + ".pdf", false);
                            generoReporte = true;
                        
                        }else{
                            FacesUtils.addErrorMessage(MSG_VALIDACION_PATOLOGOS);
                        }
                        
            
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No se genero el reporte " + e.getMessage());
                }
            
            }
        
        
        
        }
        
    
    }
    
    public void fillCentros() {
        listCentros = new ArrayList();

        try {
            List<Cpclinica> tabla = 
                (List<Cpclinica>)this.serviceLocator.getClinicoService().getClinicas();
            for (Cpclinica combo: tabla) {
                listCentros.add(new SelectItem(combo.getCclncodigo().toString(), 
                                               combo.getCclcnombre()));
            }
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

    }
    
    public void changeCentros() {

        this.listPatologos = new ArrayList();
        if (this.idCentro != null && !this.idCentro.equalsIgnoreCase("")) {

            Chprofpatol chprofpatol = new Chprofpatol();
            chprofpatol.getComp_id().setHppnclinlect(new Integer(idCentro));
        
            try {
                List<Cpprofesio> tabla = 
                    (List<Cpprofesio>)this.serviceLocator.getClinicoService().getComboPatologos(chprofpatol);
                for (Cpprofesio combo: tabla) {
                    listPatologos.add(new SelectItem(combo.getCpfncodigo().toString(), 
                                                               combo.getCpfcnombre()));
                }
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }
        

        } else {
            this.idCentro = "";
            listPatologos = new ArrayList();
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

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }
    
    public void setIdCentro(ValueChangeEvent valueChangeEvent) {
        setIdCentro((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setListCentros(List listCentros) {
        this.listCentros = listCentros;
    }

    public List getListCentros() {
        return listCentros;
    }

    public void setIdPatologos(String idPatologos) {
        this.idPatologos = idPatologos;
    }

    public String getIdPatologos() {
        return idPatologos;
    }

    public void setListPatologos(List listPatologos) {
        this.listPatologos = listPatologos;
    }

    public List getListPatologos() {
        return listPatologos;
    }
}
