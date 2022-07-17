package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;

public class ConsultarFoliosUsuarioCirugiaIngresoEnfermeraBean extends BaseBean{


    private Chusuario usuario;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private Integer edad;

    private boolean renderInformacionUsuario;


    StringBuffer sbuffer = new StringBuffer();

    private Long numeroUsuario;

    /** Almacena el numero de la consulta*/
    private Long numeroConsulta;

    /** Almacena la consulta seleccionada*/
    private Chconsulta consultaClone;

    private HtmlDataTable dtFoliosCirugia;

    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFolios;

    private int selectedIndex;

    private boolean renderBuscador;

    private UIInput itNumeroUsuario;

    private String nombreUsuario;

    BuscadorUsuariosBean buscador;

    static final int ACTIVAR_BEAN = 0;

    static final int ACTIVAR_BUSCADOR = 1;

    private List<Object[]> lstDescDetalle; // QUITAR
    




    public ConsultarFoliosUsuarioCirugiaIngresoEnfermeraBean() {
    }
    
    
    
    public void init() {

        sbuffer = new StringBuffer();
        lstFolios = new ArrayList<Chconsulta>();

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();

        if (usuario == null) {
            usuario = new Chusuario();
        }
            try {
            if(numeroUsuario != null){
                lstFolios = this.serviceLocator.getCirugiaService().getFoliosUsuarioCirugia(numeroUsuario);

            }
                
            } catch (ModelException e) {
                e.printStackTrace();
            }
        
       
        }


    public void consultarRegistros(){
        try {
        if(numeroUsuario != null){
            lstFolios = this.serviceLocator.getCirugiaService().getFoliosUsuarioCirugia(numeroUsuario);

        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
    
    public String generar() {
        Chconsulta consulta = null;
        consulta = (Chconsulta)dtFoliosCirugia.getRowData();
        DatosBasicosUsuarioCirugiaBean datosUsuario = (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        
        if(datosUsuario!= null && usuario!= null){
            datosUsuario.setUsuario(usuario);
            datosUsuario.inicializarUsuario();
        }
        
        FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
        
        GenerarFoliosCirugiaBean generarFolios = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        
        if(generarFolios!= null && consulta!= null ){
            generarFolios.setConsulta(consulta);
            generarFolios.setGeneroHistoria(false);
        }
        
        return BeanNavegacion.RUTA_IR_GENERAR_FOLIOS_INGRESO_ENFERMERIA;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    
    
    
    

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setListSexos(List<SelectItem> listSexos) {
        this.listSexos = listSexos;
    }

    public List<SelectItem> getListSexos() {
        return listSexos;
    }

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List<SelectItem> getListEstadoCivil() {
        return listEstadoCivil;
    }

    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        return listTipoIdentificacion;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setRenderInformacionUsuario(boolean renderInformacionUsuario) {
        this.renderInformacionUsuario = renderInformacionUsuario;
    }

    public boolean isRenderInformacionUsuario() {
        return renderInformacionUsuario;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setConsultaClone(Chconsulta consultaClone) {
        this.consultaClone = consultaClone;
    }

    public Chconsulta getConsultaClone() {
        return consultaClone;
    }

    public void setDtFoliosCirugia(HtmlDataTable dtFoliosCirugia) {
        this.dtFoliosCirugia = dtFoliosCirugia;
    }

    public HtmlDataTable getDtFoliosCirugia() {
        return dtFoliosCirugia;
    }

    public void setLstFolios(List<Chconsulta> lstFolios) {
        this.lstFolios = lstFolios;
    }

    public List<Chconsulta> getLstFolios() {
        return lstFolios;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setLstDescDetalle(List<Object[]> lstDescDetalle) {
        this.lstDescDetalle = lstDescDetalle;
    }

    public List<Object[]> getLstDescDetalle() {
        return lstDescDetalle;
    }
    
  
}
