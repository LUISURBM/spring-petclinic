package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chplantilla;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


public class BuscadorPlantillaProcedimientoBean extends BaseBean {

    private Chplantilla plantilla;

    private List lstPlantillas;

    private HtmlDataTable dtPlantilla;

    private Chplantilla plantillaSelect;


    public BuscadorPlantillaProcedimientoBean() {

    }

    public void init() {
        plantilla = new Chplantilla();
        lstPlantillas = new ArrayList();

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
    public void setLstPlantillas(List lstPlantillas) {
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
     * @param plantillaSelect
     */
    public void setPlantillaSelect(Chplantilla plantillaSelect) {
        this.plantillaSelect = plantillaSelect;
    }

    /**
     * @return
     */
    public Chplantilla getPlantillaSelect() {
        return plantillaSelect;
    }

    public void selectPlantilla() {
        plantillaSelect = (Chplantilla)dtPlantilla.getRowData();
    }

    public void consultarPlantillas() {
        dtPlantilla.setFirst(0);
        try {
            lstPlantillas = 
                    this.serviceLocator.getClinicoService().getPlantillaUsuarioCriterios(userName(), 
                                                                                         plantilla);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


}
