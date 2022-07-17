package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chunidades;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCie10Bean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaCirugiaBean;
import org.profamilia.hc.view.backing.menus.cirugia.MenuAnestesiaBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class RegistrarAnetesiaBean extends BaseBean {

    private Chanestesia anestesia;

    private Chcirugprogr cirugia;

    private List lstCirugias;

    private List lstEstadoLLegar;

    private List lstPosicion;

    private List lstOpciones;

    private int selectedIndex;

    private boolean renderMascara;

    private boolean renderCanula;

    private boolean renderDispositivo;

    private boolean renderTuboOro;

    private List lstTipoDispositivo;

    /** Almacena la lista de los tipos de anestesia  */
    private List lstTipoAnestesia;

    private List lstGradoASA;

    private boolean esurgencia;

    private boolean renderAyuno;

    private boolean renderCircuito;

    private boolean renderAgente;

    private Chingresoenf ingreso;

    /** Almacena la lista de los tipos de Circuito  */
    private List lstTipoCircuito;

    /** Almacena la lista de los tipos de Agentes  */
    private List lstAgentes;


    /** Almacena la lista de los tipos de ventilaci�n  */
    private List lstVentilacion;

    static final int ACTIVAR_BUSCADOR_DIAGNOSTICO = 1;

    static final int ACTIVAR_REGISTRO_DATOS = 0;

    private boolean mostrarCie10;

    private UIInput itDiagPreoperatorio;

    private String diagnosticoPreoperatorio;

    private Crdgncie10 diagprin;

    private Integer edad;

    private Crdgncie10 diagprincipal;

    private List lstProfesionales;

    private List lstAnestesiologos;

    private Cpusuario anestesio;
    
    private String navigationRule;
    
    private boolean wexito;
    
    private String diagnosticoPrincipal;
    
    static final int ACTIVAR_BUSCADOR_PLANTILLAS = 2;
    
    static final int ACTIVAR_BUSCADOR_DESCRIPCION= 2;
    
    static final int ACTIVAR_APLICACION = 0;
    
    private boolean renderPlantilla;
    
    private UIInput itDescripcion;


    public RegistrarAnetesiaBean() {
        lstCirugias = new ArrayList();
    }

    public void init() {
        lstCirugias = new ArrayList();
   
        initRegisgtrarAnestesia();
    }


    public void initRegisgtrarAnestesia() {
        esurgencia = false;
        renderAyuno = false;
        
        if (cirugia != null && cirugia.getHcplnumero() != null) {
            try {
                anestesia = 
                        this.serviceLocator.getClinicoService().getEncabezadoRegistroAnestesia(cirugia.getHcplnumero());

                ingreso = 
                        this.serviceLocator.getClinicoService().getIngresoEnfermeria(cirugia.getHcplnumero());

                if (ingreso != null) {
                    if (ingreso.getHiecayunopre() != null && 
                        ingreso.getHiecayunopre().equals("S")) {
                        renderAyuno = true;
                    }
                }

                if (cirugia.getChdetacirpros() != null && 
                    !cirugia.getChdetacirpros().isEmpty()) {
                    Chdetacirpro detalle = null;
                    Iterator it = cirugia.getChdetacirpros().iterator();
                    while (it.hasNext()) {
                        detalle = (Chdetacirpro)it.next();

                        if (detalle != null && 
                            detalle.getId().getHdccservicio() != null) {
                            Cpservicio servicio = 
                                this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                            lstCirugias.add(servicio);
                        }
                    }
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }


        }

        if (cirugia != null) {
            Object[] lstImpresionaux = null;
            Object[] lstImpresionanes = null;
            try {

                lstImpresionaux = 
                        (Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreUsuario(cirugia.getHcplusuario().getHuslnumero());
                        
                lstImpresionanes = 
                        (Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreAnesUsuario(cirugia.getHcplusuario().getHuslnumero());

            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(anestesia == null){
                anestesia = new Chanestesia();
            }


            if (lstImpresionaux == null && lstImpresionanes == null) {
                FacesUtils.addInfoMessage(MSG_NO_TIENE_VALORACION_PREOPERATORIA);
                FacesUtils.addInfoMessage(MSG_NO_TIENE_VALORACION_PREANESTESICA);
            } 
        
                if(lstImpresionanes != null){
                    anestesia.setHancdiagprinci((String)lstImpresionanes[0]);
                    if(itDiagPreoperatorio != null){
                        itDiagPreoperatorio.setValue((Object)(String)lstImpresionanes[0]);
                    }
                    
                    if(lstImpresionanes[2]!= null){
                        BigDecimal gradoASApre = (BigDecimal)lstImpresionanes[2];
                        
                        if(gradoASApre != null){
                            anestesia.setHanngradoasa(gradoASApre.intValue());

                        }
                        
                    }
                  
                    
                   
                    


                    try {
                        diagprincipal = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(anestesia.getHancdiagprinci().toUpperCase());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (diagprincipal != null && 
                        diagprincipal.getCdcccodigo() != null) {
                        diagnosticoPreoperatorio = diagprincipal.getCdccdescri();


                    }
                }
                
    
          
            if (lstImpresionaux != null) {

                anestesia.setHancdiagprinci((String)lstImpresionaux[0]);
                if(itDiagPreoperatorio != null){
                    itDiagPreoperatorio.setValue((Object)(String)lstImpresionaux[0]);
                }
            


                try {
                    diagprincipal = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(anestesia.getHancdiagprinci().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprincipal != null && 
                    diagprincipal.getCdcccodigo() != null) {
                    diagnosticoPreoperatorio = diagprincipal.getCdccdescri();


                }
            }
            
         


            Object[] lstExamenaux = null;
            Object[] lstExamenanes = null;

            try {
                lstExamenaux = 
                        (Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreExamUsuario(cirugia.getHcplusuario().getHuslnumero());
                        
                lstExamenanes = 
                        (Object[])this.serviceLocator.getCirugiaService().getUltimaValoracionPreExamAnesUsuario(cirugia.getHcplusuario().getHuslnumero());
                        
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstExamenaux == null && lstExamenanes == null ) {
                FacesUtils.addErrorMessage(MSG_NO_TIENE_VALORACION_PREOPERATORIA);
                FacesUtils.addErrorMessage(MSG_NO_TIENE_VALORACION_PREANESTESICA);
            }
          
            if (lstExamenaux != null && lstExamenanes != null) {
                anestesia.setHannpeso((BigDecimal)lstExamenanes[0]);
            }
            if(lstExamenaux != null){
                anestesia.setHannpeso((BigDecimal)lstExamenaux[0]);
            }
            if(lstExamenanes != null){
                anestesia.setHannpeso((BigDecimal)lstExamenanes[0]);
            }

            BigDecimal medicoCirugia = null;

            try {
                medicoCirugia = 
                        this.serviceLocator.getCirugiaService().getMedicoProgramacion(cirugia.getHcplnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (medicoCirugia != null) {
                anestesia.setHannmedicatien(medicoCirugia);
            }


            try {
                anestesio = 
                        this.serviceLocator.getCirugiaService().getAnestesiologosAnestesia(userName());

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (anestesio != null) {
                anestesia.setHannanestesiol(anestesio.getCurnprofes());
            }


        }


        if (anestesia == null) {
            anestesia = new Chanestesia();
            anestesia.setHanngradoasa(1);
            anestesia.setHancestadllega("1");
            anestesia.setHanctipoanest("2");
        } else {
        
            if(anestesia.getHanngradoasa() == null){
                anestesia.setHanngradoasa(1);    
            }
            
            if(anestesia.getHancestadllega() == null || anestesia.getHancestadllega().equals("")){
                anestesia.setHancestadllega("1");
            }
            
            
            if(anestesia.getHanctipoanest() == null || anestesia.getHanctipoanest().equals("")){
                anestesia.setHanctipoanest("2");
            }
          
            

            if (anestesia.getHancmascafacia() != null && 
                anestesia.getHancmascafacia().equals("S")) {
                renderMascara = true;
            }


            if (anestesia.getHanccanulbucor() != null && 
                anestesia.getHanccanulbucor().equals("S")) {
                renderCanula = true;
            }


            if (anestesia.getHancmascalarin() != null && 
                anestesia.getHancmascalarin().equals("S")) {
                renderDispositivo = true;
            }


            if (anestesia.getHanctuboorotr() != null && 
                anestesia.getHanctuboorotr().equals("S")) {
                renderTuboOro = true;
            }

            if (anestesia.getHancurgenasa() != null && 
                anestesia.getHancurgenasa().equals("S")) {
                esurgencia = true;
            }

            if (anestesia != null && anestesia.getHanntipocircu() != null) {
                if (anestesia.getHanntipocircu().equals(5)) {
                    renderCircuito = true;
                }

                if (anestesia != null && 
                    anestesia.getHanngasesagent() != null) {
                    if (anestesia.getHanngasesagent().equals(3)) {
                        renderAgente = true;
                    }

                }
            }
            
        if (anestesia.getHancdiagprinci() != null) {
                try {
                        diagprin = 
                                this.serviceLocator.getClinicoService().getCIE10PorCodigo(anestesia.getHancdiagprinci().toUpperCase());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    
                    if(diagprin != null){
                        diagnosticoPreoperatorio = diagprin.getCdccdescri();
                    }
                    
            }
 
        }
    }


    /**
     * @param lstGradoASA
     */
    public void setLstGradoASA(List lstGradoASA) {
        this.lstGradoASA = lstGradoASA;
    }

    /**
     * @return
     */
    public List getLstGradoASA() {
        if (lstGradoASA == null || lstGradoASA.isEmpty()) {
            lstGradoASA = new ArrayList();
            lstGradoASA.add(new SelectItem(1, "1"));
            lstGradoASA.add(new SelectItem(2, "2"));
            lstGradoASA.add(new SelectItem(3, "3"));
            lstGradoASA.add(new SelectItem(4, "4"));
            lstGradoASA.add(new SelectItem(5, "5"));
        }
        return lstGradoASA;
    }

    /**
     * @param esurgencia
     */
    public void setEsurgencia(boolean esurgencia) {
        this.esurgencia = esurgencia;
    }

    /**
     * @return
     */
    public boolean isEsurgencia() {
        return esurgencia;
    }


    /**
     * @param anestesia
     */
    public void setAnestesia(Chanestesia anestesia) {
        this.anestesia = anestesia;
    }

    /**
     * @return
     */
    public Chanestesia getAnestesia() {
        return anestesia;
    }


    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }


    /**
     * @param lstEstadoLLegar
     */
    public void setLstEstadoLLegar(List lstEstadoLLegar) {
        this.lstEstadoLLegar = lstEstadoLLegar;
    }

    /**
     * @return
     */
    public List getLstEstadoLLegar() {
        if (lstEstadoLLegar == null || lstEstadoLLegar.isEmpty()) {
            lstEstadoLLegar = new ArrayList();
            lstEstadoLLegar.add(new SelectItem("1", "No Ansiosa"));
            lstEstadoLLegar.add(new SelectItem("2", "Ansiosa"));
            lstEstadoLLegar.add(new SelectItem("3", "Muy ansiosa"));

        }
        return lstEstadoLLegar;
    }

    /**
     * @param lstPosicion
     */
    public void setLstPosicion(List lstPosicion) {
        this.lstPosicion = lstPosicion;
    }

    /**
     * @return
     */
    public List getLstPosicion() {
        if (lstPosicion == null || lstPosicion.isEmpty()) {
            lstPosicion = new ArrayList();
            lstPosicion.add(new SelectItem("", "Seleccione"));
            lstPosicion.add(new SelectItem(1, "Dec�bito supino"));
            lstPosicion.add(new SelectItem(2, "Fowler"));
            lstPosicion.add(new SelectItem(3, "Litotom�a"));
            lstPosicion.add(new SelectItem(4, "Litotom�a+Trendelenburg"));
            lstPosicion.add(new SelectItem(5, "Litotom�a+Fowler"));
            lstPosicion.add(new SelectItem(6, "Decubito ventral"));
            lstPosicion.add(new SelectItem(7, "Trendelemburg"));
            lstPosicion.add(new SelectItem(8, "Trendelemburg Invertida"));
            lstPosicion.add(new SelectItem(9, "Neutro"));
        }
        return lstPosicion;
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
     * @param renderAyuno
     */
    public void setRenderAyuno(boolean renderAyuno) {
        this.renderAyuno = renderAyuno;
    }

    /**
     * @return
     */
    public boolean isRenderAyuno() {
        return renderAyuno;
    }

    /**
     * @param ingreso
     */
    public void setIngreso(Chingresoenf ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * @return
     */
    public Chingresoenf getIngreso() {
        return ingreso;
    }

    /**
     * @param renderMascara
     */
    public void setRenderMascara(boolean renderMascara) {
        this.renderMascara = renderMascara;
    }

    /**
     * @return
     */
    public boolean isRenderMascara() {
        return renderMascara;
    }

    /**
     * @param renderCanula
     */
    public void setRenderCanula(boolean renderCanula) {
        this.renderCanula = renderCanula;
    }

    /**
     * @return
     */
    public boolean isRenderCanula() {
        return renderCanula;
    }

    /**
     * @param renderDispositivo
     */
    public void setRenderDispositivo(boolean renderDispositivo) {
        this.renderDispositivo = renderDispositivo;
    }

    /**
     * @return
     */
    public boolean isRenderDispositivo() {
        return renderDispositivo;
    }

    /**
     * @param renderTuboOro
     */
    public void setRenderTuboOro(boolean renderTuboOro) {
        this.renderTuboOro = renderTuboOro;
    }

    /**
     * @return
     */
    public boolean isRenderTuboOro() {
        return renderTuboOro;
    }

    /**
     * @param lstTipoDispositivo
     */
    public void setLstTipoDispositivo(List lstTipoDispositivo) {
        this.lstTipoDispositivo = lstTipoDispositivo;
    }

    /**
     * @return
     */
    public List getLstTipoDispositivo() {
        if (lstTipoDispositivo == null || lstTipoDispositivo.isEmpty()) {
            lstTipoDispositivo = new ArrayList();
            lstTipoDispositivo.add(new SelectItem("1", "Clasica"));
            lstTipoDispositivo.add(new SelectItem("2", "Con canal esof�gico"));
        }

        return lstTipoDispositivo;
    }

    /**
     * @param lstTipoCircuito
     */
    public void setLstTipoCircuito(List lstTipoCircuito) {
        this.lstTipoCircuito = lstTipoCircuito;
    }

    /**
     * @return
     */
    public List getLstTipoCircuito() {
        if (lstTipoCircuito == null || lstTipoCircuito.isEmpty()) {
            lstTipoCircuito = new ArrayList();
            lstTipoCircuito.add(new SelectItem("", "Seleccione..."));
            lstTipoCircuito.add(new SelectItem(1, "CCC"));
            lstTipoCircuito.add(new SelectItem(2, "CCSC"));
            lstTipoCircuito.add(new SelectItem(3, "BAIN"));
            lstTipoCircuito.add(new SelectItem(4, "Jackson R"));
            lstTipoCircuito.add(new SelectItem(5, "Otro"));
        }

        return lstTipoCircuito;
    }

    /**
     * @param renderCircuito
     */
    public void setRenderCircuito(boolean renderCircuito) {
        this.renderCircuito = renderCircuito;
    }

    /**
     * @return
     */
    public boolean isRenderCircuito() {
        return renderCircuito;
    }

    /**
     * @param renderAgente
     */
    public void setRenderAgente(boolean renderAgente) {
        this.renderAgente = renderAgente;
    }

    /**
     * @return
     */
    public boolean isRenderAgente() {
        return renderAgente;
    }


    /**
     * @param lstAgentes
     */
    public void setLstAgentes(List lstAgentes) {
        this.lstAgentes = lstAgentes;
    }

    /**
     * @return
     */
    public List getLstAgentes() {
        if (lstAgentes == null || lstAgentes.isEmpty()) {
            lstAgentes = new ArrayList();
            lstAgentes.add(new SelectItem("", "Seleccione..."));
            lstAgentes.add(new SelectItem(1, "O2 CAJON ABIERTO LPM"));
            lstAgentes.add(new SelectItem(2, "N2O CAJON ABIERTO LPM"));
            lstAgentes.add(new SelectItem(3, "Otro CAJON ABIERTO LPM "));
        }

        return lstAgentes;
    }

    /**
     * @param lstVentilacion
     */
    public void setLstVentilacion(List lstVentilacion) {
        this.lstVentilacion = lstVentilacion;
    }

    /**
     * @return
     */
    public List getLstVentilacion() {
        if (lstVentilacion == null || lstVentilacion.isEmpty()) {
            lstVentilacion = new ArrayList();
            lstVentilacion.add(new SelectItem("", "Seleccione..."));
            lstVentilacion.add(new SelectItem(1, "Manual"));
            lstVentilacion.add(new SelectItem(2, "Mec�nica"));
            lstVentilacion.add(new SelectItem(3, "F.R"));
            lstVentilacion.add(new SelectItem(4, "V.C"));
        }

        return lstVentilacion;
    }


    /**
     * @param valueChangeEvent
     */
    public void setHanntipocircu(ValueChangeEvent valueChangeEvent) {
        anestesia.setHanntipocircu((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHanngasesagent(ValueChangeEvent valueChangeEvent) {
        anestesia.setHanngasesagent((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setRenderCanula(ValueChangeEvent valueChangeEvent) {
        setRenderCanula((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setRenderTuboOro(ValueChangeEvent valueChangeEvent) {
        setRenderTuboOro((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderDispositivo(ValueChangeEvent valueChangeEvent) {
        setRenderDispositivo((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setLstTipoAnestesia(List lstTipoAnestesia) {
        this.lstTipoAnestesia = lstTipoAnestesia;
    }

    public List getLstTipoAnestesia() {
        if (lstTipoAnestesia == null || lstTipoAnestesia.isEmpty()) {
            lstTipoAnestesia = new ArrayList();
            lstTipoAnestesia.add(new SelectItem("2", "General"));
            lstTipoAnestesia.add(new SelectItem("4", "Regional"));
            lstTipoAnestesia.add(new SelectItem("5", "Sedaci�n"));
            lstTipoAnestesia.add(new SelectItem("6", "Local Controlada"));


        }
        return lstTipoAnestesia;
    }

    public void changeTipoCircuito() {
        renderCircuito = false;
        if (anestesia != null && anestesia.getHanntipocircu() != null) {
            if (anestesia.getHanntipocircu().equals(5)) {
                renderCircuito = true;
            }
        }
    }


    public void changeAgente() {
        renderAgente = false;
        if (anestesia != null && anestesia.getHanngasesagent() != null) {
            if (anestesia.getHanngasesagent().equals(3)) {
                renderAgente = true;
            }
        }
    }


    public String registrarAnestesia() {
        wexito = true;
        navigationRule = "";
        anestesia.setHancoperador(userName());
        anestesia.setHanctiposervi(TIPO_HOSPITALIZACION);
        anestesia.setHandfecregistr(new Date());
        
        if(ingreso != null && ingreso.getHiecdescayuno() != null && ingreso.getHiecdescayuno().equals("SI")){
            if(ingreso.getHienayunosolid() != null && ingreso.getHienayunosolid() < 6){
              //  wexito = false;
                FacesUtils.addErrorMessage(MSG_NO_CUMPLE_AYUNO);
            }
            if(ingreso.getHienayunoliqui() != null && ingreso.getHienayunoliqui() < 6){
//                wexito = false;
                FacesUtils.addErrorMessage(MSG_NO_CUMPLE_AYUNO);
            }
        }

        if (anestesia.getHancdiagprinci() != null && diagprin != null) {
            diagnosticoPrincipal = diagprin.getCdccdescri();
        } else {
            diagnosticoPrincipal = null;
        }
        if (diagnosticoPrincipal == null || diagnosticoPrincipal.trim().equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PRINCIPAL_NO_VALIDO);
        }

        if (anestesia != null && anestesia.getHanntipocircu() != null) {
            if (!anestesia.getHanntipocircu().equals(5)) {
                anestesia.setHancotrocircu(null);
            }
        }


        if (anestesia != null && anestesia.getHanngasesagent() != null) {
            if (!anestesia.getHanngasesagent().equals(3)) {
                anestesia.setHancotroagent(null);
            }
        }

        if (esurgencia) {
            anestesia.setHancurgenasa("S");
        } else {
            anestesia.setHancurgenasa("N");
        }

        if (renderMascara) {
            anestesia.setHancmascafacia("S");
        } else {
            anestesia.setHancmascafacia("N");
            anestesia.setHannmascalarin(null);
        }


        if (renderCanula) {
            anestesia.setHanccanulbucor("S");
        } else {
            anestesia.setHanccanulbucor("N");
            anestesia.setHanncanulbucor(null);
        }


        if (renderDispositivo) {
            anestesia.setHancmascalarin("S");
        } else {
            anestesia.setHancmascalarin("N");
            anestesia.setHannmascalarin(null);
            anestesia.setHanctipolarin(null);
        }


        if (renderTuboOro) {
            anestesia.setHanctuboorotr("S");
        } else {
            anestesia.setHanctuboorotr("N");
            anestesia.setHanntuboorotr(null);
        }

        if (cirugia != null && cirugia.getHcplnumero() != null && 
            anestesia.getHanlnumero() == null) {
            anestesia.setHanlnumero(cirugia.getHcplnumero());
        }
        if (cirugia != null && cirugia.getHcplusuario() != null && 
            cirugia.getHcplusuario().getHuslnumero() != null) {
            anestesia.setHanlusuario(cirugia.getHcplusuario().getHuslnumero());
        }
        anestesia.setHannclinica(this.getClinica().getCclncodigo());


        try {
        if(wexito){
            serviceLocator.getClinicoService().saveEncabezadoRegistroAnestesia(anestesia);
            MenuAnestesiaBean menuAntes = (MenuAnestesiaBean)FacesUtils.getManagedBean("menuAnestesiaBean");
            menuAntes.init();
             FacesUtils.addInfoMessage(MSG_ADICION);
            
            navigationRule = "irRegistrarMedidasProteccionAnestesia";
        }
           
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION + " ERROR: " + 
                                       e.getMessage());
        }
        return navigationRule;
    }
    
    
    
    public  boolean esValido(){
        Chanestesia anestesiaAux = null;


        try {
        if(cirugia != null){
            anestesiaAux =  this.serviceLocator.getClinicoService().getEncabezadoRegistroAnestesia(cirugia.getHcplnumero());
        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(anestesiaAux == null){
            return false;
        }
        
        return true;   
    }


    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }


    public void mostrarDiagnosticoComplicacion() {
        BuscadorCie10Bean cie10;
        if (anestesia != null) {
            anestesia.setHancdiagprinci(null);
        }

        cie10 = 
                (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(false);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(true);
        cie10.setDiagnosticoRelacionado3(false);
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
        mostrarCie10 = true;
    }


    public void aceptarDiagnostico() {
        BuscadorCie10Bean cie10;
        cie10 = 
                (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");

        if (cie10 != null && cie10.getCie10Select() != null) {

            if (cie10.isDiagnosticoPrincipal()) {
                anestesia.setHancdiagprinci(cie10.getCie10Select().getCdcccodigo());
                itDiagPreoperatorio.setValue(cie10.getCie10Select().getCdcccodigo());
                diagnosticoPreoperatorio = 
                        cie10.getCie10Select().getCdccdescri();
                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(anestesia.getHancdiagprinci().toUpperCase());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }


        }

        mostrarCie10 = false;
        selectedIndex = ACTIVAR_REGISTRO_DATOS;
        cie10.clear();

    }

    public void mostrarBuscadorPlantilla() {
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
        BuscadorPlantillaCirugiaBean buscador = (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if(buscador != null){
            buscador.setNombreBeanAnterior("registrarAnetesiaBean");
            buscador.setTagRenderizar("panelGridRegistrarAnestesiaTab");
        }
        selectedIndex = ACTIVAR_BUSCADOR_PLANTILLAS;
        renderPlantilla = true; 
    }
    
    public void aceptarPlantilla() {
        BuscadorPlantillaCirugiaBean buscador = 
            (BuscadorPlantillaCirugiaBean)FacesUtils.getManagedBean("buscadorPlantillaCirugiaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            itDescripcion.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
            anestesia.setHancobseringre(buscador.getPlantillaSelect().getHplcdescripcio());

        }
        renderPlantilla = false; 
        selectedIndex = ACTIVAR_APLICACION;
        FacesUtils.resetManagedBean("buscadorPlantillaCirugiaBean");
    }
 
    public void setMostrarCie10(boolean mostrarCie10) {
        this.mostrarCie10 = mostrarCie10;
    }

    public boolean isMostrarCie10() {
        return mostrarCie10;
    }

    public void setItDiagPreoperatorio(UIInput itDiagPreoperatorio) {
        this.itDiagPreoperatorio = itDiagPreoperatorio;
    }

    public UIInput getItDiagPreoperatorio() {
        return itDiagPreoperatorio;
    }

    public void setDiagnosticoPreoperatorio(String diagnosticoPreoperatorio) {
        this.diagnosticoPreoperatorio = diagnosticoPreoperatorio;
    }

    public String getDiagnosticoPreoperatorio() {
        return diagnosticoPreoperatorio;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHancdiagprinci(ValueChangeEvent valueChangeEvent) {
        anestesia.setHancdiagprinci((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    /**
     * @param valueChangeEvent
     */
    public void setHienayunosolid(ValueChangeEvent valueChangeEvent) {
        ingreso.setHienayunoliqui((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    

    public void changeDiagnosticoPreoperatorio() {

        if (cirugia != null && cirugia.getHcplusuario()!= null &&  cirugia.getHcplusuario().getHusdfechanacim() != null) {
            edad = calcularEdad(cirugia.getHcplusuario().getHusdfechanacim(), new Date());
        }

        diagnosticoPreoperatorio = null;
        List validacionRelacionado1 = null;

        if (anestesia.getHancdiagprinci() != null && 
            !anestesia.getHancdiagprinci().equals("")) {
            try {
                diagprin = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(anestesia.getHancdiagprinci().toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagprin != null && diagprin.getCdcccodigo() != null) {
                diagnosticoPreoperatorio = diagprin.getCdccdescri();
                validacionRelacionado1 = 
                        this.serviceLocator.getClinicoService().getVerificacionCie10(diagprin, 
                                                                                     cirugia.getHcplusuario().getHusesexo(), 
                                                                                     "1", 
                                                                                     edad, 
                                                                                     "N");

                if (validacionRelacionado1 != null && 
                    !validacionRelacionado1.isEmpty()) {
                    if (validacionRelacionado1.get(1) != null) {
                        FacesUtils.addErrorMessage(MSG_DIAGNOSTICO_PREOPERATORIO + 
                                                   validacionRelacionado1.get(1));
                    }

                }

            }

            if (diagnosticoPreoperatorio == null || 
                diagnosticoPreoperatorio.equals("")) {
                FacesUtils.addErrorMessage(IMsg.MSG_DIAGNOSTICO_PREOPERATORIO_NO_VALIDO);
            }
        } else {
            diagnosticoPreoperatorio = "";
        }
    }

    public void setDiagprin(Crdgncie10 diagprin) {
        this.diagprin = diagprin;
    }

    public Crdgncie10 getDiagprin() {
        return diagprin;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void mostrarDiagnosticoPreoperatorio() {
        BuscadorCie10Bean cie10;
        if (anestesia != null) {
            anestesia.setHancdiagprinci(null);
        }
        cie10 = 
                (BuscadorCie10Bean)FacesUtils.getManagedBean("buscadorCie10Bean");
        cie10.setDiagnosticoPrincipal(true);
        cie10.setDiagnosticoRelacionado1(false);
        cie10.setDiagnosticoRelacionado2(false);
        cie10.setDiagnosticoRelacionado3(false);
        mostrarCie10 = true;
        selectedIndex = ACTIVAR_BUSCADOR_DIAGNOSTICO;
    }

    public void setDiagprincipal(Crdgncie10 diagprincipal) {
        this.diagprincipal = diagprincipal;
    }

    public Crdgncie10 getDiagprincipal() {
        return diagprincipal;
    }

    public void setLstProfesionales(List lstProfesionales) {
        this.lstProfesionales = lstProfesionales;
    }

    public List getLstProfesionales() {
        if (lstProfesionales == null || lstProfesionales.isEmpty()) {
            lstProfesionales = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaMedicosClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstProfesionales.add(new SelectItem("", 
                                                    "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstProfesionales.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo(), 
                                                        listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstProfesionales;
    }


    /**
     * @param lstAnestesiologos
     */
    public void setLstAnestesiologos(List lstAnestesiologos) {
        this.lstAnestesiologos = lstAnestesiologos;
    }

    /**
     * @return
     */
    public List getLstAnestesiologos() {
        if (lstAnestesiologos == null || lstAnestesiologos.isEmpty()) {
            lstAnestesiologos = new ArrayList();
            ArrayList<Cpprofesio> listProfesionalesAux = null;
            try {
                listProfesionalesAux = 
                        (ArrayList<Cpprofesio>)this.serviceLocator.getClinicoService().getListaAnestesiologoClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listProfesionalesAux.isEmpty()) {

                Iterator it = listProfesionalesAux.iterator();
                int i = 0;
                lstAnestesiologos.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstAnestesiologos.add(new SelectItem(listProfesionalesAux.get(i).getId().getCpfncodigo().toString(), 
                                                         listProfesionalesAux.get(i).getCpfcnombre()));
                    i++;
                }
            }
        }

        return lstAnestesiologos;
    }


    public void setAnestesio(Cpusuario anestesio) {
        this.anestesio = anestesio;
    }

    public Cpusuario getAnestesio() {
        return anestesio;
    }


    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }


    public void setWexito(boolean wexito) {
        this.wexito = wexito;
    }

    public boolean isWexito() {
        return wexito;
    }


    public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
        this.diagnosticoPrincipal = diagnosticoPrincipal;
    }

    public String getDiagnosticoPrincipal() {
        return diagnosticoPrincipal;
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
}
