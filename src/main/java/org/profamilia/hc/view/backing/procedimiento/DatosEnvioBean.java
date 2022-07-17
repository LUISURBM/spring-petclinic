//=======================================================================
// ARCHIVO DatosEnvioBean.java
// FECHA CREACI�N: 14/03/2011
// AUTOR: Jhon Carranza Silva
// Descripci�n: Registrar datos de envio de las patologias.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.jboss.logging.Logger;
import org.profamilia.hc.model.dto.Chentregapatol;
import org.profamilia.hc.model.dto.Sapermiso;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ProfesionalPatologoBean
//======================================================================= 
public class DatosEnvioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    static final Logger log = Logger.getLogger(DatosEnvioBean.class);

    /** Objeto patologias lectura */
    private Chentregapatol listaEntrega;

    /** Clon del Objeto patologias lectura */
    private Chentregapatol listaEntregaClone;

    /** Data table de la forma para la lista de envio de patologias */
    private HtmlDataTable dtListasEnvio;

    /** Lista de patologiases para lectura */
    private List<Chentregapatol> listaPatologiasEntreg = 
        new ArrayList<Chentregapatol>();

    /** Opcion para la operacion de edicion */
    private boolean editar;

    /** Opcion para la operacion de adicion */
    private boolean adicionar;

    /** Opcion para el titulo del formulario */
    private String titulo;

    /** Opcion de solo lectura */
    private boolean readOnly;

    /** Guarda el indice del registro consultado */
    private int indexDto;

    Sapermiso permisosForma;

 
    
    private Date fechaEnvio;
    



    /** default constructor */
    public DatosEnvioBean() {
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {
        listaEntrega = new Chentregapatol();
        permisosForma = new Sapermiso();
    }

    // ACTIONS




    /**
     * Backing bean action para modificar tipos de temas.
     * @return the navigation result
     */
    public void modificar() {
        log.error("Entro log");        
        try {
        
            listaEntregaClone.setHepdenvioorig(this.fechaEnvio);       
            
            this.serviceLocator.getClinicoService().saveCabeceraListaEnvio(listaEntregaClone);
            this.listaPatologiasEntreg.set(indexDto, listaEntregaClone);
            FacesUtils.addInfoMessage(MSG_ACTUALIZACION);

        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_ACTUALIZACION);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_ACTUALIZACION);
        }
    }

    /**
     * Backing bean action para buscar patologiases de lecturas.
     * @return the navigation result
     */
    public void buscar() {
        try {
            listaPatologiasEntreg = 
                    this.serviceLocator.getClinicoService().getListaEntregaPatol(listaEntrega);
            if (listaPatologiasEntreg.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            }
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }
    }

    /**
     * Backing bean action para ver la forma en edicion de patologiases.
     * @return the navigation result
     */
    public Object verEditar() {

        this.listaEntregaClone = (Chentregapatol)((Chentregapatol)this.dtListasEnvio.getRowData()).clone();
        indexDto = dtListasEnvio.getRowIndex();
        this.editar = true;
        this.adicionar = false;
        this.readOnly = true;
        this.titulo = "Registar Envio Listado";
        listaEntregaClone.setHepcoperador(this.getUsuarioSystem().getCurcusuari());
        listaEntregaClone.setHepdfechamod(new Date());
        this.fechaEnvio = (Date)listaEntregaClone.getHepdenvioorig();        
        return BeanNavegacion.RUTA_ADICIONAR;

    }



    /**
     * Backing bean action para una regla de navegacion global.
     * @return the navigation result
     */
    public Object volverConsulta() {
        return BeanNavegacion.RUTA_REGRESAR;
    }



    //ACCESSORS



    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setAdicionar(boolean adicionar) {
        this.adicionar = adicionar;
    }

    public boolean isAdicionar() {
        return adicionar;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setIndexDto(int indexDto) {
        this.indexDto = indexDto;
    }

    public int getIndexDto() {
        return indexDto;
    }

    public void setPermisosForma(Sapermiso permisosForma) {
        this.permisosForma = permisosForma;
    }

    public Sapermiso getPermisosForma() {
        return permisosForma;
    }
    
    // Datos de Envio

    public void setListaEntrega(Chentregapatol listaEntrega) {
        this.listaEntrega = listaEntrega;
    }

    public Chentregapatol getListaEntrega() {
        return listaEntrega;
    }

    public void setListaEntregaClone(Chentregapatol listaEntregaClone) {
        this.listaEntregaClone = listaEntregaClone;
    }

    public Chentregapatol getListaEntregaClone() {
        return listaEntregaClone;
    }

    public void setDtListasEnvio(HtmlDataTable dtListasEnvio) {
        this.dtListasEnvio = dtListasEnvio;
    }

    public HtmlDataTable getDtListasEnvio() {
        return dtListasEnvio;
    }

    public void setListaPatologiasEntreg(List<Chentregapatol> listaPatologiasEntreg) {
        this.listaPatologiasEntreg = listaPatologiasEntreg;
    }

    public List<Chentregapatol> getListaPatologiasEntreg() {
        return listaPatologiasEntreg;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }
}


