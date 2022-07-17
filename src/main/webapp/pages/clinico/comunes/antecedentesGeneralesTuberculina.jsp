<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTuberculinaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAntecedentesGeneralesTuberculina"
                     styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesGeneralesTuberculina" label="Antecedentes Tuberculina">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentesGeneralesTuberculina" styleClass="tabContainer">
        <s:fieldset legend="Aplicación" id="fieldAntecedentes" styleClass="fieldset">
          <h:panelGrid columns="1">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Fecha de aplicación"  styleClass="labelTextOblig"/>
                <t:inputCalendar id="fechaAplicaiconTuberculina" title="Formato: dd/mm/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haedfechaplic}" popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaAplicaiconTuberculina" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputLabel value="Peso"  styleClass="labelTextOblig"/>
              <h:inputText id="textPeso" value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haenpeso}" required="true" style="width:200px" maxlength="50"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textPeso" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputLabel value="Talla"  styleClass="labelTextOblig"/>
              <h:inputText id="textTalla" value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haentalla}" required="true" style="width:200px" maxlength="50"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textTalla" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="AntecedentesEspecificos" id="fieldAntecedentesEspecificos" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedenteDesarrolloInfantil" rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Presenta o ha presentado tuberculosis " styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesEspecificos"  value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haecprestuber}"
                                    valueChangeListener="#{AntecedentesGeneralesTuberculinaBean.setHaecprestuber}" required="true">
                    <f:selectItems value="#{AntecedentesGeneralesTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesEspecificos" event="onclick" action="#{AntecedentesGeneralesTuberculinaBean.changePresentaTuber}" reRender="panelInputCuandoTuber">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesEspecificos" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputCuandoTuber">
                  <h:outputLabel value="¿Cuándo?" styleClass="labelTextOblig" rendered="#{AntecedentesGeneralesTuberculinaBean.renderCualPresenta}"/>
                  <h:inputText id="itCuandoTuber" required="true" rendered="#{AntecedentesGeneralesTuberculinaBean.renderCualPresenta}"
                               value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haeccuantuber}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCuandoTuber" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Recibió tratamiento "  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesEspecificosTrata"  value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haecrecibtrata}"
                                    valueChangeListener="#{AntecedentesGeneralesTuberculinaBean.setHaecrecibtrata}" required="true">
                    <f:selectItems value="#{AntecedentesGeneralesTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesEspecificosTrata" event="onclick" action="#{AntecedentesGeneralesTuberculinaBean.changeTratamientoTuber}" reRender="panelInputTrataTuber">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesEspecificosTrata" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputTrataTuber">
                  <h:outputLabel value="¿Por cuánto tiempo ?" styleClass="labelTextOblig"  rendered="#{AntecedentesGeneralesTuberculinaBean.renderTratamiento}"/>
                  <h:inputText id="itTiempoTuber" required="true" rendered="#{AntecedentesGeneralesTuberculinaBean.renderTratamiento}"
                               value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haectiemptrata}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTiempoTuber" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="Ha estado en contacto con alguien que tenga o hay tenido tuberculosis ? "  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesEspecificosContacto"  value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haeccontactubercu}"
                                    valueChangeListener="#{AntecedentesGeneralesTuberculinaBean.setHaeccontactubercu}" required="true">
                    <f:selectItems value="#{AntecedentesGeneralesTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesEspecificosContacto" event="onclick" action="#{AntecedentesGeneralesTuberculinaBean.changeContactoTuber}" reRender="panelInputContactoTuber">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesEspecificosContacto" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputContactoTuber">
                  <h:outputLabel value="¿Quién?" styleClass="labelTextOblig"  rendered="#{AntecedentesGeneralesTuberculinaBean.renderContacto}"/>
                  <h:inputText id="itContactoTuber" required="true" rendered="#{AntecedentesGeneralesTuberculinaBean.renderContacto}"
                               value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haecquiencontac}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itContactoTuber" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
            
            <h:panelGroup>
              <h:panelGrid columns="1">
                <h:outputLabel value="¿Vive con él?"  styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuAntecedentesEspecificosVive" immediate="true" value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haecviveconel}"
                                    valueChangeListener="#{AntecedentesGeneralesTuberculinaBean.setHaecviveconel}" required="true">
                    <f:selectItems value="#{AntecedentesGeneralesTuberculinaBean.lstOpciones}"/>
                    <a4j:support id="supportAntecedentesEspecificosVive" event="onclick" action="#{AntecedentesGeneralesTuberculinaBean.changeViveTuber}" reRender="panelInputViveTuber">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentesEspecificosVive" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelInputViveTuber">
                  <h:outputLabel value="¿Cuanto tiempo compartió con el?" styleClass="labelTextOblig" rendered="#{AntecedentesGeneralesTuberculinaBean.renderVive}"/>
                  <h:inputText id="itViveTuber" required="true" rendered="#{AntecedentesGeneralesTuberculinaBean.renderVive}"
                               value="#{AntecedentesGeneralesTuberculinaBean.antecedespec.haectiempocompart}"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itViveTuber" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>
    </t:panelTab>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonGuardarAntecedenteTuberculina" columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{AntecedentesGeneralesTuberculinaBean.aceptar}">
          <a4j:support event="onclick" status="statusButton" reRender="panelTabAntecedentesGeneralesTuberculina"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>