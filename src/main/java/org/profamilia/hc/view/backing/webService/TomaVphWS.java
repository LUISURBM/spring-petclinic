//=======================================================================
// ARCHIVO ListaVphBean
// FECHA CREACI�N: 30/05/2019
// AUTOR: jariano
// Descripcion: Permite visualizar la lista de usuarios de VPH por medico 
// para un Usuario de una Histroia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.webService;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.BeanNavegacion;
import org.profamilia.hc.view.backing.cirugia.registro.IngresoCirugiaEnfermeria;
import org.profamilia.hc.view.backing.clinico.consultorio.vph.DatosUsuarioVphBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class TomaVphWS extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------

    private List<ConsultaTomaVph> listConsultaTomaVph;
    private List<ConsultaEpicenterResult> listconsultaEpicenterResult;
    private List<RegistraEpicienterResult> listRegistraEpicienterResult;
    private List<RegistroTomaVph> listRegistroTomaVph;
    private ConsultaTomaVph consultaTomaVph;
    private ConsultaEpicenterResult consultaEpicenterResult;
    private RegistraEpicienterResult registraEpicienterResult;
    private RegistroTomaVph registroTomaVph;
    private List<SelectItem> listTipoWebService;
    private String tipoWebService;
    private Boolean renderRegistroToma;
    private Boolean renderConsultaToma;
    public VphClient vphClient;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public TomaVphWS() {

    }


    public void init()  {
    }

    public RegistraEpicienterResult registroTomaVph(Cncitologi citologia,Cnconsclin consulta,Chusuario usuario) throws IOException {
        registroTomaVph = new RegistroTomaVph();
        registroTomaVph.setUsuario("Ivan");
        registroTomaVph.setPassword("123");
        registroTomaVph.setNumeroDeOrden(citologia.getCcinconsec().toString());//consecutivo
        registroTomaVph.setIdentificacionDelPaciente(consulta.getCcoanumide().toString());
        registroTomaVph.setNombreDelPaciente(consulta.getCcocprinom()+" "+formatearCampoNulo(consulta.getCcocsegnom())+" "+consulta.getCcocpriape()+" "+formatearCampoNulo(consulta.getCcocsegape()));//todo el nombre
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String fechaNacimiento = df.format(usuario.getHusdfechanacim());
        registroTomaVph.setFechaDeNacimiento(fechaNacimiento);
        registroTomaVph.setCliente(consulta.getCconcontra().toString());//Contrato
        String fechaAdmision = df.format(consulta.getCcodfecreg());
        registroTomaVph.setFechaDeAdmision(fechaAdmision);
        registroTomaVph.setCampoDeMuestra1(consulta.getCconclinic().toString());
        listRegistraEpicienterResult = new ArrayList();
        RegistraEpicienterResult registraEpicienterResult = 
            new RegistraEpicienterResult();
        vphClient = new VphClient();
        registraEpicienterResult = vphClient.registrarTomaVph(registroTomaVph);
        return registraEpicienterResult;
       

    }

    public List<ConsultaEpicenterResult> consultaTomaVph(Cncitologi citologia)  {
        consultaTomaVph = new ConsultaTomaVph();
        consultaTomaVph.setUsuario("Ivan");
        consultaTomaVph.setPassword("123");
        consultaTomaVph.setNumeroOrden(citologia.getCcinconsec().toString());
        //consultaTomaVph.setNumeroOrden("4355 ana");
        consultaTomaVph.setIdentificacionPaciente("");
        //consultaTomaVph.setIdentificacionPaciente(citologia.getCcianumide().toString());
        listconsultaEpicenterResult = new ArrayList();
        vphClient = new VphClient();
        try {
            listconsultaEpicenterResult = vphClient.consultaTomaVph(consultaTomaVph);
        } catch (IOException e) {
            e.getMessage();
        }
        return listconsultaEpicenterResult;
    }

    public void onChangeTipoWebService() {
        if ("R".equals(tipoWebService)) {
            renderConsultaToma = false;
            renderRegistroToma = true;
        } else if ("C".equals(tipoWebService)) {
            renderRegistroToma = false;
            renderConsultaToma = true;
        }
    }

}
