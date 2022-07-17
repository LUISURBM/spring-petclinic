//=======================================================================
// ARCHIVO EsterilizacionFemeninaBean.java
// FECHA CREACI�N: 12/08/2010
// AUTOR: Jhon carranza
// Descripci�n: Datos correspondientes cuestionaro sobre esterilizacion.
//=======================================================================

package org.profamilia.hc.view.backing.cirugia.consulta;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcuestester;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;





//=======================================================================
//  CLASE EsterilizacionFemeninaBean
//=======================================================================

public class EsterilizacionFemeninaBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List lstOpciones;

    private List<Chcuestester> lstCuestionario;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String nextAction;

    private String menuBean;

    private Chcuestester cuestEsterilizacion;
    
    private int index = -1;

    private boolean mostrarFumar;

    private boolean mostrarMetodoPlan;
    
    private Integer fumadia;

    private List lstMetodo;
    
    private boolean generoConsentimiento; 
    
    private List<Chreporte> lstReporte;
    
    private boolean renderFechaParto;
    
    // Datos del Reporte

     String NOMBRE; 
     Date FECHA_NACIMIENTO; 
     String DIRECCION; 
     String OCUPACION; 
     String RESPONSABLE; 
     Integer EDAD; 
     String TELEFONO; 
     String ESTADO_CIVIL; 
     String PARENTESCO_RESPONSABLE; 
     String SEXO; 
     String CIUDAD; 
     String TELEFONO_RESPONSABLE; 
     String IMPRIMIO;  
     String TIPO_DOCUMENTO; 
     Long NUMERO_DOCUMENTO; 
     String CENTRO; 
     
    // Datos del Reporte

      String NOMBRE_USUARIO;
      Date FECHA;
      String NOMBRE_PROFESIONAL;
      String HCECENFERMO;
      String HCECENFERGRAV;
      String HCECOPERADO;
      String HCECTRANSFUSION;
      String HCECPRESIONALTA;
      String HCECEJERCICIO;
      String HCECPALPITACION;
      String HCECSOPLO;
      String HCECASMA;
      String HCECTOS;
      String HCECGRIPA;
      String HCECFUMA;
      String HCECPROBANESTESIA;
      String HCECALERGIA;
      String HCECDROGAS;
      String HCECCONVULSION;
      String HCECENFERMENTAL;
      String HCECDIABETES;
      String HCECHEPATITIS;
      String HCECOTRAENFER;
      String HCECEMBARAZO;
      String HCEDFECHULTMES;
      String HCECUTILMETPLAN;
      String HCEDFECHAPARTO;
      String HCECINFOMET;
      String HCECMETDEF;
      String HCECLIGFALLA;
      String HCECINSESTER;
      
       String HCECANENFERMO; 
       String HCECANENFERGRAV; 
       String HCECANOPERADO; 
       String HCECANTRANSFUSION; 
       String HCECANPRESIONALTA; 
       String HCECANEJERCICIO; 
       String HCECANPALPITACION; 
       String HCECANSOPLO; 
       String HCECANASMA; 
       String HCECANTOS; 
       String HCECANGRIPA; 
       String HCECANFUMA; 
       String HCECANPROBANESTESIA; 
       String HCECANALERGIA; 
       String HCECANDROGAS; 
       String HCECANCONVULSION; 
       String HCECANENFERMENTAL; 
       String HCECANDIABETES; 
       String HCECANHEPATITIS; 
       String HCECANOTRAENFER; 
       String HCECANEMBARAZO; 
       String HCECANMESNORM; 
       String HCECANMETPLAN; 
       String HCECANINFOMET; 
       String HCECANMETDEF; 
       String HCECANLIGFALLA; 
       String HCECANINSESTER; 
       String HCECMESNORM; 
       String HCECESPARTO;
       String HCECMETPLAN; 
       String HCECOBSERV; 


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public EsterilizacionFemeninaBean() {
    }


    public void init() {
        cuestEsterilizacion = new Chcuestester();
        lstMetodo = new ArrayList();
        generoConsentimiento = false; 
        lstReporte = new ArrayList<Chreporte>();

    }

    public void inicializarEsterilizacionFem() {

        Long numeroConsulta = null;
        generoConsentimiento = false; 
        renderFechaParto = false; 
        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }

        if (numeroConsulta != null) {

            try {
                lstCuestionario = 
                        this.getServiceLocator().getClinicoService().getCuestionarioEsterilizacion(numeroConsulta);

                if (lstCuestionario == null || lstCuestionario.isEmpty()) {
                    lstCuestionario = this.getServiceLocator().getClinicoService().getCuestionarioEsterilizacionPorUsuaria(consulta.getCcolusuario().getHuslnumero());
                } 

                if (lstCuestionario != null && !lstCuestionario.isEmpty()) {
                    cuestEsterilizacion = lstCuestionario.get(0);
                                           

                    if (cuestEsterilizacion.getHcecfuma() != null && 
                        cuestEsterilizacion.getHcecfuma().equalsIgnoreCase("S")) {
                        fumadia = cuestEsterilizacion.getHcecnocigarrillo();
                        mostrarFumar = true;
                    } else {
                        fumadia = null;
                        mostrarFumar = false;
                    }

                    if (cuestEsterilizacion.getHcecutilmetplan() != null && 
                        cuestEsterilizacion.getHcecutilmetplan().equalsIgnoreCase("S")) {
                        mostrarMetodoPlan = true;
                    } else {
                        mostrarMetodoPlan = false;
                    }
                    
                    if(cuestEsterilizacion.getHcecesparto()!= null && !cuestEsterilizacion.getHcecesparto().equals("X")){
                        renderFechaParto = true;         
                    }else{
                        renderFechaParto = false;         
                    }
                    
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
      
    }

    //ACTIONS

    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Long numero;
        numero = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            numero = new Long(consulta.getCconnumero());
        }

        if (numero != null) {
            try {
                lstCuestionario = 
                        this.getServiceLocator().getClinicoService().getCuestionarioEsterilizacion(numero);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstCuestionario != null && !lstCuestionario.isEmpty()) {
            return true;
        }

        return false;
    }

    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void changeTodosSi() {
           mostrarFumar = true; 
          mostrarMetodoPlan = true; 
          inicializarPreguntas("S");       
    }

    public void changeTodosNo() {
           mostrarFumar = false; 
           mostrarMetodoPlan = false; 
           inicializarPreguntas("N");
   
    }


    public void changeNinguno() {
        inicializarPreguntas(null);
    }


    public void inicializarPreguntas(String opcion) {

       
            cuestEsterilizacion.setHcecenfermo(opcion);
            cuestEsterilizacion.setHcecenfergrav(opcion);
            cuestEsterilizacion.setHcecoperado(opcion);
            cuestEsterilizacion.setHcectransfusion(opcion);
            cuestEsterilizacion.setHcecpresionalta(opcion);
            cuestEsterilizacion.setHcecejercicio(opcion);
            cuestEsterilizacion.setHcecpalpitacion(opcion);
            cuestEsterilizacion.setHcecsoplo(opcion);
            cuestEsterilizacion.setHcecasma(opcion);
            cuestEsterilizacion.setHcectos(opcion);
            cuestEsterilizacion.setHcecgripa(opcion);
            cuestEsterilizacion.setHcecfuma(opcion);
            cuestEsterilizacion.setHcecprobanestesia(opcion);
            cuestEsterilizacion.setHcecalergia(opcion);
            cuestEsterilizacion.setHcecdrogas(opcion);
            cuestEsterilizacion.setHcecconvulsion(opcion);
            cuestEsterilizacion.setHcecenfermental(opcion);
            cuestEsterilizacion.setHcecdiabetes(opcion);
            cuestEsterilizacion.setHcechepatitis(opcion);
            cuestEsterilizacion.setHcecotraenfer(opcion);
            cuestEsterilizacion.setHcecembarazo(opcion);
            cuestEsterilizacion.setHcecmesnorm(opcion);
            cuestEsterilizacion.setHcecmetplan(opcion);
            cuestEsterilizacion.setHcecinfomet(opcion);
            cuestEsterilizacion.setHcecmetdef(opcion);
            cuestEsterilizacion.setHcecligfalla(opcion);
            cuestEsterilizacion.setHcecinsester(opcion);
            cuestEsterilizacion.setHcecutilmetplan(opcion);
        

    }
    
    
    public void setHcecesparto(ValueChangeEvent valueChangeEvent) {
         cuestEsterilizacion.setHcecesparto((String)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
         }
         
         
    public void changeParto(){
    renderFechaParto = false; 
        if(cuestEsterilizacion!= null && cuestEsterilizacion.getHcecesparto()!= null && !cuestEsterilizacion.getHcecesparto().equals("X")){
            renderFechaParto = true;         
        }
    }

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public String guardarCuestionario() {
    boolean wexito = true;

        // pregunta 1

        if (cuestEsterilizacion.getHcecanenfermo() == null || 
            cuestEsterilizacion.getHcecanenfermo().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecenfermo() != null && 
                (cuestEsterilizacion.getHcecenfermo().equals("S") || 
                 cuestEsterilizacion.getHcecenfermo().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanenfermo", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }


        // pregunta 2
        if (cuestEsterilizacion.getHcecanenfergrav() == null || 
            cuestEsterilizacion.getHcecanenfergrav().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecenfergrav() != null && 
                (cuestEsterilizacion.getHcecenfergrav().equals("S") || 
                 cuestEsterilizacion.getHcecenfergrav().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanenfergrav", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 3
        if (cuestEsterilizacion.getHcecanoperado() == null || 
            cuestEsterilizacion.getHcecanoperado().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecoperado() != null && 
                (cuestEsterilizacion.getHcecoperado().equals("S") || 
                 cuestEsterilizacion.getHcecoperado().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanoperado", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 4  
        if (cuestEsterilizacion.getHcecantransfusion() == null || 
            cuestEsterilizacion.getHcecantransfusion().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcectransfusion() != null && 
                (cuestEsterilizacion.getHcectransfusion().equals("S") || 
                 cuestEsterilizacion.getHcectransfusion().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecantransfusion", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 5    

        if (cuestEsterilizacion.getHcecanpresionalta() == null || 
            cuestEsterilizacion.getHcecanpresionalta().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecpresionalta() != null && 
                (cuestEsterilizacion.getHcecpresionalta().equals("S") || 
                 cuestEsterilizacion.getHcecpresionalta().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanpresionalta", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 6
        if (cuestEsterilizacion.getHcecanejercicio() == null || 
            cuestEsterilizacion.getHcecanejercicio().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecejercicio() != null && 
                (cuestEsterilizacion.getHcecejercicio().equals("S") || 
                 cuestEsterilizacion.getHcecejercicio().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanejercicio", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 7
        if (cuestEsterilizacion.getHcecanpalpitacion() == null || 
            cuestEsterilizacion.getHcecanpalpitacion().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecpalpitacion() != null && 
                (cuestEsterilizacion.getHcecpalpitacion().equals("S") || 
                 cuestEsterilizacion.getHcecpalpitacion().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanpalpitacion", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 8
        if (cuestEsterilizacion.getHcecansoplo() == null || 
            cuestEsterilizacion.getHcecansoplo().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecsoplo() != null && 
                (cuestEsterilizacion.getHcecsoplo().equals("S") || 
                 cuestEsterilizacion.getHcecsoplo().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecansoplo", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 9
        if (cuestEsterilizacion.getHcecanasma() == null || 
            cuestEsterilizacion.getHcecanasma().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecasma() != null && 
                (cuestEsterilizacion.getHcecasma().equals("S") || 
                 cuestEsterilizacion.getHcecasma().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanasma", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }

        }

        // pregunta 10
        if (cuestEsterilizacion.getHcecantos() == null || 
            cuestEsterilizacion.getHcecantos().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcectos() != null && 
                (cuestEsterilizacion.getHcectos().equals("S") || 
                 cuestEsterilizacion.getHcectos().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecantos", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }

        }

        // pregunta 11
        if (cuestEsterilizacion.getHcecangripa() == null || 
            cuestEsterilizacion.getHcecangripa().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecgripa() != null && 
                (cuestEsterilizacion.getHcecgripa().equals("S") || 
                 cuestEsterilizacion.getHcecgripa().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecangripa", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 12
        if (cuestEsterilizacion.getHcecanfuma() == null || 
            cuestEsterilizacion.getHcecanfuma().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecfuma() != null && 
                (cuestEsterilizacion.getHcecfuma().equals("S") || 
                 cuestEsterilizacion.getHcecfuma().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanfuma", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 13
        if (cuestEsterilizacion.getHcecanprobanestesia() == null || 
            cuestEsterilizacion.getHcecanprobanestesia().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecprobanestesia() != null && 
                (cuestEsterilizacion.getHcecprobanestesia().equals("S") || 
                 cuestEsterilizacion.getHcecprobanestesia().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanprobanestesia", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 14
        if (cuestEsterilizacion.getHcecanalergia() == null || 
            cuestEsterilizacion.getHcecanalergia().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecalergia() != null && 
                (cuestEsterilizacion.getHcecalergia().equals("S") || 
                 cuestEsterilizacion.getHcecalergia().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanalergia", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 15
        if (cuestEsterilizacion.getHcecandrogas() == null || 
            cuestEsterilizacion.getHcecandrogas().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecdrogas() != null && 
                (cuestEsterilizacion.getHcecdrogas().equals("S") || 
                 cuestEsterilizacion.getHcecdrogas().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecandrogas", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 16
        if (cuestEsterilizacion.getHcecanconvulsion() == null || 
            cuestEsterilizacion.getHcecanconvulsion().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecconvulsion() != null && 
                (cuestEsterilizacion.getHcecconvulsion().equals("S") || 
                 cuestEsterilizacion.getHcecconvulsion().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanconvulsion", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 17
        if (cuestEsterilizacion.getHcecanenfermental() == null || 
            cuestEsterilizacion.getHcecanenfermental().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecenfermental() != null && 
                (cuestEsterilizacion.getHcecenfermental().equals("S") || 
                 cuestEsterilizacion.getHcecenfermental().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanenfermental", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 18
        if (cuestEsterilizacion.getHcecandiabetes() == null || 
            cuestEsterilizacion.getHcecandiabetes().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecdiabetes() != null && 
                (cuestEsterilizacion.getHcecdiabetes().equals("S") || 
                 cuestEsterilizacion.getHcecdiabetes().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecandiabetes", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 19
        if (cuestEsterilizacion.getHcecanhepatitis() == null || 
            cuestEsterilizacion.getHcecanhepatitis().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcechepatitis() != null && 
                (cuestEsterilizacion.getHcechepatitis().equals("S") || 
                 cuestEsterilizacion.getHcechepatitis().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanhepatitis", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 20
        if (cuestEsterilizacion.getHcecanotraenfer() == null || 
            cuestEsterilizacion.getHcecanotraenfer().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecotraenfer() != null && 
                (cuestEsterilizacion.getHcecotraenfer().equals("S") || 
                 cuestEsterilizacion.getHcecotraenfer().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanotraenfer", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 21
        if (cuestEsterilizacion.getHcecanembarazo() == null || 
            cuestEsterilizacion.getHcecanembarazo().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecembarazo() != null && 
                (cuestEsterilizacion.getHcecembarazo().equals("S") || 
                 cuestEsterilizacion.getHcecembarazo().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanembarazo", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 22
        if (cuestEsterilizacion.getHcecanmesnorm() == null || 
            cuestEsterilizacion.getHcecanmesnorm().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecmesnorm() != null && 
                (cuestEsterilizacion.getHcecmesnorm().equals("N") || 
                 cuestEsterilizacion.getHcecmesnorm().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanmesnorm", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }


        // pregunta 25
        if (cuestEsterilizacion.getHcecaninfomet() == null || 
            cuestEsterilizacion.getHcecaninfomet().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecinfomet() != null && 
                (cuestEsterilizacion.getHcecinfomet().equals("N") || 
                 cuestEsterilizacion.getHcecinfomet().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecaninfomet", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 26
        if (cuestEsterilizacion.getHcecanmetdef() == null || 
            cuestEsterilizacion.getHcecanmetdef().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecmetdef() != null && 
                (cuestEsterilizacion.getHcecmetdef().equals("N") || 
                 cuestEsterilizacion.getHcecmetdef().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanmetdef", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }

        // pregunta 27
        if (cuestEsterilizacion.getHcecanligfalla() == null || 
            cuestEsterilizacion.getHcecanligfalla().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecligfalla() != null && 
                (cuestEsterilizacion.getHcecligfalla().equals("N") || 
                 cuestEsterilizacion.getHcecligfalla().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecanligfalla", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }
        
        // pregunta 28
        if (cuestEsterilizacion.getHcecaninsester() == null || 
            cuestEsterilizacion.getHcecaninsester().equals("")) {
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecinsester() != null && 
                (cuestEsterilizacion.getHcecinsester().equals("N") || 
                 cuestEsterilizacion.getHcecinsester().equals(""))) {
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:ithcecaninsester", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
        }
        
        if(cuestEsterilizacion.getHcedfechultmes() == null){
            FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:fechaUltimaMens", 
                                       MSG_CAMPO_OBLIGATORIO);
            wexito = false;
        }
        
        if(cuestEsterilizacion.getHcedfechaparto()!= null){
            if(cuestEsterilizacion.getHcecesparto()== null || 
                cuestEsterilizacion.getHcecesparto().equals("")){
                FacesUtils.addErrorMessage("body:formEsterFem:panelTabEstFem:hcecesparto", 
                                           MSG_PREGUNTA_OBLIGATORIA);
                wexito = false;
            }
            
        }
    

        navigationRule = "";
        Long numeroConsulta = null;
        
        if(wexito){
        
            if (consulta != null && consulta.getCconnumero() != null) {
                numeroConsulta = new Long(consulta.getCconnumero());
            }
            
            if (cuestEsterilizacion != null && 
                cuestEsterilizacion.getHcecesparto() != null && cuestEsterilizacion.getHcecesparto().equals("X")) {
              cuestEsterilizacion.setHcedfechaparto(null);
            }
            

                    cuestEsterilizacion.getComp_id().setHcectiposerv(TIPO_CONSULTA);
                    cuestEsterilizacion.getComp_id().setHcelconsulta(numeroConsulta);
                    cuestEsterilizacion.setHcecoperador(userName());
                    cuestEsterilizacion.setHcedfecreg(new Date());


                    if (cuestEsterilizacion!= null && cuestEsterilizacion.getHcecfuma() != null && 
                    cuestEsterilizacion.getHcecfuma().equalsIgnoreCase("S"))
                        cuestEsterilizacion.setHcecnocigarrillo(fumadia);
                        
            try {

                this.serviceLocator.getClinicoService().saveCuestionarioEsterilizacion(cuestEsterilizacion);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;

            } catch (ModelException e) {
                e.printStackTrace();
                navigationRule = "";
            }
            
        }        
         // Se establece la siguiente accion de navegacion
        return navigationRule;

    }
    
    
    public String siguiente() {
    if(esValido()){
        generoConsentimiento = false; 
        return nextAction;
    }
          return null;       
        }
    
    //-----------------------------------------------------------------------
    //  Jasper Report
    //-----------------------------------------------------------------------
    
    public boolean next() {
        index++;
        return (index < lstReporte.size());
        }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        } else if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        } else if (fieldName.equals("DIRECCION")) {
            value = DIRECCION;
        } else if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        } else if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        } else if (fieldName.equals("ESTADO_CIVIL")) {
            value = ESTADO_CIVIL;
        } else if (fieldName.equals("PARENTESCO_RESPONSABLE")) {
            value = PARENTESCO_RESPONSABLE;
        } else if (fieldName.equals("SEXO")) {
            value = SEXO;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("TELEFONO_RESPONSABLE")) {
            value = TELEFONO_RESPONSABLE;
        } else if (fieldName.equals("FECHA")) {
            value = new Date();
        } else if (fieldName.equals("IMPRIMIO")) {
            value = IMPRIMIO;
        } else if (fieldName.equals("TIPO")) {
            value = lstReporte.get(index).getHrencodigo();
        } else if (fieldName.equals("DESCRIPCION")) {
            value = lstReporte.get(index).getHrecdescripcio();
        } else if (fieldName.equals("DESCRIPCION2")) {
            value = lstReporte.get(index).getHrecdescripcio2();
        } else if (fieldName.equals("DESCRIPCION3")) {
            value = lstReporte.get(index).getHrecdescripcio3();
        } else if (fieldName.equals("DESCRIPCION4")) {
            value = lstReporte.get(index).getHrecdescripcio4();
        } else if (fieldName.equals("DESCRIPCION5")) {
            value = lstReporte.get(index).getHrecdescripcio5();
        } else if (fieldName.equals("TIPO_DES")) {
            value = lstReporte.get(index).getHrectipodescri();
        } else if (fieldName.equals("TIPO_IMPRESION")) {
            value = lstReporte.get(index).getHrentipoimpres();
        } else if (fieldName.equals("NUMERO_CONSULTA")) {
            value = lstReporte.get(index).getHrenconsulta();
        }  else if (fieldName.equals("FECHA_REGISTRO")) {
            value = lstReporte.get(index).getHredfecharegis();
        }
        return value;
    }
    
    public void obtenerDatosReporte() {
        // Obtenemos los datos del usuario 
        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();
                if (FECHA_NACIMIENTO != null) {
                    int edad = calcularEdad(FECHA_NACIMIENTO, new Date());
                    EDAD = edad;
                }

            }


            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }
            if (getClinica() != null) {
                CENTRO = this.getClinica().getCclcnombre();
            }


            if (usuario.getHuscprimernomb() != null) {
                NOMBRE = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE = NOMBRE + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE = NOMBRE + usuario.getHuscsegundapel();
            }
            if (usuario.getHusanumeiden() != null && 
                usuario.getHusanumeiden() != 0) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden();
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }

            SEXO = usuario.getHusesexo();
            DIRECCION = usuario.getHuscdireccion();
            TELEFONO = usuario.getHusctelefono();
            Integer idCiudad = usuario.getHusnciudad();
            Integer idDepartamento = usuario.getHusndepartamen();
            Cpmunidane ciudadObject = null;

            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();

            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomresponsa();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelresponsa();
        }
        
        if(cuestEsterilizacion!= null){
            HCECENFERMO = formatearCampo(cuestEsterilizacion.getHcecenfermo()); 
            HCECENFERGRAV  = formatearCampo(cuestEsterilizacion.getHcecenfergrav()); 
            HCECOPERADO  = formatearCampo(cuestEsterilizacion.getHcecoperado()); 
            HCECTRANSFUSION  = formatearCampo(cuestEsterilizacion.getHcectransfusion()); 
            HCECPRESIONALTA  = formatearCampo(cuestEsterilizacion.getHcecpresionalta()); 
            HCECEJERCICIO  = formatearCampo(cuestEsterilizacion.getHcecejercicio()); 
            HCECPALPITACION  = formatearCampo(cuestEsterilizacion.getHcecpalpitacion()); 
            HCECSOPLO  = formatearCampo(cuestEsterilizacion.getHcecsoplo()); 
            HCECASMA  = formatearCampo(cuestEsterilizacion.getHcecasma()); 
            HCECTOS  = formatearCampo(cuestEsterilizacion.getHcectos()); 
            HCECGRIPA  = formatearCampo(cuestEsterilizacion.getHcecgripa()); 
            HCECFUMA  = formatearCampo(cuestEsterilizacion.getHcecfuma()); 
            HCECPROBANESTESIA  = formatearCampo(cuestEsterilizacion.getHcecprobanestesia()); 
            HCECALERGIA  = formatearCampo(cuestEsterilizacion.getHcecalergia()); 
            HCECDROGAS  = formatearCampo(cuestEsterilizacion.getHcecdrogas()); 
            HCECCONVULSION  = formatearCampo(cuestEsterilizacion.getHcecconvulsion()); 
            HCECENFERMENTAL  = formatearCampo(cuestEsterilizacion.getHcecenfermental()); 
            HCECDIABETES  = formatearCampo(cuestEsterilizacion.getHcecdiabetes()); 
            HCECHEPATITIS  = formatearCampo(cuestEsterilizacion.getHcechepatitis()); 
            HCECOTRAENFER = formatearCampo(cuestEsterilizacion.getHcecotraenfer()); 
            HCECEMBARAZO  = formatearCampo(cuestEsterilizacion.getHcecembarazo()); 
            HCEDFECHULTMES  = formatearCampo(cuestEsterilizacion.getHcedfechultmes()); 
            HCECUTILMETPLAN  = formatearCampo(cuestEsterilizacion.getHcecutilmetplan()); 
            HCEDFECHAPARTO  = formatearCampo(cuestEsterilizacion.getHcedfechaparto()); 
            HCECINFOMET  = formatearCampo(cuestEsterilizacion.getHcecinfomet()); 
            HCECMETDEF  = formatearCampo(cuestEsterilizacion.getHcecmetdef());
            HCECLIGFALLA = 
                    formatearCampo(cuestEsterilizacion.getHcecligfalla());
            HCECINSESTER = 
                    formatearCampo(cuestEsterilizacion.getHcecinsester());

            HCECANENFERMO = 
                    formatearCampo(cuestEsterilizacion.getHcecanenfermo());
            HCECANENFERGRAV = 
                    formatearCampo(cuestEsterilizacion.getHcecanenfergrav());
            HCECANOPERADO = 
                    formatearCampo(cuestEsterilizacion.getHcecanoperado());
            HCECANTRANSFUSION = 
                    formatearCampo(cuestEsterilizacion.getHcecantransfusion());
            HCECANPRESIONALTA = 
                    formatearCampo(cuestEsterilizacion.getHcecanpresionalta());
            HCECANEJERCICIO = 
                    formatearCampo(cuestEsterilizacion.getHcecanejercicio());
            HCECANPALPITACION = 
                    formatearCampo(cuestEsterilizacion.getHcecanpalpitacion());
            HCECANSOPLO = formatearCampo(cuestEsterilizacion.getHcecansoplo());
            HCECANASMA = formatearCampo(cuestEsterilizacion.getHcecanasma());
            HCECANTOS = formatearCampo(cuestEsterilizacion.getHcecantos());
            HCECANGRIPA = formatearCampo(cuestEsterilizacion.getHcecangripa());
            HCECANFUMA = formatearCampo(cuestEsterilizacion.getHcecanfuma());
            HCECANPROBANESTESIA = 
                    formatearCampo(cuestEsterilizacion.getHcecanprobanestesia());
            HCECANALERGIA = 
                    formatearCampo(cuestEsterilizacion.getHcecanalergia());
            HCECANDROGAS = 
                    formatearCampo(cuestEsterilizacion.getHcecandrogas());
            HCECANCONVULSION = 
                    formatearCampo(cuestEsterilizacion.getHcecanconvulsion());
            HCECANENFERMENTAL = 
                    formatearCampo(cuestEsterilizacion.getHcecanenfermental());
            HCECANDIABETES = 
                    formatearCampo(cuestEsterilizacion.getHcecandiabetes());
            HCECANHEPATITIS = 
                    formatearCampo(cuestEsterilizacion.getHcecanhepatitis());
            HCECANOTRAENFER = 
                    formatearCampo(cuestEsterilizacion.getHcecanotraenfer());
            HCECANEMBARAZO = 
                    formatearCampo(cuestEsterilizacion.getHcecanembarazo());
            HCECANMESNORM = 
                    formatearCampo(cuestEsterilizacion.getHcecanmesnorm());
            HCECANMETPLAN = 
                    formatearCampo(cuestEsterilizacion.getHcecanmetplan());
            HCECANINFOMET = 
                    formatearCampo(cuestEsterilizacion.getHcecaninfomet());
            HCECANMETDEF = 
                    formatearCampo(cuestEsterilizacion.getHcecanmetdef());
            HCECANLIGFALLA = 
                    formatearCampo(cuestEsterilizacion.getHcecanligfalla());
            HCECANINSESTER = 
                    formatearCampo(cuestEsterilizacion.getHcecaninsester());
            HCECMESNORM = formatearCampo(cuestEsterilizacion.getHcecmesnorm());  
            
            if(cuestEsterilizacion!= null && cuestEsterilizacion.getHcecesparto()!= null){
                if(cuestEsterilizacion.getHcecesparto().equals("P")){
                    HCECESPARTO = "Parto"; 
                }else if(cuestEsterilizacion.getHcecesparto().equals("A")){{
                    HCECESPARTO = "Aborto"; 
                }
                    
                }
            }
            
            if(cuestEsterilizacion!= null && cuestEsterilizacion.getHcecmetplan()!=null){
                try {
                  HCECMETPLAN =   this.serviceLocator.getClinicoService().getDescripcionMetodo(cuestEsterilizacion.getHcecmetplan());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }else{
                HCECMETPLAN = ""; 
            }
            
            if(HCECMETPLAN!=null){
               HCECMETPLAN =  HCECMETPLAN.trim(); 
            }

        }
        
        HCECOBSERV = formatearCampo(cuestEsterilizacion.getHcecobserv()); 

    }


        
    public void generarConsentimiento() {
        this.index = -1;
        setDatos();

        try {
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/cuestionarioEsterilizacion.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                

                byte[] bytes;
                
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                
                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "EsterilizacionFemenina" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoConsentimiento = true;
            

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void setDatos() {
        obtenerDatosReporte();
        lstReporte = new ArrayList<Chreporte>();

        if (cuestEsterilizacion != null) {


            Chreporte report = new Chreporte();
            String s = "";
            String s2 = "";
            String s3 = ""; 
            String s4 = ""; 
            s = "";
            s = "1.  Se siente Usted actualmente enferma? ";
            s2  = HCECENFERMO; 
            s3 = HCECANENFERMO; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            
            s = "2.  Ha tenido enfermedades graves en el pasado? ";
            s2  = HCECENFERGRAV;
            s3 = HCECANENFERGRAV; 
 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            s = "3.  Ha sido operada o anestesiada alguna vez?";
            s2  = HCECOPERADO;
            s3 = HCECANOPERADO; 
    
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            s = "4.  Ha recibido transfusiones de sangre?";
            s2  = HCECTRANSFUSION;
            s3 = HCECANTRANSFUSION; 
             report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            s = "5.  Ha tenido o tiene la presion arterial alta?"; 
            s2 = HCECPRESIONALTA; 
            s3 = HCECANPRESIONALTA; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            
      
            s = "6.  Al hacer ejercicio o subir escaleras siente usted: palpitaciones, ahogo o  dolor en el pecho?"; 
            s2 = HCECEJERCICIO; 
            s3 = HCECANEJERCICIO; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            

            s = "7.  Ha tenido alguna vez palpitaciones, dolor en el pecho o taquicardia?"; 
            s2 = HCECPALPITACION; 
            s3 = HCECANPALPITACION; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            s = "8.  Alguna vez en un examen medico le han encontrado un soplo en el corazon?"; 
            s2 = HCECSOPLO; 
            s3 = HCECANSOPLO; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            

            s = "9.  Ha tenido o tiene asma o bronquitis?"; 
            s2 = HCECASMA; 
            s3 = HCECANASMA; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
   
            s = "10. Tose con frecuencia?"; 
            s2 = HCECTOS; 
            s3 = HCECANTOS; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "11. Tiene actualmente gripa?"; 
            s2 = HCECGRIPA; 
            s3 = HCECANGRIPA; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "12. Usted fuma o fumo?"; 
            s2 = HCECFUMA;
            if(cuestEsterilizacion!= null && cuestEsterilizacion.getHcecfuma() != null && cuestEsterilizacion.getHcecfuma() .equals("S")){
                s3 = "Cuantos al dia: "+fumadia;    
            }else{
                s3 = ""; 
            }
            
            s4 = HCECANFUMA; 
             
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrecdescripcio4(s4);
            report.setHrentipoimpres(4                 );
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            

            s = "13. Ha tenido Usted o algun familiar problemas cuando han recibido anestesia?"; 
            s2 = HCECPROBANESTESIA; 
            s3 = HCECANPROBANESTESIA; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            s = "14. Ha tenido o tiene alergia a alguna droga?"; 
            s2 = HCECALERGIA; 
            s3 = HCECANALERGIA; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "15. Ha tomado alguna droga en los ultimos 6 meses?"; 
            s2 = HCECDROGAS; 
            s3 = HCECANDROGAS; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            s = "16. Ha tenido alguna vez una convulsion? (Epilepsia)"; 
            s2 = HCECCONVULSION; 
            s3 = HCECANCONVULSION; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "17. Ha tenido o tiene enfermedades mentales?"; 
            s2 = HCECENFERMENTAL; 
            s3 = HCECANENFERMENTAL; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "18. Ha tenido o tiene diabetes o hipoglicemia? (Problemas con los niveles de azucar en la sangre)"; 
            s2 = HCECDIABETES; 
            s3 = HCECANDIABETES; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "19. Ha tenido hepatitis?"; 
            s2 = HCECHEPATITIS; 
            s3 = HCECANHEPATITIS; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "20. Ha tenido o tiene otra enfermedad o alteracion en su salud no  mencionada anteriormente?"; 
            s2 = HCECOTRAENFER; 
            s3 = HCECANOTRAENFER; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "21. Piensa Usted que esta embarazada?"; 
            s2 = HCECEMBARAZO; 
            s3 = HCECANEMBARAZO; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            

            s = "22. Fecha de la ultima menstruaci�n "; 
            s2 = HCEDFECHULTMES; 
            s3 ="Fue normal? " + HCECMESNORM; 
            s4 = HCECANMESNORM; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrecdescripcio4(s4);
            report.setHrentipoimpres(4);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            s = "23. Usted o su pareja utiliza(n) actualmente alg�n m�todo de planificaci�n? " +HCECUTILMETPLAN; 
            if(cuestEsterilizacion!= null && cuestEsterilizacion.getHcecutilmetplan()!= null && cuestEsterilizacion.getHcecutilmetplan().equals("S")){
                s2 = "Cual? " + formatearCampo(HCECMETPLAN); 
            }else{
                s2 = ""; 
            }
            
            s3 = HCECANMETPLAN; 
            
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrecdescripcio4(s4);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
      
            s = "24. Fecha del ultimo parto/aborto"; 
            s2 = HCEDFECHAPARTO; 
            
            

                                if (cuestEsterilizacion != null && 
                                    cuestEsterilizacion.getHcecesparto() != null) {
                                    if (cuestEsterilizacion.getHcecesparto().equals("P")) {
                                        HCECESPARTO = "Parto";
                                    } else if (cuestEsterilizacion.getHcecesparto().equals("A")) {
                                                HCECESPARTO = "Aborto";               
                                    }else if (cuestEsterilizacion.getHcecesparto().equals("X")) {
                                                HCECESPARTO = "Ninguno";               
                                    }
                                }
            
            if(cuestEsterilizacion.getHcecesparto()!= null){
                s3 = "Fue? " + HCECESPARTO; 
            }else{
                s3 = ""; 
            }
            
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(5);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
    
            s = "25. Recibio Usted informacion o asesoria sobre los metodos temporales de planificacion?"; 
            s2 = HCECINFOMET; 
            s3 = HCECANINFOMET; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
 
            s = "26. Sabe usted que la ligadura de trompas es un metodo definitivo de planificacion?"; 
            s2 = HCECMETDEF; 
            s3 = HCECANMETDEF; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            s = "27. Sabe usted que la ligadura de trompas puede fallar en una de cada 500 mujeres operadas?"; 
            s2 = HCECLIGFALLA; 
            s3 = HCECANLIGFALLA; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            

            s = "28. Recibio Usted las instrucciones y el consentimiento informado para esterilizacion femenina?"; 
            s2 = HCECINSESTER; 
            s3 = HCECANINSESTER; 
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrecdescripcio3(s3);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Cuestionario Esterilizacion");
            report.setHrencodigo(1);
            report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
            report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
            lstReporte.add(report);
            
            
            if(cuestEsterilizacion.getHcecobserv()!= null){
                s = "OBSERVACIONES ADICIONALES" ; 
               
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(7);
                report.setHrectipodescri("Cuestionario Esterilizacion");
                report.setHrencodigo(1);
                report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
                report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
                lstReporte.add(report);
                
                
                s = HCECOBSERV; 
                
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(7);
                report.setHrectipodescri("Cuestionario Esterilizacion");
                report.setHrencodigo(1);
                report.setHrenconsulta(cuestEsterilizacion.getComp_id().getHcelconsulta());
                report.setHredfecharegis(cuestEsterilizacion.getHcedfecreg());
                lstReporte.add(report);
            }


        }


        if (lstReporte == null || lstReporte.isEmpty()) {

            Chreporte report = new Chreporte();
            String s = "No se encontrar�n Registros  ";

            report.setHrecdescripcio(s);
            report.setHrencodigo(0);
            lstReporte.add(report);

        }
    }


    // ACCESSORS

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

    public void changeFumar() {

        if (cuestEsterilizacion!= null && cuestEsterilizacion.getHcecfuma() != null) {
            if (cuestEsterilizacion.getHcecfuma().equalsIgnoreCase("S")) {
                this.mostrarFumar = true;
            } else {
                this.mostrarFumar = false;
            }
        }

    }


    public void changeMetodoPlan() {

        if (cuestEsterilizacion != null && cuestEsterilizacion.getHcecutilmetplan()!= null) {
            if (cuestEsterilizacion.getHcecutilmetplan().equalsIgnoreCase("S")) {
                this.mostrarMetodoPlan = true;
            } else {
                this.mostrarMetodoPlan = false;
            }
        }

    }


    /**
     * @param lstMetodo
     */
    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    /**
     * @return
     */
    public List getLstMetodo() {
        if (lstMetodo.size() == 0) {
            ArrayList<Chmetodoplan> lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodoAux.isEmpty()) {

                Iterator it = lstMetodoAux.iterator();
                int i = 0;
                lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMetodo.add(new SelectItem(lstMetodoAux.get(i).getHmpccodigo(), 
                                                 lstMetodoAux.get(i).getHmpcdescripcio()));
                    i++;
                }

            }
        }

        return lstMetodo;
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
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
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
     * @param cuestEsterilizacion
     */
    public void setCuestEsterilizacion(Chcuestester cuestEsterilizacion) {
        this.cuestEsterilizacion = cuestEsterilizacion;
    }

    /**
     * @return
     */
    public Chcuestester getCuestEsterilizacion() {
        return cuestEsterilizacion;
    }


    /**
     * @param mostrarFumar
     */
    public void setMostrarFumar(boolean mostrarFumar) {
        this.mostrarFumar = mostrarFumar;
    }

    /**
     * @return
     */
    public boolean isMostrarFumar() {
        return mostrarFumar;
    }

    /**
     * @param fumadia
     */
    public void setFumadia(Integer fumadia) {
        this.fumadia = fumadia;
    }

    /**
     * @return
     */
    public Integer getFumadia() {
        return fumadia;
    }

    /**
     * @param valueChangeEvent
     */
    public void setFuma(ValueChangeEvent valueChangeEvent) {
        cuestEsterilizacion.setHcecfuma((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param mostrarMetodoPlan
     */
    public void setMostrarMetodoPlan(boolean mostrarMetodoPlan) {
        this.mostrarMetodoPlan = mostrarMetodoPlan;
    }

    /**
     * @return
     */
    public boolean isMostrarMetodoPlan() {
        return mostrarMetodoPlan;
    }

    /**
     * @param valueChangeEvent
     */
    public void setMetodoPlan(ValueChangeEvent valueChangeEvent) {
        cuestEsterilizacion.setHcecutilmetplan((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param generoConsentimiento
     */
    public void setGeneroConsentimiento(boolean generoConsentimiento) {
        this.generoConsentimiento = generoConsentimiento;
    }

    /**
     * @return
     */
    public boolean isGeneroConsentimiento() {
        return generoConsentimiento;
    }


    public void setRenderFechaParto(boolean renderFechaParto) {
        this.renderFechaParto = renderFechaParto;
    }

    public boolean isRenderFechaParto() {
        return renderFechaParto;
    }
}

