<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConsultaControlSinCostoTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane  border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" 
                        activePanelTabVar="true" 
                         selectedIndex="#{controlUsuarioBean.selectedIndex}"
                         width="100%" id="panelTabbedPaneControlConsultaControl" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabConsultaControl" label=" Control" disabled="#{controlUsuarioBean.mostrarCie10}">
          <a4j:region id="bodyRegionConsultaControl">
            <a4j:status id="statusButton" for="bodyRegionConsultaControl">
              <f:facet name="start">
                <t:div id="chargindConsultaControl" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="tableContentTabsConsultaControl" styleClass="tabContainerControl">
        <s:fieldset legend="Motivo de la Consulta " id="fieldMotivoConsultaControl" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsultaControl" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Causa Externa" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup>
            <h:outputText value="Motivo de Consulta"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuMotivoConsultaControl"  
                onkeydown="return blockEnter(event);" 
            value="#{controlUsuarioBean.motivo.hmcncausaexte}">
              <f:selectItems value="#{controlUsuarioBean.lstCausa}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMotivoConsultaControl" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
            <h:inputTextarea id="textMotivoConsultaControl" 
                 
                value="#{controlUsuarioBean.motivo.hmctdescripcio}" style="width:500px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMotivoConsultaControl" styleClass="errorMessage"/>
            </a4j:outputPanel>
                     </h:panelGrid>
  
 <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsultaControl2" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Finalidad" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup>
            <h:outputText value="Enfermedad Actual" />
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuFinalidadControl" onkeydown="return blockEnter(event);"   
            value="#{controlUsuarioBean.motivo.hmcnfinalidad}">
              <f:selectItems value="#{controlUsuarioBean.lstFinalidades}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuFinalidadControl" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
            <h:inputTextarea id="textEnfermedaActualControl"   
            value="#{controlUsuarioBean.motivo.hmctenferactal}" style="width:500px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textEnfermedaActualControl" styleClass="errorMessage"/>
            </a4j:outputPanel>
