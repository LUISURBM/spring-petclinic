<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarAnestesiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneRegistrarAnestesia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" selectedIndex="#{registrarAnetesiaBean.selectedIndex}" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabRegistrarAnestesia" label="Datos del Paciente " disabled="#{descripcionQuirurgicaBean.mostrarCie10}">
      <!-- Diagnosticos Preoperatorios -->
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDiagnosticoPreoperatorio" rowClasses="labelText, labelTextInfo">
        <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
        <h:outputText/>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" rowClasses="labelText,labelTextInfo">
          <a4j:commandLink action="#{registrarAnetesiaBean.mostrarDiagnosticoPreoperatorio}" reRender="panelGridRegistrarAnestesiaTab" immediate="true">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
          </a4j:commandLink>
          <h:inputText id="itDiagPrevioCirugia" styleClass="textmayuscula,input-large" onkeydown="return blockEnter(event);" immediate="true" required="true"
                       binding="#{registrarAnetesiaBean.itDiagPreoperatorio}" value="#{registrarAnetesiaBean.anestesia.hancdiagprinci}" valueChangeListener="#{registrarAnetesiaBean.setHancdiagprinci}"
                       style="width:50px" maxlength="4">
            <f:converter converterId="cadena.stringUpperCaseConverter"/>
            <a4j:support id="supportItDiagPreCirugia" event="onchange" ignoreDupResponses="true" immediate="true" action="#{registrarAnetesiaBean.changeDiagnosticoPreoperatorio}"
                         reRender="panelDiagnosticoPreoperatorio">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
            <f:converter converterId="util.ConverterMayuscula"/>
          </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itDiagPrevioCirugia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnostico1Cirugia">
            <h:outputText value=" #{registrarAnetesiaBean.diagnosticoPreoperatorio}" styleClass="buscador"/>
          </h:panelGrid>
        </h:panelGrid>
      </h:panelGrid>
      <!-- Fin Diagnosticos  -->
      <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" rowClasses="labelText,labelTextInfo" width="100%">
        <h:outputText value="Grado Examen ASA" styleClass="labelTextOblig"/>
        <h:outputText value=" "/>
        <h:outputText value=" "/>
        <h:outputText value=" "/>
        <h:outputText value=" "/>
        <h:outputText value=" "/>
        <h:outputText value="Peso del Paciente" styleClass="labelTextOblig"/>
        <h:outputText value=" "/>
        <h:selectOneRadio id="mnuGradoAsaAnestesia" onkeydown="return blockEnter(event);"
        layout="lineDirection" required="true" styleClass="input-group-addon" immediate="true"
                          value="#{registrarAnetesiaBean.anestesia.hanngradoasa}">
          <f:selectItems value="#{registrarAnetesiaBean.lstGradoASA}"/>
        </h:selectOneRadio>
        <h:outputText value=" "/>
        <h:outputText value=""/>
        <h:outputText value=""/>
        <h:panelGroup>
          <h:selectBooleanCheckbox id="checkUrgente" onkeydown="return blockEnter(event);" styleClass="css-checkbox" value="#{registrarAnetesiaBean.esurgencia}"/>
          <h:outputLabel value="Urgencia" for="checkUrgente" styleClass="css-label"/>
        </h:panelGroup>
        <h:outputText value=" "/>
        <h:panelGroup>
          <h:inputText id="itPeso" value="#{registrarAnetesiaBean.anestesia.hannpeso}" required="true" styleClass="input-small"/>
          <h:panelGroup>
            <h:outputText value="  Kg"/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itPeso" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:outputText value=" "/>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuGradoAsaAnestesia" styleClass="errorMessage"/>
        </a4j:outputPanel>
        <h:outputText value=" "/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
      </h:panelGrid>
      <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEstadoPaciente" rowClasses="labelText,labelTextInfo">
        <h:outputText value="Anestesia Solicitada " styleClass="labelTextOblig"/>
        <h:outputText/>
        <h:outputText value="Estado de paciente al ingreso a Quirófano" styleClass="labelTextOblig"/>
        <h:outputText/>
        <h:outputText value="Observaciones Ingreso"/>
        <h:outputText/>
        <h:selectOneRadio id="mnuTipoAnestesia" required="true" immediate="true" onkeydown="return blockEnter(event);" styleClass="css-radio" layout="pageDirection"
                          value="#{registrarAnetesiaBean.anestesia.hanctipoanest}">
          <f:selectItems value="#{registrarAnetesiaBean.lstTipoAnestesia}"/>
        </h:selectOneRadio>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="mnuTipoAnestesia" styleClass="errorMessage"/>
        </a4j:outputPanel>
        <h:selectOneRadio id="textEstadoPacienteLLegar"  immediate="true" required="true" value="#{registrarAnetesiaBean.anestesia.hancestadllega}" layout="pageDirection">
          <f:selectItems value="#{registrarAnetesiaBean.lstEstadoLLegar}"/>
        </h:selectOneRadio>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="textEstadoPacienteLLegar" styleClass="errorMessage"/>
        </a4j:outputPanel>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
          <a4j:commandLink action="#{registrarAnetesiaBean.mostrarBuscadorPlantilla}" immediate="true" reRender="panelGridRegistrarAnestesiaTab">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
          </a4j:commandLink>
          <h:inputTextarea id="textObservacionesIngreso" required="true" onkeydown="return blockEnter(event);" immediate="true" binding="#{registrarAnetesiaBean.itDescripcion}"
                           value="#{registrarAnetesiaBean.anestesia.hancobseringre}" style="width:350px;height:70px"/>
        </h:panelGrid>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="textObservacionesIngreso" styleClass="errorMessage"/>
        </a4j:outputPanel>
        <h:outputText value=" "/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
        <h:outputText/>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesCanalizacion" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Siguiente" styleClass="btn btn btn-info" action="#{registrarAnetesiaBean.registrarAnestesia}"/>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <!-- Buscador de Diagnosticos -->
    <t:panelTab id="panelTabBuscadorDescripcionQuirurgicaCie10" label="Bucar Diagnosticos" rendered="#{registrarAnetesiaBean.mostrarCie10}">
      <a4j:region id="regionDescripcionQuirurgicaCie10" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionDescripcionQuirurgicaCie10">
          <f:facet name="start">
            <t:div id="chargingDescripcionQuirurgicaCie10" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <s:fieldset legend="Cie10" id="fieldSetDescripcionQuirurgicaCie10" styleClass="fieldset">
          <jsp:include page="/pages/clinico/comunes/buscador/buscadorCie10Procedimiento.jsp" flush="true"/>
          <h:panelGrid id="panelGridDescripcionQuirurgicaCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupDescripcionQuirurgicaCie10Botones1">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success" action="#{registrarAnetesiaBean.aceptarDiagnostico}" reRender="panelGridRegistrarAnestesiaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantilla" label="Buscar Plantillas" rendered="#{registrarAnetesiaBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantilla" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantilla">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantilla" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantilla" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <h:panelGrid>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionCanalizacionMsg" ajaxRendered="true">
        <t:messages id="msgInformationCanalizacionMsg" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>