<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridAntecedentesGinecoObstetricosTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentesObstetricos" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesObstetricos" label="Antecedentes Gineco-Obstetricos">
    
      <s:fieldset legend="Gineco-Obstetricos" id="fieldAntecedentesGinecoobstetricos" styleClass="fieldset">
        <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="7">
            <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true"
                             action="#{antecedentesGinecoObstetricosBean.changeTodosSi}" reRender="panelDatosAntecedentesGinecobstetricos"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true"
                             action="#{antecedentesGinecoObstetricosBean.changeTodosNo}" reRender="panelDatosAntecedentesGinecobstetricos"/>
            <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
            <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true"
                             action="#{antecedentesGinecoObstetricosBean.changeNinguno}" reRender=" panelDatosAntecedentesGinecobstetricos"/>
            <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
          </h:panelGrid>
        </a4j:region>
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosAntecedentesGinecobstetricos" rowClasses="labelCuestionario3,labelCuestionario4">
          <h:panelGroup>
            <h:outputText value="Leucorreas" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="ITS" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Citologia" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuLeucorreas" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocleucorreas}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuLeucorreas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuETS" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocets}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuETS" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuCitologia" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haoccitologia}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCitologia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Colposcopia" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Periodo Intergenésico" styleClass="labelTextNoOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Historia Infertilidad" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuColposcopia" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haoccolposcopi}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuColposcopia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:inputText id="itPeriodoIntergenesico" maxlength="2" style="width:30px"
                         onkeydown="return blockEnter(event);"
                         value="#{antecedentesGinecoObstetricosBean.antecedente.haonperiodoint}"/>
            <h:outputText value=" Meses"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itPeriodoIntergenesico" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuFertilidad" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haochistoriain}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuFertilidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="RPM" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="RCIU" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Tratamientos Recibidos" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextCualTratamiento">
            <h:outputText value="Cual" styleClass="labelTextOblig"
                          rendered="#{antecedentesGinecoObstetricosBean.mostrarTratamiento}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuRPM" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocruppremenb}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuRPM" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuRCIU" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocrciu}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuRCIU" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuTratamientos" immediate="true" required="true"
                                value="#{antecedentesGinecoObstetricosBean.tieneTratamiento}"
                                valueChangeListener="#{antecedentesGinecoObstetricosBean.setTieneTratamiento}">
                <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
                <a4j:support id="supportTratamientos" event="onclick" immediate="true"
                             action="#{antecedentesGinecoObstetricosBean.changeTratamiento}"
                             reRender="panelTextCualTratamiento,panelInputCualTratamiento">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTratamientos" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputCualTratamiento">
            <h:inputTextarea id="itCualTratamiento" required="true"
                             value="#{antecedentesGinecoObstetricosBean.antecedente.haoccualesttos}"
                             style="width:200px;height:25px"
                             rendered="#{antecedentesGinecoObstetricosBean.mostrarTratamiento}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCualTratamiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Amenaza de Parto" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Parto Prematuro" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Gemelar" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup>
            <h:selectOneRadio id="mnuAmenaza" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocamenzparto}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAmenaza" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuPrematuro" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocpartoprema}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuPrematuro" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuGemelar" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocgemelar}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuGemelar" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup>
            <h:outputText value="Polhidramnios" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Oligohidramnios" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Malformaciones" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextCualMalformacion">
            <h:outputText value="Cuales" styleClass="labelTextOblig"
                          rendered="#{antecedentesGinecoObstetricosBean.mostrarMalformacion}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuPolhidramnios" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocpolhidramn}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuPolhidramnios" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuOligohidramnios" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocoligohidra}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOligohidramnios" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuMalformaciones" immediate="true" required="true"
                                value="#{antecedentesGinecoObstetricosBean.tieneMalformacion}"
                                valueChangeListener="#{antecedentesGinecoObstetricosBean.setTieneMalformacion}">
                <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
                <a4j:support id="supportMalformaciones" event="onclick" immediate="true"
                             action="#{antecedentesGinecoObstetricosBean.changeMalformacion}"
                             reRender="panelTextCualMalformacion,panelInputCualMalformacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuMalformaciones" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputCualMalformacion">
            <h:inputText id="itCualMalformacion" required="true"
                         value="#{antecedentesGinecoObstetricosBean.antecedente.haocmalforcual}"
                         onkeydown="return blockEnter(event);"
                         rendered="#{antecedentesGinecoObstetricosBean.mostrarMalformacion}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itCualMalformacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Embarazo Prolongado" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Amenaza de aborto" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Otros" styleClass="labelTextOblig"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextOtrosObste">
            <h:outputText value="Cuales"  styleClass="labelTextOblig"
                    rendered="#{antecedentesGinecoObstetricosBean.mostrarObstetricos}"/>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuProlongado" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocembarprolo}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuProlongado" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:selectOneRadio id="mnuAmenazaAborto" immediate="true" required="true"
                              value="#{antecedentesGinecoObstetricosBean.antecedente.haocamenaabort}">
              <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuAmenazaAborto" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuOtros" immediate="true" required="true"
                                value="#{antecedentesGinecoObstetricosBean.otrosObste}"
                                valueChangeListener="#{antecedentesGinecoObstetricosBean.setOtrosObste}">
                <f:selectItems value="#{antecedentesGinecoObstetricosBean.lstOpciones}"/>
                <a4j:support id="supportOtrosObstetricos" event="onclick" immediate="true"
                             action="#{antecedentesGinecoObstetricosBean.changeOtrosObstetricos}"
                             reRender="panelTextOtrosObste,panelInputOtrosObste">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuOtros" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputOtrosObste">
            <h:inputText id="itOtrosObstetricos"  required="true"
                        value="#{antecedentesGinecoObstetricosBean.antecedente.haocotrosobste}"
                         onkeydown="return blockEnter(event);"
                         rendered="#{antecedentesGinecoObstetricosBean.mostrarObstetricos}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itOtrosObstetricos" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarObstetricos"
                 columnClasses="panelGridBotones">
      <h:panelGroup>
        <h:commandButton value="Guardar" styleClass="boton_fieldset"
                         action="#{antecedentesGinecoObstetricosBean.aceptar}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
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
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>