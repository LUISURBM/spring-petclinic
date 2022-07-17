package org.profamilia.hc.view.backing.clinico.consultorio;

import java.math.BigDecimal;

import java.text.DecimalFormat;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlSelectOneRadio;


import javax.faces.event.ValueChangeEvent;


import org.profamilia.hc.model.dto.Chconsutarif;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Spimprime;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.model.dto.Spservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.sap.webservice.consultaservicio.ListaReq;
import org.profamilia.hc.sap.webservice.consultaservicio.ListaResp;
import org.profamilia.hc.sap.webservice.consultaservicio.Lista_Sync_OutProxy;
import org.profamilia.hc.sap.webservice.consultaservicio.T_Inf;
import org.profamilia.hc.sap.webservice.consultaservicio.T_Return;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorServicioBean;
import org.profamilia.hc.view.backing.sap.registro.RegistarUsuarioSapBean;
import org.profamilia.hc.view.util.FacesUtils;


public class InformacionServicioBean extends BaseBean {
    private Spservicio spservicio;
    private Chconsutarif consulta;
    private List<Spservicio> lstSpservicios;
    private HtmlSelectOneRadio selectPresservi;
    private T_Inf list;
    private List<T_Inf> ltsServicioSap;

    private List<Chconsutarif> ltsTarifaServicio;

    T_Inf[] wrespue;
    T_Return[] wrespu2;


    /** Objeto clinica */
    private Cpclinica infoClinica;
    private Cpusuario usuario;
    private boolean renderConsultas;
    private List lstConsultasAbiertas;
    private Date fecha;
    private String msgCerrarConsulta;
    private HtmlDataTable dtConsultasAbiertas;
    private boolean renderBuscador;
    private int selectedIndex;

    /** Variable que almacena el Nombre y codigo del servicio */
    private Cpservicio servicio;
    private static final int ACTIVAR_SERVICIO = 0;

    private static final int ACTIVAR_BUSCADOR = 1;


    private String servicioSeleccion;

    private boolean deshabilitarServicio;

    private List<Spservicio> lstservicioSelect;

    /** Almacena la tabla de servicios */
    private HtmlDataTable dtServicio;

    /** Almacena la formula que se desea eliminar de la base de datos */
    private Chconsutarif servicioClon;

    private Spimprime imprime;

    private Cpservicio serviciosap;

    private Cpservicio servix;

    private String codigo;
    
    private UIInput itServicio;


    public InformacionServicioBean() {
    }

    public void init() {

       
        spservicio = new Spservicio();
        servicio = new Cpservicio();
        this.spservicio.setLugarservi("I");
        this.selectPresservi = new HtmlSelectOneRadio();
        lstservicioSelect = new ArrayList<Spservicio>();
        this.spservicio.setCantservi(1);
        lstSpservicios = new ArrayList<Spservicio>();
        ltsServicioSap = new ArrayList<T_Inf>();
        ltsTarifaServicio = new ArrayList<Chconsutarif>();

    }

   

