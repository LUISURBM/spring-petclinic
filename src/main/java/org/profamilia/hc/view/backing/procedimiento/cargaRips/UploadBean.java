package org.profamilia.hc.view.backing.procedimiento.cargaRips;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.math.BigDecimal;

import java.net.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Cisaludtool;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crarcconsu;
import org.profamilia.hc.model.dto.CrarcconsuId;
import org.profamilia.hc.model.dto.RipsSaludtoolsDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.StringTokenizerStrict;
import org.profamilia.hc.view.util.XlsServletUtils;

/**
 * Esta clase representa la p�gina de alta de documentos
 * @author Bea
 *
 */
public class UploadBean extends BaseBean implements JRDataSource {
    /** Fichero binario */
    private UploadedFile docDocumento;

    /** Descripci�n del documento */
    private String descripcion;

    /** Content-type del documento */
    private String contentType;

    private List<Cisaludtool> lstRipsSalud;
    private List<Cisaludtool> lstRipsSaludBD;

    private Chconsulta consulta;

    private Cncitologi citologia;
    private boolean esSimil;
    private boolean renderValidar;
    private boolean generoReporte;
    private int index;

    /** Almacena la tabla de citologias */
    private HtmlDataTable dtBucarEpicrisis;

    public void init() {
        index = -1;
        renderValidar = false;
    }

