package org.profamilia.hc.view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jboss.logging.Logger;
import org.apache.myfaces.custom.navmenu.NavigationMenuItem;

import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Saprograma;
import org.profamilia.hc.model.dto.Sausuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.asesoria.administrador.ConsultarOtrasAsesoria;
import org.profamilia.hc.view.backing.cirugia.autorizacion.notaAclaratoria.AprobarNotaAclaratoriaBean;
import org.profamilia.hc.view.backing.cirugia.autorizacion.notaAclaratoria.AutorizarNotaAclaratoriaBean;
import org.profamilia.hc.view.backing.cirugia.autorizacion.notaAclaratoria.SolicitarNotaAclaratoriaBean;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiasMedicoBean;
import org.profamilia.hc.view.backing.cirugia.registro.ReporteLogImpresionBean;
import org.profamilia.hc.view.backing.cirugia.registro.ReporteVinisoBean;
import org.profamilia.hc.view.backing.cirugia.registro.ReporteVphBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultaEtiquetaVphBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultaTomaTuberculinaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosCitologiaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosPAPsicologiaBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarFoliosVphBean;
import org.profamilia.hc.view.backing.clinico.consultas.ConsultarUsuarioBean;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaTuberculinaBean;
import org.profamilia.hc.view.backing.clinico.consultorio.ListaUsuariosPruebasRapidasBean;
import org.profamilia.hc.view.backing.comun.PruebasAnticuerposCovidBean;
import org.profamilia.hc.view.backing.comun.administracion.CertAsistenciaAdminBean;
import org.profamilia.hc.view.backing.comun.reporte.ReporteOtrasAsesoriasBean;
import org.profamilia.hc.view.backing.comun.reporte.ReporteOtrasAsesoriasNacionalBean;
import org.profamilia.hc.view.backing.pamec.RegistrarTemaBean;
import org.profamilia.hc.view.backing.procedimiento.reportes.RepSegCitologiasBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


public class MenuBean extends BaseBean {

    static final Logger log = Logger.getLogger(MenuBean.class);

    private static final String MENU_CONSULTAR_HISTORIA = "ConsultarHistoria";
    private static final String MENU_CONSULTAS_CLINICO = "clinicoadm";
    private static final String MENU_CONSULTAS_SIN_FACTURA = 
        "consultaSinFactura";
    private static final String MENU_REGISTRAR_HISTORIA = "RegistrarHistoria";
    private static final String MENU_REGISTRAR_NOTA_MEDICA = 
        "RegistrarNotaMedica";
    private static final String MENU_REGISTRO_TELEFONICO = 
        "RegistroTelefonico";
    private static final String MENU_REIMPRIMIR_CONDUCTA = "ImprimirConducta";
    private static final String MENU_MODIFICAR_DATOS = "ModificarDatos";
    private static final String MENU_CITOLOGIA = "citologia";
    private static final String MENU_VPH = "vph";
    private static final String MENU_CIRUGIA = "cirugia";
    private static final String MENU_ADMIN_PLANTILLA = "adminplan";
    private static final String MENU_VACUNACION = "vacunacion";
    private static final String MENU_REPORTES = "reportes";
    private static final String MENU_ASESORIA = "asesoria";
    private static final String MENU_PAMEC = "pamec";
    private static final String MENU_PARAMETROS = "parametros";
    private static final String MENU_SERVICIOS = "servicio";
    private static final String MENU_INFORMACION_SAP = "InformacionSap";
    private static final String MENU_LABORATORIO = "laboratorio";
    private static final String MENU_PROCEDIMIENTO = "procedimiento";
    private static final String MENU_NOTICIAS = "noticias";

    // PERFIL ADMINISTRATIVO
    private static final String MENU_GESTION_PRIORIDAD = "gestion";

    private static final String MENU_NOMB_INFORMACION_SAP = "Informaci�n";
    private static final String MENU_NOMB_CONSULTAR_HISTORIA = "Consultas";
    private static final String MENU_NOMB_REGISTRAR_HISTORIA = 
        "Registro de Historias";
    private static final String MENU_NOMB_REGISTRO_TELEFONICO = 
        "Registro Telef�nico";
    private static final String MENU_NOMB_REGISTRAR_NOTA = "Registros";
    private static final String MENU_NOMB_REIMPRIMIR_CONDUCTA = "Conducta";
    private static final String MENU_NOMB_MODIFICAR_DATOS = "Datos Pacientes";
    private static final String MENU_NOMB_CITOLOGIA = 
        "Tamizaje C�ncer de C�rvix";
    private static final String MENU_NOMB_CIRUGIA = "Cirugia";
    private static final String MENU_NOMB_ADMIN_PLANTILLA = "Mis Plantillas";
    private static final String MENU_NOMB_GESTION_PRIORIDAD = "Gesti�n";
    private static final String MENU_NOMB_VACUNACION = "Enfermeria";
    private static final String MENU_NOMB_REPORTES = "Reportes";
    private static final String MENU_NOMB_ASESORIA = "Asesoria";
    private static final String MENU_NOMB_PAMEC = "PAMEC";
    private static final String MENU_NOMB_PARAMETROS = "Parametros Generales";
    private static final String MENU_NOMB_SERVICIOS = "Servicios";
    private static final String MENU_NOMB_CLINICO = "Reportes Clinico";
    private static final String MENU_NOM_CONSULTAS = "Consultas Sin Factura";
    private static final String MENU_NOM_CONFIRMAR_CONSULTAS = 
        "Confirmar Consultas Sin Factura";
    private static final String MENU_NOM_LABORATORIOS = "Laboratorios";
    private static final String MENU_NOMB_PROCEDIMIENTO = 
        "Procedimientos de Consultorio";
    private static final String MENU_NOMB_NOTICIAS = "Noticias";


    private ConsultarUsuarioBean consultarUsuario;


    private NavigationMenuItem[] navItems;

    String nombUsuario;

    String clinUsuario;

    private List menuAdmin;

    private boolean mostarMenuAdmin;


    private boolean mostraMenuConHistoria;


    private boolean mostraMenuRegHistoria;


    private boolean mostraMenuRegNota;

    private boolean mostrarMenuRegTelefonico;

    private boolean mostrarMenuReimprCon;

    private boolean mostrarMenuDatosUsuario;

    private boolean mostrarCitologia;

    private boolean mostrarCirugia;

    private boolean mostrarVPH;

    private boolean mostrarAdminPlan;

    private boolean mostrarGestion;

    private boolean mostrarVacunacion;

    private boolean mostarMsgExpira;

    private boolean mostrarReportes;

    private boolean mostrarAsesoria;

    private boolean mostrarPamec;

    private boolean mostrarParametros;

    private boolean mostrarInformacion;

    private boolean mostrarServicios;

    private boolean mostrarReportesClinico;

    private boolean mostrarConsultaSinFactura;

    private boolean mostrarlaboratorio;

    private boolean listaSinFactura;

    private boolean mostrarConfirmarConsultaSinFactura;

    private boolean mostrarProcedimiento;

    private boolean mostrarNoticias;

    private String msgExpira;

    private String direccionIP;

    private Sausuario sausuario;


    public MenuBean() {
    }

