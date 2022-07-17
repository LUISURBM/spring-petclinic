package org.profamilia.hc.view.backing.asesoria.administrador;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chreporte;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chaseavise;
import org.profamilia.hc.model.dto.Chseguavis;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ConsultarAsesoriaBean extends BaseBean implements JRDataSource {


    private int selectedIndex;

    private boolean renderBuscador;

    private UIInput itNumeroUsuario;

    private String nombreUsuario;

    BuscadorUsuariosBean buscador;

    private List<Chaseavise> lstAsesoria;

    private boolean renderInformacionUsuario;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private boolean generoHistoria;

    private Long numeroUsuario;

    private boolean renderFolio;

    private boolean mostrarReporte;

    private Chusuario usuario;

    private List listSexos;

    private List listEstadoCivil;


    private int index = -1;


    protected List<Chreporte> lstReporte;

    private HtmlDataTable dtAsesoria;

    // Orden de Impresion
    
     static Integer imp_datos_asesoria = 1;
    
     static Integer imp_conocimiento_programa = 2;
    
    static Integer imp_intervencion_asesoria = 3;

    static Integer imp_estado_psicoemocional = 4;

    static Integer imp_documentos_presentados = 5;

    static Integer imp_hallazgos = 6;
    
    static Integer imp_concepto_psicologico = 7;


    static Integer imp_conducta_a_seguir = 8;

    static Integer imp_seguimiento = 9;

    /** Almacenan los datos de la historia clinica */
    private String TIPO_DOCUMENTO;
    private Long NUMERO_DOCUMENTO;
    private String IMPRIMIO;
    private String NOMBRE;
    private Date FECHA_NACIMIENTO;
    private Integer EDAD;
    private String SEXO;
    private String DIRECCION;
    private String TELEFONO;
    private String CIUDAD;
    private String OCUPACION;
    private String ESTADO_CIVIL;
    private String RESPONSABLE;
    private String PARENTESCO_RESPONSABLE;
    private String TELEFONO_RESPONSABLE;
    private String FECHA_CONSULTA;
    private String NOMBRE_PROFESIONAL;
    private String REGISTRO_MEDICO;
    private String CENTRO;
    private String EPS;
    
    
    //DATOS DE CONOCIMIENTO DEL PROGRAMA
    
    private String CONOCIMIENTO_PROGRAMA; 
    
    private String CUAL_CONOCIMIENTO; 

    // DATOS DE ASESORIA

    private String INTERVENCION_ASESORIA;
    private String TIPO_ASESORIA;
    private String AREA_AFECTIVA;
    private String AREA_SOMATICA;
    private String AREA_RELACIONAL;
    private String AREA_COGNITIVA;

    private String DOCUMENTOS_PRESENTADOS;
    private String DOCUMENTOS_REMISION_INSTITUCION;
    private String DOCUMENTO_OTRO;
    private String HALLAZGOS;
    private String CONCEPTO_PSICOLOGICO;
    private String INTERVENCION_CRISIS;
    private String CONDUCTA;
    private String SEGUIMIENTO;


    //

    String AGRESOR_CONOCIDO;
    String RELACION_AGRESOR; 
    String PARENTESCO_AGRESOR; 
    String CUAL_PARENTESCO; 
    String CUAL_RELACION; 
    
    
    String LUGAR_HECHOS;
    String CUAL_LUGAR;
    String TIEMPO_OCURRENCIA;
    String OTRO_TIEMPO;
    String ACCIONES_PREVIAS;
    String CUAL_ACCION_PREVIA; 
    
    //DATOS ASESOR
    
    String FECHA_ASESORIA; 
    String FECHA_REGISTRO; 
    String NOMBRE_ASESOR; 
    String CLINICA_ASESORIA; 


    public ConsultarAsesoriaBean() {
    }
    
    public void init(){
        
    }

    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
    }

    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
     * @param itNumeroUsuario
     */
    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    /**
     * @return
     */
    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }

    /**
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param renderInformacionUsuario
     */
    public void setRenderInformacionUsuario(boolean renderInformacionUsuario) {
        this.renderInformacionUsuario = renderInformacionUsuario;
    }

    /**
     * @return
     */
    public boolean isRenderInformacionUsuario() {
        renderInformacionUsuario = false;
        if (usuario != null && usuario.getHuslnumero() != null) {
            renderInformacionUsuario = true;
        }
        return renderInformacionUsuario;
    }

    /**
     * @param generoHistoria
     */
    public void setGeneroHistoria(boolean generoHistoria) {
        this.generoHistoria = generoHistoria;
    }

    /**
     * @return
     */
    public boolean isGeneroHistoria() {
        return generoHistoria;
    }

    /**
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
        return numeroUsuario;
    }


    public String changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        renderFolio = false;
        mostrarReporte = false;
        nombreUsuario = "";
        usuario = new Chusuario();
        lstAsesoria = new ArrayList<Chaseavise>();
        if (numeroUsuario != null)
            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }

            usuario = usuarioAux;

        }
        return null;
    }

    /**
     * @param renderFolio
     */
    public void setRenderFolio(boolean renderFolio) {
        this.renderFolio = renderFolio;
    }

    /**
     * @return
     */
    public boolean isRenderFolio() {
        return renderFolio;
    }

    /**
     * @param mostrarReporte
     */
    public void setMostrarReporte(boolean mostrarReporte) {
        this.mostrarReporte = mostrarReporte;
    }

    /**
     * @return
     */
    public boolean isMostrarReporte() {
        return mostrarReporte;
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
     * @param listSexos
     */
    public void setListSexos(List listSexos) {
        this.listSexos = listSexos;
    }

    /**
     * @param dtAsesoria
     */
    public void setDtAsesoria(HtmlDataTable dtAsesoria) {
        this.dtAsesoria = dtAsesoria;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtAsesoria() {
        return dtAsesoria;
    }

    /**
     * @param lstAsesoria
     */
    public void setLstAsesoria(List<Chaseavise> lstAsesoria) {
        this.lstAsesoria = lstAsesoria;
    }

    /**
     * @return
     */
    public List<Chaseavise> getLstAsesoria() {
        return lstAsesoria;
    }


    /**
     * @return La lista de los sexos que existen
     */
    public List getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
            ArrayList<Chsexo> listSexoAux = null;
            listSexos = new ArrayList();
            try {
                listSexoAux = 
                        (ArrayList<Chsexo>)this.getServiceLocator().getClinicoService().getSexo();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listSexoAux.isEmpty()) {

                Iterator it = listSexoAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listSexos.add(new SelectItem(listSexoAux.get(i).getCsxecodigo(), 
                                                 listSexoAux.get(i).getCsxcdescripcio()));
                    i++;

                }
            }
        }
        return listSexos;
    }

    /**
     * @param listEstadoCivil
     */
    public void setListEstadoCivil(List listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List getListEstadoCivil() {
        if (listEstadoCivil == null || listEstadoCivil.isEmpty()) {
            listEstadoCivil = new ArrayList();
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivilFemenino();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEstadoCivilAux.isEmpty()) {

                Iterator it = listEstadoCivilAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listEstadoCivil.add(new SelectItem(listEstadoCivilAux.get(i).getCececodigo(), 
                                                       listEstadoCivilAux.get(i).getCeccdescripcio()));
                    i++;
                }
            }
        }
        return listEstadoCivil;
    }


    public String consultarAsesoriasUsuario() {
        try {
            if (usuario != null && usuario.getHusanumeiden() != null && 
                usuario.getHusetipoiden() != null && 
                !usuario.getHusetipoiden().equals("")) {
                lstAsesoria = 
                        this.serviceLocator.getClinicoService().getListAsesoriaUsuario(usuario);
            }

        } catch (ModelException e) {
            e.printStackTrace();
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return null;
    }

    public String volverConsulta() {
        // Add event code here...
        return null;
    }

    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;
        renderFolio = false;
        mostrarReporte = false;
        usuario = new Chusuario();
        nombreUsuario = "";
        lstAsesoria = new ArrayList<Chaseavise>();

        buscador = 
                (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }
        renderBuscador = false;

    }

    //-----------------------------------------------------------------------
    //  Generacion Reporte
    //-----------------------------------------------------------------------

    public boolean next() {
        index++;
        return index < lstReporte.size();
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        } else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        } else if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
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
        } else if (fieldName.equals("EPS")) {
            value = EPS;
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
        } else if (fieldName.equals("FECHA_REGISTRO")) {
            value = lstReporte.get(index).getHredfecharegis();
        } else if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        }
        return value;
    }

    public String obtenerDatosReporte(Chaseavise asesoriaAux) {
        // Obtenemos los datos del usuario 
        resetDatos();

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

            if (usuario.getHuscentidadadm() != null) {
                try {
                    EPS = 
serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(usuario.getHuscentidadadm());
                } catch (ModelException e) {
                    e.printStackTrace();
                    return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                }
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
                return capturaError(e,IConstantes.ERROR_ARCHIVOS);
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
            }

            Integer ocupacion = usuario.getHusnocupacion();

            try {
                OCUPACION = 
                        serviceLocator.getClinicoService().getDescripcionOcupacion(ocupacion);
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_ARCHIVOS);
            }
            ESTADO_CIVIL = usuario.getHuseestadcivil();
            RESPONSABLE = usuario.getHuscnomacompana();
            PARENTESCO_RESPONSABLE = usuario.getHuscparresponsa();
            TELEFONO_RESPONSABLE = usuario.getHusctelacompana();
            

        }


        if (asesoriaAux != null) {
        
            if(asesoriaAux.getHavnconavs()!= null){
                try {
                    CONOCIMIENTO_PROGRAMA = this.serviceLocator.getClinicoService().getDescripcionConocimientoAvise(asesoriaAux.getHavnconavs());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                    
                }
                
                if(asesoriaAux.getHavnconavs().equals(6)){
                    CUAL_CONOCIMIENTO = asesoriaAux.getHavcotrcon(); 
                }
            }


            if (asesoriaAux.getHavcusureg() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (this.getClinica() != null) {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(asesoriaAux.getHavcusureg(), 
                                                                                           asesoriaAux.getHavnclinic());
                    }

                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                }

                if (profesional != null) {
                    NOMBRE_ASESOR = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                }
            }
            
            if(asesoriaAux.getId()!= null && asesoriaAux.getId().getHavdfecase()!= null){
                FECHA_ASESORIA = formatearCampo(asesoriaAux.getId().getHavdfecase()); 
            }
            
            if(asesoriaAux.getHavdfecreg() != null){
                FECHA_REGISTRO = formatearCampo(asesoriaAux.getHavdfecreg()); 
            }
            
            if(asesoriaAux.getHavnclinic() != null){
            Cpclinica clinAux  = null;
                try {
                    clinAux = this.serviceLocator.getClinicoService().getClinica(asesoriaAux.getHavnclinic());
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                }
                
                if(clinAux!= null){
                    CLINICA_ASESORIA = clinAux.getCclncodigo()+" "+clinAux.getCclcnombre(); 
                }
            }
            

            if (asesoriaAux != null) {
                if (asesoriaAux.getHavnintase() != null) {
                    try {
                        INTERVENCION_ASESORIA = 
                                serviceLocator.getClinicoService().getDescripcionIntervencionAsesoriaXid(asesoriaAux.getHavnintase());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                    }
                }


                try {
                    if (asesoriaAux.getHavndetint() != null) {
                        TIPO_ASESORIA = 
                                serviceLocator.getClinicoService().getDescripcionIntervencionAsesoriaXid(asesoriaAux.getHavndetint());
                    }
                } catch (ModelException e) {
                    return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                }


                if (asesoriaAux.getHavcagrcon() != null && 
                    !asesoriaAux.getHavcagrcon().equals("")) {
                    AGRESOR_CONOCIDO = 
                            formatearCampo(asesoriaAux.getHavcagrcon());
                }
                
                if(asesoriaAux.getHavnrelagr()!= null){
                    try {
                        RELACION_AGRESOR =  this.serviceLocator.getClinicoService().getDescripcionRelacionFamiliarAvise(asesoriaAux.getHavnrelagr());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                    }
                    
                
                    if(asesoriaAux.getHavnparagr()!= null){
                            try {
                                PARENTESCO_AGRESOR = this.serviceLocator.getClinicoService().getDescripcionParentescoFamiliarAvise(asesoriaAux.getHavnparagr());
                            } catch (ModelException e) {
                                return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                            }
                        }
                        
                    if(asesoriaAux.getHavcotrrel()!= null){
                        CUAL_RELACION = formatearCampo(asesoriaAux.getHavcotrrel());
                    }
                    
                    if(asesoriaAux.getHavcotrpar() != null){
                        CUAL_PARENTESCO = formatearCampo(asesoriaAux.getHavcotrpar()); 
                    }
  
                }

              

                AREA_AFECTIVA = "";

                // AREA AFECTIVA 
                if (asesoriaAux.getHavetranqu() != null && 
                    asesoriaAux.getHavetranqu().equals("S")) {
                    AREA_AFECTIVA = "Tranquila" + ", ";
                }
                if (asesoriaAux.getHaveangust() != null && 
                    asesoriaAux.getHaveangust().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Angustiada" + ", ";
                }
                if (asesoriaAux.getHavetriste() != null && 
                    asesoriaAux.getHavetriste().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Triste" + ", ";
                }
                if (asesoriaAux.getHaveconfun() != null && 
                    asesoriaAux.getHaveconfun().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Confundida" + ", ";
                }


                if (asesoriaAux.getHavedesori() != null && 
                    asesoriaAux.getHavedesori().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Desorientada" + ", ";
                }

                if (asesoriaAux.getHaveansios() != null && 
                    asesoriaAux.getHaveansios().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Ansiosa" + ", ";
                }
                
                if (asesoriaAux.getHaveagotad() != null && 
                    asesoriaAux.getHaveagotad().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Agotada /cansada" + ", ";
                }

                if (asesoriaAux.getHavehostil() != null && 
                    asesoriaAux.getHavehostil().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Hostil" + ", ";
                }

                if (asesoriaAux.getHavedesesp() != null && 
                    asesoriaAux.getHavedesesp().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Desesperada" + ", ";
                }

                if (asesoriaAux.getHavedisfru() != null && 
                    asesoriaAux.getHavedisfru().equals("S")) {
                    AREA_AFECTIVA = 
                            AREA_AFECTIVA + "Anedonia" + ", ";
                }

                if (asesoriaAux.getHavesendes() != null && 
                    asesoriaAux.getHavesendes().equals("S")) {
                    AREA_AFECTIVA = 
                            AREA_AFECTIVA + "Sentimientos de desesperanza" + 
                            ", ";
                }
                if (asesoriaAux.getHaveimpote() != null && 
                    asesoriaAux.getHaveimpote().equals("S")) {
                    AREA_AFECTIVA = AREA_AFECTIVA + "Impotencia" + ", ";
                }

              

                if (AREA_AFECTIVA != null && !AREA_AFECTIVA.equals("")) {
                    AREA_AFECTIVA = 
                            AREA_AFECTIVA.substring(0, AREA_AFECTIVA.length() - 
                                                    2);
                } else {
                    AREA_AFECTIVA = "Sin Alteraciones Aparentes";
                }


                AREA_SOMATICA = "";

                // AREA SOMATICA
                if (asesoriaAux.getHavedolor() != null && 
                    asesoriaAux.getHavedolor().equals("S")) {
                    AREA_SOMATICA = "Dolor" + ", ";
                }

                if (asesoriaAux.getHavehemato() != null && 
                    asesoriaAux.getHavehemato().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Hematoma / equimosis" + ", ";
                }


                if (asesoriaAux.getHavefractu() != null && 
                    asesoriaAux.getHavefractu().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Fractura" + ", ";
                }

                if (asesoriaAux.getHaveinsomn() != null && 
                    asesoriaAux.getHaveinsomn().equals("S")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA + "Alteraci�n del sue�o" + ", ";
                }

                if (asesoriaAux.getHaveinapet() != null && 
                    asesoriaAux.getHaveinapet().equals("S")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA + "Alteraci�n del apetito" + ", ";
                }

                if (asesoriaAux.getHavesendeb() != null && 
                    asesoriaAux.getHavesendeb().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Debilidad" + ", ";
                }


                if (asesoriaAux.getHavemareo() != null && 
                    asesoriaAux.getHavemareo().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Mareos" + ", ";
                }

                if (asesoriaAux.getHavehipera() != null && 
                    asesoriaAux.getHavehipera().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Hiperactividad" + ", ";
                }

                if (asesoriaAux.getHaveahogo() != null && 
                    asesoriaAux.getHaveahogo().equals("S")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA + "Ahogo/falta de aire" + ", ";
                }

                if (asesoriaAux.getHavepalpi() != null && 
                    asesoriaAux.getHavepalpi().equals("S")) {
                    AREA_SOMATICA = AREA_SOMATICA + "Palpitaciones" + ", ";
                }

                if (AREA_SOMATICA != null && !AREA_SOMATICA.equals("")) {
                    AREA_SOMATICA = 
                            AREA_SOMATICA.substring(0, AREA_SOMATICA.length() - 
                                                    2);
                } else {
                    AREA_SOMATICA = "Sin Alteraciones Aparentes";
                }


                AREA_RELACIONAL = "";

                // AREA AREA_RELACIONAL
                if (asesoriaAux.getHaveagresi() != null && 
                    asesoriaAux.getHaveagresi().equals("S")) {
                    AREA_RELACIONAL = "Agresividad" + ", ";
                }

                if (asesoriaAux.getHaveaislam() != null && 
                    asesoriaAux.getHaveaislam().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Aislamiento" + ", ";
                }

                if (asesoriaAux.getHavepasmad() != null && 
                    asesoriaAux.getHavepasmad().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Pasmada " + ", ";
                }

                if (asesoriaAux.getHavereftem() != null && 
                    asesoriaAux.getHavereftem().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Fobia " + ", ";
                }


                if (asesoriaAux.getHavepareja() != null && 
                    asesoriaAux.getHavepareja().equals("S")) {
                    AREA_RELACIONAL = 
                            AREA_RELACIONAL + "Conflicto con la pareja " + ", ";
                }
                if (asesoriaAux.getHavefamili() != null && 
                    asesoriaAux.getHavefamili().equals("S")) {
                    AREA_RELACIONAL = 
                            AREA_RELACIONAL + "Conflicto con la familia " + 
                            ", ";
                }
                if (asesoriaAux.getHavedesamp() != null && 
                    asesoriaAux.getHavedesamp().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Desamparo " + ", ";
                }
                if (asesoriaAux.getHavepobrez() != null && 
                    asesoriaAux.getHavepobrez().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Pobreza " + ", ";
                }
                if (asesoriaAux.getHaveviolen() != null && 
                    asesoriaAux.getHaveviolen().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Violencia " + ", ";
                }
                if (asesoriaAux.getHavedesemp() != null && 
                    asesoriaAux.getHavedesemp().equals("S")) {
                    AREA_RELACIONAL = AREA_RELACIONAL + "Desempleo " + ", ";
                }

                if (AREA_RELACIONAL != null && !AREA_RELACIONAL.equals("")) {
                    AREA_RELACIONAL = 
                            AREA_RELACIONAL.substring(0, AREA_RELACIONAL.length() - 
                                                      2);
                } else {
                    AREA_RELACIONAL = "Sin Alteraciones Aparentes";
                }


                AREA_COGNITIVA = "";

                // AREA AREA_COGNITIVA
                if (asesoriaAux.getHavedisper() != null && 
                    asesoriaAux.getHavedisper().equals("S")) {
                    AREA_COGNITIVA = "Dispersa / desorientada" + ", ";
                }

                if (asesoriaAux.getHavepenneg() != null && 
                    asesoriaAux.getHavepenneg().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Pensamientos negativos frecuentes" + 
                            ", ";
                }

                if (asesoriaAux.getHavedifpro() != null && 
                    asesoriaAux.getHavedifpro().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Dificultad para resolver problemas" + 
                            ", ";
                }


                if (asesoriaAux.getHaveideper() != null && 
                    asesoriaAux.getHaveideper().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Ideas de persecuci�n" + ", ";
                }

                if (asesoriaAux.getHaveincme() != null && 
                    asesoriaAux.getHaveincme().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Incapacidad mental" + ", ";
                }


                if (asesoriaAux.getHavedificu() != null && 
                    asesoriaAux.getHavedificu().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Dificultad para tomar decisiones" + 
                            ", ";
                }
                if (asesoriaAux.getHaveconcen() != null && 
                    asesoriaAux.getHaveconcen().equals("S")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA + "Falta de concentraci�n " + ", ";
                }
                if (asesoriaAux.getHavesuicid() != null && 
                    asesoriaAux.getHavesuicid().equals("S")) {
                    AREA_COGNITIVA = AREA_COGNITIVA + "ideaci�n suicida" + ", ";
                }

                if (asesoriaAux.getHaveotro() != null && 
                    asesoriaAux.getHaveotro().equals("S")) {
                    AREA_COGNITIVA = AREA_COGNITIVA + " Otro" + ", ";
                }

                if (AREA_COGNITIVA != null && !AREA_COGNITIVA.equals("")) {
                    AREA_COGNITIVA = 
                            AREA_COGNITIVA.substring(0, AREA_COGNITIVA.length() - 
                                                    2);
                } else {
                    AREA_COGNITIVA = "Sin Alteraci�n Aparentes";
                }

                DOCUMENTOS_PRESENTADOS = "";
                DOCUMENTO_OTRO = "";
                DOCUMENTOS_REMISION_INSTITUCION = "";

                if (asesoriaAux.getHavcnindoc() != null && 
                    asesoriaAux.getHavcnindoc().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = "Ninguno";
                }

                if (asesoriaAux.getHavedocden() != null && 
                    asesoriaAux.getHavedocden().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = "Denuncia" + ",";
                }

                if (asesoriaAux.getHavepruemb() != null && 
                    asesoriaAux.getHavepruemb().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "Prueba de Embarazo" + 
                            ",";
                }

                if (asesoriaAux.getHavevalps() != null && 
                    asesoriaAux.getHavevalps().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "Valoraci�n Psicol�gica" + 
                            ",";
                }

                if (asesoriaAux.getHavecerme() != null && 
                    asesoriaAux.getHavecerme().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "Certificado M�dico" + 
                            ",";
                }

                if (asesoriaAux.getHavedoceco() != null && 
                    asesoriaAux.getHavedoceco().equals("S")) {
                    DOCUMENTOS_PRESENTADOS = 
                            DOCUMENTOS_PRESENTADOS + "Ecograf�a" + ",";
                }

                if (asesoriaAux.getHavcrecotr() != null && 
                    asesoriaAux.getHavcrecotr().equals("S")) {
                    DOCUMENTOS_REMISION_INSTITUCION = 
                            "Remisi�n de otra instituci�n: " + 
                            formatearCampo(asesoriaAux.getHavcrecnom());
                }

                if (asesoriaAux.getHaveotrdoc() != null && 
                    asesoriaAux.getHaveotrdoc().equals("S")) {
                    DOCUMENTO_OTRO = 
                            "Otro: " + formatearCampo(asesoriaAux.getHavcnomdoc());
                }

                HALLAZGOS = "";

                if (asesoriaAux.getHavcconclu() != null && 
                    !asesoriaAux.getHavcconclu().equals("")) {
                    HALLAZGOS = formatearCampo(asesoriaAux.getHavcconclu());
                }
                
                CONCEPTO_PSICOLOGICO =""; 
                
                if (asesoriaAux.getHavcconpsi() != null && 
                    !asesoriaAux.getHavcconpsi().equals("")) {
                    CONCEPTO_PSICOLOGICO = formatearCampo(asesoriaAux.getHavcconpsi());
                }
                
                
                INTERVENCION_CRISIS = formatearCampo(asesoriaAux.getHavcintcri()); 

                CONDUCTA = "";

               if (asesoriaAux.getHavcremilv() != null && 
                    asesoriaAux.getHavcremilv().equals("S")) {
                    CONDUCTA = CONDUCTA + "Opta ILVE Institucional" + ",";
                }


                

                if (asesoriaAux.getHavcremind() != null && 
                    asesoriaAux.getHavcremind().equals("S")) {
                    CONDUCTA = CONDUCTA + "Indecisi�n" + ",";
                }

                if (asesoriaAux.getHavcremcos() != null && 
                    asesoriaAux.getHavcremcos().equals("S")) {
                    CONDUCTA = CONDUCTA + "Capacidad de pago limitada" + ",";
                }

                if (asesoriaAux.getHavcremeps() != null && 
                    asesoriaAux.getHavcremeps().equals("S")) {
                    CONDUCTA = CONDUCTA + "Va a usar EPS" + ",";
                }

                if (asesoriaAux.getHavcremips() != null && 
                    asesoriaAux.getHavcremips().equals("S")) {
                    CONDUCTA = CONDUCTA + "Va a usar otra I.P.S" + ",";
                }

                if (asesoriaAux.getHavcremcau() != null && 
                    asesoriaAux.getHavcremcau().equals("S")) {
                    CONDUCTA = CONDUCTA + "No aplica causal" + ",";
                }

                if (asesoriaAux.getHavcremmay() != null && 
                    asesoriaAux.getHavcremmay().equals("S")) {
                    CONDUCTA = CONDUCTA + "Remisi�n por edad gestacional" + ",";
                    
                    if(asesoriaAux.getHavnedages()!= null){
                        CONDUCTA = CONDUCTA + "Cu�ntas semanas: "+formatearCampo(asesoriaAux.getHavnedages())+ ",";
                    }
                }

                if (asesoriaAux.getHavcremcon() != null && 
                    asesoriaAux.getHavcremcon().equals("S")) {
                    CONDUCTA = CONDUCTA + "Desea continuar embarazo" + ",";
                }

                if (asesoriaAux.getHavcremotr() != null && 
                    asesoriaAux.getHavcremotr().equals("S")) {
                    CONDUCTA = CONDUCTA + "Otro" + ",";
                    if(asesoriaAux.getHavcnmbotr()!= null){
                        CONDUCTA = CONDUCTA + " Cual? "+formatearCampo(asesoriaAux.getHavcnmbotr())+ ",";
                    }
                }
                
                
                if (asesoriaAux.getHavcremapl() != null && 
                    asesoriaAux.getHavcremapl().equals("S")) {
                    CONDUCTA = CONDUCTA + "   Aplaza la decisi�n" + ",";
                    if(asesoriaAux.getHavcremmot()!= null){
                        CONDUCTA = CONDUCTA + "Motivo? "+formatearCampo(asesoriaAux.getHavcremmot())+ ",";
                    }
                }


                if (CONDUCTA != null && !CONDUCTA.equals("")) {
                    CONDUCTA = CONDUCTA.substring(0, CONDUCTA.length() - 1);
                } else {
                    CONDUCTA = "Ninguna";
                }
              
            
          

               

                if (asesoriaAux.getHnseguavis() != null && 
                    !asesoriaAux.getHnseguavis().isEmpty()) {

                    Iterator it = asesoriaAux.getHnseguavis().iterator();
                    SEGUIMIENTO = "";

                    while (it.hasNext()) {
                        Chseguavis seguiAux = (Chseguavis)it.next();

        
                                
                           StringBuffer sb = new StringBuffer(); 
                        sb.append("Fecha del seguimiento: " + formatearCampo(seguiAux.getHsadfecreg()) ); 
                        sb.append("\n" + "Asesor: " + seguiAux.getHsacasesor());     
                        if(seguiAux.getHsansemest() != null){
                            sb.append("\n" + "Semanas estimadas: " + formatearCampo(seguiAux.getHsansemest()));     
                        }
                        
                        if(seguiAux.getHsadfececo() != null){
                            sb.append("\n" + "Fecha Ecografia: " + formatearCampo(seguiAux.getHsadfececo())); 
                        }
                        
                        if(seguiAux.getHsansemeco() != null){
                            sb.append("\n" + "Semanas Ecografia: " + formatearCampo(seguiAux.getHsansemeco())); 
                        }
                        
                        if(seguiAux.getHsacmetant() != null){
                            sb.append("\n" + "Metodo de Anticoncepci�n: " + formatearCampo(seguiAux.getHsacmetant())); 
                        }
                        
                        if(seguiAux.getHsaccousan() != null && seguiAux.getHsaccousan().equals("N")){
                            sb.append("\n" + "Confirma Procedimiento Institucional: " + formatearCampo(seguiAux.getHsaccousan())); 
                            if(seguiAux.getHsacotrins() != null){
                                sb.append("     Cual Instituci�n: ").append( seguiAux.getHsacotrins());    
                            }
                            
                            
                        }
                        
                        
                        if(seguiAux.getHsaccousan() != null && seguiAux.getHsaccousan().equals("S")){
                            sb.append("\n" + "Confirma Procedimiento Institucional: " + formatearCampo(seguiAux.getHsaccousan())  ); 
                        }
                        
                        if(seguiAux.getHsacseguim() != null){
                            sb.append("\n" +"Seguimiento: " + seguiAux.getHsacseguim()); 
                        }
                            sb.append("\n" + "Acci�n: " + obtenerAccion(seguiAux) + "\n"); 
                        
                        
                        sb.append("\n"); 

                                
                        SEGUIMIENTO = 
                                SEGUIMIENTO + sb.toString(); 
                    }
                }


                if (asesoriaAux.getHavnlugech() != null) {
                    try {
                        LUGAR_HECHOS = 
                                this.serviceLocator.getClinicoService().getDescripcionLugarHechosAvise(asesoriaAux.getHavnlugech());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_ARCHIVOS);
                    }
                }

                if (asesoriaAux.getHavcotrlug() != null && 
                    !asesoriaAux.getHavcotrlug().equals("")) {
                    CUAL_LUGAR = formatearCampo(asesoriaAux.getHavcotrlug());
                }

                if (asesoriaAux.getHavntieocu() != null) {
                    try {
                        TIEMPO_OCURRENCIA = 
                                this.serviceLocator.getClinicoService().getDescripcionTiempoHechosAvise(asesoriaAux.getHavntieocu());
                    } catch (ModelException e) {
                        return capturaError(e,IConstantes.ERROR_COSNULTA);
                    }
                    
                    if(asesoriaAux.getHavndiaeve() != null){
                        OTRO_TIEMPO = formatearCampo(asesoriaAux.getHavndiaeve()); 
                    }
                }
                ACCIONES_PREVIAS = "";
                if (asesoriaAux.getHavcaccnin() != null && 
                    asesoriaAux.getHavcaccnin().equals("S")) {
                    ACCIONES_PREVIAS = "Ninguna" + ",";
                }

                if (asesoriaAux.getHavcaccden() != null && 
                    asesoriaAux.getHavcaccden().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Denuncia Penal " + ",";
                }

                if (asesoriaAux.getHavcaccate() != null && 
                    asesoriaAux.getHavcaccate().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Busco atenci�n m�dica " + ",";
                }
                
                
                if (asesoriaAux.getHaveantem() != null && 
                    asesoriaAux.getHaveantem().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Us� anticoncepci�n de emergencia " + ",";
                }

                if (asesoriaAux.getHavcaccapo() != null && 
                    asesoriaAux.getHavcaccapo().equals("S")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS + " Busco apoyo de otra persona " + 
                            ",";
                }

              

                if (asesoriaAux.getHaveaccot() != null && 
                    asesoriaAux.getHaveaccot().equals("S")) {
                    ACCIONES_PREVIAS = ACCIONES_PREVIAS + " Otro ";
                    
                    CUAL_ACCION_PREVIA = "Cual: " +  formatearCampo(asesoriaAux.getHavcotracc()); 
                    
                    ACCIONES_PREVIAS = ACCIONES_PREVIAS + CUAL_ACCION_PREVIA + ","; 
                }

                if (ACCIONES_PREVIAS != null && !ACCIONES_PREVIAS.equals("")) {
                    ACCIONES_PREVIAS = 
                            ACCIONES_PREVIAS.substring(0, ACCIONES_PREVIAS.length() - 
                                                       1);
                }


            }


        }

        setDatos(asesoriaAux);
        return null;

    }


    public void setDatos(Chaseavise asesoriaAux) {

        if (asesoriaAux != null) {
        
        
            String s = "Asesor: " +  NOMBRE_ASESOR;
            String s2 = "Cl�nica:  " + CLINICA_ASESORIA;
            
            String s3 = "";
            String s4 = ""; 

            Chreporte report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Datos Asesor�a");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_datos_asesoria);
            lstReporte.add(report);
            
            
            s = "Fecha Asesor�a: " + FECHA_ASESORIA;
            s2 = "Fecha Registro: " + FECHA_REGISTRO;
            s3 = "";
            s4 = ""; 
            
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrecdescripcio2(s2);
            report.setHrentipoimpres(2);
            report.setHrectipodescri("Datos Asesor�a");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_datos_asesoria);
            lstReporte.add(report);
            
            
        
             s = "Conocimiento del programa:  " + CONOCIMIENTO_PROGRAMA;
             s2 = "C�al? " + CUAL_CONOCIMIENTO;
             s3 = "";
             s4 = ""; 

             report = new Chreporte();
            report.setHrecdescripcio(s);
            if (CUAL_CONOCIMIENTO != null && !CUAL_CONOCIMIENTO.equals("")) {
                report.setHrecdescripcio2(s2);
            }

            report.setHrentipoimpres(2);
            report.setHrectipodescri("Conocimiento del Programa");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_conocimiento_programa);
            lstReporte.add(report);

             s = "Intervenci�n Asesor�a:  " + INTERVENCION_ASESORIA;
            

            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Intervenci�n Asesor�a");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_intervencion_asesoria);
            lstReporte.add(report);
            
            
          
            s = "Tipo de Intervencion: " + TIPO_ASESORIA;
            report = new Chreporte();
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Intervenci�n Asesor�a");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_intervencion_asesoria);
            lstReporte.add(report);


            if (AGRESOR_CONOCIDO != null && !AGRESOR_CONOCIDO.equals("")) {
                report = new Chreporte();
                s = "Agresor/a Conocido:  " + AGRESOR_CONOCIDO;
                s2 = "Relaci�n: " +RELACION_AGRESOR; 
                
                if(PARENTESCO_AGRESOR!= null && !PARENTESCO_AGRESOR.equals("")){
                    s3 = "Parentesco: " + PARENTESCO_AGRESOR; 
                }else if(CUAL_RELACION != null && !CUAL_RELACION.equals("")){
                    s3 = "Cual Relaci�n? " + CUAL_RELACION; 
                }
               
                s4 = "Cual? " + CUAL_PARENTESCO; 
              
                report = new Chreporte();
                report.setHrentipoimpres(4);
                report.setHrecdescripcio(s);
                if(RELACION_AGRESOR!= null && !RELACION_AGRESOR.equals("")){
                    report.setHrecdescripcio2(s2);    
                }
               
                if((PARENTESCO_AGRESOR!= null && !PARENTESCO_AGRESOR.equals("")) ||(CUAL_RELACION!= null && !CUAL_RELACION.equals("")) ){
                    report.setHrecdescripcio3(s3);
                }
                if(CUAL_PARENTESCO!= null && !CUAL_PARENTESCO.equals("")){
                    report.setHrecdescripcio4(s4);
                }
                
                report.setHrectipodescri("Intervenci�n Asesor�a");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }


            if (LUGAR_HECHOS != null && !LUGAR_HECHOS.equals("")) {
                report = new Chreporte();
                s = "Lugar de los hechos:  " + LUGAR_HECHOS;
                s2 = "Cu�l? " + CUAL_LUGAR;
                report.setHrecdescripcio(s);
                if (CUAL_LUGAR != null && !CUAL_LUGAR.equals("")) {
                    report.setHrecdescripcio2(s2);
                }

                report.setHrentipoimpres(2);
                report.setHrectipodescri("Intervenci�n Asesor�a");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }

            if (TIEMPO_OCURRENCIA != null && !TIEMPO_OCURRENCIA.equals("")) {
                report = new Chreporte();
                s = "Tiempo de Ocurrencia:  " + TIEMPO_OCURRENCIA;
                s2 = "Cuantos (d�as) : "+ OTRO_TIEMPO; 
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(2);
                if(OTRO_TIEMPO!= null && !OTRO_TIEMPO.equals("")){
                    report.setHrecdescripcio2(s2);    
                }
                report.setHrectipodescri("Intervenci�n Asesor�a");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }

            if (ACCIONES_PREVIAS != null && !ACCIONES_PREVIAS.equals("")) {
                report = new Chreporte();
                s = "Acciones previas:  " + ACCIONES_PREVIAS;
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Intervenci�n Asesor�a");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_intervencion_asesoria);
                lstReporte.add(report);
            }


            report = new Chreporte();
            s = "Area Afectiva:  " + AREA_AFECTIVA;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Valoraci�n estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);

            report = new Chreporte();
            s = "Area Som�tica:  " + AREA_SOMATICA;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Valoraci�n estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);

            report = new Chreporte();
            s = "Area Relacional/Social:  " + AREA_RELACIONAL;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Valoraci�n estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);

            report = new Chreporte();
            s = "Area Cognitiva:  " + AREA_COGNITIVA;
            report.setHrecdescripcio(s);
            report.setHrentipoimpres(1);
            report.setHrectipodescri("Valoraci�n estado psicoemocional de la usuaria por esferas");
            report.setHrenconsulta(new Long(0));
            report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
            report.setHrencodigo(imp_estado_psicoemocional);
            lstReporte.add(report);


            if (DOCUMENTOS_PRESENTADOS != null && 
                !DOCUMENTOS_PRESENTADOS.equals("")) {
                s = DOCUMENTOS_PRESENTADOS;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Documentos Presentados");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_documentos_presentados);
                lstReporte.add(report);
            }

            if (DOCUMENTOS_REMISION_INSTITUCION != null && 
                !DOCUMENTOS_REMISION_INSTITUCION.equals("")) {
                s = DOCUMENTOS_REMISION_INSTITUCION;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Documentos Presentados");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_documentos_presentados);
                lstReporte.add(report);
            }

            if (DOCUMENTO_OTRO != null && !DOCUMENTO_OTRO.equals("")) {
                s = DOCUMENTO_OTRO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Documentos Presentados");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_documentos_presentados);
                lstReporte.add(report);
            }

            if (HALLAZGOS != null && !HALLAZGOS.equals("")) {
                s = HALLAZGOS;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Hallazgos");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_hallazgos);
                lstReporte.add(report);
            }
            
            if (CONCEPTO_PSICOLOGICO != null && !CONCEPTO_PSICOLOGICO.equals("")) {
                s = CONCEPTO_PSICOLOGICO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Concepto Psicologico");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_concepto_psicologico);
                lstReporte.add(report);
            }
            
            if(INTERVENCION_CRISIS!= null && !INTERVENCION_CRISIS.equals("")){
               s = "Se realizo intervenci�n en crisis:  "  + INTERVENCION_CRISIS; 
               
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Hallazgos");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_hallazgos);
                lstReporte.add(report);
            }

            if (CONDUCTA != null && !CONDUCTA.equals("")) {


                s = "Remisiones: " + CONDUCTA;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Conducta");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_conducta_a_seguir);
                lstReporte.add(report);
            }




            if (SEGUIMIENTO != null && !SEGUIMIENTO.equals("")) {
                s = SEGUIMIENTO;
                report = new Chreporte();
                report.setHrecdescripcio(s);
                report.setHrentipoimpres(1);
                report.setHrectipodescri("Seguimiento");
                report.setHrenconsulta(new Long(0));
                report.setHredfecharegis(asesoriaAux.getId().getHavdfecase());
                report.setHrencodigo(imp_seguimiento);
                lstReporte.add(report);
            }


        } else {
            Chreporte report = new Chreporte();
            String s = "No se encontrar�n folios ";

            report.setHrecdescripcio(s);
            report.setHrencodigo(0);
            lstReporte.add(report);
        }

    }


    public void resetDatos() {
    
        FECHA_ASESORIA = null; 
        FECHA_REGISTRO = null; 
        NOMBRE_ASESOR = null; 
        CLINICA_ASESORIA = null; 
        TIPO_DOCUMENTO = null;
        NUMERO_DOCUMENTO = null;
        IMPRIMIO = null;
        NOMBRE = null;
        FECHA_NACIMIENTO = null;
        EDAD = null;
        SEXO = null;
        DIRECCION = null;
        TELEFONO = null;
        CIUDAD = null;
        OCUPACION = null;
        ESTADO_CIVIL = null;
        RESPONSABLE = null;
        PARENTESCO_RESPONSABLE = null;
        TELEFONO_RESPONSABLE = null;
        FECHA_CONSULTA = null;
        NOMBRE_PROFESIONAL = null;
        REGISTRO_MEDICO = null;
        CENTRO = null;
        EPS = null;

        INTERVENCION_ASESORIA = null;
        AREA_AFECTIVA = null;
        AREA_SOMATICA = null;
        AREA_RELACIONAL = null;
        AREA_COGNITIVA = null;

        DOCUMENTOS_PRESENTADOS = null;
        DOCUMENTOS_REMISION_INSTITUCION = null;
        DOCUMENTO_OTRO = null;
        HALLAZGOS = null;
        INTERVENCION_CRISIS = null; 
        CONDUCTA = null;

 
        SEGUIMIENTO = null;
        AGRESOR_CONOCIDO = null;

        LUGAR_HECHOS = null;
        CUAL_LUGAR = null;
        TIEMPO_OCURRENCIA = null;

        TIPO_ASESORIA = null;
        
        CUAL_CONOCIMIENTO = null; 
        CONOCIMIENTO_PROGRAMA = null; 
        
        AGRESOR_CONOCIDO = null;
        RELACION_AGRESOR = null; 
        PARENTESCO_AGRESOR = null; 
        CUAL_PARENTESCO = null; 
        CUAL_RELACION = null; 
        OTRO_TIEMPO = null; 
    }


    public String generarResumenAsesoria(Chaseavise asesoriaAux) {
        this.index = -1;
        lstReporte = new ArrayList<Chreporte>();

        try {
            obtenerDatosReporte(asesoriaAux);
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteAsesoria.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "Resumen_Asesoria" + ".pdf", 
                                                false);
                generoHistoria = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return capturaError(e,IConstantes.ERROR_REPORTES);
        }

