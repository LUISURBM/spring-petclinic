//=======================================================================
// ARCHIVO Registrar Seguimiento Avise 
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registra el seguimiento para la asesoria AVISE
//=======================================================================
package org.profamilia.hc.view.backing.asesoria;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chaseavise;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chseguavis;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.asesoria.administrador.ConsultarAsesoriaBean;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RegistrarSeguimientoAviseBean
//=======================================================================
public class RegistrarSeguimientoAviseBean extends BaseBean{


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

  
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**Almacena el obejo asesoria */
    private Chaseavise asesoria;

    private String nextAction;

    private String navegationRule;

    private String menuBean;
    
    private Chseguavis seguimiento; 
    
    private Date fechaAsesoria; 
    
    private List<Chaseavise> lstAsesoria; 
    
    private int index = -1;
    
    private boolean generoReporte;
    
    private boolean renderRemitirIlve; 
    
    private boolean renderIndecision; 
    
    private boolean renderCostoAlto; 
    
    private boolean renderEps; 
    
    private boolean renderOtraIps; 
    
    private boolean renderEmbarazoMayor; 
    
    private boolean renderAplicaCausal; 
    
    private boolean renderContinuaEmbarazo; 
    
    private boolean renderAplazaDecision; 
    
    private boolean renderOtraConducta; 
    
    private boolean renderRemisionOtra; 
    
    private boolean renderConducta; 
    
    private boolean renderConfirmaMetodo;
    
    private boolean renderConfirmaInstitucion;
    
    
 
    /** Almacena la confirmacion seleccionada*/
    private String confirmaMetodoSelect;
    
    /** Almacena la institucion seleccionada*/
    private String confirmaOtraInstiSelect;
    
    
    /** Lista que almacena la lista de los metodos de planificacion  */
    private List<SelectItem> listMetodoPlanificacion;
    
    /** Lista que almacena la lista de conductas  */
    private List<SelectItem> listConductas;
    
    /** Almacena la lista de opciones 'SI' o 'NO' */
    private List lstOpciones;
    
    /** Almacena la lista de entidades administrativas */ 
    private List<SelectItem> listEntidades;
    
    
    
    
 
     

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarSeguimientoAviseBean() {

    }

