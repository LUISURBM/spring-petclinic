//=======================================================================
// ARCHIVO ConfirmarServicioBean.java
// FECHA CREACI�N: 14/01/2019
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la confirmacion del servicio
//=======================================================================
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.CfdetaadmisionPK;
import org.profamilia.hc.model.dto.Cfnoveadmi;
import org.profamilia.hc.model.dto.Cfnovedeta;
import org.profamilia.hc.model.dto.Chconfiservi;
import org.profamilia.hc.model.dto.Chgeslabor;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================

//=================================================================
//  CLASE AplicacionVacunaCervixBean
//=======================================================================
public class ConfirmarServicioBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chusuario usuario;
    private Chconfiservi confirmacion;
    private String nextAction;
    private String menuBean;
    private Long numeroConsulta;
    private String tipoServicio;
    private String navigationRule;
    private Cnconsclin consulta;
    private Cfadmision admision;
    private String usuarioRegistro;
    private Cfdetaadmision detalleAdmision;
    private List<Cfdetaadmision> detalleAdmisionLista;
    private List listServiciosProfesional;
    // Lista de los servicios de los Profesionales X Contrato
    private List lstServicios;
    private List<SelectItem> listaConfirmacion;
    private Chgeslabor chgeslabor;
    private Cpservicio servicio;
    private Boolean validacionRegistro;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ConfirmarServicioBean() {
    }

    public void init() {
        inicalizarConfirmarServicioBean();

    }
    //ACTIONS

    public void inicalizarConfirmarServicioBean() {
        tipoServicio = "C";

        try {
            confirmacion = 
                    serviceLocator.getClinicoService().getConfirmacionServicio(numeroConsulta);
                    if(confirmacion == null){
                        validacionRegistro=false;
                    }else{
                        validacionRegistro = true;
                    }
        } catch (ModelException e) {
            e.printStackTrace();
        }

         try {

            if (consulta != null && consulta.getCcocservic() != null) {
                lstServicios =
                        this.serviceLocator.getClinicoService().getServiciosPorProfesionalXContrato(getClinica().getCclncodigo(),
                                                                                                    getUsuarioSystem().getCurnprofes(),
                                                                                                    consulta.getCcocservic(),
                                                                                                    consulta.getCconcontra());
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }


        listServiciosProfesional = new ArrayList();

        if (lstServicios != null && !lstServicios.isEmpty()) {
            Iterator iter = lstServicios.iterator();
            while (iter.hasNext()) {
                Object[] a = (Object[])iter.next();
                listServiciosProfesional.add(new SelectItem(a[0].toString(), 
                                                            a[1].toString()));

            }
        }


        if (confirmacion == null) {
            confirmacion = new Chconfiservi();
            confirmacion.setHcscrealiservi("S");
            if (consulta != null && consulta.getCcocservic() != null) {
                confirmacion.setHcscserviingre(consulta.getCcocservic().getCsvccodigo());
                confirmacion.setDescServicioIngreso(consulta.getCcocservic().getCsvcnombre());
                confirmacion.setHcscserviegres(consulta.getCcocservic().getCsvccodigo());
                
                try {
                    servicio = 
                            serviceLocator.getClinicoService().getServicioPorId(confirmacion.getHcscserviingre());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

            }

            if (consulta != null && consulta.getCconnumero() != null) {

                confirmacion.getComp_id().setHcslconsulta(new Long(consulta.getCconnumero()));
                confirmacion.getComp_id().setHcsctiposervi(tipoServicio);
                confirmacion.setHcsdfecregistr(new Date());
                confirmacion.setHcscoperador(userName());

            }
        } else {
            if (confirmacion.getHcscserviingre() != null) {
                try {
                    servicio = 
                            serviceLocator.getClinicoService().getServicioPorId(confirmacion.getHcscserviingre());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (servicio != null) {
                    confirmacion.setDescServicioIngreso(servicio.getCsvcnombre());
                }
            }
        }
        try {
            if (consulta != null && consulta.getCconnumero() != null) {
                chgeslabor = 
                        serviceLocator.getClinicoService().getLaboratorioXClinica(consulta.getCconclinic().longValue());
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }


    }

    //-----------------------------------------------------------------------------------------------
    //  Bot�n Principal
    //------------------------------------------------------------------------------------------------ 

    public String guardar() {
        navigationRule = "";

        try {
        
            if (servicio.getCsvntiphis().equals(IConstantes.HISTORIA_LABORATORIOS)) {
                if (chgeslabor != null) {
                    this.serviceLocator.getClinicoService().saveConfirmacionServicio(confirmacion, 
                                                                                     consulta, 
                                                                                     getUsuarioSystem().getCurcusuari(), 
                                                                                     chgeslabor.getHglncodprof().toString());
                }

            } else {
                this.serviceLocator.getClinicoService().saveConfirmacionServicio(confirmacion, 
                                                                                 consulta, 
                                                                                 getUsuarioSystem().getCurcusuari(), 
                                                                                 null);
            }
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

            // Se recarga el menu 
            FacesUtils.resetManagedBean(menuBean);
            FacesUtils.resetManagedBean("listaMisUsuariosBean");
            FacesUtils.resetManagedBean("listaUsuariosBean");
            nextAction=BeanNavegacion.RUTA_LISTA;
            navigationRule = nextAction;
            

        } catch (ModelException e) {
            e.printStackTrace();
            navigationRule = "";
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
        }


        return navigationRule;
    }
    //-----------------------------------------------------------------------------------------------
    //  Metodo esValido Garantiza que la informaci�n fue ingresada correctamente en la base de datos
    //------------------------------------------------------------------------------------------------

    public boolean esValido() {
        Long numero;
        numero = null;
        Chconfiservi confirmacionAux = null;

        if (numeroConsulta != null) {
            numero = numeroConsulta;
        }

        if (numero != null) {
            try {
                confirmacionAux = 
                        this.getServiceLocator().getClinicoService().getConfirmacionServicio(numero);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (confirmacionAux != null) {
            return true;
        }

        return false;
    }

    //-----------------------------------------------------------------------------------------------
    //  Jasper
    //------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Ajax
    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------
    //  Accesorios
    //-----------------------------------------------------------------------

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setConfirmacion(Chconfiservi confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Chconfiservi getConfirmacion() {
        return confirmacion;
    }

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

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setLstServicios(List lstServicios) {
        this.lstServicios = lstServicios;
    }

    public List getLstServicios() {
        return lstServicios;
    }

    public void setListServiciosProfesional(List listServiciosProfesional) {
        this.listServiciosProfesional = listServiciosProfesional;
    }

    public List getListServiciosProfesional() {
        return listServiciosProfesional;
    }

    public Cfadmision getAdmision() {
        return admision;
    }

    public void setAdmision(Cfadmision admision) {
        this.admision = admision;
    }

    public Cfdetaadmision getDetalleAdmision() {
        return detalleAdmision;
    }

    public void setDetalleAdmision(Cfdetaadmision detalleAdmision) {
        this.detalleAdmision = detalleAdmision;
    }

    public List<Cfdetaadmision> getDetalleAdmisionLista() {
        return detalleAdmisionLista;
    }

    public void setDetalleAdmisionLista(List<Cfdetaadmision> detalleAdmisionLista) {
        this.detalleAdmisionLista = detalleAdmisionLista;
    }

    public void setListaConfirmacion(List<SelectItem> listaConfirmacion) {
        this.listaConfirmacion = listaConfirmacion;
    }

    public List<SelectItem> getListaConfirmacion() {
        if (listaConfirmacion == null || listaConfirmacion.isEmpty()) {
            listaConfirmacion = new ArrayList();
            listaConfirmacion.add(new SelectItem("S", "SI"));
            listaConfirmacion.add(new SelectItem("N", "NO"));
        }
        return listaConfirmacion;
    }

    public void setChgeslabor(Chgeslabor chgeslabor) {
        this.chgeslabor = chgeslabor;
    }

    public Chgeslabor getChgeslabor() {
        return chgeslabor;
    }

    public void setServicio(Cpservicio servicio) {
        this.servicio = servicio;
    }

    public Cpservicio getServicio() {
        return servicio;
    }

    public void setValidacionRegistro(Boolean validacionRegistro) {
        this.validacionRegistro = validacionRegistro;
    }

    public Boolean getValidacionRegistro() {
        return validacionRegistro;
    }
}
