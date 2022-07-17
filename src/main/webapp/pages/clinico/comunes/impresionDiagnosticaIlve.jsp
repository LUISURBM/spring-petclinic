<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridImpresionDiagnosticaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneImpresionDiagnostica" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     selectedIndex="#{impresionDiagnosticaIlveBean.selectedIndex}"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabImpresionDiagnostica" label="Impresión Diagnostica Ilve"
                disabled="#{impresionDiagnosticaIlveBean.mostrarCie10}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridImpresionDiagnostica">
        <s:fieldset legend="Tipo Diagnostico" id="fieldImpresionDiagnostica" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosImpresionDiagnostica" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Tipo Diagnostico " styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGroup>
              <h:selectOneMenu id="tipoDiagnostico" onkeydown="return blockEnter(event);"
                               binding="#{impresionDiagnosticaIlveBean.mnuTipoDiagnostico}"
                               value="#{impresionDiagnosticaIlveBean.impresion.hidntipodiagn}">
                <f:selectItems value="#{impresionDiagnosticaIlveBean.lstTipoImpresion}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="tipoDiagnostico" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Diagnosticos Relacionados" id="fieldDiagnosticos" styleClass="fieldset">
          <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosImpresionDiagnostica2" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextSemanas">
              <h:outputText value="Edad gestacional concepcional" styleClass="labelTextOblig"
                            />
            </h:panelGroup>
            <h:panelGroup id="panelTextConfirmaSemanas">
              <h:outputText value="Confirma Semanas" styleClass="labelTextOblig"
                            />
            </h:panelGroup>
            <h:panelGroup id = "panelTextNumeroSemanas">
                <h:outputText value = "Semanas de Embarazo" styleClass="labelTextOblig" 
                        rendered="#{impresionDiagnosticaIlveBean.renderConfirmacion && impresionDiagnosticaIlveBean.renderHistoriaIlve}"/>
            </h:panelGroup>
            <h:panelGroup id = "panelTextConfirmaPor">
            <h:outputText value= "Confirma por" styleClass="labelTextOblig" 
            rendered="#{impresionDiagnosticaIlveBean.renderConfirmacion && impresionDiagnosticaIlveBean.renderHistoriaIlve}"/>
            </h:panelGroup>
            
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink immediate="true"
                                action="#{impresionDiagnosticaIlveBean.mostrarDiagnosticoPrincipal}"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              
             <a4j:region renderRegionOnly="false"> 
              <h:inputText id="itDiagPrin" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                           value="#{impresionDiagnosticaIlveBean.impresion.hidcdiagprin}"
                           disabled="#{impresionDiagnosticaIlveBean.desHabilitarDiagnosticoPrincipal}"
                           valueChangeListener="#{impresionDiagnosticaIlveBean.setHidcdiagprin}" 
                           style="width:50px"
                           maxlength="4" immediate="true"
                           binding="#{impresionDiagnosticaIlveBean.inputDiagPrincipal}">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPrin" event="onchange" ignoreDupResponses="true"
                             action="#{impresionDiagnosticaIlveBean.changeDiagnosticoPrincipal}"
                             reRender="panelDiagnosticoPrincipal,panelTextSemanas,panelInputSemanas,panelTextNumeroSemanas,panelTextConfirmaPor,panelMenuMotivoConfirma,panelTextConfirmaSemanas,panelInputSemanas,panelConfirmaEmbarazo,panelSemanasEmbarazo">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              </a4j:region>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoPrincipal">
                <h:outputText value=" #{impresionDiagnosticaIlveBean.diagnosticoPrincipal}" styleClass="buscador"/>
              </h:panelGrid>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPrin" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          
          
            <h:panelGroup id="panelInputSemanas">
              <h:outputText value="±" />
              <h:inputText id="itEdadGestacional" style="width:30px" maxlength="2" disabled="true"
                            required="true"
                           value="#{impresionDiagnosticaIlveBean.impresion.hidnsemanameno}">
                <f:validator validatorId="validateSemanaEmbarazo"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true"  >
                <t:message for="itEdadGestacional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelConfirmaEmbarazo">
            <h:selectOneRadio id = "mnuConfirmaEmbarazo"  immediate="true"
                    required="true"
                    value = "#{impresionDiagnosticaIlveBean.impresion.hidcconfiseman}"
                    valueChangeListener="#{impresionDiagnosticaIlveBean.setHidcconfiseman}">
                <f:selectItems value = "#{impresionDiagnosticaIlveBean.lstOpciones}"/>
                <a4j:support id="supportitConfirmarEmbarazo" event="onclick" 
                             ignoreDupResponses="true" immediate="true"
                             action="#{impresionDiagnosticaIlveBean.changeConfirmacion}"
                             reRender="panelTextNumeroSemanas,panelSemanasEmbarazo,panelTextConfirmaPor,panelMenuMotivoConfirma">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
            </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true"  rendered="#{impresionDiagnosticaIlveBean.renderHistoriaIlve}">
                <t:message for="mnuConfirmaEmbarazo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelSemanasEmbarazo">
                <h:inputText id="itSemanasEmbarazo" style="width:50px"  maxlength="4"
                        rendered="#{impresionDiagnosticaIlveBean.renderConfirmacion && impresionDiagnosticaIlveBean.renderHistoriaIlve}"
                        value ="#{impresionDiagnosticaIlveBean.impresion.hidnsemanembar}"/>
                        
            <a4j:outputPanel ajaxRendered="true"  rendered="#{impresionDiagnosticaIlveBean.renderConfirmacion && impresionDiagnosticaIlveBean.renderHistoriaIlve}">
                <t:message for="itSemanasEmbarazo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id = "panelMenuMotivoConfirma">
            <h:selectOneMenu id = "mnuMotivoConfirma" 
             rendered="#{impresionDiagnosticaIlveBean.renderConfirmacion && impresionDiagnosticaIlveBean.renderHistoriaIlve}"
                value = "#{impresionDiagnosticaIlveBean.impresion.hidcmotivconfi}">
                <f:selectItems value = "#{impresionDiagnosticaIlveBean.lstConfirmaPor}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{impresionDiagnosticaIlveBean.renderConfirmacion && impresionDiagnosticaIlveBean.renderHistoriaIlve}" >
                <t:message for="mnuMotivoConfirma" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Diagnostico Relacionado Uno (1) "/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
           
             <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{impresionDiagnosticaIlveBean.mostrarDiagnosticoRelacionado1}"
                                immediate="true"
                               reRender="panelGridImpresionDiagnosticaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
            <a4j:region renderRegionOnly="false">
              <h:inputText id="itDiagnosticoRelacionado1" onkeydown="return blockEnter(event);"
                           styleClass="textmayuscula" value="#{impresionDiagnosticaIlveBean.impresion.hidcdiagrela1}"
                           valueChangeListener="#{impresionDiagnosticaIlveBean.setHidcdiagrela1}" style="width:50px"
                           maxlength="4" immediate="true"
                           disabled="#{impresionDiagnosticaIlveBean.disableRel1}"
                           binding="#{impresionDiagnosticaIlveBean.inputDiagRelacionado1}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado1" event="onchange"
                             action="#{impresionDiagnosticaIlveBean.changeDiagnosticoRelacionado1}"
                             reRender="panelDiagnosticoRelacionado1">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                  <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado1" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:inputText>
              </a4j:region>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado1">
                <h:outputText value="#{impresionDiagnosticaIlveBean.diagnosticoRelacionado1}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
           
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGroup>
            <h:outputText value="Diagnostico Relacionado Dos (2) "  styleClass ="labelTextOblig"
            rendered="#{impresionDiagnosticaIlveBean.requiredRel2}"/>
            
           <h:outputText value="Diagnostico Relacionado Dos (2) " 
            rendered="#{!impresionDiagnosticaIlveBean.requiredRel2}"/>
            
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGrid id="panelGroupDiagnostico" columns="2" border="0" cellpadding="0" cellspacing="0">
              
               <h:selectOneMenu id="itDiagnosticoRelacionado2"   required="true"
                           value="#{impresionDiagnosticaIlveBean.impresion.hidcdiagrela2}">
                         <f:selectItems value = "#{impresionDiagnosticaIlveBean.lstDiagnosticoRelacionado2}"/>  
            </h:selectOneMenu>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado2" styleClass="errorMessage"/>
              </a4j:outputPanel>
 
            </h:panelGrid>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText value="Diagnostico Relacionado Tres (3) "/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:panelGrid id="mnuDiagnosticoRelacionado3" columns="2" border="0" cellpadding="0" cellspacing="0">
      
           <h:selectOneMenu id="itDiagnosticoRelacionado3"   required="true"
                           value="#{impresionDiagnosticaIlveBean.impresion.hidcdiagrela3}">
                         <f:selectItems value = "#{impresionDiagnosticaIlveBean.lstDiagnosticoRelacionado3}"/>  
            </h:selectOneMenu>
             <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado3" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Observaciones" id="fieldRecomendacion" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosRecomendaciones" rowClasses="labelText">
            <h:outputText value="Observaciones"/>
            <h:panelGroup>
              <h:inputTextarea id="textRecomendaciones" onkeydown="return blockEnter(event);"
                               value="#{impresionDiagnosticaIlveBean.impresion.hidtrecomen}" style="width:600px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textRecomendaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Estado Fisico ASA" id="fieldExamenFisicoASA"
                    rendered="#{impresionDiagnosticaIlveBean.mostrarAsa}" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosExamenFisicoASA" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Grado Examen ASA" styleClass="labelTextOblig"/>
            <h:outputText value="Urgencia"/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuGradoAsa" onkeydown="return blockEnter(event);"
                                value="#{impresionDiagnosticaIlveBean.impresion.hidngradoasa}">
                <f:selectItems value="#{impresionDiagnosticaIlveBean.lstGradoASA}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuGradoAsa" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkUrgente" onkeydown="return blockEnter(event);"
                                       value="#{impresionDiagnosticaIlveBean.esurgencia}"/>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajesImpresionDiagnostica" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonBotonesImpresionDiagnostica" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                             action="#{impresionDiagnosticaIlveBean.guardarImpresion}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
     <t:panelTab id="panelBuscadorImpresionDiagnosticaIve" label="Buscar Diagnosticos"
                rendered="#{impresionDiagnosticaIlveBean.mostrarCie10}">
      <a4j:region id="regionCie10" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionCie10">
          <f:facet name="start">
            <t:div id="chargingCie10" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/registro/buscadorIveCie10.jsp" flush="true"/>
        <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupCie10Botones1">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{impresionDiagnosticaIlveBean.aceptarDiagnostico}"
                               reRender="panelGridImpresionDiagnosticaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>