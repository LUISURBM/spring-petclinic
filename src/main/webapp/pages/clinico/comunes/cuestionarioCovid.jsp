<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCuestionarioCovidTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneCuestionarioCovid" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCuestionarioCovid" label="Cuestionario Covid">
     <s:fieldset legend="Sintomas" id="fieldCuestionarioCovid" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="1000px"
                       id="panelCuestionarioCovid" rowClasses="labelText,labelTextInfo">
          
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="800px"
                         id="panelGridCuestionarioCovid" rowClasses="standardTable_Row3,standardTable_Row3"
                         style="border-color:#3f3e23;">
              <h:outputText value="¿Ha presentado algunos de estos síntomas en los últimos 14 días? " styleClass="labelTextOblig"/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectManyCheckbox required="true" style="border-style:none;" immediate="true"
                                        id="mnuSintomas" disabled="#{cuestionarioCovidBean.existeEncuesta}"
                                        value="#{cuestionarioCovidBean.lstSintomasSelect}"
                                        valueChangeListener="#{cuestionarioCovidBean.setLstSintomasSelect}"
                                        layout="pageDirection">
                    <f:selectItems value="#{cuestionarioCovidBean.lstSintomas}"/>
                    <a4j:support id="supportmnuSintomas" event="onclick" immediate="true"
                                 action="#{cuestionarioCovidBean.changeSintomas}"
                                 reRender="panelGridCuestionarioCovid">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectManyCheckbox>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuSintomas" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelCualSintoma" rendered="#{cuestionarioCovidBean.renderOtroSintoma}">
                <h:outputText value="Cúal? " styleClass="labelTextOblig"
                
                              rendered="#{cuestionarioCovidBean.renderOtroSintoma}"/>
                <h:inputText id="itSintoma" style="width:300px" maxlength="80" required="true"
                 disabled="#{cuestionarioCovidBean.existeEncuesta}"
                             rendered="#{cuestionarioCovidBean.renderOtroSintoma}"
                             value="#{cuestionarioCovidBean.cuestionario.ceccsintcual}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itSintoma" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
            </s:fieldset>
            
         <s:fieldset legend="Cuestionario" id="fieldCuestionarioCovid2" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" 
                         id="panelGridCuestionarioCovidSintomas2" rowClasses="standardTable_Row3,standardTable_Row4"
                         style="border-color:#3f3e23;">
                         
                <h:outputText value = "¿Ha tenido contacto estrecho (sin tapabocas, con una distancia menor a 2 metros o por más de 15 minutos) con una persona sospechosa o positiva con COVID en los últimos 14 días" styleClass="labelTextOblig"/>
                <h:panelGroup>
                <h:selectOneRadio id = "menuContactoEstrecho" required="true" 
                 disabled="#{cuestionarioCovidBean.existeEncuesta}"
                            value="#{cuestionarioCovidBean.cuestionario.cecccontestr}"> 
                <f:selectItems value = "#{cuestionarioCovidBean.lstOpciones}"/>
                </h:selectOneRadio>
                                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuContactoEstrecho" styleClass="errorMessage"/>
            </a4j:outputPanel>
                </h:panelGroup>
                
                <h:outputText value = "Si es personal de la salud o de una ocupación de alta movilidad (personas que requieren movilizarse a diferentes zonas de los municipios o entre municipios) ¿ha tenido contacto con un caso confirmado o probable? Recuerde que se considera contacto, una exposición a aerosoles sin respirador de alta eficiencia o atención clínica sin EPP" styleClass="labelTextOblig"/>
                <h:panelGroup>
                <h:selectOneRadio id = "menuMovilidad" required="true" 
                 disabled="#{cuestionarioCovidBean.existeEncuesta}"
                                    value="#{cuestionarioCovidBean.cuestionario.cecccontprob}">
                <f:selectItems value = "#{cuestionarioCovidBean.lstOpciones}"/>
                </h:selectOneRadio>
                               
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMovilidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
                
                </h:panelGroup>
                
                <h:outputText value = "¿Usted ha sido diagnosticado con COVID-19? " styleClass="labelTextOblig"/>
                  <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id = "mnuDiagnosticadoCovid" immediate="true"
                 disabled="#{cuestionarioCovidBean.existeEncuesta}"
                required="true" value = "#{cuestionarioCovidBean.cuestionario.ceccdiagcovi}"
                valueChangeListener="#{cuestionarioCovidBean.setCeccdiagcovi}">
                <f:selectItems value = "#{cuestionarioCovidBean.lstOpciones}"/>
                  <a4j:support id="supportmnuCovid" event="onclick" immediate="true"
                                 action="#{cuestionarioCovidBean.changeDiagnostico}"
                                 reRender="panelTextSigueCuarentena,panelMenuSigueCuarentena">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                
                </h:selectOneRadio>
                
                  <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuDiagnosticadoCovid" styleClass="errorMessage"/>
            </a4j:outputPanel>
            </a4j:region>
                </h:panelGroup>
                
                <h:panelGroup id = "panelTextSigueCuarentena">
                <h:outputText value = "¿Sigue en cuarentena?   " styleClass="labelTextOblig" 
                rendered="#{cuestionarioCovidBean.renderSigueCuarentena}"/>
                </h:panelGroup>
            <h:panelGroup id ="panelMenuSigueCuarentena">
              <h:selectOneRadio id = "menuSigueCuarentena" required="true"
              rendered="#{cuestionarioCovidBean.renderSigueCuarentena}"
               disabled="#{cuestionarioCovidBean.existeEncuesta}"
                        value="#{cuestionarioCovidBean.cuestionario.ceccsigucuar}">
                <f:selectItems value = "#{cuestionarioCovidBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuSigueCuarentena" styleClass="errorMessage"/>
            </a4j:outputPanel>
                
                </h:panelGroup>
                
                         
                         </h:panelGrid>
                         
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="1000px"
                       id="panelCuestionarioCovidConducta" rowClasses="labelText,labelTextInfo">
                       
                       <h:outputText value = "Conducta" styleClass="labelTextOblig"/>
                       <h:panelGroup id = "panelMenuConducta">
                       <h:selectOneMenu id="mnuConducta" style="width:350px"
                       required="true"  disabled="#{cuestionarioCovidBean.existeEncuesta}"
                       value="#{cuestionarioCovidBean.cuestionario.ceccconducta}">
                       <f:selectItems value = "#{cuestionarioCovidBean.lstConducta}"/>
                       </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuConducta" styleClass="errorMessage"/>
            </a4j:outputPanel>
                       
                       
                       </h:panelGroup>
         <h:outputText value = "Observaciones" />    
            <h:panelGroup>
                <h:inputTextarea id="textObservaciones"  disabled="#{cuestionarioCovidBean.existeEncuesta}" value="#{cuestionarioCovidBean.cuestionario.ceccobservac}" style="width:400px"/>
                                 
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textObservaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>
              </h:panelGroup>
                       
                       
            </h:panelGrid>
            
          </s:fieldset>
          
      
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionCuestionarioCovidMsg" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationCuestionarioCovidMsg" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                   columnClasses="panelGridBotones">
        <h:commandButton value="Guardar Cuestionario Covid" styleClass="btn btn btn-success"
                           action="#{cuestionarioCovidBean.guardar}"/>
      </h:panelGrid>
    
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>