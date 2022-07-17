//=======================================================================
// ARCHIVO DatosBasicosUsuarioBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a los datos basicos del usuario.
//=======================================================================

package org.profamilia.hc.view.backing.comun;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.AntecedentesGeneralesDTO;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.Cfencuecovid;
import org.profamilia.hc.model.dto.Chantalerg;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantfami;
import org.profamilia.hc.model.dto.Chantfarma;
import org.profamilia.hc.model.dto.Chantit;
import org.profamilia.hc.model.dto.Chantox;
import org.profamilia.hc.model.dto.Chantpatol;
import org.profamilia.hc.model.dto.Chantquir;
import org.profamilia.hc.model.dto.Chanttrans;
import org.profamilia.hc.model.dto.Chanttrauma;
import org.profamilia.hc.model.dto.Chconinfxcon;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chfertdato;
import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cppais;
import org.profamilia.hc.model.dto.Cpparametr;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.sap.webservice.usuariosSapWSService.UsuarioWsSap;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCirugiasBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorConsentimientoBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorOcupacionBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=================================================================
//  CLASE DatosUsuarioBean
//=======================================================================

/**
 * DatosBasicosUsuarioBean: Permite registrar los Datos Basicos de un Usuario
 * @author Jos� Andr�s Riano jariano@profamilia.org.co
 * 
 */
