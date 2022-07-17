package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.Date;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.vph.DatosUsuarioVphBean;
import org.profamilia.hc.view.backing.clinico.consultorio.vph.TomaVphBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuTomaVphBean extends BaseBean {

    private DatosUsuarioVphBean datosBasicosUsuario;
    
    private DatosBasicosUsuarioBean datosBasicos;


    private TomaVphBean toma;

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
    
    private CuestionarioCovidBean cuestionarioCovid;
    
    private boolean renderCovid;
    



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
                (DatosUsuarioVphBean)FacesUtils.getManagedBean("datosUsuarioVphBean");
        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_TOMA_VPH);
        datosBasicosUsuario.setMenuBean("menuTomaVphBean");
        renderCovid = datosBasicosUsuario.esValido();

        datosBasicosUsuario.setUsuario(datosBasicosUsuario.getUsuario());

       
       datosBasicos = 
                      (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
              datosBasicos.setUsuario(datosBasicosUsuario.getUsuario());
              
        if(datosBasicosUsuario!= null && datosBasicosUsuario.getConsulta()!= null &&  datosBasicosUsuario.getConsulta().getCconnumero()!= null){
                    numeroConsulta = new Long(datosBasicosUsuario.getConsulta().getCconnumero());
        }
              
        // MOTIVO DE CONSULTA
        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        if(datosBasicosUsuario != null && datosBasicosUsuario.getUsuario() != null && datosBasicosUsuario.getUsuario().getHuslnumero() != null ){
            cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        }
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_TOMA_VPH);
        cuestionarioCovid.setMenuBean("menuTomaVphBean");
        cuestionarioCovid.inicializarCuestionario();
        renderToma= cuestionarioCovid.esValido();


        toma = (TomaVphBean)FacesUtils.getManagedBean("tomaVphBean");
        toma.setTipoServicio(TIPO_CONSULTA);
        toma.setConsulta(datosBasicosUsuario.getConsulta());
        toma.setEsPolicia(false);
        toma.setUsuario(datosBasicosUsuario.getUsuario());
        toma.setMenuBean("menuTomaVphBean");
        toma.inicializarTomaVph();

    }


    /**
     * @return
     */
    public String irDatosVph() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_VPH;
    }
    
    public String irCuestionarioCovidVph() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_TOMA_VPH;
        }



    /**
     * @return
     */
    public String irTomaVph() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_TOMA_VPH;
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


    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }
}
