//======================================================================================================================
// ARCHIVO EntregaVphBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//======================================================================================================================
package org.profamilia.hc.view.backing.procedimiento;

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

import org.profamilia.hc.model.dto.Chdatosvph;
import org.profamilia.hc.model.dto.Chlibrovph;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvphlect;
import org.profamilia.hc.model.dto.Chvphtoma;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpestadciv;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpparametr;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================
//======================================================================================================================
//  CLASE EntregaVphBean
//======================================================================================================================
public class EntregaVphBean extends BaseBean implements JRDataSource {
    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------

    private Chlibrovph entrega;

    private Chdatosvph vph;

    private Chvphlect lectura;

    private Chvphtoma toma;
    
    private boolean modoConsulta;

    private String reclamaUsuaria;

    private List lstOpciones;

    private boolean mostrarReclama;

    private boolean wexito;

    /**
     * Lista que almacena la lista de tipos de documentos
     */
    private List<SelectItem> listTipoIdentificacion;

    private int index = -1;

    private boolean generoEntregaResultado;

    private static int NUMERO_COPIAS = 1;

    private List lstConducta;

    Date FECHA_REPORTE;
    String HISTORIA_CLINICA;
    String CLINICA;

    String NOMBRE;
    String DOCUMENTO;
    String COMO_DESEA_SER_LLAMADO;

    String SEXO;
    Integer EDAD;
    Date FECHA_NACIMIENTO;
    String CIUDAD;
    String EPS;

    String DIRECCION_RESIDENCIA;
    String TELEFONO;
    String OCUPACION;
    String ESTADO_CIVIL;

    String RESPONSABLE;
    String RESPONSABLE_PARENTESCO;
    String RESPONSABLE_TELEFONO;

    String ACOMPANHIANTE;
    String ACOMPANHIANTE_PARENTESCO;
    String ACOMPANHIANTE_TELEFONO;

    String MOTIVO_CONSULTA;
    String CONDUCTA;
    String OBSERVACIONES_ADICIONALES;

    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------
    public EntregaVphBean() {
    }

    public void init() {
        generoEntregaResultado = false;
        modoConsulta = false;
        lstOpciones = new ArrayList();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        entrega = new Chlibrovph();
        lstConducta = new ArrayList();

        if (vph != null) {
            try {
                toma = serviceLocator.getClinicoService().getTomaVph(vph.getHdvnconsec());
                lectura
                        = serviceLocator.getClinicoService().getLecturaVph(vph.getHdvnconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (vph != null && lectura == null) {
            FacesUtils.addErrorMessage("No se ha registrado la lectura de esta vph");
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    //  Get/Set
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @param entrega
     */
    public void setEntrega(Chlibrovph entrega) {
        this.entrega = entrega;
    }

    /**
     * @return
     */
    public Chlibrovph getEntrega() {
        return entrega;
    }

    public boolean isGeneroEntregaResultado() {
        return generoEntregaResultado;
    }

    public void setGeneroEntregaResultado(boolean generoEntregaResultado) {
        this.generoEntregaResultado = generoEntregaResultado;
    }

    public boolean isModoConsulta() {
        return modoConsulta;
    }

    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }
    
    
    /**
     * @param reclamaUsuaria
     */
    public void setReclamaUsuaria(String reclamaUsuaria) {
        this.reclamaUsuaria = reclamaUsuaria;
    }

    /**
     * @return
     */
    public String getReclamaUsuaria() {
        return reclamaUsuaria;
    }

    /**
     * @param mostrarReclama
     */
    public void setMostrarReclama(boolean mostrarReclama) {
        this.mostrarReclama = mostrarReclama;
    }

    /**
     * @return
     */
    public boolean isMostrarReclama() {
        return mostrarReclama;
    }

    /**
     * @param vph
     */
    public void setVph(Chdatosvph vph) {
        this.vph = vph;
    }

    /**
     * @return
     */
    public Chdatosvph getVph() {
        return vph;
    }

    /**
     * @param valueChangeEvent
     */
    public void setReclamaUsuaria(ValueChangeEvent valueChangeEvent) {
        setReclamaUsuaria((String) valueChangeEvent.getNewValue());
        ((UIInput) valueChangeEvent.getComponent()).setLocalValueSet(false);
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
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }

    /**
     * @param listTipoIdentificacion
     */
    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux
                        = (ArrayList<Cptipoiden>) this.serviceLocator.getClinicoService().getTipoIdentificacion();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoIdentificacionAux.isEmpty()) {

                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("",
                        "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(listTipoIdentificacionAux.get(i).getCticcodigo(),
                            listTipoIdentificacionAux.get(i).getCticdescri()));
                    i++;
                }
            }
        }

