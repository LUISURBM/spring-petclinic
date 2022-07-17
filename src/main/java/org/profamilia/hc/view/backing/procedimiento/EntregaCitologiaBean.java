//======================================================================================================================
// ARCHIVO EntregaCitologiaBean
// FECHA CREACI�N: 
// AUTOR: jariano, nlis
// Descripcion: 
//======================================================================================================================
package org.profamilia.hc.view.backing.procedimiento;

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
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;

import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cptipoiden;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.PdfServletUtils;


//======================================================================================================================
//  BIBLIOTECAS REQUERIDAS
//======================================================================================================================


//======================================================================================================================
//  CLASE EntregaCitologiaBean
//======================================================================================================================
public class EntregaCitologiaBean extends BaseBean implements JRDataSource {
    //------------------------------------------------------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //------------------------------------------------------------------------------------------------------------------

    private Chlibrocitol entrega;

    private Cncitologi citologia;

    private Cncitolect lectura;

    private Cncitotoma toma;

    private boolean generoCitologia;

    private String reclamaUsuaria;

    private List lstOpciones;

    private boolean mostrarReclama;

    private boolean wexito;

    /** Lista que almacena la lista de tipos de documentos  */
    private List<SelectItem> listTipoIdentificacion;

    private static int NUMERO_COPIAS = 1;

    private int index = -1;

    private List lstConducta;

   private boolean esPolicia;

    //Variables Citologia
    String APELLIDOS;
    String NOMBRES;
    Long NUMERO_DOCUMENTO;
    String TIPO_DOCUMENTO;
    String DIRECCION;
    String TELEFONO;
    String CIUDAD;
    String DEPARTAMENTO;
    String OTRA_DIRECCION;
    String OTRO_TELEFONO;
    String OTRA_CIUDAD;
    String OTRO_DEPARTAMENTO;
    Integer EDAD;
    Date FECHA_REGLA;
    String DIA_REGLA;
    String MES_REGLA;
    String ANNO_REGLA;

    Integer GESTACIONES;
    Integer PARTOS;
    Integer ABORTOS;
    String TIPO_AFILIACION;
    String ASEGURADORA;
    String ESQUEMA_CITOLOGIA;
    String APECTO_CUELLO;

    Date FECHA_PARTO;
    String DIA_PARTO;
    String MES_PARTO;
    String ANNO_PARTO;

    String ESTA_EMBARAZADA;
    Integer EDAD_RELACIONES;
    String METODO_PLANIFICACION;
    Date FECHA_CITOLOGIA;
    String DIA_CITOLOGIA;
    String MES_CITOLOGIA;
    String ANNO_CITOLOGIA;
    String RESULTADO_CITOLOGIA;

    Date FECHA_CAUTERIZACION;
    Date FECHA_HISTERECTOMIA;
    Date FECHA_CONIZACION;
    Date FECHA_RADIOTERAPIA;
    Date FECHA_BIOPSA;
    Date FECHA_CRIOTERAPIA;
    Date FECHA_ATA;
    Date FECHA_OTRO;
    Date FECHA_COLPOSCOPIA;
    String OTRO_CUAL;
    String NINGUNO;
    String CAUTERIZACION;
    String HISTERECTOMIA;
    String CONIZACION;
    String RADIOTERAPIA;
    String BIOPSIA;
    String CRIOTERAPIA;
    String ATA;
    String OTRO;
    String COLPOSCOPIA;
    String TOMADA;
    Date FECHA_TOMADA;
    String NOMBRE_TOMADA;
    Integer NUMERO_CITOLOGIA;
    Date FECHA_VPH;

    Integer DOSIS_VPH;
    String VPH;
    String OBSERVACIONES_TOMA;
    String OTROS_HALLAZGOS;

    String OTROS_HALLAZGOS_TOMA;

    String OTRO_METODO;

    String ES_SANO;
    String ES_AUSENTE;
    String ES_EROSIONADO;
    String ES_CONGESTIVO;
    String ES_ATROFICO;
    String ES_ULCERADO;
    String ES_SANGRANTE;
    String ES_LESION_VISIBLE;
    String ES_POLIPO;
    String CENTRO;


    // Variables de Lectura

    String CALIDAD_MUESTRA;
    String MICROORGANISMOS;
    String OTROS_MICRO;
    String CATEGORIZACION;
    String ANORMAL_ESCA;
    String ANORMAL_GLANDU;
    String OTRAS_NEOPLACITAS;
    String OBSERVACIONES;

    String DIA_PRIMERA_LECTURA;
    String MES_PRIMERA_LECTURA;
    String ANO_PRIMERA_LECTURA;
    String DIA_SEGUNDA_LECTURA;
    String MES_SEGUNDA_LECTURA;
    String ANO_SEGUNDA_LECTURA;
    String NOMBRE_PRIMERA_LECTURA;
    String NOMBRE_SEGUNDA_LECTURA;
    String PRIMERA_LEIDA;
    String SEGUNDA_LEIDA;
    String NUMERO_PRIMERA_LECTURA;
    String NUMERO_SEGUNDA_LECTURA;

    String DIA_VPH;
    String MES_VPH;
    String ANO_VPH;

    String DESCRIPCION_CONDUCTA;
    Date FECHA_PRIMERA_LECTURA;
    Date FECHA_SEGUNDA_LECTURA;
    String NUMERO_FAC;
    private Cncitovphlect lecturaVPH;

    // FECHA ENTREGA CITOLOGIA

    Date FECHA_ENTREGA;
    
    //Variables VPH
     Integer NUMERO_TIPIFICACION;
     String HVLCGT16;
     String HVLCGT18;
     String HVLCGT31;
     String HVLCGT45;
     String HVLCGT51;
     String HVLCGT52;
     String HVLCGT3858;
     String HVLCGT353968;
     String HVLCGT565966;
     String LECTURA_NOMBRRE_PROFESIONAL;
     String LECTURA_TARJETA_PROFESIONAL;
     String CONDUCTA;
     String DIA_LECTURA;
     String MES_LECTURA;
     String ANO_LECTURA;
     String DIA_TOMADA;
     String MES_TOMADA;
     String ANO_TOMADA;
     String DIA_RECEP;
     String MES_RECEP;
     String ANO_RECEP;
     String INTERPRETACION;
     String GENOTIPIFICACION;
    //------------------------------------------------------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //------------------------------------------------------------------------------------------------------------------

    public EntregaCitologiaBean() {
    }

