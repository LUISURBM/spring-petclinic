package org.profamilia.hc.view.backing.clinico.consultorio;


import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.ChnotamedicaPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.menus.consultorio.MenuNotaAclaratoriaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarNotaMedicaBean extends BaseBean {

    /** Almacena la descripcion de la nota Medica*/
    private String notaMedica;

    /** Alamcena la consulta a la cual se le esta haciendo la nota medica */
    private Chconsulta consulta;

    /** Almacena la nota medica a persistir*/
    private Chnotamedica nota;
    
    /** Almacena el bean de navegacion*/
    private String nextAction;
    
    private String opcionConducta;
    
    private List lstOpciones;
    
    private boolean renderConducta;
    
    private MenuNotaAclaratoriaBean menuNotaAclaratoriaBean;
    
    private boolean renderOpcionConducta;
    
    private boolean notaRealizada;
    



    public RegistrarNotaMedicaBean() {
    }


    public void init() {
        nota = new Chnotamedica();
        renderConducta = false;
        renderOpcionConducta = false;
        notaRealizada = false;
        notaMedica= "";

    }

    /**
     * @param notaMedica
     */
    public void setNotaMedica(String notaMedica) {
        this.notaMedica = notaMedica;
    }

    /**
     * @return
     */
    public String getNotaMedica() {
        return notaMedica;
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
     * @return
     */
    public String aceptar() {
    if(nota != null && nota.getId() == null){
        ChnotamedicaPK idNota = new ChnotamedicaPK();
        idNota.setHnmlconsulta(consulta.getHcolnumero());
        nextAction = ""; 
        idNota.setHnmctiposervi(TIPO_CONSULTA);
        nota.setHnmcoperador(userName());
        nota.setHnmdfecregistr(new Date());
        nota.setId(idNota);
    }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (consulta != null && consulta.getHcodfeccierre() != null) {
            String fechaI = dateFormat.format(consulta.getHcodfeccierre());
            String fechaF = dateFormat.format(new Date());

            if (fechaI.equals(fechaF)) {
                renderOpcionConducta = true;
            }
        }
        
        try {
            this.serviceLocator.getClinicoService().saveNotaMedica(nota);
            notaRealizada = true;
            FacesUtils.resetManagedBean("menuNotaAclaratoriaBean");
            nextAction = BeanNavegacion.RUTA_REGISTRAR_NOTA_MEDICA;
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            nextAction = BeanNavegacion.RUTA_ACTUAL;
            e.printStackTrace();
        }
        return nextAction;
        
    }
    
    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        List<Chnotamedica> notaAux = null;
        Long numeroConsulta = null;
        if(consulta != null && consulta.getHcolnumero() != null){
            numeroConsulta = consulta.getHcolnumero();
        }
        if (numeroConsulta != null)
            try {
                notaAux = 
                        getServiceLocator().getClinicoService().getListNotasMedicas(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (notaAux != null && !notaAux.isEmpty())
            esValido = true;
        else
            esValido = false;
        return esValido;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setMenuConductaEvent(ValueChangeEvent valueChangeEvent) {
            setOpcionConducta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public String changeMenuConducta(){
        renderConducta= false;
        if("S".equals(opcionConducta)){
            renderConducta= true; 
        }
        FacesUtils.resetManagedBean("menuNotaAclaratoriaBean");
        return BeanNavegacion.RUTA_REGISTRAR_NOTA_MEDICA;
    }


    public void setOpcionConducta(String opcionConducta) {
        this.opcionConducta = opcionConducta;
    }

    public String getOpcionConducta() {
        return opcionConducta;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
}

    public void setRenderConducta(boolean renderConducta) {
        this.renderConducta = renderConducta;
    }

    public boolean isRenderConducta() {
        return renderConducta;
    }

    public void setMenuNotaAclaratoriaBean(MenuNotaAclaratoriaBean menuNotaAclaratoriaBean) {
        this.menuNotaAclaratoriaBean = menuNotaAclaratoriaBean;
    }

    public MenuNotaAclaratoriaBean getMenuNotaAclaratoriaBean() {
        return menuNotaAclaratoriaBean;
    }

    public void setRenderOpcionConducta(boolean renderOpcionConducta) {
        this.renderOpcionConducta = renderOpcionConducta;
    }

    public boolean isRenderOpcionConducta() {
        return renderOpcionConducta;
    }

    public void setNotaRealizada(boolean notaRealizada) {
        this.notaRealizada = notaRealizada;
    }

    public boolean isNotaRealizada() {
        return notaRealizada;
    }

    public void setNota(Chnotamedica nota) {
        this.nota = nota;
    }

    public Chnotamedica getNota() {
        return nota;
    }
}
