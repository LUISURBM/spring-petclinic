<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarEpicrisisForm">
    <a4j:region id="bodyRegionEpicrisis">
        <a4j:status id="statusButton" for="bodyRegionEpicrisis">
            <f:facet name="start">
                <t:div id="chargindConsultarEpicrisis" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        
        <h:panelGrid columns="1" id="tableConsultarEpicrisis" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Consultar Epicrisis " id="infoUbicationEpicrisis"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableEpicrisisTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxEpicrisis" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgEpicrisis" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConEpicrisis"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{solicitarAutorizacionEpicrisisBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConEpicrisis" label="Solicitar Aclaración Epicrisis"
                            rendered="#{!solicitarAutorizacionEpicrisisBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosEpicrisis" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConEpicrisis" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{solicitarAutorizacionEpicrisisBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableEpicrisisTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnulaMedico" maxlength="15" style="width:80px" immediate="true"
                                             value="#{solicitarAutorizacionEpicrisisBean.numeroUsuario}"
                                             valueChangeListener="#{solicitarAutorizacionEpicrisisBean.setNumeroUsuario}"
                                             binding="#{solicitarAutorizacionEpicrisisBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioMedico" event="onchange" ignoreDupResponses="true"
                                                 action="#{solicitarAutorizacionEpicrisisBean.changeUsuario}"
                                                 reRender="tableEpicrisisTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnulaMedico" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioMedico">
                                <h:outputText value=" #{solicitarAutorizacionEpicrisisBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{solicitarAutorizacionEpicrisisBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{solicitarAutorizacionEpicrisisBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{solicitarAutorizacionEpicrisisBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{solicitarAutorizacionEpicrisisBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoMedico" disabled="true"
                                                 rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"
                                                 value="#{solicitarAutorizacionEpicrisisBean.usuario.husesexo}">
                                    <f:selectItems value="#{solicitarAutorizacionEpicrisisBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilEpicrisis" disabled="true"
                                                 rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"
                                                 value="#{solicitarAutorizacionEpicrisisBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{solicitarAutorizacionEpicrisisBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonSolicitarEpicrisis" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesEpicrisis" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonSolicitarEpicrisis" id="msgEpicrisis"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Epicrisis"
                                               rendered="#{solicitarAutorizacionEpicrisisBean.renderInformacionUsuario}"
                                               action="#{solicitarAutorizacionEpicrisisBean.consultarEpicrisis}"
                                               reRender="fieldSetListaSolicitarEpicrisis"
                                               styleClass="btn btn btn-success" id="idButtonSolicitarEpicrisis"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
            <s:fieldset legend="Autorización Epicrisis" id="fieldSetListaSolicitarEpicrisis" 
                    styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarListaEpicrisis"
                           rendered="#{empty solicitarAutorizacionEpicrisisBean.lstEpicrisis}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabslstSolicitarEpicrisis"
                           rendered="#{not empty solicitarAutorizacionEpicrisisBean.lstEpicrisis}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{solicitarAutorizacionEpicrisisBean.dtEpicrisis}"
                               value="#{solicitarAutorizacionEpicrisisBean.lstEpicrisis}" rows="10"
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
                        <h:outputText value="Cirugia(s)"/>
                      </f:facet>
                      <h:outputText value="#{item.hepcserviegres}"/>
                    </h:column>
                    
                      <h:column>
                       <f:facet name="header">
                         <h:outputText value="Epicrisis"/>
                            </f:facet>
                             <h:commandLink id="aclararEpicrisis" immediate="true"
                              action="#{solicitarAutorizacionEpicrisisBean.aclaracionEpicrisis}">
                              <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientData.png"/>
                          </h:commandLink>
                       </h:column>
                    
                   
                
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_SolicitarEpicrisis" for="dtEpicrisis" fastStep="10" pageCountVar="pageCount"
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
                        <h:commandLink action="#{solicitarAutorizacionEpicrisisBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelRegistrosAutorizarEpicrisis" label="Buscar Usuarios"
                            rendered="#{solicitarAutorizacionEpicrisisBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsuarioSolEpicrisis" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsuarioSolEpicrisis">
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
                        <h:panelGrid id="panelGridBusUsuaBotMedico" width="100%" columnClasses="columnaBotonesCentrados"
                                     dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotMedico">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{solicitarAutorizacionEpicrisisBean.aceptarUsuario}">
                                    <a4j:support event="onclick" status="statusButton"/>
                                </h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgEpicrisis" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgEpicrisis" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>