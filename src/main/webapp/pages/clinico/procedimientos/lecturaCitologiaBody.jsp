<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:keepAlive beanName="lecturaCitologiaBean"/>
<a4j:form id="formLecturaCitologia">
  <a4j:region id="regionLecturaCitologia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionLecturaCitologia">
      <f:facet name="start">
        <t:div id="chargingLecturaCitologia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
  
   
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridLecturaCitologiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPanelLecturaCitologia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabLecturaCitologia" label="Lectura Citologia">
          <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
           <h:outputText value="Tipo de Historia:" />
           <h:outputText value="#{lecturaCitologiaBean.tipoLecturaCitologia}" />
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridLecturaCitologia1" styleClass="tabContainer">
            <s:fieldset legend="Lectura Citologia" id="fieldLectura" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosLecturaCitologia" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Primera Lectura por" styleClass="labelTextOblig"/>
                <h:outputText value="Nombre" styleClass="labelTextOblig"/>
                <h:outputText value="Fecha" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuCitologiaLeida" required="true" immediate="true"
                                   value="#{lecturaCitologiaBean.lectura.clccprilec}">
                    <f:selectItems value="#{lecturaCitologiaBean.lstPrimeraLectura}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuCitologiaLeida" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNombreLectura1" required="true" maxlength="30" immediate="true"
                               value="#{lecturaCitologiaBean.lectura.clccnompri}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreLectura1" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarPrimeraLectura" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{lecturaCitologiaBean.lectura.clcdprilec}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" immediate="true" required="true"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarPrimeraLectura" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Segunda Lectura por"/>
                <h:outputText value="Nombre"/>
                <h:outputText value="Fecha"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuSegundaLectura" required="false" immediate="true"
                                   value="#{lecturaCitologiaBean.lectura.clccseglec}">
                    <f:selectItems value="#{lecturaCitologiaBean.lstSegundaLectura}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuSegundaLectura" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itNombreLectura2" required="false" maxlength="30" immediate="true"
                               value="#{lecturaCitologiaBean.lectura.clccnomseg}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreLectura2" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarSegundaLectura" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{lecturaCitologiaBean.lectura.clcdseglec}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" immediate="true" required="false"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarSegundaLectura" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelLecturaCitologia" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Calidad de la Muestra" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneMenu id="menuCalidadMuestra" required="true" immediate="true"
                                   style="width:600px"
                                   value="#{lecturaCitologiaBean.lectura.clcccalmue}"
                                   valueChangeListener="#{lecturaCitologiaBean.setClcccalmue}">
                    <f:selectItems value="#{lecturaCitologiaBean.lstMuestra}"/>
                    <a4j:support id="supportmenuCalidadMuestra" event="onchange" immediate="true"
                                   action="#{lecturaCitologiaBean.changeCalidad}"
                                   reRender="panelTextMicroorganismos,outputTextCualesMicro,panelMenuMicroOrganismos,inputTextCualesMicro,panelLecturaCitologia2">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                  </h:selectOneMenu>
                </a4j:region>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuCalidadMuestra" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                
                <h:panelGroup id = "panelTextMicroorganismos">
                <h:outputText value="MicroOrganismos" styleClass="labelTextOblig" rendered="#{lecturaCitologiaBean.renderLectura}"/>
                </h:panelGroup>
                <h:panelGroup id="outputTextCualesMicro">
                  <h:outputText value="Cual" styleClass="labelTextOblig"
                                rendered="#{lecturaCitologiaBean.mostrarMicroOrganismos && lecturaCitologiaBean.renderLectura}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelMenuMicroOrganismos">
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneMenu id="menuMicroOrganismos" required="true" immediate="true"
                                     value="#{lecturaCitologiaBean.lectura.clccmicorg}"
                                      rendered="#{lecturaCitologiaBean.renderLectura}"
                                      style="width:600px"
                                     valueChangeListener="#{lecturaCitologiaBean.setClccmicorg}">
                      <f:selectItems value="#{lecturaCitologiaBean.lstMicroorganismos}"/>
                      <a4j:support id="supportmenuMicroOrganismos" event="onchange" immediate="true"
                                   action="#{lecturaCitologiaBean.changeMicroorganismos}"
                                   reRender="inputTextCualesMicro,outputTextCualesMicro">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true"  rendered="#{lecturaCitologiaBean.renderLectura}">
                      <t:message for="menuMicroOrganismos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                </h:panelGroup>
                <h:panelGroup id="inputTextCualesMicro">
                  <h:inputText id="itCualMicroOrganismo" maxlength="20" immediate="true" required="true"
                               value="#{lecturaCitologiaBean.lectura.clccotrmic}"
                               rendered="#{lecturaCitologiaBean.mostrarMicroOrganismos && lecturaCitologiaBean.renderLectura}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputTextCualesMicro" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelLecturaCitologia2" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Categorización" styleClass="labelTextOblig" rendered="#{lecturaCitologiaBean.renderLectura}"/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneMenu id="menuCategorizacion" required="true" immediate="true"
                                     value="#{lecturaCitologiaBean.lectura.clcccatego}"
                                      rendered="#{lecturaCitologiaBean.renderLectura}"
                                      style="width:600px"
                                     valueChangeListener="#{lecturaCitologiaBean.setClcccatego}">
                      <f:selectItems value="#{lecturaCitologiaBean.lstCategorizacion}"/>
                      <a4j:support id="supportmenuCategorizacion" event="onchange" immediate="true"
                                   action="#{lecturaCitologiaBean.changeCategorizacion}"
                                   reRender="outputTextAnomalidadesEscamosas,panelGroupAnomalidadesEscamosas,outputTextAnomalidadesGlandulares,panelGroupAnomalidadesGlandulares">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true"  rendered="#{lecturaCitologiaBean.renderLectura}">
                      <t:message for="menuCategorizacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="outputTextAnomalidadesEscamosas">
                  <h:outputText value="Anormalidades Células Escamosas" styleClass="labelTextOblig"
                           rendered="#{lecturaCitologiaBean.mostrarEpiteliales && lecturaCitologiaBean.renderLectura}"/>
                </h:panelGroup>
                <h:panelGroup id="panelGroupAnomalidadesEscamosas">
                  <h:selectOneMenu id="menuAnormalidadesEscamosas" required="true" immediate="true"
                                   rendered="#{lecturaCitologiaBean.mostrarEpiteliales  && lecturaCitologiaBean.renderLectura}"
                                    style="width:600px"
                                   value="#{lecturaCitologiaBean.lectura.clccanoesc}">
                    <f:selectItems value="#{lecturaCitologiaBean.lstAnomalidadesEscamosas}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{lecturaCitologiaBean.mostrarEpiteliales  && lecturaCitologiaBean.renderLectura}">
                    <t:message for="menuAnormalidadesEscamosas" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="outputTextAnomalidadesGlandulares">
                  <h:outputText value="Anormalidades en células glandulas" styleClass="labelTextOblig"
                                rendered="#{lecturaCitologiaBean.mostrarEpiteliales  && lecturaCitologiaBean.renderLectura}"/>
                </h:panelGroup>
                <h:panelGroup id="panelGroupAnomalidadesGlandulares">
                  <h:selectOneMenu id="menuAnormalidadesGlandulas" required="true" immediate="true"
                                   rendered="#{lecturaCitologiaBean.mostrarEpiteliales  && lecturaCitologiaBean.renderLectura}"
                                    style="width:600px"
                                   value="#{lecturaCitologiaBean.lectura.clccanogla}">
                    <f:selectItems value="#{lecturaCitologiaBean.lstAnomalidadesGlandulares}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{lecturaCitologiaBean.mostrarEpiteliales  && lecturaCitologiaBean.renderLectura}">
                    <t:message for="menuAnormalidadesGlandulas" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Otros Hallazgos no Neoplásicos" styleClass="labelTextOblig" rendered="#{lecturaCitologiaBean.renderLectura}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="menuHallazgos" required="true" immediate="true"
                                    style="width:600px" rendered="#{lecturaCitologiaBean.renderLectura}"
                                   value="#{lecturaCitologiaBean.lectura.clccotrhal}">
                    <f:selectItems value="#{lecturaCitologiaBean.lstHallazgos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{lecturaCitologiaBean.renderLectura}">
                    <t:message for="menuHallazgos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="Otras neoplasias malignas" rendered="#{lecturaCitologiaBean.renderLectura}"/>
                <h:panelGroup>
                  <h:inputTextarea id = "itotrosneolpa" rendered="#{lecturaCitologiaBean.renderLectura}"
                       value="#{lecturaCitologiaBean.lectura.clccotrneo}" style="width:600px">
                       <f:validateLength maximum="40"/>
                    </h:inputTextarea>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{lecturaCitologiaBean.renderLectura}">
                    <t:message for="itotrosneolpa" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
               
              </h:panelGrid>
               <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelObservacionesLectura" rowClasses="labelText,labelTextInfo">
                            <h:outputText value="Observaciones" />
                            <h:outputText value = ""/>
                            
                <h:panelGroup>
                  <h:inputTextarea id = "itObservaciones"  style="width:600px" 
                    value="#{lecturaCitologiaBean.lectura.clccobserv}">
                       <f:validateLength maximum="80"/>
                    </h:inputTextarea>
                </h:panelGroup>
                
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itObservaciones" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                            
                            
                </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAceptarLectura"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <h:commandButton value="Guardar" styleClass="boton_fieldset"
                               onclick="if (!confirm(\'¿Realmente desea guardar la lectura de la citologia\')) return false"
                               action="#{lecturaCitologiaBean.aceptar}">
                <a4j:support event="onclick" status="statusButton"/>
              </h:commandButton>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMsgLecturaCito" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgLecturaCito" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>