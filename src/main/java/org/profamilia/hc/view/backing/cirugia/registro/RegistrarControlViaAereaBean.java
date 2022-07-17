//=======================================================================
// ARCHIVO RegistrarControlViaAereaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chventiaerea;
import org.profamilia.hc.model.dto.ChventiaereaPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarControlViaAereaBean
//=======================================================================

public class RegistrarControlViaAereaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chventiaerea viaaerea;

    private List lstCircuito;

    private List lstTipoOxigenoDirecto;

    private List lstTipoMascara;

    private List lstTipoControl;

    private List lstVistaLaringoscopia;

    private boolean mostraroxigeno;

    private boolean mostrarmascara;

    private boolean mostrarotro;

    private boolean mostrardificultades;

    private boolean mostrarotraverificacion;

    private boolean mostrarVentilacionasistida;

    private boolean selectfacial;

    private boolean selectcanulaoro;

    private boolean selectcanulanaso;

    private boolean selectlaringuea;

    private boolean selectotrodispositivo;

    private boolean selectIntubacion;

    private boolean selectotro;

    private boolean mostrarventilacionmecanica;

    private String selectmascaralaringea;

    private List lstVerificacion;

    private List lstOpciones;

    private List lstmasclaringea;

    private List lstMetodoControl;

    private List lstModoVentilacion;

    private List<String> lstVerifica;

    private List listHora;
    private List lstMinutos;

    private Integer horacolocacion;
    private Integer minutocolocacion;
    private Integer horaretiro;
    private Integer minutoretiro;

    private Integer horacolocacionotro;
    private Integer minutocolocacionotro;

    private Integer horaretirootro;
    private Integer minutoretirootro;

    private UIInput checkFacial;
    private UIInput checkCanual;
    private UIInput checkCanulaNaso;
    private UIInput checkMascaraLaringuea;
    private UIInput checkOtroDispositivo;
    private UIInput checkIntubacion;
    private UIInput checkOtro;


    private Integer horaintubacion;
    private Integer horaextubacion;

    private Integer minutointubacion;
    private Integer minutoextubacion;

    private UIInput mnuModoVentilacion;

    private Long numeroCirugia;

    private String tipoServicio;

    private String navegationRule;

    private boolean ligadura;

    private boolean renderOtrasCirugias;

    private Chcirugprogr cirugia;

    private int selectedIndex;

    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;

    static final int ACTIVAR_APLICACION = 0;

    private boolean renderPlantilla;

    private UIInput itDescripcion;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    public RegistrarControlViaAereaBean() {
    }

    public void init() {
        lstCircuito = new ArrayList();
        lstTipoOxigenoDirecto = new ArrayList();
        lstTipoMascara = new ArrayList();
        lstTipoControl = new ArrayList();
        lstVerificacion = new ArrayList();
        lstOpciones = new ArrayList();
        lstMetodoControl = new ArrayList();
        lstModoVentilacion = new ArrayList();
        lstVistaLaringoscopia = new ArrayList();
        lstmasclaringea = new ArrayList();

        lstMinutos = new ArrayList();
        listHora = new ArrayList();
        lstVerifica = new ArrayList();
        cargarDatos();
    }

    public void cargarDatos() {


        try {
            viaaerea = 
                    this.serviceLocator.getClinicoService().getControlViaAerea(numeroCirugia);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (viaaerea == null) {
            viaaerea = new Chventiaerea();

        } else {

            viaaerea.setHvacmetodcontr("VE");
            viaaerea.setHvaccircuoxige("CC");
            viaaerea.setHvadhoracolmas(cirugia.getHcpdfechacirug());
            viaaerea.setHvadhoraretmas(cirugia.getHcpdfechacirug());
            viaaerea.setHvadhoracolotr(cirugia.getHcpdfechacirug());
            viaaerea.setHvadhoraretotr(cirugia.getHcpdfechacirug());
            viaaerea.setHvadhoraintuba(cirugia.getHcpdfechacirug());
            viaaerea.setHvadhoraextuba(cirugia.getHcpdfechacirug());

            if (viaaerea.getHvaccontviarea() != null && 
                viaaerea.getHvaccontviarea().equals("D")) {
                mostrardificultades = true;
            } else {
                mostrardificultades = false;

            }

            if (viaaerea.getHvacverifviare() != null && 
                viaaerea.getHvacverifviare().equals("O")) {
                mostrarotraverificacion = true;
            } else {

                mostrarotraverificacion = false;
            }

            if (viaaerea.getHvacmodoventil() != null && 
                viaaerea.getHvacmodoventil().equals("E")) {
                mostrarventilacionmecanica = true;
            } else {
                mostrarventilacionmecanica = false;
            }

            if (viaaerea.getHvaccircuoxige() != null && 
                viaaerea.getHvaccircuoxige().equals("OD")) {
                mostraroxigeno = true;
            } else {
                mostraroxigeno = false;
                mostrarmascara = false;
            }


            if (viaaerea.getHvaccircuoxige() != null && 
                viaaerea.getHvaccircuoxige().equals("OT")) {
                mostrarotro = true;
            } else {
                mostrarotro = false;
            }


            if (viaaerea.getHvactipooxigen() != null && 
                viaaerea.getHvactipooxigen().equals("MO")) {
                mostrarmascara = true;
            } else {
                mostrarmascara = false;
            }


            if (viaaerea.getHvacmetodcontr() != null && 
                viaaerea.getHvacmetodcontr().equals("VA")) {
                mostrarVentilacionasistida = true;
            } else {
                mostrarVentilacionasistida = false;
            }


            if (viaaerea.getHvaccanunasfar() != null && 
                viaaerea.getHvaccanunasfar().equals("S")) {
                selectcanulanaso = true;
            } else {
                selectcanulanaso = false;
            }

            if (viaaerea.getHvacmascafacia() != null && 
                viaaerea.getHvacmascafacia().equals("S")) {
                selectfacial = true;

            } else {
                selectfacial = false;
            }

            if (viaaerea.getHvacotro() != null && 
                viaaerea.getHvacotro().equals("S")) {
                selectotro = true;

            } else {
                selectotro = false;

            }

            if (viaaerea.getHvacintubacion() != null && 
                viaaerea.getHvacintubacion().equals("S")) {
                selectIntubacion = true;

            } else {
                selectIntubacion = false;
            }

            if (viaaerea.getHvacotrodisglo() != null && 
                viaaerea.getHvacotrodisglo().equals("S")) {
                selectotrodispositivo = true;

            } else {
                selectotrodispositivo = false;
            }

            if (viaaerea.getHvacmascalarin() != null && 
                viaaerea.getHvacmascalarin().equals("S")) {
                selectlaringuea = true;
                viaaerea.getHvacmasclarin();
                selectmascaralaringea = viaaerea.getHvacmasclarin();
            } else {
                selectlaringuea = false;
            }

            if (viaaerea.getHvaccanuorofar() != null && 
                viaaerea.getHvaccanuorofar().equals("S")) {
                selectcanulaoro = true;
            } else {
                selectcanulaoro = false;
            }


            if (viaaerea.getHvadhoracolmas() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(viaaerea.getHvadhoracolmas());
                horacolocacion = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutocolocacion = fechaaux.get(Calendar.MINUTE);
            }

            if (viaaerea.getHvadhoraretmas() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(viaaerea.getHvadhoraretmas());
                horaretiro = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoretiro = fechaaux.get(Calendar.MINUTE);
            }


            if (viaaerea.getHvadhoracolotr() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(viaaerea.getHvadhoracolotr());
                horacolocacionotro = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutocolocacionotro = fechaaux.get(Calendar.MINUTE);
            }


            if (viaaerea.getHvadhoraretotr() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(viaaerea.getHvadhoraretotr());
                horaretirootro = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoretirootro = fechaaux.get(Calendar.MINUTE);
            }


            if (viaaerea.getHvadhoraintuba() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(viaaerea.getHvadhoraintuba());
                horaintubacion = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutointubacion = fechaaux.get(Calendar.MINUTE);
            }


            if (viaaerea.getHvadhoraextuba() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(viaaerea.getHvadhoraextuba());
                horaextubacion = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoextubacion = fechaaux.get(Calendar.MINUTE);
            }
            if (viaaerea.getHvacverviarecap() != null) {
                if (viaaerea.getHvacverviarecap().equals("S")) {
                    lstVerifica.add("C");
                }
            }
            if (viaaerea.getHvacverviareaus() != null) {
                if (viaaerea.getHvacverviareaus().equals("S")) {
                    lstVerifica.add("A");
                }
            }
            if (viaaerea.getHvacverviareotr() != null) {
                if (viaaerea.getHvacverviareotr().equals("S")) {
                    lstVerifica.add("O");
                    mostrarotraverificacion = true;
                    if (viaaerea.getHvacotraverifi() != null) {
                        System.out.println(viaaerea.getHvacotraverifi());
                    }
                }
            }
        }
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

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
     * @param viaaerea
     */
    public void setViaaerea(Chventiaerea viaaerea) {
        this.viaaerea = viaaerea;
    }

    /**
     * @return
     */
    public Chventiaerea getViaaerea() {
        return viaaerea;
    }


    /**
     * @param lstCircuito
     */
    public void setLstCircuito(List lstCircuito) {
        this.lstCircuito = lstCircuito;
    }

    /**
     * @return
     */
    public List getLstCircuito() {
        if (lstCircuito.size() == 0) {

            lstCircuito.add(new SelectItem("CC", "Circular Cerrado"));
            lstCircuito.add(new SelectItem("CS", "Circular Semicerrado"));
            lstCircuito.add(new SelectItem("BA", "Bain"));
            lstCircuito.add(new SelectItem("JR", "Jackson-Rees"));
            lstCircuito.add(new SelectItem("OD", "Ox�geno directo"));
            lstCircuito.add(new SelectItem("IN", "Intubaci�n "));
            lstCircuito.add(new SelectItem("OT", "Otro"));
        }
        return lstCircuito;
    }


    /**
     * @param lstTipoOxigenoDirecto
     */
    public void setLstTipoOxigenoDirecto(List lstTipoOxigenoDirecto) {
        this.lstTipoOxigenoDirecto = lstTipoOxigenoDirecto;
    }

    /**
     * @return
     */
    public List getLstTipoOxigenoDirecto() {
        if (lstTipoOxigenoDirecto.size() == 0) {
            lstTipoOxigenoDirecto.add(new SelectItem("MO", 
                                                     "M�scara de Oxigeno"));
            lstTipoOxigenoDirecto.add(new SelectItem("CN", "C�nula Nasal"));
        }
        return lstTipoOxigenoDirecto;
    }

    /**
     * @param lstTipoMascara
     */
    public void setLstTipoMascara(List lstTipoMascara) {
        this.lstTipoMascara = lstTipoMascara;
    }

    /**
     * @return
     */
    public List getLstTipoMascara() {
        if (lstTipoMascara.size() == 0) {
            lstTipoMascara.add(new SelectItem("CR", "Con reservorio"));
            lstTipoMascara.add(new SelectItem("SR", "Sin reservorio"));
        }
        return lstTipoMascara;
    }

    /**
     * @param mostraroxigeno
     */
    public void setMostraroxigeno(boolean mostraroxigeno) {
        this.mostraroxigeno = mostraroxigeno;
    }

    /**
     * @return
     */
    public boolean isMostraroxigeno() {
        return mostraroxigeno;
    }

    /**
     * @param mostrarmascara
     */
    public void setMostrarmascara(boolean mostrarmascara) {
        this.mostrarmascara = mostrarmascara;
    }

    /**
     * @return
     */
    public boolean isMostrarmascara() {
        return mostrarmascara;
    }

    /**
     * @param mostrarotro
     */
    public void setMostrarotro(boolean mostrarotro) {
        this.mostrarotro = mostrarotro;
    }

    /**
     * @return
     */
    public boolean isMostrarotro() {
        return mostrarotro;
    }


    /**
     * @param mnuModoVentilacion
     */
    public void setMnuModoVentilacion(UIInput mnuModoVentilacion) {
        this.mnuModoVentilacion = mnuModoVentilacion;
    }

    /**
     * @return
     */
    public UIInput getMnuModoVentilacion() {
        return mnuModoVentilacion;
    }

    /**
     * @param checkFacial
     */
    public void setCheckFacial(UIInput checkFacial) {
        this.checkFacial = checkFacial;
    }

    /**
     * @return
     */
    public UIInput getCheckFacial() {
        return checkFacial;
    }

    /**
     * @param checkCanual
     */
    public void setCheckCanual(UIInput checkCanual) {
        this.checkCanual = checkCanual;
    }

    /**
     * @return
     */
    public UIInput getCheckCanual() {
        return checkCanual;
    }

    /**
     * @param checkCanulaNaso
     */
    public void setCheckCanulaNaso(UIInput checkCanulaNaso) {
        this.checkCanulaNaso = checkCanulaNaso;
    }

    /**
     * @return
     */
    public UIInput getCheckCanulaNaso() {
        return checkCanulaNaso;
    }

    /**
     * @param checkMascaraLaringuea
     */
    public void setCheckMascaraLaringuea(UIInput checkMascaraLaringuea) {
        this.checkMascaraLaringuea = checkMascaraLaringuea;
    }

    /**
     * @return
     */
    public UIInput getCheckMascaraLaringuea() {
        return checkMascaraLaringuea;
    }

    /**
     * @param checkOtroDispositivo
     */
    public void setCheckOtroDispositivo(UIInput checkOtroDispositivo) {
        this.checkOtroDispositivo = checkOtroDispositivo;
    }

    /**
     * @return
     */
    public UIInput getCheckOtroDispositivo() {
        return checkOtroDispositivo;
    }

    /**
     * @param checkIntubacion
     */
    public void setCheckIntubacion(UIInput checkIntubacion) {
        this.checkIntubacion = checkIntubacion;
    }

    /**
     * @return
     */
    public UIInput getCheckIntubacion() {
        return checkIntubacion;
    }

    /**
     * @param checkOtro
     */
    public void setCheckOtro(UIInput checkOtro) {
        this.checkOtro = checkOtro;
    }

    /**
     * @return
     */
    public UIInput getCheckOtro() {
        return checkOtro;
    }

    /**
     * @param lstTipoControl
     */
    public void setLstTipoControl(List lstTipoControl) {
        this.lstTipoControl = lstTipoControl;
    }

    /**
     * @return
     */
    public List getLstTipoControl() {
        if (lstTipoControl.size() == 0) {
            lstTipoControl.add(new SelectItem("F", "F�cil"));
            lstTipoControl.add(new SelectItem("D", "Dif�cil"));
        }
        return lstTipoControl;
    }

    /**
     * @param lstVerificacion
     */
    public void setLstVerificacion(List lstVerificacion) {
        this.lstVerificacion = lstVerificacion;
    }

    /**
     * @return
     */
    public List getLstVerificacion() {
        if (lstVerificacion.size() == 0) {

            lstVerificacion.add(new SelectItem("C", "Capnograf�a"));
            lstVerificacion.add(new SelectItem("A", "Auscultaci�n"));
            lstVerificacion.add(new SelectItem("O", "Otra"));

        }
        return lstVerificacion;
    }

    /**
     * @param mostrardificultades
     */
    public void setMostrardificultades(boolean mostrardificultades) {
        this.mostrardificultades = mostrardificultades;
    }

    /**
     * @return
     */
    public boolean isMostrardificultades() {
        return mostrardificultades;
    }

    /**
     * @param mostrarotraverificacion
     */
    public void setMostrarotraverificacion(boolean mostrarotraverificacion) {
        this.mostrarotraverificacion = mostrarotraverificacion;
    }

    /**
     * @return
     */
    public boolean isMostrarotraverificacion() {
        return mostrarotraverificacion;
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
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param lstMetodoControl
     */
    public void setLstMetodoControl(List lstMetodoControl) {
        this.lstMetodoControl = lstMetodoControl;
    }

    /**
     * @return
     */
    public List getLstMetodoControl() {
        if (lstMetodoControl.size() == 0) {
            lstMetodoControl.add(new SelectItem("VE", 
                                                "Ventilaci�n espontanea."));
            lstMetodoControl.add(new SelectItem("VA", 
                                                "Ventilaci�n asistida/controlada"));

            lstMetodoControl.add(new SelectItem("MA", "Ventilaci�n Manual"));

            lstMetodoControl.add(new SelectItem("ME", "Ventilaci�n Mecanica"));
        }
        return lstMetodoControl;
    }

    /**
     * @param mostrarVentilacionasistida
     */
    public void setMostrarVentilacionasistida(boolean mostrarVentilacionasistida) {
        this.mostrarVentilacionasistida = mostrarVentilacionasistida;
    }

    /**
     * @return
     */
    public boolean isMostrarVentilacionasistida() {
        return mostrarVentilacionasistida;
    }

    /**
     * @param selectfacial
     */
    public void setSelectfacial(boolean selectfacial) {
        this.selectfacial = selectfacial;
    }

    /**
     * @return
     */
    public boolean isSelectfacial() {
        return selectfacial;
    }

    /**
     * @param selectcanulaoro
     */
    public void setSelectcanulaoro(boolean selectcanulaoro) {
        this.selectcanulaoro = selectcanulaoro;
    }

    /**
     * @return
     */
    public boolean isSelectcanulaoro() {
        return selectcanulaoro;
    }

    /**
     * @param selectcanulanaso
     */
    public void setSelectcanulanaso(boolean selectcanulanaso) {
        this.selectcanulanaso = selectcanulanaso;
    }

    /**
     * @return
     */
    public boolean isSelectcanulanaso() {
        return selectcanulanaso;
    }

    /**
     * @param selectlaringuea
     */
    public void setSelectlaringuea(boolean selectlaringuea) {
        this.selectlaringuea = selectlaringuea;
    }

    /**
     * @return
     */
    public boolean isSelectlaringuea() {
        return selectlaringuea;
    }

    /**
     * @param selectotrodispositivo
     */
    public void setSelectotrodispositivo(boolean selectotrodispositivo) {
        this.selectotrodispositivo = selectotrodispositivo;
    }

    /**
     * @return
     */
    public boolean isSelectotrodispositivo() {
        return selectotrodispositivo;
    }

    /**
     * @param selectIntubacion
     */
    public void setSelectIntubacion(boolean selectIntubacion) {
        this.selectIntubacion = selectIntubacion;
    }

    /**
     * @return
     */
    public boolean isSelectIntubacion() {
        return selectIntubacion;
    }

    /**
     * @param selectotro
     */
    public void setSelectotro(boolean selectotro) {
        this.selectotro = selectotro;
    }

    /**
     * @return
     */
    public boolean isSelectotro() {
        return selectotro;
    }

    /**
     * @param lstModoVentilacion
     */
    public void setLstModoVentilacion(List lstModoVentilacion) {
        this.lstModoVentilacion = lstModoVentilacion;
    }

    /**
     * @return
     */
    public List getLstModoVentilacion() {
        if (lstModoVentilacion.size() == 0) {
            lstModoVentilacion.add(new SelectItem("M", "Manual"));
            lstModoVentilacion.add(new SelectItem("E", "Mec�nica"));
        }
        return lstModoVentilacion;
    }

    /**
     * @param mostrarventilacionmecanica
     */
    public void setMostrarventilacionmecanica(boolean mostrarventilacionmecanica) {
        this.mostrarventilacionmecanica = mostrarventilacionmecanica;
    }

    /**
     * @return
     */
    public boolean isMostrarventilacionmecanica() {
        return mostrarventilacionmecanica;
    }

    /**
     * @param lstMinutos
     */
    public void setLstMinutos(List lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List getLstMinutos() {
        if (lstMinutos.size() == 0) {
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem(00, "00"));
            lstMinutos.add(new SelectItem(01, "01"));
            lstMinutos.add(new SelectItem(02, "02"));
            lstMinutos.add(new SelectItem(03, "03"));
            lstMinutos.add(new SelectItem(04, "04"));
            lstMinutos.add(new SelectItem(05, "05"));
            lstMinutos.add(new SelectItem(06, "06"));
            lstMinutos.add(new SelectItem(07, "07"));
            lstMinutos.add(new SelectItem(10, "10"));
            lstMinutos.add(new SelectItem(11, "11"));
            lstMinutos.add(new SelectItem(12, "12"));
            lstMinutos.add(new SelectItem(13, "13"));
            lstMinutos.add(new SelectItem(14, "14"));
            lstMinutos.add(new SelectItem(15, "15"));
            lstMinutos.add(new SelectItem(16, "16"));
            lstMinutos.add(new SelectItem(17, "17"));
            lstMinutos.add(new SelectItem(18, "18"));
            lstMinutos.add(new SelectItem(19, "19"));
            lstMinutos.add(new SelectItem(20, "20"));
            lstMinutos.add(new SelectItem(21, "21"));
            lstMinutos.add(new SelectItem(22, "22"));
            lstMinutos.add(new SelectItem(23, "23"));
            lstMinutos.add(new SelectItem(24, "24"));
            lstMinutos.add(new SelectItem(25, "25"));
            lstMinutos.add(new SelectItem(26, "26"));
            lstMinutos.add(new SelectItem(27, "27"));
            lstMinutos.add(new SelectItem(28, "28"));
            lstMinutos.add(new SelectItem(29, "29"));
            lstMinutos.add(new SelectItem(30, "30"));
            lstMinutos.add(new SelectItem(31, "31"));
            lstMinutos.add(new SelectItem(32, "32"));
            lstMinutos.add(new SelectItem(33, "33"));
            lstMinutos.add(new SelectItem(34, "34"));
            lstMinutos.add(new SelectItem(35, "35"));
            lstMinutos.add(new SelectItem(36, "36"));
            lstMinutos.add(new SelectItem(37, "37"));
            lstMinutos.add(new SelectItem(38, "38"));
            lstMinutos.add(new SelectItem(39, "39"));
            lstMinutos.add(new SelectItem(40, "40"));
            lstMinutos.add(new SelectItem(42, "41"));
            lstMinutos.add(new SelectItem(43, "43"));
            lstMinutos.add(new SelectItem(44, "44"));
            lstMinutos.add(new SelectItem(45, "45"));
            lstMinutos.add(new SelectItem(46, "46"));
            lstMinutos.add(new SelectItem(47, "47"));
            lstMinutos.add(new SelectItem(48, "48"));
            lstMinutos.add(new SelectItem(49, "49"));
            lstMinutos.add(new SelectItem(50, "50"));
            lstMinutos.add(new SelectItem(51, "51"));
            lstMinutos.add(new SelectItem(52, "52"));
            lstMinutos.add(new SelectItem(53, "53"));
            lstMinutos.add(new SelectItem(54, "54"));
            lstMinutos.add(new SelectItem(55, "55"));
            lstMinutos.add(new SelectItem(56, "56"));
            lstMinutos.add(new SelectItem(57, "57"));
            lstMinutos.add(new SelectItem(58, "58"));
            lstMinutos.add(new SelectItem(59, "59"));
        }
        return lstMinutos;
    }

    /**
     * @param horacolocacion
     */
    public void setHoracolocacion(Integer horacolocacion) {
        this.horacolocacion = horacolocacion;
    }

    /**
     * @return
     */
    public Integer getHoracolocacion() {
        return horacolocacion;
    }

    /**
     * @param minutocolocacion
     */
    public void setMinutocolocacion(Integer minutocolocacion) {
        this.minutocolocacion = minutocolocacion;
    }

    /**
     * @return
     */
    public Integer getMinutocolocacion() {
        return minutocolocacion;
    }

    /**
     * @param horaretiro
     */
    public void setHoraretiro(Integer horaretiro) {
        this.horaretiro = horaretiro;
    }

    /**
     * @return
     */
    public Integer getHoraretiro() {
        return horaretiro;
    }

    /**
     * @param minutoretiro
     */
    public void setMinutoretiro(Integer minutoretiro) {
        this.minutoretiro = minutoretiro;
    }

    /**
     * @return
     */
    public Integer getMinutoretiro() {
        return minutoretiro;
    }

    /**
     * @param horacolocacionotro
     */
    public void setHoracolocacionotro(Integer horacolocacionotro) {
        this.horacolocacionotro = horacolocacionotro;
    }

    /**
     * @return
     */
    public Integer getHoracolocacionotro() {
        return horacolocacionotro;
    }

    /**
     * @param minutocolocacionotro
     */
    public void setMinutocolocacionotro(Integer minutocolocacionotro) {
        this.minutocolocacionotro = minutocolocacionotro;
    }

    /**
     * @return
     */
    public Integer getMinutocolocacionotro() {
        return minutocolocacionotro;
    }

    /**
     * @param horaretirootro
     */
    public void setHoraretirootro(Integer horaretirootro) {
        this.horaretirootro = horaretirootro;
    }

    /**
     * @return
     */
    public Integer getHoraretirootro() {
        return horaretirootro;
    }

    /**
     * @param minutoretirootro
     */
    public void setMinutoretirootro(Integer minutoretirootro) {
        this.minutoretirootro = minutoretirootro;
    }

    /**
     * @return
     */
    public Integer getMinutoretirootro() {
        return minutoretirootro;
    }

    /**
     * @param horaintubacion
     */
    public void setHoraintubacion(Integer horaintubacion) {
        this.horaintubacion = horaintubacion;
    }

    /**
     * @return
     */
    public Integer getHoraintubacion() {
        return horaintubacion;
    }

    /**
     * @param horaextubacion
     */
    public void setHoraextubacion(Integer horaextubacion) {
        this.horaextubacion = horaextubacion;
    }

    /**
     * @return
     */
    public Integer getHoraextubacion() {
        return horaextubacion;
    }

    /**
     * @param minutointubacion
     */
    public void setMinutointubacion(Integer minutointubacion) {
        this.minutointubacion = minutointubacion;
    }

    /**
     * @return
     */
    public Integer getMinutointubacion() {
        return minutointubacion;
    }

    /**
     * @param minutoextubacion
     */
    public void setMinutoextubacion(Integer minutoextubacion) {
        this.minutoextubacion = minutoextubacion;
    }

    /**
     * @return
     */
    public Integer getMinutoextubacion() {
        return minutoextubacion;
    }

    /**
     * @param lstVistaLaringoscopia
     */
    public void setLstVistaLaringoscopia(List lstVistaLaringoscopia) {
        this.lstVistaLaringoscopia = lstVistaLaringoscopia;
    }

    /**
     * @return
     */
    public List getLstVistaLaringoscopia() {
        if (lstVistaLaringoscopia.size() == 0) {

            lstVistaLaringoscopia.add(new SelectItem("I", "I"));
            lstVistaLaringoscopia.add(new SelectItem("II", "II"));
            lstVistaLaringoscopia.add(new SelectItem("III", "III"));
            lstVistaLaringoscopia.add(new SelectItem("IV", "IV"));
        }
        return lstVistaLaringoscopia;
    }

    /**
     * @return
     */
    public List getListHora() {
        if (listHora.size() == 0) {
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem(0, "00"));
            listHora.add(new SelectItem(5, "05"));
            listHora.add(new SelectItem(6, "06"));
            listHora.add(new SelectItem(7, "07"));
            listHora.add(new SelectItem(8, "08"));
            listHora.add(new SelectItem(9, "09"));
            listHora.add(new SelectItem(10, "10"));
            listHora.add(new SelectItem(11, "11"));
            listHora.add(new SelectItem(12, "12"));
            listHora.add(new SelectItem(13, "13"));
            listHora.add(new SelectItem(14, "14"));
            listHora.add(new SelectItem(15, "15"));
            listHora.add(new SelectItem(16, "16"));
            listHora.add(new SelectItem(17, "17"));
            listHora.add(new SelectItem(18, "18"));
            listHora.add(new SelectItem(19, "19"));
            listHora.add(new SelectItem(20, "20"));
            listHora.add(new SelectItem(21, "21"));
            listHora.add(new SelectItem(22, "22"));
            listHora.add(new SelectItem(23, "23"));
            listHora.add(new SelectItem(24, "24"));

        }
        return listHora;
    }

    /**
     * @param listHora
     */
    public void setListHora(List listHora) {
        this.listHora = listHora;
    }

    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void changeCircuitoAdministracion() {
        if (viaaerea != null) {
            if (viaaerea.getHvaccircuoxige() != null && 
                viaaerea.getHvaccircuoxige().equals("OD")) {
                mostraroxigeno = true;
            } else {
                mostraroxigeno = false;
                mostrarmascara = false;
                viaaerea.setHvactipomascar(null);
                viaaerea.setHvactipooxigen(null);

            }


            if (viaaerea != null && viaaerea.getHvaccircuoxige() != null && 
                viaaerea.getHvaccircuoxige().equals("OT")) {
                mostrarotro = true;
            } else {
                mostrarotro = false;
                viaaerea.setHvacotrooxigen(null);
            }
        }

    }


    public void changeTipoOxigeno() {
        if (viaaerea != null) {
            if (viaaerea.getHvactipooxigen() != null && 
                viaaerea.getHvactipooxigen().equals("MO")) {
                mostrarmascara = true;
            } else {
                viaaerea.setHvactipomascar(null);
                mostrarmascara = false;
            }
        }

    }

    public void changeControlViaAerea() {
        if (viaaerea != null) {
            if (viaaerea.getHvaccontviarea() != null && 
                viaaerea.getHvaccontviarea().equals("D")) {
                mostrardificultades = true;
            } else {
                viaaerea.setHvacviadificil(null);
                mostrardificultades = false;

            }
        }

    }

    public void changeVerificacion() {
        if (viaaerea != null) {
            if (viaaerea.getHvacverifviare() != null && 
                viaaerea.getHvacverifviare().equals("O")) {
                mostrarotraverificacion = true;
            } else {
                viaaerea.setHvacotraverifi(null);
                mostrarotraverificacion = false;
            }
        }
    }

    public void changeVerifica() {
        mostrarotraverificacion = false;
        if (!lstVerifica.isEmpty()) {
            for (String aux: lstVerifica) {
                if (aux.equals("O")) {
                    mostrarotraverificacion = true;
                }
            }
        }
    }

    public void changeTipoVentilacion() {
        if (viaaerea != null && viaaerea.getHvacmetodcontr() != null && 
            viaaerea.getHvacmetodcontr().equals("VA")) {
            mostrarVentilacionasistida = true;
        } else {
            selectfacial = false;
            selectcanulaoro = false;
            selectcanulanaso = false;
            selectlaringuea = false;
            selectotrodispositivo = false;
            selectIntubacion = false;
            selectotro = false;
            changeCanulaOro();
            changeMascaraLaringuea();
            changeOtroDispositivo();
            changeIntubacion();
            changeOtraDescripcion();
            viaaerea.setHvanmecanfrecu(null);
            viaaerea.setHvanmecanvolum(null);
            viaaerea.setHvacmecanventi(null);
            viaaerea.setHvacmodoventil(null);
            mnuModoVentilacion.setValue(null);
            mostrarventilacionmecanica = false;
            mostrarVentilacionasistida = false;
        }
    }


    public void changeModoVentilacion() {
        if (viaaerea != null && viaaerea.getHvacmodoventil() != null && 
            viaaerea.getHvacmodoventil().equals("E")) {
            mostrarventilacionmecanica = true;
        } else {
            viaaerea.setHvanmecanfrecu(null);
            viaaerea.setHvanmecanvolum(null);
            viaaerea.setHvacmecanventi(null);
            mostrarventilacionmecanica = false;
        }
    }

    public void changeCanulaOro() {
        if (selectcanulaoro) {
            viaaerea.setHvaccanuorofar("S");
        } else {
            viaaerea.setHvancanulfarin(null);
            viaaerea.setHvaccanuorofar("N");
        }
    }

    public void changeMascaraLaringuea() {
        if (selectlaringuea) {
            viaaerea.setHvacmascalarin("S");
            viaaerea.setHvadhoracolmas(new Date());
            viaaerea.setHvadhoraretmas(new Date());

        } else {
            viaaerea.setHvacmascaclasi(null);
            viaaerea.setHvacmascafastr(null);
            viaaerea.setHvacmascaprose(null);
            viaaerea.setHvacmascasupre(null);
            viaaerea.setHvadhoracolmas(null);
            viaaerea.setHvadhoracolmas(null);
            viaaerea.setHvadhoraretmas(null);
            horacolocacion = null;
            minutocolocacion = null;
            viaaerea.setHvadhoraretmas(null);
            horaretiro = null;
            minutoretiro = null;
            viaaerea.setHvacmascalarin("N");
            checkFacial.setValue(null);
            checkCanual.setValue(null);
            checkCanulaNaso.setValue(null);
            checkMascaraLaringuea.setValue(null);
            checkOtroDispositivo.setValue(null);
            checkIntubacion.setValue(null);
            checkOtro.setValue(null);
        }
    }

    public void changeOtroDispositivo() {
        if (selectotrodispositivo) {
            viaaerea.setHvacotrodisglo("S");
            viaaerea.setHvadhoracolotr(new Date());
            viaaerea.setHvadhoraretotr(new Date());
        } else {
            viaaerea.setHvacotrodispos(null);
            viaaerea.setHvadhoracolotr(null);
            horacolocacionotro = null;
            minutocolocacionotro = null;
            viaaerea.setHvadhoraretotr(null);
            horaretirootro = null;
            minutoretirootro = null;
            viaaerea.setHvacotrodisglo("N");
            viaaerea.setHvadhoracolotr(null);
            viaaerea.setHvadhoraretotr(null);

        }
    }

    public void changeIntubacion() {
        if (selectIntubacion) {
            viaaerea.setHvacintubacion("S");
            viaaerea.setHvadhoraintuba(new Date());
            viaaerea.setHvadhoraextuba(new Date());
        } else {
            viaaerea.setHvanintuborotr(null);
            viaaerea.setHvanintubnasot(null);
            viaaerea.setHvacvistalarin(null);
            viaaerea.setHvadhoraintuba(null);
            viaaerea.setHvadhoraintuba(null);
            viaaerea.setHvadhoraextuba(null);
            horaintubacion = null;
            minutointubacion = null;
            viaaerea.setHvadhoraextuba(null);
            horaextubacion = null;
            minutoextubacion = null;
            viaaerea.setHvacintubacion("N");
        }
    }

    public void changeOtraDescripcion() {
        if (selectotro) {
            viaaerea.setHvacotro("S");
        } else {
            viaaerea.setHvacmetoconvia(null);
            viaaerea.setHvacotro("N");
        }
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvaccircuoxige(ValueChangeEvent valueChangeEvent) {
        viaaerea.setHvaccircuoxige((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvactipooxigen(ValueChangeEvent valueChangeEvent) {
        viaaerea.setHvactipooxigen((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHvaccontviarea(ValueChangeEvent valueChangeEvent) {
        viaaerea.setHvaccontviarea((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHvacverifviare(ValueChangeEvent valueChangeEvent) {
        viaaerea.setHvacverifviare((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHvacmetodcontr(ValueChangeEvent valueChangeEvent) {
        viaaerea.setHvacmetodcontr((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHvacmodoventil(ValueChangeEvent valueChangeEvent) {
        viaaerea.setHvacmodoventil((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setSelectcanulaoro(ValueChangeEvent valueChangeEvent) {
        setSelectcanulaoro((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setSelectlaringuea(ValueChangeEvent valueChangeEvent) {
        setSelectlaringuea((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setSelectotrodispositivo(ValueChangeEvent valueChangeEvent) {
        setSelectotrodispositivo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setSelectIntubacion(ValueChangeEvent valueChangeEvent) {
        setSelectIntubacion((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setSelectotro(ValueChangeEvent valueChangeEvent) {
        setSelectotro((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    //-----------------------------------------------------------------------
    //  Boton Principal 
    //----------------------------------------------------------------------- 

    /**
     * @return
     */
    public

    String RegistrarViaAerea() {
        navegationRule = "";
        boolean wexito;
        wexito = true;
        ChventiaereaPK id;
        id = new ChventiaereaPK();
        id.setHvalnumero(numeroCirugia);
        id.setHvactiposervi(tipoServicio);
        viaaerea.setId(id);
        viaaerea.setHvacoperador(userName());
        viaaerea.setHvadfecregistr(new Date());
        viaaerea.setHvanclinica(this.getClinica().getCclncodigo());

        if (selectIntubacion) {
            if (viaaerea == null || viaaerea.getHvanintuborotr() == null || 
                (viaaerea.getHvanintuborotr().compareTo(new BigDecimal(10)) >= 
                 0)) {
                FacesUtils.addErrorMessage("body:formControlViaAerea:panelTabControlViaAerea:itOrotraqueal", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
                wexito = false;
            }

            if (viaaerea == null || viaaerea.getHvanintubnasot() == null || 
                (viaaerea.getHvanintubnasot().compareTo(new BigDecimal(10)) >= 
                 0)) {
                FacesUtils.addErrorMessage("body:formControlViaAerea:panelTabControlViaAerea:itNasotraqueal", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
                wexito = false;
            }
        }

        if (selectlaringuea) {

            if (viaaerea == null || viaaerea.getHvacmasclarin() == null ) {
                FacesUtils.addErrorMessage("body:formControlViaAerea:panelTabControlViaAerea:itMascaraSelect", 
                                           MSG_VALOR_CAMPO_INCORRECTO);
                wexito = false;
            }
        }


        if (selectcanulanaso) {
            viaaerea.setHvaccanunasfar("S");
        } else {
            viaaerea.setHvaccanunasfar("N");
        }

        if (selectfacial) {
            viaaerea.setHvacmascafacia("S");
        } else {
            viaaerea.setHvacmascafacia("N");
        }


        if (viaaerea.getHvadhoracolmas() != null && horacolocacion != null && 
            minutocolocacion != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(viaaerea.getHvadhoracolmas());
            fechaaux.set(Calendar.HOUR, horacolocacion);
            fechaaux.set(Calendar.MINUTE, minutocolocacion);
            viaaerea.setHvadhoracolmas(fechaaux.getTime());
        }


        if (viaaerea.getHvadhoraretmas() != null && horaretiro != null && 
            minutoretiro != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(viaaerea.getHvadhoraretmas());
            fechaaux.set(Calendar.HOUR, horaretiro);
            fechaaux.set(Calendar.MINUTE, minutoretiro);
            viaaerea.setHvadhoraretmas(fechaaux.getTime());
        }


        if (viaaerea.getHvadhoracolotr() != null && 
            horacolocacionotro != null && minutocolocacionotro != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(viaaerea.getHvadhoracolotr());
            fechaaux.set(Calendar.HOUR, horacolocacionotro);
            fechaaux.set(Calendar.MINUTE, minutocolocacionotro);
            viaaerea.setHvadhoracolotr(fechaaux.getTime());
        }


        if (viaaerea.getHvadhoraretotr() != null && horaretirootro != null && 
            minutoretirootro != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(viaaerea.getHvadhoraretotr());
            fechaaux.set(Calendar.HOUR, horaretirootro);
            fechaaux.set(Calendar.MINUTE, minutoretirootro);
            viaaerea.setHvadhoraretotr(fechaaux.getTime());
        }


        if (viaaerea.getHvadhoraintuba() != null && horaintubacion != null && 
            minutointubacion != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(viaaerea.getHvadhoraintuba());
            fechaaux.set(Calendar.HOUR, horaintubacion);
            fechaaux.set(Calendar.MINUTE, minutointubacion);
            viaaerea.setHvadhoraintuba(fechaaux.getTime());
        }


        if (viaaerea.getHvadhoraextuba() != null && horaextubacion != null && 
            minutoextubacion != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(viaaerea.getHvadhoraextuba());
            fechaaux.set(Calendar.HOUR, horaextubacion);
            fechaaux.set(Calendar.MINUTE, minutoextubacion);
            viaaerea.setHvadhoraextuba(fechaaux.getTime());
        }
        if (lstVerifica != null && !lstVerifica.isEmpty()) {
            viaaerea.setHvacverviarecap("N");
            viaaerea.setHvacverviareaus("N");
            viaaerea.setHvacverviareotr("N");
        }

        if (lstVerifica != null && !lstVerifica.isEmpty()) {
            for (String codaux: lstVerifica) {
                if (codaux.equals("C")) {
                    viaaerea.setHvacverviarecap("S");
                } else if (codaux.equals("A")) {
                    viaaerea.setHvacverviareaus("S");
                } else if (codaux.equals("O")) {
                    viaaerea.setHvacverviareotr("S");
                }
            }
        }


        if (wexito) {
            try {

                this.serviceLocator.getClinicoService().saveControlViaAerea(viaaerea);
                FacesUtils.addInfoMessage(MSG_ADICION);
                if (renderOtrasCirugias) {
                    navegationRule = "irRegistrarTecnicaAnestesia";
                } else {
                    navegationRule = "irCerrarAnestesia";
                }

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
            return navegationRule;
        }

        return BeanNavegacion.RUTA_ACTUAL;
    }

    public void changeMascaraLaringea() {
        if (selectmascaralaringea != null && 
            selectmascaralaringea.equals("CL")) {
            viaaerea.setHvacmasclarin(selectmascaralaringea);
        } else if (selectmascaralaringea != null && 
                   selectmascaralaringea.equals("PR")) {
            viaaerea.setHvacmasclarin(selectmascaralaringea);
        } else if (selectmascaralaringea != null && 
                   selectmascaralaringea.equals("FA")) {
            viaaerea.setHvacmasclarin(selectmascaralaringea);
        } else if (selectmascaralaringea != null && 
                   selectmascaralaringea.equals("SU")) {
            viaaerea.setHvacmasclarin(selectmascaralaringea);
        }
    }

    public void mostrarBuscadorPlantilla() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
            buscador.setNombreBeanAnterior("registrarControlViaAereaBean");
            buscador.setTagRenderizar("panelGridControlViaAereaTab");
        }
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        renderPlantilla = true;
    }

    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            viaaerea.setHvacobserviare(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
    }


    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    public String getNavegationRule() {
        return navegationRule;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }

    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }

    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setLstVerifica(List<String> lstVerifica) {
        this.lstVerifica = lstVerifica;
    }

    public List<String> getLstVerifica() {
        return lstVerifica;
    }

    /**
     * @param valueChangeEvent
     */
    public void setLstVerifica(ValueChangeEvent valueChangeEvent) {
        setLstVerifica((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setSelectmascaralaringea(String selectmascaralaringea) {
        this.selectmascaralaringea = selectmascaralaringea;
    }

    public String getSelectmascaralaringea() {
        return selectmascaralaringea;
    }

    /**
     * @param valueChangeEvent
     */
    public void setSelectmascaralaringea(ValueChangeEvent valueChangeEvent) {
        setSelectmascaralaringea((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstmasclaringea(List lstmasclaringea) {
        this.lstmasclaringea = lstmasclaringea;
    }

    public List getLstmasclaringea() {
        if (lstmasclaringea.size() == 0) {
            lstmasclaringea.add(new SelectItem("CL", "Cl�sica"));
            lstmasclaringea.add(new SelectItem("PR", "Proseal"));
            lstmasclaringea.add(new SelectItem("FA", "Fastrach"));
            lstmasclaringea.add(new SelectItem("SU", "Supreme"));
        }
        return lstmasclaringea;
    }
}
