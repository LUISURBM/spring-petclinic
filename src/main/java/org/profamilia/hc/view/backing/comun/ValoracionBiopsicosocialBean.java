package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chanteceobst;
import org.profamilia.hc.model.dto.ChanteceobstPK;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvalorabiopsi;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ValoracionBiopsicosocialBean extends BaseBean {

    private Chvalorabiopsi valoracionBiopsicosocial;

    private List lstOpciones;

    private Integer tipoHistoria;

    private String navigationRule;

    private Chusuario usuario;

    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;
    
    private String mensajePuntos;
    
    private boolean renderPuntos;
    
    private boolean renderAnemia;
    
    private UIInput datosAnemia;
    
    private Integer numParto;


    public ValoracionBiopsicosocialBean() {
    }

    public void init() {
        lstOpciones = new ArrayList();
        mensajePuntos="La paciente se encuentra en alto riesgo biopsicosocial";

        inicializarValoracionBiopsicosocial();
    }

    public void inicializarValoracionBiopsicosocial() {
        try {
            valoracionBiopsicosocial = 
                    serviceLocator.getClinicoService().getValoracionBiopsicosocial(numeroConsulta);

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (valoracionBiopsicosocial == null) {
            renderPuntos=false;
            renderAnemia = false;
            valoracionBiopsicosocial = new Chvalorabiopsi();
            valoracionBiopsicosocial.setHvbccesaprev("N");
            valoracionBiopsicosocial.setHvbcpreehipe("N");
            valoracionBiopsicosocial.setHvbcaborinfe("N");
            valoracionBiopsicosocial.setHvbchemposrem("N");
            valoracionBiopsicosocial.setHvbcmanuplac("N");
            valoracionBiopsicosocial.setHvbcmorfetneo("N");
            valoracionBiopsicosocial.setHvbcparanodifi("N");
            valoracionBiopsicosocial.setHvbccirginpre("N");
            valoracionBiopsicosocial.setHvbcenfrencro("N");
            valoracionBiopsicosocial.setHvbcdiabgest("N");
            valoracionBiopsicosocial.setHvbcdiabprec("N");
            valoracionBiopsicosocial.setHvbchipearte("N");
            valoracionBiopsicosocial.setHvbcpolihidra("N");
            valoracionBiopsicosocial.setHvbcembmult("N");
            valoracionBiopsicosocial.setHvbcprefretra("N");
            valoracionBiopsicosocial.setHvbcisoinnmu("N");
            valoracionBiopsicosocial.setHvbcansiseve("N");
            valoracionBiopsicosocial.setHvbcsosofain("N");
            valoracionBiopsicosocial.setHvbcanemia("N");
            if(usuario != null && usuario.getHusdfechanacim() != null ){
                valoracionBiopsicosocial.setHvbnedad(calcularEdad(usuario.getHusdfechanacim(), new Date()));    
            }
            
            if(numParto != null){
                valoracionBiopsicosocial.setHvbnparidad(numParto);
            }
            
            
        }
        
        calcularPuntos();
        

    }

    public void calcularPuntos() {
        Integer puntos = 0;
        
        //Historia Reproductiva
        if (valoracionBiopsicosocial.getHvbnedad() != null) {
            if (valoracionBiopsicosocial.getHvbnedad() < 16) {
                puntos = puntos + 1;
            } else if (valoracionBiopsicosocial.getHvbnedad() > 35) {
                puntos = puntos + 2;
            }
        }

        if (valoracionBiopsicosocial.getHvbnparidad() != null) {
            if (valoracionBiopsicosocial.getHvbnparidad() == 0) {
                puntos = puntos + 1;
            } else if (valoracionBiopsicosocial.getHvbnparidad() > 4) {
                puntos = puntos + 2;
            }
        }
        
        if ("S".equals(valoracionBiopsicosocial.getHvbccesaprev())) {
            puntos = puntos + 1;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcpreehipe())) {
            puntos = puntos + 1;
        }


        if ("S".equals(valoracionBiopsicosocial.getHvbcaborinfe())) {
            puntos = puntos + 1;
        }


        if ("S".equals(valoracionBiopsicosocial.getHvbchemposrem())) {
            puntos=puntos+1;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcmanuplac())) {
            puntos = puntos + 1;
        }
        
        if (valoracionBiopsicosocial.getHvbnpesrecnac() != null) {
            if (valoracionBiopsicosocial.getHvbnpesrecnac() < 2500 || 
                valoracionBiopsicosocial.getHvbnpesrecnac() > 4000) {
                puntos = puntos + 1;
            }
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcmorfetneo())) {
            puntos = puntos + 1;
        }


        if ("S".equals(valoracionBiopsicosocial.getHvbcparanodifi())) {
            puntos = puntos + 1;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbccirginpre())) {
            puntos = puntos + 1;
        }

        //Emabarazo actual

        if ("S".equals(valoracionBiopsicosocial.getHvbcenfrencro())) {
            puntos = puntos + 2;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcdiabgest())) {
            puntos = puntos + 2;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcdiabprec())) {
            puntos = puntos + 3;
        }
        
        if (valoracionBiopsicosocial.getHvbnhemorragia() != null) {
            if (valoracionBiopsicosocial.getHvbnhemorragia() < 20) {
                puntos = puntos + 1;
            } else if (valoracionBiopsicosocial.getHvbnhemorragia() >= 20) {
                puntos = puntos + 2;
            }
        }

        if (valoracionBiopsicosocial.getHvbnanemiadesc() != null && "S".equals(valoracionBiopsicosocial.getHvbcanemia())) {
            renderAnemia = true;
            if (valoracionBiopsicosocial.getHvbnanemiadesc() < 10) {
                puntos = puntos + 1;
            }
        }
        
       if (valoracionBiopsicosocial.getHvbnembpro() != null) {
       
           if (valoracionBiopsicosocial.getHvbnembpro() >= 42) {
               puntos = puntos + 1;
           }
       }

        if ("S".equals(valoracionBiopsicosocial.getHvbchipearte())) {
            puntos = puntos + 2;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcpolihidra())) {
            puntos = puntos + 2;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcembmult())) {
            puntos = puntos + 3;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcprefretra())) {
            puntos = puntos + 3;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcisoinnmu())) {
            puntos = puntos + 3;
        }
        
        //Riesgo psicosocial

        if ("S".equals(valoracionBiopsicosocial.getHvbcansiseve())) {
            puntos = puntos + 1;
        }

        if ("S".equals(valoracionBiopsicosocial.getHvbcsosofain())) {
            puntos = puntos + 1;
        }
        
        valoracionBiopsicosocial.setHvbnpuntos(puntos);
        
        if(valoracionBiopsicosocial.getHvbnpuntos() >=3){
            renderPuntos =true;
        }else{
            renderPuntos =false;
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

    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
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
        Chvalorabiopsi valoracionAux = null;
        boolean esValido = false;
        if (numeroConsulta != null) {
            try {
                valoracionAux = 
                        this.getServiceLocator().getClinicoService().getValoracionBiopsicosocial(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (valoracionAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public String aceptar() {

        try {
            valoracionBiopsicosocial.setHvbnconsulta(numeroConsulta);
            valoracionBiopsicosocial.setHvbdfechregi(new Date());
            valoracionBiopsicosocial.setHvbcusuaregi(userName());
            this.serviceLocator.getClinicoService().saveValoracionBiopsicosocial(valoracionBiopsicosocial);
            navigationRule = nextAction;
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }

        return navigationRule;
    }


    public void setValoracionBiopsicosocial(Chvalorabiopsi valoracionBiopsicosocial) {
        this.valoracionBiopsicosocial = valoracionBiopsicosocial;
    }

    public Chvalorabiopsi getValoracionBiopsicosocial() {
        return valoracionBiopsicosocial;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHusdfechanacim(ValueChangeEvent valueChangeEvent) {
        usuario.setHusdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbnedad(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbnedad((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbnparidad(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbnparidad((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbccesaprev(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbccesaprev((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcpreehipe(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcpreehipe((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcaborinfe(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcaborinfe((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbchemposrem(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbchemposrem((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcmanuplac(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcmanuplac((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbnpesrecnac(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbnpesrecnac((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcmorfetneo(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcmorfetneo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcparanodifi(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcparanodifi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbccirginpre(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbccirginpre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcenfrencro(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcenfrencro((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcdiabgest(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcdiabgest((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcdiabprec(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcdiabprec((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbnhemorragia(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbnhemorragia((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcanemia(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcanemia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbnembpro(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbnembpro((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbchipearte(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbchipearte((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcpolihidra(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcpolihidra((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcembmult(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcembmult((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcprefretra(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcprefretra((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcisoinnmu(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcisoinnmu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcansiseve(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcansiseve((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbcsosofain(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbcsosofain((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setMensajePuntos(String mensajePuntos) {
        this.mensajePuntos = mensajePuntos;
    }

    public String getMensajePuntos() {
        return mensajePuntos;
    }

    public void setRenderPuntos(boolean renderPuntos) {
        this.renderPuntos = renderPuntos;
    }

    public boolean isRenderPuntos() {
        return renderPuntos;
    }
    
    public void changeAnemia() {
        if (valoracionBiopsicosocial.getHvbcanemia().equals("S")) {
            renderAnemia = true;
        } else {
            renderAnemia = false;
            valoracionBiopsicosocial.setHvbnanemiadesc(null);
            datosAnemia.setValue(null);
            calcularPuntos();
        }
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHvbnanemiadesc(ValueChangeEvent valueChangeEvent) {
        valoracionBiopsicosocial.setHvbnanemiadesc((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderAnemia(boolean renderAnemia) {
        this.renderAnemia = renderAnemia;
    }

    public boolean isRenderAnemia() {
        return renderAnemia;
    }

    public void setDatosAnemia(UIInput datosAnemia) {
        this.datosAnemia = datosAnemia;
    }

    public UIInput getDatosAnemia() {
        return datosAnemia;
    }

    public void setNumParto(Integer numParto) {
        this.numParto = numParto;
    }

    public Integer getNumParto() {
        return numParto;
    }
}
