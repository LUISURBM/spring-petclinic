//=======================================================================
// ARCHIVO AntecedentesBean.java
// FECHA CREACI�N: 
// AUTOR: jariano, nliz
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

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
import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantecolpo;
import org.profamilia.hc.model.dto.Chcolposcopia;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chfragesperma;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.ChmedicamentId;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaFragmentacionEspermaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
//=======================================================================
//  CLASE AntecedentesBean
//=======================================================================
public class CierreTestFragmentacionEspermaBean extends BaseBean implements JRDataSource {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    /** Almacena el tipo de historia*/
    private Integer tipoHistoria;


    private String sexo;

    private String navigationRule;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    /**  */
    private String menuBean;

    private String nextAction;

    private Long numeroConsulta;


    private boolean renderReacciones;


    private Integer consecutivo;

    private Chfragesperma chfragespe;

    /** Almacena el consulta */
    private Cnconsclin consulta;
    private int index = -1;
    private boolean generoReporte;

    private String NOMBRES;
    private Long NUMEROID;
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
    Cpprofesio prot = new Cpprofesio();
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public CierreTestFragmentacionEspermaBean() {
    }

    public void init() {
        nextAction = "";
        chfragespe = new Chfragesperma();
        inicializarFragmentacion();

    }
    
    public String cerrarConsulta() {
        navigationRule = "";

        try {

           consulta.setCcocetapa("AT");
           this.getServiceLocator().getClinicoService().saveChconsulta(consulta,"VG",this.getUsuarioSystem().getCurcusuari());

            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION + " : " + 
                                       e.getMessage());
            navigationRule = "";
            e.printStackTrace();
        }
        return navigationRule;

    }


    public void inicializarFragmentacion() {
      
        chfragespe = new Chfragesperma();
        generoReporte=false;
        consecutivo = 1;
        try {
            if (numeroConsulta != null) {
                consulta= this.getServiceLocator().getClinicoService().getConsultaClinicaPorId(numeroConsulta.toString());
                chfragespe = 
                        this.serviceLocator.getClinicoService().getFragmentEsperma(numeroConsulta);
                
                if(chfragespe==null){
                    chfragespe= new Chfragesperma();
                }

            }
            
            prot =  this.getServiceLocator().getClinicoService().getProfesionalPorCodigo(this.getUsuarioSystem().getCurnprofes(),
                                                                         this.getUsuarioSystem().getCurnclinic());
          
        } catch (ModelException e) {
            e.printStackTrace();
        }

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
    public boolean esValido() {
        Chfragesperma e = new Chfragesperma();

        boolean esValido = false;

        try {
            if (numeroConsulta != null) {
                e = this.serviceLocator.getClinicoService().getFragmentEsperma(numeroConsulta);
            }

        } catch (ModelException ex) {
            ex.printStackTrace();
        }

        if (e != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    public String aceptar() {
        navigationRule = "";
        generoReporte=false;
        cerrarConsulta();
        navigationRule = nextAction;
        FacesUtils.resetManagedBean("listaFragmentacionEspermaBean");
         return navigationRule;

    }

    public void obtenerDatosReporte() {


        try {
            if (usuario != null) {
                if (usuario.getHuscprimernomb() != null) {
                    PACIENTE = usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb() + " " + usuario.getHuscprimerapel() + " " + usuario.getHuscsegundapel();
                }
                if (usuario.getHusanumeiden() != null) {
                    IDENTIFICACION = usuario.getHusetipoiden() + " " + usuario.getHusanumeiden();
                }
            }
            
            if (chfragespe != null) {
                if (chfragespe.getCfelnumexam() != null) {
                    NEXAMEN = chfragespe.getCfelnumexam();
                }
              
                if (chfragespe.getCfectipomuest() != null) {
                    TIPOMUESTRA = chfragespe.getCfectipomuest();
                }
                if (chfragespe.getCfedfechtoma() != null) {
                    FECHA_MUESTRA = chfragespe.getCfedfechtoma();
                }
                if (chfragespe.getCfedfechinfor() != null) {
                    FECHA_INFORME = chfragespe.getCfedfechinfor();
                }
                if (chfragespe.getCfecmediremi() != null) {
                    MEDICO_REMITE = chfragespe.getCfecmediremi();
                }
                if (chfragespe.getCfelnesinfrag() != null) {
                    NESINFRAG = chfragespe.getCfelnesinfrag();
                }
                if (chfragespe.getCfelneconfrag() != null) {
                    NESCONFRAG = chfragespe.getCfelneconfrag();
                }
                if (chfragespe.getCfenidf() != null) {
                    IDF = new BigDecimal(chfragespe.getCfenidf().doubleValue());
                }
                if (chfragespe.getCfenporcentaje() != null) {
                    OBSPORCENTAJE = new BigDecimal(chfragespe.getCfenporcentaje().doubleValue());
                }
                if (chfragespe.getCfecconsidera() != null) {
                    CONSIDERAS = chfragespe.getCfecconsidera();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }
    }

    public void imprimirFragmentacionEsperma() {
        this.index = -1;
        try {
            generoReporte=false;
          obtenerDatosReporte();
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

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                byte[] bytes = 
                    JasperRunManager.runReportToPdf(report, parameters, 
                                                    (JRDataSource)this);
                PdfServletUtils.showPdfDocument(bytes, 
                                                "TestFragmentacionEsperma" + 
                                                ".pdf", false);
                this.generoReporte = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No se pudo generar el reporte " + 
                                       e.getMessage());
        }
        
        FacesUtils.addInfoMessage("Se creo exitosamente el test de Fragmenta espermatica ");
    }


    public boolean next() throws JRException {
        index++;
        return (index < 1);
    }

    public void setchfragespe(Chfragesperma chfragespe) {
        this.chfragespe = chfragespe;
    }

    public Chfragesperma getchfragespe() {
        return chfragespe;
    }


    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
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

    public void setPACIENTE(String pACIENTE) {
        this.PACIENTE = pACIENTE;
    }

    public String getPACIENTE() {
        return PACIENTE;
    }


    public void setNEXAMEN(int nEXAMEN) {
        this.NEXAMEN = nEXAMEN;
    }

    public int getNEXAMEN() {
        return NEXAMEN;
    }

    public void setTIPOMUESTRA(String tIPOMUESTRA) {
        this.TIPOMUESTRA = tIPOMUESTRA;
    }

    public String getTIPOMUESTRA() {
        return TIPOMUESTRA;
    }

    public void setFECHA_MUESTRA(Date fECHA_MUESTRA) {
        this.FECHA_MUESTRA = fECHA_MUESTRA;
    }

    public Date getFECHA_MUESTRA() {
        return FECHA_MUESTRA;
    }

    public void setFECHA_INFORME(Date fECHA_INFORME) {
        this.FECHA_INFORME = fECHA_INFORME;
    }

    public Date getFECHA_INFORME() {
        return FECHA_INFORME;
    }

    public void setMEDICO_REMITE(String mEDICO_REMITE) {
        this.MEDICO_REMITE = mEDICO_REMITE;
    }

    public String getMEDICO_REMITE() {
        return MEDICO_REMITE;
    }

    public void setNESINFRAG(int nESINFRAG) {
        this.NESINFRAG = nESINFRAG;
    }

    public int getNESINFRAG() {
        return NESINFRAG;
    }

    public void setNESCONFRAG(int nESCONFRAG) {
        this.NESCONFRAG = nESCONFRAG;
    }

    public int getNESCONFRAG() {
        return NESCONFRAG;
    }

    public void setIDF(BigDecimal iDF) {
        this.IDF = iDF;
    }

    public BigDecimal getIDF() {
        return IDF;
    }

    public void setOBSPORCENTAJE(BigDecimal oBSPORCENTAJE) {
        this.OBSPORCENTAJE = oBSPORCENTAJE;
    }

    public BigDecimal getOBSPORCENTAJE() {
        return OBSPORCENTAJE;
    }

    public void setCONSIDERAS(String cONSIDERAS) {
        this.CONSIDERAS = cONSIDERAS;
    }

    public String getCONSIDERAS() {
        return CONSIDERAS;
    }

    public void setIDENTIFICACION(String iDENTIFICACION) {
        this.IDENTIFICACION = iDENTIFICACION;
    }

    public String getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public void setProt(Cpprofesio prot) {
        this.prot = prot;
    }

    public Cpprofesio getProt() {
        return prot;
    }
}
