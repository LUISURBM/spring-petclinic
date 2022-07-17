package org.profamilia.hc.view.backing.menus.consultorio;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.clinico.consultorio.RegistrarNotaMedicaBean;
import org.profamilia.hc.view.backing.clinico.consultorio.RegistrarPAPsicologiaBean;
import org.profamilia.hc.view.backing.comun.AplicacionDispositivoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.EncuestaViolenciaSivigilaBean;
import org.profamilia.hc.view.backing.comun.ExamenFisicoUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
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
import org.profamilia.hc.view.backing.comun.conducta.ReferenciaUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.ReservaSangreUsuarioBean;
import org.profamilia.hc.view.backing.comun.conducta.VademecumMedicoBean;
import org.profamilia.hc.view.backing.comun.resumen.ResumenHistoriaEspecificaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.ExpandableTreeModel;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuPAPsicologiaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private RegistrarPAPsicologiaBean registrarNotaMedicaBean;

    private boolean renderConsultaFolios;

    private AnatomiaPatologicaUsuarioBean anatomiaPatologicaUsuarioBean;

    private ControlSinCostoUsuarioBean controlSinCostoUsuarioBean;

    private FormulaMedicaUsuarioBean formulaMedicaUsuarioBean;

    private HospitalizacionUsuarioBean hospitalizacionUsuarioBean;

    private OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean;

    private InterConsultaUsuarioBean interConsultaUsuarioBean;

    private IncapacidadUsuarioBean incapacidadUsuarioBean;

    private ReferenciaUsuarioBean referenciaUsuarioBean;

    private ReservaSangreUsuarioBean reservaSangreUsuarioBean;

    private CertMedicoUsuarioBean certMedicoUsuarioBean;

    private CertAsistenciaUsuarioBean certAsistenciaUsuarioBean;

    private ExamElectrofisiologicoUsuarioBean examElectrofisiologicoUsuarioBean;

    private ExamImagenUsuarioBean examImagenUsuarioBean;

    private ExamLaboratorioUsuarioBean examLaboratorioUsuarioBean;


    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private ResumenHistoriaEspecificaBean resumenEspecifico;

    private AplicacionDispositivoBean dispositivos;

    private AutorizacionServicioUsuarioBean autorizacionServicioUsuarioBean;

    private VademecumMedicoBean vademecumUsuarioBean;

    private boolean renderVademecum;

    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;

    private OtrasOrdenesBean otrasOrdenesBean;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderConducta;

    private boolean renderCerrarConsulta;

    private boolean renderControl;

    private ExpandableTreeModel trnhistoria;

    private Long numeroConsulta;

    private String cie10Principal;

    private String cie10Relacionado1;

    private String codigoCups;

    private boolean primeraConsulta;

    private Chimprdiag impresion;

    private Chmotivocon motivo;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;

    private boolean renderOrdenesMedicas;

    private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
    private boolean renderServiciosAdmision;

    private boolean renderCovid;
    
    private EncuestaViolenciaSivigilaBean encuestaViolenciaSivigila;
    
    private Cnconsclin consulta;
    
    private boolean renderSalir;


    public void init() {
        renderConsultaFolios = false;
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        registrarNotaMedicaBean = 
                (RegistrarPAPsicologiaBean)FacesUtils.getManagedBean("registrarPAPsicologiaBean");
                
        numeroConsulta = registrarNotaMedicaBean.getConsulta().getHcolnumero();
        
      renderSalir = registrarNotaMedicaBean.isNotaRealizada();
        
        if (registrarNotaMedicaBean.getConsulta() != null && registrarNotaMedicaBean.getConsulta().getHcolnumero() != null) {

            try {
                consulta = 
                        this.serviceLocator.getClinicoService().getConsultaClinicaPorId(registrarNotaMedicaBean.getConsulta().getHcolnumero().toString());
                        
                if(consulta != null){
                    datosBasicosUsuario.setConsulta(consulta);
                }        
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (datosBasicosUsuario.getUsuario() != null) {
            datosBasicosUsuario.setUsuario(registrarNotaMedicaBean.getConsulta().getHcolusuario());
            datosBasicosUsuario.inicializarUsuario();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaI = 
            dateFormat.format(registrarNotaMedicaBean.getConsulta().getHcodfeccierre());
        String fechaF = dateFormat.format(new Date());

        if (fechaI.equals(fechaF)) {
            renderConsultaFolios = true;
        }

        String tensionArterial = null;
        Integer frecuenciaCardiaca = null;
        Integer frecuenciaRespiratoria = null;
        BigDecimal peso = null;
        String hallazgos = null;
        BigDecimal temperatura = null;

        renderOrdenesMedicas = true;
        renderServiciosAdmision = false;

        boolean renderMasculino;
        renderMasculino = false;

        renderVademecum = true;
        
        


     //RESUMEN DE LA HISTORIA CLINICA

        resumenEspecifico = 
                (ResumenHistoriaEspecificaBean)FacesUtils.getManagedBean("resumenHistoriaEspecificaBean");
        resumenEspecifico.setUsuario(datosBasicosUsuario.getUsuario());


      }

    /**
     * @return
     */
    public String irDatosNotaAclaratoria() {
        return BeanNavegacion.RUTA_REGISTRAR_NOTA_MEDICA;
    }

    /**
     * @return
     */
    public String irResumenHistoriaNotaAclaratoria() {
        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
        if (generarResumen != null) {
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(registrarNotaMedicaBean.getConsulta().getHcolusuario());
            generarResumen.setNumeroConsulta(registrarNotaMedicaBean.getConsulta().getHcolnumero());
            generarResumen.consultarFoliosUsuarioNotaAclaratoria();

        }
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_NOTA_ACLARATORIA;
    }

    public void setRenderConsultaFolios(boolean renderConsultaFolios) {
        this.renderConsultaFolios = renderConsultaFolios;
    }

    public boolean isRenderConsultaFolios() {
        return renderConsultaFolios;
    }

  
    /**
     * @return
     */
    public String irFormulaMedicaNotaAclaratoria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FORMULAMEDICA_NOTA_ACLARATORIA;
    }


    
    /**
     * @return
     */
    public String irSalir() {
        inicializarUsuario();
        FacesUtils.resetManagedBean("registrarNotaMedicaBean");
        FacesUtils.resetManagedBean("consultarFoliosNotaBean");
        FacesUtils.resetManagedBean("consultarUsuarioNotaMedicaBean");
        return BeanNavegacion.RUTA_IR_INICIO;
    }
    

    public void inicializarUsuario() {

        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
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
     * @param renderControl
     */
    public void setRenderControl(boolean renderControl) {
        this.renderControl = renderControl;
    }

    /**
     * @param primeraConsulta
     */
    public void setPrimeraConsulta(boolean primeraConsulta) {
        this.primeraConsulta = primeraConsulta;
    }

    /**
     * @return
     */
    public boolean isPrimeraConsulta() {
        return primeraConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderNotaAclaratoria() {
        return renderControl;
    }

    /**
     * @param trnhistoria
     */
    public void setTrnhistoria(ExpandableTreeModel trnhistoria) {
        this.trnhistoria = trnhistoria;
    }

   

  
    public void setRenderSalir(boolean renderSalir) {
        this.renderSalir = renderSalir;
    }

    public boolean isRenderSalir() {
        return renderSalir;
    }
}
