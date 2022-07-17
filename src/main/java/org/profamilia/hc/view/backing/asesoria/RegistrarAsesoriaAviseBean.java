//=======================================================================
// ARCHIVO Registrar Asesoria Avise
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registro asesoria para avise
//=======================================================================
package org.profamilia.hc.view.backing.asesoria;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chtipoinas;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chaseavise;
import org.profamilia.hc.model.dto.Cnconocavise;
import org.profamilia.hc.model.dto.Cningrilve;
import org.profamilia.hc.model.dto.Cnlugarhecho;
import org.profamilia.hc.model.dto.Cnparenfamil;
import org.profamilia.hc.model.dto.Cnrelacavise;
import org.profamilia.hc.model.dto.Cnremisinsti;
import org.profamilia.hc.model.dto.Cntiempocurr;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  CLASE RegistrarAsesoriaAviseBean
//=======================================================================
public class RegistrarAsesoriaAviseBean extends BaseBean {


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Lista que almacena el tipo de Intervencion de Asesoria  */
    private List listIntervencionAsesoria;

    /** Lista que almacena las opciones de conocimiento AVISE  */
    private List listConocimientoAvise;


    /** Lista que almacena las opciones de lugar de lo hechos  */
    private List listLugarHechos;

    /** Lista que almacena el tiempo del lugar de los hechos  */
    private List listTiempoLugarHechos;

    /** Lista de las relaciones familiares **/
    private List listRelacionAvise;

    /** Lista de parentesco familiar  */
    private List listParentescoFamiliar;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;


    /**Almacena el obejo asesoria */
    private Chaseavise asesoria;

    /** Lista que almacena la lista de opciones */
    private List<SelectItem> listOpciones;

    /** Lista que almacena la lista de opciones */
    private List<SelectItem> listOpcionesNinguna;

    private String nextAction;

    private String navegationRule;

    private String menuBean;

    /** Almacena el tipo de afiliacion */
    private String afiliacion;

    private boolean renderAgresor;

    private boolean renderOtroAgresor;

    private boolean renderOtroLugar;

    private List lstAreaCognitiva;

    private List lstAreaAfectiva;

    private List lstAreaSomatico;

    private List lstAreaRelacional;

    private List<String> lstAreaCognitivaSelect;

    private List<String> lstAreaAfectivaSelect;

    private List<String> lstAreaSomaticoSelect;

    private List<String> lstAreaRelacionalSelect;

    private boolean renderDenuncia;

    private boolean renderPrueba;

    private boolean renderPsiquica;

    private boolean renderCertMedico;

    private boolean renderRemisionOtra;

    private boolean renderOtroDocumento;

    private boolean renderAcciones;

    private boolean renderNingunDocumento;

    private boolean renderOtraInstitucion;

    private boolean renderCualDocumento;

    private boolean renderNingunaAccion;

    private boolean renderDenunciaAccion;

    private boolean renderAtencionMedica;

    private boolean renderApoyoAccion;


    private boolean renderOtroAccion;


    private boolean renderRemitirIlve;

    private boolean renderProgramaAvise;

    private List lstRemisionInstitucion;

    private List lstIngreso;


    private List lstDetalleIntervencion;

    private boolean renderOtraInstitucionIlve;

   // private Date fechaAsesoria;

    private UIInput menuDetalleIntervencion;

    private boolean renderOtroIngreso;

    private boolean renderDetalle;

    private boolean renderEcografia;

    private boolean renderIndecision;

    private boolean renderCostoAlto;

    private boolean renderEps;

    private boolean renderOtraIps;

    private boolean renderAplicaCausal;

    private boolean renderEmbarazoMayor;

    private boolean renderContinuaEmbarazo;

    private boolean renderOtraConducta;

    private boolean renderAplazaDecision;

    private boolean renderRelacionFamiliar;

    private boolean renderRelacionOtra;

    private boolean renderOtroParentesco;

    private boolean renderCuantosDias;
    
    private boolean renderAnticoncepcion;
    
    private UIInput checkOtraAccion; 
    
    private UIInput itConceptoPsicologico; 
    
    private Integer selectedIndex; 
    
    private boolean renderPlantilla; 
    
    static final int ACTIVAR_APLICACION = 0;

     static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;




    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarAsesoriaAviseBean() {

    }

