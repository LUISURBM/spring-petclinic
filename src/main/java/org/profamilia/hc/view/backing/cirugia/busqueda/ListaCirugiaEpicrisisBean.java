package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarEpicrisisBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaCirugiaEpicrisisBean extends BaseBean {


    private List<Chcirugprogr> lstCirugiasIngresadas;

    private HtmlDataTable dtCirugia;

    private Chusuario usuario;
    
    private Date fechaHoy; 


    public ListaCirugiaEpicrisisBean() {

    }

    public void init() {
        usuario = new Chusuario();
        cargarCirugias();
    }

    public void cargarCirugias() {
    
        fechaHoy = new Date();
        cargarListasCirugia(fechaHoy);
      
    }
    
    
    public String cargarListasCirugia(Date fechaCirugia){
        try {
        
             lstCirugiasIngresadas = 
                        this.serviceLocator.getClinicoService().getCirugiasProgramadasEpicrisis(getClinica().getCclncodigo(),fechaCirugia);    
                   
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return null;
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
     * @param lstCirugiasIngresadas
     */
    public void setLstCirugiasIngresadas(List<Chcirugprogr> lstCirugiasIngresadas) {
        this.lstCirugiasIngresadas = lstCirugiasIngresadas;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstCirugiasIngresadas() {
        return lstCirugiasIngresadas;
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


    public String registrarEpicrisis() {
        Chcirugprogr cirugiaSelect = null; 
        DatosBasicosUsuarioBean datosBasicosAux = 
            (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("registrarEpicrisisBean");
        cirugiaSelect = (Chcirugprogr)dtCirugia.getRowData();
        Long numerocirugia = null;

        if (cirugiaSelect != null) {
            numerocirugia = cirugiaSelect.getHcplnumero();
        }

        RegistrarEpicrisisBean epicrisisBean = null;
        epicrisisBean = 
                (RegistrarEpicrisisBean)FacesUtils.getManagedBean("registrarEpicrisisBean");

        if (epicrisisBean != null && cirugiaSelect != null) {
            epicrisisBean.setCirugiaSelect(cirugiaSelect);
            epicrisisBean.setNumerocirugia(numerocirugia);
            epicrisisBean.cargarDatos();
        }


        if (datosBasicosAux != null && cirugiaSelect != null) {
            datosBasicosAux.setUsuario(cirugiaSelect.getHcplusuario());
        }

        return BeanNavegacion.RUTA_IR_REGISTRAR_EPICRISIS;
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
        if (fechaHoy != null && getClinica() != null) {
                cargarListasCirugia(fechaHoy);
            } 
        }
    
}
