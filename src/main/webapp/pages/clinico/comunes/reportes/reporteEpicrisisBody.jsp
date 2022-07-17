<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="reporteEpicrisisForm">
  <a4j:region id="bodyRegionDescQX">
    <a4j:status for="bodyRegionDescQX">
      <f:facet name="start">
        <t:div id="chargindDescQX" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
  </a4j:status>  
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridDescQXTab"
                 styleClass="tabContainer">
       
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableRegistrosQuirurgicosTabs" styleClass="tabContainer">
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConRegistrosQuirurgicos"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" 
                               selectedIndex="#{imprimirEpicrisisBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConRegistrosQuirurgicos" label="Consultar Epicrisis"
                            rendered="#{!imprimirEpicrisisBean.renderBuscador}">
                   
                    <s:fieldset legend="Datos Paciente" id="fieldDatosRegistrosQuirurgicos"
                                styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConRegistrosQuirurgicos"
                                     rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{imprimirEpicrisisBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableRegistrosQuirurgicosTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnulaMedico" maxlength="15" style="width:80px" immediate="true"
                                             value="#{imprimirEpicrisisBean.numeroUsuario}"
                                             valueChangeListener="#{imprimirEpicrisisBean.setNumeroUsuario}"
                                             binding="#{imprimirEpicrisisBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioMedico" event="onchange" ignoreDupResponses="true"
                                                 action="#{imprimirEpicrisisBean.changeUsuario}"
                                                 reRender="tableRegistrosQuirurgicosTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnulaMedico" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelNombreUsuarioMedico">
                                <h:outputText value=" #{imprimirEpicrisisBean.nombreUsuario}" styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{imprimirEpicrisisBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{imprimirEpicrisisBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo" rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{imprimirEpicrisisBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{imprimirEpicrisisBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoMedico" disabled="true"
                                                 rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"
                                                 value="#{imprimirEpicrisisBean.usuario.husesexo}">
                                    <f:selectItems value="#{imprimirEpicrisisBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilRegistrosQuirurgicos" disabled="true"
                                                 rendered="#{imprimirEpicrisisBean.renderInformacionUsuario}"
                                                 value="#{imprimirEpicrisisBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{imprimirEpicrisisBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsultaMedico" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesRegistrosQuirurgicos" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaMedico" id="msgRegistrosQuirurgicos"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar"
                                               action="#{imprimirEpicrisisBean.consultarRegistros}"
                                               reRender="fieldSetListaDescripciones"
                                               styleClass="btn btn btn-success" id="idButtonBuscarHistoriaMedico"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
        <s:fieldset legend="Imprimir Epicrisis" id="fieldSetListaDescripciones" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarListaDescripciones"
                           rendered="#{empty imprimirEpicrisisBean.lstEpicrisis}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabsConsultarlstDescripcion"
                           rendered="#{not empty imprimirEpicrisisBean.lstEpicrisis}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{imprimirEpicrisisBean.dtEpicrisis}"
                               value="#{imprimirEpicrisisBean.lstEpicrisis}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtEpicrisis">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha Registro"/>
                      </f:facet>
                      <h:outputText value="#{item.hepdfechaegres}"/>
                    </h:column>
                    <h:column>
                          <f:facet name="header">
                            <h:outputText value="Imprimir"/>
                          </f:facet>
                          <h:commandLink id="imprimirDescripcion" immediate="true"
                                         action="#{imprimirEpicrisisBean.generar}">
                            <t:graphicImage alt=""  border="0"
                                            url="/comun/imagenes/print_Spa.gif"/>
                          </h:commandLink>
                        </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_DetalleDescripcionQuirurgica" for="dtEpicrisis" fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif" border="0" alt=""/>
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
                        <h:commandLink action="#{imprimirEpicrisisBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                     
                    
                </t:panelTab>
                <t:panelTab id="panelRegistrosEpicrisis" label="Buscar Usuarios"
                            rendered="#{imprimirEpicrisisBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuMedico" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuMedico">
                            <f:facet name="start">
                                <t:div id="chargingBuscUsuMedico" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorUsuarios.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBusUsuaBotMedico" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotMedico">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{imprimirEpicrisisBean.aceptarUsuario}">
                                                 <a4j:support event="onclick" status="statusButton"/> 
                                        
                                </h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <f:subview id="generarDescEpc" rendered="#{imprimirEpicrisisBean.generoReporte}">
            <f:subview id="generarReportePamec" rendered="#{imprimirEpicrisisBean.generoReporte}">
                <f:verbatim>
                    <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                    </script>
                </f:verbatim>
            </f:subview>
        </f:subview>
        <h:panelGrid>
            <h:panelGroup id="msgModificarDescQX">
                <a4j:outputPanel id="ajaxRegionMessagesDescQX" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrorsDescQX" showSummary="true" errorClass="error" globalOnly="true" 
                    layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>        
      </h:panelGrid>
  </a4j:region> 
</a4j:form>