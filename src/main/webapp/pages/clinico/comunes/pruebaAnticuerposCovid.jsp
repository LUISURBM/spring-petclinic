<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridPruebaCovidAnticuerpoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPanePruebaCovidAnticuerpo" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <h:panelGroup>
       <a4j:outputPanel id="ajaxRegionAnticuerposMsg" ajaxRendered="true">
         <t:htmlTag value="br"/>
         <t:messages id="msgInformationAnticuerposMsg" showSummary="false" errorClass="error" globalOnly="true"
                     layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
         <t:htmlTag value="br"/>
       </a4j:outputPanel>
     </h:panelGroup>
    <t:panelTab id="panelTabPruebaCovidAnticuerpo" label="Prueba de Detección de Anticuerpos COVID-19">
      <s:fieldset legend="Datos Adicionales" id="fieldSetPruebaCovidAnticuerpo" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosPruebaCovidAnticuerpo" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Cerco epidemiológico" styleClass="labelTextOblig"/>
           <h:selectOneRadio id="menuRealizocerco" required="true" immediate="true"
                            value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpaccercepid}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAnticuerposCovidBean.lstOpciones}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuRealizocerco" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
          
          <h:outputText value="Trabajador de la salud " styleClass="labelTextOblig"/>
           <h:selectOneRadio id="menuTrabaSalud" required="true" immediate="true"
                            value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpactrabsalud}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAnticuerposCovidBean.lstOpciones}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTrabaSalud" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
          
          <h:outputText value="¿ha tenido contacto estrecho en los últimos 14 días?" styleClass="labelTextOblig"/>
           <h:selectOneRadio id="menuContacto" required="true" immediate="true"
                            value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpaccontadias}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAnticuerposCovidBean.lstOpciones}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
          
          <h:outputText value="¿El paciente ha tenido síntomas?" styleClass="labelTextOblig"/>
            <h:selectOneRadio id="menusintomas" required="true" immediate="true" valueChangeListener="#{pruebasAnticuerposCovidBean.setHpacsintopaci}"
                            value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpacsintopaci}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAnticuerposCovidBean.lstOpciones}"/>
             <a4j:support id="suppoSintoPaci" event="onchange" immediate="true"
                               action="#{pruebasAnticuerposCovidBean.changeSintomasPaciente}"
                               reRender="panelFechaSintomas,panelDiasSintomas">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menusintomas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
          <h:panelGroup id="panelFechaSintomas">
          <h:outputText value="Fecha de inicio de síntomas:" styleClass="labelTextOblig"  rendered="#{pruebasAnticuerposCovidBean.sintomas}"/>
           <a4j:region renderRegionOnly="false">
              <t:inputCalendar id="fechaSintomas" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"  rendered="#{pruebasAnticuerposCovidBean.sintomas}"
                               value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpadfecsinto}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{pruebasAnticuerposCovidBean.setFechaSintomas}" required="true">
                       <a4j:support id="supportfechaSin" event="onchange" immediate="true"
                                 reRender="panelDiasSintomas"
                                 action="#{pruebasAnticuerposCovidBean.changeFechaSintomas}">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </t:inputCalendar>
            </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="panelDiasSintomas">
          <h:outputText value="Número de días de evolución de los síntomas " styleClass="labelTextOblig"  rendered="#{pruebasAnticuerposCovidBean.sintomas}"/>
           <h:inputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpannumesintevol}" readonly="true" maxlength="2"  style="width:30%" required="true"  rendered="#{pruebasAnticuerposCovidBean.sintomas}" />
           </h:panelGroup>
           </h:panelGrid>
           </s:fieldset>
        <s:fieldset legend="Condición de realización de la prueba" id="fieldSetCondicionCovidAnticuerpo" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelCondicionPruebaCovidAnticuerpo" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Lugar donde se toma la muestra" styleClass="labelTextOblig"/>
          <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="menulugar" value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpaclugatoma}"
                             onkeydown="return blockEnter(event);" required="true"
                             valueChangeListener="#{pruebasAnticuerposCovidBean.setLugarToma}" >
              <f:selectItems value="#{pruebasAnticuerposCovidBean.lstLugarToma}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menulugar" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </a4j:region>
          <h:outputText value="Temperatura ambiental" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="20%" id="panelTemperatura">
              <h:inputText  value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpantempambi}" maxlength="4"
                           style="width:40%" required="true" >
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="panelTemperatura" styleClass="errorMessage"/>
            </a4j:outputPanel>
             </h:inputText>
              <h:outputLabel value="c°"/>
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
        <s:fieldset legend="Datos de la prueba rápida" id="fieldSetDatosPRCovidAnticuerpo" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosPRPruebaCovidAnticuerpo" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Marca" styleClass="labelTextOblig"/>
            <h:outputText value="ONSITE RAPID TEST CTK BIOTECH"/>
            
          <h:outputText value="Lote" styleClass="labelTextOblig"/>
            <h:inputText value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpaclote}" required="true"/>
            
          <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
          <h:outputText value="INVIMA 2020RD-0006148"/>
          
          <h:outputText value="Fecha de fabricación" styleClass="labelTextOblig"/>
           <a4j:region renderRegionOnly="false">
              <t:inputCalendar id="fechaFabricacion" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpadfechfabr}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{pruebasAnticuerposCovidBean.setFechaFabricacion}" required="true">
                </t:inputCalendar>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFabricacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </a4j:region>
            
          <h:outputText value="Fecha de vencimiento" styleClass="labelTextOblig"/>
           <a4j:region renderRegionOnly="false">
              <t:inputCalendar id="fechaVencimiento" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true" 
                               value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpadfechvenci}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{pruebasAnticuerposCovidBean.setFechaVencimiento}" required="true">
                </t:inputCalendar>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaVencimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </a4j:region>
            
          <h:outputText value="Resultado" styleClass="labelTextOblig"/>
          <a4j:region renderRegionOnly="false">
                    <h:selectOneMenu id="menuResultado" value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpacresultado}"
                                     onkeydown="return blockEnter(event);" required="true"
                                     valueChangeListener="#{pruebasAnticuerposCovidBean.setResultado}">
                       <f:selectItems value="#{pruebasAnticuerposCovidBean.lstResultado}"/>
                      <a4j:support id="supportResultado" event="onchange"
                           action="#{pruebasAnticuerposCovidBean.changeResultado}"
                           reRender="groupTipoAntText,groupTipoAntSelect" >
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                     </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="menuResultado" styleClass="errorMessage"/>
                    </a4j:outputPanel>
           </a4j:region>
          <h:panelGroup id="groupTipoAntText">
          <h:outputText  value="Tipo de Antígeno " styleClass="labelTextOblig"  rendered="#{pruebasAnticuerposCovidBean.renderResultado}"/>
          </h:panelGroup>
           <h:panelGroup id="groupTipoAntSelect" >
          <a4j:region renderRegionOnly="false">
                    <h:selectOneMenu id="menuAntigeno" value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpactipoantig}"  rendered="#{pruebasAnticuerposCovidBean.renderResultado}"
                                     onkeydown="return blockEnter(event);"  required="true"
                                     valueChangeListener="#{pruebasAnticuerposCovidBean.setAntigeno}">
                      <f:selectItems value="#{pruebasAnticuerposCovidBean.lstAntigeno}"/>
                     
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="menuAntigeno" styleClass="errorMessage"/>
                    </a4j:outputPanel>
           </a4j:region>
          </h:panelGroup>
          <h:outputText value="Observaciones"/>
            <h:inputTextarea value="#{pruebasAnticuerposCovidBean.covidAnticuerpo.hpacobserv}"/>
            
          <h:outputText value="Nombre del profesional" styleClass="labelTextOblig"/>
           <h:outputText value="#{pruebasAnticuerposCovidBean.nombreProfesional}" />
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAdministrarMedicamento" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset" 
                               action="#{pruebasAnticuerposCovidBean.guardar}">
                <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
     <h:panelGroup>
       <a4j:outputPanel id="ajaxRegionAnicuerpos1Msg" ajaxRendered="true">
         <t:htmlTag value="br"/>
         <t:messages id="msgInformationAnticuerpos1Msg" showSummary="false" errorClass="error" globalOnly="true"
                     layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
         <t:htmlTag value="br"/>
       </a4j:outputPanel>
     </h:panelGroup>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>