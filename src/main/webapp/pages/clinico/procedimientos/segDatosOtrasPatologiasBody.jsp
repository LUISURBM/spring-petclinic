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
      <h:outputText value="HISTORIAS CLINICAS >> Patologia >> Consulta de Patologia " id="infoUbication"/>
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
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.idListado}" id="olNumListado"/>
              <t:message for="olNumListado" errorClass="errorMessage"/>
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.chopnconsec}" id="olNumPatologia"/>
              <t:message for="olNumPatologia" errorClass="errorMessage"/>
              <h:outputLabel value="Usuario(a)" for="olUsuario"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.tipoIden} #{seguimientoPatologiasBean.chotraspatologClone.numInden} - #{seguimientoPatologiasBean.chotraspatologClone.nombusuario}"
                            id="olUsuario"/>
              <t:message for="olUsuario" errorClass="errorMessage"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputLabel value="Documento" for="olDocumento"/>
              <h:outputText value=""/>
              <h:outputLabel value="Servicio" for="olServicio"/>
              <h:outputText value=""/>
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.descTipoDoc} - #{seguimientoPatologiasBean.chotraspatologClone.chopnnumdoc}" id="olDocumento"/>
              <t:message for="olDocumento" errorClass="errorMessage"/>
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.chopccodiserv} - #{seguimientoPatologiasBean.chotraspatologClone.nombServcio}" id="olServicio"/>
              <t:message for="olServicio" errorClass="errorMessage"/>
              <h:outputLabel value="Etapa" for="olEtapa"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.descetapa}" id="olEtapa"/>
              <t:message for="olEtapa" errorClass="errorMessage"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
            </h:panelGrid>
            <h:panelGrid rendered="#{seguimientoPatologiasBean.estadopatol == \'RD\'}" columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDiagnosticoP"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Diagnostico Patologia" />
              <h:outputText value=""/>
              <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.chopcdiagn}" id="itchopcdiagn"/>
              <h:outputText value=""/>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCitologiaEnt" rowClasses="labelText,labelTextInfo"
                         rendered="#{seguimientoPatologiasBean.chotraspatologClone.etapapatol == \'EU\'}">
              <h:outputText value="Fecha de Entrega "/>
              <h:outputText value="Reclama la Usuaria? "/>
                            <h:outputText value="#{seguimientoPatologiasBean.chotraspatologClone.chopdfechaent}">
                <f:convertDateTime pattern="dd/MM/yyyy"/>
              </h:outputText>
              <h:selectOneRadio id="mnuEntrega" immediate="true" required="true" value="#{seguimientoPatologiasBean.reclamaUsuaria}"
                                valueChangeListener="#{seguimientoPatologiasBean.setReclamaUsuaria}" disabled="true">
                <f:selectItem itemLabel="Si" itemValue="S"/>
                <f:selectItem itemLabel="No" itemValue="N"/>
              </h:selectOneRadio>

            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridCitologia2" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Nombre de la persona que reclama "   rendered="#{seguimientoPatologiasBean.reclamaUsuaria == \'N\'}"/>
              <h:outputText value="Parentesco "   rendered="#{seguimientoPatologiasBean.reclamaUsuaria == \'N\'}"/>
              <h:outputText id="itNombreReclama" value="#{seguimientoPatologiasBean.chotraspatologClone.chopcnombrerecl}" rendered="#{seguimientoPatologiasBean.reclamaUsuaria == \'N\'}"
                            style="width:250px"/>
              <h:outputText id="itParentescoReclama" rendered="#{seguimientoPatologiasBean.reclamaUsuaria == \'N\'}" value="#{seguimientoPatologiasBean.chotraspatologClone.chopcparentesco}"
                            style="width:250px"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
              <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid>
        <h:commandLink action="#{seguimientoPatologiasBean.volverConsulta}" immediate="true">
          <t:graphicImage border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>