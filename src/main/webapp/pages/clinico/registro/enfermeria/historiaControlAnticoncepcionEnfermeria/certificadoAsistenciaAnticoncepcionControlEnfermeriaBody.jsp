<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formCertificadoAsistensia">
  <a4j:region id="regionCertificadoAsistensia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionCertificadoAsistensia">
      <f:facet name="start">
        <t:div id="chargingCertificadoAsistensia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneralCertificadoAsistensia" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentCertificadoAsistensia">
        <h:panelGrid columns="1" id="tableInfoUbicationCertificadoAsistensia" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta Enfermería >> Historia Anticoncepción Temporal >> Conducta >> Certificado Asistencia " id="infoUbicationCertificadoAsistensia"/>
        </h:panelGrid>
        <jsp:include page="/pages/clinico/comunes/certificadoAsistencia.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/consultorio/menuHistoriaControlAnticoncepcionEnfermeria.jsp" flush="true"/>
    </h:panelGrid>
  
  </a4j:region>
</a4j:form>