    /**
     * Inicializa el Bean con la informacion requerida.
     * @see BaseBean#init()
     */
    protected void init() {
        if (getUsuarioSystem() != null) {
            nombUsuario = this.getUsuarioSystem().getCurcnombre();
        }

        if (getClinica() != null) {
            clinUsuario = this.getClinica().getCclcnombre();
        }
        if (getDireccionIP() != null) {
            direccionIP = this.getDireccionIP();
        }


        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        menuAdmin = new ArrayList();
        mostarMenuAdmin = false;
        mostraMenuConHistoria = false;
        mostraMenuRegHistoria = false;
        mostraMenuRegNota = false;
        mostrarMenuReimprCon = false;
        mostrarMenuDatosUsuario = false;
        mostrarCitologia = false;
        mostrarVPH = false;
        mostrarCirugia = false;
        mostrarAdminPlan = false;
        mostrarGestion = false;
        mostrarVacunacion = false;
        mostrarReportes = false;
        mostrarAsesoria = false;
        mostrarParametros = false;
        mostrarInformacion = false;
        mostrarServicios = false;
        mostrarReportesClinico = false;
        mostrarConsultaSinFactura = false;
        mostrarConfirmarConsultaSinFactura = false;
        listaSinFactura = false;
        mostrarMenuRegTelefonico = false;
        mostrarProcedimiento = false;
        mostrarNoticias = false;

        try {


            sausuario = 
                    serviceLocator.getClinicoService().getSausuario(this.getUsuarioSystem().getCurcusuari());

            if (sausuario != null && sausuario.getSusndiexp() != null && 
                sausuario.getSusndiexp().intValue() <= 12) {
                mostarMsgExpira = true;
                msgExpira = 
                        "� Su contrase�a expira en " + sausuario.getSusndiexp().intValue() + 
                        " d�as !";
            } else {
                mostarMsgExpira = false;
                msgExpira = "";
            }

            List listPermisos = 
                serviceLocator.getClinicoService().getPermisosUsuarioRol(this.getUsuarioSystem().getCurcusuari(), 
                                                                         APLICACION_HISTORIAS_CLINICAS);


            Iterator<Saprograma> it = listPermisos.iterator();


            NavigationMenuItem itemConsultaHistoria = 
                new NavigationMenuItem(MENU_NOMB_CONSULTAR_HISTORIA, null);
            NavigationMenuItem itemRegistrarHistoria = 
                new NavigationMenuItem(MENU_NOMB_REGISTRAR_HISTORIA, null);
            NavigationMenuItem itemRegistrarNota = 
                new NavigationMenuItem(MENU_NOMB_REGISTRAR_NOTA, null);
            NavigationMenuItem itemReImprimirConducta = 
                new NavigationMenuItem(MENU_NOMB_REIMPRIMIR_CONDUCTA, null);

            NavigationMenuItem itemModiciarDatos = 
                new NavigationMenuItem(MENU_NOMB_MODIFICAR_DATOS, null);

            NavigationMenuItem itemCitologiasDatos = 
                new NavigationMenuItem(MENU_NOMB_CITOLOGIA, null);

            NavigationMenuItem itemCirugias = 
                new NavigationMenuItem(MENU_NOMB_CIRUGIA, null);

            NavigationMenuItem itemAdminPlan = 
                new NavigationMenuItem(MENU_NOMB_ADMIN_PLANTILLA, null);

            NavigationMenuItem itemGestionPrio = 
                new NavigationMenuItem(MENU_NOMB_GESTION_PRIORIDAD, null);

            NavigationMenuItem itemVacunacion = 
                new NavigationMenuItem(MENU_NOMB_VACUNACION, null);

            NavigationMenuItem itemReportes = 
                new NavigationMenuItem(MENU_NOMB_REPORTES, null);

            NavigationMenuItem itemAsesoria = 
                new NavigationMenuItem(MENU_NOMB_ASESORIA, null);

            NavigationMenuItem itemPamec = 
                new NavigationMenuItem(MENU_NOMB_PAMEC, null);


            NavigationMenuItem itemParametros = 
                new NavigationMenuItem(MENU_NOMB_PARAMETROS, null);

            NavigationMenuItem itemInformacion = 
                new NavigationMenuItem(MENU_NOMB_INFORMACION_SAP, null);

            NavigationMenuItem itemServicio = 
                new NavigationMenuItem(MENU_NOMB_SERVICIOS, null);

            NavigationMenuItem itemClinico = 
                new NavigationMenuItem(MENU_NOMB_CLINICO, null);

            NavigationMenuItem itemConsultaSinFactura = 
                new NavigationMenuItem(MENU_NOM_CONSULTAS, null);

            NavigationMenuItem itemConfirmarConsultaSinFactura = 
                new NavigationMenuItem(MENU_NOM_CONFIRMAR_CONSULTAS, null);

            NavigationMenuItem itemLaboratorio = 
                new NavigationMenuItem(MENU_NOM_LABORATORIOS, null);

            NavigationMenuItem itemNoticias = 
                new NavigationMenuItem(MENU_NOMB_NOTICIAS, null);

            NavigationMenuItem itemRegistroTelefonico = 
                new NavigationMenuItem(MENU_NOMB_REGISTRO_TELEFONICO, null);

            NavigationMenuItem itemProcedimiento = 
                new NavigationMenuItem(MENU_NOMB_PROCEDIMIENTO, null);

            while (it.hasNext()) {
                Saprograma s = it.next();


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_PARAMETROS)) {

                    if (mostrarParametros == false) {
                        mostrarParametros = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemParametros.add(nuevoitem);
                }

                /*      if (s.getSpgcaplica().equalsIgnoreCase(MENU_INFORMACION_SAP)){

                    if(mostrarInformacion == false){
                       mostrarInformacion = true;

                    }
                    NavigationMenuItem nuevoitem =
                    new NavigationMenuItem(s.getSpgcdescri(),
                    "#{MenuBean.ir" +
                    s.getSpgcnombre() + "}");
                    itemInformacion.add(nuevoitem);
                }*/


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_CONSULTAR_HISTORIA)) {

                    if (mostraMenuConHistoria == false) {
                        mostraMenuConHistoria = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemConsultaHistoria.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_REGISTRAR_NOTA_MEDICA)) {

                    if (mostraMenuRegNota == false) {
                        mostraMenuRegNota = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemRegistrarNota.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_REGISTRAR_HISTORIA)) {

                    if (mostraMenuRegHistoria == false) {
                        mostraMenuRegHistoria = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemRegistrarHistoria.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_REIMPRIMIR_CONDUCTA)) {

                    if (mostrarMenuReimprCon == false) {
                        mostrarMenuReimprCon = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemReImprimirConducta.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_MODIFICAR_DATOS)) {

                    if (mostrarMenuDatosUsuario == false) {
                        mostrarMenuDatosUsuario = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemModiciarDatos.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_CITOLOGIA)) {

                    if (mostrarCitologia == false) {
                        mostrarCitologia = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemCitologiasDatos.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_CIRUGIA)) {
                    if (mostrarCirugia == false) {
                        mostrarCirugia = true;
                    }


                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");

                    itemCirugias.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_ADMIN_PLANTILLA)) {

                    if (mostrarAdminPlan == false) {
                        mostrarAdminPlan = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemAdminPlan.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_GESTION_PRIORIDAD)) {

                    if (mostrarGestion == false) {
                        mostrarGestion = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemGestionPrio.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_VACUNACION)) {

                    if (mostrarVacunacion == false) {
                        mostrarVacunacion = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemVacunacion.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_REPORTES)) {

                    if (mostrarReportes == false) {
                        mostrarReportes = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemReportes.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_ASESORIA)) {

                    if (mostrarAsesoria == false) {
                        mostrarAsesoria = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemAsesoria.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_PAMEC)) {

                    if (mostrarPamec == false) {
                        mostrarPamec = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemPamec.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_SERVICIOS)) {

                    if (mostrarServicios == false) {
                        mostrarServicios = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemServicio.add(nuevoitem);
                }


                if (s.getSpgcaplica().equalsIgnoreCase(MENU_CONSULTAS_CLINICO)) {

                    if (mostrarReportesClinico == false) {
                        mostrarReportesClinico = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemClinico.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_CONSULTAS_SIN_FACTURA)) {

                    if (mostrarConsultaSinFactura == false) {
                        mostrarConsultaSinFactura = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemConsultaSinFactura.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_NOM_CONFIRMAR_CONSULTAS)) {

                    if (mostrarConfirmarConsultaSinFactura == false) {
                        mostrarConfirmarConsultaSinFactura = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemConfirmarConsultaSinFactura.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_REGISTRO_TELEFONICO)) {

                    if (mostrarMenuRegTelefonico == false) {
                        mostrarMenuRegTelefonico = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemRegistroTelefonico.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_LABORATORIO)) {

                    if (mostrarlaboratorio == false) {
                        mostrarlaboratorio = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemLaboratorio.add(nuevoitem);
                }

                if (s.getSpgcaplica().equalsIgnoreCase(MENU_PROCEDIMIENTO)) {

                    if (mostrarProcedimiento == false) {
                        mostrarProcedimiento = true;
                    }

                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemProcedimiento.add(nuevoitem);
                }
                //opcion agregada por CJET         
                if (s.getSpgcaplica().equalsIgnoreCase(MENU_NOTICIAS)) {

                    if (mostrarNoticias == false) {
                        mostrarNoticias = true;
                    }
                    NavigationMenuItem nuevoitem = 
                        new NavigationMenuItem(s.getSpgcdescri(), 
                                               "#{MenuBean.ir" + 
                                               s.getSpgcnombre() + "}");
                    itemNoticias.add(nuevoitem);
                }


            }


            if (mostrarParametros == true)
                menuAdmin.add(itemParametros);
            if (mostrarInformacion == true)
                menuAdmin.add(itemInformacion);
            if (mostraMenuConHistoria == true)
                menuAdmin.add(itemConsultaHistoria);
            if (mostraMenuRegNota == true)
                menuAdmin.add(itemRegistrarNota);
            if (mostraMenuRegHistoria == true)
                menuAdmin.add(itemRegistrarHistoria);
            if (mostrarMenuReimprCon == true)
                menuAdmin.add(itemReImprimirConducta);
            if (mostrarMenuDatosUsuario == true)
                menuAdmin.add(itemModiciarDatos);
            if (mostrarCitologia == true)
                menuAdmin.add(itemCitologiasDatos);
            if (mostrarCirugia == true)
                menuAdmin.add(itemCirugias);
            if (mostrarAdminPlan)
                menuAdmin.add(itemAdminPlan);
            if (mostrarGestion)
                menuAdmin.add(itemGestionPrio);
            if (mostrarVacunacion)
                menuAdmin.add(itemVacunacion);
            if (mostrarReportes)
                menuAdmin.add(itemReportes);
            if (mostrarAsesoria)
                menuAdmin.add(itemAsesoria);
            if (mostrarPamec)
                menuAdmin.add(itemPamec);
            if (mostrarServicios)
                menuAdmin.add(itemServicio);
            if (mostrarReportesClinico) {
                menuAdmin.add(itemClinico);
            }
            if (mostrarConsultaSinFactura) {
                menuAdmin.add(itemConsultaSinFactura);
            }
            if (mostrarMenuRegTelefonico) {
                menuAdmin.add(itemRegistroTelefonico);
            }

            if (mostrarlaboratorio) {
                menuAdmin.add(itemLaboratorio);
            }

            if (mostrarProcedimiento) {
                menuAdmin.add(itemProcedimiento);
            }
            if (mostrarNoticias) {
                menuAdmin.add(itemNoticias);
            }

            NavigationMenuItem inicioItem = 
                new NavigationMenuItem("Inicio", "#{MenuBean.irhome}");
            NavigationMenuItem salirItem = 
                new NavigationMenuItem("Salida Segura", "#{MenuBean.irSalir}");
            menuAdmin.add(inicioItem);
            menuAdmin.add(salirItem);


        } catch (ModelException de) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA + " " + 
                                       de.getMessage());
            de.printStackTrace();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA + " " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * @param mostarMsgExpira
     */
    public void setMostarMsgExpira(boolean mostarMsgExpira) {
        this.mostarMsgExpira = mostarMsgExpira;
    }

    /**
     * @return
     */
    public boolean isMostarMsgExpira() {
        return mostarMsgExpira;
    }

    /**
     * @param msgExpira
     */
    public void setMsgExpira(String msgExpira) {
        this.msgExpira = msgExpira;
    }

    /**
     * @return
     */
    public String getMsgExpira() {
        return msgExpira;
    }

    /**
     * @return
     */
    public String irhome() {
        FacesUtils.resetManagedBean("informacionUsuarioBean");
        return BeanNavegacion.RUTA_HOME;
    }

    /**
     * @return
     */
    public String irSalir() {

        return BeanNavegacion.RUTA_LOGOUT;

    }


    /**
     * @return
     */
    public String irrepConsulAbier() {
        FacesUtils.resetManagedBean("reporteConsultasAbiertasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_CONSULTAS_ABIERTAS;
    }

    /**
     * @return
     */
    public String irrepAnteceGinec() {
        FacesUtils.resetManagedBean("reporteGestacionesBean");
        return BeanNavegacion.RUTA_IR_REPORTE_GESTACIONES;
    }


    /**
     * @return
     */
    public String irrepEducativas() {
        FacesUtils.resetManagedBean("reporteActividadesEducativasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ACTIVIDADES_EDUCATIVAS;
    }


    /**
     * @return
     */
    public String irregVacunaCervix() {

        FacesUtils.resetManagedBean("listaVacunacionBean");
        return BeanNavegacion.RUTA_IR_LISTA_VACUNACION;
    }


    /**
     * @return
     */
    public String irregEspermograEnfer() {
        FacesUtils.resetManagedBean("listaEspermogramaBean");
        return BeanNavegacion.RUTA_IR_LISTA_ESPERMOGRAMA;
    }


    /**
     * @return
     */
    public String irregistrarNotaMedica() {
        FacesUtils.resetManagedBean("consultarUsuarioNotaMedicaBean");
        FacesUtils.resetManagedBean("consultarFoliosNotaBean");
        FacesUtils.resetManagedBean("registrarNotaMedicaBean");
        return BeanNavegacion.RUTA_IR_NOTA_MEDICA;
    }


    /**
     * @return
     */
    public String irregistrarExamenes() {
        FacesUtils.resetManagedBean("consultarUsuarioExamenesClinicosBean");
        FacesUtils.resetManagedBean("consultarFoliosExamenesClinicosBean");
        FacesUtils.resetManagedBean("registrarExamenesClinicosBean");


        return BeanNavegacion.RUTA_IR_CONSULTAR_EXAMENES_LABORATORIO;
    }

    /**
     * @return
     */
    public String irconsultarHistoria() {
        FacesUtils.resetManagedBean("consultarFoliosBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_VER_FOLIOS_USUARIO;
    }


    /**
     * @return
     */
    public String ircopiaCitologia() {
        FacesUtils.resetManagedBean("consultarCopiaCitologiaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_VER_COPIA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String ircopiaTuberculina() {
        FacesUtils.resetManagedBean("consultarCopiaTuberculinaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_COPIA_TUBERCULINA;
    }

    /**
     * @return
     */
    public String ircopiaVph() {
        FacesUtils.resetManagedBean("consultarCopiaVphBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_VER_COPIA_VPH;
    }


    public String irestadoCitologia() {
        FacesUtils.resetManagedBean("consultarEstadoCitologiaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_VER_ESTADO_CITOLOGIA;
    }


    /**
     * @return
     */
    public String irimprimirFolios() {
        FacesUtils.resetManagedBean("consultarFoliosBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_IR_IMPRIMIR_FOLIOS;
    }

    /**
     * @return
     */
    public String irimprimirHistorias() {
        FacesUtils.resetManagedBean("imprimirFoliosConsultasBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_IR_IMPRIMIR_HISTORIAS;
    }

    /**
     * @return
     */
    public String irconsultarAntecedente() {
        FacesUtils.resetManagedBean("consultarUsuarioAntecedenteBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_ANTECEDENTE;
    }

    /**
     * @return
     */
    public String irconsultarResumen() {
        FacesUtils.resetManagedBean("consultarUsuarioResumenBean");
        FacesUtils.resetManagedBean("consultarFoliosBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_RESUMEN;
    }

    /**
     * @return
     */
    public String irconsultasProfesional() {
        FacesUtils.resetManagedBean("listaUsuariosBean");
        FacesUtils.resetManagedBean("buscadorControlesBean");
        FacesUtils.resetManagedBean("controlSinCostoUsuarioBean");
        return BeanNavegacion.RUTA_LISTA_TODOS_LOS_USUARIOS;

    }

    /**
     * @return
     */
    public String irHistoria() {
        FacesUtils.resetManagedBean("listaUsuariosBean");
        return BeanNavegacion.RUTA_LISTA_TODOS_LOS_USUARIOS;
    }


    /**
     * @return
     */
    public String irimprimirConducta() {
        FacesUtils.resetManagedBean("consultarUsuarioBean");
        FacesUtils.resetManagedBean("consultarFoliosDocumentoBean");
        FacesUtils.resetManagedBean("reimprimirDocumentosBean");


        ConsultarUsuarioBean consultarUsuarioBean = 
            (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");


        if (consultarUsuarioBean != null) {
            consultarUsuarioBean.setMenu(IConstantes.MENU_REIMPRIMIR_DOCUMENTOS);
            consultarUsuarioBean.inicializarConsultarUsuario();
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO;
    }

    /**
     * @return
     */
    public String irmodificarDatos() {
        if (consultarUsuario != null) {
            consultarUsuario.setMenu(IConstantes.MENU_MODIFICAR_DATOS_USUARIO);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO;
    }


    /**
     * @return
     */
    public String ircitologia() {
        FacesUtils.resetManagedBean("lecturaCitologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_LECTURA_CITOLOGIA);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String irregLectCitoConv() {
        FacesUtils.resetManagedBean("lecturaCitologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_LECTURA_CITOLOGIA);
        }

        ConsultarFoliosCitologiaBean consultarFoliosCitologiaBean = 
            (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
        if (consultarFoliosCitologiaBean != null) {
            consultarFoliosCitologiaBean.setTipoHistoria(HISTORIA_LECTURA_CITOLOGIA_CONVENCIONAL);
            consultarFoliosCitologiaBean.setTipoMenu(MENU_LECTURA_CITOLOGIA);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }

    public String irmodLectCitoConv() {
        FacesUtils.resetManagedBean("lecturaCitologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_MODIFICAR_CITOLOGIA);
        }

        ConsultarFoliosCitologiaBean consultarFoliosCitologiaBean = 
            (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
        if (consultarFoliosCitologiaBean != null) {
            consultarFoliosCitologiaBean.setTipoHistoria(HISTORIA_LECTURA_CITOLOGIA_CONVENCIONAL);
            consultarFoliosCitologiaBean.setTipoMenu(MENU_MODIFICAR_CITOLOGIA);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }


    /**
     * @return
     */
    public String irregLecturaVph() {
        FacesUtils.resetManagedBean("lecturaVphBean");
        FacesUtils.resetManagedBean("consultarFoliosVphBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_LECTURA_VPH);
        }

        ConsultarFoliosVphBean consultarFoliosVphBean = 
            (ConsultarFoliosVphBean)FacesUtils.getManagedBean("consultarFoliosVphBean");
        if (consultarFoliosVphBean != null) {
            consultarFoliosVphBean.setTipoLectura(MENU_LECTURA_VPH);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }
    
    public String irmodLecturaVph() {
        FacesUtils.resetManagedBean("lecturaVphModBean");
        FacesUtils.resetManagedBean("consultarFoliosVphBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_MODIFICAR_VPH);
        }

        ConsultarFoliosVphBean consultarFoliosVphBean = 
            (ConsultarFoliosVphBean)FacesUtils.getManagedBean("consultarFoliosVphBean");
        if (consultarFoliosVphBean != null) {
            consultarFoliosVphBean.setTipoLectura(MENU_MODIFICAR_VPH);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String irregLectCitoBl() {
        FacesUtils.resetManagedBean("lecturaCitologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_LECTURA_CITOLOGIA);
        }

        ConsultarFoliosCitologiaBean consultarFoliosCitologiaBean = 
            (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
        if (consultarFoliosCitologiaBean != null) {
            consultarFoliosCitologiaBean.setTipoHistoria(HISTORIA_LECTURA_CITOLOGIA_BASE_LIQUIDA);
            consultarFoliosCitologiaBean.setTipoMenu(MENU_LECTURA_CITOLOGIA);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String irregLectVphCito() {
        FacesUtils.resetManagedBean("lecturaVphCitologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosVphBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(MENU_LECTURA_VPH_CITOLOGIA);
        }
        ConsultarFoliosVphBean consultarFoliosVphBean = 
            (ConsultarFoliosVphBean)FacesUtils.getManagedBean("consultarFoliosVphBean");
        if (consultarFoliosVphBean != null) {
            consultarFoliosVphBean.setTipoLectura(MENU_LECTURA_VPH_CITOLOGIA);
        }

        return BeanNavegacion.RUTA_IR_CONSULTAR_LECTURA_CITOLOGIA;
    }


    /**
     * @return
     */
    public String irimprimirCitologia() {
        FacesUtils.resetManagedBean("imprimirCitologiaBean");
        return BeanNavegacion.RUTA_LISTA_IMPRIMIR_CITOLOGIA;
    }


    /**
     * @return
     */
    public String irregistrarCitologia() {
        FacesUtils.resetManagedBean("listaCitologiasBean");
        FacesUtils.resetManagedBean("datosUsuarioCitologiaBean");
        FacesUtils.resetManagedBean("tomaCitologiaBean");
        return BeanNavegacion.RUTA_LISTA_CITOLOGIAS_PROGRAMADAS;
    }

    /**
     * @return
     */
    public String irregistrarTomaVph() {
        FacesUtils.resetManagedBean("listaVphBean");
        FacesUtils.resetManagedBean("datosUsuarioVphBean");
        FacesUtils.resetManagedBean("tomaVphBean");
        return BeanNavegacion.RUTA_LISTA_VPH_PROGRAMADAS;
    }


    /**
     * @return
     */
    public String irregLectCitoVph() {
        FacesUtils.resetManagedBean("lecturaCitologiaVphBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");

        consultarUsuario = 
                (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");

        if (consultarUsuario != null) {
            consultarUsuario.setMenu(IConstantes.MENU_LECTURA_CITOLOGIA_VPH);
        }

        ConsultarFoliosCitologiaBean consultarFoliosCitologiaBean = 
            (ConsultarFoliosCitologiaBean)FacesUtils.getManagedBean("consultarFoliosCitologiaBean");
        if (consultarFoliosCitologiaBean != null) {
            consultarFoliosCitologiaBean.setTipoHistoria(IConstantes.HISTORIA_LECTURA_VPH_BASE_LIQUIDA);
            consultarFoliosCitologiaBean.setTipoMenu(IConstantes.MENU_LECTURA_CITOLOGIA_VPH);
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO;
    }


    /**
     * @return
     */
    public String irentregaCitologia() {
        FacesUtils.resetManagedBean("consultarEntregaCitologiasBean");
        FacesUtils.resetManagedBean("entregaCitologiaBean");
        return BeanNavegacion.RUTA_IR_BUSCAR_CITOLOGIAS;
    }

    /**
     * @return
     */
    public String irentregaVph() {
        FacesUtils.resetManagedBean("consultarEntregaVphsBean");
        FacesUtils.resetManagedBean("entregaVphBean");
        return BeanNavegacion.RUTA_IR_BUSCAR_VPHS;
    }


    /**
     * @return
     */
    public String irregistrosEnfermeria() {
        FacesUtils.resetManagedBean("consultarListaNotasEnfermeria");
        return BeanNavegacion.RUTA_IR_LISTA_NOTAS_ENFERMERIA;
    }


    /**
     * @return
     */
    public String irprogramarCirugia() {
        FacesUtils.resetManagedBean("consultarCirugiasProgramarBean");
        FacesUtils.resetManagedBean("programarCirugiaBean");

        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_PROGRAMACION_CIRUGIA;

    }

    /**
     * @return
     */
    public String irmodificarPrograCiru() {
        FacesUtils.resetManagedBean("modificarCirugiasProgramarBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_MODIFICAR_PROGRAMACION_CIRUGIA;
    }

    /**
     * 
     * @return
     */
    public String irreprogramarCirugia() {
        FacesUtils.resetManagedBean("reprogramarCirugiasProgramarBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_REPROGRAMAR_PROGRAMACION_CIRUGIA;
    }

    public String iradicionarCirugia() {
        FacesUtils.resetManagedBean("adicionarCirugiaBean");
        FacesUtils.resetManagedBean("consultarUsuarioAgregarBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_ADICIONAR_CIRUGIA;
    }

    public String iradministraMedicoSala() {
        FacesUtils.resetManagedBean("administraMedicoSalaBean");
        return BeanNavegacion.RUTA_IR_ADMINISTRAR_MEDICOS_POR_SALA;
    }


    public String irreprogramaCirugia() {
        FacesUtils.resetManagedBean("");
        return BeanNavegacion.RUTA_IR_REPROGRAMACION_CIRUGIA;
    }

    /**
     * @return
     */
    public String iringresoEnfermeria() {
        FacesUtils.resetManagedBean("menuIngresoEnfermeriaBean");
        FacesUtils.resetManagedBean("listaCirugiasProgramadasBean");
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_PROGRAMADAS;
    }


    /**
     * @return
     */
    public String iringresoCheckEnfermeria() {
        // FacesUtils.resetManagedBean("menuIngresoEnfermeriaBean");
        FacesUtils.resetManagedBean("listaCirugiasProgramadasCheckBean");
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_PROGRAMADAS_CHECK;
    }


    /**
     * @return
     */
    public String irdescripQuirurgica() {
        FacesUtils.resetManagedBean("listaCirugiaDescripcionQuirurgicaBean");
        FacesUtils.resetManagedBean("descripcionQuirurgicaBean");

        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_DESCRIPCION_QUIRURGICA;
    }


    /**
     * @return
     */
    public String irregistrosMedicos() {
        FacesUtils.resetManagedBean("listaCirugiasMedicoBean");
        ListaCirugiasMedicoBean listaMedico = 
            (ListaCirugiasMedicoBean)FacesUtils.getManagedBean("listaCirugiasMedicoBean");

        if (listaMedico != null) {
            listaMedico.setEsEvolucion(true);
            listaMedico.setEsIngresoMedico(false);
            listaMedico.setEsRegistroAnestesia(false);
            listaMedico.cargarCirugias();
        }
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS;
    }


    /**
     * @return
     */
    public String iringresoMedico() {
        FacesUtils.resetManagedBean("listaCirugiasMedicoBean");
        ListaCirugiasMedicoBean listaMedico = 
            (ListaCirugiasMedicoBean)FacesUtils.getManagedBean("listaCirugiasMedicoBean");

        if (listaMedico != null) {
            listaMedico.setEsEvolucion(false);
            listaMedico.setEsRegistroAnestesia(false);
            listaMedico.setEsIngresoMedico(true);
            listaMedico.cargarCirugias();
        }
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS;
    }

    /**
     * @return
     */
    public String irregistrarEpicrisis() {
        FacesUtils.resetManagedBean("listaCirugiaEpicrisisBean");
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_EPICRISIS;
    }

    /**
     * @return
     */
    public String irregistrarAnestesia() {
        ListaCirugiasMedicoBean listaMedico = 
            (ListaCirugiasMedicoBean)FacesUtils.getManagedBean("listaCirugiasMedicoBean");

        if (listaMedico != null) {
            listaMedico.setEsRegistroAnestesia(true);
            listaMedico.setEsEvolucion(false);
            listaMedico.setEsIngresoMedico(false);
            listaMedico.cargarCirugias();
        }
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS;
    }


    public String irrepOtrasAseso() {
        FacesUtils.resetManagedBean("reporteOtrasAsesoriasBean");
        ReporteOtrasAsesoriasBean reporteAsesoria = 
            (ReporteOtrasAsesoriasBean)FacesUtils.getManagedBean("reporteOtrasAsesoriasBean");
        if (reporteAsesoria != null) {
            reporteAsesoria.setGeneroReporte(false);
            reporteAsesoria.init();
        }

        return BeanNavegacion.RUTA_IR_REPORTE_OTRAS_ASESORIAS;
    }


    public String irrepOtrasAsesoNal() {
        FacesUtils.resetManagedBean("reporteOtrasAsesoriasNacionalBean");
        ReporteOtrasAsesoriasNacionalBean reporteAsesoria = 
            (ReporteOtrasAsesoriasNacionalBean)FacesUtils.getManagedBean("reporteOtrasAsesoriasNacionalBean");
        if (reporteAsesoria != null) {
            reporteAsesoria.setGeneroReporte(false);
            reporteAsesoria.init();
        }

        return BeanNavegacion.RUTA_IR_REPORTE_OTRAS_ASESORIAS_NAL;
    }


    /**
     * @return
     */
    public String iradminClinica() {
        FacesUtils.resetManagedBean("informacionUsuarioClinicaBean");
        return BeanNavegacion.RUTA_IR_ADMINISTRAR_CLINICA;
    }

    public String irasignarSala() {
        FacesUtils.resetManagedBean("asignarSalaMedicoBean");
        return BeanNavegacion.RUTA_IR_ASIGNAR_SALA_MEDICO;
    }


    /**
     * @return
     */
    public String irsegCitologia() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_CONTROL_ENTREGA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String irsegVph() {
        resetBeansSegVphs();
        return BeanNavegacion.RUTA_IR_CONTROL_ENTREGA_VPH;
    }

    /**
     * @return
     */
    public String irresLecturaUno() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_RESULTADO_LECTURA_UNO;
    }

    /**
     * @return
     */
    public String irregEntregaCitol() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_REPORTE_ENTREGA_CITOL;
    }

    /**
     * @return
     */
    public String irenvioLecturaDos() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_ENVIO_LECTURA_DOS;
    }

    /**
     * @return
     */
    public String iradminPatologos() {
        FacesUtils.resetManagedBean("profesionalLecturaBean");
        return BeanNavegacion.RUTA_IR_ADMIN_PATOLOGOS;
    }

    /**
     * @return
     */
    public String irotrasPatologias() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_OTRAS_PATOLGIAS;
    }


    /**
     * @return
     */
    public String irenvioOtrasPatologias() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_ENV_OTRAS_PATOLGIAS;
    }


    /**
     * @return
     */
    public String iradministrarPlantilla() {
        FacesUtils.resetManagedBean("administrarPlantillaBean");
        return BeanNavegacion.RUTA_IR_ADMINISTRAR_PLANTILLAS;
    }

    /**
     * @return
     */
    public String irrepReferencia() {
        FacesUtils.resetManagedBean("reporteReferenciaBean");
        return BeanNavegacion.RUTA_IR_REPORTE_REFERENCIA;
    }

    /**
     * @return
     */
    public String irgesNoticia() {
        FacesUtils.resetManagedBean("noticiasBean");
        return BeanNavegacion.RUTA_IR_NOTICIAS;
    }


    /**
     * @return
     */
    public String irripsSaludtools() {
        FacesUtils.resetManagedBean("ripsSaludtoolBean");
        return BeanNavegacion.RUTA_IR_RIPS_SALUDTOOLS;
    }


    /**
     * @return
     */
    public String irconsultarProgrCir() {
        FacesUtils.resetManagedBean("consultarProgramacionCirugiaBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_PROGRAMACION;
    }


    /**
     * @return
     */
    public String irreporteProgrCir() {
        FacesUtils.resetManagedBean("reporteProgramacionCirugiaBean");
        return BeanNavegacion.RUTA_IR_REPORTE_PROGRAMACION;
    }


    /**
     * @return
     */
    public String irreporteHonoraCir() {
        FacesUtils.resetManagedBean("reporteHonorariosCirugiaBean");
        return BeanNavegacion.RUTA_IR_REPORTE_HONORARIOS_CIRUGIA;
    }


    /**
     * @return
     */
    public String irgestionPrioridad() {
        return BeanNavegacion.RUTA_IR_GESTION_PRIORIDAD;
    }

    /**
     * @return
     */
    public String irgestionServicios() {
        return BeanNavegacion.RUTA_IR_GESTION_SERVICIOS;
    }

    /**
     * @return
     */
    public String irsegCitoConv() {
        resetBeansSegCitologias();
        RepSegCitologiasBean repSegCitologiasBean = 
            (RepSegCitologiasBean)FacesUtils.getManagedBean("repSegCitologiasBean");
        repSegCitologiasBean.setTipoHistoria(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA);
        repSegCitologiasBean.init();

        return BeanNavegacion.RUTA_IR_CONTROL_ENTREGA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String irsegCitoBL() {
        resetBeansSegCitologias();
        RepSegCitologiasBean repSegCitologiasBean = 
            (RepSegCitologiasBean)FacesUtils.getManagedBean("repSegCitologiasBean");
        repSegCitologiasBean.setTipoHistoria(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA);
        repSegCitologiasBean.init();
        return BeanNavegacion.RUTA_IR_CONTROL_ENTREGA_CITOLOGIA;
    }

    /**
     * @return
     */
    public String irsegCitoVph() {
        resetBeansSegCitologias();
        RepSegCitologiasBean repSegCitologiasBean = 
            (RepSegCitologiasBean)FacesUtils.getManagedBean("repSegCitologiasBean");
        repSegCitologiasBean.setTipoHistoria(IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA);
        repSegCitologiasBean.init();
        return BeanNavegacion.RUTA_IR_CONTROL_ENTREGA_CITOLOGIA;
    }


    /**
     * @return
     */
    public String iradminGenPatologos() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_ADMIN_GEN_PATOLOGOS;
    }

    /**
     * @return
     */
    public String irresultadoPatologia() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_RESULTADO_PATOLOGIAS;
    }

    /**
     * @return
     */
    public String irconfirmarPatologia() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_CONFIRMACION_PATOLOGIAS;
    }

    /**
     * @return
     */
    public String irentregaPatologia() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_ENTREGA_PATOLOGIAS;
    }


    /**
     * @return
     */
    public String irliberarConsulta() {
        FacesUtils.resetManagedBean("liberarConsultaBean");
        return BeanNavegacion.RUTA_IR_LIBERAR_CONSULTAS;
    }

    /**
     * @return
     */
    public String irsolicitarAnulacion() {
        FacesUtils.resetManagedBean("solicitarAnulacionBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_IR_SOLICITAR_ANULACION;
    }


    /**
     * @return
     */
    public String iranularAutorizacion() {
        FacesUtils.resetManagedBean("autorizarAnulacionBean");
        return BeanNavegacion.RUTA_IR_AUTORIZAR_ANULACION;
    }


    /**
     * @return
     */
    public String irdatosEnvio() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_DATOS_ENVIO;
    }

    /**
     * @return
     */
    public String irseguimientoPatologia() {
        resetBeansSegCitologias();
        return BeanNavegacion.RUTA_IR_SEGUIMINETO_PATOLOGIAS;
    }

    public void resetBeansSegCitologias() {
        FacesUtils.resetManagedBean("repEntregaCitologiasBean");
        FacesUtils.resetManagedBean("repCitologiaLecturaDosBean");
        FacesUtils.resetManagedBean("resultadoLecturaUnoBean");
        FacesUtils.resetManagedBean("repSegCitologiasBean");
        FacesUtils.resetManagedBean("otrasPatologiasBean");
        FacesUtils.resetManagedBean("envioOtrasPatologiasBean");
        FacesUtils.resetManagedBean("resultadoPatologiaBean");
        FacesUtils.resetManagedBean("seguimientoPatologiasBean");
        FacesUtils.resetManagedBean("entregaPatologiaBean");
    }

    public void resetBeansSegVphs() {
        //FacesUtils.resetManagedBean("repEntregaCitologiasBean");
        //FacesUtils.resetManagedBean("repCitologiaLecturaDosBean");
        //FacesUtils.resetManagedBean("resultadoLecturaUnoBean");
        FacesUtils.resetManagedBean("repSegVphsBean");
        //FacesUtils.resetManagedBean("otrasPatologiasBean");
        //FacesUtils.resetManagedBean("envioOtrasPatologiasBean");
        //FacesUtils.resetManagedBean("resultadoPatologiaBean");
        //FacesUtils.resetManagedBean("seguimientoPatologiasBean");
        //FacesUtils.resetManagedBean("entregaPatologiaBean");
    }

    /**
     * @return
     */
    public String irconsultarIncompleta() {
        FacesUtils.resetManagedBean("consultarFoliosBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_IR_CONSULTAR_FOLIOS_INCOMPLETOS;

    }


    /**
     * @return
     */
    public String irconsultasEnfermeria() {
        FacesUtils.resetManagedBean("listaUsuariosEnfermeriaBean");
        FacesUtils.resetManagedBean("buscadorControlesBean");
        FacesUtils.resetManagedBean("controlSinCostoUsuarioBean");
        return BeanNavegacion.RUTA_LISTA_TODOS_LOS_USUARIOS_ENFERMERIA;
    }

    /**
     * @return
     */
    public String irrepDatosRips() {
        FacesUtils.resetManagedBean("reporteDatosRipsBean");
        return BeanNavegacion.RUTA_IR_REPORTE_DATOS_RIPS;
    }

    /**
     * @return
     */
    public String irrepOporEntre() {
        FacesUtils.resetManagedBean("reporteOportunidadEntregaBean");
        return BeanNavegacion.RUTA_IR_REPORTE_OPORTUNIDAD_ENTREGA;
    }

    /**
     * @return
     */
    public String irrepPorceManual() {
        FacesUtils.resetManagedBean("reportePorcentajeManualBean");
        return BeanNavegacion.RUTA_IR_REPORTE_PORCENTAJE_MANUALES;
    }

    /**
     * @return
     */
    public String irrepConsAtendida() {
        FacesUtils.resetManagedBean("reporteConsultasAtendidasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_CONSULTAS_ATENDIDAS;
    }


    /**
     * @return
     */
    public String irrepConsulAtendidas() {
        FacesUtils.resetManagedBean("reporteConsultasAtendidasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_PORCENTAJE_MANUALES;
    }


    /**
     * @return
     */
    public String irImprimirEpicrisis() {
        FacesUtils.resetManagedBean("imprimirEpicrisisBean");
        return BeanNavegacion.RUTA_IR_REPORTE_EPICRISIS;
    }


    /**
     * @return
     */
    public String irregAsesoria() {

        String navegation = "";

        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");

        Cpprofesio profes = null;
        Cpusuario usuaux = null;

        try {

            if (userName() != null && getClinica() != null && 
                getClinica().getCclncodigo() != null) {
                usuaux = 
                        this.serviceLocator.getClinicoService().getUsuarioPorId(userName().toUpperCase());

                profes = 
                        this.serviceLocator.getClinicoService().getProfesionalPorUsuario(userName(), 
                                                                                         getClinica().getCclncodigo());
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }


        if (usuaux != null) {
            if (usuaux.getCurnprofes() != null && 
                usuaux.getCurnprofes().equals(0)) {
                navegation = "";
                FacesUtils.addErrorMessage(IMsg.PROFESIONAL_NO_TIENE_CODIGO);
            }
        }


        if (profes != null) {
            navegation = BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIA;
        } else {
            navegation = "";
            FacesUtils.addErrorMessage(IMsg.PROFESIONAL_NO_EXISTE_CLINICA);
        }


        return navegation;
    }

    /**
     * @return
     */
    public String irconAsesoria() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("consultarAsesoriaBean");

        return BeanNavegacion.RUTA_IR_CONSULTAR_ASESORIA_OPCIONES;
    }


    public String irconsultarAsesoria() {
        FacesUtils.resetManagedBean("consultarOtrasAsesoria");
        ConsultarOtrasAsesoria asesor = 
            (ConsultarOtrasAsesoria)FacesUtils.getManagedBean("consultarOtrasAsesoria");
        if (asesor != null) {
            asesor.setGeneroAsesoria(false);
        }

        return BeanNavegacion.RUTA_IR_CONSULTAR_ASESORIA;
    }

    /**
     * @return
     */
    public String irregOtraAsesoria() {
        //Nueva Asesoria
        //   FacesUtils.resetManagedBean("registrarOtraAsesoriaBean");
        //   return BeanNavegacion.RUTA_IR_REGISTRAR_OTRAS_ASESORIAS;

        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean"); //Encabezado
        FacesUtils.resetManagedBean("registroUsuarioNuevaAsesoriaBean");
        FacesUtils.resetManagedBean("mnuNuevaAsesoriaBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_USUARIO_NUEVA_ASESORIA;

    }


    /**
     * @return
     */
    public String irrepSistemaNal() {
        FacesUtils.resetManagedBean("reportePorcentajeManualBean");
        return BeanNavegacion.RUTA_IR_REPORTE_PORCENTAJE_MANUALES_NACIONAL;
    }

    /**
     * @return
     */
    public String irrepConAbiNal() {
        FacesUtils.resetManagedBean("reporteConsultasAbiertasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_CONSULTAS_ABIERTAS_NACIONAL;

    }


    /**
     * @return
     */
    public String irregAsesHuman() {
        FacesUtils.resetManagedBean("registrarOtraAsesoriaBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_ASESORIAS_HUMANITARIA;
    }


    /**
     * @return
     */
    public String irregAsesNueva() {

        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean"); //Encabezado
        FacesUtils.resetManagedBean("registroUsuarioNuevaAsesoriaBean");
        FacesUtils.resetManagedBean("mnuNuevaAsesoriaBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_USUARIO_NUEVA_ASESORIA;
    }


    /**
     * @return
     */
    public String irrepControlCito() {
        FacesUtils.resetManagedBean("reporteControlCitologiasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_CONTRO_CITOLOGIA;
    }

    public String irrepControlCitoNal() {
        FacesUtils.resetManagedBean("reporteControlCitologiasNalBean");
        return BeanNavegacion.RUTA_IR_REPORTE_CONTRO_CITOLOGIA_NACIONAL;
    }


    /**
     * @return
     */
    public String irrepAsesoIlve() {
        FacesUtils.resetManagedBean("reporteAsesoriaIlveBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ASESORIA_ILVE;
    }


    /**
     * @return  
     */
    public String irrepAutorizaServicios() {
        FacesUtils.resetManagedBean("reporteAutorizacionServiciosBean");
        return BeanNavegacion.RUTA_IR_REPORTE_AUTORIZACION_SERVICIOS;
    }

    /**
     * @return
     */
    public String irrepCliAsesIlve() {
        FacesUtils.resetManagedBean("reporteClinicAsesoriaIlveBean");
        return BeanNavegacion.RUTA_IR_REPORTE_CLINIC_ASESORIA_ILVE;
    }

    /**
     * @return
     */
    public String irregPreguntaPamec() {
        FacesUtils.resetManagedBean("registrarTemaBean");
        FacesUtils.resetManagedBean("registrarIndicadorBean");
        FacesUtils.resetManagedBean("registrarPreguntaBean");
        RegistrarTemaBean tema = 
            (RegistrarTemaBean)FacesUtils.getManagedBean("registrarTemaBean");
        tema.init();
        return BeanNavegacion.RUTA_IR_REGISTRAR_TEMA_PAMEC;
    }

    /**
     * @return
     */
    public String irregCuestPamec() {
        FacesUtils.resetManagedBean("cuestionarioTemaBean");
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_TEMA_PAMEC;
    }

    public String ircargarLectura() {
        //        System.out.println("Entro:::::");
        return BeanNavegacion.RUTA_IR_UPLOAD;
    }

    public String irinformacionServicios() {
        System.out.println("Ingreso a irinformacionServicios" + userName());
        FacesUtils.resetManagedBean("informacionServicioBean");

        return BeanNavegacion.RUTA_IR_INFORMACION_SERVICIO;
    }

    /**
     * @return
     */
    public String irrepPamec() {
        System.out.println("Ingreso a irrepPamec" + userName());
        FacesUtils.resetManagedBean("modificarCirugiasProgramarBean");
        return BeanNavegacion.RUTA_IR_REPORTE_PAMEC;
    }


    /**
     * @return
     */
    public String irpermisoPamec() {
        System.out.println("Ingreso a irpermisoPamec" + userName());
        FacesUtils.resetManagedBean("permisoTemaBean");
        return BeanNavegacion.RUTA_IR_PERMISOS_TEMA_PAMEC;
    }


    /**
     * @return
     */
    public String irautAclaracionReg() {
        System.out.println("Ingreso a irautAclaracionReg" + userName());
        FacesUtils.resetManagedBean("autorizarNotaAclaratoriaBean");
        FacesUtils.resetManagedBean("aprobarNotaAclaratoriaBean");
        FacesUtils.resetManagedBean("solicitarNotaAclaratoriaBean");
        return BeanNavegacion.RUTA_IR_AUTORIZACION_NOTA_ACLARATORIA;
    }

    /**
     * @return
     */
    public String irsolAclaracionReg() {
        System.out.println("Ingreso a irsolAclaracionReg" + userName());
        FacesUtils.resetManagedBean("autorizarNotaAclaratoriaBean");
        FacesUtils.resetManagedBean("aprobarNotaAclaratoriaBean");
        FacesUtils.resetManagedBean("solicitarNotaAclaratoriaBean");
        return BeanNavegacion.RUTA_IR_SOLICITUD_NOTA_ACLARATORIA;
    }


    public String irsolAclaracionEpi() {
        System.out.println("Ingreso a irsolAclaracionEpi" + userName());
        FacesUtils.resetManagedBean("solicitarAutorizacionEpicrisisBean");
        return BeanNavegacion.RUTA_IR_SOLICITUD_AUTORIZACION_EPICRISIS;
    }


    public String irregInstrumental() {
        System.out.println("Ingreso a irregInstrumental" + userName());
        FacesUtils.resetManagedBean("listaCirugiaInstrumentadorBean");
        return BeanNavegacion.RUTA_IR_INSTRUMENTADOR;
    }


    /**
     * @return
     */
    public String irconsultarCirugia() {
        System.out.println("Ingreso a irconsultarCirugia" + userName());
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
        FacesUtils.resetManagedBean("consultarUsuariosFoliosCirugiaBean");

        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_FOLIOS_CIRUGIA;
    }


    /**
     * @return
     */
    public String irimprimirFoliosCirugia() {
        System.out.println("Ingreso a irconsultarCirugia" + userName());
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("datosBasicosUsuarioBean");
        FacesUtils.resetManagedBean("generarFoliosCirugiaBean");
        FacesUtils.resetManagedBean("consultarUsuariosFoliosCirugiaBean");

        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO_FOLIOS_CIRUGIA;
    }


    /**
     * @return
     */
    public String irconCancelCiru() {
        System.out.println("Ingreso a irconCancelCiru" + userName());
        FacesUtils.resetManagedBean("consultarCancelacionCirugiaBean");
        return BeanNavegacion.RUTA_IR_CONS_CANCELACION_CIRUGIA;
    }

    /**
     * @return
     */
    public String irregPaqInstrumental() {
        System.out.println("Ingreso a irregPaqInstrumental" + userName());
        FacesUtils.resetManagedBean("registrarPaqueteInstrumentalBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_PAQUETE_INSTRUMENTAL;
    }

    /**
     * @return
     */
    public String irregMatInstrumental() {
        System.out.println("Ingreso a irregMatInstrumental" + userName());
        FacesUtils.resetManagedBean("registrarMaterialInstrumentalBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_MATERIAL_INSTRUMENTAL;
    }

    public String irregSeguimientoTel() {
        System.out.println("Ingreso a irregSeguimientoTel" + userName());
        FacesUtils.resetManagedBean("consultarUsuarioSeguimientoTelefonicoBean");
        FacesUtils.resetManagedBean("consultarFoliosSeguimientoTelefonicoBean");
        FacesUtils.resetManagedBean("registrarSeguimientoTelefonicoBean");


        return BeanNavegacion.RUTA_IR_CONSULTA_USUARIO_SEGUIMIENTO_TELEFONICO;
    }

    public String irregCirugiaSinFac() {
        System.out.println("Ingreso a irregCirugiaSinFac" + userName());
        FacesUtils.resetManagedBean("consultarUsuarioCirugiaSinFacturaBean");
        return BeanNavegacion.RUTA_IR_CONSULTA_USUARIO_CIRUGIA_SIN_FACTURA;
    }

    /**
     * @return
     */
    public String irregParVerQuirofano() {
        System.out.println("Ingreso a irregParVerQuirofano" + userName());
        FacesUtils.resetManagedBean("registrarParametroVerificacionQuirofanoBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_PARAMETRO_VERIFICACION_QUIROFANO;
    }

    /**
     * @return
     */
    public String irregSalaCirugia() {
        System.out.println("Ingreso a irregSalaCirugia" + userName());
        FacesUtils.resetManagedBean("registrarSalaCirugiaBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_SALA_CIRUGIA;
    }

    /**
     * @return
     */
    public String irregVerQuiEnfermera() {
        System.out.println("Ingreso a irregVerQuiEnfermera" + userName());
        FacesUtils.resetManagedBean("listaVerificacionQuirofanoEnfermeraBean");
        return BeanNavegacion.RUTA_IR_LISTA_VERIFICACION_QUIROFANO_ENFERMERA;
    }

    public String irregEducativa() {
        System.out.println("Ingreso a irregEducativa" + userName());
        FacesUtils.resetManagedBean("registrarActividadEducativaBean");
        return BeanNavegacion.RUTA_IR_ACTIVIDAD_EDUCTAIVA;
    }


    public String irrepIlve() {
        System.out.println("Ingreso a irrepIlve" + userName());
        FacesUtils.resetManagedBean("reporteIlveBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ILVE;
    }


    public String irrepIlveNacional() {
        System.out.println("Ingreso a irrepIlveNacional" + userName());
        FacesUtils.resetManagedBean("reporteIlveNacionalBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ILVE_NACIONAL;
    }

    public String irrepResolucion256() {
        System.out.println("Ingreso a irrepResolucion256" + userName());
        FacesUtils.resetManagedBean("reporteResolucion256Bean");
        return BeanNavegacion.RUTA_IR_REPORTE_RESOLUCION_256;
    }

    /**
     * @return
     */
    public String irregVerQuiMedico() {
        System.out.println("Ingreso a irregVerQuiMedico" + userName());
        FacesUtils.resetManagedBean("listaVerificacionQuirofanoMedicoBean");
        return BeanNavegacion.RUTA_IR_LISTA_VERIFICACION_QUIROFANO_MEDICO;
    }

    public String ircnfCirugiaSinFac() {
        System.out.println("Ingreso a ircnfCirugiaSinFac" + userName());
        FacesUtils.resetManagedBean("listaCirugiaSinFacturaBean");
        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIA_SIN_FACTURA;
    }

    public String irasgTipoServicio() {
        System.out.println("Ingreso a irasgTipoServicio" + userName());
        FacesUtils.resetManagedBean("registrarTipoServicioBean");
        return BeanNavegacion.RUTA_IR_REGISTRAR_TIPO_SERVICIO;
    }


    public String irregVademecum() {

        System.out.println("Ingreso a irregVademecum" + userName());
        return BeanNavegacion.RUTA_IR_REGISTRAR_VADEMECUM;
    }


    /**
     * @return
     */
    public String irregMedicamento() {
        System.out.println("Ingreso a irregMedicamento" + userName());
        FacesUtils.resetManagedBean("listaMedicamentosBean");
        return BeanNavegacion.RUTA_IR_LISTA_MEDICAMENTO;
    }


    /**
     * @return
     */
    public String irrepMiAsesoIlve() {
        System.out.println("Ingreso a irrepMiAsesoIlve" + userName());
        //FacesUtils.resetManagedBean("reporteMisAsesoriasIlveBean");
        return BeanNavegacion.RUTA_IR_REPORTE_MIS_ASESORIAS_ILVE;
    }

    public String irrepFacturaRadicada() {
        System.out.println("Ingreso a irrepFacturaRadicada" + userName());
        FacesUtils.resetManagedBean("reporteRadicacionFacturasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_RADICACION_FACTURAS;
    }


    public String irrepServiciosSinFactura() {
        System.out.println("Ingreso a irrepServiciosSinFactura" + userName());
        FacesUtils.resetManagedBean("reporteRadicacionFacturasBean");
        return BeanNavegacion.RUTA_IR_REPORTE_SERVICIOS_SIN_FACTURA;
    }

    public String irrepServiciosIPPF() {
        System.out.println("Ingreso a irrepServiciosIPPF" + userName());
        FacesUtils.resetManagedBean("reporteServiciosIPPFBean");
        return BeanNavegacion.RUTA_IR_REPORTE_SERVICIOS_IPPF;
    }

    public String irrepUsuariosIPPF() {
        System.out.println("Ingreso a irrepUsuariosIPPF" + userName());
        FacesUtils.resetManagedBean("reporteUsuariosIPPFBean");
        return BeanNavegacion.RUTA_IR_REPORTE_USUARIOS_IPPF;
    }


    public String irrepFacturaContrato() {
        System.out.println("Ingreso a irrepFacturaContrato" + userName());
        FacesUtils.resetManagedBean("reporteFacturacionContratoBean");
        return BeanNavegacion.RUTA_IR_REPORTE_FACTURACION_CONTRATO;
    }

    public String irrepInfoAborto1() {
        System.out.println("Ingreso a irrepInfoAborto1" + userName());
        FacesUtils.resetManagedBean("reporteInformacionAborto1Bean");
        return BeanNavegacion.RUTA_IR_REPORTE_INFORMACION_ABORTO_1;
    }

    public String irrepInfoAborto2() {
        System.out.println("Ingreso a irrepInfoAborto2" + userName());
        FacesUtils.resetManagedBean("reporteInformacionAborto2Bean");
        return BeanNavegacion.RUTA_IR_REPORTE_INFROMACION_ABORTO_2;
    }

    public String irrepDiagSrvHabilitado() {
        System.out.println("Ingreso a irrepDiagSrvHabilitado" + userName());
        FacesUtils.resetManagedBean("reporteDiagnosticoServicioHabilitadoBean");
        return BeanNavegacion.RUTA_IR_REPORTE_DIAG_SERVICIO_HABILITADO;
    }
    
    public String irrepGestionClinl() {
        System.out.println("Ingreso a irrepGestionClinl" + userName());
        FacesUtils.resetManagedBean("reporteVariosBean");
        return BeanNavegacion.RUTA_IR_REPORTE_VARIOS;
    }    

    public String irrepMedVacuna() {
        System.out.println("Ingreso a irrepMedVacuna" + userName());
        FacesUtils.resetManagedBean("reporteMedicamentoVacunaBean");
        return BeanNavegacion.RUTA_IR_REPORTE_MEDICAMENTO_VACUNA;
    }

    public String irconsultaSinFactura() {
        System.out.println("Ingreso a irconsultaSinFactura" + userName());
        FacesUtils.resetManagedBean("consultarUsuarioConsultaSinFacturaBean");
        return BeanNavegacion.RUTA_IR_CONSULTA_SIN_FACTURA;
    }


    public String irConfirmarSinFactura() {
        System.out.println("Ingreso a irConfirmarSinFactura" + userName());
        // FacesUtils.resetManagedBean("consultaSinFacturaBean");
        return BeanNavegacion.RUTA_IR_LISTA_CONSULTA_SIN_FACTURA;
    }

    public String irrepEnvioEmail() {
        System.out.println("Ingreso a irrepEnvioEmail" + userName());
        FacesUtils.resetManagedBean("reporteEnvioEmailBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ENVIO_EMAIL;
    }


    /**
     * @return
     */
    public String irregEvolucionConsulta() {
        System.out.println("Ingreso a irregEvolucionConsulta" + userName());
        FacesUtils.resetManagedBean("consultarUsuarioEvolucionBean");
        FacesUtils.resetManagedBean("consultarFoliosSeguimientoBean");
        FacesUtils.resetManagedBean("registrarEvolucionConsultaBean");
        return BeanNavegacion.RUTA_IR_EVOLUCION_CONSULTA_MEDICA;
    }


    /**
     * @return
     */
    public String irregistroComplementario() {
        System.out.println("Ingreso a irregistroComplementario" + userName());
        FacesUtils.resetManagedBean("registrarUsuarioComplementarioBean");
        return BeanNavegacion.RUTA_IR_REGISTRO_USUARIO_COMPLEMENTARIO;
    }

    /**
     * @return
     */
    public String irregistroTelefonico() {
        System.out.println("Ingreso a irregistroTelefonico" + userName());
        FacesUtils.resetManagedBean("registrarUsuarioTelefonicoBean");
        return BeanNavegacion.RUTA_IR_REGISTRO_USUARIO_TELEFONICO;
    }

    /**
     * @return
     */
    public NavigationMenuItem[] getNavItems() {
        return navItems;
    }

    /**
     * @param navItems
     */
    public void setNavItems(NavigationMenuItem[] navItems) {
        this.navItems = navItems;
    }


    /**
     * @param nombUsuario
     */
    public void setNombUsuario(String nombUsuario) {
        this.nombUsuario = nombUsuario;
    }

    /**
     * @return
     */
    public String getNombUsuario() {
        return nombUsuario;
    }

    /**
     * @param clinUsuario
     */
    public void setClinUsuario(String clinUsuario) {
        this.clinUsuario = clinUsuario;
    }

    /**
     * @return
     */
    public String getClinUsuario() {
        return clinUsuario;
    }

    /**
     * @param menuAdmin
     */
    public void setMenuAdmin(List menuAdmin) {
        this.menuAdmin = menuAdmin;
    }

    /**
     * @return
     */
    public List getMenuAdmin() {
        return menuAdmin;
    }


    /**
     * @param direccionIP
     */
    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    /**
     * @return
     */
    public String get_direccionIP() {
        return direccionIP;
    }

    public String irgestionLaboratorio() {
        System.out.println("Ingreso a irgestionLaboratorio" + userName());
        FacesUtils.resetManagedBean("gestionLaboratorioBean");
        return BeanNavegacion.RUTA_IR_GESTION_LABORATORIO;
    }

    /**
     * @return
     */
    public String irnotasEnfermeria() {
        System.out.println("Ingreso a irnotasEnfermeria" + userName());
        FacesUtils.resetManagedBean("listaUsuarioNotaEnfermeriaBean");
        return BeanNavegacion.RUTA_IR_LISTA_USUARIO_NOTA_ENFERMERIA;
    }

    /**
     * @return
     */
    public String irrepViniso() {
        System.out.println("Ingreso a irrepViniso" + userName());
        FacesUtils.resetManagedBean("reporteVinisoBean");
        ReporteVinisoBean reporte = 
            (ReporteVinisoBean)FacesUtils.getManagedBean("reporteVinisoBean");
        reporte.setDisableClinicas(true);
        return BeanNavegacion.RUTA_IR_REPORTE_VINISO;
    }

    /**
     * @return
     */
    public String irrepVinisoNal() {
        System.out.println("Ingreso a irrepVinisoNal" + userName());
        FacesUtils.resetManagedBean("reporteVinisoBean");
        ReporteVinisoBean reporte = 
            (ReporteVinisoBean)FacesUtils.getManagedBean("reporteVinisoBean");
        reporte.setDisableClinicas(false);
        return BeanNavegacion.RUTA_IR_REPORTE_VINISO;
    }

    public String irconsultasLaboratorio() {
        FacesUtils.resetManagedBean("listaUsuariosLaboratorioBean");
        FacesUtils.resetManagedBean("registrarLaboratorioBean");
        return BeanNavegacion.RUTA_LISTA_TODOS_LOS_LABORATORIO;
    }

    public String irgenerarCertAsisAdm() {
        System.out.println("Ingreso a irgenerarCertAsisAdm" + userName());
        FacesUtils.resetManagedBean("CertAsistenciaAdminBean");
        return BeanNavegacion.RUTA_IR_CERTIFICADO_ASISTENCIA_ADMIN;
    }

    /**
     * @return
     */
    public String irconsultarEtiquetaVph() {
        FacesUtils.resetManagedBean("consultaEtiquetaVphBean");
        return BeanNavegacion.RUTA_IR_CONSULTA_ETQUETA_VPH;
    }

    /**
     * @return
     */
    public String irtomaTuberculina() {
        FacesUtils.resetManagedBean("antecedentesUsuarioBean");
        FacesUtils.resetManagedBean("AntecedentesGeneralesTuberculinaBean");
        FacesUtils.resetManagedBean("AntecedentesPatologicosTuberculinaBean");
        FacesUtils.resetManagedBean("antecedentesFarmacologicosTuberculinaBean");
        FacesUtils.resetManagedBean("CierreTuberculinaBean");
        return BeanNavegacion.RUTA_IR_TOMA_TUBERCULINA;
    }

    /**
     * @return
     */
    public String irlecturaTuberculina() {
        FacesUtils.resetManagedBean("consultarUsuarioBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        FacesUtils.resetManagedBean("CierreTuberculinaBean");
        System.out.println("Ingreso a irLecturaTuberculina" + userName());

        return BeanNavegacion.RUTA_IR_LECTURA_TUBERCULINA;
    }

    /**
     * @return
     */
    public String irDatosLecturaTuberculina() {
        FacesUtils.resetManagedBean("consultarUsuarioBean");
        FacesUtils.resetManagedBean("consultarFoliosCitologiaBean");
        return BeanNavegacion.RUTA_IR_MODIFICAR_DATOS_USUARIO_TUBERCULINA;
    }

    /**
     * @return
     */
    public String irFormatoLecturaTuberculina() {
        FacesUtils.resetManagedBean("ConsultarFoliosBean");
        FacesUtils.resetManagedBean("consultarUsuarioBean");
        return BeanNavegacion.RUTA_IR_LECTURA_TUBERCULINA_DILIGENCIAR;
    }

    /**
     * @return
     */
    public String irnotaCompleEnfermeria() {
        System.out.println("Ingreso a irnotaCompleEnfermeria" + userName());
        FacesUtils.resetManagedBean("consultarUsuarioNotaComplementariaEnfermeriaBean");
        return BeanNavegacion.RUTA_IR_NOTA_COMPLEMENTARIA_ENFEMERIA;
    }

    /**
     * @return
     */
    public String irautInformePsicologico() {
        FacesUtils.resetManagedBean("autorizarInformePsicologicoBean");
        FacesUtils.resetManagedBean("aprobarInformePsicologicoBean");
        FacesUtils.resetManagedBean("solicitarInformePsicologicoBean");
        return BeanNavegacion.RUTA_IR_AUTORIZACION_INFORME_PSICOLOGICO;
    }

    /**
     * @return
     */
    public String irsolInformePsicologico() {
        FacesUtils.resetManagedBean("autorizarInformePsicologicoBean");
        FacesUtils.resetManagedBean("aprobarInformePsicologicoBean");
        FacesUtils.resetManagedBean("solicitarInformePsicologicoBean");
        return BeanNavegacion.RUTA_IR_SOLICITUD_INFORME_PSICOLOGICO;
    }

    /**
     * @return
     */
    public String irregistrarInfoPsicologico() {
        FacesUtils.resetManagedBean("registrarInformePsicologicoBean");
        FacesUtils.resetManagedBean("consultarUsuarioInformePsicologicoBean");
        FacesUtils.resetManagedBean("consultarFoliosInformePsicologicoBean");
        return BeanNavegacion.RUTA_IR_INFORME_PSICOLOGICO;
    }

    /**
     * @return
     */
    public String irrepRegComplEnfer() {
        FacesUtils.resetManagedBean("reporteComplEnfermBean");
        return BeanNavegacion.RUTA_IR_REPORTE_REGISTRO_COMPL_ENFERMERIA;
    }

    /**
     * @return
     */
    public
    /*  public String irdescripQuirurgicaHisteroscopia() {
        FacesUtils.resetManagedBean("listaCirugiaDescripcionQuirurgicaHisteroscopiaBean");
        FacesUtils.resetManagedBean("descripcionQuirurgicaHisteroscopiaBean");

        return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_DESCRIPCION_QUIRURGICA_HISTEROSCOPIA;
   */
    String irrepLogImpresion() {
        FacesUtils.resetManagedBean("reporteLogImpresionBean");
        ReporteLogImpresionBean reporte = 
            (ReporteLogImpresionBean)FacesUtils.getManagedBean("reporteLogImpresionBean");
        return BeanNavegacion.RUTA_IR_REPORTE_LOG_IMPRESION;
    }
    
    /**
     * @return
     */
    public String irconsultasPruebasRapidas() {
        FacesUtils.resetManagedBean("listaUsuariosPruebasRapidasBean");
        FacesUtils.resetManagedBean("pruebasRapidasBean");
        return BeanNavegacion.RUTA_LISTA_PRUEBAS_RAPIDAS;
    }
    
    
    
    /**
     * @return
     */
    public String irprimerosAuxPsicologia() {
        FacesUtils.resetManagedBean("consultarUsuarioPAPsicologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosPAPsicologiaBean");
        return BeanNavegacion.RUTA_IR_PRIMEROSAUX_PSICOLOGIA;
    }
    
    
    /**
     * @return
     */
    public String ircopiaPAPsicologia() {
        FacesUtils.resetManagedBean("consultarCopiaPAPsicologiaBean");
        FacesUtils.resetManagedBean("consultarFoliosPAPsicologiaBean");
        return BeanNavegacion.RUTA_IMPRIMIR_PAPSICOLOGIA;
    }
    
    /**
     * @return
     */
    public String irregcovidAnticuerpos() {
        FacesUtils.resetManagedBean("pruebasAnticuerposCovidBean");
        FacesUtils.resetManagedBean("menuAnticuerposCovidBean");
        
        return BeanNavegacion.RUTA_USUARIOS_COVD_ANTICUERPOS;

    }
    
    /**
     * @return
     */
    public String irUsuarioCovidAnticuerpos() {
        return BeanNavegacion.RUTA_DATOS_USUARIO_COVID_ANTICUERPOS;

    }
    
    /**
     * @return
     */
    public String irregcovidAntigenos() {
        FacesUtils.resetManagedBean("pruebasAntigenosCovidBean");
        FacesUtils.resetManagedBean("menuAntigenosCovidBean");
        return BeanNavegacion.RUTA_USUARIOS_COVD_ANTIGENOS;

    }
    
    /**
     * @return
     */
    public String irrepAnticuerpoCovid() {
        FacesUtils.resetManagedBean("repCovidAnticureposBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ANTICUERPOS_COVID;
    }
    
    /**
     * @return
     */
    public String irrepAntigenoCovid() {
        FacesUtils.resetManagedBean("repCovidAntigenosBean");
        return BeanNavegacion.RUTA_IR_REPORTE_ANTIGENOS_COVID;
    }
    
    /**
     * @return
     */
    public String irrepVph() {
        FacesUtils.resetManagedBean("reporteVphBean");
        ReporteVphBean reporte = 
            (ReporteVphBean)FacesUtils.getManagedBean("reporteVphBean");
        return BeanNavegacion.RUTA_IR_REPORTE_VPH;
    }
    /**
       * @return
       */
      public String irimpPruebasRapidas() {
          FacesUtils.resetManagedBean("consultarPruebasRapidasBean");
          FacesUtils.resetManagedBean("buscadorUsuariosBean");
          return BeanNavegacion.RUTA_IR_IMPRESION_PRUEBAS_RAPIDAS;
      }
    /**
       * @return
       */
      public String irrepPruebasRapidas() {
          FacesUtils.resetManagedBean("reportePruebasRapidas");
          return BeanNavegacion.RUTA_IR_REPORTE_PRUEBAS_RAPIDAS;
      }
      
    /**
       * @return
       */
      public String irgecamrepsaltot() {
          FacesUtils.resetManagedBean("reporteCancerCervixBean");
          return BeanNavegacion.RUTA_IR_REPORTE_CANCER_CERVIX;
      }
      
    /**
       * @return
       */
      public String irgeparamcorreos() {
          FacesUtils.resetManagedBean("parametrizacionCorreosBean");
          return BeanNavegacion.RUTA_IR_PARAMETRIZACION_CORREOS;
      }
      
    
    /**
       * @return
       */
      public String irfragmentacionEsperma() {
        FacesUtils.resetManagedBean("listaFragmentacionEspermaBean");
          return BeanNavegacion.RUTA_IR_FRAGMENTACION_ESPERMA;
      }
    /**
       * @return
       */
      public String irimpPruebasCovid() {
          FacesUtils.resetManagedBean("consultarPruebasCovidBean");
          return BeanNavegacion.RUTA_IR_IMPRESION_PRUEBAS_COVID;
      }
      
    /**
     * @return
     */
    public String ircopiaTestFragmentacionE() {
        FacesUtils.resetManagedBean("consultarCopiaTestFragEspermaBean");
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        return BeanNavegacion.RUTA_COPIA_TEST_FRAGMENTACION_ESPERMA;
    }
    
    /**
     * @return
     */
    public String irconsentimientoInfo() {
        FacesUtils.resetManagedBean("consentimientoInformadoBean");
        return BeanNavegacion.RUTA_IR_CONSENTIMIENTO_INFORMADO;
    }
    
    /**
     * @return
     */
    public String irrepWSSaludTotal() {
        FacesUtils.resetManagedBean("reprocesoWSSaludTotalBean");
        return BeanNavegacion.RUTA_IR_REP_WS_SALUD_TOTAL;
    }
    
    /**
     * @return
     */
    public String irinterConsuApoTer() {
        FacesUtils.resetManagedBean("consultarUsuarioBean");
        FacesUtils.resetManagedBean("consultarFoliosDocumentoBean");
        FacesUtils.resetManagedBean("reimprimirDocumentosBean");


        ConsultarUsuarioBean consultarUsuarioBean = 
            (ConsultarUsuarioBean)FacesUtils.getManagedBean("consultarUsuarioBean");


        if (consultarUsuarioBean != null) {
            consultarUsuarioBean.setMenu(IConstantes.MENU_REIMPRIMIR_DOCUMENTOS);
            consultarUsuarioBean.inicializarConsultarUsuario();
        }
        return BeanNavegacion.RUTA_IR_CONSULTAR_USUARIO;
    }
    

}