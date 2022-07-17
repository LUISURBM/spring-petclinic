<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConductaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneConducta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     selectedIndex="#{recomedacionUsuarioBean.selectedIndex}"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabConducta" label="Conducta " disabled="#{recomedacionUsuarioBean.renderPlantilla}">
      <h:panelGrid columns="1" dir="LTR" cellpadding="0" cellspacing="0" border="0" width="100%" rendered="#{recomedacionUsuarioBean.mostrarIcono}">
      
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConducta" styleClass="tabContainer">
        <s:fieldset legend="Conducta" id="fieldConducta" styleClass="fieldset">
        
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="" id="panelConductaObservaciones" rowClasses="labelText,labelTextInfo ">
           
              
               <h:outputText value="Plan de Manejo" styleClass="labelTextOblig" rendered="#{!recomedacionUsuarioBean.renderColposcopia}"/>
               <h:outputText value="" rendered="#{recomedacionUsuarioBean.renderColposcopia}"/>
            
             <h:outputText value=""/>
                         
              <h:inputTextarea id="textPlanManejo" required="true"
             onkeydown="return blockEnter(event);" immediate="true"
                   value="#{recomedacionUsuarioBean.conducta.hcncplanmanejo}"
                             style="width:500px;height:60px"/>
         
            
        
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textPlanManejo" styleClass="errorMessage"/>
              </a4j:outputPanel>
         
         
          <h:outputText value="Recomendaciones" styleClass="labelTextOblig">
           
          </h:outputText>
            <h:outputText value=""/>
           
             <h:panelGroup>
             <a4j:commandLink action="#{recomedacionUsuarioBean.generarReporte}" reRender="panelGridConductaTab" immediate="true" title="Imprimir Recomendaciones" styleClass="margin:1px 0 0 0;">
          <t:graphicImage alt="Imprimir Recomendaciones" title="Imprimir Recomendaciones" border="0" url="/comun/imagenes/pdf2.gif"/>
        </a4j:commandLink>
            <h:inputTextarea id="textObservaciones" 
             onkeydown="return blockEnter(event);" immediate="true" styleClass="align:left"
                   binding="#{recomedacionUsuarioBean.itDescripcion}"
                   required="true"
                   value="#{recomedacionUsuarioBean.conducta.hcncobservacio}"
                             style="width:500px;height:60px"/>
           
          
             </h:panelGroup>
                    <a4j:commandLink    
                            action="#{recomedacionUsuarioBean.mostrarBuscadorPlantilla}" 
                            immediate="true"
                            reRender="panelGridConductaTab">
                             <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                             <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
                             
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textObservaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
          
          </h:panelGrid>
        
        </s:fieldset>
           
        <h:panelGroup>
       
      
          
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
          <h:commandButton value="Aceptar" styleClass="btn btn btn-success"   action="#{recomedacionUsuarioBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
            <a4j:outputPanel id="ajaxRegionMensajesConducta" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInfConducta" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGrid>
           
      </h:panelGrid>
      
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantillaRecomendaciones" label="Buscar Plantillas" 
        rendered="#{recomedacionUsuarioBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaRecomendaciones" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaRecomendaciones">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaRecomendaciones" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaRecomendaciones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotonesPlantillaRecomendaciones">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset" 
              action="#{recomedacionUsuarioBean.aceptarPlantilla}" 
                reRender="panelGridConductaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
     <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
  </t:panelTabbedPane>
      <f:subview id="generarRecomendaciones" rendered="#{recomedacionUsuarioBean.generoRecomendaciones}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>  
</h:panelGrid>