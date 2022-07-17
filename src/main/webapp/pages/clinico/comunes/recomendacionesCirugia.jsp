<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConductaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneConducta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     selectedIndex="#{recomedacionCirugiaBean.selectedIndex}"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabConducta" label="Conducta " disabled="#{recomedacionCirugiaBean.renderPlantilla}">
      <h:panelGrid columns="1" dir="LTR" cellpadding="0" cellspacing="0" border="0" width="100%" rendered="#{recomedacionCirugiaBean.mostrarIcono}">
      
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConducta" styleClass="tabContainer">
        <s:fieldset legend="Conducta" id="fieldConducta" styleClass="fieldset">
        
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="" id="panelConductaObservaciones" rowClasses="labelText,labelTextInfo ">
           
              
               <h:outputText value="Plan de Manejo" styleClass="labelTextOblig"/>
            
             <h:outputText value=""/>
                      
               <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
                  <a4j:commandLink action="#{recomedacionCirugiaBean.mostrarBuscadorPlantillaPlanManejo}" 
                  immediate="true"
                                   reRender="panelGridConductaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
              <h:inputTextarea id="textPlanManejo" required="true"
             onkeydown="return blockEnter(event);" immediate="true"
                   value="#{recomedacionCirugiaBean.conducta.hcncplanmanejo}"
                   binding="#{recomedacionCirugiaBean.itPlanManejo}"
                             style="width:500px;height:60px"/>
                </h:panelGrid>
      
                         
         
            
        
            <a4j:outputPanel ajaxRendered="true">
                <t:message for="textPlanManejo" styleClass="errorMessage"/>
              </a4j:outputPanel>
         
         
          <h:outputText value="Recomendaciones" styleClass="labelTextOblig">
           
          </h:outputText>
            <h:outputText value=""/>
           
             <h:panelGroup>
             <a4j:commandLink action="#{recomedacionCirugiaBean.generarReporte}" reRender="panelGridConductaTab" immediate="true" title="Imprimir Recomendaciones" styleClass="margin:1px 0 0 0;">
          <t:graphicImage alt="Imprimir Recomendaciones" title="Imprimir Recomendaciones" border="0" url="/comun/imagenes/pdf2.gif"/>
        </a4j:commandLink>
            <h:inputTextarea id="textObservaciones" 
             onkeydown="return blockEnter(event);" immediate="true" styleClass="align:left"
                   binding="#{recomedacionCirugiaBean.itDescripcion}"
                   required="true"
                   value="#{recomedacionCirugiaBean.conducta.hcncobservacio}"
                             style="width:500px;height:60px"/>
           
          
             </h:panelGroup>
                                 <a4j:commandLink    
                            action="#{recomedacionCirugiaBean.mostrarBuscadorPlantillaRecomendaciones}" 
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
          <h:commandButton value="Aceptar" styleClass="btn btn btn-success"   action="#{recomedacionCirugiaBean.aceptar}">
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
        rendered="#{recomedacionCirugiaBean.renderPlantilla}">
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
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
      </a4j:region>
    </t:panelTab>
     <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
  </t:panelTabbedPane>
      <f:subview id="generarRecomendaciones" rendered="#{recomedacionCirugiaBean.generoRecomendaciones}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>  
</h:panelGrid>