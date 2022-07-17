<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEvaluacionGeneralTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneEvaluacionGeneral" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEvaluacionGeneral" label="Evaluación General">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsEvaluacionGeneral" styleClass="tabContainer">
      
        <s:fieldset legend="Área interpersonal" id="fieldAreaInterpersonal" styleClass="fieldset">
        <h:panelGrid columns="1">
    
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAreaInterpersonal"
                       rowClasses="labelText,labelTextInfo">
                       
            <h:outputText value="Cuenta con apoyo familiar/amigos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuApoyoFamiliarAmigos" immediate="true" required="true"
                                valueChangeListener="#{evaluacionGeneralBean.setHegcapoyofamil}"
                                value="#{evaluacionGeneralBean.evaluacion.hegcapoyofamil}">
                <f:selectItems value="#{evaluacionGeneralBean.lstOpciones}"/>
                <a4j:support id="supportApoyoFamiliarAmigos" event="onclick"
                             action="#{evaluacionGeneralBean.changeApoyoFamiliar}"
                             reRender="panelTextCualApoyo,panelInputCualApoyo,panelTextComunicacionAdicional,panelTextCualCanal,
                             mnuCanalesComunicacionOut,mnuProblemasSatisfaccionOut,mnuRelacionesApoyoOut">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuApoyoFamiliarAmigos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
           <h:panelGrid columns="2" id="panelInputCualApoyo">
            <h:outputText value="Cual?" styleClass="labelTextOblig"   rendered="#{evaluacionGeneralBean.renderApoyoFamiliar}"/>
            <h:inputTextarea id="itCualApoyo" required="true" style="width:760px"
                               value="#{evaluacionGeneralBean.evaluacion.hegccualapoyo}"
                                rendered="#{evaluacionGeneralBean.renderApoyoFamiliar}">
                <f:validateLength maximum="1000"/>
              </h:inputTextarea>
            </h:panelGrid>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCualApoyo" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
         
        <h:panelGrid columns="1" id="itDescripcionRelacionesOut">
          <h:outputText value="Descripción Relaciones sociales(problemas y apoyos de quién- describa?) " styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="itDescripcionRelaciones" required="true" style="width:800px"
                               value="#{evaluacionGeneralBean.evaluacion.hegcrelacfamil}" >
                <f:validateLength maximum="2000"/>
              </h:inputTextarea>
             </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itDescripcionRelaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
        
          <h:panelGrid columns="1" id="panelCompFamilia">
           <h:outputText value="Composicion Familiar y Dinamica Familiar" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="itDescripcionCompFamilia" required="true" style="width:800px"
                               value="#{evaluacionGeneralBean.evaluacion.hegccompfami}" >
                <f:validateLength maximum="2000"/>
              </h:inputTextarea>
             </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itDescripcionCompFamilia" styleClass="errorMessage"/>
            </a4j:outputPanel>
      </h:panelGrid>
       <h:panelGrid columns="1" id="panelDesarrolloSesion">
           <h:outputText value="Desarrollo de la sesión" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="itDescripcionDesarrolloSesio" required="true" style="width:800px"
                               value="#{evaluacionGeneralBean.evaluacion.hegcdesasesion}" >
                <f:validateLength maximum="2000"/>
              </h:inputTextarea>
             </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itDescripcionDesarrolloSesio" styleClass="errorMessage"/>
            </a4j:outputPanel>
      </h:panelGrid>
    </h:panelGrid>
      
     
          
        </s:fieldset>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesEvaluacionGeneral" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfEvaluacionGeneral" showSummary="true" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
   
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelBotonGuardarEvaluacionGeneral" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         action="#{evaluacionGeneralBean.guardarEvaluacion}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>