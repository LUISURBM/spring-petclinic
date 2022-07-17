//=======================================================================
// ARCHIVO RegistrarLiquidosAnestesiaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis, andres vargas
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;

import java.net.URL;

import java.util.ArrayList;
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

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.ChcontroliquPK;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chliquiparen;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarLiquidosAnestesiaBean
//=======================================================================
public class RegistrarLiquidosAnestesiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chcontroliqu liquidos;
    private Chcontroliqu liquidosEliminados;

    private Integer horainicioadministracion;
    private Integer minutoinicioadministracion;
    private Integer horafinadministracion;
    private Integer minutofinadministracion;

    private List listHora;
    private List lstMinutos;
    private List lstTipoSolucion;
    private List lstOpciones;
    private List lstAspecto;
    private List lstTipoAspecto;
    private List<Chcontroliqu> lstLiquidosAdministradosAnestesia;
    private List<Chcontroliqu> lstLiquidosEliminados;
    private List<Chcontroliqu> lstLiquidosSuspendidos;
    private List<Chcontroliqu> lstLiquidosAdministrados;

    private boolean mostrarotro;
    private boolean mostrarDiuresis;
    private boolean mostrarHemorragia;
    private boolean mostrarDrenaje;
    private boolean mostrarAspecto;

    private Long numeroCirugia;
    private String tipoServicio;

    //private HtmlDataTable dtLiquidos;

    private Long numeroUsuario;

    private Chusuario usuario;

    private boolean generoReporte;

    /* Guarda la lista de liquidos que han sido terminados parcialmente */
    private List<Chcontroliqu> lstLiquidosParciales;

    private List<Chcontroliqu> lstHistorialLiquidosEliminados;

    private boolean renderOtro;

    private List lstLiquidoParentales;
    
    private boolean renderDiuresis;
    
    private boolean renderCantidadDiuresis;
    
    private UIInput mnuTipoDiuresis;

    private boolean renderSangre;

    private boolean mostrarAdministracion;

    private List lstVia;

    private List lstFormaAdministracion;

    private boolean mostrarFormaAdmin;

    private List lstClaseSangre;

    private List lstGrupoSangre;

    private List lstFactorSangre;

    private List<Chcontroliqu> lstLiquidos;

    private Integer consecutivo;

    private Chcontroliqu liquidosDelete;
    
    private UIInput mnuDiuresis;

    private List<Chcontroliqu> lstLiquidosAdministrar;

    private HtmlDataTable dtLiquidosFormuladosAnestesia;

    private List<Chcontroliqu> lstLiquidosSelect;
    
    private List<Chcontroliqu> lstLiquidosSelectAdmin;

    private HtmlDataTable dtLiquidosParciales;
    
    private HtmlDataTable dtLiquidosEnAdministracion;

    private List lstOpcionesLiquidos;

    private String opcionLiquido;

    private boolean esSuspencion;

    private HtmlDataTable dtLiquidosEnAdministracionAnestesia;

    private List<Chcontroliqu> lstLiquidosSelectEnAdministracion;

    private String nextAction;

    private List<Chcontroliqu> lstLiquidosParcialesIniciado;

    private boolean controlLiquido;
    
    private Integer totalLiqAdmin;
    
    private Integer totalLiqElim;
    
    private String navigationRule;
    
    private Chcontroliqu liquidoDelete;
    
    private UIInput mnuCuantificadaDiuresis;
    
    private UIInput itCantidadDiuresis;

    private List lstTipoDiuresis;
    
    private boolean renderDeposiciones;
    
    private boolean renderCantidadDeposiciones;
    
    private UIInput mnuDeposiciones;
    
    private UIInput mnuCuantificadaDeposiciones;

    private UIInput itCantidadDeposiciones;
    
    private boolean renderEmesis;
    
    private boolean renderEmeCuanti;
    
    private UIInput mnuEmesis; 
    
    private UIInput mnuCuantifi;
    
    private UIInput itCantidadEmesis;
    
    private boolean renderDrenaje;

    private boolean renderCantidadDrenaje;
    
    private UIInput mnuDrenaje;
    
    private UIInput mnuTipoDrenaje;
    
    private UIInput mnuCuantificadaDrenaje;
    
    private UIInput itCantidadDrenaje;
    
    private List lstTipoDrenaje;
    
    private Chcirugprogr cirugia; 
    
    private List<Chcontroliqu> lstLiquidosEliminadosSelect;
    
    private HtmlDataTable dtLiquidosEliminados;
    
    private String navegationRule; 
    
    private Cpservicio servicio;
    
    private Chdetacirpro detalleCirugia;
    
    private Integer cantidadSumin;
    
    private String usuarioSystem;
    
    private List<Cnconsclin> lstConsclin;
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarLiquidosAnestesiaBean() {
    }


    public void init() {
    
        liquidoDelete = new Chcontroliqu();
        
        lstLiquidosEliminadosSelect = new ArrayList<Chcontroliqu>();
        liquidos = new Chcontroliqu();
        liquidosEliminados = new Chcontroliqu();
        lstLiquidosAdministrar = new ArrayList<Chcontroliqu>();
        lstLiquidosParcialesIniciado = new ArrayList<Chcontroliqu>();
        listHora = new ArrayList();
        lstMinutos = new ArrayList();
        lstTipoSolucion = new ArrayList();
        lstOpciones = new ArrayList();
        lstAspecto = new ArrayList();
        lstTipoAspecto = new ArrayList();
        lstLiquidosEliminados = new ArrayList<Chcontroliqu>();
        lstHistorialLiquidosEliminados = new ArrayList<Chcontroliqu>();
        renderOtro = false;
        renderSangre = false;
        mostrarAdministracion = false;
        mostrarFormaAdmin = false;
        lstVia = new ArrayList();
        lstFormaAdministracion = new ArrayList();
        lstOpcionesLiquidos = new ArrayList();
        controlLiquido = false;
        totalLiqAdmin = 0;
        totalLiqElim = 0;
        cargarDatos();
    }

    public void cargarDatos() {
        try {
            lstLiquidosAdministrar = 
                    this.serviceLocator.getCirugiaService().getLstLiquidosFormuladosAnestesia(numeroCirugia);
            if(lstLiquidosAdministrar != null && !lstLiquidosAdministrar.isEmpty()){
                for(Chcontroliqu formu : lstLiquidosAdministrar){
                    try{
                        usuarioSystem = 
                            this.serviceLocator.getClinicoService().getNombreUsuarioPorId(userName());
                    }catch(ModelException e){
                        e.printStackTrace();                                  
                    }
                    if(usuarioSystem != null){
                        formu.setNombreOperador(usuarioSystem);
                    }
                }
            }
            
            lstLiquidosAdministradosAnestesia = 
                    this.serviceLocator.getClinicoService().getLstLiquidosAdministradosAnestesia(numeroCirugia);
                    
            lstLiquidosParciales = 
                    this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesiaIni(numeroCirugia);
                    
            if(lstLiquidosParciales != null && !lstLiquidosParciales.isEmpty()){
                for( Chcontroliqu liqpa: lstLiquidosParciales){
                    if(liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("01")){
                        liqpa.setHclcdesctipoli("Lactato de Ringer");
                    }
                    if (liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("02")) {
                        liqpa.setHclcdesctipoli("Haemacell");
                    }
                    if (liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("03")) {
                        liqpa.setHclcdesctipoli("Dextranes");
                    }
                    if (liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("04")) {
                        liqpa.setHclcdesctipoli("Globulos Rojos");
                    }
                    if (liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("05")) {
                        liqpa.setHclcdesctipoli("Sangre total");
                    }
                    if (liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("06")) {
                        liqpa.setHclcdesctipoli("Plasma");
                    }
                    if (liqpa.getHclctipoliqpar() != null && liqpa.getHclctipoliqpar().equals("07")) {
                        liqpa.setHclcdesctipoli("Plaquetas");
                    }
                    if(liqpa.getHclcetapa().equals("VG")){
                        liqpa.setHclcmoduladmin("Enfermeria");
                    }                  
                    if(liqpa.getHclcetapa().equals("IL")){
                        liqpa.setHclcmoduladmin("Anestesia");
                    }
                }
            }

            lstHistorialLiquidosEliminados = 
                    this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(numeroCirugia);

            if (lstLiquidosAdministradosAnestesia == null || lstLiquidosAdministradosAnestesia.isEmpty()) {
                lstLiquidosAdministradosAnestesia = new ArrayList<Chcontroliqu>();
            } else {
                for (Chcontroliqu contrliq: lstLiquidosAdministradosAnestesia) {
                    if (contrliq.getHclncantisumin() != null)
                        totalLiqAdmin += contrliq.getHclncantisumin();
                    contrliq.setTipoRegistro("A");
                }
            }
            
            if (lstHistorialLiquidosEliminados == null || lstHistorialLiquidosEliminados.isEmpty()) {
                lstHistorialLiquidosEliminados = new ArrayList<Chcontroliqu>();
            } else {
                for (Chcontroliqu contrliqE: lstHistorialLiquidosEliminados) {
                    if (contrliqE.getHclndrenaje() != null){
                        totalLiqElim += contrliqE.getHclndrenaje();
                    }
                        
                    if (contrliqE.getHclndiuresis() != null){
                        totalLiqElim += contrliqE.getHclndiuresis();
                    } 
                    
                    if (contrliqE.getHclndeposicion() != null){
                        totalLiqElim += contrliqE.getHclndeposicion();
                    } 
                    if(contrliqE.getHclnemecan() != null){
                        totalLiqElim += contrliqE.getHclnemecan();
                    }

                    contrliqE.setTipoRegistro("E");
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstLiquidosAdministradosAnestesia == null) {
            lstLiquidosAdministradosAnestesia = new ArrayList<Chcontroliqu>();
        }

        if (lstLiquidosEliminados == null || lstLiquidosEliminados.isEmpty()) {
            lstLiquidosEliminados = new ArrayList<Chcontroliqu>();
        }

        if (lstLiquidos == null) {
            lstLiquidos = new ArrayList<Chcontroliqu>();
        }

        if (lstLiquidosAdministrar == null) {
            lstLiquidosAdministrar = new ArrayList<Chcontroliqu>();
        }
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param liquidos
     */
    public void setLiquidos(Chcontroliqu liquidos) {
        this.liquidos = liquidos;
    }

    /**
     * @return
     */
    public Chcontroliqu getLiquidos() {
        return liquidos;
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
     * @param horainicioadministracion
     */
    public void setHorainicioadministracion(Integer horainicioadministracion) {
        this.horainicioadministracion = horainicioadministracion;
    }

    /**
     * @return
     */
    public Integer getHorainicioadministracion() {
        return horainicioadministracion;
    }

    /**
     * @param minutoinicioadministracion
     */
    public void setMinutoinicioadministracion(Integer minutoinicioadministracion) {
        this.minutoinicioadministracion = minutoinicioadministracion;
    }

    /**
     * @return
     */
    public Integer getMinutoinicioadministracion() {
        return minutoinicioadministracion;
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
     * @param liquidosEliminados
     */
    public void setLiquidosEliminados(Chcontroliqu liquidosEliminados) {
        this.liquidosEliminados = liquidosEliminados;
    }

    /**
     * @return
     */
    public Chcontroliqu getLiquidosEliminados() {
        return liquidosEliminados;
    }

    /**
     * @param lstLiquidosEliminados
     */
    public void setLstLiquidosEliminados(List<Chcontroliqu> lstLiquidosEliminados) {
        this.lstLiquidosEliminados = lstLiquidosEliminados;
    }

    /**
     * @return
     */
    public List<Chcontroliqu> getLstLiquidosEliminados() {
        return lstLiquidosEliminados;
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
     * @param mostrarAspecto
     */
    public void setMostrarAspecto(boolean mostrarAspecto) {
        this.mostrarAspecto = mostrarAspecto;
    }

    /**
     * @return
     */
    public boolean isMostrarAspecto() {
        return mostrarAspecto;
    }

    /**
     * @param horafinadministracion
     */
    public void setHorafinadministracion(Integer horafinadministracion) {
        this.horafinadministracion = horafinadministracion;
    }

    /**
     * @return
     */
    public Integer getHorafinadministracion() {
        return horafinadministracion;
    }

    /**
     * @param minutofinadministracion
     */
    public void setMinutofinadministracion(Integer minutofinadministracion) {
        this.minutofinadministracion = minutofinadministracion;
    }

    /**
     * @return
     */
    public Integer getMinutofinadministracion() {
        return minutofinadministracion;
    }

    /**
     * @param lstTipoSolucion
     */
    public void setLstTipoSolucion(List lstTipoSolucion) {
        this.lstTipoSolucion = lstTipoSolucion;
    }

    /**
     * @return
     */
    public List getLstTipoSolucion() {
        if (lstTipoSolucion.size() == 0) {
            ArrayList<Chliquiparen> listliquidosAux = null;
            try {
                listliquidosAux = 
                        (ArrayList<Chliquiparen>)this.serviceLocator.getClinicoService().getLiquidoParenterales();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listliquidosAux.isEmpty()) {
                Iterator it = listliquidosAux.iterator();
                int i = 0;
                lstTipoSolucion.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstTipoSolucion.add(new SelectItem(listliquidosAux.get(i).getHlpccodigo(), 
                                                       listliquidosAux.get(i).getHlpcdescripcio()));
                    i++;
                }
            }
        }
        return lstTipoSolucion;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHclcdiuresis(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcdiuresis((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

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
     * @param lstAspecto
     */
    public void setLstAspecto(List lstAspecto) {
        this.lstAspecto = lstAspecto;
    }

    /**
     * @return
     */
    public List getLstAspecto() {
        if (lstAspecto.size() == 0) {
            lstAspecto.add(new SelectItem("N", "Normal"));
            lstAspecto.add(new SelectItem("H", "Hemat�rica"));
        }
        return lstAspecto;
    }

    /**
     * @param lstTipoAspecto
     */
    public void setLstTipoAspecto(List lstTipoAspecto) {
        this.lstTipoAspecto = lstTipoAspecto;
    }

    /**
     * @return
     */
    public List getLstTipoAspecto() {
        if (lstTipoAspecto.size() == 0) {
            lstTipoAspecto.add(new SelectItem("L", "Leve"));
            lstTipoAspecto.add(new SelectItem("M", "Moderada"));
            lstTipoAspecto.add(new SelectItem("S", "Severa"));
        }
        return lstTipoAspecto;
    }

    /**
     * @param mostrarDiuresis
     */
    public void setMostrarDiuresis(boolean mostrarDiuresis) {
        this.mostrarDiuresis = mostrarDiuresis;
    }

    /**
     * @return
     */
    public boolean isMostrarDiuresis() {
        return mostrarDiuresis;
    }

    /**
     * @param mostrarHemorragia
     */
    public void setMostrarHemorragia(boolean mostrarHemorragia) {
        this.mostrarHemorragia = mostrarHemorragia;
    }

    /**
     * @return
     */
    public boolean isMostrarHemorragia() {
        return mostrarHemorragia;
    }

    /**
     * @param mostrarDrenaje
     */
    public void setMostrarDrenaje(boolean mostrarDrenaje) {
        this.mostrarDrenaje = mostrarDrenaje;
    }

    /**
     * @return
     */
    public boolean isMostrarDrenaje() {
        return mostrarDrenaje;
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

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }


    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------
    /**
     * @param valueChangeEvent
     */
    public void setHclctipoliquid(ValueChangeEvent valueChangeEvent) {
        liquidos.setHclctipoliquid((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setFormaAdministracion(ValueChangeEvent valueChangeEvent) {
        liquidos.setHclcformadmins((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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

        if (tipoServicio != null) {
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
        }else{
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

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //----------------------------------------------------------------------- 

    public void eliminarLiquido() {
        Chcontroliqu liquidosdelete = null;
        //  liquidosdelete = (Chcontroliqu)this.dtLiquidos.getRowData();
    }


    public void agregarLiquido() {
        Chcontroliqu liquidosAux;
        ChcontroliquPK idLiquidos = new ChcontroliquPK();
        liquidosAux = new Chcontroliqu();

        /* if (liquidos != null) {
            liquidosAux.setHclcetapa(ETAPA_VIGENTE);
            liquidos.setHcldfechactivi(new Date());
            liquidosAux.setHcldfechactfin(liquidos.getHcldfechactfin());
            liquidos.setHcld(new Date());
            liquidosAux.setHladhorafinali(liquidos.getHladhorafinali());
            idLiquidos.setHlalnumero(numeroCirugia);
            idLiquidos.setHlactiposervi(tipoServicio);
            idLiquidos.setHlacadminelimi(REGISTRAR_LIQUIDO_ADMINISTRADO);

            liquidosAux.setId(idLiquidos);
            liquidosAux.setHlacoperador(userName());
            liquidosAux.setHladfecregistr(new Date());
            liquidosAux.setHlanlineavenos(liquidos.getHlanlineavenos());
            liquidosAux.setHlactiposoluci(liquidos.getHlactiposoluci());
            liquidosAux.setHlacotroliquid(liquidos.getHlacotroliquid());
            liquidosAux.setHlanliquiadmin(liquidos.getHlanliquiadmin());
            liquidosAux.setHlacinfusconti(liquidos.getHlacinfusconti());
            liquidosAux.setHlancantiinfus(liquidos.getHlancantiinfus());
            liquidosAux.setHlanclinica(this.getClinica().getCclncodigo());

            try {
                this.serviceLocator.getClinicoService().saveLiquidosAnestesia(liquidosAux,IConstantes.REGISTRAR_LIQUIDO_ADMINISTRADO);
                lstLiquidosAdministrados =
                        this.serviceLocator.getClinicoService().getLiquidosAdministradosAnestesia(numeroCirugia,
                                                                                                  tipoServicio);
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }

            liquidos = new Chcontliqane();
            horainicioadministracion = null;
            minutoinicioadministracion = null;
            horafinadministracion = null;
            minutofinadministracion = null;
        }*/
    }


    /**
     * @return
     */
    public String RegistrarAdministracionLiquidos() {
        if (!lstLiquidosAdministradosAnestesia.isEmpty()) {
        } else {
            FacesUtils.addErrorMessage(MSG_TABLA_VACIA);
        }
        return null;
    }

    public void ChangeSangre() {
        if (liquidos != null) {
            if (liquidos.getHclctipoliquid() != null && 
                liquidos.getHclctipoliquid().equals("05")) {
                renderSangre = true;
                renderOtro = false;
            } else if (liquidos.getHclctipoliquid() != null && 
                       liquidos.getHclctipoliquid().equals("06")) {
                renderOtro = true;
                renderSangre = false;
            } else {
                renderSangre = false;
                renderOtro = false;
            }
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

    /**
     * @param lstLiquidoParentales
     */
    public void setLstLiquidoParentales(List lstLiquidoParentales) {
        this.lstLiquidoParentales = lstLiquidoParentales;
    }

    /**
     * @return
     */
    public List getLstLiquidoParentales() {
        if (lstLiquidoParentales == null) {
            lstLiquidoParentales = new ArrayList();
            ArrayList<Chliquiparen> listliquidosAux = null;
            try {
                listliquidosAux = 
                        (ArrayList<Chliquiparen>)this.serviceLocator.getClinicoService().getLiquidoParenterales();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listliquidosAux.isEmpty()) {
                Iterator it = listliquidosAux.iterator();
                int i = 0;
                lstLiquidoParentales.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstLiquidoParentales.add(new SelectItem(listliquidosAux.get(i).getHlpccodigo(), 
                                                            listliquidosAux.get(i).getHlpcdescripcio()));
                    i++;
                }
            }
        }
        return lstLiquidoParentales;
    }

    /**
     * @return
     */
    public String RegistrarEliminacionLiquidos() {
        Chcontroliqu liquidosAux;
        ChcontroliquPK idLiquidos = new ChcontroliquPK();
        liquidosAux = new Chcontroliqu();

        if (liquidos != null) {
        }

        liquidosEliminados = new Chcontroliqu();
        mostrarDiuresis = false;
        mostrarDrenaje = false;
        mostrarHemorragia = false;
        mostrarAspecto = false;
        return null;
    }

    public void setRenderSangre(boolean renderSangre) {
        this.renderSangre = renderSangre;
    }

    public boolean isRenderSangre() {
        return renderSangre;
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
            lstVia.add(new SelectItem("IV", "Intravenosa"));
            //   lstVia.add(new SelectItem("IO", "Intra�sea"));
            //   lstVia.add(new SelectItem("GA", "Gastroclisis"));
        }
        return lstVia;
    }

    public void ChangeViaAdministracion() {
        if (liquidos.getHclcvialiquido() != null && 
            liquidos.getHclcvialiquido().equals("IV")) {
            mostrarAdministracion = true;
            if (liquidos.getHclcvialiquido() != null) {
                this.lstFormaAdministracion = new ArrayList<SelectItem>();
                lstFormaAdministracion.add(new SelectItem("I", "En infusi�n"));
                lstFormaAdministracion.add(new SelectItem("L", "En bolo"));
            }
        } else {
            liquidos.setHclcformadmins(null);
            liquidos.setHclnvelocidadm(null);
            mostrarAdministracion = false;
        }
    }

    public void ChangeFormaAdmin() {
        if (liquidos.getHclcformadmins() != null && 
            liquidos.getHclcformadmins().equals("I")) {
            mostrarFormaAdmin = true;
        } else {
            mostrarFormaAdmin = false;
        }
    }

    /**
     * @param lstFormaAdministracion
     */
    public void setLstFormaAdministracion(List lstFormaAdministracion) {
        this.lstFormaAdministracion = lstFormaAdministracion;
    }

    /**
     * @return
     */
    public List getLstFormaAdministracion() {
        if (lstFormaAdministracion.size() == 0) {
            lstFormaAdministracion.add(new SelectItem("", "Seleccione una opci�n "));
            lstFormaAdministracion.add(new SelectItem("L", "En Bolo "));
            lstFormaAdministracion.add(new SelectItem("I", "En infusi�n"));
        }
        return lstFormaAdministracion;
    }

    /**
     * @param mostrarFormaAdmin
     */
    public void setMostrarFormaAdmin(boolean mostrarFormaAdmin) {
        this.mostrarFormaAdmin = mostrarFormaAdmin;
    }

    /**
     * @return
     */
    public boolean isMostrarFormaAdmin() {
        return mostrarFormaAdmin;
    }

    /**
     * @param lstClaseSangre
     */
    public void setLstClaseSangre(List lstClaseSangre) {
        this.lstClaseSangre = lstClaseSangre;
    }

    /**
     * @return
     */
    public List getLstClaseSangre() {
        if (lstClaseSangre == null) {
            lstClaseSangre = new ArrayList();
            lstClaseSangre.add(new SelectItem("", "Seleccione.."));
            lstClaseSangre.add(new SelectItem("ST", "Sangre Total"));
            lstClaseSangre.add(new SelectItem("GR", "Globulos Rojos"));
            lstClaseSangre.add(new SelectItem("PL", "Plasma"));
        }
        return lstClaseSangre;
    }

    /**
     * @param lstGrupoSangre
     */
    public void setLstGrupoSangre(List lstGrupoSangre) {
        this.lstGrupoSangre = lstGrupoSangre;
    }

    /**
     * @return
     */
    public List getLstGrupoSangre() {
        if (lstGrupoSangre == null) {
            lstGrupoSangre = new ArrayList();
            lstGrupoSangre.add(new SelectItem("A", "A"));
            lstGrupoSangre.add(new SelectItem("AB", "AB"));
            lstGrupoSangre.add(new SelectItem("B", "B"));
            lstGrupoSangre.add(new SelectItem("O", "O"));
        }
        return lstGrupoSangre;
    }

    /**
     * @param lstFactorSangre
     */
    public void setLstFactorSangre(List lstFactorSangre) {
        this.lstFactorSangre = lstFactorSangre;
    }

    /**
     * @return
     */
    public List getLstFactorSangre() {
        if (lstFactorSangre == null) {
            lstFactorSangre = new ArrayList();
            lstFactorSangre.add(new SelectItem("P", "POS"));
            lstFactorSangre.add(new SelectItem("N", "NEG"));
        }
        return lstFactorSangre;
    }

    public void eliminarFormula() {
        //     liquidosDelete = (Chformulaliq)this.dtLiquidos.getRowData();
        this.lstLiquidos.remove(liquidosDelete);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }

    /**
     * @param valueChangeEvent
     */
    public void setViaAdministracion(ValueChangeEvent valueChangeEvent) {
        liquidos.setHclcvialiquido((String)valueChangeEvent.getNewValue());
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
    public void setHclcdrenaje(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclcdrenaje((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHclccuantdrena(ValueChangeEvent valueChangeEvent) {
        liquidoDelete.setHclccuantdrena((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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

    public void agregarLiquidos() {
        boolean wexi = true;
        String url = "body:formAnestesia:panelTabRegistrarAnestesia:";

        if (liquidos != null) {
            if (liquidos.getHclctipoliquid() == null || 
                liquidos.getHclctipoliquid().equals("")) {
                FacesUtils.addErrorMessage(url + "mnuNombreLiquido", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexi = false;
            }

            if (liquidos.getHclncantidad() == null) {
                FacesUtils.addErrorMessage(url + "itCantidad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexi = false;
            }

            if (liquidos.getHclcvialiquido() != null && 
                liquidos.getHclcvialiquido().equals("IV")) {

                if (liquidos.getHclcformadmins() == null || 
                    liquidos.getHclcformadmins().equals("")) {
                    FacesUtils.addErrorMessage(url + "mnuFormaAdministracion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexi = false;
                }

                if (liquidos.getHclcformadmins() != null && 
                    liquidos.getHclcformadmins().equals("I")) {

                    if (liquidos.getHclnvelocidadm() == null) {
                        FacesUtils.addErrorMessage(url + "itVelocidad", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wexi = false;
                    }
                }
            }
            if (liquidos.getHclctipoliquid().equals("05")) {
                if (liquidos.getHclctiposangre() == null) {
                    FacesUtils.addErrorMessage(url + "mnuClaseSangre", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexi = false;
                }
                if (liquidos.getHclcgrupsangre() == null) {
                    FacesUtils.addErrorMessage(url + "mnuFactorSangre", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexi = false;
                }
            }
        } else {
            wexi = false;
        }

        if (wexi) {
            liquidos.getId().setHcllnumero(numeroCirugia);
            liquidos.getId().setHclctiposervi(TIPO_HOSPITALIZACION);
            liquidos.setHclcoperador(userName());
            liquidos.setHcldfecregistr(new Date());
            liquidos.setHclcestado(ESTADO_VIGENTE);
            liquidos.setHclcetapa(ETAPA_ESPERA);
            liquidos.setHcllusuario(usuario.getHuslnumero());
            liquidos.setHclcetapcontro(ANESTESIA);
            lstLiquidos.add(liquidos);
            liquidos = new Chcontroliqu();
            mostrarAdministracion = false;
            renderSangre = false;
            renderOtro = false;
            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidos(lstLiquidos, 
                                                                                numeroCirugia, 
                                                                                null);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                lstLiquidos.clear();  
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
                lstLiquidosAdministrar = 
                        this.serviceLocator.getCirugiaService().getLstLiquidosFormuladosAnestesia(numeroCirugia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }


    public void administrarLiquidoFormulado() {
        Chcontroliqu formulaAdd;
        formulaAdd = 
                (Chcontroliqu)this.dtLiquidosFormuladosAnestesia.getRowData();
        lstLiquidosAdministrar.remove(formulaAdd);

        lstLiquidosSelect = new ArrayList<Chcontroliqu>();
        if (formulaAdd != null) {
            lstLiquidosSelect.add(formulaAdd);
            try {
                this.serviceLocator.getClinicoService().saveLstRegistroLiquidosAnestesiaEtapaIniciadoLiquido(lstLiquidosSelect, 
                                                                                         numeroCirugia);
                lstLiquidosParciales = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesiaIni(numeroCirugia);
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
     * 
     */
    public void administrarControlLiquidoIniciado() {
    
        Chcontroliqu formulaAdd;
        formulaAdd = 
                (Chcontroliqu)this.dtLiquidosEnAdministracion.getRowData();
        lstLiquidosAdministrar.remove(formulaAdd);

        lstLiquidosSelectAdmin = new ArrayList<Chcontroliqu>();
        if (formulaAdd != null) {
            lstLiquidosSelectAdmin.add(formulaAdd);
            try {
                lstLiquidosParcialesIniciado = 
                    this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesia(lstLiquidosSelectAdmin);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + ex.getMessage());
                ex.printStackTrace();
            }
        }
        if (lstLiquidosParcialesIniciado == null || 
            lstLiquidosParcialesIniciado.isEmpty()) {
            FacesUtils.addErrorMessage(MSG_SIN_DATOS);
        }
    }


    
    public void administrarLiquidos() {

        boolean wexito = true;
        Chcontroliqu formulaAdd;
        formulaAdd = 
                (Chcontroliqu)this.dtLiquidosEnAdministracionAnestesia.getRowData();
        lstLiquidosSelectEnAdministracion = new ArrayList<Chcontroliqu>();
        if (formulaAdd != null) {
            if (opcionLiquido != null && opcionLiquido.equals("S")) {
                formulaAdd.setHclcetapa(IConstantes.ETAPA_SUSPENDER);
                formulaAdd.setHclncantisumin(cantidadSumin);
                if (formulaAdd.getHclncantidad() != null && 
                    formulaAdd.getHclncantisumin() != null) {
                    if (formulaAdd.getHclncantisumin().compareTo(formulaAdd.getHclncantidad()) > 0) {
                        FacesUtils.addErrorMessage("Error La Cantidad Suspendida no puede ser mayor a la Cantidad Inicial ");
                        wexito = false;
                    }
                }else{
                     if (formulaAdd.getHclncantisumin() == null ) {
                                            FacesUtils.addErrorMessage("Error La Cantidad Suministrada se debe registrar ");
                                            wexito = false;
                     }
                }
            } else {
                formulaAdd.setHclcetapa(IConstantes.ETAPA_ATENDIDO);
                formulaAdd.setHclnclinica(getClinica().getCclncodigo());
                formulaAdd.setHclncantisumin(formulaAdd.getHclncantidad());
            }

            formulaAdd.setHclcoperadmodif(userName());
            lstLiquidosSelectEnAdministracion.add(formulaAdd);

            if (wexito) {
                try {
                    this.serviceLocator.getClinicoService().saveLstRegistroLiquidosControlAnestesia(lstLiquidosSelectEnAdministracion, 
                                                                                                    numeroCirugia);
                    lstLiquidosAdministradosAnestesia = 
                            this.serviceLocator.getClinicoService().getLstLiquidosAdministradosAnestesia(numeroCirugia);
                    lstLiquidosParciales = 
                            this.serviceLocator.getClinicoService().getLstLiquidosAdministradoParcialAnestesiaIni(numeroCirugia);
                            
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    init();
                    lstLiquidosParcialesIniciado.clear();
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
    }
    
    
    public String nextPage(){
        navigationRule = "irRegistrarControlMedicamentosAnestesia";
        
        return navigationRule;
    }


    public void ChangeOpcionLiquido() {
        if (opcionLiquido != null && opcionLiquido.equals("S")) {
            esSuspencion = true;
        } else {
            esSuspencion = false;
        }
    }


    public void setLiquidosDelete(Chcontroliqu liquidosDelete) {
        this.liquidosDelete = liquidosDelete;
    }

    public Chcontroliqu getLiquidosDelete() {
        return liquidosDelete;
    }

    public void setLstLiquidosParciales(List<Chcontroliqu> lstLiquidosParciales) {
        this.lstLiquidosParciales = lstLiquidosParciales;
    }

    public List<Chcontroliqu> getLstLiquidosParciales() {
        return lstLiquidosParciales;
    }

    public void setLstHistorialLiquidosEliminados(List<Chcontroliqu> lstHistorialLiquidosEliminados) {
        this.lstHistorialLiquidosEliminados = lstHistorialLiquidosEliminados;
    }

    public List<Chcontroliqu> getLstHistorialLiquidosEliminados() {
        return lstHistorialLiquidosEliminados;
    }

    public void setRenderOtro(boolean renderOtro) {
        this.renderOtro = renderOtro;
    }

    public boolean isRenderOtro() {
        return renderOtro;
    }

    public void setMostrarAdministracion(boolean mostrarAdministracion) {
        this.mostrarAdministracion = mostrarAdministracion;
    }

    public boolean isMostrarAdministracion() {
        return mostrarAdministracion;
    }

    public void setLstLiquidos(List<Chcontroliqu> lstLiquidos) {
        this.lstLiquidos = lstLiquidos;
    }

    public List<Chcontroliqu> getLstLiquidos() {
        return lstLiquidos;
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

    public void setLstLiquidosSelect(List<Chcontroliqu> lstLiquidosSelect) {
        this.lstLiquidosSelect = lstLiquidosSelect;
    }

    public List<Chcontroliqu> getLstLiquidosSelect() {
        return lstLiquidosSelect;
    }

    public void setDtLiquidosParciales(HtmlDataTable dtLiquidosParciales) {
        this.dtLiquidosParciales = dtLiquidosParciales;
    }

    public HtmlDataTable getDtLiquidosParciales() {
        return dtLiquidosParciales;
    }

    /**
     * @param lstOpcionesLiquidos
     */
    public void setLstOpcionesLiquidos(List lstOpcionesLiquidos) {
        this.lstOpcionesLiquidos = lstOpcionesLiquidos;
    }

    /**
     * @return
     */
    public List getLstOpcionesLiquidos() {
        if (lstOpcionesLiquidos.size() == 0) {
            lstOpcionesLiquidos.add(new SelectItem("C", "Completado"));
            lstOpcionesLiquidos.add(new SelectItem("S", "Suspendido"));
        }
        return lstOpcionesLiquidos;
    }

    public void setOpcionLiquido(String opcionLiquido) {
        this.opcionLiquido = opcionLiquido;
    }

    public String getOpcionLiquido() {
        return opcionLiquido;
    }

    public void setEsSuspencion(boolean esSuspencion) {
        this.esSuspencion = esSuspencion;
    }

    public boolean isEsSuspencion() {
        return esSuspencion;
    }

    public void setLstLiquidosSuspendidos(List<Chcontroliqu> lstLiquidosSuspendidos) {
        this.lstLiquidosSuspendidos = lstLiquidosSuspendidos;
    }

    public List<Chcontroliqu> getLstLiquidosSuspendidos() {
        return lstLiquidosSuspendidos;
    }

    public void setDtLiquidosEnAdministracionAnestesia(HtmlDataTable dtLiquidosEnAdministracionAnestesia) {
        this.dtLiquidosEnAdministracionAnestesia = 
                dtLiquidosEnAdministracionAnestesia;
    }

    public HtmlDataTable getDtLiquidosEnAdministracionAnestesia() {
        return dtLiquidosEnAdministracionAnestesia;
    }

    public void setLstLiquidosSelectEnAdministracion(List<Chcontroliqu> lstLiquidosSelectEnAdministracion) {
        this.lstLiquidosSelectEnAdministracion = 
                lstLiquidosSelectEnAdministracion;
    }

    public List<Chcontroliqu> getLstLiquidosSelectEnAdministracion() {
        return lstLiquidosSelectEnAdministracion;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setLstLiquidosParcialesIniciado(List<Chcontroliqu> lstLiquidosParcialesIniciado) {
        this.lstLiquidosParcialesIniciado = lstLiquidosParcialesIniciado;
    }

    public List<Chcontroliqu> getLstLiquidosParcialesIniciado() {
        return lstLiquidosParcialesIniciado;
    }

    public void setControlLiquido(boolean controlLiquido) {
        this.controlLiquido = controlLiquido;
    }

    public boolean isControlLiquido() {
        return controlLiquido;
    }

    public void setLstLiquidosAdministradosAnestesia(List<Chcontroliqu> lstLiquidosAdministradosAnestesia) {
        this.lstLiquidosAdministradosAnestesia = lstLiquidosAdministradosAnestesia;
    }

    public List<Chcontroliqu> getLstLiquidosAdministradosAnestesia() {
        return lstLiquidosAdministradosAnestesia;
    }

    public void setLstLiquidosAdministrados(List<Chcontroliqu> lstLiquidosAdministrados) {
        this.lstLiquidosAdministrados = lstLiquidosAdministrados;
    }

    public List<Chcontroliqu> getLstLiquidosAdministrados() {
        return lstLiquidosAdministrados;
    }

    public void setTotalLiqAdmin(Integer totalLiqAdmin) {
        this.totalLiqAdmin = totalLiqAdmin;
    }

    public Integer getTotalLiqAdmin() {
        return totalLiqAdmin;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setRenderDiuresis(boolean renderDiuresis) {
        this.renderDiuresis = renderDiuresis;
    }

    public boolean isRenderDiuresis() {
        return renderDiuresis;
    }

    public void setRenderCantidadDiuresis(boolean renderCantidadDiuresis) {
        this.renderCantidadDiuresis = renderCantidadDiuresis;
    }

    public boolean isRenderCantidadDiuresis() {
        return renderCantidadDiuresis;
    }

    public void setMnuTipoDiuresis(UIInput mnuTipoDiuresis) {
        this.mnuTipoDiuresis = mnuTipoDiuresis;
    }

    public UIInput getMnuTipoDiuresis() {
        return mnuTipoDiuresis;
    }

    public void setLiquidoDelete(Chcontroliqu liquidoDelete) {
        this.liquidoDelete = liquidoDelete;
    }

    public Chcontroliqu getLiquidoDelete() {
        return liquidoDelete;
    }

    public void setMnuDiuresis(UIInput mnuDiuresis) {
        this.mnuDiuresis = mnuDiuresis;
    }

    public UIInput getMnuDiuresis() {
        return mnuDiuresis;
    }
    
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
    
    public void deleteLiquidoEliminado() {
        Chcontroliqu liquidoDelete = 
            (Chcontroliqu)dtLiquidosEliminados.getRowData();
        lstLiquidosEliminadosSelect.remove(liquidoDelete);

    }
    
    public void agregarLiquidoEliminacion() {
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
    
    /**
     * @return
     */
    public String IngresoLiquidosEliminados() {
        setGeneroReporte(false);
        nextAction = ""; 

        if (lstLiquidosEliminadosSelect != null && 
            !lstLiquidosEliminadosSelect.isEmpty()) {
            try {
                    this.serviceLocator.getClinicoService().saveLstRegistroLiquidosAnestesia(lstLiquidosEliminadosSelect, 
                                                                                    cirugia.getHcplnumero()
                                                                                    );
                lstHistorialLiquidosEliminados = 
                        this.serviceLocator.getClinicoService().getLstLiquidosAdministradoEliminados(cirugia.getHcplnumero());
                                                                 
                nextAction = navegationRule; 
                
                lstLiquidosEliminadosSelect = new ArrayList<Chcontroliqu>(); 
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                init();
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                nextAction = ""; 
                e.printStackTrace();
            }
            return nextAction;
        }
        return nextAction;
    }
    
    public String Siguiente() {
        navigationRule = "";
        navigationRule= BeanNavegacion.RUTA_IR_REGISTRAR_CONTROL_MEDICAMENTOS_ANESTESIA;
        return navigationRule;
    }

    public void setMnuCuantificadaDiuresis(UIInput mnuCuantificadaDiuresis) {
        this.mnuCuantificadaDiuresis = mnuCuantificadaDiuresis;
    }

    public UIInput getMnuCuantificadaDiuresis() {
        return mnuCuantificadaDiuresis;
    }

    public void setItCantidadDiuresis(UIInput itCantidadDiuresis) {
        this.itCantidadDiuresis = itCantidadDiuresis;
    }

    public UIInput getItCantidadDiuresis() {
        return itCantidadDiuresis;
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

    public void setRenderDeposiciones(boolean renderDeposiciones) {
        this.renderDeposiciones = renderDeposiciones;
    }

    public boolean isRenderDeposiciones() {
        return renderDeposiciones;
    }

    public void setRenderCantidadDeposiciones(boolean renderCantidadDeposiciones) {
        this.renderCantidadDeposiciones = renderCantidadDeposiciones;
    }

    public boolean isRenderCantidadDeposiciones() {
        return renderCantidadDeposiciones;
    }

    public void setMnuDeposiciones(UIInput mnuDeposiciones) {
        this.mnuDeposiciones = mnuDeposiciones;
    }

    public UIInput getMnuDeposiciones() {
        return mnuDeposiciones;
    }

    public void setMnuCuantificadaDeposiciones(UIInput mnuCuantificadaDeposiciones) {
        this.mnuCuantificadaDeposiciones = mnuCuantificadaDeposiciones;
    }

    public UIInput getMnuCuantificadaDeposiciones() {
        return mnuCuantificadaDeposiciones;
    }

    public void setItCantidadDeposiciones(UIInput itCantidadDeposiciones) {
        this.itCantidadDeposiciones = itCantidadDeposiciones;
    }

    public UIInput getItCantidadDeposiciones() {
        return itCantidadDeposiciones;
    }

    public void setRenderEmesis(boolean renderEmesis) {
        this.renderEmesis = renderEmesis;
    }

    public boolean isRenderEmesis() {
        return renderEmesis;
    }

    public void setRenderEmeCuanti(boolean renderEmeCuanti) {
        this.renderEmeCuanti = renderEmeCuanti;
    }

    public boolean isRenderEmeCuanti() {
        return renderEmeCuanti;
    }

    public void setMnuEmesis(UIInput mnuEmesis) {
        this.mnuEmesis = mnuEmesis;
    }

    public UIInput getMnuEmesis() {
        return mnuEmesis;
    }

    public void setMnuCuantifi(UIInput mnuCuantifi) {
        this.mnuCuantifi = mnuCuantifi;
    }

    public UIInput getMnuCuantifi() {
        return mnuCuantifi;
    }

    public void setItCantidadEmesis(UIInput itCantidadEmesis) {
        this.itCantidadEmesis = itCantidadEmesis;
    }

    public UIInput getItCantidadEmesis() {
        return itCantidadEmesis;
    }

    public void setRenderDrenaje(boolean renderDrenaje) {
        this.renderDrenaje = renderDrenaje;
    }

    public boolean isRenderDrenaje() {
        return renderDrenaje;
    }

    public void setRenderCantidadDrenaje(boolean renderCantidadDrenaje) {
        this.renderCantidadDrenaje = renderCantidadDrenaje;
    }

    public boolean isRenderCantidadDrenaje() {
        return renderCantidadDrenaje;
    }

    public void setMnuDrenaje(UIInput mnuDrenaje) {
        this.mnuDrenaje = mnuDrenaje;
    }

    public UIInput getMnuDrenaje() {
        return mnuDrenaje;
    }

    public void setMnuTipoDrenaje(UIInput mnuTipoDrenaje) {
        this.mnuTipoDrenaje = mnuTipoDrenaje;
    }

    public UIInput getMnuTipoDrenaje() {
        return mnuTipoDrenaje;
    }

    public void setMnuCuantificadaDrenaje(UIInput mnuCuantificadaDrenaje) {
        this.mnuCuantificadaDrenaje = mnuCuantificadaDrenaje;
    }

    public UIInput getMnuCuantificadaDrenaje() {
        return mnuCuantificadaDrenaje;
    }

    public void setItCantidadDrenaje(UIInput itCantidadDrenaje) {
        this.itCantidadDrenaje = itCantidadDrenaje;
    }

    public UIInput getItCantidadDrenaje() {
        return itCantidadDrenaje;
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

    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    public void setLstLiquidosEliminadosSelect(List<Chcontroliqu> lstLiquidosEliminadosSelect) {
        this.lstLiquidosEliminadosSelect = lstLiquidosEliminadosSelect;
    }

    public List<Chcontroliqu> getLstLiquidosEliminadosSelect() {
        return lstLiquidosEliminadosSelect;
    }

    public void setDtLiquidosEliminados(HtmlDataTable dtLiquidosEliminados) {
        this.dtLiquidosEliminados = dtLiquidosEliminados;
    }

    public HtmlDataTable getDtLiquidosEliminados() {
        return dtLiquidosEliminados;
    }

    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    public String getNavegationRule() {
        return navegationRule;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setDetalleCirugia(Chdetacirpro detalleCirugia) {
        this.detalleCirugia = detalleCirugia;
    }

    public Chdetacirpro getDetalleCirugia() {
        return detalleCirugia;
    }

    public void setCantidadSumin(Integer cantidadSumin) {
        this.cantidadSumin = cantidadSumin;
    }

    public Integer getCantidadSumin() {
        return cantidadSumin;
    }

    public void setDtLiquidosEnAdministracion(HtmlDataTable dtLiquidosEnAdministracion) {
        this.dtLiquidosEnAdministracion = dtLiquidosEnAdministracion;
    }

    public HtmlDataTable getDtLiquidosEnAdministracion() {
        return dtLiquidosEnAdministracion;
    }

    public void setTotalLiqElim(Integer totalLiqElim) {
        this.totalLiqElim = totalLiqElim;
    }

    public Integer getTotalLiqElim() {
        return totalLiqElim;
    }

    public void setUsuarioSystem(String usuarioSystem) {
        this.usuarioSystem = usuarioSystem;
    }

    public String get_usuarioSystem() {
        return usuarioSystem;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }
}
