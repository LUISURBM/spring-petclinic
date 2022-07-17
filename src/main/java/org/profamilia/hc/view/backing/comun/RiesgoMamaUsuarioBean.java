//=======================================================================
// ARCHIVO RiesgoMamaUsuarioBean
// FECHA CREACI�N: 30/10/2008
// AUTOR: jariano, nlis
// Descripcion: Permite registrar el Riesgo del Examen de Mamas
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chriesgomama;
import org.profamilia.hc.model.dto.ChriesgomamaPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE ExamenFisicoMamaUsuarioBean
//=======================================================================
public class RiesgoMamaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Variable que almacena 'S' si la usuario se ha realizado una terapia de reemplazo hormonal
     * 'N' de lo contrario*/
    private String terapiaSelect;

    /** Variable que alamacena 'S' si tiene un antecente personal de cancer 'N' de lo contrario */
    private String antececancerSelect;

    /** Variable que almacena 'S' si tiene o tuvo un familiar con antecedente de cancer de mama */
    private String familiarcancerSelect;

    /** Variable que almacena 'S' si la usuaria tiene antecedentes de biopsia de mama */
    private String biopsamamaSelect;

    /** Variable que almacena el tipo de biopsia */
    private String tipoBiopsa;

    /** Variable que almacena la lista de los posibles resultados de los antecedentes de biopsa de mama*/
    private List lstAnteBiopsa;

    /** Almacena la lista de opciones 'S' SI o 'N' NO */
    private List lstOpciones;

    /** Almacena true si debe mostrar cuantos anos realizo terapia de reemplazo hormonal*/
    private boolean mostrarTerapia;

    /** Almacena true si se debe mostrar el tipo de cancer */
    private boolean mostrarCancerPersonal;

    /** Variable que almacena true si tiene familiares con antecedentes de mama */
    private boolean mostrarFamiliares;

    /** Variable que almacena true si tiene antecedentes de biopsa de mama */
    private boolean mostrarBiopsa;

    /** Variable que almacena true si tiene lactancia acumulada false de lo contrario*/
    private boolean mostrarLactancia;

    /** Variable que almacena el objeto Chriesgomama*/
    private Chriesgomama riesgo;

    /** Almacena la edad del Paciente */
    Integer edad;

    /** Almacena true si la edad del paciente es menor de 50 anos*/
    private boolean edadMenor;


    /** Almacena la lactancia seleccionada*/
    private String lactanciaSelect;


    /** Almacena la lista de lactancia*/
    private List<SelectItem> lstLactancia;

    private String tieneLactancia;

    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    private Chusuario usuario;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    public RiesgoMamaUsuarioBean() {
    }

    public void init() {
        nextAction = "";
        edadMenor = false;
        inicializarRiesgo();
    }

    public void inicializarRiesgo() {
        try {
            riesgo = 
                    this.getServiceLocator().getClinicoService().getRiesgoMama(consulta);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (riesgo == null) {
            riesgo = new Chriesgomama();

            if (usuario != null && usuario.getEdad() != null) {
                edad = usuario.getEdad();

                if (edad.compareTo(50) < 0) {
                    riesgo.setHrmemenopadesp("N");
                    edadMenor = true;
                }
            }


        } else {

            if (riesgo.getHrmnlactacum() != null) {
                lactanciaSelect = riesgo.getHrmnlactacum().toString();
            }

            if (riesgo.getHrmeterahormon() != null) {
                terapiaSelect = riesgo.getHrmeterahormon();
                if (terapiaSelect != null && terapiaSelect.equals("S")) {
                    mostrarTerapia = true;
                } else {
                    mostrarTerapia = false;
                }
            }
            if (riesgo.getHrmeantecancer() != null) {
                antececancerSelect = riesgo.getHrmeantecancer();
                if (antececancerSelect != null && 
                    antececancerSelect.equals("S")) {
                    mostrarCancerPersonal = true;
                } else {
                    mostrarCancerPersonal = false;

                }
            }

            if (riesgo.getHrmnantebiopma() != null && 
                !riesgo.getHrmnantebiopma().equals("")) {
                tipoBiopsa = riesgo.getHrmnantebiopma().toString();
                biopsamamaSelect = "S";
            } else {
                biopsamamaSelect = "N";
            }

            if (riesgo.getHrmefamicancer() != null) {
                familiarcancerSelect = riesgo.getHrmefamicancer();
                if (familiarcancerSelect != null && 
                    familiarcancerSelect.equals("S")) {
                    mostrarFamiliares = true;
                }

            }


        }
    }


    //-----------------------------------------------------------------------
    // GET/SET
    //----------------------------------------------------------------------


    /**
     * @param terapiaSelect
     */
    public void setTerapiaSelect(String terapiaSelect) {
        this.terapiaSelect = terapiaSelect;
    }


    /**
     * @return
     */
    public String getTerapiaSelect() {
        return terapiaSelect;
    }

    /**
     * @param antececancerSelect
     */
    public void setAntececancerSelect(String antececancerSelect) {
        this.antececancerSelect = antececancerSelect;
    }

    /**
     * @return
     */
    public String getAntececancerSelect() {
        return antececancerSelect;
    }

    /**
     * @param familiarcancerSelect
     */
    public void setFamiliarcancerSelect(String familiarcancerSelect) {
        this.familiarcancerSelect = familiarcancerSelect;
    }

    /**
     * @return
     */
    public String getFamiliarcancerSelect() {
        return familiarcancerSelect;
    }

    /**
     * @param biopsamamaSelect
     */
    public void setBiopsamamaSelect(String biopsamamaSelect) {
        this.biopsamamaSelect = biopsamamaSelect;
    }


    /**
     * @return
     */
    public String getBiopsamamaSelect() {
        return biopsamamaSelect;
    }

    /**
     * @param tipoBiopsa
     */
    public void setTipoBiopsa(String tipoBiopsa) {
        this.tipoBiopsa = tipoBiopsa;
    }

    /**
     * @return
     */
    public String getTipoBiopsa() {
        return tipoBiopsa;
    }

    /**
     * @param lstAnteBiopsa
     */
    public void setLstAnteBiopsa(List lstAnteBiopsa) {
        this.lstAnteBiopsa = lstAnteBiopsa;
    }

    /**
     * @return
     */
    public List getLstAnteBiopsa() {
        if (lstAnteBiopsa == null || lstAnteBiopsa.isEmpty()) {
            lstAnteBiopsa = new ArrayList();
            lstAnteBiopsa.add(new SelectItem("", 
                                             "Seleccione una opci�n ... "));
            lstAnteBiopsa.add(new SelectItem("1", "Benigno "));
            lstAnteBiopsa.add(new SelectItem("2", "CDIS "));
            lstAnteBiopsa.add(new SelectItem("3", "CLIS "));
            lstAnteBiopsa.add(new SelectItem("4", "Maligno "));
            lstAnteBiopsa.add(new SelectItem("5", 
                                             "Hiperplasia ductal o lobulillar "));
            lstAnteBiopsa.add(new SelectItem("6", "No recuerda "));

        }
        return lstAnteBiopsa;
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
     * @param mostrarTerapia
     */
    public void setMostrarTerapia(boolean mostrarTerapia) {
        this.mostrarTerapia = mostrarTerapia;
    }

    /**
     * @return
     */
    public boolean isMostrarTerapia() {
        return mostrarTerapia;
    }


    /**
     * @param mostrarCancerPersonal
     */
    public void setMostrarCancerPersonal(boolean mostrarCancerPersonal) {
        this.mostrarCancerPersonal = mostrarCancerPersonal;
    }

    /**
     * @return
     */
    public boolean isMostrarCancerPersonal() {
        return mostrarCancerPersonal;
    }


    /**
     * @param mostrarFamiliares
     */
    public void setMostrarFamiliares(boolean mostrarFamiliares) {
        this.mostrarFamiliares = mostrarFamiliares;
    }

    /**
     * @return
     */
    public boolean isMostrarFamiliares() {
        return mostrarFamiliares;
    }

    /**
     * @param mostrarBiopsa
     */
    public void setMostrarBiopsa(boolean mostrarBiopsa) {
        this.mostrarBiopsa = mostrarBiopsa;
    }

    /**
     * @return
     */
    public boolean isMostrarBiopsa() {
        return mostrarBiopsa;
    }

    /**
     * @param edadMenor
     */
    public void setEdadMenor(boolean edadMenor) {
        this.edadMenor = edadMenor;
    }

    /**
     * @return
     */
    public boolean isEdadMenor() {
        return edadMenor;
    }

    /**
     * @param tieneLactancia
     */
    public void setTieneLactancia(String tieneLactancia) {
        this.tieneLactancia = tieneLactancia;
    }

    /**
     * @return
     */
    public String getTieneLactancia() {
        return tieneLactancia;
    }

    /**
     * @param mostrarLactancia
     */
    public void setMostrarLactancia(boolean mostrarLactancia) {
        this.mostrarLactancia = mostrarLactancia;
    }

    /**
     * @return
     */
    public boolean isMostrarLactancia() {
        return mostrarLactancia;
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
     * @param riesgo
     */
    public void setRiesgo(Chriesgomama riesgo) {
        this.riesgo = riesgo;
    }

    /**
     * @return
     */
    public Chriesgomama getRiesgo() {
        return riesgo;
    }

    /**
     * @param lactanciaSelect
     */
    public void setLactanciaSelect(String lactanciaSelect) {
        this.lactanciaSelect = lactanciaSelect;
    }

    /**
     * @return
     */
    public String getLactanciaSelect() {
        return lactanciaSelect;
    }

    /**
     * @param lstLactancia
     */
    public void setLstLactancia(List<SelectItem> lstLactancia) {
        this.lstLactancia = lstLactancia;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstLactancia() {
        if (lstLactancia == null || lstLactancia.isEmpty()) {
            lstLactancia = new ArrayList<SelectItem>();
            lstLactancia.add(new SelectItem("1", " 1 a 5 meses "));
            lstLactancia.add(new SelectItem("2", " 6 a 11 meses "));
            lstLactancia.add(new SelectItem("3", " 1 a 2 anos "));
            lstLactancia.add(new SelectItem("4", " >2 anos "));
        }
        return lstLactancia;
    }
    // Metodos AJAX


    //-----------------------------------------------------------------------
    // AJAX
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setTerapiaSelect(ValueChangeEvent valueChangeEvent) {
        setTerapiaSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setAntececancerSelect(ValueChangeEvent valueChangeEvent) {
        setAntececancerSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setFamiliarcancerSelect(ValueChangeEvent valueChangeEvent) {
        setFamiliarcancerSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setBiopsamamaSelect(ValueChangeEvent valueChangeEvent) {
        setBiopsamamaSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setTieneLactancia(ValueChangeEvent valueChangeEvent) {
        riesgo.setHrmelactancia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeLactancia() {
        if (riesgo != null && riesgo.getHrmelactancia().equals("S")) {
            mostrarLactancia = true;
        } else {
            mostrarLactancia = false;
        }
    }


    public void changeTerapia() {
        if (terapiaSelect != null && terapiaSelect.equals("S")) {
            mostrarTerapia = true;
        } else {
            mostrarTerapia = false;
            riesgo.setHrmnanosterap(null);
        }
    }

    public void changeCancerPersonal() {
        if (antececancerSelect != null && antececancerSelect.equals("S")) {
            mostrarCancerPersonal = true;
        } else {
            mostrarCancerPersonal = false;
            riesgo.setHrmccancerpers(null);
        }
    }


    public void changeFamiliaCancer() {
        if (familiarcancerSelect != null && familiarcancerSelect.equals("S")) {
            mostrarFamiliares = true;
        } else {
            mostrarFamiliares = false;
            riesgo.setHrmccancerfami(null);
        }
    }

    public void changeBiopsa() {
        if (biopsamamaSelect != null && biopsamamaSelect.equals("S")) {
            mostrarBiopsa = true;
        } else {
            tipoBiopsa = "";
            mostrarBiopsa = false;
        }
    }

    //-----------------------------------------------------------------------
    // METODO ESVALIDO
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chriesgomama riesgoAux = null;
        if (consulta != null) {

            try {
                riesgoAux = 
                        this.getServiceLocator().getClinicoService().getRiesgoMama(consulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (riesgoAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    // BOTON PRINCIPAL
    //-----------------------------------------------------------------------

    public String aceptar() {
        navigationRule = "";
        Integer codBiopsa = null;
        Integer codLactancia = null;
        ChriesgomamaPK id = new ChriesgomamaPK();

        if (tipoBiopsa != null && !tipoBiopsa.equals("")) {
            codBiopsa = new Integer(tipoBiopsa);
        }

        if (lactanciaSelect != null && !lactanciaSelect.equals("")) {
            codLactancia = new Integer(lactanciaSelect);
        }

        riesgo.setHrmeterahormon(terapiaSelect);
        riesgo.setHrmeantecancer(antececancerSelect);
        riesgo.setHrmnantebiopma(codBiopsa);
        riesgo.setHrmefamicancer(familiarcancerSelect);
        riesgo.setHrmnlactacum(codLactancia);
        riesgo.setHrmcoperador(userName());
        riesgo.setHrmdfecregistr(new Date());
        if (consulta != null && consulta.getCconnumero() != null) {
            id.setHrmlconsulta(new Long(consulta.getCconnumero()));
            id.setHrmctiposervi(TIPO_CONSULTA);
            riesgo.setId(id);
        }

        try {
            this.serviceLocator.getClinicoService().saveRiesgoMama(riesgo);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            navigationRule = nextAction;
            FacesUtils.resetManagedBean(menuBean);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            navigationRule = null;
            e.printStackTrace();
        }

        return navigationRule;

    }


}