return null;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------

    public void imprimirAsesoria() {
        Chaseavise aseSelect;
        aseSelect = (Chaseavise)this.dtAsesoria.getRowData();
        if (aseSelect != null) {
            generarResumenAsesoria(aseSelect);
        }
    }
    
    private String obtenerAccion(Chseguavis seguiAux){
        String accion = "";

        if (seguiAux.getHsacremilv() != null &&
            seguiAux.getHsacremilv().equals("S")) {
            accion = accion + "Opta ILVE Institucional" + ",";
        }


        

        if (seguiAux.getHsacremind() != null && 
            seguiAux.getHsacremind().equals("S")) {
            accion = accion + "Indecisi�n" + ",";
        }

        if (seguiAux.getHsacremcos() != null && 
            seguiAux.getHsacremcos().equals("S")) {
            accion = accion + "Capacidad de pago limitada" + ",";
        }

        if (seguiAux.getHsacremeps() != null && 
            seguiAux.getHsacremeps().equals("S")) {
            accion = accion + "Va a usar EPS" + ",";
        }

        if (seguiAux.getHsacremips() != null && 
            seguiAux.getHsacremips().equals("S")) {
            accion = accion + "Va a usar otra I.P.S" + ",";
        }

        if (seguiAux.getHsacremcau() != null && 
            seguiAux.getHsacremcau().equals("S")) {
            accion = accion + "No aplica causal" + ",";
        }

        if (seguiAux.getHsacremmay() != null && 
            seguiAux.getHsacremmay().equals("S")) {
            accion = accion + "Remisi�n por edad gestacional" + ",";
            
            if(seguiAux.getHsanedages()!= null){
                accion = accion + "Cu�ntas semanas: "+formatearCampo(seguiAux.getHsanedages())+ ",";
            }
        }

        if (seguiAux.getHsacremcon() != null && 
            seguiAux.getHsacremcon().equals("S")) {
            accion = accion + "Desea continuar embarazo" + ",";
        }

        if (seguiAux.getHsacremotr() != null && 
            seguiAux.getHsacremotr().equals("S")) {
            accion = accion + "Otro" + ",";
            if(seguiAux.getHsacnmbotr()!= null){
                accion = accion + " Cual? "+formatearCampo(seguiAux.getHsacnmbotr())+ ",";
            }
        }
        
        
        if (seguiAux.getHsacremapl() != null && 
            seguiAux.getHsacremapl().equals("S")) {
            accion = accion + "   Aplaza la decisi�n" + ",";
            if(seguiAux.getHsacremmot()!= null){
                accion = accion + "Motivo? "+formatearCampo(seguiAux.getHsacremmot())+ ",";
            }
        }


        if (accion  != null && !accion.equals("")) {
            accion = accion.substring(0, accion.length() - 1);
        } else {
            accion = "Ninguna";
        }
        
        return accion; 
    }


}
