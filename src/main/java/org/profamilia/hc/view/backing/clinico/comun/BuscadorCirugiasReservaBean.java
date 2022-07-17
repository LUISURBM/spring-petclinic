package org.profamilia.hc.view.backing.clinico.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorCirugiasReservaBean extends BaseBean {
    private Cpservicio servicio;

    private List lstExamenesCirugias;

    private HtmlDataTable dtServicios;

    private List lstCirugiaSelec;

    private HtmlDataTable dtCirugiasSelec;

    public BuscadorCirugiasReservaBean() {
    }

    public void init() {
        servicio = new Cpservicio();
        lstExamenesCirugias = new ArrayList();
        lstCirugiaSelec = new ArrayList();
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setLstExamenesCirugias(List lstExamenesCirugias) {
        this.lstExamenesCirugias = lstExamenesCirugias;
    }

    public List getLstExamenesCirugias() {
        return lstExamenesCirugias;
    }

    public void setLstCirugiaSelec(List lstCirugiaSelec) {
        this.lstCirugiaSelec = lstCirugiaSelec;
    }

    public List getLstCirugiaSelec() {
        return lstCirugiaSelec;
    }

    public void setDtServicios(HtmlDataTable dtServicios) {
        this.dtServicios = dtServicios;
    }

    public HtmlDataTable getDtServicios() {
        return dtServicios;
    }

    public void setDtCirugiasSelec(HtmlDataTable dtCirugiasSelec) {
        this.dtCirugiasSelec = dtCirugiasSelec;
    }

    public HtmlDataTable getDtCirugiasSelec() {
        return dtCirugiasSelec;
    }


    public void consultarCirugias() {
        dtServicios.setFirst(0);
        try {
            lstExamenesCirugias = 
                    this.serviceLocator.getClinicoService().getCirugiasPorCriterios(servicio);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void agregarIntervencion() {
        Cpservicio servicioSelect = null;
        servicioSelect = (Cpservicio)this.dtServicios.getRowData();
        if (servicioSelect != null) {
            lstCirugiaSelec.add(servicioSelect);
        }

    }


    public void eliminarCirugia() {
        Cpservicio servicioDelete = null;
        servicioDelete = (Cpservicio)dtCirugiasSelec.getRowData();
        lstCirugiaSelec.remove(servicioDelete);
    }


}
