//=======================================================================
// ARCHIVO AplicacionMedicamentoBean.java
// FECHA CREACI�N: 16/12/2015
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la aplicacion de Medicamentos
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.ChmedicamentId;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaMedicamentosBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE AplicacionVacunaCervixBean
//=======================================================================
public class AplicacionMedicamentoBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario; 
    private String nextAction; 
    private String menuBean; 
    private Long numeroConsulta; 
    private String tipoServicio; 
    private String navigationRule; 
    private Integer consecutivo; 
    private List lstVia; 
    private List lstViaMedicamentos; 
    private List lstSitioAplicacion;
    private Integer tipoHistoria;
    private boolean esVacunacion;
    private String servicio; 
    private String nombreHistoria;
    private List lstNumeroDosis;
    private List lstUnidadMedida;
    private boolean renderReacciones;
    private boolean renderComplicaciones;
    private List lstOpciones;
    private List lstFormaFarmaceutica; 
    
    private List<Cnconsclin> lstConsultasPendientes; 
    private List<Chmedicament> lstMedicamentoAtender;
    private HtmlDataTable dtConsultasPendientes; 
    private HtmlDataTable dtMedicamentosAtender;
    private Chmedicament medicamento; 
    
    private boolean renderPlantilla; 
    private UIInput itDescripcion; 
    private int selectedIndex; 
    private UIInput checkRegistrarActividad;
    private boolean mostrarApli;
    private boolean registrarAct;
    private UIInput checkRegistrarAplicacion;
    private boolean registrarApl;
    private boolean observacion;
    private String actividad;
    private List<SelectItem> lstOpcionesActiv;
          
    private Cnconsclin conclin; 
    
    static final int ACTIVAR_APLICACION = 0;

    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 1;
    
    private String nombreHistoriaFieldset;
    
    private List lstGrupoSanguineo;
    
    private List lstRh;
    
    private boolean renderMedicamentos;
    
    private ListaMedicamentosBean listaMedicamento;
    
    private List<Cnconsclin> listaAdmision;
    
    private HtmlDataTable dtConsultasAdmin; 
    
    private List listServicios;
    
    private List<Chmedicament> listaMedicamnetos;
    
    private List<Chmedicament> lstMedicamentoAtenderAux;
    
    private boolean cambio;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------
    public AplicacionMedicamentoBean() {
    }
    
    public void init()  {
        medicamento = new Chmedicament();
        cambio=false;
        mostrarApli=false;
        observacion=false;
        renderMedicamentos = false;
        lstFormaFarmaceutica = new ArrayList();
        changeActividadRegistra();
    }
    //ACTIONS

    public void inicalizarAplicacionBean() {
        medicamento = new Chmedicament();
        mostrarApli=false;
        lstFormaFarmaceutica = new ArrayList();
        listaMedicamnetos= new ArrayList<Chmedicament>();
    
        consecutivo = 1;
        lstMedicamentoAtender = new ArrayList<Chmedicament>();
        dtConsultasPendientes = new HtmlDataTable();
        dtMedicamentosAtender = new HtmlDataTable();
        medicamento = new Chmedicament();
        observacion=false;
        renderReacciones = false; 
        renderComplicaciones = false; 
        renderMedicamentos = false;
        listaMedicamento = (ListaMedicamentosBean)FacesUtils.getManagedBean("listaMedicamentosBean");
        listaAdmision= listaMedicamento.getListaServicios();
        if(tipoHistoria != null && tipoHistoria.equals(IConstantes.HISTORIA_ADMINISTRAR_MEDICAMENTO)){
            renderMedicamentos = true;
        }
        
        if(usuario!= null && usuario.getHuslnumero()!= null){
            if (numeroConsulta != null) {
                for(Cnconsclin ad:listaAdmision){
                    if(ad.isItemSelect()){
                        Chmedicament medicAux = new Chmedicament();
                        ChmedicamentId id = new ChmedicamentId();
                               
                        id.setHmelconsulta(numeroConsulta);
                        id.setHmelconsuasoci(new Long(ad.getCconnumero()));
                        id.setHmenconsecut(1);
                        medicAux.setId(id);
                        medicAux.setHmecmedicament(ad.getCcocservic().getCsvcnombre());
                        medicAux.setHmedfecregistr(new Date());
                        medicAux.setHmecoperador(userName());
                        medicAux.setHmentipohisto(ad.getCcocservic().getCsvntiphis());
                        medicAux.setHmectiposerv(TIPO_CONSULTA);
                        medicAux.setHmecobservac("");
                        lstMedicamentoAtender.add(medicAux);
                    }
                }
                           
                lstConsultasPendientes = new ArrayList<Cnconsclin>();
                changeActividadRegistra();
            }
        }
    }
    
    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 
    
    public String guardar(){
        navigationRule = "";
        try {

            this.serviceLocator.getClinicoService().saveAplicacionMedicamento(lstMedicamentoAtender,numeroConsulta,userName());
            
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean("menuMedicamentosBean");
            CerrarConsultaUsuarioBean menuBean = (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
            
            if(menuBean != null){
                menuBean.inicalizarCerrarConsultaBean();
            }
            
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + e.getMessage());
        }
      

        return navigationRule;
        }
        
        
        public void adicionarVacunaMedicamento(){
            
        }

    public void guardarRegistro() {
        
        navigationRule = nextAction;
        FacesUtils.resetManagedBean(menuBean);
        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
    }
    //-----------------------------------------------------------------------
        //  Ajax
        //-----------------------------------------------------------------------
        
         public void setHmecpresereacc(ValueChangeEvent valueChangeEvent) {
             medicamento.setHmecpresereacc((String)valueChangeEvent.getNewValue());
             ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
             }
             
             
        public void setHmecpresecompl(ValueChangeEvent valueChangeEvent) {
            medicamento.setHmecpresecompl((String)valueChangeEvent.getNewValue());
            ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
            }
             
             
        public void changeReacciones(){
            renderReacciones= false; 
            if(medicamento != null){
                if(medicamento.getHmecpresereacc() !=  null && medicamento.getHmecpresereacc().equals("S") ){
                    renderReacciones= true; 
                }
            }
            
        }
        
        
        public void changeComplicaciones(){
         renderComplicaciones = false; 
        if(medicamento != null){
          if(medicamento.getHmecpresecompl() !=  null && medicamento.getHmecpresecompl().equals("S") ){
              renderComplicaciones = true; 
          }
        }
        }
         
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    
    public boolean esValido(){
        Long numero;
        numero = null;
        List<Chmedicament> medicamentoAux = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                medicamentoAux = 
                        this.getServiceLocator().getClinicoService().getAdministracionMedicamento(numero, 
                                                                                              consecutivo);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (medicamentoAux != null && !medicamentoAux.isEmpty()) {
            return true;
        }

        return false;
    }
    
    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


     
     //-----------------------------------------------------------------------
     //  Accesorios
     //-----------------------------------------------------------------------
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
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
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
     * @param lstVia
     */
    public void setLstVia(List lstVia) {
        this.lstVia = lstVia;
    }

    /**
     * @return
     */
    public List getLstVia() {
    if(lstVia == null || lstVia.isEmpty()){
        lstVia = new ArrayList(); 
        lstVia.add(new SelectItem("","Seleccione una opci�n"));
        lstVia.add(new SelectItem("IM","Intramuscular"));
        lstVia.add(new SelectItem("SC","Subcut�nea"));
        lstVia.add(new SelectItem("ID","Intrad�rmica"));
        
    }
        return lstVia;
    }
    
    public void setLstViaMedicamentos(List lstViaMedicamentos) {
        this.lstViaMedicamentos = lstViaMedicamentos;
    }

    public List getLstViaMedicamentos() {
        if(lstViaMedicamentos == null || lstViaMedicamentos.isEmpty()){
            lstViaMedicamentos = new ArrayList(); 
            lstViaMedicamentos.add(new SelectItem("","Seleccione"));
            lstViaMedicamentos.add(new SelectItem("IM","Intramuscular"));
            lstViaMedicamentos.add(new SelectItem("IV","Intravenosa"));
            lstViaMedicamentos.add(new SelectItem("VO","Oral"));
            lstViaMedicamentos.add(new SelectItem("VV","Vaginal"));
            lstViaMedicamentos.add(new SelectItem("VP","Parenteral"));
            lstViaMedicamentos.add(new SelectItem("VR","Rectal"));
            lstViaMedicamentos.add(new SelectItem("Vsc","Subcutanea"));
            lstViaMedicamentos.add(new SelectItem("Vsl","Sublingual"));
            lstViaMedicamentos.add(new SelectItem("Vn","Nasal"));
            lstViaMedicamentos.add(new SelectItem("Vt","Topica"));
            lstViaMedicamentos.add(new SelectItem("INH","Inhalatoria"));
            lstViaMedicamentos.add(new SelectItem("VOF","Oftalmica"));
            lstViaMedicamentos.add(new SelectItem("VOT","Otica"));
            lstViaMedicamentos.add(new SelectItem("VTO","Topica"));
            lstViaMedicamentos.add(new SelectItem("N/A","No Aplica"));
            
            
        }
            return lstViaMedicamentos;
        }

    /**
     * @param lstSitioAplicacion
     */
    public void setLstSitioAplicacion(List lstSitioAplicacion) {
        this.lstSitioAplicacion = lstSitioAplicacion;
    }

    /**
     * @return
     */
    public List getLstSitioAplicacion() {
        if(lstSitioAplicacion == null || lstSitioAplicacion.isEmpty()){
            lstSitioAplicacion = new ArrayList(); 
            lstSitioAplicacion.add(new SelectItem("","Seleccione una opci�n"));
            lstSitioAplicacion.add(new SelectItem("GD","Gl�teo Derecho"));
            lstSitioAplicacion.add(new SelectItem("GI","Gl�teo Izquierdo"));
            lstSitioAplicacion.add(new SelectItem("DD","Deltoides Derecho"));
            lstSitioAplicacion.add(new SelectItem("DI","Deltoides Izquierdo"));
            lstSitioAplicacion.add(new SelectItem("MD","Muslo Derecho"));
            lstSitioAplicacion.add(new SelectItem("MI","Muslo Izquierdo"));
            lstSitioAplicacion.add(new SelectItem("PE","Periumbilical"));
            lstSitioAplicacion.add(new SelectItem("NA","No Aplica"));
             
            
        }
            return lstSitioAplicacion;
        }
        
        
    public void setLstNumeroDosis(List lstNumeroDosis) {
        this.lstNumeroDosis = lstNumeroDosis;
    }

    public List getLstNumeroDosis() {
        if(lstNumeroDosis == null || lstNumeroDosis.isEmpty()){
            lstNumeroDosis = new ArrayList(); 
            lstNumeroDosis.add(new SelectItem("","Seleccione una opci�n"));
            lstNumeroDosis.add(new SelectItem(1,"Primera Dosis"));
            lstNumeroDosis.add(new SelectItem(2,"Segunda Dosis"));
            lstNumeroDosis.add(new SelectItem(3,"Tercera Dosis"));
            lstNumeroDosis.add(new SelectItem(6,"Refuerzo"));
            lstNumeroDosis.add(new SelectItem(8,"Dosis Unica"));
            
            
        }
            return lstNumeroDosis;
        }
        
        
    /**
     * @param lstUnidadMedida
     */
    public void setLstUnidadMedida(List lstUnidadMedida) {
        this.lstUnidadMedida = lstUnidadMedida;
    }

    /**
     * @return
     */
    public List getLstUnidadMedida() {
    if(lstUnidadMedida == null || lstUnidadMedida.isEmpty()){
        
        lstUnidadMedida = new ArrayList();
        lstUnidadMedida.add(new SelectItem("","Seleccione"));
        lstUnidadMedida.add(new SelectItem("PD","Primera Dosis"));
        lstUnidadMedida.add(new SelectItem("SD","Segunda Dosis"));
        lstUnidadMedida.add(new SelectItem("TD","Tercera Dosis"));
        lstUnidadMedida.add(new SelectItem("RF","Refuerzo"));
        lstUnidadMedida.add(new SelectItem("UN","�nica"));
        /*lstUnidadMedida.add(new SelectItem("g","Gramo"));
        lstUnidadMedida.add(new SelectItem("G","Gramo"));
        lstUnidadMedida.add(new SelectItem("G/L","Gramo/Litro"));
        lstUnidadMedida.add(new SelectItem("g/mL"," Gramo X Mililitro"));
        lstUnidadMedida.add(new SelectItem("mcg","Microgramo"));
        lstUnidadMedida.add(new SelectItem("mg","Miligramo"));
        lstUnidadMedida.add(new SelectItem("mg/mL","Microgramo X Mililitro"));
        lstUnidadMedida.add(new SelectItem("MEQ/ML","MEQ/ML"));
        lstUnidadMedida.add(new SelectItem("MG/MCG","MG/MCG"));
        lstUnidadMedida.add(new SelectItem("mcg/ML","mcg/ML"));
        lstUnidadMedida.add(new SelectItem("MCG","MCG"));
        lstUnidadMedida.add(new SelectItem("MG-G","MG-G"));
        lstUnidadMedida.add(new SelectItem("mL","Mililitro"));
        lstUnidadMedida.add(new SelectItem("UI","Unidad Internacional"));
        lstUnidadMedida.add(new SelectItem("UI/ML","Unidad Internacional/ Mililitro"));
        lstUnidadMedida.add(new SelectItem("%","Porcentaje"));*/
    }
    
        return lstUnidadMedida;
    }


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    public void setEsVacunacion(boolean esVacunacion) {
        this.esVacunacion = esVacunacion;
    }

    public boolean isEsVacunacion() {
        return esVacunacion;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setNombreHistoria(String nombreHistoria) {
        this.nombreHistoria = nombreHistoria;
    }

    public String getNombreHistoria() {
        return nombreHistoria;
    }
    

        public void setLstOpciones(List lstOpciones) {
            this.lstOpciones = lstOpciones;
        }

        public List getLstOpciones() {
            if(lstOpciones == null || lstOpciones.isEmpty()){
                lstOpciones = new ArrayList(); 
                lstOpciones.add(new SelectItem("S","SI"));
                lstOpciones.add(new SelectItem("N","NO"));
                        
            }
                return lstOpciones;
            }


    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setRenderReacciones(boolean renderReacciones) {
        this.renderReacciones = renderReacciones;
    }

    public boolean isRenderReacciones() {
        return renderReacciones;
    }

    public void setRenderComplicaciones(boolean renderComplicaciones) {
        this.renderComplicaciones = renderComplicaciones;
    }

    public boolean isRenderComplicaciones() {
        return renderComplicaciones;
    }
    
    public void setLstFormaFarmaceutica(List lstFormaFarmaceutica) {
        this.lstFormaFarmaceutica = lstFormaFarmaceutica;
    }

    public List getLstFormaFarmaceutica() {
        if(lstFormaFarmaceutica == null || lstFormaFarmaceutica.isEmpty()){
            lstFormaFarmaceutica = new ArrayList();
            if(tipoHistoria != null && tipoHistoria.equals(IConstantes.HISTORIA_ADMINISTRAR_MEDICAMENTO)){
                lstFormaFarmaceutica.add(new SelectItem("","Seleccione.."));
                lstFormaFarmaceutica.add(new SelectItem("AMPO","Ampolla"));
                lstFormaFarmaceutica.add(new SelectItem("CREM","Crema"));
                lstFormaFarmaceutica.add(new SelectItem("DIU","Diu"));
                lstFormaFarmaceutica.add(new SelectItem("EMUL","Emulsiones"));
                lstFormaFarmaceutica.add(new SelectItem("GOTA","Gota"));
                lstFormaFarmaceutica.add(new SelectItem("IMSU","Implante Subdermico"));
                lstFormaFarmaceutica.add(new SelectItem("INTR","Intrauterino"));
                lstFormaFarmaceutica.add(new SelectItem("INYE","Inyectable"));
                lstFormaFarmaceutica.add(new SelectItem("JEPR","Jeringa Prellena"));
                lstFormaFarmaceutica.add(new SelectItem("OVUL","Ovulo"));
                lstFormaFarmaceutica.add(new SelectItem("POLV","Polvo"));
                lstFormaFarmaceutica.add(new SelectItem("SOLU","Solucion Liquida"));
                lstFormaFarmaceutica.add(new SelectItem("SUSP","Suspensi�n"));
                lstFormaFarmaceutica.add(new SelectItem("TABL","Tableta"));
                lstFormaFarmaceutica.add(new SelectItem("CAPS","Capsulas"));
                lstFormaFarmaceutica.add(new SelectItem("IMPL","Implante"));
                lstFormaFarmaceutica.add(new SelectItem("INH","Inhalable"));
                lstFormaFarmaceutica.add(new SelectItem("N/A","No Aplica"));
            
            }else{          
                    lstFormaFarmaceutica.add(new SelectItem("","Seleccione.."));
                    lstFormaFarmaceutica.add(new SelectItem("AMPO","Ampolla"));
                    lstFormaFarmaceutica.add(new SelectItem("JEPR","Jeringa Prellena"));
            }
        }
        
            return lstFormaFarmaceutica;
        }

    public void setConclin(Cnconsclin conclin) {
        this.conclin = conclin;
    }

    public Cnconsclin getConclin() {
        return conclin;
    }

    public void setLstMedicamentoAtender(List<Chmedicament> lstMedicamentoAtender) {
        this.lstMedicamentoAtender = lstMedicamentoAtender;
    }

    public List<Chmedicament> getLstMedicamentoAtender() {
        return lstMedicamentoAtender;
    }


    public void setLstConsultasPendientes(List<Cnconsclin> lstConsultasPendientes) {
        this.lstConsultasPendientes = lstConsultasPendientes;
    }

    public List<Cnconsclin> getLstConsultasPendientes() {
        return lstConsultasPendientes;
    }

    public void setDtConsultasPendientes(HtmlDataTable dtConsultasPendientes) {
        this.dtConsultasPendientes = dtConsultasPendientes;
    }

    public HtmlDataTable getDtConsultasPendientes() {
        return dtConsultasPendientes;
    }

    public void agregarMedicamento() {
    
     if(lstMedicamentoAtender == null || lstMedicamentoAtender.isEmpty()){
         lstMedicamentoAtender = new ArrayList<Chmedicament>();
     }
         
         if(lstConsultasPendientes!= null && !lstConsultasPendientes.isEmpty()){
                   for(Cnconsclin conatender: lstConsultasPendientes){
                   
                   if(conatender.isSeleccionado()){
                       Chmedicament medicAux = new Chmedicament();
                       ChmedicamentId id = new ChmedicamentId();
                       
                       id.setHmelconsulta(numeroConsulta);
                       id.setHmelconsuasoci(new Long(conatender.getCconnumero()));
                       id.setHmenconsecut(1);
                       medicAux.setId(id);
                       medicAux.setHmecmedicament(conatender.getCcocservic().getCsvcnombre());
                       medicAux.setHmedfecregistr(new Date());
                       medicAux.setHmecoperador(userName());
                       medicAux.setHmentipohisto(tipoHistoria);
                       medicAux.setHmectiposerv(TIPO_CONSULTA);
                       lstMedicamentoAtender.add(medicAux);
                       
                   }
                       
                   }
               }
           
     
    }

    public void changeActividadRegistra() {
        List<Chmedicament> lstMedicamentoAtenderAux = new ArrayList();
        
        if (null != lstMedicamentoAtender) {
            if (lstMedicamentoAtender.size() > 0) {
                lstMedicamentoAtenderAux.addAll(lstMedicamentoAtender);
                lstMedicamentoAtender.clear();
            }

        }
        if (lstMedicamentoAtenderAux != null && !lstMedicamentoAtenderAux.isEmpty()) {
            for (Chmedicament medicamento: lstMedicamentoAtenderAux) {

                if (null != medicamento) {
                    Chmedicament medicamentoObj = null;
                    try {
                        medicamentoObj = 
                                this.serviceLocator.getClinicoService().getMedicamentoByConsultaAsociada(medicamento.getId().getHmelconsuasoci());
                    } catch (ModelException e) {
                        e.printStackTrace();
                        navigationRule = "";
                        FacesUtils.addErrorMessage("No se encontro registro del medicamento previo" + 
                                                   e.getMessage());
                        medicamentoObj = null;
                    }
                    if (medicamentoObj == null) {
                        if (null != medicamento.getHmelcregiacti() && 
                            !medicamento.getHmelcregiacti().equals("")) {
                            int vacu = 
                                medicamento.getHmentipohisto().compareTo(HISTORIA_VACUNACION);
                            int medi = 
                                medicamento.getHmentipohisto().compareTo(HISTORIA_ADMINISTRAR_MEDICAMENTO);
                            if (vacu == 0) {
                                medicamento.setVacunacion(true);
                            } else if (medi == 0) {
                                medicamento.setMedicamento(true);
                            } else {
                                medicamento.setVacunacion(false);
                                medicamento.setMedicamento(false);
                            }


                            if (medicamento.getHmelcregiacti().equals("A")) {
                                medicamento.setAplicacion(true);
                                registrarApl = false;
                                medicamento.setSelectObs(true);

                            } else if (medicamento.getHmelcregiacti().equals("D")) {
                                medicamento.setAplicacion(false);
                                medicamento.setVacunacion(false);
                                medicamento.setSelectObs(true);
                            } else if (medicamento.getHmelcregiacti().equals("E")) {
                                medicamento.setAplicacion(false);
                                medicamento.setVacunacion(false);
                                medicamento.setSelectObs(true);
                            } else if (medi == 0) {
                                medicamento.setMedicamento(false);
                                registrarApl = true;
                                medicamento.setSelectObs(true);
                            }
                        } else {
                            medicamentoObj = new Chmedicament();
                            medicamento.setAplicacion(false);
                            registrarApl = false;
                            medicamento.setSelectObs(false);


                        }
                    } else {
                        if (medicamento.getHmelcregiacti() != null) {
                            if (!medicamento.getHmelcregiacti().equals(medicamentoObj.getHmelcregiacti())) {
                                medicamentoObj.setHmelcregiacti(medicamento.getHmelcregiacti());
                                cambio = true;
                            }else{
                                cambio=false;
                            }
                        }
                        medicamento = medicamentoObj;
                        if (null != medicamento.getHmelcregiacti()) {
                            int vacu = 
                                medicamento.getHmentipohisto().compareTo(HISTORIA_VACUNACION);
                            int medi = 
                                medicamento.getHmentipohisto().compareTo(HISTORIA_ADMINISTRAR_MEDICAMENTO);
                            if (vacu == 0) {
                                medicamento.setVacunacion(true);
                            } else if (medi == 0) {
                                medicamento.setMedicamento(true);
                            } else {
                                medicamento.setVacunacion(false);
                                medicamento.setMedicamento(false);
                            }


                            if (medicamento.getHmelcregiacti().equals("A")) {
                            if(cambio){
                                medicamento.setHmecpresentaci(null); 
                                medicamento.setHmennumervacun (null); 
                                medicamento.setHmeclotemedic(null); 
                                medicamento.setHmedfechavenci(null); 
                                medicamento.setHmecviadministr(null); 
                                medicamento.setHmecsitioaplic(null); 
                                medicamento.setHmelcgrusangu(null); 
                                medicamento.setHmelcrh (null); 
                                medicamento.setHmecnomblabo(null);
                                medicamento.setAplicacion(true);
                                registrarApl = false;
                                medicamento.setSelectObs(true);
                            }else{
                                medicamento.setAplicacion(true);
                                registrarApl = false;
                                medicamento.setSelectObs(true);
                            }

                            } else if (medicamento.getHmelcregiacti().equals("D")) {
                                if(cambio){
                                    medicamento.setHmecpresentaci(null); 
                                    medicamento.setHmennumervacun (null); 
                                    medicamento.setHmeclotemedic(null); 
                                    medicamento.setHmedfechavenci(null); 
                                    medicamento.setHmecviadministr(null); 
                                    medicamento.setHmecsitioaplic(null); 
                                    medicamento.setHmelcgrusangu(null); 
                                    medicamento.setHmelcrh (null); 
                                    medicamento.setHmecnomblabo(null);
                                    medicamento.setAplicacion(false);
                                    medicamento.setVacunacion(false);
                                    medicamento.setSelectObs(true);
                                }else{
                                medicamento.setAplicacion(false);
                                medicamento.setVacunacion(false);
                                medicamento.setSelectObs(true);
                                }
                            } else if (medicamento.getHmelcregiacti().equals("E")) {
                                if(cambio){
                                    medicamento.setHmecpresentaci(null); 
                                    medicamento.setHmennumervacun (null); 
                                    medicamento.setHmeclotemedic(null); 
                                    medicamento.setHmedfechavenci(null); 
                                    medicamento.setHmecviadministr(null); 
                                    medicamento.setHmecsitioaplic(null); 
                                    medicamento.setHmelcgrusangu(null); 
                                    medicamento.setHmelcrh (null); 
                                    medicamento.setHmecnomblabo(null);
                                    medicamento.setAplicacion(false);
                                    medicamento.setVacunacion(false);
                                    medicamento.setSelectObs(true);
                                }else{
                                medicamento.setAplicacion(false);
                                medicamento.setVacunacion(false);
                                medicamento.setSelectObs(true);
                                }
                            }
                            
                            
                            else if (medi == 0) {
                                medicamento.setMedicamento(false);
                                registrarApl = true;
                                medicamento.setSelectObs(true);
                            }
                        } else {
                            medicamentoObj = new Chmedicament();
                            medicamento.setAplicacion(false);
                            registrarApl = false;
                            medicamento.setSelectObs(false);


                        }
                    }
                }
                lstMedicamentoAtender.add(medicamento);
            }
        }
    }
    
    public String eliminarMedicamento() {
        // Add event code here...
        return null;
    }

    public void setDtMedicamentosAtender(HtmlDataTable dtMedicamentosAtender) {
        this.dtMedicamentosAtender = dtMedicamentosAtender;
    }

    public HtmlDataTable getDtMedicamentosAtender() {
        return dtMedicamentosAtender;
    }

    public void setMedicamento(Chmedicament medicamento) {
        this.medicamento = medicamento;
    }

    public Chmedicament getMedicamento() {
        return medicamento;
    }
    
    
    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            buscador.setNombreBeanAnterior("aplicacionMedicamentoBean");
            buscador.setTagRenderizar("panelGridIngresoCirugiaTab");
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            medicamento.setHmecobservac(buscador.getPlantillaSelect().getHplcdescripcio());
           
        }
        
        if (buscador != null) {
            buscador.setNombreBeanAnterior("registrarNotaEnfermeriaBean");
            buscador.setTagRenderizar("panelGridIngresoCirugiaTab");
        }
        renderPlantilla = false;
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");
    }
    
    public void mostrarBuscadorPlantilla(){
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null) {
             medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
            buscador.setDescripcion(true);
            buscador.setNombreBeanAnterior("aplicacionMedicamentoBean");
            buscador.setTagRenderizar("panelGridAplicacionMedicamentoTab");
         }
       selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS; 
        renderPlantilla = true; 
    }


