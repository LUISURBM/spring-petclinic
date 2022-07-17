//=======================================================================
// ARCHIVO AntecedentesBean.java
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

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
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.ChmedicamentId;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
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
public class AntecedentesUsuarioBean extends BaseBean {
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

    private String reaccionVacuna;

    private String obsVacuna;

    private boolean esVacunacion;
    private boolean renderReacciones;

    private Chmedicament medicamento;
    private Integer consecutivo;

    private List<Chmedicament> lstMedicamentoAtender;

    private String mensajeAnteToxico;

    private boolean renderMensajeAnteToxico;

    private boolean renderPrenatal;
    //antecedentes
    private Chantox toxicos;
    private Chantfami familiares;
    private Chantalerg alergicos;
    private Chantfarma farmacologicos;
    private Chantit its;
    private Chanttrans transfusionales;
    private Chantpatol patologicos;
    private Chantquir quirurgicos;
    private Chanttrauma traumacologicos;
    private List<SelectItem>lstOpcionesAntecedentes;
    private boolean renderPatologicos;
    private boolean renderQuirurgicos;
    private boolean renderToxicos;
    private boolean renderAlergicos;
    private boolean renderFamiliares;
    private boolean renderTransfusionales;
    private boolean renderITS;
    private boolean renderFarmacologicos;
    private boolean renderTraumaticos;
    private List<String>chkboxAlergicos;
    private List<SelectItem>lstAlergicos;
    private boolean renderAlergicosChkbox1;
    private boolean renderAlergicosChkbox2;
    private boolean renderAlergicosChkbox3;
    private boolean renderAlergicosChkbox4;
    private boolean renderAlergicosChkbox5;
    private boolean renderAlergicosChkbox6;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AntecedentesUsuarioBean() {
    }

    public void init() {
        lstHistoricoAntecedente = new ArrayList();
        nextAction = "";
        mensajeAnteToxico = 
                "Por favor realice la encuesta de tamizaje " + "PRUEBA DE TAMIZAJE ASSIST PARA DETECCI�N TEMPRANA Y VALORACI�N DEL RIESGO " + 
                "POR CONSUMO DE SUSTANCIAS PSICOACTIVAS Y ALCOHOL FO-GS-CE-142";
        inicializarAntecedentes();

    }


