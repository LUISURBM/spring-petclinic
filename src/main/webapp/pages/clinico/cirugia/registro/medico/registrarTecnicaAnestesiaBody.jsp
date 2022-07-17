<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<a4j:form id="formTecnicaAnestesia">
  <a4j:region id="regionTecnicaAnestesia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionTecnicaAnestesia">
      <f:facet name="start">
        <t:div id="chargingTecnicaAnestesia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
   
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridTecnicaAnestesiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneTecnicaAnestesia"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabTecnicaAnestesia" label="Técnica Anestesia">
          <s:fieldset legend="Técnica Anestesia" id="fieldTecnicaAnestesia"
                      styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelTecnicaAnestesia"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="General"/>
              <h:outputText value="Regional"/>
              <h:outputText value=""/>
              <h:outputText value="Local controlada"/>
              <a4j:region renderRegionOnly="false">
                <h:selectBooleanCheckbox id="checkAnestesiaGeneral"
                                         value="#{registrarTecnicaAnestesiaBean.esAnestesiaGeneral}"
                                         valueChangeListener="#{registrarTecnicaAnestesiaBean.setEsAnestesiaGeneral}"
                                         immediate="true">
                  <a4j:support id="support2" event="onclick" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeAnestesiaGeneral}"
                               reRender="panelOutputAnestesiaGeneral,panelInputAnestesiaGeneral">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <h:selectBooleanCheckbox id="checkAnestesiaRegional"
                                         value="#{registrarTecnicaAnestesiaBean.esAnestesiaRegional}"
                                         valueChangeListener="#{registrarTecnicaAnestesiaBean.setEsAnestesiaRegional}"
                                         immediate="true">
                  <a4j:support id="support3" event="onclick" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeAnestesiaRegional}"
                               reRender="panelOutputAnestesiaRegional,panelInputAnestesiaRegional,panelDescripcionProcedimientoAnestesia,panelTextTipoNeuroaxial,panelMnuTipoNeuroaxial">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
              </a4j:region>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:selectBooleanCheckbox id="checkAnestesiaLocal"
                                         value="#{registrarTecnicaAnestesiaBean.esAnestesiaLocal}"
                                         valueChangeListener="#{registrarTecnicaAnestesiaBean.setEsAnestesiaLocal}"
                                         immediate="true">
                  <a4j:support id="support4" event="onclick" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeAnestesiaLocal}"
                               reRender="panelDescripcionProcedimientoAnestesia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
              </a4j:region>
              <h:panelGroup id="panelOutputAnestesiaGeneral">
                <h:outputText value="¿Forma Administración? "
                              styleClass="labelTextOblig"
                              rendered="#{registrarTecnicaAnestesiaBean.esAnestesiaGeneral}"/>
              </h:panelGroup>
              <h:panelGroup id="panelOutputAnestesiaRegional">
                <h:outputText value="¿Forma Administracion?"
                              styleClass="labelTextOblig"
                              rendered="#{registrarTecnicaAnestesiaBean.esAnestesiaRegional}"/>
              </h:panelGroup>
              <h:panelGroup id = "panelTextTipoNeuroaxial" >
              <h:outputText value="Tipo Neuroaxial" rendered="#{registrarTecnicaAnestesiaBean.mostrarNeuroaxial && registrarTecnicaAnestesiaBean.esAnestesiaRegional}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:panelGroup id="panelInputAnestesiaGeneral">
                <h:selectOneMenu id="mnuFormaAdministracionGeneral"
                                 required="#{registrarTecnicaAnestesiaBean.esAnestesiaGeneral}"
                                 onkeydown="return blockEnter(event);"
                                 value="#{registrarTecnicaAnestesiaBean.tecnica.htactipoanegen}"
                                 rendered="#{registrarTecnicaAnestesiaBean.esAnestesiaGeneral}">
                  <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstFormulaGeneral}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuFormaAdministracionGeneral"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelInputAnestesiaRegional">
                <h:selectOneMenu id="mnuFormaAdministracionRegional" immediate="true"
                                 required="#{registrarTecnicaAnestesiaBean.esAnestesiaRegional}"
                                 onkeydown="return blockEnter(event);"
                                 binding="#{registrarTecnicaAnestesiaBean.mnuFormaAdministracionRegional}"
                                 value="#{registrarTecnicaAnestesiaBean.tecnica.htactipoanereg}"
                                 valueChangeListener="#{registrarTecnicaAnestesiaBean.setHtactipoanereg}"
                                 rendered="#{registrarTecnicaAnestesiaBean.esAnestesiaRegional}">
                  <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstFormulaRegional}"/>
                   <a4j:support id="support1" event="onchange" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeFormaAdministracionRegional}"
                               reRender="panelTextTipoNeuroaxial,panelMnuTipoNeuroaxial">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuFormaAdministracionRegional"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id = "panelMnuTipoNeuroaxial">
             <h:selectOneRadio id = "mnuTipoNeuroaxial" rendered="#{registrarTecnicaAnestesiaBean.mostrarNeuroaxial && registrarTecnicaAnestesiaBean.esAnestesiaRegional}"
                value = "#{registrarTecnicaAnestesiaBean.tecnica.htactiponeuroa}">
             <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstTipoNeuroaxial}"/>
             </h:selectOneRadio>
              </h:panelGroup>
              <h:outputText value=""/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%"
                         id="panelDescripcionProcedimientoAnestesia"
                         rowClasses="labelText,labelTextInfo">
              <h:panelGroup>
                <h:outputText value="Descripción del procedimiento anestésico"  styleClass="labelTextOblig"
                              rendered="#{registrarTecnicaAnestesiaBean.esAnestesiaRegional || registrarTecnicaAnestesiaBean.esAnestesiaLocal}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputTextarea id="itDescripcionAnestesia" required="true"
                                 style="width:600px"
                                 rendered="#{registrarTecnicaAnestesiaBean.esAnestesiaRegional || registrarTecnicaAnestesiaBean.esAnestesiaLocal}"
                                 value="#{registrarTecnicaAnestesiaBean.tecnica.htacdescrproce}"/>
                                     <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDescripcionAnestesia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
          
          
             <s:fieldset legend="Agentes Inhalados" id="fieldAgentesInhalados"
                      styleClass="fieldset">
            <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelGridAgentesInhalados"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Oxigeno O2 (ltsX')"/>
              <h:panelGroup id="panelTextFechaInicio">
              <h:outputText value="Fecha Inicio" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextHoraInicio">
              <h:outputText value="Hora Inicio" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextFechaFin">
              <h:outputText value="Fecha Fin" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextHoraFin">
              <h:outputText value="Hora Fin" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"/>
              </h:panelGroup>
             <a4j:region renderRegionOnly="false">
             <h:panelGroup>
              <h:selectOneMenu id="itOxigeno"   immediate="true"
                    value="#{registrarTecnicaAnestesiaBean.tecnica.htanoxigeno}"
                    valueChangeListener="#{registrarTecnicaAnestesiaBean.setHtanoxigeno}">
                    <f:selectItems value = "#{registrarTecnicaAnestesiaBean.ltsOxigeno}" />
                         <a4j:support id="supportOxigeno" event="onchange" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeOxigeno}"
                               reRender="panelTextFechaInicio,panelTextHoraInicio,panelTextFechaFin,panelTextHoraFin,panelFechaInicioOxigeno,panelHoraInicioOxigeno,panelFechaFinOxigeno,panelHorafinOxigeno">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>     
                           
                    </h:selectOneMenu>
                           
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                  <t:message for="itOxigeno" styleClass="errorMessage"/>
                </a4j:outputPanel>
                           
            </h:panelGroup>
            </a4j:region>
              <h:panelGroup id="panelFechaInicioOxigeno">
                <t:inputCalendar id="fechaInicioOxigeno" 
                                 onkeydown="return blockEnter(event);"
                                 rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true" 
                                 value="#{registrarTecnicaAnestesiaBean.fechainiciooxigeno}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                  <t:message for="fechaInicioOxigeno" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelHoraInicioOxigeno">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraInicioOxigeno" required="true"
                                 immediate="true"
                                   rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"
                                   value="#{registrarTecnicaAnestesiaBean.horainiciooxigeno}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                    <t:message for="mnuHoraInicioOxigeno" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : " rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosInicioOxigeno" required="true"
                                    rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"
                                    immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.minutoiniciooxigeno}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                    <t:message for="mnuMinutosInicioOxigeno"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:panelGroup id="panelFechaFinOxigeno">
                <t:inputCalendar id="fechaFinOxigeno"
                                 rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"
                                 onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarTecnicaAnestesiaBean.fechafinoxigeno}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                  <t:message for="panelFechaFinOxigeno" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            <h:panelGroup id="panelHorafinOxigeno">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraFinOxigeno" required="true"
                                   immediate="true"
                                   rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"
                                   value="#{registrarTecnicaAnestesiaBean.horafinoxigeno}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                    <t:message for="mnuHoraFinOxigeno" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : " rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosFinOxigeno" required="true"
                                    rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}"
                                    immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.minutofinoxigeno}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostraroxigeno}">
                    <t:message for="mnuMinutosFinOxigeno"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText value="Oxigeno Nitroso (ltsX')" style="width:30px"/>
              <h:panelGroup id="panelTextFechaInicioNitroso">
              <h:outputText value="Fecha Inicio" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"/>
              </h:panelGroup>
              <h:panelGroup id = "panelTextHoraInicioNitroso">
              <h:outputText value="Hora Inicio" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"/>
              </h:panelGroup>
              <h:panelGroup id = "panelTextFechaFinNitroso">
              <h:outputText value="Fecha Fin" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"/>
              </h:panelGroup>
              <h:panelGroup id = "panelTextHoraFinNitroso">
              <h:outputText value="Hora Fin" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"/>
              </h:panelGroup>
              <h:panelGroup>
              <a4j:region renderRegionOnly="false">
              <h:panelGroup>
              <h:inputText id="itOxigenoNitroso" maxlength="1" style="width:30px" immediate="true"
              value="#{registrarTecnicaAnestesiaBean.tecnica.htanoxidonitro}"
              valueChangeListener="#{registrarTecnicaAnestesiaBean.setHtanoxidonitro}">
                <a4j:support id="supportOxigenoNitroso" event="onchange" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeOxidoNitroso}"
                               reRender="panelTextFechaInicioNitroso,panelTextHoraInicioNitroso,panelTextFechaFinNitroso,panelTextHoraFinNitroso,panelFechaInicioNitroso,panelHoraInicioNitroso,panelFechaFinNitroso,panelHoraFinNitroso">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>    
                 <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <t:message for="itOxigenoNitroso" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:inputText>
              
              </h:panelGroup>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOxigenoNitroso"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
            <h:panelGroup id="panelFechaInicioNitroso">
                <t:inputCalendar id="fechaInicioNitroso"
                                rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"
                                 onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarTecnicaAnestesiaBean.fechainicionitroso}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <t:message for="fechaInicioNitroso" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
               <h:panelGroup id="panelHoraInicioNitroso">
                <h:panelGroup rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <h:selectOneMenu id="mnuHoraInicioNitroso" required="true"
                                   immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.horainicionitroso}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraInicioNitroso" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : " rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"/>
                <h:panelGroup rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <h:selectOneMenu id="mnuMinutosInicioNitroso" required="true"
                                    immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.minutoinicionitroso}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosInicioNitroso"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              
                <h:panelGroup id="panelFechaFinNitroso">
                <t:inputCalendar id="fechaFinNitroso"
                                 onkeydown="return blockEnter(event);"
                                 rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarTecnicaAnestesiaBean.fechafinnitroso}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <t:message for="fechaFinNitroso" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              
              
              
                     <h:panelGroup id="panelHoraFinNitroso">
                <h:panelGroup rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <h:selectOneMenu id="mnuHoraFinNitroso" required="true"
                                   immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.horafinnitroso}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraFinNitroso" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : " rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}"/>
                <h:panelGroup rendered="#{registrarTecnicaAnestesiaBean.mostrarnitroso}">
                  <h:selectOneMenu id="mnuMinutosFinNitroso" required="true"
                                    immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.minutofinnitroso}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosFinNitroso"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              
              
            </h:panelGrid>
          </s:fieldset>
            
              <s:fieldset legend="Agentes Anestesico Inhalatorio" id="fieldAgenteAnestesicoInhalatorio"
                      styleClass="fieldset">
                      
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                         width="100%"
                         id="panelGridAgenteAnestesicoInhalatorio"
                         rowClasses="labelText,labelTextInfo">
                         
                         <h:outputText value = "Fecha Inicio"/>
                         <h:outputText value = "Hora Inicio"/>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         
             <h:panelGroup id="panelFechaInicioInhalatorio">
                <t:inputCalendar id="fechaInicioInhalatorio"
                                 onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarTecnicaAnestesiaBean.fechainicioinhalatorio}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicioInhalatorio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
               <h:panelGroup id="panelHoraInicioInhalatorio">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraInicioInhalatorio" required="true"
                                   immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.horainicioinhalatorio}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraInicioInhalatorio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosInicioInhalatorio" required="true"
                                    immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.minutoinicioinhalatorio}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosInicioInhalatorio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         
                         <h:outputText value = "Inducción Agente"/>
                         <h:panelGroup id = "panelTextVolumenInduccion">
                         <h:outputText value = "Volumen (%)"  rendered="#{registrarTecnicaAnestesiaBean.mostrarVolumenInduccion}"/>
                         </h:panelGroup>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                          <a4j:region renderRegionOnly="false">
                        <h:panelGroup>
                            <h:selectOneMenu id="mnuAgenteInduccion" immediate="true"
                            value = "#{registrarTecnicaAnestesiaBean.tecnica.htacinducagent}"
                            valueChangeListener="#{registrarTecnicaAnestesiaBean.setHtacinducagent}">
                            <f:selectItems value = "#{registrarTecnicaAnestesiaBean.lstAgente}"/>
                             <a4j:support id="supportAgenteInduccion" event="onchange" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeAgenteInduccion}"
                               reRender="panelTextVolumenInduccion,panelInputVolumenInduccion">
                              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>     
                            </h:selectOneMenu>
                        
                        </h:panelGroup>
                        </a4j:region>
                        <h:panelGroup id="panelInputVolumenInduccion">
                         <h:inputText id = "itconcentracion"  maxlength="4" style="width:40px"
                         rendered="#{registrarTecnicaAnestesiaBean.mostrarVolumenInduccion}"
                            value = "#{registrarTecnicaAnestesiaBean.tecnica.htanconcentrac}"/>
                             <a4j:outputPanel ajaxRendered="true">
                             <t:message for="itconcentracion"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                        </h:panelGroup>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         
                         <h:outputText value = "Mantenimiento Agente"/>
                         <h:panelGroup id = "panelTextVolumenMantenimiento">
                         <h:outputText value = "Volumen (%)" rendered="#{registrarTecnicaAnestesiaBean.mostrarVolumenMantenimiento}"/>
                         </h:panelGroup>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         <a4j:region renderRegionOnly="false">
                         <h:panelGroup>
                            <h:selectOneMenu id="mnuAgentemantenimiento" immediate="true"
                            value = "#{registrarTecnicaAnestesiaBean.tecnica.htacmanteagent}"
                            valueChangeListener="#{registrarTecnicaAnestesiaBean.setHtacmanteagent}">
                            <f:selectItems value = "#{registrarTecnicaAnestesiaBean.lstAgente}"/>
                              <a4j:support id="supportAgentemantenimiento" event="onchange" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeAgenteMantenimiento}"
                               reRender="panelTextVolumenMantenimiento,panelInputVolumenMantenimiento">
                              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                              </a4j:support>     
                            </h:selectOneMenu>
                            </h:panelGroup>
                            </a4j:region>
                               <h:panelGroup id = "panelInputVolumenMantenimiento">
                         <h:inputText id = "itMantenimientoConcentracion"  maxlength="4" style="width:40px"
                         rendered="#{registrarTecnicaAnestesiaBean.mostrarVolumenMantenimiento}"
                            value = "#{registrarTecnicaAnestesiaBean.tecnica.htanmanteconce}"/>
                             <a4j:outputPanel ajaxRendered="true">
                             <t:message for="itMantenimientoConcentracion"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                        </h:panelGroup>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         
                         
                         <h:outputText value = "Cambio Concentración"/>
                         <h:panelGroup id = "panelTextPorcentajeCambio">
                         <h:outputText value = "Porcentaje(%)" rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"/>
                         </h:panelGroup>
                         <h:panelGroup id = "panelTextFechaCambio">
                         <h:outputText value = "Fecha de Cambio" rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"/>
                         </h:panelGroup>
                         <h:panelGroup id = "panelTextHoraCambio">
                         <h:outputText value = "Hora de Cambio" rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"/>
                         </h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                       <h:panelGroup>
                       <h:selectOneRadio id="mnuCambio" immediate="true"
                       value="#{registrarTecnicaAnestesiaBean.tecnica.htaccambiconce}"
                       valueChangeListener="#{registrarTecnicaAnestesiaBean.setHtaccambiconce}">
                       <f:selectItems value = "#{registrarTecnicaAnestesiaBean.lstOpciones}"/>
                           <a4j:support id="supportmnuCambio" event="onclick" immediate="true"
                               action="#{registrarTecnicaAnestesiaBean.changeCambio}"
                               reRender="panelTextPorcentajeCambio,panelTextFechaCambio,panelTextHoraCambio,panelFechaCambio,panelHoraCambio,panelPorcentajeCambio">
                              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                              </a4j:support>     
                       </h:selectOneRadio>
                       
                       </h:panelGroup>
                       </a4j:region>
                        <h:panelGroup id = "panelPorcentajeCambio">
                         <h:inputText id = "itPorcentaheCambio" maxlength="4" style="width:50px"
                         value = "#{registrarTecnicaAnestesiaBean.tecnica.htancambiconce}"  
                         rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"/>
                           <a4j:outputPanel ajaxRendered="true"  rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}">
                             <t:message for="itPorcentaheCambio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                         </h:panelGroup>
                <h:panelGroup id="panelFechaCambio">
                <t:inputCalendar id="fechaCambio"
                                 onkeydown="return blockEnter(event);"
                                 rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarTecnicaAnestesiaBean.fechacambio}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true"  rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}">
                  <t:message for="fechaCambio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
               <h:panelGroup id="panelHoraCambio">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraCambio" required="true"  
                                rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"
                                   immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.horacambio}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true"  rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}">
                    <t:message for="mnuHoraCambio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "  rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosCambio" required="true"
                                    immediate="true"  rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}"
                                   value="#{registrarTecnicaAnestesiaBean.minutocambio}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true"  rendered="#{registrarTecnicaAnestesiaBean.mostrarcambio}">
                    <t:message for="mnuMinutosCambio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
                         
                         <h:outputText value = "Fecha Finalización"/>
                         <h:outputText value = "Hora Finalización"/>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         
             <h:panelGroup id="panelFechaFinInhalatorio">
                <t:inputCalendar id="fechaFinInhalatorio"
                                 onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" immediate="true"
                                 title="Formato: dd/mm/yyyy"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{registrarTecnicaAnestesiaBean.fechafininhalatorio}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="true"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinInhalatorio" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
               <h:panelGroup id="panelHoraFinInhalatorio">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraFinInhalatorio" required="true"
                                   immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.horafininhalatorio}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraFinInhalatorio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosFinInhalatorio" required="true"
                                    immediate="true"
                                   value="#{registrarTecnicaAnestesiaBean.minutofininhalatorio}">
                    <f:selectItems value="#{registrarTecnicaAnestesiaBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosFinInhalatorio"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
                         <h:outputText value = ""/>
                         <h:outputText value = ""/>
                         
                         </h:panelGrid>
                         
                    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%"
                         id="panelGridObservacionesAgenteAnestesicoInhalatorio"
                         rowClasses="labelText,labelTextInfo">
                         
                          <h:outputText value = "Observaciones"/>
                          <h:inputTextarea id= "itObservaciones" style="width:600px"
                          value = "#{registrarTecnicaAnestesiaBean.tecnica.htacobservacio}" />
                           <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itObservaciones"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                         
                         </h:panelGrid>
            </s:fieldset>
            
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn.success"
                           action="#{registrarTecnicaAnestesiaBean.RegistrarTecnicaAnestesia}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
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
    </h:panelGrid>
  </a4j:region>
</a4j:form>