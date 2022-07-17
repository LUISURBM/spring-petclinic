package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;


import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsentimientoInformadoBean extends BaseBean {

    private Chplanconsinfo consentimiento;

    private Chplanconsinfo consentimientoMod;

    private List<Chplanconsinfo> lstConsentimientos;

    private HtmlDataTable dtConsentimiento;

    private int indice;
    
    private List lstEstado;


    public ConsentimientoInformadoBean() {

    }

    public void init() {
        inicializarConsentimiento();
    }

    public void inicializarConsentimiento() {
        consentimiento = new Chplanconsinfo();
        dtConsentimiento = new HtmlDataTable();

        if (userName() != null) {
            try {
                lstConsentimientos = 
                        this.serviceLocator.getClinicoService().getConsentimientoInformado();
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstConsentimientos == null || lstConsentimientos.isEmpty()) {
            lstConsentimientos = new ArrayList<Chplanconsinfo>();
        }

    }


    /**
     * @param consentimiento
     */
    public void setConsentimiento(Chplanconsinfo consentimiento) {
        this.consentimiento = consentimiento;
    }

    /**
     * @return
     */
    public Chplanconsinfo getConsentimiento() {
        return consentimiento;
    }

    /**
     * @param lstConsentimientos
     */
    public void setLstConsentimientos(List<Chplanconsinfo> lstConsentimientos) {
        this.lstConsentimientos = lstConsentimientos;
    }

    /**
     * @return
     */
    public List getLstConsentimientos() {
        return lstConsentimientos;
    }

    /**
     * @param dtConsentimiento
     */
    public void setDtConsentimiento(HtmlDataTable dtConsentimiento) {
        this.dtConsentimiento = dtConsentimiento;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsentimiento() {
        return dtConsentimiento;
    }

    /**
     * @param consentimientoMod
     */
    public void setConsentimientoMod(Chplanconsinfo consentimientoMod) {
        this.consentimientoMod = consentimientoMod;
    }

    /**
     * @return
     */
    public Chplanconsinfo getConsentimientoMod() {
        return consentimientoMod;
    }

    public void agregarConsentimiento() {
        try {
            Chplanconsinfo consetimientoAux = this.serviceLocator.getClinicoService().getConsentimientoInformadoXCodigo(consentimiento.getHpciccodigo());
            if(consetimientoAux != null  && consetimientoAux.getHpcicnombre().equals(consentimiento.getHpcicnombre())){
                FacesUtils.addWarnMessage("Ya se encuentra registrado el consentimiento ingresado");
            }else{
            consentimiento.setHpcicusuaregi(userName());
            consentimiento.setHpcidfechregi(new Date());
            this.serviceLocator.getClinicoService().saveConsentimientoInformado(consentimiento);
            inicializarConsentimiento();
            FacesUtils.addInfoMessage(MSG_ADICION);
            }
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
        

    }

    public void activarConsentimiento() {
        try {
            consentimientoMod = new Chplanconsinfo();
            consentimientoMod = (Chplanconsinfo)this.dtConsentimiento.getRowData();
            consentimientoMod.setHpcicestado("AC");
            this.serviceLocator.getClinicoService().saveConsentimientoInformado(consentimientoMod);
            inicializarConsentimiento();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }
    
    public void inactivarConsentimiento() {
        try {
            consentimientoMod = new Chplanconsinfo();
            consentimientoMod = (Chplanconsinfo)this.dtConsentimiento.getRowData();
            consentimientoMod.setHpcicestado("IN");
            this.serviceLocator.getClinicoService().saveConsentimientoInformado(consentimientoMod);
            inicializarConsentimiento();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }


    public String volverInicio() {
        FacesUtils.resetManagedBean("consentimientoInformadoBean");
        return BeanNavegacion.RUTA_HOME;
    }

    
    /**
     * @return
     */
    public List getLstEstado() {
        if (lstEstado == null || lstEstado.isEmpty()) {
            lstEstado = new ArrayList();
            lstEstado.add(new SelectItem("AC", "Activo"));
            lstEstado.add(new SelectItem("IN", "Inactivo"));
        }
        return lstEstado;
    }


    public void setLstEstado(List lstEstado) {
        this.lstEstado = lstEstado;
    }
    
    public String formatearEstado(String estado) {
            if("AC".equals(estado)){
                return "Activo"; 
            }else if("IN".equals(estado)){
                return "Inactivo"; 
            }
            return "";
        
    }
}