    public void init() {
             seguimiento = new Chseguavis();
             generoReporte = false; 
            
             if(fechaAsesoria!= null && usuario!= null){
            try {
                lstAsesoria = this.serviceLocator.getClinicoService().getAsesoriaUsuario(usuario,fechaAsesoria);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
        }
    
        
      
        
        
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

     /**
      * @param valueChangeEvent
      */
     public void setRenderAplazaDecision(ValueChangeEvent valueChangeEvent) {
         setRenderAplazaDecision((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }
         
         
    /**
     * @param confirmaMetodoSelect
     */
    public void setConfirmaMetodoSelect(String confirmaMetodoSelect) {
        this.confirmaMetodoSelect = confirmaMetodoSelect;
    }

    /**
     * @param valueChangeEvent
     */
    public void setConfirmaMetodoSelect(ValueChangeEvent valueChangeEvent) {
        setConfirmaMetodoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }   
    
    
    /**
     * @param confirmaOtraInstiSelect
     */
    public void setConfirmaOtraInstiSelect(String confirmaOtraInstiSelect) {
        this.confirmaOtraInstiSelect = confirmaOtraInstiSelect;
    }

    /**
     * @param valueChangeEvent
     */
    public void setConfirmaOtraInstiSelect(ValueChangeEvent valueChangeEvent) {
        setConfirmaOtraInstiSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
        
    

    /**
     * @param valueChangeEvent
     */
    public void setRenderEmbarazoMayor(ValueChangeEvent valueChangeEvent) {
         setRenderEmbarazoMayor((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }
               
         
    /**
     * @param valueChangeEvent
     */
    public void setRenderConducta(ValueChangeEvent valueChangeEvent) {
         setRenderConducta((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }     

    /**
     * @param valueChangeEvent
     */
    public void setRenderOtraConducta(ValueChangeEvent valueChangeEvent) {
         setRenderOtraConducta((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

    /**
     * @param valueChangeEvent
     */
    public void setRenderContinuaEmbarazo(ValueChangeEvent valueChangeEvent) {
        setRenderContinuaEmbarazo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderRemitirIlve(ValueChangeEvent valueChangeEvent) {
        setRenderRemitirIlve((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderIndecision(ValueChangeEvent valueChangeEvent) {
        setRenderIndecision((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderCostoAlto(ValueChangeEvent valueChangeEvent) {
        setRenderCostoAlto((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderEps(ValueChangeEvent valueChangeEvent) {
        setRenderEps((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderOtraIps(ValueChangeEvent valueChangeEvent) {
        setRenderOtraIps((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderAplicaCausal(ValueChangeEvent valueChangeEvent) {
        setRenderAplicaCausal((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        
    /**
     * @param valueChangeEvent
     */
    public void setRenderConfirmaMetodo(ValueChangeEvent valueChangeEvent) {
        setRenderConfirmaMetodo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        
    /**
     * @param valueChangeEvent
     */
    public void setRenderConfirmaInstitucion(ValueChangeEvent valueChangeEvent) {
        setRenderConfirmaInstitucion((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        
 
    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

   
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
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
    }

    /**
     * @param asesoria
     */
    public void setAsesoria(Chaseavise asesoria) {
        this.asesoria = asesoria;
    }

    /**
     * @return
     */
    public Chaseavise getAsesoria() {
        return asesoria;
    }

    /**
     * @param seguimiento
     */
    public void setSeguimiento(Chseguavis seguimiento) {
        this.seguimiento = seguimiento;
    }

    /**
     * @return
     */
    public Chseguavis getSeguimiento() {
        return seguimiento;
    }

    /**
     * @param fechaAsesoria
     */
    public void setFechaAsesoria(Date fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
    }

    /**
     * @return
     */
    public Date getFechaAsesoria() {
        return fechaAsesoria;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
    }


    /**
     * @param lstAsesoria
     */
    public void setLstAsesoria(List<Chaseavise> lstAsesoria) {
        this.lstAsesoria = lstAsesoria;
    }

    /**
     * @return
     */
    public List<Chaseavise> getLstAsesoria() {
        return lstAsesoria;
    }

    /**
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param renderRemitirIlve
     */
    public void setRenderRemitirIlve(boolean renderRemitirIlve) {
        this.renderRemitirIlve = renderRemitirIlve;
    }

    /**
     * @return
     */
    public boolean isRenderRemitirIlve() {
        return renderRemitirIlve;
    }

    /**
     * @param renderIndecision
     */
    public void setRenderIndecision(boolean renderIndecision) {
        this.renderIndecision = renderIndecision;
    }

    /**
     * @return
     */
    public boolean isRenderIndecision() {
        return renderIndecision;
    }

    /**
     * @param renderCostoAlto
     */
    public void setRenderCostoAlto(boolean renderCostoAlto) {
        this.renderCostoAlto = renderCostoAlto;
    }

    /**
     * @return
     */
    public boolean isRenderCostoAlto() {
        return renderCostoAlto;
    }

    /**
     * @param renderEps
     */
    public void setRenderEps(boolean renderEps) {
        this.renderEps = renderEps;
    }

    /**
     * @return
     */
    public boolean isRenderEps() {
        return renderEps;
    }

    /**
     * @param renderOtraIps
     */
    public void setRenderOtraIps(boolean renderOtraIps) {
        this.renderOtraIps = renderOtraIps;
    }

    /**
     * @return
     */
    public boolean isRenderOtraIps() {
        return renderOtraIps;
    }

    /**
     * @param renderEmbarazoMayor
     */
    public void setRenderEmbarazoMayor(boolean renderEmbarazoMayor) {
        this.renderEmbarazoMayor = renderEmbarazoMayor;
    }

    /**
     * @return
     */
    public boolean isRenderEmbarazoMayor() {
        return renderEmbarazoMayor;
    }

    /**
     * @param renderAplicaCausal
     */
    public void setRenderAplicaCausal(boolean renderAplicaCausal) {
        this.renderAplicaCausal = renderAplicaCausal;
    }

    /**
     * @return
     */
    public boolean isRenderAplicaCausal() {
        return renderAplicaCausal;
    }

    /**
     * @param renderContinuaEmbarazo
     */
    public void setRenderContinuaEmbarazo(boolean renderContinuaEmbarazo) {
        this.renderContinuaEmbarazo = renderContinuaEmbarazo;
    }

    /**
     * @return
     */
    public boolean isRenderContinuaEmbarazo() {
        return renderContinuaEmbarazo;
    }

    /**
     * @param renderAplazaDecision
     */
    public void setRenderAplazaDecision(boolean renderAplazaDecision) {
        this.renderAplazaDecision = renderAplazaDecision;
    }

    /**
     * @return
     */
    public boolean isRenderAplazaDecision() {
        return renderAplazaDecision;
    }

    /**
     * @param renderOtraConducta
     */
    public void setRenderOtraConducta(boolean renderOtraConducta) {
        this.renderOtraConducta = renderOtraConducta;
    }

    /**
     * @return
     */
    public boolean isRenderOtraConducta() {
        return renderOtraConducta;
    }

    /**
     * @param renderRemisionOtra
     */
    public void setRenderRemisionOtra(boolean renderRemisionOtra) {
        this.renderRemisionOtra = renderRemisionOtra;
    }

    /**
     * @return
     */
    public boolean isRenderRemisionOtra() {
        return renderRemisionOtra;
    }
    
    public void setRenderConfirmaMetodo(boolean renderConfirmaMetodo) {
        this.renderConfirmaMetodo = renderConfirmaMetodo;
    }

    public boolean isRenderConfirmaMetodo() {
        return renderConfirmaMetodo;
    }
  
    /**
     * @return
     */
    public List<SelectItem> getListMetodoPlanificacion() {
        if (listMetodoPlanificacion == null || 
            listMetodoPlanificacion.isEmpty()) {
            listMetodoPlanificacion = new ArrayList<SelectItem>();
            ArrayList<Chmetodoplan> listMetodoPlanificacionAux = null;
            try {
                listMetodoPlanificacionAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodoPlanificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listMetodoPlanificacionAux.isEmpty()) {    

                Iterator it = listMetodoPlanificacionAux.iterator();
                int i = 0;
                listMetodoPlanificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listMetodoPlanificacion.add(new SelectItem(listMetodoPlanificacionAux.get(i).getHmpccodigo(), 
                                                              listMetodoPlanificacionAux.get(i).getHmpcdescripcio()));
                    i++;
                }
            }
        }

        return listMetodoPlanificacion;
    }
    
    
    public void setListConductas(List<SelectItem> listConductas) {
        this.listConductas = listConductas;
    }

    public List<SelectItem> getListConductas() {
    if(listConductas == null || listConductas.isEmpty()){
        listConductas = new ArrayList<SelectItem>();
        
        listConductas.add(new SelectItem("", "Seleccione una opci�n ..."));
        listConductas.add(new SelectItem("", "Ive Farmacologico"));
        listConductas.add(new SelectItem("", "Ive Quirurgico"));
        listConductas.add(new SelectItem("", "Bloqueo para Cervical"));
        listConductas.add(new SelectItem("", "Terminacion Farmacologica"));
        listConductas.add(new SelectItem("", "Terminacion Quirugica"));
        
    }
    
        return listConductas;
    }
    

    //-----------------------------------------------------------------------
    //  Generacion Reporte
    //-----------------------------------------------------------------------
        

  
    
    public void generarResumenAsesoria(){
        this.index = -1;
        generoReporte = false; 
      
        Chaseavise aseAux = new Chaseavise(); 
        try {
            aseAux = this.serviceLocator.getClinicoService().getAsesoriaUsuario(usuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }
            if(aseAux != null){
                generoReporte = true; 
            }
            
          ConsultarAsesoriaBean consultarAsesoria = (ConsultarAsesoriaBean)FacesUtils.getManagedBean("consultarAsesoriaBean");
          consultarAsesoria.setUsuario(usuario);
          consultarAsesoria.generarResumenAsesoria(aseAux);
        }
   

    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    public String registrarSeguimiento(){
        generoReporte = false; 
        navegationRule = ""; 
        seguimiento.setHsaanumide(usuario.getHusanumeiden());
        seguimiento.setHsactipide(usuario.getHusetipoiden());
        seguimiento.getId().setHsadfecase(fechaAsesoria);
        seguimiento.getId().setHsalusuario(usuario.getHuslnumero());
        
        seguimiento.setHsacestado(ESTADO_VIGENTE);
        seguimiento.setHsacasesor(userName());
        seguimiento.setHsacusureg(userName());
        seguimiento.setHsadfecreg(new Date());
        seguimiento.setHsanclinic(this.getClinica().getCclncodigo());
        
        
        // SE REALIZAN LAS VALIDACIONES DE LA CONDUCTA 


        seguimiento.setHsacremotr("N");
        seguimiento.setHsacremind("N");
        seguimiento.setHsacremcos("N");
        seguimiento.setHsacremeps("N");
        seguimiento.setHsacremips("N");
        seguimiento.setHsacremcau("N");
        seguimiento.setHsacremmay("N");
        seguimiento.setHsacremcon("N");
        seguimiento.setHsacremotr("N");
        seguimiento.setHsacremilv("N");
        seguimiento.setHsacremapl("N");
        
        
      



        if (renderRemitirIlve) {
            seguimiento.setHsacremilv("S");
            
        }else{
            seguimiento.setHsacconduc(null);
        }

        if (renderIndecision) {
            seguimiento.setHsacremind("S");
        }

        if (renderCostoAlto) {
            seguimiento.setHsacremcos("S");
        }

        if (renderEps) {
            seguimiento.setHsacremeps("S");
        }

        if (renderOtraIps) {
            seguimiento.setHsacremips("S");
        }

        if (renderAplicaCausal) {
            seguimiento.setHsacremcau("S");
        }

        if (renderEmbarazoMayor) {
            seguimiento.setHsacremmay("S");
        } else {
            seguimiento.setHsanedages(null);
           
        }

        if (renderContinuaEmbarazo) {
            seguimiento.setHsacremcon("S");
        }

        if (renderOtraConducta) {
            seguimiento.setHsacremotr("S");
        } else {
            seguimiento.setHsacnmbotr(null);
        }

        if (renderAplazaDecision) {
            seguimiento.setHsacremapl("S");
        } else {
            seguimiento.setHsacremmot(null);
        }
     




        try {
            this.serviceLocator.getClinicoService().saveSeguimientoAvise(seguimiento);
            navegationRule = BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIA; 
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION + e.getMessage());
           e.printStackTrace();
        }
        
        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");
        return navegationRule; 
         
    }

    public void changeMetodo(){
        if(confirmaMetodoSelect != null && !confirmaMetodoSelect.equals("")){
            renderConfirmaMetodo = true;
        }else{
            renderConfirmaMetodo = false;
        }
    }
    
    public void changeInstitucion(){
        if (confirmaOtraInstiSelect != null && confirmaOtraInstiSelect.equals("N")){
        renderConfirmaInstitucion = true;
    }else{
        renderConfirmaInstitucion = false;
    }
    }
    
    public void setRenderConducta(boolean renderConducta) {
        this.renderConducta = renderConducta;
    }

    public boolean isRenderConducta() {
        return renderConducta;
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

    public void setListEntidades(List<SelectItem> listEntidades) {
        this.listEntidades = listEntidades;
    }

    public List<SelectItem> getListEntidades() {
        if (listEntidades == null || 
            listEntidades.isEmpty()) {
            listEntidades = new ArrayList<SelectItem>();
            ArrayList<Cpentidadadm> listEntidadesAux = null;
            try {
                listEntidadesAux = 
                        (ArrayList<Cpentidadadm>)this.serviceLocator.getClinicoService().getEntidadAdm();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEntidadesAux.isEmpty()) {

                Iterator it = listEntidadesAux.iterator();
                int i = 0;
                listEntidades.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listEntidades.add(new SelectItem(listEntidadesAux.get(i).getCeaccodigo(), 
                                                              listEntidadesAux.get(i).getCeacnombre()));
                    i++;
                }
            }
        }

        return listEntidades;
    }

    public String getConfirmaMetodoSelect() {
        return confirmaMetodoSelect;
    }

    public void setRenderConfirmaInstitucion(boolean renderConfirmaInstitucion) {
        this.renderConfirmaInstitucion = renderConfirmaInstitucion;
    }

    public boolean isRenderConfirmaInstitucion() {
        return renderConfirmaInstitucion;
    }


    public String getConfirmaOtraInstiSelect() {
        return confirmaOtraInstiSelect;
    }
}

