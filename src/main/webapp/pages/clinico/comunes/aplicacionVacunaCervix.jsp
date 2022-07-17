<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAplicacionVacunaCervixTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAplicacionVacunaCervix" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAplicacionVacunaCervix" label="Aplicación Vacuna Cérvix">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridAplicacionVacunaCervix">
       
        <s:fieldset legend="Primera Dosis" id="fieldSetAplicacionPrimeraDosis" styleClass="fieldset"
        rendered="#{aplicacionVacunaCervixBean.renderprimdosis}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosAplicacionPrimeraDosis" rowClasses="labelText,labelTextInfo">
        
        <h:outputText value="Fecha y Hora de Aplicación"/> 
         <h:outputText value="Nombre quien aplico"/> 
         
          <h:outputText value = "#{aplicacionVacunaCervixBean.apliprimdosis.hcadfecregistr}">
                <f:convertDateTime pattern="dd/MM/yyyy HH:mm"/>
            </h:outputText>
         <h:outputText value = "#{aplicacionVacunaCervixBean.nombreprimdosis}"/> 
         
         <h:outputText value="Observaciones"/> 
         <h:outputText value=""/> 
         
         
         <h:outputText value = "#{aplicacionVacunaCervixBean.apliprimdosis.hcacobservacio}"/> 
         <h:outputText value=""/> 
       
       
       </h:panelGrid>
       </s:fieldset>
       
       
        <s:fieldset legend="Segunda Dosis" id="fieldSetAplicacionSegundaDosis" styleClass="fieldset"
        rendered="#{aplicacionVacunaCervixBean.rendersegudosis}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosAplicacionSegundaDosis" rowClasses="labelText,labelTextInfo">
        
        <h:outputText value="Fecha y Hora de Aplicación"/> 
         <h:outputText value="Nombre quien aplico"/> 
         
          <h:outputText value = "#{aplicacionVacunaCervixBean.aplisegudosis.hcadfecregistr}">
                <f:convertDateTime pattern="dd/MM/yyyy HH:mm"/>
            </h:outputText>
         <h:outputText value = "#{aplicacionVacunaCervixBean.nombresegudosis}"/> 
         
         <h:outputText value="Observaciones"/> 
         <h:outputText value=""/> 
         
         
         <h:outputText value = "#{aplicacionVacunaCervixBean.aplisegudosis.hcacobservacio}"/> 
         <h:outputText value=""/> 
       
       
       </h:panelGrid>
       </s:fieldset>
                   
                   
        <s:fieldset legend="Vacunación Cérvix " id="fieldSetAplicacionVacunaCervix" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosAplicacionVacunaCervix" rowClasses="labelText,labelTextInfo">
                       
            <h:outputText value="Fecha y Hora de Aplicación"/>            
            
            <h:outputText value = "Número de Dosis"/>
            <h:outputText value = "#{aplicacionVacunaCervixBean.fecharegistro}">
                <f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
            </h:outputText>
            <h:outputText value ="#{aplicacionVacunaCervixBean.numeroDosis}"/>
                       
            <h:outputText value="Observaciones"/>
            <h:outputText value= ""/>
            
            <h:inputTextarea id = "itObservaciones" style="width:500px"
                    value = "#{aplicacionVacunaCervixBean.aplicacion.hcacobservacio}">
               <f:validateLength maximum="2000"/>
            </h:inputTextarea>
            
            
            
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionAplicacionVacunaCervixMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAplicacionVacunaCervixMsg" showSummary="false" errorClass="error"
                        globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAplicacionVacunaCervix" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="boton_fieldset" 
                               action="#{aplicacionVacunaCervixBean.guardar}">
                <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>