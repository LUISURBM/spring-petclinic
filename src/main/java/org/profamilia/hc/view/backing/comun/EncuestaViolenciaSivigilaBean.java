//=======================================================================
// ARCHIVO EncuestaViolenciaSivigilaBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la encuesta de violencia.
//=======================================================================

package org.profamilia.hc.view.backing.comun;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.ChviolenciaPK;
import org.profamilia.hc.model.dto.Chvsolsivig;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE EncuestaViolenciaSivigilaBean
//=======================================================================
public class EncuestaViolenciaSivigilaBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Integer tipoHistoria;

    private Long numeroConsulta;

    private Long numeroUsuario;

    private String nextAction;

    private String menuBean;

    private String tipoServicio;

    private Chvsolsivig violencia;

    private List lstModalidadViolencia;

    private List<String> lstModalidadSelect;

    private List lstActividadVicitima;

    private List lstOpciones;

    private List lstParentesco;

    private List lstNoFamiliar;

    private List lstGrupoPerpetuador;

    private List lstMecanismo;

    private List<String> lstSitioSelect;

    private List lstSitioQuemadura;

    private List lstGradoQuemadura;

    private List lstExtension;

    private List lstEscenario;

    private List lstSexo;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHora;

    /** Almacena la lista de las horas habiles para una consulta*/
    private List<SelectItem> listHoraDuracion;

    /** Almacena la lista de los minutos habiles para una consulta*/
    private List<SelectItem> lstMinutos;

    private Chusuario usuario;

    private int index;
    private List<Object[]> lstSivigila;
    private boolean generoReporte;
    private static int NUMERO_COPIAS = 1;


    String NOMBRES_APELLIDOS;
    String TIPOID;
    Long NUMERO_DOCUMENTO;
    String MODVIO1;
    String MODVIO2;
    String MODVIO3;
    String MODVIO4;
    String MODVIO5;
    String MODVIO6;
    String MODVIO7;
    String MODVIO8;
    String MODVIO9;
    String MODVI10;
    String DATVICACT1;
    String DATVICACT2;
    String DATVICACT3;
    String DATVICACT4;
    String DATVICACT5;
    String DATVICACT6;
    String DATVICACT7;
    String DATVICACT8;
    String POBLACLGTBS;
    String POBLACLGTBN;
    String CONSUMESPAS;
    String CONSUMESPAN;
    String TRABAJOSEXS;
    String TRABAJOSEXN;
    String DESMOVILIZS;
    String DESMOVILIZN;
    String CAMPESINOS;
    String CAMPESINON;
    String MUJERCABFAS;
    String MUJERCABFAN;
    String AMADECASAS;
    String AMADECASAN;
    String NNASNBFS;
    String NNASNBFN;
    String PRIVALIBERS;
    String PRIVALIBERN;
    String VICCONARMAS;
    String VICCONARMAN;
    String OTRO3S;
    String OTRO3N;
    String REINCIDENCS;
    String REINCIDENCN;
    String ALCOHOLVICS;
    String ALCOHOLVICN;
    Integer EDADAGRE;
    String SEXOAGREH;
    String SEXOAGREM;
    String SEXOAGRES;
    String PARENTVICTES;
    String PARENTVICTCP;
    String PARENTVICTNO;
    String PARENTVICTAM;
    String PARENTVICTEXE;
    String PARENTVICTEXC;
    String PARENTVICTEXN;
    String PARENTVICTEXA;
    String PARENTVICTPA;
    String PARENTVICTMA;
    String PARENTVICTHI;
    String PARENTVICTENC;
    String PARENTVICTHER;
    String PARENTVICTABU;
    String PARENTVICTPAD;
    String PARENTVICTMAD;
    String PARENTVICTTIO;
    String PARENTVICTPRI;
    String PARENTVICTCUN;
    String PARENTVICTSUE;
    String PARENTVICTOTR;
    String CONVCAGRESS;
    String CONVCAGRESN;
    String AGRENOFAMIPRO;
    String AGRENOFAMIAMI;
    String AGRENOFAMICDT;
    String AGRENOFAMICDE;
    String AGRENOFAMIDES;
    String AGRENOFAMIVEC;
    String AGRENOFAMICON;
    String AGRENOFAMISIN;
    String AGRENOFAMIOTR;
    String AGRENOFAMIJEF;
    String AGRENOFAMISAC;
    String AGRENOFAMISPU;
    String GRUPERVIOLEJE;
    String GRUPERVIOLFAE;
    String GRUPERVIOLARM;
    String GRUPERVIOLPOL;
    String GRUPERVIOLNAR;
    String GRUPERVIOLBCR;
    String GRUPERVIOLPAN;
    String GRUPERVIOLAUT;
    String GRUPERVIOLGUE;
    String GRUPERVIOLNSA;
    String MECANUTILIAES;
    String MECANUTILICAI;
    String MECANUTILICON;
    String MECANUTILICOT;
    String MECANUTILIPAF;
    String MECANUTILIQPF;
    String MECANUTILIQPA;
    String MECANUTILIQCL;
    String MECANUTILIOTR;
    String SITIOANATOCAR;
    String SITIOANATOCUE;
    String SITIOANATOMAN;
    String SITIOANATOPIE;
    String SITIOANATOPLI;
    String SITIOANATOGEN;
    String SITIOANATOTRO;
    String SITIOANATOMSU;
    String SITIOANATOMIN;
    String GRADO1;
    String GRADO2;
    String GRADO3;
    String EXTENSION1;
    String EXTENSION2;
    String EXTENSION3;
    String FECHAECHO;
    String HORAECHO;
    String MINUECHO;
    String ESCENARIOVP;
    String ESCENARIOVI;
    String ESCENARIOCC;
    String ESCENARIOOE;
    String ESCENARIOOT;
    String ESCENARIOET;
    String ESCENARIOEC;
    String ESCENARIOLE;
    String MARCOCOARS;
    String MARCOCOARN;
    String PROFILAVIHS;
    String PROFILAVIHN;
    String PROFILHEPBS;
    String PROFILHEPBN;
    String OTRASPROFIS;
    String OTRASPROFIN;
    String ANTICOEMERS;
    String ANTICOEMERN;
    String ORIENTAIVES;
    String ORIENTAIVEN;
    String SALUDMENTAS;
    String SALUDMENTAN;
    String REMAPROTECS;
    String REMAPROTECN;
    String DENUNCIAS;
    String DENUNCIAN;
    String RECOEVIMEDS;
    String RECOEVIMEDN;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public EncuestaViolenciaSivigilaBean() {
    }

    public void init() {

        inicializarEncuesta();
        generoReporte = false;

    }

    // ACTIONS

    public void inicializarEncuesta() {

        generoReporte = false;
        if (numeroConsulta != null) {
            try {
                violencia = 
                        this.getServiceLocator().getClinicoService().getViolenciaSivigila(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }


        if (lstModalidadSelect == null || lstModalidadSelect.isEmpty()) {
            lstModalidadSelect = new ArrayList<String>();
        }

        if (lstSitioSelect == null || lstSitioSelect.isEmpty()) {
            lstSitioSelect = new ArrayList<String>();
        }

        if (violencia == null) {
            violencia = new Chvsolsivig();
        } else {
            if (violencia.getHvscmodalviole() != null && 
                !violencia.getHvscmodalviole().equals("")) {

                StringTokenizer stk = 
                    new StringTokenizer(violencia.getHvscmodalviole(), ",");

                while (stk.hasMoreTokens()) {
                    String modalidadAux = stk.nextToken();


                    if (lstModalidadSelect != null) {
                        lstModalidadSelect.add(modalidadAux);
                    }

                }

            }


            if (violencia.getHvscsitioanato() != null && 
                !violencia.getHvscsitioanato().equals("")) {

                StringTokenizer stk = 
                    new StringTokenizer(violencia.getHvscsitioanato(), ",");

                while (stk.hasMoreTokens()) {
                    String sitioAux = stk.nextToken();


                    if (lstSitioSelect != null) {
                        lstSitioSelect.add(sitioAux);
                    }

                }

            }

        }


    }

    public void changeOtro() {

    }

    public void changeRemision() {


    }

    public void changeViolencia() {

    }


    public void changeDeseaHablar() {

    }


    public void changeSufreRiesgo() {


    }


    // ACCESSORS


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }


    public void setViolencia(Chvsolsivig violencia) {
        this.violencia = violencia;
    }

    public Chvsolsivig getViolencia() {
        return violencia;
    }

    public void setLstModalidadViolencia(List lstModalidadViolencia) {
        this.lstModalidadViolencia = lstModalidadViolencia;
    }

    public List getLstModalidadViolencia() {
        if (lstModalidadViolencia == null || lstModalidadViolencia.isEmpty()) {
            lstModalidadViolencia = new ArrayList();
            lstModalidadViolencia.add(new SelectItem("VF", 
                                                     " Violencia Fisica"));
            lstModalidadViolencia.add(new SelectItem("VP", 
                                                     " Violencia Psicologica"));
            lstModalidadViolencia.add(new SelectItem("NA", 
                                                     "Negligencia y abandono"));
            lstModalidadViolencia.add(new SelectItem("ABS", "Abuso Sexual"));
            lstModalidadViolencia.add(new SelectItem("ACS", "Acoso Sexual"));
            lstModalidadViolencia.add(new SelectItem("VI", "Violaci�n"));
            lstModalidadViolencia.add(new SelectItem("ESN", 
                                                     "Explotaci�n Sexual comercial de ni�os y adolecentes"));
            lstModalidadViolencia.add(new SelectItem("TES", 
                                                     "Trata de personas para explotacion sexual"));
            lstModalidadViolencia.add(new SelectItem("VSC", 
                                                     "Violencia sexual en conflicto armado"));
            lstModalidadViolencia.add(new SelectItem("ASV", 
                                                     "Actos Sexuales Violentos"));

        }

        return lstModalidadViolencia;
    }

    public void setLstModalidadSelect(List<String> lstModalidadSelect) {
        this.lstModalidadSelect = lstModalidadSelect;
    }

    public List<String> getLstModalidadSelect() {
        return lstModalidadSelect;
    }

    public void setLstActividadVicitima(List lstActividadVicitima) {
        this.lstActividadVicitima = lstActividadVicitima;
    }

    public List getLstActividadVicitima() {
        if (lstActividadVicitima == null || lstActividadVicitima.isEmpty()) {
            lstActividadVicitima = new ArrayList();
            lstActividadVicitima.add(new SelectItem("", "Seleccione"));
            lstActividadVicitima.add(new SelectItem("RE", "Reciclador"));
            lstActividadVicitima.add(new SelectItem("LC", "Lideres Civicos "));
            lstActividadVicitima.add(new SelectItem("MA", "Maestro"));
            lstActividadVicitima.add(new SelectItem("SP", 
                                                    "Servidor Publico "));
            lstActividadVicitima.add(new SelectItem("FP", "Fuerza Publica"));
            lstActividadVicitima.add(new SelectItem("ES", "Estudiante"));
            lstActividadVicitima.add(new SelectItem("TD", 
                                                    "Trabajadora Domestica"));
            lstActividadVicitima.add(new SelectItem("OT", "Otro"));

        }

        return lstActividadVicitima;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No "));


        }

        return lstOpciones;
    }

    public void setLstParentesco(List lstParentesco) {
        this.lstParentesco = lstParentesco;
    }

    public List getLstParentesco() {
        if (lstParentesco == null || lstParentesco.isEmpty()) {
            lstParentesco = new ArrayList();
            lstParentesco.add(new SelectItem("", "Seleccione"));
            lstParentesco.add(new SelectItem("ES", "Esposo (a)"));
            lstParentesco.add(new SelectItem("CP", 
                                             "Compa�ero (a) Permanente "));
            lstParentesco.add(new SelectItem("NO", "Novio (a) "));
            lstParentesco.add(new SelectItem("AM", "Amante "));
            lstParentesco.add(new SelectItem("EXE", "Ex- Esposo(a) "));
            lstParentesco.add(new SelectItem("EXC", 
                                             "Ex- compa�ero permanente "));
            lstParentesco.add(new SelectItem("EXN", "Ex- novio (a) "));
            lstParentesco.add(new SelectItem("EXA", "Ex- Amante "));
            lstParentesco.add(new SelectItem("PA", "Padre "));
            lstParentesco.add(new SelectItem("MA", "Madre "));
            lstParentesco.add(new SelectItem("HI", "Hijo "));
            lstParentesco.add(new SelectItem("ENC", 
                                             "Encargado (a) del NNA/Adulto Mayor"));
            lstParentesco.add(new SelectItem("HER", " Hermano (a)"));
            lstParentesco.add(new SelectItem("ABU", " Abuelo (a)"));
            lstParentesco.add(new SelectItem("PAD", " Padrastro"));
            lstParentesco.add(new SelectItem("MAD", " Madastra"));
            lstParentesco.add(new SelectItem("TIO", " Tio (a)"));
            lstParentesco.add(new SelectItem("PRI", " Primo (a)"));
            lstParentesco.add(new SelectItem("CUN", " Cu�ado (a) "));
            lstParentesco.add(new SelectItem("SUE", " Suegro (a) "));
            lstParentesco.add(new SelectItem("OTR", " Otros  "));

        }

        return lstParentesco;
    }

    public void setLstNoFamiliar(List lstNoFamiliar) {
        this.lstNoFamiliar = lstNoFamiliar;
    }

    public List getLstNoFamiliar() {
        if (lstNoFamiliar == null || lstNoFamiliar.isEmpty()) {
            lstNoFamiliar = new ArrayList();
            lstNoFamiliar.add(new SelectItem("", "Seleccione"));
            lstNoFamiliar.add(new SelectItem("PRO", "Profesor"));
            lstNoFamiliar.add(new SelectItem("AMI", "Amigo (a) "));
            lstNoFamiliar.add(new SelectItem("CDT", 
                                             "Compa�ero (a) de trabajo "));
            lstNoFamiliar.add(new SelectItem("CDE", 
                                             "Compa�ero (a) de Estudio "));
            lstNoFamiliar.add(new SelectItem("DES", "Desconocido(a) "));
            lstNoFamiliar.add(new SelectItem("VEC", "Vecino(a) "));
            lstNoFamiliar.add(new SelectItem("CON", 
                                             "Conocido(a) sin ningun trato "));
            lstNoFamiliar.add(new SelectItem("SIN", "Sin Informaci�n "));
            lstNoFamiliar.add(new SelectItem("OTR", "Otro "));
            lstNoFamiliar.add(new SelectItem("JEF", "Jefe "));
            lstNoFamiliar.add(new SelectItem("SAC", "Sacerdote/Pastor "));
            lstNoFamiliar.add(new SelectItem("SPU", "Servidor Publico "));


        }

        return lstNoFamiliar;
    }

    public void setLstGrupoPerpetuador(List lstGrupoPerpetuador) {
        this.lstGrupoPerpetuador = lstGrupoPerpetuador;
    }

    public List getLstGrupoPerpetuador() {
        if (lstGrupoPerpetuador == null || lstGrupoPerpetuador.isEmpty()) {
            lstGrupoPerpetuador = new ArrayList();
            lstGrupoPerpetuador.add(new SelectItem("", "Seleccione"));
            lstGrupoPerpetuador.add(new SelectItem("EJE", "Ejercito"));
            lstGrupoPerpetuador.add(new SelectItem("FAE", "Fuerza Aerea "));
            lstGrupoPerpetuador.add(new SelectItem("ARM", "Armada "));
            lstGrupoPerpetuador.add(new SelectItem("POL", "Policia "));
            lstGrupoPerpetuador.add(new SelectItem("NAR", "Narcotrafico "));
            lstGrupoPerpetuador.add(new SelectItem("BCR", 
                                                   "Bandas Criminales "));
            lstGrupoPerpetuador.add(new SelectItem("PAN", "Pandillas "));
            lstGrupoPerpetuador.add(new SelectItem("AUT", 
                                                   "Paramilitar o Autodefensas "));
            lstGrupoPerpetuador.add(new SelectItem("GUE", "Guerrillero (a) "));
            lstGrupoPerpetuador.add(new SelectItem("NSA", "No Sabe) "));

        }

        return lstGrupoPerpetuador;
    }

    /*  o 1.
o 2.
o 3.
o 4.
o 11.
o 12.
o13.
o14. */

    public void setLstMecanismo(List lstMecanismo) {
        this.lstMecanismo = lstMecanismo;
    }

    public List getLstMecanismo() {
        if (lstMecanismo == null || lstMecanismo.isEmpty()) {
            lstMecanismo = new ArrayList();
            lstMecanismo.add(new SelectItem("", "Seleccione"));
            lstMecanismo.add(new SelectItem("AES", 
                                            "Ahorcamiento / estrangulamiento / sofocaci�n"));
            lstMecanismo.add(new SelectItem("CAI", "Ca�das"));
            lstMecanismo.add(new SelectItem("CON", 
                                            "Contundente / cortocondundente"));
            lstMecanismo.add(new SelectItem("COT", 
                                            "Cortante / cortopunzante / Punzante"));
            lstMecanismo.add(new SelectItem("PAF", "Proyectil arma fuego"));
            lstMecanismo.add(new SelectItem("QPF", 
                                            "Quemadura por fuego o llama"));
            lstMecanismo.add(new SelectItem("QPA", 
                                            "Quemadura por �cido, �lcalis, o sustancias corrosivas"));
            lstMecanismo.add(new SelectItem("QCL", 
                                            "Quemadura con l�quido hirviente"));
            lstMecanismo.add(new SelectItem("OTR", "Otros mecanismos"));
        }
        return lstMecanismo;
    }

    public void setLstSitioQuemadura(List lstSitioQuemadura) {
        this.lstSitioQuemadura = lstSitioQuemadura;
    }


    public List getLstSitioQuemadura() {
        if (lstSitioQuemadura == null || lstSitioQuemadura.isEmpty()) {
            lstSitioQuemadura = new ArrayList();
            lstSitioQuemadura.add(new SelectItem("CAR", "Cara"));
            lstSitioQuemadura.add(new SelectItem("CUE", "Cuello"));
            lstSitioQuemadura.add(new SelectItem("MAN", "Mano"));
            lstSitioQuemadura.add(new SelectItem("PIE", "P�es"));
            lstSitioQuemadura.add(new SelectItem("PLI", "Pliegues"));
            lstSitioQuemadura.add(new SelectItem("GEN", "Genitales"));
            lstSitioQuemadura.add(new SelectItem("TRO", "Tronco"));
            lstSitioQuemadura.add(new SelectItem("MSU", "Miembro superior"));
            lstSitioQuemadura.add(new SelectItem("MIN", "Miembro inferior"));

        }
        return lstSitioQuemadura;
    }

    public void setLstGradoQuemadura(List lstGradoQuemadura) {
        this.lstGradoQuemadura = lstGradoQuemadura;
    }

    /*
     *o1.
o2
o3.
     * */


    public List getLstGradoQuemadura() {
        if (lstGradoQuemadura == null || lstGradoQuemadura.isEmpty()) {
            lstGradoQuemadura = new ArrayList();
            lstGradoQuemadura.add(new SelectItem(1, "Primer grado"));
            lstGradoQuemadura.add(new SelectItem(2, "Segundo grado"));
            lstGradoQuemadura.add(new SelectItem(3, "Tercer grado"));


        }
        return lstGradoQuemadura;
    }

    public void setLstExtension(List lstExtension) {
        this.lstExtension = lstExtension;
    }

    public List getLstExtension() {
        if (lstExtension == null || lstExtension.isEmpty()) {
            lstExtension = new ArrayList();
            lstExtension.add(new SelectItem(1, "Menor o igual al 5%"));
            lstExtension.add(new SelectItem(2, "Del 6% al 14%"));
            lstExtension.add(new SelectItem(3, "Mayor o igual al 15%"));


        }
        return lstExtension;
    }

    public void setLstEscenario(List lstEscenario) {
        this.lstEscenario = lstEscenario;
    }


    public List getLstEscenario() {
        if (lstEscenario == null || lstEscenario.isEmpty()) {
            lstEscenario = new ArrayList();
            lstEscenario.add(new SelectItem("", "Seleccione"));
            lstEscenario.add(new SelectItem("VP", "V�a p�blica"));
            lstEscenario.add(new SelectItem("VI", "Vivienda"));
            lstEscenario.add(new SelectItem("CC", "Centro educativos"));
            lstEscenario.add(new SelectItem("OE", 
                                            "Oficina o edificio de oficinas"));
            lstEscenario.add(new SelectItem("OT", "Otro"));
            lstEscenario.add(new SelectItem("ET", 
                                            "Espacios terrrestres al aire libre (Bosque, potreros, etc)"));
            lstEscenario.add(new SelectItem("EC", 
                                            "Establecimiento comercial (tienda, centro comercial, etc)"));
            lstEscenario.add(new SelectItem("LE", 
                                            "Lugares de esparcimiento con expendido de alcohol)"));

        }
        return lstEscenario;
    }

    public void setLstSexo(List lstSexo) {
        this.lstSexo = lstSexo;
    }

    public List getLstSexo() {
        if (lstSexo == null || lstSexo.isEmpty()) {
            lstSexo = new ArrayList();
            lstSexo.add(new SelectItem("H", "Hombre"));
            lstSexo.add(new SelectItem("M", "Mujer"));
            lstSexo.add(new SelectItem("S", "Sin Informaci�n"));


        }
        return lstSexo;
    }


    public void setLstSitioSelect(List<String> lstSitioSelect) {
        this.lstSitioSelect = lstSitioSelect;
    }

    public List<String> getLstSitioSelect() {
        return lstSitioSelect;
    }


    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }


    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List<SelectItem> getListHora() {
        if (listHora == null || listHora.isEmpty()) {
            listHora = new ArrayList<SelectItem>();
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
        if (lstMinutos == null || !lstMinutos.isEmpty()) {
            lstMinutos = new ArrayList<SelectItem>();
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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }


    public boolean esValido() {
        boolean esValido = false;
        Chvsolsivig violenciaAux = null;
        if (numeroConsulta != null) {
            try {
                violenciaAux = 
                        this.getServiceLocator().getClinicoService().getViolenciaSivigila(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
        if (violenciaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public void guardarViolencia() {


        violencia.getId().setHvslconsulta(numeroConsulta);
        violencia.getId().setHvslnumerusuar(numeroUsuario);
        violencia.setHvscoperador(userName());
        violencia.setHvsdfechregis(new Date());

        if (lstModalidadSelect != null && !lstModalidadSelect.isEmpty()) {
            String modalidadAUx = "";

            for (String modalidad: lstModalidadSelect) {

                modalidadAUx = modalidadAUx + modalidad + ",";

            }

            modalidadAUx = 
                    modalidadAUx.substring(0, modalidadAUx.length() - 1);

            violencia.setHvscmodalviole(modalidadAUx);
        }


        if (lstSitioSelect != null && !lstSitioSelect.isEmpty()) {
            String sitioAUx = "";

            for (String sitio: lstSitioSelect) {

                sitioAUx = sitioAUx + sitio + ",";

            }

            sitioAUx = sitioAUx.substring(0, sitioAUx.length() - 1);

            violencia.setHvscsitioanato(sitioAUx);
        }


        try {
            this.serviceLocator.getClinicoService().saveViolenciaSivigila(violencia);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);


        } catch (ModelException e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), 
                                       IMsg.MSG_NO_ADICION);
            e.printStackTrace();

        }
        generarReporte();
    }

    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        resetDatos();
        obtenerDatos();

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRES_APELLIDOS"))
            value = NOMBRES_APELLIDOS;
        else if (fieldName.equals("TIPOID"))
            value = TIPOID;
        else if (fieldName.equals("NUMERO_DOCUMENTO"))
            value = NUMERO_DOCUMENTO;
        else if (fieldName.equals("MODVIO1"))
            value = MODVIO1;
        else if (fieldName.equals("MODVIO2"))
            value = MODVIO2;
        else if (fieldName.equals("MODVIO3"))
            value = MODVIO3;
        else if (fieldName.equals("MODVIO4"))
            value = MODVIO4;
        else if (fieldName.equals("MODVIO5"))
            value = MODVIO5;
        else if (fieldName.equals("MODVIO6"))
            value = MODVIO6;
        else if (fieldName.equals("MODVIO7"))
            value = MODVIO7;
        else if (fieldName.equals("MODVIO8"))
            value = MODVIO8;
        else if (fieldName.equals("MODVIO9"))
            value = MODVIO9;
        else if (fieldName.equals("MODVI10"))
            value = MODVI10;
        else if (fieldName.equals("DATVICACT1"))
            value = DATVICACT1;
        else if (fieldName.equals("DATVICACT2"))
            value = DATVICACT2;
        else if (fieldName.equals("DATVICACT3"))
            value = DATVICACT3;
        else if (fieldName.equals("DATVICACT4"))
            value = DATVICACT4;
        else if (fieldName.equals("DATVICACT5"))
            value = DATVICACT5;
        else if (fieldName.equals("DATVICACT6"))
            value = DATVICACT6;
        else if (fieldName.equals("DATVICACT7"))
            value = DATVICACT7;
        else if (fieldName.equals("DATVICACT8"))
            value = DATVICACT8;
        else if (fieldName.equals("POBLACLGTBS"))
            value = POBLACLGTBS;
        else if (fieldName.equals("POBLACLGTBN"))
            value = POBLACLGTBN;
        else if (fieldName.equals("CONSUMESPAS"))
            value = CONSUMESPAS;
        else if (fieldName.equals("CONSUMESPAN"))
            value = CONSUMESPAN;
        else if (fieldName.equals("TRABAJOSEXS"))
            value = TRABAJOSEXS;
        else if (fieldName.equals("TRABAJOSEXN"))
            value = TRABAJOSEXN;
        else if (fieldName.equals("DESMOVILIZS"))
            value = DESMOVILIZS;
        else if (fieldName.equals("DESMOVILIZN"))
            value = DESMOVILIZN;
        else if (fieldName.equals("CAMPESINOS"))
            value = CAMPESINOS;
        else if (fieldName.equals("CAMPESINON"))
            value = CAMPESINON;
        else if (fieldName.equals("MUJERCABFAS"))
            value = MUJERCABFAS;
        else if (fieldName.equals("MUJERCABFAN"))
            value = MUJERCABFAN;
        else if (fieldName.equals("AMADECASAS"))
            value = AMADECASAS;
        else if (fieldName.equals("AMADECASAN"))
            value = AMADECASAN;
        else if (fieldName.equals("NNASNBFS"))
            value = NNASNBFS;
        else if (fieldName.equals("NNASNBFN"))
            value = NNASNBFN;
        else if (fieldName.equals("PRIVALIBERS"))
            value = PRIVALIBERS;
        else if (fieldName.equals("PRIVALIBERN"))
            value = PRIVALIBERN;
        else if (fieldName.equals("VICCONARMAS"))
            value = VICCONARMAS;
        else if (fieldName.equals("VICCONARMAN"))
            value = VICCONARMAN;
        else if (fieldName.equals("OTRO3S"))
            value = OTRO3S;
        else if (fieldName.equals("OTRO3N"))
            value = OTRO3N;
        else if (fieldName.equals("REINCIDENCS"))
            value = REINCIDENCS;
        else if (fieldName.equals("REINCIDENCN"))
            value = REINCIDENCN;
        else if (fieldName.equals("ALCOHOLVICS"))
            value = ALCOHOLVICS;
        else if (fieldName.equals("ALCOHOLVICN"))
            value = ALCOHOLVICN;
        else if (fieldName.equals("EDADAGRE"))
            value = EDADAGRE;
        else if (fieldName.equals("SEXOAGREH"))
            value = SEXOAGREH;
        else if (fieldName.equals("SEXOAGREM"))
            value = SEXOAGREM;
        else if (fieldName.equals("SEXOAGRES"))
            value = SEXOAGRES;
        else if (fieldName.equals("PARENTVICTES"))
            value = PARENTVICTES;
        else if (fieldName.equals("PARENTVICTCP"))
            value = PARENTVICTCP;
        else if (fieldName.equals("PARENTVICTNO"))
            value = PARENTVICTNO;
        else if (fieldName.equals("PARENTVICTAM"))
            value = PARENTVICTAM;
        else if (fieldName.equals("PARENTVICTEXE"))
            value = PARENTVICTEXE;
        else if (fieldName.equals("PARENTVICTEXC"))
            value = PARENTVICTEXC;
        else if (fieldName.equals("PARENTVICTEXN"))
            value = PARENTVICTEXN;
        else if (fieldName.equals("PARENTVICTEXA"))
            value = PARENTVICTEXA;
        else if (fieldName.equals("PARENTVICTPA"))
            value = PARENTVICTPA;
        else if (fieldName.equals("PARENTVICTMA"))
            value = PARENTVICTMA;
        else if (fieldName.equals("PARENTVICTHI"))
            value = PARENTVICTHI;
        else if (fieldName.equals("PARENTVICTENC"))
            value = PARENTVICTENC;
        else if (fieldName.equals("PARENTVICTHER"))
            value = PARENTVICTHER;
        else if (fieldName.equals("PARENTVICTABU"))
            value = PARENTVICTABU;
        else if (fieldName.equals("PARENTVICTPAD"))
            value = PARENTVICTPAD;
        else if (fieldName.equals("PARENTVICTMAD"))
            value = PARENTVICTMAD;
        else if (fieldName.equals("PARENTVICTTIO"))
            value = PARENTVICTTIO;
        else if (fieldName.equals("PARENTVICTPRI"))
            value = PARENTVICTPRI;
        else if (fieldName.equals("PARENTVICTCUN"))
            value = PARENTVICTCUN;
        else if (fieldName.equals("PARENTVICTSUE"))
            value = PARENTVICTSUE;
        else if (fieldName.equals("PARENTVICTOTR"))
            value = PARENTVICTOTR;
        else if (fieldName.equals("CONVCAGRESS"))
            value = CONVCAGRESS;
        else if (fieldName.equals("CONVCAGRESN"))
            value = CONVCAGRESN;
        else if (fieldName.equals("AGRENOFAMIPRO"))
            value = AGRENOFAMIPRO;
        else if (fieldName.equals("AGRENOFAMIAMI"))
            value = AGRENOFAMIAMI;
        else if (fieldName.equals("AGRENOFAMICDT"))
            value = AGRENOFAMICDT;
        else if (fieldName.equals("AGRENOFAMICDE"))
            value = AGRENOFAMICDE;
        else if (fieldName.equals("AGRENOFAMIDES"))
            value = AGRENOFAMIDES;
        else if (fieldName.equals("AGRENOFAMIVEC"))
            value = AGRENOFAMIVEC;
        else if (fieldName.equals("AGRENOFAMICON"))
            value = AGRENOFAMICON;
        else if (fieldName.equals("AGRENOFAMISIN"))
            value = AGRENOFAMISIN;
        else if (fieldName.equals("AGRENOFAMIOTR"))
            value = AGRENOFAMIOTR;
        else if (fieldName.equals("AGRENOFAMIJEF"))
            value = AGRENOFAMIJEF;
        else if (fieldName.equals("AGRENOFAMISAC"))
            value = AGRENOFAMISAC;
        else if (fieldName.equals("AGRENOFAMISPU"))
            value = AGRENOFAMISPU;
        else if (fieldName.equals("GRUPERVIOLEJE"))
            value = GRUPERVIOLEJE;
        else if (fieldName.equals("GRUPERVIOLFAE"))
            value = GRUPERVIOLFAE;
        else if (fieldName.equals("GRUPERVIOLARM"))
            value = GRUPERVIOLARM;
        else if (fieldName.equals("GRUPERVIOLPOL"))
            value = GRUPERVIOLPOL;
        else if (fieldName.equals("GRUPERVIOLNAR"))
            value = GRUPERVIOLNAR;
        else if (fieldName.equals("GRUPERVIOLBCR"))
            value = GRUPERVIOLBCR;
        else if (fieldName.equals("GRUPERVIOLPAN"))
            value = GRUPERVIOLPAN;
        else if (fieldName.equals("GRUPERVIOLAUT"))
            value = GRUPERVIOLAUT;
        else if (fieldName.equals("GRUPERVIOLGUE"))
            value = GRUPERVIOLGUE;
        else if (fieldName.equals("GRUPERVIOLNSA"))
            value = GRUPERVIOLNSA;
        else if (fieldName.equals("MECANUTILIAES"))
            value = MECANUTILIAES;
        else if (fieldName.equals("MECANUTILICAI"))
            value = MECANUTILICAI;
        else if (fieldName.equals("MECANUTILICON"))
            value = MECANUTILICON;
        else if (fieldName.equals("MECANUTILICOT"))
            value = MECANUTILICOT;
        else if (fieldName.equals("MECANUTILIPAF"))
            value = MECANUTILIPAF;
        else if (fieldName.equals("MECANUTILIQPF"))
            value = MECANUTILIQPF;
        else if (fieldName.equals("MECANUTILIQPA"))
            value = MECANUTILIQPA;
        else if (fieldName.equals("MECANUTILIQCL"))
            value = MECANUTILIQCL;
        else if (fieldName.equals("MECANUTILIOTR"))
            value = MECANUTILIOTR;
        else if (fieldName.equals("SITIOANATOCAR"))
            value = SITIOANATOCAR;
        else if (fieldName.equals("SITIOANATOCUE"))
            value = SITIOANATOCUE;
        else if (fieldName.equals("SITIOANATOMAN"))
            value = SITIOANATOMAN;
        else if (fieldName.equals("SITIOANATOPIE"))
            value = SITIOANATOPIE;
        else if (fieldName.equals("SITIOANATOPLI"))
            value = SITIOANATOPLI;
        else if (fieldName.equals("SITIOANATOGEN"))
            value = SITIOANATOGEN;
        else if (fieldName.equals("SITIOANATOTRO"))
            value = SITIOANATOTRO;
        else if (fieldName.equals("SITIOANATOMSU"))
            value = SITIOANATOMSU;
        else if (fieldName.equals("SITIOANATOMIN"))
            value = SITIOANATOMIN;
        else if (fieldName.equals("GRADO1"))
            value = GRADO1;
        else if (fieldName.equals("GRADO2"))
            value = GRADO2;
        else if (fieldName.equals("GRADO3"))
            value = GRADO3;
        else if (fieldName.equals("EXTENSION1"))
            value = EXTENSION1;
        else if (fieldName.equals("EXTENSION2"))
            value = EXTENSION2;
        else if (fieldName.equals("EXTENSION3"))
            value = EXTENSION3;
        else if (fieldName.equals("FECHAECHO"))
            value = FECHAECHO;
        else if (fieldName.equals("HORAECHO"))
            value = HORAECHO;
        else if (fieldName.equals("MINUECHO"))
            value = MINUECHO;
        else if (fieldName.equals("ESCENARIOVP"))
            value = ESCENARIOVP;
        else if (fieldName.equals("ESCENARIOVI"))
            value = ESCENARIOVI;
        else if (fieldName.equals("ESCENARIOCC"))
            value = ESCENARIOCC;
        else if (fieldName.equals("ESCENARIOOE"))
            value = ESCENARIOOE;
        else if (fieldName.equals("ESCENARIOOT"))
            value = ESCENARIOOT;
        else if (fieldName.equals("ESCENARIOET"))
            value = ESCENARIOET;
        else if (fieldName.equals("ESCENARIOEC"))
            value = ESCENARIOEC;
        else if (fieldName.equals("ESCENARIOLE"))
            value = ESCENARIOLE;
        else if (fieldName.equals("MARCOCOARS"))
            value = MARCOCOARS;
        else if (fieldName.equals("MARCOCOARN"))
            value = MARCOCOARN;
        else if (fieldName.equals("PROFILAVIHS"))
            value = PROFILAVIHS;
        else if (fieldName.equals("PROFILAVIHN"))
            value = PROFILAVIHN;
        else if (fieldName.equals("PROFILHEPBS"))
            value = PROFILHEPBS;
        else if (fieldName.equals("PROFILHEPBN"))
            value = PROFILHEPBN;
        else if (fieldName.equals("OTRASPROFIS"))
            value = OTRASPROFIS;
        else if (fieldName.equals("OTRASPROFIN"))
            value = OTRASPROFIN;
        else if (fieldName.equals("ANTICOEMERS"))
            value = ANTICOEMERS;
        else if (fieldName.equals("ANTICOEMERN"))
            value = ANTICOEMERN;
        else if (fieldName.equals("ORIENTAIVES"))
            value = ORIENTAIVES;
        else if (fieldName.equals("ORIENTAIVEN"))
            value = ORIENTAIVEN;
        else if (fieldName.equals("SALUDMENTAS"))
            value = SALUDMENTAS;
        else if (fieldName.equals("SALUDMENTAN"))
            value = SALUDMENTAN;
        else if (fieldName.equals("REMAPROTECS"))
            value = REMAPROTECS;
        else if (fieldName.equals("REMAPROTECN"))
            value = REMAPROTECN;
        else if (fieldName.equals("DENUNCIAS"))
            value = DENUNCIAS;
        else if (fieldName.equals("DENUNCIAN"))
            value = DENUNCIAN;
        else if (fieldName.equals("RECOEVIMEDS"))
            value = RECOEVIMEDS;
        else if (fieldName.equals("RECOEVIMEDN"))
            value = RECOEVIMEDN;
        return value;
    }

    public void resetDatos() {
        NOMBRES_APELLIDOS = null;
        TIPOID = null;
        NUMERO_DOCUMENTO = null;
        MODVIO1 = null;
        MODVIO2 = null;
        MODVIO3 = null;
        MODVIO4 = null;
        MODVIO5 = null;
        MODVIO6 = null;
        MODVIO7 = null;
        MODVIO8 = null;
        MODVIO9 = null;
        MODVI10 = null;
        DATVICACT1 = null;
        DATVICACT2 = null;
        DATVICACT3 = null;
        DATVICACT4 = null;
        DATVICACT5 = null;
        DATVICACT6 = null;
        DATVICACT7 = null;
        DATVICACT8 = null;
        POBLACLGTBS = null;
        POBLACLGTBN = null;
        CONSUMESPAS = null;
        CONSUMESPAN = null;
        TRABAJOSEXS = null;
        TRABAJOSEXN = null;
        DESMOVILIZS = null;
        DESMOVILIZN = null;
        CAMPESINOS = null;
        CAMPESINON = null;
        MUJERCABFAS = null;
        MUJERCABFAN = null;
        AMADECASAS = null;
        AMADECASAN = null;
        NNASNBFS = null;
        NNASNBFN = null;
        PRIVALIBERS = null;
        PRIVALIBERN = null;
        VICCONARMAS = null;
        VICCONARMAN = null;
        OTRO3S = null;
        OTRO3N = null;
        REINCIDENCS = null;
        REINCIDENCN = null;
        ALCOHOLVICS = null;
        ALCOHOLVICN = null;
        EDADAGRE = null;
        SEXOAGREH = null;
        SEXOAGREM = null;
        SEXOAGRES = null;
        PARENTVICTES = null;
        PARENTVICTCP = null;
        PARENTVICTNO = null;
        PARENTVICTAM = null;
        PARENTVICTEXE = null;
        PARENTVICTEXC = null;
        PARENTVICTEXN = null;
        PARENTVICTEXA = null;
        PARENTVICTPA = null;
        PARENTVICTMA = null;
        PARENTVICTHI = null;
        PARENTVICTENC = null;
        PARENTVICTHER = null;
        PARENTVICTABU = null;
        PARENTVICTPAD = null;
        PARENTVICTMAD = null;
        PARENTVICTTIO = null;
        PARENTVICTPRI = null;
        PARENTVICTCUN = null;
        PARENTVICTSUE = null;
        PARENTVICTOTR = null;
        CONVCAGRESS = null;
        CONVCAGRESN = null;
        AGRENOFAMIPRO = null;
        AGRENOFAMIAMI = null;
        AGRENOFAMICDT = null;
        AGRENOFAMICDE = null;
        AGRENOFAMIDES = null;
        AGRENOFAMIVEC = null;
        AGRENOFAMICON = null;
        AGRENOFAMISIN = null;
        AGRENOFAMIOTR = null;
        AGRENOFAMIJEF = null;
        AGRENOFAMISAC = null;
        AGRENOFAMISPU = null;
        GRUPERVIOLEJE = null;
        GRUPERVIOLFAE = null;
        GRUPERVIOLARM = null;
        GRUPERVIOLPOL = null;
        GRUPERVIOLNAR = null;
        GRUPERVIOLBCR = null;
        GRUPERVIOLPAN = null;
        GRUPERVIOLAUT = null;
        GRUPERVIOLGUE = null;
        GRUPERVIOLNSA = null;
        MECANUTILIAES = null;
        MECANUTILICAI = null;
        MECANUTILICON = null;
        MECANUTILICOT = null;
        MECANUTILIPAF = null;
        MECANUTILIQPF = null;
        MECANUTILIQPA = null;
        MECANUTILIQCL = null;
        MECANUTILIOTR = null;
        SITIOANATOCAR = null;
        SITIOANATOCUE = null;
        SITIOANATOMAN = null;
        SITIOANATOPIE = null;
        SITIOANATOPLI = null;
        SITIOANATOGEN = null;
        SITIOANATOTRO = null;
        SITIOANATOMSU = null;
        SITIOANATOMIN = null;
        GRADO1 = null;
        GRADO2 = null;
        GRADO3 = null;
        EXTENSION1 = null;
        EXTENSION2 = null;
        EXTENSION3 = null;
        FECHAECHO = null;
        HORAECHO = null;
        MINUECHO = null;
        ESCENARIOVP = null;
        ESCENARIOVI = null;
        ESCENARIOCC = null;
        ESCENARIOOE = null;
        ESCENARIOOT = null;
        ESCENARIOET = null;
        ESCENARIOEC = null;
        ESCENARIOLE = null;
        MARCOCOARS = null;
        MARCOCOARN = null;
        PROFILAVIHS = null;
        PROFILAVIHN = null;
        PROFILHEPBS = null;
        PROFILHEPBN = null;
        OTRASPROFIS = null;
        OTRASPROFIN = null;
        ANTICOEMERS = null;
        ANTICOEMERN = null;
        ORIENTAIVES = null;
        ORIENTAIVEN = null;
        SALUDMENTAS = null;
        SALUDMENTAN = null;
        REMAPROTECS = null;
        REMAPROTECN = null;
        DENUNCIAS = null;
        DENUNCIAN = null;
        RECOEVIMEDS = null;
        RECOEVIMEDN = null;

    }

    public void obtenerDatos() {


        try {
            usuario = 
                    this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (usuario != null) {
            if (usuario.getHuscprimernomb() != null) {
                NOMBRES_APELLIDOS = usuario.getHuscprimernomb();
            }
            if (usuario.getHuscsegundnomb() != null) {
                NOMBRES_APELLIDOS = 
                        NOMBRES_APELLIDOS + " " + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRES_APELLIDOS = 
                        NOMBRES_APELLIDOS + " " + usuario.getHuscprimerapel();
            }
            if (usuario.getHuscsegundapel() != null) {
                NOMBRES_APELLIDOS = 
                        NOMBRES_APELLIDOS + " " + usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPOID = usuario.getHusetipoiden();
            }
            if (usuario.getHusanumeiden() != null) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
        }
        int resultado;
        if (violencia != null) {
            if (violencia.getHvscmodalviole() != null) {
                resultado = violencia.getHvscmodalviole().indexOf("VF");
                if (resultado != -1) {
                    MODVIO1 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("VP");
                if (resultado != -1) {
                    MODVIO2 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("NA");
                if (resultado != -1) {
                    MODVIO3 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("ABS");
                if (resultado != -1) {
                    MODVIO4 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("ACS");
                if (resultado != -1) {
                    MODVIO5 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("VI");
                if (resultado != -1) {
                    MODVIO6 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("ESN");
                if (resultado != -1) {
                    MODVIO7 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("TES");
                if (resultado != -1) {
                    MODVIO8 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("VSC");
                if (resultado != -1) {
                    MODVIO9 = ".";
                }
                resultado = violencia.getHvscmodalviole().indexOf("ASV");
                if (resultado != -1) {
                    MODVI10 = ".";
                }

            }
            resultado = 0;
            if (violencia.getHvscdatvicacti() != null) {
                resultado = violencia.getHvscdatvicacti().indexOf("RE");
                if (resultado != -1) {
                    DATVICACT1 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("LC");
                if (resultado != -1) {
                    DATVICACT2 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("MA");
                if (resultado != -1) {
                    DATVICACT3 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("SP");
                if (resultado != -1) {
                    DATVICACT4 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("FP");
                if (resultado != -1) {
                    DATVICACT5 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("ES");
                if (resultado != -1) {
                    DATVICACT6 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("OT");
                if (resultado != -1) {
                    DATVICACT7 = ".";
                }
                resultado = violencia.getHvscdatvicacti().indexOf("TD");
                if (resultado != -1) {
                    DATVICACT8 = ".";
                }

            }
            resultado = 0;
            if (violencia.getHvscpoblaclgtb() != null) {
                resultado = violencia.getHvscpoblaclgtb().indexOf("S");
                if (resultado != -1) {
                    POBLACLGTBS = ".";
                } else {
                    POBLACLGTBN = ".";
                }
            }
            if (violencia.getHvscconsumespa() != null) {
                resultado = violencia.getHvscconsumespa().indexOf("S");
                if (resultado != -1) {
                    CONSUMESPAS = ".";
                } else {
                    CONSUMESPAN = ".";
                }
            }
            if (violencia.getHvsctrabajosex() != null) {
                resultado = violencia.getHvsctrabajosex().indexOf("S");
                if (resultado != -1) {
                    TRABAJOSEXS = ".";
                } else {
                    TRABAJOSEXN = ".";
                }
            }
            if (violencia.getHvscdesmoviliz() != null) {
                resultado = violencia.getHvscdesmoviliz().indexOf("S");
                if (resultado != -1) {
                    DESMOVILIZS = ".";
                } else {
                    DESMOVILIZN = ".";
                }
            }
            if (violencia.getHvsccampesino() != null) {
                resultado = violencia.getHvsccampesino().indexOf("S");
                if (resultado != -1) {
                    CAMPESINOS = ".";
                } else {
                    CAMPESINON = ".";
                }
            }
            if (violencia.getHvscmujercabfa() != null) {
                resultado = violencia.getHvscmujercabfa().indexOf("S");
                if (resultado != -1) {
                    MUJERCABFAS = ".";
                } else {
                    MUJERCABFAN = ".";
                }
            }
            if (violencia.getHvscamadecasa() != null) {
                resultado = violencia.getHvscamadecasa().indexOf("S");
                if (resultado != -1) {
                    AMADECASAS = ".";
                } else {
                    AMADECASAN = ".";
                }
            }
            if (violencia.getHvscnnasnbf() != null) {
                resultado = violencia.getHvscnnasnbf().indexOf("S");
                if (resultado != -1) {
                    NNASNBFS = ".";
                } else {
                    NNASNBFN = ".";
                }
            }
            if (violencia.getHvscprivaliber() != null) {
                resultado = violencia.getHvscprivaliber().indexOf("S");
                if (resultado != -1) {
                    PRIVALIBERS = ".";
                } else {
                    PRIVALIBERN = ".";
                }
            }
            if (violencia.getHvscvicconarma() != null) {
                resultado = violencia.getHvscvicconarma().indexOf("S");
                if (resultado != -1) {
                    VICCONARMAS = ".";
                } else {
                    VICCONARMAN = ".";
                }
            }
            if (violencia.getHvscotro() != null) {
                resultado = violencia.getHvscotro().indexOf("S");
                if (resultado != -1) {
                    OTRO3S = ".";
                } else {
                    OTRO3N = ".";
                }
            }
            if (violencia.getHvscreincidenc() != null) {
                resultado = violencia.getHvscreincidenc().indexOf("S");
                if (resultado != -1) {
                    REINCIDENCS = ".";
                } else {
                    REINCIDENCN = ".";
                }
            }
            if (violencia.getHvscalcoholvic() != null) {
                resultado = violencia.getHvscalcoholvic().indexOf("S");
                if (resultado != -1) {
                    ALCOHOLVICS = ".";
                } else {
                    ALCOHOLVICN = ".";
                }
            }
            if (violencia.getHvsnedadagre() != null) {
                EDADAGRE = violencia.getHvsnedadagre();
            }
            if (violencia.getHvscsexoagre() != null) {
                if (violencia.getHvscsexoagre().equals("H")) {
                    SEXOAGREH = ".";
                } else if (violencia.getHvscsexoagre().equals("M")) {
                    SEXOAGREM = ".";
                } else {
                    SEXOAGRES = ".";
                }
            }
            if (violencia.getHvscparentvict() != null) {
                resultado = violencia.getHvscparentvict().indexOf("ES");
                if (resultado != -1) {
                    PARENTVICTES = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("CP");
                if (resultado != -1) {
                    PARENTVICTCP = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("NO");
                if (resultado != -1) {
                    PARENTVICTNO = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("AM");
                if (resultado != -1) {
                    PARENTVICTAM = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("EXE");
                if (resultado != -1) {
                    PARENTVICTEXE = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("EXC");
                if (resultado != -1) {
                    PARENTVICTEXC = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("EXN");
                if (resultado != -1) {
                    PARENTVICTEXN = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("EXA");
                if (resultado != -1) {
                    PARENTVICTEXA = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("PA");
                if (resultado != -1) {
                    PARENTVICTPA = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("MA");
                if (resultado != -1) {
                    PARENTVICTMA = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("HI");
                if (resultado != -1) {
                    PARENTVICTHI = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("ENC");
                if (resultado != -1) {
                    PARENTVICTENC = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("HER");
                if (resultado != -1) {
                    PARENTVICTHER = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("ABU");
                if (resultado != -1) {
                    PARENTVICTABU = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("PAD");
                if (resultado != -1) {
                    PARENTVICTPAD = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("MAD");
                if (resultado != -1) {
                    PARENTVICTMAD = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("TIO");
                if (resultado != -1) {
                    PARENTVICTTIO = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("PRI");
                if (resultado != -1) {
                    PARENTVICTPRI = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("CUN");
                if (resultado != -1) {
                    PARENTVICTCUN = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("SUE");
                if (resultado != -1) {
                    PARENTVICTSUE = ".";
                }
                resultado = violencia.getHvscparentvict().indexOf("OTR");
                if (resultado != -1) {
                    PARENTVICTOTR = ".";
                }
            }
            if (violencia.getHvscconvcagres() != null) {
                resultado = violencia.getHvscconvcagres().indexOf("S");
                if (resultado != -1) {
                    CONVCAGRESS = ".";
                } else {
                    CONVCAGRESN = ".";
                }
            }
            if (violencia.getHvscagrenofami() != null) {
                resultado = violencia.getHvscagrenofami().indexOf("PRO");
                if (resultado != -1) {
                    AGRENOFAMIPRO = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("AMI");
                if (resultado != -1) {
                    AGRENOFAMIAMI = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("CDT");
                if (resultado != -1) {
                    AGRENOFAMICDT = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("CDE");
                if (resultado != -1) {
                    AGRENOFAMICDE = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("DES");
                if (resultado != -1) {
                    AGRENOFAMIDES = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("VEC");
                if (resultado != -1) {
                    AGRENOFAMIVEC = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("CON");
                if (resultado != -1) {
                    AGRENOFAMICON = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("SIN");
                if (resultado != -1) {
                    AGRENOFAMISIN = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("OTR");
                if (resultado != -1) {
                    AGRENOFAMIOTR = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("JEF");
                if (resultado != -1) {
                    AGRENOFAMIJEF = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("SAC");
                if (resultado != -1) {
                    AGRENOFAMISAC = ".";
                }
                resultado = violencia.getHvscagrenofami().indexOf("SPU");
                if (resultado != -1) {
                    AGRENOFAMISPU = ".";
                }
            }
            if (violencia.getHvscgruperviol() != null) {
                resultado = violencia.getHvscgruperviol().indexOf("EJE");
                if (resultado != -1) {
                    GRUPERVIOLEJE = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("FAE");
                if (resultado != -1) {
                    GRUPERVIOLFAE = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("ARM");
                if (resultado != -1) {
                    GRUPERVIOLARM = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("POL");
                if (resultado != -1) {
                    GRUPERVIOLPOL = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("NAR");
                if (resultado != -1) {
                    GRUPERVIOLNAR = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("BCR");
                if (resultado != -1) {
                    GRUPERVIOLBCR = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("PAN");
                if (resultado != -1) {
                    GRUPERVIOLPAN = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("AUT");
                if (resultado != -1) {
                    GRUPERVIOLAUT = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("GUE");
                if (resultado != -1) {
                    GRUPERVIOLGUE = ".";
                }
                resultado = violencia.getHvscgruperviol().indexOf("NSA");
                if (resultado != -1) {
                    GRUPERVIOLNSA = ".";
                }
            }
            if (violencia.getHvscmecanutili() != null) {
                resultado = violencia.getHvscmecanutili().indexOf("AES");
                if (resultado != -1) {
                    MECANUTILIAES = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("CAI");
                if (resultado != -1) {
                    MECANUTILICAI = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("CON");
                if (resultado != -1) {
                    MECANUTILICON = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("COT");
                if (resultado != -1) {
                    MECANUTILICOT = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("PAF");
                if (resultado != -1) {
                    MECANUTILIPAF = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("QPF");
                if (resultado != -1) {
                    MECANUTILIQPF = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("QPA");
                if (resultado != -1) {
                    MECANUTILIQPA = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("QCL");
                if (resultado != -1) {
                    MECANUTILIQCL = ".";
                }
                resultado = violencia.getHvscmecanutili().indexOf("OTR");
                if (resultado != -1) {
                    MECANUTILIOTR = ".";
                }
            }
            if (violencia.getHvscsitioanato() != null) {
                resultado = violencia.getHvscsitioanato().indexOf("CAR");
                if (resultado != -1) {
                    SITIOANATOCAR = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("CUE");
                if (resultado != -1) {
                    SITIOANATOCUE = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("MAN");
                if (resultado != -1) {
                    SITIOANATOMAN = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("PIE");
                if (resultado != -1) {
                    SITIOANATOPIE = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("PLI");
                if (resultado != -1) {
                    SITIOANATOPLI = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("GEN");
                if (resultado != -1) {
                    SITIOANATOGEN = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("TRO");
                if (resultado != -1) {
                    SITIOANATOTRO = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("MSU");
                if (resultado != -1) {
                    SITIOANATOMSU = ".";
                }
                resultado = violencia.getHvscsitioanato().indexOf("MIN");
                if (resultado != -1) {
                    SITIOANATOMIN = ".";
                }
            }
            if (violencia.getHvsngrado() != null) {
                if (violencia.getHvsngrado() == 1) {
                    GRADO1 = ".";
                } else if (violencia.getHvsngrado() == 2) {
                    GRADO2 = ".";
                } else {
                    GRADO3 = ".";
                }
            }
            if (violencia.getHvsnextension() != null) {
                if (violencia.getHvsnextension() == 1) {
                    EXTENSION1 = ".";
                } else if (violencia.getHvsnextension() == 2) {
                    EXTENSION2 = ".";
                } else {
                    EXTENSION3 = ".";
                }
            }
            if (violencia.getHvsdfechaecho() != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(violencia.getHvsdfechaecho());
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH + 1);
                int ano = calendar.get(Calendar.YEAR);

                FECHAECHO = dia + "/" + mes + "/" + ano;

            }
            if (violencia.getHvschoraecho() != null) {
                HORAECHO = violencia.getHvschoraecho();
            }
            if (violencia.getHvscminuecho() != null) {
                MINUECHO = ": " + violencia.getHvscminuecho();
            }
            if (violencia.getHvscescenario() != null) {
                resultado = violencia.getHvscescenario().indexOf("VP");
                if (resultado != -1) {
                    ESCENARIOVP = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("VI");
                if (resultado != -1) {
                    ESCENARIOVI = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("CC");
                if (resultado != -1) {
                    ESCENARIOCC = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("OE");
                if (resultado != -1) {
                    ESCENARIOOE = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("OT");
                if (resultado != -1) {
                    ESCENARIOOT = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("ET");
                if (resultado != -1) {
                    ESCENARIOET = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("EC");
                if (resultado != -1) {
                    ESCENARIOEC = ".";
                }
                resultado = violencia.getHvscescenario().indexOf("LE");
                if (resultado != -1) {
                    ESCENARIOLE = ".";
                }
            }
            if (violencia.getHvscmarcocoar() != null) {
                resultado = violencia.getHvscmarcocoar().indexOf("S");
                if (resultado != -1) {
                    MARCOCOARS = ".";
                } else {
                    MARCOCOARN = ".";
                }
            }
            if (violencia.getHvscprofilavih() != null) {
                resultado = violencia.getHvscprofilavih().indexOf("S");
                if (resultado != -1) {
                    PROFILAVIHS = ".";
                } else {
                    PROFILAVIHN = ".";
                }
            }
            if (violencia.getHvscprofilhepb() != null) {
                resultado = violencia.getHvscprofilhepb().indexOf("S");
                if (resultado != -1) {
                    PROFILHEPBS = ".";
                } else {
                    PROFILHEPBN = ".";
                }
            }
            if (violencia.getHvscotrasprofi() != null) {
                resultado = violencia.getHvscotrasprofi().indexOf("S");
                if (resultado != -1) {
                    OTRASPROFIS = ".";
                } else {
                    OTRASPROFIN = ".";
                }
            }
            if (violencia.getHvscanticoemer() != null) {
                resultado = violencia.getHvscanticoemer().indexOf("S");
                if (resultado != -1) {
                    ANTICOEMERS = ".";
                } else {
                    ANTICOEMERN = ".";
                }
            }
            if (violencia.getHvscorientaive() != null) {
                resultado = violencia.getHvscorientaive().indexOf("S");
                if (resultado != -1) {
                    ORIENTAIVES = ".";
                } else {
                    ORIENTAIVEN = ".";
                }
            }
            if (violencia.getHvscsaludmenta() != null) {
                resultado = violencia.getHvscsaludmenta().indexOf("S");
                if (resultado != -1) {
                    SALUDMENTAS = ".";
                } else {
                    SALUDMENTAN = ".";
                }
            }
            if (violencia.getHvscremaprotec() != null) {
                resultado = violencia.getHvscremaprotec().indexOf("S");
                if (resultado != -1) {
                    REMAPROTECS = ".";
                } else {
                    REMAPROTECN = ".";
                }
            }
            if (violencia.getHvscdenuncia() != null) {
                resultado = violencia.getHvscdenuncia().indexOf("S");
                if (resultado != -1) {
                    DENUNCIAS = ".";
                } else {
                    DENUNCIAN = ".";
                }
            }
            if (violencia.getHvscrecoevimed() != null) {
                resultado = violencia.getHvscrecoevimed().indexOf("S");
                if (resultado != -1) {
                    RECOEVIMEDS = ".";
                } else {
                    RECOEVIMEDN = ".";
                }
            }
        }
    }

    public void generarReporte() {
        try {
            index = -1;
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EncuestaViolenciaSivigila.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_INS);
            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_REPCOL);
            
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_INS", url_profamilia);
                parameters.put("IMAGE_REPCOL", url_super_horizontal);
                
                byte[] bytes;
                generoReporte = true;
                JasperReport report = (JasperReport)JRLoader.loadObject(url);
                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "ReporteSivigila" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
            }
        } catch (Exception e) {
            generoReporte = false;
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }
}