    public void changeServicioSeleccion() {
        servicioSeleccion = null;

        if (servicio != null) {
            if (servicio != null && !servicio.equals("")) {
                try {
                    servix = 
                            (Cpservicio)this.serviceLocator.getClinicoService().getDescripcionServicioSapXCodigo(servicio);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (servix != null && servix.getCsvccodigo() != null && !servix.getCsvccodigo().equals(servicio)) {
                    servicioSeleccion = servix.getCsvcnombre();
                }else{
                    servicioSeleccion = "Servicio NO Existe en Clinico";
                }
               
            } else {
              FacesUtils.addErrorMessage(servicioSeleccion = "Por Favor escriba un Codigo de Servicio");  
            }

        }
    }

  

    public void setSpservicio(Spservicio spservicio) {
        this.spservicio = spservicio;
    }

    public Spservicio getSpservicio() {
        return spservicio;
    }

    public void setlstSpservicios(List<Spservicio> lstSpservicios) {
        this.lstSpservicios = lstSpservicios;
    }

    public List<Spservicio> getlstSpservicios() {
        return lstSpservicios;
    }


    public void setSelectPresservi(HtmlSelectOneRadio selectPresservi) {
        this.selectPresservi = selectPresservi;
    }

    public HtmlSelectOneRadio getSelectPresservi() {
        return selectPresservi;
    }


    public String registrarUsuario() {
        FacesUtils.resetManagedBean("registarUsuarioSapBean");
        RegistarUsuarioSapBean registraUsuario = 
            (RegistarUsuarioSapBean)FacesUtils.getManagedBean("registarUsuarioSapBean");
        if (registraUsuario != null) {
            registraUsuario.setLtsTarifaServicio(ltsTarifaServicio);
        }
        servicio.setCsvccodigo(""); 
        servicioSeleccion = ("");
        return BeanNavegacion.REGISTRAR_USUARIO_SAP;
       
    }


    /**
     * @param infoClinica
     */
    public void setInfoClinica(Cpclinica infoClinica) {
        this.infoClinica = infoClinica;
    }

    /**
     * @return
     */
    public Cpclinica getInfoClinica() {
        return infoClinica;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Cpusuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Cpusuario getUsuario() {
        return usuario;
    }

    /**
     * @param renderConsultas
     */
    public void setRenderConsultas(boolean renderConsultas) {
        this.renderConsultas = renderConsultas;
    }

    /**
     * @return
     */
    public boolean isRenderConsultas() {
        return renderConsultas;
    }

    /**
     * @param lstConsultasAbiertas
     */
    public void setLstConsultasAbiertas(List lstConsultasAbiertas) {
        this.lstConsultasAbiertas = lstConsultasAbiertas;
    }

    /**
     * @return
     */
    public List getLstConsultasAbiertas() {
        return lstConsultasAbiertas;
    }

    /**
     * @param msgCerrarConsulta
     */
    public void setMsgCerrarConsulta(String msgCerrarConsulta) {
        this.msgCerrarConsulta = msgCerrarConsulta;
    }

    /**
     * @return
     */
    public String getMsgCerrarConsulta() {
        return msgCerrarConsulta;
    }


    /**
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param dtConsultasAbiertas
     */
    public void setDtConsultasAbiertas(HtmlDataTable dtConsultasAbiertas) {
        this.dtConsultasAbiertas = dtConsultasAbiertas;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultasAbiertas() {
        return dtConsultasAbiertas;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------   

    public void renderServicios() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    /**
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
    }


    /**
     * @param deshabilitarServicio
     */
    public void setDeshabilitarServicio(boolean deshabilitarServicio) {
        this.deshabilitarServicio = deshabilitarServicio;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarServicio() {
        return deshabilitarServicio;
    }


    public void aceptarServicio() {

        BuscadorServicioBean servicioAux = 
            (BuscadorServicioBean)FacesUtils.getManagedBean("buscadorServicioBean");


        if (servicioAux != null && servicioAux.getServicioSelect() != null) {
            itServicio.setValue(servicioAux.getServicioSelect().getCsvccodigo());
            servicioSeleccion = 
                    servicioAux.getServicioSelect().getCsvcnombre();

            servicio.setCsvccodigo(servicioAux.getServicioSelect().getCsvccodigo());
            deshabilitarServicio = true;

        }
        selectedIndex = ACTIVAR_SERVICIO;
        renderBuscador = false;

        FacesUtils.resetManagedBean("buscadorServicioBean");
       
    }


    /**
     * @param valueChangeEvent
     */
    public void setServicio(ValueChangeEvent valueChangeEvent) {
        servicio.setCsvccodigo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }


    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setLstservicioSelect(List<Spservicio> lstservicioSelect) {
        this.lstservicioSelect = lstservicioSelect;
    }

    public List<Spservicio> getLstservicioSelect() {
        return lstservicioSelect;
    }

    public void setDtServicio(HtmlDataTable dtServicio) {
        this.dtServicio = dtServicio;
    }

    public HtmlDataTable getDtServicio() {
        return dtServicio;
    }

    public void eliminarServicio() {
        this.servicioClon = (Chconsutarif)this.dtServicio.getRowData();
        this.ltsTarifaServicio.remove(servicioClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }


    public void setServicioSeleccion(String servicioSeleccion) {
        this.servicioSeleccion = servicioSeleccion;
    }

    public String getServicioSeleccion() {
        return servicioSeleccion;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHidcdiagprin(ValueChangeEvent valueChangeEvent) {
        imprime.setHidcdiagprin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setImprime(Spimprime imprime) {
        this.imprime = imprime;
    }

    public Spimprime getImprime() {
        return imprime;
    }

    public void setServiciosap(Cpservicio serviciosap) {
        this.serviciosap = serviciosap;
    }

    public Cpservicio getServiciosap() {
        return serviciosap;
    }

    public void setServix(Cpservicio servix) {
        this.servix = servix;
    }

    public Cpservicio getServix() {
        return servix;
    }

    public void setServicioClon(Chconsutarif servicioClon) {
        this.servicioClon = servicioClon;
    }

    public Chconsutarif getServicioClon() {
        return servicioClon;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void consultaServiciosSap() {

      

        String worgven = "1100";
        String wcandis = "30";
        boolean wencontro = true; 
        boolean wexiste = false;
        
        for(Chconsutarif aixu: ltsTarifaServicio ){
            if(servicio.getCsvccodigo().toUpperCase().equals(aixu.getMaterial().toUpperCase())&& !wexiste)
                wexiste = true;
            }
           
       

       
        
       if(!wexiste){

                   try {
                       Lista_Sync_OutProxy service = new Lista_Sync_OutProxy();
                       ListaReq cedula = new ListaReq(servicio.getCsvccodigo(), worgven, wcandis);
                       ListaResp resp = service.lista_Sync_Out(cedula);
                       wrespue = resp.getT_List();
                       wrespu2 = resp.getT_Return();
                       
                           for (T_Return auxi: wrespu2) {
                               if(auxi.getTipo().equals("E")){
                                    FacesUtils.addInfoMessage("SAP: "+auxi.getMensaje());    
                               }
                               
                           }
                       
                      if(wencontro){
                      
                      
                          Chconsutarif consulta;

                          String descuentoAdulto = "";
                          String descuentoJoven = "";
                          String descuentoJovenAdulto = "";
                          String descuentoEmpleado = "";
                          String descuentoParticular = "";

                          String tarifa = "";


                          String claseDescuentoJoven = "";
                          String claseDescuentoAdulto = "";
                          String claseDescuentoJovenAdulto = "";
                          String claseDescuentoEmpleado = "";
                          String claseDescuentoParticular = "";


                          consulta = new Chconsutarif();
                          String importe;
                          String descuentoAdul;
                          String descuentoJov;
                          String descuentoJovAdul;
                          String descuentoEmp;

                          BigDecimal descuentoAdulTotal = null;
                          BigDecimal descuentoJovTotal = null;
                          BigDecimal descuentoJovAdultoTotal = null;
                          BigDecimal descuentoEmplTotal = null;
                          BigDecimal descuentoPartiTotal = null;


                          for (T_Inf aux: wrespue) {
                          

                              if (aux.getMaterial() != null && 
                                  !aux.getMaterial().equals("")) {
                                  consulta.setMaterial(aux.getMaterial());
                                  consulta.setNombreMaterial(servicioSeleccion);
                                  consulta.setCantidadMaterial(spservicio.getCantservi());
                                  consulta.setLugarServicio(spservicio.getLugarservi());

                                  if (aux.getClaseCond() != null && 
                                      aux.getClaseCond().equals("ZPR0")) {
                                      tarifa = aux.getImporte();
                                      StringTokenizer st = 
                                          new StringTokenizer(aux.getImporte(), ".");
                                      importe = st.nextToken();
                                      consulta.setImporteAdulto(new BigDecimal(importe));

                                      consulta.setImporteEmpleado(new BigDecimal(importe));
                                      consulta.setImporteJoven(new BigDecimal(importe));
                                      consulta.setImporteJovenAdulto(new BigDecimal(importe));
                                      consulta.setImporteParticular(new BigDecimal(importe));
                                  }


                                  if
                                      //TODO: VERIFICAR QUE TARIFA TRAE
                                      (aux.getClaseCond() != null && 
                                       aux.getClaseCond().equals("ZJOV") && 
                                       aux.getSuplemento() != null && 
                                       aux.getSuplemento().equals("AD")) {
                                      StringTokenizer st = 
                                          new StringTokenizer(aux.getImporte(), ".");
                                      descuentoAdul = st.nextToken();
                                      descuentoAdulto = aux.getImporte();


                                      if (aux.getUnidadCond() != null) {
                                          if (aux.getUnidadCond().equals("COP")) {
                                              claseDescuentoAdulto = "COP";

                                          } else {
                                              claseDescuentoAdulto = "POR";
                                          }
                                      }

                                  }
                                  if (aux.getClaseCond() != null && 
                                      aux.getClaseCond().equals("ZEMP")) {
                                      StringTokenizer st = 
                                          new StringTokenizer(aux.getImporte(), ".");
                                      descuentoEmp = st.nextToken();

                                      descuentoEmpleado = aux.getImporte();


                                      if (aux.getUnidadCond() != null) {
                                          if (aux.getUnidadCond().equals("COP")) {
                                              claseDescuentoEmpleado = "COP";

                                          } else {
                                              claseDescuentoEmpleado = "POR";
                                          }
                                      }


                                  }

                                  if (aux.getClaseCond() != null && 
                                      aux.getClaseCond().equals("ZJOV") && 
                                      aux.getSuplemento() != null && 
                                      aux.getSuplemento().equals("JD")) {
                                      StringTokenizer st = 
                                          new StringTokenizer(aux.getImporte(), ".");
                                      descuentoJov = st.nextToken();
                                      descuentoJoven = aux.getImporte();


                                      if (aux.getUnidadCond() != null) {
                                          if (aux.getUnidadCond().equals("COP")) {
                                              claseDescuentoJoven = "COP";

                                          } else {
                                              claseDescuentoJoven = "POR";
                                          }
                                      }
                                  }
                                  if (aux.getClaseCond() != null && 
                                      aux.getClaseCond().equals("ZJOV") && 
                                      aux.getSuplemento() != null && 
                                      aux.getSuplemento().equals("JA")) {
                                      StringTokenizer st = 
                                          new StringTokenizer(aux.getImporte(), ".");
                                      descuentoJovAdul = st.nextToken();

                                      descuentoJovenAdulto = aux.getImporte();


                                      if (aux.getUnidadCond() != null) {
                                          if (aux.getUnidadCond().equals("COP")) {
                                              claseDescuentoJovenAdulto = "COP";

                                          } else {
                                              claseDescuentoJovenAdulto = "POR";
                                          }

                                      }
                                  }

                              }

                              if (aux.getClaseCond() != null && 
                                  aux.getClaseCond().equals("ZPRO")) {

                              }


                          }


                          if (claseDescuentoAdulto != null && tarifa != null && 
                              !tarifa.equals("") && descuentoAdulto != null && 
                              !descuentoAdulto.equals("")) {
                              BigDecimal descuentoAdultoInt = null;
                              BigDecimal tarifaInt = null;
                              BigDecimal divide = null;


                              divide = new BigDecimal(100);

                              descuentoAdultoInt = new BigDecimal(descuentoAdulto);
                              tarifaInt = new BigDecimal(tarifa);

                              if (claseDescuentoAdulto.equals("COP")) {
                                  descuentoAdulTotal = 
                                          ((tarifaInt.subtract(descuentoAdultoInt)).setScale(0));

                                  consulta.setDescuentoAdulto((tarifaInt.subtract(descuentoAdultoInt)).setScale(0));

                              } else if (claseDescuentoAdulto.equals("POR")) {
                              
                                  descuentoAdulTotal = ((tarifaInt.multiply(descuentoAdultoInt).divide(divide, 
                                                                                                             BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("-1")).setScale(0));
                              
                              
                                  consulta.setDescuentoAdulto((tarifaInt.multiply(descuentoAdultoInt).divide(divide, 
                                                                                                             BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("-1")).setScale(0));
                              }
                          } else if (descuentoAdulto.equals("") && 
                                     claseDescuentoAdulto.equals("") && !tarifa.equals("")) {
                              BigDecimal cero = null;
                              cero = new BigDecimal(0);
                              consulta.setDescuentoAdulto(cero);
                          }

                          if (claseDescuentoJoven != null && tarifa != null && 
                              !tarifa.equals("") && descuentoJoven != null && 
                              !descuentoJoven.equals("")) {
                              BigDecimal descuentoJovenBig = null;
                              BigDecimal tarifaBig = null;

                              BigDecimal divide = null;
                              divide = new BigDecimal(100);

                              descuentoJovenBig = new BigDecimal(descuentoJoven);
                              tarifaBig = new BigDecimal(tarifa);
                              if (claseDescuentoJoven.equals("COP")) {

                                  descuentoJovTotal = ((descuentoJovenBig.multiply(new BigDecimal(-1)))).setScale(0);

                                  consulta.setDescuentoJoven(((descuentoJovTotal)).setScale(0));

                              } else if (claseDescuentoJoven.equals("POR")) {
                              descuentoJovTotal = (((tarifaBig.multiply(descuentoJovenBig).divide(divide, 
                                                                                                            BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("-1"))).setScale(0));
                                  consulta.setDescuentoJoven(((tarifaBig.multiply(descuentoJovenBig).divide(divide, 
                                                                                                            BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("-1"))).setScale(0));
                              }
                          } else if (descuentoJoven.equals("") && 
                                     claseDescuentoJoven.equals("") && !tarifa.equals("")) {
                              BigDecimal cero = null;
                              cero = new BigDecimal(0);
                              consulta.setDescuentoJoven(cero);
                          }

                          if (claseDescuentoJovenAdulto != null && tarifa != null && 
                              !tarifa.equals("") && descuentoJovenAdulto != null && 
                              !descuentoJovenAdulto.equals("")) {
                              BigDecimal descuentoJovenAdultoBig = null;
                              BigDecimal tarifaBig = null;
                              BigDecimal porcentaje = null;
                              porcentaje = new BigDecimal(100);
                              descuentoJovenAdultoBig = new BigDecimal(descuentoJovenAdulto);
                              tarifaBig = new BigDecimal(tarifa);
                              if (claseDescuentoJovenAdulto.equals("COP")) {
                              
                                  descuentoJovAdultoTotal = (((descuentoJovenAdultoBig).multiply(new BigDecimal(-1))).setScale(0));
                                  consulta.setDescuentoJovenAdulto(((descuentoJovAdultoTotal)).setScale(0));

                              } else if (claseDescuentoJovenAdulto.equals("POR")) {
                              
                                  descuentoJovAdultoTotal = (((tarifaBig.multiply(descuentoJovenAdultoBig).divide(porcentaje, 
                                                                                                                        BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("-1"))).setScale(0));
                              
                                  consulta.setDescuentoJovenAdulto(((tarifaBig.multiply(descuentoJovenAdultoBig).divide(porcentaje, 
                                                                                                                        BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal("-1"))).setScale(0));

                              }

                          } else if (descuentoJovenAdulto.equals("") && 
                                     claseDescuentoJovenAdulto.equals("") && 
                                     !tarifa.equals("")) {
                              BigDecimal cero = null;
                              cero = new BigDecimal(0);
                              consulta.setDescuentoJovenAdulto(cero);
                          }

                          if (claseDescuentoEmpleado != null && tarifa != null && 
                              !tarifa.equals("") && descuentoEmpleado != null && 
                              !descuentoEmpleado.equals("")) {
                              BigDecimal descuentoEmpleadoBig = null;
                              BigDecimal tarifaBig = null;
                              BigDecimal porcentaje = null;
                              porcentaje = new BigDecimal(100);
                              descuentoEmpleadoBig = new BigDecimal(descuentoEmpleado);
                              tarifaBig = new BigDecimal(tarifa);
                              if (claseDescuentoEmpleado.equals("COP")) {
                                  descuentoEmplTotal = (((descuentoEmpleadoBig).multiply(new BigDecimal(-1))).setScale(0));
                              
                                  consulta.setDescuentoEmpleado(((descuentoEmplTotal)).setScale(0));

                              } else if (claseDescuentoEmpleado.equals("POR")) {
                                  descuentoEmplTotal = (((tarifaBig.multiply(descuentoEmpleadoBig).divide(porcentaje, 
                                                                                                                  BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("-1")))).setScale(0));
                              
                                  consulta.setDescuentoEmpleado(((tarifaBig.multiply(descuentoEmpleadoBig).divide(porcentaje, 
                                                                                                                  BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("-1")))).setScale(0));

                              }

                          } else if (descuentoEmpleado.equals("") && 
                                     claseDescuentoEmpleado.equals("") && 
                                     !tarifa.equals("")) {
                              BigDecimal cero = null;
                              cero = new BigDecimal(0);
                              consulta.setDescuentoEmpleado(cero);
                          }


                          if (claseDescuentoParticular != null && 
                              descuentoParticular.equals("") && 
                              descuentoParticular != null && !tarifa.equals("")) {
                              BigDecimal cero = null;
                              cero = new BigDecimal(0);
                              consulta.setDescuentoParticular(cero);
                          }

                          if (claseDescuentoAdulto != null && tarifa != null && 
                              !tarifa.equals("") && descuentoAdulto != null && 
                              !descuentoAdulto.equals("")) {
                              BigDecimal descuentoAdulInt = null;
                              BigDecimal tarifat = null;
                              descuentoAdulInt = new BigDecimal(descuentoAdulto);
                              tarifat = new BigDecimal(tarifa);

                              if (descuentoAdulTotal != null && tarifat != null && !descuentoAdulTotal.equals("")) {
                                  consulta.setTotalAdulto((tarifat.subtract(descuentoAdulTotal)).setScale(0));
                              } 

                          }else {
                              consulta.setTotalAdulto(consulta.getImporteAdulto());
                          }

                          if (claseDescuentoJoven != null && tarifa != null && 
                              !tarifa.equals("") && descuentoJoven != null && 
                              !descuentoJoven.equals("")) {
                              BigDecimal descuentoJovInt = null;
                              BigDecimal tarifato = null;
                              descuentoJovInt = new BigDecimal(descuentoJoven);
                              tarifato = new BigDecimal(tarifa);
                              if (descuentoJovTotal != null && tarifato != null) {
                                  consulta.setTotalJoven((tarifato.subtract(descuentoJovTotal)).setScale(0));
                              }
                          } else {
                              consulta.setTotalJoven(consulta.getImporteJoven());
                          }
                          
                          
                          if (claseDescuentoEmpleado != null && tarifa != null && 
                              !tarifa.equals("") && descuentoEmpleado != null && 
                              !descuentoEmpleado.equals("")) {
                              
                              BigDecimal tari = null;
                              
                              tari = new BigDecimal(tarifa);
                              if (descuentoEmplTotal != null && tari != null) {
                                  consulta.setTotalEmpleado((tari.subtract(descuentoEmplTotal)).setScale(0));
                              }
                          } else {
                              consulta.setTotalEmpleado(consulta.getImporteEmpleado());
                          }
                          
                          
                          if (claseDescuentoJovenAdulto != null && tarifa != null && 
                              !tarifa.equals("") && descuentoJovenAdulto != null && 
                              !descuentoJovenAdulto.equals("")) {
                              
                              BigDecimal tari = null;
                              
                              tari = new BigDecimal(tarifa);
                              if (descuentoJovAdultoTotal != null && tari != null) {
                                  consulta.setTotalJovenAdulto((tari.subtract(descuentoJovAdultoTotal)).setScale(0));
                              }
                          } else {
                              consulta.setTotalJovenAdulto(consulta.getImporteJovenAdulto());
                          }
                          
                          if (claseDescuentoParticular != null && tarifa != null && 
                              !tarifa.equals("") && descuentoParticular != null && 
                              !descuentoParticular.equals("")) {
                              
                              BigDecimal tari = null;
                              
                              tari = new BigDecimal(tarifa);
                              if (descuentoPartiTotal != null && tari != null) {
                                  consulta.setTotalParticular((tari.subtract(descuentoPartiTotal)).setScale(0));
                              }
                          } else {
                              consulta.setTotalParticular(consulta.getImporteParticular());
                          }
                          
                          ltsTarifaServicio.add(consulta);
                    
                    
                     
                      
                          
                          


                      }
                       
                   } catch (Exception e) {
                       System.out.println(e);
                       FacesUtils.addErrorMessage("SAP:"+ e);
                   }
                             
       }else{
           FacesUtils.addErrorMessage("No puede adicionar mas de una vez el servicio, utilice el campo CANTIDAD");
       }

    


    }


    public void setWrespue(T_Inf[] wrespue) {
        this.wrespue = wrespue;
    }

    public T_Inf[] getWrespue() {
        return wrespue;
    }

    public void setLtsServicioSap(List<T_Inf> ltsServicioSap) {
        this.ltsServicioSap = ltsServicioSap;
    }

    public List<T_Inf> getLtsServicioSap() {
        return ltsServicioSap;
    }

    public void setLtsTarifaServicio(List<Chconsutarif> ltsTarifaServicio) {
        this.ltsTarifaServicio = ltsTarifaServicio;
    }

    public List<Chconsutarif> getLtsTarifaServicio() {
        return ltsTarifaServicio;
    }

    public void setConsulta(Chconsutarif consulta) {
        this.consulta = consulta;
    }

    public Chconsutarif getConsulta() {
        return consulta;
    }

    public void setList(T_Inf list) {
        this.list = list;
    }

    public T_Inf getList() {
        return list;
    }

    public void setItServicio(UIInput itServicio) {
        this.itServicio = itServicio;
    }

    public UIInput getItServicio() {
        return itServicio;
    }
}
