//=======================================================================
// ARCHIVO RegistrarMedicamentoAnestesiaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis, andres.vargas
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.ChcontmedanePK;
import org.profamilia.hc.model.dto.Chunidades;
import org.profamilia.hc.model.dto.Chvademecum;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorMedicamentoBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarMedicamentoAnestesiaBean
//=======================================================================
public class RegistrarMedicamentoAnestesiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chcontmedane medicamento;

    private List<Chcontmedane> lstMedicamento;

    private List<Chcontmedane> lstSaveMedicamento;


    private boolean mostrarintravenosa;

    private boolean mostrarlocal;

    private boolean mostrarotra;

    private List lstUnidades;

    private List lstViaAdministracion;

    private List listHora;

    private List lstMinutos;

    private List lstTipoIntravenosa;

    private Integer horaadministracion;

    private Integer minutoadministracion;

    private boolean mostrarcantidad;

    private HtmlDataTable dtMedicamento;

    private Long numeroCirugia;

    private String tipoServicio;

    private List lstVademecum;

    private List lstVademecumTotal;

    private List lstVademecumm;

    private List<Chvademecum> lstInicialVademecum;

    private List<Chcontmedane> lstAdicionarMedicamento;

    private String navigationRule;

    private List lstUnidadesPeso;

    private boolean mostrarViaAdministracion;

    private boolean mostrarFormAdministracion;

    private boolean mostrarFormAdministracionTable;

    private boolean mostrarViaAdministracionTable;

    private boolean mostrarLocal;

    private boolean mostrarLocalTable;

    private boolean mostrarOtra;

    private String medicamentoViaAdmini;

    private String medicamentoFormaAdmini;

    private String medicamentoUnidad;

    private UIInput mnuViaAdministracion;

    private UIInput radioFormaAdministracion;

    private BigDecimal totalMedicamento;

    private List lstOpciones;

    private boolean mostrarMedicamentoAnes;

    private UIInput radioMedicamentoAnes;

    private boolean mostrarMedicamentoNoAnes;

    /** Variable que almacena el Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica */
    private String medicamentoSelect;

    /** Variable que almacena el Nombre Generico del Medicamento Concentraci�n/ forma farmac�utica */
    private String medicamentoo;

    private UIInput itMedicamento;

    private boolean deshabilitarMedicamento;

    private boolean renderBuscador;

    private int selectedIndex;

    private static final int ACTIVAR_FORMULA_MEDICA = 0;

    private static final int ACTIVAR_BUSCADOR = 1;

    private Integer medicamentoSelectCodigo;

    private List<Chvademecum> vadecum;

    private String viaAdmin;
    
    private boolean flagCostos;
    
    private List<Chvademprof>lstChvademprof;
    
    private HtmlDataTable dtServiciosCostos;
    
    


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarMedicamentoAnestesiaBean() {
    }

    public void init() {
        medicamento = new Chcontmedane();
        lstUnidades = new ArrayList();
        lstViaAdministracion = new ArrayList();
        lstUnidadesPeso = new ArrayList();
        listHora = new ArrayList();
        lstMinutos = new ArrayList();
        lstTipoIntravenosa = new ArrayList();
        dtMedicamento = new HtmlDataTable();
        mostrarViaAdministracion = false;
        mostrarViaAdministracionTable = false;
        mostrarFormAdministracionTable = false;
        mostrarLocalTable = false;
        mostrarFormAdministracion = false;
        mostrarLocal = false;
        mostrarOtra = false;
        mostrarMedicamentoAnes = false;
        mostrarMedicamentoNoAnes = false;
        flagCostos = activarFuncionalidadCostos();
        cargarDatos();
    }


    public void cargarDatos() {
        String esAnestesia = "";
        esAnestesia = "S";

        if (numeroCirugia != null && tipoServicio != null) {
            try {
            if(!flagCostos){
                lstMedicamento = 
                        this.serviceLocator.getClinicoService().getMedicamentosAnestesia(numeroCirugia, 
                                                                                         tipoServicio);
            }
                   if(flagCostos) {                                                            
                    lstMedicamento = this.serviceLocator.getCostosService().getMedicamentosAnestesiaInsumo(numeroCirugia,tipoServicio);
                   }

                if(!flagCostos){
                    lstInicialVademecum = 
                        this.serviceLocator.getCirugiaService().getIniciaVademecumAnestesia();
                        
                } 
                if(flagCostos){
                    lstChvademprof = 
                        this.serviceLocator.getCostosService().getIniciaVademecumAnestesia();
                        if(lstInicialVademecum!=null && !lstInicialVademecum.isEmpty()){
                            
                        }
                }
                


            } catch (ModelException e) {
                e.printStackTrace();
            }

        if(!flagCostos){
            if (lstMedicamento == null || lstMedicamento.isEmpty()) {
                lstMedicamento = new ArrayList<Chcontmedane>();
                if (lstInicialVademecum != null && 
                    !lstInicialVademecum.isEmpty()) {
                    for (Chvademecum vademecum: lstInicialVademecum) {
                        medicamento = new Chcontmedane();
                        medicamento.getId().setHmactiposerv(TIPO_HOSPITALIZACION);
                        medicamento.getId().setHmalconsulta(numeroCirugia);
                        medicamento.setHmacmedicament(vademecum.getHvdcprincactiv());
                        medicamento.setHmancodigvadem(vademecum.getHvdnconsecutiv());
                        medicamento.setHmacetapa(ETAPA_VIGENTE);
                        medicamento.setHmaninduccion(new BigDecimal(0));
                        medicamento.setHmanmantenimie(new BigDecimal(0));
                        medicamento.setHmacunidapeso(vademecum.getHvdcunidad());
                        medicamento.setHmacviaadmini(vademecum.getHvdcviaadmini());
                        medicamento.setHmacformadmi(vademecum.getHvdcformadmi());
                        medicamento.setHmadfecregistr(new Date());
                        medicamento.setHmacoperador(userName());
                        lstMedicamento.add(medicamento);
                    }
                }

            }
        }
        else{
            if (lstMedicamento == null || lstMedicamento.isEmpty()) {
                lstMedicamento = new ArrayList<Chcontmedane>();
                if (lstChvademprof != null && 
                    !lstChvademprof.isEmpty()) {
                    for (Chvademprof vademecum: lstChvademprof) {
                        medicamento = new Chcontmedane();
                        medicamento.getId().setHmactiposerv(TIPO_HOSPITALIZACION);
                        medicamento.getId().setHmalconsulta(numeroCirugia);
                        medicamento.setHmacmedicament(vademecum.getHvpcprincactiv());
                        medicamento.setHmancodigvadem(vademecum.getHvpnconsecutiv());
                        medicamento.setHmacetapa(ETAPA_VIGENTE);
                        medicamento.setHmaninduccion(new BigDecimal(0));
                        medicamento.setHmanmantenimie(new BigDecimal(0));
                        medicamento.setHmacunidapeso(vademecum.getHvpcunidmedi());
                        medicamento.setHmacviaadmini(vademecum.getHvpcviaadmo());
                        medicamento.setHmacformadmi(vademecum.getHvpcformadmi());
                        medicamento.setHmadfecregistr(new Date());
                        medicamento.setHmacoperador(userName());
                        medicamento.setFichaTecnicaCostosDTO(vademecum.getFichaTecnica());
                        lstMedicamento.add(medicamento);
                    }
                }

            }
        }


            if (lstAdicionarMedicamento == null || 
                lstAdicionarMedicamento.isEmpty()) {
                lstAdicionarMedicamento = new ArrayList<Chcontmedane>();

                medicamento = new Chcontmedane();
                medicamento.getId().setHmactiposerv(TIPO_HOSPITALIZACION);
                medicamento.getId().setHmalconsulta(numeroCirugia);
                medicamento.setHmacmedicament(null);
                medicamento.setHmacetapa(ETAPA_VIGENTE);
                medicamento.setHmaninduccion(new BigDecimal(0));
                medicamento.setHmanmantenimie(new BigDecimal(0));
                medicamento.setHmadfecregistr(new Date());
                medicamento.setHmacoperador(userName());
                lstAdicionarMedicamento.add(medicamento);
            }

        }


    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param medicamento
     */
    public void setMedicamento(Chcontmedane medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * @return
     */
    public Chcontmedane getMedicamento() {
        return medicamento;
    }

    /**
     * @param mostrarintravenosa
     */
    public void setMostrarintravenosa(boolean mostrarintravenosa) {
        this.mostrarintravenosa = mostrarintravenosa;
    }

    /**
     * @return
     */
    public boolean isMostrarintravenosa() {
        return mostrarintravenosa;
    }

    /**
     * @param mostrarlocal
     */
    public void setMostrarlocal(boolean mostrarlocal) {
        this.mostrarlocal = mostrarlocal;
    }

    /**
     * @return
     */
    public boolean isMostrarlocal() {
        return mostrarlocal;
    }

    /**
     * @param mostrarotra
     */
    public void setMostrarotra(boolean mostrarotra) {
        this.mostrarotra = mostrarotra;
    }

    /**
     * @return
     */
    public boolean isMostrarotra() {
        return mostrarotra;
    }

    /**
     * @param lstUnidades
     */
    public void setLstUnidades(List lstUnidades) {
        this.lstUnidades = lstUnidades;
    }

    /**
     * @param dtMedicamento
     */
    public void setDtMedicamento(HtmlDataTable dtMedicamento) {
        this.dtMedicamento = dtMedicamento;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtMedicamento() {
        return dtMedicamento;
    }

    /**
     * @param lstMedicamento
     */
    public void setLstMedicamento(List<Chcontmedane> lstMedicamento) {
        this.lstMedicamento = lstMedicamento;
    }

    /**
     * @return
     */
    public List<Chcontmedane> getLstMedicamento() {
        return lstMedicamento;
    }

    /**
     * @return
     */
    public List getLstUnidades() {
        if (lstUnidades.size() == 0) {
            ArrayList<Chunidades> lstUnidadesAux = null;
            try {
                lstUnidadesAux = 
                        (ArrayList<Chunidades>)this.serviceLocator.getClinicoService().getUnidadesDosis();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstUnidadesAux.isEmpty()) {
                lstUnidades.add(new SelectItem("", "Seleccione..."));
                Iterator it = lstUnidadesAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstUnidades.add(new SelectItem(lstUnidadesAux.get(i).getHunccodigo(), 
                                                   lstUnidadesAux.get(i).getHuncdescripcio()));
                    i++;
                }
            }
        }

        return lstUnidades;
    }


    /**
     * @param lstViaAdministracion
     */
    public void setLstViaAdministracion(List lstViaAdministracion) {
        this.lstViaAdministracion = lstViaAdministracion;
    }

    /**
     * @return
     */
    public List getLstViaAdministracion() {
        if (lstViaAdministracion.size() == 0) {
            lstViaAdministracion.add(new SelectItem("", "Seleccione..."));
            lstViaAdministracion.add(new SelectItem("IV", "Intravenosa"));
            lstViaAdministracion.add(new SelectItem("IM", "Intramuscular"));
            lstViaAdministracion.add(new SelectItem("SC", "Subcut�nea"));
            lstViaAdministracion.add(new SelectItem("PE", "Peridural"));
            lstViaAdministracion.add(new SelectItem("SU", "Subaracniodea"));
            lstViaAdministracion.add(new SelectItem("LO", "Local"));
            lstViaAdministracion.add(new SelectItem("OT", "Otra"));
        }
        return lstViaAdministracion;
    }

    /**
     * @return
     */
    public List getListHora() {
        if (listHora.size() == 0) {
            listHora.add(new SelectItem("", "--"));
            listHora.add(new SelectItem(6, "06"));
            listHora.add(new SelectItem(7, "07"));
            listHora.add(new SelectItem(8, "08"));
            listHora.add(new SelectItem(9, "09"));
            listHora.add(new SelectItem(10, "10"));
            listHora.add(new SelectItem(11, "11"));
            listHora.add(new SelectItem(12, "12"));
            listHora.add(new SelectItem(13, "13"));
            listHora.add(new SelectItem(14, "14"));
            listHora.add(new SelectItem(15, "15"));
            listHora.add(new SelectItem(16, "16"));
            listHora.add(new SelectItem(17, "17"));
            listHora.add(new SelectItem(18, "18"));
            listHora.add(new SelectItem(19, "19"));
            listHora.add(new SelectItem(20, "20"));

        }
        return listHora;
    }


    /**
     * @param listHora
     */
    public void setListHora(List listHora) {
        this.listHora = listHora;
    }


    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
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
     * @param lstMinutos
     */
    public void setLstMinutos(List lstMinutos) {
        this.lstMinutos = lstMinutos;
    }


    /**
     * @return
     */
    public List getLstMinutos() {
        if (lstMinutos.size() == 0) {
            lstMinutos.add(new SelectItem("", "--"));
            lstMinutos.add(new SelectItem(00, "00"));
            lstMinutos.add(new SelectItem(05, "05"));
            lstMinutos.add(new SelectItem(10, "10"));
            lstMinutos.add(new SelectItem(15, "15"));
            lstMinutos.add(new SelectItem(20, "20"));
            lstMinutos.add(new SelectItem(25, "25"));
            lstMinutos.add(new SelectItem(30, "30"));
            lstMinutos.add(new SelectItem(35, "35"));
            lstMinutos.add(new SelectItem(40, "40"));
            lstMinutos.add(new SelectItem(45, "45"));
            lstMinutos.add(new SelectItem(50, "50"));
            lstMinutos.add(new SelectItem(55, "55"));
        }
        return lstMinutos;
    }

    /**
     * @param horaadministracion
     */
    public void setHoraadministracion(Integer horaadministracion) {
        this.horaadministracion = horaadministracion;
    }

    /**
     * @return
     */
    public Integer getHoraadministracion() {
        return horaadministracion;
    }

    /**
     * @param minutoadministracion
     */
    public void setMinutoadministracion(Integer minutoadministracion) {
        this.minutoadministracion = minutoadministracion;
    }

    /**
     * @return
     */
    public Integer getMinutoadministracion() {
        return minutoadministracion;
    }

    /**
     * @param lstTipoIntravenosa
     */
    public void setLstTipoIntravenosa(List lstTipoIntravenosa) {
        this.lstTipoIntravenosa = lstTipoIntravenosa;
    }

    /**
     * @return
     */
    public List getLstTipoIntravenosa() {
        if (lstTipoIntravenosa.size() == 0) {


            lstTipoIntravenosa.add(new SelectItem("", "Seleccione..."));
            lstTipoIntravenosa.add(new SelectItem("BO", "Bolo"));
            lstTipoIntravenosa.add(new SelectItem("IM", 
                                                  "Infusi�n en minutos"));
            lstTipoIntravenosa.add(new SelectItem("IC", "Infusi�n continua"));

        }
        return lstTipoIntravenosa;
    }

    /**
     * @param mostrarcantidad
     */
    public void setMostrarcantidad(boolean mostrarcantidad) {
        this.mostrarcantidad = mostrarcantidad;
    }

    /**
     * @return
     */
    public boolean isMostrarcantidad() {
        return mostrarcantidad;
    }

    /**
     * @param lstInicialVademecum
     */
    public void setLstInicialVademecum(List<Chvademecum> lstInicialVademecum) {
        this.lstInicialVademecum = lstInicialVademecum;
    }

    /**
     * @return
     */
    public List<Chvademecum> getLstInicialVademecum() {
        return lstInicialVademecum;
    }


    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------


    /**
     * @param lstAdicionarMedicamento
     */
    public void setLstAdicionarMedicamento(List<Chcontmedane> lstAdicionarMedicamento) {
        this.lstAdicionarMedicamento = lstAdicionarMedicamento;
    }

    /**
     * @return
     */
    public List<Chcontmedane> getLstAdicionarMedicamento() {
        return lstAdicionarMedicamento;
    }


    /**
     * @param lstVademecum
     */
    public void setLstVademecum(List lstVademecum) {
        this.lstVademecum = lstVademecum;
    }

    /**
     * @return
     */
    public List getLstVademecum() {
        if (lstVademecum == null || lstVademecum.isEmpty()) {
            lstVademecum = new ArrayList();
            ArrayList<Chvademecum> listVademecumAux = null;
            try {
                listVademecumAux = 
                        (ArrayList<Chvademecum>)this.serviceLocator.getCirugiaService().getVademecumAnestesia();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listVademecumAux.isEmpty()) {
                lstVademecum.add(new SelectItem("", "Seleccione..."));
                Iterator it = listVademecumAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstVademecum.add(new SelectItem(listVademecumAux.get(i).getHvdnconsecutiv(), 
                                                    listVademecumAux.get(i).getHvdcprincactiv()));
                    i++;

                }
            }
        }
        return lstVademecum;
    }


    public void setLstVademecumTotal(List lstVademecumTotal) {
        this.lstVademecumTotal = lstVademecumTotal;
    }

    public List getLstVademecumTotal() {
        if (lstVademecumTotal == null || lstVademecumTotal.isEmpty()) {
            lstVademecumTotal = new ArrayList();
            ArrayList<Chvademecum> listVademecumTotalAux = null;
            try {
                listVademecumTotalAux = 
                        (ArrayList<Chvademecum>)this.serviceLocator.getCirugiaService().getVademecumAnestesiaTotal();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listVademecumTotalAux.isEmpty()) {
                lstVademecumTotal.add(new SelectItem("", "Seleccione..."));
                Iterator it = listVademecumTotalAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstVademecumTotal.add(new SelectItem(listVademecumTotalAux.get(i).getHvdnconsecutiv(), 
                                                         listVademecumTotalAux.get(i).getHvdcprincactiv()));
                    i++;

                }
            }
        }
        return lstVademecumTotal;
    }


    private boolean validarCamposRequeridos() {
        boolean wexito;
        wexito = true;


        if (medicamento != null && medicamento.getHmaninduccion() != null && 
            (medicamento.getHmaninduccion().compareTo(new BigDecimal(10000)) >= 
             0)) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:itInduccion", 
                                       MSG_VALOR_CAMPO_INCORRECTO);
        }

        if (medicamento != null && medicamento.getHmanmantenimie() != null && 
            (medicamento.getHmanmantenimie().compareTo(new BigDecimal(10000)) >= 
             0)) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:itMantenimiento", 
                                       MSG_VALOR_CAMPO_INCORRECTO);
        }


        /*  if (medicamento == null || medicamento.getHmacmedicament() == null ||
            medicamento.getHmacmedicament().equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:itMedicamento",
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (medicamento == null || medicamento.getHmacunidades() == null ||
            medicamento.getHmacunidades().equals("")) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:mnuUnidades",
                                       MSG_CAMPO_OBLIGATORIO);
        }*/


        /*    if (medicamento == null || medicamento.getHmadhoraadmini() == null) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:fechaAdministracion",
                                       MSG_CAMPO_OBLIGATORIO);
        }


        if (horaadministracion == null) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:mnuHoraAdministracion",
                                       MSG_CAMPO_OBLIGATORIO);
        }

        if (minutoadministracion == null) {
            wexito = false;
            FacesUtils.addErrorMessage("body:formControlMedicamentos:panelTabPrescripcionHospitalizacion:mnuMinutosAdministracion",
                                       MSG_CAMPO_OBLIGATORIO);
        }*/


        return wexito;
    }


    public void agregarMedicamento() {
        boolean wexito = true;


        wexito = validarCamposRequeridos();
        ChcontmedanePK idMedicamento;
        idMedicamento = new ChcontmedanePK();
        Chcontmedane medicamentoAux = null;

        medicamentoAux = new Chcontmedane();

        // VERIFICAMOS SI EL MEDICAMENTO YA EXISTE EN LA LISTA PARA NO DEJARLO INGRESAR


        if (wexito) {
            if (medicamento != null && 
                medicamento.getHmadhoraadmini() != null && 
                horaadministracion != null && minutoadministracion != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(medicamento.getHmadhoraadmini());
                fechaaux.set(Calendar.HOUR, horaadministracion);
                fechaaux.set(Calendar.MINUTE, minutoadministracion);
                medicamento.setHmadhoraadmini(fechaaux.getTime());
            }

            idMedicamento.setHmactiposerv(tipoServicio);
            idMedicamento.setHmalconsulta(numeroCirugia);
            medicamento.setId(idMedicamento);
            medicamento.setHmacetapa(ETAPA_VIGENTE);
            medicamento.setHmacoperador(userName());
            medicamento.setHmadfecregistr(new Date());


            medicamentoAux.setId(medicamento.getId());
            medicamentoAux.setHmacetapa(medicamento.getHmacetapa());

            medicamentoAux.setHmacmedicament(medicamento.getHmacmedicament());
            medicamentoAux.setHmacoperador(medicamento.getHmacoperador());
            medicamentoAux.setHmacunidades(medicamento.getHmacunidades());
            medicamentoAux.setHmadfecregistr(medicamento.getHmadfecregistr());
            medicamentoAux.setHmadhoraadmini(medicamento.getHmadhoraadmini());
            if (medicamento.getHmancodigvadem() != null) {
                medicamentoAux.setHmancodigvadem(medicamento.getHmancodigvadem());
            } else {
                medicamentoAux.setHmancodigvadem(medicamentoSelectCodigo);
            }
            medicamentoAux.setHmaninduccion(medicamento.getHmaninduccion());
            medicamentoAux.setHmanmantenimie(medicamento.getHmanmantenimie());


            medicamentoAux.setHmacunidapeso(medicamento.getHmacunidapeso());
            medicamentoAux.setHmacdesunidades(medicamento.getHmacunidapeso());


            medicamentoAux.setHmacformadmi(medicamento.getHmacformadmi());
            medicamentoAux.setHmacformdosis(medicamento.getHmacformdosis());
            medicamentoAux.setHmacviaadlocal(medicamento.getHmacviaadlocal());


            medicamentoAux.setHmacviaadmini(medicamento.getHmacviaadmini());


            medicamentoAux.setHmacviaadotra(medicamento.getHmacviaadotra());
            
            if(medicamento.getHmanmantenimie() != null && medicamento.getHmaninduccion() != null)  {
                medicamentoAux.setHmantotalinma(medicamento.getHmaninduccion().add(medicamento.getHmanmantenimie()));    
            }
            


            lstMedicamento.add(medicamentoAux);


            medicamentoAux = new Chcontmedane();


            medicamento = new Chcontmedane();
            medicamentoUnidad = null;
            medicamentoFormaAdmini = null;
            medicamentoViaAdmini = null;
            radioFormaAdministracion.setValue(null);
            mnuViaAdministracion.setValue(null);
            medicamento.setHmaninduccion(null);
            medicamento.setHmanmantenimie(null);
            medicamento.setHmancodigvadem(null);
            medicamento.setHmacunidapeso(null);
            medicamento.setHmacformadmi(null);
            medicamento.setHmacformdosis(null);
            medicamento.setHmacviaadmini(null);
            medicamento.setHmacviaadlocal(null);
            medicamento.setHmacviaadotra(null);
            medicamentoSelectCodigo = 0;
            medicamentoSelect = null;


            mostrarcantidad = false;
            mostrarintravenosa = false;
            mostrarOtra = false;
            minutoadministracion = null;
            horaadministracion = null;
            mostrarFormAdministracion = false;
            mostrarLocal = false;
            mostrarViaAdministracion = false;


        }
    }

    public void aceptarMedicamento() {
        BuscadorMedicamentoBean medicamentoAux = 
            (BuscadorMedicamentoBean)FacesUtils.getManagedBean("buscadorMedicamentoBean");
        if (medicamentoAux != null && 
            medicamentoAux.getMedicamentoSelect() != null) {
            itMedicamento.setValue(medicamentoAux.getMedicamentoSelect().getHvpcprincactiv());

            medicamentoSelect = 
                    medicamentoAux.getMedicamentoSelect().getHvpcprincactiv();
            medicamentoSelectCodigo = 
                    medicamentoAux.getMedicamentoSelect().getHvpnconsecutiv();
            deshabilitarMedicamento = true;

        }
        selectedIndex = ACTIVAR_FORMULA_MEDICA;
        renderBuscador = false;
        FacesUtils.resetManagedBean("buscadorMedicamentoBean");
    }

    public void renderMedicamentos() {
        renderBuscador = true;
        selectedIndex = ACTIVAR_BUSCADOR;
    }


    public void eliminarMedicamento() {
        Chcontmedane medicamentoDelete;
        medicamentoDelete = null;
        medicamentoDelete = (Chcontmedane)this.dtMedicamento.getRowData();
        if (medicamentoDelete != null) {
            lstMedicamento.remove(medicamentoDelete);
        }
    }
    //-----------------------------------------------------------------------
    //  Boton Principal 
    //----------------------------------------------------------------------- 


    public String guardarControlMedicamento() {
        Integer numeroVademecum;
        navigationRule = "";
        lstSaveMedicamento = new ArrayList<Chcontmedane>();


        if (lstMedicamento != null && !lstMedicamento.isEmpty()) {
            for (Chcontmedane medAux: lstMedicamento) {
                if (medAux.getHmancodigvadem() != null) {
                    numeroVademecum = medAux.getHmancodigvadem();
                    try {
                        vadecum = 
                                this.serviceLocator.getCirugiaService().getVademecumCodigo(numeroVademecum);
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    for (Chvademecum cahva: vadecum) {
                        medAux.setHmacmedicament(cahva.getHvdcprincactiv());
                    }
                }
                lstSaveMedicamento.add(medAux);
            }
        }


        if (lstSaveMedicamento != null && !lstSaveMedicamento.isEmpty()) {


            try {
                this.serviceLocator.getClinicoService().saveMedicamentosAnestesia(lstSaveMedicamento, 
                                                                                  numeroCirugia, 
                                                                                  tipoServicio);
                FacesUtils.addInfoMessage(MSG_ADICION);
                navigationRule = "irRegistrarViaAereaAnestesia";

            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + e.getMessage());
                e.printStackTrace();

            } catch (Exception ex) {
                FacesUtils.addErrorMessage(MSG_NO_ADICION + ex.getMessage());
                ex.printStackTrace();

            }
        } else {
            FacesUtils.addErrorMessage(MSG_VALIDACION_LISTA_VACIA_PRESCRIPCION);
        }

        return navigationRule;

    }


    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setViaAdministracion(ValueChangeEvent valueChangeEvent) {
        medicamento.setHmacviaadmini((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setFormaAdministracion(ValueChangeEvent valueChangeEvent) {
        medicamento.setHmacformadmi((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setMedicamentoAnestesia(ValueChangeEvent valueChangeEvent) {
        medicamento.setHmacmedicamento((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    

    /**
     * @param valueChangeEvent
     */
    public void setMedicamentoo(ValueChangeEvent valueChangeEvent) {
        setMedicamentoo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeViaAdministracionTable() {
        Chcontmedane medicamentoSelected;
        medicamentoSelected = null;
        medicamentoSelected = (Chcontmedane)this.dtMedicamento.getRowData();


        if (medicamentoSelected.getHmacviaadmini() != null && 
            medicamentoSelected.getHmacviaadmini().equals("IV")) {
            mostrarViaAdministracionTable = true;
            mostrarFormAdministracionTable = false;
            mostrarLocalTable = false;
        } else if (medicamentoSelected.getHmacviaadmini() != null && 
                   medicamentoSelected.getHmacviaadmini().equals("LO")) {
            mostrarLocalTable = true;
            mostrarViaAdministracionTable = false;
            mostrarFormAdministracionTable = false;


        } else {
            mostrarViaAdministracionTable = false;
            mostrarFormAdministracionTable = false;
            mostrarLocalTable = false;
        }


    }

    public void ChangeFormAdministracionTable() {

        Chcontmedane medicamentoSelected;
        medicamentoSelected = null;
        medicamentoSelected = (Chcontmedane)this.dtMedicamento.getRowData();

        if (medicamentoSelected.getHmacformadmi() != null && 
            medicamentoSelected.getHmacformadmi().equals("IC")) {
            mostrarFormAdministracionTable = true;

        } else {
            mostrarFormAdministracionTable = false;


        }
    }
    
    public void eliminarRegistro() {
        Chcontmedane medicamentoSelected = (Chcontmedane)dtMedicamento.getRowData();
        lstMedicamento.remove(medicamentoSelected);

    }



    public void ChangeViaAdministracion() {
        if (medicamento.getHmacviaadmini() != null && 
            medicamento.getHmacviaadmini().equals("IV")) {
            mostrarViaAdministracion = true;
            mostrarLocal = false;
            mostrarOtra = false;


        } else if (medicamento.getHmacviaadmini() != null && 
                   medicamento.getHmacviaadmini().equals("LO")) {
            mostrarLocal = true;
            mostrarViaAdministracion = false;
            mostrarOtra = false;

        } else if (medicamento.getHmacviaadmini() != null && 
                   medicamento.getHmacviaadmini().equals("OT")) {
            mostrarOtra = true;
            mostrarViaAdministracion = false;
            mostrarLocal = false;

        } else {
            mostrarViaAdministracion = false;
            mostrarLocal = false;
            mostrarOtra = false;


        }
    }

    public void ChangeFormAdministracion() {
        if (medicamento.getHmacformadmi() != null && 
            medicamento.getHmacformadmi().equals("IC")) {
            mostrarFormAdministracion = true;

        } else {
            mostrarFormAdministracion = false;


        }
    }


    public void ChangeMedicamentoAnestesia() {
        if (medicamento.getHmacmedicamento() != null && 
            medicamento.getHmacmedicamento().equals("S")) {
            mostrarMedicamentoAnes = true;
            mostrarMedicamentoNoAnes = false;

        } else {
            mostrarMedicamentoAnes = false;
            mostrarMedicamentoNoAnes = true;


        }
    }


    public void setLstUnidadesPeso(List lstUnidadesPeso) {
        this.lstUnidadesPeso = lstUnidadesPeso;
    }

    public List getLstUnidadesPeso() {

        if (lstUnidadesPeso.size() == 0) {
            lstUnidadesPeso.add(new SelectItem("", "Seleccione..."));
            lstUnidadesPeso.add(new SelectItem("GR", "Gramos"));
            lstUnidadesPeso.add(new SelectItem("ML", "Miligramos"));
            lstUnidadesPeso.add(new SelectItem("MC", "Microgramos"));
            lstUnidadesPeso.add(new SelectItem("UN", "Unidades"));
        }

        return lstUnidadesPeso;
    }
    public String changeListaServicio(){       
       for(int i = 0;i < lstChvademprof.size();i++){
           if(("S").equals(lstChvademprof.get(i).getFichaTecnica().getTrazador()) ){
             List<String>aux;
             try {
                 aux = serviceLocator.getCostosService().geLstLotesByCodigo(lstChvademprof.get(i).getHvpccodisap());
                 if(aux !=null){
                     List<SelectItem>lotes = new ArrayList<SelectItem>();
                 for(int j = 0;j<aux.size();j++){
                    lotes.add(new SelectItem(aux.get(j),aux.get(j)));                  
                 }
                     lstChvademprof.get(i).getFichaTecnica().setLstLotes(lotes);
                 }
             } catch (ModelException e) {
                 return capturaError(e,IConstantes.ERROR_COSNULTA);
             }
           
           }
       }

        return null;
    }
    public void setLote(ValueChangeEvent valueChangeEvent) {
        int indiceLista=dtMedicamento.getRowIndex();
          lstMedicamento.get(indiceLista).getFichaTecnicaCostosDTO().setLote(((String)valueChangeEvent.getNewValue()));
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    public String changeFechaLote(){
      
        int indiceLista=dtMedicamento.getRowIndex();
        lstMedicamento.get(indiceLista).getFichaTecnicaCostosDTO().setFechaVencimiento(null);
        lstMedicamento.get(indiceLista).getFichaTecnicaCostosDTO().setRenderFecha(false);
          try {
             Date aux = serviceLocator.getCostosService().getFechaByLote( lstMedicamento.get(indiceLista).getFichaTecnicaCostosDTO().getLote());
              if(aux !=null){
                  lstMedicamento.get(indiceLista).getFichaTecnicaCostosDTO().setFechaVencimiento(aux);
                  lstMedicamento.get(indiceLista).getFichaTecnicaCostosDTO().setRenderFecha(true);
                  
              }
          } catch (ModelException e) {
              return capturaError(e,IConstantes.ERROR_COSNULTA);
          }       
        return null;
    }

    public void setMostrarViaAdministracion(boolean mostrarViaAdministracion) {
        this.mostrarViaAdministracion = mostrarViaAdministracion;
    }

    public boolean isMostrarViaAdministracion() {
        return mostrarViaAdministracion;
    }

    public void setMostrarFormAdministracion(boolean mostrarFormAdministracion) {
        this.mostrarFormAdministracion = mostrarFormAdministracion;
    }

    public boolean isMostrarFormAdministracion() {
        return mostrarFormAdministracion;
    }

    public void setMostrarLocal(boolean mostrarLocal) {
        this.mostrarLocal = mostrarLocal;
    }

    public boolean isMostrarLocal() {
        return mostrarLocal;
    }

    public void setMostrarOtra(boolean mostrarOtra) {
        this.mostrarOtra = mostrarOtra;
    }

    public boolean isMostrarOtra() {
        return mostrarOtra;
    }


    public void setMedicamentoViaAdmini(String medicamentoViaAdmini) {
        this.medicamentoViaAdmini = medicamentoViaAdmini;
    }

    public String getMedicamentoViaAdmini() {
        return medicamentoViaAdmini;
    }

    public void setMedicamentoFormaAdmini(String medicamentoFormaAdmini) {
        this.medicamentoFormaAdmini = medicamentoFormaAdmini;
    }

    public String getMedicamentoFormaAdmini() {
        return medicamentoFormaAdmini;
    }

    public void setMedicamentoUnidad(String medicamentoUnidad) {
        this.medicamentoUnidad = medicamentoUnidad;
    }

    public String getMedicamentoUnidad() {
        return medicamentoUnidad;
    }

    public void setMnuViaAdministracion(UIInput mnuViaAdministracion) {
        this.mnuViaAdministracion = mnuViaAdministracion;
    }

    public UIInput getMnuViaAdministracion() {
        return mnuViaAdministracion;
    }


    public void setRadioFormaAdministracion(UIInput radioFormaAdministracion) {
        this.radioFormaAdministracion = radioFormaAdministracion;
    }

    public UIInput getRadioFormaAdministracion() {
        return radioFormaAdministracion;
    }

    public void setTotalMedicamento(BigDecimal totalMedicamento) {
        this.totalMedicamento = totalMedicamento;
    }

    public BigDecimal getTotalMedicamento() {
        return totalMedicamento;
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
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));

        }

        return lstOpciones;
    }

    public void setMostrarMedicamentoAnes(boolean mostrarMedicamentoAnes) {
        this.mostrarMedicamentoAnes = mostrarMedicamentoAnes;
    }

    public boolean isMostrarMedicamentoAnes() {
        return mostrarMedicamentoAnes;
    }

    public void setRadioMedicamentoAnes(UIInput radioMedicamentoAnes) {
        this.radioMedicamentoAnes = radioMedicamentoAnes;
    }

    public UIInput getRadioMedicamentoAnes() {
        return radioMedicamentoAnes;
    }

    public void setMostrarMedicamentoNoAnes(boolean mostrarMedicamentoNoAnes) {
        this.mostrarMedicamentoNoAnes = mostrarMedicamentoNoAnes;
    }

    public boolean isMostrarMedicamentoNoAnes() {
        return mostrarMedicamentoNoAnes;
    }

    public void setMedicamentoSelect(String medicamentoSelect) {
        this.medicamentoSelect = medicamentoSelect;
    }

    public String getMedicamentoSelect() {
        return medicamentoSelect;
    }

    public void setMedicamentoo(String medicamentoo) {
        this.medicamentoo = medicamentoo;
    }

    public String getMedicamentoo() {
        return medicamentoo;
    }

    public void setItMedicamento(UIInput itMedicamento) {
        this.itMedicamento = itMedicamento;
    }

    public UIInput getItMedicamento() {
        return itMedicamento;
    }

    public void setDeshabilitarMedicamento(boolean deshabilitarMedicamento) {
        this.deshabilitarMedicamento = deshabilitarMedicamento;
    }

    public boolean isDeshabilitarMedicamento() {
        return deshabilitarMedicamento;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setMedicamentoSelectCodigo(Integer medicamentoSelectCodigo) {
        this.medicamentoSelectCodigo = medicamentoSelectCodigo;
    }

    public Integer getMedicamentoSelectCodigo() {
        return medicamentoSelectCodigo;
    }

    public void setLstVademecumm(List lstVademecumm) {
        this.lstVademecumm = lstVademecumm;
    }

    public List getLstVademecumm() {
        {
            if (lstVademecumm == null || lstVademecumm.isEmpty()) {
                lstVademecumm = new ArrayList();
                ArrayList<Chvademecum> listVademecumAux = null;
                try {
                    listVademecumAux = 
                            (ArrayList<Chvademecum>)this.serviceLocator.getCirugiaService().getVademecumTotal();
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (!listVademecumAux.isEmpty()) {
                    lstVademecumm.add(new SelectItem("", "Seleccione..."));
                    Iterator it = listVademecumAux.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        it.next();
                        lstVademecumm.add(new SelectItem(listVademecumAux.get(i).getHvdnconsecutiv(), 
                                                         listVademecumAux.get(i).getHvdcprincactiv()));
                        i++;

                    }
                }
            }
            return lstVademecumm;
        }
    }

    public void setMostrarViaAdministracionTable(boolean mostrarViaAdministracionTable) {
        this.mostrarViaAdministracionTable = mostrarViaAdministracionTable;
    }

    public boolean isMostrarViaAdministracionTable() {
        return mostrarViaAdministracionTable;
    }

    public void setMostrarFormAdministracionTable(boolean mostrarFormAdministracionTable) {
        this.mostrarFormAdministracionTable = mostrarFormAdministracionTable;
    }

    public boolean isMostrarFormAdministracionTable() {
        return mostrarFormAdministracionTable;
    }

    public void setMostrarLocalTable(boolean mostrarLocalTable) {
        this.mostrarLocalTable = mostrarLocalTable;
    }

    public boolean isMostrarLocalTable() {
        return mostrarLocalTable;
    }


    public void setVadecum(List<Chvademecum> vadecum) {
        this.vadecum = vadecum;
    }

    public List<Chvademecum> getVadecum() {
        return vadecum;
    }
}
