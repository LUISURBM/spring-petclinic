package org.profamilia.hc.view.backing.menus.cirugia;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.consulta.CerrarCirugiaUsuarioBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaMedicoBean;
import org.profamilia.hc.view.backing.cirugia.registro.EvolucionBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.AnatomiaPatologicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.AutorizacionServicioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertAsistenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.CertMedicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamElectrofisiologicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamImagenUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ExamLaboratorioUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.FormulaMedicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.HospitalizacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.IncapacidadUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.OrdenCirugiaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionCirugiaBean;
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReservaSangreUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

public class MenuEvolucionMedicoBean extends BaseBean {

    private EvolucionBean evolucionMedico;

    private AnatomiaPatologicaUsuarioBean anatomiaPatologicaUsuarioBean;

    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private HospitalizacionUsuarioBean hospitalizacionUsuarioBean;

    private OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private IncapacidadUsuarioBean incapacidadUsuarioBean;

    private RecomedacionCirugiaBean recomedacionUsuarioBean;

    private ReferenciaUsuarioBean referenciaUsuarioBean;

    private ReservaSangreUsuarioBean reservaSangreUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private ExamElectrofisiologicoUsuarioBean examElectrofisiologicoUsuarioBean;

    private ExamImagenUsuarioBean examImagenUsuarioBean;

    private ExamLaboratorioUsuarioBean examLaboratorioUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;

    //    private FormulaEspecialBean formulaEspecialBean;

    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;

    private OtrasOrdenesBean otrasOrdenesBean;

    //    private MedidadApoyoBean medidaApoyoBean;

    private ExamenFisicoUsuarioBean examenFisicoUsuario;

    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;

    private ConsultarFoliosUsuarioCirugiaMedicoBean consultarFolios;

    private VademecumMedicoBean vademecumUsuarioBean;
    
    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private Chcirugprogr cirugia;

    private Long numeroConsulta;

    private Long numeroUsuario;

    private Integer consecutivo;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private CerrarCirugiaUsuarioBean cerrarCirugiaUsuarioBean;

    private boolean ligadura;

    private boolean vasectomia;
    
    private Cnconsclin consulta;

