package org.profamilia.hc.view.backing.cirugia.registro;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chverquirofa;
import org.profamilia.hc.model.dto.Chitemvrquir;
import org.profamilia.hc.model.dto.ChitemvrquirPK;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chparavrqui;
import org.profamilia.hc.model.dto.Chtipousuari;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.busqueda.ListaCirugiaEpicrisisBean;
import org.profamilia.hc.view.backing.cirugia.consulta.ConsultarUsuariosEpicrisisBean;
import org.profamilia.hc.view.backing.clinico.comun.Cie10Bean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


public class RegistrarVerificacionQuirofanoEnfermeraBean extends BaseBean implements JRDataSource {

    private Chverquirofa verquirofano;

    private Long numerocirugia;

    private Chcirugprogr cirugiaSelect;
    
    private Chcirugprogr cirugia;
    
    private int selectedIndex;

    private List lstTipoUsuario;

    private List<Chitemvrquir> lstPorVerificar;

    private List<Chitemvrquir> listVerificaciones;

    private List<Chitemvrquir> lstItemverificado;

    private long numeroHoras;
    
    private List<Object[]> lstCirugiasEgreso; 
    
    private  List <Cpservicio> lstCirugiasIngreso; 
    
    /** Variable que almacena la hora inicial de la verificacion*/
    private String horaIngreso;

    /** Variable que almacena la hora final de la verificacion*/
    private String horaSalida;
    
    /** Almacena la lista de las horas habiles para una cirugia*/
    private List<SelectItem> listHora;

    /** Variable que almacena los minutos de la cirugia seleccionada*/
    private String minutoIngreso;

    /** Variable que almacena los minutos de la consulta seleccionada*/
    private String minutoSalida;

    /** Almacena la lista de los minutos habiles para una cirugia*/
    private List<SelectItem> lstMinutos;

    /** Almacena la lista de los tipos de anestesia  */
    private List lstTipoAnestesia;

    /** Almacena true si el tipo de estancia es hospitalaria*/
    private UIInput mnuAnestesia;

    /** para definir que registra la verificaci�n la enfermera */
    private String usuarioRegistra;

    private HtmlDataTable dtVerificado;

    private HtmlDataTable dtPorverificar;
    
    /** Almacena la lista de opciones 'SI' o 'NO' */
    private List lstOpciones;

    /** Almacena la lista de opciones 'SI', 'NO' o 'NO APLICA' */
    private List lstOpcionesNoaplica;
    
    private Chusuario usuario;

    /** Indice de la fuente de datos */
    private int index = 0;

    private boolean generoReporte;

    private List lstAnestesiologo;

    private List lstCirujano;
    
    private List lstEnfermera;
    
    private List lstInstrumentador;
    
    private String etapa;
    

    public RegistrarVerificacionQuirofanoEnfermeraBean() {
    }

    public void init() {
        verquirofano = new Chverquirofa();
        lstTipoUsuario = new ArrayList();
        dtVerificado = new HtmlDataTable();
        dtPorverificar = new HtmlDataTable();
        cargarDatos();
        generoReporte = false;

    }

