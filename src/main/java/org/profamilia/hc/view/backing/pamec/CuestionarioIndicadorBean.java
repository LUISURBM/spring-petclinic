package org.profamilia.hc.view.backing.pamec;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.profamilia.hc.model.dto.Chpamecindic;
import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class CuestionarioIndicadorBean extends BaseBean {

    private Chpamectema temaObject;  
    
    private List<Chpamecindic> lstIndicador; 
    
    private HtmlDataTable dtIndicador; 
    
    private boolean wcompleto; 
    
    private Integer wmes; 
    
    private Integer wanno; 


    public CuestionarioIndicadorBean() {
    }
    
    public void init(){
        dtIndicador = new HtmlDataTable(); 
        List<Object[]> lstIndicadorAux = null; 
        BigDecimal wcodindi = null; 
        BigDecimal wcoditema = null; 
        String wdescrip = null; 
        
        Calendar fechahoy = Calendar.getInstance(); 
        wanno = fechahoy.get(Calendar.YEAR);
        wmes = fechahoy.get(Calendar.MONTH)+11; 
       
        
        lstIndicador = new ArrayList<Chpamecindic>(); 
        
        
        try {
        if(temaObject != null && temaObject.getHptncodigo()!= null){
            lstIndicadorAux = this.serviceLocator.getCirugiaService().getCuestionarioIndicadorPamec(temaObject.getHptncodigo()); 
            
            if(lstIndicadorAux != null){
                for(Object[] aux: lstIndicadorAux){
                    wcodindi = (BigDecimal)aux[0];
                    wcoditema = (BigDecimal)aux[1];
                    wdescrip = (String)aux[2];
                  
                    
                    Chpamecindic indAux = new Chpamecindic();
                    if(wcodindi != null)
                    indAux.getId().setHpincodigo(wcodindi.intValue());
                    if(wcoditema != null)
                    indAux.getId().setHpincodigtema(wcoditema.intValue());
                    if(wdescrip!= null)
                    indAux.setHpicdescripcio(wdescrip);
                    
                    wcompleto = this.serviceLocator.getCirugiaService().verificarIndicador(wcoditema.intValue(),wcodindi.intValue(),2013, 03, getClinica().getCclncodigo());
                    indAux.setRenderIndicador(wcompleto);
                    
                    lstIndicador.add(indAux); 
                }
            }
            
        }
        
        
            
        } catch (ModelException e) {
            e.printStackTrace();
        }
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
     * @param lstIndicador
     */
    public void setLstIndicador(List<Chpamecindic> lstIndicador) {
        this.lstIndicador = lstIndicador;
    }

    /**
     * @return
     */
    public List<Chpamecindic> getLstIndicador() {
        return lstIndicador;
    }

    /**
     * @param dtIndicador
     */
    public void setDtIndicador(HtmlDataTable dtIndicador) {
        this.dtIndicador = dtIndicador;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtIndicador() {
        return dtIndicador;
    }

    /**
     * @return
     */
    public String volverTemas(){
        FacesUtils.resetManagedBean("cuestionarioTemaBean");
        CuestionarioTemaBean temasBean = (CuestionarioTemaBean)FacesUtils.getManagedBean("cuestionarioTemaBean");
        if(temasBean!= null){
            temasBean.init();
        }
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_TEMA_PAMEC; 
        
    }
    
    public String volverIndicadores(){
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_INDICADOR_PAMEC; 
    }

    /**
     * @return
     */
    public String irPregunta(){
        CuestionarioPreguntaBean preguntaBean = null; 
        preguntaBean = (CuestionarioPreguntaBean)FacesUtils.getManagedBean("cuestionarioPreguntaBean");
        
        Chpamecindic indiObject = (Chpamecindic)dtIndicador.getRowData(); 
        
        if(indiObject!= null && preguntaBean!= null ){
            preguntaBean.setIndicadorObject(indiObject);
            preguntaBean.setTemaObject(temaObject);
            preguntaBean.init();
        }
        
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_PREGUNTA_PAMEC; 
    }

}
