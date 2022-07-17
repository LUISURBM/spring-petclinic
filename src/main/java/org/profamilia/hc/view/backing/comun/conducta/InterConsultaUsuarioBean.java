//=======================================================================
// ARCHIVO InterConsultaUsuarioBean.java
// FECHA CREACI�N: 15/06/2010
// AUTOR:
// Descripci�n: Datos correspondientes a la conducta de Inter-Consulta.
//=======================================================================
package org.profamilia.hc.view.backing.comun.conducta;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetafactura;
import org.profamilia.hc.model.dto.CfdetafacturaPK;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chremision;
import org.profamilia.hc.model.dto.Chtipointerc;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorCie10Bean;
import org.profamilia.hc.view.backing.clinico.comun.BuscadorInterconsultaBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE InterConsultaUsuarioBean
//=======================================================================

public class InterConsultaUsuarioBean extends BaseBean implements JRDataSource {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private String descripcion;

    private boolean modoConsulta;

    private String consultaSelect;

    private List lstTipoConsulta;

    private List<Chremision> lstRemision;
    private List<Chremision> lstRemisionImp;

    private HtmlDataTable dtRemision;

    private boolean generoDocPDF;

    private boolean esIlve;

    private Chremision remisionClon;

    private Integer consecutivo;

    private int index = -1;

    String NOMBRES;

    String PRIMER_APELLIDO;

    String SEGUNDO_APELLIDO;

    String TIPO_DOCUMENTO;

    Long NUMERO_DOCUMENTO;

    String DIAGNOSTICO_PRINCIPAL;

    String DIAGNOSTICO_SECUNDARIO;

    String CODIGO_CIE10;

    String TIPO_USUARIO;

    String ANO;

    String MES;

    String DIA;

    Integer EDAD;

    Date fecha;

    String CODIGO_CIE10_PRINCIPAL;
    
    String NOMBRE_PROFESIONAL;
    
    String TIPOID_PROFESIONAL;
    
    BigDecimal NUMID_PROFESIONAL;
    
    String REGISTRO_MEDICO; 
    
    String ESPECIALIDAD = null;
    
    String TIPO_CONSULTA;

    private boolean esCirugia;

    /** Almacena el consulta */
    private Long numeroConsulta;

    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;

    private String tipoServicio;

    private String menuBean;

    private String cie10Principal;
    
    private Long numeroAdmision;
    private List<Cfdetafactura> cfdetafacturaList;
    private HtmlDataTable tableServiciosAdmision;
    private Cfdetafactura cfdetafactura;
    private List<Object[]> resultList;
    private Cfadmision admision;
    private Cnconsclin consulta;
    private Long consecutivoFactura;
    private OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean;
    
    private boolean renderPlantilla;
    
    private int selectedIndex;
    
    private UIInput inputInterconsulta; 
    
    private String descripcionInterconsulta; 
    
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //----------------------------------------------------------------------- 

    public InterConsultaUsuarioBean() {
    }

    //ACTIONS  

    public void init() {
        lstRemision = new ArrayList<Chremision>();
        lstRemisionImp = new ArrayList<Chremision>();
        modoConsulta = false;
        esIlve = false;
        numeroAdmision= null;
        cfdetafactura = new Cfdetafactura();
        cfdetafacturaList = new ArrayList();
        resultList = new ArrayList();
        tableServiciosAdmision = new HtmlDataTable();
        admision = new Cfadmision();
        consecutivoFactura = null;
        inicializarInterConsulta();

    }

