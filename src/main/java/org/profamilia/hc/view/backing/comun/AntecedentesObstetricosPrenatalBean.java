package org.profamilia.hc.view.backing.comun;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chanteobstpr;
import org.profamilia.hc.model.dto.ChanteobstprPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class AntecedentesObstetricosPrenatalBean extends BaseBean {

    private Chanteobstpr antecedente;
    
    private List lstOpciones;
    
    private List lstTipoParto;
    
    private List lstTerminoParto; 

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
    
    private UIInput itNumGesta;
    
    private boolean renderPreclampsia;
    
    private boolean renderEclampsia;
    
    private boolean renderCausas; 
    
    private boolean renderMalformaciones;
    
    private boolean renderPeriodoInterCorto; 

    private List lstViaParto;
    
    private boolean esCeroPartos;
    
    private boolean renderedGest1;
    private boolean renderedGest2;
    private boolean renderedParto;
    private boolean renderedNacidoVivo;




    public AntecedentesObstetricosPrenatalBean() {
    }

    public void init() {
       
        lstOpciones = new ArrayList();
        lstTipoParto = new ArrayList();
        lstTerminoParto = new ArrayList();
        lstTipoCiclo = new ArrayList<SelectItem>();
        lstViaParto = new ArrayList<SelectItem>();

        inicializarAntecedentesGinecoObstetricos();
    }
    
    public void inicializarAntecedentesGinecoObstetricos(){
        itNumGesta= null;
        antecedente= new Chanteobstpr();
        renderPreclampsia=false;
        renderEclampsia=false;
        renderCausas=false;
        renderMalformaciones=false;
        renderPeriodoInterCorto=false;
           try {
                antecedente = 
                        serviceLocator.getClinicoService().getAntecedenteObstetricopr(numeroConsulta);
               
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (antecedente == null) {
                antecedente = new Chanteobstpr();
            } else {
              changeNumeroGestaciones();
              changeEclampsia();
              changeMalformaciones();
              changePreclampsia();
              changeMuertes();
              changePeriodoInterCorto();
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
         
            mostrarObstetricos = false;
        }
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
      Chanteobstpr antecedenteAux = null;
        boolean esValido = false;
          if (numeroConsulta != null) {
            try {
                antecedenteAux = 
                        this.getServiceLocator().getClinicoService().getAntecedenteObstetricopr(numeroConsulta);
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
        renderPeriodoInterCorto=true;
        renderMalformaciones = true;
        renderCausas = true;
        renderEclampsia = true;
        renderPreclampsia = true;
    }
    
    public void changeTodosNo(){
        inicializarPreguntas("N");
        mostrarTratamiento = false; 
        mostrarMalformacion = false; 
        mostrarObstetricos = false;
        renderPeriodoInterCorto = false;
        renderMalformaciones = false;
        renderCausas = false;
        renderEclampsia = false;
        renderPreclampsia = false;
        antecedente.setHaocdesprecla(null);
        antecedente.setHaocdeseclamp(null);
        antecedente.setHaocmuepercual(null);
        antecedente.setHaocmalforcual(null);
        antecedente.setHaocpeincocual(null);
    }
    
    public void changeNinguno(){
        mostrarTratamiento = false; 
        mostrarMalformacion = false; 
        mostrarObstetricos = false;
        renderPeriodoInterCorto = false;
        renderMalformaciones = false;
        renderMalformaciones = false;
        renderCausas = false;
        renderEclampsia = false;
        renderPreclampsia = false;
        antecedente.setHaocdesprecla(null);
        antecedente.setHaocdeseclamp(null);
        antecedente.setHaocmuepercual(null);
        antecedente.setHaocmalforcual(null);
        antecedente.setHaocpeincocual(null);
        inicializarPreguntas(null);
    }
    
    
    public void inicializarPreguntas(String opcion) {
        if(antecedente != null){
            antecedente.setHaocleucorreas(opcion);
           
            tieneTratamiento = opcion; 
        
            antecedente.setHaocgemelar(opcion);
            antecedente.setHaocplacprevi(opcion);
            antecedente.setHaocabrupio(opcion);
            antecedente.setHaocrupprememb(opcion);
            antecedente.setHaocpolhidramn(opcion);
            antecedente.setHaocoligohidra(opcion);
            antecedente.setHaocretcrcint(opcion);
            antecedente.setHaocretplace(opcion);
            antecedente.setHaocinfepost(opcion);
            antecedente.setHaocleucorreas(opcion);
            antecedente.setHaocpreclamps(opcion);
            antecedente.setHaoccolposcopi(opcion);
            antecedente.setHaoceclampsia(opcion);
            antecedente.setHaocamenaparto(opcion);
            antecedente.setHaocamenaabort(opcion);
            antecedente.setHaocmueperinat(opcion);
            antecedente.setHaocgemelar(opcion);
            antecedente.setHaocmalformaci(opcion);
            antecedente.setHaocperintcor(opcion);
            antecedente.setHaochemoobst(opcion);
            
            antecedente.setHaocpolhidramn(opcion);
            antecedente.setHaocoligohidra(opcion);
            tieneMalformacion = opcion; 
           
            antecedente.setHaocamenaabort(opcion);
            otrosObste = opcion; 
        }
    }



    public String  aceptar() {
       ChanteobstprPK id = new ChanteobstprPK();
        navigationRule = ""; 
        if (numeroConsulta != null) {
            id.setHaolconsulta(numeroConsulta);
            id.setHaoctiposervi(tipoServicio);
            antecedente.setId(id);
        }
        
        

        antecedente.setHaodfecharegis(new Date());
        antecedente.setHaocoperador(userName());
      
        
       
        if(antecedente != null && antecedente.getHaocmalformaci()!= null 
               && antecedente.getHaocmalformaci().equals("N") ){
               antecedente.setHaocmalforcual(null);
           }

           if(antecedente != null && antecedente.getHaocmueperinat()!= null 
               && antecedente.getHaocmueperinat().equals("N") ){
               antecedente.setHaocmuepercual(null);
           }

           if(antecedente != null && antecedente.getHaoceclampsia()!= null 
               && antecedente.getHaoceclampsia().equals("N") ){
               antecedente.setHaocdeseclamp(null);
           }


           if(antecedente != null && antecedente.getHaocpreclamps()!= null 
               && antecedente.getHaocpreclamps().equals("N") ){
               antecedente.setHaocdesprecla(null); 
           }
        
            if(antecedente != null && antecedente.getHaocperintcor()!= null 
            && antecedente.getHaocperintcor().equals("N") ){
                antecedente.setHaocpeincocual(null); 
            }

        
        
      
       
      

        try {
            this.serviceLocator.getClinicoService().saveAntecedenteObstetricopr(antecedente);
            navigationRule = nextAction; 
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
        
        return navigationRule; 
    }


    public void setAntecedente(Chanteobstpr antecedente) {
        this.antecedente = antecedente;
    }

    public Chanteobstpr getAntecedente() {
        return antecedente;
    }

 

    public void setItNumGesta(UIInput itNumGesta) {
        this.itNumGesta = itNumGesta;
    }

    public UIInput getItNumGesta() {
        return itNumGesta;
    }
    
    public void setLstTipoParto(List lstTipoParto) {
        this.lstTipoParto = lstTipoParto;
    }

    public List getLstTipoParto() {
        if (lstTipoParto.size() == 0) {
            lstTipoParto.add(new SelectItem("U", "Parto Unico"));
            lstTipoParto.add(new SelectItem("M", "Parto Multiples"));

        }

        return lstTipoParto;
        }

    public void setLstTerminoParto(List lstTerminoParto) {
        this.lstTerminoParto = lstTerminoParto;
    }

    public List getLstTerminoParto() {
        if (lstTerminoParto.size() == 0) {
            lstTerminoParto.add(new SelectItem("PRE", "Prematuro"));
            lstTerminoParto.add(new SelectItem("ATE", "A Termino"));
            lstTerminoParto.add(new SelectItem("PRO", "Prolongado"));

        }

        return lstTerminoParto;
        }

    public void setRenderPreclampsia(boolean renderPreclampsia) {
        this.renderPreclampsia = renderPreclampsia;
    }

    public boolean isRenderPreclampsia() {
        return renderPreclampsia;
    }

    public void setRenderEclampsia(boolean renderEclampsia) {
        this.renderEclampsia = renderEclampsia;
    }

    public boolean isRenderEclampsia() {
        return renderEclampsia;
    }

    public void setRenderCausas(boolean renderCausas) {
        this.renderCausas = renderCausas;
    }

    public boolean isRenderCausas() {
        return renderCausas;
    }

    public void setRenderMalformaciones(boolean renderMalformaciones) {
        this.renderMalformaciones = renderMalformaciones;
    }

    public boolean isRenderMalformaciones() {
        return renderMalformaciones;
    }

    public void setHaocmueperinat(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaocmueperinat((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHaocmalformaci(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaocmalformaci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHaoceclampsia(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaoceclampsia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHaocpreclamps(ValueChangeEvent valueChangeEvent) {
         antecedente.setHaocpreclamps((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    public void changeMalformaciones(){
        renderMalformaciones = false; 
        if(antecedente != null && antecedente.getHaocmalformaci()!= null 
            && antecedente.getHaocmalformaci().equals("S") ){
            renderMalformaciones = true; 
        }
    }
    public void changeMuertes(){
     renderCausas = false; 
        if(antecedente != null && antecedente.getHaocmueperinat()!= null 
            && antecedente.getHaocmueperinat().equals("S") ){
            renderCausas = true; 
        }
        }
    public void changeEclampsia(){
        renderEclampsia = false; 
        if(antecedente != null && antecedente.getHaoceclampsia()!= null 
            && antecedente.getHaoceclampsia().equals("S") ){
            renderEclampsia = true; 
        }
        }
    public void changePreclampsia(){
        renderPreclampsia = false; 
        if(antecedente != null && antecedente.getHaocpreclamps()!= null 
            && antecedente.getHaocpreclamps().equals("S") ){
            renderPreclampsia = true; 
        }
        }


    public void setRenderPeriodoInterCorto(boolean renderPeriodoInterCorto) {
        this.renderPeriodoInterCorto = renderPeriodoInterCorto;
    }

    public boolean isRenderPeriodoInterCorto() {
        return renderPeriodoInterCorto;
    }
    
    public void setHaocperintcor(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaocperintcor((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changePeriodoInterCorto(){
        renderPeriodoInterCorto = false; 
        if(antecedente != null && antecedente.getHaocperintcor()!= null 
            && antecedente.getHaocperintcor().equals("S") ){
            renderPeriodoInterCorto = true; 
        }
    }

    public void setLstViaParto(List lstViaParto) {
        this.lstViaParto = lstViaParto;
    }

    public List getLstViaParto() {
        if (lstViaParto.isEmpty() || lstViaParto == null) {
            lstViaParto.add(new SelectItem("V", "Vaginal"));
            lstViaParto.add(new SelectItem("C", "Ces�rea"));

        }
        return lstViaParto;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroGestaciones(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaonnumgesta((Integer) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroPartos(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaonnumparto((Integer) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroHijosVivos(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaonnacivivo((Integer) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeNumeroGestaciones() {
        esCeroPartos = false;
        if(antecedente != null && antecedente.getHaonnumgesta()!=null){
        if (antecedente != null && antecedente.getHaonnumgesta() == 1) {
            renderedGest1=true;
            renderedGest2=false;
            renderPeriodoInterCorto=false;
            antecedente.setHaocpeincocual(null);
            
        } else if (antecedente != null &&  antecedente.getHaonnumgesta() >= 2) {
            renderedGest1=true;
            renderedGest2=true;
            
        }else if(antecedente != null &&  antecedente.getHaonnumgesta() <= 0){
          
            renderedGest1=false;
            renderedGest2=false;
            changeTodosNo();
            FacesUtils.addErrorMessage("Numero de gestaciones no valido, por favor verificar.");
         }
        }
}

    public void changeNumeroPartos() {
       
        if(antecedente != null && antecedente.getHaonnumparto()!=null){
        if (antecedente != null && antecedente.getHaonnumparto() >= 1) {
             renderedParto=true;
          }
          else{
              renderedParto=false;
          }
        }
    }
    
    public void changeNumeroHijosVivos() {
      if(antecedente != null && antecedente.getHaonnacivivo()!=null){
        if (antecedente != null && antecedente.getHaonnacivivo() >= 1) {
             renderedNacidoVivo=true;
          }
          else{
              renderedNacidoVivo=false;
              
          }
        }
    }
    
    

    public void setEsCeroPartos(boolean esCeroPartos) {
        this.esCeroPartos = esCeroPartos;
    }

    public boolean isEsCeroPartos() {
        return esCeroPartos;
    }

    public void setRenderedGest1(boolean renderedGest1) {
        this.renderedGest1 = renderedGest1;
    }

    public boolean isRenderedGest1() {
        return renderedGest1;
    }

    public void setRenderedGest2(boolean renderedGest2) {
        this.renderedGest2 = renderedGest2;
    }

    public boolean isRenderedGest2() {
        return renderedGest2;
    }

    public void setRenderedParto(boolean renderedParto) {
        this.renderedParto = renderedParto;
    }

    public boolean isRenderedParto() {
        return renderedParto;
    }

    public void setRenderedNacidoVivo(boolean renderedNacidoVivo) {
        this.renderedNacidoVivo = renderedNacidoVivo;
    }

    public boolean isRenderedNacidoVivo() {
        return renderedNacidoVivo;
    }

 
}
