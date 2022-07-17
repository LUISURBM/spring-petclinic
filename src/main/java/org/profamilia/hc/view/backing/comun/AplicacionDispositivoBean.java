//=======================================================================
// ARCHIVO AplicacionDispositivoBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la conducta de aplicaci�n y retiro del dispositivo
// patologica.
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.CfdetafacturaPK;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdispoaplic;
import org.profamilia.hc.model.dto.ChdispoaplicPK;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmotivretir;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cractoquir;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;


import org.profamilia.hc.view.backing.clinico.comun.BuscadorCie10Bean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaProcedimientoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE AplicacionDispositivoBean
//=======================================================================

public class AplicacionDispositivoBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chdispoaplic dispositivo;

    private List lstTipoDispositivo;

    private List lstTipoDispositivoRetiro;

    private String menuBean;

    private Long numeroConsulta;

    private String tipoServicio;

    private List lstAmbito;

    private List lstFinalidad;

    private List lstRealizacion;


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderInsercion;

    private boolean renderRetiro;

    private String nextAction;

    private String navigationRule;

    private List lstMotivo;

    private boolean renderMotivoRetiro;

    private boolean mostrarCie10;

    private boolean renderPlantilla;

    private Integer selectedIndex;

    private UIInput itDescripcion;

    private String tieneComplicaciones;

    private List lstOpciones;

    private boolean mostrarComplicaciones;

    private UIInput itDiagComplicacion;

    private Crdgncie10 diagprin;

    private Crdgncie10 diagpost;

    private Crdgncie10 diagCompl;

    private String diagnosticoComplicacion;

    private UIInput itDiagPosterior;

    private String diagnosticoPosterior;

    private Integer edad;


    static final int ACTIVAR_APLICACION_DISPOSITIVO = 0;

    static final int ACTIVAR_BUSCADOR_DIAGNOSTICO = 1;

    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 2;

    private UIInput itDesclugamarc;

    private boolean buscadorLugarMarcacion;

    private boolean renderLugarMarcacion;

    private boolean renderRealizaProcedimiento;

    private UIInput mnuRealizaProcedimiento;

    private List<Cfdetafactura> listaServicios;

    private Cnconsclin consultaClinic;
    
    private Chconsulta chconsulta;
    
    private HtmlDataTable dtProcedimientoAsociados;
    
    private Chimprdiag impresionDiang;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AplicacionDispositivoBean() {
    }


    public void init() {

        dispositivo = new Chdispoaplic();
        listaServicios = new ArrayList<Cfdetafactura>();
        consultaClinic = new Cnconsclin();
        renderRealizaProcedimiento = false;
        inicializarAplicacionDispositivo();
        selectedIndex = 0;

    }

    public void inicializarAplicacionDispositivo() {

        if (usuario != null && usuario.getHusdfechanacim() != null) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
        }
        renderLugarMarcacion = false;
        renderRealizaProcedimiento = false;

        if (numeroConsulta != null) {
            try {
                dispositivo = 
                        this.serviceLocator.getClinicoService().getAplicacionRetiroDispositivo(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                consultaClinic = 
                        this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
                
                chconsulta =  this.serviceLocator.getClinicoService().getConsultaActual(numeroConsulta);
                if (consultaClinic != null) {
                    busquedaDetalleFactura();
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (dispositivo == null) {
            dispositivo = new Chdispoaplic();
            dispositivo.setHdanambitproce(1);
            if(listaServicios == null || listaServicios.isEmpty()){
                renderRealizaProcedimiento = true;
            }
        } else {
            if (dispositivo.getHdacretiro() != null && 
                dispositivo.getHdacretiro().equals("S")) {
                renderRetiro = true;
            } else {
                renderRetiro = false;
            }

            if (dispositivo.getHdacinsercion() != null && 
                dispositivo.getHdacinsercion().equals("S")) {
                renderInsercion = true;
            } else {
                renderInsercion = false;
            }


            if (dispositivo.getHdacdiagposter() != null && 
                !dispositivo.getHdacdiagposter().equals("")) {
                try {
                    diagpost = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(dispositivo.getHdacdiagposter().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagpost != null && diagpost.getCdcccodigo() != null) {
                    diagnosticoPosterior = diagpost.getCdccdescri();
                }

            }

            if (dispositivo.getHdacdiagcompli() != null && 
                !dispositivo.getHdacdiagcompli().equals("")) {
                tieneComplicaciones = "S";
                mostrarComplicaciones = true;

                try {
                    diagCompl = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(dispositivo.getHdacdiagcompli().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagCompl != null && diagCompl.getCdcccodigo() != null) {
                    diagnosticoComplicacion = diagCompl.getCdccdescri();
                }

            } else {
                tieneComplicaciones = "N";
                mostrarComplicaciones = false;
            }
            
            if ("S".equals(dispositivo.getHdacdispoinser())){
                renderRealizaProcedimiento=true;
            }
            
            if ("S".equals(dispositivo.getHdacdisporetir())){
                renderRealizaProcedimiento=true;
            }

            if (chconsulta != null && chconsulta.getChimprdiags() != null) {
                impresionDiang = null;
                Iterator it = chconsulta.getChimprdiags().iterator();
                if (it.hasNext()) {
                    impresionDiang = (Chimprdiag)it.next();
                }
            }
            
            changeDispositivoInsercionORetiro();
        }
        
        if(listaServicios == null || listaServicios.isEmpty()){
            renderRealizaProcedimiento = true;
        }else{
            changeRealizaProce();
        }
        
    }

    private void busquedaDetalleFactura() {

        try {
            if (consultaClinic != null && 
                consultaClinic.getCconnumero() != null) {
                Long tipoDocuentoAdmision = 
                    consultaClinic.getCcontipdoc().getCtdnnumero().longValue();
                if (tipoDocuentoAdmision == 
                    IConstantes.TIPO_DOCUMENTO_ADMISION) {
                    Cfdetafactura cfdetafactura = new Cfdetafactura();
                    List<Object[]> resultList = 
                        getServiceLocator().getClinicoService().getListaServiciosDobleConUnaAtencion(consultaClinic.getCconnumdoc().longValue(),consultaClinic.getCcocservic().getCsvccodigo());

                    if (resultList != null && !resultList.isEmpty()) {
                        listaServicios = new ArrayList<Cfdetafactura>();

                        for (Object[] objeto: resultList) {

                            if (objeto[17] != null) {
                                cfdetafactura.setComp_id(new CfdetafacturaPK(validarLong(objeto[0]), 
                                                                             validarLong(objeto[1])));

                                cfdetafactura.setCdfcservicio(validarString(objeto[2]));
                                cfdetafactura.setCdfnorden(validarLong(objeto[3]));
                                cfdetafactura.setCdfcobserv(validarString(objeto[4]));
                                cfdetafactura.setCdfclote(validarString(objeto[5]));
                                cfdetafactura.setCdfndescuento(validarDouble(objeto[6]));
                                cfdetafactura.setCdfniva(validarDouble(objeto[7]));
                                cfdetafactura.setCdfncliente(validarLong(objeto[8]));
                                cfdetafactura.setCdfnestado(validarString(objeto[9]));
                                cfdetafactura.setCdfcpaquet(validarString(objeto[10]));
                                cfdetafactura.setCdfctipdscto(validarString(objeto[11]));
                                cfdetafactura.setCdfnvalsrv(validarDouble(objeto[12]));
                                cfdetafactura.setCdfncantidad(validarLong(objeto[13]));
                                cfdetafactura.setCdfcetapa(validarString(objeto[14]));
                                cfdetafactura.setCdfcusuamodi(validarString(objeto[15]));
                                cfdetafactura.setCdfdfechmodi((Date)(objeto[16]));
                                cfdetafactura.setCdfnconsuclin(validarLong(objeto[17]));
                                cfdetafactura.setCdfcswitpaq(validarString(objeto[18]));
                                cfdetafactura.setNombreServicio(validarString(objeto[19]));
                                cfdetafactura.setCheckServiciosAsociados(false);
                                cfdetafactura.setTipoHistoria(validarInteger(objeto[20]));
                                if (cfdetafactura.getCdfnconsuclin() != null) {
                                    if (chconsulta != null && chconsulta.getHconprocasoc() != null) {
                                        if (cfdetafactura.getCdfnconsuclin().longValue() == chconsulta.getHconprocasoc().longValue()) {
                                            cfdetafactura.setCheckServiciosAsociados(true);
                                            renderRealizaProcedimiento = true;
                                        }
                                    }
                                    if (chconsulta != null && chconsulta.getHconproasoret() != null) {
                                        if (cfdetafactura.getCdfnconsuclin().longValue() == chconsulta.getHconproasoret().longValue()) {
                                            cfdetafactura.setCheckServiciosAsociados(true);
                                            renderRealizaProcedimiento = true;
                                        }
                                    }
                                    
                                    cfdetafactura.setValidacionConsultaClinica(true);
                                } else {
                                    cfdetafactura.setValidacionConsultaClinica(false);
                                }
                                if (cfdetafactura.getCdfcswitpaq().equals("N")) {
                                    listaServicios.add(cfdetafactura);
                                }
                                cfdetafactura = new Cfdetafactura();
                            }
                        }
                    }
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------------
    //  GET / SET
    //-----------------------------------------------------------------------

    /**
     * @param dispositivo
     */
    public void setDispositivo(Chdispoaplic dispositivo) {
        this.dispositivo = dispositivo;
    }

    /**
     * @return
     */
    public Chdispoaplic getDispositivo() {
        return dispositivo;
    }

    /**
     * @param lstTipoDispositivo
     */
    public void setLstTipoDispositivo(List lstTipoDispositivo) {
        this.lstTipoDispositivo = lstTipoDispositivo;
    }

    /**
     * @return
     */
    public List getLstTipoDispositivo() {
        if (lstTipoDispositivo == null || lstTipoDispositivo.isEmpty()) {
            lstTipoDispositivo = new ArrayList();
            lstTipoDispositivo.add(new SelectItem("", 
                                                  "Seleccione una Opci�n"));
            lstTipoDispositivo.add(new SelectItem("DI", "DIU"));
            lstTipoDispositivo.add(new SelectItem("MI", "Mirena"));
            lstTipoDispositivo.add(new SelectItem("JA", "Jadelle"));
            lstTipoDispositivo.add(new SelectItem("IM", "Implan�n"));
            lstTipoDispositivo.add(new SelectItem("JY", "Jaydess"));
            lstTipoDispositivo.add(new SelectItem("KY", "Kyleena"));
        }

        return lstTipoDispositivo;
    }

    /**
     * @param lstTipoDispositivoRetiro
     */
    public void setLstTipoDispositivoRetiro(List lstTipoDispositivoRetiro) {
        this.lstTipoDispositivoRetiro = lstTipoDispositivoRetiro;
    }

    /**
     * @return
     */
    public List getLstTipoDispositivoRetiro() {
        if (lstTipoDispositivoRetiro == null || 
            lstTipoDispositivoRetiro.isEmpty()) {
            lstTipoDispositivoRetiro = new ArrayList();
            lstTipoDispositivoRetiro.add(new SelectItem("", 
                                                        "Seleccione una Opci�n"));
            lstTipoDispositivoRetiro.add(new SelectItem("DI", "DIU"));
            lstTipoDispositivoRetiro.add(new SelectItem("MI", "Mirena"));
            lstTipoDispositivoRetiro.add(new SelectItem("JA", "Jadelle"));
            lstTipoDispositivoRetiro.add(new SelectItem("IM", "Implan�n"));
            lstTipoDispositivoRetiro.add(new SelectItem("NP", "Norplant"));
            lstTipoDispositivoRetiro.add(new SelectItem("JY", "Jaydess"));
            lstTipoDispositivoRetiro.add(new SelectItem("KY", "Kyleena"));
            lstTipoDispositivoRetiro.add(new SelectItem("SI", "Sino Implant"));
        }

        return lstTipoDispositivoRetiro;
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
     * @param renderInsercion
     */
    public void setRenderInsercion(boolean renderInsercion) {
        this.renderInsercion = renderInsercion;
    }

    /**
     * @return
     */
    public boolean isRenderInsercion() {
        return renderInsercion;
    }

    /**
     * @param renderRetiro
     */
    public void setRenderRetiro(boolean renderRetiro) {
        this.renderRetiro = renderRetiro;
    }

    /**
     * @return
     */
    public boolean isRenderRetiro() {
        return renderRetiro;
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
     * @param lstMotivo
     */
    public void setLstMotivo(List lstMotivo) {
        this.lstMotivo = lstMotivo;
    }

    /**
     * @return
     */
    public List getLstMotivo() {
        if (lstMotivo == null) {
            lstMotivo = new ArrayList();
            ArrayList<Chmotivretir> listMotivoAux = null;
            try {
                listMotivoAux = 
                        (ArrayList<Chmotivretir>)this.serviceLocator.getClinicoService().getMotivoRetiroImplante();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listMotivoAux.isEmpty()) {

                Iterator it = listMotivoAux.iterator();
                int i = 0;
                lstMotivo.add(new SelectItem("", 
                                             "Seleccione una opci�n1 ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMotivo.add(new SelectItem(listMotivoAux.get(i).getCmrccodigo(), 
                                                 listMotivoAux.get(i).getCmrcdescripcio()));
                    i++;
                }
            }
        }
        return lstMotivo;
    }

    /**
     * @param renderMotivoRetiro
     */
    public void setRenderMotivoRetiro(boolean renderMotivoRetiro) {
        this.renderMotivoRetiro = renderMotivoRetiro;
    }

    /**
     * @return
     */
    public boolean isRenderMotivoRetiro() {
        return renderMotivoRetiro;
    }

    /**
     * @param itDiagComplicacion
     */
    public void setItDiagComplicacion(UIInput itDiagComplicacion) {
        this.itDiagComplicacion = itDiagComplicacion;
    }

    /**
     * @return
     */
    public UIInput getItDiagComplicacion() {
        return itDiagComplicacion;
    }

    /**
     * @param diagprin
     */
    public void setDiagprin(Crdgncie10 diagprin) {
        this.diagprin = diagprin;
    }

    /**
     * @return
     */
    public Crdgncie10 getDiagprin() {
        return diagprin;
    }

    /**
     * @param diagpost
     */
    public void setDiagpost(Crdgncie10 diagpost) {
        this.diagpost = diagpost;
    }

    /**
     * @return
     */
    public Crdgncie10 getDiagpost() {
        return diagpost;
    }

    /**
     * @param diagCompl
     */
    public void setDiagCompl(Crdgncie10 diagCompl) {
        this.diagCompl = diagCompl;
    }

    /**
     * @return
     */
    public Crdgncie10 getDiagCompl() {
        return diagCompl;
    }

    /**
     * @param diagnosticoComplicacion
     */
    public void setDiagnosticoComplicacion(String diagnosticoComplicacion) {
        this.diagnosticoComplicacion = diagnosticoComplicacion;
    }

    /**
     * @return
     */
    public String getDiagnosticoComplicacion() {
        return diagnosticoComplicacion;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHdacdiagposter(ValueChangeEvent valueChangeEvent) {
        dispositivo.setHdacdiagposter((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param itDiagPosterior
     */
    public void setItDiagPosterior(UIInput itDiagPosterior) {
        this.itDiagPosterior = itDiagPosterior;
    }

    /**
     * @return
     */
    public UIInput getItDiagPosterior() {
        return itDiagPosterior;
    }

    /**
     * @param diagnosticoPosterior
     */
    public void setDiagnosticoPosterior(String diagnosticoPosterior) {
        this.diagnosticoPosterior = diagnosticoPosterior;
    }

    /**
     * @return
     */
    public String getDiagnosticoPosterior() {
        return diagnosticoPosterior;
    }

    /**
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {
        return edad;
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
     * @param selectedIndex
     */
    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public Integer getSelectedIndex() {
        return selectedIndex;
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

    /**
     * @param lstAmbito
     */
    public void setLstAmbito(List lstAmbito) {
        this.lstAmbito = lstAmbito;
    }

    /**
     * @return
     */
    public List getLstAmbito() {
        if (lstAmbito == null || lstAmbito.isEmpty()) {
            lstAmbito = new ArrayList();
            lstAmbito.add(new SelectItem("", "Seleccione una opci�n"));
            lstAmbito.add(new SelectItem(1, "Ambulatorio"));
            lstAmbito.add(new SelectItem(2, "Hospitalario"));
            lstAmbito.add(new SelectItem(3, "En Urgencia"));
        }
        return lstAmbito;
    }

    /**
     * @param lstFinalidad
     */
    public void setLstFinalidad(List lstFinalidad) {
        this.lstFinalidad = lstFinalidad;
    }

    /**
     * @return
     */
    public List getLstFinalidad() {
        if (lstFinalidad == null || lstFinalidad.isEmpty()) {
            lstFinalidad = new ArrayList();
            ArrayList<Crfinalcon> lstFinalidadesAux = null;
            try {
                lstFinalidadesAux = 
                        (ArrayList<Crfinalcon>)this.getServiceLocator().getClinicoService().getFinalidadesConsultaVG(IConstantes.TIPO_PROCEDIMIENTO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstFinalidadesAux.isEmpty()) {

                lstFinalidad.add(new SelectItem("", 
                                                "Seleccione una opci�n ..."));
                Iterator it = lstFinalidadesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstFinalidad.add(new SelectItem((lstFinalidadesAux.get(i).getId().getCfcncodigo()), 
                                                    lstFinalidadesAux.get(i).getCfccdescri()));
                    i++;
                }
            }
        }
        return lstFinalidad;
    }


    /**
     * @param lstRealizacion
     */
    public void setLstRealizacion(List lstRealizacion) {
        this.lstRealizacion = lstRealizacion;
    }

    /**
     * @return
     */
    public List getLstRealizacion() {
        if (lstRealizacion == null || lstRealizacion.isEmpty()) {
            lstRealizacion = new ArrayList();
            ArrayList<Cractoquir> lstRealizacionAux = null;
            try {
                lstRealizacionAux = 
                        (ArrayList<Cractoquir>)this.getServiceLocator().getClinicoService().getActoQuirurgico();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstRealizacionAux.isEmpty()) {

                lstRealizacion.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                Iterator it = lstRealizacionAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstRealizacion.add(new SelectItem((lstRealizacionAux.get(i).getCaqncodigo()), 
                                                      lstRealizacionAux.get(i).getCaqcdescri()));
                    i++;
                }
            }
        }
        return lstRealizacion;
    }


    /**
     * @param tieneComplicaciones
     */
    public void setTieneComplicaciones(String tieneComplicaciones) {
        this.tieneComplicaciones = tieneComplicaciones;
    }

    /**
     * @return
     */
    public String getTieneComplicaciones() {
        return tieneComplicaciones;
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
     * @param mostrarComplicaciones
     */
    public void setMostrarComplicaciones(boolean mostrarComplicaciones) {
        this.mostrarComplicaciones = mostrarComplicaciones;
    }

    /**
     * @return
     */
    public boolean isMostrarComplicaciones() {
        return mostrarComplicaciones;
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //----------------------------------------------------------------------- 

    /**
     * @param valueChangeEvent
     */
    public void setRenderRetiro(ValueChangeEvent valueChangeEvent) {
        setRenderRetiro((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderInsercion(ValueChangeEvent valueChangeEvent) {
        setRenderInsercion((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTieneComplicaciones(ValueChangeEvent valueChangeEvent) {
        setTieneComplicaciones((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHdacdispoinser(ValueChangeEvent valueChangeEvent) {
        dispositivo.setHdacdispoinser((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHdacdisporetir(ValueChangeEvent valueChangeEvent) {
        dispositivo.setHdacdisporetir((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //-----------------------------------------------------------------------
    //  METODO ESVALIDO
    //-----------------------------------------------------------------------

        public boolean esValido() {
        boolean esValido = false;
        Chdispoaplic dispositivoAux = null;
        if (numeroConsulta != null) {
            try {
                dispositivoAux = 
                        this.getServiceLocator().getClinicoService().getAplicacionRetiroDispositivo(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (dispositivoAux != null) {
                esValido = true;
            } else {
                esValido = false;
            }
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //   // Acciones AJAX
    //-----------------------------------------------------------------------

    public void aceptarPlantilla() {
        BuscadorPlantillaProcedimientoBean buscador = 
            (BuscadorPlantillaProcedimientoBean)FacesUtils.getManagedBean("buscadorPlantillaProcedimientoBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            dispositivo.setHdacdescrproce(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION_DISPOSITIVO;
        FacesUtils.resetManagedBean("buscadorPlantillaProcedimientoBean");
    }

    public void aceptarPlantillaDescLugarMarcacion() {
        BuscadorPlantillaProcedimientoBean buscador = 
            (BuscadorPlantillaProcedimientoBean)FacesUtils.getManagedBean("buscadorPlantillaProcedimientoBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDesclugamarc.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            dispositivo.setHdacdeslugmar(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION_DISPOSITIVO;
        FacesUtils.resetManagedBean("buscadorPlantillaProcedimientoBean");
    }


    public void mostrarBuscadorPlantilla() {
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        buscadorLugarMarcacion = false;
        FacesUtils.resetManagedBean("buscadorPlantillaProcedimiento");
        renderPlantilla = true;
    }

    public void mostrarBuscadorPlantillaLugarMarcacion() {
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        buscadorLugarMarcacion = true;
        FacesUtils.resetManagedBean("buscadorPlantillaProcedimiento");
        renderPlantilla = true;
    }


    public void aceptarDiagnostico() {
        BuscadorCie10Bean cie10;
        cie10 = 
                (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");

        if (cie10 != null && cie10.getCie10Select() != null) {

            if (cie10.isDiagnosticoRelacionado1()) {
                dispositivo.setHdacdiagposter(cie10.getCie10Select().getCdcccodigo());
                itDiagPosterior.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPosterior = cie10.getCie10Select().getCdccdescri();
            }
            if (cie10.isDiagnosticoRelacionado2()) {
                dispositivo.setHdacdiagcompli(cie10.getCie10Select().getCdcccodigo());
                itDiagComplicacion.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoComplicacion = 
                        cie10.getCie10Select().getCdccdescri();
            }
        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_APLICACION_DISPOSITIVO;
        cie10.clear();

    }


    public void changeDiagnosticoComplicacion() {

        diagnosticoComplicacion = null;


        if (dispositivo.getHdacdiagcompli() != null && 
            !dispositivo.getHdacdiagcompli().equals("")) {
            try {
                diagCompl = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(dispositivo.getHdacdiagcompli().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagCompl != null && diagCompl.getCdcccodigo() != null) {
                diagnosticoComplicacion = diagCompl.getCdccdescri();

            }

            if (diagnosticoComplicacion == null || 
                diagnosticoComplicacion.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_COMPLICACION_NO_VALIDO);
            }
        } else {
            diagnosticoComplicacion = "";
        }
    }


    public void changeDiagnosticoPosterior() {

        diagnosticoPosterior = null;
        List validacionRelacionado1 = null;

        if (dispositivo.getHdacdiagposter() != null && 
            !dispositivo.getHdacdiagposter().equals("")) {
            try {
                diagpost = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(dispositivo.getHdacdiagposter().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagpost != null && diagpost.getCdcccodigo() != null) {
                diagnosticoPosterior = diagpost.getCdccdescri();
                validacionRelacionado1 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagpost, 
                                                                                     usuario.getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");

                if (validacionRelacionado1 != null && 
                    !validacionRelacionado1.isEmpty()) {
                    if (validacionRelacionado1.get(1) != null) {
                        FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1 + 
                                                   validacionRelacionado1.get(1));
                    }

                }

            }

            if (diagnosticoPosterior == null || 
                diagnosticoPosterior.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_RELACIONADO1_NO_VALIDO);
            }
        } else {
            diagnosticoPosterior = "";
        }
    }


    public void changeComplicaciones() {
        if (tieneComplicaciones != null && tieneComplicaciones.equals("S")) {
            mostrarComplicaciones = true;
        } else {
            mostrarComplicaciones = false;
            diagnosticoComplicacion = "";
            dispositivo.setHdacdescrcompl(null);
            dispositivo.setHdacdiagcompli(null);
        }
    }


    public void setHdacdiagcompli(ValueChangeEvent valueChangeEvent) {
        dispositivo.setHdacdiagcompli((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void mostrarDiagnosticoComplicacion() {
        BuscadorCie10Bean cie10;
        if (dispositivo != null) {
            dispositivo.setHdacdiagcompli(null);
        }

        cie10 = 
                (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(true);
        cie10.setDiagnosticoRelacionado3(false);
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
        mostrarCie10 = true;
    }

    public void mostrarDiagnosticoPosterior() {
        BuscadorCie10Bean cie10;
        if (dispositivo != null) {
            dispositivo.setHdacdiagposter(null);
        }
        cie10 = 
                (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(true);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
    }


    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------

    public String guardar() {

        ChdispoaplicPK id;
        id = new ChdispoaplicPK();
        navigationRule = "";
        String url = 
            "body:formAplicacionDispositivo:panelTabAplicacionDispositivo:";
        boolean wexito = true;
        boolean wcamposcompletos = true;

        if (renderRealizaProcedimiento) {

            if (!renderInsercion) {
                dispositivo.setHdacdispoinser(null);
            }

            if (!renderRetiro) {
                dispositivo.setHdacdisporetir(null);
                dispositivo.setHdacmotivretir(null);
            }

            if (tieneComplicaciones != null && 
                tieneComplicaciones.equals("N")) {
                dispositivo.setHdacdiagcompli(null);
                dispositivo.setHdacdescrcompl(null);
            }

            if (dispositivo != null) {
                if (dispositivo.getHdanambitproce() == null) {
                    FacesUtils.addErrorMessage(url + "menuAmbitoAplicacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                }

                if (dispositivo.getHdanfinalidad() == null) {
                    FacesUtils.addErrorMessage(url + "menuFinalidadAplicacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                }

                if (renderInsercion) {
                    if (dispositivo.getHdacdispoinser() == null || 
                        dispositivo.getHdacdispoinser().equals("")) {
                        FacesUtils.addErrorMessage(url + "menuDispositivo", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wcamposcompletos = false;
                    }
                }


                if (renderRetiro) {
                    if (dispositivo.getHdacdisporetir() == null || 
                        dispositivo.getHdacdisporetir().equals("")) {
                        FacesUtils.addErrorMessage(url + 
                                                   "menuDispositivoRetiro", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wcamposcompletos = false;
                    }


                    if (dispositivo.getHdacmotivretir() == null || 
                        dispositivo.getHdacmotivretir().equals("")) {
                        FacesUtils.addErrorMessage(url + "mnuMotivoRetiro", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wcamposcompletos = false;
                    }

                }

                if (dispositivo.getHdacdescrproce() == null || 
                    dispositivo.getHdacdescrproce().equals("")) {
                    FacesUtils.addErrorMessage(url + "textDescripcion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                }

                if ((dispositivo.getHdacdeslugmar() == null || 
                     dispositivo.getHdacdeslugmar().equals("")) && 
                    renderLugarMarcacion) {
                    FacesUtils.addErrorMessage(url + "textDesLugarMarcacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                }


                if (tieneComplicaciones == null || 
                    tieneComplicaciones.equals("")) {
                    FacesUtils.addErrorMessage(url + "mnuComplicaciones", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                } else if (tieneComplicaciones.equals("S")) {
                    if (dispositivo.getHdacdiagcompli() == null || 
                        dispositivo.getHdacdiagcompli().equals("")) {
                        FacesUtils.addErrorMessage(url + "itDiagComplicacion", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wcamposcompletos = false;
                    }


                    if (dispositivo.getHdacdescrcompl() == null || 
                        dispositivo.getHdacdescrcompl().equals("")) {
                        FacesUtils.addErrorMessage(url + 
                                                   "inputTextareaComplicaciones", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wcamposcompletos = false;
                    }
                }


                if (dispositivo.getHdacdiagposter() == null || 
                    dispositivo.getHdacdiagposter().equals("")) {
                    FacesUtils.addErrorMessage(url + 
                                               "itDiagPosteriorAplicacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                }

                if (dispositivo.getHdanrealizacio() == null) {
                    FacesUtils.addErrorMessage(url + 
                                               "mnuRealizacionAplicacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wcamposcompletos = false;
                }

            }
        } else {
            wexito = false;
            resetAplicacion();
        }

        if (wexito) {
          if(wcamposcompletos){
              if (numeroConsulta != null && tipoServicio != null) {
                  id.setHdactiposerv(tipoServicio);
                  id.setHdalconsulta(numeroConsulta);
                  dispositivo.setId(id);
              }

              if (renderInsercion) {
                  dispositivo.setHdacinsercion("S");
              } else {
                  dispositivo.setHdacinsercion("N");
                  dispositivo.setHdacdispoinser(null);
              }

              if (renderRetiro) {
                  dispositivo.setHdacretiro("S");
              } else {
                  dispositivo.setHdacretiro("N");
                  dispositivo.setHdacdisporetir(null);
                  dispositivo.setHdacmotivretir(null);
              }

                if (impresionDiang != null) {
                    dispositivo.setHdacdiagprinci(impresionDiang.getHidcdiagprin());
                }

              dispositivo.setHdacoperador(userName());
              dispositivo.setHdadfecregistr(new Date());

              try {
                  if (listaServicios != null && !listaServicios.isEmpty()) {
                      this.serviceLocator.getClinicoService().saveAplicacionRetiroDispositivo(dispositivo, 
                                                                                              listaServicios);
                  } else {
                      this.serviceLocator.getClinicoService().saveAplicacionRetiroDispositivo(dispositivo, 
                                                                                              null);
                  }
                  FacesUtils.resetManagedBean(menuBean);
                  navigationRule = nextAction;
                  FacesUtils.addInfoMessage(MSG_ADICION);
              } catch (ModelException e) {
                  FacesUtils.addErrorMessage(MSG_NO_ADICION);
                  e.printStackTrace();
              }
  
          }else{
              navigationRule = null;
          }
                    
            
        }else{
            try {
                if (numeroConsulta != null && tipoServicio != null) { 
                    id.setHdactiposerv(tipoServicio);
                    id.setHdalconsulta(numeroConsulta);
                    dispositivo.setHdanrealizacio(null);
                    dispositivo.setHdacdescrcompl(null);
                    dispositivo.setHdacdescrproce(null);
                    dispositivo.setHdacdeslugmar(null);
                    dispositivo.setHdacdiagcompli(null);
                    dispositivo.setHdacdiagposter(null);
                    dispositivo.setHdacdiagprinci(null);
                    dispositivo.setHdacdispoinser(null);
                    dispositivo.setHdacdisporetir(null);
                    dispositivo.setHdacinsercion(null);
                    dispositivo.setHdacmotivretir(null);
                    dispositivo.setHdacretiro(null);
                    dispositivo.setHdanfinalidad(null);
                    dispositivo.setHdacoperador(userName());
                    dispositivo.setHdadfecregistr(new Date());
                    dispositivo.setId(id);
                    dispositivo.setHdacreaproins("N");
                    dispositivo.setHdacreaproret("N");
                    this.serviceLocator.getClinicoService().saveAplicacionRetiroDispositivo(dispositivo,listaServicios);
                    FacesUtils.resetManagedBean(menuBean);
                    navigationRule = nextAction;
                    FacesUtils.addInfoMessage(MSG_ADICION);
                }

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ELIMINACION);
                e.printStackTrace();
            }
        }
        return navigationRule;
    }

    public void changeDispositivoInsercionORetiro() {
        if ("JA".equals(dispositivo.getHdacdisporetir()) || 
            "IM".equals(dispositivo.getHdacdisporetir()) || 
            "NP".equals(dispositivo.getHdacdisporetir()) || 
            "SI".equals(dispositivo.getHdacdisporetir()) || 
            "JA".equals(dispositivo.getHdacdispoinser()) || 
            "IM".equals(dispositivo.getHdacdispoinser())) {
            renderLugarMarcacion = true;
        } else {
            renderLugarMarcacion = false;
        }
    }

    public void setItDesclugamarc(UIInput itDesclugamarc) {
        this.itDesclugamarc = itDesclugamarc;
    }

    public UIInput getItDesclugamarc() {
        return itDesclugamarc;
    }

    public void setBuscadorLugarMarcacion(boolean buscadorLugarMarcacion) {
        this.buscadorLugarMarcacion = buscadorLugarMarcacion;
    }

    public boolean isBuscadorLugarMarcacion() {
        return buscadorLugarMarcacion;
    }

    public void setRenderLugarMarcacion(boolean renderLugarMarcacion) {
        this.renderLugarMarcacion = renderLugarMarcacion;
    }

    public boolean isRenderLugarMarcacion() {
        return renderLugarMarcacion;
    }

    public void setRenderRealizaProcedimiento(boolean renderRealizaProcedimiento) {
        this.renderRealizaProcedimiento = renderRealizaProcedimiento;
    }

    public boolean isRenderRealizaProcedimiento() {
        return renderRealizaProcedimiento;
    }

    /**
     * @param valueChangeEvent
     */
    public void setRealizaProcedimiento(ValueChangeEvent valueChangeEvent) {
        dispositivo.setHdacreaproins((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeRealizaProce() {
        //Cfdetafactura servicio = (Cfdetafactura) dtProcedimientoAsociados.getRowData();
         int contador = 0;
        for(Cfdetafactura servicio:listaServicios){
                if(servicio.isCheckServiciosAsociados()){
                    if(servicio.getTipoHistoria() == IConstantes.HISTORIA_PROCEDIMIENTO_ASOCIADO){
                        dispositivo.setHdacreaproins("S");
                        renderRealizaProcedimiento=true;
                        contador += 1;
                    }else if(servicio.getTipoHistoria() == IConstantes.HISTORIA_ANTICONCEPCION_RETIRO){
                        dispositivo.setHdacreaproret("S");
                        renderRealizaProcedimiento=true;
                        contador += 1;
                    }
                }else{
                    if(servicio.getTipoHistoria() == IConstantes.HISTORIA_PROCEDIMIENTO_ASOCIADO){
                        dispositivo.setHdacreaproins("N");
                    }else if(servicio.getTipoHistoria() == IConstantes.HISTORIA_ANTICONCEPCION_RETIRO){
                        dispositivo.setHdacreaproret("N");
                    }
                }
                
                if(contador == 0){
                    renderRealizaProcedimiento = false;
                }
        }

       
       /* if (dispositivo.getHdacreaproins() != null && 
            dispositivo.getHdacreaproins().equals("S")) {
            renderRealizaProcedimiento = true;
        }*/
    }
    
    public void resetAplicacion(){
        renderRealizaProcedimiento = false;
        itDiagPosterior.setValue(null);
        renderInsercion = false;
        tieneComplicaciones = null;
        mostrarComplicaciones = false;
        diagnosticoPosterior = null;
        renderLugarMarcacion = false;
        dispositivo.setHdacdispoinser(null);
        dispositivo.setHdacretiro(null);
        dispositivo.setHdacdescrproce(null);
        dispositivo.setHdadfecregistr(null);
        dispositivo.setHdacoperador(null);
        dispositivo.setHdacdisporetir(null);
        dispositivo.setHdacinsercion(null);
        dispositivo.setHdacmotivretir(null);
        dispositivo.setHdacdiagprinci(null);
        dispositivo.setHdacdiagposter(null);
        dispositivo.setHdanfinalidad(null);
        dispositivo.setHdacdiagcompli(null);
        dispositivo.setHdacdescrcompl(null);
        dispositivo.setHdanambitproce(1);
        dispositivo.setHdanrealizacio(null);
        dispositivo.setHdacdeslugmar(null);
        dispositivo.setHdacdispoinser(null);
        dispositivo.setHdacdisporetir(null);
    }

    public void setMnuRealizaProcedimiento(UIInput mnuRealizaProcedimiento) {
        this.mnuRealizaProcedimiento = mnuRealizaProcedimiento;
    }

    public UIInput getMnuRealizaProcedimiento() {
        return mnuRealizaProcedimiento;
    }


    public void setConsultaClinic(Cnconsclin consultaClinic) {
        this.consultaClinic = consultaClinic;
    }

    public Cnconsclin getConsultaClinic() {
        return consultaClinic;
    }

    public Long validarLong(Object valor) {
        return valor == null ? null : Long.parseLong(valor.toString());
    }

    public Double validarDouble(Object valor) {
        return valor == null ? null : Double.parseDouble(valor.toString());
    }

    public String validarString(Object valor) {
        return valor == null ? null : valor.toString();
    }

    public void setListaServicios(List<Cfdetafactura> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public List<Cfdetafactura> getListaServicios() {
        return listaServicios;
    }

    public void setDtProcedimientoAsociados(HtmlDataTable dtProcedimientoAsociados) {
        this.dtProcedimientoAsociados = dtProcedimientoAsociados;
    }

    public HtmlDataTable getDtProcedimientoAsociados() {
        return dtProcedimientoAsociados;
    }
    
    public Integer validarInteger(Object valor) {
        return valor == null ? null : Integer.parseInt(valor.toString());
    }
}
