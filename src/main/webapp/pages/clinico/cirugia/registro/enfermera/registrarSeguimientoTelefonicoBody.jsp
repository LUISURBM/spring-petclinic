<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="registrarSeguimientoTelefonicoForm">
  <a4j:region id="bodyRegionRegistrarSeguimientoTelefonico">
    <a4j:status id="statusButton" for="bodyRegionRegistrarSeguimientoTelefonico">
      <f:facet name="start">
        <t:div id="chargindRegistrarSeguimientoTelefonico" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableContentTabsRegistrarSeguimientoTelefonico"
                 styleClass="tabContainerRegistrarSeguimientoTelefonico">
      <t:htmlTag value="br"/>
      
        <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuarioSeguimiento"
                  styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionInfoConsultaSeguimiento"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificaci�n"/>
          <h:outputText value=" Numero Identificaci�n"/>
          <h:outputText value="N�mero Usuario"/>
          <h:panelGroup>
            <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                             value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husetipoiden}">
              <f:selectItems value="#{consultarFoliosSeguimientoTelefonicoBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husanumeiden}"/>
          <h:outputText id="itNumeroUsuario"
                        value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huslnumero}"/>
          <t:htmlTag value="br"/>
        </h:panelGrid>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosNombre"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Primer Nombre"/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value="Primer Apellido"/>
          <h:outputText value="Segundo Apellido"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscprimernomb}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscsegundnomb}"/>
          <h:panelGroup>
            <h:outputText id="primerApellido"
                          value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscprimerapel}"/>
          </h:panelGroup>
          <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huscsegundapel}"/>
          <h:outputText value="Fecha Nacimiento"/>
          <h:outputText value="Edad"/>
          <h:outputText value="Sexo"/>
          <h:outputText value="Estado Civil"/>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husdfechanacim}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.edad}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioSexo" disabled="true"
                             value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husesexo}">
              <f:selectItems value="#{consultarFoliosSeguimientoTelefonicoBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                             value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.huseestadcivil}">
              <f:selectItems value="#{consultarFoliosSeguimientoTelefonicoBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
       <h:outputText value="Telefono Contacto" />
       <h:outputText value="Telefono Celular" />
       <h:outputText value="" />
       <h:outputText value="" />
       
       
        <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husctelefono}" />
       <h:outputText value="#{consultarFoliosSeguimientoTelefonicoBean.usuario.husccelular}" />
        <h:outputText value="" />
          
          
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonConsultarUsuario"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionCOnsultarHistoria"
                             ajaxRendered="true">
              <t:htmlTag value="br"/>
               <t:message for="idButtonBuscarHistoria"
                         id="msgInformationConsultarHistoria" errorClass="error"
                         infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar Cirugias"
                             action="#{consultarFoliosSeguimientoTelefonicoBean.consultarFoliosUsuario}"
                             reRender="fieldSetConsultarFolio"
                             styleClass="btn btn btn-success"
                             id="idButtonBuscarHistoria"/>
        </h:panelGrid>
      </s:fieldset>
      
        <s:fieldset legend="Seguimiento Telefonico" id="fieldSeguimientoTelefonico" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0"
                     rendered="#{not empty registrarSeguimientoTelefonicoBean.lstSeguimientoTelefonico}" cellspacing="0"
                     width="100%" id="tableSeguimientoTelefonico" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarSeguimientoTelefonicoBean.dtSeguimiento}"
                         value="#{registrarSeguimientoTelefonicoBean.lstSeguimientoTelefonico}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtSeguimientoTelefonico">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora"/>
                </f:facet>
                <h:outputText value="#{item.hstdfechaseg}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seguimiento Telefonico"/>
                </f:facet>
                <h:outputText value="#{item.hstcsegtelefo}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Operador"/>
                </f:facet>
                <h:outputText value="#{item.hstcoperador}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtSeguimientoTelefonico" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      <t:htmlTag value="br"/>
      <s:fieldset legend="VINISO" id="fieldRegistrarSeguimientoTelefonico"
                  styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelHoraSeguimiento"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup id="panelTextHoraActual">
              <h:outputText value="Contesta usuario?" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelMenuHoraActual">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuHoraActual" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}"  required="false" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.contesta}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setContesta}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpcionesComprobacion}"/>
                  <a4j:support id="supportmnuHoraActual" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeContesta}"
                               reRender="panelSeguimientoText,panelTextSeguimiento,panelTextSeguimiento,panelColoracionSelect,
                               panelColoracion,panelCalor,panelCalorSelect,panelEnrojecimiento,panelEnrojecimientoSelect,panelSangre,
                               panelSangreSelect,panelPus,panelPusSelect,panelOlor,panelOlorSelect,panelMolestia,panelMolestiaSelect,
                               panelObservacionesAdicionales,panelObservacionesAdicionalesSelect,panelSeguimientoFlebitis,panelCanalizacion,panelCanalizacionSelect,
                               panelPosoperatorio,panelPosoperatorioSelect,panelSignos,panelSignosSelect,panelAntibiotico,
                               panelAntibioticoSelect,panelMedicamento,panelMedicamentoSelect,panelHospital,panelHospitalSelect,fieldRegistrarPreguntasHerida,
                               panelAlgunMedicamento,panelAlgunMedicamentoTextSelect,panelTratamiento,panelTratamientoSelect,panelRecomendaciones,
                               panelRecomendacionesTextSelect,panelSeguimientoPosoperatorio,fieldRegistrarPreguntasPosoperatorio,fieldRegistrarPreguntasFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuHoraActual" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
          </h:panelGrid>
        </a4j:region>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegistrarSeguimientoTelefonico" rowClasses="labelText">
          <h:panelGroup id="panelSeguimientoText">
            <h:outputText value="Observaciones"  styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoTelefonicoBean.mostrarContesta}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup id="panelTextSeguimiento">
            <h:inputTextarea id="textSeguimientoTelefonico" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                             rendered="#{registrarSeguimientoTelefonicoBean.mostrarContesta}"
                             value="#{registrarSeguimientoTelefonicoBean.seguimientoTelefonico}"
                             style="width:500px;height:70px">
                    <f:validateLength maximum="50" />
            </h:inputTextarea>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textSeguimientoTelefonico" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
       <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Preguntas de la herida quirurg�ca"  id="fieldRegistrarPreguntasHerida" styleClass="fieldset" >
       <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="9"  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}">
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" Todos SI" immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeTodosSiPreguntasHeridaQuirurg�ca}" reRender="panelSeguimientoHerida"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeTodosNoPreguntasHeridaQuirurg�ca}" reRender="panelSeguimientoHerida"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeNingunoPreguntasHeridaQuirurg�ca}" reRender="panelSeguimientoHerida"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="No Aplica " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeNoAplicaPreguntasHeridaQuirurg�ca}" reRender="panelSeguimientoHerida"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelSeguimientoHerida"
                       rowClasses="labelText,labelTextInfo" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}">
            <h:panelGroup id="panelColoracion">
              <h:outputText value="En alg�n momento de la recuperaci�n ha presentado coloraci�n rojiza?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderColoracion}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderColoracion}" />
            <h:outputText  value="" />
            <h:panelGroup id="panelColoracionSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuSelectColora" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.corolaSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setSelectCorola}"
                                  styleClass="labelRadio">
                       <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportMnuSelectColora" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuSelectColora" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelDolor">
              <h:outputText value=" Dolor intenso al tocarse que no cede a los medicamentos prescritos por el M�dico?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderDolor}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderDolor}"/>
            <h:outputText/>
            <h:panelGroup id="panelDolorSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelDolorSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.dolorSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setSelectDolor}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                <a4j:support id="supportMnupanelDolorSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelDolorSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelCalor">
              <h:outputText value="Calor en el sitio de la herida Quir�rgica?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderCalor}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderCalor}" />
            <h:outputText/>
            <h:panelGroup id="panelCalorSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelCalorSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.calorSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setCalorSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelCalorSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelCalorSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelEnrojecimiento">
              <h:outputText value="Enrojecimiento en el sitio de la herida Quir�rgica?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderEnrojecimiento}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderEnrojecimiento}" />
            <h:outputText/>
            <h:panelGroup id="panelEnrojecimientoSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelEnrojecimientoSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.enrojecimientoSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setEnrojecimientoSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                    <a4j:support id="supportMnupanelEnrojecimientoSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelEnrojecimientoSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelSangre">
              <h:outputText value="Salida de sangre en el  sitio de la herida Quir�rgica?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderSangre}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderSangre}" />
            <h:outputText/>
            <h:panelGroup id="panelSangreSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelSangreSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.sangreSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setSangreSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelSangreSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelSangreSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelPus">
              <h:outputText value="Salida de pus o secreci�n en el  sitio de la herida Quir�rgica?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderPus}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderPus}" />
            <h:outputText/>
            <h:panelGroup id="panelPusSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelPusSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.pusSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setPusSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportMnupanelPusSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelPusSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelLiquido">
              <h:outputText value="Salida de l�quido en el sitio de la herida Quir�rgica?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderLiquido}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderLiquido}" />
            <h:outputText/>
            <h:panelGroup id="panelLiquidoSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelLiquidoSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.liquidoSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setLiquidoSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelLiquidoSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelLiquidoSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelOlor">
              <h:outputText value="Mal olor procedente de la herida?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderOlor}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderOlor}" />
            <h:outputText/>
            <h:panelGroup id="panelOlorSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelOlorSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.olorSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setOlorSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelOlorSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelOlorSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelMolestia">
              <h:outputText value="Ha presentado otra molestia?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelCualMolestia">
              <h:outputText value="Cual?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarCualMolestia}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderMolestia}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderMolestia}" />
            <h:panelGroup id="panelMolestiaSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelMolestiaSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.cualMolestia}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setCualMolestia}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelMolestiaSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeCualMolestia}"
                               reRender="panelCualMolestia,panelInputCualMolestia,panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelMolestiaSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCualMolestia">
              <h:inputTextarea id="textInputCualMolestia" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarCualMolestia}" value="#{registrarSeguimientoTelefonicoBean.cual}"
                               style="width:500px;height:70px">
                        <f:validateLength maximum="140" />
              </h:inputTextarea>
            </h:panelGroup>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputCualMolestia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            <h:panelGroup id="panelObservacionesAdicionales">
              <h:outputText value="Observaciones adicionales" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelCualAdicionales">
              <h:outputText value="Observaciones" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarAdicional}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderObservacionesAdicionales}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderObservacionesAdicionales}" />
            <h:panelGroup id="panelObservacionesAdicionalesSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelObservacionesAdicionalesSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.observacionAdicional}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setObservacionAdicional}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelObservacionesAdicionalesSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeObservaciones}"
                               reRender="panelCualAdicionales,panelInputCual,panelSeguimientoHerida">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelObservacionesAdicionalesSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCual">
              <h:inputTextarea id="textInputCual" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarAdicional}" value="#{registrarSeguimientoTelefonicoBean.observacion}"
                               style="width:500px;height:70px">
                                <f:validateLength maximum="140"/>
              </h:inputTextarea>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputCual" styleClass="errorMessage"/>
              </a4j:outputPanel>
          </h:panelGrid>
       
      </s:fieldset>
       </a4j:region>
      <s:fieldset legend="Preguntas espec�ficas para fleb�tis" id="fieldRegistrarPreguntasFlebitis"
                  styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="9" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}">
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeTodosSiPreguntasFlebitis}" reRender="panelSeguimientoFlebitis"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeTodosNoPreguntasFlebitis}" reRender="panelSeguimientoFlebitis"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeNingunoPreguntasFlebitis}" reRender="panelSeguimientoFlebitis"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="No Aplica " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeNoAplicaPreguntasFlebitis}" reRender="panelSeguimientoFlebitis"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelSeguimientoFlebitis"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup id="panelCanalizacion">
              <h:outputText value="Present� enrojecimiento en el sitio de la canalizaci�n?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderCanalizacion}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderCanalizacion}" />
            <h:outputText/>
            <h:panelGroup id="panelCanalizacionSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelCanalizacion" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.canalizacionSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setCanalizacionSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportMnupanelCanalizacion" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelCanalizacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelDolorCanali">
              <h:outputText value="Present� dolor, sensibilidad en el sitio de la canalizaci�n?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderDolorCanali}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderDolorCanali}" />
            <h:outputText/>
            <h:panelGroup id="panelDolorCanaliSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelDolorCanaliSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.dolorCanaliSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setDolorCanaliSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelDolorCanaliSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelDolorCanaliSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelRecuperacion">
              <h:outputText value=" En alg�n momento de su recuperaci�n usted ha presentado coloraci�n rojiza en el sitio de la canalizaci�n?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderRecuperacion}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderRecuperacion}" />
            <h:outputText/>
            <h:panelGroup id="panelRecuperacionSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelRecuperacionSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.recuperacionSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setRecuperacionSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelRecuperacionSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelRecuperacionSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelPusVena">
              <h:outputText value="Le ha salido pus por el sitio donde le cogieron la vena?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderPusVena}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderPusVena}" />
            <h:outputText/>
            <h:panelGroup id="panelPusVenaSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelPusVenaSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.pusVenaSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setPusVenaSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                   <a4j:support id="supportMnupanelPusVenaSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRenderOpciones}"
                               reRender="panelSeguimientoFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelPusVenaSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelMolestiaFlebitis">
              <h:outputText value="Ha presentado otra molestia?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelCualMolestiaFlebitis">
              <h:outputText value="Cual?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarCualMolestiaFlebitis}"/>
            </h:panelGroup>
             <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderMolestiaFlebitis}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderMolestiaFlebitis}" />
            <h:panelGroup id="panelMolestiaFlebitisSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelMolestiaFlebitisSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.molestiaFlebitis}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setCualMolestiaFlebitis}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelMolestiaFlebitisSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeCualMolestiaFlebitis}"
                               reRender="panelCualMolestiaFlebitis,panelInputCualMolestiaFlebitis,panelSeguimientoFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelMolestiaFlebitisSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCualMolestiaFlebitis">
              <h:inputTextarea id="textInputCualMolestiaFlebitis" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarCualMolestiaFlebitis}" value="#{registrarSeguimientoTelefonicoBean.cualMolestiaFlebitis}"
                               style="width:500px;height:70px">
                     <f:validateLength maximum="140"/>
              </h:inputTextarea>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputCualMolestiaFlebitis" styleClass="errorMessage"/>
              </a4j:outputPanel>
            <h:panelGroup id="panelObservacionesAdicionalesFlebitis">
              <h:outputText value="Observaciones adicionales" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelObservacioAdicionalesFlebitis">
              <h:outputText value="Observaciones" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarAdicionalFlebitis}"/>
            </h:panelGroup>
             <h:outputText value="Por favor direccione a la paciente a la cl�nica de Profamilia m�s cercana e informe a la enfermera del servicio." style="color:blue;" rendered="#{registrarSeguimientoTelefonicoBean.renderObservacioAdicionalesFlebitis}" /> 
            <h:outputText value="" rendered="#{!registrarSeguimientoTelefonicoBean.renderObservacioAdicionalesFlebitis}" />
            <h:panelGroup id="panelObservacionesAdicionalesFlebitisSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelObservacionesAdicionalesFlebitis" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.observacionAdicionalFlebitis}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setObservacionAdicionalFlebitis}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportpanelObservacionesAdicionalesFlebitis" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeObservacionesFlebitis}"
                               reRender="panelObservacioAdicionalesFlebitis,panelInputObservacionesFlebitis,panelSeguimientoFlebitis">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelObservacionesAdicionalesFlebitis" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputObservacionesFlebitis">
              <h:inputTextarea id="textInputObservacionesFl" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarAdicionalFlebitis}" value="#{registrarSeguimientoTelefonicoBean.observacionFlebitis}"
                               style="width:500px;height:70px">
                        <f:validateLength maximum="140"/>
              </h:inputTextarea>
            </h:panelGroup>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputObservacionesFl" styleClass="errorMessage"/>
              </a4j:outputPanel>
          </h:panelGrid>
        </a4j:region>
      </s:fieldset>
      <s:fieldset legend="Control Pos operatorio" id="fieldRegistrarPreguntasPosoperatorio" styleClass="fieldset">
       <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="9"  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}">
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeTodosSiPreguntasControlPosOperatorio}" reRender="panelSeguimientoPosoperatorio"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeTodosNoPreguntasControlPosOperatorio}" reRender="panelSeguimientoPosoperatorio"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeNingunoPreguntasControlPosOperatorio}" reRender="panelSeguimientoPosoperatorio"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" style="font-size:8.0pt; font-weight:bold;" value="No Aplica " immediate="true"
                               action="#{registrarSeguimientoTelefonicoBean.changeNoAplicaPreguntasControlPosOperatorio}" reRender="panelSeguimientoPosoperatorio"/>
              <h:outputText rendered="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
          
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelSeguimientoPosoperatorio" rowClasses="labelText,labelTextInfo">
            <h:panelGroup id="panelPosoperatorio">
              <h:outputText value="Asisti� al control Pos operatorio?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelPosoperatorioText">
              <h:outputText value="Porque no?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarposoperatorioSelect}"/>
            </h:panelGroup>
            <h:outputText value="" /> 
            <h:panelGroup id="panelPosoperatorioSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelPosoperatorioSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.posoperatorioSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setPosoperatorioSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportpanelPosoperatorioSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangePosoperatorioSelect}"
                               reRender="panelPosoperatorioText,panelInputPorqueno">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelPosoperatorioSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputPorqueno">
              <h:inputTextarea id="textInputPorqueno" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarposoperatorioSelect}" value="#{registrarSeguimientoTelefonicoBean.posoperatorioPorqueno}"
                               style="width:500px;height:70px"/>
            </h:panelGroup>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputPorqueno" styleClass="errorMessage"/>
              </a4j:outputPanel>
            <h:panelGroup id="panelSignos">
              <h:outputText value="Los signos presentados anteriormente fue antes del control?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="" /> 
            <h:outputText/>
            <h:panelGroup id="panelSignosSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelSignosSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.signosSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setSignosSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelSignosSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            <h:panelGroup id="panelAntibiotico">
              <h:outputText value="Se le orden� antibi�tico? (preguntar si recuerda que medicamento fue ordenado)"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelAntibioticoText">
              <h:outputText value="Cual?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarAntibioticoSelect}"/>
            </h:panelGroup>
            <h:outputText value="" /> 
            <h:panelGroup id="panelAntibioticoSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelAntibioticoSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.antibioticoSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setAntibioticoSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelAntibioticoSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeAntibioticoSelect}"
                               reRender="panelAntibioticoText,panelInputCualAntibiotico">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelAntibioticoSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCualAntibiotico">
              <h:inputTextarea id="textInputCualAntibiotico" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarAntibioticoSelect}" value="#{registrarSeguimientoTelefonicoBean.cualAntibioticoSelect}"
                               style="width:500px;height:70px">
                      <f:validateLength maximum="120"/>
              </h:inputTextarea>          
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputCualAntibiotico" styleClass="errorMessage"/>
              </a4j:outputPanel>
            <h:panelGroup id="panelMedicamento">
              <h:outputText value="Tom� el medicamento como el m�dico se lo orden�?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:outputText value="" /> 
            <h:outputText/>
            <h:panelGroup id="panelMedicamentoSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelMedicamentoSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.medicamentoSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setMedicamentoSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelMedicamentoSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            
            <h:panelGroup id="panelHospital">
              <h:outputText value="Acudi� a un hospital o cl�nica posterior al control en Profamilia?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelHopitaliText">
              <h:outputText value="Cual?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarHospitalSelect}"/>
            </h:panelGroup>
            <h:outputText value="" /> 
            <h:panelGroup id="panelHospitalSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelHospitalSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.hospitalSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setHospitalSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelHospitalSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeHospitalSelect}"
                               reRender="panelHopitaliText,panelInputCualHospital">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelHospitalSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCualHospital">
              <h:inputTextarea id="textInputCualHospital" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarHospitalSelect}" value="#{registrarSeguimientoTelefonicoBean.cualHospital}"
                               style="width:500px;height:70px"/>
            </h:panelGroup>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputCualHospital" styleClass="errorMessage"/>
              </a4j:outputPanel>
            
            
            
            
            
             <h:panelGroup id="panelAlgunMedicamento">
              <h:outputText value="Le dieron alg�n medicamento?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelAlgunMedicamentoText">
              <h:outputText value="Cual?" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarAlgunMedicamentoTextSelect}"/>
            </h:panelGroup>
            <h:outputText value="" /> 
            <h:panelGroup id="panelAlgunMedicamentoTextSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelAlgunMedicamentoTextSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.algunMedicamentoTextSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setAlgunMedicamentoTextSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelAlgunMedicamentoTextSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeAlgunMedicamentoTextSelect}"
                               reRender="panelAlgunMedicamentoText,panelInputCualMedicamento">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelAlgunMedicamentoTextSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCualMedicamento">
              <h:inputTextarea id="textInputCualMedicamento" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarAlgunMedicamentoTextSelect}" value="#{registrarSeguimientoTelefonicoBean.cualAlgunMedicamento}"
                               style="width:500px;height:70px">
                       <f:validateLength maximum="30"/>
              </h:inputTextarea>                          
            </h:panelGroup>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputCualMedicamento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            
            <h:panelGroup id="panelTratamiento">
              <h:outputText value="Como se siente despu�s del tratamiento?"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
             <h:outputText value="" /> 
            <h:outputText/>
            <h:panelGroup id="panelTratamientoSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelTratamientoSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.tratamientoSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setTratamientoSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstTratamiento}"/>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelTratamientoSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText/>
            
            
            
            
            
              <h:panelGroup id="panelRecomendaciones">
              <h:outputText value="Recomendaciones Emitidas"
                            styleClass="labelTextOblig" rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"/>
            </h:panelGroup>
            <h:panelGroup id="panelRecomendacionesText">
              <h:outputText value="Recomendaciones" styleClass="labelTextOblig"
                            rendered="#{registrarSeguimientoTelefonicoBean.mostrarRecomendaciones}"/>
            </h:panelGroup>
             <h:outputText value="" /> 
            <h:panelGroup id="panelRecomendacionesTextSelect">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnupanelRecomendacionesTextSelect" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true" immediate="true"
                                  value="#{registrarSeguimientoTelefonicoBean.recomendacionSelect}"
                                  rendered="#{registrarSeguimientoTelefonicoBean.mostrarItem}"
                                  valueChangeListener="#{registrarSeguimientoTelefonicoBean.setRecomendacioneSelect}"
                                  styleClass="labelRadio">
                  <f:selectItems value="#{registrarSeguimientoTelefonicoBean.lstOpciones}"/>
                  <a4j:support id="supportmnupanelRecomendacionesTextSelect" event="onclick"
                               action="#{registrarSeguimientoTelefonicoBean.ChangeRecomendaciones}"
                               reRender="panelRecomendacionesText,panelRecomendaciones2">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnupanelRecomendacionesTextSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelRecomendaciones2">
              <h:inputTextarea id="textInputRecomendaciones" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" required="true"
                               rendered="#{registrarSeguimientoTelefonicoBean.mostrarRecomendaciones}" value="#{registrarSeguimientoTelefonicoBean.recomendaciones}"
                               style="width:500px;height:70px">
                      <f:validateLength maximum="750"/>
              </h:inputTextarea>          
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textInputRecomendaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
          </h:panelGrid>
        </a4j:region>
      </s:fieldset>
    </h:panelGrid>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                  <h:commandButton value="Guardar" disabled="#{registrarSeguimientoTelefonicoBean.botonImprimir}" styleClass="btn btn btn-success" 
                         onclick="if (!confirm(\'�Realmente desea Crear el Seguimiento Telefonico\')) return false"
                         action="#{registrarSeguimientoTelefonicoBean.aceptar}">
                        <a4j:support event="onclick" reRender="panelGridBotones" status="statusButton"/>
                </h:commandButton>
                 <h:commandButton value="Imprimir"  immediate="true" disabled="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" styleClass="btn btn btn-primary"
                        action="#{registrarSeguimientoTelefonicoBean.generarArchivoPdf}">
                  <a4j:support event="onclick" reRender="panelGridBotones" status="statusButton"/>
                </h:commandButton>
                <h:commandButton value="Cerrar"  immediate="true" disabled="#{!registrarSeguimientoTelefonicoBean.botonImprimir}" styleClass="btn btn btn-danger"
                        action="#{registrarSeguimientoTelefonicoBean.cerrarSeguimiento}">
                  <a4j:support event="onclick" reRender="panelGridBotones" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
   
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
     <f:subview id="generarViniso" rendered="#{registrarSeguimientoTelefonicoBean.generoReporte}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
  </a4j:region>
</a4j:form>