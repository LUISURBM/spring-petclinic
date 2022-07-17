package org.profamilia.hc.view.backing.comun;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.CfdetaadmisionPK;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.CfdetafacturaPK;
import org.profamilia.hc.model.dto.Chconfiservi;
import org.profamilia.hc.model.dto.Chreginsumo;
import org.profamilia.hc.model.dto.ChreginsumoPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.dto.confirmarInsumoDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;

public class ConfirmarServiciosAdmisionBean extends BaseBean {

    private Long numeroAdmision;
    private List<Cfdetafactura> cfdetafacturaList;
    private HtmlDataTable tableServiciosAdmision;
    private Cfdetafactura cfdetafactura;
    private List<Object[]> resultList;
    private Chusuario usuario;
    private Cfadmision admision;
    private ConfirmarServicioBean confirmacionBean;
    private Cnconsclin consulta;
    private Cfdetaadmision detalleAdmision;
    private List<Cfdetaadmision> detalleAdmisionLista;
    private Long consecutivoFactura;
    private Cfdetafactura detafacturaNov;
    private Boolean validacionNovedad;
    private Chconfiservi confiservi;


    public ConfirmarServiciosAdmisionBean() {
    }

    public void init() {

        cfdetafactura = new Cfdetafactura();
        cfdetafacturaList = new ArrayList();
        resultList = new ArrayList();
        tableServiciosAdmision = new HtmlDataTable();
        admision = new Cfadmision();
        consecutivoFactura = null;
        validacionNovedad = false;

    }

