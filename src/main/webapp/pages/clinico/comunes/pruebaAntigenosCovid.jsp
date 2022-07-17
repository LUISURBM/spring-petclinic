<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridPruebaCovidAntigenoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPanePruebaCovidAntigeno" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
     <h:panelGroup>
       <a4j:outputPanel id="ajaxRegionAntigenosMsg" ajaxRendered="true">
         <t:htmlTag value="br"/>
         <t:messages id="msgInformationAntigenosMsg" showSummary="false" errorClass="error" globalOnly="true"
                     layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
         <t:htmlTag value="br"/>
       </a4j:outputPanel>
     </h:panelGroup>
    <t:panelTab id="panelTabPruebaCovidAntigeno" label="Prueba de Detecci�n de Antigenos COVID-19">
      <s:fieldset legend="Datos Adicionales" id="fieldSetPruebaCovidAntigeno" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosPruebaCovidAntigeno" rowClasses="labelTextInfo,labelTextInfo">
            <h:outputText value="Trabajador de la salud " styleClass="labelTextOblig"/>
           <h:selectOneRadio id="menuTrabaSalud" required="true" immediate="true"
                            value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgctrabsalud}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAntigenosCovidBean.lstOpciones}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTrabaSalud" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
          
          <h:outputText value="�ha tenido contacto estrecho en los �ltimos 14 d�as?" styleClass="labelTextOblig"/>
           <h:selectOneRadio id="menuContacto" required="true" immediate="true"
                            value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgccontadias}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAntigenosCovidBean.lstOpciones}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
          
           <h:outputText value="�El paciente ha tenido s�ntomas?" styleClass="labelTextOblig"/>
            <h:selectOneRadio id="menusintomas" required="true" immediate="true" valueChangeListener="#{pruebasAntigenosCovidBean.setHpgcsintopaci}"
                            value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgcsintopaci}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{pruebasAntigenosCovidBean.lstOpciones}"/>
             <a4j:support id="suppoSintoPaci" event="onchange" immediate="true"
                               action="#{pruebasAntigenosCovidBean.changeSintomasPaciente}"
                               reRender="panelFechaSintomas,panelDiasSintomas">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menusintomas" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
           <h:panelGroup id="panelFechaSintomas">        
          <h:outputText value="Fecha de inicio de s�ntomas:" styleClass="labelTextOblig" rendered="#{pruebasAntigenosCovidBean.sintomas}"/>
           <a4j:region renderRegionOnly="false">
              <t:inputCalendar id="fechaSintomas" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true" 
                               value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgdfecsinto}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{pruebasAntigenosCovidBean.setFechaSintomas}" required="true" rendered="#{pruebasAntigenosCovidBean.sintomas}">
                    <a4j:support id="supportfechaSin" event="onchange" immediate="true"
                                 reRender="panelDiasSintomas"
                                 action="#{pruebasAntigenosCovidBean.changeFechaSintomas}">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </t:inputCalendar>
            </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="panelDiasSintomas">
          <h:outputText value="N�mero de d�as de inicio de sintomatologia " styleClass="labelTextOblig"  rendered="#{pruebasAntigenosCovidBean.sintomas}"/>
           <h:inputText value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgnnumesinto}" maxlength="2"  style="width:30%" required="true" readonly="true"  rendered="#{pruebasAntigenosCovidBean.sintomas}" />
           </h:panelGroup>
           </h:panelGrid>
           </s:fieldset>
        <s:fieldset legend="Condici�n de realizaci�n de la prueba" id="fieldSetCondicionCovidAntigeno" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelCondicionPruebaCovidAntigeno" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Lugar donde se toma la muestra" styleClass="labelTextOblig"/>
          <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="menulugar" value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgclugatoma}"
                             onkeydown="return blockEnter(event);" required="true"
                             valueChangeListener="#{pruebasAntigenosCovidBean.setLugarToma}" >
              <f:selectItems value="#{pruebasAntigenosCovidBean.lstLugarToma}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menulugar" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </a4j:region>
          
           <h:outputText value="Lugar donde se procesa la muestra" styleClass="labelTextOblig"/>
          <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="menuprocesalugar" value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgclugaproc}"
                             onkeydown="return blockEnter(event);" required="true"
                             valueChangeListener="#{pruebasAntigenosCovidBean.setLugarProc}" >
              <f:selectItems value="#{pruebasAntigenosCovidBean.lstLugarToma}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuprocesalugar" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </a4j:region>
          <h:outputText value="Temperatura ambiental durante el procesamiento" styleClass="labelTextOblig"/>
          <h:panelGroup>
            <h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="20%" id="panelTemperatura">
              <h:inputText  value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgntempambi}" maxlength="4"
                           style="width:40%" required="true" >
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="panelTemperatura" styleClass="errorMessage"/>
            </a4j:outputPanel>
             </h:inputText>
              <h:outputLabel value="c�"/>
            </h:panelGrid>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
        <s:fieldset legend="Datos de la prueba r�pida" id="fieldSetDatosPRCovidAntigeno" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelDatosPRPruebaCovidAntigeno" rowClasses="labelTextInfo,labelTextInfo">
          <h:outputText value="Marca" styleClass="labelTextOblig"/>
            <h:outputText value="STANDAR Q COVID 19 SD BIOSENSOR INC."/>
            
          <h:outputText value="Lote" styleClass="labelTextOblig"/>
            <h:inputText value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgclote}" required="true"/>
            
          <h:outputText value="Registro Invima" styleClass="labelTextOblig"/>
          <h:outputText value="INVIMA 2020RD-0006130"/>
          
          <h:outputText value="Fecha de fabricaci�n" styleClass="labelTextOblig"/>
           <a4j:region renderRegionOnly="false">
              <t:inputCalendar id="fechaFabricacion" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                               weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgdfechfabr}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{pruebasAntigenosCovidBean.setFechaFabricacion}" required="true">
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
                               value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgdfechvenci}" popupTodayString="Hoy" popupWeekString="Semana"
                               popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11"
                               immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top"
                               valueChangeListener="#{pruebasAntigenosCovidBean.setFechaVencimiento}" required="true">
                </t:inputCalendar>
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaVencimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </a4j:region>
            
          <h:outputText value="Resultado" styleClass="labelTextOblig"/>
          <a4j:region renderRegionOnly="false">
                    <h:selectOneMenu id="menuResultado" value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgcresultado}"
                                     onkeydown="return blockEnter(event);" required="true"
                                     valueChangeListener="#{pruebasAntigenosCovidBean.setResultado}">
                       <f:selectItems value="#{pruebasAntigenosCovidBean.lstResultado}"/>
                      <a4j:support id="supportResultado" event="onchange"
                           action="#{pruebasAntigenosCovidBean.changeResultado}">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                     </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="menuResultado" styleClass="errorMessage"/>
                    </a4j:outputPanel>
           </a4j:region>
         
          <h:outputText value="Observaciones" />
            <h:inputTextarea value="#{pruebasAntigenosCovidBean.covidAntigeno.hpgcobserv}"/>
            
          <h:outputText value="Nombre del profesional" styleClass="labelTextOblig"/>
           <h:outputText value="#{pruebasAntigenosCovidBean.nombreProfesional}" />
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonesAdministrarMedicamento" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset" 
                               action="#{pruebasAntigenosCovidBean.guardar}">
                <a4j:support event="onclick" status="statusButton"/> 
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
     <h:panelGroup>
       <a4j:outputPanel id="ajaxRegionAntigenos1Msg" ajaxRendered="true">
         <t:htmlTag value="br"/>
         <t:messages id="msgInformationAntigenos1Msg" showSummary="false" errorClass="error" globalOnly="true"
                     layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
         <t:htmlTag value="br"/>
       </a4j:outputPanel>
     </h:panelGroup>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
 <f:subview id="generarPapPsicologia" rendered="#{pruebasAntigenosCovidBean.pruebaRealizada}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
</h:panelGrid>