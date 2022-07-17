// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/09/2016 12:56:56 a. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ConsultarProgramacionCirugiaBean.java

package org.profamilia.hc.view.backing.cirugia.consulta;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ReporteProgramacionCirugiaBean extends BaseBean {

    private Date fechaInicial;

    private Date fechaFinal;

    private List lstCirugias;
    private Date fechaDia;
    private Chdetacirpro detaciru;
    private Long numeroConsulta;
    private Cpservicio servicio;
    private String nombreServicio;
    private List lstCirugiasCompleta;
    private int index;
    private Chusuario usuario;
    private Cpprofesio nombreAnestesio;
    private String nombreAnestesiologo;
    private boolean generoReporte;
    private boolean generoReporte_CE;
    private Cpprofesio medico;
    private String nombreMedico;
    private List lstSalasCirugia;
    private Integer sala;
    private Chconsultori consultorio;
    private Long wusuario;
    private String tipoReporte;


    public ReporteProgramacionCirugiaBean() {
    }

    public void init() {

        lstCirugias = new ArrayList();
        lstCirugiasCompleta = new ArrayList();
        fechaInicial = new Date();
        fechaFinal = new Date();
        tipoReporte = "CE";

    }

    public void setLstSalasCirugia(List lstSalasCirugia) {
        this.lstSalasCirugia = lstSalasCirugia;
    }

    public List getLstSalasCirugia() {
        if (lstSalasCirugia == null) {
            lstSalasCirugia = new ArrayList();
            ArrayList lstSalasAux = null;
            Integer tipoSala = Integer.valueOf(2);
            try {
                lstSalasAux = 
                        (ArrayList)getServiceLocator().getCirugiaService().getConsultoriosXClinica(tipoSala, 
                                                                                                   getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (lstSalasAux != null && !lstSalasAux.isEmpty()) {
                lstSalasCirugia.add(new SelectItem("", "Todas las salas"));
                Iterator it = lstSalasAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstSalasCirugia.add(new SelectItem(((Chconsultori)lstSalasAux.get(i)).getId().getHconnumero(), 
                                                       ((Chconsultori)lstSalasAux.get(i)).getHcocdescripcio()));
                }

            }
        }
        return lstSalasCirugia;
    }

    public void consultarProgramacion() {
        setGeneroReporte(false);
        lstCirugiasCompleta = new ArrayList();

        try {
            lstCirugias = 
                    getServiceLocator().getClinicoService().getCirugiasClinicasXFecha(fechaInicial, 
                                                                                      fechaFinal, 
                                                                                      sala, 
                                                                                      getClinica().getCclncodigo(), 
                                                                                      wusuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lstCirugias != null && !lstCirugias.isEmpty()) {
            Chcirugprogr ciru;
            for (Iterator iterator = lstCirugias.iterator(); 
                 iterator.hasNext(); lstCirugiasCompleta.add(ciru)) {
                ciru = (Chcirugprogr)iterator.next();
                Chingresoenf ingreso = null;
                numeroConsulta = ciru.getHcplnumero();
                if (ciru.getHcpcanestesiol() != null && 
                    ciru.getHcpnclinica() != null) {
                    try {
                        nombreAnestesio = 
                                serviceLocator.getClinicoService().getProfesionalXCodigo(ciru.getHcpcanestesiol(), 
                                                                                         ciru.getHcpnclinica());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (nombreAnestesio != null && !nombreAnestesio.equals(""))
                        ciru.setNombreAnestesiologo(nombreAnestesio.getCpfcnombre());
                    else
                        ciru.setNombreAnestesiologo("--");
                }
                if (ciru.getHcpctiposedacio() != null) {
                    if (ciru.getHcpctiposedacio().equals("1")) {
                        ciru.setTipoSedacion("Ansiol�sis");
                    } else if (ciru.getHcpctiposedacio().equals("2")) {
                        ciru.setTipoSedacion("Sedaci�n Consciente");
                    } else if (ciru.getHcpctiposedacio().equals("3")) {
                        ciru.setTipoSedacion("Sedaci�n Profunda/Analgesica");
                    }
                }

                if (ciru.getHcplnumero() != null) {
                    try {
                        ingreso = 
                                serviceLocator.getClinicoService().getIngresoEnfermeria(ciru.getHcplnumero());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (ingreso != null && 
                        ingreso.getHiecautocntel() != null) {
                        ciru.setAutorizaContacto(ingreso.getHiecautocntel());
                    } else {
                        ciru.setAutorizaContacto(null);
                    }

                } else {
                    ciru.setAutorizaContacto(null);
                }

                List<Chdetacirpro> lstServiciosDetallados = 
                    new ArrayList<Chdetacirpro>();
                try {


                    lstServiciosDetallados = 
                            getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);


                } catch (ModelException e) {
                    e.printStackTrace();
                }
                nombreMedico = "";
                nombreServicio = "";
                for (Chdetacirpro detaciruAux: lstServiciosDetallados) {
                    detaciru = detaciruAux;

                    if (detaciru != null) {
                        try {
                            servicio = 
                                    getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        try {
                            medico = 
                                    serviceLocator.getClinicoService().getProfesionalXCodigo(detaciru.getHdcnmedicatien().toString(), 
                                                                                             ciru.getHcpnclinica());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    }

                    if (medico != null && !medico.equals(""))
                        nombreMedico = 
                                nombreMedico + " - " + medico.getCpfcnombre();
                    if (servicio != null && !servicio.equals(""))
                        nombreServicio = 
                                nombreServicio + " - " + servicio.getCsvcnombre();
                }


                if (ciru.getHcpctipoayudan() == null || 
                    ciru.getHcpctipoayudan().equals("N"))
                    ciru.setHcpcprofeayuda("--");
                ciru.setNombreServicio(nombreServicio);
                ciru.setNombreMedico(nombreMedico);
            }

        } else {
            lstCirugiasCompleta.clear();
            lstCirugias = lstCirugiasCompleta;
            FacesUtils.addInfoMessage((new StringBuilder()).append("No tiene Cirugias Programadas para el dia: ").append(formatearCampo(fechaInicial)).toString());
        }


        if (lstCirugiasCompleta != null) {
            String descripcionSala = "";
            for (Iterator iterator = lstCirugiasCompleta.iterator(); 
                 iterator.hasNext(); ) {
                Chcirugprogr cirugi = (Chcirugprogr)iterator.next();
                numeroConsulta = cirugi.getHcplnumero();
                cirugi.setPrimerNombre(cirugi.getHcplusuario().getHuscprimernomb());
                cirugi.setSegundoNombre(cirugi.getHcplusuario().getHuscsegundnomb());
                cirugi.setPrimerApellido(cirugi.getHcplusuario().getHuscprimerapel());
                cirugi.setSegundoApellido(cirugi.getHcplusuario().getHuscsegundapel());
                cirugi.setNumeiden(cirugi.getHcplusuario().getHusanumeiden());
                cirugi.setNombreeps(obtenerNombreEps(cirugi.getHcplusuario().getHuscentidadadm()));
                cirugi.setNumerofijo(cirugi.getHcplusuario().getHusctelefono());
                cirugi.setNumerocelular(cirugi.getHcplusuario().getHusccelular());


                try {

                    descripcionSala = 
                            getServiceLocator().getCirugiaService().getNombreSalaXCodigo(cirugi.getHcpnclinica(), 
                                                                                         cirugi.getHcpnsalainterv());

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (descripcionSala != null && !descripcionSala.equals("")) {

                    cirugi.setDescSala(descripcionSala);

                }


                try {
                    detaciru = 
                            getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (detaciru != null)
                    try {
                        servicio = 
                                getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
            }

        }
        generarReporteCsv();

    }

    public void generarReporte() {
        index = -1;

        generoReporte_CE = false;
        Long numeroUsuario = null;
        String descripcionSala = "";
        List historialCirugia = new ArrayList();
        if (lstCirugiasCompleta != null) {
            for (Iterator iterator = lstCirugiasCompleta.iterator(); 
                 iterator.hasNext(); ) {
                Chcirugprogr cirugi = (Chcirugprogr)iterator.next();
                numeroUsuario = cirugi.getHcplusuario().getHuslnumero();
                numeroConsulta = cirugi.getHcplnumero();
                cirugi.setPrimerNombre(cirugi.getHcplusuario().getHuscprimernomb());
                cirugi.setSegundoNombre(cirugi.getHcplusuario().getHuscsegundnomb());
                cirugi.setPrimerApellido(cirugi.getHcplusuario().getHuscprimerapel());
                cirugi.setSegundoApellido(cirugi.getHcplusuario().getHuscsegundapel());
                cirugi.setNumeiden(cirugi.getHcplusuario().getHusanumeiden());
                cirugi.setNombreeps(obtenerNombreEps(cirugi.getHcplusuario().getHuscentidadadm()));
                cirugi.setNumerofijo(cirugi.getHcplusuario().getHusctelefono());
                cirugi.setNumerocelular(cirugi.getHcplusuario().getHusccelular());

                /*
                try {

                    consultorio =
                            getServiceLocator().getCirugiaService().getConsultoriosXId(cirugi.getHcpnsalainterv());

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (consultorio != null && !consultorio.equals("")) {

                    cirugi.setDescSala(consultorio.getHcocdescripcio());
                    historialCirugia.add(cirugi);
                }

*/
                try {

                    descripcionSala = 
                            getServiceLocator().getCirugiaService().getNombreSalaXCodigo(cirugi.getHcpnclinica(), 
                                                                                         cirugi.getHcpnsalainterv());

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (descripcionSala != null && !descripcionSala.equals("")) {

                    cirugi.setDescSala(descripcionSala);
                    historialCirugia.add(cirugi);

                }

                try {
                    detaciru = 
                            getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (detaciru != null)
                    try {
                        servicio = 
                                getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
            }

        }

        if (historialCirugia != null && !historialCirugia.isEmpty()) {

            JRBeanCollectionDataSource dataSource = 
                new JRBeanCollectionDataSource(historialCirugia);
            try {
                usuario = 
                        serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/ReporteCirugia.jasper"));
            if (reportFile.exists()) {
                Map parameters = new HashMap();
                byte bytes[] = null;
                try {
                    java.net.URL imagen = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                    parameters.put("IMAGEN", imagen);
                    parameters.put("FECHA", fechaInicial);
                    parameters.put("FECHA_FINAL", fechaFinal);
                    parameters.put("NO_HISTORIA", 
                                   usuario.getHusanumeiden().toString());
                    parameters.put("PER_APELLIDO", 
                                   usuario.getHuscprimerapel());
                    parameters.put("SDO_APELLIDO", 
                                   usuario.getHuscsegundapel());
                    parameters.put("NOMBRES", 
                                   (new StringBuilder()).append(usuario.getHuscprimernomb()).append(" ").append(usuario.getHuscsegundnomb()).toString());
                    parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "ProgramacionCirugia.pdf", 
                                                    false);
                    generoReporte_CE = true;

                } catch (JRException ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar Reporte Control Liquidos. ").append(ex.getMessage()).toString());
                    setGeneroReporte(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage((new StringBuilder()).append("No pudo generar reporte Control Liquidos. ").append(ex.getMessage()).toString());
                    setGeneroReporte(false);
                }
            }
        }


        if (historialCirugia.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        }

    }


    public void generarReporteCsv() {
        index = -1;
        generoReporte = false;

        Long numeroUsuario = null;
        List historialCirugia = new ArrayList();
        String descripcionSala = "";
        if (lstCirugiasCompleta != null) {
            for (Iterator iterator = lstCirugiasCompleta.iterator(); 
                 iterator.hasNext(); ) {
                Chcirugprogr cirugi = (Chcirugprogr)iterator.next();
                numeroUsuario = cirugi.getHcplusuario().getHuslnumero();
                numeroConsulta = cirugi.getHcplnumero();
                cirugi.setPrimerNombre(cirugi.getHcplusuario().getHuscprimernomb());
                cirugi.setSegundoNombre(cirugi.getHcplusuario().getHuscsegundnomb());
                cirugi.setPrimerApellido(cirugi.getHcplusuario().getHuscprimerapel());
                cirugi.setSegundoApellido(cirugi.getHcplusuario().getHuscsegundapel());
                cirugi.setNumeiden(cirugi.getHcplusuario().getHusanumeiden());
                cirugi.setNombreeps(obtenerNombreEps(cirugi.getHcplusuario().getHuscentidadadm()));
                cirugi.setNumerofijo(cirugi.getHcplusuario().getHusctelefono());
                cirugi.setNumerocelular(cirugi.getHcplusuario().getHusccelular());

                /*
                try {

                    consultorio =
                            getServiceLocator().getCirugiaService().getConsultoriosXId(cirugi.getHcpnsalainterv());

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (consultorio != null && !consultorio.equals("")) {

                    cirugi.setDescSala(consultorio.getHcocdescripcio());
                    historialCirugia.add(cirugi);
                }
 */
                try {

                    descripcionSala = 
                            getServiceLocator().getCirugiaService().getNombreSalaXCodigo(cirugi.getHcpnclinica(), 
                                                                                         cirugi.getHcpnsalainterv());

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (descripcionSala != null && !descripcionSala.equals("")) {

                    cirugi.setDescSala(descripcionSala);
                    historialCirugia.add(cirugi);

                }


                try {
                    detaciru = 
                            getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (detaciru != null)
                    try {
                        servicio = 
                                getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
            }

        }
        try {

            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteCirugiaProgramacion.jasper");


            if (url != null) {

                Map parameters = new HashMap();
                JRBeanCollectionDataSource dataSource = 
                    new JRBeanCollectionDataSource(historialCirugia);

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                JasperPrint jasperPrint = 
                    JasperFillManager.fillReport(report, parameters, 
                                                 dataSource);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, 
                                      jasperPrint);
                exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, 
                                      baos);
                exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, 
                                      ",");

                exporter.exportReport();
                CsvServletUtils.showCsvDocument(baos.toByteArray(), 
                                                "reporteProgramacion" + ".csv", 
                                                false);

                generoReporte = true;


            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se genero el reporte " + 
                                       e.getMessage());
        }

    }


    public boolean next() {
        index++;
        return index < 1;
    }

    public Object getFieldValue(JRField jrField) {
        return null;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    public List getLstCirugias() {
        return lstCirugias;
    }

    public void setFechaDia(Date fechaDia) {
        this.fechaDia = fechaDia;
    }

    public Date getFechaDia() {
        return fechaDia;
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

    public void setLstCirugiasCompleta(List lstCirugiasCompleta) {
        this.lstCirugiasCompleta = lstCirugiasCompleta;
    }

    public List getLstCirugiasCompleta() {
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

    public void setMedico(Cpprofesio medico) {
        this.medico = medico;
    }

    public Cpprofesio getMedico() {
        return medico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Integer getSala() {
        return sala;
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

    public void setWusuario(Long wusuario) {
        this.wusuario = wusuario;
    }

    public Long getWusuario() {
        return wusuario;
    }

    public void setGeneroReporte_CE(boolean generoReporte_CE) {
        this.generoReporte_CE = generoReporte_CE;
    }

    public boolean isGeneroReporte_CE() {
        return generoReporte_CE;
    }
}
