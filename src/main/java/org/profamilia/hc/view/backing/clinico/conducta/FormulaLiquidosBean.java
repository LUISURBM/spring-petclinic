//=======================================================================
// ARCHIVO FormulaLiquidosBean.java
// AUTOR: jariano, nlis, carlos
// Descripcion: Permite registrar la formulacion de Liquidos para un paciente
//=======================================================================
package org.profamilia.hc.view.backing.clinico.conducta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chliquiparen;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;

//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//====================================================================


//=================================================================
//  CLASE FormulaLiquidosBean
//=======================================================================
public class FormulaLiquidosBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chformulaliq liquidos;

    private Chformulaliq liquidosDelete;

    private boolean modoConsulta;

    private List lstClaseSangre;

    private List lstGrupoSangre;

    private List lstFactorSangre;

    private List lstVia;

    private List lstFormaAdministracion;

    private List<Chformulaliq> lstLiquidos;

    private HtmlDataTable dtLiquidos;

    private boolean mostrarAdministracion;
    
    private boolean mostrarFormaAdmin;

    private Long numeroCirugia;

    private String tipoServicio;

    private Integer consecutivo;

    private Chusuario usuario;

    private List lstLiquidoParentales;

    private boolean renderSangre;
    
    private boolean renderOtro;

    private List<Chformulaliq> lstLiquidosFormulados;
    
    private List<Chformulaliq> lstFormuladosExterna;

    private HtmlDataTable dtLiquidosFormulados;

    private List<Chformulaliq> lstLiquidosSuspendidos;
    
    private Long numeroUsuario; 

    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public FormulaLiquidosBean() {
    }

    public void init() {
        lstVia = new ArrayList();
        lstFormaAdministracion = new ArrayList();
        liquidos = new Chformulaliq();
        renderOtro = false;
        renderSangre = false;
        mostrarAdministracion = false;
        mostrarFormaAdmin = false;
        

        try {
            lstLiquidos = 
                    serviceLocator.getClinicoService().getLstFormulaLiquidos(numeroCirugia, 
                                                                             tipoServicio, 
                                                                             consecutivo);
                                                                             
            if (numeroCirugia != null && tipoServicio != null) {
                lstLiquidosFormulados = 
                        this.serviceLocator.getCirugiaService().getLstLiquidosFormulados(numeroCirugia, 
                                                                                         tipoServicio, consecutivo,null);
            }
            
            
            lstFormuladosExterna = serviceLocator.getCirugiaService().getLstLiquidosFormuladosConsultaExterna(numeroUsuario, numeroCirugia);
            

        } catch (ModelException e) {
            e.printStackTrace();
        }
        if (lstLiquidos == null) {
            lstLiquidos = new ArrayList<Chformulaliq>();
        }


       
    }

    //-----------------------------------------------------------------------
    //  Get/Set
    //-----------------------------------------------------------------------

    /**
     * @param modoConsulta
     */
    public void setModoConsulta(boolean modoConsulta) {
        this.modoConsulta = modoConsulta;
    }

    /**
     * @return
     */
    public boolean isModoConsulta() {
        return modoConsulta;
    }

    /**
     * @param liquidos
     */
    public void setLiquidos(Chformulaliq liquidos) {
        this.liquidos = liquidos;
    }

    /**
     * @return
     */
    public Chformulaliq getLiquidos() {
        return liquidos;
    }


    /**
     * @param lstLiquidos
     */
    public void setLstLiquidos(List<Chformulaliq> lstLiquidos) {
        this.lstLiquidos = lstLiquidos;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstLiquidos() {
        return lstLiquidos;
    }


    /**
     * @param dtLiquidos
     */
    public void setDtLiquidos(HtmlDataTable dtLiquidos) {
        this.dtLiquidos = dtLiquidos;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidos() {
        return dtLiquidos;
    }


    /**
     * @param mostrarAdministracion
     */
    public void setMostrarAdministracion(boolean mostrarAdministracion) {
        this.mostrarAdministracion = mostrarAdministracion;
    }

    /**
     * @return
     */
    public boolean isMostrarAdministracion() {
        return mostrarAdministracion;
    }

    /**
     * @param lstVia
     */
    public void setLstVia(List lstVia) {
        this.lstVia = lstVia;
    }

    /**
     * @return
     */
    public List getLstVia() {
        if (lstVia.size() == 0) {
            lstVia.add(new SelectItem("IV", "Intravenosa"));
            lstVia.add(new SelectItem("SL", "Sublingual"));
         //   lstVia.add(new SelectItem("GA", "Gastroclisis"));
        }
        return lstVia;
    }

    /**
     * @param lstFormaAdministracion
     */
    public void setLstFormaAdministracion(List lstFormaAdministracion) {
        this.lstFormaAdministracion = lstFormaAdministracion;
    }

    /**
     * @return
     */
    public List getLstFormaAdministracion() {
        if (lstFormaAdministracion.size() == 0) {
            lstFormaAdministracion.add(new SelectItem("", 
                                                      "Seleccione una opci�n "));
            lstFormaAdministracion.add(new SelectItem("L", "En Bolo "));
            lstFormaAdministracion.add(new SelectItem("I", "En infusi�n"));

        }
        return lstFormaAdministracion;
    }

    /**
     * @param lstLiquidoParentales
     */
    public void setLstLiquidoParentales(List lstLiquidoParentales) {
        this.lstLiquidoParentales = lstLiquidoParentales;
    }

    /**
     * @return
     */
    public List getLstLiquidoParentales() {
        if (lstLiquidoParentales == null) {
            lstLiquidoParentales = new ArrayList();
            ArrayList<Chliquiparen> listliquidosAux = null;
            try {
                listliquidosAux = 
                        (ArrayList<Chliquiparen>)this.serviceLocator.getClinicoService().getLiquidoParenterales();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listliquidosAux.isEmpty()) {

                Iterator it = listliquidosAux.iterator();
                int i = 0;
                lstLiquidoParentales.add(new SelectItem("", 
                                                        "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    lstLiquidoParentales.add(new SelectItem(listliquidosAux.get(i).getHlpccodigo(), 
                                                            listliquidosAux.get(i).getHlpcdescripcio()));
                    i++;
                }
            }
        }
        return lstLiquidoParentales;
    }

    /**
     * @param liquidosDelete
     */
    public void setLiquidosDelete(Chformulaliq liquidosDelete) {
        this.liquidosDelete = liquidosDelete;
    }

    /**
     * @return
     */
    public Chformulaliq getLiquidosDelete() {
        return liquidosDelete;
    }

    /**
     * @param numeroCirugia
     */
    public void setNumeroCirugia(Long numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    /**
     * @return
     */
    public Long getNumeroCirugia() {
        return numeroCirugia;
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

    /**
     * @param consecutivo
     */
    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * @return
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }

    /**
     * @param usuario
     */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }
    /**
     * @return
     */
    public Chusuario getUsuario() {
        return usuario;
    }

    /**
     * @param lstClaseSangre
     */
    public void setLstClaseSangre(List lstClaseSangre) {
        this.lstClaseSangre = lstClaseSangre;
    }

    /**
     * @return
     */
    public List getLstClaseSangre() {
        if (lstClaseSangre == null) {
            lstClaseSangre = new ArrayList();
            lstClaseSangre.add(new SelectItem("", "Seleccione.."));
            lstClaseSangre.add(new SelectItem("ST", "Sangre Total"));
            lstClaseSangre.add(new SelectItem("GR", "Globulos Rojos"));
            lstClaseSangre.add(new SelectItem("PL", "Plasma"));
        }
        return lstClaseSangre;
    }


    /**
     * @param lstGrupoSangre
     */
    public void setLstGrupoSangre(List lstGrupoSangre) {
        this.lstGrupoSangre = lstGrupoSangre;
    }

    /**
     * @return
     */
    public List getLstGrupoSangre() {
        if (lstGrupoSangre == null) {
            lstGrupoSangre = new ArrayList();
            lstGrupoSangre.add(new SelectItem("A", "A"));
            lstGrupoSangre.add(new SelectItem("AB", "AB"));
            lstGrupoSangre.add(new SelectItem("B", "B"));
            lstGrupoSangre.add(new SelectItem("O", "O"));

        }
        return lstGrupoSangre;
    }

    /**
     * @param lstLiquidosSuspendidos
     */
    public void setLstLiquidosSuspendidos(List<Chformulaliq> lstLiquidosSuspendidos) {
        this.lstLiquidosSuspendidos = lstLiquidosSuspendidos;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstLiquidosSuspendidos() {
        return lstLiquidosSuspendidos;
    }

    /**
     * @param lstFactorSangre
     */
    public void setLstFactorSangre(List lstFactorSangre) {
        this.lstFactorSangre = lstFactorSangre;
    }

    /**
     * @return
     */
    public List getLstFactorSangre() {
        if (lstFactorSangre == null) {
            lstFactorSangre = new ArrayList();
            lstFactorSangre.add(new SelectItem("P", "POS"));
            lstFactorSangre.add(new SelectItem("N", "NEG"));
        }
        return lstFactorSangre;
    }

    /**
     * @param renderSangre
     */
    public void setRenderSangre(boolean renderSangre) {
        this.renderSangre = renderSangre;
    }

    /**
     * @return
     */
    public boolean isRenderSangre() {
        return renderSangre;
    }

    /**
     * @param lstLiquidosFormulados
     */
    public void setLstLiquidosFormulados(List<Chformulaliq> lstLiquidosFormulados) {
        this.lstLiquidosFormulados = lstLiquidosFormulados;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstLiquidosFormulados() {
        return lstLiquidosFormulados;
    }

    /**
     * @param dtLiquidosFormulados
     */
    public void setDtLiquidosFormulados(HtmlDataTable dtLiquidosFormulados) {
        this.dtLiquidosFormulados = dtLiquidosFormulados;
    }

    /**
     * @return
     */
    public HtmlDataTable getDtLiquidosFormulados() {
        return dtLiquidosFormulados;
    }


    /**
     * @param numeroUsuario
     */
    public void setNumeroUsuario(Long numeroUsuario) {
            this.numeroUsuario = numeroUsuario;
        }

    /**
     * @return
     */
    public Long getNumeroUsuario() {
            return numeroUsuario;
        }

    /**
     * @param lstFormuladosExterna
     */
    public void setLstFormuladosExterna(List<Chformulaliq> lstFormuladosExterna) {
        this.lstFormuladosExterna = lstFormuladosExterna;
    }

    /**
     * @return
     */
    public List<Chformulaliq> getLstFormuladosExterna() {
        return lstFormuladosExterna;
    }

    //-----------------------------------------------------------------------
    //  Ajax y/o Botonoes secundarios
    //-----------------------------------------------------------------------   


    public void agregarLiquidos() {
        boolean wexi = true;
        String url = "body:formFormularLiquidos:panelTabPrescripcionLiquidos:";

        if (liquidos != null) {
            if (liquidos.getHflcnombreliqu() == null || 
                liquidos.getHflcnombreliqu().equals("")) {
                FacesUtils.addErrorMessage(url + "mnuNombreLiquido", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexi = false;
            }

            if (liquidos.getHflncantidad() == null) {
                FacesUtils.addErrorMessage(url + "itCantidad", 
                                           MSG_CAMPO_OBLIGATORIO);
                wexi = false;
            }


            if (liquidos.getHflcviadminist() != null && 
                liquidos.getHflcviadminist().equals("IV")) {

                if (liquidos.getHflcformadmins() == null || 
                    liquidos.getHflcformadmins().equals("")) {
                    FacesUtils.addErrorMessage(url + "mnuFormaAdministracion", 
                                               MSG_CAMPO_OBLIGATORIO);
                    wexi = false;
                }
                
                if(liquidos.getHflcformadmins() != null && 
                    liquidos.getHflcformadmins().equals("I")){
                    
                    if (liquidos.getHflnvelocidadm() == null) {
                        FacesUtils.addErrorMessage(url + "itVelocidad", 
                                                   MSG_CAMPO_OBLIGATORIO);
                        wexi = false;
                    }
                    
                }

                
            }


        } else {
            wexi = false;
        }

        if (wexi) {
            if(liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("01")){
                liquidos.setHflcdesctipoli("Lactato de Ringer");
            }
            if (liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("02")) {
                liquidos.setHflcdesctipoli("Haemacell");
            }
            if (liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("03")) {
                liquidos.setHflcdesctipoli("Dextranes");
            }
            if (liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("04")) {
                liquidos.setHflcdesctipoli("Globulos Rojos");
            }
            if (liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("05")) {
                liquidos.setHflcdesctipoli("Sangre total");
            }
            if (liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("06")) {
                liquidos.setHflcdesctipoli("Plasma");
            }
            if (liquidos.getHflcnombreliqu() != null && liquidos.getHflcnombreliqu().equals("07")) {
                liquidos.setHflcdesctipoli("Plaquetas");
            }
            liquidos.setHflcoperador(userName());
            liquidos.setHfldfecregistr(new Date());
            liquidos.setHflcestado(ESTADO_VIGENTE);
            liquidos.setHfllusuario(usuario.getHuslnumero());
            lstLiquidos.add(liquidos);
            liquidos = new Chformulaliq();
            mostrarAdministracion = false;
            renderSangre = false;
            renderOtro = false;

        }

    }

    public void eliminarFormula() {
        liquidosDelete = (Chformulaliq)this.dtLiquidos.getRowData();
        this.lstLiquidos.remove(liquidosDelete);
        FacesUtils.addInfoMessage("Se elimino correctamente ");
    }


    public void ChangeViaAdministracion() {
        if (liquidos.getHflcviadminist() != null && 
            liquidos.getHflcviadminist().equals("IV")) {
            mostrarAdministracion = true;
            if(liquidos.getHflcviadminist() !=null){
            this.lstFormaAdministracion = new ArrayList<SelectItem>();
                lstFormaAdministracion.add(new SelectItem("", 
                                                          "Seleccione una opci�n "));
                lstFormaAdministracion.add(new SelectItem("I", "En infusi�n"));
                lstFormaAdministracion.add(new SelectItem("L", "En bolo"));
           
            }
        } else {
            liquidos.setHflcformadmins(null);
            liquidos.setHflnvelocidadm(null);
            mostrarAdministracion = false;
        }
    }

public void ChangeFormaAdmin(){
    if(liquidos.getHflcformadmins() != null &&
        liquidos.getHflcformadmins().equals("I")){
        mostrarFormaAdmin = true;
    }else{
        mostrarFormaAdmin = false;
    }
}

    /**
     * @param valueChangeEvent
     */
    public void setViaAdministracion(ValueChangeEvent valueChangeEvent) {
        liquidos.setHflcviadminist((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

public void setFormaAdministracion(ValueChangeEvent valueChangeEvent){
        liquidos.setHflcformadmins((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setHflcnombreliqu(ValueChangeEvent valueChangeEvent) {
        liquidos.setHflcnombreliqu((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void ChangeSangre() {
        if (liquidos != null){
            if(liquidos.getHflcnombreliqu() != null && 
               liquidos.getHflcnombreliqu().equals("05")) {
               renderSangre = true;
               renderOtro = false; 
        }else if(liquidos.getHflcnombreliqu() != null &&
               liquidos.getHflcnombreliqu().equals("06")){
                renderOtro = true;
               renderSangre = false;
              
                
            } else {
            renderSangre = false;
            renderOtro = false;
        }
    }
    }
  


    //-----------------------------------------------------------------------
    //  Boton Principal
    //-----------------------------------------------------------------------

    public void generarFormulaLiquidos() {

        lstLiquidosSuspendidos = new ArrayList<Chformulaliq>();
        if (lstLiquidosFormulados != null && 
            !lstLiquidosFormulados.isEmpty()) {
            for (Chformulaliq formulasus: lstLiquidosFormulados) {
                if (formulasus != null && formulasus.isHflbsuspender()) {
                    lstLiquidosSuspendidos.add(formulasus);
                }
            }
        }
        
        
        if (lstFormuladosExterna != null && 
            !lstFormuladosExterna.isEmpty()) {
            for (Chformulaliq formulasus: lstFormuladosExterna) {
                if (formulasus != null && formulasus.isHflbsuspender()) {
                    lstLiquidosSuspendidos.add(formulasus);
                }
            }
        }
        
        

        try {

            this.serviceLocator.getCirugiaService().saveListFormulaLiquidosCirugia(lstLiquidos, 
                                                                                   numeroCirugia, 
                                                                                   tipoServicio, 
                                                                                   consecutivo, 
                                                                                   lstLiquidosSuspendidos);
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);

       
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(IMsg.MSG_NO_ADICION);
            e.printStackTrace();
        }


    }


    public void setRenderOtro(boolean renderOtro) {
        this.renderOtro = renderOtro;
    }

    public boolean isRenderOtro() {
        return renderOtro;
    }

    public void setMostrarFormaAdmin(boolean mostrarFormaAdmin) {
        this.mostrarFormaAdmin = mostrarFormaAdmin;
    }

    public boolean isMostrarFormaAdmin() {
        return mostrarFormaAdmin;
    }
}
