//=======================================================================
// ARCHIVO AdministracionLiquidosBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE AdministracionLiquidosBean
//=======================================================================

public class AdministracionLiquidosBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chcirugprogr cirugia;

    private Chcontroliqu liquidos;

    private List listTipoIdentificacion;

    private List listSexos;

    private List listEstadoCivil;

    private String esHoraActual;

    private List lstOpciones;

    private boolean mostrarHoraActual;

    private String horaSelect;

    private String minutoSelect;

    private List lstMinutos;

    private List listHora;

    private String opcionLiquido;

    private List lstOpcionesLiquidos;

    private boolean esSuspencion;

    private boolean wexito;
    
    private Integer tiempoAdministracion; 
    
    private String navegationRule; 
    
    private String nextAction; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    public AdministracionLiquidosBean() {
    }

    public void init() {
        listTipoIdentificacion = new ArrayList();
        listSexos = new ArrayList();
        listEstadoCivil = new ArrayList();
        lstOpciones = new ArrayList();
        lstMinutos = new ArrayList();
        listHora = new ArrayList();

        lstOpcionesLiquidos = new ArrayList();
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


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
     * @param liquidos
     */
    public void setLiquidos(Chcontroliqu liquidos) {
        this.liquidos = liquidos;
    }

    /**
     * @return
     */
    public Chcontroliqu getLiquidos() {
        return liquidos;
    }


    /**
     * @param esHoraActual
     */
    public void setEsHoraActual(String esHoraActual) {
        this.esHoraActual = esHoraActual;
    }

    /**
     * @return
     */
    public String getEsHoraActual() {
        return esHoraActual;
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
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }


    /**
     * @param mostrarHoraActual
     */
    public void setMostrarHoraActual(boolean mostrarHoraActual) {
        this.mostrarHoraActual = mostrarHoraActual;
    }

    /**
     * @return
     */
    public boolean isMostrarHoraActual() {
        return mostrarHoraActual;
    }

   

    /**
     * @param horaSelect
     */
    public void setHoraSelect(String horaSelect) {
        this.horaSelect = horaSelect;
    }

    /**
     * @return
     */
    public String getHoraSelect() {
        return horaSelect;
    }

    /**
     * @param minutoSelect
     */
    public void setMinutoSelect(String minutoSelect) {
        this.minutoSelect = minutoSelect;
    }

    /**
     * @return
     */
    public String getMinutoSelect() {
        return minutoSelect;
    }

    /**
     * @param lstMinutos
     */
    public void setLstMinutos(List lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List getLstMinutos() {
        if (lstMinutos.size() == 0) {
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem("00", "00"));
            lstMinutos.add(new SelectItem("05", "05"));
            lstMinutos.add(new SelectItem("10", "10"));
            lstMinutos.add(new SelectItem("15", "15"));
            lstMinutos.add(new SelectItem("20", "20"));
            lstMinutos.add(new SelectItem("25", "25"));
            lstMinutos.add(new SelectItem("30", "30"));
            lstMinutos.add(new SelectItem("35", "35"));
            lstMinutos.add(new SelectItem("40", "40"));
            lstMinutos.add(new SelectItem("45", "45"));
            lstMinutos.add(new SelectItem("50", "50"));
            lstMinutos.add(new SelectItem("55", "55"));
        }
        return lstMinutos;
    }


    /**
     * @param listHora
     */
    public void setListHora(List listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List getListHora() {
        if (listHora.size() == 0) {
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem("00", "00"));
            listHora.add(new SelectItem("01", "01"));
            listHora.add(new SelectItem("02", "02"));
            listHora.add(new SelectItem("03", "03"));
            listHora.add(new SelectItem("04", "04"));
            listHora.add(new SelectItem("05", "05"));
            listHora.add(new SelectItem("06", "06"));
            listHora.add(new SelectItem("07", "07"));
            listHora.add(new SelectItem("08", "08"));
            listHora.add(new SelectItem("09", "09"));
            listHora.add(new SelectItem("10", "10"));
            listHora.add(new SelectItem("11", "11"));
            listHora.add(new SelectItem("12", "12"));
            listHora.add(new SelectItem("13", "13"));
            listHora.add(new SelectItem("14", "14"));
            listHora.add(new SelectItem("15", "15"));
            listHora.add(new SelectItem("16", "16"));
            listHora.add(new SelectItem("17", "17"));
            listHora.add(new SelectItem("18", "18"));
            listHora.add(new SelectItem("19", "19"));
            listHora.add(new SelectItem("20", "20"));
            listHora.add(new SelectItem("21", "21"));
            listHora.add(new SelectItem("22", "22"));
            listHora.add(new SelectItem("23", "23"));

        }
        return listHora;
    }

    /**
     * @param opcionLiquido
     */
    public void setOpcionLiquido(String opcionLiquido) {
        this.opcionLiquido = opcionLiquido;
    }

    /**
     * @return
     */
    public String getOpcionLiquido() {
        return opcionLiquido;
    }

    /**
     * @param tiempoAdministracion
     */
    public void setTiempoAdministracion(Integer tiempoAdministracion) {
        this.tiempoAdministracion = tiempoAdministracion;
    }

    /**
     * @return
     */
    public Integer getTiempoAdministracion() {
        return tiempoAdministracion;
    }

    /**
     * @param lstOpcionesLiquidos
     */
    public void setLstOpcionesLiquidos(List lstOpcionesLiquidos) {
        this.lstOpcionesLiquidos = lstOpcionesLiquidos;
    }

    /**
     * @return
     */
    public List getLstOpcionesLiquidos() {
        if (lstOpcionesLiquidos.size() == 0) {
            lstOpcionesLiquidos.add(new SelectItem("C", "Completado"));
            lstOpcionesLiquidos.add(new SelectItem("S", "Suspendido"));

        }
        return lstOpcionesLiquidos;
    }

    /**
     * @param esSuspencion
     */
    public void setEsSuspencion(boolean esSuspencion) {
        this.esSuspencion = esSuspencion;
    }

    /**
     * @return
     */
    public boolean isEsSuspencion() {
        return esSuspencion;
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


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void ChangeOpcionLiquido() {
        if (opcionLiquido != null && opcionLiquido.equals("S")) {
            esSuspencion = true;
        } else {
            esSuspencion = false;
        }
    }

    public void ChangeEsHoraActual() {
        if (esHoraActual != null && esHoraActual.equals("N")) {
            mostrarHoraActual = true;
        } else {
            mostrarHoraActual = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setOpcionLiquido(ValueChangeEvent valueChangeEvent) {
        setOpcionLiquido((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setEsHoraActual(ValueChangeEvent valueChangeEvent) {
        setEsHoraActual((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------  


    /**
     * @return
     */
    public String AdministrarLiquidos() {
    
      
        wexito = true;
        nextAction = ""; 

        if (esHoraActual != null && esHoraActual.equals("N") && tiempoAdministracion != null) {
            
                 Calendar fechaCalendarAdmin;
                 fechaCalendarAdmin = Calendar.getInstance();
                 fechaCalendarAdmin.setTime(new Date());
                 fechaCalendarAdmin.add(Calendar.MINUTE, (tiempoAdministracion * -1));
                 liquidos.setHcldfechactfin(fechaCalendarAdmin.getTime());
     
        } else {
            liquidos.setHcldfechactfin(new Date());
        }

        if (opcionLiquido != null && opcionLiquido.equals("S")) {
            liquidos.setHclcetapa(ETAPA_SUSPENDER);
            if (liquidos.getHclncantidad() != null && 
                liquidos.getHclncantisumin() != null) {
                if (liquidos.getHclncantisumin().compareTo(liquidos.getHclncantidad()) > 
                    0) {
                    FacesUtils.addErrorMessage("body:formAdministrarLiquidos:panelTabadministracionLiquidos:itCantidadTotal", 
                                               "Error La Cantidad Suspendida no puede ser mayor a la Cantidad Inicial ");
                    wexito = false;
                }
            }
        } else {
            liquidos.setHclcetapa(ETAPA_ATENDIDO);
            liquidos.setHclncantisumin(liquidos.getHclncantidad());
        }

        liquidos.setHclcoperadmodif(userName());


        if (wexito) {
            ControlLiquidosBean controlBean = 
                (ControlLiquidosBean)FacesUtils.getManagedBean("controlLiquidosBean");
            try {
            
                        
                this.serviceLocator.getClinicoService().updateLiquidoAdministrado(liquidos);
                nextAction = navegationRule; 
                if (controlBean != null) {
                    controlBean.setCirugia(cirugia);
                    controlBean.init();
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
            FacesUtils.resetManagedBean("administracionLiquidosBean");
            return nextAction;
        } else {
            return BeanNavegacion.RUTA_ACTUAL;
        }


    }


   
}
