package org.profamilia.hc.view.backing.menus.cirugia;

import java.util.List;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiasProgramadasBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaEnfermeraBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarFoliosUsuarioCirugiaIngresoEnfermeraBean;
import org.profamilia.hc.view.backing.cirugia.registro.ControlLiquidosBean;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaEnfermeria;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesBean;
import org.profamilia.hc.view.backing.cirugia.registro.OtrasOrdenesPendientesBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEscalaValoracionCaidasBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarMedicamentosIngresoBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSignosVitalesBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.procedimiento.notaEnfermeria.ListaUsuarioNotaEnfermeriaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuIngresoEnfermeriaBean extends BaseBean {

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderToma;

    private boolean renderCerrar;

    private boolean renderNotaEnfermeria;
    
    private boolean renderLiquidos;

    private boolean renderSignosVitales;

    private IngresoCirugiaEnfermeria ingreso;

    private String menuBean;

    private DatosBasicosUsuarioCirugiaBean datosBasicosUsuarioCirugiaBean;
    
    private ControlLiquidosBean control;

    private RegistrarMedicamentosIngresoBean medicamentosBean;

    private RegistrarNotaEnfermeriaBean notaBean;
    
    private ListaCirugiasProgramadasBean listaCirugias;

    RegistrarSignosVitalesBean signos;
    
    private boolean renderOtrasCirugias;
    
    private boolean renderLigadura;
    
    private List<Chdetacirpro> lstDetalle;
    
    private List lstCirugias;
    
    private Boolean notaEnferProceConsul;
    
    private ListaUsuarioNotaEnfermeriaBean listaUsuarioNotaEnfermeria;
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderIngreso;
    
    private boolean renderCerrarIngreso;
    
    private String legendAdmision;
    
    private DatosBasicosUsuarioBean datosBasicosUsuario;
    
    private boolean renderEscalaValoracion;
    
    private Long numeroCirugia; 
    
    private OtrasOrdenesPendientesBean otrasOrdenesBean;
    
    private boolean renderCovid; 

    public void init() {
        List<Chdetacirpro> lstDetalle = null;
        Chcirugprogr cirugia;
        
        listaUsuarioNotaEnfermeria= (ListaUsuarioNotaEnfermeriaBean)FacesUtils.getManagedBean("listaUsuarioNotaEnfermeriaBean");
        notaEnferProceConsul=listaUsuarioNotaEnfermeria.getNotaEnferProceConsul();
    
        ingreso = 
                (IngresoCirugiaEnfermeria)FacesUtils.getManagedBean("ingresoCirugiaEnfermeria");
        ingreso.setMenuBean("menuIngresoEnfermeriaBean");
        
        if(ingreso != null && ingreso.getCirugia() != null && ingreso.getCirugia().getHcplnumero() != null){
            numeroCirugia = ingreso.getCirugia().getHcplnumero();
        }
        
        if (notaEnferProceConsul == null) {
            legendAdmision ="Admisi�n a Cirug�a";
            notaEnferProceConsul = false;
            renderIngreso = true;
        } else {
            legendAdmision ="Admisi�n a Procedimientos";
            if (ingreso.getIngreso() != null && 
                ingreso.getIngreso().getHielusuario() != null) {
                renderIngreso = false;
            } else {
                renderIngreso = true;
            }
        }
        
        datosBasicosUsuarioCirugiaBean = 
                (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
                
                
        

        
        if (ingreso != null && ingreso.getCirugia() != null) {
            datosBasicosUsuarioCirugiaBean.setUsuario(ingreso.getCirugia().getHcplusuario());
            if (notaEnferProceConsul) {
                ingreso.setNotaEnfeProce(true);
            }
            ingreso.setNavegationRule(BeanNavegacion.RUTA_IR_INGRESO_SIGNOS_VITALES);
            renderSignosVitales = ingreso.esValido();
            //            if (ingreso.isRenderLigadura() && ingreso.getIngreso().getHiedfechapremb() == null) {
            renderCerrar = ingreso.esValido();
            //            }
        }
        
             cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
             cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
             cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_INGRESO_ENFERMERIA);
             cuestionarioCovid.setMenuBean("menuIngresoEnfermeriaBean");
             cuestionarioCovid.inicializarCuestionario();
             renderCovid= cuestionarioCovid.esValido();

        
        
             renderEscalaValoracion = ingreso.esValido();


        signos = 
                (RegistrarSignosVitalesBean)FacesUtils.getManagedBean("registrarSignosVitalesBean");
        if (signos != null && ingreso.getCirugia() != null) {
            signos.setCirugia(ingreso.getCirugia());
            if (notaEnferProceConsul) {
                signos.setEsIngreso(false);
                signos.setNotaEnfeProce(true);
            } else {
                signos.setEsIngreso(true);
            }
            signos.setNavegationRule(BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_INGRESO); 
            signos.setMenuBean("menuIngresoEnfermeriaBean");
            signos.init();
            renderNotaEnfermeria = signos.esValido(); 
        }


        notaBean = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");

        if (notaBean != null && ingreso.getCirugia() != null) {
            if (notaEnferProceConsul) {
                notaBean.setEsIngreso(false);
                notaBean.setNotaEnfeProce(true);
            } else {
                notaBean.setEsIngreso(true);
            }
            notaBean.setNavegationRule(BeanNavegacion.RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA);
            notaBean.setMenuBean("menuIngresoEnfermeriaBean");
            notaBean.init();
            //            if (!ingreso.isRenderLigadura() || ingreso.getIngreso().getHiedfechapremb() != null) {
            //                renderCerrar = notaBean.esValido();
            //            }        
            if (notaEnferProceConsul) {
                renderLiquidos = renderSignosVitales;
            } else {
                renderLiquidos = notaBean.esValido();
            }
        }

        control = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");
        if (control != null && ingreso.getCirugia() != null) {
            control.setCirugia(ingreso.getCirugia());
            if (notaEnferProceConsul) {
                control.setEsIngreso(true);
                control.setNotaEnfeProce(true);
            } else {
                control.setEsIngreso(true);
                control.setNotaEnfeProce(false);
            }
            control.setNavegationRule(BeanNavegacion.RUTA_ACTUAL);
            control.init();
        }


        medicamentosBean = null;
        medicamentosBean = 
                (RegistrarMedicamentosIngresoBean)FacesUtils.getManagedBean("registrarMedicamentosIngresoBean");
        if (medicamentosBean != null && ingreso.getCirugia() != null) {
            medicamentosBean.setCirugia(ingreso.getCirugia());
            if (notaEnferProceConsul) {
                medicamentosBean.setNotaEnfeProce(true);
            }else{
                medicamentosBean.setNotaEnfeProce(false);
            }
            medicamentosBean.init();
        }

        otrasOrdenesBean = null;
        otrasOrdenesBean = 
                (OtrasOrdenesPendientesBean)FacesUtils.getManagedBean("otrasOrdenesPendientesBean");
        if (otrasOrdenesBean != null && ingreso.getCirugia() != null) {
            otrasOrdenesBean.setCirugia(ingreso.getCirugia());
            otrasOrdenesBean.setEsIngreso(true);
            otrasOrdenesBean.init();
        }
        
        if(notaEnferProceConsul!=null && notaEnferProceConsul){
            renderCerrar=false;
            
            Long numConsulta =Long.parseLong(listaUsuarioNotaEnfermeria.getConsultaClone().getCconnumero().toString());
            Chconsulta chconsulta = new Chconsulta();

            try {
                chconsulta = this.getServiceLocator().getClinicoService().getConsultaActual(numConsulta);
            } catch (ModelException e) {
                e.getMessage();
            }
            if(chconsulta != null && chconsulta.getHcoeetapa().equals("CE")){
                renderCerrarIngreso=true;
            }else{
                renderCerrarIngreso=false;
            }
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
     * @param renderNotaEnfermeria
     */
    public void setRenderNotaEnfermeria(boolean renderNotaEnfermeria) {
        this.renderNotaEnfermeria = renderNotaEnfermeria;
    }

    /**
     * @return
     */
    public boolean isRenderNotaEnfermeria() {
        return renderNotaEnfermeria;
    }

    /**
     * @param renderSignosVitales
     */
    public void setRenderSignosVitales(boolean renderSignosVitales) {
        this.renderSignosVitales = renderSignosVitales;
    }

    /**
     * @return
     */
    public boolean isRenderSignosVitales() {
        return renderSignosVitales;
    }


    /**
     * @param renderCerrar
     */
    public void setRenderCerrar(boolean renderCerrar) {
        this.renderCerrar = renderCerrar;
    }

    /**
     * @return
     */
    public boolean isRenderCerrar() {
        return renderCerrar;
    }

    /**
     * @param renderLiquidos
     */
    public void setRenderLiquidos(boolean renderLiquidos) {
        this.renderLiquidos = renderLiquidos;
    }

    /**
     * @return
     */
    public boolean isRenderLiquidos() {
        return renderLiquidos;
    }

    /**
     * @param renderToma
     */
    public void setRenderToma(boolean renderToma) {
        this.renderToma = renderToma;
    }

    /**
     * @return
     */
    public boolean isRenderToma() {
        return renderToma;
    }

    /**
     * @return
     */
    public String irNotasEnfermeria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_NOTA_ENFERMERIA_INGRESO;
    }
    
    
    public String irCuestionarioCovidCirugia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_INGRESO_ENFERMERIA;
        }

    /**
     * @return
     */
    public String irIngresoLiquidos() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA;
    }

    /**
     * @return
     */
    public String irCerrarIngreso() {
        inicializarUsuario();
        return null;
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
     * @return
     */
    public String irPreparacionPreoperatoria() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INGRESO_ENFERMERIA;
    }

    public void inicializarUsuario() {
        if (ingreso != null && ingreso.getIngreso() != null && 
            ingreso.getIngreso().getHielusuario() != null)
            this.setUsuario(ingreso.getIngreso().getHielusuario());
    }


    /**
     * @return
     */
    public String irCerrarIngresoEnfermeria() {
        FacesUtils.resetManagedBean("listaCirugiasProgramadasBean");
        if (ingreso != null) {
            ingreso.closeIngreso();
        }
        return BeanNavegacion.RUTA_HOME;
    }


    /**
     * @return
     */
    public String irIngresoSignosVitales() {
        inicializarUsuario();

        return BeanNavegacion.RUTA_IR_INGRESO_SIGNOS_VITALES;
    }

    /**
     * @return
     */
    public String irIngresoMedicamento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS;
    }
    
    
    public String irConsultarFoliosUsuarioCirugia() throws ModelException {
    
        ConsultarFoliosUsuarioCirugiaIngresoEnfermeraBean consultarFolios =
            (ConsultarFoliosUsuarioCirugiaIngresoEnfermeraBean)FacesUtils.getManagedBean("consultarFoliosUsuarioCirugiaIngresoEnfermeraBean"); 
    
        if(consultarFolios != null){
            usuario = 
                this.serviceLocator.getClinicoService().getUsuario(ingreso.getCirugia().getHcplusuario().getHuslnumero());
            consultarFolios.setUsuario(usuario);
            consultarFolios.setNumeroUsuario(usuario.getHuslnumero());
            consultarFolios.init();
        
            
        }
        return BeanNavegacion.RUTA_IR_GENERAR_RESUMEN_FOLIOS_CIRUGIA_INGRESO_ENFERMERIA;
    }

    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }

    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }

   

    public void setLstDetalle(List<Chdetacirpro> lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

    public List<Chdetacirpro> getLstDetalle() {
        return lstDetalle;
    }

    public void setRenderLigadura(boolean renderLigadura) {
        this.renderLigadura = renderLigadura;
    }

    public boolean isRenderLigadura() {
        return renderLigadura;
    }

    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    public List getLstCirugias() {
        return lstCirugias;
    }

    public void setNotaEnferProceConsul(Boolean notaEnferProceConsul) {
        this.notaEnferProceConsul = notaEnferProceConsul;
    }

    public Boolean getNotaEnferProceConsul() {
        return notaEnferProceConsul;
    }

    public void setListaUsuarioNotaEnfermeria(ListaUsuarioNotaEnfermeriaBean listaUsuarioNotaEnfermeria) {
        this.listaUsuarioNotaEnfermeria = listaUsuarioNotaEnfermeria;
    }

    public ListaUsuarioNotaEnfermeriaBean getListaUsuarioNotaEnfermeria() {
        return listaUsuarioNotaEnfermeria;
    }

    /**
     * @return
     */
    public String irSalirNortaEnfermeria() {
        FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
        return BeanNavegacion.RUTA_IR_LISTA_USUARIO_NOTA_ENFERMERIA;
    }

    public void setRenderIngreso(Boolean renderIngreso) {
        this.renderIngreso = renderIngreso;
    }

    public Boolean getRenderIngreso() {
        return renderIngreso;
    }
    
    /**
     * @return
     */
    public String irCierreNotaEnfermeria() {
        return BeanNavegacion.RUTA_IR_CERRAR_NOTA_ENFERMERIA_PROCEDIMIENTO;
    }

    public void setRenderCerrarIngreso(boolean renderCerrarIngreso) {
        this.renderCerrarIngreso = renderCerrarIngreso;
    }

    public boolean isRenderCerrarIngreso() {
        return renderCerrarIngreso;
    }

    public void setLegendAdmision(String legendAdmision) {
        this.legendAdmision = legendAdmision;
    }

    public String getLegendAdmision() {
        return legendAdmision;
    }
    public String irResumenHistoriaIngresoEnfermeriaProcedimiento() {
        inicializarUsuario();

        FacesUtils.resetManagedBean("consultarFoliosBean");

        ConsultarFoliosBean generarResumen = 
            (ConsultarFoliosBean)FacesUtils.getManagedBean("consultarFoliosBean");
            
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                       
        if (generarResumen != null) {
            try {
                usuario =
                this.serviceLocator.getClinicoService().getUsuario(ingreso.getCirugia().getHcplusuario().getHuslnumero());
            } catch (ModelException e) {
               e.getMessage();
            }
            generarResumen.init();
            generarResumen.setEncabezado(true);
            generarResumen.setUsuario(usuario);
            datosBasicosUsuario.setUsuario(usuario);
            datosBasicosUsuario.inicializarUsuario();
            generarResumen.consultarFoliosUsuario();

        }
        return BeanNavegacion.RUTA_IR_GENERAR_FOLIOS_INGRESO_ENFERMERIA_PROCEDIMIENTO;
    }

    public String irEscalaValoracionCaidasEnfermeriaProcedimiento() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_REGISTRO_ESCALA_VALORACION_CAIDAS_PROCEDIMIENTO;
    }

    public void setRenderEscalaValoracion(boolean renderEscalaValoracion) {
        this.renderEscalaValoracion = renderEscalaValoracion;
    }

    public boolean isRenderEscalaValoracion() {
        return renderEscalaValoracion;
    }
    
    /**
     * @return
     */
    public String irOtrasOrdenesIngresoEnfermeriaProcedimiento() {
        inicializarUsuario();
        otrasOrdenesBean = 
                (OtrasOrdenesPendientesBean)FacesUtils.getManagedBean("otrasOrdenesPendientesBean");
        if (otrasOrdenesBean != null && ingreso.getCirugia() != null) {
            otrasOrdenesBean.setCirugia(ingreso.getCirugia());
            otrasOrdenesBean.setEsIngreso(true);
            otrasOrdenesBean.init();
        }
        return BeanNavegacion.RUTA_IR_INGRESO_OTRAS_ORDENES_PROCEDIMIENTO;
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
}
