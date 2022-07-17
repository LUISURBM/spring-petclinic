<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formOtraAsesoria">
  <a4j:region id="regionOtraAsesoria" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionOtraAsesoria">
      <f:facet name="start">
        <t:div id="chargingOtraAsesoria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyOtraAsesoria" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_fondoBarraH,verticalaligntop">
     <h:panelGroup id="tableGroupOtraAsesoria">
        <h:panelGrid columns="1" id="tableInfoOtraAsesoria" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Asesoria >> Registrar Otras Asesorias " id="infoUbicationSeguimiento"/>
        </h:panelGrid>
            <jsp:include page="/pages/asesoria/comunes/registrarOtraAsesoria.jsp" flush="true"/>
      </h:panelGroup>
      </h:panelGrid>
    
  </a4j:region>
</a4j:form>