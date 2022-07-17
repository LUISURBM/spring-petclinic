package org.profamilia.hc.view.backing.comun.administracion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpsalaespe;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;

public class AsignarSalaMedicoBean extends BaseBean{

    private Integer wcodclin;
    
    private List lstClinica;
    
    private Integer wcodmed;
    
    private List listaProfesionalesClinica;
    
    private List listaSalaClinica; 
    
    private Integer wcodsala; 
    
    private Integer wcodnewsala; 

    public AsignarSalaMedicoBean() {
    
    }
    
    public void init(){
            wcodclin = this.getClinica().getCclncodigo();
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
     * @param listaSalaClinica
     */
    public void setListaSalaClinica(List listaSalaClinica) {
        this.listaSalaClinica = listaSalaClinica;
    }

    /**
     * @return
     */
    public List getListaSalaClinica() {
   /*     if (listaSalaClinica == null || listaSalaClinica.isEmpty()) {
            listaSalaClinica = new ArrayList();
            ArrayList<Cpsalaespe> lstSalaAux = null;
            try {
                lstSalaAux = 
                        (ArrayList<Cpsalaespe>)this.getServiceLocator().getClinicoService().getSalasEspera(this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstSalaAux.isEmpty()) {

                listaSalaClinica.add(new SelectItem("", "--"));
                Iterator it = lstSalaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listaSalaClinica.add(new SelectItem((lstSalaAux.get(i).getCslnnumero()), 
                                               lstSalaAux.get(i).getCslcdescri()));
                    i++;
                }
            }
        }*/
        return listaSalaClinica;
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
    
    
    public void buscarSala() {
        try {
            wcodsala =   serviceLocator.getClinicoService().getSalaXservicioProfesional(wcodclin,userName());
        } catch (ModelException e) {
           e.printStackTrace();
        }
    }
    
    
    public void asignarSalaMedico(){
        
    }

    /**
     * @param valueChangeEvent
     */
    public void setWcodmed(ValueChangeEvent valueChangeEvent) {
           setWcodmed((Integer)valueChangeEvent.getNewValue());
           ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
       }


    /**
     * @param wcodsala
     */
    public void setWcodsala(Integer wcodsala) {
        this.wcodsala = wcodsala;
    }

    /**
     * @return
     */
    public Integer getWcodsala() {
        return wcodsala;
    }
}