    public void cargarDatos() {

        lstCirugiasIngreso = new ArrayList<Cpservicio> ();
        lstPorVerificar = new ArrayList<Chitemvrquir>();
        lstItemverificado = new ArrayList<Chitemvrquir>();
        if (numerocirugia != null) {
            try {

                lstCirugiasEgreso = 
                        this.serviceLocator.getClinicoService().getDetalleCirugiasProgramadasBasico(numerocirugia,true);

                cirugia = 
                        this.serviceLocator.getClinicoService().getProgramarCirugia(numerocirugia);

                verquirofano = 
                        this.getServiceLocator().getCirugiaService().getChverquirofa(numerocirugia);                        

                if (cirugia != null) {
                    if (verquirofano == null) {
                       verquirofano = new Chverquirofa();
                       verquirofano.setHvqdfecverifi(new Date());
                       verquirofano.setHvqctipoaneste(cirugia.getHcpctipoaneste());
                       verquirofano.setHvqlcirugia(cirugia.getHcplnumero());
                       verquirofano.setHvqlusuario(cirugia.getHcplusuario());
                       verquirofano.setHvqcimpreso("N");
                       verquirofano.setHvqcetapa("AA");
                       etapa = "Antes de la Anestesia";
                    } else {
                       horaIngreso = verquirofano.getHvqchoraingres().substring(0,1);
                       minutoIngreso = verquirofano.getHvqchoraingres().substring(3,4);
                       horaSalida = verquirofano.getHvqchorasalida().substring(0,1);
                       minutoSalida = verquirofano.getHvqchorasalida().substring(3,4);
                       if (verquirofano.getHvqcetapa().equals("AA")) {
                          verquirofano.setHvqcetapa("AI");
                          etapa = "Antes de la Insici�n";
                       } else if (verquirofano.getHvqcetapa().equals("AI")) {
                          verquirofano.setHvqcetapa("AS");
                          etapa = "Antes de la Salida";
                       } else if (verquirofano.getHvqcetapa().equals("AS")) {
                           etapa = "Antes de la Salida";
                       }

                       lstItemverificado = 
                            this.serviceLocator.getCirugiaService().getItemVerificadosQuirofano(numerocirugia);
                            
                       usuario = this.serviceLocator.getClinicoService().getUsuario(verquirofano.getHvqlusuario().getHuslnumero());
                    }
                }

                if (verquirofano != null && verquirofano.getHvqcimpreso().equals("N")) {
                    lstPorVerificar = 
                        this.serviceLocator.getCirugiaService().getItemPorVerificarQuirofano(numerocirugia,usuarioRegistra,cirugia.getHcpctipoaneste(),verquirofano.getHvqcetapa(), userName());
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void changeTodosNo() {

        inicializarPreguntas("N");
    }

    public void changeTodosSi() {
   
            inicializarPreguntas("S");      
    }


    public void changeNinguno() {

        inicializarPreguntas(null);


    }
    
    /**
     * @param opcion
     */
    public void inicializarPreguntas(String opcion) {
         List<Chitemvrquir> lstPorVerificarAux;

        lstPorVerificarAux = lstPorVerificar;
        lstPorVerificar = new ArrayList<Chitemvrquir>();
        if (lstPorVerificarAux != null && !lstPorVerificarAux.isEmpty()) {

            for(Chitemvrquir lista: lstPorVerificarAux){
                lista.setHiqcrespuesta(opcion);
                
                lstPorVerificar.add(lista);
                
            }


        }

    }


    /**
     * @param verquirofano
     */
    public void setVerquirofano(Chverquirofa verquirofano) {
        this.verquirofano = verquirofano;
    }

    /**
     * @return
     */
    public Chverquirofa getVerquirofano() {
        return verquirofano;
    }

    /**
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * @return
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }


    /**
     * @param lstTipoUsuario
     */
    public void setLstTipoUsuario(List lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    /**
     * @return
     */
    public List getLstTipoUsuario() {
        if (lstTipoUsuario.size() == 0) {
            ArrayList<Chtipousuari> listTipoUsuarioAux = null;
            try {
                listTipoUsuarioAux = 
                        (ArrayList<Chtipousuari>)this.getServiceLocator().getClinicoService().getTipoUsuario();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listTipoUsuarioAux.isEmpty()) {
                lstTipoUsuario.add(new SelectItem("", 
                                                  "Seleccione una opci�n"));
                Iterator it = listTipoUsuarioAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstTipoUsuario.add(new SelectItem(listTipoUsuarioAux.get(i).getHtuccodigo(), 
                                                      listTipoUsuarioAux.get(i).getHtucdescripcio()));
                    i++;
                }
            }
        }
        return lstTipoUsuario;
    }

    /**
     * @param numeroHoras
     */
    public void setNumeroHoras(long numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * @return
     */
    public long getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * @param cirugiaSelect
     */
    public void setCirugiaSelect(Chcirugprogr cirugiaSelect) {
        this.cirugiaSelect = cirugiaSelect;
    }

    /**
     * @return
     */
    public Chcirugprogr getCirugiaSelect() {
        return cirugiaSelect;
    }

    /**
     * @param numerocirugia
     */
    public void setNumerocirugia(Long numerocirugia) {
        this.numerocirugia = numerocirugia;
    }

    /**
     * @return
     */
    public Long getNumerocirugia() {
        return numerocirugia;
    }

    /**
     * @param lstCirugiasEgreso
     */
    public void setLstCirugiasEgreso(List<Object[]> lstCirugiasEgreso) {
        this.lstCirugiasEgreso = lstCirugiasEgreso;
    }

    /**
     * @return
     */
    public List<Object[]> getLstCirugiasEgreso() {
        return lstCirugiasEgreso;
    }

    /**
     * @param lstCirugiasIngreso
     */
    public void setLstCirugiasIngreso(List<Cpservicio> lstCirugiasIngreso) {
        this.lstCirugiasIngreso = lstCirugiasIngreso;
    }

    /**
     * @return
     */
    public List<Cpservicio> getLstCirugiasIngreso() {
        return lstCirugiasIngreso;
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
     * @return
     */
    public boolean validarCampos() {
        boolean esValido = true;

        if (verquirofano == null || lstPorVerificar.isEmpty()) {
            esValido = false;
            FacesUtils.addErrorMessage("No existen datos para registrar la verificacion del quirofano");
        } else {
            if (horaIngreso == null || horaIngreso.equals("")) {
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuHoraIngreso", 
                                           MSG_CAMPO_OBLIGATORIO);
                esValido = false;
            }

            if (minutoIngreso == null || minutoIngreso.equals("")) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuMinutosIngreso");

            }

            if (horaSalida == null || horaSalida.equals("")) {
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuHoraSalida", 
                                           MSG_CAMPO_OBLIGATORIO);
                esValido = false;
            }

            if (minutoSalida == null || minutoSalida.equals("")) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuMinutosSalida",
                                            MSG_CAMPO_OBLIGATORIO);

            }

            if (verquirofano.getHvqcobservac() == null || verquirofano.getHvqcobservac().equals("")) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:observaciones",
                                            MSG_CAMPO_OBLIGATORIO);

            }

            if (verquirofano.getHvqnanestesio() == null 
                || (verquirofano.getHvqnanestesio().intValue() ==  0 && !verquirofano.getHvqctipoaneste().equals("3"))) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuAnestesiologo",
                                            MSG_CAMPO_OBLIGATORIO);

            }

            if (verquirofano.getHvqncirujano() == null || verquirofano.getHvqncirujano().intValue() == 0) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuCirujano",
                                            MSG_CAMPO_OBLIGATORIO);

            }

            if (verquirofano.getHvqninstrumen() == null || 
                (verquirofano.getHvqninstrumen().intValue() == 0 && !verquirofano.getHvqctipoaneste().equals("3"))) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuInstrumentador",
                                            MSG_CAMPO_OBLIGATORIO);

            }

            if (verquirofano.getHvqnenfermero() == null || verquirofano.getHvqnenfermero().intValue() == 0) {
                esValido = false;
                FacesUtils.addErrorMessage("body:registrarVerificacionForm:panelTabRegistrarVerificar:mnuEnfermera",
                                            MSG_CAMPO_OBLIGATORIO);
            }

            int consec = 0;
            Chitemvrquir itemvrquiAux;
            Iterator it = lstPorVerificar.iterator();
            while (it.hasNext()) {
                it.next();
                itemvrquiAux = lstPorVerificar.get(consec);

                if (itemvrquiAux.getId().getHiqnnumeral().intValue() != 0 && 
                    (itemvrquiAux.getHiqcrespuesta() == null || itemvrquiAux.getHiqcrespuesta().equals(""))) {
                    esValido = false;
                    FacesUtils.addErrorMessage("No ha registrado las respuestas de todos los items.");
                }
                consec++;
            }
        }

        return esValido;

    }


    /**
     * @return
     */
    public String registrarVerificacion() {

       boolean wexito = true;   
       if (validarCampos()) {
           verquirofano.setHvqdfecreg(new Date());
           verquirofano.setHvqcgrabador(userName());
           verquirofano.setHvqchoraingres(horaIngreso+":"+minutoIngreso);
           verquirofano.setHvqchorasalida(horaSalida+":"+minutoSalida);
           try {
               serviceLocator.getCirugiaService().saveVerificacionQuirofano(verquirofano,lstPorVerificar);
               FacesUtils.addInfoMessage(MSG_ADICION);
           } catch (ModelException e) {
               wexito = false;
               FacesUtils.addInfoMessage(MSG_NO_ADICION);
               e.printStackTrace();
           }
       }
           
       if (wexito) {
           if (usuarioRegistra.equals("E")) {
               FacesUtils.resetManagedBean("registrarVerificacionQuirofanoEnfermeraBean");
               
               return BeanNavegacion.RUTA_IR_LISTA_VERIFICACION_QUIROFANO_ENFERMERA;
           } else {
               FacesUtils.resetManagedBean("registrarVerificacionQuirofanoEnfermeraBean");
               return BeanNavegacion.RUTA_IR_LISTA_CIRUGIAS_MEDICOS;
           }
       }
           
       return BeanNavegacion.RUTA_ACTUAL;
    }


    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraIngreso() {
        if (verquirofano.getHvqchoraingres() != null && verquirofano.getHvqchoraingres().length() == 5) {
          return verquirofano.getHvqchoraingres().substring(0,2);
        } 
        return horaIngreso;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraSalida() {
        if (verquirofano.getHvqchorasalida() != null && verquirofano.getHvqchorasalida().length() == 5) {
            return verquirofano.getHvqchorasalida().substring(0,2);
        }
        return horaSalida;
    }
   
    public void setListHora(List<SelectItem> listHora) {
        this.listHora = listHora;
    }

    /**
     * @return
     */
    public List<SelectItem> getListHora() {
        if (listHora == null || listHora.isEmpty()) {
            listHora = new ArrayList<SelectItem>();
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem("06", "06"));
            listHora.add(new SelectItem("07", "07"));
            listHora.add(new SelectItem("08", "08"));
            listHora.add(new SelectItem("09", "09"));
            listHora.add(new SelectItem("10", "10"));
            listHora.add(new SelectItem("11", "11"));
            listHora.add(new SelectItem("12", "12"));
            listHora.add(new SelectItem("13", "13"));
            listHora.add(new SelectItem("14", "14"));
            listHora.add(new SelectItem("15", "15"));
            listHora.add(new SelectItem("16", "16"));
            listHora.add(new SelectItem("17", "17"));
            listHora.add(new SelectItem("18", "18"));
            listHora.add(new SelectItem("19", "19"));
            listHora.add(new SelectItem("20", "20"));

        }
        return listHora;
    }

    public void setMinutoIngreso(String minutoIngreso) {
        this.minutoIngreso = minutoIngreso;
    }

    public String getMinutoIngreso() {
    
        if (verquirofano.getHvqchoraingres() != null && verquirofano.getHvqchoraingres().length() == 5) {
            return verquirofano.getHvqchoraingres().substring(3);
        }
        return minutoIngreso;
    }

    public void setMinutoSalida(String minutoSalida) {
        this.minutoSalida = minutoSalida;
    }

    public String getMinutoSalida() {
        if (verquirofano.getHvqchorasalida() != null && verquirofano.getHvqchorasalida().length() == 5) {
            return verquirofano.getHvqchorasalida().substring(3);
        }
        return minutoSalida;
    }


    /**
     * @param lstMinutos
     */
    public void setLstMinutos(List<SelectItem> lstMinutos) {
        this.lstMinutos = lstMinutos;
    }

    /**
     * @return
     */
    public List<SelectItem> getLstMinutos() {
        if (lstMinutos == null || !lstMinutos.isEmpty()) {
            lstMinutos = new ArrayList<SelectItem>();
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem("00", "00"));
            lstMinutos.add(new SelectItem("05", "05"));
            lstMinutos.add(new SelectItem("10", "10"));
            lstMinutos.add(new SelectItem("15", "15"));
            lstMinutos.add(new SelectItem("20", "20"));
            lstMinutos.add(new SelectItem("25", "25"));
            lstMinutos.add(new SelectItem("30", "30"));
            lstMinutos.add(new SelectItem("35", "35"));
            lstMinutos.add(new SelectItem("40", "40"));
            lstMinutos.add(new SelectItem("45", "45"));
            lstMinutos.add(new SelectItem("50", "50"));
            lstMinutos.add(new SelectItem("55", "55"));
        }
        return lstMinutos;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvqctipoaneste(ValueChangeEvent valueChangeEvent) {
            verquirofano.setHvqctipoaneste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setLstTipoAnestesia(List lstTipoAnestesia) {
        this.lstTipoAnestesia = lstTipoAnestesia;
    }

    public List getLstTipoAnestesia() {
        if (lstTipoAnestesia == null || lstTipoAnestesia.isEmpty()) {
            lstTipoAnestesia = new ArrayList();
            lstTipoAnestesia.add(new SelectItem("2", "General"));
            lstTipoAnestesia.add(new SelectItem("4", "Regional"));
            lstTipoAnestesia.add(new SelectItem("5", "Sedaci�n"));
            lstTipoAnestesia.add(new SelectItem("6", "Local Controlada"));

        }
        return lstTipoAnestesia;
    }

    public void setMnuAnestesia(UIInput mnuAnestesia) {
        this.mnuAnestesia = mnuAnestesia;
    }

    public UIInput getMnuAnestesia() {
        return mnuAnestesia;
    }

    /**
     * @param dtVerificado
     * */
    public void setDtVerificado(HtmlDataTable dtVerificado) {
        this.dtVerificado = dtVerificado;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtVerificado() {
        return dtVerificado;
    }


    public void setLstPorVerificar(List<Chitemvrquir> lstPorVerificar) {
        this.lstPorVerificar = lstPorVerificar;
    }

    public List<Chitemvrquir> getLstPorVerificar() {
        return lstPorVerificar;
    }

    public void setLstItemverificado(List<Chitemvrquir> lstItemverificado) {
        this.lstItemverificado = lstItemverificado;
    }

    public List<Chitemvrquir> getLstItemverificado() {
        return lstItemverificado;
    }
    
    /**
     * @param dtPorverificar
     * */
    public void setDtPorverificar(HtmlDataTable dtPorverificar) {
        this.dtPorverificar = dtPorverificar;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPorverificar() {
        return dtPorverificar;
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
        if (lstOpciones == null) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param lstOpcionesNoaplica
     */
    public void setLstOpcionesNoaplica(List lstOpcionesNoaplica) {
        this.lstOpcionesNoaplica = lstOpcionesNoaplica;
    }

    /**
     * @return
     */
    public List getLstOpcionesNoaplica() {
        if (lstOpcionesNoaplica == null) {
            lstOpcionesNoaplica = new ArrayList();
            lstOpcionesNoaplica.add(new SelectItem("S", "SI"));
            lstOpcionesNoaplica.add(new SelectItem("N", "NO"));
            lstOpcionesNoaplica.add(new SelectItem("X", "NO APLICA"));
        }
        return lstOpcionesNoaplica;
    }

    public void changeAnestesia() {

        if (verquirofano != null && verquirofano.getHvqctipoaneste() != null) {
            if (verquirofano.getHvqctipoaneste().equals("3")) {
                verquirofano.setHvqnanestesio(new BigDecimal(0));
            }
            try {
                lstItemverificado = 
                        this.serviceLocator.getCirugiaService().getItemVerificadosQuirofano(numerocirugia);

                lstPorVerificar = 
                        this.serviceLocator.getCirugiaService().getItemPorVerificarQuirofano(numerocirugia,usuarioRegistra,verquirofano.getHvqctipoaneste(), verquirofano.getHvqcetapa(), userName());         

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
    }





    /**
     * @return
     */
    public String generarReporte() {

       boolean wexito = true;  
       Cpprofesio anestesiologo = new Cpprofesio();
       Cpprofesio cirujano = new Cpprofesio();
       Cpprofesio enfermero = new Cpprofesio();
       Cpprofesio instrumentador = new Cpprofesio();

       if (!lstPorVerificar.isEmpty()) {
           int consec = 0;
           Chitemvrquir itemvrquiAux;
           Iterator it = lstPorVerificar.iterator();
           while (it.hasNext() && wexito) {
               it.next();
               itemvrquiAux = lstPorVerificar.get(consec);

               if (itemvrquiAux.getId().getHiqnnumeral().intValue() != 0) { 
                   wexito = false;
                   FacesUtils.addErrorMessage("Existen verificaciones pendientes, registrelas primero.");
               }
               consec++;
           }
       }

        if (lstItemverificado == null || lstItemverificado.isEmpty()) {
            wexito = false;
            FacesUtils.addErrorMessage("No existen verificaciones actualmente, registrelas primero.");
        }

        if (wexito && !verquirofano.getHvqcetapa().equals("AS")) { 
            wexito = false;
            FacesUtils.addErrorMessage("El registro no esta en Etapa 'AS' Antes de la Salida.");
        }


        if (wexito) {
            verquirofano.setHvqcimpreso("S");
           
            try {
                if (verquirofano.getHvqnanestesio().intValue() != 0) {
                    anestesiologo = serviceLocator.getClinicoService().getProfesionalPorCodigo(verquirofano.getHvqnanestesio(), cirugia.getHcpnclinica());
                }
                
               if (verquirofano.getHvqncirujano().intValue() != 0) {
                   cirujano = serviceLocator.getClinicoService().getProfesionalPorCodigo(verquirofano.getHvqncirujano(), cirugia.getHcpnclinica());
               }

                if (verquirofano.getHvqnenfermero().intValue() != 0) {
                    enfermero = serviceLocator.getClinicoService().getProfesionalPorCodigo(verquirofano.getHvqnenfermero(), cirugia.getHcpnclinica());
                }

                if (verquirofano.getHvqninstrumen().intValue() != 0) {
                    instrumentador = serviceLocator.getClinicoService().getProfesionalPorCodigo(verquirofano.getHvqninstrumen(), cirugia.getHcpnclinica());
                }

            }
            catch (ModelException e) {
                wexito = false;
                FacesUtils.addInfoMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
        
            try {
               serviceLocator.getCirugiaService().saveVerificacionQuirofano(verquirofano,lstPorVerificar);
                  FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                wexito = false;
                FacesUtils.addInfoMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
       }

       listVerificaciones = new ArrayList();
       File reportFile = null;

        try {
            reportFile = 
                    new File(((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/reports/VerificacionQuirofanoReport.jasper"));

        } catch (Exception e) {
            wexito = false;
            e.printStackTrace();
        }

        if (reportFile.exists()) {
            try {
                //Obtiene las verificaciones realizadas 
                listVerificaciones = 
                        this.serviceLocator.getCirugiaService().getItemVerificadosQuirofano(numerocirugia);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (listVerificaciones == null) {
                FacesUtils.addErrorMessage("Error. No selecciono verificaciones realizadas");
                wexito = false;
            }
        }

        if (wexito) {
            Map parameters = new HashMap();
            byte[] bytes = null;
            try {
                URL imagen = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/comun/imagenes/profamilia_negro.gif");

                parameters.put("IMAGEN", imagen);
                parameters.put("FECHA", verquirofano.getHvqdfecverifi());
                parameters.put("NO_HISTORIA", usuario.getHusanumeiden().toString());
                parameters.put("PER_APELLIDO", usuario.getHuscprimerapel());
                parameters.put("SDO_APELLIDO", usuario.getHuscsegundapel());
                parameters.put("NOMBRES", 
                               usuario.getHuscprimernomb() + " " + usuario.getHuscsegundnomb());
                parameters.put("TIPO_ANESTESIA", verquirofano.getHvqctipoaneste());
                parameters.put("HORA_INGRESO", verquirofano.getHvqchoraingres());
                parameters.put("HORA_SALIDA", verquirofano.getHvqchorasalida());
                parameters.put("OBSERVACION", verquirofano.getHvqcobservac());
                if (verquirofano.getHvqnanestesio().intValue() == 0) {
                    parameters.put("ANESTESIOLOGO", " ");
                } else {
                    parameters.put("ANESTESIOLOGO", anestesiologo.getCpfcnombre());
                }
                if (verquirofano.getHvqncirujano().intValue() == 0) {
                    parameters.put("CIRUJANO", " ");
                } else {
                    parameters.put("CIRUJANO", cirujano.getCpfcnombre());
                }
                if (verquirofano.getHvqnenfermero().intValue() == 0) {
                    parameters.put("ENFERMERO", " ");
                } else {
                    parameters.put("ENFERMERO", enfermero.getCpfcnombre());
                }
                if (verquirofano.getHvqninstrumen().intValue() == 0) {
                    parameters.put("INSTRUMENTADOR", " ");
                } else {
                    parameters.put("INSTRUMENTADOR", instrumentador.getCpfcnombre());
                }

                bytes = 
                         JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, this);
                PdfServletUtils.showPdfDocument(bytes, "VerificarQuirofanoReport.pdf", 
                                                    false);
                                                    
                generoReporte = true;

             
                } catch (Exception ex) {
                    ex.printStackTrace();
                    FacesUtils.addErrorMessage("No pudo generar reporte Verificaci�n Quirofano. " + 
                                               ex.getMessage());
                  
                }
        }

        return BeanNavegacion.RUTA_ACTUAL;
       
    }


        public void setUsuario(Chusuario usuario) {
            this.usuario = usuario;
        }

        public Chusuario getUsuario() {
            return usuario;
        }

    public void setListVerificaciones(List<Chitemvrquir> listVerificaciones) {
        this.listVerificaciones = listVerificaciones;
    }

    public List<Chitemvrquir> getListVerificaciones() {
        return listVerificaciones;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
    }

    public void setUsuarioRegistra(String usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public String getUsuarioRegistra() {
        return usuarioRegistra;
    }

    /**
        * @param lstAnesteciologo
        */
       public void setLstAnestesiologo(List lstAnestesiologo) {
           this.lstAnestesiologo = lstAnestesiologo;
       }

       /**
        * @return
        */
       public List getLstAnestesiologo() {
           if (lstAnestesiologo == null || lstAnestesiologo.isEmpty()) {
               lstAnestesiologo = new ArrayList(); 
               ArrayList<Cpprofesio> listAnestesiologoAux = null;
               try {
                   listAnestesiologoAux = 
//                           (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_ANESTESIOLOGO);
                             (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_CIRUJANO);
               } catch (ModelException e) {
                   e.printStackTrace();
               }

               if (listAnestesiologoAux != null && !listAnestesiologoAux.isEmpty()) {

                   Iterator it = listAnestesiologoAux.iterator();
                   int i = 0;
                   lstAnestesiologo.add(new SelectItem("", 
                                                       "Seleccione una opci�n ..."));
                   while (it.hasNext()) {
                       it.next();
                       lstAnestesiologo.add(new SelectItem(listAnestesiologoAux.get(i).getId().getCpfncodigo(), 
                                                           listAnestesiologoAux.get(i).getCpfcnombre()));
                       i++;
                   }
               }
           }

           return lstAnestesiologo;
       }

    /**
        * @param lstCirujano
        */
       public void setLstCirujano(List lstCirujano) {
           this.lstCirujano = lstCirujano;
       }

       /**
        * @return
        */
       public List getLstCirujano() {
           if (lstCirujano == null || lstCirujano.isEmpty()) {
               lstCirujano = new ArrayList(); 
               ArrayList<Cpprofesio> listCirujanoAux = null;
               try {
                   listCirujanoAux = 
                           (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_CIRUJANO);
               } catch (ModelException e) {
                   e.printStackTrace();
               }

               if (listCirujanoAux != null && !listCirujanoAux.isEmpty()) {

                   Iterator it = listCirujanoAux.iterator();
                   int i = 0;
                   lstCirujano.add(new SelectItem("", 
                                                       "Seleccione una opci�n ..."));
                   while (it.hasNext()) {
                       it.next();
                       lstCirujano.add(new SelectItem(listCirujanoAux.get(i).getId().getCpfncodigo(), 
                                                           listCirujanoAux.get(i).getCpfcnombre()));
                       i++;
                   }
               }
           }

           return lstCirujano;
       }

    /**
        * @param lstEnfermera
        */
       public void setLstEnfermera(List lstEnfermera) {
           this.lstEnfermera = lstEnfermera;
       }

       /**
        * @return
        */
       public List getLstEnfermera() {
           if (lstEnfermera == null || lstEnfermera.isEmpty()) {
               lstEnfermera = new ArrayList(); 
               ArrayList<Cpprofesio> listEnfermeraAux = null;
               try {
                   listEnfermeraAux = 
//                           (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_ENFERMERA);
                             (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_CIRUJANO);
               } catch (ModelException e) {
                   e.printStackTrace();
               }

               if (listEnfermeraAux != null && !listEnfermeraAux.isEmpty()) {

                   Iterator it = listEnfermeraAux.iterator();
                   int i = 0;
                   lstEnfermera.add(new SelectItem("", 
                                                       "Seleccione una opci�n ..."));
                   while (it.hasNext()) {
                       it.next();
                       lstEnfermera.add(new SelectItem(listEnfermeraAux.get(i).getId().getCpfncodigo(), 
                                                           listEnfermeraAux.get(i).getCpfcnombre()));
                       i++;
                   }
               }
           }

           return lstEnfermera;
       }
       
       

    /**
        * @param lstAnesteciologo
        */
       public void setLstInstrumentador(List lstInstrumentador) {
           this.lstInstrumentador = lstInstrumentador;
       }

       /**
        * @return
        */
       public List getLstInstrumentador() {
           if (lstInstrumentador == null || lstInstrumentador.isEmpty()) {
               lstInstrumentador = new ArrayList(); 
               ArrayList<Cpprofesio> listInstrumentadorAux = null;
               try {
                   listInstrumentadorAux = 
//                           (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_INSTRUMENTADOR);
                             (ArrayList<Cpprofesio>)this.serviceLocator.getCirugiaService().getListaProfesionalPorEspecialidad(getClinica().getCclncodigo(),IConstantes.ESPECIALIDAD_CIRUJANO);
               } catch (ModelException e) {
                   e.printStackTrace();
               }

               if (listInstrumentadorAux != null && !listInstrumentadorAux.isEmpty()) {

                   Iterator it = listInstrumentadorAux.iterator();
                   int i = 0;
                   lstInstrumentador.add(new SelectItem("", 
                                                       "Seleccione una opci�n ..."));
                   while (it.hasNext()) {
                       it.next();
                       lstInstrumentador.add(new SelectItem(listInstrumentadorAux.get(i).getId().getCpfncodigo(), 
                                                           listInstrumentadorAux.get(i).getCpfcnombre()));
                       i++;
                   }
               }
           }

           return lstInstrumentador;
       }

    //-----------------------------------------------------------------------
    //  CLASES AUXILIARES
    //-----------------------------------------------------------------------

    /**
     * Implementaci�n interna de la interfaz JRDataSource que mapea las variables
     * del reporte a la informaci�n del bean
     */
    public

    boolean next() {
       return (index++ < listVerificaciones.size());
    }

    public Object getFieldValue(JRField jrField) {
        String fieldName = jrField.getName();
        
        Chitemvrquir itemvrquir = (Chitemvrquir)(listVerificaciones.get(index-1));
        String titulo = "";
        String dtitulo = "";
        if ("ABCD".contains(itemvrquir.getId().getHiqcliteral())) {
            titulo = "1";
            dtitulo = "PAUSA ANTES DE LA ADMINISTRACI�N DE ANESTESIA";
        } else if ("EFGHIJ".contains(itemvrquir.getId().getHiqcliteral()))  {
            titulo = "2";
            dtitulo = "PAUSA ANTES DE LA INSICI�N CUTANEA";
        } else if ("KLM".contains(itemvrquir.getId().getHiqcliteral())) {
            titulo = "3";
            dtitulo = "PAUSA ANTES DE QUE PACIENTE SALGA DEL QUIR�FANO";
        } else {
            titulo = " ";
            dtitulo = " ";
        }
        if (fieldName.equals("titulo")) {
            return titulo;
        }
        if (fieldName.equals("dtitulo")) {
            return dtitulo;
        }
        if (fieldName.equals("literal")) {
            return itemvrquir.getId().getHiqcliteral();
        }
        if (fieldName.equals("numeral")) {
            return itemvrquir.getId().getHiqnnumeral();
        }
        if (fieldName.equals("descri")) {
            return itemvrquir.getHiqcdescri();
        }
        if (fieldName.equals("respuesta")) {
            return itemvrquir.getHiqcrespuesta();
        }
        return null;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getEtapa() {
        return etapa;
    }
}


