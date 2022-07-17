//=======================================================================
// ARCHIVO ProfesionalLecturaBean.java
// FECHA CREACI�N: 04/10/2010
// AUTOR: Jhon Carranza Silva
// Descripci�n: Administracion de los profesionales que realizan las
// lecturas de las citologias (patologos/laboratorios).
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.jboss.logging.Logger;

import org.profamilia.hc.model.dto.Chproflect;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ProfesionalLecturaBean
//======================================================================= 
public class ProfesionalLecturaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    static final Logger log = Logger.getLogger(ProfesionalLecturaBean.class);

    /** Objeto profesional lectura */
    private Chproflect profesionalLec;

    /** Clon del Objeto profesional lectura */
    private Chproflect profesionalLecClone;

    /** Data table de la forma para la lista de profesionales */
    private HtmlDataTable dtProfesionalLectura;

    /** Lista de profesionales para lectura */
    private List<Chproflect> listaProfesionalesLec = 
        new ArrayList<Chproflect>();

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

    private String idCentro;

    /** Lista  de Centros */
    private List listCentros;

    private String idProfesionalLectura;

    /** Lista  de Profesionales */
    private List listProfesionalLecturas;

    private String idCentroLectura;


    /** default constructor */
    public ProfesionalLecturaBean() {
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {

        profesionalLec = new Chproflect();
        listProfesionalLecturas = new ArrayList();
        fillCentros();
     }

    // ACTIONS


    /**
     * Backing bean action para adicionar tipos de temas.
     * @return the navigation result
     */
    public void guardar() {

        try {


            profesionalLecClone.getComp_id().setHplnclinlect(new Integer(this.idCentroLectura));
            profesionalLecClone.getComp_id().setHplncodprofes(new BigDecimal(this.idProfesionalLectura));
            profesionalLecClone.setHplnclinprof(new Integer(this.idCentro));

            if (this.serviceLocator.getClinicoService().getPatologosLecturas(profesionalLecClone).size() != 
                0) {
                FacesUtils.addErrorMessage(MSG_CODIGO_EXISTE);

            } else {

                this.serviceLocator.getClinicoService().saveProfesionalLectura(profesionalLecClone);

                this.listaProfesionalesLec.add(0, 
                                               (Chproflect)this.serviceLocator.getClinicoService().getPatologosLecturas(profesionalLecClone).iterator().next());
                FacesUtils.addInfoMessage(MSG_ADICION);

            }


        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_ADICION);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_ADICION);
        }

    }

    /**
     * Backing bean action para modificar tipos de temas.
     * @return the navigation result
     */
    public void modificar() {
        log.error("Entro log");

        try {

            profesionalLecClone.getComp_id().setHplnclinlect(new Integer(this.idCentroLectura));
            profesionalLecClone.getComp_id().setHplncodprofes(new BigDecimal(this.idProfesionalLectura));
            profesionalLecClone.setHplnclinprof(new Integer(this.idCentro));
            this.serviceLocator.getClinicoService().saveProfesionalLectura(profesionalLecClone);
            this.listaProfesionalesLec.set(indexDto, profesionalLecClone);
            FacesUtils.addInfoMessage(MSG_ACTUALIZACION);

        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), 
                                       MSG_NO_ACTUALIZACION);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), 
                                       MSG_NO_ACTUALIZACION);
        }
    }

    /**
     * Backing bean action para buscar profesionales de lecturas.
     * @return the navigation result
     */
    public void buscar() {
        try {

            listaProfesionalesLec = 
                    this.serviceLocator.getClinicoService().getPatologosLecturas(profesionalLec);
            if (listaProfesionalesLec.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            }

        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }
    }

    /**
     * Backing bean action para ver la forma en edicion de profesionales.
     * @return the navigation result
     */
    public Object verEditar() {

        this.profesionalLecClone = 
                (Chproflect)((Chproflect)this.dtProfesionalLectura.getRowData()).clone();
        indexDto = dtProfesionalLectura.getRowIndex();
        this.editar = true;
        this.adicionar = false;
        this.readOnly = true;
        this.titulo = "Modificar Profesional Lectura";
        this.idCentro = profesionalLecClone.getHplnclinprof() + "";
        changeCentros();
        this.idProfesionalLectura = 
                profesionalLecClone.getComp_id().getHplncodprofes() + "";
        this.idCentroLectura = 
                profesionalLecClone.getComp_id().getHplnclinlect() + "";

        profesionalLecClone.setHplcoperador(this.getUsuarioSystem().getCurcusuari());
        profesionalLecClone.setHpldfechamod(new Date());

        return BeanNavegacion.RUTA_ADICIONAR;

    }

    /**
     * Backing bean action para ver la forma en adicion de Profesional Lectura.
     * @return the navigation result
     */
    public Object verAdicionar() {

        this.editar = false;
        this.adicionar = true;
        this.titulo = "Registrar Profesional Lectura";
        this.readOnly = false;
        this.profesionalLecClone = (Chproflect)new Chproflect().clone();
        this.profesionalLecClone.setHplcestado("VG");
        this.idCentro = "";
        this.idProfesionalLectura = "";
        this.idCentroLectura = "";
        listProfesionalLecturas = new ArrayList();

        profesionalLecClone.setHplcoperador(this.getUsuarioSystem().getCurcusuari());
        profesionalLecClone.setHpldfechamod(new Date());

        return BeanNavegacion.RUTA_ADICIONAR;

    }

    /**
     * Backing bean action para una regla de navegacion global.
     * @return the navigation result
     */
    public Object volverConsulta() {
        return BeanNavegacion.RUTA_REGRESAR;
    }


    public void fillCentros() {
        listCentros = new ArrayList();

        try {
            List<Cpclinica> tabla = this.serviceLocator.getClinicoService().getClinicas();
            for (Cpclinica combo: tabla) {
                listCentros.add(new SelectItem(combo.getCclncodigo().toString(), 
                                               combo.getCclcnombre()));
            }
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

    }

    public void changeCentros() {

        this.listProfesionalLecturas = new ArrayList();
        if (this.idCentro != null && !this.idCentro.equalsIgnoreCase("")) {


            try {
                List<Cpprofesio> tabla = this.serviceLocator.getClinicoService().getListaProfesionalesXClinica(new Integer(idCentro));
                for (Cpprofesio combo: tabla) {
                    listProfesionalLecturas.add(new SelectItem(combo.getId().getCpfncodigo().toString(), 
                                                               combo.getCpfcnombre()));
                }
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }

        } else {
            this.idCentro = "";
            listProfesionalLecturas = new ArrayList();
        }

    }

    //ACCESSORS


    /**
     * @param profesionalLec
     */
    public void setProfesionalLec(Chproflect profesionalLec) {
        this.profesionalLec = profesionalLec;
    }

    /**
     * @return
     */
    public Chproflect getProfesionalLec() {
        return profesionalLec;
    }

    /**
     * @param profesionalLecClone
     */
    public void setProfesionalLecClone(Chproflect profesionalLecClone) {
        this.profesionalLecClone = profesionalLecClone;
    }

    /**
     * @return
     */
    public Chproflect getProfesionalLecClone() {
        return profesionalLecClone;
    }

    /**
     * @param dtProfesionalLectura
     */
    public void setDtProfesionalLectura(HtmlDataTable dtProfesionalLectura) {
        this.dtProfesionalLectura = dtProfesionalLectura;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtProfesionalLectura() {
        return dtProfesionalLectura;
    }

    /**
     * @param listaProfesionalesLec
     */
    public void setListaProfesionalesLec(List<Chproflect> listaProfesionalesLec) {
        this.listaProfesionalesLec = listaProfesionalesLec;
    }

    /**
     * @return
     */
    public List<Chproflect> getListaProfesionalesLec() {
        return listaProfesionalesLec;
    }

    /**
     * @param editar
     */
    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    /**
     * @return
     */
    public boolean isEditar() {
        return editar;
    }

    /**
     * @param adicionar
     */
    public void setAdicionar(boolean adicionar) {
        this.adicionar = adicionar;
    }

    /**
     * @return
     */
    public boolean isAdicionar() {
        return adicionar;
    }

    /**
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param readOnly
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param indexDto
     */
    public void setIndexDto(int indexDto) {
        this.indexDto = indexDto;
    }

    /**
     * @return
     */
    public int getIndexDto() {
        return indexDto;
    }

    /**
     * @param valueChangeEvent
     */
    public void setIdCentro(ValueChangeEvent valueChangeEvent) {
        setIdCentro((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param idCentro
     */
    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    /**
     * @return
     */
    public String getIdCentro() {
        return idCentro;
    }

    /**
     * @param listCentros
     */
    public void setListCentros(List listCentros) {
        this.listCentros = listCentros;
    }

    /**
     * @return
     */
    public List getListCentros() {
        return listCentros;
    }

    /**
     * @param idProfesionalLectura
     */
    public void setIdProfesionalLectura(String idProfesionalLectura) {
        this.idProfesionalLectura = idProfesionalLectura;
    }

    /**
     * @return
     */
    public String getIdProfesionalLectura() {
        return idProfesionalLectura;
    }

    /**
     * @param listProfesionalLecturas
     */
    public void setListProfesionalLecturas(List listProfesionalLecturas) {
        this.listProfesionalLecturas = listProfesionalLecturas;
    }

    /**
     * @return
     */
    public List getListProfesionalLecturas() {
        return listProfesionalLecturas;
    }

    /**
     * @param idCentroLectura
     */
    public void setIdCentroLectura(String idCentroLectura) {
        this.idCentroLectura = idCentroLectura;
    }

    /**
     * @return
     */
    public String getIdCentroLectura() {
        return idCentroLectura;
    }
    
    
}


