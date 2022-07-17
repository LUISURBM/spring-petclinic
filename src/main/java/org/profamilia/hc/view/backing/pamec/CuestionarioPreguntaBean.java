package org.profamilia.hc.view.backing.pamec;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chcuestpamec;
import org.profamilia.hc.model.dto.Chpamecindic;
import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class CuestionarioPreguntaBean extends BaseBean  {

    private Chpamecindic indicadorObject; 
    
    private Chpamectema temaObject; 
    
    private List <Chcuestpamec> lstPregunta; 
    
    private HtmlDataTable dtPregunta; 
    
    private Integer mesActual; 
    
    private Integer wanno; 

    public CuestionarioPreguntaBean() {
    }
    
    
    public void init(){
    
    List<Object[]>lstPreguntaAux = null; 
        lstPregunta  = new ArrayList<Chcuestpamec>(); 
        Calendar fechaActual = Calendar.getInstance(); 
        mesActual = fechaActual.get(Calendar.MONTH) + 1; 
        wanno = fechaActual.get(Calendar.YEAR);
        
             
        try {
        if(indicadorObject != null && indicadorObject.getId()!= null && indicadorObject.getId().getHpincodigtema() != null
        && indicadorObject.getId().getHpincodigo() != null){
            lstPreguntaAux = this.serviceLocator.getCirugiaService().getCuestionarioPreguntaPamec(getClinica().getCclncodigo(),wanno,indicadorObject.getId().getHpincodigtema(),indicadorObject.getId().getHpincodigo()); 
        }
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        
        if(lstPreguntaAux!= null && !lstPreguntaAux.isEmpty()){
            for(Object[] preguntaAux: lstPreguntaAux){
            BigDecimal wcodpre = (BigDecimal)preguntaAux[0]; 
            BigDecimal wcodtema = (BigDecimal)preguntaAux[1];
            BigDecimal wcodindi = (BigDecimal)preguntaAux[2];
            String wdescrip = (String)preguntaAux[3];
            BigDecimal wenero = (BigDecimal)preguntaAux[4];
            BigDecimal wfebrero = (BigDecimal)preguntaAux[5];
            BigDecimal wmarzo = (BigDecimal)preguntaAux[6];
            BigDecimal wabril = (BigDecimal)preguntaAux[7];    
            BigDecimal wmayo = (BigDecimal)preguntaAux[8];
            BigDecimal wjunio = (BigDecimal)preguntaAux[9];
            BigDecimal wjulio = (BigDecimal)preguntaAux[10];
            BigDecimal wagosto = (BigDecimal)preguntaAux[11];
            BigDecimal wseptiembre = (BigDecimal)preguntaAux[12];
            BigDecimal woctubre = (BigDecimal)preguntaAux[13];
            BigDecimal wnoviembre = (BigDecimal)preguntaAux[14];
            BigDecimal wdiciembre = (BigDecimal)preguntaAux[15];
            
            
            
                Chcuestpamec cuestAux = new Chcuestpamec();
                cuestAux.getId().setHcpnanno(2013);
                cuestAux.getId().setHcpncodigclini(getClinica().getCclncodigo());
                cuestAux.getId().setHcpncodigindic(wcodindi.intValue());
                cuestAux.getId().setHcpncodigpregu(wcodpre.intValue());
                cuestAux.getId().setHcpncodigtema(wcodtema.intValue());
                
                if(wenero!= null)
                cuestAux.setHcpnmesenero(wenero.intValue());
                if(wfebrero!= null)
                cuestAux.setHcpnmesfebre(wfebrero.intValue());
                if(wmarzo!= null)
                cuestAux.setHcpnmesmarzo(wmarzo.intValue());
                if(wabril!= null)
                cuestAux.setHcpnmesabril(wabril.intValue());
                if(wmayo!= null)
                cuestAux.setHcpnmesmayo(wmayo.intValue());
                if(wjunio!= null)
                cuestAux.setHcpnmesjunio(wjunio.intValue());
                if(wjulio!= null)
                cuestAux.setHcpnmesjulio(wjulio.intValue());
                if(wagosto!= null)
                cuestAux.setHcpnmesagost(wagosto.intValue());
                if(wseptiembre!= null)
                cuestAux.setHcpnmessepti(wseptiembre.intValue());
                if(woctubre!= null)
                cuestAux.setHcpnmesoctub(woctubre.intValue());
                if(wnoviembre!= null)
                cuestAux.setHcpnmesnovie(wnoviembre.intValue());
                if(wdiciembre!= null)
                cuestAux.setHcpnmesdicie(wdiciembre.intValue());
                cuestAux.setHppcestado(ESTADO_VIGENTE);
                cuestAux.setHppcoperador(userName());
                cuestAux.setHcpcdescrpregu(wdescrip);
                lstPregunta.add(cuestAux); 
                                
            }
        }
        
    }


    /**
     * @param indicadorObject
     */
    public void setIndicadorObject(Chpamecindic indicadorObject) {
        this.indicadorObject = indicadorObject;
    }

    /**
     * @return
     */
    public Chpamecindic getIndicadorObject() {
        return indicadorObject;
    }

    /**
     * @param lstPregunta
     */
    public void setLstPregunta(List<Chcuestpamec> lstPregunta) {
        this.lstPregunta = lstPregunta;
    }

    /**
     * @return
     */
    public List<Chcuestpamec> getLstPregunta() {
        return lstPregunta;
    }

    /**
     * @param mesActual
     */
    public void setMesActual(Integer mesActual) {
        this.mesActual = mesActual;
    }

    /**
     * @return
     */
    public Integer getMesActual() {
        return mesActual;
    }

    /**
     * @param dtPregunta
     */
    public void setDtPregunta(HtmlDataTable dtPregunta) {
        this.dtPregunta = dtPregunta;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPregunta() {
        return dtPregunta;
    }

    /**
     * @param temaObject
     */
    public void setTemaObject(Chpamectema temaObject) {
        this.temaObject = temaObject;
    }

    /**
     * @return
     */
    public Chpamectema getTemaObject() {
        return temaObject;
    }

    /**
     * @return
     */
    public String volverIndicadores(){
      FacesUtils.resetManagedBean("cuestionarioIndicadorBean");
        CuestionarioIndicadorBean indicadorBean = (CuestionarioIndicadorBean)FacesUtils.getManagedBean("cuestionarioIndicadorBean");
        if(indicadorBean != null){
            indicadorBean.setTemaObject(temaObject);
            indicadorBean.init();
        }


        return BeanNavegacion.RUTA_IR_CUESTIONARIO_INDICADOR_PAMEC; 
    }

    public void actualizarPreguntas() {

        try {
            this.serviceLocator.getCirugiaService().saveCuestionario(lstPregunta);
            FacesUtils.addInfoMessage(MSG_ADICION);
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
           e.printStackTrace();
        }
    }


    
}
