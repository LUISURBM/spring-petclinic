package org.profamilia.hc.view.backing.comun;

import java.net.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chpruerapi;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.PruebasRapidasDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaMedicamentosBean;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaUsuariosPruebasRapidasBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class PruebasRapidasBean extends BaseBean implements JRDataSource {

    /** Almacena el codigo del departamento */
    private String departamentoSelect;

    /** Almacena el codigo de la ciudad */
    private String ciudadSelect;

    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;

    private Chpruerapi pruebasRapidas;

    private boolean renderVIH;

    private boolean renderHepatitisB;

    private boolean renderHepatitisC;

    private boolean renderSifilis;

    private boolean renderPruebaEmbarazo;

    private List<SelectItem> listResultadoReactiva;
    
    private List<SelectItem> listResultado;
    
    /** Clone de Consulta */
    private Cnconsclin consulta;
    
    private List<Cnconsclin> lstPruebasRapidas;
    
    private String navigationRule;
    
    private Cpprofesio profesionalAct;
    
    private String cargoProfesional;
    
    private Chusuario usuario;  
    
    private boolean botonImprimir;
    
    private List<PruebasRapidasDTO> lstReporte;
    boolean generoReporte;
    private Object[] registro;
    private List<Object[]> lstPrueba;
    private int index = -1;
    private boolean renderToma;
    private boolean renderCierre;
    private int contador = 0;
    private String menuBean;

    private ListaUsuariosPruebasRapidasBean listaPruebasRapidas;


    public PruebasRapidasBean() {
    }

    public void init() {
        botonImprimir = false;
        listDepartamentos = new ArrayList<SelectItem>();
        listMunicipios = new ArrayList<SelectItem>();        
        renderVIH = false;
        renderHepatitisB = false;
        renderHepatitisC = false;
        renderSifilis = false;
        renderPruebaEmbarazo = false;
        lstReporte = new ArrayList<PruebasRapidasDTO>();
        
        
       
        inicializarDatos();

    }
    public void inicializarDatos(){
        if(consulta != null && consulta.getCcontipdoc() != null && consulta.getCcontipdoc().getCtdnnumero()!= null && consulta.getCconnumdoc()!= null ){
//            lstPruebasRapidas = serviceLocator.getClinicoService().getConsultasPruebasRapidasXFactura(consulta.getCcontipdoc().getCtdnnumero(), consulta.getCconnumdoc());
		    listaPruebasRapidas = (ListaUsuariosPruebasRapidasBean)FacesUtils.getManagedBean("listaUsuariosPruebasRapidasBean");
		    List<Cnconsclin> lstPruebasAux = listaPruebasRapidas.getLstPruebasRapidas();
		    lstPruebasRapidas = new ArrayList<Cnconsclin>();
		    for (Cnconsclin cons : lstPruebasAux) {
		        if (cons.isItemSelect()) {
		            lstPruebasRapidas.add(cons);
		        }
		    }
		    if(lstPruebasRapidas != null && !lstPruebasRapidas.isEmpty()){
		        for(Cnconsclin consul:lstPruebasRapidas){
		            if(consul.getCcocservic().getCsvcpruerapi() != null){
		                if(consul.getCcocservic().getCsvcpruerapi().equals(IConstantes.VIH_1_2)){
		                    renderVIH=true;
		                }
		                if(consul.getCcocservic().getCsvcpruerapi().equals( IConstantes.HEPATITIS_B)){
		                    renderHepatitisB=true;
		                }
		                if(consul.getCcocservic().getCsvcpruerapi().equals(IConstantes.HEPATITIS_C)){
		                    renderHepatitisC=true;
		                }
		                if(consul.getCcocservic().getCsvcpruerapi().equals(IConstantes.SIFILIS)){
		                    renderSifilis=true;
		                }
		                if(consul.getCcocservic().getCsvcpruerapi().equals(IConstantes.PRUEBA_EMBARAZO)){
		                    renderPruebaEmbarazo=true;
		                }
		            }
		        }
		    }
		}
      
		if (consulta != null && consulta.getCconnumero() != null) {
		    try {
		        profesionalAct = 
		                serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
		                                                                            this.getClinica().getCclncodigo());
		    } catch (ModelException e) {
		        e.printStackTrace();
		    }
		    if (profesionalAct != null) {
		        try {
		            cargoProfesional = 
		                    serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(profesionalAct.getCpfntipoespe());
		        } catch (ModelException e) {
		            e.printStackTrace();
		        }
		    }
		    try{
		        pruebasRapidas = serviceLocator.getClinicoService().getOnePruebasRapidasByConsulta(consulta.getCconnumero().longValue());
		        if(pruebasRapidas!=null){
		            profesionalAct =
		                serviceLocator.getClinicoService().getProfesionalPorUsuario(pruebasRapidas.getHprcoperador(),
		                                                                        this.getClinica().getCclncodigo());
		        }
		    }catch(ModelException e){
		        e.printStackTrace();
		    }
		}
		if(pruebasRapidas == null){
		    renderCierre = false;
		    pruebasRapidas = new Chpruerapi();
		} else{
		    renderCierre = true;
		    if( pruebasRapidas.getHprndepartamen() !=null){
		        departamentoSelect = pruebasRapidas.getHprndepartamen().toString();
		        changeCiudad();
		    }
		    if(pruebasRapidas.getHprnmunicipio()!=null){
		        ciudadSelect = pruebasRapidas.getHprnmunicipio().toString();
		    }
		    if(pruebasRapidas.getHprnmunicipio()!=null && pruebasRapidas.getHprndepartamen()!=null){
		        if(renderHepatitisB){                     
		            if(pruebasRapidas.getHprcresulhepab()!=null){
		                botonImprimir = true;
		            }
		        }
		        if(renderHepatitisC){                    
		            if(pruebasRapidas.getHprcresulhepac()!=null){
		                botonImprimir = true;
		            }
		        }
		        if(renderPruebaEmbarazo){                      
		            if(pruebasRapidas.getHprcresulpruemb()!=null){
		                botonImprimir = true;
		            }
		        }
		        if(renderSifilis){
		            if(pruebasRapidas.getHprcresulsifil()!=null){
		                botonImprimir = true;
		            }
		        }
		        if(renderVIH){                    
		            if(pruebasRapidas.getHprcresulvih()!=null){
		                botonImprimir = true;
		            }
		        }
		    }
		}
        if(pruebasRapidas !=null){
            if(renderHepatitisB){
                pruebasRapidas.setHprcmarcahepab("CTK BIOTECH INC");
                pruebasRapidas.setHprcreginvhepb("INVIMA 2012RD-0002354");
            }
            if(renderHepatitisC){
                pruebasRapidas.setHprcmarcahepac("CTK BIOTECH INC");
                pruebasRapidas.setHprcreginvhepc("INVIMA 2018RD-0002353-R1");
            }
            if(renderPruebaEmbarazo){
                pruebasRapidas.setHprcmarcapruemb("CTK BIOTECH INC");
                pruebasRapidas.setHprcreginvpruemb("INVIMA 2012RD-0002296");
            }
            if(renderSifilis){
                pruebasRapidas.setHprcreginvsif("INVIMA 2019RD-0002387-R1");
                pruebasRapidas.setHprcmarcasifil("CTK BIOTECH INC");
            }
            if(renderVIH){
                pruebasRapidas.setHprcmarcavih("CTK BIOTECH INC");         
                pruebasRapidas.setHprcreginvvih("INVIMA 2018RD-0004879");
            }  
        }
    }
    
    public String guardarPruebasRapidas(){
    navigationRule="";
        boolean validarCampos = true;
        boolean exito = false;
        if(pruebasRapidas !=null){
            pruebasRapidas.setHprchepatitisb("N");
            pruebasRapidas.setHprchepatitisc("N");
            pruebasRapidas.setHprcvih("N");
            pruebasRapidas.setHprcprueemba("N");
            pruebasRapidas.setHprcsifilis("N");
            if(renderHepatitisB){
            pruebasRapidas.setHprchepatitisb("S");
               if(pruebasRapidas.getHprcmarcahepab()==null){
                   validarCampos = false;
               }
                if(pruebasRapidas.getHprclotehepab()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprcreginvhepb()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprdfecvenhepb()==null){
                    validarCampos = false;
                }
            }
            
            if(renderHepatitisC){
                pruebasRapidas.setHprchepatitisc("S");
               if(pruebasRapidas.getHprcmarcahepac()==null){
                   validarCampos = false;
               }
                if(pruebasRapidas.getHprclotehepac()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprcreginvhepc()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprdfecvenhepc()==null){
                    validarCampos = false;
                }
            }
            
            if(renderPruebaEmbarazo){
                pruebasRapidas.setHprcprueemba("S");
               if(pruebasRapidas.getHprcmarcapruemb()==null){
                   validarCampos = false;
               }
                if(pruebasRapidas.getHprclotepruemb()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprcreginvpruemb()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprdfecvenpruemb()==null){
                    validarCampos = false;
                }
            }
            
            if(renderSifilis){
                pruebasRapidas.setHprcsifilis("S");
               if(pruebasRapidas.getHprcmarcasifil()==null){
                   validarCampos = false;
               }
                if(pruebasRapidas.getHprclotesifi()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprcreginvsif()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprdfecvensif()==null){
                    validarCampos = false;
                }
            }
            
            if(renderVIH){
                pruebasRapidas.setHprcvih("S");
               if(pruebasRapidas.getHprcmarcavih()==null){
                   validarCampos = false;
               }
                if(pruebasRapidas.getHprclotevih()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprcreginvvih()==null){
                    validarCampos = false;
                }
                if(pruebasRapidas.getHprdfecvenvih()==null){
                    validarCampos = false;
                }
            }
         
        }
        if(departamentoSelect !=null){
            pruebasRapidas.setHprndepartamen(new Long(departamentoSelect));
           
        }
        else{
            validarCampos = false;
        }
        
        if(ciudadSelect !=null){
            pruebasRapidas.setHprnmunicipio(new Long(ciudadSelect));
          
        }
        else{
            validarCampos = false;
        }
    if(validarCampos){
        navigationRule = BeanNavegacion.RUTA_LISTA;
        if(lstPruebasRapidas !=null && usuario!=null){         
            for (int i = 0;i<lstPruebasRapidas.size();i++){
                try{            
                    serviceLocator.getClinicoService().savePruebasRapidas(pruebasRapidas,usuario,lstPruebasRapidas.get(i),userName());
                    exito = true;
                }
                catch(Exception e){
                exito = false;
                    return capturaError(e,IConstantes.ERROR_PRUEBAS_RAPIDAS);
                }
                
            }     
    }
    if(exito){
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.addInfoMessage("Pruebas R�pidas guardadas con �xito");
            return BeanNavegacion.RUTA_IR_PRUEBAS_RAPIDAS;
    }           
        }
        else{
            FacesUtils.addErrorMessage("Por favor diligencie todos los campos requeridos");
            return null;
     
        }
        return null;
    }
          public void guardarPruebasRapidasCierre(){
          navigationRule="";
              boolean validarCampos = true;
              boolean exito = false;
              if(pruebasRapidas !=null){
                  pruebasRapidas.setHprchepatitisb("N");
                  pruebasRapidas.setHprchepatitisc("N");
                  pruebasRapidas.setHprcvih("N");
                  pruebasRapidas.setHprcprueemba("N");
                  pruebasRapidas.setHprcsifilis("N");
                  if(renderHepatitisB){
                  pruebasRapidas.setHprchepatitisb("S");
                     if(pruebasRapidas.getHprcmarcahepab()==null){
                         validarCampos = false;
                     }
                      if(pruebasRapidas.getHprclotehepab()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprcreginvhepb()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprdfecvenhepb()==null){
                          validarCampos = false;
                      }
                  }
                  
                  if(renderHepatitisC){
                      pruebasRapidas.setHprchepatitisc("S");
                     if(pruebasRapidas.getHprcmarcahepac()==null){
                         validarCampos = false;
                     }
                      if(pruebasRapidas.getHprclotehepac()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprcreginvhepc()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprdfecvenhepc()==null){
                          validarCampos = false;
                      }
                  }
                  
                  if(renderPruebaEmbarazo){
                      pruebasRapidas.setHprcprueemba("S");
                     if(pruebasRapidas.getHprcmarcapruemb()==null){
                         validarCampos = false;
                     }
                      if(pruebasRapidas.getHprclotepruemb()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprcreginvpruemb()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprdfecvenpruemb()==null){
                          validarCampos = false;
                      }
                  }
                  
                  if(renderSifilis){
                      pruebasRapidas.setHprcsifilis("S");
                     if(pruebasRapidas.getHprcmarcasifil()==null){
                         validarCampos = false;
                     }
                      if(pruebasRapidas.getHprclotesifi()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprcreginvsif()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprdfecvensif()==null){
                          validarCampos = false;
                      }
                  }
                  
                  if(renderVIH){
                      pruebasRapidas.setHprcvih("S");
                     if(pruebasRapidas.getHprcmarcavih()==null){
                         validarCampos = false;
                     }
                      if(pruebasRapidas.getHprclotevih()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprcreginvvih()==null){
                          validarCampos = false;
                      }
                      if(pruebasRapidas.getHprdfecvenvih()==null){
                          validarCampos = false;
                      }
                  }
               
                      if(pruebasRapidas.getHprcobservacion()==null){
                          validarCampos = false;
                      
                  }
              }
              if(departamentoSelect !=null){
                  pruebasRapidas.setHprndepartamen(new Long(departamentoSelect));
                 
              }
              else{
                  validarCampos = false;
              }
              
              if(ciudadSelect !=null){
                  pruebasRapidas.setHprnmunicipio(new Long(ciudadSelect));
                
              }
              else{
                  validarCampos = false;
              }
          if(validarCampos){
              navigationRule = BeanNavegacion.RUTA_LISTA;
              if(lstPruebasRapidas !=null && usuario!=null){         
                  for (int i = 0;i<lstPruebasRapidas.size();i++){
                      try{
                          serviceLocator.getClinicoService().savePruebasRapidas(pruebasRapidas,usuario,lstPruebasRapidas.get(i),userName());
                          exito = true;
                      }
                      catch(Exception e){
                      exito = false;
                          FacesUtils.addErrorMessage(e.getMessage());
                          e.printStackTrace(); 
                      }   
                  }           
          }
                  botonImprimir = true;
          if(exito){
                  FacesUtils.addInfoMessage("Pruebas R�pidas guardadas con �xito");
          }           
              }
              else{
                  FacesUtils.addErrorMessage("Por favor diligencie todos los campos requeridos");
           
              }
          }
    public String cerrarPruebaRapida(){
        try {
        if(lstPruebasRapidas !=null ){
        for(int i = 0;i<lstPruebasRapidas.size();i++){
            serviceLocator.getClinicoService().closePruebasRapidas(pruebasRapidas,usuario,lstPruebasRapidas.get(i),userName());
            }
        }
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_CERRAR_PRUEBAS_RAPIDAS);
        }
        FacesUtils.addInfoMessage("Informaci�n guardada con �xito");
        FacesUtils.resetManagedBean("listaUsuariosPruebasRapidasBean");
        return BeanNavegacion.RUTA_LISTA_PRUEBAS_RAPIDAS;
    }
    
    public boolean esValido(){
    boolean esValido = false;
        Chpruerapi aux = null;
        if(consulta !=null && consulta.getCconnumero() != null){
        try{
       
            aux = serviceLocator.getClinicoService().getOnePruebasRapidasByConsulta(consulta.getCconnumero().longValue());
           
        }catch(ModelException e){
            e.printStackTrace();
        }
        }
        if(aux == null){
        renderCierre = false;    
        }
        else{
            esValido = true;
            renderCierre = true;
        }
        return esValido;
    }


    public void changeCiudad() {
        if (departamentoSelect != null && !departamentoSelect.equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ciudadSelect = "";
            ArrayList<Cpmunidane> listMunicipiosAux = null;

            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(new Integer(departamentoSelect));
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
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun().toString(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }


        } else {
            listMunicipios = new ArrayList<SelectItem>();
        }


    }


    /**
     * @param valueChangeEvent
     */
    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        setDepartamentoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderVIH(ValueChangeEvent valueChangeEvent) {
        setRenderVIH((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    public void setRenderHepatitisB(ValueChangeEvent valueChangeEvent) {
        setRenderHepatitisB((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderHepatitisC(ValueChangeEvent valueChangeEvent) {
        setRenderHepatitisC((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderSifilis(ValueChangeEvent valueChangeEvent) {
        setRenderSifilis((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderPruebaEmbarazo(ValueChangeEvent valueChangeEvent) {
        setRenderPruebaEmbarazo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param param
     */
    public void setListDepartamentos(List<SelectItem> param) {
        this.listDepartamentos = param;
    }

    /**
     * @return
     */
    public List<SelectItem> getListDepartamentos() {
        if (listDepartamentos.size() == 0) {
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
                    listDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo().toString(), 
                                                         listDepartamentosAux.get(i).getCddcdescri()));
                    i++;
                }
            }
        }
        return listDepartamentos;
    }
    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < lstReporte.size());
    }

    
    
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Date date = lstReporte.get(index).getFechaRegistro();

        if (fieldName.equals("nombrePrueba")) {        
          value = lstReporte.get(index).getNombrePrueba();
            return value;
        }
       else if (fieldName.equals("marca")) {        
          value = lstReporte.get(index).getMarca();
            return value;
        }
       else if (fieldName.equals("lote")) {        
          value = lstReporte.get(index).getLote();
            return value;
       }
       else if (fieldName.equals("registroInvima")) {        
          value = lstReporte.get(index).getRegistroInvima();
            return value;
        }
      else  if (fieldName.equals("fechaVencimiento")) {  
      
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                   Date fechaDate = null;
                   try {
                       fechaDate = formato.parse(lstReporte.get(index).getFechaVencimiento());
            value = fechaDate;
            
            return value;
            } catch (ParseException e) {
                value = lstReporte.get(index).getFechaVencimiento();
                 return value;
            }
        }
        else  if (fieldName.equals("nombrePersona")) {        
            value = lstReporte.get(index).getNombrePersona();
              return value;
          }
        else  if (fieldName.equals("numIdentificacion")) {        
            value = lstReporte.get(index).getNumIdentificacion();
              return value;
          }
        else  if (fieldName.equals("resultado1")) {        
            value = lstReporte.get(index).getResultado1();
              return value;
          }
        else  if (fieldName.equals("resultado2")) {        
            value = lstReporte.get(index).getResultado2();
              return value;
          }
        else  if (fieldName.equals("valorRes1")) {        
            value = lstReporte.get(index).getValorRes1();
              return value;
          }
        else  if (fieldName.equals("valorRes2")) {        
            value = lstReporte.get(index).getValorRes2();
              return value;
          }
        else  if (fieldName.equals("responsable")) {        
            value = lstReporte.get(index).getResponsable();
              return value;
          }
        else  if (fieldName.equals("CLINICA")) {        
            value = getClinica().getCclcnombre();
              return value;
          }
        else  if (fieldName.equals("MM")) {        
                SimpleDateFormat mes = new SimpleDateFormat("MM");
                String mesActual = mes.format(date);
                value = mesActual;
                return value;
          }
        else  if (fieldName.equals("DD")) {        
                SimpleDateFormat dia = new SimpleDateFormat("dd");
                String diaActual = dia.format(date);
                value = diaActual;
                return value;
          }
        else  if (fieldName.equals("YYYY")) {        
                SimpleDateFormat anio = new SimpleDateFormat("yyyy");
                String anioActual = anio.format(date);
                value = anioActual;
                return value;
          }
       
    return value;
    }
    public void generarArchivoPdf() {
    lstReporte = new ArrayList<PruebasRapidasDTO>();
    consultarPruebaRapida();
        index = -1;
        generoReporte = false;
        if (lstPrueba == null || lstPrueba.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                llenarListaReporte();
                String nombreArchivo = "Reporte_PruebasRapidas";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/impresionPruebasRapidas.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("PROFAMILIA_IMAGE",url_profamilia);

                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                    nombreArchivo + 
                    Calendar.getInstance().getTimeInMillis() + ".pdf", 
                                                    false);
                    generoReporte = true;


                   

                }
            } catch (Exception e) {
                //generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }
    
    public void consultarPruebaRapida()  {
      


        try {
        lstPrueba =
                this.getServiceLocator().getClinicoService().getPruebasRapidasByConsulta(new Long(lstPruebasRapidas.get(0).getCconnumero()));
        } catch (ModelException e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }
    public void llenarListaReporte(){
        // validar vih
        String primerNombre;
        String primerApellido ;
        String segundoNombre="";
        String segundoApellido = "";
        Object[]o  = lstPrueba.get(0);
        try {
            profesionalAct =
                serviceLocator.getClinicoService().getProfesionalPorUsuario(o[33].toString(),
                                                                            this.getClinica().getCclncodigo());
        } catch (ModelException e) {
           e.printStackTrace();
        }
        String responsable="";
        if(profesionalAct!=null){
            responsable=profesionalAct.getCpfcnombre();
        }
        if(o[10]!=null){
        PruebasRapidasDTO aux = new PruebasRapidasDTO();
        aux.setNombrePrueba("VIH");
        aux.setResultado1("Reactiva");
        aux.setResultado2("No reactiva");
        aux.setResponsable(responsable);
        aux.setFechaRegistro((Date)o[32]);
        if(o[30]!=null){
            if(o[30].equals("RE")){
                aux.setValorRes1("X");
            }
            else{
                aux.setValorRes2("X");
            }
        }
        if(o[1]!=null){
            aux.setNumIdentificacion(o[1].toString());
        }
        primerNombre = o[2].toString();
        primerApellido = o[3].toString();
        if(o[4]!=null){
            segundoNombre = o[4].toString();
        }
        if(o[5]!=null){
            segundoApellido = o[5].toString();
        }
        aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
        aux.setMarca(o[15].toString());
        aux.setLote(o[10].toString());
        aux.setRegistroInvima(o[20].toString());
        aux.setFechaVencimiento(o[25].toString());
        lstReporte.add(aux);
    }
        if(o[9]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("S�FILIS");
            aux.setResultado1("Positiva");
            aux.setResultado2("Negativa");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[29]!=null){
                if(o[29].equals("PO")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[14].toString());
            aux.setLote(o[9].toString());
            aux.setRegistroInvima(o[19].toString());
            aux.setFechaVencimiento(o[24].toString());
            lstReporte.add(aux);
        }
        if(o[8]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("EMBARAZO");
            aux.setResultado1("Positiva");
            aux.setResultado2("Negativa");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[28]!=null){
                if(o[28].equals("PO")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[13].toString());
            aux.setLote(o[8].toString());
            aux.setRegistroInvima(o[18].toString());
            aux.setFechaVencimiento(o[23].toString());
            lstReporte.add(aux);
        }
        if(o[7]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("HEPATITIS C");
            aux.setResultado1("Reactiva");
            aux.setResultado2("No Reactiva");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[27]!=null){
                if(o[27].equals("RE")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[12].toString());
            aux.setLote(o[7].toString());
            aux.setRegistroInvima(o[17].toString());
            aux.setFechaVencimiento(o[22].toString());
            lstReporte.add(aux);
        }
        if(o[6]!=null){
            PruebasRapidasDTO aux = new PruebasRapidasDTO();
            aux.setNombrePrueba("HEPATITIS B");
            aux.setResultado1("Reactiva");
            aux.setResultado2("No reactiva");
            aux.setResponsable(responsable);
            aux.setFechaRegistro((Date)o[32]);
            if(o[26]!=null){
                if(o[26].equals("RE")){
                    aux.setValorRes1("X");
                }
                else{
                    aux.setValorRes2("X");
                }
            }
            if(o[1]!=null){
                aux.setNumIdentificacion(o[1].toString());
            }
            primerNombre = o[2].toString();
            primerApellido = o[3].toString();
            if(o[4]!=null){
                segundoNombre = o[4].toString();
            }
            if(o[5]!=null){
                segundoApellido = o[5].toString();
            }
            aux.setNombrePersona(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            aux.setMarca(o[11].toString());
            aux.setLote(o[6].toString());
            aux.setRegistroInvima(o[16].toString());
            aux.setFechaVencimiento(o[21].toString());
            lstReporte.add(aux);
        }
       
       
    }
 
    

    public void setDepartamentoSelect(String departamentoSelect) {
        this.departamentoSelect = departamentoSelect;
    }

    public String getDepartamentoSelect() {
        return departamentoSelect;
    }

    public void setCiudadSelect(String ciudadSelect) {
        this.ciudadSelect = ciudadSelect;
    }

    public String getCiudadSelect() {
        return ciudadSelect;
    }

    public void setListMunicipios(List<SelectItem> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public List<SelectItem> getListMunicipios() {
        return listMunicipios;
    }

    public void setPruebasRapidas(Chpruerapi pruebasRapidas) {
        this.pruebasRapidas = pruebasRapidas;
    }

    public Chpruerapi getPruebasRapidas() {
        return pruebasRapidas;
    }

    public void setRenderVIH(boolean renderVIH) {
        this.renderVIH = renderVIH;
    }

    public boolean isRenderVIH() {
        return renderVIH;
    }

    public void setRenderHepatitisB(boolean renderHepatitisB) {
        this.renderHepatitisB = renderHepatitisB;
    }

    public boolean isRenderHepatitisB() {
        return renderHepatitisB;
    }

    public void setRenderHepatitisC(boolean renderHepatitisC) {
        this.renderHepatitisC = renderHepatitisC;
    }

    public boolean isRenderHepatitisC() {
        return renderHepatitisC;
    }

    public void setRenderSifilis(boolean renderSifilis) {
        this.renderSifilis = renderSifilis;
    }

    public boolean isRenderSifilis() {
        return renderSifilis;
    }

    public void setRenderPruebaEmbarazo(boolean renderPruebaEmbarazo) {
        this.renderPruebaEmbarazo = renderPruebaEmbarazo;
    }

    public boolean isRenderPruebaEmbarazo() {
        return renderPruebaEmbarazo;
    }

    public void setListResultadoReactiva(List<SelectItem> listResultadoReactiva) {
        this.listResultadoReactiva = listResultadoReactiva;
    }

    public List<SelectItem> getListResultadoReactiva() {
        if (listResultadoReactiva == null || listResultadoReactiva.isEmpty()) {
            listResultadoReactiva = new ArrayList<SelectItem>();
            listResultadoReactiva.add(new SelectItem("RE", "Reactiva"));
            listResultadoReactiva.add(new SelectItem("NR", "No Reactiva"));//cambiar esto
        }
        return listResultadoReactiva;
    }

    public void setListResultado(List<SelectItem> listResultado) {
        this.listResultado = listResultado;
    }

    public List<SelectItem> getListResultado() {
        if (listResultado == null || listResultado.isEmpty()) {
            listResultado = new ArrayList<SelectItem>();
            listResultado.add(new SelectItem("PO", "Positivo"));
            listResultado.add(new SelectItem("NE", "Negativo"));
        }
        return listResultado;
    }
    
    public void incrementarContador(){
        contador++;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setLstPruebasRapidas(List<Cnconsclin> lstPruebasRapidas) {
        this.lstPruebasRapidas = lstPruebasRapidas;
    }

    public List<Cnconsclin> getLstPruebasRapidas() {
        return lstPruebasRapidas;
    }

    public void setProfesionalAct(Cpprofesio profesionalAct) {
        this.profesionalAct = profesionalAct;
    }

    public Cpprofesio getProfesionalAct() {
        return profesionalAct;
    }

    public void setCargoProfesional(String cargoProfesional) {
        this.cargoProfesional = cargoProfesional;
    }

    public String getCargoProfesional() {
        return cargoProfesional;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setBotonImprimir(boolean botonImprimir) {
        this.botonImprimir = botonImprimir;
    }

    public boolean isBotonImprimir() {
        return botonImprimir;
    }

    public void setLstReporte(List<PruebasRapidasDTO> lstReporte) {
        this.lstReporte = lstReporte;
    }

    public List<PruebasRapidasDTO> getLstReporte() {
        return lstReporte;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setRegistro(Object[] registro) {
        this.registro = registro;
    }

    public Object[] getRegistro() {
        return registro;
    }

    public void setLstPrueba(List<Object[]> lstPrueba) {
        this.lstPrueba = lstPrueba;
    }

    public List<Object[]> getLstPrueba() {
        return lstPrueba;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setRenderToma(boolean renderToma) {
        this.renderToma = renderToma;
    }

    public boolean isRenderToma() {
        return renderToma;
    }

    public void setRenderCierre(boolean renderCierre) {
        this.renderCierre = renderCierre;
    }

    public boolean isRenderCierre() {
        return renderCierre;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }
}
