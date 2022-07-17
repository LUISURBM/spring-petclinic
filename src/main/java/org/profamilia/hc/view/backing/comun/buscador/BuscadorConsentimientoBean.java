package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorConsentimientoBean extends BaseBean {

    private Chplanconsinfo chplanconsinfo;

    private List lstConsentimientoInformado;

    private HtmlDataTable dtConsentimiento;

    private List<Chplanconsinfo> lstConsentimientoSelec;

    private HtmlDataTable dtConsentimientoSelec;
    
    private Chplanconsinfo chplanconsinfoBusqueda;

    public BuscadorConsentimientoBean() {
    }

    public void init() {
        chplanconsinfo = new Chplanconsinfo();
        chplanconsinfoBusqueda = new Chplanconsinfo();
        lstConsentimientoInformado = new ArrayList();
        lstConsentimientoSelec = new ArrayList<Chplanconsinfo>();
    }


    public void consultarConsentimientos() {
        try {
            lstConsentimientoInformado = 
                    this.serviceLocator.getClinicoService().getConsentimientoInformadoXCliterios(chplanconsinfoBusqueda);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void agregarConsentimiento() {
        Chplanconsinfo planconsinfoSelect = null;
        planconsinfoSelect = (Chplanconsinfo)this.dtConsentimiento.getRowData();
        if (planconsinfoSelect != null) {
            lstConsentimientoSelec.add(planconsinfoSelect);
        }

    }


    public void eliminarConsentimiento() {
        Chplanconsinfo planconsinfoDelete = null;
        planconsinfoDelete = (Chplanconsinfo)dtConsentimientoSelec.getRowData();
        lstConsentimientoSelec.remove(planconsinfoDelete);
    }


    public void setChplanconsinfo(Chplanconsinfo chplanconsinfo) {
        this.chplanconsinfo = chplanconsinfo;
    }

    public Chplanconsinfo getChplanconsinfo() {
        return chplanconsinfo;
    }

    public void setLstConsentimientoInformado(List lstConsentimientoInformado) {
        this.lstConsentimientoInformado = lstConsentimientoInformado;
    }

    public List getLstConsentimientoInformado() {
        return lstConsentimientoInformado;
    }

    public void setDtConsentimiento(HtmlDataTable dtConsentimiento) {
        this.dtConsentimiento = dtConsentimiento;
    }

    public HtmlDataTable getDtConsentimiento() {
        return dtConsentimiento;
    }

    public void setLstConsentimientoSelec(List<Chplanconsinfo> lstConsentimientoSelec) {
        this.lstConsentimientoSelec = lstConsentimientoSelec;
    }

    public List<Chplanconsinfo> getLstConsentimientoSelec() {
        return lstConsentimientoSelec;
    }

    public void setDtConsentimientoSelec(HtmlDataTable dtConsentimientoSelec) {
        this.dtConsentimientoSelec = dtConsentimientoSelec;
    }

    public HtmlDataTable getDtConsentimientoSelec() {
        return dtConsentimientoSelec;
    }

    public void setChplanconsinfoBusqueda(Chplanconsinfo chplanconsinfoBusqueda) {
        this.chplanconsinfoBusqueda = chplanconsinfoBusqueda;
    }

    public Chplanconsinfo getChplanconsinfoBusqueda() {
        return chplanconsinfoBusqueda;
    }
}
