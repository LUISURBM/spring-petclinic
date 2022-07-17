package org.profamilia.hc.view.backing.menus.cirugia;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.DescripcionQuirurgicaBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.conducta.ControlSinCostoUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.FormulaMedicaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.IncapacidadUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.view.util.FacesUtils;

public class MenuDescripcionBean extends BaseBean {

    private DescripcionQuirurgicaBean descripcionMedico;

    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;

    private VademecumMedicoBean vademecumUsuarioBean;

    private IncapacidadUsuarioBean incapacidadUsuarioBean;
    
    private List<Chformulamed> lstPrescripciones;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private Long numeroConsulta;

    private Long numeroUsuario;

    private Integer consecutivo;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private boolean renderConducta;

    private boolean ligadura;

    private boolean vasectomia;

    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulahos> lstPrescripcionesVasectomia;

    private boolean renderDescripcion;

    private OtrasOrdenesBean otrasOrdenesBean;

    public void init() {

        consecutivo = new Integer("0");
        codigoCups = "";
        ligadura = false;
        vasectomia = false;

        lstPrescripcionesVasectomia = new ArrayList<Chformulahos>();

        descripcionMedico = 
                (DescripcionQuirurgicaBean)FacesUtils.getManagedBean("descripcionQuirurgicaBean");

        if (descripcionMedico != null && 
            descripcionMedico.getNumeroConsulta() != null) {
            numeroConsulta = descripcionMedico.getNumeroConsulta();
        }

        if (descripcionMedico != null && 
            descripcionMedico.getLstDetalleCirugias() != null && 
            !descripcionMedico.getLstDetalleCirugias().isEmpty()) {
            List<Chdetacirpro> lstCirugia = 
                descripcionMedico.getLstDetalleCirugias();
            Chdetacirpro serc = lstCirugia.get(0);
            if (serc != null) {
                codigoCups = serc.getId().getHdccservicio();
            }
            if (codigoCups != null && !codigoCups.equals("")) {
                Cpservicio servAux = null;
                try {
                    servAux = 
                            serviceLocator.getClinicoService().getDescripcionCupsCompleto(codigoCups);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (servAux != null && servAux.getCsvntiphis() != null && 
                    servAux.getCsvntiphis().equals(CIRUGIA_LIGADURA_POR_BIPOLAR)) {
                    ligadura = true;
                } else {
                    ligadura = false;
                }
               
            }
        }
        renderDescripcion = descripcionMedico.esValido();
        if (descripcionMedico != null && 
            descripcionMedico.getNumeroUsuario() != null) {
            numeroUsuario = descripcionMedico.getNumeroUsuario();
        }
        
        if(descripcionMedico != null && descripcionMedico.getDescripcion() != null
        && descripcionMedico.getDiagnosticoPreoperatorio() != null){
            cie10Principal = descripcionMedico.getDiagnosticoPreoperatorio();
        }
        
       
        
        // CONDUCTA - CONTROL SIN COSTO
        try {
            if (numeroUsuario != null) {
                usuario = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        controlSinCostoUsuarioBean = 
                (ControlSinCostoUsuarioBean)FacesUtils.getManagedBean("controlSinCostoUsuarioBean");
        controlSinCostoUsuarioBean.setUsuario(usuario);
        controlSinCostoUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        controlSinCostoUsuarioBean.setCodigoCups(codigoCups);
        controlSinCostoUsuarioBean.setNumeroConsulta(numeroConsulta);
        controlSinCostoUsuarioBean.setMenuBean("menuDescripcionBean");
        controlSinCostoUsuarioBean.inicializarControlSinCosto();

        // CONDUCTA - FORMULA MEDICA

       
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

        formulaMedicaUsuarioBean =
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(usuario);
        formulaMedicaUsuarioBean.setEsCirugia(true);
        formulaMedicaUsuarioBean.setConsecutivo(consecutivo);
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setLstPrescripcionesDefecto(lstPrescripciones);
        formulaMedicaUsuarioBean.setCodigoCIE10(descripcionMedico.getDetalleDescripcion().getHddcdiagnprinc());
        formulaMedicaUsuarioBean.setMenuBean("menuDescripcionBean");
        formulaMedicaUsuarioBean.setLigadura(ligadura);
        formulaMedicaUsuarioBean.inicializardFormulaMedica();

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
        incapacidadUsuarioBean.setMenuBean("menuDescripcionBean");
        incapacidadUsuarioBean.inicializarIncapacidad();

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
        formulaHospitalizacionBean.setLstPrescripcionesVasectomia(lstPrescripcionesVasectomia);
        formulaHospitalizacionBean.init();

        otrasOrdenesBean = 
                (OtrasOrdenesBean)FacesUtils.getManagedBean("otrasOrdenesBean");

        //otrasOrdenesBean.setCirugia(evolucionMedico.getCirugia());
        otrasOrdenesBean.setConsecutivo(consecutivo);
        otrasOrdenesBean.setNumeroConsulta(numeroConsulta);
        otrasOrdenesBean.setTipoServicio(TIPO_HOSPITALIZACION);
        otrasOrdenesBean.init();
    }


    public String irdescripcionMedicoUsuario() throws ModelException {
        Cpservicio s = null;
        String codigoSer;
        if (descripcionMedico != null &&  descripcionMedico.getLstDetalleCirugias().size() > 1) {
        for (int i = 0;  i < descripcionMedico.getLstDetalleCirugias().size(); i++) {
                Chdetacirpro detaciru =  (Chdetacirpro)descripcionMedico.getLstDetalleCirugias().get(i);
                codigoSer = detaciru.getId().getHdccservicio();
                s = serviceLocator.getClinicoService().getDescripcionCupsCompleto(codigoSer);
                
                if (s != null) {
                    break;
                }
        }
 
            if (56 != s.getCsvntiphis()) {
                return BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA;
            } else {
                return BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA_HISTE;
            }
        }
        else{
        if(descripcionMedico.getServicio() !=null){
            if (descripcionMedico.getServicio() !=null && descripcionMedico.getServicio().getCsvntiphis() != 56) {
                return BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA;
            } else {
                return BeanNavegacion.RUTA_REGISTRAR_DESCRIPCION_QUIRURGICA_HISTE;
            }
        }
       return "";
        }
    }

    /**
     * @return
     */
    public String irControlSinCostodescripcionMedico() {
        return BeanNavegacion.RUTA_IR_CONTROL_SIN_COSTO_DESCRIPCION_QX;
    }

    /**
     * @return
     */
    public String irFormulaMedicadescripcionMedico() {
        formulaMedicaUsuarioBean =
                (FormulaMedicaUsuarioBean)FacesUtils.getManagedBean("formulaMedicaUsuarioBean");
        formulaMedicaUsuarioBean.setUsuario(usuario);
        formulaMedicaUsuarioBean.setEsCirugia(true);
        formulaMedicaUsuarioBean.setConsecutivo(consecutivo);
        formulaMedicaUsuarioBean.setTipoServicio(TIPO_HOSPITALIZACION);
        formulaMedicaUsuarioBean.setNumeroConsulta(numeroConsulta);
        formulaMedicaUsuarioBean.setLstPrescripcionesDefecto(lstPrescripciones);
        formulaMedicaUsuarioBean.setCodigoCIE10(descripcionMedico.getDetalleDescripcion().getHddcdiagnprinc());
        formulaMedicaUsuarioBean.setMenuBean("menuDescripcionBean");
        formulaMedicaUsuarioBean.setLigadura(ligadura);
        formulaMedicaUsuarioBean.inicializardFormulaMedica();
        return BeanNavegacion.RUTA_IR_FORMULA_MEDICA_DESCRIPCION_QX;
    }

    /**
     * @return
     */
    public String irIncapacidaddescripcionMedico() {
        return BeanNavegacion.RUTA_IR_INCAPACIDAD_DESCRIPCION_QX;
    }


    public void setRenderConducta(boolean renderConducta) {
        this.renderConducta = renderConducta;
    }

    public boolean isRenderConducta() {
        return renderConducta;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public String irConsultarFoliosUsuarioCirugia() {

        ConsultarFoliosUsuarioCirugiaBean consultarFolios = 
            (ConsultarFoliosUsuarioCirugiaBean)FacesUtils.getManagedBean("consultarFoliosUsuarioCirugiaBean");
        if (consultarFolios != null) {
            consultarFolios.setUsuario(usuario);
            consultarFolios.setNumeroUsuario(usuario.getHuslnumero());
            consultarFolios.init();
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_FOLIOS_USUARIO_CIRUGIA_DQX;
    }

    /**
     * @return
     */
    public String irResumenHistoriaTotal() {

        FacesUtils.resetManagedBean("consultarFoliosBean");
        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(usuario);
            generarResumen.consultarFoliosUsuario();
        }
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_DESCRIPCION_CIRUGIA;
    }


    /**
     * @return
     */
    public String irFormularLiquidosDescripcionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_LIQUIDOS_DESCRIPCION_MEDICO;
    }

    /**
     * @return
     */
    public String irFormularMedicamentosDescripcionMedico() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULA_HOSPITALIZACION_DESCRIPCION_MEDICO;
    }

    public String irRegistrarOtrasOrdenes() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_DESCRIPCION_MEDICO;
    }

    public void inicializarUsuario() {
        if (descripcionMedico != null && 
            descripcionMedico.getCirugiaProgra() != null && 
            descripcionMedico.getCirugiaProgra().getHcplusuario() != null)
            this.setUsuario(descripcionMedico.getCirugiaProgra().getHcplusuario());
    }

    public String volverListadoDescricpion() {
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_DESCRIPCION_QUIRURGICA;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setRenderDescripcion(boolean renderDescripcion) {
        this.renderDescripcion = renderDescripcion;
    }

    public boolean isRenderDescripcion() {
        return renderDescripcion;
    }
}
