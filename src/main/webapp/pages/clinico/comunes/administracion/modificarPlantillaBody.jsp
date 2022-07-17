<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="ModificarPlantillaForm">
  <a4j:region id="bodyRegionModificarPlantilla">
    <a4j:status  id = "statusButton" for="bodyRegionModificarPlantilla">
      <f:facet name="start">
        <t:div id="charginModificarPlantilla" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridModificarPlantillasTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneModificarPlantillas" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabModificarPlantillas" label="Modificar Plantilla">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridModificarPlantilla">
        <s:fieldset legend="Datos Plantilla " id="fieldSetModificarPlantilla" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosModificarPlantilla" rowClasses="labelText,labelTextInfo">
              <h:outputText id ="otPlantillaModificar" value = "Nombre Plantilla"  styleClass="labelTextOblig"/>           
              <h:outputText/>
              <h:inputText id ="itPlantillaModificar" required="true"
                  value = "#{administrarPlantillaBean.plantillaMod.hplcnombrplant}" style="width:300px"/>           
              <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itPlantillaModificar" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              <h:outputText id ="otDescripcionModificarPlantilla" value = "Descripción Plantilla"  styleClass="labelTextOblig"/>   
              <h:outputText/>
              <h:inputTextarea id ="itDescripcionModificarPlantilla" 
                    style="width:800px;height:100px" required="true"
                    value = "#{administrarPlantillaBean.plantillaMod.hplcdescripcio}"/>           
               <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDescripcionModificarPlantilla" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
          </h:panelGrid>
          
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonModificarPlantila" columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <h:commandButton value="Modificar" styleClass="boton_fieldset"
                                   action="#{administrarPlantillaBean.modificarPlantilla}">
                                   <a4j:support event="onclick" status="statusButton"/>
                                   </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
        </s:fieldset>
    
      </h:panelGrid>
    </t:panelTab>  
  </t:panelTabbedPane>
  </h:panelGrid>
  </a4j:region>
</a4j:form>