        return listTipoIdentificacion;
    }

    /**
     * @param wexito
     */
    public void setWexito(boolean wexito) {
        this.wexito = wexito;
    }

    /**
     * @return
     */
    public boolean isWexito() {
        return wexito;
    }

    /**
     * @param lstConducta
     */
    public void setLstConducta(List lstConducta) {
        this.lstConducta = lstConducta;
    }

    /**
     * @return
     */
    public List getLstConducta() {
        if (lstConducta.size() == 0) {
            ArrayList<Cndesccito> lstConductaAux = null;
            try {
                lstConductaAux
                        = (ArrayList<Cndesccito>) this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("chlibrovph",
                                "ctmcvphcond");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstConductaAux != null && !lstConductaAux.isEmpty()) {

                lstConducta.add(new SelectItem("",
                        "Seleccione una opcion ..."));
                Iterator it = lstConductaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstConducta.add(new SelectItem((lstConductaAux.get(i).getCdicvalor()),
                            lstConductaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstConducta;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //------------------------------------------------------------------------------------------------------------------
    public void changeReclama() {
        if (reclamaUsuaria != null && reclamaUsuaria.equals("N")) {
            mostrarReclama = true;
        } else {
            mostrarReclama = false;
        }
    }

    public String volverConsulta() {

        FacesUtils.resetManagedBean("consultarEntregaVphsBean");
        FacesUtils.resetManagedBean("entregaVphBean");
        generoEntregaResultado = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Reporte
    //------------------------------------------------------------------------------------------------------------------
    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        obtenerDatosReporte();
        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("FECHA_REPORTE")) {
            value = FECHA_REPORTE;
        } else if (fieldName.equals("HISTORIA_CLINICA")) {
            value = HISTORIA_CLINICA;
        } else if (fieldName.equals("CLINICA")) {
            value = CLINICA;
        } else if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("DOCUMENTO")) {
            value = DOCUMENTO;
        } else if (fieldName.equals("COMO_DESEA_SER_LLAMADO")) {
            value = COMO_DESEA_SER_LLAMADO;
        } else if (fieldName.equals("SEXO")) {
            value = SEXO;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        } else if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("EPS")) {
            value = EPS;
        } else if (fieldName.equals("DIRECCION_RESIDENCIA")) {
            value = DIRECCION_RESIDENCIA;
        } else if (fieldName.equals("TELEFONO")) {
            value = TELEFONO;
        } else if (fieldName.equals("OCUPACION")) {
            value = OCUPACION;
        } else if (fieldName.equals("ESTADO_CIVIL")) {
            value = ESTADO_CIVIL;
        } else if (fieldName.equals("RESPONSABLE")) {
            value = RESPONSABLE;
        } else if (fieldName.equals("RESPONSABLE_PARENTESCO")) {
            value = RESPONSABLE_PARENTESCO;
        } else if (fieldName.equals("RESPONSABLE_TELEFONO")) {
            value = RESPONSABLE_TELEFONO;
        } else if (fieldName.equals("ACOMPANHIANTE")) {
            value = ACOMPANHIANTE;
        } else if (fieldName.equals("ACOMPANHIANTE_PARENTESCO")) {
            value = ACOMPANHIANTE_PARENTESCO;
        } else if (fieldName.equals("ACOMPANHIANTE_TELEFONO")) {
            value = ACOMPANHIANTE_TELEFONO;
        } else if (fieldName.equals("MOTIVO_CONSULTA")) {
            value = MOTIVO_CONSULTA;
        } else if (fieldName.equals("CONDUCTA")) {
            value = CONDUCTA;
        } else if (fieldName.equals("OBSERVACIONES_ADICIONALES")) {
            value = OBSERVACIONES_ADICIONALES;
        }

        return value;
    }

    public void obtenerDatosReporte() {
/*
        if (entrega != null && entrega.getHlvcconducta() != null) {

        }
        */
        if (vph != null) {

            FECHA_REPORTE = new Date();
            Chusuario usuario = vph.getHdvlusuario();
            if (usuario != null) {
                HISTORIA_CLINICA = "" + usuario.getHusanumeiden();
            }
            Cpclinica clinica = null;
            try {
                clinica = this.serviceLocator.getClinicoService().getClinica((int) vph.getHdvnclinic());
                if (clinica != null) {
                    CLINICA = clinica.getCclcnombre();
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ArrayList<Cpparametr> sexos = null;
            try {
                sexos
                        = (ArrayList<Cpparametr>) this.serviceLocator.getClinicoService().getListaDescripcionesParametro("sexo");
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ArrayList<Cpocupacio> ocupaciones = null;
            try {
                ocupaciones
                        = (ArrayList<Cpocupacio>) this.serviceLocator.getClinicoService().getOcupaciones();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            ArrayList<Cpestadciv> estadosCiviles = null;
            try {
                estadosCiviles
                        = (ArrayList<Cpestadciv>) this.serviceLocator.getClinicoService().getEstadosCiviles();
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (usuario != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(usuario.getHuscprimerapel() + " ");
                sb.append(usuario.getHuscsegundnomb() != null ? (usuario.getHuscsegundnomb() + " ") : "");
                sb.append(usuario.getHuscprimerapel() + " ");
                sb.append(usuario.getHuscsegundapel() != null ? (usuario.getHuscsegundapel()) : "");
                NOMBRE = sb.toString();
                sb = new StringBuilder();
                sb.append(usuario.getHusetipoiden() + " - ");
                sb.append(usuario.getHusanumeiden());
                DOCUMENTO = sb.toString();
                COMO_DESEA_SER_LLAMADO = usuario.getHuscnombralter();
                if (sexos != null && usuario.getHusesexo() != null) {
                    for (Cpparametr cpparametr : sexos) {
                        if (cpparametr.getCpcvalor().equals(usuario.getHusesexo())) {
                            SEXO = cpparametr.getCpcdescrip();
                        }
                    }

                }
                EDAD = usuario.calcularEdad(new Date());
                FECHA_NACIMIENTO = usuario.getHusdfechanacim();

            }

            if (usuario.getHusnciudad() != null && usuario.getHusndepartamen() != null) {
                try {
                    Cpmunidane ciudadObject = this.serviceLocator.getClinicoService().getMunicipio(usuario.getHusnciudad(),
                            usuario.getHusndepartamen());
                    if (ciudadObject != null) {
                        CIUDAD = ciudadObject.getCmdcnommun() + "-" + ciudadObject.getCmdcnomdpt();
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            if (usuario.getHuscentidadadm() != null) {
                try {
                    Cpentidadadm eps = serviceLocator.getClinicoService().getAseguradoraPorCodigo(usuario.getHuscentidadadm());
                    if (eps != null) {
                        EPS = eps.getCeacnombre();
                    }
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (usuario.getHuscdireccion() != null) {
                DIRECCION_RESIDENCIA = usuario.getHuscdireccion()
                        + usuario.getHuscbarrio() != null ? " - " + usuario.getHuscbarrio() : "";
            }

            if (usuario.getHusctelefono() != null) {
                TELEFONO = usuario.getHusctelefono();
            }
            if (ocupaciones!= null && usuario.getHusnocupacion() != null) {
                for (Cpocupacio cpocupacio : ocupaciones) {
                    if (cpocupacio.getCocncodigo().equals(usuario.getHusnocupacion())) {
                        OCUPACION = cpocupacio.getCoccdescri();
                    }
                }
            }
            if (estadosCiviles != null && usuario.getHuseestadcivil()!= null) {
                for (Cpestadciv cpestadciv : estadosCiviles) {
                    if (cpestadciv.getCecccodigo().equals(usuario.getHuseestadcivil())) {
                        ESTADO_CIVIL = cpestadciv.getCeccdescri();
                    }
                }
            }
            if (usuario.getHuscnomresponsa() != null) {
                RESPONSABLE = usuario.getHuscnomresponsa();
            }
            if (usuario.getHuscparresponsa() != null) {
                RESPONSABLE_PARENTESCO = usuario.getHuscparresponsa();
            }
            if (usuario.getHusctelresponsa() != null) {
                RESPONSABLE_TELEFONO = usuario.getHusctelresponsa();
            }
            if (usuario.getHuscnomacompana() != null) {
                ACOMPANHIANTE = usuario.getHuscnomacompana();
            }
            if (usuario.getHusctelacompana() != null) {
                ACOMPANHIANTE_TELEFONO = usuario.getHusctelacompana();
            }
            
            Chlibrovph libro = null;
            try {
                libro = serviceLocator.getClinicoService().getLibroVph(vph.getHdvnconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (libro != null && libro.getHlvcconducta() != null) {
                CONDUCTA = libro.getHlvcconducta();
            }
        }
    }

    public void clearFormulario() {
        FECHA_REPORTE = null;
        HISTORIA_CLINICA = "";
        CLINICA = "";
        NOMBRE = "";
        DOCUMENTO = "";
        COMO_DESEA_SER_LLAMADO = "";
        SEXO = "";
        EDAD = null;
        FECHA_NACIMIENTO = null;
        CIUDAD = "";
        EPS = "";
        DIRECCION_RESIDENCIA = "";
        TELEFONO = "";
        OCUPACION = "";
        ESTADO_CIVIL = "";
        RESPONSABLE = "";
        RESPONSABLE_PARENTESCO = "";
        RESPONSABLE_TELEFONO = "";
        ACOMPANHIANTE = "";
        ACOMPANHIANTE_PARENTESCO = "";
        ACOMPANHIANTE_TELEFONO = "";
        MOTIVO_CONSULTA = "";
        CONDUCTA = "";
        OBSERVACIONES_ADICIONALES = "";
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Boton Principal 
    //------------------------------------------------------------------------------------------------------------------
    public void generarEntregaVph() {
        clearFormulario();
        wexito = true;
        entrega.setHlvcoperador(userName());
        entrega.setHlvdfecregistr(new Date());
        entrega.setHlvanumeiden(vph.getHdvanumide());
        entrega.setHlvetipoiden(vph.getHdvctipide());
        entrega.setHlvcprimerapel(vph.getHdvcpriape());
        entrega.setHlvcsegundapel(vph.getHdvcsegape());
        entrega.setHlvcprimernomb(vph.getHdvcprinom());
        entrega.setHlvcsegundnomb(vph.getHdvcsegnom());
        entrega.setHlvnconsec((long) vph.getHdvnconsec());

        toma = null;
        lectura = null;

        if (vph != null) {
            try {
                toma = serviceLocator.getClinicoService().getTomaVph(vph.getHdvnconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            try {
                lectura = serviceLocator.getClinicoService().getLecturaVph(vph.getHdvnconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lectura == null) {
            wexito = false;
        }

        if (wexito) {
            try {
                serviceLocator.getClinicoService().entregarVph(vph, entrega);
                modoConsulta = true;
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + ": "
                        + e.getMessage());
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_EXISTE_LECTURA_VPH);
        }

//        FacesUtils.resetManagedBean("consultarEntregaVphsBean");
//        FacesUtils.resetManagedBean("entregaVphBean");
        //return BeanNavegacion.RUTA_IR_BUSCAR_VPHS;
    }
    
    
    public String generarPDF() {

        try {
            index = -1;
            URL url = null;
            URL url_profamilia = null;

            url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteEntregaResultados FO_GS_CS_CG-015.jasper");

            url_profamilia
                    = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);

            URL url_super_horizontal
                    = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical
                    = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL",
                        url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report
                        = (JasperReport) JRLoader.loadObject(url);

                bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource) this);
                PdfServletUtils.showPdfDocument(bytes,
                        "entregaResultados" + Calendar.getInstance().getTimeInMillis()
                        + ".pdf", false);
                generoEntregaResultado = true;
                modoConsulta = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte "
                    + e.getMessage());
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }

}
