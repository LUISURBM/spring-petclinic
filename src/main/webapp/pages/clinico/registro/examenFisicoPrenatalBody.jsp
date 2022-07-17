<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formExamenFisicoPrenatal">
 <a4j:region id="regionExamenFisicoPrenatal" renderRegionOnly="false">
    <a4j:status  id = "statusButton" for="regionExamenFisicoPrenatal">
      <f:facet name="start">
        <t:div id="chargingExamenFisicoPrenatal" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>

 
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridExamenFisicoPrenatalTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneExamenFisicoPrenatal"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabExamenFisiscoPrenatal" label="Examen Fisico Prenatal">

 <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%"
                     id="tableContentTabsexamenFisicoPrenatal"
                     styleClass="tabContainer">

      <s:fieldset legend="Datos Examen Fisico" id="fieldExamenFisico"
                  styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelDatosExamen"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Presion Arterial" styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Cardiaca"
                          styleClass="labelTextOblig"/>
            <h:outputText value="Frecuencia Respiratoria"
                          styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:inputText id="itPresion" title="mm Hg" required="true"
                           onkeydown="return blockEnter(event);"
                           value="#{examenFisicoPrenatal.control.hcpcpresart1}"
                           style="width:30px" maxlength="3"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="/"/>
              <h:inputText id="itPresion2" title="mm Hg" required="true"
                           onkeydown="return blockEnter(event);"
                           value="#{examenFisicoPrenatal.control.hcpcpresart2}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="  mm Hg"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itPresion2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itCardiaca" title="latidos por minuto"
                           onkeydown="return blockEnter(event);" required="true"
                           value="#{examenFisicoPrenatal.control.hcpnfreccard}"
                           style="width:30px" maxlength="3"/>
              <h:outputText value="  l.p.m"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCardiaca" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itRespiratoria" title="respiraciones por minuto"
                           onkeydown="return blockEnter(event);" required="true"
                           value="#{examenFisicoPrenatal.control.hcpnfrecresp}"
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
                             value="#{examenFisicoPrenatal.control.hcpapeso}"
                             style="width:40px" maxlength="4"
                             title="Peso en Kilogramos"/>
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
                           value="#{examenFisicoPrenatal.control.hcpatalla}"
                           valueChangeListener="#{examenFisicoPrenatal.setTalla}"
                           style="width:40px" maxlength="4">
                <a4j:support id="supportIMC" event="onchange"
                             action="#{examenFisicoPrenatal.calcularIMC}"
                             reRender="tableContentTabsexamenFisicoPrenatal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTalla" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="  mts  "/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText id="itMasaCorporal"
                            value="#{examenFisicoPrenatal.control.hcpaimc}"
                            style="width:30px"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itMasaCorporal" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Temperatura"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value=""/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value=""/>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itTemperaura" required="true"
                           onkeydown="return blockEnter(event);"
                           title="Temperatura en grados centígrados"
                           value="#{examenFisicoPrenatal.control.hcpatemperatu}"
                           style="width:50px" maxlength="5"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itTemperaura" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value="  ºC"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
          </h:panelGrid>
        </a4j:region>
      </s:fieldset>
      <s:fieldset legend="Examen Fisico Prenatal"
                  id="fieldExamenesFisicoPrenatal" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelexamenFisicoPrenatal"
                     rowClasses="labelText">
          <h:outputText value="Examen Clinico" styleClass="labelTextOblig"/>
          <h:outputText value="Examen de Mamas" styleClass="labelTextOblig"/>
          <h:outputText value="Examen Odontologico"
                        styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenClinico" immediate="true"
                              required="true" styleClass="labelRadio"
                              value="#{examenFisicoPrenatal.control.hcpeexaclinico}">
              <f:selectItems value="#{examenFisicoPrenatal.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenClinico" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenMama" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpeexamemamas}">
              <f:selectItems value="#{examenFisicoPrenatal.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenMama" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenOdontologico" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpeexaodontol}">
              <f:selectItems value="#{examenFisicoPrenatal.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenOdontologico" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Pelvis" styleClass="labelTextOblig"/>
          <h:outputText value="Citologia" styleClass="labelTextOblig"/>
          <h:outputText value="Cervix" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenPelvis" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpeexamepelvi}">
              <f:selectItems value="#{examenFisicoPrenatal.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenPelvis" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenCitologia" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpeexacitolog}">
              <f:selectItems value="#{examenFisicoPrenatal.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenCitologia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuExamenCervix" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpeexamcervix}">
              <f:selectItems value="#{examenFisicoPrenatal.lstNormal}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuExamenCervix" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Altura Uterina" />
          <h:outputText value="Frecuencia Cardiaca Fetal"
                        styleClass="labelTextOblig"/>
          <h:outputText value="Movimiento Fetal" styleClass="labelTextOblig"/>
          <h:inputText value="#{examenFisicoPrenatal.control.hcpnaltuterina}"
                       disabled="#{!examenFisicoPrenatal.habilitarAlturaUterina}"
                       maxlength="3" style="width:30px"/>
          <h:inputText value="#{examenFisicoPrenatal.control.hcpnfcf}" required="true"
                       disabled="#{!examenFisicoPrenatal.habilitarFCF}"
                       maxlength="2" style="width:30px"/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuMovimientoFetal" immediate="true"
                              styleClass="labelRadio" required="true"
                              disabled="#{!examenFisicoPrenatal.habilitarmovimientoFetal}"
                              value="#{examenFisicoPrenatal.control.hcpcmovimfetal}">
              <f:selectItems value="#{examenFisicoPrenatal.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMovimientoFetal" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Presentación Fetal"/>
          <h:outputText value="Edemas" styleClass="labelTextOblig"/>
          <h:outputText value="Valoración Cuello Uterino"
                        styleClass="labelTextOblig"/>
          <h:inputText value="#{examenFisicoPrenatal.control.hcpcpresefetal}" required="false"
                      disabled="#{!examenFisicoPrenatal.habilitarpresentacionFetal}"
                       maxlength="10"/>
         <h:panelGroup>
            <h:selectOneRadio id="mnuEdemas" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpeedemas}">
              <f:selectItems value="#{examenFisicoPrenatal.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuEdemas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuValoracionCuello" immediate="true"
                              styleClass="labelRadio" required="true"
                              value="#{examenFisicoPrenatal.control.hcpevalcueuter}">
              <f:selectItems value="#{examenFisicoPrenatal.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuValoracionCuello" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>

        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelDatosExamenHallazgosControlPrenatal"
                     rowClasses="labelText">
          <h:outputText value="Hallazgos del examen físico"
                        styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:inputTextarea id="textHallazgosControlPrenatal" required="true"
                             value="#{examenFisicoPrenatal.control.hcpthallazgo}"
                             style="width:600px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textHallazgosControlPrenatal"
                         styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelexamenFisicoPrenatalBoton"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                             action="#{examenFisicoPrenatal.aceptar}">
            <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    
    </h:panelGrid><h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionexamenFisicoPrenatal"
                         ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsexamenFisicoPrenatal"
                      showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
</t:panelTab>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>