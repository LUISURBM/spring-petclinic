//=======================================================================
// ARCHIVO Registrar Usuario Asesoria 
// FECHA CREACI�N: 15/01/2012
// AUTOR: Jos� Andres Riano Rinc�n
// Descripci�n: Registro de otra asesoria.
//=======================================================================

package org.profamilia.hc.view.backing.asesoria;

import java.util.*;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;

public class RegistrarOtraAsesoriaBean extends BaseBean
{

    public RegistrarOtraAsesoriaBean()
    {
    }

    public void init()
    {
        asesoria = new Chasesoria();
        selectedIndex = 0;
    }

    public void setRenderEnviaTemporal(ValueChangeEvent valueChangeEvent)
    {
        setRenderEnviaTemporal(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderEnviaDefinitiva(ValueChangeEvent valueChangeEvent)
    {
        setRenderEnviaDefinitiva(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setHascdicapadad(ValueChangeEvent valueChangeEvent)
    {
        asesoria.setHascdicapadad((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderEnviaGeneral(ValueChangeEvent valueChangeEvent)
    {
        setRenderEnviaGeneral(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderEnviaEspecial(ValueChangeEvent valueChangeEvent)
    {
        setRenderEnviaEspecial(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderEnviaLaboratorio(ValueChangeEvent valueChangeEvent)
    {
        setRenderEnviaLaboratorio(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderEnviaProductos(ValueChangeEvent valueChangeEvent)
    {
        setRenderEnviaProductos(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderPsicologia(ValueChangeEvent valueChangeEvent)
    {
        setRenderPsicologia(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setRenderOtro(ValueChangeEvent valueChangeEvent)
    {
        setRenderOtro(((Boolean)valueChangeEvent.getNewValue()).booleanValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void buscadorUsuario()
    {
        renderUsuario = false;
        renderRegistrar = false;
        lstUsuarios = new ArrayList();
        boolean wexito = true;
        String url = "body:formDatosUsuarios:panelTabDatosUsuario:";
        if(asesoria.getHasetipoiden() == null || asesoria.getHasetipoiden().equals(""))
        {
            FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("tipoIde").toString(), "El campo es obligatorio");
            wexito = false;
        }
        if(asesoria.getHasanumeiden() == null)
        {
            FacesUtils.addErrorMessage((new StringBuilder()).append(url).append("itNumeroIdentificacion").toString(), "El campo es obligatorio");
            wexito = false;
        }
        if(wexito && asesoria != null)
        {
            try
            {
                lstUsuarios = serviceLocator.getClinicoService().getUsuarios(asesoria.getHasetipoiden(), asesoria.getHasanumeiden());
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
            if(lstUsuarios != null && !lstUsuarios.isEmpty())
            {
                if(lstUsuarios.size() == 1)
                {
                    usuario = (Chusuario)lstUsuarios.get(0);
                    renderUsuario = true;
                    if(usuario != null)
                    {
                        String wnombre = usuario.getHuscprimernomb();
                        if(usuario.getHuscsegundnomb() != null)
                            wnombre = (new StringBuilder()).append(wnombre).append(" ").append(usuario.getHuscsegundnomb()).append(" ").append(usuario.getHuscprimerapel()).toString();
                        else
                            wnombre = (new StringBuilder()).append(wnombre).append(" ").append(usuario.getHuscprimerapel()).toString();
                        if(usuario.getHuscsegundapel() != null)
                            wnombre = (new StringBuilder()).append(wnombre).append(" ").append(usuario.getHuscsegundapel()).toString();
                        if(usuario.getHusedicapadad() != null && usuario.getHusedicapadad().equals("S"))
                            renderDiscapacidad = true;
                        asesoria.setHasanumeiden(usuario.getHusanumeiden());
                        asesoria.setHasccorreoelec(usuario.getHusccorreoelec());
                        asesoria.setHascprimerapel(null);
                        asesoria.setHascprimernomb(wnombre);
                        asesoria.setHascsegundnomb(null);
                        asesoria.setHascsegundapel(null);
                        asesoria.setHasdfechanacim(null);
                        asesoria.setHasnedad(Integer.valueOf(calcularEdad(usuario.getHusdfechanacim(), new Date())));
                        asesoria.setHasesexo(usuario.getHusesexo());
                        asesoria.setHasetipoafilia(usuario.getHusetipoafilia());
                        asesoria.setHaslnumusu(usuario.getHuslnumero());
                        asesoria.setHasesexo(usuario.getHusesexo());
                        asesoria.setHascdicapadad(usuario.getHusedicapadad());
                        asesoria.setHascdiscaselec(usuario.getHusediscaselec());
                    }
                } else
                if(lstUsuarios.size() > 1)
                {
                    renderSelecionarUsuario = true;
                    selectedIndex = 1;
                }
            } else
            {
                renderRegistrar = true;
                asesoria.setHaslnumusu(Long.valueOf(0L));
                asesoria.setHascprimernomb(null);
                asesoria.setHascprimerapel(null);
                asesoria.setHascsegundnomb(null);
                asesoria.setHascsegundapel(null);
                asesoria.setHasdfechanacim(null);
                asesoria.setHasccorreoelec(null);
                asesoria.setHasetipoafilia(null);
                asesoria.setHasesexo(null);
                asesoria.setHascdicapadad(null);
                asesoria.setHascdiscaselec(null);
            }
        }
    }

    public void resetDatos()
    {
        asesoria = new Chasesoria();
        nextAction = "";
        navegationRule = "";
        renderUsuario = false;
        renderRegistrar = false;
        usuario = new Chusuario();
        navegarAsesoria = false;
        navegarSeguimiento = false;
        renderDiscapacidad = false;
        renderPlanificacionTemporal = false;
        renderPlanificacionDefinitiva = false;
        renderIlve = false;
        renderIts = false;
        renderSexualidad = false;
        renderVih = false;
        renderOtro = false;
        renderEnviaTemporal = false;
        renderEnviaDefinitiva = false;
        renderEnviaGeneral = false;
        renderEnviaEspecial = false;
        renderEnviaLaboratorio = false;
        renderEnviaProductos = false;
        renderSelecionarUsuario = false;
        calendarFechaNacimiento = new UIInput();
        renderAutorizaContacto = false;
        renderIlve = false;
        renderOtro = false;
        existeVioFisica = false;
        existeVioPsicologica = false;
        existeVioSexual = false;
        FacesUtils.resetManagedBean("registrarAsesoriaAviseBean");
        FacesUtils.resetManagedBean("registrarSeguimientoAviseBean");
        FacesUtils.resetManagedBean("registrarUsuarioAsesoriaBean");
        FacesUtils.resetManagedBean("mnuAsesoriaBean");
    }

    public void setListTipoIdentificacion(List param)
    {
        listTipoIdentificacion = param;
    }

    public List getListTipoIdentificacion()
    {
        if(listTipoIdentificacion == null || listTipoIdentificacion.isEmpty())
        {
            listTipoIdentificacion = new ArrayList();
            ArrayList listTipoIdentificacionAux = null;
            try
            {
                listTipoIdentificacionAux = (ArrayList)serviceLocator.getClinicoService().getTipoIdentificacion();
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
            if(!listTipoIdentificacionAux.isEmpty())
            {
                Iterator it = listTipoIdentificacionAux.iterator();
                int i = 0;
                listTipoIdentificacion.add(new SelectItem("", "Seleccione una opci\363n ..."));
                while(it.hasNext()) 
                {
                    it.next();
                    listTipoIdentificacion.add(new SelectItem(((Cptipoiden)listTipoIdentificacionAux.get(i)).getCticcodigo(), ((Cptipoiden)listTipoIdentificacionAux.get(i)).getCticdescri()));
                    i++;
                }
            }
        }
        return listTipoIdentificacion;
    }

    public void setListTipoAfiliacion(List param)
    {
        listTipoAfiliacion = param;
    }

    public List getListTipoAfiliacion()
    {
        if(listTipoAfiliacion == null || listTipoAfiliacion.isEmpty())
        {
            listTipoAfiliacion = new ArrayList();
            ArrayList listTipoAfiliacionAux = null;
            try
            {
                listTipoAfiliacionAux = (ArrayList)getServiceLocator().getClinicoService().getTipoafiliado();
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
            if(!listTipoAfiliacionAux.isEmpty())
            {
                listTipoAfiliacion.add(new SelectItem("", "Seleccione una opcion ..."));
                Iterator it = listTipoAfiliacionAux.iterator();
                for(int i = 0; it.hasNext(); i++)
                {
                    it.next();
                    listTipoAfiliacion.add(new SelectItem(((Chtipoafilia)listTipoAfiliacionAux.get(i)).getCtaecodigo().toString(), ((Chtipoafilia)listTipoAfiliacionAux.get(i)).getCtacdescripcio()));
                }

            }
        }
        return listTipoAfiliacion;
    }

    public void setLstDiscapacidad(List lstDiscapacidad)
    {
        this.lstDiscapacidad = lstDiscapacidad;
    }

    public List getLstDiscapacidad()
    {
        if(lstDiscapacidad == null || lstDiscapacidad.isEmpty())
        {
            lstDiscapacidad = new ArrayList();
            lstDiscapacidad.add(new SelectItem("", "Seleccione una opci�n"));
            lstDiscapacidad.add(new SelectItem("VI", "Visual"));
            lstDiscapacidad.add(new SelectItem("AU", "Auditiva"));
            lstDiscapacidad.add(new SelectItem("MO", "Motriz"));
            lstDiscapacidad.add(new SelectItem("CO", "Cognitiva"));
            lstDiscapacidad.add(new SelectItem("PS", "Psicosocial"));
            lstDiscapacidad.add(new SelectItem("MU", "M�tiple"));
        }
        return lstDiscapacidad;
    }

    public void setListSexos(List param)
    {
        listSexos = param;
    }

    public List getListSexos()
    {
        if(listSexos == null || listSexos.isEmpty())
        {
            listSexos = new ArrayList();
            ArrayList listSexoAux = null;
            listSexos.add(new SelectItem("", "Seleccione..."));
            try
            {
                listSexoAux = (ArrayList)getServiceLocator().getClinicoService().getSexoNew();
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
            if(!listSexoAux.isEmpty())
            {
                Iterator it = listSexoAux.iterator();
                for(int i = 0; it.hasNext(); i++)
                {
                    it.next();
                    listSexos.add(new SelectItem(((Chsexo)listSexoAux.get(i)).getCsxecodigo(), ((Chsexo)listSexoAux.get(i)).getCsxcdescripcio()));
                }

            }
        }
        return listSexos;
    }

    public void setListzona(List listzona)
    {
        this.listzona = listzona;
    }

    public List getListzona()
    {
        if(listzona == null || listzona.isEmpty())
        {
            listzona = new ArrayList();
            ArrayList zonaList = null;
            try
            {
                zonaList = (ArrayList)serviceLocator.getClinicoService().getZona();
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
            Iterator it = zonaList.iterator();
            for(int i = 0; it.hasNext(); i++)
            {
                it.next();
                listzona.add(new SelectItem(((Chzona)zonaList.get(i)).getId(), ((Chzona)zonaList.get(i)).getDescripcion()));
            }

        }
        return listzona;
    }

    public void setListEstadoCivil(List listEstadoCivil)
    {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List getListEstadoCivil()
    {
        if(listEstadoCivil == null || listEstadoCivil.isEmpty())
        {
            listEstadoCivil = new ArrayList();
            ArrayList listEstadoCivilAux = null;
            try
            {
                listEstadoCivilAux = (ArrayList)getServiceLocator().getClinicoService().getEstadoCivilFemenino();
            }
            catch(ModelException e)
            {
                e.printStackTrace();
            }
            if(!listEstadoCivilAux.isEmpty())
            {
                Iterator it = listEstadoCivilAux.iterator();
                for(int i = 0; it.hasNext(); i++)
                {
                    it.next();
                    listEstadoCivil.add(new SelectItem(((Chestadociv)listEstadoCivilAux.get(i)).getCececodigo(), ((Chestadociv)listEstadoCivilAux.get(i)).getCeccdescripcio()));
                }

            }
        }
        return listEstadoCivil;
    }

    public void changeDiscapacidad()
    {
        renderDiscapacidad = false;
        if(asesoria != null && asesoria.getHascdicapadad() != null && asesoria.getHascdicapadad().equals("S"))
            renderDiscapacidad = true;
    }

    public void setExisteVioFisica(boolean existeVioFisica)
    {
        this.existeVioFisica = existeVioFisica;
    }

    public boolean isExisteVioFisica()
    {
        return existeVioFisica;
    }

    public void setExisteVioPsicologica(boolean existeVioPsicologica)
    {
        this.existeVioPsicologica = existeVioPsicologica;
    }

    public boolean isExisteVioPsicologica()
    {
        return existeVioPsicologica;
    }

    public void setExisteVioSexual(boolean existeVioSexual)
    {
        this.existeVioSexual = existeVioSexual;
    }

    public boolean isExisteVioSexual()
    {
        return existeVioSexual;
    }

    public void setNextAction(String nextAction)
    {
        this.nextAction = nextAction;
    }

    public String getNextAction()
    {
        return nextAction;
    }

    public void setMenuBean(String menuBean)
    {
        this.menuBean = menuBean;
    }

    public String getMenuBean()
    {
        return menuBean;
    }

    public void setRenderPlanificacionTemporal(boolean renderPlanificacionTemporal)
    {
        this.renderPlanificacionTemporal = renderPlanificacionTemporal;
    }

    public boolean isRenderPlanificacionTemporal()
    {
        return renderPlanificacionTemporal;
    }

    public void setRenderPlanificacionDefinitiva(boolean renderPlanificacionDefinitiva)
    {
        this.renderPlanificacionDefinitiva = renderPlanificacionDefinitiva;
    }

    public boolean isRenderPlanificacionDefinitiva()
    {
        return renderPlanificacionDefinitiva;
    }

    public void setRenderUsuario(boolean renderUsuario)
    {
        this.renderUsuario = renderUsuario;
    }

    public boolean isRenderUsuario()
    {
        return renderUsuario;
    }

    public void setLstUsuarios(List lstUsuarios)
    {
        this.lstUsuarios = lstUsuarios;
    }

    public List getLstUsuarios()
    {
        return lstUsuarios;
    }

    public void setRenderRegistrar(boolean renderRegistrar)
    {
        this.renderRegistrar = renderRegistrar;
    }

    public boolean isRenderRegistrar()
    {
        return renderRegistrar;
    }

    public void setNavegationRule(String navegationRule)
    {
        this.navegationRule = navegationRule;
    }

    public String getNavegationRule()
    {
        return navegationRule;
    }

    public void setMsg_existe_asesoria(String msg_existe_asesoria)
    {
        this.msg_existe_asesoria = msg_existe_asesoria;
    }

    public String getMsg_existe_asesoria()
    {
        return msg_existe_asesoria;
    }

    public void setSelectedIndex(int selectedIndex)
    {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex()
    {
        return selectedIndex;
    }

    public void setDtConsultaUsuario(HtmlDataTable dtConsultaUsuario)
    {
        this.dtConsultaUsuario = dtConsultaUsuario;
    }

    public HtmlDataTable getDtConsultaUsuario()
    {
        return dtConsultaUsuario;
    }

    public void setNavegarAsesoria(boolean navegarAsesoria)
    {
        this.navegarAsesoria = navegarAsesoria;
    }

    public boolean isNavegarAsesoria()
    {
        return navegarAsesoria;
    }

    public void setNavegarSeguimiento(boolean navegarSeguimiento)
    {
        this.navegarSeguimiento = navegarSeguimiento;
    }

    public boolean isNavegarSeguimiento()
    {
        return navegarSeguimiento;
    }

    public void setRenderSelecionarUsuario(boolean renderSelecionarUsuario)
    {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    public boolean isRenderSelecionarUsuario()
    {
        return renderSelecionarUsuario;
    }

    public void setCalendarFechaNacimiento(UIInput calendarFechaNacimiento)
    {
        this.calendarFechaNacimiento = calendarFechaNacimiento;
    }

    public UIInput getCalendarFechaNacimiento()
    {
        return calendarFechaNacimiento;
    }

    public void setRenderAutorizaContacto(boolean renderAutorizaContacto)
    {
        this.renderAutorizaContacto = renderAutorizaContacto;
    }

    public boolean isRenderAutorizaContacto()
    {
        return renderAutorizaContacto;
    }

    public void setRenderEnviaTemporal(boolean renderEnviaTemporal)
    {
        this.renderEnviaTemporal = renderEnviaTemporal;
    }

    public boolean isRenderEnviaTemporal()
    {
        return renderEnviaTemporal;
    }

    public void setRenderEnviaDefinitiva(boolean renderEnviaDefinitiva)
    {
        this.renderEnviaDefinitiva = renderEnviaDefinitiva;
    }

    public boolean isRenderEnviaDefinitiva()
    {
        return renderEnviaDefinitiva;
    }

    public void setRenderEnviaGeneral(boolean renderEnviaGeneral)
    {
        this.renderEnviaGeneral = renderEnviaGeneral;
    }

    public boolean isRenderEnviaGeneral()
    {
        return renderEnviaGeneral;
    }

    public void setRenderEnviaEspecial(boolean renderEnviaEspecial)
    {
        this.renderEnviaEspecial = renderEnviaEspecial;
    }

    public boolean isRenderEnviaEspecial()
    {
        return renderEnviaEspecial;
    }

    public void setRenderEnviaLaboratorio(boolean renderEnviaLaboratorio)
    {
        this.renderEnviaLaboratorio = renderEnviaLaboratorio;
    }

    public boolean isRenderEnviaLaboratorio()
    {
        return renderEnviaLaboratorio;
    }

    public void setRenderEnviaProductos(boolean renderEnviaProductos)
    {
        this.renderEnviaProductos = renderEnviaProductos;
    }

    public boolean isRenderEnviaProductos()
    {
        return renderEnviaProductos;
    }

    public void setRenderIlve(boolean renderIlve)
    {
        this.renderIlve = renderIlve;
    }

    public boolean isRenderIlve()
    {
        return renderIlve;
    }

    public void setRenderOtro(boolean renderOtro)
    {
        this.renderOtro = renderOtro;
    }

    public boolean isRenderOtro()
    {
        return renderOtro;
    }

    public void setAsesoria(Chasesoria asesoria)
    {
        this.asesoria = asesoria;
    }

    public Chasesoria getAsesoria()
    {
        return asesoria;
    }

    public void setUsuario(Chusuario usuario)
    {
        this.usuario = usuario;
    }

    public Chusuario getUsuario()
    {
        return usuario;
    }

    public void setRenderIts(boolean renderIts)
    {
        this.renderIts = renderIts;
    }

    public boolean isRenderIts()
    {
        return renderIts;
    }

    public void setRenderSexualidad(boolean renderSexualidad)
    {
        this.renderSexualidad = renderSexualidad;
    }

    public boolean isRenderSexualidad()
    {
        return renderSexualidad;
    }

    public void setRenderVih(boolean renderVih)
    {
        this.renderVih = renderVih;
    }

    public boolean isRenderVih()
    {
        return renderVih;
    }

    public void setLstResultadoEmbarazo(List lstResultadoEmbarazo)
    {
        this.lstResultadoEmbarazo = lstResultadoEmbarazo;
    }

    public List getLstResultadoEmbarazo()
    {
        if(lstResultadoEmbarazo == null || lstResultadoEmbarazo.isEmpty())
        {
            lstResultadoEmbarazo = new ArrayList();
            lstResultadoEmbarazo.add(new SelectItem("P", "Pos(+)"));
            lstResultadoEmbarazo.add(new SelectItem("N", "Neg(-)"));
        }
        return lstResultadoEmbarazo;
    }

    public void agregarUsuario()
    {
        usuario = (Chusuario)dtConsultaUsuario.getRowData();
        if(usuario != null)
        {
            String wnombre = usuario.getHuscprimernomb();
            if(usuario.getHuscsegundnomb() != null)
                wnombre = (new StringBuilder()).append(wnombre).append(" ").append(usuario.getHuscsegundnomb()).append(" ").append(usuario.getHuscprimerapel()).toString();
            else
                wnombre = (new StringBuilder()).append(wnombre).append(" ").append(usuario.getHuscprimerapel()).toString();
            if(usuario.getHuscsegundapel() != null)
                wnombre = (new StringBuilder()).append(wnombre).append(" ").append(usuario.getHuscsegundapel()).toString();
            asesoria.setHasanumeiden(usuario.getHusanumeiden());
            asesoria.setHasccorreoelec(usuario.getHusccorreoelec());
            asesoria.setHascprimerapel(null);
            asesoria.setHascprimernomb(wnombre);
            asesoria.setHascsegundnomb(null);
            asesoria.setHascsegundapel(null);
            asesoria.setHasdfechanacim(null);
            asesoria.setHasnedad(Integer.valueOf(calcularEdad(usuario.getHusdfechanacim(), new Date())));
            asesoria.setHasesexo(usuario.getHusesexo());
            asesoria.setHasetipoafilia(usuario.getHusetipoafilia());
            asesoria.setHaslnumusu(usuario.getHuslnumero());
        }
    }

    public String seleccionarUsuario()
    {
        renderSelecionarUsuario = false;
        renderUsuario = true;
        selectedIndex = 0;
        return "actual";
    }

    public String guardarUsuario()
    {
        boolean wexito = true;
        asesoria.setHascoperador(userName());
        asesoria.setHasdfecregistr(new Date());
        asesoria.setHaseestado("VG");
        asesoria.setHasnclinic(getClinica().getCclncodigo());
        navegationRule = "";
        asesoria.setHaseplanitempo("N");
        asesoria.setHaseplanidefin("N");
        asesoria.setHaseilve("N");
        asesoria.setHaseits("N");
        asesoria.setHasediversexua("N");
        asesoria.setHasesexuaejerc("N");
        asesoria.setHasevih("N");
        asesoria.setHaseviolencia("N");
        asesoria.setHasevacunacion("N");
        asesoria.setHasepruebembar("N");
        asesoria.setHaseotro("N");
        asesoria.setHascviolefisic("N");
        asesoria.setHascviolepsico("N");
        asesoria.setHascviolesexua("N");
        if(existeVioFisica)
            asesoria.setHascviolefisic("S");
        if(existeVioPsicologica)
            asesoria.setHascviolepsico("S");
        if(existeVioSexual)
            asesoria.setHascviolesexua("S");
        if(renderPlanificacionTemporal)
            asesoria.setHaseplanitempo("S");
        if(renderPlanificacionDefinitiva)
            asesoria.setHaseplanidefin("S");
        if(renderIlve)
            asesoria.setHaseilve("S");
        if(renderIts)
            asesoria.setHaseits("S");
        if(renderSexualidad)
            asesoria.setHasesexuaejerc("S");
        if(renderVih)
            asesoria.setHasevih("S");
        if(renderEnviaTemporal)
            asesoria.setHascenvplntem("S");
        if(renderEnviaDefinitiva)
            asesoria.setHascenvplndef("S");
        if(renderEnviaGeneral)
            asesoria.setHascenvmedgen("S");
        if(renderEnviaEspecial)
            asesoria.setHascenvmedesp("S");
        if(renderEnviaLaboratorio)
            asesoria.setHascenvlabcli("S");
        if(renderEnviaProductos)
            asesoria.setHascenvproduc("S");
        if(renderPsicologia)
            asesoria.setHascenvpsicolo("S");
        if(renderOtro)
            asesoria.setHaseotro("S");
        else
            asesoria.setHasccualotro(null);
        if(!renderPlanificacionTemporal && !renderPlanificacionDefinitiva && !renderIlve && !renderIts && !renderSexualidad && !renderVih && !renderOtro && !existeVioFisica && !existeVioPsicologica && !existeVioSexual)
        {
            wexito = false;
            msgError = " Debe registrar el tipo de asesor\355a";
        }
        if(!renderEnviaTemporal && !renderEnviaDefinitiva && !renderEnviaGeneral && !renderEnviaEspecial && !renderEnviaLaboratorio && !renderEnviaProductos && !renderPsicologia)
        {
            wexito = false;
            msgError = " Debe registrar a donde se envia";
        }
        if(wexito)
            try
            {
                serviceLocator.getClinicoService().saveOtraAsesoria(asesoria);
                navegationRule = "irRegistrarOtrasAsesorias";
                resetDatos();
                FacesUtils.addInfoMessage("Se ingreso la informaci\363n satisfactoriamente.");
            }
            catch(ModelException e)
            {
                navegationRule = "actual";
                FacesUtils.addErrorMessage((new StringBuilder()).append("Adicion no realizada ").append(e.getMessage()).toString());
            }
        else
            FacesUtils.addErrorMessage(msgError);
        return navegationRule;
    }

    public void setRenderDiscapacidad(boolean renderDiscapacidad)
    {
        this.renderDiscapacidad = renderDiscapacidad;
    }

    public boolean isRenderDiscapacidad()
    {
        return renderDiscapacidad;
    }

    public void setRenderPsicologia(boolean renderPsicologia)
    {
        this.renderPsicologia = renderPsicologia;
    }

    public boolean isRenderPsicologia()
    {
        return renderPsicologia;
    }

    private List listEstadoCivil;
    private List listzona;
    private List lstResultadoEmbarazo;
    private List listTipoIdentificacion;
    private List listTipoAfiliacion;
    private List listSexos;
    private Chasesoria asesoria;
    private String nextAction;
    private String navegationRule;
    private String menuBean;
    private boolean renderUsuario;
    private boolean renderRegistrar;
    private List lstUsuarios;
    private Chusuario usuario;
    private int selectedIndex;
    static final int ACTIVAR_DATOS_USUARIO = 0;
    static final int ACTIVAR_SELECCIONAR_USUARIOS = 1;
    private String msg_existe_asesoria;
    private boolean navegarAsesoria;
    private boolean navegarSeguimiento;
    private boolean renderSelecionarUsuario;
    private HtmlDataTable dtConsultaUsuario;
    private UIInput calendarFechaNacimiento;
    private boolean renderAutorizaContacto;
    private boolean renderPlanificacionTemporal;
    private boolean renderPlanificacionDefinitiva;
    private boolean renderIlve;
    private boolean renderIts;
    private boolean renderSexualidad;
    private boolean renderVih;
    private boolean renderEnviaTemporal;
    private boolean renderEnviaDefinitiva;
    private boolean renderEnviaGeneral;
    private boolean renderEnviaEspecial;
    private boolean renderEnviaLaboratorio;
    private boolean renderEnviaProductos;
    private boolean renderPsicologia;
    private boolean renderOtro;
    private boolean existeVioFisica;
    private boolean existeVioPsicologica;
    private boolean existeVioSexual;
    private String msgError;
    private boolean renderDiscapacidad;
    private List lstDiscapacidad;
}