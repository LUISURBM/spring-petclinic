package org.profamilia.hc.view.backing.comun.reporte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteDatosRipsBean extends BaseBean
    implements JRDataSource {
    
    
    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstDatosRips; 
    private List lstTipoUsuario; 
    private Integer tipoUsuarioSelect; 
    private String codservicio; 


    
    public ReporteDatosRipsBean() {
    }
    
    public void init(){
        index = -1;
        generoReporte = false;
    }



    /**
     * @return
     */
    public boolean next()
     {
         index++;
         if(lstDatosRips != null)
             return index < lstDatosRips.size();
         else
             return false;
     }

     public Object getFieldValue(JRField jrField)
     {
         Object value = null;
         Object a[] = null;
         String fieldName = jrField.getName();
         if(lstDatosRips.get(index) != null)
             a = (Object[])lstDatosRips.get(index);
         if(fieldName.equals("TIPO_DOCUMENTO"))
             value = a[2];
         else
         if(fieldName.equals("NUMERO_DOCUMENTO"))
         {
             if(a[3] != null)
                 value = a[3].toString();
             else
                 value = "";
         } else
         if(fieldName.equals("NOMBRE_PACIENTE"))
             value = (new StringBuilder()).append(a[4]).append(" ").append(a[6]).toString();
         else
        
         if(fieldName.equals("FINALIDAD"))
         {
             if(a[8] != null)
                 value = a[8].toString();
             else
                 value = "";
         } else
         if(fieldName.equals("CAUSA_EXTERNA"))
         {
             if(a[9] != null)
                 value = a[9].toString();
             else
                 value = "";
         } else
         if(fieldName.equals("DIAGNOSTICO_PRINCIPAL"))
         {
             if(a[10] != null)
                 value = a[10].toString();
             else
                 value = "";
         } else
         if(fieldName.equals("DIAGNOSTICO_RELACIONADO"))
         {
             if(a[11] != null)
                 value = a[11].toString();
             else
                 value = "";
         } else
         if(fieldName.equals("TIPO_DIAGNOSTICO"))
         {
             if(a[12] != null)
                 value = a[12].toString();
             else
                 value = "";
         } else
         if(fieldName.equals("NUMERO_CONSULTA"))
         {
             if(a[1] != null)
                 value = a[1].toString();
             else
                 value = "";
         }  else
         if(fieldName.equals("FECHA_CONSULTA"))
             value = a[0];
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
     * @param lstTipoUsuario
     */
    public void setLstTipoUsuario(List lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    /**
     * @return
     */
    public List getLstTipoUsuario() 
        {
            if(lstTipoUsuario == null || lstTipoUsuario.isEmpty())
            {
                lstTipoUsuario = new ArrayList();
                ArrayList<Cpcontrato> lstTipoUsuarioAux = null;
                try
                {
                    lstTipoUsuarioAux = (ArrayList<Cpcontrato>)getServiceLocator().getClinicoService().getTipoUsuarioClinico(this.getClinica().getCclncodigo());
                }
                catch(ModelException e)
                {
                    e.printStackTrace();
                }
                if(!lstTipoUsuarioAux.isEmpty())
                {
                    lstTipoUsuario.add(new SelectItem("", "Seleccione una opcion ..."));
                    Iterator it = lstTipoUsuarioAux.iterator();
                    for(int i = 0; it.hasNext(); i++)
                    {
                        it.next();
                        lstTipoUsuario.add(new SelectItem((lstTipoUsuarioAux.get(i)).getId().getCcnnnumero(), (lstTipoUsuarioAux.get(i).getCcncdescri())));
                    }

                }
            }
            return lstTipoUsuario;
        }

    

    /**
     * @param codservicio
     */
    public void setCodservicio(String codservicio) {
        this.codservicio = codservicio;
    }

    /**
     * @return
     */
    public String getCodservicio() {
        return codservicio;
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
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return
     */
    public int getIndex() {
        return index;
    }


    /**
     * @param tipoUsuarioSelect
     */
    public void setTipoUsuarioSelect(Integer tipoUsuarioSelect) {
            this.tipoUsuarioSelect = tipoUsuarioSelect;
        }

        /**
         * @return
         */
        public Integer getTipoUsuarioSelect() {
            return tipoUsuarioSelect;
        }

    /**
     * @param lstDatosRips
     */
    public void setLstDatosRips(List lstDatosRips) {
        this.lstDatosRips = lstDatosRips;
    }

    /**
     * @return
     */
    public List getLstDatosRips() {
        return lstDatosRips;
    }

  
    public String generarReporte() {
    
        index = -1;
        generoReporte = false;

        try {
            lstDatosRips = this.serviceLocator.getClinicoService().getDatosRipsConsulta(fechaInicial, fechaFinal, this.getClinica().getCclncodigo(),tipoUsuarioSelect,codservicio);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        try
        {
            if(lstDatosRips != null && !lstDatosRips.isEmpty())
            {
                java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteDatosRips.jasper");
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
                    parameters.put("TIPO_USUARIO", tipoUsuarioSelect);
                    parameters.put("SERVICIO", codservicio);
                    generoReporte = true;
                    JasperReport report = (JasperReport)JRLoader.loadObject(url);
                    byte bytes[] = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, (new StringBuilder()).append("ReporteDatosRips").append(Calendar.getInstance().getTimeInMillis()).append(".pdf").toString(), false);
                }
            } else
            {
                FacesUtils.addErrorMessage("No existen resultados con esos criterios de busqueda");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar el reporte ").append(e.getMessage()).toString());
        }
        
        
        return null;
    }

}
