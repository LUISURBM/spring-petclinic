package org.profamilia.hc.view.backing.menus.cirugia;

import java.util.Date;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiasMedicoBean;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaMedicoBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaEspecialBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.conducta.MedidadApoyoBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.ImpresionDiagnosticaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.AnatomiaPatologicaUsuarioBean;
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
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReservaSangreUsuarioBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuIngresoMedicoBean extends BaseBean {


    private IngresoCirugiaMedicoBean ingresoMedico;

    private AnatomiaPatologicaUsuarioBean anatomiaPatologicaUsuarioBean;

    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;

    private HospitalizacionUsuarioBean hospitalizacionUsuarioBean;

    private OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private IncapacidadUsuarioBean incapacidadUsuarioBean;

    private RecomedacionUsuarioBean recomedacionUsuarioBean;

    private ReferenciaUsuarioBean referenciaUsuarioBean;

    private ReservaSangreUsuarioBean reservaSangreUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private ExamElectrofisiologicoUsuarioBean examElectrofisiologicoUsuarioBean;

    private ExamImagenUsuarioBean examImagenUsuarioBean;

    private ExamLaboratorioUsuarioBean examLaboratorioUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;

    private FormulaEspecialBean formulaEspecialBean;

    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;

    private MedidadApoyoBean medidaApoyoBean;
    
    
    private ExamenFisicoUsuarioBean examenFisicoUsuario;
    
    private ImpresionDiagnosticaUsuarioBean impresionDiagnosticaUsuarioBean;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private Chcirugprogr cirugia;

    private Long numeroConsulta;
    
    private Integer consecutivo;
    
    private String cie10Principal;

    private String cie10Relacionado1;
    
    private Long numeroUsuario; 
    
    private boolean ligadura;


    public void init() {
    
        consecutivo = 0; 

        // DATOS BASICOS USUARIO
        ingresoMedico = 
                (IngresoCirugiaMedicoBean)FacesUtils.getManagedBean("ingresoCirugiaMedicoBean");
        ingresoMedico.setMenuBean("menuIngresoMedicoBean");
        ingresoMedico.setCirugia(cirugia);
        if(!renderConducta){
            renderConducta = ingresoMedico.esValido();    
        }
        

        if (ingresoMedico != null && ingresoMedico.getCirugia() != null && 
            ingresoMedico.getCirugia().getHcplnumero() != null) {
            numeroConsulta = ingresoMedico.getCirugia().getHcplnumero();
        }
        
        
        
        if (ingresoMedico != null && 
            ingresoMedico.getCirugia() != null && 
            ingresoMedico.getCirugia().getHcplusuario()!= null) {
            numeroUsuario = ingresoMedico.getCirugia().getHcplusuario().getHuslnumero();         
        }
        
        
        examenFisicoUsuario = 
                (ExamenFisicoUsuarioBean)FacesUtils.getManagedBean("examenFisicoUsuarioBean");
        examenFisicoUsuario.setTipoServicio(TIPO_HOSPITALIZACION);
        examenFisicoUsuario.setNumeroConsulta(numeroConsulta);
        examenFisicoUsuario.setConsecutivo(consecutivo);
        examenFisicoUsuario.setNextAction(BeanNavegacion.RUTA_ACTUAL);
        examenFisicoUsuario.setMenuBean(null);
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
        impresionDiagnosticaUsuarioBean.setMenuBean(null);
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


        // CONDUCTA - RECOMENDACIONES
        recomedacionUsuarioBean = 
                (RecomedacionUsuarioBean)FacesUtils.getManagedBean("recomedacionUsuarioBean");
        recomedacionUsuarioBean.setUsuario(usuario);
        recomedacionUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        recomedacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        recomedacionUsuarioBean.setMenuBean("menuIngresoMedicoBean");
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
        anatomiaPatologicaUsuarioBean.setConsecutivo(1);
        //anatomiaPatologicaUsuarioBean.setAntecedente(antecedenteObject);
        anatomiaPatologicaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        anatomiaPatologicaUsuarioBean.inicializarAnatomiaPatol();


        // CONDUCTA - CONTROL SIN COSTO
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(usuario);
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        //controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA
        formulaMedicaUsuarioBean = 
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(usuario);
        formulaMedicaUsuarioBean.setEsCirugia(true);
        formulaMedicaUsuarioBean.setConsecutivo(1);
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        //formulaMedicaUsuarioBean.setCodigoCIE10(cie10Principal);
        formulaMedicaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        formulaMedicaUsuarioBean.inicializardFormulaMedica();

        // CONDUCTA - REMISION HOSPITALIZACION
        hospitalizacionUsuarioBean = 
                (HospitalizacionUsuarioBean)FacesUtils.getManagedBean("hospitalizacionUsuarioBean");
        hospitalizacionUsuarioBean.setUsuario(usuario);
        hospitalizacionUsuarioBean.setEsCirugia(true);
        hospitalizacionUsuarioBean.setConsecutivo(1);
        hospitalizacionUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        hospitalizacionUsuarioBean.setNumeroConsulta(numeroConsulta);
        //hospitalizacionUsuarioBean.setCiel0Principal(cie10Principal);
        hospitalizacionUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        hospitalizacionUsuarioBean.inicializarHospitalizacion();

        // CONDUCTA - Cirug�as y procedimientos
        ordenCirugiaUsuarioBean = 
                (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
        ordenCirugiaUsuarioBean.setUsuario(usuario);
        ordenCirugiaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        ordenCirugiaUsuarioBean.setEsCirugia(true);
        ordenCirugiaUsuarioBean.setConsecutivo(1);
        ordenCirugiaUsuarioBean.setNumeroConsulta(numeroConsulta);
        ordenCirugiaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        ordenCirugiaUsuarioBean.inicializarOrdenCirugia();

        // CONDUCTA - INTER-CONSULTA
        interConsultaUsuarioBean = 
                (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
        interConsultaUsuarioBean.setUsuario(usuario);
        interConsultaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        interConsultaUsuarioBean.setNumeroConsulta(numeroConsulta);
        interConsultaUsuarioBean.setEsCirugia(true);
        interConsultaUsuarioBean.setConsecutivo(1);
        //interConsultaUsuarioBean.setCie10Principal(cie10Principal);
        interConsultaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        interConsultaUsuarioBean.inicializarInterConsulta();

        // CONDUCTA - INCAPACIDAD
        incapacidadUsuarioBean = 
                (IncapacidadUsuarioBean)FacesUtils.getManagedBean("incapacidadUsuarioBean");
        incapacidadUsuarioBean.setUsuario(usuario);
        incapacidadUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        incapacidadUsuarioBean.setNumeroConsulta(numeroConsulta);
        incapacidadUsuarioBean.setEsCirugia(true);
        incapacidadUsuarioBean.setConsecutivo(1);
        incapacidadUsuarioBean.setCie10Principal(cie10Principal);
        incapacidadUsuarioBean.setCie10Relacionado1(cie10Relacionado1);
        incapacidadUsuarioBean.setLigadura(ligadura);
        //incapacidadUsuarioBean.setCodigoCups(codigoCups);
        incapacidadUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        incapacidadUsuarioBean.inicializarIncapacidad();


        // CONDUCTA - REFERENCIA
        referenciaUsuarioBean = 
                (ReferenciaUsuarioBean)FacesUtils.getManagedBean("referenciaUsuarioBean");
        referenciaUsuarioBean.setUsuario(usuario);
        referenciaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        referenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        referenciaUsuarioBean.setEsCirugia(true);
        referenciaUsuarioBean.setConsecutivo(1);
        // referenciaUsuarioBean.setTensionArterial(tensionArterial);
        // referenciaUsuarioBean.setFrecuenciaCardiaca(frecuenciaCardiaca);
        // referenciaUsuarioBean.setFrecuenciaRespiratoria(frecuenciaRespiratoria);
        // referenciaUsuarioBean.setPeso(peso);
        // referenciaUsuarioBean.setHallazgos(hallazgos);
        // referenciaUsuarioBean.setTemperatura(temperatura);
        referenciaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        referenciaUsuarioBean.inicializarReferencia();


        // CONDUCTA - SOLICITUD RESERVA DE SANGRE
        reservaSangreUsuarioBean = 
                (ReservaSangreUsuarioBean)FacesUtils.getManagedBean("reservaSangreUsuarioBean");
        reservaSangreUsuarioBean.setUsuario(usuario);
        reservaSangreUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        reservaSangreUsuarioBean.setEsCirugia(true);
        reservaSangreUsuarioBean.setConsecutivo(1);
        reservaSangreUsuarioBean.setNumeroConsulta(numeroConsulta);
        reservaSangreUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        reservaSangreUsuarioBean.inicializarReservaSangre();

        // CONDUCTA - CERTIFICADOS / CERTIFICADO MEDICO
        certMedicoUsuarioBean = 
                (CertMedicoUsuarioBean)FacesUtils.getManagedBean("certMedicoUsuarioBean");
        certMedicoUsuarioBean.setUsuario(usuario);
        certMedicoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        certMedicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        certMedicoUsuarioBean.setEsCirugia(true);
        certMedicoUsuarioBean.setConsecutivo(1);
        certMedicoUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        certMedicoUsuarioBean.inicializarCertificadoMedico();
        certMedicoUsuarioBean.setEsCirugia(false);

        // CONDUCTA - CERTIFICADOS / CERTIFICADO DE ASISTENCIA
        certAsistenciaUsuarioBean = 
                (CertAsistenciaUsuarioBean)FacesUtils.getManagedBean("certAsistenciaUsuarioBean");
        certAsistenciaUsuarioBean.setUsuario(usuario);
        certAsistenciaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        certAsistenciaUsuarioBean.setNumeroConsulta(numeroConsulta);
        certAsistenciaUsuarioBean.setEsCirugia(true);
        certAsistenciaUsuarioBean.setConsecutivo(1);
        //  certAsistenciaUsuarioBean.setCodigoCups(codigoCups);
        certAsistenciaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        certAsistenciaUsuarioBean.inicializarCertificadoAsistencia();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN ELECTROFISIOLOGICO
        examElectrofisiologicoUsuarioBean = 
                (ExamElectrofisiologicoUsuarioBean)FacesUtils.getManagedBean("examElectrofisioUsuarioBean");
        examElectrofisiologicoUsuarioBean.setUsuario(usuario);
        examElectrofisiologicoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        examElectrofisiologicoUsuarioBean.setNumeroConsulta(numeroConsulta);
        examElectrofisiologicoUsuarioBean.setEsCirugia(true);
        examElectrofisiologicoUsuarioBean.setConsecutivo(1);
        //  examElectrofisiologicoUsuarioBean.setCie10Principal(cie10Principal);
        examElectrofisiologicoUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        examElectrofisiologicoUsuarioBean.inicializarExamElectrofisiologico();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN IMAGEN
        examImagenUsuarioBean = 
                (ExamImagenUsuarioBean)FacesUtils.getManagedBean("examImagenUsuarioBean");
        examImagenUsuarioBean.setUsuario(usuario);
        examImagenUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        examImagenUsuarioBean.setNumeroConsulta(numeroConsulta);
        examImagenUsuarioBean.setEsCirugia(true);
        examImagenUsuarioBean.setConsecutivo(1);
        //   examImagenUsuarioBean.setAntecedente(antecedenteObject);
        //   examImagenUsuarioBean.setCie10Principal(cie10Principal);
        examImagenUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        examImagenUsuarioBean.inicializarExamImagen();

        // CONDUCTA - EXAMENES PARACLINICOS / EXAMEN LABORATORIO
        examLaboratorioUsuarioBean = 
                (ExamLaboratorioUsuarioBean)FacesUtils.getManagedBean("examLaboratorioUsuarioBean");
        examLaboratorioUsuarioBean.setUsuario(usuario);
        examLaboratorioUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        examLaboratorioUsuarioBean.setNumeroConsulta(numeroConsulta);
        examLaboratorioUsuarioBean.setEsCirugia(true);
        examLaboratorioUsuarioBean.setConsecutivo(1);
        //    examLaboratorioUsuarioBean.setCie10Principal(cie10Principal);
        examLaboratorioUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        examLaboratorioUsuarioBean.inicializarExamLaboratorio();


        formulaEspecialBean = 
                (FormulaEspecialBean)FacesUtils.getManagedBean("formulaEspecialBean");
        formulaEspecialBean.setUsuario(usuario);
        formulaEspecialBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaEspecialBean.setNumeroCirugia(numeroConsulta);
        formulaEspecialBean.setEsCirugia(true);
        formulaEspecialBean.setConsecutivo(1);
        formulaEspecialBean.init();


        formulaLiquidosBean = 
                (FormulaLiquidosBean)FacesUtils.getManagedBean("formulaLiquidosBean");
        formulaLiquidosBean.setUsuario(usuario);
        formulaLiquidosBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaLiquidosBean.setNumeroCirugia(numeroConsulta);
        formulaLiquidosBean.setNumeroUsuario(numeroUsuario);
        formulaLiquidosBean.setConsecutivo(1);
        formulaLiquidosBean.init();


        formulaHospitalizacionBean = 
                (FormulaHospitalizacionBean)FacesUtils.getManagedBean("formulaHospitalizacionBean");
        formulaHospitalizacionBean.setUsuario(usuario);
        formulaHospitalizacionBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaHospitalizacionBean.setNumeroCirugia(numeroConsulta);
        formulaHospitalizacionBean.setRenderProfilaxis(false);
        formulaHospitalizacionBean.setNumeroUsuario(numeroUsuario);
        formulaHospitalizacionBean.setConsecutivo(1);
        formulaHospitalizacionBean.init();


        medidaApoyoBean = 
                (MedidadApoyoBean)FacesUtils.getManagedBean("medidadApoyoBean");
        medidaApoyoBean.setUsuario(usuario);
        medidaApoyoBean.setTipoServicio(TIPO_HOSPITALIZACION);
        medidaApoyoBean.setNumeroCirugia(numeroConsulta);
        medidaApoyoBean.setConsecutivo(1);
        medidaApoyoBean.init();

        // CERRAR CONSULTA
        /*     cerrarConsultaUsuarioBean =
          (CerrarConsultaUsuarioBean) FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(usuario);
        cerrarConsultaUsuarioBean.setMenuBean("menuIngresoMedicoBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();*/


        //RESUMEN DE LA HISTORIA CLINICA

        resumenEspecifico = 
                (ResumenHistoriaEspecificaBean)FacesUtils.getManagedBean("resumenHistoriaEspecificaBean");
        resumenEspecifico.setUsuario(usuario);


    }

    public String irIngresoMedicoUsuario() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irExamenFisicoIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_FISICO_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irImpDiagnosticaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irAnatPatologicaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANATOMIA_PATOLOGICA_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irControlSinCostoIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CONTROL_SIN_COSTO_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irFormulaMedicaIngresoMedico() {
       
        inicializarUsuario();
      
        return BeanNavegacion.RUTA_IR_FORMULA_MEDICA_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irRemHospitalizacionIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_HOSPITALIZACION_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irIncapacidadIngresoMedico() {
        inicializarUsuario();
        
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irInterConsultaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INTERCONSULTA_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irOrdenCirugiaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ORDEN_CIRUGIA_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irReferenciaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REFERENCIA_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irReservaSangreIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESERVA_SANGRE_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irRecomedacionIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RECOMENDACIONES_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irCertMedicoIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_MEDICO_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irCertAsistenciaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irExamElectrofisiologicoIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_ELECTROFISIOLOGICO_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irExamImagenIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_IMAGENES_INGRESO_MEDICO;
    }

    /**
     * @return
     */
    public String irExamLaboratorioIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_EXAMEN_LABORATORIOS_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irCerrarConsultaIngresoMedico() {
        
        if (numeroConsulta != null) {
            try {
                this.serviceLocator.getCirugiaService().closeIngresoMedico(numeroConsulta, 
                                                                           userName(), new Date());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            ListaCirugiasMedicoBean listaIngreso = (ListaCirugiasMedicoBean)FacesUtils.getManagedBean("listaCirugiasMedicoBean"); 
            listaIngreso.setEsIngresoMedico(true);
            listaIngreso.init();

            return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS;
        }
        return BeanNavegacion.RUTA_ACTUAL;

    }


    /**
     * @return
     */
    public String irFormularLiquidos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_LIQUIDOS_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irFormularMedicamentos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_HOSPITALIZACION_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irMedidasApoyo() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MEDIDAS_APOYO_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irMedicamentosEspeciales() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_ESPECIALES_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irResumenHistoriaEspecificaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_INGRESO_MEDICO;
    }


    /**
     * @return
     */
    public String irResumenHistoriaIngresoMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_CONTROL;
    }


    public void inicializarUsuario() {
        if (ingresoMedico != null && ingresoMedico.getCirugia() != null && 
            ingresoMedico.getCirugia().getHcplusuario() != null)
            this.setUsuario(ingresoMedico.getCirugia().getHcplusuario());
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


    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }
}
