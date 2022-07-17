//=======================================================================
// ARCHIVO Registrar Asesoria Avise
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registro asesoria para avise
//=======================================================================
 package org.profamilia.hc.view.backing.asesoria.educativa;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chactiveduca;
import org.profamilia.hc.model.dto.Chetnia;
import org.profamilia.hc.model.dto.Chparameduca;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RegistrarAsesoriaAviseBean
//=======================================================================
public class RegistrarActividadEducativaBean extends BaseBean {


    private String nombreAsesor; 
    
    private Chactiveduca actividad; 
    
    private List lstActividad; 
    
    private List lstCondicion; 
    
    private List lstEjes; 
    
    private List lstNaturaleza; 
    
    private List lstPoblacion; 
    
    private List lstEtnia;


    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

  



    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarActividadEducativaBean() {

    }

    public void init() {
        nombreAsesor = getUsuarioSystem().getCurcnombre(); 
        actividad = new Chactiveduca(); 
        
        if(actividad != null){
            actividad.setHaedfechases(new Date());
        }
        
    }


    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------
    
  

    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

    /**
     * @param nombreAsesor
     */
    public void setNombreAsesor(String nombreAsesor) {
         this.nombreAsesor = nombreAsesor;
     }

    /**
     * @return
     */
    public String getNombreAsesor() {
         return nombreAsesor;
     }


    /**
     * @param actividad
     */
    public void setActividad(Chactiveduca actividad) {
        this.actividad = actividad;
    }

    /**
     * @return
     */
    public Chactiveduca getActividad() {
        return actividad;
    }

    /**
     * @param lstActividad
     */
    public void setLstActividad(List lstActividad) {
        this.lstActividad = lstActividad;
    }

    /**
     * @return
     */
    public List getLstActividad() {
        if (lstActividad == null || lstActividad.isEmpty()) {
            lstActividad = new ArrayList();
            ArrayList lstActividadAux = null;
            try {
                lstActividadAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getParametroEduca(EDUCATIVA_ACTIVIDAD);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstActividadAux.isEmpty()) {
                lstActividad.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstActividadAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstActividad.add(new SelectItem(((Chparameduca)lstActividadAux.get(i)).getId().getHpennumero(), 
                                                ((Chparameduca)lstActividadAux.get(i)).getHpecdescripcion()));
                }

            }
        }
        return lstActividad;
        }
    /**
     * @param lstCondicion
     */
    public void setLstCondicion(List lstCondicion) {
        this.lstCondicion = lstCondicion;
    }

    /**
     * @return
     */
    public List getLstCondicion() {
        if (lstCondicion == null || lstCondicion.isEmpty()) {
            lstCondicion = new ArrayList();
            ArrayList lstCondicionAux = null;
            try {
                lstCondicionAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getParametroEduca(EDUCATIVA_CONDICION);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstCondicionAux.isEmpty()) {
                lstCondicion.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstCondicionAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstCondicion.add(new SelectItem(((Chparameduca)lstCondicionAux.get(i)).getId().getHpennumero(), 
                                                ((Chparameduca)lstCondicionAux.get(i)).getHpecdescripcion()));
                }

            }
        }
        return lstCondicion;
        }

    /**
     * @param lstEjes
     */
    public void setLstEjes(List lstEjes) {
        this.lstEjes = lstEjes;
    }

    /**
     * @return
     */
    public List getLstEjes() {
        if (lstEjes == null || lstEjes.isEmpty()) {
            lstEjes = new ArrayList();
            ArrayList lstEjesAux = null;
            try {
                lstEjesAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getParametroEduca(EDUCATIVA_EJES);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstEjesAux.isEmpty()) {
                lstEjes.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstEjesAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstEjes.add(new SelectItem(((Chparameduca)lstEjesAux.get(i)).getId().getHpennumero(), 
                                                ((Chparameduca)lstEjesAux.get(i)).getHpecdescripcion()));
                }

            }
        }
        return lstEjes;
        }

    /**
     * @param lstNaturaleza
     */
    public void setLstNaturaleza(List lstNaturaleza) {
        this.lstNaturaleza = lstNaturaleza;
    }

    /**
     * @return
     */
    public List getLstNaturaleza() {
        if (lstNaturaleza == null || lstNaturaleza.isEmpty()) {
            lstNaturaleza = new ArrayList();
            ArrayList lstNaturalezaAux = null;
            try {
                lstNaturalezaAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getParametroEduca(EDUCATIVA_NATURALEZA);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstNaturalezaAux.isEmpty()) {
                lstNaturaleza.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstNaturalezaAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstNaturaleza.add(new SelectItem(((Chparameduca)lstNaturalezaAux.get(i)).getId().getHpennumero(), 
                                                ((Chparameduca)lstNaturalezaAux.get(i)).getHpecdescripcion()));
                }

            }
        }
        return lstNaturaleza;
        }

    /**
     * @param lstPoblacion
     */
    public void setLstPoblacion(List lstPoblacion) {
        this.lstPoblacion = lstPoblacion;
    }

    /**
     * @return
     */
    public List getLstPoblacion() {
        if (lstPoblacion == null || lstPoblacion.isEmpty()) {
            lstPoblacion = new ArrayList();
            ArrayList lstPoblacionAux = null;
            try {
                lstPoblacionAux = 
                        (ArrayList)getServiceLocator().getClinicoService().getParametroEduca(EDUCATIVA_POBLACION);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (!lstPoblacionAux.isEmpty()) {
                lstPoblacion.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = lstPoblacionAux.iterator();
                for (int i = 0; it.hasNext(); i++) {
                    it.next();
                    lstPoblacion.add(new SelectItem(((Chparameduca)lstPoblacionAux.get(i)).getId().getHpennumero(), 
                                                ((Chparameduca)lstPoblacionAux.get(i)).getHpecdescripcion()));
                }

            }
        }
        return lstPoblacion;
        }
        
        
    /**
     * @param lstEtnia
     */
    public void setLstEtnia(List lstEtnia) {
        this.lstEtnia = lstEtnia;
    }

    /**
     * @return
     */
    public List getLstEtnia() {
        if (lstEtnia == null || lstEtnia.isEmpty()) {
            lstEtnia = new ArrayList<SelectItem>();
            ArrayList<Chetnia> listEtniaAux = null;
            try {
                listEtniaAux = 
                        (ArrayList<Chetnia>)this.serviceLocator.getClinicoService().getListaEtnia();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listEtniaAux.isEmpty()) {

                Iterator it = listEtniaAux.iterator();
                int i = 0;
                lstEtnia.add(new SelectItem("", "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstEtnia.add(new SelectItem(listEtniaAux.get(i).getCetecodigo(), 
                                                listEtniaAux.get(i).getCetcdescripcio()));
                    i++;
                }
            }
        }
        return lstEtnia;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    public String guardarActividad() {
    
        actividad.setHaedfechregi(new Date());
        actividad.setHaecusuaregi(userName());
        actividad.setHaenclinic(getClinica().getCclncodigo());


        try {
            serviceLocator.getClinicoService().saveActividadEducativa(actividad);
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_COSNULTA);
        }
        return BeanNavegacion.RUTA_HOME;
    }


   
}
