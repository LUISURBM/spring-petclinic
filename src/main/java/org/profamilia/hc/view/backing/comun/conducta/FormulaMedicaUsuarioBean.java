//=======================================================================
// ARCHIVO FormulaMedicaUsuarioBean.java
// FECHA CREACI�N: 11/06/2010
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
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorMedicamentoBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE FormulaMedicaUsuarioBean
//=======================================================================

public class FormulaMedicaUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private int index = -1;

    private boolean generoFormula;

    /** Variable que almacena el Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica */
    private String medicamento;

    /** Variable que almacena las contraindicaciones y/o observaciones*/
    private String contraindicaciones;

    /** Variable que almacena la Dosis, frecuencia de administraci�n y duraci�n del tratamiento */
    private String tratamiento;

    /** Variable que almacena la via de administracion  */
    private String viaSelect;

    /** Variable que almacena la cantidad requeridad*/
    private Integer cantidad;

    /** Lista que almacena los tipos de vias de administracion de los medicamentos*/
    private List lstVia;

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

    private UIInput itMedicamento;

    private Integer consecutivo;

    private boolean esCirugia;

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
    
    String ESPECIALIDAD = null;


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

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------    

    public FormulaMedicaUsuarioBean() {
    }


    public void init() {
        modoConsulta = false;
        inicializardFormulaMedica();

    }

    public void inicializardFormulaMedica() {
    
        generoFormula = false;

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
            if(lstPrescripcionesDefecto!= null && !lstPrescripcionesDefecto.isEmpty()){
                lstPrescripciones = lstPrescripcionesDefecto; 
            }
        } else {
            modoConsulta = true;
            
            for(Chformulamed medaux: lstPrescripciones){
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
     * @param medicamento
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * @return
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * @param tratamiento
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * @return
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * @param viaSelect
     */
    public void setViaSelect(String viaSelect) {
        this.viaSelect = viaSelect;
    }

    /**
     * @return
     */
    public String getViaSelect() {
        return viaSelect;
    }


    /**
     * @param lstVia
     */
    public void setLstVia(List lstVia) {
        this.lstVia = lstVia;
    }

    /**
     * @param cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return
     */
    public Integer getCantidad() {
        return cantidad;
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
     * @return
     */
    public List getLstVia() {
        if (lstVia == null || lstVia.isEmpty()) {
            lstVia = new ArrayList();
            lstVia.add(new SelectItem("", "Seleccione una opci�n "));
            lstVia.add(new SelectItem("VO", "Via Oral "));
            lstVia.add(new SelectItem("IV", "V�a Intravenosa "));
            lstVia.add(new SelectItem("IM", "V�a Intramuscular"));
            lstVia.add(new SelectItem("VA", "V�a Intravaginal"));
            lstVia.add(new SelectItem("VB", "V�a Bucal"));
            lstVia.add(new SelectItem("SC", "Subcut�nea"));
            lstVia.add(new SelectItem("SL", "Sublingual"));
            lstVia.add(new SelectItem("OT", "Otra "));
        }
        return lstVia;
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
     * @param contraindicaciones
     */
    public void setContraindicaciones(String contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    /**
     * @return
     */
    public String getContraindicaciones() {
        return contraindicaciones;
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
     * @param itMedicamento
     */
    public void setItMedicamento(UIInput itMedicamento) {
        this.itMedicamento = itMedicamento;
    }

    /**
     * @return
     */
    public UIInput getItMedicamento() {
        return itMedicamento;
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
        selectedIndex = ACTIVAR_BUSCADOR;
    }


    public void agregarPrescripcion() {
        Chformulamed formula;
        generoFormula = false;
        formula = new Chformulamed();
        if (medicamento != null && !medicamento.equals("") && 
            contraindicaciones != null && tratamiento != null && 
            !tratamiento.equals("") && viaSelect != null && 
            !viaSelect.equals("") && cantidad != null && 
            !cantidad.equals("0")) {
            formula.setImprimir(true);
            formula.setHfocadosis(cantidad);
            formula.setHfocmedicament(medicamento);
            formula.setHfoctratramien(tratamiento);
            formula.setHfocviadministr(viaSelect);
            formula.setHfoccontraindi(contraindicaciones);
            formula.setHfodfecregistr(new Date());
            formula.setHfocoperador(userName());
            lstPrescripciones.add(formula);
            medicamento = "";
            itMedicamento.setValue(null);
            tratamiento = "";
            viaSelect = "";
            contraindicaciones = "";
            cantidad = null;
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
        medicamento = formulaClon.getHfocmedicament();
        tratamiento = formulaClon.getHfoctratramien();
        viaSelect = formulaClon.getHfocviadministr();
        cantidad = formulaClon.getHfocadosis();
        contraindicaciones = formulaClon.getHfoccontraindi();
        deshabilitarMedicamento = false;
        this.lstPrescripciones.remove(formulaClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }

    public void aceptarMedicamento() {
        BuscadorMedicamentoBean medicamentoAux = 
            (BuscadorMedicamentoBean)FacesUtils.getManagedBean("buscadorMedicamentoBean");
        if (medicamentoAux != null && 
            medicamentoAux.getMedicamentoSelect() != null) {
            itMedicamento.setValue(medicamentoAux.getMedicamentoSelect().getHvpcprincactiv() + " " + medicamentoAux.getMedicamentoSelect().getHvpcconcentrac() +" "+ medicamentoAux.getMedicamentoSelect().getHvpcformafarma());
         
            medicamento = 
                    medicamentoAux.getMedicamentoSelect().getHvpcprincactiv();
            deshabilitarMedicamento = true;

        }
        selectedIndex = ACTIVAR_FORMULA_MEDICA;
        renderBuscador = false;
        FacesUtils.resetManagedBean("buscadorMedicamentoBean");
    }


    /**
     * @param valueChangeEvent
     */
    public void setMedicamento(ValueChangeEvent valueChangeEvent) {
        setMedicamento((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
            return value;
        }
        if (fieldName.equals("MEDICAMENTO")) {
            value = 
                    (index + 1) + "- " + this.lstPrescripcionesImprimir.get(index).getHfocmedicament();
            return value;
        }
        if (fieldName.equals("TRATAMIENTO")) {
            value = this.lstPrescripcionesImprimir.get(index).getHfoctratramien();
            return value;
        }
        if (fieldName.equals("VIA_ADMINISTRACION")) {
            value = lstPrescripcionesImprimir.get(index).getHfocviadministr();
            return value;
        }
        if (fieldName.equals("CANTIDAD_REQUERIDAD")) {
            value = this.lstPrescripcionesImprimir.get(index).getHfocadosis();
            return value;
        }
        if (fieldName.equals("CODIGO_CIE10")) {
            value = CODIGO_CIE10;
            return value;
        }

        if (fieldName.equals("CONTRAINDICACIONES")) {
            CONTRAINDICACIONES = ""; 
            if (lstPrescripcionesImprimir.get(index).getHfoccontraindi() != null && 
                !lstPrescripcionesImprimir.get(index).getHfoccontraindi().equals("")) {
                CONTRAINDICACIONES = 
                        CONTRAINDICACIONES + (index + 1) + "- " + lstPrescripcionesImprimir.get(index).getHfoccontraindi() + 
                        "\n";
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
        
        if(numeroConsulta != null && !numeroConsulta.equals("")){
            try{
               detaldescr = 
                this.serviceLocator.getCirugiaService().getDetalleDescripcion(numeroConsulta);
            }catch(ModelException e){
                e.printStackTrace();
            }
            
            if(detaldescr != null && !detaldescr.equals("")){
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
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
            }
        

                 }




    }
    
    


    //--------------------------------------------------------------------------
    //  Bot�n principal
    //--------------------------------------------------------------------------


    private void clearDatosFormula(){
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
        TIPOID_PROFESIONAL = null;
        NUMID_PROFESIONAL = null;
        REGISTRO_MEDICO = null; 
    }

    /**
     * 
     */
    public void generarFormula() {

        this.index = -1;
        clearDatosFormula();
        CONTRAINDICACIONES = ""; 
        
        lstPrescripcionesImprimir = new ArrayList<Chformulamed>(); 
         
      
        if (lstPrescripciones.size() != 0) {
        
            for(Chformulamed medImp :lstPrescripciones){
                if(medImp.isImprimir()){
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
//                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/prescripcionMedica.jasper");
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
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

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


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
    
    if(lstOpciones == null || lstOpciones.isEmpty()){
        lstOpciones = new ArrayList(); 
        lstOpciones.add(new SelectItem("S","SI")); 
        lstOpciones.add(new SelectItem("N","NO")); 
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
}

