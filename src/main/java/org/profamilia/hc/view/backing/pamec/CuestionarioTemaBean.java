package org.profamilia.hc.view.backing.pamec;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class CuestionarioTemaBean extends BaseBean {

    private HtmlDataTable dtTema; 
    
    private List lstTema; 
    
    private Integer wanno; 
    
    private Integer wmes; 
    
    private BigDecimal wcoditema; 
    
    private String wdescrip; 
    
    private boolean wcompleto; 

    public CuestionarioTemaBean() {
    
    }
    
    
    public void init(){
        dtTema = new HtmlDataTable(); 
        
        List<Object[]> lstTemaAux = null; 
        lstTema = new ArrayList(); 
        
        Calendar fechahoy = Calendar.getInstance(); 
        wanno = fechahoy.get(Calendar.YEAR);
        wmes = fechahoy.get(Calendar.MONTH)+11; 
        try {
            lstTemaAux = this.serviceLocator.getCirugiaService().getCuestionarioTemasPamec(userName(),getClinica().getCclncodigo()); 

        } catch (ModelException e) {
            e.printStackTrace();
        }
        
        if(lstTemaAux != null && !lstTemaAux.isEmpty()){
            for(Object[] temaObject :lstTemaAux){
               
                wcoditema = (BigDecimal)temaObject[0];
                wdescrip = (String)temaObject[1];
                
                Chpamectema temaAux = new Chpamectema(); 
                temaAux.setHptncodigo(wcoditema.intValue());
                temaAux.setHptcdescripcio(wdescrip);
                try {
                    wcompleto = this.serviceLocator.getCirugiaService().verificarTema(wcoditema.intValue(),2013, 3, getClinica().getCclncodigo());
                } catch (ModelException e) {
                    e.printStackTrace();
                }
                temaAux.setRenderTema(wcompleto);  
               
                
                lstTema.add(temaAux); 
            }
        }
        

    }


    /**
     * @param dtTema
     */
    public void setDtTema(HtmlDataTable dtTema) {
        this.dtTema = dtTema;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtTema() {
        return dtTema;
    }

    /**
     * @param lstTema
     */
    public void setLstTema(List lstTema) {
        this.lstTema = lstTema;
    }

    /**
     * @return
     */
    public List getLstTema() {
        return lstTema;
    }

    /**
     * @param wanno
     */
    public void setWanno(Integer wanno) {
        this.wanno = wanno;
    }

    /**
     * @return
     */
    public Integer getWanno() {
        return wanno;
    }

    /**
     * @param wmes
     */
    public void setWmes(Integer wmes) {
        this.wmes = wmes;
    }

    /**
     * @return
     */
    public Integer getWmes() {
        return wmes;
    }

    /**
     * @return
     */
    public String irIndicadores(){
        CuestionarioIndicadorBean indicadorBean = null; 
        indicadorBean = (CuestionarioIndicadorBean)FacesUtils.getManagedBean("cuestionarioIndicadorBean"); 
        Chpamectema temaObject = (Chpamectema)dtTema.getRowData(); 
        
        if(temaObject != null && indicadorBean != null){
            indicadorBean.setTemaObject(temaObject);
            indicadorBean.init();
        }
    
        return BeanNavegacion.RUTA_IR_CUESTIONARIO_INDICADOR_PAMEC; 
    }


  
}
