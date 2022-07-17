package org.profamilia.hc.view.backing.comun.reporte;

import java.util.*;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteConsultasAbiertasBean extends BaseBean
    implements JRDataSource
{

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstConsultasAbiertas;
    private HtmlDataTable dtConsultasAbiertas;
    
    
    public void init()
    {
        index = -1;
    }

    public ReporteConsultasAbiertasBean()
    {
       init();
    }

    public String volverInicio()
    {
        FacesUtils.resetManagedBean("reporteConsultasAbiertasBean");
        return "home";
    }

    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial()
    {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setGeneroReporte(boolean generoReporte)
    {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte()
    {
        return generoReporte;
    }

    public void setLstConsultasAbiertas(List lstConsultasAbiertas)
    {
        this.lstConsultasAbiertas = lstConsultasAbiertas;
    }

    public List getLstConsultasAbiertas()
    {
        return lstConsultasAbiertas;
    }

    public void setDtConsultasAbiertas(HtmlDataTable dtConsultasAbiertas)
    {
        this.dtConsultasAbiertas = dtConsultasAbiertas;
    }

    public HtmlDataTable getDtConsultasAbiertas()
    {
        return dtConsultasAbiertas;
    }

    public boolean next()
    {
        index++;
        if(lstConsultasAbiertas != null)
            return index < lstConsultasAbiertas.size();
        else
            return false;
    }

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
        if(fieldName.equals("NUMERO_CONSULTA"))
            value = ((Chconsulta)lstConsultasAbiertas.get(index)).getHcolnumero().toString();
        return value;
    }

    public void generarReporteConsultasAbiertas()
    {
        index = -1;
        generoReporte = false;
        try
        {
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrarClinica(getClinica().getCclncodigo(), fechaInicial, fechaFinal);
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
            lstConsultasAbiertas = serviceLocator.getClinicoService().getConsultasSinCerrarClinica(getClinica().getCclncodigo(), fechaInicial, fechaFinal);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
