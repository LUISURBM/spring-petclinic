<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridvaloracionBiopsicosocialsGinecoObstetricosTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPanevaloracionBiopsicosocialsObstetricos" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabvaloracionBiopsicosocialsObstetricos" label="Valoracion Biopsicosocial">
      <h:panelGrid columns="2" id="tableInfoUbicationSemanaPrenatal" border="0" cellpadding="0" cellspacing="0"
                   width="100%" columnClasses="td_alertas">
        <h:outputText styleClass="lableTextOblig" value="Puntos:"/>
        <h:outputText value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnpuntos}">
          <f:convertNumber maxFractionDigits="2"/>
        </h:outputText>
      </h:panelGrid>
      <h:panelGrid id="panelMensajesGinecoObstetricos">
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGroup id="mensajePuntos">
      <h:outputText value="#{valoracionBiopsicosocialBean.mensajePuntos}"
                    style="font-size: 150%;color:blue;" rendered="#{valoracionBiopsicosocialBean.renderPuntos}"/>
      </h:panelGroup>
      
      <s:fieldset legend="Historia Repoductiva" id="fieldHistoriaReproductiva" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelHistoriaReproductiva"
                     rowClasses="labelCuestionario3,labelCuestionario4">
          <h:panelGroup>
            <h:outputText value="Edad" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Paridad" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Cesárea Previa" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:outputText id="inputEdad" 
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnedad}">
                
              </h:outputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputEdad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:outputText id="inputParidad" 
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnparidad}">
              </h:outputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputParidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuCesariaPrev" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbccesaprev}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbccesaprev}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportCesariaPrev" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuCesariaPrev" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Preeclampsia o Hipertensión" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Abortos recurrentes o infertilidad" styleClass="labelTextNoOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Hemorragia postparto o remoción" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuPreeOHiper" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcpreehipe}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcpreehipe}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportCPreeOHiper" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPreeOHiper" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuAbortoOInfer" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcaborinfe}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcaborinfe}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportAbortoOInfer" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAbortoOInfer" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuHemorragiaORemocio" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbchemposrem}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbchemposrem}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportHemorragiaORemocio" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuHemorragiaORemocio" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Manual de placenta" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Peso del recién nacido" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Mortalidad fetal tardía o neonatal temprana" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuManualPlacenta" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcmanuplac}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcmanuplac}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportManualPlacenta" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuManualPlacenta" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:inputText id="inputPesoRecienNacido" maxlength="4" style="width:30px"
                           onkeydown="return blockEnter(event);"
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnpesrecnac}"
                           valueChangeListener="#{valoracionBiopsicosocialBean.setHvbnpesrecnac}">
                <a4j:support id="supportPesoRecienNacido" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText value="Gramos"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputPesoRecienNacido" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuMortalidad" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcmorfetneo}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcmorfetneo}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportMortalidad" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuMortalidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Trabajo de parto anormal o dificultoso" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Cirugia ginecológica previa" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup></h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuTrabajoParto" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcparanodifi}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcparanodifi}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportTrabajoParto" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTrabajoParto" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuCirugiaGineco" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbccirginpre}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbccirginpre}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportCirugiaGineco" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuCirugiaGineco" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup></h:panelGroup>
          <h:outputText/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Embarazo actual" id="fieldEmbarazoActual" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEmbarazoActual"
                     rowClasses="labelCuestionario3,labelCuestionario4">
          <h:panelGroup>
            <h:outputText value="Enfermedad renal crónica" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Diabetes gestacional" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Diabetes preconcepcional" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuEnfermedadRenalCronica" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcenfrencro}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcenfrencro}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportEnfermedadRenalCronica" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuEnfermedadRenalCronica" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuDiabetesGestacional" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcdiabgest}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcdiabgest}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportDiabetesGestacional" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuDiabetesGestacional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuDiabetesPreconcepcional" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcdiabprec}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcdiabprec}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportDiabetesPreconcepcional" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuDiabetesPreconcepcional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Hemorragia" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Isoinmunización" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Embarazo prolongado" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:inputText id="inputHemorragia" maxlength="2" style="width:30px" onkeydown="return blockEnter(event);"
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnhemorragia}"
                           valueChangeListener="#{valoracionBiopsicosocialBean.setHvbnhemorragia}" required="true">
                <a4j:support id="supportHemorragia" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText value=" Semanas"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputHemorragia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuIsoinmunizacion" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcisoinnmu}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcisoinnmu}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportIsoinmunizacion" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuIsoinmunizacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:inputText id="inputEmbarazoProlongado" maxlength="2" style="width:30px"
                           onkeydown="return blockEnter(event);"
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnembpro}"
                           valueChangeListener="#{valoracionBiopsicosocialBean.setHvbnembpro}" required="true">
                <a4j:support id="supportEmbarazoProlongado" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText value=" Semanas"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="inputEmbarazoProlongado" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Hipertensión arterial" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Polihidramnios" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Embarazo Multiple" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuHipertencionaArterial" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbchipearte}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbchipearte}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportHipertencionaArterial" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuHipertencionaArterial" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuPolihidramios" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcpolihidra}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcpolihidra}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportPolihidramios" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPolihidramios" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuEmbarazoMultiple" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcembmult}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcembmult}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportEmbarazoMultiple" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuEmbarazoMultiple" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Presentación de frente o transversa" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Anemia" styleClass="labelTextNoOblig"/>
          </h:panelGroup>
          <h:panelGroup id="datoAnemiaText">
            <h:outputText  value="Dato Anemia" styleClass="labelTextNoOblig" rendered="#{valoracionBiopsicosocialBean.renderAnemia}"/>
          </h:panelGroup>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuPresentaFrenTrans" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcprefretra}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcprefretra}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportPresentaFrenTrans" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuPresentaFrenTrans" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          
           <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuAnemia" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcanemia}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcanemia}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportAnemia" event="onchange"
                             action="#{valoracionBiopsicosocialBean.changeAnemia}"
                             reRender="anemiaDatoPanel,anemiaDato,datoAnemiaText,tableInfoUbicationSemanaPrenatal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAnemia" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          
          <a4j:region renderRegionOnly="false">
            <h:panelGroup id="anemiaDatoPanel">
              <h:inputText id="anemiaDato" maxlength="2" style="width:30px" onkeydown="return blockEnter(event);"
                            binding="#{valoracionBiopsicosocialBean.datosAnemia}"
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbnanemiadesc}"
                           valueChangeListener="#{valoracionBiopsicosocialBean.setHvbnanemiadesc}" required="true" rendered="#{valoracionBiopsicosocialBean.renderAnemia}">
                <a4j:support id="supportAnemiaDato" event="onchange" action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:outputText value=" G/L " rendered="#{valoracionBiopsicosocialBean.renderAnemia}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="anemiaDato" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Riesgo Psicosocial" id="fieldRiesgoPsicosocial" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRiesgoPsicosocial"
                     rowClasses="labelCuestionario3,labelCuestionario4">
          <h:panelGroup>
            <h:outputText value="Ansiedad Severa" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Soporte social familiar inadecuado " styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuAnsiedadSevera" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcansiseve}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcansiseve}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportAnsiedadSevera" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAnsiedadSevera" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuSopoSociFamiInad" immediate="true" required="true"
                                value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcsosofain}"
                                valueChangeListener="#{valoracionBiopsicosocialBean.setHvbcsosofain}">
                <f:selectItems value="#{valoracionBiopsicosocialBean.lstOpciones}"/>
                <a4j:support id="supportSopoSociFamiInad" event="onchange"
                             action="#{valoracionBiopsicosocialBean.calcularPuntos}"
                             reRender="tableInfoUbicationSemanaPrenatal,mensajePuntos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuSopoSociFamiInad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:outputText/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Observaciones " id="fieldSetObservacionesBiopsicosocial" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionObservacionesBiopsicosocial" styleClass="labelTextInfo">
          <h:inputTextarea id="textObservaciones" style="width:650px;height:70px"
                           value="#{valoracionBiopsicosocialBean.valoracionBiopsicosocial.hvbcobservacion}"
                           required="true">
            <f:validateLength maximum="4000"/>
          </h:inputTextarea>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textObservaciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarObstetricos"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{valoracionBiopsicosocialBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
    <h:panelGrid id="panelMensajesGinecoObstetricos2">
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>