//=======================================================================
// ARCHIVO AplicacionEspermogramaBean.java
// FECHA CREACI�N: 29/09/2016
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la aplicacion de Espermograma
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

import java.net.URL;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chespervasec;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE AplicacionEspermogramaBean
//=======================================================================
public class AplicacionEspermogramaBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    private Chusuario usuario;
    private Chespervasec espevasec;
    private Cnconsclin consulta;
    private String nextAction;
    private String menuBean;
    private String tipoServicio;
    private String navigationRule;
    private Cpservicio codigoServicio;
    private List lstResultado;
    private Chconsulta hsEspermograma;
    private boolean generoEspermograma;
//    private boolean modoconsulta;
    private boolean consultaCerrada;
    private int index = -1;

    // Datos para el reporte 
    String NOMBRES;
    String PRIMER_APELLIDO;
    String SEGUNDO_APELLIDO;
    String TIPO_DOCUMENTO;
    Long NUMERO_DOCUMENTO;
    String ANO;
    String MES;
    String DIA;
    Integer EDAD;
    Date fecha;
    String RESULTADO_ESPERMOGRAMA;
    String OBSERVACIONES_ESPERMOGRAMA;
    String RECUENTO_ESPERMATOZOIDES;
    String NOMBRE_USUARIO;
    String NOMBRE_PROFESIONAL;
    String REGISTRO_MEDICO; 


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public AplicacionEspermogramaBean() {
    }

    public void init() {
        inicalizarAplicacionBean();
    }
    //ACTIONS

    public void inicalizarAplicacionBean() {
        generoEspermograma = false; 
        consultaCerrada = false;
        if (usuario != null && usuario.getHuslnumero() != null) {
            try {
                if (consulta != null) {
                    espevasec = 
                            this.getServiceLocator().getClinicoService().getAdministracionEspermograma(consulta.getCconnumero().longValue());
                    hsEspermograma = this.getServiceLocator().getClinicoService().getConsultaActual(consulta.getCconnumero().longValue());        
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (espevasec == null) {
                espevasec = new Chespervasec();
                espevasec.setHevlconsulta(consulta.getCconnumero().longValue());
                espevasec.setHevdfecregistr(new Date());
                espevasec.setHevcoperador(userName());
                espevasec.setHevctiposervi("C");
            } 
            
            if (hsEspermograma != null && IConstantes.ETAPA_CERRADA.equals(hsEspermograma.getHcoeetapa())) {
                consultaCerrada = true;
            }
        }
    }

    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 

    public String guardar() {
        navigationRule = "";
        index = -1; 

        try {
            this.serviceLocator.getClinicoService().saveAplicacionEspermograma(espevasec, consulta);
            CerrarConsultaUsuarioBean cerrarConsultaEspermogramaBean = 
                    (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
            cerrarConsultaEspermogramaBean.inicalizarCerrarConsultaBean();


            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
//        imprimirEspermograma();
//        return BeanNavegacion.RUTA_IR_CERRAR_ESPERMOGRAMA;
        return nextAction;      
    }

    public void imprimirEspermograma() {    
        try {
            obtenerDatosReporteConsulta();
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/espermvasec_v3.jasper");
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
                bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, "Espermograma" + Calendar.getInstance().getTimeInMillis() + 
                                                ".pdf", false);
                generoEspermograma = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + e.getMessage());
        }
    }
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------


    public boolean esValido() {
        Chespervasec espermogramaAux = null;

        if (consulta != null && consulta.getCconnumero() != null) {
            try {
                espermogramaAux = 
                        this.getServiceLocator().getClinicoService().getAdministracionEspermograma(consulta.getCconnumero().longValue());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (espermogramaAux != null && !IConstantes.ETAPA_ABIERTO.equals(consulta.getCcocetapa())) {
            return true;
        }
        return false;
    }
        

    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Accesorios
    //-----------------------------------------------------------------------


    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }


    public void setCodigoServicio(Cpservicio codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public Cpservicio getCodigoServicio() {
        return codigoServicio;
    }

    public void setLstResultado(List lstResultado) {
        this.lstResultado = lstResultado;
    }

    public List getLstResultado() {
        if(lstResultado == null || lstResultado.isEmpty()){
            lstResultado = new ArrayList();
            lstResultado.add(new SelectItem("1","Negativo"));
            lstResultado.add(new SelectItem("2","Positivo"));
        }
        return lstResultado;
    }

    public void setEspevasec(Chespervasec espevasec) {
        this.espevasec = espevasec;
    }

    public Chespervasec getEspevasec() {
        return espevasec;
    }
    
    /**
     * @param generoEspermograma
     */
    public void setGeneroEspermograma(boolean generoEspermograma) {
        this.generoEspermograma = generoEspermograma;
    }

    /**
     * @return
     */
    public boolean isGeneroEspermograma() {
        return generoEspermograma;
    }

    public void obtenerDatosReporteConsulta() {
        resetDatos(); 
    
        if (usuario != null) {
            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }
            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            } else {
                PRIMER_APELLIDO = " ";
            }
            if (usuario.getHuscsegundapel() != null && !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            } else {
                SEGUNDO_APELLIDO = " ";
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
        }
   
        if (getUsuarioSystem() != null) {
            NOMBRE_USUARIO = espevasec.getHevcoperador();
        }
     
        if (NOMBRE_USUARIO != null) {
            Cpprofesio profesional;
            profesional = null;
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(NOMBRE_USUARIO, 
                                                                                       getClinica().getCclncodigo());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
            }
        }

        if (espevasec.getHevdfecharesul() != null) {
            fecha = espevasec.getHevdfecharesul() ;
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
        }

        if (espevasec != null) {
            if (espevasec.getHevcresulesper()  != null && !espevasec.getHevcresulesper().trim().equals("")) {
                OBSERVACIONES_ESPERMOGRAMA = espevasec.getHevcresulesper();
            }
            if (espevasec.getHevcesperpostv() != null && espevasec.getHevcesperpostv().equals("1")) {
                RESULTADO_ESPERMOGRAMA = "NEGATIVO";
            } else if (espevasec.getHevcesperpostv() != null && espevasec.getHevcesperpostv().equals("2")) {
                RESULTADO_ESPERMOGRAMA = "POSITIVO";
            } else {
                RESULTADO_ESPERMOGRAMA = "REGISTRO NO VALIDO";
            }
            if (espevasec.getHevarecueesper() != null) {
                DecimalFormat formateador = new DecimalFormat("###,###,##0");
                RECUENTO_ESPERMATOZOIDES = formateador.format(espevasec.getHevarecueesper());
            }
        }
    }

    public void resetDatos(){
        PRIMER_APELLIDO = null; 
        SEGUNDO_APELLIDO = null; 
        NUMERO_DOCUMENTO = null; 
        NOMBRES = null; 
        DIA = null; 
        MES = null; 
        ANO = null; 
        EDAD = null; 
        TIPO_DOCUMENTO = null; 
        OBSERVACIONES_ESPERMOGRAMA = null;
        RECUENTO_ESPERMATOZOIDES = null;
        RESULTADO_ESPERMOGRAMA = null;
        NOMBRE_USUARIO = null; 
        NOMBRE_PROFESIONAL = null; 
        REGISTRO_MEDICO = null; 
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
     * @return
     * @throws JRException
     */
    public boolean next() throws JRException {
        index++;
        return (index < 1);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();
        
//        if(index == 1){
            if (fieldName.equals("APELLIDO1")) {
                value = PRIMER_APELLIDO;
                return value;
            }
            if (fieldName.equals("APELLIDO2")) {
                value = SEGUNDO_APELLIDO;
                return value;
            }
            if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
                return value;
            }
            if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
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
            if (fieldName.equals("TIPO_DOCUMENTO")) {
                value = TIPO_DOCUMENTO;
                return value;
            }
            if (fieldName.equals("FECHA")) {
                value = new Date();
                return value;
            }
            if (fieldName.equals("RESULTADO_ESPERMOGRAMA")) {
                value = RESULTADO_ESPERMOGRAMA;
                return value;
            }
            if (fieldName.equals("OBSERVACIONES_ESPERMOGRAMA")) {
                value = OBSERVACIONES_ESPERMOGRAMA;
                return value;
            }
            if (fieldName.equals("RECUENTO_ESPERMATOZOIDES")) {
                value = RECUENTO_ESPERMATOZOIDES;
                return value;
            }
            if (fieldName.equals("EDAD")) {
                value = EDAD;
                return value;
            }
            if (fieldName.equals("NOMBRE_USUARIO")) {
                value = NOMBRE_USUARIO;
                return value;
            }
            if (fieldName.equals("NOMBRE_PROFESIONAL")) {
                value = NOMBRE_PROFESIONAL;
                return value;
            } 
            if (fieldName.equals("REGISTRO_MEDICO")) {
                value = REGISTRO_MEDICO;
                return value;
            }   
            if (fieldName.equals("NUMERO_HOJA")) {
                value = 1;
                return value;
            }
//        }
        return null;
    }

    /**
     * @return
     */
    public String siguiente() {
        if ("menuVasectomiaBean".equals(menuBean)) {
            FacesUtils.resetManagedBean("listaMisUsuariosBean");
            FacesUtils.resetManagedBean("listaUsuariosBean");
            return BeanNavegacion.RUTA_LISTA;
        } else {
            return BeanNavegacion.RUTA_IR_CONTROL_VASECTOMIA;
        }
        
    }


    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public String cerrarEspermograma() {
        Chconsulta conshist;
        try {
            conshist = 
                    this.serviceLocator.getClinicoService().getConsultaActual(consulta.getCconnumero().longValue());
            if (!IConstantes.ETAPA_ABIERTO.equals(conshist.getHcoeetapa())) {
                FacesUtils.addInfoMessage("Consulta ya esta Cerrada");
            } else {
                if (consulta != null && usuario != null) {
                    this.serviceLocator.getClinicoService().closeEspermograma(usuario, 
                                                                                  consulta, 
                                                                                  userName());
                    FacesUtils.resetManagedBean(menuBean);
                    inicalizarAplicacionBean();
                    if ("menuVasectomiaBean".equals(menuBean)) {
                        return BeanNavegacion.RUTA_IR_MEDICO_ESPERMOGRAMA;
                    } else {
                        return BeanNavegacion.RUTA_IR_ESPERMOGRAMA;
                    }
                }
            }
        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }
//        return BeanNavegacion.RUTA_ACTUAL;
        return nextAction;
    }


    public void setConsultaCerrada(boolean consultaCerrada) {
        this.consultaCerrada = consultaCerrada;
    }

    public boolean isConsultaCerrada() {
        return consultaCerrada;
    }
}