    public UploadBean() {
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UploadedFile getDocDocumento() {
        return docDocumento;
    }

    public void setDocDocumento(UploadedFile docDocumento) {

        this.docDocumento = docDocumento;
    }

    /**
     *  Efect�a el upload del fichero
     */
    public String upload() throws IOException {
        if (docDocumento != null) {
            try {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().getApplicationMap().put("fileupload_bytes", 
                                                                          docDocumento.getBytes());
                facesContext.getExternalContext().getApplicationMap().put("fileupload_type", 
                                                                          docDocumento.getContentType());
                facesContext.getExternalContext().getApplicationMap().put("fileupload_name", 
                                                                          docDocumento.getName());
                ByteArrayInputStream inStream = 
                    new ByteArrayInputStream(docDocumento.getBytes());
                ByteArrayOutputStream theBOS = new ByteArrayOutputStream();

                byte buf[] = docDocumento.getBytes();
                theBOS.write(buf);
                Cisaludtool ripsSalud = null;
                boolean primeraLinea = true;
                int consec = 1;
                serviceLocator.getRipsService().deleteSaludtools();
                lstRipsSalud = new ArrayList<Cisaludtool>();
                Scanner scanner = new Scanner(inStream);
                while (scanner.hasNextLine()) {
                    ripsSalud = new Cisaludtool();

                    String cstctipide = "";
                    String cstanumide = "";
                    String cstcnombre = "";
                    String cstcapelli = "";
                    String cstdfecate = "";
                    String cstcservic = "";
                    String cstctipoci = "";
                    String cstccausae = "";
                    String cstcciepri = "";
                    String cstcdespri = "";
                    String cstcciesec = "";
                    String cstcdessec = "";
                    String cstnclinic = "";
                    String cstcprofes = "";
                    String cstcdepart = "";
                    String cstcciudad = "";
                    String cstcsexo = "";
                    String cstcedad = "";
                    String cstcestado = "";
                    String cstcerror = "";
                    String cstcfinalidad = "";
                    Integer cstnconcli = null;
                    String nomClinic = "";
                    StringTokenizerStrict stk = 
                        new StringTokenizerStrict(scanner.nextLine(), "|");

                    int i = 0;
                    boolean o;
                    o = false;

                    String token;

                    while (stk.hasMoreTokens()) {
                        token = (String)stk.nextElement();
                        token.trim();
                        i++;
                        if (i == 1 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                o = true;

                                cstctipide = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }
                        if (i == 2 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {

                            try {
                                if (primeraLinea == false) {
                                    o = true;
                                    int valor = 0;
                                    cstanumide = new String("" + 0);
                                    try {
                                        valor = Integer.parseInt(token.trim());
                                        cstanumide = new String("" + valor);
                                    } catch (NumberFormatException n) {

                                    }
                                }
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }


                        if (i == 3 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcnombre = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 4 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcapelli = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 5 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                if (primeraLinea == false) {
                                    ripsSalud.setCstcfecate(token.trim());
                                }

                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 6 && token != null && !token.equals("") && 
                            !token.trim().equals("")) {
                            try {
                                cstcservic = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 7 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstctipoci = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }
                        if (i == 8 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstccausae = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 9 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcciepri = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 10 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcdespri = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 12 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcciesec = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 13 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcdessec = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 15 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstnclinic = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 16 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcprofes = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 17 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcdepart = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 18 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcciudad = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 19 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                cstcsexo = new String(token.trim());
                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }

                        if (i == 20 && token != null && !token.equals("") && 
                            !token.trim().equals("null")) {
                            try {
                                if (primeraLinea == false) {
                                    ripsSalud.setCstcedad(token.trim());
                                }

                            } catch (Exception e) {
                                FacesUtils.addErrorMessage(e.getMessage());
                            }
                        }


                    }
                    if (primeraLinea == false) {

                        ripsSalud.setCstanumide(cstanumide);
                        ripsSalud.setCstcnombre(cstcnombre);
                        ripsSalud.setCstcapelli(cstcapelli);
                        ripsSalud.setCstcservic(cstcservic);
                        ripsSalud.setCstcsexo(cstcsexo);
                        ripsSalud.setCstcciudad(cstcciudad);
                        ripsSalud.setCstcdepart(cstcdepart);
                        ripsSalud.setCstcciepri(cstcciepri);
                        ripsSalud.setCstcdespri(cstcdespri);
                        ripsSalud.setCstcciesec(cstcciesec);
                        ripsSalud.setCstcdessec(cstcdessec);
                        ripsSalud.setCstcclinic(cstnclinic);
                        ripsSalud.setCstcsexo(cstcsexo);
                        String[] valoresIden = 
                        { "CEDULA DE CIUDADANIA", "TARJETA DE IDENTIDAD", 
                          "REGISTRO CIVIL", "CEDULA DE EXTRANJERIA", 
                          "ADULTO SIN IDENTIFICACION", "PASAPORTE", 
                          "MENOR SIN IDENTIFICACION", "NIT", 
                          "PERMISO ESPECIAL PERMANENCIA", "SALVOCONDUCTO" };
                        String[] llavesIden = 
                        { "CC", "TI", "RC", "CE", "AS", "PA", "MS", "NI", "PE", 
                          "SC" };
                        for (int j = 0; j < valoresIden.length; j++) {
                            setWords(valoresIden[j], cstctipide);
                            if (esSimil) {
                                ripsSalud.setCstctipide(llavesIden[j]);
                                break;
                            } else {
                                ripsSalud.setCstctipide("NV");
                            }
                        }


                        if ("MASCULINO".equalsIgnoreCase(cstcsexo)) {
                            ripsSalud.setCstcsexo("M");
                        } else if ("FEMENINO".equalsIgnoreCase(cstcsexo)) {
                            ripsSalud.setCstcsexo("F");
                        }
                        //si no es ninguno se marca como NO VALIDO X
                        else {
                            ripsSalud.setCstcsexo("X");
                        }
                        //ripsSalud.setNombreClinica(nomClinic);
                        ripsSalud.setCstcprofes(cstcprofes);
                        ripsSalud.setCstctipoci(cstctipoci);
                        ripsSalud.setSexo(cstcsexo);
                        ripsSalud.setTipoIden(cstctipide);
                        ripsSalud.setCstnsecuencia(consec);
                        //ripsSalud.
                        //Integer codigoCausa = serviceLocator.getRipsService().getCodigoConsultaExterna(cstccausae);
                        ripsSalud.setCstccausae(cstccausae.toUpperCase());
                        lstRipsSalud.add(ripsSalud);
                        

                    }
                    if (primeraLinea) {
                        primeraLinea = false;
                    }
                    consec++;
                }
                scanner.close();
                serviceLocator.getRipsService().savelstRipsSaludTools(lstRipsSalud);
                serviceLocator.getRipsService().updateLstRipsBySexo();
                serviceLocator.getRipsService().updateLstRipsByTipNum();
                serviceLocator.getRipsService().updateLstRipsNum();
                serviceLocator.getRipsService().updateLstRipsCausaE();
                serviceLocator.getRipsService().updateLstRipsServi();
                serviceLocator.getRipsService().updateLstRipsCIE10();
                serviceLocator.getRipsService().updateLstRipsSCIE10();
                serviceLocator.getRipsService().updateLstRipsByAdm();

                //generarArchivoCsv();
                //validarInformacion();
                renderValidar = true;

                //serviceLocator.getClinicoService().savelstCitologia(lstCitologia);
                //this.serviceLocator.getClinicoService().closeLecturaCitologia(consulta);


                FacesUtils.addInfoMessage(MSG_CARGA_VALIDA);
                return null;
            } catch (Exception ex) {
                ex.printStackTrace();
                FacesUtils.addErrorMessage((MSG_CARGA_NO_VALIDA + 
                                            ex.getMessage()));
                return null;
            }
        }
        return null;
    }

    public void prueba() {
        System.out.println("si entro aca primero o que hago");
    }

    public void validarInformacion() {
        try {
            lstRipsSaludBD = serviceLocator.getRipsService().getLstRips();
            
            Date fechaFin = null;
          
            //boolean ripRegistrado = this.serviceLocator.getRipsService().validarRipsDuplicados(lstRipsSaludBD.get(0));
            if (lstRipsSaludBD != null && !lstRipsSaludBD.isEmpty()) {
                //validar fechas
                for(int i = 0;i<lstRipsSaludBD.size();i++){
                    if (lstRipsSaludBD.get(i).getCstcestado() == null) {
                        String fechaStr=convertirFecha(lstRipsSaludBD.get(i).getCstcfecate());
                        if(fechaStr == null){
                            lstRipsSaludBD.get(i).setCstcerror("FORMATO DE FECHA NO VALIDO");
                            lstRipsSaludBD.get(i).setCstcestado("XX");
                        }
                    }
                }
                for (int i = 0;i<lstRipsSaludBD.size();i++) {
                   
                    boolean encontroAdmision = false;
                    int tipoConsulta = 1;

                    
                    //buscar admision por tipo identifiacio,numero identificacion,servicio,fecha inical y fehca final
                    if (lstRipsSaludBD.get(i).getCstcestado() == null) {
                       String fechaStr = convertirFecha(lstRipsSaludBD.get(i).getCstcfecate());
                        RipsSaludtoolsDTO datosAdmision = 
                            serviceLocator.getRipsService().updateLstRipsByAdminDatos(lstRipsSaludBD.get(i), 
                                                                                      tipoConsulta,fechaStr);

                        if (datosAdmision != null) {
                            encontroAdmision = true;
                        }
                        if (!encontroAdmision) {
                            tipoConsulta = 2;
                            datosAdmision = 
                                    serviceLocator.getRipsService().updateLstRipsByAdminDatos(lstRipsSaludBD.get(i), 
                                                                                              tipoConsulta,fechaStr);
                        }
                        if (datosAdmision != null) {
                            encontroAdmision = true;
                        }
                        if (!encontroAdmision) {
                            tipoConsulta = 3;
                            datosAdmision = 
                                    serviceLocator.getRipsService().updateLstRipsByAdminDatos(lstRipsSaludBD.get(i), 
                                                                                              tipoConsulta,fechaStr);
                        }
                        if (datosAdmision != null) {
                            encontroAdmision = true;
                        }

                        if (!encontroAdmision) {
                            tipoConsulta = 4;
                            datosAdmision = 
                                    serviceLocator.getRipsService().updateLstRipsByAdminDatos(lstRipsSaludBD.get(i), 
                                                                                              tipoConsulta,fechaStr);
                        }
                        if (datosAdmision != null) {
                            encontroAdmision = true;
                        }

                        if (!encontroAdmision) {
                            tipoConsulta = 5;
                            datosAdmision = 
                                    serviceLocator.getRipsService().updateLstRipsByAdminDatos(lstRipsSaludBD.get(i), 
                                                                                              tipoConsulta,fechaStr);
                        }
                        if (datosAdmision != null) {
                            encontroAdmision = true;
                        }
                        if (encontroAdmision) {


                            // setear valores a rips
                            lstRipsSaludBD.get(i).setCstcestado("VG");
                            lstRipsSaludBD.get(i).setCstcautori(datosAdmision.getCstcautori());
                            lstRipsSaludBD.get(i).setCstavalcon(datosAdmision.getCstavalcon());
                            lstRipsSaludBD.get(i).setCstavalnet(datosAdmision.getCstavalnet());
                            lstRipsSaludBD.get(i).setCstavalcuo(datosAdmision.getCstavalcuo());
                            lstRipsSaludBD.get(i).setCstnadmisi(datosAdmision.getCstnadmisi());
                            lstRipsSaludBD.get(i).setCstcsrvadm(datosAdmision.getCstcsrvadm());
                            //lstRipsSaludBD.get(i).setCstcautori();

                        }
                    }
                }
                //agregar datos a los rips de la tabla temporal
               
                for (int i = 0;i<lstRipsSaludBD.size();i++) {
                    
                    if ("VG".equals(lstRipsSaludBD.get(i).getCstcestado())) {
                        SimpleDateFormat sdf = 
                            new SimpleDateFormat("dd-MM-yyyy");
                        Date fecha = null;
                        lstRipsSaludBD.get(i).setCstnconsec(0);
                        lstRipsSaludBD.get(i).setCstnconcep(1);
                        lstRipsSaludBD.get(i).setCstnfincon(10);
                        lstRipsSaludBD.get(i).setCstncauext("15");
                        lstRipsSaludBD.get(i).setCstntipdia(1);
                        try {
                            fecha = sdf.parse(lstRipsSaludBD.get(i).getCstcfecate());
                            lstRipsSaludBD.get(i).setCstdfeccon(fecha);
                        } catch (ParseException e) {
                            FacesUtils.addErrorMessage("Error, valide si el formato de fecha es el correcto");
                        }

                        Cnconsclin aux = 
                            serviceLocator.getRipsService().getConsultaClinica(lstRipsSaludBD.get(i), 
                                                                               1);
                        if (aux != null) {
                            lstRipsSaludBD.get(i).setCstnnomcli(aux.getCconnumero());

                        }
                        aux = 
serviceLocator.getRipsService().getConsultaClinica(lstRipsSaludBD.get(i), 2);
                        if (aux != null) {
                            lstRipsSaludBD.get(i).setCstnclirip(aux.getCconclinic());

                        }
                        Cpservicio aux1 = 
                            serviceLocator.getRipsService().getCodigoCups(lstRipsSaludBD.get(i));
                        if (aux1 != null) {
                            lstRipsSaludBD.get(i).setCstccodcon(aux1.getCsvccodcups());
                        }
                        Cfadmision aux2 = 
                            serviceLocator.getRipsService().getUsuarioAdmision(lstRipsSaludBD.get(i));
                        if (aux2 != null) {
                            lstRipsSaludBD.get(i).setCstlusuario(aux2.getCannumpaci());
                        }
                        if (lstRipsSaludBD.get(i).getCstccodcon() != null && 
                            lstRipsSaludBD.get(i).getCstccodcon().length() < 5) {
                            lstRipsSaludBD.get(i).setCstccodcon(lstRipsSaludBD.get(i).getCstcsrvadm().substring(1, 
                                                                            7));
                        }

                        lstRipsSaludBD.get(i).setCstcdiagpr(lstRipsSaludBD.get(i).getCstcciepri());

                        if (!(lstRipsSaludBD.get(i).getCstcciepri().equals(lstRipsSaludBD.get(i).getCstcciesec()))) {
                            lstRipsSaludBD.get(i).setCstcdiagr1(lstRipsSaludBD.get(i).getCstcciesec());
                        }
                        boolean ripRegistrado = 
                            this.serviceLocator.getRipsService().validarRipsDuplicados(lstRipsSaludBD.get(i));
                        if (ripRegistrado) {
                            lstRipsSaludBD.get(i).setCstcestado("XX");
                            lstRipsSaludBD.get(i).setCstcerror("YA TIENE RIPS REGISTRADO");
                        }
                    }
                    
                }
                List<Crarcconsu> lstArchivoCon = new ArrayList<Crarcconsu>();
                for (int i = 0 ; i<lstRipsSaludBD.size();i++) {
                  
                    Crarcconsu archivoConsulta = new Crarcconsu();
                    CrarcconsuId id = new CrarcconsuId();
                    if ("VG".equals(lstRipsSaludBD.get(i).getCstcestado())) {
                        id.setCacnconcli(lstRipsSaludBD.get(i).getCstnnomcli());
                        id.setCacnconsec(lstRipsSaludBD.get(i).getCstnconsec());
                        archivoConsulta.setId(id);
                        archivoConsulta.setCacdfeccon(lstRipsSaludBD.get(i).getCstdfeccon());
                        archivoConsulta.setCacctipide(lstRipsSaludBD.get(i).getCstctipide());
                        archivoConsulta.setCacanumide((new BigDecimal(lstRipsSaludBD.get(i).getCstanumide())));
                        archivoConsulta.setCacnconcep(lstRipsSaludBD.get(i).getCstnconcep());
                        archivoConsulta.setCaccautori(lstRipsSaludBD.get(i).getCstcautori());
                        archivoConsulta.setCacccodcon(lstRipsSaludBD.get(i).getCstccodcon());
                        archivoConsulta.setCacnfincon(lstRipsSaludBD.get(i).getCstnfincon());
                        archivoConsulta.setCacncauext(Integer.parseInt(lstRipsSaludBD.get(i).getCstncauext()));
                        archivoConsulta.setCaccdiagpr(lstRipsSaludBD.get(i).getCstcdiagpr());
                        archivoConsulta.setCaccdiagr1(lstRipsSaludBD.get(i).getCstcdiagr1());
                        archivoConsulta.setCacntipdia(lstRipsSaludBD.get(i).getCstntipdia());
                        archivoConsulta.setCacavalcon(lstRipsSaludBD.get(i).getCstavalcon());
                        archivoConsulta.setCacavalcuo(lstRipsSaludBD.get(i).getCstavalcuo());
                        archivoConsulta.setCacavalnet(lstRipsSaludBD.get(i).getCstavalnet());
                        archivoConsulta.setCacdfecreg(new Date());
                        archivoConsulta.setCaccusuari(userName());
                        archivoConsulta.setVersion(0);
                        archivoConsulta.setCacnclinic(lstRipsSaludBD.get(i).getCstnclirip());
                        archivoConsulta.setCaclusuario(new BigDecimal(lstRipsSaludBD.get(i).getCstlusuario()));
                        lstArchivoCon.add(archivoConsulta);
                    }
                    if (lstRipsSaludBD.get(i).getCstcestado() == null) {
                        lstRipsSaludBD.get(i).setCstcestado("XX");
                        lstRipsSaludBD.get(i).setCstcerror("REGISTRO NO VALIDO");
                    }
                }
                serviceLocator.getRipsService().deleteSaludtools();
                serviceLocator.getRipsService().savelstRipsSaludTools(lstRipsSaludBD);
                if (!lstArchivoCon.isEmpty()) {
                    // guardar
                  
                    serviceLocator.getRipsService().savelstRipsCrarcconsu(lstArchivoCon);
                } else {
                    FacesUtils.addWarnMessage("No hay nuevos rips que generar");
                }
                lstRipsSaludBD= null;
                lstRipsSaludBD = serviceLocator.getRipsService().getLstRips();
                generarArchivoCsv();

            }
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

    }

    public String convertirFecha(String token) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date fecha = new Date();
        String fechastr = null;
        try {
            fecha = sdf.parse(token);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            fechastr = sdf1.format(fecha);
            return fechastr;
        } catch (ParseException e) {
            FacesUtils.addErrorMessage("No se puede convertir " + token + 
                                       "a String " + e.getMessage());
            return null;
        }
       
    }

    public boolean next() {
        index++;
        if (lstRipsSalud != null)
            return index < lstRipsSalud.size();
        else
            return false;

    }

    private void calculoLevenshtein(String str1, String str2) {

        int distancia;
        int[][] matriz;
        matriz = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            matriz[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            matriz[0][j] = j;
        }
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matriz[i][j] = matriz[i - 1][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    if ((matriz[i - 1][j]) + 1 < min) {
                        min = (matriz[i - 1][j]) + 1;
                    }
                    if ((matriz[i][j - 1]) + 1 < min) {
                        min = (matriz[i][j - 1]) + 1;
                    }
                    if ((matriz[i - 1][j - 1]) + 1 < min) {
                        min = (matriz[i - 1][j - 1]) + 1;
                    }
                    matriz[i][j] = min;
                }
            }
        }
        distancia = matriz[str1.length()][str2.length()];
        getAfinidad(str1, str2, distancia);

    }

    public void getAfinidad(String str1, String str2, int distancia) {
        float longitud = 
            str1.length() > str2.length() ? str1.length() : str2.length();
        float afinidad = 1 - (distancia / longitud);
        esSimil = false;
        //System.out.println("el valor a mirar del ciclo "+str1+" el valor de la columna "+str2+" afinidad de:"+afinidad);
        if (afinidad > 0.6) {
            esSimil = true;
        }
    }

    public void setWords(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        calculoLevenshtein(str1, str2);
    }


    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = lstRipsSaludBD.get(index).getCstctipide();
            return value;
        } else if (fieldName.equals("NUM_DOCUMENTO")) {
            value = lstRipsSaludBD.get(index).getCstanumide();
            return value;
        } else if (fieldName.equals("NOMBRES")) {
            value = lstRipsSaludBD.get(index).getCstcnombre();
            return value;
        } else if (fieldName.equals("APELLIDOS")) {
            value = lstRipsSaludBD.get(index).getCstcapelli();
            return value;
        } else if (fieldName.equals("FECHA_ATENCION")) {
            value = lstRipsSaludBD.get(index).getCstcfecate();
            return value;
        } else if (fieldName.equals("NOMBRE_SERVICIO")) {
            value = lstRipsSaludBD.get(index).getCstcservic().trim();
            return value;
        } else if (fieldName.equals("DES_SERVICIO")) {
            value = lstRipsSaludBD.get(index).getCstctipoci();
            return value;
        } else if (fieldName.equals("CIE_PRI")) {
            value = lstRipsSaludBD.get(index).getCstcciepri();
            return value;
        } else if (fieldName.equals("DCIE_PRI")) {
            value = lstRipsSaludBD.get(index).getCstcdespri();
            return value;
        } else if (fieldName.equals("CIE_SEC")) {
            value = lstRipsSaludBD.get(index).getCstcciesec();
            return value;
        } else if (fieldName.equals("DCIE_SEC")) {
            value = lstRipsSaludBD.get(index).getCstcdessec();
            return value;
        } else if (fieldName.equals("CLINICA")) {
            value = lstRipsSaludBD.get(index).getCstcclinic();
            return value;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = lstRipsSaludBD.get(index).getCstcprofes();
            return value;
        } else if (fieldName.equals("DEPARTAMENTO")) {
            value = lstRipsSaludBD.get(index).getCstcdepart();
            return value;
        } else if (fieldName.equals("CIUDAD")) {
            value = lstRipsSaludBD.get(index).getCstcciudad();
            return value;
        } else if (fieldName.equals("SEXO")) {
            value = lstRipsSaludBD.get(index).getCstcsexo();
            return value;
        } else if (fieldName.equals("EDAD")) {
            value = lstRipsSaludBD.get(index).getCstcedad();
            return value;
        } else if (fieldName.equals("ESTADO")) {
            value = lstRipsSaludBD.get(index).getCstcestado();
            return value;
        } else if (fieldName.equals("ERROR")) {
            value = lstRipsSaludBD.get(index).getCstcerror();
            return value;
        }
        return value;
    }


    public void generarArchivoCsv() {

        index = -1;
        if (lstRipsSaludBD == null || lstRipsSaludBD.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteRips.jasper");

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
                                                    "Reporte_Rips" + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);

                    generoReporte = true;

                }
            } catch (Exception e) {
                generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }

    public void setDtBucarEpicrisis(HtmlDataTable dtBucarEpicrisis) {
        this.dtBucarEpicrisis = dtBucarEpicrisis;
    }

    public HtmlDataTable getDtBucarEpicrisis() {
        return dtBucarEpicrisis;
    }

    public void setLstRipsSalud(List<Cisaludtool> lstRipsSalud) {
        this.lstRipsSalud = lstRipsSalud;
    }

    public List<Cisaludtool> getLstRipsSalud() {
        return lstRipsSalud;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setRenderValidar(boolean renderValidar) {
        this.renderValidar = renderValidar;
    }

    public boolean isRenderValidar() {
        return renderValidar;
    }
}
