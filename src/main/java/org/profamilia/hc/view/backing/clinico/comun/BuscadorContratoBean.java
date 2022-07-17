package org.profamilia.hc.view.backing.clinico.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorContratoBean extends BaseBean {

    private Cpcontrato contrato;

    private List lstContrato;

    private HtmlDataTable dtContrato;

    private Cpcontrato contratoSelect;


    public BuscadorContratoBean() {
    }

    public void init() {
        contrato = new Cpcontrato();
        lstContrato = new ArrayList();

    }


    public void consultarContratos() {
        dtContrato.setFirst(0);
        try {
            lstContrato = 
                    this.serviceLocator.getClinicoService().getContratoPorCriterios(contrato);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void seleccionarContrato() {
        contratoSelect = (Cpcontrato)this.dtContrato.getRowData();
    }


    /**
     * @param contrato
     */
    public void setContrato(Cpcontrato contrato) {
        this.contrato = contrato;
    }

    /**
     * @return
     */
    public Cpcontrato getContrato() {
        return contrato;
    }

    public void setLstContrato(List lstContrato) {
        this.lstContrato = lstContrato;
    }

    public List getLstContrato() {
        return lstContrato;
    }

    public void setDtContrato(HtmlDataTable dtContrato) {
        this.dtContrato = dtContrato;
    }

    public HtmlDataTable getDtContrato() {
        return dtContrato;
    }

    public void setContratoSelect(Cpcontrato contratoSelect) {
        this.contratoSelect = contratoSelect;
    }

    public Cpcontrato getContratoSelect() {
        return contratoSelect;
    }
}
