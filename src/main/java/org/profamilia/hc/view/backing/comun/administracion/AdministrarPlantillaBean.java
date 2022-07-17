package org.profamilia.hc.view.backing.comun.administracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chplantilla;
import org.profamilia.hc.model.dto.ChplantillaPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;


public class AdministrarPlantillaBean extends BaseBean {

    private Chplantilla plantilla;

    private Chplantilla plantillaMod;

    private List<Chplantilla> lstPlantillas;

    private HtmlDataTable dtPlantilla;

    private int indice;


    public AdministrarPlantillaBean() {

    }

    public void init() {
        inicializarPlantilla();
    }

    public void inicializarPlantilla() {
        plantilla = new Chplantilla();
        dtPlantilla = new HtmlDataTable();

        if (userName() != null) {
            try {
                lstPlantillas = 
                        this.serviceLocator.getClinicoService().getPlantillaUsuario(userName());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstPlantillas == null || lstPlantillas.isEmpty()) {
            lstPlantillas = new ArrayList<Chplantilla>();
        }

    }


    /**
     * @param plantilla
     */
    public void setPlantilla(Chplantilla plantilla) {
        this.plantilla = plantilla;
    }

    /**
     * @return
     */
    public Chplantilla getPlantilla() {
        return plantilla;
    }

    /**
     * @param lstPlantillas
     */
    public void setLstPlantillas(List<Chplantilla> lstPlantillas) {
        this.lstPlantillas = lstPlantillas;
    }

    /**
     * @return
     */
    public List getLstPlantillas() {
        return lstPlantillas;
    }

    /**
     * @param dtPlantilla
     */
    public void setDtPlantilla(HtmlDataTable dtPlantilla) {
        this.dtPlantilla = dtPlantilla;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPlantilla() {
        return dtPlantilla;
    }

    /**
     * @param plantillaMod
     */
    public void setPlantillaMod(Chplantilla plantillaMod) {
        this.plantillaMod = plantillaMod;
    }

    /**
     * @return
     */
    public Chplantilla getPlantillaMod() {
        return plantillaMod;
    }

    public void agregarPlantilla() {
        ChplantillaPK id;
        id = new ChplantillaPK();
        id.setHplcusuarplant(userName());
        plantilla.setId(id);
        plantilla.setHplcoperador(userName());
        plantilla.setHpldfecregistr(new Date());
        lstPlantillas.add(plantilla);

        plantilla = new Chplantilla();

    }

    public void eliminarPlantilla() {
        Chplantilla plantilladelete;
        plantilladelete = (Chplantilla)this.dtPlantilla.getRowData();
        this.lstPlantillas.remove(plantilladelete);
        FacesUtils.addInfoMessage(MSG_ELIMINACION);
    }

    public String verModificarPlantilla() {
        indice = dtPlantilla.getRowIndex();
        plantillaMod = (Chplantilla)dtPlantilla.getRowData();
        return BeanNavegacion.RUTA_IR_MODIFICAR_PLANTILLAS;
    }

    /**
     * @return
     */
    public String modificarPlantilla() {
        lstPlantillas.set(indice, plantillaMod);
        return BeanNavegacion.RUTA_IR_ADMINISTRAR_PLANTILLAS;
    }

    public String volverInicio() {
        FacesUtils.resetManagedBean("administrarPlantillaBean");
        return BeanNavegacion.RUTA_HOME;
    }


    public void aceptar() {

        if (lstPlantillas != null && !lstPlantillas.isEmpty()) {
            try {
                this.serviceLocator.getClinicoService().savePlantillaUsuario(lstPlantillas, 
                                                                             userName());
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(e.getMessage());
            }
        } else {
            FacesUtils.addErrorMessage(MSG_PLANTILLA_VACIAS);
        }
    }


}
