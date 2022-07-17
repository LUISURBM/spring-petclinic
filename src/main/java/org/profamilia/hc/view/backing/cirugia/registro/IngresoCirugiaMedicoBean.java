//=======================================================================
// ARCHIVO IngresoCirugiaMedicoBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================

package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chingresomed;
import org.profamilia.hc.model.dto.ChingresomedPK;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuIngresoMedicoBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE IngresoCirugiaMedicoBean
//=======================================================================

public class IngresoCirugiaMedicoBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chcirugprogr cirugia;

    private List listTipoIdentificacion;

    private List listSexos;

    private List listEstadoCivil;

    private List lstCirugias;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtCirugias;

    private Chingresomed ingreso;

    private String diagnosticoPrincipal;

    private boolean mostrarCie10;

    private int selectedIndex;

    private UIInput itDiagpreo;

    private UIInput itDiagdetec;

    private boolean esFebril;

    private List<SelectItem> lstTemperatura;

    private String diagnosticoDetectado;


    static final int ACTIVAR_IMPRESION_DIAGNOSTICA = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private String nextAction;

    private String menuBean;
    
    private UIInput itDescripcion; 
    
    private boolean renderPlantilla; 
    
    static final int ACTIVAR_APLICACION = 0;

     static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public IngresoCirugiaMedicoBean() {
    }

    public void init() {
        listTipoIdentificacion = new ArrayList();
        listSexos = new ArrayList();
        listEstadoCivil = new ArrayList();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        lstTemperatura = new ArrayList<SelectItem>();

        if (cirugia != null) {
            try {
                ingreso = 
                        this.serviceLocator.getClinicoService().getIngresoMedico(cirugia.getHcplnumero());
                        
                if(cirugia.getChdetacirpros()!= null && !cirugia.getChdetacirpros().isEmpty()){
                    Chdetacirpro detalle = null; 
                    Iterator it = cirugia.getChdetacirpros().iterator(); 
                    while(it.hasNext()){
                        detalle = (Chdetacirpro)it.next(); 
                        
                        if(detalle!= null && detalle.getId()!= null && detalle.getId().getHdccservicio() != null){
                            Cpservicio servicio = this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio()); 
                            lstCirugias.add(servicio); 
                        }
                    }
                }
                        
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (ingreso == null) {
                ingreso = new Chingresomed();
            }
        }
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


    /**
     * @param diagnosticoPrincipal
     */
    public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    /**
     * @return
     */
    public String getDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
    }

    /**
     * @param mostrarCie10
     */
    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    /**
     * @return
     */
    public boolean isMostrarCie10() {
        return mostrarCie10;
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param ingreso
     */
    public void setIngreso(Chingresomed ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return
     */
    public Chingresomed getIngreso() {
        return ingreso;
    }

    /**
     * @param renderPlantilla
     */
    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    /**
     * @return
     */
    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }

    /**
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    /**
     * @param itDiagpreo
     */
    public void setItDiagpreo(UIInput itDiagpreo) {
        this.itDiagpreo = itDiagpreo;
    }

    /**
     * @return
     */
    public UIInput getItDiagpreo() {
        return itDiagpreo;
    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
    public List getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }


    /**
     * @param param
     */
    public void setListSexos(List param) {
        this.listSexos = param;
    }

    /**
     * @return La lista de los sexos que existen
     */
    public List getListSexos() {
        if (listSexos.size() == 0) {
            ArrayList<Chsexo> listSexoAux = null;
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;

                }
            }
        }
        return listSexos;
    }


    /**
     * @param listEstadoCivil
     */
    public void setListEstadoCivil(List listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List getListEstadoCivil() {
        if (listEstadoCivil.size() == 0) {
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }

    /**
     * @param esFebril
     */
    public void setEsFebril(boolean esFebril) {
        this.esFebril = esFebril;
    }

    /**
     * @return
     */
    public boolean isEsFebril() {
        return esFebril;
    }

    /**
     * @param itDiagdetec
     */
    public void setItDiagdetec(UIInput itDiagdetec) {
        this.itDiagdetec = itDiagdetec;
    }

    /**
     * @return
     */
    public UIInput getItDiagdetec() {
        return itDiagdetec;
    }

    /**
     * @param diagnosticoDetectado
     */
    public void setDiagnosticoDetectado(String diagnosticoDetectado) {
        this.diagnosticoDetectado = diagnosticoDetectado;
    }

    /**
     * @return
     */
    public String getDiagnosticoDetectado() {
        return diagnosticoDetectado;
    }

    /**
     * @param lstTemperatura
     */
    public void setLstTemperatura(List<SelectItem> lstTemperatura) {
        this.lstTemperatura = lstTemperatura;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstTemperatura() {
        if (lstTemperatura.size() == 0) {
            lstTemperatura.add(new SelectItem("", "Seleccione una opci�n"));
            lstTemperatura.add(new SelectItem("A", "Afebril"));
            lstTemperatura.add(new SelectItem("F", "Febril"));
        }
        return lstTemperatura;
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
     * @param itDescripcion
     */
    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    /**
     * @return
     */
    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
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
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            ingreso.setHimcobservacio(buscador.getPlantillaSelect().getHplcdescripcio());
           
        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
    }

    //-----------------------------------------------------------------------
    //  EsValido
    //-----------------------------------------------------------------------  


    public boolean esValido() {
        boolean esValido = false;
        Chingresomed ingresoAux = null;
        if (cirugia != null) {
            try {
                ingresoAux = 
                        this.serviceLocator.getClinicoService().getIngresoMedico(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (ingresoAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------  


    public String RegistrarIngreso() {
        ChingresomedPK id = new ChingresomedPK();
        MenuIngresoMedicoBean menu = 
            (MenuIngresoMedicoBean)FacesUtils.getManagedBean("menuIngresoMedicoBean");


        if (lstCirugias != null && !lstCirugias.isEmpty()) {
            String cirugiasProgramadas = "";
            Cpservicio servicioAux;
            servicioAux = null;
            Iterator it = lstCirugias.iterator();
            while (it.hasNext()) {
                servicioAux = (Cpservicio)it.next();

                if (servicioAux != null) {
                    cirugiasProgramadas = 
                            cirugiasProgramadas + servicioAux.getCsvccodigo() + 
                            ",";
                }
            }


            if (cirugiasProgramadas != null && 
                cirugiasProgramadas.length() > 0) {

                cirugiasProgramadas = 
                        cirugiasProgramadas.substring(0, cirugiasProgramadas.length() - 
                                                      1);
            }


            if (cirugiasProgramadas != null) {
                ingreso.setHimcintervenci(cirugiasProgramadas);
            }

        }

        if (ingreso != null && cirugia != null) {
            id.setHimctiposervi(TIPO_HOSPITALIZACION);
            id.setHimlnumero(cirugia.getHcplnumero());
            ingreso.setId(id);
            ingreso.setHimlusuario(cirugia.getHcplusuario().getHuslnumero());
            ingreso.setHimdfecregistr(new Date());
            ingreso.setHimcestado(ESTADO_REGISTRO);
            ingreso.setHimcoperador(userName());
            
        }

        try {
            this.serviceLocator.getClinicoService().saveIngresoMedico(ingreso);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            menu.init();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }

        return BeanNavegacion.RUTA_ACTUAL;
    }


    
}
