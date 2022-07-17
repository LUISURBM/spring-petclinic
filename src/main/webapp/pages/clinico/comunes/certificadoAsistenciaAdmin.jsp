<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCertificadoAsistenciaTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneCertificadoAsistencia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCertificadoAsistencia" label="Certificado Asistencia Administrativo">
      <s:fieldset legend="Datos Basicos" id="fieldCertificadoAsistencia" styleClass="fieldset">
         <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCertificadoAcom" rowClasses="labelText,labelTextInfo">
          <h:panelGroup>
            <h:outputText value="Tipo Documento" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="N�mero Documento" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Nombre Completo" styleClass="labelTextOblig"/>
          </h:panelGroup>
          
          <h:panelGroup>
            <h:selectOneMenu id="tipoIde" required="true" 
                            onkeydown="return blockEnter(event);"
                             value="#{certAsistenciaAdminBean.tipoId}">
              <f:selectItems value="#{certAsistenciaAdminBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="idtipo" onkeydown="return blockEnter(event);"  maxlength="17"
                         value="#{certAsistenciaAdminBean.numId}" required="true"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="idtipo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itNombreAcompa�ante" onkeydown="return blockEnter(event);" 
                         style="width:250px" 
                         maxlength="60"
                         value="#{certAsistenciaAdminBean.nombres}"/>
          </h:panelGroup>
        </h:panelGrid>
        
        <h:panelGrid columns="1">
            <h:outputText value="Motivo Certificado" styleClass="labelTextOblig"/>
            <h:inputTextarea id="itdescripcionCert" style="width:355%;"
                         value="#{certAsistenciaAdminBean.descrpcionCertificado}"/>
          </h:panelGrid>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionCertificadoAsistenciaMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationCertificadoAsistenciaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                      warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
        <a4j:commandLink value="Generar Certificado Asistencia" styleClass="btn btn btn-success"  reRender="panelGridCertificadoAsistenciaTab"
                           action="#{certAsistenciaAdminBean.generarCertificado}"/>
      </h:panelGrid>
       <f:subview id="generarCertificadoAsistencia"
                       rendered="#{certAsistenciaAdminBean.generoCertificado}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
              </f:verbatim>
            </f:subview>

    </t:panelTab>
  </t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>