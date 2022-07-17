<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formResumenInformeEspecificoMamografia">
  <a4j:region id="regionResumenInformeEspecificoMamografia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResumenInformeEspecificoMamografia">
      <f:facet name="start">
        <t:div id="chargingResumenInformeEspecificoMamografia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <script>
       //Ejecuta una acci�n
  function execute(form,page_)
  {   
    (document.getElementById('body:formResumenInformeEspecificoMamografia')).pagina.value=page_;
    (document.getElementById('body:formResumenInformeEspecificoMamografia')).submit();

   } 
  
</script>
    <h:panelGrid columns="2" id="tableBodyGeneralResumenInformeEspecificoMamografia" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentResumenInformeEspecificoMamografia">
        <h:panelGrid columns="1" id="tableInfoUbicationResumenInformeEspecificoMamografia" border="0" cellpadding="0" cellspacing="0" width="100%"
                     columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >> Informe Mamografia >> Resumen Historia InformeMamografia "
                        id="infoUbication"/>
        </h:panelGrid>
       <jsp:include page="/pages/clinico/comunes/resumen/resumenHistoriaControl.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/consultorio/menuInformeMamografia.jsp" flush="true"/>
    </h:panelGrid>
   <f:verbatim>
      <input id="pagina" type="hidden" name="pagina"/>
    </f:verbatim>
  </a4j:region>
</a4j:form>