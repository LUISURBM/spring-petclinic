package org.profamilia.hc.view.backing.comun.consulta;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarEstadoCitologiaBean extends BaseBean{


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

    private Integer edad;
    
    private List lstCitologiaUsuario; 
    
    private HtmlDataTable dtEstadoCitologia; 
    
    private Cncitotoma toma; 
    
    private Cncitolect lectura; 
    
    private Cncitologi citologia; 
    
    private Chlibrocitol libro; 
    

    

    public ConsultarEstadoCitologiaBean() {
    }
    
    
    public void init(){
        generoHistoria = false; 
    }
  
    
    
 

    
    
    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        lstCitologiaUsuario = null;
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
    }
    
    
    public void consultarCitologiasUsuario() {
        try {
            lstCitologiaUsuario = this.serviceLocator.getClinicoService().getEstadoCitologia(numeroUsuario);
        } catch (ModelException e) {
            e.printStackTrace();
        }
            
    }


    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoHistoria = false;
        nombreUsuario = ""; 
        usuario = new Chusuario(); 
        lstCitologiaUsuario = null;
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
        if (listSexos == null || listSexos.isEmpty() ) {
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
        if (listTipoIdentificacion == null || listTipoIdentificacion.isEmpty()) {
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
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {
        return edad;
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
     * @param lstCitologiaUsuario
     */
    public void setLstCitologiaUsuario(List lstCitologiaUsuario) {
        this.lstCitologiaUsuario = lstCitologiaUsuario;
    }

    /**
     * @return
     */
    public List getLstCitologiaUsuario() {
        return lstCitologiaUsuario;
    }


    /**
     * @param dtEstadoCitologia
     */
    public void setDtEstadoCitologia(HtmlDataTable dtEstadoCitologia) {
            this.dtEstadoCitologia = dtEstadoCitologia;
        }

    /**
     * @return
     */
    public HtmlDataTable getDtEstadoCitologia() {
            return dtEstadoCitologia;
        }

 
    /**
     * @return
     */
    public String volverConsulta() {
        
        FacesUtils.resetManagedBean("consultarEstadoCitologiaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        generoHistoria = false;
        return BeanNavegacion.RUTA_IR_INICIO;
    }
    
    
 


    public String  consultarEstadoCitologia(){
        Object[] citologiaAux; 
         Integer consecutivo;
         consecutivo = 0; 
         
        DetalleConsultaCitologiaBean detalle = (DetalleConsultaCitologiaBean)FacesUtils.getManagedBean("detalleConsultaCitologiaBean"); 
        
        citologiaAux = (Object[])dtEstadoCitologia.getRowData(); 
        
        BigDecimal consecutivoBig = (BigDecimal)citologiaAux[0]; 
        if(consecutivoBig!= null){
             
             consecutivo = consecutivoBig.intValue();
         }
               
         if (citologiaAux != null) {
                    try {
                        citologia = serviceLocator.getClinicoService().getEncabezadoCitologia(consecutivo); 
                        toma =  serviceLocator.getClinicoService().getTomaCitologia(consecutivo);
                        lectura =  serviceLocator.getClinicoService().getLecturaCitologia(consecutivo);
                        libro = serviceLocator.getClinicoService().getLibroCitologia(consecutivo); 
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }   
                
                
                if(detalle != null){
                    detalle.setUsuario(usuario);
                    detalle.setCitologia(citologia);
                    detalle.setToma(toma);
                    detalle.setLectura(lectura);
                    detalle.setLibro(libro);
                    detalle.inicializarDetalle();
                }

                return BeanNavegacion.RUTA_VER_DETALLE_CITOLOGIA; 
    }


}
