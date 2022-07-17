package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.ChcontroliquPK;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class IngresoLiquidosBean extends BaseBean {

    private Chcontroliqu liquidos;

    private List lstOpciones;

    private boolean mostrarCanalizacion;

    private List lstTipoLiquido;

    private List lstLocalizacion;

    private List lstVia;

    private List lstLiquidoParentales;

    private String liquidoSelect;

    private List<Chcontroliqu> lstLiquidosSelect;

    private HtmlDataTable dtLiquidos;

    private boolean mostrarParenterales;

    private boolean mostrarCantidad;

    private UIInput mnuVia;

    private UIInput mnuTipoLiquidosParentales;

    private boolean mostrarOral;

    private Chcirugprogr cirugia;

    private boolean esIngreso;

    private List lstCirugias;

    private HtmlDataTable dtCirugias;

    private boolean mostrarHoraActual;

    private List lstMiembroSuperior;

    private Date fechaAdministracion;

    private String esHoraActual;

    private List lstLiquidosAdministrados;

    private List lstTipoCateter;

    private String menuBean;

    private List lstClaseSangre;

    private List lstFactorSangre;

    private List lstGrupoSangre;

    private boolean renderSangre;

    private Integer tiempoAdministracion;
    
    private String tipoServicio;
    
    private boolean notaEnfeProce;
    
    private String legendServicio;
    
    private List<Cnconsclin> lstConsclin;


    public IngresoLiquidosBean() {
    }

    public void init() {
        liquidos = new Chcontroliqu();
        lstTipoLiquido = new ArrayList();
        lstVia = new ArrayList();
        lstLiquidoParentales = new ArrayList();
        lstLiquidosSelect = new ArrayList<Chcontroliqu>();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        lstLiquidosAdministrados = new ArrayList();
        mostrarCanalizacion = false;
        mostrarParenterales = false;
        mostrarCantidad = false;
        mostrarOral = false;
        mostrarHoraActual = false;
        legendServicio="Cirugia(s) Programada(s)";

        if (cirugia != null) {
            
            if(notaEnfeProce){
                legendServicio="Procedimiento(s)";
                try {
                    lstConsclin = 
                            this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                // Cargamos los procedimientos
                if (lstConsclin != null && !lstConsclin.isEmpty()) {
                    Iterator it = lstConsclin.iterator();
                    Cnconsclin conclin;

                    while (it.hasNext()) {
                        conclin = (Cnconsclin)it.next();
                        lstCirugias.add(conclin.getCcocservic());
                    }
                }
            }

            if (cirugia.getChdetacirpros() != null && 
                !cirugia.getChdetacirpros().isEmpty()) {
                Chdetacirpro detalle = null;
                Iterator it = cirugia.getChdetacirpros().iterator();
                while (it.hasNext()) {
                    detalle = (Chdetacirpro)it.next();

                    if (detalle != null && detalle.getId() != null && 
                        detalle.getId().getHdccservicio() != null) {
                        Cpservicio servicio;
                        servicio = null;
                        try {
                            servicio = 
                                    this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                        lstCirugias.add(servicio);
                    }
                }
            }


        }
        //TODO: VERIFICAR PROCESO
        if (lstLiquidosSelect == null || lstLiquidosSelect.isEmpty()) {
            lstLiquidosSelect = new ArrayList<Chcontroliqu>();
        }
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
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }


    /**
     * @param lstClaseSangre
     */
    public void setLstClaseSangre(List lstClaseSangre) {
        this.lstClaseSangre = lstClaseSangre;
    }

    /**
     * @return
     */
    public List getLstClaseSangre() {
        if (lstClaseSangre == null) {
            lstClaseSangre = new ArrayList();
            lstClaseSangre.add(new SelectItem("", "Seleccione.."));
            lstClaseSangre.add(new SelectItem("ST", "Sangre Total"));
            lstClaseSangre.add(new SelectItem("GR", "Globulos Rojos"));
            lstClaseSangre.add(new SelectItem("PL", "Plasma"));
        }
        return lstClaseSangre;
    }

    /**
     * @param lstFactorSangre
     */
    public void setLstFactorSangre(List lstFactorSangre) {
        this.lstFactorSangre = lstFactorSangre;
    }

    /**
     * @return
     */
    public List getLstFactorSangre() {
        if (lstFactorSangre == null) {
            lstFactorSangre = new ArrayList();
            lstFactorSangre.add(new SelectItem("P", "+"));
            lstFactorSangre.add(new SelectItem("N", "-"));
        }
        return lstFactorSangre;
    }


    public void setLstGrupoSangre(List lstGrupoSangre) {
        this.lstGrupoSangre = lstGrupoSangre;
    }

    public List getLstGrupoSangre() {
        if (lstGrupoSangre == null) {
            lstGrupoSangre = new ArrayList();
            lstGrupoSangre.add(new SelectItem("A", "A"));
            lstGrupoSangre.add(new SelectItem("AB", "AB"));
            lstGrupoSangre.add(new SelectItem("B", "B"));
            lstGrupoSangre.add(new SelectItem("O", "O"));

        }
        return lstGrupoSangre;
    }

    public void setRenderSangre(boolean renderSangre) {
        this.renderSangre = renderSangre;
    }

    public boolean isRenderSangre() {
        return renderSangre;
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
     * @param fechaAdministracion
     */
    public void setFechaAdministracion(Date fechaAdministracion) {
        this.fechaAdministracion = fechaAdministracion;
    }

    /**
     * @return
     */
    public Date getFechaAdministracion() {
        return fechaAdministracion;
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
     * @param lstTipoLiquido
     */
    public void setLstTipoLiquido(List lstTipoLiquido) {
        this.lstTipoLiquido = lstTipoLiquido;
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
     * @return
     */
    public List getLstTipoLiquido() {
        if (lstTipoLiquido.size() == 0) {
            lstTipoLiquido.add(new SelectItem("PA", "Parenterales"));
            lstTipoLiquido.add(new SelectItem("OR", "Oral o Tubo"));
        }
        return lstTipoLiquido;
    }

    /**
     * @param lstMiembroSuperior
     */
    public void setLstMiembroSuperior(List lstMiembroSuperior) {
        this.lstMiembroSuperior = lstMiembroSuperior;
    }

    /**
     * @return
     */
    public List getLstMiembroSuperior() {
        if (lstMiembroSuperior == null) {
            lstMiembroSuperior = new ArrayList();
            lstMiembroSuperior.add(new SelectItem("B", "Brazo"));
            lstMiembroSuperior.add(new SelectItem("A", "Antebrazo"));
            lstMiembroSuperior.add(new SelectItem("M", "Mano"));

        }
        return lstMiembroSuperior;
    }


    /**
     * @param lstVia
     */
    public void setLstVia(List lstVia) {
        this.lstVia = lstVia;
    }

    /**
     * @return
     */
    public List getLstVia() {
        if (lstVia.size() == 0) {
            lstVia.add(new SelectItem("IV", "Intravenosa"));
            lstVia.add(new SelectItem("IO", "Intra�sea"));
        }
        return lstVia;
    }

    /**
     * @param lstLiquidoParentales
     */
    public void setLstLiquidoParentales(List lstLiquidoParentales) {
        this.lstLiquidoParentales = lstLiquidoParentales;
    }

    /**
     * @return
     */
    public List getLstLiquidoParentales() {
        if (lstLiquidoParentales.size() == 0) {
            lstLiquidoParentales.add(new SelectItem("", 
                                                    "Seleccione una opci�n..."));
            lstLiquidoParentales.add(new SelectItem("01", 
                                                    "Lactato de Ringer"));
            lstLiquidoParentales.add(new SelectItem("02", 
                                                    "Haemacell"));
            lstLiquidoParentales.add(new SelectItem("03", 
                                                    "Dextranes"));
            lstLiquidoParentales.add(new SelectItem("04", 
                                                    "Globulos Rojos"));
            lstLiquidoParentales.add(new SelectItem("05", 
                                                    "Sangre total"));
            lstLiquidoParentales.add(new SelectItem("06", 
                                                    "Plasma"));
            lstLiquidoParentales.add(new SelectItem("07", "Plaquetas"));
        }
        return lstLiquidoParentales;
    }

    /**
     * @param liquidoSelect
     */
    public void setLiquidoSelect(String liquidoSelect) {
        this.liquidoSelect = liquidoSelect;
    }

    /**
     * @return
     */
    public String getLiquidoSelect() {
        return liquidoSelect;
    }

    /**
     * @param dtLiquidos
     */
    public void setDtLiquidos(HtmlDataTable dtLiquidos) {
        this.dtLiquidos = dtLiquidos;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidos() {
        return dtLiquidos;
    }

    /**
     * @param lstLocalizacion
     */
    public void setLstLocalizacion(List lstLocalizacion) {
        this.lstLocalizacion = lstLocalizacion;
    }

    /**
     * @return
     */
    public List getLstLocalizacion() {
        if (lstLocalizacion == null) {
            lstLocalizacion = new ArrayList();
            lstLocalizacion.add(new SelectItem("D", "Derecho"));
            lstLocalizacion.add(new SelectItem("I", "Izquierdo"));
        }
        return lstLocalizacion;
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
     * @param lstTipoCateter
     */
    public void setLstTipoCateter(List lstTipoCateter) {
        this.lstTipoCateter = lstTipoCateter;
    }

    /**
     * @return
     */
    public List getLstTipoCateter() {
        if (lstTipoCateter == null) {
            lstTipoCateter = new ArrayList();
            lstTipoCateter.add(new SelectItem("P", "Pericraneal"));
            lstTipoCateter.add(new SelectItem("C", 
                                              "Cat�ter por fuera de aguja"));
        }
        return lstTipoCateter;
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
     * @param mostrarCantidad
     */
    public void setMostrarCantidad(boolean mostrarCantidad) {
        this.mostrarCantidad = mostrarCantidad;
    }

    /**
     * @return
     */
    public boolean isMostrarCantidad() {
        return mostrarCantidad;
    }

    /**
     * @param mostrarParenterales
     */
    public void setMostrarParenterales(boolean mostrarParenterales) {
        this.mostrarParenterales = mostrarParenterales;
    }

    /**
     * @return
     */
    public boolean isMostrarParenterales() {
        return mostrarParenterales;
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
     * @param lstLiquidosSelect
     */
    public void setLstLiquidosSelect(List<Chcontroliqu> lstLiquidosSelect) {
        this.lstLiquidosSelect = lstLiquidosSelect;
    }

    /**
     * @return
     */
    public List<Chcontroliqu> getLstLiquidosSelect() {
        return lstLiquidosSelect;
    }

    /**
     * @param mnuVia
     */
    public void setMnuVia(UIInput mnuVia) {
        this.mnuVia = mnuVia;
    }

    /**
     * @return
     */
    public UIInput getMnuVia() {
        return mnuVia;
    }

    /**
     * @param mnuTipoLiquidosParentales
     */
    public void setMnuTipoLiquidosParentales(UIInput mnuTipoLiquidosParentales) {
        this.mnuTipoLiquidosParentales = mnuTipoLiquidosParentales;
    }

    /**
     * @return
     */
    public UIInput getMnuTipoLiquidosParentales() {
        return mnuTipoLiquidosParentales;
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
     * @param esIngreso
     */
    public void setEsIngreso(boolean esIngreso) {
        this.esIngreso = esIngreso;
    }

    /**
     * @return
     */
    public boolean isEsIngreso() {
        return esIngreso;
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
     * @param mostrarOral
     */
    public void setMostrarOral(boolean mostrarOral) {
        this.mostrarOral = mostrarOral;
    }

    /**
     * @return
     */
    public boolean isMostrarOral() {
        return mostrarOral;
    }


    /**
     * @param mostrarCanalizacion
     */
    public void setMostrarCanalizacion(boolean mostrarCanalizacion) {
        this.mostrarCanalizacion = mostrarCanalizacion;
    }

    /**
     * @return
     */
    public boolean isMostrarCanalizacion() {
        return mostrarCanalizacion;
    }

    /**
     * @param lstLiquidosAdministrados
     */
    public void setLstLiquidosAdministrados(List lstLiquidosAdministrados) {
        this.lstLiquidosAdministrados = lstLiquidosAdministrados;
    }

    /**
     * @return
     */
    public List getLstLiquidosAdministrados() {
        return lstLiquidosAdministrados;
    }

    // Value Change Listener

    public void setLiquidoSelect(ValueChangeEvent valueChangeEvent) {
        setLiquidoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }


    /**
     * @param valueChangeEvent
     */
    public void setHclctipoliquid(ValueChangeEvent valueChangeEvent) {
        liquidos.setHclctipoliquid((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    // Acciones Data Table   

    public void agregarLiquido() {
        if (liquidos != null && liquidos.getHclctipoliquid() != null) {

            if (liquidos.getHclctipoliquid().equals("PA") || 
                liquidos.getHclctipoliquid().equals("OR")) {
                boolean wexito = true;
                Chcontroliqu liquidoAux;
                liquidoAux = new Chcontroliqu();
                ChcontroliquPK idControl;
                idControl = new ChcontroliquPK();
                idControl.setHcllnumero(cirugia.getHcplnumero());
                idControl.setHclctiposervi(TIPO_HOSPITALIZACION);
                if (liquidos.getHclctipoliquid().equals("PA")) {
                    liquidoAux.setHclcetapa(ESTADO_VIGENTE);
                } else {
                    liquidoAux.setHclcetapa(ETAPA_ATENDIDO);
                }

                liquidoAux.setId(idControl);
                liquidoAux.setHclctipoliqpar(liquidoSelect);
                liquidoAux.setHclctipoliquid(liquidos.getHclctipoliquid());
                liquidoAux.setHclcoperador(userName());
                liquidoAux.setHclcotroliqpar(liquidos.getHclcotroliqpar());
                liquidoAux.setHclcvialiquido(liquidos.getHclcvialiquido());
                liquidoAux.setHclncantidad(liquidos.getHclncantidad());
                liquidoAux.setHcldfechactivi(liquidos.getHcldfechactivi());
                liquidoAux.setHcldfecregistr(new Date());
                liquidoAux.setHclcotroliqpar(ETAPA_INGRESO);
                liquidoAux.setHclnclinica(getClinica().getCclncodigo());
                liquidoAux.setHclctipoliqadm(liquidos.getHclctipoliqadm());
                liquidoAux.setHclcvialiquido(liquidos.getHclcvialiquido());


                if (esHoraActual != null && esHoraActual.equals("N") && 
                    tiempoAdministracion != null) {
                    Calendar fechaCalendarAdmin;
                    fechaCalendarAdmin = Calendar.getInstance();
                    fechaCalendarAdmin.setTime(new Date());
                    fechaCalendarAdmin.add(Calendar.MINUTE, 
                                           (tiempoAdministracion * -1));
                    liquidoAux.setHcldfechactivi(fechaCalendarAdmin.getTime());
                } else {
                    liquidoAux.setHcldfechactivi(new Date());
                }


                if (wexito) {
                    if (tipoServicio != null) {
                        liquidoAux.getId().setHclctiposervi(tipoServicio);
                    }
                    lstLiquidosSelect.add(liquidoAux);
                    liquidoSelect = null;
                    liquidos.setHclctipoliqadm(null);
                    liquidos.setHclncantidad(null);
                    liquidos.setHclcvialiquido(null);
                    liquidos.setHclctipoliquid(null);
                    mostrarCantidad = false;
                    mostrarOral = false;
                    mostrarParenterales = false;
                    mostrarHoraActual = false;
                    fechaAdministracion = null;
                    esHoraActual = "";

                }


            }


        }

    }

    public void eliminarLiquido() {
        Chcontroliqu liquidoDelete = (Chcontroliqu)dtLiquidos.getRowData();
        lstLiquidosSelect.remove(liquidoDelete);
    }

    // Acciones AJAX

    public void ChangeTipoLiquido() {
        if (liquidos.getHclctipoliquid() != null) {
            mostrarCantidad = true;
            liquidoSelect = null;
            liquidos.setHclctipoliqadm(null);
            liquidos.setHclncantidad(null);
            liquidos.setHclcvialiquido(null);

            if (liquidos.getHclctipoliquid().equals("PA")) {
                mostrarParenterales = true;
                mostrarOral = false;

            } else {
                liquidos.setHclcvialiquido(null);
                mnuVia.setValue(null);
                mnuTipoLiquidosParentales.setValue("");
                mostrarParenterales = false;
                mostrarOral = true;
            }
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setEsHoraActual(ValueChangeEvent valueChangeEvent) {
        setEsHoraActual((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEsHoraActual() {
        if (esHoraActual != null && esHoraActual.equals("N")) {
            mostrarHoraActual = true;
        } else {
            mostrarHoraActual = false;
        }
    }

    public void ChangeSangre() {
        if (liquidoSelect != null && liquidoSelect.equals("06")) {
            renderSangre = true;
        } else {
            renderSangre = false;
        }
    }


    // Boton Principal

    /**
     * @return
     */
    public String IngresoLiquidos() {


        try {
        
            this.serviceLocator.getClinicoService().saveLstRegistroLiquidos(lstLiquidosSelect, 
                                                                            cirugia.getHcplnumero(), 
                                                                            null);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }


        if (esIngreso) {

            return BeanNavegacion.RUTA_ACTUAL;
        } else {
            return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIOS_INGRESADOS;
        }

    }


    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendServicio(String legendServicio) {
        this.legendServicio = legendServicio;
    }

    public String getLegendServicio() {
        return legendServicio;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }
}
