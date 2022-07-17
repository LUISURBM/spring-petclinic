package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.registro.ControlLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCanalizacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaAldreteBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuEnfermeriaBean;
import org.profamilia.hc.view.util.FacesUtils;

public class ConsultarListaNotasEnfermeria extends BaseBean {

    private List<Chcirugprogr> lstCirugiasIngresadasQuirofano;

    private List<Chcirugprogr> lstCirugiasIngresadasEnfermeria;
    
    private List<Chcirugprogr> lstCirugiasEnRecuperacion;

    private HtmlDataTable dtCirugia;

    private HtmlDataTable dtCirugiaQuirofano;
    
    private HtmlDataTable dtCirugiaRecuperacion;

    private Chdetacirpro detaciru;

    private Long numeroConsulta;

    private String nombreServicio;

    private List<Chcirugprogr> lstCirugiasCompleta;
    
    private List<Chcirugprogr> lstCirugiasCompletaQuirofano;
    
    private List<Chcirugprogr> lstCirugiasCompletaRecuperacion;

    private Cpservicio servicio;
    
    private Chcirugprogr orden;
    
    private List<Chcirugprogr> lstCirugiasSiguiente;
    
    private Date fechaHoy; 


    public ConsultarListaNotasEnfermeria() {
    }

    public void init() {
        lstCirugiasIngresadasEnfermeria = new ArrayList<Chcirugprogr>();
        lstCirugiasIngresadasQuirofano = new ArrayList<Chcirugprogr>();
        lstCirugiasCompleta = new ArrayList<Chcirugprogr>();
        lstCirugiasCompletaQuirofano = new ArrayList<Chcirugprogr>();
        lstCirugiasSiguiente = new ArrayList<Chcirugprogr>();
        lstCirugiasEnRecuperacion = new ArrayList<Chcirugprogr>();
        lstCirugiasCompletaRecuperacion = new ArrayList<Chcirugprogr>();
        cargarCirugias();
    }

    public void cargarCirugias() {
        
        fechaHoy = new Date();
      
        cargarListasCirugia(fechaHoy);
    }
    
    
    
    public void cargarListasCirugia(Date fecha){
        try {
             lstCirugiasIngresadasEnfermeria = 
             this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(), 
                                                                                   ETAPA_CIRUGIA_PENDIENTE_QUIROFANO,null,fecha,getUsuarioSystem().getCurnprofes());

             lstCirugiasIngresadasQuirofano = 
             this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(), 
                                                                                     ETAPA_CIRUGIA_EN_QUIROFANO, null,fecha,getUsuarioSystem().getCurnprofes());
                                                                                     
