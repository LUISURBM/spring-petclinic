<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoEditarMaterialForm">
  <a4j:region id="bodyRegionEditarMaterial">
    <a4j:status for="bodyRegionEditarMaterial">
      <f:facet name="start">
        <t:div id="chargindEditarMaterial" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEditarMaterial" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">

    
     <t:panelTab id="panelTabEditarMaterial" label="Editar Material Instrumental">
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Editar Material" id="fieldSetInfoEditarMaterial" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionEditarMaterial"
                     rowClasses="labelText,labelTextInfo">      
                     
                     <h:outputText value = "Codigo Material" styleClass="labelTextOblig"/>
                     <h:outputText/>
                     <h:outputText value = "Descripción Material" styleClass="labelTextOblig"/>
                     <h:outputText/>
                     
                     <h:outputText id="itCodigoEditarMaterial" 
                            value = "#{registrarMaterialInstrumentalBean.materialUpdate.hmincodigo}"/>
                    <h:outputText/>

                            
                    <h:inputText id = "itDescripcionEditarMaterial" style="width:400px" 
                        maxlength="60" required="true"
                        value = "#{registrarMaterialInstrumentalBean.materialUpdate.hmicdescripcio}"/>
                       <a4j:outputPanel ajaxRendered="true">
              <t:message for="itDescripcionEditarMaterial" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
            
             <h:outputText value = "Estado" styleClass="labelTextOblig"/>
             <h:outputText/>
             <h:outputText/>
            <h:outputText/>
            
            <h:selectOneRadio id = "mnuEstado" required="true"
                value = "#{registrarMaterialInstrumentalBean.materialUpdate.hmicestado}">
                <f:selectItems value = "#{registrarMaterialInstrumentalBean.lstEstado}"/>
            </h:selectOneRadio>
            
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEstado" styleClass="errorMessage"/>
            </a4j:outputPanel>

          
        </h:panelGrid>
           <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonEditarMaterial"
      columnClasses="panelGridBotones">
        <h:commandButton value="Modificar" styleClass="btn btn btn-success"  
                           action="#{registrarMaterialInstrumentalBean.modificarMaterial}"/>
      </h:panelGrid>
      </s:fieldset>
      </a4j:region>
      
         
    </t:panelTab>
    </t:panelTabbedPane>
     <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesEditarMaterial" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfEditarMaterial" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      
  </a4j:region>
</a4j:form>