package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfencuecovid;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

public class CuestionarioCovidBean extends BaseBean {


    private Cfencuecovid cuestionario;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private Long numeroConsulta;
    
    private Chconsulta consultaObject;
    
    private Long numeroUsuario;
    
    private Chusuario usuario; 

    private String tipoServicio;

    private List lstSintomas;

    private List lstSintomasSelect;

    private boolean renderOtroSintoma;
    
    private List lstOpciones;
    
    private List lstConducta; 
    
    private boolean existeEncuesta;
    
    private boolean renderSigueCuarentena;

  


    public CuestionarioCovidBean() {
    }
    
    public void init() {
        lstSintomas = new ArrayList();
        lstSintomasSelect = new ArrayList();
        cuestionario = new Cfencuecovid();
        renderOtroSintoma = false;
        existeEncuesta = false; 
        
        if(numeroUsuario != null ){
            
        
        
            try {
                cuestionario = serviceLocator.getClinicoService().getEncuestaCovidXUsuario(numeroUsuario, new Date());
                usuario = serviceLocator.getClinicoService().getUsuario(numeroUsuario);
                
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if(cuestionario == null){
            cuestionario = new Cfencuecovid();
            existeEncuesta = false; 
        }else{
            existeEncuesta = true; 
            changeDiagnostico();
            changeSintomas();
        lstSintomasSelect = new ArrayList();
        
            if(cuestionario.getCeccsintfieb() != null && cuestionario.getCeccsintfieb().equals("S")){
                lstSintomasSelect.add("FI");
            }
            
            if(cuestionario.getCeccsinttos()!= null && cuestionario.getCeccsinttos().equals("S")){
                lstSintomasSelect.add("TO");
            }
            
            if(cuestionario.getCeccsintfati()!= null && cuestionario.getCeccsintfati().equals("S")){
                lstSintomasSelect.add("FA");
            }  
            
            if(cuestionario.getCeccsintexpe() != null && cuestionario.getCeccsintexpe().equals("S")){
                lstSintomasSelect.add("EX");    
            }  
            
            if(cuestionario.getCeccsintresp() != null && cuestionario.getCeccsintresp().equals("S")){
                lstSintomasSelect.add("DR");    
            }  
            
            if(cuestionario.getCeccsintgarg() != null && cuestionario.getCeccsintgarg().equals("S")){
                    lstSintomasSelect.add("DG");    
                }  
            
            if(cuestionario.getCeccsintolfa() != null && cuestionario.getCeccsintolfa().equals("S")){
                lstSintomasSelect.add("PO");    
            }  
            
            if(cuestionario.getCeccsintdiar() != null && cuestionario.getCeccsintdiar().equals("S")){
                lstSintomasSelect.add("DI");                    
            }  
            
            if(cuestionario.getCeccsintotro() != null && cuestionario.getCeccsintotro().equals("S")){
                lstSintomasSelect.add("OT");    
                renderOtroSintoma = true;
            }  

            if(cuestionario.getCeccsintning() != null && cuestionario.getCeccsintning().equals("S")){
               lstSintomasSelect.add("NI");    
            }  
            
            if(cuestionario.getCeccsintrapi() != null && cuestionario.getCeccsintrapi().equals("S")){
                lstSintomasSelect.add("RR");    
            } 
            
            if(cuestionario.getCecnrefeapli() !=null && cuestionario.getCecnrefeapli().equals(numeroConsulta)){
                existeEncuesta = false;
            }

            
        }
       
    }

    public void inicializarCuestionario() {
            init();
    }
    
/*    public void mensaje(){
        if(cuestionario != null && cuestionario.getCeccconducta()!= null){
            if(cuestionario.getCeccconducta().equals("EPSD")){
                FacesUtils.addInfoMessage("La respuesta a la pregunta de conducta fue: Direccionar al paciente a urgencias o su EPS");
                FacesUtils.addInfoMessage("No olvide Activar C�digo Perla y tener en cuenta protocolos de Bioseguridad� se procede con el progreso en la atenci�n de la historia cl�nica");
            }
            
            if(cuestionario.getCeccconducta().equals("AUAI")){
                FacesUtils.addErrorMessage("La respuesta a la pregunta de conducta fue: Recomendar autoaislamiento preventivo en casa y reprogramar la atenci�n para cuando hayan pasado por lo menos 3 d�as despu�s de la desaparici�n de los s�ntomas.");
                FacesUtils.addInfoMessage("No olvide Activar C�digo Perla y tener en cuenta protocolos de Bioseguridad� se procede con el progreso en la atenci�n de la historia cl�nica");
            }
        }
    }
*/

    public String guardar() {

        navigationRule = "";

        cuestionario.setCeccsintfieb("N");
                cuestionario.setCeccsinttos("N");
                cuestionario.setCeccsintfati("N");
                cuestionario.setCeccsintexpe("N");
                cuestionario.setCeccsintresp("N");
                cuestionario.setCeccsintgarg("N");
                cuestionario.setCeccsintolfa("N");
                cuestionario.setCeccsintdiar("N");
                cuestionario.setCeccsintotro("N");
                cuestionario.setCeccsintrapi("N");
                cuestionario.setCeccsintning("N");

        
    if(!existeEncuesta){
        cuestionario.setCeccaplicaci("HISTO");
        cuestionario.setCecnrefeapli(numeroConsulta);
        cuestionario.setCeccusuareg(userName());
        cuestionario.setCecdfechregi(new Date());
        cuestionario.setCeclusuario(numeroUsuario);
        
        if(usuario != null){
            cuestionario.setCecctipide(usuario.getHusetipoiden());
            cuestionario.setCecnnumide(usuario.getHusanumeiden());
        }

    }
        
        if (lstSintomasSelect != null && !lstSintomasSelect.isEmpty()) {
            for (Iterator iterator = lstSintomasSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("FI")) {
                    cuestionario.setCeccsintfieb("S");
                }

                if (codigo.equals("TO")) {
                    cuestionario.setCeccsinttos("S");
                }

                if (codigo.equals("FA")) {
                    cuestionario.setCeccsintfati("S");
                }

                if (codigo.equals("EX")) {
                    cuestionario.setCeccsintexpe("S");
                }

                if (codigo.equals("DR")) {
                    cuestionario.setCeccsintresp("S");
                }

                if (codigo.equals("DG")) {
                    cuestionario.setCeccsintgarg("S");
                }

                if (codigo.equals("PO")) {
                    cuestionario.setCeccsintolfa("S");
                }

                if (codigo.equals("DI")) {
                    cuestionario.setCeccsintdiar("S");
                }

                if (codigo.equals("OT")) {
                    cuestionario.setCeccsintotro("S");
                }

                if (codigo.equals("NI")) {
                    cuestionario.setCeccsintning("S");
                }

                if (codigo.equals("RR")) {
                    cuestionario.setCeccsintrapi("S");
                }

            }

        }


        try {
            serviceLocator.getClinicoService().saveCuestionarioCovid(cuestionario);
            navigationRule = nextAction;
            FacesUtils.resetManagedBean(menuBean);
            DatosBasicosUsuarioBean datos = (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean"); 
            datos.mensaje();
        } catch (ModelException e) {
            e.printStackTrace();
        }

        return navigationRule;
    }
    

    /**
     * @return
     */
    public boolean esValido()
    {
        Cfencuecovid cuestionarioAux = null;
        if(numeroUsuario != null)
            try
            {
                cuestionarioAux = serviceLocator.getClinicoService().getEncuestaCovidXUsuario(numeroUsuario, new Date());
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
        return cuestionarioAux != null;
    }


    public void setCuestionario(Cfencuecovid cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Cfencuecovid getCuestionario() {
        return cuestionario;
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

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setLstSintomas(List lstSintomas) {
        this.lstSintomas = lstSintomas;
    }

    public List getLstSintomas() {
        {
            if (lstSintomas == null || lstSintomas.isEmpty()) {
                lstSintomas = new ArrayList();
                lstSintomas.add(new SelectItem("NI", "Ninguno"));
                lstSintomas.add(new SelectItem("FI", 
                                               "Fiebre cuantificada mayor a 38�C"));
                lstSintomas.add(new SelectItem("TO", "Tos"));
                lstSintomas.add(new SelectItem("FA", "Fatiga"));
                lstSintomas.add(new SelectItem("EX", "Expectoraci�n "));
                lstSintomas.add(new SelectItem("DR", 
                                               "Dificultad respiratoria "));
                lstSintomas.add(new SelectItem("RR", "Respiraci�n r�pida "));
                lstSintomas.add(new SelectItem("DG", "Dolor de garganta  "));
                lstSintomas.add(new SelectItem("PO", 
                                               "P�rdida del olfato o gusto"));
                lstSintomas.add(new SelectItem("DI", 
                                               "Diarrea u otras molestias digestivas"));
                lstSintomas.add(new SelectItem("OT", "�Otros s�ntomas? "));
            }
            return lstSintomas;
        }
    }
    
   
    public void setLstSintomasSelect(List lstSintomasSelect) {
        this.lstSintomasSelect = lstSintomasSelect;
    }

    public List getLstSintomasSelect() {
        return lstSintomasSelect;
    }

    public void setLstSintomasSelect(ValueChangeEvent valueChangeEvent) {
        setLstSintomasSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderOtroSintoma(boolean renderOtroSintoma) {
        this.renderOtroSintoma = renderOtroSintoma;
    }

    public boolean isRenderOtroSintoma() {
        return renderOtroSintoma;
    }

    public void changeSintomas() {
        {
            renderOtroSintoma = false;
            if (lstSintomasSelect != null && !lstSintomasSelect.isEmpty()) {
                for (Iterator iterator = lstSintomasSelect.iterator(); 
                     iterator.hasNext(); ) {
                    String codigo = (String)iterator.next();
                    if (codigo.equals("OT"))
                        renderOtroSintoma = true;
                }

            }
        }

    }
    
    public void changeDiagnostico(){
        renderSigueCuarentena = false; 
        if(cuestionario != null && cuestionario.getCeccdiagcovi() != null && 
        cuestionario.getCeccdiagcovi().equals("S")){
            renderSigueCuarentena = true;     
        }
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

    public void setLstConducta(List lstConducta) {
        this.lstConducta = lstConducta;
    }

    public List getLstConducta() {
        if (lstConducta == null || lstOpciones.isEmpty()) {
            lstConducta = new ArrayList();
            lstConducta.add(new SelectItem("", "Seleccione ..."));
            lstConducta.add(new SelectItem("AGEN", "Agendar o prestar el servicio. "));
            lstConducta.add(new SelectItem("EPSD", "Direccionar al paciente a urgencias o su EPS"));
            lstConducta.add(new SelectItem("AUAI", "Recomendar autoaislamiento preventivo en casa y reprogramar la atenci�n para cuando hayan pasado por lo menos 3 d�as despu�s de la desaparici�n de los s�ntomas.  "));


        }

        return lstConducta;
        }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setConsultaObject(Chconsulta consultaObject) {
        this.consultaObject = consultaObject;
    }

    public Chconsulta getConsultaObject() {
        return consultaObject;
    }

    public void setExisteEncuesta(boolean existeEncuesta) {
        this.existeEncuesta = existeEncuesta;
    }

    public boolean isExisteEncuesta() {
        return existeEncuesta;
    }

    public void setRenderSigueCuarentena(boolean renderSigueCuarentena) {
        this.renderSigueCuarentena = renderSigueCuarentena;
    }

    public boolean isRenderSigueCuarentena() {
        return renderSigueCuarentena;
    }

    public void setCeccdiagcovi(ValueChangeEvent valueChangeEvent) {
        cuestionario.setCeccdiagcovi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }
}