    public void inicializarInterConsulta() {
        generoDocPDF = false;
        lstRemisionImp = new ArrayList<Chremision>();

        try {
            lstRemision = 
                    this.getServiceLocator().getClinicoService().getRemisionConsulta(numeroConsulta, 
                                                                                     tipoServicio, 
                                                                                     consecutivo);
            if (lstRemision != null) {
                for (Chremision remi: lstRemision) {
                    Chtipointerc servicio = 
                        this.serviceLocator.getClinicoService().getInterconsultaPorCriterios(remi.getHrecservicio());
                    if (servicio != null) {
                        remi.setHrecdesservici(servicio.getHticdescripcio());
                    }
                }
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (lstRemision == null || lstRemision.isEmpty()) {
            lstRemision = new ArrayList<Chremision>();
            modoConsulta = false;
            
            if (esIlve) {
                consultaSelect = "0";
                descripcion = "S890202.15 CONSULTA ESPEC. PREANESTESICA";
                agregarInterconsulta();
            }
        } else {
            modoConsulta = true;
            
        }
        //busquedaDetalleFactura();
    }
    
    private void busquedaDetalleFactura() {
        try {
            if (numeroAdmision != null) {
                resultList = 
                        getServiceLocator().getClinicoService().getListaServiciosXAdmision(numeroAdmision,IConstantes.OPCIONINTERCONSULTA);

                if (resultList != null && !resultList.isEmpty()) {
                    cfdetafacturaList = new ArrayList<Cfdetafactura>();

                    for (Object[] objeto: resultList) {

                        if (objeto[17] == null) {
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
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public boolean next() throws JRException {
        index++;
        return (index < lstRemisionImp.size());
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();

        if (fieldName.equals("APELLIDO1")) {
            value = PRIMER_APELLIDO;
            return value;
        }

        if (fieldName.equals("APELLIDO2")) {
            value = SEGUNDO_APELLIDO;
            return value;
        }
        if (fieldName.equals("NOMBRES")) {
            value = NOMBRES;
            return value;
        }
        if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = NUMERO_DOCUMENTO;
            return value;
        }
        if (fieldName.equals("DIA")) {
            value = DIA;
            return value;
        }
        if (fieldName.equals("MES")) {
            value = MES;
            return value;
        }
        if (fieldName.equals("ANO")) {
            value = ANO;
            return value;
        }
        if (fieldName.equals("TIPO_CONSULTA")) {
            value = TIPO_CONSULTA;
            return value;
        }
/*        if (fieldName.equals("TIPO_CONSULTA")) {
            String valueObject = "";
            Chtipointerc tipoAux = null;
            value = "";
            if (lstRemisionImp.get(index).getHrecservicio() != null) {
                try {
                    tipoAux = 
                            this.serviceLocator.getClinicoService().getInterconsultaPorCriterios(lstRemisionImp.get(index).getHrecservicio());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

            }

            if (tipoAux != null && !tipoAux.equals("")) {
                valueObject = 
                        lstRemisionImp.get(index).getHrecservicio() + " " + tipoAux.getHticdescripcio();
            }

            value = valueObject;
            return value;
        }
*/
        if (fieldName.equals("DESCRIPCION_REMISION")) {
            value = lstRemisionImp.get(index).getHrecdescripcio();
            return value;
        }

        if (fieldName.equals("EDAD")) {
            value = EDAD;
            return value;
        }
        if (fieldName.equals("DIAGNOSTICO_PRINCIPAL")) {
            value = DIAGNOSTICO_PRINCIPAL;
            return value;
        }
        
        if (fieldName.equals("NOMBRE_PROFESIONAL")) {
            value = NOMBRE_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("TIPOID_PROFESIONAL")) {
            value = TIPOID_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("NUMID_PROFESIONAL")) {
            value = NUMID_PROFESIONAL;
            return value;
        }
        if (fieldName.equals("REGISTRO_MEDICO")) {
            value = REGISTRO_MEDICO;
            return value;
        }
        if (fieldName.equals("ESPECIALIDAD")) {
            value = ESPECIALIDAD;
            return value;
        }

        return null;

    }

/*    public void obtenerDatosReporteConsulta() {

        if (usuario != null) {

            if (usuario.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuario.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }
            }

            if (cie10Principal != null) {

                Crdgncie10 diagprin = null;

                CODIGO_CIE10_PRINCIPAL = cie10Principal.toUpperCase();


                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = 
                            CODIGO_CIE10_PRINCIPAL + " " + diagprin.getCdccdescri();
                } else {
                    DIAGNOSTICO_PRINCIPAL = "";
                }
            }

            if (usuario.getHuscprimernomb() != null) {
                NOMBRES = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
            }
            if (usuario.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
            }
            if (usuario.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuario.getHusetipoiden().toString();
            }
            if (usuario.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuario.getHusanumeiden();
            }
            if (usuario.getHusetipoafilia() != null) {

                if (usuario.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuario.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuario.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuario.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuario.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuario.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }
            }
        }
        
        if (userName() != null) {
            Cpprofesio profesional;
            profesional = null;
            try {
                if (this.getClinica() != null) {
                    profesional = 
                            serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                       getClinica().getCclncodigo());
                }

            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (profesional != null) {
                NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                TIPOID_PROFESIONAL = profesional.getCpfctipide();
                NUMID_PROFESIONAL = profesional.getCpfacedula();
                REGISTRO_MEDICO = profesional.getCpfcregmedic();
                ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
            }
        }

        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer anoact = calendar.get(calendar.YEAR);

        if (diaact.compareTo(10) < 0) {
            DIA = "0" + diaact.toString();
        } else {
            DIA = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            MES = "0" + mesact.toString();
        } else {
            MES = mesact.toString();
        }

        ANO = anoact.toString();

    }


    public void obtenerDatosReporteCirugia() {

        Chusuario usuarioAux;
        usuarioAux = null;

        if (usuario != null) {
            usuarioAux = usuario;

        }

        if (usuarioAux != null) {

            if (usuarioAux.getHusdfechanacim() != null) {
                Date fechaNacimiento = usuarioAux.getHusdfechanacim();
                if (fechaNacimiento != null) {
                    int edad = calcularEdad(fechaNacimiento, new Date());
                    EDAD = edad;
                }

            }

            if (cie10Principal != null) {

                Crdgncie10 diagprin = null;
                CODIGO_CIE10_PRINCIPAL = cie10Principal.toUpperCase();

                try {
                    diagprin = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (diagprin != null) {
                    DIAGNOSTICO_PRINCIPAL = 
                            CODIGO_CIE10_PRINCIPAL + " " + diagprin.getCdccdescri();
                }
            }

            if (usuarioAux.getHuscprimernomb() != null) {
                NOMBRES = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                NOMBRES = NOMBRES + usuarioAux.getHuscsegundnomb();
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                PRIMER_APELLIDO = usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                SEGUNDO_APELLIDO = usuarioAux.getHuscsegundapel();
            }
            if (usuarioAux.getHusetipoiden() != null) {
                TIPO_DOCUMENTO = usuarioAux.getHusetipoiden().toString();
            }
            if (usuarioAux.getHusanumeiden() != 0) {
                NUMERO_DOCUMENTO = usuarioAux.getHusanumeiden();
            }
            if (usuarioAux.getHusetipoafilia() != null) {

                if (usuarioAux.getHusetipoafilia().equals("C")) {
                    TIPO_USUARIO = "CONTRIBUTIVO";
                }
                if (usuarioAux.getHusetipoafilia().equals("E")) {
                    TIPO_USUARIO = "ESPECIAL";
                }
                if (usuarioAux.getHusetipoafilia().equals("R")) {
                    TIPO_USUARIO = "SUBSIDIO PARCIAL";
                }
                if (usuarioAux.getHusetipoafilia().equals("S")) {
                    TIPO_USUARIO = "SUBSIDIADO";
                }
                if (usuarioAux.getHusetipoafilia().equals("V")) {
                    TIPO_USUARIO = "VINCULADO";
                }
                if (usuarioAux.getHusetipoafilia().equals("X")) {
                    TIPO_USUARIO = "NINGUNO";
                }
            }
        }

        fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        Integer diaact = calendar.get(Calendar.DAY_OF_MONTH);
        Integer mesact = calendar.get(Calendar.MONTH) + 1;
        Integer anoact = calendar.get(calendar.YEAR);

        if (diaact.compareTo(10) < 0) {
            DIA = "0" + diaact.toString();
        } else {
            DIA = diaact.toString();
        }

        if (mesact.compareTo(10) < 0) {
            MES = "0" + mesact.toString();
        } else {
            MES = mesact.toString();
        }
        ANO = anoact.toString();

    }
*/    

    public void eliminarRemision() {
        this.remisionClon = (Chremision)this.dtRemision.getRowData();
        this.lstRemision.remove(remisionClon);
        for (Cfdetafactura fact: cfdetafacturaList) {
            if (fact.getCdfcservicio().equals(remisionClon.getHrecservicio())) {
                fact.setValidacionConsultaClinica(false);
            }
        }
        FacesUtils.addInfoMessage(IMsg.MSG_ELIMINACION);
    }

    public void agregarInterconsulta() {

        Chremision remision;
        remision = new Chremision();
        if (consultaSelect != null && !consultaSelect.equals("") && 
            descripcion != null && !descripcion.equals("")) {

            descripcionInterconsulta = ""; 
            Chtipointerc tipoInt = new Chtipointerc();
            
            if(consultaSelect != null && !consultaSelect.equals("")){
                try {
                    tipoInt = serviceLocator.getClinicoService().getInterconsultaPorCriterios(consultaSelect);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                
                if(tipoInt != null){
                    descripcionInterconsulta = tipoInt.getHticdescripcio();
                    remision.setHrecservicio(consultaSelect);
                    remision.setHredfecregistr(new Date());
                    remision.setHrecoperador(userName());
                    remision.setHrecdescripcio(descripcion);
                    lstRemision.add(remision);
                    descripcionInterconsulta = ""; 
                    consultaSelect = "";
                    descripcion = "";
                    FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                }else{
                    descripcionInterconsulta = "La interconsulta no existe"; 
                    FacesUtils.addErrorMessage("La interconsulta no existe, favor verificar");
                }
            }


           
        } else {
            FacesUtils.addErrorMessage("Debe Registrar todos los datos");
        }
    }

    public void generarRemision() {

        this.index = -1;

        if (lstRemision.size() != 0) {

            try {
                Cptipodocu tipodocu = new Cptipodocu();
                Cpservicio servicio = new Cpservicio();
                List<Cnconsclin> listadeConsultasClinicas = new ArrayList();
                

                admision = 
                        getServiceLocator().getClinicoService().getAdmision(numeroAdmision);
               /*         
                for (Chremision remision: lstRemision) {
                    for (Cfdetafactura detalle: cfdetafacturaList) {
                        if (detalle.getCdfnconsuclin() == null && 
                            detalle.getCdfcservicio().equals(remision.getHrecservicio())) {
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
                            listadeConsultasClinicas.add(consclin);
                        }
                    }
                }        
           */
                
                this.serviceLocator.getClinicoService().saveListRemisionInterconsultaCirugiaLiberacion(lstRemision,numeroConsulta,
                                                                                                       tipoServicio,consecutivo,listadeConsultasClinicas,
                                                                                                       cfdetafacturaList,numeroAdmision);
                
                //busquedaDetalleFactura();
                ordenCirugiaUsuarioBean = 
                        (OrdenCirugiaUsuarioBean)FacesUtils.getManagedBean("ordenCirugiaUsuarioBean");
                        
                ordenCirugiaUsuarioBean.init();       
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);


            } catch (ModelException e) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
                e.printStackTrace();
            }

            try {
                byte[] bytes = generarReporteInterConsulta(numeroConsulta, consecutivo, tipoServicio);
                if (bytes != null) {
                    PdfServletUtils.showPdfDocument(bytes, 
                                            "Interconsulta" + Calendar.getInstance().getTimeInMillis() + 
                                            ".pdf", false);
                    generoDocPDF = true;
                    modoConsulta = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " +
                                   e.getMessage());
            }

/*            try {
                if (!esCirugia) {
                    obtenerDatosReporteConsulta();
                } else {
                    obtenerDatosReporteCirugia();
                }

               URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GS-RC-004.jasper");
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
                                                    "Interconsulta" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);
                    generoDocPDF = true;
                    modoConsulta = true;

                }
                
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
*/
        } else {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_EXISTEN_CONSULTAS);
        }
    }
    
    public void agregarServicioPropuesto() {
        Cfdetafactura factura=(Cfdetafactura)tableServiciosAdmision.getRowData();  
        Chremision remision;
        remision = new Chremision();
        if (factura != null && 
            (factura.getDescripcionServicio() != null && !factura.getDescripcionServicio() .equals(""))) {
            remision.setHrecservicio(factura.getCdfcservicio());
            remision.setHredfecregistr(new Date());
            remision.setHrecoperador(userName());
            remision.setHrecdescripcio(factura.getDescripcionServicio());
            remision.setHrecdesservici(factura.getNombreServicio());
            lstRemision.add(remision);
            consultaSelect = "";
            descripcion = "";
            for (Cfdetafactura fact: cfdetafacturaList) {
                if (fact.getCdfcservicio().equals(factura.getCdfcservicio())) {
                    fact.setValidacionConsultaClinica(true);
                }
            }

        } else {
            FacesUtils.addErrorMessage("Debe Registrar todos los datos");
        }
    
    }

    // ACCESSORS

    /**
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param esCirugia
     */
    public void setEsCirugia(boolean esCirugia) {
        this.esCirugia = esCirugia;
    }

    /**
     * @return
     */
    public boolean isEsCirugia() {
        return esCirugia;
    }

    /**
     * @param modoConsulta
     */
    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    /**
     * @return
     */
    public boolean isModoConsulta() {
        return modoConsulta;
    }

    /**
     * @param consultaSelect
     */
    public void setConsultaSelect(String consultaSelect) {
        this.consultaSelect = consultaSelect;
    }

    /**
     * @return
     */
    public String getConsultaSelect() {
        return consultaSelect;
    }

    /**
     * @param lstTipoConsulta
     */
    public void setLstTipoConsulta(List lstTipoConsulta) {
        this.lstTipoConsulta = lstTipoConsulta;
    }

    /**
     * @return
     */
    public List getLstTipoConsulta() {
        if (lstTipoConsulta == null || lstTipoConsulta.isEmpty()) {
            lstTipoConsulta = new ArrayList();
            ArrayList<Chtipointerc> lstTipoConsultaAux = null;
            try {
                lstTipoConsultaAux = 
                        (ArrayList<Chtipointerc>)this.serviceLocator.getClinicoService().getTiposInterconsulta();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstTipoConsultaAux != null && !lstTipoConsultaAux.isEmpty()) {

                Iterator it = lstTipoConsultaAux.iterator();
                int i = 0;
                lstTipoConsulta.add(new SelectItem("", 
                                                   "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstTipoConsulta.add(new SelectItem(lstTipoConsultaAux.get(i).getHticcodigo(), 
                                                       lstTipoConsultaAux.get(i).getHticdescripcio()));
                    i++;
                }
            }
        }
        return lstTipoConsulta;
    }

    /**
     * @param dtRemision
     */
    public void setDtRemision(HtmlDataTable dtRemision) {
        this.dtRemision = dtRemision;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtRemision() {
        return dtRemision;
    }

    /**
     * @param generoDocPDF
     */
    public void setGeneroDocPDF(boolean generoDocPDF) {
        this.generoDocPDF = generoDocPDF;
    }

    /**
     * @return
     */
    public boolean isGeneroDocPDF() {
        return generoDocPDF;
    }


    /**
     * @param lstRemision
     */
    public void setLstRemision(List<Chremision> lstRemision) {
        this.lstRemision = lstRemision;
    }

    /**
     * @return
     */
    public List<Chremision> getLstRemision() {
        return lstRemision;
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
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    /**
     * @param cie10Principal
     */
    public void setCie10Principal(String cie10Principal) {
        this.cie10Principal = cie10Principal;
    }

    /**
     * @return
     */
    public String getCie10Principal() {
        return cie10Principal;
    }


    public void setEsIlve(boolean esIlve) {
        this.esIlve = esIlve;
    }

    public boolean isEsIlve() {
        return esIlve;
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

    public void setTableServiciosAdmision(HtmlDataTable tableServiciosAdmision) {
        this.tableServiciosAdmision = tableServiciosAdmision;
    }

    public HtmlDataTable getTableServiciosAdmision() {
        return tableServiciosAdmision;
    }

    public void setCfdetafactura(Cfdetafactura cfdetafactura) {
        this.cfdetafactura = cfdetafactura;
    }

    public Cfdetafactura getCfdetafactura() {
        return cfdetafactura;
    }

    public void setResultList(List<Object[]> resultList) {
        this.resultList = resultList;
    }

    public List<Object[]> getResultList() {
        return resultList;
    }

    public void setAdmision(Cfadmision admision) {
        this.admision = admision;
    }

    public Cfadmision getAdmision() {
        return admision;
    }

    public void setConsulta(Cnconsclin consulta) {
        this.consulta = consulta;
    }

    public Cnconsclin getConsulta() {
        return consulta;
    }

    public void setConsecutivoFactura(Long consecutivoFactura) {
        this.consecutivoFactura = consecutivoFactura;
    }

    public Long getConsecutivoFactura() {
        return consecutivoFactura;
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

    public void setOrdenCirugiaUsuarioBean(OrdenCirugiaUsuarioBean ordenCirugiaUsuarioBean) {
        this.ordenCirugiaUsuarioBean = ordenCirugiaUsuarioBean;
    }

    public OrdenCirugiaUsuarioBean getOrdenCirugiaUsuarioBean() {
        return ordenCirugiaUsuarioBean;
    }

    public void setRenderPlantilla(boolean renderPlantilla) {
        this.renderPlantilla = renderPlantilla;
    }

    public boolean isRenderPlantilla() {
        return renderPlantilla;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }
    
    public void mostrarInterconsulta(){
    
         BuscadorInterconsultaBean buscador = 
             (BuscadorInterconsultaBean)FacesUtils.getManagedBean("buscadorInterconsultaBean");
             
             if(buscador != null){
                 buscador.init();
                 buscador.setNombreBeanAnterior("interConsultaUsuarioBean");
                 buscador.setTagRenderizar("panelGridRemisionTab");
             }
             
             
        
         selectedIndex = 1;
         renderPlantilla = true;
         
    }

    public void setConsultaSelect(ValueChangeEvent valueChangeEvent) {
        setConsultaSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
  }

    public void setInputInterconsulta(UIInput inputInterconsulta) {
        this.inputInterconsulta = inputInterconsulta;
    }

    public UIInput getInputInterconsulta() {
        return inputInterconsulta;
    }
    
    
    public void changeInterconsulta(){
        descripcionInterconsulta = ""; 
        Chtipointerc tipoInt = new Chtipointerc();
        
        if(consultaSelect != null && !consultaSelect.equals("")){
            try {
                tipoInt = serviceLocator.getClinicoService().getInterconsultaPorCriterios(consultaSelect);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(tipoInt != null){
                descripcionInterconsulta = tipoInt.getHticdescripcio();
            }else{
                descripcionInterconsulta = "La interconsulta no existe"; 
            }
        }
        
    }

    public void setDescripcionInterconsulta(String descripcionInterconsulta) {
        this.descripcionInterconsulta = descripcionInterconsulta;
    }

    public String getDescripcionInterconsulta() {
        return descripcionInterconsulta;
    }
    
    public byte[] generarReporteInterConsulta(Long numConsulta, Integer consecutivo, String tipoServicio) {
        byte[] bytes = null;
        try {
            Cnconsclin consulta = this.serviceLocator.getClinicoService().getConsultaClinicaPorId(numConsulta.toString());
            Chusuario usuario = this.serviceLocator.getClinicoService().getUsuario(consulta.getCcolusuario().getHuslnumero());
            List<Chremision> lstRemisionAux = this.serviceLocator.getClinicoService().getRemisionConsulta(numConsulta, tipoServicio);
            lstRemisionImp = new ArrayList<Chremision>();
                
            if (lstRemisionAux != null && !lstRemisionAux.isEmpty()) {
                Chimprdiag imprdiag = this.serviceLocator.getClinicoService().getImresionDiagnostica(numConsulta, consecutivo);
                if (imprdiag != null && imprdiag.getHidcdiagprin() != null) {
                    Crdgncie10 diagprin = null;
                    CODIGO_CIE10_PRINCIPAL = imprdiag.getHidcdiagprin();
                    DIAGNOSTICO_PRINCIPAL = imprdiag.getHidcdiagprin();

                    diagprin = this.serviceLocator.getClinicoService().getCIE10PorCodigo(CODIGO_CIE10_PRINCIPAL);
                    if (diagprin != null) {
                        DIAGNOSTICO_PRINCIPAL = diagprin.getCdcccodigo()+ " " + diagprin.getCdccdescri() ;
                    }
                }
                
                Chremision remision = null;
                Iterator it = lstRemisionAux.iterator();
                TIPO_CONSULTA = "";
                while (it.hasNext()) {
                    remision = (Chremision)it.next();
                    
                    Chtipointerc tipoAux = null;
                    if (remision.getHrecservicio() != null) {
                        try {
                            tipoAux = 
                                    this.serviceLocator.getClinicoService().getInterconsultaPorCriterios(remision.getHrecservicio());
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    }

                    if (tipoAux != null && !tipoAux.equals("")) {
                        TIPO_CONSULTA = TIPO_CONSULTA + remision.getHrecservicio() + " " + tipoAux.getHticdescripcio() + "\n";
                    }
                }

                if (remision != null) {
                    lstRemisionImp.add(remision);
                    if (usuario.getHusdfechanacim() != null) {
                       Date fechaNacimiento = usuario.getHusdfechanacim();
                       if (fechaNacimiento != null) {
                          int edad = calcularEdad(fechaNacimiento, remision.getHredfecregistr());
                          EDAD = edad;
                       }
                    }

                    if (usuario.getHuscprimernomb() != null) {
                       NOMBRES = usuario.getHuscprimernomb() + " ";
                    }
                    if (usuario.getHuscsegundnomb() != null && !usuario.getHuscsegundnomb().equals("_")) {
                       NOMBRES = NOMBRES + usuario.getHuscsegundnomb();
                    }
                    if (usuario.getHuscprimerapel() != null) {
                       PRIMER_APELLIDO = usuario.getHuscprimerapel() + " ";
                    }
                    if (usuario.getHuscsegundapel() != null && !usuario.getHuscsegundapel().equals("_")) {
                       SEGUNDO_APELLIDO = usuario.getHuscsegundapel();
                    }
                    if (usuario.getHusetipoiden() != null) {
                       TIPO_DOCUMENTO = usuario.getHusetipoiden();
                    }
                    if (usuario.getHusanumeiden() != 0) {
                       NUMERO_DOCUMENTO = usuario.getHusanumeiden();
                    }
                    if ("C".equals(usuario.getHusetipoafilia())) {
                        TIPO_USUARIO = "CONTRIBUTIVO";
                    } else if ("E".equals(usuario.getHusetipoafilia())) {
                        TIPO_USUARIO = "ESPECIAL";
                    } else if ("R".equals(usuario.getHusetipoafilia())) {
                        TIPO_USUARIO = "SUBSIDIO PARCIAL";
                    } else if ("S".equals(usuario.getHusetipoafilia())) {
                        TIPO_USUARIO = "SUBSIDIADO";
                    } else if ("V".equals(usuario.getHusetipoafilia())) {
                        TIPO_USUARIO = "VINCULADO";
                    } else if ("X".equals(usuario.getHusetipoafilia())) {
                        TIPO_USUARIO = "NINGUNO";
                    }
                
                    Integer diaact = null;
                    Integer mesact = null;
                    Integer anoact = null;
                    Calendar calendar = Calendar.getInstance();
                    if (remision.getHredfecregistr() != null) {
                        calendar.setTime(remision.getHredfecregistr());
                        diaact = calendar.get(Calendar.DAY_OF_MONTH);
                        mesact = calendar.get(Calendar.MONTH) + 1;
                        anoact = calendar.get(calendar.YEAR);
                    }
                        
                    if (remision.getHrecoperador() != null && consulta != null && consulta.getCconclinic() != null) {
                        Cpprofesio profesional = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(remision.getHrecoperador().toLowerCase(), 
                                                                                                     consulta.getCconclinic());
                        if (profesional != null) {
                            NOMBRE_PROFESIONAL = profesional.getCpfcnombre();
                            REGISTRO_MEDICO = profesional.getCpfcregmedic();
                            ESPECIALIDAD = obtenerDescripcionTipoEspecialidad(profesional.getCpfntipoespe());
                            TIPOID_PROFESIONAL = profesional.getCpfctipide();
                            NUMID_PROFESIONAL = profesional.getCpfacedula();

                        }
                    }

                    if (diaact.compareTo(10) < 0) {
                        DIA = "0" + diaact.toString();
                    } else {
                        DIA = diaact.toString();
                    }

                    if (mesact.compareTo(10) < 0) {
                        MES = "0" + mesact.toString();
                    } else {
                        MES = mesact.toString();
                    }
                    ANO = anoact.toString();
                }
            }
            
            URL url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/FO-GS-RC-004.jasper");
            URL url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA); 
            URL url_super_horizontal = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL); 
            URL url_super_vertical = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL); 
            if (url != null) {

                Map parameters = new HashMap();
                parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                 
                JasperReport report = (JasperReport) JRLoader.loadObject(url);  
                bytes = JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                       e.getMessage());
        }
        return bytes;
    }
    
}
