//=======================================================================
// ARCHIVO InformeMarcacionSenoBean.java
// FECHA CREACI�N: 09/06/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la marcacion del seno
//=======================================================================

package org.profamilia.hc.view.backing.procedimiento;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.ChinfomamogrPK;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorPlantillaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE InformeMarcacionSenoBean
//=======================================================================
public class InformeMarcacionSenoBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private boolean modoconsulta;

    private boolean generoInforme;

    private Chinfomamogr informe;

    private List lstTipoEstudio;

    private List lstOpciones;

    /** Almacena el consulta */
    private Cnconsclin consulta;

    private String navigationRule;

    private String nextAction;

    private String tipoServicio;

    /**  */
    private String menuBean;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private boolean renderBuscador;

    private boolean wexito;

    private UIInput itInforme;

    private int selectIndex;

    static int ACTIVAR_INFORME = 0;

    static int ACTIVAR_BUSCADOR = 1;


    String CIUDAD;
    Date FECHA;
    String NOMBRES;
    Integer NUMERO_ESTUDIO;
    Integer EDAD;
    String INFORMACION_CLINICA;
    String INFORME;
    String OPINION;
    Long NUMERO_IDENTIFICACION;
    String NOMBRE_MEDICO;
    Integer DES;
    String RECOMENDACIONES;
    String ECOGRAFIA;
    String NOMBRE_USUARIO;
    String REGISTRO_MEDICO;


    private static int NUMERO_COPIAS = 1;

    private int index = -1;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public InformeMarcacionSenoBean() {
    }

    public void init() {

        lstTipoEstudio = new ArrayList();

        lstOpciones = new ArrayList();
        inicializarMarcacion();

    }

    public void inicializarMarcacion() {
        generoInforme = false;
        try {
            if (consulta != null) {
                informe = 
                        serviceLocator.getClinicoService().getInformeMamografia(consulta, 
                                                                                IConstantes.INFORME_MARCACION_SENO);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (informe == null) {
            informe = new Chinfomamogr();
            modoconsulta = false;
        } else {
            modoconsulta = true;
        }
    }


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------

    /**
     * @param modoconsulta
     */
    public void setModoconsulta(boolean modoconsulta) {
        this.modoconsulta = modoconsulta;
    }

    /**
     * @return
     */
    public boolean isModoconsulta() {
        return modoconsulta;
    }

    /**
     * @param generoInforme
     */
    public void setGeneroInforme(boolean generoInforme) {
        this.generoInforme = generoInforme;
    }

    /**
     * @return
     */
    public boolean isGeneroInforme() {
        return generoInforme;
    }

    /**
     * @param informe
     */
    public void setInforme(Chinfomamogr informe) {
        this.informe = informe;
    }

    /**
     * @return
     */
    public Chinfomamogr getInforme() {
        return informe;
    }

    public void setLstTipoEstudio(List lstTipoEstudio) {
        this.lstTipoEstudio = lstTipoEstudio;
    }

    public List getLstTipoEstudio() {
        if (lstTipoEstudio.size() == 0) {
            lstTipoEstudio.add(new SelectItem("", "Seleccione una opci�n"));
            lstTipoEstudio.add(new SelectItem("D", "Seno Derecho"));
            lstTipoEstudio.add(new SelectItem("I", "Seno Izquierdo"));
            lstTipoEstudio.add(new SelectItem("A", "Ambos Senos"));
        }
        return lstTipoEstudio;
    }

    /**
     * @param lstOpciones
     */
    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    /**
     * @return
     */
    public List getLstOpciones() {
        if (lstOpciones.size() == 0) {
            lstOpciones.add(new SelectItem("S", "Si"));
            lstOpciones.add(new SelectItem("N", "No"));
        }
        return lstOpciones;
    }

    /**
     * @param consulta
     */
    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    /**
     * @return
     */
    public Cnconsclin getConsulta() {
        return consulta;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio() {
        return tipoServicio;
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
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }


    /**
     * @param renderBuscador
     */
    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    /**
     * @return
     */
    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    /**
     * @param itInforme
     */
    public void setItInforme(UIInput itInforme) {
        this.itInforme = itInforme;
    }

    /**
     * @return
     */
    public UIInput getItInforme() {
        return itInforme;
    }

    /**
     * @param selectIndex
     */
    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    /**
     * @return
     */
    public int getSelectIndex() {
        return selectIndex;
    }


    //-----------------------------------------------------------------------
    //  METODO ESVALIDO
    //-----------------------------------------------------------------------

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chinfomamogr informeAux = null;
        if (consulta != null) {
            try {
                informeAux = 
                        this.getServiceLocator().getClinicoService().getInformeMamografia(consulta, 
                                                                                          IConstantes.INFORME_MARCACION_SENO);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (informeAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }


    //-----------------------------------------------------------------------
    //  REPORTE
    //----------------------------------------------------------------------- 

    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("CIUDAD")) {
            value = CIUDAD;
        } else if (fieldName.equals("FECHA")) {
            value = FECHA;
        } else if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
        } else if (fieldName.equals("NUMERO_ESTUDIO")) {
            value = NUMERO_ESTUDIO;
        } else if (fieldName.equals("EDAD")) {
            value = EDAD;
        } else if (fieldName.equals("INFORMACION_CLINICA")) {
            value = INFORMACION_CLINICA;
        } else if (fieldName.equals("INFORME")) {
            value = INFORME;
        } else if (fieldName.equals("OPINION")) {
            value = OPINION;
        } else if (fieldName.equals("NUMERO_IDENTIFICACION")) {
            value = NUMERO_IDENTIFICACION;
        } else if (fieldName.equals("NOMBRE_MEDICO")) {
            value = NOMBRE_MEDICO;
        } else if (fieldName.equals("DES")) {
            value = DES;
        } else if (fieldName.equals("RECOMENDACIONES")) {
            value = RECOMENDACIONES;
        } else if (fieldName.equals("ECOGRAFIA")) {
            value = ECOGRAFIA;
        } else if (fieldName.equals("NOMBRE_USUARIO")) {
            value = NOMBRE_USUARIO;
        } else if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
        }


        return value;
    }

    public void obtenerDatosReporte() {


        if (this.getClinica() != null) {
            CIUDAD = this.getClinica().getCclcciudad();
        }

        if (informe != null) {

            if (informe.getHimcoperador() != null) {
                Cpprofesio profesional;
                profesional = null;
                try {
                    if (consulta != null) {
                        profesional = 
                                serviceLocator.getClinicoService().getProfesionalPorUsuario(informe.getHimcoperador(), 
                                                                                           consulta.getCconclinic());
                    }

                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (profesional != null) {
                    NOMBRE_USUARIO = profesional.getCpfcnombre();
                    REGISTRO_MEDICO = profesional.getCpfcregmedic();
                }
            }


            if (usuario != null) {
                if (usuario.getHusdfechanacim() != null) {
                    Date fechaNacimiento = usuario.getHusdfechanacim();
                    if (fechaNacimiento != null) {
                        int edad = calcularEdad(fechaNacimiento, new Date());
                        EDAD = edad;
                    }

                }

                if (usuario.getHuscprimernomb() != null) {
                    NOMBRES = usuario.getHuscprimernomb() + " ";
                }
                if (usuario.getHuscsegundnomb() != null && 
                    !usuario.getHuscsegundnomb().equals("_")) {
                    NOMBRES = NOMBRES + usuario.getHuscsegundnomb() + " ";
                }
                if (usuario.getHuscprimerapel() != null) {
                    NOMBRES = NOMBRES + usuario.getHuscprimerapel() + " ";
                }
                if (usuario.getHuscsegundapel() != null && 
                    !usuario.getHuscsegundapel().equals("_")) {
                    NOMBRES = NOMBRES + usuario.getHuscsegundapel();
                }

                if (usuario.getHusanumeiden() != 0) {
                    NUMERO_IDENTIFICACION = usuario.getHusanumeiden();
                }

            }


            FECHA = informe.getHimdfecregistr();

            if (informe.getHimnnumero() != null) {
                NUMERO_ESTUDIO = informe.getHimnnumero();
            }

            if (informe.getHimcdatosclire() != null) {
                INFORMACION_CLINICA = informe.getHimcdatosclire();
            }

            if (informe.getHimcinformamog() != null) {
                INFORME = informe.getHimcinformamog();
            }

            if (informe.getHimcopinion() != null) {
                OPINION = informe.getHimcopinion();
            }

            if (informe.getHimcmedicoremi() != null) {
                NOMBRE_MEDICO = informe.getHimcmedicoremi();
            }

            if (informe.getHimndosisentra() != null) {
                DES = informe.getHimndosisentra();
            }

            if (informe.getHimcrecomendac() != null) {
                RECOMENDACIONES = informe.getHimcrecomendac();
            }

            if (informe.getHimcecografia() != null) {
                ECOGRAFIA = informe.getHimcecografia();
            }


        }


    }


    //-----------------------------------------------------------------------
    //  BOTONES SECUNDARIOS
    //-----------------------------------------------------------------------

    public void aceptarPlantilla() {
        BuscadorPlantillaBean buscador = 
            (BuscadorPlantillaBean)FacesUtils.getManagedBean("buscadorPlantillaBean");
        if (buscador != null && buscador.getPlantillaSelect() != null) {
            informe.setHimcinformamog(buscador.getPlantillaSelect().getHplcdescripcio());
            itInforme.setValue(buscador.getPlantillaSelect().getHplcdescripcio());
        }
        renderBuscador = false;
        selectIndex = ACTIVAR_INFORME;
        FacesUtils.resetManagedBean("buscadorPlantillaBean");

    }


    public void mostrarBuscadorPlantilla() {
        if (!modoconsulta) {
            selectIndex = ACTIVAR_BUSCADOR;
            FacesUtils.resetManagedBean("buscadorPlantillaBean");
            renderBuscador = true;
        }

    }


    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------

    public String generarMarcacionSeno() {
        generoInforme = false;
        modoconsulta = false;
        wexito = true;
        navigationRule = "";
        informe.setHimcoperador(userName());
        informe.setHimdfecregistr(new Date());
        if (consulta != null && consulta.getCconnumero() != null) {
            ChinfomamogrPK id = new ChinfomamogrPK();
            id.setHimlconsulta(new Long(consulta.getCconnumero()));
            id.setHimctipoinform(IConstantes.INFORME_MARCACION_SENO);
            id.setHimctiposervi(tipoServicio);
            informe.setId(id);
        }


        if (wexito) {
            try {
                this.serviceLocator.getClinicoService().saveInformeMamografia(informe);
                modoconsulta = true;
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
                navigationRule = nextAction;
                FacesUtils.resetManagedBean(menuBean);
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                navigationRule = "";
                e.printStackTrace();
            }

            try {
                obtenerDatosReporte();
               URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/informeMarcacionSeno.jasper");
                URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
                URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
                URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
                
                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    byte[] bytes;
                    
                    JasperReport report = (JasperReport) JRLoader.loadObject(url); 

                    bytes = 
                            JasperRunManager.runReportToPdf(report, 
                                                            parameters, 
                                                            (JRDataSource)this);

                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "InformeMarcacionSeno" + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);

                    generoInforme = true;
                    modoconsulta = true;

                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }

        }


        return navigationRule;
    }


}
