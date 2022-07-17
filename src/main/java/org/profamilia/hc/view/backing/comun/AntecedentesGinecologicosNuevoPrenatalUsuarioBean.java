//=======================================================================
// ARCHIVO AntecedenteGinecologicoBean.java
// FECHA CREACI�N: 19/08/2020
// AUTOR: Diana Rodriguez
// Descripcion: permite registrar antecedentes ginecologicos del Nuevo prenatal
// para un Usuario de una Histroia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chanteginecopre;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE AntecedenteGinecologicoBean
//=======================================================================
public class AntecedentesGinecologicosNuevoPrenatalUsuarioBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chanteginecopre antecedente;

    /** Almacena el tipo de ciclo  */
    private String tipoCiclo;

    /** Almacena true si el ciclo es regular */
    private boolean cicloiregular;

    /** Almacena la lista de los tipos de ciclos regular e irregular */
    private List<SelectItem> lstTipoCiclo;

    /** Almacena la lista de las fechas de ultima citologia */
    private List<SelectItem> lstUltimaCitologia;

    /** Almacena true si los campos del caso de uso son obligatorios para el tipo de historia*/
    private boolean camposRequeridos;


    /** Almacena true si los datos ingresados son correctos*/
    private boolean wexito;

    private boolean tieneCiclo;

    private boolean renderMenarquia;

    private Integer tipoHistoria;

    private boolean mostrarReporte;

    private List lstMetodo;

    private boolean mostrarMetodo;

    private boolean mostrarInyectable;

    private boolean mostrarPildoras;

    private boolean mostrarPildorasSi;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private Chconsulta consulta;

    /**  */
    private String menuBean;

    private boolean renderCiclos;

    private String nextAction;

    private UIInput itFechaRegla;

    private UIInput itPenFechaRegla;

    private UIInput mnuResultado;

    private UIInput mnuUltima;

    private Long numeroConsulta;

    private boolean ocultarmensaje;

    private Date fur;

    private Date fup;

    private boolean renderResultado;

    private boolean renderOtroResultado;

    private List lstResultado;

    private List lstOpciones;


    /** Almacena si es consulta de Fertilidad */
    private boolean esFertilidad = false;

    /** Almacena el No aplica fecha  */
    private String noAplica;

    private boolean mostrarFechaFUP;

    private boolean mostrarSuspencionAnticonceptivo;

    private boolean mostrarFlujoVaginal = false;

    private boolean mostrarTratamientoInfertilidad = false;
    
    private boolean renderColposcopia = false; 


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AntecedentesGinecologicosNuevoPrenatalUsuarioBean() {
    }

    public void init() {
        camposRequeridos = true;
        mostrarPildoras = false;
        mostrarPildorasSi = false;
        mostrarInyectable = false;
        renderColposcopia = false; 
        mostrarSuspencionAnticonceptivo = false;
        mostrarFlujoVaginal = false;
        mostrarTratamientoInfertilidad = false;
        renderCiclos = true;
        inicializarAntecedentesGinecologicos();

        nextAction = "";
        mostrarFechaFUP = false;
    }

    public void inicializarAntecedentesGinecologicos() {
        try {
            if (numeroConsulta != null) {
                antecedente = 
                        this.getServiceLocator().getClinicoService().getAntecedentesGinecologicospre(numeroConsulta);
                consulta = 
                        this.getServiceLocator().getClinicoService().getConsultaActual(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (antecedente == null) {
            antecedente = new Chanteginecopre();
            Chanteginecopre antecedenteAux = null;

            try {
                if (usuario != null) {
                    antecedenteAux = 
                            this.serviceLocator.getClinicoService().getUltimoAntecedentesGinecologicospre(usuario.getHuslnumero());
                }

                if (antecedenteAux != null) {
                    if (antecedente != null && 
                        antecedenteAux.getHagnmenarquia() != null) {
                        antecedente.setHagnmenarquia(antecedenteAux.getHagnmenarquia());

                    }
                    if (antecedente != null && 
                        antecedenteAux.getHagcultcitolo() != null) {
                        antecedente.setHagcultcitolo(antecedenteAux.getHagcultcitolo());
                        if (antecedenteAux.getHagcresulcitol() != null) {
                            antecedente.setHagcresulcitol(antecedenteAux.getHagcresulcitol());
                        }

                        if (antecedenteAux.getHagcotroresul() != null) {
                            antecedente.setHagcotroresul(antecedenteAux.getHagcotroresul());
                        }

                        renderResultado = true;
                        if (antecedente.getHagcresulcitol() != null && 
                            antecedente.getHagcresulcitol().equals("2.2")) {
                            renderOtroResultado = true;
                        }
                    }
                }

                if (fup != null) {
                    antecedente.setHagdfpr(fup);
                }

                if (fur != null) {
                    antecedente.setHagdfur(fur);
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }


        } else {
            chanheColposcopia();
            tipoCiclo = antecedente.getHagetipciclo();

            if (tipoCiclo != null && tipoCiclo.equals("I")) {
                cicloiregular = true;
                tieneCiclo = true;
            } else {
                cicloiregular = false;
            }

            if (tipoCiclo != null && !tipoCiclo.equals("N")) {
                tieneCiclo = true;
            }

            if (tipoCiclo != null && tipoCiclo.equals("A")) {
                tieneCiclo = false;
                renderMenarquia = true;
            }

            if (antecedente.getHagcultcitolo() != null && 
                !antecedente.getHagcultcitolo().equals("NO")) {
                renderResultado = true;
                if (antecedente.getHagcresulcitol() != null && 
                    antecedente.getHagcresulcitol().equals("2.2")) {
                    renderOtroResultado = true;
                }
            }

            if (antecedente.getHagcmetodoplan() != null && 
                antecedente.getHagcmetodoplan().equals("0")) {
                mostrarMetodo = true;
                mostrarSuspencionAnticonceptivo = true;
            }

            if (antecedente.getHagcmetodoplan() != null && 
                antecedente.getHagcmetodoplan().equals("890201.1")) {
                mostrarInyectable = true;
                mostrarSuspencionAnticonceptivo = true;
            }

            if (antecedente.getHagcmetodoplan() != null && 
                antecedente.getHagcmetodoplan().equals("890201.4")) {
                mostrarPildoras = true;
                mostrarSuspencionAnticonceptivo = true;
                if (antecedente.getHagcpildouso() != null && 
                    antecedente.getHagcpildouso().equals("S")) {
                    mostrarPildorasSi = true;
                } else {
                    mostrarPildorasSi = false;
                }
            }

            if (antecedente.getHagcnoaplica() != null) {
                if (antecedente.getHagcnoaplica().equals("S")) {
                    mostrarFechaFUP = true;
                } else {
                    mostrarFechaFUP = false;
                }
            }

            if (antecedente.getHagcmetodoplan() != null && 
                antecedente.getHagcmetodoplan().equals("9999")) {
                mostrarInyectable = false;
                mostrarSuspencionAnticonceptivo = false;
            } else {
                mostrarSuspencionAnticonceptivo = true;
            }


            if (antecedente != null && antecedente.getHagcfluvag() != null && 
                antecedente.getHagcfluvag().equals("S")) {
                mostrarFlujoVaginal = true;
            } else {
                mostrarFlujoVaginal = false;
                antecedente.setHagcobsfluvag(null);
            }

        }


        if (antecedente != null && antecedente.getHagctratainfert() != null && 
            antecedente.getHagctratainfert().equals("S")) {
            mostrarTratamientoInfertilidad = true;
        } else {
            mostrarTratamientoInfertilidad = false;
            antecedente.setHagcobstratainfert(null);
        }
    }


    /**
     * @param tipoCiclo
     */
    public void setTipoCiclo(String tipoCiclo) {
        this.tipoCiclo = tipoCiclo;
    }

    /**
     * @param valueChangeEvent
     */
    public void setTipoCiclo(ValueChangeEvent valueChangeEvent) {
        setTipoCiclo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHagcnoaplica(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcnoaplica((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHagcresulcitol(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcresulcitol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setHagcultcitolo(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcultcitolo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHagcmetodoplan(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcmetodoplan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHagcpildouso(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcpildouso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHagctratainfert(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagctratainfert((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHagcfluvag(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagcfluvag((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public String getTipoCiclo() {
        return tipoCiclo;
    }


    /**
     * @param antecedente
     */
    public void setAntecedente(Chanteginecopre antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * @return
     */
    public Chanteginecopre getAntecedente() {
        return antecedente;
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
                    //                                                    lstMetodosAux.get(i).getCdicvalor() + 
                    //                                                    "  " + 
                    lstResultado.add(new SelectItem((lstMetodosAux.get(i).getCdicvalor()), 
                                                    lstMetodosAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstResultado;
    }


    public void changeResultado() {
        if (antecedente.getHagcresulcitol() != null && 
            antecedente.getHagcresulcitol().equals("2.2")) {
            renderOtroResultado = true;
        } else {
            renderOtroResultado = false;
            antecedente.setHagcotroresul(null);
        }
    }


    /**
     * @param itFechaRegla
     */
    public void setItFechaRegla(UIInput itFechaRegla) {
        this.itFechaRegla = itFechaRegla;
    }

    /**
     * @return
     */
    public UIInput getItFechaRegla() {
        return itFechaRegla;
    }

    /**
     * @param itPenFechaRegla
     */
    public void setItPenFechaRegla(UIInput itPenFechaRegla) {
        this.itPenFechaRegla = itPenFechaRegla;
    }

    /**
     * @return
     */
    public UIInput getItPenFechaRegla() {
        return itPenFechaRegla;
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
     * @param consulta
     */
    public void setConsulta(Chconsulta consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Chconsulta getConsulta() {
        return consulta;
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

    /**
     * @param lstUltimaCitologia
     */
    public void setLstUltimaCitologia(List<SelectItem> lstUltimaCitologia) {
        this.lstUltimaCitologia = lstUltimaCitologia;
    }

    public List<SelectItem> getLstUltimaCitologia() {
        if (lstUltimaCitologia == null || lstUltimaCitologia.isEmpty()) {
            lstUltimaCitologia = new ArrayList<SelectItem>();
            lstUltimaCitologia.add(new SelectItem("", 
                                                  "Seleccione una opci�n "));
            lstUltimaCitologia.add(new SelectItem("NO", "Nunca"));
            lstUltimaCitologia.add(new SelectItem("-1", 
                                                  "Hace menos de un ano"));
            lstUltimaCitologia.add(new SelectItem("+1", "Hace mas de un ano"));
            lstUltimaCitologia.add(new SelectItem("NR", "No recuerda"));
        }
        return lstUltimaCitologia;
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
     * @param mostrarReporte
     */
    public void setMostrarReporte(boolean mostrarReporte) {
        this.mostrarReporte = mostrarReporte;
    }

    /**
     * @return
     */
    public boolean isMostrarReporte() {
        return mostrarReporte;
    }

    /**
     * @param mostrarMetodo
     */
    public void setMostrarMetodo(boolean mostrarMetodo) {
        this.mostrarMetodo = mostrarMetodo;
    }

    /**
     * @return
     */
    public boolean isMostrarMetodo() {
        return mostrarMetodo;
    }

    /**
     * @param ocultarmensaje
     */
    public void setOcultarmensaje(boolean ocultarmensaje) {
        this.ocultarmensaje = ocultarmensaje;
    }

    /**
     * @return
     */
    public boolean isOcultarmensaje() {
        return ocultarmensaje;
    }

    /**
     * @param renderMenarquia
     */
    public void setRenderMenarquia(boolean renderMenarquia) {
        this.renderMenarquia = renderMenarquia;
    }

    /**
     * @return
     */
    public boolean isRenderMenarquia() {
        return renderMenarquia;
    }


    public void changeTipo() {
        if (tipoCiclo != null) {
            if (tipoCiclo.equals("N")) {
                tieneCiclo = false;
                renderMenarquia = false;
                cicloiregular = false;
            }
            if (tipoCiclo.equals("A")) {
                tieneCiclo = false;
                renderMenarquia = true;
                cicloiregular = false;
            }

            if (tipoCiclo.equals("R")) {
                tieneCiclo = true;
                renderMenarquia = true;
                cicloiregular = false;
            }

            if (tipoCiclo.equals("I")) {
                cicloiregular = true;
                renderMenarquia = true;
                tieneCiclo = true;

            }
        }
    }

    public void changeFecha() {
        if (antecedente.getHagcnoaplica() != null) {
            if (antecedente.getHagcnoaplica().equals("S")) {
                mostrarFechaFUP = true;
            } else {
                mostrarFechaFUP = false;
            }
        }
    }


    /**
     * @param camposRequeridos
     */
    public void setCamposRequeridos(boolean camposRequeridos) {
        this.camposRequeridos = camposRequeridos;
    }

    /**
     * @return
     */
    public boolean isCamposRequeridos() {
        return camposRequeridos;
    }


    /**
     * @param cicloiregular
     */
    public void setCicloiregular(boolean cicloiregular) {
        this.cicloiregular = cicloiregular;
    }

    /**
     * @return
     */
    public boolean isCicloiregular() {
        return cicloiregular;
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
     * @param tieneCiclo
     */
    public void setTieneCiclo(boolean tieneCiclo) {
        this.tieneCiclo = tieneCiclo;
    }

    /**
     * @return
     */
    public boolean isTieneCiclo() {
        return tieneCiclo;
    }


    /**
     * @param fur
     */
    public void setFur(Date fur) {
        this.fur = fur;
    }

    /**
     * @return
     */
    public Date getFur() {
        return fur;
    }

    /**
     * @param fup
     */
    public void setFup(Date fup) {
        this.fup = fup;
    }

    /**
     * @return
     */
    public Date getFup() {
        return fup;
    }

    /**
     * @param renderOtroResultado
     */
    public void setRenderOtroResultado(boolean renderOtroResultado) {
        this.renderOtroResultado = renderOtroResultado;
    }

    /**
     * @return
     */
    public boolean isRenderOtroResultado() {
        return renderOtroResultado;
    }

    /**
     * @param mnuResultado
     */
    public void setMnuResultado(UIInput mnuResultado) {
        this.mnuResultado = mnuResultado;
    }

    /**
     * @return
     */
    public UIInput getMnuResultado() {
        return mnuResultado;
    }

    /**
     * @param mnuUltima
     */
    public void setMnuUltima(UIInput mnuUltima) {
        this.mnuUltima = mnuUltima;
    }

    /**
     * @return
     */
    public UIInput getMnuUltima() {
        return mnuUltima;
    }

    /**
     * @param renderCiclos
     */
    public void setRenderCiclos(boolean renderCiclos) {
        this.renderCiclos = renderCiclos;
    }

    /**
     * @return
     */
    public boolean isRenderCiclos() {
        return renderCiclos;
    }

    /**
     * @param renderResultado
     */
    public void setRenderResultado(boolean renderResultado) {
        this.renderResultado = renderResultado;
    }

    /**
     * @return
     */
    public boolean isRenderResultado() {
        return renderResultado;
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

    public void setEsFertilidad(boolean esFertilidad) {
        this.esFertilidad = esFertilidad;
    }

    public boolean isEsFertilidad() {
        return esFertilidad;
    }


    public void setNoAplica(String noAplica) {
        this.noAplica = noAplica;
    }

    public String getNoAplica() {
        return noAplica;
    }

    public void setMostrarFechaFUP(boolean mostrarFechaFUP) {
        this.mostrarFechaFUP = mostrarFechaFUP;
    }

    public boolean isMostrarFechaFUP() {
        return mostrarFechaFUP;
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


    public boolean esValido() {
        Chanteginecopre antecedenteAux = null;
        boolean esValido = false;
        boolean esValidoObstetricos = true;
        if (numeroConsulta != null) {
            try {
                antecedenteAux = 
                        this.getServiceLocator().getClinicoService().getAntecedentesGinecologicospre(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (antecedenteAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        if (!esValidoObstetricos) {
            esValido = false;
        }
        return esValido;
    }

    public void ChangePildoras() {
        if (antecedente != null && antecedente.getHagcpildouso() != null && 
            antecedente.getHagcpildouso().equals("S")) {
            mostrarPildorasSi = true;
        } else {
            mostrarPildorasSi = false;
            antecedente.setHagcpildoobser(null);
        }
    }

    public void ChangeFlujoVaginal() {
        if (antecedente == null) {
            mostrarFlujoVaginal = false;
            antecedente.setHagcfluvag(null);
            antecedente.setHagcobsfluvag(null);
        } else {
            if (antecedente != null && antecedente.getHagcfluvag() != null && 
                antecedente.getHagcfluvag().equals("S")) {
                mostrarFlujoVaginal = true;
            } else {
                mostrarFlujoVaginal = false;
                antecedente.setHagcfluvag(null);
                antecedente.setHagcobsfluvag(null);
            }
        }
    }

    public void ChangeTratmientoFertilidad() {
        if (antecedente == null) {
            mostrarTratamientoInfertilidad = false;
            antecedente.setHagctratainfert(null);
            antecedente.setHagcobstratainfert(null);
        } else {
            if (antecedente != null && 
                antecedente.getHagctratainfert() != null && 
                antecedente.getHagctratainfert().equals("S")) {
                mostrarTratamientoInfertilidad = true;
            } else {
                mostrarTratamientoInfertilidad = false;
                antecedente.setHagctratainfert(null);
                antecedente.setHagcobstratainfert(null);
            }
        }
    }


    public void ChangeMetodo() {
        if (antecedente == null) {
            mostrarMetodo = false;
            antecedente.setHagcotrometodo(null);
            mostrarInyectable = false;
            mostrarSuspencionAnticonceptivo = true;
            mostrarPildoras = false;
            mostrarPildorasSi = false;
            antecedente.setHagcpildoobser(null);
            antecedente.setHagcpildouso(null);

        } else {
            if (antecedente != null && 
                antecedente.getHagcmetodoplan().equals("0")) {
                mostrarMetodo = true;
                mostrarInyectable = false;
                mostrarPildoras = false;
                mostrarPildorasSi = false;
                antecedente.setHagcpildoobser(null);
                antecedente.setHagcpildouso(null);
                mostrarSuspencionAnticonceptivo=true;
            } else if (antecedente != null && 
                       antecedente.getHagcmetodoplan().equals("890201.1")) {
                mostrarMetodo = false;
                antecedente.setHagcotrometodo(null);
                mostrarInyectable = true;
                mostrarPildoras = false;
                mostrarPildorasSi = false;
                antecedente.setHagcpildoobser(null);
                antecedente.setHagcpildouso(null);
                mostrarSuspencionAnticonceptivo = true;
            } else if (antecedente != null && 
                       antecedente.getHagcmetodoplan().equals("890201.2")) {
                mostrarMetodo = false;
                antecedente.setHagcotrometodo(null);
                mostrarInyectable = true;
                mostrarPildoras = false;
                mostrarPildorasSi = false;
                antecedente.setHagcpildoobser(null);
                antecedente.setHagcpildouso(null);
                mostrarSuspencionAnticonceptivo = true;
            } else if (antecedente != null && 
                       antecedente.getHagcmetodoplan().equals("890201.4")) {
                mostrarMetodo = false;
                antecedente.setHagcotrometodo(null);
                mostrarInyectable = false;
                mostrarPildoras = true;
                if (antecedente.getHagcpildouso() != null && 
                    antecedente.getHagcpildouso().equals("S")) {
                    mostrarPildorasSi = true;
                } else {
                    mostrarPildorasSi = false;
                }
                mostrarSuspencionAnticonceptivo = true;
            } else if (antecedente.getHagcmetodoplan() != null && 
                       (antecedente.getHagcmetodoplan().equals("9999") || 
                        antecedente.getHagcmetodoplan().equals("890201.7"))) {
                mostrarInyectable = false;
                mostrarSuspencionAnticonceptivo = false;
            } else {
                mostrarMetodo = false;
                antecedente.setHagcotrometodo(null);
                mostrarInyectable = false;
                mostrarSuspencionAnticonceptivo = true;
                mostrarPildoras = false;
                mostrarPildorasSi = false;
                antecedente.setHagcpildoobser(null);
                antecedente.setHagcpildouso(null);
            }
        }
    }


    public void changeUltimaCitologia() {
        if (!antecedente.getHagcultcitolo().equals("NO")) {
            renderResultado = true;
        } else {
            antecedente.setHagcresulcitol(null);
            renderResultado = false;
            renderOtroResultado = false;
            mnuResultado.setValue(null);
            antecedente.setHagcotroresul(null);
        }
    }

    public String aceptar() throws ModelException {

        navigationRule = "";
        wexito = true;
        mostrarReporte = false;
        String urlAux = 
            "body:formAntecedentesGinecologicos:panelTabAntecedentesGinecologicospre:";


        if (wexito) {

            if (!renderResultado) {
                antecedente.setHagcresulcitol(null);
                antecedente.setHagcotroresul(null);
            }

            if (!renderOtroResultado) {
                antecedente.setHagcotroresul(null);
            }

            if (antecedente != null) {

                if (antecedente.getHagcultcitolo() != null && 
                    !antecedente.getHagcultcitolo().equals("NO")) {
                    if (antecedente.getHagcresulcitol() == null || 
                        antecedente.getHagcresulcitol().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage(urlAux + 
                                                   "mnuResultadoGineco", 
                                                   MSG_CAMPO_OBLIGATORIO);
                    }

                    if (antecedente.getHagcresulcitol() != null && 
                        antecedente.getHagcresulcitol().equals("2.2")) {
                        if (antecedente.getHagcotroresul() == null || 
                            antecedente.getHagcotroresul().equals("")) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + 
                                                       "itOtrosHallazgos", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }

                    }

                }

                if (antecedente != null && 
                    antecedente.getHagcmetodoplan() != null && 
                    antecedente.getHagcmetodoplan().equals("0")) {
                    if (antecedente.getHagcotrometodo() == null || 
                        antecedente.getHagcotrometodo().equals("")) {
                        wexito = false;
                        FacesUtils.addErrorMessage(urlAux + "inputOtroMetodo", 
                                                   MSG_CAMPO_OBLIGATORIO);
                    }

                }

                if (tipoCiclo == null || tipoCiclo.equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage(urlAux + "radioTipoCiclo", 
                                               MSG_CAMPO_OBLIGATORIO);
                }

                if (tipoCiclo != null) {
                    if (tipoCiclo.equals("I")) {

                        if (antecedente != null) {
                            if (antecedente.getHagnfreciclo() == null) {
                                wexito = false;
                                FacesUtils.addErrorMessage(urlAux + 
                                                           "itFrecuencia", 
                                                           MSG_CAMPO_OBLIGATORIO);
                            }

                            if (antecedente.getHagndurciclo() == null) {
                                wexito = false;
                                FacesUtils.addErrorMessage(urlAux + 
                                                           "itDuracion", 
                                                           MSG_CAMPO_OBLIGATORIO);
                            }

                            if (antecedente.getHagnmenarquia() == null) {
                                wexito = false;
                                FacesUtils.addErrorMessage(urlAux + 
                                                           "itEdadMenarquia", 
                                                           MSG_CAMPO_OBLIGATORIO);
                            }

                            if (antecedente.getHagdfur() == null) {
                                wexito = false;
                                FacesUtils.addErrorMessage(urlAux + 
                                                           "calendarUltimaRegla", 
                                                           MSG_CAMPO_OBLIGATORIO);
                            }
                        }

                    }


                    if (tipoCiclo.equals("R")) {
                        if (antecedente.getHagnfreciclo() == null) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + "itFrecuencia", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }


                        if (antecedente.getHagndurciclo() == null) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + "itDuracion", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }


                        if (antecedente.getHagnmenarquia() == null) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + 
                                                       "itEdadMenarquia", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }

                        if (antecedente.getHagdfur() == null) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + 
                                                       "calendarUltimaRegla", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }

                    }


                    if (tipoCiclo.equals("A")) {

                        antecedente.setHagnfreciclo(null);
                        antecedente.setHagndurciclo(null);

                        if (antecedente.getHagnmenarquia() == null) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + 
                                                       "itEdadMenarquia", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }

                        if (antecedente.getHagdfur() == null) {
                            wexito = false;
                            FacesUtils.addErrorMessage(urlAux + 
                                                       "calendarUltimaRegla", 
                                                       MSG_CAMPO_OBLIGATORIO);
                        }

                    }

                    if (tipoCiclo.equals("N")) {
                        antecedente.setHagnfreciclo(null);
                        antecedente.setHagndurciclo(null);
                        antecedente.setHagnmenarquia(null);

                    }

                }

            }


        }


        if (tipoCiclo != null && tipoCiclo.equals("N")) {
            tieneCiclo = false;
            renderMenarquia = false;
            antecedente.setHagnfreciclo(null);
            antecedente.setHagndurciclo(null);
            antecedente.setHagnmenarquia(null);
            antecedente.setHagdfur(null);

            antecedente.setHagcultcitolo("NO");

        }

        if (tipoCiclo != null && tipoCiclo.equals("A")) {
            tieneCiclo = false;
            renderMenarquia = true;
            antecedente.setHagnfreciclo(null);
            antecedente.setHagndurciclo(null);
        }

        if (numeroConsulta != null) {
            antecedente.setHaglconsulta(numeroConsulta);
            antecedente.setHagctiposervi(TIPO_CONSULTA);
        }

        antecedente.setHagdfecregistr(new Date());
        antecedente.setHagcoperador(userName());


        if (tipoCiclo != null) {
            antecedente.setHagetipciclo(tipoCiclo);
        }

        if (antecedente != null) {
            if (antecedente.getHagdfur() != null) {
                java.util.Date fechaUltimaRegla = 
                    new Date(antecedente.getHagdfur().getTime());
                Calendar fechaAuxUR = Calendar.getInstance();
                fechaAuxUR.setTime(fechaUltimaRegla);
                fechaAuxUR.add(Calendar.DAY_OF_YEAR, 30);
                Date fechacomp = new Date();

                if (fechaUltimaRegla.compareTo(fechacomp) > 0) {
                    wexito = false;
                    FacesUtils.addErrorMessage(MSG_FECHA_ULTIMA_REGLA_NO_VALIDA);
                }

            }

            Date fechacomp = new Date();
            if (antecedente.getHagdfpr() != null) {
                Date fechaUltimoParto = 
                    new Date(antecedente.getHagdfpr().getTime());
                if (fechaUltimoParto.compareTo(fechacomp) > 0) {
                    wexito = false;
                    FacesUtils.addErrorMessage(MSG_FECHA_ULTIMO_PARTO_NO_VALIDA);
                }
            }

        }


        if (wexito) {

            try {
                this.getServiceLocator().getClinicoService().saveAntecedenteGinecopre(antecedente);
                FacesUtils.addInfoMessage(MSG_ADICION);
                // Se recarga el menu 
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            }
            catch (Exception e) {
                FacesUtils.addErrorMessage("Error " + e.getMessage());
                navigationRule = null;
            }
          

        }

        return navigationRule;
    }


    public void setMostrarSuspencionAnticonceptivo(boolean mostrarSuspencionAnticonceptivo) {
        this.mostrarSuspencionAnticonceptivo = mostrarSuspencionAnticonceptivo;
    }

    public boolean isMostrarSuspencionAnticonceptivo() {
        return mostrarSuspencionAnticonceptivo;
    }

    public void setWexito(boolean wexito) {
        this.wexito = wexito;
    }

    public boolean isWexito() {
        return wexito;
    }

    public void setMostrarFlujoVaginal(boolean mostrarFlujoVaginal) {
        this.mostrarFlujoVaginal = mostrarFlujoVaginal;
    }

    public boolean isMostrarFlujoVaginal() {
        return mostrarFlujoVaginal;
    }

    public void setMostrarTratamientoInfertilidad(boolean mostrarTratamientoInfertilidad) {
        this.mostrarTratamientoInfertilidad = mostrarTratamientoInfertilidad;
    }

    public boolean isMostrarTratamientoInfertilidad() {
        return mostrarTratamientoInfertilidad;
    }

    public void setHagccolposcopi(ValueChangeEvent valueChangeEvent) {
        antecedente.setHagccolposcopi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
        public void chanheColposcopia(){
          renderColposcopia = false; 
          
          if(antecedente.getHagccolposcopi()!= null ){
              if(antecedente.getHagccolposcopi().equals("S")){
                  renderColposcopia = true; 
              }
          }
        }

    public void setRenderColposcopia(boolean renderColposcopia) {
        this.renderColposcopia = renderColposcopia;
    }

    public boolean isRenderColposcopia() {
        return renderColposcopia;
    }
}
