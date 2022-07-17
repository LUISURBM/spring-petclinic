<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="gestionSolicitarAnulacion">
    <a4j:region id="bodyRegionSolicitarAnulacion" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegionSolicitarAnulacion">
            <f:facet name="start">
                <t:div id="chargindSolicitarAnulacion" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableInfoSolicitarAnulacion" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="td_ubicador">
            <h:outputText value="Historias Clinicas >> Gestión >> Solicitar Anulación Consulta "
                          id="infoUbicationSolicitarAnulacion"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableSolicitarAnulacionTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxSolicitarAnulacion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgSolicitarAnulacion" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabSolicitarAnulacion" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               selectedIndex="#{solicitarAnulacionBean.selectedIndex}"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelSolicitarAnulacion" label="Solicitar Anulación Consulta"
                            rendered="#{!solicitarAnulacionBean.renderBuscador}">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Datos Paciente" id="fieldDatosAnulacionConsulta" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentTabsListaSolicitarAnulacion" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:outputText value="Fecha Consulta" styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{solicitarAnulacionBean.mostrarBuscadorUsuarios}"
                                                 immediate="true" reRender="tableSolicitarAnulacionTabs">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipoAnula" maxlength="15" style="width:80px" immediate="true"
                                             value="#{solicitarAnulacionBean.numeroUsuario}"
                                             valueChangeListener="#{solicitarAnulacionBean.setNumeroUsuario}"
                                             binding="#{solicitarAnulacionBean.itNumeroUsuario}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true"
                                                 action="#{solicitarAnulacionBean.changeUsuario}"
                                                 reRender="panelNombreUsuario">
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                             id="panelNombreUsuario">
                                    <h:outputText value=" #{solicitarAnulacionBean.nombreUsuario}"
                                                  styleClass="buscador"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="idtipoAnula" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            <t:inputCalendar id="calendarFechaAnular" title="Formato: dd/mm/yyyy"
                                             onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                             weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                             value="#{solicitarAnulacionBean.fechaConsulta}" popupTodayString="Hoy"
                                             popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                                             maxlength="11" size="11"
                                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                             renderPopupButtonAsImage="true" align="top"></t:inputCalendar>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="calendarFechaAnular" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsulta" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesAnulacion" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonAnulacion" id="msgAnulacionSolicitud" errorClass="error"
                                               infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Buscar" action="#{solicitarAnulacionBean.buscarConsultas}"
                                               reRender="panelSolicitarAnulacion" styleClass="btn btn btn-success"
                                               id="idButtonAnulacion"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Resultados Consulta" id="fieldSetConsultasCerradas"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridConsultasCerradas"
                                     rendered="#{empty solicitarAnulacionBean.lstConsultas}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0"
                                     rendered="#{not empty solicitarAnulacionBean.lstConsultas}" cellspacing="0"
                                     width="100%" id="tableContentTabsBucarConsultas" styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                                             binding="#{solicitarAnulacionBean.dtConsultas}"
                                             value="#{solicitarAnulacionBean.lstConsultas}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarConsultasCerradas">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Codigo"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcolnumero}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Número Usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcolusuario.huslnumero}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Servicio"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hcocservicio.csvccodigo} #{item.hcocservicio.csvcnombre}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Seleccione"/>
                                        </f:facet>
                                        <h:commandLink id="aceptarSolicitud"
                                                       action="#{solicitarAnulacionBean.aceptarSolicitud}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_BuscarCerradas" for="dtBucarConsultasCerradas"
                                                    fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex"
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
                                    <t:dataScroller id="scroll_BuscarCerradas2" for="dtBucarConsultasCerradas"
                                                    immediate="true" rowsCountVar="rowsCount"
                                                    displayedRowsCountVar="displayedRowsCountVar"
                                                    firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
                                                    pageCountVar="pageCount" pageIndexVar="pageIndex">
                                        <h:outputFormat value="#{msg.msg_datos_tablas}" styleClass="standard">
                                            <f:param value="#{rowsCount}"/>
                                            <f:param value="#{displayedRowsCountVar}"/>
                                            <f:param value="#{firstRowIndex}"/>
                                            <f:param value="#{lastRowIndex}"/>
                                            <f:param value="#{pageIndex}"/>
                                            <f:param value="#{pageCount}"/>
                                        </h:outputFormat>
                                    </t:dataScroller>
                                </h:panelGrid>
                            </t:buffer>
                            <h:outputText value="#{tableScroller}" escape="false"/>
                            <h:outputText value="#{table}" escape="false"/>
                            <h:outputText value="#{tableScroller}" escape="false"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Consulta Seleccionada" id="fieldSetConsultaSeleccionada"
                                rendered="#{solicitarAnulacionBean.renderConsultaSeleccionada}"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentAnulacionSeleccionada" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Consulta" styleClass="labelTextOblig"/>
                            <h:outputText value="Servicio" styleClass="labelTextOblig"/>
                            <h:outputText value="#{solicitarAnulacionBean.consultaSelect.id.hcolnumero}"/>
                            <h:outputText value="#{solicitarAnulacionBean.consultaSelect.hcocservicio.csvccodigo} #{solicitarAnulacionBean.consultaSelect.hcocservicio.csvcnombre}"/>
                            <h:outputText value="Observaciones Anulación Consulta" styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:inputTextarea id="itObservaAnulacionConsulta" style="width:500px"
                                             value="#{solicitarAnulacionBean.solicitud.hsacobsermedic}"/>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="itObservaAnulacionConsulta" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGrid>
                    </s:fieldset>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 id="panelBotonSolicitarAnulacion" columnClasses="panelGridBotones">
                        <h:commandButton value="Solicitar Anulación" styleClass="btn btn btn-success"
                                         rendered="#{solicitarAnulacionBean.renderConsultaSeleccionada}"
                                         onclick="if (!confirm(\'¿Realmente desea solicitar la Anulación de la Consulta\')) return false"
                                         action="#{solicitarAnulacionBean.aceptar}"/>
                    </h:panelGrid>
                    <h:panelGrid>
                        <h:commandLink action="#{solicitarAnulacionBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
                <t:panelTab id="panelBuscadorUsuarios" label="Buscar Usuarios"
                            rendered="#{solicitarAnulacionBean.renderBuscador}">
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
                                                 action="#{solicitarAnulacionBean.aceptarUsuario}"></h:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionSolicitarAnulacion" ajaxRendered="true">
                <t:messages id="msgInformationSolicitarAnulacion" showSummary="false" errorClass="error"
                            globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
        </h:panelGroup>
    </a4j:region>
</a4j:form>