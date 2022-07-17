//=======================================================================
// ARCHIVO EncuestaViolenciaUsuarioBean.java
// FECHA CREACI�N: 20/05/2010
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la encuesta de violencia.
//=======================================================================

package org.profamilia.hc.view.backing.comun;
//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.ChviolenciaPK;
import org.profamilia.hc.model.dto.Chviolenremi;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;




//=======================================================================
//  CLASE EncuestaViolenciaUsuarioBean
//=======================================================================
public class EncuestaViolenciaUsuarioBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private String sufreViolencia;

    private List lstOpcionesViolencia;

    private boolean existeVioFisica;

    private boolean existeVioPsicologica;

    private boolean existeVioSexual;
    
    private boolean existeVioEconomica;
    
    private boolean existeVioCoercion;

    private boolean mostrarDeseaHablar;

    private boolean mostrar;

    private boolean mostrarRiesgo;

    private String sufreRiesgo;

    private String deseaHablar;

    private List lstRemision;

    private List lstTipoRemision;

    private String tipoSelect;

    private boolean mostrarCual;

    private Integer tipoHistoria;

    private Chviolencia encuesta;

    /** Almacena true si ingreso correctamente los datos */
    private boolean exito;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private String tipoServicio;

    private Long numeroConsulta;
    
    private List ltsTiempo;
    
    private List lstRemisionInterna;
    
    private List lstRemisionExterna;
    
    private boolean renderRemisionInterna; 
    
    private boolean renderRemisionExterna; 
    
    private UIInput mnuTipoRemisionExterno;
    
    private boolean mostrarMensaje;
    
    private boolean mostrarMensajeTipVioFisica;
    
    private boolean mostrarMensajeTipVioPsicologica;
    
    private boolean mostrarMensajeTipVioSexual;
    
    private boolean mostrarMensajeTipVioEconomica;
    
    private boolean mostrarMensajeTipVioCoerciOnreproductiva;
    
    private boolean renderPrenatal;
    
    
    

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public EncuestaViolenciaUsuarioBean() {
    }

    public void init() {
        exito = true;
        nextAction = "";
        inicializarEncuesta();
    }

    // ACTIONS

    public void inicializarEncuesta() {
        sufreViolencia = "";
        existeVioFisica=false;
        existeVioPsicologica=false;
        existeVioSexual=false;
        existeVioEconomica=false;
        existeVioCoercion=false;
        mostrarMensaje=false;
        mostrar=false;
        try {
            if (numeroConsulta != null) {
                encuesta = 
                        this.getServiceLocator().getClinicoService().getEncuestaViolencia(numeroConsulta);
            }

        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (encuesta == null) {
            encuesta = new Chviolencia();
        } else {
            if (encuesta.getHvicremitidoa() != null && 
                encuesta.getHvicremitidoa().equals("0")) {
                mostrarCual = true;
            } else {
                mostrarCual = false;
            }

            if (encuesta.getHvicremitidoa() != null) {
                try {
                    tipoSelect = 
                            serviceLocator.getClinicoService().getTipoRemisionViolencia(encuesta.getHvicremitidoa());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
            }

            sufreViolencia = encuesta.getHviesufreviol();
            if (sufreViolencia != null && sufreViolencia.equals("S")) {
                mostrar = true;
                mostrarMensaje=true;
                if(HISTORIA_PRENATAL.equals(tipoHistoria)){
                    renderPrenatal= true;
                }else{
                    renderPrenatal= false;
                }
            }
            if (encuesta.getHvieviofisica() != null && 
                encuesta.getHvieviofisica().equals("S")) {
                existeVioFisica = true;
            }
            if (encuesta.getHvieviopsicol() != null && 
                encuesta.getHvieviopsicol().equals("S")) {
                existeVioPsicologica = true;
            }
            if (encuesta.getHvieviosexual() != null && 
                encuesta.getHvieviosexual().equals("S")) {
                existeVioSexual = true;
            }
            
            if (encuesta.getHvieviocoerci() != null && 
                encuesta.getHvieviocoerci().equals("S")) {
                existeVioCoercion= true;
            }
            
            if (encuesta.getHvievioeconom() != null && 
                encuesta.getHvievioeconom().equals("S")) {
                existeVioEconomica= true;
            }
            
            if (encuesta.getHvictienreex() != null && 
                            encuesta.getHvictienreex().equals("S")) {
                            renderRemisionExterna = true;
             } else {
                    renderRemisionExterna = false;
                     mostrarCual = false; 
            }
            
            if (encuesta.getHvictienrein() != null && 
                            encuesta.getHvictienrein().equals("S")) {
                            renderRemisionInterna = true;
                } else {
                    renderRemisionInterna = false;
            }
            
            if (encuesta.getHvicremiexte() != null && 
                           encuesta.getHvicremiexte().equals("0")) {
                           mostrarCual = true;
                       } else {
                           mostrarCual = false;
                       }
            
            sufreRiesgo = encuesta.getHvieriesgo();
            deseaHablar = encuesta.getHviehabla();
            if (sufreRiesgo != null && sufreRiesgo.equals("S")) {
                mostrarRiesgo = true;
            } else {
                mostrarRiesgo = false;
            }
            if (deseaHablar != null && deseaHablar.equals("S")) {
                mostrarDeseaHablar = true;
            } else {
                mostrarDeseaHablar = false;
            }

        }
        if (lstRemision == null) {
            lstRemision = new ArrayList();
            lstRemision.add(new SelectItem("", "Seleccione una opci�n ..."));
        }

    }

    public void changeOtro() {
        if (encuesta != null) {
            encuesta.setHvilcualremisi(null);
            if (encuesta.getHvicremiexte() != null && 
                encuesta.getHvicremiexte().equals("0")) {
                mostrarCual = true;
            } else {
                mostrarCual = false;
            }
        }
    }
    
    public void changeRemisionInterna() {
        if (encuesta != null) {
            if (encuesta.getHvictienrein() != null && 
                encuesta.getHvictienrein().equals("S")) {
                renderRemisionInterna = true;
            } else {
                renderRemisionInterna = false;
            }
        }
    }
    
    
    public void changeRemisionExterna() {
        if (encuesta != null) {
            encuesta.setHvilcualremisi(null);
            encuesta.setHvicremiexte(null);
            mnuTipoRemisionExterno.setValue(null);
            if (encuesta.getHvictienreex() != null && 
                encuesta.getHvictienreex().equals("S")) {
                renderRemisionExterna = true;
            } else {
                renderRemisionExterna = false;
                mostrarCual = false; 
            }
        }
    }

    public void changeRemision() {

        mostrarCual = false;
    }

    public void changeViolencia() {

        if (sufreViolencia.equals("S")) {
            mostrar = true;
            mostrarMensaje=true;
            if(HISTORIA_PRENATAL.equals(tipoHistoria)){
                renderPrenatal= true;
            }else{
                renderPrenatal= false;
            }
        } else {
            existeVioFisica = false;
            existeVioPsicologica = false;
            existeVioSexual = false;
            existeVioCoercion = false; 
            existeVioEconomica = false;
            mostrarMensajeTipVioFisica = false;

            mostrarMensajeTipVioPsicologica = false;

            mostrarMensajeTipVioSexual = false;

            mostrarMensajeTipVioEconomica = false;

            mostrarMensajeTipVioCoerciOnreproductiva = false;

            encuesta.setHvicfisiquien(null);
            encuesta.setHvicpsicquien(null);
            encuesta.setHvicsexuquien(null);
            encuesta.setHviccoerquien(null);
            encuesta.setHviceconquien(null);
            
            encuesta.setHvintiemcoer(null);
            encuesta.setHvintiemecon(null);
            encuesta.setHvintiemsexu(null);
            encuesta.setHvintiempsic(null);
            encuesta.setHvintiemfisi(null);

            sufreRiesgo = null;

            encuesta.setHvicrsgxquien(null);
            deseaHablar = null;
            encuesta.setHvicremitidoa(null);
            encuesta.setHvitobserva(null);
            
            encuesta.setHvichumeinam(null);
            encuesta.setHvicgobopalaul(null);
            encuesta.setHvicgobopalage(null);
            encuesta.setHvicforrelsex(null);
            
            mostrar = false;
            mostrarMensaje=false;
            mostrarDeseaHablar = false;
            mostrarRiesgo = false;
            renderPrenatal= false;
        }
    }


    public void changeDeseaHablar() {
        if (deseaHablar != null && deseaHablar.equals("S")) {
            mostrarDeseaHablar = true;
            mostrarCual = true;
            encuesta.setHvilcualremisi("");
        } else {
            mostrarDeseaHablar = false;
            mostrarCual = false;
            encuesta.setHvicremitidoa("");
            encuesta.setHvilcualremisi("");
        }
    }


    public void changeSufreRiesgo() {
        if (sufreRiesgo != null && sufreRiesgo.equals("S")) {
            mostrarRiesgo = true;
        } else {
            mostrarRiesgo = false;
            encuesta.setHvicrsgxquien(null);
        }

    }

    public boolean esValido() {
        boolean esValido = false;
        Chviolencia encuestaAux = null;
        if (numeroConsulta != null) {
            try {
                encuestaAux = 
                        this.getServiceLocator().getClinicoService().getEncuestaViolencia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }
        if (encuestaAux != null) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    public void changeViolenciaFisica() {
        if (!existeVioFisica) {
            encuesta.setHvicfisiquien(null);
        }
    }

    public void changeViolenciaPsicologica() {
        if (!existeVioPsicologica) {
            encuesta.setHvicpsicquien(null);
        }
    }

    public void changeViolenciaSexual() {
        if (!existeVioSexual) {
            encuesta.setHvicsexuquien(null);
        }
    }


    public void changeViolenciaEconomica() {
        if (!existeVioEconomica) {
            encuesta.setHviceconquien(null);
        }
    }


    public void changeViolenciaCoercion() {
        if (!existeVioCoercion) {
            encuesta.setHviccoerquien(null);
        }
    }
    /**
     * @return
     */
    public String guardarEncuesta() {

        navigationRule = "";
        exito = true;
        ChviolenciaPK id = new ChviolenciaPK();

        if (sufreViolencia != null && sufreViolencia.equals("S")) {
            if (existeVioFisica == false && existeVioPsicologica == false && 
                existeVioSexual == false && existeVioCoercion == false && existeVioEconomica == false) {
                FacesUtils.addErrorMessage(IMsg.MSG_NO_SELECCIONO_VIOLENCIA);
                exito = false;
            }
        }
        
        if(!renderRemisionInterna){
            encuesta.setHvicremiinte(null);
        }
        
        
        if(!renderRemisionExterna){
            encuesta.setHvicremiexte(null);
        }
        
        if(!existeVioFisica){
            encuesta.setHvicfisiquien(null);
            encuesta.setHvintiemfisi(null);
        }
        
        if(!existeVioPsicologica){
            encuesta.setHvicpsicquien(null);
            encuesta.setHvintiempsic(null);
        }
        
        if(!existeVioSexual){
            encuesta.setHvicsexuquien(null);
            encuesta.setHvintiemsexu(null);
        }
        
        if(!existeVioCoercion){
            encuesta.setHviccoerquien(null);
            encuesta.setHvintiemcoer(null);
        }
        
        if(!existeVioEconomica){
            encuesta.setHviceconquien(null);
            encuesta.setHvintiemecon(null);
        }
        
        
        

        if (exito) {
            if (numeroConsulta != null) {
                id.setHvilconsulta(numeroConsulta);
                id.setHvictiposervi(tipoServicio);
                encuesta.setId(id);
            }
            encuesta.setHvicoperador(userName());
            encuesta.setHvidfecregistr(new Date());
            encuesta.setHviesufreviol(sufreViolencia);
            if (sufreViolencia != null && sufreViolencia.equals("S")) {
                if (existeVioFisica) {
                    encuesta.setHvieviofisica("S");
                } else {
                    encuesta.setHvieviofisica("N");
                }

                if (existeVioPsicologica) {
                    encuesta.setHvieviopsicol("S");
                } else {
                    encuesta.setHvieviopsicol("N");
                }
                if (existeVioSexual) {
                    encuesta.setHvieviosexual("S");
                } else {
                    encuesta.setHvieviosexual("N");
                }
                
                if (existeVioEconomica) {
                    encuesta.setHvievioeconom("S");
                } else {
                    encuesta.setHvievioeconom("N");
                }
                
                if (existeVioCoercion) {
                    encuesta.setHvieviocoerci("S");
                } else {
                    encuesta.setHvieviocoerci("N");
                }

                encuesta.setHviedeseaseso(sufreRiesgo);
                encuesta.setHviehabla(deseaHablar);
                encuesta.setHvieriesgo(sufreRiesgo);


            } else {
                existeVioFisica = false;
                encuesta.setHvieviofisica(null);
                existeVioPsicologica = false;
                encuesta.setHvieviopsicol(null);
                existeVioSexual = false;
                encuesta.setHvieviosexual(null);
                encuesta.setHvicfisiquien(null);
                encuesta.setHvicpsicquien(null);
                encuesta.setHvicsexuquien(null);
                sufreRiesgo = null;
                encuesta.setHvicrsgxquien(null);
                deseaHablar = null;
                encuesta.setHvicremitidoa(null);
                encuesta.setHvitobserva(null);
                encuesta.setHvieriesgo(null);
                encuesta.setHviedeseaseso(null);
                encuesta.setHviehabla(null);
                encuesta.setHvilcualremisi(null);
                
                existeVioEconomica = false; 
                encuesta.setHvievioeconom(null);
                encuesta.setHviceconquien(null);
                
                existeVioCoercion = false; 
                encuesta.setHvieviocoerci(null);
                encuesta.setHviccoerquien(null);
            }
            try {
                this.serviceLocator.getClinicoService().saveEncuestaViolencia(encuesta);
                FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

                // Se recarga el menu 
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;

            } catch (ModelException e) {
                navigationRule = "";
                return capturaError(e,IConstantes.ERROR_GUARDADO);
            }
        }

        // Se establece la siguiente accion de navegacion
        return navigationRule;
    }

    public void changeTiempoOcurrenciaEvento() {
        mostrarMensajeTipVioFisica = false;

        mostrarMensajeTipVioPsicologica = false;

        mostrarMensajeTipVioSexual = false;

        mostrarMensajeTipVioEconomica = false;

        mostrarMensajeTipVioCoerciOnreproductiva = false;

        if (encuesta.getHvintiemfisi() != null) {
            mostrarMensajeTipVioFisica = 
                    validacionMensajeTiempoOcurrencia(encuesta.getHvintiemfisi());
        }

        if (encuesta.getHvintiempsic() != null) {
            mostrarMensajeTipVioPsicologica = 
                    validacionMensajeTiempoOcurrencia(encuesta.getHvintiempsic());
        }

        if (encuesta.getHvintiemsexu() != null) {
            mostrarMensajeTipVioSexual = 
                    validacionMensajeTiempoOcurrencia(encuesta.getHvintiemsexu());
        }

        if (encuesta.getHvintiemecon() != null) {
            mostrarMensajeTipVioEconomica = 
                    validacionMensajeTiempoOcurrencia(encuesta.getHvintiemecon());
        }

        if (encuesta.getHvintiemcoer() != null) {
            mostrarMensajeTipVioCoerciOnreproductiva = 
                    validacionMensajeTiempoOcurrencia(encuesta.getHvintiemcoer());
        }


    }

    public boolean validacionMensajeTiempoOcurrencia(Integer dato) {
        if (dato == 1 || dato == 2 || dato == 3) {
            return true;
        } else {
            return false;
        }
    }

    // ACCESSORS

    /**
     * @param sufreViolencia
     */
    public void setSufreViolencia(String sufreViolencia) {
        this.sufreViolencia = sufreViolencia;
    }

    /**
     * @param valueChangeEvent
     */
    public void setSufreViolencia(ValueChangeEvent valueChangeEvent) {
        setSufreViolencia((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHvictienrein(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvictienrein((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    public void setHvictienreex(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvictienreex((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    public void setHvintiemfisi(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvintiemfisi((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    public void setHvintiempsic(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvintiempsic((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHvintiemsexu(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvintiemsexu((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHvintiemecon(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvintiemecon((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setHvintiemcoer(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvintiemcoer((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    

    public String getSufreViolencia() {
        return sufreViolencia;
    }

    public void setLstOpcionesViolencia(List lstOpcionesViolencia) {
        this.lstOpcionesViolencia = lstOpcionesViolencia;
    }

    public List getLstOpcionesViolencia() {
        if (lstOpcionesViolencia == null || lstOpcionesViolencia.isEmpty()) {
            lstOpcionesViolencia = new ArrayList();
            lstOpcionesViolencia.add(new SelectItem("S", "SI"));
            lstOpcionesViolencia.add(new SelectItem("N", "NO"));

        }

        return lstOpcionesViolencia;
    }


    public void setExisteVioFisica(ValueChangeEvent valueChangeEvent) {
        setExisteVioFisica((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setExisteVioEconomica(ValueChangeEvent valueChangeEvent) {
        setExisteVioEconomica((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }
    
    public void setExisteVioCoercion(ValueChangeEvent valueChangeEvent) {
        setExisteVioCoercion((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setExisteVioFisica(boolean existeVioFisica) {
        this.existeVioFisica = existeVioFisica;
    }

    public boolean getExisteVioFisica() {
        return existeVioFisica;
    }


    public void setExisteVioPsicologica(ValueChangeEvent valueChangeEvent) {
        setExisteVioPsicologica((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void setExisteVioPsicologica(boolean existeVioPsicologica) {
        this.existeVioPsicologica = existeVioPsicologica;
    }

    public boolean isExisteVioPsicologica() {
        return existeVioPsicologica;
    }

    public void setExisteVioSexual(ValueChangeEvent valueChangeEvent) {
        setExisteVioSexual((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    public void setExisteVioSexual(boolean existeVioSexual) {
        this.existeVioSexual = existeVioSexual;
    }

    public boolean isExisteVioSexual() {
        return existeVioSexual;
    }


    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setEncuesta(Chviolencia encuesta) {
        this.encuesta = encuesta;
    }

    public Chviolencia getEncuesta() {
        return encuesta;
    }


    public void setSufreRiesgo(String sufreRiesgo) {
        this.sufreRiesgo = sufreRiesgo;
    }

    public void setSufreRiesgo(ValueChangeEvent valueChangeEvent) {
        setSufreRiesgo((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    public String getSufreRiesgo() {
        return sufreRiesgo;
    }

    public void setDeseaHablar(String deseaHablar) {
        this.deseaHablar = deseaHablar;
    }

    public void setDeseaHablar(ValueChangeEvent valueChangeEvent) {
        setDeseaHablar((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    public void setLstRemision(List lstRemision) {
        this.lstRemision = lstRemision;
    }

    public List getLstRemision() {
        if (tipoSelect != null) {
            lstRemision = new ArrayList();
            lstRemision.add(new SelectItem("", "Seleccione una opci�n ..."));
            ArrayList<Chviolenremi> listlstRemisionAux = null;
            try {
                listlstRemisionAux = 
                        (ArrayList<Chviolenremi>)this.serviceLocator.getClinicoService().getRemisionViolencia(tipoSelect);
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listlstRemisionAux.isEmpty()) {

                Iterator it = listlstRemisionAux.iterator();
                int i = 0;

                while (it.hasNext()) {
                    it.next();
                    lstRemision.add(new SelectItem(listlstRemisionAux.get(i).getHvrccodigo(), 
                                                   listlstRemisionAux.get(i).getHvrcdescripcio()));
                    i++;
                }
            }
        }

        return lstRemision;
    }

    public String getDeseaHablar() {
        return deseaHablar;
    }

    public void setMostrarDeseaHablar(boolean mostrarDeseaHablar) {
        this.mostrarDeseaHablar = mostrarDeseaHablar;
    }

    public boolean isMostrarDeseaHablar() {
        return mostrarDeseaHablar;
    }

    public void setMostrarRiesgo(boolean mostrarRiesgo) {
        this.mostrarRiesgo = mostrarRiesgo;
    }

    public boolean isMostrarRiesgo() {
        return mostrarRiesgo;
    }


    public void setLstTipoRemision(List lstTipoRemision) {
        this.lstTipoRemision = lstTipoRemision;
    }

    public List getLstTipoRemision() {
        if (lstTipoRemision == null || lstTipoRemision.isEmpty()) {
            lstTipoRemision = new ArrayList();
            lstTipoRemision.add(new SelectItem("I", "Interno"));
            lstTipoRemision.add(new SelectItem("E", "Externo"));
        }
        return lstTipoRemision;
    }

    public void setTipoSelect(ValueChangeEvent valueChangeEvent) {
        setTipoSelect((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    public void setTipoSelect(String tipoSelect) {
        this.tipoSelect = tipoSelect;
    }

    public String getTipoSelect() {
        return tipoSelect;
    }


    public void setMostrarCual(boolean mostrarCual) {
        this.mostrarCual = mostrarCual;
    }

    public boolean isMostrarCual() {
        return mostrarCual;
    }


    public void setHvicremitidoa(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvicremitidoa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }
    
    public void setHvicremiexte(ValueChangeEvent valueChangeEvent) {
        encuesta.setHvicremiexte((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }


    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    public String getMenuBean() {
        return menuBean;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }


    public void setExisteVioEconomica(boolean existeVioEconomica) {
        this.existeVioEconomica = existeVioEconomica;
    }

    public boolean isExisteVioEconomica() {
        return existeVioEconomica;
    }

    public void setExisteVioCoercion(boolean existeVioCoercion) {
        this.existeVioCoercion = existeVioCoercion;
    }

    public boolean isExisteVioCoercion() {
        return existeVioCoercion;
    }

    public void setLtsTiempo(List ltsTiempo) {
        this.ltsTiempo = ltsTiempo;
    }

    public List getLtsTiempo() {
        if (ltsTiempo == null || ltsTiempo.isEmpty()) {
            ltsTiempo = new ArrayList();
            ltsTiempo.add(new SelectItem("", "Seleccione"));
            ltsTiempo.add(new SelectItem(1, "Menor de 24 Horas"));
            ltsTiempo.add(new SelectItem(2, "Entre 24 y 72 Horas"));
            ltsTiempo.add(new SelectItem(3, "Entre 72 y 120 Horas"));
            ltsTiempo.add(new SelectItem(4, "Entre 5 d�as y un ano"));
            ltsTiempo.add(new SelectItem(5, "Mayor a un ano"));
        }
        return ltsTiempo;
        }

    public void setLstRemisionInterna(List lstRemisionInterna) {
        this.lstRemisionInterna = lstRemisionInterna;
    }

    public List getLstRemisionInterna() {
        lstRemisionInterna = new ArrayList();
        lstRemisionInterna.add(new SelectItem("", "Seleccione una opci�n ..."));
        ArrayList<Chviolenremi> listlstRemisionAux = null;
        try {
            listlstRemisionAux = 
                    (ArrayList<Chviolenremi>)this.serviceLocator.getClinicoService().getRemisionViolencia("I");
        } catch (ModelException e) {
            e.printStackTrace();
        }

        if (!listlstRemisionAux.isEmpty()) {

            Iterator it = listlstRemisionAux.iterator();
            int i = 0;

            while (it.hasNext()) {
                it.next();
                lstRemisionInterna.add(new SelectItem(listlstRemisionAux.get(i).getHvrccodigo(), 
                                               listlstRemisionAux.get(i).getHvrcdescripcio()));
                i++;
            }
        }
        

        return lstRemisionInterna;
        }

    public void setLstRemisionExterna(List lstRemisionExterna) {
        this.lstRemisionExterna = lstRemisionExterna;
    }

    public List getLstRemisionExterna() {
     
            lstRemisionExterna = new ArrayList();
            lstRemisionExterna.add(new SelectItem("", "Seleccione una opci�n ..."));
            ArrayList<Chviolenremi> listlstRemisionAux = null;
            try {
                listlstRemisionAux = 
                        (ArrayList<Chviolenremi>)this.serviceLocator.getClinicoService().getRemisionViolencia("E");
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listlstRemisionAux.isEmpty()) {

                Iterator it = listlstRemisionAux.iterator();
                int i = 0;

                while (it.hasNext()) {
                    it.next();
                    lstRemisionExterna.add(new SelectItem(listlstRemisionAux.get(i).getHvrccodigo(), 
                                                   listlstRemisionAux.get(i).getHvrcdescripcio()));
                    i++;
                }
            }
        

        return lstRemisionExterna;
        }


  

    public void setRenderRemisionInterna(boolean renderRemisionInterna) {
        this.renderRemisionInterna = renderRemisionInterna;
    }

    public boolean isRenderRemisionInterna() {
        return renderRemisionInterna;
    }

    public void setRenderRemisionExterna(boolean renderRemisionExterna) {
        this.renderRemisionExterna = renderRemisionExterna;
    }

    public boolean isRenderRemisionExterna() {
        return renderRemisionExterna;
    }


    public void setMnuTipoRemisionExterno(UIInput mnuTipoRemisionExterno) {
        this.mnuTipoRemisionExterno = mnuTipoRemisionExterno;
    }

    public UIInput getMnuTipoRemisionExterno() {
        return mnuTipoRemisionExterno;
    }

    public void setMostrarMensaje(boolean mostrarMensaje) {
        this.mostrarMensaje = mostrarMensaje;
    }

    public boolean isMostrarMensaje() {
        return mostrarMensaje;
    }

    public void setMostrarMensajeTipVioFisica(boolean mostrarMensajeTipVioFisica) {
        this.mostrarMensajeTipVioFisica = mostrarMensajeTipVioFisica;
    }

    public boolean isMostrarMensajeTipVioFisica() {
        return mostrarMensajeTipVioFisica;
    }

    public void setMostrarMensajeTipVioPsicologica(boolean mostrarMensajeTipVioPsicologica) {
        this.mostrarMensajeTipVioPsicologica = mostrarMensajeTipVioPsicologica;
    }

    public boolean isMostrarMensajeTipVioPsicologica() {
        return mostrarMensajeTipVioPsicologica;
    }

    public void setMostrarMensajeTipVioSexual(boolean mostrarMensajeTipVioSexual) {
        this.mostrarMensajeTipVioSexual = mostrarMensajeTipVioSexual;
    }

    public boolean isMostrarMensajeTipVioSexual() {
        return mostrarMensajeTipVioSexual;
    }

    public void setMostrarMensajeTipVioEconomica(boolean mostrarMensajeTipVioEconomica) {
        this.mostrarMensajeTipVioEconomica = mostrarMensajeTipVioEconomica;
    }

    public boolean isMostrarMensajeTipVioEconomica() {
        return mostrarMensajeTipVioEconomica;
    }

    public void setMostrarMensajeTipVioCoerciOnreproductiva(boolean mostrarMensajeTipVioCoerciOnreproductiva) {
        this.mostrarMensajeTipVioCoerciOnreproductiva = mostrarMensajeTipVioCoerciOnreproductiva;
    }

    public boolean isMostrarMensajeTipVioCoerciOnreproductiva() {
        return mostrarMensajeTipVioCoerciOnreproductiva;
    }

    public boolean isExisteVioFisica() {
        return existeVioFisica;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public boolean isExito() {
        return exito;
    }

    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    public String getNavigationRule() {
        return navigationRule;
    }

    public void setRenderPrenatal(boolean renderPrenatal) {
        this.renderPrenatal = renderPrenatal;
    }

    public boolean isRenderPrenatal() {
        return renderPrenatal;
    }
}

