//=======================================================================
// ARCHIVO RegistrarVademecumBean.java
// FECHA CREACI�N: 25/01/2017
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Regsitro de los medicamentos para el buevo Vademecum 2017
//=======================================================================

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
 package org.profamilia.hc.view.backing.clinico.vademecum;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chvademprof;
 import org.profamilia.hc.view.backing.BaseBean;
//=======================================================================
//  CLASE AntecedentePrenatalUsuarioBean
//=======================================================================

public class RegistrarVademecumBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private Chvademprof vademecum;
    
    private List lstUnidadMedida;
    
    private List lstFormaFarmaceutica;
    
    private List lstViaAdministracion;
    
    private List lstFrecuencia;
    
    private List lstClase;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public RegistrarVademecumBean() {
    }

    public void init() {
        vademecum = new Chvademprof();

    }

  


    //-----------------------------------------------------------------------
    //  GET/SET
    //-----------------------------------------------------------------------


         public void setVademecum(Chvademprof vademecum) {
             this.vademecum = vademecum;
         }

         public Chvademprof getVademecum() {
             return vademecum;
         }
    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    //-----------------------------------------------------------------------
    //  AJAX
    //-----------------------------------------------------------------------

    //-----------------------------------------------------------------------
    //  BOTON PRINCIPAL
    //-----------------------------------------------------------------------



    public void registrarVademecum(){
        System.out.println("Hola Mundo Entroooo ....");
    }

    public void setLstUnidadMedida(List lstUnidadMedida) {
        this.lstUnidadMedida = lstUnidadMedida;
    }


    /**
     * @return
     */
    public List getLstUnidadMedida() {
    if(lstUnidadMedida == null || lstUnidadMedida.isEmpty()){
        lstUnidadMedida = new ArrayList();
        lstUnidadMedida.add(new SelectItem("",""));
        lstUnidadMedida.add(new SelectItem("g","Gramo"));
        lstUnidadMedida.add(new SelectItem("G","Gramo"));
        lstUnidadMedida.add(new SelectItem("G/L","Gramo/Litro"));
        lstUnidadMedida.add(new SelectItem("g/mL"," Gramo X Mililitro"));
        lstUnidadMedida.add(new SelectItem("mcg","Microgramo"));
        lstUnidadMedida.add(new SelectItem("mg","Miligramo"));
        lstUnidadMedida.add(new SelectItem("mg/mL","Microgramo X Mililitro"));
        lstUnidadMedida.add(new SelectItem("MEQ/ML","MEQ/ML"));
        lstUnidadMedida.add(new SelectItem("MG/MCG","MG/MCG"));
        lstUnidadMedida.add(new SelectItem("mcg/ML","mcg/ML"));
        lstUnidadMedida.add(new SelectItem("MCG","MCG"));
        lstUnidadMedida.add(new SelectItem("MG-G","MG-G"));
        lstUnidadMedida.add(new SelectItem("mL","Mililitro"));
        lstUnidadMedida.add(new SelectItem("UI","Unidad Internacional"));
        lstUnidadMedida.add(new SelectItem("UI/ML","Unidad Internacional/ Mililitro"));
        lstUnidadMedida.add(new SelectItem("%","Porcentaje"));
        lstUnidadMedida.add(new SelectItem("_","_"));
        
    }
    
        return lstUnidadMedida;
    }
    
    
    public void setLstFormaFarmaceutica(List lstFormaFarmaceutica) {
        this.lstFormaFarmaceutica = lstFormaFarmaceutica;
    }

    public List getLstFormaFarmaceutica() {
        if(lstFormaFarmaceutica == null || lstFormaFarmaceutica.isEmpty()){
            lstFormaFarmaceutica = new ArrayList();
            lstFormaFarmaceutica.add(new SelectItem("",""));
            lstFormaFarmaceutica.add(new SelectItem("AMPO","Ampolla"));
            lstFormaFarmaceutica.add(new SelectItem("CREM","Crema"));
            lstFormaFarmaceutica.add(new SelectItem("DIU","Diu"));
            lstFormaFarmaceutica.add(new SelectItem("EMUL","Emulsiones"));
            lstFormaFarmaceutica.add(new SelectItem("GOTA","Gota"));
            lstFormaFarmaceutica.add(new SelectItem("IMSU","Implante Subdermico"));
            lstFormaFarmaceutica.add(new SelectItem("INTR","Intrauterino"));
            lstFormaFarmaceutica.add(new SelectItem("INYE","Inyectable"));
            lstFormaFarmaceutica.add(new SelectItem("OVUL","Ovulo"));
            lstFormaFarmaceutica.add(new SelectItem("POLV","Polvo"));
            lstFormaFarmaceutica.add(new SelectItem("SOLU","Solucion Liquida"));
            lstFormaFarmaceutica.add(new SelectItem("SUSP","Suspensi�n"));
            lstFormaFarmaceutica.add(new SelectItem("TABL","Tableta"));
            lstFormaFarmaceutica.add(new SelectItem("CAPS","Capsulas"));
            lstFormaFarmaceutica.add(new SelectItem("IMPL","Implante"));
            lstFormaFarmaceutica.add(new SelectItem("INH","Inhalable"));
            lstFormaFarmaceutica.add(new SelectItem("N/A","No Aplica"));
        }
        
            return lstFormaFarmaceutica;
        }
        
        
    public void setLstViaAdministracion(List lstViaAdministracion) {
        this.lstViaAdministracion = lstViaAdministracion;
    }

    public List getLstViaAdministracion() {
        if(lstViaAdministracion == null || lstViaAdministracion.isEmpty()){
            lstViaAdministracion = new ArrayList();
            lstViaAdministracion.add(new SelectItem("",""));
            lstViaAdministracion.add(new SelectItem("IM","Intramuscular"));
            lstViaAdministracion.add(new SelectItem("IV","Intravenosa"));
            lstViaAdministracion.add(new SelectItem("VO","Oral"));
            lstViaAdministracion.add(new SelectItem("VV","Vaginal"));
            lstViaAdministracion.add(new SelectItem("VP","Parenteral"));
            lstViaAdministracion.add(new SelectItem("VR","Rectal"));
            lstViaAdministracion.add(new SelectItem("Vsc","Subcutanea"));
            lstViaAdministracion.add(new SelectItem("Vsl","Sublingual"));
            lstViaAdministracion.add(new SelectItem("Vn","Nasal"));
            lstViaAdministracion.add(new SelectItem("Vt","Topica"));
            lstViaAdministracion.add(new SelectItem("INH","Inhalatoria"));
            lstViaAdministracion.add(new SelectItem("N/A","v�a nasal"));
            lstViaAdministracion.add(new SelectItem("VOF","Oftalmica"));
            lstViaAdministracion.add(new SelectItem("VOT","Otica"));
            lstViaAdministracion.add(new SelectItem("VTO","Topica"));
            lstViaAdministracion.add(new SelectItem("N/A","No Aplica"));
            
        }
        
            return lstViaAdministracion;
        }
    public void setLstFrecuencia(List lstFrecuencia) {
        this.lstFrecuencia = lstFrecuencia;
    }

    public List getLstFrecuencia() {
        if(lstFrecuencia == null || lstUnidadMedida.isEmpty()){
            lstFrecuencia = new ArrayList();
            lstFrecuencia.add(new SelectItem("","--"));
            lstFrecuencia.add(new SelectItem("MI","Minutos"));
            lstFrecuencia.add(new SelectItem("HO","Horas"));
            lstFrecuencia.add(new SelectItem("DI","Dias"));
            lstFrecuencia.add(new SelectItem("SE","Semanal"));
            lstFrecuencia.add(new SelectItem("ME","Mensual"));
            lstFrecuencia.add(new SelectItem("TR","Trimestral"));
            lstFrecuencia.add(new SelectItem("UN","Unica"));
        
        }
            return lstFrecuencia;
        }


    public void setLstClase(List lstClase) {
        this.lstClase = lstClase;
    }

    public List getLstClase() {
        return lstClase;
    }
}
