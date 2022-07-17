//=======================================================================
// ARCHIVO VademecumMedicoBean.java
// FECHA CREACI�N: 31/01/2017
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la conducta de formula medica.
//=======================================================================
package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorVademecumBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.ConverterTextoNumero;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE FormulaMedicaUsuarioBean
//=======================================================================

public class VademecumMedicoBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private int index = -1;

    private boolean generoFormula;


    private Chvademprof vademecum;


    /** Almacena la tabla de la formulaci�n */
    private HtmlDataTable dtFormula;

    /**Almacena la lista de prescripci�n  */
    private List<Chformulamed> lstPrescripciones;


    /**Almacena la lista de prescripci�n  */
    private List<Chformulamed> lstPrescripcionesDefecto;

    /** Almacena la lista de Medicamentos a Imprimir*/
    private List<Chformulamed> lstPrescripcionesImprimir;

    /** Almacena la formula que se desea eliminar de la base de datos */
    private Chformulamed formulaClon;

    /** Almacena true si es modo consulta*/
    private boolean modoConsulta;

    /** */
    private boolean deshabilitarMedicamento;

    private Integer tipoHistoria;


    private Integer consecutivo;

    private boolean renderDescripcion;

    private boolean esCirugia;
    
    private boolean renderAlertaIve; 

    String NOMBRES;

    String APELLIDOS;

    String TIPO_DOCUMENTO;

    Long NUMERO_DOCUMENTO;

    String DIAGNOSTICO_PRINCIPAL;
    String DIAGNOSTICO_SECUNDARIO;

    String CODIGO_CIE10;

    String TIPO_USUARIO;

    String ANO;

    String MES;

    String DIA;

    Date fecha;

    String CONTRAINDICACIONES = "";

    String NOMBRE_PROFESIONAL;
    
    String TIPOID_PROFESIONAL;
      
    BigDecimal NUMID_PROFESIONAL;

    String REGISTRO_MEDICO;
    
    String ESPECIALIDAD;

    String CONCILIAMEDICA = "";


    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String tipoServicio;

    private String menuBean;

    private boolean renderBuscador;

    private int selectedIndex;

    private static final int ACTIVAR_FORMULA_MEDICA = 0;

    private static final int ACTIVAR_BUSCADOR = 1;

    private Long numeroConsulta;

    private String codigoCIE10;

    private List lstOpciones;

    /** Almacena el detalle de la descripcion quirurgica */
    private Chdetaldescr detaldescr;

    private boolean ligadura;

    private List lstUnidadMedida;

    private List lstFormaFarmaceutica;

    private List lstViaAdministracion;

    private List lstFrecuencia;

    private String conciliacionMedicamentosa = null;

    /** Lista que almacena la lista de opciones */
    private List<SelectItem> listOpciones;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------    

    public VademecumMedicoBean() {
    }


    public void init() {
        modoConsulta = false;
        vademecum = new Chvademprof();
        inicializardFormulaMedica();

    }

    public void inicializardFormulaMedica() {

        generoFormula = false;

        renderDescripcion = false;

        try {

            if (numeroConsulta != null && tipoServicio != null && 
                consecutivo != null) {
                lstPrescripciones = 
                        this.serviceLocator.getClinicoService().getListPrescripciones(numeroConsulta, 
                                                                                      tipoServicio, 
                                                                                      consecutivo);
            }


        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstPrescripciones == null || lstPrescripciones.isEmpty()) {
            lstPrescripciones = new ArrayList<Chformulamed>();
            if (lstPrescripcionesDefecto != null && 
                !lstPrescripcionesDefecto.isEmpty()) {
                lstPrescripciones = lstPrescripcionesDefecto;
            }
        } else {
            modoConsulta = true;

            for (Chformulamed medaux: lstPrescripciones) {
                conciliacionMedicamentosa = medaux.getHfocconcimedic();
                medaux.setImprimir(true);
            }
        }

        if (lstPrescripciones == null || lstPrescripciones.isEmpty()) {
            lstPrescripciones = new ArrayList<Chformulamed>();


        }
    }


    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


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

    public void setDetaldescr(Chdetaldescr detaldescr) {
        this.detaldescr = detaldescr;
    }

    public Chdetaldescr getDetaldescr() {
        return detaldescr;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public void setRenderDescripcion(boolean renderDescripcion) {
        this.renderDescripcion = renderDescripcion;
    }

    public boolean isRenderDescripcion() {
        return renderDescripcion;
    }

    public void setVademecum(Chvademprof vademecum) {
        this.vademecum = vademecum;
    }

    public Chvademprof getVademecum() {
        return vademecum;
    }

    /**
     * @param generoFormula
     */
    public void setGeneroFormula(boolean generoFormula) {
        this.generoFormula = generoFormula;
    }

    /**
     * @return
     */
    public boolean isGeneroFormula() {
        return generoFormula;
    }


    /**
     * @param codigoCIE10
     */
    public void setCodigoCIE10(String codigoCIE10) {
        this.codigoCIE10 = codigoCIE10;
    }

    /**
     * @return
     */
    public String getCodigoCIE10() {
        return codigoCIE10;
    }


    /**
     * @param dtFormula
     */
    public void setDtFormula(HtmlDataTable dtFormula) {
        this.dtFormula = dtFormula;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFormula() {
        return dtFormula;
    }


    /**
     * @param lstPrescripciones
     */
    public void setLstPrescripciones(List<Chformulamed> lstPrescripciones) {
        this.lstPrescripciones = lstPrescripciones;
    }

    /**
     * @return
     */
    public List<Chformulamed> getLstPrescripciones() {
        return lstPrescripciones;
    }

    /**
     * @param modoConsulta
     */
    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    /**
     * @return
     */
    public boolean isModoConsulta() {
        return modoConsulta;
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
     * @param esCirugia
     */
    public void setEsCirugia(boolean esCirugia) {
        this.esCirugia = esCirugia;
    }

    /**
     * @return
     */
    public boolean isEsCirugia() {
        return esCirugia;
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
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param deshabilitarMedicamento
     */
    public void setDeshabilitarMedicamento(boolean deshabilitarMedicamento) {
        this.deshabilitarMedicamento = deshabilitarMedicamento;
    }

    /**
     * @return
     */
    public boolean isDeshabilitarMedicamento() {
        return deshabilitarMedicamento;
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

    /**
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
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
     * @param lstPrescripcionesDefecto
     */
    public void setLstPrescripcionesDefecto(List<Chformulamed> lstPrescripcionesDefecto) {
        this.lstPrescripcionesDefecto = lstPrescripcionesDefecto;
    }

    /**
     * @return
     */
    public List<Chformulamed> getLstPrescripcionesDefecto() {
        return lstPrescripcionesDefecto;
    }


    //--------------------------------------------------------------------------
    //  Metodo esValido que garantiza que el registro fue guardado exitosamente
    //--------------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {

        boolean esValido = false;
        List<Chformulamed> lstPrescripcionesAux = null;
        if (numeroConsulta != null) {
            try {
                lstPrescripcionesAux = 
                        this.serviceLocator.getClinicoService().getListPrescripciones(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstPrescripcionesAux == null || 
                lstPrescripcionesAux.isEmpty()) {
                esValido = false;
            } else {
                esValido = true;
            }

        }
        return esValido;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------   

    public void renderMedicamentos() {
        renderBuscador = true;
        FacesUtils.resetManagedBean("buscadorVademecumBean");
        selectedIndex = ACTIVAR_BUSCADOR;
    }


    public void agregarPrescripcion() {
        Chformulamed formula;
        generoFormula = false;
        formula = new Chformulamed();
        Integer codisap = null;
        if (vademecum.getHvpccodisap() != null) {
            codisap = codisap.parseInt(vademecum.getHvpccodisap());
        }
        if (vademecum != null && vademecum.getHvpcprincactiv() != null) {
            formula.setImprimir(true);
            formula.setHfocadosis(vademecum.getHvpncantidad());
            formula.setHfocmedicament(vademecum.getHvpcprincactiv());
            formula.setHfoctratramien(vademecum.getHvpctratamiento());
            formula.setHfocviadministr(vademecum.getHvpcviaadmo());
            formula.setHfoccontraindi(vademecum.getHvpccontrindic());
            formula.setHfodfecregistr(new Date());
            formula.setHfocoperador(userName());
            formula.setHfocfrecuenc(vademecum.getHvpcfrecuencia());
            formula.setHfonfrecuenc(vademecum.getHvpnfrecuencia());
            formula.setHfocduracion(vademecum.getHvpcduracion());
            formula.setHfonduracion(vademecum.getHvpnduracion());
            formula.setHfocconcentr(vademecum.getHvpcconcentrac());
            formula.setHfocunidmedi(vademecum.getHvpcunidmedi());
            formula.setHfocformafarma(vademecum.getHvpcformafarma());
            formula.setHfoccontraindi(vademecum.getHvpcobservaci());
            formula.setHfoccodiatc(vademecum.getHvpccodigatc());
            formula.setHfoccodicum(vademecum.getHvpccodicum());
            formula.setHfoccodisap(vademecum.getHvpccodisap());
            formula.setHfocdescform(vademecum.getHvpcdialforma());
            formula.setHfocalerta(vademecum.getHvpcalerta());

            if (codisap != null && codisap.intValue() > 1000) {
                formula.setHfocventmostra("SI");
            } else {

                formula.setHfocventmostra("NO");
            }

            lstPrescripciones.add(formula);

            vademecum = new Chvademprof();
            renderDescripcion = false;
            deshabilitarMedicamento = false;
        } else {
            FacesUtils.addErrorMessage("Debe Registrar todos los datos");
        }
    }

    public void eliminarFormula() {
        this.formulaClon = (Chformulamed)this.dtFormula.getRowData();
        this.lstPrescripciones.remove(formulaClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }

    public void editarFormula() {
        this.formulaClon = (Chformulamed)this.dtFormula.getRowData();
        vademecum = new Chvademprof();
        vademecum.setHvpncantidad(formulaClon.getHfocadosis());
        vademecum.setHvpcprincactiv(formulaClon.getHfocmedicament());
        vademecum.setHvpcviaadmo(formulaClon.getHfocviadministr());
        vademecum.setHvpccontrindic(formulaClon.getHfoccontraindi());
        vademecum.setHvpdfecharegis(formulaClon.getHfodfecregistr());
        vademecum.setHvpcoperador(formulaClon.getHfocoperador());
        vademecum.setHvpcfrecuencia(formulaClon.getHfocfrecuenc());
        vademecum.setHvpnfrecuencia(formulaClon.getHfonfrecuenc());
        vademecum.setHvpcduracion(formulaClon.getHfocduracion());
        vademecum.setHvpnduracion(formulaClon.getHfonduracion());
        vademecum.setHvpcconcentrac(formulaClon.getHfocconcentr());
        vademecum.setHvpcunidmedi(formulaClon.getHfocunidmedi());
        vademecum.setHvpcformafarma(formulaClon.getHfocformafarma());
        vademecum.setHvpcobservaci(formulaClon.getHfoccontraindi());
        vademecum.setHvpccodigatc(formulaClon.getHfoccodiatc());
        vademecum.setHvpccodicum(formulaClon.getHfoccodicum());
        vademecum.setHvpccodisap(formulaClon.getHfoccodisap());
        vademecum.setHvpcdialforma(formulaClon.getHfocdescform());
        vademecum.setHvpctratamiento(formulaClon.getHfoctratramien());

        deshabilitarMedicamento = false;
        this.lstPrescripciones.remove(formulaClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }

    public void aceptarMedicamento() {
        BuscadorVademecumBean medicamentoAux = 
            (BuscadorVademecumBean)FacesUtils.getManagedBean("buscadorVademecumBean");
            boolean encontro = false;
            String alertMife = ""; 

        renderDescripcion = false;
        if (medicamentoAux != null && 
            medicamentoAux.getMedicamentoSelect() != null) {


            consecutivo = 
                    medicamentoAux.getMedicamentoSelect().getHvpnconsecutiv();

            if (consecutivo != null && consecutivo.intValue() == 0) {
                renderDescripcion = true;
                vademecum.setHvpcprincactiv("");
                vademecum.setHvpcconcentrac(null);
                vademecum.setHvpcunidmedi(null);
                vademecum.setHvpcformafarma(null);
                vademecum.setHvpcviaadmo(null);
                vademecum.setHvpccodisap(null);
                vademecum.setHvpcalerta(null);

            } else {
                renderDescripcion = false;
                vademecum.setHvpcprincactiv(medicamentoAux.getMedicamentoSelect().getHvpcprincactiv());
                vademecum.setHvpcconcentrac(medicamentoAux.getMedicamentoSelect().getHvpcconcentrac());
                vademecum.setHvpcunidmedi(medicamentoAux.getMedicamentoSelect().getHvpcunidmedi());
                vademecum.setHvpcformafarma(medicamentoAux.getMedicamentoSelect().getHvpcformafarma());
                vademecum.setHvpcviaadmo(medicamentoAux.getMedicamentoSelect().getHvpcviaadmo());
                vademecum.setHvpccodisap(medicamentoAux.getMedicamentoSelect().getHvpccodisap());
                vademecum.setHvpcalerta(medicamentoAux.getMedicamentoSelect().getHvpcalerta());
                if(vademecum.getHvpcalerta() != null && !vademecum.getHvpcalerta().equals("") ){        
                 for(Chformulamed aux:lstPrescripciones){
                     String principioActivo = aux.getHfocmedicament();
                      if (principioActivo.toUpperCase().contains("MIFREPRIS") && !encontro){
                          encontro = true; 
                      }
                     
                 }
                
                    renderAlertaIve = true; 
                }
    
            }
            
          
            
            
            
            // Verificamos si adicionamois una MIFEPRISTONAsi ya existias alertas en los anteriores medicamentos
            
            
            if(medicamentoAux != null && medicamentoAux.getMedicamentoSelect() != null && medicamentoAux.getMedicamentoSelect().getHvpcprincactiv() != null ){
                
                    if(medicamentoAux.getMedicamentoSelect().getHvpcprincactiv().toUpperCase().contains("MIFREPRIS")){
                        encontro = true;
                        for(Chformulamed aux:lstPrescripciones){
                            if(aux.getHfocalerta() != null){
                                encontro = true;
                                renderAlertaIve = true;
                                alertMife =  alertMife + aux.getHfocmedicament() + ": " +aux.getHfocalerta() + "\n.";    
                            }
                            
                            vademecum.setHvpcalerta(alertMife);
                        }
                        
                    }
                
            }
            
            
            if(!encontro){
                renderAlertaIve = false; 
            }

            deshabilitarMedicamento = true;

        }
        selectedIndex = ACTIVAR_FORMULA_MEDICA;
        renderBuscador = false;
        FacesUtils.resetManagedBean("buscadorMedicamentoBean");
    }


    //-----------------------------------------------------------------------
    //  Construir Reporte
    //-----------------------------------------------------------------------

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();


        Chformulamed formulaAux = lstPrescripcionesImprimir.get(index);


        if (fieldName.equals("APELLIDOS")) {
            value = APELLIDOS;
            return value;
        }
        if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
            return value;
        }
        if (fieldName.equals("TIPO_USUARIO")) {
            value = TIPO_USUARIO;
            return value;
        }
        if (fieldName.equals("FECHA")) {
            value = "FECHA";
            return value;
        }
        if (fieldName.equals("DIA")) {
            value = DIA;
            return value;
        }
        if (fieldName.equals("MES")) {
            value = MES;
            return value;
        }
        if (fieldName.equals("ANO")) {
            value = ANO;
            return value;
        }
        if (fieldName.equals("CONCILIAMEDICA")) {
            if (CONCILIAMEDICA != null) {
                value = CONCILIAMEDICA;
            }
            return value;
        }
        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
            return value;
        }
        if (fieldName.equals("MEDICAMENTO")) {
            value = (index + 1) + obtenerNombreMedicamento(formulaAux);


            return value;
        }
        if (fieldName.equals("TRATAMIENTO")) {
            value = obtenerNombreTratamiento(formulaAux);


            return value;
        }
        if (fieldName.equals("VIA_ADMINISTRACION")) {
            value = 
                    formatearCampoViaAdministracion(lstPrescripcionesImprimir.get(index).getHfocviadministr());
            return value;
        }
        if (fieldName.equals("CANTIDAD_REQUERIDAD")) {
            value = 
                    calcularCantidad(this.lstPrescripcionesImprimir.get(index).getHfocadosis(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfonfrecuenc(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfonduracion(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfocfrecuenc(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfocduracion());

            return value;
        }
        if (fieldName.equals("CODIGO_CIE10")) {
            value = CODIGO_CIE10;
            return value;
        }

        if (fieldName.equals("CONTRAINDICACIONES")) {
            CONTRAINDICACIONES = "";
            if (lstPrescripcionesImprimir.get(index).getHfoccontraindi() != 
                null && 
                !lstPrescripcionesImprimir.get(index).getHfoccontraindi().equals("")) {
                CONTRAINDICACIONES = 
                        lstPrescripcionesImprimir.get(index).getHfoccontraindi();
            }
            value = CONTRAINDICACIONES;
            return value;
        }
        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("TIPOID_PROFESIONAL")) {
                   value = TIPOID_PROFESIONAL;
                   return value;
               }
               if (fieldName.equals("NUMID_PROFESIONAL")) {
                   value = NUMID_PROFESIONAL;
                   return value;
               }       

        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
            return value;
        }
        
        if (fieldName.equals("ESPECIALIDAD")) {
                value = ESPECIALIDAD;
                return value;
            }

        if (fieldName.equals("CANTIDAD_REQUERIDAD_LETRAS")) {
            int cantidadRequerida = 0;
            cantidadRequerida = 
                    calcularCantidad(this.lstPrescripcionesImprimir.get(index).getHfocadosis(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfonfrecuenc(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfonduracion(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfocfrecuenc(), 
                                     this.lstPrescripcionesImprimir.get(index).getHfocduracion());
            ConverterTextoNumero texto = new ConverterTextoNumero();
            value = texto.getStringOfNumber(cantidadRequerida);
            return value;
        }

        return null;

    }


    public void obtenerDatosReporteConsulta() {
        if (usuario != null) {
            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                APELLIDOS = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                APELLIDOS = APELLIDOS + usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHusetipoafilia() != null) {

                if (usuario.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuario.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuario.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuario.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuario.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuario.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }
            }
        }

        if (conciliacionMedicamentosa != null) {
            CONCILIAMEDICA = conciliacionMedicamentosa;
        }

        if (codigoCIE10 != null) {
            Crdgncie10 diagnosticoPrincipal = null;

            CODIGO_CIE10 = codigoCIE10.toUpperCase();

            try {
                diagnosticoPrincipal = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagnosticoPrincipal != null) {
                CODIGO_CIE10 = 
                        codigoCIE10 + " " + diagnosticoPrincipal.getCdccdescri();
            }

        }

        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer anoact = calendar.get(calendar.YEAR);

        if (diaact.compareTo(10) < 0) {
            DIA = "0" + diaact.toString();
        } else {
            DIA = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            MES = "0" + mesact.toString();
        } else {
            MES = mesact.toString();
        }

        ANO = anoact.toString();

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
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
            }


        }


        if (codigoCIE10 != null) {
            Crdgncie10 diagnosticoPrincipal = null;

            CODIGO_CIE10 = codigoCIE10.toUpperCase();

            try {
                diagnosticoPrincipal = 
                        this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (diagnosticoPrincipal != null) {
                CODIGO_CIE10 = 
                        codigoCIE10 + " " + diagnosticoPrincipal.getCdccdescri();
            }

        }


    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < lstPrescripcionesImprimir.size());
    }


    public void obtenerDatosReporteCirugia() {

        Chusuario usuarioAux;
        usuarioAux = null;
        CONTRAINDICACIONES = "";

        if (usuario != null) {

            usuarioAux = usuario;

        }


        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                NOMBRES = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuarioAux.getHuscsegundnomb();
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                APELLIDOS = usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                APELLIDOS = APELLIDOS + usuarioAux.getHuscsegundapel();
            }
            if (usuarioAux.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuarioAux.getHusetipoiden().toString();
            }
            if (usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }
            if (usuarioAux.getHusetipoafilia() != null) {

                if (usuarioAux.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuarioAux.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuarioAux.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuarioAux.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuarioAux.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuarioAux.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }


            }

        }

        if (numeroConsulta != null && !numeroConsulta.equals("")) {
            try {
                detaldescr = 
                        this.serviceLocator.getCirugiaService().getDetalleDescripcion(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (detaldescr != null && !detaldescr.equals("")) {
                CODIGO_CIE10 = detaldescr.getHddcdiagnprinc().toUpperCase();


            }

        }


        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer anoact = calendar.get(calendar.YEAR);

        if (diaact.compareTo(10) < 0) {
            DIA = "0" + diaact.toString();
        } else {
            DIA = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            MES = "0" + mesact.toString();
        } else {
            MES = mesact.toString();
        }

        ANO = anoact.toString();


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
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
            }


        }


    }


    /**
     * @param lstUnidadMedida
     */
    public void setLstUnidadMedida(List lstUnidadMedida) {
        this.lstUnidadMedida = lstUnidadMedida;
    }

    /**
     * @return
     */
    public List getLstUnidadMedida() {
        if (lstUnidadMedida == null || lstUnidadMedida.isEmpty()) {
            lstUnidadMedida = new ArrayList();
            lstUnidadMedida.add(new SelectItem("", ""));
            lstUnidadMedida.add(new SelectItem("g", "Gramo"));
            lstUnidadMedida.add(new SelectItem("G", "Gramo"));
            lstUnidadMedida.add(new SelectItem("G/L", "Gramo/Litro"));
            lstUnidadMedida.add(new SelectItem("g/mL", " Gramo X Mililitro"));
            lstUnidadMedida.add(new SelectItem("mcg", "Microgramo"));
            lstUnidadMedida.add(new SelectItem("mg", "Miligramo"));
            lstUnidadMedida.add(new SelectItem("mg/mL", 
                                               "Microgramo X Mililitro"));
            lstUnidadMedida.add(new SelectItem("MEQ/ML", "MEQ/ML"));
            lstUnidadMedida.add(new SelectItem("MG/MCG", "MG/MCG"));
            lstUnidadMedida.add(new SelectItem("mcg/ML", "mcg/ML"));
            lstUnidadMedida.add(new SelectItem("MCG", "MCG"));
            lstUnidadMedida.add(new SelectItem("MG-G", "MG-G"));
            lstUnidadMedida.add(new SelectItem("mL", "Mililitro"));
            lstUnidadMedida.add(new SelectItem("UI", "Unidad Internacional"));
            lstUnidadMedida.add(new SelectItem("UI/ML", 
                                               "Unidad Internacional/ Mililitro"));
            lstUnidadMedida.add(new SelectItem("%", "Porcentaje"));
            lstUnidadMedida.add(new SelectItem("_", "_"));

        }

        return lstUnidadMedida;
    }


    public void setLstFormaFarmaceutica(List lstFormaFarmaceutica) {
        this.lstFormaFarmaceutica = lstFormaFarmaceutica;
    }

    public List getLstFormaFarmaceutica() {
        if (lstFormaFarmaceutica == null || lstFormaFarmaceutica.isEmpty()) {
            lstFormaFarmaceutica = new ArrayList();
            lstFormaFarmaceutica.add(new SelectItem("", ""));
            lstFormaFarmaceutica.add(new SelectItem("AMPO", "Ampolla"));
            lstFormaFarmaceutica.add(new SelectItem("CAPS", "Capsulas"));
            lstFormaFarmaceutica.add(new SelectItem("CREM", "Crema"));
            lstFormaFarmaceutica.add(new SelectItem("DIU", "Diu"));
            lstFormaFarmaceutica.add(new SelectItem("EMUL", "Emulsiones"));
            lstFormaFarmaceutica.add(new SelectItem("FCO", "FRASCO"));
            lstFormaFarmaceutica.add(new SelectItem("GOTA", "Gota"));
            lstFormaFarmaceutica.add(new SelectItem("IMPL", "Implante"));
            lstFormaFarmaceutica.add(new SelectItem("INH", "Inhalable"));
            lstFormaFarmaceutica.add(new SelectItem("IMSU", 
                                                    "Implante Subdermico"));
            lstFormaFarmaceutica.add(new SelectItem("INTR", "Intrauterino"));
            lstFormaFarmaceutica.add(new SelectItem("INYE", "Inyectable"));
            lstFormaFarmaceutica.add(new SelectItem("JEPR", 
                                                    "Jeringa Prellena"));
            lstFormaFarmaceutica.add(new SelectItem("OVUL", "Ovulo"));
            lstFormaFarmaceutica.add(new SelectItem("POLV", "Polvo"));
            lstFormaFarmaceutica.add(new SelectItem("SOLU", 
                                                    "Solucion Liquida"));
            lstFormaFarmaceutica.add(new SelectItem("SUSP", "Suspensi�n"));
            lstFormaFarmaceutica.add(new SelectItem("TABL", "Tableta"));
            lstFormaFarmaceutica.add(new SelectItem("N/A", "No Aplica"));
        }

        return lstFormaFarmaceutica;
    }


    public void setLstViaAdministracion(List lstViaAdministracion) {
        this.lstViaAdministracion = lstViaAdministracion;
    }

    public List getLstViaAdministracion() {
        if (lstViaAdministracion == null || lstViaAdministracion.isEmpty()) {
            lstViaAdministracion = new ArrayList();
            lstViaAdministracion.add(new SelectItem("", ""));
            lstViaAdministracion.add(new SelectItem("IM", "Intramuscular"));
            lstViaAdministracion.add(new SelectItem("IV", "Intravenosa"));
            lstViaAdministracion.add(new SelectItem("VO", "Oral"));
            lstViaAdministracion.add(new SelectItem("VV", "Vaginal"));
            lstViaAdministracion.add(new SelectItem("VP", "Parenteral"));
            lstViaAdministracion.add(new SelectItem("VR", "Rectal"));
            lstViaAdministracion.add(new SelectItem("Vsc", "Subcutanea"));
            lstViaAdministracion.add(new SelectItem("Vsl", "Sublingual"));
            lstViaAdministracion.add(new SelectItem("Vn", "Nasal"));
            lstViaAdministracion.add(new SelectItem("Vt", "Topica"));
            lstViaAdministracion.add(new SelectItem("INH", "Inhalatoria"));
            lstViaAdministracion.add(new SelectItem("VOF", "Oftalmica"));
            lstViaAdministracion.add(new SelectItem("VOT", "Otica"));
            lstViaAdministracion.add(new SelectItem("VTO", "Topica"));
            lstViaAdministracion.add(new SelectItem("N/A", "No Aplica"));

        }

        return lstViaAdministracion;
    }


    public void setLstFrecuencia(List lstFrecuencia) {
        this.lstFrecuencia = lstFrecuencia;
    }

    public List getLstFrecuencia() {
        if (lstFrecuencia == null || lstUnidadMedida.isEmpty()) {
            lstFrecuencia = new ArrayList();
            lstFrecuencia.add(new SelectItem("", "--"));
            lstFrecuencia.add(new SelectItem("MI", "Minutos"));
            lstFrecuencia.add(new SelectItem("HO", "Horas"));
            lstFrecuencia.add(new SelectItem("DI", "Dias"));
            lstFrecuencia.add(new SelectItem("SE", "Semanal"));
            lstFrecuencia.add(new SelectItem("ME", "Mensual"));
            lstFrecuencia.add(new SelectItem("TR", "Trimestral"));
            lstFrecuencia.add(new SelectItem("UN", "Unica"));

        }
        return lstFrecuencia;
    }


    public void setConciliacionMedicamentosa(String conciliacionMedicamentosa) {
        this.conciliacionMedicamentosa = conciliacionMedicamentosa;
    }

    public String getConciliacionMedicamentosa() {
        return conciliacionMedicamentosa;
    }

    /**
     * @param listOpciones
     */
    public void setListOpciones(List<SelectItem> listOpciones) {
        this.listOpciones = listOpciones;
    }

    /**
     * @return
     */
    public List<SelectItem> getListOpciones() {
        if (listOpciones == null || listOpciones.isEmpty()) {
            listOpciones = new ArrayList<SelectItem>();
            listOpciones.add(new SelectItem("S", "SI"));
            listOpciones.add(new SelectItem("N", "NO"));
        }
        return listOpciones;
    }

    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------


    private void clearDatosFormula() {
        APELLIDOS = null;
        NOMBRES = null;
        TIPO_USUARIO = null;
        DIA = null;
        MES = null;
        ANO = null;
        NUMERO_DOCUMENTO = null;
        CODIGO_CIE10 = null;
        CONTRAINDICACIONES = null;
        NOMBRE_PROFESIONAL = null;
        REGISTRO_MEDICO = null;
        CONCILIAMEDICA = null;
    }

    /**
     * 
     */
    public void generarFormula() {
        if (conciliacionMedicamentosa == null) {
            FacesUtils.addErrorMessage("Debe seleccionar si realiz� conciliaci�n medicamentosa?");
        } else {
            this.index = -1;
            clearDatosFormula();
            CONTRAINDICACIONES = "";

            lstPrescripcionesImprimir = new ArrayList<Chformulamed>();


            if (lstPrescripciones.size() != 0) {

                for (Chformulamed medImp: lstPrescripciones) {
                    if (conciliacionMedicamentosa != null) {
                        medImp.setHfocconcimedic(conciliacionMedicamentosa);
                    }
                    if (medImp.isImprimir()) {
                        lstPrescripcionesImprimir.add(medImp);
                    }
                }

                if (!esCirugia) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }

                try {
                    try {
                        this.serviceLocator.getCirugiaService().saveListFormulaMedicaCirugia(lstPrescripciones, 
                                                                                             numeroConsulta, 
                                                                                             tipoServicio, 
                                                                                             consecutivo);
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    } catch (ModelException e) {
                        FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                        e.printStackTrace();
                    }


                    //                URL url = 
                    //                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/prescripcionVademecumMedica2.jasper");
                    URL url = 
                        FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO_GS_GC_CS_08_V01.jasper");
                    URL url_profamilia = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                    URL url_super_horizontal = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                    URL url_super_vertical = 
                        FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
                    if (url != null) {
                        Map parameters = new HashMap();
                        parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                        parameters.put("IMAGE_SUPER_HORIZONTAL", 
                                       url_super_horizontal);
                        parameters.put("IMAGE_SUPER_VERTICAL", 
                                       url_super_vertical);
                        byte[] bytes;

                        JasperReport report = 
                            (JasperReport)JRLoader.loadObject(url);

                        bytes = 
                                JasperRunManager.runReportToPdf(report, parameters, 
                                                                (JRDataSource)this);

                        PdfServletUtils.showPdfDocument(bytes, 
                                                        "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                        ".pdf", false);
                        generoFormula = true;
                        modoConsulta = true;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                               e.getMessage());
                }
            } else {
                FacesUtils.addErrorMessage(IMsg.MSG_VALIDACION_LISTA_VACIA_PRESCRIPCION);
            }
        }
    }

    public void confirmaConciliacion() {
    }

    public void setConciliacionMedicamentosa(ValueChangeEvent valueChangeEvent) {
        setConciliacionMedicamentosa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderAlertaIve(boolean renderAlertaIve) {
        this.renderAlertaIve = renderAlertaIve;
    }

    public boolean isRenderAlertaIve() {
        return renderAlertaIve;
    }
}

