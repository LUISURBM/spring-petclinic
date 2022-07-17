<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesVasectomiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentesVasectomia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesVasectomia" label="Otros Antecedentes">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsAntecedentesVasectomias" styleClass="tabContainer">
          
    
    
    
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelAntecedentes"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Se le ha realizado una vasectomía antes?"
                            styleClass="labelTextOblig"/>
             <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAntecedentes" immediate="true"
                                required="true" onkeydown="return blockEnter(event);"
                                value="#{antecedentesVasectomiaBean.antecedente.havcvaseante}"
                                valueChangeListener="#{antecedentesVasectomiaBean.setNuevosAntecedentes}">
                <f:selectItems value="#{antecedentesVasectomiaBean.lstOpciones}"/>
                <a4j:support id="supportmnuAntecedentes" event="onclick"
                             
                             action="#{antecedentesVasectomiaBean.changeOtrosAntecedentes}"
                             reRender="tableContentTabsAntecedentesVasectomias">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentes" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
              </a4j:region>
            </h:panelGrid>
            
          
         <s:fieldset legend="Otros Antecedentes" id="fieldAntecedentesSeleccion"
                      styleClass="fieldset" rendered="#{antecedentesVasectomiaBean.mostrarAntecedentes}"  > 
          
       <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelOtroAntecedentesRender"
                         rowClasses="labelText,labelTextInfo" >
           
    
              <h:outputText value="Cuantas Vasectomias Previas?"
                            styleClass="labelTextOblig"/>
                <h:outputText value=""/>            
               <h:outputText value="Razon por cual requiere un nuevo procedimiento"
                            styleClass="labelTextOblig"/> 
                <h:outputText value=""/> 
                <h:panelGroup id="panelCual" >
                <h:outputText value="Cuál?" rendered="#{antecedentesVasectomiaBean.mostrarOtraRazon}"
                            styleClass="labelTextOblig"/>
                </h:panelGroup>            
                 <h:outputText value=""/> 
               <h:inputText maxlength="2" id="vasecPrevi" value="#{antecedentesVasectomiaBean.antecedente.havnvaseprev}" styleClass="input-mini"/> 
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecPrevi" styleClass="errorMessage"/>
                </a4j:outputPanel>  
               <h:selectOneMenu id="selectVasec" value = "#{antecedentesVasectomiaBean.antecedente.havcrazoproc}"> 
                     <f:selectItem itemValue = "" itemLabel = " Seleccione una Opción ..." />  
                     <f:selectItem itemValue = "EP" itemLabel = "Embarazo de pareja" /> 
                     <f:selectItem itemValue = "EF" itemLabel = "Espermograma con evidencia de falla" /> 
                     <f:selectItem itemValue = "HA" itemLabel = "Hallazgo anatómico que requiere nueva intervención"/>
                     <f:selectItem itemValue = "OT" itemLabel = "Otro"/>
                       <a4j:support id="supportselectVasec" event="onchange"
                             action="#{antecedentesVasectomiaBean.changeOtraRazon}"
                             reRender="panelOtro,panelCual">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="supportselectVasec" styleClass="errorMessage"/>
                </a4j:outputPanel>
               </h:selectOneMenu> 
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="selectVasec" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                <h:panelGroup id="panelOtro" >
               <h:inputText value="#{antecedentesVasectomiaBean.antecedente.havcrazocual}" id="vasecCual" rendered="#{antecedentesVasectomiaBean.mostrarOtraRazon}"/>
               </h:panelGroup>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecCual" styleClass="errorMessage"/>
                </a4j:outputPanel>    
                
              
                 </h:panelGrid>
              </s:fieldset>
                 <s:fieldset legend="Información Antecedentes" id="fieldAntecedentesSeleccion2"
                      styleClass="fieldset" > 
                 <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelOtroAntecedentesRender2"
                         rowClasses="labelText,labelTextInfo" >
                 <h:outputText value="Numero de hijos biologicos del paciente"
                            styleClass="labelTextOblig"/>
                <h:outputText value=""/>            
               <h:outputText value="Hijos biologicos de la pareja del paciente"
                            styleClass="labelTextOblig"/> 
                <h:outputText value=""/> 
                <h:outputText value=""
                            />             
                 <h:outputText value=""/> 
                 
                 <h:inputText maxlength="2" id="vasecNhijos" value="#{antecedentesVasectomiaBean.antecedente.havnbiolpaci}" styleClass="input-mini" required="true"/> 
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecNhijos" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                 <h:inputText maxlength="2" id="vasecNhijosPa" value="#{antecedentesVasectomiaBean.antecedente.havnbiolpare}" styleClass="input-mini" required="true"/> 
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecNhijosPa" styleClass="errorMessage"/>
                </a4j:outputPanel>    
              <h:outputText value=""/>  
                <h:outputText value=""/>    
                
               <h:outputText value="Hijos biologicos que tengan juntos"
                            styleClass="labelTextOblig"/>
                <h:outputText value=""/>            
               <h:outputText value="Qué Metodo Anticonceptivo usa usted o su pareja?"
                            styleClass="labelTextOblig"/> 
                <h:outputText value=""/> 
                <h:panelGroup id="panelOtroLabel">
                  <h:outputText value="Cuál?" rendered="#{antecedentesVasectomiaBean.mostrarOtroMetodo}"
                            styleClass="labelTextOblig"/>             
                 </h:panelGroup>
                 <h:outputText value=""/> 
                 
                 <h:inputText maxlength="2" id="vasecJuntos" value="#{antecedentesVasectomiaBean.antecedente.havnbioljunt}" styleClass="input-mini" required="true"/> 
               <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecJuntos" styleClass="errorMessage"/>
                </a4j:outputPanel>  
                  <h:selectOneMenu id="vasecMeAn" value = "#{antecedentesVasectomiaBean.antecedente.havcmetoplan}" required="true"> 
                     <f:selectItem itemValue = "" itemLabel = " Seleccione una Opción ..." />  
                     <f:selectItem itemValue = "PR" itemLabel = "Preservativo" /> 
                     <f:selectItem itemValue = "OR" itemLabel = "Oral" /> 
                     <f:selectItem itemValue = "IN" itemLabel = " Inyectable"/>
                     <f:selectItem itemValue = "IS" itemLabel = "ISD"/>
                     <f:selectItem itemValue = "DI" itemLabel = "DIU"/>
                     <f:selectItem itemValue = "OT" itemLabel = "Otro"/>
                      <a4j:support id="supportvasecMeAn" event="onchange"
                             action="#{antecedentesVasectomiaBean.ChangeOtroMetodo}"
                             reRender="panelOtroMeto,panelOtroLabel">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="supportvasecMeAn" styleClass="errorMessage"/>
                </a4j:outputPanel>
               </h:selectOneMenu> 
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecMeAn" styleClass="errorMessage"/>
                </a4j:outputPanel>         
                 <h:panelGroup id="panelOtroMeto">
                 <h:inputText id="vasecCuale" value="#{antecedentesVasectomiaBean.antecedente.havcotrometo}" rendered="#{antecedentesVasectomiaBean.mostrarOtroMetodo}" maxlength="40" required="true"/>
                 </h:panelGroup>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="vasecCuale" styleClass="errorMessage"/>
                </a4j:outputPanel>  
               </h:panelGrid>
              </s:fieldset>
              
             
               <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonModificar"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                  action="#{antecedentesVasectomiaBean.aceptar}" >
                    <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
        
       
           
       
            
            
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>