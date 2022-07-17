<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="aprobarAutorizacionNotaAclaratoriaForm">
    <a4j:region id="bodyRegionAprobarAutorizacionNotaAclaratoria">
        <a4j:status id="statusButton" for="bodyRegionAprobarAutorizacionNotaAclaratoria">
            <f:facet name="start">
                <t:div id="chargindConsultarAprobarAutorizacionNotaAclaratoria" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
      
        <h:panelGrid columns="1" id="tableConsultarAprobarAutorizacionNotaAclaratoria" border="0" cellpadding="0" cellspacing="0"
                     width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
                     
            <h:outputText value="Aprobar Nota Aclaratoria " 
                        id="infoUbicationAprobarAutorizacionNotaAclaratoria"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableAprobarAutorizacionNotaAclaratoriaTabs" styleClass="tabContainer">
            <h:panelGroup>
                <a4j:outputPanel id="ajaxAprobarAutorizacionNotaAclaratoria" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgAprobarAutorizacionNotaAclaratoria" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false"
                               activePanelTabVar="true" width="100%" id="tabConAprobarAutorizacionNotaAclaratoria"
                               styleClass="tabbedPane" activeTabStyleClass="activeTab"
                               inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                               activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                               tabContentStyleClass="tabContent">
                <t:panelTab id="panelConAprobarAutorizacionNotaAclaratoria" label="Aprobar Autorización Descripción Qirurgica">
                    <s:fieldset legend="Datos Solicitud" id="fieldDatosAprobarAutorizacionNotaAclaratoria" styleClass="fieldset">
                        <h:panelGrid columns="2" border="0" cellpadding="0" width="100%"
                                     id="tableContentAprobarAutorizacionNotaAclaratoria" rowClasses="labelText,labelTextInfo">
                                     
                                     <h:outputText value = "Fecha Solicitud"/>
                                     <h:outputText value = "Motivo Solicitud"/>
                                     
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.handfechasolic}"/>
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.hancmotivsolic}"/>
                                     
                                      
                                     <h:outputText value = "Usuario Solicitud"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.hancoperasolic}"/>
                                     <h:outputText value = ""/>
                                     
                                     
                                     <h:outputText value = "Servicio"/>
                                     <h:outputText value = "Fecha Consulta"/>
                                     
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.hancservicio} #{aprobarNotaAclaratoriaBean.autorizacion.hancnombserv}"/>
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.handfechaconsu}"/>
                                     
                                      <h:outputText value = "Paciente"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.hancnombpaci} #{aprobarNotaAclaratoriaBean.autorizacion.hanctipoiden} #{aprobarNotaAclaratoriaBean.autorizacion.hannnumeiden}"/>
                                     <h:outputText value = ""/>
                                     
                                       <h:outputText value = "Clinica"/>
                                     <h:outputText value = ""/>
                                     
                                     <h:outputText value = "#{aprobarNotaAclaratoriaBean.autorizacion.hannclinica} #{aprobarNotaAclaratoriaBean.autorizacion.nombreClinica}"/>
                                     <h:outputText value = ""/>
                                     
                           
                        </h:panelGrid>
                    </s:fieldset>
                    
                    
                <s:fieldset legend="Aprobar Solicitud" id="fieldDatosAprobarNotaAclaratoria" styleClass="fieldset">
                        <h:panelGrid columns="4" border="0" cellpadding="0" width="100%"
                                     id="tableContentAprobarNotaAclaratoria" rowClasses="labelText,labelTextInfo">
                                     
                                     <h:outputText value = "Aprueba Solicitud"  styleClass="labelTextOblig"/>
                                      <h:outputText value =""/>
                                     <h:panelGroup id = "panelTextMotivoRechazo">
                                     <h:outputText value = "Motivo Rechazo" styleClass="labelTextOblig" rendered="#{aprobarNotaAclaratoriaBean.renderRechazo}"/>
                                     </h:panelGroup>
                                      <h:outputText value =""/>
                                     
                                      
                                     <h:selectOneRadio id = "mnuApruebaSolicitud" immediate="true"
                                        value = "#{aprobarNotaAclaratoriaBean.autorizacion.hancaceptsolic}"
                                     valueChangeListener="#{aprobarNotaAclaratoriaBean.setHancaceptsolic}">
                                        <f:selectItem itemLabel="SI" itemValue="S"/>
                                        <f:selectItem itemLabel="NO" itemValue="N"/>
                                          <a4j:support id="supportApruebaSolicitud" event="onclick"
                                              action="#{aprobarNotaAclaratoriaBean.changeSolicitud}"
                                             immediate="true"
                                             reRender="panelTextMotivoRechazo,panelInputMotivoRechazo">
                                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                       </a4j:support>
                                     </h:selectOneRadio>
                                       <a4j:outputPanel ajaxRendered="true">
                                            <t:message for="mnuApruebaSolicitud" styleClass="errorMessage"/>
                                        </a4j:outputPanel>
                                     
                                     <h:panelGroup id = "panelInputMotivoRechazo">
                                         <h:inputTextarea id="textAreaMotivoAclaracion" required="true" rendered="#{aprobarNotaAclaratoriaBean.renderRechazo}"
                                             value="#{aprobarNotaAclaratoriaBean.autorizacion.hancmotivrecha}"
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
                         width="100%" id="panelBotonesAprobarAutorizacionNotaAclaratoria"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Aceptar"
                                   styleClass="btn btn btn-success"
                                   action="#{aprobarNotaAclaratoriaBean.aceptar}"/>
              </h:panelGroup>
            </h:panelGrid>
                    <h:panelGrid>
                        <h:commandLink action="#{aprobarNotaAclaratoriaBean.volver}"
                                       immediate="true">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
                        </h:commandLink>
                    </h:panelGrid>
                </t:panelTab>
            </t:panelTabbedPane>
        </h:panelGrid>
        <h:panelGrid>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMsgAprobarAutorizacionNotaAclaratoria" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationMsgAprobarAutorizacionNotaAclaratoria" showSummary="true" errorClass="error"
                                globalOnly="true" layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>