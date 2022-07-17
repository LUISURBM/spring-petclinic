<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formConducta">
  <a4j:region id="regionConducta" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionConducta">
      <f:facet name="start">
        <t:div id="chargingConducta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
  

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridConductaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneConducta"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabConducta" label="Conducta ">
          <h:panelGrid columns="1" dir="LTR" cellpadding="0" cellspacing="0"
                       border="0" width="100%"
                       rendered="#{conductaBean.mostrarIcono}">
            <a4j:commandLink action="#{conductaBean.generarReporte}"
                             reRender="formConducta" immediate="true"
                             title="Imprimir Recomendaciones">
              <t:graphicImage alt="Imprimir Recomendaciones"
                              title="Imprimir Recomendaciones" border="0"
                              url="/comun/imagenes/pdf2.gif"/>
            </a4j:commandLink>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridConducta"
                       styleClass="tabContainer">
            <s:fieldset legend="Conducta" id="fieldConducta"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelConductaObservaciones"
                           rowClasses="labelText">
                <h:outputText value="Recomendaciones"
                              styleClass="labelTextOblig"/>
            <h:outputText value=""/>
                <h:panelGroup>
                  <h:inputTextarea id="textObservaciones" required="true"
                                   disabled="#{conductaBean.modoconsulta}"
                                   value="#{conductaBean.conducta.hcncobservacio}"
                                   style="width:600px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textObservaciones"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                            
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonBotonesConducta"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                   disabled="#{conductaBean.modoconsulta}"
                                   reRender="formConducta"
                                   action="#{conductaBean.aceptar}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajesConducta"
                                 ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInfConducta" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
      <f:subview id="generarRecomendaciones"
                 rendered="#{conductaBean.generoRecomendaciones}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </a4j:region>
</a4j:form>