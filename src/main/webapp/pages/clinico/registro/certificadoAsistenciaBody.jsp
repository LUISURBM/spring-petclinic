<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formCertificadoAsistencia">
  <a4j:region id="regionCertificadoAsistencia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionCertificadoAsistencia">
      <f:facet name="start">
        <t:div id="chargingCertificadoAsistencia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridCertificadoAsistenciaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneCertificadoAsistencia"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabCertificadoAsistencia"
                    label="Certificado Asistencia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridCertificadoAsistencia"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Solicita certificado asistencia"
                          styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuSolicita" immediate="true"
                                required="true"
                                disabled="#{certificadoAsistenciaBean.modoconsulta}"
                                value="#{certificadoAsistenciaBean.dirigidoSelect}"
                                valueChangeListener="#{certificadoAsistenciaBean.setDirigidoSelect}">
                <f:selectItems value="#{certificadoAsistenciaBean.lstDirigido}"/>
                <a4j:support id="supportmnuSolicita" event="onclick"
                             immediate="true"
                             action="#{certificadoAsistenciaBean.changeSolicita}"
                             reRender="panelGridCertificadoAcom">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuSolicita" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
            </a4j:region>
          </h:panelGrid>
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridCertificadoAcom"
                       rowClasses="labelText,labelTextInfo">
             <h:panelGroup>          
            <h:outputText value="Tipo Documento" styleClass="labelTextOblig"  rendered="#{certificadoAsistenciaBean.mostrarAcomp}"/>
            </h:panelGroup>
            <h:panelGroup>
            <h:outputText value="N�mero Documento" styleClass="labelTextOblig"  rendered="#{certificadoAsistenciaBean.mostrarAcomp}"/>
            </h:panelGroup>
            <h:panelGroup>
            <h:outputText value="Nombres  Apellidos Acompa�ante"  rendered="#{certificadoAsistenciaBean.mostrarAcomp}"
                          styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="tipoIde" required="true"   
                               rendered="#{certificadoAsistenciaBean.mostrarAcomp}"
                               disabled="#{certificadoAsistenciaBean.modoconsulta}"
                               value="#{certificadoAsistenciaBean.certificado.hcmetipoideaco}">
                <f:selectItems value="#{certificadoAsistenciaBean.listTipoIdentificacion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="tipoIde" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="idtipo"   rendered="#{certificadoAsistenciaBean.mostrarAcomp}"
                           disabled="#{certificadoAsistenciaBean.modoconsulta}"
                           value="#{certificadoAsistenciaBean.certificado.hcmanumideacom}"
                           required="true"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idtipo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itNombreAcompa�ante" style="width:250px"
                          disabled="#{certificadoAsistenciaBean.modoconsulta}"
                           maxlength="60"   rendered="#{certificadoAsistenciaBean.mostrarAcomp}"
                           value="#{certificadoAsistenciaBean.certificado.hcmcnombreacom}"/>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridCertificadoTexto"
                       rowClasses="labelText,labelTextInfo">
               
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesCertificadoAsistencia"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <a4j:commandButton value="Generar Certificado Asistencia"
                                   styleClass="boton_fieldset"
                                   disabled="#{certificadoAsistenciaBean.modoconsulta}"
                                   reRender="panelGridCertificadoAsistenciaTab"
                                   action="#{certificadoAsistenciaBean.generarCertificado}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid></h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionCertificadoAsistenciaMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationCertificadoAsistenciaMsg"
                              showSummary="true" errorClass="error"
                              globalOnly="true" layout="table"
                              infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <f:subview id="generarCertificadoAsistencia"
                       rendered="#{certificadoAsistenciaBean.generoCertificado}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
              </f:verbatim>
            </f:subview>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>