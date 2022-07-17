//=======================================================================
// ARCHIVO AntecedentesBean.java
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.AntecedentesDetalladoDTO;
import org.profamilia.hc.model.dto.Chantecdetal;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chidentiriesgo;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
//=======================================================================
//  CLASE AntecedentesBean
//=======================================================================
public class AntecedentesUsuarioDetalladoBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /**Almacena los tipos de antecedentes  */
    private List<SelectItem> lstAntecedentes;

    /** Almacena el codigo del tipo de antecedente */
    private String codigoAntecedente;

    /** Almacena el antecedente encontrado */
    private String antecedente;

    /** Almacena los antecedentes registrados  */

    List<Chantecegene> lstAntecedentesGenerales;

    /** Almacena el componente tabla  */
    private HtmlDataTable dtAntecedentes;

    /** Almacena el antecendente **/
    private Chantecegene antecedenteClone;


    /** Almacena el tipo de historia*/
    private Integer tipoHistoria;

    private String nuevosAntecedentes;

    private List lstOpciones;

    private boolean mostrarAntecedentes;

    private List lstHistoricoAntecedente;

    private String sexo;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;
    
    /** Almacena el componente tabla  */
    private HtmlDataTable dtAntecedentesMusa;
    
    private List lstGrupoSangre;
    
    private List lstFactorSangre;
    
    private Chantecdetal antedecentesDetallado;
    
    private boolean renderRH;
    
    private List lstOpcionesBoolean;
    
    private List lstOpcionesPregunta;
    
    private List lstRespuestaPregunta;
    
    private List lstOpcionesPruebasRapidas;
    
    private boolean renderPruebaVPH;
    
    private boolean renderPruebaSifilis;
    
    private boolean renderPruebaRapida;
    
    private boolean renderEmbarazo;
    
    private boolean renderSifilis;
    
    private boolean renderVIH;
    
    private List<String> lstOpcionesPruebasRapidasSelect;
    
    private List resultadosPruebasRapidas;
    
    private List lstPreguntasToxicologicas;
    
    private List<String> lstPreguntasToxicologicasSelect;
    
    private List lstPreguntasPatologia;
    
    private List<String> lstPreguntasPatologicasSelect;
    
    private boolean renderTbcPato;
    
    private boolean renderDiabetesPato;
    
    private boolean renderHipertensionPato;
    
    private boolean renderPreclampsiaPato;
    
    private boolean renderEclampsiaPato;
    
    private boolean renderInfertilidadPato;
    
    private boolean renderCardiopatiaPato;
    
    private boolean renderNefropatiaPato;
    
    private boolean renderPatologia;
    
    private boolean renderTbcFami;
    
    private boolean renderDiabetesFami;
    
    private boolean renderHipertensionFami;
    
    private boolean renderPreclampsiaFami;
    
    private boolean renderEclampsiaFami;
    
    private boolean renderFamiliar;
    
    private boolean renderToxicologico;
    
    private boolean renderGrupoSanguineo;
    
    private boolean renderAntecedentesGinecologicos;
    
    private boolean renderCirugiaGenUri;
    
    private Chidentiriesgo identifi;
    
    private boolean renderQuirurgicos;
    
    private boolean renderAlergico;
    
    private boolean renderTransfusionales;
    
    private boolean renderITS;
    
    private boolean renderFarmacologicos;
    
    private boolean renderTraumaticos;
    
    private List lstOpcionesAntecedentes;
    
    private boolean renderNuevoAntecedente;
    
    private boolean renderPrimeraVez;
    
    private boolean renderAntecedentesDetallado;
    
    // campos agregados
    
     private List<SelectItem> lstPatologicos;
     private List<SelectItem> lstQuirurgicos;
    private List<SelectItem> lstFamiliares;
    private List<SelectItem> lstMasculinos;
    
    private List<String> lstPatologicosSelected;
    private List<String> lstQuirurgicosSelected;
    private List<String> lstFamiliaresSelected;
    private List<String> lstMasculinosSelected;
    private UIInput mnuPatologicos;
    private boolean renderGenetico;
    private boolean renderMasculino;
    
    
  
    
    private List<Chantecdetal> antedecentesDetalladoLista;
    
    private List <AntecedentesDetalladoDTO> antecedentesDetalladoHistorial;
    
    private List<SelectItem> lstPatologicosIve;
    private List<String> lstPatologicosIveSelected;
    private List<SelectItem> lstFamiliaresIve;
    private List<String> lstFamiliaresIveSelected;
    private List<SelectItem> lstQuirurgicosIve;
    private List<String> lstQuirurgicosIveSelected;
    private List resultadosPruebasRapidasEmbarazo;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AntecedentesUsuarioDetalladoBean() {
    }

    public void init() {
        lstHistoricoAntecedente = new ArrayList();
        nextAction = "";
        renderRH=false;
        inicializarAntecedentes();
        renderPruebaSifilis =false;
        renderPruebaVPH = false;
        renderPruebaRapida = false;
        renderPatologia=false;
        renderGenetico=false;
        renderMasculino=false;
        renderAntecedentesGinecologicos = false;
        renderCirugiaGenUri = false;
        identifi= new Chidentiriesgo();
        renderNuevoAntecedente= false;

    }


    public void inicializarAntecedentes() {
        lstPatologicosSelected = new ArrayList<String>();
        lstQuirurgicosSelected = new ArrayList<String>();
        lstFamiliaresSelected = new ArrayList<String>();
        lstMasculinosSelected = new ArrayList<String>();
        lstPreguntasToxicologicas = new ArrayList();
        lstPreguntasToxicologicasSelect = new ArrayList<String>();
        lstOpcionesPruebasRapidasSelect = new ArrayList<String>();
        resultadosPruebasRapidas = new ArrayList();
        resultadosPruebasRapidasEmbarazo=new ArrayList();
        lstPreguntasPatologia = new ArrayList();
        lstPreguntasPatologicasSelect = new ArrayList<String>();
        antedecentesDetalladoLista = new ArrayList();
        antecedentesDetalladoHistorial = new ArrayList();
        
        lstPatologicosIve = new ArrayList();
        lstPatologicosIveSelected = new ArrayList<String>();
        lstFamiliaresIve = new ArrayList();
        lstFamiliaresIveSelected = new ArrayList<String>();
        lstQuirurgicosIve = new ArrayList();
        lstQuirurgicosIveSelected = new ArrayList<String>();

        renderToxicologico = false;
        renderQuirurgicos = false;
        
        renderAlergico = false;
        
        renderTransfusionales = false;
        
        renderITS = false;
        
        renderFarmacologicos = false;
        
        renderTraumaticos = false;
        
        renderGrupoSanguineo = false;
        renderFamiliar = false;
        renderPatologia = false;

        renderPruebaVPH = false;
        renderPruebaSifilis = false;
        renderRH = false;
        renderAntecedentesDetallado= false;
        renderNuevoAntecedente= false;
       
        
       
        renderAntecedentesDetallado= false;
        renderNuevoAntecedente= false;
        
       
        
        // Obtiene el tipo de historia      
        try {
            if (usuario != null && usuario.getHuslnumero() != null) {
                lstHistoricoAntecedente = 
                        this.serviceLocator.getClinicoService().getAntecedentesUsuario(usuario.getHuslnumero());
                        
                antedecentesDetalladoLista = 
                        this.serviceLocator.getClinicoService().getHistorialAntecedentesDetallado(usuario.getHuslnumero());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }


        try {
            if (numeroConsulta != null) {
            System.out.println("EL NUMERO DE CONSULTA ES "+ numeroConsulta);
                antedecentesDetallado = this.serviceLocator.getClinicoService().getAntecedentesDetallado(numeroConsulta);
                identifi=    this.getServiceLocator().getClinicoService().getIdentificacionRiesgos(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (renderPrimeraVez) {
            renderNuevoAntecedente = false;
            renderAntecedentesDetallado = true;
            if (antedecentesDetallado != null) {
                antedecentesDetallado.setHadcantenuev("S");
            }else{
                antedecentesDetallado= new Chantecdetal() ;
                antedecentesDetallado.setHadcantenuev("S");
            }
        } else {
            if (antedecentesDetallado != null) {
                renderNuevoAntecedente = true;
                renderAntecedentesDetallado = false;
                if(antedecentesDetallado.getHadcantenuev()== null){
                    antedecentesDetallado.setHadcantenuev("N");
                }else  if("S".equals(antedecentesDetallado.getHadcantenuev())){
                    renderAntecedentesDetallado = true;
                }
            } else {
                antedecentesDetallado= new Chantecdetal() ;
                renderNuevoAntecedente = true;
                renderAntecedentesDetallado = false;
            }
        }

        if(antedecentesDetallado != null){
            changeAntFamiliares();
            changeAntToxicologicos();
            changeGrupoSanguineo();
            changePatologia();
            changePreguntasAnteceFamiliares();
            changePreguntasPatologias();
            changePreguntasToxicologicas();
            changeRH();
            changePruebaVPH();
            changePruebaSifilis();
            changeAntecedentes();
            changePruebaRapida();
            changeAntQuirurgicos();
            changePreguntasAntQuirurgicos();
            changeAntAlergico();
            changeAntTransfusionales();
            changeAntITS();
            changeAntFarmacologicos();
            changeAntTraumaticos();
            changeGeneticosFertilidad();
            changeMasculinoFertilidad();
            inicializarChkBoxes();
            inicializarAntecentesCheck();          
                
            if (antedecentesDetallado.getHadcembarazo()!= null){
                lstOpcionesPruebasRapidasSelect.add("EM");
                renderEmbarazo = true;
            }
            
            if (antedecentesDetallado.getHadcsifilis()!= null){
                lstOpcionesPruebasRapidasSelect.add("SI");
                renderSifilis = true;
            }
            
            if (antedecentesDetallado.getHadcvih() != null){
                lstOpcionesPruebasRapidasSelect.add("VI");
                renderVIH = true;
            } 
                
        }else{
            antedecentesDetallado = new Chantecdetal();
        }
        cargarHistorial();
    }

    public void cargarHistorial() {
        if (antedecentesDetalladoLista != null && 
            !antedecentesDetalladoLista.isEmpty()) {
            AntecedentesDetalladoDTO antecedentesDetalladoDTO = 
                new AntecedentesDetalladoDTO();
            antecedentesDetalladoHistorial = new ArrayList();
            for (Chantecdetal antecente: antedecentesDetalladoLista) {
                //Patologias
                if ("S".equals(antecente.getHadcantepato())) {
                    if ("S".equals(antecente.getHadctbcpato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("TBC");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcdiabpato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Diabetes");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadchipepato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Hipertensi�n");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcprecpato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Preclampsia");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadceclapato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Eclampsia");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadciferpato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Infertilidad");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadccardpato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Cardiopat�a");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcnefrpato())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Patologico");
                        antecedentesDetalladoDTO.setNombreAntecedente("Nefropat�a");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    

                    if ("S".equals(antecente.getHadctbcfami())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Familiares");
                        antecedentesDetalladoDTO.setNombreAntecedente("TBC");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcpatdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }
                }

                //Familiares
                if ("S".equals(antecente.getHadcantefami())) {
                    if ("S".equals(antedecentesDetallado.getHadcdiabfami())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Familiares");
                        antecedentesDetalladoDTO.setNombreAntecedente("Diabetes");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcfamdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadchipefami())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Familiares");
                        antecedentesDetalladoDTO.setNombreAntecedente("Hipertensi�n");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcfamdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcprecfami())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Familiares");
                        antecedentesDetalladoDTO.setNombreAntecedente("Preclampsia");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcfamdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadceclafami())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Familiares");
                        antecedentesDetalladoDTO.setNombreAntecedente("Eclampsia");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcfamdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }
                }

                //Toxicologicos
                if ("S".equals(antecente.getHadcantetoxi())) {

                    if ("S".equals(antecente.getHadcfumacttox())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Toxicologicos");
                        antecedentesDetalladoDTO.setNombreAntecedente("Fumador Activo");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadctoxdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcfumpastox())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Toxicologicos");
                        antecedentesDetalladoDTO.setNombreAntecedente("Fumador Pasivo");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadctoxdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcsuspsitox())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Toxicologicos");
                        antecedentesDetalladoDTO.setNombreAntecedente("Sustancias Psicoactivas");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadctoxdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                    if ("S".equals(antecente.getHadcalctox())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Toxicologicos");
                        antecedentesDetalladoDTO.setNombreAntecedente("Alcohol");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadctoxdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }

                }
                //Quirugicos
                if ("S".equals(antecente.getHadcanteqx())) {
                    if ("S".equals(antecente.getHadcgeurqx())) {
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Quir�rgicos");
                        antecedentesDetalladoDTO.setNombreAntecedente("Cirug�a genitourinaria");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcquirdes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                    }
                }

                //Alergicos
                if("S".equals(antecente.getHadcantealer())){
                        antecedentesDetalladoDTO = 
                                new AntecedentesDetalladoDTO();
                        antecedentesDetalladoDTO.setTipoAntecedente("Al�rgicos");
                        antecedentesDetalladoDTO.setNombreAntecedente("Al�rgicos");
                        antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcantaledes());
                        antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                        antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                }

                //Transfusionales
                if ("S".equals(antecente.getHadcantetran())) {
                    antecedentesDetalladoDTO = new AntecedentesDetalladoDTO();
                    antecedentesDetalladoDTO.setTipoAntecedente("Transfusionales");
                    antecedentesDetalladoDTO.setNombreAntecedente("Transfusionales");
                    antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcanttrades());
                    antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                    antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                }

                //ITS
                if ("S".equals(antecente.getHadcantits())) {
                    antecedentesDetalladoDTO = new AntecedentesDetalladoDTO();
                    antecedentesDetalladoDTO.setTipoAntecedente("ITS");
                    antecedentesDetalladoDTO.setNombreAntecedente("ITS");
                    antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcantitsdes());
                    antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                    antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                }

                //Farmacologicos
                if ("S".equals(antecente.getHadcantefarm())) {
                    antecedentesDetalladoDTO = new AntecedentesDetalladoDTO();
                    antecedentesDetalladoDTO.setTipoAntecedente("Farmacologicos");
                    antecedentesDetalladoDTO.setNombreAntecedente("Farmacologicos");
                    antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadcantfardes());
                    antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                    antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                }

                //Traumaticos
                if ("S".equals(antecente.getHadcantetrau())) {
                    antecedentesDetalladoDTO = new AntecedentesDetalladoDTO();
                    antecedentesDetalladoDTO.setTipoAntecedente("Traumaticos");
                    antecedentesDetalladoDTO.setNombreAntecedente("Traumaticos");
                    antecedentesDetalladoDTO.setDescripcionAntecedente(antecente.getHadctraantdesc());
                    antecedentesDetalladoDTO.setFechaRegistro(antecente.getHaddfecregistr());
                    antecedentesDetalladoHistorial.add(antecedentesDetalladoDTO);
                }           
                
            }
        }

    }


    /**
     * @param lstAntecedentes
     */
    public void setLstAntecedentes(List<SelectItem> lstAntecedentes) {
        this.lstAntecedentes = lstAntecedentes;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstAntecedentes() {
        if (lstAntecedentes == null || lstAntecedentes.isEmpty()) {
            lstAntecedentes = new ArrayList<SelectItem>();
            ArrayList<Chtipoantece> lstAntecendesAux;
            lstAntecendesAux = new ArrayList<Chtipoantece>();

            try {
             
                    lstAntecendesAux = 
                            (ArrayList<Chtipoantece>)this.getServiceLocator().getClinicoService().getTipoAntecedente(tipoHistoria);
                

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstAntecendesAux != null && !lstAntecendesAux.isEmpty()) {

                Iterator it = lstAntecendesAux.iterator();
                int i = 0;
                lstAntecedentes.add(new SelectItem("", 
                                                   "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstAntecedentes.add(new SelectItem(lstAntecendesAux.get(i).getHtancodigo().toString(), 
                                                       lstAntecendesAux.get(i).getHtacdescripcio()));
                    i++;
                }
            }
        }

        return lstAntecedentes;
    }

    /**
     * @param codigoAntecedente
     */
    public void setCodigoAntecedente(String codigoAntecedente) {
        this.codigoAntecedente = codigoAntecedente;
    }

    /**
     * @return
     */
    public String getCodigoAntecedente() {
        return codigoAntecedente;
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
     * @param antecedente
     */
    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    /**
     * @return
     */
    public String getAntecedente() {
        return antecedente;
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
     * @param lstHistoricoAntecedente
     */
    public void setLstHistoricoAntecedente(List lstHistoricoAntecedente) {
        this.lstHistoricoAntecedente = lstHistoricoAntecedente;
    }

    /**
     * @return
     */
    public List getLstHistoricoAntecedente() {
        return lstHistoricoAntecedente;
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

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }

    /**
     * @param mostrarAntecedentes
     */
    public void setMostrarAntecedentes(boolean mostrarAntecedentes) {
        this.mostrarAntecedentes = mostrarAntecedentes;
    }

    /**
     * @return
     */
    public boolean isMostrarAntecedentes() {
        return mostrarAntecedentes;
    }

    /**
     * @param nuevosAntecedentes
     */
    public void setNuevosAntecedentes(String nuevosAntecedentes) {
        this.nuevosAntecedentes = nuevosAntecedentes;
    }

    /**
     * @return
     */
    public String getNuevosAntecedentes() {
        return nuevosAntecedentes;
    }


    /**
     * @param lstAntecedentesGenerales
     */
    public void setLstAntecedentesGenerales(List<Chantecegene> lstAntecedentesGenerales) {
        this.lstAntecedentesGenerales = lstAntecedentesGenerales;
    }

    /**
     * @return
     */
    public List<Chantecegene> getLstAntecedentesGenerales() {
        return lstAntecedentesGenerales;
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
     * @return
     */
    public String agregarAntecedente() {

        Chantecegene anteced;
        anteced = new Chantecegene();

        if (codigoAntecedente != null && !codigoAntecedente.equals("") && 
            antecedente != null && !antecedente.equals("")) {
            anteced.setHanntipoante(new Integer(codigoAntecedente));
            anteced.setHantdescripcio(antecedente);
            anteced.setHancoperador(userName());

            lstAntecedentesGenerales.add(anteced);
            codigoAntecedente = "";
            antecedente = "";
        } else {
            FacesUtils.addErrorMessage("Debe Registrar el tipo antecedente y la descripcion");
        }


        return null;

    }

    /**
     * Backing bean action para eliminar una tarjeta.
     * 
     * @return the navigation result
     */
    public String eliminarAntecedente() {
        this.antecedenteClone = (Chantecegene)this.dtAntecedentes.getRowData();
        this.lstAntecedentesGenerales.remove(antecedenteClone);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
        return BeanNavegacion.SUCCESS;
    }

    /**
     * @param dtAntecedentes
     */
    public void setDtAntecedentes(HtmlDataTable dtAntecedentes) {
        this.dtAntecedentes = dtAntecedentes;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtAntecedentes() {
        return dtAntecedentes;
    }


    /**
     * @return
     */
    public boolean esValido() {
        Chantecdetal antedecentesDetalladoAux = null;

        boolean esValido = false;

        try {
            if (numeroConsulta != null) {
                antedecentesDetalladoAux = this.serviceLocator.getClinicoService().getAntecedentesDetallado(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (antedecentesDetalladoAux != null ) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public void changeAntecedentes() {
        if (antedecentesDetallado != null) {
            if ("S".equals(antedecentesDetallado.getHadcantenuev())) {
                mostrarAntecedentes = true;
            } else {
                mostrarAntecedentes = false;
            }

        }

    }


    public String aceptar() {
        navigationRule = "";
        if(null ==identifi){
            identifi= new Chidentiriesgo();
        }
        if (usuario != null && usuario.getHusesexo() != null) {
            sexo = usuario.getHusesexo();
        }

        if (antedecentesDetallado.getHadcsifilis() !=null && (antedecentesDetallado.getHadcsifilis().equals("P") || antedecentesDetallado.getHadcsifilis().equals("N") )) {
            identifi.setHidecserovih("S");
        } else{
            identifi.setHidecserovih("N");
        }
        
        if (antedecentesDetallado.getHadcvih() !=null && (antedecentesDetallado.getHadcvih().equals("P")|| antedecentesDetallado.getHadcvih().equals("N"))) {
            identifi.setHidecvih("S");
        } else {
            identifi.setHidecvih("N");
        }
       
        if (antedecentesDetallado != null) {
            try {
       
                identifi.setHidelconsulta(numeroConsulta);

                this.getServiceLocator().getClinicoService().saveIdentificaRiesgo(identifi);
                
                antedecentesDetallado.setHadcoperador(userName());
                this.getServiceLocator().getClinicoService().saveAntecedentesIve(numeroConsulta,antedecentesDetallado);
                
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_VALIDACION_ANTECEDENTES);
        }

        return navigationRule;

    }
    
    public String aceptarFertilidad() {
    cambiarAntecedentesDetallados();
        System.out.println("EL NPUMERO DE CONSULTA ES "+ numeroConsulta);
        System.out.println("NO GUARDO NADA "+antedecentesDetallado.getHadcpatdes());
        navigationRule = "";
        if (usuario != null && usuario.getHusesexo() != null) {
            sexo = usuario.getHusesexo();
        }
        if (antedecentesDetallado != null) {
            try {
                
                antedecentesDetallado.setHadcoperador(userName());
                this.getServiceLocator().getClinicoService().saveAntecedentesDetFertilidad(numeroConsulta,antedecentesDetallado);
                
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_VALIDACION_ANTECEDENTES);
        }

        return navigationRule;

    }

    public void setDtAntecedentesMusa(HtmlDataTable dtAntecedentesMusa) {
        this.dtAntecedentesMusa = dtAntecedentesMusa;
    }

    public HtmlDataTable getDtAntecedentesMusa() {
        return dtAntecedentesMusa;
    }

    public void setLstGrupoSangre(List lstGrupoSangre) {
        this.lstGrupoSangre = lstGrupoSangre;
    }

    public List getLstGrupoSangre() {
        if (lstGrupoSangre == null) {
            lstGrupoSangre = new ArrayList();
            lstGrupoSangre.add(new SelectItem("", "Seleccione una opci�n ..."));
            lstGrupoSangre.add(new SelectItem("A", "A"));
            lstGrupoSangre.add(new SelectItem("AB", "AB"));
            lstGrupoSangre.add(new SelectItem("B", "B"));
            lstGrupoSangre.add(new SelectItem("O", "O"));
            lstGrupoSangre.add(new SelectItem("NS", "No sabe"));
        }
        return lstGrupoSangre;
    }

    public void setLstFactorSangre(List lstFactorSangre) {
        this.lstFactorSangre = lstFactorSangre;
    }

    public List getLstFactorSangre() {
        if (lstFactorSangre == null) {
            lstFactorSangre = new ArrayList();
            lstFactorSangre.add(new SelectItem("P", "POS (+) "));
            lstFactorSangre.add(new SelectItem("N", "NEG (-) "));
        }
        return lstFactorSangre;
    }

    public void setAntedecentesDetallado(Chantecdetal antedecentesDetallado) {
        this.antedecentesDetallado = antedecentesDetallado;
    }

    public Chantecdetal getAntedecentesDetallado() {
        return antedecentesDetallado;
    }
    
    public void changeRH(){
        if("N".equals(antedecentesDetallado.getHadcrh())){
            renderRH =true;
            antedecentesDetallado.setHadcisoinabort("N");
        }else{
            antedecentesDetallado.setHadcisoinabort(null);
                renderRH =false;
        }
    }

    public void setRenderRH(boolean renderRH) {
        this.renderRH = renderRH;
    }

    public boolean isRenderRH() {
        return renderRH;
    }
    
    public List getLstOpcionesBooleanee() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem(true, "SI"));
            lstOpciones.add(new SelectItem(false, "NO"));

        }

        return lstOpciones;
    }

    public void setLstOpcionesBoolean(List lstOpcionesBoolean) {
        this.lstOpcionesBoolean = lstOpcionesBoolean;
    }

    public List getLstOpcionesBoolean() {
        if (lstOpcionesBoolean == null || lstOpcionesBoolean.isEmpty()) {
            lstOpcionesBoolean = new ArrayList();
            lstOpcionesBoolean.add(new SelectItem(true, "SI"));
            lstOpcionesBoolean.add(new SelectItem(false, "NO"));

        }
        return lstOpcionesBoolean;
    }

    public void setLstOpcionesPregunta(List lstOpcionesPregunta) {
        this.lstOpcionesPregunta = lstOpcionesPregunta;
    }

    public List getLstOpcionesPregunta() {
        if (lstOpcionesPregunta == null || lstOpcionesPregunta.isEmpty()) {
            lstOpcionesPregunta = new ArrayList();
            lstOpcionesPregunta.add(new SelectItem("", "Seleccione una opci�n ..."));
            lstOpcionesPregunta.add(new SelectItem("NU", "Nunca"));
            lstOpcionesPregunta.add(new SelectItem("HMEA", "Hace menos de un ano"));
            lstOpcionesPregunta.add(new SelectItem("HMAA", "Hace m�s de un ano"));
            lstOpcionesPregunta.add(new SelectItem("NR", "No Recuerda"));

        }
        return lstOpcionesPregunta;
    }

    public void setLstRespuestaPregunta(List lstRespuestaPregunta) {
        this.lstRespuestaPregunta = lstRespuestaPregunta;
    }

    public List getLstRespuestaPregunta() {
        if (lstRespuestaPregunta == null || lstRespuestaPregunta.isEmpty()) {
            lstRespuestaPregunta = new ArrayList();
            lstRespuestaPregunta.add(new SelectItem("", "Seleccione una opci�n ..."));
            lstRespuestaPregunta.add(new SelectItem("RE", "Reactivo"));
            lstRespuestaPregunta.add(new SelectItem("NR", "No Reactivo"));
            lstRespuestaPregunta.add(new SelectItem("IN", "Indeterminado"));

        }
        return lstRespuestaPregunta;
    }

    public void setLstOpcionesPruebasRapidas(List lstOpcionesPruebasRapidas) {
        this.lstOpcionesPruebasRapidas = lstOpcionesPruebasRapidas;
    }

    public List getLstOpcionesPruebasRapidas() {
        if (lstOpcionesPruebasRapidas == null || lstOpcionesPruebasRapidas.isEmpty()) {
            lstOpcionesPruebasRapidas = new ArrayList();
            lstOpcionesPruebasRapidas.add(new SelectItem("EM", "Embarazo "));
            lstOpcionesPruebasRapidas.add(new SelectItem("SI", "Sifilis"));
            lstOpcionesPruebasRapidas.add(new SelectItem("VI", "VIH"));

        }
        return lstOpcionesPruebasRapidas;
    }
    
    public void changePruebaVPH(){
        if("HMEA".equals(antedecentesDetallado.getHadcultpruvih())|| "HMAA".equals(antedecentesDetallado.getHadcultpruvih()) ){
            renderPruebaVPH =true;
        }else{
            antedecentesDetallado.setHadcresultpruvih(null);
            renderPruebaVPH =false;
        }
    }

    public void setRenderPruebaVPH(boolean renderPruebaVPH) {
        this.renderPruebaVPH = renderPruebaVPH;
    }

    public boolean isRenderPruebaVPH() {
        return renderPruebaVPH;
    }

    public void setRenderPruebaSifilis(boolean renderPruebaSifilis) {
        this.renderPruebaSifilis = renderPruebaSifilis;
    }

    public boolean isRenderPruebaSifilis() {
        return renderPruebaSifilis;
    }
    
    public void changePruebaSifilis(){
        if("HMEA".equals(antedecentesDetallado.getHadcultprusif())|| "HMAA".equals(antedecentesDetallado.getHadcultprusif()) ){
            renderPruebaSifilis =true;
        }else{
            antedecentesDetallado.setHadcresultprusif(null);
            renderPruebaSifilis =false;
        }
    }
    
    public void changePruebaRapida(){
        if("S".equals(antedecentesDetallado.getHadcprurapcon())){
            renderPruebaRapida =true;
        }else{
            antedecentesDetallado.setHadcsifilis(null);
            antedecentesDetallado.setHadcembarazo(null);
            antedecentesDetallado.setHadcvih(null);
            renderPruebaRapida =false;
        }
    }

    public void setRenderPruebaRapida(boolean renderPruebaRapida) {
        this.renderPruebaRapida = renderPruebaRapida;
    }

    public boolean isRenderPruebaRapida() {
        return renderPruebaRapida;
    }
    
    public void setOpcionesPruebasRapidasSelect(ValueChangeEvent valueChangeEvent) {
        setLstOpcionesPruebasRapidasSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstOpcionesPruebasRapidasSelect(List<String> lstOpcionesPruebasRapidasSelect) {
        this.lstOpcionesPruebasRapidasSelect = lstOpcionesPruebasRapidasSelect;
    }

    public List<String> getLstOpcionesPruebasRapidasSelect() {
        return lstOpcionesPruebasRapidasSelect;
    }
    
    public void changeOpcionesPruebasRapidas() {
        renderEmbarazo = false;
        renderSifilis = false;
        renderVIH = false;
        if (lstOpcionesPruebasRapidasSelect != null && 
            !lstOpcionesPruebasRapidasSelect.isEmpty()) {
            for (Iterator iterator = lstOpcionesPruebasRapidasSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("EM")){
                    renderEmbarazo = true;
                }else {
                    antedecentesDetallado.setHadcembarazo(null);
                }
                
                if (codigo.equals("SI")){
                    renderSifilis = true;
                }else {
                    antedecentesDetallado.setHadcsifilis(null);
                }
                
                if (codigo.equals("VI")){
                    renderVIH = true;
                }else {
                    antedecentesDetallado.setHadcvih(null);
                }
            }

        }
    }

    public void setRenderEmbarazo(boolean renderEmbarazo) {
        this.renderEmbarazo = renderEmbarazo;
    }

    public boolean isRenderEmbarazo() {
        return renderEmbarazo;
    }

    public void setRenderSifilis(boolean renderSifilis) {
        this.renderSifilis = renderSifilis;
    }

    public boolean isRenderSifilis() {
        return renderSifilis;
    }

    public void setRenderVIH(boolean renderVIH) {
        this.renderVIH = renderVIH;
    }

    public boolean isRenderVIH() {
        return renderVIH;
    }

    public void setResultadosPruebasRapidas(List resultadosPruebasRapidas) {
        this.resultadosPruebasRapidas = resultadosPruebasRapidas;
    }

    public List getResultadosPruebasRapidas() {
        if (resultadosPruebasRapidas == null || resultadosPruebasRapidas.isEmpty()) {
            resultadosPruebasRapidas = new ArrayList();
            resultadosPruebasRapidas.add(new SelectItem("P", "Reactivo "));
            resultadosPruebasRapidas.add(new SelectItem("N", "No Reactivo"));

        }
        return resultadosPruebasRapidas;
    }
    
    public void setFacSangreSelect(ValueChangeEvent valueChangeEvent) {
        antedecentesDetallado.setHadcrh((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setPreguntasToxicologicasSelect(ValueChangeEvent valueChangeEvent) {
        setLstPreguntasToxicologicasSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstPreguntasToxicologicasSelect(List<String> lstPreguntasToxicologicasSelect) {
        this.lstPreguntasToxicologicasSelect = lstPreguntasToxicologicasSelect;
    }

    public List<String> getLstPreguntasToxicologicasSelect() {
        return lstPreguntasToxicologicasSelect;
    }

    public void setLstPreguntasToxicologicas(List lstPreguntasToxicologicas) {
        this.lstPreguntasToxicologicas = lstPreguntasToxicologicas;
    }

    public List getLstPreguntasToxicologicas() {
        if (lstPreguntasToxicologicas == null || lstPreguntasToxicologicas.isEmpty()) {
            lstPreguntasToxicologicas = new ArrayList();
            lstPreguntasToxicologicas.add(new SelectItem("FA", "Fumadora activa"));
            lstPreguntasToxicologicas.add(new SelectItem("FP", "Fumadora pasiva"));
            lstPreguntasToxicologicas.add(new SelectItem("SP", "Sustancias Psicoactivas"));
            lstPreguntasToxicologicas.add(new SelectItem("AL", "Alcohol"));

        }
        return lstPreguntasToxicologicas;
    }
    
    public void changePreguntasToxicologicas() {
        if (lstPreguntasToxicologicasSelect != null && 
            !lstPreguntasToxicologicasSelect.isEmpty()) {
            
            antedecentesDetallado.setHadcfumacttox("N");
            antedecentesDetallado.setHadcfumpastox("N");
            antedecentesDetallado.setHadcsuspsitox("N");
            antedecentesDetallado.setHadcalctox("N");
            
            for (Iterator iterator = lstPreguntasToxicologicasSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("FA")){
                    antedecentesDetallado.setHadcfumacttox("S");
                }
                
                if (codigo.equals("FP")){
                    antedecentesDetallado.setHadcfumpastox("S");
                }
                
                if (codigo.equals("SP")){
                    antedecentesDetallado.setHadcsuspsitox("S");
                }
                
                if (codigo.equals("AL")){
                    antedecentesDetallado.setHadcalctox("S");
                }
            }

        }
    }

    public void setLstPreguntasPatologia(List lstOpcionesPatologia) {
        this.lstPreguntasPatologia = lstOpcionesPatologia;
    }

    public List getLstPreguntasPatologia() {
    
        if (lstPreguntasPatologia == null || lstPreguntasPatologia.isEmpty()) {
            lstPreguntasPatologia = new ArrayList();
            lstPreguntasPatologia.add(new SelectItem("TBC", "TBC(Personal)"));
            lstPreguntasPatologia.add(new SelectItem("DIA", "Diabetes(Personal)"));
            lstPreguntasPatologia.add(new SelectItem("HIP", "Hipertensi�n (Personal)"));
            lstPreguntasPatologia.add(new SelectItem("PRE", "Preclampsia"));
            lstPreguntasPatologia.add(new SelectItem("ECL", "Eclampsia"));
            lstPreguntasPatologia.add(new SelectItem("INF", "Infertilidad"));
            lstPreguntasPatologia.add(new SelectItem("CAR", "Cardiopat�a"));
            lstPreguntasPatologia.add(new SelectItem("NEF", "Nefropat�a"));

        }
        return lstPreguntasPatologia;
    }
    
    public void changeOpcionesPreguntasPatologiasAnt() {    
        if (lstPreguntasPatologicasSelect != null && 
            !lstPreguntasPatologicasSelect.isEmpty()) {
            for (Iterator iterator = lstPreguntasPatologicasSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("TBC")){
                    renderTbcPato = true;
                }else {
                    antedecentesDetallado.setHadctbcpatdes(null);
                }
                
                if (codigo.equals("DIA")){
                    renderDiabetesPato = true;
                }else {
                    antedecentesDetallado.setHadcdiapatdes(null);
                }
                
                if (codigo.equals("HIP")){
                    renderHipertensionPato = true;
                }else {
                    antedecentesDetallado.setHadchippatdes(null);
                }
                
                if (codigo.equals("PRE")){
                    renderPreclampsiaPato = true;
                }else {
                    antedecentesDetallado.setHadcprepatdes(null);
                }
                
                if (codigo.equals("ECL")){
                    renderEclampsiaPato = true;
                }else {
                    antedecentesDetallado.setHadceclapato(null);
                }
                
                if (codigo.equals("INF")){
                    renderInfertilidadPato = true;
                }else {
                    antedecentesDetallado.setHadcifepatdes(null);
                }
                
                if (codigo.equals("CAR")){
                    renderCardiopatiaPato = true;
                }else {
                    antedecentesDetallado.setHadccarpatdes(null);
                }
                
                if (codigo.equals("NEF")){
                    renderNefropatiaPato = true;
                }else {
                    antedecentesDetallado.setHadcnefpatdes(null);
                }
            }

        }
    }
    
    public void changePreguntasPatologias() {
        if (antedecentesDetallado != null) {
            if (lstPatologicosIveSelected != null && 
                !lstPatologicosIveSelected.isEmpty()) {
                
                antedecentesDetallado.setHadctbcpato("N");
                antedecentesDetallado.setHadcdiabpato("N");
                antedecentesDetallado.setHadchipepato("N");
                antedecentesDetallado.setHadcprecpato("N");
                antedecentesDetallado.setHadceclapato("N");
                antedecentesDetallado.setHadciferpato("N");
                antedecentesDetallado.setHadccardpato("N");
                antedecentesDetallado.setHadcnefrpato("N");
                
                for (Iterator iterator = lstPatologicosIveSelected.iterator(); 
                     iterator.hasNext(); ) {
                    String codigo = (String)iterator.next();
                    if (codigo.equals("TBC")){
                        antedecentesDetallado.setHadctbcpato("S");
                    }
                    if (codigo.equals("DIA")){
                        antedecentesDetallado.setHadcdiabpato("S");
                    }    
                    if (codigo.equals("HIP")){
                        antedecentesDetallado.setHadchipepato("S");
                    }
                    if (codigo.equals("PRE")){
                        antedecentesDetallado.setHadcprecpato("S");
                    }
                    if (codigo.equals("ECL")){
                        antedecentesDetallado.setHadceclapato("S");
                    }
                    if (codigo.equals("INF")){
                        antedecentesDetallado.setHadciferpato("S");
                    }
                    if (codigo.equals("CAR")){
                        antedecentesDetallado.setHadccardpato("S");
                    }
                    if (codigo.equals("NEF")){
                        antedecentesDetallado.setHadcnefrpato("S");
                    }
                }

            }
        }
    }
    public void changePatologia(){
        lstPatologicosIveSelected = new ArrayList<String>();
        if("S".equals(antedecentesDetallado.getHadcantepato())){
            renderPatologia =true;
            if(antedecentesDetallado.getHadctbcpato()== null){
                antedecentesDetallado.setHadctbcpato("N");
            }
            if(antedecentesDetallado.getHadcdiabpato()== null){
                antedecentesDetallado.setHadcdiabpato("N");
            }
            
            if(antedecentesDetallado.getHadchipepato()== null){
                antedecentesDetallado.setHadchipepato("N");
            }
            
            if(antedecentesDetallado.getHadcprecpato()== null){
                antedecentesDetallado.setHadcprecpato("N");
            }
            
            if(antedecentesDetallado.getHadceclapato()== null){
                antedecentesDetallado.setHadceclapato("N");
            }
            
            if(antedecentesDetallado.getHadccardpato()== null){
                antedecentesDetallado.setHadccardpato("N");
            }
            if(antedecentesDetallado.getHadciferpato()== null){
                antedecentesDetallado.setHadciferpato("N");
            } 
            
            if(antedecentesDetallado.getHadcnefrpato()== null){
                antedecentesDetallado.setHadcnefrpato("N");
            }   
            
        }else if("N".equals(antedecentesDetallado.getHadcantepato())){
            antedecentesDetallado.setHadctbcpato("N");
            antedecentesDetallado.setHadcdiabpato("N");
            antedecentesDetallado.setHadchipepato("N");
            antedecentesDetallado.setHadcprecpato("N");
            antedecentesDetallado.setHadceclapato("N");
            antedecentesDetallado.setHadciferpato("N");
            antedecentesDetallado.setHadccardpato("N");
            antedecentesDetallado.setHadcnefrpato("N");
            
            antedecentesDetallado.setHadctbcpatdes(null);
            antedecentesDetallado.setHadcdiapatdes(null);
            antedecentesDetallado.setHadchippatdes(null);
            antedecentesDetallado.setHadcprepatdes(null);
            antedecentesDetallado.setHadceclpatdes(null);
            antedecentesDetallado.setHadcifepatdes(null);
            antedecentesDetallado.setHadccarpatdes(null);
            antedecentesDetallado.setHadcnefpatdes(null);
            antedecentesDetallado.setHadcpatdes(null);
            
            renderPatologia =false;
        }else{
            antedecentesDetallado.setHadctbcpato(null);
            antedecentesDetallado.setHadcdiabpato(null);
            antedecentesDetallado.setHadchipepato(null);
            antedecentesDetallado.setHadcprecpato(null);
            antedecentesDetallado.setHadceclapato(null);
            antedecentesDetallado.setHadciferpato(null);
            antedecentesDetallado.setHadccardpato(null);
            antedecentesDetallado.setHadcnefrpato(null);
            
            antedecentesDetallado.setHadctbcpatdes(null);
            antedecentesDetallado.setHadcdiapatdes(null);
            antedecentesDetallado.setHadchippatdes(null);
            antedecentesDetallado.setHadcprepatdes(null);
            antedecentesDetallado.setHadceclpatdes(null);
            antedecentesDetallado.setHadcifepatdes(null);
            antedecentesDetallado.setHadccarpatdes(null);
            antedecentesDetallado.setHadcnefpatdes(null);
            antedecentesDetallado.setHadcpatdes(null);
            
            renderPatologia =false;
        }
    }
    
    public void changePatologiaFertilidad() {
        renderPatologia = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantepato() != null && 
            antedecentesDetallado.getHadcantepato().equals("S")) {
            renderPatologia = true;
        }
        if(renderPatologia == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcantepato("N");
                antedecentesDetallado.setHadcpatdes(null);
                antedecentesDetallado.setHadcendoundo(null);
                antedecentesDetallado.setHadcendotrcu(null);
                antedecentesDetallado.setHadcepi(null);
                
            }
        }
    }
    
    public void changeQuirurgicoFertilidad() {
        renderQuirurgicos = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcanteqx() != null && 
            antedecentesDetallado.getHadcanteqx().equals("S")) {
            renderQuirurgicos = true;
        }
        if(renderQuirurgicos == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcquirdes(null);
                antedecentesDetallado.setHadccirabd(null);
                antedecentesDetallado.setHadclapparosc(null);
                
            }
        }
    }
    
    public void changeToxicoFertilidad() {
        renderToxicologico = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantetoxi() != null && 
            antedecentesDetallado.getHadcantetoxi().equals("S")) {
            renderToxicologico = true;
        }
        if(renderToxicologico == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadctoxdes(null);
            }
        }
        
    }
    
    public void changeAlergicoFertilidad() {
        renderAlergico = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantealer() != null && 
            antedecentesDetallado.getHadcantealer().equals("S")) {
            renderAlergico = true;
        }
        if(renderAlergico == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcaledes(null);
            }
        }
    }
    
    public void changeFamiliarFertilidad() {
        renderFamiliar = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantefami() != null && 
            antedecentesDetallado.getHadcantefami().equals("S")) {
            renderFamiliar = true;
        }
        if(renderFamiliar == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcfamdes(null);
                antedecentesDetallado.setHadcinffam(null);
                antedecentesDetallado.setHadcprogenfa(null);
                
            }
        }
    }
    
    public void changeTransfusionalFertilidad() {
        renderTransfusionales = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantetran() != null && 
            antedecentesDetallado.getHadcantetran().equals("S")) {
            renderTransfusionales = true;
        }
        if(renderTransfusionales == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadctransdes(null);
                
            }
        }
    }
    
    public void changeITSFertilidad() {
        renderITS = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantits() != null && 
            antedecentesDetallado.getHadcantits().equals("S")) {
            renderITS= true;
        }
        if(renderITS == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcitsdes(null);
                
            }
        }
    }
    
    public void changeFarmacologicosFertilidad() {
        renderFarmacologicos = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantefarm() != null && 
            antedecentesDetallado.getHadcantefarm().equals("S")) {
            renderFarmacologicos= true;
        }
        if(renderFarmacologicos == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcfarmdes(null);
                
            }
        }
    }
    
    public void changeTraumatologicosFertilidad() {
        renderTraumaticos = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantetrau() != null && 
            antedecentesDetallado.getHadcantetrau().equals("S")) {
            renderTraumaticos= true;
        }
        if(renderTraumaticos == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadctraudes(null);
                
            }
        }
    }
    
    public void changeGeneticosFertilidad() {
        renderGenetico = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantegen() != null && 
            antedecentesDetallado.getHadcantegen().equals("S")) {
            renderGenetico= true;
        }
        if(renderGenetico == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcgendes(null);
                
            }
        }
    }
    
    
    public void changeMasculinoFertilidad() {
        renderMasculino = false;
        if (antedecentesDetallado != null && antedecentesDetallado.getHadcantemas() != null && 
            antedecentesDetallado.getHadcantemas().equals("S")) {
            renderMasculino= true;
        }
        if(renderMasculino == false){
            if(antedecentesDetallado !=null){
                antedecentesDetallado.setHadcmasdes(null);
                antedecentesDetallado.setHadcpaternidad(null);
                antedecentesDetallado.setHadcorquitis(null);
                antedecentesDetallado.setHadccriporquidea(null);
                antedecentesDetallado.setHadctrautest(null);
                antedecentesDetallado.setHadccirtest(null);
                antedecentesDetallado.setHadcquimrad(null);
                antedecentesDetallado.setHadcitsmas(null);
                antedecentesDetallado.setHadcocuparies(null);
                antedecentesDetallado.setHadcdiserectil(null);
                antedecentesDetallado.setHadceyaprecoz(null);
                
            }
        }
    }
    
    public void changePreguntasAnteceFamiliares() {
            if (antedecentesDetallado != null) {
                if (lstFamiliaresIveSelected != null && 
                    !lstFamiliaresIveSelected.isEmpty()) {
                    
                    antedecentesDetallado.setHadctbcfami("N");
                    antedecentesDetallado.setHadcdiabfami("N");
                    antedecentesDetallado.setHadchipefami("N");
                    antedecentesDetallado.setHadcprecfami("N");
                    antedecentesDetallado.setHadceclafami("N");
                    
                    for (Iterator iterator = lstFamiliaresIveSelected.iterator(); 
                         iterator.hasNext(); ) {
                        String codigo = (String)iterator.next();
                        if (codigo.equals("TBC")){
                            antedecentesDetallado.setHadctbcfami("S");
                        }
                        if (codigo.equals("DIA")){
                            antedecentesDetallado.setHadcdiabfami("S");
                        }    
                        if (codigo.equals("HIP")){
                            antedecentesDetallado.setHadchipefami("S");
                        }
                        if (codigo.equals("PRE")){
                            antedecentesDetallado.setHadcprecfami("S");
                        }
                        if (codigo.equals("ECL")){
                            antedecentesDetallado.setHadceclafami("S");
                        }
                    }

                }
            }
    }
    
    public void changeAntFamiliares(){
        lstFamiliaresIveSelected = new ArrayList<String>();
        if("S".equals(antedecentesDetallado.getHadcantefami())){
            renderFamiliar =true;
            
            if(antedecentesDetallado.getHadctbcfami()== null){
                antedecentesDetallado.setHadctbcfami("N");
            }
            if(antedecentesDetallado.getHadcdiabfami()== null){
                antedecentesDetallado.setHadcdiabfami("N");
            }
            
            if(antedecentesDetallado.getHadchipefami()== null){
                antedecentesDetallado.setHadchipefami("N");
            }
            
            if(antedecentesDetallado.getHadcprecfami()== null){
                antedecentesDetallado.setHadcprecfami("N");
            }
            
            if(antedecentesDetallado.getHadceclafami()== null){
                antedecentesDetallado.setHadceclafami("N");
            }

        }else if("N".equals(antedecentesDetallado.getHadcantefami())){
            antedecentesDetallado.setHadctbcfami("N");
            antedecentesDetallado.setHadcdiabfami("N");
            antedecentesDetallado.setHadchipefami("N");
            antedecentesDetallado.setHadcprecfami("N");
            antedecentesDetallado.setHadceclafami("N");
            
            antedecentesDetallado.setHadctbcfamdes(null);
            antedecentesDetallado.setHadcdiafamdes(null);
            antedecentesDetallado.setHadchipfamdes(null);
            antedecentesDetallado.setHadcprefamdes(null);
            antedecentesDetallado.setHadceclfamdes(null);
            
            antedecentesDetallado.setHadcfamdes(null);
            renderFamiliar =false;
        }else{
            antedecentesDetallado.setHadctbcfami(null);
            antedecentesDetallado.setHadcdiabfami(null);
            antedecentesDetallado.setHadchipefami(null);
            antedecentesDetallado.setHadcprecfami(null);
            antedecentesDetallado.setHadceclafami(null);
            
            antedecentesDetallado.setHadctbcfamdes(null);
            antedecentesDetallado.setHadcdiafamdes(null);
            antedecentesDetallado.setHadchipfamdes(null);
            antedecentesDetallado.setHadcprefamdes(null);
            antedecentesDetallado.setHadceclfamdes(null);
            
            antedecentesDetallado.setHadcfamdes(null);
            renderFamiliar =false;   
        }
    }
    
    public void changeAntToxicologicos(){
        lstPreguntasToxicologicasSelect = new ArrayList<String>();
        if("S".equals(antedecentesDetallado.getHadcantetoxi())){
            renderToxicologico =true;
        }else if("N".equals(antedecentesDetallado.getHadcantetoxi())){
             antedecentesDetallado.setHadcfumacttox("N");

             antedecentesDetallado.setHadcfumpastox("N");
            
             antedecentesDetallado.setHadcsuspsitox("N");

             antedecentesDetallado.setHadcalctox("N");
             
            antedecentesDetallado.setHadctoxdes(null);
            
            renderToxicologico =false;
        }else{
            antedecentesDetallado.setHadcfumacttox(null);

            antedecentesDetallado.setHadcfumpastox(null);
            
            antedecentesDetallado.setHadcsuspsitox(null);

            antedecentesDetallado.setHadcalctox(null);
            
            antedecentesDetallado.setHadctoxdes(null);
            
            renderToxicologico =false;
        }
    }
    
    public void inicializarChkBoxes(){
    lstPatologicosSelected = new ArrayList<String>();
    lstMasculinosSelected = new ArrayList<String>();
    lstFamiliaresSelected = new ArrayList<String>();
    lstQuirurgicosSelected = new ArrayList<String>();
        if ("S".equals(antedecentesDetallado.getHadcendoundo())){
            lstPatologicosSelected.add("EUD");
        }
        if ("S".equals(antedecentesDetallado.getHadcendotrcu())){
            lstPatologicosSelected.add("ETC");
        }
        if ("S".equals(antedecentesDetallado.getHadcepi())){
            lstPatologicosSelected.add("EPI");
        }
        if ("S".equals(antedecentesDetallado.getHadccirabd())){
            lstQuirurgicosSelected.add("CIA");
        }
        if ("S".equals(antedecentesDetallado.getHadclapparosc())){
            lstQuirurgicosSelected.add("LAP");
        }
        if ("S".equals(antedecentesDetallado.getHadcinffam())){
            lstFamiliaresSelected.add("IFA");
        }
        if ("S".equals(antedecentesDetallado.getHadcprogenfa())){
            lstFamiliaresSelected.add("PGF");
        }
        if ("S".equals(antedecentesDetallado.getHadcpaternidad())){
            lstMasculinosSelected.add("PAT");
        }
        if ("S".equals(antedecentesDetallado.getHadcorquitis())){
            lstMasculinosSelected.add("ORQ");
        }
        if ("S".equals(antedecentesDetallado.getHadccriporquidea())){
            lstMasculinosSelected.add("CRI");
        }
        if ("S".equals(antedecentesDetallado.getHadctrautest())){
            lstMasculinosSelected.add("TTE");
        }
        if ("S".equals(antedecentesDetallado.getHadccirtest())){
            lstMasculinosSelected.add("CTE");
        }
        if ("S".equals(antedecentesDetallado.getHadcitsmas())){
            lstMasculinosSelected.add("ITS");
        }
        if ("S".equals(antedecentesDetallado.getHadcquimrad())){
            lstMasculinosSelected.add("QRA");
        }
        if ("S".equals(antedecentesDetallado.getHadcocuparies())){
            lstMasculinosSelected.add("ORI");
        }
        if ("S".equals(antedecentesDetallado.getHadcdiserectil())){
            lstMasculinosSelected.add("DER");
        }
        if ("S".equals(antedecentesDetallado.getHadceyaprecoz())){
            lstMasculinosSelected.add("EPR");
        }
    }
    
    public void cambiarAntecedentesDetallados(){
        antedecentesDetallado.setHadcendoundo(null);
        antedecentesDetallado.setHadcendotrcu(null);
            antedecentesDetallado.setHadcepi(null);
            antedecentesDetallado.setHadccirabd(null);
            antedecentesDetallado.setHadclapparosc(null);
            antedecentesDetallado.setHadcinffam(null);
            antedecentesDetallado.setHadcprogenfa(null);
            antedecentesDetallado.setHadcpaternidad(null);
            antedecentesDetallado.setHadcorquitis(null);
            antedecentesDetallado.setHadccriporquidea(null);
            antedecentesDetallado.setHadctrautest(null);
            antedecentesDetallado.setHadccirtest(null);
            antedecentesDetallado.setHadcquimrad(null);
            antedecentesDetallado.setHadcocuparies(null);
            antedecentesDetallado.setHadcdiserectil(null);
            antedecentesDetallado.setHadceyaprecoz(null);
        for (String codigo: lstPatologicosSelected) {
            System.out.println(codigo);
            if (codigo != null) {
                if (codigo.equals("EUD")) {
                    antedecentesDetallado.setHadcendoundo("S");
                } else if (codigo.equals("ETC")) {
                    antedecentesDetallado.setHadcendotrcu("S");
                } else if (codigo.equals("EPI")) {
                    antedecentesDetallado.setHadcepi("S");
                } 
               
            }
        }
        for (String codigo: lstQuirurgicosSelected) {
            if (codigo != null) {
                if (codigo.equals("CIA")) {
                    antedecentesDetallado.setHadccirabd("S");
                } else if (codigo.equals("LAP")) {
                    antedecentesDetallado.setHadclapparosc("S");
                }   
            }
        }
        
        for (String codigo: lstFamiliaresSelected) {
            if (codigo != null) {
                if (codigo.equals("IFA")) {
                    antedecentesDetallado.setHadcinffam("S");
                } else if (codigo.equals("PGF")) {
                    antedecentesDetallado.setHadcprogenfa("S");
                }   
            }
        }
        
        for (String codigo: lstMasculinosSelected) {
            if (codigo != null) {
                if (codigo.equals("PAT")) {
                    antedecentesDetallado.setHadcpaternidad("S");
                } else if (codigo.equals("ORQ")) {
                    antedecentesDetallado.setHadcorquitis("S");
                }
                else if (codigo.equals("CRI")) {
                    antedecentesDetallado.setHadccriporquidea("S");
                } 
                else if (codigo.equals("TTE")) {
                    antedecentesDetallado.setHadctrautest("S");
                }
                else if (codigo.equals("CTE")) {
                    antedecentesDetallado.setHadccirtest("S");
                }
                else if (codigo.equals("ITS")) {
                    antedecentesDetallado.setHadcitsmas("S");
                }
                else if (codigo.equals("QRA")) {
                    antedecentesDetallado.setHadcquimrad("S");
                } 
                else if (codigo.equals("ORI")) {
                    antedecentesDetallado.setHadcocuparies("S");
                }
                else if (codigo.equals("DER")) {
                    antedecentesDetallado.setHadcdiserectil("S");
                }
                else if (codigo.equals("EPR")) {
                    antedecentesDetallado.setHadceyaprecoz("S");
                }  
            }
        }
    }

    
    
    public void changeGrupoSanguineo(){
        if(!"NS".equals(antedecentesDetallado.getHadcgrupsang())){
            renderGrupoSanguineo =true;
        }else{
            antedecentesDetallado.setHadcrh(null);
            
            antedecentesDetallado.setHadcisoinabort(null);
             
            renderGrupoSanguineo =false;
            renderRH =false;
        }
    }
    
    
    public void changePreguntasAntQuirurgicos() {
        if (antedecentesDetallado != null) {
            if (lstQuirurgicosIveSelected != null && 
                !lstQuirurgicosIveSelected.isEmpty()) {
                
                antedecentesDetallado.setHadcgeurqx("N");
                
                for (Iterator iterator = lstQuirurgicosIveSelected.iterator(); 
                     iterator.hasNext(); ) {
                    String codigo = (String)iterator.next();
                    if (codigo.equals("CG")){
                        antedecentesDetallado.setHadcgeurqx("S");
                    }else {
                    
                    }
                }

            }
        }
        renderCirugiaGenUri = false;
    }
    
    public void changeAntAlergico(){
        if("S".equals(antedecentesDetallado.getHadcantealer())){
            renderAlergico =true;
           
        }else{
            renderAlergico =false;
            antedecentesDetallado.setHadcantaledes(null);
        }
    }
    
    public void changeAntFarmacologicos(){
        if("S".equals(antedecentesDetallado.getHadcantefarm())){
            renderFarmacologicos =true;
           
        }else{
            renderFarmacologicos =false;
            antedecentesDetallado.setHadcantfardes(null);
        }
    }
    
    public void changeAntTraumaticos(){
        if("S".equals(antedecentesDetallado.getHadcantetrau())){
            renderTraumaticos =true;
           
        }else{
            renderTraumaticos =false;
            antedecentesDetallado.setHadctraantdesc(null);
        }
    }
    
    
    public void changeTodosNo() {
        inicializarPregunta("N");
    }

    public void changeTodosSi() {
        inicializarPregunta("S");
    }
    public void changeAntQuirurgicos(){
        lstQuirurgicosIveSelected = new ArrayList<String>();
        if("S".equals(antedecentesDetallado.getHadcanteqx())){
            renderQuirurgicos =true;
            if(antedecentesDetallado.getHadcgeurqx()== null){
                antedecentesDetallado.setHadcgeurqx("N");
            }
        }else if("N".equals(antedecentesDetallado.getHadcanteqx())){
            renderQuirurgicos =false;
            antedecentesDetallado.setHadcgeurqx("N");
            antedecentesDetallado.setHadcgeurqxdes(null);
        }else{
            renderQuirurgicos =false;
            antedecentesDetallado.setHadcgeurqx(null);
            antedecentesDetallado.setHadcgeurqxdes(null);
        }
    }
    
    
    public void changeAntTransfusionales(){
        if("S".equals(antedecentesDetallado.getHadcantetran())){
            renderTransfusionales =true;
           
        }else{
            renderTransfusionales =false;
            antedecentesDetallado.setHadcanttrades(null);
        }
    }
    
    public void changeAntITS(){
        if("S".equals(antedecentesDetallado.getHadcantits())){
            renderITS =true;
           
        }else{
            renderITS =false;
            antedecentesDetallado.setHadcantitsdes(null);
        }
    }
    
    public void changeNinguno() {
        inicializarPregunta(null);
    }
    
    public void inicializarPregunta(String opcion){
        antedecentesDetallado.setHadcantepato(opcion);
        changePatologia();
        antedecentesDetallado.setHadcantefami(opcion);
        changeAntFamiliares();
        antedecentesDetallado.setHadcantetoxi(opcion);
        changeAntToxicologicos();
        antedecentesDetallado.setHadcanteqx(opcion);
        changeAntQuirurgicos();
        antedecentesDetallado.setHadcantealer(opcion);
        changeAntAlergico();
        antedecentesDetallado.setHadcantetran(opcion);
        changeAntTransfusionales();
        antedecentesDetallado.setHadcantits(opcion);
        changeAntITS();
        antedecentesDetallado.setHadcantefarm(opcion);
        changeAntFarmacologicos();
        antedecentesDetallado.setHadcantetrau(opcion);
        changeAntTraumaticos();
        antedecentesDetallado.setHadcantegen(opcion);
        changeGeneticosFertilidad();
        antedecentesDetallado.setHadcantemas(opcion);
        changeMasculinoFertilidad();

        
    }
    
    public void changeNuevosAntecedentes(){
        if("S".equals(antedecentesDetallado.getHadcantenuev())){
            renderAntecedentesDetallado =true;
            changeNinguno();
           
        }else{
            renderAntecedentesDetallado =false;
            changeNinguno();
        }
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNuevosAntecedentesEvent(ValueChangeEvent valueChangeEvent) {
        antedecentesDetallado.setHadcantenuev((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    

    public void setLstPreguntasPatologicasSelect(List<String> lstPreguntasPatologicasSelect) {
        this.lstPreguntasPatologicasSelect = lstPreguntasPatologicasSelect;
    }

    public List<String> getLstPreguntasPatologicasSelect() {
        return lstPreguntasPatologicasSelect;
    }
    
    public void setPreguntasPatologiaSelect(ValueChangeEvent valueChangeEvent) {
        setLstPreguntasPatologicasSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderTbcPato(boolean renderTbcPato) {
        this.renderTbcPato = renderTbcPato;
    }

    public boolean isRenderTbcPato() {
        return renderTbcPato;
    }

    public void setRenderDiabetesPato(boolean renderDiabetesPato) {
        this.renderDiabetesPato = renderDiabetesPato;
    }

    public boolean isRenderDiabetesPato() {
        return renderDiabetesPato;
    }

    public void setRenderHipertensionPato(boolean renderHipertensionPato) {
        this.renderHipertensionPato = renderHipertensionPato;
    }

    public boolean isRenderHipertensionPato() {
        return renderHipertensionPato;
    }

    public void setRenderPreclampsiaPato(boolean renderPreclampsiaPato) {
        this.renderPreclampsiaPato = renderPreclampsiaPato;
    }

    public boolean isRenderPreclampsiaPato() {
        return renderPreclampsiaPato;
    }

    public void setRenderEclampsiaPato(boolean renderEclampsiaPato) {
        this.renderEclampsiaPato = renderEclampsiaPato;
    }

    public boolean isRenderEclampsiaPato() {
        return renderEclampsiaPato;
    }

    public void setRenderInfertilidadPato(boolean renderInfertilidadPato) {
        this.renderInfertilidadPato = renderInfertilidadPato;
    }

    public boolean isRenderInfertilidadPato() {
        return renderInfertilidadPato;
    }

    public void setRenderCardiopatiaPato(boolean renderCardiopatiaPato) {
        this.renderCardiopatiaPato = renderCardiopatiaPato;
    }

    public boolean isRenderCardiopatiaPato() {
        return renderCardiopatiaPato;
    }

    public void setRenderNefropatiaPato(boolean renderNefropatiaPato) {
        this.renderNefropatiaPato = renderNefropatiaPato;
    }

    public boolean isRenderNefropatiaPato() {
        return renderNefropatiaPato;
    }

    public void setRenderPatologia(boolean renderPatologia) {
        this.renderPatologia = renderPatologia;
    }

    public boolean isRenderPatologia() {
        return renderPatologia;
    }

    public void setRenderTbcFami(boolean renderTbcFami) {
        this.renderTbcFami = renderTbcFami;
    }

    public boolean isRenderTbcFami() {
        return renderTbcFami;
    }

    public void setRenderDiabetesFami(boolean renderDiabetesFami) {
        this.renderDiabetesFami = renderDiabetesFami;
    }

    public boolean isRenderDiabetesFami() {
        return renderDiabetesFami;
    }

    public void setRenderHipertensionFami(boolean renderHipertensionFami) {
        this.renderHipertensionFami = renderHipertensionFami;
    }

    public boolean isRenderHipertensionFami() {
        return renderHipertensionFami;
    }

    public void setRenderPreclampsiaFami(boolean renderPreclampsiaFami) {
        this.renderPreclampsiaFami = renderPreclampsiaFami;
    }

    public boolean isRenderPreclampsiaFami() {
        return renderPreclampsiaFami;
    }

    public void setRenderEclampsiaFami(boolean renderEclampsiaFami) {
        this.renderEclampsiaFami = renderEclampsiaFami;
    }

    public boolean isRenderEclampsiaFami() {
        return renderEclampsiaFami;
    }

    public void setRenderFamiliar(boolean renderFamiliar) {
        this.renderFamiliar = renderFamiliar;
    }

    public boolean isRenderFamiliar() {
        return renderFamiliar;
    }

    public void setRenderToxicologico(boolean renderToxicologico) {
        this.renderToxicologico = renderToxicologico;
    }

    public boolean isRenderToxicologico() {
        return renderToxicologico;
    }

    public void setRenderGrupoSanguineo(boolean renderGrupoSanguineo) {
        this.renderGrupoSanguineo = renderGrupoSanguineo;
    }

    public boolean isRenderGrupoSanguineo() {
        return renderGrupoSanguineo;
    }

    public void setRenderAntecedentesGinecologicos(boolean renderAntecedentesGinecologicos) {
        this.renderAntecedentesGinecologicos = renderAntecedentesGinecologicos;
    }

    public boolean isRenderAntecedentesGinecologicos() {
        return renderAntecedentesGinecologicos;
    }

    public void setNuevosAntecedentes(ValueChangeEvent valueChangeEvent) {
        antedecentesDetallado.setHadcantenuev((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setPreguntasPruebasRapidasSelect(ValueChangeEvent valueChangeEvent) {
        setLstOpcionesPruebasRapidasSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderCirugiaGenUri(boolean renderCirugiaGenUri) {
        this.renderCirugiaGenUri = renderCirugiaGenUri;
    }

    public boolean isRenderCirugiaGenUri() {
        return renderCirugiaGenUri;
    }

    public void setIdentifi(Chidentiriesgo identifi) {
        this.identifi = identifi;
    }

    public Chidentiriesgo getIdentifi() {
        return identifi;
    }

    public void setRenderQuirurgicos(boolean renderQuirurgicos) {
        this.renderQuirurgicos = renderQuirurgicos;
    }

    public boolean isRenderQuirurgicos() {
        return renderQuirurgicos;
    }

    public void setRenderAlergico(boolean renderAlergico) {
        this.renderAlergico = renderAlergico;
    }

    public boolean isRenderAlergico() {
        return renderAlergico;
    }

    public void setRenderTransfusionales(boolean renderTransfusionales) {
        this.renderTransfusionales = renderTransfusionales;
    }

    public boolean isRenderTransfusionales() {
        return renderTransfusionales;
    }


    public void setRenderITS(boolean renderITS) {
        this.renderITS = renderITS;
    }

    public boolean isRenderITS() {
        return renderITS;
    }

    public void setRenderFarmacologicos(boolean renderFarmacologicos) {
        this.renderFarmacologicos = renderFarmacologicos;
    }

    public boolean isRenderFarmacologicos() {
        return renderFarmacologicos;
    }


    public void setLstOpcionesAntecedentes(List lstOpcionesAntecedentes) {
        this.lstOpcionesAntecedentes = lstOpcionesAntecedentes;
    }

    public List getLstOpcionesAntecedentes() {
        if (lstOpcionesAntecedentes == null || lstOpcionesAntecedentes.isEmpty()) {
            lstOpcionesAntecedentes = new ArrayList();
            lstOpcionesAntecedentes.add(new SelectItem("S", "Refiere"));
            lstOpcionesAntecedentes.add(new SelectItem("N", "No Refiere"));

        }
        return lstOpcionesAntecedentes;
    }

    public void setRenderNuevoAntecedente(boolean renderNuevoAntecedente) {
        this.renderNuevoAntecedente = renderNuevoAntecedente;
    }

    public boolean isRenderNuevoAntecedente() {
        return renderNuevoAntecedente;
    }

    public void setRenderPrimeraVez(boolean renderPrimeraVez) {
        this.renderPrimeraVez = renderPrimeraVez;
    }

    public boolean isRenderPrimeraVez() {
        return renderPrimeraVez;
    }

    public void setRenderAntecedentesDetallado(boolean renderAntecedentesDetallado) {
        this.renderAntecedentesDetallado = renderAntecedentesDetallado;
    }

    public boolean isRenderAntecedentesDetallado() {
        return renderAntecedentesDetallado;
    }


    public void setLstPatologicos(List<SelectItem> lstPatologicos) {
        this.lstPatologicos = lstPatologicos;
    }

    public List<SelectItem> getLstPatologicos() {
    if(lstPatologicos == null || lstPatologicos.isEmpty()){
        lstPatologicos = new ArrayList<SelectItem>();
        lstPatologicos.add(new SelectItem("EUD", "Endometriosis I � II"));
        lstPatologicos.add(new SelectItem("ETC", "Endometriosis III � IV"));
        lstPatologicos.add(new SelectItem("EPI", "EPI (Enfermedad P�lvica Inflamatoria)"));
    }
        return lstPatologicos;
    }

    public void setLstQuirurgicos(List<SelectItem> lstQuirurgicos) {
        this.lstQuirurgicos = lstQuirurgicos;
    }

    public List<SelectItem> getLstQuirurgicos() {
    if(lstQuirurgicos == null || lstQuirurgicos.isEmpty()){
        lstQuirurgicos = new ArrayList<SelectItem>();
        lstQuirurgicos.add(new SelectItem("CIA","Cirug�a Abdominal"));
        lstQuirurgicos.add(new SelectItem("LAP","Laparoscopia"));
    }
        return lstQuirurgicos;
    }

    public void setLstFamiliares(List<SelectItem> lstFamiliares) {
        this.lstFamiliares = lstFamiliares;
    }

    public List<SelectItem> getLstFamiliares() {
    if(lstFamiliares == null || lstFamiliares.isEmpty()){
        lstFamiliares = new ArrayList<SelectItem>();
        lstFamiliares.add(new SelectItem("IFA","Infertilidad familiar"));
        lstFamiliares.add(new SelectItem("PGF","Problemas gen�ticos Familiares"));  
    }
        return lstFamiliares;
    }

    public void setLstMasculinos(List<SelectItem> lstMasculinos) {
        this.lstMasculinos = lstMasculinos;
    }

    public List<SelectItem> getLstMasculinos() {
    if(lstMasculinos == null || lstMasculinos.isEmpty()){
        lstMasculinos = new ArrayList<SelectItem>();
        lstMasculinos.add(new SelectItem("PAT","Paternidad"));
        lstMasculinos.add(new SelectItem("ORQ","Orquitis"));
        lstMasculinos.add(new SelectItem("CRI","Criptorquidia"));
        lstMasculinos.add(new SelectItem("TTE","Trauma Testicular"));
        lstMasculinos.add(new SelectItem("CTE","Cirug�a Testicular"));
        lstMasculinos.add(new SelectItem("ITS","ITS"));
        lstMasculinos.add(new SelectItem("QRA","Quimio / Radioterapia"));
        lstMasculinos.add(new SelectItem("ORI","Ocupacionales de riesgo"));
        lstMasculinos.add(new SelectItem("DER","Disfunci�n er�ctil"));
        lstMasculinos.add(new SelectItem("EPR","Eyaculaci�n precoz"));
        
        
    }
        return lstMasculinos;
    }

    public void setLstPatologicosSelected(List lstPatologicosSelected) {
        this.lstPatologicosSelected = lstPatologicosSelected;
    }

    public List getLstPatologicosSelected() {
        return lstPatologicosSelected;
    }

    public void setLstQuirurgicosSelected(List lstQuirurgicosSelected) {
        this.lstQuirurgicosSelected = lstQuirurgicosSelected;
    }

    public List getLstQuirurgicosSelected() {
        return lstQuirurgicosSelected;
    }

    public void setLstFamiliaresSelected(List lstFamiliaresSelected) {
        this.lstFamiliaresSelected = lstFamiliaresSelected;
    }

    public List getLstFamiliaresSelected() {
        return lstFamiliaresSelected;
    }

    public void setLstMasculinosSelected(List lstMasculinosSelected) {
        this.lstMasculinosSelected = lstMasculinosSelected;
    }

    public List getLstMasculinosSelected() {
        return lstMasculinosSelected;
    }


    public void setMnuPatologicos(UIInput mnuPatologicos) {
        this.mnuPatologicos = mnuPatologicos;
    }

    public UIInput getMnuPatologicos() {
        return mnuPatologicos;
    }


    public void setRenderGenetico(boolean renderGenetico) {
        this.renderGenetico = renderGenetico;
    }

    public boolean isRenderGenetico() {
        return renderGenetico;
    }

    public void setRenderMasculino(boolean renderMasculino) {
        this.renderMasculino = renderMasculino;
    }

    public boolean isRenderMasculino() {
        return renderMasculino;
    }

    public void setRenderTraumaticos(boolean renderTraumaticos) {
        this.renderTraumaticos = renderTraumaticos;
    }

    public boolean isRenderTraumaticos() {
        return renderTraumaticos;
    }
    public void setAntedecentesDetalladoLista(List<Chantecdetal> antedecentesDetalladoLista) {
        this.antedecentesDetalladoLista = antedecentesDetalladoLista;
    }

    public List<Chantecdetal> getAntedecentesDetalladoLista() {
        return antedecentesDetalladoLista;
    }

    public void setAntecedentesDetalladoHistorial(List<AntecedentesDetalladoDTO> antecedentesDetalladoDTOLista) {
        this.antecedentesDetalladoHistorial = antecedentesDetalladoDTOLista;
    }

    public List<AntecedentesDetalladoDTO> getAntecedentesDetalladoHistorial() {
        return antecedentesDetalladoHistorial;
    }

    public void setLstPatologicosIve(List<SelectItem> lstPatologicosIve) {
        this.lstPatologicosIve = lstPatologicosIve;
    }

    public List<SelectItem> getLstPatologicosIve() {
        if(lstPatologicosIve == null || lstPatologicosIve.isEmpty()){
            lstPatologicosIve = new ArrayList<SelectItem>();
            lstPatologicosIve.add(new SelectItem("TBC","Tuberculosis"));
            lstPatologicosIve.add(new SelectItem("DIA","Diabetes mellitus"));
            lstPatologicosIve.add(new SelectItem("HIP","Hipertensi�n arterial"));
            lstPatologicosIve.add(new SelectItem("PRE","Preclampsia"));
            lstPatologicosIve.add(new SelectItem("ECL","Eclampsia"));
            lstPatologicosIve.add(new SelectItem("INF","Infertilidad"));
            lstPatologicosIve.add(new SelectItem("CAR","Cardiopat�a"));
            lstPatologicosIve.add(new SelectItem("NEF","Nefropat�a"));
        }
        return lstPatologicosIve;
    }

    public void setLstPatologicosIveSelected(List<String> lstPatologicosIveSelected) {
        this.lstPatologicosIveSelected = lstPatologicosIveSelected;
    }

    public List<String> getLstPatologicosIveSelected() {
        return lstPatologicosIveSelected;
    }
    
    public void setPreguntasPatologicosIveSelected(ValueChangeEvent valueChangeEvent) {
        setLstPatologicosIveSelected((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstFamiliaresIve(List<SelectItem> lstFamiliaresIve) {
        this.lstFamiliaresIve = lstFamiliaresIve;
    }

    public List<SelectItem> getLstFamiliaresIve() {
        if(lstFamiliaresIve == null || lstFamiliaresIve.isEmpty()){
            lstFamiliaresIve = new ArrayList<SelectItem>();
            lstFamiliaresIve.add(new SelectItem("TBC","Tuberculosis"));
            lstFamiliaresIve.add(new SelectItem("DIA","Diabetes mellitus"));
            lstFamiliaresIve.add(new SelectItem("HIP","Hipertensi�n arterial"));
            lstFamiliaresIve.add(new SelectItem("PRE","Preclampsia"));
            lstFamiliaresIve.add(new SelectItem("ECL","Eclampsia"));
        }
        return lstFamiliaresIve;
    }


    public void setLstFamiliaresIveSelected(List<String> lstFamiliaresIveSelected) {
        this.lstFamiliaresIveSelected = lstFamiliaresIveSelected;
    }

    public List<String> getLstFamiliaresIveSelected() {
        return lstFamiliaresIveSelected;
    }
    
    public void setPreguntasFamiliaresIveSelected(ValueChangeEvent valueChangeEvent) {
        setLstFamiliaresIveSelected((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstQuirurgicosIve(List<SelectItem> lstQuirurgicosIve) {
        this.lstQuirurgicosIve = lstQuirurgicosIve;
    }

    public List<SelectItem> getLstQuirurgicosIve() {
        if(lstQuirurgicosIve == null || lstQuirurgicosIve.isEmpty()){
            lstQuirurgicosIve = new ArrayList<SelectItem>();
            lstQuirurgicosIve.add(new SelectItem("CG","Cirug�a genitourinaria"));
        }
        return lstQuirurgicosIve;
    }

    public void setLstQuirurgicosIveSelected(List<String> lstQuirurgicosIveSelected) {
        this.lstQuirurgicosIveSelected = lstQuirurgicosIveSelected;
    }

    public List<String> getLstQuirurgicosIveSelected() {
        return lstQuirurgicosIveSelected;
    }
    
    public void setPreguntasQuirurgicosIveSelected(ValueChangeEvent valueChangeEvent) {
        setLstQuirurgicosIveSelected((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void inicializarAntecentesCheck(){
    lstPatologicosIveSelected = new ArrayList<String>();
    lstFamiliaresIveSelected = new ArrayList<String>();
    lstQuirurgicosIveSelected = new ArrayList<String>();
    lstPreguntasToxicologicasSelect = new ArrayList<String>();
        
        //Antecedentes Patologicos
        if ("S".equals(antedecentesDetallado.getHadctbcpato())){
            lstPatologicosIveSelected.add("TBC");
        }
        if ("S".equals(antedecentesDetallado.getHadcdiabpato())){
            lstPatologicosIveSelected.add("DIA");
        }
        if ("S".equals(antedecentesDetallado.getHadchipepato())){
            lstPatologicosIveSelected.add("HIP");
        }
        if ("S".equals(antedecentesDetallado.getHadcprecpato())){
            lstPatologicosIveSelected.add("PRE");
        }
        if ("S".equals(antedecentesDetallado.getHadceclapato())){
            lstPatologicosIveSelected.add("ECL");
        }
        if ("S".equals(antedecentesDetallado.getHadciferpato())){
            lstPatologicosIveSelected.add("INF");
        }
        if ("S".equals(antedecentesDetallado.getHadccardpato())){
            lstPatologicosIveSelected.add("CAR");
        }
        if ("S".equals(antedecentesDetallado.getHadcnefrpato())){
            lstPatologicosIveSelected.add("NEF");
        }
        
        //Antecedentes Familiares
         
        if ("S".equals(antedecentesDetallado.getHadctbcfami())){
            lstFamiliaresIveSelected.add("TBC");
        }
        if ("S".equals(antedecentesDetallado.getHadcdiabfami())){
            lstFamiliaresIveSelected.add("DIA");
        }
        if ("S".equals(antedecentesDetallado.getHadchipefami())){
            lstFamiliaresIveSelected.add("HIP");
        }
        if ("S".equals(antedecentesDetallado.getHadcprecfami())){
            lstFamiliaresIveSelected.add("PRE");
        }
        if ("S".equals(antedecentesDetallado.getHadceclafami())){
            lstFamiliaresIveSelected.add("ECL");
        }
        
        //Antecedentes Quirurgicos     
        if ("S".equals(antedecentesDetallado.getHadcgeurqx())){
            lstQuirurgicosIveSelected.add("CG");
        }
        
        //Antecedentes Toxicologicos  
        
         if ("S".equals(antedecentesDetallado.getHadcfumacttox())){
             lstPreguntasToxicologicasSelect.add("FA");
         }
         
        if ("S".equals(antedecentesDetallado.getHadcfumpastox())){
            lstPreguntasToxicologicasSelect.add("FP");
        }
        
        if ("S".equals(antedecentesDetallado.getHadcsuspsitox())){
            lstPreguntasToxicologicasSelect.add("SP");
        }
       
    }

    public void setResultadosPruebasRapidasEmbarazo(List resultadosPruebasRapidasEmbarazo) {
        this.resultadosPruebasRapidasEmbarazo = resultadosPruebasRapidasEmbarazo;
    }

    public List getResultadosPruebasRapidasEmbarazo() {
        if (resultadosPruebasRapidasEmbarazo == null || resultadosPruebasRapidasEmbarazo.isEmpty()) {
            resultadosPruebasRapidasEmbarazo = new ArrayList();
            resultadosPruebasRapidasEmbarazo.add(new SelectItem("P", "Positivo "));
            resultadosPruebasRapidasEmbarazo.add(new SelectItem("N", "Negativo"));

        }
        return resultadosPruebasRapidasEmbarazo;
    }
}
