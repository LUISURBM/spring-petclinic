package org.profamilia.hc.view.backing.cirugia.buscador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorFacturasBean extends BaseBean {

    private List lstExamenesCirugias;

    private HtmlDataTable dtServicios;
 
    private Chusuario usuario; 
    
    private Cnconsclin consultaObject; 
    
    private Date fechaInicial; 
    
    private Date fechaFinal; 

    public BuscadorFacturasBean() {
    }

    public void init() {
        lstExamenesCirugias = new ArrayList();     
        fechaInicial = new Date(); 
    }
    
    
   

   /**
     * @param lstExamenesCirugias
     */
    public void setLstExamenesCirugias(List lstExamenesCirugias) {
        this.lstExamenesCirugias = lstExamenesCirugias;
    }

    /**
     * @return
     */
    public List getLstExamenesCirugias() {
        return lstExamenesCirugias;
    }

 

    /**
     * @param dtServicios
     */
    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    /**
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
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
     * @param consultaObject
     */
    public void setConsultaObject(Cnconsclin consultaObject) {
        this.consultaObject = consultaObject;
    }

    /**
     * @return
     */
    public Cnconsclin getConsultaObject() {
        return consultaObject;
    }
 

    public void aceptarFacturas() {
         consultaObject = (Cnconsclin)this.dtServicios.getRowData();   
    }
    
    public void consultarFacturas(){
        try {
            lstExamenesCirugias = 
                    this.serviceLocator.getClinicoService().getBuscadorFacturas(usuario,fechaInicial,fechaFinal);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("ERROR:::: " + e.getMessage());
        }catch (Exception ex) {
            FacesUtils.addErrorMessage("ERROR:::: " + ex.getMessage());
        }
        
        if(lstExamenesCirugias == null || lstExamenesCirugias.isEmpty()){
            FacesUtils.addErrorMessage(MSG_SIN_DATOS);
        }
    }


   
}
