package org.profamilia.hc.view.backing.cirugia.comun;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.MantenimientoCirugiasBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class AdicionarCirugiaBean extends BaseBean {

  

  
    private Chcirugprogr programacion;

    private String entidad;

    private boolean wexito;

    BuscadorCirugiasBean buscadorCirugias;


    private List<Chdetacirpro> lstCirugiasProgramadas;
    
    MantenimientoCirugiasBean  mantenimiento; 
    
     


    public AdicionarCirugiaBean() {
    }

    public void init() {
        cargarConsultas();
         
         
        mantenimiento = (MantenimientoCirugiasBean)FacesUtils.getManagedBean("mantenimientoCirugiasBean"); 
        mantenimiento.setRenderIconEliminar(true);
        mantenimiento.init();
    }

    public void cargarConsultas() {
        
    }


 
    /**
     * @param programacion
     */
    public void setProgramacion(Chcirugprogr programacion) {
        this.programacion = programacion;
    }

    /**
     * @return
     */
    public Chcirugprogr getProgramacion() {
        return programacion;
    }

    /**
     * @param entidad
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return
     */
    public String getEntidad() {
        return entidad;
    }

   

  


    /**
     * @param lstCirugiasProgramadas
     */
    public void setLstCirugiasProgramadas(List<Chdetacirpro> lstCirugiasProgramadas) {
        this.lstCirugiasProgramadas = lstCirugiasProgramadas;
    }

    /**
     * @return
     */
    public List<Chdetacirpro> getLstCirugiasProgramadas() {
        return lstCirugiasProgramadas;
    }



    /**
     * @return
     */
    public String agregarCirugia() {
        wexito = true;
      
       
        
        if(wexito){
             lstCirugiasProgramadas =  mantenimiento.getLstCirugiasProgramadas(); 
        }
        
        
        if(wexito){
            
            for(Chdetacirpro detaCirugia: lstCirugiasProgramadas){
                if(detaCirugia.getHdcnmedicatien() == null){
                    wexito = false; 
                    FacesUtils.addErrorMessage(IMsg.MSG_CIRUGIA_SIN_MEDICO);
                }
            }
        }


        if (wexito) {

            try {
                this.serviceLocator.getCirugiaService().updateProgramarCirugia(programacion, 
                                                                               lstCirugiasProgramadas);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean("modificarProgramacionBean");
                FacesUtils.resetManagedBean("consultarCirugiasProgramarBean");
                return BeanNavegacion.RUTA_HOME;
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }

        }
        return null;
    }


   
}
