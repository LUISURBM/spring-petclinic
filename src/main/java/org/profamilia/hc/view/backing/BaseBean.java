package org.profamilia.hc.view.backing;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.myfaces.custom.datascroller.ScrollerActionEvent;
import org.apache.myfaces.custom.tabbedpane.HtmlPanelTabbedPane;
import org.profamilia.hc.model.dto.Chcirdetdesc;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.ComponentesDto;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.StringTokenizerStrict;

import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.userdetails.User;


/**
 * @author Jose Andres Riano
 * */
public class BaseBean implements IConstantes {

    protected ServiceLocator serviceLocator;
    
    private Integer codclin; 
    
    public BaseBean() {
        Locale local = new Locale(LANGUAGE, COUNTRY, VARIANT);
        Locale.setDefault(local);
        System.setProperty("user.country", local.getCountry());
        System.setProperty("user.language", local.getLanguage());
        System.setProperty("user.variant", local.getVariant());
        System.setProperty("user.timezone", TIME_ZONE);

    }

    /**
     * @return
     */
    public ServiceLocator getServiceLocator() {
        return this.serviceLocator;
    }

    /**
     * @param newServiceLocator
     */
    public void setServiceLocator(ServiceLocator newServiceLocator) {
        this.serviceLocator = newServiceLocator;
        this.init();
    }

    /**
     * @param codclin
     */
    public void setCodclin(Integer codclin) {
        this.codclin = codclin;
    }

    /**
     * @return
     */
    public Integer getCodclin() {
        return codclin;
    }


    /**
     * Used to initialize the managed bean.
     * <p>
     * Called after the service locator is set.
     * It is a workaround.
     * <p>
     * Once the JSF bean management facility can support init method,
     * the init method can be configured and called from the JSF implementation directly.
     */
    protected void init() {
    }


    /**
     * Selecciona un panel tab a mostrar.
     * @param location, nombre del panel Tab
     * @param selectedIndex, indice del panel tab a mostrar
     */
    public void changeTab(String location, int selectedIndex) {
        UIViewRoot viewId = FacesContext.getCurrentInstance().getViewRoot();
        HtmlPanelTabbedPane htmlPanelTabbedPane = 
            (HtmlPanelTabbedPane)viewId.findComponent(location);
        htmlPanelTabbedPane.setSelectedIndex(selectedIndex);
    }


    //Paginacion en DataTable

    /**
     * @param event
     */
    public void scrollerAction(javax.faces.event.ActionEvent event) {
        ScrollerActionEvent scrollerEvent = (ScrollerActionEvent)event;
        FacesContext.getCurrentInstance().getExternalContext().log("scrollerAction: facet: " + 
                                                                   scrollerEvent.getScrollerfacet() + 
                                                                   ", pageindex: " + 
                                                                   scrollerEvent.getPageIndex());
    }


    /**
     * @return
     */
    public String obtenerFechaActual() {
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        return DateFormat.format(today).toString();
    }

    /**
     * @param listTiempo
     * @param cantidad
     * @param inicio
     */
    public void fillListaTiempo(List<SelectItem> listTiempo, int cantidad, 
                                int inicio) {
        for (int i = inicio; i < cantidad; i++) {
            if (i >= 10)
                listTiempo.add(new SelectItem("" + i, "" + i));
            else
                listTiempo.add(new SelectItem("" + i, "0" + i));
        }
    }

    /**
     * @param listTiempo
     * @param cantidad
     * @param inicio
     */
    public void fillListaTiempoCero(List<SelectItem> listTiempo, int cantidad, 
                                    int inicio) {
        for (int i = inicio; i < cantidad; i++) {
            if (i >= 10)
                listTiempo.add(new SelectItem("" + i, "" + i));
            else
                listTiempo.add(new SelectItem("0" + i, "0" + i));
        }
    }

