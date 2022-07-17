package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.RegistrarSeguimientoTelefonicoBean;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.backing.clinico.consultorio.RegistrarNotaMedicaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarFoliosSeguimientoTelefonicoBean extends BaseBean {

    private Chusuario usuario;

    /** Almacena el bean de Registrar Folios */

    RegistrarSeguimientoTelefonicoBean registrarFolio;


    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena las cirugias de un Usuario */
    private

    List<Chcirugprogr> lstFolios;

    private HtmlDataTable dtFolios;

    private Integer edad;

    /** Alamacena la cirugia seleccionada*/
    private Chcirugprogr cirugia;


    /** Almacena la cirugia seleccionada*/
    Chcirugprogr cirugiaClone;
    
    private HtmlDataTable dtFoliosCirugia;
    
    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFoliosDos;
    
    private boolean renderBuscador;
    
    private int selectedIndex;
    
    private static final int ACTIVAR_FORMULA_MEDICA = 0;

    private static final int ACTIVAR_BUSCADOR = 1;

    public ConsultarFoliosSeguimientoTelefonicoBean() {
    }

    public void init() {

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstFolios = new ArrayList<Chcirugprogr>();
        if (usuario == null) {
            usuario = new Chusuario();
        }
        renderBuscador = false;

    }


    public void renderMedicamentos() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }
    
    public void volver(){
        selectedIndex = ACTIVAR_FORMULA_MEDICA;
        renderBuscador = false;
    }
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }


    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param param
     */
    public void setListSexos(List<SelectItem> param) {
        this.listSexos = param;
    }


    /**
     * @return La lista de los sexos que existen
     */
    public List getListSexos() {
        if (listSexos.size() == 0) {
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
        if (listEstadoCivil.size() == 0) {
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

    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
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

    public void consultarFoliosUsuario() {
        if (usuario.getHuslnumero() != null) {
            try {
                lstFolios = 
                    this.getServiceLocator().getCirugiaService().getFoliosUsuarioSeguimientoTelefonico(usuario.getHuslnumero());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IMsg.MSG_SIN_DATOS);
            }
        }


    }
    
    public void consultarRegistros(){
        try {
        Long numeroUsuario = null;
        numeroUsuario = usuario.getHuslnumero();
        
        if(numeroUsuario != null){
            lstFoliosDos = this.serviceLocator.getCirugiaService().getFoliosUsuarioCirugia(numeroUsuario);

        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public void setDtFolios(HtmlDataTable dtFolios) {
        this.dtFolios = dtFolios;
    }

    public HtmlDataTable getDtFolios() {
        return dtFolios;
    }

    public void setLstFolios(List<Chcirugprogr> lstFolios) {
        this.lstFolios = lstFolios;
    }

    public List<Chcirugprogr> getLstFolios() {
        return lstFolios;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public String RegistrarSeguimientoTelefonico() {
 
        cirugia = (Chcirugprogr)this.dtFolios.getRowData();
        dtFolios.setFirst(IConstantes.OFFSET_DATATABLE);
        if (cirugia != null) {
            registrarFolio = 
                (RegistrarSeguimientoTelefonicoBean)FacesUtils.getManagedBean("registrarSeguimientoTelefonicoBean");
                
            if (registrarFolio != null) {
                registrarFolio.setCirugia(cirugia);
                registrarFolio.cargarDatos();
                return BeanNavegacion.RUTA_IR_SEGUIMIENTO_TELEFONICO;
            }
        }
        return null;
    }
    
   
    
    public String generar() {
        Chconsulta consulta = null;
        consulta = (Chconsulta)dtFoliosCirugia.getRowData();
        DatosBasicosUsuarioBean datosUsuario = (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
        
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
        
        return BeanNavegacion.RUTA_IR_GENERAR_FOLIOS_CIRUGIA;
    }


    public void setDtFoliosCirugia(HtmlDataTable dtFoliosCirugia) {
        this.dtFoliosCirugia = dtFoliosCirugia;
    }

    public HtmlDataTable getDtFoliosCirugia() {
        return dtFoliosCirugia;
    }

    public void setLstFoliosDos(List<Chconsulta> lstFoliosDos) {
        this.lstFoliosDos = lstFoliosDos;
    }

    public List<Chconsulta> getLstFoliosDos() {
        return lstFoliosDos;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }
}