    public void init() {

        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;
        ligadura = false;
        vasectomia = false;
        codigoCups = "";
        try {
            if (numeroConsulta != null) {
                consulta = 
                        this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        evolucionMedico = 
                (EvolucionBean)FacesUtils.getManagedBean("evolucionBean");
        evolucionMedico.setTipoServicio(TIPO_HOSPITALIZACION);
        evolucionMedico.setMenuBean("menuEvolucionMedicoBean");
        evolucionMedico.setCirugia(cirugia);
        renderConducta = evolucionMedico.esValido();

        if (evolucionMedico != null && evolucionMedico.getCirugia() != null && 
            evolucionMedico.getCirugia().getHcplnumero() != null) {
            numeroConsulta = evolucionMedico.getCirugia().getHcplnumero();
        }

        if (evolucionMedico != null && 
            evolucionMedico.getLstCirugias() != null && 
            !evolucionMedico.getLstCirugias().isEmpty()) {
            Chdetacirpro detalle = null;
            Iterator it = evolucionMedico.getLstCirugias().iterator();
            if (it.hasNext()) {
                Cpservicio servicioAux;
                servicioAux = (Cpservicio)it.next();
                if (codigoCups == null || codigoCups.trim().equals("")) {
                    codigoCups = servicioAux.getCsvccodigo();
                }
                if (servicioAux != null) {
                    if (servicioAux != null && 
                        servicioAux.getCsvntiphis() != null && 
                        servicioAux.getCsvntiphis().equals(CIRUGIA_LIGADURA_POR_BIPOLAR)) {
                        ligadura = true;
                    } else {
                        ligadura = false;
                    }
                    if (servicioAux != null && 
                        servicioAux.getCsvntiphis() != null && 
                        (servicioAux.getCsvntiphis().equals(CIRUGIA_VASECTOMIA) || 
                         servicioAux.getCsvntiphis().equals(HISTORIA_ESTERILIZACION_MASCULINA))) {
                        vasectomia = true;
                    } else {
                        vasectomia = false;
                    }
                }
            }
        }
        System.out.println("Codigos CUPS " + codigoCups);
        if (evolucionMedico != null && evolucionMedico.getCirugia() != null && 
            evolucionMedico.getCirugia().getHcplusuario() != null) {
            numeroUsuario = 
                    evolucionMedico.getCirugia().getHcplusuario().getHuslnumero();
        }
        if (evolucionMedico != null && 
            evolucionMedico.getEvolucion() != null && 
            evolucionMedico.getEvolucion().getId() != null) {
            Long idUsuario = null;
            consecutivo = 
                    evolucionMedico.getEvolucion().getId().getHevnconsecutiv();
            numeroConsulta = 
                    evolucionMedico.getEvolucion().getId().getHevlnumero();
            numeroUsuario = evolucionMedico.getEvolucion().getHevlusuario();
            idUsuario = evolucionMedico.getEvolucion().getHevlusuario();
            if (idUsuario != null) {
                try {
                    usuario = 
                            this.serviceLocator.getClinicoService().getUsuario(idUsuario);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }

        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_HOSPITALIZACION);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setConsecutivo(consecutivo);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_ACTUAL);
        examenFisicoUsuario.setMenuBean("menuEvolucionMedicoBean");
        examenFisicoUsuario.setUsuario(usuario);
        examenFisicoUsuario.inicializarExamen();

        // IMPRESION DIAGNOSTICA
        impresionDiagnosticaUsuarioBean = 
                (ImpresionDiagnosticaUsuarioBean)FacesUtils.getManagedBean("impresionDiagnosticaUsuarioBean");
        impresionDiagnosticaUsuarioBean.setUsuario(usuario);
        impresionDiagnosticaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        impresionDiagnosticaUsuarioBean.setNumeroConsulta(numeroConsulta);
        impresionDiagnosticaUsuarioBean.setConsecutivo(consecutivo);
        impresionDiagnosticaUsuarioBean.setNextAction(BeanNavegacion.RUTA_ACTUAL);
        impresionDiagnosticaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        impresionDiagnosticaUsuarioBean.setDesHabilitarDiagnosticoPrincipal(false);
        impresionDiagnosticaUsuarioBean.inicializarImpresion();

        // SE OBTIENE EL CODIGO DEL DIAGNOSTICO PRINCIPAL 

        if (impresionDiagnosticaUsuarioBean != null && 
            impresionDiagnosticaUsuarioBean.getImpresion() != null && 
            impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin() != 
            null) {
            cie10Principal = 
                    impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin();
            cie10Relacionado1 = 
                    impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela1();
        }
        if (cie10Principal == null || cie10Principal.equals("")) {
            cie10Principal = "Z302";
        }

        // CONDUCTA - RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionCirugiaBean)FacesUtils.getManagedBean("recomedacionCirugiaBean");
        recomedacionUsuarioBean.setUsuario(usuario);
        recomedacionUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        recomedacionUsuarioBean.setConsecutivo(consecutivo);
        recomedacionUsuarioBean.setEsCirugia(true);
        recomedacionUsuarioBean.inicializarRecomedaciones();
        renderCerrarConsulta = recomedacionUsuarioBean.esValido();

        // CONDUCTA - ANATOMIA PATOLOGICA
        anatomiaPatologicaUsuarioBean = 
                (AnatomiaPatologicaUsuarioBean)FacesUtils.getManagedBean("anatomiaPatolUsuarioBean");
        anatomiaPatologicaUsuarioBean.setUsuario(usuario);
        anatomiaPatologicaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        anatomiaPatologicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        anatomiaPatologicaUsuarioBean.setEsCirugia(true);
        anatomiaPatologicaUsuarioBean.setConsecutivo(consecutivo);
        //anatomiaPatologicaUsuarioBean.setAntecedente(antecedenteObject);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();

        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(usuario);
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        List<Chformulamed> lstPrescripciones;
        lstPrescripciones = new ArrayList<Chformulamed>();
        Chformulamed formula = null;
        if (vasectomia) {
            formula = new Chformulamed();
            formula.setHfocoperador(userName());
            formula.setHfoccontraindi("");
            formula.setHfodfecregistr(new Date());
            formula = new Chformulamed();
            formula.setImprimir(false);
            formula.setHfocadosis(15);
            formula.setHfocmedicament("IBUPROFENO");
            formula.setHfoctratramien("400 MG CADA 8 HORAS POR 5 D�AS");
            formula.setHfocviadministr("VO");
            formula.setHfoccontraindi("");
            formula.setHfodfecregistr(new Date());
            formula.setHfocoperador(userName());
            formula.setHfoccontraindi("");
            formula.setHfoctiposerv("H");
            formula.setHfocconcentr("400");
            formula.setHfocunidmedi("mg");
            formula.setHfocformafarma("TABL");
            formula.setHfoccodisap("1000000550");
            lstPrescripciones.add(formula);
        }
        if (ligadura) {
            formula = new Chformulamed();
            formula.setHfocoperador(userName());
            formula.setHfoccontraindi("");
            formula.setHfodfecregistr(new Date());
            formula = new Chformulamed();
            formula.setImprimir(false);
            formula.setHfocadosis(15);
            formula.setHfocmedicament("ACETAMINOFEN");
            formula.setHfoctratramien("500 MG CADA 8 HORAS POR 5 D�AS");
            formula.setHfocviadministr("VO");
            formula.setHfoccontraindi("");
            formula.setHfodfecregistr(new Date());
            formula.setHfocoperador(userName());
            formula.setHfoccontraindi("");
            formula.setHfoctiposerv("H");
            formula.setHfocconcentr("500");
            formula.setHfocunidmedi("mg");
            formula.setHfocformafarma("TABL");
            formula.setHfoccodisap("1000000158");
            lstPrescripciones.add(formula);
        }
        /*formulaMedicaUsuarioBean =
               (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(usuario);
        formulaMedicaUsuarioBean.setEsCirugia(true);
        formulaMedicaUsuarioBean.setConsecutivo(consecutivo);
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setLstPrescripcionesDefecto(lstPrescripciones);
        formulaMedicaUsuarioBean.setCodigoCIE10("Z302");
        formulaMedicaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        formulaMedicaUsuarioBean.setLigadura(ligadura);
        formulaMedicaUsuarioBean.inicializardFormulaMedica();*/

        // CONDUCTA - FORMULA MEDICA
        vademecumUsuarioBean = 
                (VademecumMedicoBean)FacesUtils.getManagedBean("vademecumMedicoBean");
        vademecumUsuarioBean.setUsuario(usuario);
        vademecumUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        vademecumUsuarioBean.setNumeroConsulta(numeroConsulta);
        vademecumUsuarioBean.setCodigoCIE10(cie10Principal);
        vademecumUsuarioBean.setConsecutivo(1);
        vademecumUsuarioBean.setLstPrescripcionesDefecto(lstPrescripciones);
        vademecumUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        vademecumUsuarioBean.inicializardFormulaMedica();

        // CONDUCTA - INCAPACIDAD

        incapacidadUsuarioBean = 
                (IncapacidadUsuarioBean)FacesUtils.getManagedBean("incapacidadUsuarioBean");
        incapacidadUsuarioBean.setUsuario(usuario);
        incapacidadUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        incapacidadUsuarioBean.setNumeroConsulta(numeroConsulta);
        incapacidadUsuarioBean.setEsCirugia(true);
        incapacidadUsuarioBean.setConsecutivo(consecutivo);
        incapacidadUsuarioBean.setCie10Principal(cie10Principal);
        incapacidadUsuarioBean.setCie10Relacionado1(cie10Relacionado1);
        incapacidadUsuarioBean.setCodigoCups(codigoCups);
        incapacidadUsuarioBean.setLigadura(ligadura);
        incapacidadUsuarioBean.setVasectomia(vasectomia);
        incapacidadUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        incapacidadUsuarioBean.inicializarIncapacidad();

        // CONDUCTA - REMISION HOSPITALIZACION
        hospitalizacionUsuarioBean = 
                (HospitalizacionUsuarioBean)FacesUtils.getManagedBean("hospitalizacionUsuarioBean");
        hospitalizacionUsuarioBean.setUsuario(usuario);
        hospitalizacionUsuarioBean.setEsCirugia(true);
        hospitalizacionUsuarioBean.setConsecutivo(consecutivo);
        hospitalizacionUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        hospitalizacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        //hospitalizacionUsuarioBean.setCiel0Principal(cie10Principal);
        hospitalizacionUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(usuario);
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        ordenCirugiaUsuarioBean.setEsCirugia(true);
        ordenCirugiaUsuarioBean.setConsecutivo(consecutivo);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        if (consulta != null) {
            Long tipoDocuentoAdmision = 
                consulta.getCcontipdoc().getCtdnnumero().longValue();
            if (tipoDocuentoAdmision == IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    ordenCirugiaUsuarioBean.setNumeroAdmision(consulta.getCconnumdoc().longValue());
            }
        }
        ordenCirugiaUsuarioBean.inicializarOrdenCirugia();

        // CONDUCTA - INTER-CONSULTA
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(usuario);
        interConsultaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setEsCirugia(true);
        interConsultaUsuarioBean.setConsecutivo(consecutivo);
        //interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        interConsultaUsuarioBean.inicializarInterConsulta();

        // CONDUCTA - REFERENCIA
        referenciaUsuarioBean = 
                (ReferenciaUsuarioBean)FacesUtils.getManagedBean("referenciaUsuarioBean");
        referenciaUsuarioBean.setUsuario(usuario);
        referenciaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        referenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        referenciaUsuarioBean.setConsultaAux(consulta);
        referenciaUsuarioBean.setEsCirugia(true);
        referenciaUsuarioBean.setConsecutivo(consecutivo);
        referenciaUsuarioBean.setTensionArterial(tensionArterial);
        referenciaUsuarioBean.setFrecuenciaCardiaca(frecuenciaCardiaca);
        referenciaUsuarioBean.setFrecuenciaRespiratoria(frecuenciaRespiratoria);
        referenciaUsuarioBean.setPeso(peso);
        referenciaUsuarioBean.setHallazgos(hallazgos);
        referenciaUsuarioBean.setTemperatura(temperatura);
        referenciaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        referenciaUsuarioBean.inicializarReferencia();
        
        // CONDUCTA - AUTORIZACION DE SERVICIOS
        
         autorizacionServicioUsuarioBean =
                 (AutorizacionServicioUsuarioBean)FacesUtils.getManagedBean("autorizacionServicioUsuarioBean");
         autorizacionServicioUsuarioBean.setUsuario(usuario);
         
         autorizacionServicioUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
         autorizacionServicioUsuarioBean.setNumeroConsulta(numeroConsulta);
        // autorizacionServicioUsuarioBean.setTipoHistoria(motivoConsulta.getTipoHistoria());
         
         autorizacionServicioUsuarioBean.setCodigoCups(codigoCups);
        autorizacionServicioUsuarioBean.setTipoDiagnostico(impresionDiagnosticaUsuarioBean.getImpresion().getHidntipodiagn());
        autorizacionServicioUsuarioBean.setCodigoDiagnostico(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagprin());
        autorizacionServicioUsuarioBean.setCodigoDiagnostico1(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela2());
        autorizacionServicioUsuarioBean.setCodigoDiagnostico2(impresionDiagnosticaUsuarioBean.getImpresion().getHidcdiagrela3());
         autorizacionServicioUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
         autorizacionServicioUsuarioBean.inicializarAutorizacionServicio();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(usuario);
        reservaSangreUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        reservaSangreUsuarioBean.setEsCirugia(true);
        reservaSangreUsuarioBean.setConsecutivo(consecutivo);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(usuario);
        certMedicoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setEsCirugia(true);
        certMedicoUsuarioBean.setConsecutivo(consecutivo);
        certMedicoUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        certMedicoUsuarioBean.inicializarCertificadoMedico();
        certMedicoUsuarioBean.setEsCirugia(false);

        // CONDUCTA - CERTIFICADOS / CERTIFICADO DE ASISTENCIA
        certAsistenciaUsuarioBean = 
                (CertAsistenciaUsuarioBean)FacesUtils.getManagedBean("certAsistenciaUsuarioBean");
        certAsistenciaUsuarioBean.setUsuario(usuario);
        certAsistenciaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        certAsistenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        certAsistenciaUsuarioBean.setEsCirugia(true);
        certAsistenciaUsuarioBean.setConsecutivo(consecutivo);
        //  certAsistenciaUsuarioBean.setCodigoCups(codigoCups);
        certAsistenciaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(usuario);
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setEsCirugia(true);
        examElectrofisiologicoUsuarioBean.setConsecutivo(consecutivo);
        //  examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(usuario);
        examImagenUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setEsCirugia(true);
        examImagenUsuarioBean.setConsecutivo(consecutivo);
        //   examImagenUsuarioBean.setAntecedente(antecedenteObject);
        //   examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(usuario);
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setEsCirugia(true);
        examLaboratorioUsuarioBean.setConsecutivo(consecutivo);
        //    examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        examLaboratorioUsuarioBean.inicializarExamLaboratorio();

        //        formulaEspecialBean = 
        //                (FormulaEspecialBean)FacesUtils.getManagedBean("formulaEspecialBean");
        //        formulaEspecialBean.setUsuario(usuario);
        //        formulaEspecialBean.setTipoServicio(TIPO_HOSPITALIZACION);
        //        formulaEspecialBean.setNumeroCirugia(numeroConsulta);
        //        formulaEspecialBean.setEsCirugia(true);
        //        formulaEspecialBean.setConsecutivo(consecutivo);
        //        formulaEspecialBean.init();

        formulaLiquidosBean = 
                (FormulaLiquidosBean)FacesUtils.getManagedBean("formulaLiquidosBean");
        formulaLiquidosBean.setUsuario(usuario);
        formulaLiquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaLiquidosBean.setNumeroCirugia(numeroConsulta);
        formulaLiquidosBean.setConsecutivo(consecutivo);
        formulaLiquidosBean.setNumeroUsuario(numeroUsuario);
        formulaLiquidosBean.init();

        formulaHospitalizacionBean = 
                (FormulaHospitalizacionBean)FacesUtils.getManagedBean("formulaHospitalizacionBean");
        formulaHospitalizacionBean.setUsuario(usuario);
        formulaHospitalizacionBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaHospitalizacionBean.setNumeroCirugia(numeroConsulta);
        formulaHospitalizacionBean.setRenderProfilaxis(false);
        formulaHospitalizacionBean.setConsecutivo(consecutivo);
        formulaHospitalizacionBean.setNumeroUsuario(numeroUsuario);
        formulaHospitalizacionBean.init();

        otrasOrdenesBean = 
                (OtrasOrdenesBean)FacesUtils.getManagedBean("otrasOrdenesBean");

        //otrasOrdenesBean.setCirugia(evolucionMedico.getCirugia());
        otrasOrdenesBean.setConsecutivo(consecutivo);
        otrasOrdenesBean.setNumeroConsulta(numeroConsulta);
        otrasOrdenesBean.setTipoServicio(TIPO_HOSPITALIZACION);
        otrasOrdenesBean.init();

        //        medidaApoyoBean = 
        //                (MedidadApoyoBean)FacesUtils.getManagedBean("medidadApoyoBean");
        //        medidaApoyoBean.setUsuario(usuario);
        //        medidaApoyoBean.setTipoServicio(TIPO_HOSPITALIZACION);
        //        medidaApoyoBean.setNumeroCirugia(numeroConsulta);
        //        medidaApoyoBean.setConsecutivo(consecutivo);
        //        medidaApoyoBean.init();

        // CERRAR CONSULTA
        cerrarCirugiaUsuarioBean = 
                (CerrarCirugiaUsuarioBean)FacesUtils.getManagedBean("cerrarCirugiaUsuarioBean");
        cerrarCirugiaUsuarioBean.setUsuario(usuario);
        cerrarCirugiaUsuarioBean.setConsecutivo(consecutivo);
        cerrarCirugiaUsuarioBean.setNumeroCirugia(numeroConsulta);
        cerrarCirugiaUsuarioBean.setMenuBean("menuEvolucionMedicoBean");
        cerrarCirugiaUsuarioBean.inicalizarCerrarConsultaBean();

        //RESUMEN DE LA HISTORIA CLINICA

        resumenEspecifico = 
                (ResumenHistoriaEspecificaBean)FacesUtils.getManagedBean("resumenHistoriaEspecificaBean");
        resumenEspecifico.setUsuario(usuario);
        consultarFolios = 
                (ConsultarFoliosUsuarioCirugiaMedicoBean)FacesUtils.getManagedBean("consultarFoliosUsuarioCirugiaMedicoBean");

        if (consultarFolios != null) {
            consultarFolios.setUsuario(usuario);
            consultarFolios.setNumeroUsuario(numeroUsuario);
            consultarFolios.init();
        }
    }

    public String irEvolucionMedicoUsuario() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irExamenFisicoEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irImpDiagnosticaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irAnatPatologicaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIA_PATOLOGICA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irControlSinCostoEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_SIN_COSTO_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irFormulaMedicaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_MEDICA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALIZACION_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irIncapacidadEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irInterConsultaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irOrdenCirugiaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDEN_CIRUGIA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irReferenciaEvolucionMedico() {
        inicializarUsuario();
        
        // CONDUCTA - REFERENCIA
        referenciaUsuarioBean = 
                (ReferenciaUsuarioBean)FacesUtils.getManagedBean("referenciaUsuarioBean");
        referenciaUsuarioBean.setUsuario(usuario);
        referenciaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        referenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        referenciaUsuarioBean.setConsultaAux(consulta);
        referenciaUsuarioBean.setEsCirugia(true);
        referenciaUsuarioBean.setConsecutivo(consecutivo);
        referenciaUsuarioBean.inicializarReferencia();
        
        return BeanNavegacion.RUTA_IR_REFERENCIA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irReservaSangreEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irRecomedacionEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irCertMedicoEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_MEDICO_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irCertAsistenciaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_ELECTROFISIOLOGICO_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irExamImagenEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_IMAGENES_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irExamLaboratorioEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_LABORATORIOS_EVOLUCION_MEDICO;
    }

    /**
     * @return
     */
    public String irRegistrarOtrasOrdenes() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES;
    }


    /**
     * @return
     */
    public String irCerrarConsultaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERRAR_CONSULTA_EVOLUCION_MEDICO;
    }


