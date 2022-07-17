package org.profamilia.hc.view.backing.menus.consultorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.AntecedentesFarmacologicosTuberculinaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesTuberculinaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesGeneralesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AntecedentesPatologicosTuberculinaBean;
import org.profamilia.hc.view.backing.comun.AntecedentesUsuarioBean;
import org.profamilia.hc.view.backing.comun.AplicacionMedicamentoBean;
import org.profamilia.hc.view.backing.comun.CerrarConsultaUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.PausarConsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.view.backing.comun.ConfirmarServiciosAdmisionBean;


public class MenuLecturaTuberculinaBean extends BaseBean {

    private DatosBasicosUsuarioBean datosBasicosUsuario;

    private CerrarConsultaUsuarioBean cerrarConsultaUsuarioBean;

    private AplicacionMedicamentoBean aplicacionBean;

    private AntecedentesUsuarioBean antecedentes;

    private AntecedentesGeneralesTuberculinaBean antecedentesGeneralesTuberculina;
    
    private AntecedentesPatologicosTuberculinaBean antecedentesPatologicosTuberculina;
    
    private AntecedentesFarmacologicosTuberculinaBean antecedentesFarmacologicosTuberculina;


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
    
    private boolean renderAdministracion; 
    
    private boolean primeraConsulta;

    private boolean renderPausarConsulta;
    private PausarConsultaBean pausarConsulta;
    private boolean tiempoAtencion;
	
	private ConfirmarServiciosAdmisionBean confirmarServiciosAdmision;
			
	private boolean renderServiciosAdmision;


    public MenuLecturaTuberculinaBean() {
    }


    public void init() {
        renderVacunacion = false; 

        // DATOS BASICOS USUARIO
         primeraConsulta = false;

        
        
        datosBasicosUsuario = 
                (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
                
        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getUsuario() != null && 
            datosBasicosUsuario.getUsuario().getHuslnumero() != null) {
            try {
                primeraConsulta = 
                        this.getServiceLocator().getClinicoService().esPrimeraConsulta(datosBasicosUsuario.getUsuario());
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
                
      if(primeraConsulta)        {
            datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_TUBERCULINA);
            renderAntecedentesGenerales = datosBasicosUsuario.esValido();
        }else{
            
            datosBasicosUsuario.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_TUBERCULINA);    
            renderAntecedentes = datosBasicosUsuario.esValido();
        }
        
        datosBasicosUsuario.setMenuBean("menuLecturaTuberculinaBean");
        
    
        
    if(datosBasicosUsuario != null){
        tipoHistoria = datosBasicosUsuario.getTipoHistoria();
    }
        


        if (datosBasicosUsuario != null && 
            datosBasicosUsuario.getConsulta() != null && 
            datosBasicosUsuario.getConsulta().getCconnumero() != null) {
            numeroConsulta = 
                    new Long(datosBasicosUsuario.getConsulta().getCconnumero());

        }
        if(tipoHistoria != null){
            if(tipoHistoria.equals(IConstantes.HISTORIA_LECTURA_TUBERCULINA)){
                renderVacunacion = true; 
            }
        }


        // ANTECEDENTES


        antecedentes = 
                (AntecedentesUsuarioBean)FacesUtils.getManagedBean("antecedentesUsuarioBean");
        antecedentes.setTipoServicio(TIPO_CONSULTA);
        antecedentes.setNumeroConsulta(numeroConsulta);
        antecedentes.setTipoHistoria(HISTORIA_LECTURA_TUBERCULINA);
        antecedentes.setUsuario(datosBasicosUsuario.getUsuario());
        antecedentes.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_TUBERCULINA);
        antecedentes.setMenuBean("menuLecturaTuberculinaBean");
        antecedentes.inicializarAntecedentes();
        if(primeraConsulta){
        renderAdministracion = antecedentes.esValido();
        }


        // ANTECEDENTES ESPECIFICOS
        antecedentesGeneralesTuberculina = 
                (AntecedentesGeneralesTuberculinaBean)FacesUtils.getManagedBean("AntecedentesGeneralesTuberculinaBean");
        antecedentesGeneralesTuberculina.setTipoServicio(TIPO_CONSULTA);
        antecedentesGeneralesTuberculina.setTipoHistoria(HISTORIA_TOMA_TUBERCULINA);
        antecedentesGeneralesTuberculina.setNumeroConsulta(numeroConsulta);
        antecedentesGeneralesTuberculina.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_PATOLOGICOS_TUBERCULINA);
        antecedentesGeneralesTuberculina.setMenuBean("menuTuberculinaBean");
        antecedentesGeneralesTuberculina.inicializarAntecedentes();
       
        // ANTECEDENTES PATOLOGICOS
        antecedentesPatologicosTuberculina = 
                (AntecedentesPatologicosTuberculinaBean)FacesUtils.getManagedBean("AntecedentesPatologicosTuberculinaBean");
        antecedentesPatologicosTuberculina.setTipoServicio(TIPO_CONSULTA);
        antecedentesPatologicosTuberculina.setTipoHistoria(HISTORIA_TOMA_TUBERCULINA);
        antecedentesPatologicosTuberculina.setNumeroConsulta(numeroConsulta);
        antecedentesPatologicosTuberculina.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_FARMACOLOGICO_TUBERCULINA);
        antecedentesPatologicosTuberculina.setMenuBean("menuTuberculinaBean");
        antecedentesPatologicosTuberculina.inicializarAntecedentes();

        // ANTECEDENTES FARMACOLOGICOS
        antecedentesFarmacologicosTuberculina = 
                (AntecedentesFarmacologicosTuberculinaBean)FacesUtils.getManagedBean("antecedentesFarmacologicosTuberculinaBean");
        antecedentesFarmacologicosTuberculina.setTipoServicio(TIPO_CONSULTA);
        antecedentesFarmacologicosTuberculina.setTipoHistoria(HISTORIA_TOMA_TUBERCULINA);
        antecedentesFarmacologicosTuberculina.setNumeroConsulta(numeroConsulta);
        antecedentesFarmacologicosTuberculina.setNextAction(BeanNavegacion.RUTA_IR_ANTECEDENTES_FARMACOLOGICO_TUBERCULINA);
        antecedentesFarmacologicosTuberculina.setMenuBean("menuTuberculinaBean");
        antecedentesFarmacologicosTuberculina.inicializarAntecedentes();

        // CERRAR CONSULTA
        cerrarConsultaUsuarioBean = 
                (CerrarConsultaUsuarioBean)FacesUtils.getManagedBean("cerrarConsultaUsuarioBean");
        cerrarConsultaUsuarioBean.setUsuario(datosBasicosUsuario.getUsuario());
        cerrarConsultaUsuarioBean.setMenuBean("menuTuberculinaBean");
        cerrarConsultaUsuarioBean.setConsulta(datosBasicosUsuario.getConsulta());
        cerrarConsultaUsuarioBean.setEsVacunacion(true);
        cerrarConsultaUsuarioBean.inicalizarCerrarConsultaBean();
        
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

 
    public String irDatosLecturaTuberculina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_MODIFICAR_DATOS_USUARIO_TUBERCULINA;
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

 
    public String irAntecedentesTuberculina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_GENERALES_TUBERCULINA;
    }
    
    public String irAntecedentesPatologicosTuberculina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_PATOLOGICOS_TUBERCULINA;
    }

    public String irAntecedentesFarmacologicosTuberculina() {
        inicializarUsuario();
        return BeanNavegacion.RUTA_IR_ANTECEDENTES_FARMACOLOGICO_TUBERCULINA;
    }

}
