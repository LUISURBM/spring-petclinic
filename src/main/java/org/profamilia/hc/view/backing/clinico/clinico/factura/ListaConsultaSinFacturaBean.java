package org.profamilia.hc.view.backing.clinico.clinico.factura;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chregiconpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaConsultaSinFacturaBean extends BaseBean {


    private List<Chregiconpro> lstConsultas;

    private HtmlDataTable dtConsulta;
    
    

    private Chusuario usuario;
    
    private Cpservicio servicio;

    public ListaConsultaSinFacturaBean() {

    }

    public void init() {
        lstConsultas = new ArrayList<Chregiconpro>();
        dtConsulta = new HtmlDataTable();
        cargarCirugias();
    }

    public void cargarCirugias() {
        try {
        
             lstConsultas = 
                        this.serviceLocator.getClinicoService().getConsultaSinFacturaPorConfirmar(getClinica().getCclncodigo());    
            
        } catch (ModelException e) {
            e.printStackTrace();
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

   



    public String seleccionarCirugia() {
        Chregiconpro cirugiaSelect = null; 
        cirugiaSelect = (Chregiconpro)dtConsulta.getRowData();
        ConfirmarConsultaSinFacturaBean confirmarCirugiaBean = null;
        usuario = new Chusuario();

        try {
        
             usuario = this.serviceLocator.getClinicoService().getUsuario(cirugiaSelect.getHrclusuario().getHuslnumero());    
            
        } catch (ModelException e) {
            e.printStackTrace();
        }        
    

        confirmarCirugiaBean = 
                (ConfirmarConsultaSinFacturaBean)FacesUtils.getManagedBean("confirmarConsultaSinFacturaBean");
        if (confirmarCirugiaBean != null && cirugiaSelect != null && 
            usuario != null) {
            confirmarCirugiaBean.setUsuario(usuario);
            confirmarCirugiaBean.setNumeroCirugia(cirugiaSelect.getHrcnnumero());
            confirmarCirugiaBean.init();
        }
        return BeanNavegacion.RUTA_IR_CONFIRMAR_CONSULTA_SIN_FACTURA;
    }

    public void setLstConsultas(List<Chregiconpro> lstConsultas) {
        this.lstConsultas = lstConsultas;
    }

    public List<Chregiconpro> getLstConsultas() {
        return lstConsultas;
    }

    public void setDtConsulta(HtmlDataTable dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public HtmlDataTable getDtConsulta() {
        return dtConsulta;
    }
}