    /**
     * Verifica si el componente tiene alg�n valor. Se toma como constante vac�a
     * a la cadena vac�a ""
     * 
     * @param 
     *            Componente que se va a validar
     * @return True si el componente tuene alg�n valor o false en caso contrario
     */
    public Cpusuario getUsuarioSystem() {

        SecurityContext sc = 
            (SecurityContext)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute(null/*HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY*/);
        String userName1;
        userName1 = "";
        try {
            if (sc != null && sc.getAuthentication().getPrincipal() != null) {
                User usuario1 = ((User)sc.getAuthentication().getPrincipal());
                userName1 = usuario1.getUsername();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cpusuario cpusuario = null;

        try {
            cpusuario = 
                    serviceLocator.getClinicoService().getUsuarioPorId(userName1.toUpperCase());

        } catch (ModelException de) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA);

        } catch (Exception e) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA);
        }


        return cpusuario;
    }

    /**
     * @return
     */
    public Cpclinica getClinica() {
        Cpclinica clinica = null;
        Integer idClinica = null; 
        
        SecurityContext sc = 
            (SecurityContext)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute(null/*HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY*/);
        String userName2;
        userName2 = "";
        try {
            if (sc != null && sc.getAuthentication().getPrincipal() != null) {
                User usuario2 = ((User)sc.getAuthentication().getPrincipal());
                userName2 = usuario2.getUsername();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(userName2!= null){
            try {
                idClinica = serviceLocator.getClinicoService().getClinicaActiva(userName2.toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if(idClinica == null){
            idClinica = getUsuarioSystem().getCurnclinic(); 
        }
        
            
        try {
            clinica = serviceLocator.getClinicoService().getClinica(idClinica);    
            
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA);

        } catch (Exception e) {
            FacesUtils.addErrorMessage(MSG_NO_CONSULTA);
        }
        return clinica;
    }

    /**
     * @return
     */
    public String getDireccionIP() {
    
     
        String dirip = "";
        LoginBacking login = 
            (LoginBacking)FacesUtils.getManagedBean("loginBacking");
        if (login != null) {
            dirip = login.getDireccionIP();
        }

        return dirip;

    }


    /**
     * 
     * @param pwservic
     * @return
     */
    public String cfcocups(final String pwservic) {
        String servicio = null;
        if (pwservic != null && pwservic.length() > 0) {
            StringTokenizer st = new StringTokenizer(pwservic, ".");

            servicio = st.nextToken();
        }
        return servicio;

    }


    /**
     * @param fechaNacimiento
     * @param fechaActual
     * @return
     */
    public static int calcularEdad(Date fechaNacimiento, Date fechaActual) {


        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int age = 0;
        int factor = 0;
        Date birthDate = fechaNacimiento;
        Date currentDate = fechaActual;  //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) {
                    factor = -1; //Aun no celebra su cumpleanos
                }
            } else {
                factor = -1; //Aun no celebra su cumpleanos
            }
        }
        age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
        return age;
    }
    
    
    /**
     * @param fechaUltimaRegla
     * @return
     */
    public static Integer calcularSemana(Date fechaUltimaRegla) {
        Date fechaHoy = new Date();
        Integer semanaEmbarazo = 0;

        if (fechaUltimaRegla != null && fechaHoy != null) {
            double time = 0;
            int numero = 0;
            time = fechaHoy.getTime() - fechaUltimaRegla.getTime();
            numero = (int)java.lang.Math.ceil((time / (3600 * 24 * 1000)));
            semanaEmbarazo = numero / 7;

        }
        return semanaEmbarazo;

    }


    /**
     * @param campos
     * @return
     */
    public static Vector<String> validarCampos(List<ComponentesDto> campos) {
        Vector<String> msgs = new Vector<String>();
        Iterator i = campos.iterator();
        while (i.hasNext()) {
            ComponentesDto campo = (ComponentesDto)i.next();
            if (campo.getRequerido().equals(ComponentesDto.REQUERIDO)) {
                if (campo.getValor() == null || 
                    campo.getValor().equalsIgnoreCase("")) {
                    msgs.add(MSG_VALIDACION_REQUERIDO);
                    FacesUtils.addErrorMessage(campo.getId(), 
                                               MSG_VALIDACION_REQUERIDO);
                    continue;
                }


            }
            if (campo.getValor() != null && 
                !(campo.getValor().equalsIgnoreCase(""))) {

                if (campo.getTipo().equalsIgnoreCase(ComponentesDto.TIPO_LONG)) {
                    try {
                        new Long(campo.getValor());
                    } catch (NumberFormatException e) {
                        msgs.add(MSG_VALIDACION_NUMERICO);
                        FacesUtils.addErrorMessage(campo.getId(), 
                                                   MSG_VALIDACION_NUMERICO);
                    }
                }

                if (campo.getTipo().equalsIgnoreCase(ComponentesDto.TIPO_DOUBLE)) {
                    try {
                        new Double(campo.getValor());
                    } catch (NumberFormatException e) {
                        msgs.add(MSG_VALIDACION_NUMERICO);
                        FacesUtils.addErrorMessage(campo.getId(), 
                                                   MSG_VALIDACION_NUMERICO);
                    }
                }

                if (campo.getTipo().equalsIgnoreCase(ComponentesDto.TIPO_DATE)) {
                    if (campo.getValor().length() > 10) {
                        msgs.add(MSG_VALIDACION_FECHA);
                        FacesUtils.addErrorMessage(campo.getId(), 
                                                   MSG_VALIDACION_FECHA);
                    } else {
                        SimpleDateFormat formatoFecha = 
                            new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = null;
                        try {
                            fecha = formatoFecha.parse(campo.getValor());
                        } catch (Exception ex) {
                            msgs.add(MSG_VALIDACION_FECHA);
                            FacesUtils.addErrorMessage(campo.getId(), 
                                                       MSG_VALIDACION_FECHA);
                        }
                    }


                }

                if (campo.getTipo().equalsIgnoreCase(ComponentesDto.TIPO_EMAIL)) {
                    if (campo.getValor().indexOf('@') == -1 || 
                        campo.getValor().indexOf('.') == -1) {
                        msgs.add(MSG_VALIDACION_EMAIL);
                        FacesUtils.addErrorMessage(campo.getId(), 
                                                   MSG_VALIDACION_EMAIL);
                    }
                }
            }

        }

        return msgs;
    }


    /**
     * @param fechacomp
     * @return
     */
    public boolean dateMayorIgualActual(Date fechacomp) {
        boolean esMayorIgual = false;
        if (fechacomp != null) {
            if (fechacomp.after(new Date())) {
                esMayorIgual = true;
            }
        }
        return esMayorIgual;
    }

    /**
     * Verifica si el componente tiene alg�n valor. Se toma como constante vac�a
     * a la cadena vac�a ""
     * 
     * @param  
     * @return True si el componente tuene alg�n valor o false en caso contrario
     */
    public static String userName() {


        SecurityContext sc = 
            (SecurityContext)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute(null/*HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY*/);


        String userName;
        userName = "";

        try {
            if (sc != null && sc.getAuthentication().getPrincipal() != null) {

                User usuario = ((User)sc.getAuthentication().getPrincipal());
                userName = usuario.getUsername();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userName != null && !userName.equals("")) {
            userName = userName.toLowerCase();
        }


        return userName;

    }


    /**
     * @param fecha
     * @return
     */
    public boolean esElMismoDia(Date fecha){
        boolean esMismo = false; 
        Calendar fechaHoy = Calendar.getInstance(); 
        Calendar fechaComparar = Calendar.getInstance(); 
        fechaComparar.setTime(fecha);
        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH); 
        int mesHoy = fechaHoy.get(Calendar.MONTH); 
        int annoHoy = fechaHoy.get(Calendar.YEAR); 
        
        int diaComp= fechaComparar.get(Calendar.DAY_OF_MONTH); 
        int mesComp = fechaComparar.get(Calendar.MONTH); 
        int annoComp = fechaComparar.get(Calendar.YEAR); 
        
        if(diaHoy == diaComp && mesHoy == mesComp && annoHoy == annoComp ){
            esMismo = true; 
        }
        return esMismo; 
        
    }

    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoEcografia(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("R")) {
                campo = "Rastreo";
            }
            if (campo.equals("E")) {
                campo = "Ecograf�a especializada";
            }
            
             if (campo.equals("N")) {
                 campo = "No se realiza ecograf�a o rastreo";
             }
         }
         
        return campo;
    }
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampo(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("S")) {
                campo = "Si";
            }
            if (campo.equals("N")) {
                campo = "No";
            }
            
         }
        
        
         
        return campo;
    }
    
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoCLOB(String campo) {
        if (campo == null) {
            campo = "";
        } else { 
             campo = campo.trim()+ "\n"; 
            
            
         }
        
        
         
        return campo;
    }
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoRH(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("P")) {
                campo = "Positivo";
            }
            if (campo.equals("N")) {
                campo = "Negativo";
            }
  
         }

        return campo;
    }
    
    
    public String formatearCampoDosis(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("PD")) {
                campo = "Primera Dosis";
            }
            if (campo.equals("SD")) {
                campo = "Segunda Dosis";
            }
             if (campo.equals("TD")) {
                 campo = "Tercera Dosis";
             }
             
             if (campo.equals("RF")) {
                 campo = "Refuerzo";
             }
             if (campo.equals("UN")) {
                 campo = "Unica";
             }
            
         }
        
        
         
        return campo;
    }
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoZona(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("U")) {
                campo = "Urbano";
            }
            if (campo.equals("R")) {
                campo = "Rural";
            }
         }
        
        return campo;
    }
    
    
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoEtnia(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("01")) {
                campo = "Indigena";
            }
            if (campo.equals("02")) {
                campo = "ROM (gitano)";
            }
             if (campo.equals("03")) {
                 campo = "Raizal (archipielago de San Andres y Providencia)";
             }

             if (campo.equals("04")) {
                 campo = "Palanquero de San Basilio";
             }

             if (campo.equals("05")) {
                 campo = "Negro(a)";
             }

             if (campo.equals("06")) {
                 campo = "Afrocolombiano(a)";
             }

             if (campo.equals("99")) {
                 campo = "Ninguno de los anteriores";
             }

         }
        
        return campo;
    }
        
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoNivelEducativo(Integer campo) {
     String campoAux = "";
     if(campo != null){
         if (campo.equals(1)) {
             campoAux = "No Definido";
         }
         if (campo.equals(2)) {
             campoAux = "Preescolar";
         }

         if (campo.equals(3)) {
         campoAux = "Basica Primaria";
         }
         if (campo.equals(4)) {
         campoAux = "Basica Secundaria (Bachillerato Basico)";
         }
         if (campo.equals(5)) {
         campoAux = "Media Academica o Clasica (Bachillerato Basico)";
         }
         if (campo.equals(6)) {
         campoAux = "Media Tecnica (Bachillerato Tecnico)";
         }
         if (campo.equals(7)) {
         campoAux = "Normalista";
         }
         if (campo.equals(8)) {
         campoAux = "Tecnica Profesional";
         }
         if (campo.equals(9)) {
         campoAux = "Tecnologica";
         }
         if (campo.equals(10)) {
         campoAux = "Profesional";
         }
         if (campo.equals(11)) {
         campoAux = "Especializacion";
         }
         if (campo.equals(12)) {
         campoAux = "Maestria";
         }
         if (campo.equals(13)) {
         campoAux = "Doctorado";
         }

     }
                   return campoAux;
    }

    
    
        /**
         * @param campo
         * @return el campo sin espacios y si es null devuelve vacio
         */
        public String formatearCampoDiscapacidad(String campo) {
            if (campo == null) {
                campo = "";
            } else {
                 campo = campo.trim(); 
                if (campo.equals("VI")) {
                    campo = "Discapacidad visual";
                }
                if (campo.equals("AU")) {
                    campo = "Discapacidad auditiva";
                }
                
                 if (campo.equals("MO")) {
                     campo = "Motriz";
                 }
                 if (campo.equals("CO")) {
                     campo = "Cognitiva";
                 }
                 if (campo.equals("PS")) {
                     campo = "Psicosocial";
                 }
                 if (campo.equals("MU")) {
                     campo = "Discapacidad m�ltiple";
                 }
                 if (campo.equals("FI")) {
                     campo = "Discapacidad f�sica";
                 }
                 if (campo.equals("IN")) {
                     campo = "Discapacidad intelectual";
                 }
                 if (campo.equals("ME")) {
                     campo = "Discapacidad sicosocial (mental)";
                 }
                 if (campo.equals("SO")) {
                     campo = "Discapacidad Sordoceguera";
                 }
                 
             }
            
            
             
            return campo;
        }

    
    public String formatearCampoTipoViolencia(String tipoViolencia){
        String resul = ""; 
      
        
        if(tipoViolencia != null){
            try {
                resul = serviceLocator.getClinicoService().getDescripcionRemisionViolencia(tipoViolencia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
    
        
        return resul;
        }

    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoPruebaEmbarazo(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("N")) {
                campo = "Negativa";
            }
            if (campo.equals("P")) {
                campo = "Positiva";
            }
         }
        
        
         
        return campo;
    }
    
    
    
    
 
    
    
    public String formatearCampoNulo(String campo) {
        if (campo == null) {
            campo = "";
        }
        return campo;
    }
    
    
    public String formatearCampoRevision(String campo) {
        if (campo == null) {
            campo = "";
        } else {
            if (campo.equals("R")) {
                campo = "Refiere";
            }
            if (campo.equals("N")) {
                campo = "No Refiere";
            }
            campo.trim();
        }
        return campo;
    }
    
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoRh(String campo) {
        if (campo == null) {
            campo = "";
        } else {
            if (campo.equals("+")) {
                campo = "+ (POS)";
            }
            if (campo.equals("-")) {
                campo = "- (NEG)";
            }
            campo.trim();
        }
        return campo;
    }


    /**
     * @param fecha
     * @return
     */
    public String formatearCampo(Date fecha) {
        String f = "";
        if (fecha != null) {
            String DATE_FORMAT = "dd/MM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            f = sdf.format(fecha);

        }
        return f;

    }
    
    public String formatearCampoNombreUsuario(String usuario, Integer codClinica){
        String resul = ""; 
        Cpprofesio usuaux = null;
    
        if(usuario != null && codClinica != null){
            try {
                usuaux = serviceLocator.getClinicoService().getProfesionalPorUsuario(usuario,codClinica);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if(usuaux!= null){
            resul = usuaux.getCpfcnombre();
        }
        
        return resul;
    }


    /**
     * @param fecha
     * @return
     */
    public String formatearCampoFe(Date fecha) {
        String f = "";
        if (fecha != null) {
            String DATE_FORMAT = "yyyyddMM";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            f = sdf.format(fecha);

        }
        return f;

    }
    
    /**
     * @param fecha
     * @return
     */
    public String formatearCampoFechaLetras(Date fecha) {
        String f = "";
        if (fecha != null) {
            String DATE_FORMAT = "EEEEE dd MMMMM yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            f = sdf.format(fecha);

        }
        return f;

    }
    
    
    
 
    
    
    
    
    public String  formatearDecimal(BigDecimal numero){
        
        String numeroAux = ""; 
        if(numero!= null){
            numeroAux = numero.toString();
        }
        
        if(numeroAux != null && !numeroAux.equals("")){
            numeroAux = numeroAux.replace(".00","") ;
        }
        
        return numeroAux;
    }

   
   
   
    /**
     * @param fecha
     * @return
     */
    public String formatearCampoHoraSimple(Date fecha) {
        String f = "";
        if (fecha != null) {
            String DATE_FORMAT = "h.mm a";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            f = sdf.format(fecha);

        }
        return f;

    }
    
    
    
    


    /**
     * @param fecha
     * @return
     */
    public String formatearCampoHora(Date fecha) {
        String f = "";
        if (fecha != null) {
            String DATE_FORMAT = "dd/MM/yyyy HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            f = sdf.format(fecha);

        }
        return f;

    }


    /**
     * @param numero
     * @return
     */
    public String formatearCampo(Integer numero) {
        String numfor = "";
        if (numero != null) {
            numfor = numero.toString();
        }
        return numfor;
    }
    
    public String formatearCampoTipoDuracion(String desc){
        String resdesc = "";
        if (desc != null) {
            if(desc.equals("MI")){
                resdesc = "Minuto(s)";
            }
            if(desc.equals("H")){
                resdesc = "Hora(s)";
            }
            if(desc.equals("D")){
                resdesc = "D�a(s)";
            }
            if(desc.equals("S")){
                resdesc = "Semana(s)";
            }
        }
        return resdesc;
        }


    /**
     * @param numero
     * @return
     */
    public String formatearCampoTiempoOcurrencia(Integer numero) {
        String numfor = "";
        if (numero != null) {
           if(numero.equals(1)){
               numfor = "Menor de 24 Horas";
             
           }
            if(numero.equals(2)){
                numfor = "Entre 24 y 72 Horas";
              
            }
            if(numero.equals(3)){
                numfor = "Entre 72 y 120 Horas";
              
            }
            if(numero.equals(4)){
                numfor = "Entre 5 d�as y un ano";
              
            }
            if(numero.equals(5)){
                numfor = "Mayor a un ano";
              
            }
           
           
        }
        return numfor;
    }

    /**
     * @param numero
     * @return
     */
    public String formatearCampo(BigDecimal numero) {
        String numfor = "";
        if (numero != null) {
            numfor = numero.toString();
        }
        return numfor;
    }
    
    
    /**
     * @param numero
     * @return
     */
    public String formatearCampo(Double numero) {
        String numfor = "";
        if (numero != null) {
            numfor = numero.toString();
        }
        return numfor;
    }

    /**
     * @param fecha
     * @return
     */
    public String getHoraFecha(Date fecha) {
        String horaFecha;
        horaFecha = "";
        if (fecha != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);

            String hora;
            String minuto;

            hora = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            minuto = String.valueOf(calendar.get(Calendar.MINUTE));

            if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                hora = "0" + hora;
            }
            if (calendar.get(Calendar.MINUTE) < 10) {
                minuto = "0" + minuto;
            }

            horaFecha = hora + ":" + minuto;

        }
        return horaFecha;

    }


    /**
     * @param fechaultimaregla
     * @return El numero de  semanas de embarazo tomado desde la fecha de la ultima regla
     */
    public double calcularSemanasEmbarazo(Date fechaultimaregla) {
        //Creo las dos instancias de fecha
        int semanaAux = 0;
        Integer residuo = 0;
        double semana = 0;
        Double dias = new Double(0);
        String imcStr = "";
        if (fechaultimaregla != null) {

            Calendar calendarconsulta = Calendar.getInstance();
            Calendar calendarUltimaRegla = Calendar.getInstance();
            calendarUltimaRegla.setTime(fechaultimaregla);
            //Realizo la operaci�n
            long time = 
                calendarconsulta.getTimeInMillis() - calendarUltimaRegla.getTimeInMillis();
            //Muestro el resultado en d�as
            dias = new Double((time / (3600 * 24 * 1000)));
            semanaAux = (dias.intValue() / 7);
            residuo = dias.intValue() % 7;

            semana = semanaAux + residuo.doubleValue() / 10;


            if (semana < 0) {
                semana = 0;
            }

            if (semana >= 43) {
                semana = 0;
            } 
        }
        return semana;
    }


    /**
     * @param fechaultimaregla
     * @return
     */
    public double calcularDiasEmbarazo(Date fechaultimaregla){
        //Creo las dos instancias de fecha
       
         double dias = 0;
         if(fechaultimaregla != null){
             Calendar calendarconsulta = Calendar.getInstance(); 
             Calendar calendarUltimaRegla = Calendar.getInstance(); 
             calendarUltimaRegla.setTime(fechaultimaregla);
             //Realizo la operaci�n
             long time = calendarconsulta.getTimeInMillis() - calendarUltimaRegla.getTimeInMillis();
             //Muestro el resultado en d�as
             dias = (time/(3600*24*1000));
            
    }
        return dias;
    }
    
    
    public String obtenerAmbito(Integer ambito) {
        String descAmbito = "";

        if (ambito != null) {
            try {
                descAmbito = 
                        serviceLocator.getClinicoService().getDescripcionActoQuirurgico(ambito);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        return descAmbito;

    }


    public String obtenerFinalidad(Integer finalidad) {
        String descFinalidad = "";
        Crfinalcon fina = null;
        if (finalidad != null) {
            try {
                fina = 
    serviceLocator.getClinicoService().getFinalidadPorId(finalidad,
                                                     TIPO_PROCEDIMIENTO);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (fina != null) {
                descFinalidad = fina.getCfccdescri();
            }
        }

        return descFinalidad;
    }


    public String obtenerActoQuirurgico(Integer actoQuirurgico) {
        String descFinalidad = "";

        if (actoQuirurgico != null) {
            try {
                descFinalidad = 
                        serviceLocator.getClinicoService().getDescripcionActoQuirurgico(actoQuirurgico);
            } catch (ModelException e) {
                e.printStackTrace();
            }


        }

        return descFinalidad;
    }
    
    
    public String obtenerResultadoCitologia(String idResultadoCitologia) {
        Cndesccito descrCitol = null; 
        String descResultadoCitologia = "";

        if (idResultadoCitologia != null) {
            try {
                descrCitol = 
                        serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma","ctmcultres",idResultadoCitologia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            
            if(descrCitol!= null){
                descResultadoCitologia = descrCitol.getCdicdescri(); 
            }


        }

        return descResultadoCitologia;
    }
    


    public String obtenerTipoAnestesia(String tipoAnestesia) {
        String descTipoAnestesia = "";

        if (tipoAnestesia != null && !tipoAnestesia.equals("")) {
            try {
                descTipoAnestesia = 
                        serviceLocator.getClinicoService().getDescripcionTipoAnestesia(tipoAnestesia);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        return descTipoAnestesia;
    }
    
    
    
    public String obtenerCirculante(String codigoCirculante, Integer codClinica){
        String descCirculante = "";
        Cpprofesio profe = null;
        
        if(codigoCirculante != null && !codigoCirculante.equals("")){
            
            try{
                profe = 
                    this.serviceLocator.getClinicoService().getProfesionalPorCodigo(new BigDecimal (codigoCirculante),codClinica);
            }catch(ModelException e){
                e.printStackTrace();
            }
            
            if(profe != null && !profe.equals("")){
                descCirculante = profe.getCpfcnombre();
            }
        }
        return descCirculante;
        
    }
    
    
    public String obtenerInstrumentadora(String codigoInstrumentadora, Integer codClinica){
        String descInstrumenta = "";
        Cpprofesio instrumenta = null;
        
        if(codigoInstrumentadora != null && !codigoInstrumentadora.equals("")){
            try{
                instrumenta = 
                        this.serviceLocator.getClinicoService().getProfesionalPorCodigo(new BigDecimal(codigoInstrumentadora), codClinica);
            }catch(ModelException e){
                e.printStackTrace();
            }
            
            if(instrumenta != null && !instrumenta.equals("")){
                descInstrumenta = instrumenta.getCpfcnombre();
            }
            
        }
        return descInstrumenta;
        
    }


    public String obtenerAnestesiologo(String codigoAnestesiologo, 
                                        Integer codClinica) {
        String descAnestesiologo = "";
        Cpprofesio profesionaObject = null;

        if (codigoAnestesiologo != null && !codigoAnestesiologo.equals("")) {

            StringTokenizer stk = 
                new StringTokenizer(codigoAnestesiologo, ",");
            String codigoAnestesioAux = "";


            while (stk.hasMoreTokens()) {
                codigoAnestesioAux = "";
                descAnestesiologo = "";
                codigoAnestesioAux = stk.nextToken();
                if (codigoAnestesioAux != null && 
                    !codigoAnestesioAux.equals("")) {
                    try {
                        profesionaObject = 
                                this.serviceLocator.getClinicoService().getProfesionalPorCodigo(new BigDecimal(codigoAnestesioAux), 
                                                                                                codClinica);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                }

                if (profesionaObject != null) {
                    descAnestesiologo = 
                            descAnestesiologo + profesionaObject.getCpfcnombre() + 
                            ", ";
                }


            }

        }

        if (descAnestesiologo != null && descAnestesiologo.length() > 2) {
            descAnestesiologo = 
                    descAnestesiologo.substring(0, descAnestesiologo.length() - 
                                                1);
        }

        return descAnestesiologo;
    }


    public String obtenerDescripcionCie10(String codCie10) {
        Crdgncie10 cieObject = null;
        String descripCie10 = "";

        if (codCie10 != null) {
            if (!codCie10.equals("")) {
                try {
                    cieObject = 
                            this.serviceLocator.getClinicoService().getCIE10PorCodigo(codCie10);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            if (cieObject != null) {
                descripCie10 = 
                        cieObject.getCdcccodigo() + " " + cieObject.getCdccdescri();
            }

        }
        return descripCie10;

    }


    public String obtenerAspectosDiuresis(String codigoDiuresis) {
        String descripcionDiuresis = "";

        if (codigoDiuresis != null) {
            try {
                descripcionDiuresis = 
                        serviceLocator.getClinicoService().getDescripcionAspectosDiuresis(codigoDiuresis);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        return descripcionDiuresis;
    }


    public String obtenerGrado(String codigoGrado) {
        String descripcionGrado = "";

        if (codigoGrado != null) {
            try {
                descripcionGrado = 
                        serviceLocator.getClinicoService().getDescripcionGradoDiuresis(codigoGrado);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        return descripcionGrado;
    }
    
    
    public String obtenerTipoLaringueo(String tipo){
        String descTipoLaringueo = "";

        if (tipo != null) {
            if (tipo.equals("1")) {
                descTipoLaringueo = "Clasica";
            }

            if (tipo.equals("2")) {
                descTipoLaringueo = "Con canal esof�gico ";
            }
        }

        return descTipoLaringueo;
        }
        
    
    
    public String obtenerPosicionAnestesia(Integer tipo){
        String descPosicion = "";

        if (tipo != null) {
            if (tipo.equals(1)) {
                descPosicion = "Dec�bito supino";
            }

            if (tipo.equals(2)) {
                descPosicion = "Fowler";
            }
            
            if (tipo.equals(3)) {
                descPosicion = "Litotom�a";
            }
            
            
            if (tipo.equals(4)) {
                descPosicion = "Litotom�a+Trendelenburg";
            }
            
            
            if (tipo.equals(5)) {
                descPosicion = "Litotom�a+Fowler";
            }
            
          
        }

        return descPosicion;
        }
    
    public String obtenerTipoSolucion(String codigoSolucion){
        String descMedico = "";
   
          if (codigoSolucion != null && !codigoSolucion.equals("")) {
            try {
                descMedico = 
                        this.serviceLocator.getClinicoService().getDescripcionLiquidoParenteral(codigoSolucion);
            } catch (ModelException e) {
                e.printStackTrace();


            }

           if(descMedico == null){
               descMedico = ""; 
           }

        }
        return descMedico; 
    }


    public String obtenerCirujano(BigDecimal codigoMedico, Integer codClinica) {
        String descMedico = "";
        Cpprofesio profesionaObject = null;

        if (codigoMedico != null && !codigoMedico.equals("")) {
            try {
                profesionaObject = 
                        this.serviceLocator.getClinicoService().getProfesionalPorCodigo(codigoMedico, 
                                                                                        codClinica);
            } catch (ModelException e) {
                e.printStackTrace();


            }

            if (profesionaObject != null) {
                descMedico = profesionaObject.getCpfcnombre();
            }

        }


        return descMedico;
    }


    public String obtenerIntervenciones(Long numeroCirugia, 
                                         Integer consecutivo) {
        List<Chcirdetdesc> lstCirugias = null;
        String cirugiaDescrip = "";
        String codigoCirugia = "";
        String descripcion = "";

        try {
            lstCirugias = 
                    serviceLocator.getCirugiaService().getCirugiasDescripcion(numeroCirugia, 
                                                                              consecutivo);
            if (lstCirugias != null && !lstCirugias.isEmpty()) {
                for (Chcirdetdesc cirugia: lstCirugias) {
                    codigoCirugia = cirugia.getId().getHcdcintervenci();
                    cirugiaDescrip = 
                            serviceLocator.getClinicoService().getDescripcionCups(cirugia.getId().getHcdcintervenci());
                    if (cirugiaDescrip != null && !cirugiaDescrip.equals("")) {
                        descripcion = 
                                descripcion + codigoCirugia + " " + cirugiaDescrip + 
                                ",";
                    }

                }
            }


        } catch (ModelException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return descripcion;
    }


    public String obtenerTipoUsuario(String tipoUsuario) {
        String descTipoUsuario = "";

        if (tipoUsuario != null && !tipoUsuario.equals("")) {
            try {
                descTipoUsuario = 
                        serviceLocator.getClinicoService().getDescripcionTipoUsuario(tipoUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        return descTipoUsuario;

    }


    public String obtenerUsuario(String codUsuario) {
        String usuario = "";
        Cpusuario usuaObject = null;

        if (codUsuario != null) {
            try {
                usuaObject = 
                        serviceLocator.getClinicoService().getUsuarioPorId(codUsuario.toUpperCase());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (usuaObject != null) {
                usuario = usuaObject.getCurcnombre();
            }
        }
        return usuario;

    }


    public String obtenerPresionArteria(String presArt1, String presArt2) {
        String presionArterial = "";

        if (presArt1 != null && !presArt1.equals("") && presArt2 != null && 
            !presArt2.equals("")) {
            presionArterial = presArt1 + "/" + presArt2;
        }

        return presionArterial;
    }


    public String obtenerTipoTemperatura(String codTemperatura) {
        String descTipoTemperatura = "";

        if (codTemperatura != null) {
            if (codTemperatura.equals("A")) {
                descTipoTemperatura = "Afebril";
            }

            if (codTemperatura.equals("F")) {
                descTipoTemperatura = "Febril";
            }
        }

        return descTipoTemperatura;
    }


    public String obtenerMiembroSuperior(String codMiembro) {
        String descMiembro = "";

        if (codMiembro != null) {
            if (codMiembro.equals("B")) {
                descMiembro = "Brazo";
            }

            if (codMiembro.equals("A")) {
                descMiembro = "Antebrazo";
            }

            if (codMiembro.equals("M")) {
                descMiembro = "Mano";
            }
        }

        return descMiembro;
    }

    public String obtenerLocalizacion(String codLocal) {
        String descLocal = "";
        if (codLocal != null) {
            if (codLocal.equals("D")) {
                descLocal = "Derecho";
            }

            if (codLocal.equals("I")) {
                descLocal = "Izquierdo";
            }
        }

        return descLocal;
    }


    public String obtenerTipoCateter(String tipoCateter) {
        String descTipoCateter = "";

        if (tipoCateter != null) {
            if (tipoCateter.equals("P")) {
                descTipoCateter = "Pericraneal";
            }
            if (tipoCateter.equals("C")) {
                descTipoCateter = "Cat�ter por fuera de aguja";
            }
        }

        return descTipoCateter;
    }


    public String obtenerVia(String codVia) {
        String descrVia;
        descrVia = "";

        if (codVia != null) {
            if (codVia.equals("VO")) {
                descrVia = "Via Oral";
            }

            if (codVia.equals("IV")) {
                descrVia = "V�a Intravenosa";
            }
            if (codVia.equals("IM")) {
                descrVia = "V�a Intramuscular";
            }
            if (codVia.equals("VA")) {
                descrVia = "V�a Intravaginal";
            }
            if (codVia.equals("SC")) {
                descrVia = "Subcut�nea";
            }

            if (codVia.equals("OT")) {
                descrVia = "Otra";
            }

        }

        return descrVia;

    }


    public String obtenerForma(String codForma) {
        String descrForma;
        descrForma = "";

        if (codForma != null) {
            if (codForma.equals("L")) {
                descrForma = "Bolo lento";
            }

            if (codForma.equals("I")) {
                descrForma = "En infusi�n";
            }

            if (codForma.equals("B")) {
                descrForma = "Buretrol";
            }

        }


        return descrForma;
    }
    
    public String obtenerColorManilla(String codColor){
        String descColor = ""; 
        
        if(codColor!= null){
            if(codColor.equals("VE")){
                descColor = "VERDE"; 
            }
            
            if(codColor.equals("AZ")){
                descColor = "AZUL"; 
            }
            
            if(codColor.equals("RO")){
                descColor = "ROJO"; 
            }
        }
        
        return descColor; 
    }
    

    public String obtenerEtapa(String etapa) {
        String descEtapa = "";

        if (etapa != null) {

            if (etapa.equals(ETAPA_VIGENTE)) {
                descEtapa = "Vigente";
            }

            if (etapa.equals(ETAPA_ATENDIDO)) {
                descEtapa = "Atendido";
            }

            if (etapa.equals(ETAPA_SUSPENDER)) {
                descEtapa = "Suspendido";
            }

        }

        return descEtapa;
    }
    
    
    public String obtenerTipoLiquido(String codTipoLiquido){
        String descTipoLiquido = ""; 
        
        if(codTipoLiquido != null){
            if(codTipoLiquido.equals("PA")){
                descTipoLiquido = "Parenterales";
            }
            
            if(codTipoLiquido.equals("OR")){
                descTipoLiquido = "Oral o Tubo";
            }
            
            
            
        }
        
        return descTipoLiquido; 
    }
    
    
    public String obtenerDescripcionTipoLiquido(String codTipoLiquido){
        String descTipoLiquido = ""; 
        
        if(codTipoLiquido != null){
            if(codTipoLiquido.equals("01")){
                descTipoLiquido = "Lactato de Ringer";
            }
            
            if(codTipoLiquido.equals("02")){
                descTipoLiquido = "Haemacell";
            }
            
            if(codTipoLiquido.equals("03")){
                descTipoLiquido = "Dextranes";
            }
            
            if(codTipoLiquido.equals("04")){
                descTipoLiquido = "Globulos Rojos";
            }
            
            if(codTipoLiquido.equals("05")){
                descTipoLiquido = "Sangre total";
            }
            
            if(codTipoLiquido.equals("06")){
                descTipoLiquido = "Plasma";
            }
            
            if(codTipoLiquido.equals("07")){
                descTipoLiquido = "Plaquetas";
            }


            if(codTipoLiquido.equals("08")){
                descTipoLiquido = "Soluci�n Salina";
            }
   
        }
        
        return descTipoLiquido; 
        }
    
    
    public String obtenerTipoDiuresis(String codTipoDiresis){
        String descTipoDiuresis; 
        descTipoDiuresis = ""; 
        if(codTipoDiresis!= null){
            if(codTipoDiresis.equals("S")){
                descTipoDiuresis = "Sonda"; 
            }
            if(codTipoDiresis.equals("E")){
                descTipoDiuresis = "Espontanea"; 
            }
        }
        
        return descTipoDiuresis; 
    }
    
    public String obtenerTipoDrenaje(String codTipoDrenaje){
        String descTipoDrenaje; 
        descTipoDrenaje = ""; 
        
        if(codTipoDrenaje!= null){
            if(codTipoDrenaje.equals("S")){
                descTipoDrenaje = "Sonda"; 
            }
            if(codTipoDrenaje.equals("H")){
                descTipoDrenaje = "Hemovac"; 
            }
            if(codTipoDrenaje.equals("V")){
                descTipoDrenaje = "Vomito"; 
            }
        }
        
        return descTipoDrenaje; 
    }
    
    public String obtenerMetodoPlanificacion(String codigo){
        String descPlanificacion = ""; 
            if(codigo!= null && !codigo.equals("")){
            try {
                descPlanificacion = serviceLocator.getClinicoService().getDescripcionMetodo(codigo);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        return descPlanificacion; 
    }
    
    
    public String obtenerMotivoRechazoIlve(String codigo){
        String descripcion = ""; 
        
        if(codigo!= null){
            if(codigo.equals("SE")){
                descripcion = "Realizar� su Planificaci�n Familiar en la EPS"; 
            }else if(codigo.equals("NC")){
                descripcion = "No tiene compa�ero actual"; 
            }
            else if(codigo.equals("PL")){
                            descripcion = "Ya esta planificando";           
                        }
                        
            else if(codigo.equals("FT")){
                            descripcion = "Ya se encuentra planificando y tuvo falla temporal de m�todo";         
                        }
        }
        
        return descripcion; 
    }
    
    public String getNombreOperadorXUsuario(String usuario){
        String descNombreOperador = usuario;
        Cpusuario usuAux = new Cpusuario();

        if (usuario != null && !usuario.equals("")) {
            try {
                usuAux = 
                        serviceLocator.getClinicoService().getUsuarioPorId(usuario.toUpperCase().trim());
                        
//                System.out.println("NOMBRE ::::::::::::::::::::::::::::::::::: " + usuario.toUpperCase().trim());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if(usuAux != null && usuAux.getCurcnombre() != null){
            descNombreOperador = usuAux.getCurcnombre();
        }
        
            
        
//        System.out.println("NOMBRE ::::::::::::::::::::::::::::::::::: " + descNombreOperador);

        return descNombreOperador;

        }



    /**
     * @param d1 Fecha Inicial
     * @param d2 Fecha Final
     * @return
     */
    public String calculaHorasDiferencia(Date d1, Date d2){    
        Double difH, difM, mod;
        Integer milseg = (1000 * 60 * 60);

        if(d1.after(d2))
            return "";
            
        BigDecimal bd1 = new BigDecimal(d2.getTime());
        BigDecimal bd2 = new BigDecimal(d1.getTime());
        BigDecimal aux1 =  BigDecimal.ZERO;
        
        aux1 = bd1.subtract(bd2);
        aux1 = aux1.divide(new BigDecimal(milseg), 5, BigDecimal.ROUND_HALF_DOWN);
        
        difH = aux1.doubleValue();
        mod  = difH%1;
        difM = mod * 60;
        difH -= mod;
        
        return difH.intValue() + " h : " + difM.intValue() + " m";        
    }
    
    /**
     * @param fecha
     * @return
     */
    public Date formatearCampoStringToDate(String fecha) {
        Date f = null;
        Integer dia = null;
        Integer mes = null;
        Integer anno = null;
        
        
        if (fecha != null && !fecha.equals("")) {
            StringTokenizerStrict stk = 
                new StringTokenizerStrict(fecha, "/");
            dia = new Integer((String)stk.nextElement());
            mes = new Integer((String)stk.nextElement());
            anno = new Integer ((String)stk.nextElement());
            Calendar calendar  = Calendar.getInstance();
            calendar.set(Calendar.YEAR, anno);
            calendar.set(Calendar.MONTH, mes-1);
            calendar.set(Calendar.DAY_OF_MONTH, dia);
            f = calendar.getTime();

        }
        return f;

    }
    
    public String formatearCampo(Object object){
    String campo = ""; 
        if(object != null){
            campo = object.toString();
        }
        
        return campo;
    }
    
    
    public String formatearCampoViaAdministracionMedicamento(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("IM")) {
                campo = "Intramuscular";
            }
            if (campo.equals("SC")) {
                campo = "Subcut�nea";
            }
            
             if (campo.equals("ID")) {
                 campo = "Intrad�rmica";
             }
             
             if (campo.equals("EV")) {
                 campo = "Endovenosa";
             }
             
             if (campo.equals("VO")) {
                 campo = "Oral";
             }
             
             if (campo.equals("SL")) {
                 campo = "Sublingual";
             }
           
            
            if (campo.equals("IV")) {
                campo = "Intravenosa";
            }
            
            if (campo.equals("VO")) {
                campo = "Oral";
            }
            
            if (campo.equals("VV")) {
                campo = "Vaginal";
            }
            
            if (campo.equals("VP")) {
                campo = "Parenteral";
            }
            
            if (campo.equals("VR")) {
                campo = "Rectal";
            }
            
            if (campo.equals("Vsc")) {
                campo = "Subcutanea";
            }
            
            if (campo.equals("Vsl")) {
                campo = "Sublingual";
            }
            
            if (campo.equals("Vn")) {
                campo = "Nasal";
            }
            
            if (campo.equals("Vt")) {
                campo = "Topica";
            }
            
            if (campo.equals("INH")) {
                campo = "Inhalatoria";
            }
            
            if (campo.equals("VOF")) {
                campo = "Oftalmica";
            }
            
            if (campo.equals("VOT")) {
                campo = "Otica";
            }
            
            if (campo.equals("VTO")) {
                campo = "Topica";
            }
            
            if (campo.equals("N/A")) {
                campo = "No Aplica";
            }
            
        }
         
       
        return campo;
    }
    
    public String formatearCampoOtraOrden(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("IV")) {
                campo = "Iniciar v�a oral";
            }
            if (campo.equals("RV")) {
                campo = "Retirar sonda vesical";
            }
            
             if (campo.equals("TS")) {
                 campo = "Tomar Retirar sonda vesicalglucometria";
             }
             
             if (campo.equals("CP")) {
                 campo = "Cambio de posici�n";
             }
             
             if (campo.equals("OX")) {
                 campo = "Oxigeno";
             }
             
             if (campo.equals("OT")) {
                 campo = "Otro";
             }
             
         }
         
       
        return campo;
    }
    
    
    
    
    public String formatearCampoPresentacionVademecum(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("AMPO")) {
                campo = "Ampolla";
            }
            if (campo.equals("CAPS")) {
                campo = "Capsulas";
            }
            
             if (campo.equals("CREM")) {
                 campo = "Crema";
             }
             if (campo.equals("DIU")) {
                 campo = "Diu";
             }
             
              if (campo.equals("EMUL")) {
                  campo = "Emulsiones";
              }
             if (campo.equals("GOTA")) {
                 campo = "Gota";
             }
             
              if (campo.equals("IMPL")) {
                  campo = "Implante";
              }
              if (campo.equals("INH")) {
                  campo = "Inhalable";
              }
              
               if (campo.equals("IMSU")) {
                   campo = "Implante Subdermico";
               }
             if (campo.equals("INTR")) {
                 campo = "Intrauterino";
             }
             
              if (campo.equals("INYE")) {
                  campo = "Inyectable";
              }
              if (campo.equals("JEPR")) {
                  campo = "Jeringa Prellena";
              }
              
               if (campo.equals("OVUL")) {
                   campo = "Ovulo";
               }
             if (campo.equals("POLV")) {
                 campo = "Polvo";
             }
             if (campo.equals("SOLU")) {
               campo = "Solucion Liquida";
             }
             
             if (campo.equals("SUSP")) {
                campo = "Suspensi�n";
             }
             if (campo.equals("TABL")) {
                campo = "Tableta";
             }
             
             if (campo.equals("N/A")) {
                 campo = "No Aplica";
             }
          
         }
    
        return campo;
    }
    
  
    
    
    
    public String formatearCampoSitioAplicacionMedicamento(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("GD")) {
                campo = "Gl�teo Derecho";
            }
            if (campo.equals("GI")) {
                campo = "Gl�teo Izquierdo";
            }
             if (campo.equals("DD")) {
                 campo = "Deltoides Derecho";
             }
             if (campo.equals("DI")) {
                 campo = "Deltoides Izquierdo";
             }
             if (campo.equals("MD")) {
                 campo = "Muslo Derecho";
             }
             if (campo.equals("MI")) {
                 campo = "Muslo Izquierdo";
             }             if (campo.equals("PE")) {
                 campo = "Periumbilical";
             }             if (campo.equals("NA")) {
                 campo = "No Aplica";
             }

         }
        
        
         
        return campo;
    }
    
    
    
    private String formatearCampoFrecuencia(String codigo){
        String descripcion = "";
        
        if(codigo != null && !codigo.equals("")){
            if(codigo.equals("MI")){
                descripcion = "Minutos";
            }
            if(codigo.equals("HO")){
                descripcion = "Horas";
            }
            if(codigo.equals("DI")){
                descripcion = "Dias";
            }
            if(codigo.equals("SE")){
                            descripcion = "Semanal";
                        }
            if(codigo.equals("ME")){
                descripcion = "Mensual";
            }
            if(codigo.equals("TR")){
                descripcion = "Trimestral";
            }
            if(codigo.equals("UN")){
                descripcion = "Unica";
            }if(codigo.equals("N/A")){
                descripcion = "";
            } 
           
        }
        
        return descripcion;
    }
    
    
    
    public String formatearCampoViaAdministracion(String codigo){
        String descripcion = "";
        
        if(codigo != null && !codigo.equals("")){
            if(codigo.equals("VO")){
                descripcion = "Oral";
            }
            if(codigo.equals("IV")){
                descripcion = "Intravenosa";
            }
            if(codigo.equals("IM")){
                descripcion = "Intramuscular";
            }
            if(codigo.equals("VA")){
                descripcion = "Intravaginal";
            }
            if(codigo.equals("VB")){
                descripcion = "Bucal";
            }
            if(codigo.equals("SC")){
                descripcion = "Subcut�nea";
            }if(codigo.equals("TO")){
                descripcion = "Topica";
            }
            if(codigo.equals("N/A")){
                descripcion = "No Aplica";
            } if(codigo.equals("VV")){
                descripcion = "Vaginal";
            } if(codigo.equals("Vof")){
                descripcion = "Oftalmica";
            }if(codigo.equals("Vot")){
                descripcion = "Otica";
            }if(codigo.equals("VP")){
                descripcion = "Parenteral";
            }if(codigo.equals("VR")){
                descripcion = "Rectal";
            }if(codigo.equals("Vsc")){
                descripcion = "Subcutanea";
            }if(codigo.equals("Vsl")){
                descripcion = "Sublingual";
            }if(codigo.equals("Vn")){
                descripcion = "Nasal";
            }if(codigo.equals("Vt")){
                descripcion = "Topica";
            }if(codigo.equals("INH")){
                descripcion = "Inhalatoria";
            }if(codigo.equals("VOF")){
                descripcion = "Oftalmica";
            }if(codigo.equals("VOT")){
                descripcion = "Otica";
            }if(codigo.equals("VTO")){
                descripcion = "Topica";
            }
        
        }
        
        return descripcion;
        }

    
    public String obtenerNombreMedicamento(Chformulamed formulaAux) {

        String nombre = "";

        nombre = 
                "- " + formulaAux.getHfocmedicament() + " " + formatearCampoPresentacion(formulaAux.getHfocformafarma()) + 
                " " + formulaAux.getHfocconcentr() + " " + 
                formulaAux.getHfocunidmedi();

        return nombre;
            }
            
            
    public String obtenerNombreEps(String wcodigo) {

          String nombre = "";
          
                  if (wcodigo != null) {
                          try {
                              nombre = serviceLocator.getClinicoService().getDescripcionEntidadByCodigo(wcodigo);
                          } catch (ModelException e) {
                              e.printStackTrace();
                          }
                      }
                      
                      if(nombre == null){
                          
                          nombre = "Particular";
                      }


          return nombre;
              }
              
              
    public String obtenerDescripcionTipoEspecialidad(Integer codEspecialidad){
        String nombre = "";
        
                if (codEspecialidad != null) {
                        try {
                            nombre = serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(codEspecialidad);
                        } catch (ModelException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    if(nombre == null){
                        nombre = "";
                    }
        return nombre;
            }
            
            

    public String obtenerNombreServicio(String wcodigo) {

          String nombre = "";
          
                  if (wcodigo != null) {
                          try {
                              nombre = serviceLocator.getClinicoService().getNombreServicioXCodigo(wcodigo);
                          } catch (ModelException e) {
                              e.printStackTrace();
                          }
                      }
          return nombre;
              }


            
    public String obtenerNombreTratamiento(Chformulamed formulaAux){
    String nombre = "";
    
    if(formulaAux != null){
      if(formulaAux.getHfocfrecuenc() != null && formulaAux.getHfocfrecuenc().equals("UN")){
          nombre = "Dosis Unica"; 
      }      
      
     else  if( formulaAux.getHfocfrecuenc() != null && formulaAux.getHfocformafarma() != null && formulaAux.getHfocformafarma().equals("CREM")){
          nombre = "Aplicar"  + " Cada " + formulaAux.getHfonfrecuenc() + " " +
          formatearCampoFrecuencia(formulaAux.getHfocfrecuenc()) + " Por " +  formulaAux.getHfonduracion()
          + " " + formatearCampoFrecuencia(formulaAux.getHfocduracion()); 
          
      }      
      
      else if(formulaAux.getHfocfrecuenc() != null && formulaAux.getHfocformafarma() != null && formulaAux.getHfocformafarma().equals("INH")){
          nombre = "Puff "  + " Cada " + formulaAux.getHfonfrecuenc() + " " +
          formatearCampoFrecuencia(formulaAux.getHfocfrecuenc()) + " Por " +  formulaAux.getHfonduracion()
          + " " + formatearCampoFrecuencia(formulaAux.getHfocduracion()); 
          
      }      
      
      else if(formulaAux.getHfocfrecuenc() != null && formulaAux.getHfocformafarma() != null && formulaAux.getHfocformafarma().equals("SUSP")){
          nombre = "CC "  + " Cada " + formulaAux.getHfonfrecuenc() + " " +
          formatearCampoFrecuencia(formulaAux.getHfocfrecuenc()) + " Por " +  formulaAux.getHfonduracion()
          + " " + formatearCampoFrecuencia(formulaAux.getHfocduracion()); 
          
      }   
      else if(formulaAux.getHfocdescform() != null && !formulaAux.getHfocdescform().equals("") ){
        
        nombre = formulaAux.getHfocadosis() + " " + formulaAux.getHfocdescform()   + " Cada " + formulaAux.getHfonfrecuenc() + " " +
        formatearCampoFrecuencia(formulaAux.getHfocfrecuenc()) + " Por " +  formulaAux.getHfonduracion()
        + " " + formatearCampoFrecuencia(formulaAux.getHfocduracion()); 
      
        
        
    }else{
        nombre =  formulaAux.getHfocadosis() + " " + formatearCampoPresentacion(formulaAux.getHfocformafarma()) + " Cada " + formulaAux.getHfonfrecuenc() + " " +
        formatearCampoFrecuencia(formulaAux.getHfocfrecuenc()) + " Por " +  formulaAux.getHfonduracion()
        + " " + formatearCampoFrecuencia(formulaAux.getHfocduracion()); 
    }
    
       
      
    }
    
    
    if(formulaAux.getHfoctratramien() != null && !formulaAux.getHfoctratramien().equals("")){
        nombre = formulaAux.getHfoctratramien();
    }
    
    return nombre;

    }
    
    
    public String formatearCampoPresentacion(String codigo){
        String descripcion = "";
        
        if(codigo != null && !codigo.equals("")){
            if(codigo.equals("AMPO")){
                descripcion = "Ampolla";
            }
            if(codigo.equals("CREM")){
                descripcion = "Crema";
            }
            if(codigo.equals("DIU")){
                descripcion = "Diu";
            }
            if(codigo.equals("EMUL")){
                descripcion = "Emulsiones";
            }
            if(codigo.equals("GOTA")){
                descripcion = "Gota";
            }
            if(codigo.equals("IMSU")){
                descripcion = "Implante Subdermico";
            }
            if(codigo.equals("INTR")){
                descripcion = "Intrauterino";
            }
            if(codigo.equals("INYE")){
                descripcion = "Inyectable";
            }
            if(codigo.equals("OVUL")){
                descripcion = "Ovulo";
            }
            if(codigo.equals("POLV")){
                descripcion = "Polvo";
            }
            if(codigo.equals("SOLU")){
                descripcion = "Solucion Liquida";
            }
            if(codigo.equals("SUSP")){
                descripcion = "Suspensi�n";
            }
            if(codigo.equals("TABL")){
                descripcion = "Tableta";
            }
          
            if(codigo.equals("CAPS")){
                descripcion = "Capsulas";
            }
            if(codigo.equals("IMPL")){
                descripcion = "Implante";
            }
            if(codigo.equals("INH")){
                descripcion = "Inhalable";
            }
            
        
        }
            return descripcion;
        }
        
        
        
        
        public Integer calcularCantidad(Integer cantidad, Integer frecuencia, Integer duracion , String unifre, String unidura){
            Integer total = 0 ;
            Integer factorFrecuencia = 0;
            Integer factorDuracion = 0;
            
            Integer totalFrecuencia = 0;
            Integer totalDuracion = 0;
            
            
            if(unifre != null && !unifre.equals("")  && unidura != null && !unidura.equals("") ){
                if(unifre.equals("MI")){
                    factorFrecuencia = 1;
                }
                if(unifre.equals("HO")){
                    factorFrecuencia = 60;
                }
                if(unifre.equals("DI")){
                    factorFrecuencia = 1440;
                }
                if(unifre.equals("SE")){
                    factorFrecuencia = 10080;
                }
                if(unifre.equals("ME")){
                    factorFrecuencia = 43200;
                }
                if(unifre.equals("TR")){
                    factorFrecuencia = 129600;
                }
                if(unifre.equals("UN")){
                    factorFrecuencia = 0;
                }
                
                
                
                if(unidura.equals("MI")){
                    factorDuracion = 1;
                }
                if(unidura.equals("HO")){
                    factorDuracion = 60;
                }
                if(unidura.equals("DI")){
                    factorDuracion = 1440;
                }
                if(unidura.equals("ME")){
                    factorDuracion = 43200;
                }
                if(unidura.equals("TR")){
                    factorDuracion = 129600;
                }
                if(unidura.equals("UN")){
                    factorDuracion = 0;
                }
            }
            
            if(frecuencia != null && duracion != null){
                totalFrecuencia = frecuencia * factorFrecuencia;
                totalDuracion = duracion * factorDuracion;
                
                if(totalFrecuencia != null && totalFrecuencia.intValue() != 0){
                    total = (totalDuracion/totalFrecuencia)*cantidad;    
                }else{
                    total = 1*cantidad;
                }
                
             
                
                if(factorDuracion != null && factorDuracion.intValue() == 0 && factorFrecuencia != null && factorFrecuencia.intValue() == 0){
                    total = 1*cantidad;
                }
                
            }else{
                total = cantidad;
            }
            
            
            
            return total;
        }

    public String formatearNombreCitologia(String wcodigo) {
        String nombre = "";

        if (wcodigo != null) {
            nombre = wcodigo.replace("�", "N");
        }
        return nombre;
    }
    
    public String nombrecontratoxconsulta(Long numeroconsulta){
     String nombreContrato = "";
        Integer numeroContrato = null;
        Cpcontrato contrato = null;
        try {
            numeroContrato = serviceLocator.getClinicoService().getContratoXConsultaClinica(numeroconsulta);
            if(numeroContrato != null){
                contrato = serviceLocator.getClinicoService().getContratoPornumero(numeroContrato) ;  
            }
            
            if(contrato != null){
                nombreContrato = contrato.getCcncdescri();
            }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        
        return nombreContrato; 
    }
    
    public String codigocontratoxconsulta(Long numeroconsulta){
     String nombreContrato = "";
        Integer numeroContrato = null;
        Cpcontrato contrato = null;
        try {
            numeroContrato = serviceLocator.getClinicoService().getContratoXConsultaClinica(numeroconsulta);
            if(numeroContrato != null){
                contrato = serviceLocator.getClinicoService().getContratoPornumero(numeroContrato) ;  
            }
            
            if(contrato != null){
                nombreContrato = contrato.getCcnccodsgs();
                if(nombreContrato == null || nombreContrato.equals("")){
                    nombreContrato = contrato.getId().getCcnnnumero().toString(); 
                }
                
            }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        
        return nombreContrato; 
    }
    
    
    public String getNombreAseguradora(String codigo ){
        String nombreAseguradora = "";
           Cpentidadadm entidadAux = null;
         
           try {
               entidadAux = serviceLocator.getClinicoService().getAseguradoraPorCodigo(codigo);
               if(entidadAux != null){
                   nombreAseguradora = entidadAux.getCeacnombre();  
               }
               
              
               
           } catch (ModelException e) {
               e.printStackTrace();
           }
           
           
           return nombreAseguradora; 
        }
        
    
    
    public String getNombreTipoEspecialidad(Integer codigo ){
        String nombreEspecialidad = "";
           
         
           try {
               nombreEspecialidad = serviceLocator.getClinicoService().getDescripcionTipoEspecialidad(codigo);
               
               
              
               
           } catch (ModelException e) {
               e.printStackTrace();
           }
           
           
           return nombreEspecialidad; 
        }
    
    
    public String getTipoAnestesia(String codTipoLiquido){
        String descTipoAnestesia = ""; 
        
        if(codTipoLiquido != null){
            if(codTipoLiquido.equals("2")){
                descTipoAnestesia = "General";
            }
            
            if(codTipoLiquido.equals("3")){
                descTipoAnestesia = "";
            }
            
            
            if(codTipoLiquido.equals("4")){
                descTipoAnestesia = "Regional";
            }
            
            if(codTipoLiquido.equals("5")){
                descTipoAnestesia = "Sedaci�n";
            }
            if(codTipoLiquido.equals("6")){
                descTipoAnestesia = "Local";
            }
            if(codTipoLiquido.equals("7")){
                descTipoAnestesia = "Local Controlada";
            }
        }
        
        return descTipoAnestesia; 
    }
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoVPH(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("S")) {
                campo = "Si";
            }
            if (campo.equals("N")) {
                campo = "No";
            }
            
            if (campo.equals("NS")) {
                 campo = "No Sabe";
             }
         }
        
        
         
        return campo;
    }
    
    /**
         * @param campo
         * @return el campo sin espacios y si es null devuelve vacio
         */
        public String formatearCampoEFPrenatal(String campo) {
            if (campo == null) {
                campo = "";
            } else {
                 campo = campo.trim(); 
                if (campo.equals("A")) {
                    campo = "Anormal";
                }
                if (campo.equals("N")) {
                    campo = "Normal";
                }
             }
            return campo;
        }
        
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearCampoSexo(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("F")) {
                campo = "MUJER";
            }
            if (campo.equals("M")) {
                campo = "HOMBRE";
            }
             if (campo.equals("I")) {
                 campo = "INDETERMINADO";
             }
         }
        
        return campo;
    }
    
    /**
     * @param campo
     * @return el campo sin espacios y si es null devuelve vacio
     */
    public String formatearEstadoCivil(String campo) {
        if (campo == null) {
            campo = "";
        } else {
             campo = campo.trim(); 
            if (campo.equals("C")) {
                campo = "CASADO";
            }
            if (campo.equals("D")) {
                campo = "DIVORCIADO";
            }
             if (campo.equals("S")) {
                 campo = "SOLTERO";
             }
             if (campo.equals("U")) {
                 campo = "UNI�N LIBRE";
             }
             if (campo.equals("V")) {
                 campo = "VIUDO";
             }
         }
        
        return campo;
    }
    
    public String formatearLugarToma(String toma) {
        String f = "";
        if (toma != null) {
            if(toma.equals("CL")){
                f= "Clinica";
            }else  if(toma.equals("BE")){
                f= "Brigada";
            }else  if(toma.equals("DP")){
                f= "Domicilio Paciente";
            }

        }
        return f;

    }
    public boolean activarFuncionalidadCostos() {
          Cpempresa emp ;
          Boolean activar = false;
        try {
            emp = serviceLocator.getCostosService().getCpempresa();
            if (emp != null) {
                  if (emp.getCemccostos().equals("AC")) {
                      activar = true;
                  }
              } 
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }
       
          return activar;
      }

     /**
    * Capturas las excepciones y las muestra en pantalle de forma mas clara 
    *
    * @params Throwable e Excepcion generada
    * @params String msg Mensaje claro del desarrollador para el usuario
    * */
    protected String capturaError(Throwable e, String msg){
       FacesUtils.resetManagedBean("erroresBean");                 
       ErroresBean error = (ErroresBean)FacesUtils.getManagedBean("erroresBean");
       error.setMensajeUsuario(msg);
       error.setE(e);
       DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       Date date = new Date();
       error.setFechaError(dateFormat.format(date));
       return BeanNavegacion.RUTA_IR_MOSTRAR_ERROR;  
    }
    
    
   
}
