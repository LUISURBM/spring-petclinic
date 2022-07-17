<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="gestionPrioridadForm">
    <a4j:region id="bodyRegionPrioridad" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegionPrioridad">
            <f:facet name="start">
                <t:div id="chargindDiv3" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%"
                     columnClasses="td_ubicador">
            <h:outputText value="Historias Clinicas >> Gestión Prioridad " id="infoUbication"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                     styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesInfoClin" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabbedPaneEmpresa" styleClass="tabbedPane"
                               activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                               disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                               inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                <t:panelTab id="panelTabInfoGenral" label="Asignar Prioridad a Servicios por Profesionales"
                            rendered="true">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoBasica" styleClass="fieldset">
                        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="2" width="100%"
                                     id="panelRegionInfoBasica" columnClasses="labelText,labelText">
                            <h:outputText id="otClinica" value="Clinica: "/>
                            <h:selectOneMenu id="mnuClinica" disabled="true" value="#{gestionPrioridadBean.wcodclin}">
                                <f:selectItems value="#{gestionPrioridadBean.lstClinica}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuClinica" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            <h:outputText id="otDoctor" value="Profesional: "/>
                            <h:selectOneMenu id="otCodProf" immediate="true"
                                             valueChangeListener="#{gestionPrioridadBean.setWcodmed}"
                                             value="#{gestionPrioridadBean.wcodmed}">
                                <f:selectItems value="#{gestionPrioridadBean.listaProfesionalesClinica}"/>
                                <a4j:support id="supportCodProf" action="#{gestionPrioridadBean.buscarServicios}"
                                             event="onchange" immediate="true" reRender="gestionPrioridadForm">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                </a4j:support>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <t:htmlTag value="br"/>
                        <t:htmlTag value="br"/>
                        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="2" width="100%"
                                     id="panelRegionInfoServicios" rowClasses="labelText,labelText">
                            <h:panelGrid columns="7"
                                         rendered="#{not empty gestionPrioridadBean.listServiciosProfesional || not empty gestionPrioridadBean.listServiciosProfesionalSP}">
                                <h:outputLabel value="Servicios "
                                               rendered="#{not empty gestionPrioridadBean.listServiciosProfesional || not empty gestionPrioridadBean.listServiciosProfesionalSP}"
                                               for="serviciosProf" styleClass="labelTextOblig"/>
                                <h:outputText value=" "/>
                                <h:outputText value="[ "/>
                                <a4j:commandLink onclick="CheckAll('body:gestionPrioridadForm','body:gestionPrioridadForm:panelTabInfoGenral:serviciosProf');CheckAll('body:gestionPrioridadForm','body:gestionPrioridadForm:panelTabInfoGenral:serviciosProfSP')"
                                                 value=" Todos"/>
                                <h:outputText value=" | "/>
                                <a4j:commandLink onclick="unCheckAll('body:gestionPrioridadForm','body:gestionPrioridadForm:panelTabInfoGenral:serviciosProf');unCheckAll('body:gestionPrioridadForm','body:gestionPrioridadForm:panelTabInfoGenral:serviciosProfSP')"
                                                 value="Ninguno "/>
                                <h:outputText value=" ]"/>
                            </h:panelGrid>
                            <h:outputText value=""
                                          rendered="#{empty gestionPrioridadBean.listServiciosProfesional && empty gestionPrioridadBean.listServiciosProfesionalSP}"/>
                            <h:outputText value=""/>
                            <h:outputText value=""/>
                            <h:outputText value=""/>
                            <h:panelGrid rendered="#{not empty gestionPrioridadBean.listServiciosProfesional}"
                                         columns="1" border="0" cellpadding="0" cellspacing="2" width="100%"
                                         id="panelRegionServProf" rowClasses="standardTable_Row4,standardTable_Row4"
                                         style="border-color:#3f3e23;">
                                <h:selectManyCheckbox style="border-style:none;" immediate="true" id="serviciosProf"
                                                      value="#{gestionPrioridadBean.selectedItems}"
                                                      layout="pageDirection">
                                    <f:selectItems value="#{gestionPrioridadBean.listServiciosProfesional}"/>
                                </h:selectManyCheckbox>
                            </h:panelGrid>
                            <h:panelGrid rendered="#{not empty gestionPrioridadBean.listServiciosProfesionalSP}"
                                         columns="1" border="0" cellpadding="0" cellspacing="2" width="100%"
                                         id="panelRegionServProfSP" rowClasses="standardTable_Row3,standardTable_Row3"
                                         style="border-color:#006600;">
                                <h:selectManyCheckbox style="border-style:none;" immediate="true" id="serviciosProfSP"
                                                      value="#{gestionPrioridadBean.selectedItemsSP}"
                                                      layout="pageDirection" disabledClass="checkbox_gen"
                                                      enabledClass="checkbox_gen" styleClass="checkbox_gen">
                                    <f:selectItems value="#{gestionPrioridadBean.listServiciosProfesionalSP}"/>
                                </h:selectManyCheckbox>
                            </h:panelGrid>
                            <h:outputText value="" rendered="#{empty gestionPrioridadBean.listServiciosProfesionalSP}"/>
                            <t:message for="serviciosProfSP" id="messageserviciosProfSP" errorClass="errorMessage"/>
                            <h:outputText value=""/>
                            <h:outputText value=""/>
                        </h:panelGrid>
                        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                                     id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
                            <t:htmlTag value="br"/>
                            <h:commandButton value="Asignar Prioridad" action="#{gestionPrioridadBean.asignarPrioridad}"
                                             styleClass="boton_fieldset"/>
                        </h:panelGrid>
                    </s:fieldset>
                    <h:panelGrid columns="4"
                                 rendered="#{not empty gestionPrioridadBean.listServiciosProfesional || not empty gestionPrioridadBean.listServiciosProfesionalSP}">
                        <h:panelGrid columns="1" border="1" cellpadding="2" cellspacing="0" width="30"
                                     rowClasses="standardTable_Row4,standardTable_Row4" style="border-color:#000000;">
                            <h:outputText value=""/>
                        </h:panelGrid>
                        <h:outputText value=" CON Prioridad " style="font-size:7.0pt;"/>
                        <h:panelGrid columns="1" border="1" cellpadding="2" cellspacing="0" width="30"
                                     rowClasses="standardTable_Row3,standardTable_Row3" style="border-color:#000000;">
                            <h:outputText value=""/>
                        </h:panelGrid>
                        <h:outputText value=" SIN Prioridad" style="font-size:7.0pt;"/>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesPrioridad" ajaxRendered="true">
                <t:messages id="msgInformationAndErrorsPrioridad" showSummary="false" errorClass="error"
                            globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
        </h:panelGroup>
    </a4j:region>
</a4j:form>