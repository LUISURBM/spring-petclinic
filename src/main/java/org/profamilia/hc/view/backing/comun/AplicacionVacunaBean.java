//=======================================================================
// ARCHIVO AplicacionMedicamentoBean.java
// FECHA CREACI�N: 16/12/2015
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la aplicacion de Medicamentos
//=======================================================================
package org.profamilia.hc.view.backing.comun;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvacunacion;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE AplicacionVacunaCervixBean
//=======================================================================
public class AplicacionVacunaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario; 
    private Chvacunacion vacuna;
    private String nextAction; 
    private String menuBean; 
    private Long numeroConsulta; 
    private String tipoServicio; 
    private String navigationRule; 
    private List lstVia; 
    private List lstSitioAplicacion;
    private List lstNumeroDosis;
    private Cpservicio codigoServicio; 
    private List lstOpciones; 
    
    private boolean renderComplicaciones; 
    
    private boolean renderReacciones; 
    
   
   
   
    
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------
    public AplicacionVacunaBean() {
    }
    
    public void init(){
        
    }
    //ACTIONS

    public void inicalizarAplicacionBean() {
    
    
        renderComplicaciones = false; 
        renderReacciones = false; 
        
        if(usuario!= null && usuario.getHuslnumero()!= null){


        if (numeroConsulta != null) {

            try {
                vacuna = 
                        this.getServiceLocator().getClinicoService().getAdministracionVacuna(numeroConsulta);

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
        
        if(vacuna == null && numeroConsulta != null){
            vacuna = new Chvacunacion();


                try {
                    codigoServicio = serviceLocator.getClinicoService().getServicioXNumeroConsulta(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(codigoServicio != null && codigoServicio.getCsvccodigo() != null){
                    vacuna.setHvaccodigservi(codigoServicio.getCsvccodigo());    
                    vacuna.setHvacnombrservi(codigoServicio.getCsvcnombre());
                    
                }
                
        }else{
            if(vacuna.getHvacpresecompl() != null && vacuna.getHvacpresecompl().equals("S") ){
                renderComplicaciones = true; 
                
            }
            
            if(vacuna.getHvacpresereacc() != null && vacuna.getHvacpresereacc().equals("S")){
                renderReacciones = true; 
               
            }

        }

      
    }
    }
    
    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 
    
    public String guardar(){
        navigationRule = "";

      
        if (numeroConsulta != null) {
           
            vacuna.getId().setHvalconsulta(numeroConsulta);
            vacuna.getId().setHvactiposervi(tipoServicio);
            vacuna.setHvadfecregistr(new Date());
            vacuna.setHvacoperador(userName());
            
             }
             
             if(!renderComplicaciones){
                 vacuna.setHvaccualcompl(null);
             }
             
            if(!renderReacciones){
                vacuna.setHvaccualreacc(null);
            }

        try {

            this.serviceLocator.getClinicoService().saveAplicacionVacuna(vacuna);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
      

        return navigationRule;
        }
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    
    public boolean esValido(){
        Long numero;
        numero = null;
        Chvacunacion vacunacionAux = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                vacunacionAux = 
                        this.getServiceLocator().getClinicoService().getAdministracionVacuna(numero);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (vacunacionAux != null) {
            return true;
        }

        return false;
    }
    
    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------
    
     /**
      * @param valueChangeEvent
      */
     public void setHvacpresereacc(ValueChangeEvent valueChangeEvent) {
         vacuna.setHvacpresereacc((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

     /**
      * @param valueChangeEvent
      */
     public void setHvacpresecompl(ValueChangeEvent valueChangeEvent) {
         vacuna.setHvacpresecompl((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }
         
         
      public void changeComplicaciones(){
          renderComplicaciones = false; 
       if(vacuna != null){
           if(vacuna.getHvacpresecompl() !=  null && vacuna.getHvacpresecompl().equals("S") ){
               renderComplicaciones = true; 
           }
       }
      }
         
     public void changeReacciones(){
         renderReacciones= false; 
         if(vacuna != null){
             if(vacuna.getHvacpresereacc() !=  null && vacuna.getHvacpresereacc().equals("S") ){
                 renderReacciones= true; 
             }
         }
         
     }
     
     
     //-----------------------------------------------------------------------
     //  Accesorios
     //-----------------------------------------------------------------------
    /**
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
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
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }

    /**
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
    }



    /**
     * @param lstVia
     */
    public void setLstVia(List lstVia) {
        this.lstVia = lstVia;
    }

    /**
     * @return
     */
    public List getLstVia() {
    if(lstVia == null || lstVia.isEmpty()){
        lstVia = new ArrayList(); 
        lstVia.add(new SelectItem("","Seleccione una opci�n"));
        lstVia.add(new SelectItem("IM","Intramuscular"));
        lstVia.add(new SelectItem("SC","Subcut�nea"));
        lstVia.add(new SelectItem("ID","Intrad�rmica"));
        
    }
        return lstVia;
    }

    /**
     * @param lstSitioAplicacion
     */
    public void setLstSitioAplicacion(List lstSitioAplicacion) {
        this.lstSitioAplicacion = lstSitioAplicacion;
    }

    /**
     * @return
     */
    public List getLstSitioAplicacion() {
        if(lstSitioAplicacion == null || lstSitioAplicacion.isEmpty()){
            lstSitioAplicacion = new ArrayList(); 
            lstSitioAplicacion.add(new SelectItem("","Seleccione una opci�n"));
            lstSitioAplicacion.add(new SelectItem("GD","Gl�teo Derecho"));
            lstSitioAplicacion.add(new SelectItem("GI","Gl�teo Izquierdo"));
            lstSitioAplicacion.add(new SelectItem("DD","Deltoides Derecho"));
            lstSitioAplicacion.add(new SelectItem("DI","Deltoides Izquierdo"));
            lstSitioAplicacion.add(new SelectItem("MD","Muslo Derecho"));
            lstSitioAplicacion.add(new SelectItem("MI","Muslo Izquierdo"));
            
        }
            return lstSitioAplicacion;
        }

    public void setLstNumeroDosis(List lstNumeroDosis) {
        this.lstNumeroDosis = lstNumeroDosis;
    }

    public List getLstNumeroDosis() {
        if(lstNumeroDosis == null || lstNumeroDosis.isEmpty()){
            lstNumeroDosis = new ArrayList(); 
            lstNumeroDosis.add(new SelectItem("","Seleccione una opci�n"));
            lstNumeroDosis.add(new SelectItem(1,"1"));
            lstNumeroDosis.add(new SelectItem(2,"2"));
            lstNumeroDosis.add(new SelectItem(3,"3"));
            lstNumeroDosis.add(new SelectItem(4,"4"));
            lstNumeroDosis.add(new SelectItem(5,"5"));
            lstNumeroDosis.add(new SelectItem(6,"Refuerzo 1"));
            lstNumeroDosis.add(new SelectItem(7,"Refuerzo 2"));
            
            
        }
            return lstNumeroDosis;
        }

    /**
     * @param vacuna
     */
    public void setVacuna(Chvacunacion vacuna) {
        this.vacuna = vacuna;
    }

    /**
     * @return
     */
    public Chvacunacion getVacuna() {
        return vacuna;
    }

    public void setCodigoServicio(Cpservicio codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public Cpservicio getCodigoServicio() {
        return codigoServicio;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if(lstOpciones == null || lstOpciones.isEmpty()){
            lstOpciones = new ArrayList(); 
            lstOpciones.add(new SelectItem("S","SI"));
            lstOpciones.add(new SelectItem("N","NO"));
                    
        }
            return lstOpciones;
        }

    public void setRenderComplicaciones(boolean renderComplicaciones) {
        this.renderComplicaciones = renderComplicaciones;
    }

    public boolean isRenderComplicaciones() {
        return renderComplicaciones;
    }

    public void setRenderReacciones(boolean renderReacciones) {
        this.renderReacciones = renderReacciones;
    }

    public boolean isRenderReacciones() {
        return renderReacciones;
    }


    
        
}
