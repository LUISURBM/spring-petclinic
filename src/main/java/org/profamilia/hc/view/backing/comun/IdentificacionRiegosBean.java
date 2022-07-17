//=======================================================================
// ARCHIVO IdentificacionRiegosBean.java
// FECHA CREACI�N: 28/03/2018
// AUTOR: Carlos Andr�s Vargas Roa
// Descripci�n: Datos correspondientes a la identificacion de Riegos
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.ChanteginecoPK;
import org.profamilia.hc.model.dto.Chidentiriesgo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ExamenFisicoUsuarioBean
//=======================================================================


public class IdentificacionRiegosBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List lstOpciones;

    private boolean renderRieHemorragia;
    
    private boolean renderInfActual;
    
    private boolean renderMalMulleriana;
    
    private boolean renderSerVih;

    private boolean renderSosAnemia;

    private Chidentiriesgo identifi;
    
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    private String nextAction;
    
    private String menuBean;
    
    private String navigationRule;
    
    private UIInput mnuRieHemorragia; 

    private UIInput mnuPatCronica; 

    private UIInput mnuInfActual; 
    
    private UIInput mnuMalMulleriana; 

    private UIInput mnuSerVih; 

    private UIInput mnuSosAnemia; 

    private List lstRiesgoHemorragia;
    
    private List lstInfeccionActual;

    private List<String> lstRiesgoHemorragiaSelect;

    private List<String> lstInfeccionActualSelect;
    
    //Render Preguntas IVE
    
    private boolean renderPreguntasIVE;
    
    private boolean renderManejoAnticoa;
    
    private boolean renderAntecedentePato;
    
    private boolean renderAcretismoPlacen;
    
    private boolean renderSospechaCorioa;
    
    private boolean renderCesareaAnte;
    
    private boolean renderDosCesareas;
    
    private boolean renderAlteracionesAnato;
    
    private boolean renderGestacionMalfor;
    
    private boolean renderPlacentaPrevia;
    
    private boolean renderAnemiaGrave;
    
    private boolean renderVih;
     
    private UIInput mnuVih; 
    
    

    public void init() {
        renderRieHemorragia = false;
        renderInfActual = false;
        renderMalMulleriana = false;
        renderSerVih = false;
        renderSosAnemia = false;
        renderVih=false;
        identifi = new Chidentiriesgo();
        nextAction = "";
        lstRiesgoHemorragiaSelect = new ArrayList<String>();
        lstInfeccionActualSelect = new ArrayList<String>();
        iniciarIdentificacionBean();
        
    }
    
    public IdentificacionRiegosBean() {
       
    }
    public void iniciarIdentificacionBean() {
        try {
            if (numeroConsulta != null) {
                identifi = 
                        this.getServiceLocator().getClinicoService().getIdentificacionRiesgos(numeroConsulta);
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if (identifi == null){
            identifi = new Chidentiriesgo();
        } else {
            if (identifi.getHidecriehemo() != null && identifi.getHidecriehemo().equals("S")) {
                renderRieHemorragia = true;
            }
            
            if (identifi.getHidecinfactu() != null && identifi.getHidecinfactu().equals("S")) {
                renderInfActual = true;
            }
            
            if (identifi.getHidecantmull() != null && identifi.getHidecantmull().equals("S")) {
                renderMalMulleriana = true;
            }
            
            if (identifi.getHidecserovih() != null && identifi.getHidecserovih().equals("S")) {
                renderSerVih = true;
            }
            if (identifi.getHidecvih() != null && identifi.getHidecvih().equals("S")) {
                renderVih = true;
            }
            if (identifi.getHidecsosanem() != null && identifi.getHidecsosanem().equals("S")) {
                renderSosAnemia = true;
            }
        
            if(identifi.getHidecriheval() != null && !identifi.getHidecriheval().equals("")) {
                StringTokenizer stk = new StringTokenizer(identifi.getHidecriheval(), ",");
                String rieHemorragiaAux = null;
                while(stk.hasMoreTokens()) {
                    rieHemorragiaAux = "";
                    rieHemorragiaAux = stk.nextToken();
                    if (rieHemorragiaAux != null) {
                        lstRiesgoHemorragiaSelect.add(rieHemorragiaAux);
                    }
                }
             }

            if(identifi.getHidecinacval() != null && !identifi.getHidecinacval().equals("")) {
                StringTokenizer stk = new StringTokenizer(identifi.getHidecinacval(), ",");
                String infActualAux = null;
                while(stk.hasMoreTokens()) {
                    infActualAux = "";
                    infActualAux = stk.nextToken();
                    if (infActualAux != null) {
                        lstInfeccionActualSelect.add(infActualAux);
                    }
                }
             }
            changePreguntasIVE();  
            
        }
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }
        return lstOpciones;
    }

    public void setRenderRieHemorragia(boolean renderRieHemorragia) {
        this.renderRieHemorragia = renderRieHemorragia;
    }

    public boolean isRenderRieHemorragia() {
        return renderRieHemorragia;
    }
    
    public void changeRieHemorragia(){
        renderRieHemorragia = false; 
        if (identifi!= null) {
           if (identifi.getHidecriehemo()!= null && identifi.getHidecriehemo().equals("S")){
              renderRieHemorragia = true;
           } else {
              identifi.setHidecriheval(null);
              identifi.setHidecriheobs(null);
              lstRiesgoHemorragiaSelect =  new ArrayList<String>();
           }
        }
    }
    
    public void changeVih(){
          renderVih = false; 
            if (identifi!= null) {
               if (identifi.getHidecvih() != null && identifi.getHidecvih().equals("S")){
                   renderVih = true; 
               } else {
                   identifi.setHidecvihobs(null);
               }
        
        }
    }


    public void setRenderInfActual(boolean renderInfActual) {
        this.renderInfActual = renderInfActual;
    }

    public boolean isRenderInfActual() {
        return renderInfActual;
    }
    
    public void changeInfActual(){
        renderInfActual = false; 
        if (identifi != null) {
           if (identifi.getHidecinfactu() != null && identifi.getHidecinfactu().equals("S")){
              renderInfActual = true; 
           } else {
              identifi.setHidecinacval(null);
              identifi.setHidecinacobs(null);
              lstInfeccionActualSelect =  new ArrayList<String>();
           }
        }
    }

    public void setRenderMalMulleriana(boolean renderMalMulleriana) {
        this.renderMalMulleriana = renderMalMulleriana;
    }

    public boolean isRenderMalMulleriana() {
        return renderMalMulleriana;
    }
    
    public void changeMalMulleriana(){
        renderMalMulleriana = false; 
        if (identifi!= null) {
            if (identifi.getHidecantmull()!= null && identifi.getHidecantmull().equals("S")) {
                renderMalMulleriana = true;
            } else {
                identifi.setHidecanmuobs(null);
            }
        }
    }
    
    public void setRenderSerVih(boolean renderSerVih) {
        this.renderSerVih = renderSerVih;
    }

    public boolean isRenderSerVih() {
        return renderSerVih;
    }
    
    public void changeSerVih(){
        renderSerVih = false; 
        if (identifi!= null) {
           if (identifi.getHidecserovih() != null && identifi.getHidecserovih().equals("S")){
               renderSerVih = true; 
           } else {
               identifi.setHidecseviobs(null);
           }
        }
    }

    public void setRenderSosAnemia(boolean renderSosAnemia) {
        this.renderSosAnemia = renderSosAnemia;
    }

    public boolean isRenderSosAnemia() {
        return renderSosAnemia;
    }
    
    public void changeSosAnemia(){
        renderSosAnemia = false; 
        if (identifi!= null && identifi.getHidecsosanem()!= null &&
           identifi.getHidecsosanem().equals("S")){
            renderSosAnemia = true; 
        }
    }

    public boolean esValido() {
        Chidentiriesgo identiAux = null;
        boolean esValido = false;
        if (numeroConsulta != null) {
            try {
                identiAux = 
                        this.getServiceLocator().getClinicoService().getIdentificacionRiesgos(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (identiAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
       
        return esValido;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidecriehemo(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecriehemo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidecpatcron(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecpatcron((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidecinfactu(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecinfactu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidecantmull(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecantmull((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidecserovih(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecserovih((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidecsosanem(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecsosanem((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
        
    public void setIdentifi(Chidentiriesgo identifi) {
        this.identifi = identifi;
    }

    public Chidentiriesgo getIdentifi() {
        return identifi;
    }

    public void setMnuRieHemorragia(UIInput mnuRieHemorragia) {
        this.mnuRieHemorragia = mnuRieHemorragia;
    }

    public UIInput getMnuRieHemorragia() {
        return mnuRieHemorragia;
    }

    public void setMnuPatCronica(UIInput mnuPatCronica) {
        this.mnuPatCronica = mnuPatCronica;
    }

    public UIInput getMnuPatCronica() {
        return mnuPatCronica;
    }


    public void setMnuInfActual(UIInput mnuInfActual) {
        this.mnuInfActual = mnuInfActual;
    }

    public UIInput getMnuInfActual() {
        return mnuInfActual;
    }

    public void setMnuMalMulleriana(UIInput mnuMalMulleriana) {
        this.mnuMalMulleriana = mnuMalMulleriana;
    }

    public UIInput getMnuMalMulleriana() {
        return mnuMalMulleriana;
    }
    
    public void setMnuSerVih(UIInput mnuSerVih) {
        this.mnuSerVih = mnuSerVih;
    }

    public UIInput getMnuSerVih() {
        return mnuSerVih;
    }

    public void setMnuSosAnemia(UIInput mnuSosAnemia) {
        this.mnuSosAnemia = mnuSosAnemia;
    }

    public UIInput getMnuSosAnemia() {
        return mnuSosAnemia;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }
    
    public String guardarIdentificacion(){
        
        return null;
    }

    public String aceptar() {

        navigationRule = "";
        boolean wexito = true;
        String urlAux = "body:formIdentificacionRiesgo:panelGridIdentificacionRiesgosTab:"; 
        String riesgoHemorragia = "";
        String infeccionActual = "";

        if(lstRiesgoHemorragiaSelect != null && !lstRiesgoHemorragiaSelect.isEmpty()) {
            for(Iterator iterator1 = lstRiesgoHemorragiaSelect.iterator(); iterator1.hasNext();) {
                String hemorragia = (String)iterator1.next();
                riesgoHemorragia = (new StringBuilder()).append(riesgoHemorragia).append(hemorragia).append(",").toString();
            }

            if(riesgoHemorragia != null && riesgoHemorragia.length() > 2) {
                riesgoHemorragia = riesgoHemorragia.substring(0, riesgoHemorragia.length() - 1);
                identifi.setHidecriheval(riesgoHemorragia);
            }
        }

        if(lstInfeccionActualSelect != null && !lstInfeccionActualSelect.isEmpty()) {
            for(Iterator iterator2 = lstInfeccionActualSelect.iterator(); iterator2.hasNext();) {
                String infeccion = (String)iterator2.next();
                infeccionActual = (new StringBuilder()).append(infeccionActual).append(infeccion).append(",").toString();
            }

            if(infeccionActual != null && infeccionActual.length() > 2) {
                infeccionActual = infeccionActual.substring(0, infeccionActual.length() - 1);
                identifi.setHidecinacval(infeccionActual);
            }
        }


        if (wexito) {

            try {
                
                identifi.setHidelconsulta(numeroConsulta);

                this.getServiceLocator().getClinicoService().saveIdentificaRiesgo(identifi);
                FacesUtils.addInfoMessage(MSG_ADICION);

                // Se recarga el menu 
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;


            } catch (ModelException e) {
                e.printStackTrace();
                navigationRule = "";
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
            }

        }

        return navigationRule;

    }
    
    /**
     * @param valueChangeEvent
     */
    public void setLstRiesgoHemorragiaSelect(ValueChangeEvent valueChangeEvent) {
        setLstRiesgoHemorragiaSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param lstRiegoHemorragia
     */
    public void setLstRiesgoHemorragia(List lstRiesgoHemorragia) {
        this.lstRiesgoHemorragia = lstRiesgoHemorragia;
    }

    /**
     * @param valueChangeEvent
     */
    public void setLstInfeccionActualSelect(ValueChangeEvent valueChangeEvent) {
        setLstInfeccionActualSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param lstInfeccionActual
     */
    public void setLstInfeccionActual(List lstInfeccionActual) {
        this.lstInfeccionActual = lstInfeccionActual;
    }

    /**
     * @return
     */
    public List getLstRiesgoHemorragia() {
        if(lstRiesgoHemorragia == null || lstRiesgoHemorragia.isEmpty()) {
            lstRiesgoHemorragia = new ArrayList();
            lstRiesgoHemorragia.add(new SelectItem("DS", "Discrasia sangu�nea"));
            lstRiesgoHemorragia.add(new SelectItem("AC", "Anticoagulaci�n"));
            lstRiesgoHemorragia.add(new SelectItem("PA", "Placentaci�n anormal"));
            lstRiesgoHemorragia.add(new SelectItem("CA", "Ces�reas anteriores"));
            lstRiesgoHemorragia.add(new SelectItem("CR", "Antecedente de c�digo rojo"));
        }
        return lstRiesgoHemorragia;
    }

    /**
     * @param lstRiesgoHemorragiaSelect
     */
    public void setLstRiesgoHemorragiaSelect(List<String>  lstRiesgoHemorragiaSelect) {
        this.lstRiesgoHemorragiaSelect = lstRiesgoHemorragiaSelect;
    }

    /**
     * @return
     */
    public List getLstInfeccionActual() {
        if(lstInfeccionActual == null || lstInfeccionActual.isEmpty()) {
            lstInfeccionActual = new ArrayList();
            lstInfeccionActual.add(new SelectItem("CA", "Corioamnionitis"));
            lstInfeccionActual.add(new SelectItem("VG", "Vaginosis / Vaginitis"));
            lstInfeccionActual.add(new SelectItem("CV", "Cervicitis"));
            lstInfeccionActual.add(new SelectItem("OT", "Otro"));
        }
        return lstInfeccionActual;
    }

    /**
     * @param lstInfeccionActualSelect
     */
    public void setLstInfeccionActualSelect(List<String>  lstInfeccionActualSelect) {
        this.lstInfeccionActualSelect = lstInfeccionActualSelect;
    }


    /**
     * @return
     */
    public List<String> getLstRiesgoHemorragiaSelect() {
        return lstRiesgoHemorragiaSelect;
    }

    /**
     * @return
     */
    public List<String> getLstInfeccionActualSelect() {
        return lstInfeccionActualSelect;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecmaansure(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecmaansure((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecantpatdes(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecantpatdes((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecacrplacon(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecacrplacon((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecsospcori(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecsospcori((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecunceananin(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecunceananin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecdosmasces(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecdosmasces((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecalancoec(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecalancoec((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setHidecgemamucoec(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecgemamucoec((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecplapremay(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecplapremay((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecanemiagrave(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecanemiagrave((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHidecvih(ValueChangeEvent valueChangeEvent) {
        identifi.setHidecvih((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changePreguntasIVE(){
        renderManejoAnticoa = false;
        renderAntecedentePato = false;
        renderAcretismoPlacen  = false;
        renderSospechaCorioa = false;
        renderCesareaAnte = false;
        renderDosCesareas = false;
        renderAlteracionesAnato = false;
        renderGestacionMalfor = false;
        renderPlacentaPrevia = false;
        renderAnemiaGrave = false;
        
        if (identifi!= null && identifi.getHidecmaansure()!= null &&
            identifi.getHidecmaansure().equals("S")){
            renderManejoAnticoa = true;
        }
        
        if (identifi!= null && identifi.getHidecantpatdes()!= null &&
            identifi.getHidecantpatdes().equals("S")){
            renderAntecedentePato = true;
        }
        
        if (identifi!= null && identifi.getHidecacrplacon()!= null &&
            identifi.getHidecacrplacon().equals("S")){
            renderAcretismoPlacen = true;
        }
        
        if (identifi!= null && identifi.getHidecsospcori()!= null &&
            identifi.getHidecsospcori().equals("S")){
            renderSospechaCorioa = true;
        }
        
        if (identifi!= null && identifi.getHidecunceananin()!= null &&
            identifi.getHidecunceananin().equals("S")){
            renderCesareaAnte = true;
        }
        
        if (identifi!= null && identifi.getHidecdosmasces()!= null &&
            identifi.getHidecdosmasces().equals("S")){
            renderDosCesareas = true;
        }
        
        if (identifi!= null && identifi.getHidecalancoec()!= null &&
            identifi.getHidecalancoec().equals("S")){
            renderAlteracionesAnato = true;
        }
        
        if (identifi!= null && identifi.getHidecgemamucoec()!= null &&
            identifi.getHidecgemamucoec().equals("S")){
            renderGestacionMalfor = true;
        }
        
        if (identifi!= null && identifi.getHidecplapremay()!= null &&
            identifi.getHidecplapremay().equals("S")){
            renderPlacentaPrevia = true;
        }
        
        if (identifi!= null && identifi.getHidecanemiagrave()!= null &&
            identifi.getHidecanemiagrave().equals("S")){
            renderAnemiaGrave = true;
        }
        
        
    }
    public void changeTodosSi(){
        renderManejoAnticoa = true;
        renderAntecedentePato = true;
        renderAcretismoPlacen  = true;
        renderSospechaCorioa = true;
        renderCesareaAnte = true;
        renderDosCesareas = true;
        renderAlteracionesAnato = true;
        renderGestacionMalfor = true;
        renderPlacentaPrevia = true;
        renderAnemiaGrave = true;
        
        inicializarPreguntas("S");
        
    }
    
    public void changeTodosSiRiesgo(){
        renderRieHemorragia=true;
        renderInfActual=true;
        renderMalMulleriana=true;
        renderSerVih=true;
        renderSosAnemia=true;
        renderVih=true;
        inicializarPreguntasRiesgo("S");
        
    }
    public void changeTodosNoRiesgo(){
        renderRieHemorragia=false;
        renderInfActual=false;
        renderMalMulleriana=false;
        renderSerVih=false;
        renderSosAnemia=false;
        inicializarPreguntasRiesgo("N");
        
    }
    
    public void changeTodosNo(){
        renderManejoAnticoa = false;
        renderAntecedentePato = false;
        renderAcretismoPlacen  = false;
        renderSospechaCorioa = false;
        renderCesareaAnte = false;
        renderDosCesareas = false;
        renderAlteracionesAnato = false;
        renderGestacionMalfor = false;
        renderPlacentaPrevia = false;
        renderAnemiaGrave = false;
        renderVih=false;
        
        inicializarPreguntas("N");
        
    }
    
    public void changeNinguno(){
        renderManejoAnticoa = false;
        renderAntecedentePato = false;
        renderAcretismoPlacen  = false;
        renderSospechaCorioa = false;
        renderCesareaAnte = false;
        renderDosCesareas = false;
        renderAlteracionesAnato = false;
        renderGestacionMalfor = false;
        renderPlacentaPrevia = false;
        renderAnemiaGrave = false;
        
        inicializarPreguntas(null);
        
    }
    public void changeTodosNingunoRiesgo(){
        renderRieHemorragia=false;
        renderInfActual=false;
        renderMalMulleriana=false;
        renderSerVih=false;
        renderSosAnemia=false;
        renderVih=false;
        inicializarPreguntasRiesgo(null);
    }
    
    public void inicializarPreguntas(String opcion) {
        if (identifi!= null ){
            identifi.setHidecantpatdes(opcion);
            identifi.setHidecunceananin(opcion);
            identifi.setHidecdosmasces(opcion);
            identifi.setHidecalancoec(opcion);
        }
    }
    public void inicializarPreguntasRiesgo(String opcion) {
        if (identifi!= null ){
            
            identifi.setHidecriehemo(opcion);
            identifi.setHidecpatcron(opcion);
            identifi.setHidecinfactu(opcion);
            identifi.setHidecantmull(opcion);
            identifi.setHidecserovih(opcion);
            identifi.setHidecvih(opcion);
            identifi.setHidecsosanem(opcion);
        }
    }


    public void setRenderPreguntasIVE(boolean renderPreguntasIVE) {
        this.renderPreguntasIVE = renderPreguntasIVE;
    }

    public boolean isRenderPreguntasIVE() {
        return renderPreguntasIVE;
    }

    public void setRenderManejoAnticoa(boolean renderManejoAnticoa) {
        this.renderManejoAnticoa = renderManejoAnticoa;
    }

    public boolean isRenderManejoAnticoa() {
        return renderManejoAnticoa;
    }

    public void setRenderAntecedentePato(boolean renderAntecedentePato) {
        this.renderAntecedentePato = renderAntecedentePato;
    }

    public boolean isRenderAntecedentePato() {
        return renderAntecedentePato;
    }

    public void setRenderAcretismoPlacen(boolean renderAcretismoPlacen) {
        this.renderAcretismoPlacen = renderAcretismoPlacen;
    }

    public boolean isRenderAcretismoPlacen() {
        return renderAcretismoPlacen;
    }

    public void setRenderSospechaCorioa(boolean renderSospechaCorioa) {
        this.renderSospechaCorioa = renderSospechaCorioa;
    }

    public boolean isRenderSospechaCorioa() {
        return renderSospechaCorioa;
    }

    public void setRenderCesareaAnte(boolean renderCesareaAnte) {
        this.renderCesareaAnte = renderCesareaAnte;
    }

    public boolean isRenderCesareaAnte() {
        return renderCesareaAnte;
    }

    public void setRenderDosCesareas(boolean renderDosCesareas) {
        this.renderDosCesareas = renderDosCesareas;
    }

    public boolean isRenderDosCesareas() {
        return renderDosCesareas;
    }

    public void setRenderAlteracionesAnato(boolean renderAlteracionesAnato) {
        this.renderAlteracionesAnato = renderAlteracionesAnato;
    }

    public boolean isRenderAlteracionesAnato() {
        return renderAlteracionesAnato;
    }

    public void setRenderGestacionMalfor(boolean renderGestacionMalfor) {
        this.renderGestacionMalfor = renderGestacionMalfor;
    }

    public boolean isRenderGestacionMalfor() {
        return renderGestacionMalfor;
    }

    public void setRenderPlacentaPrevia(boolean renderPlacentaPrevia) {
        this.renderPlacentaPrevia = renderPlacentaPrevia;
    }

    public boolean isRenderPlacentaPrevia() {
        return renderPlacentaPrevia;
    }

    public void setRenderAnemiaGrave(boolean renderAnemiaGrave) {
        this.renderAnemiaGrave = renderAnemiaGrave;
    }

    public boolean isRenderAnemiaGrave() {
        return renderAnemiaGrave;
    }

    public void setRenderVih(boolean renderVih) {
        this.renderVih = renderVih;
    }

    public boolean isRenderVih() {
        return renderVih;
    }

    public void setMnuVih(UIInput mnuVih) {
        this.mnuVih = mnuVih;
    }

    public UIInput getMnuVih() {
        return mnuVih;
    }
}
