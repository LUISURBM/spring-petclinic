package org.profamilia.hc.view.backing.comun.reporte;

import java.util.*;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteConsultasAbiertasNacionalBean extends BaseBean
    implements JRDataSource
{

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstConsultasAbiertas;
    private HtmlDataTable dtConsultasAbiertas;
    private List lstClinicas; 
    private Integer wcodclin; 
    
    
    public void init()
    {
        index = -1;
    }

    public ReporteConsultasAbiertasNacionalBean()
    {
       init();
    }

    /**
     * @return
     */
    public String volverInicio()
    {
        FacesUtils.resetManagedBean("reporteConsultasAbiertasBean");
        return "home";
    }

    /**
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return
     */
    public Date getFechaInicial()
    {
        return fechaInicial;
    }

    /**
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return
     */
    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte)
    {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte()
    {
        return generoReporte;
    }

    /**
     * @param lstConsultasAbiertas
     */
    public void setLstConsultasAbiertas(List lstConsultasAbiertas)
    {
        this.lstConsultasAbiertas = lstConsultasAbiertas;
    }

    /**
     * @return
     */
    public List getLstConsultasAbiertas()
    {
        return lstConsultasAbiertas;
    }

    /**
     * @param dtConsultasAbiertas
     */
    public void setDtConsultasAbiertas(HtmlDataTable dtConsultasAbiertas)
    {
        this.dtConsultasAbiertas = dtConsultasAbiertas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultasAbiertas()
    {
        return dtConsultasAbiertas;
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

    /**
     * @return
     */
    public boolean next()
    {
        index++;
        if(lstConsultasAbiertas != null)
            return index < lstConsultasAbiertas.size();
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
        if(fieldName.equals("TIPO_DOCUMENTO"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHcolusuario().getHusetipoiden().toString();
        else
        if(fieldName.equals("NUMERO_DOCUMENTO"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHcolusuario().getHusanumeiden().toString();
        else
        if(fieldName.equals("NOMBRE_PACIENTE"))
            value = (new StringBuilder()).append(((Chconsulta)lstConsultasAbiertas.get(index)).getHcolusuario().getHuscprimernomb()).append(" ").append(((Chconsulta)lstConsultasAbiertas.get(index)).getHcolusuario().getHuscprimerapel()).toString();
        else
        if(fieldName.equals("FECHA_CONSULTA"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHcolusuario().getHusdfecregistr();
        else
        if(fieldName.equals("SERVICIO"))
            value = (new StringBuilder()).append(((Chconsulta)lstConsultasAbiertas.get(index)).getHcocservicio().getCsvccodigo()).append(" ").append(((Chconsulta)lstConsultasAbiertas.get(index)).getHcocservicio().getCsvcnombre()).toString();
        else
        if(fieldName.equals("OPERADOR"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHcocoperador();
        else
        if(fieldName.equals("NUMERO_CONSULTA"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHcolnumero().toString();
        else
        if(fieldName.equals("CODIGO_CLINICA"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHconclinica(); 
        return value;
    }

    public void generarReporteConsultasAbiertas()
    {
        index = -1;
        generoReporte = false;
        try
        {
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrarClinica(wcodclin, fechaInicial, fechaFinal);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            if(lstConsultasAbiertas != null && !lstConsultasAbiertas.isEmpty())
            {
                java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteConsultasAbiertas.jasper");
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
                    generoReporte = true;
                    JasperReport report = (JasperReport)JRLoader.loadObject(url);
                    byte bytes[] = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, (new StringBuilder()).append("ReporteConsultasAbiertas").append(Calendar.getInstance().getTimeInMillis()).append(".pdf").toString(), false);
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
    }

    public void generarConsultasAbiertas()
    {
        index = -1;
        generoReporte = false;
        try
        {
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrarClinica(wcodclin, fechaInicial, fechaFinal);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(lstConsultasAbiertas == null || lstConsultasAbiertas.isEmpty()){
            FacesUtils.addErrorMessage("No existen resultados con esos criterios de busqueda");
        }
    }


  
}
