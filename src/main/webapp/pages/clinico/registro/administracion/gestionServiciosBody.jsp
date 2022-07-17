<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="gestionProfesionales">
    <a4j:region id="bodyRegionProfesionales" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegionProfesionales">
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
            <h:outputText value="Historias Clinicas >> Prioridad Profesionales" id="infoUbication"/>
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
                <t:panelTab id="panelTabInfoGenral" label="Activar Prioridad a  Profesionales"
                            rendered="true">
                    <t:htmlTag value="br"/>
                    <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoBasica" styleClass="fieldset">
                        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="2" width="100%"
                                     id="panelRegionInfoBasica" columnClasses="labelText,labelText">
                            <h:outputText id="otClinica" value="Clinica: "/>
                            <h:selectOneMenu id="mnuClinica" disabled="true" value="#{gestionProfesionalesBean.wcodclin}">
                                <f:selectItems value="#{gestionProfesionalesBean.lstClinica}"/>
                            </h:selectOneMenu>
                            <a4j:outputPanel ajaxRendered="true">
                                <t:message for="mnuClinica" styleClass="errorMessage"/>
                            </a4j:outputPanel>
                            <h:outputText id="otDoctor" value="Profesional: "/>
                            <h:selectOneMenu id="otCodProf" 
                                              value="#{gestionProfesionalesBean.wcodmed}">
                                <f:selectItems value="#{gestionProfesionalesBean.listaProfesionalesClinica}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                          <h:panelGrid columns="2" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelBotonAgregarExamenImagenes"
                             columnClasses="panelGridBotones">
                  <h:panelGroup>
                    <t:htmlTag value="br"/>
                    <a4j:commandButton value="Agregar"
                                       styleClass="boton_fieldset"
                                       action="#{gestionProfesionalesBean.agregarProfesional}"
                                       reRender="tableContentTabs"/>
                  </h:panelGroup>
                </h:panelGrid>
                    </s:fieldset>
                    
            <a4j:region renderRegionOnly="false">
                 <s:fieldset legend="Medicos que atiende solo las consultas prioritarias "
                            id="fieldMedicosPrioridadLista" rendered="#{not empty gestionProfesionalesBean.listaProfesionalPrioridad}"
                            styleClass="fieldset">
                  <h:panelGrid columns="1" border="0" cellpadding="0"
                               cellspacing="0" width="100%"
                               id="panelMedicosPrioridadTable"
                               styleClass="tabContainer">
                    <t:buffer into="#{table}">
                      <h:dataTable var="item" border="1" cellpadding="0"
                                   binding="#{gestionProfesionalesBean.dtMedicosPrioridad}"
                                   cellspacing="0"
                                   value="#{gestionProfesionalesBean.listaProfesionalPrioridad}"
                                   rows="10" styleClass="standard_table"
                                   rowClasses="standardTable_Row1,standardTable_Row2"
                                   footerClass="paginacion"
                                   id="dtMedicosPrioridad">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Codigo"/>
                          </f:facet>
                          <h:outputText value="#{item.id.hpmncodigprofe}"/>
                        </h:column>
                        
                              <h:column>
                          <f:facet name="header">
                            <h:outputText value="Nombre"/>
                          </f:facet>
                          <h:outputText value="#{item.hpmcnombre}"/>
                        </h:column>
                        
                        
                              <h:column>
                          <f:facet name="header">
                            <h:outputText value="Cedula"/>
                          </f:facet>
                          <h:outputText value="#{item.hpmacedula}"/>
                        </h:column>
                        
                        
                              <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                            <h:commandLink id="eliminarPrioridad" immediate="true"  action="#{gestionProfesionalesBean.eliminarPrioridad}">
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                      </h:commandLink>
                        </h:column>
                        </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                      <h:panelGrid columns="1"
                                   rowClasses="labelTextInfo,labelTextInfo">
                        <t:dataScroller id="scroll_MedicosPrioridad"
                                        for="dtMedicosPrioridad"
                                        fastStep="10" pageCountVar="pageCount"
                                        pageIndexVar="pageIndex"
                                        styleClass="scroller" paginator="true"
                                        immediate="true" paginatorMaxPages="9"
                                        paginatorTableClass="paginator"
                                        renderFacetsIfSinglePage="false"
                                        paginatorActiveColumnStyle="font-weight:bold;">
                          <f:facet name="first">
                            <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="last">
                            <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="previous">
                            <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="next">
                            <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="fastforward">
                            <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="fastrewind">
                            <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                            border="0"/>
                          </f:facet>
                        </t:dataScroller>
                      </h:panelGrid>
                    </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                  <h:outputText value="#{table}" escape="false"/>
                  <h:outputText value="#{tableScroller}" escape="false"/>
                  </h:panelGrid>
                </s:fieldset>
              </a4j:region>
              
                 <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset" reRender="panelGridExamenImagenesTab" 
                               action="#{gestionProfesionalesBean.guardarProfesionalPrioridad}"/>
          </h:panelGrid>
                    
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMessagesProfesionales" ajaxRendered="true">
                <t:messages id="msgInformationAndErrorsProfesionales" showSummary="false" errorClass="error"
                            globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
            </a4j:outputPanel>
            <t:htmlTag value="br"/>
        </h:panelGroup>
    </a4j:region>
</a4j:form>