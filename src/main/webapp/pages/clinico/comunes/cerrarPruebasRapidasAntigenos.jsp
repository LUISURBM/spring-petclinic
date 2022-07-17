<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
  id="panelGridCerrarConsultaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneCerrarConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCerrarConsulta" label="Cerrar Consulta">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsCerrarConsulta" styleClass="tabContainer">
        <s:fieldset legend="Datos Registrados" id="fieldCerrarConsulta" styleClass="fieldset_report">
        
     <h:panelGroup>
            <h:commandButton value="Imprimir Pruebas Rapidas" styleClass="boton_fieldset" 
                               action="#{pruebasAntigenosCovidBean.imprimirResumen}">
                <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>

           <a4j:region renderRegionOnly="false">
            <jsp:include page="/pages/clinico/consulta/mostrarCerrarConsulta.jsp" flush="true"/>
          </a4j:region>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonCerrarConsulta" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Cerrar Pruebas Rapidas" styleClass="btn btn btn-success" onclick="if (!confirm(\'�Realmente desea Cerrar la Consulta\')) return false"
                             action="#{pruebasAntigenosCovidBean.cerrarAntigenos}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
     
  </t:panelTabbedPane>
   <h:panelGrid>
      <f:subview id="generarPapPsicologia" rendered="#{pruebasAntigenosCovidBean.pruebaRealizada}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
      
    </h:panelGrid>
</h:panelGrid>
