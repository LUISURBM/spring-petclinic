 //=======================================================================
 // ARCHIVO MotivoBean.java
 // FECHA CREACI�N: 05/05/2010
 // AUTOR: Jos� Andr�s Riano
 // Descripci�n: Datos correspondientes a motivo de consulta
 //=======================================================================
 package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chfertdato;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.ChviolenciaPK;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorOcupacionBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
 //  BIBLIOTECAS REQUERIDAS
 //=======================================================================


 //=======================================================================
 //  CLASE MotivoBean
 //=======================================================================

 public class DatosFertilidadBean extends BaseBean {

     //-----------------------------------------------------------------------
     //  ATRIBUTOS DE INSTANCIA
     //-----------------------------------------------------------------------

   
    private Chfertdato fertdato; 

     private String nextAction;
     
     private Chconsulta consulta; 

     private String menuBean;

    private List lstOpciones;

    private boolean mostrarDonante;
    
    private boolean mostrarPareja;

     private Long numeroConsulta;

     private String tipoServicio;
     
     private String tienePareja;
     
     private String esDonante;
     
     //campos agregado
     
     private boolean numeroIdPareja;
     
     private String tieneNumeroIdPareja;
     
    private Cpocupacio ocupacioservix;
    
    private String seleccionOcupacion;
    
    private UIInput itOcupacion;
    
    private boolean deshabilitarOcupacion;
    
    private boolean renderBuscadorOcupacion;
    
    private static final int ACTIVAR_DATOS_FERTILIDAD = 0;

    private static final int ACTIVAR_BUSCADOR_OCUPACION = 1;
    
    private static final int BEAN_USUARIO_DATOS_FERTILIDAD = 4;
    
    private int selectedIndex;

     //-----------------------------
     /** Lista que almacena la lista de tipos de documentos  */
      private List<SelectItem> listTipoIdentificacion;
      
    /** Lista que almacena la lista de ocupaciones  */
    private List<SelectItem> listOcupaciones;
    
  
     //-----------------------------------------------------------------------
     //  METODO CONSTRUCTOR
     //-----------------------------------------------------------------------

     public DatosFertilidadBean() {
     }

     public void init() {

         nextAction = "";
         itOcupacion = new UIInput();
         selectedIndex = ACTIVAR_DATOS_FERTILIDAD;

         inicializarDatosPareja();
         
     }


     // ACTIONS

     public void inicializarDatosPareja () {
         mostrarDonante = false;
         mostrarPareja = false;
         numeroIdPareja = false;

         if (numeroConsulta != null) {
             try {
                 fertdato = 
                         getServiceLocator().getClinicoService().getDatosFertilidad(numeroConsulta);
                         
                 consulta = getServiceLocator().getClinicoService().getConsultaActual(numeroConsulta);
                         
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         }
         if (fertdato == null){
             fertdato = new Chfertdato();
             esDonante = "N";
             tienePareja = "N";
             tieneNumeroIdPareja ="N";
           
         } else {
             esDonante = fertdato.getHfdcdonant();
             tienePareja = fertdato.getHfdcpareja();
             tieneNumeroIdPareja = fertdato.getHfdcnumpareja();

             if (fertdato.getHfdcdonant() != null && 
                 fertdato.getHfdcdonant().equals("S")) {
                 mostrarDonante = true;
                 esDonante = "S";
                 tienePareja = "S";
             } else {
                 mostrarDonante = false;
                 esDonante = "N";
                 tienePareja = "N";
             }
             if (fertdato.getHfdcpareja() != null && 
                 fertdato.getHfdcpareja().equals("S")) {
                 mostrarPareja = true;
                 tienePareja = "S";
             } else {
                 mostrarPareja = false;
                 tienePareja = "N";
             }
             if (fertdato.getHfdcnumpareja() != null && 
                 fertdato.getHfdcnumpareja().equals("S")) {
                 numeroIdPareja = true;
                 tieneNumeroIdPareja = "S";
             } else {
                 numeroIdPareja = false;
                 tieneNumeroIdPareja = "N";
             }
         }
             
     }

     /**
      * @return
      */
     public boolean esValido() {
         boolean esValido = false;
          Chfertdato fertdatoAux = null;
         if (numeroConsulta != null)
             try {
                 fertdatoAux = 
                         getServiceLocator().getClinicoService().getDatosFertilidad(numeroConsulta);
             } catch (ModelException e) {
                 e.printStackTrace();
             }
         if (fertdatoAux != null)
             esValido = true;
         else
             esValido = false;
         return esValido;
     }


     //-----------------------------------------------------------------------
     //  GET /SET
     //-----------------------------------------------------------------------

     public void setNextAction(String nextAction) {
         this.nextAction = nextAction;
     }

     public String getNextAction() {
         return nextAction;
     }

     public void setMenuBean(String menuBean) {
         this.menuBean = menuBean;
     }

     public String getMenuBean() {
         return menuBean;
     }

  
     public void setNumeroConsulta(Long numeroConsulta) {
         this.numeroConsulta = numeroConsulta;
     }

     public Long getNumeroConsulta() {
         return numeroConsulta;
     }

     public void setTipoServicio(String tipoServicio) {
         this.tipoServicio = tipoServicio;
     }

     public String getTipoServicio() {
         return tipoServicio;
     }
     
     

        public void setListOcupaciones(List<SelectItem> param) {
            this.listOcupaciones = param;
        }

        public List<SelectItem> getListOcupaciones() {
            if (listOcupaciones == null || listOcupaciones.isEmpty()) {
                listOcupaciones = new ArrayList<SelectItem>();
                ArrayList<Cpocupacio> listOcpuacionesAux = null;
                try {
                    listOcpuacionesAux = 
                            (ArrayList<Cpocupacio>)this.serviceLocator.getClinicoService().getOcupaciones();
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (!listOcpuacionesAux.isEmpty()) {
                    listOcupaciones.add(new SelectItem("", 
                                                       "Seleccione una opcion..."));
                    Iterator it = listOcpuacionesAux.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        it.next();
                        listOcupaciones.add(new SelectItem(listOcpuacionesAux.get(i).getCocncodigo(), 
                                                           listOcpuacionesAux.get(i).getCoccdescri()));

                        i++;
                    }
                }
            }
            return listOcupaciones;
        }
     
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
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

     
     
     //-----------------------------------------------------------------------
     //  BOTON PRINCIPAL
     //-----------------------------------------------------------------------
     
     public String guardar(){
        String  navigationRule = "";
        fertdato.setHfddfecreg(new Date());
        changeDonante();
        changePareja();
        fertdato.setHfdlconsulta(numeroConsulta);
        fertdato.setHfdcnomreg(userName());
        
        try {
              this.serviceLocator.getClinicoService().saveDatosFertilidad(fertdato);
              FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

              // Se recarga el menu 
              
              DatosBasicosUsuarioBean datos = (DatosBasicosUsuarioBean)FacesUtils.getManagedBean("datosBasicosUsuarioBean");
              if(datos != null){
                  datos.setIdentPareja( formatearCampo(fertdato.getHfdctipide()) + " " + formatearCampo(fertdato.getHfdanumide()));
                  datos.setNombrePareja(formatearCampo(fertdato.getHfdcprinom()) + " " + formatearCampo(fertdato.getHfdcsegnom()) + " " + formatearCampo(fertdato.getHfdcpriape()) + " " + formatearCampo(fertdato.getHfdcsegape()) );
                  
                  if(fertdato.getHfdanumide() == null || fertdato.getHfdctipide() == null || fertdato.getHfdctipide().equals(""))
                            {
                                datos.setIdentPareja("Sin Dato");          
                            }
                            
                  if(fertdato.getHfdcprinom() == null || fertdato.getHfdcprinom().equals(""))
                            {
                                datos.setNombrePareja("Sin Dato");          
                            }
              }
              
              FacesUtils.resetManagedBean(menuBean);
              navigationRule = nextAction;
         } catch (ModelException e) {
              FacesUtils.addErrorMessage(null, e.getMessage(), 
                                         IMsg.MSG_NO_ADICION);
              e.printStackTrace();
              navigationRule = "";
         }
         
         return navigationRule;
         }

    /**
     * @param fertdato
     */
    public void setFertdato(Chfertdato fertdato) {
        this.fertdato = fertdato;
    }

    /**
     * @return
     */
    public Chfertdato getFertdato() {
        return fertdato;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    public void setEsDonante(String esDonante) {
        this.esDonante = esDonante;
    }

    public void setEsDonante(ValueChangeEvent valueChangeEvent) {
        setEsDonante((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getEsDonante() {
        return esDonante;
    }

    public void changeDonante() {
        if (esDonante != null && esDonante.equals("S")) {
            fertdato.setHfdcdonant("S");
            fertdato.setHfdcpareja("N");
            fertdato.setHfdcnumpareja("N");
            setTienePareja("N");
            setTieneNumeroIdPareja("N");
            mostrarPareja = false;
            mostrarDonante = true;
            numeroIdPareja=false;
        } else {
            mostrarDonante = false;
            fertdato.setHfdcdonant("N");
        }
    }
    
    public void changeSeleccionOcupacion() {
        seleccionOcupacion = null;

        if (fertdato.getHfdncodocupac() != null) {
            if (fertdato.getHfdncodocupac() != null) {
                try {
                    ocupacioservix = 
                            (Cpocupacio)this.serviceLocator.getClinicoService().getOcupacionPorCodigo(fertdato.getHfdncodocupac());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (ocupacioservix != null && 
                    ocupacioservix.getCocncodigo() != null) {

                    if (!ocupacioservix.getCocncodigo().equals(fertdato.getHfdncodocupac())) {
                        FacesUtils.addErrorMessage(seleccionOcupacion = 
                                                   "Ocupaci�n: " + 
                                                   fertdato.getHfdncodocupac() + 
                                                   " no Coincide, intente nuevamente");
                    } else {
                        seleccionOcupacion = ocupacioservix.getCoccdescri();
                        fertdato.setHfdcocupac(seleccionOcupacion);
                    }

                } else {
                    FacesUtils.addErrorMessage(seleccionOcupacion = 
                                               "Ocupaci�n: " + 
                                               fertdato.getHfdncodocupac() + 
                                               " no existe, intente nuevamente");
                }

            } else {
                FacesUtils.addErrorMessage(seleccionOcupacion = 
                                           "Por Favor escriba una Ocupaci�n");
            }

        }
    }
    /**
     * @param valueChangeEvent
     */
    public void setOcupacion(ValueChangeEvent valueChangeEvent) {
        fertdato.setHfdncodocupac((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setTienePareja(String tienePareja) {
        this.tienePareja = tienePareja;
    }

    public void setTienePareja(ValueChangeEvent valueChangeEvent) {
        setTienePareja((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getTienePareja() {
        return tienePareja;
    }

    public void changePareja() {
        if (tienePareja != null && tienePareja.equals("S")) {
            fertdato.setHfdcpareja("S");
            mostrarPareja = true;
        } else {
            fertdato.setHfdcpareja("N");
            mostrarPareja = false;
        }

    }
    
    public void renderOcupacion() {
        FacesUtils.resetManagedBean("buscadorOcupacionBean");
        renderBuscadorOcupacion = true;
        selectedIndex = ACTIVAR_BUSCADOR_OCUPACION;

        BuscadorOcupacionBean buscador = 
            (BuscadorOcupacionBean)FacesUtils.getManagedBean("buscadorOcupacionBean");
        buscador.setBeanAnterior(BEAN_USUARIO_DATOS_FERTILIDAD);

    }
    
         public void aceptarOcupacion() {

             BuscadorOcupacionBean ocupacionAux = 
                 (BuscadorOcupacionBean)FacesUtils.getManagedBean("buscadorOcupacionBean");


             if (ocupacionAux != null && 
                 ocupacionAux.getOcupacionSelect() != null) {
                 itOcupacion.setValue(ocupacionAux.getOcupacionSelect().getCocncodigo());
                 seleccionOcupacion = 
                         ocupacionAux.getOcupacionSelect().getCoccdescri();


                 fertdato.setHfdncodocupac(ocupacionAux.getOcupacionSelect().getCocncodigo());
                 fertdato.setHfdcocupac(seleccionOcupacion);
                 deshabilitarOcupacion = true;

             }
             selectedIndex = ACTIVAR_DATOS_FERTILIDAD;
             renderBuscadorOcupacion = false;

             FacesUtils.resetManagedBean("buscadorOcupacionBean");
         }

    
    public void changeNumeroIdPareja() {
        if (tieneNumeroIdPareja != null && tieneNumeroIdPareja.equals("S")) {
            fertdato.setHfdcnumpareja("S");
            numeroIdPareja = true;
        } else {
            fertdato.setHfdcnumpareja("N");
            numeroIdPareja = false;
        }

    }


    public void setMostrarDonante(boolean mostrarDonante) {
        this.mostrarDonante = mostrarDonante;
    }

    public boolean isMostrarDonante() {
        return mostrarDonante;
    }

    public void setMostrarPareja(boolean mostrarPareja) {
        this.mostrarPareja = mostrarPareja;
    }

    public boolean isMostrarPareja() {
        return mostrarPareja;
    }

    public void setNumeroIdPareja(boolean numeroIdPareja) {
        this.numeroIdPareja = numeroIdPareja;
    }
    
    public void setTieneNumeroIdPareja(ValueChangeEvent valueChangeEvent) {
        setTieneNumeroIdPareja((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public boolean isNumeroIdPareja() {
        return numeroIdPareja;
    }

    public void setTieneNumeroIdPareja(String tieneNumeroIdPareja) {
        this.tieneNumeroIdPareja = tieneNumeroIdPareja;
    }

    public String getTieneNumeroIdPareja() {
        return tieneNumeroIdPareja;
    }


    public void setOcupacioservix(Cpocupacio ocupacioservix) {
        this.ocupacioservix = ocupacioservix;
    }

    public Cpocupacio getOcupacioservix() {
        return ocupacioservix;
    }

    public void setSeleccionOcupacion(String seleccionOcupacion) {
        this.seleccionOcupacion = seleccionOcupacion;
    }

    public String getSeleccionOcupacion() {
        return seleccionOcupacion;
    }

    public void setItOcupacion(UIInput itOcupacion) {
        this.itOcupacion = itOcupacion;
    }

    public UIInput getItOcupacion() {
        return itOcupacion;
    }


    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }


    public void setRenderBuscadorOcupacion(boolean renderBuscadorOcupacion) {
        this.renderBuscadorOcupacion = renderBuscadorOcupacion;
    }

    public boolean isRenderBuscadorOcupacion() {
        return renderBuscadorOcupacion;
    }
}
