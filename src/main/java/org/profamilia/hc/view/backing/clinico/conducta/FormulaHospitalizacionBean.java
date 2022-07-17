//=======================================================================
// ARCHIVO 
// FECHA CREACI�N: 
// AUTOR: jariano, nliz, avargas
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.clinico.conducta;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chunidades;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorMedicamentoBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=======================================================================
//  CLASE FormulaHospitalizacionBean.java
//=======================================================================
public class FormulaHospitalizacionBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    /** Lista que almacena los tipos de vias de administracion de los medicamentos*/
    private List lstVia;

    /** Lista que almacena las unidades de tiempo para la administraci�n de los medicamentos*/
    private List lstUnidadTiempo;

    /** Almacena la tabla de la formulaci�n */
    private HtmlDataTable dtFormula;

    /** Almacena la tabla de la formulaci�n */
    private HtmlDataTable dtAnalgesia;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulahos> lstPrescripciones;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulahos> lstHistorialExterna;

    /**Almacena la lista de prescripci�n activas en esta o en otra consulta */
    private List<Chformulahos> lstHistorialPrescrpcion;

    /**Almacena la lista de prescripci�n activas en esta o en otra consulta */
    private List<Chformulahos> lstPrescripcionSuspender;

    /** Almacena la formula que se desea eliminar de la base de datos */
    private Chformulahos formulaClon;

    /** Variable que almacena el Objeto formula de Hospitalizacion */
    private Chformulahos formula;

    /** Dosis del medicamento a administrar en las unidades respectivas, por ejemplo gramos, miligramos, microgramos */
    private BigDecimal dosisSelect;

    /** Tiempo total a suministrar el medicamento */
    private Integer tiempoTotal;

    /** Variable que almacena Cada cuento tiempo se administra la dosis formulada */
    private Integer frecuenciaAdm;

    /** Variable que almacena el Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica */
    private String medicamentoSelect;

    /** Variable que almacena  la presentaci�n del medicamento, por ejemplo: ampollas, tabletas, capsulas, loci�n, ung�ento, etc. */
    private String presentacionSelect;

    /** Variable que almacena la via de administracion  */
    private String viaSelect;

    /** Variable que almacena otra via de Administracion  */
    private String otraVia;

    /** Variable que almacena true si la va de administracion es Intravenosa*/
    private boolean mostrarIntravenosa;

    /**Variable que almacena el valor de recomendacionSelect intravenosa
     */
    private String recoIntravenosa;

    /** Lista que almacena las unidades respectiva */
    private

    List lstUnidades;

    /** Alamcena la unidad seleccionada*/
    private String unidadSelect;

    /** Alamcena la unidad de tiempo seleccionada*/
    private String tiempoSelect;

    private Long numeroCirugia;

    private String tipoServicio;

    private Integer consecutivo;

    private Chusuario usuario;

    private Long numeroUsuario;

    private boolean renderProfilaxis;

    private boolean renderAnalgesiaPosoperatoria;

    private boolean renderAnalgesia;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulahos> lstProfilaxisAntibiotica;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulahos> lstProfilaxisAntitrombotica;

    private List<Chformulahos> lstAnalgesiaPosoperatoria;

    private HtmlDataTable dtAntibiotica;

    private HtmlDataTable dtAntitrombotica;

    private boolean renderAntibiotica;

    private boolean renderAntitrombotica;

    private String msgMedicamento;

    private boolean renderBuscador;

    private int selectedIndex;

    private static final int ACTIVAR_FORMULA_MEDICA = 0;

    private static final int ACTIVAR_BUSCADOR = 1;


    private boolean deshabilitarMedicamento;

    /** Variable que almacena el Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica */
    private String medicamento;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulahos> lstPrescripcionesVasectomia;

    private String conciliacionMedicamentosa = null;

    /** Lista que almacena la lista de opciones */
    private List<SelectItem> listOpciones;
    
    private boolean renderIve; 
    
    private String codsap;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------    

    public FormulaHospitalizacionBean() {
    }

    public void init() {
        lstVia = new ArrayList();
        lstUnidadTiempo = new ArrayList();
        lstUnidades = new ArrayList();
        setMsgMedicamento("Verificar si prescribe:  Gentamicina 3-5 mg/kg/d�a ");

        lstProfilaxisAntibiotica = new ArrayList<Chformulahos>();
        lstProfilaxisAntitrombotica = new ArrayList<Chformulahos>();
        lstAnalgesiaPosoperatoria = new ArrayList<Chformulahos>();

        if (renderProfilaxis) {
            inicializarProfilaxisAntibiotico();
            inicializarProfilaxisAntitrombotico();
        }

        if (renderAnalgesiaPosoperatoria) {
            inicializarAnalgesiaPosoperatoria();
        }


        try {
            lstHistorialPrescrpcion = 
                    this.serviceLocator.getCirugiaService().getFormulaMedicamentosCirugia(numeroCirugia, 
                                                                                          consecutivo);


            lstPrescripciones = 
                    serviceLocator.getClinicoService().getLstFormulaHospitalizacion(numeroCirugia, 
                                                                                    tipoServicio, 
                                                                                    consecutivo);


            lstHistorialExterna = 
                    serviceLocator.getCirugiaService().getFormulaMedicamentosConsultaExterna(numeroUsuario, 
                                                                                             numeroCirugia);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstHistorialPrescrpcion != null && 
            !lstHistorialPrescrpcion.isEmpty()) {
            for (Chformulahos auxhispre: lstHistorialPrescrpcion) {
                if (auxhispre.getHfhcconcimedi() != null) {
                    conciliacionMedicamentosa = auxhispre.getHfhcconcimedi();
                }
            }
        }
        if (lstPrescripciones != null && !lstPrescripciones.isEmpty()) {
            for (Chformulahos auxpres: lstPrescripciones) {
                if (auxpres.getHfhcconcimedi() != null) {
                    conciliacionMedicamentosa = auxpres.getHfhcconcimedi();
                }
            }
        }

        if (lstPrescripciones == null || lstPrescripciones.isEmpty()) {
            lstPrescripciones = new ArrayList<Chformulahos>();

            if (lstPrescripcionesVasectomia != null && 
                !lstPrescripcionesVasectomia.isEmpty()) {
                lstPrescripciones = lstPrescripcionesVasectomia;
            }

        }
    }

    public void renderMedicamentos() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }

    /**
     * @param valueChangeEvent
     */
    public void setMedicamento(ValueChangeEvent valueChangeEvent) {
        setMedicamento((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    public void setRecoIntravenosa(String recoIntravenosa) {
        this.recoIntravenosa = recoIntravenosa;
    }

    public String getRecoIntravenosa() {
        return recoIntravenosa;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setDeshabilitarMedicamento(boolean deshabilitarMedicamento) {
        this.deshabilitarMedicamento = deshabilitarMedicamento;
    }

    public boolean isDeshabilitarMedicamento() {
        return deshabilitarMedicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setLstPrescripcionesVasectomia(List<Chformulahos> lstPrescripcionesVasectomia) {
        this.lstPrescripcionesVasectomia = lstPrescripcionesVasectomia;
    }

    public List<Chformulahos> getLstPrescripcionesVasectomia() {
        return lstPrescripcionesVasectomia;
    }

    public void setRenderAnalgesiaPosoperatoria(boolean renderAnalgesiaPosoperatoria) {
        this.renderAnalgesiaPosoperatoria = renderAnalgesiaPosoperatoria;
    }

    public boolean isRenderAnalgesiaPosoperatoria() {
        return renderAnalgesiaPosoperatoria;
    }


    /**
     * @param viaSelect
     */
    public void setViaSelect(String viaSelect) {
        this.viaSelect = viaSelect;
    }

    /**
     * @return
     */
    public String getViaSelect() {
        return viaSelect;
    }

    /**
     * @param formulaClon
     */
    public void setFormulaClon(Chformulahos formulaClon) {
        this.formulaClon = formulaClon;
    }

    /**
     * @return
     */
    public Chformulahos getFormulaClon() {
        return formulaClon;
    }

    /**
     * @param formula
     */
    public void setFormula(Chformulahos formula) {
        this.formula = formula;
    }

    /**
     * @return
     */
    public Chformulahos getFormula() {
        return formula;
    }

    /**
     * @param dosisSelect
     */
    public void setDosisSelect(BigDecimal dosisSelect) {
        this.dosisSelect = dosisSelect;
    }

    /**
     * @return
     */
    public BigDecimal getDosisSelect() {
        return dosisSelect;
    }

    /**
     * @param tiempoTotal
     */
    public void setTiempoTotal(Integer tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    /**
     * @return
     */
    public Integer getTiempoTotal() {
        return tiempoTotal;
    }

    /**
     * @param frecuenciaAdm
     */
    public void setFrecuenciaAdm(Integer frecuenciaAdm) {
        this.frecuenciaAdm = frecuenciaAdm;
    }

    /**
     * @return
     */
    public Integer getFrecuenciaAdm() {
        return frecuenciaAdm;
    }

    /**
     * @param medicamentoSelect
     */
    public void setMedicamentoSelect(String medicamentoSelect) {
        this.medicamentoSelect = medicamentoSelect;
    }

    /**
     * @return
     */
    public String getMedicamentoSelect() {
        return medicamentoSelect;
    }

    /**
     * @param presentacionSelect
     */
    public void setPresentacionSelect(String presentacionSelect) {
        this.presentacionSelect = presentacionSelect;
    }

    /**
     * @return
     */
    public String getPresentacionSelect() {
        return presentacionSelect;
    }

    /**
     * @param otraVia
     */
    public void setOtraVia(String otraVia) {
        this.otraVia = otraVia;
    }

    /**
     * @return
     */
    public String getOtraVia() {
        return otraVia;
    }


    /**
     * @param lstUnidades
     */
    public void setLstUnidades(List lstUnidades) {
        this.lstUnidades = lstUnidades;
    }

    /**
     * @return
     */
    public List getLstUnidades() {
        if (lstUnidades.size() == 0) {
            ArrayList<Chunidades> lstUnidadesAux = null;
            try {
                lstUnidadesAux = 
                        (ArrayList<Chunidades>)this.serviceLocator.getClinicoService().getUnidadesDosis();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstUnidadesAux.isEmpty()) {

                Iterator it = lstUnidadesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstUnidades.add(new SelectItem(lstUnidadesAux.get(i).getHunccodigo(), 
                                                   lstUnidadesAux.get(i).getHuncdescripcio()));
                    i++;
                }
            }
        }

        return lstUnidades;
    }

    /**
     * @param lstHistorialPrescrpcion
     */
    public void setLstHistorialPrescrpcion(List<Chformulahos> lstHistorialPrescrpcion) {
        this.lstHistorialPrescrpcion = lstHistorialPrescrpcion;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstHistorialPrescrpcion() {
        return lstHistorialPrescrpcion;
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
            lstVia.add(new SelectItem("", "Seleccione una opci�n "));
            lstVia.add(new SelectItem("VO", "Via Oral "));
            lstVia.add(new SelectItem("IV", "V�a Intravenosa "));
            lstVia.add(new SelectItem("IM", "V�a Intramuscular"));
            lstVia.add(new SelectItem("VA", "V�a Intravaginal"));
            lstVia.add(new SelectItem("SC", "Subcut�nea"));
            lstVia.add(new SelectItem("OT", "Otra "));
        }
        return lstVia;
    }

    /**
     * @param lstUnidadTiempo
     */
    public void setLstUnidadTiempo(List lstUnidadTiempo) {
        this.lstUnidadTiempo = lstUnidadTiempo;
    }


    /**
     * @return
     */
    public List getLstUnidadTiempo() {
        if (lstUnidadTiempo.size() == 0) {
            lstUnidadTiempo.add(new SelectItem("", "Seleccione una opci�n "));
            lstUnidadTiempo.add(new SelectItem("H", "Horas "));
            lstUnidadTiempo.add(new SelectItem("M", "Minutos "));
            lstUnidadTiempo.add(new SelectItem("U", "Unica Dosis"));
        }
        return lstUnidadTiempo;
    }

    /**
     * @param dtFormula
     */
    public void setDtFormula(HtmlDataTable dtFormula) {
        this.dtFormula = dtFormula;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFormula() {
        return dtFormula;
    }


    /**
     * @param lstPrescripciones
     */
    public void setLstPrescripciones(List<Chformulahos> lstPrescripciones) {
        this.lstPrescripciones = lstPrescripciones;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstPrescripciones() {
        return lstPrescripciones;
    }


    /**
     * @param unidadSelect
     */
    public void setUnidadSelect(String unidadSelect) {
        this.unidadSelect = unidadSelect;
    }

    /**
     * @return
     */
    public String getUnidadSelect() {
        return unidadSelect;
    }

    /**
     * @param tiempoSelect
     */
    public void setTiempoSelect(String tiempoSelect) {
        this.tiempoSelect = tiempoSelect;
    }

    /**
     * @return
     */
    public String getTiempoSelect() {
        return tiempoSelect;
    }


    /**
     * @param msgMedicamento
     */
    public void setMsgMedicamento(String msgMedicamento) {
        this.msgMedicamento = msgMedicamento;
    }

    /**
     * @return
     */
    public String getMsgMedicamento() {
        return msgMedicamento;
    }


    /**
     * @param mostrarIntravenosa
     */
    public void setMostrarIntravenosa(boolean mostrarIntravenosa) {
        this.mostrarIntravenosa = mostrarIntravenosa;
    }

    /**
     * @return
     */
    public boolean isMostrarIntravenosa() {
        return mostrarIntravenosa;
    }

    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
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
     * @param lstHistorialExterna
     */
    public void setLstHistorialExterna(List<Chformulahos> lstHistorialExterna) {
        this.lstHistorialExterna = lstHistorialExterna;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstHistorialExterna() {
        return lstHistorialExterna;
    }

    /**
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
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
     * @param lstPrescripcionSuspender
     */
    public void setLstPrescripcionSuspender(List<Chformulahos> lstPrescripcionSuspender) {
        this.lstPrescripcionSuspender = lstPrescripcionSuspender;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstPrescripcionSuspender() {
        return lstPrescripcionSuspender;
    }

    /**
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    /**
     * @param renderProfilaxis
     */
    public void setRenderProfilaxis(boolean renderProfilaxis) {
        this.renderProfilaxis = renderProfilaxis;
    }

    /**
     * @return
     */
    public boolean isRenderProfilaxis() {
        return renderProfilaxis;
    }

    /**
     * @param lstProfilaxisAntibiotica
     */
    public void setLstProfilaxisAntibiotica(List<Chformulahos> lstProfilaxisAntibiotica) {
        this.lstProfilaxisAntibiotica = lstProfilaxisAntibiotica;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstProfilaxisAntibiotica() {
        return lstProfilaxisAntibiotica;
    }

    /**
     * @param lstProfilaxisAntitrombotica
     */
    public void setLstProfilaxisAntitrombotica(List<Chformulahos> lstProfilaxisAntitrombotica) {
        this.lstProfilaxisAntitrombotica = lstProfilaxisAntitrombotica;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstProfilaxisAntitrombotica() {
        return lstProfilaxisAntitrombotica;
    }

    /**
     * @param dtAntibiotica
     */
    public void setDtAntibiotica(HtmlDataTable dtAntibiotica) {
        this.dtAntibiotica = dtAntibiotica;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtAntibiotica() {
        return dtAntibiotica;
    }

    /**
     * @param dtAntitrombotica
     */
    public void setDtAntitrombotica(HtmlDataTable dtAntitrombotica) {
        this.dtAntitrombotica = dtAntitrombotica;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtAntitrombotica() {
        return dtAntitrombotica;
    }

    /**
     * @param renderAntibiotica
     */
    public void setRenderAntibiotica(boolean renderAntibiotica) {
        this.renderAntibiotica = renderAntibiotica;
    }

    /**
     * @return
     */
    public boolean isRenderAntibiotica() {
        return renderAntibiotica;
    }

    /**
     * @param renderAntitrombotica
     */
    public void setRenderAntitrombotica(boolean renderAntitrombotica) {
        this.renderAntitrombotica = renderAntitrombotica;
    }

    public boolean isRenderAntitrombotica() {
        return renderAntitrombotica;
    }


    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------  


    private void inicializarProfilaxisAntibiotico() {
        lstProfilaxisAntibiotica = new ArrayList<Chformulahos>();

        if(renderIve){
            Chformulahos formulaAux = new Chformulahos();
            formulaAux = new Chformulahos();
            formulaAux.setHfhcadosis(new BigDecimal(0));
            formulaAux.setHfhcformaadmin(null);
            //   formulaAux.setHfhnfrecuadmin(cantidadDosis);
            formulaAux.setHfhcmedicament(" Doxiciclina  ");
            formulaAux.setHfhcpresentaci("Tableta");
            formulaAux.setHfhcviadministr("VO");
            formulaAux.setHfhcviadminotr(null);
            formulaAux.setHfhcunidad("mg");
            formulaAux.setHfhnfrecuadmin(1);
            formulaAux.setHfhcadosis(new BigDecimal(100));
            formulaAux.setHfhnvolumburet(null);
            formulaAux.setHfhntiempburet(null);
            formulaAux.setHfhnvelocinfus(null);
            formulaAux.setWdesforma("tomar antes del procedimiento.");
            formulaAux.setHfhcunitiempo("U");
            formulaAux.setHfhcetapa(ETAPA_VIGENTE);
            formulaAux.setHfhlusuario(numeroUsuario);
            formulaAux.setHfhcoperador(userName());
            formulaAux.setHfhdfecregistr(new Date());
            lstProfilaxisAntibiotica.add(formulaAux);

            
        }else{
            Chformulahos formulaAux = new Chformulahos();
            formulaAux = new Chformulahos();
            formulaAux.setHfhcadosis(new BigDecimal(0));
            formulaAux.setHfhcformaadmin(null);
            //   formulaAux.setHfhnfrecuadmin(cantidadDosis);
            formulaAux.setHfhcmedicament(" Cefazolina ");
            formulaAux.setHfhcpresentaci("AMPOLLA");
            formulaAux.setHfhcviadministr("IV");
            formulaAux.setHfhcviadminotr(null);
            formulaAux.setHfhcunidad("g");
            formulaAux.setHfhcadosis(new BigDecimal(2));
            formulaAux.setHfhnvolumburet(null);
            formulaAux.setHfhntiempburet(null);
            formulaAux.setHfhnvelocinfus(null);
            formulaAux.setHfhcetapa(ETAPA_VIGENTE);
            formulaAux.setHfhlusuario(numeroUsuario);
            formulaAux.setHfhcoperador(userName());
            formulaAux.setHfhdfecregistr(new Date());
            lstProfilaxisAntibiotica.add(formulaAux);


            formulaAux = new Chformulahos();
            formulaAux.setHfhcadosis(new BigDecimal(0));
            formulaAux.setHfhcformaadmin(null);
            //   formulaAux.setHfhnfrecuadmin(cantidadDosis);
            formulaAux.setHfhcmedicament(" Clindamicina  ");
            formulaAux.setHfhcpresentaci("AMPOLLA");
            formulaAux.setHfhcviadministr("IV");
            formulaAux.setHfhcviadminotr(null);
            formulaAux.setHfhcunidad("mg");
            formulaAux.setHfhcadosis(new BigDecimal(600));
            formulaAux.setHfhnvolumburet(null);
            formulaAux.setHfhntiempburet(null);
            formulaAux.setHfhnvelocinfus(null);
            formulaAux.setHfhcetapa(ETAPA_VIGENTE);
            formulaAux.setHfhlusuario(numeroUsuario);
            formulaAux.setHfhcoperador(userName());
            formulaAux.setHfhdfecregistr(new Date());
            lstProfilaxisAntibiotica.add(formulaAux);
    
        }
        

    }

    private void inicializarProfilaxisAntitrombotico() {

        lstProfilaxisAntitrombotica = new ArrayList<Chformulahos>();


        Chformulahos formulaAux = new Chformulahos();
        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(0));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("Heparina no fraccionada, 5.000 UI SC cada 8 o 12 horas ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(5000));
        formulaAux.setHfhcviadministr("SC");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("ui");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstProfilaxisAntitrombotica.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(0));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("Heparina de bajo peso molecular (enoxaparina) ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcviadministr("SC");
        formulaAux.setHfhcadosis(new BigDecimal(20));
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstProfilaxisAntitrombotica.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(0));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("Heparina de bajo peso molecular (enoxaparina) ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcviadministr("SC");
        formulaAux.setHfhcadosis(new BigDecimal(40));
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstProfilaxisAntitrombotica.add(formulaAux);
    }


    private void inicializarAnalgesiaPosoperatoria() {

        lstAnalgesiaPosoperatoria = new ArrayList<Chformulahos>();


        Chformulahos formulaAux = new Chformulahos();
        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("HIOSCINA N-BUTIL BROMURO 20 mg/mL SOLUCION INYECTABLE	 ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(20));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("MEPERIDINA CLORHIDRATO 100 mg/2 mL SOLUCION INYECTABLE	");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(30));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("DICLOFENACO SODICO 75 mg/3 mL SOLUCION INYECTABLE	");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(75));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("DICLOFENACO SODICO 75 mg/3 mL SOLUCION INYECTABLE ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(75));
        formulaAux.setHfhcviadministr("IM");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux = new Chformulahos();
        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcformaadmin(null);

        formulaAux.setHfhcmedicament("DEXAMETASONA  4MG/ML SOLUCI�N INYECTABLE ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(4));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);

        formulaAux = new Chformulahos();

        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcformaadmin(null);
        formulaAux.setHfhcmedicament("DEXAMETASONA  4MG/ML SOLUCI�N INYECTABLE ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(8));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);

        formulaAux = new Chformulahos();
        formulaAux.setHfhcmedicament("DIPIRONA 1 GRAMO/2ML, SOLUCI�N INYECTABLE ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(1));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("g");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);

        formulaAux = new Chformulahos();
        formulaAux.setHfhcmedicament("DIPIRONA 1 GRAMO/2ML, SOLUCI�N INYECTABLE ");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(2));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("g");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);


        formulaAux = new Chformulahos();
        formulaAux.setHfhcmedicament("MORFINA CLORHIDRATO 10 MG/ML");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(3));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);

        formulaAux = new Chformulahos();
        formulaAux.setHfhcmedicament("MORFINA CLORHIDRATO 10 MG/ML");
        formulaAux.setHfhcpresentaci("AMPOLLA");
        formulaAux.setHfhcadosis(new BigDecimal(4));
        formulaAux.setHfhcviadministr("IV");
        formulaAux.setHfhcviadminotr(null);
        formulaAux.setHfhcunidad("mg");
        formulaAux.setHfhnvolumburet(null);
        formulaAux.setHfhntiempburet(null);
        formulaAux.setHfhnvelocinfus(null);
        formulaAux.setHfhcetapa(ETAPA_VIGENTE);
        formulaAux.setHfhlusuario(numeroUsuario);
        formulaAux.setHfhcoperador(userName());
        formulaAux.setHfhdfecregistr(new Date());
        lstAnalgesiaPosoperatoria.add(formulaAux);


    }


    public void agregarAntibiotica() {
        Chformulahos formulaSelect = null;
        formulaSelect = (Chformulahos)this.dtAntibiotica.getRowData();
        this.lstPrescripciones.add(formulaSelect);
        lstProfilaxisAntibiotica.remove(formulaSelect);
        FacesUtils.addInfoMessage(MSG_ADICION_PROFILAXIS);
    }


    public void agregarAntitrombotica() {
        Chformulahos formulaSelect = null;
        formulaSelect = (Chformulahos)this.dtAntitrombotica.getRowData();
        this.lstPrescripciones.add(formulaSelect);
        lstProfilaxisAntitrombotica.remove(formulaSelect);
        FacesUtils.addInfoMessage(MSG_ADICION_PROFILAXIS);
    }

    public void agregarAnalgesia() {
        Chformulahos formulaSelect = null;
        formulaSelect = (Chformulahos)this.dtAnalgesia.getRowData();
        this.lstPrescripciones.add(formulaSelect);
        lstAnalgesiaPosoperatoria.remove(formulaSelect);
        FacesUtils.addInfoMessage(MSG_ADICION_PROFILAXIS);
    }


    public void agregarPrescripcion() {
        boolean wexito;
        wexito = true;
        String url = "";
        url = 
"body:formFormularMedicamentos:panelTabPrescripcionHospitalizacion:";

        if (medicamentoSelect == null || medicamentoSelect.equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "itMedicamento", 
                                       MSG_CAMPO_OBLIGATORIO);
        }


        if (presentacionSelect == null || presentacionSelect.equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "itPresentacion", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (dosisSelect == null) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "itDosis", MSG_CAMPO_OBLIGATORIO);
        }

        if (tiempoTotal == null) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "itTottiempo", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (unidadSelect == null || unidadSelect.equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "mnuUnidades", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (tiempoSelect == null || tiempoSelect.equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "mnuTiempo", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (frecuenciaAdm == null) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "itFrecuencia", 
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (viaSelect == null || viaSelect.equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage(url + "mnuVia", MSG_CAMPO_OBLIGATORIO);
        }

        if (viaSelect != null) {
            if (viaSelect.equals("IV")) {
                if (recoIntravenosa == null || recoIntravenosa.equals("")) {
                    wexito = false;
                    FacesUtils.addErrorMessage(url + "itRecomendacion", 
                                               MSG_CAMPO_OBLIGATORIO);
                }
            }
        }


        if (wexito) {
            if (frecuenciaAdm != null && frecuenciaAdm.intValue() > 0) {
                Integer cantidadDosis = 0;
                cantidadDosis = tiempoTotal / frecuenciaAdm;
                for (int i = 0; i < frecuenciaAdm; i++) {

                    formula = new Chformulahos();
                    formula.setHfhcadosis(dosisSelect);
                    formula.setHfhntiempotot(tiempoTotal);
                    formula.setHfhnfrecuadmin(cantidadDosis);
                    formula.setHfhcmedicament(medicamentoSelect);
                    formula.setHfhcpresentaci(presentacionSelect);
                    formula.setHfhcviadministr(viaSelect);
                    formula.setHfhcviadminotr(otraVia);
                    formula.setHfhdfecregistr(new Date());
                    formula.setHfhcunidad(unidadSelect);
                    formula.setHfhcunitiempo(tiempoSelect);
                    formula.setHfhcoperador(userName());
                    formula.setHfhcetapa(ETAPA_VIGENTE);
                    formula.setHfhlusuario(numeroUsuario);
                    formula.setHfhcviaintreco(recoIntravenosa);
                    formula.setHfhnconsmedic(i + 1);
                    formula.setHfhccodsap(codsap);
                    lstPrescripciones.add(formula);
                }


            }


            dosisSelect = null;
            tiempoTotal = null;
            frecuenciaAdm = null;
            medicamentoSelect = "";
            presentacionSelect = "";
            viaSelect = "";
            otraVia = "";
            mostrarIntravenosa = false;
            recoIntravenosa = null;
            unidadSelect = null;
            tiempoSelect = null;
        }

    }

    public void aceptarMedicamento() {
        BuscadorMedicamentoBean medicamentoAux = 
            (BuscadorMedicamentoBean)FacesUtils.getManagedBean("buscadorMedicamentoBean");
        if (medicamentoAux != null && 
            medicamentoAux.getMedicamentoSelect() != null) {
            setMedicamentoSelect(medicamentoAux.getMedicamentoSelect().getHvpcprincactiv() + 
                                   " " + 
                                   medicamentoAux.getMedicamentoSelect().getHvpcconcentrac() + 
                                   " " + 
                                   medicamentoAux.getMedicamentoSelect().getHvpcformafarma());

           
            presentacionSelect = medicamentoAux.getMedicamentoSelect().getHvpcformafarma();
            unidadSelect = medicamentoAux.getMedicamentoSelect().getHvpcunidmedi();
            codsap = medicamentoAux.getMedicamentoSelect().getHvpccodisap();
            deshabilitarMedicamento = true;

        }
        selectedIndex = ACTIVAR_FORMULA_MEDICA;
        renderBuscador = false;
        FacesUtils.resetManagedBean("buscadorMedicamentoBean");
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderAntitrombotica(ValueChangeEvent valueChangeEvent) {
        setRenderAntitrombotica((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setRenderAnalgesia(ValueChangeEvent valueChangeEvent) {
        setRenderAnalgesia((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderAntibiotica(ValueChangeEvent valueChangeEvent) {
        setRenderAntibiotica((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void eliminarFormula() {
        this.formulaClon = (Chformulahos)this.dtFormula.getRowData();
        this.lstPrescripciones.remove(formulaClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }


    /**
     * @param valueChangeEvent
     */
    public void setViaSelect(ValueChangeEvent valueChangeEvent) {
        setViaSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeViaAdministracion() {
        if (viaSelect != null && viaSelect.equals("IV")) {
            mostrarIntravenosa = true;
        } else {
            recoIntravenosa = "";
            mostrarIntravenosa = false;
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setRecoIntravenosa(ValueChangeEvent valueChangeEvent) {
        setRecoIntravenosa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public void generarFormula() {

        lstPrescripcionSuspender = new ArrayList<Chformulahos>();
        if (lstHistorialPrescrpcion != null && 
            !lstHistorialPrescrpcion.isEmpty()) {
            for (Chformulahos medicsusp: lstHistorialPrescrpcion) {
                if (medicsusp.isHfhbsuspender()) {
                    medicsusp.setHfhcoperamodif(userName());
                    lstPrescripcionSuspender.add(medicsusp);
                }
            }
        }


        if (lstHistorialExterna != null && !lstHistorialExterna.isEmpty()) {
            for (Chformulahos medicsusp: lstHistorialExterna) {
                if (medicsusp.isHfhbsuspender()) {
                    medicsusp.setHfhcoperamodif(userName());
                    lstPrescripcionSuspender.add(medicsusp);
                }
            }
        }
        if (lstPrescripciones != null && !lstPrescripciones.isEmpty()) {
            for (Chformulahos auxFormula: lstPrescripciones) {
                if (conciliacionMedicamentosa != null) {
                    auxFormula.setHfhcconcimedi(conciliacionMedicamentosa);
                }
            }

        }

        try {
            this.serviceLocator.getCirugiaService().saveListFormulaMedicamentosCirugia(lstPrescripciones, 
                                                                                       numeroCirugia, 
                                                                                       tipoServicio, 
                                                                                       consecutivo, 
                                                                                       lstPrescripcionSuspender);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }
    }


    public void setLstAnalgesiaPosoperatoria(List<Chformulahos> lstAnalgesiaPosoperatoria) {
        this.lstAnalgesiaPosoperatoria = lstAnalgesiaPosoperatoria;
    }

    public List<Chformulahos> getLstAnalgesiaPosoperatoria() {
        return lstAnalgesiaPosoperatoria;
    }

    public void setRenderAnalgesia(boolean renderAnalgesia) {
        this.renderAnalgesia = renderAnalgesia;
    }

    public boolean isRenderAnalgesia() {
        return renderAnalgesia;
    }


    public void setDtAnalgesia(HtmlDataTable dtAnalgesia) {
        this.dtAnalgesia = dtAnalgesia;
    }

    public HtmlDataTable getDtAnalgesia() {
        return dtAnalgesia;
    }

    public void setConciliacionMedicamentosa(String conciliacionMedicamentosa) {
        this.conciliacionMedicamentosa = conciliacionMedicamentosa;
    }

    public String getConciliacionMedicamentosa() {
        return conciliacionMedicamentosa;
    }

    /**
     * @param listOpciones
     */
    public void setListOpciones(List<SelectItem> listOpciones) {
        this.listOpciones = listOpciones;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOpciones() {
        if (listOpciones == null || listOpciones.isEmpty()) {
            listOpciones = new ArrayList<SelectItem>();
            listOpciones.add(new SelectItem("S", "SI"));
            listOpciones.add(new SelectItem("N", "NO"));
        }
        return listOpciones;
    }

    public void confirmaConciliacion() {
    }

    public void setConciliacionMedicamentosa(ValueChangeEvent valueChangeEvent) {
        setConciliacionMedicamentosa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderIve(boolean renderIve) {
        this.renderIve = renderIve;
    }

    public boolean isRenderIve() {
        return renderIve;
    }


    public void setCodsap(String codsap) {
        this.codsap = codsap;
    }

    public String getCodsap() {
        return codsap;
    }
}
