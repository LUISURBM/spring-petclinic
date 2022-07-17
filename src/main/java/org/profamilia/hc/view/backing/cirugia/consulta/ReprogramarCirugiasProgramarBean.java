package org.profamilia.hc.view.backing.cirugia.consulta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.comun.CambiarCirugiaBean;
import org.profamilia.hc.view.backing.cirugia.comun.EncabezadoCirugiaProgramadaBean;
import org.profamilia.hc.view.backing.cirugia.comun.MantenimientoCirugiasBean;
import org.profamilia.hc.view.backing.cirugia.registro.ModificarProgramacionBean;
import org.profamilia.hc.view.backing.cirugia.registro.ReprogramarCirugiaBean;
import org.profamilia.hc.view.backing.comun.DatosBasicosUsuarioCirugiaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


public class ReprogramarCirugiasProgramarBean extends BaseBean {

    private List<Chcirugprogr> lstUsuarios;

    private HtmlDataTable dtConsultaUsuario;

    private Chusuario usuario;
    
    private Chcirugprogr cirugia;
    
    private List<Chdetacirpro> detaciru;

    private Long numeroConsulta;

    private Cpservicio servicio;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private boolean existenCriterios;

    ReprogramarCirugiaBean modificar;
    
    private List<Chcirugprogr> lstCirugiasCompleta;



    public ReprogramarCirugiasProgramarBean() {
    }

    public void init() {

        listTipoIdentificacion = new ArrayList<SelectItem>();
          lstCirugiasCompleta = new ArrayList<Chcirugprogr>();
        usuario = new Chusuario();
      }


    /**
     * @param lstUsuarios
     */
    public void setLstUsuarios(List<Chcirugprogr> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List<Chcirugprogr> getLstUsuarios() {
        return lstUsuarios;
    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List<SelectItem> param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
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


    /**
     * @param dtConsultaUsuario
     */
    public void setDtConsultaUsuario(HtmlDataTable dtConsultaUsuario) {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtConsultaUsuario() {
        return dtConsultaUsuario;
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
     * @return
     */
    public String buscarUsuarioProgramacion() {
        existenCriterios = true;
        if (usuario == null) {
            existenCriterios = false;
        }

        if (usuario != null) {
            if (((usuario.getHusanumeiden() == null || 
                  usuario.getHusanumeiden().equals("")) && 
                 (usuario.getHuscprimernomb() == null || 
                  usuario.getHuscprimernomb().equals("")) && 
                 (usuario.getHuscsegundnomb() == null || 
                  usuario.getHuscsegundnomb().equals("")) && 
                 (usuario.getHuscsegundnomb() == null || 
                  usuario.getHuscsegundnomb().equals("")) && 
                 (usuario.getHuscsegundapel() == null || 
                  usuario.getHuscsegundapel().equals("")))) {
                existenCriterios = false;
            }

        }

        if (existenCriterios) {


            try {
                lstUsuarios = 
                        serviceLocator.getCirugiaService().getCirugiasModificarProgramadas(usuario);
                dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(lstUsuarios != null && !lstUsuarios.isEmpty()){
                for(Chcirugprogr ciru: lstUsuarios){
                    numeroConsulta = ciru.getHcplnumero();
                    String nombreServicio1 = "";


                                        try {
                                            detaciru = 
                                                    this.getServiceLocator().getCirugiaService().getServicioDetalleLista(numeroConsulta);
                                        } catch (ModelException e) {
                                            e.printStackTrace();
                                        }

                                        if (detaciru != null) {
                                            for(Chdetacirpro detalle: detaciru){
                                                try {
                                                    servicio = 
                                                            this.getServiceLocator().getClinicoService().getServicioPorId(detalle.getId().getHdccservicio());
                                                } catch (ModelException e) {
                                                    e.printStackTrace();
                                                }
                                           
                                           
                                            if (servicio != null && !servicio.equals("")) {
                                               
                                                    nombreServicio1 = nombreServicio1 + " - " + servicio.getCsvcnombre() ;
                                              
                                            }

                                            }
                                            ciru.setNombreServicio(nombreServicio1);
                                            lstCirugiasCompleta.add(ciru);
                                        }

                   
                }
                lstCirugiasCompleta = lstUsuarios;   
            }

            if (lstUsuarios == null || lstUsuarios.isEmpty()) {
                FacesUtils.addErrorMessage(MSG_SIN_DATOS_REPROGRAMAR_CIRUGIA);
            }


        } else {
            lstUsuarios = new ArrayList<Chcirugprogr>();
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * @return
     */
    public String consultar() {
        FacesUtils.resetManagedBean("reprogramarCirugiaBean");
        Long numeroCirugia = null; 
              Chcirugprogr cirugiaSelect = null;
              ReprogramarCirugiaBean reprogramar = 
                  (ReprogramarCirugiaBean)FacesUtils.getManagedBean("reprogramarCirugiaBean");
                  
        MantenimientoCirugiasBean mantenimientoCirugia = (MantenimientoCirugiasBean)FacesUtils.getManagedBean("mantenimientoCirugiasBean");
        
        CambiarCirugiaBean cambiarCirugia = (CambiarCirugiaBean)FacesUtils.getManagedBean("cambiarCirugiaBean");
        
        DatosBasicosUsuarioCirugiaBean datosUsuarioCirugia = 
            (DatosBasicosUsuarioCirugiaBean)FacesUtils.getManagedBean("datosBasicosUsuarioCirugiaBean");
        EncabezadoCirugiaProgramadaBean encabezado = 
            (EncabezadoCirugiaProgramadaBean)FacesUtils.getManagedBean("encabezadoCirugiaProgramadaBean");
                  
              cirugiaSelect = (Chcirugprogr)dtConsultaUsuario.getRowData();
              cirugia = cirugiaSelect;
              
              if (cirugiaSelect != null && reprogramar != null && datosUsuarioCirugia != null && encabezado != null) {
                  reprogramar.setReprogramar(cirugiaSelect);
                  reprogramar.cargarConsultas();
                  usuario = cirugiaSelect.getHcplusuario(); 
                  numeroCirugia = cirugiaSelect.getHcplnumero(); 
                  datosUsuarioCirugia.setUsuario(usuario);
                  encabezado.setCirugia(cirugia);
                  encabezado.inicializarCirugiasProgramadas();
                  
              }
              
        if(mantenimientoCirugia != null && numeroCirugia!= null){
            mantenimientoCirugia.setNumeroCirugia(numeroCirugia);
            mantenimientoCirugia.setUsuario(usuario);
            mantenimientoCirugia.cargarConsultas();
        }
        
        if(cambiarCirugia != null && numeroCirugia!= null){
            cambiarCirugia.setNumeroCirugia(numeroCirugia);
            cambiarCirugia.setUsuario(usuario);
            cambiarCirugia.cargarConsultas();
        }
              
              return BeanNavegacion.RUTA_IR_REPROGRAMACION_CIRUGIA;
    }

    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    public void setDetaciru(List<Chdetacirpro> detaciru) {
        this.detaciru = detaciru;
    }

    public List<Chdetacirpro> getDetaciru() {
        return detaciru;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setLstCirugiasCompleta(List<Chcirugprogr> lstCirugiasCompleta) {
        this.lstCirugiasCompleta = lstCirugiasCompleta;
    }

    public List<Chcirugprogr> getLstCirugiasCompleta() {
        return lstCirugiasCompleta;
    }
}