    /**
     * @return
     */
    public String irFormularLiquidosEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_LIQUIDOS_EVOLUCION_MEDICO;
    }


    /**
     * @return
     */
    public String irFormularMedicamentosEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_HOSPITALIZACION_EVOLUCION_MEDICO;
    }


    /**
     * @return
     */
    public String irMedidasApoyoEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MEDIDAS_APOYO_EVOLUCION_MEDICO;
    }


    /**
     * @return
     */
    public String irMedicamentosEspecialesEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_ESPECIALES_EVOLUCION_MEDICO;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL;
    }

    public String irConsultarFoliosUsuarioCirugiaMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONSULTAR_FOLIOS_CIRUGIA_MEDICO;
    }


    public void inicializarUsuario() {
        if (evolucionMedico != null && evolucionMedico.getCirugia() != null && 
            evolucionMedico.getCirugia().getHcplusuario() != null)
            this.setUsuario(evolucionMedico.getCirugia().getHcplusuario());
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
     * @param renderConducta
     */
    public void setRenderConducta(boolean renderConducta) {
        this.renderConducta = renderConducta;
    }

    /**
     * @return
     */
    public boolean isRenderConducta() {
        return renderConducta;
    }

    /**
     * @param renderCerrarConsulta
     */
    public void setRenderCerrarConsulta(boolean renderCerrarConsulta) {
        this.renderCerrarConsulta = renderCerrarConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderCerrarConsulta() {
        return renderCerrarConsulta;
    }

    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @return
     */
    public String irResumenHistoriaEspecificaEvolucionMedico() {

        FacesUtils.resetManagedBean("consultarFoliosBean");
        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(usuario);
            generarResumen.consultarFoliosUsuario();
        }
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_EVOLUCION_MEDICO;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public String irAautorizacionServiciosEvolucionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_AUTORIZACION_SERVICIOS_EVOLUCION_MEDICO;
        }}
