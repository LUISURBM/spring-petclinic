<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarHistoriaAdministradorForm">
    <a4j:region id="bodyRegionHistoriaAdministrador">
        <a4j:status id="statusButton" for="bodyRegionHistoriaAdministrador">
            <f:facet name="start">
                <t:div id="chargindConsultarFolioAdministrador" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableConsultarFolioAdministrador" border="0" cellpadding="0" cellspacing="0"
                     width="100%" styleClass="td_ubicador">
            <h:outputText value="Consultar Asesoria " id="infoUbicationAdministrador"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableconsultarFoliosAdministracionTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxconsultarFoliosAdministracion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgconsultarFoliosAdministracion" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabconsultarFoliosAdministracion"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" selectedIndex="#{consultarAsesoriaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelconsultarFoliosAdministracion" label="Consultar Asesoria"
                            rendered="#{!consultarAsesoriaBean.renderBuscador}">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Datos Paciente" id="fieldDatosFoliosAdministradorConsulta"
                                styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentTabsListaconsultarFoliosAdministracion"
                                     rowClasses="labelText,labelTextInfo">
                            <h:outputText value="N�mero Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre " styleClass="labelTextOblig"
                                              rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{consultarAsesoriaBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableconsultarFoliosAdministracionTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnula" maxlength="15" style="width:80px" immediate="true"
                                             value="#{consultarAsesoriaBean.numeroUsuario}"
                                             valueChangeListener="#{consultarAsesoriaBean.setNumeroUsuario}"
                                             binding="#{consultarAsesoriaBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true"
                                                 action="#{consultarAsesoriaBean.changeUsuario}"
                                                 reRender="tableContentTabsListaconsultarFoliosAdministracion,fieldSetConsultarAsesoriaAdministrador">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnula" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelNombreUsuario">
                                <h:outputText value=" #{consultarAsesoriaBean.nombreUsuario}" styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{consultarAsesoriaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{consultarAsesoriaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo" rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{consultarAsesoriaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{consultarAsesoriaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexo" disabled="true"
                                                 rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"
                                                 value="#{consultarAsesoriaBean.usuario.husesexo}">
                                    <f:selectItems value="#{consultarAsesoriaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivil" disabled="true"
                                                 rendered="#{consultarAsesoriaBean.renderInformacionUsuario}"
                                                 value="#{consultarAsesoriaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{consultarAsesoriaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsulta" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesFoliosAdministrador" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoria" id="msgFoliosAdministradorSolicitud"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Asesoria"
                                               action="#{consultarAsesoriaBean.consultarAsesoriasUsuario}"
                                               reRender="fieldSetConsultarAsesoriaAdministrador"
                                               styleClass="btn btn btn-success" id="idButtonBuscarHistoria"/>
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                    <s:fieldset legend="Asesorias" id="fieldSetConsultarAsesoriaAdministrador"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarAsesoria"
                                     rendered="#{empty consultarAsesoriaBean.lstAsesoria}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentConsultarAsesoria" 
                                        rendered="#{not empty consultarAsesoriaBean.lstAsesoria}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{consultarAsesoriaBean.dtAsesoria}"
                                             value="#{consultarAsesoriaBean.lstAsesoria}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarAsesoria">
                                             
                                         
                                <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Clinica"/>
                                        </f:facet>
                                        <h:outputText value="#{item.havnclinic}"/>
                                    </h:column>
                                             
                                             
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Asesoria"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.havdfecase}"/>
                                    </h:column>
                                    
                                      <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.havlusuario}"/>
                                    </h:column>
                                     <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Visualizar"/>
                                        </f:facet>
                                        <h:commandLink id="atender" action="#{consultarAsesoriaBean.imprimirAsesoria}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/pdf.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_1" for="dtBucarAsesoria" fastStep="10"
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
                        <h:commandLink action="#{consultarAsesoriaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelBuscadorUsuarios" label="Buscar Usuarios"
                            rendered="#{consultarAsesoriaBean.renderBuscador}">
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
                                                 action="#{consultarAsesoriaBean.aceptarUsuario}"></h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgFolioAdministrador" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgFolioAdministrador" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
        <f:subview id="generarHistoriaClinicaAdministrador" rendered="#{consultarAsesoriaBean.generoHistoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>
    </a4j:region>
</a4j:form>