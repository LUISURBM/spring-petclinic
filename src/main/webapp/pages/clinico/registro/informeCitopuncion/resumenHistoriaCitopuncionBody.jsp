<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formResumenInformeCitopuncion">
  <a4j:region id="regionResumenInformeCitopuncion" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionResumenInformeCitopuncion">
      <f:facet name="start">
        <t:div id="chargingResumenInformeCitopuncion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
      <script>
       //Ejecuta una acci?n
  function execute(form,page_)
  {   
    (document.getElementById('body:formResumenInformeCitopuncion')).pagina.value=page_;
    (document.getElementById('body:formResumenInformeCitopuncion')).submit();

   } 
  
</script>
    <h:panelGrid columns="2" id="tableBodyGeneralResumenInformeCitopuncion" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentResumenInformeCitopuncion">
        <h:panelGrid columns="1" id="tableInfoUbicationResumenInformeCitopuncion" border="0" cellpadding="0" cellspacing="0" width="100%"
                     columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Consulta >> Informe Citopunci?n >> Resumen Historia (Total) "
                        id="infoUbication"/>
        </h:panelGrid>
       <jsp:include page="/pages/clinico/comunes/resumen/resumenHistoriaTotalDetallada.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/consultorio/menuInformeCitopuncion.jsp" flush="true"/>
    </h:panelGrid>
    <f:verbatim>
      <input id="pagina" type="hidden" name="pagina"/>
    </f:verbatim>
  </a4j:region>
</a4j:form>