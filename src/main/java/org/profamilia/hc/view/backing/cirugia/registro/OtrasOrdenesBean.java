//=======================================================================
// ARCHIVO OtrasOrdenesBean.java
// FECHA CREACI�N: 
// AUTOR: CARLOS ANDRES VARGAS ROA
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.ChcontroordenPK;
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chparacgener;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class OtrasOrdenesBean extends BaseBean {

    private List<Chcontroorden> lstHistoricoOrdenes;
    private Chusuario usuario;
    private Long numeroConsulta;
    List<Chcontroorden> lstOtrasOrdenes;
    private boolean mostrarOrden;
    private String nuevasOrdenes;
    private Cpservicio servicio;
    private String observacionesOrden;
    private List lstOpciones;
    private String tipoServicio;
    private String tipoHistoria;
    private String nextAction;
    private String menuBean;
    private String nombreOrden;
    private String nombreSistemaOx;
    private HtmlDataTable dtOtrasOrdenes;
    private Chcontroorden controOrden;
    private String navigationRule;
    private Integer consecutivo;
    private HtmlDataTable dtHistoriasOtrasOrdenes;
    /**Almacena la lista de prescripci�n activas en esta o en otra consulta */
    private List<Chcontroorden> lstOrdenesSuspender;
    private List<SelectItem> lstaTipoOrden;
    private List<SelectItem> lstaTipoOrdenOxigeno;
    private boolean renderedTipoOrden;
    private boolean renderedTipoOrdenOxigeno;
    private Long numeroUsuario; 
    private List<Chcontroorden>lstOtrasOrdenesExterna;


    public OtrasOrdenesBean() {
    }

    public void init() {
        lstHistoricoOrdenes = new ArrayList<Chcontroorden>();
        lstOtrasOrdenesExterna = new ArrayList<Chcontroorden>();
        controOrden= new Chcontroorden();
        inicializarOtrasOrdenes();
        servicio = new Cpservicio();
        nextAction = "";
        mostrarOrden = false;
        nuevasOrdenes = "";
        nombreOrden="";
        lstaTipoOrden = new ArrayList<SelectItem>();
        lstaTipoOrdenOxigeno = new ArrayList<SelectItem>();
        renderedTipoOrden=false;
        renderedTipoOrdenOxigeno=false;
        
    }

    public void inicializarOtrasOrdenes() {


        // Obtiene el tipo de historia por numeroCirugia
         try {
            if(numeroConsulta != null)
            lstHistoricoOrdenes =
                                 this.serviceLocator.getClinicoService().getOtrasOrdenes(numeroConsulta);
                                 
            lstOtrasOrdenesExterna = serviceLocator.getCirugiaService().getLstOtrasOrdenesConsultaExterna(numeroUsuario, numeroConsulta);                     


        }catch(ModelException e){
            e.printStackTrace();
        }
        lstOtrasOrdenes = new ArrayList<Chcontroorden>();


      /*  try {
            if (numeroConsulta != null)
                lstOtrasOrdenes = 
                        this.serviceLocator.getClinicoService().getOtrasOrdenes(numeroConsulta);

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lstOtrasOrdenes == null || lstOtrasOrdenes.isEmpty()) {
            lstOtrasOrdenes = new ArrayList<Chcontroorden>();
        } else {
            Chcontroorden otraOrden;
            otraOrden = lstOtrasOrdenes.get(0);
            if (otraOrden != null) {

                mostrarOrden = false;
                nuevasOrdenes = "N";

            } else {
                lstHistoricoOrdenes = new ArrayList<Chcontroorden>();
                mostrarOrden = true;
                nuevasOrdenes = "S";

            }
       }*/ 
    }


    /**
     * @param valueChangeEvent
     */
    public void setNuevasOrdenes(ValueChangeEvent valueChangeEvent) {
        setNuevasOrdenes((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }


    public void changeOtrasOrdenes() {
        if (nuevasOrdenes.equals("S")) {
            mostrarOrden = true;
        } else {
            lstOtrasOrdenes = new ArrayList<Chcontroorden>();
            mostrarOrden = false;
        }
    }
    
    public void changeTipoOrden() {
        if (!nombreOrden.equals("OX")) {
            renderedTipoOrden=true;
            renderedTipoOrdenOxigeno=false;
        } else {
            renderedTipoOrden=false;
            renderedTipoOrdenOxigeno=true;
        }
    }


    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoHistoria(String tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public String getTipoHistoria() {
        return tipoHistoria;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }


    public boolean esValido() {
        boolean esValido = false;
        List<Chcontroorden> lstOtrasOrdenes = null;
        if (numeroConsulta != null) {

            try {
                lstOtrasOrdenes = 
                        this.serviceLocator.getClinicoService().getOtrasOrdenes(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (lstOtrasOrdenes != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    /**
     * @return
     */
    public String agregarOtrasOrdenes() {

        Chcontroorden orden;
        orden = new Chcontroorden();


        if (nombreOrden != null && !nombreOrden.equals("") && 
            observacionesOrden != null && !observacionesOrden.equals("") ) {
            if(!nombreOrden.equals("OX")){
                orden.setHcocnombreord(nombreOrden);
                orden.setHcocordenenvi(observacionesOrden);
                orden.setHcoccestadoadminox("N");
                orden.setHcocoperaasig(userName());
                orden.setHcodfechaasig(new Date());
                orden.setHconevoluconse(consecutivo);
                orden.setHcolusuario(numeroUsuario);
                lstOtrasOrdenes.add(orden);
            }
            else{
                orden.setHcocnombreord(nombreOrden);
                orden.setHcoccantlitros(controOrden.getHcoccantlitros());
                orden.setHcoccantminutos(controOrden.getHcoccantminutos());
                orden.setHcocsistoxige(controOrden.getHcocsistoxige());
                orden.setHcoccduracion(nombreOrden +" "+controOrden.getHcoccantlitros()+" Lt / "+controOrden.getHcoccantminutos()+" Minutos ,  "+observacionesOrden);
                orden.setHcocordenenvi(nombreOrden +" "+controOrden.getHcoccantlitros()+" Lt / "+controOrden.getHcoccantminutos()+" Minutos ,  "+observacionesOrden);
                orden.setHcocoperaasig(userName());
                orden.setHcodfechaasig(new Date());
                if(nombreOrden.equals("OX")){
                orden.setHcoccadminisoxig("S");
                }
                else{
                orden.setHcoccadminisoxig("N");
                }
                orden.setHcoccadminoxigdesc(observacionesOrden);
                orden.setHconevoluconse(consecutivo);
                orden.setHcolusuario(numeroUsuario);
                lstOtrasOrdenes.add(orden);
            }
           
            nombreOrden = "";
            observacionesOrden = "";
            controOrden.setHcocsistoxige(null);
            controOrden.setHcoccantlitros(null);
            controOrden.setHcoccantminutos(null);
            renderedTipoOrden=false;
            renderedTipoOrdenOxigeno=false;
            
        } else {
            FacesUtils.addErrorMessage("Debe Registrar Otras Ordenes");
        }
        return null;

    }
    


    /**
     * Backing bean action para eliminar una tarjeta.
     * 
     * @return the navigation result
     */
    public String eliminarOtrasOrdenes() {
        this.controOrden = (Chcontroorden)this.dtOtrasOrdenes.getRowData();
        this.lstOtrasOrdenes.remove(controOrden);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
        return BeanNavegacion.SUCCESS;
    }


   

    public String aceptar() {
    
    
        lstOrdenesSuspender = new ArrayList<Chcontroorden>();
        if (lstHistoricoOrdenes != null && 
            !lstHistoricoOrdenes.isEmpty()) {
            for (Chcontroorden medicsusp: lstHistoricoOrdenes) {
                if (medicsusp.isHcobsuspender()) {
                    medicsusp.setHcocoperamodif(userName());
                    lstOrdenesSuspender.add(medicsusp);
                }
            }
        }
        
        if (lstOtrasOrdenesExterna != null && 
            !lstOtrasOrdenesExterna.isEmpty()) {
            for (Chcontroorden medicsusp: lstOtrasOrdenesExterna) {
                if (medicsusp.isHcobsuspender()) {
                    medicsusp.setHcocoperamodif(userName());
                    lstOrdenesSuspender.add(medicsusp);
                }
            }
        }

        if (lstOtrasOrdenes != null && !lstOtrasOrdenes.isEmpty()) {
            try {
                this.getServiceLocator().getClinicoService().saveOtrasOrdenes(lstOtrasOrdenes, 
                                                                              numeroConsulta, 
                                                                              userName(),lstOrdenesSuspender);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);


            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);

                e.printStackTrace();
            }
        }else if (lstOrdenesSuspender != null && !lstOrdenesSuspender.isEmpty()){
            try {
                this.getServiceLocator().getClinicoService().saveOtrasOrdenes(null, 
                                                                              numeroConsulta, 
                                                                              userName(),lstOrdenesSuspender);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);


            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);

                e.printStackTrace();
            }
        }
        lstOtrasOrdenes.clear();
        init();
        

        return navigationRule;

    }


    public void setMostrarOrden(boolean mostrarOrden) {
        this.mostrarOrden = mostrarOrden;
    }

    public boolean isMostrarOrden() {
        return mostrarOrden;
    }

    public void setNuevasOrdenes(String nuevasOrdenes) {
        this.nuevasOrdenes = nuevasOrdenes;
    }

    public String getNuevasOrdenes() {
        return nuevasOrdenes;
    }

    public void setControOrden(Chcontroorden controOrden) {
        this.controOrden = controOrden;
    }

    public Chcontroorden getControOrden() {
        return controOrden;
    }

    public void setNombreOrden(String nombreOrden) {
        this.nombreOrden = nombreOrden;
    }

    public String getNombreOrden() {
        return nombreOrden;
    }

    public void setObservacionesOrden(String observacionesOrden) {
        this.observacionesOrden = observacionesOrden;
    }

    public String getObservacionesOrden() {
        return observacionesOrden;
    }

    public void setDtOtrasOrdenes(HtmlDataTable dtOtrasOrdenes) {
        this.dtOtrasOrdenes = dtOtrasOrdenes;
    }

    public HtmlDataTable getDtOtrasOrdenes() {
        return dtOtrasOrdenes;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setLstOtrasOrdenes(List<Chcontroorden> lstOtrasOrdenes) {
        this.lstOtrasOrdenes = lstOtrasOrdenes;
    }

    public List<Chcontroorden> getLstOtrasOrdenes() {
        return lstOtrasOrdenes;
    }

    public void setLstHistoricoOrdenes(List lstHistoricoOrdenes) {
        this.lstHistoricoOrdenes = lstHistoricoOrdenes;
    }

    public List getLstHistoricoOrdenes() {
        return lstHistoricoOrdenes;
    }

    public void setDtHistoriasOtrasOrdenes(HtmlDataTable dtHistoriasOtrasOrdenes) {
        this.dtHistoriasOtrasOrdenes = dtHistoriasOtrasOrdenes;
    }

    public HtmlDataTable getDtHistoriasOtrasOrdenes() {
        return dtHistoriasOtrasOrdenes;
    }

    public void setLstOrdenesSuspender(List<Chcontroorden> lstOrdenesSuspender) {
        this.lstOrdenesSuspender = lstOrdenesSuspender;
    }

    public List<Chcontroorden> getLstOrdenesSuspender() {
        return lstOrdenesSuspender;
    }

    public void setLstaTipoOrden(List<SelectItem> lstaTipoOrden) {
        this.lstaTipoOrden = lstaTipoOrden;
    }

    public List<SelectItem> getLstaTipoOrden() {
        if(lstaTipoOrden.isEmpty() || lstaTipoOrden==null){
                lstaTipoOrden = new ArrayList();
                lstaTipoOrden.add(new SelectItem("IV", "Iniciar v�a oral"));
                lstaTipoOrden.add(new SelectItem("RV", "Retirar sonda vesical"));
                lstaTipoOrden.add(new SelectItem("TS", "Tomar Retirar sonda vesicalglucometria"));
                lstaTipoOrden.add(new SelectItem("CP", "Cambio de posici�n"));
                lstaTipoOrden.add(new SelectItem("OX", "Oxigeno"));
                lstaTipoOrden.add(new SelectItem("OT", "Otro. Cu�l? "));
                return lstaTipoOrden;
            }
        return lstaTipoOrden;
    }

    public void setRenderedTipoOrden(boolean renderedTipoOrden) {
        this.renderedTipoOrden = renderedTipoOrden;
    }

    public boolean isRenderedTipoOrden() {
        return renderedTipoOrden;
    }

    public void setRenderedTipoOrdenOxigeno(boolean renderedTipoOrdenOxigeno) {
        this.renderedTipoOrdenOxigeno = renderedTipoOrdenOxigeno;
    }

    public boolean isRenderedTipoOrdenOxigeno() {
        return renderedTipoOrdenOxigeno;
    }

    public void setLstaTipoOrdenOxigeno(List<SelectItem> lstaTipoOrdenOxigeno) {
        this.lstaTipoOrdenOxigeno = lstaTipoOrdenOxigeno;
    }

    public List<SelectItem> getLstaTipoOrdenOxigeno() {
        if(lstaTipoOrdenOxigeno.isEmpty() || lstaTipoOrdenOxigeno==null){
                lstaTipoOrdenOxigeno = new ArrayList();
                lstaTipoOrdenOxigeno.add(new SelectItem("", "Seleccione ..."));
                lstaTipoOrdenOxigeno.add(new SelectItem("MA", "Mascara"));
                lstaTipoOrdenOxigeno.add(new SelectItem("CA", "C�nula"));
                lstaTipoOrdenOxigeno.add(new SelectItem("VE", "Ventury"));
                return lstaTipoOrdenOxigeno;
            }
        return lstaTipoOrdenOxigeno;
    }

    public void setNombreSistemaOx(String nombreSistemaOx) {
        this.nombreSistemaOx = nombreSistemaOx;
    }

    public String getNombreSistemaOx() {
        return nombreSistemaOx;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setLstOtrasOrdenesExterna(List<Chcontroorden> lstOtrasOrdenesExterna) {
        this.lstOtrasOrdenesExterna = lstOtrasOrdenesExterna;
    }

    public List<Chcontroorden> getLstOtrasOrdenesExterna() {
        return lstOtrasOrdenesExterna;
    }
}

