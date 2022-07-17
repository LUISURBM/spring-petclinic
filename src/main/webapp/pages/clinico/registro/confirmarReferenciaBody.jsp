<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formReferencia">
  <a4j:region id="regionReferencia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionReferencia">
      <f:facet name="start">
        <t:div id="chargingReferencia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReferenciaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReferencia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReferencia" label="Referencia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReferencia"
                       styleClass="tabContainer">
            <s:fieldset legend="Referencia" id="fieldReferencia" styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosReferencia"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo de Servicio" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectManyCheckbox id="checkTipoServicio" value="#{confirmarReferenciaBean.lstServiciosSelect}"
                                        disabled="true">
                    <f:selectItems value="#{confirmarReferenciaBean.lstTiposServicios}"/>
                  </h:selectManyCheckbox>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="checkTipoServicio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <s:fieldset legend="Responsable" id="fieldReferenciaResponsable" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelDatosReferencia1" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Nombre Responsable" styleClass="labelTextOblig"/>
                  <h:outputText/>
                  <h:outputText id="itNombreResponsable" value="#{confirmarReferenciaBean.referencia.hrecnombrespon}"/>
                  <h:outputText/>
                  <h:outputText value="Direcci�n Responsable" styleClass="labelTextOblig"/>
                  <h:outputText value="Telefono Responsable" styleClass="labelTextOblig"/>
                  <h:outputText id="itDirResponsable" value="#{confirmarReferenciaBean.referencia.hrecdirecrespo}"/>
                  <h:outputText id="itTelResponsable" value="#{confirmarReferenciaBean.referencia.hrectelefrespo}"/>
                </h:panelGrid>
              </s:fieldset>
              <s:fieldset legend="Datos Referencia " id="fieldRef" styleClass="fieldset">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelDatosReferencia2" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Anamnesis" styleClass="labelTextOblig"/>
                  <h:inputTextarea id="textAnamnesis" disabled="true" 
                                   value="#{confirmarReferenciaBean.referencia.hrecanamnesis}" style="width:600px"/>
                  <h:outputText value="Apoyo Diagnostico" styleClass="labelTextOblig"/>
                  <h:inputTextarea id="textApoyoDiagnostico" disabled="true" 
                                   value="#{confirmarReferenciaBean.referencia.hrecapoyodiagn}" style="width:600px"/>
                  <h:outputText value="Justifiaci�n de la referencia" styleClass="labelTextOblig"/>
                  <h:inputTextarea id="textJustificacion" disabled="true" 
                                     value="#{confirmarReferenciaBean.referencia.hrecjustirefer}" style="width:600px"/>
                </h:panelGrid>
              </s:fieldset>
              
              <s:fieldset legend="Confirmaci�n Referencia " id="fieldCnf" styleClass="fieldset">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelDatosConfirma" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Observaci�n Confirmaci�n" styleClass="labelTextOblig"/>
                  <h:panelGroup>
                    <h:inputTextarea id="textObservacion" required="true" 
                                     value="#{confirmarReferenciaBean.referencia.hrecobsconf}" style="width:600px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="textObservacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
              </s:fieldset>

              
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonReferencia"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <a4j:commandButton value="Confirmar Referencia" styleClass="boton_fieldset"
                                   action="#{confirmarReferenciaBean.confirmarReferencia}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionReferenciaMsg" ajaxRendered="true">
                  <t:messages id="msgReferenciaMsg" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>