package org.profamilia.hc.view.backing.cirugia.busqueda;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chregicirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.ConfirmarCirugiaSinFacturaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaCirugiaSinFacturaBean extends BaseBean {


    private List<Chregicirpro> lstCirugias;

    private HtmlDataTable dtCirugia;

    private Chusuario usuario;
    
    private Cpservicio servicio;

    public ListaCirugiaSinFacturaBean() {

    }

    public void init() {
        lstCirugias = new ArrayList<Chregicirpro>();
        dtCirugia = new HtmlDataTable();
        cargarCirugias();
    }

    public String cargarCirugias() {
        try {
        
             lstCirugias = 
                        this.serviceLocator.getCirugiaService().getCirugiasSinFacturaPorConfirmar(getClinica().getCclncodigo());    
            
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
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List<Chregicirpro> lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List<Chregicirpro> getLstCirugias() {
        return lstCirugias;
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
    


    public String seleccionarCirugia() {
        Chregicirpro cirugiaSelect = null; 
        cirugiaSelect = (Chregicirpro)dtCirugia.getRowData();
        ConfirmarCirugiaSinFacturaBean confirmarCirugiaBean = null;
        usuario = new Chusuario();

        try {
        
             usuario = this.serviceLocator.getClinicoService().getUsuario(cirugiaSelect.getHrclusuario().getHuslnumero());    
            
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }        
        FacesUtils.resetManagedBean("confirmarCirugiaSinFacturaBean");


        confirmarCirugiaBean = 
                (ConfirmarCirugiaSinFacturaBean)FacesUtils.getManagedBean("confirmarCirugiaSinFacturaBean");
        if (confirmarCirugiaBean != null && cirugiaSelect != null && 
            usuario != null) {
            confirmarCirugiaBean.setUsuario(usuario);
            confirmarCirugiaBean.setNumeroCirugia(cirugiaSelect.getHrcnnumero());
            confirmarCirugiaBean.init();
        }
        return BeanNavegacion.RUTA_IR_CONFIRMAR_CIRUGIA_SIN_FACTURA;
    }
}
