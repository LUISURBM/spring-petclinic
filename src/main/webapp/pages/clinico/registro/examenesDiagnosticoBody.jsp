<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formExamenesApoyoDiagnostico">
 <a4j:region id="regionExamenesApoyoDiagnostico" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionExamenesApoyoDiagnostico">
      <f:facet name="start">
        <t:div id="chargingExamenesApoyoDiagnostico" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

   
   <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenesDiagnosticoTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenesDiagnostico"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenesDiagnostico" label="Metodos Anticonceptivos">
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsExamenesDiagnostico"
                     styleClass="tabContainer">
      <s:fieldset legend="Metodos" id="fieldSetExamenesDiagnosticos"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelExamenesDiagnosticos1"
                     rowClasses="labelText">
                     
         
          <h:outputText value="Metodo que el Paciente desea usar:" 
                        styleClass="labelTextOblig"/>
          <h:outputText value="Contraindicaciones a Métodos Anticonceptivos -Especificar" 
                        styleClass="labelTextOblig"/>
            <h:panelGroup>
            <h:selectOneMenu id="mnuMetodo" required="true" 
                            value="#{examenesDiagnosticoBean.diagnostico.hedcmetodopaci}">
            <f:selectItems value="#{examenesDiagnosticoBean.lstMetodo}"/>
          </h:selectOneMenu>
           <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMetodo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          
            </h:panelGroup>
             
             <h:panelGroup>
            <h:inputTextarea id="textContraindicaciones" required="true" 
                             value="#{examenesDiagnosticoBean.diagnostico.hedccontraindi}"
                             style="width:400px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textContraindicaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
            <h:outputText value="Metodo sugerido:" 
                        styleClass="labelTextOblig"/>
              <h:outputText value="Dentro de los metodos anticonceptivos no contraindicados la paciente escoge libremente"
                       styleClass="labelTextOblig"/>
            
            <h:panelGroup>
            <h:selectOneMenu id="mnuMetodoSugerido" required="true" 
                            value="#{examenesDiagnosticoBean.diagnostico.hedcmetodosuge}">
            <f:selectItems value="#{examenesDiagnosticoBean.lstMetodo}"/>
          </h:selectOneMenu>
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMetodoSugerido" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </h:panelGroup>
             
          <h:panelGroup>
          <h:selectOneMenu id="mnuMetodoSolicita" required="true" 
                            value="#{examenesDiagnosticoBean.diagnostico.hedcmetodosoli}">
            <f:selectItems value="#{examenesDiagnosticoBean.lstMetodo}"/>
          </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMetodoSolicita" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificarExamenesDiagnosticos"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar"   styleClass="boton_fieldset"
                             action="#{examenesDiagnosticoBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>           
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributoExamenesDiagnosticos"
                         ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsExamenesDiagnosticos"
                      showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>