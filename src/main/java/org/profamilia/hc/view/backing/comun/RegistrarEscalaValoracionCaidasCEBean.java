package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chaldrete;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chescvalcai;
import org.profamilia.hc.model.dto.ChescvalcaiPK;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarEscalaValoracionCaidasCEBean extends BaseBean {

    private Long numeroConsulta;

    private String menuBean;

    private HtmlDataTable dtConsulta;

    private List lstConsultas;

    private List<Cnconsclin> lstConsclin;

    private List lstOpciones;

    private String navegationRule;

    private String nextAction;

    private List lstCaidasPrevias;
    
    private List<String> lstCaidasPreviasSelect;

    private List lstDeficitSensorial;
    
    private List<String> lstDeficitSensorialSelect;

    private List lstMedicamentos;
    
    private List<String> lstMedicamentosSelect;

    private List lstEstadoMental;
    
    private List<String> lstEstadoMentalSelect;

    private List lstDeambulacion;
    
    private List<String> lstDeambulacionSelect;

    private String numeroEscala;
    
    private Chescvalcai chescvalcai;
    
    private String msgPuntos;
    
    private int puntosSeguimientos;
    
    private HtmlDataTable dtSeguimiento;
    
    private List<Chescvalcai> listaEscalaValoracionCaida;
    
    private String caidasPreviasSeleccionados;
    
    private String medicamentosSeleccionados;
    
    private String deficitSensorialSeleccionados;
    
    private String estadoMentalSeleccionados;
    
    private String deambulacionSeleccionados;
    
    private Long numeroUsuario;
    
    private String msgRiesgo;
    
    private String msgRiesgo1;
    
    private String msgRiesgo2;
    
    private String msgRiesgo3;
    
    private String msgRiesgo4;
    
    private String msgRiesgo5;
    
    private String msgRiesgo6;
    
    private String msgRiesgo7;
    
    

    public RegistrarEscalaValoracionCaidasCEBean() {
    }

    public void init() {

        lstConsultas = new ArrayList();
        dtConsulta = new HtmlDataTable();
        dtSeguimiento = new HtmlDataTable();
        listaEscalaValoracionCaida = new ArrayList(); 
        msgPuntos="";
        msgRiesgo= "";
        msgRiesgo1="";
        msgRiesgo2="";
        msgRiesgo3="";
        msgRiesgo4="";
        msgRiesgo5="";
        msgRiesgo6="";
        msgRiesgo7="";
        
        chescvalcai = new Chescvalcai();
        
        cargarHistorial();

    }


    public void cargarHistorial() {
        if (numeroConsulta != null ) {
            try {
                    
                listaEscalaValoracionCaida = 
                        serviceLocator.getClinicoService().getEscalaValoracionCaidasXdia(numeroUsuario);
                        
                
                if(listaEscalaValoracionCaida != null){
                for(Chescvalcai escala:listaEscalaValoracionCaida){
                    caidasPreviasSeleccionados = "";
                    
                    medicamentosSeleccionados = "";
                    
                    deficitSensorialSeleccionados = "";
                    
                    estadoMentalSeleccionados = "";
                    
                    deambulacionSeleccionados = "";
                    
                    escala.setEditable(false);
                    
                    if(escala.getHevccaidprev() != null){
                        if ("S".equals(escala.getHevccaidprev())) {
                            caidasPreviasSeleccionados ="Si";
                        }else if ("N".equals(escala.getHevccaidprev())) {
                            caidasPreviasSeleccionados ="No";
                        }
                        
                        if(!"".equals(caidasPreviasSeleccionados)){
                            escala.setCaidasPrevias(caidasPreviasSeleccionados);
                        }
                    }
                    
                    
                    if(escala.getHevccmedicamen() != null){
                        
                        StringTokenizer st = 
                            new StringTokenizer(escala.getHevccmedicamen(), ",");
                        while (st.hasMoreTokens()) {
                            String medicamento = st.nextToken();

                            if (medicamento.equals("NI")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Ninguno,";
                            }
                            if (medicamento.equals("DI")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Diur�ticos,";
                            }
                            if (medicamento.equals("AN")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Antiparkinsonianos,";
                            } 
                            if (medicamento.equals("TS")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Tranquilizantes, sedantes,";
                            }   
                            if (medicamento.equals("HND")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Hipotensores no diur�ticos,";
                            }
                            if (medicamento.equals("AD")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Antidepresivos,";
                            }     
                            if (medicamento.equals("AO")) {
                                medicamentosSeleccionados= medicamentosSeleccionados+"Analg�sicos Opioides,";
                            }
                        }
                        if(!"".equals(medicamentosSeleccionados)){
                            escala.setMedicamentos(medicamentosSeleccionados.substring(0, (medicamentosSeleccionados.length()-1)));
                        }
                    }
                    
                    if(escala.getHevccdefisens() != null){
                        
                        StringTokenizer st = 
                            new StringTokenizer(escala.getHevccdefisens(), ",");
                        while (st.hasMoreTokens()) {
                            String medicamento = st.nextToken();

                            if (medicamento.equals("NI")) {
                                deficitSensorialSeleccionados = deficitSensorialSeleccionados+"Ninguno,";
                            }
                            if (medicamento.equals("AV")) {
                                deficitSensorialSeleccionados= deficitSensorialSeleccionados+"Alteraciones visuales,";
                            }
                            if (medicamento.equals("AA")) {
                                deficitSensorialSeleccionados= deficitSensorialSeleccionados+"Alteraciones auditivas,";
                            } 
                            if (medicamento.equals("DM")) {
                                deficitSensorialSeleccionados= deficitSensorialSeleccionados+"D�ficit de miembros,";
                            }   
                        }
                        
                        if(!"".equals(deficitSensorialSeleccionados)){
                            escala.setDeficitSensorial(deficitSensorialSeleccionados.substring(0, (deficitSensorialSeleccionados.length()-1)));
                        }
                    }
                    
                    if(escala.getHevccestament() != null){
                        
                        if ("OR".equals(escala.getHevccestament())) {
                            estadoMentalSeleccionados = "Orientado";
                        } else if ("CO".equals(escala.getHevccestament())) {
                            estadoMentalSeleccionados = "Confuso";
                        }
                        if (!"".equals(estadoMentalSeleccionados)) {
                            escala.setEstadoMental(estadoMentalSeleccionados);
                        }
                    }
                    
                    if(escala.getHevccdeambula() != null){
                        
                        StringTokenizer st = 
                            new StringTokenizer(escala.getHevccdeambula(), ",");
                        while (st.hasMoreTokens()) {
                            String deambulacion = st.nextToken();
                                                             
                            if (deambulacion.equals("NO")) {
                                deambulacionSeleccionados = deambulacionSeleccionados+"Normal,";
                            }
                            if (deambulacion.equals("SSA")) {
                                deambulacionSeleccionados= deambulacionSeleccionados+"Segura sin ayuda,";
                            }         
                            if (deambulacion.equals("AEA")) {
                                deambulacionSeleccionados= deambulacionSeleccionados+"Asistida con elementos de apoyo,";
                            }
                            if (deambulacion.equals("RAI")) {
                                deambulacionSeleccionados= deambulacionSeleccionados+"Reposo absoluto o imposible,";
                            }
                        }
                        
                        if(!"".equals(deambulacionSeleccionados)){
                            escala.setDeambulacion(deambulacionSeleccionados.substring(0, (deambulacionSeleccionados.length()-1)));
                        }
                    }
                }
            }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void agregarEscala() {
        String caidasPreviasCodigos ="";
        
        String medicamentosCodigos ="";
        
        String deficitSensorialCodigos ="";
        
        String estadoMentalCodigos ="";
        
        String deambulacionCodigos ="";
        
        caidasPreviasSeleccionados = "";
        
        medicamentosSeleccionados = "";
        
        deficitSensorialSeleccionados = "";
        
        estadoMentalSeleccionados = "";
        
        deambulacionSeleccionados = "";
        
        Chescvalcai encuestraValoracionCaidas = new Chescvalcai();
        
        
        encuestraValoracionCaidas.setHevccoperador(userName());
        encuestraValoracionCaidas.setHevcdfecregistr(new Date());
        if (numeroConsulta != null) {
            ChescvalcaiPK id = new ChescvalcaiPK();
            id.setHevclconsulta(numeroConsulta);
            encuestraValoracionCaidas.setHevlusuario(numeroUsuario);
            long count = 0; 
            if(listaEscalaValoracionCaida != null && !listaEscalaValoracionCaida.isEmpty()){
                count = listaEscalaValoracionCaida.size()+1;
            }else{
                count = 1;
                listaEscalaValoracionCaida = new ArrayList();
            }
            id.setHevcnconsecuti(count);
            encuestraValoracionCaidas.setComp_id(id);
            encuestraValoracionCaidas.setEditable(true);
            encuestraValoracionCaidas.setHevccpuntos(puntosSeguimientos);
        
            if(chescvalcai != null && chescvalcai.getHevccaidprev() != null){
                encuestraValoracionCaidas.setHevccaidprev(chescvalcai.getHevccaidprev());
            }

            if (chescvalcai != null && chescvalcai.getHevccestament() != null) {
                encuestraValoracionCaidas.setHevccestament(chescvalcai.getHevccestament());
            }
            
        
        if(lstDeficitSensorialSelect != null && !lstDeficitSensorialSelect.isEmpty()){
            for(String deficitSensorial:lstDeficitSensorialSelect){
                deficitSensorialCodigos = deficitSensorialCodigos + deficitSensorial +",";
            }
            
            if(!"".equals(deficitSensorialCodigos)){
                encuestraValoracionCaidas.setHevccdefisens(deficitSensorialCodigos.substring(0, (deficitSensorialCodigos.length()-1)));
            }
        }
        
        if(lstDeambulacionSelect != null && !lstDeambulacionSelect.isEmpty()){
            for(String deambulacion:lstDeambulacionSelect){
                deambulacionCodigos = deambulacionCodigos + deambulacion +",";
            }
            
            if(!"".equals(deambulacionCodigos)){
                encuestraValoracionCaidas.setHevccdeambula(deambulacionCodigos.substring(0, (deambulacionCodigos.length()-1)));
            }
        }
        
        if(lstMedicamentosSelect != null && !lstMedicamentosSelect.isEmpty()){
            for(String medicamentos:lstMedicamentosSelect){
                medicamentosCodigos = medicamentosCodigos + medicamentos +",";
            }
            
            if(!"".equals(medicamentosCodigos)){
                encuestraValoracionCaidas.setHevccmedicamen(medicamentosCodigos.substring(0, (medicamentosCodigos.length()-1)));
            }
        }
        
        
        
        if(encuestraValoracionCaidas.getHevccaidprev() != null){
        
            if ("S".equals(encuestraValoracionCaidas.getHevccaidprev())) {
                caidasPreviasSeleccionados ="Si";
            }else if ("N".equals(encuestraValoracionCaidas.getHevccaidprev())) {
                caidasPreviasSeleccionados ="No";
            }
            
            if(!"".equals(caidasPreviasSeleccionados)){
                encuestraValoracionCaidas.setCaidasPrevias(caidasPreviasSeleccionados);
            }
        }
        
        if(encuestraValoracionCaidas.getHevccmedicamen() != null){
            
            StringTokenizer st = 
                new StringTokenizer(encuestraValoracionCaidas.getHevccmedicamen(), ",");
            while (st.hasMoreTokens()) {
                String medicamento = st.nextToken();

                if (medicamento.equals("NI")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Ninguno,";
                }
                if (medicamento.equals("DI")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Diur�ticos,";
                }
                if (medicamento.equals("AN")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Antiparkinsonianos,";
                } 
                if (medicamento.equals("TS")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Tranquilizantes, sedantes,";
                }   
                if (medicamento.equals("HND")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Hipotensores no diur�ticos,";
                }
                if (medicamento.equals("AD")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Antidepresivos,";
                }     
                if (medicamento.equals("AO")) {
                    medicamentosSeleccionados= medicamentosSeleccionados+"Analg�sicos Opioides,";
                }
            }
            if(!"".equals(medicamentosSeleccionados)){
                encuestraValoracionCaidas.setMedicamentos(medicamentosSeleccionados.substring(0, (medicamentosSeleccionados.length()-1)));
            }
        }
        
        if(encuestraValoracionCaidas.getHevccdefisens() != null){
            
            StringTokenizer st = 
                new StringTokenizer(encuestraValoracionCaidas.getHevccdefisens(), ",");
            while (st.hasMoreTokens()) {
                String medicamento = st.nextToken();

                if (medicamento.equals("NI")) {
                    deficitSensorialSeleccionados = deficitSensorialSeleccionados+"Ninguno,";
                }
                if (medicamento.equals("AV")) {
                    deficitSensorialSeleccionados= deficitSensorialSeleccionados+"Alteraciones visuales,";
                }
                if (medicamento.equals("AA")) {
                    deficitSensorialSeleccionados= deficitSensorialSeleccionados+"Alteraciones auditivas,";
                } 
                if (medicamento.equals("DM")) {
                    deficitSensorialSeleccionados= deficitSensorialSeleccionados+"D�ficit de miembros,";
                }   
            }
            
            if(!"".equals(deficitSensorialSeleccionados)){
                encuestraValoracionCaidas.setDeficitSensorial(deficitSensorialSeleccionados.substring(0, (deficitSensorialSeleccionados.length()-1)));
            }
        }

            if (encuestraValoracionCaidas.getHevccestament() != null) {
                if ("OR".equals(encuestraValoracionCaidas.getHevccestament())) {
                    estadoMentalSeleccionados = "Orientado";
                } else if ("CO".equals(encuestraValoracionCaidas.getHevccestament())) {
                    estadoMentalSeleccionados = "Confuso";
                }
                if (!"".equals(estadoMentalSeleccionados)) {
                    encuestraValoracionCaidas.setEstadoMental(estadoMentalSeleccionados);
                }
            }

        if(encuestraValoracionCaidas.getHevccdeambula() != null){
            
            StringTokenizer st = 
                new StringTokenizer(encuestraValoracionCaidas.getHevccdeambula(), ",");
            while (st.hasMoreTokens()) {
                String deambulacion = st.nextToken();
                                                 
                if (deambulacion.equals("NO")) {
                    deambulacionSeleccionados = deambulacionSeleccionados+"Normal,";
                }
                if (deambulacion.equals("SSA")) {
                    deambulacionSeleccionados= deambulacionSeleccionados+"Segura sin ayuda,";
                }         
                if (deambulacion.equals("AEA")) {
                    deambulacionSeleccionados= deambulacionSeleccionados+"Asistida con elementos de apoyo,";
                }
                if (deambulacion.equals("RAI")) {
                    deambulacionSeleccionados= deambulacionSeleccionados+"Reposo absoluto o imposible,";
                }
            }
            
            if(!"".equals(deambulacionSeleccionados)){
                encuestraValoracionCaidas.setDeambulacion(deambulacionSeleccionados.substring(0, (deambulacionSeleccionados.length()-1)));
            }
        }

        listaEscalaValoracionCaida.add(encuestraValoracionCaidas);
        
        chescvalcai = new Chescvalcai();
        lstDeficitSensorialSelect= new ArrayList();
        lstDeambulacionSelect= new ArrayList();
        lstMedicamentosSelect= new ArrayList();
        puntosSeguimientos = 0;
        msgPuntos="";
        
        }

    }
    
    public void eliminarEscala() {  
        Chescvalcai escalaEliminar  = (Chescvalcai)dtSeguimiento.getRowData();
    
        if(escalaEliminar!= null){
            listaEscalaValoracionCaida.remove(escalaEliminar);
        }
    }
    
    /**
     * @return
     */
    public String aceptar() {
        navegationRule = "";
        if(listaEscalaValoracionCaida != null && !listaEscalaValoracionCaida.isEmpty()){
        try {
            this.serviceLocator.getCirugiaService().saveEscalaValoracionCaidas(listaEscalaValoracionCaida);
            cargarHistorial();
            navegationRule = nextAction;
            // Se recarga el menu 
            if(menuBean!= null){
                FacesUtils.resetManagedBean(menuBean);    
            }
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
            navegationRule = "";
        }
     }else{
         FacesUtils.addErrorMessage("Se debe ingresar una escala valoracion de caidas");
     }


        return navegationRule;


    }
    
    public void calcularEscalaValoracionCaidas() {
        int puntos=0;
        msgRiesgo="";
        msgRiesgo1="";
        msgRiesgo2="";
        msgRiesgo3="";
        msgRiesgo4="";
        msgRiesgo5="";
        msgRiesgo6="";
        msgRiesgo7="";
        
        if(chescvalcai != null && chescvalcai.getHevccaidprev() != null){
                if("S".equals(chescvalcai.getHevccaidprev())){
                    puntos= puntos+1;
                }
        }
        
        if(chescvalcai != null && chescvalcai.getHevccestament() != null){
                if("CO".equals(chescvalcai.getHevccestament())){
                    puntos= puntos+1;
                }
        }
        
        if(lstDeficitSensorialSelect != null && !lstDeficitSensorialSelect.isEmpty()){
            for(String deficitSensorial:lstDeficitSensorialSelect){
                if(!"NI".equals(deficitSensorial)){
                    puntos= puntos+1;
                }
            }
        }
        
        if(lstDeambulacionSelect != null && !lstDeambulacionSelect.isEmpty()){
            for(String deambulacion:lstDeambulacionSelect){
                if(!"NO".equals(deambulacion)){
                    puntos= puntos+1;
                }
            }
        }
        
        if(lstMedicamentosSelect != null && !lstMedicamentosSelect.isEmpty()){
            for(String medicamentos:lstMedicamentosSelect){
                if(!"NI".equals(medicamentos)){
                    puntos= puntos+1;
                }
            }
        }
        puntosSeguimientos = puntos;
        msgPuntos="Total puntos: "+puntos;
        
        if(puntos >= 3){
            msgRiesgo = "� Se brinda Educaci�n al paciente y su familia� sobre la importancia de la prevenci�n de ca�das e identificaci�n del riesgo";
            msgRiesgo1 = "� Se explica a los familiares o cuidadores la importancia de estar acompa�ado durante el procedimiento.";
            msgRiesgo2 = "� Se orienta sobre el espacio y ambiente f�sico de la unidad en la que se encuentre, aseo personal, eliminaci�n, movilidad y deambulaci�n.";
            msgRiesgo3 = "� Se brinda asistencia por parte de Enfermer�a en sus necesidades b�sicas como eliminaci�n, movilidad y deambulaci�n.";
            msgRiesgo4 = "� Se realiza identificaci�n de paciente con riesgo alto de ca�da, con el bot�n amarillo para consulta externa o para cirug�a en la manilla del procedimiento.";
            msgRiesgo5 = "� Se realiza registro en el hablador de forma visible del riesgo alto de ca�da. ";
            msgRiesgo6 = "� Se asegura que los dispositivos de ayuda de uso personal de cada paciente est�n a su alcance (bastones, caminador, gafas, aud�fonos, etc.)."; 
            msgRiesgo7 = "� Se verifican las medidas de seguridad f�sicas del entorno del paciente que puedan aumentar el riesgo de ca�da. (Barandas de la camilla)"; 
        }
    }

    public String volver() {
        FacesUtils.resetManagedBean("consultarUsuariosIngresadosBean");
        FacesUtils.resetManagedBean("registrarEscalaValoracionCaidasBean");
        return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHevccaidprev(ValueChangeEvent valueChangeEvent) {
        chescvalcai.setHevccaidprev((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHevccmedicamen(ValueChangeEvent valueChangeEvent) {
        chescvalcai.setHevccmedicamen((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHevccdefisens(ValueChangeEvent valueChangeEvent) {
        chescvalcai.setHevccdefisens((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHevccestament(ValueChangeEvent valueChangeEvent) {
        chescvalcai.setHevccestament((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHevccdeambula(ValueChangeEvent valueChangeEvent) {
        chescvalcai.setHevccdeambula((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
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
     * @param lstConsclin
     */
    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    /**
     * @return
     */
    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
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
     * @param lstCaidasPrevias
     */
    public void setLstCaidasPrevias(List lstCaidasPrevias) {
        this.lstCaidasPrevias = lstCaidasPrevias;
    }

    /**
     * @return
     */
    public List getLstCaidasPrevias() {
        if (lstCaidasPrevias == null || lstCaidasPrevias.isEmpty()) {
            lstCaidasPrevias = new ArrayList();

            lstCaidasPrevias.add(new SelectItem("S", 
                                            "Si"));
            lstCaidasPrevias.add(new SelectItem("N", 
                                            "No"));
        }
        return lstCaidasPrevias;
    }

    /**
     * @param lstRespiracion
     */
    public void setLstDeficitSensorial(List lstRespiracion) {
        this.lstDeficitSensorial = lstRespiracion;
    }

    /**
     * @return
     */
    public List getLstDeficitSensorial() {
        if (lstDeficitSensorial == null || lstDeficitSensorial.isEmpty()) {
            lstDeficitSensorial = new ArrayList();
            
            lstDeficitSensorial.add(new SelectItem("NI", 
                                              "Ninguno"));
            lstDeficitSensorial.add(new SelectItem("AV", 
                                              "Alteraciones visuales"));
            lstDeficitSensorial.add(new SelectItem("AA", 
                                              "Alteraciones auditivas "));                                  
            lstDeficitSensorial.add(new SelectItem("DM", 
                                              "D�ficit de miembros"));
        }
        return lstDeficitSensorial;
    }

    /**
     * @param lstCirculacion
     */
    public void setLstMedicamentos(List lstCirculacion) {
        this.lstMedicamentos = lstCirculacion;
    }

    /**
     * @return
     */
    public List getLstMedicamentos() {
        if (lstMedicamentos == null || lstMedicamentos.isEmpty()) {
            lstMedicamentos = new ArrayList();
            
            lstMedicamentos.add(new SelectItem("NI", 
                                              "Ninguno"));
            lstMedicamentos.add(new SelectItem("DI", 
                                              "Diur�ticos"));
            lstMedicamentos.add(new SelectItem("AN", 
                                              "Antiparkinsonianos"));
            lstMedicamentos.add(new SelectItem("TS",
                                              "Tranquilizantes, sedantes"));
            lstMedicamentos.add(new SelectItem("HND",
                                              "Hipotensores no diur�ticos"));
            lstMedicamentos.add(new SelectItem("AD",
                                              "Antidepresivos"));
            lstMedicamentos.add(new SelectItem("AO",
                                              "Analg�sicos Opioides"));                                   
        }
        return lstMedicamentos;
    }

    /**
     * @param lstEstadoConciencia
     */
    public void setLstEstadoMental(List lstEstadoConciencia) {
        this.lstEstadoMental = lstEstadoConciencia;
    }

    /**
     * @return
     */
    public List getLstEstadoMental() {
        if (lstEstadoMental == null || lstEstadoMental.isEmpty()) {
            lstEstadoMental = new ArrayList();

            lstEstadoMental.add(new SelectItem("OR","Orientado"));
            lstEstadoMental.add(new SelectItem("CO","Confuso"));
        }
        return lstEstadoMental;
    }

    /**
     * @param lstSaturacion
     */
    public void setLstDeambulacion(List lstSaturacion) {
        this.lstDeambulacion = lstSaturacion;
    }

    /**
     * @return
     */
    public List getLstDeambulacion() {
        if (lstDeambulacion == null || lstDeambulacion.isEmpty()) {
            lstDeambulacion = new ArrayList();

            lstDeambulacion.add(new SelectItem("NO", 
                                             "Normal"));
            lstDeambulacion.add(new SelectItem("SSA", 
                                             "Segura sin ayuda"));
            lstDeambulacion.add(new SelectItem("AEA", 
                                             "Asistida con elementos de apoyo"));    
            lstDeambulacion.add(new SelectItem("RAI", 
                                             "Reposo absoluto o imposible"));                                  
                                             
        }
        return lstDeambulacion;
    }

    /**
     * @param numeroEscala
     */
    public void setNumeroEscala(String numeroEscala) {
        this.numeroEscala = numeroEscala;
    }

    /**
     * @return
     */
    public String getNumeroEscala() {
        return numeroEscala;
    }


    public void setChescvalcai(Chescvalcai chescvalcai) {
        this.chescvalcai = chescvalcai;
    }

    public Chescvalcai getChescvalcai() {
        return chescvalcai;
    }

    public void setLstCaidasPreviasSelect(List<String> lstCaidasPreviasSelect) {
        this.lstCaidasPreviasSelect = lstCaidasPreviasSelect;
    }

    public List<String> getLstCaidasPreviasSelect() {
        return lstCaidasPreviasSelect;
    }

    public void setLstDeficitSensorialSelect(List<String> lstDeficitSensorialSelect) {
        this.lstDeficitSensorialSelect = lstDeficitSensorialSelect;
    }

    public List<String> getLstDeficitSensorialSelect() {
        return lstDeficitSensorialSelect;
    }

    public void setLstMedicamentosSelect(List<String> lstMedicamentosSelect) {
        this.lstMedicamentosSelect = lstMedicamentosSelect;
    }

    public List<String> getLstMedicamentosSelect() {
        return lstMedicamentosSelect;
    }

    public void setLstEstadoMentalSelect(List<String> lstEstadoMentalSelect) {
        this.lstEstadoMentalSelect = lstEstadoMentalSelect;
    }

    public List<String> getLstEstadoMentalSelect() {
        return lstEstadoMentalSelect;
    }

    public void setLstDeambulacionSelect(List<String> lstDeambulacionSelect) {
        this.lstDeambulacionSelect = lstDeambulacionSelect;
    }

    public List<String> getLstDeambulacionSelect() {
        return lstDeambulacionSelect;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setCaidasPreviasSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstCaidasPreviasSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setDeficitSensorialSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstDeficitSensorialSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setMedicamentosSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstMedicamentosSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setEstadoMentalSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstEstadoMentalSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setDeambulacionSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstDeambulacionSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMsgPuntos(String msgPuntos) {
        this.msgPuntos = msgPuntos;
    }

    public String getMsgPuntos() {
        return msgPuntos;
    }

    public void setPuntosSeguimientos(int puntosSeguimientos) {
        this.puntosSeguimientos = puntosSeguimientos;
    }

    public int getPuntosSeguimientos() {
        return puntosSeguimientos;
    }

    public void setDtSeguimiento(HtmlDataTable dtSeguimiento) {
        this.dtSeguimiento = dtSeguimiento;
    }

    public HtmlDataTable getDtSeguimiento() {
        return dtSeguimiento;
    }


    public void setListaEscalaValoracionCaida(List<Chescvalcai> listaEscalaValoracionCaida) {
        this.listaEscalaValoracionCaida = listaEscalaValoracionCaida;
    }

    public List<Chescvalcai> getListaEscalaValoracionCaida() {
        return listaEscalaValoracionCaida;
    }

    public void setCaidasPreviasSeleccionados(String caidasPreviasSeleccionados) {
        this.caidasPreviasSeleccionados = caidasPreviasSeleccionados;
    }

    public String getCaidasPreviasSeleccionados() {
        return caidasPreviasSeleccionados;
    }

    public void setMedicamentosSeleccionados(String medicamentosSeleccionados) {
        this.medicamentosSeleccionados = medicamentosSeleccionados;
    }

    public String getMedicamentosSeleccionados() {
        return medicamentosSeleccionados;
    }

    public void setDeficitSensorialSeleccionados(String deficitSensorialSeleccionados) {
        this.deficitSensorialSeleccionados = deficitSensorialSeleccionados;
    }

    public String getDeficitSensorialSeleccionados() {
        return deficitSensorialSeleccionados;
    }

    public void setEstadoMentalSeleccionados(String estadoMentalSeleccionados) {
        this.estadoMentalSeleccionados = estadoMentalSeleccionados;
    }

    public String getEstadoMentalSeleccionados() {
        return estadoMentalSeleccionados;
    }

    public void setDeambulacionSeleccionados(String deambulacionSeleccionados) {
        this.deambulacionSeleccionados = deambulacionSeleccionados;
    }

    public String getDeambulacionSeleccionados() {
        return deambulacionSeleccionados;
    }

    public void setDtConsulta(HtmlDataTable dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public HtmlDataTable getDtConsulta() {
        return dtConsulta;
    }

    public void setLstConsultas(List lstConsultas) {
        this.lstConsultas = lstConsultas;
    }

    public List getLstConsultas() {
        return lstConsultas;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }
    
    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        List<Chescvalcai> listaEscalaValoracionCaidaAux = null;
        if (numeroConsulta != null)
            try {
                listaEscalaValoracionCaidaAux = 
                        serviceLocator.getCirugiaService().getEscalaValoracionCaidas(numeroConsulta);
                if(listaEscalaValoracionCaidaAux == null && numeroUsuario != null){
                    listaEscalaValoracionCaidaAux = 
                            serviceLocator.getClinicoService().getEscalaValoracionCaidasXdia(numeroUsuario);
                }        
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (listaEscalaValoracionCaidaAux != null && !listaEscalaValoracionCaidaAux.isEmpty())
            esValido = true;
        else
            esValido = false;
        return esValido;
    }

    public void setMsgRiesgo(String msgRiesgo) {
        this.msgRiesgo = msgRiesgo;
    }

    public String getMsgRiesgo() {
        return msgRiesgo;
    }

    public void setMsgRiesgo1(String msgRiesgo1) {
        this.msgRiesgo1 = msgRiesgo1;
    }

    public String getMsgRiesgo1() {
        return msgRiesgo1;
    }

    public void setMsgRiesgo2(String msgRiesgo2) {
        this.msgRiesgo2 = msgRiesgo2;
    }

    public String getMsgRiesgo2() {
        return msgRiesgo2;
    }

    public void setMsgRiesgo3(String msgRiesgo3) {
        this.msgRiesgo3 = msgRiesgo3;
    }

    public String getMsgRiesgo3() {
        return msgRiesgo3;
    }

    public void setMsgRiesgo4(String msgRiesgo4) {
        this.msgRiesgo4 = msgRiesgo4;
    }

    public String getMsgRiesgo4() {
        return msgRiesgo4;
    }

    public void setMsgRiesgo5(String msgRiesgo5) {
        this.msgRiesgo5 = msgRiesgo5;
    }

    public String getMsgRiesgo5() {
        return msgRiesgo5;
    }

    public void setMsgRiesgo6(String msgRiesgo6) {
        this.msgRiesgo6 = msgRiesgo6;
    }

    public String getMsgRiesgo6() {
        return msgRiesgo6;
    }

    public void setMsgRiesgo7(String msgRiesgo7) {
        this.msgRiesgo7 = msgRiesgo7;
    }

    public String getMsgRiesgo7() {
        return msgRiesgo7;
    }
}
