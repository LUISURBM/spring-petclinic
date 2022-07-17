<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formRemisionHospitalizacion">
  <a4j:region id="regionRemisionHospitalizacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionRemisionHospitalizacion">
      <f:facet name="start">
        <t:div id="chargingRemisionHospitalizacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridRemisionHospitalizacionTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%"
                         id="panelTabbedPaneRemisionHospitalizacion"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabRemisionHospitalizacion"
                    label="Hospitalizaci�n">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridHospitalizacion"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Motivo de la Hospitalizaci�n "
                          styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="textHospitalizacion"     
                                disabled="#{remisionHospitalizacionBean.modoconsulta}"
                               value="#{remisionHospitalizacionBean.hospitalizacion.hrhcmotivhospi}"
                               required="true" style="width:600px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textHospitalizacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
             <h:outputText value="Plan de Manejo" styleClass="labelTextOblig"/>
             
             
               <h:panelGroup>
              <h:inputTextarea id="textPlanManejo"
                               disabled="#{remisionHospitalizacionBean.modoconsulta}"
                               value="#{remisionHospitalizacionBean.hospitalizacion.hrhcplanmanejo}"
                               required="true" style="width:600px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textPlanManejo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
        </h:panelGrid>
            
                 <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesRemisionHospitalizacion"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <a4j:commandButton value="Generar Hospitalizacion"
                                   styleClass="boton_fieldset"
                                   disabled="#{remisionHospitalizacionBean.modoconsulta}"
                                   reRender="formRemisionHospitalizacion"
                                   action="#{remisionHospitalizacionBean.generarHospitalizacion}"/>
              </h:panelGroup>
            <f:subview id="generarHospitalizacion"
                       rendered="#{remisionHospitalizacionBean.generoHospitalizacion}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
              </f:verbatim>
            </f:subview>
          </h:panelGrid>
        </t:panelTab>
           
      </t:panelTabbedPane>
         <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionHospitalizacionMsg" ajaxRendered="true">
                  <t:messages id="msgInformationHospitalizacionMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
      
    </h:panelGrid>
  </a4j:region>
</a4j:form>