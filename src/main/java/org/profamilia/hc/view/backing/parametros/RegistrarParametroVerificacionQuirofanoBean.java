package org.profamilia.hc.view.backing.parametros;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chparavrqui;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarParametroVerificacionQuirofanoBean extends BaseBean {

    private Chparavrqui parametroAdd;
    
    private List<Chparavrqui> lstParametro;

    private HtmlDataTable dtParametro;

    private List lstEstado;

    /** Almacena la lista de opciones 'SI' o 'NO' */
    private List lstOpciones;

    /** Almacena la lista de Etapa 'AA', 'AI' o 'AS' */
    private List lstEtapa;

    private String radioRegAnestesiologo;

    private boolean renderRegAnestesiologo;

    private String radioNoaplica;

    private boolean renderNoaplica;
    
    private boolean renderTitulo;
    
    private UIInput regAnestesiologo;
    
    private UIInput noAplica;
    
    private boolean renderGeneral;

    private boolean renderRegional;

    private boolean renderLocal;
    
    public RegistrarParametroVerificacionQuirofanoBean() {
    }

    public void init() {
        parametroAdd = new Chparavrqui();
        parametroAdd.setHpqcnoaplica("N");
        parametroAdd.setHpqcanesreg("N");
        parametroAdd.setHpqcanesgen("N");
        parametroAdd.setHpqcanesloc("N");
        parametroAdd.setHpqcreganeste("N");
        parametroAdd.setHpqcetapa(" ");
        radioRegAnestesiologo = "N";
        radioNoaplica = "N";
        renderTitulo = true;

        try {
            lstParametro = 
                    this.serviceLocator.getCirugiaService().getListaParametroVerificacionQuirofano();
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }


    public String volver() {
        return BeanNavegacion.RUTA_IR_INICIO;
    }

    public String editarParametro() {
        parametroAdd = (Chparavrqui)dtParametro.getRowData();

        if (parametroAdd.getHpqnnumeral().intValue() == 0) {
            renderTitulo = true;
        } else {
            renderTitulo = false;
        }
        if (parametroAdd.getHpqcanesgen().equals("S")) {
            renderGeneral = true;
        } else {
            renderGeneral = false;
        }
        
        if (parametroAdd.getHpqcanesreg().equals("S")) {
            renderRegional = true;
        } else {
            renderRegional = false;
        }
        
        if (parametroAdd.getHpqcanesloc().equals("S")) {
            renderLocal = true;
        } else {
            renderLocal = false;
        }
        return BeanNavegacion.RUTA_IR_REGISTRAR_PARAMETRO_VERIFICACION_QUIROFANO;
    }


    public void activarParametro() {

        Chparavrqui parametroActivar;
        parametroActivar = (Chparavrqui)dtParametro.getRowData();

        if (parametroActivar != null) {
            if (parametroActivar.getHpqcestado().equals("AC")) {
                parametroActivar.setHpqcestado("IN");
            } else {
                parametroActivar.setHpqcestado("AC");
            }
        }

        try {
            this.serviceLocator.getCirugiaService().saveParametroVerificacionQuirofano(parametroActivar);
            FacesUtils.addInfoMessage(MSG_ACTUALIZACION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(e.getMessage());
        } catch (Exception ex) {
            FacesUtils.addErrorMessage("No se puede activar/inactivar el parametro de verificacion de quirofano");
            FacesUtils.addErrorMessage(ex.getMessage());
        }
    }

    public String nuevoParametro() {
        parametroAdd = new Chparavrqui();
        parametroAdd.setHpqcnoaplica("N");
        parametroAdd.setHpqcanesreg("N");
        parametroAdd.setHpqcanesgen("N");
        parametroAdd.setHpqcanesloc("N");
        parametroAdd.setHpqcreganeste("N");
        radioRegAnestesiologo = "N";
        radioNoaplica = "N";
        renderTitulo = true;
        try {
            lstParametro = 
                    this.serviceLocator.getCirugiaService().getListaParametroVerificacionQuirofano();
        } catch (ModelException e) {
            e.printStackTrace();
        }

        return BeanNavegacion.RUTA_IR_REGISTRAR_PARAMETRO_VERIFICACION_QUIROFANO;
        
 
    }

    public String agregarParametro() {

        boolean wexito;
        wexito = true;
        if (lstParametro == null || lstParametro.isEmpty()) {
            lstParametro = new ArrayList<Chparavrqui>();
        }

        if (parametroAdd == null || parametroAdd.getHpqcliteral() == null) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:codigoLiteral", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
        }

        if (parametroAdd == null || parametroAdd.getHpqnnumeral() == null) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:codigoNumeral", 
                                           MSG_CAMPO_OBLIGATORIO);
              wexito = false;
        }
            
        if (parametroAdd == null || parametroAdd.getHpqcreganeste() == null) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:menuReganestesiologo", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
        }
            
        if (parametroAdd == null || parametroAdd.getHpqcdescri() == null || parametroAdd.getHpqcdescri().equals("")) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:itDescripcionRegistrarParametro", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexito = false;
        }

        if (parametroAdd == null || parametroAdd.getHpqcnoaplica() == null || parametroAdd.getHpqcnoaplica().equals("")) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:menuNoaplica", 
                                         MSG_CAMPO_OBLIGATORIO);
              wexito = false;
        }

        if (parametroAdd == null || parametroAdd.getHpqcanesgen() == null || parametroAdd.getHpqcanesgen().equals("")) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:menuTipoanestesia", 
                                         MSG_CAMPO_OBLIGATORIO);
              wexito = false;
        }

        if (parametroAdd == null || parametroAdd.getHpqcanesreg() == null || parametroAdd.getHpqcanesreg().equals("")) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:menuTipoanestesia", 
                                         MSG_CAMPO_OBLIGATORIO);
              wexito = false;
        }

        if (parametroAdd == null || parametroAdd.getHpqcanesloc() == null || parametroAdd.getHpqcanesloc().equals("")) {
              FacesUtils.addErrorMessage("body:infoRegistrarParametroForm:panelTabRegistrarParametro:menuTipoanestesia", 
                                         MSG_CAMPO_OBLIGATORIO);
              wexito = false;
        }

        if (wexito) {
            if (renderGeneral) {
                parametroAdd.setHpqcanesgen("S");
            } else {
                parametroAdd.setHpqcanesgen("N");
            }

            if (renderRegional) {
                parametroAdd.setHpqcanesreg("S");
            } else {
                parametroAdd.setHpqcanesreg("N");
            }

            if (renderLocal) {
                parametroAdd.setHpqcanesloc("S");
            } else {
                parametroAdd.setHpqcanesloc("N");
            }

            parametroAdd.setHpqdfecreg(new Date());
            parametroAdd.setHpqcusureg(userName());
            parametroAdd.setHpqcestado(ESTADO_ACTIVO);

            try {
                serviceLocator.getCirugiaService().saveParametroVerificacionQuirofano(parametroAdd);
                lstParametro = 
                        this.serviceLocator.getCirugiaService().getListaParametroVerificacionQuirofano();
                FacesUtils.addInfoMessage(MSG_ADICION);
            } catch (ModelException e) {
                FacesUtils.addInfoMessage(MSG_NO_ADICION);
                e.printStackTrace();
            }
        }
        
        if (wexito) {
            FacesUtils.resetManagedBean("registrarParametroVerificacionQuirofanoBean");
            return BeanNavegacion.RUTA_IR_REGISTRAR_PARAMETRO_VERIFICACION_QUIROFANO;
        }
        
        return BeanNavegacion.RUTA_ACTUAL;
    }


    /**
     * @param lstEstado
     */
    public void setLstEstado(List lstEstado) {
        this.lstEstado = lstEstado;
    }

    /**
     * @return
     */
    public List getLstEstado() {
        if (lstEstado == null || lstEstado.isEmpty()) {
            lstEstado = new ArrayList();
            lstEstado.add(new SelectItem("AC", "Activo"));
            lstEstado.add(new SelectItem("IN", "Inactivo"));
        }
        return lstEstado;
    }

    /**
     * @param dtParametro
     */
    public void setDtParametro(HtmlDataTable dtParametro) {
        this.dtParametro = dtParametro;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtParametro() {
        return dtParametro;
    }

    /**
     * @param parametroAdd
     */
    public void setParametroAdd(Chparavrqui parametroAdd) {
        this.parametroAdd = parametroAdd;
    }

    /**
     * @return
     */
    public Chparavrqui getParametroAdd() {
        return parametroAdd;
    }

    /**
     * @param lstParametro
     */
    public void setLstParametro(List<Chparavrqui> lstParametro) {
        this.lstParametro = lstParametro;
    }

    /**
     * @return
     */
    public List<Chparavrqui> getLstParametro() {
        return lstParametro;
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
     * @param lstEtapa
     */
    public void setLstEtapa(List lstEtapa) {
        this.lstEtapa = lstEtapa;
    }

    /**
     * @return
     */
    public List getLstEtapa() {
        if (lstEtapa == null) {
            lstEtapa = new ArrayList();
            lstEtapa.add(new SelectItem("AA", "Antes de Anestesia"));
            lstEtapa.add(new SelectItem("AI", "Antes de la Insici�n"));
            lstEtapa.add(new SelectItem("AS", "Antes de la Salida"));
        }
        return lstEtapa;
    }

    /**
     * @param radioRegAnestesiologo
     */
    public void setRadioRegAnestesiologo(String radioRegAnestesiologo) {
        this.radioRegAnestesiologo = radioRegAnestesiologo;
    }

    /**
     * @return
     */
    public String getRadioRegAnestesiologo() {
        return radioRegAnestesiologo;
    }

    /**
     * @param radioNoaplica
     */
    public void setRadioNoaplica(String radioNoaplica) {
        this.radioNoaplica = radioNoaplica;
    }

    /**
     * @return
     */
    public String getRadioNoaplica() {
        return radioNoaplica;
    }

    public void listenRegAnestesiologo(ValueChangeEvent valueChangeEvent) {
        parametroAdd.setHpqcreganeste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        if (parametroAdd != null || parametroAdd.getHpqcreganeste().equals("S"))
            renderRegAnestesiologo = true;
        else
            renderRegAnestesiologo = false;     
    }


    public void listenNoaplica(ValueChangeEvent valueChangeEvent) {
        parametroAdd.setHpqcnoaplica((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        
        if (parametroAdd != null || parametroAdd.getHpqcnoaplica().equals("S"))
            renderNoaplica = true;
        else
            renderNoaplica = false;     
    }

    /**
     * @param renderRegAnestesiologo
     */
    public void setRenderRegAnestesiologo(boolean renderRegAnestesiologo) {
        this.renderRegAnestesiologo = renderRegAnestesiologo;
    }

    /**
     * @return
     */
    public boolean getRenderRegAnestesiologo() {
        return renderRegAnestesiologo;
    }

    /**
     * @param renderNoaplica
     */
    public void setRenderNoaplica(boolean renderNoaplica) {
        this.renderNoaplica = renderNoaplica;
    }

    /**
     * @return
     */
    public boolean getRenderNoaplica() {
        return renderNoaplica;
    }


    public void muestraRegAnestesiologo(){   
    
    }

    public void muestraNoaplica(){   
    
    }
    
    public void setHpqnnumeral(ValueChangeEvent valueChangeEvent) {
        parametroAdd.setHpqnnumeral((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeNumeral() {
         if (parametroAdd != null && parametroAdd.getHpqnnumeral() != null && 
         parametroAdd.getHpqnnumeral().intValue() == 0) {
             renderTitulo = true;
         } else {
             renderTitulo = false;
             radioRegAnestesiologo = "N";
             radioNoaplica = "N";
         }
    }

    public void setRenderTitulo(boolean renderTitulo) {
        this.renderTitulo = renderTitulo;
    }

    public boolean getRenderTitulo() {
        return renderTitulo;
    }

    public void setRegAnestesiologo(UIInput regAnestesiologo) {
        this.regAnestesiologo = regAnestesiologo;
    }

    public UIInput getRegAnestesiologo() {
        return regAnestesiologo;
    }

    public void setNoAplica(UIInput noAplica) {
        this.noAplica = noAplica;
    }

    public UIInput getNoAplica() {
        return noAplica;
    }

    /**
     * @param renderGeneral
     * */
    public void setRenderGeneral(boolean renderGeneral) {
        this.renderGeneral = renderGeneral;
    }

    /**
     * @return
     */
    public boolean isRenderGeneral() {
        return renderGeneral;
    }

    /**
     * @param renderRegional
     * */
    public void setRenderRegional(boolean renderRegional) {
        this.renderRegional = renderRegional;
    }

    /**
     * @return
     */
    public boolean isRenderRegional() {
        return renderRegional;
    }

    /**
     * @param renderLocal
     * */
    public void setRenderLocal(boolean renderLocal) {
        this.renderLocal = renderLocal;
    }

    /**
     * @return
     */
    public boolean isRenderLocal() {
        return renderLocal;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderGeneral(ValueChangeEvent valueChangeEvent) {
        setRenderGeneral((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }
    
    /**
     * @param valueChangeEvent
     */
    public void setRenderRegional(ValueChangeEvent valueChangeEvent) {
        setRenderRegional((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }

    /**
     * @param valueChangeEvent
     */
    public void setRenderLocal(ValueChangeEvent valueChangeEvent) {
        setRenderLocal((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);

    }


    /**
     * @param valueChangeEvent
     */
    public void setHpqcreganeste(ValueChangeEvent valueChangeEvent) {
        parametroAdd.setHpqcreganeste((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpqcetapa(ValueChangeEvent valueChangeEvent) {
        parametroAdd.setHpqcetapa((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHpqcnoaplica(ValueChangeEvent valueChangeEvent) {
        parametroAdd.setHpqcnoaplica((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


}
