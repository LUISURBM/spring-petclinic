
package org.profamilia.hc.view.backing.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chdatosadvacuna;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpdepadane;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.constantes.IMsg;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=================================================================
//  CLASE DatosUsuarioBean
//=======================================================================


public class DatosAdicionalesMedicamentoBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

   

   

   
    /** Lista que almacena la lista de  Departamentos  */
    private List<SelectItem> listDepartamentos;

    /** Lista que almacena la lista de  Ciudades */
    private List<SelectItem> listMunicipios;

    
    /** Almacena el usuario que se desea guardar */
    private Chusuario usuario;
    
  

   
  
    private Integer tipoHistoria;

    private String nextAction;

    private String menuBean;

    private String navigationRule;

    private static final int ACTIVAR_DATOS_USUARIO = 0;
    private int selectedIndex;
    private boolean renderDiscapacidad;
    private Chdatosadvacuna chdatosadvacuna;
    private List<SelectItem>lstSiNo;
    private List<SelectItem>lstCondEmbarazo;
    private boolean renderEmbarazo;
    private boolean renderInstitucion;
    private boolean renderDatosEmbarazo;
    private Long numeroConsulta;
    
    /** Almacena la lista de Tipos de Discapacidad*/
    private List<SelectItem> lstDiscapacidad;
    
    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public DatosAdicionalesMedicamentoBean() {
    }



    public void init() {
    
        listMunicipios = new ArrayList<SelectItem>();
        if (usuario == null) {
            usuario = new Chusuario();
        }
        
        selectedIndex = ACTIVAR_DATOS_USUARIO;
        
        chdatosadvacuna = new Chdatosadvacuna();
        
        inicializarUsuario();      
     
    }
    

    //ACTIONS

    public String inicializarUsuario() {

        
        renderDatosEmbarazo = false;
        renderDiscapacidad = false;
    
        if (usuario != null)  {
           if(("F").equals(usuario.getHusesexo())){
               renderDatosEmbarazo = true;
           }
            try {
                chdatosadvacuna= this.serviceLocator.getHistoriaService().readDatosADVacunaByUsuario(usuario);
                if(chdatosadvacuna!=null){
                   chdatosadvacuna.setHdavnconsulta(null);
                    changeCiudad();
                    if(chdatosadvacuna.getHdacdiscapadid() != null && chdatosadvacuna.getHdacdiscapadid().equals("S")){
                        renderDiscapacidad = true;
                    }
                }
                else{
                    chdatosadvacuna = new Chdatosadvacuna();
                }
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }
        }

        return null;

    }
    
    public void changeDiscapacidad(){
        renderDiscapacidad = false;
        if(chdatosadvacuna != null && chdatosadvacuna.getHdacdiscapadid() != null && chdatosadvacuna.getHdacdiscapadid().equals("S")){
            renderDiscapacidad = true;
        }
    }

    /**
     * @return
     */
    public boolean esValido() {
        boolean esValido = false;
        Chdatosadvacuna consultaAux = null;
        if (numeroConsulta !=null) {

            try {
                consultaAux = 
                        this.serviceLocator.getHistoriaService().readDatosADVacunaByConsulta((int)(long)numeroConsulta);

            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (consultaAux != null) {
            esValido = true;
            chdatosadvacuna.setHdavccondusua(consultaAux.getHdavccondusua());
            chdatosadvacuna.setHdavcembact(consultaAux.getHdavcembact());
            chdatosadvacuna.setHdavcestuact(consultaAux.getHdavcestuact());
            chdatosadvacuna.setHdavcinstitucion(consultaAux.getHdavcinstitucion());
            chdatosadvacuna.setHdavdfur(consultaAux.getHdavdfur());
            chdatosadvacuna.setHdavdfecpart(consultaAux.getHdavdfecpart());
           
            
        } else {
            esValido = false;
            chdatosadvacuna.setHdavccondusua(null);
            chdatosadvacuna.setHdavcembact(null);
            chdatosadvacuna.setHdavcestuact(null);
            chdatosadvacuna.setHdavcinstitucion(null);
            chdatosadvacuna.setHdavdfur(null);
            chdatosadvacuna.setHdavdfecpart(null);
        }
        onChangeCondEmbarazo();
        onChangeInstitucion();
        return esValido;
    }


    /** Botones  */
    public String guardarUsuario()  {
        navigationRule = "";
        chdatosadvacuna.setHdavdfecreg(new Date());
        if(numeroConsulta!=null){
            chdatosadvacuna.setHdavnconsulta(numeroConsulta);
        }
        chdatosadvacuna.setHdavcusuareg(userName());
        chdatosadvacuna.setHdavnusuario(usuario.getHuslnumero());
        
        if(chdatosadvacuna != null && chdatosadvacuna.getHdacdiscapadid() != null && chdatosadvacuna.getHdacdiscapadid().equals("N")){
            chdatosadvacuna.setHdacdiscaselec(null);
        }

        try {
            this.serviceLocator.getHistoriaService().save(chdatosadvacuna);
            navigationRule = nextAction;
            FacesUtils.addInfoMessage(IMsg.MSG_ADICION);
            FacesUtils.resetManagedBean("menuMedicamentosBean");
            return navigationRule;
        } catch (ModelException e) {
            return capturaError(e,IConstantes.ERROR_GUARDADO);
        }
    }

    public String changeCiudad() {
        if (chdatosadvacuna.getHdavndepart() != null && !chdatosadvacuna.getHdavndepart().equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {

                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(chdatosadvacuna.getHdavndepart());

            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }
        } else {
            listMunicipios = new ArrayList<SelectItem>();
            listMunicipios.add(new SelectItem("", 
                                              "Seleccione una opcion ..."));
        }
        return null;
    }

    //ACCESSORS

    /** Definimos los Gets y Set de la aplicacion */
    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

  




    public void setListDepartamentos(List<SelectItem> param) {
        this.listDepartamentos = param;
    }

    public List<SelectItem> getListDepartamentos() {
        if (listDepartamentos == null || listDepartamentos.isEmpty()) {
            listDepartamentos = new ArrayList<SelectItem>();
            ArrayList<Cpdepadane> listDepartamentosAux = null;
            try {
                listDepartamentosAux = 
                        (ArrayList<Cpdepadane>)this.serviceLocator.getClinicoService().getDepartamentos();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!listDepartamentosAux.isEmpty()) {

                Iterator it = listDepartamentosAux.iterator();
                int i = 0;
                listDepartamentos.add(new SelectItem("", 
                                                     "Seleccione una opci�n ..."));
                while (it.hasNext()) {
                    it.next();
                    listDepartamentos.add(new SelectItem(listDepartamentosAux.get(i).getCddncodigo(), 
                                                         listDepartamentosAux.get(i).getCddcdescri()));
                    i++;
                }
            }
        }
        return listDepartamentos;
    }

    public void setListMunicipios(List<SelectItem> param) {
        this.listMunicipios = param;
    }

    public List<SelectItem> getListMunicipios() {

        return listMunicipios;
    }

  
  
    public String setCiudad() {
        if (usuario.getHusndepartamen()!=null && !usuario.getHusndepartamen().equals("")) {
            this.listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {
                listMunicipiosAux = 
                        (ArrayList<Cpmunidane>)this.serviceLocator.getClinicoService().getMunicipios(usuario.getHusndepartamen());
            } catch (ModelException e) {
                return capturaError(e,IConstantes.ERROR_COSNULTA);
            }

            if (listMunicipiosAux != null && !listMunicipiosAux.isEmpty()) {

                Iterator it = listMunicipiosAux.iterator();
                int i = 0;
                listMunicipios.add(new SelectItem("", 
                                                  "Seleccione una opcion ..."));
                while (it.hasNext()) {
                    it.next();
                    listMunicipios.add(new SelectItem(listMunicipiosAux.get(i).getCmdncodmun(), 
                                                      listMunicipiosAux.get(i).getCmdcnommun()));
                    i++;
                }
            }
        }
        return null;
    }
    
    public void onChangeInstitucion(){
        renderInstitucion = false;
        if(("S").equals(chdatosadvacuna.getHdavcestuact())){
            renderInstitucion = true;
        }
        else{
            chdatosadvacuna.setHdavcinstitucion(null);
        }
    }
    
    public void onChangeCondEmbarazo(){
        renderEmbarazo = false;
        if(("EM").equals(chdatosadvacuna.getHdavccondusua())){
            renderEmbarazo = true;
        }
        else{
            chdatosadvacuna.setHdavcembact(null);
            chdatosadvacuna.setHdavdfecpart(null);
        }
    }


    /**
     * @param valueChangeEvent
     */
    public void setDepartamentoSelect(ValueChangeEvent valueChangeEvent) {
        chdatosadvacuna.setHdavndepart((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHuseautorcont(ValueChangeEvent valueChangeEvent) {
        usuario.setHuseautorcont((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
        
    /**
     * @param valueChangeEvent
     */
    public void setHdavcestuact(ValueChangeEvent valueChangeEvent) {
        chdatosadvacuna.setHdavcestuact((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    /**
     * @param valueChangeEvent
     */
    public void setHdavccondusua(ValueChangeEvent valueChangeEvent) {
        chdatosadvacuna.setHdavccondusua((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


  
    /**
     * @param valueChangeEvent
     */
    public void setFechaNacimiento(ValueChangeEvent valueChangeEvent) {
        usuario.setHusdfechanacim((Date)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

  
    /**
     * @param tipoHistoria
     */
    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    /**
     * @return
     */
    public Integer getTipoHistoria() {
        return tipoHistoria;
    }

    /**
     * @param nextAction
     */
    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    /**
     * @return
     */
    public String getNextAction() {
        return nextAction;
    }

    /**
     * @param menuBean
     */
    public void setMenuBean(String menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return
     */
    public String getMenuBean() {
        return menuBean;
    }

  
  

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setChdatosadvacuna(Chdatosadvacuna chdatosadvacuna) {
        this.chdatosadvacuna = chdatosadvacuna;
    }

    public Chdatosadvacuna getChdatosadvacuna() {
        return chdatosadvacuna;
    }

    
   
    public void setLstSiNo(List<SelectItem> lstSiNo) {
        this.lstSiNo = lstSiNo;
    }

    public List<SelectItem> getLstSiNo() {
    if(lstSiNo == null || lstSiNo.isEmpty()){
        lstSiNo = new ArrayList<SelectItem>();
        lstSiNo.add(new SelectItem("S","Si"));
        lstSiNo.add(new SelectItem("N","No"));
    }
        return lstSiNo;
    }

    public void setLstCondEmbarazo(List<SelectItem> lstCondEmbarazo) {
        this.lstCondEmbarazo = lstCondEmbarazo;
    }

    public List<SelectItem> getLstCondEmbarazo() {
    if(lstCondEmbarazo == null || lstCondEmbarazo.isEmpty()){
        lstCondEmbarazo = new ArrayList<SelectItem>();
        lstCondEmbarazo.add(new SelectItem("EM","Embarazada"));
        lstCondEmbarazo.add(new SelectItem("NE","No embarazada"));
    }
        return lstCondEmbarazo;
    }

    public void setRenderEmbarazo(boolean renderEmbarazo) {
        this.renderEmbarazo = renderEmbarazo;
    }

    public boolean isRenderEmbarazo() {
        return renderEmbarazo;
    }

    public void setRenderInstitucion(boolean renderInstitucion) {
        this.renderInstitucion = renderInstitucion;
    }

    public boolean isRenderInstitucion() {
        return renderInstitucion;
    }

    public void setRenderDatosEmbarazo(boolean renderDatosEmbarazo) {
        this.renderDatosEmbarazo = renderDatosEmbarazo;
    }

    public boolean isRenderDatosEmbarazo() {
        return renderDatosEmbarazo;
    }
    
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setRenderDiscapacidad(boolean renderDiscapacidad) {
        this.renderDiscapacidad = renderDiscapacidad;
    }

    public boolean isRenderDiscapacidad() {
        return renderDiscapacidad;
    }
    
    public void setLstDiscapacidad(List<SelectItem> lstDiscapacidad) {
        this.lstDiscapacidad = lstDiscapacidad;
    }

    public List<SelectItem> getLstDiscapacidad() {
        if (lstDiscapacidad == null || lstDiscapacidad.isEmpty()) {
            lstDiscapacidad = new ArrayList<SelectItem>();
            lstDiscapacidad.add(new SelectItem("", "Seleccione una opci�n"));
            lstDiscapacidad.add(new SelectItem("FI", "Discapacidad f�sica"));
            lstDiscapacidad.add(new SelectItem("VI", "Discapacidad visual"));
            lstDiscapacidad.add(new SelectItem("AU", "Discapacidad auditiva"));
            lstDiscapacidad.add(new SelectItem("IN", "Discapacidad intelectual"));
            lstDiscapacidad.add(new SelectItem("ME", "Discapacidad sicosocial (mental)"));
            lstDiscapacidad.add(new SelectItem("SO", "Discapacidad Sordoceguera"));
            lstDiscapacidad.add(new SelectItem("MU", "Discapacidad m�ltiple"));
           
        }
        return lstDiscapacidad;
    }
    
}
