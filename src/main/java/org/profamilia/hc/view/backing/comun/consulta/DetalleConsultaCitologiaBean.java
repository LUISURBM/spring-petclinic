package org.profamilia.hc.view.backing.comun.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class DetalleConsultaCitologiaBean extends BaseBean {


    private Chusuario usuario;

    private Cncitologi citologia;

    private Cncitotoma toma;

    private Cncitolect lectura;

    private List<SelectItem> listSexos;

    /** Almacena la lista de los posibles estados civil  */
    private List<SelectItem> listEstadoCivil;

    private Chlibrocitol libro;

    private boolean renderToma;

    private boolean renderLectura;

    private boolean renderEncabezado;

    private boolean renderEntrega;
    
    private boolean renderReclama; 
    
    private String reclamoUsuaria; 


    public DetalleConsultaCitologiaBean() {
    }


    public void init() {
        renderReclama = false; 
           
    }
    
    
    public void inicializarDetalle(){
        if(libro!= null){
            if(libro.getHlccnombrerecl() == null){
                renderReclama = false; 
                reclamoUsuaria = "SI"; 
            }else{
                renderReclama = true; 
                reclamoUsuaria = "NO"; 
            }
        }
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

    public void setListSexos(List<SelectItem> listSexos) {
        this.listSexos = listSexos;
    }

    public List getListSexos() {
        if (listSexos == null || listSexos.isEmpty()) {
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


    /**
     * @param citologia
     */
    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    /**
     * @return
     */
    public Cncitologi getCitologia() {
        return citologia;
    }

    /**
     * @param toma
     */
    public void setToma(Cncitotoma toma) {
        this.toma = toma;
    }

    /**
     * @return
     */
    public Cncitotoma getToma() {
        return toma;
    }

    /**
     * @param lectura
     */
    public void setLectura(Cncitolect lectura) {
        this.lectura = lectura;
    }

    /**
     * @return
     */
    public Cncitolect getLectura() {
        return lectura;
    }

    /**
     * @param libro
     */
    public void setLibro(Chlibrocitol libro) {
        this.libro = libro;
    }

    /**
     * @return
     */
    public Chlibrocitol getLibro() {
        return libro;
    }

    /**
     * @param renderReclama
     */
    public void setRenderReclama(boolean renderReclama) {
        this.renderReclama = renderReclama;
    }

    /**
     * @return
     */
    public boolean isRenderReclama() {
        return renderReclama;
    }


    /**
     * @param renderToma
     */
    public void setRenderToma(boolean renderToma) {
        this.renderToma = renderToma;
    }

    /**
     * @return
     */
    public boolean isRenderToma() {
        renderToma = false;
        if (toma != null) {
            renderToma = true;
        }
        return renderToma;
    }

    /**
     * @param renderLectura
     */
    public void setRenderLectura(boolean renderLectura) {
        this.renderLectura = renderLectura;
    }

    /**
     * @return
     */
    public boolean isRenderLectura() {
        renderLectura = false;
        if (lectura != null) {
            renderLectura = true;
        }
        return renderLectura;
    }

    /**
     * @param renderEncabezado
     */
    public void setRenderEncabezado(boolean renderEncabezado) {
        this.renderEncabezado = renderEncabezado;
    }

    /**
     * @return
     */
    public boolean isRenderEncabezado() {
        renderEncabezado = false;
        if (citologia != null) {
            renderEncabezado = true;
        }
        return renderEncabezado;
    }

    /**
     * @param renderEntrega
     */
    public void setRenderEntrega(boolean renderEntrega) {
        this.renderEntrega = renderEntrega;
    }

    /**
     * @return
     */
    public boolean isRenderEntrega() {
        renderEntrega = false;
        if (libro != null) {
            renderEntrega = true;
        }
        return renderEntrega;
    }


    /**
     * @return
     */
    public String volverConsulta() {
        FacesUtils.resetManagedBean("detalleConsultaCitologiaBean");
        return BeanNavegacion.RUTA_VER_ESTADO_CITOLOGIA;
    }


    public void setReclamoUsuaria(String reclamoUsuaria) {
        this.reclamoUsuaria = reclamoUsuaria;
    }

    public String getReclamoUsuaria() {
        return reclamoUsuaria;
    }
}
