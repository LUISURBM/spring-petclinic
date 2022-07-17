<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="formFormulaHospitalizacion">
  <a4j:region id="regionFormulaHospitalizacion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionFormulaHospitalizacion">
      <f:facet name="start">
        <t:div id="chargingFormulaHospitalizacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
    <jsp:include page="/pages/clinico/cirugia/registro/enfermera/comun/adicionarMedicamento.jsp" flush="true"/>
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridFormulaHospitalizacionTab" styleClass="tabContainer">
     
     
     
        <h:commandLink action="irListaNotasEnfermeria" immediate="true">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
          </h:commandLink>
     
      <h:commandLink id="imprimirReporte" immediate="true" action="#{registrarMedicamentosBean.generarReporte}">
        <t:graphicImage alt="" border="0" url="/comun/imagenes/print_Spa.gif" style="text-align:right"/>
      </h:commandLink>
      <f:subview id="generarContLiq" rendered="#{registrarMedicamentosBean.generoReporte}">
        <f:subview id="generarReporteContLiq" rendered="#{registrarMedicamentosBean.generoReporte}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                    window.open("<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=1200,height=900");
                </script>
          </f:verbatim>
        </f:subview>
      </f:subview>
    </h:panelGrid>
  </a4j:region>
</a4j:form>