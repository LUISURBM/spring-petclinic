package org.profamilia.hc.view.backing.asesoria.administrador;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chasesoria;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class ConsultarOtrasAsesoria extends BaseBean implements JRDataSource {


    private HtmlDataTable dtConsultaUsuario;

    private List lstUsuarios;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;


    private Chusuario usuario;

    private boolean existenCriterios;

    private boolean generoAsesoria;


    /** Almacenan los datos de la historia clinica */
    private String TIPO_DOCUMENTO;
    private Long NUMERO_DOCUMENTO;
    private String IMPRIMIO;
    private String NOMBRE;
    private Date FECHA_NACIMIENTO;
    private Integer EDAD;
    private String SEXO;
    private String OBSERVACIONES;
    private String TIPO_ASESORIA;
    private String NOMBRE_PROFESIONAL;
    private String REGISTRO_MEDICO;

    private Integer index;


    public ConsultarOtrasAsesoria() {
    }

    public void init() {
        lstUsuarios = new ArrayList();
        usuario = new Chusuario();
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
     * @param lstUsuarios
     */
    public void setLstUsuarios(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    /**
     * @return
     */
    public List getLstUsuarios() {
        return lstUsuarios;
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
     * @param index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * @return
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param generoAsesoria
     */
    public void setGeneroAsesoria(boolean generoAsesoria) {
        this.generoAsesoria = generoAsesoria;
    }

    /**
     * @return
     */
    public boolean isGeneroAsesoria() {
        return generoAsesoria;
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
        if (listTipoIdentificacion == null || 
            listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<SelectItem>();
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


    //-----------------------------------------------------------------------
    //  Generacion Reporte
    //-----------------------------------------------------------------------

    public boolean next() {
        index++;
        return (index < 1);
    }

    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = TIPO_DOCUMENTO;
        }

        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
        }

        if (fieldName.equals("IMPRIMIO")) {
            value = IMPRIMIO;
        }

        if (fieldName.equals("NOMBRE")) {
            value = NOMBRE;
        }

        if (fieldName.equals("FECHA_NACIMIENTO")) {
            value = FECHA_NACIMIENTO;
        }

        if (fieldName.equals("EDAD")) {
            value = EDAD;
        }

        if (fieldName.equals("SEXO")) {
            value = SEXO;
        }

        if (fieldName.equals("OBSERVACIONES")) {
            value = OBSERVACIONES;
        }

        if (fieldName.equals("TIPO_ASESORIA")) {
            value = TIPO_ASESORIA;
        }


        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        }

        return value;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Secundario
    //-----------------------------------------------------------------------


    /**
     * @return
     */
    public String consultarUsuario() {

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
                 (usuario.getHuscprimerapel() == null || 
                  usuario.getHuscprimerapel().equals("")) && 
                 (usuario.getHuscsegundapel() == null || 
                  usuario.getHuscsegundapel().equals("")))) {
                existenCriterios = false;
            }

        }


        if (existenCriterios) {

            try {
                lstUsuarios = 
                        serviceLocator.getClinicoService().getOtrasAsesoria(usuario);
                dtConsultaUsuario.setFirst(IConstantes.OFFSET_DATATABLE);
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (lstUsuarios == null || lstUsuarios.isEmpty()) {
                FacesUtils.addErrorMessage(IConstantes.MSG_SIN_DATOS);
            }
        } else {
            FacesUtils.addErrorMessage(IConstantes.MSG_CONSULTA_POR_FILTROS);
        }
        return BeanNavegacion.RUTA_ACTUAL;
    }


    public String obtenerDatosReporte(Chasesoria asesoriaAux) {
        // Obtenemos los datos del usuario 
        resetDatos();

        if (asesoriaAux != null) {
            if (asesoriaAux.getHasdfechanacim() != null) {
                FECHA_NACIMIENTO = asesoriaAux.getHasdfechanacim();
            }

            if (asesoriaAux.getHasnedad() != null) {
                EDAD = asesoriaAux.getHasnedad();
            }

            if (getUsuarioSystem() != null) {
                IMPRIMIO = this.getUsuarioSystem().getCurcnombre();
            }

            if (asesoriaAux.getHascprimernomb() != null) {
                NOMBRE = asesoriaAux.getHascprimernomb() + " ";
            }
            if (asesoriaAux.getHascsegundnomb() != null && 
                !asesoriaAux.getHascsegundnomb().equals("_")) {
                NOMBRE = NOMBRE + asesoriaAux.getHascsegundnomb() + " ";
            }
            if (asesoriaAux.getHascprimerapel() != null) {
                NOMBRE = NOMBRE + asesoriaAux.getHascprimerapel() + " ";
            }
            if (asesoriaAux.getHascsegundapel() != null && 
                !asesoriaAux.getHascsegundapel().equals("_")) {
                NOMBRE = NOMBRE + asesoriaAux.getHascsegundapel();
            }
            if (asesoriaAux.getHasanumeiden() != null && 
                asesoriaAux.getHasanumeiden() != 0) {
                TIPO_DOCUMENTO = asesoriaAux.getHasetipoiden();
                NUMERO_DOCUMENTO = asesoriaAux.getHasanumeiden();
            }


            SEXO = asesoriaAux.getHasesexo();

            OBSERVACIONES = asesoriaAux.getHascobservacio();
            TIPO_ASESORIA = "";

            if (asesoriaAux != null) {
            
                if (asesoriaAux.getHascconspadr() != null && 
                    asesoriaAux.getHascconspadr().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Consejer�a para Padres y Cuidadores " + 
                            "\n";
                }
                
                if (asesoriaAux.getHascconsexpl() != null && 
                    asesoriaAux.getHascconsexpl().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Consulta Sexualidad y Placer	" + 
                            "\n";
                }
                
                if (asesoriaAux.getHascviolencia() != null && 
                    asesoriaAux.getHascviolencia().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Violencia     " + 
                            "\n";
                }
                
                if (asesoriaAux.getHascvihpre() != null && 
                    asesoriaAux.getHascvihpre().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Asesor�a Pre Prueba de VIH " + 
                            "\n";
                }
                
                
                if (asesoriaAux.getHascvihpos() != null && 
                    asesoriaAux.getHascvihpos().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Asesor�a Pos Prueba de VIH " + 
                            "\n";
                }
                
                
                if (asesoriaAux.getHascintcris() != null ) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Realiz� intervenci�n en crisis?	 " + formatearCampo(asesoriaAux.getHascintcris()) + 
                            "\n";
                }
            
            
                if (asesoriaAux.getHaseplanitempo() != null && 
                    asesoriaAux.getHaseplanitempo().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Planificaci�n Temporal" + "\n";
                }

                if (asesoriaAux.getHaseplanidefin() != null && 
                    asesoriaAux.getHaseplanidefin().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Planificaci�n Definitiva " + "\n";
                }


                if (asesoriaAux.getHaseilve() != null && 
                    asesoriaAux.getHaseilve().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "ILVE " + "\n";
                }

                if (asesoriaAux.getHasediversexua() != null && 
                    asesoriaAux.getHasediversexua().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "G�nero y diversidad sexual " + 
                            "\n";
                }


                if (asesoriaAux.getHasesexuaejerc() != null && 
                    asesoriaAux.getHasesexuaejerc().equals("S")) {
                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Sexualidad y alteraciones relacionadas con el ejercicio " + 
                            "\n";
                }
                
               

                if (asesoriaAux.getHasevih() != null && 
                    asesoriaAux.getHasevih().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Pre y Pos VIH " + "\n";
                }


                if (asesoriaAux.getHaseits() != null && 
                    asesoriaAux.getHaseits().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "ITS " + "\n";
                }

                if (asesoriaAux.getHasevacunacion() != null && 
                    asesoriaAux.getHasevacunacion().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Vacunaci�n " + "\n";
                }

                if ((asesoriaAux.getHasepruebembar() != null && 
                     asesoriaAux.getHasepruebembar().equals("S")) || 
                    asesoriaAux.getHaseresulembar() != null) {
                    String resultado = "";

                    if (asesoriaAux.getHaseresulembar().equals("N")) {
                        resultado = "Negativo";
                    }

                    if (asesoriaAux.getHaseresulembar().equals("P")) {
                        resultado = "Positivo";
                    }

                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Prueba de Embarazo (resultado) " + resultado + "\n";
                }

                if (asesoriaAux.getHascviolefisic() != null && 
                        asesoriaAux.getHascviolefisic().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Violencia Fisica " + "\n";
                }

                if (asesoriaAux.getHascviolepsico() != null && 
                    asesoriaAux.getHascviolepsico().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Violencia Psicologica " + "\n";
                }

                if (asesoriaAux.getHascviolesexua() != null && 
                    asesoriaAux.getHascviolesexua().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Violencia Sexual " + "\n";
                }

                if (asesoriaAux.getHaseotro() != null && 
                    asesoriaAux.getHaseotro().equals("S")) {
                    String cualOtro = "";

                    if (asesoriaAux.getHasccualotro() != null) {
                        cualOtro = asesoriaAux.getHasccualotro();
                    }

                    TIPO_ASESORIA = 
                            TIPO_ASESORIA + "Otro " + "Cual? " + cualOtro + 
                            "\n";
                    if (asesoriaAux.getHascoperador() != null) {
                        Cpprofesio profesional;
                        profesional = null;
                        try {
                            if (this.getClinica() != null) {
                                profesional = 
                                        serviceLocator.getClinicoService().getProfesionalPorUsuario(asesoriaAux.getHascoperador(), 
                                                                                                    asesoriaAux.getHasnclinic());
                            }

                        } catch (ModelException e) {
                            return capturaError(e,IConstantes.ERROR_COSNULTA);
                        }

                        if (profesional != null) {
                            NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                            REGISTRO_MEDICO = profesional.getCpfcregmedic();


                        }
                    }
                }

                TIPO_ASESORIA = TIPO_ASESORIA + "Conducta: " + "\n";
                
                
                if (asesoriaAux.getHascenvantic() != null && 
                    asesoriaAux.getHascenvantic().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Consulta Anticoncepci�n" + "\n";
                }
                
                if (asesoriaAux.getHascenvabort() != null && 
                    asesoriaAux.getHascenvabort().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Consulta Aborto	" + "\n";
                }


                if (asesoriaAux.getHascenvplntem() != null && 
                    asesoriaAux.getHascenvplntem().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Anticoncepci�n temporal " + "\n";
                }

                if (asesoriaAux.getHascenvplndef() != null && 
                    asesoriaAux.getHascenvplndef().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Anticoncepci�n definitiva " + "\n";
                }

                if (asesoriaAux.getHascenvmedgen() != null && 
                    asesoriaAux.getHascenvmedgen().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Medicina general " + "\n";
                }

                if (asesoriaAux.getHascenvmedesp() != null && 
                    asesoriaAux.getHascenvmedesp().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Medicina especializada " + "\n";
                }

                if (asesoriaAux.getHascenvlabcli() != null && 
                    asesoriaAux.getHascenvlabcli().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Laboratorio cl�nico " + "\n";
                }

                if (asesoriaAux.getHascenvproduc() != null && 
                    asesoriaAux.getHascenvproduc().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Productos " + "\n";
                }
                
                
                if (asesoriaAux.getHascenvpsicolo() != null && 
                    asesoriaAux.getHascenvpsicolo().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Consulta de Psicolog�a	    " + "\n";
                }
                
                if (asesoriaAux.getHascenvunifer() != null && 
                    asesoriaAux.getHascenvunifer().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Unidad Fertilidad" + "\n";
                }
                
                if (asesoriaAux.getHascenvotro() != null && 
                    asesoriaAux.getHascenvotro().equals("S")) {
                    TIPO_ASESORIA = TIPO_ASESORIA + "Otro:" + asesoriaAux.getHascenvotrcond() + "\n";
                }

            }


        }
    return null;

    }

    private void resetDatos() {
        TIPO_DOCUMENTO = null;
        ;
        NUMERO_DOCUMENTO = null;
        IMPRIMIO = null;
        NOMBRE = null;
        FECHA_NACIMIENTO = null;
        EDAD = null;
        SEXO = null;
        OBSERVACIONES = null;
        TIPO_ASESORIA = null;
        NOMBRE_PROFESIONAL = null;
        REGISTRO_MEDICO = null;
    }


    /**
     * @param asesoriaAux
     */
    public String generarResumenAsesoria(Chasesoria asesoriaAux) {
        this.index = -1;
        try {
            obtenerDatosReporte(asesoriaAux);
            URL url = 
                FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteOtraAsesoria.jasper");
            URL url_profamilia = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA);
            URL url_super_horizontal = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
            URL url_super_vertical = 
                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);
            if (url != null) {
                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                byte[] bytes;

                JasperReport report = (JasperReport)JRLoader.loadObject(url);

                bytes = 
                        JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);

                PdfServletUtils.showPdfDocument(bytes, 
                                                "Resumen_Otra_Asesoria" + 
                                                ".pdf", false);
                generoAsesoria = true;

            }
        } catch (Exception e) {
            return capturaError(e,IConstantes.ERROR_REPORTES);
        }

    return null;
    }


    //-----------------------------------------------------------------------
    //  Bot�n Principal
    //-----------------------------------------------------------------------


    public String imprimirAsesoria() {
        Chasesoria asesoriaSelect = null;
        asesoriaSelect = (Chasesoria)dtConsultaUsuario.getRowData();

        if (asesoriaSelect != null) {
            generarResumenAsesoria(asesoriaSelect);
        }

        return null;
    }


}
