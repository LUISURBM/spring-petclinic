//=======================================================================
// ARCHIVO AntecedentePsicologiaBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a los antecedentes psicologicos
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chpsicoantec;
import org.profamilia.hc.model.dto.ChpsicoantecPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=================================================================
//  CLASE AntecedentePsicologiaBean
//=======================================================================

/**
 * AntecedentePsicologiaBean: Permite registrar los Datos correspondientes a los antecedentes psicologicos
 * @author Jos� Andr�s Riano jariano@profamilia.org.co
 * 
 */
public class AntecedentePsicologiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List lstOpciones;

    private Chpsicoantec antecedente;

    private boolean renderDiscapacidad;

    private boolean renderAlteracion;

    private boolean renderMedicamentos;

    private boolean renderHabitosSalud;

    private boolean renderOrientacion;

    private boolean renderVinculo;

    private boolean renderDificultades;

    private boolean renderTrastornos;

    private List lstOrientacion;

    private List lstTipoVinculo;

    private List lstTipoFamilia;

    private List lstTipoVinculoFamiliar;

    private String navigationRule;

    private Long numeroConsulta;

    private String tipoServicio;

    private String nextAction;

    private String menuBean;

    private Integer tipoHistoria;

    private Chusuario usuario;

    private boolean renderEnfermedadDiag;

    private boolean renderHabitoSaludable;

    private boolean renderquitaVida;

    private boolean rendersustanciaPsico;

    private boolean renderDificultadAprend;

    private boolean renderSocializarPares;

    private boolean renderRutina;

    private List lstTipoViolencia;
    
    private List<String> lstTipoViolenciaSelect;
    
    private boolean menor12edad=false;

    private int edad;
    
    private boolean renderTemperamento;
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AntecedentePsicologiaBean() {
    }

    public void init() {

        lstTipoViolencia = new ArrayList<String>();
        menor12edad= false;
       
        inicializarAntecedentes();
    }

    //ACTIONS

    public void inicializarAntecedentes() {
        if (numeroConsulta != null) {
            menor12edad=false;
            try {
                antecedente = 
                        this.getServiceLocator().getClinicoService().getAntecedentePsicologia(numeroConsulta, 
                                                                                              TIPO_CONSULTA);

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
        lstTipoViolenciaSelect= new ArrayList<String>();
        
        if (null != usuario &&  null != usuario.getHusanumeiden()) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
            if (edad >= 12) {
                menor12edad = false;
            }
            else{
                menor12edad=true;
            }
        }

        if (antecedente == null) {
            antecedente = new Chpsicoantec();
            
        } else {

            if (antecedente.getHpacpresedisca() != null && 
                antecedente.getHpacpresedisca().equals("S")) {
                renderDiscapacidad = true;
            } else {

                renderDiscapacidad = false;
            }

            if (antecedente.getHpactomamedi() != null && 
                antecedente.getHpactomamedi().equals("S")) {
                renderMedicamentos = true;
            } else {

                renderMedicamentos = false;
            }

            if (antecedente.getHpactrastmenta() != null && 
                antecedente.getHpactrastmenta().equals("S")) {
                renderTrastornos = true;
            } else {

                renderTrastornos = false;
            }

            if (antecedente.getHpacenfediag() != null && 
                antecedente.getHpacenfediag().equals("S")) {
                renderEnfermedadDiag = true;
            } else {

                renderEnfermedadDiag = false;
            }

            if (antecedente.getHpacenfediag() != null && 
                antecedente.getHpacenfediag().equals("S")) {
                renderEnfermedadDiag = true;
            } else {

                renderEnfermedadDiag = false;
            }

            if (antecedente.getHpachabitsalud() != null && 
                antecedente.getHpachabitsalud().equals("S")) {
                renderHabitoSaludable = true;
            } else {

                renderHabitoSaludable = false;
            }

            if (antecedente.getHpacquitavida() != null && 
                antecedente.getHpacquitavida().equals("S")) {
                renderquitaVida = true;
            } else {

                renderquitaVida = false;
            }

            if (antecedente.getHpacsustapsico() != null && 
                antecedente.getHpacsustapsico().equals("S")) {
                rendersustanciaPsico = true;
            } else {

                rendersustanciaPsico = false;
            }

            if (antecedente.getHpacdificapren() != null && 
                antecedente.getHpacdificapren().equals("S")) {
                renderDificultadAprend = true;
            } else {

                renderDificultadAprend = false;
            }

            if (antecedente.getHpacsociapare() != null && 
                antecedente.getHpacsociapare().equals("S")) {
                renderSocializarPares = true;
            } else {

                renderSocializarPares = false;
            }
            if (antecedente.getHpacrutiesta() != null && 
                antecedente.getHpacrutiesta().equals("S")) {
                renderRutina = true;
            } else {

                renderRutina = false;
            }
            if (antecedente.getHpactemppred() != null && 
                antecedente.getHpactemppred().equals("S")) {
                renderTemperamento = true;
            } else {

                renderTemperamento = false;
            }
    
            if (antecedente.getHpacviolesexual() != null && 
                antecedente.getHpacviolesexual().equals("S")) {
                lstTipoViolenciaSelect.add("S");
            }
            if (antecedente.getHpacviolefisic() != null && 
                antecedente.getHpacviolefisic().equals("F")) {
                lstTipoViolenciaSelect.add("F");
            }
            if (antecedente.getHpacvioleecono() != null && 
                antecedente.getHpacvioleecono().equals("E")) {
                lstTipoViolenciaSelect.add("E");
            }
            if (antecedente.getHpacviolepsico() != null && 
                antecedente.getHpacviolepsico().equals("P")) {
                lstTipoViolenciaSelect.add("P");
            }
            if (null != usuario) {
                if (null != usuario.getHuslnumero()) {
                    edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                    if (edad <= 12) {
                        menor12edad = true;
                    } else {
                        menor12edad = false;

                    }
                }
            }
            
            
           
                          
           
           
           
                

        }


    }

    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------    

    public String guardarAntecedente() {

        navigationRule = "";

        if (numeroConsulta != null) {
        
        if(null ==antecedente.getId()){
            ChpsicoantecPK id = new ChpsicoantecPK();
            id.setHpactiposervi(tipoServicio);
            id.setHpalconsulta(numeroConsulta); 
            antecedente.setId(id);
        }
            
            antecedente.setHpacoperador(userName());
            antecedente.setHpadfecregistr(new Date());
        }
        
        if(lstTipoViolenciaSelect!= null && !lstTipoViolenciaSelect.isEmpty()){
             for(String violenSelect : lstTipoViolenciaSelect){
                 if(violenSelect.equals("S") && lstTipoViolenciaSelect.size()>1){
                     antecedente.setHpacviolesexual("S");
                     
                 }
                 if(violenSelect.equals("F") && lstTipoViolenciaSelect.size()>1){
                     antecedente.setHpacviolefisic("F");
                     
                 }
                 if(violenSelect.equals("E") && lstTipoViolenciaSelect.size()>1){
                     antecedente.setHpacvioleecono("E");
                     
                 }
                 if(violenSelect.equals("P") && lstTipoViolenciaSelect.size()>1){
                     antecedente.setHpacviolepsico("P");
                     
                 }
             }
         }
         
        try {

            this.serviceLocator.getClinicoService().saveAntecedentePsicologia(antecedente);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }

        return navigationRule;
    }


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Long numero;
        numero = null;
        Chpsicoantec antecedenteAux = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                antecedenteAux = 
                        this.getServiceLocator().getClinicoService().getAntecedentePsicologia(numero, 
                                                                                              TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (antecedenteAux != null) {
            return true;
        }

        return false;
    }

    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------


    /**
     * @param valueChangeEvent
     */
    public void setHpacpresedisca(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacpresedisca((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpactomamedi(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpactomamedi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpactrastmenta(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpactrastmenta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacenfediag(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacenfediag((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacvidasexac(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacvidasexac((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpacrelacsatis(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacrelacsatis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpachabitsalud(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpachabitsalud((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacquitavida(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacquitavida((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacsustapsico(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacsustapsico((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpacvicconfarm(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacvicconfarm((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacdificapren(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacdificapren((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpacsociapare(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacsociapare((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacrutiesta(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacrutiesta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpactemppred(ValueChangeEvent valueChangeEvent) {
        antecedente.setHpacrutiesta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeDiscapacidad() {
        if (antecedente != null && antecedente.getHpacpresedisca() != null && 
            antecedente.getHpacpresedisca().equals("S")) {
            renderDiscapacidad = true;
        } else {
            renderDiscapacidad = false;
        }
    }

    public void changeMedicamento() {
        if (antecedente != null && antecedente.getHpactomamedi() != null && 
            antecedente.getHpactomamedi().equals("S")) {
            renderMedicamentos = true;
        } else {
            renderMedicamentos = false;
        }
    }

    public void changeTrastornoMental() {
        if (antecedente != null && antecedente.getHpactrastmenta() != null && 
            antecedente.getHpactrastmenta().equals("S")) {
            renderTrastornos = true;
        } else {
            renderTrastornos = false;
        }
    }

    public void changeEnfermedadDiag() {
        if (antecedente != null && antecedente.getHpacenfediag() != null && 
            antecedente.getHpacenfediag().equals("S")) {
            renderEnfermedadDiag = true;
        } else {
            renderEnfermedadDiag = false;
        }
    }

    public void changHabitoSaludable() {
        if (antecedente != null && antecedente.getHpachabitsalud() != null && 
            antecedente.getHpachabitsalud().equals("S")) {
            renderHabitoSaludable = true;
        } else {
            renderHabitoSaludable = false;
        }
    }

    public void changeQuitaVida() {
        if (antecedente != null && antecedente.getHpacquitavida() != null && 
            antecedente.getHpacquitavida().equals("S")) {
            renderquitaVida = true;
        } else {
            renderquitaVida = false;
        }
    }

    public void changeSustanciaPsico() {
        if (antecedente != null && antecedente.getHpacsustapsico() != null && 
            antecedente.getHpacsustapsico().equals("S")) {
            rendersustanciaPsico = true;
        } else {
            rendersustanciaPsico = false;
        }
    }

    public void changeDificultadAprend() {
        if (antecedente != null && antecedente.getHpacdificapren() != null && 
            antecedente.getHpacdificapren().equals("S")) {
            renderDificultadAprend = true;
        } else {
            renderDificultadAprend = false;
        }
    }


    public void changeSocializaPares() {
        if (antecedente != null && antecedente.getHpacsociapare() != null && 
            antecedente.getHpacsociapare().equals("S")) {
            renderSocializarPares = true;
        } else {
            renderSocializarPares = false;
        }
    }

    public void changeRutina() {
        if (antecedente != null && antecedente.getHpacrutiesta() != null && 
            antecedente.getHpacrutiesta().equals("S")) {
            renderRutina = true;
        } else {
            renderRutina = false;
        }
    }

    public void changeTemperamento() {
        if (antecedente != null && antecedente.getHpacrutiesta() != null && 
            antecedente.getHpacrutiesta().equals("S")) {
            renderTemperamento = true;
        } else {
            renderTemperamento = false;
        }
    }

    //-----------------------------------------------------------------------
    //  Accesorios
    //-----------------------------------------------------------------------


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

    /**
     * @param antecedente
     */
    public void setAntecedente(Chpsicoantec antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * @return
     */
    public Chpsicoantec getAntecedente() {
        return antecedente;
    }


    /**
     * @param renderAlteracion
     */
    public void setRenderAlteracion(boolean renderAlteracion) {
        this.renderAlteracion = renderAlteracion;
    }

    /**
     * @return
     */
    public boolean isRenderAlteracion() {
        return renderAlteracion;
    }

    /**
     * @param renderMedicamentos
     */
    public void setRenderMedicamentos(boolean renderMedicamentos) {
        this.renderMedicamentos = renderMedicamentos;
    }

    /**
     * @return
     */
    public boolean isRenderMedicamentos() {
        return renderMedicamentos;
    }

    /**
     * @param renderHabitosSalud
     */
    public void setRenderHabitosSalud(boolean renderHabitosSalud) {
        this.renderHabitosSalud = renderHabitosSalud;
    }

    /**
     * @return
     */
    public boolean isRenderHabitosSalud() {
        return renderHabitosSalud;
    }

    /**
     * @param renderVinculo
     */
    public void setRenderVinculo(boolean renderVinculo) {
        this.renderVinculo = renderVinculo;
    }

    /**
     * @return
     */
    public boolean isRenderVinculo() {
        return renderVinculo;
    }

    /**
     * @param renderDificultades
     */
    public void setRenderDificultades(boolean renderDificultades) {
        this.renderDificultades = renderDificultades;
    }

    /**
     * @return
     */
    public boolean isRenderDificultades() {
        return renderDificultades;
    }

    /**
     * @param renderTrastornos
     */
    public void setRenderTrastornos(boolean renderTrastornos) {
        this.renderTrastornos = renderTrastornos;
    }

    /**
     * @return
     */
    public boolean isRenderTrastornos() {
        return renderTrastornos;
    }


    /**
     * @param lstOrientacion
     */
    public void setLstOrientacion(List lstOrientacion) {
        this.lstOrientacion = lstOrientacion;
    }

    /**
     * @return
     */
    public List getLstOrientacion() {
        if (lstOrientacion == null || lstOrientacion.isEmpty()) {
            lstOrientacion = new ArrayList();
            lstOrientacion.add(new SelectItem("", "Seleccione..."));
            lstOrientacion.add(new SelectItem("BI", "Bisexual"));
            lstOrientacion.add(new SelectItem("HO", "Homosexual "));
            lstOrientacion.add(new SelectItem("HE", "Heterosexual "));
            lstOrientacion.add(new SelectItem("OT", "Otro"));

        }
        return lstOrientacion;
    }

    /**
     * @param lstTipoVinculo
     */
    public void setLstTipoVinculo(List lstTipoVinculo) {
        this.lstTipoVinculo = lstTipoVinculo;
    }

    /**
     * @return
     */
    public List getLstTipoVinculo() {
        if (lstTipoVinculo == null || lstTipoVinculo.isEmpty()) {
            lstTipoVinculo = new ArrayList();
            lstTipoVinculo.add(new SelectItem("", "Seleccione"));
            lstTipoVinculo.add(new SelectItem("DE", "Dependiente"));
            lstTipoVinculo.add(new SelectItem("DM", "Democr�tica"));
            lstTipoVinculo.add(new SelectItem("EV", "Evitadora"));
            lstTipoVinculo.add(new SelectItem("DI", "Disfuncional"));
            lstTipoVinculo.add(new SelectItem("SI", "Sin Identificar"));
        }
        return lstTipoVinculo;
    }

    /**
     * @param renderOrientacion
     */
    public void setRenderOrientacion(boolean renderOrientacion) {
        this.renderOrientacion = renderOrientacion;
    }

    /**
     * @return
     */
    public boolean isRenderOrientacion() {
        return renderOrientacion;
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
     * @param lstTipoFamilia
     */
    public void setLstTipoFamilia(List lstTipoFamilia) {
        this.lstTipoFamilia = lstTipoFamilia;
    }

    /**
     * @return
     */
    public List getLstTipoFamilia() {
        if (lstTipoFamilia == null || lstTipoFamilia.isEmpty()) {
            lstTipoFamilia = new ArrayList();
            lstTipoFamilia.add(new SelectItem("", "Seleccione..."));
            lstTipoFamilia.add(new SelectItem("NU", "Nuclear"));
            lstTipoFamilia.add(new SelectItem("EX", "Extensa"));
            lstTipoFamilia.add(new SelectItem("MO", "Monoparental"));
            lstTipoFamilia.add(new SelectItem("NE", "Neofamiliar"));

        }
        return lstTipoFamilia;
    }

    /**
     * @param lstTipoVinculoFamiliar
     */
    public void setLstTipoVinculoFamiliar(List lstTipoVinculoFamiliar) {
        this.lstTipoVinculoFamiliar = lstTipoVinculoFamiliar;
    }

    /**
     * @return
     */
    public List getLstTipoVinculoFamiliar() {
        if (lstTipoVinculoFamiliar == null || 
            lstTipoVinculoFamiliar.isEmpty()) {
            lstTipoVinculoFamiliar = new ArrayList();
            lstTipoVinculoFamiliar.add(new SelectItem("", "Seleccione..."));
            lstTipoVinculoFamiliar.add(new SelectItem("RI", "R�gida"));
            lstTipoVinculoFamiliar.add(new SelectItem("SO", 
                                                      "Sobreprotectora"));
            lstTipoVinculoFamiliar.add(new SelectItem("AM", "Amalgamada"));
            lstTipoVinculoFamiliar.add(new SelectItem("CE", "Centrada"));
            lstTipoVinculoFamiliar.add(new SelectItem("EV", "Evitadora"));
            lstTipoVinculoFamiliar.add(new SelectItem("SE", 
                                                      "Seudodemocratica"));
            lstTipoVinculoFamiliar.add(new SelectItem("NA", "No aplica"));
        }
        return lstTipoVinculoFamiliar;
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


    public void setHapctrastpsiqu(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setRenderDiscapacidad(boolean renderDiscapacidad) {
        this.renderDiscapacidad = renderDiscapacidad;
    }

    public boolean isRenderDiscapacidad() {
        return renderDiscapacidad;
    }

    public void setRenderEnfermedadDiag(boolean renderEnfermedadDiag) {
        this.renderEnfermedadDiag = renderEnfermedadDiag;
    }

    public boolean isRenderEnfermedadDiag() {
        return renderEnfermedadDiag;
    }

    public void setRenderHabitoSaludable(boolean renderHabitoSaludable) {
        this.renderHabitoSaludable = renderHabitoSaludable;
    }

    public boolean isRenderHabitoSaludable() {
        return renderHabitoSaludable;
    }

    public void setRenderquitaVida(boolean renderquitaVida) {
        this.renderquitaVida = renderquitaVida;
    }

    public boolean isRenderquitaVida() {
        return renderquitaVida;
    }

    public void setRendersustanciaPsico(boolean rendersustanciaPsico) {
        this.rendersustanciaPsico = rendersustanciaPsico;
    }

    public boolean isRendersustanciaPsico() {
        return rendersustanciaPsico;
    }

    public void setRenderDificultadAprend(boolean renderDificultadAprend) {
        this.renderDificultadAprend = renderDificultadAprend;
    }

    public boolean isRenderDificultadAprend() {
        return renderDificultadAprend;
    }

    public void setRenderSocializarPares(boolean renderSocializarPares) {
        this.renderSocializarPares = renderSocializarPares;
    }

    public boolean isRenderSocializarPares() {
        return renderSocializarPares;
    }

    public void setRenderRutina(boolean renderRutina) {
        this.renderRutina = renderRutina;
    }

    public boolean isRenderRutina() {
        return renderRutina;
    }

    public void setRenderTemperamento(boolean renderTemperamento) {
        this.renderTemperamento = renderTemperamento;
    }

    public boolean isRenderTemperamento() {
        return renderTemperamento;
    }

    public void setLstTipoViolencia(List lstTipoViolencia) {
        this.lstTipoViolencia = lstTipoViolencia;
    }

    public List getLstTipoViolencia() {
        if (lstTipoViolencia != null || lstTipoViolencia.isEmpty()) {
            lstTipoViolencia = new ArrayList();
            lstTipoViolencia.add(new SelectItem("S", "Sexual"));
            lstTipoViolencia.add(new SelectItem("F", "F�sica"));
            lstTipoViolencia.add(new SelectItem("E", "Econ�mica"));
            lstTipoViolencia.add(new SelectItem("P", "Psicol�gica"));
        }
        return lstTipoViolencia;
    }

    public void setLstTipoViolenciaSelect(List<String> lstTipoViolenciaSelect) {
        this.lstTipoViolenciaSelect = lstTipoViolenciaSelect;
    }

    public List<String> getLstTipoViolenciaSelect() {
        return lstTipoViolenciaSelect;
    }

    public void setMenor12edad(boolean menor12edad) {
        this.menor12edad = menor12edad;
    }

    public boolean isMenor12edad() {
        return menor12edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }
}
