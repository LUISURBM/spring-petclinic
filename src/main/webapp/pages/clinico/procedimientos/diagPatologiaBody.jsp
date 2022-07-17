<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="infoClinicaForm">
  <a4j:region id="bodyRegionCU">
    <a4j:status id="statusButton" for="bodyRegionCU">
      <f:facet name="start">
        <t:div id="chargindDiv2" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Patologia - Registro de Diagnostico " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneParametro" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabInfoGenral" label="Patologia" rendered="true">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
              <h:outputLabel value="Num. Listado" for="olNumListado"/>
              <h:outputText value=""/>
              <h:outputLabel value="Num. patologia" for="olNumPatologia"/>
              <h:outputText value=""/>
              <h:outputText value="#{resultadoPatologiaBean.chotraspatologClone.idListado}" id="olNumListado"/>
              <t:message for="olNumListado" errorClass="errorMessage"/>
              <h:outputText value="#{resultadoPatologiaBean.chotraspatologClone.chopnconsec}" id="olNumPatologia"/>
              <t:message for="olNumPatologia" errorClass="errorMessage"/>
              <h:outputLabel value="Usuario(a)" for="olUsuario"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value="#{resultadoPatologiaBean.chotraspatologClone.tipoIden} #{resultadoPatologiaBean.chotraspatologClone.numInden} - #{resultadoPatologiaBean.chotraspatologClone.nombusuario}"
                            id="olUsuario"/>
              <t:message for="olUsuario" errorClass="errorMessage"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputLabel value="Documento" for="olDocumento"/>
              <h:outputText value=""/>
              <h:outputLabel value="Servicio" for="olServicio"/>
              <h:outputText value=""/>
              <h:outputText value="#{resultadoPatologiaBean.chotraspatologClone.descTipoDoc} - #{resultadoPatologiaBean.chotraspatologClone.chopnnumdoc}" id="olDocumento"/>
              <t:message for="olDocumento" errorClass="errorMessage"/>
              <h:outputText value="#{resultadoPatologiaBean.chotraspatologClone.chopccodiserv} - #{resultadoPatologiaBean.chotraspatologClone.nombServcio}" id="olServicio"/>
              <t:message for="olServicio" errorClass="errorMessage"/>
              <h:outputLabel value="Etapa" for="olEtapa"/>
              <h:outputText value=""/>
              <h:outputLabel value="Estado" for="olEstado"/>
              <h:outputText value=""/>
              <h:outputText value="#{resultadoPatologiaBean.chotraspatologClone.descetapa}" id="olEtapa"/>
              <t:message for="olEtapa" errorClass="errorMessage"/>
              <h:panelGroup id="panelGroupRadio">
                <h:selectOneRadio id="olEstado" value="#{resultadoPatologiaBean.estadopatol}" required="true" immediate="true" valueChangeListener="#{resultadoPatologiaBean.setEstadopatol}"
                                  layout="pageDirection">
                  <f:selectItem itemLabel="Registar Diagnostico" itemValue="RD"/>
                  <f:selectItem itemLabel="No recibido" itemValue="NR"/>
                  <a4j:support id="sprtjEstados" event="onclick" immediate="true" reRender="tableContentTabs">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </h:panelGroup>
              <t:message for="olEstado" styleClass="errorMessage"/>
            </h:panelGrid>
            <h:panelGrid rendered="#{resultadoPatologiaBean.estadopatol == \'RD\'}" columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDiagnosticoP"
                         columnClasses="columnaBotonesCentrados">
              <h:outputLabel value="Diagnostico Patologia" styleClass="labelTextOblig" for="itchopcdiagn"/>
              <h:outputText value=""/>
              <h:inputTextarea value="#{resultadoPatologiaBean.chotraspatologClone.chopcdiagn}" rows="2" style="width:500px" id="itchopcdiagn" required="true">
                <f:validateLength maximum="100"/>
              </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itchopcdiagn" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
              <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <a4j:commandButton value="Registrar" action="#{resultadoPatologiaBean.guardar}" reRender="tableContentTabs" styleClass="boton_fieldset"/>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid>
        <h:commandLink action="#{resultadoPatologiaBean.volverConsulta}" immediate="true">
          <t:graphicImage border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>