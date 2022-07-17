<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridProcedimientoConsultorioTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneProcedimientoConsultorio" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     selectedIndex="#{procedimientosConsultorioUsuarioBean.selectedIndex}"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabProcedimientoConsultorio" label="Procedimientos Consultorio"
                disabled="#{procedimientosConsultorioUsuarioBean.mostrarCie10}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridProcedimientoConsultorio" rowClasses="tabContainer">
        <s:fieldset legend="Motivo de Consulta" id="fieldMotivoConsulta" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosMotivoConsulta"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Ambito de realización del procedimiento  " styleClass="labelTextOblig"/>
            <h:outputText value="Finalidad del Procedimiento" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:selectOneMenu id="menuAmbitoProcedimiento" disabled="true"
                               value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpcnambitproce}">
                <f:selectItems value="#{procedimientosConsultorioUsuarioBean.lstAmbito}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuAmbitoProcedimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneMenu id="menuFinalidadProcedimiento"
                               value="#{procedimientosConsultorioUsuarioBean.finalidadSelect}">
                <f:selectItems value="#{procedimientosConsultorioUsuarioBean.lstFinalidad}"/>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuFinalidadProcedimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Diagnostico Previo" id="fieldImpresionDiagnostica" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelImpresionDiagnostica" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Previo" styleClass="labelTextOblig"/>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{procedimientosConsultorioUsuarioBean.mostrarDiagnosticoPrevio}"
                               reRender="panelGridProcedimientoConsultorioTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:panelGroup>
                <h:inputText id="itDiagPrevio" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                             immediate="true" binding="#{procedimientosConsultorioUsuarioBean.itDiagPrevio}"
                             value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccdiagprinci}"
                             valueChangeListener="#{procedimientosConsultorioUsuarioBean.setHpccdiagprinci}"
                             style="width:50px" maxlength="4">
                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                  <a4j:support id="supportitDiagPrevio" event="onchange" ignoreDupResponses="true" immediate="true"
                               action="#{procedimientosConsultorioUsuarioBean.changeDiagnosticoPrevio}"
                               reRender="panelDiagnosticoPrevio">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <f:converter converterId="util.ConverterMayuscula"/>
                </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itDiagPrevio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoPrevio">
                <h:outputText value=" #{procedimientosConsultorioUsuarioBean.diagnosticoPrevio}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Procedimiento" id="fieldProcedimiento" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelProcedimiento"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Procedimiento" styleClass="labelTextOblig"/>
            <h:outputText value=" #{procedimientosConsultorioUsuarioBean.procedimientoCups}"/>
            <h:outputText value="Descripción del procedimiento" styleClass="labelTextOblig"/>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{procedimientosConsultorioUsuarioBean.mostrarBuscadorPlantilla}"
                               immediate="true" reRender="panelGridProcedimientoConsultorioTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="inputTextAreaDescripcion" onkeydown="return blockEnter(event);" immediate="true"
                               binding="#{procedimientosConsultorioUsuarioBean.itDescripcion}"
                               value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccdescrproce}"
                               style="width:500px;height:70px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputTextAreaDescripcion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelComplicaciones"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Tiene Complicaciones" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuComplicaciones" onkeydown="return blockEnter(event);"
                                value="#{procedimientosConsultorioUsuarioBean.tieneComplicaciones}"
                                valueChangeListener="#{procedimientosConsultorioUsuarioBean.setTieneComplicaciones}">
                <f:selectItems value="#{procedimientosConsultorioUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportmnuComplicaciones" event="onclick"
                             action="#{procedimientosConsultorioUsuarioBean.changeComplicaciones}"
                             reRender="panelGroupTextDiagnostico,panelInputDiagnosticoComplicacion,panelGroupTextDescripcion,panelInputDescripcionComplicacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelGroupTextDiagnostico">
              <h:panelGroup rendered="#{procedimientosConsultorioUsuarioBean.mostrarComplicaciones}">
                <h:outputText value="Diagnostico Complicación" styleClass="labelTextOblig"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelInputDiagnosticoComplicacion">
              <h:panelGroup rendered="#{procedimientosConsultorioUsuarioBean.mostrarComplicaciones}">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                  <a4j:commandLink action="#{procedimientosConsultorioUsuarioBean.mostrarDiagnosticoComplicacion}"
                                   reRender="panelGridProcedimientoConsultorioTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                  <h:inputText id="itDiagComplicacion" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                               binding="#{procedimientosConsultorioUsuarioBean.itDiagComplicacion}"
                               value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccdiagcompli}"
                               valueChangeListener="#{procedimientosConsultorioUsuarioBean.setHpccdiagcompli}"
                               style="width:50px" maxlength="4">
                    <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <a4j:support id="supportitDiagComplicacion" event="onchange" ignoreDupResponses="true"
                                 action="#{procedimientosConsultorioUsuarioBean.changeDiagnosticoComplicacion}"
                                 reRender="panelDiagnosticoComplicacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <f:converter converterId="util.ConverterMayuscula"/>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiagComplicacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:panelGroup id="panelDiagnosticoComplicacion">
                    <h:outputText value=" #{procedimientosConsultorioUsuarioBean.diagnosticoComplicacion}"
                                  styleClass="buscador"/>
                  </h:panelGroup>
                </h:panelGrid>
              </h:panelGroup>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelComplicacionesDescripcion" rowClasses="labelText,labelTextInfo">
            <h:panelGroup id="panelGroupTextDescripcion">
              <h:outputText value="Descripción de la complicación"
                            rendered="#{procedimientosConsultorioUsuarioBean.mostrarComplicaciones}"
                            styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputDescripcionComplicacion">
              <h:inputTextarea id="inputTextareaComplicaciones" onkeydown="return blockEnter(event);"
                               value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccdescrcompl}"
                               style="width:500px;height:70px"
                               rendered="#{procedimientosConsultorioUsuarioBean.mostrarComplicaciones}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputTextareaComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <!-- COMIENZA ESCALA DE DOLOR -->
                  <s:fieldset legend="Escala de Dolor" id="fieldEscalaDolorProcedimiento" styleClass="fieldset">
            <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEscalaDolorProcedimiento"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Refiere dolor" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelEscala" >
                <h:outputText value="Escala de Dolor" styleClass="labelTextOblig" 
                        rendered="#{procedimientosConsultorioUsuarioBean.renderDolor}"/>
              </h:panelGroup>
              <h:outputText value=""/>
            <h:panelGroup id = "itTextDuracionDolor">
               <h:outputText value="Duración del dolor"  rendered="#{procedimientosConsultorioUsuarioBean.renderDolor}"
               styleClass="labelTextOblig"/>
               </h:panelGroup>
                    <h:panelGroup id = "itTextUnidadMedida">
               <h:outputText value="Unidad de Medida"  rendered="#{procedimientosConsultorioUsuarioBean.renderDolor}"
               styleClass="labelTextOblig"/>
               </h:panelGroup>

              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="radioEscalaDolor" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccrefierdolor}"
                                    valueChangeListener="#{procedimientosConsultorioUsuarioBean.listenDolorCirugia}">
                    <f:selectItems value="#{procedimientosConsultorioUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supportradioEscalaDolor" event="onclick" reRender="panelEscalaDolorProcedimiento">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </h:panelGroup>
              </a4j:region>
              <h:outputText value=""/>
              <h:panelGroup id="panelRenderDolor" rendered="#{procedimientosConsultorioUsuarioBean.renderDolor}">
                <h:selectOneRadio id="selectEscalaDolor" layout="lineDirection" value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpcnescaladolor}" 
                style="margin-left:55px; width:580px">
                                <f:selectItems value="#{procedimientosConsultorioUsuarioBean.listEscala}"/>
                                  <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneRadio>
                <h:graphicImage url="/comun/imagenes/escalaDolor2.png" style="width:650px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="selectEscalaDolor" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
             
             
             
             <h:panelGroup>
                <h:inputText id="menuDuraDolor" maxlength="2" size="2" style="width:30px" immediate="true"
                             rendered="#{procedimientosConsultorioUsuarioBean.renderDolor}"
                             value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpcnduracidolor}"
                             onkeypress="return justNumbers(event);">
                              <a4j:support event="onchange" status="statusButton"/>
                             </h:inputText>
               <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuDuraDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>
                              
              </h:panelGroup>
              
              <h:panelGroup>
              <h:selectOneMenu id="menuTiempo3" styleClass="input-small labelTextOblig"
                rendered="#{procedimientosConsultorioUsuarioBean.renderDolor}" immediate="true"
                value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccdudointen}">
                    <f:selectItem itemLabel="Seleccione una opción ..." itemValue=""/>
                    <f:selectItem itemLabel="Minuto(s)" itemValue="MI"/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                     <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneMenu>
                
                              <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuTiempo3" styleClass="errorMessage"/>
              </a4j:outputPanel>
 
 
              
              </h:panelGroup>
              
              
            </h:panelGrid>
          </s:fieldset>

        
        
        <!--FIN DE LA ESCALA DE DOLOR -->
        <s:fieldset legend="Diagnostico Posterior" id="fieldDiagnosticoPosterior" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDiagnosticoPosterior" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Posterior"/>
            <h:outputText/>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{procedimientosConsultorioUsuarioBean.mostrarDiagnosticoPosterior}"
                               reRender="panelGridProcedimientoConsultorioTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPosterior" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                           immediate="true" binding="#{procedimientosConsultorioUsuarioBean.itDiagPosterior}"
                           value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpccdiagposter}"
                           valueChangeListener="#{procedimientosConsultorioUsuarioBean.setHpccdiagposter}"
                           style="width:50px" maxlength="4">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPosterior" event="onchange" ignoreDupResponses="true" immediate="true"
                             action="#{procedimientosConsultorioUsuarioBean.changeDiagnosticoPosterior}"
                             reRender="panelDiagnosticoPosterior">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <f:converter converterId="util.ConverterMayuscula"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPosterior" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado1">
                <h:outputText value=" #{procedimientosConsultorioUsuarioBean.diagnosticoPosterior}"
                              styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>
            <h:outputText value="Realización" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:selectOneMenu id="mnuRealizacion"
                             value="#{procedimientosConsultorioUsuarioBean.procedimiento.hpcnrealizacio}">
              <f:selectItems value="#{procedimientosConsultorioUsuarioBean.lstRealizacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuRealizacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonBotonesProcedimientoConsultorio" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="btn btn btn-success"
                             action="#{procedimientosConsultorioUsuarioBean.aceptar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid id="mensajesProcedimientoConsultorio">
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesProcedimientoConsultorio" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelTabBuscadorCie10" label="Bucar Diagnosticos"
                rendered="#{procedimientosConsultorioUsuarioBean.mostrarCie10}">
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
        <s:fieldset legend="Cie10" id="fieldSetCie10" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
          <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupCie10Botones1">
              <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                 action="#{procedimientosConsultorioUsuarioBean.aceptarDiagnostico}"
                                 reRender="panelGridProcedimientoConsultorioTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantillaProcedimiento" label="Buscar Plantillas"
                rendered="#{procedimientosConsultorioUsuarioBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaProcedimiento" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaProcedimiento">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaProcedimiento" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaProcedimiento" width="100%"
                     columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotonesBuscadorPlantilla">
            <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                               action="#{procedimientosConsultorioUsuarioBean.aceptarPlantilla}"
                               reRender="panelGridProcedimientoConsultorioTab">
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