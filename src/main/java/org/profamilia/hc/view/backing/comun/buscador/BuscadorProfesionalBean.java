package org.profamilia.hc.view.backing.comun.buscador;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorProfesionalBean extends BaseBean {

    private List<Cpprofesio> lstProfesional;

    private HtmlDataTable dtConsultaProfesional;

    private Cpprofesio profesionalSelect;

    private Cpprofesio profesional;

    private boolean existenCriterios;
    
    private Chconsulta consulta;


    public BuscadorProfesionalBean() {
    }

    public void init() {
        profesional = new Cpprofesio();
    }


   



    /**
     * @return
     */
    public String consultarProfesional() {
        existenCriterios = true;
        if (profesional == null) {
            existenCriterios = false;
        }

        if (profesional != null) {
            if (profesional.getCpfacedula() == null && 
                 (profesional.getCpfcnombre() == null || 
                  profesional.getCpfcnombre().equals(""))) {
                existenCriterios = false;
            }

        }

        if (existenCriterios) {
            try {
                lstProfesional =  serviceLocator.getClinicoService().getProfesionalXCedulaXNombre(profesional.getCpfacedula(), 
                                                                                consulta.getHconclinica(),profesional.getCpfcnombre());
                dtConsultaProfesional.setFirst(IConstantes.OFFSET_DATATABLE);
                if (lstProfesional == null || lstProfesional.isEmpty()) {
                    FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

        } else {
            lstProfesional = new ArrayList<Cpprofesio>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }


        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * @return
     */
    public void consultar() {
          profesionalSelect = (Cpprofesio)dtConsultaProfesional.getRowData();
    }


    public void setLstProfesional(List<Cpprofesio> lstProfesional) {
        this.lstProfesional = lstProfesional;
    }

    public List<Cpprofesio> getLstProfesional() {
        return lstProfesional;
    }

    public void setDtConsultaProfesional(HtmlDataTable dtConsultaProfesional) {
        this.dtConsultaProfesional = dtConsultaProfesional;
    }

    public HtmlDataTable getDtConsultaProfesional() {
        return dtConsultaProfesional;
    }

    public void setProfesionalSelect(Cpprofesio profesionalSelect) {
        this.profesionalSelect = profesionalSelect;
    }

    public Cpprofesio getProfesionalSelect() {
        return profesionalSelect;
    }

    public void setProfesional(Cpprofesio profesional) {
        this.profesional = profesional;
    }

    public Cpprofesio getProfesional() {
        return profesional;
    }

    public void setExistenCriterios(boolean existenCriterios) {
        this.existenCriterios = existenCriterios;
    }

    public boolean isExistenCriterios() {
        return existenCriterios;
    }

    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    public Chconsulta getConsulta() {
        return consulta;
    }
}
