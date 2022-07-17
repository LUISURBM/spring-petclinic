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

import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.ChantecfarmaPK;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.ChantecfarmaPK;
import org.profamilia.hc.model.dto.Chantecpatol;
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
public class AntecedentesFarmacologicosTuberculinaBean extends BaseBean {


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /**Almacena los tipos de antecedentes  */
    private Chantecfarma antecedfarma;

    /** Almacena el codigo del tipo de antecedente */
    private String codigoAntecedente;

    /** Almacena el antecedente encontrado */
    private String antecedente;

    /** Almacena los antecedentes registrados  */

    List<Chantecfarma> antecedfarmacologicosTuberculina;

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

    private Boolean renderCualaines;

    private Boolean renderCualagr;

    private Boolean renderCualaco;

    private Boolean renderCualmedi;

    private Boolean renderCualva;


    public AntecedentesFarmacologicosTuberculinaBean() {

    }


    public void init() {
        inicializarAntecedentes();
        nextAction = "";


    }

    public void inicializarAntecedentes() {
        try {
            // validarCamposRequeridos();

            renderCualaines = false;
            renderCualagr = false;
            renderCualaco = false;
            renderCualmedi = false;
            renderCualva = false;
            if (numeroConsulta != null) {
                antecedfarma = 
                        this.serviceLocator.getClinicoService().getAntecedentesFarmacologicosTuberculina(numeroConsulta);
            }

            if (null == antecedfarma) {
                antecedfarma = new Chantecfarma();
            } else {
                if (antecedfarma != null && 
                    antecedfarma.getHafcaines().equals("S")) {
                    renderCualaines = true;
                } else {
                    antecedfarma.setHafcainecual(null);
                    antecedfarma.setHafcainefrecu(null);
                    renderCualaines = false;
                }

                if (antecedfarma != null && 
                    antecedfarma.getHafcantiagre().equals("S")) {
                    renderCualagr = true;
                } else {
                    antecedfarma.setHafcaagrecual(null);
                    antecedfarma.setHafcaagrefrecu(null);
                    renderCualagr = false;
                }

                if (antecedfarma != null && 
                    antecedfarma.getHafcanticoag().equals("S")) {
                    renderCualaco = true;
                } else {

                    antecedfarma.setHafcacoagcual(null);
                    antecedfarma.setHafcacoagfrec(null);
                    renderCualaco = false;
                }

                if (antecedfarma != null && 
                    antecedfarma.getHafcaplivacu().equals("S")) {
                    renderCualmedi = true;
                } else {
                    renderCualva = false;
                    antecedfarma.setHafcapvacucual(null);
                    antecedfarma.setHaflapvacudias(null);
                }

                if (antecedfarma != null && 
                    antecedfarma.getHafcaines().equals("S")) {
                    renderCualaines = true;
                } else {
                    antecedfarma.setHaflapvacudias(null);
                    renderCualmedi = false;
                }
            }

            renderedsCuestionario();

        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public boolean validarCamposRequeridos() throws ModelException {
        String url = 
            "body:formAntecedentesGenerales:panelTabAntecedentesFarmacologicosTuberculina:";
        boolean wexito = true;
        if (antecedfarma != null) {
            if (antecedfarma.getHafcaines() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesFarmacologicoso").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedfarma.getHafcaines().equals("S")) {
                if (antecedfarma.getHafcainecual() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAinesCual").toString(), 
                                               "El campo es obligatorio");
                }
                if (antecedfarma.getHafcainefrecu() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAinesfrec").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (antecedfarma.getHafcantiagre() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesFarmacologicosoaagr").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedfarma.getHafcantiagre().equals("S")) {
                if (antecedfarma.getHafcaagrecual() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAntiagCual").toString(), 
                                               "El campo es obligatorio");
                }
                if (antecedfarma.getHafcaagrefrecu() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAntiagfrec").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (antecedfarma.getHafcanticoag() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesFarmacologicosac").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedfarma.getHafcanticoag().equals("S")) {
                if (antecedfarma.getHafcacoagcual() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAcoCual").toString(), 
                                               "El campo es obligatorio");
                }
                if (antecedfarma.getHafcacoagfrec() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAcofrec").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (antecedfarma.getHafcaplimedic() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesFarmacologicosoapl").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedfarma.getHafcaplimedic().equals("S")) {
                if (antecedfarma.getHafcaplmedcual() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAplCual").toString(), 
                                               "El campo es obligatorio");
                }
            }
            if (antecedfarma.getHafcaplivacu() == null) {
                wexito = false;
                FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("mnuAntecedentesFarmacologicosav").toString(), 
                                           "El campo es obligatorio");
            } else if (antecedfarma.getHafcaplivacu().equals("S")) {
                if (antecedfarma.getHafcapvacucual() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAvCual").toString(), 
                                               "El campo es obligatorio");
                }
                if (antecedfarma.getHaflapvacudias() == null) {
                    wexito = false;
                    FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itAvDias").toString(), 
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


    public String aceptar() {
        navigationRule = "";

        try {
            if (validarCamposRequeridos()) {
                ChantecfarmaPK chantecefarmaId = new ChantecfarmaPK();
                chantecefarmaId.setHaflconsulta(numeroConsulta);
                chantecefarmaId.setHafctiposervi(tipoServicio);
                antecedfarma.setComp_id(chantecefarmaId);
                antecedfarma.setHafdfecharegis(new Date());
                antecedfarma.setHafcoperador(this.getUsuarioSystem().getCurcusuari());


                this.getServiceLocator().getClinicoService().saveAntecedentesFarmacologicosTuberculina(antecedfarma);

                FacesUtils.addInfoMessage(MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                FacesUtils.resetManagedBean("CierreTuberculinaBean");
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


    public void setantecedfarmacologicosTuberculina(List<Chantecfarma> antecedfarmacologicosTuberculina) {
        this.antecedfarmacologicosTuberculina = 
                antecedfarmacologicosTuberculina;
    }

    public List<Chantecfarma> getantecedfarmacologicosTuberculina() {
        return antecedfarmacologicosTuberculina;
    }


    /**
     * @param valueChangeEvent
     */
    public void setHafcaines(ValueChangeEvent valueChangeEvent) {
        antecedfarma.setHafcaines((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHafcantiagre(ValueChangeEvent valueChangeEvent) {
        antecedfarma.setHafcantiagre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHafcanticoag(ValueChangeEvent valueChangeEvent) {
        antecedfarma.setHafcanticoag((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setHafcaplimedic(ValueChangeEvent valueChangeEvent) {
        antecedfarma.setHafcaplimedic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHhafcaplivacu(ValueChangeEvent valueChangeEvent) {
        antecedfarma.setHafcaplivacu((String)valueChangeEvent.getNewValue());
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

    public void setrenderCualaines(Boolean renderCualaines) {
        this.renderCualaines = renderCualaines;
    }

    public Boolean getrenderCualaines() {
        return renderCualaines;
    }


    public void renderedsCuestionario() {
        changeaines();
        changeafcantiagre();
        changeanticoag();
        changeafcaplimedic();
        changehafcaplivacu();
    }

    public void changeaines() {
        if (null != antecedfarma) {
            if (antecedfarma != null && antecedfarma.getHafcaines() != null && 
                antecedfarma.getHafcaines().equals("S")) {
                renderCualaines = true;
            } else {
                renderCualaines = false;

            }
        }
    }


    public void changeafcantiagre() {
        if (null != antecedfarma) {
            if (antecedfarma != null && 
                antecedfarma.getHafcantiagre() != null && 
                antecedfarma.getHafcantiagre().equals("S")) {
                renderCualagr = true;
            } else {
                renderCualagr = false;

            }
        }
    }

    public void changeanticoag() {
        if (null != antecedfarma) {
            if (antecedfarma != null && 
                antecedfarma.getHafcanticoag() != null && 
                antecedfarma.getHafcanticoag().equals("S")) {
                renderCualaco = true;
            } else {
                renderCualaco = false;
            }
        }
    }

    public void changeafcaplimedic() {
        if (null != antecedfarma) {
            if (antecedfarma != null && 
                antecedfarma.getHafcaplimedic() != null && 
                antecedfarma.getHafcaplimedic().equals("S")) {
                renderCualmedi = true;
            } else {
                renderCualmedi = false;
            }
        }
    }


    public void changehafcaplivacu() {
        if (null != antecedfarma) {
            if (antecedfarma != null && 
                antecedfarma.getHafcaplivacu() != null && 
                antecedfarma.getHafcaplivacu().equals("S")) {
                renderCualva = true;
            } else {
                renderCualva = false;

            }
        }
    }


    public void setAntecedfarmacologicosTuberculina(List<Chantecfarma> antecedfarmacologicosTuberculina) {
        this.antecedfarmacologicosTuberculina = 
                antecedfarmacologicosTuberculina;
    }

    public List<Chantecfarma> getAntecedfarmacologicosTuberculina() {
        return antecedfarmacologicosTuberculina;
    }

    public void setAntecedfarma(Chantecfarma antecedfarma) {
        this.antecedfarma = antecedfarma;
    }

    public Chantecfarma getAntecedfarma() {
        return antecedfarma;
    }

    public void setRenderCualaines(Boolean renderCualaines) {
        this.renderCualaines = renderCualaines;
    }

    public Boolean getRenderCualaines() {
        return renderCualaines;
    }

    public void setRenderCualagr(Boolean renderCualagr) {
        this.renderCualagr = renderCualagr;
    }

    public Boolean getRenderCualagr() {
        return renderCualagr;
    }

    public void setRenderCualaco(Boolean renderCualaco) {
        this.renderCualaco = renderCualaco;
    }

    public Boolean getRenderCualaco() {
        return renderCualaco;
    }

    public void setRenderCualmedi(Boolean renderCualmedi) {
        this.renderCualmedi = renderCualmedi;
    }

    public Boolean getRenderCualmedi() {
        return renderCualmedi;
    }

    public void setRenderCualva(Boolean renderCualva) {
        this.renderCualva = renderCualva;
    }

    public Boolean getRenderCualva() {
        return renderCualva;
    }

    public boolean esValido() {
        boolean esValido = false;
        Chantecfarma antecefarmaTuberculinaAux = null;
        if (numeroConsulta != null) {

            try {
                antecefarmaTuberculinaAux = 
                        this.serviceLocator.getClinicoService().getAntecedentesFarmacologicosTuberculina(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (antecefarmaTuberculinaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }
}
