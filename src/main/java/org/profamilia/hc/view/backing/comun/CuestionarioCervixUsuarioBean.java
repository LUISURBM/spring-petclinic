//=======================================================================
// ARCHIVO CuestionarioCervixUsuarioBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes al cuestionario de Cervix
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import org.profamilia.hc.model.dto.Chcancecervi;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;



//=================================================================
//  CLASE CuestionarioCervixUsuarioBean
//=======================================================================

 /**
  * CuestionarioCervixUsuarioBean: Permite registrar los Datos correspondientes al cuestionario de Cervix
  * @author Jos� Andr�s Riano jariano@profamilia.org.co
  * 
  */
public class CuestionarioCervixUsuarioBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chcancecervi cuestionarioCervix;

    private String menuBean;

    private String nextAction;

    private Cnconsclin consulta;

    private Chusuario usuario;

    private String tipoServicio;

    private List lstOpciones;

    private String navigationRule;
    
    private String REGISTRO_MEDICO; 
     
    private List lstContacto;

    private static int NUMERO_COPIAS = 1;

    private boolean generoCuestionario;

    private boolean renderCualResul;

    private boolean renderFechaParto;
    
    private boolean renderContacto; 

    private int index = -1;

    private UIInput mnutieneparto;

    private UIInput mnuanormcitol;

    private UIInput mnuasesocancer;

    private UIInput mnurecompreve;

    private UIInput mnuvphcomppre;

    private UIInput mnuotrostipos;

    private UIInput mnucienvirus;
    private UIInput mnudosvacucol;
    private UIInput mnuvphcausant;
    private UIInput mnutresdosis;
    private UIInput mnuinfocerva;
    private UIInput mnuantecalerg;
    private UIInput mnureacivacun;
    private UIInput mnuenfergripa;
    private UIInput mnuestaembar;
    private UIInput mnumestrnorma;
    private UIInput mnumetodplani;
    private UIInput mnupiensembar;
    private UIInput mnumediahora;
    private UIInput mnuinforconse;
    private UIInput mnuconsuprofa;
    private UIInput mnugardasil; 

    // Datos del Reporte

    String NOMBRE_USUARIO;
    Long NUMERO_DOCUMENTO;
    String TIPO_DOCUMENTO;
    Date FECHA;
    String CENTRO;
    String NOMBRE_PROFESIONAL;
    String ASESOCANCE;
    String RECOMPREVE;
    String VPHCOMPPRE;
    String OTROSTIPOS;
    String CIENVIRUS;
    String DOSVACUCOL;
    String VPHCAUSANT;
    String TRESDOSIS;
    String INFOCERVA;
    String ANORMCITOL;
    String ANTECALERG;
    String REACIVACUN;
    String ENFERGRIPA;
    String ESTAEMBAR;
    String AMAMANTAND;
    String MESTRNORMA;
    String TIENEPARTO;
    String METODPLANI;
    String PIENSEMBAR;
    String MEDIAHORA;
    String INFORCONSE;
    String CONSUPROFA;
    Date FUR;
    Date FUP;
    String CUALANORMALIDAD;
    String INFORGARDA; 
    
    private Boolean renderFemenino; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------
    public CuestionarioCervixUsuarioBean() {
    }


    public void init() {
        generoCuestionario = false;
    }
    //ACTIONS
    public void inicializarCuestionario() {
        Long numeroConsulta = null;
        generoCuestionario = false;
        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }

        if (numeroConsulta != null) {

            try {
                cuestionarioCervix = 
                        this.getServiceLocator().getClinicoService().getCuestionarioCervix(numeroConsulta, 
                                                                                           TIPO_CONSULTA);

            } catch (ModelException e) {
                e.printStackTrace();
            }

        }

        if (cuestionarioCervix == null) {
            cuestionarioCervix = new Chcancecervi();
            
        } else {
            if (cuestionarioCervix.getHcccanormcitol() != null && 
                cuestionarioCervix.getHcccanormcitol().equals("S")) {
                renderCualResul = true;
            } else {
                renderCualResul = false;
            }

            if (cuestionarioCervix.getHccctieneparto() != null && 
                cuestionarioCervix.getHccctieneparto().equals("S")) {
                renderFechaParto = true;
            } else {
                renderFechaParto = false;
            }

           
        }
    }


    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        Long numero;
        numero = null;
        Chcancecervi cervixAux = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            numero = new Long(consulta.getCconnumero());
        }

        if (numero != null) {
            try {
                cervixAux = 
                        this.getServiceLocator().getClinicoService().getCuestionarioCervix(numero, 
                                                                                           TIPO_CONSULTA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (cervixAux != null) {
            return true;
        }

        return false;
    }

    


    //-----------------------------------------------------------------------
    //  Reporte Jasper
    //-----------------------------------------------------------------------

    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }


    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE_USUARIO")) {
            value = NOMBRE_USUARIO;
        }
        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        }
        if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        }
        if (fieldName.equals("FECHA")) {
            value = FECHA;
        }
        if (fieldName.equals("CENTRO")) {
            value = CENTRO;
        }
        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
        }

        if (fieldName.equals("ASESOCANCE")) {
            value = ASESOCANCE;
        }
        if (fieldName.equals("RECOMPREVE")) {
            value = RECOMPREVE;
        }
        if (fieldName.equals("VPHCOMPPRE")) {
            value = VPHCOMPPRE;
        }
        if (fieldName.equals("OTROSTIPOS")) {
            value = OTROSTIPOS;
        }
        if (fieldName.equals("CIENVIRUS")) {
            value = CIENVIRUS;
        }
        if (fieldName.equals("DOSVACUCOL")) {
            value = DOSVACUCOL;
        }
        if (fieldName.equals("VPHCAUSANT")) {
            value = VPHCAUSANT;
        }
  
        if (fieldName.equals("TRESDOSIS")) {
            value = TRESDOSIS;
        }
        if (fieldName.equals("INFOCERVA")) {
            value = INFOCERVA;
        }
        if (fieldName.equals("ANORMCITOL")) {
            value = ANORMCITOL;
        }
        if (fieldName.equals("ANTECALERG")) {
            value = ANTECALERG;
        }
        if (fieldName.equals("REACIVACUN")) {
            value = REACIVACUN;
        }
        if (fieldName.equals("ENFERGRIPA")) {
            value = ENFERGRIPA;
        }
        if (fieldName.equals("ESTAEMBAR")) {
            value = ESTAEMBAR;
        }
        if (fieldName.equals("AMAMANTAND")) {
            value = AMAMANTAND;
        }
        if (fieldName.equals("MESTRNORMA")) {
            value = MESTRNORMA;
        }
        if (fieldName.equals("TIENEPARTO")) {
            value = TIENEPARTO;
        }
        if (fieldName.equals("METODPLANI")) {
            value = METODPLANI;
        }
        if (fieldName.equals("PIENSEMBAR")) {
            value = PIENSEMBAR;
        }
        if (fieldName.equals("MEDIAHORA")) {
            value = MEDIAHORA;
        }
        if (fieldName.equals("INFORCONSE")) {
            value = INFORCONSE;
        }
        if (fieldName.equals("CONSUPROFA")) {
            value = CONSUPROFA;
        }
        if (fieldName.equals("FUR")) {
            value = FUR;
        }
        if (fieldName.equals("FUP")) {
            value = FUP;
        }
        if (fieldName.equals("CUALANORMALIDAD")) {
            value = CUALANORMALIDAD;
        }
        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        } if (fieldName.equals("INFORGARDA")) {
            value = INFORGARDA;
        }
        
        
        
        
        
        

        return value;
    }


    public void obtenerDatos() {
    
    
        if (userName() != null) {
            Cpprofesio profesional;
            profesional = null;
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                       getClinica().getCclncodigo());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
            }
        }

        if (usuario != null) {
            if (usuario.getHuscprimernomb() != null) {
                NOMBRE_USUARIO = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRE_USUARIO = 
                        NOMBRE_USUARIO + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                NOMBRE_USUARIO = 
                        NOMBRE_USUARIO + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                NOMBRE_USUARIO = NOMBRE_USUARIO + usuario.getHuscsegundapel();
            }

            if (usuario.getHusanumeiden() != null) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }

            TIPO_DOCUMENTO = usuario.getHusetipoiden();
            if (this.getClinica() != null) {
                CENTRO = this.getClinica().getCclcnombre();
            }

        }
        FECHA = new Date();

        

        if (cuestionarioCervix != null) {
            ASESOCANCE = 
                    formatearCampo(cuestionarioCervix.getHcccasesocance());
            RECOMPREVE = 
                    formatearCampo(cuestionarioCervix.getHcccrecompreve());
            VPHCOMPPRE = 
                    formatearCampo(cuestionarioCervix.getHcccvphcomppre());
            OTROSTIPOS = 
                    formatearCampo(cuestionarioCervix.getHcccotrostipos());
            CIENVIRUS = formatearCampo(cuestionarioCervix.getHccccienvirus());
            DOSVACUCOL = 
                    formatearCampo(cuestionarioCervix.getHcccdosvacucol());
            VPHCAUSANT = 
                    formatearCampo(cuestionarioCervix.getHcccvphcausant());
           
            TRESDOSIS = formatearCampo(cuestionarioCervix.getHccctresdosis());
            INFOCERVA = formatearCampo(cuestionarioCervix.getHcccinfocerva());
            ANORMCITOL = 
                    formatearCampo(cuestionarioCervix.getHcccanormcitol());
            ANTECALERG = 
                    formatearCampo(cuestionarioCervix.getHcccantecalerg());
            REACIVACUN = 
                    formatearCampo(cuestionarioCervix.getHcccreacivacun());
            ENFERGRIPA = 
                    formatearCampo(cuestionarioCervix.getHcccenfergripa());
            ESTAEMBAR = formatearCampo(cuestionarioCervix.getHcccestaembar());
            AMAMANTAND = 
                    formatearCampo(cuestionarioCervix.getHcccamamantand());
            MESTRNORMA = 
                    formatearCampo(cuestionarioCervix.getHcccmestrnorma());
            TIENEPARTO = 
                    formatearCampo(cuestionarioCervix.getHccctieneparto());
            METODPLANI = 
                    formatearCampo(cuestionarioCervix.getHcccmetodplani());
            PIENSEMBAR = 
                    formatearCampo(cuestionarioCervix.getHcccpiensembar());
            MEDIAHORA = formatearCampo(cuestionarioCervix.getHcccmediahora());
            INFORCONSE = 
                    formatearCampo(cuestionarioCervix.getHcccinforconse());
            CONSUPROFA = 
                    formatearCampo(cuestionarioCervix.getHcccconsuprofa());

            CUALANORMALIDAD = cuestionarioCervix.getHccccualresul();
            
            INFORGARDA = formatearCampo(cuestionarioCervix.getHcccinforgarda());

            FUR = cuestionarioCervix.getHccdfecharegla();

            FUP = cuestionarioCervix.getHccdfechaparto();

        }


    }


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------

    public void changeTodosSi() {
     
            renderCualResul = true;
            renderFechaParto = true;
            inicializarPreguntas("S");    
        
    }

    public void changeTodosNo() {
       
        renderCualResul = false;
        renderFechaParto = false;
        inicializarPreguntas("N");
        
    }


    public void changeNinguno() {
      
        renderCualResul = false;
        renderFechaParto = false;
        inicializarPreguntas(null);
        
    }

    public void changeCitologia() {
        if (cuestionarioCervix != null && 
            cuestionarioCervix.getHcccanormcitol() != null && 
            cuestionarioCervix.getHcccanormcitol().equals("S")) {
            renderCualResul = true;
        } else {
            renderCualResul = false;
        }
    }

    public void changeParto() {
        if (cuestionarioCervix != null && 
            cuestionarioCervix.getHccctieneparto() != null && 
            cuestionarioCervix.getHccctieneparto().equals("S")) {
            renderFechaParto = true;
        } else {
            renderFechaParto = false;
        }
    }
    
  

    /**
     * @param valueChangeEvent
     */
    public void setHcccanormcitol(ValueChangeEvent valueChangeEvent) {
        cuestionarioCervix.setHcccanormcitol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHccctieneparto(ValueChangeEvent valueChangeEvent) {
        cuestionarioCervix.setHccctieneparto((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param opcion
     */
    public void inicializarPreguntas(String opcion) {

        
            cuestionarioCervix.setHcccasesocance(opcion);
            cuestionarioCervix.setHcccrecompreve(opcion);
            cuestionarioCervix.setHcccvphcomppre(opcion);
            cuestionarioCervix.setHcccotrostipos(opcion);
            cuestionarioCervix.setHccccienvirus(opcion);
            cuestionarioCervix.setHcccdosvacucol(opcion);
            cuestionarioCervix.setHcccvphcausant(opcion);
            cuestionarioCervix.setHccctresdosis(opcion);
            cuestionarioCervix.setHcccanormcitol(opcion);
            cuestionarioCervix.setHcccinfocerva(opcion);
            cuestionarioCervix.setHcccantecalerg(opcion);
            cuestionarioCervix.setHcccreacivacun(opcion);
            cuestionarioCervix.setHcccenfergripa(opcion);
            cuestionarioCervix.setHcccestaembar(opcion);
            cuestionarioCervix.setHcccmestrnorma(opcion);
            cuestionarioCervix.setHccctieneparto(opcion);
            cuestionarioCervix.setHcccmetodplani(opcion);
            cuestionarioCervix.setHcccpiensembar(opcion);
            cuestionarioCervix.setHcccmediahora(opcion);
            cuestionarioCervix.setHcccinforconse(opcion);
            cuestionarioCervix.setHcccconsuprofa(opcion);
            cuestionarioCervix.setHcccamamantand(opcion);
            cuestionarioCervix.setHcccamamantand(opcion);
            cuestionarioCervix.setHcccinforgarda(opcion);
            mnuanormcitol.setValue(opcion);
            mnutieneparto.setValue(opcion);
            mnuasesocancer.setValue(opcion);
            mnurecompreve.setValue(opcion);
            mnuvphcomppre.setValue(opcion);
            mnuotrostipos.setValue(opcion);
            mnucienvirus.setValue(opcion);
            mnudosvacucol.setValue(opcion);
            mnuvphcausant.setValue(opcion);
            mnutresdosis.setValue(opcion);
            mnuinfocerva.setValue(opcion);
            mnuantecalerg.setValue(opcion);
            mnureacivacun.setValue(opcion);
            mnuenfergripa.setValue(opcion);
            mnuestaembar.setValue(opcion);
            mnugardasil.setValue(opcion);
            mnumestrnorma.setValue(opcion);
            mnumetodplani.setValue(opcion);
            mnupiensembar.setValue(opcion);
            mnumediahora.setValue(opcion);
            mnuinforconse.setValue(opcion);
            mnuconsuprofa.setValue(opcion);

        

    }

    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public String guardarCuestionario() {
        navigationRule = "";
        this.index = -1;
        Long numeroConsulta = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            numeroConsulta = new Long(consulta.getCconnumero());
        }
        
        if(cuestionarioCervix!= null){
            cuestionarioCervix.setHcccvphcervari("N");
        }

        if (cuestionarioCervix != null && 
            cuestionarioCervix.getHcccanormcitol() != null && 
            cuestionarioCervix.getHcccanormcitol().equals("N")) {
            cuestionarioCervix.setHccccualresul(null);
        }

        if (cuestionarioCervix != null && 
            cuestionarioCervix.getHccctieneparto() != null && 
            cuestionarioCervix.getHccctieneparto().equals("N")) {
            cuestionarioCervix.setHccdfechaparto(null);
            renderFechaParto = true;
        }

        if (numeroConsulta != null) {
            cuestionarioCervix.getId().setHccctiposerv(TIPO_CONSULTA);
            cuestionarioCervix.getId().setHcclconsulta(numeroConsulta);
            cuestionarioCervix.setHcccoperador(userName());
            cuestionarioCervix.setHccdfecreg(new Date());
        }
        
        
        if(usuario!= null && usuario.getHusesexo()!= null && usuario.getHusesexo().equals("M")){
            cuestionarioCervix.setHcccasesocance(null);
            cuestionarioCervix.setHcccrecompreve(null);
            cuestionarioCervix.setHcccvphcomppre(null);
            cuestionarioCervix.setHcccotrostipos(null);
            cuestionarioCervix.setHcccanormcitol(null);
            cuestionarioCervix.setHccccualresul(null);
            cuestionarioCervix.setHcccestaembar(null);
            cuestionarioCervix.setHcccmestrnorma(null);
            cuestionarioCervix.setHccdfecharegla(null);
            cuestionarioCervix.setHccctieneparto(null);
            cuestionarioCervix.setHccdfechaparto(null);
            cuestionarioCervix.setHcccpiensembar(null);
            
        }

        try {
        
            
            this.serviceLocator.getClinicoService().saveCuestionarioCervix(cuestionarioCervix);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
        }

        return navigationRule;

    }
    
    
    /**
     * @return
     */
    public String continuar() {
       generoCuestionario = false; 
       return nextAction;
    }
    
    public void generarReporte(){
        try {
            obtenerDatos();
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/cuestionarioCervix.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                parameters.put("RENDER_FEMENINO", renderFemenino);
                byte[] bytes;
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "CuestionarioCervix" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoCuestionario = true;

          

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }

    }


    //-----------------------------------------------------------------------
    //  ACCESORIOS
    //-----------------------------------------------------------------------


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
     * @param cuestionarioCervix
     */
    public void setCuestionarioCervix(Chcancecervi cuestionarioCervix) {
        this.cuestionarioCervix = cuestionarioCervix;
    }

    /**
     * @return
     */
    public Chcancecervi getCuestionarioCervix() {
        return cuestionarioCervix;
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
     * @param generoCuestionario
     */
    public void setGeneroCuestionario(boolean generoCuestionario) {
        this.generoCuestionario = generoCuestionario;
    }

    /**
     * @return
     */
    public boolean isGeneroCuestionario() {
        return generoCuestionario;
    }

    
    /**
     * @param renderCualResul
     */
    public void setRenderCualResul(boolean renderCualResul) {
        this.renderCualResul = renderCualResul;
    }

    /**
     * @return
     */
    public boolean isRenderCualResul() {
        return renderCualResul;
    }

    /**
     * @param renderFechaParto
     */
    public void setRenderFechaParto(boolean renderFechaParto) {
        this.renderFechaParto = renderFechaParto;
    }

    /**
     * @return
     */
    public boolean isRenderFechaParto() {
        return renderFechaParto;
    }


    /**
     * @param mnutieneparto
     */
    public void setMnutieneparto(UIInput mnutieneparto) {
        this.mnutieneparto = mnutieneparto;
    }

    /**
     * @return
     */
    public UIInput getMnutieneparto() {
        return mnutieneparto;
    }

    /**
     * @param mnuanormcitol
     */
    public void setMnuanormcitol(UIInput mnuanormcitol) {
        this.mnuanormcitol = mnuanormcitol;
    }

    /**
     * @return
     */
    public UIInput getMnuanormcitol() {
        return mnuanormcitol;
    }

    /**
     * @param mnuasesocancer
     */
    public void setMnuasesocancer(UIInput mnuasesocancer) {
        this.mnuasesocancer = mnuasesocancer;
    }

    /**
     * @return
     */
    public UIInput getMnuasesocancer() {
        return mnuasesocancer;
    }

    /**
     * @param mnurecompreve
     */
    public void setMnurecompreve(UIInput mnurecompreve) {
        this.mnurecompreve = mnurecompreve;
    }

    /**
     * @return
     */
    public UIInput getMnurecompreve() {
        return mnurecompreve;
    }

    /**
     * @param mnuvphcomppre
     */
    public void setMnuvphcomppre(UIInput mnuvphcomppre) {
        this.mnuvphcomppre = mnuvphcomppre;
    }

    /**
     * @return
     */
    public UIInput getMnuvphcomppre() {
        return mnuvphcomppre;
    }

    /**
     * @param mnuotrostipos
     */
    public void setMnuotrostipos(UIInput mnuotrostipos) {
        this.mnuotrostipos = mnuotrostipos;
    }

    /**
     * @return
     */
    public UIInput getMnuotrostipos() {
        return mnuotrostipos;
    }

    /**
     * @param mnucienvirus
     */
    public void setMnucienvirus(UIInput mnucienvirus) {
        this.mnucienvirus = mnucienvirus;
    }

    /**
     * @return
     */
    public UIInput getMnucienvirus() {
        return mnucienvirus;
    }

    /**
     * @param mnudosvacucol
     */
    public void setMnudosvacucol(UIInput mnudosvacucol) {
        this.mnudosvacucol = mnudosvacucol;
    }

    /**
     * @return
     */
    public UIInput getMnudosvacucol() {
        return mnudosvacucol;
    }

    /**
     * @param mnuvphcausant
     */
    public void setMnuvphcausant(UIInput mnuvphcausant) {
        this.mnuvphcausant = mnuvphcausant;
    }

    /**
     * @return
     */
    public UIInput getMnuvphcausant() {
        return mnuvphcausant;
    }

    
    /**
     * @param mnutresdosis
     */
    public void setMnutresdosis(UIInput mnutresdosis) {
        this.mnutresdosis = mnutresdosis;
    }

    /**
     * @return
     */
    public UIInput getMnutresdosis() {
        return mnutresdosis;
    }

    /**
     * @param mnuinfocerva
     */
    public void setMnuinfocerva(UIInput mnuinfocerva) {
        this.mnuinfocerva = mnuinfocerva;
    }

    /**
     * @return
     */
    public UIInput getMnuinfocerva() {
        return mnuinfocerva;
    }

    /**
     * @param mnuantecalerg
     */
    public void setMnuantecalerg(UIInput mnuantecalerg) {
        this.mnuantecalerg = mnuantecalerg;
    }

    /**
     * @return
     */
    public UIInput getMnuantecalerg() {
        return mnuantecalerg;
    }

    /**
     * @param mnureacivacun
     */
    public void setMnureacivacun(UIInput mnureacivacun) {
        this.mnureacivacun = mnureacivacun;
    }

    /**
     * @return
     */
    public UIInput getMnureacivacun() {
        return mnureacivacun;
    }

    /**
     * @param mnuenfergripa
     */
    public void setMnuenfergripa(UIInput mnuenfergripa) {
        this.mnuenfergripa = mnuenfergripa;
    }

    /**
     * @return
     */
    public UIInput getMnuenfergripa() {
        return mnuenfergripa;
    }

    /**
     * @param mnuestaembar
     */
    public void setMnuestaembar(UIInput mnuestaembar) {
        this.mnuestaembar = mnuestaembar;
    }

    /**
     * @return
     */
    public UIInput getMnuestaembar() {
        return mnuestaembar;
    }


    /**
     * @param mnumestrnorma
     */
    public void setMnumestrnorma(UIInput mnumestrnorma) {
        this.mnumestrnorma = mnumestrnorma;
    }

    /**
     * @return
     */
    public UIInput getMnumestrnorma() {
        return mnumestrnorma;
    }

    /**
     * @param mnumetodplani
     */
    public void setMnumetodplani(UIInput mnumetodplani) {
        this.mnumetodplani = mnumetodplani;
    }

    /**
     * @return
     */
    public UIInput getMnumetodplani() {
        return mnumetodplani;
    }

    /**
     * @param mnupiensembar
     */
    public void setMnupiensembar(UIInput mnupiensembar) {
        this.mnupiensembar = mnupiensembar;
    }

    /**
     * @return
     */
    public UIInput getMnupiensembar() {
        return mnupiensembar;
    }

    /**
     * @param mnumediahora
     */
    public void setMnumediahora(UIInput mnumediahora) {
        this.mnumediahora = mnumediahora;
    }

    /**
     * @return
     */
    public UIInput getMnumediahora() {
        return mnumediahora;
    }

    /**
     * @param mnuinforconse
     */
    public void setMnuinforconse(UIInput mnuinforconse) {
        this.mnuinforconse = mnuinforconse;
    }

    /**
     * @return
     */
    public UIInput getMnuinforconse() {
        return mnuinforconse;
    }

    /**
     * @param mnuconsuprofa
     */
    public void setMnuconsuprofa(UIInput mnuconsuprofa) {
        this.mnuconsuprofa = mnuconsuprofa;
    }

    /**
     * @return
     */
    public UIInput getMnuconsuprofa() {
        return mnuconsuprofa;
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
     * @param mnugardasil
     */
    public void setMnugardasil(UIInput mnugardasil) {
        this.mnugardasil = mnugardasil;
    }

    /**
     * @return
     */
    public UIInput getMnugardasil() {
        return mnugardasil;
    }

   

    /**
     * @param lstContacto
     */
    public void setLstContacto(List lstContacto) {
        this.lstContacto = lstContacto;
    }

    /**
     * @return
     */
    public List getLstContacto() {
        if(lstContacto== null || lstContacto.isEmpty()){
            lstContacto = new ArrayList();
            lstContacto.add(new SelectItem("","--"));
            lstContacto.add(new SelectItem("1","Tel. Oficina"));
            lstContacto.add(new SelectItem("2","Tel. Casa"));
            lstContacto.add(new SelectItem("3","Celular"));
            lstContacto.add(new SelectItem("4","Mensaje de Texto"));
            lstContacto.add(new SelectItem("4","Correo Electronico"));
        }
        return lstContacto;
    }


    /**
     * @param renderFemenino
     */
    public void setRenderFemenino(Boolean renderFemenino) {
        this.renderFemenino = renderFemenino;
    }

    /**
     * @return
     */
    public Boolean getRenderFemenino() {
        return renderFemenino;
    }
}
