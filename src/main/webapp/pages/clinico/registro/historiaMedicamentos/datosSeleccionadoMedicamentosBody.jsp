<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formDatosUsuarios">
  <a4j:region id="regionDatosUsuariosMedicamentos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionDatosUsuariosMedicamentos">
      <f:facet name="start">
        <t:div id="chargingDatosMedicamentos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneralMedicamentos" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContent">
        <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >>  Historia Aplicacion Medicamentos >> Servicios Seleccionados " id="infoUbication"/>
        </h:panelGrid>
            <jsp:include page="/pages/clinico/comunes/datosSeleccionadoMedicamento.jsp" flush="true"/>
      </h:panelGroup>
     </h:panelGrid>
   
  </a4j:region>
</a4j:form>