<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="formIngresoLiquidos">
  <a4j:region id="regionIngresoLiquidos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionIngresoLiquidos">
      <f:facet name="start">
        <t:div id="chargingIngresoLiquidos" styleClass="progress">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoIngresoLiquidos" border="0" cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Registros Enfermeria >> Liquidos " id="infoUbication"/>
    </h:panelGrid>
    <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <jsp:include page="/pages/clinico/cirugia/registro/enfermera/comun/adicionarLiquido.jsp" flush="true"/>
    <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
                   displayAtDistanceX="20" displayAtDistanceY="1">
            <h:commandLink id="imprimirReporte" immediate="true" action="#{controlLiquidosBean.generarReporte}">
        <t:graphicImage alt=""  border="0" url="/comun/imagenes/pdfIcon.png"/>
    </h:commandLink> 
            <f:facet name="popup">
              <h:panelGroup>
                <h:panelGrid columns="2" style="text-align:left;">
                 <h:outputText value="IMPRIMIR CONTROL DE LIQUIDOS"/>
                </h:panelGrid>
              </h:panelGroup>
            </f:facet>
          </t:popup>
   
              
 
   
  </a4j:region>
  <h:panelGrid></h:panelGrid>
</a4j:form>