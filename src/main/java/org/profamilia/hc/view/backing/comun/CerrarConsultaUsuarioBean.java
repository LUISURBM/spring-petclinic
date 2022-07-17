package org.profamilia.hc.view.backing.comun;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;


import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chcontabor;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chregisabort;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chusuarioabor;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Chantecolpo;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Chcolposcopia;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chcorrelec;
import org.profamilia.hc.model.dto.Chexamediagn;
import org.profamilia.hc.model.dto.Chremisilve;
import org.profamilia.hc.model.dto.Chtipocontro;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaMedicamentosBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.AlertaEmail;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class CerrarConsultaUsuarioBean extends BaseBean implements JRDataSource{

    /** Variable que almacena el bean de Conducta  */
    RecomedacionUsuarioBean conducta;

    /** Variable que almacena el bean de la impresion Diagnostica  */
    ImpresionDiagnosticaUsuarioBean impresion;

    /** Variable que almacena el bean de la impresion Diagnostica  */
    ImpresionDiagnosticaIlveBean impresionIlve;

    /** Variable que almacena el bean de la impresion Diagnostica */
    ImpresionDiagnosticaControlIlveBean impresionControlIlve;


    /** Variable que almacena el bean de motivo de consulta*/
    MotivoBean motivoConsulta;

    ConsultarFoliosBean folio;

    ControlUsuarioBean controlUsuario;

    ControlUsuarioIlveBean controlUsuarioIlve;

    private boolean generoResumen;

    private int index = -1;
    private boolean generoReporte;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String menuBean;

    private boolean esVacunacion;

    private Chimprdiag impreDiag;

    private Chmotivocon motcons;

    private String nextAction;

    private String navegacionRule;
    
    private PausarConsultaBean pausarConsulta;
    
    private boolean renderImprimirEspermograma; 
    
    private Long numeroConsulta;
    
    private boolean colposcopiaValidacion;
    
    private AplicacionMedicamentoBean aplicacionMedicamento;
    
    private String surveypalLink;
    
    /** Fiels Requeridos en el Reporte */
        private Date FECHA;
        private String NHISTCLINICA;
        private String CLINICA;
        private String PRIMERAPE;
        private String SEGUNDOAPE;
        private String NOMBRES;
        private Long NUMEROID;
        private String NOMBRELLAMAR;
        private Date FECHA_NACIMIENTO;
        private String IDGENERO;
        private String DIRECCION;
        private String TELEFONO;
        private String CIUDAD;
        private String RURAL;
        private String URBANA;
        private String ESTADOCIVIL;
        private String OCUPACION;
        private String TIPOAFILIACION;
        private String ASEGURADORA;
        private Long EDAD;
        private String ACOMPANANTE;
        private String TELEFONOCONTACTO;
        private String PARENTESCO;
        private String MOTIVOCONSULTA;
        /*antecedentes colposocpia*/
        private Long NGESTACIONES;
        private Long NPARTOS;
        private Long NABORTOS;
        private Long NCESAREAS;
        private String RELACIONSEXUAL;
        private Long NCOMPANEROS;
        private Long HIJOSV;
        private Long HIJOSE;
        private Long HIJOSM;
        private Long HIJOSMOLA;
        private Date ULTIMOPARTO;
        private String METODOPLAN;
        private String FUMA;
        private String DIABETES;
        private String VIH;
        private String ETS;
        private Date FECHAULTREGLA;
        private String CITNUNCA;
        private String CITMASUNAVEZ;
        private String CITMENOSANO;
        private String CITNORECUER;
        private String RESULTADOCIT;
        private String TIPOCICLOR;
        private String TIPOCICLOI;
        private String TIPOCICLONM;
        private String TIPOCICLOA;
        private Long FRECICLO;
        private Long EDADMENARQUIA;
        private String VACUNAVPH;
        private Long DOSISVACUNAVPH;
        private String TIPIFIVPH;
        private String ANTECEDENTEPROC;
        private String RESULTADOPROC;
        /*VIOLENCIA*/
        private String VIOLENTOMTRO;
        private String FISICA;
        private String REPRODUCTIVA;
        private String PSICOLOGICA;
        private String SEXUAL;
        private String ECONOMICA;
        private String QUIENFISICA;
        private String QUIENREPRODUCTIVA;
        private String QUIENPSICOLOGICA;
        private String QUIENSEXUAL;
        private String QUIENECONOMICA;
        private String RIESGOABANDONO;
        private String AGRESORFAMILIA;
        private String DANOMISMO;
        private String AGRESORCASA;
        private String FAMILIAENTERADA;
        private String REMISIONEXT;
        private String REMISIONINT;
        private String REMISIONLUGAR;
        private String REMISIONLUGARINTERNA;
        private String REMISIONLUGAREXTERNA;


        /*COLPOSCOPIA*/
        private String EVALUACIONGENERAL;
        private String INFLAMACION;
        private String SANGRADO;
        private String CICATRIZ;
        private String  OTROS;
        private String OTROSCUAL;
        private String ESCAMOCULUMNA;
        private String TRNASFORMACION;
        private String HALLAZGOMADU;
        private String HALLAZGOQUISTE;
        private String HALLAZGOESCTOPIA;
        private String HALLAZGOATROF;
        private String HALLAZGOABERGLAND;
        private String HALLAZGODECIEMBARAZO;
        private String HALLAZVAZONA;
        private String HALLAZVALEUCO;
        private String HALLAZVACONDILOMA;
        private String HALLAZVAINFLAM;
        private String HALLAZVAESTENOSIS;
        private String HALLAZVAANOCONG;
        private String HALLAZVAANOTRATA;
        private String HALLAZVAPOLIPO;
        private String HALLAZVAENDOMETRI;
        private String HALLAZVAOTRO;
        private String HALLAZVAOTROCUAL;
        private String GRADOHALLA;
        private String HCLCGRAD1EPITELIO;
        private String HCLCGRAD1BORDER;
        private String HCLCGRAD1MOSAICOF;
        private String HCLCGRAD1PUNTEADOF;
        private String HCLCGRAD2MOSAICOG;
        private String HCLCGRAD2SIGBINT;
        private String HCLCGRAD2SIGCRES;
        private String HCLCGRAD2PUNTIG;
        private String HCLCGRAD2BORDEDEL;
        private String HCLCGRAD2APAEPITELIO;
        private String HCLCGRAD2ORIFICIOGLA;
        private String HCLCGRAD3TEST;
        private String UBICACIONLDENTRO;
        private String UBICACIONLFUERA;
        private String UBICACIONLNCUADRAN;
        private String UBICACIONLPORCEN;
        private String SIVASOSATI;
        private String SIVASOSDEL;
        private String SISUPIRRE;
        private String SILESIOEX;
        private String SINECROSIS;
        private String SIULCERA;
        private String SITUMOR;
        private String SIOTROS;
        private String NOMBRE_PROFESIONAL;
        private String REG_PROFESIONAL;
        private String IDEN_PROFESIONAL;
        /*IMPRESION DAIGNOSTICA*/
        private String IMPDIAGN;
        private String IMPDIAGINF;
        private String IMPDIAGATR;
        private String IMPDIAGCARINV;
        private String IMPDIAGSVPH;
        private String IMPDIAGBGRADO;
        private String IMPDIAGAGRADO;
        private String IMPDIAGOTRO;
        private String OBSERVACIONESDIAG;
         /*CONDUCTA*/
        private String PLANMANEJO;
        private String RECOMENDACIONES;
        private String HCLCGRAD2EPACEDEN;
        private String HALLAZNOESPEROSION;
        
        private String HACCFUMA;
        private String HACCDIABETES;
        private String HACCVIH;
        private String HACCETS;
        private String HCLCTOMOBIOP;
        
        private String HCLCOBSERVACIO;
        
    private String edad;
    private String sexo;
    private String genero;
    private String orientacion;
    private String escolaridad;
    private String clinica;
    private String servicio;
    private String contrato;
    private String eps;
    private String etnia;
    private String convenio;
    private String discapacidad;
    private String gestante;
    private String procedencia;
    private String numeroIden;
    private String numeroContacto;
    private String numeroContrato;
    
    public CerrarConsultaUsuarioBean() {
    }

    public void init() {
        generoResumen = false;
        esVacunacion = false;
    }
    
    public void resetReporteColposcopia(){
    NOMBRE_PROFESIONAL = null;
    REG_PROFESIONAL = null;
    IDEN_PROFESIONAL = null;
        EVALUACIONGENERAL = null; 
             INFLAMACION = null; 
             SANGRADO = null; 
             CICATRIZ = null; 
              OTROS = null; 
             OTROSCUAL = null; 
             ESCAMOCULUMNA = null; 
             TRNASFORMACION = null; 
             HALLAZGOMADU = null; 
             HALLAZGOQUISTE = null; 
             HALLAZGOESCTOPIA = null; 
             HALLAZGOATROF = null; 
             HALLAZGOABERGLAND = null; 
             HALLAZGODECIEMBARAZO = null; 
             HALLAZVAZONA = null; 
             HALLAZVALEUCO = null; 
             HALLAZVACONDILOMA = null; 
             HALLAZVAINFLAM = null; 
             HALLAZVAESTENOSIS = null; 
             HALLAZVAANOCONG = null; 
             HALLAZVAANOTRATA = null; 
             HALLAZVAPOLIPO = null; 
             HALLAZVAENDOMETRI = null; 
             HALLAZVAOTRO = null; 
             HALLAZVAOTROCUAL = null; 
             GRADOHALLA = null; 
             HCLCGRAD1EPITELIO = null; 
             HCLCGRAD1BORDER = null; 
             HCLCGRAD1MOSAICOF = null; 
             HCLCGRAD1PUNTEADOF = null; 
             HCLCGRAD2MOSAICOG = null; 
             HCLCGRAD2SIGBINT = null; 
             HCLCGRAD2SIGCRES = null; 
             HCLCGRAD2PUNTIG = null; 
             HCLCGRAD2BORDEDEL = null; 
             HCLCGRAD2APAEPITELIO = null; 
             HCLCGRAD2ORIFICIOGLA = null; 
             HCLCGRAD3TEST = null; 
             UBICACIONLDENTRO = null; 
             UBICACIONLFUERA = null; 
             UBICACIONLNCUADRAN = null; 
             UBICACIONLPORCEN = null; 
             SIVASOSATI = null; 
             SIVASOSDEL = null; 
             SISUPIRRE = null; 
             SILESIOEX = null; 
             SINECROSIS = null; 
             SIULCERA = null; 
             SITUMOR = null; 
             SIOTROS = null; 
             /*IMPRESION DAIGNOSTICA*/
             IMPDIAGN = null;
             IMPDIAGINF = null; 
             IMPDIAGATR = null; 
             IMPDIAGCARINV = null; 
             IMPDIAGSVPH = null; 
             IMPDIAGBGRADO = null; 
             IMPDIAGAGRADO = null; 
             IMPDIAGOTRO = null; 
             OBSERVACIONESDIAG = null; 
              /*CONDUCTA*/
             PLANMANEJO = null; 
             RECOMENDACIONES = null; 
             HCLCGRAD2EPACEDEN = null; 
             HALLAZNOESPEROSION = null; 
             
            HACCFUMA = null; 
            HACCDIABETES= null; 
            HACCVIH= null; 
            HACCETS= null; 
            HCLCTOMOBIOP= null; 
            HCLCOBSERVACIO= null;
            
    }


    public void inicalizarCerrarConsultaBean() {
        generoResumen = false;
        FacesUtils.resetManagedBean("consultarFoliosBean");

        conducta = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        impresion = 
                (ImpresionDiagnosticaUsuarioBean)FacesUtils.getManagedBean("impresionDiagnosticaUsuarioBean");
        impresionIlve = 
                (ImpresionDiagnosticaIlveBean)FacesUtils.getManagedBean("impresionDiagnosticaIlveBean");
        impresionControlIlve = 
                (ImpresionDiagnosticaControlIlveBean)FacesUtils.getManagedBean("impresionDiagnosticaControlIlveBean");
        motivoConsulta = (MotivoBean)FacesUtils.getManagedBean("motivoBean");
        controlUsuario = 
                (ControlUsuarioBean)FacesUtils.getManagedBean("controlUsuarioBean");
        controlUsuarioIlve = (ControlUsuarioIlveBean)FacesUtils.getManagedBean("controlUsuarioIlveBean");

        Chconsulta consul = null;
        try {
            if (consulta != null && consulta.getCconnumero() != null) {
                consul = 
                        this.getServiceLocator().getClinicoService().getConsultaCompleta(new Long(consulta.getCconnumero()), 
                                                                                     TIPO_CONSULTA);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (consul != null) {
            folio = (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
            if (folio != null && usuario != null && consul != null) {
                folio.setConsultaClone(consul);
                folio.setUsuario(usuario);
                folio.setNumeroConsulta(consul.getHcolnumero());
                folio.init();
                folio.visualizarConsulta();
            }
        }
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

    public void generarImpresionFolio() {
        index = -1;
        Chconsulta consul;
        consul = null;
        FacesUtils.resetManagedBean("consultarFoliosBean");
        try {
            if (consulta != null && consulta.getCconnumero() != null) {
                consul = 
                        this.getServiceLocator().getClinicoService().getConsultaActual(new Long(consulta.getCconnumero()));
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (consul != null) {
            folio = (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
            if (folio != null && usuario != null && consul != null) {
                folio.setConsultaClone(consul);
                folio.setUsuario(usuario);
                folio.setNumeroConsulta(consul.getHcolnumero());
                folio.ImprimirFolio();
                generoResumen = true;
            }
        }
    }


    /**
     * @return
     */
    public String cerrarConsulta() throws ModelException {
        impreDiag = null;
        motcons = null;
        navegacionRule = "";

        if (usuario != null) {
            linkSurveypal();
            if (consulta != null && consulta.getCcocservic() != null) {
                if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL) || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_GINECOLOGIA)
                || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_DERMATOLOGIA)|| consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_UROLOGIA)
                || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_EXAMEN_MAMA)|| consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_ENTREGA_RESULTADO)){
                    if (controlUsuario != null) {
                        impreDiag = controlUsuario.getImpresion();
                        motcons = controlUsuario.getMotivo();
                    }
                } else if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_FERTILIDAD)) {
                    if (controlUsuario != null) {
                        impreDiag = controlUsuario.getImpresion();
                        motcons = controlUsuario.getMotivo();
                    }
                }else if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)) {
                    if (controlUsuarioIlve != null) {
                        impreDiag = controlUsuarioIlve.getImpresion();
                        motcons = controlUsuarioIlve.getMotivo();
                        guardarSeguimientoIVE();
                    }
                }else if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION) || 
                         consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA)) {
                    guardarSeguimientoIVE();
                } else {
                    if (impresion != null && motivoConsulta != null) {
                        impreDiag = impresion.getImpresion();
                        motcons = motivoConsulta.getMotivo();
                    }
                }
            }

            nextAction = BeanNavegacion.RUTA_LISTA;

            Long numeroConsulta = null;
            if (conducta != null && conducta.esValido()) {
                if (conducta != null && conducta.getConducta() != null && 
                    conducta.getConducta().getId() != null && 
                    conducta.getConducta().getId().getHcnlconsulta() != null) {
                    numeroConsulta = conducta.getConducta().getId().getHcnlconsulta();
                }
                try {
                
                    this.serviceLocator.getClinicoService().closeConsulta(usuario,
                                                                          consulta,
                                                                          impreDiag,
                                                                          motcons,
                                                                          userName(),surveypalLink);

                    
                /*  if (consulta != null && consulta.getCconcontra() != null && (consulta.getCconcontra().equals(IConstantes.NUM_CONTRATO_SALUDTOTAL1) || consulta.getCconcontra().equals(IConstantes.NUM_CONTRATO_SALUDTOTAL2))) {
                        if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_PROCEDIMIENTO_COLPOSCOPIA)) {
                            ResultadosLCResponse resultadosLCResponse = 
                                new ResultadosLCResponse();
                            resultadosLCResponse = 
                                    this.serviceLocator.getClinicoService().envioResultadosColposcopiaSaludTotal(usuario, 
                                                                                                                 consulta, 
                                                                                                                 impreDiag, 
                                                                                                                 userName());
                            if (resultadosLCResponse.getData().getError().equals("0")) {
                                FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                          "Respuesta WS: " + 
                                                          resultadosLCResponse.getNotification().getMessage() + 
                                                          " Estado: " + 
                                                          resultadosLCResponse.getNotification().getStatus());
                            } else {
                                FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                          "Respuesta WS:" + "Error: " + 
                                                          resultadosLCResponse.getData().getError() + 
                                                          " " + "Descripcion:  " + 
                                                          resultadosLCResponse.getData().getDescripcion() + 
                                                          " " + "Resultado LC: " + 
                                                          resultadosLCResponse.getData().getResultadoLC());
                            }
                            
                        }else if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_GINECOLOGIA) 
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_GINECOLOGIA)
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_UROLOGIA)
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_UROLOGIA)
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_EXAMEN_MAMA)
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_DERMATOLOGIA)
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_EXAMEN_MAMA)
                        || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_OTRAS_ESPECIALIDADES)) {
                        
                        if(motcons != null && motcons.getHmcctrapatol() != null && motcons.getHmcctrapatol().equals("S") && "CX".equals(motcons.getHmcctippatol())){
                            ResultadosLCResponse resultadosLCResponse = 
                                new ResultadosLCResponse();
                             resultadosLCResponse = 
                                    this.serviceLocator.getClinicoService().envioResultadosPatologiaSaludTotal(usuario, 
                                                                                                                 consulta, 
                                                                                                                 motcons, 
                                                                                                                 userName());
                            if (resultadosLCResponse.getData().getError().equals("0")) {
                                FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                          "Respuesta WS: " + 
                                                          resultadosLCResponse.getNotification().getMessage() + 
                                                          " Estado: " + 
                                                          resultadosLCResponse.getNotification().getStatus());
                            } else {
                                FacesUtils.addInfoMessage(IMsg.MSG_ADICION + 
                                                          "Respuesta WS:" + "Error: " + 
                                                          resultadosLCResponse.getData().getError() + 
                                                          " " + "Descripcion:  " + 
                                                          resultadosLCResponse.getData().getDescripcion() + 
                                                          " " + "Resultado LC: " + 
                                                          resultadosLCResponse.getData().getResultadoLC());
                            }
                        
                        }
                            
                        }
                    }*/
                    
                    //envio de email
                     if(usuario != null && usuario.getHusccorreoelec() != null && !usuario.getHusccorreoelec().equals("")){
                        String recipientTo="";
                        if (usuario.getHusnaceppolprv() != null && usuario.getHusnaceppolprv().intValue() == 1) {
                            recipientTo = usuario.getHusccorreoelec();
//                            email.sendCierreConsulta(consulta, usuario, recipientTo, surveypalLink);
                            try {
                                this.sendCorreoSurveypal(consulta, recipientTo);                        
                            } catch (Exception e) {
                                e.printStackTrace();
//                                FacesUtils.addErrorMessage("Error al enviar correo Surveypal: " + e.getMessage());
                            }
                        }
                    }

                    if (IConstantes.HISTORIA_INTERRUPCION.equals(consulta.getCcocservic().getCsvntiphis())) {
                        boolean valdacionIVEAdmision = false;

                        Cpservicio servicio = null;

                        try {
                            valdacionIVEAdmision = 
                                    this.getServiceLocator().getClinicoService().getDetalleAdmisionXTipoHistoria(consulta.getCconnumdoc().longValue(), 
                                                                                                                 IConstantes.HISTORIA_INTERRUPCION);
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }

                        if (consulta.getCcocservic() != null) {
                            servicio = consulta.getCcocservic();
                        }

                        
                            
                            List<Cnconsclin> listaConsultas = 
                                this.getServiceLocator().getClinicoService().getConsultaAdmisionXTipoHistoria(consulta.getCconnumdoc().longValue(), 
                                                                                                              IConstantes.HISTORIA_INTERRUPCION);
                            if (listaConsultas != null && 
                                !listaConsultas.isEmpty()) {
                                this.getServiceLocator().getClinicoService().atenderConsultaClinicaIve(listaConsultas, 
                                                                                                    userName(),consulta);
                            }
                        
                    }else{
                    
                        Chexamediagn diagnostico = 
                         this.getServiceLocator().getClinicoService().getExamenApoyoDiagnostico(consulta.getCconnumero().longValue());

                        if (diagnostico != null && 
                            diagnostico.getHednmetodopaq() != null) {
                            Cnconsclin consultaMetodo = 
                                this.getServiceLocator().getClinicoService().getConsultaClinicaPorId(diagnostico.getHednmetodopaq().toString());

                            if (consultaMetodo != null) {
                                List<Cnconsclin> listaConsultas = new ArrayList();
                                listaConsultas.add(consultaMetodo);
                                this.getServiceLocator().getClinicoService().atenderConsultaClinica(listaConsultas, 
                                                                                                    userName());
                            }
                        }
                    }
                    navegacionRule = nextAction;
                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(e.getMessage());
                    e.printStackTrace();
                    return null;
                } catch (Exception ex) {
                    FacesUtils.addErrorMessage(ex.getMessage());
                    ex.printStackTrace();
                    return null;
                }

                if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
                    pausarConsulta = 
                            (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                    pausarConsulta.cerrarPausa(consulta.getCconnumero().longValue());
                }
                FacesUtils.resetManagedBean("listaMisUsuariosBean");
                FacesUtils.resetManagedBean("listaUsuariosBean");
                FacesUtils.addInfoMessage(MSG_ADICION);
                return navegacionRule;

            } else {
                FacesUtils.addErrorMessage(MSG_NO_REGISTRO_CONDUCTA);
                return BeanNavegacion.RUTA_ACTUAL;
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_ACTUALIZO_DATOS_USUARIO);
            return null;
        }
    }
    public void guardarSeguimientoIVE(){
    
        boolean esControl = false;
        String tipoControl = null;
            Chusuarioabor usuarioAborto;
            try {
            Chconsulta consul = null;
                if (consulta != null && consulta.getCconnumero() != null) {
                    consul = 
                            this.getServiceLocator().getClinicoService().getConsultaActual(new Long(consulta.getCconnumero()));
                }
                if(consul !=null){
                String formulaMedica = null;
                Chremisilve remision = null;
                    String escogeVoluntariamente ="InterrupciNn voluntaria del embarazo";
                    String siguienteTecnica = "";        
                    if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)
                    ||consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION )) {
               remision = 
                        serviceLocator.getClinicoService().getRemisionIlve(consulta.getCconnumero().longValue(),"C");
                                                               
                if(remision != null){
                   
                    if(("AG").equals(remision.getHrictiporemis())){
                        siguienteTecnica = "Aborto por aspiraciNn Bajo anestesia general";
                    }
                    else if(("FA").equals(remision.getHrictiporemis())){
                        siguienteTecnica = "Aborto FarmacolNgico";
                        if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)){
                           List<Chformulamed> lstformulaMedica= serviceLocator.getClinicoService().getListPrescripciones(consulta.getCconnumero().longValue());
                           if(lstformulaMedica !=null && !lstformulaMedica.isEmpty()){
                           formulaMedica = "";
                               for(int i = 0;i<lstformulaMedica.size();i++){
                                   if(i==(lstformulaMedica.size()-1)){
                                       formulaMedica +=lstformulaMedica.get(i).getHfocmedicament();
                                   }
                                   else{
                                       formulaMedica +=lstformulaMedica.get(i).getHfocmedicament()+", ";
                                   }
                               }
                           }
                        }
                    }
                    else if(("AB").equals(remision.getHrictiporemis())){
                        siguienteTecnica = "Aborto por aspiraciNn bajo Bloqueo";
                    }
                    else if(("DE").equals(remision.getHrictiporemis())){
                         siguienteTecnica = "Aborto por dilataciNn y evacuaciNn";
                    }
                    else if(("AF").equals(remision.getHrictiporemis())){
                         siguienteTecnica = "InterrupciNn voluntaria del embarazo por asistolia fetal";
                    }
                
                    if(("CG").equals(remision.getHricescogvolun())){
                        escogeVoluntariamente = "Continuar gestaciNn";
                    }
                    else if(("AD").equals(remision.getHricescogvolun())){
                        escogeVoluntariamente = "Adopcion";
                     }
                }
                    
                    }           
                usuarioAborto = 
                        serviceLocator.getClinicoService().findOneUsuarioAbort(usuario.getHusanumeiden(),usuario.getHusetipoiden());
                        if(usuarioAborto !=null){
                            Chregisabort registroAborto = serviceLocator.getClinicoService().findOneRegistroUsuarioAbort(usuarioAborto.getHualnumero());
                            if (registroAborto !=null){
                              String  nombreProfesional = formatearCampoNombreUsuario(consul.getHcocoperador(),consul.getHconclinica());
                                Chcontabor seguimientoUsuario = new Chcontabor();
                                if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)
                                || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)) {
                                    Chantegineco antecedentes =  serviceLocator.getClinicoService().getAntecedentesGinecologicos(consulta.getCconnumero().longValue());
                                    if(antecedentes !=null && antecedentes.getHagdfur()!=null){                                      
                                            registroAborto.setHradultmen(antecedentes.getHagdfur());    
                                            registroAborto.setHransememb(calcularSemanasEmbarazo(registroAborto.getHradultmen()));
                                    }
                                   
                                    if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)){
                                    esControl = true;
                                       
                                        Chexamfisico examen = 
                                                this.getServiceLocator().getClinicoService().getExamenFisico(consulta.getCconnumero().longValue(),1);
                                    ArrayList<Chtipocontro> lstTipoControlAux = null;
                                    lstTipoControlAux = 
                                            (ArrayList<Chtipocontro>)this.getServiceLocator().getClinicoService().getTipoControlIlve();
                                    if(lstTipoControlAux !=null && !lstTipoControlAux.isEmpty()){
                                        if(motcons!=null){
                                       
                                        for (int i = 0;i<lstTipoControlAux.size();i++){
                                            if( lstTipoControlAux.get(i).getCtcecodigo().equals(motcons.getHmcctipocontr())){
                                            tipoControl=lstTipoControlAux.get(i).getCtcecodigo();
                                                if(lstTipoControlAux.get(i).getCtccdescripcio().contains("Control")){
                                                    //caso 1 al 3
                                                     seguimientoUsuario.setHcacobserva(nombreProfesional+", "+"Se realiza:"+lstTipoControlAux.get(i).getCtccdescripcio().toUpperCase());
                                                     
                                                }
                                                else if(lstTipoControlAux.get(i).getCtcecodigo().equals("CE")){
                                                    // caso 6             
                                                        if(remision!=null){
                                                             if(examen !=null && ("S").equals(examen.getHefcconfiembar())){
                                                                 seguimientoUsuario.setHcacobserva(nombreProfesional+", "+"Se realiza control:"+lstTipoControlAux.get(i).getCtccdescripcio().toUpperCase()+" ,"+"NLa usuaria escoge libremente la siguiente tNcnica:"+siguienteTecnica);
                                                             }
                                                        }
                                                             else{
                                                                 seguimientoUsuario.setHcacobserva(nombreProfesional+", NO SE CONFIRMA EMBARAZO EN CONSULTA");
                                                             }
                                                          
                                                }
                                                else{
                                                //caso 4 y 5
                                                    seguimientoUsuario.setHcacobserva(nombreProfesional+", "+"Se realiza control:"+lstTipoControlAux.get(i).getCtccdescripcio().toUpperCase());
                                                   
                                                    
                                                }
                                                break;
                                            }
                                        }
                                        }
                                    }
                                    if(tipoControl.equals("IM") || tipoControl.equals("CE")){
                                        if(tipoControl.equals("IM")){
                                            List<Chformulamed> lstformulaMedica= serviceLocator.getClinicoService().getListPrescripciones(consulta.getCconnumero().longValue());
                                            if(lstformulaMedica !=null && !lstformulaMedica.isEmpty()){
                                            formulaMedica="";
                                                for(int i = 0;i<lstformulaMedica.size();i++){
                                                    if(i==(lstformulaMedica.size()-1)){
                                                        formulaMedica +=lstformulaMedica.get(i).getHfocmedicament();
                                                    }
                                                    else{
                                                        formulaMedica +=lstformulaMedica.get(i).getHfocmedicament()+", ";
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            if(examen!=null && ("S").equals(examen.getHefcconfiembar())){
                                                List<Chformulamed> lstformulaMedica= serviceLocator.getClinicoService().getListPrescripciones(consulta.getCconnumero().longValue());
                                                if(lstformulaMedica !=null && !lstformulaMedica.isEmpty()){
                                                formulaMedica="";
                                                    for(int i = 0;i<lstformulaMedica.size();i++){
                                                        if(i==(lstformulaMedica.size()-1)){
                                                            formulaMedica +=lstformulaMedica.get(i).getHfocmedicament();
                                                        }
                                                        else{
                                                            formulaMedica +=lstformulaMedica.get(i).getHfocmedicament()+", ";
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                      
                                    }
                            if(!esControl){
                                if(remision!=null){
                                    seguimientoUsuario.setHcacobserva(nombreProfesional+", "+"Paciente escoge voluntariamente, "+escogeVoluntariamente+", "+siguienteTecnica);
                                }
                                else{
                                    seguimientoUsuario.setHcacobserva(nombreProfesional+", NO SE CONFIRMA EMBARAZO EN CONSULTA");
                                }
                                    seguimientoUsuario.setHcactipocont("CM");
                                    registroAborto.setHraconsumed("S");
                            }
                                    else{
                                        seguimientoUsuario.setHcactipocont("CO");                                       
                                        registroAborto.setHraccontrol("S");
                                    }
                                }
                                       
                            else{
                                
                                if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_PSICOLOGICA)){
                                    seguimientoUsuario.setHcacobserva(nombreProfesional+", Se realiza consulta psicNlogica para el servicio " +consulta.getCcocservic().getCsvccodigo()+" "+consulta.getCcocservic().getCsvcnombre());
                                    seguimientoUsuario.setHcactipocont("PS");
                                    registroAborto.setHracpsicolo("S");
                                }
                                else{
                                    seguimientoUsuario.setHcacobserva(nombreProfesional+", Se realiza un procedimiento para el servicio:" +consulta.getCcocservic().getCsvccodigo()+" "+consulta.getCcocservic().getCsvcnombre());
                                    seguimientoUsuario.setHcactipocont("PR");
                                    registroAborto.setHracproced("S");
                                }                           
                             }
                               
                              
                                registroAborto.setHracseguim("S");
                               seguimientoUsuario.setHcadfechobse(new Date());
                                seguimientoUsuario.setHcancodclin(consulta.getCconclinic());
                                seguimientoUsuario.setHcacusuareg(usuario.getHuscoperador());
                                seguimientoUsuario.setHcalnumeusua(registroAborto.getHralnumero());
                              seguimientoUsuario.setHcannumcons(consulta.getCconnumero().longValue());
                                serviceLocator.getClinicoService().saveSeguimientoUsuarioAbort(seguimientoUsuario);
                                serviceLocator.getClinicoService().saveRegistroUsuarioAbort(registroAborto);
                                
                             if(formulaMedica!=null){
                                 seguimientoUsuario = new Chcontabor();
                                 seguimientoUsuario.setHcadfechobse(new Date());
                                  seguimientoUsuario.setHcancodclin(consulta.getCconclinic());
                                  seguimientoUsuario.setHcacusuareg(usuario.getHuscoperador());
                                  seguimientoUsuario.setHcalnumeusua(registroAborto.getHralnumero());
                                 seguimientoUsuario.setHcacobserva("Se formula "+formulaMedica);
                                 seguimientoUsuario.setHcactipocont("SG");
                                 seguimientoUsuario.setHcannumcons(consulta.getCconnumero().longValue());
                                 if(esControl){
                                 if(tipoControl.equals("CE")){
                                     seguimientoUsuario.setHcacobserva("Se formula "+formulaMedica);
                                 }
                                 else{
                                     seguimientoUsuario.setHcacobserva("Se formula refuerzo "+formulaMedica);
                                 }
                                    
                                     seguimientoUsuario.setHcactipocont("SG");
                                 }
                                 serviceLocator.getClinicoService().saveSeguimientoUsuarioAbort(seguimientoUsuario);
                             }
                            
                            }
                        }
                }
             
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(e.getMessage());
            }
        if(!consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL_INTERRUPCION)){
    if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_INTERRUPCION)){
    if (impresionIlve != null) {
            impreDiag = impresionIlve.getImpresion();
            motcons = motivoConsulta.getMotivo();
    }
    
         else {
        if (impresion != null && motivoConsulta != null) {
            impreDiag = impresion.getImpresion();
            motcons = motivoConsulta.getMotivo();
        }
    }
    }
    else{
        if (impresion != null && motivoConsulta != null) {
            impreDiag = impresion.getImpresion();
            motcons = motivoConsulta.getMotivo();
        }
    }
        }
    }
    public double calcularSemanasEmbarazo(Date fechaultimaregla) {
           //Creo las dos instancias de fecha

           int semanaAux = 0;
           Integer residuo = 0;
           double semana = 0;
           Double dias = new Double(0);
           String imcStr = "";
           if (fechaultimaregla != null) {

               Calendar calendarconsulta = Calendar.getInstance();
               Calendar calendarUltimaRegla = Calendar.getInstance();
               calendarUltimaRegla.setTime(fechaultimaregla);
               //Realizo la operaciNn
               long time
                       = calendarconsulta.getTimeInMillis() - calendarUltimaRegla.getTimeInMillis();
               //Muestro el resultado en dNas
               dias = new Double((time / (3600 * 24 * 1000)));
               semanaAux = (dias.intValue() / 7);
               residuo = dias.intValue() % 7;

               semana = semanaAux + residuo.doubleValue() / 10;

               if (semana < 0) {
                   semana = 0;
               }

               if (semana >= 43) {
                   semana = 0;
               }
           }
           //RequestContext.getCurrentInstance().update("sememb");
           return semana;
       }
    public String cerrarConsultaEnfermeria() throws ModelException {
        impreDiag = null;
        motcons = null;
        navegacionRule = "";

        if (usuario != null) {
            if (consulta != null && consulta.getCcocservic() != null) {
                linkSurveypal();
                if (consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_CONTROL) || consulta.getCcocservic().getCsvntiphis().equals(IConstantes.HISTORIA_ENTREGA_RESULTADO )) {
                    if (controlUsuario != null) {
                        impreDiag = controlUsuario.getImpresion();
                        motcons = controlUsuario.getMotivo();
                    }
                } else {
                    if (impresion != null && motivoConsulta != null) {
                        impreDiag = impresion.getImpresion();
                        motcons = motivoConsulta.getMotivo();
                    }
                }
            }

            nextAction = BeanNavegacion.RUTA_LISTA_TODOS_LOS_USUARIOS_ENFERMERIA;

            Long numeroConsulta = null;
            if (conducta != null && conducta.esValido()) {
                if (conducta != null && conducta.getConducta() != null && 
                    conducta.getConducta().getId() != null && 
                    conducta.getConducta().getId().getHcnlconsulta() != null) {
                    numeroConsulta = 
                            conducta.getConducta().getId().getHcnlconsulta();
                }
                try {
                        this.serviceLocator.getClinicoService().closeConsulta(usuario, consulta, impreDiag, motcons, userName(), surveypalLink);
                    navegacionRule = nextAction;
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_CERRAR_CONSULTA);
                }
                
                if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
                    pausarConsulta = 
                            (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                    pausarConsulta.cerrarPausa(consulta.getCconnumero().longValue());
                }
                
                FacesUtils.resetManagedBean("listaMisUsuariosBean");
                FacesUtils.resetManagedBean("listaUsuariosBean");
                FacesUtils.resetManagedBean("listaUsuariosEnfermeriaBean");

                FacesUtils.addInfoMessage(MSG_ADICION);
                return navegacionRule;
            } else {
                FacesUtils.addErrorMessage(MSG_NO_REGISTRO_CONDUCTA);
                return BeanNavegacion.RUTA_ACTUAL;
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_ACTUALIZO_DATOS_USUARIO);
            return null;
        }
    }


    /**
     * @return
     */
    public String cerrarVacunacion() throws ModelException {
    
        aplicacionMedicamento= (AplicacionMedicamentoBean)FacesUtils.getManagedBean("aplicacionMedicamentoBean");
        if (usuario != null) {
            linkSurveypal();
            try {
                                                                                   
                this.serviceLocator.getClinicoService().closeVacunacionCervix(usuario, 
                                                                              consulta, 
                                                                              userName(),aplicacionMedicamento.getLstMedicamentoAtender());
                
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_CERRAR_CONSULTA);
            }
            if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
                pausarConsulta = 
                        (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                pausarConsulta.cerrarPausa(consulta.getCconnumero().longValue());
            }
            FacesUtils.resetManagedBean("ListaMedicamentosBean");
            FacesUtils.addInfoMessage(MSG_ADICION);
            return BeanNavegacion.RUTA_HOME;
        } else {
            FacesUtils.addErrorMessage(MSG_NO_ACTUALIZO_DATOS_USUARIO);
            return null;
        }
    }


    /**
     * @return
     */
    public String cerrarProcedimiento() throws ModelException {
        if (usuario != null) {
            Long numeroConsulta = null;
            if(consulta.getCcocservic().getCsvntiphis().equals(IConstantes.CIRUGIA_PROCEDIMIENTO_CONSULTORIO_IVE)){
                guardarSeguimientoIVE();
                
            }
            if (conducta != null && conducta.esValido()) {
                if (conducta != null && conducta.getConducta() != null && 
                    conducta.getConducta().getId() != null && 
                    conducta.getConducta().getId().getHcnlconsulta() != null) {
                    numeroConsulta = 
                            conducta.getConducta().getId().getHcnlconsulta();
                }
                linkSurveypal();
                try {
                    this.serviceLocator.getClinicoService().closeProcedimiento(consulta, 
                                                                               userName());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_CERRAR_CONSULTA);
                }
                
                if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
                    pausarConsulta = 
                            (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                    pausarConsulta.cerrarPausa(consulta.getCconnumero().longValue());
                }
                
                FacesUtils.resetManagedBean("listaMisUsuariosBean");
                FacesUtils.resetManagedBean("listaUsuariosBean");

                return BeanNavegacion.RUTA_LISTA;
            } else {
                FacesUtils.addErrorMessage(MSG_NO_REGISTRO_CONDUCTA);
                return BeanNavegacion.RUTA_ACTUAL;
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_ACTUALIZO_DATOS_USUARIO);
            return null;
        }
    }

    public String cerrarInforme() {
        if (consulta != null) {
            try {
                linkSurveypal();
                this.serviceLocator.getClinicoService().closeProcedimiento(consulta, 
                                                                           userName());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_CERRAR_CONSULTA);
            }
            if (IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
                pausarConsulta = 
                        (PausarConsultaBean)FacesUtils.getManagedBean("pausarConsultaBean");
                pausarConsulta.cerrarPausa(consulta.getCconnumero().longValue());
            }
            FacesUtils.resetManagedBean("listaMisUsuariosBean");
            FacesUtils.resetManagedBean("listaUsuariosBean");
            return BeanNavegacion.RUTA_LISTA;
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }


    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }

    /**
     * @param generoResumen
     */
    public void setGeneroResumen(boolean generoResumen) {
        this.generoResumen = generoResumen;
    }

    /**
     * @return
     */
    public boolean isGeneroResumen() {
        return generoResumen;
    }

    /**
     * @param esVacunacion
     */
    public void setEsVacunacion(boolean esVacunacion) {
        this.esVacunacion = esVacunacion;
    }

    /**
     * @return
     */
    public boolean isEsVacunacion() {
        return esVacunacion;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param navegacionRule
     */
    public void setNavegacionRule(String navegacionRule) {
        this.navegacionRule = navegacionRule;
    }

    /**
     * @return
     */
    public String getNavegacionRule() {
        return navegacionRule;
    }
    
    public String cerrarLaboratorio() {
        if (consulta != null && usuario != null) {
            try {
                linkSurveypal();
                this.serviceLocator.getClinicoService().closeEspermograma(usuario, 
                                                                          consulta, 
                                                                          userName());

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_CERRAR_CONSULTA);
            }

            FacesUtils.resetManagedBean("listaMisUsuariosBean");
            FacesUtils.resetManagedBean("listaUsuariosBean");
            return BeanNavegacion.RUTA_LISTA;
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }

    public void setRenderImprimirEspermograma(boolean renderImprimirEspermograma) {
        this.renderImprimirEspermograma = renderImprimirEspermograma;
    }

    public boolean isRenderImprimirEspermograma() {
        return renderImprimirEspermograma;
    }

    public void obtenerDatosReporte() {
        Chmotivocon motivoCons;
        motivoCons = null;
        Chantecolpo antecedentesColposc;
        antecedentesColposc = null;
        Chviolencia violencia;
        violencia = null;
        Chcolposcopia colposcopia;
        colposcopia = null;
        Chimprdiag impresionDiag;
        impresionDiag = null;
        Chconducta conducta;
        conducta = null;
        colposcopiaValidacion= false;
        resetReporteColposcopia();
        try {
            motivoCons = 
                    this.serviceLocator.getClinicoService().getMotivoConsulta(new Long(consulta.getCconnumero()));
            antecedentesColposc = 
                    this.serviceLocator.getClinicoService().getAntecedentesColposcopia(new Long(consulta.getCconnumero()));
            violencia = 
                    this.serviceLocator.getClinicoService().getEncuestaViolencia(new Long(consulta.getCconnumero()));
            colposcopia = 
                    this.serviceLocator.getClinicoService().getColposcopia(new Long(consulta.getCconnumero()));
            impresionDiag = 
                    this.serviceLocator.getClinicoService().getImresionDiagnostica(new Long(consulta.getCconnumero()), 
                                                                                   1);
            conducta = 
                    this.serviceLocator.getClinicoService().getConducta(new Long(consulta.getCconnumero()));
                         

            if (usuario != null) {
                if (usuario.getHusdfechanacim() != null) {
                    FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                    if (FECHA_NACIMIENTO != null) {
                        int edad = calcularEdad(FECHA_NACIMIENTO, new Date());
                        EDAD = new Long(edad);
                    }
                }
                if (colposcopia != null && colposcopia.getHcldfecregistr() != null) {
                    FECHA = colposcopia.getHcldfecregistr();
                }
                if (consulta.getCconnumero() != null) {
                    NHISTCLINICA = consulta.getCconnumero().toString();
                }
                if (consulta.getCconclinic() != null) {
                    try {
                        Cpclinica clinica = 
                                this.serviceLocator.getClinicoService().getClinica(consulta.getCconclinic());
                                CLINICA =  clinica.getCclcnombre();
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                   
                }
                if (usuario.getHuscprimernomb() != null) {
                    NOMBRES = usuario.getHuscprimernomb() + " ";
                }
                if (usuario.getHuscsegundnomb() != null && 
                    !usuario.getHuscsegundnomb().equals("_")) {
                    NOMBRES = NOMBRES + usuario.getHuscsegundnomb() + " ";
                }
                if (usuario.getHuscprimerapel() != null) {
                    PRIMERAPE = usuario.getHuscprimerapel();
                }
                if (usuario.getHuscsegundapel() != null && 
                    !usuario.getHuscsegundapel().equals("_")) {
                    SEGUNDOAPE = usuario.getHuscsegundapel();
                }
                if (usuario.getHusanumeiden() != null) {
                    NUMEROID = usuario.getHusanumeiden();
                }

                if (usuario.getHuscnombralter() != null) {
                    NOMBRELLAMAR = usuario.getHuscnombralter();
                }
                if (usuario.getHuscidengene() != null) {
                    if (usuario.getHuscidengene().equals("F")) {
                        IDGENERO = "FEMENINO";
                    } else if (usuario.getHuscidengene().equals("M")) {
                        IDGENERO = "MASCULINO";
                    } else if (usuario.getHuscidengene().equals("HT")) {
                        IDGENERO = "HOMBRE TRANS";
                    } else if (usuario.getHuscidengene().equals("MT")) {
                        IDGENERO = "MUJER TRANS";
                    } else if (usuario.getHuscidengene().equals("NF")) {
                        IDGENERO = "NEUTRO FLUIDO";
                    } else if (usuario.getHuscidengene().equals("I")) {
                        IDGENERO = "INDETERMINADO";
                    }
                }
                if (usuario.getHuscdireccion() != null) {
                    DIRECCION = usuario.getHuscdireccion();
                }
                if (usuario.getHusctelefono() != null) {
                    TELEFONO = usuario.getHusctelefono();
                }
                if (usuario.getHusnciudad() != null) {
                    try {
                        Cpmunidane muncipio = 
                                this.serviceLocator.getClinicoService().getMunicipio(usuario.getHusnciudad(),usuario.getHusndepartamen());
                                CIUDAD =muncipio.getCmdcnommun();
                            } catch (ModelException e) {
                                e.printStackTrace();
                            }
                   
                }
                if (usuario.getHusezonareside() != null) {
                    if (usuario.getHusezonareside().equals('U')) {
                        URBANA = "X";
                        RURAL = "-";
                    } else {
                        URBANA = "-";
                        RURAL = "X";
                    }
                }
                if (usuario.getHuseestadcivil() != null) {
                    if (usuario.getHuseestadcivil().equals("C")) {
                        ESTADOCIVIL = "CASADO";
                    } else if (usuario.getHuseestadcivil().equals("D")) {
                        ESTADOCIVIL = "DIVORCIADO";
                    } else if (usuario.getHuseestadcivil().equals("S")) {
                        ESTADOCIVIL = "SOLTERO";
                    } else if (usuario.getHuseestadcivil().equals("V")) {
                        ESTADOCIVIL = "VIUDO";
                    } else if (usuario.getHuseestadcivil().equals("U")) {
                        ESTADOCIVIL = "UNION LIBRE";
                    }

                }
                if (usuario.getHusnocupacion() != null) {
                    try {
                        Cpocupacio ocupacion = 
                            this.serviceLocator.getClinicoService().getOcupacionPorCodigo(usuario.getHusnocupacion());
                        OCUPACION = 
                                usuario.getHusnocupacion() + " - " + ocupacion.getCoccdescri();
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                }
                if(colposcopia!=null){
                    try {
                       Cpprofesio profesionalAct =
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(colposcopia.getHclcoperador(),
                                                                                        this.getClinica().getCclncodigo());
                        if(profesionalAct !=null){
                            NOMBRE_PROFESIONAL ="Nombre: "+ profesionalAct.getCpfcnombre();
                            REG_PROFESIONAL = "R.P.: "+profesionalAct.getCpfcregmedic();
                            IDEN_PROFESIONAL = profesionalAct.getCpfctipide()+": "+profesionalAct.getCpfacedula();
                        }
                    } catch (ModelException e) {
                       e.printStackTrace();
                    }
                }
                if (usuario.getHusetipoafilia() != null) {
                    if (usuario.getHusetipoafilia().equals("C")) {
                        TIPOAFILIACION = "CONTRIBUTIVO";
                    } else if (usuario.getHusetipoafilia().equals("E")) {
                        TIPOAFILIACION = "ESPECIAL";
                    } else if (usuario.getHusetipoafilia().equals("S")) {
                        TIPOAFILIACION = "SUBSIDIADO";
                    } else if (usuario.getHusetipoafilia().equals("V")) {
                        TIPOAFILIACION = "VINCULADO";
                    } else if (usuario.getHusetipoafilia().equals("N")) {
                        TIPOAFILIACION = "NINGUNO";
                    }
                }
                if (usuario.getHuscentidadadm() != null) {
                    try {
                        Cpentidadadm entidad = 
                            this.serviceLocator.getClinicoService().getEntidadEpsxCodigo(usuario.getHuscentidadadm());
                        ASEGURADORA = usuario.getHuscentidadadm() +" - "+ entidad.getCeacnombre();
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    
                }
                if (usuario.getHuscnomacompana() != null) {
                    ACOMPANANTE = usuario.getHuscnomacompana();
                }
                if (usuario.getHusctelacompana() != null) {
                    TELEFONOCONTACTO = usuario.getHusctelacompana();
                }
                if (usuario.getHuscparresponsa() != null) {
                    PARENTESCO = usuario.getHuscparresponsa();
                }
                if (motivoCons != null && motivoCons.getHmctdescripcio() != null) {
                    MOTIVOCONSULTA = 
                             motivoCons.getHmctdescripcio();
                }
                /* ANTECEDENTES*/
                if (antecedentesColposc.getHacnnumgesta() != null) {
                    NGESTACIONES = 
                            new Long(antecedentesColposc.getHacnnumgesta());
                }
                if (antecedentesColposc.getHacnnumparto() != null) {
                    NPARTOS = 
                            new Long(antecedentesColposc.getHacnnumparto().toString());
                }
                if (antecedentesColposc.getHacnnumaborto() != null) {
                    NABORTOS = 
                            new Long(antecedentesColposc.getHacnnumaborto().toString());
                }
                if (antecedentesColposc.getHacnnumcesare() != null) {
                    NCESAREAS = 
                            new Long(antecedentesColposc.getHacnnumcesare().toString());
                }
                if (antecedentesColposc.getHacnedadrelac() != null) {
                    RELACIONSEXUAL = 
                            antecedentesColposc.getHacnedadrelac().toString();
                }
                if (antecedentesColposc.getHacncompasexua() != null) {
                    NCOMPANEROS = 
                            new Long(antecedentesColposc.getHacncompasexua().toString());
                }
                if (antecedentesColposc.getHacnnumvivo() != null) {
                    HIJOSV = 
                            new Long(antecedentesColposc.getHacnnumvivo().toString());
                }
                if (antecedentesColposc.getHacnectopico() != null) {
                    HIJOSE = 
                            new Long(antecedentesColposc.getHacnectopico().toString());
                }
                if (antecedentesColposc.getHacnmortina() != null) {
                    HIJOSM = 
                            new Long(antecedentesColposc.getHacnmortina().toString());
                }
                if (antecedentesColposc.getHacnmolas() != null) {
                    HIJOSMOLA = 
                            new Long(antecedentesColposc.getHacnmolas().toString());
                }
                if (antecedentesColposc.getHacdfup() != null) {
                    ULTIMOPARTO = antecedentesColposc.getHacdfup();
                }
                if (antecedentesColposc.getHaccmetodoplan() != null) {
                    try {
                  String servicio = this.serviceLocator.getClinicoService().getDescripcionMetodo(antecedentesColposc.getHaccmetodoplan());
                        METODOPLAN = antecedentesColposc.getHaccmetodoplan().toString() +" - "+servicio;
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    
                }
                if (antecedentesColposc.getHacefuma() != null) {
                    FUMA = antecedentesColposc.getHacefuma().toString();
                }
                if (antecedentesColposc.getHacediabetes() != null) {
                    DIABETES = 
                            antecedentesColposc.getHacediabetes().toString();
                }
                if (antecedentesColposc.getHacevih() != null) {
                    VIH = antecedentesColposc.getHacevih().toString();
                }
                if (antecedentesColposc.getHaceets() != null) {
                    ETS = antecedentesColposc.getHaceets().toString();
                }
                if (antecedentesColposc.getHacdfur() != null) {
                    FECHAULTREGLA = antecedentesColposc.getHacdfur();
                }
                if (antecedentesColposc.getHaccultcitolo() != null) {
                    if (antecedentesColposc.getHaccultcitolo().equals("NO")) {

                        CITNUNCA = "NO";

                    } else if (antecedentesColposc.getHaccultcitolo().equals("MU")) {

                        CITMASUNAVEZ = "MU";

                    } else if (antecedentesColposc.getHaccultcitolo().equals("MA")) {

                        CITMENOSANO = "MA";

                    } else {
                        CITNORECUER = "NR";
                    }

                }
                if (antecedentesColposc.getHaccresulcitol() != null) {
                    RESULTADOCIT = 
                            antecedentesColposc.getHaccresulcitol().toString();
                }
                if (antecedentesColposc.getHacetipciclo() != null) {
                    if (antecedentesColposc.getHacetipciclo().equals("R")) {
                        TIPOCICLOR = 
                                antecedentesColposc.getHacetipciclo().toString();
                    } else if (antecedentesColposc.getHacetipciclo().equals("I")) {
                        TIPOCICLOI = 
                                antecedentesColposc.getHacnnumgesta().toString();
                    } else if (antecedentesColposc.getHacetipciclo().equals("N")) {
                        TIPOCICLONM = 
                                antecedentesColposc.getHacnnumgesta().toString();
                    } else if (antecedentesColposc.getHacetipciclo().equals("A")) {
                        TIPOCICLOA = 
                                antecedentesColposc.getHacnnumgesta().toString();
                    }
                }
                if (antecedentesColposc.getHacnfreciclo() != null) {
                    FRECICLO = 
                            new Long(antecedentesColposc.getHacnfreciclo().toString());
                }
                if (antecedentesColposc.getHacnmenarquia() != null) {
                    EDADMENARQUIA = 
                            new Long(antecedentesColposc.getHacnmenarquia().toString());
                }
                if (antecedentesColposc.getHacevacunvph() != null) {
                    VACUNAVPH = 
                            antecedentesColposc.getHacevacunvph().toString();
                }
                if (antecedentesColposc.getHacnnumervph() != null) {
                    DOSISVACUNAVPH = 
                            new Long(antecedentesColposc.getHacnnumervph().toString());
                }
                if (antecedentesColposc.getHacetipifvph() != null) {
                    TIPIFIVPH = 
                            antecedentesColposc.getHacetipifvph().toString();
                }
                if (antecedentesColposc.getHaccantecprevi() != null) {
                    if (antecedentesColposc.getHaccantecprevi().equals("S")) {
                        ANTECEDENTEPROC = "SI";
                    } else if (antecedentesColposc.getHaccantecprevi().equals("N")) {
                        ANTECEDENTEPROC = "NO";
                    } else {
                        ANTECEDENTEPROC = antecedentesColposc.getHaccantecprevi().toString();
                    }
                } else{
                    ANTECEDENTEPROC = "-----------------------------";
                }
                if (antecedentesColposc.getHaccresulproce() != null) {
                    RESULTADOPROC = 
                            antecedentesColposc.getHaccresulproce().toString();
                    } else{
                        RESULTADOPROC = "-----------------------------";
                    }
                if (violencia.getHviesufreviol() != null) {
                    VIOLENTOMTRO = violencia.getHviesufreviol();
                }
                if ( null != violencia.getHvieviofisica()) {
                    if (violencia.getHvieviofisica().equals("S")) {
                        FISICA = "SI";
                    } else if (violencia.getHvieviofisica().equals("N")) {
                        FISICA = "NO";
                    }
                }else{
                    FISICA = "------";
                }
                
                if (null != violencia.getHvieviocoerci()) {
                    if (violencia.getHvieviocoerci().equals("S")) {
                        REPRODUCTIVA = "SI";
                    } else if (violencia.getHvieviocoerci().equals("N")) {
                        REPRODUCTIVA = "NO";
                    }
                } else {
                    REPRODUCTIVA =  "------";
                }
            }

            if (null==violencia.getHvieviopsicol()) {
                PSICOLOGICA = "------";
            } else if (violencia.getHvieviopsicol() != null) {
                if (violencia.getHvieviopsicol().equals("S")) {
                    PSICOLOGICA = "SI";
                } else if (violencia.getHvieviopsicol().equals("N")) {
                    PSICOLOGICA = "NO";


                }
            }
                
                if (null!= violencia.getHvieviosexual()) {
                    if (violencia.getHvieviosexual().equals("S")) {
                        SEXUAL = "SI";
                    } else if (violencia.getHvieviosexual().equals("N")) {
                        SEXUAL = "NO";
                    }
                    } else {
                    SEXUAL =  "------";
                    }
                
                if (violencia != null && violencia.getHvievioeconom()!= null ) {
                    if (violencia.getHvievioeconom().equals("S")) {
                        ECONOMICA = "SI";
                    } else if (violencia.getHvievioeconom().equals("N")) {
                        ECONOMICA = "NO";

                    }
                }else {
                    ECONOMICA = "------";
                    }
                
                if (violencia != null && violencia.getHvicfisiquien()!= null) {
                    QUIENFISICA = violencia.getHvicfisiquien();
                }else {
                    QUIENFISICA = "------";
                }
                
            
            if (violencia!= null && violencia.getHviccoerquien()!= null) {
            QUIENREPRODUCTIVA =  violencia.getHviccoerquien();
            }else {
            QUIENREPRODUCTIVA = "------";
            }
                
            if (violencia!= null && violencia.getHvicpsicquien()!= null) {
            QUIENPSICOLOGICA =  violencia.getHvicpsicquien();
            }else {
            QUIENPSICOLOGICA = "------";
            }
            
            if (violencia!= null && violencia.getHvicsexuquien()!= null) {
            QUIENSEXUAL =  violencia.getHvicsexuquien();
            }else {
            QUIENSEXUAL = "------";
            }
                
                
               
                
            if (violencia!= null && violencia.getHviceconquien()!= null) {
                QUIENECONOMICA =  violencia.getHviceconquien();
            }else {
                QUIENECONOMICA = "------";
                }
                
                if (violencia.getHvicamenpare() != null) {
                    if (violencia.getHvicamenpare().equals("S")) {
                        RIESGOABANDONO = "SI";
                    } else if (violencia.getHvicamenpare().equals("N")) {
                        RIESGOABANDONO = "NO";

                    }
                }else {
                    RIESGOABANDONO =  "------";
                    }
                
                if (violencia.getHvicagrefami() != null) {
                    if (violencia.getHvicagrefami().equals("S")) {
                        AGRESORFAMILIA = "SI";
                    } else if (violencia.getHvicagrefami().equals("N")) {
                        AGRESORFAMILIA = "NO";

                    } 
                }else {
                    AGRESORFAMILIA =  "------";
                    }
                  
                if (violencia.getHvicintedano() != null) {
                    if (violencia.getHvicintedano().equals("S")) {
                        DANOMISMO = "SI";
                    } else if (violencia.getHvicintedano().equals("N")) {
                        DANOMISMO = "NO";

                    } 
                }else {
                    DANOMISMO =  "------";
                    }
                
                if (violencia.getHvicagrecasa() != null) {
                    if (violencia.getHvicagrecasa().equals("S")) {
                        AGRESORCASA = "SI";
                    } else if (violencia.getHvicagrecasa().equals("N")) {
                        AGRESORCASA = "NO";

                    }
                }else {
                    AGRESORCASA =  "------";
                    }
                   
                if (violencia.getHvicfamicono() != null) {
                    if (violencia.getHvicfamicono().equals("S")) {
                        FAMILIAENTERADA = "SI";
                    } else if (violencia.getHvicfamicono().equals("N")) {
                        FAMILIAENTERADA = "NO";

                    }
                }else {
                    FAMILIAENTERADA =  "------";
                    }
                
                if (violencia.getHvictienreex() != null) {
                    if (violencia.getHvictienreex().equals("S")) {
                        REMISIONEXT = "SI";
                    } else if (violencia.getHvictienreex().equals("N")) {
                        REMISIONEXT = "NO";

                    } 
                }else {
                    REMISIONEXT =  "------";
                    }
                
                if (violencia.getHvictienrein() != null) {
                    if (violencia.getHvictienrein().equals("S")) {
                        REMISIONINT = "SI";
                    } else if (violencia.getHvictienrein().equals("N")) {
                        REMISIONINT = "NO";

                    } 
                }else {
                    REMISIONINT =  "------";
                    }
                
                if (violencia.getHvicremiinte() != null) {
                    REMISIONLUGARINTERNA = "Interna: " + serviceLocator.getClinicoService().getDescripcionRemisionViolencia(violencia.getHvicremiinte());
                }else{
                    REMISIONLUGARINTERNA = null; 
                }
                    
            if (violencia.getHvicremiexte() != null) {
                REMISIONLUGAREXTERNA= "Externa: " +  serviceLocator.getClinicoService().getDescripcionRemisionViolencia(violencia.getHvicremiexte());
            }else{
                REMISIONLUGAREXTERNA = null;
            }
            
            if(REMISIONLUGARINTERNA != null || REMISIONLUGAREXTERNA != null ){
             if(REMISIONLUGARINTERNA != null){
                 REMISIONLUGAR = formatearCampo(REMISIONLUGARINTERNA); 
             }
                if(REMISIONLUGAREXTERNA != null){
                    REMISIONLUGAR = formatearCampo(REMISIONLUGAR) + " "+  formatearCampo(REMISIONLUGAREXTERNA); 
                }

            }
            
                if (colposcopia.getHclcevalugener() != null) {
                    EVALUACIONGENERAL = colposcopia.getHclcevalugener();
                }

                if (colposcopia.getHclcinadeinfla() != null) {
                    INFLAMACION = colposcopia.getHclcinadeinfla();
                }
                if (colposcopia.getHclcinadesangr() != null) {
                    SANGRADO = colposcopia.getHclcinadesangr();
                }
                if (colposcopia.getHclcinadecicat() != null) {
                    CICATRIZ = colposcopia.getHclcinadecicat();
                }
                if (colposcopia.getHclcinadeotro() != null) {
                    OTROS = colposcopia.getHclcinadeotro();
                }
                if (colposcopia.getHclcinadecual() != null) {
                    OTROSCUAL = colposcopia.getHclcinadecual();
                }
                if (colposcopia.getHclcvisioescam() != null) {
                    ESCAMOCULUMNA = colposcopia.getHclcvisioescam();
                }
                if (colposcopia.getHclczonatrans() != null) {
                    TRNASFORMACION = colposcopia.getHclczonatrans();
                }
                if (colposcopia.getHclchallamadur() != null) {
                    HALLAZGOMADU = colposcopia.getHclchallamadur();
                }
                if (colposcopia.getHclchallaquiste() != null) {
                    HALLAZGOQUISTE = colposcopia.getHclchallaquiste();
                }
                if (colposcopia.getHclchallaectop() != null) {
                    HALLAZGOESCTOPIA = colposcopia.getHclchallaectop();
                }
                if (colposcopia.getHclchallaatrof() != null) {
                    HALLAZGOATROF = colposcopia.getHclchallaatrof();
                }
                if (colposcopia.getHclchallagland() != null) {
                    HALLAZGOABERGLAND = colposcopia.getHclchallagland();
                }
                if (colposcopia.getHclchalladecid() != null) {
                    HALLAZGODECIEMBARAZO = colposcopia.getHclchalladecid();
                }
                if (colposcopia.getHclchallazona() != null) {
                    HALLAZVAZONA = colposcopia.getHclchallazona();
                }
                if (colposcopia.getHclchallaleuco() != null) {
                    HALLAZVALEUCO = colposcopia.getHclchallaleuco();
                }
                if (colposcopia.getHclchallacondi() != null) {
                    HALLAZVACONDILOMA = colposcopia.getHclchallacondi();
                }
                if (colposcopia.getHclchallainfla() != null) {
                    HALLAZVAINFLAM = colposcopia.getHclchallainfla();
                }
                if (colposcopia.getHclchallaesten() != null) {
                    HALLAZVAESTENOSIS = colposcopia.getHclchallaesten();
                }
                if (colposcopia.getHclchallaconge() != null) {
                    HALLAZVAANOCONG = colposcopia.getHclchallaconge();
                }
                if (colposcopia.getHclchallapost() != null) {
                    HALLAZVAANOTRATA = colposcopia.getHclchallapost();
                }
                if (colposcopia.getHclchallapolip() != null) {
                    HALLAZVAPOLIPO = colposcopia.getHclchallapolip();
                }
                if (colposcopia.getHclchallaendom() != null) {
                    HALLAZVAENDOMETRI = colposcopia.getHclchallaendom();
                }
                if (colposcopia.getHclchallaotro() != null) {
                    HALLAZVAOTRO = colposcopia.getHclchallaotro();
                }
                if (colposcopia.getHclchallacual() != null) {
                    HALLAZVAOTROCUAL = colposcopia.getHclchallacual();
                }
                if (colposcopia.getHclcgradohalla() != null) {
                    GRADOHALLA = colposcopia.getHclcgradohalla();
                }
                if (colposcopia.getHclcgrad1epite() != null) {
                    HCLCGRAD1EPITELIO = colposcopia.getHclcgrad1epite();
                }
                if (colposcopia.getHclcgrad1borde() != null) {
                    HCLCGRAD1BORDER = colposcopia.getHclcgrad1borde();
                }
                if (colposcopia.getHclcgrad1mosai() != null) {
                    HCLCGRAD1MOSAICOF = colposcopia.getHclcgrad1mosai();
                }
                if (colposcopia.getHclcgrad1punte() != null) {
                    HCLCGRAD1PUNTEADOF = colposcopia.getHclcgrad1punte();
                }
                if (colposcopia.getHclcgrad2mosai() != null) {
                    HCLCGRAD2MOSAICOG = colposcopia.getHclcgrad2mosai();
                }
                if (colposcopia.getHclcgrad2signo() != null) {
                    HCLCGRAD2SIGBINT = colposcopia.getHclcgrad2signo();
                }
                if (colposcopia.getHclcgrad2crest() != null) {
                    HCLCGRAD2SIGCRES = colposcopia.getHclcgrad2crest();
                }
                if (colposcopia.getHclcgrad2puntil() != null) {
                    HCLCGRAD2PUNTIG = colposcopia.getHclcgrad2puntil();
                }
                if (colposcopia.getHclcgrad2borde() != null) {
                    HCLCGRAD2BORDEDEL = colposcopia.getHclcgrad2borde();
                }
                if (colposcopia.getHclcgrad2aceta() != null) {
                    HCLCGRAD2APAEPITELIO = colposcopia.getHclcgrad2aceta();
                }
                if (colposcopia.getHclcgrad2orifi() != null) {
                    HCLCGRAD2ORIFICIOGLA = colposcopia.getHclcgrad2orifi();
                }
                if (colposcopia.getHclcgrad3test() != null) {
                    HCLCGRAD3TEST = colposcopia.getHclcgrad3test();
                }
                if (colposcopia.getHclcubicadentr() != null) {
                    UBICACIONLDENTRO = 
                            colposcopia.getHclcubicadentr().toString();
                            
                          if(colposcopia.getHclcubicadentr2()!= null){
                              UBICACIONLDENTRO = UBICACIONLDENTRO + "-" + colposcopia.getHclcubicadentr2();
                              
                          }
                            
                }
                if (colposcopia.getHclcubicafuera() != null) {
                    UBICACIONLFUERA = 
                            colposcopia.getHclcubicafuera().toString();
                    if(colposcopia.getHclcubicafuera2()!= null){
                        UBICACIONLFUERA = UBICACIONLFUERA + "-" + colposcopia.getHclcubicafuera2();
                        
                    }
                            
                }
                if (colposcopia.getHclcubicacuadr() != null) {
                    UBICACIONLNCUADRAN = 
                            colposcopia.getHclcubicacuadr().toString();
                }
                if (colposcopia.getHclcubicaporce() != null) {
                    UBICACIONLPORCEN = 
                            colposcopia.getHclcubicaporce().toString();
                }
                if (colposcopia.getHclcvasosatipi() != null) {
                    SIVASOSATI = colposcopia.getHclcvasosatipi();
                }
                if (colposcopia.getHclcvasosdelga() != null) {
                    SIVASOSDEL = colposcopia.getHclcvasosdelga();
                }
                if (colposcopia.getHclcsupirreg() != null) {
                    SISUPIRRE = colposcopia.getHclcsupirreg();
                }
                if (colposcopia.getHclclesioexofi() != null) {
                    SILESIOEX = colposcopia.getHclclesioexofi();
                }
                if (colposcopia.getHclcnecrosis() != null) {
                    SINECROSIS = colposcopia.getHclcnecrosis();
                }
                if (colposcopia.getHclcnulcera() != null) {
                    SIULCERA = colposcopia.getHclcnulcera();
                }
                if (colposcopia.getHclctumornudol() != null) {
                    SITUMOR = colposcopia.getHclctumornudol();
                }
                if (colposcopia.getHclcsospecual() != null) {
                    SIOTROS = colposcopia.getHclcsospeotro();
                }
                if (impresionDiag.getHidcimprenorma() != null) {
                    IMPDIAGN = impresionDiag.getHidcimprenorma();
                }
                if (impresionDiag.getHidcimpreinfla() != null) {
                    IMPDIAGINF = impresionDiag.getHidcimpreinfla();
                }
                if (impresionDiag.getHidcimpreatrof() != null) {
                    IMPDIAGATR = impresionDiag.getHidcimpreatrof();
                }
                if (impresionDiag.getHidcimprecarci() != null) {
                    IMPDIAGCARINV = impresionDiag.getHidcimprecarci();
                }
                if (impresionDiag.getHidcimpresuges() != null) {
                    IMPDIAGSVPH = impresionDiag.getHidcimpresuges();
                }
                if (impresionDiag.getHidcimpreleyba() != null) {
                    IMPDIAGBGRADO = impresionDiag.getHidcimpreleyba();
                }
                if (impresionDiag.getHidcimpreleyal() != null) {
                    IMPDIAGAGRADO = impresionDiag.getHidcimpreleyal();
                }
                if (impresionDiag.getHidcimpreotro() != null) {
                    IMPDIAGOTRO = impresionDiag.getHidcimpreotro();
                }
                if (impresionDiag.getHidtrecomen() != null) {
                    OBSERVACIONESDIAG = impresionDiag.getHidtrecomen();
                }
                if (conducta.getHcncplanmanejo() != null) {
                    PLANMANEJO = conducta.getHcncplanmanejo();
                }
                if (conducta.getHcncobservacio() != null) {
                    RECOMENDACIONES = conducta.getHcncobservacio();
                }
                if (colposcopia.getHclcgrad3erosi() != null) {
                    HALLAZNOESPEROSION  = colposcopia.getHclcgrad3erosi();
                }
                if (colposcopia.getHclcgrad2epacde() != null) {
                   HCLCGRAD2EPACEDEN = colposcopia.getHclcgrad2epacde();
                }
                if (antecedentesColposc.getHaccfuma()!= null) {
                    HACCFUMA =  antecedentesColposc.getHaccfuma();
                }
                if (antecedentesColposc.getHaccdiabetes() != null) {
                    HACCDIABETES = antecedentesColposc.getHaccdiabetes();
                }
                if (antecedentesColposc.getHaccvih() != null) {
                    HACCVIH  = antecedentesColposc.getHaccvih();
                }
                if (antecedentesColposc.getHaccets() != null) {
                   HACCETS = antecedentesColposc.getHaccets();
                }
                if (colposcopia.getHclctomobiop() != null) {
                   HCLCTOMOBIOP = colposcopia.getHclctomobiop();
                }
                if (colposcopia.getHclcobservacio() != null) {
                   HCLCOBSERVACIO = colposcopia.getHclcobservacio();
                }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void imprimirColposcopia() {
        this.index = -1;
        try {
            obtenerDatosReporte();
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteColposcopia.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);
            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_COLPOSCOPIA);
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_COLPOSCOPIA", url_super_horizontal);

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                byte[] bytes = 
                    JasperRunManager.runReportToPdf(report, parameters, 
                                                    (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "FormatoColposcopia" + ".pdf", 
                                                false);
                this.generoReporte = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }

        FacesUtils.addInfoMessage("Se creo exitosamente , realizar aca la implementacion ");
    }

    public byte[] generarColposcopia() {
        this.index = -1;
        try {
            Cnconsclin consultaAux = 
                    this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
            if (consultaAux != null && 
                (consultaAux.getCcocservic().getCsvntiphis().toString().equals(IConstantes.HISTORIA_PROCEDIMIENTO_COLPOSCOPIA.toString()))) {
                consulta = consultaAux;
                obtenerDatosReporte();

                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteColposcopia.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_COLPOSCOPIA);
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_COLPOSCOPIA", url_super_horizontal);

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    byte[] bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);
                    if (bytes != null) {

                        return bytes;
                    }
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }
        return null;
    }
    
    public void linkSurveypal() throws ModelException {

        Cpclinica clin= null;
        Cpentidadadm entidad=null;
        Cpmunidane muni=null;    
        Cpcontrato contr= null;
        clin= new Cpclinica();
        entidad= new Cpentidadadm();
        muni= new Cpmunidane();
        contr= new Cpcontrato();

        clin = this.serviceLocator.getClinicoService().getClinica(consulta.getCconclinic());
        entidad = this.serviceLocator.getClinicoService().getEntidadEpsxCodigo(usuario.getHuscentidadadm());
        muni= this.serviceLocator.getClinicoService().getMunicipio(usuario.getHusnciudad(),usuario.getHusndepartamen());
        contr= this.serviceLocator.getClinicoService().getContratoPornumero(consulta.getCconcontra());
       
        if (consulta != null && usuario != null) {
            String numConsulta = consulta.getCconnumero().toString();
            edad = usuario.getEdad().toString();

            if (usuario.getHusesexo() == null || usuario.getHusesexo().equals("")) {
                sexo = "SinDato";
            } else if (usuario.getHusesexo().equals("F")) {
                sexo = "Femenino";
            } else if (usuario.getHusesexo().equals("M")) {
                sexo = "Masculino";
            } else if (usuario.getHusesexo().equals("I")) {
                sexo = "Indeterminado";
            }

            if (usuario.getHuscidengene() == null || usuario.getHuscidengene().equals("")) {
                genero = "SinDato";
            } else if (usuario.getHuscidengene().equals("F")) {
                genero = "Femenino";
            } else if (usuario.getHuscidengene().equals("M")) {
                genero = "Masculino";
            } else if (usuario.getHuscidengene().equals("HT")) {
                genero = "HombreTrans";
            } else if (usuario.getHuscidengene().equals("MT")) {
                genero = "MujerTrans";
            } else if (usuario.getHuscidengene().equals("NF")) {
                genero = "NeutroFluido";
            } else if (usuario.getHuscidengene().equals("I")) {
                genero = "Indeterminado";
            }

            if (usuario.getHuscoriesexu() == null || usuario.getHuscoriesexu().equals("")) {
                orientacion = "Sin dato";
            } else if (usuario.getHuscoriesexu().equals("HO")) {
                orientacion = "Homosexual";
            } else if (usuario.getHuscoriesexu().equals("BI")) {
                orientacion = "Bisexual";
            } else if (usuario.getHuscoriesexu().equals("HE")) {
                orientacion = "Heterosexual";
            } else if (usuario.getHuscoriesexu().equals("PA")) {
                orientacion = "Pansexual";
            } else if (usuario.getHuscoriesexu().equals("AS")) {
                orientacion = "Asexual";
            }

            if (usuario.getHusnniveledu() == 3) {
                escolaridad = "BasicaPrimaria";
            } else if (usuario.getHusnniveledu() == 4) {
                escolaridad = "BasicaSecundaria(BachilleratoBasico)";
            }else if (usuario.getHusnniveledu() == 13) {
                escolaridad = "Doctorado";
            } else if (usuario.getHusnniveledu() == 11) {
                escolaridad = "Especializacion";
            } else if (usuario.getHusnniveledu() == 12) {
                escolaridad = "Maestria";
            } else if (usuario.getHusnniveledu() == 5) {
                escolaridad = "MediaAcademicaoClasica(BachilleratoBasico)";
            }else if (usuario.getHusnniveledu() == 6) {
                escolaridad = "MediaTecnica(BachilleratoTecnico)";
            }else if (usuario.getHusnniveledu() == 1) {
                escolaridad = "NoDefinido";
            } else if (usuario.getHusnniveledu() == 7) {
                escolaridad = "Normalista";
            } else if (usuario.getHusnniveledu() == 2) {
                escolaridad = "Preescolar";
            } else if (usuario.getHusnniveledu() == 10) {
                escolaridad = "Profesional";
            } else if (usuario.getHusnniveledu() == 8) {
                escolaridad = "TecnicaProfesional";
            } else if (usuario.getHusnniveledu() == 9) {
                escolaridad = "Tecnologica";
            } else {
                escolaridad = "SinDato";
            }

            
            if (clin != null) {
                clinica = clin.getCclcnombre();
            }
            
            servicio = consulta.getCcocservic().getCsvcnombre();
            
            if(contr != null){
                contrato = contr.getCcncdescri();
                numeroContrato = contr.getId().getCcnnnumero().toString();
            } else {
                contrato="SinDato";
                numeroContrato = "SinDato";
            }
           
            if (entidad != null) {
                eps = entidad.getCeacnombre();
            }

            if (usuario.getHuscetnia().equals("01")) {
                etnia = "IndNgena";
            } else if (usuario.getHuscetnia().equals("05")) {
                etnia =  "Negro(a)";
            } else if (usuario.getHuscetnia().equals("06")) {
                etnia =  "Afrocolombiano(a)";
            } else if (usuario.getHuscetnia().equals("99")) {
                etnia = "Ningunodelosanteriores";
            } else if (usuario.getHuscetnia().equals("04")) {
                etnia = "PalanquerodeSanBasilio";
            } else if (usuario.getHuscetnia().equals("03")) {
                etnia = "Raizal(archipiNlagodeSanAndresyProvidencia)";
            } else if (usuario.getHuscetnia().equals("02")) {
                etnia = "ROM(gitano)";
            } else {
                etnia = "SinDato";
            }
            
            
            if(usuario.getHusetipoafilia().equals("C")){ 
               convenio="Contributivo";
            } else if(usuario.getHusetipoafilia().equals("S")){ 
               convenio="Subsidiado";
            } else if(usuario.getHusetipoafilia().equals("E")){ 
               convenio="Especial";
            }else if(usuario.getHusetipoafilia().equals("X")){ 
               convenio="Ninguno";
            }else if(usuario.getHusetipoafilia().equals("R")){ 
               convenio="SubsidioParcial";
            }else if(usuario.getHusetipoafilia().equals("V")){ 
               convenio="vinculado";
            }else{
               convenio= "SinDato";
            }
                  
             if(null !=usuario.getHusedicapadad()){
                discapacidad= usuario.getHusedicapadad();
             }else{
                discapacidad= "SinDato";
             }
             
             gestante="SinDato";
             
             if(muni!=null){
                procedencia= muni.getCmdcnommun();
             }else{
                procedencia="SinDato";
             }
             
             if (usuario.getHusanumeiden() != null) {
                 numeroIden = usuario.getHusanumeiden().toString();
             }else{
                numeroIden = "SinDato";
             }
             if (usuario.getHusccelular() != null) {
                 numeroContacto = usuario.getHusccelular().toString();
             }else{
                 numeroContacto = "SinDato";
             }
            
             
             String link;
             
             link= "href=\"https://my.surveypal.com/app/form/ext?sid=1670187399&sh=phffMtaq0JGLyu3_KY7hdH_pK3AQHY0CzqJgiW7F5zOaIWgHuaEbQSbvHrcQyhf2&showP&externalId=&meta=[{key:Edad,value:"
             +edad+"},{key:Sexo,value:"+sexo+"},{key:Genero,value:"+genero+"},{key:Orientacion,value:"+orientacion+"},{key:Escolaridad,value:"+escolaridad
             +"},{key:Clinica,value:"+clinica+"},{key:Servicio,value:"+servicio+"},{key:Contrato,value:"+contrato+"},{key:EPS,value:"+eps+"},{key:Etnia,value:"+etnia
             +"},{key:Convenio,value:"+convenio+"},{key:Discapacidad,value:"+discapacidad+"},{key:Gestante,value:"+gestante+"},{key:Procedencia,value:"+procedencia
             +"},{key:NumeroIdentificacion,value:"+numeroIden+"},{key:NumeroContacto,value:"+numeroContacto+"},{key:NumeroConsulta,value:"+numConsulta
             +"},{key:NumeroContrato,value:"+numeroContrato+"}]&source=external&name=Encuesta%20%23\"";
             surveypalLink= link.replaceAll(" ","");
             System.out.println(surveypalLink);
            
           
            }
    }

    public boolean next() throws JRException {
        index++;
        return (index < 1);
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("FECHA")) {
            value = FECHA;
        }
        if (fieldName.equals("NHISTCLINICA")) {
            value = NHISTCLINICA;
        }
        if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        }
        if (fieldName.equals("PRIMERAPE")) {
            value = PRIMERAPE;
        }
        if (fieldName.equals("SEGUNDOAPE")) {
            value = SEGUNDOAPE;
        }
        if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        }
        if (fieldName.equals("NUMEROID")) {
            value = NUMEROID;
        }
        if (fieldName.equals("NOMBRELLAMAR")) {
            value = NOMBRELLAMAR;
        }
        if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        }
        if (fieldName.equals("IDGENERO")) {
            value = IDGENERO;
        }
        if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        }
        if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        }
        if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        }
        if (fieldName.equals("RURAL")) {
            value = RURAL;
        }
        if (fieldName.equals("URBANA")) {
            value = URBANA;
        }
        if (fieldName.equals("ESTADOCIVIL")) {
            value = ESTADOCIVIL;
        }
        if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        }
        if (fieldName.equals("TIPOAFILIACION")) {
            value = TIPOAFILIACION;
        }
        if (fieldName.equals("ASEGURADORA")) {
            value = ASEGURADORA;
        }
        if (fieldName.equals("EDAD")) {
            value = EDAD;
        }
        if (fieldName.equals("ACOMPANANTE")) {
            value = ACOMPANANTE;
        }
        if (fieldName.equals("TELEFONOCONTACTO")) {
            value = TELEFONOCONTACTO;
        }
        if (fieldName.equals("PARENTESCO")) {
            value = PARENTESCO;
        }
        if (fieldName.equals("MOTIVOCONSULTA")) {
            value = MOTIVOCONSULTA;
        }
        if (fieldName.equals("NGESTACIONES")) {
            value = NGESTACIONES;
        }
        if (fieldName.equals("NPARTOS")) {
            value = NPARTOS;
        }
        if (fieldName.equals("NABORTOS")) {
            value = NABORTOS;
        }
        if (fieldName.equals("NCESAREAS")) {
            value = NCESAREAS;
        }
        if (fieldName.equals("RELACIONSEXUAL")) {
            value = RELACIONSEXUAL;
        }
        if (fieldName.equals("NCOMPANEROS")) {
            value = NCOMPANEROS;
        }
        if (fieldName.equals("HIJOSV")) {
            value = HIJOSV;
        }
        if (fieldName.equals("HIJOSE")) {
            value = HIJOSE;
        }
        if (fieldName.equals("HIJOSM")) {
            value = HIJOSM;
        }
        if (fieldName.equals("HIJOSMOLA")) {
            value = HIJOSMOLA;
        }
        if (fieldName.equals("ULTIMOPARTO")) {
            value = ULTIMOPARTO;
        }
        if (fieldName.equals("METODOPLAN")) {
            value = METODOPLAN;
        }
        if (fieldName.equals("FUMA")) {
            value = FUMA;
        }
        if (fieldName.equals("DIABETES")) {
            value = DIABETES;
        }
        if (fieldName.equals("VIH")) {
            value = VIH;
        }
        if (fieldName.equals("ETS")) {
            value = ETS;
        }
        if (fieldName.equals("FECHAULTREGLA")) {
            value = FECHAULTREGLA;
        }
        if (fieldName.equals("CITNUNCA")) {
            value = CITNUNCA;
        }
        if (fieldName.equals("CITMASUNAVEZ")) {
            value = CITMASUNAVEZ;
        }
        if (fieldName.equals("CITMENOSANO")) {
            value = CITMENOSANO;
        }
        if (fieldName.equals("CITNORECUER")) {
            value = CITNORECUER;
        }
        if (fieldName.equals("RESULTADOCIT")) {
            value = RESULTADOCIT;
        }
        if (fieldName.equals("TIPOCICLOR")) {
            value = TIPOCICLOR;
        }
        if (fieldName.equals("TIPOCICLOI")) {
            value = TIPOCICLOI;
        }
        if (fieldName.equals("TIPOCICLONM")) {
            value = TIPOCICLONM;
        }
        if (fieldName.equals("TIPOCICLOA")) {
            value = TIPOCICLOA;
        }
        if (fieldName.equals("FRECICLO")) {
            value = FRECICLO;
        }
        if (fieldName.equals("EDADMENARQUIA")) {
            value = EDADMENARQUIA;
        }
        if (fieldName.equals("VACUNAVPH")) {
            value = VACUNAVPH;
        }
        if (fieldName.equals("DOSISVACUNAVPH")) {
            value = DOSISVACUNAVPH;
        }
        if (fieldName.equals("TIPIFIVPH")) {
            value = TIPIFIVPH;
        }
        if (fieldName.equals("ANTECEDENTEPROC")) {
            value = ANTECEDENTEPROC;
        }
        if (fieldName.equals("RESULTADOPROC")) {
            value = RESULTADOPROC;
        }
        if (fieldName.equals("VIOLENTOMTRO")) {
            value = VIOLENTOMTRO;
        }
        if (fieldName.equals("FISICA")) {
            value = FISICA;
        }
        if (fieldName.equals("REPRODUCTIVA")) {
            value = REPRODUCTIVA;
        }
        if (fieldName.equals("PSICOLOGICA")) {
            value = PSICOLOGICA;
        }
        if (fieldName.equals("SEXUAL")) {
            value = SEXUAL;
        }
        if (fieldName.equals("ECONOMICA")) {
            value = ECONOMICA;
        }
        if (fieldName.equals("QUIENFISICA")) {
            value = QUIENFISICA;
        }
        if (fieldName.equals("QUIENREPRODUCTIVA")) {
            value = QUIENREPRODUCTIVA;
        }
        if (fieldName.equals("QUIENPSICOLOGICA")) {
            value = QUIENPSICOLOGICA;
        }
        if (fieldName.equals("QUIENSEXUAL")) {
            value = QUIENSEXUAL;
        }
        if (fieldName.equals("QUIENECONOMICA")) {
            value = QUIENECONOMICA;
        }
        if (fieldName.equals("RIESGOABANDONO")) {
            value = RIESGOABANDONO;
        }
        if (fieldName.equals("AGRESORFAMILIA")) {
            value = AGRESORFAMILIA;
        }
        if (fieldName.equals("DANOMISMO")) {
            value = DANOMISMO;
        }
        if (fieldName.equals("AGRESORCASA")) {
            value = AGRESORCASA;
        }
        if (fieldName.equals("FAMILIAENTERADA")) {
            value = FAMILIAENTERADA;
        }
        if (fieldName.equals("REMISIONEXT")) {
            value = REMISIONEXT;
        }
        if (fieldName.equals("REMISIONINT")) {
            value = REMISIONINT;
        }
        if (fieldName.equals("REMISIONLUGAR")) {
            value = REMISIONLUGAR;
        }
        if (fieldName.equals("EVALUACIONGENERAL")) {
            value = EVALUACIONGENERAL;
        }
        if (fieldName.equals("INFLAMACION")) {
            value = INFLAMACION;
        }
        if (fieldName.equals("SANGRADO")) {
            value = SANGRADO;
        }
        if (fieldName.equals("CICATRIZ")) {
            value = CICATRIZ;
        }
        if (fieldName.equals("OTROS")) {
            value = OTROS;
        }
        if (fieldName.equals("OTROSCUAL")) {
            value = OTROSCUAL;
        }
        if (fieldName.equals("ESCAMOCULUMNA")) {
            value = ESCAMOCULUMNA;
        }
        if (fieldName.equals("TRNASFORMACION")) {
            value = TRNASFORMACION;
        }
        if (fieldName.equals("HALLAZGOMADU")) {
            value = HALLAZGOMADU;
        }
        if (fieldName.equals("HALLAZGOQUISTE")) {
            value = HALLAZGOQUISTE;
        }
        if (fieldName.equals("HALLAZGOESCTOPIA")) {
            value = HALLAZGOESCTOPIA;
        }
        if (fieldName.equals("HALLAZGOATROF")) {
            value = HALLAZGOATROF;
        }
        if (fieldName.equals("HALLAZGOABERGLAND")) {
            value = HALLAZGOABERGLAND;
        }
        if (fieldName.equals("HALLAZGODECIEMBARAZO")) {
            value = HALLAZGODECIEMBARAZO;
        }
        if (fieldName.equals("HALLAZVAZONA")) {
            value = HALLAZVAZONA;
        }
        if (fieldName.equals("HALLAZVALEUCO")) {
            value = HALLAZVALEUCO;
        }
        if (fieldName.equals("HALLAZVACONDILOMA")) {
            value = HALLAZVACONDILOMA;
        }
        if (fieldName.equals("HALLAZVAINFLAM")) {
            value = HALLAZVAINFLAM;
        }
        if (fieldName.equals("HALLAZVAESTENOSIS")) {
            value = HALLAZVAESTENOSIS;
        }
        if (fieldName.equals("HALLAZVAANOCONG")) {
            value = HALLAZVAANOCONG;
        }
        if (fieldName.equals("HALLAZVAANOTRATA")) {
            value = HALLAZVAANOTRATA;
        }
        if (fieldName.equals("HALLAZVAPOLIPO")) {
            value = HALLAZVAPOLIPO;
        }
        if (fieldName.equals("HALLAZVAENDOMETRI")) {
            value = HALLAZVAENDOMETRI;
        }
        if (fieldName.equals("HALLAZVAOTRO")) {
            value = HALLAZVAOTRO;
        }
        if (fieldName.equals("HALLAZVAOTROCUAL")) {
            value = HALLAZVAOTROCUAL;
        }
        if (fieldName.equals("GRADOHALLA")) {
            value = GRADOHALLA;
        }
        if (fieldName.equals("HCLCGRAD1EPITELIO")) {
            value = HCLCGRAD1EPITELIO;
        }
        if (fieldName.equals("HCLCGRAD1BORDER")) {
            value = HCLCGRAD1BORDER;
        }
        if (fieldName.equals("HCLCGRAD1MOSAICOF")) {
            value = HCLCGRAD1MOSAICOF;
        }
        if (fieldName.equals("HCLCGRAD1PUNTEADOF")) {
            value = HCLCGRAD1PUNTEADOF;
        }
        if (fieldName.equals("HCLCGRAD2MOSAICOG")) {
            value = HCLCGRAD2MOSAICOG;
        }
        if (fieldName.equals("HCLCGRAD2SIGBINT")) {
            value = HCLCGRAD2SIGBINT;
        }
        if (fieldName.equals("HCLCGRAD2SIGCRES")) {
            value = HCLCGRAD2SIGCRES;
        }
        if (fieldName.equals("HCLCGRAD2PUNTIG")) {
            value = HCLCGRAD2PUNTIG;
        }
        if (fieldName.equals("HCLCGRAD2BORDEDEL")) {
            value = HCLCGRAD2BORDEDEL;
        }
        if (fieldName.equals("HCLCGRAD2APAEPITELIO")) {
            value = HCLCGRAD2APAEPITELIO;
        }
        if (fieldName.equals("HCLCGRAD2ORIFICIOGLA")) {
            value = HCLCGRAD2ORIFICIOGLA;
        }
        if (fieldName.equals("HCLCGRAD3TEST")) {
            value = HCLCGRAD3TEST;
        }
        if (fieldName.equals("UBICACIONLDENTRO")) {
            value = UBICACIONLDENTRO;
        }
        if (fieldName.equals("UBICACIONLFUERA")) {
            value = UBICACIONLFUERA;
        }
        if (fieldName.equals("UBICACIONLNCUADRAN")) {
            value = UBICACIONLNCUADRAN;
        }
        if (fieldName.equals("UBICACIONLPORCEN")) {
            value = UBICACIONLPORCEN;
        }
        if (fieldName.equals("SIVASOSATI")) {
            value = SIVASOSATI;
        }
        if (fieldName.equals("SIVASOSDEL")) {
            value = SIVASOSDEL;
        }
        if (fieldName.equals("SISUPIRRE")) {
            value = SISUPIRRE;
        }
        if (fieldName.equals("SILESIOEX")) {
            value = SILESIOEX;
        }
        if (fieldName.equals("SINECROSIS")) {
            value = SINECROSIS;
        }
        if (fieldName.equals("SIULCERA")) {
            value = SIULCERA;
        }
        if (fieldName.equals("SITUMOR")) {
            value = SITUMOR;
        }
        if (fieldName.equals("SIOTROS")) {
            value = SIOTROS;
        }
        if (fieldName.equals("IMPDIAGN")) {
            value = IMPDIAGN;
        }
        if (fieldName.equals("IMPDIAGINF")) {
            value = IMPDIAGINF;
        }
        if (fieldName.equals("IMPDIAGATR")) {
            value = IMPDIAGATR;
        }
        if (fieldName.equals("IMPDIAGCARINV")) {
            value = IMPDIAGCARINV;
        }
        if (fieldName.equals("IMPDIAGSVPH")) {
            value = IMPDIAGSVPH;
        }
        if (fieldName.equals("IMPDIAGBGRADO")) {
            value = IMPDIAGBGRADO;
        }
        if (fieldName.equals("IMPDIAGAGRADO")) {
            value = IMPDIAGAGRADO;
        }
        if (fieldName.equals("IMPDIAGOTRO")) {
            value = IMPDIAGOTRO;
        }
        if (fieldName.equals("OBSERVACIONESDIAG")) {
            value = OBSERVACIONESDIAG;
        }
        if (fieldName.equals("PLANMANEJO")) {
            value = PLANMANEJO;
        }
        if (fieldName.equals("RECOMENDACIONES")) {
            value = RECOMENDACIONES;
        }
        if (fieldName.equals("HCLCGRAD2EPACEDEN")) {
            value = HCLCGRAD2EPACEDEN;
        }
        if (fieldName.equals("HALLAZNOESPEROSION")) {
            value = HALLAZNOESPEROSION;
        }
        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        }
        if (fieldName.equals("REG_PROFESIONAL")) {
            value = REG_PROFESIONAL;
        }
        if (fieldName.equals("IDEN_PROFESIONAL")) {
            value = IDEN_PROFESIONAL;
        }
        
        
        if (fieldName.equals("HACCFUMA")) {
            value = HACCFUMA;
        }
        if (fieldName.equals("HACCDIABETES")) {
            value = HACCDIABETES;
        }
        if (fieldName.equals("HACCVIH")) {
            value = HACCVIH;
        }
        if (fieldName.equals("HACCETS")) {
            value = HACCETS;
        }
        if (fieldName.equals("HCLCTOMOBIOP")) {
            value = HCLCTOMOBIOP;
        }
        if (fieldName.equals("HCLCOBSERVACIO")) {
            value = HCLCOBSERVACIO;
        }
        
        return value;
    }


    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setAplicacionMedicamento(AplicacionMedicamentoBean aplicacionMedicamento) {
        this.aplicacionMedicamento = aplicacionMedicamento;
    }

    public AplicacionMedicamentoBean getAplicacionMedicamento() {
        return aplicacionMedicamento;
    }

    public void setSurveypalLink(String surveypalLink) {
        this.surveypalLink = surveypalLink;
    }

    public String getSurveypalLink() {
        return surveypalLink;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getContrato() {
        return contrato;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getEps() {
        return eps;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getGestante() {
        return gestante;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setNumeroIden(String numeroIden) {
        this.numeroIden = numeroIden;
    }

    public String getNumeroIden() {
        return numeroIden;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }
    
    public void sendCorreoSurveypal(Cnconsclin consulta, String recipienTo) throws Exception {
        Chcorrelec correoelec = new Chcorrelec();
        correoelec.setHcenconsul(consulta.getCconnumero().longValue());
        correoelec.setHcelusuario(consulta.getCcolusuario().getHuslnumero());
        correoelec.setHceccorreoelec(recipienTo);
        correoelec.setHcectipo("SURVEYPAL");
        correoelec.setHcecetapa("PE");
        correoelec.setHcecusureg(userName());
        correoelec.setHcedfecreg(new Date());

        try {
            this.getServiceLocator().getClinicoService().saveOrUpdateChcorrelec(correoelec);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }
        
        AlertaEmail email = new AlertaEmail();
        String etapa = "EN";
        String error = "";
        try {
            email.sendCierreConsulta(recipienTo, surveypalLink);
        } catch (Exception ex) {
            ex.printStackTrace();
            etapa = "PE";
            error = ex.getMessage();
            throw new Exception(ex);
        } finally {
            Chcorrelec correlec = this.getServiceLocator().getClinicoService().getChcorrelec(consulta.getCconnumero().longValue());
            if (error != null && error.length() > 100) {
               correlec.setHcecerror(error.substring(0, 99));
            } else {
               correlec.setHcecerror(error);
            }
            correlec.setHcedfecenv(new Date());
            correlec.setHcecusuenv(userName());
            correlec.setHcecetapa(etapa);
            try {
                this.serviceLocator.getClinicoService().saveOrUpdateChcorrelec(correlec);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new Exception(ex);
            }
        }
    }
}
