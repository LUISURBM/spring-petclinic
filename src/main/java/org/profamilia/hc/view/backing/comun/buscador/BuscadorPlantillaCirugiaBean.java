package org.profamilia.hc.view.backing.comun.buscador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.Chplantilla;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.cirugia.registro.CerrarAnestesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.ControlMedicamentosBean;
import org.profamilia.hc.view.backing.cirugia.registro.DescripcionQuirurgicaBean;
import org.profamilia.hc.view.backing.cirugia.registro.EvolucionBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarNotaEnfermeriaBean;
import org.profamilia.hc.view.backing.comun.conducta.RecomedacionCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarAnetesiaBean;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarControlViaAereaBean;
import org.profamilia.hc.view.backing.comun.AplicacionMedicamentoBean;
import org.profamilia.hc.view.util.FacesUtils;


public class BuscadorPlantillaCirugiaBean extends BaseBean {

    private Chplantilla plantilla;

    private List lstPlantillas;

    private HtmlDataTable dtPlantilla;

    private Chplantilla plantillaSelect;

    private String nombreBeanAnterior;

    private String tagRenderizar;
    private boolean hallazgos;
    private boolean descripcion;


    public BuscadorPlantillaCirugiaBean() {

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

        int ACTIVAR_BEAN_PRINCIPAL = 0;
        if (nombreBeanAnterior != null && 
            nombreBeanAnterior.equals("registrarNotaEnfermeriaBean")) {
            RegistrarNotaEnfermeriaBean nota = 
                (RegistrarNotaEnfermeriaBean)FacesUtils.getManagedBean("registrarNotaEnfermeriaBean");
            nota.getNota().setHnecnotaenferm(plantillaSelect.getHplcdescripcio());
            nota.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
            nota.setRenderPlantilla(false);
            nota.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("controlMedicamentosBean")) {
            ControlMedicamentosBean nota = 
                (ControlMedicamentosBean)FacesUtils.getManagedBean("controlMedicamentosBean");
            nota.getNota().setHnecnotaenferm(plantillaSelect.getHplcdescripcio());
            nota.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
            nota.setRenderPlantilla(false);
            nota.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("registrarAnetesiaBean")) {
            RegistrarAnetesiaBean anestesia = 
                (RegistrarAnetesiaBean)FacesUtils.getManagedBean("registrarAnetesiaBean");
            anestesia.getAnestesia().setHancobseringre(plantillaSelect.getHplcdescripcio());
            anestesia.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
            anestesia.setRenderPlantilla(false);
            anestesia.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("registrarControlViaAereaBean")) {
            RegistrarControlViaAereaBean viaaerea = 
                (RegistrarControlViaAereaBean)FacesUtils.getManagedBean("registrarControlViaAereaBean");
            viaaerea.getViaaerea().setHvacobserviare(plantillaSelect.getHplcdescripcio());
          
            viaaerea.setRenderPlantilla(false);
            viaaerea.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("cerrarAnestesiaBean")) {
            CerrarAnestesiaBean cierreanestesia = 
                (CerrarAnestesiaBean)FacesUtils.getManagedBean("cerrarAnestesiaBean");
            cierreanestesia.getCierreanestesia().setHcicestadsalir(plantillaSelect.getHplcdescripcio());
            cierreanestesia.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
            cierreanestesia.setRenderPlantilla(false);
            cierreanestesia.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("descripcionQuirurgicaBean")) {
            if (isDescripcion()) {
                DescripcionQuirurgicaBean descripcion = 
                    (DescripcionQuirurgicaBean)FacesUtils.getManagedBean("descripcionQuirurgicaBean");
                descripcion.getDetalleDescripcion().setHddcdescripcio(plantillaSelect.getHplcdescripcio());
                descripcion.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
                descripcion.setRenderPlantilla(false);
                descripcion.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
            } else if (isHallazgos()) {
                DescripcionQuirurgicaBean descripcion = 
                    (DescripcionQuirurgicaBean)FacesUtils.getManagedBean("descripcionQuirurgicaBean");
                descripcion.getDetalleDescripcion().setHddcdescripcio(plantillaSelect.getHplcdescripcio());
                descripcion.getItHallazgos().setValue(plantillaSelect.getHplcdescripcio());
                descripcion.setRenderPlantilla(false);
                descripcion.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
            }
        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("recomedacionCirugiaBean")) {
            if (isDescripcion()) {
                RecomedacionCirugiaBean recomendaciones = 
                    (RecomedacionCirugiaBean)FacesUtils.getManagedBean("recomedacionCirugiaBean");
                recomendaciones.getConducta().setHcncobservacio(plantillaSelect.getHplcdescripcio());
                recomendaciones.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
                recomendaciones.setRenderPlantilla(false);
                recomendaciones.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
            } else if (isHallazgos()) {
                RecomedacionCirugiaBean recomendaciones = 
                    (RecomedacionCirugiaBean)FacesUtils.getManagedBean("recomedacionCirugiaBean");
                recomendaciones.getConducta().setHcncplanmanejo(plantillaSelect.getHplcdescripcio());
                recomendaciones.getItPlanManejo().setValue(plantillaSelect.getHplcdescripcio());
                recomendaciones.setRenderPlantilla(false);
                recomendaciones.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
            }

        } else if (nombreBeanAnterior != null && 
                   nombreBeanAnterior.equals("evolucionBean")) {
            if (isDescripcion()) {
                EvolucionBean evolucion = 
                    (EvolucionBean)FacesUtils.getManagedBean("evolucionBean");
                evolucion.getEvolucion().setHevcnotapacien(plantillaSelect.getHplcdescripcio());
                evolucion.getItEvolucion().setValue(plantillaSelect.getHplcdescripcio());
                evolucion.setRenderPlantilla(false);
                evolucion.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
            }

        }
            else if (nombreBeanAnterior != null && 
                               nombreBeanAnterior.equals("aplicacionMedicamentoBean")) {
                       
           AplicacionMedicamentoBean aplicacion = 
           (AplicacionMedicamentoBean)FacesUtils.getManagedBean("aplicacionMedicamentoBean");
           aplicacion.getMedicamento().setHmecobservac(plantillaSelect.getHplcdescripcio());
            aplicacion.getItDescripcion().setValue(plantillaSelect.getHplcdescripcio());
           aplicacion.setRenderPlantilla(false);
           aplicacion.setSelectedIndex(ACTIVAR_BEAN_PRINCIPAL);
                        

                    }
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


    /**
     * @param nombreBeanAnterior
     */
    public void setNombreBeanAnterior(String nombreBeanAnterior) {
        this.nombreBeanAnterior = nombreBeanAnterior;
    }

    /**
     * @return
     */
    public String getNombreBeanAnterior() {
        return nombreBeanAnterior;
    }

    public void setTagRenderizar(String tagRenderizar) {
        this.tagRenderizar = tagRenderizar;
    }

    public String getTagRenderizar() {
        return tagRenderizar;
    }

    public void setHallazgos(boolean hallazgos) {
        this.hallazgos = hallazgos;
    }

    public boolean isHallazgos() {
        return hallazgos;
    }

    public void setDescripcion(boolean descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDescripcion() {
        return descripcion;
    }


}
