package org.profamilia.hc.view.backing.comun.administracion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chprioxmedi;
import org.profamilia.hc.model.dto.ChprioxmediPK;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;


public class GestionProfesionalesBean extends BaseBean {


    private Integer wcodclin;

    private BigDecimal wcodmed;

    private List lstClinica;

    private List listaProfesionalesClinica;

    private List<Chprioxmedi> listaProfesionalPrioridad;

    private HtmlDataTable dtMedicosPrioridad;

    public GestionProfesionalesBean() {
    }


    public void init() {
        wcodclin = this.getClinica().getCclncodigo();
        listaProfesionalPrioridad = new ArrayList<Chprioxmedi>();

        if (wcodclin != null) {
            try {
                listaProfesionalPrioridad = 
                        this.serviceLocator.getClinicoService().getPrioridadProfesional(wcodclin);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            
            if(listaProfesionalPrioridad == null || listaProfesionalPrioridad.isEmpty()){
                listaProfesionalPrioridad = new ArrayList<Chprioxmedi>(); 
            }
        }
        
    }

    /**
     * @param wcodclin
     */
    public void setWcodclin(Integer wcodclin) {
        this.wcodclin = wcodclin;
    }

    /**
     * @return
     */
    public Integer getWcodclin() {
        return wcodclin;
    }

    /**
     * @param wcodmed
     */
    public void setWcodmed(BigDecimal wcodmed) {
        this.wcodmed = wcodmed;
    }

    /**
     * @return
     */
    public BigDecimal getWcodmed() {
        return wcodmed;
    }

    /**
     * @param lstClinica
     */
    public void setLstClinica(List lstClinica) {
        this.lstClinica = lstClinica;
    }

    /**
     * @return
     */
    public List getLstClinica() {
        if (lstClinica == null) {
            lstClinica = new ArrayList();

            try {
                List<Cpclinica> tabla;
                tabla = this.serviceLocator.getClinicoService().getClinicas();
                for (Cpclinica combo: tabla) {
                    lstClinica.add(new SelectItem(combo.getCclncodigo(), 
                                                  combo.getCclcnombre()));
                }
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }
        }
        return lstClinica;
    }

    /**
     * @param listaProfesionalPrioridad
     */
    public void setListaProfesionalPrioridad(List<Chprioxmedi> listaProfesionalPrioridad) {
        this.listaProfesionalPrioridad = listaProfesionalPrioridad;
    }

    /**
     * @return
     */
    public List<Chprioxmedi> getListaProfesionalPrioridad() {
        return listaProfesionalPrioridad;
    }

    /**
     * @param listaProfesionalesClinica
     */
    public void setListaProfesionalesClinica(List listaProfesionalesClinica) {
        this.listaProfesionalesClinica = listaProfesionalesClinica;
    }


    /**
     * @return
     */
    public List getListaProfesionalesClinica() {

        if (listaProfesionalesClinica == null) {
            listaProfesionalesClinica = new ArrayList<Cpprofesio>();
            listaProfesionalesClinica.add(new SelectItem("", 
                                                         "Seleccione ..."));
            try {

                List<Cpprofesio> tabla = 
                    this.serviceLocator.getClinicoService().getListaProfesionalesClinica(this.getClinica().getCclncodigo());
                for (Cpprofesio combo: tabla) {
                    listaProfesionalesClinica.add(new SelectItem(combo.getId().getCpfncodigo(), 
                                                                 combo.getCpfcnombre()));
                }
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }
        }


        return listaProfesionalesClinica;

    }

    /**
     * @param dtMedicosPrioridad
     */
    public void setDtMedicosPrioridad(HtmlDataTable dtMedicosPrioridad) {
        this.dtMedicosPrioridad = dtMedicosPrioridad;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtMedicosPrioridad() {
        return dtMedicosPrioridad;
    }


    public void agregarProfesional() {
        Cpprofesio medicoAux;
        Chprioxmedi wpriomed;
        medicoAux = null;
        wpriomed = null;
        
        if (wcodmed != null && wcodclin != null) {
            try {
                medicoAux = 
                        this.serviceLocator.getClinicoService().getProfesionalPorCodigo(wcodmed, 
                                                                                        wcodclin);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (medicoAux != null && medicoAux.getCpfacedula()!= null ) {
                ChprioxmediPK idpromed;
                idpromed = new ChprioxmediPK();
                wpriomed = new Chprioxmedi();
                idpromed.setHpmncodigclini(wcodclin);
                idpromed.setHpmncodigprofe(wcodmed);
                wpriomed.setId(idpromed);
                wpriomed.setHpmacedula(new Long(medicoAux.getCpfacedula().intValue()));
                wpriomed.setHpmcnombre(medicoAux.getCpfcnombre());
                wpriomed.setHpmcoperador(userName());
                wpriomed.setHpmdfecharegis(new Date());
                listaProfesionalPrioridad.add(wpriomed);
            }

        }
    }

    public void guardarProfesionalPrioridad() {

        try {
            this.serviceLocator.getClinicoService().saveProfesionalPrioridad(listaProfesionalPrioridad, 
                                                                             wcodclin);
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
    }


    public void eliminarPrioridad() {

        Chprioxmedi wpriomedaux = (Chprioxmedi)dtMedicosPrioridad.getRowData();
        listaProfesionalPrioridad.remove(wpriomedaux);

    }
}
