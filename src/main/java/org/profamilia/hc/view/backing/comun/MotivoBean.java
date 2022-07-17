//=======================================================================
// ARCHIVO MotivoBean.java
// FECHA CREACI�N: 05/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a motivo de consulta
//=======================================================================
package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chasesoriaive;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chrevissiste;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  CLASE MotivoBean
//=======================================================================

public class MotivoBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    /**Lista de opciones si recibio asesoria */
    private List lstRecibio;

    /**Lista de opciones si se ofrecio asesoria */
    private List lstOfrecio;

    /** Almacena la finalidad seleccionada*/
    private String finalidadSelect;

    /** Almacena la lista de causas para el codigo del motivo de consulta */
    private List lstCausa;

    /** Almacena si es consulta de ilve */
    private boolean esIlve = false;

    /** Almacena la lista de finalidades  */
    private List lstFinalidades;
    

        /** Almacena la lista de finalidades  */
        private List lstFinalidadesProcedimiento;

    /** Almacen el codigo del motivo de consulta seleccionado*/
    private String causaSelect;

    /** Almacena el motivo de consulta el cual se va a persistir*/
    private Chmotivocon motivo;

    private boolean modoconsulta;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private Long numeroConsulta;

    private String tipoServicio;

    /** Variable que almacena true si se desea ver se ofrecio asesoria y recibio asesoria */
    private boolean ocultarasesoria;

    private boolean esValoracionPreanestesica;

    private boolean motivoOpcional;

    private boolean enfermedadOpcional;

    private boolean ocultarRevision;

    private List lstRenderedCausa;

    private Integer tipoHistoria;

    private List lstFactorSangre;

    private List lstGrupoSangre;

    private boolean renderEcografia;

    private boolean renderPreguntas;

    private boolean renderConocioProfamilia;

    private List lstTipoContacto;

    private List lstContacto;

    private List lstRefiere;

    private Chrevissiste revision;

    private Cpservicio servicio;

    private boolean renderCabeza;

    private boolean renderOjos;

    private boolean renderOidos;

    private boolean renderNariz;

    private boolean renderBoca;

    private boolean renderGarganta;

    private boolean renderCuello;

    private boolean renderCardiorespiratorio;

    private boolean renderMama;

    private boolean renderGastrointestinal;

    private boolean renderGenitourinario;
    
    private boolean renderTuberculosis; 
    
    private boolean renderLepra;

    //    private boolean renderVenereos;

    //    private boolean renderEndocrino;

    private boolean renderLocomotor;

    private boolean renderNeuromuscular;

    private boolean renderNeuropsiqui;

    private boolean renderPiel;

    private boolean renderManiobras;

    private boolean renderInterrupcion;

    private boolean mostrarotramaniobra;

    private UIInput mnuCabeza;

    private UIInput mnuOjos;

    private UIInput mnuOidos;

    private UIInput mnuNariz;

    private UIInput mnuBoca;

    private UIInput mnuGarganta;

    private UIInput mnuCuello;

    private UIInput mnuCardiorrespiratorio;

    private UIInput mnuMamas;

    private UIInput mnuGastrointestinal;

    private UIInput mnuGenitourinario;

    //    private UIInput mnuVenereos;

    //    private UIInput mnuEndocrino;

    private UIInput mnuLocomotor;

    private UIInput mnuNeuromuscular;

    private UIInput mnuNeuropsiqui;

    private UIInput mnuPiel;
    
    private UIInput mnuTuberculosis; 
    
    private UIInput mnuLepra;

    private List<String> lstManiobras;

    private List<String> lstInterrupcion;

    private List lstMani;

    private List lstInte;

    private List<SelectItem> lstTipoConsultaPsicologia; 
    
    private Chasesoriaive asesoria;
    
    private List<SelectItem> lstOpciones;
    
    private boolean renderTeleorientacion;
    
    // campos agregados
    
    private boolean renderDismenorrea ;
    
    private boolean renderDispareunia ;
    
    private UIInput mnuDismenorrea;
    
    private UIInput mnuDispareunia;
    
    private Boolean renderEnferOpc;
    
    private List<SelectItem> lstPatologias;
       
    private List<SelectItem>lstResPatols;
    
    private List<SelectItem>lstBiopsia;
    
    private boolean renderTipoPatologia;
    
    private boolean renderPatologiaCual;
    
    private boolean renderDescripcionResultados;
    
    private boolean rendeGineco;
    
    private boolean renderResultado;
    
    private List<SelectItem>lstClasificacionHistol;
    
    private List<SelectItem>lstGradoTumor;
    
    private boolean renderPHQ9;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public MotivoBean() {
    }

    public void init() {
        modoconsulta = false;
        ocultarasesoria = false;
        esValoracionPreanestesica = false;
        motivoOpcional = false;
        enfermedadOpcional = true;
        ocultarRevision = false;
        renderPreguntas = false;
        nextAction = "";
        lstContacto = new ArrayList();
        renderPHQ9 = false;
        inicializarMotivo();
        renderManiobras = false;
        mostrarotramaniobra = false;
        lstManiobras = new ArrayList();
        lstInterrupcion = new ArrayList();
        lstTipoConsultaPsicologia= new ArrayList();
        asesoria = new Chasesoriaive();
        renderTeleorientacion=false;
        renderEnferOpc=false;
        rendeGineco=false;
        renderResultado=false;
        
    }


    // ACTIONS

    public String inicializarMotivo() {
        renderTeleorientacion=false;
        renderPHQ9 = false;
        try {
            if (numeroConsulta != null)
                motivo = 
                        getServiceLocator().getClinicoService().getMotivoConsulta(numeroConsulta);
            revision = 
                    getServiceLocator().getClinicoService().getRevisionSistemas(numeroConsulta);

            servicio = 
                    getServiceLocator().getClinicoService().getServicioXNumeroConsulta(numeroConsulta);
                    
            asesoria = 
                    getServiceLocator().getClinicoService().getAsesoriaIve(numeroConsulta);

        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        if (servicio != null) {
            if (servicio.getCsvntiphis().equals(26)) {
                renderPreguntas = true;
            }
            
                if (servicio.getCsvcteleorie()!=null && servicio.getCsvcteleorie().equals("S")) {
                    renderTeleorientacion = true;
                }else{
                    renderTeleorientacion = false;
                }
            
        }
    
        if (motivo == null) {
            motivo = new Chmotivocon();
        } else {
            if (motivo.getHmcncausaexte() != null)
                causaSelect = motivo.getHmcncausaexte().toString();
            if (motivo.getHmcnfinalidad() != null)
                finalidadSelect = motivo.getHmcnfinalidad().toString();


            if (motivo.getHmcctipoconta() != null) {
                lstContacto = new ArrayList();
                if (motivo.getHmcctipoconta().equals("I")) {
                    lstContacto.add(new SelectItem("", "Seleccione ..."));
                    //                    lstContacto.add(new SelectItem("ASES", "Asesor�a"));
                    lstContacto.add(new SelectItem("CDPS", 
                                                   "Consulta de Psicolog�a"));
                    lstContacto.add(new SelectItem("COME", "Consulta M�dica"));
                    lstContacto.add(new SelectItem("SPEM", 
                                                   "Servicio de prueba de embarazo"));

                }

                if (motivo.getHmcctipoconta().equals("E")) {
                    lstContacto.add(new SelectItem("", "Seleccione..."));
                    //                    lstContacto.add(new SelectItem("ASEG", "Aseguradora"));
                    //                    lstContacto.add(new SelectItem("CONO", "Conocido"));
                    //                    lstContacto.add(new SelectItem("IDSA", 
                    //                                                   "Instituci�n de Salud"));
                    lstContacto.add(new SelectItem("PRSA", 
                                                   "Direccionamiento de un Profesional de Salud"));
                    lstContacto.add(new SelectItem("DEPS", 
                                                   "Direccionamiento de una EPS"));
                    lstContacto.add(new SelectItem("DIPS", 
                                                   "Direccionamiento de una IPS"));
                                                   
                    lstContacto.add(new SelectItem("PAWE", 
                                                   "Pagina Web"));
                                                   
                    lstContacto.add(new SelectItem("CEEX", 
                                                   "Centro de experiencia"));
                    lstContacto.add(new SelectItem("REPE", 
                                                   "Por recomendaci�n de otra persona"));
                }
            }

            if (motivo.getHmccmaniofarma() != null) {
                if (motivo.getHmccmaniofarma().equals("S")) {
                    lstManiobras.add("IF");
                    renderManiobras = true;
                }
            }
            if (motivo.getHmccmanioinstru() != null) {
                if (motivo.getHmccmanioinstru().equals("S")) {
                    lstManiobras.add("II");
                    renderManiobras = true;
                }
            }
            if (motivo.getHmccmaniootro() != null) {
                if (motivo.getHmccmaniootro().equals("S")) {
                    lstManiobras.add("OT");
                    renderManiobras = true;
                    mostrarotramaniobra = true;
                }
            }

            if (motivo.getHmccinteroprof() != null) {
                if (motivo.getHmccinteroprof().equals("S")) {
                    lstInterrupcion.add("OP");
                    renderInterrupcion = true;
                }
            }
            if (motivo.getHmccinterasegu() != null) {
                if (motivo.getHmccinterasegu().equals("S")) {
                    lstInterrupcion.add("AT");
                    renderInterrupcion = true;
                }
            }
            if (motivo.getHmccinteractua() != null && 
                motivo.getHmccinteractua().equals("S")) {
                renderInterrupcion = true;
            }


        }

        if (revision == null) {
            revision = new Chrevissiste();
        } else {
            if (revision.getHrserefiecabez() != null && 
                revision.getHrserefiecabez().equals("R")) {
                renderCabeza = true;
            }

            if (revision.getHrserefieojos() != null && 
                revision.getHrserefieojos().equals("R")) {
                renderOjos = true;
            }

            if (revision.getHrserefieoidos() != null && 
                revision.getHrserefieoidos().equals("R")) {
                renderOidos = true;
            }

            if (revision.getHrserefienariz() != null && 
                revision.getHrserefienariz().equals("R")) {
                renderNariz = true;
            }

            if (revision.getHrserefieboca() != null && 
                revision.getHrserefieboca().equals("R")) {
                renderBoca = true;
            }

            if (revision.getHrserefiegarga() != null && 
                revision.getHrserefiegarga().equals("R")) {
                renderGarganta = true;
            }

            if (revision.getHrserefiecuell() != null && 
                revision.getHrserefiecuell().equals("R")) {
                renderCuello = true;
            }

            if (revision.getHrserefiecardi() != null && 
                revision.getHrserefiecardi().equals("R")) {
                renderCardiorespiratorio = true;
            }

            if (revision.getHrserefiemamas() != null && 
                revision.getHrserefiemamas().equals("R")) {
                renderMama = true;
            }

            if (revision.getHrserefiegastr() != null && 
                revision.getHrserefiegastr().equals("R")) {
                renderGastrointestinal = true;
            }

            if (revision.getHrserefiegenit() != null && 
                revision.getHrserefiegenit().equals("R")) {
                renderGenitourinario = true;
            }
            
            if (revision.getHrserefietuber() != null && 
                revision.getHrserefietuber().equals("R")) {
                renderTuberculosis = true;
            }
            
            if (revision.getHrserefielepra() != null && 
                revision.getHrserefielepra().equals("R")) {
                renderLepra = true;
            }
            

            //           if (revision.getHrserefievener()!= null && revision.getHrserefievener().equals("R")) {
            //                renderVenereos = true; 
            //            }

            //            if (revision.getHrserefieendoc()!= null && revision.getHrserefieendoc().equals("R")) {
            //                renderEndocrino = true; 
            //            }

            if (revision.getHrserefielocom() != null && 
                revision.getHrserefielocom().equals("R")) {
                renderLocomotor = true;
            }

            if (revision.getHrserefieneups() != null && 
                revision.getHrserefieneups().equals("R")) {
                renderNeuropsiqui = true;
            }

            if (revision.getHrserefieneumu() != null && 
                revision.getHrserefieneumu().equals("R")) {
                renderNeuromuscular = true;
            }

            if (revision.getHrserefiepiel() != null && 
                revision.getHrserefiepiel().equals("R")) {
                renderPiel = true;
            }
            if (revision.getHrserefiedismeno() != null && 
                revision.getHrserefiedismeno().equals("R")) {
                renderDismenorrea = true;
            }
            if (revision.getHrserefiedispar() != null && 
                revision.getHrserefiedispar().equals("R")) {
                renderDispareunia = true;
            }
        }
        if(asesoria==null){
        asesoria= new Chasesoriaive();
        }
    if(servicio !=null){
        if(servicio.getCsvntiphis() == 5 || servicio.getCsvntiphis() == 24){
            asesoria = null;
        }
    }
        if (null != servicio) {
            if (null!= servicio && servicio.getCsvntiphis() == 5) {
                enfermedadOpcional = false;
                renderEnferOpc = true;
            }
            else if(null!= servicio && servicio.getCsvntiphis() != 5){
                enfermedadOpcional = true;
                renderEnferOpc = false;
            }
        }
        if(lstPatologias !=null && !lstPatologias.isEmpty()){
            changeTraePatologia();
            changePatologia();
        }
       
        
        if(tipoHistoria==HISTORIA_GINECOLOGIA || tipoHistoria==HISTORIA_CONTROL_GINECOLOGIA){
            rendeGineco= true;
            changeResultados();
        }
        
        if(tipoHistoria != null && (tipoHistoria==HISTORIA_INTERRUPCION || tipoHistoria==HISTORIA_PSICOLOGICA) ){
            renderPHQ9 = true;
        }
        return null;
    }

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chmotivocon motivoAux = null;
        if (numeroConsulta != null)
            try {
                motivoAux = 
                        getServiceLocator().getClinicoService().getMotivoConsulta(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        if (motivoAux != null)
            esValido = true;
        else
            esValido = false;
        return esValido;
    }


    //ACCESSORS

    /**
     * @param causaSelect
     */
    public void setCausaSelect(String causaSelect) {
        this.causaSelect = causaSelect;
    }

    /**
     * @return
     */
    public String getCausaSelect() {
        return causaSelect;
    }

    /**
     * @param lstRecibio
     */
    public void setLstRecibio(List lstRecibio) {
        this.lstRecibio = lstRecibio;
    }

    /**
     * @return
     */
    public List getLstRecibio() {
        if (lstRecibio == null || lstRecibio.isEmpty()) {
            lstRecibio = new ArrayList();
            lstRecibio.add(new SelectItem("S", "SI"));
            lstRecibio.add(new SelectItem("N", "NO"));
        }
        return lstRecibio;
    }

    /**
     * @param lstOfrecio
     */
    public void setLstOfrecio(List lstOfrecio) {
        this.lstOfrecio = lstOfrecio;
    }

    /**
     * @return
     */
    public List getLstOfrecio() {
        if (lstOfrecio == null || lstOfrecio.isEmpty()) {
            lstOfrecio = new ArrayList();
            lstOfrecio.add(new SelectItem("S", "SI"));
            lstOfrecio.add(new SelectItem("N", "NO"));
        }
        return lstOfrecio;
    }

    /**
     * @param lstCausa
     */
    public void setLstCausa(List lstCausa) {
        this.lstCausa = lstCausa;
    }

    /**
     * @return
     */
    public List getLstCausa() {
        if (lstCausa == null || lstCausa.isEmpty()) {
            lstCausa = new ArrayList();

            if (esIlve) {
                lstCausa.add(new SelectItem("", "Seleccione una opcion ..."));
                lstCausa.add(new SelectItem(CAUSA_ENFERMEDAD_GENERAL, 
                                            "ENFERMEDAD GENERAL"));
                lstCausa.add(new SelectItem(CAUSA_SOSPECHA_ABUSO_SEXUAL, 
                                            "SOSPECHA ABUSO SEXUAL"));
                lstCausa.add(new SelectItem(CAUSA_SOSPECHA_VIOLENCIA_SEXUAL, 
                                            "SOSPECHA VIOLENCIA SEXUAL"));
            } else {
                ArrayList lstCausaAux = null;
                try {
                    lstCausaAux = 
                            (ArrayList)getServiceLocator().getClinicoService().getCausaExternaVG(tipoHistoria);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (!lstCausaAux.isEmpty()) {
                    lstCausa.add(new SelectItem("", 
                                                "Seleccione una opcion ..."));
                    Iterator it = lstCausaAux.iterator();
                    for (int i = 0; it.hasNext(); i++) {
                        it.next();
                        lstCausa.add(new SelectItem(((Crcausaext)lstCausaAux.get(i)).getCcancodigo().toString(), 
                                                    ((Crcausaext)lstCausaAux.get(i)).getCcacdescri()));
                    }
                }
            }
        }
        return lstCausa;
    }

    /**
     * @param motivo
     */
    public void setMotivo(Chmotivocon motivo) {
        this.motivo = motivo;
    }

    /**
     * @return
     */
    public Chmotivocon getMotivo() {
        return motivo;
    }

    /**
     * @param lstFinalidades
     */
    public void setLstFinalidades(List lstFinalidades) {
        this.lstFinalidades = lstFinalidades;
    }

    /**
     * @return
     */
    public List getLstFinalidades() {
        if (lstFinalidades == null || lstFinalidades.isEmpty()) {
            lstFinalidades = new ArrayList();
            ArrayList lstFinalidadesAux = null;
            try {
                lstFinalidadesAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getFinalidadesConsultaVG(tipoServicio);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstFinalidadesAux.isEmpty()) {
                lstFinalidades.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                Iterator it = lstFinalidadesAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstFinalidades.add(new SelectItem(((Crfinalcon)lstFinalidadesAux.get(i)).getId().getCfcncodigo().toString(), 
                                                      ((Crfinalcon)lstFinalidadesAux.get(i)).getCfccdescri()));
                }

            }
        }
        return lstFinalidades;
    }

    /**
     * @param finalidadSelect
     */
    public void setFinalidadSelect(String finalidadSelect) {
        this.finalidadSelect = finalidadSelect;
    }

    /**
     * @return
     */
    public String getFinalidadSelect() {
        return finalidadSelect;
    }

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
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
     * @param ocultarasesoria
     */
    public void setOcultarasesoria(boolean ocultarasesoria) {
        this.ocultarasesoria = ocultarasesoria;
    }

    /**
     * @return
     */
    public boolean isOcultarasesoria() {
        return ocultarasesoria;
    }

    /**
     * @param esValoracionPreanestesica
     */
    public void setEsValoracionPreanestesica(boolean esValoracionPreanestesica) {
        this.esValoracionPreanestesica = esValoracionPreanestesica;
    }

    /**
     * @return
     */
    public boolean isEsValoracionPreanestesica() {
        return esValoracionPreanestesica;
    }

    /**
     * @param motivoOpcional
     */
    public void setMotivoOpcional(boolean motivoOpcional) {
        this.motivoOpcional = motivoOpcional;
    }

    /**
     * @return
     */
    public boolean isMotivoOpcional() {
        return motivoOpcional;
    }

    /**
     * @param enfermedadOpcional
     */
    public void setEnfermedadOpcional(boolean enfermedadOpcional) {
        this.enfermedadOpcional = enfermedadOpcional;
    }

    /**
     * @return
     */
    public boolean isEnfermedadOpcional() {
        return enfermedadOpcional;
    }

    /**
     * @param ocultarRevision
     */
    public void setOcultarRevision(boolean ocultarRevision) {
        this.ocultarRevision = ocultarRevision;
    }

    /**
     * @return
     */
    public boolean isOcultarRevision() {
        return ocultarRevision;
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
     * @param lstRenderedCausa
     */
    public void setLstRenderedCausa(List lstRenderedCausa) {
        this.lstRenderedCausa = lstRenderedCausa;
    }

    /**
     * @return
     */
    public List getLstRenderedCausa() {
        return lstRenderedCausa;
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
     * @param lstFactorSangre
     */
    public void setLstFactorSangre(List lstFactorSangre) {
        this.lstFactorSangre = lstFactorSangre;
    }

    /**
     * @return
     */
    public List getLstFactorSangre() {
        if (lstFactorSangre == null) {
            lstFactorSangre = new ArrayList();
            lstFactorSangre.add(new SelectItem("P", "POS (+) "));
            lstFactorSangre.add(new SelectItem("N", "NEG (-) "));
        }
        return lstFactorSangre;
    }

    /**
     * @param lstGrupoSangre
     */
    public void setLstGrupoSangre(List lstGrupoSangre) {
        this.lstGrupoSangre = lstGrupoSangre;
    }

    /**
     * @return
     */
    public List getLstGrupoSangre() {
        if (lstGrupoSangre == null) {
            lstGrupoSangre = new ArrayList();
            lstGrupoSangre.add(new SelectItem("A", "A"));
            lstGrupoSangre.add(new SelectItem("AB", "AB"));
            lstGrupoSangre.add(new SelectItem("B", "B"));
            lstGrupoSangre.add(new SelectItem("O", "O"));
        }
        return lstGrupoSangre;
    }

    /**
     * @param renderEcografia
     */
    public void setRenderEcografia(boolean renderEcografia) {
        this.renderEcografia = renderEcografia;
    }

    /**
     * @return
     */
    public boolean isRenderEcografia() {
        return renderEcografia;
    }

    /**
     * @param revision
     */
    public void setRevision(Chrevissiste revision) {
        this.revision = revision;
    }

    /**
     * @return
     */
    public Chrevissiste getRevision() {
        return revision;
    }


    public void setRenderConocioProfamilia(boolean renderConocioProfamilia) {
        this.renderConocioProfamilia = renderConocioProfamilia;
    }

    public boolean isRenderConocioProfamilia() {
        return renderConocioProfamilia;
    }


    /**
     * @param lstRefiere
     */
    public void setLstRefiere(List lstRefiere) {
        this.lstRefiere = lstRefiere;
    }

    /**
     * @return
     */
    public List getLstRefiere() {
        if (lstRefiere == null || lstRefiere.isEmpty()) {
            lstRefiere = new ArrayList();
            lstRefiere.add(new SelectItem("R", "Refiere"));
            lstRefiere.add(new SelectItem("N", "No Refiere"));
        }
        return lstRefiere;
    }


    /**
     * @param lstTipoContacto
     */
    public void setLstTipoContacto(List lstTipoContacto) {
        this.lstTipoContacto = lstTipoContacto;
    }

    /**
     * @return
     */
    public List getLstTipoContacto() {
        if (lstTipoContacto == null || lstTipoContacto.isEmpty()) {
            lstTipoContacto = new ArrayList();
            lstTipoContacto.add(new SelectItem("I", "Interno"));
            lstTipoContacto.add(new SelectItem("E", "Externo"));
        }
        return lstTipoContacto;
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
        return lstContacto;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHmcctipoconta(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctipoconta((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiecabez(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiecabez((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefieojos(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefieojos((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefieoidos(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefieoidos((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefienariz(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefienariz((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefieboca(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefieboca((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiegarga(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiegarga((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiecuell(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiecuell((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiecardi(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiecardi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiemamas(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiemamas((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiegastr(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiegastr((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefiegenit(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiegenit((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHmccmanioprev(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccmanioprev((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHmccinteractua(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccinteractua((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHrserefietuber(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefietuber((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefielepra(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefielepra((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHmccteleorien(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccteleorien((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    /**
     * @param valueChangeEvent
     */
    //    public void setHrserefievener(ValueChangeEvent valueChangeEvent) {
    //        revision.setHrserefievener((String)valueChangeEvent.getNewValue());
    //        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    //        }

    /**
     * @param valueChangeEvent
     */
    //    public void setHrserefieendoc(ValueChangeEvent valueChangeEvent) {
    //        revision.setHrserefieendoc((String)valueChangeEvent.getNewValue());
    //        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    //        }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefielocom(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefielocom((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefieneumu(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefieneumu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHrserefieneups(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefieneups((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHrserefiedismeno(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiedismeno((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHrserefiedispar(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiedispar((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHrserefiepiel(ValueChangeEvent valueChangeEvent) {
        revision.setHrserefiepiel((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeContacto() {
        lstContacto = new ArrayList();
        if (motivo != null && motivo.getHmcctipoconta() != null) {
            if (motivo.getHmcctipoconta().equals("I")) {
                lstContacto.add(new SelectItem("", "Seleccione ..."));
                //                lstContacto.add(new SelectItem("ASES", "Asesor�a"));
                lstContacto.add(new SelectItem("CDPS", 
                                               "Consulta de Psicolog�a"));
                lstContacto.add(new SelectItem("COME", "Consulta M�dica"));
                lstContacto.add(new SelectItem("SPEM", 
                                               "Servicio de prueba de embarazo"));

            }

            if (motivo.getHmcctipoconta().equals("E")) {
                lstContacto.add(new SelectItem("", "Seleccione..."));
                //                    lstContacto.add(new SelectItem("ASEG", "Aseguradora"));
                //                    lstContacto.add(new SelectItem("CONO", "Conocido"));
                //                    lstContacto.add(new SelectItem("IDSA",
                //                                                   "Instituci�n de Salud"));
                lstContacto.add(new SelectItem("PRSA", 
                                               "Direccionamiento de un Profesional de Salud"));
                lstContacto.add(new SelectItem("DEPS", 
                                               "Direccionamiento de una EPS"));
                lstContacto.add(new SelectItem("DIPS", 
                                               "Direccionamiento de una IPS"));
                                               
                lstContacto.add(new SelectItem("PAWE", 
                                               "Pagina Web"));
                                               
                lstContacto.add(new SelectItem("CEEX", 
                                               "Centro de experiencia"));
                lstContacto.add(new SelectItem("REPE", 
                                               "Por recomendaci�n de otra persona"));

            }
        }
    }

    public void changeTodosNo() {
        renderCabeza = false;
        renderOjos = false;
        renderOidos = false;
        renderNariz = false;
        renderBoca = false;
        renderGarganta = false;
        renderCuello = false;
        renderCardiorespiratorio = false;
        renderMama = false;
        renderGastrointestinal = false;
        renderGenitourinario = false;
        renderLepra = false;
        renderTuberculosis = false;
        //        renderVenereos = false;
        //        renderEndocrino = false;
        renderLocomotor = false;
        renderNeuromuscular = false;
        renderNeuropsiqui = false;
        renderPiel = false;
        inicializarPreguntas("N");
    }

    public void changeTodosSi() {
        renderCabeza = true;
        renderOjos = true;
        renderOidos = true;
        renderNariz = true;
        renderBoca = true;
        renderGarganta = true;
        renderCuello = true;
        renderCardiorespiratorio = true;
        renderMama = true;
        renderGastrointestinal = true;
        renderGenitourinario = true;
        renderLepra = true;
        renderTuberculosis = true;
        //            renderVenereos = true;
        //            renderEndocrino = true;
        renderLocomotor = true;
        renderNeuromuscular = true;
        renderNeuropsiqui = true;
        renderPiel = true;
        inicializarPreguntas("R");
    }


    public void changeNinguno() {


        renderCabeza = false;
        renderOjos = false;
        renderOidos = false;
        renderNariz = false;
        renderBoca = false;
        renderGarganta = false;
        renderCuello = false;
        renderCardiorespiratorio = false;
        renderMama = false;
        renderGastrointestinal = false;
        renderGenitourinario = false;
        renderTuberculosis = false;
        renderLepra = false;
        //        renderVenereos = false;
        //        renderEndocrino = false;
        renderLocomotor = false;
        renderNeuromuscular = false;
        renderNeuropsiqui = false;
        renderPiel = false;

        inicializarPreguntas(null);


    }


    public void changeCabeza() {
        renderCabeza = false;
        if (revision != null && revision.getHrserefiecabez() != null && 
            revision.getHrserefiecabez().equals("R")) {
            renderCabeza = true;
        }
    }

    public void changeOjos() {
        renderOjos = false;
        if (revision != null && revision.getHrserefieojos() != null && 
            revision.getHrserefieojos().equals("R")) {
            renderOjos = true;
        }
    }

    public void changeOidos() {
        renderOidos = false;

        if (revision != null && revision.getHrserefieoidos() != null && 
            revision.getHrserefieoidos().equals("R")) {
            renderOidos = true;
        }
    }

    public void changeNariz() {
        renderNariz = false;
        if (revision != null && revision.getHrserefienariz() != null && 
            revision.getHrserefienariz().equals("R")) {
            renderNariz = true;
        }
    }

    public void changeBoca() {
        renderBoca = false;
        if (revision != null && revision.getHrserefieboca() != null && 
            revision.getHrserefieboca().equals("R")) {
            renderBoca = true;
        }
    }

    public void changeGarganta() {
        renderGarganta = false;
        if (revision != null && revision.getHrserefiegarga() != null && 
            revision.getHrserefiegarga().equals("R")) {
            renderGarganta = true;
        }
    }

    public void changeCuello() {
        renderCuello = false;

        if (revision != null && revision.getHrserefiecuell() != null && 
            revision.getHrserefiecuell().equals("R")) {
            renderCuello = true;
        }
    }

    public void changeCardiorrespiratorio() {
        renderCardiorespiratorio = false;
        if (revision != null && revision.getHrserefiecardi() != null && 
            revision.getHrserefiecardi().equals("R")) {
            renderCardiorespiratorio = true;
        }
    }

    public void changeMama() {
        renderMama = false;
        if (revision != null && revision.getHrserefiemamas() != null && 
            revision.getHrserefiemamas().equals("R")) {
            renderMama = true;
        }
    }

    public void changeGastrointestinal() {
        renderGastrointestinal = false;
        if (revision != null && revision.getHrserefiegastr() != null && 
            revision.getHrserefiegastr().equals("R")) {
            renderGastrointestinal = true;
        }
    }

    public void changeGenitourinario() {
        renderGenitourinario = false;
        if (revision != null && revision.getHrserefiegenit() != null && 
            revision.getHrserefiegenit().equals("R")) {
            renderGenitourinario = true;
        }

    }
    
    public void changeTuberculosis() {
        renderTuberculosis = false;
        if (revision != null && revision.getHrserefietuber() != null && 
            revision.getHrserefietuber().equals("R")) {
            renderTuberculosis = true;
        }

    }
    
    public void changeLepra() {
        renderLepra = false;
        if (revision != null && revision.getHrserefielepra() != null && 
            revision.getHrserefielepra().equals("R")) {
            renderLepra = true;
        }

    }


    //    public void changeEndocrino() {
    //        renderEndocrino = false;
    //        if(revision != null && revision.getHrserefieendoc() != null && 
    //        revision.getHrserefieendoc().equals("R")){
    //            renderEndocrino = true;  
    //        }
    //    }

    public void changeLocomotor() {
        renderLocomotor = false;
        if (revision != null && revision.getHrserefielocom() != null && 
            revision.getHrserefielocom().equals("R")) {
            renderLocomotor = true;
        }
    }

    public void changeNeuromuscular() {
        renderNeuromuscular = false;
        if (revision != null && revision.getHrserefieneumu() != null && 
            revision.getHrserefieneumu().equals("R")) {
            renderNeuromuscular = true;
        }
    }

    public void changeNeuropsiqui() {
        renderNeuropsiqui = false;
        if (revision != null && revision.getHrserefieneups() != null && 
            revision.getHrserefieneups().equals("R")) {
            renderNeuropsiqui = true;
        }
    }

    public void changePiel() {
        renderPiel = false;
        if (revision != null && revision.getHrserefiepiel() != null && 
            revision.getHrserefiepiel().equals("R")) {
            renderPiel = true;
        }
    }
    
    public void changeDismenorrea() {
        renderDismenorrea = false;
        if (revision != null && revision.getHrserefiedismeno() != null && 
            revision.getHrserefiedismeno().equals("R")) {
            renderDismenorrea = true;
        }
    }
    
    public void changeDispareunia() {
        renderDispareunia = false;
        if (revision != null && revision.getHrserefiedispar() != null && 
            revision.getHrserefiedispar().equals("R")) {
            renderDispareunia = true;
        }
    }

    public void changeManiobras() {
        renderManiobras = false;
        if (motivo.getHmccmanioprev() != null && 
            motivo.getHmccmanioprev().equals("S")) {
            renderManiobras = true;
        } else {
            lstManiobras = new ArrayList();
            motivo.setHmccmaniootrodesc(null);
            motivo.setHmccmanioobser(null);
            mostrarotramaniobra = false;
        }
    }

    public void changeInterrupcion() {
        renderInterrupcion = false;
        if (motivo.getHmccinteractua() != null && 
            motivo.getHmccinteractua().equals("S")) {
            renderInterrupcion = true;
        }
    }

    public void changeManiobrasOtras() {
        mostrarotramaniobra = false;
        if (!lstManiobras.isEmpty()) {
            for (String aux: lstManiobras) {
                if (aux.equals("OT")) {
                    mostrarotramaniobra = true;
                }
            }
        }
    }


    //    public void changeVenereos() {
    //        renderVenereos = false; 
    //        if(revision != null && revision.getHrserefievener()!= null && 
    //        revision.getHrserefievener().equals("R")){
    //            renderVenereos = true;  
    //        }
    //    }


    /**
     * @param renderCabeza
     */
    public void setRenderCabeza(boolean renderCabeza) {
        this.renderCabeza = renderCabeza;
    }

    /**
     * @return
     */
    public boolean isRenderCabeza() {
        return renderCabeza;
    }

    /**
     * @param renderOjos
     */
    public void setRenderOjos(boolean renderOjos) {
        this.renderOjos = renderOjos;
    }

    /**
     * @return
     */
    public boolean isRenderOjos() {
        return renderOjos;
    }

    /**
     * @param renderOidos
     */
    public void setRenderOidos(boolean renderOidos) {
        this.renderOidos = renderOidos;
    }

    /**
     * @return
     */
    public boolean isRenderOidos() {
        return renderOidos;
    }

    /**
     * @param renderNariz
     */
    public void setRenderNariz(boolean renderNariz) {
        this.renderNariz = renderNariz;
    }

    /**
     * @return
     */
    public boolean isRenderNariz() {
        return renderNariz;
    }

    /**
     * @param renderBoca
     */
    public void setRenderBoca(boolean renderBoca) {
        this.renderBoca = renderBoca;
    }

    /**
     * @return
     */
    public boolean isRenderBoca() {
        return renderBoca;
    }

    /**
     * @param renderGarganta
     */
    public void setRenderGarganta(boolean renderGarganta) {
        this.renderGarganta = renderGarganta;
    }

    /**
     * @return
     */
    public boolean isRenderGarganta() {
        return renderGarganta;
    }

    /**
     * @param renderCuello
     */
    public void setRenderCuello(boolean renderCuello) {
        this.renderCuello = renderCuello;
    }

    /**
     * @return
     */
    public boolean isRenderCuello() {
        return renderCuello;
    }

    /**
     * @param renderCardiorespiratorio
     */
    public void setRenderCardiorespiratorio(boolean renderCardiorespiratorio) {
        this.renderCardiorespiratorio = renderCardiorespiratorio;
    }

    /**
     * @return
     */
    public boolean isRenderCardiorespiratorio() {
        return renderCardiorespiratorio;
    }

    /**
     * @param renderMama
     */
    public void setRenderMama(boolean renderMama) {
        this.renderMama = renderMama;
    }

    /**
     * @return
     */
    public boolean isRenderMama() {
        return renderMama;
    }

    /**
     * @param renderGastrointestinal
     */
    public void setRenderGastrointestinal(boolean renderGastrointestinal) {
        this.renderGastrointestinal = renderGastrointestinal;
    }

    /**
     * @return
     */
    public boolean isRenderGastrointestinal() {
        return renderGastrointestinal;
    }

    /**
     * @param renderGenitourinario
     */
    public void setRenderGenitourinario(boolean renderGenitourinario) {
        this.renderGenitourinario = renderGenitourinario;
    }

    /**
     * @return
     */
    public boolean isRenderGenitourinario() {
        return renderGenitourinario;
    }

    /**
     * @param renderVenereos
     */
    //    public void setRenderVenereos(boolean renderVenereos) {
    //        this.renderVenereos = renderVenereos;
    //    }

    /**
     * @return
     */
    //    public boolean isRenderVenereos() {
    //        return renderVenereos;
    //    }

    /**
     * @param renderEndocrino
     */
    //    public void setRenderEndocrino(boolean renderEndocrino) {
    //        this.renderEndocrino = renderEndocrino;
    //    }

    /**
     * @return
     */
    //    public boolean isRenderEndocrino() {
    //        return renderEndocrino;
    //    }

    /**
     * @param renderLocomotor
     */
    public void setRenderLocomotor(boolean renderLocomotor) {
        this.renderLocomotor = renderLocomotor;
    }

    /**
     * @return
     */
    public boolean isRenderLocomotor() {
        return renderLocomotor;
    }

    /**
     * @param renderNeuromuscular
     */
    public void setRenderNeuromuscular(boolean renderNeuromuscular) {
        this.renderNeuromuscular = renderNeuromuscular;
    }

    /**
     * @return
     */
    public boolean isRenderNeuromuscular() {
        return renderNeuromuscular;
    }

    /**
     * @param renderNeuropsiqui
     */
    public void setRenderNeuropsiqui(boolean renderNeuropsiqui) {
        this.renderNeuropsiqui = renderNeuropsiqui;
    }

    /**
     * @return
     */
    public boolean isRenderNeuropsiqui() {
        return renderNeuropsiqui;
    }

    /**
     * @param renderPiel
     */
    public void setRenderPiel(boolean renderPiel) {
        this.renderPiel = renderPiel;
    }

    /**
     * @return
     */
    public boolean isRenderPiel() {
        return renderPiel;
    }

    /**
     * @param mnuCabeza
     */
    public void setMnuCabeza(UIInput mnuCabeza) {
        this.mnuCabeza = mnuCabeza;
    }

    /**
     * @return
     */
    public UIInput getMnuCabeza() {
        return mnuCabeza;
    }

    /**
     * @param mnuOjos
     */
    public void setMnuOjos(UIInput mnuOjos) {
        this.mnuOjos = mnuOjos;
    }

    /**
     * @return
     */
    public UIInput getMnuOjos() {
        return mnuOjos;
    }

    /**
     * @param mnuOidos
     */
    public void setMnuOidos(UIInput mnuOidos) {
        this.mnuOidos = mnuOidos;
    }

    /**
     * @return
     */
    public UIInput getMnuOidos() {
        return mnuOidos;
    }

    /**
     * @param mnuNariz
     */
    public void setMnuNariz(UIInput mnuNariz) {
        this.mnuNariz = mnuNariz;
    }

    /**
     * @return
     */
    public UIInput getMnuNariz() {
        return mnuNariz;
    }

    /**
     * @param mnuBoca
     */
    public void setMnuBoca(UIInput mnuBoca) {
        this.mnuBoca = mnuBoca;
    }

    /**
     * @return
     */
    public UIInput getMnuBoca() {
        return mnuBoca;
    }

    /**
     * @param mnuGarganta
     */
    public void setMnuGarganta(UIInput mnuGarganta) {
        this.mnuGarganta = mnuGarganta;
    }

    /**
     * @return
     */
    public UIInput getMnuGarganta() {
        return mnuGarganta;
    }

    /**
     * @param mnuCuello
     */
    public void setMnuCuello(UIInput mnuCuello) {
        this.mnuCuello = mnuCuello;
    }

    /**
     * @return
     */
    public UIInput getMnuCuello() {
        return mnuCuello;
    }

    /**
     * @param mnuCardiorrespiratorio
     */
    public void setMnuCardiorrespiratorio(UIInput mnuCardiorrespiratorio) {
        this.mnuCardiorrespiratorio = mnuCardiorrespiratorio;
    }

    /**
     * @return
     */
    public UIInput getMnuCardiorrespiratorio() {
        return mnuCardiorrespiratorio;
    }

    /**
     * @param mnuMamas
     */
    public void setMnuMamas(UIInput mnuMamas) {
        this.mnuMamas = mnuMamas;
    }

    /**
     * @return
     */
    public UIInput getMnuMamas() {
        return mnuMamas;
    }

    /**
     * @param mnuGastrointestinal
     */
    public void setMnuGastrointestinal(UIInput mnuGastrointestinal) {
        this.mnuGastrointestinal = mnuGastrointestinal;
    }

    /**
     * @return
     */
    public UIInput getMnuGastrointestinal() {
        return mnuGastrointestinal;
    }

    /**
     * @param mnuGenitourinario
     */
    public void setMnuGenitourinario(UIInput mnuGenitourinario) {
        this.mnuGenitourinario = mnuGenitourinario;
    }

    /**
     * @return
     */
    public UIInput getMnuGenitourinario() {
        return mnuGenitourinario;
    }

    /**
     * @param mnuVenereos
     */
    //    public void setMnuVenereos(UIInput mnuVenereos) {
    //        this.mnuVenereos = mnuVenereos;
    //    }

    /**
     * @return
     */
    //    public UIInput getMnuVenereos() {
    //        return mnuVenereos;
    //    }

    /**
     * @param mnuEndocrino
     */
    //    public void setMnuEndocrino(UIInput mnuEndocrino) {
    //        this.mnuEndocrino = mnuEndocrino;
    //    }

    /**
     * @return
     */
    //    public UIInput getMnuEndocrino() {
    //        return mnuEndocrino;
    //    }

    /**
     * @param mnuLocomotor
     */
    public void setMnuLocomotor(UIInput mnuLocomotor) {
        this.mnuLocomotor = mnuLocomotor;
    }

    /**
     * @return
     */
    public UIInput getMnuLocomotor() {
        return mnuLocomotor;
    }

    /**
     * @param mnuNeuromuscular
     */
    public void setMnuNeuromuscular(UIInput mnuNeuromuscular) {
        this.mnuNeuromuscular = mnuNeuromuscular;
    }

    /**
     * @return
     */
    public UIInput getMnuNeuromuscular() {
        return mnuNeuromuscular;
    }

    /**
     * @param mnuNeuropsiqui
     */
    public void setMnuNeuropsiqui(UIInput mnuNeuropsiqui) {
        this.mnuNeuropsiqui = mnuNeuropsiqui;
    }

    /**
     * @return
     */
    public UIInput getMnuNeuropsiqui() {
        return mnuNeuropsiqui;
    }

    /**
     * @param mnuPiel
     */
    public void setMnuPiel(UIInput mnuPiel) {
        this.mnuPiel = mnuPiel;
    }

    /**
     * @return
     */
    public UIInput getMnuPiel() {
        return mnuPiel;
    }

    /**
     * @param mnuTuberculosis
     */
    public void setMnuTuberculosis(UIInput mnuTuberculosis) {
        this.mnuTuberculosis = mnuTuberculosis;
    }

    /**
     * @return
     */
    public UIInput getMnuTuberculosis() {
        return mnuTuberculosis;
    }

    /**
     * @param mnuLepra
     */
    public void setMnuLepra(UIInput mnuLepra) {
        this.mnuLepra = mnuLepra;
    }

    /**
     * @return
     */
    public UIInput getMnuLepra() {
        return mnuLepra;
    }


    /**
     * @param opcion
     */
    public void inicializarPreguntas(String opcion) {

        if (revision != null) {

            revision.setHrserefiecabez(opcion);
            revision.setHrserefieojos(opcion);
            revision.setHrserefieoidos(opcion);
            revision.setHrserefienariz(opcion);
            revision.setHrserefieboca(opcion);
            revision.setHrserefiegarga(opcion);
            revision.setHrserefiecuell(opcion);
            revision.setHrserefiecardi(opcion);
            revision.setHrserefiemamas(opcion);
            revision.setHrserefiegastr(opcion);
            revision.setHrserefiegenit(opcion);
            //            revision.setHrserefievener(opcion);
            //            revision.setHrserefieendoc(opcion);
            revision.setHrserefielocom(opcion);
            revision.setHrserefieneumu(opcion);
            revision.setHrserefieneups(opcion);
            revision.setHrserefiepiel(opcion);

            mnuCabeza.setValue(opcion);
            mnuOjos.setValue(opcion);
            mnuOidos.setValue(opcion);
            mnuNariz.setValue(opcion);
            mnuBoca.setValue(opcion);
            mnuGarganta.setValue(opcion);
            mnuCuello.setValue(opcion);
            mnuCardiorrespiratorio.setValue(opcion);
            mnuMamas.setValue(opcion);
            mnuGastrointestinal.setValue(opcion);
            mnuGenitourinario.setValue(opcion);
            //            mnuVenereos.setValue(opcion);
            //            mnuEndocrino.setValue(opcion);
            mnuLocomotor.setValue(opcion);
            mnuNeuromuscular.setValue(opcion);
            mnuNeuropsiqui.setValue(opcion);
            mnuPiel.setValue(opcion);
            mnuLepra.setValue(opcion);
            mnuTuberculosis.setValue(opcion);


        }

    }
    
    
    public String  guardarMotivoConsulta(){
       
        return  guardarMotivo("C");
    }
    
    
    public String guardarMotivoProcedimiento(){
        return guardarMotivo("P");
    }

    public void setHmcctrapatol(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctrapatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHmcctippatolt(ValueChangeEvent valueChangeEvent) {
        motivo.setHmcctippatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeTraePatologia(){
        renderTipoPatologia = false;
        if(("S").equals(motivo.getHmcctrapatol())){
            renderTipoPatologia = true;
        }
        else{
            lstBiopsia = new ArrayList<SelectItem>();
            renderPatologiaCual = false;
            renderDescripcionResultados = false;
            motivo.setHmccdesres(null);
            motivo.setHmccresbiop(null);
            motivo.setHmccrespatol(null);
            motivo.setHmcccualpat(null);
            motivo.setHmcctippatol(null);
            motivo.setHmcctrapatol("N");
        }
    }
    
    public void changePatologia(){
        renderPatologiaCual = false;
        renderDescripcionResultados = false;
        lstBiopsia = new ArrayList<SelectItem>();
       if("OT".equals(motivo.getHmcctippatol())){
            motivo.setHmccresbiop(null);
            renderPatologiaCual = true;
            renderDescripcionResultados = true;
        }
        else if("CX".equals(motivo.getHmcctippatol())){
            motivo.setHmcccualpat(null);
            motivo.setHmccdesres(null);
            lstBiopsia.add(new SelectItem("NN","Negativo para neoplasia"));
            lstBiopsia.add(new SelectItem("DI","Displasia"));
            lstBiopsia.add(new SelectItem("NB","NIC de bajo grado (NIC I)"));
            lstBiopsia.add(new SelectItem("NA","NIC de alto grado: (NIC II - NIC III)"));
            lstBiopsia.add(new SelectItem("NM","Neoplasia micro infiltrante: escamocelular o adenocarcinoma"));
            lstBiopsia.add(new SelectItem("NI","Neoplasia Infiltrante: escamocelular o adenocarcinoma"));
        }
        else if("MA".equals(motivo.getHmcctippatol())){
            motivo.setHmcccualpat(null);
            motivo.setHmccdesres(null);
            lstBiopsia.add(new SelectItem("BE","Benigna"));
            lstBiopsia.add(new SelectItem("AT","At�pica (Indeterminada)"));
            lstBiopsia.add(new SelectItem("MS","Malignidad sospechosa/probable"));
            lstBiopsia.add(new SelectItem("MA","Maligna"));
            lstBiopsia.add(new SelectItem("NS","No satisfactoria"));
            
        }
        else{
        if("S".equals(motivo.getHmcctrapatol())){
            renderDescripcionResultados = true;
            motivo.setHmcccualpat(null);
        }
           
        }
    }


    /**
     * @return
     */
    public String guardarMotivo(String tipo) {
        navigationRule = "";
       
        if (!renderCabeza) {
            revision.setHrscrefiecabez(null);
        }

        if (!renderOjos) {
            revision.setHrscrefieojos(null);
        }

        if (!renderOidos) {
            revision.setHrscrefieoidos(null);
        }

        if (!renderNariz) {
            revision.setHrscrefienariz(null);
        }

        if (!renderBoca) {
            revision.setHrscrefieboca(null);
        }

        if (!renderGarganta) {
            revision.setHrscrefiegarga(null);
        }

        if (!renderCuello) {
            revision.setHrscrefiecuell(null);
        }

        if (!renderCardiorespiratorio) {
            revision.setHrscrefiecardi(null);
        }

        if (!renderMama) {
            revision.setHrscrefiemamas(null);
        }

        if (!renderGastrointestinal) {
            revision.setHrscrefiegastr(null);
        }

        if (!renderGenitourinario) {
            revision.setHrscrefiegenit(null);
        }
        
        if (!renderTuberculosis) {
            revision.setHrscrefietuber(null);
        }
        
        if (!renderLepra) {
            revision.setHrscrefielepra(null);
        }

        //        if (!renderVenereos) {
        //            revision.setHrscrefievener(null);
        //        }

        //        if (!renderEndocrino) {
        //            revision.setHrscrefieendoc(null);
        //        }

        if (!renderLocomotor) {
            revision.setHrscrefielocom(null);
        }

        if (!renderNeuromuscular) {
            revision.setHrscrefieneumu(null);
        }

        if (!renderNeuropsiqui) {
            revision.setHrscrefieneups(null);
        }

        if (!renderPiel) {
            revision.setHrscrefiepiel(null);
        }
        
        if (!renderDismenorrea) {
            revision.setHrscrefiedismeno(null);
        }
        
        if (!renderDispareunia) {
            revision.setHrscrefiedispar(null);
        }


        revision.setHrscoperador(userName());
        revision.setHrsdfecregistr(new Date());

        motivo.setHmccoperador(userName());
        motivo.setHmcdfecregistr(new Date());
        if (numeroConsulta != null) {
            motivo.getId().setHmclconsulta(numeroConsulta);
            motivo.getId().setHmcctiposervi(tipoServicio);

            revision.getId().setHrslconsulta(numeroConsulta);
            revision.getId().setHrsctiposervi(tipoServicio);

        }


        if (lstManiobras != null && !lstManiobras.isEmpty()) {
            motivo.setHmccmaniofarma("N");
            motivo.setHmccmanioinstru("N");
            motivo.setHmccmaniootro("N");
        }

        if (lstManiobras != null && !lstManiobras.isEmpty()) {
            for (String codaux: lstManiobras) {
                if (codaux.equals("IF")) {
                    motivo.setHmccmaniofarma("S");
                } else if (codaux.equals("II")) {
                    motivo.setHmccmanioinstru("S");
                } else if (codaux.equals("OT")) {
                    motivo.setHmccmaniootro("S");
                }
            }
        }
        if (motivo.getHmccmaniootro() != null && motivo.getHmccmaniootro().equals("N")) {
            motivo.setHmccmaniootrodesc(null);
        }

        if (lstInterrupcion != null && !lstInterrupcion.isEmpty()) {
            motivo.setHmccinteroprof("N");
            motivo.setHmccinterasegu("N");
        }

        if (lstInterrupcion != null && !lstInterrupcion.isEmpty()) {
            for (String codaux: lstInterrupcion) {
                if (codaux.equals("OP")) {
                    motivo.setHmccinteroprof("S");
                } else if (codaux.equals("AT")) {
                    motivo.setHmccinterasegu("S");
                }
            }
        }

    if(causaSelect != null){
        motivo.setHmcncausaexte(new Integer(causaSelect));
    }
        
        if (finalidadSelect != null){
            motivo.setHmcnfinalidad(new Integer(finalidadSelect));  
        }else{
            motivo.setHmcnfinalidad(new Integer(10));
        }
            
            motivo.setHmcctipoproce(tipo);
            
        
        if(asesoria != null){
        asesoria.setHailconsulta(numeroConsulta);
        asesoria.setHaidfecregistr(new Date());
        asesoria.setHaicoperador(userName());
        }
       
       
        try {
        if(asesoria != null && renderPreguntas){
            serviceLocator.getClinicoService().saveAsesoriaIve(asesoria);
        }
            
            serviceLocator.getClinicoService().saveMotivoConsulta(motivo, 
                                                                  revision);
            FacesUtils.addInfoMessage("Se ingreso la informaci�n satisfactoriamente.");
            if (motivo.getHmccfactosangre() != null && 
                motivo.getHmccfactosangre().equals("N")) {
                FacesUtils.addInfoMessage("Recuerde formular Inmunoglobulina anti D durante el procedimiento - " + 
                                          "tratamiento farmacol�gico, o hasta 72 horas posteriores al procedimiento o expulsi�n.");
            }
            if (motivo.getHmnencuestaphq9() != null && 
                motivo.getHmnencuestaphq9() >= 11) {
                if(tipoHistoria != null && tipoHistoria==HISTORIA_PSICOLOGICA ){
                FacesUtils.addInfoMessage("De recomendaciones y contin�e con las consultas de psicolog�a");
                }
                else{
                    FacesUtils.addInfoMessage("Remitir a consulta por Psicolog�a");
                }
                
            }
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            navigationRule = "";
            return capturaError(e,IConstantes.ERROR_GUARDADO);
        }
        
        
        return navigationRule;
    }


    public void setEsIlve(boolean esIlve) {
        this.esIlve = esIlve;
    }

    public boolean isEsIlve() {
        return esIlve;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setRenderPreguntas(boolean renderPreguntas) {
        this.renderPreguntas = renderPreguntas;
    }

    public boolean isRenderPreguntas() {
        return renderPreguntas;
    }

    public void setRenderManiobras(boolean renderManiobras) {
        this.renderManiobras = renderManiobras;
    }

    public boolean isRenderManiobras() {
        return renderManiobras;
    }

    public void setLstManiobras(List<String> lstManiobras) {
        this.lstManiobras = lstManiobras;
    }

    public List<String> getLstManiobras() {
        return lstManiobras;
    }

    /**
     * @param valueChangeEvent
     */
    public void setLstManiobras(ValueChangeEvent valueChangeEvent) {
        setLstManiobras((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMostrarotramaniobra(boolean mostrarotramaniobra) {
        this.mostrarotramaniobra = mostrarotramaniobra;
    }

    public boolean isMostrarotramaniobra() {
        return mostrarotramaniobra;
    }

    public void setLstInterrupcion(List<String> lstInterrupcion) {
        this.lstInterrupcion = lstInterrupcion;
    }

    public List<String> getLstInterrupcion() {
        return lstInterrupcion;
    }

    public void setLstInterrupcion(ValueChangeEvent valueChangeEvent) {
        setLstInterrupcion((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setRenderInterrupcion(boolean renderInterrupcion) {
        this.renderInterrupcion = renderInterrupcion;
    }

    public boolean isRenderInterrupcion() {
        return renderInterrupcion;
    }

    public void setLstMani(List lstMani) {
        this.lstMani = lstMani;
    }

    public List getLstMani() {
        if (lstMani == null || lstMani.isEmpty()) {
            lstMani = new ArrayList();
            lstMani.add(new SelectItem("S", "SI"));
            lstMani.add(new SelectItem("N", "NO"));
        }
        return lstMani;
    }

    public void setLstInte(List lstInte) {
        this.lstInte = lstInte;
    }

    public List getLstInte() {
        if (lstInte == null || lstInte.isEmpty()) {
            lstInte = new ArrayList();
            lstInte.add(new SelectItem("S", "SI"));
            lstInte.add(new SelectItem("N", "NO"));
        }
        return lstInte;
    }

 


    public void setRenderTuberculosis(boolean renderTuberculosis) {
        this.renderTuberculosis = renderTuberculosis;
    }

    public boolean isRenderTuberculosis() {
        return renderTuberculosis;
    }

    public void setRenderLepra(boolean renderLepra) {
        this.renderLepra = renderLepra;
    }

    public boolean isRenderLepra() {
        return renderLepra;
    }

    public void setLstTipoConsultaPsicologia(List<SelectItem> lstTipoConsultaPsicologia) {
            this.lstTipoConsultaPsicologia = lstTipoConsultaPsicologia;
    }

    public List<SelectItem> getLstTipoConsultaPsicologia() {
        if(lstTipoConsultaPsicologia ==null || lstTipoConsultaPsicologia.isEmpty()){
            lstTipoConsultaPsicologia= new ArrayList<SelectItem>();
            lstTipoConsultaPsicologia.add(new SelectItem("","Seleccione una Opcion"));
            lstTipoConsultaPsicologia.add(new SelectItem("DS","Discapacidad"));
            lstTipoConsultaPsicologia.add(new SelectItem("AT","aborto por trimestre"));
            lstTipoConsultaPsicologia.add(new SelectItem("VI","violencia"));
            lstTipoConsultaPsicologia.add(new SelectItem("VG","violencia basada en genero"));
            lstTipoConsultaPsicologia.add(new SelectItem("VS","violencia sexual"));
            lstTipoConsultaPsicologia.add(new SelectItem("CP","consulta psicolog�a cl�nica"));
              }
        
        return lstTipoConsultaPsicologia;
    }

    public void setLstFinalidadesProcedimiento(List lstFinalidadesProcedimiento) {
        this.lstFinalidadesProcedimiento = lstFinalidadesProcedimiento;
    }

    public List getLstFinalidadesProcedimiento() {
        if (lstFinalidadesProcedimiento == null || lstFinalidadesProcedimiento.isEmpty()) {
            lstFinalidadesProcedimiento = new ArrayList();
            ArrayList lstFinalidadesAux = null;
            try {
                lstFinalidadesAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getFinalidadesConsultaVG("P");
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstFinalidadesAux.isEmpty()) {
                lstFinalidadesProcedimiento.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                Iterator it = lstFinalidadesAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstFinalidadesProcedimiento.add(new SelectItem(((Crfinalcon)lstFinalidadesAux.get(i)).getId().getCfcncodigo().toString(), 
                                                      ((Crfinalcon)lstFinalidadesAux.get(i)).getCfccdescri()));
                }

            }
        }
        return lstFinalidadesProcedimiento;
        }


    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setAsesoria(Chasesoriaive asesoria) {
        this.asesoria = asesoria;
    }

    public Chasesoriaive getAsesoria() {
        return asesoria;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList<SelectItem>();
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No"));
        }
        return lstOpciones;
    }

    public void setRenderTeleorientacion(boolean renderTeleorientacion) {
        this.renderTeleorientacion = renderTeleorientacion;
    }

    public boolean isRenderTeleorientacion() {
        return renderTeleorientacion;
    }

    public void setRenderDismenorrea(boolean renderDismenorrea) {
        this.renderDismenorrea = renderDismenorrea;
    }

    public boolean isRenderDismenorrea() {
        return renderDismenorrea;
    }

    public void setRenderDispareunia(boolean renderDispareunia) {
        this.renderDispareunia = renderDispareunia;
    }

    public boolean isRenderDispareunia() {
        return renderDispareunia;
    }

    public void setMnuDismenorrea(UIInput mnuDismenorrea) {
        this.mnuDismenorrea = mnuDismenorrea;
    }

    public UIInput getMnuDismenorrea() {
        return mnuDismenorrea;
    }

    public void setMnuDispareunia(UIInput mnuDispareunia) {
        this.mnuDispareunia = mnuDispareunia;
    }

    public UIInput getMnuDispareunia() {
        return mnuDispareunia;
    }

    public void setRenderEnferOpc(Boolean renderEnferOpc) {
        this.renderEnferOpc = renderEnferOpc;
    }

    public Boolean getRenderEnferOpc() {
        return renderEnferOpc;
    }


    public void setLstPatologias(List<SelectItem> lstPatologias) {
        this.lstPatologias = lstPatologias;
    }

    public List<SelectItem> getLstPatologias() {
        return lstPatologias;
    }

    public void setLstResPatols(List<SelectItem> lstResPatols) {
        this.lstResPatols = lstResPatols;
    }

    public List<SelectItem> getLstResPatols() {
        if(lstResPatols == null || lstResPatols.isEmpty()){
            lstResPatols = new ArrayList<SelectItem>();
            lstResPatols.add(new SelectItem("P","Maligno"));
            lstResPatols.add(new SelectItem("N","Benigno"));
        }
        return lstResPatols;
    }

    public void setLstBiopsia(List<SelectItem> lstBiopsia) {
        this.lstBiopsia = lstBiopsia;
    }

    public List<SelectItem> getLstBiopsia() {
        return lstBiopsia;
    }

    public void setRenderTipoPatologia(boolean renderTipoPatologia) {
        this.renderTipoPatologia = renderTipoPatologia;
    }

    public boolean isRenderTipoPatologia() {
        return renderTipoPatologia;
    }

    public void setRenderPatologiaCual(boolean renderPatologiaCual) {
        this.renderPatologiaCual = renderPatologiaCual;
    }

    public boolean isRenderPatologiaCual() {
        return renderPatologiaCual;
    }

    public void setRenderDescripcionResultados(boolean renderDescripcionResultados) {
        this.renderDescripcionResultados = renderDescripcionResultados;
    }

    public boolean isRenderDescripcionResultados() {
        return renderDescripcionResultados;
    }

    public void setRendeGineco(boolean rendeGineco) {
        this.rendeGineco = rendeGineco;
    }

    public boolean isRendeGineco() {
        return rendeGineco;
    }
    
    public void changeResultados() {
        renderResultado = false;
        if (motivo.getHmccrespatol() != null && 
            motivo.getHmccrespatol().equals("P")) {
            renderResultado = true;
        } else {
            renderResultado=false;
            motivo.setHmnclashisto(null);
            motivo.setHmngradtumor(null);
        }
    }

    public void setRenderResultado(boolean renderResultado) {
        this.renderResultado = renderResultado;
    }

    public boolean isRenderResultado() {
        return renderResultado;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setHmccrespatol(ValueChangeEvent valueChangeEvent) {
        motivo.setHmccrespatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setLstClasificacionHistol(List<SelectItem> lstClasificacionHistol) {
        this.lstClasificacionHistol = lstClasificacionHistol;
    }

    public List<SelectItem> getLstClasificacionHistol() {
        if(lstClasificacionHistol == null || lstClasificacionHistol.isEmpty()){
            lstClasificacionHistol = new ArrayList<SelectItem>();
            lstClasificacionHistol.add(new SelectItem(0,"Seleccione..."));
            lstClasificacionHistol.add(new SelectItem(1,"1= Adenocarcinoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(2,"2= Carcinoma escamocelular (epidermoide), con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(3,"3= Carcinoma de c�lulas basales (basocelular)"));
            lstClasificacionHistol.add(new SelectItem(4,"4=Carcinoma, con o sin otra especificaci�n diferentes a las anteriores"));
            lstClasificacionHistol.add(new SelectItem(5,"5= Oligodendroglioma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(6,"6= Astrocitoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(7,"7= Ependimoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(8,"8= Neuroblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(9,"9= Meduloblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(10,"10= Hepatoblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(11,"11= Rabdomiosarcoma, con o sin otra especificaci�"));
            lstClasificacionHistol.add(new SelectItem(12,"12= Leiomiosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(12,"13= Osteosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(14,"14= Fibrosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(15,"15= Angiosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(16,"16= Condrosarcoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(17,"17= Otros sarcomas, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(18,"18= Pancreatoblastoma, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(19,"19= Blastoma pleuropulmonar, con o sin otra especificaci�n"));
            lstClasificacionHistol.add(new SelectItem(20,"20= Otros tipos histol�gicos no mencionados"));
            lstClasificacionHistol.add(new SelectItem(21,"23= Melanoma"));
            lstClasificacionHistol.add(new SelectItem(22,"24= Carcinoma papilar de tiroides"));
        }
  
        return lstClasificacionHistol;
    }

    public void setLstGradoTumor(List<SelectItem> lstGradoTumor) {
        this.lstGradoTumor = lstGradoTumor;
    }

    public List<SelectItem> getLstGradoTumor() {
        if(lstGradoTumor == null || lstGradoTumor.isEmpty()){
            lstGradoTumor = new ArrayList<SelectItem>();
            lstGradoTumor.add(new SelectItem(0,"Seleccione.."));
            lstGradoTumor.add(new SelectItem(1,"1= Bien diferenciado (grado1-GRADO BAJO)"));
            lstGradoTumor.add(new SelectItem(2,"2= Moderadamente diferenciado (grado 2 GRADO INTERMEDIO)"));
            lstGradoTumor.add(new SelectItem(3,"3= Mal diferenciado (grado 3 GRADO ALTO)"));
            lstGradoTumor.add(new SelectItem(4,"4= Anapl�sico o indiferenciado (grado 4)"));

        }
        return lstGradoTumor;
    }

    public void setRenderPHQ9(boolean renderPHQ9) {
        this.renderPHQ9 = renderPHQ9;
    }

    public boolean isRenderPHQ9() {
        return renderPHQ9;
    }
}
