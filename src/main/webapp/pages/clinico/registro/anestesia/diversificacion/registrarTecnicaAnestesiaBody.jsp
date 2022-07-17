<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formTecnicaAnestesia">
  <a4j:region id="regionTecnicaAnestesia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionTecnicaAnestesia">
      <f:facet name="start">
        <t:div id="chargingTecnicaAnestesia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
    <h:panelGrid columns="2" id="tableBodyGeneralTecnicaAnestesia" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
      <h:panelGroup id="tableGroupContentTecnicaAnestesia">
        <h:panelGrid columns="1" id="tableInfoUbicationTecnicaAnestesia" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
          <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Registro Anestesia >> Técnica Anestesia " id="infoUbication"/>
        </h:panelGrid>
        <jsp:include page="/pages/clinico/cirugia/registro/anestesia/comun/registrarTecnicaAnestesia.jsp" flush="true"/>
      </h:panelGroup>
      <jsp:include page="/pages/menus/cirugia/menuAnestesia.jsp" flush="true"/>
    </h:panelGrid>
   
  </a4j:region>
</a4j:form>