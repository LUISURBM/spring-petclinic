package org.profamilia.hc.view.backing.clinico.consultas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chhistoimpre;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.consultorio.ReimprimirDocumentosBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class ConsultarFoliosDocumento extends BaseBean implements JRDataSource {


    private Chusuario usuario;

    /** Lista de sexos */
    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    /** Lista que almacena las consultas de un Usuario */
    private List<Chconsulta> lstFolios;

    private HtmlDataTable dtFolios;

    private Integer edad;

    /** Almacena el objeto de impresion */
    Chhistoimpre objetoImpresion;


    /** Almacena true si genero el folio seleccionado */
    private

    boolean generoHistoria;

    /** Almacena la consulta seleccionada*/
    Chconsulta consultaClone;

    ReimprimirDocumentosBean imprimirDocumento;


    String titulo = "";
    int total = 0;

    private int index = -1;

    List<String> datos = new ArrayList<String>();


    public ConsultarFoliosDocumento() {
    }

    public void init() {

        listSexos = new ArrayList<SelectItem>();
        listEstadoCivil = new ArrayList<SelectItem>();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        lstFolios = new ArrayList<Chconsulta>();
        generoHistoria = false;
        if (usuario == null) {
            usuario = new Chusuario();
        }

    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
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
                        this.getServiceLocator().getClinicoService().getFoliosUsuarioPorFecha(usuario.getHuslnumero(), 
                                                                                              null, 
                                                                                              null);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstFolios == null || lstFolios.isEmpty()) {
                FacesUtils.addErrorMessage(IMsg.MSG_SIN_DATOS);
            }
        }


    }


    public void setDtFolios(HtmlDataTable dtFolios) {
        this.dtFolios = dtFolios;
    }

    public HtmlDataTable getDtFolios() {
        return dtFolios;
    }

    public void setLstFolios(List<Chconsulta> lstFolios) {
        this.lstFolios = lstFolios;
    }

    public List<Chconsulta> getLstFolios() {
        return lstFolios;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return false;
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("NOMBRE")) {
            value = "";
        }
        return value;
    }

    public void setGeneroHistoria(boolean generoHistoria) {
        this.generoHistoria = generoHistoria;
    }

    public boolean isGeneroHistoria() {
        return generoHistoria;
    }

    public String ConsultarConducta() {
        Chconsulta consultaAux;
        consultaAux = (Chconsulta)dtFolios.getRowData();
        imprimirDocumento = 
                (ReimprimirDocumentosBean)FacesUtils.getManagedBean("reimprimirDocumentosBean");
        if (consultaAux != null && imprimirDocumento != null) {
            imprimirDocumento.setConsulta(consultaAux);
            if (usuario != null)
                imprimirDocumento.setUsuario(usuario);
            return BeanNavegacion.RUTA_IR_REIMPRIMIR_DOCUMENTOS;
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }


}

