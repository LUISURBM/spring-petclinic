//=======================================================================
// ARCHIVO RepCitologiaLecturaDosBean.java
// FECHA CREACI�N: 21/09/2010
// AUTOR: Jhon Carranza Silva
// Descripci�n: Reporte correspondiente al seguimineto de las citologias
// que se entregan a los diferentes laboratorios para segunda lectura.
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento.reportes;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chdetaentcito;
import org.profamilia.hc.model.dto.Chentregacitol;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE RepCitologiaLecturaDosBean
//=======================================================================
public class RepCitologiaLecturaDosBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------


    private Date fechaEnvio;

    private boolean generoReporte;

    private String tipoLectura;

    private List listaCitologias = new ArrayList();

    private int index = -1;

    private Integer idListado;

    public RepCitologiaLecturaDosBean() {
    }

    public void init() {

        generoReporte = false;
        listaCitologias = new ArrayList();

    }

    // ACTIONS

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        Chdetaentcito detaentcito = 
            ((Chdetaentcito)listaCitologias.get(index));

        String motivo = "";

        if (fieldName.equals("FORMATO")) {
            value = (Integer)detaentcito.getCncitologi().getCcinconsec();
            return value;
        }

        else if (fieldName.equals("MOTIVO_ENVIO")) {
            if (detaentcito.getHdecresultado().equalsIgnoreCase("P")) {
                motivo = "Segunda Lectura";
            } else if (detaentcito.getHdecresultado().equalsIgnoreCase("N")) {
                motivo = "Control de Calidad";
            } else if (detaentcito.getHdecresultado().equalsIgnoreCase("NR")) {
                motivo = "No Recibido";
            } else {
                motivo = "";
            }
            value = (String)motivo;
            return value;
        }

        else if (fieldName.equals("FECHA_TOMA")) {
            value = (Date)detaentcito.getCncitologi().getCcidfeccit();
            return value;
        }

        else if (fieldName.equals("IDENTIFICACION")) {
            value = 
                    detaentcito.getCncitologi().getCcictipide() + " " + detaentcito.getCncitologi().getCcianumide();
            return value;
        }

        else if (fieldName.equals("USUARIO")) {
            value = 
                    detaentcito.getCncitologi().getCcicprinom() + " " + ((detaentcito.getCncitologi().getCcicsegnom() == 
                                                                          null) ? 
                                                                         "" : 
                                                                         detaentcito.getCncitologi().getCcicsegnom()) + 
                    " " + detaentcito.getCncitologi().getCcicpriape() + " " + 
                    ((detaentcito.getCncitologi().getCcicsegape() == null) ? 
                     "" : detaentcito.getCncitologi().getCcicsegape());
            return value;
        }

        return value;
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < listaCitologias.size());
    }

    public void generarListaEntrega() {
        index = -1;
        generoReporte = false;

        Calendar fechaActual = GregorianCalendar.getInstance();
        fechaActual.set(Calendar.HOUR_OF_DAY, 0);
        fechaActual.set(Calendar.MINUTE, 0);
        fechaActual.set(Calendar.SECOND, 0);
        fechaActual.set(Calendar.MILLISECOND, 0);

        if (fechaEnvio.compareTo(fechaActual.getTime()) < 0) {
            FacesUtils.addInfoMessage("Fecha de Envio: " + 
                                      MSG_VAL_FECHA_ACTUAL);
        } else {

            try {

                tipoLectura = "SL"; // Segunda Lectura.            
                listaCitologias = 
                        this.serviceLocator.getClinicoService().getCitologiaLecturaDos(idListado);

            } catch (ModelException de) {
                FacesUtils.addErrorMessage(null, de.getMessage(), 
                                           MSG_NO_CONSULTA);
            } catch (Exception e) {
                FacesUtils.addErrorMessage(null, e.getMessage(), 
                                           MSG_NO_CONSULTA);
            }

            if (listaCitologias.isEmpty()) {
                FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
            } else {

                try {

                    URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteCitologiasLecturaDos.jasper");
                    URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
                    URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
                    URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
                    if (url != null) {
                    
                        JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                        Chentregacitol entregacitol = 
                            ((Chdetaentcito)listaCitologias.get(0)).getChentregacitol();
                        entregacitol.setHecdfechaenvio2(fechaEnvio);

                        Set setCitologias = new HashSet(listaCitologias);
                        entregacitol.setChdetaentcitos(setCitologias);
                        entregacitol.setHeccoperador(this.getUsuarioSystem().getCurcusuari());
                        entregacitol.setHecdfechamod(new Date());
                        entregacitol.setHecnclinica(this.getClinica().getCclncodigo());

                        Cpprofesio profe = 
                            this.serviceLocator.getClinicoService().getProfesionalesLectura(this.getClinica().getCclncodigo(), 
                                                                                            entregacitol.getHecnlablectura1());
                        entregacitol.setHecnlablectura2(profe.getCpfncodigo());


                        Map reportParams = new HashMap();
                        reportParams.put("CENTRO", 
                                         this.getClinica().getCclcnombre());
                        reportParams.put("COD_CENTRO", 
                                         this.getClinica().getCclncodigo());
                        reportParams.put("FECHA_ENVIO", fechaEnvio);
                        reportParams.put("LABORATORIO", profe.getCpfcnombre());
                        reportParams.put("ID_LISTADO", 
                                         entregacitol.getHeclidentificador());
                        reportParams.put("IMAGE_PROFAMILIA", url_profamilia);
                        reportParams.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                        reportParams.put("IMAGE_SUPER_VERTICAL", url_super_vertical);

                        byte[] bytes;
                        bytes = 
                                JasperRunManager.runReportToPdf(report, 
                                                                reportParams, 
                                                                (JRDataSource)this);
                        PdfServletUtils.showPdfDocument(bytes, 
                                                        "lectura_dos" + this.getClinica().getCclncodigo() + 
                                                        "_" + 
                                                        Calendar.getInstance().getTimeInMillis() + 
                                                        ".pdf", false);
                        generoReporte = true;

                        this.serviceLocator.getClinicoService().saveEnvioCitologias(entregacitol);

                    }
                    
                }catch (ModelException me) {
                    me.printStackTrace();
                    FacesUtils.addErrorMessage("No se genero el reporte " + 
                                               me.getMessage());
                }
                
                catch (Exception e) {
                    e.printStackTrace();
                    FacesUtils.addErrorMessage("No se genero el reporte " + 
                                               e.getMessage());
                } 


            }

        }


    }

    //ACCESSORS


    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setIdListado(Integer idListado) {
        this.idListado = idListado;
    }

    public Integer getIdListado() {
        return idListado;
    }
}

