package org.profamilia.hc.view.backing.menus.cirugia;

import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaEnfermeraBean;
import org.profamilia.hc.view.backing.cirugia.registro.ControlLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarCanalizacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaAldreteBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesPendientesBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaValoracionCaidasBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarResumenEnfermeriaCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuEnfermeriaBean extends BaseBean {

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private RegistrarNotaEnfermeriaBean notaEnfermeria;

    private ConsultarResumenEnfermeriaCirugiaBean resumen;

    private Chcirugprogr cirugia;

    private boolean renderAldrete;

    private boolean renderBromage;
    
    private boolean salidaCirugia;


    public void init() {

        renderAldrete = false;

        renderBromage = false;

        Chanestesia anestesiaAux = null;


        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");


        if (cirugia != null &&  notaEnfermeria.getCirugia() != null) {
            try {
                anestesiaAux = 
                        serviceLocator.getClinicoService().getEncabezadoRegistroAnestesia(notaEnfermeria.getCirugia().getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (anestesiaAux != null) {
                if (anestesiaAux.getHanctipoanest() != null) {
                    // 2 ES ANESTESIA GENERAL
                    if (anestesiaAux.getHanctipoanest().equals("2") || anestesiaAux.getHanctipoanest().equals("5") ) {
                        renderAldrete = true;

                        renderBromage = false;
                    }
                    // 4 ES ANESTESIA REGIONAL
                    else if (anestesiaAux.getHanctipoanest().equals("4")) {
                        renderAldrete = false;

                        renderBromage = true;
                    }
                }
            }else{
                FacesUtils.addErrorMessage("Paciente no tiene Registros Anestesicos Verificar");
            }
            

        }

        resumen = 
                (ConsultarResumenEnfermeriaCirugiaBean)FacesUtils.getManagedBean("consultarResumenEnfermeriaCirugiaBean");

        if (notaEnfermeria != null && notaEnfermeria.getCirugia() != null && 
            resumen != null) {
            resumen.setCodigoCirugia(notaEnfermeria.getCirugia().getHcplnumero());
        }

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
     * @return
     */
    public String irNotasEnfermeria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_INGRESO;
    }

    /**
     * @return
     */
    public String irIngresoLiquidos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA;
    }

    public String irSalidaEnfermeria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_SALIDA_ENFERMERIA;
    }

    /**
     * @return
     */
    public String irCerrarIngreso() {
        inicializarUsuario();
        return null;
    }


    /**
     * @return
     */
    public String irPreparacionPreoperatoria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INGRESO_ENFERMERIA;
    }


    public void inicializarUsuario() {
        /*      if (ingreso!= null &&  ingreso.getIngreso()!= null
           && ingreso.getIngreso().getHielusuario() != null)
           this.setUsuario(ingreso.getIngreso().getHielusuario());    */
    }


    public String irNotadeEnfermeria() {
        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }

    public String irConsultarNotas() {
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        resumen = 
                (ConsultarResumenEnfermeriaCirugiaBean)FacesUtils.getManagedBean("consultarResumenEnfermeriaCirugiaBean");
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        if (notaEnfermeria != null && notaEnfermeria.getCirugia() != null && 
            notaEnfermeria.getCirugia().getHcplnumero() != null) {

            ConsultarResumenEnfermeriaCirugiaBean consultar = 
                (ConsultarResumenEnfermeriaCirugiaBean)FacesUtils.getManagedBean("consultarResumenEnfermeriaCirugiaBean");

            consultar.setCodigoCirugia(notaEnfermeria.getCirugia().getHcplnumero());
            consultar.setUsuario(notaEnfermeria.getCirugia().getHcplusuario());
            consultar.consultarResumen();

            datosUsuario.setUsuario(notaEnfermeria.getCirugia().getHcplusuario());
            datosUsuario.inicializarUsuario();
            notaEnfermeria.setGeneroReporte(false);

            return BeanNavegacion.RUTA_IR_CONSULTAR_NOTAS_ENFERMERIA;
        }


        FacesUtils.addErrorMessage("Error!!! Consultando Notas de Enfermeria");
        return BeanNavegacion.RUTA_ACTUAL;
    }


    /**
     * @return
     */
    public String registrarLiquidos() {

        DatosBasicosUsuarioCirugiaBean datosUsuario;
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        ControlLiquidosBean control;
        control = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");

        if (control != null && cirugia != null) {
            control.setCirugia(cirugia);
            control.setEsIngreso(false);
            control.setNavegationRule(BeanNavegacion.RUTA_ACTUAL);
            control.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }
        notaEnfermeria.setGeneroReporte(false);
        return BeanNavegacion.RUTA_IR_CONTROL_LIQUIDOS;
    }
    
    /**
     * @return
     */
    public String otrasOrdenes() {

        DatosBasicosUsuarioCirugiaBean datosUsuario;
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        OtrasOrdenesPendientesBean control;
        control = 
                (OtrasOrdenesPendientesBean)FacesUtils.getManagedBean("otrasOrdenesPendientesBean");

        if (control != null && cirugia != null) {
            control.setCirugia(cirugia);
            control.setEsIngreso(false);
            control.setNavegationRule(BeanNavegacion.RUTA_ACTUAL);
            control.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }
        notaEnfermeria.setGeneroReporte(false);
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_PENDIENTE;
    }

    public String registrarBromage() {
        DatosBasicosUsuarioCirugiaBean datosUsuario;

        RegistrarEscalaAldreteBean aldrete = 
            (RegistrarEscalaAldreteBean)FacesUtils.getManagedBean("registrarEscalaAldreteBean");

        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        if (aldrete != null && cirugia != null) {
            aldrete.setCirugia(cirugia);
            aldrete.init();
        }


        return BeanNavegacion.RUTA_IR_BROMAGE_CONTROL;
    }

    /**
     * @return
     */
    public String registrarMedicamentos() {


        RegistrarMedicamentosBean medicamentosBean;
        medicamentosBean = null;
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        medicamentosBean = 
                (RegistrarMedicamentosBean)FacesUtils.getManagedBean("registrarMedicamentosBean");
        if (medicamentosBean != null && cirugia != null) {
            medicamentosBean.setCirugia(cirugia);
            medicamentosBean.init();
        }
        notaEnfermeria.setGeneroReporte(false);
        return BeanNavegacion.RUTA_IR_REGISTRO_MEDICAMENTOS;
    }


    /**
     * @return
     */
    public String registrarSignosVitales() {

        RegistrarSignosVitalesBean signosVitalesBean;
        DatosBasicosUsuarioCirugiaBean datosUsuario;

        FacesUtils.resetManagedBean("registrarSignosVitalesBean");
        notaEnfermeria = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
        signosVitalesBean = 
                (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");

        if (signosVitalesBean != null && cirugia != null) {
            signosVitalesBean.setCirugia(cirugia);
            signosVitalesBean.setEsIngreso(false);
            signosVitalesBean.init();
        }

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        notaEnfermeria.setGeneroReporte(false);
        return BeanNavegacion.RUTA_IR_SIGNOS_VITALES_CONTROL;
    }


    /**
     * @return
     */
    public String registrarCanalizacion() {


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
    

        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("consultarResumenEnfermeriaCirugiaBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
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

        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }

        if (menu != null && cirugia != null) {
            menu.setCirugia(cirugia);
            menu.init();
        }


        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_CONTROL;
    }


    public String registrarAldrete() {
        DatosBasicosUsuarioCirugiaBean datosUsuario;

        RegistrarEscalaAldreteBean aldrete = 
            (RegistrarEscalaAldreteBean)FacesUtils.getManagedBean("registrarEscalaAldreteBean");

        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


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
    
    
    
    public String irEscalaValoracionCaidasEnfermeria(){
        DatosBasicosUsuarioCirugiaBean datosUsuario;
        FacesUtils.resetManagedBean("registrarEscalaValoracionCaidasBean");
        RegistrarEscalaValoracionCaidasBean escala = 
            (RegistrarEscalaValoracionCaidasBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasBean");

        datosUsuario = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");


        if (datosUsuario != null) {
            datosUsuario.setUsuario(cirugia.getHcplusuario());
            datosUsuario.inicializarUsuario();
        }


        if (escala != null && cirugia != null) {
            escala.setCirugia(cirugia);
            escala.init();
        }

        return BeanNavegacion.RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS;
    }
    
    
    public String irConsultarFoliosUsuarioCirugia(){
    
        ConsultarFoliosUsuarioCirugiaEnfermeraBean consultarFolios =
            (ConsultarFoliosUsuarioCirugiaEnfermeraBean)FacesUtils.getManagedBean("consultarFoliosUsuarioCirugiaEnfermeraBean"); 
    
        if(consultarFolios != null){
            consultarFolios.setUsuario(usuario);
            consultarFolios.setNumeroUsuario(usuario.getHuslnumero());
            consultarFolios.init();
        
            
        }
        return BeanNavegacion.RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_ENFERMERA;
    }
    
    
    
    public String volverListadoEnfermeria(){
        return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
    }



    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    public void setRenderAldrete(boolean renderAldrete) {
        this.renderAldrete = renderAldrete;
    }

    public boolean isRenderAldrete() {
        return renderAldrete;
    }


    public void setRenderBromage(boolean renderBromage) {
        this.renderBromage = renderBromage;
    }

    public boolean isRenderBromage() {
        return renderBromage;
    }
    
    /**
     * @return
     */
    public String registrarLiquidosIngreso() {
           return BeanNavegacion.RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA;
        }
        
        
        /**
         * @return
         */
        public String registrarMedicamentosIngreso() {
            return BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS;
        }
        
        /**
         * @return
         */
        public String registrarNotasEnfermeriaIngreso() {
            return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_INGRESO;
        }
        
        /**
         * @return
         */
        public String registrarSignosVitalesIngreso() {
            return BeanNavegacion.RUTA_IR_INGRESO_SIGNOS_VITALES;
        }


    public void setSalidaCirugia(boolean salidaCirugia) {
        this.salidaCirugia = salidaCirugia;
    }

    public boolean isSalidaCirugia() {
        return salidaCirugia;
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ENFERMERIA;
    }

}


