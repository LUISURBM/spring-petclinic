//=======================================================================
// ARCHIVO EntregaPatologiaBean.java
// FECHA CREACI�N: 23/05/2011
// AUTOR: Jhon Carranza Silva
// Descripci�n: Registro de entrega de patologias.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import org.profamilia.hc.model.dto.Chdetaentpatol;
import org.profamilia.hc.model.dto.Chentregapatol;
import org.profamilia.hc.model.dto.Chotraspatolog;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=======================================================================
//  CLASE EntregaPatologiaBean
//=======================================================================
public class EntregaPatologiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Integer idListado;
    
    private BigDecimal idPatologia;

    private HtmlDataTable dtlistadoPatologias;

    List<Chotraspatolog> listadoPatologias = new ArrayList<Chotraspatolog>();

    private String tipoLectura;
    
    /**
     * Actualizacion Resultados de Citologias 
     */
    private Integer idListado_mod;

    private String tipoLectura_mod;

    List<Chotraspatolog> listadoPatologias_mod = new ArrayList<Chotraspatolog>();

    List<Chotraspatolog> listadoPatologias_sel = new ArrayList<Chotraspatolog>();

    private HtmlDataTable dtlistadoPatologias_mod;
    
    Chentregapatol entregapatol = new Chentregapatol();
    
    private Chotraspatolog chotraspatologClone;
    
    /** Guarda el indice del registro consultado */
    private int indexDto;
    
    private String estadopatol;
    
    private String reclamaUsuaria;


    public EntregaPatologiaBean() {
    }

    public void init() {
        listadoPatologias = new ArrayList<Chotraspatolog>();
        listadoPatologias_mod = new ArrayList<Chotraspatolog>();
        listadoPatologias_sel = new ArrayList<Chotraspatolog>();
    }

    // ACTIONS

    public void generarlistadoPatologias_mod() { 
         if (this.idListado_mod == null && this.idPatologia == null) {
            FacesUtils.addErrorMessage(MSG_CONSULTA_POR_FILTROS);            
        } else{ 
            listadoPatologias_mod = new ArrayList<Chotraspatolog>();
            tipoLectura_mod = "";
            Chdetaentpatol detalle = new Chdetaentpatol();
            detalle.setHepcetapa(this.PATOLOGIA_REG_DIA);
            if(this.idListado_mod != null)             
                detalle.getComp_id().setHeplidentregapatol(idListado_mod.longValue());            
            if(this.idPatologia != null)             
                detalle.getComp_id().setHepnpatologia(idPatologia); 
    
            try {
                listadoPatologias_mod = 
                        (ArrayList<Chotraspatolog>)this.serviceLocator.getClinicoService().getListadoPatologias(detalle);
    
                if (listadoPatologias_mod.isEmpty()) {
                    FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
                }
    
            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            }
        
        }
    }

    public void guardar() {       
            try { 
                 chotraspatologClone.setEtapapatol(this.PATOLOGIA_ENT_USU);
                 this.serviceLocator.getClinicoService().saveOrUpdatePatologia(chotraspatologClone);                
                 this.listadoPatologias_mod.set(indexDto, chotraspatologClone);
                 FacesUtils.addInfoMessage(MSG_ACTUALIZACION); 
            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(),   MSG_NO_ACTUALIZACION);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(),  MSG_NO_ACTUALIZACION);
            }
    }
    
    /**
     * Backing bean action para ver la forma en edicion de profesionales.
     * @return the navigation result
     */
    public Object verEditar() {           
        this.chotraspatologClone = (Chotraspatolog)((Chotraspatolog)this.dtlistadoPatologias_mod.getRowData()).clone();
        chotraspatologClone.setChopdfechaent(new Date());
        
        
        if(this.chotraspatologClone.getChopcdiagn() != null && !this.chotraspatologClone.getChopcdiagn().equalsIgnoreCase("") ){            
            this.estadopatol = this.PATOLOGIA_REG_DIA;
        }else{
            this.estadopatol = this.NO_RECIBIDO;
        }  
        
        if(this.chotraspatologClone.getChopcnombrerecl() != null && !this.chotraspatologClone.getChopcnombrerecl().equalsIgnoreCase("") ){            
            this.reclamaUsuaria = "N";
        }else{
            this.reclamaUsuaria = "S";
        }
        
        indexDto = dtlistadoPatologias_mod.getRowIndex();
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

    public void setIdListado(Integer idListado) {
        this.idListado = idListado;
    }

    public Integer getIdListado() {
        return idListado;
    }

    public void setlistadoPatologias(List<Chotraspatolog> listadoPatologias) {
        this.listadoPatologias = listadoPatologias;
    }

    public List<Chotraspatolog> getlistadoPatologias() {
        return listadoPatologias;
    }

    public void setDtlistadoPatologias(HtmlDataTable dtlistadoPatologias) {
        this.dtlistadoPatologias = dtlistadoPatologias;
    }

    public HtmlDataTable getDtlistadoPatologias() {
        return dtlistadoPatologias;
    }

    public void setTipoLectura(String tipoLectura) {
        this.tipoLectura = tipoLectura;
    }

    public String getTipoLectura() {
        return tipoLectura;
    }

    public void setIdListado_mod(Integer idListado_mod) {
        this.idListado_mod = idListado_mod;
    }

    public Integer getIdListado_mod() {
        return idListado_mod;
    }

    public void setTipoLectura_mod(String tipoLectura_mod) {
        this.tipoLectura_mod = tipoLectura_mod;
    }

    public String getTipoLectura_mod() {
        return tipoLectura_mod;
    }

    public void setlistadoPatologias_mod(List<Chotraspatolog> listadoPatologias_mod) {
        this.listadoPatologias_mod = listadoPatologias_mod;
    }

    public List<Chotraspatolog> getlistadoPatologias_mod() {
        return listadoPatologias_mod;
    }

    public void setDtlistadoPatologias_mod(HtmlDataTable dtlistadoPatologias_mod) {
        this.dtlistadoPatologias_mod = dtlistadoPatologias_mod;
    }

    public HtmlDataTable getDtlistadoPatologias_mod() {
        return dtlistadoPatologias_mod;
    }

    public void setIdPatologia(BigDecimal idPatologia) {
        this.idPatologia = idPatologia;
    }

    public BigDecimal getIdPatologia() {
        return idPatologia;
    }

    public void setChotraspatologClone(Chotraspatolog chotraspatologClone) {
        this.chotraspatologClone = chotraspatologClone;
    }

    public Chotraspatolog getChotraspatologClone() {
        return chotraspatologClone;
    }

    public void setIndexDto(int indexDto) {
        this.indexDto = indexDto;
    }

    public int getIndexDto() {
        return indexDto;
    }
    
    public void setEstadopatol(ValueChangeEvent valueChangeEvent) {
        setEstadopatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setEstadopatol(String estadopatol) {
        this.estadopatol = estadopatol;
    }

    public String getEstadopatol() {
        return estadopatol;
    }

    public void setReclamaUsuaria(String reclamaUsuaria) {
        this.reclamaUsuaria = reclamaUsuaria;
    }
    
    public void setReclamaUsuaria(ValueChangeEvent valueChangeEvent) {
        setReclamaUsuaria((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getReclamaUsuaria() {
        return reclamaUsuaria;
    }
}


