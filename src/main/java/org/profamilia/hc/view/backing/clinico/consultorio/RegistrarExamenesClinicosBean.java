package org.profamilia.hc.view.backing.clinico.consultorio;


import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chregisexame;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarExamenesClinicosBean extends BaseBean {


    /** Alamcena la consulta a la cual se le esta haciendo la nota medica */
    private Chconsulta consulta;

    private Chregisexame examen;

    /** Almacena el bean de navegacion*/
    private String nextAction;

    private boolean renderLaboratorio;

    private boolean renderImagenes;

    private boolean renderEstudio;

    private boolean renderPruebaEmbarazo;

    private boolean renderCitologia;

    private boolean renderColposcopia;

    private boolean renderOtro;


    public RegistrarExamenesClinicosBean() {
    }


    public void init() {
        examen = new Chregisexame();


    }


    /**
     * @param consulta
     */
    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Chconsulta getConsulta() {
        return consulta;
    }


    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }


    /**
     * @param examen
     */
    public void setExamen(Chregisexame examen) {
        this.examen = examen;
    }

    /**
     * @return
     */
    public Chregisexame getExamen() {
        return examen;
    }

    /**
     * @param renderLaboratorio
     */
    public void setRenderLaboratorio(boolean renderLaboratorio) {
        this.renderLaboratorio = renderLaboratorio;
    }

    /**
     * @return
     */
    public boolean isRenderLaboratorio() {
        return renderLaboratorio;
    }

    /**
     * @param renderImagenes
     */
    public void setRenderImagenes(boolean renderImagenes) {
        this.renderImagenes = renderImagenes;
    }

    /**
     * @return
     */
    public boolean isRenderImagenes() {
        return renderImagenes;
    }

    /**
     * @param renderEstudio
     */
    public void setRenderEstudio(boolean renderEstudio) {
        this.renderEstudio = renderEstudio;
    }

    /**
     * @return
     */
    public boolean isRenderEstudio() {
        return renderEstudio;
    }

    /**
     * @param renderPruebaEmbarazo
     */
    public void setRenderPruebaEmbarazo(boolean renderPruebaEmbarazo) {
        this.renderPruebaEmbarazo = renderPruebaEmbarazo;
    }

    /**
     * @return
     */
    public boolean isRenderPruebaEmbarazo() {
        return renderPruebaEmbarazo;
    }

    /**
     * @param renderCitologia
     */
    public void setRenderCitologia(boolean renderCitologia) {
        this.renderCitologia = renderCitologia;
    }

    /**
     * @return
     */
    public boolean isRenderCitologia() {
        return renderCitologia;
    }

    /**
     * @param renderColposcopia
     */
    public void setRenderColposcopia(boolean renderColposcopia) {
        this.renderColposcopia = renderColposcopia;
    }

    /**
     * @return
     */
    public boolean isRenderColposcopia() {
        return renderColposcopia;
    }

    /**
     * @param renderOtro
     */
    public void setRenderOtro(boolean renderOtro) {
        this.renderOtro = renderOtro;
    }

    /**
     * @return
     */
    public boolean isRenderOtro() {
        return renderOtro;
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderLaboratorio(ValueChangeEvent valueChangeEvent) {
        setRenderLaboratorio((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderImagenes(ValueChangeEvent valueChangeEvent) {
        setRenderImagenes((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderEstudio(ValueChangeEvent valueChangeEvent) {
        setRenderEstudio((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderPruebaEmbarazo(ValueChangeEvent valueChangeEvent) {
        setRenderPruebaEmbarazo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderCitologia(ValueChangeEvent valueChangeEvent) {
        setRenderCitologia((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderColposcopia(ValueChangeEvent valueChangeEvent) {
        setRenderColposcopia((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderOtro(ValueChangeEvent valueChangeEvent) {
        setRenderOtro((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }


    /**
     * @return
     */
    public String aceptar() {


        examen.getId().setHrelconsulta(consulta.getHcolnumero());
        nextAction = "";
        examen.setHrecoperador(userName());
        examen.setHrenclinica(this.getClinica().getCclncodigo());
        examen.setHredfecregistr(new Date());

         if (renderCitologia) {
            examen.setHreecitologia("S");
        } else {
            examen.setHreecitologia("N");
            examen.setHreccitologia(null);

        }

        if (renderColposcopia) {
            examen.setHreecolposcopi("S");
        } else {
            examen.setHreecolposcopi("N");
            examen.setHreccolposcopi(null);
        }

        if (renderEstudio) {
            examen.setHreeestudpatol("S");
        } else {
            examen.setHreeestudpatol("N");
            examen.setHrecestudpatol(null);
        }

        if (renderImagenes) {
            examen.setHreeimagediagn("S");
        } else {
            examen.setHreeimagediagn("N");
            examen.setHrecimagediagn(null);
        }

        if (renderLaboratorio) {
            examen.setHreelaborclini("S");
        } else {
            examen.setHreelaborclini("N");
            examen.setHreclaborclini(null);
        }

        if (renderOtro) {
            examen.setHreecualexame("S");
        } else {
            examen.setHreecualexame("N");
            examen.setHreccualexame(null);
        }
        if (renderPruebaEmbarazo) {
            examen.setHreepruebembar("S");
        } else {
            examen.setHreepruebembar("N");
            examen.setHrecpruebembar(null);
        }

        try {
            this.serviceLocator.getClinicoService().saveRegistrarExamenLaboratorio(examen);
            nextAction = BeanNavegacion.RUTA_IR_INICIO;
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            nextAction = BeanNavegacion.RUTA_ACTUAL;
            e.printStackTrace();
        }

        return nextAction;
    }


    public String volver() {
        FacesUtils.resetManagedBean("registrarExamenesClinicosBean");
        return BeanNavegacion.RUTA_CONSULTAR_FOLIOS_EXAMENES_CLINICOS;
    }
}
