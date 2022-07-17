<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="gestionAsignarSalaMedico">
    <a4j:region id="bodyRegionAsignarSalaMedico" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegionAsignarSalaMedico">
            <f:facet name="start">
                <t:div id="chargindAsignarSalaMedico" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableInfoAsignarSalaMedico" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="td_ubicador">
            <h:outputText value="Historias Clinicas >> Gestión >> Asignar Sala Médico "
                          id="infoUbicationAsignarSalaMedico"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAsignarSalaMedicoTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAsignarSalaMedico" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAsignarSalaMedico" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
             <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabbedAsignarSalaMedico" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelTabAsignarSalaMedico" label="Asignar Sala a Médico"
                            rendered="true">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Criterios de Busqueda" id="fieldSetAsignarSalaMedico" styleClass="fieldset">
                        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="2" width="100%"
                                     id="panelRegionAsignarSalaMedico" columnClasses="labelText,labelText">
                            <h:outputText id="otClinicaAsignarSalaMedico" value="Clinica: "  styleClass="labelTextOblig"/>
                            <h:selectOneMenu id="mnuClinicaAsignarSalaMedico" disabled="true" value="#{asignarSalaMedicoBean.wcodclin}">
                                <f:selectItems value="#{asignarSalaMedicoBean.lstClinica}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuClinicaAsignarSalaMedico" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            <h:outputText id="otDoctorAsignarSalaMedico" value="Profesional: "  styleClass="labelTextOblig"/>
                            <a4j:region renderRegionOnly="false">
                            <h:selectOneMenu id="otCodProfAsignarSalaMedico" immediate="true" required="true"
                                             valueChangeListener="#{asignarSalaMedicoBean.setWcodmed}"
                                             value="#{asignarSalaMedicoBean.wcodmed}">
                                <f:selectItems value="#{asignarSalaMedicoBean.listaProfesionalesClinica}"/>
                                <a4j:support id="supportAsignarSalaMedico" action="#{asignarSalaMedicoBean.buscarSala}"
                                             event="onchange" immediate="true" reRender="panelMenuSala">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </h:selectOneMenu>
                            </a4j:region>
                            <h:outputText value = ""/>
                            
                              <h:outputText id="otSalaMedico" value="Sala "  styleClass="labelTextOblig"/>
                    <h:panelGroup id = "panelMenuSala">
                                 <h:selectOneMenu id="otAsignarSala" immediate="true" required="true"
                                  value="#{asignarSalaMedicoBean.wcodsala}">
                                <f:selectItems value="#{asignarSalaMedicoBean.listaSalaClinica}"/>
                    </h:selectOneMenu>
                    </h:panelGroup>
                     <a4j:outputPanel ajaxRendered="true">
                                <t:message for="otAsignarSala" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonAsignarClinica" columnClasses="panelGridBotones">
                            <h:panelGroup>
                                <a4j:outputPanel id="ajaxRegionMessagesAsignarClinica" ajaxRendered="true">
                                    <t:htmlTag value="br"/>
                                    <t:message for="idButtonAsignarSala" id="msgAsignarSala" errorClass="error"
                                               infoClass="informacion"/>
                                </a4j:outputPanel>
                            </h:panelGroup>
                            <a4j:commandButton value="Asignar Sala" 
                                    action="#{asignarSalaMedicoBean.asignarSalaMedico}"
                                   styleClass="boton_fieldset"
                                               id="idButtonAsignarSala"/>
                        </h:panelGrid>
                        
                    </s:fieldset>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionAsignarSalaMedico" ajaxRendered="true">
                <t:messages id="msgInformationAsignarSalaMedico" showSummary="false" errorClass="error"
                            globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
        </h:panelGroup>
    </a4j:region>
</a4j:form>