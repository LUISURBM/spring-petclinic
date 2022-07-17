package org.profamilia.hc.view.backing.comun.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.consulta.ConfirmarReferenciaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ListaReferenciaPorConfirmarBean extends BaseBean {


    private List<Chconsulta> lstConsultas;

    private HtmlDataTable dtConsulta;

    public ListaReferenciaPorConfirmarBean() {

    }

    public void init() {
        lstConsultas = new ArrayList<Chconsulta>();
        dtConsulta = new HtmlDataTable();
        cargarReferencia();
    }

    public void cargarReferencia() {
        try {
        
             lstConsultas = 
                        this.serviceLocator.getClinicoService().getConsultasReferenciaPorConfirmar(getClinica().getCclncodigo());    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param lstReferencia
     */
    public void setLstConsultas(List<Chconsulta> lstConsultas) {
        this.lstConsultas = lstConsultas;
    }

    /**
     * @return
     */
    public List<Chconsulta> getLstConsultas() {
        return lstConsultas;
    }

    public String seleccionarConsulta() {
        Chconsulta consultaSelect = null; 
        consultaSelect = (Chconsulta)dtConsulta.getRowData();
        ConfirmarReferenciaBean confirmarReferenciaBean = null;

        FacesUtils.resetManagedBean("confirmarReferenciaBean");


        confirmarReferenciaBean = 
                (ConfirmarReferenciaBean)FacesUtils.getManagedBean("confirmarReferenciaBean");
        if (confirmarReferenciaBean != null && consultaSelect != null ) { 
            confirmarReferenciaBean.setUsuario(consultaSelect.getHcolusuario());
            confirmarReferenciaBean.setNumeroConsulta(consultaSelect.getHcolnumero());
            confirmarReferenciaBean.setTipoServicio(consultaSelect.getHcoctiposervi());
            confirmarReferenciaBean.setConsecutivo(consultaSelect.getHconclinica());
            confirmarReferenciaBean.init();
        }
        return BeanNavegacion.RUTA_IR_CONFIRMAR_REFERENCIA;
    }


    public void setDtConsulta(HtmlDataTable dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public HtmlDataTable getDtConsulta() {
        return dtConsulta;
    }
}
