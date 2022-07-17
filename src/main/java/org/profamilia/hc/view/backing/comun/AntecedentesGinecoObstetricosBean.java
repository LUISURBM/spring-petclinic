package org.profamilia.hc.view.backing.comun;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chanteceobst;
import org.profamilia.hc.model.dto.ChanteceobstPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class AntecedentesGinecoObstetricosBean extends BaseBean {

    private Chanteceobst antecedente;
    
    private List lstOpciones;

    private String tieneTratamiento;

    private boolean mostrarTratamiento;

    private String tieneMalformacion;

    private boolean mostrarMalformacion;

    private String otrosObste;

    private boolean mostrarObstetricos;

    private boolean esCeroGestaciones;

    /** Almacena la lista de los tipos de ciclos regular e irregular */
    private List<SelectItem> lstTipoCiclo;

    private boolean cicloiregular;

    private Integer tipoHistoria;
    
    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;
    
    private Long numeroConsulta;



    public AntecedentesGinecoObstetricosBean() {
    }

    public void init() {
        lstOpciones = new ArrayList();
        lstTipoCiclo = new ArrayList<SelectItem>();

        inicializarAntecedentesGinecoObstetricos();
    }
    
    public void inicializarAntecedentesGinecoObstetricos(){
           try {
                antecedente = 
                        serviceLocator.getClinicoService().getAntecedenteObstetrico(numeroConsulta);
               
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (antecedente == null) {
                antecedente = new Chanteceobst();
            } else {
                tieneMalformacion = antecedente.getHaocmalformaci();
                tieneTratamiento = antecedente.getHaocttosrecibi();
                if (antecedente.getHaocmalformaci() != null && 
                    antecedente.getHaocmalformaci().equals("S")) {
                    mostrarMalformacion = true;
                }
                if (antecedente.getHaocttosrecibi() != null && 
                    antecedente.getHaocttosrecibi().equals("S")) {
                    mostrarTratamiento = true;
                }
                if (antecedente.getHaocotrosobste() != null && 
                    !antecedente.getHaocotrosobste().equals("")) {
                    mostrarObstetricos = true;
                    otrosObste = "S";
                } else {
                    otrosObste = "N";
                }


            }
    }


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }

    public void setTieneTratamiento(String tieneTratamiento) {
        this.tieneTratamiento = tieneTratamiento;
    }

    public void setTieneTratamiento(ValueChangeEvent valueChangeEvent) {
        setTieneTratamiento((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

   

    /**
     * @return
     */
    public String getTieneTratamiento() {
        return tieneTratamiento;
    }


    /**
     * @param lstTipoCiclo
     */
    public void setLstTipoCiclo(List<SelectItem> lstTipoCiclo) {
        this.lstTipoCiclo = lstTipoCiclo;
    }

    public List<SelectItem> getLstTipoCiclo() {
        if (lstTipoCiclo.size() == 0) {
            lstTipoCiclo.add(new SelectItem("", "Seleccione una opci�n "));
            lstTipoCiclo.add(new SelectItem("I", "Irregular"));
            lstTipoCiclo.add(new SelectItem("R", "Regular"));
        }
        return lstTipoCiclo;
    }


    


    public void changeTratamiento() {

        if (tieneTratamiento != null && tieneTratamiento.equals("S")) {
            mostrarTratamiento = true;
        } else {
            antecedente.setHaoccualesttos(null);
            mostrarTratamiento = false;
        }

    }

    public void setTieneMalformacion(String tieneMalformacion) {
        this.tieneMalformacion = tieneMalformacion;
    }

    public void setTieneMalformacion(ValueChangeEvent valueChangeEvent) {
        setTieneMalformacion((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getTieneMalformacion() {
        return tieneMalformacion;
    }

    public void changeMalformacion() {
        if (tieneMalformacion != null && tieneMalformacion.equals("S")) {
            mostrarMalformacion = true;
        } else {
            antecedente.setHaocmalforcual("");
            mostrarMalformacion = false;
        }
    }

    /**
     * @param otrosObste
     */
    public void setOtrosObste(String otrosObste) {
        this.otrosObste = otrosObste;
    }

    /**
     * @param valueChangeEvent
     */
    public void setOtrosObste(ValueChangeEvent valueChangeEvent) {
        setOtrosObste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @return
     */
    public String getOtrosObste() {
        return otrosObste;
    }


    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void changeOtrosObstetricos() {
        if (otrosObste != null && otrosObste.equals("S")) {
            mostrarObstetricos = true;
        } else {
            antecedente.setHaocotrosobste(null);
            mostrarObstetricos = false;
        }
    }


    public void setAntecedente(Chanteceobst antecedente) {
        this.antecedente = antecedente;
    }

    public Chanteceobst getAntecedente() {
        return antecedente;
    }

    public void setMostrarTratamiento(boolean mostrarTratamiento) {
        this.mostrarTratamiento = mostrarTratamiento;
    }

    public boolean isMostrarTratamiento() {
        return mostrarTratamiento;
    }

    public void setMostrarMalformacion(boolean mostrarMalformacion) {
        this.mostrarMalformacion = mostrarMalformacion;
    }

    public boolean isMostrarMalformacion() {
        return mostrarMalformacion;
    }

    public void setMostrarObstetricos(boolean mostrarObstetricos) {
        this.mostrarObstetricos = mostrarObstetricos;
    }

    public boolean isMostrarObstetricos() {
        return mostrarObstetricos;
    }

  

   
   

    public void setCicloiregular(boolean cicloiregular) {
        this.cicloiregular = cicloiregular;
    }

    public boolean isCicloiregular() {
        return cicloiregular;
    }

    public void setEsCeroGestaciones(boolean esCeroGestaciones) {
        this.esCeroGestaciones = esCeroGestaciones;
    }

    public boolean isEsCeroGestaciones() {
        return esCeroGestaciones;
    }
    
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
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

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public boolean esValido() {
      Chanteceobst antecedenteAux = null;
        boolean esValido = false;
          if (numeroConsulta != null) {
            try {
                antecedenteAux = 
                        this.getServiceLocator().getClinicoService().getAntecedenteObstetrico(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (antecedenteAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }
    
    
    public void changeTodosSi(){
        inicializarPreguntas("S");
        mostrarTratamiento = true; 
        mostrarMalformacion = true; 
        mostrarObstetricos = true; 
    }
    
    public void changeTodosNo(){
        inicializarPreguntas("N");
        mostrarTratamiento = false; 
        mostrarMalformacion = false; 
        mostrarObstetricos = false; 
    }
    
    public void changeNinguno(){
        mostrarTratamiento = false; 
        mostrarMalformacion = false; 
        mostrarObstetricos = false;
        inicializarPreguntas(null);
    }
    
    
    public void inicializarPreguntas(String opcion) {
        if(antecedente != null){
            antecedente.setHaocleucorreas(opcion);
            antecedente.setHaocets(opcion);
            antecedente.setHaoccitologia(opcion);
            antecedente.setHaoccolposcopi(opcion);
            antecedente.setHaochistoriain(opcion);
            antecedente.setHaocruppremenb(opcion);
            antecedente.setHaocrciu(opcion);
            tieneTratamiento = opcion; 
            antecedente.setHaocamenzparto(opcion);
            antecedente.setHaocpartoprema(opcion);
            antecedente.setHaocgemelar(opcion);
            antecedente.setHaocpolhidramn(opcion);
            antecedente.setHaocoligohidra(opcion);
            tieneMalformacion = opcion; 
            antecedente.setHaocembarprolo(opcion);
            antecedente.setHaocamenaabort(opcion);
            otrosObste = opcion; 
        }
    }



    public String  aceptar() {
       ChanteceobstPK id = new ChanteceobstPK();
        navigationRule = ""; 
        if (numeroConsulta != null) {
            id.setHaolconsulta(numeroConsulta);
            id.setHaoctiposervi(tipoServicio);
            antecedente.setId(id);
        }
        
        

        antecedente.setHaodfecharegis(new Date());
        antecedente.setHaocoperador(userName());
        if (tieneTratamiento != null && !tieneTratamiento.equals("")) {
            antecedente.setHaocttosrecibi(tieneTratamiento);
        }
        
        if(tieneTratamiento == null || tieneTratamiento.equals("N")){
            antecedente.setHaoccualesttos(null);
        }
        
                
        if (tieneMalformacion != null && !tieneMalformacion.equals("")) {
            antecedente.setHaocmalformaci(tieneMalformacion);
        }
        
        
      
        if(tieneMalformacion == null || tieneMalformacion.equals("N")){
            antecedente.setHaocmalforcual(null);
        }
        
        if(otrosObste == null || otrosObste.equals("N")){
            antecedente.setHaocotrosobste(null);
        }

        try {
            this.serviceLocator.getClinicoService().saveAntecedenteObstetrico(antecedente);
            navigationRule = nextAction; 
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
        
        return navigationRule; 
    }


   
}
