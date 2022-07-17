//=======================================================================
// ARCHIVO ResultadoPatologiaBean.java
// FECHA CREACI�N: 11/03/2011
// AUTOR: Jhon Carranza Silva
// Descripci�n: Registro de los resultados de Otras Patologias.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Ccdetafact;
import org.profamilia.hc.model.dto.Ccdetfacve;
import org.profamilia.hc.model.dto.Ccfactserv;
import org.profamilia.hc.model.dto.Ccfactvent;
import org.profamilia.hc.model.dto.Chdetaentpatol;
import org.profamilia.hc.model.dto.Chentregacitol;
import org.profamilia.hc.model.dto.Chentregapatol;
import org.profamilia.hc.model.dto.Chotraspatolog;
import org.profamilia.hc.model.dto.Chproflect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE ResultadoPatologiaBean
//=======================================================================
public class ResultadoPatologiaBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Integer idListado;
    
    private BigDecimal idPatologia;

    private HtmlDataTable dtlistadoPatologias;

    List<Chotraspatolog> listadoPatologias = new ArrayList<Chotraspatolog>();

    private String tipoLectura;

    /**
     * Actualizacion Resultados de Citologias 
     */
    private Integer idListado_mod;

    private String tipoLectura_mod;

    List<Chotraspatolog> listadoPatologias_mod = new ArrayList<Chotraspatolog>();

    List<Chotraspatolog> listadoPatologias_sel = new ArrayList<Chotraspatolog>();

    private HtmlDataTable dtlistadoPatologias_mod;

    private String imprimeListado;

    private int index = -1;

    private boolean generoReporte;
    
    Chentregapatol entregapatol = new Chentregapatol();
    
    private Chotraspatolog chotraspatologClone;
    
    /** Guarda el indice del registro consultado */
    private int indexDto;
    
    private String estadopatol;


    public ResultadoPatologiaBean() {
    }

    public void init() {
        listadoPatologias = new ArrayList<Chotraspatolog>();
        listadoPatologias_mod = new ArrayList<Chotraspatolog>();
        listadoPatologias_sel = new ArrayList<Chotraspatolog>();
        imprimeListado = "S";

    }

    // ACTIONS

    public void generarlistadoPatologias_mod() { 
        generoReporte = false;
        if (this.idListado_mod == null && this.idPatologia == null) {
            FacesUtils.addErrorMessage(MSG_CONSULTA_POR_FILTROS);            
        } else{ 
            listadoPatologias_mod = new ArrayList<Chotraspatolog>();
            tipoLectura_mod = "";
            Chdetaentpatol detalle = new Chdetaentpatol();
            detalle.setHepcetapa(this.PATOLOGIA_ENV_LAB);
            if(this.idListado_mod != null)             
                detalle.getComp_id().setHeplidentregapatol(idListado_mod.longValue());            
            if(this.idPatologia != null)             
                detalle.getComp_id().setHepnpatologia(idPatologia); 
    
            try {
                listadoPatologias_mod = 
                        (ArrayList<Chotraspatolog>)this.serviceLocator.getClinicoService().getListadoPatologias(detalle);
    
                if (listadoPatologias_mod.isEmpty()) {
                    FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
                }
    
            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            }
        
        }
    }

    public void generarListadoPatologias() {
        listadoPatologias = new ArrayList<Chotraspatolog>();         
        Chdetaentpatol detalle = new Chdetaentpatol();
        if(this.idListado != null)             
            detalle.getComp_id().setHeplidentregapatol(idListado.longValue());            
        if(this.idPatologia != null)             
            detalle.getComp_id().setHepnpatologia(idPatologia);
        
        try {
            listadoPatologias = 
                    (ArrayList<Chotraspatolog>)this.serviceLocator.getClinicoService().getListadoPatologias(detalle);

            if (listadoPatologias.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            }

        } catch (ModelException de) {
            de.printStackTrace();
            FacesUtils.addErrorMessage(null, de.getMessage(), MSG_NO_CONSULTA);
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
        }

    }


    public void guardar() {       
            try { 
                 chotraspatologClone.setEtapapatol(estadopatol);
                 this.serviceLocator.getClinicoService().saveOrUpdatePatologia(chotraspatologClone);                
                 this.listadoPatologias_mod.set(indexDto, chotraspatologClone);
                 FacesUtils.addInfoMessage(MSG_ACTUALIZACION); 
            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(),   MSG_NO_ACTUALIZACION);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(),  MSG_NO_ACTUALIZACION);
            }
    }


    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

            Chotraspatolog patologia = 
                ((Chotraspatolog)listadoPatologias_sel.get(index));

            if (fieldName.equals("FORMATO")) {
                value = new BigDecimal((Integer)patologia.getChopnconsec());
                return value;
            }

            else if (fieldName.equals("FECHA_REG")) {
                value = (Date)patologia.getChopdfechareg();
                return value;
            }
            
            else if (fieldName.equals("COD_SERVICIO")) {            
                value = patologia.getChopccodiserv() + " - " + patologia.getNombServcio();
                return value;
            }
            
            else if (fieldName.equals("IDENTIFICACION") ) {                              
                value = patologia.getTipoIden() + " " + patologia.getNumInden().toString();
                return value;     
            }
            
            else if (fieldName.equals("USUARIO") ) {
                value = patologia.getNombusuario();
                return value;    
            } 
            
            else if (fieldName.equals("GRUPO")) {
                value = new BigDecimal(0); // Todavia no se agrupa
                return value;
            }
            
            else if (fieldName.equals("PATOLOGO")) {
                value = patologia.getLaboratorio();  
                return value;
            }
       
        return value;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < listadoPatologias_sel.size());
    }


    public void guardarlistadoPatologias_mod() {

        index = -1;
        generoReporte = false;

        boolean exito = true;



        if (exito) {
            try {

                //this.serviceLocator.getClinicoService().saveDetalleListaPatologias(listadoPatologias_mod);
                //FacesUtils.addInfoMessage(MSG_ACTUALIZACION);

                if (imprimeListado.equalsIgnoreCase("S")) {

                    listadoPatologias_sel = new ArrayList<Chotraspatolog>();

                    for (Chotraspatolog otraspatolog: listadoPatologias_mod) {
                        if (otraspatolog.isItemSelected()) {
                            listadoPatologias_sel.add(otraspatolog);
                            if(this.idListado_mod == null){
                                this.idListado_mod = otraspatolog.getIdListado().intValue();
                            }
                            
                        }
                    }


                    if (listadoPatologias_sel.size() == 0) {
                        FacesUtils.addErrorMessage(MSG_VALIDACION_SELECCION_REQUERIDO);
                        exito = false;
                    }

                    if (exito) {

                        String pathReporte = null;
                        Date fechaEnvio = null;
                        String nameReporte = null;

                        Chentregapatol identregapatol = new Chentregapatol();
                        identregapatol.setHeplidentificador(this.idListado_mod.longValue());
                        
                        List listpatol = this.serviceLocator.getClinicoService().getListaEntregaPatol(identregapatol);
                        
                        
                        if(!listpatol.isEmpty())
                            entregapatol = (Chentregapatol)listpatol.get(0);
                            
                        pathReporte = "/reports/reporteEntregaPatologias.jasper";
                        fechaEnvio = entregapatol.getHepdfechaenvio();
                        nameReporte = "lectura_uno";

                        Cpclinica centro = this.serviceLocator.getClinicoService().getClinica(entregapatol.getHepnclinica());
                        URL url = FacesUtils.getFacesContext().getExternalContext().getResource(pathReporte);
                        URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
                        URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
                        URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 



                        if (url != null) {

                            Map reportParams = new HashMap();
                            reportParams.put("CENTRO", centro.getCclcnombre());
                            reportParams.put("COD_CENTRO", centro.getCclncodigo());
                            reportParams.put("FECHA_ENVIO", fechaEnvio);
                            reportParams.put("ID_LISTADO", entregapatol.getHeplidentificador());
                            reportParams.put("IMAGE_PROFAMILIA", url_profamilia);
                            reportParams.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                            reportParams.put("IMAGE_SUPER_VERTICAL", url_super_vertical);                                             
                            JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                            byte[] bytes;
                            bytes =  JasperRunManager.runReportToPdf(report, reportParams, (JRDataSource)this);
                            PdfServletUtils.showPdfDocument(bytes, nameReporte + centro.getCclncodigo() + "_" + Calendar.getInstance().getTimeInMillis() + ".pdf", false);
                            generoReporte = true;

                        }
                    }

                }


            } catch (ModelException de) {
                de.printStackTrace();
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_ACTUALIZACION);
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_ACTUALIZACION);
            }
        }

    }
    
    
    
    /**
     * Backing bean action para ver la forma en edicion de profesionales.
     * @return the navigation result
     */
    public Object verEditar() {
        this.estadopatol = this.PATOLOGIA_REG_DIA;
        this.chotraspatologClone = 
                (Chotraspatolog)((Chotraspatolog)this.dtlistadoPatologias_mod.getRowData()).clone();
        indexDto = dtlistadoPatologias_mod.getRowIndex();

        return BeanNavegacion.RUTA_ADICIONAR;

    }    
    
    /**
     * Backing bean action para una regla de navegacion global.
     * @return the navigation result
     */
    public Object volverConsulta() {
        return BeanNavegacion.RUTA_REGRESAR;
    }


    //ACCESSORS

    public void setIdListado(Integer idListado) {
        this.idListado = idListado;
    }

    public Integer getIdListado() {
        return idListado;
    }

    public void setlistadoPatologias(List<Chotraspatolog> listadoPatologias) {
        this.listadoPatologias = listadoPatologias;
    }

    public List<Chotraspatolog> getlistadoPatologias() {
        return listadoPatologias;
    }

    public void setDtlistadoPatologias(HtmlDataTable dtlistadoPatologias) {
        this.dtlistadoPatologias = dtlistadoPatologias;
    }

    public HtmlDataTable getDtlistadoPatologias() {
        return dtlistadoPatologias;
    }

    public void setTipoLectura(String tipoLectura) {
        this.tipoLectura = tipoLectura;
    }

    public String getTipoLectura() {
        return tipoLectura;
    }

    public void setIdListado_mod(Integer idListado_mod) {
        this.idListado_mod = idListado_mod;
    }

    public Integer getIdListado_mod() {
        return idListado_mod;
    }

    public void setTipoLectura_mod(String tipoLectura_mod) {
        this.tipoLectura_mod = tipoLectura_mod;
    }

    public String getTipoLectura_mod() {
        return tipoLectura_mod;
    }

    public void setlistadoPatologias_mod(List<Chotraspatolog> listadoPatologias_mod) {
        this.listadoPatologias_mod = listadoPatologias_mod;
    }

    public List<Chotraspatolog> getlistadoPatologias_mod() {
        return listadoPatologias_mod;
    }

    public void setDtlistadoPatologias_mod(HtmlDataTable dtlistadoPatologias_mod) {
        this.dtlistadoPatologias_mod = dtlistadoPatologias_mod;
    }

    public HtmlDataTable getDtlistadoPatologias_mod() {
        return dtlistadoPatologias_mod;
    }

    public void setImprimeListado(String imprimeListado) {
        this.imprimeListado = imprimeListado;
    }

    public String getImprimeListado() {
        return imprimeListado;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setIdPatologia(BigDecimal idPatologia) {
        this.idPatologia = idPatologia;
    }

    public BigDecimal getIdPatologia() {
        return idPatologia;
    }

    public void setChotraspatologClone(Chotraspatolog chotraspatologClone) {
        this.chotraspatologClone = chotraspatologClone;
    }

    public Chotraspatolog getChotraspatologClone() {
        return chotraspatologClone;
    }

    public void setIndexDto(int indexDto) {
        this.indexDto = indexDto;
    }

    public int getIndexDto() {
        return indexDto;
    }
    
    public void setEstadopatol(ValueChangeEvent valueChangeEvent) {
        setEstadopatol((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setEstadopatol(String estadopatol) {
        this.estadopatol = estadopatol;
    }

    public String getEstadopatol() {
        return estadopatol;
    }
}


