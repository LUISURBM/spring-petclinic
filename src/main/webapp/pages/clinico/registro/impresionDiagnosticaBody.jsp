<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formImpresionDiagnostica">
  <a4j:region id="regionImpresionDiagnostica" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionImpresionDiagnostica">
      <f:facet name="start">
        <t:div id="chargingImpresionDiagnostica" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   

    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridImpresionDiagnosticaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneImpresionDiagnostica"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         selectedIndex="#{impresionDiagnosticaBean.selectedIndex}"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabImpresionDiagnostica"
                    label="Impresión Diagnostica"
                    disabled="#{impresionDiagnosticaBean.mostrarCie10}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridImpresionDiagnostica"
                       styleClass="tabContainer">
            <s:fieldset legend="Tipo Diagnostico" id="fieldImpresionDiagnostica"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosImpresionDiagnostica"
                           rowClasses="labelText">
                <h:outputText value="Tipo Diagnostico "
                              styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneMenu id="tipoDiagnostico" 
                                   binding="#{impresionDiagnosticaBean.mnuTipoDiagnostico}"
                                   value="#{impresionDiagnosticaBean.diagnosticoSelect}">
                    <f:selectItems value="#{impresionDiagnosticaBean.lstTipoImpresion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoDiagnostico" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Diagnosticos Relacionados"
                        id="fieldDiagnosticos" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosImpresionDiagnostica2"
                           rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Diagnostico Principal"
                                styleClass="labelTextOblig"/>
                   
                    <a4j:commandLink styleClass="boton_fieldset" 
                                     action="#{impresionDiagnosticaBean.mostrarDiagnosticoPrincipal}"
                                     reRender="panelGridImpresionDiagnosticaTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      <t:graphicImage  alt="" border="0"
                                      url="/comun/imagenes/lupa.gif"/>
                    </a4j:commandLink> 
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Diagnostico Relacionado 1"/>
                  
                    <a4j:commandLink styleClass="boton_fieldset"  
                                     action="#{impresionDiagnosticaBean.mostrarDiagnosticoRelacionado1}"
                                     reRender="panelGridImpresionDiagnosticaTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      <t:graphicImage  alt="" border="0"
                                      url="/comun/imagenes/lupa.gif"/>
                    </a4j:commandLink>
                  
                </h:panelGroup>
                
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itDiagPrin" immediate="true" styleClass="textmayuscula"
                                 onkeydown="return blockEnter(event);" 
                                 binding="#{impresionDiagnosticaBean.itDiagprinc}"
                                 value="#{impresionDiagnosticaBean.impresion.hidcdiagprin}"
                                  valueChangeListener="#{impresionDiagnosticaBean.setHidcdiagprin}"
                                  style="width:50px"
                                 maxlength="4">
                                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                      <a4j:support id="supportitDiagPrin" event="onchange"
                                    ignoreDupResponses="true"
                                   action="#{impresionDiagnosticaBean.changeDiagnosticoPrincipal}"
                                   reRender="panelDiagnosticoPrincipal">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                       
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDiagPrin" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id = "panelDiagnosticoPrincipal">
                  <h:outputText value=" #{impresionDiagnosticaBean.diagnosticoPrincipal}"
                                styleClass="buscador"/>
                  </h:panelGroup>
                </h:panelGroup>
                
                
                <h:panelGroup>
                  <h:inputText id="itDiagnosticoRelacionado1"  styleClass="textmayuscula"
                               onkeydown="return blockEnter(event);" 
                               value="#{impresionDiagnosticaBean.impresion.hidcdiagrela1}"
                               valueChangeListener="#{impresionDiagnosticaBean.setHidcdiagrela1}"
                               binding="#{impresionDiagnosticaBean.itDiagrelac1}"
                               style="width:50px" maxlength="4">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <a4j:support id="supportDiagnosticoRelacionado1"
                                 event="onchange" 
                                 action="#{impresionDiagnosticaBean.changeDiagnosticoRelacionado1}"
                                 reRender="panelDiagnosticoRelacionado1">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                     
                  </h:inputText>
                 <h:panelGroup  id = "panelDiagnosticoRelacionado1"> 
                  <h:outputText value="  #{impresionDiagnosticaBean.diagnosticoRelacionado1}"
                                styleClass="buscador"/>
                   </h:panelGroup>             
                </h:panelGroup>
                
                <h:panelGroup>
                  
                    <h:outputText value="Diagnostico Relacionado 2"/>
                    <a4j:commandLink styleClass="boton_fieldset"  
                                     action="#{impresionDiagnosticaBean.mostrarDiagnosticoRelacionado2}"
                                     reRender="panelGridImpresionDiagnosticaTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      <t:graphicImage border="0"  alt="" 
                                      url="/comun/imagenes/lupa.gif"/>
                    </a4j:commandLink>
                  
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Diagnostico Relacionado 3"/>
                  
                    <a4j:commandLink styleClass="boton_fieldset"  
                                     action="#{impresionDiagnosticaBean.mostrarDiagnosticoRelacionado3}"
                                     reRender="panelGridImpresionDiagnosticaTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      <t:graphicImage border="0" alt="" 
                                      url="/comun/imagenes/lupa.gif"/>
                    </a4j:commandLink>
                  
                </h:panelGroup>
                
                <h:panelGroup id="panelGroupDiagnostico">
                  <h:inputText id="itDiagnosticoRelacionado2" styleClass="textmayuscula"
                               value="#{impresionDiagnosticaBean.impresion.hidcdiagrela2}"
                                binding="#{impresionDiagnosticaBean.itDiagrelac2}"
                               onkeydown="return blockEnter(event);"
                               valueChangeListener="#{impresionDiagnosticaBean.setHidcdiagrela2}"
                               style="width:50px" maxlength="4">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <a4j:support id="supportDiagnosticoRelacionado2"
                                 event="onchange" 
                                 action="#{impresionDiagnosticaBean.changeDiagnosticoRelacionado2}"
                                 reRender="panelDiagnosticoRelacionado2">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                     
                  </h:inputText>
                  <h:panelGroup  id = "panelDiagnosticoRelacionado2">
                  <h:outputText value="  #{impresionDiagnosticaBean.diagnosticoRelacionado2}"
                                styleClass="buscador"/>
                  </h:panelGroup>
                </h:panelGroup>
                
                 
                <h:panelGroup id="mnuDiagnosticoRelacionado3">
                  <h:inputText id="itDiagnosticoRelacionado3"  styleClass="textmayuscula"
                               onkeydown="return blockEnter(event);"
                               value="#{impresionDiagnosticaBean.impresion.hidcdiagrela3}"
                                binding="#{impresionDiagnosticaBean.itDiagrelac3}"
                               valueChangeListener="#{impresionDiagnosticaBean.setHidcdiagrela3}"
                               style="width:50px" maxlength="4">
                                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <a4j:support id="supportDiagnosticoRelacionado3"
                                 event="onchange" 
                                 action="#{impresionDiagnosticaBean.changeDiagnosticoRelacionado3}"
                                 reRender="panelDiagnosticoRelacionado3">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                     
                  </h:inputText>
                  <h:panelGroup id = "panelDiagnosticoRelacionado3">
                  <h:outputText value="  #{impresionDiagnosticaBean.diagnosticoRelacionado3}"
                                styleClass="buscador"/>
                        </h:panelGroup>
                </h:panelGroup>
                
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Observaciones" id="fieldRecomendacion"
                        styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosRecomendaciones"
                           rowClasses="labelText">
                <h:outputText value="Observaciones"/>
                <h:panelGroup>
                  <h:inputTextarea id="textRecomendaciones"
                                   onkeydown="return blockEnter(event);"
                                   value="#{impresionDiagnosticaBean.impresion.hidtrecomen}"
                                   style="width:600px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textRecomendaciones"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            
        <s:fieldset legend="Estado Fisico ASA" id="fieldExamenFisicoASA" rendered="#{impresionDiagnosticaBean.mostrarAsa}"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosExamenFisicoASA" 
                           rowClasses="labelText,labelTextInfo">

                <h:outputText value="Grado Examen ASA" styleClass="labelTextOblig"/>
                <h:outputText value="Urgencia" />           
                
                <h:panelGroup>
                 <h:selectOneRadio id = "mnuGradoAsa" 
                        value = "#{impresionDiagnosticaBean.impresion.hidngradoasa}">
                    <f:selectItems value="#{impresionDiagnosticaBean.lstGradoASA}"/>
                 </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGradoAsa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
               
                </h:panelGroup>
                
                <h:panelGroup>
                <h:selectBooleanCheckbox id = "checkUrgente" value="#{impresionDiagnosticaBean.esurgencia}"/>
                </h:panelGroup>
                
               
                
     
              
             
                
                
              </h:panelGrid>
            </s:fieldset>
            
            
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonBotonesImpresionDiagnostica"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Aceptar" styleClass="boton_fieldset"
                                 action="#{impresionDiagnosticaBean.aceptar}">
                   <a4j:support event="onclick" status="statusButton"/>              
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid id="mensajesGrid">
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajesImpresionDiagnostica"
                                 ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInf" showSummary="true" errorClass="error"
                              globalOnly="true" layout="table"
                              infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscador" label="Bucar Diagnosticos"
                    rendered="#{impresionDiagnosticaBean.mostrarCie10}">
          <a4j:region id="regionCie10" renderRegionOnly="false">
            <a4j:status for="regionCie10">
              <f:facet name="start">
                <t:div id="chargingCie10" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0"
                               border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <s:fieldset legend="Cie10" id="fieldSetCie10" styleClass="fieldset">
              <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp"
                           flush="true"/>
              <h:panelGrid id="panelGridCie10Botones" width="100%"
                           columnClasses="columnaBotonesCentrados" dir="RTL">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCie10Botones1">
                  <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{impresionDiagnosticaBean.aceptarDiagnostico}"
                                     reRender="formImpresionDiagnostica">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>