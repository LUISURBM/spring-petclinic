// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/09/2016 12:56:56 a. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ConsultarProgramacionCirugiaBean.java

package org.profamilia.hc.view.backing.cirugia.consulta;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.math.BigDecimal;

import java.util.*;

import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.service.CirugiaService;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
import org.profamilia.hc.view.util.XlsServletUtils;

public class ConsultarProgramacionCirugiaBean extends BaseBean {

    private Date fechaActual;
    private List lstCirugias;
    private Date fechaDia;
    private List<Chdetacirpro> detaciru;
    private Long numeroConsulta;
    private Cpservicio servicio;
    private String nombreServicio;
    private List lstCirugiasCompleta;
    private int index;
    private Chusuario usuario;
    private Cpprofesio nombreAnestesio;
    private Cpprofesio ayudante;
    private String nombreAnestesiologo;
    private boolean generoReporte;
    private boolean generoReporteExcel; 
    private Cpprofesio medico;
    private String nombreMedico;
    private List lstSalasCirugia;
    private Integer sala;
    private Chconsultori consultorio;

    public ConsultarProgramacionCirugiaBean() {
    }

    public void init() {
        setGeneroReporte(false);
        lstCirugias = new ArrayList();
        lstCirugiasCompleta = new ArrayList();
        fechaActual = new Date();
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
                lstSalasCirugia.add(new SelectItem("", "Seleccione ...."));
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
                    getServiceLocator().getClinicoService().getConsultasClinicasXDia(fechaActual, 
                                                                                     sala, 
                                                                                     getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lstCirugias != null && !lstCirugias.isEmpty()) {
            Chcirugprogr ciru;
            for (Iterator iterator = lstCirugias.iterator(); iterator.hasNext(); lstCirugiasCompleta.add(ciru)) {
                ciru = (Chcirugprogr)iterator.next();
                numeroConsulta = ciru.getHcplnumero();
                if (ciru.getHcpcanestesiol() != null && ciru.getHcpnclinica() != null) {
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
                if (ciru.getHcpcprofeayuda() != null && ciru.getHcpnclinica() != null) {
                    try {
                        ayudante = 
                                serviceLocator.getClinicoService().getProfesionalXCodigo(ciru.getHcpcprofeayuda(), 
                                                                                         ciru.getHcpnclinica());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (ayudante != null && !ayudante.equals(""))
                        ciru.setNombreAyudante(ayudante.getCpfcnombre());
                    else
                        ciru.setNombreAyudante("--");
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

                try {
                    detaciru = 
                            this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (detaciru != null) {
                    String nombreServicio1 = "";
                    for (Chdetacirpro detalle: detaciru) {
                        try {
                            servicio = 
                                    this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }

                        if (servicio != null && !servicio.equals("")) {
                            nombreServicio1 = nombreServicio1 + " - " + servicio.getCsvcnombre();
                        }
                        try {
                              medico =
                                      serviceLocator.getClinicoService().getProfesionalXCodigo(detalle.getHdcnmedicatien().toString(),
                                                                                               ciru.getHcpnclinica());
                          } catch (ModelException e) {
                              e.printStackTrace();
                          }
                    }
                    ciru.setNombreServicio(nombreServicio1);
                }  
                if (medico != null && !medico.equals(""))
                    nombreMedico = medico.getCpfcnombre();

                nombreServicio = ciru.getNombreServicio();
                if (ciru.getHcpctipoayudan() == null || ciru.getHcpctipoayudan().equals("N"))
                    ciru.setHcpcprofeayuda("--");
                ciru.setNombreServicio(nombreServicio);
                ciru.setNombreMedico(nombreMedico);
            }

        } else {
            lstCirugiasCompleta.clear();
            lstCirugias = lstCirugiasCompleta;
            FacesUtils.addInfoMessage((new StringBuilder()).append("No tiene Cirugias Programadas para el dia: ").append(formatearCampo(fechaActual)).toString());
        }
    }

    public void generarReporte() {
        index = -1;
        Long numeroUsuario = null;
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


                /*    try {
                    detaciru =
                            getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }*/
                /* if (detaciru != null)
                    try {
                        servicio =
                                getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }*/
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
//            File reportFile = 
//                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/ProgramacionCirugia.jasper"));
            File reportFile = 
                new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/FO_GS_QX_10_V01.jasper"));
            if (reportFile.exists()) {
                Map parameters = new HashMap();
                byte bytes[] = null;
                try {
                    java.net.URL imagen = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");
                    parameters.put("IMAGEN", imagen);
                    parameters.put("FECHA", fechaActual);
                    parameters.put("NO_HISTORIA", 
                                   usuario.getHusanumeiden().toString());
                    parameters.put("PER_APELLIDO", 
                                   usuario.getHuscprimerapel());
                    parameters.put("SDO_APELLIDO", 
                                   usuario.getHuscsegundapel());
                    parameters.put("NOMBRES", 
                                   (new StringBuilder()).append(usuario.getHuscprimernomb()).append(" ").append(usuario.getHuscsegundnomb()).toString());
                    //  parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                    parameters.put("CLINICA", getClinica().getCclcnombre());
                    bytes = 
                            JasperRunManager.runReportToPdf(reportFile.getPath(), 
                                                            parameters, 
                                                            dataSource);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "ProgramacionCirugia.pdf", 
                                                    false);
                    setGeneroReporte(true);
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
        } else {
            generoReporte = false;
            FacesUtils.addInfoMessage("No existen datos");
        }
    }
    
    
    public void generarReporteExcel()
    {
    generoReporteExcel = false;
        index = -1;
        Long numeroUsuario = null;
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
                cirugi.setAsegurador(getNombreAseguradora(cirugi.getHcplusuario().getHuscentidadadm()));
                cirugi.setEdad(calcularEdad(cirugi.getHcplusuario().getHusdfechanacim(), new Date()));
                cirugi.setTelefono(cirugi.getHcplusuario().getHusccelular());
                cirugi.setAnestesia(obtenerTipoAnestesia(cirugi.getHcpctipoaneste()));
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


                /*    try {
                    detaciru =
                            getServiceLocator().getCirugiaService().getServicioDetalle(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }*/
                /* if (detaciru != null)
                    try {
                        servicio =
                                getServiceLocator().getClinicoService().getServicioPorId(detaciru.getId().getHdccservicio());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }*/
            }

        }
        
        
        
        index = -1;
        
        
        String urlAux = ""; 
        generoReporte = false;
        String nombSalida = "ProgramacionCirugia"+new Date();


        urlAux = "/reports/FO_GS_QX_10_V02.jasper";

        try {
            usuario = 
                    serviceLocator.getClinicoService().getUsuario(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

       
        if(lstCirugiasCompleta != null && !lstCirugiasCompleta.isEmpty()){
            try {

                java.net.URL url = FacesUtils.getFacesContext().getExternalContext().getResource(urlAux);
             
                java.net.URL imagen = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

                if (url != null) {

                    JRBeanCollectionDataSource dataSource = 
                        new JRBeanCollectionDataSource(historialCirugia);
                   
                    Map parameters = new HashMap();
                    parameters.put("IMAGEN", imagen);
                    parameters.put("FECHA", fechaActual);
                    parameters.put("NO_HISTORIA",usuario.getHusanumeiden().toString());
                    parameters.put("PER_APELLIDO", usuario.getHuscprimerapel());
                    parameters.put("SDO_APELLIDO", usuario.getHuscsegundapel());
                    parameters.put("NOMBRES",(new StringBuilder()).append(usuario.getHuscprimernomb()).append(" ").append(usuario.getHuscsegundnomb()).toString());
                    //  parameters.put("PROCEDIMIENTO", servicio.getCsvcnombre());
                    parameters.put("CLINICA", getClinica().getCclcnombre());
    

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

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
                                                    nombSalida + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                    generoReporte = true;
                    
                    FacesUtils.addInfoMessage("Mensaje generado exitosamente");


                }
            } catch (Exception e) {
             
                FacesUtils.addErrorMessage("No se genero el reporte " + 
                                           e.getMessage());
                e.printStackTrace();
            }
        }else{
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }
        
            if(lstCirugiasCompleta != null){
                System.out.println("Tamano de la lista " + lstCirugiasCompleta.size());
            }else{
                System.out.println("Tamano de la lista  0" );
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


    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
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

    public void setDetaciru(List<Chdetacirpro> detaciru) {
        this.detaciru = detaciru;
    }

    public List<Chdetacirpro> getDetaciru() {
        return detaciru;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setAyudante(Cpprofesio ayudante) {
        this.ayudante = ayudante;
    }

    public Cpprofesio getAyudante() {
        return ayudante;
    }

    public void setGeneroReporteExcel(boolean generoReporteExcel) {
        this.generoReporteExcel = generoReporteExcel;
    }

    public boolean isGeneroReporteExcel() {
        return generoReporteExcel;
    }
}
