<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formEntregaVph">
  <a4j:region id="regionEntregaVph" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionEntregaVph">
      <f:facet name="start">
        <t:div id="chargingEntregaVph" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEntregaVphTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneEntregaVph" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabEntregaVph" label="Entrega Resultados Vph">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridEntregaVph" styleClass="tabContainer">
            <s:fieldset legend="Datos Usuario" id="fieldSetInfoConsultarUsuario" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Tipo Identificaci�n"/>
                <h:outputText value=" Numero Identificaci�n"/>
                <h:outputText value=""/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoIde" required="true" disabled="true"
                                   value="#{entregaVphBean.vph.hdvctipide}">
                    <f:selectItems value="#{entregaVphBean.listTipoIdentificacion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoIde" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="#{entregaVphBean.vph.hdvanumide}"/>
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
                  <h:outputText value="#{entregaVphBean.vph.hdvcprinom}"/>
                </h:panelGroup>
                <h:outputText value="#{entregaVphBean.vph.hdvcsegnom}"/>
                <h:panelGroup>
                  <h:outputText id="primerApellido" value="#{entregaVphBean.vph.hdvcpriape}"/>
                </h:panelGroup>
                <h:outputText value="#{entregaVphBean.vph.hdvcsegape}"/>
                <h:outputText value="N�mero Vph"/>
                <h:outputText value="Fecha de la Vph"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:panelGroup>
                  <h:outputText value="#{entregaVphBean.vph.hdvnconsec}"/>
                </h:panelGroup>
                <h:outputText value="#{entregaVphBean.vph.hdvdfecreg}"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Entrega Resultados Vph" id="fieldEntregaVph" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosEntregaVph" rowClasses="labelText,labelTextInfo">
                           
                   <h:outputText value="Conducta"/>
                   
                   <h:outputText value="Reclama la Usuaria? " styleClass="labelTextOblig"/>
                    
                    <h:panelGroup>
                    <h:selectOneMenu id = "mnuConducta" value = "#{entregaVphBean.entrega.hlvcconducta}">
                    <f:selectItems value = "#{entregaVphBean.lstConducta}"/>
                    </h:selectOneMenu>
                       <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuConducta" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                           
                
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuEntrega" immediate="true" required="true"
                                    value="#{entregaVphBean.reclamaUsuaria}"
                                    valueChangeListener="#{entregaVphBean.setReclamaUsuaria}">
                    <f:selectItems value="#{entregaVphBean.lstOpciones}"/>
                    <a4j:support id="supportmnuEntrega" event="onclick"
                                 action="#{entregaVphBean.changeReclama}" reRender="panelGridVph2">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEntrega" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </a4j:region>

              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridVph2"
                           styleClass="tabContainer">
                <h:panelGroup>
                  <h:outputText value="Nombre de la persona que reclama " styleClass="labelTextOblig"
                                rendered="#{entregaVphBean.mostrarReclama}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Parentesco " styleClass="labelTextOblig"
                                rendered="#{entregaVphBean.mostrarReclama}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNombreReclama" required="true" maxlength="60"
                               value="#{entregaVphBean.entrega.hlvcnombrerecl}"
                               rendered="#{entregaVphBean.mostrarReclama}" style="width:250px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreReclama" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itParentescoReclama" required="true" maxlength="20"
                               rendered="#{entregaVphBean.mostrarReclama}"
                               value="#{entregaVphBean.entrega.hlvcparentesco}" style="width:250px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itParentescoReclama" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              
            </s:fieldset>
            
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonesEntregaVph" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Entregar Vph" styleClass="boton_fieldset"
                        action="#{entregaVphBean.generarEntregaVph}" />
              </h:panelGroup>
            </h:panelGrid>
            
            <a4j:commandLink id="mostrarImpresion" action="#{entregaVphBean.generarPDF}"
                           rendered="#{entregaVphBean.modoConsulta}"
                             reRender="panelGridEntregaVphTab" immediate="true"
                             title="Imprimir Entrega Resultados Vph">
              <t:graphicImage alt="Imprimir Entrega Resultados Vph" title="Imprimir Entrega Resultados" border="0"
                              url="/comun/imagenes/print_Spa.gif"/>
            </a4j:commandLink>
            
            <h:panelGrid></h:panelGrid>
            
            <f:subview id="generarEntrega" rendered="#{entregaVphBean.generoEntregaResultado}">
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
          <a4j:outputPanel id="ajaxRegionVphMsg" ajaxRendered="true">
            <t:messages id="msgInformationVphMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:commandLink action="#{entregaVphBean.volverConsulta}" immediate="true">
        <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
    </h:panelGrid>
  </a4j:region>
</a4j:form>