//=======================================================================
// ARCHIVO IngresoCirugiaEnfermeria
// FECHA CREACI�N: 
// AUTOR: jariano, nlis, avargas
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.UISelectOne;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.hibernate.HibernateException;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuIngresoEnfermeriaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;



//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE IngresoCirugiaEnfermeria
//=======================================================================
public class IngresoCirugiaEnfermeria extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private List lstOpcionesEmbarazo;
    
    private List lstOpciones;

    private List lstOpcionesCompleta;

    private Chingresoenf ingreso;

    private boolean mostrarPremedicacion;

    private boolean mostrarPatologico;

    private boolean mostrarToxico;
    
    private boolean mostrarPruebaEmb;

    private Chcirugprogr cirugia;

    private List lstCirugias;

    private HtmlDataTable dtCirugias;

    private String menuBean;

    private UIInput itDescripcion;

    private int selectedIndex;

    static final int ACTIVAR_APLICACION = 0;

    String cirugiasIniciales;
    
    String wtiposervicio;

    private String navegationRule;

    private String nextAction;

    private List<SelectItem> lstEntrega;

    private boolean renderAyuno;

    private boolean renderVerifiAyuno;

    private boolean renderJoyas;

    private boolean renderElementos;

    private boolean renderRasura;

    private boolean renderAzul;

    private boolean renderRojo;

    private boolean renderVerde;

    private boolean renderMedias;

    private boolean renderContacto;

    private boolean renderConsentimiento;
    
    private boolean renderTieneDIU;

    private boolean renderAlertaNoConfirma;

    private Date fechaActual;
    
    private Date fechaInicial;
    
    /** Almacena el resultado de la prueba*/
    private String resultadoPrueba;
    
    private boolean renderOtrasCirugias;
    
    private boolean renderLigadura;
    
    MenuIngresoEnfermeriaBean menuIngreso;
    
    private boolean wpruebaive;
    
    private List lstSalasCirugia;
    
    
    private UISelectOne conficirug; 
    
    private UISelectOne consinfor; 
    
    private UISelectOne tienediu;
    
    private UISelectOne verifayun; 
    
    private UISelectOne antepatol;
  
    private UISelectOne antetoxic;
    
    private UISelectOne premedicac;
    
    private UISelectOne objetvalor;
    
    private UISelectOne arearasur;
    
    private UISelectOne comprelast;
    
    private UISelectOne autocntel;
     
    private UISelectOne pruebaEmb;

    private UISelectOne resulPEmb;

    private String pruebaEmbarazo;
    
    private String tipoServicio;
    
    private String legendServicio;
    
    private String legendTablaServicio;
    
    private List<Cnconsclin> lstConsclin;
    
    private boolean notaEnfeProce;
    
    private String legendAdmision;
    
    private String legendIngresoEnfermeria;
    
    private UISelectOne confiproce;
    
    private boolean renderAlertaNoConfirmaProce;
    private boolean renderDatosConsentimiento;
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public IngresoCirugiaEnfermeria() {
    }


    public void init() {
        lstOpciones = new ArrayList();
        lstOpcionesEmbarazo = new ArrayList();
        lstCirugias = new ArrayList();
        dtCirugias = new HtmlDataTable();
        inicializarIngresoCirugiaEnfermeria();

        conficirug = new UISelectOne();
        consinfor = new UISelectOne();
        tienediu = new UISelectOne();
        verifayun = new UISelectOne();
        antepatol = new UISelectOne();
        antetoxic = new UISelectOne();
        premedicac = new UISelectOne(); 
        objetvalor = new UISelectOne();
        arearasur = new UISelectOne();
        comprelast = new UISelectOne();
        autocntel = new UISelectOne();
        pruebaEmb = new UISelectOne();
        resulPEmb = new UISelectOne();
        confiproce = new UISelectOne();
    }


    public void inicializarIngresoCirugiaEnfermeria() {
        renderAzul = false;
        renderVerde = false;
        renderRojo = false;
        renderAlertaNoConfirma = false;
        renderElementos = false;
        renderAyuno = false;
        renderVerifiAyuno = false;
        renderLigadura = false;
        renderOtrasCirugias = false;
        renderTieneDIU = true;
        renderAlertaNoConfirmaProce=false;
        renderDatosConsentimiento = false;
        legendServicio="Cirugia(s) Programada(s)";
        legendAdmision ="Admisi�n a Cirug�a";
        legendTablaServicio= "Intervenci�n(es)";
        legendIngresoEnfermeria="Ingreso Enfermeria Cirugia";
        
        fechaActual = new Date();
        Cpservicio servicio = null;
      
        
        
        if ( ingreso != null && ingreso.getHiedfechapremb() != null && !ingreso.getHiedfechapremb().equals(new Date())) {
            ingreso.setHiedfechapremb(new Date());
        }
       

        if (cirugia != null) {  
            // VERIFICA LA CIRUGIA 
            renderAyuno = false;
            renderVerifiAyuno = false;
            cirugiasIniciales = "";
          /*
             if (cirugia.getHcpctipoaneste() != null) {
                // SE VERIFICA SI LA ANESTESIA ES GENERAL PARA MOSTRAR EL AYUNO
                if (cirugia.getHcpctipoaneste().equals("2") && notaEnfeProce == false) {
                    renderAyuno = true;
                    renderVerifiAyuno = true;
                }
            }
           */
            
           
            try {
            if(tipoServicio == null){
                ingreso = 
                        this.serviceLocator.getClinicoService().getIngresoEnfermeria(cirugia.getHcplnumero());
            }else{
                ingreso = 
                        this.serviceLocator.getClinicoService().getIngresoEnfermeriaProcedimiento(cirugia.getHcplnumero());    
            }
            
                if(notaEnfeProce){
                    legendServicio="Procedimiento(s)";
                    legendAdmision ="Admisi�n a Procedimientos";
                    legendTablaServicio = "Procedimiento(s)";
                    legendIngresoEnfermeria = "Ingreso Enfermeria Procedimientos";
                    try {
                        lstConsclin = 
                                this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    // Cargamos los procedimientos
                    if (lstConsclin != null && !lstConsclin.isEmpty()) {
                        Iterator it = lstConsclin.iterator();
                        Cnconsclin conclin;

                        while (it.hasNext()) {
                            conclin = (Cnconsclin)it.next();
                            lstCirugias.add(conclin.getCcocservic());
                        }
                    }
                }
               
                if (cirugia.getChdetacirpros() != null && 
                    !cirugia.getChdetacirpros().isEmpty()) {
                    Chdetacirpro detalle = null;
                    Iterator it = cirugia.getChdetacirpros().iterator();
                    while (it.hasNext()) {
                        detalle = (Chdetacirpro)it.next();

                        if (detalle != null && detalle.getId() != null && 
                            detalle.getId().getHdccservicio() != null) {
                             servicio = 
                                this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                                
                            lstCirugias.add(servicio);
                            cirugiasIniciales = 
                                    cirugiasIniciales + servicio.getCsvccodigo() + 
                                    ",";

                        }
                        if(cirugia.getChdetacirpros()  != null && cirugia.getChdetacirpros().size()==1 ){
                            if(servicio != null && servicio.getCsvntiphis().equals(CIRUGIA_LIGADURA_POR_BIPOLAR)){
                                renderLigadura = true;
                                renderOtrasCirugias = false;
                               
                            }else if(servicio != null && servicio.getCsvntiphis().equals(CIRUGIA_IVE)){
                                wpruebaive = true;
                                renderLigadura = true;
                                renderOtrasCirugias = false;
                            }else if(servicio != null && (servicio.getCsvntiphis()== 20 || servicio.getCsvntiphis()== 31 || servicio.getCsvntiphis()== 44 )){
                                renderTieneDIU = false;
                            }else{
                                renderLigadura = false;
                                renderOtrasCirugias = true;
                            }
                        }else{
                            renderLigadura = false;
                            renderOtrasCirugias = true;
                        }
                    }
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (ingreso == null) {
                ingreso = new Chingresoenf();
                if (ingreso.getHiedfechapremb() != null && !ingreso.getHiedfechapremb().equals(new Date())) {
                    ingreso.setHiedfechapremb(new Date());
                }
                ingreso.setHiecmanilazul("N");
                ingreso.setHiecmanilrojo("N");
                ingreso.setHiecmanilverde("N");
                if(cirugia.getHcpnsalainterv() != null){
                    ingreso.setSala(cirugia.getHcpnsalainterv());    
                }
            } else {

                
                if (ingreso.getHiecpremedicac() != null && 
                    ingreso.getHiecpremedicac().equals("S")) {
                    mostrarPremedicacion = true;
                } else {
                    mostrarPremedicacion = false;
                }

                if (ingreso.getHiecantepatol() != null && 
                    ingreso.getHiecantepatol().equals("S")) {
                    mostrarPatologico = true;
                } else {
                    mostrarPatologico = false;
                }

                if (ingreso.getHiedfechapremb() != null) {
                    mostrarPruebaEmb = true;
                    pruebaEmbarazo = "S";
                } else {
                    pruebaEmbarazo = "N";
                    mostrarPruebaEmb = false;
                }

                if (ingreso.getHiecantetoxic() != null && 
                    ingreso.getHiecantetoxic().equals("S")) {
                    mostrarToxico = true;
                } else {
                    mostrarToxico = false;
                }

                if (ingreso.getHiecobjetvalor() != null && 
                    ingreso.getHiecobjetvalor().equals("S")) {
                    renderJoyas = true;
                } else {
                    renderJoyas = false;
                }

                if (ingreso.getHiecarearasur() != null && 
                    ingreso.getHiecarearasur().equals("S")) {
                    renderRasura = true;
                } else {
                    renderRasura = false;
                }

                if (ingreso.getHieccomprelast() != null && 
                    ingreso.getHieccomprelast().equals("S")) {
                    renderMedias = false;
                } else {
                    renderMedias = true;
                }

                if (ingreso.getHiecautocntel() != null && 
                    ingreso.getHiecautocntel().equals("S")) {
                    renderContacto = true;
                } else {
                    renderContacto = false;
                }

                if (ingreso.getHiecmanilazul() != null && 
                    ingreso.getHiecmanilazul().equals("S")) {
                    renderAzul = true;
                }


                if (ingreso.getHiecconficirug() != null && 
                    ingreso.getHiecconficirug().equals("N")) {
                    renderAlertaNoConfirma = true;
                }
                
                if (ingreso.getHiecconfiproce() != null && 
                    ingreso.getHiecconfiproce().equals("N")) {
                    renderAlertaNoConfirma = true;
                }

                if (ingreso.getHiecmanilrojo() != null && 
                    ingreso.getHiecmanilrojo().equals("S")) {
                    renderRojo = true;
                }

                if (ingreso.getHiecmanilverde() != null && 
                    ingreso.getHiecmanilverde().equals("S")) {
                    renderVerde = true;
                }

                if (ingreso.getHiecverifayun() != null && 
                    ingreso.getHiecverifayun().equals("S")) {
                    renderVerifiAyuno = true;

                    if (ingreso.getHiecayunopre() != null && 
                        ingreso.getHiecayunopre().equals("S")) {
                        renderAyuno = true;
                    } else {
                        renderAyuno = false;
                    }
                } else {
                    renderVerifiAyuno = false;
                }
                
                if(cirugia.getHcpnsalainterv() != null){
                    ingreso.setSala(cirugia.getHcpnsalainterv());    
                }
                
                changeConsentimiento();

            }

        }

    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

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
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No"));
        }
        return lstOpciones;
    }

    /**
     * @param lstOpcionesCompleta
     */
    public void setLstOpcionesCompleta(List lstOpcionesCompleta) {
        this.lstOpcionesCompleta = lstOpcionesCompleta;
    }

    public List getLstOpcionesCompleta() {
        if (lstOpcionesCompleta == null || lstOpcionesCompleta.isEmpty()) {
            lstOpcionesCompleta = new ArrayList();
            lstOpcionesCompleta.add(new SelectItem("S", "Si"));
            lstOpcionesCompleta.add(new SelectItem("N", "No"));
            lstOpcionesCompleta.add(new SelectItem("X", "No Aplica"));
        }
        return lstOpcionesCompleta;
    }
    
    
    public void changeEmbarazo(){
        if (resultadoPrueba != null && resultadoPrueba.equals("S") && !wpruebaive){
            FacesUtils.addErrorMessage("Recuerde Cancelar la cirug�a la prueba de Embarazo sali� positiva.");
        }
    }
    


    /**
     * @param lstEntrega
     */
    public void setLstEntrega(List<SelectItem> lstEntrega) {
        this.lstEntrega = lstEntrega;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstEntrega() {
        if (lstEntrega == null || lstEntrega.isEmpty()) {
            lstEntrega = new ArrayList<SelectItem>();
            lstEntrega.add(new SelectItem("", "Seleccione"));
            lstEntrega.add(new SelectItem("1", "Se entrega a familiar"));
            lstEntrega.add(new SelectItem("2", 
                                          "La deja con sus cosas personales en custodia del centro"));
        }

        return lstEntrega;
    }


    /**
     * @param ingreso
     */
    public void setIngreso(Chingresoenf ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return
     */
    public Chingresoenf getIngreso() {
        return ingreso;
    }

    /**
     * @param renderAyuno
     */
    public void setRenderAyuno(boolean renderAyuno) {
        this.renderAyuno = renderAyuno;
    }

    /**
     * @return
     */
    public boolean isRenderAyuno() {
        return renderAyuno;
    }


    /**
     * @param mostrarPremedicacion
     */
    public void setMostrarPremedicacion(boolean mostrarPremedicacion) {
        this.mostrarPremedicacion = mostrarPremedicacion;
    }

    /**
     * @return
     */
    public boolean isMostrarPremedicacion() {
        return mostrarPremedicacion;
    }

    /**
     * @param mostrarPatologico
     */
    public void setMostrarPatologico(boolean mostrarPatologico) {
        this.mostrarPatologico = mostrarPatologico;
    }

    /**
     * @return
     */
    public boolean isMostrarPatologico() {
        return mostrarPatologico;
    }

    /**
     * @param mostrarPruebaEmb
     */
    public void setMostrarPruebaEmb(boolean mostrarPruebaEmb) {
        this.mostrarPruebaEmb = mostrarPruebaEmb;
    }

    /**
     * @return
     */
    public boolean isMostrarPruebaEmb() {
        return mostrarPruebaEmb;
    }

    /**
     * @param mostrarToxico
     */
    public void setMostrarToxico(boolean mostrarToxico) {
        this.mostrarToxico = mostrarToxico;
    }

    /**
     * @return
     */
    public boolean isMostrarToxico() {
        return mostrarToxico;
    }

    /**
     * @param renderJoyas
     */
    public void setRenderJoyas(boolean renderJoyas) {
        this.renderJoyas = renderJoyas;
    }

    /**
     * @return
     */
    public boolean isRenderJoyas() {
        return renderJoyas;
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
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
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
     * @param itDescripcion
     */
    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    /**
     * @return
     */
    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    /**
     * @param navegationRule
     */
    public void setNavegationRule(String navegationRule) {
        this.navegationRule = navegationRule;
    }

    /**
     * @return
     */
    public String getNavegationRule() {
        return navegationRule;
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
     * @param renderAzul
     */
    public void setRenderAzul(boolean renderAzul) {
        this.renderAzul = renderAzul;
    }

    /**
     * @return
     */
    public boolean isRenderAzul() {
        return renderAzul;
    }

    /**
     * @param renderRojo
     */
    public void setRenderRojo(boolean renderRojo) {
        this.renderRojo = renderRojo;
    }

    /**
     * @return
     */
    public boolean isRenderRojo() {
        return renderRojo;
    }

    /**
     * @param renderVerde
     */
    public void setRenderVerde(boolean renderVerde) {
        this.renderVerde = renderVerde;
    }

    /**
     * @return
     */
    public boolean isRenderVerde() {
        return renderVerde;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------


    public void changePremedicacion() {
        if (ingreso != null && ingreso.getHiecpremedicac() != null && 
            ingreso.getHiecpremedicac().equals("S")) {
            mostrarPremedicacion = true;
        } else {
            mostrarPremedicacion = false;
        }
    }


    public void changeAyuno() {
        renderAyuno = false;
        if (ingreso != null && ingreso.getHiecayunopre() != null && 
            ingreso.getHiecayunopre().equals("S")) {
            renderAyuno = true;
        } else {
            renderAyuno = false;

        }
    }

    public void changeVerifica() {
            renderVerifiAyuno = false;
        if (ingreso != null && ingreso.getHiecverifayun() != null && 
            ingreso.getHiecverifayun().equals("S")) {
            renderVerifiAyuno = true;
        } else {
            renderVerifiAyuno = false;
            renderAyuno = false;
            ingreso.setHienayunosolid(null);
            ingreso.setHienayunoliqui(null);
            ingreso.setHiecayunopre(null);
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setHiecconsinfor(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecconsinfor((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiectienediu(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiectienediu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setHiecayunopre(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecayunopre((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHiecverifayun(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecverifayun((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecpremedicac(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecpremedicac((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHiecobjetvalor(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecobjetvalor((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecarearasur(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecarearasur((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecconficirug(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecconficirug((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHiecconfiproce(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecconfiproce((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecantepatol(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecantepatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecantetoxic(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecantetoxic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHieccomprelast(ValueChangeEvent valueChangeEvent) {
        ingreso.setHieccomprelast((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecautocntel(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecautocntel((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHiecresulpruemb(ValueChangeEvent valueChangeEvent) {
        ingreso.setHiecresulpruemb((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setPruebaEmbarazo(ValueChangeEvent valueChangeEvent) {
        pruebaEmbarazo = ((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changePatologico() {
        if (ingreso != null && ingreso.getHiecantepatol() != null && 
            ingreso.getHiecantepatol().equals("S")) {
            mostrarPatologico = true;
        } else {
            mostrarPatologico = false;
        }
    }

    public void changePruebaEmb() {
        if (ingreso != null && pruebaEmbarazo != null && pruebaEmbarazo.equals("S")) {
            mostrarPruebaEmb = true;
        } else {
            mostrarPruebaEmb = false;
            ingreso.setHiedfechapremb(null);
            ingreso.setHiecresulpruemb(null);
            resulPEmb.setValue(null);
        }
    }


    public void changeToxico() {
        if (ingreso != null && ingreso.getHiecantetoxic() != null && 
            ingreso.getHiecantetoxic().equals("S")) {
            mostrarToxico = true;
            renderRojo = true;
            ingreso.setHiecmanilrojo("S");
        } else {
            mostrarToxico = false;
            renderRojo = false;
            ingreso.setHiecmanilrojo("N");
        }
    }

    //-----------------------------------------------------------------------
    //  Metodo es Valido
    //-----------------------------------------------------------------------

    public boolean esValido() {

        Chingresoenf ingresoAux;
        ingresoAux = null;
        boolean esValido = false;

        try {
            if (cirugia != null) {
                if(tipoServicio == null){
                    ingresoAux = 
                            this.serviceLocator.getClinicoService().getIngresoEnfermeria(cirugia.getHcplnumero());
                }else{
                    ingresoAux = 
                            this.serviceLocator.getClinicoService().getIngresoEnfermeriaProcedimiento(cirugia.getHcplnumero());    
                }
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (ingresoAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  Metodo cerrar Consulta
    //-----------------------------------------------------------------------


    public void closeIngreso() {
        if (ingreso != null && ingreso.getId() != null && 
            ingreso.getId().getHielnumero() != null) {
            try {
                this.serviceLocator.getCirugiaService().closeIngresoEnfermeria(ingreso.getId().getHielnumero(), 
                                                                               userName(), 
                                                                               new Date(), 
                                                                               cirugia.getHcpnsalainterv());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

    }

    public void changeJoyas() {
        renderJoyas = false;
        renderElementos = false;
        if (ingreso != null && ingreso.getHiecobjetvalor() != null && 
            ingreso.getHiecobjetvalor().equals("S")) {
            renderJoyas = true;
            renderElementos = false;
        } else if (ingreso != null && ingreso.getHiecobjetvalor() != null && 
                   ingreso.getHiecobjetvalor().equals("N")) {
            renderElementos = true;
            renderJoyas = false;
        }
    }


    public void changeRasura() {
        renderRasura = false;
        if (ingreso != null && ingreso.getHiecarearasur() != null && 
            ingreso.getHiecarearasur().equals("N")) {
            renderRasura = true;
        }
    }

    public void changeMedias() {
        renderMedias = false;
        if (ingreso != null && ingreso.getHieccomprelast() != null && 
            ingreso.getHieccomprelast().equals("S")) {
            renderMedias = true;
        }
    }

    public void changeContacto() {
        renderContacto = false;
        if (ingreso != null && ingreso.getHiecautocntel() != null && 
            ingreso.getHiecautocntel().equals("S")) {
            renderContacto = true;
        }
    }


    public void changeConsentimiento() {
        renderConsentimiento = false;
        if(ingreso !=null && ingreso.getHiecconsinfor()!=null){
            if(ingreso.getHiecconsinfor().equals("N"))
           {
            ingreso.setHieccpacautdat(null);
            ingreso.setHieccualconse(null);
            renderConsentimiento = true;
            renderDatosConsentimiento = false;
        }
        else{
            renderDatosConsentimiento = true;
        }
        }
       
    }

    public void changeConfirma() {
        renderAzul = false;
        renderVerde = false;
        renderAlertaNoConfirma = false;
        ingreso.setHiecmanilazul("N");
        ingreso.setHiecmanilverde("N");

        if (ingreso.getHiecconficirug() != null && 
            ingreso.getHiecconficirug().equals("S")) {
            if (cirugia.getChdetacirpros() != null && 
                !cirugia.getChdetacirpros().isEmpty()) {
                Chdetacirpro detalle = null;
                Iterator it = cirugia.getChdetacirpros().iterator();
                while (it.hasNext()) {
                    detalle = (Chdetacirpro)it.next();

                    if (detalle != null && detalle.getId() != null && 
                        detalle.getId().getHdccservicio() != null) {

                        if (detalle.getId().getHdccservicio().contains("637300") || 
                            detalle.getId().getHdccservicio().contains("662200") ||
                            detalle.getId().getHdccservicio().contains("662202")) {
                            renderVerde = true;
                            ingreso.setHiecmanilverde("S");
                        } else {
                            renderAzul = true;
                            ingreso.setHiecmanilazul("S");
                        }
                    }
                }
            }
        } else {
            ingreso.setHiecmanilrojo("N");
            renderRojo = false;
            if(!notaEnfeProce){
                renderAlertaNoConfirma = true;
                ingreso.setHiecantetoxic(null);
            }
        }
    }

    public void changeConfirmaProcedimiento() {

        if (ingreso.getHiecconfiproce() != null && 
            ingreso.getHiecconfiproce().equals("N")) {
            renderAlertaNoConfirmaProce = true;
        }else{
            renderAlertaNoConfirmaProce = false;
        }

    }


    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------  


    public String IngresoEnfermeria() {
        boolean wexito = true;

        nextAction = "";
        String url = 
            "body:formNotaIngresoEnfermeria:panelTabIngresoEnfermeria:";

        if (ingreso != null) {
          if(!notaEnfeProce){  
            if (ingreso.getHiecconficirug() == null) {
                FacesUtils.addErrorMessage(url + "mnuConfirmaCirugia", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
          }else{
            if (ingreso.getHiecconfiproce() == null) {
                FacesUtils.addErrorMessage(url + "mnuConfirmaProcedimiento", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
        }

            if (ingreso.getHiecconsinfor() == null) {
                FacesUtils.addErrorMessage(url + "mnuConsenInformado", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            if(!notaEnfeProce){
            if (renderVerifiAyuno && ingreso.getHiecayunopre() == null) {
                FacesUtils.addErrorMessage(url + "mnuAyunoPreoper", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
          }
            
            if(!wpruebaive){
                if(ingreso.getHiedfechapremb() != null && ingreso.getHiecresulpruemb()!= null && ingreso.getHiecresulpruemb().equals("S") ){
                    FacesUtils.addErrorMessage("Recuerde cancelar la Cirug�a la prueba de embarazo es POSITIVA");
                   
                }
            }
        
            if(ingreso.getHiedfechapremb() == null && ingreso.getHiecresulpruemb() == null){
                ingreso.setHiecresulpruemb(null);
            }
        if(!notaEnfeProce){
            if (ingreso.getHiecayunopre() != null && 
                ingreso.getHiecayunopre().equals("S")) {
                if (ingreso.getHienayunosolid() == null || 
                    ingreso.getHienayunosolid().equals("") && 
                    ingreso.getHienayunoliqui() == null || 
                    ingreso.getHienayunoliqui().equals("")) {
                    if (ingreso.getHiecobserayu() == null || 
                        ingreso.getHiecobserayu().equals("")) {
                        FacesUtils.addErrorMessage(url + 
                                                   "itTextAreaAyunoLiquido", 
                                                   MSG_NO_TIENE_DATOS_AYUNO);
                        wexito = false;
                    }
                }
            }
       


            if (ingreso.getHiecayunopre() != null && 
                !ingreso.getHiecayunopre().equals("")) {
                if (ingreso.getHienayunosolid() != null && 
                    ingreso.getHienayunosolid() < 6) {
                    FacesUtils.addErrorMessage(url + "itHorasAyunoSolido", 
                                               MSG_NO_CUMPLE_AYUNO);

                }

                if (ingreso.getHienayunoliqui() != null && 
                    ingreso.getHienayunoliqui() < 6) {
                    FacesUtils.addErrorMessage(url + "itHorasAyunoLiquido", 
                                               MSG_NO_CUMPLE_AYUNO);

                }
            }


            if (ingreso.getHiecantepatol() == null) {
                FacesUtils.addErrorMessage(url + "mnuPatologico", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            } else {
                if (ingreso.getHiecantepatol().equals("S") && 
                    ingreso.getHieccualpatol() == null) {
                    FacesUtils.addErrorMessage(url + "textCualPatologico", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;

                }

            }
        }  

            if (pruebaEmbarazo != null) {
                if (pruebaEmbarazo.equals("S") && ingreso.getHiedfechapremb() == null) {
                    FacesUtils.addErrorMessage(url + "textPruebaEmb", 
                                           MSG_CAMPO_OBLIGATORIO);
                    wexito = false;
                }
                if (pruebaEmbarazo.equals("N")) {
                    ingreso.setHiedfechapremb(null);
                    ingreso.setHiecresulpruemb(null);
                }
            }

            if (ingreso.getHiecautocntel() == null || 
                ingreso.getHiecautocntel().equals("")) {
                FacesUtils.addErrorMessage(url + "mnuContactoTelefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (ingreso.getHiecantetoxic() == null) {
                FacesUtils.addErrorMessage(url + "mnuToxico", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            } else {
                if (ingreso.getHiecantetoxic().equals("S") && 
                    ingreso.getHieccualtoxic() == null) {
                    FacesUtils.addErrorMessage(url + "textCualToxico", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexito = false;

                }

            }

            if (ingreso != null && ingreso.getHiecpreparacio() != null && 
                ingreso.getHiecpreparacio().equals("N")) {

                ingreso.setHieccualpremed(null);
                ingreso.setHienhoraspreme(null);

            }

            if (ingreso != null && ingreso.getHiecpremedicac() != null && 
                ingreso.getHiecpremedicac().equals("N")) {

                ingreso.setHiecdescinterv(null);
                ingreso.setHienhoraspreme(null);

            }


        }
        
        if (pruebaEmbarazo == null || pruebaEmbarazo.equals("N")) {
            ingreso.setHiedfechapremb(null);
            ingreso.setHiecresulpruemb(null);
        }

        ingreso.setHiecmanilazul("N");
        ingreso.setHiecmanilrojo("N");
        ingreso.setHiecmanilverde("N");
      if(!notaEnfeProce){      
        if (ingreso.getHiecconficirug() != null && 
            ingreso.getHiecconficirug().equals("N")) {
            FacesUtils.addErrorMessage("Error. No confirma cirug�a no permite guardar registro");
            wexito = false;
        }
      }else{
        if (ingreso.getHiecconfiproce() != null && 
            ingreso.getHiecconfiproce().equals("N")) {
            FacesUtils.addErrorMessage("Error. No confirma Procedimiento no permite guardar registro");
            wexito = false;
        }
    }
        

        if (!renderJoyas) {
            ingreso.setHiecentreobjec(null);
        }

        if (renderAzul) {
            ingreso.setHiecmanilazul("S");
        }

        if (renderRojo) {
            ingreso.setHiecmanilrojo("S");
        }

        if (renderVerde) {
            ingreso.setHiecmanilverde("S");
        }

        if (ingreso != null) {
            ingreso.getId().setHiectiposervi(TIPO_HOSPITALIZACION);
            ingreso.getId().setHielnumero(cirugia.getHcplnumero());
            ingreso.setHielusuario(cirugia.getHcplusuario());
            ingreso.setHienclinica(this.getClinica().getCclncodigo());
            ingreso.setHiedfecregistr(new Date());
            ingreso.setHiecoperador(userName());
            ingreso.setHiecetapa(ETAPA_NO_APLICA);

            if (cirugiasIniciales != null && !cirugiasIniciales.equals("")) {
                ingreso.setHiecinterinici(cirugiasIniciales);
            }
            
            cirugia.setHcpnsalainterv(ingreso.getSala());

        }


        if (wexito) {
            try {
                if(tipoServicio != null ){
                    ingreso.getId().setHiectiposervi(tipoServicio);
                }
                this.serviceLocator.getClinicoService().saveIngresoEnfermeria(ingreso,cirugia);
                nextAction = navegationRule;
                FacesUtils.resetManagedBean(menuBean);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                if (renderAzul)
                    FacesUtils.addInfoMessage("Colocar manilla Az�l");
                if (renderVerde)
                    FacesUtils.addInfoMessage("Colocar manilla Verde");
                if (renderRojo)
                    FacesUtils.addInfoMessage("Colocar manilla Roja");


            } catch (ModelException e) {
                FacesUtils.addErrorMessage("ERROR!!! " + e.getMessage());
                e.printStackTrace();
            } catch (Exception ex) {
                FacesUtils.addErrorMessage("ERROR!!! " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return nextAction;
    }
    
    /**
     * @param lstSalasCirugia
     */
    public void setLstSalasCirugia(List lstSalasCirugia) {
        this.lstSalasCirugia = lstSalasCirugia;
    }

    /**
     * @return
     */
    public List getLstSalasCirugia() {
        if (lstSalasCirugia == null) {
            lstSalasCirugia = new ArrayList();
            ArrayList<Chconsultori> lstSalasAux = null;
            Integer tipoSala = 2;
            try {
                lstSalasAux = 
                        (ArrayList<Chconsultori>)this.getServiceLocator().getCirugiaService().getConsultoriosXClinica(tipoSala, 
                                                                                                                      this.getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstSalasAux!= null && !lstSalasAux.isEmpty()) {

                lstSalasCirugia.add(new SelectItem("", "Seleccione ...."));
                Iterator it = lstSalasAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstSalasCirugia.add(new SelectItem((lstSalasAux.get(i).getId().getHconnumero()), 
                                                       lstSalasAux.get(i).getHcocdescripcio()));
                    i++;
                }
            }
        }
        return lstSalasCirugia;
    }


    /**
     * @param cirugiasIniciales
     */
    public void setCirugiasIniciales(String cirugiasIniciales) {
        this.cirugiasIniciales = cirugiasIniciales;
    }

    /**
     * @return
     */
    public String getCirugiasIniciales() {
        return cirugiasIniciales;
    }

    /**
     * @param renderRasura
     */
    public void setRenderRasura(boolean renderRasura) {
        this.renderRasura = renderRasura;
    }

    /**
     * @return
     */
    public boolean isRenderRasura() {
        return renderRasura;
    }

    /**
     * @param renderMedias
     */
    public void setRenderMedias(boolean renderMedias) {
        this.renderMedias = renderMedias;
    }

    /**
     * @return
     */
    public boolean isRenderMedias() {
        return renderMedias;
    }

    /**
     * @param renderContacto
     */
    public void setRenderContacto(boolean renderContacto) {
        this.renderContacto = renderContacto;
    }

    /**
     * @return
     */
    public boolean isRenderContacto() {
        return renderContacto;
    }


    /**
     * @param renderConsentimiento
     */
    public void setRenderConsentimiento(boolean renderConsentimiento) {
        this.renderConsentimiento = renderConsentimiento;
    }

    /**
     * @return
     */
    public boolean isRenderConsentimiento() {
        return renderConsentimiento;
    }

    /**
     * @param renderTieneDIU
     */
    public void setRenderTieneDIU(boolean renderTieneDIU) {
        this.renderTieneDIU = renderTieneDIU;
    }

    /**
     * @return
     */
    public boolean isRenderTieneDIU() {
        return renderTieneDIU;
    }

    public void setRenderAlertaNoConfirma(boolean renderAlertaNoConfirma) {
        this.renderAlertaNoConfirma = renderAlertaNoConfirma;
    }

    public boolean isRenderAlertaNoConfirma() {
        return renderAlertaNoConfirma;
    }

    public void setRenderElementos(boolean renderElementos) {
        this.renderElementos = renderElementos;
    }

    public boolean isRenderElementos() {
        return renderElementos;
    }

    public void setRenderVerifiAyuno(boolean renderVerifiAyuno) {
        this.renderVerifiAyuno = renderVerifiAyuno;
    }

    public boolean isRenderVerifiAyuno() {
        return renderVerifiAyuno;
    }

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setFechaActual(ValueChangeEvent valueChangeEvent) {
        setFechaActual((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setLstOpcionesEmbarazo(List lstOpcionesEmbarazo) {
        this.lstOpcionesEmbarazo = lstOpcionesEmbarazo;
    }

    public List getLstOpcionesEmbarazo()       {
        if (lstOpcionesEmbarazo == null || lstOpcionesEmbarazo.isEmpty()) {
            lstOpcionesEmbarazo = new ArrayList();
            lstOpcionesEmbarazo.add(new SelectItem("S", "Positiva"));
            lstOpcionesEmbarazo.add(new SelectItem("N", "Negativa"));
        }
        return lstOpcionesEmbarazo;
    }

    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }

    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }
  

    public void setRenderLigadura(boolean renderLigadura) {
        this.renderLigadura = renderLigadura;
    }

    public boolean isRenderLigadura() {
        return renderLigadura;
    }

    public void setWpruebaive(boolean wpruebaive) {
        this.wpruebaive = wpruebaive;
    }

    public boolean isWpruebaive() {
        return wpruebaive;
    }
    
    public void changeTodosNo() {
    if(!notaEnfeProce){
        renderAlertaNoConfirma = true;
    }else{
        renderAlertaNoConfirmaProce=true;
    }
        inicializarPregunta("N");
    }

    public void changeTodosSi() {
        inicializarPregunta("S");
    }


    public void changeNinguno() {
        inicializarPregunta(null);
    }
    
    
    public void inicializarPregunta(String opcion){
        ingreso.setHieccpacautdat(opcion);
        if(opcion  == null || opcion.equals("N")){
            ingreso.setHieccualconse(null);
        }
     
        renderDatosConsentimiento = false;
        if(!notaEnfeProce){
            ingreso.setHiecconficirug(opcion);
            ingreso.setHiecconsinfor(opcion);
            ingreso.setHiectienediu(opcion);
            ingreso.setHiecverifayun(opcion);
            ingreso.setHiecantepatol(opcion);
            ingreso.setHiecantetoxic(opcion);
            ingreso.setHiecpremedicac(opcion);
            ingreso.setHiecobjetvalor(opcion);
            ingreso.setHiecarearasur(opcion);
            ingreso.setHieccomprelast(opcion);
            ingreso.setHiecautocntel(opcion);
            ingreso.setHiecresulpruemb(opcion);
            
            if (opcion == null) {
                ingreso.setHiedfechapremb(null);
                pruebaEmbarazo = null;
            }
            if(renderLigadura){
                ingreso.setHiecresulpruemb(opcion);
                pruebaEmbarazo = opcion;
            }
            
            conficirug.setValue(opcion);
            confiproce.setValue(opcion);
            consinfor.setValue(opcion);
            tienediu.setValue(opcion);
            verifayun.setValue(opcion);
            antepatol.setValue(opcion);
            antetoxic.setValue(opcion);
            premedicac.setValue(opcion);
            objetvalor.setValue(opcion);
            arearasur.setValue(opcion);
            comprelast.setValue(opcion);
            autocntel.setValue(opcion);
            resulPEmb.setValue(opcion);
            pruebaEmb.setValue(opcion);
            changeConfirma();
            changeConsentimiento();
            changeVerifica();
            changePatologico();
            changeToxico();
            changePremedicacion();
            changeJoyas();
            changeRasura();
            changeMedias();
            changeContacto();
            changePruebaEmb();
        }else{
            ingreso.setHiecconfiproce(opcion);
            ingreso.setHiecconsinfor(opcion);
            ingreso.setHiecantepatol(opcion);
            ingreso.setHiecantetoxic(opcion);
            ingreso.setHiecpremedicac(opcion);
            ingreso.setHiecobjetvalor(opcion);
            ingreso.setHiecautocntel(opcion);
            ingreso.setHiecresulpruemb(opcion);
            if (opcion == null) {
                ingreso.setHiedfechapremb(null);
            }
            pruebaEmbarazo = "N";
            confiproce.setValue(opcion);
            consinfor.setValue(opcion);
            antepatol.setValue(opcion);
            antetoxic.setValue(opcion);
            premedicac.setValue(opcion);
            objetvalor.setValue(opcion);
            autocntel.setValue(opcion);
            resulPEmb.setValue(opcion);
            pruebaEmb.setValue(opcion);
            
            
            changeConfirma();
            changeConsentimiento();
            changeVerifica();
            changePatologico();
            changeToxico();
            changePremedicacion();
            changeJoyas();
            changeRasura();
            changeMedias();
            changeContacto();
            changePruebaEmb();
            changeConfirmaProcedimiento();
        }
        
    }

    public void setConficirug(UISelectOne conficirug) {
        this.conficirug = conficirug;
    }

    public UISelectOne getConficirug() {
        return conficirug;
    }


    public void setConsinfor(UISelectOne consinfor) {
        this.consinfor = consinfor;
    }

    public UISelectOne getConsinfor() {
        return consinfor;
    }
    
    public void setTienediu(UISelectOne tienediu) {
        this.tienediu = tienediu;
    }

    public UISelectOne getTienediu() {
        return tienediu;
    }

    public void setVerifayun(UISelectOne verifayun) {
        this.verifayun = verifayun;
    }

    public UISelectOne getVerifayun() {
        return verifayun;
    }

    public void setAntepatol(UISelectOne antepatol) {
        this.antepatol = antepatol;
    }

    public UISelectOne getAntepatol() {
        return antepatol;
    }

    public void setPruebaEmb(UISelectOne pruebaEmb) {
        this.pruebaEmb = pruebaEmb;
    }

    public UISelectOne getPruebaEmb() {
        return pruebaEmb;
    }

    public void setAntetoxic(UISelectOne antetoxic) {
        this.antetoxic = antetoxic;
    }

    public UISelectOne getAntetoxic() {
        return antetoxic;
    }

    public void setPremedicac(UISelectOne premedicac) {
        this.premedicac = premedicac;
    }

    public UISelectOne getPremedicac() {
        return premedicac;
    }

    public void setObjetvalor(UISelectOne objetvalor) {
        this.objetvalor = objetvalor;
    }

    public UISelectOne getObjetvalor() {
        return objetvalor;
    }

    public void setArearasur(UISelectOne arearasur) {
        this.arearasur = arearasur;
    }

    public UISelectOne getArearasur() {
        return arearasur;
    }

    public void setComprelast(UISelectOne comprelast) {
        this.comprelast = comprelast;
    }

    public UISelectOne getComprelast() {
        return comprelast;
    }

    public void setAutocntel(UISelectOne autocntel) {
        this.autocntel = autocntel;
    }

    public UISelectOne getAutocntel() {
        return autocntel;
    }

    public void setResulPEmb(UISelectOne resulPEmb) {
        this.resulPEmb = resulPEmb;
    }

    public UISelectOne getResulPEmb() {
        return resulPEmb;
    }

    public void setPruebaEmbarazo(String pruebaEmbarazo) {
        this.pruebaEmbarazo = pruebaEmbarazo;
    }

    public String getPruebaEmbarazo() {
        return pruebaEmbarazo;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setLegendServicio(String legendServicio) {
        this.legendServicio = legendServicio;
    }

    public String getLegendServicio() {
        return legendServicio;
    }

    public void setLstConsclin(List<Cnconsclin> lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    public List<Cnconsclin> getLstConsclin() {
        return lstConsclin;
    }

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendAdmision(String legendAdmision) {
        this.legendAdmision = legendAdmision;
    }

    public String getLegendAdmision() {
        return legendAdmision;
    }

    public void setLegendTablaServicio(String legendTablaServicio) {
        this.legendTablaServicio = legendTablaServicio;
    }

    public String getLegendTablaServicio() {
        return legendTablaServicio;
    }

    public void setLegendIngresoEnfermeria(String legendIngresoEnfermeria) {
        this.legendIngresoEnfermeria = legendIngresoEnfermeria;
    }

    public String getLegendIngresoEnfermeria() {
        return legendIngresoEnfermeria;
    }

    public void setConfiproce(UISelectOne confiproce) {
        this.confiproce = confiproce;
    }

    public UISelectOne getConfiproce() {
        return confiproce;
    }

    public void setRenderAlertaNoConfirmaProce(boolean renderAlertaNoConfirmaProce) {
        this.renderAlertaNoConfirmaProce = renderAlertaNoConfirmaProce;
    }

    public boolean isRenderAlertaNoConfirmaProce() {
        return renderAlertaNoConfirmaProce;
    }

    public void setRenderDatosConsentimiento(boolean renderDatosConsentimiento) {
        this.renderDatosConsentimiento = renderDatosConsentimiento;
    }

    public boolean isRenderDatosConsentimiento() {
        return renderDatosConsentimiento;
    }
}

