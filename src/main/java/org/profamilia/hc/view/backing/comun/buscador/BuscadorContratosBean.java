package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.CpcontratoId;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorContratosBean extends BaseBean {

    private List<Cpcontrato> lstContratos;

    private HtmlDataTable dtConsultaContrato;

    private Cpcontrato contratoSelect;

    private Cpcontrato contrato;

    private boolean existenCriterios;
    
    private boolean filtroClinica;


    public BuscadorContratosBean() {
    }

    public void init() {


        contrato = new Cpcontrato();
        CpcontratoId contratoId = new CpcontratoId();
        contrato.setId(contratoId);
    }

    /**
     * @return
     */
    public String consultarContrato() {
        existenCriterios = true;
        if (contrato == null) {
            existenCriterios = false;
        }

    

        if (existenCriterios) {
            try {
            if(contrato.getCcncdescri()== null){
                contrato.setCcncdescri("");
            }
            if(filtroClinica){
                lstContratos = 
                        serviceLocator.getClinicoService().getCriteriosContratoByClinica(contrato,false,this.getClinica().getCclncodigo());
            }
            else{
                lstContratos = 
                        serviceLocator.getClinicoService().getCriteriosContrato(contrato,false);
            }
                dtConsultaContrato.setFirst(IConstantes.OFFSET_DATATABLE);
                if (lstContratos == null || lstContratos.isEmpty()) {
                    FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            lstContratos = new ArrayList<Cpcontrato>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


        return BeanNavegacion.RUTA_ACTUAL;
    }
    
    
    public String consultarContratoByClinica() {
        existenCriterios = true;
        if (contrato == null) {
            existenCriterios = false;
        }

    

        if (existenCriterios) {
            try {
            if(contrato.getCcncdescri()== null){
                contrato.setCcncdescri("");
            }
                lstContratos = 
                        serviceLocator.getClinicoService().getCriteriosContrato(contrato,false);
                dtConsultaContrato.setFirst(IConstantes.OFFSET_DATATABLE);
                if (lstContratos == null || lstContratos.isEmpty()) {
                    FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            lstContratos = new ArrayList<Cpcontrato>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


        return BeanNavegacion.RUTA_ACTUAL;
    }
    

    /**
     * @return
     */
    public void consultar() {
          contratoSelect = (Cpcontrato)dtConsultaContrato.getRowData();
    }


    public void setLstContratos(List<Cpcontrato> lstContratos) {
        this.lstContratos = lstContratos;
    }

    public List<Cpcontrato> getLstContratos() {
        return lstContratos;
    }

    public void setDtConsultaContrato(HtmlDataTable dtConsultaContrato) {
        this.dtConsultaContrato = dtConsultaContrato;
    }

    public HtmlDataTable getDtConsultaContrato() {
        return dtConsultaContrato;
    }

    public void setContratoSelect(Cpcontrato contratoSelect) {
        this.contratoSelect = contratoSelect;
    }

    public Cpcontrato getContratoSelect() {
        return contratoSelect;
    }

    public void setContrato(Cpcontrato contrato) {
        this.contrato = contrato;
    }

    public Cpcontrato getContrato() {
        return contrato;
    }

    public void setExistenCriterios(boolean existenCriterios) {
        this.existenCriterios = existenCriterios;
    }

    public boolean isExistenCriterios() {
        return existenCriterios;
    }

    public void setFiltroClinica(boolean filtroClinica) {
        this.filtroClinica = filtroClinica;
    }

    public boolean isFiltroClinica() {
        return filtroClinica;
    }
}
