//=======================================================================
// ARCHIVO TamizajeControlPrenatalUsuarioBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano Rinc�n jariano@profamilia.org.co
// Descripci�n: Datos correspondientes al tamizaje del control Prenatal
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
//  CLASE TamizajeControlPrenatalUsuarioBean
//=======================================================================

public class TamizajeControlPrenatalUsuarioBean extends BaseBean {

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

    /** Almacena el codigo de la consulta principal*/
    private Long codigoHistoriaPrincipal;

    private List<Chtamizalapr> lstHistorialTamizaje;

    private Integer tipoHistoria;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String nextAction;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public TamizajeControlPrenatalUsuarioBean() {
    }

    public void init() {
        fechaActual = new Date();
        inicializarTamizaje();
        nextAction = "";
    }

    public void inicializarTamizaje() {
        if (consulta != null) {
            try {
                tamizaje = 
                        this.serviceLocator.getClinicoService().getTamizajeLaboratorioPrenatal(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (usuario != null) {
            try {
                codigoHistoriaPrincipal = 
                        this.serviceLocator.getClinicoService().getConsultaPrenatalPrincipal(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (codigoHistoriaPrincipal != null) {
                try {
                    lstHistorialTamizaje = 
                            this.serviceLocator.getClinicoService().getTamizajesLaboratorioPrenatal(codigoHistoriaPrincipal);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }


        if (tamizaje == null) {
            tamizaje = new Chtamizalapr();
        } else {
            if (tamizaje.getHtlcecografia() != null) {
                tieneEcografia = "S";
                mostrarEcografia = true;
            } else {
                tieneEcografia = "N";
                mostrarEcografia = false;
            }

            if (tamizaje.getHtleparciorina() != null && 
                tamizaje.getHtleparciorina().equals("S")) {
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

    //-----------------------------------------------------------------------
    // ValueChangeListener 
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

    /**
     * @param mostrarToxoplasmaIGG
     */
    public void setMostrarToxoplasmaIGG(boolean mostrarToxoplasmaIGG) {
        this.mostrarToxoplasmaIGG = mostrarToxoplasmaIGG;
    }


    //-----------------------------------------------------------------------
    // AJAX
    //-----------------------------------------------------------------------

    public void changeParcial() {
        if (tamizaje != null && tamizaje.getHtleparciorina().equals("S")) {
            existeParcial = true;
        } else {
            existeParcial = false;
            if (tamizaje != null) {
                tamizaje.setHtlebacteriuri(null);
                tamizaje.setHtleproteinuri(null);
                tamizaje.setHtlehematies(null);
                tamizaje.setHtleleucocitos(null);
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
    // ESVALIDO
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
    // AJAX
    //-----------------------------------------------------------------------

    public String aceptar() {
        ChtamizalaprPK id = new ChtamizalaprPK();
        navigationRule = "";

        tamizaje.setHtlcoperador(userName());
        tamizaje.setHtldfecharegis(new Date());


        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHtllconsulta(new Long(consulta.getCconnumero()));
            id.setHtlctiposervi(TIPO_CONSULTA);
            tamizaje.setId(id);
        }

        if (codigoHistoriaPrincipal != null) {
            tamizaje.setHtllconsulprin(codigoHistoriaPrincipal);
        }


        try {
            this.serviceLocator.getClinicoService().saveTamizajeLaboratoriosPrenatal(tamizaje);
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            navigationRule = nextAction;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            navigationRule = null;
            e.printStackTrace();
        }
        return navigationRule;

    }


}
