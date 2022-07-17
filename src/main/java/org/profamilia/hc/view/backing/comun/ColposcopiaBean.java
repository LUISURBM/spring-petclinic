//=======================================================================
// ARCHIVO ColposcopiaBean.java
// FECHA CREACI�N: 
// AUTOR: Jos� Andr�s Riano
// Descripci�n: Datos correspondientes a la informacion de la colposcopia
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

import org.profamilia.hc.model.dto.Chcolposcopia;
import org.profamilia.hc.model.dto.ChcolposcopiaPK;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
//=======================================================================
//  CLASE ColposcopiaBean
//=======================================================================
public class ColposcopiaBean extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    private Chcolposcopia coloposcopia;
    private String tipoServicio;
    private Long numeroConsulta;
    private String nextAction;
    private String menuBean;
    private String navigationRule;

    private List lstTipoEvaluacion;

    private List<String> lstEvaluacionInadecuadaSelect;

    private List lstEvaluacionInadecuada;

    private List lstVisibilidadEscamo;

    private List lstTipoZonaTranformacion;

    private List<String> lstHallazgosNormalSelect;

    private List lstHallazgosNormal;

    private List lstHallazgosVarios;

    private List<String> lstHallazgosVariosSelect;

    private List lstGradoHallazgos;

    private List lstGrado1;

    private List<String> lstGrado1Select;

    private List lstGrado2;

    private List<String> lstGrado2Select;

    private List lstSospecha;

    private List<String> lstSospechaSelect;

    private List lstOpciones;
    
    private List lstOpcionesSi;

    private boolean renderGrado1;

    private boolean renderGrado2;

    private boolean renderNoEspecifico;

    private boolean renderAdecuada;

    private boolean renderOtroAdecuada;

    private boolean renderOtosVarios;

    private boolean renderOtraSospecha;
    
    private boolean renderTomaBiopsa; 
    
    private List ltsTipoHallazgo;
    
    private boolean renderNormal;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public ColposcopiaBean() {

    }
    // ACTIONS

    public void init() {

        inicializarColposcopia();
    }


    public void inicializarColposcopia() {
        lstEvaluacionInadecuadaSelect = new ArrayList<String>();
        lstHallazgosNormalSelect = new ArrayList<String>();
        lstHallazgosVariosSelect = new ArrayList<String>();
        lstSospechaSelect = new ArrayList<String>();
        lstGrado1Select = new ArrayList<String>();
        lstGrado2Select = new ArrayList<String>();
        renderGrado1 = false;
        renderGrado2 = false;
        renderNoEspecifico = false;
        renderNormal = true;
    


        if (numeroConsulta != null) {
            try {
                coloposcopia = 
                        getServiceLocator().getClinicoService().getColposcopia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        }

        if (coloposcopia == null) {
            coloposcopia = new Chcolposcopia();
        } else {
            changeTomoBiopsa();
            changeTipoHallazgos();
            if (coloposcopia.getHclcgradohalla() != null) {
                if (coloposcopia.getHclcgradohalla().equals("1")) {
                    renderGrado1 = true;
                    renderGrado2 = false;
                    renderNoEspecifico = false;

                    if (lstGrado1Select != null) {                 
                            if (coloposcopia.getHclcgrad1epite()!= null && coloposcopia.getHclcgrad1epite().equals("S")) {
                                lstGrado1Select.add("EA");
                            }
                            if (coloposcopia.getHclcgrad1borde()!= null && coloposcopia.getHclcgrad1borde().equals("S")) {
                                lstGrado1Select.add("BI");
                            }
                            if (coloposcopia.getHclcgrad1mosai()!= null && coloposcopia.getHclcgrad1mosai().equals("S")) {
                                lstGrado1Select.add("MF");
                            }
                            if (coloposcopia.getHclcgrad1punte()!= null && coloposcopia.getHclcgrad1punte().equals("S")) {
                                 lstGrado1Select.add("PF");
                            }

                    }
                }
                if (coloposcopia.getHclcgradohalla().equals("2")) {
                    renderGrado1 = false;
                    renderGrado2 = true;
                    renderNoEspecifico = false;
                    
                    
                    if (lstGrado2Select != null) {


                        if (coloposcopia.getHclcgrad2mosai()!= null && coloposcopia.getHclcgrad2mosai().equals("S")) {
                            lstGrado2Select.add("MG");
                        }
                        if (coloposcopia.getHclcgrad2borde()!= null && coloposcopia.getHclcgrad2borde().equals("S")) {
                            lstGrado2Select.add("BD");
                        }
                        if (coloposcopia.getHclcgrad2signo()!= null && coloposcopia.getHclcgrad2signo().equals("S")) {
                            lstGrado2Select.add("SB");
                        }
                        if (coloposcopia.getHclcgrad2aceta()!= null && coloposcopia.getHclcgrad2aceta().equals("S")) {
                            lstGrado2Select.add("AE");
                        }
                        if (coloposcopia.getHclcgrad2crest()!= null && coloposcopia.getHclcgrad2crest().equals("S")) {
                            lstGrado2Select.add("SC");
                        }
                        if (coloposcopia.getHclcgrad2orifi()!= null && coloposcopia.getHclcgrad2orifi().equals("S")) {
                            lstGrado2Select.add("OG");
                        }

                        if (coloposcopia.getHclcgrad2puntil()!= null && coloposcopia.getHclcgrad2puntil().equals("S")) {
                            lstGrado2Select.add("PG");
                        }
                        
                        if (coloposcopia.getHclcgrad2epacde() != null && coloposcopia.getHclcgrad2epacde().equals("S")) {
                            lstGrado2Select.add("EA");
                        }


                    }
                    
                }
                if (coloposcopia.getHclcgradohalla().equals("0")) {
                    renderGrado1 = false;
                    renderGrado2 = false;
                    renderNoEspecifico = true;
                }
            }

            if (coloposcopia.getHclcevalugener() != null && 
                coloposcopia.getHclcevalugener().equals("I")) {

                renderAdecuada = true;


                if (coloposcopia.getHclcinadeinfla() != null && 
                    coloposcopia.getHclcinadeinfla().equals("S")) {

                    lstEvaluacionInadecuadaSelect.add("PI");
                }

                if (coloposcopia.getHclcinadesangr() != null && 
                    coloposcopia.getHclcinadesangr().equals("S")) {

                    lstEvaluacionInadecuadaSelect.add("PS");
                }


                if (coloposcopia.getHclcinadecicat() != null && 
                    coloposcopia.getHclcinadecicat().equals("S")) {

                    lstEvaluacionInadecuadaSelect.add("PC");
                }

                if (coloposcopia.getHclcinadeotro() != null && 
                    coloposcopia.getHclcinadeotro().equals("S")) {

                    lstEvaluacionInadecuadaSelect.add("OT");
                    renderOtroAdecuada = true;
                }


            }
            
            // INICIALIZACION HALLAZGO COLPOSCOPICO NORMAL
            
            
             if (lstHallazgosNormalSelect != null) {

             
                     if (coloposcopia.getHclchallamadur()!= null && coloposcopia.getHclchallamadur().equals("S"))
                     {
                         lstHallazgosNormalSelect.add("MA");
                     }
                     if (coloposcopia.getHclchallaatrof()!= null && coloposcopia.getHclchallaatrof().equals("S")) {
                          lstHallazgosNormalSelect.add("AT");
                     }

                     if (coloposcopia.getHclchallaquiste()!= null && coloposcopia.getHclchallaquiste().equals("S")) {
                          lstHallazgosNormalSelect.add("QN");
                     }

                     if (coloposcopia.getHclchallagland()!= null && coloposcopia.getHclchallagland().equals("S")) {
                          lstHallazgosNormalSelect.add("AG");
                     }


                     if (coloposcopia.getHclchallaectop()!= null && coloposcopia.getHclchallaectop().equals("S")) {
                          lstHallazgosNormalSelect.add("EC");
                     }

                     if (coloposcopia.getHclchalladecid()!= null && coloposcopia.getHclchalladecid().equals("S")) {
                          lstHallazgosNormalSelect.add("DE");
                     }
                 }
            
             // INICIALIZACION HALLAZGOS VARIOS 
             
              if (lstHallazgosVariosSelect != null ) {

                      if (coloposcopia.getHclchallazona()!= null && coloposcopia.getHclchallazona().equals("S")) {
                           lstHallazgosVariosSelect.add("ZC");
                      }
                      if (coloposcopia.getHclchallacondi()!= null && coloposcopia.getHclchallacondi().equals("S")) {
                           lstHallazgosVariosSelect.add("CO");
                      }
                      if (coloposcopia.getHclchallainfla()!= null && coloposcopia.getHclchallainfla().equals("S")) {
                           lstHallazgosVariosSelect.add("IN");
                      }
                      if (coloposcopia.getHclchallaesten()!= null && coloposcopia.getHclchallaesten().equals("S")) {
                          lstHallazgosVariosSelect.add("ES");
                      }
                      if (coloposcopia.getHclchallaconge()!= null && coloposcopia.getHclchallaconge().equals("S")) {
                           lstHallazgosVariosSelect.add("AC");
                      }
                      if (coloposcopia.getHclchallapost()!= null && coloposcopia.getHclchallapost().equals("S")) {
                             lstHallazgosVariosSelect.add("AT");
                      }
                      if (coloposcopia.getHclchallapolip()!= null && coloposcopia.getHclchallapolip().equals("S")) {
                            lstHallazgosVariosSelect.add("PO");
                      }
                      if (coloposcopia.getHclchallaendom()!= null && coloposcopia.getHclchallaendom().equals("S")) {
                           lstHallazgosVariosSelect.add("EN");
                      }
                      if (coloposcopia.getHclchallaotro()!= null && coloposcopia.getHclchallaotro().equals("S")) {
                          lstHallazgosVariosSelect.add("OT");
                          renderOtosVarios = true; 
                      }
                  

              }
              
              // INICIALIZACION SOSPECHA
              
               if (lstSospechaSelect != null) {


                       if (coloposcopia.getHclcvasosatipi()!= null && coloposcopia.getHclcvasosatipi().equals("S")) {
                            lstSospechaSelect.add("VA");
                       }
                       if (coloposcopia.getHclcnecrosis()!= null && coloposcopia.getHclcnecrosis().equals("S")) {
                           lstSospechaSelect.add("NE");
                       }

                       if (coloposcopia.getHclcvasosdelga()!= null && coloposcopia.getHclcvasosdelga().equals("S")) {
                           lstSospechaSelect.add("VD");
                       }

                       if (coloposcopia.getHclcnulcera()!= null && coloposcopia.getHclcnulcera().equals("S")) {
                           lstSospechaSelect.add("UN");
                       }

                       if (coloposcopia.getHclcsupirreg()!= null && coloposcopia.getHclcsupirreg().equals("S")) {
                           lstSospechaSelect.add("SI");
                       }

                       if (coloposcopia.getHclctumornudol()!= null && coloposcopia.getHclctumornudol().equals("S")) {
                           lstSospechaSelect.add("TN");
                       }
                       if (coloposcopia.getHclclesioexofi()!= null && coloposcopia.getHclclesioexofi().equals("S")) {
                           lstSospechaSelect.add("LE");
                       }
                       if (coloposcopia.getHclcsospeotro()!= null && coloposcopia.getHclcsospeotro().equals("S")) {
                           lstSospechaSelect.add("OT");
                           renderOtraSospecha = true; 
                       }
                   

               }

        }

    }


    public boolean esValido() {
        boolean esValido = false;
        Chcolposcopia colposcopiaAux = null;
        if (numeroConsulta != null) {

            try {
                colposcopiaAux = 
                        getServiceLocator().getClinicoService().getColposcopia(numeroConsulta);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }
        if (colposcopiaAux != null)
            esValido = true;
        else
            esValido = false;
        return esValido;
    }


    /**
     * @param coloposcopia
     */
    public void setColoposcopia(Chcolposcopia coloposcopia) {
        this.coloposcopia = coloposcopia;
    }

    /**
     * @return
     */
    public Chcolposcopia getColoposcopia() {
        return coloposcopia;
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
     * @param numeroConsulta
     */
    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    /**
     * @return
     */
    public Long getNumeroConsulta() {
        return numeroConsulta;
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

    /**
     * @param navigationRule
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return
     */
    public String getNavigationRule() {
        return navigationRule;
    }

    public void setLstTipoEvaluacion(List lstTipoEvaluacion) {
        this.lstTipoEvaluacion = lstTipoEvaluacion;
    }

    public List getLstTipoEvaluacion() {
        if (lstTipoEvaluacion == null || lstTipoEvaluacion.isEmpty()) {
            lstTipoEvaluacion = new ArrayList();
            lstTipoEvaluacion.add(new SelectItem("A", "Adecuada"));
            lstTipoEvaluacion.add(new SelectItem("I", "Inadecuada"));
        }

        return lstTipoEvaluacion;
    }

    public void setLstEvaluacionInadecuadaSelect(List<String> lstEvaluacionInadecuadaSelect) {
        this.lstEvaluacionInadecuadaSelect = lstEvaluacionInadecuadaSelect;
    }

    public List getLstEvaluacionInadecuadaSelect() {
        return lstEvaluacionInadecuadaSelect;
    }

    public void setLstEvaluacionInadecuada(List lstEvaluacionInadecuada) {
        this.lstEvaluacionInadecuada = lstEvaluacionInadecuada;
    }

    public List getLstEvaluacionInadecuada() {
        if (lstEvaluacionInadecuada == null || 
            lstEvaluacionInadecuada.isEmpty()) {
            lstEvaluacionInadecuada = new ArrayList();
            lstEvaluacionInadecuada.add(new SelectItem("PI", 
                                                       "Por Inflamacion"));
            lstEvaluacionInadecuada.add(new SelectItem("PS", "Por Sangrado"));
            lstEvaluacionInadecuada.add(new SelectItem("PC", "Por cicatriz "));
            lstEvaluacionInadecuada.add(new SelectItem("OT", "Otros "));
        }

        return lstEvaluacionInadecuada;
    }

    public void setLstVisibilidadEscamo(List lstVisibilidadEscamo) {
        this.lstVisibilidadEscamo = lstVisibilidadEscamo;
    }

    public List getLstVisibilidadEscamo() {
        if (lstVisibilidadEscamo == null || lstVisibilidadEscamo.isEmpty()) {
            lstVisibilidadEscamo = new ArrayList();
            lstVisibilidadEscamo.add(new SelectItem("", "Seleccione ..."));
            lstVisibilidadEscamo.add(new SelectItem("CV", 
                                                    "Completamente visible "));
            lstVisibilidadEscamo.add(new SelectItem("PV", 
                                                    "Parcialmente visible  "));
            lstVisibilidadEscamo.add(new SelectItem("NV", "No visible  "));
        }

        return lstVisibilidadEscamo;
    }

    public void setLstTipoZonaTranformacion(List lstTipoZonaTranformacion) {
        this.lstTipoZonaTranformacion = lstTipoZonaTranformacion;
    }

    public List getLstTipoZonaTranformacion() {
        if (lstTipoZonaTranformacion == null || 
            lstTipoZonaTranformacion.isEmpty()) {
            lstTipoZonaTranformacion = new ArrayList();
            lstTipoZonaTranformacion.add(new SelectItem("", "Seleccione ..."));
            lstTipoZonaTranformacion.add(new SelectItem("1", "1 "));
            lstTipoZonaTranformacion.add(new SelectItem("2", "2"));
            lstTipoZonaTranformacion.add(new SelectItem("3", "3"));
        }

        return lstTipoZonaTranformacion;
    }

    public void setLstHallazgosNormalSelect(List<String> lstHallazgosNormalSelect) {
        this.lstHallazgosNormalSelect = lstHallazgosNormalSelect;
    }

    public List getLstHallazgosNormalSelect() {
        return lstHallazgosNormalSelect;
    }

    public void setLstHallazgosNormal(List lstHallazgosNormal) {
        this.lstHallazgosNormal = lstHallazgosNormal;
    }

    public List getLstHallazgosNormal() {
        if (lstHallazgosNormal == null || lstHallazgosNormal.isEmpty()) {
            lstHallazgosNormal = new ArrayList();
            lstHallazgosNormal.add(new SelectItem("MA", "Maduro"));
            lstHallazgosNormal.add(new SelectItem("AT", "Atr�fico"));
            lstHallazgosNormal.add(new SelectItem("QN", "Quistes de Naboth"));
            lstHallazgosNormal.add(new SelectItem("AG", 
                                                  "Aberturas Glandulares"));
            lstHallazgosNormal.add(new SelectItem("EC", "Ectopia"));
            lstHallazgosNormal.add(new SelectItem("DE", 
                                                  "Deciduosis en el embarazo"));
        }

        return lstHallazgosNormal;
    }


    public void setLstHallazgosVarios(List lstHallazgosVarios) {
        this.lstHallazgosVarios = lstHallazgosVarios;
    }

    public List getLstHallazgosVarios() {
        if (lstHallazgosVarios == null || lstHallazgosVarios.isEmpty()) {
            lstHallazgosVarios = new ArrayList();
            lstHallazgosVarios.add(new SelectItem("ZC", 
                                                  "Zona de transformaci�n congenita "));
            lstHallazgosVarios.add(new SelectItem("CO", "Condiloma"));
            lstHallazgosVarios.add(new SelectItem("IN", "Inflamaci�n"));
            lstHallazgosVarios.add(new SelectItem("ES", "Estenosis"));
            lstHallazgosVarios.add(new SelectItem("AC", "Anomal�a Cong�nita"));
            lstHallazgosVarios.add(new SelectItem("AT", 
                                                  "Anomal�as post tratamiento"));
            lstHallazgosVarios.add(new SelectItem("PO", 
                                                  "P�lipo (endocervical-exocervical)"));
            lstHallazgosVarios.add(new SelectItem("EN", "Endometriosis"));
            lstHallazgosVarios.add(new SelectItem("OT", "Otros"));
        }

        return lstHallazgosVarios;
    }

    public void setLstHallazgosVariosSelect(List<String> lstHallazgosVariosSelect) {
        this.lstHallazgosVariosSelect = lstHallazgosVariosSelect;
    }

    public List getLstHallazgosVariosSelect() {
        return lstHallazgosVariosSelect;
    }

    public void setLstGradoHallazgos(List lstGradoHallazgos) {
        this.lstGradoHallazgos = lstGradoHallazgos;
    }

    public List getLstGradoHallazgos() {
        if (lstGradoHallazgos == null || lstGradoHallazgos.isEmpty()) {
            lstGradoHallazgos = new ArrayList();
            lstGradoHallazgos.add(new SelectItem("", "Seleccione .."));
            lstGradoHallazgos.add(new SelectItem("1", "Grado 1 (Menor)"));
            lstGradoHallazgos.add(new SelectItem("2", "Grado 2 (Mayor)"));
        }

        return lstGradoHallazgos;
    }

    public void setLstGrado1(List lstGrado1) {
        this.lstGrado1 = lstGrado1;
    }

    public List getLstGrado1() {
        if (lstGrado1 == null || lstGrado1.isEmpty()) {
            lstGrado1 = new ArrayList();
            lstGrado1.add(new SelectItem("EA", "Epitelio acetoblanco"));
            lstGrado1.add(new SelectItem("BI", "Borde irregular"));
            lstGrado1.add(new SelectItem("MF", "Mosaico fino"));
            lstGrado1.add(new SelectItem("PF", "Punteado fino"));
        }

        return lstGrado1;
    }

    public void setLstGrado2(List lstGrado2) {
        this.lstGrado2 = lstGrado2;
    }

    public List getLstGrado2() {
        if (lstGrado2 == null || lstGrado2.isEmpty()) {
            lstGrado2 = new ArrayList();
            lstGrado2.add(new SelectItem("MG", "Mosaico Grueso"));
            lstGrado2.add(new SelectItem("BD", "Bordes delimitados"));
            lstGrado2.add(new SelectItem("SB", "Signo del borde interno"));
            lstGrado2.add(new SelectItem("AE", 
                                         "Aparici�n r�pida epitelio acetablanco "));
            lstGrado2.add(new SelectItem("SC", "Signo de la Crest. "));
            lstGrado2.add(new SelectItem("OG", 
                                         "Orificio glandular abierto con borde engrosado"));
            lstGrado2.add(new SelectItem("PG", "Puntillado Grueso"));
            lstGrado2.add(new SelectItem("EA", "Epitelio acetoblanco denso"));
            
        }

        return lstGrado2;
    }

    public void setRenderGrado1(boolean renderGrado1) {
        this.renderGrado1 = renderGrado1;
    }

    public boolean isRenderGrado1() {
        return renderGrado1;
    }

    public void setRenderGrado2(boolean renderGrado2) {
        this.renderGrado2 = renderGrado2;
    }

    public boolean isRenderGrado2() {
        return renderGrado2;
    }

    public void setRenderNoEspecifico(boolean renderNoEspecifico) {
        this.renderNoEspecifico = renderNoEspecifico;
    }

    public boolean isRenderNoEspecifico() {
        return renderNoEspecifico;
    }

    public void setLstGrado1Select(List<String> lstGrado1Select) {
        this.lstGrado1Select = lstGrado1Select;
    }

    public List getLstGrado1Select() {
        return lstGrado1Select;
    }

    public void setLstGrado2Select(List<String> lstGrado2Select) {
        this.lstGrado2Select = lstGrado2Select;
    }

    public List getLstGrado2Select() {
        return lstGrado2Select;
    }

    public void setLstOpciones(List lstOpciones) {
        this.lstOpciones = lstOpciones;
    }

    public List getLstOpciones() {
        if (lstOpciones == null || lstOpciones.isEmpty()) {
            lstOpciones = new ArrayList();
            lstOpciones.add(new SelectItem("P", "Positivo(+) "));
            lstOpciones.add(new SelectItem("N", "Negativo(-) "));

        }

        return lstOpciones;
    }


    public void changeGradoHallazgos() {
        renderGrado1 = false;
        renderGrado2 = false;
        renderNoEspecifico = false;

        if (coloposcopia.getHclcgradohalla() != null) {
            if (coloposcopia.getHclcgradohalla().equals("1")) {
                renderGrado1 = true;
                renderGrado2 = false;
                renderNoEspecifico = false;
            }
            if (coloposcopia.getHclcgradohalla().equals("2")) {
                renderGrado1 = false;
                renderGrado2 = true;
                renderNoEspecifico = false;
            }
            /*
            if (coloposcopia.getHclcgradohalla().equals("0")) {
                renderGrado1 = false;
                renderGrado2 = false;
                renderNoEspecifico = true;
            }
            */
        }
    }

    public void setHclcgradohalla(ValueChangeEvent valueChangeEvent) {
        coloposcopia.setHclcgradohalla((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderAdecuada(boolean renderAdecuada) {
        this.renderAdecuada = renderAdecuada;
    }

    public boolean isRenderAdecuada() {
        return renderAdecuada;
    }


    public void setHclcevalugener(ValueChangeEvent valueChangeEvent) {
        coloposcopia.setHclcevalugener((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void changeEvaluacionGeneral() {
        renderAdecuada = false;
        if (coloposcopia.getHclcevalugener() != null && 
            coloposcopia.getHclcevalugener().equals("I")) {
            renderAdecuada = true;
        }

    }

    public void changeOtroEvaluacion() {
        renderOtroAdecuada = false;
        if (lstEvaluacionInadecuadaSelect != null && 
            !lstEvaluacionInadecuadaSelect.isEmpty()) {
            for (Iterator iterator = lstEvaluacionInadecuadaSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("OT"))
                    renderOtroAdecuada = true;
            }

        }
    }


    public void setLstEvaluacionInadecuadaSelect(ValueChangeEvent valueChangeEvent) {
        setLstEvaluacionInadecuadaSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderOtroAdecuada(boolean renderOtroAdecuada) {
        this.renderOtroAdecuada = renderOtroAdecuada;
    }

    public boolean isRenderOtroAdecuada() {
        return renderOtroAdecuada;
    }

    public void setRenderOtosVarios(boolean renderOtosVarios) {
        this.renderOtosVarios = renderOtosVarios;
    }

    public boolean isRenderOtosVarios() {
        return renderOtosVarios;
    }

    public void setLstHallazgosVariosSelect(ValueChangeEvent valueChangeEvent) {
        setLstHallazgosVariosSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeOtroVarios() {
        renderOtosVarios = false;
        if (lstHallazgosVariosSelect != null && 
            !lstHallazgosVariosSelect.isEmpty()) {
            for (Iterator iterator = lstHallazgosVariosSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("OT"))
                    renderOtosVarios = true;
            }

        }
    }

    public void setLstSospecha(List lstSospecha) {
        this.lstSospecha = lstSospecha;
    }

    public List getLstSospecha() {
        if (lstSospecha == null || lstSospecha.isEmpty()) {
            lstSospecha = new ArrayList();
            lstSospecha.add(new SelectItem("VA", "Vasos At�picos"));
            lstSospecha.add(new SelectItem("NE", "Necrosis"));
            lstSospecha.add(new SelectItem("VD", "Vasos Delgados"));
            lstSospecha.add(new SelectItem("UN", "Ulcera (Necr�tica)"));
            lstSospecha.add(new SelectItem("SI", "Sup. Irregular "));
            lstSospecha.add(new SelectItem("TN", "Tumor Nodular "));
            lstSospecha.add(new SelectItem("LE", "Lesi�n Exofitica"));
            lstSospecha.add(new SelectItem("OT", "Otros"));

        }

        return lstSospecha;
    }

    public void setLstSospechaSelect(List<String> lstSospechaSelect) {
        this.lstSospechaSelect = lstSospechaSelect;
    }

    public List<String> getLstSospechaSelect() {
        return lstSospechaSelect;
    }

    public void setRenderOtraSospecha(boolean renderOtraSospecha) {
        this.renderOtraSospecha = renderOtraSospecha;
    }

    public boolean isRenderOtraSospecha() {
        return renderOtraSospecha;
    }

    public void setLstSospechaSelect(ValueChangeEvent valueChangeEvent) {
        setLstSospechaSelect((List<String>)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }


    public void changeSospecha() {
        renderOtraSospecha = false;
        if (lstSospechaSelect != null && !lstSospechaSelect.isEmpty()) {
            for (Iterator iterator = lstSospechaSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("OT"))
                    renderOtraSospecha = true;
            }

        }
    }

    public void resetDatos() {
        coloposcopia.setHclcinadeinfla(null);
        coloposcopia.setHclcinadesangr(null);
        coloposcopia.setHclcinadecicat(null);
        coloposcopia.setHclcinadeotro(null);
        coloposcopia.setHclchallamadur(null);
        coloposcopia.setHclchallaatrof(null);
        coloposcopia.setHclchallaquiste(null);
        coloposcopia.setHclchallagland(null);
        coloposcopia.setHclchallaectop(null);
        coloposcopia.setHclchalladecid(null);
        coloposcopia.setHclchallazona(null);
        coloposcopia.setHclchallacondi(null);
        coloposcopia.setHclchallainfla(null);
        coloposcopia.setHclchallaesten(null);
        coloposcopia.setHclchallaconge(null);
        coloposcopia.setHclchallapost(null);
        coloposcopia.setHclchallapolip(null);
        coloposcopia.setHclchallaendom(null);
        coloposcopia.setHclchallaotro(null);
        coloposcopia.setHclcvasosatipi(null);
        coloposcopia.setHclcnecrosis(null);
        coloposcopia.setHclcvasosdelga(null);
        coloposcopia.setHclcnulcera(null);
        coloposcopia.setHclcsupirreg(null);
        coloposcopia.setHclctumornudol(null);
        coloposcopia.setHclclesioexofi(null);
        coloposcopia.setHclcsospeotro(null);

        coloposcopia.setHclcgrad1epite(null);
        coloposcopia.setHclcgrad1borde(null);
        coloposcopia.setHclcgrad1mosai(null);
        coloposcopia.setHclcgrad1punte(null);
        coloposcopia.setHclcgrad2mosai(null);
        coloposcopia.setHclcgrad2borde(null);
        coloposcopia.setHclcgrad2signo(null);
        coloposcopia.setHclcgrad2aceta(null);
        coloposcopia.setHclcgrad2crest(null);
        coloposcopia.setHclcgrad2orifi(null);
        coloposcopia.setHclcgrad2puntil(null);
        coloposcopia.setHclcgrad2epacde(null);

    }


    public String aceptar() {
        navigationRule = "";

        ChcolposcopiaPK id = new ChcolposcopiaPK();
        coloposcopia.setHclcoperador(userName());
        coloposcopia.setHcldfecregistr(new Date());
        if (numeroConsulta != null) {
            id.setHcllconsulta(numeroConsulta);
            id.setHclctiposervi(tipoServicio);
            coloposcopia.setId(id);
        }

        resetDatos();


        if (coloposcopia.getHclcevalugener() != null && 
            coloposcopia.getHclcevalugener().equals("I")) {

            if (lstEvaluacionInadecuadaSelect != null && 
                !lstEvaluacionInadecuadaSelect.isEmpty()) {
                coloposcopia.setHclcinadeinfla("N");
                coloposcopia.setHclcinadesangr("N");
                coloposcopia.setHclcinadecicat("N");
                coloposcopia.setHclcinadeotro("N");

                for (Iterator iterator = 
                     lstEvaluacionInadecuadaSelect.iterator(); 
                     iterator.hasNext(); ) {
                    String codigo = (String)iterator.next();
                    if (codigo.equals("PI")) {
                        coloposcopia.setHclcinadeinfla("S");
                    }
                    if (codigo.equals("PS")) {
                        coloposcopia.setHclcinadesangr("S");
                    }

                    if (codigo.equals("PC")) {
                        coloposcopia.setHclcinadecicat("S");
                    }

                    if (codigo.equals("OT")) {
                        coloposcopia.setHclcinadeotro("S");
                    }
                }

            }


        }


        if (lstHallazgosNormalSelect != null && 
            !lstHallazgosNormalSelect.isEmpty()) {

            coloposcopia.setHclchallamadur("N");
            coloposcopia.setHclchallaatrof("N");
            coloposcopia.setHclchallaquiste("N");
            coloposcopia.setHclchallagland("N");
            coloposcopia.setHclchallaectop("N");
            coloposcopia.setHclchalladecid("N");

            for (Iterator iterator = lstHallazgosNormalSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("MA")) {
                    coloposcopia.setHclchallamadur("S");
                }
                if (codigo.equals("AT")) {
                    coloposcopia.setHclchallaatrof("S");
                }

                if (codigo.equals("QN")) {
                    coloposcopia.setHclchallaquiste("S");
                }

                if (codigo.equals("AG")) {
                    coloposcopia.setHclchallagland("S");
                }


                if (codigo.equals("EC")) {
                    coloposcopia.setHclchallaectop("S");
                }

                if (codigo.equals("DE")) {
                    coloposcopia.setHclchalladecid("S");
                }
            }

        }


        if (lstHallazgosVariosSelect != null && 
            !lstHallazgosVariosSelect.isEmpty()) {

            coloposcopia.setHclchallazona("N");
            coloposcopia.setHclchallacondi("N");
            coloposcopia.setHclchallainfla("N");
            coloposcopia.setHclchallaesten("N");
            coloposcopia.setHclchallaconge("N");
            coloposcopia.setHclchallapost("N");
            coloposcopia.setHclchallapolip("N");
            coloposcopia.setHclchallaendom("N");
            coloposcopia.setHclchallaotro("N");

            for (Iterator iterator = lstHallazgosVariosSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("ZC")) {
                    coloposcopia.setHclchallazona("S");
                }
                if (codigo.equals("CO")) {
                    coloposcopia.setHclchallacondi("S");
                }
                if (codigo.equals("IN")) {
                    coloposcopia.setHclchallainfla("S");
                }
                if (codigo.equals("ES")) {
                    coloposcopia.setHclchallaesten("S");
                }
                if (codigo.equals("AC")) {
                    coloposcopia.setHclchallaconge("S");
                }
                if (codigo.equals("AT")) {
                    coloposcopia.setHclchallapost("S");
                }
                if (codigo.equals("PO")) {
                    coloposcopia.setHclchallapolip("S");
                }
                if (codigo.equals("EN")) {
                    coloposcopia.setHclchallaendom("S");
                }
                if (codigo.equals("OT")) {
                    coloposcopia.setHclchallaotro("S");
                }
            }

        }


        if (lstSospechaSelect != null && !lstSospechaSelect.isEmpty()) {
            coloposcopia.setHclcvasosatipi("N");
            coloposcopia.setHclcnecrosis("N");
            coloposcopia.setHclcvasosdelga("N");
            coloposcopia.setHclcnulcera("N");
            coloposcopia.setHclcsupirreg("N");
            coloposcopia.setHclctumornudol("N");
            coloposcopia.setHclclesioexofi("N");
            coloposcopia.setHclcsospeotro("N");


            for (Iterator iterator = lstSospechaSelect.iterator(); 
                 iterator.hasNext(); ) {
                String codigo = (String)iterator.next();
                if (codigo.equals("VA")) {
                    coloposcopia.setHclcvasosatipi("S");
                }
                if (codigo.equals("NE")) {
                    coloposcopia.setHclcnecrosis("S");
                }

                if (codigo.equals("VD")) {
                    coloposcopia.setHclcvasosdelga("S");
                }

                if (codigo.equals("UN")) {
                    coloposcopia.setHclcnulcera("S");
                }

                if (codigo.equals("SI")) {
                    coloposcopia.setHclcsupirreg("S");
                }

                if (codigo.equals("TN")) {
                    coloposcopia.setHclctumornudol("S");
                }
                if (codigo.equals("LE")) {
                    coloposcopia.setHclclesioexofi("S");
                }
                if (codigo.equals("OT")) {
                    coloposcopia.setHclcsospeotro("S");
                }
            }

        }

        if (coloposcopia.getHclcgradohalla() != null) {
            if (coloposcopia.getHclcgradohalla().equals("1")) {

                coloposcopia.setHclcgrad2mosai(null);
                coloposcopia.setHclcgrad2borde(null);
                coloposcopia.setHclcgrad2signo(null);
                coloposcopia.setHclcgrad2aceta(null);
                coloposcopia.setHclcgrad2crest(null);
                coloposcopia.setHclcgrad2orifi(null);
                coloposcopia.setHclcgrad2puntil(null);
                coloposcopia.setHclcgrad2epacde(null);
                

                if (lstGrado1Select != null && !lstGrado1Select.isEmpty()) {

                    coloposcopia.setHclcgrad1epite("N");
                    coloposcopia.setHclcgrad1borde("N");
                    coloposcopia.setHclcgrad1mosai("N");
                    coloposcopia.setHclcgrad1punte("N");

                    for (Iterator iterator = lstGrado1Select.iterator(); 
                         iterator.hasNext(); ) {
                        String codigo = (String)iterator.next();
                        if (codigo.equals("EA")) {
                            coloposcopia.setHclcgrad1epite("S");
                        }
                        if (codigo.equals("BI")) {
                            coloposcopia.setHclcgrad1borde("S");
                        }
                        if (codigo.equals("MF")) {
                            coloposcopia.setHclcgrad1mosai("S");
                        }
                        if (codigo.equals("PF")) {
                            coloposcopia.setHclcgrad1punte("S");
                        }

                    }

                }

            } else if (coloposcopia.getHclcgradohalla().equals("2")) {

                coloposcopia.setHclcgrad1epite(null);
                coloposcopia.setHclcgrad1borde(null);
                coloposcopia.setHclcgrad1mosai(null);
                coloposcopia.setHclcgrad1punte(null);


                if (lstGrado2Select != null && !lstGrado2Select.isEmpty()) {
                    coloposcopia.setHclcgrad2mosai("N");
                    coloposcopia.setHclcgrad2borde("N");
                    coloposcopia.setHclcgrad2signo("N");
                    coloposcopia.setHclcgrad2aceta("N");
                    coloposcopia.setHclcgrad2crest("N");
                    coloposcopia.setHclcgrad2orifi("N");
                    coloposcopia.setHclcgrad2puntil("N");
                    coloposcopia.setHclcgrad2epacde("N");

                    for (Iterator iterator = lstGrado2Select.iterator(); 
                         iterator.hasNext(); ) {
                        String codigo = (String)iterator.next();
                        if (codigo.equals("MG")) {
                            coloposcopia.setHclcgrad2mosai("S");
                        }
                        if (codigo.equals("BD")) {
                            coloposcopia.setHclcgrad2borde("S");
                        }
                        if (codigo.equals("SB")) {
                            coloposcopia.setHclcgrad2signo("S");
                        }
                        if (codigo.equals("AE")) {
                            coloposcopia.setHclcgrad2aceta("S");
                        }
                        if (codigo.equals("SC")) {
                            coloposcopia.setHclcgrad2crest("S");
                        }
                        if (codigo.equals("OG")) {
                            coloposcopia.setHclcgrad2orifi("S");
                        }

                        if (codigo.equals("PG")) {
                            coloposcopia.setHclcgrad2puntil("S");
                        }
                        if (codigo.equals("EA")) {
                            coloposcopia.setHclcgrad2epacde("S");
                        }

                    }

                }


            } else if (coloposcopia.getHclcgradohalla().equals("3")) {
                coloposcopia.setHclcgrad1epite(null);
                coloposcopia.setHclcgrad1borde(null);
                coloposcopia.setHclcgrad1mosai(null);
                coloposcopia.setHclcgrad1punte(null);
                coloposcopia.setHclcgrad2mosai(null);
                coloposcopia.setHclcgrad2borde(null);
                coloposcopia.setHclcgrad2signo(null);
                coloposcopia.setHclcgrad2aceta(null);
                coloposcopia.setHclcgrad2crest(null);
                coloposcopia.setHclcgrad2orifi(null);
                coloposcopia.setHclcgrad2puntil(null);
                coloposcopia.setHclcgrad2epacde(null);
                

            }
        }


        try {
            serviceLocator.getClinicoService().saveColposcopia(coloposcopia);
            FacesUtils.addInfoMessage(MSG_ADICION);
            FacesUtils.resetManagedBean(menuBean);
            navigationRule = nextAction;
        } catch (ModelException e) {
            FacesUtils.addErrorMessage(MSG_NO_ADICION);
            e.printStackTrace();
            navigationRule = "";
        }
        return navigationRule;
    }


    public void setLstOpcionesSi(List lstOpcionesSi) {
        this.lstOpcionesSi = lstOpcionesSi;
    }

    public List getLstOpcionesSi() {
        if (lstOpcionesSi == null || lstOpcionesSi.isEmpty()) {
            lstOpcionesSi = new ArrayList();
            lstOpcionesSi.add(new SelectItem("S", "SI"));
            lstOpcionesSi.add(new SelectItem("N", "NO"));

        }

        return lstOpcionesSi;
        }

    public void setHclctomobiop(ValueChangeEvent valueChangeEvent) {
        coloposcopia.setHclctomobiop((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }

    public void setRenderTomaBiopsa(boolean renderTomaBiopsa) {
        this.renderTomaBiopsa = renderTomaBiopsa;
    }

    public boolean isRenderTomaBiopsa() {
        return renderTomaBiopsa;
    }
    
    
    public void changeTomoBiopsa(){
        renderTomaBiopsa = false; 
        
        if(coloposcopia != null && coloposcopia.getHclctomobiop()!= null 
        &&   coloposcopia.getHclctomobiop().equals("S")){
            renderTomaBiopsa = true; 
        }
    }

    public void setLtsTipoHallazgo(List ltsTipoHallazgo) {
        this.ltsTipoHallazgo = ltsTipoHallazgo;
    }

    public List getLtsTipoHallazgo() {
        if (ltsTipoHallazgo == null || ltsTipoHallazgo.isEmpty()) {
            ltsTipoHallazgo = new ArrayList();
            ltsTipoHallazgo.add(new SelectItem("N", "Normal"));
            ltsTipoHallazgo.add(new SelectItem("A", "Anormal"));

        }

        return ltsTipoHallazgo;
        }

    public void setRenderNormal(boolean renderNormal) {
        this.renderNormal = renderNormal;
    }

    public boolean isRenderNormal() {
        return renderNormal;
    }
    
    public void changeTipoHallazgos(){
        renderNormal = true;
        if(coloposcopia != null && coloposcopia.getHclctipohalla() != null 
        && coloposcopia.getHclctipohalla().equals("A")){
            renderNormal = false;
        }
    }

    public void setHclctipohalla(ValueChangeEvent valueChangeEvent) {
        coloposcopia.setHclctipohalla((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
}
