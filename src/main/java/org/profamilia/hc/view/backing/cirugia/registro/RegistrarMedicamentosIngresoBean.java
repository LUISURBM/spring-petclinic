//=======================================================================
// ARCHIVO registrarMedicamentosIngresoBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================

package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.File;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chestadociv;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chsexo;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.resumen.GenerarFoliosCirugiaBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE registrarMedicamentosIngresoBean
//=======================================================================
public class RegistrarMedicamentosIngresoBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private HtmlDataTable dtFormula;
    
    private IngresoCirugiaEnfermeria ingreso;

    private List<Chformulahos> lstPrescripciones;

    private Chcirugprogr cirugia;

    private List lstCirugias;

    private List lstConsclin;

    private HtmlDataTable dtCirugias;

    private Chformulahos formulaSelect;

    private List<Chcontrmedic> lstMedicamentosTerminados;

    private List listTipoIdentificacion;

    private List listSexos;

    private List listEstadoCivil;

    private Chusuario usuario;

    private Integer edad;
    
    private boolean generoReporte;
    
    private List<Chformulahos> lstPrescripcionesExterna;
    
    private HtmlDataTable dtFormulaExterna;
    
    private String legendServicio;
    
    private List<Cnconsclin> listaConsclin;
    
    private boolean notaEnfeProce;
    
    private String legendTablaServicio;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarMedicamentosIngresoBean() {
    }

    public void init() {
        listTipoIdentificacion = new ArrayList();
        listSexos = new ArrayList();
        listEstadoCivil = new ArrayList();
        usuario = new Chusuario();

        lstPrescripciones = new ArrayList<Chformulahos>();
        lstMedicamentosTerminados = new ArrayList<Chcontrmedic>();
        lstCirugias = new ArrayList();
        legendServicio="Cirugia(s) Programada(s)";
        legendTablaServicio ="Intervenci�n(es)";
        if (cirugia != null) {
           try {
              lstPrescripciones = 
                   this.serviceLocator.getCirugiaService().getFormulaMedicamentosCirugia(cirugia.getHcplnumero(), null);
                           
              lstPrescripcionesExterna = 
                   this.serviceLocator.getCirugiaService().getFormulaMedicamentosConsultaExterna(cirugia.getHcplusuario().getHuslnumero(),cirugia.getHcplnumero()); 
                            
              lstMedicamentosTerminados = 
                   this.serviceLocator.getCirugiaService().getFormulaMedicamentosCirugiaSuministrados(cirugia.getHcplnumero());
                            
              if(cirugia.getChdetacirpros()!= null && !cirugia.getChdetacirpros().isEmpty()){
                  Chdetacirpro detalle = null; 
                  Iterator it = cirugia.getChdetacirpros().iterator(); 
                  while(it.hasNext()){
                      detalle = (Chdetacirpro)it.next(); 
                            
                      if(detalle!= null && detalle.getId() != null && detalle.getId().getHdccservicio() != null){
                           Cpservicio servicio = this.serviceLocator.getClinicoService().getServicioPorId(detalle.getId().getHdccservicio()); 
                           lstCirugias.add(servicio); 
                      }
                  }
              }
               if(notaEnfeProce){
                   legendServicio="Procedimiento(s)";
                   legendTablaServicio="Procedimiento(s)";
                   try {
                       listaConsclin = 
                               this.serviceLocator.getClinicoService().getConsultaClinica(cirugia.getHcplnumero().longValue());
                   } catch (ModelException e) {
                       e.printStackTrace();
                   }

                   // Cargamos los procedimientos
                   if (listaConsclin != null && !listaConsclin.isEmpty()) {
                       Iterator it = listaConsclin.iterator();
                       Cnconsclin conclin;

                       while (it.hasNext()) {
                           conclin = (Cnconsclin)it.next();
                           lstCirugias.add(conclin.getCcocservic());
                       }
                   }
               }   
              
           } catch (ModelException e) {
              e.printStackTrace();
           }
           usuario = cirugia.getHcplusuario();
        }
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param dtFormula
     */
    public void setDtFormula(HtmlDataTable dtFormula) {
        this.dtFormula = dtFormula;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFormula() {
        return dtFormula;
    }

    /**
     * @param lstPrescripcionesExterna
     */
    public void setLstPrescripcionesExterna(List<Chformulahos> lstPrescripcionesExterna) {
        this.lstPrescripcionesExterna = lstPrescripcionesExterna;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstPrescripcionesExterna() {
        return lstPrescripcionesExterna;
    }

    /**
     * @param dtFormulaExterna
     */
    public void setDtFormulaExterna(HtmlDataTable dtFormulaExterna) {
        this.dtFormulaExterna = dtFormulaExterna;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtFormulaExterna() {
        return dtFormulaExterna;
    }

    /**
     * @param lstPrescripciones
     */
    public void setLstPrescripciones(List<Chformulahos> lstPrescripciones) {
        this.lstPrescripciones = lstPrescripciones;
    }

    /**
     * @return
     */
    public List<Chformulahos> getLstPrescripciones() {
        return lstPrescripciones;
    }

    /**
     * @param cirugia
     */
    public void setCirugia(Chcirugprogr cirugia) {
        this.cirugia = cirugia;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugia() {
        return cirugia;
    }

    /**
     * @param lstCirugias
     */
    public void setLstCirugias(List lstCirugias) {
        this.lstCirugias = lstCirugias;
    }

    /**
     * @return
     */
    public List getLstCirugias() {
        return lstCirugias;
    }

    /**
     * @param lstConsclin
     */
    public void setLstConsclin(List lstConsclin) {
        this.lstConsclin = lstConsclin;
    }

    /**
     * @return
     */
    public List getLstConsclin() {
        return lstConsclin;
    }

    /**
     * @param dtCirugias
     */
    public void setDtCirugias(HtmlDataTable dtCirugias) {
        this.dtCirugias = dtCirugias;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtCirugias() {
        return dtCirugias;
    }

    /**
     * @param formulaSelect
     */
    public void setFormulaSelect(Chformulahos formulaSelect) {
        this.formulaSelect = formulaSelect;
    }

    /**
     * @return
     */
    public Chformulahos getFormulaSelect() {
        return formulaSelect;
    }

    /**
     * @param lstMedicamentosTerminados
     */
    public void setLstMedicamentosTerminados(List<Chcontrmedic> lstMedicamentosTerminados) {
        this.lstMedicamentosTerminados = lstMedicamentosTerminados;
    }

    /**
     * @return
     */
    public List<Chcontrmedic> getLstMedicamentosTerminados() {
        return lstMedicamentosTerminados;
    }

    /**
     * @param param
     */
    public void setListTipoIdentificacion(List param) {
        this.listTipoIdentificacion = param;
    }

    /**
     * @return
     */
    public List getListTipoIdentificacion() {
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
                listTipoIdentificacion.add(new SelectItem("", "Seleccione una opci�n ..."));
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
     * @param param
     */
    public void setListSexos(List param) {
        this.listSexos = param;
    }

    /**
     * @return La lista de los sexos que existen
     */
    public List getListSexos() {
        if (listSexos.size() == 0) {
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

    /**
     * @param listEstadoCivil
     */
    public void setListEstadoCivil(List listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    /**
     * @return
     */
    public List getListEstadoCivil() {
        if (listEstadoCivil.size() == 0) {
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
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer getEdad() {
        return edad;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------

    public String volver() {
        FacesUtils.resetManagedBean("consultarUsuariosIngresadosBean");
        FacesUtils.resetManagedBean("ingresoLiquidosBean");
        FacesUtils.resetManagedBean("registrarMedicamentosIngresoBean");
        FacesUtils.resetManagedBean("registrarNotaEnfermeriaBean");
        return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
    }

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------  

    public String administrarMedicamento() {
        setGeneroReporte(false); 
        formulaSelect = (Chformulahos)dtFormula.getRowData();
        ControlMedicamentosBean controlBean = 
            (ControlMedicamentosBean)FacesUtils.getManagedBean("controlMedicamentosBean");
        if (controlBean != null && formulaSelect != null) {
            controlBean.setFormula(formulaSelect);
            controlBean.setCirugia(cirugia);
            controlBean.setNavegationRule(BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS);
            controlBean.setEsIngreso(true);
            controlBean.init();
            if (notaEnfeProce) {
                controlBean.setTipoServicio(TIPO_PROCEDIMIENTO);
            } else {
                controlBean.setTipoServicio(null);
            }
        }
        return BeanNavegacion.RUTA_IR_CONTROL_MEDICAMENTOS;
    }

    public void generarReporte(){    
        GenerarFoliosCirugiaBean bean = (GenerarFoliosCirugiaBean)FacesUtils.getManagedBean("generarFoliosCirugiaBean");
        byte[] result = null;

        if (bean != null && cirugia != null && usuario != null) {       
            result = bean.generarMedicamentos(usuario, cirugia, -1);
        }
        if (result != null) {
            PdfServletUtils.showPdfDocument(result,"ControlMedicamentos.pdf", false);
            setGeneroReporte(true);
        } else {
            FacesUtils.addErrorMessage("No pudo generar Reporte Control Medicamentos. ");
            setGeneroReporte(false);
        }
    }
    
    public void actualizarDatos(){
        init();
    }
    

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }
    
    public String administrarMedicamentoExterna() {
        setGeneroReporte(false); 
        formulaSelect = (Chformulahos)dtFormulaExterna.getRowData();
        ControlMedicamentosBean controlBean = 
            (ControlMedicamentosBean)FacesUtils.getManagedBean("controlMedicamentosBean");
        if (controlBean != null && formulaSelect != null) {
            controlBean.setFormula(formulaSelect);
            controlBean.setCirugia(cirugia);
            controlBean.setEsIngreso(true);
            controlBean.setNavegationRule(BeanNavegacion.RUTA_IR_INGRESO_MEDICAMENTOS);
            controlBean.init();
            if (notaEnfeProce) {
                controlBean.setTipoServicio(TIPO_PROCEDIMIENTO);
            } else {
                controlBean.setTipoServicio(null);
            }
        }
        return BeanNavegacion.RUTA_IR_CONTROL_MEDICAMENTOS;
    }
        
    /**
    * @return
    */
    public String irCerrarIngresoEnfermeria() {
     FacesUtils.resetManagedBean("listaCirugiasProgramadasBean");
     if (ingreso != null) {
         ingreso.closeIngreso();
     }
     return BeanNavegacion.RUTA_HOME;
    }

    public void setLegendServicio(String legendServicio) {
        this.legendServicio = legendServicio;
    }

    public String getLegendServicio() {
        return legendServicio;
    }

    public void setListaConsclin(List<Cnconsclin> listaConsclin) {
        this.listaConsclin = listaConsclin;
    }

    public List<Cnconsclin> getListaConsclin() {
        return listaConsclin;
    }

    public void setNotaEnfeProce(Boolean notaEnfeProce) {
        this.notaEnfeProce = notaEnfeProce;
    }

    public Boolean getNotaEnfeProce() {
        return notaEnfeProce;
    }

    public void setLegendTablaServicio(String legendTablaServicio) {
        this.legendTablaServicio = legendTablaServicio;
    }

    public String getLegendTablaServicio() {
        return legendTablaServicio;
    }
}
