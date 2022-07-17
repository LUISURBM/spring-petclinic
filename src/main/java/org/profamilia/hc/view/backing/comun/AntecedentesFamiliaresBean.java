//=======================================================================
// ARCHIVO AntecedentePrenatalUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes los antacedentes de la Historia de Prenatal
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

import org.profamilia.hc.model.dto.Chantecfamil;
import org.profamilia.hc.model.dto.ChantecfamilPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  CLASE AntecedentePrenatalUsuarioBean
//=======================================================================

public class AntecedentesFamiliaresBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chantecfamil antecedente;

    /** Almacena la lista de opciones */
    private List lstOpciones;

    private boolean renderFamiliar;

    private boolean renderHTAfam;

    private boolean renderDiafam;

    private boolean renderPreEclfam;

    private boolean renderEclfam;


    private boolean renderCardiopatiafam;



    private boolean renderMetabolicoFamiliar;

    private boolean renderAutoinmuneFamiliar;

    private boolean renderInfecciosaFamiliar;

    private boolean renderCongenitaFamiliar;

    private boolean renderEpilepsiaFamiliar;

    private Integer tipoHistoria;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String nextAction;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;
    
    private boolean renderTrastornoMental;
    
    private boolean renderOtros;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AntecedentesFamiliaresBean() {
    }

    public void init() {
        inicializarAntecedentes();
        nextAction = "";

    }

    public void inicializarAntecedentes() {
        try {
            antecedente = 
                    this.serviceLocator.getClinicoService().getAntecedentesFamiliares(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (antecedente == null) {
            antecedente = new Chantecfamil();
        } else {
            changeAutoimnuneFamiliar();
            changeInfecciosaFamiliar();
            changeCongenitoFamiliar();
            changeEpilepsiaFamiliar();
            changeHtaFami();
            changeMetabolicas();
            changeDiabetesFamiliar();
            changePreeclfami();
            changeEclampsiafami();
            changeCardiopatiafami();
            changeTrastornoMentales();
            changeOtros();

        }
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


    /**
     * @param renderFamiliar
     */
    public void setRenderFamiliar(boolean renderFamiliar) {
        this.renderFamiliar = renderFamiliar;
    }

    /**
     * @return
     */
    public boolean isRenderFamiliar() {
        return renderFamiliar;
    }


    public void setAntecedente(Chantecfamil antecedente) {
        this.antecedente = antecedente;
    }

    public Chantecfamil getAntecedente() {
        return antecedente;
    }


    /**
     * @param renderHTAfam
     */
    public void setRenderHTAfam(boolean renderHTAfam) {
        this.renderHTAfam = renderHTAfam;
    }

    /**
     * @return
     */
    public boolean isRenderHTAfam() {
        return renderHTAfam;
    }


    /**
     * @param renderDiafam
     */
    public void setRenderDiafam(boolean renderDiafam) {
        this.renderDiafam = renderDiafam;
    }

    /**
     * @return
     */
    public boolean isRenderDiafam() {
        return renderDiafam;
    }


    /**
     * @param renderPreEclfam
     */
    public void setRenderPreEclfam(boolean renderPreEclfam) {
        this.renderPreEclfam = renderPreEclfam;
    }

    /**
     * @return
     */
    public boolean isRenderPreEclfam() {
        return renderPreEclfam;
    }


    /**
     * @param renderEclfam
     */
    public void setRenderEclfam(boolean renderEclfam) {
        this.renderEclfam = renderEclfam;
    }

    /**
     * @return
     */
    public boolean isRenderEclfam() {
        return renderEclfam;
    }

  
    /**
     * @param renderCardiopatiafam
     */
    public void setRenderCardiopatiafam(boolean renderCardiopatiafam) {
        this.renderCardiopatiafam = renderCardiopatiafam;
    }

    /**
     * @return
     */
    public boolean isRenderCardiopatiafam() {
        return renderCardiopatiafam;
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
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
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

    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    public void changeTodosSi() {
        inicializarPreguntas("S", true);

    }

    public void changeTodosNo() {
        inicializarPreguntas("N", false);

    }


    public void changeNinguno() {
        inicializarPreguntas(null, false);

    }

    public void changeAutoimnuneFamiliar() {
        if (antecedente.getHafcautoinmu() != null && 
            antecedente.getHafcautoinmu().equals("S")) {
            renderAutoinmuneFamiliar = true;

        } else {
            antecedente.setHafcdesauinf(null);
            renderAutoinmuneFamiliar = false;
        }
    }

    public void changeInfecciosaFamiliar() {
        if (antecedente.getHafcmetabinfe() != null && 
            antecedente.getHafcmetabinfe().equals("S")) {
            renderInfecciosaFamiliar = true;

        } else {
            antecedente.setHafcdesinfecf(null);
            renderInfecciosaFamiliar = false;
        }
    }

    public void changeCongenitoFamiliar() {
        if (antecedente.getHafccongefami() != null && 
            antecedente.getHafccongefami().equals("S")) {
            renderCongenitaFamiliar = true;

        } else {
            antecedente.setHafcdescongef(null);
            renderCongenitaFamiliar = false;
        }
    }

    public void changeEpilepsiaFamiliar() {
        if (antecedente.getHafcepilfami() != null && 
            antecedente.getHafcepilfami().equals("S")) {
            renderEpilepsiaFamiliar = true;

        } else {
            antecedente.setHafcdeseplif(null);
            renderEpilepsiaFamiliar = false;
        }
    }

    public void changeHtaFami() {

        if (antecedente.getHafchiperarter() != null && 
            antecedente.getHafchiperarter().equals("S")) {
            renderHTAfam = true;

        } else {
            antecedente.setHafcdeshtacrof(null);
            renderHTAfam = false;
        }
    }


    public void changeMetabolicas() {
        if (antecedente.getHafcmetabfami() != null && 
            antecedente.getHafcmetabfami().equals("S")) {
            renderMetabolicoFamiliar = true;

        } else {
            antecedente.setHafcdesmetabf(null);
            renderMetabolicoFamiliar = false;
        }
    }


    public void changeDiabetesFamiliar() {
        if (antecedente.getHafcdiabetfami() != null && 
            antecedente.getHafcdiabetfami().equals("S")) {
            renderDiafam = true;
        } else {
            antecedente.setHafcdesdiabetf(null);
            renderDiafam = false;
        }
    }


    public void changePreeclfami() {
        if (antecedente.getHafcpreeclfami() != null && 
            antecedente.getHafcpreeclfami().equals("S")) {
            renderPreEclfam = true;
        } else {
            antecedente.setHafcdespreeclf(null);
            renderPreEclfam = false;
        }
    }


    public void changeEclampsiafami() {
        if (antecedente.getHafceclampfami() != null && 
            antecedente.getHafceclampfami().equals("S")) {
            renderEclfam = true;
        } else {
            antecedente.setHafcdeseclampf(null);
            renderEclfam = false;
        }
    }

    public void changeCardiopatiafami() {
        if (antecedente.getHafccardiofami() != null && 
            antecedente.getHafccardiofami().equals("S")) {
            renderCardiopatiafam = true;
        } else {
            antecedente.setHafcdescardiof(null);
            renderCardiopatiafam = false;
        }
    }


    /**
     * @param opcion
     */
    public void inicializarPreguntas(String opcion, boolean renderOpcion) {

        if (antecedente != null) {

            renderFamiliar = renderOpcion;
            renderHTAfam = renderOpcion;
            renderDiafam = renderOpcion;
            renderPreEclfam = renderOpcion;
            renderEclfam = renderOpcion;
            renderMetabolicoFamiliar = renderOpcion;

            renderAutoinmuneFamiliar = renderOpcion;

            renderInfecciosaFamiliar = renderOpcion;

            renderCongenitaFamiliar = renderOpcion;

            renderEpilepsiaFamiliar = renderOpcion;
           

            renderCardiopatiafam = renderOpcion;
            
            renderTrastornoMental = renderOpcion;
            
            renderOtros = renderOpcion;
     
        
            antecedente.setHafcdiabetfami(opcion);
            antecedente.setHafcpreeclfami(opcion);
            antecedente.setHafceclampfami(opcion);
            antecedente.setHafccardiofami(opcion);
            antecedente.setHafchiperarter(opcion);
            antecedente.setHafcpreeclfami(opcion);
            antecedente.setHafceclampfami(opcion);
            antecedente.setHafccardiofami(opcion);
            antecedente.setHafcdiabetfami(opcion);
            antecedente.setHafcmetabfami(opcion);
            antecedente.setHafcautoinmu(opcion);
            antecedente.setHafcmetabinfe(opcion);
            antecedente.setHafccongefami(opcion);
            antecedente.setHafcepilfami(opcion);
            antecedente.setHafctrastmenta(opcion);
            antecedente.setHafcgestamulti(opcion);
            antecedente.setHafctuberculosis(opcion);
            antecedente.setHafcneoplasias(opcion);
            antecedente.setHafcotros(opcion);
         
        }

    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        Chantecfamil antecedenteAux = null;
        if (consulta != null) {
            try {
                antecedenteAux = 
                        this.serviceLocator.getClinicoService().getAntecedentesFamiliares(consulta);
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


    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------


    public String aceptar() {
        ChantecfamilPK id = new ChantecfamilPK();
        navigationRule = "";

        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHaflconsulta(new Long(consulta.getCconnumero()));
            id.setHafctiposervi(TIPO_CONSULTA);
            antecedente.setId(id);
        }


        if (antecedente.getHafchiperarter() != null && 
            antecedente.getHafchiperarter().equals("N")) {
            antecedente.setHafcdeshtacrof(null);

        }


        if (antecedente.getHafcdiabetfami() != null && 
            antecedente.getHafcdiabetfami().equals("N")) {
            antecedente.setHafcdesdiabetf(null);
        }


        if (antecedente.getHafcpreeclfami() != null && 
            antecedente.getHafcpreeclfami().equals("N")) {
            antecedente.setHafcdespreeclf(null);
        }


        if (antecedente.getHafceclampfami() != null && 
            antecedente.getHafceclampfami().equals("N")) {
            antecedente.setHafcdeseclampf(null);
        }


        if (antecedente.getHafccardiofami() != null && 
            antecedente.getHafccardiofami().equals("N")) {
            antecedente.setHafcdescardiof(null);
        }
        
        if (antecedente.getHafctrastmenta() != null && 
            antecedente.getHafctrastmenta().equals("N")) {
            antecedente.setHafcdestramen(null);
        }
        
        if (antecedente.getHafcotros() != null && 
            antecedente.getHafcotros().equals("N")) {
            antecedente.setHafcdescrotros(null);
        }


        antecedente.setHafdfecregistr(new Date());
        antecedente.setHafcoperador(userName());

        try {
            serviceLocator.getClinicoService().saveAntecedentesFamiliar(antecedente);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            navigationRule = nextAction;
            FacesUtils.resetManagedBean(menuBean);
        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = null;
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
        return navigationRule;
    }


    /**
     * @param valueChangeEvent
     */
    public void setHafchiperarter(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafchiperarter((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafcmetabfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcmetabfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafcautoinmu(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcautoinmu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafcmetabinfe(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcmetabinfe((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafccongefami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafccongefami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafcepilfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcepilfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafcpreeclfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcpreeclfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHafceclampfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafceclampfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafccardiofami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafccardiofami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHafcdiabetfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcdiabetfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setRenderMetabolicoFamiliar(boolean renderMetabolicoFamiliar) {
        this.renderMetabolicoFamiliar = renderMetabolicoFamiliar;
    }

    public boolean isRenderMetabolicoFamiliar() {
        return renderMetabolicoFamiliar;
    }

    public void setRenderAutoinmuneFamiliar(boolean renderAutoinmuneFamiliar) {
        this.renderAutoinmuneFamiliar = renderAutoinmuneFamiliar;
    }

    public boolean isRenderAutoinmuneFamiliar() {
        return renderAutoinmuneFamiliar;
    }

    public void setRenderInfecciosaFamiliar(boolean renderInfecciosaFamiliar) {
        this.renderInfecciosaFamiliar = renderInfecciosaFamiliar;
    }

    public boolean isRenderInfecciosaFamiliar() {
        return renderInfecciosaFamiliar;
    }

    public void setRenderCongenitaFamiliar(boolean renderCongenitaFamiliar) {
        this.renderCongenitaFamiliar = renderCongenitaFamiliar;
    }

    public boolean isRenderCongenitaFamiliar() {
        return renderCongenitaFamiliar;
    }

    public void setRenderEpilepsiaFamiliar(boolean renderEpilepsiaFamiliar) {
        this.renderEpilepsiaFamiliar = renderEpilepsiaFamiliar;
    }

    public boolean isRenderEpilepsiaFamiliar() {
        return renderEpilepsiaFamiliar;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHafctrastmenta(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafctrastmenta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeTrastornoMentales() {
        if (antecedente.getHafctrastmenta() != null && 
            antecedente.getHafctrastmenta().equals("S")) {
            renderTrastornoMental = true;

        } else {
            antecedente.setHafcdestramen(null);
            renderTrastornoMental = false;
        }
    }

    public void setRenderTrastornoMental(boolean renderTrastornoMental) {
        this.renderTrastornoMental = renderTrastornoMental;
    }

    public boolean isRenderTrastornoMental() {
        return renderTrastornoMental;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHafcgestamulti(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcgestamulti((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHafctuberculosis(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafctuberculosis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHafcneoplasias(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcneoplasias((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setHafcotros(ValueChangeEvent valueChangeEvent) {
        antecedente.setHafcotros((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeOtros() {
        if (antecedente.getHafcotros() != null && 
            antecedente.getHafcotros().equals("S")) {
            renderOtros = true;

        } else {
            antecedente.setHafcdescrotros(null);
            renderOtros = false;
        }
    }


    public void setRenderOtros(boolean renderOtros) {
        this.renderOtros = renderOtros;
    }

    public boolean isRenderOtros() {
        return renderOtros;
    }
}
