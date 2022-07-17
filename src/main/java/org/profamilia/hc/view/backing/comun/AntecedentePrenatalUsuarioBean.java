//=======================================================================
// ARCHIVO AntecedentePrenatalUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes los antacedentes de la Historia de Prenatal
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantecprena;
import org.profamilia.hc.model.dto.ChantecprenaPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;



//=======================================================================
//  CLASE AntecedentePrenatalUsuarioBean
//=======================================================================

public class AntecedentePrenatalUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chantecprena antecedente;

    /** Almacena la lista de opciones */
    private List lstOpciones;

    private boolean renderFamiliar;

    private boolean renderPersonal;

    private boolean renderHTAper;

    private boolean renderHTAfam;

    private boolean renderDiaper;

    private boolean renderDiafam;

    private boolean renderPreEclper;

    private boolean renderPreEclfam;

    private boolean renderEclper;

    private boolean renderEclfam;

    private boolean renderGemfam;
    
    private boolean renderGemper;

    private boolean renderCardiopatiafam;
    
    private boolean renderCardiopatiaper;

    private boolean renderTBCfam;

    private boolean renderTBCper;

    private boolean renderpelvicoper;

    private boolean renderAlergicoper;

    private boolean renderTabaquismoper;

    private boolean renderAntitetanicaper;

    private Integer tipoHistoria;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String nextAction;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AntecedentePrenatalUsuarioBean() {
    }

    public void init() {
        inicializarAntecedentes();
        nextAction = "";

    }

    public void inicializarAntecedentes() {
        try {
            antecedente = 
                    this.serviceLocator.getClinicoService().getAntecedentesPrenatales(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (antecedente == null) {
            antecedente = new Chantecprena();
        } else {

            if (antecedente.getHapchtacrofami() != null && 
                antecedente.getHapchtacrofami().equals("S")) {
                renderHTAfam = true;
            } else {
                renderHTAfam = false;
            }
            if (antecedente.getHapchtacropers() != null && 
                antecedente.getHapchtacropers().equals("S")) {
                renderHTAper = true;
            } else {
                renderHTAper = false;
            }
            if (antecedente.getHapcdiabetfami() != null && 
                antecedente.getHapcdiabetfami().equals("S")) {
                renderDiafam = true;
            } else {
                renderDiafam = false;
            }
            if (antecedente.getHapcdiabeperso() != null && 
                antecedente.getHapcdiabeperso().equals("S")) {
                renderDiaper = true;
            } else {
                renderDiaper = false;
            }
            if (antecedente.getHapcpreeclfami() != null && 
                antecedente.getHapcpreeclfami().equals("S")) {
                renderPreEclfam = true;
            } else {
                renderPreEclfam = false;
            }
            if (antecedente.getHapcpreeclpers() != null && 
                antecedente.getHapcpreeclpers().equals("S")) {
                renderPreEclper = true;
            } else {
                renderPreEclper = false;
            }
            if (antecedente.getHapceclampfami() != null && 
                antecedente.getHapceclampfami().equals("S")) {
                renderEclfam = true;
            } else {
                renderEclfam = false;
            }
            if (antecedente.getHapceclamppers() != null && 
                antecedente.getHapceclamppers().equals("S")) {
                renderEclper = true;
            } else {
                renderEclper = false;
            }

            if (antecedente.getHapcgemelafami() != null && 
                antecedente.getHapcgemelafami().equals("S")) {
                renderGemfam = true;
            } else {
                renderGemfam = false;
            }
            if (antecedente.getHapccardiofami() != null && 
                antecedente.getHapccardiofami().equals("S")) {
                renderCardiopatiafam = true;
            } else {
                renderCardiopatiafam = false;
            }

            if (antecedente.getHapcgemelapers() != null && 
                antecedente.getHapcgemelapers().equals("S")) {
                renderGemper = true;
            } else {
                renderGemper = false;
            }

            if (antecedente.getHapccardiopers() != null && 
                antecedente.getHapccardiopers().equals("S")) {
                renderCardiopatiaper = true;
            } else {
                renderCardiopatiaper = false;
            }

            if (antecedente.getHapctbcfamilia() != null && 
                antecedente.getHapctbcfamilia().equals("S")) {
                renderTBCfam = true;
            } else {
                renderTBCfam = false;
            }
            if (antecedente.getHapctuberperso() != null && 
                antecedente.getHapctuberperso().equals("S")) {
                renderTBCper = true;
            } else {
                renderTBCper = false;
            }
            if (antecedente.getHapccirpeutepe() != null && 
                antecedente.getHapccirpeutepe().equals("S")) {
                renderpelvicoper = true;
            } else {
                renderpelvicoper = false;
            }
            if (antecedente.getHapcalergipers() != null && 
                antecedente.getHapcalergipers().equals("S")) {
                renderAlergicoper = true;
            } else {
                renderAlergicoper = false;
            }
            if (antecedente.getHapctabaqupers() != null && 
                antecedente.getHapctabaqupers().equals("S")) {
                renderTabaquismoper = true;
            } else {
                renderTabaquismoper = false;
            }
            if (antecedente.getHapcantitepers() != null && 
                antecedente.getHapcantitepers().equals("S")) {
                renderAntitetanicaper = true;
            } else {
                renderAntitetanicaper = false;
            }


            if (antecedente.getHapcotrofamili() != null && 
                antecedente.getHapcotrofamili().equals("S")) {
                renderFamiliar = true;
            } else {
                renderFamiliar = false;
            }

            if (antecedente.getHapcotrosperso() != null && 
                antecedente.getHapcotrosperso().equals("S")) {
                renderPersonal = true;
            } else {
                renderPersonal = false;
            }

        }
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


    /**
     * @param renderFamiliar
     */
    public void setRenderFamiliar(boolean renderFamiliar) {
             this.renderFamiliar = renderFamiliar;
         }

    /**
     * @return
     */
    public boolean isRenderFamiliar() {
             return renderFamiliar;
         }

    /**
     * @param renderPersonal
     */
    public void setRenderPersonal(boolean renderPersonal) {
             this.renderPersonal = renderPersonal;
         }

    /**
     * @return
     */
    public boolean isRenderPersonal() {
             return renderPersonal;
         }

    /**
     * @param renderHTAper
     */
    public void setRenderHTAper(boolean renderHTAper) {
             this.renderHTAper = renderHTAper;
         }

    /**
     * @return
     */
    public boolean isRenderHTAper() {
             return renderHTAper;
         }

    /**
     * @param renderHTAfam
     */
    public void setRenderHTAfam(boolean renderHTAfam) {
             this.renderHTAfam = renderHTAfam;
         }

    /**
     * @return
     */
    public boolean isRenderHTAfam() {
             return renderHTAfam;
         }

    /**
     * @param renderDiaper
     */
    public void setRenderDiaper(boolean renderDiaper) {
             this.renderDiaper = renderDiaper;
         }

    /**
     * @return
     */
    public boolean isRenderDiaper() {
             return renderDiaper;
         }

    /**
     * @param renderDiafam
     */
    public void setRenderDiafam(boolean renderDiafam) {
             this.renderDiafam = renderDiafam;
         }

    /**
     * @return
     */
    public boolean isRenderDiafam() {
             return renderDiafam;
         }

    /**
     * @param renderPreEclper
     */
    public void setRenderPreEclper(boolean renderPreEclper) {
             this.renderPreEclper = renderPreEclper;
         }

    /**
     * @return
     */
    public boolean isRenderPreEclper() {
             return renderPreEclper;
         }

    /**
     * @param renderPreEclfam
     */
    public void setRenderPreEclfam(boolean renderPreEclfam) {
             this.renderPreEclfam = renderPreEclfam;
         }

    /**
     * @return
     */
    public boolean isRenderPreEclfam() {
             return renderPreEclfam;
         }

    /**
     * @param renderEclper
     */
    public void setRenderEclper(boolean renderEclper) {
             this.renderEclper = renderEclper;
         }

    /**
     * @return
     */
    public boolean isRenderEclper() {
             return renderEclper;
         }

    /**
     * @param renderEclfam
     */
    public void setRenderEclfam(boolean renderEclfam) {
             this.renderEclfam = renderEclfam;
         }

    /**
     * @return
     */
    public boolean isRenderEclfam() {
             return renderEclfam;
         }

    /**
     * @param renderGemfam
     */
    public void setRenderGemfam(boolean renderGemfam) {
             this.renderGemfam = renderGemfam;
         }

    /**
     * @return
     */
    public boolean isRenderGemfam() {
             return renderGemfam;
         }

    /**
     * @param renderCardiopatiafam
     */
    public void setRenderCardiopatiafam(boolean renderCardiopatiafam) {
             this.renderCardiopatiafam = renderCardiopatiafam;
         }

    /**
     * @return
     */
    public boolean isRenderCardiopatiafam() {
             return renderCardiopatiafam;
         }

    /**
     * @param renderTBCfam
     */
    public void setRenderTBCfam(boolean renderTBCfam) {
             this.renderTBCfam = renderTBCfam;
         }

    /**
     * @return
     */
    public boolean isRenderTBCfam() {
             return renderTBCfam;
         }

    /**
     * @param renderTBCper
     */
    public void setRenderTBCper(boolean renderTBCper) {
             this.renderTBCper = renderTBCper;
         }

    /**
     * @return
     */
    public boolean isRenderTBCper() {
             return renderTBCper;
         }

    /**
     * @param renderpelvicoper
     */
    public void setRenderpelvicoper(boolean renderpelvicoper) {
             this.renderpelvicoper = renderpelvicoper;
         }

    /**
     * @return
     */
    public boolean isRenderpelvicoper() {
             return renderpelvicoper;
         }

    /**
     * @param renderAlergicoper
     */
    public void setRenderAlergicoper(boolean renderAlergicoper) {
             this.renderAlergicoper = renderAlergicoper;
         }

    /**
     * @return
     */
    public boolean isRenderAlergicoper() {
             return renderAlergicoper;
         }

    /**
     * @param renderTabaquismoper
     */
    public void setRenderTabaquismoper(boolean renderTabaquismoper) {
             this.renderTabaquismoper = renderTabaquismoper;
         }

    /**
     * @return
     */
    public boolean isRenderTabaquismoper() {
             return renderTabaquismoper;
         }

    /**
     * @param renderAntitetanicaper
     */
    public void setRenderAntitetanicaper(boolean renderAntitetanicaper) {
             this.renderAntitetanicaper = renderAntitetanicaper;
         }

    /**
     * @return
     */
    public boolean isRenderAntitetanicaper() {
             return renderAntitetanicaper;
         }

    /**
     * @param antecedente
     */
    public void setAntecedente(Chantecprena antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * @return
     */
    public Chantecprena getAntecedente() {
        return antecedente;
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
     * @param renderGemper
     */
    public void setRenderGemper(boolean renderGemper) {
        this.renderGemper = renderGemper;
    }

    /**
     * @return
     */
    public boolean isRenderGemper() {
        return renderGemper;
    }

    /**
     * @param renderCardiopatiaper
     */
    public void setRenderCardiopatiaper(boolean renderCardiopatiaper) {
        this.renderCardiopatiaper = renderCardiopatiaper;
    }

    /**
     * @return
     */
    public boolean isRenderCardiopatiaper() {
        return renderCardiopatiaper;
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    public void changeTodosSi() {
        inicializarPreguntas("S",true);

    }

    public void changeTodosNo() {
        inicializarPreguntas("N",false);

    }


    public void changeNinguno() {
        inicializarPreguntas(null,false);

    }
    
    /**
       * @param opcion
       */
      public void inicializarPreguntas(String opcion, boolean renderOpcion) {

          if (antecedente != null) {
          
              renderFamiliar = renderOpcion;
              renderPersonal = renderOpcion;
              renderHTAper = renderOpcion;
              renderHTAfam = renderOpcion;
              renderDiaper = renderOpcion;
              renderDiafam = renderOpcion;
              renderPreEclper = renderOpcion;
              renderPreEclfam = renderOpcion;
              renderEclper = renderOpcion;
              renderEclfam = renderOpcion;
              renderGemfam = renderOpcion;
              renderGemper = renderOpcion; 
              renderCardiopatiaper = renderOpcion; 
              renderCardiopatiafam = renderOpcion;
              renderTBCfam = renderOpcion;
              renderTBCper = renderOpcion;
              renderpelvicoper = renderOpcion;
              renderAlergicoper = renderOpcion;
              renderTabaquismoper = renderOpcion;
              renderAntitetanicaper = renderOpcion;
       
          
              antecedente.setHapchtacrofami(opcion);
              antecedente.setHapchtacropers(opcion);
              antecedente.setHapcdiabetfami(opcion);
              antecedente.setHapcdiabeperso(opcion);
              antecedente.setHapcpreeclfami(opcion);
              antecedente.setHapcpreeclpers(opcion);
              antecedente.setHapceclampfami(opcion);
              antecedente.setHapceclamppers(opcion);
              antecedente.setHapcgemelafami(opcion);
              antecedente.setHapcgemelapers(opcion);
              antecedente.setHapccardiofami(opcion);
              antecedente.setHapccardiopers(opcion);
              antecedente.setHapctbcfamilia(opcion);
              antecedente.setHapctuberperso(opcion);
              antecedente.setHapccirpeutepe(opcion);
              antecedente.setHapcalergipers(opcion);
              antecedente.setHapctabaqupers(opcion);
              antecedente.setHapcantitepers(opcion);
              antecedente.setHapcotrosperso(opcion);
              antecedente.setHapcotrofamili(opcion);

          }

      }

    public void setOtroFamiliar(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcotrofamili((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setOtroPersonal(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcotrosperso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeOtroFamiliar() {
        if (antecedente.getHapcotrofamili() != null && 
            antecedente.getHapcotrofamili().equals("S")) {
            renderFamiliar = true;
        } else {
            antecedente.setHapccualotrfam(null);
            renderFamiliar = false;
        }
    }

    public void ChangeOtroPersonal() {
        if (antecedente.getHapcotrosperso() != null && 
            antecedente.getHapcotrosperso().equals("S")) {
            renderPersonal = true;
        } else {
            antecedente.setHapccualotrper(null);
            renderPersonal = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapchtacrofami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapchtacrofami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeHtaFami() {

        if (antecedente.getHapchtacrofami() != null && 
            antecedente.getHapchtacrofami().equals("S")) {
            renderHTAfam = true;

        } else {
            antecedente.setHapcdeshtacrof(null);
            renderHTAfam = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapchtacropers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapchtacropers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeHtaPers() {
        if (antecedente.getHapchtacropers() != null && 
            antecedente.getHapchtacropers().equals("S")) {
            renderHTAper = true;
        } else {
            antecedente.setHapcdeshtacrop(null);
            renderHTAper = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapcdiabetfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcdiabetfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeDiabetesFamiliar() {
        if (antecedente.getHapcdiabetfami() != null && 
            antecedente.getHapcdiabetfami().equals("S")) {
            renderDiafam = true;
        } else {
            antecedente.setHapcdesdiabetf(null);
            renderDiafam = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcdiabeperso(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcdiabeperso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeDiabetesPersonal() {
        if (antecedente.getHapcdiabeperso() != null && 
            antecedente.getHapcdiabeperso().equals("S")) {
            renderDiaper = true;
        } else {
            antecedente.setHapcdesdiabepe(null);
            renderDiaper = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcpreeclfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcpreeclfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangePreeclfami() {
        if (antecedente.getHapcpreeclfami() != null && 
            antecedente.getHapcpreeclfami().equals("S")) {
            renderPreEclfam = true;
        } else {
            antecedente.setHapcdespreeclf(null);
            renderPreEclfam = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapcpreeclpers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcpreeclpers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangePreeclpers() {
        if (antecedente.getHapcpreeclpers() != null && 
            antecedente.getHapcpreeclpers().equals("S")) {
            renderPreEclper = true;
        } else {
            antecedente.setHapcdespreeclp(null);
            renderPreEclper = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapceclampfami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapceclampfami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEclampsiafami() {
        if (antecedente.getHapceclampfami() != null && 
            antecedente.getHapceclampfami().equals("S")) {
            renderEclfam = true;
        } else {
            antecedente.setHapcdeseclampf(null);
            renderEclfam = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapceclamppers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapceclamppers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeEclampsiapers() {
        if (antecedente.getHapceclamppers() != null && 
            antecedente.getHapceclamppers().equals("S")) {
            renderEclper = true;
        } else {
            antecedente.setHapcdeseclampp(null);
            renderEclper = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapcgemelafami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcgemelafami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapcgemelapers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcgemelapers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

    public void ChangeGemelaresfami() {
        if (antecedente.getHapcgemelafami() != null && 
            antecedente.getHapcgemelafami().equals("S")) {
            renderGemfam = true;
        } else {
            antecedente.setHapcdesgemelaf(null);
            renderGemfam = false;
        }
    }
    
    
    public void ChangeGemelarespers() {
        if (antecedente.getHapcgemelapers() != null && 
            antecedente.getHapcgemelapers().equals("S")) {
            renderGemper = true;
        } else {
            antecedente.setHapcdesgemelap(null);
            renderGemper = false;
        }
    }
    


    /**
     * @param valueChangeEvent
     */
    public void setHapccardiofami(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapccardiofami((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapccardiopers(ValueChangeEvent valueChangeEvent) {
         antecedente.setHapccardiopers((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeCardiopatiafami() {
        if (antecedente.getHapccardiofami() != null && 
            antecedente.getHapccardiofami().equals("S")) {
            renderCardiopatiafam = true;
        } else {
            antecedente.setHapcdescardiof(null);
            renderCardiopatiafam = false;
        }
    }
    
    public void ChangeCardiopatiapers() {
        if (antecedente.getHapccardiopers() != null && 
            antecedente.getHapccardiopers().equals("S")) {
            renderCardiopatiaper = true;
        } else {
            antecedente.setHapcdescardiop(null);
            renderCardiopatiaper = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapctbcfamilia(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapctbcfamilia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeTBCfami() {
        if (antecedente.getHapctbcfamilia() != null && 
            antecedente.getHapctbcfamilia().equals("S")) {
            renderTBCfam = true;
        } else {
            antecedente.setHapcdestbcfami(null);
            renderTBCfam = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapctuberperso(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapctuberperso((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeTBCperso() {
        if (antecedente.getHapctuberperso() != null && 
            antecedente.getHapctuberperso().equals("S")) {
            renderTBCper = true;
        } else {
            antecedente.setHapcdestuberpe(null);
            renderTBCper = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapccirpeutepe(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapccirpeutepe((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeCirugiaperso() {
        if (antecedente.getHapccirpeutepe() != null && 
            antecedente.getHapccirpeutepe().equals("S")) {
            renderpelvicoper = true;
        } else {
            antecedente.setHapcdescirugpe(null);
            renderpelvicoper = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapcalergipers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcalergipers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeAlergicospers() {
        if (antecedente.getHapcalergipers() != null && 
            antecedente.getHapcalergipers().equals("S")) {
            renderAlergicoper = true;
        } else {
            antecedente.setHapcdesalergip(null);
            renderAlergicoper = false;
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHapctabaqupers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapctabaqupers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeTabaquismoperso() {
        if (antecedente.getHapctabaqupers() != null && 
            antecedente.getHapctabaqupers().equals("S")) {
            renderTabaquismoper = true;
        } else {
            antecedente.setHapcdestabaqup(null);
            renderTabaquismoper = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHapcantitepers(ValueChangeEvent valueChangeEvent) {
        antecedente.setHapcantitepers((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeAntitetanicapers() {
        if (antecedente.getHapcantitepers() != null && 
            antecedente.getHapcantitepers().equals("S")) {
            renderAntitetanicaper = true;
        } else {
            antecedente.setHapcdesantitep(null);
            renderAntitetanicaper = false;
        }
    }

    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    public boolean esValido() {
        boolean esValido = false;
        Chantecprena antecedenteAux = null;
        if (consulta != null) {
            try {
                antecedenteAux = 
                        this.serviceLocator.getClinicoService().getAntecedentesPrenatales(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (antecedenteAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------


    public String aceptar() {
        ChantecprenaPK id = new ChantecprenaPK();
        navigationRule = "";

        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHaplconsulta(new Long(consulta.getCconnumero()));
            id.setHapctiposervi(TIPO_CONSULTA);
            antecedente.setId(id);
        }
        if (antecedente.getHapcotrofamili() != null && 
            antecedente.getHapcotrofamili().equals("N")) {
            antecedente.setHapccualotrfam(null);
        }


        if (antecedente.getHapcotrosperso() != null && 
            antecedente.getHapcotrosperso().equals("N")) {
            antecedente.setHapccualotrper(null);
        }

        if (antecedente.getHapchtacrofami() != null && 
            antecedente.getHapchtacrofami().equals("N")) {
            antecedente.setHapcdeshtacrof(null);

        }

        if (antecedente.getHapchtacropers() != null && 
            antecedente.getHapchtacropers().equals("N")) {
            antecedente.setHapcdeshtacrop(null);
        }

        if (antecedente.getHapcdiabetfami() != null && 
            antecedente.getHapcdiabetfami().equals("N")) {
            antecedente.setHapcdesdiabetf(null);
        }

        if (antecedente.getHapcdiabeperso() != null && 
            antecedente.getHapcdiabeperso().equals("N")) {
            antecedente.setHapcdesdiabepe(null);
        }

        if (antecedente.getHapcpreeclfami() != null && 
            antecedente.getHapcpreeclfami().equals("N")) {
            antecedente.setHapcdespreeclf(null);
        }

        if (antecedente.getHapcpreeclpers() != null && 
            antecedente.getHapcpreeclpers().equals("N")) {
            antecedente.setHapcdespreeclp(null);
        }

        if (antecedente.getHapceclampfami() != null && 
            antecedente.getHapceclampfami().equals("N")) {
            antecedente.setHapcdeseclampf(null);
        }

        if (antecedente.getHapceclamppers() != null && 
            antecedente.getHapceclamppers().equals("N")) {
            antecedente.setHapcdeseclampp(null);
        }

        if (antecedente.getHapcgemelafami() != null && 
            antecedente.getHapcgemelafami().equals("N")) {
            antecedente.setHapcdesgemelaf(null);
        }
        if (antecedente.getHapccardiofami() != null && 
            antecedente.getHapccardiofami().equals("N")) {
            antecedente.setHapcdescardiof(null);
        }

        if (antecedente.getHapctbcfamilia() != null && 
            antecedente.getHapctbcfamilia().equals("N")) {
            antecedente.setHapcdestbcfami(null);
        }
        if (antecedente.getHapctuberperso() != null && 
            antecedente.getHapctuberperso().equals("N")) {
            antecedente.setHapcdestuberpe(null);
        }

        if (antecedente.getHapccirpeutepe() != null && 
            antecedente.getHapccirpeutepe().equals("N")) {
            antecedente.setHapcdescirugpe(null);
        }
        if (antecedente.getHapcalergipers() != null && 
            antecedente.getHapcalergipers().equals("N")) {
            antecedente.setHapcdesalergip(null);
        }

        if (antecedente.getHapctabaqupers() != null && 
            antecedente.getHapctabaqupers().equals("N")) {
            antecedente.setHapcdestabaqup(null);
        }
        if (antecedente.getHapcantitepers() != null && 
            antecedente.getHapcantitepers().equals("N")) {
            antecedente.setHapcdesantitep(null);
        }
        
        if (antecedente.getHapccardiopers() != null && 
                   antecedente.getHapccardiopers().equals("N")) {
            antecedente.setHapcdescardiop(null);
        }
        
        if (antecedente.getHapcgemelapers() != null && 
               antecedente.getHapcgemelapers().equals("N")) {
               antecedente.setHapcdesgemelap(null); 
        } 
        
        antecedente.setHapdfecregistr(new Date());
        antecedente.setHapcoperador(userName());

        try {
            serviceLocator.getClinicoService().saveAntecedentesPrenatal(antecedente);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            navigationRule = nextAction;
            FacesUtils.resetManagedBean(menuBean);
        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = null;
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
        return navigationRule;
    }

}
