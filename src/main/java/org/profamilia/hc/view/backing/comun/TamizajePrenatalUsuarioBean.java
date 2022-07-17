//=======================================================================
// ARCHIVO TamizajePrenatalUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano Rinc�n jariano@profamilia.org.co
// Descripci�n: Datos correspondientes al Tamizaje Prenatal
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chtamizalapr;
import org.profamilia.hc.model.dto.ChtamizalaprPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE TamizajePrenatalUsuarioBean
//=======================================================================

public class TamizajePrenatalUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chtamizalapr tamizaje;

    private List lstOpciones;

    private boolean existeParcial;

    private boolean mostrarEcografia;

    private List lstResultado;

    private String tieneEcografia;

    private boolean mostrarToxoplasmaIGG;

    private boolean mostrarToxoplasmaIGM;

    private boolean mostrarTest;

    private boolean mostrarHemoglobina;

    private boolean mostrarGlucosa;

    private boolean mostrarSerologia;

    private Date fechaActual;

    private Integer tipoHistoria;


    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;
    
    private UIInput mnuToxoplasmaIGG;
    
    private UIInput mnuToxoplasmaIGM;
    
    private UIInput mnuSullivan;
    
    private UIInput mnuHemoglobina;
    
    private UIInput mnuGlucosa;
    
    private UIInput mnuSerologia;
    
    private UIInput mnuParcialOrina;
    
    private UIInput mnuEcografia; 
    
    private List<Chtamizalapr> lstHistorialTamizaje;
    
    /** Almacena el codigo de la consulta principal*/
    private Long codigoHistoriaPrincipal;
    
    private UIInput parcialOrinaDesc;
    
    private boolean mostrarUrocultivo;
    
    private UIInput mnuUrocultivo;
    
    private boolean mostrarAntibiograma;
    
    private UIInput mnuAntibiograma;
    
    private boolean mostrarHemograma;
    
    private UIInput mnuHemograma;
    
    private boolean mostrarHemoclasificacion;
    
    private UIInput mnuHemoclasificacion;
    
    private boolean mostrarPruebaRapiVIH;
    
    private UIInput mnuPruebaRapiVIH;
    
    private boolean mostrarAntigenoHepatitis ;
    
    private UIInput mnuAntigenoHepatitis;
    
    private boolean mostrarTamizajeCancerCuello ;
    
    private UIInput mnuTamizajeCancerCuello;
    
    private boolean mostrarPruebasIgg;
    
    private UIInput mnuPruebasIgg;
    
    private boolean mostrarPruebasIga;
    
    private UIInput mnuPruebasIga;
    
    private boolean mostrarTamizacionEstreptococo;
    
    private UIInput mnuTamizacionEstreptococo;
    
    private boolean mostrarPruebasTolerancia;
    
    private UIInput mnuPruebasTolerancia;
    
    private boolean mostrarTamizajeGotaGruesa;
    
    private UIInput mnuTamizajeGotaGruesa;
    
    private boolean mostrarElisa;
    
    private UIInput mnuElisa;
    
    private List lstOpcionesPruebaOrina;
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public TamizajePrenatalUsuarioBean() {
    }

    public void init() {

        fechaActual = new Date();
        inicializarTamizaje();
    }


    public void inicializarTamizaje() {
        if (consulta != null) {
        
            if (codigoHistoriaPrincipal != null) {
                try {
                    lstHistorialTamizaje = 
                            this.serviceLocator.getClinicoService().getTamizajesLaboratorioPrenatal(codigoHistoriaPrincipal);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        
            try {
                tamizaje = 
                        this.serviceLocator.getClinicoService().getTamizajeLaboratorioPrenatal(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }


        if (tamizaje == null) {
            tamizaje = new Chtamizalapr();
            
            tamizaje.setHtletoxoplaigg("N");
            tamizaje.setHtletoxoplaigm("N");
            tamizaje.setHtletestsulliv("N");
            tamizaje.setHtlehemoglobin("N"); 
            tamizaje.setHtleglucosa("N");
            tamizaje.setHtleserologia("N");
            tamizaje.setHtlemicronutri("N");
            tamizaje.setHtleparciorina("N");
            
            tamizaje.setHtleurocultivo("N");
            tamizaje.setHtleantibiogra("N");
            tamizaje.setHtlehemograma ("N");
            tamizaje.setHtlehemoclasif("N");
            tamizaje.setHtleprurapvih ("N");
            tamizaje.setHtleantisupehepa("N");
            tamizaje.setHtletamcancue("N");
            tamizaje.setHtlepruigg ("N");
            tamizaje.setHtlepruigatox("N");
            tamizaje.setHtletamizestre("N");
            tamizaje.setHtleprutoloraglu("N");
            tamizaje.setHtletamgotgru("N");
            tamizaje.setHtleelisa("N");
            

        } else {
            if (tamizaje.getHtlcecografia() != null) {
                tieneEcografia = "S";
                mostrarEcografia = true;
            } else {
                tieneEcografia = "N";
                mostrarEcografia = false;
            }

            if (tamizaje.getHtleparciorina() != null && 
                tamizaje.getHtleparciorina().equals("A")) {
                existeParcial = true;
            } else {
                existeParcial = false;
            }

            if (tamizaje.getHtletoxoplaigg() != null && 
                tamizaje.getHtletoxoplaigg().equals("S")) {
                mostrarToxoplasmaIGG = true;
            } else {
                mostrarToxoplasmaIGG = false;
            }

            if (tamizaje.getHtletoxoplaigm() != null && 
                tamizaje.getHtletoxoplaigm().equals("S")) {
                mostrarToxoplasmaIGM = true;
            } else {
                mostrarToxoplasmaIGM = false;
            }

            if (tamizaje.getHtletestsulliv() != null && 
                tamizaje.getHtletestsulliv().equals("S")) {
                mostrarTest = true;
            } else {
                mostrarTest = false;
            }
            if (tamizaje.getHtlehemoglobin() != null && 
                tamizaje.getHtlehemoglobin().equals("S")) {
                mostrarHemoglobina = true;
            } else {
                mostrarHemoglobina = false;
            }
            if (tamizaje.getHtleglucosa() != null && 
                tamizaje.getHtleglucosa().equals("S")) {
                mostrarGlucosa = true;
            } else {
                mostrarGlucosa = false;
            }
            if (tamizaje.getHtleserologia() != null && 
                tamizaje.getHtleserologia().equals("S")) {
                mostrarSerologia = true;
            } else {
                mostrarSerologia = false;
            }
            
            //nuevos campos
            if (tamizaje.getHtleurocultivo() != null && 
                tamizaje.getHtleurocultivo().equals("S")) {
                mostrarUrocultivo = true;
            } else {
                mostrarUrocultivo = false;
            }
            
            if (tamizaje.getHtleantibiogra() != null && 
                tamizaje.getHtleantibiogra().equals("S")) {
                mostrarAntibiograma = true;
            } else {
                mostrarAntibiograma = false;
            }
            
            if (tamizaje.getHtlehemograma() != null && 
                tamizaje.getHtlehemograma().equals("S")) {
                mostrarHemograma = true;
            } else {
                mostrarHemograma = false;
            }
            
            if (tamizaje.getHtlehemoclasif() != null && 
                tamizaje.getHtlehemoclasif().equals("S")) {
                mostrarHemoclasificacion = true;
            } else {
                mostrarHemoclasificacion = false;
            }
            
            if (tamizaje.getHtleprurapvih() != null && 
                tamizaje.getHtleprurapvih().equals("S")) {
                mostrarPruebaRapiVIH = true;
            } else {
                mostrarPruebaRapiVIH = false;
            }
            
            
            if (tamizaje.getHtleantisupehepa() != null && 
                tamizaje.getHtleantisupehepa().equals("S")) {
                mostrarAntigenoHepatitis = true;
            } else {
                mostrarAntigenoHepatitis = false;
            }
            
            if (tamizaje.getHtletamcancue() != null && 
                tamizaje.getHtletamcancue().equals("S")) {
                mostrarTamizajeCancerCuello = true;
            } else {
                mostrarTamizajeCancerCuello = false;
            }
            
            
            if (tamizaje.getHtlepruigg() != null && 
                tamizaje.getHtlepruigg().equals("S")) {
                mostrarPruebasIgg = true;
            } else {
                mostrarPruebasIgg = false;
            }
            
            if (tamizaje.getHtlepruigatox() != null && 
                tamizaje.getHtlepruigatox().equals("S")) {
                mostrarPruebasIga = true;
            } else {
                mostrarPruebasIga = false;
            }
            
            if (tamizaje.getHtletamizestre() != null && 
                tamizaje.getHtletamizestre().equals("S")) {
                mostrarTamizacionEstreptococo = true;
            } else {
                mostrarTamizacionEstreptococo = false;
            }
            
            if (tamizaje.getHtleprutoloraglu() != null && 
                tamizaje.getHtleprutoloraglu().equals("S")) {
                mostrarPruebasTolerancia = true;
            } else {
                mostrarPruebasTolerancia = false;
            }
            
            if (tamizaje.getHtletamgotgru() != null && 
                tamizaje.getHtletamgotgru().equals("S")) {
                mostrarTamizajeGotaGruesa = true;
            } else {
                mostrarTamizajeGotaGruesa = false;
            }
            
            if (tamizaje.getHtleelisa() != null && 
                tamizaje.getHtleelisa().equals("S")) {
                mostrarElisa = true;
            } else {
                mostrarElisa = false;
            }

        }
    }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


    /**
     * @param tamizaje
     */
    public void setTamizaje(Chtamizalapr tamizaje) {
        this.tamizaje = tamizaje;
    }

    /**
     * @return
     */
    public Chtamizalapr getTamizaje() {
        return tamizaje;
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
     * @param existeParcial
     */
    public void setExisteParcial(boolean existeParcial) {
        this.existeParcial = existeParcial;
    }

    /**
     * @return
     */
    public boolean isExisteParcial() {
        return existeParcial;
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
            lstResultado.add(new SelectItem("+", "+"));
            lstResultado.add(new SelectItem("-", "-"));

        }

        return lstResultado;
    }


    /**
     * @param tieneEcografia
     */
    public void setTieneEcografia(String tieneEcografia) {
        this.tieneEcografia = tieneEcografia;
    }

    /**
     * @return
     */
    public String getTieneEcografia() {
        return tieneEcografia;
    }


    /**
     * @param mostrarEcografia
     */
    public void setMostrarEcografia(boolean mostrarEcografia) {
        this.mostrarEcografia = mostrarEcografia;
    }

    /**
     * @return
     */
    public boolean isMostrarEcografia() {
        return mostrarEcografia;
    }


    /**
     * @param mostrarToxoplasmaIGG
     */
    public void setMostrarToxoplasmaIGG(boolean mostrarToxoplasmaIGG) {
        this.mostrarToxoplasmaIGG = mostrarToxoplasmaIGG;
    }


    /**
     * @return
     */
    public boolean isMostrarToxoplasmaIGG() {
        return mostrarToxoplasmaIGG;
    }

    /**
     * @param mostrarToxoplasmaIGM
     */
    public void setMostrarToxoplasmaIGM(boolean mostrarToxoplasmaIGM) {
        this.mostrarToxoplasmaIGM = mostrarToxoplasmaIGM;
    }

    /**
     * @return
     */
    public boolean isMostrarToxoplasmaIGM() {
        return mostrarToxoplasmaIGM;
    }

    /**
     * @param mostrarTest
     */
    public void setMostrarTest(boolean mostrarTest) {
        this.mostrarTest = mostrarTest;
    }

    /**
     * @return
     */
    public boolean isMostrarTest() {
        return mostrarTest;
    }


    /**
     * @param mostrarHemoglobina
     */
    public void setMostrarHemoglobina(boolean mostrarHemoglobina) {
        this.mostrarHemoglobina = mostrarHemoglobina;
    }

    /**
     * @return
     */
    public boolean isMostrarHemoglobina() {
        return mostrarHemoglobina;
    }


    /**
     * @param mostrarGlucosa
     */
    public void setMostrarGlucosa(boolean mostrarGlucosa) {
        this.mostrarGlucosa = mostrarGlucosa;
    }

    /**
     * @return
     */
    public boolean isMostrarGlucosa() {
        return mostrarGlucosa;
    }


    /**
     * @param mostrarSerologia
     */
    public void setMostrarSerologia(boolean mostrarSerologia) {
        this.mostrarSerologia = mostrarSerologia;
    }

    /**
     * @return
     */
    public boolean isMostrarSerologia() {
        return mostrarSerologia;
    }

    /**
     * @param fechaActual
     */
    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    /**
     * @return
     */
    public Date getFechaActual() {
        return fechaActual;
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
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
    }

    /**
     * @param mnuToxoplasmaIGG
     */
    public void setMnuToxoplasmaIGG(UIInput mnuToxoplasmaIGG) {
        this.mnuToxoplasmaIGG = mnuToxoplasmaIGG;
    }

    /**
     * @return
     */
    public UIInput getMnuToxoplasmaIGG() {
        return mnuToxoplasmaIGG;
    }

    /**
     * @param mnuToxoplasmaIGM
     */
    public void setMnuToxoplasmaIGM(UIInput mnuToxoplasmaIGM) {
        this.mnuToxoplasmaIGM = mnuToxoplasmaIGM;
    }

    /**
     * @return
     */
    public UIInput getMnuToxoplasmaIGM() {
        return mnuToxoplasmaIGM;
    }

    /**
     * @param mnuSullivan
     */
    public void setMnuSullivan(UIInput mnuSullivan) {
        this.mnuSullivan = mnuSullivan;
    }

    /**
     * @return
     */
    public UIInput getMnuSullivan() {
        return mnuSullivan;
    }

    /**
     * @param mnuHemoglobina
     */
    public void setMnuHemoglobina(UIInput mnuHemoglobina) {
        this.mnuHemoglobina = mnuHemoglobina;
    }

    /**
     * @return
     */
    public UIInput getMnuHemoglobina() {
        return mnuHemoglobina;
    }

    /**
     * @param mnuGlucosa
     */
    public void setMnuGlucosa(UIInput mnuGlucosa) {
        this.mnuGlucosa = mnuGlucosa;
    }

    /**
     * @return
     */
    public UIInput getMnuGlucosa() {
        return mnuGlucosa;
    }

    /**
     * @param mnuSerologia
     */
    public void setMnuSerologia(UIInput mnuSerologia) {
        this.mnuSerologia = mnuSerologia;
    }

    /**
     * @return
     */
    public UIInput getMnuSerologia() {
        return mnuSerologia;
    }

    /**
     * @param mnuParcialOrina
     */
    public void setMnuParcialOrina(UIInput mnuParcialOrina) {
        this.mnuParcialOrina = mnuParcialOrina;
    }

    /**
     * @return
     */
    public UIInput getMnuParcialOrina() {
        return mnuParcialOrina;
    }

    /**
     * @param mnuEcografia
     */
    public void setMnuEcografia(UIInput mnuEcografia) {
        this.mnuEcografia = mnuEcografia;
    }

    /**
     * @return
     */
    public UIInput getMnuEcografia() {
        return mnuEcografia;
    }

    /**
     * @param lstHistorialTamizaje
     */
    public void setLstHistorialTamizaje(List<Chtamizalapr> lstHistorialTamizaje) {
        this.lstHistorialTamizaje = lstHistorialTamizaje;
    }

    /**
     * @return
     */
    public List<Chtamizalapr> getLstHistorialTamizaje() {
        return lstHistorialTamizaje;
    }

    /**
     * @param codigoHistoriaPrincipal
     */
    public void setCodigoHistoriaPrincipal(Long codigoHistoriaPrincipal) {
        this.codigoHistoriaPrincipal = codigoHistoriaPrincipal;
    }

    /**
     * @return
     */
    public Long getCodigoHistoriaPrincipal() {
        return codigoHistoriaPrincipal;
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setTieneEcografia(ValueChangeEvent valueChangeEvent) {
        setTieneEcografia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setParcialOrina(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleparciorina((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setToxoplasmaIGG(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtletoxoplaigg((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setToxoplasmaIGM(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtletoxoplaigm((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setTestSullivan(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtletestsulliv((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHemoglobina(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtlehemoglobin((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setGlucosa(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleglucosa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setSerologia(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleserologia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    // Acciones AJAX

    public void changeParcial() {
        if (tamizaje != null && tamizaje.getHtleparciorina().equals("A")) {
            existeParcial = true;
        } else {
            existeParcial = false;
            if (tamizaje != null) {
                tamizaje.setHtlcparorides(null);
                parcialOrinaDesc.setValue(null);
            }
        }
    }

    public void changeEcografia() {
        if (tieneEcografia != null && tieneEcografia.equals("S")) {
            mostrarEcografia = true;
        } else {
            mostrarEcografia = false;
            if (tamizaje != null) {
                tamizaje.setHtlcecografia(null);

            }
        }
    }

    public void ChangeToxoplasmaIGG() {
        if (tamizaje != null && tamizaje.getHtletoxoplaigg().equals("S")) {
            mostrarToxoplasmaIGG = true;
        } else {
            mostrarToxoplasmaIGG = false;
            tamizaje.setHtlcresutoxigg(null);
            tamizaje.setHtldfechtoxigg(null);
        }
    }

    public void ChangeToxoplasmaIGM() {
        if (tamizaje != null && tamizaje.getHtletoxoplaigm().equals("S")) {
            mostrarToxoplasmaIGM = true;
        } else {
            mostrarToxoplasmaIGM = false;
            tamizaje.setHtlcresutoxigm(null);
            tamizaje.setHtldfechtoxigm(null);
        }
    }

    public void ChangeTextSullivan() {
        if (tamizaje != null && tamizaje.getHtletestsulliv().equals("S")) {
            mostrarTest = true;
        } else {
            tamizaje.setHtlnrestestsul(null);
            tamizaje.setHtldfectestsul(null);
            mostrarTest = false;
        }
    }

    public void ChangeHemoglobina() {
        if (tamizaje != null && tamizaje.getHtlehemoglobin().equals("S")) {
            mostrarHemoglobina = true;
        } else {
            mostrarHemoglobina = false;
            tamizaje.setHtlnreshemoglo(null);
            tamizaje.setHtldfechemoglo(null);
        }
    }

    public void ChangeGlucosa() {
        if (tamizaje != null && tamizaje.getHtleglucosa().equals("S")) {
            mostrarGlucosa = true;
        } else {
            mostrarGlucosa = false;
            tamizaje.setHtlnresglucosa(null);
            tamizaje.setHtldfecglucosa(null);
        }
    }

    public void ChangeSerologia() {
        if (tamizaje != null && tamizaje.getHtleserologia().equals("S")) {
            mostrarSerologia = true;
        } else {
            mostrarSerologia = false;
            tamizaje.setHtleresuserolo(null);
            tamizaje.setHtldfecserolog(null);
        }
    }
    //-----------------------------------------------------------------------
    //  ESVALIDO
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chtamizalapr tamizajeAux = null;
        if (consulta != null) {
            try {
                tamizajeAux = 
                        this.getServiceLocator().getClinicoService().getTamizajeLaboratorioPrenatal(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (tamizajeAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  BOT�N PRINCIPAL
    //-----------------------------------------------------------------------
    
     public void changeTodosSi(){
         existeParcial = true; 
         mostrarEcografia = true; 
         mostrarToxoplasmaIGG = true; 
         mostrarToxoplasmaIGM = true; 
         mostrarTest = true; 
         mostrarHemoglobina = true;  
         mostrarGlucosa = true; 
         mostrarSerologia = true; 
         
         mostrarUrocultivo = true; 
         mostrarAntibiograma = true; 
         mostrarHemograma = true; 
         mostrarHemoclasificacion = true; 
         mostrarPruebaRapiVIH = true; 
         mostrarAntigenoHepatitis = true; 
         mostrarTamizajeCancerCuello = true; 
         mostrarPruebasIgg = true; 
         mostrarPruebasIga = true; 
         mostrarTamizacionEstreptococo = true; 
         mostrarPruebasTolerancia = true; 
         mostrarTamizajeGotaGruesa = true; 
         mostrarElisa = true; 
         inicializarPreguntas("S");
       
     }
     
     public void changeTodosNo(){
         existeParcial = false; 
         mostrarEcografia = false; 
         mostrarToxoplasmaIGG = false; 
         mostrarToxoplasmaIGM = false; 
         mostrarTest = false; 
         mostrarHemoglobina = false; 
         mostrarGlucosa = false; 
         mostrarSerologia = false; 
         
         mostrarUrocultivo = false; 
         mostrarAntibiograma = false; 
         mostrarHemograma = false; 
         mostrarHemoclasificacion = false; 
         mostrarPruebaRapiVIH = false; 
         mostrarAntigenoHepatitis = false; 
         mostrarTamizajeCancerCuello = false; 
         mostrarPruebasIgg = false; 
         mostrarPruebasIga = false; 
         mostrarTamizacionEstreptococo = false; 
         mostrarPruebasTolerancia = false; 
         mostrarTamizajeGotaGruesa = false; 
         mostrarElisa = false; 
         inicializarPreguntas("N");
      
     }
     
     public void changeNinguno(){
         existeParcial = false; 
         mostrarEcografia = false; 
         mostrarToxoplasmaIGG = false; 
         mostrarToxoplasmaIGM = false; 
         mostrarTest = false; 
         mostrarHemoglobina = false; 
         mostrarGlucosa = false; 
         mostrarSerologia = false;
         
         mostrarUrocultivo = false; 
         mostrarAntibiograma = false; 
         mostrarHemograma = false; 
         mostrarHemoclasificacion = false; 
         mostrarPruebaRapiVIH = false; 
         mostrarAntigenoHepatitis = false; 
         mostrarTamizajeCancerCuello = false; 
         mostrarPruebasIgg = false; 
         mostrarPruebasIga = false; 
         mostrarTamizacionEstreptococo = false; 
         mostrarPruebasTolerancia = false; 
         mostrarTamizajeGotaGruesa = false; 
         mostrarElisa = false; 
         inicializarPreguntas(null);
     }
     
     
     public void inicializarPreguntas(String opcion) {
         if(tamizaje != null){
             tamizaje.setHtletoxoplaigg(opcion);
             tamizaje.setHtletoxoplaigm(opcion);
             tamizaje.setHtletestsulliv(opcion);
             tamizaje.setHtlehemoglobin(opcion);
             tamizaje.setHtleglucosa(opcion);
             tamizaje.setHtleserologia(opcion);
             tieneEcografia = opcion; 
             tamizaje.setHtlemicronutri(opcion);
             tamizaje.setHtleparciorina(opcion);
             tamizaje.setHtleurocultivo(opcion);
             tamizaje.setHtleantibiogra(opcion);
             tamizaje.setHtlehemograma(opcion);
             tamizaje.setHtlehemoclasif(opcion);
             tamizaje.setHtleprurapvih(opcion);
             tamizaje.setHtleantisupehepa(opcion);
             tamizaje.setHtletamcancue(opcion);
             tamizaje.setHtlepruigg(opcion);
             tamizaje.setHtlepruigatox(opcion);
             tamizaje.setHtletamizestre(opcion);
             tamizaje.setHtleprutoloraglu(opcion);
             tamizaje.setHtletamgotgru(opcion);
             tamizaje.setHtleelisa(opcion);

             

             mnuToxoplasmaIGG.setValue(opcion);
             mnuToxoplasmaIGM.setValue(opcion);
             mnuSullivan.setValue(opcion);
             mnuHemoglobina.setValue(opcion);
             mnuGlucosa.setValue(opcion);
             mnuSerologia.setValue(opcion);
             mnuParcialOrina.setValue(opcion);
             mnuEcografia.setValue(opcion);
             
             mnuUrocultivo.setValue(opcion);
             mnuAntibiograma.setValue(opcion);
             mnuHemograma.setValue(opcion);
             mnuHemoclasificacion.setValue(opcion);
             mnuPruebaRapiVIH.setValue(opcion);
             mnuAntigenoHepatitis.setValue(opcion);
             mnuTamizajeCancerCuello.setValue(opcion);
             mnuPruebasIgg.setValue(opcion);
             mnuPruebasIga.setValue(opcion);
             mnuTamizacionEstreptococo.setValue(opcion);
             mnuPruebasTolerancia.setValue(opcion);
             mnuTamizajeGotaGruesa.setValue(opcion);
             mnuElisa.setValue(opcion);
         }
     }

    

    public String aceptar() {

        ChtamizalaprPK id = new ChtamizalaprPK();
        tamizaje.setHtlcoperador(userName());
        tamizaje.setHtldfecharegis(new Date());
        navigationRule = "";
       
        if (tamizaje != null && tamizaje.getHtleparciorina().equals("N")) {
            tamizaje.setHtlebacteriuri(null);
            tamizaje.setHtleproteinuri(null);
            tamizaje.setHtlehematies(null);
            tamizaje.setHtleleucocitos(null);
            tamizaje.setHtlcparorides(null);
        }

        if (tieneEcografia != null && tieneEcografia.equals("N")) {
            tamizaje.setHtlcecografia(null);
        } 

        if (tamizaje != null && tamizaje.getHtletoxoplaigg() != null&& tamizaje.getHtletoxoplaigg().equals("N")) {
            tamizaje.setHtlcresutoxigg(null);
            tamizaje.setHtldfechtoxigg(null);
        }

        if (tamizaje != null && tamizaje.getHtletoxoplaigm()!= null && tamizaje.getHtletoxoplaigm().equals("N")) {
            tamizaje.setHtlcresutoxigm(null);
            tamizaje.setHtldfechtoxigm(null);
        } 

        if (tamizaje != null && tamizaje.getHtletestsulliv()!= null && tamizaje.getHtletestsulliv().equals("N")) {
            tamizaje.setHtlnrestestsul(null);
            tamizaje.setHtldfectestsul(null);
        }

        if (tamizaje != null && tamizaje.getHtlehemoglobin()!= null && tamizaje.getHtlehemoglobin().equals("N")) {
            tamizaje.setHtlnreshemoglo(null);
            tamizaje.setHtldfechemoglo(null);
        } 

        if (tamizaje != null && tamizaje.getHtleglucosa()!= null && tamizaje.getHtleglucosa().equals("N")) {
            tamizaje.setHtlnresglucosa(null);
            tamizaje.setHtldfecglucosa(null);
        }

        if (tamizaje != null && tamizaje.getHtleserologia() != null && tamizaje.getHtleserologia().equals("N")) {
            tamizaje.setHtleresuserolo(null);
            tamizaje.setHtldfecserolog(null);
        }
        
        //nuevosCampos
        
         if (tamizaje != null && tamizaje.getHtleurocultivo() != null && tamizaje.getHtleurocultivo().equals("N")) {
             tamizaje.setHtlcresulurocu(null);
             tamizaje.setHtldfechaurocu(null);
         }
         
        if (tamizaje != null && tamizaje.getHtleantibiogra() != null && tamizaje.getHtleantibiogra().equals("N")) {
            tamizaje.setHtlcresulantib(null);
            tamizaje.setHtldfechaantib (null);
        }
        
        if (tamizaje != null && tamizaje.getHtlehemograma() != null && tamizaje.getHtlehemograma().equals("N")) {
            tamizaje.setHtlcresulhemog(null);
            tamizaje.setHtldfechahemog(null);
        }
        
        if (tamizaje != null && tamizaje.getHtlehemoclasif() != null && tamizaje.getHtlehemoclasif().equals("N")) {
            tamizaje.setHtlcresulhemoc(null);
            tamizaje.setHtldfechahemoc(null);
        }
        
        
        if (tamizaje != null && tamizaje.getHtleprurapvih () != null && tamizaje.getHtleprurapvih ().equals("N")) {
            tamizaje.setHtlcresulprravi(null);
            tamizaje.setHtldfechaprravi(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleantisupehepa() != null && tamizaje.getHtleantisupehepa().equals("N")) {
            tamizaje.setHtlcresulansuhe(null);
            tamizaje.setHtldfechaansuhe (null);
        }
        
        if (tamizaje != null && tamizaje.getHtletamcancue() != null && tamizaje.getHtletamcancue().equals("N")) {
            tamizaje.setHtlcresultacacu(null);
            tamizaje.setHtldfechatacacu(null);
        }
        
        if (tamizaje != null && tamizaje.getHtlepruigg() != null && tamizaje.getHtlepruigg().equals("N")) {
            tamizaje.setHtlcresulpruigg(null);
            tamizaje.setHtldfechpruigg(null);
        }
        
        if (tamizaje != null && tamizaje.getHtlepruigatox() != null && tamizaje.getHtlepruigatox().equals("N")) {
            tamizaje.setHtlcresulprigto(null);
            tamizaje.setHtldfechprigto(null);
        }
        
        if (tamizaje != null && tamizaje.getHtletamizestre() != null && tamizaje.getHtletamizestre().equals("N")) {
            tamizaje.setHtlcresultamest(null);
            tamizaje.setHtldfechtamest(null);
        }
        
        
        if (tamizaje != null && tamizaje.getHtleprutoloraglu() != null && tamizaje.getHtleprutoloraglu().equals("N")) {
            tamizaje.setHtlcresulprtoorgl(null);
            tamizaje.setHtldfechprtoorgl(null);
        }
        
        if (tamizaje != null && tamizaje.getHtletamgotgru() != null && tamizaje.getHtletamgotgru().equals("N")) {
            tamizaje.setHtlcresultagogr(null);
            tamizaje.setHtldfechtagogr(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleelisa() != null && tamizaje.getHtleelisa().equals("N")) {
            tamizaje.setHtlcresulelisa(null);
            tamizaje.setHtldfechelisa(null);
        }
        
        
         //
        
        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHtllconsulta(new Long(consulta.getCconnumero()));
            id.setHtlctiposervi(TIPO_CONSULTA);
            tamizaje.setId(id);
  
        if (codigoHistoriaPrincipal != null) {
                 tamizaje.setHtllconsulprin(codigoHistoriaPrincipal);
         }else{
             tamizaje.setHtllconsulprin(new Long(consulta.getCconnumero()));
         }
         
        }

        try {
            this.serviceLocator.getClinicoService().saveTamizajeLaboratoriosPrenatal(tamizaje);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
            navigationRule = null;
        }
        return navigationRule;
    }


    public void setParcialOrinaDesc(UIInput parcialOrinaDesc) {
        this.parcialOrinaDesc = parcialOrinaDesc;
    }

    public UIInput getParcialOrinaDesc() {
        return parcialOrinaDesc;
    }
    
    //nuevos campos
    
     /**
      * @param valueChangeEvent
      */
     public void setHtleurocultivo(ValueChangeEvent valueChangeEvent) {
         tamizaje.setHtleurocultivo((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }
     
    /**
     * @param valueChangeEvent
     */
    public void setHtleantibiogra(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleantibiogra((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtlehemograma(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtlehemograma((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtlehemoclasif(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtlehemoclasif((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtleprurapvih(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleprurapvih((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtleantisupehepa(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleantisupehepa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setHtletamcancue(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtletamcancue((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setHtlepruigg(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtlepruigg((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtlepruigatox(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtlepruigatox((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtletamizestre(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtletamizestre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtleprutoloraglu(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleprutoloraglu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtletamgotgru(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtletamgotgru((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHtleelisa(ValueChangeEvent valueChangeEvent) {
        tamizaje.setHtleelisa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setMostrarUrocultivo(boolean mostrarUrocultivo) {
        this.mostrarUrocultivo = mostrarUrocultivo;
    }

    public boolean isMostrarUrocultivo() {
        return mostrarUrocultivo;
    }

    public void setMnuUrocultivo(UIInput mnuUrocultivo) {
        this.mnuUrocultivo = mnuUrocultivo;
    }

    public UIInput getMnuUrocultivo() {
        return mnuUrocultivo;
    }

    public void setMostrarAntibiograma(boolean mostrarAntibiograma) {
        this.mostrarAntibiograma = mostrarAntibiograma;
    }

    public boolean isMostrarAntibiograma() {
        return mostrarAntibiograma;
    }

    public void setMnuAntibiograma(UIInput mnuAntibiograma) {
        this.mnuAntibiograma = mnuAntibiograma;
    }

    public UIInput getMnuAntibiograma() {
        return mnuAntibiograma;
    }

    public void setMostrarHemograma(boolean mostrarHemograma) {
        this.mostrarHemograma = mostrarHemograma;
    }

    public boolean isMostrarHemograma() {
        return mostrarHemograma;
    }

    public void setMnuHemograma(UIInput mnuHemograma) {
        this.mnuHemograma = mnuHemograma;
    }

    public UIInput getMnuHemograma() {
        return mnuHemograma;
    }

    public void setMostrarHemoclasificacion(boolean mostrarHemoclasificacion) {
        this.mostrarHemoclasificacion = mostrarHemoclasificacion;
    }

    public boolean isMostrarHemoclasificacion() {
        return mostrarHemoclasificacion;
    }

    public void setMnuHemoclasificacion(UIInput mnuHemoclasificacion) {
        this.mnuHemoclasificacion = mnuHemoclasificacion;
    }

    public UIInput getMnuHemoclasificacion() {
        return mnuHemoclasificacion;
    }

    public void setMostrarPruebaRapiVIH(boolean mostrarPruebaRapiVIH) {
        this.mostrarPruebaRapiVIH = mostrarPruebaRapiVIH;
    }

    public boolean isMostrarPruebaRapiVIH() {
        return mostrarPruebaRapiVIH;
    }

    public void setMnuPruebaRapiVIH(UIInput mnuPruebaRapiVIH) {
        this.mnuPruebaRapiVIH = mnuPruebaRapiVIH;
    }

    public UIInput getMnuPruebaRapiVIH() {
        return mnuPruebaRapiVIH;
    }

    public void setMostrarAntigenoHepatitis(boolean mostrarAntigenoHepatitis) {
        this.mostrarAntigenoHepatitis = mostrarAntigenoHepatitis;
    }

    public boolean isMostrarAntigenoHepatitis() {
        return mostrarAntigenoHepatitis;
    }

    public void setMnuAntigenoHepatitis(UIInput mnuAntigenoHepatitis) {
        this.mnuAntigenoHepatitis = mnuAntigenoHepatitis;
    }

    public UIInput getMnuAntigenoHepatitis() {
        return mnuAntigenoHepatitis;
    }

    public void setMostrarTamizajeCancerCuello(boolean mostrarTamizajeCancerCuello) {
        this.mostrarTamizajeCancerCuello = mostrarTamizajeCancerCuello;
    }

    public boolean isMostrarTamizajeCancerCuello() {
        return mostrarTamizajeCancerCuello;
    }

    public void setMnuTamizajeCancerCuello(UIInput mnuAntigenoTamizajeCancerCuello) {
        this.mnuTamizajeCancerCuello = mnuAntigenoTamizajeCancerCuello;
    }

    public UIInput getMnuTamizajeCancerCuello() {
        return mnuTamizajeCancerCuello;
    }

    public void setMostrarPruebasIgg(boolean mostrarPruebasIgg) {
        this.mostrarPruebasIgg = mostrarPruebasIgg;
    }

    public boolean isMostrarPruebasIgg() {
        return mostrarPruebasIgg;
    }

    public void setMnuPruebasIgg(UIInput mnuAntigenoPruebasIgg) {
        this.mnuPruebasIgg = mnuAntigenoPruebasIgg;
    }

    public UIInput getMnuPruebasIgg() {
        return mnuPruebasIgg;
    }

    public void setMostrarPruebasIga(boolean mostrarPruebasIga) {
        this.mostrarPruebasIga = mostrarPruebasIga;
    }

    public boolean isMostrarPruebasIga() {
        return mostrarPruebasIga;
    }

    public void setMnuPruebasIga(UIInput mnuAntigenoPruebasIga) {
        this.mnuPruebasIga = mnuAntigenoPruebasIga;
    }

    public UIInput getMnuPruebasIga() {
        return mnuPruebasIga;
    }

    public void setMostrarTamizacionEstreptococo(boolean mostrarTamizacionEstreptococo) {
        this.mostrarTamizacionEstreptococo = mostrarTamizacionEstreptococo;
    }

    public boolean isMostrarTamizacionEstreptococo() {
        return mostrarTamizacionEstreptococo;
    }

    public void setMnuTamizacionEstreptococo(UIInput mnuTamizacionEstreptococo) {
        this.mnuTamizacionEstreptococo = mnuTamizacionEstreptococo;
    }

    public UIInput getMnuTamizacionEstreptococo() {
        return mnuTamizacionEstreptococo;
    }

    public void setMostrarPruebasTolerancia(boolean mostrarPruebasTolerancia) {
        this.mostrarPruebasTolerancia = mostrarPruebasTolerancia;
    }

    public boolean isMostrarPruebasTolerancia() {
        return mostrarPruebasTolerancia;
    }

    public void setMnuPruebasTolerancia(UIInput mnuPruebasTolerancia) {
        this.mnuPruebasTolerancia = mnuPruebasTolerancia;
    }

    public UIInput getMnuPruebasTolerancia() {
        return mnuPruebasTolerancia;
    }

    public void setMostrarTamizajeGotaGruesa(boolean mostrarTamizajeGotaGruesa) {
        this.mostrarTamizajeGotaGruesa = mostrarTamizajeGotaGruesa;
    }

    public boolean isMostrarTamizajeGotaGruesa() {
        return mostrarTamizajeGotaGruesa;
    }

    public void setMnuTamizajeGotaGruesa(UIInput mnuTamizajeGotaGruesa) {
        this.mnuTamizajeGotaGruesa = mnuTamizajeGotaGruesa;
    }

    public UIInput getMnuTamizajeGotaGruesa() {
        return mnuTamizajeGotaGruesa;
    }

    public void setMostrarElisa(boolean mostrarElisa) {
        this.mostrarElisa = mostrarElisa;
    }

    public boolean isMostrarElisa() {
        return mostrarElisa;
    }

    public void setMnuElisa(UIInput mnuElisa) {
        this.mnuElisa = mnuElisa;
    }

    public UIInput getMnuElisa() {
        return mnuElisa;
    }
    
    public void ChangeNuevasOpciones() {
        if (tamizaje != null && tamizaje.getHtleurocultivo() != null && tamizaje.getHtleurocultivo().equals("S")) {
            mostrarUrocultivo = true;
        } else {
            mostrarUrocultivo = false;
            tamizaje.setHtlcresulurocu(null);
            tamizaje.setHtldfechaurocu(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleantibiogra() != null && tamizaje.getHtleantibiogra().equals("S")) {
            mostrarAntibiograma = true;
        } else {
            mostrarAntibiograma = false;
            tamizaje.setHtlcresulantib(null);
            tamizaje.setHtldfechaantib (null);
        }
        
        if (tamizaje != null && tamizaje.getHtlehemograma() != null && tamizaje.getHtlehemograma().equals("S")) {
            mostrarHemograma = true;
        } else {
            mostrarHemograma = false;
            tamizaje.setHtlcresulhemog(null);
            tamizaje.setHtldfechahemog(null);
        }
        
        if (tamizaje != null && tamizaje.getHtlehemoclasif() != null && tamizaje.getHtlehemoclasif().equals("S")) {
            mostrarHemoclasificacion = true;
        } else {
            mostrarHemoclasificacion = false;
            tamizaje.setHtlcresulhemoc(null);
            tamizaje.setHtldfechahemoc(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleprurapvih () != null && tamizaje.getHtleprurapvih ().equals("S")) {
            mostrarPruebaRapiVIH = true;
        } else {
            mostrarPruebaRapiVIH = false;
            tamizaje.setHtlcresulprravi(null);
            tamizaje.setHtldfechaprravi(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleantisupehepa() != null && tamizaje.getHtleantisupehepa().equals("S")) {
            mostrarAntigenoHepatitis = true;
        } else {
            mostrarAntigenoHepatitis = false;
            tamizaje.setHtlcresulansuhe(null);
            tamizaje.setHtldfechaansuhe (null);
        }
        
        if (tamizaje != null && tamizaje.getHtletamcancue() != null && tamizaje.getHtletamcancue().equals("S")) {
            mostrarTamizajeCancerCuello = true;
        } else {
            mostrarTamizajeCancerCuello = false;
            tamizaje.setHtlcresultacacu(null);
            tamizaje.setHtldfechatacacu(null);
        }
        
        if (tamizaje != null && tamizaje.getHtlepruigg() != null && tamizaje.getHtlepruigg().equals("S")) {
            mostrarPruebasIgg = true;
        } else {
            mostrarPruebasIgg = false;
            tamizaje.setHtlcresulpruigg(null);
            tamizaje.setHtldfechpruigg(null);
        }
        
        if (tamizaje != null && tamizaje.getHtlepruigatox() != null && tamizaje.getHtlepruigatox().equals("S")) {
            mostrarPruebasIga = true;
        } else {
            mostrarPruebasIga = false;
            tamizaje.setHtlcresulprigto(null);
            tamizaje.setHtldfechprigto(null);
        }
        
        if (tamizaje != null && tamizaje.getHtletamizestre() != null && tamizaje.getHtletamizestre().equals("S")) {
            mostrarTamizacionEstreptococo = true;
        } else {
            mostrarTamizacionEstreptococo = false;
            tamizaje.setHtlcresultamest(null);
            tamizaje.setHtldfechtamest(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleprutoloraglu() != null && tamizaje.getHtleprutoloraglu().equals("S")) {
            mostrarPruebasTolerancia = true;
        } else {
            mostrarPruebasTolerancia = false;
            tamizaje.setHtlcresulprtoorgl(null);
            tamizaje.setHtldfechprtoorgl(null);
        }
        
        if (tamizaje != null && tamizaje.getHtletamgotgru() != null && tamizaje.getHtletamgotgru().equals("S")) {
            mostrarTamizajeGotaGruesa = true;
        } else {
            mostrarTamizajeGotaGruesa = false;
            tamizaje.setHtlcresultagogr(null);
            tamizaje.setHtldfechtagogr(null);
        }
        
        if (tamizaje != null && tamizaje.getHtleelisa() != null && tamizaje.getHtleelisa().equals("S")) {
            mostrarElisa = true;
        } else {
            mostrarElisa = false;
            tamizaje.setHtlcresulelisa(null);
            tamizaje.setHtldfechelisa(null);
        }
        
        
        
        
        
    }

    public void setLstOpcionesPruebaOrina(List lstOpcionesPruebaOrina) {
        this.lstOpcionesPruebaOrina = lstOpcionesPruebaOrina;
    }

    public List getLstOpcionesPruebaOrina() {
        if (lstOpcionesPruebaOrina == null || lstOpcionesPruebaOrina.isEmpty()) {
            lstOpcionesPruebaOrina = new ArrayList();
            lstOpcionesPruebaOrina.add(new SelectItem("N", "Normal"));
            lstOpcionesPruebaOrina.add(new SelectItem("A", "Anormal"));

        }
        return lstOpcionesPruebaOrina;
    }
}
