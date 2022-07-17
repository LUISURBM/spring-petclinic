//=======================================================================
// ARCHIVO Reporte Actividades Educativas
// FECHA CREACI�N: 06/10/2015
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Reporte Actividades Educativas
//=======================================================================
 package org.profamilia.hc.view.backing.comun.administracion;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chcorreo;
import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.CpcontratoId;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorContratosBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ReporteActividadesEducativasBean
//=======================================================================
public class ParametrizacionCorreosBean extends BaseBean   {

   private boolean renderEditar;
   private List<Chcorreo>lstcorreo;
   private Chcorreo correo;
   private HtmlDataTable dtcorreo;
   private int selectedIndex;
   private boolean renderBuscador;
   private boolean generoHistoria;
    static final int ACTIVAR_BUSCADOR = 1;
    static final int ACTIVAR_PARAMETRIZACION = 0;
    private String descripcion;
    private List<SelectItem>lstEstados;
    private List<SelectItem>latDocumentos;
    private UIInput IDescripcion;



    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE REPORTE
    //-----------------------------------------------------------------------

  



    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ParametrizacionCorreosBean() {

    }
    public void init(){
    if(correo==null){
        correo = new Chcorreo();
        consultar();
        
    }
       
    }
    public void consultar(){
        try {
            lstcorreo = serviceLocator.getClinicoService().readCorreo();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("Error al consultar noticias");
            e.printStackTrace();
        }
    }
    public void guardarCorreo(){
    if(descripcion !=null && correo.getHcncontrato()!=null){
        try {
            if(correo.getHcdfecreg()==null){
                correo.setHcdfecreg(new Date());
            }
            correo.setHccusuareg(userName());
            serviceLocator.getClinicoService().saveOrUpdateParamCorreo(correo);
            correo = new Chcorreo();
            descripcion = null;
            renderEditar = false;
            consultar();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("Error al guardar correo");
        }
    }
    else{
        FacesUtils.addErrorMessage("La Descripci�n y el n�mero de contrato no pueden estar vaci�s  ");
    }
    }
 
    public void obtenerCorreo(){
        correo = (Chcorreo)dtcorreo.getRowData();
    }

    public void cambiarEstadoCorreoActivo(){
        try {
            obtenerCorreo();
            correo.setHccestado("VG");
            correo.setHccusuareg(userName());
            serviceLocator.getClinicoService().saveOrUpdateParamCorreo(correo);
            correo = new Chcorreo();
            consultar();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }
    public void cambiarEstadoCorreoInactivo(){
        try {
            obtenerCorreo();
            correo.setHccestado("XX");
            correo.setHccusuareg(userName());
            serviceLocator.getClinicoService().saveOrUpdateParamCorreo(correo);
            correo = new Chcorreo();
            consultar();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }
    
 
    
    public void mostrarBuscadorContratos() {
        FacesUtils.resetManagedBean("buscadorContratosBean");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoHistoria = false;
        //lstCitologiaUsuario = new ArrayList();

    }
         public void aceptarContrato() {
             BuscadorContratosBean contratoBus;
             contratoBus = (BuscadorContratosBean)FacesUtils.getManagedBean("buscadorContratosBean");

             if (contratoBus != null && contratoBus.getContratoSelect() != null) {
                correo.setHcncontrato(contratoBus.getContratoSelect().getId().getCcnnnumero());
                IDescripcion.setValue(contratoBus.getContratoSelect().getId().getCcnnnumero());
                //dto.setCstnadmisi(((BigDecimal)aux[0]).longValue());
                descripcion = contratoBus.getContratoSelect().getCcncdescri();
            
            }
             renderBuscador = false;
             selectedIndex = ACTIVAR_PARAMETRIZACION;
         }
         
    /**
     * @param valueChangeEvent
     */
    public void setDescriCorreo(ValueChangeEvent valueChangeEvent) {
        correo.setHcncontrato((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void changeDescripcion() {
        descripcion = "";
        Cpcontrato contrato = new Cpcontrato();
        CpcontratoId id = new CpcontratoId();
       
        List <Cpcontrato>auxContratos = new ArrayList<Cpcontrato>();
        if (correo != null) {
            if (correo.getHcncontrato() != null && 
                !correo.getHcncontrato().equals("")) {
                id.setCcnnnumero(correo.getHcncontrato());
                contrato.setId(id);
                contrato.setCcncdescri(descripcion);
                try {
                    auxContratos = 
                            this.serviceLocator.getClinicoService().getCriteriosContrato(contrato,true);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (auxContratos != null  && !auxContratos.isEmpty()) {
                    descripcion = auxContratos.get(0).getCcncdescri();
                }
                else{
                    descripcion = null;
                }

              if(descripcion == null){
                    correo.setHcncontrato(null);
                    IDescripcion.setValue(null);
                    FacesUtils.addErrorMessage("Contrato no existe");
                }
          
        }
    }
    }
  


    public void setRenderEditar(boolean renderEditar) {
        this.renderEditar = renderEditar;
    }

    public boolean isRenderEditar() {
        return renderEditar;
    }



    public void setLstcorreo(List<Chcorreo> lstcorreo) {
        this.lstcorreo = lstcorreo;
    }

    public List<Chcorreo> getLstcorreo() {
        return lstcorreo;
    }

    public void setCorreo(Chcorreo correo) {
        this.correo = correo;
    }

    public Chcorreo getCorreo() {
        return correo;
    }

    public void setDtcorreo(HtmlDataTable dtcorreo) {
        this.dtcorreo = dtcorreo;
    }

    public HtmlDataTable getDtcorreo() {
        return dtcorreo;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setGeneroHistoria(boolean generoHistoria) {
        this.generoHistoria = generoHistoria;
    }

    public boolean isGeneroHistoria() {
        return generoHistoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setLstEstados(List<SelectItem> lstEstados) {
        this.lstEstados = lstEstados;
    }

    public List<SelectItem> getLstEstados() {
        if(lstEstados == null || lstEstados.isEmpty()){
            lstEstados = new ArrayList<SelectItem>();
            lstEstados.add(new SelectItem("VG","Activo"));
            lstEstados.add(new SelectItem("XX","Inactivo"));
        }
        return lstEstados;
    }

    public void setLatDocumentos(List<SelectItem> latDocumentos) {
        this.latDocumentos = latDocumentos;
    }

    public List<SelectItem> getLatDocumentos() {
        if(latDocumentos == null || latDocumentos.isEmpty()){
            latDocumentos = new ArrayList<SelectItem>();
            latDocumentos.add(new SelectItem("VPH","Lectura VPH"));
        }
        return latDocumentos;
    }


    public void setIDescripcion(UIInput iDescripcion) {
        this.IDescripcion = iDescripcion;
    }

    public UIInput getIDescripcion() {
        return IDescripcion;
    }

 
}
