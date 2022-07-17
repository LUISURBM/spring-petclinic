//=======================================================================
// ARCHIVO RegistrarMedidaProfilacticaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//=======================================================================
package org.profamilia.hc.view.backing.cirugia.registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chposicanest;
import org.profamilia.hc.model.dto.ChposicanestPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE RegistrarMedidaProfilacticaBean
//=======================================================================
public class RegistrarMedidaProfilacticaBean extends BaseBean {
    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List lstBasica;

    private List lstModificacion;

    private Chposicanest medida;

    private boolean mostrarmodificacion;

    private Integer horainicio;

    private Integer horainiciocambio;

    private List listHora;

    private Integer minutoinicio;

    private Integer minutoiniciocambio;

    private List lstMinutos;

    private boolean mostrarmodificacioncambio;

    private boolean proteccionpuntos;

    private boolean proteccionocular;

    private boolean compresionneumatica;

    private List lstOpciones;

    private boolean mostrartorniquete;

    private Integer horafin;

    private Integer minutofin;

    private Long numeroCirugia;

    private String tipoServicio;
    
    private String opcion;
    
    private String navigationRule;
    
    private boolean ligadura;
    
    private boolean renderOtrasCirugias;

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarMedidaProfilacticaBean() {
    }

    public void init() {
        lstBasica = new ArrayList();
        lstModificacion = new ArrayList();
        listHora = new ArrayList();
        lstMinutos = new ArrayList();
        lstOpciones = new ArrayList();
   
        cargarDatos();

    }


