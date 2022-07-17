package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.Date;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.RegistrarEscalaValoracionCaidasCEBean;
import org.profamilia.hc.view.backing.procedimiento.DatosUsuarioCitologiaBean;
import org.profamilia.hc.view.backing.procedimiento.TomaCitologiaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuTomaCitologiaBean extends BaseBean {

    private DatosUsuarioCitologiaBean datosBasicosUsuario;
    
    private DatosBasicosUsuarioBean datosBasicos;


    private TomaCitologiaBean toma;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderToma;

    private boolean renderCerrar;
    
    private Integer wgestac;
    
    private Integer wpartos;
    
    private Integer waborto;
    
    private Date wultmen;
    
    private Date wultpar;
    
    private Integer wedarel;
    
    private Date wultcit;
    
    private boolean esPolicia; 
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    
    private RegistrarEscalaValoracionCaidasCEBean registrarEscalaValoracionCaidasBean;
    
    private boolean renderEscalaCaidas;


    public void init() {

        // DATOS BASICOS USUARIO
        
        Chantegineco antecedentes;
        antecedentes = null;
        
        Long numeroConsulta = null; 
        
        wgestac = null;
        wpartos = null;
        waborto = null;
        wultmen = null;
        wultpar = null;
        wedarel = null;
        wultcit = null;
        
        datosBasicosUsuario = 
                (DatosUsuarioCitologiaBean)FacesUtils.getManagedBean("datosUsuarioCitologiaBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_TOMA_CITOLOGIA);
        datosBasicosUsuario.setMenuBean("menuTomaCitologiaBean");
        renderCovid = datosBasicosUsuario.esValido();

        datosBasicosUsuario.setUsuario(datosBasicosUsuario.getUsuario());

       
       datosBasicos = 
                      (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
              datosBasicos.setUsuario(datosBasicosUsuario.getUsuario());

    if(datosBasicosUsuario!= null && datosBasicosUsuario.getConsulta()!= null &&  datosBasicosUsuario.getConsulta().getCconnumero()!= null){
                numeroConsulta = new Long(datosBasicosUsuario.getConsulta().getCconnumero());
                try {
                    esPolicia =  serviceLocator.getClinicoService().esPoliciaNacional(datosBasicosUsuario.getConsulta().getCconnumero());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
    }
        // MOTIVO DE CONSULTA
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CITOLOGIA);
        cuestionarioCovid.setMenuBean("menuTomaCitologiaBean");
        cuestionarioCovid.inicializarCuestionario();
        renderEscalaCaidas= cuestionarioCovid.esValido();
        
        registrarEscalaValoracionCaidasBean = 
           (RegistrarEscalaValoracionCaidasCEBean)FacesUtils.getManagedBean("registrarEscalaValoracionCaidasCEBean");
           registrarEscalaValoracionCaidasBean.setNumeroConsulta(numeroConsulta);
        if (datosBasicosUsuario != null &&
           datosBasicosUsuario.getUsuario() != null && 
           datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
               registrarEscalaValoracionCaidasBean.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
           }
           registrarEscalaValoracionCaidasBean.setMenuBean("menuTomaCitologiaBean");
           registrarEscalaValoracionCaidasBean.setNextAction(BeanNavegacion.RUTA_IR_TOMA_CITOLOGIA);
           registrarEscalaValoracionCaidasBean.init();
           renderToma = registrarEscalaValoracionCaidasBean.esValido();
    
    
        toma = (TomaCitologiaBean)FacesUtils.getManagedBean("tomaCitologiaBean");
        toma.setTipoServicio(TIPO_CONSULTA);
        toma.setConsulta(datosBasicosUsuario.getConsulta());
        toma.setEsPolicia(esPolicia);
        toma.setUsuario(datosBasicosUsuario.getUsuario());
        toma.setMenuBean("menuTomaCitologiaBean");
        toma.inicializarTomaCitologia();

    }


    /**
     * @return
     */
    public String irDatosCitologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_CITOLOGIA;
    }


    /**
     * @return
     */
    public String irTomaCitologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_TOMA_CITOLOGIA;
    }
    
    public String irCuestionarioCovidTomaCitologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_TOMA_CITOLOGIA;
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
     * @param wgestac
     */
    public void setWgestac(Integer wgestac) {
        this.wgestac = wgestac;
    }

    /**
     * @return
     */
    public Integer getWgestac() {
        return wgestac;
    }

    /**
     * @param wpartos
     */
    public void setWpartos(Integer wpartos) {
        this.wpartos = wpartos;
    }

    /**
     * @return
     */
    public Integer getWpartos() {
        return wpartos;
    }

    /**
     * @param waborto
     */
    public void setWaborto(Integer waborto) {
        this.waborto = waborto;
    }

    /**
     * @return
     */
    public Integer getWaborto() {
        return waborto;
    }

    /**
     * @param wultmen
     */
    public void setWultmen(Date wultmen) {
        this.wultmen = wultmen;
    }

    /**
     * @return
     */
    public Date getWultmen() {
        return wultmen;
    }

    /**
     * @param wultpar
     */
    public void setWultpar(Date wultpar) {
        this.wultpar = wultpar;
    }

    /**
     * @return
     */
    public Date getWultpar() {
        return wultpar;
    }

    /**
     * @param wedarel
     */
    public void setWedarel(Integer wedarel) {
        this.wedarel = wedarel;
    }

    /**
     * @return
     */
    public Integer getWedarel() {
        return wedarel;
    }

    /**
     * @param wultcit
     */
    public void setWultcit(Date wultcit) {
        this.wultcit = wultcit;
    }

    /**
     * @return
     */
    public Date getWultcit() {
        return wultcit;
    }

    public void setEsPolicia(boolean esPolicia) {
        this.esPolicia = esPolicia;
    }

    public boolean isEsPolicia() {
        return esPolicia;
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }

    public void setRenderEscalaCaidas(boolean renderEscalaCaidas) {
        this.renderEscalaCaidas = renderEscalaCaidas;
    }

    public boolean isRenderEscalaCaidas() {
        return renderEscalaCaidas;
    }
    
    /**
     * @return
     */
    public String irEscalaValoracionCaidasCitologia() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ESCALA_VALORACION_CAIDAS_CITOLOGIA;
    }
}
