<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoEditarTemaForm">
  <a4j:region id="bodyRegionEditarTema">
    <a4j:status for="bodyRegionEditarTema">
      <f:facet name="start">
        <t:div id="chargindEditarTema" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEditarTema" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">

    
     <t:panelTab id="panelTabEditarTema" label="Editar Tema">
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Editar Tema" id="fieldSetInfoEditarTema" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionEditarTema"
                     rowClasses="labelText,labelTextInfo">      
                     
                     <h:outputText value = "Codigo Tema" styleClass="labelTextOblig"/>
                     <h:outputText/>
                     <h:outputText value = "Descripción Tema" styleClass="labelTextOblig"/>
                     <h:outputText/>
                     
                     <h:outputText id="itCodigoEditarTema" 
                            value = "#{registrarTemaBean.temaUpdate.hptncodigo}"/>
                    <h:outputText/>

                            
                    <h:inputText id = "itDescripcionEditarTema" style="width:400px" 
                        maxlength="60" required="true"
                        value = "#{registrarTemaBean.temaUpdate.hptcdescripcio}"/>
                       <a4j:outputPanel ajaxRendered="true">
              <t:message for="itDescripcionEditarTema" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
            
             <h:outputText value = "Estado" styleClass="labelTextOblig"/>
             <h:outputText/>
             <h:outputText/>
            <h:outputText/>
            
            <h:selectOneRadio id = "mnuEstado" required="true"
                value = "#{registrarTemaBean.temaUpdate.hptcestado}">
                <f:selectItems value = "#{registrarTemaBean.lstEstado}"/>
            </h:selectOneRadio>
            
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEstado" styleClass="errorMessage"/>
            </a4j:outputPanel>

          
        </h:panelGrid>
           <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonEditarTema"
      columnClasses="panelGridBotones">
        <h:commandButton value="Modificar" styleClass="boton"  
                           action="#{registrarTemaBean.modificarTema}"/>
      </h:panelGrid>
      </s:fieldset>
      </a4j:region>
      
         
    </t:panelTab>
    </t:panelTabbedPane>
     <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesEditarTema" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfEditarTema" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      
  </a4j:region>
</a4j:form>