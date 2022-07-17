<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formCambiarClinicaUsuarioForm">
    <a4j:region id="bodyRegioncambiarClinicaUsuario" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegioncambiarClinicaUsuario">
            <f:facet name="start">
                <t:div id="chargindDivcambiarClinicaUsuario" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableInfoUbicationCambiarClinicaUsuario" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="td_ubicador">
            <h:outputText value="Historias Clinicas >> Cambiar Clinica " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentTabsCambiarClinicaUsuario" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesCambiarClinicaUsuario" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrorsCambiarClinicaUsuario" showSummary="false" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion" showDetail="true"
                                tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabbedCambiarClinicaUsuario"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                <t:panelTab id="panelTabCambiarClinicaUsuario" label="Cambiar Clínica Usuario" rendered="true">
                    <t:htmlTag value="br"/>
                    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                                 rowClasses="labelText,labelTextInfo" style="border-color:#000000;">
                        <h:outputText value="Usuario" styleClass="labelTextOblig"/>
                        <h:outputText value="Cedula" styleClass="labelTextOblig"/>
                        <h:outputText value="Codigo" styleClass="labelTextOblig"/>
                        <h:outputText value="#{informacionUsuarioClinicaBean.usuarioSystem.curcnombre}"/>
                        <h:outputText value="#{informacionUsuarioClinicaBean.usuarioSystem.curacedula}"/>
                        <h:outputText value="#{informacionUsuarioClinicaBean.usuarioSystem.curnprofes}"/>
                        <h:outputText value="Clinica" styleClass="labelTextOblig"/>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:selectOneMenu id="mnuClinicasUsuario"  required="true"
                                value="#{informacionUsuarioClinicaBean.clinselec}">
                            <f:selectItems value="#{informacionUsuarioClinicaBean.lstClinicaUsuario}"/>
                        </h:selectOneMenu>
                         <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuClinicasUsuario" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                        <h:outputText value=""/>
                    </h:panelGrid>
                </t:panelTab>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesOrden"
                             columnClasses="panelGridBotones">
                    <h:panelGroup>
                        <h:commandButton value="Cambiar Clinica" styleClass="boton_fieldset"
                                         action="#{informacionUsuarioClinicaBean.cambiarClinica}"/>
                    </h:panelGroup>
                </h:panelGrid>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesClinicaUsuario" ajaxRendered="true">
                <t:messages id="msgInformationAndErrorsClinicaUsuario" showSummary="false" errorClass="error"
                            globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
        </h:panelGroup>
    </a4j:region>
</a4j:form>