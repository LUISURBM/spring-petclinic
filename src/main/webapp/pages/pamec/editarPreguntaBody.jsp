<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoEditarPreguntaForm">
  <a4j:region id="bodyRegionEditarPregunta">
    <a4j:status for="bodyRegionEditarPregunta">
      <f:facet name="start">
        <t:div id="chargindEditarPregunta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
     <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneEditarPregunta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">

    
     <t:panelTab id="panelTabEditarPregunta" label="Editar Pregunta">
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Editar Tema" id="fieldSetInfoEditarPregunta" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionEditarPregunta"
                     rowClasses="labelText,labelTextInfo">      
                     
                     <h:outputText value = "Codigo Pregunta" styleClass="labelTextOblig"/>
                     <h:outputText/>
                     <h:outputText value = "Descripción Pregunta" styleClass="labelTextOblig"/>
                     <h:outputText/>
                     
                     <h:outputText id="itCodigoEditarPregunta" 
                            value = "#{registrarPreguntaBean.preguntaUpdate.id.hppncodigo}"/>
                    <h:outputText/>

                            
                    <h:inputTextarea id = "itDescripcionEditarPregunta"  style="width:400px;height:50px"  required="true"
                        value = "#{registrarPreguntaBean.preguntaUpdate.hppcdescripcio}">
                           <f:validateLength maximum="500" />
                    </h:inputTextarea>
                       <a4j:outputPanel ajaxRendered="true">
              <t:message for="itDescripcionEditarPregunta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
             <h:outputText value = "Estado" styleClass="labelTextOblig"/>
             <h:outputText/>
             <h:outputText/>
            <h:outputText/>
            
            <h:selectOneRadio id = "mnuEstado" required="true"
                value = "#{registrarPreguntaBean.preguntaUpdate.hppcestado}">
                <f:selectItems value = "#{registrarPreguntaBean.lstEstado}"/>
            </h:selectOneRadio>
            
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEstado" styleClass="errorMessage"/>
            </a4j:outputPanel>

          
        </h:panelGrid>
           <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonEditarPregunta"
      columnClasses="panelGridBotones">
        <h:commandButton value="Modificar" styleClass="boton"  
                           action="#{registrarPreguntaBean.modificarPregunta}"/>
      </h:panelGrid>
      </s:fieldset>
      </a4j:region>
      
         
    </t:panelTab>
    </t:panelTabbedPane>
     <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesEditarPregunta" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfEditarPregunta" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      
  </a4j:region>
</a4j:form>