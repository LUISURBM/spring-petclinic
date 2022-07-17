//=======================================================================
// ARCHIVO OtrasPatologiasBean.java
// FECHA CREACI�N: 05/01/2011
// AUTOR: Jhon Carranza Silva
// Descripci�n: Ingreso de informaci�n correspondiente a otras patologias.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.jboss.logging.Logger;

import org.profamilia.hc.model.dto.Ccdetafact;
import org.profamilia.hc.model.dto.Ccdetfacve;
import org.profamilia.hc.model.dto.Ccfactserv;
import org.profamilia.hc.model.dto.Ccfactvent;
import org.profamilia.hc.model.dto.Chotraspatolog;
import org.profamilia.hc.model.dto.Chprofpatol;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE OtrasPatologiasBean
//=======================================================================

public class OtrasPatologiasBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    static final Logger log = Logger.getLogger(OtrasPatologiasBean.class);

    private Chotraspatolog chotraspatolog;

    private String idTipoDocumento;

    private String idCentro;

    /** Lista  de Centros */
    private List listCentros;

    private String servicioSelected;

    /** Lista  de Servicios en Factura */
    private List listServiciosFact;

    private String tipoIden;

    private BigDecimal numIden;

    private String nombUsuario;

    private boolean mostrarFactura;

    private boolean registrado;

    private String servicio;

    /** default constructor */
    public OtrasPatologiasBean() {
        chotraspatolog = new Chotraspatolog();
    }

    /**
     * Initializes UsuarioBean.
     * @see BaseBean#init()
     */
    protected void init() {
        servicio = null;
        registrado = false;
        mostrarFactura = false;
        fillCentros();
        chotraspatolog.setChopdfechareg(new Date());
        chotraspatolog.setChopcoperador(getUsuarioSystem().getCurcusuari());
        idTipoDocumento = null;
        idCentro = getClinica().getCclncodigo().toString();
        listServiciosFact = new ArrayList();
    }

    // ACTIONS

    public void inicializarBean() {
        servicio = null;
        registrado = false;
        chotraspatolog = new Chotraspatolog();
        chotraspatolog.setChopdfechareg(new Date());
        chotraspatolog.setChopcoperador(getUsuarioSystem().getCurcusuari());
        idTipoDocumento = null;
        idCentro = getClinica().getCclncodigo().toString();
        listServiciosFact = new ArrayList();
        tipoIden = null;
        numIden = null;
        nombUsuario = null;
        mostrarFactura = false;
    }

    /**
     * Backing bean action para adicionar tipos de temas.
     * @return the navigation result
     */
    public void guardar() {
        try {

            chotraspatolog.setChopnclinorig(new Integer(this.idCentro));
            chotraspatolog.setChopntipodoc(new Integer(this.idTipoDocumento));
            chotraspatolog.setChopccodiserv(servicioSelected);

            if (this.serviceLocator.getClinicoService().getOtrasPatolog(chotraspatolog) != null) {
                FacesUtils.addErrorMessage(MSG_FACTURA_EXISTE);

            } else if (chotraspatolog.getChopccodiserv() == null || chotraspatolog.getChopccodiserv().equalsIgnoreCase("")) {
                FacesUtils.addErrorMessage(MSG_SELECCIONAR_SERVICIO);
            } else {
            
                Chprofpatol chprofpatol = new Chprofpatol();
                chprofpatol.getComp_id().setHppcservicio(servicioSelected);       
                chprofpatol.getComp_id().setHppnclinlect(new Integer(this.idCentro));
                if (this.serviceLocator.getClinicoService().getPatologosGeneral(chprofpatol).size() == 0){
                    FacesUtils.addErrorMessage(MSG_SERVICIO_PATOLOGO);
                }else{
                
                    this.serviceLocator.getClinicoService().saveOrUpdatePatologia(chotraspatolog);
                    FacesUtils.addInfoMessage(MSG_ADICION);
                    registrado = true;
                    
                }
            

            }

        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_ADICION);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_ADICION);
        }

    }

    public void buscadorDoc() {

        registrado = false;
        mostrarFactura = false;
        listServiciosFact = new ArrayList();

        if (this.idTipoDocumento.equalsIgnoreCase("20") || this.idTipoDocumento.equalsIgnoreCase("51")) {
        
            try {

                Ccfactvent facturaVenta = 
                    (Ccfactvent)this.serviceLocator.getClinicoService().getInfoFactura(new Integer(this.idCentro), 
                                                                                       new Integer(this.idTipoDocumento), 
                                                                                       this.chotraspatolog.getChopnnumdoc());

                if (facturaVenta != null) {

                    mostrarFactura = true;
                    this.tipoIden = facturaVenta.getCfvctipide();
                    this.numIden = facturaVenta.getCfvanumide();
                    this.nombUsuario = 
                            facturaVenta.getCfvcprinom() + " " + facturaVenta.getCfvcsegnom() + 
                            " " + facturaVenta.getCfvcpriape() + " " + 
                            facturaVenta.getCfvcsegape();

                    List<Ccdetfacve> tabla = 
                        this.serviceLocator.getClinicoService().getDetalleFact(new Integer(this.idTipoDocumento), 
                                                                               facturaVenta.getCfvnconsec());
                    for (Ccdetfacve combo: tabla) {
                        listServiciosFact.add(new SelectItem(combo.getCdvcservic(), 
                                                             combo.getCdvcservic()));
                    }


                } else {

                    mostrarFactura = false;
                    this.tipoIden = null;
                    this.numIden = null;
                    this.nombUsuario = null;
                    FacesUtils.addErrorMessage(MSG_DOC_NO_EXISTE);

                }

            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            }

        } else if (this.idTipoDocumento.equalsIgnoreCase("2")) {

            try {

                Ccfactserv facturaServicio = 
                    (Ccfactserv)this.serviceLocator.getClinicoService().getInfoFactura(new Integer(this.idCentro), 
                                                                                       new Integer(this.idTipoDocumento), 
                                                                                       this.chotraspatolog.getChopnnumdoc());

                if (facturaServicio != null) {

                    mostrarFactura = true;
                    this.tipoIden = facturaServicio.getCfsctipide();
                    this.numIden = facturaServicio.getCfsanumide();
                    this.nombUsuario = facturaServicio.getCfscpacien();

                    List<Ccdetafact> tabla = 
                        this.serviceLocator.getClinicoService().getDetalleFact(new Integer(this.idTipoDocumento), 
                                                                               facturaServicio.getCfsnnumero());
                    for (Ccdetafact combo: tabla) {
                        listServiciosFact.add(new SelectItem(combo.getCdfcservic(), 
                                                             combo.getCdfcservic()));
                    }

                } else {

                    mostrarFactura = false;
                    this.tipoIden = null;
                    this.numIden = null;
                    this.nombUsuario = null;
                    FacesUtils.addErrorMessage(MSG_DOC_NO_EXISTE);

                }

            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }


        } else {
            FacesUtils.addErrorMessage(MSG_DOC_NO_EXISTE);
        }


    }


    public void fillCentros() {
        listCentros = new ArrayList();

        try {
            List<Cpclinica> tabla = 
                (List<Cpclinica>)this.serviceLocator.getClinicoService().getClinicas();
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


    public void changeServicio() {

        if (this.servicioSelected != null && 
            !this.servicioSelected.equalsIgnoreCase("")) {

            Cpservicio a = new Cpservicio();
            a.setCsvccodigo(servicioSelected);
            try {
                this.servicio = 
                        ((Cpservicio)this.serviceLocator.getClinicoService().getServicioClinico(a)).getCsvcnombre();
            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }

        } else {
            this.servicio = "";

        }

    }


    //ACCESSORS


    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setListCentros(List listCentros) {
        this.listCentros = listCentros;
    }

    public List getListCentros() {
        return listCentros;
    }

    public void setChotraspatolog(Chotraspatolog chotraspatolog) {
        this.chotraspatolog = chotraspatolog;
    }

    public Chotraspatolog getChotraspatolog() {
        return chotraspatolog;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setServicioSelected(String servicioSelected) {
        this.servicioSelected = servicioSelected;
    }

    public void setServicioSelected(ValueChangeEvent valueChangeEvent) {
        setServicioSelected((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public String getServicioSelected() {
        return servicioSelected;
    }

    public void setTipoIden(String tipoIden) {
        this.tipoIden = tipoIden;
    }

    public String getTipoIden() {
        return tipoIden;
    }

    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }

    public String getNombUsuario() {
        return nombUsuario;
    }

    public void setNumIden(BigDecimal numIden) {
        this.numIden = numIden;
    }

    public BigDecimal getNumIden() {
        return numIden;
    }

    public void setMostrarFactura(boolean mostrarFactura) {
        this.mostrarFactura = mostrarFactura;
    }

    public boolean isMostrarFactura() {
        return mostrarFactura;
    }

    public void setListServiciosFact(List listServiciosFact) {
        this.listServiciosFact = listServiciosFact;
    }

    public List getListServiciosFact() {
        return listServiciosFact;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getServicio() {
        return servicio;
    }
}


