<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<a4j:form id="formExamenFisico">
 <a4j:region id="regionExamenFisico" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionExamenFisico">
      <f:facet name="start">
        <t:div id="chargingExamenFisico" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

   

  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenFisicoTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenFisico"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenFisico" label="Examen Fisico">
 <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="tableContentTabsExamenFisico"
                     styleClass="tabContainer">
      <s:fieldset legend="Datos Examen Fisico" id="fieldExamenFisico"
                  styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelDatosExamen"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Presión Arterial" styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Cardiaca"
                          styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Respiratoria"
                          styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputText id="itPresion" title="mm Hg" required="true"
                             onkeydown="return blockEnter(event);"
                           value="#{examenFisicoBean.examen.hefcpresart1}"
                           style="width:30px" maxlength="3"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="/"/>
              <h:inputText id="itPresion2" title="mm Hg" required="true"
                           onkeydown="return blockEnter(event);"
                           value="#{examenFisicoBean.examen.hefcpresart2}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="  mm Hg"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itCardiaca" title="latidos por minuto"
                             onkeydown="return blockEnter(event);"
                           required="true"
                           value="#{examenFisicoBean.examen.hefnfreccard}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="  l.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCardiaca" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itRespiratoria" title="respiraciones por minuto"
                             onkeydown="return blockEnter(event);"
                           required="true"
                           value="#{examenFisicoBean.examen.hefnfrecresp}"
                           style="width:30px" maxlength="2"/>
              <h:outputText value="  r.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itRespiratoria" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value="Peso" styleClass="labelTextOblig"/>
            <h:outputText value="Talla" styleClass="labelTextOblig"/>
            <h:outputText value="IMC" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itPeso" required="true"
                            onkeydown="return blockEnter(event);"
                             value="#{examenFisicoBean.peso}" 
                             valueChangeListener="#{examenFisicoBean.setPeso}"
                             style="width:40px"
                             maxlength="4" title="Peso en Kilogramos">
                 <a4j:support id="supportPesoIMC" event="onchange" 
                             action="#{examenFisicoBean.calcularIMC}"
                             reRender="itIndiceMasaCorporal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
             </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itPeso" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value="  kg"/>
              </h:panelGroup>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itTalla" title="Talla en metros" required="true"
                            onkeydown="return blockEnter(event);"
                           value="#{examenFisicoBean.talla}"
                           valueChangeListener="#{examenFisicoBean.setTalla}"
                           style="width:40px" maxlength="4">
                <a4j:support id="supportIMC" event="onchange" oncomplete="imcJs()"
                             action="#{examenFisicoBean.calcularIMC}"
                             reRender="itIndiceMasaCorporal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTalla" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="  mts  "/>
            </h:panelGroup>
            <h:panelGroup id = "itIndiceMasaCorporal">
              <h:outputText id="itMasaCorporal"
                            value="#{examenFisicoBean.masacor}"
                            style="width:30px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMasaCorporal" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Temperatura"/>
            </h:panelGroup>
             <h:outputText value=""/>
            <h:panelGroup>
              <h:outputText value="Perímetro Cefálico"
                            rendered="#{examenFisicoBean.esPediatria}"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itTemperaura" required="true"
                            onkeydown="return blockEnter(event);"
                           title="Temperatura en grados centígrados"
                           value="#{examenFisicoBean.examen.hefatemperatu}"
                           style="width:50px" maxlength="5"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTemperaura" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="  ºC"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itPerimetro" title="perimetro en centímetros"
                            onkeydown="return blockEnter(event);"
                           value="#{examenFisicoBean.examen.hefnpericefali}"
                           rendered="#{examenFisicoBean.esPediatria}"
                           style="width:20px" maxlength="2"/>
              <h:outputText value="   cm"
                            rendered="#{examenFisicoBean.esPediatria}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPerimetro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Saturación de oxihemoglobina"
                            rendered="#{examenFisicoBean.esPediatria}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup>
              <h:inputText id="itSaturacion"
                           onkeydown="return blockEnter(event);"
                           rendered="#{examenFisicoBean.esPediatria}"
                           value="#{examenFisicoBean.examen.hefnsatuoxihe}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="    O2"
                            rendered="#{examenFisicoBean.esPediatria}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itSaturacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </a4j:region>
      </s:fieldset>
      <s:fieldset legend="Hallazgos" id="fieldHallazgos" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosExamenHallazgos"
                     rowClasses="labelText">
          <h:outputText value="Hallazgos del examen físico"
                        styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputTextarea id="textHallazgos" required="true"
                             value="#{examenFisicoBean.examen.hefthallazgo}"
                             style="width:600px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazgos" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                               action="#{examenFisicoBean.aceptar}">
            
            <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors1" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
  
</a4j:form>
