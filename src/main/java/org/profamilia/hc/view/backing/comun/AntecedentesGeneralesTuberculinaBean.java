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
import org.profamilia.hc.model.dto.Chantecespec;
import org.profamilia.hc.model.dto.ChantecespecPK;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
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
public class AntecedentesGeneralesTuberculinaBean extends BaseBean {


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /**Almacena los tipos de antecedentes  */
    private Chantecespec antecedespec;

    /** Almacena el codigo del tipo de antecedente */
    private String codigoAntecedente;

    /** Almacena el antecedente encontrado */
    private String antecedente;

    /** Almacena los antecedentes registrados  */

    List<Chantecegene> antecedespecGeneralesTuberculina;

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
    
    private Date fechaAplicacion;
    
    private Long peso;
    
    private List lstOpciones;
    
    private Boolean renderCualPresenta;
    
    private Boolean renderTratamiento;

    private Boolean renderContacto;
    
    private Boolean renderVive; 
    
    private UIInput numDiasDificultadRespirar;

    
    public AntecedentesGeneralesTuberculinaBean() {

    }
   

    public void init() {
       
        inicializarAntecedentes();
        nextAction = "";
        
       
    }

    public void inicializarAntecedentes() {
        try {
            renderCualPresenta=false;
            renderTratamiento=false;
            renderContacto=false;
            renderVive=false;
            
            if (numeroConsulta != null) {
                antecedespec = this.serviceLocator.getClinicoService().getAntecedentesTuberculina(numeroConsulta);
            }
            
            if(null==antecedespec){
                antecedespec= new Chantecespec();
            }
            else{
                if (antecedespec != null && 
                    antecedespec.getHaecprestuber().equals("S")) {
                    renderCualPresenta = true;
                }
                else{
                    antecedespec.setHaeccuantuber(null);
                    renderCualPresenta = false;
                }
            }
            renderTuberculina();
            
            
           
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public boolean validarCamposRequeridos() throws ModelException {
        String url = "body:formAntecedentesGenerales:panelTabAntecedentesGeneralesTuberculina:";
        boolean wexito = true;
        if (antecedespec != null) {
            if (antecedespec.getHaecprestuber() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesEspecificos").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedespec.getHaecprestuber().equals("S")) {
                if (antecedespec.getHaeccuantuber() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itCuandoTuber").toString(), 
                                               "El campo es obligatorio");
                }
            }


            if (antecedespec.getHaecrecibtrata() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesEspecificosTrata").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedespec.getHaecrecibtrata().equals("S")) {
                if (antecedespec.getHaectiemptrata() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itTiempoTuber").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (antecedespec.getHaeccontactubercu() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesEspecificosContacto").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedespec.getHaeccontactubercu().equals("S")) {
                if (antecedespec.getHaecquiencontac() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itContactoTuber").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (antecedespec.getHaecviveconel() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesEspecificosVive").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedespec.getHaecviveconel().equals("S")) {
                if (antecedespec.getHaectiempocompart() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itViveTuber").toString(), 
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
     * @param antecedespecGeneralesTuberculina
     */
    public void setantecedespecGeneralesTuberculina(List<Chantecegene> antecedespecGeneralesTuberculina) {
        this.antecedespecGeneralesTuberculina = antecedespecGeneralesTuberculina;
    }

    /**
     * @return
     */
    public List<Chantecegene> getantecedespecGeneralesTuberculina() {
        Chantecegene anteced;
        anteced = new Chantecegene();
        if (antecedespecGeneralesTuberculina == null || 
            antecedespecGeneralesTuberculina.isEmpty()) {
            antecedespecGeneralesTuberculina = new ArrayList<Chantecegene>();
            antecedespecGeneralesTuberculina.clear();
            List<Chtipoantece> lstTipoAntecedentes = null;
            try {
                  lstTipoAntecedentes = 
                            this.getServiceLocator().getClinicoService().getTipoAntecedente(tipoHistoria);
               
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstTipoAntecedentes != null && 
                !lstTipoAntecedentes.isEmpty()) {
                       
                if(antecedespecGeneralesTuberculina.isEmpty()){
                    for(Chtipoantece tipoAntecedente:lstTipoAntecedentes) {
                        anteced = new Chantecegene();
                        anteced.setHanntipoante(tipoAntecedente.getHtancodigo());
                        anteced.setHantdescripcio("No refiere");
                        anteced.setHancoperador(userName());
                        antecedespecGeneralesTuberculina.add(anteced);
                       
                    }    
                }
                

            }
        }

        return antecedespecGeneralesTuberculina;
    }


    public boolean esValido() {

        boolean esValido = false;
        Chantecespec antecedespecAux = null;
        try {

            if (numeroConsulta != null) {
                antecedespecAux = 
                        this.serviceLocator.getClinicoService().getAntecedentesTuberculina(numeroConsulta);
            }
            if (null !=antecedespecAux) {

                esValido = true;
            } else {
                esValido = false;
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
       
        return esValido;
    }


    public String aceptar() {
        navigationRule = "";

        try {
            if (validarCamposRequeridos()){
            ChantecespecPK chanteceespecId= new ChantecespecPK();
            chanteceespecId.setHaelconsulta(numeroConsulta);
            chanteceespecId.setHaectiposervi(tipoServicio);
            antecedespec.setComp_id(chanteceespecId);
            antecedespec.setHaedfecregistr(new Date());
            antecedespec.setHaecoperador(this.getUsuarioSystem().getCurcusuari());
            
            if(antecedespec.getHaecprestuber()!=null && antecedespec.getHaecprestuber().equals("N")){
                antecedespec.setHaeccuantuber(null);
            }
        
            
            this.getServiceLocator().getClinicoService().saveAntecedentesTuberculina(antecedespec);

            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
            }
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION  + " : " + e.getMessage() );
            navigationRule = "";
            e.printStackTrace();
        }
        return navigationRule;

    }


    public void setAntecedespec(Chantecespec antecedespec) {
        this.antecedespec = antecedespec;
    }

    public Chantecespec getAntecedespec() {
        return antecedespec;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setAntecedespecGeneralesTuberculina(List<Chantecegene> antecedespecGeneralesTuberculina) {
        this.antecedespecGeneralesTuberculina = antecedespecGeneralesTuberculina;
    }

    public List<Chantecegene> getAntecedespecGeneralesTuberculina() {
        return antecedespecGeneralesTuberculina;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public Long getPeso() {
        return peso;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHaecprestuber(ValueChangeEvent valueChangeEvent) {
        antecedespec.setHaecprestuber((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHaecrecibtrata(ValueChangeEvent valueChangeEvent) {
        antecedespec.setHaecrecibtrata((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setHaeccontactubercu(ValueChangeEvent valueChangeEvent) {
        antecedespec.setHaeccontactubercu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHaecviveconel(ValueChangeEvent valueChangeEvent) {
        antecedespec.setHaecviveconel((String)valueChangeEvent.getNewValue());
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
    
    public void renderTuberculina(){
        changePresentaTuber();
        changeTratamientoTuber();
        changeContactoTuber();
        changeViveTuber();
    
    }

    public void changePresentaTuber() {
        if (null != antecedespec.getHaecprestuber()) {

            if (antecedespec != null && 
                antecedespec.getHaecprestuber() != null && 
                antecedespec.getHaecprestuber().equals("S")) {
                renderCualPresenta = true;
            } else {
                  renderCualPresenta = false;
            }
        }
    }

    public void changeTratamientoTuber() {
        if (null != antecedespec.getHaecprestuber()) {
            if (antecedespec != null && 
                antecedespec.getHaecrecibtrata() != null && 
                antecedespec.getHaecrecibtrata().equals("S")) {
                renderTratamiento = true;
            } else {
                renderTratamiento = false;
            }
        }
    }
 

    public void changeContactoTuber() {
        if (null != antecedespec.getHaecprestuber()) {
            if (antecedespec != null && 
                antecedespec.getHaeccontactubercu() != null && 
                antecedespec.getHaeccontactubercu().equals("S")) {
                renderContacto = true;
            } else {
                renderContacto = false;
            }
        }
    }

    public void changeViveTuber() {
        if (null != antecedespec.getHaecprestuber()) {
            if (antecedespec != null && 
                antecedespec.getHaecviveconel() != null && 
                antecedespec.getHaecviveconel().equals("S")) {
                renderVive = true;
            } else {
                renderVive = false;
            }
        }
    }


    public void setRenderTratamiento(Boolean renderTratamiento) {
        this.renderTratamiento = renderTratamiento;
    }

    public Boolean getRenderTratamiento() {
        return renderTratamiento;
    }

    public void setRenderContacto(Boolean renderContacto) {
        this.renderContacto = renderContacto;
    }

    public Boolean getRenderContacto() {
        return renderContacto;
    }

    public void setRenderVive(Boolean renderVive) {
        this.renderVive = renderVive;
    }

    public Boolean getRenderVive() {
        return renderVive;
    }

    public void setNumDiasDificultadRespirar(UIInput numDiasDificultadRespirar) {
        this.numDiasDificultadRespirar = numDiasDificultadRespirar;
    }

    public UIInput getNumDiasDificultadRespirar() {
        return numDiasDificultadRespirar;
    }
}
