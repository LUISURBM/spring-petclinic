package org.profamilia.hc.view.backing.procedimiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantecolpo;
import org.profamilia.hc.model.dto.ChantecolpoPK;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class AntecedentesColposcopiaBean extends BaseBean {

    private Chantecolpo antecedente;

    private boolean esCeroGestaciones;

    /** Almacena la lista de los metodos de planificacion para el examen de mama  */
    private List<SelectItem> lstMetodos;
    
    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private List lstOpciones;
    
    private Long numeroConsulta;
    
    private Integer tipoHistoria; 
    
    private String nextAction;
    
    private boolean renderNumeroDosis; 
    
    private boolean renderResultado;
    
    private boolean renderVIH;
    
    private boolean renderETS;
    
    private boolean renderDiabetes;
    
    private boolean renderFuma;
    
    private boolean renderResultadoCitologia;

    
    private UIInput  itNumGesta; 
    
    private UIInput  itNumPartos;
    
    private UIInput  itNumAbortos;
    
    private UIInput  itNumcesareas;
    
    private UIInput  itNumHijosVivos;
    
   
    private UIInput  itNumEctopicos;
    
    private UIInput  itNumHijosMortinatos;
    
    private UIInput  itNumHijosMuertos;
    
    private UIInput itFechaParto;

    private UIInput itFechaRegla;

    private UIInput itPenFechaRegla;
    
    private UIInput itAntFechaRegla;
    
    private boolean mostrarFechaFUP;
    
    
    /** Almacena la lista de las fechas de ultima citologia */
    private List<SelectItem> lstUltimaCitologia;


    /** Almacena true si los campos del caso de uso son obligatorios para el tipo de historia*/
    private boolean camposRequeridos;

    
    /** Almacena true si el numero de gestaciones es cero */
    private boolean esCeroPartos;   

    /** Almacena true si el numero de abortos es cero */
    private boolean esCeroAbortos;   
    
    private boolean renderOtroResultado; 
    
    private UIInput mnuResultado; 
    
    /** Almacena la lista de los tipos de ciclos regular e irregular */
    private List<SelectItem> lstTipoCiclo;
    
    private boolean tieneCiclo;
    
    private boolean renderMenarquia; 
    
    /** Almacena true si el ciclo es regular */
    private boolean cicloiregular;
    
    private UIInput mnuUltima; 
    
    private boolean mostrarMetodo;
    
    private boolean mostrarInyectable; 
    
    private boolean mostrarPildoras;  
    
    private boolean mostrarPildorasSi;
    
    private boolean renderGenotipificacion; 
    
    private List lstMetodo;
    
    private List lstResultado;

    


    public AntecedentesColposcopiaBean() {
    }


    public void init() {
       lstMetodos = new ArrayList<SelectItem>();
       lstOpciones = new ArrayList();
        camposRequeridos = true;
        mostrarPildoras = false;
        mostrarPildorasSi = false;
        mostrarInyectable = false;
        inicializarAntecedentes();
        nextAction = "";
        mostrarFechaFUP = false;
        renderETS = false; 
        renderDiabetes = false; 
        renderFuma = false; 
        renderVIH = false; 
     //  renderPlaneaEmbarazo = true;
        
    //    msgplaneaembarazo = ""; 
       inicializarAntecedentes();
    }
    
    public void inicializarAntecedentes(){

                try {
                    antecedente = 
                            this.serviceLocator.getClinicoService().getAntecedentesColposcopia(numeroConsulta);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (antecedente == null) {
                    antecedente = new Chantecolpo();
                } else{
                    if(antecedente.getHacevacunvph()!= null &&antecedente.getHacevacunvph().equals("S") ){
                        renderNumeroDosis = true; 
                    }
                    
                    if(antecedente.getHaccantecprevi()!= null &&antecedente.getHaccantecprevi().equals("S") ){
                        renderResultado = true; 
                    }
                    
                    
                    else {
                            
                                                         
                                
                                                               
                                if(antecedente.getHacnnumgesta() != null && antecedente.getHacnnumgesta().equals(new Integer(0))){
                                    esCeroGestaciones = true; 
                                    esCeroPartos = true; 
                                }
                                
                                if(antecedente.getHacnnumparto() != null && antecedente.getHacnnumparto().equals(new Integer(0))){
                                    esCeroPartos = true; 
                                }

                                if(antecedente.getHacnnumaborto() != null && antecedente.getHacnnumaborto().equals(new Integer(0))){
                                    esCeroAbortos = true; 
                                }
                                
                                if(antecedente.getHaccultcitolo() != null && !antecedente.getHaccultcitolo().equals("NO")){
                                    renderResultadoCitologia = true; 
                                    if(antecedente.getHaccresulcitol()!= null && antecedente.getHaccresulcitol().equals("2.2") ){
                                        renderOtroResultado = true; 
                                    }
                                }
                                
                                if(antecedente.getHaccmetodoplan()!= null && antecedente.getHaccmetodoplan().equals("0") ){
                                    mostrarMetodo = true; 
                                }
                                
                                if(antecedente.getHaccmetodoplan() != null && antecedente.getHaccmetodoplan().equals("890201.1")){
                                    mostrarInyectable = true;
                                }
                                
                                if(antecedente.getHaccmetodoplan() != null && antecedente.getHaccmetodoplan().equals("890201.4")){
                                    mostrarPildoras = true;
                                    if (antecedente.getHaccpildouso() != null && antecedente.getHaccpildouso().equals("S")) {
                                        mostrarPildorasSi = true;
                                    } else {
                                        mostrarPildorasSi = false;
                                    }
                                }
                                
                                if(antecedente.getHaccnoaplica()!= null){
                                    if(antecedente.getHaccnoaplica().equals("S")){
                                        mostrarFechaFUP = true;
                                    }else{
                                        mostrarFechaFUP= false;
                                    }
                                }
                                
                              
                            }
                            
                    changeTipo();
                    changeFecha();
                    ChangeMetodo();
                    changeProcedimietosCuello();
                    changeResultado();
                    ChangePildoras();
                    changeUltimaCitologia();
                    changeVph();
                    changeTipificacion();
                    changeDiabetes();
                    changeETS();
                    changeVih();
                    changeFuma();
                
                    
                }

    }


  


    // esValido

    /**
     * @return true si los antecedentes se registraron exitosamente
     */
    public boolean esValido() {
        boolean esValido = false;

        Chantecolpo antecedenteAux = null;
        if (numeroConsulta != null) {
            try {
                antecedenteAux = 
                        this.getServiceLocator().getClinicoService().getAntecedentesColposcopia(numeroConsulta);
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


    // Accion Forma

    public String  aceptar() {
        ChantecolpoPK id = new ChantecolpoPK();
        navigationRule = ""; 
        if (numeroConsulta != null) {
            id.setHaclconsulta(numeroConsulta);
            id.setHacctiposervi(TIPO_CONSULTA);
            antecedente.setId(id);
        }
        
        if(!renderFuma){
            antecedente.setHaccfuma(null);
        }
        
        if(!renderETS){
            antecedente.setHaccets(null);
        }
    
        
        if(!renderVIH){
            antecedente.setHaccvih(null);
        }
        
        
        if(!renderDiabetes){
            antecedente.setHaccdiabetes(null);
        }
        
        
        
        
        antecedente.setHacdfecregistr(new Date());
        antecedente.setHaccoperador(userName());
        
        if(antecedente.getHacevacunvph()== null || antecedente.getHacevacunvph() == null || antecedente.getHacevacunvph().equals("N") ){
            antecedente.setHacnnumervph(null);
        }
        
        if(antecedente.getHaccantecprevi()== null || antecedente.getHaccantecprevi() == null || antecedente.getHaccantecprevi().equals("N") ){
            antecedente.setHaccresulproce(null);
        }


        try {
            this.serviceLocator.getClinicoService().saveAntecedentesColposcopia(antecedente);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            navigationRule = nextAction; 
            FacesUtils.resetManagedBean(menuBean);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
        
        return navigationRule; 

    }


    /**
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
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
     * @param antecedente
     */
    public void setAntecedente(Chantecolpo antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * @return
     */
    public Chantecolpo getAntecedente() {
        return antecedente;
    }


    /**
     * @param esCeroGestaciones
     */
    public void setEsCeroGestaciones(boolean esCeroGestaciones) {
        this.esCeroGestaciones = esCeroGestaciones;
    }

    /**
     * @return
     */
    public boolean isEsCeroGestaciones() {
        return esCeroGestaciones;
    }


    /**
     * @param lstMetodos
     */
    public void setLstMetodos(List<SelectItem> lstMetodos) {
        this.lstMetodos = lstMetodos;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstMetodos() {
        if (lstMetodos.size() == 0) {
            ArrayList<Chmetodoplan> lstMetodosAux;
            lstMetodosAux = null;
            try {
                lstMetodosAux = 
                        (ArrayList<Chmetodoplan>)this.getServiceLocator().getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstMetodosAux != null && !lstMetodosAux.isEmpty()) {

                Iterator it = lstMetodosAux.iterator();
                int i = 0;
                lstMetodos.add(new SelectItem("", "Seleccione una opci�n"));
                while (it.hasNext()) {
                    it.next();
                    lstMetodos.add(new SelectItem(lstMetodosAux.get(i).getHmpccodigo().toString(), 
                                                  lstMetodosAux.get(i).getHmpcdescripcio()));
                    i++;
                }
            }
        }
        return lstMetodos;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    public void setRenderNumeroDosis(boolean renderNumeroDosis) {
        this.renderNumeroDosis = renderNumeroDosis;
    }

    public boolean isRenderNumeroDosis() {
        return renderNumeroDosis;
    }

    public void setRenderResultado(boolean renderResultado) {
        this.renderResultado = renderResultado;
    }

    public boolean isRenderResultado() {
        return renderResultado;
    }
    
    
    public void changeVph(){
        renderNumeroDosis = false; 
        if(antecedente.getHacevacunvph()!= null &&antecedente.getHacevacunvph().equals("S") ){
            renderNumeroDosis = true; 
        }
    }
    
    
    public void changeProcedimietosCuello(){
        renderResultado= false; 
        if(antecedente.getHaccantecprevi()!= null &&antecedente.getHaccantecprevi().equals("S") ){
            renderResultado = true; 
        }
    }

    public void setHacevacunvph(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacevacunvph((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

    public void setHaccantecprevi(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaccantecprevi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setItNumGesta(UIInput itNumGesta) {
        this.itNumGesta = itNumGesta;
    }

    public UIInput getItNumGesta() {
        return itNumGesta;
    }

    public void setItNumPartos(UIInput itNumPartos) {
        this.itNumPartos = itNumPartos;
    }

    public UIInput getItNumPartos() {
        return itNumPartos;
    }

    public void setItNumAbortos(UIInput itNumAbortos) {
        this.itNumAbortos = itNumAbortos;
    }

    public UIInput getItNumAbortos() {
        return itNumAbortos;
    }

    public void setItNumcesareas(UIInput itNumcesareas) {
        this.itNumcesareas = itNumcesareas;
    }

    public UIInput getItNumcesareas() {
        return itNumcesareas;
    }

    public void setItNumHijosVivos(UIInput itNumHijosVivos) {
        this.itNumHijosVivos = itNumHijosVivos;
    }

    public UIInput getItNumHijosVivos() {
        return itNumHijosVivos;
    }

  

    public void setItNumEctopicos(UIInput itNumEctopicos) {
        this.itNumEctopicos = itNumEctopicos;
    }

    public UIInput getItNumEctopicos() {
        return itNumEctopicos;
    }

    public void setItNumHijosMortinatos(UIInput itNumHijosMortinatos) {
        this.itNumHijosMortinatos = itNumHijosMortinatos;
    }

    public UIInput getItNumHijosMortinatos() {
        return itNumHijosMortinatos;
    }

    public void setItNumHijosMuertos(UIInput itNumHijosMuertos) {
        this.itNumHijosMuertos = itNumHijosMuertos;
    }

    public UIInput getItNumHijosMuertos() {
        return itNumHijosMuertos;
    }
    
    
 



    public void changeNumeroGestaciones() {

        if (antecedente != null && antecedente.getHacnnumgesta()!= null) {
            // Verificamos si el numero de gestaciones es cero los campos de partos, abortos, cesareas
            // vivos, ectopicos, mortinatos e hijos muertos es cero.
            if (antecedente.getHacnnumgesta().compareTo(0) == 0) {
                antecedente.setHacnectopico(0);
                antecedente.setHacnmortina(0);
                antecedente.setHacnmolas(0);
                antecedente.setHacnnumaborto(0);
                antecedente.setHacnnumcesare(0);
                antecedente.setHacnnumparto(0);
                antecedente.setHacnnumvivo(0);

                
                
                itNumPartos.setValue(0);
                itNumAbortos.setValue(0);
                itNumcesareas.setValue(0);
                itNumHijosVivos.setValue(0);
                
                itNumEctopicos.setValue(0);
                itNumHijosMortinatos.setValue(0);
                itNumHijosMuertos.setValue(0);
                
                
                esCeroGestaciones = true;
                esCeroPartos = true;
                esCeroAbortos = true;
            } else {
                Integer numero = null;
                esCeroGestaciones = false;
                esCeroPartos = false; 
                esCeroAbortos = false;
                antecedente.setHacnectopico(numero);
                antecedente.setHacnmortina(numero);
                antecedente.setHacnmolas(numero);
                antecedente.setHacnnumaborto(numero);
                antecedente.setHacnnumcesare(numero);
                antecedente.setHacnnumparto(numero);
                antecedente.setHacnnumvivo(numero);
                
                
                
                itNumPartos.setValue(numero);
                itNumAbortos.setValue(numero);
                itNumcesareas.setValue(numero);
                itNumHijosVivos.setValue(numero);
                itNumEctopicos.setValue(numero);
                itNumHijosMortinatos.setValue(numero);
                itNumHijosMuertos.setValue(numero);
                
                
            }
        }
    }
    
    public void ChangePildoras() {
        if (antecedente != null && antecedente.getHaccpildouso() != null 
           && antecedente.getHaccpildouso().equals("S")) {
               mostrarPildorasSi = true;
        } else {
               mostrarPildorasSi = false;
               antecedente.setHaccpildoobser(null);
        }
    }

    
    
    public void ChangeMetodo() {

        if (antecedente != null && antecedente.getHaccmetodoplan() != null &&
            antecedente.getHaccmetodoplan().equals("0")) {
            mostrarMetodo = true;
            mostrarInyectable = false;
            antecedente.setHacdfeultiapl(null);
            mostrarPildoras = false;
            mostrarPildorasSi = false;
            antecedente.setHaccpildoobser(null);
            antecedente.setHaccpildouso(null);
        }else if(antecedente != null && antecedente.getHaccmetodoplan() != null &&
            antecedente.getHaccmetodoplan().equals("890201.1")){
            mostrarMetodo = false;
            antecedente.setHaccotrometodo(null);
            mostrarInyectable = true;
            mostrarPildoras = false;
            mostrarPildorasSi = false;
            antecedente.setHaccpildoobser(null);
            antecedente.setHaccpildouso(null);
        }else if(antecedente != null && antecedente.getHaccmetodoplan() != null &&
            antecedente.getHaccmetodoplan().equals("890201.2")){
            mostrarMetodo = false;
            antecedente.setHaccotrometodo(null);
            mostrarInyectable = true;
            //antecedente.setHacdfeultiapl(null);
            mostrarPildoras = false;
            mostrarPildorasSi = false;
            antecedente.setHaccpildoobser(null);
            antecedente.setHaccpildouso(null);
        }else if(antecedente != null && antecedente.getHaccmetodoplan() != null &&
            antecedente.getHaccmetodoplan().equals("890201.4")){
            mostrarMetodo = false;
            antecedente.setHaccotrometodo(null);
            mostrarInyectable = false;
            //antecedente.setHacdfeultiapl(null);
            mostrarPildoras = true;
            if (antecedente.getHaccpildouso() != null && antecedente.getHaccpildouso().equals("S")) {
                mostrarPildorasSi = true;
            } else {
                mostrarPildorasSi = false;
            }
        }else{
            mostrarMetodo = false;
            antecedente.setHaccotrometodo(null);
            mostrarInyectable = false;
            //antecedente.setHacdfeultiapl(null);
            mostrarPildoras = false;
            mostrarPildorasSi = false;
            antecedente.setHaccpildoobser(null);
            antecedente.setHaccpildouso(null);
        }
    }
    
    
    public void changeNumeroParto() {

        if (antecedente != null && antecedente.getHacnnumparto()!= null) {
            // Verificamos si el numero de gestaciones es cero los campos de partos, abortos, cesareas
            // vivos, ectopicos, mortinatos e hijos muertos es cero.
            changeValidacionItemsEmbarazos(); 
            if (antecedente.getHacnnumparto().compareTo(0) == 0) {
                            
                
                esCeroPartos = true;
            } else {
                esCeroPartos = false;
                itFechaParto.setValue(null);
            }
        }
    }

    public void changeNumeroAbortos() {
        if (antecedente != null && antecedente.getHacnnumaborto()!= null) {
             changeValidacionItemsEmbarazos(); 
            if (antecedente.getHacnnumaborto().compareTo(0) == 0) {
                esCeroAbortos = true;
            } else {
                esCeroAbortos = false;
            }
        }
    }

    public boolean changeValidacionItemsEmbarazos() {
        if (antecedente != null && antecedente.getHacnnumgesta() != null) {
            if (antecedente.getHacnnumgesta().compareTo(0) != 0) {
                int gestaciones = antecedente.getHacnnumgesta();
                int suma = 0;

                if (antecedente.getHacnectopico()!= null) {
                    suma = suma + antecedente.getHacnectopico();
                }
                if (antecedente.getHacnmortina()!= null) {
                    suma = suma + antecedente.getHacnmortina();
                } 
                if (antecedente.getHacnmolas()!= null) {
                    suma = suma + antecedente.getHacnmolas();
                } 
                if (antecedente.getHacnnumaborto()!= null) {
                    suma = suma + antecedente.getHacnnumaborto();
                }
                if (antecedente.getHacnnumcesare()!= null) {
                    suma = suma + antecedente.getHacnnumcesare();
                }
                if (antecedente.getHacnnumparto()!= null) {
                    suma = suma + antecedente.getHacnnumparto();
                }

                if (gestaciones < suma) {
                    FacesUtils.addErrorMessage("Cerciorese de los datos de la formula obstetrica");
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;

    }

    public void changeNumeroCesarias() {
        if (antecedente != null && antecedente.getHacnnumcesare() != null) {
            changeValidacionItemsEmbarazos();
            
        }
    }

    public void changeNumeroMortinatos() {
        if (antecedente != null && antecedente.getHacnmortina() != null) {
            changeValidacionItemsEmbarazos();
        }
    }

    public void changeNumeroMolas() {
        if (antecedente != null && antecedente.getHacnmolas() != null) {
            changeValidacionItemsEmbarazos();
        }
    }

    public void changeNumeroEctopicos() {
        if (antecedente != null && antecedente.getHacnectopico() != null) {
            changeValidacionItemsEmbarazos();
        }
    }


    


  
    
    
    public void changeUltimaCitologia() {
        if (antecedente.getHaccultcitolo() != null && !antecedente.getHaccultcitolo().equals("N")) {
            renderResultadoCitologia = true;
        } else {
            antecedente.setHaccresulcitol(null);
            renderResultadoCitologia = false;
            renderOtroResultado = false;
            //mnuResultado.setValue(null);
            antecedente.setHaccotroresul(null);
        }
    }

    public void setItFechaParto(UIInput itFechaParto) {
        this.itFechaParto = itFechaParto;
    }

    public UIInput getItFechaParto() {
        return itFechaParto;
    }

    public void setItFechaRegla(UIInput itFechaRegla) {
        this.itFechaRegla = itFechaRegla;
    }

    public UIInput getItFechaRegla() {
        return itFechaRegla;
    }

    public void setItPenFechaRegla(UIInput itPenFechaRegla) {
        this.itPenFechaRegla = itPenFechaRegla;
    }

    public UIInput getItPenFechaRegla() {
        return itPenFechaRegla;
    }

    public void setItAntFechaRegla(UIInput itAntFechaRegla) {
        this.itAntFechaRegla = itAntFechaRegla;
    }

    public UIInput getItAntFechaRegla() {
        return itAntFechaRegla;
    }

    public void setCamposRequeridos(boolean camposRequeridos) {
        this.camposRequeridos = camposRequeridos;
    }

    public boolean isCamposRequeridos() {
        return camposRequeridos;
    }

    public void setEsCeroPartos(boolean esCeroPartos) {
        this.esCeroPartos = esCeroPartos;
    }

    public boolean isEsCeroPartos() {
        return esCeroPartos;
    }

    public void setEsCeroAbortos(boolean esCeroAbortos) {
        this.esCeroAbortos = esCeroAbortos;
    }

    public boolean isEsCeroAbortos() {
        return esCeroAbortos;
    }

    public void setRenderOtroResultado(boolean renderOtroResultado) {
        this.renderOtroResultado = renderOtroResultado;
    }

    public boolean isRenderOtroResultado() {
        return renderOtroResultado;
    }

    public void setMnuResultado(UIInput mnuResultado) {
        this.mnuResultado = mnuResultado;
    }

    public UIInput getMnuResultado() {
        return mnuResultado;
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroGestaciones(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacnnumgesta((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    

        /**
         * @param valueChangeEvent
         */
        public void setNumeroAbortos(ValueChangeEvent valueChangeEvent) {
            antecedente.setHacnnumaborto((Integer)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        /**
         * @param valueChangeEvent
         */
        public void setNumeroCesarias(ValueChangeEvent valueChangeEvent) {
            antecedente.setHacnnumcesare((Integer)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        /**
         * @param valueChangeEvent
         */
        public void setNumeroMortinatos(ValueChangeEvent valueChangeEvent) {
            antecedente.setHacnmortina((Integer)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        /**
         * @param valueChangeEvent
         */
        public void setNumeroMolas(ValueChangeEvent valueChangeEvent) {
            antecedente.setHacnmolas((Integer)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        /**
         * @param valueChangeEvent
         */
        public void setNumeroEctopicos(ValueChangeEvent valueChangeEvent) {
            antecedente.setHacnectopico((Integer)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        
    /**
     * @param valueChangeEvent
     */
    public void setTipoCiclo(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacetipciclo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param lstTipoCiclo
     */
    public void setLstTipoCiclo(List<SelectItem> lstTipoCiclo) {
        this.lstTipoCiclo = lstTipoCiclo;
    }

    public List<SelectItem> getLstTipoCiclo() {
        if (lstTipoCiclo == null || lstTipoCiclo.isEmpty()) {
            lstTipoCiclo = new ArrayList<SelectItem>();
            lstTipoCiclo.add(new SelectItem("", "Seleccione una opci�n "));
            lstTipoCiclo.add(new SelectItem("I", "Irregular"));
            lstTipoCiclo.add(new SelectItem("R", "Regular"));
            lstTipoCiclo.add(new SelectItem("N", "No ha Tenido Menarquia"));
            lstTipoCiclo.add(new SelectItem("A", "Amenorrea"));
        }
        return lstTipoCiclo;
    }



        public void changeTipo() {
            if (antecedente != null && antecedente.getHacetipciclo() != null) {
                if (antecedente.getHacetipciclo().equals("N")) {
                    tieneCiclo = false;
                    renderMenarquia = false; 
                }
                if (antecedente.getHacetipciclo().equals("A")) {
                    tieneCiclo = false;
                    renderMenarquia = true; 
                }

                if (antecedente.getHacetipciclo().equals("R")) {
                    tieneCiclo = true;
                    renderMenarquia = true; 
                }

                if (antecedente.getHacetipciclo().equals("I")) {
                    cicloiregular = true;
                    renderMenarquia = true;
                    tieneCiclo = true;

                } else {
                    Integer num = null;
                    antecedente.setHacnfrefincicl(num);
                    antecedente.setHacndurfincicl(num);
                    cicloiregular = false;
                }
            }
        }


    public void setTieneCiclo(boolean tieneCiclo) {
        this.tieneCiclo = tieneCiclo;
    }

    public boolean isTieneCiclo() {
        return tieneCiclo;
    }

    public void setRenderMenarquia(boolean renderMenarquia) {
        this.renderMenarquia = renderMenarquia;
    }

    public boolean isRenderMenarquia() {
        return renderMenarquia;
    }

    public void setCicloiregular(boolean cicloiregular) {
        this.cicloiregular = cicloiregular;
    }

    public boolean isCicloiregular() {
        return cicloiregular;
    }


    public void setMostrarFechaFUP(boolean mostrarFechaFUP) {
        this.mostrarFechaFUP = mostrarFechaFUP;
    }

    public boolean isMostrarFechaFUP() {
        return mostrarFechaFUP;
    }

    public void setHaccnoaplica(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaccnoaplica((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    public void changeFecha(){
        if(antecedente.getHaccnoaplica()!= null){
            if(antecedente.getHaccnoaplica().equals("S")){
                mostrarFechaFUP = true;
            }else{
                mostrarFechaFUP= false;
            }
        }
    }

    public void setMnuUltima(UIInput mnuUltima) {
        this.mnuUltima = mnuUltima;
    }

    public UIInput getMnuUltima() {
        return mnuUltima;
    }

    public void setHaccultcitolo(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaccultcitolo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        
    /**
     * @param lstUltimaCitologia
     */
    public void setLstUltimaCitologia(List<SelectItem> lstUltimaCitologia) {
        this.lstUltimaCitologia = lstUltimaCitologia;
    }

    public List<SelectItem> getLstUltimaCitologia() {
        if (lstUltimaCitologia == null || lstUltimaCitologia.isEmpty()) {
            lstUltimaCitologia = new ArrayList<SelectItem>();
            lstUltimaCitologia.add(new SelectItem("", "Seleccione una opci�n "));
            lstUltimaCitologia.add(new SelectItem("NO", "Nunca"));
            lstUltimaCitologia.add(new SelectItem("-1", "Hace menos de un ano"));
            lstUltimaCitologia.add(new SelectItem("+1", "Hace mas de un ano"));
            lstUltimaCitologia.add(new SelectItem("NR", "No recuerda"));
        }
        return lstUltimaCitologia;
    }

    public void setHaccresulcitol(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaccresulcitol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
         public void changeResultado() {
             if (antecedente.getHaccresulcitol() != null && 
                 antecedente.getHaccresulcitol().equals("2.2")) {
                 renderOtroResultado = true;
             } else {
                 renderOtroResultado = false;
                 antecedente.setHaccotroresul(null);
             }
         }

    public void setMostrarMetodo(boolean mostrarMetodo) {
        this.mostrarMetodo = mostrarMetodo;
    }

    public boolean isMostrarMetodo() {
        return mostrarMetodo;
    }
    
    /**
     * @param lstMetodo
     */
    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    /**
     * @return
     */
    public List getLstMetodo() {

        if (lstMetodo == null || lstMetodo.isEmpty()) {
            lstMetodo = new ArrayList();
            ArrayList<Chmetodoplan> lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodoAux.isEmpty()) {

                Iterator it = lstMetodoAux.iterator();
                int i = 0;
                lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMetodo.add(new SelectItem(lstMetodoAux.get(i).getHmpccodigo(), 
                                                 lstMetodoAux.get(i).getHmpcdescripcio()));
                    i++;
                }
            }
        }

        return lstMetodo;
    }

    public void setHaccmetodoplan(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaccmetodoplan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHaccpildouso(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaccpildouso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setMostrarInyectable(boolean mostrarInyectable) {
        this.mostrarInyectable = mostrarInyectable;
    }

    public boolean isMostrarInyectable() {
        return mostrarInyectable;
    }

    public void setMostrarPildoras(boolean mostrarPildoras) {
        this.mostrarPildoras = mostrarPildoras;
    }

    public boolean isMostrarPildoras() {
        return mostrarPildoras;
    }

    public void setMostrarPildorasSi(boolean mostrarPildorasSi) {
        this.mostrarPildorasSi = mostrarPildorasSi;
    }

    public boolean isMostrarPildorasSi() {
        return mostrarPildorasSi;
    }
    
    /**
     * @param lstResultado
     */
    public void setLstResultado(List lstResultado) {
        this.lstResultado = lstResultado;
    }

    /**
     * @return
     */
    public List getLstResultado() {
        if (lstResultado == null || lstResultado.isEmpty()) {
            lstResultado = new ArrayList();
            ArrayList<Cndesccito> lstMetodosAux = null;
            try {
                lstMetodosAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("cncitotoma", 
                                                                                                                           "ctmcultres");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodosAux.isEmpty()) {

                lstResultado.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                Iterator it = lstMetodosAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstResultado.add(new SelectItem((lstMetodosAux.get(i).getCdicvalor()), 
    //                                                    lstMetodosAux.get(i).getCdicvalor() +
    //                                                    "  " +
                                                    lstMetodosAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstResultado;
    }

    public void setHacnedadrelac(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacnedadrelac((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
    
         public void changeEdadPrimeraRelacion() {
             if (antecedente != null && antecedente.getHacnedadrelac() != null) {
                 int resultado = antecedente.getHacnedadrelac().compareTo(14);
                 if(resultado < 0 || resultado==0 ){
                     FacesUtils.addErrorMessage("Esto corresponde a un acto delictivo por favor verificar informaci�n.");
                 }
             }
         }

    public void setRenderGenotipificacion(boolean renderGenotipificacion) {
        this.renderGenotipificacion = renderGenotipificacion;
    }

    public boolean isRenderGenotipificacion() {
        return renderGenotipificacion;
    }

    public void setHacetipifvph(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacetipifvph((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
    public void changeTipificacion(){
        renderGenotipificacion = false; 
        if(antecedente != null && antecedente.getHacetipifvph()!= null && antecedente.getHacetipifvph().equals("SI") ){{
            renderGenotipificacion = true; 
        }
            
        }
    }

    public void setRenderResultadoCitologia(boolean renderResultadoCitologia) {
        this.renderResultadoCitologia = renderResultadoCitologia;
    }

    public boolean isRenderResultadoCitologia() {
        return renderResultadoCitologia;
    }

    public void setRenderVIH(boolean renderVIH) {
        this.renderVIH = renderVIH;
    }

    public boolean isRenderVIH() {
        return renderVIH;
    }

    public void setRenderETS(boolean renderETS) {
        this.renderETS = renderETS;
    }

    public boolean isRenderETS() {
        return renderETS;
    }

    public void setRenderDiabetes(boolean renderDiabetes) {
        this.renderDiabetes = renderDiabetes;
    }

    public boolean isRenderDiabetes() {
        return renderDiabetes;
    }

    public void setRenderFuma(boolean renderFuma) {
        this.renderFuma = renderFuma;
    }

    public boolean isRenderFuma() {
        return renderFuma;
    }

    public void setHaceets(ValueChangeEvent valueChangeEvent) {
        antecedente.setHaceets((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHacevih(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacevih((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHacediabetes(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacediabetes((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHacefuma(ValueChangeEvent valueChangeEvent) {
        antecedente.setHacefuma((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        

        
        public void changeDiabetes(){

            renderDiabetes = false; 
            if(antecedente != null && antecedente.getHacediabetes() != null &&
            antecedente.getHacediabetes().equals("S")){
                renderDiabetes = true; 
            }
        }
        
        
        public void changeVih(){
            renderVIH = false; 
            if(antecedente != null && antecedente.getHacevih() != null &&
            antecedente.getHacevih().equals("S")){
                renderVIH = true; 
            }
        }
        
        
        public void changeETS(){
             renderETS = false; 
            if(antecedente != null && antecedente.getHaceets() != null &&
            antecedente.getHaceets().equals("S")){
                renderETS = true; 
            }
        }
        
        public void changeFuma(){
            renderFuma = false; 
       
            if(antecedente != null && antecedente.getHacefuma() != null &&
            antecedente.getHacefuma().equals("S")){
                renderFuma = true; 
            }
        }
        
}
