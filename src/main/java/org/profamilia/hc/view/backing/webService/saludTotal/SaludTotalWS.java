//=======================================================================
// ARCHIVO ListaVphBean
// FECHA CREACI�N: 30/05/2019
// AUTOR: jariano
// Descripcion: Permite visualizar la lista de usuarios de VPH por medico 
// para un Usuario de una Histroia Clinica 
//=======================================================================
package org.profamilia.hc.view.backing.webService.saludTotal;

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
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.Afiliado;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.Analito;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.Clasificacion;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.GrupoLaboratorio;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.IPS;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.Referencia;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.request.Servicio;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.ModuleConfig;


//=======================================================================
//  BIBLIOTECAS REQUERIDAS
//=======================================================================


//=======================================================================
//  CLASE
//=======================================================================

public class SaludTotalWS extends BaseBean {

    //-----------------------------------------------------------------------
    //  ATRIBUTOS DE INSTANCIA
    //-----------------------------------------------------------------------
    
    public SaludTotalClient saludTotalClient;


    //-----------------------------------------------------------------------
    //  METODO CONSTRUCTOR
    //-----------------------------------------------------------------------

    public SaludTotalWS() {

    }
    
    public ResultadosLCResponse registroResultadosLC(IPS ips) throws IOException {
        ResultadosLCResponse resultadosLCResponse = new ResultadosLCResponse();
        ModuleConfig config = new ModuleConfig();
        String urlConsumo = config.getDireccionWebServiceSaludTotal();
        saludTotalClient = new SaludTotalClient();
        resultadosLCResponse = saludTotalClient.registrarResultadoLC(ips,urlConsumo);
        return resultadosLCResponse;
    }

}
