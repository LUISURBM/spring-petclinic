<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridExamenFisicoDermatologiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneExamenFisicoDermatologia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabExamenFisicoDermatologia" label="Examen Fisico">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsExamenFisicoDermatologia"
                   styleClass="tabContainer">
        <s:fieldset legend="Datos Examen Fisico" id="fieldExamenFisicoDermatologia" styleClass="fieldset">
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosExamenDermatologia"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Presión Arterial"
                            styleClass="labelTextOblig"/>
              <h:outputText value="Peso"
                            styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup>
                <h:inputText id="itPresionDermatologia" title="mm Hg" required="#{!examenFisicoUsuarioBean.campoopcional}"
                             onkeydown="return blockEnter(event);"
                             value="#{examenFisicoUsuarioBean.examen.hefcpresart1}" style="width:30px" maxlength="3"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPresionDermatologia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="/"/>
                <h:inputText id="itPresion2Dermatologia" title="mm Hg" required="#{!examenFisicoUsuarioBean.campoopcional}"
                             onkeydown="return blockEnter(event);"
                             value="#{examenFisicoUsuarioBean.examen.hefcpresart2}" style="width:30px" maxlength="3"/>
                <h:outputText value="  mm Hg"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPresion2Dermatologia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itPesoDermatologia" style="width:40px" maxlength="4"
                               required="#{!examenFisicoUsuarioBean.campoopcional}"
                               onkeydown="return blockEnter(event);" value="#{examenFisicoUsuarioBean.peso}"
                               title="Peso en Kilogramos"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itPesoDermatologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="  kg"/>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText/>
            </h:panelGrid>
          </a4j:region>
        </s:fieldset>
        <s:fieldset legend="Hallazgos" id="fieldHallazgosDermatologia" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelDatosExamenDermatologiaHallazgos" rowClasses="labelText">
            <h:outputText value="Hallazgos del examen físico"
                          styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputTextarea id="textHallazgosDermatologia" 
                              required="#{!examenFisicoUsuarioBean.campoopcional}"
                               value="#{examenFisicoUsuarioBean.examen.hefthallazgo}" style="width:650px;height:100px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textHallazgosDermatologia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{examenFisicoUsuarioBean.guardarExamen}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>