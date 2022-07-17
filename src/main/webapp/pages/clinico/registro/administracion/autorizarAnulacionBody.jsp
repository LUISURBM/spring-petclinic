<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="gestionAutorizarAnulacion">
    <a4j:region id="bodyRegionAutorizarAnulacion" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegionAutorizarAnulacion">
            <f:facet name="start">
                <t:div id="chargindAutorizarAnulacion" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableInfoAutorizarAnulacion" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="td_ubicador">
            <h:outputText value="Historias Clinicas >> Gestión >> Autorizar Anulación Consulta "
                          id="infoUbicationAutorizarAnulacion"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAutorizarAnulacionTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAutorizarAnulacion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAutorizarAnulacion" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabAutorizarAnulacion" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelAutorizarAnulacion" label="Autorizar Anulación Consulta">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Solicitudes Anulación Consulta" id="fieldSetConsultarSolicitud"
                                styleClass="fieldset_dataTable">
                        <h:panelGrid columns="1" id="panelGridSolicitudVaciaAnulacionConsultas"
                                     rendered="#{empty autorizarAnulacionBean.lstSolicitudes}">
                            <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0"
                                     rendered="#{not empty autorizarAnulacionBean.lstSolicitudes}" cellspacing="0"
                                     width="100%" id="tableContentTabsSolicitudAnulacionConsultas"
                                     styleClass="tabContainer">
                            <t:buffer into="#{table}">
                                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                                             binding="#{autorizarAnulacionBean.dtSolicitudAnulacion}"
                                             value="#{autorizarAnulacionBean.lstSolicitudes}" rows="10"
                                             styleClass="standard_table"
                                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                             id="dtBucarSolicitudesAnulacion">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Número"/>
                                        </f:facet>
                                        <h:outputText value="#{item.id.hsalconsulta}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Usuario"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hsalusuario.huscprimernomb} #{item.hsalusuario.huscsegundnomb} #{item.hsalusuario.huscprimerapel} #{item.hsalusuario.huscsegundapel}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Observaciones Médico"/>
                                        </f:facet>
                                        <t:div style="overflow:auto;width:400px;height:30px;">
                                            <h:outputText value="#{item.hsacobsermedic}"/>
                                        </t:div>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Solicita"/>
                                        </f:facet>
                                        <h:outputText value="#{item.hsacoperaregis}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Seleccione"/>
                                        </f:facet>
                                        <h:commandLink id="aceptarSolicitud"
                                                       action="#{autorizarAnulacionBean.seleccionarSolicitud}">
                                            <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
                            </t:buffer>
                            <t:buffer into="#{tableScroller}">
                                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                    <t:dataScroller id="scroll_BuscarCerradas" for="dtBucarSolicitudesAnulacion"
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
                                    <t:dataScroller id="scroll_BuscarCerradas2" for="dtBucarSolicitudesAnulacion"
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
                    <s:fieldset legend="Solicitud Seleccionada" id="fieldSetSolicitudAnulacionSeleccionada"
                                rendered="#{autorizarAnulacionBean.renderAnulacion}" styleClass="fieldset_dataTable">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentAnulacionSeleccionada" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Nombre Usuario" styleClass="labelTextOblig"/>
                            <h:outputText value="Tipo Documento" styleClass="labelTextOblig"/>
                            <h:outputText value="Número Documento" styleClass="labelTextOblig"/>
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsalusuario.huscprimernomb} #{autorizarAnulacionBean.solicitudSelect.hsalusuario.huscsegundnomb} #{autorizarAnulacionBean.solicitudSelect.hsalusuario.huscprimerapel} #{autorizarAnulacionBean.solicitudSelect.hsalusuario.huscsegundapel}"/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsalusuario.husetipoiden}"/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsalusuario.husanumeiden}"/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsalusuario.huslnumero}"/>
                            <h:outputText value="Solicita" styleClass="labelTextOblig"/>
                            <h:outputText value="Fecha Solicitud" styleClass="labelTextOblig"/>
                            <h:outputText value="Hora Solicitud" styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsacoperaregis}"/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsadfecharegis}">
                                <f:convertDateTime pattern="dd/MM/yyyy"/>
                            </h:outputText>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsadfecharegis}">
                                <f:convertDateTime pattern="hh:mm"/>
                            </h:outputText>
                            <h:outputText value=""/>
                        </h:panelGrid>
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentAnulacionSeleccionadaObservaciones"
                                     rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Observaciones Médico" styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:outputText value="#{autorizarAnulacionBean.solicitudSelect.hsacobsermedic}"/>
                            <h:outputText value=""/>
                            <h:outputText value="Acepta Anulación" styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:selectOneRadio id="mnuAceptaAnulacion" required="true"
                                              value="#{autorizarAnulacionBean.solicitudSelect.hsacacepta}">
                                <f:selectItems value="#{autorizarAnulacionBean.lstOpciones}"/>
                            </h:selectOneRadio>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuAceptaAnulacion" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            <h:outputText value="Observaciones Administrador" styleClass="labelTextOblig"/>
                            <h:outputText/>
                            <h:inputTextarea id="itObservacionAdministrador" style="width:400px" required="true"
                                             value="#{autorizarAnulacionBean.solicitudSelect.hsacobseradmin}">
                                <f:validateLength maximum="1000"/>
                            </h:inputTextarea>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="itObservacionAdministrador" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGrid>
                    </s:fieldset>
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 rendered="#{autorizarAnulacionBean.renderAnulacion}" id="panelBotonAutorizarAnulacion"
                                 columnClasses="panelGridBotones">
                        <h:commandButton value="Autorizar Anulación" styleClass="boton_fieldset"
                                         onclick="if (!confirm(\'¿Realmente desea Autorizar la Anulación de la Consulta\')) return false"
                                         action="#{autorizarAnulacionBean.actualizarSolicitud}"/>
                    </h:panelGrid>
                    <h:panelGrid>
                        <h:commandLink action="#{autorizarAnulacionBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionAutorizarAnulacion" ajaxRendered="true">
                <t:messages id="msgInformationAutorizarAnulacion" showSummary="false" errorClass="error"
                            globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
        </h:panelGroup>
    </a4j:region>
</a4j:form>