    public void inicializarAntecedentes() {
        renderPrenatal = false;
        if (IConstantes.HISTORIA_PRENATAL.equals(tipoHistoria)) {
            renderPrenatal = true;
            
        }
        renderMensajeAnteToxico = false;
        // Obtiene el tipo de historia    
        medicamento = new Chmedicament();
        consecutivo = 1;
        renderReacciones = false;
        changeReacciones();
        esVacunacion = true;
        try {
            if (usuario != null && usuario.getHuslnumero() != null) {
                lstHistoricoAntecedente = 
                        this.serviceLocator.getClinicoService().getAntecedentesUsuario(usuario.getHuslnumero());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }


        try {
            if (numeroConsulta != null) {
                lstAntecedentesGenerales = 
                        this.serviceLocator.getClinicoService().getAntecedentes(numeroConsulta);
                llenarAntecedentes();
               
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstAntecedentesGenerales == null || 
            lstAntecedentesGenerales.isEmpty()) {
            lstAntecedentesGenerales = new ArrayList<Chantecegene>();
        } else {
            Chantecegene antecedenteSelect;
            antecedenteSelect = lstAntecedentesGenerales.get(0);
            if (antecedenteSelect != null) {
                if (antecedenteSelect.getHanntipoante() != null && 
                    antecedenteSelect.getHanntipoante().equals(IConstantes.CODIGO_ANTECEDENTE_NIEGA)) {
                    mostrarAntecedentes = false;
                    nuevosAntecedentes = "N";
                    lstAntecedentesGenerales = new ArrayList<Chantecegene>();
                } else {
                    mostrarAntecedentes = true;
                    nuevosAntecedentes = "S";
                }
            }
        }
     
        

    }
    public String llenarAntecedentes(){
        Chconsulta aux;
        try {
            aux = this.serviceLocator.getHistoriaService().getConsultaAntecedentes(numeroConsulta);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        Iterator it ;
        if(aux!=null){
            if(aux.getChantox()!=null){
                it = aux.getChantox().iterator();
                while(it.hasNext())
                toxicos = (Chantox)it.next();
            }
            else{
                toxicos = new Chantox();
            }
            if(aux.getChantalerg()!=null){
                it = aux.getChantalerg().iterator();
                while(it.hasNext())
                alergicos = (Chantalerg)it.next();
            }
            else{
                alergicos = new Chantalerg();
            }
            if(aux.getChantfami()!=null){
                it = aux.getChantfami().iterator();
                while(it.hasNext())
                familiares = (Chantfami)it.next();
            }
            else{
                familiares = new Chantfami();
            }
            if(aux.getChantquir()!=null){
                it = aux.getChantquir().iterator();
                while(it.hasNext())
                quirurgicos = (Chantquir)it.next();
            }
            else{
                quirurgicos = new Chantquir();
            }
            if(aux.getChantpatol()!=null){
                it = aux.getChantpatol().iterator();
                while(it.hasNext())
                patologicos = (Chantpatol)it.next();
            }
            else{
                patologicos = new Chantpatol();
            }
            if(aux.getChantfarma()!=null){
                it = aux.getChantfarma().iterator();
                while(it.hasNext())
                farmacologicos = (Chantfarma)it.next();
            }
            else{
                 farmacologicos = new Chantfarma();
            }
            if(aux.getChanttrauma()!=null){
                it = aux.getChanttrauma().iterator();
                while(it.hasNext())
                traumacologicos = (Chanttrauma)it.next();
            }
            else{
                 traumacologicos = new Chanttrauma();
            }
            if(aux.getChantit()!=null){
                it = aux.getChantit().iterator();
                while(it.hasNext())
                its = (Chantit)it.next();
            }
            else{
                 its = new Chantit();
            }
            if(aux.getChanttrans()!=null){
                it = aux.getChanttrans().iterator();
                while(it.hasNext())
                transfusionales = (Chanttrans)it.next();
            }
            else{
                 transfusionales = new Chanttrans();
            }
            
        // se comprueba si alguno de los antecedentes est� nulo para iniciar todos
        if(patologicos ==null){
            iniciarAntecedentes();
        }
        }
        else{
          iniciarAntecedentes();
        }
        changeAlergicos();
        changeAlergicosChkbox();
        changeFamiliares();
        changeFarmacologicos();
        changeIts();
        changePatologia();
        changeQuirurgicos();
        changeToxicos();
        changeTransfusionales();
        changeTraumaticos();
    return null;
    }
    public void iniciarAntecedentes(){
        toxicos = new Chantox();
        familiares = new Chantfami();
        alergicos = new Chantalerg();
        farmacologicos = new Chantfarma();
        its = new Chantit();
        transfusionales = new Chanttrans();
        patologicos = new Chantpatol();
        quirurgicos = new Chantquir();
        traumacologicos = new Chanttrauma();
    }

    public void changePatologia() {
        renderPatologicos = false;
        if (("S").equals(patologicos.getHagcrefiere())) {
            renderPatologicos = true;
        }
        else{
            patologicos.setHagcdescri(null);
        }
       
    }
    public void changeQuirurgicos() {
        renderQuirurgicos = false;
        if (("S").equals(quirurgicos.getHanqcrefiere())) {
            renderQuirurgicos = true;
        }
        else{
            quirurgicos.setHanqcdesc(null);
        }
       
    }
    
    public void changeToxicos() {
        renderToxicos = false;
        if (("S").equals(toxicos.getHantcrefiere())) {
            renderToxicos = true;
        }
        else{
          
            toxicos.setHantcdesc(null);
        }
       
    }
    public void changeAlergicos() {
        renderAlergicos = false;
        if (("S").equals(alergicos.getHanacrefiere())) {
            renderAlergicos = true;
        }
        else{
     
            alergicos.setHanacdesc(null);
            alergicos.setHanacalichk(null);
            alergicos.setHanacotrachk(null);
            alergicos.setHanacmedchk(null);
            alergicos.setHanacmedcual(null);
            alergicos.setHanacpicadchk(null);
            alergicos.setHanacpicadcual(null);
            alergicos.setHanacsusambchk(null);
            alergicos.setHanacsusambcual(null);
            alergicos.setHanacsuspielchk(null);
            alergicos.setHanacsuspielcual(null);
            alergicos.setHanacalicual(null);
            alergicos.setHanacotracual(null);
            renderAlergicosChkbox1 = false;
            renderAlergicosChkbox2 = false;
            renderAlergicosChkbox3 = false;
            renderAlergicosChkbox4 = false;
            renderAlergicosChkbox5 = false;
            renderAlergicosChkbox6 = false;
            
        }
       
    }
    public void changeFamiliares() {
        renderFamiliares = false;
        if (("S").equals(familiares.getHanfcrefiere())) {
            renderFamiliares = true;
        }
        else{
            
            familiares.setHanfcdesc(null);
        }
       
    }
    public void changeTransfusionales() {
        renderTransfusionales = false;
        if (("S").equals(transfusionales.getHantcrefiere())) {
            renderTransfusionales = true;
        }
        else{
      
          
            transfusionales.setHantcdesc(null);
        }
       
    }
    public void changeFarmacologicos() {
        renderFarmacologicos = false;
        if (("S").equals(farmacologicos.getHanfcrefiere())) {
            renderFarmacologicos = true;
        }
        else{
      
            farmacologicos.setHanfcdesc(null);
        }      
    }
    public void changeIts() {
        renderITS = false;
        if (("S").equals(its.getHanicrefiere())) {
            renderITS = true;
        }
        else{
     
            its.setHanicdesc(null);
        }      
    }
    public void changeTraumaticos() {
        renderTraumaticos = false;
        if (("S").equals(traumacologicos.getHantcrefiere())) {
            renderTraumaticos = true;
        }
        else{        
            traumacologicos.setHantcdesc(null);
        }      
    }
    public void alergicosChkbox(){
        alergicos.setHanacmedchk("N");
        alergicos.setHanacalichk("N");
        alergicos.setHanacotrachk("N");
        alergicos.setHanacsusambchk("N");
        alergicos.setHanacsuspielchk("N");
        alergicos.setHanacpicadchk("N");
        if(renderAlergicosChkbox1){
            alergicos.setHanacalichk("S");
        }
        if(renderAlergicosChkbox2){
            alergicos.setHanacmedchk("S");
        }
        if(renderAlergicosChkbox3){
            alergicos.setHanacotrachk("S");
        }
        if(renderAlergicosChkbox4){
            alergicos.setHanacpicadchk("S");
        }
        if(renderAlergicosChkbox5){
            alergicos.setHanacsusambchk("S");
        }
        if(renderAlergicosChkbox6){
            alergicos.setHanacsuspielchk("S");
        }

    }
    public void changeAlergicosChkbox(){
        renderAlergicosChkbox1 = false;
        renderAlergicosChkbox2 = false;
        renderAlergicosChkbox3 = false;
        renderAlergicosChkbox4 = false;
        renderAlergicosChkbox5 = false;
        renderAlergicosChkbox6 = false;
        if ("S".equals(alergicos.getHanacalichk())){
            renderAlergicosChkbox1 = true;
        }
        else{
            alergicos.setHanacalicual(null);
        }
        if ("S".equals(alergicos.getHanacmedchk())){
            renderAlergicosChkbox2 = true;
        }
        else{
            alergicos.setHanacmedcual(null);
        }
        if ("S".equals(alergicos.getHanacotrachk())){
            renderAlergicosChkbox3 = true;
        }
        else{
            alergicos.setHanacotracual(null);
        }
        if ("S".equals(alergicos.getHanacpicadchk())){
            renderAlergicosChkbox4 = true;
        }
        else{
            alergicos.setHanacpicadcual(null);
        }
        if ("S".equals(alergicos.getHanacsusambchk())){
            renderAlergicosChkbox5 = true;
        }
        else{
            alergicos.setHanacsusambcual(null);
        }
        if ("S".equals(alergicos.getHanacsuspielchk())){
            renderAlergicosChkbox6 = true;
        }
        else{
            alergicos.setHanacsuspielcual(null);
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
                if (tipoHistoria == 26) {
                    for (int a = 0; a < lstAntecedentes.size(); a++) {
                        if (lstAntecedentes.get(a).getValue().toString().equals("99"))
                            lstAntecedentes.remove(lstAntecedentes.get(a));
                    }
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
    public void inicializarChkBoxes(){
    chkboxAlergicos = new ArrayList<String>();

        if ("S".equals(alergicos.getHanacalichk())){
            chkboxAlergicos.add("ALI");
        }
        if ("S".equals(alergicos.getHanacmedchk())){
            chkboxAlergicos.add("MED");
        }
        if ("S".equals(alergicos.getHanacotrachk())){
            chkboxAlergicos.add("OTR");
        }
        if ("S".equals(alergicos.getHanacpicadchk())){
            chkboxAlergicos.add("PIC");
        }
        if ("S".equals(alergicos.getHanacsusambchk())){
            chkboxAlergicos.add("SAM");
        }
        if ("S".equals(alergicos.getHanacsuspielchk())){
            chkboxAlergicos.add("SPI");
        }
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
     * @param valueChangeEvent
     */
    public void setNuevosAntecedentes(ValueChangeEvent valueChangeEvent) {
        setNuevosAntecedentes((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
            if (anteced.getHanntipoante().equals(new Integer(28))) {
                renderMensajeAnteToxico = true;
            } else {
                renderMensajeAnteToxico = false;
            }
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
        if (antecedenteClone.getHanntipoante().equals(new Integer(28))) {
            renderMensajeAnteToxico = false;
        }
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
        List<Chantecegene> lstAntecedentesGeneralesAux = null;

        boolean esValido = false;

        try {
            if (numeroConsulta != null) {
                lstAntecedentesGeneralesAux = 
                        this.serviceLocator.getClinicoService().getAntecedentes(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstAntecedentesGeneralesAux != null && 
            !lstAntecedentesGeneralesAux.isEmpty()) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public void changeAntecedentes() {
        if (nuevosAntecedentes.equals("S")) {
            mostrarAntecedentes = true;
        } else {
            lstAntecedentesGenerales = new ArrayList<Chantecegene>();
            mostrarAntecedentes = false;
            iniciarAntecedentes();
            changeAlergicos();
            changeAlergicosChkbox();
            changeFamiliares();
            changeFarmacologicos();
            changeIts();
            changePatologia();
            changeQuirurgicos();
            changeToxicos();
            changeTransfusionales();
            changeTraumaticos();
        }
    }
    public void changeTodosSi(){
        inicializarPregunta("S");
    }
    public void changeTodosNo(){
        inicializarPregunta("N");
    }
    public void changeNinguno(){
        inicializarPregunta(null);
    }
    public void inicializarPregunta(String opcion){
        if(opcion == null){
            iniciarAntecedentes();
          
        }
        else if(opcion.equals("S")){
            alergicos.setHanacrefiere("S");
            familiares.setHanfcrefiere("S");
            toxicos.setHantcrefiere("S");
            traumacologicos.setHantcrefiere("S");
            transfusionales.setHantcrefiere("S");
            farmacologicos.setHanfcrefiere("S");
            patologicos.setHagcrefiere("S");
            quirurgicos.setHanqcrefiere("S");
            its.setHanicrefiere("S");
            
        }
        else{
            alergicos.setHanacrefiere("N");
            familiares.setHanfcrefiere("N");
            toxicos.setHantcrefiere("N");
            traumacologicos.setHantcrefiere("N");
            transfusionales.setHantcrefiere("N");
            farmacologicos.setHanfcrefiere("N");
            patologicos.setHagcrefiere("N");
            quirurgicos.setHanqcrefiere("N");
            its.setHanicrefiere("N"); 
        }
        changeAlergicos();
        changeAlergicosChkbox();
        changeFamiliares();
        changeFarmacologicos();
        changeIts();
        changePatologia();
        changeQuirurgicos();
        changeToxicos();
        changeTransfusionales();
        changeTraumaticos();

    }


    public String aceptar() {
        navigationRule = "";
        if (usuario != null && usuario.getHusesexo() != null) {
            sexo = usuario.getHusesexo();
        }

        lstAntecedentesGenerales.clear();
        Chantecegene antecedenteAux = new Chantecegene();
        antecedenteAux.setHancnomtipante("");
        antecedenteAux.setHancoperador(userName());
        antecedenteAux.setHanntipoante(IConstantes.CODIGO_ANTECEDENTE_NIEGA);
        antecedenteAux.setHantdescripcio(IConstantes.ANTECEDENTE_NIEGA_DESCRIPCION);
        antecedenteAux.setHancreacvac(reaccionVacuna);
        antecedenteAux.setHancreacvacdesc(obsVacuna);
        if (!mostrarAntecedentes) {
            antecedenteAux.setHanntipoante(IConstantes.CODIGO_ANTECEDENTE_NIEGA);
            antecedenteAux.setHantdescripcio(IConstantes.ANTECEDENTE_NIEGA_DESCRIPCION);          
        }
        else{
            antecedenteAux.setHanntipoante(IConstantes.CODIGO_ANTECEDENTE_NUEVOS_ANTECEDENTES);
            antecedenteAux.setHantdescripcio(IConstantes.ANTECEDENTE_TIENE_DESCRIPCION);
        }
        lstAntecedentesGenerales.add(antecedenteAux);
        /*if (lstAntecedentesGenerales != null && 
            !lstAntecedentesGenerales.isEmpty()) {
            try {
                this.getServiceLocator().getClinicoService().saveAntecedentes(lstAntecedentesGenerales, 
                                                                              numeroConsulta);
            
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
*/
    try{
        this.getServiceLocator().getClinicoService().saveAntecedentes(lstAntecedentesGenerales, 
                                                                      numeroConsulta);
        if(mostrarAntecedentes){// se comprueba que si tiene antecedentes nuevos
            llenarDatosRestantes();
        this.getServiceLocator().getHistoriaService().saveAntecedentesGenerales(toxicos,alergicos,farmacologicos,its,transfusionales
        ,familiares,patologicos,quirurgicos,traumacologicos);
        }
        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
        FacesUtils.resetManagedBean(menuBean);
        navigationRule = nextAction;
    }catch(Exception e){       
        return capturaError(e,IConstantes.ERROR_GUARDADO);
    }
        return navigationRule;

    }
    
    public void llenarDatosRestantes(){
        familiares.setHanfcusuareg(userName());
        familiares.setHanfdfecreg(new Date());
        familiares.setHanfnconsulta(numeroConsulta);
        
        alergicos.setHanacusuareg(userName());
        alergicos.setHanadfecreg(new Date());
        alergicos.setHananconsulta(numeroConsulta);
        
        transfusionales.setHantcusuareg(userName());
        transfusionales.setHantdfecreg(new Date());
        transfusionales.setHantnconsulta(numeroConsulta);
        
        its.setHanicusuareg(userName());
        its.setHanidfecreg(new Date());
        its.setHaninconsulta(numeroConsulta);
        
        traumacologicos.setHantcusuareg(userName());
        traumacologicos.setHantdfecreg(new Date());
        traumacologicos.setHantnconsulta(numeroConsulta);
        
        toxicos.setHantcusuareg(userName());
        toxicos.setHantdfecreg(new Date());
        toxicos.setHantnconsulta(numeroConsulta);
        
        patologicos.setHagcusuareg(userName());
        patologicos.setHagnconsulta(numeroConsulta);
        patologicos.setHagdfecreg(new Date());
        
        
        quirurgicos.setHanqcusuareg(userName());
        quirurgicos.setHanqdfecreg(new Date());
        quirurgicos.setHanqnconsulta(numeroConsulta);
        
        farmacologicos.setHanfnconsulta(numeroConsulta);
        farmacologicos.setHanfdfecreg(new Date());
        farmacologicos.setHanfcusuareg(userName());
        
    }

    public void setReaccionVacuna(String reaccionVacuna) {
        this.reaccionVacuna = reaccionVacuna;
    }

    public String getReaccionVacuna() {
        return reaccionVacuna;
    }

    public void setObsVacuna(String obsVacuna) {
        this.obsVacuna = obsVacuna;
    }

    public String getObsVacuna() {
        return obsVacuna;
    }


    public void setHancreacvac(ValueChangeEvent valueChangeEvent) {
        setReaccionVacuna((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setEsVacunacion(boolean esVacunacion) {
        this.esVacunacion = esVacunacion;
    }

    public boolean isEsVacunacion() {
        return esVacunacion;
    }

    public void changeReacciones() {
        renderReacciones = false;
        if (reaccionVacuna != null) {
            if (reaccionVacuna != null && reaccionVacuna.equals("S")) {
                renderReacciones = true;
            }
        }

    }

    public void setRenderReacciones(boolean renderReacciones) {
        this.renderReacciones = renderReacciones;
    }

    public boolean isRenderReacciones() {
        return renderReacciones;
    }

    public void setMensajeAnteToxico(String mensajeAnteToxico) {
        this.mensajeAnteToxico = mensajeAnteToxico;
    }

    public String getMensajeAnteToxico() {
        return mensajeAnteToxico;
    }

    public void setRenderMensajeAnteToxico(boolean renderMensajeAnteToxico) {
        this.renderMensajeAnteToxico = renderMensajeAnteToxico;
    }

    public boolean isRenderMensajeAnteToxico() {
        return renderMensajeAnteToxico;
    }

    public void setRenderPrenatal(boolean renderPrenatal) {
        this.renderPrenatal = renderPrenatal;
    }

    public boolean isRenderPrenatal() {
        return renderPrenatal;
    }

    public void setToxicos(Chantox toxicos) {
        this.toxicos = toxicos;
    }

    public Chantox getToxicos() {
        return toxicos;
    }

    public void setFamiliares(Chantfami familiares) {
        this.familiares = familiares;
    }

    public Chantfami getFamiliares() {
        return familiares;
    }

    public void setAlergicos(Chantalerg alergicos) {
        this.alergicos = alergicos;
    }

    public Chantalerg getAlergicos() {
        return alergicos;
    }

    public void setFarmacologicos(Chantfarma farmacologicos) {
        this.farmacologicos = farmacologicos;
    }

    public Chantfarma getFarmacologicos() {
        return farmacologicos;
    }

    public void setIts(Chantit its) {
        this.its = its;
    }

    public Chantit getIts() {
        return its;
    }

    public void setTransfusionales(Chanttrans transfusionales) {
        this.transfusionales = transfusionales;
    }

    public Chanttrans getTransfusionales() {
        return transfusionales;
    }

    public void setPatologicos(Chantpatol patologicos) {
        this.patologicos = patologicos;
    }

    public Chantpatol getPatologicos() {
        return patologicos;
    }

    public void setQuirurgicos(Chantquir quirurgicos) {
        this.quirurgicos = quirurgicos;
    }

    public Chantquir getQuirurgicos() {
        return quirurgicos;
    }

    public void setTraumacologicos(Chanttrauma traumacologicos) {
        this.traumacologicos = traumacologicos;
    }

    public Chanttrauma getTraumacologicos() {
        return traumacologicos;
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

    public void setRenderPatologicos(boolean renderPatologicos) {
        this.renderPatologicos = renderPatologicos;
    }

    public boolean isRenderPatologicos() {
        return renderPatologicos;
    }

    public void setRenderQuirurgicos(boolean renderQuirurgicos) {
        this.renderQuirurgicos = renderQuirurgicos;
    }

    public boolean isRenderQuirurgicos() {
        return renderQuirurgicos;
    }

    public void setRenderToxicos(boolean renderToxicos) {
        this.renderToxicos = renderToxicos;
    }

    public boolean isRenderToxicos() {
        return renderToxicos;
    }

    public void setRenderAlergicos(boolean renderAlergicos) {
        this.renderAlergicos = renderAlergicos;
    }

    public boolean isRenderAlergicos() {
        return renderAlergicos;
    }

    public void setRenderFamiliares(boolean renderFamiliares) {
        this.renderFamiliares = renderFamiliares;
    }

    public boolean isRenderFamiliares() {
        return renderFamiliares;
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

    public void setRenderTraumaticos(boolean renderTraumaticos) {
        this.renderTraumaticos = renderTraumaticos;
    }

    public boolean isRenderTraumaticos() {
        return renderTraumaticos;
    }

    public void setChkboxAlergicos(List<String> chkboxAlergicos) {
        this.chkboxAlergicos = chkboxAlergicos;
    }

    public List<String> getChkboxAlergicos() {
        return chkboxAlergicos;
    }

    public void setLstAlergicos(List<SelectItem> lstAlergicos) {
        this.lstAlergicos = lstAlergicos;
    }

    public List<SelectItem> getLstAlergicos() {
    if(lstAlergicos == null || lstAlergicos.isEmpty()){
        lstAlergicos = new ArrayList<SelectItem>();
        lstAlergicos.add(new SelectItem("MED","Medicamento"));
        lstAlergicos.add(new SelectItem("ALI","Alimento"));
        lstAlergicos.add(new SelectItem("SAM","Sustancia del ambiente"));
        lstAlergicos.add(new SelectItem("SPI","Sustancia que entra en contacto con la piel"));
        lstAlergicos.add(new SelectItem("PDI","Picadura de insecto "));
        lstAlergicos.add(new SelectItem("OTR","Otra"));
    }
        return lstAlergicos;
    }

    public void setRenderAlergicosChkbox1(boolean renderAlergicosChkbox1) {
        this.renderAlergicosChkbox1 = renderAlergicosChkbox1;
    }

    public boolean isRenderAlergicosChkbox1() {
        return renderAlergicosChkbox1;
    }

    public void setRenderAlergicosChkbox2(boolean renderAlergicosChkbox2) {
        this.renderAlergicosChkbox2 = renderAlergicosChkbox2;
    }

    public boolean isRenderAlergicosChkbox2() {
        return renderAlergicosChkbox2;
    }

    public void setRenderAlergicosChkbox3(boolean renderAlergicosChkbox3) {
        this.renderAlergicosChkbox3 = renderAlergicosChkbox3;
    }

    public boolean isRenderAlergicosChkbox3() {
        return renderAlergicosChkbox3;
    }

    public void setRenderAlergicosChkbox4(boolean renderAlergicosChkbox4) {
        this.renderAlergicosChkbox4 = renderAlergicosChkbox4;
    }

    public boolean isRenderAlergicosChkbox4() {
        return renderAlergicosChkbox4;
    }

    public void setRenderAlergicosChkbox5(boolean renderAlergicosChkbox5) {
        this.renderAlergicosChkbox5 = renderAlergicosChkbox5;
    }

    public boolean isRenderAlergicosChkbox5() {
        return renderAlergicosChkbox5;
    }

    public void setRenderAlergicosChkbox6(boolean renderAlergicosChkbox6) {
        this.renderAlergicosChkbox6 = renderAlergicosChkbox6;
    }

    public boolean isRenderAlergicosChkbox6() {
        return renderAlergicosChkbox6;
    }
}
