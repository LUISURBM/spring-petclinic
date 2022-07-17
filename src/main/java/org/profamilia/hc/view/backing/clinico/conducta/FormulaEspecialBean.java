//=======================================================================
// ARCHIVO 
// FECHA CREACIon: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.clinico.conducta;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chformulaesp;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=======================================================================
//  CLASE
//=======================================================================
public class FormulaEspecialBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private int index = -1;

    private boolean generoFormula;

    /** Variable que almacena el Nombre Generico del Medicamento Concentracion/ forma farmac�utica */
    private String medicamento;

    /** Variable que almacena las contraindicaciones y/o observaciones*/
    private String contraindicaciones;

    /** Variable que almacena la Dosis, frecuencia de administracion y duracion del tratamiento */
    private String tratamiento;

    /** Variable que almacena la via de administracion  */
    private String viaSelect;

    /** Variable que almacena la cantidad requeridad*/
    private Integer cantidad;

    /** Lista que almacena los tipos de vias de administracion de los medicamentos*/
    private List lstVia;

    /** Almacena la tabla de la formulacion */
    private HtmlDataTable dtFormula;

    /**Almacena la lista de prescripcion  */
    private List<Chformulaesp> lstPrescripciones;

    /** Almacena la formula que se desea eliminar de la base de datos */
    private Chformulaesp formulaClon;

    /** Almacena true si es modo consulta*/
    private boolean modoConsulta;


    private Integer tipoHistoria;

    private Long numeroCirugia;

    private String tipoServicio;

    private Integer consecutivo;

    private boolean esCirugia;


    private Chusuario usuario;

    private String codigoCie10;

    String NOMBRES = "";
    String APELLIDOS = "";
    String TIPO_DOCUMENTO = "";
    Long NUMERO_DOCUMENTO = null;
    String DIAGNOSTICO_PRINCIPAL = "";
    String DIAGNOSTICO_SECUNDARIO = "";
    String CODIGO_CIE10 = "";
    String TIPO_USUARIO = "";
    String ANO = "";
    String MES = "";
    String DIA = "";
    Date fecha = null;
    String CONTRAINDICACIONES = "";

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------    

    public FormulaEspecialBean() {
    }

    public void init() {


        lstVia = new ArrayList();
        generoFormula = false;


        try {
            lstPrescripciones = 
                    this.serviceLocator.getClinicoService().getLstMedicamentosEspeciales(numeroCirugia, 
                                                                                         tipoServicio, 
                                                                                         consecutivo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (lstPrescripciones == null) {
            lstPrescripciones = new ArrayList<Chformulaesp>();
            modoConsulta = false;

        } else {
            modoConsulta = true;
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
     * @param codigoCie10
     */
    public void setCodigoCie10(String codigoCie10) {
        this.codigoCie10 = codigoCie10;
    }

    /**
     * @return
     */
    public String getCodigoCie10() {
        return codigoCie10;
    }

    /**
     * @return
     */
    public List getLstVia() {
        if (lstVia.size() == 0) {
            lstVia.add(new SelectItem("", "Seleccione una opcion "));
            lstVia.add(new SelectItem("VO", "Via Oral "));
            lstVia.add(new SelectItem("IV", "V�a Intravenosa "));
            lstVia.add(new SelectItem("IM", "V�a Intramuscular"));
            lstVia.add(new SelectItem("VA", "V�a Intravaginal"));
            lstVia.add(new SelectItem("SC", "Subcutonea"));
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
    public void setLstPrescripciones(List<Chformulaesp> lstPrescripciones) {
        this.lstPrescripciones = lstPrescripciones;
    }

    /**
     * @return
     */
    public List<Chformulaesp> getLstPrescripciones() {
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
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
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

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------   

    public void agregarPrescripcion() {
        Chformulaesp formula;
        formula = new Chformulaesp();
        if (medicamento != null && !medicamento.equals("") && 
            contraindicaciones != null && tratamiento != null && 
            !tratamiento.equals("") && viaSelect != null && 
            !viaSelect.equals("") && cantidad != null && 
            !cantidad.equals("0")) {
            formula.setHfecadosis(cantidad);
            formula.setHfecmedicament(medicamento);
            formula.setHfectratramien(tratamiento);
            formula.setHfecviadministr(viaSelect);
            formula.setHfeccontraindi(contraindicaciones);
            formula.setHfedfecregistr(new Date());
            formula.setHfecoperador(userName());

            lstPrescripciones.add(formula);
            medicamento = "";
            tratamiento = "";
            viaSelect = "";
            contraindicaciones = "";
            cantidad = null;
        } else {
            FacesUtils.addErrorMessage("Debe Registrar todos los datos");
        }


    }


    public void eliminarFormula() {
        this.formulaClon = (Chformulaesp)this.dtFormula.getRowData();
        this.lstPrescripciones.remove(formulaClon);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }


    //-----------------------------------------------------------------------
    //  Construir Reporte
    //----------------------------------------------------------------------- 

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < lstPrescripciones.size());
    }

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
            value = "FECHA ";
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
            value = this.lstPrescripciones.get(index).getHfecmedicament();
            return value;
        }
        if (fieldName.equals("TRATAMIENTO")) {
            value = this.lstPrescripciones.get(index).getHfectratramien();
            return value;
        }
        if (fieldName.equals("VIA_ADMINISTRACION")) {
            value = lstPrescripciones.get(index).getHfecviadministr();
            return value;
        }
        if (fieldName.equals("CANTIDAD_REQUERIDAD")) {
            value = this.lstPrescripciones.get(index).getHfecadosis();
            return value;
        }
        if (fieldName.equals("CODIGO_CIE10")) {
            value = CODIGO_CIE10;
            return value;
        }

        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = this.getUsuarioSystem().getCurcnombre();
            return value;
        }
        if (fieldName.equals("CONTRAINDICACIONES")) {
            CONTRAINDICACIONES = 
                    lstPrescripciones.get(index).getHfeccontraindi();
            value = CONTRAINDICACIONES;
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

        if (codigoCie10 != null) {

            CODIGO_CIE10 = codigoCie10;


        }

        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer ano = calendar.get(calendar.YEAR);

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

        ANO = ano.toString();


    }


    public void obtenerDatosReporteCirugia() {
        clear();

        Chusuario usuarioAux;
        usuarioAux = null;

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


        if (codigoCie10 != null) {

            CODIGO_CIE10 = codigoCie10;


        }

        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer ano = calendar.get(calendar.YEAR);

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

        ANO = ano.toString();


    }

    private void clear() {
        NOMBRES = "";
        APELLIDOS = "";
        TIPO_DOCUMENTO = "";
        NUMERO_DOCUMENTO = null;
        DIAGNOSTICO_PRINCIPAL = "";
        DIAGNOSTICO_SECUNDARIO = "";
        CODIGO_CIE10 = "";
        TIPO_USUARIO = "";
        ANO = "";
        MES = "";
        DIA = "";
        fecha = null;
        CONTRAINDICACIONES = "";
    }


    //--------------------------------------------------------------------------
    //  Boton principal
    //--------------------------------------------------------------------------


    /**
     * 
     */
    public void generarFormula() {
        this.index = -1;
        if (lstPrescripciones.size() != 0 && !lstPrescripciones.isEmpty()) {
            this.index = -1;
            try {
                if (!esCirugia) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }

                try {
                    if (!esCirugia) {
                        this.serviceLocator.getCirugiaService().saveListFormulaMedicaEspecial(lstPrescripciones, 
                                                                                              numeroCirugia, 
                                                                                              tipoServicio);
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    } else {
                        this.serviceLocator.getCirugiaService().saveListFormulaMedicamentoEspecialCirugia(lstPrescripciones, 
                                                                                                          numeroCirugia, 
                                                                                                          tipoServicio, 
                                                                                                          consecutivo);
                        FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                    }

                } catch (ModelException e) {
                    FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                    e.printStackTrace();
                }


               URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/prescripcionMedicaEspecial.jasper");
                URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
                URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
                URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 

                if (url!= null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;

                    JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                    bytes = 
                            JasperRunManager.runReportToPdf(report, 
                                                            parameters, 
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
