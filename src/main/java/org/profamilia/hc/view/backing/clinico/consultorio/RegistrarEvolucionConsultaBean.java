package org.profamilia.hc.view.backing.clinico.consultorio;

import java.util.Date;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chevoluconsu;
import org.profamilia.hc.model.dto.ChevoluconsuPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarEvolucionConsultaBean extends BaseBean {

    /** Almacena la descripcion de la nota Medica*/
    private Chevoluconsu evolucion;

    /** Alamcena la consulta a la cual se le esta haciendo la nota medica */
    private Chconsulta consulta;

    
    /** Almacena el bean de navegacion*/
    private String nextAction; 



    public RegistrarEvolucionConsultaBean() {
    }


    public void init() {
        evolucion = new Chevoluconsu();    
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

        ChevoluconsuPK idEvolucion = new ChevoluconsuPK();
        idEvolucion.setHeclconsulta(consulta.getHcolnumero());
        idEvolucion.setHecctiposervi(TIPO_CONSULTA);
        nextAction = ""; 
      
        evolucion.setHeccoperador(userName());
        evolucion.setHecdfecregistr(new Date());
        evolucion.setId(idEvolucion);


        try {
            this.serviceLocator.getClinicoService().saveEvolucionConsulta(evolucion);
            nextAction = BeanNavegacion.RUTA_IR_INICIO; 
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            nextAction = BeanNavegacion.RUTA_ACTUAL; 
            e.printStackTrace();
        }


        return nextAction;
    }


    public void setEvolucion(Chevoluconsu evolucion) {
        this.evolucion = evolucion;
    }

    public Chevoluconsu getEvolucion() {
        return evolucion;
    }
}
