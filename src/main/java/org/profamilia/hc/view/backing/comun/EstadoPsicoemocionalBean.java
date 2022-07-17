package org.profamilia.hc.view.backing.comun;

import java.util.*;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class EstadoPsicoemocionalBean extends BaseBean
{

    private Chestadpsico estadopsico;
    private String tipoServicio;
    private Long numeroConsulta;
    private Integer tipoHistoria;
    private Chusuario usuario;
    private String nextAction;
    private String menuBean;
    private String navigationRule;
    private List lstAreaCognitiva;
    private List lstAreaAfectiva;
    private List lstAreaSomatico;
    private List lstAreaRelacional;
    private List<String> lstAreaCognitivaSelect;
    private List<String> lstAreaAfectivaSelect;
    private List<String> lstAreaSomaticoSelect;
    private List<String> lstAreaRelacionalSelect;
    private boolean renderOtroSomatico;
    private boolean renderOtroRelacional;
    private boolean renderOtroCognitivo;
    private boolean renderFobia; 


    public EstadoPsicoemocionalBean()
    {
    }

    public void init()
    {
        lstAreaCognitivaSelect = new ArrayList<String>();
        lstAreaAfectivaSelect = new ArrayList<String>();
        lstAreaSomaticoSelect = new ArrayList<String>();
        lstAreaRelacionalSelect = new ArrayList<String>();
        estadopsico = new Chestadpsico();
    }

    public void inicializarEstadoPsicoemocional()
    {
        renderOtroCognitivo = false;
        renderOtroRelacional = false;
        renderOtroSomatico = false;
        renderFobia = false; 
        if(numeroConsulta != null)
            try
            {
                estadopsico = getServiceLocator().getClinicoService().getEstadoPsicoemocional(numeroConsulta, "C");
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
        if(estadopsico == null)
        {
            estadopsico = new Chestadpsico();
        } else
        {
            if(estadopsico.getHepcareacogni() != null && !estadopsico.getHepcareacogni().equals(""))
            {
                StringTokenizer stk = new StringTokenizer(estadopsico.getHepcareacogni(), ",");
                String areacogniAux = null;
                while(stk.hasMoreTokens()) 
                {
                    areacogniAux = "";
                    areacogniAux = stk.nextToken();
                    if(areacogniAux != null)
                    {
                        if(areacogniAux.equals("OT"))
                            renderOtroCognitivo = true;
                        lstAreaCognitivaSelect.add(areacogniAux);
                    }
                }
            }
            if(estadopsico.getHepcareaafect() != null && !estadopsico.getHepcareaafect().equals(""))
            {
                StringTokenizer stk = new StringTokenizer(estadopsico.getHepcareaafect(), ",");
                String areaafectAux = null;
                while(stk.hasMoreTokens()) 
                {
                    areaafectAux = "";
                    areaafectAux = stk.nextToken();
                    if(areaafectAux != null)
                        lstAreaAfectivaSelect.add(areaafectAux);
                }
            }
            if(estadopsico.getHepcareasomat() != null && !estadopsico.getHepcareasomat().equals(""))
            {
                StringTokenizer stk = new StringTokenizer(estadopsico.getHepcareasomat(), ",");
                String areasomatiAux = null;
                while(stk.hasMoreTokens()) 
                {
                    areasomatiAux = "";
                    areasomatiAux = stk.nextToken();
                    if(areasomatiAux != null)
                    {
                        if(areasomatiAux.equals("OT"))
                            renderOtroSomatico = true;
                        lstAreaSomaticoSelect.add(areasomatiAux);
                    }
                }
            }
            if(estadopsico.getHepcarearelac() != null && !estadopsico.getHepcarearelac().equals(""))
            {
                StringTokenizer stk = new StringTokenizer(estadopsico.getHepcarearelac(), ",");
                String arearelacAux = null;
                while(stk.hasMoreTokens()) 
                {
                    arearelacAux = "";
                    arearelacAux = stk.nextToken();
                    if(arearelacAux != null)
                    {
                        if(arearelacAux.equals("OT"))
                            renderOtroRelacional = true;
                        lstAreaRelacionalSelect.add(arearelacAux);
                    }
                    
                    if(arearelacAux.equals("FO")){
                        renderFobia = true; 
                    }
                }
            }
        }
    }

    public String guardarEstadoPsicoemocional()
    {
        navigationRule = "";
        String areaCognitiva = "";
        String areaAfectiva = "";
        String areaSomatica = "";
        String areaRelacional = "";
        boolean wexito = true;
        if(numeroConsulta != null){
            estadopsico.getId().setHepctiposerv(tipoServicio);
            estadopsico.getId().setHeplconsulta(numeroConsulta);
            estadopsico.setHepcoperador(userName());
            estadopsico.setHepdfecreg(new Date());
        }
        if(lstAreaAfectivaSelect == null || lstAreaAfectivaSelect.isEmpty())
        {
            FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaAfectivaPsicoemocional", "El campo es obligatorio");
            wexito = false;
        }
        if(lstAreaSomaticoSelect == null || lstAreaSomaticoSelect.isEmpty())
        {
            FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaSomaticoPsicoemocional", "El campo es obligatorio");
            wexito = false;
        }
        if(lstAreaRelacionalSelect == null || lstAreaRelacionalSelect.isEmpty())
        {
            FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaRelacionalPsicoemocional", "El campo es obligatorio");
            wexito = false;
        }
        if(lstAreaCognitivaSelect == null || lstAreaCognitivaSelect.isEmpty())
        {
            FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaCognitiva", "El campo es obligatorio");
            wexito = false;
        }
        if(lstAreaAfectivaSelect != null && !lstAreaAfectivaSelect.isEmpty())
        {
            for(Iterator iterator = lstAreaAfectivaSelect.iterator(); iterator.hasNext();)
            {
                String areaafec = (String)iterator.next();
                areaAfectiva = (new StringBuilder()).append(areaAfectiva).append(areaafec).append(",").toString();
            }

            if(areaAfectiva != null && areaAfectiva.length() > 2)
            {
                areaAfectiva = areaAfectiva.substring(0, areaAfectiva.length() - 1);
                estadopsico.setHepcareaafect(areaAfectiva);
            }
        }
        if(lstAreaCognitivaSelect != null && !lstAreaCognitivaSelect.isEmpty())
        {
            for(Iterator iterator1 = lstAreaCognitivaSelect.iterator(); iterator1.hasNext();)
            {
                String areacogn = (String)iterator1.next();
                areaCognitiva = (new StringBuilder()).append(areaCognitiva).append(areacogn).append(",").toString();
            }

            if(areaCognitiva != null && areaCognitiva.length() > 2)
            {
                areaCognitiva = areaCognitiva.substring(0, areaCognitiva.length() - 1);
                estadopsico.setHepcareacogni(areaCognitiva);
            }
        }
        if(lstAreaSomaticoSelect != null && !lstAreaSomaticoSelect.isEmpty())
        {
            for(Iterator iterator2 = lstAreaSomaticoSelect.iterator(); iterator2.hasNext();)
            {
                String areasoma = (String)iterator2.next();
                areaSomatica = (new StringBuilder()).append(areaSomatica).append(areasoma).append(",").toString();
            }

            if(areaSomatica != null && areaSomatica.length() > 2)
            {
                areaSomatica = areaSomatica.substring(0, areaSomatica.length() - 1);
                estadopsico.setHepcareasomat(areaSomatica);
            }
        }
        if(lstAreaRelacionalSelect != null && !lstAreaRelacionalSelect.isEmpty())
        {
            for(Iterator iterator3 = lstAreaRelacionalSelect.iterator(); iterator3.hasNext();)
            {
                String arearela = (String)iterator3.next();
                areaRelacional = (new StringBuilder()).append(areaRelacional).append(arearela).append(",").toString();
            }

            if(areaRelacional != null && areaRelacional.length() > 2)
            {
                areaRelacional = areaRelacional.substring(0, areaRelacional.length() - 1);
                estadopsico.setHepcarearelac(areaRelacional);
            }
        }
        if(!renderOtroCognitivo){
            estadopsico.setHepcotrocogni(null);
        }
            
        if(!renderOtroRelacional){
            estadopsico.setHepcotrorelac(null);
        }
            
        if(!renderOtroSomatico){
            estadopsico.setHepcotrosomat(null);
        }
        if(lstAreaSomaticoSelect != null && !lstAreaSomaticoSelect.isEmpty()){
            for(String areasoma : lstAreaSomaticoSelect){
                if(areasoma.equals("SA") && lstAreaSomaticoSelect.size()>1){
                    FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaSomaticoPsicoemocional", "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }
        
        
        if(lstAreaRelacionalSelect!= null && !lstAreaRelacionalSelect.isEmpty()){
            for(String arearela : lstAreaRelacionalSelect){
                if(arearela.equals("SA") && lstAreaRelacionalSelect.size()>1){
                    FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaRelacionalPsicoemocional", "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }
        
        if(lstAreaCognitivaSelect!= null && !lstAreaCognitivaSelect.isEmpty()){
            for(String areacogn : lstAreaCognitivaSelect){
                if(areacogn.equals("SA") && lstAreaCognitivaSelect.size()>1){
                    FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaCognitiva", "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }
        
        
        if(lstAreaAfectivaSelect!= null && !lstAreaAfectivaSelect.isEmpty()){
            for(String areaafect : lstAreaAfectivaSelect){
                if(areaafect.equals("SAL") && lstAreaAfectivaSelect.size()>1){
                    FacesUtils.addErrorMessage("body:formEstadoPsicoemocional:panelTabEstadoPsicoemocional:mnuAreaAfectivaPsicoemocional", "La opci�n sin alteraci�n es excluyente");
                    wexito = false;
                }
            }
        }
            
        if(wexito){
            try
            {
                serviceLocator.getClinicoService().saveEstadoPsicoemocional(estadopsico);
                FacesUtils.addInfoMessage("Se ingreso la informaci�n satisfactoriamente.");
                FacesUtils.resetManagedBean(menuBean);
                navigationRule = nextAction;
            }
            catch(ModelException e)
            {
                e.printStackTrace();
                navigationRule = "";
                FacesUtils.addErrorMessage("Adicion no realizada");
            }
        } else {
            navigationRule = BeanNavegacion.RUTA_ACTUAL;
        }
        return navigationRule;
    }

    /**
     * @return
     */
    public boolean esValido()
    {
        Chestadpsico estadoAux = null;
        if(numeroConsulta != null)
            try
            {
                estadoAux = getServiceLocator().getClinicoService().getEstadoPsicoemocional(numeroConsulta, "C");
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
        return estadoAux != null;
    }

    /**
     * @param valueChangeEvent
     */
    public void setLstAreaSomaticoSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstAreaSomaticoSelect((List<String>) valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setLstAreaRelacionalSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstAreaRelacionalSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setLstAreaCognitivaSelect(ValueChangeEvent valueChangeEvent)
    {
        setLstAreaCognitivaSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void ChangeAreaSomatica()
    {
        renderOtroSomatico = false;
        if(lstAreaSomaticoSelect != null && !lstAreaSomaticoSelect.isEmpty())
        {
            for(Iterator iterator = lstAreaSomaticoSelect.iterator(); iterator.hasNext();)
            {
                String codigo = (String)iterator.next();
                if(codigo.equals("OT"))
                    renderOtroSomatico = true;
            }

        }
    }

    public void ChangeAreaRelacional()
    {
        renderOtroRelacional = false;
        renderFobia = false; 
        if(lstAreaRelacionalSelect != null && !lstAreaRelacionalSelect.isEmpty())
        {
            for(Iterator iterator = lstAreaRelacionalSelect.iterator(); iterator.hasNext();)
            {
                String codigo = (String)iterator.next();
                if(codigo.equals("OT")){
                    renderOtroRelacional = true;
                }
                
                if(codigo.equals("FO")){
                    renderFobia = true; 
                }
                    
            }

        }
    }

    public void ChangeAreaCognitiva()
    {
        renderOtroCognitivo = false;
        if(lstAreaCognitivaSelect != null && !lstAreaCognitivaSelect.isEmpty())
        {
            for(Iterator iterator = lstAreaCognitivaSelect.iterator(); iterator.hasNext();)
            {
                String codigo = (String)iterator.next();
                if(codigo.equals("OT"))
                    renderOtroCognitivo = true;
            }

        }
    }

    /**
     * @param lstAreaCognitiva
     */
    public void setLstAreaCognitiva(List lstAreaCognitiva)
    {
        this.lstAreaCognitiva = lstAreaCognitiva;
    }

    /**
     * @return
     */
    public List getLstAreaCognitiva()
    {
        if(lstAreaCognitiva == null || lstAreaCognitiva.isEmpty())
        {
            lstAreaCognitiva = new ArrayList();
            lstAreaCognitiva.add(new SelectItem("SA", "Sin Alteraciones Aparentes"));
            lstAreaCognitiva.add(new SelectItem("DI", "Dispersa"));
            lstAreaCognitiva.add(new SelectItem("PN", "Pensamientos negativos frecuentes"));
            lstAreaCognitiva.add(new SelectItem("DP", "Dificultad para resolver problemas"));
            lstAreaCognitiva.add(new SelectItem("IP", "Ideas de persecuci�n"));
//            lstAreaCognitiva.add(new SelectItem("IM", "Incapacidad Mental"));
            lstAreaCognitiva.add(new SelectItem("DC", "Dificultad para la concentraci�n y producci�n intelectual"));
            lstAreaCognitiva.add(new SelectItem("OT", "Otro"));
        }
        return lstAreaCognitiva;
    }

    /**
     * @param lstAreaAfectiva
     */
    public void setLstAreaAfectiva(List lstAreaAfectiva)
    {
        this.lstAreaAfectiva = lstAreaAfectiva;
    }

    /**
     * @return
     */
    public List getLstAreaAfectiva()
    {
        if(lstAreaAfectiva == null || lstAreaAfectiva.isEmpty())
        {
            lstAreaAfectiva = new ArrayList();
            
            lstAreaAfectiva.add(new SelectItem("SAL", "Sin Alteraciones Aparentes"));
            lstAreaAfectiva.add(new SelectItem("ANG", "Angustiada"));
            lstAreaAfectiva.add(new SelectItem("DEP", "Deprimida"));
            lstAreaAfectiva.add(new SelectItem("CON", "Confundida"));
            lstAreaAfectiva.add(new SelectItem("APA", "Ap�tica"));
            lstAreaAfectiva.add(new SelectItem("ANS", "Ansiosa"));
            lstAreaAfectiva.add(new SelectItem("SDD", "Sentimientos de desesperanza"));
            lstAreaAfectiva.add(new SelectItem("IMP", "Impotencia"));
    }
        return lstAreaAfectiva;
    }

    /**
     * @param tipoServicio
     */
    public void setTipoServicio(String tipoServicio)
    {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return
     */
    public String getTipoServicio()
    {
        return tipoServicio;
    }

    /**
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta)
    {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta()
    {
        return numeroConsulta;
    }

    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria)
    {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria()
    {
        return tipoHistoria;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Chusuario usuario)
    {
        this.usuario = usuario;
    }

    /**
     * @return
     */
    public Chusuario getUsuario()
    {
        return usuario;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction)
    {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction()
    {
        return nextAction;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean)
    {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean()
    {
        return menuBean;
    }

    /**
     * @param lstAreaCognitivaSelect
     */
    public void setLstAreaCognitivaSelect(List <String>lstAreaCognitivaSelect)
    {
        this.lstAreaCognitivaSelect = lstAreaCognitivaSelect;
    }

    /**
     * @return
     */
    public List <String> getLstAreaCognitivaSelect()
    {
        return lstAreaCognitivaSelect;
    }

    /**
     * @param lstAreaAfectivaSelect
     */
    public void setLstAreaAfectivaSelect(List<String> lstAreaAfectivaSelect)
    {
        this.lstAreaAfectivaSelect = lstAreaAfectivaSelect;
    }


    /**
     * @return
     */
    public List<String> getLstAreaAfectivaSelect()
    {
        return lstAreaAfectivaSelect;
    }

    /**
     * @param estadopsico
     */
    public void setEstadopsico(Chestadpsico estadopsico)
    {
        this.estadopsico = estadopsico;
    }

    /**
     * @return
     */
    public Chestadpsico getEstadopsico()
    {
        return estadopsico;
    }

    /**
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule)
    {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule()
    {
        return navigationRule;
    }

    /**
     * @param lstAreaSomatico
     */
    public void setLstAreaSomatico(List lstAreaSomatico)
    {
        this.lstAreaSomatico = lstAreaSomatico;
    }

    /**
     * @return
     */
    public List getLstAreaSomatico()
    {
        if(lstAreaSomatico == null || lstAreaSomatico.isEmpty())
        {
            lstAreaSomatico = new ArrayList();
            lstAreaSomatico.add(new SelectItem("SA", "Sin Alteraciones Aparentes"));
            lstAreaSomatico.add(new SelectItem("AG", "Agotamiento"));
//            lstAreaSomatico.add(new SelectItem("IM", "Imsomnio"));
            lstAreaSomatico.add(new SelectItem("AS", "Alteraciones en el sue�o"));
            lstAreaSomatico.add(new SelectItem("IN", "Inapetecia"));
            lstAreaSomatico.add(new SelectItem("DE", "Debilidad"));
            lstAreaSomatico.add(new SelectItem("AH", "Ahogo"));
            lstAreaSomatico.add(new SelectItem("PA", "Palpitaciones"));
            lstAreaSomatico.add(new SelectItem("OT", "Otro"));
        }
        return lstAreaSomatico;
    }

    /**
     * @param lstAreaRelacional
     */
    public void setLstAreaRelacional(List lstAreaRelacional)
    {
        this.lstAreaRelacional = lstAreaRelacional;
    }

    /**
     * @return
     */
    public List getLstAreaRelacional()
    {
        if(lstAreaRelacional == null || lstAreaRelacional.isEmpty())
        {
            lstAreaRelacional = new ArrayList();
            lstAreaRelacional.add(new SelectItem("SA", "Sin Alteraciones Aparentes "));
            lstAreaRelacional.add(new SelectItem("AG", "Agresividad"));
            lstAreaRelacional.add(new SelectItem("AI", "Aislamiento"));
//            lstAreaRelacional.add(new SelectItem("PA", "Pasmada"));
            lstAreaRelacional.add(new SelectItem("FO", "Fobia"));
            lstAreaRelacional.add(new SelectItem("OT", "Otro"));
        }
        return lstAreaRelacional;
    }

    /**
     * @param lstAreaSomaticoSelect
     */
    public void setLstAreaSomaticoSelect(List<String>  lstAreaSomaticoSelect)
    {
        this.lstAreaSomaticoSelect = lstAreaSomaticoSelect;
    }

    /**
     * @return
     */
    public List<String> getLstAreaSomaticoSelect()
    {
        return lstAreaSomaticoSelect;
    }

    /**
     * @param lstAreaRelacionalSelect
     */
    public void setLstAreaRelacionalSelect(List<String> lstAreaRelacionalSelect)
    {
        this.lstAreaRelacionalSelect = lstAreaRelacionalSelect;
    }

    /**
     * @return
     */
    public List <String> getLstAreaRelacionalSelect()
    {
        return lstAreaRelacionalSelect;
    }

    /**
     * @param renderOtroSomatico
     */
    public void setRenderOtroSomatico(boolean renderOtroSomatico)
    {
        this.renderOtroSomatico = renderOtroSomatico;
    }

    /**
     * @return
     */
    public boolean isRenderOtroSomatico()
    {
        return renderOtroSomatico;
    }

    /**
     * @param renderOtroRelacional
     */
    public void setRenderOtroRelacional(boolean renderOtroRelacional)
    {
        this.renderOtroRelacional = renderOtroRelacional;
    }

    /**
     * @return
     */
    public boolean isRenderOtroRelacional()
    {
        return renderOtroRelacional;
    }

    /**
     * @param renderOtroCognitivo
     */
    public void setRenderOtroCognitivo(boolean renderOtroCognitivo)
    {
        this.renderOtroCognitivo = renderOtroCognitivo;
    }

    /**
     * @return
     */
    public boolean isRenderOtroCognitivo(){
        return renderOtroCognitivo;
    }


    /**
     * @param renderFobia
     */
    public void setRenderFobia(boolean renderFobia){
        this.renderFobia = renderFobia;
    }

    /**
     * @return
     */
    public boolean isRenderFobia() {
        return renderFobia;
    }

}