             lstCirugiasEnRecuperacion = 
             this.serviceLocator.getClinicoService().getCirugiasProgramadasActivas(getClinica().getCclncodigo(), 
                                                                                     ETAPA_CIRUGIA_EN_RECUPERACION, null,fecha,getUsuarioSystem().getCurnprofes());
                                                                                     
                                                                                     

         } catch (ModelException e) {
             e.printStackTrace();
         }
         


    }


    /**
     * @param dtCirugia
     */
    public void setDtCirugia(HtmlDataTable dtCirugia) {
        this.dtCirugia = dtCirugia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugia() {
        return dtCirugia;
    }


    /**
     * @return
     */
    public String registrarLiquidos() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugia.getRowData();
        DatosBasicosUsuarioBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        ControlLiquidosBean control;
        control = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");


        MenuEnfermeriaBean menu = 
            (MenuEnfermeriaBean)FacesUtils.getManagedBean("menuEnfermeriaBean");

        if (control != null && cirugia != null) {
            control.setCirugia(cirugia);
            control.setEsIngreso(false);
            control.setNavegationRule(BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA);
            control.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.init();
        }

        return BeanNavegacion.RUTA_IR_CONTROL_LIQUIDOS;
    }


    /**
     * @return
     */
    public String registrarLiquidosQuirofano() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();
        DatosBasicosUsuarioBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        ControlLiquidosBean control;
        control = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");


        MenuEnfermeriaBean menu = 
            (MenuEnfermeriaBean)FacesUtils.getManagedBean("menuEnfermeriaBean");

        if (control != null && cirugia != null) {
            control.setCirugia(cirugia);
            control.setEsIngreso(false);
            control.setNavegationRule(BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA);
            control.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.init();
        }

        return BeanNavegacion.RUTA_IR_CONTROL_LIQUIDOS;
    }
    
    
    
    
    
    
    /**
     * @return
     */
    public String registrarLiquidosRecuperacion() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();
        DatosBasicosUsuarioBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        ControlLiquidosBean control;
        control = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");


        MenuEnfermeriaBean menu = 
            (MenuEnfermeriaBean)FacesUtils.getManagedBean("menuEnfermeriaBean");

        if (control != null && cirugia != null) {
            control.setCirugia(cirugia);
            control.setEsIngreso(false);
            control.setNavegationRule(BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA);
            control.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.init();
        }

        return BeanNavegacion.RUTA_IR_CONTROL_LIQUIDOS;
    }

    
    
    
    


    /**
     * @return
     */
    public String registrarMedicamentos() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugia.getRowData();

        RegistrarMedicamentosBean medicamentosBean;
        medicamentosBean = null;
        medicamentosBean = 
                (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
        if (medicamentosBean != null && cirugia != null) {
            medicamentosBean.setCirugia(cirugia);
            medicamentosBean.init();
        }

        return BeanNavegacion.RUTA_IR_REGISTRO_MEDICAMENTOS;
    }


    /**
     * @return
     */
    public String registrarMedicamentosQuirofano() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();

        RegistrarMedicamentosBean medicamentosBean;
        medicamentosBean = null;
        medicamentosBean = 
                (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
        if (medicamentosBean != null && cirugia != null) {
            medicamentosBean.setCirugia(cirugia);
            medicamentosBean.init();
        }

        return BeanNavegacion.RUTA_IR_REGISTRO_MEDICAMENTOS;
    }


    /**
     * @return
     */
    public String registrarSignosVitales() {
        Chcirugprogr cirugiaSelect = null;
        cirugiaSelect = (Chcirugprogr)dtCirugia.getRowData();
        RegistrarSignosVitalesBean signosVitalesBean;
        DatosBasicosUsuarioBean datosUsuario;

        FacesUtils.resetManagedBean("registrarSignosVitalesBean");

        signosVitalesBean = 
                (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        if (signosVitalesBean != null && cirugiaSelect != null) {
            signosVitalesBean.setCirugia(cirugiaSelect);
            signosVitalesBean.setEsIngreso(false);
            signosVitalesBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugiaSelect.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        return BeanNavegacion.RUTA_IR_SIGNOS_VITALES_CONTROL;
    }


    /**
     * @return
     */
    public String registrarSignosVitalesQuirofano() {
        Chcirugprogr cirugiaSelect = null;
        cirugiaSelect = (Chcirugprogr)dtCirugiaQuirofano.getRowData();
        RegistrarSignosVitalesBean signosVitalesBean;
        DatosBasicosUsuarioBean datosUsuario;

        FacesUtils.resetManagedBean("registrarSignosVitalesBean");

        signosVitalesBean = 
                (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        if (signosVitalesBean != null && cirugiaSelect != null) {
            signosVitalesBean.setCirugia(cirugiaSelect);
            signosVitalesBean.setEsIngreso(false);
            signosVitalesBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugiaSelect.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        return BeanNavegacion.RUTA_IR_SIGNOS_VITALES_CONTROL;
    }


    /**
     * @return
     */
    public String registrarCanalizacion() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugia.getRowData();
        RegistrarCanalizacionBean canalizacionBean;

        canalizacionBean = 
                (RegistrarCanalizacionBean)FacesUtils.getManagedBean("registrarCanalizacionBean");

        if (canalizacionBean != null && cirugia != null) {
            canalizacionBean.setCirugia(cirugia);
            canalizacionBean.setEsIngreso(false);
            canalizacionBean.init();
        }


        return BeanNavegacion.RUTA_IR_CANALIZACION_CONTROL;
    }


    /**
     * @return
     */
    public String registrarCanalizacionQuirofano() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();
        RegistrarCanalizacionBean canalizacionBean;

        canalizacionBean = 
                (RegistrarCanalizacionBean)FacesUtils.getManagedBean("registrarCanalizacionBean");

        if (canalizacionBean != null && cirugia != null) {
            canalizacionBean.setCirugia(cirugia);
            canalizacionBean.setEsIngreso(false);
            canalizacionBean.init();
        }


        return BeanNavegacion.RUTA_IR_CANALIZACION_CONTROL;
    }

    /**
     * @return
     */
    public String registrarNotasEnfermeria() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugia.getRowData();

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        FacesUtils.resetManagedBean("consultarResumenEnfermeriaCirugiaBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

        MenuEnfermeriaBean menu = 
            (MenuEnfermeriaBean)FacesUtils.getManagedBean("menuEnfermeriaBean");

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.init();
        }

        if (datosUsuario != null && encabezado != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        if (menu != null && cirugia != null) {
            menu.setUsuario(cirugia.getHcplusuario());
            menu.setCirugia(cirugia);
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }


    /**
     * @return
     */
    public String registrarNotasEnfermeriaQuirofano() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        FacesUtils.resetManagedBean("consultarResumenEnfermeriaCirugiaBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

        MenuEnfermeriaBean menu = 
            (MenuEnfermeriaBean)FacesUtils.getManagedBean("menuEnfermeriaBean");

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.init();
        }

        if (datosUsuario != null && encabezado != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        if (menu != null && cirugia != null) {
            menu.setUsuario(cirugia.getHcplusuario());
            menu.setCirugia(cirugia);
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }
    
    
    /**
     * @return
     */
    public String registrarNotasEnfermeriaRecuperacion() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        FacesUtils.resetManagedBean("consultarResumenEnfermeriaCirugiaBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");

        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

        MenuEnfermeriaBean menu = 
            (MenuEnfermeriaBean)FacesUtils.getManagedBean("menuEnfermeriaBean");

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.init();
        }

        if (datosUsuario != null && encabezado != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
            encabezado.setCirugia(cirugia);
            encabezado.inicializarCirugiasProgramadas();
        }

        if (menu != null && cirugia != null) {
            menu.setUsuario(cirugia.getHcplusuario());
            menu.setCirugia(cirugia);
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }



    public String registrarSalidaEnfermeria() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugia.getRowData();

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.setEsSalida(true);
            notaBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }
    
    
    public String registrarSalidaEnfermeriaRecuperacion() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaRecuperacion.getRowData();
         boolean existeEpicrisis;
        try {
            existeEpicrisis = this.serviceLocator.getCirugiaService().existeEpicrisis(cirugia.getHcplnumero());
            if(existeEpicrisis){
            FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
            DatosBasicosUsuarioCirugiaBean datosUsuario;
            datosUsuario = 
                    (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
            RegistrarNotaEnfermeriaBean notaBean;
            notaBean = 
                    (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

            if (notaBean != null && cirugia != null) {
                notaBean.setCirugia(cirugia);
                notaBean.setEsIngreso(false);
                notaBean.setEsSalida(true);
                notaBean.init();
            }

            if (datosUsuario != null) {
                datosUsuario.setUsuario(cirugia.getHcplusuario());
                datosUsuario.inicializarUsuario();
            }
            }
            else{
                FacesUtils.addErrorMessage("Registre la epicrisis antes de dar el alta m�dica");
                return null;
            }
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
            e.printStackTrace();
            return null;
        }
      

        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }
    
    
    
    


    public String registrarSalidaEnfermeriaQuirofano() {
        Chcirugprogr cirugia = null;
        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();

        FacesUtils.resetManagedBean("datosBasicosUsuarioCirugiaBean");
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        RegistrarNotaEnfermeriaBean notaBean;
        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

        if (notaBean != null && cirugia != null) {
            notaBean.setCirugia(cirugia);
            notaBean.setEsIngreso(false);
            notaBean.setEsSalida(true);
            notaBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }


    public String registrarAldrete() {
        DatosBasicosUsuarioBean datosUsuario;
        Chcirugprogr cirugia = null;
        RegistrarEscalaAldreteBean aldrete = 
            (RegistrarEscalaAldreteBean)FacesUtils.getManagedBean("registrarEscalaAldreteBean");

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        cirugia = (Chcirugprogr)dtCirugia.getRowData();

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        if (aldrete != null && cirugia != null) {
            aldrete.setCirugia(cirugia);
            aldrete.init();
        }


        return BeanNavegacion.RUTA_IR_ALDRETE_CONTROL;
    }


    public String registrarAldreteQuirofano() {
        DatosBasicosUsuarioBean datosUsuario;
        Chcirugprogr cirugia = null;
        RegistrarEscalaAldreteBean aldrete = 
            (RegistrarEscalaAldreteBean)FacesUtils.getManagedBean("registrarEscalaAldreteBean");

        datosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        cirugia = (Chcirugprogr)dtCirugiaQuirofano.getRowData();

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        if (aldrete != null && cirugia != null) {
            aldrete.setCirugia(cirugia);
            aldrete.init();
        }


        return BeanNavegacion.RUTA_IR_ALDRETE_CONTROL;
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

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setLstCirugiasCompleta(List<Chcirugprogr> lstCirugiasCompleta) {
        this.lstCirugiasCompleta = lstCirugiasCompleta;
    }

    public List<Chcirugprogr> getLstCirugiasCompleta() {
        return lstCirugiasCompleta;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setLstCirugiasIngresadasEnfermeria(List<Chcirugprogr> lstCirugiasIngresadasEnfermeria) {
        this.lstCirugiasIngresadasEnfermeria = lstCirugiasIngresadasEnfermeria;
    }

    public List<Chcirugprogr> getLstCirugiasIngresadasEnfermeria() {
        return lstCirugiasIngresadasEnfermeria;
    }

    public void setLstCirugiasIngresadasQuirofano(List<Chcirugprogr> lstCirugiasIngresadasQuirofano) {
        this.lstCirugiasIngresadasQuirofano = lstCirugiasIngresadasQuirofano;
    }

    public List<Chcirugprogr> getLstCirugiasIngresadasQuirofano() {
        return lstCirugiasIngresadasQuirofano;
    }

    public void setDtCirugiaQuirofano(HtmlDataTable dtCirugiaQuirofano) {
        this.dtCirugiaQuirofano = dtCirugiaQuirofano;
    }

    public HtmlDataTable getDtCirugiaQuirofano() {
        return dtCirugiaQuirofano;
    }

    public void setLstCirugiasCompletaQuirofano(List<Chcirugprogr> lstCirugiasCompletaQuirofano) {
        this.lstCirugiasCompletaQuirofano = lstCirugiasCompletaQuirofano;
    }

    public List<Chcirugprogr> getLstCirugiasCompletaQuirofano() {
        return lstCirugiasCompletaQuirofano;
    }

    public void setOrden(Chcirugprogr orden) {
        this.orden = orden;
    }

    public Chcirugprogr getOrden() {
        return orden;
    }

    public void setLstCirugiasSiguiente(List<Chcirugprogr> lstCirugiasSiguiente) {
        this.lstCirugiasSiguiente = lstCirugiasSiguiente;
    }

    public List<Chcirugprogr> getLstCirugiasSiguiente() {
        return lstCirugiasSiguiente;
    }

    public void setDtCirugiaRecuperacion(HtmlDataTable dtCirugiaRecuperacion) {
        this.dtCirugiaRecuperacion = dtCirugiaRecuperacion;
    }

    public HtmlDataTable getDtCirugiaRecuperacion() {
        return dtCirugiaRecuperacion;
    }

    public void setLstCirugiasEnRecuperacion(List<Chcirugprogr> lstCirugiasEnRecuperacion) {
        this.lstCirugiasEnRecuperacion = lstCirugiasEnRecuperacion;
    }

    public List<Chcirugprogr> getLstCirugiasEnRecuperacion() {
        return lstCirugiasEnRecuperacion;
    }

    public void setLstCirugiasCompletaRecuperacion(List<Chcirugprogr> lstCirugiasCompletaRecuperacion) {
        this.lstCirugiasCompletaRecuperacion = lstCirugiasCompletaRecuperacion;
    }

    public List<Chcirugprogr> getLstCirugiasCompletaRecuperacion() {
        return lstCirugiasCompletaRecuperacion;
    }

    public void setFechaHoy(Date fechaHoy) {
        this.fechaHoy = fechaHoy;
    }

    public Date getFechaHoy() {
        return fechaHoy;
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setFechaHoy(ValueChangeEvent valueChangeEvent) {
        setFechaHoy((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    public void changeCirugia() {
        if (fechaHoy!= null && getClinica() != null) {
                cargarListasCirugia(fechaHoy);
            } 
        }
    
}
