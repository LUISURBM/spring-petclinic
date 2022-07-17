//=======================================================================
// ARCHIVO DatosBasicosUsuarioCirugiaBean.java
// FECHA CREACI�N: 01/12/2015
// AUTOR: Carlos Andres Vargas Roa
// Descripci�n: Datos correspondientes a los datos basicos del usuario de las cirugias .
//=======================================================================

package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.Chtipoafilia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chzona;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=================================================================
//  CLASE DatosUsuarioBean
//=======================================================================

/**
 * DatosBasicosUsuarioCirugiaBean: Permite registrar los Datos Basicos de un Usuario
 * @author Carlos Andres Vargas andres.vargas@profamilia.org.co
 * 
 */
public class DatosBasicosUsuarioCirugiaBean extends BaseBean {

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


    /** Almacena la cosnulta X clinica */
    private Cnconsclin consulta;

    /** Almacena la edad del usuario*/
    private Integer edad;

    /** Almacena la fecha de nacimiento*/
    private Date fechaNacimiento;

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
    
    private List lstHistoricoAntecedente;
    
    // Ultima Valoracion Preanestesica
    private Object[] lstExamenaux;
    
    private Object[] lstExamenanes;
    
    private BigDecimal peso;
    
    private BigDecimal talla;
    
    private List<Chsignovital> lstHistorialSignosVitalesTomados;
    
    private Long numeroCirugia; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public DatosBasicosUsuarioCirugiaBean() {
    }


    public void init() {
    
    
    
        if (usuario == null) {
            usuario = new Chusuario();
        }
        nextAction = "";
        lstHistoricoAntecedente = new ArrayList();
        lstHistorialSignosVitalesTomados = new ArrayList<Chsignovital>();
        inicializarUsuario();
      
    }


    //ACTIONS

    public void inicializarUsuario() {
             
        if (usuario!= null && usuario.getHusdfechanacim() != null) {
            edad = calcularEdad(usuario.getHusdfechanacim(), new Date());
            this.setEdad(edad);
            this.setFechaNacimiento(usuario.getHusdfechanacim());
        }
        
        setCiudad();

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
        
        try {
            if (usuario != null && usuario.getHuslnumero() != null) {
                lstHistoricoAntecedente = 
                        this.serviceLocator.getClinicoService().getAntecedentesUsuario(usuario.getHuslnumero());
                        
                        
                lstExamenaux = 
                        (Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreExamUsuario(usuario.getHuslnumero());      
                lstExamenanes = 
                        (Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreExamAnesUsuario(usuario.getHuslnumero());        
                        
                        if(lstExamenaux != null && lstExamenaux.length >0){
                           peso = (BigDecimal)lstExamenaux[0];
                           talla = (BigDecimal)lstExamenaux[2];
                        }
                        if(lstExamenanes != null && lstExamenanes.equals("") && lstExamenanes.length >0){
                            peso = (BigDecimal)lstExamenaux[0];
                            talla = (BigDecimal)lstExamenaux[2];
                        }
                        
            }
            
            
            if (numeroCirugia != null) {
                try {
                    lstHistorialSignosVitalesTomados = 
                            this.serviceLocator.getCirugiaService().getSignosVitalesTomados(numeroCirugia);


                } catch (ModelException e) {
                    e.printStackTrace();
                }
                {

                }

            }

        } catch (ModelException e) {
            e.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        

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
    public String guardarUsuario() {
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

            if (usuario.getHusctelefono() == null || 
                usuario.getHusctelefono().equals("")) {
                FacesUtils.addErrorMessage(url + "Telefono", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

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

            if (usuario.getHuscentidadadm() == null || 
                usuario.getHuscentidadadm().equals("")) {
                FacesUtils.addErrorMessage(url + "menuEps", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }


            if (usuario.getHusnocupacion() == null) {
                FacesUtils.addErrorMessage(url + "menuOcupacion", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
            }

        }

          

        if (this.getConsulta() != null && 
            this.getConsulta().getCcocservic() != null)
            tipoHistoria = this.getConsulta().getCcocservic().getCsvntiphis();

     
       
        if (fechaNacimiento != null)
            usuario.setHusdfechanacim(fechaNacimiento);
            
        if(renderContacto){
            if(!renderAutoriza){
                usuario.setHuseautcasa("N"); 
                usuario.setHuseautcelular("N");
                usuario.setHuseautcorreoe("N"); 
                usuario.setHuseautmensaj("N");
                usuario.setHuseautoficina("N");
            }else{
                
                if(!renderCasa && !renderCelular && 
                        !renderCorreo && !renderMensajes && !renderOficina){
                    wexitoContacto = false; 
                }            
                
                if(renderCasa){
                    usuario.setHuseautcasa("S"); 
                }else{
                    usuario.setHuseautcasa("N"); 
                }
                if(renderCelular){
                    usuario.setHuseautcelular("S");
                }else{
                    usuario.setHuseautcelular("N");
                }
               
                if(renderCorreo){
                    usuario.setHuseautcorreoe("S");
                }else{
                    usuario.setHuseautcorreoe("N");
                }
                if(renderMensajes){
                    usuario.setHuseautmensaj("S");
                }else{
                    usuario.setHuseautmensaj("N");
                }
                if(renderOficina){
                    usuario.setHuseautoficina("S");
                }else{
                    usuario.setHuseautoficina("N");
                }
                
                
            }
            
            
        }
            
    if(wexitoContacto){
        if(wexito){
            try {
                this.serviceLocator.getClinicoService().saveUsuario(usuario, 
                                                                    consulta,userName(), null);
               

                // Se recarga el menu 
                 navigationRule = nextAction;
                FacesUtils.resetManagedBean(menuBean);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                navigationRule = "";
            }
        }
       
    }else{
        navigationRule = ""; 
        FacesUtils.addErrorMessage(MSG_SIN_AUTORIZACION_CONTACTO);
    }
       // Se establece la siguiente accion de navegacion
        return navigationRule;
    }

    public void changeCiudad() {
        if (usuario.getHusndepartamen() != null && !usuario.getHusndepartamen().equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            usuario.setHusnciudad(null);
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());

            } catch (ModelException e) {
                e.printStackTrace();
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
    }

    public void changeEdad() {
        if (fechaNacimiento != null) {
            setEdad(calcularEdad(fechaNacimiento, new Date()));
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
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
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

  
    public void setCiudad() {
        if (usuario.getHusndepartamen()!=null && !usuario.getHusndepartamen().equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {
                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());
            } catch (ModelException e) {
                e.printStackTrace();
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
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @param valueChangeEvent
     */
    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        setFechaNacimiento((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
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

    public void setLstHistoricoAntecedente(List lstHistoricoAntecedente) {
        this.lstHistoricoAntecedente = lstHistoricoAntecedente;
    }

    public List getLstHistoricoAntecedente() {
        return lstHistoricoAntecedente;
    }

 

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setTalla(BigDecimal talla) {
        this.talla = talla;
    }

    public BigDecimal getTalla() {
        return talla;
    }

    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    public void setLstHistorialSignosVitalesTomados(List<Chsignovital> lstHistorialSignosVitalesTomados) {
        this.lstHistorialSignosVitalesTomados = lstHistorialSignosVitalesTomados;
    }

    public List<Chsignovital> getLstHistorialSignosVitalesTomados() {
        return lstHistorialSignosVitalesTomados;
    }
}
