<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="aprobarAutorizacionDescripcionForm">
    <a4j:region id="bodyRegionAprobarAutorizacionDescripcion">
        <a4j:status id="statusButton" for="bodyRegionAprobarAutorizacionDescripcion">
            <f:facet name="start">
                <t:div id="chargindConsultarAprobarAutorizacionDescripcion" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
      
        <h:panelGrid columns="1" id="tableConsultarAprobarAutorizacionDescripcion" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
                     
            <h:outputText value="Aprobar Aclaración Descripción Quirurgica " 
                        id="infoUbicationAprobarAutorizacionDescripcion"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAprobarAutorizacionDescripcionTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAprobarAutorizacionDescripcion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAprobarAutorizacionDescripcion" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConAprobarAutorizacionDescripcion"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                <t:panelTab id="panelConAprobarAutorizacionDescripcion" label="Aprobar Autorización Descripción Qirurgica">
                    <s:fieldset legend="Datos Solicitud" id="fieldDatosAprobarAutorizacionDescripcion" styleClass="fieldset">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentAprobarAutorizacionDescripcion" rowClasses="labelText,labelTextInfo">
                                     
                                     <h:outputText value = "Fecha Solicitud"/>
                                     <h:outputText value = "Motivo Solicitud"/>
                                     
                                     <h:outputText value = "#{aprobarAclaracionDescripcionBean.autorizacion.haddfechasolic}"/>
                                     <h:outputText value = "#{aprobarAclaracionDescripcionBean.autorizacion.hadcmotivsolic}"/>
                                     
                                      
                                     <h:outputText value = "Usuario Solicitud"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarAclaracionDescripcionBean.autorizacion.hadcoperasolic}"/>
                                     <h:outputText value = ""/>
                           
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                <s:fieldset legend="Aprobar Solicitud" id="fieldDatosAprobarDescripcion" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentAprobarDescripcion" rowClasses="labelText,labelTextInfo">
                                     
                                     <h:outputText value = "Aprueba Solicitud"  styleClass="labelTextOblig"/>
                                      <h:outputText value =""/>
                                     <h:panelGroup id = "panelTextMotivoRechazo">
                                     <h:outputText value = "Motivo Rechazo" styleClass="labelTextOblig" rendered="#{aprobarAclaracionDescripcionBean.renderRechazo}"/>
                                     </h:panelGroup>
                                      <h:outputText value =""/>
                                     
                                      
                                     <h:selectOneRadio id = "mnuApruebaSolicitud" immediate="true"
                                        value = "#{aprobarAclaracionDescripcionBean.autorizacion.hadcaceptsolic}"
                                     valueChangeListener="#{aprobarAclaracionDescripcionBean.setHadcaceptsolic}">
                                        <f:selectItem itemLabel="SI" itemValue="S"/>
                                        <f:selectItem itemLabel="NO" itemValue="N"/>
                                          <a4j:support id="supportApruebaSolicitud" event="onclick"
                                              action="#{aprobarAclaracionDescripcionBean.changeSolicitud}"
                                             immediate="true"
                                             reRender="panelTextMotivoRechazo,panelInputMotivoRechazo">
                                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                       </a4j:support>
                                     </h:selectOneRadio>
                                       <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuApruebaSolicitud" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                     
                                     <h:panelGroup id = "panelInputMotivoRechazo">
                                         <h:inputTextarea id="textAreaMotivoAclaracion" required="true" rendered="#{aprobarAclaracionDescripcionBean.renderRechazo}"
                                             value="#{aprobarAclaracionDescripcionBean.autorizacion.hadcmotivrecha}"
                                             style="width:650px;height:70px">
                                         <f:validateLength maximum="100"/>
                                        </h:inputTextarea>
                                     </h:panelGroup>
                                       <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="textAreaMotivoAclaracion" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                    
                           
                        </h:panelGrid>
                    </s:fieldset>
                    
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesAprobarAutorizacionDescripcion"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Aceptar"
                                   styleClass="btn btn btn-success"
                                   action="#{aprobarAclaracionDescripcionBean.aceptar}"/>
              </h:panelGroup>
            </h:panelGrid>
                    <h:panelGrid>
                        <h:commandLink action="#{aprobarAclaracionDescripcionBean.volver}"
                                       immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgAprobarAutorizacionDescripcion" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgAprobarAutorizacionDescripcion" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>