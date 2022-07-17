package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.ChcontroliquPK;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.ChnotaenfermPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ControlLiquidosBean extends BaseBean {

    private Chcontroliqu liquidoDelete;

    private Chcontroliqu liquidoViaOral;

    private boolean generoReporte;

    private List<Chcontroliqu> lstLiquidosEliminadosSelect;

    private List<Chcontroliqu> lstLiquidosAdministrar;

    private List lstTipoDiuresis;

    private List lstTipoDrenaje;

    private HtmlDataTable dtLiquidosParciales;

    private HtmlDataTable dtLiquidosFormuladosAnestesia;

    private HtmlDataTable dtLiquidosEliminados;

    private Chcirugprogr cirugia;

    private boolean esIngreso;

    private List lstCirugias;

    private HtmlDataTable dtCirugias;

    private List<SelectItem> listHora;

    private List<SelectItem> lstMinutos;

    private List<Chcontroliqu> lstLiquidosAdministrados;

    /* Guarda la lista de liquidos que han sido terminados parcialmente */
    private List<Chcontroliqu> lstLiquidosParciales;

    private List<Chcontroliqu> lstHistorialLiquidosEliminados;

    private boolean renderDiuresis;

    private boolean renderCantidadDiuresis;

    private boolean renderDeposiciones;

    private boolean renderCantidadDeposiciones;

    private boolean renderDrenaje;

    private boolean renderCantidadDrenaje;

    private boolean renderEmesis;

    private boolean renderEmeCuanti;

    private UIInput mnuDiuresis;

    private UIInput mnuDeposiciones;

    private UIInput mnuDrenaje;

    private UIInput mnuEmesis;

    private UIInput mnuCuantifi;

    private UIInput mnuTipoDiuresis;

    private UIInput mnuCuantificadaDiuresis;

    private UIInput itCantidadDiuresis;

    private UIInput mnuCuantificadaDeposiciones;

    private UIInput itCantidadDeposiciones;

    private UIInput itCantidadEmesis;

    private UIInput mnuTipoDrenaje;

    private UIInput mnuCuantificadaDrenaje;

    private UIInput itCantidadDrenaje;

    private HtmlDataTable dtLiquidosFormulados;

    private HtmlDataTable dtLiquidosFormuladosExterna;

    private List<Chformulaliq> lstLiquidosFormulados;

    private List<Chformulaliq> lstLiquidosFormuladosExterna;

    private List<Chformulaliq> lstLiquidosFormuladosSelect;

    private Integer tiempoEliminacion;

    private Integer totalLiqAdmin;

    private Integer totalLiqElim;

    private List lstOpciones;

    private Chusuario usuario;

    private List<Chcontroliqu> lstLiquidosSelect;

    private String navegationRule;

    private String nextAction;

    private Chdetacirpro detalleCirugia;

    private Cpservicio servicio;

    private String usuarioSystem;

    private String radioLiquidosViaOral;

    private boolean renderLiquidosViaOral;

    private boolean renderLiquidosViaOralOtro;
    
    private String legendServicio;
    
    private List<Cnconsclin> lstConsclin;
    
    private boolean notaEnfeProce;
    
    private String legendTablaServicio;
    
    private List<Chnotaenferm> lstNotaEnfermeria;

    public ControlLiquidosBean() {
    }

    public void init() {

        liquidoDelete = new Chcontroliqu();
        liquidoViaOral = new Chcontroliqu();
        lstLiquidosEliminadosSelect = new ArrayList<Chcontroliqu>();
        lstNotaEnfermeria = new ArrayList<Chnotaenferm>();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        listHora = new ArrayList<SelectItem>();
        lstMinutos = new ArrayList<SelectItem>();
        lstLiquidosAdministrar = new ArrayList<Chcontroliqu>();
        lstLiquidosParciales = new ArrayList<Chcontroliqu>();
        lstHistorialLiquidosEliminados = new ArrayList<Chcontroliqu>();
        lstLiquidosFormulados = new ArrayList<Chformulaliq>();
        lstLiquidosFormuladosSelect = new ArrayList<Chformulaliq>();
        totalLiqAdmin = 0;
        totalLiqElim = 0;
        setGeneroReporte(false);
        renderLiquidosViaOral = false;
        renderLiquidosViaOralOtro = false;
        legendServicio="Cirugia(s) Programada(s)";
        legendTablaServicio ="Intervenci�n(es)";

        if (cirugia != null) {
           try {
                lstLiquidosAdministrar = 
                      this.serviceLocator.getCirugiaService().getLstLiquidosFormuladosAnestesia(cirugia.getHcplnumero());
           } catch (ModelException e) {
                e.printStackTrace();
           }
           if (lstLiquidosAdministrar != null && !lstLiquidosAdministrar.isEmpty()) {
               for (Chcontroliqu formu: lstLiquidosAdministrar) {
                   try {
                       usuarioSystem = 
                            this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                   } catch (ModelException e) {
                       e.printStackTrace();
                   }
                   if (usuarioSystem != null) {
                       formu.setNombreOperador(usuarioSystem);
                   }
               }
           }

           if (lstLiquidosAdministrar == null) {
               lstLiquidosAdministrar = new ArrayList<Chcontroliqu>();
           }

           try {
               detalleCirugia = 
                      this.serviceLocator.getCirugiaService().getServicioDetalle(cirugia.getHcplnumero());
           } catch (ModelException e) {
               e.printStackTrace();
           }

           try {
               lstLiquidosAdministrados = 
                     this.serviceLocator.getClinicoService().getLstLiquidosAdministrados(cirugia.getHcplnumero());

               lstLiquidosFormulados = 
                     this.serviceLocator.getCirugiaService().getLstLiquidosFormulados(cirugia.getHcplnumero(), 
                                                                                             TIPO_HOSPITALIZACION, 
                                                                                             null,null);
               if (lstLiquidosFormulados != null && !lstLiquidosFormulados.isEmpty()) {
                   for (Chformulaliq formu: lstLiquidosFormulados) {
                       try {
                           usuarioSystem = 
                                 this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                       } catch (ModelException e) {
                           e.printStackTrace();
                       }

                       if (usuarioSystem != null) {
                           formu.setNombreOperador(usuarioSystem);
                       }
                   }
               }

               lstLiquidosParciales = 
                       this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcial(cirugia.getHcplnumero());
               if (lstLiquidosParciales != null && lstLiquidosParciales.isEmpty()) {
                  for (Chcontroliqu liqpa: lstLiquidosParciales) {
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("01")) {
                          liqpa.setHclcdesctipoli("Lactato de Ringer");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("02")) {
                          liqpa.setHclcdesctipoli("Haemacell");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("03")) {
                          liqpa.setHclcdesctipoli("Dextranes");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("04")) {
                          liqpa.setHclcdesctipoli("Globulos Rojos");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("05")) {
                          liqpa.setHclcdesctipoli("Sangre total");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("06")) {
                          liqpa.setHclcdesctipoli("Plasma");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("07")) {
                          liqpa.setHclcdesctipoli("Plaquetas");
                      }
                      if (liqpa.getHclctipoliqpar() != null && 
                          liqpa.getHclctipoliqpar().equals("08")) {
                          liqpa.setHclcdesctipoli(" Soluci�n Salina Normal 0.9%");
                      }
                      if (liqpa.getHclcetapa().equals("IL")) {
                          liqpa.setHclcmoduladmin("Anestesia");
                      }
                      if (liqpa.getHclcetapa().equals("VG")) {
                          liqpa.setHclcmoduladmin("Enfermeria");
                      }

                      try {
                          usuarioSystem = 
                                this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                      } catch (ModelException e) {
                          e.printStackTrace();
                      }

                      if (usuarioSystem != null) {
                          liqpa.setNombreOperador(usuarioSystem);
                      }
                  }
               }

               lstHistorialLiquidosEliminados = 
                      this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());

               lstLiquidosFormuladosExterna = 
                      this.serviceLocator.getCirugiaService().getLstLiquidosFormuladosConsultaExterna(cirugia.getHcplusuario().getHuslnumero(), 
                                                                                                            cirugia.getHcplnumero());

               if (lstLiquidosFormuladosExterna != null && !lstLiquidosFormuladosExterna.isEmpty()) {
                   for (Chformulaliq formula: lstLiquidosFormuladosExterna) {
                       try {
                           usuarioSystem = 
                                 this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                       } catch (ModelException e) {
                           e.printStackTrace();
                       }

                       if (usuarioSystem != null) {
                           formula.setNombreOperador(usuarioSystem);
                       }
                   }
               }

               if (lstLiquidosAdministrados == null || lstLiquidosAdministrados.isEmpty()) {
                   lstLiquidosAdministrados = new ArrayList<Chcontroliqu>();
               } else {
                   for (Chcontroliqu contrliq: lstLiquidosAdministrados) {
                       if (contrliq.getHclncantisumin() != null)
                           totalLiqAdmin += contrliq.getHclncantisumin();
                       contrliq.setTipoRegistro("A");
                   }
               }

               if (lstHistorialLiquidosEliminados == null || lstHistorialLiquidosEliminados.isEmpty()) {
                   lstHistorialLiquidosEliminados = new ArrayList<Chcontroliqu>();
               } else {
                   for (Chcontroliqu contrliq: lstHistorialLiquidosEliminados) {
                       if (contrliq.getHclndrenaje() != null) {
                           totalLiqElim += contrliq.getHclndrenaje();
                       }
                       if (contrliq.getHclndiuresis() != null) {
                           totalLiqElim += contrliq.getHclndiuresis();
                       }
                       if (contrliq.getHclndeposicion() != null) {
                           totalLiqElim += contrliq.getHclndeposicion();
                       }
                       if (contrliq.getHclnemecan() != null) {
                           totalLiqElim += contrliq.getHclnemecan();
                       }
                       contrliq.setTipoRegistro("E");
                   }
               }
               
               if(notaEnfeProce){
                   legendServicio="Procedimiento(s)";
                   legendTablaServicio ="Procedimiento(s)"; 
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

               if (cirugia.getChdetacirpros() != null && !cirugia.getChdetacirpros().isEmpty()) {
                   Chdetacirpro detalle = null;
                   Iterator it = cirugia.getChdetacirpros().iterator();
                   while (it.hasNext()) {
                      detalle = (Chdetacirpro)it.next();
                      if (detalle != null && detalle.getId() != null && detalle.getId().getHdccservicio() != null) {
                          Cpservicio servicio = 
                              this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                          lstCirugias.add(servicio);
                      }
                   }
               }
           } catch (ModelException e) {
               e.printStackTrace();
           }
        }
    }


    public void actualizarDatos() {
        if (cirugia != null) {
           try {
               lstLiquidosAdministrados = 
                      this.serviceLocator.getClinicoService().getLstLiquidosAdministrados(cirugia.getHcplnumero());

               lstLiquidosFormulados = 
                      this.serviceLocator.getCirugiaService().getLstLiquidosFormulados(cirugia.getHcplnumero(), 
                                                                                             TIPO_HOSPITALIZACION, 
                                                                                             null,null);
               if (lstLiquidosFormulados != null && !lstLiquidosFormulados.isEmpty()) {
                  for (Chformulaliq formu: lstLiquidosFormulados) {
                      try {
                          usuarioSystem = 
                                 this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                      } catch (ModelException e) {
                          e.printStackTrace();
                      }
                      if (usuarioSystem != null) {
                           formu.setNombreOperador(usuarioSystem);
                      }
                  }
               }

               lstLiquidosParciales = 
                      this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcial(cirugia.getHcplnumero());

               lstHistorialLiquidosEliminados = 
                      this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());

               lstLiquidosFormuladosExterna = 
                      this.serviceLocator.getCirugiaService().getLstLiquidosFormuladosConsultaExterna(cirugia.getHcplusuario().getHuslnumero(), 
                                                                                                       cirugia.getHcplnumero());
               if (lstLiquidosFormuladosExterna != null && !lstLiquidosFormuladosExterna.isEmpty()) {
                   for (Chformulaliq formula: lstLiquidosFormuladosExterna) {
                       try {
                           usuarioSystem = 
                                 this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                       } catch (ModelException e) {
                           e.printStackTrace();
                       }
                       if (usuarioSystem != null) {
                           formula.setNombreOperador(usuarioSystem);
                       }
                   }
               }
           } catch (ModelException e) {
               e.printStackTrace();
           }
       }
    }

    public void guardarLiquidoViaOral() {
        generoReporte = false;
        lstLiquidosSelect = new ArrayList<Chcontroliqu>();

        if (liquidoViaOral != null) {
            Chcontroliqu liquidoAux;
            liquidoAux = new Chcontroliqu();

            liquidoAux.getId().setHcllnumero(cirugia.getHcplnumero());
            liquidoAux.getId().setHclctiposervi(TIPO_HOSPITALIZACION);

            liquidoAux.setHclctipoliqpar(liquidoViaOral.getHclctipoliquid());
            liquidoAux.setHclctipoliquid(liquidoViaOral.getHclctipoliquid());
            liquidoAux.setHclcoperador(userName());
            liquidoAux.setHclcvialiquido("OR");
            liquidoAux.setHclncantidad(liquidoViaOral.getHclncantidad());
            liquidoAux.setHclncantisumin(liquidoViaOral.getHclncantidad());
            liquidoAux.setHcldfechactivi(new Date());
            liquidoAux.setHcldfechactfin(new Date());
            liquidoAux.setHcldfecregistr(new Date());
            liquidoAux.setHclcotroliqpar(ETAPA_INGRESO);
            liquidoAux.setHclnclinica(getClinica().getCclncodigo());
            liquidoAux.setHclbdeshaelimi(true);
            liquidoAux.setHcllusuario(cirugia.getHcplusuario().getHuslnumero());
            liquidoAux.setHclcetapa(ETAPA_ATENDIDO);
            liquidoAux.setHclcestado(ETAPA_VIGENTE);
            liquidoAux.setHclcetapcontro("EN");
            liquidoAux.setHclcotroliqvo(liquidoViaOral.getHclcotroliqvo());
            liquidoAux.setHclcoobsliqvo(liquidoViaOral.getHclcoobsliqvo());
            lstLiquidosSelect.add(liquidoAux);

            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidosViaOral(lstLiquidosSelect, 
                                                                                       cirugia.getHcplnumero());
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                liquidoViaOral = new Chcontroliqu();
                renderLiquidosViaOral = false;
                renderLiquidosViaOralOtro = false;
                init();
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    /**
     * @param renderDiuresis
     */
    public void setRenderDiuresis(boolean renderDiuresis) {
        this.renderDiuresis = renderDiuresis;
    }

    /**
     * @return
     */
    public boolean isRenderDiuresis() {
        return renderDiuresis;
    }

    /**
     * @param renderCantidadDiuresis
     */
    public void setRenderCantidadDiuresis(boolean renderCantidadDiuresis) {
        this.renderCantidadDiuresis = renderCantidadDiuresis;
    }

    /**
     * @return
     */
    public boolean isRenderCantidadDiuresis() {
        return renderCantidadDiuresis;
    }

    /**
     * @param renderDeposiciones
     */
    public void setRenderDeposiciones(boolean renderDeposiciones) {
        this.renderDeposiciones = renderDeposiciones;
    }

    /**
     * @return
     */
    public boolean isRenderDeposiciones() {
        return renderDeposiciones;
    }

    /**
     * @param renderCantidadDeposiciones
     */
    public void setRenderCantidadDeposiciones(boolean renderCantidadDeposiciones) {
        this.renderCantidadDeposiciones = renderCantidadDeposiciones;
    }

    /**
     * @return
     */
    public boolean isRenderCantidadDeposiciones() {
        return renderCantidadDeposiciones;
    }

    /**
     * @param renderDrenaje
     */
    public void setRenderDrenaje(boolean renderDrenaje) {
        this.renderDrenaje = renderDrenaje;
    }

    /**
     * @return
     */
    public boolean isRenderDrenaje() {
        return renderDrenaje;
    }

    /**
     * @param renderEmesis
     */
    public void setRenderEmesis(boolean renderEmesis) {
        this.renderEmesis = renderEmesis;
    }

    /**
     * @return
     */
    public boolean isRenderEmesis() {
        return renderEmesis;
    }

    /**
     * @param renderCantidadDrenaje
     */
    public void setRenderCantidadDrenaje(boolean renderCantidadDrenaje) {
        this.renderCantidadDrenaje = renderCantidadDrenaje;
    }

    /**
     * @return
     */
    public boolean isRenderCantidadDrenaje() {
        return renderCantidadDrenaje;
    }


    /**
     * @param mnuTipoDiuresis
     */
    public void setMnuTipoDiuresis(UIInput mnuTipoDiuresis) {
        this.mnuTipoDiuresis = mnuTipoDiuresis;
    }

    /**
     * @return
     */
    public UIInput getMnuTipoDiuresis() {
        return mnuTipoDiuresis;
    }

    /**
     * @param mnuCuantificadaDiuresis
     */
    public void setMnuCuantificadaDiuresis(UIInput mnuCuantificadaDiuresis) {
        this.mnuCuantificadaDiuresis = mnuCuantificadaDiuresis;
    }

    /**
     * @return
     */
    public UIInput getMnuCuantificadaDiuresis() {
        return mnuCuantificadaDiuresis;
    }

    /**
     * @param itCantidadDiuresis
     */
    public void setItCantidadDiuresis(UIInput itCantidadDiuresis) {
        this.itCantidadDiuresis = itCantidadDiuresis;
    }

    /**
     * @return
     */
    public UIInput getItCantidadDiuresis() {
        return itCantidadDiuresis;
    }

    /**
     * @param mnuCuantificadaDeposiciones
     */
    public void setMnuCuantificadaDeposiciones(UIInput mnuCuantificadaDeposiciones) {
        this.mnuCuantificadaDeposiciones = mnuCuantificadaDeposiciones;
    }

    /**
     * @return
     */
    public UIInput getMnuCuantificadaDeposiciones() {
        return mnuCuantificadaDeposiciones;
    }

    /**
     * @param itCantidadDeposiciones
     */
    public void setItCantidadDeposiciones(UIInput itCantidadDeposiciones) {
        this.itCantidadDeposiciones = itCantidadDeposiciones;
    }

    /**
     * @return
     */
    public UIInput getItCantidadDeposiciones() {
        return itCantidadDeposiciones;
    }

    /**
     * @param mnuTipoDrenaje
     */
    public void setMnuTipoDrenaje(UIInput mnuTipoDrenaje) {
        this.mnuTipoDrenaje = mnuTipoDrenaje;
    }

    /**
     * @return
     */
    public UIInput getMnuTipoDrenaje() {
        return mnuTipoDrenaje;
    }

    /**
     * @param mnuCuantificadaDrenaje
     */
    public void setMnuCuantificadaDrenaje(UIInput mnuCuantificadaDrenaje) {
        this.mnuCuantificadaDrenaje = mnuCuantificadaDrenaje;
    }

    /**
     * @return
     */
    public UIInput getMnuCuantificadaDrenaje() {
        return mnuCuantificadaDrenaje;
    }

    /**
     * @param itCantidadDrenaje
     */
    public void setItCantidadDrenaje(UIInput itCantidadDrenaje) {
        this.itCantidadDrenaje = itCantidadDrenaje;
    }

    /**
     * @return
     */
    public UIInput getItCantidadDrenaje() {
        return itCantidadDrenaje;
    }

    /**
     * @param mnuDiuresis
     */
    public void setMnuDiuresis(UIInput mnuDiuresis) {
        this.mnuDiuresis = mnuDiuresis;
    }

    /**
     * @return
     */
    public UIInput getMnuDiuresis() {
        return mnuDiuresis;
    }

    /**
     * @param mnuDeposiciones
     */
    public void setMnuDeposiciones(UIInput mnuDeposiciones) {
        this.mnuDeposiciones = mnuDeposiciones;
    }

    /**
     * @return
     */
    public UIInput getMnuDeposiciones() {
        return mnuDeposiciones;
    }

    /**
     * @param mnuDrenaje
     */
    public void setMnuDrenaje(UIInput mnuDrenaje) {
        this.mnuDrenaje = mnuDrenaje;
    }

    /**
     * @return
     */
    public UIInput getMnuDrenaje() {
        return mnuDrenaje;
    }

    /**
     * @param mnuEmesis
     */
    public void setMnuEmesis(UIInput mnuEmesis) {
        this.mnuEmesis = mnuEmesis;
    }

    /**
     * @return
     */
    public UIInput getMnuEmesis() {
        return mnuEmesis;
    }

    /**
     * @param lstLiquidosAdministrados
     */
    public void setLstLiquidosAdministrados(List<Chcontroliqu> lstLiquidosAdministrados) {
        this.lstLiquidosAdministrados = lstLiquidosAdministrados;
    }

    /**
     * @return
     */
    public List<Chcontroliqu> getLstLiquidosAdministrados() {
        return lstLiquidosAdministrados;
    }


    /**
     * @param lstLiquidosEliminadosSelect
     */
    public void setLstLiquidosEliminadosSelect(List<Chcontroliqu> lstLiquidosEliminadosSelect) {
        this.lstLiquidosEliminadosSelect = lstLiquidosEliminadosSelect;
    }

    /**
     * @return
     */
    public List<Chcontroliqu> getLstLiquidosEliminadosSelect() {
        return lstLiquidosEliminadosSelect;
    }

    /**
     * @param listHora
     */
    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List<SelectItem> getListHora() {
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
     * @param lstMinutos
     */
    public void setLstMinutos(List<SelectItem> lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstMinutos() {
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
     * @param liquidoDelete
     */
    public void setLiquidoDelete(Chcontroliqu liquidoDelete) {
        this.liquidoDelete = liquidoDelete;
    }

    /**
     * @return
     */
    public Chcontroliqu getLiquidoDelete() {
        return liquidoDelete;
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
     * @param dtLiquidosParciales
     */
    public void setDtLiquidosParciales(HtmlDataTable dtLiquidosParciales) {
        this.dtLiquidosParciales = dtLiquidosParciales;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidosParciales() {
        return dtLiquidosParciales;
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
     * @param lstLiquidosParciales
     */
    public void setLstLiquidosParciales(List<Chcontroliqu> lstLiquidosParciales) {
        this.lstLiquidosParciales = lstLiquidosParciales;
    }

    /**
     * @return
     */
    public List<Chcontroliqu> getLstLiquidosParciales() {
        return lstLiquidosParciales;
    }

    /**
     * @param lstTipoDiuresis
     */
    public void setLstTipoDiuresis(List lstTipoDiuresis) {
        this.lstTipoDiuresis = lstTipoDiuresis;
    }

    /**
     * @return
     */
    public List getLstTipoDiuresis() {
        if (lstTipoDiuresis == null) {
            lstTipoDiuresis = new ArrayList();
            lstTipoDiuresis.add(new SelectItem("S", "Sonda"));
            lstTipoDiuresis.add(new SelectItem("E", "Espontanea"));
        }
        return lstTipoDiuresis;
    }

    /**
     * @param lstLiquidosFormuladosSelect
     */
    public void setLstLiquidosFormuladosSelect(List<Chformulaliq> lstLiquidosFormuladosSelect) {
        this.lstLiquidosFormuladosSelect = lstLiquidosFormuladosSelect;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstLiquidosFormuladosSelect() {
        return lstLiquidosFormuladosSelect;
    }

    /**
     * @param lstTipoDrenaje
     */
    public void setLstTipoDrenaje(List lstTipoDrenaje) {
        this.lstTipoDrenaje = lstTipoDrenaje;
    }

    /**
     * @return
     */
    public List getLstTipoDrenaje() {
        if (lstTipoDrenaje == null) {
            lstTipoDrenaje = new ArrayList();
            lstTipoDrenaje.add(new SelectItem("S", "Sonda"));
            lstTipoDrenaje.add(new SelectItem("H", "Hemovac"));
        }
        return lstTipoDrenaje;
    }

    /**
     * @param lstHistorialLiquidosEliminados
     */
    public void setLstHistorialLiquidosEliminados(List<Chcontroliqu> lstHistorialLiquidosEliminados) {
        this.lstHistorialLiquidosEliminados = lstHistorialLiquidosEliminados;
    }

    /**
     * @return
     */
    public List<Chcontroliqu> getLstHistorialLiquidosEliminados() {
        return lstHistorialLiquidosEliminados;
    }

    /**
     * @param dtLiquidosFormulados
     */
    public void setDtLiquidosFormulados(HtmlDataTable dtLiquidosFormulados) {
        this.dtLiquidosFormulados = dtLiquidosFormulados;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidosFormulados() {
        return dtLiquidosFormulados;
    }

    /**
     * @param lstLiquidosFormulados
     */
    public void setLstLiquidosFormulados(List<Chformulaliq> lstLiquidosFormulados) {
        this.lstLiquidosFormulados = lstLiquidosFormulados;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstLiquidosFormulados() {
        return lstLiquidosFormulados;
    }

    /**
     * @param tiempoEliminacion
     */
    public void setTiempoEliminacion(Integer tiempoEliminacion) {
        this.tiempoEliminacion = tiempoEliminacion;
    }

    /**
     * @return
     */
    public Integer getTiempoEliminacion() {
        return tiempoEliminacion;
    }

    /**
     * @param dtLiquidosEliminados
     */
    public void setDtLiquidosEliminados(HtmlDataTable dtLiquidosEliminados) {
        this.dtLiquidosEliminados = dtLiquidosEliminados;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidosEliminados() {
        return dtLiquidosEliminados;
    }

    // Value Change Listener

    /**
     * @param valueChangeEvent
     */
    public void setHclcdiuresis(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcdiuresis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclccuantdiure(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclccuantdiure((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclcdeposicion(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcdeposicion((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclccuantdepos(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclccuantdepos((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclcdrenaje(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcdrenaje((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclcemesis(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcemesis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclcemecua(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcemecua((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclccuantdrena(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclccuantdrena((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHclctipoliquid(ValueChangeEvent valueChangeEvent) {
        liquidoViaOral.setHclctipoliquid((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    // Acciones Data Table   
    public void agregarLiquidoEliminacion() {
        generoReporte = false;
        boolean wexito;
        wexito = true;

        if (liquidoDelete != null) {
            if ((liquidoDelete.getHclcdiuresis() == null) || 
                (liquidoDelete.getHclcdeposicion() == null) || 
                (liquidoDelete.getHclcdrenaje() == null) || 
                (liquidoDelete.getHclcemesis() == null) || 
                (liquidoDelete.getHclcdiuresis().equals("N") && 
                 liquidoDelete.getHclcdeposicion().equals("N") && 
                 liquidoDelete.getHclcdrenaje().equals("N") && 
                 liquidoDelete.getHclcemesis().equals("N"))) {
                wexito = false;
            }
        }

        if (wexito) {
            ChcontroliquPK idControl;
            idControl = new ChcontroliquPK();
            idControl.setHcllnumero(cirugia.getHcplnumero());
            idControl.setHclctiposervi(TIPO_HOSPITALIZACION);
            liquidoDelete.setHclcoperador(userName());
            liquidoDelete.setHcldfecregistr(new Date());
            liquidoDelete.setId(idControl);
            liquidoDelete.setHcldfechactivi(new Date());
            liquidoDelete.setHcldfechactfin(new Date());
            liquidoDelete.setHclnclinica(getClinica().getCclncodigo());
            liquidoDelete.setHclcetapa(ETAPA_DELETE);
            liquidoDelete.setHclcestado(ESTADO_VIGENTE);
            liquidoDelete.setHcllusuario(cirugia.getHcplusuario().getHuslnumero());
            lstLiquidosEliminadosSelect.add(liquidoDelete);
            liquidoDelete = new Chcontroliqu();
            renderCantidadDeposiciones = false;
            renderCantidadDiuresis = false;
            renderCantidadDrenaje = false;
            renderDeposiciones = false;
            renderDiuresis = false;
            renderDrenaje = false;
            renderEmesis = false;
            renderEmeCuanti = false;
        } else {
            FacesUtils.addErrorMessage("Debe seleccionar por lo menos un liquido");
        }
    }

    // Acciones AJAX
    public void changeDiuresis() {
        if (liquidoDelete.getHclcdiuresis() != null && 
            liquidoDelete.getHclcdiuresis().equals("S")) {
            renderDiuresis = true;
        } else {
            liquidoDelete.setHclctipodiure(null);
            liquidoDelete.setHclccuantdiure(null);
            liquidoDelete.setHclndiuresis(null);
            mnuTipoDiuresis.setValue(null);
            mnuCuantificadaDiuresis.setValue(null);
            itCantidadDiuresis.setValue(null);
            renderDiuresis = false;
            renderCantidadDiuresis = false;
        }
    }

    public void changeCuantificadaDiuresis() {
        if (liquidoDelete.getHclccuantdiure() != null && 
            liquidoDelete.getHclccuantdiure().equals("S")) {
            renderCantidadDiuresis = true;
        } else {
            liquidoDelete.setHclndiuresis(null);
            itCantidadDiuresis.setValue(null);
            renderCantidadDiuresis = false;
        }
    }

    public void changeDeposiciones() {
        if (liquidoDelete.getHclcdeposicion() != null && 
            liquidoDelete.getHclcdeposicion().equals("S")) {
            renderDeposiciones = true;
        } else {
            liquidoDelete.setHclccuantdepos(null);
            liquidoDelete.setHclndeposicion(null);
            mnuCuantificadaDeposiciones.setValue(true);
            itCantidadDeposiciones.setValue(null);
            renderDeposiciones = false;
            renderCantidadDeposiciones = false;
        }
    }

    public void changeCuantificadaDeposiciones() {
        if (liquidoDelete.getHclccuantdepos() != null && 
            liquidoDelete.getHclccuantdepos().equals("S")) {
            renderCantidadDeposiciones = true;
        } else {
            liquidoDelete.setHclndeposicion(null);
            itCantidadDeposiciones.setValue(null);
            renderCantidadDeposiciones = false;
        }
    }

    public void changeDrenaje() {
        if (liquidoDelete.getHclcdrenaje() != null && 
            liquidoDelete.getHclcdrenaje().equals("S")) {
            renderDrenaje = true;
        } else {
            liquidoDelete.setHclctipodrena(null);
            liquidoDelete.setHclccuantdrena(null);
            liquidoDelete.setHclndrenaje(null);
            liquidoDelete.setHclcemesis(null);
            mnuTipoDrenaje.setValue(null);
            mnuCuantificadaDrenaje.setValue(null);
            itCantidadDrenaje.setValue(null);
            renderDrenaje = false;
            renderCantidadDrenaje = false;
        }
    }

    public void changeEmesis() {
        if (liquidoDelete.getHclcemesis() != null && 
            liquidoDelete.getHclcemesis().equals("S")) {
            renderEmesis = true;
        } else {
            liquidoDelete.setHclcemesis(null);
            renderEmesis = false;
        }
    }

    public void changeEmesisCuanti() {
        if (liquidoDelete.getHclcemecua() != null && 
            liquidoDelete.getHclcemecua().equals("S")) {
            renderEmeCuanti = true;
        } else {
            liquidoDelete.setHclcemecua(null);
            itCantidadEmesis.setValue(null);
            renderEmeCuanti = false;
        }
    }

    public void changeCuantificadaDrenaje() {
        if (liquidoDelete.getHclccuantdrena() != null && 
            liquidoDelete.getHclccuantdrena().equals("S")) {
            renderCantidadDrenaje = true;
        } else {
            liquidoDelete.setHclndrenaje(null);
            itCantidadDrenaje.setValue(null);
            renderCantidadDrenaje = false;
        }
    }

    // Boton Principal
    /**
     * @return
     */
    public String administrarLiquido() {
        generoReporte = false;
        Chcontroliqu liquidosAux;
        liquidosAux = (Chcontroliqu)dtLiquidosParciales.getRowData();
        AdministracionLiquidosBean administracionBean;

        administracionBean = 
                (AdministracionLiquidosBean)FacesUtils.getManagedBean("administracionLiquidosBean");

        if (administracionBean != null && cirugia != null) {
            administracionBean.setCirugia(cirugia);
            administracionBean.setLiquidos(liquidosAux);
            if (esIngreso) {
                administracionBean.setNavegationRule(BeanNavegacion.RUTA_IR_LIQUIDOS_INGRESO_ENFERMERIA);
            } else {
                administracionBean.setNavegationRule(BeanNavegacion.RUTA_IR_CONTROL_LIQUIDOS);
            }
        }
        return BeanNavegacion.RUTA_IR_ADMINISTRAR_LIQUIDOS;
    }

    public void deleteLiquidoEliminado() {
        Chcontroliqu liquidoDelete = 
            (Chcontroliqu)dtLiquidosEliminados.getRowData();
        lstLiquidosEliminadosSelect.remove(liquidoDelete);

    }

    public void administrarLiquidoFormulado() {
        generoReporte = false;
        Chformulaliq formulaAdd;
        Chcontroliqu controlAdd;
        formulaAdd = (Chformulaliq)this.dtLiquidosFormulados.getRowData();
        lstLiquidosFormulados.remove(formulaAdd);

        lstLiquidosSelect = new ArrayList<Chcontroliqu>();

        if (formulaAdd != null) {
            Chcontroliqu liquidoAux;
            liquidoAux = new Chcontroliqu();
            liquidoAux.getId().setHcllnumero(cirugia.getHcplnumero());
            liquidoAux.getId().setHclctiposervi(TIPO_HOSPITALIZACION);
            liquidoAux.setHclctipoliqpar(formulaAdd.getHflcnombreliqu());
            liquidoAux.setHclctipoliquid(formulaAdd.getHflcnombreliqu());
            liquidoAux.setHclcoperador(userName());
            liquidoAux.setHclcvialiquido(formulaAdd.getHflcviadminist());
            liquidoAux.setHclncantidad(formulaAdd.getHflncantidad());
            liquidoAux.setHcldfechactivi(new Date());
            liquidoAux.setHcldfecregistr(new Date());
            liquidoAux.setHclcotroliqpar(ETAPA_INGRESO);
            liquidoAux.setHclnclinica(getClinica().getCclncodigo());
            liquidoAux.setHclctiposangre(formulaAdd.getHflctiposangre());
            liquidoAux.setHclcgrupsangre(formulaAdd.getHflcgrupsangre());
            liquidoAux.setHclcfactosangre(formulaAdd.getHflcfactosangre());
            liquidoAux.setHclnunidasangr(formulaAdd.getHflnunidasangr());
            liquidoAux.setHclnsellocalid(formulaAdd.getHflnsellocalid());
            liquidoAux.setHcldsangrvenci(formulaAdd.getHfldsangrvenci());
            liquidoAux.setHclbdeshaelimi(true);
            liquidoAux.setHcllusuario(cirugia.getHcplusuario().getHuslnumero());
            liquidoAux.setHclcetapa(ETAPA_VIGENTE);
            liquidoAux.setHclcestado(ETAPA_VIGENTE);
            liquidoAux.setHclcetapcontro("EN");
            liquidoAux.setHclnvelocidadm(formulaAdd.getHflnvelocidadm());
            lstLiquidosSelect.add(liquidoAux);
            lstLiquidosFormuladosSelect.add(formulaAdd);
            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidos(lstLiquidosSelect, 
                                                                                cirugia.getHcplnumero(), 
                                                                                lstLiquidosFormuladosSelect);
                lstLiquidosParciales = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcial(cirugia.getHcplnumero());
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public void administrarLiquidoFormuladoExterna() {
        generoReporte = false;
        Chformulaliq formulaAdd;
        formulaAdd = (Chformulaliq)this.dtLiquidosFormuladosExterna.getRowData();
        lstLiquidosFormuladosExterna.remove(formulaAdd);

        lstLiquidosSelect = new ArrayList<Chcontroliqu>();

        if (formulaAdd != null) {
            Chcontroliqu liquidoAux;
            liquidoAux = new Chcontroliqu();
            liquidoAux.getId().setHcllnumero(cirugia.getHcplnumero());
            liquidoAux.getId().setHclctiposervi(TIPO_HOSPITALIZACION);
            liquidoAux.setHclctipoliqpar("PA");
            liquidoAux.setHclctipoliquid(formulaAdd.getHflcnombreliqu());
            liquidoAux.setHclcoperador(userName());
            liquidoAux.setHclcvialiquido(formulaAdd.getHflcviadminist());
            liquidoAux.setHclncantidad(formulaAdd.getHflncantidad());
            liquidoAux.setHcldfechactivi(new Date());
            liquidoAux.setHcldfecregistr(new Date());
            liquidoAux.setHclcotroliqpar(ETAPA_INGRESO);
            liquidoAux.setHclnclinica(getClinica().getCclncodigo());
            liquidoAux.setHclctiposangre(formulaAdd.getHflctiposangre());
            liquidoAux.setHclcgrupsangre(formulaAdd.getHflcgrupsangre());
            liquidoAux.setHclcfactosangre(formulaAdd.getHflcfactosangre());
            liquidoAux.setHclnunidasangr(formulaAdd.getHflnunidasangr());
            liquidoAux.setHclnsellocalid(formulaAdd.getHflnsellocalid());
            liquidoAux.setHcldsangrvenci(formulaAdd.getHfldsangrvenci());
            liquidoAux.setHclbdeshaelimi(true);
            liquidoAux.setHclcetapa(ETAPA_VIGENTE);
            liquidoAux.setHclcestado(ETAPA_VIGENTE);
            liquidoAux.setHcllusuario(formulaAdd.getHfllusuario());
            liquidoAux.setHclnvelocidadm(formulaAdd.getHflnvelocidadm());
            lstLiquidosSelect.add(liquidoAux);
            lstLiquidosFormuladosSelect.add(formulaAdd);

            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidos(lstLiquidosSelect, 
                                                                                cirugia.getHcplnumero(), 
                                                                                lstLiquidosFormuladosSelect);
                lstLiquidosParciales = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcial(cirugia.getHcplnumero());

                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return
     */
    public String IngresoLiquidosEliminados() {
        setGeneroReporte(false);
        nextAction = "";
        Calendar fechaCalendarAdmin;
        fechaCalendarAdmin = null; 
        ChnotaenfermPK idNota;
        idNota = new ChnotaenfermPK();
        lstNotaEnfermeria = new ArrayList<Chnotaenferm>();

        if (lstLiquidosEliminadosSelect != null && 
            !lstLiquidosEliminadosSelect.isEmpty()) {
            
            fechaCalendarAdmin = Calendar.getInstance();
            fechaCalendarAdmin.setTime(new Date());
            
          for(Chcontroliqu liqEliminado:lstLiquidosEliminadosSelect){
              Chnotaenferm nota = new Chnotaenferm();
              idNota = new ChnotaenfermPK();
              idNota.setHnelnumero(cirugia.getHcplnumero());
              idNota.setHnectiposervi(TIPO_HOSPITALIZACION);
              nota.setId(idNota);
              nota.setHnenclinica(this.getClinica().getCclncodigo());
              nota.setHnelusuario(cirugia.getHcplusuario().getHuslnumero());
              nota.setHnecestado(ESTADO_VIGENTE);
              nota.setHnecoperador(userName());
              nota.setHnedfecregistr(new Date());
              nota.setHnecnotaenferm(liqEliminado.getHclcobsliqelim());
              nota.setHnedfechanotac(fechaCalendarAdmin.getTime());
              if (notaEnfeProce) {
                  nota.getId().setHnectiposervi(TIPO_PROCEDIMIENTO);
              }
              lstNotaEnfermeria.add(nota);
          }  
            
            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidosNota(lstLiquidosEliminadosSelect, 
                                                                                cirugia.getHcplnumero(), 
                                                                                lstLiquidosFormuladosSelect,lstNotaEnfermeria);
                lstHistorialLiquidosEliminados = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());
                nextAction = navegationRule;
                lstLiquidosEliminadosSelect = new ArrayList<Chcontroliqu>();
                init();
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                nextAction = "";
                e.printStackTrace();
            }
            return nextAction;
        }
        return nextAction;
    }


    public void generarReporte() {
        GenerarFoliosCirugiaBean bean = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        byte[] result = null;
        Chusuario usuario = null;
        try {
            usuario = this.serviceLocator.getClinicoService().getUsuario(cirugia.getHcplusuario().getHuslnumero());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (notaEnfeProce) {
            try {
                lstConsclin = 
                        this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (bean != null && cirugia != null && usuario != null) {
            if (lstConsclin!=null && !lstConsclin.isEmpty()){
            result = bean.generarControlLiquidos(usuario, cirugia, -1,lstConsclin.get(0));
            }else {
                result = bean.generarControlLiquidos(usuario, cirugia, -1,null);
            }
        }
        if (result != null) {
            PdfServletUtils.showPdfDocument(result,"ControlLiquidos.pdf", false);
            setGeneroReporte(true);
        } else {
            FacesUtils.addErrorMessage("No pudo generar Reporte Control Liquidos. ");
            setGeneroReporte(false);
        }
    }


    public void administrarLiquidoFormuladoAnestesia() {
        Chcontroliqu formulaAdd;
        formulaAdd = (Chcontroliqu)this.dtLiquidosFormuladosAnestesia.getRowData();
        lstLiquidosAdministrar.remove(formulaAdd);

        lstLiquidosSelect = new ArrayList<Chcontroliqu>();
        if (formulaAdd != null) {
            lstLiquidosSelect.add(formulaAdd);
            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidosAnestesiaEtapaIniciadoLiquido(lstLiquidosSelect, 
                                                                                                             cirugia.getHcplnumero());
                lstLiquidosParciales = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesiaIni(cirugia.getHcplnumero());
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + 
                                           ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public void muestraLiquidosViaOral() {

    }

    public void muestraLiquidosViaOralOtro() {
        if (liquidoViaOral.getHclctipoliquid() != null && 
            liquidoViaOral.getHclctipoliquid().equals("0")) {
            renderLiquidosViaOralOtro = true;
        } else {
            renderLiquidosViaOralOtro = false;
        }
    }

    /**
     * @return
     */
    public String volver() {
        setGeneroReporte(false);
        return "irListaNotasEnfermeria";
    }

    /**
     * @param totalLiqAdmin
     */
    public void setTotalLiqAdmin(Integer totalLiqAdmin) {
        this.totalLiqAdmin = totalLiqAdmin;
    }

    /**
     * @return
     */
    public Integer getTotalLiqAdmin() {
        return totalLiqAdmin;
    }

    /**
     * @param totalLiqElim
     */
    public void setTotalLiqElim(Integer totalLiqElim) {
        this.totalLiqElim = totalLiqElim;
    }

    /**
     * @return
     */
    public Integer getTotalLiqElim() {
        return totalLiqElim;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
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
     * @param lstLiquidosFormuladosExterna
     */
    public void setLstLiquidosFormuladosExterna(List<Chformulaliq> lstLiquidosFormuladosExterna) {
        this.lstLiquidosFormuladosExterna = lstLiquidosFormuladosExterna;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstLiquidosFormuladosExterna() {
        return lstLiquidosFormuladosExterna;
    }

    /**
     * @param dtLiquidosFormuladosExterna
     */
    public void setDtLiquidosFormuladosExterna(HtmlDataTable dtLiquidosFormuladosExterna) {
        this.dtLiquidosFormuladosExterna = dtLiquidosFormuladosExterna;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidosFormuladosExterna() {
        return dtLiquidosFormuladosExterna;
    }

    /**
     * @return
     */
    public String siguiente() {
        return BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS;
    }

    public void setMnuCuantifi(UIInput mnuCuantifi) {
        this.mnuCuantifi = mnuCuantifi;
    }

    public UIInput getMnuCuantifi() {
        return mnuCuantifi;
    }

    public void setRenderEmeCuanti(boolean renderEmeCuanti) {
        this.renderEmeCuanti = renderEmeCuanti;
    }

    public boolean isRenderEmeCuanti() {
        return renderEmeCuanti;
    }

    public void setItCantidadEmesis(UIInput itCantidadEmesis) {
        this.itCantidadEmesis = itCantidadEmesis;
    }

    public UIInput getItCantidadEmesis() {
        return itCantidadEmesis;
    }

    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setUsuarioSystem(String usuarioSystem) {
        this.usuarioSystem = usuarioSystem;
    }

    public String get_usuarioSystem() {
        return usuarioSystem;
    }

    public void setLstLiquidosAdministrar(List<Chcontroliqu> lstLiquidosAdministrar) {
        this.lstLiquidosAdministrar = lstLiquidosAdministrar;
    }

    public List<Chcontroliqu> getLstLiquidosAdministrar() {
        return lstLiquidosAdministrar;
    }

    public void setDtLiquidosFormuladosAnestesia(HtmlDataTable dtLiquidosFormuladosAnestesia) {
        this.dtLiquidosFormuladosAnestesia = dtLiquidosFormuladosAnestesia;
    }

    public HtmlDataTable getDtLiquidosFormuladosAnestesia() {
        return dtLiquidosFormuladosAnestesia;
    }

    public void setRadioLiquidosViaOral(String radioLiquidosViaOral) {
        this.radioLiquidosViaOral = radioLiquidosViaOral;
    }

    public String getRadioLiquidosViaOral() {
        return radioLiquidosViaOral;
    }

    public void listenLiquidosViaOral(ValueChangeEvent valueChangeEvent) {
        String value = (String)(((UIInput)valueChangeEvent.getComponent()).getValue());
        if (value.equals("S")) {
            renderLiquidosViaOral = true;
        } else if (value.equals("N")) {
            renderLiquidosViaOral = false;
        }
    }

    public void setRenderLiquidosViaOral(boolean renderLiquidosViaOral) {
        this.renderLiquidosViaOral = renderLiquidosViaOral;
    }

    public boolean isRenderLiquidosViaOral() {
        return renderLiquidosViaOral;
    }

    public void setLiquidoViaOral(Chcontroliqu liquidoViaOral) {
        this.liquidoViaOral = liquidoViaOral;
    }

    public Chcontroliqu getLiquidoViaOral() {
        return liquidoViaOral;
    }

    public void setRenderLiquidosViaOralOtro(boolean renderLiquidosViaOralOtro) {
        this.renderLiquidosViaOralOtro = renderLiquidosViaOralOtro;
    }

    public boolean isRenderLiquidosViaOralOtro() {
        return renderLiquidosViaOralOtro;
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

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendTablaServicio(String legendTablaServicio) {
        this.legendTablaServicio = legendTablaServicio;
    }

    public String getLegendTablaServicio() {
        return legendTablaServicio;
    }

    public void setLstNotaEnfermeria(List<Chnotaenferm> lstNotaEnfermeria) {
        this.lstNotaEnfermeria = lstNotaEnfermeria;
    }

    public List<Chnotaenferm> getLstNotaEnfermeria() {
        return lstNotaEnfermeria;
    }
}
