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
      <h:outputText value="Historias Clinicas >> Profesionales lectura" id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneParametro" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabInfoGenral" label="#{profesionalLecturaBean.titulo}" rendered="true">
          <t:htmlTag value="br"/>
          <s:fieldset legend="Datos Basicos" id="fieldSetInfoBasica" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
              <h:outputLabel value="Clinica profesional" for="cltlncodtilla" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputLabel value="Profesional" for="cltlncodsutilla" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:selectOneMenu id="cltlncodtilla" value="#{profesionalLecturaBean.idCentro}" required="true" immediate="true" disabled="#{profesionalLecturaBean.editar}"
                               valueChangeListener="#{profesionalLecturaBean.setIdCentro}">
                <f:selectItem itemLabel="Seleccione una opción..." itemValue=""/>
                <f:selectItems value="#{profesionalLecturaBean.listCentros}"/>
                <a4j:support id="support1" action="#{profesionalLecturaBean.changeCentros}" event="onchange" immediate="true" reRender="panelgridSubTipoCon">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
              <t:message for="cltlncodtilla" errorClass="errorMessage"/>
              <h:panelGrid id="panelgridSubTipoCon" columns="2">
                <h:selectOneMenu id="cltlncodsutilla" value="#{profesionalLecturaBean.idProfesionalLectura}" required="true" disabled="#{profesionalLecturaBean.editar}">
                  <f:selectItem itemLabel="Seleccione una opción..." itemValue=""/>
                  <f:selectItems value="#{profesionalLecturaBean.listProfesionalLecturas}"/>
                </h:selectOneMenu>
                <t:message for="cltlncodsutilla" id="messagecltlncodsutilla" errorClass="errorMessage"/>
              </h:panelGrid>
              <h:outputText value=" "/>
              <h:outputLabel value="Centro para Lectura" for="hplnclinlect" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:outputLabel value="Estado" for="cltacestado" styleClass="labelTextOblig"/>
              <h:outputText value=" "/>
              <h:selectOneMenu id="hplnclinlect" value="#{profesionalLecturaBean.idCentroLectura}" required="true" disabled="#{profesionalLecturaBean.editar}">
                <f:selectItem itemLabel="Seleccione una opción..." itemValue=""/>
                <f:selectItem itemLabel="NACIONAL" itemValue="0"/>
                <f:selectItems value="#{profesionalLecturaBean.listCentros}"/>
              </h:selectOneMenu>
              <t:message for="hplnclinlect" errorClass="errorMessage"/>
              <h:panelGroup id="panelGroupRadio">
                <h:selectOneRadio id="clslcestado" value="#{profesionalLecturaBean.profesionalLecClone.hplcestado}" required="true">
                  <f:selectItem itemLabel="Vigente" itemValue="VG"/>
                  <f:selectItem itemLabel="Inactivo" itemValue="XX"/>
                </h:selectOneRadio>
              </h:panelGroup>
              <t:message for="clslcestado" styleClass="errorMessage"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
              <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
              <h:panelGroup>
                <a4j:commandButton value="Adicionar" action="#{profesionalLecturaBean.guardar}" reRender="tableContentTabs" rendered="#{profesionalLecturaBean.adicionar}" styleClass="boton_fieldset"/>
                <a4j:commandButton value="Actualizar" action="#{profesionalLecturaBean.modificar}" reRender="tableContentTabs" rendered="#{profesionalLecturaBean.editar}" styleClass="boton_fieldset"/>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid>
        <h:commandLink action="#{profesionalLecturaBean.volverConsulta}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </h:panelGrid>
    </h:panelGrid>
  </a4j:region>
</a4j:form>