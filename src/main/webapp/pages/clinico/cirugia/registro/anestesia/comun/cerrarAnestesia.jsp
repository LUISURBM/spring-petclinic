<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCerrarAnestesiaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneCerrarAnestesia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabCerrarAnestesia" label="Finalización de Atención ">
      <s:fieldset legend="Estado del Paciente" id="fieldEstadoPaciente" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEstadoPaciente" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Estado de paciente al egreso del quirófano" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <!-- ***** -->
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
            <a4j:commandLink action="#{cerrarAnestesiaBean.mostrarBuscadorPlantilla}" immediate="true" reRender="panelGridCerrarAnestesiaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
            </a4j:commandLink>
            <h:inputTextarea id="textEstadoPacienteEgresoQuirofano" required="true" onkeydown="return blockEnter(event);" immediate="true" binding="#{cerrarAnestesiaBean.itDescripcion}"
                             value="#{cerrarAnestesiaBean.cierreanestesia.hcicestadsalir}" style="width:350px;height:70px"/>
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textEstadoPacienteEgresoQuirofano" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <!-- ***** -->
          <h:outputText/>
          <h:outputText/>
          <h:outputText value="Tiene Complicaciones " styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGroup id="panelCualCompli">
            <h:outputText value="Cuales Complicaciones? " styleClass="labelTextOblig" rendered="#{cerrarAnestesiaBean.renderComplicaciones}"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuComplicacionAnestesia" onkeydown="return blockEnter(event);" immediate="true" required="true" value="#{cerrarAnestesiaBean.cierreanestesia.hciccomplicaci}"
                              valueChangeListener="#{cerrarAnestesiaBean.setHciccomplicaci}">
              <f:selectItems value="#{cerrarAnestesiaBean.lstOpciones}"/>
              <a4j:support id="supportmnuComplicacionAnestesia" event="onclick" action="#{cerrarAnestesiaBean.ChangeComplicacion}" reRender="panelCualCompli,panelInputComplicaciones">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuComplicacionAnestesia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id="panelInputComplicaciones">
            <h:inputTextarea id="textObservacionesComplicaciones" style="width:550px;height:70px" required="true" rendered="#{cerrarAnestesiaBean.renderComplicaciones}"
                             value="#{cerrarAnestesiaBean.cierreanestesia.hcicobsercompl}">
              <f:validateLength maximum="4000"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textObservacionesComplicaciones" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObservacionAnestesia" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Observaciones"/>
          <h:outputText/>
          <h:inputTextarea id="textObservaciones" style="width:550px;height:70px" value="#{cerrarAnestesiaBean.cierreanestesia.hcicobservacio}">
            <f:validateLength maximum="4000"/>
          </h:inputTextarea>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textObservaciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesCanalizacion" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Finalizar Atención" styleClass="btn btn btn-danger" onclick="if (!confirm(\'¿Esta seguro de Cerrar el registro de anestesia \')) return false"
                         action="#{cerrarAnestesiaBean.cerrarAnestesia}"/>
      </h:panelGroup>
    </h:panelGrid>
    <t:panelTab id="panelBuscadorPlantilla" label="Buscar Plantillas" rendered="#{cerrarAnestesiaBean.renderPlantilla}">
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