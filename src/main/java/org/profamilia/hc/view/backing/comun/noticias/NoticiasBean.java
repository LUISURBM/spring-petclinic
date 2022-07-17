//=======================================================================
// ARCHIVO Reporte Actividades Educativas
// FECHA CREACI�N: 06/10/2015
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Reporte Actividades Educativas
//=======================================================================
 package org.profamilia.hc.view.backing.comun.noticias;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ReporteActividadesEducativasBean
//=======================================================================
public class NoticiasBean extends BaseBean   {

   private boolean renderEditar;
   private List<Chnoticia>lstnoticia;
   private Chnoticia noticia;
   private HtmlDataTable dtnoticia;
   private String lblAdicion;
   private String lblFieldset;




    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE REPORTE
    //-----------------------------------------------------------------------

  



    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public NoticiasBean() {

    }
    public void init(){
    if(noticia==null){
        lblAdicion = "Agregar";
        lblFieldset="Agregar Noticia";
        renderEditar = false;
        noticia = new Chnoticia();
        consultar();
        
    }
       
    }
    public void consultar(){
        try {
            lstnoticia = serviceLocator.getNoticiaService().readNoticia();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("Error al consultar noticias");
            e.printStackTrace();
        }
    }
    public void guardarNoticia(){
        try {
            noticia.setHnocestado("VG");
            if(noticia.getHnodfecreg()==null){
                noticia.setHnodfecreg(new Date());
            }
            noticia.setHnocusuareg(userName());
            serviceLocator.getNoticiaService().saveOrUpdateNoticia(noticia);
            lblAdicion = "Agregar";
            lblFieldset="Agregar Noticia";
            noticia = new Chnoticia();
            renderEditar = false;
            consultar();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage("Error al guardar noticia");
        }
    }
    public String editarNoticia(){
        lblAdicion = "Editar";
        lblFieldset="Editar Noticia";
        obtenerNoticia();
        //FacesUtils.resetManagedBean("registroPersonalBean");
         return BeanNavegacion.RUTA_IR_NOTICIAS;
    }
    public void obtenerNoticia(){
        noticia = (Chnoticia)dtnoticia.getRowData();
    }
    public void cambiarEstadoNoticia(){
        try {
            obtenerNoticia();
            noticia.setHnocestado("XX");
            noticia.setHnocusuareg(userName());
            serviceLocator.getNoticiaService().saveOrUpdateNoticia(noticia);
            consultar();
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
    }
    public void redirect() throws IOException {
       obtenerNoticia();
       try{
           ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
           externalContext.redirect(noticia.getHnoclinnot());
       }
       catch(Exception e){
           FacesUtils.addErrorMessage("La p�gina solicitada no existe");
       }
      
    }


    public void setRenderEditar(boolean renderEditar) {
        this.renderEditar = renderEditar;
    }

    public boolean isRenderEditar() {
        return renderEditar;
    }

    public void setLstnoticia(List<Chnoticia> lstnoticia) {
        this.lstnoticia = lstnoticia;
    }

    public List<Chnoticia> getLstnoticia() {
        return lstnoticia;
    }

    public void setNoticia(Chnoticia noticia) {
        this.noticia = noticia;
    }

    public Chnoticia getNoticia() {
        return noticia;
    }


    public void setDtnoticia(HtmlDataTable dtnoticia) {
        this.dtnoticia = dtnoticia;
    }

    public HtmlDataTable getDtnoticia() {
        return dtnoticia;
    }

    public void setLblAdicion(String lblAdicion) {
        this.lblAdicion = lblAdicion;
    }

    public String getLblAdicion() {
        return lblAdicion;
    }

    public void setLblFieldset(String lblFieldset) {
        this.lblFieldset = lblFieldset;
    }

    public String getLblFieldset() {
        return lblFieldset;
    }
}