    public void init() {
        asesoria = new Chaseavise();
        asesoria.getId().setHavdfecase(new Date());
        lstDetalleIntervencion = new ArrayList();
        selectedIndex = 0; 
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------
    
     public void mostrarBuscadorPlantilla(){
         FacesUtils.resetManagedBean("buscadorPlantillaBean");
         selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS; 
         renderPlantilla = true; 
     }
     
     public void aceptarPlantilla() {
         BuscadorPlantillaBean buscador = 
             (BuscadorPlantillaBean)FacesUtils.getManagedBean("buscadorPlantillaBean");
         if (buscador != null && buscador.getPlantillaSelect() != null) {
             itConceptoPsicologico.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
             asesoria.setHavcconpsi(buscador.getPlantillaSelect().getHplcdescripcio());
            
         }
         renderPlantilla = false;
         selectedIndex = ACTIVAR_APLICACION;
         FacesUtils.resetManagedBean("buscadorPlantillaBean");
     }
    
    

    public void changeAsesoria() {
        renderDetalle = false;
        renderAgresor = false;

        if (asesoria != null && asesoria.getHavnintase() != null) {
            asesoria.setHavndetint(null);
            menuDetalleIntervencion.setValue(null);
            if (asesoria.getHavnintase().equals(11) || 
                asesoria.getHavnintase().equals(12)) {
                renderDetalle = true;

                if (asesoria.getHavnintase() != null) {
                    this.lstDetalleIntervencion = new ArrayList();

                    ArrayList<Chtipoinas> listTipoIntervencionAux = null;

                    try {

                        listTipoIntervencionAux = 
                                (ArrayList<Chtipoinas>)this.serviceLocator.getClinicoService().getListaHistoriaIntervencionAsesoria(asesoria.getHavnintase());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (listTipoIntervencionAux != null && 
                        !listTipoIntervencionAux.isEmpty()) {

                        Iterator it = listTipoIntervencionAux.iterator();
                        int i = 0;
                        lstDetalleIntervencion.add(new SelectItem("", 
                                                                  "Seleccione una opcion ..."));
                        while (it.hasNext()) {
                            it.next();
                            lstDetalleIntervencion.add(new SelectItem(listTipoIntervencionAux.get(i).getHtinnumero(), 
                                                                      listTipoIntervencionAux.get(i).getHticdescri()));
                            i++;
                        }
                    }


                } else {
                    lstDetalleIntervencion = new ArrayList<SelectItem>();
                }
            }

        }

    }


    public void changeDetalleAsesoria() {
        renderAgresor = false;
        if (asesoria != null && asesoria.getHavnintase() != null) {
            if (asesoria.getHavndetint().equals(13) || 
                asesoria.getHavndetint().equals(14)) {
                renderAgresor = true;
            }

        }
    }


    public void changeAgresorConocido() {
        renderOtroAgresor = false;
        if (asesoria != null && asesoria.getHavcagrcon() != null) {
            if (asesoria.getHavcagrcon().equals("S")) {
                renderOtroAgresor = true;
            }
        }
    }


    public void changeLugarHechos() {
        renderOtroLugar = false;
        if (asesoria != null && asesoria.getHavnlugech() != null) {
            if (asesoria.getHavnlugech().equals(6)) {
                renderOtroLugar = true;
            }
        }
    }

    public void changeEstablecioAcciones() {
        renderAcciones = false;
        if (asesoria != null && asesoria.getHavcaccnin() != null) {
            if (asesoria.getHavcaccnin().equals("N")) {
                renderAcciones = true;
            }
        }

    }


    

    public void changeNingunaAccion() {
        if (renderNingunaAccion) {
            renderDenunciaAccion = false;
            renderAtencionMedica = false;
            renderApoyoAccion = false;
            renderAnticoncepcion = false;
            renderOtroAccion = false;
            checkOtraAccion.setValue(false);                    
        }
    }


    public void changeNingunDocumento() {
        if (renderNingunDocumento) {
            renderDenuncia = false;
            renderPrueba = false;
            renderCertMedico = false;
            renderRemisionOtra = false;
            renderOtroDocumento = false;
            renderEcografia = false;
            asesoria.setHavcrecnom(" ");
            asesoria.setHavcnomdoc(" ");
        }
    }

    public void changeConocimientoAvise() {
        renderProgramaAvise = false;
        if (asesoria != null && asesoria.getHavnconavs() != null) {
            if (asesoria.getHavnconavs().equals(6)) {
                renderProgramaAvise = true;
            }

        }
    }

    public void changeRelacionConocido() {
        renderRelacionFamiliar = false;
        renderRelacionOtra = false;
        if (asesoria != null && asesoria.getHavnrelagr() != null && 
            asesoria.getHavnrelagr().equals(1)) {
            renderRelacionFamiliar = true;
        } else if (asesoria != null && asesoria.getHavnrelagr() != null && 
                   asesoria.getHavnrelagr().equals(6)) {
            renderRelacionOtra = true;
        }
    }

    public void changeParentescoFamiliar() {
        renderOtroParentesco = false;
        if (asesoria != null && asesoria.getHavnparagr() != null && 
            asesoria.getHavnparagr().equals(7)) {
            renderOtroParentesco = true;

        }

    }


    public void changeTiempoOcurrencia() {
        renderCuantosDias = false;
        if (asesoria != null && asesoria.getHavntieocu() != null && 
            asesoria.getHavntieocu().equals(8)) {
            renderCuantosDias = true;
        }
    }



    /**
     * @param valueChangeEvent
     */
    public void setHavnintase(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavnintase((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHavntieocu(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavntieocu((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHavnrelagr(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavnrelagr((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHavnparagr(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavnparagr((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHavndetint(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavndetint((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHavcagrcon(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavcagrcon((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHavnlugech(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavnlugech((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHavcaccnin(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavcaccnin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHavcnindoc(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavcnindoc((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderOtroAccion(ValueChangeEvent valueChangeEvent) {
        setRenderOtroAccion((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
  

    /**
     * @param valueChangeEvent
     */
    public void setRenderRemitirIlve(ValueChangeEvent valueChangeEvent) {
        setRenderRemitirIlve((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }


    /**
     * @param valueChangeEvent
     */
    public void setRenderNingunaAccion(ValueChangeEvent valueChangeEvent) {
        setRenderNingunaAccion((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderIndecision(ValueChangeEvent valueChangeEvent) {
        setRenderIndecision((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderCostoAlto(ValueChangeEvent valueChangeEvent) {
        setRenderCostoAlto((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderEps(ValueChangeEvent valueChangeEvent) {
         setRenderEps((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

    /**
     * @param valueChangeEvent
     */
    public void setRenderOtraIps(ValueChangeEvent valueChangeEvent) {
         setRenderOtraIps((Boolean)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }

    /**
     * @param valueChangeEvent
     */
    public void setRenderAplicaCausal(ValueChangeEvent valueChangeEvent) {
        setRenderAplicaCausal((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderContinuaEmbarazo(ValueChangeEvent valueChangeEvent) {
        setRenderContinuaEmbarazo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderOtraConducta(ValueChangeEvent valueChangeEvent) {
        setRenderOtraConducta((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderAplazaDecision(ValueChangeEvent valueChangeEvent) {
        setRenderAplazaDecision((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderEmbarazoMayor(ValueChangeEvent valueChangeEvent) {
        setRenderEmbarazoMayor((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setRenderNingunDocumento(ValueChangeEvent valueChangeEvent) {
        setRenderNingunDocumento((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setRenderRemisionOtra(ValueChangeEvent valueChangeEvent) {
        setRenderRemisionOtra((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHavnconavs(ValueChangeEvent valueChangeEvent) {
        asesoria.setHavnconavs((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

    /**
     * @param listIntervencionAsesoria
     */
    public void setListIntervencionAsesoria(List listIntervencionAsesoria) {
        this.listIntervencionAsesoria = listIntervencionAsesoria;
    }

    /**
     * @return
     */
    public List getListIntervencionAsesoria() {
        if (listIntervencionAsesoria == null || 
            listIntervencionAsesoria.isEmpty()) {
            listIntervencionAsesoria = new ArrayList();
            ArrayList<Chtipoinas> listIntervencionAsesoriaAux = null;
            try {
                listIntervencionAsesoriaAux = 
                        (ArrayList<Chtipoinas>)this.serviceLocator.getClinicoService().getListaHistoriaIntervencionAsesoria(0);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listIntervencionAsesoriaAux.isEmpty()) {

                Iterator it = listIntervencionAsesoriaAux.iterator();
                int i = 0;
                listIntervencionAsesoria.add(new SelectItem("", 
                                                            "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listIntervencionAsesoria.add(new SelectItem(listIntervencionAsesoriaAux.get(i).getHtinnumero(), 
                                                                listIntervencionAsesoriaAux.get(i).getHticdescri()));
                    i++;
                }
            }
        }

        return listIntervencionAsesoria;
    }


    /**
     * @param listConocimientoAvise
     */
    public void setListConocimientoAvise(List listConocimientoAvise) {
        this.listConocimientoAvise = listConocimientoAvise;
    }

    /**
     * @return
     */
    public List getListConocimientoAvise() {
        if (listConocimientoAvise == null || listConocimientoAvise.isEmpty()) {
            listConocimientoAvise = new ArrayList();
            ArrayList<Cnconocavise> listConocimientoAux = null;
            try {
                listConocimientoAux = 
                        (ArrayList<Cnconocavise>)this.serviceLocator.getClinicoService().getListaConocimientoAvise();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listConocimientoAux.isEmpty()) {

                Iterator it = listConocimientoAux.iterator();
                int i = 0;
                listConocimientoAvise.add(new SelectItem("", 
                                                         "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listConocimientoAvise.add(new SelectItem(listConocimientoAux.get(i).getCcancodigo(), 
                                                             listConocimientoAux.get(i).getCcacdescripcio()));
                    i++;
                }
            }
        }

        return listConocimientoAvise;
    }


    /**
     * @param listLugarHechos
     */
    public void setListLugarHechos(List listLugarHechos) {
        this.listLugarHechos = listLugarHechos;
    }

    /**
     * @return
     */
    public List getListLugarHechos() {
        if (listLugarHechos == null || listLugarHechos.isEmpty()) {
            listLugarHechos = new ArrayList();
            ArrayList<Cnlugarhecho> listLugarAux = null;
            try {
                listLugarAux = 
                        (ArrayList<Cnlugarhecho>)this.serviceLocator.getClinicoService().getListaLugarHechosAvise();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listLugarAux.isEmpty()) {

                Iterator it = listLugarAux.iterator();
                int i = 0;
                listLugarHechos.add(new SelectItem("", 
                                                   "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listLugarHechos.add(new SelectItem(listLugarAux.get(i).getClhncodigo(), 
                                                       listLugarAux.get(i).getClhcdescripcio()));
                    i++;
                }
            }
        }

        return listLugarHechos;
    }


    /**
     * @param listTiempoLugarHechos
     */
    public void setListTiempoLugarHechos(List listTiempoLugarHechos) {
        this.listTiempoLugarHechos = listTiempoLugarHechos;
    }

    /**
     * @return
     */
    public List getListTiempoLugarHechos() {
        if (listTiempoLugarHechos == null || listTiempoLugarHechos.isEmpty()) {
            listTiempoLugarHechos = new ArrayList();
            ArrayList<Cntiempocurr> listTiempoAux = null;
            try {
                listTiempoAux = 
                        (ArrayList<Cntiempocurr>)this.serviceLocator.getClinicoService().getListaTiempoHechosAvise();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTiempoAux.isEmpty()) {

                Iterator it = listTiempoAux.iterator();
                int i = 0;
                listTiempoLugarHechos.add(new SelectItem("", 
                                                         "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTiempoLugarHechos.add(new SelectItem(listTiempoAux.get(i).getCtoncodigo(), 
                                                             listTiempoAux.get(i).getCtocdescripcio()));
                    i++;
                }
            }
        }

        return listTiempoLugarHechos;
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
     * @param afiliacion
     */
    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    /**
     * @return
     */
    public String getAfiliacion() {
        return afiliacion;
    }


    /**
     * @param asesoria
     */
    public void setAsesoria(Chaseavise asesoria) {
        this.asesoria = asesoria;
    }

    /**
     * @return
     */
    public Chaseavise getAsesoria() {
        return asesoria;
    }

    /**
     * @param listOpciones
     */
    public void setListOpciones(List<SelectItem> listOpciones) {
        this.listOpciones = listOpciones;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOpciones() {
        if (listOpciones == null || listOpciones.isEmpty()) {
            listOpciones = new ArrayList<SelectItem>();
            listOpciones.add(new SelectItem("S", "SI"));
            listOpciones.add(new SelectItem("N", "NO"));
        }
        return listOpciones;
    }

    /**
     * @param renderAgresor
     */
    public void setRenderAgresor(boolean renderAgresor) {
        this.renderAgresor = renderAgresor;
    }

    /**
     * @return
     */
    public boolean isRenderAgresor() {
        return renderAgresor;
    }

    /**
     * @param renderOtroAgresor
     */
    public void setRenderOtroAgresor(boolean renderOtroAgresor) {
        this.renderOtroAgresor = renderOtroAgresor;
    }

    /**
     * @return
     */
    public boolean isRenderOtroAgresor() {
        return renderOtroAgresor;
    }

    /**
     * @param renderOtroLugar
     */
    public void setRenderOtroLugar(boolean renderOtroLugar) {
        this.renderOtroLugar = renderOtroLugar;
    }

    /**
     * @return
     */
    public boolean isRenderOtroLugar() {
        return renderOtroLugar;
    }


    /**
     * @param lstAreaCognitiva
     */
    public void setLstAreaCognitiva(List lstAreaCognitiva) {
        this.lstAreaCognitiva = lstAreaCognitiva;
    }

    /**
     * @return
     */
    public List getLstAreaCognitiva() {
        if (lstAreaCognitiva == null || lstAreaCognitiva.isEmpty()) {
            lstAreaCognitiva = new ArrayList();
            lstAreaCognitiva.add(new SelectItem("SA", "Sin Alteraci�n"));
            lstAreaCognitiva.add(new SelectItem("DI", "Dispersa"));
            lstAreaCognitiva.add(new SelectItem("PN", 
                                                "Pensamientos negativos frecuentes"));
            lstAreaCognitiva.add(new SelectItem("DP", 
                                                "Dificultad para resolver problemas"));
            lstAreaCognitiva.add(new SelectItem("IP", "Ideas de persecuci�n"));
            lstAreaCognitiva.add(new SelectItem("IM", "Incapacidad Mental"));
            lstAreaCognitiva.add(new SelectItem("DD", 
                                                "Dificultad para tomar decisiones"));
            lstAreaCognitiva.add(new SelectItem("FC", 
                                                "Falta de concentraci�n "));
            lstAreaCognitiva.add(new SelectItem("IS", "ideaci�n suicida "));
            lstAreaCognitiva.add(new SelectItem("OT", "Otro"));
        }
        return lstAreaCognitiva;
    }


    /**
     * @param lstAreaAfectiva
     */
    public void setLstAreaAfectiva(List lstAreaAfectiva) {
        this.lstAreaAfectiva = lstAreaAfectiva;
    }

    /**
     * @return
     */
    public List getLstAreaAfectiva() {
        if (lstAreaAfectiva == null || lstAreaAfectiva.isEmpty()) {
            lstAreaAfectiva = new ArrayList();

            lstAreaAfectiva.add(new SelectItem("SAL", "Sin Alteraci�n"));
            lstAreaAfectiva.add(new SelectItem("TRA", "Tranquila"));
            lstAreaAfectiva.add(new SelectItem("ANG", "Angustiada"));
            lstAreaAfectiva.add(new SelectItem("TRI", "Triste"));
            lstAreaAfectiva.add(new SelectItem("CON", "Confundida"));
            lstAreaAfectiva.add(new SelectItem("DES", "Desorientada"));
            lstAreaAfectiva.add(new SelectItem("ANS", "Ansiosa"));
            lstAreaAfectiva.add(new SelectItem("AGO", "Agotada/Cansada"));
            lstAreaAfectiva.add(new SelectItem("HOS", "Hostil"));
            lstAreaAfectiva.add(new SelectItem("DPR", "Desesperaci�n"));
            lstAreaAfectiva.add(new SelectItem("NDN", "Anedonia"));
            lstAreaAfectiva.add(new SelectItem("SDD", 
                                               "Sentimientos de desesperanza"));
            lstAreaAfectiva.add(new SelectItem("IMP", "Impotencia"));
        }
        return lstAreaAfectiva;
    }

    /**
     * @param lstAreaSomatico
     */
    public void setLstAreaSomatico(List lstAreaSomatico) {
        this.lstAreaSomatico = lstAreaSomatico;
    }

    /**
     * @return
     */
    public List getLstAreaSomatico() {
        if (lstAreaSomatico == null || lstAreaSomatico.isEmpty()) {
            lstAreaSomatico = new ArrayList();
            lstAreaSomatico.add(new SelectItem("SAL", "Sin Alteraci�n"));
            lstAreaSomatico.add(new SelectItem("DOL", "Dolor"));
            lstAreaSomatico.add(new SelectItem("HEM", "Hematoma / equimosis"));
            lstAreaSomatico.add(new SelectItem("FRA", "Fractura"));
            lstAreaSomatico.add(new SelectItem("INS", "Alteraci�n del Sue�o"));
            lstAreaSomatico.add(new SelectItem("INA", 
                                               "Alteraci�n del apetito"));
            lstAreaSomatico.add(new SelectItem("DEB", "Debilidad"));
            lstAreaSomatico.add(new SelectItem("MAR", "Mareos"));
            lstAreaSomatico.add(new SelectItem("HIP", "Hiperactividad"));
            lstAreaSomatico.add(new SelectItem("AHO", 
                                               "Ahogo / falta de aire"));
            lstAreaSomatico.add(new SelectItem("PAL", "Palpitaciones"));

        }
        return lstAreaSomatico;
    }

    /**
     * @param lstAreaRelacional
     */
    public void setLstAreaRelacional(List lstAreaRelacional) {
        this.lstAreaRelacional = lstAreaRelacional;
    }

    /**
     * @return
     */
    public List getLstAreaRelacional() {
        if (lstAreaRelacional == null || lstAreaRelacional.isEmpty()) {
            lstAreaRelacional = new ArrayList();
            lstAreaRelacional.add(new SelectItem("SA", "Sin Alteraci�n"));
            lstAreaRelacional.add(new SelectItem("AG", "Agresividad"));
            lstAreaRelacional.add(new SelectItem("AI", "Aislamiento"));
            lstAreaRelacional.add(new SelectItem("PA", "Pasmada"));
            lstAreaRelacional.add(new SelectItem("FO", "Fobia"));
            lstAreaRelacional.add(new SelectItem("CP", 
                                                 "Conflicto con la pareja "));
            lstAreaRelacional.add(new SelectItem("CF", 
                                                 "Conflicto con la familia "));
            lstAreaRelacional.add(new SelectItem("DE", "Desamparo "));
            lstAreaRelacional.add(new SelectItem("PO", "Pobreza "));
            lstAreaRelacional.add(new SelectItem("VI", "Violencia "));
            lstAreaRelacional.add(new SelectItem("DPL", "Desempleo "));

        }
        return lstAreaRelacional;
    }


    /**
     * @param lstAreaCognitivaSelect
     */
    public void setLstAreaCognitivaSelect(List<String> lstAreaCognitivaSelect) {
        this.lstAreaCognitivaSelect = lstAreaCognitivaSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaCognitivaSelect() {
        return lstAreaCognitivaSelect;
    }

    /**
     * @param lstAreaAfectivaSelect
     */
    public void setLstAreaAfectivaSelect(List<String> lstAreaAfectivaSelect) {
        this.lstAreaAfectivaSelect = lstAreaAfectivaSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaAfectivaSelect() {
        return lstAreaAfectivaSelect;
    }

    /**
     * @param lstAreaSomaticoSelect
     */
    public void setLstAreaSomaticoSelect(List<String> lstAreaSomaticoSelect) {
        this.lstAreaSomaticoSelect = lstAreaSomaticoSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaSomaticoSelect() {
        return lstAreaSomaticoSelect;
    }

    /**
     * @param lstAreaRelacionalSelect
     */
    public void setLstAreaRelacionalSelect(List<String> lstAreaRelacionalSelect) {
        this.lstAreaRelacionalSelect = lstAreaRelacionalSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaRelacionalSelect() {
        return lstAreaRelacionalSelect;
    }

    /**
     * @param renderDenuncia
     */
    public void setRenderDenuncia(boolean renderDenuncia) {
        this.renderDenuncia = renderDenuncia;
    }

    /**
     * @return
     */
    public boolean isRenderDenuncia() {
        return renderDenuncia;
    }

    /**
     * @param renderPrueba
     */
    public void setRenderPrueba(boolean renderPrueba) {
        this.renderPrueba = renderPrueba;
    }

    /**
     * @return
     */
    public boolean isRenderPrueba() {
        return renderPrueba;
    }

    /**
     * @param renderPsiquica
     */
    public void setRenderPsiquica(boolean renderPsiquica) {
        this.renderPsiquica = renderPsiquica;
    }

    /**
     * @return
     */
    public boolean isRenderPsiquica() {
        return renderPsiquica;
    }

    /**
     * @param renderCertMedico
     */
    public void setRenderCertMedico(boolean renderCertMedico) {
        this.renderCertMedico = renderCertMedico;
    }

    /**
     * @return
     */
    public boolean isRenderCertMedico() {
        return renderCertMedico;
    }

    /**
     * @param renderAnticoncepcion
     */
    public void setRenderAnticoncepcion(boolean renderAnticoncepcion) {
        this.renderAnticoncepcion = renderAnticoncepcion;
    }

    /**
     * @return
     */
    public boolean isRenderAnticoncepcion() {
        return renderAnticoncepcion;
    }

    /**
     * @param renderRemisionOtra
     */
    public void setRenderRemisionOtra(boolean renderRemisionOtra) {
        this.renderRemisionOtra = renderRemisionOtra;
    }

    /**
     * @return
     */
    public boolean isRenderRemisionOtra() {
        return renderRemisionOtra;
    }

    /**
     * @param renderOtroDocumento
     */
    public void setRenderOtroDocumento(boolean renderOtroDocumento) {
        this.renderOtroDocumento = renderOtroDocumento;
    }

    /**
     * @return
     */
    public boolean isRenderOtroDocumento() {
        return renderOtroDocumento;
    }

    /**
     * @param renderAcciones
     */
    public void setRenderAcciones(boolean renderAcciones) {
        this.renderAcciones = renderAcciones;
    }

    /**
     * @return
     */
    public boolean isRenderAcciones() {
        return renderAcciones;
    }


    /**
     * @param listOpcionesNinguna
     */
    public void setListOpcionesNinguna(List<SelectItem> listOpcionesNinguna) {
        this.listOpcionesNinguna = listOpcionesNinguna;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOpcionesNinguna() {
        if (listOpcionesNinguna == null || listOpcionesNinguna.isEmpty()) {
            listOpcionesNinguna = new ArrayList<SelectItem>();
            listOpcionesNinguna.add(new SelectItem("N", "SI"));
            listOpcionesNinguna.add(new SelectItem("S", "NO"));
        }
        return listOpcionesNinguna;
    }

    /**
     * @param renderOtraInstitucion
     */
    public void setRenderOtraInstitucion(boolean renderOtraInstitucion) {
        this.renderOtraInstitucion = renderOtraInstitucion;
    }

    /**
     * @return
     */
    public boolean isRenderOtraInstitucion() {
        return renderOtraInstitucion;
    }

    /**
     * @param renderCualDocumento
     */
    public void setRenderCualDocumento(boolean renderCualDocumento) {
        this.renderCualDocumento = renderCualDocumento;
    }

    /**
     * @return
     */
    public boolean isRenderCualDocumento() {
        return renderCualDocumento;
    }

    public void setRenderDetalle(boolean renderDetalle) {
        this.renderDetalle = renderDetalle;
    }

    public boolean isRenderDetalle() {
        return renderDetalle;
    }


    /**
     * @param lstDetalleIntervencion
     */
    public void setLstDetalleIntervencion(List lstDetalleIntervencion) {
        this.lstDetalleIntervencion = lstDetalleIntervencion;
    }

    /**
     * @return
     */
    public List getLstDetalleIntervencion() {
        return lstDetalleIntervencion;
    }

    /**
     * @param menuDetalleIntervencion
     */
    public void setMenuDetalleIntervencion(UIInput menuDetalleIntervencion) {
        this.menuDetalleIntervencion = menuDetalleIntervencion;
    }

    /**
     * @return
     */
    public UIInput getMenuDetalleIntervencion() {
        return menuDetalleIntervencion;
    }

    /**
     * @param renderCuantosDias
     */
    public void setRenderCuantosDias(boolean renderCuantosDias) {
        this.renderCuantosDias = renderCuantosDias;
    }

    /**
     * @return
     */
    public boolean isRenderCuantosDias() {
        return renderCuantosDias;
    }


    /**
     * @return
     */
    public


    void setRenderNingunaAccion(boolean renderNingunaAccion) {
        this.renderNingunaAccion = renderNingunaAccion;
    }

    /**
     * @return
     */
    public boolean isRenderNingunaAccion() {
        return renderNingunaAccion;
    }

    /**
     * @param renderDenunciaAccion
     */
    public void setRenderDenunciaAccion(boolean renderDenunciaAccion) {
        this.renderDenunciaAccion = renderDenunciaAccion;
    }

    /**
     * @return
     */
    public boolean isRenderDenunciaAccion() {
        return renderDenunciaAccion;
    }

    /**
     * @param renderAtencionMedica
     */
    public void setRenderAtencionMedica(boolean renderAtencionMedica) {
        this.renderAtencionMedica = renderAtencionMedica;
    }

    /**
     * @return
     */
    public boolean isRenderAtencionMedica() {
        return renderAtencionMedica;
    }

    /**
     * @param renderApoyoAccion
     */
    public void setRenderApoyoAccion(boolean renderApoyoAccion) {
        this.renderApoyoAccion = renderApoyoAccion;
    }

    /**
     * @return
     */
    public boolean isRenderApoyoAccion() {
        return renderApoyoAccion;
    }

  

    /**
     * @param renderOtroAccion
     */
    public void setRenderOtroAccion(boolean renderOtroAccion) {
        this.renderOtroAccion = renderOtroAccion;
    }

    /**
     * @return
     */
    public boolean isRenderOtroAccion() {
        return renderOtroAccion;
    }

    /**
     * @param renderNingunDocumento
     */
    public void setRenderNingunDocumento(boolean renderNingunDocumento) {
        this.renderNingunDocumento = renderNingunDocumento;
    }

    /**
     * @return
     */
    public boolean isRenderNingunDocumento() {
        return renderNingunDocumento;
    }


    /**
     * @param renderRemitirIlve
     */
    public void setRenderRemitirIlve(boolean renderRemitirIlve) {
        this.renderRemitirIlve = renderRemitirIlve;
    }

    /**
     * @return
     */
    public boolean isRenderRemitirIlve() {
        return renderRemitirIlve;
    }



    /**
     * @param lstRemisionInstitucion
     */
    public void setLstRemisionInstitucion(List lstRemisionInstitucion) {
        this.lstRemisionInstitucion = lstRemisionInstitucion;
    }

    /**
     * @return
     */
    public List getLstRemisionInstitucion() {
        if (lstRemisionInstitucion == null || 
            lstRemisionInstitucion.isEmpty()) {
            lstRemisionInstitucion = new ArrayList();
            ArrayList<Cnremisinsti> listInstitucionAux = null;
            try {
                listInstitucionAux = 
                        (ArrayList<Cnremisinsti>)this.serviceLocator.getClinicoService().getListaTipoInstitucion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listInstitucionAux.isEmpty()) {

                Iterator it = listInstitucionAux.iterator();
                int i = 0;
                lstRemisionInstitucion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstRemisionInstitucion.add(new SelectItem(listInstitucionAux.get(i).getCrincodigo(), 
                                                              listInstitucionAux.get(i).getCricdescripcio()));
                    i++;
                }
            }
        }

        return lstRemisionInstitucion;
    }


    /**
     * @param renderOtraInstitucionIlve
     */
    public void setRenderOtraInstitucionIlve(boolean renderOtraInstitucionIlve) {
        this.renderOtraInstitucionIlve = renderOtraInstitucionIlve;
    }

    /**
     * @return
     */
    public boolean isRenderOtraInstitucionIlve() {
        return renderOtraInstitucionIlve;
    }

   

    /**
     * @param renderProgramaAvise
     */
    public void setRenderProgramaAvise(boolean renderProgramaAvise) {
        this.renderProgramaAvise = renderProgramaAvise;
    }

    /**
     * @return
     */
    public boolean isRenderProgramaAvise() {
        return renderProgramaAvise;
    }

    /**
     * @param renderEcografia
     */
    public void setRenderEcografia(boolean renderEcografia) {
        this.renderEcografia = renderEcografia;
    }

    /**
     * @return
     */
    public boolean isRenderEcografia() {
        return renderEcografia;
    }

    /**
     * @param renderIndecision
     */
    public void setRenderIndecision(boolean renderIndecision) {
        this.renderIndecision = renderIndecision;
    }

    /**
     * @return
     */
    public boolean isRenderIndecision() {
        return renderIndecision;
    }

    /**
     * @param checkOtraAccion
     */
    public void setCheckOtraAccion(UIInput checkOtraAccion) {
        this.checkOtraAccion = checkOtraAccion;
    }

    /**
     * @return
     */
    public UIInput getCheckOtraAccion() {
        return checkOtraAccion;
    }

    /**
     * @param renderCostoAlto
     */
    public void setRenderCostoAlto(boolean renderCostoAlto) {
        this.renderCostoAlto = renderCostoAlto;
    }

    /**
     * @return
     */
    public boolean isRenderCostoAlto() {
        return renderCostoAlto;
    }

    /**
     * @param renderEps
     */
    public void setRenderEps(boolean renderEps) {
        this.renderEps = renderEps;
    }

    /**
     * @return
     */
    public boolean isRenderEps() {
        return renderEps;
    }

    /**
     * @param renderOtraIps
     */
    public void setRenderOtraIps(boolean renderOtraIps) {
        this.renderOtraIps = renderOtraIps;
    }

    /**
     * @return
     */
    public boolean isRenderOtraIps() {
        return renderOtraIps;
    }

    /**
     * @param renderAplicaCausal
     */
    public void setRenderAplicaCausal(boolean renderAplicaCausal) {
        this.renderAplicaCausal = renderAplicaCausal;
    }

    /**
     * @return
     */
    public boolean isRenderAplicaCausal() {
        return renderAplicaCausal;
    }

    /**
     * @param renderEmbarazoMayor
     */
    public void setRenderEmbarazoMayor(boolean renderEmbarazoMayor) {
        this.renderEmbarazoMayor = renderEmbarazoMayor;
    }

    /**
     * @return
     */
    public boolean isRenderEmbarazoMayor() {
        return renderEmbarazoMayor;
    }

    /**
     * @param renderContinuaEmbarazo
     */
    public void setRenderContinuaEmbarazo(boolean renderContinuaEmbarazo) {
        this.renderContinuaEmbarazo = renderContinuaEmbarazo;
    }

    /**
     * @return
     */
    public boolean isRenderContinuaEmbarazo() {
        return renderContinuaEmbarazo;
    }


    /**
     * @param renderAplazaDecision
     */
    public void setRenderAplazaDecision(boolean renderAplazaDecision) {
        this.renderAplazaDecision = renderAplazaDecision;
    }

    /**
     * @return
     */
    public boolean isRenderAplazaDecision() {
        return renderAplazaDecision;
    }

    /**
     * @param renderOtraConducta
     */
    public void setRenderOtraConducta(boolean renderOtraConducta) {
        this.renderOtraConducta = renderOtraConducta;
    }

    /**
     * @return
     */
    public boolean isRenderOtraConducta() {
        return renderOtraConducta;
    }

    /**
     * @param lstIngreso
     */
    public void setLstIngreso(List lstIngreso) {
        this.lstIngreso = lstIngreso;
    }

    /**
     * @return
     */
    public List getLstIngreso() {
        if (lstIngreso == null || lstIngreso.isEmpty()) {
            lstIngreso = new ArrayList();
            ArrayList<Cningrilve> listIngresoAux = null;
            try {
                listIngresoAux = 
                        (ArrayList<Cningrilve>)this.serviceLocator.getClinicoService().getListaIngresoPor();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listIngresoAux.isEmpty()) {

                Iterator it = listIngresoAux.iterator();
                int i = 0;
                lstIngreso.add(new SelectItem("", 
                                              "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstIngreso.add(new SelectItem(listIngresoAux.get(i).getCiincodigo(), 
                                                  listIngresoAux.get(i).getCiicdescripcio()));
                    i++;
                }
            }
        }

        return lstIngreso;
    }

    /**
     * @param renderOtroIngreso
     */
    public void setRenderOtroIngreso(boolean renderOtroIngreso) {
        this.renderOtroIngreso = renderOtroIngreso;
    }

    /**
     * @return
     */
    public boolean isRenderOtroIngreso() {
        return renderOtroIngreso;
    }

    /**
     * @param listRelacionAvise
     */
    public void setListRelacionAvise(List listRelacionAvise) {
        this.listRelacionAvise = listRelacionAvise;
    }

    /**
     * @param renderRelacionFamiliar
     */
    public void setRenderRelacionFamiliar(boolean renderRelacionFamiliar) {
        this.renderRelacionFamiliar = renderRelacionFamiliar;
    }

    /**
     * @return
     */
    public boolean isRenderRelacionFamiliar() {
        return renderRelacionFamiliar;
    }

    /**
     * @param renderRelacionOtra
     */
    public void setRenderRelacionOtra(boolean renderRelacionOtra) {
        this.renderRelacionOtra = renderRelacionOtra;
    }

    /**
     * @return
     */
    public boolean isRenderRelacionOtra() {
        return renderRelacionOtra;
    }

    /**
     * @param renderOtroParentesco
     */
    public void setRenderOtroParentesco(boolean renderOtroParentesco) {
        this.renderOtroParentesco = renderOtroParentesco;
    }

    /**
     * @return
     */
    public boolean isRenderOtroParentesco() {
        return renderOtroParentesco;
    }

    /**
     * @return
     */
    public List getListRelacionAvise() {
        if (listRelacionAvise == null || listRelacionAvise.isEmpty()) {
            listRelacionAvise = new ArrayList();
            ArrayList<Cnrelacavise> listRelacionAux = null;
            try {
                listRelacionAux = 
                        (ArrayList<Cnrelacavise>)this.serviceLocator.getClinicoService().getListaRelacionAvise();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listRelacionAux.isEmpty()) {

                Iterator it = listRelacionAux.iterator();
                int i = 0;
                listRelacionAvise.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listRelacionAvise.add(new SelectItem(listRelacionAux.get(i).getCrancodigo(), 
                                                         listRelacionAux.get(i).getCracdescripcio()));
                    i++;
                }
            }
        }

        return listRelacionAvise;
    }

    /**
     * @param listParentescoFamiliar
     */
    public void setListParentescoFamiliar(List listParentescoFamiliar) {
        this.listParentescoFamiliar = listParentescoFamiliar;
    }

    /**
     * @return
     */
    public List getListParentescoFamiliar() {
        if (listParentescoFamiliar == null || 
            listParentescoFamiliar.isEmpty()) {
            listParentescoFamiliar = new ArrayList();
            ArrayList<Cnparenfamil> listRelacionAux = null;
            try {
                listRelacionAux = 
                        (ArrayList<Cnparenfamil>)this.serviceLocator.getClinicoService().getListaParentescoFamiliarAvise();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listRelacionAux.isEmpty()) {

                Iterator it = listRelacionAux.iterator();
                int i = 0;
                listParentescoFamiliar.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listParentescoFamiliar.add(new SelectItem(listRelacionAux.get(i).getCpfncodigo(), 
                                                              listRelacionAux.get(i).getCpfcdescripcio()));
                    i++;
                }
            }
        }

        return listParentescoFamiliar;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    /**
     * @return
     */
    public String guardarAsesoria() {
        boolean wexito = true;
        String nextAction = "";

        String url = "body:formAsesoriaAvise:panelTabDatosUsuario:";

        if (asesoria == null) {
            wexito = false;
        }

        // VALIDAMOS QUE EL USUARIO SELECCIONE LOS DOCUMENTOS PRESENTADOS
        if (!renderNingunDocumento && !renderDenuncia && !renderPrueba && 
            !renderPsiquica && !renderCertMedico && !renderNingunDocumento && 
            !renderRemisionOtra && !renderOtroDocumento && !renderEcografia) {

            wexito = false;
            FacesUtils.addErrorMessage(url + "checkNingunDocumento", 
                                       MSG_CAMPO_OBLIGATORIO_DOCUMENTO_PRESENTADO);

        }

        // VERIFICAMOS QUE EL USUARIO SELECCIONE LAS ACCIONES PREVIAS 

        if (renderAgresor) {
            if (!renderNingunaAccion && !renderDenunciaAccion && 
                           !renderAtencionMedica && !renderApoyoAccion && 
                           !renderAnticoncepcion && !renderOtroAccion) {

                           wexito = false;
                           FacesUtils.addErrorMessage(url + "checkNingunaAccion", 
                                                      MSG_CAMPO_OBLIGATORIO_ACCION);

                       }
        }
        

        // VERIFICAMOS QUE LA OPCION SIN ALTERACION EN EL ESTADO SOMATICO ES EXCLUYENTE 

        if (lstAreaSomaticoSelect != null && 
            !lstAreaSomaticoSelect.isEmpty()) {
            for (String areasoma: lstAreaSomaticoSelect) {
                if (areasoma.equals("SAL") && 
                    lstAreaSomaticoSelect.size() > 1) {
                    FacesUtils.addErrorMessage(url + 
                                               "mnuAreaSomaticoPsicoemocional", 
                                               "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }

        // VERIFICAMOS QUE LA OPCION SIN ALTERACION EN EL ESTADO RELACIONAL ES EXCLUYENTE 

        if (lstAreaRelacionalSelect != null && 
            !lstAreaRelacionalSelect.isEmpty()) {
            for (String arearela: lstAreaRelacionalSelect) {
                if (arearela.equals("SA") && 
                    lstAreaRelacionalSelect.size() > 1) {
                    FacesUtils.addErrorMessage(url + 
                                               "mnuAreaRelacionalPsicoemocional", 
                                               "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }

        // VERIFICAMOS QUE LA OPCION SIN ALTERACION EN EL ESTADO COGNITIVO ES EXCLUYENTE 

        if (lstAreaCognitivaSelect != null && 
            !lstAreaCognitivaSelect.isEmpty()) {
            for (String areacogn: lstAreaCognitivaSelect) {
                if (areacogn.equals("SA") && 
                    lstAreaCognitivaSelect.size() > 1) {
                    FacesUtils.addErrorMessage(url + "mnuAreaCognitiva", 
                                               "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }

        // VERIFICAMOS QUE LA OPCION SIN ALTERACION EN EL ESTADO PSICOEMOCIONAL ES EXCLUYENTE 

        if (lstAreaAfectivaSelect != null && 
            !lstAreaAfectivaSelect.isEmpty()) {
            for (String areaafect: lstAreaAfectivaSelect) {
                if (areaafect.equals("SAL") && 
                    lstAreaAfectivaSelect.size() > 1) {
                    FacesUtils.addErrorMessage(url + 
                                               "mnuAreaAfectivaPsicoemocional", 
                                               "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }
        
        // VERIFICAMOS SI EXISTE UNA ASESORIA PARA EL DIA REGISTRADO 
        
        boolean existeAsesoriaFecha = false;
        boolean existeAsesoriaPoseterior = false; 
        try {
            existeAsesoriaFecha = this.serviceLocator.getClinicoService().verificarAsesoriaDia(usuario,asesoria.getId().getHavdfecase());
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION + " " + e.getMessage());
        }


        if(existeAsesoriaFecha){
            wexito = false; 
            FacesUtils.addErrorMessage("Ya existe una asesoria para esa fecha por favor registre un seguimiento");
        }
        
        
        if(wexito){
            try {
                existeAsesoriaPoseterior = this.serviceLocator.getClinicoService().verificarAsesoriaDiaPosterior(usuario,asesoria.getId().getHavdfecase());
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + " " + e.getMessage());
            }
            
            if(existeAsesoriaPoseterior){
                wexito = false; 
                FacesUtils.addErrorMessage(" Existe Asesorias posteriores a esa fecha, No se puede registrar la asesoria");
            }
        }
        
        if (wexito) {
            // Realizamos el set del usuario que guarda 
            asesoria.setHavcusureg(userName());
            // Realizamos el set de la fecha de registor
            asesoria.setHavdfecreg(new Date());
            // Realizamos el set del estado
            asesoria.setHavcestado(ESTADO_VIGENTE);
            if (usuario != null && usuario.getHuslnumero() != null) {
                // Realizmos el set del usuario
                asesoria.getId().setHavlusuario(usuario.getHuslnumero());
            }


            if (asesoria != null) {
                // VALIDAMOS EL CONOCIMIENTO DEL PROGRAMA
                if (asesoria.getHavnconavs() != null && 
                    !asesoria.getHavnconavs().equals(6)) {
                    asesoria.setHavcotrcon(null);
                }
                // VALIDAMOS LA INTERVENCION DE LA ASESORIA
                if (asesoria.getHavndetint() != null) {
                    // VERIFICAMOS SI NO ES CAUSAL VIOLENCIA SEXUAL; O VIOLENCIA SEXUAL
                    if (!asesoria.getHavndetint().equals(13) && 
                        !asesoria.getHavndetint().equals(14)) {
                        asesoria.setHavcagrcon(null);
                        asesoria.setHavnrelagr(null);
                        asesoria.setHavnparagr(null);
                        asesoria.setHavcotrpar(null);
                        asesoria.setHavcotrrel(null);
                        asesoria.setHavnlugech(null);
                        asesoria.setHavcotrlug(null);
                        asesoria.setHavntieocu(null);
                        asesoria.setHavndiaeve(null);

                        asesoria.setHavcaccden(null);
                        asesoria.setHavcaccate(null);
                        asesoria.setHavcaccapo(null);
                      
                        asesoria.setHaveaccot(null);
                        asesoria.setHavcaccnin(null);


                    } else {
                        // SI ES VIOLENCIA SEXUAL O CAUSAL VIOLENCIA SEXUAL 

                        if (asesoria.getHavcagrcon() != null) {
                            // VERIFICAMOS SI EL AGRESOR ES CONOCIDO 
                            if (asesoria.getHavcagrcon().equals("N")) {
                                asesoria.setHavnrelagr(null);
                                asesoria.setHavnparagr(null);
                                asesoria.setHavcotrpar(null);
                                asesoria.setHavcotrrel(null);
                            } else {
                                if (!asesoria.getHavnrelagr().equals(1)) {
                                    asesoria.setHavnparagr(null);
                                    asesoria.setHavcotrpar(null);
                                }

                                if (!asesoria.getHavnrelagr().equals(6)) {
                                    asesoria.setHavcotrrel(null);
                                }

                            }

                        }

                        // VERIFICAMOS SI EL LUGAR DE LOS HECHOS ES DIFERENTE A OTRO 

                        if (asesoria.getHavnlugech() != null) {

                            if (!asesoria.getHavnlugech().equals(6)) {
                                asesoria.setHavcotrlug(null);
                            }

                        }

                        // VERIFICAMOS EL TIEMPO DE OCURRENCIA 

                        if (asesoria.getHavntieocu() != null) {
                            if (!asesoria.getHavntieocu().equals(8)) {
                                asesoria.setHavndiaeve(null);
                            }
                        }

                        // VERIFICAMOS LAS ACCIONES PREVIAS 

                        if (renderNingunaAccion) {
                            asesoria.setHavcaccden("N");
                            asesoria.setHavcaccate("N");
                            asesoria.setHavcaccapo("N");
                          
                            asesoria.setHaveaccot("N");
                            asesoria.setHavcaccnin("S");


                        } else {
                            asesoria.setHavcaccnin("N");
                            if (renderDenunciaAccion) {
                                asesoria.setHavcaccden("S");
                            } else {
                                asesoria.setHavcaccden("N");
                            }
                            
                            if (renderAnticoncepcion) {
                                   asesoria.setHaveantem("S");
                            } else {
                                 asesoria.setHaveantem("N");
                            }

                            if (renderAtencionMedica) {
                                asesoria.setHavcaccate("S");
                            } else {
                                asesoria.setHavcaccate("N");
                            }

                            if (renderApoyoAccion) {
                                asesoria.setHavcaccapo("S");
                            } else {
                                asesoria.setHavcaccapo("N");
                            }

                           
                            if (renderOtroAccion) {
                                asesoria.setHaveaccot("S");
                            } else {
                                asesoria.setHaveaccot("N");
                                asesoria.setHavcotracc(null);
                            }


                        }


                    }


                }

                if (lstAreaAfectivaSelect != null && 
                    !lstAreaAfectivaSelect.isEmpty()) {
                    asesoria.setHavetranqu("N");
                    asesoria.setHaveangust("N");
                    asesoria.setHavetriste("N");
                    asesoria.setHaveconfun("N");
                    asesoria.setHavedesori("N");
                    asesoria.setHaveansios("N");
                    asesoria.setHavesendes("N");
                    asesoria.setHaveimpote("N");
                    asesoria.setHaveagotad("N");
                    asesoria.setHavehostil("N");
                    asesoria.setHavedesesp("N");
                    asesoria.setHavedisfru("N");


                    for (String codigo: lstAreaAfectivaSelect) {
                        if (codigo != null) {
                            if (codigo.equals("TRA")) {
                                asesoria.setHavetranqu("S");
                            } else if (codigo.equals("ANG")) {
                                asesoria.setHaveangust("S");
                            } else if (codigo.equals("TRI")) {
                                asesoria.setHavetriste("S");
                            } else if (codigo.equals("CON")) {
                                asesoria.setHaveconfun("S");
                            } else if (codigo.equals("DES")) {
                                asesoria.setHavedesori("S");
                            } else if (codigo.equals("ANS")) {
                                asesoria.setHaveansios("S");
                            } else if (codigo.equals("SDD")) {
                                asesoria.setHavesendes("S");
                            } else if (codigo.equals("IMP")) {
                                asesoria.setHaveimpote("S");
                            } else if (codigo.equals("AGO")) {
                                asesoria.setHaveagotad("S");
                            } else if (codigo.equals("HOS")) {
                                asesoria.setHavehostil("S");
                            } else if (codigo.equals("DPR")) {
                                asesoria.setHavedesesp("S");
                            } else if (codigo.equals("NDN")) {
                                asesoria.setHavedisfru("S");
                            }
                        }
                    }
                }


                if (lstAreaSomaticoSelect != null && 
                    !lstAreaSomaticoSelect.isEmpty()) {
                    asesoria.setHavedolor("N");
                    asesoria.setHavehemato("N");
                    asesoria.setHavefractu("N");
                    asesoria.setHaveinsomn("N");
                    asesoria.setHaveinapet("N");
                    asesoria.setHavesendeb("N");
                    asesoria.setHaveahogo("N");
                    asesoria.setHavepalpi("N");
                    asesoria.setHavemareo("N");
                    asesoria.setHavehipera("N");


                    for (String codigo: lstAreaSomaticoSelect) {
                        if (codigo != null) {
                            if (codigo.equals("DOL")) {
                                asesoria.setHavedolor("S");
                            } else if (codigo.equals("HEM")) {
                                asesoria.setHavehemato("S");
                            } else if (codigo.equals("FRA")) {
                                asesoria.setHavefractu("S");
                            } else if (codigo.equals("INS")) {
                                asesoria.setHaveinsomn("S");
                            } else if (codigo.equals("INA")) {
                                asesoria.setHaveinapet("S");
                            } else if (codigo.equals("DEB")) {
                                asesoria.setHavesendeb("S");
                            } else if (codigo.equals("AHO")) {
                                asesoria.setHaveahogo("S");
                            } else if (codigo.equals("PAL")) {
                                asesoria.setHavepalpi("S");
                            } else if (codigo.equals("MAR")) {
                                asesoria.setHavemareo("S");
                            } else if (codigo.equals("HIP")) {
                                asesoria.setHavehipera("S");
                            }
                        }
                    }
                }


                if (lstAreaRelacionalSelect != null && 
                    !lstAreaRelacionalSelect.isEmpty()) {
                    asesoria.setHaveagresi("N");
                    asesoria.setHaveaislam("N");
                    asesoria.setHavepasmad("N");
                    asesoria.setHavereftem("N");
                    asesoria.setHavepareja("N");
                    asesoria.setHavefamili("N");
                    asesoria.setHavedesamp("N");
                    asesoria.setHavepobrez("N");
                    asesoria.setHaveviolen("N");
                    asesoria.setHavedesemp("N");


                    for (String codigo: lstAreaRelacionalSelect) {
                        if (codigo != null) {
                            if (codigo.equals("AG")) {
                                asesoria.setHaveagresi("S");
                            } else if (codigo.equals("AI")) {
                                asesoria.setHaveaislam("S");
                            } else if (codigo.equals("PA")) {
                                asesoria.setHavepasmad("S");
                            } else if (codigo.equals("FO")) {
                                asesoria.setHavereftem("S");
                            } else if (codigo.equals("CP")) {
                                asesoria.setHavepareja("S");
                            } else if (codigo.equals("CF")) {
                                asesoria.setHavefamili("S");
                            } else if (codigo.equals("DE")) {
                                asesoria.setHavedesamp("S");
                            } else if (codigo.equals("PO")) {
                                asesoria.setHavepobrez("S");
                            } else if (codigo.equals("VI")) {
                                asesoria.setHaveviolen("S");
                            } else if (codigo.equals("DPL")) {
                                asesoria.setHavedesemp("S");
                            }
                        }
                    }
                }


                if (lstAreaCognitivaSelect != null && 
                    !lstAreaCognitivaSelect.isEmpty()) {
                    asesoria.setHavedisper("N");
                    asesoria.setHavepenneg("N");
                    asesoria.setHavedifpro("N");
                    asesoria.setHaveideper("N");
                    asesoria.setHaveincme("N");
                    asesoria.setHavedificu("N");
                    asesoria.setHaveconcen("N");
                    asesoria.setHavesuicid("N");
                    asesoria.setHaveotro("N");


                    for (String codigo: lstAreaCognitivaSelect) {
                        if (codigo != null) {
                            if (codigo.equals("OT")) {
                                    asesoria.setHaveotro("S");
                            } else if (codigo.equals("DI")) {
                                asesoria.setHavedisper("S");
                            } else if (codigo.equals("PN")) {
                                asesoria.setHavepenneg("S");
                            } else if (codigo.equals("DP")) {
                                asesoria.setHavedifpro("S");
                            } else if (codigo.equals("IP")) {
                                asesoria.setHaveideper("S");
                            } else if (codigo.equals("IM")) {
                                asesoria.setHaveincme("S");
                            } else if (codigo.equals("DD")) {
                                asesoria.setHavedificu("S");
                            } else if (codigo.equals("FC")) {
                                asesoria.setHaveconcen("S");
                            } else if (codigo.equals("IS")) {
                                asesoria.setHavesuicid("S");
                            }
                        }
                    }
                }

                // VALIDACIONES DE DOCUMENTOS PRESENTADOS 

                if (renderNingunDocumento) {

                    asesoria.setHavedocden("N");
                    asesoria.setHavepruemb("N");
                    asesoria.setHavevalps("N");
                    asesoria.setHavecerme("N");
                    asesoria.setHavedoceco("N");
                    asesoria.setHavcrecotr("N");
                    asesoria.setHaveotrdoc("N");
                    asesoria.setHavcnindoc("S");
                    asesoria.setHavcrecnom(null);
                    asesoria.setHavcnomdoc(null);


                } else {
                    asesoria.setHavedocden("N");
                    asesoria.setHavepruemb("N");
                    asesoria.setHavevalps("N");
                    asesoria.setHavecerme("N");
                    asesoria.setHavedoceco("N");
                    asesoria.setHavcrecotr("N");
                    asesoria.setHaveotrdoc("N");
                    asesoria.setHavcnindoc("N");


                    if (renderDenuncia) {
                        asesoria.setHavedocden("S");
                    }

                    if (renderPrueba) {
                        asesoria.setHavepruemb("S");
                    }

                    if (renderPsiquica) {
                        asesoria.setHavevalps("S");
                    }

                    if (renderCertMedico) {
                        asesoria.setHavecerme("S");
                    }

                    if (renderEcografia) {
                        asesoria.setHavedoceco("S");
                    }

                    if (renderRemisionOtra) {
                        asesoria.setHavcrecotr("S");
                    } else {
                        asesoria.setHavcrecnom(null);
                    }

                    if (renderOtroDocumento) {
                        asesoria.setHaveotrdoc("S");
                    } else {
                        asesoria.setHavcnomdoc(null);
                    }

                }

                // SE REALIZAN LAS VALIDACIONES DE LA CONDUCTA 

  
                asesoria.setHavcremotr("N");
                asesoria.setHavcremind("N");
                asesoria.setHavcremcos("N");
                asesoria.setHavcremeps("N");
                asesoria.setHavcremips("N");
                asesoria.setHavcremcau("N");
                asesoria.setHavcremmay("N");
                asesoria.setHavcremcon("N");
                asesoria.setHavcremotr("N");
                asesoria.setHavcremilv("N");
                asesoria.setHavcremapl("N");


              
              


                if (renderRemitirIlve) {
                    asesoria.setHavcremilv("S");
                }

                if (renderIndecision) {
                    asesoria.setHavcremind("S");
                }

                if (renderCostoAlto) {
                    asesoria.setHavcremcos("S");
                }

                if (renderEps) {
                    asesoria.setHavcremeps("S");
                }

                if (renderOtraIps) {
                    asesoria.setHavcremips("S");
                }

                if (renderAplicaCausal) {
                    asesoria.setHavcremcau("S");
                }

                if (renderEmbarazoMayor) {
                    asesoria.setHavcremmay("S");
                } else {
                    asesoria.setHavnedages(null);
                }

                if (renderContinuaEmbarazo) {
                    asesoria.setHavcremcon("S");
                }

                if (renderOtraConducta) {
                    asesoria.setHavcremotr("S");
                } else {
                    asesoria.setHavcnmbotr(null);
                }


                if (renderAplazaDecision) {
                    asesoria.setHavcremapl("S");
                } else {
                    asesoria.setHavcremmot(null);
                }


            }

            if (usuario != null && usuario.getHusanumeiden() != null && 
                usuario.getHusetipoiden() != null) {
                asesoria.setHavanumide(usuario.getHusanumeiden());
                asesoria.setHavctipide(usuario.getHusetipoiden());
                asesoria.setHavnescola(usuario.getHusnniveledu());
                asesoria.setHavnedad(usuario.getEdad());

            }
            asesoria.setHavnclinic(this.getClinica().getCclncodigo());


            try {
                this.serviceLocator.getClinicoService().saveAsesoriaAvise(asesoria);
                FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
                FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
                FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
                FacesUtils.resetManagedBean("mnuAsesoriaBean");
                nextAction = BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIA;
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }


        }


        return nextAction;
    }


   

    public void setItConceptoPsicologico(UIInput itConceptoPsicologico) {
        this.itConceptoPsicologico = itConceptoPsicologico;
    }

    public UIInput getItConceptoPsicologico() {
        return itConceptoPsicologico;
    }
    
   

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }
}
