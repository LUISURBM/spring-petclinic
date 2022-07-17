//=======================================================================
// ARCHIVO AntecedentesGeneralesUsuarioBean.java
// FECHA CREACI�N: 
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos Antecedentes del paciente
//=======================================================================

package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.ChantecpatolPK;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.ChantecpatolPK;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=======================================================================
//  CLASE AntecedentesGeneralesBean
//=======================================================================
public class AntecedentesPatologicosTuberculinaBean extends BaseBean {


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /**Almacena los tipos de antecedentes  */
    private Chantecpatol antecedpatol;

    /** Almacena el codigo del tipo de antecedente */
    private String codigoAntecedente;

    /** Almacena el antecedente encontrado */
    private String antecedente;

    /** Almacena los antecedentes registrados  */

    List<Chantecegene> antecedpatologicosTuberculina;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtAntecedentes;


    /** Almacena el tipo de historia*/
    private Integer tipoHistoria;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;

    private List lstOpciones;

    private Boolean renderCualPresenta;


    public AntecedentesPatologicosTuberculinaBean() {

    }


    public void init() {
        renderCualPresenta = false;
        inicializarAntecedentes();
        nextAction = "";
        
    }

    public void inicializarAntecedentes() {
        renderCualPresenta = false;
        try {
            if (numeroConsulta != null) {
                antecedpatol = 
                        this.serviceLocator.getClinicoService().getAntecedentesPatologicosTuberculina(numeroConsulta);
            }

            if (null == antecedpatol) {
                antecedpatol = new Chantecpatol();
            } else {
                if (antecedpatol != null && 
                    antecedpatol.getHapcotra().equals("S")) {
                    renderCualPresenta = true;
                }
                else{
                    antecedpatol.setHapccual(null);
                    renderCualPresenta = false;
                }
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

     public boolean validarCamposRequeridos() throws ModelException {
         String url = "body:formAntecedentesGenerales:panelTabAntecedentesPatologicosTuberculina:";
         boolean wexito = true;
         if (antecedpatol != null) {
             if (antecedpatol.getHapcvih() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosvih").toString(), 
                                            "El campo es obligatorio");
             } 


             if (antecedpatol.getHapcdiabmelli() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosdm").toString(), 
                                            "El campo es obligatorio");
             } 
             if (antecedpatol.getHapcartrireuma() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosar").toString(), 
                                            "El campo es obligatorio");
             
             }
             if (antecedpatol.getHapcesclmult() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosem").toString(), 
                                            "El campo es obligatorio");
             } 


             if (antecedpatol.getHapccancer() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosca").toString(), 
                                            "El campo es obligatorio");
             } 
             
             if (antecedpatol.getHapcescllatamio() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosel").toString(), 
                                            "El campo es obligatorio");
             } 


             if (antecedpatol.getHapcnefropa() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosn").toString(), 
                                            "El campo es obligatorio");
             } 
             if (antecedpatol.getHapcmigrana() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosm").toString(), 
                                            "El campo es obligatorio");
             
             }
             if (antecedpatol.getHapcfibromi() == null) {
                 wexito = false;
                 FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicosf").toString(), 
                                            "El campo es obligatorio");
             }
             
             if (antecedpatol.getHapcotra() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesPatologicoso").toString(), 
                                                "El campo es obligatorio");
                 }else if (antecedpatol.getHapcotra().equals("S")) {
                 if (antecedpatol.getHapccual() == null) {
                     wexito = false;
                     FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itotraTuber").toString(), 
                                                "El campo es obligatorio");
                 }
             }
         }
         return wexito;
     }
     
    /**
     * @param codigoAntecedente
     */
    public void setCodigoAntecedente(String codigoAntecedente) {
        this.codigoAntecedente = codigoAntecedente;
    }

    /**
     * @return
     */
    public String getCodigoAntecedente() {
        return codigoAntecedente;
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

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getAntecedente() {
        return antecedente;
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
     * @param dtAntecedentes
     */
    public void setDtAntecedentes(HtmlDataTable dtAntecedentes) {
        this.dtAntecedentes = dtAntecedentes;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtAntecedentes() {
        return dtAntecedentes;
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
     * @param antecedpatologicosTuberculina
     */
    public void setAntecedpatologicosTuberculina(List<Chantecegene> antecedpatologicosTuberculina) {
        this.antecedpatologicosTuberculina = antecedpatologicosTuberculina;
    }



    public String aceptar() {
        navigationRule = "";

        try {
            if (validarCamposRequeridos()){
            ChantecpatolPK chantecepatolId = new ChantecpatolPK();
            chantecepatolId.setHaplconsulta(numeroConsulta);
            chantecepatolId.setHapctiposervi(tipoServicio);
            antecedpatol.setComp_id(chantecepatolId);
            antecedpatol.setHapdfecregistr(new Date());
            antecedpatol.setHapcoperador(this.getUsuarioSystem().getCurcusuari());


            this.getServiceLocator().getClinicoService().saveAntecedentesPatologicosTuberculina(antecedpatol);

            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
            }
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + " : " + 
                                       e.getMessage());
            navigationRule = "";
            e.printStackTrace();
        }
        return navigationRule;

    }


    public void setantecedpatol(Chantecpatol antecedpatol) {
        this.antecedpatol = antecedpatol;
    }

    public Chantecpatol getantecedpatol() {
        return antecedpatol;
    }


    public void setantecedpatologicosTuberculina(List<Chantecegene> antecedpatologicosTuberculina) {
        this.antecedpatologicosTuberculina = antecedpatologicosTuberculina;
    }

    public List<Chantecegene> getantecedpatologicosTuberculina() {
        return antecedpatologicosTuberculina;
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapcvih(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcvih((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcdiabmelli(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcdiabmelli((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcartrireuma(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcartrireuma((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcesclmult(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcesclmult((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapccancer(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapccancer((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcescllatamio(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcescllatamio((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcnefropa(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcnefropa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcmigrana(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcmigrana((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcfibromi(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcfibromi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcotra(ValueChangeEvent valueChangeEvent) {
        antecedpatol.setHapcotra((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    public void setRenderCualPresenta(Boolean renderCualPresenta) {
        this.renderCualPresenta = renderCualPresenta;
    }

    public Boolean getRenderCualPresenta() {
        return renderCualPresenta;
    }


    public void changeOtraTuber() {
        if (antecedpatol != null && antecedpatol.getHapcotra() != null && 
            antecedpatol.getHapcotra().equals("S")) {
            renderCualPresenta = true;
        } else {
            renderCualPresenta = false;
            antecedpatol.setHapccual(null);
        }
    }


    public void setAntecedpatol(Chantecpatol antecedpatol) {
        this.antecedpatol = antecedpatol;
    }

    public Chantecpatol getAntecedpatol() {
        return antecedpatol;
    }
    
     public boolean esValido() {
         boolean esValido = false;
         Chantecpatol antecepatolTuberculinaAux = null;
         if (numeroConsulta != null) {

             try {
                 antecepatolTuberculinaAux =  this.serviceLocator.getClinicoService().getAntecedentesPatologicosTuberculina(numeroConsulta);
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
         if (antecepatolTuberculinaAux != null) {
             esValido = true;
         } else {
             esValido = false;
         }
         return esValido;
     }

 }
