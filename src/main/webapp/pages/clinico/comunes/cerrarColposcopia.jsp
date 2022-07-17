<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCerrarConsultaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneCerrarConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCerrarConsulta" label="Cerrar Consulta">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsCerrarConsulta" styleClass="tabContainer">
        <s:fieldset legend="Datos Registrados" id="fieldCerrarConsulta" styleClass="fieldset_report">
         <h:commandButton value="Imprimir Colposcopia" styleClass="btn btn btn-success"
            action="#{cerrarConsultaUsuarioBean.imprimirColposcopia}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
        
          <a4j:region renderRegionOnly="false">
            <jsp:include page="/pages/clinico/consulta/mostrarCerrarConsulta.jsp" flush="true"/>
          </a4j:region>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonCerrarConsulta"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Cerrar Consulta" styleClass="btn btn btn-success"
                             onclick="if (!confirm(\'�Realmente desea Cerrar la Consulta\')) return false"
                             rendered="#{!cerrarConsultaUsuarioBean.esVacunacion}"
                             action="#{cerrarConsultaUsuarioBean.cerrarConsulta}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
          <h:panelGroup>
            <h:commandButton value="Cerrar" styleClass="btn btn btn-success"
                             rendered="#{cerrarConsultaUsuarioBean.esVacunacion}"
                             onclick="if (!confirm(\'�Realmente desea Cerrar la Vacunaci�n\')) return false"
                             action="#{cerrarConsultaUsuarioBean.cerrarVacunacion}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
<f:subview id="generarRecomendaciones" rendered="#{cerrarConsultaUsuarioBean.generoReporte}">
  <f:verbatim>
    <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
  </f:verbatim>
</f:subview>
</h:panelGrid>
