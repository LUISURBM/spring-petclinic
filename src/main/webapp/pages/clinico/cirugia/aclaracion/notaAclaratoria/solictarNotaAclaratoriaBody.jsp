<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarNotaAclaratoriaForm">
    <a4j:region id="bodyRegionNotaAclaratoria">
        <a4j:status id="statusButton" for="bodyRegionNotaAclaratoria">
            <f:facet name="start">
                <t:div id="chargindConsultarNotaAclaratoria" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
      
        <h:panelGrid columns="1" id="tableConsultarNotaAclaratoria" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Consultar Registros Medicos " id="infoUbicationNotaAclaratoria"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableNotaAclaratoriaTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxNotaAclaratoria" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgNotaAclaratoria" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConNotaAclaratoria"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{solicitarNotaAclaratoriaBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConNotaAclaratoria" label="Consultar Registros Medicos"
                            rendered="#{!solicitarNotaAclaratoriaBean.renderBuscador}">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosNotaAclaratoria" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConNotaAclaratoria" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"
                                              rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"
                                              rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"
                                              rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{solicitarNotaAclaratoriaBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableNotaAclaratoriaTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnulaMedico" maxlength="15" style="width:80px" immediate="true"
                                             value="#{solicitarNotaAclaratoriaBean.numeroUsuario}"
                                             valueChangeListener="#{solicitarNotaAclaratoriaBean.setNumeroUsuario}"
                                             binding="#{solicitarNotaAclaratoriaBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuarioMedico" event="onchange" ignoreDupResponses="true"
                                                 action="#{solicitarNotaAclaratoriaBean.changeUsuario}"
                                                 reRender="tableNotaAclaratoriaTabs">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipoAnulaMedico" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                            </h:panelGrid>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioMedico">
                                <h:outputText value=" #{solicitarNotaAclaratoriaBean.nombreUsuario}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{solicitarNotaAclaratoriaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{solicitarNotaAclaratoriaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"
                                              rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"
                                          rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo"
                                              rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"
                                              styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"
                                              rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"/>
                            </h:panelGroup>
                            <h:outputText value="#{solicitarNotaAclaratoriaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{solicitarNotaAclaratoriaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoMedico" disabled="true"
                                                 rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"
                                                 value="#{solicitarNotaAclaratoriaBean.usuario.husesexo}">
                                    <f:selectItems value="#{solicitarNotaAclaratoriaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilNotaAclaratoria" disabled="true"
                                                 rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"
                                                 value="#{solicitarNotaAclaratoriaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{solicitarNotaAclaratoriaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsultaMedico" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesNotaAclaratoria" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonBuscarHistoriaMedico" id="msgNotaAclaratoria"
                                               errorClass="error" infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Consultar Registros Medicos"
                                               rendered="#{solicitarNotaAclaratoriaBean.renderInformacionUsuario}"
                                               action="#{solicitarNotaAclaratoriaBean.consultarNotaAclaratoria}"
                                               reRender="fieldSetListaDescripcionesAclaracion"
                                               styleClass="btn btn btn-success" id="idButtonBuscarHistoriaMedico"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Registros Medicos" id="fieldSetListaDescripcionesAclaracion"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultarListaDescripcionesAclaracion"
                                     rendered="#{empty solicitarNotaAclaratoriaBean.lstDescripcion}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="tableContentTabsConsultarlstDescripcionAclaracion"
                                     rendered="#{not empty solicitarNotaAclaratoriaBean.lstDescripcion}"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                             binding="#{solicitarNotaAclaratoriaBean.dtDescripcionAclaracion}"
                                             value="#{solicitarNotaAclaratoriaBean.lstDescripcion}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtDescripcionAclaracion">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Fecha Registro"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcodfecregistr}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Servicio"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcocservicio.csvccodigo} #{item.hcocservicio.csvcnombre}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Solicitar Autorizacion Nota Aclaratoria"/>
                                        </f:facet>
                                        <h:commandLink id="aclararDescripcion" immediate="true"
                                                       action="#{solicitarNotaAclaratoriaBean.aclaracionNotaAclaratoria}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientData.png"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_DetalleAclaracion" for="dtDescripcionAclaracion"
                                                    fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex"
                                                    styleClass="scroller" paginator="true" immediate="true"
                                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                                    renderFacetsIfSinglePage="false"
                                                    paginatorActiveColumnStyle="font-weight:bold;">
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
                        <h:commandLink action="#{solicitarNotaAclaratoriaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelRegistrosAutorizarDescripcionQuirurgica" label="Buscar Usuarios"
                            rendered="#{solicitarNotaAclaratoriaBean.renderBuscador}">
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
                        <h:panelGrid id="panelGridBusUsuaBotMedico" width="100%" columnClasses="columnaBotonesCentrados"
                                     dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotMedico">
                                <h:commandButton value="Aceptar Usuario" styleClass="btn btn btn-success"
                                                 action="#{solicitarNotaAclaratoriaBean.aceptarUsuario}">
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
                <a4j:outputPanel id="ajaxRegionMsgNotaAclaratoria" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgNotaAclaratoria" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>