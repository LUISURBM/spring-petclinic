<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarDetalleCitologiaForm">
    <a4j:region id="bodyRegionDetalleCitologia">
        <a4j:status id="statusButton" for="bodyRegionDetalleCitologia">
            <f:facet name="start">
                <t:div id="chargindConsultarDetalleCitologia" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
       
        <h:panelGrid columns="1" id="tableConsultarDetalleCitologia" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:outputText value="Detalle Estado de la Citologia " id="infoUbicationDetalleCitologia"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableDetalleCitologiaTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxFoliosDetalleCitologia" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgFoliosDetalleCitologia" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConDetalleCitologia" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                                disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelConFoliosDetalleCitologia" label="Detalle Citologia">
                    <s:fieldset legend="Datos Paciente" id="fieldDatosDetalleCitologia" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaConDetalleCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Nombre" styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Tipo Documento" styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Numero Documento" styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:outputText id="idtipoDetalleCitologia"
                                          value="#{detalleConsultaCitologiaBean.usuario.huslnumero}"/>
                            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                                         id="panelNombreUsuarioidtipoDetalleCitologia">
                                <h:outputText value=" #{detalleConsultaCitologiaBean.usuario.huscprimernomb} #{detalleConsultaCitologiaBean.usuario.huscsegundnomb}"
                                              styleClass="buscador"/>
                            </h:panelGrid>
                            <h:outputText value="#{detalleConsultaCitologiaBean.usuario.husetipoiden}"/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.usuario.husanumeiden}"/>
                            <h:panelGroup>
                                <h:outputText value="Fecha de Nacimiento" styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:outputText value="Edad" styleClass="labelTextOblig"/>
                            <h:panelGroup>
                                <h:outputText value="Sexo" styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Estado Civil" styleClass="labelTextOblig"/>
                            </h:panelGroup>
                            <h:outputText value="#{detalleConsultaCitologiaBean.usuario.husdfechanacim}"/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.usuario.edad}"/>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioSexoDetalleCitologia" disabled="true"
                                                 value="#{detalleConsultaCitologiaBean.usuario.husesexo}">
                                    <f:selectItems value="#{detalleConsultaCitologiaBean.listSexos}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:selectOneMenu id="radioEstadoCivilDetalleCitologia" disabled="true"
                                                 value="#{detalleConsultaCitologiaBean.usuario.huseestadcivil}">
                                    <f:selectItems value="#{detalleConsultaCitologiaBean.listEstadoCivil}"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Datos Encabezado Citologia" id="fieldDatosEncabezadoCitologia"
                                styleClass="fieldset" rendered="#{detalleConsultaCitologiaBean.renderEncabezado}">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaEncabezadoCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Fecha registro encabezado"/>
                            <h:outputText value="Hora registro encabezado"/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.citologia.ccidfecreg}">
                                <f:convertDateTime pattern="dd/MM/yyyy"/>
                            </h:outputText>
                            <h:outputText value="#{detalleConsultaCitologiaBean.citologia.ccidfecreg}">
                                <f:convertDateTime pattern="hh:mm"/>
                            </h:outputText>
                            <h:outputText value="Usuario que registro"/>
                            <h:outputText value=""/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.citologia.ccicusureg}"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Datos Toma Citologia" id="fieldDatosTomaCitologia" styleClass="fieldset"
                                rendered="#{detalleConsultaCitologiaBean.renderToma}">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaTomaCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Fecha registro toma"/>
                            <h:outputText value="Hora registro toma"/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.toma.ctmdfecreg}">
                                <f:convertDateTime pattern="dd/MM/yyyy"/>
                            </h:outputText>
                            <h:outputText value="#{detalleConsultaCitologiaBean.toma.ctmdfecreg}">
                                <f:convertDateTime pattern="hh:mm"/>
                            </h:outputText>
                            <h:outputText value="Usuario que registro"/>
                            <h:outputText value=""/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.toma.ctmcusureg}"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Datos Lectuta Citologia" id="fieldDatosLecturaCitologia" styleClass="fieldset"
                                rendered="#{detalleConsultaCitologiaBean.renderLectura}">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaLecturaCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Fecha registro lectura "/>
                            <h:outputText value="Hora registro lectura "/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.lectura.clcdfecreg}">
                                <f:convertDateTime pattern="dd/MM/yyyy"/>
                            </h:outputText>
                            <h:outputText value="#{detalleConsultaCitologiaBean.lectura.clcdfecreg}">
                                <f:convertDateTime pattern="hh:mm"/>
                            </h:outputText>
                            <h:outputText value="Usuario que registro"/>
                            <h:outputText value=""/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.lectura.clccusureg}"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <s:fieldset legend="Datos Entrega Citologia" id="fieldDatosEntregaCitologia" styleClass="fieldset"
                                rendered="#{detalleConsultaCitologiaBean.renderEntrega}">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaEntregaCitologia" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Fecha Entrega Citologia "/>
                            <h:outputText value="Hora Entrega Citologia "/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.libro.hlcdfecregistr}">
                                <f:convertDateTime pattern="dd/MM/yyyy"/>
                            </h:outputText>
                            <h:outputText value="#{detalleConsultaCitologiaBean.libro.hlcdfecregistr}">
                                <f:convertDateTime pattern="hh:mm"/>
                            </h:outputText>
                            <h:outputText value="Usuario que Entrego"/>
                            <h:outputText value=""/>
                            <h:outputText value="#{detalleConsultaCitologiaBean.libro.hlccoperador}"/>
                            
                            <h:outputText value = ""/>
                            
                            <h:outputText value="Reclamo la usuaria"/>
                            <h:panelGroup>
                            <h:outputText value="Persona que reclamo" rendered="#{detalleConsultaCitologiaBean.renderReclama}"/>
                            </h:panelGroup>
                            <h:outputText value = "#{detalleConsultaCitologiaBean.reclamoUsuaria}"/>
                            <h:panelGroup>
                            <h:outputText value = "#{detalleConsultaCitologiaBean.libro.hlccnombrerecl}" rendered="#{detalleConsultaCitologiaBean.renderReclama}"/>
                            </h:panelGroup>
                            
                        </h:panelGrid>
                    </s:fieldset>
                    <h:panelGrid>
                        <h:commandLink action="#{detalleConsultaCitologiaBean.volverConsulta}" immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
  
    </a4j:region>
</a4j:form>