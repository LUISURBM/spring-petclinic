// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 13/06/2011 11:29:06 a.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ReporteGestacionesBean.java

package org.profamilia.hc.view.backing.comun.reporte;

import java.util.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ReporteGestacionesBean extends BaseBean
    implements JRDataSource
{

    private Date fechaInicial;
    private Date fechaFinal;
    private boolean generoReporte;
    private int index;
    private List lstGestaciones;

    public void init()
    {
        index = -1;
    }

    public ReporteGestacionesBean()
    {
       init();
    }

    public String volverInicio()
    {
        FacesUtils.resetManagedBean("reporteGestacionesBean");
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

    public void setLstGestaciones(List lstGestaciones)
    {
        this.lstGestaciones = lstGestaciones;
    }

    public List getLstGestaciones()
    {
        return lstGestaciones;
    }

    public boolean next()
    {
        index++;
        if(lstGestaciones != null)
            return index < lstGestaciones.size();
        else
            return false;
    }

    public Object getFieldValue(JRField jrField){
        Object value = null;
        Object a[] = null;
        String fieldName = jrField.getName();
        if(lstGestaciones.get(index) != null)
            a = (Object[])lstGestaciones.get(index);
        if(fieldName.equals("TIPO_DOCUMENTO"))
            value = a[1];
        else
        if(fieldName.equals("NUMERO_DOCUMENTO"))
        {
            if(a[2] != null)
                value = a[2].toString();
            else
                value = "";
        } else
        if(fieldName.equals("NOMBRE_PACIENTE"))
            value = (new StringBuilder()).append(a[3]).append(" ").append(a[4]).toString();
        else
        if(fieldName.equals("GESTACIONES"))
        {
            if(a[5] != null)
                value = a[5].toString();
            else
                value = "";
        } else
        if(fieldName.equals("PARTOS"))
        {
            if(a[6] != null)
                value = a[6].toString();
            else
                value = "";
        } else
        if(fieldName.equals("ABORTOS"))
        {
            if(a[7] != null)
                value = a[7].toString();
            else
                value = "";
        } else
        if(fieldName.equals("CESAREAS"))
        {
            if(a[8] != null)
                value = a[8].toString();
            else
                value = "";
        } else
        if(fieldName.equals("VIVOS"))
        {
            if(a[9] != null)
                value = a[9].toString();
            else
                value = "";
        } else
        if(fieldName.equals("ECTOPICOS"))
        {
            if(a[10] != null)
                value = a[10].toString();
            else
                value = "";
        } else
        if(fieldName.equals("MORTINATOS"))
        {
            if(a[11] != null)
                value = a[11].toString();
            else
                value = "";
        } else
        if(fieldName.equals("MOLAS"))
        {
            if(a[12] != null)
                value = a[12].toString();
            else
                value = "";
        } else
        if(fieldName.equals("FECHA_CONSULTA"))
            value = a[0];
        return value;
    }

    public void generarReporteGestaciones()
    {
        index = -1;
        generoReporte = false;
        try
        {
            lstGestaciones = serviceLocator.getClinicoService().getAntecedentesGinecologicoValoracion(fechaInicial, fechaFinal, getClinica().getCclncodigo());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            if(lstGestaciones != null && !lstGestaciones.isEmpty())
            {
                java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteGestacionQuirurgico.jasper");
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
                    PdfServletUtils.showPdfDocument(bytes, (new StringBuilder()).append("AntecedentesGinecologicos").append(Calendar.getInstance().getTimeInMillis()).append(".pdf").toString(), false);
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


}
