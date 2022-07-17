<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMotivoConsultaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneMotivoConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabMotivoConsulta" label="Motivo Consulta">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsMotivoConsulta" styleClass="tabContainer">
        <s:fieldset legend="Remisión " id="fieldContactoProfamilia" styleClass="fieldset" rendered="#{motivoBean.renderConocioProfamilia}">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosContactoProfamilia" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Ingresa a Profamilia por:" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup id="panelOutputContacto">
              <h:outputText value="Cual? " styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:panelGroup id="panelRemision">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuTipoContacto" immediate="true" required="true" value="#{motivoBean.motivo.hmcctipoconta}" onkeydown="return blockEnter(event);"
                                  valueChangeListener="#{motivoBean.setHmcctipoconta}">
                  <f:selectItems value="#{motivoBean.lstTipoContacto}"/>
                  <a4j:support id="supportTipoContacto" event="onclick" action="#{motivoBean.changeContacto}" reRender="panelOutputContacto,panelInputContacto">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTipoContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelInputContacto">
              <h:selectOneMenu id="mnuCualContacto" required="true" onkeydown="return blockEnter(event);" value="#{motivoBean.motivo.hmcccualconta}">
                <f:selectItems value="#{motivoBean.lstContacto}"/>
              </h:selectOneMenu>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCualContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Motivo de la Consulta " id="fieldMotivo1" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMotivoConsulta" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Causa Externa" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:outputText value="Motivo de Consulta" styleClass="labelTextOblig" rendered="#{!motivoBean.esValoracionPreanestesica}"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuMotivoConsulta" required="true" onkeydown="return blockEnter(event);" value="#{motivoBean.causaSelect}">
              <f:selectItems value="#{motivoBean.lstCausa}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
              <h:panelGroup>
                <h:inputTextarea id="textMotivoConsulta" required="#{!motivoBean.motivoOpcional}" value="#{motivoBean.motivo.hmctdescripcio}" style="width:300px"
                                 rendered="#{!motivoBean.esValoracionPreanestesica}"/>
              </h:panelGroup>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMotivoConsulta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Finalidad" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:outputText value="Enfermedad Actual" styleClass="labelTextOblig" rendered="#{!motivoBean.enfermedadOpcional && !motivoBean.esValoracionPreanestesica}"/>
              <h:outputText value="Enfermedad Actual" rendered="#{motivoBean.enfermedadOpcional && !motivoBean.esValoracionPreanestesica}"/>
            </h:panelGroup>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuFinalidad" onkeydown="return blockEnter(event);" required="true" value="#{motivoBean.finalidadSelect}">
              <f:selectItem itemLabel="No aplica" itemValue="10"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuFinalidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup>
              <h:panelGroup>
                <h:inputTextarea id="textEnfermedaActual" required="#{!motivoBean.enfermedadOpcional}" value="#{motivoBean.motivo.hmctenferactal}" style="width:500px"
                                 rendered="#{!motivoBean.esValoracionPreanestesica}"/>
              </h:panelGroup>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textEnfermedaActual" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
        <!-- ***** -->
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionMensajesasesoriailve" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInfasesoriailve" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <!-- ***** -->
        <!-- ***** -->
        <s:fieldset legend="Revisión por Sistemas " id="fieldRevisionPorSistemas" styleClass="fieldset" rendered="#{!motivoBean.esValoracionPreanestesica && !motivoBean.ocultarRevision}">
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="7">
              <h:outputText value="[ " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value=" Todos SI" immediate="true" action="#{motivoBean.changeTodosSi}" reRender="panelRevisionPorSistemas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Todos NO " immediate="true" action="#{motivoBean.changeTodosNo}" reRender="panelRevisionPorSistemas"/>
              <h:outputText value=" | " style="font-size:8.0pt; font-weight:bold;"/>
              <a4j:commandLink style="font-size:8.0pt; font-weight:bold;" value="Ninguno " immediate="true" action="#{motivoBean.changeNinguno}" reRender="panelRevisionPorSistemas"/>
              <h:outputText value=" ]" style="font-size:8.0pt; font-weight:bold;"/>
            </h:panelGrid>
          </a4j:region>
          <t:htmlTag value="br"/>
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRevisionPorSistemas" rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico">
            <h:outputText value="Cabeza" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCabeza" required="true" immediate="true" binding="#{motivoBean.mnuCabeza}" valueChangeListener="#{motivoBean.setHrserefiecabez}"
                                value="#{motivoBean.revision.hrserefiecabez}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuCabeza" action="#{motivoBean.changeCabeza}" reRender="panelTextCabeza,panelInputCabeza" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCabeza" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextCabeza">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderCabeza}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCabeza">
              <h:inputTextarea id="textCabeza" required="true" rendered="#{motivoBean.renderCabeza}" value="#{motivoBean.revision.hrscrefiecabez}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCabeza" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Ojos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuOjos" immediate="true" required="true" binding="#{motivoBean.mnuOjos}" value="#{motivoBean.revision.hrserefieojos}"
                                valueChangeListener="#{motivoBean.setHrserefieojos}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuOjos" action="#{motivoBean.changeOjos}" reRender="panelTextOjos,panelInputOjos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOjos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextOjos">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderOjos}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputOjos">
              <h:inputTextarea id="textOjos" required="true" rendered="#{motivoBean.renderOjos}" value="#{motivoBean.revision.hrscrefieojos}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textOjos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Oídos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuOidos" required="true" immediate="true" binding="#{motivoBean.mnuOidos}" value="#{motivoBean.revision.hrserefieoidos}"
                                valueChangeListener="#{motivoBean.setHrserefieoidos}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuOidos" action="#{motivoBean.changeOidos}" reRender="panelTextOidos,panelInputOidos" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuOidos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextOidos">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderOidos}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputOidos">
              <h:inputTextarea id="textOidos" required="true" rendered="#{motivoBean.renderOidos}" value="#{motivoBean.revision.hrscrefieoidos}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textOidos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Nariz" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuNariz" required="true" binding="#{motivoBean.mnuNariz}" immediate="true" value="#{motivoBean.revision.hrserefienariz}"
                                valueChangeListener="#{motivoBean.setHrserefienariz}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuNariz" action="#{motivoBean.changeNariz}" reRender="panelTextNariz,panelInputNariz" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuNariz" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextNariz">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderNariz}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputNariz">
              <h:inputTextarea id="textNariz" required="true" rendered="#{motivoBean.renderNariz}" value="#{motivoBean.revision.hrscrefienariz}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textNariz" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Boca" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuBoca" required="true" binding="#{motivoBean.mnuBoca}" immediate="true" value="#{motivoBean.revision.hrserefieboca}"
                                valueChangeListener="#{motivoBean.setHrserefieboca}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuBoca" action="#{motivoBean.changeBoca}" reRender="panelTextBoca,panelInputBoca" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuBoca" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextBoca">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderBoca}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputBoca">
              <h:inputTextarea id="textBoca" required="true" rendered="#{motivoBean.renderBoca}" value="#{motivoBean.revision.hrscrefieboca}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textBoca" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Garganta" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuGarganta" required="true" binding="#{motivoBean.mnuGarganta}" immediate="true" value="#{motivoBean.revision.hrserefiegarga}"
                                valueChangeListener="#{motivoBean.setHrserefiegarga}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuGarganta" action="#{motivoBean.changeGarganta}" reRender="panelTextGarganta,panelInputGarganta" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuGarganta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextGarganta">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderGarganta}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputGarganta">
              <h:inputTextarea id="textGarganta" required="true" rendered="#{motivoBean.renderGarganta}" value="#{motivoBean.revision.hrscrefiegarga}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textGarganta" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Cuello" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCuello" required="true" binding="#{motivoBean.mnuCuello}" immediate="true" value="#{motivoBean.revision.hrserefiecuell}"
                                valueChangeListener="#{motivoBean.setHrserefiecuell}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuCuello" action="#{motivoBean.changeCuello}" reRender="panelTextCuello,panelInputCuello" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCuello" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextCuello">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderCuello}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCuello">
              <h:inputTextarea id="textCuello" required="true" rendered="#{motivoBean.renderCuello}" value="#{motivoBean.revision.hrscrefiecuell}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCuello" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Cardiorrespiratorio" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuCardiorrespiratorio" required="true" binding="#{motivoBean.mnuCardiorrespiratorio}" immediate="true" value="#{motivoBean.revision.hrserefiecardi}"
                                valueChangeListener="#{motivoBean.setHrserefiecardi}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuCardiorrespiratorio" action="#{motivoBean.changeCardiorrespiratorio}" reRender="panelTextCardiorrespiratorio,panelInputCardiorrespiratorio" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuCardiorrespiratorio" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextCardiorrespiratorio">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderCardiorespiratorio}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputCardiorrespiratorio">
              <h:inputTextarea id="textCardiorrespiratorio" required="true" rendered="#{motivoBean.renderCardiorespiratorio}" value="#{motivoBean.revision.hrscrefiecardi}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCardiorrespiratorio" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Mamas" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuMamas" required="true" binding="#{motivoBean.mnuMamas}" immediate="true" value="#{motivoBean.revision.hrserefiemamas}"
                                valueChangeListener="#{motivoBean.setHrserefiemamas}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuMamas" action="#{motivoBean.changeMama}" reRender="panelTextMama,panelInputMama" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuMamas" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextMama">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderMama}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputMama">
              <h:inputTextarea id="textMamas" required="true" rendered="#{motivoBean.renderMama}" value="#{motivoBean.revision.hrscrefiemamas}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textMamas" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Gastrointestinal" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuGastrointestinal" required="true" binding="#{motivoBean.mnuGastrointestinal}" immediate="true" value="#{motivoBean.revision.hrserefiegastr}"
                                valueChangeListener="#{motivoBean.setHrserefiegastr}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuGastrointestinal" action="#{motivoBean.changeGastrointestinal}" reRender="panelTextGastrointestinal,panelInputGastrointestinal" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuGastrointestinal" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextGastrointestinal">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderGastrointestinal}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputGastrointestinal">
              <h:inputTextarea id="textGastrointestinal" required="true" rendered="#{motivoBean.renderGastrointestinal}" value="#{motivoBean.revision.hrscrefiegastr}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textGastrointestinal" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Genitourinario" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuGenitourinario" required="true" binding="#{motivoBean.mnuGenitourinario}" immediate="true" value="#{motivoBean.revision.hrserefiegenit}"
                                valueChangeListener="#{motivoBean.setHrserefiegenit}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuGenitourinario" action="#{motivoBean.changeGenitourinario}" reRender="panelTextGenitourinario,panelInputGenitourinario" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuGenitourinario" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextGenitourinario">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderGenitourinario}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputGenitourinario">
              <h:inputTextarea id="textGenitourinario" required="true" rendered="#{motivoBean.renderGenitourinario}" value="#{motivoBean.revision.hrscrefiegenit}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textGenitourinario" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Locomotor" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuLocomotor" required="true" binding="#{motivoBean.mnuLocomotor}" immediate="true" value="#{motivoBean.revision.hrserefielocom}"
                                valueChangeListener="#{motivoBean.setHrserefielocom}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuLocomotor" action="#{motivoBean.changeLocomotor}" reRender="panelTextLocomotor,panelInputLocomotor" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuLocomotor" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextLocomotor">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderLocomotor}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputLocomotor">
              <h:inputTextarea id="textLocomotor" required="true" rendered="#{motivoBean.renderLocomotor}" value="#{motivoBean.revision.hrscrefielocom}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textLocomotor" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Neuropsiquiátrico" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuNeuropsiqui" required="true" binding="#{motivoBean.mnuNeuropsiqui}" immediate="true" value="#{motivoBean.revision.hrserefieneups}"
                                valueChangeListener="#{motivoBean.setHrserefieneups}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuNeuropsiqui" action="#{motivoBean.changeNeuropsiqui}" reRender="panelTextNeuropsiqui,panelInputNeuropsiqui" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuNeuropsiqui" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextNeuropsiqui">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderNeuropsiqui}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputNeuropsiqui">
              <h:inputTextarea id="textNeuropsiqui" required="true" rendered="#{motivoBean.renderNeuropsiqui}" value="#{motivoBean.revision.hrscrefieneups}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textNeuropsiqui" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Neuromuscular" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuNeuromuscular" required="true" binding="#{motivoBean.mnuNeuromuscular}" immediate="true" value="#{motivoBean.revision.hrserefieneumu}"
                                valueChangeListener="#{motivoBean.setHrserefieneumu}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuNeuromuscular" action="#{motivoBean.changeNeuromuscular}" reRender="panelTextNeuromuscular,panelInputNeuromuscular" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuNeuromuscular" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextNeuromuscular">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderNeuromuscular}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputNeuromuscular">
              <h:inputTextarea id="textNeuromuscular" required="true" rendered="#{motivoBean.renderNeuromuscular}" value="#{motivoBean.revision.hrscrefieneumu}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textNeuromuscular" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Piel y anexos" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuPiel" required="true" binding="#{motivoBean.mnuPiel}" immediate="true" value="#{motivoBean.revision.hrserefiepiel}"
                                valueChangeListener="#{motivoBean.setHrserefiepiel}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuPiel" action="#{motivoBean.changePiel}" reRender="panelTextPiel,panelInputPiel" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuPiel" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextPiel">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderPiel}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputPiel">
              <h:inputTextarea id="textPiel" required="true" rendered="#{motivoBean.renderPiel}" value="#{motivoBean.revision.hrscrefiepiel}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textPiel" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Usuario es sintomático respiratorio (Tuberculosis)" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuTuberculosis" required="true" immediate="true" binding="#{motivoBean.mnuTuberculosis}" value="#{motivoBean.revision.hrserefietuber}"
                                valueChangeListener="#{motivoBean.setHrserefietuber}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuTuberculosis" action="#{motivoBean.changeTuberculosis}" reRender="panelTextTuberculosis,panelInputTuberculosis" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTuberculosis" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextTuberculosis">
              <h:outputText value="Tiempo" styleClass="labelTextOblig" rendered="#{motivoBean.renderTuberculosis}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputTuberculosis">
              <h:inputTextarea id="textTuberculosis" required="true" rendered="#{motivoBean.renderTuberculosis}" value="#{motivoBean.revision.hrscrefietuber}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textTuberculosis" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Usuario es sintomático de piel (Lepra) " styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuLepra" required="true" immediate="true" binding="#{motivoBean.mnuLepra}" value="#{motivoBean.revision.hrserefielepra}"
                                valueChangeListener="#{motivoBean.setHrserefielepra}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuLepra" action="#{motivoBean.changeLepra}" reRender="panelTextLepra,panelInputLepra" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuLepra" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelTextLepra">
              <h:outputText value="Tiempo" styleClass="labelTextOblig" rendered="#{motivoBean.renderLepra}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputLepra">
              <h:inputTextarea id="textLepra" required="true" rendered="#{motivoBean.renderLepra}" value="#{motivoBean.revision.hrscrefielepra}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textLepra" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>
          <s:fieldset legend="Condiciones específicas"  id="fieldCondicionesEspecificas" styleClass="fieldset" >
                        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCondiEspecificas" rowClasses="standardTable_ExamenFisico2,standardTable_ExamenFisico">
            <h:outputText value="Dismenorrea" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnudismeno" required="true" immediate="true" binding="#{motivoBean.mnuDismenorrea}" valueChangeListener="#{motivoBean.setHrserefiedismeno}"
                                value="#{motivoBean.revision.hrserefiedismeno}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuDismeno" action="#{motivoBean.changeDismenorrea}" reRender="panelDismeno,panelInputDismeno" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuDismeno" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelDismeno">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderDismenorrea}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputDismeno">
              <h:inputTextarea id="textDismenorrea" required="true" rendered="#{motivoBean.renderDismenorrea}" value="#{motivoBean.revision.hrscrefiedismeno}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textDismenorrea" styleClass="errorMessage"/>
            </a4j:outputPanel>
     
            <h:outputText value="Dispareunia" styleClass="labelTextOblig"/>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuDispar" required="true" immediate="true" binding="#{motivoBean.mnuDispareunia}" valueChangeListener="#{motivoBean.setHrserefiedispar}"
                                value="#{motivoBean.revision.hrserefiedispar}">
                <f:selectItems value="#{motivoBean.lstRefiere}"/>
                <a4j:support id="supportmnuDispar" action="#{motivoBean.changeDispareunia}" reRender="panelDispar,panelInputDispar" event="onclick">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuDispar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelDispar">
              <h:outputText value="Descripción" styleClass="labelTextOblig" rendered="#{motivoBean.renderDispareunia}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputDispar">
              <h:inputTextarea id="textDispareunia" required="true" rendered="#{motivoBean.renderDispareunia}" value="#{motivoBean.revision.hrscrefiedispar}" style="width:350px"/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textDispareunia" styleClass="errorMessage"/>
            </a4j:outputPanel>
             
            </h:panelGrid>
          </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        styleClass="alert alert-success" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{motivoBean.guardarMotivoConsulta}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>