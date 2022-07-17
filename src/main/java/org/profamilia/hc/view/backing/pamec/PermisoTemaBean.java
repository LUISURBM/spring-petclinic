package org.profamilia.hc.view.backing.pamec;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.dto.Chpermitema;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.util.FacesUtils;

public class PermisoTemaBean extends BaseBean {


    private Integer wcodigoTema;

    private List lstTema;

    private String wusuario;

    private List lstUsuario;
    
    private List<Object[]> lstPermiso; 
    
    private HtmlDataTable dtPermiso; 

    public PermisoTemaBean() {
    }
    
    public void init(){
        dtPermiso = new HtmlDataTable(); 
        try {
            lstPermiso =  this.serviceLocator.getCirugiaService().getListaPermisoTemaPamec(wcodigoTema,
                                                                                getClinica().getCclncodigo());
        } catch (ModelException e) {
            e.printStackTrace();
        }
        
    }


    public void setWcodigoTema(Integer wcodigoTema) {
        this.wcodigoTema = wcodigoTema;
    }

    public Integer getWcodigoTema() {
        return wcodigoTema;
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

        if (lstTema == null || lstTema.isEmpty()) {
            lstTema = new ArrayList();
            ArrayList<Chpamectema> lstTemaAux = null;
            try {
                lstTemaAux = 
                        (ArrayList<Chpamectema>)this.serviceLocator.getCirugiaService().getListaTemasPamec();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (lstTemaAux!= null && !lstTemaAux.isEmpty()) {

                Iterator it = lstTemaAux.iterator();
                int i = 0;
                lstTema.add(new SelectItem("", "Seleccione una opci�n"));
                while (it.hasNext()) {
                    it.next();
                    lstTema.add(new SelectItem(lstTemaAux.get(i).getHptncodigo(), 
                                               lstTemaAux.get(i).getHptcdescripcio()));
                    i++;
                }
            }
        }

        return lstTema;
    }

    /**
     * @param wusuario
     */
    public void setWusuario(String wusuario) {
        this.wusuario = wusuario;
    }

    /**
     * @return
     */
    public String getWusuario() {
        return wusuario;
    }

  
    /**
     * @param dtPermiso
     */
    public void setDtPermiso(HtmlDataTable dtPermiso) {
        this.dtPermiso = dtPermiso;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtPermiso() {
        return dtPermiso;
    }

    /**
     * @param lstPermiso
     */
    public void setLstPermiso(List<Object[]> lstPermiso) {
        this.lstPermiso = lstPermiso;
    }

    /**
     * @return
     */
    public List<Object[]> getLstPermiso() {
        return lstPermiso;
    }

    /**
     * @param lstUsuario
     */
    public void setLstUsuario(List lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    /**
     * @return
     */
    public List getLstUsuario() {
        if (lstUsuario == null || lstTema.isEmpty()) {
            lstUsuario = new ArrayList();
            List<Object[]> lstUsuariosAux = null;
            try {
                lstUsuariosAux = 
                        this.serviceLocator.getCirugiaService().getListaUsuariosPorClinica(getClinica().getCclncodigo());
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstUsuariosAux.isEmpty()) {

                Iterator it = lstUsuariosAux.iterator();
                int i = 0;
                lstUsuario.add(new SelectItem("", "Seleccione una opci�n"));
                while (it.hasNext()) {
                    Object[] aux = (Object[])it.next();
                    String usuario = null;
                    String descripcion = "";
                    usuario = (String)aux[0];
                    descripcion = (String)aux[1];

                    lstUsuario.add(new SelectItem(usuario, descripcion));


                    i++;
                }
            }
        }

        return lstUsuario;
    }

    /**
     * @return
     */
    public String asignarPermiso() {

        Chpermitema temaPermiso = new Chpermitema();
        Chpermitema temaAux = null;
        boolean wexito = true;  

        try {
            temaPermiso.getId().setHptcusuarpamec(wusuario);
            temaPermiso.getId().setHptncodigclini(getClinica().getCclncodigo());
            temaPermiso.getId().setHptncodigtema(wcodigoTema);
            temaPermiso.setHptcoperador(userName());
            temaPermiso.setHptdfecregistr(new Date());

            temaAux = 
                    this.serviceLocator.getCirugiaService().getPermisoTemaPamec(wcodigoTema, 
                                                                                getClinica().getCclncodigo(), 
                                                                                wusuario);
                                                                                
            if(temaAux != null){
                wexito = false; 
            }

            if(wexito){
                this.serviceLocator.getCirugiaService().savePermisoTemaPamec(temaPermiso);
                FacesUtils.addInfoMessage(MSG_ADICION);    
            }else{
                wexito = false; 
                FacesUtils.addErrorMessage(MSG_EXISTE_PERMISO);    
            }
            
            if(wexito){
                lstPermiso =  this.serviceLocator.getCirugiaService().getListaPermisoTemaPamec(wcodigoTema,
                                                                                    getClinica().getCclncodigo());
            }
            
        } catch (ModelException e) {
            FacesUtils.addInfoMessage(MSG_NO_ADICION);
            e.printStackTrace();
        }
        wcodigoTema = null;
        wusuario = "";

        return BeanNavegacion.RUTA_ACTUAL;
    }

    /**
     * 
     */
    public void eliminarPermiso(){
        Object[] aux = (Object[])dtPermiso.getRowData(); 
        BigDecimal codigoTema = null; 
        String usuartema = null;
        BigDecimal codclin = null;
        Chpermitema temaAux = null; 
        
        codigoTema = (BigDecimal)aux[0]; 
        usuartema = (String)aux[2];
        codclin = (BigDecimal)aux[4];
        
        if(codigoTema!= null && usuartema!= null && codclin!= null){
            try {
                temaAux =
                    this.serviceLocator.getCirugiaService().getPermisoTemaPamec(codigoTema.intValue(),
                                                                                codclin.intValue(),
                                                                                usuartema);
                                                                                
                if(temaAux != null){
                    this.serviceLocator.getCirugiaService().deletePermisoTemaPamec(temaAux);
                    FacesUtils.addInfoMessage(MSG_ELIMINACION);
                }
            
            } catch (ModelException e) {
                FacesUtils.addErrorMessage(MSG_NO_ELIMINACION);
                e.printStackTrace();
            }
        }
        
        lstPermiso.remove(aux); 
        
    }


   
}
