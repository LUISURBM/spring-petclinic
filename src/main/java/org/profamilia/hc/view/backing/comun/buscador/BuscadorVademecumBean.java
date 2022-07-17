package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorVademecumBean extends BaseBean {


    private Chvademprof medicamento;

    private List lstMedicamentos;

    private HtmlDataTable dtMedicamentos;

    private Chvademprof medicamentoSelect;

    private HtmlDataTable dtMedicamentoSelec;

    public BuscadorVademecumBean() {
    }


    public void init() {
        medicamento = new Chvademprof();
        lstMedicamentos = new ArrayList();

    }


    public void consultarMedicamentos() {
        dtMedicamentos.setFirst(0);
        try {
            lstMedicamentos = 
                    this.serviceLocator.getClinicoService().getVademecumHistorias(medicamento);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }


    public void agregarMedicamento() {
        medicamentoSelect = (Chvademprof)this.dtMedicamentos.getRowData();

    }


    /**
     * @param medicamento
     */
    public void setMedicamento(Chvademprof medicamento) {
        this.medicamento = medicamento;
    }


    /**
     * @return
     */
    public Chvademprof getMedicamento() {
        return medicamento;
    }

    /**
     * @param lstMedicamentos
     */
    public void setLstMedicamentos(List lstMedicamentos) {
        this.lstMedicamentos = lstMedicamentos;
    }

    /**
     * @return
     */
    public List getLstMedicamentos() {
        return lstMedicamentos;
    }


    /**
     * @param dtMedicamentos
     */
    public void setDtMedicamentos(HtmlDataTable dtMedicamentos) {
        this.dtMedicamentos = dtMedicamentos;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtMedicamentos() {
        return dtMedicamentos;
    }

    /**
     * @param dtMedicamentoSelec
     */
    public void setDtMedicamentoSelec(HtmlDataTable dtMedicamentoSelec) {
        this.dtMedicamentoSelec = dtMedicamentoSelec;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtMedicamentoSelec() {
        return dtMedicamentoSelec;
    }

    /**
     * @param medicamentoSelect
     */
    public void setMedicamentoSelect(Chvademprof medicamentoSelect) {
        this.medicamentoSelect = medicamentoSelect;
    }

    /**
     * @return
     */
    public Chvademprof getMedicamentoSelect() {
        return medicamentoSelect;
    }

}
