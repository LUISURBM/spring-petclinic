//=======================================================================
// ARCHIVO AntecedentesTemporalesUsuario
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcuestplani;
import org.profamilia.hc.model.dto.ChcuestplaniPK;
import org.profamilia.hc.model.dto.Chmetodoplan;
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
public class AntecedentesTemporalesUsuario extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    /** Variable que almacena true si ya se guardo los antecedentes temporales y por tal motivo se vuelve modo consulta */
    private boolean modoconsulta;

    private int index = -1;

    /** Almacena la lista de los metodos  de planificacion  */
    private List lstMetodo;

    /** Almacena el metodo seleccionado*/
    private String metodoSelect;

    private boolean generoConsentimiento;


    /** Almacena la lista de opciones 'S' SI o 'N' NO */
    private List lstOpciones;

    /** Almacena el objeto cuestionario planificacion a persistir*/
    private Chcuestplani cuestionario;

    /** Almacena true si debe mostrar los metodos de planificacion*/
    private boolean mostrarMetodos;

    /** Alamcena true si la usuaria ha tenido partos y/o Abortos*/
    private boolean mostrarFecha;

    /** Almacena true si los datos ingresados son correctos*/
    private boolean wexito;

    private Integer tipoHistoria;

    private String navigationRule;

    private String tipoServicio;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;

    private AntecedentesGinecologicosUsuarioBean ginecologicos;

    private Long numeroConsulta;
    
    
    private UIInput mnuHcpcmetotempla;
    private UIInput mnuHcpcmetodefpla;
    
    private UIInput mnuHcpcembarazada;
        
    private UIInput mnuHcpcfallametem;
    
    private UIInput mnuHcpcinfometoso;
    
    private UIInput mnuHcpcmetintemb;
    
    
  


    String NOMBRE_USUARIO;
    Long NUMERO_DOCUMENTO;
    String TIPO_DOCUMENTO;
    Date FECHA;
    String CENTRO;
    String NOMBRE_PROFESIONAL;
    String METODO_PLAN;
    String INFO_METODO_TEMPORAL;
    String INFO_METODO_DEFINITIVO;
    String ESTA_EMBARAZADA;
    String REGLA_NORMAL;
    String METODOS_TEMPORALES_FALLA;
    String INFORMACION_CONSENTIMIENTO;
    String UTILIZA_METODO_PLANIFICACION;
    String HA_TENIDO_PARTOS;
    Date FUR;
    Date FUP;
    String METODOS_TEMPORALES_NO_INTERRUPCION_EMBARAZO;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------


    public AntecedentesTemporalesUsuario() {
    }

    public void init() {
        generoConsentimiento = false;
        nextAction = "";
    }

    public void inicializarAntecedentes() {
        try {
            if (numeroConsulta != null) {
                cuestionario = 
                        serviceLocator.getClinicoService().getCuestionarioPlanificacion(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (cuestionario == null) {
            cuestionario = new Chcuestplani();
            modoconsulta = false;
        } else {
            modoconsulta = true;
           
           
            cuestionario.setHcpcoperador(userName());
            cuestionario.setHcpdfecregistr(new Date());

        }
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < 1);
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
        if (fieldName.equals("METODO_PLAN")) {
            value = METODO_PLAN;
        }
        if (fieldName.equals("INFO_METODO_TEMPORAL")) {
            value = INFO_METODO_TEMPORAL;
        }
        if (fieldName.equals("INFO_METODO_DEFINITIVO")) {
            value = INFO_METODO_DEFINITIVO;
        }
        if (fieldName.equals("ESTA_EMBARAZADA")) {
            value = ESTA_EMBARAZADA;
        }
        if (fieldName.equals("REGLA_NORMAL")) {
            value = REGLA_NORMAL;
        }
        if (fieldName.equals("METODOS_TEMPORALES_FALLA")) {
            value = METODOS_TEMPORALES_FALLA;
        }
        if (fieldName.equals("INFORMACION_CONSENTIMIENTO")) {
            value = INFORMACION_CONSENTIMIENTO;
        }
        if (fieldName.equals("UTILIZA_METODO_PLANIFICACION")) {
            value = UTILIZA_METODO_PLANIFICACION;
        }
        if (fieldName.equals("HA_TENIDO_PARTOS")) {
            value = HA_TENIDO_PARTOS;
        }
        if (fieldName.equals("FUR")) {
            value = FUR;
        }
        if (fieldName.equals("FUP")) {
            value = FUP;
        }
        return value;
    }


    /**
     * @param mnuHcpcmetotempla
     */
    public void setMnuHcpcmetotempla(UIInput mnuHcpcmetotempla) {
        this.mnuHcpcmetotempla = mnuHcpcmetotempla;
    }

    /**
     * @return
     */
    public UIInput getMnuHcpcmetotempla() {
        return mnuHcpcmetotempla;
    }

    /**
     * @param mnuHcpcmetodefpla
     */
    public void setMnuHcpcmetodefpla(UIInput mnuHcpcmetodefpla) {
        this.mnuHcpcmetodefpla = mnuHcpcmetodefpla;
    }

    /**
     * @return
     */
    public UIInput getMnuHcpcmetodefpla() {
        return mnuHcpcmetodefpla;
    }

    /**
     * @param mnuHcpcembarazada
     */
    public void setMnuHcpcembarazada(UIInput mnuHcpcembarazada) {
        this.mnuHcpcembarazada = mnuHcpcembarazada;
    }

    /**
     * @return
     */
    public UIInput getMnuHcpcembarazada() {
        return mnuHcpcembarazada;
    }

  

    /**
     * @param mnuHcpcfallametem
     */
    public void setMnuHcpcfallametem(UIInput mnuHcpcfallametem) {
        this.mnuHcpcfallametem = mnuHcpcfallametem;
    }

    /**
     * @return
     */
    public UIInput getMnuHcpcfallametem() {
        return mnuHcpcfallametem;
    }

    /**
     * @param mnuHcpcinfometoso
     */
    public void setMnuHcpcinfometoso(UIInput mnuHcpcinfometoso) {
        this.mnuHcpcinfometoso = mnuHcpcinfometoso;
    }

    /**
     * @return
     */
    public UIInput getMnuHcpcinfometoso() {
        return mnuHcpcinfometoso;
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
     * @param lstMetodo
     */
    public void setLstMetodo(List lstMetodo) {
        this.lstMetodo = lstMetodo;
    }

    /**
     * @return
     */
    public List getLstMetodo() {
        if (lstMetodo == null || lstMetodo.isEmpty()) {
            lstMetodo = new ArrayList();
            ArrayList<Chmetodoplan> lstMetodoAux = null;
            try {
                lstMetodoAux = 
                        (ArrayList<Chmetodoplan>)this.serviceLocator.getClinicoService().getMetodosPlanificacion(SEXO_FEMENINO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstMetodoAux.isEmpty()) {

                Iterator it = lstMetodoAux.iterator();
                int i = 0;
                lstMetodo.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstMetodo.add(new SelectItem(lstMetodoAux.get(i).getHmpccodigo(), 
                                                 lstMetodoAux.get(i).getHmpcdescripcio()));
                    i++;
                }
            }
        }

        return lstMetodo;
    }


    /**
     * @param generoConsentimiento
     */
    public void setGeneroConsentimiento(boolean generoConsentimiento) {
        this.generoConsentimiento = generoConsentimiento;
    }

    /**
     * @return
     */
    public boolean isGeneroConsentimiento() {
        return generoConsentimiento;
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
     * @param mostrarMetodos
     */
    public void setMostrarMetodos(boolean mostrarMetodos) {
        this.mostrarMetodos = mostrarMetodos;
    }

    /**
     * @return
     */
    public boolean isMostrarMetodos() {
        return mostrarMetodos;
    }

    /**
     * @param metodoSelect
     */
    public void setMetodoSelect(String metodoSelect) {
        this.metodoSelect = metodoSelect;
    }

    /**
     * @return
     */
    public String getMetodoSelect() {
        return metodoSelect;
    }


    /**
     * @param mostrarFecha
     */
    public void setMostrarFecha(boolean mostrarFecha) {
        this.mostrarFecha = mostrarFecha;
    }

    /**
     * @return
     */
    public boolean isMostrarFecha() {
        return mostrarFecha;
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


    public void generarConsentimiento() {
        this.index = -1;
        obtenerDatos();

        try {
           URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/cuestionarioPlanificacion.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                

                byte[] bytes;
                
                JasperReport report = (JasperReport) JRLoader.loadObject(url); 
                
                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, 
                                                        (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);

                generoConsentimiento = true;
                modoconsulta = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
    }


    public void changeTodosSi() {  
            mostrarFecha = true;
            mostrarMetodos = true;
            inicializarPreguntas("S");
    }

    public void changeTodosNo() {
        if (!modoconsulta) {
            mostrarFecha = false;
            mostrarMetodos = false;
            inicializarPreguntas("N");
            cuestionario.setHcpdfechultmes(null);
            cuestionario.setHcpcmetodoplan(null);
            cuestionario.setHcpdfechaparto(null);
        }
    }


    public void changeNinguno() {
        if (!modoconsulta) {
            mostrarFecha = false;
            mostrarMetodos = false;
            inicializarPreguntas(null);
            cuestionario.setHcpdfechultmes(null);
            cuestionario.setHcpcmetodoplan(null);
            cuestionario.setHcpdfechaparto(null);
        }
    }
    
    /**
     * @param opcion
     */
    public void inicializarPreguntas(String opcion) {

        if (cuestionario != null && !modoconsulta) {

            mnuHcpcmetotempla.setValue(opcion);
            mnuHcpcmetodefpla.setValue(opcion);
            mnuHcpcembarazada.setValue(opcion);
            mnuHcpcfallametem.setValue(opcion);
            mnuHcpcinfometoso.setValue(opcion);
            mnuHcpcmetintemb.setValue(opcion);
         
            cuestionario.setHcpcmetotempla(opcion);
            cuestionario.setHcpcmetodefpla(opcion);
            cuestionario.setHcpcembarazada(opcion);
            cuestionario.setHcpcfallametem(opcion);
            cuestionario.setHcpcinfometoso(opcion);
            cuestionario.setHcpcmetintemb(opcion);
          
   }

    }




    public void setCuestionario(Chcuestplani cuestionario) {
        this.cuestionario = cuestionario;
    }

    /**
     * @return
     */
    public Chcuestplani getCuestionario() {
        return cuestionario;
    }


    public void changeMetodoPlanificacion() {
        mostrarMetodos = true;
    }





    public void obtenerDatos() {

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

        NOMBRE_PROFESIONAL = this.getUsuarioSystem().getCurcnombre();

        if (cuestionario != null) {
            String codigo = cuestionario.getHcpcmetodoplan();
            if (codigo != null) {
                if (codigo.equals("697100")) {
                    METODO_PLAN = "DIU";
                } else if (codigo.equals("697101")) {
                    METODO_PLAN = "DIU";
                } else if (codigo.equals("890201.1")) {
                    METODO_PLAN = "Inyectable M. ";
                } else if (codigo.equals("890201.2")) {
                    METODO_PLAN = "Inyectable T. ";
                } else if (codigo.equals("890201.12")) {
                    METODO_PLAN = "Jadelle ";
                } else if (codigo.equals("890201.6")) {
                    METODO_PLAN = "�vulos ";
                } else if (codigo.equals("890201.4")) {
                    METODO_PLAN = "Pildoras ";
                } else if (codigo.equals("890201.5")) {
                    METODO_PLAN = "Preservativos ";
                } else if (codigo.equals("699101.5")) {
                    METODO_PLAN = "Kyleena ";
                }
            }


            INFO_METODO_TEMPORAL = cuestionario.getHcpcmetotempla();
            INFO_METODO_DEFINITIVO = cuestionario.getHcpcmetodefpla();
            ESTA_EMBARAZADA = cuestionario.getHcpcembarazada();
            METODOS_TEMPORALES_FALLA = cuestionario.getHcpcfallametem();
            METODOS_TEMPORALES_NO_INTERRUPCION_EMBARAZO = cuestionario.getHcpcmetintemb();
            INFORMACION_CONSENTIMIENTO = cuestionario.getHcpcinfometoso();
            
            FUR = cuestionario.getHcpdfechultmes();
            FUP = cuestionario.getHcpdfechaparto();
        }


    }

    public boolean esValido() {
        boolean esValido = false;
        Chcuestplani cuestionarioAux = null;
        if (numeroConsulta != null) {
            try {
                cuestionarioAux = 
                        serviceLocator.getClinicoService().getCuestionarioPlanificacion(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
        if (cuestionarioAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }
    
    
    /**
     * @return
     */
    public String continuar() {
       generoConsentimiento = false; 
       return nextAction;
    }


    public String aceptar() {
        navigationRule = "";
        wexito = true;
        ChcuestplaniPK id = new ChcuestplaniPK();
        if (numeroConsulta != null) {
            id.setHcplconsulta(numeroConsulta);
            id.setHcpctiposervi(tipoServicio);
            cuestionario.setId(id);
        }
        
            
        if(cuestionario!= null){
        


        Date fechacomp = new Date();

        if (cuestionario.getHcpdfechultmes() != null && 
            cuestionario.getHcpdfechultmes().after(fechacomp)) {
            wexito = false;
            FacesUtils.addErrorMessage(IMsg.MSG_FECHA_ULTIMA_REGLA_NO_VALIDA);
        }

        if (cuestionario.getHcpdfechaparto() != null && 
            cuestionario.getHcpdfechaparto().after(fechacomp)) {
            wexito = false;
            FacesUtils.addErrorMessage(IMsg.MSG_FECHA_ULTIMO_PARTO_NO_VALIDA);
        }
        cuestionario.setHcpcoperador(userName());
        cuestionario.setHcpdfecregistr(new Date());

        ginecologicos = 
                (AntecedentesGinecologicosUsuarioBean)FacesUtils.getManagedBean("antecedentesGinecologicosUsuarioBean");
        ginecologicos.inicializarAntecedentesGinecologicos();
        if (ginecologicos != null && ginecologicos.getAntecedente() != null) {
            ginecologicos.getAntecedente().setHagdfup(cuestionario.getHcpdfechaparto());
            ginecologicos.getAntecedente().setHagdfur(cuestionario.getHcpdfechultmes());
            ginecologicos.getAntecedente().setHagcmetodoplan(cuestionario.getHcpcmetodoplan());
        }


        if (wexito) {
            try {
                serviceLocator.getClinicoService().saveCuestionarioPlanificacion(cuestionario);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                navigationRule = nextAction;
                FacesUtils.resetManagedBean(menuBean);

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
                navigationRule = null;
            }

        }
       

    }
        return navigationRule;


    }

    public void setMnuHcpcmetintemb(UIInput mnuHcpcmetintemb) {
        this.mnuHcpcmetintemb = mnuHcpcmetintemb;
    }

    public UIInput getMnuHcpcmetintemb() {
        return mnuHcpcmetintemb;
    }
}
