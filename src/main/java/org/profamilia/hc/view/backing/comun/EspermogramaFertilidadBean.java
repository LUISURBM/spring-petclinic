//=======================================================================
// ARCHIVO EspermogramaFertilidadBean.java
// FECHA CREACI�N: 16/05/2018
// AUTOR: Norbey Lis Salda�a
// Descripci�n: Datos correspondientes al registro de Espermograma de Fertilidad
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

import java.net.URL;

import java.text.DecimalFormat;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cnespermog;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncapaespe;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE EspermogramaFertilidadBean
//=======================================================================
public class EspermogramaFertilidadBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario;
    private Cnespermog espermograma;
    private Cncapaespe capacitacion;
    private Cnconsclin consulta;
    private String nextAction;
    private String menuBean;
    private String tipoServicio;
    private String navigationRule;
    private Cpservicio codigoServicio;
    private List lstSiNo;
    private List lstTipoEspermograma;
    private List lstViscosidad;
    private List lstColor;
    private boolean generoEspermograma;
    private boolean modoconsulta;
    private boolean guardado;
    private int index = -1;

    private boolean renderCapacitacion; 
    private boolean renderBasico;
    private UIInput mnuTipoEspe; 

    private BigDecimal volumen;
    private Integer cantidad;
    private Integer progresivo;
    private Integer pendulares;
    private Integer inmovil;
    private Integer vivos;
    private BigDecimal total;
    private Integer anomaliaCab;
    private Integer anomaliaPie;
    private Integer anomaliaFla;
    private Integer anormales;
    private Integer indice;
    private BigDecimal posVolumen;
    private Integer posCantidad;
    private Integer posProgresivos;
    private BigDecimal recuento;
    private BigDecimal capVolumen;
    private Integer capCantidad;
    private Integer capProgresivos;
    private Integer capPendulares;
    private Integer capInmoviles;
    private Integer capVivos;
    private Integer posPendulares;
    private Integer posInmoviles;
    private Integer posVivos;
    private String capObservaciones;
    private String oligoz;
    private String asteno;
    private String terato;
    private String normoz;

    // Datos para el reporte 
    private Cnespermog espermogramaImp;
    private Cncapaespe capacitacionImp;
    private Cpprofesio profesional;
    private UIInput inpOligoz; 
    private UIInput inpTerato; 
    private UIInput inpAsteno; 
    private UIInput inpNormoz; 


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public EspermogramaFertilidadBean() {
    }

    public void init() {
        inicalizarEspermogramaBean();
    }
    //ACTIONS

    public void inicalizarEspermogramaBean() {
        generoEspermograma = false; 
        guardado = false;

        if (usuario != null && usuario.getHuslnumero() != null) {
            try {
                if (consulta != null) {
                    espermograma = 
                            this.getServiceLocator().getClinicoService().getEspermogramaFertilidad(consulta.getCconnumero().longValue());
                }
                if (espermograma != null) {
                    capacitacion = 
                         this.getServiceLocator().getClinicoService().getCapacitacionFertilidad(espermograma.getCesnclinic(), espermograma.getCesnnumero());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (espermograma == null) {
                espermograma = new Cnespermog();
                espermograma.setCesnconcli(consulta.getCconnumero().longValue());
                espermograma.setCesnclinic(consulta.getCconclinic());
                espermograma.setCesdfecesp(new Date());
                espermograma.setCesctipide(usuario.getHusetipoiden());
                espermograma.setCesanumide(new BigDecimal(usuario.getHusanumeiden()));
                espermograma.setCescusureg(userName());
                String pacien = usuario.getHuscprimernomb();
                if (usuario.getHuscsegundnomb() != null) {
                    pacien = pacien + " " + usuario.getHuscsegundnomb();
                }
                pacien = pacien + " " + usuario.getHuscprimerapel();
                if (usuario.getHuscsegundapel() != null) {
                    pacien = pacien + " " + usuario.getHuscsegundapel();
                }
                if (pacien.length() > 40) {
                    espermograma.setCescpacien(pacien.substring(0,39));
                } else {
                    espermograma.setCescpacien(pacien);
                }
                Integer edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
                espermograma.setCesnedapac(edad);
            } else {
                if (espermograma.getCesntipesp() != null && espermograma.getCesntipesp() == 1) {
                    renderCapacitacion = false;
                    renderBasico = true;
                } 
                if (espermograma.getCesntipesp() != null && espermograma.getCesntipesp() == 2) {
                    renderBasico = false;
                    renderCapacitacion = true;
                } 
                if (espermograma.getCesavolume() != null) {
                    volumen = espermograma.getCesavolume();
                }
                if (espermograma.getCesncantid() != null) {
                    cantidad = espermograma.getCesncantid();
                }
                if (espermograma.getCesnprogre() != null) {
                    progresivo = espermograma.getCesnprogre();
                }
                if (espermograma.getCesnpendul() != null) {
                    pendulares = espermograma.getCesnpendul();
                }
                if (espermograma.getCesninmovi() != null) {
                    inmovil = espermograma.getCesninmovi();
                }
                if (espermograma.getCesnvivos() != null) {
                    vivos = espermograma.getCesnvivos();
                }
                if (espermograma.getCesnanorma() != null) {
                    anormales = espermograma.getCesnanorma();
                }
                if (espermograma.getCesnanocab() != null) {
                    anomaliaCab = espermograma.getCesnanocab();
                }
                if (espermograma.getCesnanopie() != null) {
                    anomaliaPie = espermograma.getCesnanopie();
                }
                if (espermograma.getCesnanofla() != null) {
                    anomaliaFla = espermograma.getCesnanofla();
                }
                if (espermograma.getCescoligoz() != null) {
                    oligoz = espermograma.getCescoligoz();
                }
                if (espermograma.getCescterato() != null) {
                    terato = espermograma.getCescterato();
                }
                if (espermograma.getCescasteno() != null) {
                    asteno = espermograma.getCescasteno();
                }
                if (espermograma.getCescnormoz() != null) {
                    normoz = espermograma.getCescnormoz();
                }

                guardado = true;
            }
            setCesatotal();
            setIndiceTera();
            
            if (capacitacion != null) {
                if (capacitacion.getCceavolume() != null) {
                    capVolumen = capacitacion.getCceavolume();
                }
                if (capacitacion.getCcenprogre() != null) {
                    capProgresivos = capacitacion.getCcenprogre();
                }
                if (capacitacion.getCcenpendul() != null) {
                    capPendulares = capacitacion.getCcenpendul();
                }
                if (capacitacion.getCceninmovi() != null) {
                    capInmoviles = capacitacion.getCceninmovi();
                }
                if (capacitacion.getCcenvitali() != null) {
                    capVivos = capacitacion.getCcenvitali();
                }
                if (capacitacion.getCcenpospen() != null) {
                    posPendulares = capacitacion.getCcenpospen();
                }
                if (capacitacion.getCcenposinm() != null) {
                    posInmoviles = capacitacion.getCcenposinm();
                }
                if (capacitacion.getCcenposvit() != null) {
                    posVivos = capacitacion.getCcenposvit();
                }
                if (capacitacion.getCcencantid() != null) {
                    capCantidad = capacitacion.getCcencantid();
                }
                if (capacitacion.getCceaposvol() != null) {
                    posVolumen = capacitacion.getCceaposvol();
                }
                if (capacitacion.getCcenposcan() != null) {
                    posCantidad = capacitacion.getCcenposcan();
                }
                if (capacitacion.getCcenpospgr() != null) {
                    posProgresivos = capacitacion.getCcenpospgr();
                }
                if (capacitacion.getCcexobserv() != null) {
                    capObservaciones = capacitacion.getCcexobserv();
                }
            }
            setRecuentoPos();
        }
    }

    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 

    public String guardar() {
        navigationRule = "";
        index = -1; 
    
        espermograma.setCesavolume(volumen);
        espermograma.setCesncantid(cantidad);
        espermograma.setCesatotal(total);
        espermograma.setCesnanorma(anormales);
        espermograma.setCesnanocab(anomaliaCab);
        espermograma.setCesnanopie(anomaliaPie);
        espermograma.setCesnanofla(anomaliaFla);
        espermograma.setCesdfecreg(new Date());
        espermograma.setCescoligoz(oligoz);
        espermograma.setCescterato(terato);
        espermograma.setCescasteno(asteno);
        espermograma.setCescnormoz(normoz);
        espermograma.setCesnprogre(progresivo);
        espermograma.setCesnpendul(pendulares);
        espermograma.setCesninmovi(inmovil);
        espermograma.setCesnvivos(vivos);
        espermograma.setCesnligelo(0);
        espermograma.setCesnmarelo(0);
        espermograma.setCesnanoacr(0);
        espermograma.setCesnmacroc(0);
        espermograma.setCesnmicroc(0);
        espermograma.setCesndobcab(0);
        espermograma.setCesnangula(0);
        espermograma.setCesnflaenr(0);
        espermograma.setCesndobfla(0);
        espermograma.setCesnanomul(0);
        espermograma.setCesnprorap(0);
        espermograma.setCesnprolen(0);
        
        if (espermograma.getCesntipesp() != null && espermograma.getCesntipesp() == 1) {
            capacitacion = null;
        } else {
            capacitacion = new Cncapaespe();
            capacitacion.getId().setCcenclinic(espermograma.getCesnclinic());
            capacitacion.getId().setCcennumero(espermograma.getCesnnumero());
            capacitacion.setCcectipide(espermograma.getCesctipide());
            capacitacion.setCceanumide(espermograma.getCesanumide());
            capacitacion.setCcecpacien(espermograma.getCescpacien());
            capacitacion.setCcedfeccap(espermograma.getCesdfecesp());
            capacitacion.setCcedfecreg(new Date());
            capacitacion.setCcenesperm(espermograma.getCesnnumero());
            capacitacion.setCcecusureg(espermograma.getCescusureg());
            capacitacion.setCcectipocp("S");
            capacitacion.setCcencantid(0);
            capacitacion.setCcenprorap(0);
            capacitacion.setCcenprolen(0);
            capacitacion.setCcenposrap(0);
            capacitacion.setCcenposlen(0);
            capacitacion.setCcennormal(0);
            capacitacion.setCcenligelo(0);
            capacitacion.setCcenmarelo(0);
            capacitacion.setCcenanoacr(0);
            capacitacion.setCcenanomul(0);
            capacitacion.setCcenanorma(0);
            capacitacion.setCcenanocab(0);
            capacitacion.setCcenanopie(0);
            capacitacion.setCcenanofla(0);
            capacitacion.setCceavolume(capVolumen);
            capacitacion.setCceninmovi(capInmoviles);
            capacitacion.setCcenpendul(capPendulares);
            capacitacion.setCcenprogre(capProgresivos);
            capacitacion.setCcenvitali(capVivos);
            capacitacion.setCcencantid(capCantidad);
            capacitacion.setCceaposvol(posVolumen);
            capacitacion.setCcenposcan(posCantidad);
            capacitacion.setCcenpospgr(posProgresivos);
            capacitacion.setCcenpospen(posPendulares);
            capacitacion.setCcenposinm(posInmoviles);
            capacitacion.setCcenposvit(posVivos);
            capacitacion.setCcexobserv(capObservaciones);
        }

        if (espermograma.getCesntipesp() != null && espermograma.getCesntipesp() == 2) {
            espermograma.setCescparoti(" ");
            espermograma.setCescorquit(" ");
            espermograma.setCesnhijos(0);
            espermograma.setCescfumar(" ");
            espermograma.setCescets(" ");
            espermograma.setCesncantid(0);
            espermograma.setCesnpendul(0);
            espermograma.setCesninmovi(0);
            espermograma.setCesnvivos(0);
            espermograma.setCesnmuerto(0);
            espermograma.setCesavolume(new BigDecimal(0));
            espermograma.setCesatotal(new BigDecimal(0));
            espermograma.setCesnprogre(0);
            espermograma.setCesnanorma(0);
            espermograma.setCesnanocab(0);
            espermograma.setCesnanopie(0);
            espermograma.setCesnanofla(0);
            espermograma.setCesnnormal(0);
            espermograma.setCescmedact(null);
            espermograma.setCesccirugi(null);
            espermograma.setCescotros(null);
            espermograma.setCescinfert(null);
            espermograma.setCescurolog(null);
            espermograma.setCescleucoc(null);
            espermograma.setCescpiocit(null);
            espermograma.setCeschemati(null);
            espermograma.setCescoligoz(null);
            espermograma.setCescasteno(null);
            espermograma.setCescterato(null);
            espermograma.setCescnormoz(null);
            espermograma.setCesxobserv(null);
        }

        try {
            this.serviceLocator.getClinicoService().saveEspermogramaFertilidad(espermograma, capacitacion);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
            guardado = true;
        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
        imprimirEspermograma();
        return BeanNavegacion.RUTA_ACTUAL;
    }

    public void imprimirEspermograma() {    
        try {
            obtenerDatosReporteEspermograma();
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EspermogramaFertilidad_T4.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_esp_normal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_NORMAL); 
            URL url_esp_ligelo = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_LIGELO); 
            URL url_esp_marelo = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_MARELO); 
            URL url_esp_anoacr = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_ANOACR); 
            URL url_esp_macro = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_MACRO); 
            URL url_esp_micro = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_MICRO); 
            URL url_esp_dobcab = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_DOBCAB); 
            URL url_esp_angul = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_ANGUL); 
            URL url_esp_flaenr = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_FLAENR); 
            URL url_esp_dobfla = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESP_DOBFLA); 

            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_ESP_NORMAL", url_esp_normal);
                parameters.put("IMAGE_ESP_LIGELO", url_esp_ligelo);
                parameters.put("IMAGE_ESP_MARELO", url_esp_marelo);
                parameters.put("IMAGE_ESP_ANOACR", url_esp_anoacr);
                parameters.put("IMAGE_ESP_MACRO", url_esp_macro);
                parameters.put("IMAGE_ESP_MICRO", url_esp_micro);
                parameters.put("IMAGE_ESP_DOBCAB", url_esp_dobcab);
                parameters.put("IMAGE_ESP_ANGUL", url_esp_angul);
                parameters.put("IMAGE_ESP_FLAENR", url_esp_flaenr);
                parameters.put("IMAGE_ESP_DOBFLA", url_esp_dobfla);
                parameters.put("TIPO_ESPERMOGRAMA", espermogramaImp.getCesntipesp());
                byte[] bytes;
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, "Espermograma" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoEspermograma = true;
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + e.getMessage());
        }
        espermogramaImp = null;
        capacitacionImp = null;
        profesional = null;
    }
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    public boolean esValido() {
        Cnespermog espermogramaAux = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            try {
                espermogramaAux = 
                        this.getServiceLocator().getClinicoService().getEspermogramaFertilidad(consulta.getCconnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (espermogramaAux != null) {
            return true;
        }
        return false;
    }
        

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }


    public void setCodigoServicio(Cpservicio codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public Cpservicio getCodigoServicio() {
        return codigoServicio;
    }

    public void setSiNo(List lstSiNo) {
        this.lstSiNo = lstSiNo;
    }

    public List getLstSiNo() {
        if(lstSiNo == null || lstSiNo.isEmpty()){
            lstSiNo = new ArrayList();
            lstSiNo.add(new SelectItem("S","Si"));
            lstSiNo.add(new SelectItem("N","No"));
        }
        return lstSiNo;
    }

    public void setLstTipoEspermograma(List lstTipoEspermograma) {
        this.lstTipoEspermograma = lstTipoEspermograma;
    }

    public List getLstTipoEspermograma() {
        if(lstTipoEspermograma == null || lstTipoEspermograma.isEmpty()){
            lstTipoEspermograma = new ArrayList();
            lstTipoEspermograma.add(new SelectItem("","Seleccione una opci�n"));
            lstTipoEspermograma.add(new SelectItem(1,"B�sico"));
            lstTipoEspermograma.add(new SelectItem(2,"Capacitaci�n"));
            lstTipoEspermograma.add(new SelectItem(4,"Capacitaci�n Swin Up"));
        }
        return lstTipoEspermograma;
    }

    public void setLstViscosidad(List lstViscosidad) {
        this.lstViscosidad = lstViscosidad;
    }

    public List getLstViscosidad() {
        if(lstViscosidad == null || lstViscosidad.isEmpty()){
            lstViscosidad = new ArrayList();
            lstViscosidad.add(new SelectItem("AUMENTADA","Aumentada"));
            lstViscosidad.add(new SelectItem("NORMAL","Normal"));
        }
        return lstViscosidad;
    }

    public void setLstColor(List lstColor) {
        this.lstColor = lstColor;
    }

    public List getLstColor() {
        if(lstColor == null || lstColor.isEmpty()){
            lstColor = new ArrayList();
            lstColor.add(new SelectItem("GRIS","Gris"));
            lstColor.add(new SelectItem("AMARILLO","Amarillo"));
            lstColor.add(new SelectItem("ROJO","Rojo"));
            lstColor.add(new SelectItem("TRANSPARENTE","Transparente"));
            lstColor.add(new SelectItem("CAF�","Caf�"));
        }
        return lstColor;
    }

    public void setEspermograma(Cnespermog espermograma) {
        this.espermograma = espermograma;
    }

    public Cnespermog getEspermograma() {
        return espermograma;
    }

    public void setCapacitacion(Cncapaespe capacitacion) {
        this.capacitacion = capacitacion;
    }
 
 
    public Cncapaespe getCapacitacion() {
        return capacitacion;
    }
    
    /**
     * @param generoEspermograma
     */
    public void setGeneroEspermograma(boolean generoEspermograma) {
        this.generoEspermograma = generoEspermograma;
    }

    /**
     * @return
     */
    public boolean isGeneroEspermograma() {
        return generoEspermograma;
    }

    public void obtenerDatosReporteEspermograma() {
        try {
            if (consulta != null) {
                espermogramaImp = 
                    this.getServiceLocator().getClinicoService().getEspermogramaFertilidad(consulta.getCconnumero().longValue());
            }
            if (espermogramaImp != null) {
                capacitacionImp = 
                    this.getServiceLocator().getClinicoService().getCapacitacionFertilidad(espermogramaImp.getCesnclinic(), 
                                                                                           espermogramaImp.getCesnnumero());
                profesional = 
                        serviceLocator.getClinicoService().getProfesionalPorUsuario(espermogramaImp.getCescusureg(), 
                                                                                    espermogramaImp.getCesnclinic());
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
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
     * @return
     * @throws JRException
     */
    public boolean next() throws JRException {
        index++;
        return (index < 1);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();
        

        if (espermogramaImp != null){
            if (fieldName.equals("NUMERO")) 
                value = espermogramaImp.getCesnnumero();
            if (fieldName.equals("TIPO_ID")) 
                value = espermogramaImp.getCesctipide();
            if (fieldName.equals("NUMERO_ID")) 
                value = espermogramaImp.getCesanumide();
            if (fieldName.equals("NOMBRE")) 
                value = espermogramaImp.getCescpacien();
            if (fieldName.equals("EDAD")) 
                value = espermogramaImp.getCesnedapac();
            if (fieldName.equals("REMITE")) 
                value = espermogramaImp.getCescremite();
            if (fieldName.equals("FECHA")) 
                value = espermogramaImp.getCesdfecesp();
            if (fieldName.equals("ABSTINENCIA")) 
                value = espermogramaImp.getCesndiaabs();
            if (fieldName.equals("PAROTIDITIS")) 
                value = espermogramaImp.getCescparoti();
            if (fieldName.equals("ORQUITIS")) 
                value = espermogramaImp.getCescorquit();
            if (fieldName.equals("HIJOS")) 
                value = espermogramaImp.getCesnhijos();
            if (fieldName.equals("FUMA")) 
                value = espermogramaImp.getCescfumar();
            if (fieldName.equals("ETS")) 
                value = espermogramaImp.getCescets();
            if (fieldName.equals("MEDICAMENTOS")) 
                value = espermogramaImp.getCescmedact();
            if (fieldName.equals("CIRUGIAS")) 
                value = espermogramaImp.getCesccirugi();
            if (fieldName.equals("UROLOGIA")) 
                value = espermogramaImp.getCescurolog();
            if (fieldName.equals("INFERTILIDAD")) 
                value = espermogramaImp.getCescinfert();
            if (fieldName.equals("OTROS")) 
                value = espermogramaImp.getCescotros();
            if (fieldName.equals("VOLUMEN")) 
                value = espermogramaImp.getCesavolume();
            if (fieldName.equals("VISCOSIDAD")) 
                value = espermogramaImp.getCescviscos();
            if (fieldName.equals("COLOR")) 
                value = espermogramaImp.getCesccolor();
            if (fieldName.equals("CANTIDAD")) 
                value = espermogramaImp.getCesncantid();
            if (fieldName.equals("ANOMALIAS_CAB")) 
                value = espermogramaImp.getCesnanocab();
            if (fieldName.equals("ANOMALIAS_PIE")) 
                value = espermogramaImp.getCesnanopie();
            if (fieldName.equals("ANOMALIAS_FLA")) 
                value = espermogramaImp.getCesnanofla();
            if (fieldName.equals("TOTAL")) 
                value = espermogramaImp.getCesatotal();
            if (fieldName.equals("INMOVILES")) 
                value = espermogramaImp.getCesninmovi();
            if (fieldName.equals("VIVOS")) 
                value = espermogramaImp.getCesnvivos();
            if (fieldName.equals("MUERTOS")) 
                value = espermogramaImp.getCesnmuerto();
            if (fieldName.equals("LEUCOCITOS")) 
                value = espermogramaImp.getCescleucoc();
            if (fieldName.equals("PIOCITOS")) 
                value = espermogramaImp.getCescpiocit();
            if (fieldName.equals("HEMATIES")) 
                value = espermogramaImp.getCeschemati();
            if (fieldName.equals("PROGRESIVOS")) 
                value = espermogramaImp.getCesnprogre();
            if (fieldName.equals("PENDULARES")) 
                value = espermogramaImp.getCesnpendul();
            if (fieldName.equals("NORMALES")) 
                value = espermogramaImp.getCesnnormal();
            if (fieldName.equals("ANORMALES")) 
                value = espermogramaImp.getCesnanorma();
            if (fieldName.equals("OBSERVACIONES_ESP")) 
                value = espermogramaImp.getCesxobserv();
            if (fieldName.equals("INDICE")) 
                if (espermogramaImp.getCesnanorma() != null && espermograma.getCesnanocab() != null && 
                    espermogramaImp.getCesnanopie() != null && espermograma.getCesnanofla() != null) {
                    value  = (espermograma.getCesnanocab() + espermogramaImp.getCesnanopie() + 
                               espermograma.getCesnanofla()) * espermogramaImp.getCesnanorma();
                } else {
                    value = 0;
                }
            if (capacitacionImp != null) {
                if (fieldName.equals("OBSERVACIONES_CAP")) 
                    value = capacitacionImp.getCcexobserv();
                if (fieldName.equals("INMOVILES_CAP")) 
                    value = capacitacionImp.getCceninmovi();
                if (fieldName.equals("INMOVILES_POS")) 
                    value = capacitacionImp.getCcenposinm();
                if (fieldName.equals("VOLUMEN_CAP")) 
                    value = capacitacionImp.getCceavolume();
                if (fieldName.equals("VOLUMEN_POS")) 
                    value = capacitacionImp.getCceaposvol();
                if (fieldName.equals("CANTIDAD_CAP")) 
                    value = capacitacionImp.getCcencantid();
                if (fieldName.equals("CANTIDAD_POS")) 
                    value = capacitacionImp.getCcenposcan();
                if (fieldName.equals("PROGRESIVOS_CAP")) 
                    value = capacitacionImp.getCcenprogre();
                if (fieldName.equals("PROGRESIVOS_POS")) 
                    value = capacitacionImp.getCcenpospgr();
                if (fieldName.equals("PENDULARES_CAP")) 
                    value = capacitacionImp.getCcenpendul();
                if (fieldName.equals("PENDULARES_POS")) 
                    value = capacitacionImp.getCcenpospen();
                if (fieldName.equals("VIVOS_CAP")) 
                    value = capacitacionImp.getCcenvitali();
                if (fieldName.equals("VIVOS_POS")) 
                    value = capacitacionImp.getCcenposvit();
                if (fieldName.equals("RECUENTO")) 
                    if (capacitacionImp.getCcenposcan() != null && capacitacionImp.getCceaposvol() != null && 
                        capacitacionImp.getCcenpospgr() != null) {
                        value = capacitacionImp.getCceaposvol().multiply(new BigDecimal(capacitacionImp.getCcenposcan())).
                              multiply(new BigDecimal(capacitacionImp.getCcenpospgr())).divide(new BigDecimal(100),BigDecimal.ROUND_HALF_UP);
                    } else {
                        value = new BigDecimal(0);
                    }
            }
            if (fieldName.equals("NOMBRE_PROFESIONAL")) 
                value = profesional.getCpfcnombre();
            if (fieldName.equals("REGISTRO_MEDICO")) 
                value = profesional.getCpfcregmedic();
            return value;
        }
        return null;
    }

    /**
     * @return
     */
    public String siguiente() {
        return nextAction;
    }


    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }
    
    public String cerrarEspermograma() {
       if (consulta != null && usuario != null) {
           try {
                  this.serviceLocator.getClinicoService().closeEspermogramaFertilidad(usuario, 
                                                                     consulta, 
                                                                     userName());
           } catch (ModelException e) {
                 e.printStackTrace();
                 return null;
           }

           FacesUtils.resetManagedBean("listaMisUsuariosBean");
           FacesUtils.resetManagedBean("listaUsuariosBean");
           return BeanNavegacion.RUTA_LISTA;
       }
       return BeanNavegacion.RUTA_ACTUAL;
    }


    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    public boolean isGuardado() {
        return guardado;
    }
    
    /**
     * @param renderCapacitacion
     */
    public void setRenderCapacitacion(boolean renderCapacitacion) {
        this.renderCapacitacion = renderCapacitacion;
    }

    /**
     * @return
     */
    public boolean isRenderCapacitacion() {
        return renderCapacitacion;
    }

    /**
     * @param renderBasico
     */
    public void setRenderBasico(boolean renderBasico) {
        this.renderBasico = renderBasico;
    }

    /**
     * @return
     */
    public boolean isRenderBasico() {
        return renderBasico;
    }

    public void changeTipoEspermograma(){
        renderCapacitacion = true;
        renderBasico = true;
        if (espermograma != null && espermograma.getCesntipesp() != null &&
            espermograma.getCesntipesp() == 1) {
            renderCapacitacion = false; 
        }
        if (espermograma != null && espermograma.getCesntipesp() != null &&
            espermograma.getCesntipesp() == 2) {
            renderBasico = false; 
        }

    }

    /**
     * @param valueChangeEvent
     */
    public void setCesntipesp(ValueChangeEvent valueChangeEvent) {
        espermograma.setCesntipesp((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param mnuTipoEspe
     */
    public void setMnuTipoEspe(UIInput mnuTipoEspe) {
        this.mnuTipoEspe = mnuTipoEspe;
    }

    /**
     * @return
     */
    public UIInput getMnuTipoEspe() {
        return mnuTipoEspe;
    }

    public void setCesatotal() {
       if (cantidad != null && volumen != null) {
           total = volumen.multiply(new BigDecimal(cantidad));
       } else {
           total = new BigDecimal(0);
       }
       muestraFresco();
    }

    public void muestraFresco() {
       if (cantidad != null) 
          capCantidad = cantidad;
       if (volumen != null)
          capVolumen = volumen;
       if (progresivo != null) 
          capProgresivos = progresivo; 
       if (pendulares != null)
          capPendulares = pendulares;
       if (inmovil != null)
          capInmoviles = inmovil;
       if (vivos != null) 
          capVivos = vivos;
    }


    public void setIndiceTera() {
       if (anormales != null && anomaliaCab != null && anomaliaPie != null && anomaliaFla != null) {
           indice  = (anomaliaCab + anomaliaPie + anomaliaFla) * anormales;
       } else {
           indice = 0;
       }
    }

    public void setRecuentoPos() {
       if (posCantidad != null && posVolumen != null && posProgresivos != null) {
           recuento = posVolumen.multiply(new BigDecimal(posCantidad)).multiply(new BigDecimal(posProgresivos)).divide(new BigDecimal(100),BigDecimal.ROUND_HALF_UP);
       } else {
           recuento = new BigDecimal(0);
       }
    }

    /**
     * @param volumen
     */
    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
    }

    /**
     * @param valueChangeEvent
     */
    public void setVolumen(ValueChangeEvent valueChangeEvent) {
        setVolumen((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public BigDecimal getVolumen() {
        return volumen;
    }

    /**
     * @param cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCantidad(ValueChangeEvent valueChangeEvent) {
        setCantidad((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param indice
     */
    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    /**
     * @return
     */
    public Integer getIndice() {
        return indice;
    }

    /**
     * @param anormales
     */
    public void setAnormales(Integer anormales) {
        this.anormales = anormales;
    }

    /**
     * @param valueChangeEvent
     */
    public void setAnormales(ValueChangeEvent valueChangeEvent) {
        setAnormales((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getAnormales() {
        return anormales;
    }

    /**
     * @param anomaliaCab
     */
    public void setAnomaliaCab(Integer anomaliaCab) {
        this.anomaliaCab = anomaliaCab;
    }

    /**
     * @param valueChangeEvent
     */
    public void setAnomaliaCab(ValueChangeEvent valueChangeEvent) {
        setAnomaliaCab((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getAnomaliaCab() {
        return anomaliaCab;
    }

    /**
     * @param anomaliaPie
     */
    public void setAnomaliaPie(Integer anomaliaPie) {
        this.anomaliaPie = anomaliaPie;
    }

    /**
     * @param valueChangeEvent
     */
    public void setAnomaliaPie(ValueChangeEvent valueChangeEvent) {
        setAnomaliaPie((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getAnomaliaPie() {
        return anomaliaPie;
    }

    /**
     * @param anomaliaFla
     */
    public void setAnomaliaFla(Integer anomaliaFla) {
        this.anomaliaFla = anomaliaFla;
    }

    /**
     * @param valueChangeEvent
     */
    public void setAnomaliaFla(ValueChangeEvent valueChangeEvent) {
        setAnomaliaFla((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getAnomaliaFla() {
        return anomaliaFla;
    }

    /**
     * @param capVolumen
     */
    public void setCapVolumen(BigDecimal capVolumen) {
        this.capVolumen = capVolumen;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapVolumen(ValueChangeEvent valueChangeEvent) {
        setCapVolumen((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public BigDecimal getCapVolumen() {
        return capVolumen;
    }

    /**
     * @param capCantidad
     */
    public void setCapCantidad(Integer capCantidad) {
        this.capCantidad = capCantidad;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapCantidad(ValueChangeEvent valueChangeEvent) {
        setCapCantidad((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getCapCantidad() {
        return capCantidad;
    }

    /**
     * @return
     */
    public Integer getCapProgresivos() {
        return capProgresivos;
    }

    /**
     * @param capProgresivos
     */
    public void setCapProgresivos(Integer capProgresivos) {
        this.capProgresivos = capProgresivos;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapProgresivos(ValueChangeEvent valueChangeEvent) {
        setCapProgresivos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param capPendulares
     */
    public void setCapPendulares(Integer capPendulares) {
        this.capPendulares = capPendulares;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapPendulares(ValueChangeEvent valueChangeEvent) {
        setCapPendulares((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getCapPendulares() {
        return capPendulares;
    }

    /**
     * @param capInmoviles
     */
    public void setCapInmoviles(Integer capInmoviles) {
        this.capInmoviles = capInmoviles;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapInmoviles(ValueChangeEvent valueChangeEvent) {
        setCapInmoviles((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getCapInmoviles() {
        return capInmoviles;
    }

    /**
     * @param capVivos
     */
    public void setCapVivos(Integer capVivos) {
        this.capVivos = capVivos;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapVivos(ValueChangeEvent valueChangeEvent) {
        setCapVivos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getCapVivos() {
        return capVivos;
    }

    /**
     * @param posPendulares
     */
    public void setPosPendulares(Integer posPendulares) {
        this.posPendulares = posPendulares;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPosPendulares(ValueChangeEvent valueChangeEvent) {
        setPosPendulares((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getPosPendulares() {
        return posPendulares;
    }

    /**
     * @param posInmoviles
     */
    public void setPosInmoviles(Integer posInmoviles) {
        this.posInmoviles = posInmoviles;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPosInmoviles(ValueChangeEvent valueChangeEvent) {
        setPosInmoviles((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getPosInmoviles() {
        return posInmoviles;
    }

    /**
     * @param posVivos
     */
    public void setPosVivos(Integer posVivos) {
        this.posVivos = posVivos;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPosVivos(ValueChangeEvent valueChangeEvent) {
        setPosVivos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getPosVivos() {
        return posVivos;
    }

    /**
     * @param capObservaciones
     */
    public void setCapObservaciones(String capObservaciones) {
        this.capObservaciones = capObservaciones;
    }

    /**
     * @param valueChangeEvent
     */
    public void setCapObservaciones(ValueChangeEvent valueChangeEvent) {
        setCapObservaciones((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public String getCapObservaciones() {
        return capObservaciones;
    }



    /**
     * @param posVolumen
     */
    public void setPosVolumen(BigDecimal posVolumen) {
        this.posVolumen = posVolumen;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPosVolumen(ValueChangeEvent valueChangeEvent) {
        setPosVolumen((BigDecimal)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public BigDecimal getPosVolumen() {
        return posVolumen;
    }

    /**
     * @param posVolumen
     */
    public void setPosCantidad(Integer posCantidad) {
        this.posCantidad = posCantidad;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPosCantidad(ValueChangeEvent valueChangeEvent) {
        setPosCantidad((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getPosCantidad() {
        return posCantidad;
    }

    /**
     * @param posProgresivos
     */
    public void setPosProgresivos(Integer posProgresivos) {
        this.posProgresivos = posProgresivos;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPosProgresivos(ValueChangeEvent valueChangeEvent) {
        setPosProgresivos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getPosProgresivos() {
        return posProgresivos;
    }

    /**
     * @param recuento
     */
    public void setRecuento(BigDecimal recuento) {
        this.recuento = recuento;
    }

    /**
     * @return
     */
    public BigDecimal getRecuento() {
        return recuento;
    }
    
    /**
     * @param oligoz
     */
    public void setOligoz(String oligoz) {
        this.oligoz = oligoz;
    }

    /**
     * @param valueChangeEvent
     */
    public void setOligoz(ValueChangeEvent valueChangeEvent) {
        setOligoz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public String getOligoz() {
        return oligoz;
    }

    /**
     * @param asteno
     */
    public void setAsteno(String asteno) {
        this.asteno = asteno;
    }

    /**
     * @param valueChangeEvent
     */
    public void setAsteno(ValueChangeEvent valueChangeEvent) {
        setAsteno((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public String getAsteno() {
        return oligoz;
    }

    /**
     * @param terato
     */
    public void setTerato(String terato) {
        this.terato = terato;
    }

    /**
     * @param valueChangeEvent
     */
    public void setTerato(ValueChangeEvent valueChangeEvent) {
        setTerato((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public String getTerato() {
        return terato;
    }

    /**
     * @param normoz
     */
    public void setNormoz(String normoz) {
        this.normoz = normoz;
    }

    /**
     * @param valueChangeEvent
     */
    public void setNormoz(ValueChangeEvent valueChangeEvent) {
        setNormoz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public String getNormoz() {
        return normoz;
    }

    public void changeDiagnosticoNormoz(){
        if (normoz != null && normoz.equals("S")) {
            oligoz = "N";
            asteno = "N";
            terato = "N";
            inpOligoz.setValue("N");
            inpAsteno.setValue("N");
            inpTerato.setValue("N");
        } 
    }

    public void changeDiagnostico(){
        if ((oligoz != null && oligoz.equals("S")) || (asteno != null && asteno.equals("S"))
            || (terato != null && terato.equals("S"))) {
            normoz = "N";
            inpNormoz.setValue("N");
        }
    }

    /**
     * @param inpOligoz
     */
    public void setInpOligoz(UIInput inpOligoz) {
        this.inpOligoz = inpOligoz;
    }

    /**
     * @return
     */
    public UIInput getInpOligoz() {
        return inpOligoz;
    }

    /**
     * @param inpAsteno
     */
    public void setInpAsteno(UIInput inpAsteno) {
        this.inpAsteno = inpAsteno;
    }

    /**
     * @return
     */
    public UIInput getInpAsteno() {
        return inpAsteno;
    }

    /**
     * @param inpTerato
     */
    public void setInpTerato(UIInput inpTerato) {
        this.inpTerato = inpTerato;
    }

    /**
     * @return
     */
    public UIInput getInpTerato() {
        return inpTerato;
    }

    /**
     * @param inpNormoz
     */
    public void setInpNormoz(UIInput inpNormoz) {
        this.inpNormoz = inpNormoz;
    }

    /**
     * @return
     */
    public UIInput getInpNormoz() {
        return inpNormoz;
    }





    /**
     * @param progresivo
     */
    public void setProgresivo(Integer progresivo) {
        this.progresivo = progresivo;
    }

    /**
     * @param valueChangeEvent
     */
    public void setProgresivo(ValueChangeEvent valueChangeEvent) {
        setProgresivo((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getProgresivo() {
        return progresivo;
    }

    /**
     * @param pendulares
     */
    public void setPendulares(Integer pendulares) {
        this.pendulares = pendulares;
    }

    /**
     * @param valueChangeEvent
     */
    public void setPendulares(ValueChangeEvent valueChangeEvent) {
        setPendulares((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getPendulares() {
        return pendulares;
    }

    /**
     * @param inmovil
     */
    public void setInmovil(Integer inmovil) {
        this.inmovil = inmovil;
    }

    /**
     * @param valueChangeEvent
     */
    public void setInmovil(ValueChangeEvent valueChangeEvent) {
        setInmovil((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getInmovil() {
        return inmovil;
    }

    /**
     * @param vivos
     */
    public void setVivos(Integer vivos) {
        this.vivos = vivos;
    }

    /**
     * @param valueChangeEvent
     */
    public void setVivos(ValueChangeEvent valueChangeEvent) {
        setVivos((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Integer getVivos() {
        return vivos;
    }

}