public void volverMedicamentos(){
    BuscadorPlantillaCirugiaBean buscador = 
        (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
   
        buscador.setNombreBeanAnterior("aplicacionMedicamentoBean");
        buscador.setTagRenderizar("panelGridAplicacionMedicamentoTab");
     
    renderPlantilla = false;
    selectedIndex = ACTIVAR_APLICACION;
    FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
}
    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setItDescripcion(UIInput itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public UIInput getItDescripcion() {
        return itDescripcion;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setCheckRegistrarActividad(UIInput checkRegistrarActividad) {
        this.checkRegistrarActividad = checkRegistrarActividad;
    }

    public UIInput getCheckRegistrarActividad() {
        return checkRegistrarActividad;
    }

    public void setMostrarApli(boolean mostrarApli) {
        this.mostrarApli = mostrarApli;
    }

    public boolean isMostrarApli() {
        return mostrarApli;
    }

    public void setRegistrarAct(boolean registrarAct) {
        this.registrarAct = registrarAct;
    }

    public boolean isRegistrarAct() {
        return registrarAct;
    }
    
  
    public void setRegistrarAct(ValueChangeEvent valueChangeEvent) {
        setRegistrarAct((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setRegistrarApl(ValueChangeEvent valueChangeEvent) {
        setRegistrarApl((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setCheckRegistrarAplicacion(UIInput checkRegistrarAplicacion) {
        this.checkRegistrarAplicacion = checkRegistrarAplicacion;
    }

    public UIInput getCheckRegistrarAplicacion() {
        return checkRegistrarAplicacion;
    }

    public void setRegistrarApl(boolean registrarApl) {
        this.registrarApl = registrarApl;
    }

    public boolean isRegistrarApl() {
        return registrarApl;
    }

    public void setObservacion(boolean observacion) {
        this.observacion = observacion;
    }

    public boolean isObservacion() {
        return observacion;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(ValueChangeEvent valueChangeEvent) {
      
        Chmedicament medicamento = null;
        medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
        medicamento.setHmelcregiacti((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }

    public void setLstOpcionesActiv(List<SelectItem> lstOpcionesActiv) {
        this.lstOpcionesActiv = lstOpcionesActiv;
    }

    public List<SelectItem> getLstOpcionesActiv() {
        if (lstOpcionesActiv == null || lstOpcionesActiv.isEmpty()) {
            lstOpcionesActiv = new ArrayList<SelectItem>();
            lstOpcionesActiv.add(new SelectItem("", "Seleccione una opci�n "));
            //lstOpcionesActiv.add(new SelectItem("D", "Dispensaci�n"));
            lstOpcionesActiv.add(new SelectItem("A", "Administraci�n"));
            lstOpcionesActiv.add(new SelectItem("E", "Entrega"));
            
        }
        return lstOpcionesActiv;
    }

    public void setNombreHistoriaFieldset(String nombreHistoriaFieldset) {
        this.nombreHistoriaFieldset = nombreHistoriaFieldset;
    }

    public String getNombreHistoriaFieldset() {
        return nombreHistoriaFieldset;
    }

    public void setLstGrupoSanguineo(List lstGrupoSanguineo) {
        this.lstGrupoSanguineo = lstGrupoSanguineo;
    }

    public List getLstGrupoSanguineo() {
        if(lstGrupoSanguineo == null || lstGrupoSanguineo.isEmpty()){
            lstGrupoSanguineo = new ArrayList(); 
            lstGrupoSanguineo.add(new SelectItem("","Seleccione una opci�n"));
            lstGrupoSanguineo.add(new SelectItem("A","A"));
            lstGrupoSanguineo.add(new SelectItem("AB","AB"));
            lstGrupoSanguineo.add(new SelectItem("B","B"));
            lstGrupoSanguineo.add(new SelectItem("O","O"));
            lstGrupoSanguineo.add(new SelectItem("N","No sabe"));
            }
        return lstGrupoSanguineo;
    }

    public void setLstRh(List lstRh) {
        this.lstRh = lstRh;
    }

    public List getLstRh() {
        if(lstRh == null || lstRh.isEmpty()){
            lstRh = new ArrayList(); 
            lstRh.add(new SelectItem("P","POS(+)"));
            lstRh.add(new SelectItem("N","NEG(-)"));
            }
        return lstRh;
    }

    public void setRenderMedicamentos(boolean renderDosis) {
        this.renderMedicamentos = renderDosis;
    }

    public boolean isRenderMedicamentos() {
        return renderMedicamentos;
    }

    public void setListaMedicamento(ListaMedicamentosBean listaMedicamento) {
        this.listaMedicamento = listaMedicamento;
    }

    public ListaMedicamentosBean getListaMedicamento() {
        return listaMedicamento;
    }

   
    public void setDtConsultasAdmin(HtmlDataTable dtConsultasAdmin) {
        this.dtConsultasAdmin = dtConsultasAdmin;
    }

    public HtmlDataTable getDtConsultasAdmin() {
        return dtConsultasAdmin;
    }


    public void setListServicios(List listServicios) {
        this.listServicios = listServicios;
    }

    public List getListServicios() {
        return listServicios;
    }

    public void setListaMedicamnetos(List<Chmedicament> listaMedicamnetos) {
        this.listaMedicamnetos = listaMedicamnetos;
    }

    public List<Chmedicament> getListaMedicamnetos() {
        return listaMedicamnetos;
    }

    public void setListaAdmision(List<Cnconsclin> listaAdmision) {
        this.listaAdmision = listaAdmision;
    }

    public List<Cnconsclin> getListaAdmision() {
        return listaAdmision;
    }


    public void setLstMedicamentoAtenderAux(List<Chmedicament> lstMedicamentoAtenderAux) {
        this.lstMedicamentoAtenderAux = lstMedicamentoAtenderAux;
    }

    public List<Chmedicament> getLstMedicamentoAtenderAux() {
        return lstMedicamentoAtenderAux;
    }
    
    public void setPresentacion(ValueChangeEvent valueChangeEvent) {
        medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
        medicamento.setHmecpresentaci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    public void setDosis(ValueChangeEvent valueChangeEvent) {
        medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
        medicamento.setHmennumervacun((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }


    
    public void setLote(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmeclotemedic((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    
    
    public void setFechaVenci(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmedfechavenci((Date)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    
    public void setViaAdmi(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmecviadministr((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    
    public void setSitioApli(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmecsitioaplic((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    
    public void setGrupoSang(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmelcgrusangu((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    
    public void setRh(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmelcrh((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    
    public void setLaboratorio(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmecnomblabo((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }
    public void setNotaEnfer(ValueChangeEvent valueChangeEvent) {
         medicamento = (Chmedicament)this.dtMedicamentosAtender.getRowData();
         medicamento.setHmecobservac((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);     
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }

    public boolean isCambio() {
        return cambio;
    }
}
