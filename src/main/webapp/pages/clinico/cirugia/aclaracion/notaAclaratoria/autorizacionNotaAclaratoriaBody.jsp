<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultarAutorizacionRegistrosForm">
    <a4j:region id="bodyRegionAutorizacionRegistros">
        <a4j:status id="statusButton" for="bodyRegionAutorizacionRegistros">
            <f:facet name="start">
                <t:div id="chargindConsultarAutorizacionRegistros" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
       
        <h:panelGrid columns="1" id="tableConsultarAutorizacionRegistros" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
                     
            <h:outputText value="Autorizar Registros Médicos " id="infoUbicationAutorizacionRegistros"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAutorizacionRegistrosTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAutorizacionRegistros" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAutorizacionRegistros" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConAutorizacionRegistros"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                <t:panelTab id="panelConAutorizacionRegistros" label="Autorizar Registros Médicos. ">
                 <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
                    <s:fieldset legend="Datos Paciente" id="fieldDatosAutorizacionRegistros" styleClass="fieldset">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentListaAutorizacionRegistros" rowClasses="labelText,labelTextInfo">
                                     
                            <h:outputText value=" Motivo Aclaración"  styleClass="labelTextOblig"/>
                            <h:outputText value=""/>
                            <h:inputTextarea id="textAreaMotivoAclaracion" required="true"
                                             value="#{solicitarNotaAclaratoriaBean.autoriza.hancmotivsolic}"
                                             style="width:650px;height:70px">
                                <f:validateLength maximum="4000"/>
                            </h:inputTextarea>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="textAreaMotivoAclaracion" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                        </h:panelGrid>
                    </s:fieldset>
                    
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesMotivoAclaracion"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Aceptar"
                                   styleClass="btn btn btn-success"
                                   action="#{solicitarNotaAclaratoriaBean.solicitarAclaracion}"/>
              </h:panelGroup>
            </h:panelGrid>
                    <h:panelGrid>
                        <h:commandLink action="#{solicitarNotaAclaratoriaBean.volverDescripcion}"
                                       immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgAutorizacionRegistros" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgAutorizacionRegistros" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>