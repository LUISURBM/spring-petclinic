package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosCitologiaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesFarmacologicosTuberculinaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesTuberculinaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesPatologicosTuberculinaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionMedicamentoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.CierreTuberculinaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaFragmentacionEspermaBean;
import org.profamilia.hc.view.backing.comun.CierreTestFragmentacionEspermaBean;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;
import org.profamilia.hc.view.backing.comun.CuestionarioCovidBean;
import org.profamilia.hc.view.backing.comun.TestFragmentacionEspermaBean;


public class MenuFragmentacionEspermaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private AplicacionMedicamentoBean aplicacionBean;

    private AntecedentesUsuarioBean antecedentes;

    private CierreTuberculinaBean cierreTuberculinaBean;
    
    
    private boolean renderAntecedentesGenerales;
    
    private Integer tipoHistoria;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderAplicacion;

    private boolean renderAntecedentes;

    private boolean renderCerrarConsulta;

    private Long numeroConsulta;

    private String sexo;
    
    private boolean renderVacunacion;
    
    private boolean primeraConsulta;

    private boolean renderPausarConsulta;
    private boolean tiempoAtencion;
	
    private boolean renderIngreso;
    private CuestionarioCovidBean cuestionarioCovid;
    private boolean renderCovid; 
    private boolean renderAntespe;
    private boolean renderAntpato;
    private boolean renderAntfarm;
    private boolean renderCierre;
    private boolean primeraConsultacovid;
    private TestFragmentacionEspermaBean testFrag;
    private CierreTestFragmentacionEspermaBean cierreTestFragmentacionEspermaBean;


    public MenuFragmentacionEspermaBean() {
    }


    public void init() {
        renderVacunacion = false; 
        renderAntespe = false;
        renderAntpato = false;
        renderAntfarm = false;
        renderCierre = false;

        // DATOS BASICOS USUARIO
         primeraConsulta = false;
        renderIngreso = false;
        primeraConsultacovid=false;

        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");

        datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_FRAGMENTACION);
        renderIngreso = datosBasicosUsuario.esValido();


        datosBasicosUsuario.setMenuBean("menuFragmentacionEspermaBean");


        if (datosBasicosUsuario != null) {
            tipoHistoria = datosBasicosUsuario.getTipoHistoria();
        }
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());

        }

        if (tipoHistoria != null) {
            if (tipoHistoria.equals(IConstantes.HISTORIA_TEST_FRAGMENTACION_ESPERMA)) {
                renderVacunacion = true;
            }
        }

        cuestionarioCovid = (CuestionarioCovidBean)FacesUtils.getManagedBean("cuestionarioCovidBean");
        cuestionarioCovid.setTipoServicio(TIPO_CONSULTA);
        cuestionarioCovid.setNumeroUsuario(datosBasicosUsuario.getUsuario().getHuslnumero());
        cuestionarioCovid.setNumeroConsulta(numeroConsulta);
        cuestionarioCovid.setNextAction(BeanNavegacion.RUTA_IR_TEST_FRAGMENTACION_ESPERMA);
        cuestionarioCovid.setMenuBean("menuFragmentacionEspermaBean");
        cuestionarioCovid.inicializarCuestionario();
        primeraConsultacovid= cuestionarioCovid.esValido();

        // ANTECEDENTES


        testFrag = 
        (TestFragmentacionEspermaBean)FacesUtils.getManagedBean("testFragmentacionEspermaBean");
        testFrag.setNumeroConsulta(numeroConsulta);
        testFrag.setTipoHistoria(HISTORIA_TEST_FRAGMENTACION_ESPERMA);
        testFrag.setUsuario(datosBasicosUsuario.getUsuario());
        testFrag.setMenuBean("menuFragmentacionEspermaBean");
        testFrag.setNextAction(BeanNavegacion.RUTA_IR_CIERRE_FRAGMENTACION_ESPERMA);
        testFrag.inicializarFragmentacion();
        renderCierre=testFrag.esValido();

        // CERRAR CONSULTA
        
        cierreTestFragmentacionEspermaBean = (CierreTestFragmentacionEspermaBean)FacesUtils.getManagedBean("cierreTestFragmentacionEspermaBean");
        cierreTestFragmentacionEspermaBean.setNumeroConsulta(numeroConsulta);
        cierreTestFragmentacionEspermaBean.setUsuario(datosBasicosUsuario.getUsuario());
        cierreTestFragmentacionEspermaBean.setMenuBean("menuFragmentacionEspermaBean");
        cierreTestFragmentacionEspermaBean.setNextAction(BeanNavegacion.RUTA_IR_FRAGMENTACION_ESPERMA);
        cierreTestFragmentacionEspermaBean.inicializarFragmentacion();
         
      
        
        renderPausarConsulta=false;
        if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
            renderPausarConsulta = datosBasicosUsuario.esValido();
        }
        
            if(IConstantes.ACTIVAR_PAUSAR_CONSULTA) {
           tiempoAtencion =datosBasicosUsuario.esValido();
           if (tiempoAtencion) {
               
               try {
                   List<Chtiempaten> chtiempatenList = new ArrayList<Chtiempaten>();
                   chtiempatenList = 
                           getServiceLocator().getClinicoService().consultarTiempoAtencionVigentesXconsulta(numeroConsulta);
                   if (chtiempatenList.isEmpty()) {
                       Chtiempaten chtiempatenAux = new Chtiempaten();
                       chtiempatenAux.setCtanconsulta(numeroConsulta);
                       chtiempatenAux.setCtacetapa("AB");
                       chtiempatenAux.setCtacestado("VG");
                       chtiempatenAux.setCtadhora(new Date());
                       chtiempatenAux.setCtadfechregi(new Date());
                       chtiempatenAux.setCtancausa(0);
                       chtiempatenAux.setCtacusuareg(getUsuarioSystem().getCurcusuari());
                       chtiempatenAux.setCtancodmed(Integer.parseInt(getUsuarioSystem().getCurnprofes().toString()));
                       this.getServiceLocator().getClinicoService().saveRegistroTiempoAtencion(chtiempatenAux);
                   }
               } catch (ModelException e) {
                   e.printStackTrace();
               }
           }
        }

     }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

 
    public String irDatosFragmentacionEsperma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_DATOS_FRAGMENTACION_ESPERMA;
    }




    public void inicializarUsuario() {
        if (datosBasicosUsuario.getUsuario() != null)
            this.setUsuario(datosBasicosUsuario.getUsuario());
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
     * @param renderAplicacion
     */
    public void setRenderAplicacion(boolean renderAplicacion) {
        this.renderAplicacion = renderAplicacion;
    }

    /**
     * @return
     */
    public boolean isRenderAplicacion() {
        return renderAplicacion;
    }

    /**
     * @param renderCerrarConsulta
     */
    public void setRenderCerrarConsulta(boolean renderCerrarConsulta) {
        this.renderCerrarConsulta = renderCerrarConsulta;
    }

    /**
     * @return
     */
    public boolean isRenderCerrarConsulta() {
        return renderCerrarConsulta;
    }

    public void setRenderAntecedentesGenerales(boolean renderAntecedentesGenerales) {
        this.renderAntecedentesGenerales = renderAntecedentesGenerales;
    }

    public boolean isRenderAntecedentesGenerales() {
        return renderAntecedentesGenerales;
    }


    public void setRenderAntecedentes(boolean renderAntecedentes) {
        this.renderAntecedentes = renderAntecedentes;
    }

    public boolean isRenderAntecedentes() {
        return renderAntecedentes;
    }


    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

 
    public String irFragmentacionEsperma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_FRAGMENTACION_ESPERMA;
    }
    
    public String irTestFragmentacionEsperma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_TEST_FRAGMENTACION_ESPERMA;
    }
    
    
   
        public String irCierreFragmentacionEsperma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CIERRE_FRAGMENTACION_ESPERMA;
    }
    
    public String irCuestionarioCovidFragmentacionEsperma() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_COVID_FRAGMENTACION;
        }


    public void setRenderIngreso(boolean renderIngreso) {
        this.renderIngreso = renderIngreso;
    }

    public boolean isRenderIngreso() {
        return renderIngreso;
    }

    public void setCuestionarioCovid(CuestionarioCovidBean cuestionarioCovid) {
        this.cuestionarioCovid = cuestionarioCovid;
    }

    public CuestionarioCovidBean getCuestionarioCovid() {
        return cuestionarioCovid;
    }

    public void setRenderCovid(boolean renderCovid) {
        this.renderCovid = renderCovid;
    }

    public boolean isRenderCovid() {
        return renderCovid;
    }


    public void setRenderAntespe(boolean renderAntespe) {
        this.renderAntespe = renderAntespe;
    }

    public boolean isRenderAntespe() {
        return renderAntespe;
    }

    public void setRenderAntpato(boolean renderAntpato) {
        this.renderAntpato = renderAntpato;
    }

    public boolean isRenderAntpato() {
        return renderAntpato;
    }

    public void setRenderAntfarm(boolean renderAntfarm) {
        this.renderAntfarm = renderAntfarm;
    }

    public boolean isRenderAntfarm() {
        return renderAntfarm;
    }

    public void setRenderCierre(boolean renderCierre) {
        this.renderCierre = renderCierre;
    }

    public boolean isRenderCierre() {
        return renderCierre;
    }

    public void setPrimeraConsultacovid(boolean primeraConsultacovid) {
        this.primeraConsultacovid = primeraConsultacovid;
    }

    public boolean isPrimeraConsultacovid() {
        return primeraConsultacovid;
    }

    public void setTestFrag(TestFragmentacionEspermaBean testFrag) {
        this.testFrag = testFrag;
    }

    public TestFragmentacionEspermaBean getTestFrag() {
        return testFrag;
    }

    public void setCierreTestFragmentacionEspermaBean(CierreTestFragmentacionEspermaBean cierreTestFragmentacionEspermaBean) {
        this.cierreTestFragmentacionEspermaBean = cierreTestFragmentacionEspermaBean;
    }

    public CierreTestFragmentacionEspermaBean getCierreTestFragmentacionEspermaBean() {
        return cierreTestFragmentacionEspermaBean;
    }
}
