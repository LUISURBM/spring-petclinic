<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="aprobarAutorizacionInformePsicologicoForm">
    <a4j:region id="bodyRegionAprobarAutorizacionInformePsicologico">
        <a4j:status id="statusButton" for="bodyRegionAprobarAutorizacionInformePsicologico">
            <f:facet name="start">
                <t:div id="chargindConsultarAprobarAutorizacionInformePsicologico" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
      
        <h:panelGrid columns="1" id="tableConsultarAprobarAutorizacionInformePsicologico" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
                     
            <h:outputText value="Aprobar Informe Psicologico " 
                        id="infoUbicationAprobarAutorizacionInformePsicologico"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAprobarAutorizacionInformePsicologicoTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAprobarAutorizacionInformePsicologico" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAprobarAutorizacionInformePsicologico" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConAprobarAutorizacionInformePsicologico"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                <t:panelTab id="panelConAprobarAutorizacionInformePsicologico" label="Aprobar Autorización Informe Psicologico">
                    <s:fieldset legend="Datos Solicitud" id="fieldDatosAprobarAutorizacionInformePsicologico" styleClass="fieldset">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentAprobarAutorizacionInformePsicologico" rowClasses="labelText,labelTextInfo">
                                     
                                     <h:outputText value = "Fecha Solicitud"/>
                                     <h:outputText value = "Motivo Solicitud"/>
                                     
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipdfechasolic}"/>
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipcmotivsolic}"/>
                                     
                                      
                                     <h:outputText value = "Usuario Solicitud"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipcoperasolic}"/>
                                     <h:outputText value = ""/>
                                     
                                     
                                     <h:outputText value = "Servicio"/>
                                     <h:outputText value = "Fecha Consulta"/>
                                     
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipcservicio} #{aprobarInformePsicologicoBean.autorizacion.haipcnombserv}"/>
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipdfechaconsu}"/>
                                     
                                      <h:outputText value = "Paciente"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipcnombpaci} #{aprobarInformePsicologicoBean.autorizacion.haipctipoiden} #{aprobarInformePsicologicoBean.autorizacion.haipnnumeiden}"/>
                                     <h:outputText value = ""/>
                                     
                                       <h:outputText value = "Clinica"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarInformePsicologicoBean.autorizacion.haipnclinica} #{aprobarInformePsicologicoBean.autorizacion.nombreClinica}"/>
                                     <h:outputText value = ""/>
                                     
                           
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                <s:fieldset legend="Aprobar Solicitud" id="fieldDatosAprobarInformePsicologico" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentAprobarInformePsicologico" rowClasses="labelText,labelTextInfo">
                                     
                                     <h:outputText value = "Aprueba Solicitud"  styleClass="labelTextOblig"/>
                                      <h:outputText value =""/>
                                     <h:panelGroup id = "panelTextMotivoRechazo">
                                     <h:outputText value = "Motivo Rechazo" styleClass="labelTextOblig" rendered="#{aprobarInformePsicologicoBean.renderRechazo}"/>
                                     </h:panelGroup>
                                      <h:outputText value =""/>
                                     
                                      
                                     <h:selectOneRadio id = "mnuApruebaSolicitud" immediate="true"
                                        value = "#{aprobarInformePsicologicoBean.autorizacion.haipcaceptsolic}"
                                     valueChangeListener="#{aprobarInformePsicologicoBean.setHaipcaceptsolic}">
                                        <f:selectItem itemLabel="SI" itemValue="S"/>
                                        <f:selectItem itemLabel="NO" itemValue="N"/>
                                          <a4j:support id="supportApruebaSolicitud" event="onclick"
                                              action="#{aprobarInformePsicologicoBean.changeSolicitud}"
                                             immediate="true"
                                             reRender="panelTextMotivoRechazo,panelInputMotivoRechazo">
                                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                       </a4j:support>
                                     </h:selectOneRadio>
                                       <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuApruebaSolicitud" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                     
                                     <h:panelGroup id = "panelInputMotivoRechazo">
                                         <h:inputTextarea id="textAreaMotivoAclaracion" required="true" rendered="#{aprobarInformePsicologicoBean.renderRechazo}"
                                             value="#{aprobarInformePsicologicoBean.autorizacion.haipcmotivrecha}"
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
                         width="100%" id="panelBotonesAprobarAutorizacionInformePsicologico"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Aceptar"
                                   styleClass="btn btn btn-success"
                                   action="#{aprobarInformePsicologicoBean.aceptar}"/>
              </h:panelGroup>
            </h:panelGrid>
                    <h:panelGrid>
                        <h:commandLink action="#{aprobarInformePsicologicoBean.volver}"
                                       immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgAprobarAutorizacionInformePsicologico" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgAprobarAutorizacionInformePsicologico" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>