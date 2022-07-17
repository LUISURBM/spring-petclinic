package org.profamilia.hc.view.backing.clinico.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chplantilla;
import org.profamilia.hc.model.dto.Chtipointerc;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.cirugia.registro.EvolucionBean;
import org.profamilia.hc.view.backing.comun.conducta.InterConsultaUsuarioBean;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorInterconsultaBean extends BaseBean {

    private Chtipointerc interconsulta;

    private List lstInterconsulta;

    private HtmlDataTable dtInterconsulta;

    private Chtipointerc interconsultaSelect;
    
    private String tagRenderizar;
    
    private String nombreBeanAnterior; 


    public BuscadorInterconsultaBean() {
    }

    public void init() {
        interconsulta = new Chtipointerc();
        lstInterconsulta = new ArrayList();

    }


    public void consultarInterconsulta() {
        dtInterconsulta.setFirst(0);
        try {
            lstInterconsulta = 
                    this.serviceLocator.getClinicoService().getInterconsultaPorCriterios(interconsulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void seleccionarContrato() {
        interconsultaSelect = (Chtipointerc)this.dtInterconsulta.getRowData();
    }


    public void setInterconsulta(Chtipointerc interconsulta) {
        this.interconsulta = interconsulta;
    }

    public Chtipointerc getInterconsulta() {
        return interconsulta;
    }

    public void setLstInterconsulta(List lstInterconsulta) {
        this.lstInterconsulta = lstInterconsulta;
    }

    public List getLstInterconsulta() {
        return lstInterconsulta;
    }

    public void setDtInterconsulta(HtmlDataTable dtInterconsulta) {
        this.dtInterconsulta = dtInterconsulta;
    }

    public HtmlDataTable getDtInterconsulta() {
        return dtInterconsulta;
    }

    public void setInterconsultaSelect(Chtipointerc interconsultaSelect) {
        this.interconsultaSelect = interconsultaSelect;
    }

    public Chtipointerc getInterconsultaSelect() {
        return interconsultaSelect;
    }
    
    public void selectInterconsulta(){        
    interconsultaSelect = (Chtipointerc)dtInterconsulta.getRowData();
    int ACTIVAR_BEAN_PRINCIPAL = 0;
    
    
     if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("interConsultaUsuarioBean")) {
       
                InterConsultaUsuarioBean interconsulta = 
                    (InterConsultaUsuarioBean)FacesUtils.getManagedBean("interConsultaUsuarioBean");
                interconsulta.setConsultaSelect(interconsultaSelect.getHticcodigo());
                interconsulta.setDescripcionInterconsulta(interconsultaSelect.getHticdescripcio());
                interconsulta.setRenderPlantilla(false);
                interconsulta.getInputInterconsulta().setValue(interconsultaSelect.getHticcodigo());
                interconsulta.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
        }
        }
        

    public void setTagRenderizar(String tagRenderizar) {
        this.tagRenderizar = tagRenderizar;
    }

    public String getTagRenderizar() {
        return tagRenderizar;
    }

    public void setNombreBeanAnterior(String nombreBeanAnterior) {
        this.nombreBeanAnterior = nombreBeanAnterior;
    }

    public String getNombreBeanAnterior() {
        return nombreBeanAnterior;
    }
}