    public void init() {
        lstOpciones = new ArrayList();
        listTipoIdentificacion = new ArrayList<SelectItem>();
        entrega = new Chlibrocitol();
        lstConducta = new ArrayList();
        
        if (citologia != null) {
            try {
                toma = serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());
                lectura = 
                        serviceLocator.getClinicoService().getLecturaCitologia(citologia.getCcinconsec());
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        
        if(citologia != null && lectura == null){
            FacesUtils.addErrorMessage("No se ha registrado la lectura de esta citologia");
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Get/Set
    //------------------------------------------------------------------------------------------------------------------

    /**
     * @param entrega
     */
    public void setEntrega(Chlibrocitol entrega) {
        this.entrega = entrega;
    }

    /**
     * @return
     */
    public Chlibrocitol getEntrega() {
        return entrega;
    }


    /**
     * @param generoCitologia
     */
    public void setGeneroCitologia(boolean generoCitologia) {
        this.generoCitologia = generoCitologia;
    }

    /**
     * @return
     */
    public boolean isGeneroCitologia() {
        return generoCitologia;
    }

    /**
     * @param reclamaUsuaria
     */
    public void setReclamaUsuaria(String reclamaUsuaria) {
        this.reclamaUsuaria = reclamaUsuaria;
    }

    /**
     * @return
     */
    public String getReclamaUsuaria() {
        return reclamaUsuaria;
    }

    /**
     * @param mostrarReclama
     */
    public void setMostrarReclama(boolean mostrarReclama) {
        this.mostrarReclama = mostrarReclama;
    }

    /**
     * @return
     */
    public boolean isMostrarReclama() {
        return mostrarReclama;
    }

    /**
     * @param citologia
     */
    public void setCitologia(Cncitologi citologia) {
        this.citologia = citologia;
    }

    /**
     * @return
     */
    public Cncitologi getCitologia() {
        return citologia;
    }

    /**
     * @param valueChangeEvent
     */
    public void setReclamaUsuaria(ValueChangeEvent valueChangeEvent) {
        setReclamaUsuaria((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
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
     * @param listTipoIdentificacion
     */
    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    /**
     * @return
     */
    public List<SelectItem> getListTipoIdentificacion() {
        if (listTipoIdentificacion.size() == 0) {
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


    /**
     * @param wexito
     */
    public void setWexito(boolean wexito) {
            this.wexito = wexito;
        }

    /**
     * @return
     */
    public boolean isWexito() {
            return wexito;
        }


    /**
     * @param lstConducta
     */
    public void setLstConducta(List lstConducta) {
        this.lstConducta = lstConducta;
    }

    /**
     * @return
     */
    public List getLstConducta() {
        if (lstConducta.size() == 0) {
            ArrayList<Cndesccito> lstConductaAux = null;
            try {
                if(citologia.getCcintiphis() != null && citologia.getCcintiphis().equals(HISTORIA_PROCEDIMIENTO_VPH_TOMA)){
                lstConductaAux = 
                        (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("chlibrocitol", 
                                                                                                                           "conductavph");
                }else{
                lstConductaAux = 
                            (ArrayList<Cndesccito>)this.getServiceLocator().getClinicoService().getListaDescripcionesCitologia("chlibrocitol", 
                                                                                                                               "hlccconducta");
                }
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstConductaAux != null && !lstConductaAux.isEmpty()) {

                lstConducta.add(new SelectItem("", 
                                               "Seleccione una opcion ..."));
                Iterator it = lstConductaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    lstConducta.add(new SelectItem((lstConductaAux.get(i).getCdicvalor()), 
                                                   lstConductaAux.get(i).getCdicdescri()));
                    i++;
                }
            }
        }
        return lstConducta;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //------------------------------------------------------------------------------------------------------------------

    public void changeReclama() {
        if (reclamaUsuaria != null && reclamaUsuaria.equals("N")) {
            mostrarReclama = true;
        } else {
            mostrarReclama = false;
        }
    }

    public String volverConsulta() {

        FacesUtils.resetManagedBean("consultarEntregaCitologiasBean");
        FacesUtils.resetManagedBean("entregaCitologiaBean");
        generoCitologia = false;
        return BeanNavegacion.RUTA_IR_BUSCAR_CITOLOGIAS;
    }


    //------------------------------------------------------------------------------------------------------------------
    //  Reporte
    //------------------------------------------------------------------------------------------------------------------


    public boolean next() {
        index++;
        return (index < NUMERO_COPIAS);
    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        if (lectura != null) {     
           if (fieldName.equals("APELLIDOS")) {
               value = APELLIDOS;
           } else if (fieldName.equals("NOMBRES")) {
               value = NOMBRES;
           } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
               value = NUMERO_DOCUMENTO;
           } else if (fieldName.equals("DIRECCION")) {
               value = DIRECCION;
           } else if (fieldName.equals("TELEFONO")) {
               value = TELEFONO;
           } else if (fieldName.equals("CIUDAD")) {
               value = CIUDAD;
           } else if (fieldName.equals("DEPARTAMENTO")) {
               value = DEPARTAMENTO;
           } else if (fieldName.equals("OTRA_DIRECCION")) {
               value = OTRA_DIRECCION;
           } else if (fieldName.equals("OTRO_TELEFONO")) {
               value = OTRO_TELEFONO;
           } else if (fieldName.equals("OTRA_CIUDAD")) {
               value = OTRA_CIUDAD;
           } else if (fieldName.equals("OTRO_DEPARTAMENTO")) {
               value = OTRO_DEPARTAMENTO;
           } else if (fieldName.equals("EDAD")) {
               value = EDAD;
           }  else if (fieldName.equals("DIA_REGLA")) {
                value = DIA_REGLA;
            } else if (fieldName.equals("MES_REGLA")) {
                value = MES_REGLA;
            } else if (fieldName.equals("ANNO_REGLA")) {
                value = ANNO_REGLA;
            }  else if (fieldName.equals("GESTACIONES")) {
               value = GESTACIONES;
           } else if (fieldName.equals("PARTOS")) {
               value = PARTOS;
           } else if (fieldName.equals("ABORTOS")) {
               value = ABORTOS;
           } else if (fieldName.equals("TIPO_AFILIACION")) {
               value = TIPO_AFILIACION;
           } else if (fieldName.equals("ASEGURADORA")) {
               value = ASEGURADORA;
           } else if (fieldName.equals("ESQUEMA_CITOLOGIA")) {
               value = ESQUEMA_CITOLOGIA;
           } else if (fieldName.equals("DIA_PARTO")) {
                value = DIA_PARTO;
           } else if (fieldName.equals("MES_PARTO")) {
                value = MES_PARTO;
           } else if (fieldName.equals("ANNO_PARTO")) {
                value = ANNO_PARTO;
           } else if (fieldName.equals("EDAD_RELACIONES")) {
               value = EDAD_RELACIONES;
           } else if (fieldName.equals("METODO_PLANIFICACION")) {
               value = METODO_PLANIFICACION;
           } else if (fieldName.equals("DIA_CITOLOGIA")) {
                value = DIA_CITOLOGIA;
            } else if (fieldName.equals("MES_CITOLOGIA")) {
                value = MES_CITOLOGIA;
            } else if (fieldName.equals("ANNO_CITOLOGIA")) {
                value = ANNO_CITOLOGIA;
            } else if (fieldName.equals("RESULTADO_CITOLOGIA")) {
               value = RESULTADO_CITOLOGIA;
           } else if (fieldName.equals("ESTA_EMBARAZADA")) {
               value = ESTA_EMBARAZADA;
           } else if (fieldName.equals("APECTO_CUELLO")) {
               value = APECTO_CUELLO;
           } else if (fieldName.equals("FECHA_CAUTERIZACION")) {
               value = FECHA_CAUTERIZACION;
           } else if (fieldName.equals("FECHA_HISTERECTOMIA")) {
               value = FECHA_HISTERECTOMIA;
           } else if (fieldName.equals("FECHA_CONIZACION")) {
               value = FECHA_CONIZACION;
           } else if (fieldName.equals("FECHA_RADIOTERAPIA")) {
               value = FECHA_RADIOTERAPIA;
           } else if (fieldName.equals("FECHA_BIOPSA")) {
               value = FECHA_BIOPSA;
           } else if (fieldName.equals("FECHA_CRIOTERAPIA")) {
               value = FECHA_CRIOTERAPIA;
           } else if (fieldName.equals("FECHA_ATA")) {
               value = FECHA_ATA;
           } else if (fieldName.equals("FECHA_OTRO")) {
               value = FECHA_OTRO;
           }else if (fieldName.equals("FECHA_COLPOSCOPIA")) {
                value = FECHA_COLPOSCOPIA;
           }  else if (fieldName.equals("OTRO_CUAL")) {
               value = OTRO_CUAL;
           }else if (fieldName.equals("COLPOSCOPIA")) {
                value = COLPOSCOPIA;
           } else if (fieldName.equals("NINGUNO")) {
               value = NINGUNO;
           } else if (fieldName.equals("CAUTERIZACION")) {
               value = CAUTERIZACION;
           } else if (fieldName.equals("HISTERECTOMIA")) {
               value = HISTERECTOMIA;
           } else if (fieldName.equals("CONIZACION")) {
               value = CONIZACION;
           } else if (fieldName.equals("RADIOTERAPIA")) {
               value = RADIOTERAPIA;
           } else if (fieldName.equals("BIOPSIA")) {
               value = BIOPSIA;
           } else if (fieldName.equals("CRIOTERAPIA")) {
               value = CRIOTERAPIA;
           } else if (fieldName.equals("ATA")) {
               value = ATA;
           } else if (fieldName.equals("OTRO")) {
               value = OTRO;
           } else if (fieldName.equals("TOMADA")) {
               value = TOMADA;
           } else if (fieldName.equals("FECHA_TOMADA")) {
               value = FECHA_TOMADA;
           } else if (fieldName.equals("NOMBRE_TOMADA")) {
               value = NOMBRE_TOMADA;
           } else if (fieldName.equals("NUMERO_CITOLOGIA")) {
               value = NUMERO_CITOLOGIA;
           } else if (fieldName.equals("FECHA_VPH")) {
               value = FECHA_VPH;
           } else if (fieldName.equals("DOSIS_VPH")) {
               value = DOSIS_VPH;
           } else if (fieldName.equals("VPH")) {
               value = VPH;
           } else if (fieldName.equals("OBSERVACIONES_TOMA")) {
               value = OBSERVACIONES_TOMA;
           } else if (fieldName.equals("OTROS_HALLAZGOS_TOMA")) {
               value = OTROS_HALLAZGOS_TOMA;
           } else if (fieldName.equals("OTRO_METODO")) {
               value = OTRO_METODO;
           } else if (fieldName.equals("ES_SANO")) {
               value = ES_SANO;
           } else if (fieldName.equals("ES_AUSENTE")) {
               value = ES_AUSENTE;
           } else if (fieldName.equals("ES_EROSIONADO")) {
               value = ES_EROSIONADO;
           } else if (fieldName.equals("ES_CONGESTIVO")) {
               value = ES_CONGESTIVO;
           } else if (fieldName.equals("ES_ATROFICO")) {
               value = ES_ATROFICO;
           } else if (fieldName.equals("ES_ULCERADO")) {
               value = ES_ULCERADO;
           } else if (fieldName.equals("ES_SANGRANTE")) {
               value = ES_SANGRANTE;
           } else if (fieldName.equals("ES_LESION_VISIBLE")) {
               value = ES_LESION_VISIBLE;
           } else if (fieldName.equals("ES_POLIPO")) {
               value = ES_POLIPO;
           } else if (fieldName.equals("CENTRO")) {
               value = CENTRO;
           } else if (fieldName.equals("CALIDAD_MUESTRA")) {
               value = CALIDAD_MUESTRA;
           } else if (fieldName.equals("MICROORGANISMOS")) {
               value = MICROORGANISMOS;
           } else if (fieldName.equals("OTROS_MICRO")) {
               value = OTROS_MICRO;
           } else if (fieldName.equals("CATEGORIZACION")) {
               value = CATEGORIZACION;
           } else if (fieldName.equals("OTROS_HALLAZGOS")) {
               value = OTROS_HALLAZGOS;
           } else if (fieldName.equals("ANORMAL_ESCA")) {
               value = ANORMAL_ESCA;
           } else if (fieldName.equals("ANORMAL_GLANDU")) {
               value = ANORMAL_GLANDU;
           } else if (fieldName.equals("OTRAS_NEOPLACITAS")) {
               value = OTRAS_NEOPLACITAS;
           } else if (fieldName.equals("OBSERVACIONES")) {
               value = OBSERVACIONES;
           } else if (fieldName.equals("DIA_PRIMERA_LECTURA")) {
               value = DIA_PRIMERA_LECTURA;
           } else if (fieldName.equals("MES_PRIMERA_LECTURA")) {
               value = MES_PRIMERA_LECTURA;
           } else if (fieldName.equals("ANO_PRIMERA_LECTURA")) {
               value = ANO_PRIMERA_LECTURA;
           } else if (fieldName.equals("DIA_SEGUNDA_LECTURA")) {
               value = DIA_SEGUNDA_LECTURA;
           } else if (fieldName.equals("MES_SEGUNDA_LECTURA")) {
               value = MES_SEGUNDA_LECTURA;
           } else if (fieldName.equals("ANO_SEGUNDA_LECTURA")) {
               value = ANO_SEGUNDA_LECTURA;
           } else if (fieldName.equals("NOMBRE_PRIMERA_LECTURA")) {
               value = NOMBRE_PRIMERA_LECTURA;
           } else if (fieldName.equals("NOMBRE_SEGUNDA_LECTURA")) {
               value = NOMBRE_SEGUNDA_LECTURA;
           } else if (fieldName.equals("PRIMERA_LEIDA")) {
               value = PRIMERA_LEIDA;
           } else if (fieldName.equals("SEGUNDA_LEIDA")) {
               value = SEGUNDA_LEIDA;
           } else if (fieldName.equals("FECHA_PRIMERA_LECTURA")) {
               value = FECHA_PRIMERA_LECTURA;
           } else if (fieldName.equals("FECHA_SEGUNDA_LECTURA")) {
               value = FECHA_SEGUNDA_LECTURA;
           } else if (fieldName.equals("NUMERO_PRIMERA_LECTURA")) {
               value = NUMERO_PRIMERA_LECTURA;
           } else if (fieldName.equals("NUMERO_SEGUNDA_LECTURA")) {
               value = NUMERO_SEGUNDA_LECTURA;
           } else if (fieldName.equals("NUMERO_FAC")) {
               value = NUMERO_FAC;
           } else if (fieldName.equals("CONDUCTA")) {
                value = CONDUCTA;
            }
        }
        //
        if (lecturaVPH != null) {
            if (fieldName.equals("NUMERO_TIPIFICACION")) {
                value = NUMERO_TIPIFICACION;
            } else if (fieldName.equals("CENTRO")) {
                value = CENTRO;
            } else if (fieldName.equals("APELLIDOS")) {
                value = APELLIDOS;
            } else if (fieldName.equals("NOMBRES")) {
                value = NOMBRES;
            } else if (fieldName.equals("TIPO_DOCUMENTO")) {
                value = TIPO_DOCUMENTO;
            } else if (fieldName.equals("NUMERO_DOCUMENTO")) {
                value = NUMERO_DOCUMENTO;
            } else if (fieldName.equals("EDAD")) {
                value = EDAD;
            } else if (fieldName.equals("ASEGURADORA")) {
                value = ASEGURADORA;
            } else if (fieldName.equals("TELEFONO")) {
                value = TELEFONO;
            } else if (fieldName.equals("CIUDAD")) {
                value = CIUDAD;
            } else if (fieldName.equals("DEPARTAMENTO")) {
                value = DEPARTAMENTO;
           } else if (fieldName.equals("HVLCGT16")) {
                value = HVLCGT16;
            } else if (fieldName.equals("HVLCGT18")) {
                value = HVLCGT18;
            } else if (fieldName.equals("HVLCGT31")) {
                value = HVLCGT31;
            } else if (fieldName.equals("HVLCGT45")) {
                value = HVLCGT45;
            } else if (fieldName.equals("HVLCGT51")) {
                value = HVLCGT51;
            } else if (fieldName.equals("HVLCGT52")) {
                value = HVLCGT52;
            } else if (fieldName.equals("HVLCGT3858")) {
                value = HVLCGT3858;
            } else if (fieldName.equals("HVLCGT353968")) {
                value = HVLCGT353968;
            } else if (fieldName.equals("HVLCGT565966")) {
                value = HVLCGT565966;
            } else if (fieldName.equals("LECTURA_NOMBRRE_PROFESIONAL")) {
                value = LECTURA_NOMBRRE_PROFESIONAL;
            } else if (fieldName.equals("LECTURA_TARJETA_PROFESIONAL")) {
                value = LECTURA_TARJETA_PROFESIONAL;
            } else if (fieldName.equals("CONDUCTA")) {
                value = CONDUCTA;
            } else if (fieldName.equals("DIA_TOMADA")) {
                value = DIA_TOMADA;
            } else if (fieldName.equals("MES_TOMADA")) {
                value = MES_TOMADA;
            } else if (fieldName.equals("ANO_TOMADA")) {
                value = ANO_TOMADA;
            } else if (fieldName.equals("DIA_LECTURA")) {
                value = DIA_LECTURA;
            } else if (fieldName.equals("MES_LECTURA")) {
                value = MES_LECTURA;
            } else if (fieldName.equals("ANO_LECTURA")) {
                value = ANO_LECTURA;
            } else if (fieldName.equals("DIA_RECEP_TOMA")) {
                value = DIA_RECEP;  
            } else if (fieldName.equals("MES_RECEP_TOMA")) {
                value = MES_RECEP;  
            } else if (fieldName.equals("ANO_RECEP_TOMA")) {
                value = ANO_RECEP;  
            } else if (fieldName.equals("INTERPRETACION")) {
                value = INTERPRETACION;  
            }else if (fieldName.equals("GENOTIPIFICACION")) {
                value = GENOTIPIFICACION;  
            }
        }
        return value;
    }

    public void obtenerDatosReporte(Integer numeroconsec) {
        List lstAspectoSelect = null;
        lstAspectoSelect = new ArrayList();

        if (numeroconsec != null) {
            try {
                citologia = 
                        this.serviceLocator.getClinicoService().getEncabezadoCitologia(numeroconsec);
                if (citologia != null) {
                    toma = 
    serviceLocator.getClinicoService().getTomaCitologia(numeroconsec);
                }


            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (entrega != null && entrega.getHlccconducta() != null) {
           Cndesccito conductades;
            conductades = null;
            try {
                conductades = 
                        serviceLocator.getClinicoService().getDescripcionesCitologia("chlibrocitol", 
                                                                                     "hlccconducta", 
                                                                                      entrega.getHlccconducta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (conductades != null) {
                CONDUCTA = conductades.getCdicvalor();
            }
        }

        if (citologia != null && toma != null) {
        
            if (citologia.getCcinnumdoc() != null) {
                NUMERO_FAC = citologia.getCcinnumdoc().toString();

                if (NUMERO_FAC != null && NUMERO_FAC.length() > 6) {
                    NUMERO_FAC = 
                            NUMERO_FAC.substring(NUMERO_FAC.length() - 6, NUMERO_FAC.length());
                }

            }


            if (citologia != null) {
                if (citologia.getCcinconsec() != null) {
                    NUMERO_CITOLOGIA = citologia.getCcinconsec();
                }
                if (citologia.getCcicprinom() != null) {
                    NOMBRES = citologia.getCcicprinom() + " ";
                }
                if (citologia.getCcicsegnom() != null && 
                    !citologia.getCcicsegnom().equals("_")) {
                    NOMBRES = NOMBRES + citologia.getCcicsegnom();
                }
                if (citologia.getCcicpriape() != null) {
                    APELLIDOS = citologia.getCcicpriape() + " ";
                }
                if (citologia.getCcicsegape() != null && 
                    !citologia.getCcicsegape().equals("_")) {
                    APELLIDOS = APELLIDOS + citologia.getCcicsegape();
                }
                if (citologia.getCcictipide() != null) {
                    TIPO_DOCUMENTO = citologia.getCcictipide();
                }
                if (citologia.getCcianumide() != 0) {
                    NUMERO_DOCUMENTO = citologia.getCcianumide();
                }
                if (citologia.getCcicdirecc() != null) {
                    DIRECCION = citologia.getCcicdirecc();
                }
                if (citologia.getCcictelefo() != null) {
                    TELEFONO = citologia.getCcictelefo();
                }
                Integer idCiudad = null;
                Integer idDepartamento = null;
                Cpmunidane ciudadObject = null;
                if (citologia.getCcinmunici() != null && 
                    citologia.getCcindepart() != null) {
                    idCiudad = citologia.getCcinmunici();
                    idDepartamento = citologia.getCcindepart();
                }


                try {
                    ciudadObject = 
                            this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                                 idDepartamento);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (ciudadObject != null) {
                    CIUDAD = ciudadObject.getCmdcnommun();
                    DEPARTAMENTO = ciudadObject.getCmdcnomdpt();
                }

                if (citologia.getCcicotrdir() != null) {
                    OTRA_DIRECCION = citologia.getCcicotrdir();
                }
                if (citologia.getCcicotrtel() != null) {
                    OTRO_TELEFONO = citologia.getCcicotrtel();
                }


                Integer idOtraCiudad = null;
                Integer idOtroDepartamento = null;
                Cpmunidane ciudadOtraObject = null;
                if (citologia.getCcinotrmun() != null && 
                    citologia.getCcinotrdep() != null) {
                    idOtraCiudad = citologia.getCcinotrmun();
                    idOtroDepartamento = citologia.getCcinotrdep();
                }
                if (citologia.getCcinedad() != null) {
                    EDAD = citologia.getCcinedad();
                }


                try {
                    ciudadOtraObject = 
                            this.serviceLocator.getClinicoService().getMunicipio(idOtraCiudad, 
                                                                                 idOtroDepartamento);
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                if (ciudadOtraObject != null) {
                    OTRA_CIUDAD = ciudadOtraObject.getCmdcnommun();
                    OTRO_DEPARTAMENTO = ciudadOtraObject.getCmdcnomdpt();
                }


                if (citologia.getCcictipafi() != null) {
                    if (citologia.getCcictipafi().equals("C")) {
                        TIPO_AFILIACION = "CONTRIBUTIVO";
                    }
                    if (citologia.getCcictipafi().equals("E")) {
                        TIPO_AFILIACION = "ESPECIAL";
                    }
                    if (citologia.getCcictipafi().equals("R")) {
                        TIPO_AFILIACION = "SUBSIDIO PARCIAL";
                    }
                    if (citologia.getCcictipafi().equals("S")) {
                        TIPO_AFILIACION = "SUBSIDIADO";
                    }
                    if (citologia.getCcictipafi().equals("V")) {
                        TIPO_AFILIACION = "VINCULADO";
                    }
                    if (citologia.getCcictipafi().equals("X")) {
                        TIPO_AFILIACION = "NINGUNO";
                    }


                }
                
                
                if (citologia.getCcinclinic() != null) {
                 Cpclinica clinica = null;


                    try {
                        clinica = serviceLocator.getClinicoService().getClinica(citologia.getCcinclinic());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    CENTRO = clinica.getCclcnombre();
                }
                

                if (citologia.getCcicasegur() != null) {
                    Cpentidadadm aseguradora;
                    aseguradora = null;

                    try {
                        aseguradora = 
                                serviceLocator.getClinicoService().getAseguradoraPorCodigo(citologia.getCcicasegur());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }

                    if (aseguradora != null) {
                        ASEGURADORA = aseguradora.getCeacnombre();
                    }

                }


            }

            if (toma != null) {

                if (toma.getCtmcotrhal() != null) {
                    OTROS_HALLAZGOS_TOMA = toma.getCtmcotrhal();
                }

                if (toma.getCtmcotrmet() != null) {
                    OTRO_METODO = toma.getCtmcotrmet();
                }


                if (toma.getCtmcobstom() != null) {
                    OBSERVACIONES_TOMA = toma.getCtmcobstom();
                }
                if (toma.getCtmdultmen() != null) {
                
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(toma.getCtmdultmen());
                    Integer diapar = calendar.get(Calendar.DAY_OF_MONTH);
                    Integer mespar = calendar.get(Calendar.MONTH) + 1;
                    Integer anopar = calendar.get(calendar.YEAR);

                    if (diapar.compareTo(10) < 0) {
                        DIA_REGLA = "0" + diapar.toString();
                    } else {
                        DIA_REGLA = diapar.toString();
                    }

                    if (mespar.compareTo(10) < 0) {
                        MES_REGLA = "0" + mespar.toString();
                    } else {
                        MES_REGLA = mespar.toString();
                    }

                    ANNO_REGLA = anopar.toString();

                }

                if (toma.getCtmcvph() != null) {
                    if (toma.getCtmcvph().equals("S")) {
                        VPH = "Si";
                    }
                    if (toma.getCtmcvph().equals("N")) {
                        VPH = "No";
                    }

                }


                if (toma.getCtmdvph() != null) {

                    FECHA_VPH = toma.getCtmdvph();
                }

                if (toma.getCtmnvph() != null) {
                    DOSIS_VPH = toma.getCtmnvph();
                }


                if (toma.getCtmdultpar() != null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(toma.getCtmdultpar());
                    Integer diapar = calendar.get(Calendar.DAY_OF_MONTH);
                    Integer mespar = calendar.get(Calendar.MONTH) + 1;
                    Integer anopar = calendar.get(calendar.YEAR);

                    if (diapar.compareTo(10) < 0) {
                        DIA_PARTO = "0" + diapar.toString();
                    } else {
                        DIA_PARTO = diapar.toString();
                    }

                    if (mespar.compareTo(10) < 0) {
                        MES_PARTO = "0" + mespar.toString();
                    } else {
                        MES_PARTO = mespar.toString();
                    }

                    ANNO_PARTO = anopar.toString();
                }

                if (toma.getCtmnedarel() != null) {
                    EDAD_RELACIONES = toma.getCtmnedarel();
                }


                if (toma.getCtmcembara() != null) {
                    Cndesccito embarazades;
                    embarazades = null;
                    try {
                        embarazades = 
                                serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                             "ctmcembara", 
                                                                                             toma.getCtmcembara());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (embarazades != null) {
                        ESTA_EMBARAZADA = embarazades.getCdicdescri();
                    }

                }

                if (toma.getCtmngestac() != null) {
                    GESTACIONES = toma.getCtmngestac();
                }

                if (toma.getCtmnpartos() != null) {
                    PARTOS = toma.getCtmnpartos();
                }
                if (toma.getCtmnaborto() != null) {
                    ABORTOS = toma.getCtmnaborto();
                }

                if (toma.getCtmcesquem() != null) {
                    Cndesccito esquemades;
                    esquemades = null;
                    try {
                        esquemades = 
                                serviceLocator.getClinicoService().getDescripcionesCitologia("cncitotoma", 
                                                                                             "ctmcesquem", 
                                                                                             toma.getCtmcesquem());
                    } catch (ModelException e) {
                        e.printStackTrace();
                    }
                    if (esquemades != null) {
                        ESQUEMA_CITOLOGIA = formatearCampoNulo(esquemades.getCdicdescri());
                    }

                }

                if (toma.getCtmcmetpla() != null) {
                    METODO_PLANIFICACION = formatearCampoNulo(toma.getCtmcmetpla());

                }


                if (toma.getCtmcultres() != null) {

                    RESULTADO_CITOLOGIA = formatearCampoNulo(toma.getCtmcultres());

                }

                if (toma.getCtmcaspcue() != null && 
                    !toma.getCtmcaspcue().equals("")) {
                    StringTokenizer st = 
                        new StringTokenizer(toma.getCtmcaspcue(), ",");
                    while (st.hasMoreTokens()) {
                        String aspec = st.nextToken();
                        lstAspectoSelect.add(aspec);
                    }
                }


                if (lstAspectoSelect != null && !lstAspectoSelect.isEmpty()) {
                    ES_SANO = "";
                    ES_AUSENTE = "";
                    ES_EROSIONADO = "";
                    ES_CONGESTIVO = "";
                    ES_ATROFICO = "";
                    ES_ULCERADO = "";
                    ES_SANGRANTE = "";
                    ES_LESION_VISIBLE = "";
                    ES_POLIPO = "";
                    Iterator it = lstAspectoSelect.iterator();
                    while (it.hasNext()) {
                        String idAspecto;
                        idAspecto = (String)it.next();


                        if (idAspecto.equals("3.1")) {
                            ES_SANO = "S";
                        }
                        if (idAspecto.equals("3.2")) {
                            ES_AUSENTE = "S";
                        }
                        if (idAspecto.equals("3.3")) {
                            ES_EROSIONADO = "S";
                        }
                        if (idAspecto.equals("3.4")) {
                            ES_CONGESTIVO = "S";
                        }
                        if (idAspecto.equals("3.5")) {
                            ES_ATROFICO = "S";
                        }
                        if (idAspecto.equals("3.6")) {
                            ES_ULCERADO = "S";
                        }
                        if (idAspecto.equals("3.7")) {
                            ES_SANGRANTE = "S";
                        }
                        if (idAspecto.equals("3.8")) {
                            ES_LESION_VISIBLE = "S";
                        }
                        if (idAspecto.equals("3.9")) {
                            ES_POLIPO = "S";
                        }

                    }


                    if (toma.getCtmdultcit() != null) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(toma.getCtmdultcit());
                        Integer diacit = calendar.get(Calendar.DAY_OF_MONTH);
                        Integer mescit = calendar.get(Calendar.MONTH) + 1;
                        Integer anocit = calendar.get(calendar.YEAR);

                        if (diacit.compareTo(10) < 0) {
                            DIA_CITOLOGIA = "0" + diacit.toString();
                        } else {
                            DIA_CITOLOGIA = diacit.toString();
                        }

                        if (mescit.compareTo(10) < 0) {
                            MES_CITOLOGIA = "0" + mescit.toString();
                        } else {
                            MES_CITOLOGIA = mescit.toString();
                        }

                        ANNO_CITOLOGIA = anocit.toString();
                    }


                    if (toma.getCtmdpcaute() != null) {

                        FECHA_CAUTERIZACION = toma.getCtmdpcaute();
                    }

                    if (toma.getCtmdphiste() != null) {

                        FECHA_HISTERECTOMIA = toma.getCtmdphiste();
                    }

                    if (toma.getCtmdpconiz() != null) {

                        FECHA_CONIZACION = toma.getCtmdpconiz();
                    }


                    if (toma.getCtmdpradio() != null) {

                        FECHA_RADIOTERAPIA = toma.getCtmdpradio();
                    }

                    if (toma.getCtmdpbiops() != null) {

                        FECHA_BIOPSA = toma.getCtmdpbiops();
                    }


                    if (toma.getCtmdpcriot() != null) {

                        FECHA_CRIOTERAPIA = toma.getCtmdpcriot();
                    }

                    if (toma.getCtmdpata() != null) {


                        FECHA_ATA = toma.getCtmdpata();
                    }


                    if (toma.getCtmdpotro() != null) {

                        FECHA_OTRO = toma.getCtmdpotro();
                    }
                    if (toma.getCtmdpcolpo() != null) {

                        FECHA_COLPOSCOPIA = toma.getCtmdpcolpo();
                    }

                    if (toma.getCtmcpdotro() != null) {
                        OTRO_CUAL = formatearCampoNulo(toma.getCtmcpdotro());
                    }
                    if (toma.getCtmcpningu() != null) {
                        NINGUNO = formatearCampoNulo(toma.getCtmcpningu());
                    }

                    if (toma.getCtmcpcaute() != null) {
                        CAUTERIZACION = formatearCampoNulo(toma.getCtmcpcaute());
                    }
                    if (toma.getCtmcphiste() != null) {
                        HISTERECTOMIA = formatearCampoNulo(toma.getCtmcphiste());
                    }
                    if (toma.getCtmcpconiz() != null) {
                        CONIZACION = formatearCampoNulo(toma.getCtmcpconiz());
                    }
                    if (toma.getCtmcpradio() != null) {
                        RADIOTERAPIA = formatearCampoNulo(toma.getCtmcpradio());
                    }
                    if (toma.getCtmcpbiops() != null) {
                        BIOPSIA = formatearCampoNulo(toma.getCtmcpbiops());
                    }
                    if (toma.getCtmcpcriot() != null) {
                        CRIOTERAPIA = formatearCampoNulo(toma.getCtmcpcriot());
                    }
                    if (toma.getCtmcpata() != null) {
                        ATA = formatearCampoNulo(toma.getCtmcpata());
                    }
                    if (toma.getCtmcpotro() != null) {
                        OTRO = formatearCampoNulo(toma.getCtmcpotro());
                    }
                    if (toma.getCtmcpcolpo() != null) {
                        COLPOSCOPIA = toma.getCtmcpcolpo();
                    }

                    if (toma.getCtmctomada() != null) {
                        TOMADA = formatearCampoNulo(toma.getCtmctomada());
                    }

                    if (toma.getCtmdfecreg() != null) {

                        FECHA_TOMADA = toma.getCtmdfecreg();
                    }

                    if (toma.getCtmcnomtom() != null) {
                        NOMBRE_TOMADA = formatearCampoNulo(toma.getCtmcnomtom());
                    }


                 


                }

            }


        }


        if (lectura != null) {
            if (lectura.getClcccalmue() != null) {
                CALIDAD_MUESTRA = formatearCampoNulo(lectura.getClcccalmue());
            }
            if (lectura.getClccmicorg() != null) {
                MICROORGANISMOS = formatearCampoNulo(lectura.getClccmicorg());
            }
            if (lectura.getClccotrmic() != null) {
                OTROS_MICRO = formatearCampoNulo(lectura.getClccotrmic());
            }
            if (lectura.getClcccatego() != null) {
                CATEGORIZACION = formatearCampoNulo(lectura.getClcccatego());
            }
            if (lectura.getClccotrhal() != null) {
                OTROS_HALLAZGOS = formatearCampoNulo(lectura.getClccotrhal());
            }

            if (lectura.getClcdprilec() != null) {
                FECHA_PRIMERA_LECTURA = lectura.getClcdprilec();
            }

            if (lectura.getClcdseglec() != null) {
                FECHA_SEGUNDA_LECTURA = lectura.getClcdseglec();
            }

            if (lectura.getClccanoesc() != null) {
                ANORMAL_ESCA = formatearCampoNulo(lectura.getClccanoesc());
            }
            if (lectura.getClccanogla() != null) {
                ANORMAL_GLANDU = formatearCampoNulo(lectura.getClccanogla());
            }
            if (lectura.getClccotrneo() != null) {
                OTRAS_NEOPLACITAS = formatearCampoNulo(lectura.getClccotrneo());
            }

            if (lectura.getClccobserv() != null) {
                OBSERVACIONES = formatearCampoNulo(lectura.getClccobserv());
            }

            if (lectura.getClcdprilec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lectura.getClcdprilec());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_PRIMERA_LECTURA = "0" + dialec1.toString();
                } else {
                    DIA_PRIMERA_LECTURA = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_PRIMERA_LECTURA = "0" + meslec1.toString();
                } else {
                    MES_PRIMERA_LECTURA = meslec1.toString();
                }

                ANO_PRIMERA_LECTURA = anolec1.toString();
            }


            if (lectura.getClcdseglec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lectura.getClcdseglec());
                Integer dialec2 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec2 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec2 = calendar.get(calendar.YEAR);

                if (dialec2.compareTo(10) < 0) {
                    DIA_SEGUNDA_LECTURA = "0" + dialec2.toString();
                } else {
                    DIA_SEGUNDA_LECTURA = dialec2.toString();
                }

                if (meslec2.compareTo(10) < 0) {
                    MES_SEGUNDA_LECTURA = "0" + meslec2.toString();
                } else {
                    MES_SEGUNDA_LECTURA = meslec2.toString();
                }

                ANO_SEGUNDA_LECTURA = anolec2.toString();
            }

            if (lectura.getClccnompri() != null) {
                NOMBRE_PRIMERA_LECTURA = formatearCampoNulo(lectura.getClccnompri());
            }
            if (lectura.getClccnomseg() != null) {
                NOMBRE_SEGUNDA_LECTURA = formatearCampoNulo(lectura.getClccnomseg());
            }
            if (lectura.getClccprilec() != null) {
                PRIMERA_LEIDA = formatearCampoNulo(lectura.getClccprilec());
            }
            if (lectura.getClccseglec() != null) {
                SEGUNDA_LEIDA = formatearCampoNulo(lectura.getClccseglec()) ;
            }
            if (lectura.getClccnumpri() != null) {
                NUMERO_PRIMERA_LECTURA = formatearCampoNulo(lectura.getClccnumpri()) ;
            }
            if (lectura.getClccnumseg() != null) {
                NUMERO_SEGUNDA_LECTURA = formatearCampoNulo(lectura.getClccnumseg()) ;
            }

        }
    } 
    
    public void obtenerDatosReporteVPH() {

        if (entrega != null && entrega.getHlccconducta() != null) {
           Cndesccito conductades;
            conductades = null;
            try {
                conductades = 
                        serviceLocator.getClinicoService().getDescripcionesCitologia("chlibrocitol", 
                                                                                     "conductavph", 
                                                                                      entrega.getHlccconducta());
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (conductades != null) {
                CONDUCTA = conductades.getCdicvalor();
            }
        }

     //  if (entrega != null && entrega.getHlcdfecregistr() != null) {
       //     FECHA_ENTREGA = entrega.getHlcdfecregistr();
        //}

        if (citologia != null) {
            if (citologia.getCcinconsec() != null) {
                NUMERO_TIPIFICACION = citologia.getCcinconsec();
            }

            if (citologia.getCcicprinom() != null) {
                NOMBRES = citologia.getCcicprinom() + " ";
            }
            if (citologia.getCcicsegnom() != null && 
                !citologia.getCcicsegnom().equals("_")) {
                NOMBRES = NOMBRES + citologia.getCcicsegnom();
            }
            if (citologia.getCcicpriape() != null) {
                APELLIDOS = citologia.getCcicpriape() + " ";
            }
            if (citologia.getCcicsegape() != null && 
                !citologia.getCcicsegape().equals("_")) {
                APELLIDOS = APELLIDOS + citologia.getCcicsegape();
            }
            if (citologia.getCcictipide() != null) {
                TIPO_DOCUMENTO = citologia.getCcictipide();
            }
            if (citologia.getCcianumide() != 0) {
                NUMERO_DOCUMENTO = citologia.getCcianumide();
            }
            if (citologia.getCcictelefo() != null) {
                TELEFONO = citologia.getCcictelefo();
            }
            Integer idCiudad = null;
            Integer idDepartamento = null;
            Cpmunidane ciudadObject = null;
            if (citologia.getCcinmunici() != null && 
                citologia.getCcindepart() != null) {
                idCiudad = citologia.getCcinmunici();
                idDepartamento = citologia.getCcindepart();
            }


            try {
                ciudadObject = 
                        this.serviceLocator.getClinicoService().getMunicipio(idCiudad, 
                                                                             idDepartamento);
            } catch (ModelException e) {
                e.printStackTrace();
            }
            if (ciudadObject != null) {
                CIUDAD = ciudadObject.getCmdcnommun();
                DEPARTAMENTO = ciudadObject.getCmdcnomdpt();
            }
            if (citologia.getCcicasegur() != null) {
                Cpentidadadm aseguradoraAux;
                aseguradoraAux = null;

                try {
                    aseguradoraAux = 
                            serviceLocator.getClinicoService().getAseguradoraPorCodigo(citologia.getCcicasegur());
                } catch (ModelException e) {
                    e.printStackTrace();
                }

                if (ASEGURADORA != null) {
                    ASEGURADORA = aseguradoraAux.getCeacnombre();
                }
            }
            if (citologia.getCcinedad() != null) {
                EDAD = citologia.getCcinedad();
            }
        }


        if (toma != null) {    
            if (toma.getCtmdfecreg() != null) {
            
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(toma.getCtmdfecreg());
                Integer diareg = calendar.get(Calendar.DAY_OF_MONTH);
                Integer mesreg = calendar.get(Calendar.MONTH) + 1;
                Integer anoreg = calendar.get(calendar.YEAR);

                if (diareg.compareTo(10) < 0) {
                    DIA_TOMADA = "0" + diareg.toString();
                } else {
                    DIA_TOMADA = diareg.toString();
                }

                if (mesreg.compareTo(10) < 0) {
                    MES_TOMADA = "0" + mesreg.toString();
                } else {
                    MES_TOMADA = mesreg.toString();
                }

                ANO_TOMADA = anoreg.toString();
            }
            
            if (toma.getCtmnclinic() != null) {
                try {
                    Cpclinica clinica = 
                        this.serviceLocator.getClinicoService().getClinica(toma.getCtmnclinic());
                    CENTRO = clinica.getCclcnombre();
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
        }

        if (lecturaVPH != null) {
            if(lecturaVPH.getCcvcusureg() != null){
                try {
                    Cpprofesio profesional = this.serviceLocator.getClinicoService().getProfesionalPorUsuario(lecturaVPH.getCcvcusureg(),lecturaVPH.getCcvnclinic());
                    LECTURA_TARJETA_PROFESIONAL = profesional.getCpfcregmedic();
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }
            
            if (lecturaVPH.getCcvcgenoneg() != null) {
                GENOTIPIFICACION = lecturaVPH.getCcvcgenoneg();
            } 
            
            if (lecturaVPH.getCcvcgt16() != null) {
                HVLCGT16 = lecturaVPH.getCcvcgt16();
            }
            if (lecturaVPH.getCcvcgt18() != null) {
                HVLCGT18 = lecturaVPH.getCcvcgt18();
            }
            if (lecturaVPH.getCcvcgt31() != null) {
                HVLCGT31 = lecturaVPH.getCcvcgt31();
            }
            if (lecturaVPH.getCcvcgt45() != null) {
                HVLCGT45 = lecturaVPH.getCcvcgt45();
            }
            if (lecturaVPH.getCcvcgt51() != null) {
                HVLCGT51 = lecturaVPH.getCcvcgt51();
            }
            if (lecturaVPH.getCcvcgt52() != null) {
                HVLCGT52 = lecturaVPH.getCcvcgt52();
            }
            if (lecturaVPH.getCcvcgt3858() != null) {
                HVLCGT3858 = lecturaVPH.getCcvcgt3858();
            }
            if (lecturaVPH.getCcvcgt353968() != null) {
                HVLCGT353968 = lecturaVPH.getCcvcgt353968();
            }
            if (lecturaVPH.getCcvcgt565966() != null) {
                HVLCGT565966 = lecturaVPH.getCcvcgt565966();
            }
            
            if(lecturaVPH.getCcvcnomlec()!= null){
                LECTURA_NOMBRRE_PROFESIONAL=lecturaVPH.getCcvcnomlec();
            }

            if (lecturaVPH.getCcvdfeclec() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lecturaVPH.getCcvdfeclec());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_LECTURA = "0" + dialec1.toString();
                } else {
                    DIA_LECTURA = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_LECTURA = "0" + meslec1.toString();
                } else {
                    MES_LECTURA = meslec1.toString();
                }

                ANO_LECTURA = anolec1.toString();
            }
            
            if (lecturaVPH.getCcvdfecrecep() != null) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(lecturaVPH.getCcvdfecrecep());
                Integer dialec1 = calendar.get(Calendar.DAY_OF_MONTH);
                Integer meslec1 = calendar.get(Calendar.MONTH) + 1;
                Integer anolec1 = calendar.get(calendar.YEAR);

                if (dialec1.compareTo(10) < 0) {
                    DIA_RECEP= "0" + dialec1.toString();
                } else {
                    DIA_RECEP = dialec1.toString();
                }

                if (meslec1.compareTo(10) < 0) {
                    MES_RECEP = "0" + meslec1.toString();
                } else {
                    MES_RECEP = meslec1.toString();
                }

                ANO_RECEP = anolec1.toString();
            }
            if(lecturaVPH.getCcvcinterpre() != null){
                INTERPRETACION =lecturaVPH.getCcvcinterpre();
            }
        }
    }
    
    


    public void clearReporte() {
        APELLIDOS = "";
        NOMBRES = "";
        NUMERO_DOCUMENTO = null;
        DIRECCION = "";
        TELEFONO = "";
        CIUDAD = "";
        DEPARTAMENTO = "";
        OTRA_DIRECCION = "";
        OTRO_TELEFONO = "";
        OTRA_CIUDAD = "";
        OTRO_DEPARTAMENTO = "";
        EDAD = null;
        FECHA_REGLA = null;
        DIA_REGLA = "";
        MES_REGLA = "";
        ANNO_REGLA = "";
        GESTACIONES = null;
        PARTOS = null;
        ABORTOS = null;
        TIPO_AFILIACION = "";
        ASEGURADORA = "";
        ESQUEMA_CITOLOGIA = "";
        FECHA_PARTO = null;
        DIA_PARTO = "";
        MES_PARTO = "";
        ANNO_PARTO = "";
        EDAD_RELACIONES = null;
        METODO_PLANIFICACION = "";
        FECHA_CITOLOGIA = null;
        DIA_CITOLOGIA = "";
        MES_CITOLOGIA = "";
        ANNO_CITOLOGIA = "";
        RESULTADO_CITOLOGIA = "";
        ESTA_EMBARAZADA = "";
        APECTO_CUELLO = "";
        FECHA_CAUTERIZACION = null;
        FECHA_HISTERECTOMIA = null;
        FECHA_CONIZACION = null;
        FECHA_RADIOTERAPIA = null;
        FECHA_BIOPSA = null;
        FECHA_CRIOTERAPIA = null;
        FECHA_ATA = null;
        FECHA_OTRO = null;
        FECHA_COLPOSCOPIA = null;
        OTRO_CUAL = "";
        NINGUNO = "";
        CAUTERIZACION = "";
        HISTERECTOMIA = "";
        CONIZACION = "";
        RADIOTERAPIA = "";
        BIOPSIA = "";
        CRIOTERAPIA = "";
        ATA = "";
        OTRO = "";
        COLPOSCOPIA = "";
        TOMADA = "";
        FECHA_TOMADA = null;
        NOMBRE_TOMADA = "";
        NUMERO_CITOLOGIA = null;
        FECHA_VPH = null;
        VPH = "";
        DOSIS_VPH = null;
        OBSERVACIONES_TOMA = null;
        OTROS_HALLAZGOS = "";
        OTROS_HALLAZGOS_TOMA = "";

        CALIDAD_MUESTRA = "";
        MICROORGANISMOS = "";
        OTROS_MICRO = "";
        CATEGORIZACION = "";
        OTROS_HALLAZGOS = "";
        ANORMAL_ESCA = "";
        ANORMAL_GLANDU = "";
        OTRAS_NEOPLACITAS = "";
        OBSERVACIONES = "";

        DIA_PRIMERA_LECTURA = "";
        MES_PRIMERA_LECTURA = "";
        ANO_PRIMERA_LECTURA = "";
        DIA_SEGUNDA_LECTURA = "";
        MES_SEGUNDA_LECTURA = "";
        ANO_SEGUNDA_LECTURA = "";
        NOMBRE_PRIMERA_LECTURA = "";
        NOMBRE_SEGUNDA_LECTURA = "";
        PRIMERA_LEIDA = "";
        SEGUNDA_LEIDA = "";

        DIA_VPH = "";
        MES_VPH = "";
        ANO_VPH = "";
    }

    public void clearFormularioVph() {
        NUMERO_TIPIFICACION = null;
        CENTRO = "";
        HVLCGT16 = "";
        HVLCGT18 = "";
        HVLCGT31 = "";
        HVLCGT45 = "";
        HVLCGT51 = "";
        HVLCGT52 = "";
        HVLCGT3858 = "";
        HVLCGT353968 = "";
        HVLCGT565966 = "";
        LECTURA_NOMBRRE_PROFESIONAL = "";
        LECTURA_TARJETA_PROFESIONAL = "";
        CONDUCTA = "";
        DIA_LECTURA = "";
        MES_LECTURA = "";
        ANO_LECTURA = "";
        DIA_TOMADA = "";
        MES_TOMADA = "";
        ANO_TOMADA = "";
        DIA_RECEP = "";
        MES_RECEP = "";
        ANO_RECEP = "";
        INTERPRETACION = "";
        GENOTIPIFICACION = "";

    }


    //------------------------------------------------------------------------------------------------------------------
    //  Boton Principal 
    //------------------------------------------------------------------------------------------------------------------

    public String generarCitologia() {
        index = -1;
        clearReporte();
        clearFormularioVph();
        wexito = true;
        entrega.setHlccoperador(userName());
        entrega.setHlcdfecregistr(new Date());
        entrega.setHlcanumeiden(citologia.getCcianumide());
        entrega.setHlcetipoiden(citologia.getCcictipide());
        entrega.setHlccprimerapel(citologia.getCcicpriape());
        entrega.setHlccsegundapel(citologia.getCcicsegape());
        entrega.setHlccprimernomb(citologia.getCcicprinom());
        entrega.setHlccsegundnomb(citologia.getCcicsegnom());
        entrega.setHlcnconsec(citologia.getCcinconsec());

        toma = null;
        lectura = null;
        lecturaVPH=null;
        
        if (citologia != null) {
                   try {
                       toma = 
                     serviceLocator.getClinicoService().getTomaCitologia(citologia.getCcinconsec());
                       lectura = 
                               serviceLocator.getClinicoService().getLecturaCitologia(citologia.getCcinconsec());
                       lecturaVPH=serviceLocator.getClinicoService().getLecturaCitologiaVph(citologia.getCcinconsec());         
                   } catch (ModelException e) {
                       e.printStackTrace();
                   }
               }




        if (lectura == null) {
            if(lecturaVPH == null){
                wexito = false;
            }
        }

        if (wexito) {
            try {
               serviceLocator.getClinicoService().entregarCitologia(citologia,entrega);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            try {
            
                URL url = null;
                URL url_profamilia = null;
                URL url_firma = null;
                
                if(citologia != null && citologia.getCcilconcli() != null )
                try {
                    esPolicia = serviceLocator.getClinicoService().esPoliciaNacional(citologia.getCcilconcli().intValue()) ;
                } catch (ModelException e) {
                   e.printStackTrace();
                }

                if (lectura != null) {
                    if (esPolicia) {
                        url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologiaPolicia.jasper");
                        url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_POLICIA);
                        obtenerDatosReporte(citologia.getCcinconsec());
                    } else {
                        url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/tomaCitologia.jasper");

                        url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                        obtenerDatosReporte(citologia.getCcinconsec());
                    }
                } else if (lecturaVPH != null) {
                    url = FacesUtils.getFacesContext().getExternalContext().getResource("/reports/EntregaTipificacionVPH FO_GS_AD-022.jasper");
                    url_profamilia = FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_PROFAMILIA_NEW);
                    
                    if (lecturaVPH.getCcvcusureg().equals("cl01dasg")) {
                        url_firma = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_DIANA_SALCEDO);
                    } else if (lecturaVPH.getCcvcusureg().equals("cl01lkmm")) {
                        url_firma = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MARROQUIN);
                    }else if (lecturaVPH.getCcvcusureg().equals("cl01lahm")) {
                        url_firma = 
                                FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_LAURA_HERRERA);
                    }else if (lecturaVPH.getCcvcusureg().equals("cl01ksmg")) {
                        url_firma = 
                                 FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_FIRMA_KAREN_MEDINA);
                    }
                    
                    obtenerDatosReporteVPH();
                }
                           
                URL url_super_horizontal = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_HORIZONTAL);
                URL url_super_vertical = 
                    FacesUtils.getFacesContext().getExternalContext().getResource(IMAGE_SUPER_VERTICAL);

                if (url != null) {
                    Map parameters = new HashMap();
                    parameters.put("IMAGE_PROFAMILIA", url_profamilia);
                    parameters.put("IMAGE_SUPER_HORIZONTAL", url_super_horizontal);
                    parameters.put("IMAGE_SUPER_VERTICAL", url_super_vertical);
                    parameters.put("IMAGE_FIRMA", url_firma);
                    byte[] bytes;

                    JasperReport report = (JasperReport)JRLoader.loadObject(url);

                    bytes = 
                            JasperRunManager.runReportToPdf(report, parameters, (JRDataSource)this);
                    PdfServletUtils.showPdfDocument(bytes, 
                                                    "Documento" + Calendar.getInstance().getTimeInMillis() + 
                                                    ".pdf", false);

                    generoCitologia = true;
                    
                    FacesUtils.addInfoMessage("Se genero correctamente la entrega");

                }
            } catch (Exception e) {
                e.printStackTrace();
                FacesUtils.addErrorMessage("No pudo generar el reporte " + 
                                           e.getMessage());
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_EXISTE_LECTURA_CITOLOGIA);
        }

        //FacesUtils.resetManagedBean("consultarEntregaCitologiasBean");
        //FacesUtils.resetManagedBean("entregaCitologiaBean");
        return "";
    }
    

    public void setLecturaVPH(Cncitovphlect lecturaVPH) {
        this.lecturaVPH = lecturaVPH;
    }

    public Cncitovphlect getLecturaVPH() {
        return lecturaVPH;
    }

    public void setEsPolicia(boolean esPolicia) {
        this.esPolicia = esPolicia;
    }

    public boolean isEsPolicia() {
        return esPolicia;
    }
}
