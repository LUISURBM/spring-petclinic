//=======================================================================
// ARCHIVO RegistrarSignosVitalesAnestesiaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================

package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.ChsignovitalPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarSignosVitalesAnestesiaBean
//=======================================================================
public class RegistrarSignosVitalesAnestesiaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List lstIntervalo;


    private List lstTiempoIntervalo;

    private Integer tiempointervalo;

    private boolean mostrarIntervalo;

    private String intervaloselect;

    private Date fechaInicio;

    private List listHora;

    private List lstMinutos;

    private Integer horaSelect;

    private Integer minutoSelect;
    
    private Integer horaNuevaSelect; 
    
    private Integer minutoNuevoSelect; 

    private HtmlDataTable dtSignosVitales;

    private Integer numeroDocumento;

    private Integer tipoDocumento;

    private Long numeroUsuario;

    private Long numeroCirugia;

    private List lstTipoRespiracion;

    // CAMPOS DE SIGNOS VITALES


    private Chanestesia anestesia;

    private Chcirugprogr cirugia;

    private List lstCirugias;

    private List<Chsignovital> lstSignoVital;

    private boolean selectFrecuencia0;

    private boolean selectFrecuencia10;

    private boolean selectFrecuencia20;

    private boolean selectFrecuencia30;

    private boolean selectFrecuencia40;

    private boolean selectFrecuencia50;

    private boolean selectFrecuencia60;

    private boolean selectFrecuencia70;

    private boolean selectFrecuencia80;

    private boolean selectFrecuencia90;

    private boolean selectFrecuencia100;

    private boolean selectFrecuencia110;

    private boolean selectFrecuencia120;

    private boolean selectFrecuencia130;

    private boolean selectFrecuencia140;

    private boolean selectFrecuencia150;

    private boolean selectFrecuencia160;

    private boolean selectFrecuencia170;

    private boolean selectFrecuencia180;

    private boolean selectFrecuencia190;

    private boolean selectFrecuencia200;

    private boolean selectFrecuencia210;

    private boolean selectPresionSistole0;

    private boolean selectPresionSistole10;

    private boolean selectPresionSistole20;

    private boolean selectPresionSistole30;

    private boolean selectPresionSistole40;

    private boolean selectPresionSistole50;

    private boolean selectPresionSistole60;

    private boolean selectPresionSistole70;

    private boolean selectPresionSistole80;

    private boolean selectPresionSistole90;

    private boolean selectPresionSistole100;

    private boolean selectPresionSistole110;

    private boolean selectPresionSistole120;

    private boolean selectPresionSistole130;

    private boolean selectPresionSistole140;

    private boolean selectPresionSistole150;

    private boolean selectPresionSistole160;

    private boolean selectPresionSistole170;

    private boolean selectPresionSistole180;

    private boolean selectPresionSistole190;

    private boolean selectPresionSistole200;

    private boolean selectPresionSistole210;


    private boolean selectPresionDiastole0;

    private boolean selectPresionDiastole10;

    private boolean selectPresionDiastole20;

    private boolean selectPresionDiastole30;

    private boolean selectPresionDiastole40;

    private boolean selectPresionDiastole50;

    private boolean selectPresionDiastole60;

    private boolean selectPresionDiastole70;

    private boolean selectPresionDiastole80;

    private boolean selectPresionDiastole90;

    private boolean selectPresionDiastole100;

    private boolean selectPresionDiastole110;

    private boolean selectPresionDiastole120;

    private boolean selectPresionDiastole130;

    private boolean selectPresionDiastole140;

    private boolean selectPresionDiastole150;

    private boolean selectPresionDiastole160;

    private boolean selectPresionDiastole170;

    private boolean selectPresionDiastole180;

    private boolean selectPresionDiastole190;

    private boolean selectPresionDiastole200;

    private boolean selectPresionDiastole210;
    
    private boolean renderVistaClasica;


    private boolean selectPeco0;

    private boolean selectPeco10;

    private boolean selectPeco20;

    private boolean selectPeco30;

    private boolean selectPeco40;

    private boolean selectPeco50;

    private boolean selectPeco60;

    private boolean selectPeco70;

    private boolean selectPeco80;

    private boolean selectPeco90;

    private boolean selectPeco100;

    private boolean selectPeco110;

    private boolean selectPeco120;

    private boolean selectPeco130;

    private boolean selectPeco140;

    private boolean selectPeco150;

    private boolean selectPeco160;

    private boolean selectPeco170;

    private boolean selectPeco180;

    private boolean selectPeco190;

    private boolean selectPeco200;

    private boolean selectPeco210;


    private boolean selectSaturacion0;

    private boolean selectSaturacion10;

    private boolean selectSaturacion20;

    private boolean selectSaturacion30;

    private boolean selectSaturacion40;

    private boolean selectSaturacion50;

    private boolean selectSaturacion60;

    private boolean selectSaturacion70;

    private boolean selectSaturacion80;

    private boolean selectSaturacion90;

    private boolean selectSaturacion100;

    private boolean selectSaturacion110;

    private boolean selectSaturacion120;

    private boolean selectSaturacion130;

    private boolean selectSaturacion140;

    private boolean selectSaturacion150;

    private boolean selectSaturacion160;

    private boolean selectSaturacion170;

    private boolean selectSaturacion180;

    private boolean selectSaturacion190;

    private boolean selectSaturacion200;

    private boolean selectSaturacion210;

    private Integer valorSelectFrecuencia;

    private Integer valorSelectDiastole;

    private Integer valorSelectSistole;

    private Integer valorSelectPeco;

    private Integer valorSelectSaturacion;

    private List lstDigitos;

    private Integer digitoFC;

    private Integer digitoSistolica;

    private Integer digitoDiastolica;

    private Integer digitoPeco;

    private Integer digitoSaturacion;

    private String tipoRespiracion;
    
    private Integer frecuenciaCardiacaNuevo;

    private Integer sistolicaNuevo;

    private Integer diastolicaNuevo;

    private Integer pecoNuevo;

    private Integer saturacionNuevo;

    private String respiracionNuevo;
    
    
    private String navigationRule;
    
    private String vistaClasica; 
    
    private List lstTipoVista; 
    
    private String modificarHoraInicial; 
    
    private List lstOpciones;
    
    private boolean renderHoraNueva;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarSignosVitalesAnestesiaBean() {
    }

    public void init() {
        lstIntervalo = new ArrayList();
        lstTiempoIntervalo = new ArrayList();
        lstMinutos = new ArrayList();
        listHora = new ArrayList();

        lstTipoRespiracion = new ArrayList();
        anestesia = new Chanestesia();
        lstSignoVital = new ArrayList<Chsignovital>();
        fechaInicio = new Date();
        modificarHoraInicial = "N";
        

        cargarDatos();
    }

    public void cargarDatos() {

        dtSignosVitales = new HtmlDataTable();
        
        renderVistaClasica = true; 
        vistaClasica = "C";
        
        
        if (numeroCirugia != null) {
            try {
                lstSignoVital = 
                        serviceLocator.getCirugiaService().getSignosVitalesAnestesia(numeroCirugia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (lstSignoVital == null || lstSignoVital.isEmpty()) {
            lstSignoVital = new ArrayList<Chsignovital>();
        } else {
            Chsignovital signosAux = lstSignoVital.get(0);
            if (signosAux != null) {
                fechaInicio = signosAux.getHsvdfechaactiv();
                Calendar fechaAux = Calendar.getInstance();
                fechaAux.setTime(fechaInicio);
                horaSelect = fechaAux.get(Calendar.HOUR_OF_DAY);
                minutoSelect = fechaAux.get(Calendar.MINUTE);
            }
        }
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param lstIntervalo
     */
    public void setLstIntervalo(List lstIntervalo) {
        this.lstIntervalo = lstIntervalo;
    }

    /**
     * @return
     */
    public List getLstIntervalo() {
        if (lstIntervalo.size() == 0) {
            lstIntervalo.add(new SelectItem("A", "Automatico"));
            lstIntervalo.add(new SelectItem("M", "Manual"));
        }
        return lstIntervalo;
    }


    /**
     * @param lstTiempoIntervalo
     */
    public void setLstTiempoIntervalo(List lstTiempoIntervalo) {
        this.lstTiempoIntervalo = lstTiempoIntervalo;
    }

    /**
     * @return
     */
    public List getLstTiempoIntervalo() {
        if (lstTiempoIntervalo.size() == 0) {

            lstTiempoIntervalo.add(new SelectItem(1, "01"));
            lstTiempoIntervalo.add(new SelectItem(2, "02"));
            lstTiempoIntervalo.add(new SelectItem(3, "03"));
            lstTiempoIntervalo.add(new SelectItem(4, "04"));
        }
        return lstTiempoIntervalo;
    }

    /**
     * @param tiempointervalo
     */
    public void setTiempointervalo(Integer tiempointervalo) {
        this.tiempointervalo = tiempointervalo;
    }

    /**
     * @return
     */
    public Integer getTiempointervalo() {
        return tiempointervalo;
    }


    /**
     * @param tipoRespiracion
     */
    public void setTipoRespiracion(String tipoRespiracion) {
        this.tipoRespiracion = tipoRespiracion;
    }

    /**
     * @return
     */
    public String getTipoRespiracion() {
        return tipoRespiracion;
    }

    /**
     * @param mostrarIntervalo
     */
    public void setMostrarIntervalo(boolean mostrarIntervalo) {
        this.mostrarIntervalo = mostrarIntervalo;
    }

    /**
     * @return
     */
    public boolean isMostrarIntervalo() {
        return mostrarIntervalo;
    }

    /**
     * @param intervaloselect
     */
    public void setIntervaloselect(String intervaloselect) {
        this.intervaloselect = intervaloselect;
    }

    /**
     * @return
     */
    public String getIntervaloselect() {
        return intervaloselect;
    }


    /**
     * @param valueChangeEvent
     */
    public void setIntervaloselect(ValueChangeEvent valueChangeEvent) {
        setIntervaloselect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setVistaClasica(ValueChangeEvent valueChangeEvent) {
        setVistaClasica((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @return
     */
    public List getListHora() {
        if (listHora.size() == 0) {
            listHora.add(new SelectItem("", "--"));
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

        }
        return listHora;
    }


    /**
     * @param listHora
     */
    public void setListHora(List listHora) {
        this.listHora = listHora;
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
            lstMinutos.add(new SelectItem(05, "05"));
            lstMinutos.add(new SelectItem(10, "10"));
            lstMinutos.add(new SelectItem(15, "15"));
            lstMinutos.add(new SelectItem(20, "20"));
            lstMinutos.add(new SelectItem(25, "25"));
            lstMinutos.add(new SelectItem(30, "30"));
            lstMinutos.add(new SelectItem(35, "35"));
            lstMinutos.add(new SelectItem(40, "40"));
            lstMinutos.add(new SelectItem(45, "45"));
            lstMinutos.add(new SelectItem(50, "50"));
            lstMinutos.add(new SelectItem(55, "55"));
        }
        return lstMinutos;
    }

    /**
     * @param horaSelect
     */
    public void setHoraSelect(Integer horaSelect) {
        this.horaSelect = horaSelect;
    }

    /**
     * @return
     */
    public Integer getHoraSelect() {
        return horaSelect;
    }

    /**
     * @param minutoSelect
     */
    public void setMinutoSelect(Integer minutoSelect) {
        this.minutoSelect = minutoSelect;
    }

    /**
     * @return
     */
    public Integer getMinutoSelect() {
        return minutoSelect;
    }


    /**
     * @param dtSignosVitales
     */
    public void setDtSignosVitales(HtmlDataTable dtSignosVitales) {
        this.dtSignosVitales = dtSignosVitales;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtSignosVitales() {
        return dtSignosVitales;
    }

    /**
     * @param numeroDocumento
     */
    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return
     */
    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param tipoDocumento
     */
    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return
     */
    public Integer getTipoDocumento() {
        return tipoDocumento;
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
     * @param lstTipoRespiracion
     */
    public void setLstTipoRespiracion(List lstTipoRespiracion) {
        this.lstTipoRespiracion = lstTipoRespiracion;
    }

    /**
     * @return
     */
    public List getLstTipoRespiracion() {
        if (lstTipoRespiracion.size() == 0) {
            lstTipoRespiracion.add(new SelectItem("E", "Espont�nea."));
            lstTipoRespiracion.add(new SelectItem("A", "Asistida"));
            lstTipoRespiracion.add(new SelectItem("C", "Controlada"));
        }
        return lstTipoRespiracion;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------


    public void ChangeTipoIntervalo() {
        if (intervaloselect != null && intervaloselect.equals("M")) {
            mostrarIntervalo = true;
        } else {
            mostrarIntervalo = false;
        }
    }
    
    
    public void ChangeVistaClasica(){
        if (vistaClasica != null && vistaClasica.equals("C")) {
            renderVistaClasica = true;
        } else {
            renderVistaClasica = false;
        }
    }


    /**
     * @param lstDigitos
     */
    public void setLstDigitos(List lstDigitos) {
        this.lstDigitos = lstDigitos;
    }

    /**
     * @return
     */
    public List getLstDigitos() {
        if (lstDigitos == null || lstDigitos.isEmpty()) {
            lstDigitos = new ArrayList();
            lstDigitos.add(new SelectItem(0, "0"));
            lstDigitos.add(new SelectItem(1, "1"));
            lstDigitos.add(new SelectItem(2, "2"));
            lstDigitos.add(new SelectItem(3, "3"));
            lstDigitos.add(new SelectItem(4, "4"));
            lstDigitos.add(new SelectItem(5, "5"));
            lstDigitos.add(new SelectItem(6, "6"));
            lstDigitos.add(new SelectItem(7, "7"));
            lstDigitos.add(new SelectItem(8, "8"));
            lstDigitos.add(new SelectItem(9, "9"));
        }
        return lstDigitos;
    }


    /**
     * @param anestesia
     */
    public void setAnestesia(Chanestesia anestesia) {
        this.anestesia = anestesia;
    }

    /**
     * @return
     */
    public Chanestesia getAnestesia() {
        return anestesia;
    }

    /**
     * @param lstSignoVital
     */
    public void setLstSignoVital(List<Chsignovital> lstSignoVital) {
        this.lstSignoVital = lstSignoVital;
    }

    /**
     * @return
     */
    public List<Chsignovital> getLstSignoVital() {
        return lstSignoVital;
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
     * @param selectFrecuencia10
     */
    public void setSelectFrecuencia10(boolean selectFrecuencia10) {
        this.selectFrecuencia10 = selectFrecuencia10;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia10() {
        return selectFrecuencia10;
    }

    /**
     * @param selectFrecuencia20
     */
    public void setSelectFrecuencia20(boolean selectFrecuencia20) {
        this.selectFrecuencia20 = selectFrecuencia20;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia20() {
        return selectFrecuencia20;
    }

    /**
     * @param selectFrecuencia30
     */
    public void setSelectFrecuencia30(boolean selectFrecuencia30) {
        this.selectFrecuencia30 = selectFrecuencia30;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia30() {
        return selectFrecuencia30;
    }

    /**
     * @param selectFrecuencia40
     */
    public void setSelectFrecuencia40(boolean selectFrecuencia40) {
        this.selectFrecuencia40 = selectFrecuencia40;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia40() {
        return selectFrecuencia40;
    }

    /**
     * @param selectFrecuencia50
     */
    public void setSelectFrecuencia50(boolean selectFrecuencia50) {
        this.selectFrecuencia50 = selectFrecuencia50;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia50() {
        return selectFrecuencia50;
    }

    /**
     * @param selectFrecuencia60
     */
    public void setSelectFrecuencia60(boolean selectFrecuencia60) {
        this.selectFrecuencia60 = selectFrecuencia60;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia60() {
        return selectFrecuencia60;
    }

    /**
     * @param selectFrecuencia70
     */
    public void setSelectFrecuencia70(boolean selectFrecuencia70) {
        this.selectFrecuencia70 = selectFrecuencia70;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia70() {
        return selectFrecuencia70;
    }

    /**
     * @param selectFrecuencia80
     */
    public void setSelectFrecuencia80(boolean selectFrecuencia80) {
        this.selectFrecuencia80 = selectFrecuencia80;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia80() {
        return selectFrecuencia80;
    }

    /**
     * @param selectFrecuencia90
     */
    public void setSelectFrecuencia90(boolean selectFrecuencia90) {
        this.selectFrecuencia90 = selectFrecuencia90;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia90() {
        return selectFrecuencia90;
    }

    /**
     * @param selectFrecuencia100
     */
    public void setSelectFrecuencia100(boolean selectFrecuencia100) {
        this.selectFrecuencia100 = selectFrecuencia100;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia100() {
        return selectFrecuencia100;
    }

    /**
     * @param selectFrecuencia110
     */
    public void setSelectFrecuencia110(boolean selectFrecuencia110) {
        this.selectFrecuencia110 = selectFrecuencia110;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia110() {
        return selectFrecuencia110;
    }

    /**
     * @param selectFrecuencia120
     */
    public void setSelectFrecuencia120(boolean selectFrecuencia120) {
        this.selectFrecuencia120 = selectFrecuencia120;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia120() {
        return selectFrecuencia120;
    }

    /**
     * @param selectFrecuencia130
     */
    public void setSelectFrecuencia130(boolean selectFrecuencia130) {
        this.selectFrecuencia130 = selectFrecuencia130;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia130() {
        return selectFrecuencia130;
    }

    /**
     * @param selectFrecuencia140
     */
    public void setSelectFrecuencia140(boolean selectFrecuencia140) {
        this.selectFrecuencia140 = selectFrecuencia140;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia140() {
        return selectFrecuencia140;
    }

    /**
     * @param selectFrecuencia150
     */
    public void setSelectFrecuencia150(boolean selectFrecuencia150) {
        this.selectFrecuencia150 = selectFrecuencia150;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia150() {
        return selectFrecuencia150;
    }

    /**
     * @param selectFrecuencia160
     */
    public void setSelectFrecuencia160(boolean selectFrecuencia160) {
        this.selectFrecuencia160 = selectFrecuencia160;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia160() {
        return selectFrecuencia160;
    }

    /**
     * @param selectFrecuencia170
     */
    public void setSelectFrecuencia170(boolean selectFrecuencia170) {
        this.selectFrecuencia170 = selectFrecuencia170;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia170() {
        return selectFrecuencia170;
    }

    /**
     * @param selectFrecuencia180
     */
    public void setSelectFrecuencia180(boolean selectFrecuencia180) {
        this.selectFrecuencia180 = selectFrecuencia180;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia180() {
        return selectFrecuencia180;
    }

    /**
     * @param selectFrecuencia190
     */
    public void setSelectFrecuencia190(boolean selectFrecuencia190) {
        this.selectFrecuencia190 = selectFrecuencia190;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia190() {
        return selectFrecuencia190;
    }

    /**
     * @param selectFrecuencia200
     */
    public void setSelectFrecuencia200(boolean selectFrecuencia200) {
        this.selectFrecuencia200 = selectFrecuencia200;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia200() {
        return selectFrecuencia200;
    }

    /**
     * @param selectFrecuencia210
     */
    public void setSelectFrecuencia210(boolean selectFrecuencia210) {
        this.selectFrecuencia210 = selectFrecuencia210;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia210() {
        return selectFrecuencia210;
    }

    /**
     * @param selectPresionSistole10
     */
    public void setSelectPresionSistole10(boolean selectPresionSistole10) {
        this.selectPresionSistole10 = selectPresionSistole10;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole10() {
        return selectPresionSistole10;
    }

    /**
     * @param selectPresionSistole20
     */
    public void setSelectPresionSistole20(boolean selectPresionSistole20) {
        this.selectPresionSistole20 = selectPresionSistole20;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole20() {
        return selectPresionSistole20;
    }

    /**
     * @param selectPresionSistole30
     */
    public void setSelectPresionSistole30(boolean selectPresionSistole30) {
        this.selectPresionSistole30 = selectPresionSistole30;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole30() {
        return selectPresionSistole30;
    }

    /**
     * @param selectPresionSistole40
     */
    public void setSelectPresionSistole40(boolean selectPresionSistole40) {
        this.selectPresionSistole40 = selectPresionSistole40;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole40() {
        return selectPresionSistole40;
    }

    /**
     * @param selectPresionSistole50
     */
    public void setSelectPresionSistole50(boolean selectPresionSistole50) {
        this.selectPresionSistole50 = selectPresionSistole50;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole50() {
        return selectPresionSistole50;
    }

    /**
     * @param selectPresionSistole60
     */
    public void setSelectPresionSistole60(boolean selectPresionSistole60) {
        this.selectPresionSistole60 = selectPresionSistole60;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole60() {
        return selectPresionSistole60;
    }

    /**
     * @param selectPresionSistole70
     */
    public void setSelectPresionSistole70(boolean selectPresionSistole70) {
        this.selectPresionSistole70 = selectPresionSistole70;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole70() {
        return selectPresionSistole70;
    }

    /**
     * @param selectPresionSistole80
     */
    public void setSelectPresionSistole80(boolean selectPresionSistole80) {
        this.selectPresionSistole80 = selectPresionSistole80;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole80() {
        return selectPresionSistole80;
    }

    /**
     * @param selectPresionSistole90
     */
    public void setSelectPresionSistole90(boolean selectPresionSistole90) {
        this.selectPresionSistole90 = selectPresionSistole90;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole90() {
        return selectPresionSistole90;
    }

    /**
     * @param selectPresionSistole100
     */
    public void setSelectPresionSistole100(boolean selectPresionSistole100) {
        this.selectPresionSistole100 = selectPresionSistole100;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole100() {
        return selectPresionSistole100;
    }

    /**
     * @param selectPresionSistole110
     */
    public void setSelectPresionSistole110(boolean selectPresionSistole110) {
        this.selectPresionSistole110 = selectPresionSistole110;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole110() {
        return selectPresionSistole110;
    }

    /**
     * @param selectPresionSistole120
     */
    public void setSelectPresionSistole120(boolean selectPresionSistole120) {
        this.selectPresionSistole120 = selectPresionSistole120;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole120() {
        return selectPresionSistole120;
    }

    /**
     * @param selectPresionSistole130
     */
    public void setSelectPresionSistole130(boolean selectPresionSistole130) {
        this.selectPresionSistole130 = selectPresionSistole130;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole130() {
        return selectPresionSistole130;
    }

    /**
     * @param selectPresionSistole140
     */
    public void setSelectPresionSistole140(boolean selectPresionSistole140) {
        this.selectPresionSistole140 = selectPresionSistole140;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole140() {
        return selectPresionSistole140;
    }

    /**
     * @param selectPresionSistole150
     */
    public void setSelectPresionSistole150(boolean selectPresionSistole150) {
        this.selectPresionSistole150 = selectPresionSistole150;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole150() {
        return selectPresionSistole150;
    }

    /**
     * @param selectPresionSistole160
     */
    public void setSelectPresionSistole160(boolean selectPresionSistole160) {
        this.selectPresionSistole160 = selectPresionSistole160;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole160() {
        return selectPresionSistole160;
    }

    /**
     * @param selectPresionSistole170
     */
    public void setSelectPresionSistole170(boolean selectPresionSistole170) {
        this.selectPresionSistole170 = selectPresionSistole170;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole170() {
        return selectPresionSistole170;
    }

    /**
     * @param selectPresionSistole180
     */
    public void setSelectPresionSistole180(boolean selectPresionSistole180) {
        this.selectPresionSistole180 = selectPresionSistole180;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole180() {
        return selectPresionSistole180;
    }

    /**
     * @param selectPresionSistole190
     */
    public void setSelectPresionSistole190(boolean selectPresionSistole190) {
        this.selectPresionSistole190 = selectPresionSistole190;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole190() {
        return selectPresionSistole190;
    }

    /**
     * @param selectPresionSistole200
     */
    public void setSelectPresionSistole200(boolean selectPresionSistole200) {
        this.selectPresionSistole200 = selectPresionSistole200;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole200() {
        return selectPresionSistole200;
    }

    /**
     * @param selectPresionSistole210
     */
    public void setSelectPresionSistole210(boolean selectPresionSistole210) {
        this.selectPresionSistole210 = selectPresionSistole210;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole210() {
        return selectPresionSistole210;
    }

    /**
     * @param selectPresionDiastole10
     */
    public void setSelectPresionDiastole10(boolean selectPresionDiastole10) {
        this.selectPresionDiastole10 = selectPresionDiastole10;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole10() {
        return selectPresionDiastole10;
    }

    /**
     * @param selectPresionDiastole20
     */
    public void setSelectPresionDiastole20(boolean selectPresionDiastole20) {
        this.selectPresionDiastole20 = selectPresionDiastole20;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole20() {
        return selectPresionDiastole20;
    }

    /**
     * @param selectPresionDiastole30
     */
    public void setSelectPresionDiastole30(boolean selectPresionDiastole30) {
        this.selectPresionDiastole30 = selectPresionDiastole30;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole30() {
        return selectPresionDiastole30;
    }

    /**
     * @param selectPresionDiastole40
     */
    public void setSelectPresionDiastole40(boolean selectPresionDiastole40) {
        this.selectPresionDiastole40 = selectPresionDiastole40;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole40() {
        return selectPresionDiastole40;
    }

    /**
     * @param selectPresionDiastole50
     */
    public void setSelectPresionDiastole50(boolean selectPresionDiastole50) {
        this.selectPresionDiastole50 = selectPresionDiastole50;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole50() {
        return selectPresionDiastole50;
    }

    /**
     * @param selectPresionDiastole60
     */
    public void setSelectPresionDiastole60(boolean selectPresionDiastole60) {
        this.selectPresionDiastole60 = selectPresionDiastole60;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole60() {
        return selectPresionDiastole60;
    }

    /**
     * @param selectPresionDiastole70
     */
    public void setSelectPresionDiastole70(boolean selectPresionDiastole70) {
        this.selectPresionDiastole70 = selectPresionDiastole70;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole70() {
        return selectPresionDiastole70;
    }

    /**
     * @param selectPresionDiastole80
     */
    public void setSelectPresionDiastole80(boolean selectPresionDiastole80) {
        this.selectPresionDiastole80 = selectPresionDiastole80;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole80() {
        return selectPresionDiastole80;
    }

    /**
     * @param selectPresionDiastole90
     */
    public void setSelectPresionDiastole90(boolean selectPresionDiastole90) {
        this.selectPresionDiastole90 = selectPresionDiastole90;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole90() {
        return selectPresionDiastole90;
    }

    /**
     * @param selectPresionDiastole100
     */
    public void setSelectPresionDiastole100(boolean selectPresionDiastole100) {
        this.selectPresionDiastole100 = selectPresionDiastole100;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole100() {
        return selectPresionDiastole100;
    }

    /**
     * @param selectPresionDiastole110
     */
    public void setSelectPresionDiastole110(boolean selectPresionDiastole110) {
        this.selectPresionDiastole110 = selectPresionDiastole110;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole110() {
        return selectPresionDiastole110;
    }

    /**
     * @param selectPresionDiastole120
     */
    public void setSelectPresionDiastole120(boolean selectPresionDiastole120) {
        this.selectPresionDiastole120 = selectPresionDiastole120;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole120() {
        return selectPresionDiastole120;
    }

    /**
     * @param selectPresionDiastole130
     */
    public void setSelectPresionDiastole130(boolean selectPresionDiastole130) {
        this.selectPresionDiastole130 = selectPresionDiastole130;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole130() {
        return selectPresionDiastole130;
    }

    /**
     * @param selectPresionDiastole140
     */
    public void setSelectPresionDiastole140(boolean selectPresionDiastole140) {
        this.selectPresionDiastole140 = selectPresionDiastole140;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole140() {
        return selectPresionDiastole140;
    }

    /**
     * @param selectPresionDiastole150
     */
    public void setSelectPresionDiastole150(boolean selectPresionDiastole150) {
        this.selectPresionDiastole150 = selectPresionDiastole150;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole150() {
        return selectPresionDiastole150;
    }

    /**
     * @param selectPresionDiastole160
     */
    public void setSelectPresionDiastole160(boolean selectPresionDiastole160) {
        this.selectPresionDiastole160 = selectPresionDiastole160;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole160() {
        return selectPresionDiastole160;
    }

    /**
     * @param selectPresionDiastole170
     */
    public void setSelectPresionDiastole170(boolean selectPresionDiastole170) {
        this.selectPresionDiastole170 = selectPresionDiastole170;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole170() {
        return selectPresionDiastole170;
    }

    /**
     * @param selectPresionDiastole180
     */
    public void setSelectPresionDiastole180(boolean selectPresionDiastole180) {
        this.selectPresionDiastole180 = selectPresionDiastole180;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole180() {
        return selectPresionDiastole180;
    }

    /**
     * @param selectPresionDiastole190
     */
    public void setSelectPresionDiastole190(boolean selectPresionDiastole190) {
        this.selectPresionDiastole190 = selectPresionDiastole190;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole190() {
        return selectPresionDiastole190;
    }

    /**
     * @param selectPresionDiastole200
     */
    public void setSelectPresionDiastole200(boolean selectPresionDiastole200) {
        this.selectPresionDiastole200 = selectPresionDiastole200;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole200() {
        return selectPresionDiastole200;
    }

    /**
     * @param selectPresionDiastole210
     */
    public void setSelectPresionDiastole210(boolean selectPresionDiastole210) {
        this.selectPresionDiastole210 = selectPresionDiastole210;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole210() {
        return selectPresionDiastole210;
    }

    /**
     * @param selectPeco10
     */
    public void setSelectPeco10(boolean selectPeco10) {
        this.selectPeco10 = selectPeco10;
    }

    /**
     * @return
     */
    public boolean isSelectPeco10() {
        return selectPeco10;
    }

    /**
     * @param selectPeco20
     */
    public void setSelectPeco20(boolean selectPeco20) {
        this.selectPeco20 = selectPeco20;
    }

    /**
     * @return
     */
    public boolean isSelectPeco20() {
        return selectPeco20;
    }

    /**
     * @param selectPeco30
     */
    public void setSelectPeco30(boolean selectPeco30) {
        this.selectPeco30 = selectPeco30;
    }

    /**
     * @return
     */
    public boolean isSelectPeco30() {
        return selectPeco30;
    }

    /**
     * @param selectPeco40
     */
    public void setSelectPeco40(boolean selectPeco40) {
        this.selectPeco40 = selectPeco40;
    }

    /**
     * @return
     */
    public boolean isSelectPeco40() {
        return selectPeco40;
    }

    /**
     * @param selectPeco50
     */
    public void setSelectPeco50(boolean selectPeco50) {
        this.selectPeco50 = selectPeco50;
    }

    /**
     * @return
     */
    public boolean isSelectPeco50() {
        return selectPeco50;
    }

    /**
     * @param selectPeco60
     */
    public void setSelectPeco60(boolean selectPeco60) {
        this.selectPeco60 = selectPeco60;
    }

    /**
     * @return
     */
    public boolean isSelectPeco60() {
        return selectPeco60;
    }

    /**
     * @param selectPeco70
     */
    public void setSelectPeco70(boolean selectPeco70) {
        this.selectPeco70 = selectPeco70;
    }

    /**
     * @return
     */
    public boolean isSelectPeco70() {
        return selectPeco70;
    }

    /**
     * @param selectPeco80
     */
    public void setSelectPeco80(boolean selectPeco80) {
        this.selectPeco80 = selectPeco80;
    }

    /**
     * @return
     */
    public boolean isSelectPeco80() {
        return selectPeco80;
    }

    /**
     * @param selectPeco90
     */
    public void setSelectPeco90(boolean selectPeco90) {
        this.selectPeco90 = selectPeco90;
    }

    /**
     * @return
     */
    public boolean isSelectPeco90() {
        return selectPeco90;
    }

    /**
     * @param selectPeco100
     */
    public void setSelectPeco100(boolean selectPeco100) {
        this.selectPeco100 = selectPeco100;
    }

    /**
     * @return
     */
    public boolean isSelectPeco100() {
        return selectPeco100;
    }

    /**
     * @param selectPeco110
     */
    public void setSelectPeco110(boolean selectPeco110) {
        this.selectPeco110 = selectPeco110;
    }

    /**
     * @return
     */
    public boolean isSelectPeco110() {
        return selectPeco110;
    }

    /**
     * @param selectPeco120
     */
    public void setSelectPeco120(boolean selectPeco120) {
        this.selectPeco120 = selectPeco120;
    }

    /**
     * @return
     */
    public boolean isSelectPeco120() {
        return selectPeco120;
    }

    /**
     * @param selectPeco130
     */
    public void setSelectPeco130(boolean selectPeco130) {
        this.selectPeco130 = selectPeco130;
    }

    /**
     * @return
     */
    public boolean isSelectPeco130() {
        return selectPeco130;
    }

    /**
     * @param selectPeco140
     */
    public void setSelectPeco140(boolean selectPeco140) {
        this.selectPeco140 = selectPeco140;
    }

    /**
     * @return
     */
    public boolean isSelectPeco140() {
        return selectPeco140;
    }

    /**
     * @param selectPeco150
     */
    public void setSelectPeco150(boolean selectPeco150) {
        this.selectPeco150 = selectPeco150;
    }

    /**
     * @return
     */
    public boolean isSelectPeco150() {
        return selectPeco150;
    }

    /**
     * @param selectPeco160
     */
    public void setSelectPeco160(boolean selectPeco160) {
        this.selectPeco160 = selectPeco160;
    }

    /**
     * @return
     */
    public boolean isSelectPeco160() {
        return selectPeco160;
    }

    /**
     * @param selectPeco170
     */
    public void setSelectPeco170(boolean selectPeco170) {
        this.selectPeco170 = selectPeco170;
    }

    /**
     * @return
     */
    public boolean isSelectPeco170() {
        return selectPeco170;
    }

    /**
     * @param selectPeco180
     */
    public void setSelectPeco180(boolean selectPeco180) {
        this.selectPeco180 = selectPeco180;
    }

    /**
     * @return
     */
    public boolean isSelectPeco180() {
        return selectPeco180;
    }

    /**
     * @param selectPeco190
     */
    public void setSelectPeco190(boolean selectPeco190) {
        this.selectPeco190 = selectPeco190;
    }

    /**
     * @return
     */
    public boolean isSelectPeco190() {
        return selectPeco190;
    }

    /**
     * @param selectPeco200
     */
    public void setSelectPeco200(boolean selectPeco200) {
        this.selectPeco200 = selectPeco200;
    }

    /**
     * @return
     */
    public boolean isSelectPeco200() {
        return selectPeco200;
    }

    /**
     * @param selectPeco210
     */
    public void setSelectPeco210(boolean selectPeco210) {
        this.selectPeco210 = selectPeco210;
    }

    /**
     * @return
     */
    public boolean isSelectPeco210() {
        return selectPeco210;
    }

    /**
     * @param selectSaturacion10
     */
    public void setSelectSaturacion10(boolean selectSaturacion10) {
        this.selectSaturacion10 = selectSaturacion10;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion10() {
        return selectSaturacion10;
    }

    /**
     * @param selectSaturacion20
     */
    public void setSelectSaturacion20(boolean selectSaturacion20) {
        this.selectSaturacion20 = selectSaturacion20;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion20() {
        return selectSaturacion20;
    }

    /**
     * @param selectSaturacion30
     */
    public void setSelectSaturacion30(boolean selectSaturacion30) {
        this.selectSaturacion30 = selectSaturacion30;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion30() {
        return selectSaturacion30;
    }

    /**
     * @param selectSaturacion40
     */
    public void setSelectSaturacion40(boolean selectSaturacion40) {
        this.selectSaturacion40 = selectSaturacion40;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion40() {
        return selectSaturacion40;
    }

    /**
     * @param selectSaturacion50
     */
    public void setSelectSaturacion50(boolean selectSaturacion50) {
        this.selectSaturacion50 = selectSaturacion50;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion50() {
        return selectSaturacion50;
    }

    /**
     * @param selectSaturacion60
     */
    public void setSelectSaturacion60(boolean selectSaturacion60) {
        this.selectSaturacion60 = selectSaturacion60;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion60() {
        return selectSaturacion60;
    }

    /**
     * @param selectSaturacion70
     */
    public void setSelectSaturacion70(boolean selectSaturacion70) {
        this.selectSaturacion70 = selectSaturacion70;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion70() {
        return selectSaturacion70;
    }

    /**
     * @param selectSaturacion80
     */
    public void setSelectSaturacion80(boolean selectSaturacion80) {
        this.selectSaturacion80 = selectSaturacion80;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion80() {
        return selectSaturacion80;
    }

    /**
     * @param selectSaturacion90
     */
    public void setSelectSaturacion90(boolean selectSaturacion90) {
        this.selectSaturacion90 = selectSaturacion90;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion90() {
        return selectSaturacion90;
    }

    /**
     * @param selectSaturacion100
     */
    public void setSelectSaturacion100(boolean selectSaturacion100) {
        this.selectSaturacion100 = selectSaturacion100;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion100() {
        return selectSaturacion100;
    }

    /**
     * @param selectSaturacion110
     */
    public void setSelectSaturacion110(boolean selectSaturacion110) {
        this.selectSaturacion110 = selectSaturacion110;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion110() {
        return selectSaturacion110;
    }

    /**
     * @param selectSaturacion120
     */
    public void setSelectSaturacion120(boolean selectSaturacion120) {
        this.selectSaturacion120 = selectSaturacion120;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion120() {
        return selectSaturacion120;
    }

    /**
     * @param selectSaturacion130
     */
    public void setSelectSaturacion130(boolean selectSaturacion130) {
        this.selectSaturacion130 = selectSaturacion130;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion130() {
        return selectSaturacion130;
    }

    /**
     * @param selectSaturacion140
     */
    public void setSelectSaturacion140(boolean selectSaturacion140) {
        this.selectSaturacion140 = selectSaturacion140;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion140() {
        return selectSaturacion140;
    }

    /**
     * @param selectSaturacion150
     */
    public void setSelectSaturacion150(boolean selectSaturacion150) {
        this.selectSaturacion150 = selectSaturacion150;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion150() {
        return selectSaturacion150;
    }

    /**
     * @param selectSaturacion160
     */
    public void setSelectSaturacion160(boolean selectSaturacion160) {
        this.selectSaturacion160 = selectSaturacion160;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion160() {
        return selectSaturacion160;
    }

    /**
     * @param selectSaturacion170
     */
    public void setSelectSaturacion170(boolean selectSaturacion170) {
        this.selectSaturacion170 = selectSaturacion170;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion170() {
        return selectSaturacion170;
    }

    /**
     * @param selectSaturacion180
     */
    public void setSelectSaturacion180(boolean selectSaturacion180) {
        this.selectSaturacion180 = selectSaturacion180;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion180() {
        return selectSaturacion180;
    }

    /**
     * @param selectSaturacion190
     */
    public void setSelectSaturacion190(boolean selectSaturacion190) {
        this.selectSaturacion190 = selectSaturacion190;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion190() {
        return selectSaturacion190;
    }

    /**
     * @param selectSaturacion200
     */
    public void setSelectSaturacion200(boolean selectSaturacion200) {
        this.selectSaturacion200 = selectSaturacion200;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion200() {
        return selectSaturacion200;
    }

    /**
     * @param selectSaturacion210
     */
    public void setSelectSaturacion210(boolean selectSaturacion210) {
        this.selectSaturacion210 = selectSaturacion210;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion210() {
        return selectSaturacion210;
    }


    /**
     * @param selectFrecuencia0
     */
    public void setSelectFrecuencia0(boolean selectFrecuencia0) {
        this.selectFrecuencia0 = selectFrecuencia0;
    }

    /**
     * @return
     */
    public boolean isSelectFrecuencia0() {
        return selectFrecuencia0;
    }

    /**
     * @param selectPresionSistole0
     */
    public void setSelectPresionSistole0(boolean selectPresionSistole0) {
        this.selectPresionSistole0 = selectPresionSistole0;
    }

    /**
     * @return
     */
    public boolean isSelectPresionSistole0() {
        return selectPresionSistole0;
    }

    /**
     * @param selectPresionDiastole0
     */
    public void setSelectPresionDiastole0(boolean selectPresionDiastole0) {
        this.selectPresionDiastole0 = selectPresionDiastole0;
    }

    /**
     * @return
     */
    public boolean isSelectPresionDiastole0() {
        return selectPresionDiastole0;
    }

    /**
     * @param selectPeco0
     */
    public void setSelectPeco0(boolean selectPeco0) {
        this.selectPeco0 = selectPeco0;
    }

    /**
     * @return
     */
    public boolean isSelectPeco0() {
        return selectPeco0;
    }

    /**
     * @param selectSaturacion0
     */
    public void setSelectSaturacion0(boolean selectSaturacion0) {
        this.selectSaturacion0 = selectSaturacion0;
    }

    /**
     * @return
     */
    public boolean isSelectSaturacion0() {
        return selectSaturacion0;
    }

    /**
     * @param valorSelectFrecuencia
     */
    public void setValorSelectFrecuencia(Integer valorSelectFrecuencia) {
        this.valorSelectFrecuencia = valorSelectFrecuencia;
    }

    /**
     * @return
     */
    public Integer getValorSelectFrecuencia() {
        return valorSelectFrecuencia;
    }

    /**
     * @param valorSelectDiastole
     */
    public void setValorSelectDiastole(Integer valorSelectDiastole) {
        this.valorSelectDiastole = valorSelectDiastole;
    }

    /**
     * @return
     */
    public Integer getValorSelectDiastole() {
        return valorSelectDiastole;
    }

    /**
     * @param valorSelectSistole
     */
    public void setValorSelectSistole(Integer valorSelectSistole) {
        this.valorSelectSistole = valorSelectSistole;
    }

    /**
     * @return
     */
    public Integer getValorSelectSistole() {
        return valorSelectSistole;
    }

    /**
     * @param valorSelectPeco
     */
    public void setValorSelectPeco(Integer valorSelectPeco) {
        this.valorSelectPeco = valorSelectPeco;
    }

    /**
     * @return
     */
    public Integer getValorSelectPeco() {
        return valorSelectPeco;
    }

    /**
     * @param valorSelectSaturacion
     */
    public void setValorSelectSaturacion(Integer valorSelectSaturacion) {
        this.valorSelectSaturacion = valorSelectSaturacion;
    }

    /**
     * @return
     */
    public Integer getValorSelectSaturacion() {
        return valorSelectSaturacion;
    }


    /**
     * @param digitoFC
     */
    public void setDigitoFC(Integer digitoFC) {
        this.digitoFC = digitoFC;
    }

    /**
     * @return
     */
    public Integer getDigitoFC() {
        return digitoFC;
    }

    /**
     * @param digitoSistolica
     */
    public void setDigitoSistolica(Integer digitoSistolica) {
        this.digitoSistolica = digitoSistolica;
    }

    /**
     * @return
     */
    public Integer getDigitoSistolica() {
        return digitoSistolica;
    }

    /**
     * @param digitoDiastolica
     */
    public void setDigitoDiastolica(Integer digitoDiastolica) {
        this.digitoDiastolica = digitoDiastolica;
    }

    /**
     * @return
     */
    public Integer getDigitoDiastolica() {
        return digitoDiastolica;
    }

    /**
     * @param digitoPeco
     */
    public void setDigitoPeco(Integer digitoPeco) {
        this.digitoPeco = digitoPeco;
    }

    /**
     * @return
     */
    public Integer getDigitoPeco() {
        return digitoPeco;
    }

    /**
     * @param digitoSaturacion
     */
    public void setDigitoSaturacion(Integer digitoSaturacion) {
        this.digitoSaturacion = digitoSaturacion;
    }

    /**
     * @return
     */
    public Integer getDigitoSaturacion() {
        return digitoSaturacion;
    }


    public void clear() {

        tipoRespiracion = null;
        selectFrecuencia0 = false;
        selectFrecuencia10 = false;
        selectFrecuencia20 = false;
        selectFrecuencia30 = false;
        selectFrecuencia40 = false;
        selectFrecuencia50 = false;
        selectFrecuencia60 = false;
        selectFrecuencia70 = false;
        selectFrecuencia80 = false;
        selectFrecuencia90 = false;
        selectFrecuencia100 = false;
        selectFrecuencia110 = false;
        selectFrecuencia120 = false;
        selectFrecuencia130 = false;
        selectFrecuencia140 = false;
        selectFrecuencia150 = false;
        selectFrecuencia160 = false;
        selectFrecuencia170 = false;
        selectFrecuencia180 = false;
        selectFrecuencia190 = false;
        selectFrecuencia200 = false;
        selectFrecuencia210 = false;


        selectPresionSistole0 = false;
        selectPresionSistole10 = false;
        selectPresionSistole20 = false;
        selectPresionSistole30 = false;
        selectPresionSistole40 = false;
        selectPresionSistole50 = false;
        selectPresionSistole60 = false;
        selectPresionSistole70 = false;
        selectPresionSistole80 = false;
        selectPresionSistole90 = false;
        selectPresionSistole100 = false;
        selectPresionSistole110 = false;
        selectPresionSistole120 = false;
        selectPresionSistole130 = false;
        selectPresionSistole140 = false;
        selectPresionSistole150 = false;
        selectPresionSistole160 = false;
        selectPresionSistole170 = false;
        selectPresionSistole180 = false;
        selectPresionSistole190 = false;
        selectPresionSistole200 = false;
        selectPresionSistole210 = false;


        selectPresionDiastole0 = false;
        selectPresionDiastole10 = false;
        selectPresionDiastole20 = false;
        selectPresionDiastole30 = false;
        selectPresionDiastole40 = false;
        selectPresionDiastole50 = false;
        selectPresionDiastole60 = false;
        selectPresionDiastole70 = false;
        selectPresionDiastole80 = false;
        selectPresionDiastole90 = false;
        selectPresionDiastole100 = false;
        selectPresionDiastole110 = false;
        selectPresionDiastole120 = false;
        selectPresionDiastole130 = false;
        selectPresionDiastole140 = false;
        selectPresionDiastole150 = false;
        selectPresionDiastole160 = false;
        selectPresionDiastole170 = false;
        selectPresionDiastole180 = false;
        selectPresionDiastole190 = false;
        selectPresionDiastole200 = false;
        selectPresionDiastole210 = false;

        selectPeco0 = false;
        selectPeco10 = false;
        selectPeco20 = false;
        selectPeco30 = false;
        selectPeco40 = false;
        selectPeco50 = false;
        selectPeco60 = false;
        selectPeco70 = false;
        selectPeco80 = false;
        selectPeco90 = false;
        selectPeco100 = false;
        selectPeco110 = false;
        selectPeco120 = false;
        selectPeco130 = false;
        selectPeco140 = false;
        selectPeco150 = false;
        selectPeco160 = false;
        selectPeco170 = false;
        selectPeco180 = false;
        selectPeco190 = false;
        selectPeco200 = false;
        selectPeco210 = false;

        selectSaturacion0 = false;
        selectSaturacion10 = false;
        selectSaturacion20 = false;
        selectSaturacion30 = false;
        selectSaturacion40 = false;
        selectSaturacion50 = false;
        selectSaturacion60 = false;
        selectSaturacion70 = false;
        selectSaturacion80 = false;
        selectSaturacion90 = false;
        selectSaturacion100 = false;
        selectSaturacion110 = false;
        selectSaturacion120 = false;
        selectSaturacion130 = false;
        selectSaturacion140 = false;
        selectSaturacion150 = false;
        selectSaturacion160 = false;
        selectSaturacion170 = false;
        selectSaturacion180 = false;
        selectSaturacion190 = false;
        selectSaturacion200 = false;
        selectSaturacion210 = false;

        digitoDiastolica = 0;
        digitoFC = 0;
        digitoPeco = 0;
        digitoSaturacion = 0;
        digitoSistolica = 0;
        
        sistolicaNuevo = null;
        diastolicaNuevo= null;
        saturacionNuevo= null;
        pecoNuevo= null;
        frecuenciaCardiacaNuevo= null;
        respiracionNuevo= "";


    }


    public String adicionarSignoVital() {
        Chsignovital signoVital = new Chsignovital();
        boolean wexito = false;

        Calendar fechacalendar;
        if (lstSignoVital.isEmpty()) {
            fechacalendar = Calendar.getInstance();
            fechacalendar.setTime(fechaInicio);
            fechacalendar.set(Calendar.HOUR, horaSelect);
            fechacalendar.set(Calendar.MINUTE, minutoSelect);
            signoVital.setHsvdfechaactiv(fechacalendar.getTime());
            if (validarSignosVitales()) {
                wexito = true;
                signoVital.setHsvnpresart1(valorSelectSistole);
                signoVital.setHsvctiposervi(TIPO_HOSPITALIZACION);
                signoVital.setHsvnpresart2(valorSelectDiastole);
                signoVital.setHsvnsatuoxihe(valorSelectSaturacion);
                signoVital.setHsvnpresioxido(valorSelectPeco);
                signoVital.setHsvnfreccard(valorSelectFrecuencia);
                signoVital.setHsvcestado(ESTADO_VIGENTE);
                signoVital.setHsvdfecregistr(new Date());
                signoVital.setHsvlusuario(cirugia.getHcplusuario().getHuslnumero());
                signoVital.setHsvcoperador(userName());
                signoVital.setHsvnclinica(getClinica().getCclncodigo());
                signoVital.getId().setHsvlconsulta(cirugia.getHcplnumero());
                signoVital.setHsvctipoproced(TIPO_PROCEDIMIENTO_ANESTESIA);
                signoVital.setHsvctiporespir(tipoRespiracion);
                intervaloselect = "A";
                clear();
            }


        } else {

            Chsignovital signoAux;
            signoVital = new Chsignovital();
            Integer minutoAdd = null;
            signoAux = lstSignoVital.get(lstSignoVital.size() - 1);
            if (intervaloselect != null && intervaloselect.equals("A")) {
                // Si es automatico se muestran en intervalos de 5 minutos 
                minutoAdd = 5;
            } else {
                // Si es manual se toma el intervalo menor a 5 Minutos 
                minutoAdd = tiempointervalo;
            }

            fechacalendar = Calendar.getInstance();
            fechacalendar.setTime(signoAux.getHsvdfechaactiv());
            fechacalendar.add(Calendar.MINUTE, minutoAdd);

            signoVital.setHsvdfechaactiv(fechacalendar.getTime());
            if (validarSignosVitales()) {
                wexito = true;
                signoVital.setHsvnpresart1(valorSelectSistole);
                signoVital.setHsvnpresart2(valorSelectDiastole);
                signoVital.setHsvnsatuoxihe(valorSelectSaturacion);
                signoVital.setHsvnpresioxido(valorSelectPeco);
                signoVital.setHsvnfreccard(valorSelectFrecuencia);
                signoVital.setHsvctiposervi(TIPO_HOSPITALIZACION);
                signoVital.setHsvcestado(ESTADO_VIGENTE);
                signoVital.setHsvdfecregistr(new Date());
                signoVital.setHsvlusuario(cirugia.getHcplusuario().getHuslnumero());
                signoVital.setHsvcoperador(userName());
                signoVital.setHsvnclinica(getClinica().getCclncodigo());
                signoVital.getId().setHsvlconsulta(cirugia.getHcplnumero());
                signoVital.setHsvctipoproced(TIPO_PROCEDIMIENTO_ANESTESIA);
                signoVital.setHsvctiporespir(tipoRespiracion);
                clear();
            }

        }
        if (wexito) {
            try {
                this.serviceLocator.getCirugiaService().saveSignosVitales(signoVital);
                lstSignoVital = 
                        serviceLocator.getCirugiaService().getSignosVitalesAnestesia(numeroCirugia);
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + " " + 
                                           e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }
    
    
    
    public String adicionarSignoVitalNuevo() {
        Chsignovital signoVital = new Chsignovital();
        boolean wexito = false;

        Calendar fechacalendar;
        if (lstSignoVital.isEmpty()) {
            fechacalendar = Calendar.getInstance();
            fechacalendar.setTime(fechaInicio);
            fechacalendar.set(Calendar.HOUR, horaSelect);
            fechacalendar.set(Calendar.MINUTE, minutoSelect);
            signoVital.setHsvdfechaactiv(fechacalendar.getTime());
            if (validarSignosVitalesNuevo()) {
                wexito = true;
                signoVital.setHsvnpresart1(sistolicaNuevo);
                signoVital.setHsvnpresart2(diastolicaNuevo);
                signoVital.setHsvnsatuoxihe(saturacionNuevo);
                signoVital.setHsvnpresioxido(pecoNuevo);
                signoVital.setHsvnfreccard(frecuenciaCardiacaNuevo);
                signoVital.setHsvctiporespir(respiracionNuevo);
                signoVital.setHsvcestado(ESTADO_VIGENTE);
                signoVital.setHsvdfecregistr(new Date());
                signoVital.setHsvlusuario(cirugia.getHcplusuario().getHuslnumero());
                signoVital.setHsvcoperador(userName());
                signoVital.setHsvnclinica(getClinica().getCclncodigo());
                signoVital.getId().setHsvlconsulta(cirugia.getHcplnumero());
                signoVital.setHsvctipoproced(TIPO_PROCEDIMIENTO_ANESTESIA);
                
                intervaloselect = "A";
                clear();
            }


        } else {

            Chsignovital signoAux;
            signoVital = new Chsignovital();
            Integer minutoAdd = null;
            signoAux = lstSignoVital.get(lstSignoVital.size() - 1);
            if (intervaloselect != null && intervaloselect.equals("A")) {
                // Si es automatico se muestran en intervalos de 5 minutos 
                minutoAdd = 5;
            } else {
                // Si es manual se toma el intervalo menor a 5 Minutos 
                minutoAdd = tiempointervalo;
            }

            fechacalendar = Calendar.getInstance();
            fechacalendar.setTime(signoAux.getHsvdfechaactiv());
            fechacalendar.add(Calendar.MINUTE, minutoAdd);

            signoVital.setHsvdfechaactiv(fechacalendar.getTime());
            if (validarSignosVitalesNuevo()) {
                wexito = true;
                signoVital.setHsvnpresart1(sistolicaNuevo);
                signoVital.setHsvnpresart2(diastolicaNuevo);
                signoVital.setHsvnsatuoxihe(saturacionNuevo);
                signoVital.setHsvnpresioxido(pecoNuevo);
                signoVital.setHsvnfreccard(frecuenciaCardiacaNuevo);
                signoVital.setHsvctiporespir(respiracionNuevo);
                signoVital.setHsvcestado(ESTADO_VIGENTE);
                signoVital.setHsvdfecregistr(new Date());
                signoVital.setHsvlusuario(cirugia.getHcplusuario().getHuslnumero());
                signoVital.setHsvcoperador(userName());
                signoVital.setHsvnclinica(getClinica().getCclncodigo());
                signoVital.getId().setHsvlconsulta(cirugia.getHcplnumero());
                signoVital.setHsvctipoproced(TIPO_PROCEDIMIENTO_ANESTESIA);
                clear();
                
                
            }

        }
        if (wexito) {
            try {
                this.serviceLocator.getCirugiaService().saveSignosVitales(signoVital);
                lstSignoVital = 
                        serviceLocator.getCirugiaService().getSignosVitalesAnestesia(numeroCirugia);
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + " " + 
                                           e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }
    
    
    private boolean validarSignosVitalesNuevo(){
    
    boolean validocampos = true;
    
        if(sistolicaNuevo == null || sistolicaNuevo.intValue() == 0){
            validocampos = false;
            FacesUtils.addErrorMessage(MSG_PRESION_SISTOLE_OBLIGATORIA);
        }
        
        if(diastolicaNuevo == null || diastolicaNuevo.intValue() == 0){
            validocampos = false;
            FacesUtils.addErrorMessage(MSG_PRESION_DIASTOLE_OBLIGATORIA);
        }
        
        
        if(saturacionNuevo == null || saturacionNuevo.intValue() == 0){
            validocampos = false;
            FacesUtils.addErrorMessage(MSG_SATURACION_OBLIGATORIA);
            
        }
        
   /*     if(pecoNuevo == null || pecoNuevo.intValue() == 0){
            validocampos = false;
            FacesUtils.addErrorMessage(MSG_PECO2_OBLIGATORIA);
        }*/
        
        if(frecuenciaCardiacaNuevo == null || frecuenciaCardiacaNuevo.intValue() == 0){
            validocampos = false;
            FacesUtils.addErrorMessage(MSG_FRECUENCIA_OBLIGATORIA);
        }
        
        if(respiracionNuevo == null || respiracionNuevo.equals("")){
            FacesUtils.addErrorMessage(MSG_TIPO_RESPIRACION);
            validocampos = false;
            
        }
        

        
        
        
        return validocampos;
    }
    

    private boolean validarSignosVitales() {
        boolean validar = true;
        Integer valorFrecuencia = 0;
        Integer valorSistole = 0;
        Integer valorDiastole = 0;
        Integer valorPeco = 0;
        Integer valorSaturacion = 0;

        valorSelectDiastole = 0;
        valorSelectFrecuencia = 0;
        valorSelectPeco = 0;
        valorSelectSaturacion = 0;
        valorSelectSistole = 0;

        if (tipoRespiracion == null || tipoRespiracion.equals("")) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_TIPO_RESPIRACION);
        }


        if (!selectFrecuencia0 && !selectFrecuencia10 && !selectFrecuencia20 && 
            !selectFrecuencia30 && !selectFrecuencia40 && 
            !selectFrecuencia50 && !selectFrecuencia60 && 
            !selectFrecuencia70 && !selectFrecuencia80 && 
            !selectFrecuencia90 && !selectFrecuencia100 && 
            !selectFrecuencia110 && !selectFrecuencia120 && 
            !selectFrecuencia130 && !selectFrecuencia140 && 
            !selectFrecuencia150 && !selectFrecuencia160 && 
            !selectFrecuencia170 && !selectFrecuencia180 && 
            !selectFrecuencia190 && !selectFrecuencia200 && 
            !selectFrecuencia210) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_FRECUENCIA_OBLIGATORIA);
        }


        if (!selectPresionSistole0 && !selectPresionSistole10 && 
            !selectPresionSistole20 && !selectPresionSistole30 && 
            !selectPresionSistole40 && !selectPresionSistole50 && 
            !selectPresionSistole60 && !selectPresionSistole70 && 
            !selectPresionSistole80 && !selectPresionSistole90 && 
            !selectPresionSistole100 && !selectPresionSistole110 && 
            !selectPresionSistole120 && !selectPresionSistole130 && 
            !selectPresionSistole140 && !selectPresionSistole150 && 
            !selectPresionSistole160 && !selectPresionSistole170 && 
            !selectPresionSistole180 && !selectPresionSistole190 && 
            !selectPresionSistole200 && !selectPresionSistole210) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_PRESION_SISTOLE_OBLIGATORIA);
        }


        if (!selectPresionDiastole0 && !selectPresionDiastole10 && 
            !selectPresionDiastole20 && !selectPresionDiastole30 && 
            !selectPresionDiastole40 && !selectPresionDiastole50 && 
            !selectPresionDiastole60 && !selectPresionDiastole70 && 
            !selectPresionDiastole80 && !selectPresionDiastole90 && 
            !selectPresionDiastole100 && !selectPresionDiastole110 && 
            !selectPresionDiastole120 && !selectPresionDiastole130 && 
            !selectPresionDiastole140 && !selectPresionDiastole150 && 
            !selectPresionDiastole160 && !selectPresionDiastole170 && 
            !selectPresionDiastole180 && !selectPresionDiastole190 && 
            !selectPresionDiastole200 && !selectPresionDiastole210) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_PRESION_DIASTOLE_OBLIGATORIA);
        }


      /*  if (!selectPeco0 && !selectPeco10 && !selectPeco20 && !selectPeco30 && 
            !selectPeco40 && !selectPeco50 && !selectPeco60 && !selectPeco70 && 
            !selectPeco80 && !selectPeco90 && !selectPeco100 && 
            !selectPeco110 && !selectPeco120 && !selectPeco130 && 
            !selectPeco140 && !selectPeco150 && !selectPeco160 && 
            !selectPeco170 && !selectPeco180 && !selectPeco190 && 
            !selectPeco200 && !selectPeco210) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_PECO2_OBLIGATORIA);
        }*/


        if (!selectSaturacion0 && !selectSaturacion10 && !selectSaturacion20 && 
            !selectSaturacion30 && !selectSaturacion40 && 
            !selectSaturacion50 && !selectSaturacion60 && 
            !selectSaturacion70 && !selectSaturacion80 && 
            !selectSaturacion90 && !selectSaturacion100 && 
            !selectSaturacion110 && !selectSaturacion120 && 
            !selectSaturacion130 && !selectSaturacion140 && 
            !selectSaturacion150 && !selectSaturacion160 && 
            !selectSaturacion170 && !selectSaturacion180 && 
            !selectSaturacion190 && !selectSaturacion200 && 
            !selectSaturacion210) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_SATURACION_OBLIGATORIA);
        }


        if (selectFrecuencia0) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 0 + digitoFC;
        }


        if (selectFrecuencia10) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 10 + digitoFC;
        }

        if (selectFrecuencia20) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 20 + digitoFC;
        }

        if (selectFrecuencia30) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 30 + digitoFC;
        }

        if (selectFrecuencia40) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 40 + digitoFC;
        }

        if (selectFrecuencia50) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 50 + digitoFC;
        }

        if (selectFrecuencia60) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 60 + digitoFC;
        }

        if (selectFrecuencia70) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 70 + digitoFC;
        }

        if (selectFrecuencia80) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 80 + digitoFC;
        }

        if (selectFrecuencia90) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 90 + digitoFC;
        }

        if (selectFrecuencia100) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 100 + digitoFC;
        }

        if (selectFrecuencia110) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 110 + digitoFC;
        }

        if (selectFrecuencia120) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 120 + digitoFC;
        }

        if (selectFrecuencia130) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 130 + digitoFC;
        }

        if (selectFrecuencia140) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 140 + digitoFC;
        }

        if (selectFrecuencia150) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 150 + digitoFC;
        }

        if (selectFrecuencia160) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 160 + digitoFC;
        }

        if (selectFrecuencia170) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 170 + digitoFC;
        }

        if (selectFrecuencia180) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 180 + digitoFC;
        }

        if (selectFrecuencia190) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 190 + digitoFC;
        }

        if (selectFrecuencia200) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 200 + digitoFC;
        }

        if (selectFrecuencia210) {
            valorFrecuencia = valorFrecuencia + 1;
            valorSelectFrecuencia = 210 + digitoFC;
        }


        if (selectPresionSistole0) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 0 + digitoSistolica;
        }


        if (selectPresionSistole10) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 10 + digitoSistolica;
        }

        if (selectPresionSistole20) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 20 + digitoSistolica;
        }

        if (selectPresionSistole30) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 30 + digitoSistolica;
        }

        if (selectPresionSistole40) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 40 + digitoSistolica;
        }

        if (selectPresionSistole50) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 50 + digitoSistolica;
        }

        if (selectPresionSistole60) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 60 + digitoSistolica;
        }

        if (selectPresionSistole70) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 70 + digitoSistolica;
        }

        if (selectPresionSistole80) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 80 + digitoSistolica;
        }

        if (selectPresionSistole90) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 90 + digitoSistolica;
        }

        if (selectPresionSistole100) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 100 + digitoSistolica;
        }

        if (selectPresionSistole110) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 110 + digitoSistolica;
        }


        if (selectPresionSistole120) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 120 + digitoSistolica;
        }

        if (selectPresionSistole130) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 130 + digitoSistolica;
        }

        if (selectPresionSistole140) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 140 + digitoSistolica;
        }

        if (selectPresionSistole150) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 150 + digitoSistolica;
        }

        if (selectPresionSistole160) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 160 + digitoSistolica;
        }

        if (selectPresionSistole170) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 170 + digitoSistolica;
        }

        if (selectPresionSistole180) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 180 + digitoSistolica;
        }

        if (selectPresionSistole190) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 190 + digitoSistolica;
        }

        if (selectPresionSistole200) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 200 + digitoSistolica;
        }

        if (selectPresionSistole210) {
            valorSistole = valorSistole + 1;
            valorSelectSistole = 210 + digitoSistolica;
        }


        if (selectPresionDiastole0) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 0 + digitoDiastolica;
        }

        if (selectPresionDiastole10) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 10 + digitoDiastolica;
        }

        if (selectPresionDiastole20) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 20 + digitoDiastolica;
        }

        if (selectPresionDiastole30) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 30 + digitoDiastolica;
        }

        if (selectPresionDiastole40) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 40 + digitoDiastolica;
        }

        if (selectPresionDiastole50) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 50 + digitoDiastolica;
        }

        if (selectPresionDiastole60) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 60 + digitoDiastolica;
        }

        if (selectPresionDiastole70) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 70 + digitoDiastolica;
        }

        if (selectPresionDiastole80) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 80 + digitoDiastolica;
        }

        if (selectPresionDiastole90) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 90 + digitoDiastolica;
        }

        if (selectPresionDiastole100) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 100 + digitoDiastolica;
        }

        if (selectPresionDiastole110) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 110 + digitoDiastolica;
        }

        if (selectPresionDiastole120) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 120 + digitoDiastolica;
        }

        if (selectPresionDiastole130) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 130 + digitoDiastolica;
        }

        if (selectPresionDiastole140) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 140 + digitoDiastolica;
        }

        if (selectPresionDiastole150) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 150 + digitoDiastolica;
        }

        if (selectPresionDiastole160) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 160 + digitoDiastolica;
        }

        if (selectPresionDiastole170) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 170 + digitoDiastolica;
        }

        if (selectPresionDiastole180) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 180 + digitoDiastolica;
        }

        if (selectPresionDiastole190) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 190 + digitoDiastolica;
        }

        if (selectPresionDiastole200) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 200 + digitoDiastolica;
        }

        if (selectPresionDiastole210) {
            valorDiastole = valorDiastole + 1;
            valorSelectDiastole = 210 + digitoDiastolica;
        }


        if (selectPeco0) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 0 + digitoPeco;
        }

        if (selectPeco10) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 10 + digitoPeco;
        }

        if (selectPeco20) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 20 + digitoPeco;
        }

        if (selectPeco30) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 30 + digitoPeco;
        }

        if (selectPeco40) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 40 + digitoPeco;
        }

        if (selectPeco50) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 50 + digitoPeco;
        }

        if (selectPeco60) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 60 + digitoPeco;
        }

        if (selectPeco70) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 70 + digitoPeco;
        }

        if (selectPeco80) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 80 + digitoPeco;
        }

        if (selectPeco90) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 90 + digitoPeco;
        }

        if (selectPeco100) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 100 + digitoPeco;
        }

        if (selectPeco110) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 110 + digitoPeco;
        }

        if (selectPeco120) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 120 + digitoPeco;
        }

        if (selectPeco130) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 130 + digitoPeco;
        }

        if (selectPeco140) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 140 + digitoPeco;
        }

        if (selectPeco150) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 150 + digitoPeco;
        }

        if (selectPeco160) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 160 + digitoPeco;
        }

        if (selectPeco170) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 170 + digitoPeco;
        }

        if (selectPeco180) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 180 + digitoPeco;
        }

        if (selectPeco190) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 190 + digitoPeco;
        }

        if (selectPeco200) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 200 + digitoPeco;
        }

        if (selectPeco210) {
            valorPeco = valorPeco + 1;
            valorSelectPeco = 210 + digitoPeco;
        }

        if (selectSaturacion0) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 0 + digitoSaturacion;
        }

        if (selectSaturacion10) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 10 + digitoSaturacion;
        }

        if (selectSaturacion20) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 20 + digitoSaturacion;
        }

        if (selectSaturacion30) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 30 + digitoSaturacion;
        }

        if (selectSaturacion40) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 40 + digitoSaturacion;
        }

        if (selectSaturacion50) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 50 + digitoSaturacion;
        }

        if (selectSaturacion60) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 60 + digitoSaturacion;
        }

        if (selectSaturacion70) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 70 + digitoSaturacion;
        }

        if (selectSaturacion80) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 80 + digitoSaturacion;
        }

        if (selectSaturacion90) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 90 + digitoSaturacion;
        }

        if (selectSaturacion100) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 100 + digitoSaturacion;
        }

        if (selectSaturacion110) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 110 + digitoSaturacion;
        }

        if (selectSaturacion120) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 120 + digitoSaturacion;
        }

        if (selectSaturacion130) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 130 + digitoSaturacion;
        }

        if (selectSaturacion140) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 140 + digitoSaturacion;
        }

        if (selectSaturacion150) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 150 + digitoSaturacion;
        }

        if (selectSaturacion160) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 160 + digitoSaturacion;
        }

        if (selectSaturacion170) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 170 + digitoSaturacion;
        }

        if (selectSaturacion180) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 180 + digitoSaturacion;
        }

        if (selectSaturacion190) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 190 + digitoSaturacion;
        }

        if (selectSaturacion200) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 200 + digitoSaturacion;
        }

        if (selectSaturacion210) {
            valorSaturacion = valorSaturacion + 1;
            valorSelectSaturacion = 210 + digitoSaturacion;
        }

        if (valorDiastole > 1) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_PRESION_DIASTOLE_UNICA);
        }

        if (valorSistole > 1) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_PRESION_SISTOLE_UNICA);
        }


        if (valorFrecuencia > 1) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_FRECUENCIA_UNICA);
        }

        if (valorPeco > 1) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_PECO2_UNICA);
        }

        if (valorSaturacion > 1) {
            validar = false;
            FacesUtils.addErrorMessage(MSG_SATURACION_UNICA);
        }


        return validar;
    }


    //-----------------------------------------------------------------------
    //  Boton Principal 
    //----------------------------------------------------------------------- 

    public void guardarSignoVital() {
        Chsignovital signoAux = new Chsignovital();
        ChsignovitalPK idsigno = new ChsignovitalPK();

        signoAux = (Chsignovital)this.dtSignosVitales.getRowData();

        if (signoAux == null || signoAux.getId() == null || 
            signoAux.getId().getHsvlconsecutiv() == null) {
            idsigno.setHsvlconsulta(numeroCirugia);
            signoAux.setId(idsigno);
        }

        signoAux.setHsvdfecregistr(new Date());
        signoAux.setHsvcestado(ESTADO_VIGENTE);
        signoAux.setHsvcoperador(userName());


        try {
            this.serviceLocator.getCirugiaService().saveSignosVitales(signoAux);
            lstSignoVital = 
                    serviceLocator.getCirugiaService().getSignosVitalesAnestesia(numeroCirugia);
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION + " " + e.getMessage());
            e.printStackTrace();
        }


    }
    
    
    public String nextPage(){
        navigationRule="irRegistrarMonitoriaAnestesia";
        
        return navigationRule;
    }


    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setRenderVistaClasica(boolean renderVistaClasica) {
        this.renderVistaClasica = renderVistaClasica;
    }

    public boolean isRenderVistaClasica() {
        return renderVistaClasica;
    }

    public void setVistaClasica(String vistaClasica) {
        this.vistaClasica = vistaClasica;
    }

    public String getVistaClasica() {
        return vistaClasica;
    }

    public void setLstTipoVista(List lstTipoVista) {
        this.lstTipoVista = lstTipoVista;
    }

    public List getLstTipoVista() {
        if (lstTipoVista == null || lstTipoVista.isEmpty()) {
            lstTipoVista = new ArrayList();
            lstTipoVista.add(new SelectItem("C", "Clasica"));
            lstTipoVista.add(new SelectItem("N", "Nueva"));
           
        }
        return lstTipoVista;
        }


    public void setFrecuenciaCardiacaNuevo(Integer frecuenciaCardiacaNuevo) {
        this.frecuenciaCardiacaNuevo = frecuenciaCardiacaNuevo;
    }

    public Integer getFrecuenciaCardiacaNuevo() {
        return frecuenciaCardiacaNuevo;
    }

    public void setSistolicaNuevo(Integer sistolicaNuevo) {
        this.sistolicaNuevo = sistolicaNuevo;
    }

    public Integer getSistolicaNuevo() {
        return sistolicaNuevo;
    }

    public void setDiastolicaNuevo(Integer diastolicaNuevo) {
        this.diastolicaNuevo = diastolicaNuevo;
    }

    public Integer getDiastolicaNuevo() {
        return diastolicaNuevo;
    }

    public void setPecoNuevo(Integer pecoNuevo) {
        this.pecoNuevo = pecoNuevo;
    }

    public Integer getPecoNuevo() {
        return pecoNuevo;
    }

    public void setSaturacionNuevo(Integer saturacionNuevo) {
        this.saturacionNuevo = saturacionNuevo;
    }

    public Integer getSaturacionNuevo() {
        return saturacionNuevo;
    }

    public void setRespiracionNuevo(String respiracionNuevo) {
        this.respiracionNuevo = respiracionNuevo;
    }

    public String getRespiracionNuevo() {
        return respiracionNuevo;
    }

    public void setModificarHoraInicial(String modificarHoraInicial) {
        this.modificarHoraInicial = modificarHoraInicial;
    }

    public String getModificarHoraInicial() {
        return modificarHoraInicial;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No"));
           
        }
        return lstOpciones;
        }

    public void setModificarHoraInicial(ValueChangeEvent valueChangeEvent) {
        setModificarHoraInicial((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
    
    public void changeHoraSignos(){
        renderHoraNueva = false; 
         if(modificarHoraInicial != null && modificarHoraInicial.equals("S")){
             renderHoraNueva = true;
         }
        
    }

    public void setRenderHoraNueva(boolean renderHoraNueva) {
        this.renderHoraNueva = renderHoraNueva;
    }

    public boolean isRenderHoraNueva() {
        return renderHoraNueva;
    }

    public void setHoraNuevaSelect(Integer horaNuevaSelect) {
        this.horaNuevaSelect = horaNuevaSelect;
    }

    public Integer getHoraNuevaSelect() {
        return horaNuevaSelect;
    }

    public void setMinutoNuevoSelect(Integer minutoNuevoSelect) {
        this.minutoNuevoSelect = minutoNuevoSelect;
    }

    public Integer getMinutoNuevoSelect() {
        return minutoNuevoSelect;
    }
    
    public void modificarHora(){
       
        if(horaSelect != null && minutoSelect != null 
                && horaNuevaSelect != null && minutoNuevoSelect != null){
            Calendar fechaOriginal = Calendar.getInstance();
             fechaOriginal.setTime(fechaInicio);
             fechaOriginal.set(Calendar.HOUR_OF_DAY, horaSelect);
            fechaOriginal.set(Calendar.MINUTE, minutoSelect);  
            
            Calendar nuevaFecha= Calendar.getInstance();
             nuevaFecha.setTime(fechaInicio);
             nuevaFecha.set(Calendar.HOUR_OF_DAY, horaNuevaSelect);
            nuevaFecha.set(Calendar.MINUTE, minutoNuevoSelect);  
            
            long diff =  nuevaFecha.getTimeInMillis() - fechaOriginal.getTimeInMillis();        
            long diffMinutes = diff / (60 * 1000);


            try {
                serviceLocator.getCirugiaService().actualizarMinutosSignosVitales(numeroCirugia, diffMinutes);
            } catch (ModelException e) {
               e.printStackTrace();
            }
            
            if (numeroCirugia != null) {
                try {
                    lstSignoVital = 
                            serviceLocator.getCirugiaService().getSignosVitalesAnestesia(numeroCirugia);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            
            horaSelect = horaNuevaSelect;
            minutoSelect = minutoNuevoSelect;
            horaNuevaSelect = null; 
            minutoNuevoSelect = null;
            renderHoraNueva = false; 
            
            
            
                
            
        }else{
            FacesUtils.addErrorMessage("Debe Seleccionar todos los datos para modificar la hora de Inicio de Actividades");
        }
        
    
    }

    public void setHoraNuevaSelect(ValueChangeEvent valueChangeEvent) {
        setHoraNuevaSelect((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setMinutoNuevoSelect(ValueChangeEvent valueChangeEvent) {
        setMinutoNuevoSelect((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
}
