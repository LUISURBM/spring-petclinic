package org.profamilia.hc.view.backing.comun.consulta;

import java.awt.Color;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chantecespec;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chfragesperma;
import org.profamilia.hc.model.dto.Chlecttuber;
import org.profamilia.hc.model.dto.ChlecttuberPK;
import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultarCopiaTestFragEspermaBean extends BaseBean implements JRDataSource {


    private int selectedIndex;

    private boolean renderBuscador;

    private boolean generoHistoria;

    private Chusuario usuario;

    private String nombreUsuario;

    BuscadorUsuariosBean buscador;

    private Long numeroUsuario;

    private boolean renderInformacionUsuario;

    private UIInput itNumeroUsuario;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;


    private List lstTestUsuario;

    private HtmlDataTable dtCopiaCitologia;


    private int index = -1;

    private static int NUMERO_COPIAS = 1;
        
    Chfragesperma chfrage = new Chfragesperma();
    private String nextAction;
    
    private List<Chantecespec> listaTomaTuber= new ArrayList<Chantecespec>();
    
    Chantecespec antecespec = new Chantecespec();
    Chantecpatol antepatol = new Chantecpatol();
    Chantecfarma antefarma = new Chantecfarma();
    Cpusuario usu= new Cpusuario();
    ChlecttuberPK chChlecttuberId= new ChlecttuberPK();
    private boolean generoTestFragEsperma;

    private boolean esPolicia;
    /*reporte tuberculina*/
     private String PACIENTE;
     private String IDENTIFICACION;
     private int NEXAMEN;
     private String TIPOMUESTRA;
     private Date FECHA_MUESTRA;
     private Date FECHA_INFORME;
     private String MEDICO_REMITE;
     private int NESINFRAG;
     private int NESCONFRAG;
     private BigDecimal IDF;
     private BigDecimal OBSPORCENTAJE;
     private String CONSIDERAS;
    private String navigationRule;
    Cpclinica clinAux= new Cpclinica();
    private List<Cnconsclin> lstConsClin;
    
    
    private List listaChconsulta;
    Object[] consultaAuxT;


    public ConsultarCopiaTestFragEspermaBean() {
    }


    public void init() {
        generoHistoria = false;
        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        //        lstFolios = new ArrayList<Chconsulta>();
        lstConsClin = new ArrayList<Cnconsclin>();
        listaChconsulta = new ArrayList();
        if (usuario == null) {
            usuario = new Chusuario();
        }
        nextAction = "";
    }


    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("PACIENTE")) {
            value = PACIENTE;
        }
        if (fieldName.equals("IDENTIFICACION")) {
            value = IDENTIFICACION;
        }
        if (fieldName.equals("NEXAMEN")) {
            value = NEXAMEN;
        }
        if (fieldName.equals("TIPOMUESTRA")) {
            value = TIPOMUESTRA;
        }
        if (fieldName.equals("FECHA_MUESTRA")) {
            value = FECHA_MUESTRA;
        }
        if (fieldName.equals("FECHA_INFORME")) {
            value = FECHA_INFORME;
        }
        if (fieldName.equals("MEDICO_REMITE")) {
            value = MEDICO_REMITE;
        }
        if (fieldName.equals("NESINFRAG")) {
            value = NESINFRAG;
        }
        if (fieldName.equals("NESCONFRAG")) {
            value = NESCONFRAG;
        }
        if (fieldName.equals("IDF")) {
            value = IDF;
        }
        if (fieldName.equals("OBSPORCENTAJE")) {
            value = OBSPORCENTAJE;
        }
        if (fieldName.equals("CONSIDERAS")) {
            value = CONSIDERAS;
        }
        return value;

    }

    public void obtenerDatosReporte( Chfragesperma chfrage) throws ModelException {
        // Obtenemos los datos del usuario 
        resetDatos();

        try {
            if (usuario != null) {
                if (usuario.getHuscprimernomb() != null) {
                    PACIENTE = usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb() + " " + usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel();
                }
                if (usuario.getHusanumeiden() != null) {
                    IDENTIFICACION = usuario.getHusetipoiden() + " " + usuario.getHusanumeiden();
                }
            }
            
            if (chfrage != null) {
                if (chfrage.getCfelnumexam() != null) {
                    NEXAMEN = chfrage.getCfelnumexam();
                }
              
                if (chfrage.getCfectipomuest() != null) {
                    TIPOMUESTRA = chfrage.getCfectipomuest();
                }
                if (chfrage.getCfedfechtoma() != null) {
                    FECHA_MUESTRA = chfrage.getCfedfechtoma();
                }
                if (chfrage.getCfedfechinfor() != null) {
                    FECHA_INFORME = chfrage.getCfedfechinfor();
                }
                if (chfrage.getCfecmediremi() != null) {
                    MEDICO_REMITE = chfrage.getCfecmediremi();
                }
                if (chfrage.getCfelnesinfrag() != null) {
                    NESINFRAG = chfrage.getCfelnesinfrag();
                }
                if (chfrage.getCfelneconfrag() != null) {
                    NESCONFRAG = chfrage.getCfelneconfrag();
                }
                if (chfrage.getCfenidf() != null) {
                    IDF = new BigDecimal(chfrage.getCfenidf().doubleValue());
                }
                if (chfrage.getCfenporcentaje() != null) {
                    OBSPORCENTAJE = new BigDecimal(chfrage.getCfenporcentaje().doubleValue());
                }
                if (chfrage.getCfecconsidera() != null) {
                    CONSIDERAS = chfrage.getCfecconsidera();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }
        }
    public void resetDatos() {

        PACIENTE = "";
        IDENTIFICACION = "";
        NEXAMEN = 0;
        TIPOMUESTRA = "";
        FECHA_MUESTRA = null;
        FECHA_INFORME = null;
        MEDICO_REMITE = "";
        NESINFRAG = 0;
        NESCONFRAG = 0;
        IDF = null;
        OBSPORCENTAJE = null;
        CONSIDERAS = "";
    }
    


    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        lstTestUsuario = new ArrayList();

    }
    



    public void consultarTestUsuario() {


        try {
            lstTestUsuario = 
                    this.serviceLocator.getClinicoService().getCopiaTestFragE(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }

    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        nombreUsuario = "";
        usuario = new Chusuario();
        if (numeroUsuario != null)
            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
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
    }


    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;

        usuario = new Chusuario();
        nombreUsuario = "";


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

    public void setListSexos(List<SelectItem> listSexos) {
        this.listSexos = listSexos;
    }

    public List getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
            listSexos = new ArrayList<SelectItem>();
            ArrayList<Chsexo> listSexoAux = null;
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

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List<SelectItem> getListEstadoCivil() {
        if (listEstadoCivil == null || listEstadoCivil.isEmpty()) {
            listEstadoCivil = new ArrayList<SelectItem>();
            ArrayList<Chestadociv> listEstadoCivilAux = null;
            try {
                listEstadoCivilAux = 
                        (ArrayList<Chestadociv>)this.getServiceLocator().getClinicoService().getEstadoCivil();
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

    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
            ArrayList<Cptipoiden> listTipoIdentificacionAux = null;
            try {
                listTipoIdentificacionAux = 
                        (ArrayList<Cptipoiden>)this.serviceLocator.getClinicoService().getTipoIdentificacion();
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
     * @param dtCopiaCitologia
     */
    public void setDtCopiaCitologia(HtmlDataTable dtCopiaCitologia) {
        this.dtCopiaCitologia = dtCopiaCitologia;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCopiaCitologia() {
        return dtCopiaCitologia;
    }

    /**
     * @return
     */
    public String volverConsulta() {

        FacesUtils.resetManagedBean("consultarCopiaCitologiaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }


    public String generarCopiaTestFragE() {
        navigationRule = "";
       
        try {
            consultaAuxT = (Object[])dtCopiaCitologia.getRowData();
            
            chfrage= this.serviceLocator.getClinicoService().getTestFargEConsulta(new Long(consultaAuxT[2].toString()));

            usu = this.getServiceLocator().getClinicoService().getUsuarioPorOperador((this.getUsuarioSystem().getCurcusuari().toUpperCase()));

            imprimirResumen();

            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean("listaTuberculinaBean");
            navigationRule = nextAction;

        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + " : " + 
                                       e.getMessage());

            e.printStackTrace();
        }
        return navigationRule;

    }
    public void generarReporte() throws ModelException {
       
          obtenerDatosReporte(chfrage);
      
    }
    
    public void imprimirResumen() {
        this.index = -1;
       
            try {
            
                generoTestFragEsperma=false;
                generarReporte();
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/testFragmentacionEspermatica.jasper");
                URL url_profamilia = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_PRINCIPAL);
                URL url_espermasin = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESPERMASINFRAGMENTACION);
                URL url_espermacon = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_ESPERMACONFRAGMENTACION);
                
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_ESPERMASIN", url_espermasin);
                    parameters.put("IMAGE_ESPERMACON", url_espermacon);
                    
                    byte[] bytes;

                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "TestFragentacionEspermatica" + ".pdf", 
                                                    false);
                    generoTestFragEsperma=true;
                    navigationRule = nextAction;
            
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            
        }
        
    
    }

  

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setListaTomaTuber(List<Chantecespec> listaTomaTuber) {
        this.listaTomaTuber = listaTomaTuber;
    }

    public List<Chantecespec> getListaTomaTuber() {
        return listaTomaTuber;
    }

    public void setAntecespec(Chantecespec antecespec) {
        this.antecespec = antecespec;
    }

    public Chantecespec getAntecespec() {
        return antecespec;
    }

    public void setAntepatol(Chantecpatol antepatol) {
        this.antepatol = antepatol;
    }

    public Chantecpatol getAntepatol() {
        return antepatol;
    }

    public void setAntefarma(Chantecfarma antefarma) {
        this.antefarma = antefarma;
    }

    public Chantecfarma getAntefarma() {
        return antefarma;
    }

    public void setUsu(Cpusuario usu) {
        this.usu = usu;
    }

    public Cpusuario getUsu() {
        return usu;
    }

    public void setChChlecttuberId(ChlecttuberPK chChlecttuberId) {
        this.chChlecttuberId = chChlecttuberId;
    }

    public ChlecttuberPK getChChlecttuberId() {
        return chChlecttuberId;
    }

   

    public void setEsPolicia(boolean esPolicia) {
        this.esPolicia = esPolicia;
    }

    public boolean isEsPolicia() {
        return esPolicia;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setClinAux(Cpclinica clinAux) {
        this.clinAux = clinAux;
    }

    public Cpclinica getClinAux() {
        return clinAux;
    }

    public void setLstConsClin(List<Cnconsclin> lstConsClin) {
        this.lstConsClin = lstConsClin;
    }

    public List<Cnconsclin> getLstConsClin() {
        return lstConsClin;
    }

    public void setListaChconsulta(List listaChconsulta) {
        this.listaChconsulta = listaChconsulta;
    }

    public List getListaChconsulta() {
        return listaChconsulta;
    }

    public void setConsultaAuxT(Object[] consultaAuxT) {
        this.consultaAuxT = consultaAuxT;
    }

    public Object[] getConsultaAuxT() {
        return consultaAuxT;
    }

    public void setGeneroTestFragEsperma(boolean generoTestFragEsperma) {
        this.generoTestFragEsperma = generoTestFragEsperma;
    }

    public boolean isGeneroTestFragEsperma() {
        return generoTestFragEsperma;
    }

    public void setLstTestUsuario(List lstTestUsuario) {
        this.lstTestUsuario = lstTestUsuario;
    }

    public List getLstTestUsuario() {
        return lstTestUsuario;
    }

    public void setChfrage(Chfragesperma chfrage) {
        this.chfrage = chfrage;
    }

    public Chfragesperma getChfrage() {
        return chfrage;
    }
}
