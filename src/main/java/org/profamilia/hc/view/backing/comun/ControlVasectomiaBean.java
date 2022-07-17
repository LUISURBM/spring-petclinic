package org.profamilia.hc.view.backing.comun;

import java.net.URL;

import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcontrvasec;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ControlVasectomiaBean extends BaseBean {

    private Chcontrvasec vasectomia; 
    
    private Chusuario usuario; 
    
    private Cnconsclin consulta;
    
    private String tipoServicio; 
    
    private String nextAction; 
    
    private String menuBean;
    
    private String navigationRule; 
    
    private boolean modoconsulta;


    public ControlVasectomiaBean() {
    }
    
    
    public void init(){
        inicializarVasectomia();
    }
    
    public void inicializarVasectomia(){
        modoconsulta = false; 
        
        vasectomia = new Chcontrvasec();
        if (consulta != null) {
            vasectomia.getId().setHcvlconsulta(consulta.getCconnumero().longValue());
        }
    }

    /**
     * @return
     */
    public boolean esValido(){
        boolean esValido = false;
        /** Almacena el motivo de consulta el cual se va a persistir*/
        Chcontrvasec vasectomiaAux = null;
        if (consulta != null && consulta.getCconnumero() != null && vasectomia.getId().getHcvnconsecutiv() != null) {
            try {
                vasectomiaAux = this.getServiceLocator().getClinicoService().getControlVasectomia(consulta.getCconnumero().longValue(), vasectomia.getId().getHcvnconsecutiv());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (vasectomiaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }
        
    /**
     * @param vasectomia
     */
    public void setVasectomia(Chcontrvasec vasectomia) {
        this.vasectomia = vasectomia;
    }

    /**
     * @return
     */
    public Chcontrvasec getVasectomia() {
        return vasectomia;
    }

    /**
     * @return
     */
    public String aceptar() {
        navigationRule = ""; 
        
        vasectomia.setHcvcoperador(userName());
        vasectomia.setHcvctiposervi(TIPO_CONSULTA);
        vasectomia.setHcvdfecregistr(new Date());
    
        try {
            this.serviceLocator.getClinicoService().saveControlVasectomia(usuario, consulta, vasectomia, userName());
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.resetManagedBean("listaEspermogramaBean");
            return BeanNavegacion.RUTA_IR_LISTA_ESPERMOGRAMA;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
            navigationRule = null;
        }
        
        return BeanNavegacion.RUTA_ACTUAL;
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
     * @param usuario
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
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
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
    }

}
