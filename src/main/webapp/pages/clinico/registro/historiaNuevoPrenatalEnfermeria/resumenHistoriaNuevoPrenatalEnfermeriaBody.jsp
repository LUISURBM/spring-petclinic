<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formResumenNuevoPrenatal">
  <a4j:region id="regionResumenNuevoPrenatal" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResumenNuevoPrenatal">
      <f:facet name="start">
        <t:div id="chargingResumenNuevoPrenatal" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
       <script>
       //Ejecuta una acción
  function execute(form,page_)
  {   
    (document.getElementById('body:formResumenNuevoPrenatal')).pagina.value=page_;
    (document.getElementById('body:formResumenNuevoPrenatal')).submit();

   } 
  
</script>
    
    <h:panelGrid columns="2" id="tableBodyGeneralResumenNuevoPrenatal" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentResumenNuevoPrenatal">
        <h:panelGrid columns="1" id="tableInfoUbicationResumenNuevoPrenatal" border="0" cellpadding="0" cellspacing="0" width="100%"
                     columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >> Historia Nuevo Prenatal Enfermeria >> Resumen Historia (Total)"
                        id="infoUbication"/>
        </h:panelGrid>
       <jsp:include page="/pages/clinico/comunes/resumen/resumenHistoriaTotalDetallada.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/consultorio/menuNuevoPrenatalEnfermeria.jsp" flush="true"/>
    </h:panelGrid>
    <f:verbatim>
      <input id="pagina" type="hidden" name="pagina"/>
    </f:verbatim>
  </a4j:region>
</a4j:form>