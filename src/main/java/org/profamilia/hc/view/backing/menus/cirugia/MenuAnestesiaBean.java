package org.profamilia.hc.view.backing.menus.cirugia;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarAnetesiaBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaHospitalizacionBean;
import org.profamilia.hc.view.backing.clinico.conducta.FormulaLiquidosBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuAnestesiaBean extends BaseBean {

    private boolean renderOtrasCirugias;
    private boolean ligadura;
    private Chusuario usuario;
    private Long numeroUsuario;
    private Long numeroConsulta;
    private Integer consecutivo;
    private Chcirugprogr cirugia;
    private boolean renderTecnica;
    
    private boolean esValidoAnestesia;
    
    private FormulaLiquidosBean formulaLiquidosBean;

    private FormulaHospitalizacionBean formulaHospitalizacionBean;
    
    private OtrasOrdenesBean otrasOrdenesBean;

    public MenuAnestesiaBean() {
    }


    public void init() {

        if (usuario == null) {
            usuario = new Chusuario();

        }
        if (cirugia == null) {
            cirugia = new Chcirugprogr();
        }
        
        if(renderOtrasCirugias){
            renderTecnica = true;
        }else{
            renderTecnica= false;
        }
        
        consecutivo = 999;
        
        esValidoAnestesia = false;
        RegistrarAnetesiaBean encabezado = new RegistrarAnetesiaBean();
        
        // MOTIVO DE CONSULTA
        encabezado = (RegistrarAnetesiaBean)FacesUtils.getManagedBean("registrarAnetesiaBean");
        encabezado.setCirugia(cirugia);
        esValidoAnestesia= encabezado.esValido();
        


        if (encabezado != null && 
            encabezado.getCirugia() != null && encabezado.getCirugia().getHcplnumero() != null) {
            numeroConsulta = encabezado.getCirugia().getHcplnumero();
        }
        
        
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
        formulaHospitalizacionBean.setRenderAnalgesiaPosoperatoria(true);
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
        

    }

    /**
     * @return
     */
    public String irMonitoria() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_MONITORIA_ANESTESIA;
    }

    /**
     * @return
     */
    public String irSignosVitales() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_SIGNOS_VITALES_ANESTESIA;
    }

    /**
     * @return
     */
    public String irBalanceLiquidos() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_BALANCE_LIQUIDOS_ANESTESIA;
    }

    /**
     * @return
     */
    public String irControlMedicamentos() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_CONTROL_MEDICAMENTOS_ANESTESIA;
    }

    /**
     * @return
     */
    public String irTecnicaAnestesia() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_TECNICA_ANESTESIA;
    }

    /**
     * @return
     */
    public String irViaAerea() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_VIA_AEREA_ANESTESIA;
    }

    /**
     * @return
     */
    public String irMedidasProteccion() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_MEDIDAS_PROTECCION_ANESTESIA;
    }

    /**
     * @return
     */
    public String irDatosEntrada() {
        return BeanNavegacion.RUTA_IR_REGISTRAR_ANESTESIA;
    }

    public String irConsultarFoliosUsuarioCirugia() {

        ConsultarFoliosUsuarioCirugiaBean consultarFolios = 
            (ConsultarFoliosUsuarioCirugiaBean)FacesUtils.getManagedBean("consultarFoliosUsuarioCirugiaBean");

        if (consultarFolios != null) {
            consultarFolios.setUsuario(usuario);
            consultarFolios.setNumeroUsuario(usuario.getHuslnumero());
            consultarFolios.init();


        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_FOLIOS_USUARIO_CIRUGIA;
    }
    

        /**
         * @return
         */
        public String irFormularLiquidosAnestesia() {
            return BeanNavegacion.RUTA_IR_FORMULA_LIQUIDOS_ANESTESIA;
        }
        
        
    /**
     * @return
     */
    public String irFormularMedicamentosAnestesia() {
        return BeanNavegacion.RUTA_IR_FORMULA_HOSPITALIZACION_ANESTESIA;
    }

    public String irRegistrarOtrasOrdenesAnestesia() {
        return BeanNavegacion.RUTA_IR_OTRAS_ORDENES_ANESTESIA;
    }

        

    /**
     * @param renderOtrasCirugias
     */
    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }
    
    

    /**
     * @return
     */
    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }

    public String irCerrarAnestesia() {
        return BeanNavegacion.RUTA_IR_CERRAR_ANESTESIA;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
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
        return BeanNavegacion.RUTA_IR_RESUMEN_HISTORIA_ANESTESIA_CIRUGIA;
    }


    public void setRenderTecnica(boolean renderTecnica) {
        this.renderTecnica = renderTecnica;
    }

    public boolean isRenderTecnica() {
        return renderTecnica;
    }


    public void setEsValidoAnestesia(boolean esValidoAnestesia) {
        this.esValidoAnestesia = esValidoAnestesia;
    }

    public boolean isEsValidoAnestesia() {
        return esValidoAnestesia;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }
}
