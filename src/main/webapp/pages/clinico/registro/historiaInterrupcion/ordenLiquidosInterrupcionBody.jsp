<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formOrdenLiquidoInterrupcion">
  <a4j:region id="regionOrdenLiquidoInterrupcion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionOrdenLiquidoInterrupcion">
      <f:facet name="start">
        <t:div id="chargingOrdenLiquidoInterrupcion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="2" id="tableBodyGeneralLiquidoInterrupcion" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentLiquidoInterrupcion">
        <h:panelGrid columns="1" id="tableInfoUbicationLiquidoInterrupcion" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Cirugias >> Historia Interrupcion >> Conducta >> Ordenes Médicas (Liquidos) " id="infoUbicationLiquidosInterrupcion"/>
        </h:panelGrid>
        <jsp:include page="/pages/clinico/comunes/formularLiquidos.jsp" flush="true"/>
      </h:panelGroup>
         <jsp:include page="/pages/menus/consultorio/menuHistoriaInterrupcion.jsp" flush="true"/>
    </h:panelGrid>
    
  </a4j:region>
</a4j:form>