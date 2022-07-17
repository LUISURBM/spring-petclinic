<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formEntregaCitologia">
  <a4j:region id="regionEntregaCitologia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEntregaCitologia">
      <f:facet name="start">
        <t:div id="chargingEntregaCitologia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntregaCitologiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneEntregaCitologia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabEntregaCitologia" label="Entrega Resultados Citologia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridEntregaCitologia" styleClass="tabContainer">
            <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuario" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo Identificaci�n"/>
                <h:outputText value=" Numero Identificaci�n"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                                   value="#{entregaCitologiaBean.citologia.ccictipide}">
                    <f:selectItems value="#{entregaCitologiaBean.listTipoIdentificacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoIde" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="#{entregaCitologiaBean.citologia.ccianumide}"/>
                <h:outputText id="itNumeroUsuario" value=""/>
                <t:htmlTag value="br"/>
              </h:panelGrid>
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosNombre"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Primer Nombre"/>
                <h:outputText value="Segundo Nombre"/>
                <h:outputText value="Primer Apellido"/>
                <h:outputText value="Segundo Apellido"/>
                <h:panelGroup>
                  <h:outputText value="#{entregaCitologiaBean.citologia.ccicprinom}"/>
                </h:panelGroup>
                <h:outputText value="#{entregaCitologiaBean.citologia.ccicsegnom}"/>
                <h:panelGroup>
                  <h:outputText id="primerApellido" value="#{entregaCitologiaBean.citologia.ccicpriape}"/>
                </h:panelGroup>
                <h:outputText value="#{entregaCitologiaBean.citologia.ccicsegape}"/>
                <h:outputText value="N�mero Citologia"/>
                <h:outputText value="Fecha de la Citologia"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:panelGroup>
                  <h:outputText value="#{entregaCitologiaBean.citologia.ccinconsec}"/>
                </h:panelGroup>
                <h:outputText value="#{entregaCitologiaBean.citologia.ccidfecreg}"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Entrega Resultados" id="fieldEntregaCitologia" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosEntregaCitologia" rowClasses="labelText,labelTextInfo">
                           
                   <h:outputText value="Conducta "/>
                   
                   <h:outputText value="Reclama la Usuaria? " styleClass="labelTextOblig"/>
                    
                    <h:panelGroup>
                    <h:selectOneMenu id = "mnuConducta" value = "#{entregaCitologiaBean.entrega.hlccconducta}">
                    <f:selectItems value = "#{entregaCitologiaBean.lstConducta}"/>
                    </h:selectOneMenu>
                       <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuConducta" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                           
                
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuEntrega" immediate="true" required="true"
                                    value="#{entregaCitologiaBean.reclamaUsuaria}"
                                    valueChangeListener="#{entregaCitologiaBean.setReclamaUsuaria}">
                    <f:selectItems value="#{entregaCitologiaBean.lstOpciones}"/>
                    <a4j:support id="supportmnuEntrega" event="onclick"
                                 action="#{entregaCitologiaBean.changeReclama}" reRender="panelGridCitologia2">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEntrega" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </a4j:region>

              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCitologia2"
                           styleClass="tabContainer">
                <h:panelGroup>
                  <h:outputText value="Nombre de la persona que reclama " styleClass="labelTextOblig"
                                rendered="#{entregaCitologiaBean.mostrarReclama}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Parentesco " styleClass="labelTextOblig"
                                rendered="#{entregaCitologiaBean.mostrarReclama}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNombreReclama" required="true" maxlength="60"
                               value="#{entregaCitologiaBean.entrega.hlccnombrerecl}"
                               rendered="#{entregaCitologiaBean.mostrarReclama}" style="width:250px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreReclama" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itParentescoReclama" required="true" maxlength="20"
                               rendered="#{entregaCitologiaBean.mostrarReclama}"
                               value="#{entregaCitologiaBean.entrega.hlccparentesco}" style="width:250px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itParentescoReclama" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              
              
              
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonesEntregaCitologia" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Entregar Citologia" disabled="#{entregaCitologiaBean.generoCitologia}" styleClass="boton_fieldset"
                        action="#{entregaCitologiaBean.generarCitologia}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid></h:panelGrid>
            <f:subview id="generarCitologia" rendered="#{entregaCitologiaBean.generoCitologia}">
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
          <a4j:outputPanel id="ajaxRegionCitologiaMsg" ajaxRendered="true">
            <t:messages id="msgInformationCitologiaMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:commandLink action="#{entregaCitologiaBean.volverConsulta}" immediate="true">
        <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
    </h:panelGrid>
  </a4j:region>
</a4j:form>