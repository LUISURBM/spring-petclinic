<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formCertificadoAsistensiaControl">
  <a4j:region id="regionCertificadoAsistensiaControl" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionCertificadoAsistensiaControl">
      <f:facet name="start">
        <t:div id="chargingCertificadoAsistensiaControl" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneralCertificadoAsistensiaControl" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentCertificadoAsistensiaControl">
        <h:panelGrid columns="1" id="tableInfoUbicationCertificadoAsistensiaControl" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >> Historia Psicologia (Seguimiento) >> Conducta >> Certificado Asistencia " id="infoUbicationCertificadoAsistensiaControl"/>
        </h:panelGrid>
        <jsp:include page="/pages/clinico/comunes/certificadoAsistencia.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/consultorio/menuHistoriaPsicologicaControl.jsp" flush="true"/>
    </h:panelGrid>
    </a4j:region>
</a4j:form>