    public void consultarServiciosAdmision() {
        tableServiciosAdmision = new HtmlDataTable();
        cfdetafacturaList = new ArrayList();
        cfdetafactura = new Cfdetafactura();
        resultList = new ArrayList();
        admision = new Cfadmision();

        try {
            
            // CONFIRMAR CONSULTA
            confirmacionBean = 
                    (ConfirmarServicioBean)FacesUtils.getManagedBean("confirmarServicioBean");
            confirmacionBean.setUsuario(getUsuario());
            confirmacionBean.setNumeroConsulta(getConsulta().getCconnumero().longValue());
            confirmacionBean.setConsulta(getConsulta());
            confirmacionBean.inicalizarConfirmarServicioBean();

            if (confirmacionBean.getValidacionRegistro()) {
                validacionNovedad = true;
            } else {
                validacionNovedad = false;
            }
            
            if (numeroAdmision != null) {

                busquedaDetalleFactura();
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    private void busquedaDetalleFactura() throws ModelException {
        resultList = 
                getServiceLocator().getClinicoService().getListaServiciosFactura(numeroAdmision);

        if (resultList != null && !resultList.isEmpty()) {

            for (Object[] objeto: resultList) {

                cfdetafactura.setComp_id(new CfdetafacturaPK(validarLong(objeto[0]), 
                                                             validarLong(objeto[1])));
                consecutivoFactura = 
                        cfdetafactura.getComp_id().getCdfnconsfact();
                cfdetafactura.setCdfcservicio(validarString(objeto[2]));
                cfdetafactura.setCdfnorden(validarLong(objeto[3]));
                cfdetafactura.setCdfcobserv(validarString(objeto[4]));
                cfdetafactura.setCdfclote(validarString(objeto[5]));
                cfdetafactura.setCdfndescuento(validarDouble(objeto[6]));
                cfdetafactura.setCdfniva(validarDouble(objeto[7]));
                cfdetafactura.setCdfncliente(validarLong(objeto[8]));
                cfdetafactura.setCdfnestado(validarString(objeto[9]));
                cfdetafactura.setCdfcpaquet(validarString(objeto[10]));
                cfdetafactura.setCdfctipdscto(validarString(objeto[11]));
                cfdetafactura.setCdfnvalsrv(validarDouble(objeto[12]));
                cfdetafactura.setCdfncantidad(validarLong(objeto[13]));
                cfdetafactura.setCdfcetapa(validarString(objeto[14]));
                cfdetafactura.setCdfcusuamodi(validarString(objeto[15]));
                cfdetafactura.setCdfdfechmodi((Date)(objeto[16]));
                cfdetafactura.setCdfnconsuclin(validarLong(objeto[17]));
                cfdetafactura.setCdfcswitpaq(validarString(objeto[18]));
                cfdetafactura.setNombreServicio(validarString(objeto[19]));
                if (cfdetafactura.getCdfnconsuclin() != null) {
                    cfdetafactura.setValidacionConsultaClinica(true);
                } else {
                    cfdetafactura.setValidacionConsultaClinica(false);
                }
                cfdetafacturaList.add(cfdetafactura);
                cfdetafactura = new Cfdetafactura();
            }
        }
    }

    public void guardarConfirmacionServiciosAdmision() {
        try {

            Cptipodocu tipodocu = new Cptipodocu();
            Cpservicio servicio = new Cpservicio();
            Boolean confirmacion = false;
            detalleAdmision = new Cfdetaadmision();
            detafacturaNov = new Cfdetafactura();

            admision = 
                    getServiceLocator().getClinicoService().getAdmision(numeroAdmision);

                confiservi = 
                        serviceLocator.getClinicoService().getConfirmacionServicio(consulta.getCconnumero().longValue());


                if (confiservi == null) {

                    if (!confirmacionBean.getConfirmacion().getHcscserviingre().equals(confirmacionBean.getConfirmacion().getHcscserviegres())) {

                        detalleAdmisionLista = 
                                serviceLocator.getClinicoService().getDetalleAdmision(consulta.getCconnumdoc().longValue());
                        Long consecutivo = 
                            Long.valueOf(detalleAdmisionLista.size() + 1);

                        try {
                            servicio = 
                                    serviceLocator.getClinicoService().getServicioPorId(confirmacionBean.getConfirmacion().getHcscserviegres());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }

                        detalleAdmision.setId(new CfdetaadmisionPK(admision.getCannumero().longValue(), 
                                                                   consecutivo));
                        detalleAdmision.setCdacservic(confirmacionBean.getConfirmacion().getHcscserviegres());
                        detalleAdmision.setCdanvalser(0D);
                        detalleAdmision.setCdanivaser(0D);
                        detalleAdmision.setCdandescto(0D);
                        detalleAdmision.setCdancantid(1L);
                        detalleAdmision.setCdanvalent(0D);
                        detalleAdmision.setCdanvaltot(0D);
                        detalleAdmision.setCdannumite(1L);
                        detalleAdmision.setCdacpaquet("0");
                        detalleAdmision.setCdacswpaqu("N");
                        detalleAdmision.setCdacdesserv(servicio.getCsvcnombre());
                        detalleAdmision.setCdanrecaudo(0D);
                        detalleAdmision.setCdacestado("PR");


                        detafacturaNov.setComp_id(new CfdetafacturaPK(consecutivo, 
                                                                      consecutivoFactura));
                        detafacturaNov.setCdfcservicio(confirmacionBean.getConfirmacion().getHcscserviegres());
                        detafacturaNov.setCdfndescuento(0D);
                        detafacturaNov.setCdfniva(0D);
                        detafacturaNov.setCdfncliente(0L);
                        detafacturaNov.setCdfcetapa("AT");
                        detafacturaNov.setCdfcswitpaq("N");
                        detafacturaNov.setCdfcpaquet("0");
                        detafacturaNov.setCdfnvalsrv(0D);
                        detafacturaNov.setCdfncantidad(1L);
                        detafacturaNov.setCdfnestado("NV");
                        detafacturaNov.setCdfnconsuclin(consulta.getCconnumero().longValue());

                        this.serviceLocator.getClinicoService().saveNovedadAdmision(detalleAdmision, 
                                                                                    detafacturaNov, 
                                                                                    confirmacionBean.getConfirmacion());


                        if (confirmacionBean.getLstServicios() != null && 
                            !confirmacionBean.getLstServicios().isEmpty()) {
                            consulta.setCcocservic(servicio);
                            Iterator iter = 
                                confirmacionBean.getLstServicios().iterator();
                            while (iter.hasNext()) {
                                Object[] a = (Object[])iter.next();
                                if (a[0].toString().equals(confirmacionBean.getConfirmacion().getHcscserviegres().toString())) {
                                    consulta.setCcoavalser(new BigDecimal(a[2].toString()));
                                }
                            }
                        }
                        this.serviceLocator.getClinicoService().updateCnconsclin(consulta);
                        busquedaDetalleFactura();
                        FacesUtils.addInfoMessage("Se creo la novedad correctamente.");
                        validacionNovedad = true;
                    }
                } else {
                    FacesUtils.addInfoMessage("Ya cuenta con una novedad sobre el servicio" + 
                                              " : " + 
                                              confirmacionBean.getConfirmacion().getDescServicioIngreso());
                }

            for (Cfdetafactura detalle: cfdetafacturaList) {
                if (detalle.getValidacionConsultaClinica() == true && 
                    detalle.getCdfnconsuclin() == null) {
                    tipodocu = 
                            this.serviceLocator.getCirugiaService().getTipoDocuPorId(100);

                    servicio = 
                            this.serviceLocator.getClinicoService().getServicioPorId(detalle.getCdfcservicio());

                    Cnconsclin consclin = new Cnconsclin();
                    consclin.setCconclinic(admision.getCanclinic().intValue());
                    consclin.setCconsalesp(0);
                    consclin.setCconconsul(0);
                    consclin.setCcontconcl(servicio.getCsvntipcon());
                    consclin.setCcodfecreg(admision.getCadfecreg());
                    consclin.setCconhistor(0);
                    consclin.setCcoctipide(admision.getCactipide());
                    consclin.setCcoanumide(new BigDecimal(admision.getCannumide()));
                    consclin.setCcocprinom(usuario.getHuscprimernomb());
                    consclin.setCcocsegnom(usuario.getHuscsegundnomb());
                    consclin.setCcocpriape(usuario.getHuscprimerapel());
                    consclin.setCcocsegape(usuario.getHuscsegundapel());
                    consclin.setCconclidoc(admision.getCanclinic().intValue());
                    consclin.setCcontipdoc(tipodocu);
                    consclin.setCconnumdoc(new BigDecimal(admision.getCannumero()));
                    consclin.setCconprogra(admision.getCanprogra().intValue());
                    consclin.setCconcontra(admision.getCancontra().intValue());
                    consclin.setCcocservic(servicio);
                    consclin.setCconcantid(detalle.getCdfncantidad().intValue());
                    consclin.setCcoavalser(new BigDecimal(detalle.getCdfnvalsrv()));
                    consclin.setCcodfecreg(new Date());
                    consclin.setCcodfeccon(admision.getCadfecreg());
                    consclin.setCcothorcon(new Date());
                    consclin.setCcocusureg(getUsuarioSystem().getCurcusuari());
                    consclin.setCcocetapa(IConstantes.CEN_SALA);
                    consclin.setCcothorate(new Date());
                    consclin.setCcocusumod(" ");
                    consclin.setCcocestado(IConstantes.ESTADO_VIGENTE);
                    consclin.setCcondonant(new BigDecimal(admision.getCandonante()));
                    consclin.setCcocgenero(usuario.getHusesexo());
                    consclin.setCcolusuario(usuario);
                    consclin.setCcocintext(admision.getCacintext());
                    consclin = 
                            this.serviceLocator.getClinicoService().generarConsultaClinica(consclin);

                    if (consclin != null) {
                        detalle.setCdfnconsuclin(consclin.getCconnumero().longValue());
                        confirmacion = true;
                    }
                }
            }
            if (confirmacion) {
                this.serviceLocator.getClinicoService().saveDetalleFactura(cfdetafacturaList, 
                                                                           numeroAdmision);
                FacesUtils.addInfoMessage("Se confirmaron los servicios para atender correctamente");
            }
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("No se logro guardar");
            e.printStackTrace();
        }


    }

    public Long validarLong(Object valor) {
        return valor == null ? null : Long.parseLong(valor.toString());
    }

    public Double validarDouble(Object valor) {
        return valor == null ? null : Double.parseDouble(valor.toString());
    }

    public String validarString(Object valor) {
        return valor == null ? null : valor.toString();
    }

    public void setTableServiciosAdmision(HtmlDataTable tableInsumos) {
        this.tableServiciosAdmision = tableInsumos;
    }

    public HtmlDataTable getTableServiciosAdmision() {
        return tableServiciosAdmision;
    }

    public void setNumeroAdmision(Long numeroAdmision) {
        this.numeroAdmision = numeroAdmision;
    }

    public Long getNumeroAdmision() {
        return numeroAdmision;
    }

    public void setCfdetafacturaList(List<Cfdetafactura> cfdetafacturaList) {
        this.cfdetafacturaList = cfdetafacturaList;
    }

    public List<Cfdetafactura> getCfdetafacturaList() {
        return cfdetafacturaList;
    }

    public void setCfdetafactura(Cfdetafactura cfdetafactura) {
        this.cfdetafactura = cfdetafactura;
    }

    public Cfdetafactura getCfdetafactura() {
        return cfdetafactura;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setAdmision(Cfadmision admision) {
        this.admision = admision;
    }

    public Cfadmision getAdmision() {
        return admision;
    }

    public void setConfirmacionBean(ConfirmarServicioBean confirmacionBean) {
        this.confirmacionBean = confirmacionBean;
    }

    public ConfirmarServicioBean getConfirmacionBean() {
        return confirmacionBean;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setDetalleAdmision(Cfdetaadmision detalleAdmision) {
        this.detalleAdmision = detalleAdmision;
    }

    public Cfdetaadmision getDetalleAdmision() {
        return detalleAdmision;
    }

    public void setDetalleAdmisionLista(List<Cfdetaadmision> detalleAdmisionLista) {
        this.detalleAdmisionLista = detalleAdmisionLista;
    }

    public List<Cfdetaadmision> getDetalleAdmisionLista() {
        return detalleAdmisionLista;
    }

    public void setConsecutivoFactura(Long consecutivoFactura) {
        this.consecutivoFactura = consecutivoFactura;
    }

    public Long getConsecutivoFactura() {
        return consecutivoFactura;
    }

    public void setDetafacturaNov(Cfdetafactura detafacturaNov) {
        this.detafacturaNov = detafacturaNov;
    }

    public Cfdetafactura getDetafacturaNov() {
        return detafacturaNov;
    }

    public void setValidacionNovedad(Boolean validacionNovedad) {
        this.validacionNovedad = validacionNovedad;
    }

    public Boolean getValidacionNovedad() {
        return validacionNovedad;
    }

    public void setConfiservi(Chconfiservi confiservi) {
        this.confiservi = confiservi;
    }

    public Chconfiservi getConfiservi() {
        return confiservi;
    }
}
