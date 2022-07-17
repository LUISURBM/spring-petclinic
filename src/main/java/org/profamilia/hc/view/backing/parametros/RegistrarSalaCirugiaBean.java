package org.profamilia.hc.view.backing.parametros;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.ChantecegenePK;
import org.profamilia.hc.model.dto.Chconocprofa;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.ChconsultoriPK;
import org.profamilia.hc.model.dto.Chconsutarif;
import org.profamilia.hc.model.dto.Chespacio;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chetnia;
import org.profamilia.hc.model.dto.Chniveleduca;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chtipovincu;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cprestxcon;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Spservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.sap.webservice.creacliente.CreaCliReq;
import org.profamilia.hc.sap.webservice.creacliente.CreaCliente_Sync_OutProxy;
import org.profamilia.hc.sap.webservice.creacliente.Resp;
import org.profamilia.hc.sap.webservice.creacliente.Respuesta;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorEPSBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorOcupacionBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
// ARCHIVO Registrar Usuario SAP
// FECHA CREACI�N: 13/10/2015
// AUTOR: Carlos Andres Vargas Roa
// Descripci�n: Registro de Salas de Cirugia.
//=======================================================================

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RegistrarSalaCirugiaBean
//=======================================================================
public class RegistrarSalaCirugiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /** Listado de clinicas */
    private List lstClinicas;
    /** Lista de Espacios */
    private List<SelectItem> listEspacios;
    /** Objeto consultorio */
    private Chconsultori consultori;
    /** Lista de consultorios activos */
    private List<Chconsultori> lstConsultoriActivos;
    
    private boolean renderConsulta;
    
    /** Toma la Sala */ 
    private Integer clinicaSala;
    /** Toma el tipo de Consultorio */
    private Integer tipConsulto;
    /** Toma la descripcion del consultorio */
    private String descriSala;
    
    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private List<SelectItem> listzona;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;

    /** Lista que almacena la lista de ocupaciones  */
    private List<SelectItem> listOcupaciones;

    /** Lista que almacena el tipo de afiliacion  */
    private List<SelectItem> listTipoAfiliacion;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Lista de Estratos */
    private List<SelectItem> listEstrato;

    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listEntidadAdm;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /** Almacena la edad del usuario*/
    private Integer edad;

    private String nextAction;

    private String navegationRule;


    private boolean renderUsuario;

    private boolean renderRegistrar;

    private List<Chusuario> lstUsuariosActivos;
    
    private List<Chusuario> lstUsuariosInactivos;

    private BigDecimal porDescuento;

    private List lstEtnia;

    private List lstNivelEducativo;

    private List lstTipoVinculacion;

    private List lstConoceProfamilia;

    private int selectedIndex;

    static final int ACTIVAR_DATOS_USUARIO = 0;

    static final int ACTIVAR_SELECCIONAR_USUARIOS = 1;

    private boolean renderSelecionarUsuario;

    private HtmlDataTable dtConsultaUsuario;

    private UIInput calendarFechaNacimiento;

    private List<Spservicio> lstSpservicios;

    private List<Chconsutarif> ltsTarifaServicio;

    private boolean renderBuscador;

    private boolean renderBuscadorOcupacion;

    private UIInput itEps;

    private boolean deshabilitarEps;

    private static final int ACTIVAR_BUSCADOR = 2;


    private UIInput itOcupacion;


    private boolean deshabilitarOcupacion;

    private static final int ACTIVAR_BUSCADOR_OCUPACION = 3;

    private String seleccionEps;

    private String seleccionOcupacion;


    /** Lista de TipoCliente */
    private List<SelectItem> listTipoCliente;

    private List<Cprestxcon> lstRestricc;

    private Chconsutarif tarifa;

    private boolean mostrarContrato;
    private boolean mostrarAfiliacion;
    private Cpentidadadm entidad;
    private Integer ocupacio;
    private Cpocupacio ocupacioservix;
    
    
    private HtmlDataTable dtConsulta;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarSalaCirugiaBean() {

    }


    // ACTIONS

    public void init() {
        
        consultori = new Chconsultori();
        lstConsultoriActivos = new ArrayList<Chconsultori>();
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        
        try{
            lstConsultoriActivos = 
                        this.serviceLocator.getClinicoService().getSalasCirugia();
            
        }catch(ModelException e){
            e.printStackTrace();
        }
        
          
       

    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------



    
  

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------



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
     * @param renderSelecionarUsuario
     */
    public void setRenderSelecionarUsuario(boolean renderSelecionarUsuario) {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderSelecionarUsuario() {
        return renderSelecionarUsuario;
    }

    /**
     * @param calendarFechaNacimiento
     */
    public void setCalendarFechaNacimiento(UIInput calendarFechaNacimiento) {
        this.calendarFechaNacimiento = calendarFechaNacimiento;
    }

    /**
     * @return
     */
    public UIInput getCalendarFechaNacimiento() {
        return calendarFechaNacimiento;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


   

    public String seleccionarUsuario() {
        renderSelecionarUsuario = false;
        renderUsuario = true;
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        return BeanNavegacion.RUTA_ACTUAL;

    }

    public String volver() {
        return BeanNavegacion.RUTA_IR_INFORMACION_SERVICIO;
    }


    /**
     * @param deshabilitarEps
     */
    public void setDeshabilitarEps(boolean deshabilitarEps) {
        this.deshabilitarEps = deshabilitarEps;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarEps() {
        return deshabilitarEps;
    }


    public void setItEps(UIInput itEps) {
        this.itEps = itEps;
    }

    public UIInput getItEps() {
        return itEps;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setRenderBuscadorOcupacion(boolean renderBuscadorOcupacion) {
        this.renderBuscadorOcupacion = renderBuscadorOcupacion;
    }

    public boolean isRenderBuscadorOcupacion() {
        return renderBuscadorOcupacion;
    }

    public void setItOcupacion(UIInput itOcupacion) {
        this.itOcupacion = itOcupacion;
    }

    public UIInput getItOcupacion() {
        return itOcupacion;
    }

    public void setDeshabilitarOcupacion(boolean deshabilitarOcupacion) {
        this.deshabilitarOcupacion = deshabilitarOcupacion;
    }

    public boolean isDeshabilitarOcupacion() {
        return deshabilitarOcupacion;
    }

    public void setSeleccionEps(String seleccionEps) {
        this.seleccionEps = seleccionEps;
    }

    public String getSeleccionEps() {
        return seleccionEps;
    }

    public void setSeleccionOcupacion(String seleccionOcupacion) {
        this.seleccionOcupacion = seleccionOcupacion;
    }

    public String getSeleccionOcupacion() {
        return seleccionOcupacion;
    }

 

    /**
     * @return
     */
    public String crearSalaCirugia() {
       
        navegationRule = "";
     
        nextAction = BeanNavegacion.RUTA_IR_REGISTRAR_SALAS_CIRUGIA;
      
        boolean wexito = true;
      

 
        String url = "body:infoRegistrarParametroForm:panelTabDatosSAPUsuario:";
        if (clinicaSala == null || clinicaSala.equals("") || clinicaSala == 0 ) {
            
            //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
             FacesUtils.addErrorMessage(url + "mnuClinica", 
                                        MSG_CAMPO_OBLIGATORIO);
                                        
                wexito = false;
            }
        
          
            
            if (tipConsulto == null || tipConsulto.equals("") || tipConsulto == 0) {
            
                //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
                FacesUtils.addErrorMessage(url + "mnuEspacio", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            if (descriSala == null || descriSala.equals("")) {
            
                //TODO: ACA COLOCA EL MENDAJE AL CAMPO, PARA DECIR VALOR REQUERIDO
                FacesUtils.addErrorMessage(url + "inputTareaDescrip", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

        
        int i = 0;
     
        if (wexito) {
            if (consultori != null) {
            
            ChconsultoriPK idconsultorio;
                Chconsultori consultorioObject = 
                    new Chconsultori();
                    
          
            consultorioObject.setHcocdescripcio(descriSala);  
            consultorioObject.setHcocestado(IConstantes.ESTADO_VIGENTE);
            consultorioObject.setHcocoperador(userName());
            consultorioObject.setHcodfecregistr(new Date());
            idconsultorio = new ChconsultoriPK();   
            
            idconsultorio.setHconnumero(new Integer(i + 1));
            idconsultorio.setHcoctipoconsu(tipConsulto.toString());
            idconsultorio.setHconclinica(clinicaSala);
                i++;
            consultorioObject.setId(idconsultorio);
           

    
                // Guardamos el usuario 
                try {
                
                    this.serviceLocator.getClinicoService().saveSalaCirugia(consultorioObject
                                                                           );
                    navegationRule = nextAction;
                    FacesUtils.resetManagedBean("registrarSalaCirugiaBean");
                    FacesUtils.addInfoMessage(MSG_ADICION);
                    descriSala = "";

                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(MSG_NO_ADICION + 
                                               e.getMessage());
                    navegationRule = BeanNavegacion.RUTA_ACTUAL;
                    e.printStackTrace();
                }

         
            
            }
        }


        return navegationRule;

    }

  
    public void setMostrarAfiliacion(boolean mostrarAfiliacion) {
        this.mostrarAfiliacion = mostrarAfiliacion;
    }

    public boolean isMostrarAfiliacion() {
        return mostrarAfiliacion;
    }


    public void setOcupacio(Integer ocupacio) {
        this.ocupacio = ocupacio;
    }

    public Integer getOcupacio() {
        return ocupacio;
    }

    public void setOcupacioservix(Cpocupacio ocupacioservix) {
        this.ocupacioservix = ocupacioservix;
    }

    public Cpocupacio getOcupacioservix() {
        return ocupacioservix;
    }

    public void setLstUsuariosActivos(List<Chusuario> lstUsuariosActivos) {
        this.lstUsuariosActivos = lstUsuariosActivos;
    }

    public List<Chusuario> getLstUsuariosActivos() {
        return lstUsuariosActivos;
    }

    public void setLstUsuariosInactivos(List<Chusuario> lstUsuariosInactivos) {
        this.lstUsuariosInactivos = lstUsuariosInactivos;
    }

    public List<Chusuario> getLstUsuariosInactivos() {
        return lstUsuariosInactivos;
    }
    
    
    /**
     * @param lstClinicas
     */
    public void setLstClinicas(List lstClinicas) {
        this.lstClinicas = lstClinicas;
    }

    /**
     * @return
     */
    public List getLstClinicas() {
        if (lstClinicas == null || lstClinicas.isEmpty()) {
            lstClinicas = new ArrayList();
            ArrayList<Cpclinica> lstClinicaAux = null;
            try {
                lstClinicaAux = 
                        (ArrayList<Cpclinica>)this.serviceLocator.getClinicoService().getClinicas();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstClinicaAux.isEmpty()) {

                Iterator it = lstClinicaAux.iterator();
                int i = 0;
                lstClinicas.add(new SelectItem(0, "Seleccione una Cl�nica ..."));
                while (it.hasNext()) {
                    it.next();
                    lstClinicas.add(new SelectItem(lstClinicaAux.get(i).getCclncodigo(), 
                                                   lstClinicaAux.get(i).getCclcnombre()));
                    i++;
                }
            }
        }

        return lstClinicas;
    }
    
    /**
     * @param param
     */
    public void setListEspacios(List<SelectItem> param) {
        this.listEspacios = param;
    }

    /**
     * @return La lista de los Espacios que existen
     */
    public List<SelectItem> getListEspacios() {
        if (listEspacios == null || listEspacios.isEmpty()) {
            listEspacios = new ArrayList<SelectItem>();
            ArrayList<Chespacio> listEspaAux = null;
            try {
                listEspaAux = 
                        (ArrayList<Chespacio>)this.getServiceLocator().getClinicoService().getEspacioCirugia();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEspaAux.isEmpty()) {

                Iterator it = listEspaAux.iterator();
                int i = 0;
                listEspacios.add(new SelectItem(0, "Seleccione una Opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listEspacios.add(new SelectItem(listEspaAux.get(i).getCespnodigo(), 
                                                    listEspaAux.get(i).getCespdescripcio()));
                    i++;
                }
            }
        }
        return listEspacios;
    }


    public void setConsultori(Chconsultori consultori) {
        this.consultori = consultori;
    }

    public Chconsultori getConsultori() {
        return consultori;
    }

    public void setClinicaSala(Integer clinicaSala) {
        this.clinicaSala = clinicaSala;
    }

    public Integer getClinicaSala() {
        return clinicaSala;
    }

 
    public void setDescriSala(String descriSala) {
        this.descriSala = descriSala;
    }

    public String getDescriSala() {
        return descriSala;
    }

    public void setTipConsulto(Integer tipConsulto) {
        this.tipConsulto = tipConsulto;
    }

    public Integer getTipConsulto() {
        return tipConsulto;
    }

    public void setRenderConsulta(boolean renderConsulta) {
        this.renderConsulta = renderConsulta;
    }

    public boolean isRenderConsulta() {
        return renderConsulta;
    }

    public void setLstConsultoriActivos(List<Chconsultori> lstConsultoriActivos) {
        this.lstConsultoriActivos = lstConsultoriActivos;
    }

    public List<Chconsultori> getLstConsultoriActivos() {
        return lstConsultoriActivos;
    }

    public void setDtConsulta(HtmlDataTable dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public HtmlDataTable getDtConsulta() {
        return dtConsulta;
    }
}

