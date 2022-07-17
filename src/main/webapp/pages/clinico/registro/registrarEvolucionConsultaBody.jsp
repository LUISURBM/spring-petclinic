<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="registrarEvolucionConsultaForm">
  <a4j:region id="bodyRegionRegistrarEvolucionConsulta">
    <a4j:status  id = "statusButton" for="bodyRegionRegistrarEvolucionConsulta">
      <f:facet name="start">
        <t:div id="chargindRegistrarEvolucionConsulta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsRegistrarEvolucionConsulta"
                     styleClass="tabContainerRegistrarEvolucionConsulta">
      <t:htmlTag value="br"/>
      <s:fieldset legend="Registrar Evolución Consulta " id="fieldRegistrarEvolucionConsulta"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegistrarEvolucionConsulta"
                     rowClasses="labelText">
      
          <h:outputText value="Evolución" styleClass="labelTextOblig"/>
          <h:outputText/>
       
          
          <h:panelGroup>
            <h:inputTextarea id="textEvolucionConsulta" required="true"
                             value="#{registrarEvolucionConsultaBean.evolucion.heccdescripc}"
                             style="width:500px;height:70px"/>
          
          </h:panelGroup>
          
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textEvolucionConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
    
     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBotonRegistrarEvolucionConsulta"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
            onclick="if (!confirm(\'¿Realmente desea Crear la Evolucion\')) return false"
                               action="#{registrarEvolucionConsultaBean.aceptar}">
                   <a4j:support event="onclick" status="statusButton"/>            
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
    
    
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>

    
      

  </a4j:region>
</a4j:form>