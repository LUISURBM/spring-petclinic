//=======================================================================
// ARCHIVO ExamenFisicoMamaUsuarioBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano, nlis
// Descripcion: Permite registrar el examen fisico del Examen de Mamas
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chexafismama;
import org.profamilia.hc.model.dto.ChexafismamaPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE ExamenFisicoMamaUsuarioBean
//=======================================================================
public class ExamenFisicoMamaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chexafismama examen;

    private List lstEstado;

    private List lstOpciones;

    private List lstZonaLesion;

    private List lstCuadrante;

    private String estadoDerSelect;

    private String estadoIzqSelect;

    private boolean lesionPesonDerecho;

    private boolean lesionMamaDerecha;

    private boolean lesionAxilaDerecha;

    private boolean lesionPesonIzquierdo;

    private boolean lesionMamaIzquierda;

    private boolean lesionAxilaIzquierda;

    private String lesionPielDerecha;

    private String lesionPielIzquierda;

    private List lstTipoLesion;

    private String secrecionDerecha;

    private String secrecionIzquierda;

    private List lstTipoSecrecion;

    private List lstSecrecion;

    private String masaDerecha;

    private String masaIzquierda;

    private String dolorDerecho;

    private String dolorIzquierdo;

    private List lstTipoDolor;

    private boolean mostrarMamaDerecha;

    private boolean mostrarMamaIzquierda;

    private boolean mostrarLesionPielDerecho;

    private boolean mostrarSecrecionDerecha;

    private boolean mostrarMasaDerecha;

    private boolean mostrarMasaIzquierda;

    private boolean mostrarDolorDerecho;

    private boolean mostrarDolorIzquierdo;

    private boolean mostrarLesionPielIzquierda;

    private boolean mostrarSecrecionIzquierda;

    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    private Chusuario usuario;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ExamenFisicoMamaUsuarioBean() {
    }

    public void init() {
        nextAction = "";
        inicializarExamenFisico();

    }

    public void inicializarExamenFisico() {
        try {
            examen = 
                    this.serviceLocator.getClinicoService().getExamenFisicoMama(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (examen == null) {
            examen = new Chexafismama();
        } else {

            if (examen.getHemeexamamader() != null) {
                estadoDerSelect = examen.getHemeexamamader();
                if (estadoDerSelect != null && estadoDerSelect.equals("A")) {
                    mostrarMamaDerecha = true;
                    if (examen.getHemesecreciode() != null) {
                        secrecionDerecha = "S";
                        mostrarSecrecionDerecha = true;
                    } else {
                        secrecionDerecha = "N";
                        mostrarSecrecionDerecha = false;
                    }
                } else {
                    mostrarMamaDerecha = false;
                }
            }

            if (examen.getHemeexamamaizq() != null) {
                estadoIzqSelect = examen.getHemeexamamaizq();
                if (estadoIzqSelect != null && estadoIzqSelect.equals("A")) {
                    if (examen.getHemesecrecioiz() != null) {
                        secrecionIzquierda = "S";
                        mostrarSecrecionIzquierda = true;
                    } else {
                        secrecionIzquierda = "N";
                        mostrarSecrecionIzquierda = false;
                    }

                    mostrarMamaIzquierda = true;
                } else {
                    mostrarMamaIzquierda = false;
                }
            }

            if (examen.getHemelespezonde() != null && 
                examen.getHemelespezonde().equals("S")) {
                lesionPesonDerecho = true;
            } else {
                lesionPesonDerecho = false;
            }


            if (examen.getHemelespezoniz() != null && 
                examen.getHemelespezoniz().equals("S")) {
                lesionPesonIzquierdo = true;
            } else {
                lesionPesonIzquierdo = false;
            }


            if (examen.getHemelesimamade() != null && 
                examen.getHemelesimamade().equals("S")) {
                lesionMamaDerecha = true;

            } else {
                lesionMamaDerecha = false;
            }


            if (examen.getHemelesimamaiz() != null && 
                examen.getHemelesimamaiz().equals("S")) {
                lesionMamaIzquierda = true;

            } else {
                lesionMamaIzquierda = false;
            }

            if (examen.getHemelesionaxde() != null && 
                examen.getHemelesionaxde().equals("S")) {
                lesionAxilaDerecha = true;
            } else {
                lesionAxilaDerecha = false;
            }

            if (examen.getHemelesionaxiz() != null && 
                examen.getHemelesionaxiz().equals("S")) {
                lesionAxilaIzquierda = true;
            } else {
                lesionAxilaIzquierda = false;
            }

            if (examen.getHemelesipielde() != null && 
                examen.getHemelesipielde().equals("S")) {
                lesionPielDerecha = examen.getHemelesipielde();
                mostrarLesionPielDerecho = true;
            } else {
                lesionPielDerecha = examen.getHemelesipielde();
                mostrarLesionPielDerecho = false;
            }

            if (examen.getHemelesipieliz() != null && 
                examen.getHemelesipieliz().equals("S")) {
                lesionPielIzquierda = examen.getHemelesipieliz();
                mostrarLesionPielIzquierda = true;
            } else {
                lesionPielIzquierda = examen.getHemelesipieliz();
                mostrarLesionPielIzquierda = false;
            }


            if (examen.getHememasaderech() != null) {
                masaDerecha = examen.getHememasaderech();
                if (masaDerecha != null && masaDerecha.equals("S")) {
                    mostrarMasaDerecha = true;
                } else {
                    mostrarMasaDerecha = false;
                }

            } else {
                mostrarMasaDerecha = false;
            }

            if (examen.getHememasaizquie() != null) {
                masaIzquierda = examen.getHememasaizquie();
                if (masaIzquierda != null && masaIzquierda.equals("S")) {
                    mostrarMasaIzquierda = true;
                } else {
                    mostrarMasaIzquierda = false;
                }

            } else {
                mostrarMasaIzquierda = false;
            }

            if (examen.getHemedolorosade() != null) {
                dolorDerecho = examen.getHemedolorosade();
                if (dolorDerecho != null && dolorDerecho.equals("S")) {
                    mostrarDolorDerecho = true;
                } else {
                    mostrarDolorDerecho = false;
                }
            } else {
                mostrarDolorDerecho = false;
            }


            if (examen.getHemedolorosaiz() != null) {
                dolorIzquierdo = examen.getHemedolorosaiz();
                if (dolorIzquierdo != null && dolorIzquierdo.equals("S")) {
                    mostrarDolorIzquierdo = true;
                } else {
                    mostrarDolorIzquierdo = false;
                }
            } else {
                mostrarDolorIzquierdo = false;
            }


        }

    }

    //-----------------------------------------------------------------------
    // GET/SET
    //-----------------------------------------------------------------------

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
     * @param examen
     */
    public void setExamen(Chexafismama examen) {
        this.examen = examen;
    }

    /**
     * @return
     */
    public Chexafismama getExamen() {
        return examen;
    }


    /**
     * @param lstEstado
     */
    public void setLstEstado(List lstEstado) {
        this.lstEstado = lstEstado;
    }

    /**
     * @return
     */
    public List getLstEstado() {

        if (lstEstado == null || lstEstado.isEmpty()) {
            lstEstado = new ArrayList();
            lstEstado.add(new SelectItem("", "Seleccione una opci�n"));
            lstEstado.add(new SelectItem("N", "Normal"));
            lstEstado.add(new SelectItem("A", "Anormal"));
        }
        return lstEstado;
    }


    /**
     * @param estadoDerSelect
     */
    public void setEstadoDerSelect(String estadoDerSelect) {
        this.estadoDerSelect = estadoDerSelect;
    }


    /**
     * @return
     */
    public String getEstadoDerSelect() {
        return estadoDerSelect;
    }


    /**
     * @param estadoIzqSelect
     */
    public void setEstadoIzqSelect(String estadoIzqSelect) {
        this.estadoIzqSelect = estadoIzqSelect;
    }

    /**
     * @return
     */
    public String getEstadoIzqSelect() {
        return estadoIzqSelect;
    }

    /**
     * @param lesionPesonDerecho
     */
    public void setLesionPesonDerecho(boolean lesionPesonDerecho) {
        this.lesionPesonDerecho = lesionPesonDerecho;
    }

    /**
     * @return
     */
    public boolean isLesionPesonDerecho() {
        return lesionPesonDerecho;
    }

    /**
     * @param lesionMamaDerecha
     */
    public void setLesionMamaDerecha(boolean lesionMamaDerecha) {
        this.lesionMamaDerecha = lesionMamaDerecha;
    }

    /**
     * @return
     */
    public boolean isLesionMamaDerecha() {
        return lesionMamaDerecha;
    }

    /**
     * @param lesionAxilaDerecha
     */
    public void setLesionAxilaDerecha(boolean lesionAxilaDerecha) {
        this.lesionAxilaDerecha = lesionAxilaDerecha;
    }

    /**
     * @return
     */
    public boolean isLesionAxilaDerecha() {
        return lesionAxilaDerecha;
    }

    /**
     * @param lesionPesonIzquierdo
     */
    public void setLesionPesonIzquierdo(boolean lesionPesonIzquierdo) {
        this.lesionPesonIzquierdo = lesionPesonIzquierdo;
    }

    /**
     * @return
     */
    public boolean isLesionPesonIzquierdo() {
        return lesionPesonIzquierdo;
    }

    /**
     * @param lesionMamaIzquierda
     */
    public void setLesionMamaIzquierda(boolean lesionMamaIzquierda) {
        this.lesionMamaIzquierda = lesionMamaIzquierda;
    }

    /**
     * @return
     */
    public boolean isLesionMamaIzquierda() {
        return lesionMamaIzquierda;
    }

    /**
     * @param lesionAxilaIzquierda
     */
    public void setLesionAxilaIzquierda(boolean lesionAxilaIzquierda) {
        this.lesionAxilaIzquierda = lesionAxilaIzquierda;
    }

    /**
     * @return
     */
    public boolean isLesionAxilaIzquierda() {
        return lesionAxilaIzquierda;
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
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No"));
        }
        return lstOpciones;
    }

    /**
     * @param lesionPielDerecha
     */
    public void setLesionPielDerecha(String lesionPielDerecha) {
        this.lesionPielDerecha = lesionPielDerecha;
    }

    /**
     * @return
     */
    public String getLesionPielDerecha() {
        return lesionPielDerecha;
    }

    /**
     * @param lstTipoLesion
     */
    public void setLstTipoLesion(List lstTipoLesion) {
        this.lstTipoLesion = lstTipoLesion;
    }

    /**
     * @return
     */
    public List getLstTipoLesion() {
        if (lstTipoLesion == null || lstTipoLesion.isEmpty()) {
            lstTipoLesion = new ArrayList();
            lstTipoLesion.add(new SelectItem("", "Seleccione una opci�n"));
            lstTipoLesion.add(new SelectItem("E", "Edema"));
            lstTipoLesion.add(new SelectItem("R", "Retracci�n"));
            lstTipoLesion.add(new SelectItem("U", "Ulcera"));
        }
        return lstTipoLesion;
    }

    /**
     * @param secrecionDerecha
     */
    public void setSecrecionDerecha(String secrecionDerecha) {
        this.secrecionDerecha = secrecionDerecha;
    }

    /**
     * @return
     */
    public String getSecrecionDerecha() {
        return secrecionDerecha;
    }

    /**
     * @param lstTipoSecrecion
     */
    public void setLstTipoSecrecion(List lstTipoSecrecion) {
        this.lstTipoSecrecion = lstTipoSecrecion;
    }

    /**
     * @return
     */
    public List getLstTipoSecrecion() {
        if (lstTipoSecrecion == null || lstTipoSecrecion.isEmpty()) {
            lstTipoSecrecion = new ArrayList();
            lstTipoSecrecion.add(new SelectItem("", 
                                                "Seleccione una opci�n ..."));
            lstTipoSecrecion.add(new SelectItem("C", "Cristalina"));
            lstTipoSecrecion.add(new SelectItem("A", "Amarillenta"));
            lstTipoSecrecion.add(new SelectItem("S", "Sanguinolenta"));
            lstTipoSecrecion.add(new SelectItem("V", "Verdosa"));
        }
        return lstTipoSecrecion;
    }

    /**
     * @param lstZonaLesion
     */
    public void setLstZonaLesion(List lstZonaLesion) {
        this.lstZonaLesion = lstZonaLesion;
    }

    /**
     * @return
     */
    public List getLstZonaLesion() {
        if (lstZonaLesion == null || lstZonaLesion.isEmpty()) {
            lstZonaLesion = new ArrayList();
            lstZonaLesion.add(new SelectItem("", "--"));
            lstZonaLesion.add(new SelectItem("1", "1"));
            lstZonaLesion.add(new SelectItem("2", "2"));
            lstZonaLesion.add(new SelectItem("3", "3"));
            lstZonaLesion.add(new SelectItem("4", "4"));
            lstZonaLesion.add(new SelectItem("5", "5"));
            lstZonaLesion.add(new SelectItem("P", "P"));
        }
        return lstZonaLesion;
    }

    /**
     * @param lstCuadrante
     */
    public void setLstCuadrante(List lstCuadrante) {
        this.lstCuadrante = lstCuadrante;
    }

    /**
     * @return
     */
    public List getLstCuadrante() {
        if (lstCuadrante == null || lstCuadrante.isEmpty()) {
            lstCuadrante = new ArrayList();
            lstCuadrante.add(new SelectItem("", "--"));
            lstCuadrante.add(new SelectItem("CS", "CS"));
            lstCuadrante.add(new SelectItem("IE", "IE"));
            lstCuadrante.add(new SelectItem("SE", "SE"));
            lstCuadrante.add(new SelectItem("SI", "SI"));
        }
        return lstCuadrante;
    }

    /**
     * @param lstSecrecion
     */
    public void setLstSecrecion(List lstSecrecion) {
        this.lstSecrecion = lstSecrecion;
    }

    /**
     * @return
     */
    public List getLstSecrecion() {
        if (lstSecrecion == null || lstSecrecion.isEmpty()) {
            lstSecrecion = new ArrayList();
            lstSecrecion.add(new SelectItem("", "Seleccione una opci�n ..."));
            lstSecrecion.add(new SelectItem("P", "Presi�n"));
            lstSecrecion.add(new SelectItem("E", "Espontanea"));
        }
        return lstSecrecion;
    }


    /**
     * @param masaDerecha
     */
    public void setMasaDerecha(String masaDerecha) {
        this.masaDerecha = masaDerecha;
    }


    /**
     * @return
     */
    public String getMasaDerecha() {
        return masaDerecha;
    }

    /**
     * @param dolorDerecho
     */
    public void setDolorDerecho(String dolorDerecho) {
        this.dolorDerecho = dolorDerecho;
    }

    /**
     * @return
     */
    public String getDolorDerecho() {
        return dolorDerecho;
    }

    /**
     * @param mostrarMamaIzquierda
     */
    public void setMostrarMamaIzquierda(boolean mostrarMamaIzquierda) {
        this.mostrarMamaIzquierda = mostrarMamaIzquierda;
    }

    /**
     * @return
     */
    public boolean isMostrarMamaIzquierda() {
        return mostrarMamaIzquierda;
    }


    /**
     * @param lstTipoDolor
     */
    public void setLstTipoDolor(List lstTipoDolor) {
        this.lstTipoDolor = lstTipoDolor;
    }

    /**
     * @return
     */
    public List getLstTipoDolor() {
        if (lstTipoDolor == null || lstTipoDolor.isEmpty()) {
            lstTipoDolor = new ArrayList();
            lstTipoDolor.add(new SelectItem("1", "Dura"));
            lstTipoDolor.add(new SelectItem("2", "Renitente"));
            lstTipoDolor.add(new SelectItem("3", "Le�osa"));
            lstTipoDolor.add(new SelectItem("4", "Movil"));
            lstTipoDolor.add(new SelectItem("5", "Adherecias a piel"));
            lstTipoDolor.add(new SelectItem("6", "Adherecias a pared"));
            lstTipoDolor.add(new SelectItem("7", "Bordes Irregulares"));
            lstTipoDolor.add(new SelectItem("8", "Bordes Regulares"));
            lstTipoDolor.add(new SelectItem("9", "Bordes No Definidos"));
        }
        return lstTipoDolor;
    }


    /**
     * @param lesionPielIzquierda
     */
    public void setLesionPielIzquierda(String lesionPielIzquierda) {
        this.lesionPielIzquierda = lesionPielIzquierda;
    }

    /**
     * @return
     */
    public String getLesionPielIzquierda() {
        return lesionPielIzquierda;
    }

    /**
     * @param secrecionIzquierda
     */
    public void setSecrecionIzquierda(String secrecionIzquierda) {
        this.secrecionIzquierda = secrecionIzquierda;
    }


    /**
     * @return
     */
    public String getSecrecionIzquierda() {
        return secrecionIzquierda;
    }

    /**
     * @param masaIzquierda
     */
    public void setMasaIzquierda(String masaIzquierda) {
        this.masaIzquierda = masaIzquierda;
    }

    /**
     * @return
     */
    public String getMasaIzquierda() {
        return masaIzquierda;
    }

    /**
     * @param mostrarMasaIzquierda
     */
    public void setMostrarMasaIzquierda(boolean mostrarMasaIzquierda) {
        this.mostrarMasaIzquierda = mostrarMasaIzquierda;
    }

    /**
     * @return
     */
    public boolean isMostrarMasaIzquierda() {
        return mostrarMasaIzquierda;
    }


    /**
     * @param mostrarSecrecionDerecha
     */
    public void setMostrarSecrecionDerecha(boolean mostrarSecrecionDerecha) {
        this.mostrarSecrecionDerecha = mostrarSecrecionDerecha;
    }

    /**
     * @return
     */
    public boolean isMostrarSecrecionDerecha() {
        return mostrarSecrecionDerecha;
    }

    /**
     * @param dolorIzquierdo
     */
    public void setDolorIzquierdo(String dolorIzquierdo) {
        this.dolorIzquierdo = dolorIzquierdo;
    }

    /**
     * @return
     */
    public String getDolorIzquierdo() {
        return dolorIzquierdo;
    }

    /**
     * @param mostrarLesionPielDerecho
     */
    public void setMostrarLesionPielDerecho(boolean mostrarLesionPielDerecho) {
        this.mostrarLesionPielDerecho = mostrarLesionPielDerecho;
    }

    /**
     * @return
     */
    public boolean isMostrarLesionPielDerecho() {
        return mostrarLesionPielDerecho;
    }

    /**
     * @param mostrarMamaDerecha
     */
    public void setMostrarMamaDerecha(boolean mostrarMamaDerecha) {
        this.mostrarMamaDerecha = mostrarMamaDerecha;
    }

    /**
     * @return
     */
    public boolean isMostrarMamaDerecha() {
        return mostrarMamaDerecha;
    }

    /**
     * @param mostrarDolorDerecho
     */
    public void setMostrarDolorDerecho(boolean mostrarDolorDerecho) {
        this.mostrarDolorDerecho = mostrarDolorDerecho;
    }

    /**
     * @return
     */
    public boolean isMostrarDolorDerecho() {
        return mostrarDolorDerecho;
    }

    /**
     * @param mostrarLesionPielIzquierda
     */
    public void setMostrarLesionPielIzquierda(boolean mostrarLesionPielIzquierda) {
        this.mostrarLesionPielIzquierda = mostrarLesionPielIzquierda;
    }

    /**
     * @return
     */
    public boolean isMostrarLesionPielIzquierda() {
        return mostrarLesionPielIzquierda;
    }

    /**
     * @param mostrarDolorIzquierdo
     */
    public void setMostrarDolorIzquierdo(boolean mostrarDolorIzquierdo) {
        this.mostrarDolorIzquierdo = mostrarDolorIzquierdo;
    }

    /**
     * @return
     */
    public boolean isMostrarDolorIzquierdo() {
        return mostrarDolorIzquierdo;
    }

    /**
     * @param mostrarSecrecionIzquierda
     */
    public void setMostrarSecrecionIzquierda(boolean mostrarSecrecionIzquierda) {
        this.mostrarSecrecionIzquierda = mostrarSecrecionIzquierda;
    }

    /**
     * @return
     */
    public boolean isMostrarSecrecionIzquierda() {
        return mostrarSecrecionIzquierda;
    }

    /**
     * @param mostrarMasaDerecha
     */
    public void setMostrarMasaDerecha(boolean mostrarMasaDerecha) {
        this.mostrarMasaDerecha = mostrarMasaDerecha;
    }

    /**
     * @return
     */
    public boolean isMostrarMasaDerecha() {
        return mostrarMasaDerecha;
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


    //-----------------------------------------------------------------------
    // AJAX
    //-----------------------------------------------------------------------

    public void setEstadoDerSelect(ValueChangeEvent valueChangeEvent) {
        setEstadoDerSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setEstadoIzqSelect(ValueChangeEvent valueChangeEvent) {
        setEstadoIzqSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setLesionPesonDerecho(ValueChangeEvent valueChangeEvent) {
        examen.setHemelespezonde((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setLesionMamaDerecha(ValueChangeEvent valueChangeEvent) {
        examen.setHemelesimamade((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLesionAxilaDerecha(ValueChangeEvent valueChangeEvent) {
        examen.setHemelesionaxde((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setLesionPesonIzquierdo(ValueChangeEvent valueChangeEvent) {
        examen.setHemelespezoniz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLesionMamaIzquierda(ValueChangeEvent valueChangeEvent) {
        examen.setHemelesimamaiz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLesionAxilaIzquierda(ValueChangeEvent valueChangeEvent) {
        examen.setHemelesionaxiz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLesionPielDerecha(ValueChangeEvent valueChangeEvent) {
        setLesionPielDerecha((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setSecrecionDerecha(ValueChangeEvent valueChangeEvent) {
        setSecrecionDerecha((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMasaDerecha(ValueChangeEvent valueChangeEvent) {
        setMasaDerecha((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setDolorDerecho(ValueChangeEvent valueChangeEvent) {
        setDolorDerecho((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setLesionPielIzquierda(ValueChangeEvent valueChangeEvent) {
        setLesionPielIzquierda((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setSecrecionIzquierda(ValueChangeEvent valueChangeEvent) {
        setSecrecionIzquierda((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMasaIzquierda(ValueChangeEvent valueChangeEvent) {
        setMasaIzquierda((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setDolorIzquierdo(ValueChangeEvent valueChangeEvent) {
        setDolorIzquierdo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeMamaDerecha() {
        if (estadoDerSelect != null && estadoDerSelect.equals("A")) {
            mostrarMamaDerecha = true;
        } else {
            mostrarMamaDerecha = false;
            lesionPesonDerecho = false;
            lesionAxilaDerecha = false;
            lesionMamaDerecha = false;
            mostrarSecrecionDerecha = false;
            mostrarLesionPielDerecho = false;
            mostrarDolorDerecho = false;
            examen.setHemetipolepide(null);
            examen.setHemesecreciode(null);
            examen.setHemetiposecrde(null);
            examen.setHemndiammasade(null);
            examen.setHemctipodolode(null);
        }
    }

    public void changeMamaIzquierda() {
        if (estadoIzqSelect != null && estadoIzqSelect.equals("A")) {
            mostrarMamaIzquierda = true;
        } else {
            mostrarMamaIzquierda = false;
            lesionPesonIzquierdo = false;
            lesionAxilaIzquierda = false;
            lesionMamaIzquierda = false;
            mostrarSecrecionIzquierda = false;
            mostrarLesionPielIzquierda = false;
            mostrarDolorIzquierdo = false;
            examen.setHemetipolepiiz(null);
            examen.setHemesecrecioiz(null);
            examen.setHemetiposecriz(null);
            examen.setHemndiammasaiz(null);
            examen.setHemctipodoloiz(null);
            examen.setHemctipodoloiz(null);

        }
    }


    public void changeLesionPielDerecha() {
        if (lesionPielDerecha != null && lesionPielDerecha.equals("S")) {
            mostrarLesionPielDerecho = true;
        } else {
            mostrarLesionPielDerecho = false;
            examen.setHemetipolepide(null);
        }
    }

    public void changeLesionPielIzquierda() {
        if (lesionPielIzquierda != null && lesionPielIzquierda.equals("S")) {
            mostrarLesionPielIzquierda = true;
        } else {
            mostrarLesionPielIzquierda = false;
            examen.setHemetipolepiiz(null);
        }
    }

    public void changeSecrecionDerecha() {
        if (secrecionDerecha != null && secrecionDerecha.equals("S")) {
            mostrarSecrecionDerecha = true;
        } else {
            mostrarSecrecionDerecha = false;
            examen.setHemesecreciode(null);
            examen.setHemetiposecrde(null);
        }
    }

    public void changeSecrecionIzquierda() {
        if (secrecionIzquierda != null && secrecionIzquierda.equals("S")) {
            mostrarSecrecionIzquierda = true;
        } else {
            mostrarSecrecionIzquierda = false;
            examen.setHemesecrecioiz(null);
            examen.setHemetiposecriz(null);
        }
    }

    public void changePezonDerecho() {
        if (examen != null && examen.getHemelespezonde().equals("S")) {
            lesionPesonDerecho = true;
        } else {
            lesionPesonDerecho = false;
            examen.setHemctipolepede(null);
        }

    }

    public void changePezonIzquierdo() {

        if (examen != null && examen.getHemelespezoniz().equals("S")) {
            lesionPesonIzquierdo = true;
        } else {
            lesionPesonIzquierdo = false;
            examen.setHemctipolepeiz(null);
        }

    }

    public void changeAxilaDerecha() {
        if (examen != null && examen.getHemelesionaxde().equals("S")) {
            lesionAxilaDerecha = true;
        } else {
            lesionAxilaDerecha = false;
            examen.setHemctipolesaxde(null);
        }

    }


    public void changeAxilaIzquierda() {
        if (examen != null && examen.getHemelesionaxiz().equals("S")) {
            lesionAxilaIzquierda = true;
        } else {
            lesionAxilaIzquierda = false;
            examen.setHemctipolesaxiz(null);
        }
    }


    public void changeMasaDerecha() {
        if (masaDerecha != null && masaDerecha.equals("S")) {
            mostrarMasaDerecha = true;
        } else {
            mostrarMasaDerecha = false;
            examen.setHemndiammasade(null);
        }
    }

    public void changeMasaIzquierda() {
        if (masaIzquierda != null && masaIzquierda.equals("S")) {
            mostrarMasaIzquierda = true;
        } else {
            mostrarMasaIzquierda = false;
            examen.setHemndiammasaiz(null);
        }
    }

    public void changeDolorDerecho() {
        if (dolorDerecho != null && dolorDerecho.equals("S")) {
            mostrarDolorDerecho = true;
        } else {
            mostrarDolorDerecho = false;
            examen.setHemctipodolode(null);
        }
    }

    public void changeDolorIzquierdo() {
        if (dolorIzquierdo != null && dolorIzquierdo.equals("S")) {
            mostrarDolorIzquierdo = true;
        } else {
            mostrarDolorIzquierdo = false;
            examen.setHemctipodoloiz(null);

        }
    }

    public void changeZonaDerecha() {
        if (examen != null && examen.getHemelesimamade().equals("S")) {
            lesionMamaDerecha = true;
        } else {
            lesionMamaDerecha = false;
            examen.setHemczonalesder(null);
            examen.setHemccuadlesder(null);
        }
    }

    public void changeZonaIzquierda() {
        if (examen != null && examen.getHemelesimamaiz().equals("S")) {
            lesionMamaIzquierda = true;
        } else {
            lesionMamaIzquierda = false;
            examen.setHemczonalesizq(null);
            examen.setHemccuadlesizq(null);
        }
    }

    //-----------------------------------------------------------------------
    // METODO ESVALIDO
    //-----------------------------------------------------------------------


    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chexafismama examenAux = null;
        if (consulta != null) {
            try {
                examenAux = 
                        this.serviceLocator.getClinicoService().getExamenFisicoMama(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (examenAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    // BOTON PRINCIPAL
    //-----------------------------------------------------------------------


    public String aceptar() {

        ChexafismamaPK id = new ChexafismamaPK();
        navigationRule = "";

        examen.setHemeexamamader(estadoDerSelect);
        examen.setHemeexamamaizq(estadoIzqSelect);

        if (estadoDerSelect != null && estadoDerSelect.equals("A")) {
            if (lesionPesonDerecho) {
                examen.setHemelespezonde("S");
            } else {
                examen.setHemelespezonde("N");
            }

            if (lesionMamaDerecha) {
                examen.setHemelesimamade("S");
            } else {
                examen.setHemelesimamade("N");
            }

            if (lesionAxilaDerecha) {
                examen.setHemelesionaxde("S");
            } else {
                examen.setHemelesionaxde("N");
            }

            if (lesionPielDerecha != null) {
                examen.setHemelesipielde(lesionPielDerecha);
            }


            if (masaDerecha != null) {
                examen.setHememasaderech(masaDerecha);
            }
            if (dolorDerecho != null) {
                examen.setHemedolorosade(dolorDerecho);
            }

        } else {
            examen.setHemelespezonde(null);
            examen.setHemelesimamade(null);
            examen.setHemelesionaxde(null);
            examen.setHemelesipielde(null);
            examen.setHememasaderech(null);
            examen.setHemedolorosade(null);
            examen.setHemctipodolode(null);


        }


        if (estadoIzqSelect != null && estadoIzqSelect.equals("A")) {
            if (lesionPesonIzquierdo) {
                examen.setHemelespezoniz("S");
            } else {
                examen.setHemelespezoniz("N");
            }

            if (lesionMamaIzquierda) {
                examen.setHemelesimamaiz("S");
            } else {
                examen.setHemelesimamaiz("N");
            }

            if (lesionAxilaIzquierda) {
                examen.setHemelesionaxiz("S");
            } else {
                examen.setHemelesionaxiz("N");
            }

            if (lesionPielIzquierda != null) {
                examen.setHemelesipieliz(lesionPielIzquierda);
            }

            if (masaIzquierda != null) {
                examen.setHememasaizquie(masaIzquierda);
            }
            if (dolorIzquierdo != null) {
                examen.setHemedolorosaiz(dolorIzquierdo);
            }


        } else {
            examen.setHemelespezoniz(null);
            examen.setHemelesimamaiz(null);
            examen.setHemelesionaxiz(null);
            examen.setHemelesipieliz(null);
            examen.setHememasaizquie(null);
            examen.setHemedolorosaiz(null);
            examen.setHemctipodoloiz(null);


        }


        examen.setHemcoperador(userName());
        examen.setHemdfecregistr(new Date());

        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHemlconsulta(new Long(consulta.getCconnumero()));
            id.setHemctiposervi(TIPO_CONSULTA);
            examen.setId(id);
        }


        try {
            this.getServiceLocator().getClinicoService().saveExamenFisicoMama(examen);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            navigationRule = "";
            e.printStackTrace();

        }
        return navigationRule;
    }


}