</h:panelGrid>
        </s:fieldset>   
        
        <s:fieldset legend="Resultado de Patologia " id="fieldPatolo" styleClass="fieldset" rendered="#{controlUsuarioBean.rendeGineco}">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPatol" rowClasses="labelText,labelTextInfo">

          <h:panelGrid columns="6" border="0" rendered="#{not empty controlUsuarioBean.lstPatologias}" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsultaPatologia" rowClasses="labelText,labelTextInfo">
                <h:outputText value="¿La Paciente trae resultado de patología?" styleClass="labelTextOblig" />
                <h:outputText value=""/>
                <h:panelGroup>
                     <h:outputText value="Tipo de Patología" rendered="#{controlUsuarioBean.renderTipoPatologia}" styleClass="labelTextOblig"  />
                </h:panelGroup>
                 <h:outputText value=""/>
                 <h:panelGroup>
                    <h:outputText value="¿Cuál?" rendered="#{controlUsuarioBean.renderPatologiaCual}" styleClass="labelTextOblig"  />
                 </h:panelGroup>
                        <h:outputText value=""/>                    
                    <h:selectOneRadio rendered="#{not empty controlUsuarioBean.lstPatologias}" id="mnuTraePat" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                  valueChangeListener="#{controlUsuarioBean.setHmcctrapatol}"
                                   value="#{controlUsuarioBean.motivo.hmcctrapatol}">
                  <f:selectItems value="#{controlUsuarioBean.lstOpciones}"/>
                  <a4j:support id="suppoFechaAborto" event="onchange" immediate="true"
                               action="#{controlUsuarioBean.changeTraePatologia}"
                               reRender="panelMotivoConsultaPatologia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuTraePat" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                <h:selectOneMenu rendered="#{controlUsuarioBean.renderTipoPatologia}" id="mnuTipPat" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                  valueChangeListener="#{controlUsuarioBean.setHmcctippatolt}"
                                   value="#{controlUsuarioBean.motivo.hmcctippatol}">
                  <f:selectItems value="#{controlUsuarioBean.lstPatologias}"/>
                  <a4j:support id="suppoTipPatol" event="onchange" immediate="true"
                               action="#{controlUsuarioBean.changePatologia}"
                               reRender="panelMotivoConsultaPatologia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuTipPat" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                 <h:inputTextarea id="textCualPatologia" required="true"  rendered="#{controlUsuarioBean.renderPatologiaCual}"  
                     value="#{controlUsuarioBean.motivo.hmcccualpat}" style="width:200px">
                <f:validateLength maximum="50"/>
                </h:inputTextarea>
                </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textCualPatologia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup>
                    <h:outputText value="Resultado de biopsia" styleClass="labelTextOblig" rendered="#{not empty controlUsuarioBean.lstBiopsia}" />
                    <h:outputText value="Descripción del Resultado?" styleClass="labelTextOblig" rendered="#{controlUsuarioBean.renderDescripcionResultados}"  /> 
                </h:panelGroup>
                <h:outputText value=""/>
                 <h:outputText value=""/>
                  <h:outputText value=""/>
                   <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:panelGroup>
                         <h:selectOneMenu rendered="#{not empty controlUsuarioBean.lstBiopsia}" id="mnuResBio" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                   value="#{controlUsuarioBean.motivo.hmccresbiop}">
                  <f:selectItems value="#{controlUsuarioBean.lstBiopsia}"/>
                </h:selectOneMenu>
                  <h:inputTextarea id="textResultados" required="true"  rendered="#{controlUsuarioBean.renderDescripcionResultados}"   
                     value="#{controlUsuarioBean.motivo.hmccdesres}" style="width:200px">
                <f:validateLength maximum="100"/>
                </h:inputTextarea>
                </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResBio" styleClass="errorMessage"/>
                </a4j:outputPanel>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textResultados" styleClass="errorMessage"/>
                </a4j:outputPanel>
                     <h:outputText value=""/>
                   <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:panelGroup>
                    <h:outputText value="Resultado" styleClass="labelTextOblig" rendered="#{controlUsuarioBean.renderTipoPatologia}" />
                    </h:panelGroup>
                       <h:outputText value=""/>
                   <h:outputText value=""/>
                    <h:outputText value=""/> 
                   <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:panelGroup>
                      <h:selectOneRadio rendered="#{controlUsuarioBean.renderTipoPatologia}"  id="mnuPosPat"  immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"  valueChangeListener="#{controlUsuarioBean.setHmccrespatol}"
                                   value="#{controlUsuarioBean.motivo.hmccrespatol}">
                  <f:selectItems value="#{controlUsuarioBean.lstResPatols}"/>
                   <a4j:support id="supportmnuRepuestaPatol" event="onchange" immediate="true" action="#{controlUsuarioBean.changeResultados}" reRender="panelMotivoConsultaPatologia,PanelMaligno">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuPosPat" styleClass="errorMessage"/>
                </a4j:outputPanel>
                   <h:outputText value=""/>
                    <h:outputText value=""/> 
                   <h:outputText value=""/>
                    <h:outputText value=""/>
                    
            <h:panelGroup id="PanelMaligno">
                 <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelPatolResul" rowClasses="labelText,labelTextInfo">
                 <h:panelGroup>
                 <h:panelGrid columns="1">
                <h:outputText value="Clasificacion Histologica" styleClass="labelTextOblig" rendered="#{controlUsuarioBean.renderResultado}"/>
                 <h:selectOneMenu id="mnuResPa" immediate="true" rendered="#{controlUsuarioBean.renderResultado}"
                                  onkeydown="return blockEnter(event);" required="true"
                                   value="#{controlUsuarioBean.motivo.hmnclashisto}">
                  <f:selectItems value="#{controlUsuarioBean.lstClasificacionHistol}"/>
                </h:selectOneMenu>
                </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                 <h:panelGrid columns="1">
                <h:outputText value="Grado diferenciador del tumor" styleClass="labelTextOblig" rendered="#{controlUsuarioBean.renderResultado}"/>
                 <h:selectOneMenu id="mnuResHisto" immediate="true" rendered="#{controlUsuarioBean.renderResultado}"
                                  onkeydown="return blockEnter(event);" required="true"
                                   value="#{controlUsuarioBean.motivo.hmngradtumor}">
                  <f:selectItems value="#{controlUsuarioBean.lstGradoTumor}"/>
                </h:selectOneMenu>
                </h:panelGrid>
                </h:panelGroup>
                </h:panelGrid>
                </h:panelGroup>
                
            </h:panelGrid>
            
            </h:panelGrid>
            </s:fieldset>
            
           <s:fieldset legend="Impresión Diagnostica" id="fieldDiagnosticosConsultaControl" styleClass="fieldset">
           
             <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosTipoImpresionConsultaControl" rowClasses="labelText,labelTextInfo">
                       
                        <h:outputText value="Tipo Diagnostico "
                              styleClass="labelTextOblig"/>
                        <h:outputText value = ""/>

           
                  <h:selectOneMenu id="tipoDiagnosticoConsultaControl" 
                                   value="#{controlUsuarioBean.impresion.hidntipodiagn}">
                    <f:selectItems value="#{controlUsuarioBean.lstTipoImpresion}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="tipoDiagnosticoConsultaControl" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGrid>          
           
           
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosDiagnosticosConsultaControl" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <h:commandLink action="#{controlUsuarioBean.mostrarDiagnosticoPrincipal}">
                <t:graphicImage alt="Buscar Diagnosticos"  border="0" url="/comun/imagenes/lupa.gif"/>
              </h:commandLink>
              <h:inputText id="itDiagPrinConsultaControl"  onkeydown="return blockEnter(event);"
                        styleClass="textmayuscula" 
                           value="#{controlUsuarioBean.impresion.hidcdiagprin}"
                           valueChangeListener="#{controlUsuarioBean.setHidcdiagprin}" style="width:50px"
                           maxlength="4" immediate="true"
                           binding="#{controlUsuarioBean.inputDiagPrincipal}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPrinConsultaControl" event="onchange" ignoreDupResponses="true"
                             action="#{controlUsuarioBean.changeDiagnosticoPrincipal}"
                             reRender="panelDiagnosticoPrincipalConsultaControl">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                    
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoPrincipalConsultaControl">
                <h:outputText value=" #{controlUsuarioBean.diagnosticoPrincipal}" styleClass="buscador"/>
              </h:panelGrid>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPrinConsultaControl" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            </a4j:region>
            <h:outputText value="Diagnostico Relacionado Uno (1) "/>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <h:commandLink action="#{controlUsuarioBean.mostrarDiagnosticoRelacionado1}">
                      <t:graphicImage alt="Buscar Diagnosticos"  border="0" url="/comun/imagenes/lupa.gif"/>
              </h:commandLink>
              <h:inputText id="itDiagnosticoRelacionado1ConsultaControl" onkeydown="return blockEnter(event);"
                            styleClass="textmayuscula" 
                           value="#{controlUsuarioBean.impresion.hidcdiagrela1}"
                           valueChangeListener="#{controlUsuarioBean.setHidcdiagrela1}" style="width:50px"
                           maxlength="4"  immediate="true"
                           disabled="#{controlUsuarioBean.disableRel1}"
                           binding="#{controlUsuarioBean.inputDiagRelacionado1}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado1ConsultaControl" event="onchange"
                             action="#{controlUsuarioBean.changeDiagnosticoRelacionado1}"
                             reRender="panelDiagnosticoRelacionado1ConsultaControl">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                    
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado1ConsultaControl">
                <h:outputText value="#{controlUsuarioBean.diagnosticoRelacionado1}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
             <h:panelGroup>
            <h:outputText value="Diagnostico Relacionado Dos (2) "  styleClass ="labelTextOblig"
            rendered="#{controlUsuarioBean.requiredRel2}"/>
            
           <h:outputText value="Diagnostico Relacionado Dos (2) " 
            rendered="#{!controlUsuarioBean.requiredRel2}"/>
            
            </h:panelGroup>
            <h:panelGrid id="panelGroupDiagnosticoConsultaControl" columns="3" border="0" cellpadding="0" cellspacing="0">
              <h:commandLink action="#{controlUsuarioBean.mostrarDiagnosticoRelacionado2}">
                    <t:graphicImage alt="Buscar Diagnosticos"  border="0" url="/comun/imagenes/lupa.gif"/>
              </h:commandLink>
              <h:inputText id="itDiagnosticoRelacionado2ConsultaControl"
                            styleClass="textmayuscula" 
                           value="#{controlUsuarioBean.impresion.hidcdiagrela2}"
                           required="#{controlUsuarioBean.requiredRel2}"
                           onkeydown="return blockEnter(event);"
                           valueChangeListener="#{controlUsuarioBean.setHidcdiagrela2}" style="width:50px"
                           maxlength="4"  immediate="true"
                           binding="#{controlUsuarioBean.inputDiagRelacionado2}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado2ConsultaControl" event="onchange"
                             action="#{controlUsuarioBean.changeDiagnosticoRelacionado2}"
                             reRender="panelDiagnosticoRelacionado2ConsultaControl">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                    
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado2ConsultaControl">
                <h:outputText value="  #{controlUsuarioBean.diagnosticoRelacionado2}"
                              styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText value="Diagnostico Relacionado Tres (3) "/>
            <h:panelGrid id="mnuDiagnosticoRelacionado3ConsultaControl" columns="3" border="0" cellpadding="0" cellspacing="0">
              <h:commandLink action="#{controlUsuarioBean.mostrarDiagnosticoRelacionado3}">
                        <t:graphicImage alt="Buscar Diagnosticos"  border="0" url="/comun/imagenes/lupa.gif"/>
              </h:commandLink>
              <h:inputText id="itDiagnosticoRelacionado3ConsultaControl" onkeydown="return blockEnter(event);"
                           styleClass="textmayuscula"
                           value="#{controlUsuarioBean.impresion.hidcdiagrela3}"
                           valueChangeListener="#{controlUsuarioBean.setHidcdiagrela3}" style="width:50px"
                           maxlength="4"  immediate="true"
                           binding="#{controlUsuarioBean.inputDiagRelacionado3}">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado3ConsultaControl" event="onchange"
                             action="#{controlUsuarioBean.changeDiagnosticoRelacionado3}"
                             reRender="panelDiagnosticoRelacionado3ConsultaControl">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                    
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado3ConsultaControl">
                <h:outputText value="  #{controlUsuarioBean.diagnosticoRelacionado3}"
                              styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
                         
                         
              <t:htmlTag value="br"/>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelControlConsultaControl"
                           rowClasses="labelText" rendered="#{controlUsuarioBean.controlrender}">
                <h:outputText value="Control" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:inputTextarea id="textNotaConsultaControl" 
                                  value="#{controlUsuarioBean.control.hcccdescripcio}"
                                   style="width:500px;height:70px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textNotaConsultaControl" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonRegistrarNotaMedicaConsultaControl" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{controlUsuarioBean.aceptar}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1ConsultaControl" ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInformationAndErrors1ConsultaControl" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
           <t:panelTab id="panelBuscadorConsultaControl" label="Buscar Diagnosticos"
                rendered="#{controlUsuarioBean.mostrarCie10}">
      <a4j:region id="regionCie10ConsultaControl" renderRegionOnly="false">
        <a4j:status for="regionCie10ConsultaControl">
          <f:facet name="start">
            <t:div id="chargingCie10ConsultaControl" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
        <h:panelGrid id="panelGridCie10BotonesConsultaControl" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupCie10Botones1ConsultaControl">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                               action="#{controlUsuarioBean.aceptarDiagnostico}"
                               reRender="panelGridConsultaControlSinCostoTab">
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