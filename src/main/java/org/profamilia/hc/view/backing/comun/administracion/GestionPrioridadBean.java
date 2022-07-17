package org.profamilia.hc.view.backing.comun.administracion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class GestionPrioridadBean extends BaseBean {

    private Integer wcodmed;

    private Integer wcodclin;

    private List lstClinica;

    private List listServiciosProfesional;

    private List listServiciosProfesionalSP;

    private List<String> selectedItems;

    private List<String> selectedItemsSP;

    private List<String> selectedItemsPrioridad;

    private List listaProfesionalesClinica;

    private List lstOpciones;


    public GestionPrioridadBean() {

    }


    public void init() {
        selectedItems = new ArrayList<String>();
        selectedItemsPrioridad = new ArrayList<String>();
        wcodclin = this.getClinica().getCclncodigo();
    }


    /**
     * @param wcodmed
     */
    public void setWcodmed(Integer wcodmed) {
        this.wcodmed = wcodmed;
    }

    /**
     * @return
     */
    public Integer getWcodmed() {
        return wcodmed;
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
     * @param listServiciosProfesional
     */
    public void setListServiciosProfesional(List listServiciosProfesional) {
        this.listServiciosProfesional = listServiciosProfesional;
    }

    /**
     * @return
     */
    public List getListServiciosProfesional() {
        return listServiciosProfesional;
    }

    /**
     * @param listServiciosProfesionalSP
     */
    public void setListServiciosProfesionalSP(List listServiciosProfesionalSP) {
        this.listServiciosProfesionalSP = listServiciosProfesionalSP;
    }

    /**
     * @return
     */
    public List getListServiciosProfesionalSP() {
        return listServiciosProfesionalSP;
    }


    /**
     * @param selectedItemsSP
     */
    public void setSelectedItemsSP(List<String> selectedItemsSP) {
        this.selectedItemsSP = selectedItemsSP;
    }

    /**
     * @return
     */
    public List<String> getSelectedItemsSP() {
        return selectedItemsSP;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
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


    public void buscarServicios() {

        List listServiciosProfesionalAux;
        List listServiciosProfesionalSPAux;
        listServiciosProfesionalSPAux = null;
        listServiciosProfesionalAux = null;

        listServiciosProfesionalSP = new ArrayList();
        listServiciosProfesional = new ArrayList();

        if (wcodclin != null && wcodmed != null) {
            try {
                listServiciosProfesionalAux = 
                        this.serviceLocator.getClinicoService().getServiciosPorProfesional(wcodclin, 
                                                                                           wcodmed, 
                                                                                           TIENE_PRIORIDAD);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listServiciosProfesionalAux != null && 
                !listServiciosProfesionalAux.isEmpty()) {
                Iterator iter = listServiciosProfesionalAux.iterator();

                while (iter.hasNext()) {
                    Object[] a = (Object[])iter.next();
                    listServiciosProfesional.add(new SelectItem(a[0].toString(), 
                                                                a[1].toString()));
                    selectedItems.add(a[0].toString());
                }
            }


            try {
                listServiciosProfesionalSPAux = 
                        this.serviceLocator.getClinicoService().getServiciosPorProfesional(wcodclin, 
                                                                                           wcodmed, 
                                                                                           NO_TIENE_PRIORIDAD);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listServiciosProfesionalSPAux != null && 
                !listServiciosProfesionalSPAux.isEmpty()) {
                Iterator iter1 = listServiciosProfesionalSPAux.iterator();

                while (iter1.hasNext()) {
                    Object[] a = (Object[])iter1.next();
                    listServiciosProfesionalSP.add(new SelectItem(a[0].toString(), 
                                                                  a[1].toString()));
                }
            }
        }
    }


    /**
     * @param selectedItems
     */
    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    /**
     * @return
     */
    public List<String> getSelectedItems() {
        return selectedItems;
    }

    /**
     * @param valueChangeEvent
     */
    public void setWcodmed(ValueChangeEvent valueChangeEvent) {
        setWcodmed((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void asignarPrioridad() {

        selectedItemsPrioridad = new ArrayList<String>();
        if (selectedItems != null && !selectedItems.isEmpty()) {
            for (String s: selectedItems) {
                selectedItemsPrioridad.add(s);
            }
        }

        if (selectedItemsSP != null && !selectedItemsSP.isEmpty()) {
            for (String s1: selectedItemsSP) {
                selectedItemsPrioridad.add(s1);
            }
        }


        try {
            this.serviceLocator.getClinicoService().asignarPrioridad(wcodclin, 
                                                                     wcodmed, 
                                                                     selectedItemsPrioridad);

            FacesUtils.addInfoMessage(IMsg.MSG_ACTUALIZACION);
            selectedItems = new ArrayList<String>();
            selectedItemsSP = new ArrayList<String>();
            buscarServicios();

        } catch (ModelException e) {
            e.printStackTrace();
        }


    }
}
