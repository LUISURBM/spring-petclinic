package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chestadpsico;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chremisilve;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.util.FacesUtils;


public class RemisionIlveBean extends BaseBean {

    private Chremisilve remision;
    private String tipoServicio;
    private Long numeroConsulta;
    private Integer tipoHistoria;
    private Chusuario usuario;
    private String nextAction;
    private String nextAction2;

    private String menuBean;
    private String navigationRule;
    private List lstTipoRemision;
    private boolean renderCual;
    private boolean renderCertificacion;
    private boolean renderOtroMetodo;
    private List lstMetodo;
    private static double numeroSemanasEmbarazo;
    private double numeroDiasEmbarazo;
    private boolean renderAcepta;
    private List lstOpciones;
    private List lstRazones;
    private List lstNosuministra;
    private boolean renderNingunMetodo;
    private List lstTipoConducta;
    private List lstTipoConducta2;
    private List lstTipoConducta3;
    private boolean renderMensaje;
    private boolean renderPlantilla;
    private Integer selectedIndex;
    private UIInput itDescripcion;
    private boolean renderPlanifica;
    private boolean renderSuministra;
    private boolean renderNoPorque;
    private boolean renderNootro;
    private List lstOpcionesVoluntarias;
    private UIInput itDescripcionIVE;
    private boolean renderContinuarGesta;
    private boolean renderAdopcion;
    private boolean renderInterVoluEmba;
    private boolean renderDescPsicosocial;
    private boolean renderDescAnteMedi;
    private boolean renderContinua; 
    private UIInput itDescripcionPsicosocial;
    private UIInput itDescripcionAnteMedi;
    private boolean renderAclaracion;

    static final int ACTIVAR_APLICACION = 0;

    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;
    
    private boolean renderSiSuministraProfa;


    public RemisionIlveBean() {

    }

    public void init() {
        remision = new Chremisilve();
        inicializarRemision();
        selectedIndex = 0;
        
        lstTipoConducta2 = new ArrayList();
        lstTipoConducta2.add(new SelectItem("", "Seleccione"));
        
        lstTipoConducta3 = new ArrayList();
        lstTipoConducta3.add(new SelectItem("", "Seleccione"));
    }