public class DatosBasicosUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

   /** Almacena true si existe el usuario  */
    boolean existeusuario;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Variable que almacena la lista de zonas */
    private List<SelectItem> listzona;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena la lista de Paises */
    private List<SelectItem> listPaises;

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

    /** Lista que almacena la lista de EPS */
    private List<SelectItem> listEntidadAdm;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
    /** Almacena los datos de usuario incial */
    private Chusuario usuarioTemp;


    /** Almacena la cosnulta X clinica */
    private Cnconsclin consulta;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /**Variable que almacena el tipo de servicio de la consulta */
    private Cpservicio servicio;

    private List lstOpciones;

    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    private String navigationRule;
    
    private boolean renderContacto; 
    
    private boolean renderOficina; 
    
    private boolean renderCasa; 
    
    private boolean renderCelular; 
    
    private boolean renderMensajes; 
    
    private boolean renderCorreo;
    
    private boolean renderAutoriza;
    
    private boolean wexitoContacto;
    
    private Long codigoAgenda;
    
    private UsuarioWsSap usuarioWsSap;
    
    private List<AntecedentesGeneralesDTO> lstHistoricoAntecedente;
    
    
    private UIInput itOcupacion;
    
    private String seleccionOcupacion;
    
    private boolean renderBuscadorOcupacion;
    
    private Cpocupacio ocupacioservix;
   
    private static final int ACTIVAR_DATOS_USUARIO = 0;

    private static final int ACTIVAR_BUSCADOR_OCUPACION = 1;
  

    private int selectedIndex;
    
    
    private static final int BEAN_USUARIO_DATOS_USUARIO = 3;
    
    private boolean deshabilitarOcupacion;

    
    /** Lista que almacena la lista de Identidades G�neros  */
    private List<SelectItem> listIdentidadGenero;
        
    /** Lista de sexos */
    private List<SelectItem> listOrientacionSexual;
    
    private boolean renderOrientacionSexual;
    
    
    /** Almacena el tipo de historia*/
    private boolean renderViveSola;
    
    private String mensaje;
    
    private boolean renderConsentimiento;
    
    private boolean renderRealizaConsentimiento;
    
    private List<Cnconsclin>lstConsultas;
    
    private boolean renderEPS;
    
    static final int ACTIVAR_BUSCADOR_CONSENTIMIENTO = 1;
    
    private boolean mostrarConsentimiento;
    
    private List<Chplanconsinfo> lstConsentimientoAceptados;
    
    private HtmlDataTable dtConsentimiento;
    
    private List<Chconinfxcon> listaChconinfxcon;
    
    private List<Chplanconsinfo> lstConsentimientoInformado;
    
    private boolean esFertilidad;
    
    private String identPareja = "Sin Dato";
    
    private String nombrePareja = "Sin Dato";
    
    private String codigoConsentimiento;
    
    private UIInput itConsentimiento;
    
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public DatosBasicosUsuarioBean() {
    }


    public void init() {
    
        
        if (usuario == null) {
            usuario = new Chusuario();
            usuarioTemp = new Chusuario();
        }
        nextAction = "";
        lstHistoricoAntecedente = new ArrayList();
        listIdentidadGenero = new ArrayList<SelectItem>();
        listOrientacionSexual = new ArrayList<SelectItem>();
        itOcupacion = new UIInput();
        esFertilidad = false; 
        
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        identPareja = "Sin Dato ";
        nombrePareja = "Sin Dato ";
        
     
    }
    

    //ACTIONS

    public String inicializarUsuario() {
        renderEPS = true;
        
        renderConsentimiento = false;
        
        renderRealizaConsentimiento = false; 
        
        if(usuario != null){
            mensaje();
        }
           
        if (usuario!= null && usuario.getHusdfechanacim() != null) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
            this.setEdad(edad);
            if(edad >= 11){
                renderOrientacionSexual=true;
            }else{
                renderOrientacionSexual=false;
            }
        }
        if (usuario != null && usuario.getHuslnumero() != null) {
            try {
            lstHistoricoAntecedente = new ArrayList();
            lstHistoricoAntecedente.clear();
            List<Chantecegene> aux =  this.serviceLocator.getClinicoService().getAntecedentesUsuario(usuario.getHuslnumero());
            List<Chconsulta> aux1 = this.serviceLocator.getHistoriaService().getConsultasHistoricoAntecedentes(usuario.getHuslnumero(),true);
            if(aux !=null && !aux.isEmpty()){
                for(int i =0;i<aux.size();i++){
                    AntecedentesGeneralesDTO objeto = new AntecedentesGeneralesDTO();
                    objeto.setTipoAntecedente(aux.get(i).getHancnomtipante());
                    objeto.setDescripcionAntecedente(aux.get(i).getHantdescripcio());
                    objeto.setFechaRegistro(aux.get(i).getHandfecregistr());
                    lstHistoricoAntecedente.add(objeto);
                }
               
            }
                    if(aux1 !=null && !aux1.isEmpty()){
                        Iterator it ;
                        for(int i =0;i<aux1.size();i++){
                            AntecedentesGeneralesDTO objeto = new AntecedentesGeneralesDTO();
                            Chantox toxicos;
                            Chantfami familiares;
                            Chantalerg alergicos;
                            Chantfarma farmacologicos;
                            Chantit its;
                            Chanttrans transfusionales;
                            Chantpatol patologicos;
                            Chantquir quirurgicos;
                            Chanttrauma traumacologicos;
                            if(aux1.get(i).getChantox()!=null){
                                it = aux1.get(i).getChantox().iterator();
                                while(it.hasNext()){
                                toxicos = (Chantox)it.next();
                                if(("S").equals(toxicos.getHantcrefiere())){
                                objeto.setTipoAntecedente("T�xicos");
                                objeto.setDescripcionAntecedente(toxicos.getHantcdesc());
                                objeto.setFechaRegistro(toxicos.getHantdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                }
                                }
                                
                            }
                          
                            if(aux1.get(i).getChantalerg()!=null){
                                it = aux1.get(i).getChantalerg().iterator();
                                while(it.hasNext()){
                                    alergicos = (Chantalerg)it.next();
                                    if(("S").equals(alergicos.getHanacrefiere())){
                                    objeto.setTipoAntecedente("Alergias");
                                    objeto.setDescripcionAntecedente(alergicos.getHanacdesc());
                                    objeto.setFechaRegistro(alergicos.getHanadfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                           
                            if(aux1.get(i).getChantfami()!=null){
                                it = aux1.get(i).getChantfami().iterator();
                                while(it.hasNext()){
                                    familiares = (Chantfami)it.next();
                                    if(("S").equals(familiares.getHanfcrefiere())){
                                    objeto.setTipoAntecedente("Familiares");
                                    objeto.setDescripcionAntecedente(familiares.getHanfcdesc());
                                    objeto.setFechaRegistro(familiares.getHanfdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                           
                            if(aux1.get(i).getChantquir()!=null){
                                it = aux1.get(i).getChantquir().iterator();
                                while(it.hasNext()){
                                quirurgicos = (Chantquir)it.next();
                                    if(("S").equals(quirurgicos.getHanqcrefiere())){
                                objeto.setTipoAntecedente("Quirurgicos");
                                objeto.setDescripcionAntecedente(quirurgicos.getHanqcdesc());
                                objeto.setFechaRegistro(quirurgicos.getHanqdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                         
                            if(aux1.get(i).getChantpatol()!=null){
                                it = aux1.get(i).getChantpatol().iterator();
                                while(it.hasNext()){
                                    patologicos = (Chantpatol)it.next();
                                    if(("S").equals(patologicos.getHagcrefiere())){
                                    objeto.setTipoAntecedente("Patolog�cos");
                                    objeto.setDescripcionAntecedente(patologicos.getHagcdescri());
                                    objeto.setFechaRegistro(patologicos.getHagdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                                                    
                                }
                            }
                          
                            if(aux1.get(i).getChantfarma()!=null){
                                it = aux1.get(i).getChantfarma().iterator();
                                while(it.hasNext()){
                                    farmacologicos = (Chantfarma)it.next();
                                    if(("S").equals(farmacologicos.getHanfcrefiere())){
                                    objeto.setTipoAntecedente("Farmacol�gicos");
                                    objeto.setDescripcionAntecedente(farmacologicos.getHanfcdesc());
                                    objeto.setFechaRegistro(farmacologicos.getHanfdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                           
                            if(aux1.get(i).getChanttrauma()!=null){
                                it = aux1.get(i).getChanttrauma().iterator();
                                while(it.hasNext()){
                                    traumacologicos = (Chanttrauma)it.next();
                                    if(("S").equals(traumacologicos.getHantcrefiere())){
                                    objeto.setTipoAntecedente("Traumacolo�gicos");
                                    objeto.setDescripcionAntecedente(traumacologicos.getHantcdesc());
                                    objeto.setFechaRegistro(traumacologicos.getHantdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                           
                            if(aux1.get(i).getChantit()!=null){
                                it = aux1.get(i).getChantit().iterator();
                                while(it.hasNext()){
                                    its = (Chantit)it.next();
                                    if(("S").equals(its.getHanicrefiere())){
                                    objeto.setTipoAntecedente("Its");
                                    objeto.setDescripcionAntecedente(its.getHanicdesc());
                                    objeto.setFechaRegistro(its.getHanidfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                           
                            if(aux1.get(i).getChanttrans()!=null){
                                it = aux1.get(i).getChanttrans().iterator();
                                while(it.hasNext()){
                                    transfusionales = (Chanttrans)it.next();
                                    if(("S").equals(transfusionales.getHantcrefiere())){
                                    objeto.setTipoAntecedente("Transfusionales");
                                    objeto.setDescripcionAntecedente(transfusionales.getHantcdesc());
                                    objeto.setFechaRegistro(transfusionales.getHantdfecreg());
                                    lstHistoricoAntecedente.add(objeto);
                                    objeto = new AntecedentesGeneralesDTO();
                                    }
                                }
                            }
                           
                        }
                    }
                //lstHistoricoAntecedente =
                    //this.serviceLocator.getClinicoService().getAntecedentesUsuario(usuario.getHuslnumero());
                    
                } catch (ModelException e) {
                    e.printStackTrace();
                }
        }
        
        if(consulta != null && consulta.getCcocservic() != null 
            && IConstantes.HISTORIA_CONTROL_VASECTOMIA.equals(consulta.getCcocservic().getCsvntiphis())){
            renderOrientacionSexual=false;
        }
        
        if(consulta != null && consulta.getCcocservic() != null 
            && IConstantes.HISTORIA_FERTILIDAD.equals(consulta.getCcocservic().getCsvntiphis())){
            esFertilidad=true;
        }
        
        if(esFertilidad){
            Chfertdato datoFertilidad = null;
            try {
                datoFertilidad = 
                        serviceLocator.getClinicoService().getDatosFertilidadUltimaPareja(consulta.getCcolusuario().getHuslnumero(),null);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(datoFertilidad != null){
                identPareja = formatearCampo(datoFertilidad.getHfdctipide()) + " " + formatearCampo(datoFertilidad.getHfdanumide());
                nombrePareja = formatearCampo(datoFertilidad.getHfdcprinom()) + " " + formatearCampo(datoFertilidad.getHfdcsegnom()) + " " + formatearCampo(datoFertilidad.getHfdcpriape()) + " " + formatearCampo(datoFertilidad.getHfdcsegape()) + " ";
                
                if(datoFertilidad.getHfdctipide() == null || datoFertilidad.getHfdctipide().equals("")){
                    identPareja = "Sin Dato";
                    nombrePareja = "Sin Dato";
                }
                
                if(datoFertilidad.getHfdcprinom() == null || datoFertilidad.getHfdcprinom().equals("")){
                    identPareja = "Sin Dato";
                    nombrePareja = "Sin Dato";
                }
            }
            
            if(identPareja == null || identPareja.equals("")){
                identPareja = "Sin Dato";
            }
            
            if(nombrePareja == null || nombrePareja.equals("")){
                nombrePareja = "Sin Dato";
            }
            
            
        }
        
        setCiudad();
        changeSeleccionOcupacion();

        if (servicio != null) {
            this.setServicio(servicio);
        }

    
        if(usuario.getHuseautorcont()!= null && usuario.getHuseautorcont().equals("S")){
            renderAutoriza = true; 
        }else{
            renderAutoriza = false; 
        }
        
        if(usuario.getHuseautcasa()!= null && usuario.getHuseautcasa().equals("S")){
            renderCasa = true; 
        }else{
            renderCasa = false; 
        }

        if(usuario.getHuseautcelular()!= null && usuario.getHuseautcelular().equals("S")){
            renderCelular = true;   
        }else{
            renderCelular = false; 
        }

        if(usuario.getHuseautcorreoe()!= null && usuario.getHuseautcorreoe().equals("S")){
            renderCorreo = true; 
        }else{
            renderCorreo = false; 
        }

        if(usuario.getHuseautmensaj()!= null && usuario.getHuseautmensaj().equals("S")){
            renderMensajes = true; 
        }else{
            renderMensajes = false; 
        }
        if(usuario.getHuseautoficina()!= null && usuario.getHuseautoficina().equals("S")){
            renderOficina = true; 
        }else{
            renderOficina = false; 
        }
        
        if(codigoAgenda == null){
            codigoAgenda = null;
        }
        
        if(usuario != null && usuario.getHusetipoafilia()!= null && usuario.getHusetipoafilia().equals("X")){
            renderEPS= false;
        }
        
        
        boolean esValido = false;
        Long consultaAux = null;
        Chconsulta chconsulta = null;
        if (consulta != null && consulta.getCconnumero() != null) {

            try {
                consultaAux = 
                        this.serviceLocator.getClinicoService().getExisteConsulta(consulta.getCconnumero());
                        
                chconsulta =  
                        this.serviceLocator.getClinicoService().getConsultaActual(consulta.getCconnumero().longValue());       

            } catch (ModelException e) {
               return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }
        if (consultaAux != null) {
            esValido = true;
            if (chconsulta != null) {
                usuario.setHcocreaconinf(chconsulta.getHcocreaconinf());
                usuario.setHcoccuacondil(chconsulta.getHcoccuacondil());
                usuario.setHcocautusodat(chconsulta.getHcocautusodat());
            }
            
        } else {
            esValido = false;
        }
        
        if(!esValido()){
            if(usuario!= null){
                usuario.setHuscnomacompana(null);
                usuario.setHusctelacompana(null);
               /* usuario.setHuscnomresponsa(null);
                usuario.setHuscparresponsa(null);
                usuario.setHusctelresponsa(null);*/
            }
        }
        
        if (usuario != null) {
            if ("S".equals(usuario.getHcocreaconinf())) {
                renderRealizaConsentimiento = true;
            }
        }
        
        if(consulta != null && consulta.getCcocservic() != null ){
            renderConsentimiento = false;
            if(consulta.getCcocservic().getCsvcaplicons() != null && "S".equals(consulta.getCcocservic().getCsvcaplicons())){
                renderConsentimiento = true;
            }
        }
        
        try {
            lstConsentimientoInformado = 
                    this.serviceLocator.getClinicoService().getConsentimientoInformado();
        } catch (ModelException e) {
            e.printStackTrace();
        }
        if(consulta != null && consulta.getCconnumero() != null){
            try {
                listaChconinfxcon = 
                        this.serviceLocator.getClinicoService().getConsentimientoXConsulta(consulta.getCconnumero().longValue());       

            } catch (ModelException e) {
               return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        
            
        if (listaChconinfxcon != null && !listaChconinfxcon.isEmpty() && lstConsentimientoInformado != null && !lstConsentimientoInformado.isEmpty()) {
            if(lstConsentimientoAceptados == null){
                lstConsentimientoAceptados = new ArrayList();
            }
            lstConsentimientoAceptados.clear();
            for(Chconinfxcon consent :listaChconinfxcon){
                for(Chplanconsinfo plancon :lstConsentimientoInformado){
                        if(plancon.getHpcinconsec().equals(consent.getHcicnnucoin().getHpcinconsec())){
                            plancon.setModoconsulta(true);
                            lstConsentimientoAceptados.add(plancon);
                        }
                }
            }
                
        }
    }
        
        return null;

    }

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Long consultaAux = null;
        if (consulta != null && consulta.getCconnumero() != null) {

            try {
                consultaAux = 
                        this.serviceLocator.getClinicoService().getExisteConsulta(consulta.getCconnumero());

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (consultaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    /** Botones  */
    public String guardarUsuario() throws Exception {
        navigationRule = "";
        wexitoContacto = true;
        usuario.setHuscoperador(userName());
        usuario.setHusdultimacons(new Date());


        boolean wexito = true;
        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";

        if (usuario != null) {


            if (usuario.getHusetipoiden() == null || 
                usuario.getHusetipoiden().equals("")) {
                FacesUtils.addErrorMessage(url + "tipoIde", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusanumeiden() == null) {
                FacesUtils.addErrorMessage(url + "itNumeroIdentificacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHuscprimernomb() == null || 
                usuario.getHuscprimernomb().equals("")) {
                FacesUtils.addErrorMessage(url + "primerNombre", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscprimerapel() == null || 
                usuario.getHuscprimerapel().equals("")) {
                FacesUtils.addErrorMessage(url + "primerApellido", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusdfechanacim() == null) {
                FacesUtils.addErrorMessage(url + "fechaNacimiento", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusesexo() == null || 
                usuario.getHusesexo().equals("")) {
                FacesUtils.addErrorMessage(url + "radioSexo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuseestadcivil() == null || 
                usuario.getHuseestadcivil().equals("")) {
                FacesUtils.addErrorMessage(url + "radioEstadoCivil", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscdireccion() == null || 
                usuario.getHuscdireccion().equals("")) {
                FacesUtils.addErrorMessage(url + "Direccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscbarrio() == null || 
                usuario.getHuscbarrio().equals("")) {
                FacesUtils.addErrorMessage(url + "itBarrio", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            /*if (usuario.getHusctelefono() == null || 
                usuario.getHusctelefono().equals("")) {
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }*/

            if (usuario.getHusezonareside() == null || 
                usuario.getHusezonareside().equals("")) {
                FacesUtils.addErrorMessage(url + "radioZona", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusnciudad() == null) {
                FacesUtils.addErrorMessage(url + "menuCiudad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusetipoafilia() == null || 
                usuario.getHusetipoafilia().equals("")) {
                FacesUtils.addErrorMessage(url + "menuAfiliacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
             if(renderEPS){
                if (usuario.getHuscentidadadm() == null || 
                    usuario.getHuscentidadadm().equals("")) {
                FacesUtils.addErrorMessage(url + "menuEps", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
    }


            if (usuario.getHusnocupacion() == null) {
                FacesUtils.addErrorMessage(url + "menuOcupacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (usuario.getHuscoriesexu() == null && renderOrientacionSexual) {
                FacesUtils.addErrorMessage(url + "radioOrienSex", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }     
            
            if (usuario.getHuscvivesolo() == null && renderViveSola) {
                FacesUtils.addErrorMessage(url + "mnuViveSolo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

        }


        if (this.getConsulta() != null && 
            this.getConsulta().getCcocservic() != null)
            tipoHistoria = this.getConsulta().getCcocservic().getCsvntiphis();


        if (renderContacto) {
            if (!renderAutoriza) {
                usuario.setHuseautcasa("N");
                usuario.setHuseautcelular("N");
                usuario.setHuseautcorreoe("N");
                usuario.setHuseautmensaj("N");
                usuario.setHuseautoficina("N");
            } else {

                if (!renderCasa && !renderCelular && !renderCorreo && 
                    !renderMensajes && !renderOficina) {
                    wexitoContacto = false;
                }

                if (renderCasa) {
                    usuario.setHuseautcasa("S");
                } else {
                    usuario.setHuseautcasa("N");
                }
                if (renderCelular) {
                    usuario.setHuseautcelular("S");
                } else {
                    usuario.setHuseautcelular("N");
                }

                if (renderCorreo) {
                    usuario.setHuseautcorreoe("S");
                } else {
                    usuario.setHuseautcorreoe("N");
                }
                if (renderMensajes) {
                    usuario.setHuseautmensaj("S");
                } else {
                    usuario.setHuseautmensaj("N");
                }
                if (renderOficina) {
                    usuario.setHuseautoficina("S");
                } else {
                    usuario.setHuseautoficina("N");
                }
            }


        }
        
        if(!renderOrientacionSexual){
            usuario.setHuscoriesexu(null);
        }

        if (wexitoContacto) {
            if (wexito) {
                try {
                    /*String resultadoCreaUsuario = null;
                    String resultadoModUsuario = null;
                    String codigoSAP = null;
                    usuarioWsSap= new UsuarioWsSap();

                    usuarioTemp = 
                            this.getServiceLocator().getClinicoService().getUsuario(usuario.getHuslnumero());
    
                    */
                    if (tipoHistoria.intValue() != HISTORIA_ADMINISTRAR_MEDICAMENTO 
                        && tipoHistoria.intValue() != HISTORIA_VACUNACION) {
                        this.serviceLocator.getClinicoService().saveUsuario(usuario, 
                                                                        consulta, 
                                                                        userName(), 
                                                                        codigoAgenda);
                    /*
                    Cpmunidane auxMuni = null;
                    auxMuni = 
                            this.serviceLocator.getClinicoService().getMunicipiosSap(usuario.getHusndepartamen(), 
                                                                                     usuario.getHusnciudad());

                    if (usuario.getHusccodsap() != null) {
                        Boolean diferente = false;
                        if (compararString(usuario.getHuscprimernomb(),usuarioTemp.getHuscprimernomb()) || 
                            compararString(usuario.getHuscsegundnomb(),usuarioTemp.getHuscsegundnomb()) || 
                            compararString(usuario.getHuscprimerapel(),usuarioTemp.getHuscprimerapel()) || 
                            compararString(usuario.getHuscsegundapel(),usuarioTemp.getHuscsegundapel()) || 
                            compararLong(usuario.getHusanumeiden(), usuarioTemp.getHusanumeiden()) || 
                            compararString(usuario.getHusesexo(),usuarioTemp.getHusesexo()) || 
                            compararString(usuario.getHuscdireccion(),usuarioTemp.getHuscdireccion()) || 
                            compararLong(usuario.getHusndepartamen().longValue(),usuarioTemp.getHusndepartamen().longValue()) || 
                            compararLong(usuario.getHusnciudad().longValue(), usuarioTemp.getHusnciudad().longValue()) || 
                            compararString(usuario.getHusctelefono(),usuarioTemp.getHusctelefono()) || 
                            compararString(usuario.getHusccelular(),usuarioTemp.getHusccelular()) || 
                            compararString(usuario.getHusetipcliente(),usuarioTemp.getHusetipcliente()) || 
                            compararString(usuario.getHusetipoiden(),usuarioTemp.getHusetipoiden()) || 
                            compararString(usuario.getHuscnomacompana(),usuarioTemp.getHuscnomacompana()) || 
                            compararDate(usuario.getHusdfechanacim(),usuarioTemp.getHusdfechanacim())) {
                            diferente = true;
                        }
                        if (diferente) {
                            resultadoModUsuario = 
                                    usuarioWsSap.modificarUsuarioSap(usuario, 
                                                                     usuarioTemp.getHusanumeiden().longValue(), 
                                                                     auxMuni);
                        }
                    } else {
                        resultadoCreaUsuario = 
                                usuarioWsSap.saveUsuarioSap(usuario, auxMuni);
                        String[] parts = resultadoCreaUsuario.split("\\|");
                        String respuesta = parts[0];
                        String[] contieneCodigoArray = respuesta.split(" ");
                        String validacion = contieneCodigoArray[0];
                        if ("Nuevo".equals(validacion)) {
                            codigoSAP = contieneCodigoArray[2];
                        } else {
                            codigoSAP = contieneCodigoArray[3];
                            if (usuarioTemp.getHuslnumero() == null) {
                                try {
                                    usuarioTemp = 
                                            this.getServiceLocator().getClinicoService().getUsuario(usuario.getHuslnumero());

                                } catch (ModelException e) {
                                    e.printStackTrace();
                                }
                            }
                            resultadoModUsuario = 
                                    usuarioWsSap.modificarUsuarioSap(usuario, 
                                                                     usuarioTemp.getHusanumeiden().longValue(), 
                                                                     auxMuni);
                        }
                    }
                    if (codigoSAP != null) {
                        usuario.setHusccodsap(codigoSAP);
                        this.serviceLocator.getClinicoService().updateUsuario(usuario);
                    }
                    */
                    // Se recarga el menu 
                    
                        if (lstConsentimientoAceptados != null && !lstConsentimientoAceptados.isEmpty()) {
                            if(listaChconinfxcon  == null ){
                                listaChconinfxcon = new ArrayList();
                            }
                                for(Chplanconsinfo plancon :lstConsentimientoAceptados){
                                    Chconinfxcon coninfxcon = new Chconinfxcon();
                                        if(!plancon.isModoconsulta()){
                                            coninfxcon.setHciccusuaregi(userName());
                                            coninfxcon.setHcicdfechregi( new Date());
                                            coninfxcon.setHcicnnucoin(plancon);
                                            coninfxcon.setHcicnconsulta(consulta.getCconnumero().longValue());
                                            listaChconinfxcon.add(coninfxcon);
                                    }
                            }
                             
                        }
                        if(listaChconinfxcon != null && !listaChconinfxcon.isEmpty()){
                            this.serviceLocator.getClinicoService().saveConsentimientoInformadoXconsulta(listaChconinfxcon);
                        }
                    } else {
                        if(lstConsultas !=null && !lstConsultas.isEmpty()){
// NLS Asigna la primera consulta a consultas 07/12/2021
                            consulta = lstConsultas.get(0);
                            for (int i = 0;i<lstConsultas.size();i++){
                                this.serviceLocator.getClinicoService().saveUsuario(usuario, 
                                                                            lstConsultas.get(i), 
                                                                            userName(), 
                                                                            null);

                                if (lstConsentimientoAceptados != null && !lstConsentimientoAceptados.isEmpty()) {
                                    if(listaChconinfxcon  == null ){
                                        listaChconinfxcon = new ArrayList();
                                    }
                                        for(Chplanconsinfo plancon :lstConsentimientoAceptados){
                                            Chconinfxcon coninfxcon = new Chconinfxcon();
                                                if(!plancon.isModoconsulta()){
                                                    coninfxcon.setHciccusuaregi(userName());
                                                    coninfxcon.setHcicdfechregi( new Date());
                                                    coninfxcon.setHcicnnucoin(plancon);
                                                    coninfxcon.setHcicnconsulta(consulta.getCconnumero().longValue());
                                                    listaChconinfxcon.add(coninfxcon);
                                            }
                                    }
                                     
                                }
                                if(listaChconinfxcon != null && !listaChconinfxcon.isEmpty()){
                                    this.serviceLocator.getClinicoService().saveConsentimientoInformadoXconsulta(listaChconinfxcon);
                                }
                            }
                        }
                    }
                    navigationRule = nextAction;
                    FacesUtils.resetManagedBean(menuBean);
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);


                } catch (ModelException e) {
                    //FacesUtils.addErrorMessage(null, e.getMessage(), 
                                               //IMsg.MSG_NO_ADICION);
                    //e.printStackTrace();
                    navigationRule = "";
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                    
                }
            } else {
                navigationRule = BeanNavegacion.RUTA_ACTUAL;
            }

        } else {
            navigationRule = "";
            FacesUtils.addErrorMessage(MSG_SIN_AUTORIZACION_CONTACTO);
        }
        // Se establece la siguiente accion de navegacion
        return navigationRule;
    }
    
    public String guardarUsuarioPruebasRapidas() throws Exception {
        navigationRule = "";
        wexitoContacto = true;
        usuario.setHuscoperador(userName());
        usuario.setHusdultimacons(new Date());


        boolean wexito = true;
        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";

        if (usuario != null) {


            if (usuario.getHusetipoiden() == null || 
                usuario.getHusetipoiden().equals("")) {
                FacesUtils.addErrorMessage(url + "tipoIde", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusanumeiden() == null) {
                FacesUtils.addErrorMessage(url + "itNumeroIdentificacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHuscprimernomb() == null || 
                usuario.getHuscprimernomb().equals("")) {
                FacesUtils.addErrorMessage(url + "primerNombre", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if(renderEPS){
               if (usuario.getHuscentidadadm() == null || 
                   usuario.getHuscentidadadm().equals("")) {
               FacesUtils.addErrorMessage(url + "menuEps", 
                                          MSG_CAMPO_OBLIGATORIO);
               wexito = false;
            }
            }


            if (usuario.getHuscprimerapel() == null || 
                usuario.getHuscprimerapel().equals("")) {
                FacesUtils.addErrorMessage(url + "primerApellido", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusdfechanacim() == null) {
                FacesUtils.addErrorMessage(url + "fechaNacimiento", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusesexo() == null || 
                usuario.getHusesexo().equals("")) {
                FacesUtils.addErrorMessage(url + "radioSexo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuseestadcivil() == null || 
                usuario.getHuseestadcivil().equals("")) {
                FacesUtils.addErrorMessage(url + "radioEstadoCivil", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscdireccion() == null || 
                usuario.getHuscdireccion().equals("")) {
                FacesUtils.addErrorMessage(url + "Direccion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHuscbarrio() == null || 
                usuario.getHuscbarrio().equals("")) {
                FacesUtils.addErrorMessage(url + "itBarrio", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            /*if (usuario.getHusctelefono() == null || 
                usuario.getHusctelefono().equals("")) {
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }*/

            if (usuario.getHusezonareside() == null || 
                usuario.getHusezonareside().equals("")) {
                FacesUtils.addErrorMessage(url + "radioZona", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusnciudad() == null) {
                FacesUtils.addErrorMessage(url + "menuCiudad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusetipoafilia() == null || 
                usuario.getHusetipoafilia().equals("")) {
                FacesUtils.addErrorMessage(url + "menuAfiliacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

            if (usuario.getHusnocupacion() == null) {
                FacesUtils.addErrorMessage(url + "menuOcupacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }
            
            if (usuario.getHuscoriesexu() == null && renderOrientacionSexual) {
                FacesUtils.addErrorMessage(url + "radioOrienSex", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }     
            
            if (usuario.getHuscvivesolo() == null && renderViveSola) {
                FacesUtils.addErrorMessage(url + "mnuViveSolo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

        }


        if (this.getConsulta() != null && 
            this.getConsulta().getCcocservic() != null)
            tipoHistoria = this.getConsulta().getCcocservic().getCsvntiphis();


        if (renderContacto) {
            if (!renderAutoriza) {
                usuario.setHuseautcasa("N");
                usuario.setHuseautcelular("N");
                usuario.setHuseautcorreoe("N");
                usuario.setHuseautmensaj("N");
                usuario.setHuseautoficina("N");
            } else {

                if (!renderCasa && !renderCelular && !renderCorreo && 
                    !renderMensajes && !renderOficina) {
                    wexitoContacto = false;
                }

                if (renderCasa) {
                    usuario.setHuseautcasa("S");
                } else {
                    usuario.setHuseautcasa("N");
                }
                if (renderCelular) {
                    usuario.setHuseautcelular("S");
                } else {
                    usuario.setHuseautcelular("N");
                }

                if (renderCorreo) {
                    usuario.setHuseautcorreoe("S");
                } else {
                    usuario.setHuseautcorreoe("N");
                }
                if (renderMensajes) {
                    usuario.setHuseautmensaj("S");
                } else {
                    usuario.setHuseautmensaj("N");
                }
                if (renderOficina) {
                    usuario.setHuseautoficina("S");
                } else {
                    usuario.setHuseautoficina("N");
                }
            }


        }
        
        if(!renderOrientacionSexual){
            usuario.setHuscoriesexu(null);
        }

        if (wexitoContacto) {
            if (wexito) {
                try {
                    /*String resultadoCreaUsuario = null;
                    String resultadoModUsuario = null;
                    String codigoSAP = null;
                    usuarioWsSap= new UsuarioWsSap();

                    usuarioTemp = 
                            this.getServiceLocator().getClinicoService().getUsuario(usuario.getHuslnumero());
    
                    */
                    
                    if(lstConsultas !=null && !lstConsultas.isEmpty()){
                        consulta = lstConsultas.get(0);
                        for (int i = 0;i<lstConsultas.size();i++){
                            this.serviceLocator.getClinicoService().saveUsuario(usuario, 
                                                                        lstConsultas.get(i), 
                                                                        userName(), 
                                                                        null);
                            
                           
                        }
                        if (lstConsentimientoAceptados != null && !lstConsentimientoAceptados.isEmpty()) {
                            if(listaChconinfxcon  == null ){
                                listaChconinfxcon = new ArrayList();
                            }
                                for(Chplanconsinfo plancon :lstConsentimientoAceptados){
                                    Chconinfxcon coninfxcon = new Chconinfxcon();
                                        if(!plancon.isModoconsulta()){
                                            coninfxcon.setHciccusuaregi(userName());
                                            coninfxcon.setHcicdfechregi( new Date());
                                            coninfxcon.setHcicnnucoin(plancon);
                                            coninfxcon.setHcicnconsulta(consulta.getCconnumero().longValue());
                                            listaChconinfxcon.add(coninfxcon);
                                    }
                            }
                             
                        }
                        if(listaChconinfxcon != null && !listaChconinfxcon.isEmpty()){
                            this.serviceLocator.getClinicoService().saveConsentimientoInformadoXconsulta(listaChconinfxcon);
                        }
                    }
                    
                    /*
                    Cpmunidane auxMuni = null;
                    auxMuni = 
                            this.serviceLocator.getClinicoService().getMunicipiosSap(usuario.getHusndepartamen(), 
                                                                                     usuario.getHusnciudad());

                    if (usuario.getHusccodsap() != null) {
                        Boolean diferente = false;
                        if (compararString(usuario.getHuscprimernomb(),usuarioTemp.getHuscprimernomb()) || 
                            compararString(usuario.getHuscsegundnomb(),usuarioTemp.getHuscsegundnomb()) || 
                            compararString(usuario.getHuscprimerapel(),usuarioTemp.getHuscprimerapel()) || 
                            compararString(usuario.getHuscsegundapel(),usuarioTemp.getHuscsegundapel()) || 
                            compararLong(usuario.getHusanumeiden(), usuarioTemp.getHusanumeiden()) || 
                            compararString(usuario.getHusesexo(),usuarioTemp.getHusesexo()) || 
                            compararString(usuario.getHuscdireccion(),usuarioTemp.getHuscdireccion()) || 
                            compararLong(usuario.getHusndepartamen().longValue(),usuarioTemp.getHusndepartamen().longValue()) || 
                            compararLong(usuario.getHusnciudad().longValue(), usuarioTemp.getHusnciudad().longValue()) || 
                            compararString(usuario.getHusctelefono(),usuarioTemp.getHusctelefono()) || 
                            compararString(usuario.getHusccelular(),usuarioTemp.getHusccelular()) || 
                            compararString(usuario.getHusetipcliente(),usuarioTemp.getHusetipcliente()) || 
                            compararString(usuario.getHusetipoiden(),usuarioTemp.getHusetipoiden()) || 
                            compararString(usuario.getHuscnomacompana(),usuarioTemp.getHuscnomacompana()) || 
                            compararDate(usuario.getHusdfechanacim(),usuarioTemp.getHusdfechanacim())) {
                            diferente = true;
                        }
                        if (diferente) {
                            resultadoModUsuario = 
                                    usuarioWsSap.modificarUsuarioSap(usuario, 
                                                                     usuarioTemp.getHusanumeiden().longValue(), 
                                                                     auxMuni);
                        }
                    } else {
                        resultadoCreaUsuario = 
                                usuarioWsSap.saveUsuarioSap(usuario, auxMuni);
                        String[] parts = resultadoCreaUsuario.split("\\|");
                        String respuesta = parts[0];
                        String[] contieneCodigoArray = respuesta.split(" ");
                        String validacion = contieneCodigoArray[0];
                        if ("Nuevo".equals(validacion)) {
                            codigoSAP = contieneCodigoArray[2];
                        } else {
                            codigoSAP = contieneCodigoArray[3];
                            if (usuarioTemp.getHuslnumero() == null) {
                                try {
                                    usuarioTemp = 
                                            this.getServiceLocator().getClinicoService().getUsuario(usuario.getHuslnumero());

                                } catch (ModelException e) {
                                    e.printStackTrace();
                                }
                            }
                            resultadoModUsuario = 
                                    usuarioWsSap.modificarUsuarioSap(usuario, 
                                                                     usuarioTemp.getHusanumeiden().longValue(), 
                                                                     auxMuni);
                        }
                    }
                    if (codigoSAP != null) {
                        usuario.setHusccodsap(codigoSAP);
                        this.serviceLocator.getClinicoService().updateUsuario(usuario);
                    }
                    */
                    // Se recarga el menu 
                  
                    navigationRule = nextAction;
                    FacesUtils.resetManagedBean(menuBean);
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);


                } catch (ModelException e) {
                   
                    navigationRule = "";
                    return capturaError(e,IConstantes.ERROR_GUARDADO);
                }
            } else {
                navigationRule = BeanNavegacion.RUTA_ACTUAL;
            }

        } else {
            navigationRule = "";
            FacesUtils.addErrorMessage(MSG_SIN_AUTORIZACION_CONTACTO);
        }
        // Se establece la siguiente accion de navegacion
        return navigationRule;
    }

    public String changeCiudad() {
        if (usuario.getHusndepartamen() != null && !usuario.getHusndepartamen().equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            usuario.setHusnciudad(null);
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }
        } else {
            listMunicipios = new ArrayList<SelectItem>();
            listMunicipios.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
        }
        return null;
    }

    public Boolean compararString(String dato1, String dato2) {

        if (dato1 != null && dato2 != null) {
            if (!dato1.equals(dato2)) {
                return true;
            } else {
                return false;
            }
        } else if ((dato1 == null && dato2 != null) || 
                   (dato1 != null && dato2 == null)) {
            return true;
        } else {
            return false;
        }
    }

    public void changeEdad() {
        if (usuario != null && usuario.getHusdfechanacim() != null) {
            setEdad(calcularEdad(usuario.getHusdfechanacim(), new Date()));
        }
    }

    public Boolean compararDate(Date date1, Date date2) {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String fecha1 = sd.format(date1);
        String fecha2 = sd.format(date2);
        if (fecha1 != null && fecha2 != null) {
            if (!fecha1.equals(fecha2)) {
                return true;
            } else {
                return false;
            }
        } else if ((fecha1 == null && fecha2 != null) || 
                   (fecha1 != null && fecha2 == null)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean compararLong(Long num1, Long num2) {

        if (num1 != null && num2 != null) {
            int compareValue = num1.compareTo(num2);
            if (compareValue == 0) {
                return false;
            } else {
                return true;
            }
        } else if ((num1 == null && num2 != null) || 
                   (num1 != null && num2 == null)) {
            return true;
        } else {
            return false;
        }
    }


    public void changeAutorizo(){
        if (usuario.getHuseautorcont() != null && 
            usuario.getHuseautorcont() .equals("S")) {
            renderAutoriza = true;
        } else {
            renderAutoriza = false;
        }
        }
        
        
    public String changeSeleccionOcupacion() {
        seleccionOcupacion = null;

        if (usuario.getHusnocupacion() != null) {
            if (usuario.getHusnocupacion() != null) {
                try {
                    ocupacioservix = 
                            (Cpocupacio)this.serviceLocator.getClinicoService().getOcupacionPorCodigo(usuario.getHusnocupacion());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
                if (ocupacioservix != null && 
                    ocupacioservix.getCocncodigo() != null) {

                    if (!ocupacioservix.getCocncodigo().equals(usuario.getHusnocupacion())) {
                        FacesUtils.addErrorMessage(seleccionOcupacion = 
                                                   "Ocupaci�n: " + 
                                                   usuario.getHusnocupacion() + 
                                                   " no Coincide, intente nuevamente");
                    } else {
                        seleccionOcupacion = ocupacioservix.getCoccdescri();
                    }

                } else {
                    FacesUtils.addErrorMessage(seleccionOcupacion = 
                                               "Ocupaci�n: " + 
                                               usuario.getHusnocupacion() + 
                                               " no existe, intente nuevamente");
                }

            } else {
                FacesUtils.addErrorMessage(seleccionOcupacion = 
                                           "Por Favor escriba una Ocupaci�n");
            }

        }
        return null;
    }


    public void renderOcupacion() {
        FacesUtils.resetManagedBean("buscadorOcupacionBean");
        renderBuscadorOcupacion = true;
        selectedIndex = ACTIVAR_BUSCADOR_OCUPACION;

        BuscadorOcupacionBean buscador = 
            (BuscadorOcupacionBean)FacesUtils.getManagedBean("buscadorOcupacionBean");
        buscador.setBeanAnterior(BEAN_USUARIO_DATOS_USUARIO);

    }
    
    public void consultarConsentimientos() {
        FacesUtils.resetManagedBean("buscadorConsentimientoBean");
        BuscadorConsentimientoBean consentimientos;
        consentimientos = 
                (BuscadorConsentimientoBean)FacesUtils.getManagedBean("buscadorConsentimientoBean");
        if (consentimientos != null) {
            consentimientos.init();
        }
        selectedIndex = ACTIVAR_BUSCADOR_CONSENTIMIENTO;
        mostrarConsentimiento = true;

    }
    
    
    public void aceptarConsentimientos() {
        BuscadorConsentimientoBean buscadorConsentimientos;
        buscadorConsentimientos = 
                (BuscadorConsentimientoBean)FacesUtils.getManagedBean("buscadorConsentimientoBean");
        if (buscadorConsentimientos != null) {
            if (lstConsentimientoAceptados != null && 
                !lstConsentimientoAceptados.isEmpty()) {
                lstConsentimientoAceptados.addAll(buscadorConsentimientos.getLstConsentimientoSelec());
            } else {
                lstConsentimientoAceptados = buscadorConsentimientos.getLstConsentimientoSelec();
            }
        }
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        mostrarConsentimiento = false;

        FacesUtils.resetManagedBean("buscadorConsentimientoBean");
    }
    
    public void eliminarConsentimiento() {
        Chplanconsinfo consentimientoSelec;
        consentimientoSelec = (Chplanconsinfo)dtConsentimiento.getRowData();
        lstConsentimientoAceptados.remove(consentimientoSelec);

    }
    public String agregarConsentimiento() {       
        Chplanconsinfo aux = null;
                try {
                    aux = this.serviceLocator.getHistoriaService().getConsentimientoInformadoActivo(codigoConsentimiento);
                    if(aux!=null){
                        if(lstConsentimientoAceptados==null){
                            lstConsentimientoAceptados = new ArrayList<Chplanconsinfo>();
                        }
                        lstConsentimientoAceptados.add(aux);
                        codigoConsentimiento ="";
                    }
                    else{
                        FacesUtils.addErrorMessage("el consentimiento con c�digo " +codigoConsentimiento+" no existe"); 
                    }
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);

        }
        return null;
    }

    //ACCESSORS

    /** Definimos los Gets y Set de la aplicacion */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setExisteusuario(boolean param) {
        this.existeusuario = param;
    }

    public boolean isExisteusuario() {
        return existeusuario;
    }


    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(), 
                                                              listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }


    public void setListDepartamentos(List<SelectItem> param) {
        this.listDepartamentos = param;
    }

    public List<SelectItem> getListDepartamentos() {
        if (listDepartamentos == null || listDepartamentos.isEmpty()) {
            listDepartamentos = new ArrayList<SelectItem>();
            ArrayList<Cpdepadane> listDepartamentosAux = null;
            try {
                listDepartamentosAux = 
                        (ArrayList<Cpdepadane>)this.serviceLocator.getClinicoService().getDepartamentos();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listDepartamentosAux.isEmpty()) {

                Iterator it = listDepartamentosAux.iterator();
                int i = 0;
                listDepartamentos.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo(), 
                                                         listDepartamentosAux.get(i).getCddcdescri()));
                    i++;
                }
            }
        }
        return listDepartamentos;
    }

    public void setListMunicipios(List<SelectItem> param) {
        this.listMunicipios = param;
    }

    public List<SelectItem> getListMunicipios() {

        return listMunicipios;
    }

    public void setListOcupaciones(List<SelectItem> param) {
        this.listOcupaciones = param;
    }

    public List<SelectItem> getListOcupaciones() {
        if (listOcupaciones == null || listOcupaciones.isEmpty()) {
            listOcupaciones = new ArrayList<SelectItem>();
            ArrayList<Cpocupacio> listOcpuacionesAux = null;
            try {
                listOcpuacionesAux = 
                        (ArrayList<Cpocupacio>)this.serviceLocator.getClinicoService().getOcupaciones();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listOcpuacionesAux.isEmpty()) {
                listOcupaciones.add(new SelectItem("", 
                                                   "Seleccione una opcion..."));
                Iterator it = listOcpuacionesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listOcupaciones.add(new SelectItem(listOcpuacionesAux.get(i).getCocncodigo(), 
                                                       listOcpuacionesAux.get(i).getCoccdescri()));

                    i++;
                }
            }
        }
        return listOcupaciones;
    }

    public void setListTipoAfiliacion(List<SelectItem> param) {
        this.listTipoAfiliacion = param;
    }

    public List<SelectItem> getListTipoAfiliacion() {
        if (listTipoAfiliacion == null || listTipoAfiliacion.isEmpty()) {
            listTipoAfiliacion = new ArrayList<SelectItem>();
            ArrayList<Chtipoafilia> listTipoAfiliacionAux = null;
            try {
                listTipoAfiliacionAux = 
                        (ArrayList<Chtipoafilia>)this.getServiceLocator().getClinicoService().getTipoafiliado();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoAfiliacionAux.isEmpty()) {

                listTipoAfiliacion.add(new SelectItem("", 
                                                      "Seleccione una opcion ..."));
                Iterator it = listTipoAfiliacionAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listTipoAfiliacion.add(new SelectItem((listTipoAfiliacionAux.get(i).getCtaecodigo().toString()), 
                                                          listTipoAfiliacionAux.get(i).getCtacdescripcio()));
                    i++;
                }
            }
        }
        return listTipoAfiliacion;
    }

    /**
     * @param param
     */
    public void setListSexos(List<SelectItem> param) {
        this.listSexos = param;
    }

    /**
     * @return La lista de los sexos que existen
     */
    public List<SelectItem> getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
            listSexos = new ArrayList<SelectItem>();
            ArrayList<Chsexo> listSexoAux = null;
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexoNew();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;
                }
            }
        }
        return listSexos;
    }


    public void setListzona(List<SelectItem> listzona) {
        this.listzona = listzona;
    }

    public List<SelectItem> getListzona() {
        if (listzona == null || listzona.isEmpty()) {
            listzona = new ArrayList<SelectItem>();
            ArrayList<Chzona> zonaList;
            zonaList = null;


            try {
                zonaList = 
                        (ArrayList<Chzona>)serviceLocator.getClinicoService().getZona();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            Iterator it = zonaList.iterator();
            int i = 0;
            listzona.add(new SelectItem("", "Seleccione una opcion ..."));
            while (it.hasNext()) {
                it.next();
                listzona.add(new SelectItem(zonaList.get(i).getId(), 
                                            zonaList.get(i).getDescripcion()));
                i++;
            }

        }
        return listzona;
    }

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil == null || listEstadoCivil.isEmpty()) {
            listEstadoCivil = new ArrayList<SelectItem>();
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }

  

    public void setListEntidadAdm(List<SelectItem> listEntidadAdm) {
        this.listEntidadAdm = listEntidadAdm;
    }

    public List<SelectItem> getListEntidadAdm() {
        if (listEntidadAdm == null || listEntidadAdm.isEmpty()) {
            listEntidadAdm = new ArrayList<SelectItem>();
            ArrayList<Cpentidadadm> listEntidadAdmAux = null;
            try {
                listEntidadAdmAux = 
                        (ArrayList<Cpentidadadm>)this.serviceLocator.getClinicoService().getEntidadAdm();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEntidadAdmAux.isEmpty()) {

                Iterator it = listEntidadAdmAux.iterator();
                int i = 0;
                listEntidadAdm.add(new SelectItem("", 
                                                  "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listEntidadAdm.add(new SelectItem(listEntidadAdmAux.get(i).getCeaccodigo(), 
                                                      listEntidadAdmAux.get(i).getCeacnombre()));
                    i++;
                }
            }
        }
        return listEntidadAdm;
    }

  
    public String setCiudad() {
        if (usuario.getHusndepartamen()!=null && !usuario.getHusndepartamen().equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {
                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }
        }
        return null;
    }


    /**
     * @param valueChangeEvent
     */
    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        usuario.setHusndepartamen((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHuseautorcont(ValueChangeEvent valueChangeEvent) {
        usuario.setHuseautorcont((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {
        return edad;
    }


    /**
     * @param servicio
     */
    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return
     */
    public Cpservicio getServicio() {
        return servicio;
    }



    /**
     * @param valueChangeEvent
     */
    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        usuario.setHusdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
     * @param renderOficina
     */
    public void setRenderOficina(boolean renderOficina) {
        this.renderOficina = renderOficina;
    }

    /**
     * @return
     */
    public boolean isRenderOficina() {
        return renderOficina;
    }

    /**
     * @param renderCasa
     */
    public void setRenderCasa(boolean renderCasa) {
        this.renderCasa = renderCasa;
    }

    /**
     * @return
     */
    public boolean isRenderCasa() {
        return renderCasa;
    }

    /**
     * @param renderCelular
     */
    public void setRenderCelular(boolean renderCelular) {
        this.renderCelular = renderCelular;
    }

    /**
     * @return
     */
    public boolean isRenderCelular() {
        return renderCelular;
    }

    /**
     * @param renderMensajes
     */
    public void setRenderMensajes(boolean renderMensajes) {
        this.renderMensajes = renderMensajes;
    }

    /**
     * @return
     */
    public boolean isRenderMensajes() {
        return renderMensajes;
    }

    /**
     * @param renderCorreo
     */
    public void setRenderCorreo(boolean renderCorreo) {
        this.renderCorreo = renderCorreo;
    }

    /**
     * @return
     */
    public boolean isRenderCorreo() {
        return renderCorreo;
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
     * @param renderAutoriza
     */
    public void setRenderAutoriza(boolean renderAutoriza) {
        this.renderAutoriza = renderAutoriza;
    }

    /**
     * @return
     */
    public boolean isRenderAutoriza() {
        return renderAutoriza;
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderCasa(ValueChangeEvent valueChangeEvent) {
        setRenderCasa((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderCelular(ValueChangeEvent valueChangeEvent) {
        setRenderCelular((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderOficina(ValueChangeEvent valueChangeEvent) {
        setRenderOficina((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setRenderCorreo(ValueChangeEvent valueChangeEvent) {
        setRenderCorreo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }


    public void setCodigoAgenda(Long codigoAgenda) {
        this.codigoAgenda = codigoAgenda;
    }

    public Long getCodigoAgenda() {
        return codigoAgenda;
    }

    public void setUsuarioTemp(Chusuario usuarioTemp) {
        this.usuarioTemp = usuarioTemp;
    }

    public Chusuario getUsuarioTemp() {
        return usuarioTemp;
    }

    public void setUsuarioWsSap(UsuarioWsSap usuarioWsSap) {
        this.usuarioWsSap = usuarioWsSap;
    }

    public UsuarioWsSap getUsuarioWsSap() {
        return usuarioWsSap;
    }

    public void setLstHistoricoAntecedente(List lstHistoricoAntecedente) {
        this.lstHistoricoAntecedente = lstHistoricoAntecedente;
    }

    public List getLstHistoricoAntecedente() {
        return lstHistoricoAntecedente;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setOcupacion(ValueChangeEvent valueChangeEvent) {
        usuario.setHusnocupacion((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setItOcupacion(UIInput itOcupacion) {
        this.itOcupacion = itOcupacion;
    }

    public UIInput getItOcupacion() {
        return itOcupacion;
    }

    public void setSeleccionOcupacion(String seleccionOcupacion) {
        this.seleccionOcupacion = seleccionOcupacion;
    }

    public String getSeleccionOcupacion() {
        return seleccionOcupacion;
    }

    public void setRenderBuscadorOcupacion(boolean renderBuscadorOcupacion) {
        this.renderBuscadorOcupacion = renderBuscadorOcupacion;
    }

    public boolean isRenderBuscadorOcupacion() {
        return renderBuscadorOcupacion;
    }

    public void setOcupacioservix(Cpocupacio ocupacioservix) {
        this.ocupacioservix = ocupacioservix;
    }

    public Cpocupacio getOcupacioservix() {
        return ocupacioservix;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setDeshabilitarOcupacion(boolean deshabilitarOcupacion) {
        this.deshabilitarOcupacion = deshabilitarOcupacion;
    }

    public boolean isDeshabilitarOcupacion() {
        return deshabilitarOcupacion;
    }
    
    
    public void aceptarOcupacion() {

        BuscadorOcupacionBean ocupacionAux = 
            (BuscadorOcupacionBean)FacesUtils.getManagedBean("buscadorOcupacionBean");


        if (ocupacionAux != null && 
            ocupacionAux.getOcupacionSelect() != null) {
            itOcupacion.setValue(ocupacionAux.getOcupacionSelect().getCocncodigo());
            seleccionOcupacion = 
                    ocupacionAux.getOcupacionSelect().getCoccdescri();


            usuario.setHusnocupacion(ocupacionAux.getOcupacionSelect().getCocncodigo());
            deshabilitarOcupacion = true;

        }
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        renderBuscadorOcupacion = false;

        FacesUtils.resetManagedBean("buscadorOcupacionBean");
    }


     
     public List<SelectItem> getListIdentidadGenero() {
         if (listIdentidadGenero.size() == 0) {
             ArrayList<Cpparametr> listIdentidadGeneroAux = null;
             try {
                 listIdentidadGeneroAux = 
                         (ArrayList<Cpparametr>)this.serviceLocator.getClinicoService().getListaDescripcionesParametro("identidadgen");
             } catch (ModelException e) {
                 e.printStackTrace();
             }

             if (!listIdentidadGeneroAux.isEmpty()) {

                 Iterator it = listIdentidadGeneroAux.iterator();
                 int i = 0;
                 listIdentidadGenero.add(new SelectItem("", 
                                                           "Seleccione una opci�n ..."));
                 while (it.hasNext()) {
                     it.next();
                     listIdentidadGenero.add(new SelectItem(listIdentidadGeneroAux.get(i).getCpcvalor(), 
                                                               listIdentidadGeneroAux.get(i).getCpcdescrip()));
                     i++;
                 }
             }
         }
         return listIdentidadGenero;
     }

     public void setListIdentidadGenero(List<SelectItem> listIdentidadGenero) {
         this.listIdentidadGenero = listIdentidadGenero;
     }


    public void setListOrientacionSexual(List<SelectItem> listOrientacionSexual) {
        this.listOrientacionSexual = listOrientacionSexual;
    }

    public List<SelectItem> getListOrientacionSexual() {
        if (listOrientacionSexual.size() == 0) {
            ArrayList<Cpparametr> listOrientacionSexualAux = null;
            try {
                listOrientacionSexualAux = 
                        (ArrayList<Cpparametr>)this.serviceLocator.getClinicoService().getListaDescripcionesParametro("orientsexual");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listOrientacionSexualAux.isEmpty()) {

                Iterator it = listOrientacionSexualAux.iterator();
                int i = 0;
                listOrientacionSexual.add(new SelectItem("", 
                                                          "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listOrientacionSexual.add(new SelectItem(listOrientacionSexualAux.get(i).getCpcvalor(), 
                                                              listOrientacionSexualAux.get(i).getCpcdescrip()));
                    i++;
                }
            }
        }
        return listOrientacionSexual;
    }

    public void setRenderOrientacionSexual(boolean renderOrientacionSexual) {
        this.renderOrientacionSexual = renderOrientacionSexual;
    }

    public boolean isRenderOrientacionSexual() {
        return renderOrientacionSexual;
    }
    
    public void changeFechaNacimiento(){
        if(usuario.getEdad() >= 11){
            renderOrientacionSexual=true;
        }else{
            renderOrientacionSexual=false;
        }
    }

    public void setRenderViveSola(boolean renderViveSola) {
        this.renderViveSola = renderViveSola;
    }

    public boolean isRenderViveSola() {
        return renderViveSola;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public String mensaje(){
    
    mensaje = "";
        Cfencuecovid cuestionarioAux = null;
        if(usuario != null && usuario.getHuslnumero() != null){
            
            if(usuario.getHuslnumero() != null)
                try
                {
                    cuestionarioAux = serviceLocator.getClinicoService().getEncuestaCovidXUsuario(usuario.getHuslnumero(), new Date());
                }
                catch(ModelException e)
                {
                    return capturaError(e,IConstantes.ERROR_COSNULTA);
                }
        }
    
        if(cuestionarioAux != null && cuestionarioAux.getCeccconducta()!= null){
            if(cuestionarioAux.getCeccconducta().equals("EPSD")){
                mensaje = ("La respuesta a la pregunta de conducta fue: Direccionar al paciente a urgencias o su EPS") + "\n";
                mensaje = mensaje + (" No olvide Activar C�digo Perla y tener en cuenta protocolos de Bioseguridad� se procede con el progreso en la atenci�n de la historia cl�nica");
            }
            
            if(cuestionarioAux.getCeccconducta().equals("AUAI")){
                mensaje =  ("La respuesta a la pregunta de conducta fue: Recomendar autoaislamiento preventivo en casa y reprogramar la atenci�n para cuando hayan pasado por lo menos 3 d�as despu�s de la desaparici�n de los s�ntomas.")  + "\n";
                mensaje = mensaje + ("No olvide Activar C�digo Perla y tener en cuenta protocolos de Bioseguridad� se procede con el progreso en la atenci�n de la historia cl�nica");
            }
        }
        return null;
    }
    
    public void setHcocreaconinf(ValueChangeEvent valueChangeEvent) {
        usuario.setHcocreaconinf((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeConsentimiento() {
        renderRealizaConsentimiento = false;
        if (usuario != null) {
            if ("S".equals(usuario.getHcocreaconinf())) {
                renderRealizaConsentimiento = true;
            }else{
                usuario.setHcoccuacondil(null);
                usuario.setHcocautusodat(null);
            }
        }
    }
    /**
     * @param valueChangeEvent
     */
    public void setConsentimiento(ValueChangeEvent valueChangeEvent) {
        codigoConsentimiento=((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderConsentimiento(boolean renderConsentimiento) {
        this.renderConsentimiento = renderConsentimiento;
    }

    public boolean isRenderConsentimiento() {
        return renderConsentimiento;
    }

    public void setRenderRealizaConsentimiento(boolean renderRealizaConsentimiento) {
        this.renderRealizaConsentimiento = renderRealizaConsentimiento;
    }

    public boolean isRenderRealizaConsentimiento() {
        return renderRealizaConsentimiento;
    }


    public void setLstConsultas(List<Cnconsclin> lstConsultas) {
        this.lstConsultas = lstConsultas;
    }

    public List<Cnconsclin> getLstConsultas() {
        return lstConsultas;
    }

    public void setRenderEPS(boolean renderEPS) {
        this.renderEPS = renderEPS;
    }

    public boolean isRenderEPS() {
        return renderEPS;
    }

    public void setMostrarConsentimiento(boolean mostrarConsentimiento) {
        this.mostrarConsentimiento = mostrarConsentimiento;
    }

    public boolean isMostrarConsentimiento() {
        return mostrarConsentimiento;
    }

    public void setLstConsentimientoAceptados(List<Chplanconsinfo> lstConsentimientoAceptados) {
        this.lstConsentimientoAceptados = lstConsentimientoAceptados;
    }

    public List<Chplanconsinfo> getLstConsentimientoAceptados() {
        return lstConsentimientoAceptados;
    }

    public void setDtConsentimiento(HtmlDataTable dtConsentimiento) {
        this.dtConsentimiento = dtConsentimiento;
    }

    public HtmlDataTable getDtConsentimiento() {
        return dtConsentimiento;
    }


    public void setListaChconinfxcon(List<Chconinfxcon> listaChconinfxcon) {
        this.listaChconinfxcon = listaChconinfxcon;
    }

    public List<Chconinfxcon> getListaChconinfxcon() {
        return listaChconinfxcon;
    }

    public void setEsFertilidad(boolean esFertilidad) {
        this.esFertilidad = esFertilidad;
    }

    public boolean isEsFertilidad() {
        return esFertilidad;
    }

    public void setIdentPareja(String identPareja) {
        this.identPareja = identPareja;
    }

    public String getIdentPareja() {
        return identPareja;
    }

    public void setNombrePareja(String nombrePareja) {
        this.nombrePareja = nombrePareja;
    }

    public String getNombrePareja() {
        return nombrePareja;
    }

    public void setCodigoConsentimiento(String codigoConsentimiento) {
        this.codigoConsentimiento = codigoConsentimiento;
    }

    public String getCodigoConsentimiento() {
        return codigoConsentimiento;
    }

    public void setItConsentimiento(UIInput itConsentimiento) {
        this.itConsentimiento = itConsentimiento;
    }

    public UIInput getItConsentimiento() {
        return itConsentimiento;
    }
    
    /**
     * @param param
     */
    public void setListPaises(List<SelectItem> param) {
        this.listPaises = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListPaises() {
        if (listPaises == null || listPaises.isEmpty()) {
            listPaises = new ArrayList<SelectItem>();
            ArrayList<Cppais> listPaisesAux = null;
            try {
                listPaisesAux = (ArrayList<Cppais>)this.serviceLocator.getClinicoService().getPaises();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listPaisesAux.isEmpty()) {
                Iterator it = listPaisesAux.iterator();
                int i = 0;
                listPaises.add(new SelectItem("", "No Seleccionado ..."));
                while (it.hasNext()) {
                    it.next();
                    listPaises.add(new SelectItem(listPaisesAux.get(i).getCpacodalfa3(), 
                                                         listPaisesAux.get(i).getCpacnombre()));
                    i++;
                }
            }
        }
        return listPaises;
    }

}