    public void cargarDatos() {

        try {
            medida = 
                    this.serviceLocator.getClinicoService().getMedidaProfilactica(numeroCirugia);
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (medida == null) {
            medida = new Chposicanest();
            medida.setHpacposicbasic("DSU");
            medida.setHpacmodifposic("TRE");
        } else {
            if (medida.getHpacmodifposic() != null && medida.getHpacmodifposic().equals("OTR")) {
                mostrarmodificacion = true;
            } else {
                mostrarmodificacion = false;
            }
            
            if(medida.getHpacnuevamodif() !=null && medida.getHpacnuevamodif().equals("OTR")){
                mostrarmodificacioncambio = true;
            } else {
                mostrarmodificacioncambio = false;
            }

           

            if (medida.getHpactorniquete() != null && 
                medida.getHpactorniquete().equals("S")) {
                mostrartorniquete = true;
            } else {
                mostrartorniquete = false;
            }


            if (medida.getHpacprotpunpre() != null && 
                medida.getHpacprotpunpre().equals("S")) {
                proteccionpuntos = true;
            } else {
                proteccionpuntos = false;
            }

            if (medida.getHpacprotocupre() != null && 
                medida.getHpacprotocupre().equals("S")) {
                proteccionocular = true;

            } else {
                proteccionocular = false;
            }

            if (medida.getHpaccompneuint() != null && 
                medida.getHpaccompneuint().equals("S")) {
                compresionneumatica = true;

            } else {
                compresionneumatica = false;
            }

            if (medida.getHpadhoracampos() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(medida.getHpadhoracampos());
                horainiciocambio = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoiniciocambio = fechaaux.get(Calendar.MINUTE);
            }


            if (medida.getHpadhorainicio() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(medida.getHpadhorainicio());
                horainicio = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutoinicio = fechaaux.get(Calendar.MINUTE);
            }

            if (medida.getHpadhorafin() != null) {
                Calendar fechaaux = Calendar.getInstance();
                fechaaux.setTime(medida.getHpadhorafin());
                horafin = fechaaux.get(Calendar.HOUR_OF_DAY);
                minutofin = fechaaux.get(Calendar.MINUTE);
            }

        }


    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------


    /**
     * @param lstBasica
     */
    public void setLstBasica(List lstBasica) {
        this.lstBasica = lstBasica;
    }

    /**
     * @return
     */
    public List getLstBasica() {
        if (lstBasica.size() == 0) {
            
            lstBasica.add(new SelectItem("DSU", "Dec�bito supino"));
            lstBasica.add(new SelectItem("DPR", "Dec�bito prono"));
            lstBasica.add(new SelectItem("DLD", "Dec�bito lateral derecho"));
            lstBasica.add(new SelectItem("DLI", "Dec�bito lateral izquierdo"));
            lstBasica.add(new SelectItem("LIT", "Litotom�a"));
            lstBasica.add(new SelectItem("FOW", "Fowler"));
            lstBasica.add(new SelectItem("NEU", "Neutro"));
        }
        return lstBasica;
    }

    /**
     * @param lstModificacion
     */
    public void setLstModificacion(List lstModificacion) {
        this.lstModificacion = lstModificacion;
    }

    /**
     * @return
     */
    public List getLstModificacion() {
        if (lstModificacion.size() == 0) {
            lstModificacion.add(new SelectItem("TRE", "Trendelemburg"));
            lstModificacion.add(new SelectItem("FOW", "Fowler"));
            lstModificacion.add(new SelectItem("NAV", "Navaja "));
            lstModificacion.add(new SelectItem("TIN",  "Trendelemburg invertido"));
            lstModificacion.add(new SelectItem("NEU",  "Neutro"));
           

        }
        return lstModificacion;
    }

    /**
     * @param medida
     */
    public void setMedida(Chposicanest medida) {
        this.medida = medida;
    }

    /**
     * @return
     */
    public Chposicanest getMedida() {
        return medida;
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpacmodifposic(ValueChangeEvent valueChangeEvent) {
        medida.setHpacmodifposic((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param mostrarmodificacion
     */
    public void setMostrarmodificacion(boolean mostrarmodificacion) {
        this.mostrarmodificacion = mostrarmodificacion;
    }

    /**
     * @return
     */
    public boolean isMostrarmodificacion() {
        return mostrarmodificacion;
    }

    public void changeModificacion() {
        if (medida != null && medida.getHpacmodifposic().equals("OTR")) {
            mostrarmodificacion = true;
        } else {
            medida.setHpacotraposici(null);
            mostrarmodificacion = false;
        }
    }

    /**
     * @param horainicio
     */
    public void setHorainicio(Integer horainicio) {
        this.horainicio = horainicio;
    }

    /**
     * @return
     */
    public Integer getHorainicio() {
        return horainicio;
    }

    /**
     * @param minutoinicio
     */
    public void setMinutoinicio(Integer minutoinicio) {
        this.minutoinicio = minutoinicio;
    }

    /**
     * @return
     */
    public Integer getMinutoinicio() {
        return minutoinicio;
    }

    /**
     * @param horafin
     */
    public void setHorafin(Integer horafin) {
        this.horafin = horafin;
    }

    /**
     * @return
     */
    public Integer getHorafin() {
        return horafin;
    }

    /**
     * @param minutofin
     */
    public void setMinutofin(Integer minutofin) {
        this.minutofin = minutofin;
    }

    /**
     * @return
     */
    public Integer getMinutofin() {
        return minutofin;
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
     * @param mostrarmodificacioncambio
     */
    public void setMostrarmodificacioncambio(boolean mostrarmodificacioncambio) {
        this.mostrarmodificacioncambio = mostrarmodificacioncambio;
    }

    /**
     * @return
     */
    public boolean isMostrarmodificacioncambio() {
        return mostrarmodificacioncambio;
    }

    /**
     * @param proteccionpuntos
     */
    public void setProteccionpuntos(boolean proteccionpuntos) {
        this.proteccionpuntos = proteccionpuntos;
    }

    /**
     * @return
     */
    public boolean isProteccionpuntos() {
        return proteccionpuntos;
    }

    /**
     * @param proteccionocular
     */
    public void setProteccionocular(boolean proteccionocular) {
        this.proteccionocular = proteccionocular;
    }

    /**
     * @return
     */
    public boolean isProteccionocular() {
        return proteccionocular;
    }

    /**
     * @param compresionneumatica
     */
    public void setCompresionneumatica(boolean compresionneumatica) {
        this.compresionneumatica = compresionneumatica;
    }

    /**
     * @return
     */
    public boolean isCompresionneumatica() {
        return compresionneumatica;
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
            lstOpciones.add(new SelectItem("S", "SI"));
            lstOpciones.add(new SelectItem("N", "NO"));
        }
        return lstOpciones;
    }

    /**
     * @param horainiciocambio
     */
    public void setHorainiciocambio(Integer horainiciocambio) {
        this.horainiciocambio = horainiciocambio;
    }

    /**
     * @return
     */
    public Integer getHorainiciocambio() {
        return horainiciocambio;
    }

    /**
     * @param minutoiniciocambio
     */
    public void setMinutoiniciocambio(Integer minutoiniciocambio) {
        this.minutoiniciocambio = minutoiniciocambio;
    }

    /**
     * @return
     */
    public Integer getMinutoiniciocambio() {
        return minutoiniciocambio;
    }

    /**
     * @param mostrartorniquete
     */
    public void setMostrartorniquete(boolean mostrartorniquete) {
        this.mostrartorniquete = mostrartorniquete;
    }

    /**
     * @return
     */
    public boolean isMostrartorniquete() {
        return mostrartorniquete;
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


    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------

    /**
     * @param valueChangeEvent
     */
    public void setHpacnuevamodif(ValueChangeEvent valueChangeEvent) {
        medida.setHpacnuevamodif((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setProteccionocular(ValueChangeEvent valueChangeEvent) {
        setProteccionocular((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    /**
     * @param valueChangeEvent
     */
    public void setHpactorniquete(ValueChangeEvent valueChangeEvent) {
        medida.setHpactorniquete((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeModificacionCambio() {
        if (medida != null && medida.getHpacnuevamodif().equals("OTR")) {
            mostrarmodificacioncambio = true;
        } else {
            medida.setHpacnuevaotra(null);
            mostrarmodificacioncambio = false;
        }
    }

    public void changeTorniquete() {
        if (medida != null && medida.getHpactorniquete() != null && 
            medida.getHpactorniquete().equals("S")) {
            mostrartorniquete = true;
        } else {
            medida.setHpadhorainicio(null);
            medida.setHpadhorafin(null);
            horainicio = null;
            minutoinicio = null;
            minutofin = null;
            horafin = null;
            medida.setHpaclugartorni(null);
            medida.setHpanpresiinfla(null);
            mostrartorniquete = false;
        }
    }

    public void ChangeProteccion() {
        if (proteccionocular) {
            medida.setHpacproteocula(null);
        }
    }

    //-----------------------------------------------------------------------
    //  Boton Principal 
    //-----------------------------------------------------------------------     

    public String RegistrarMedidaProfilactica() {
        navigationRule = "";
        ChposicanestPK id = new ChposicanestPK();
        id.setHpactiposervi(tipoServicio);
        id.setHpalnumero(numeroCirugia);
        medida.setHpadfecregistr(new Date());
        medida.setHpacoperador(userName());
        medida.setId(id);
        medida.setHpanclinica(getClinica().getCclncodigo());

        if (proteccionpuntos) {
            medida.setHpacprotpunpre("S");
        } else {
            medida.setHpacprotpunpre("N");
        }

        if (proteccionocular) {
            medida.setHpacprotocupre("S");
        } else {
            medida.setHpacprotocupre("N");
        }

        if (compresionneumatica) {
            medida.setHpaccompneuint("S");
        } else {
            medida.setHpaccompneuint("N");
        }

        if (medida.getHpadhoracampos() != null && horainiciocambio != null && 
            minutoiniciocambio != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(medida.getHpadhoracampos());
            fechaaux.set(Calendar.HOUR, horainiciocambio);
            fechaaux.set(Calendar.MINUTE, minutoiniciocambio);
            medida.setHpadhoracampos(fechaaux.getTime());
        }

        if (medida.getHpadhorainicio() != null && horainicio != null && 
            minutoinicio != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(medida.getHpadhorainicio());
            fechaaux.set(Calendar.HOUR, horainicio);
            fechaaux.set(Calendar.MINUTE, minutoinicio);
            medida.setHpadhorainicio(fechaaux.getTime());
        }


        if (medida.getHpadhorafin() != null && horafin != null && 
            minutofin != null) {
            Calendar fechaaux = Calendar.getInstance();
            fechaaux.setTime(medida.getHpadhorafin());
            fechaaux.set(Calendar.HOUR, horafin);
            fechaaux.set(Calendar.MINUTE, minutofin);
            medida.setHpadhorafin(fechaaux.getTime());
        }

        try {
            this.serviceLocator.getClinicoService().saveMedidaProfilactica(medida);
            FacesUtils.addInfoMessage(MSG_ADICION);
            
            navigationRule = "irRegistrarSignosVitalesAnestesia";
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        return navigationRule;
    }


    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    public Long getNumeroCirugia() {
        return numeroCirugia;
    }

    public void setLigadura(boolean ligadura) {
        this.ligadura = ligadura;
    }

    public boolean isLigadura() {
        return ligadura;
    }

    public void setRenderOtrasCirugias(boolean renderOtrasCirugias) {
        this.renderOtrasCirugias = renderOtrasCirugias;
    }

    public boolean isRenderOtrasCirugias() {
        return renderOtrasCirugias;
    }
}
