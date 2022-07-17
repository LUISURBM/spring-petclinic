<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formListaUsuariosEspermograma">
  <a4j:region id="regionListaUsuariosEspermograma" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionListaUsuariosEspermograma">
      <f:facet name="start">
        <t:div id="chargingListaUsuariosEspermograma" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableinfoUbicationListaEspermogramaListaEspermograma" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Registro de Historias >> Todas las consultas " id="infoUbicationListaEspermograma"/>
    </h:panelGrid>
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="tableconsultarEspermogramaTabs" styleClass="tabContainer">
         <h:panelGroup>
           <a4j:outputPanel id="ajaxconsultarEspermograma" ajaxRendered="true">
               <t:htmlTag value="br"/>
                    <t:messages id="msgconsultarEspermograma" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabconsultarEspermograma"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" selectedIndex="#{listaEspermogramaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelconsultarEspermograma" label="Imprimir Espermograma"
                            rendered="#{!listaEspermogramaBean.renderBuscador}">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Datos Paciente" id="fieldDatosEspermogramaConsulta"
                                styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentTabsListaconsultarEspermograma"
                                     rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre " styleClass="labelTextOblig"
                                              rendered="#{listaEspermogramaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{listaEspermogramaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{listaEspermogramaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{listaEspermogramaBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableconsultarEspermogramaTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnula" maxlength="15" style="width:80px" immediate="true"
                                             value="#{listaEspermogramaBean.numeroUsuario}"
                                             valueChangeListener="#{listaEspermogramaBean.setNumeroUsuario}"
                                             binding="#{listaEspermogramaBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true"
                                                 action="#{listaEspermogramaBean.changeUsuario}"
                                                 reRender="tableContentTabsListaconsultarEspermograma,fieldSetConsultarEspermogramas">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnula" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelNombreUsuario">
                                <h:outputText value=" #{listaEspermogramaBean.nombreUsuario}" styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{listaEspermogramaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{listaEspermogramaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{listaEspermogramaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{listaEspermogramaBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo" rendered="#{listaEspermogramaBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{listaEspermogramaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{listaEspermogramaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{listaEspermogramaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexo" disabled="true"
                                                 rendered="#{listaEspermogramaBean.renderInformacionUsuario}"
                                                 value="#{listaEspermogramaBean.usuario.husesexo}">
                                    <f:selectItems value="#{listaEspermogramaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                                                 rendered="#{listaEspermogramaBean.renderInformacionUsuario}"
                                                 value="#{listaEspermogramaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{listaEspermogramaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsulta" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesEspermograma" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarUsuario" id="msgEspermogramaSolicitud"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Espermogramas"
                                               action="#{listaEspermogramaBean.consultarFoliosUsuario}"
                                               reRender="fieldSetConsultarEspermogramas"
                                               styleClass="btn btn btn-success" id="idButtonBuscarUsuario"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarEspermogramas"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarEspermogramas"
                                     rendered="#{empty listaEspermogramaBean.lstFolios}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsBucar" rendered="#{not empty listaEspermogramaBean.lstFolios}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{listaEspermogramaBean.dtFolios}"
                                             value="#{listaEspermogramaBean.lstFolios}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarFolios">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha"/>
                                        </f:facet>
                                        <h:outputText value="#{item.ccodfeccon}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Numero Usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.ccolusuario.huslnumero}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Servicio"/>
                                        </f:facet>
                                        <h:outputText value="#{item.ccocservic.csvcnombre}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Visualizar"/>
                                        </f:facet>
                                        <h:commandLink id="atender" action="#{listaEspermogramaBean.SeleccionarEspermograma}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_1" for="dtBucarFolios" fastStep="10"
                                                    pageCountVar="pageCount" pageIndexVar="pageIndex"
                                                    styleClass="scroller" paginator="true" immediate="true"
                                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                                    renderFacetsIfSinglePage="false"
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
                    <h:panelGrid>
                        <h:commandLink action="#{listaEspermogramaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelBuscadorUsuarios" label="Buscar Usuarios"
                            rendered="#{listaEspermogramaBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuarios" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuarios">
                            <f:facet name="start">
                                <t:div id="chargingBuscadorUsuarios" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBuscarUsuariosBotones" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBuscarUsuariosBotones1">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{listaEspermogramaBean.aceptarUsuario}"></h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>

    
    
    
    
    
    
    
    
    
    
  </a4j:region>
</a4j:form>