<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formReferencia">
  <a4j:region id="regionReferencia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionReferencia">
      <f:facet name="start">
        <t:div id="chargingReferencia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneralReferencia" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentReferencia">
        <h:panelGrid columns="1" id="tableInfoUbicationReferencia" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >> Procedimientos en Consultorio >> Conducta >> Autorizacion Servicios " id="infoUbicationReferencia"/>
        </h:panelGrid>
       <jsp:include page="/pages/clinico/comunes/autorizacionServicios.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/consultorio/menuProcedimientosConsultorio.jsp" flush="true"/>
    </h:panelGrid>
  
  </a4j:region>
</a4j:form>