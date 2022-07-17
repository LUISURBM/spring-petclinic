<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAplicacionDispositivoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAplicacionDispositivo" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     selectedIndex="#{aplicacionDispositivoBean.selectedIndex}" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAplicacionDispositivo" label="Aplicación / Retiro Dispositivo P.F."
                disabled="#{aplicacionDispositivoBean.selectedIndex != 0}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelGridAplicacionDispositivo">
        <s:fieldset legend="Servicios Asociados " id="fieldServiAsociados" styleClass="fieldset"
                    rendered="#{not empty aplicacionDispositivoBean.listaServicios}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentTabsServAsociados"
                       rendered="#{not empty aplicacionDispositivoBean.listaServicios}">
            <t:buffer into="#{table}">
              <h:dataTable var="itemServ" border="0" cellpadding="0" cellspacing="4"
                           value="#{aplicacionDispositivoBean.listaServicios}" rows="30" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           binding="#{aplicacionDispositivoBean.dtProcedimientoAsociados}"
                           id="tdatosServAsociado">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo Servicio"/>
                  </f:facet>
                  <h:outputText value="#{itemServ.cdfcservicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre Servicio"/>
                  </f:facet>
                  <h:outputText value="#{itemServ.nombreServicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Realiza"/>
                  </f:facet>
                   <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectBooleanCheckbox id="mnuTablaProcedimiento" value="#{itemServ.checkServiciosAsociados}">
                  <a4j:support id="supportmnuTablaProce" event="onclick"
                               action="#{aplicacionDispositivoBean.changeRealizaProce}"
                               reRender="panelGridAplicacionDispositivo">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTablaProcedimiento" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Asociado" for="tdatosServAsociado" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" paginatorMaxPages="9"
                                paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Datos RIPS (Procedimiento) " id="fieldSetDatosProcedimiento" styleClass="fieldset"
                    rendered="#{aplicacionDispositivoBean.renderRealizaProcedimiento}">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosRipsProcedimiento" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Ambito Realización" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:outputText value="Finalidad del procedimiento" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:selectOneMenu id="menuAmbitoAplicacion" disabled="true"
                             value="#{aplicacionDispositivoBean.dispositivo.hdanambitproce}">
              <f:selectItems value="#{aplicacionDispositivoBean.lstAmbito}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAmbitoAplicacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuFinalidadAplicacion"
                             value="#{aplicacionDispositivoBean.dispositivo.hdanfinalidad}">
              <f:selectItems value="#{aplicacionDispositivoBean.lstFinalidad}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuFinalidadAplicacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Datos Procedimiento " id="fieldSetOrigen" styleClass="fieldset"
                    rendered="#{aplicacionDispositivoBean.renderRealizaProcedimiento}">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosOrigen"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Inserción"/>
            <h:outputText/>
            <h:panelGroup id="panelTextDispositivoInsercion">
              <h:outputText value="Dispositivo Insercion" styleClass="labelTextOblig"
                            rendered="#{aplicacionDispositivoBean.renderInsercion}"/>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkInsercion" onkeydown="return blockEnter(event);"
                                       value="#{aplicacionDispositivoBean.renderInsercion}"
                                       valueChangeListener="#{aplicacionDispositivoBean.setRenderInsercion}"
                                       immediate="true">
                <a4j:support id="support1" event="onclick"
                             reRender="panelTextDispositivoInsercion,panelMenuDispositivo,panelMsgDispositivo">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="checkInsercion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup id="panelMenuDispositivo">
                <h:selectOneMenu id="menuDispositivo" required="false"
                                 rendered="#{aplicacionDispositivoBean.renderInsercion}"
                                 onkeydown="return blockEnter(event);"
                                 valueChangeListener="#{aplicacionDispositivoBean.setHdacdispoinser}"
                                 value="#{aplicacionDispositivoBean.dispositivo.hdacdispoinser}">
                  <f:selectItems value="#{aplicacionDispositivoBean.lstTipoDispositivo}"/>
                  <a4j:support id="supportMenuDispositivoInsersion" event="onchange"
                               action="#{aplicacionDispositivoBean.changeDispositivoInsercionORetiro}"
                               reRender="panelDescripcionLugarMarcacion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelMsgDispositivo">
              <a4j:outputPanel ajaxRendered="true" rendered="#{aplicacionDispositivoBean.renderInsercion}">
                <t:message for="menuDispositivo" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
            <h:outputText value="Retiro"/>
            <h:outputText/>
            <h:panelGroup id="panelTextDispositivoRetiro">
              <h:outputText value="Dispositivo Retiro" styleClass="labelTextOblig"
                            rendered="#{aplicacionDispositivoBean.renderRetiro}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextMotivoRetiro">
              <h:outputText value="Motivo del Retiro" styleClass="labelTextOblig"
                            rendered="#{aplicacionDispositivoBean.renderRetiro}"/>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkRetiro" onkeydown="return blockEnter(event);"
                                       value="#{aplicacionDispositivoBean.renderRetiro}"
                                       valueChangeListener="#{aplicacionDispositivoBean.setRenderRetiro}"
                                       immediate="true">
                <a4j:support id="support" event="onclick"
                             reRender="panelTextDispositivoRetiro,panelMsgDispositivoRetiro,panelMenuDispositivoRetiro,panelTextMotivoRetiro,panelMenuMotivoRetiro,panelMsgMotivoRetiro">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="checkRetiro" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup id="panelMenuDispositivoRetiro">
                <h:selectOneMenu id="menuDispositivoRetiro" required="false" onkeydown="return blockEnter(event);"
                                 rendered="#{aplicacionDispositivoBean.renderRetiro}"
                                 valueChangeListener="#{aplicacionDispositivoBean.setHdacdisporetir}"
                                 value="#{aplicacionDispositivoBean.dispositivo.hdacdisporetir}">
                  <f:selectItems value="#{aplicacionDispositivoBean.lstTipoDispositivoRetiro}"/>
                  <a4j:support id="supportMenuDispositivoRetiro" event="onchange"
                               action="#{aplicacionDispositivoBean.changeDispositivoInsercionORetiro}"
                               reRender="panelDescripcionLugarMarcacion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup id="panelMsgDispositivoRetiro">
                <a4j:outputPanel ajaxRendered="true" rendered="#{aplicacionDispositivoBean.renderRetiro}">
                  <t:message for="menuDispositivoRetiro" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelMenuMotivoRetiro">
              <h:selectOneMenu id="mnuMotivoRetiro" rendered="#{aplicacionDispositivoBean.renderRetiro}"
                               required="false" value="#{aplicacionDispositivoBean.dispositivo.hdacmotivretir}">
                <f:selectItems value="#{aplicacionDispositivoBean.lstMotivo}"/>
              </h:selectOneMenu>
            </h:panelGroup>
            <h:panelGroup id="panelMsgMotivoRetiro">
              <a4j:outputPanel ajaxRendered="true" rendered="#{aplicacionDispositivoBean.renderRetiro}">
                <t:message for="mnuMotivoRetiro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDescripcionLugarMarcacion" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Descripción  del lugar de marcación del procedimiento" styleClass="labelTextOblig"
                          rendered="#{aplicacionDispositivoBean.renderLugarMarcacion}"/>
            <h:outputText rendered="#{aplicacionDispositivoBean.renderLugarMarcacion}"/>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         rendered="#{aplicacionDispositivoBean.renderLugarMarcacion}">
              <a4j:commandLink action="#{aplicacionDispositivoBean.mostrarBuscadorPlantillaLugarMarcacion}"
                               reRender="panelGridAplicacionDispositivoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="textDesLugarMarcacion" onkeydown="return blockEnter(event);" immediate="true"
                               binding="#{aplicacionDispositivoBean.itDesclugamarc}"
                               value="#{aplicacionDispositivoBean.dispositivo.hdacdeslugmar}"
                               style="width:500px;height:60px"/>
            </h:panelGrid>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textDesLugarMarcacion" styleClass="errorMessage"
                         rendered="#{aplicacionDispositivoBean.renderLugarMarcacion}"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDescripcionProcedimiento" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Descripción del Procedimiento" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{aplicacionDispositivoBean.mostrarBuscadorPlantilla}"
                               reRender="panelGridAplicacionDispositivoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="textDescripcion" onkeydown="return blockEnter(event);" immediate="true"
                               binding="#{aplicacionDispositivoBean.itDescripcion}"
                               value="#{aplicacionDispositivoBean.dispositivo.hdacdescrproce}"
                               style="width:500px;height:60px"/>
            </h:panelGrid>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textDescripcion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Complicaciones " id="fieldSetDatosComplicacionAplicacion" styleClass="fieldset"
                    rendered="#{aplicacionDispositivoBean.renderRealizaProcedimiento}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelComplicacionesAplicacion" rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Tiene Complicaciones" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuComplicaciones" onkeydown="return blockEnter(event);" immediate="true"
                                  value="#{aplicacionDispositivoBean.tieneComplicaciones}"
                                  valueChangeListener="#{aplicacionDispositivoBean.setTieneComplicaciones}">
                  <f:selectItems value="#{aplicacionDispositivoBean.lstOpciones}"/>
                  <a4j:support id="supportmnuComplicaciones" event="onclick"
                               action="#{aplicacionDispositivoBean.changeComplicaciones}"
                               reRender="panelGroupTextDiagnostico,panelInputDiagnosticoComplicacion,panelTextDescripcionComplicacion,panelInputDescripcionComplicacion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelGroupTextDiagnostico">
              <h:panelGroup rendered="#{aplicacionDispositivoBean.mostrarComplicaciones}">
                <h:outputText value="Diagnostico Complicación" styleClass="labelTextOblig"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelInputDiagnosticoComplicacion">
              <h:panelGroup rendered="#{aplicacionDispositivoBean.mostrarComplicaciones}">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
                  <a4j:commandLink action="#{aplicacionDispositivoBean.mostrarDiagnosticoComplicacion}"
                                   reRender="panelGridAplicacionDispositivoTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                  <h:inputText id="itDiagComplicacion" styleClass="textmayuscula" onkeydown="return blockEnter(event);"
                               binding="#{aplicacionDispositivoBean.itDiagComplicacion}"
                               value="#{aplicacionDispositivoBean.dispositivo.hdacdiagcompli}"
                               valueChangeListener="#{aplicacionDispositivoBean.setHdacdiagcompli}" style="width:50px"
                               maxlength="4">
                    <f:converter converterId="cadena.stringUpperCaseConverter"/>
                    <a4j:support id="supportitDiagComplicacion" event="onchange" ignoreDupResponses="true"
                                 action="#{aplicacionDispositivoBean.changeDiagnosticoComplicacion}"
                                 reRender="panelDiagnosticoComplicacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <f:converter converterId="util.ConverterMayuscula"/>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiagComplicacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:panelGroup id="panelDiagnosticoComplicacion">
                    <h:outputText value=" #{aplicacionDispositivoBean.diagnosticoComplicacion}" styleClass="buscador"/>
                  </h:panelGroup>
                </h:panelGrid>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup id="panelTextDescripcionComplicacion">
              <h:outputText value="Descripción de la Complicación"
                            rendered="#{aplicacionDispositivoBean.mostrarComplicaciones}" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputDescripcionComplicacion">
              <h:inputTextarea id="inputTextareaComplicaciones" onkeydown="return blockEnter(event);"
                               value="#{aplicacionDispositivoBean.dispositivo.hdacdescrcompl}"
                               style="width:500px;height:70px"
                               rendered="#{aplicacionDispositivoBean.mostrarComplicaciones}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputTextareaComplicaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Diagnostico Posterior" id="fieldDiagnosticoPosteriorAplicacion" styleClass="fieldset"
                    rendered="#{aplicacionDispositivoBean.renderRealizaProcedimiento}">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDiagnosticoPosteriorAplicacion" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Posterior"/>
            <h:outputText/>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink action="#{aplicacionDispositivoBean.mostrarDiagnosticoPosterior}"
                               reRender="panelGridAplicacionDispositivoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPosteriorAplicacion" styleClass="textmayuscula"
                           onkeydown="return blockEnter(event);" immediate="true"
                           binding="#{aplicacionDispositivoBean.itDiagPosterior}"
                           value="#{aplicacionDispositivoBean.dispositivo.hdacdiagposter}"
                           valueChangeListener="#{aplicacionDispositivoBean.setHdacdiagposter}" style="width:50px"
                           maxlength="4">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPosteriorAplicacion" event="onchange" ignoreDupResponses="true"
                             immediate="true" action="#{aplicacionDispositivoBean.changeDiagnosticoPosterior}"
                             reRender="panelDiagnosticoPosteriorAplicacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <f:converter converterId="util.ConverterMayuscula"/>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPosteriorAplicacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoAplicacion1">
                <h:outputText value=" #{aplicacionDispositivoBean.diagnosticoPosterior}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>
            <h:outputText value="Realización" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:selectOneMenu id="mnuRealizacionAplicacion"
                             value="#{aplicacionDispositivoBean.dispositivo.hdanrealizacio}">
              <f:selectItems value="#{aplicacionDispositivoBean.lstRealizacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuRealizacionAplicacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionAplicacionDispositivoMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAplicacionDispositivoMsg" showSummary="false" errorClass="error"
                        globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAplicacionDispositivo" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Aceptar" styleClass="boton_fieldset" action="#{aplicacionDispositivoBean.guardar}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelTabBuscadorAplicacionCie10" label="Bucar Diagnosticos"
                rendered="#{aplicacionDispositivoBean.mostrarCie10}">
      <a4j:region id="regionAplicacionCie10" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionAplicacionCie10">
          <f:facet name="start">
            <t:div id="chargingAplicacionCie10" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <s:fieldset legend="Cie10" id="fieldSetAplicacionCie10" styleClass="fieldset">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorCie10Procedimiento.jsp" flush="true"/>
          <h:panelGrid id="panelGridAplicacionCie10Botones" width="100%" columnClasses="columnaBotonesCentrados"
                       dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupCie10Botones1">
              <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                 action="#{aplicacionDispositivoBean.aceptarDiagnostico}"
                                 reRender="panelGridAplicacionDispositivoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantillaAplicacion" label="Buscar Plantillas"
                rendered="#{aplicacionDispositivoBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaAplicacion" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaAplicacion">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaAplicacion" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasProcedimiento.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaAplicacion" width="100%"
                     columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotonesPlantillaAplicacion">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                               action="#{aplicacionDispositivoBean.aceptarPlantilla}"
                               rendered="#{!aplicacionDispositivoBean.buscadorLugarMarcacion}"
                               reRender="panelGridAplicacionDispositivoTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                               action="#{aplicacionDispositivoBean.aceptarPlantillaDescLugarMarcacion}"
                               rendered="#{aplicacionDispositivoBean.buscadorLugarMarcacion}"
                               reRender="panelGridAplicacionDispositivoTab">
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