    public void inicializarRemision() {
        renderCertificacion = false;
        renderAclaracion=false;
        renderCual = false;
        renderOtroMetodo = false;
        renderSuministra = true;
        renderNoPorque = false;
        renderNootro = false;
        renderContinuarGesta = false;
        renderAdopcion = false;
        renderInterVoluEmba = false;
        renderDescPsicosocial = false;
        renderDescAnteMedi = false;
        renderSiSuministraProfa= false;

        if (numeroConsulta != null)
            try {
                remision = 
                        getServiceLocator().getClinicoService().getRemisionIlve(numeroConsulta, 
                                                                                "C");
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (remision == null) {
            remision = new Chremisilve();
        } else {
            
            changeLista2();
            changeLista3();

            if (remision.getHrictiporemis() != null) {
                if (remision.getHrictiporemis().equals("OT"))
                    renderCual = true;
                if (remision.getHrictiporemis().equals("IQ") || 
                    remision.getHrictiporemis().equals("IM") || 
                    remision.getHrictiporemis().equals("QL") || 
                    remision.getHrictiporemis().equals("QG")) {

                    renderCertificacion = true;

                }

            }

            if (remision != null && remision.getHricmetodplani() != null && 
                remision.getHricmetodplani().equals("0")) {
                renderOtroMetodo = true;
            }

            if (remision != null && remision.getHricmetodplani() != null && 
                remision.getHricmetodplani().equals(CODIGO_NINGUN_METODO)) {
                renderNingunMetodo = true;
            }

            if (remision != null && remision.getHricsumiprofa() != null) { 
                if (remision.getHricsumiprofa().equals("S")) {
                    renderSuministra = true;
                    renderSiSuministraProfa = true;
                } else if (remision.getHricsumiprofa().equals("N")) {
                    renderSuministra = false;
                }
            } else {
                renderSuministra = false;
            }
                
            if (remision != null && remision.getHricsumiprofno() != null) {
                if (remision.getHricsumiprofno().equals("OT")) {
                    renderNootro = true;
                } else {
                    renderNootro = false;
                }
            } else {
                renderNootro = false;
            }
            
            if (remision != null && remision.getHricaceptpacie() != null) {
                if (remision.getHricaceptpacie().equals("S")) {
                    renderAcepta = true;
                } else if (remision.getHricaceptpacie().equals("N")) {
                    renderAcepta = false;
                }
            } else {
                renderAcepta = false;
            }
            
            if (remision != null && remision.getHricdeseaplan() != null) {
                if (remision.getHricdeseaplan().equals("S")) {
                    renderPlanifica = true;
                    renderAclaracion=false;
                } else if (remision.getHricdeseaplan().equals("N")) {
                    renderPlanifica = false;
                    renderSuministra = false;
                    renderAclaracion=true;
                }
            } else {
                renderPlanifica = false;
                renderSuministra = false;
                renderAclaracion=false;
            }
           
           if (remision != null && remision.getHricsumiprofa() != null) {
               if (remision.getHricsumiprofa().equals("N")) {
                   renderNoPorque = true;
               } else if (remision.getHricsumiprofa().equals("S")) {
                   renderNoPorque = false;
               } else {
                   renderNoPorque = false;
               }
           }
            changeHallazgosPositivos();
            changeOpcionVoluntaria();
        }
    }

    public String guardarRemisionilve() {
        navigationRule = "";
        boolean wexito = true;
        
        if(!renderContinua){
                remision.setHriccertimedic(null);
                remision.setHrictiporemis(null);
                remision.setHricotroremis(null);
                remision.setHricmetodplani(null);
                remision.setHricotrometod(null);
                remision.setHricaceptpacie(null); 
                remision.setHricmotivrecha(null);
                remision.setHriccausailve(null); 
                remision.setHricdeseaplan(null); 
                remision.setHricsumiprofa(null); 
                remision.setHricsumiprofno(null);
                remision.setHricsumiotro(null); 
                remision.setHricdesinvoem(null);
                remision.setHricpsicosocial(null);
                remision.setHricdescrpsico(null);
                remision.setHricantemedi(null);
                remision.setHricdesantmed(null);
        }

        Chestadpsico estadoPsicoemocional = null;


        try {
            estadoPsicoemocional = 
                    serviceLocator.getClinicoService().getEstadoPsicoemocional(numeroConsulta, 
                                                                               "C");
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (estadoPsicoemocional != null) {
            if (estadoPsicoemocional.getHepcareaafect() != null && 
                estadoPsicoemocional.getHepcareacogni() != null && 
                estadoPsicoemocional.getHepcarearelac() != null && 
                estadoPsicoemocional.getHepcareasomat() != null && 
                estadoPsicoemocional.getHepcareaafect().equals("SAL") && 
                estadoPsicoemocional.getHepcareacogni().equals("SA") && 
                estadoPsicoemocional.getHepcarearelac().equals("SA") && 
                estadoPsicoemocional.getHepcareasomat().equals("SA")) {
                renderMensaje = true;
            } else {
                renderMensaje = false;
            }


        } else {
            renderMensaje = false;
        }
        
        
        if(!renderAcepta){
            renderMensaje = false;
        }

    /*   if (!renderAcepta) {
            remision.setHriccertimedic(" ");
            remision.setHricmetodplani(" ");
            remision.setHricmotivrecha(" ");
            remision.setHricotrometod(" ");
            remision.setHricotroremis(" ");
            remision.setHrictiporemis(" ");
            remision.setHricdeseaplan(" ");
            remision.setHricsumiprofa(" ");
            remision.setHricsumiprofno(" ");
            remision.setHricsumiotro(" ");
        }
        */
            alertasEmbarazo();

            if (remision != null && remision.getHricmetodplani() != null && 
                !remision.getHricmetodplani().equals("0"))
                remision.setHricotrometod(null);
            if (numeroConsulta != null) {
                remision.getId().setHrictiposerv(tipoServicio);
                remision.getId().setHrilconsulta(numeroConsulta);
                remision.setHricoperador(userName());
                remision.setHridfecreg(new Date());
            }


            if (renderAcepta) {
                      if (remision.getHriccausailve() == null || 
                                remision.getHriccausailve().equals("")) {
                                FacesUtils.addErrorMessage("body:formCertificadoMedicoIlve:panelTabRemisionilve:mnuCausal", 
                                                           "El campo es obligatorio");
                                wexito = false;
                            }
                if (remision.getHrictiporemis() == null || 
                    remision.getHrictiporemis().equals("")) {
                    FacesUtils.addErrorMessage("body:formCertificadoMedicoIlve:panelTabRemisionilve:mnuTipoRemision", 
                                               "El campo es obligatorio");
                    wexito = false;
                }

                if (remision.getHrictiporemis() != null) {
                    if (remision.getHrictiporemis().equals("OT") && 
                        (remision.getHricotroremis() == null || 
                         remision.getHricotroremis().equals(""))) {
                        FacesUtils.addErrorMessage("body:formCertificadoMedicoIlve:panelTabRemisionilve:itOtraRemision", 
                                                   "El campo es obligatorio");
                        wexito = false;
                    }

                    if ((remision.getHrictiporemis().equals("FA") || 
                         remision.getHrictiporemis().equals("AB") || 
                         remision.getHrictiporemis().equals("AG")) && 
                        (remision.getHriccertimedic() == null || 
                         remision.getHriccertimedic().equals(" "))) {
                        FacesUtils.addErrorMessage("body:formCertificadoMedicoIlve:panelTabRemisionilve:itCertificacion", 
                                                   "De acuerdo a la C-355 de 2006 para realizar una interrupci�n legal se requiere una certificaci�n m�dica, sino se realiza la certificaci�n no podr� realizarse el procedimiento");
                        wexito = false;
                    }
                }
                
                if (!renderSuministra) {
                    if (remision.getHricsumiprofno() == null || remision.getHricsumiprofno().equals("")) {
                        FacesUtils.addErrorMessage("body:formCertificadoMedicoIlve:panelTabRemisionilve:mnuNosuministra", 
                                                   "El campo es obligatorio");
                    }
                    
                    if (remision.getHricsumiprofno() != null) {
                        if (remision.getHricsumiprofno().equals("OT") && 
                            (remision.getHricsumiotro() == null || 
                            remision.getHricsumiotro().equals(""))) {
                                FacesUtils.addErrorMessage("body:formCertificadoMedicoIlve:panelTabRemisionilve:InputNoOtro", 
                                                           "El campo es obligatorio");
                        }
                    }
                }
            }
            
     

            if (remision.getHrictiporemis() != null) {
                if (!remision.getHrictiporemis().equals("OT"))
                    remision.setHricotroremis(null);
                if (!remision.getHrictiporemis().equals("FA") && 
                    !remision.getHrictiporemis().equals("AB") && 
                    !remision.getHrictiporemis().equals("AG") &&
                    !remision.getHrictiporemis().equals("DE") &&
                    !remision.getHrictiporemis().equals("AF"))
                    remision.setHriccertimedic(" ");
            }


            if (wexito){
                try {
                    serviceLocator.getClinicoService().saveRemisionIlve(remision);
                    FacesUtils.addInfoMessage("Se ingreso la informaci�n satisfactoriamente.");
                    if (remision.getHrictiporemis() != null && remision.getHrictiporemis().equals("QG")) {
                        FacesUtils.addInfoMessage("Se debe solicitar valoraci�n por Anestesiolog�a.");
                    }
                    FacesUtils.resetManagedBean(menuBean);
                    if(remision.getHricinicimetod() != null && "S".equals(remision.getHricinicimetod())){
                        nextAction = BeanNavegacion.RUTA_IR_METODO_INTERRUPCION;
                        nextAction2 = BeanNavegacion.RUTA_IR_METODO_INTERRUPCION; 
                    }else{
                        nextAction = BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION;
                        nextAction2 = BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_INTERRUPCION;
                    }
                    if(renderContinua){
                        navigationRule = nextAction;    
                    }else{
                        navigationRule = nextAction2; 
                        FacesUtils.addInfoMessage("Recuerde cambiar diagn�stico acorde a la opci�n que seleccion� la paciente");
                    }     
                } catch (ModelException e) {
                    e.printStackTrace();
                    navigationRule = "";
                    FacesUtils.addErrorMessage("Adicion no realizada");
                }
            }
                
        

        return navigationRule;
    }

    /**
     * @return
     */
    public boolean esValido() {
        Chremisilve remisionAux = null;
        if (numeroConsulta != null)
            try {
                remisionAux = 
                        getServiceLocator().getClinicoService().getRemisionIlve(numeroConsulta, 
                                                                                "C");
            } catch (ModelException e) {
                e.printStackTrace();
            }
        return remisionAux != null;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrictiporemis(ValueChangeEvent valueChangeEvent) {
        remision.setHrictiporemis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHricmetodplani(ValueChangeEvent valueChangeEvent) {
        remision.setHricmetodplani((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeTipoRemision() {
        renderCual = false;
        renderCertificacion = false;
        alertasEmbarazo();
        if (remision.getHrictiporemis() != null) {
            if (remision.getHrictiporemis().equals("OT"))
                renderCual = true;
            if (remision.getHrictiporemis().equals("IQ") || 
                remision.getHrictiporemis().equals("IM") || 
                remision.getHrictiporemis().equals("QL") || 
                remision.getHrictiporemis().equals("QG")) {

                renderCertificacion = true;

            }

        }
    }

    public void ChangeMetodoPlanificacion() {
        alertasEmbarazo();
        renderOtroMetodo = false;
        renderNingunMetodo = false;
        renderSuministra = true;
        renderNoPorque = false;
        renderNootro = false;
        if (remision != null && remision.getHricmetodplani() != null && 
            remision.getHricmetodplani().equals("0")) {
            renderOtroMetodo = true;
            renderSuministra = false;
        }

        if (remision != null && remision.getHricmetodplani() != null && 
            remision.getHricmetodplani().equals(CODIGO_NINGUN_METODO)) {
            renderNingunMetodo = true;
            renderSuministra = false;
        }


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
     * @param remision
     */
    public void setRemision(Chremisilve remision) {
        this.remision = remision;
    }

    /**
     * @return
     */
    public Chremisilve getRemision() {
        return remision;
    }

    /**
     * @param lstTipoRemision
     */
    public void setLstTipoRemision(List lstTipoRemision) {
        this.lstTipoRemision = lstTipoRemision;
    }

    /**
     * @return
     */
    public List getLstTipoRemision() {
        if (lstTipoRemision == null || lstTipoRemision.isEmpty()) {
            lstTipoRemision = new ArrayList();
            lstTipoRemision.add(new SelectItem("", "Seleccione"));
            //            lstTipoRemision.add(new SelectItem("IQ", "ILVE Quir�rgico"));
            lstTipoRemision.add(new SelectItem("FA", "Aborto Farmacol�gico"));
            lstTipoRemision.add(new SelectItem("AG", "Aborto por aspiraci�n Bajo anestesia general"));
            lstTipoRemision.add(new SelectItem("AB", "Aborto por aspiraci�n bajo Bloqueo"));
            lstTipoRemision.add(new SelectItem("DE", "Aborto por dilataci�n y evacuaci�n"));
            lstTipoRemision.add(new SelectItem("AF", "Interrupci�n voluntaria del embarazo por asistolia fetal"));

        }
        return lstTipoRemision;
    }

    /**
     * @param renderCual
     */
    public void setRenderCual(boolean renderCual) {
        this.renderCual = renderCual;
    }

    /**
     * @return
     */
    public boolean isRenderCual() {
        return renderCual;
    }

    /**
     * @param renderCertificacion
     */
    public void setRenderCertificacion(boolean renderCertificacion) {
        this.renderCertificacion = renderCertificacion;
    }

    /**
     * @return
     */
    public boolean isRenderCertificacion() {
        return renderCertificacion;
    }

    /**
     * @param lstMetodo
     */
    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    /**
     * @param renderOtroMetodo
     */
    public void setRenderOtroMetodo(boolean renderOtroMetodo) {
        this.renderOtroMetodo = renderOtroMetodo;
    }

    /**
     * @return
     */
    public boolean isRenderOtroMetodo() {
        return renderOtroMetodo;
    }

    /**
     * @param numeroSemanasEmbarazo
     */
    public void setNumeroSemanasEmbarazo(double numeroSemanasEmbarazo) {
        this.numeroSemanasEmbarazo = numeroSemanasEmbarazo;
    }

    /**
     * @return
     */
    public double getNumeroSemanasEmbarazo() {
        return numeroSemanasEmbarazo;
    }

    public List getLstMetodo() {
        if (lstMetodo == null || lstMetodo.isEmpty()) {
            lstMetodo = new ArrayList();
            ArrayList lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList)serviceLocator.getClinicoService().getMetodosPlanificacion("F");
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstMetodoAux.isEmpty()) {
                Iterator it = lstMetodoAux.iterator();
                int i = 0;
                lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMetodo.add(new SelectItem(((Chmetodoplan)lstMetodoAux.get(i)).getHmpccodigo(), 
                                                 ((Chmetodoplan)lstMetodoAux.get(i)).getHmpcdescripcio()));
                    i++;
                }
            }
        }
        return lstMetodo;
    }


    /**
     * @param numeroDiasEmbarazo
     */
    public void setNumeroDiasEmbarazo(double numeroDiasEmbarazo) {
        this.numeroDiasEmbarazo = numeroDiasEmbarazo;
    }

    /**
     * @return
     */
    public double getNumeroDiasEmbarazo() {
        return numeroDiasEmbarazo;
    }

    private void alertasEmbarazo() {

        if (remision.getHrictiporemis() != null) {
            if (remision.getHrictiporemis().equals("FA") || 
                remision.getHrictiporemis().equals("AB") || 
                remision.getHrictiporemis().equals("AG")) {
                if (remision.getHrictiporemis().equals("FA")) {
                    if (numeroDiasEmbarazo < 42) {
                        FacesUtils.addErrorMessage("Esperar una semana");
                        FacesUtils.addErrorMessage("Remitirse a la GPC � Interrupci�n voluntaria y legal del embarazo con intervenci�n farmacol�gica");

                    } else if (numeroDiasEmbarazo >= 63 && 
                               numeroDiasEmbarazo <= 97) {
                        FacesUtils.addErrorMessage("Se sugiere realizar IVE quir�rgico");
                        FacesUtils.addErrorMessage("Remitirse a la GPC � Interrupci�n voluntaria y legal del embarazo con intervenci�n farmacol�gica");

                    } else if (numeroDiasEmbarazo > 98) {
                        FacesUtils.addErrorMessage("Favor remitir");
                        FacesUtils.addErrorMessage("Remitirse a la GPC � Interrupci�n voluntaria y legal del embarazo con intervenci�n farmacol�gica");

                    }


                }

                if (remision.getHrictiporemis().equals("AB") || 
                    remision.getHrictiporemis().equals("AG")) {
                    if (numeroDiasEmbarazo < 42) {
                        FacesUtils.addErrorMessage("Esperar una semana");
                        FacesUtils.addErrorMessage("Remitirse a la GPC � Interrupci�n voluntaria y legal del embarazo con tratamiento quir�rgico");

                    } else if (numeroDiasEmbarazo > 98) {
                        FacesUtils.addErrorMessage("Favor remitir");
                        FacesUtils.addErrorMessage("Remitirse a la GPC � Interrupci�n voluntaria y legal del embarazo con tratamiento quir�rgico");
                    }

                }

            }
        }

    }

    public void setHricaceptpacie(ValueChangeEvent valueChangeEvent) {
        remision.setHricaceptpacie((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHricdeseaplan(ValueChangeEvent valueChangeEvent) {
        remision.setHricdeseaplan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHricsumiprofa(ValueChangeEvent valueChangeEvent) {
        remision.setHricsumiprofa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderAcepta(boolean renderAcepta) {
        this.renderAcepta = renderAcepta;
    }

    public boolean isRenderAcepta() {
        return renderAcepta;
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


    public void changeAcepta() {
        if (remision != null && remision.getHricaceptpacie() != null) {
            if (remision.getHricaceptpacie().equals("S")) {
                renderAcepta = true;
            } else if (remision.getHricaceptpacie().equals("N")) {
                renderAcepta = false;
            }
        } else {
            renderAcepta = false;
        }
    }

    public void changePlanifica() {
        if (remision != null && remision.getHricdeseaplan() != null) {
            if (remision.getHricdeseaplan().equals("S")) {
                renderPlanifica = true;
                renderAclaracion=false;
            } else if (remision.getHricdeseaplan().equals("N")) {
                renderPlanifica = false;
                renderSuministra = false;
                renderAclaracion=true;
                remision.setHricinicimetod(null);
            }
        } else {
            renderPlanifica = false;
            renderSuministra = false;
            renderAclaracion=false;
            remision.setHricinicimetod(null);
        }
    }

    public void changeSuministra() {
        if (remision != null && remision.getHricsumiprofa() != null) {
            if (remision.getHricsumiprofa().equals("S")) {
                renderSuministra = true;
                renderNoPorque = false;
                renderSiSuministraProfa = true;
            } else if (remision.getHricsumiprofa().equals("N")) {
                renderSuministra = false;
                renderNoPorque = true;
                remision.setHricsumiprofno(null);
                remision.setHricsumiotro(null);
                remision.setHricinicimetod(null);
                renderSiSuministraProfa=false;
            }
        } else {
            renderSuministra = false;
            remision.setHricsumiprofno(null);
            remision.setHricsumiotro(null);
            remision.setHricinicimetod(null);
        }
        renderNootro = false;
    }

    public void changeNootro() {
        if (remision != null && remision.getHricsumiprofno() != null) {
            if (remision.getHricsumiprofno().equals("OT")) {
                renderNootro = true;
            } else {
                renderNootro = false;
                remision.setHricsumiotro(null);
            }
        } else {
            renderNootro = false;
            remision.setHricsumiotro(null);
        }
    }

    public void setLstRazones(List lstRazones) {
        this.lstRazones = lstRazones;
    }

    public List getLstRazones() {
        if (lstRazones == null || lstRazones.isEmpty()) {
            lstRazones = new ArrayList();
            lstRazones.add(new SelectItem("", "Seleccione..."));
            lstRazones.add(new SelectItem("SE", 
                                          "Realizar� su Planificaci�n Familiar en la EPS"));
            lstRazones.add(new SelectItem("NC", "No tiene compa�ero actual"));
            lstRazones.add(new SelectItem("PL", "Ya esta planificando"));
            lstRazones.add(new SelectItem("FT", 
                                          "Ya se encuentra planificando y tuvo falla temporal de m�todo"));

        }
        return lstRazones;
    }

    public void setLstNosuministra(List lstNosuministra) {
        this.lstNosuministra = lstNosuministra;
    }

    public List getLstNosuministra() {
        if (lstNosuministra == null || lstNosuministra.isEmpty()) {
            lstNosuministra = new ArrayList();
            lstNosuministra.add(new SelectItem("", "Seleccione..."));
            lstNosuministra.add(new SelectItem("SE", "Lo solicitar� en su EPS"));
            lstNosuministra.add(new SelectItem("ND", "Marca comercial no disponible"));
            lstNosuministra.add(new SelectItem("OT", "Otro"));
        }
        return lstNosuministra;
    }


    /**
     * @param renderNingunMetodo
     */
    public void setRenderNingunMetodo(boolean renderNingunMetodo) {
        this.renderNingunMetodo = renderNingunMetodo;
    }

    /**
     * @return
     */
    public boolean isRenderNingunMetodo() {
        return renderNingunMetodo;
    }

    public void setLstTipoConducta(List lstTipoConducta) {
        this.lstTipoConducta = lstTipoConducta;
    }

    public List getLstTipoConducta() {
        if (lstTipoConducta == null || lstTipoConducta.isEmpty()) {
            lstTipoConducta = new ArrayList();
            lstTipoConducta.add(new SelectItem("", "Seleccione"));
            lstTipoConducta.add(new SelectItem("CS", "Salud"));
            lstTipoConducta.add(new SelectItem("VS", "Violencia Sexual"));
            lstTipoConducta.add(new SelectItem("MC", 
                                               "Malformaci�n Congenita"));
        }
        return lstTipoConducta;
    }

    public void setRenderMensaje(boolean renderMensaje) {
        this.renderMensaje = renderMensaje;
    }

    public boolean isRenderMensaje() {
        return renderMensaje;
    }

    public void aceptarPlantilla() {
        BuscadorPlantillaBean buscador = 
            (BuscadorPlantillaBean)FacesUtils.getManagedBean("buscadorPlantillaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            remision.setHriccertimedic(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
    }

    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public UIInput getItDescripcion() {
        return itDescripcion;
    }


    public void mostrarBuscadorPlantilla() {
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
        renderPlantilla = true;
    }


    public void setRenderPlanifica(boolean renderPlanifica) {
        this.renderPlanifica = renderPlanifica;
    }

    public boolean isRenderPlanifica() {
        return renderPlanifica;
    }

    public void setRenderSuministra(boolean renderSuministra) {
        this.renderSuministra = renderSuministra;
    }

    public boolean isRenderSuministra() {
        return renderSuministra;
    }


    public void setRenderNootro(boolean renderNootro) {
        this.renderNootro = renderNootro;
    }

    public boolean isRenderNootro() {
        return renderNootro;
    }


    public void setRenderNoPorque(boolean renderNoPorque) {
        this.renderNoPorque = renderNoPorque;
    }

    public boolean isRenderNoPorque() {
        return renderNoPorque;
    }

    public void setLstOpcionesVoluntarias(List lstOpcionesVoluntarias) {
        this.lstOpcionesVoluntarias = lstOpcionesVoluntarias;
    }

    public List getLstOpcionesVoluntarias() {
        if (lstOpcionesVoluntarias == null || lstOpcionesVoluntarias.isEmpty()) {
            lstOpcionesVoluntarias = new ArrayList();
            lstOpcionesVoluntarias.add(new SelectItem("", "Seleccione"));
            lstOpcionesVoluntarias.add(new SelectItem("CG", "Continuar gestaci�n"));
            lstOpcionesVoluntarias.add(new SelectItem("AD", "Adopci�n"));
            lstOpcionesVoluntarias.add(new SelectItem("IV", "Interrupci�n voluntaria del embarazo"));

        }
        return lstOpcionesVoluntarias;
    }

    public void setItDescripcionIVE(UIInput itDescripcionIVE) {
        this.itDescripcionIVE = itDescripcionIVE;
    }

    public UIInput getItDescripcionIVE() {
        return itDescripcionIVE;
    }

    public void setRenderContinuarGesta(boolean renderContinuarGesta) {
        this.renderContinuarGesta = renderContinuarGesta;
    }

    public boolean isRenderContinuarGesta() {
        return renderContinuarGesta;
    }

    public void setRenderAdopcion(boolean renderAdopcion) {
        this.renderAdopcion = renderAdopcion;
    }

    public boolean isRenderAdopcion() {
        return renderAdopcion;
    }

    public void setRenderInterVoluEmba(boolean renderInterVoluEmba) {
        this.renderInterVoluEmba = renderInterVoluEmba;
    }

    public boolean isRenderInterVoluEmba() {
        return renderInterVoluEmba;
    }

    public void setRenderDescPsicosocial(boolean renderDescPsicosocial) {
        this.renderDescPsicosocial = renderDescPsicosocial;
    }

    public boolean isRenderDescPsicosocial() {
        return renderDescPsicosocial;
    }

    public void setRenderDescAnteMedi(boolean renderDescAnteMedi) {
        this.renderDescAnteMedi = renderDescAnteMedi;
    }

    public boolean isRenderDescAnteMedi() {
        return renderDescAnteMedi;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHricpsicosocial(ValueChangeEvent valueChangeEvent) {
        remision.setHricpsicosocial((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHricantemedi(ValueChangeEvent valueChangeEvent) {
        remision.setHricantemedi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHricescogvolun(ValueChangeEvent valueChangeEvent) {
        remision.setHricescogvolun((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeHallazgosPositivos() {
        renderDescPsicosocial = false;
        renderDescAnteMedi = false;
        if (remision != null && remision.getHricpsicosocial() != null) {
            if (remision.getHricpsicosocial().equals("S")) {
                renderDescPsicosocial = true;
            } else {
                renderDescPsicosocial = false;
                remision.setHricdescrpsico(null);
                if(itDescripcionPsicosocial != null){
                itDescripcionPsicosocial.setValue(null);
                }
            }
        }

        if (remision != null && remision.getHricantemedi() != null) {
            if (remision.getHricantemedi().equals("S")) {
                renderDescAnteMedi = true;
            } else {
                renderDescAnteMedi = false;
                remision.setHricdesantmed(null);
                if(itDescripcionAnteMedi != null){
                itDescripcionAnteMedi.setValue(null);
                }
            }
        }
    }
    
    public void changeOpcionVoluntaria() {
        renderContinuarGesta = false;
        renderAdopcion = false;
        renderInterVoluEmba = false;
        renderContinua = false; 
        if (remision != null && remision.getHricescogvolun() != null) {
            if (remision.getHricescogvolun().equals("CG")) {
                renderContinuarGesta = true;
                renderContinua = false; 
                remision.setHricdesinvoem(null);
                if(itDescripcionIVE != null){
                itDescripcionIVE.setValue(null);
                }
            } else if (remision.getHricescogvolun().equals("AD")) {
                renderAdopcion = true;
                remision.setHricdesinvoem(null);
                renderContinua = false; 
                if(itDescripcionIVE != null){
                itDescripcionIVE.setValue(null);
                }
            }else if (remision.getHricescogvolun().equals("IV")) {
                renderInterVoluEmba = true;
                renderContinua = true; 
            }
        }
    }

    public void setItDescripcionPsicosocial(UIInput itDescripcionPsicosocial) {
        this.itDescripcionPsicosocial = itDescripcionPsicosocial;
    }

    public UIInput getItDescripcionPsicosocial() {
        return itDescripcionPsicosocial;
    }

    public void setItDescripcionAnteMedi(UIInput itDescripcionAnteMedi) {
        this.itDescripcionAnteMedi = itDescripcionAnteMedi;
    }

    public UIInput getItDescripcionAnteMedi() {
        return itDescripcionAnteMedi;
    }

    public void setRenderContinua(boolean renderContinua) {
        this.renderContinua = renderContinua;
    }

    public boolean isRenderContinua() {
        return renderContinua;
    }

    public void setNextAction2(String nextAction2) {
        this.nextAction2 = nextAction2;
    }

    public String getNextAction2() {
        return nextAction2;
    }

    public void setRenderAclaracion(boolean renderAclaracion) {
        this.renderAclaracion = renderAclaracion;
    }

    public boolean isRenderAclaracion() {
        return renderAclaracion;
    }

    public void setLstTipoConducta2(List lstTipoConducta2) {
        this.lstTipoConducta2 = lstTipoConducta2;
    }

    public List getLstTipoConducta2() {
        return lstTipoConducta2;
    }

    public void setLstTipoConducta3(List lstTipoConducta3) {
        this.lstTipoConducta3 = lstTipoConducta3;
    }

    public List getLstTipoConducta3() {
        return lstTipoConducta3;
    }
    
    
    public void changeLista2(){
        lstTipoConducta2 = new ArrayList();
        lstTipoConducta2.add(new SelectItem("", "Seleccione"));
        
        lstTipoConducta3 = new ArrayList();
        lstTipoConducta3.add(new SelectItem("", "Seleccione"));
        

        if(remision != null && remision.getHriccausailve() != null){
            
            if(remision.getHriccausailve().equals("CS")){
                lstTipoConducta2.add(new SelectItem("MC", 
                                                   "Malformaci�n Congenita")); 
                lstTipoConducta2.add(new SelectItem("VS", "Violencia Sexual"));
            }else if(remision.getHriccausailve().equals("VS")){
                lstTipoConducta2.add(new SelectItem("CS", "Salud"));
                lstTipoConducta2.add(new SelectItem("MC", 
                                                   "Malformaci�n Congenita"));
            }else if(remision.getHriccausailve().equals("MC")){
                lstTipoConducta2.add(new SelectItem("CS", "Salud"));
                lstTipoConducta2.add(new SelectItem("VS", "Violencia Sexual"));
            }
            
           
        }
        
        changeLista3();

        
    }
    
    
    public void changeLista3(){
        lstTipoConducta3 = new ArrayList();
        lstTipoConducta3.add(new SelectItem("", "Seleccione"));
        
        if(remision != null && remision.getHriccausailve() != null  && 
           remision.getHriccausailve2() != null){
            if(remision.getHriccausailve().equals("CS")){
                if(remision.getHriccausailve2().equals("MC")){
                    lstTipoConducta3.add(new SelectItem("VS", "Violencia Sexual"));
                } else   if(remision.getHriccausailve2().equals("VS")){
                    lstTipoConducta3.add(new SelectItem("MC", "Malformaci�n Congenita"));  
                }
            }else if(remision.getHriccausailve().equals("VS")){
                if(remision.getHriccausailve2().equals("MC")){
                    lstTipoConducta3.add(new SelectItem("CS", "Salud"));
                } else   if(remision.getHriccausailve2().equals("CS")){
                    lstTipoConducta3.add(new SelectItem("MC", "Malformaci�n Congenita"));  
                }
            }else if(remision.getHriccausailve().equals("MC")){
                if(remision.getHriccausailve2().equals("CS")){
                    lstTipoConducta3.add(new SelectItem("VS", "Violencia Sexual"));
                } else   if(remision.getHriccausailve2().equals("VS")){
                    lstTipoConducta3.add(new SelectItem("CS", "Salud"));
                }
            }
            
           
        }
    }


    public void setHriccausailve(ValueChangeEvent valueChangeEvent) {
        remision.setHriccausailve((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHriccausailve2(ValueChangeEvent valueChangeEvent) {
        remision.setHriccausailve2((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

    public void setRenderSiSuministraProfa(boolean renderSiSuministraProfa) {
        this.renderSiSuministraProfa = renderSiSuministraProfa;
    }

    public boolean isRenderSiSuministraProfa() {
        return renderSiSuministraProfa;
    }
    
    public void changeIniciaMetodo() {
        if(remision.getHricinicimetod() != null && "S".equals(remision.getHricinicimetod())){
            nextAction = BeanNavegacion.RUTA_IR_METODO_INTERRUPCION;
            nextAction2 = BeanNavegacion.RUTA_IR_METODO_INTERRUPCION; 
        }else{
            nextAction = BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_IVE_INTERRUPCION;
            nextAction2 = BeanNavegacion.RUTA_IR_IMPRESION_DIAGNOSTICA_INTERRUPCION;
        }
    }
}
