//=======================================================================
// ARCHIVO ConsultarProgramacionCirugiaBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano andres.vargas
// Descripcion: Permite visualizar la programaci�n de las cirugias
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.consulta;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.ChcertmedicoPK;
import org.profamilia.hc.model.dto.Chciruganula;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================
public class ConsultarCancelacionCirugiaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Date fechaInicial;

    private Date fechaFinal;

    private Chdetacirpro detaciru;

    private Long numeroConsulta;

    private Cpservicio servicio;

    private String nombreServicio;

    private List<Chciruganula> lstCirugiasCompleta;

    private int index;

    private Chusuario usuario;

    private Cpprofesio nombreAnestesio;

    private String nombreAnestesiologo;

    private boolean generoReporte;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ConsultarCancelacionCirugiaBean() {
    }

    public void init() {
        setGeneroReporte(false);

        lstCirugiasCompleta = new ArrayList<Chciruganula>();
        fechaInicial = new Date();
    }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

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
    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Bot�n Principal 
    //-----------------------------------------------------------------------


    public String generarReporte() {

        System.out.println("Entroooo");
        index = -1;
        Long numeroUsuario = null;
        List<Chciruganula> lstCirugiasAux = null;
        String nombreUsuario = "";


        try {
            lstCirugiasAux = 
                    serviceLocator.getCirugiaService().getCirugiasCanceladas(fechaInicial, 
                                                                             fechaFinal, 
                                                                             this.getUsuarioSystem().getCurnclinic());
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }


        for (Chciruganula cirugiAnula: lstCirugiasAux) {

            Chcirugprogr cirugi = null;


            try {
                cirugi = 
                        serviceLocator.getCirugiaService().getCirugiaPorId(cirugiAnula.getId().getHcalnumero());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (cirugi != null) {
                numeroUsuario = cirugi.getHcplusuario().getHuslnumero();
                numeroConsulta = cirugi.getHcplnumero();
                nombreUsuario = 
                        cirugi.getHcplusuario().getHuscprimernomb() + " " + 
                        cirugi.getHcplusuario().getHuscprimerapel();
                cirugiAnula.setNombrePaciente(nombreUsuario);
                cirugiAnula.setNumeroIdentificacion(cirugi.getHcplusuario().getHusanumeiden());

                lstCirugiasCompleta.add(cirugiAnula);
            }


            try {
                detaciru = 
                        this.getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (detaciru != null) {
                try {
                    servicio = 
                            this.getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                } catch (ModelException e) {
                    e.printStackTrace();
                }


            }

            if (servicio != null) {
                cirugiAnula.setProcedimiento(servicio.getCsvcnombre());
            }

        }


        if (lstCirugiasCompleta == null || lstCirugiasCompleta.isEmpty()) {
            generoReporte = false;
            FacesUtils.addInfoMessage("No existen datos");

        }

        if (lstCirugiasCompleta != null && !lstCirugiasCompleta.isEmpty()) {

            try {
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/CancelacionCirugiaExcel.jasper");


                if (url != null) {

                    Map parameters = new HashMap();

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    JRBeanCollectionDataSource dataSource = 
                        new JRBeanCollectionDataSource(lstCirugiasCompleta);

                    JasperPrint jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     dataSource);
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
                                                    "CancelacionCirugia" + 
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

        return null;
    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < 1);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        return null;
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

    public void setDetaciru(Chdetacirpro detaciru) {
        this.detaciru = detaciru;
    }

    public Chdetacirpro getDetaciru() {
        return detaciru;
    }


    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setLstCirugiasCompleta(List<Chciruganula> lstCirugiasCompleta) {
        this.lstCirugiasCompleta = lstCirugiasCompleta;
    }

    public List<Chciruganula> getLstCirugiasCompleta() {
        return lstCirugiasCompleta;
    }


    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }


    public void setNombreAnestesio(Cpprofesio nombreAnestesio) {
        this.nombreAnestesio = nombreAnestesio;
    }

    public Cpprofesio getNombreAnestesio() {
        return nombreAnestesio;
    }


    public void setNombreAnestesiologo(String nombreAnestesiologo) {
        this.nombreAnestesiologo = nombreAnestesiologo;
    }

    public String getNombreAnestesiologo() {
        return nombreAnestesiologo;
    }


}
