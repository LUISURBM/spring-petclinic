<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControlViaAereaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneControlViaAerea" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabViaAerea" label="Ventilación y Manejo de Via Aerea">
      <s:fieldset legend="Dispositivos para control de vía aérea" id="fieldMetodoViaAerea" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMetodoVentilacionAsistida" rowClasses="labelText,labelTextInfo">
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkFacial" immediate="true" required="true" styleClass="css-checkbox" binding="#{registrarControlViaAereaBean.checkFacial}"
                                     value="#{registrarControlViaAereaBean.selectfacial}"/>
            <h:outputLabel value="Máscara Facial" for="checkFacial" styleClass="css-label"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:panelGroup id="panelTextNumeroOro">
            <h:outputText value="Número" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectcanulaoro}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkCanulaOro" immediate="true" styleClass="css-checkbox" binding="#{registrarControlViaAereaBean.checkCanual}"
                                       valueChangeListener="#{registrarControlViaAereaBean.setSelectcanulaoro}" value="#{registrarControlViaAereaBean.selectcanulaoro}">
                <a4j:support id="supportcheckCanulaOro" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeCanulaOro}"
                             reRender="panelTextNumeroOro,panelInputNumeroOro">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputLabel value="Cánula oro faríngea" for="checkCanulaOro" styleClass="css-label"/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputNumeroOro">
            <h:inputText id="itCanula" maxlength="2" style="width:50px" required="true" rendered="#{registrarControlViaAereaBean.selectcanulaoro}"
                         value="#{registrarControlViaAereaBean.viaaerea.hvancanulfarin}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectcanulaoro}">
              <t:message for="itCanula" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <h:outputText value="Cánula naso faríngea"/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:panelGroup>
            <h:selectBooleanCheckbox id="checkCanulaNaso" immediate="true" styleClass="css-checkbox" binding="#{registrarControlViaAereaBean.checkCanulaNaso}"
                                     value="#{registrarControlViaAereaBean.selectcanulanaso}"/>
            <h:outputLabel value="Cánula naso faríngea" for="checkCanulaNaso" styleClass="css-label"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText value="Máscara laríngea"/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkMascaraLaringuea" immediate="true" styleClass="css-checkbox" binding="#{registrarControlViaAereaBean.checkMascaraLaringuea}"
                                       value="#{registrarControlViaAereaBean.selectlaringuea}" valueChangeListener="#{registrarControlViaAereaBean.setSelectlaringuea}">
                <a4j:support id="supportcheckMascaraLaringuea" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeMascaraLaringuea}"
                             reRender="panelTextButton,panelText1,panelText2,panelText3,panelHoraColocacion,panelFechaColocacion,panelTextFechaColocacion,panelTextHoraColocacion,panelTextFechaRetiro,panelTextHoraInicio,panelFechaRetiro,panelHoraRetiro,horaMascaraLaringeaRetiro, horaMascaraLaringea,minMascaraLaringea,minMascaraLaringeaRetiro,panelTextCalibreLaringuea,panelInputCalibreLaringuea">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
        <h:outputLabel value="Máscara laríngea" for="checkMascaraLaringuea" styleClass="css-label"/>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:panelGroup id = "panelTextCalibreLaringuea" >
          <h:outputText id = "inputextCalibreLaringuea" value = "Calibre" styleClass="labelTextOblig" 
                            rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <h:outputText/>
          <!-- inicio -->
          <h:panelGroup id="panelTextButton">
            <h:selectOneRadio id="itMascaraSelect" value="#{registrarControlViaAereaBean.selectmascaralaringea}" immediate="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}"
                              valueChangeListener="#{registrarControlViaAereaBean.setSelectmascaralaringea}">
              <f:selectItems value="#{registrarControlViaAereaBean.lstmasclaringea}"/>
              <a4j:support id="supportmnuAntecedentes" event="onclick" action="#{registrarControlViaAereaBean.changeMascaraLaringea}">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
                <t:message for="itMascaraSelect" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:selectOneRadio>
          </h:panelGroup>
          <h:panelGroup id="panelText1">
            <h:outputText value="" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <h:panelGroup id="panelText2">
            <h:inputText id = "inputCalibre" value="#{registrarControlViaAereaBean.viaaerea.hvancaliblarin}" 
            required="true" style="width:50px" maxlength="3"
            rendered="#{registrarControlViaAereaBean.selectlaringuea}">
            <f:validateDoubleRange maximum="9.9"/>
               
            </h:inputText>
               <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
                <t:message for="inputCalibre" styleClass="errorMessage"/>
              </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelText3">
            <h:outputText value="" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <!-- final -->
          <h:panelGroup id="panelTextFechaColocacion">
            <h:outputText value="Fecha colocación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextHoraColocacion">
            <h:outputText value="Hora de colocación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextFechaRetiro">
            <h:outputText value="Fecha de retiro" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextHoraInicio">
            <h:outputText value="Hora de retiro" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
          </h:panelGroup>
          <h:panelGroup id="panelFechaColocacion">
            <t:inputCalendar id="fechaColocacion" onkeydown="return blockEnter(event);" styleClass="input-small" rendered="#{registrarControlViaAereaBean.selectlaringuea}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{registrarControlViaAereaBean.viaaerea.hvadhoracolmas}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
              <t:message for="fechaColocacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelHoraColocacion">
            <h:panelGroup>
              <h:selectOneMenu id="mnuHoraColocacion" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectlaringuea}"
                               value="#{registrarControlViaAereaBean.horacolocacion}">
                <f:selectItems value="#{registrarControlViaAereaBean.listHora}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="horaMascaraLaringea" value="HH" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
                <t:message for="mnuHoraColocacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=" : " rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMinutosColocacion" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectlaringuea}"
                               value="#{registrarControlViaAereaBean.minutocolocacion}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstMinutos}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="minMascaraLaringea" value="mm" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
                <t:message for="mnuMinutosColocacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup id="panelFechaRetiro">
            <t:inputCalendar id="fechaRetiro" onkeydown="return blockEnter(event);" styleClass="input-small" rendered="#{registrarControlViaAereaBean.selectlaringuea}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{registrarControlViaAereaBean.viaaerea.hvadhoraretmas}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
              <t:message for="fechaRetiro" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelHoraRetiro">
            <h:panelGroup>
              <h:selectOneMenu id="mnuHoraRetiro" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectlaringuea}" value="#{registrarControlViaAereaBean.horaretiro}">
                <f:selectItems value="#{registrarControlViaAereaBean.listHora}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="horaMascaraLaringeaRetiro" value="HH" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
                <t:message for="mnuHoraRetiro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=" : " rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMinutosRetiro" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectlaringuea}"
                               value="#{registrarControlViaAereaBean.minutoretiro}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstMinutos}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="minMascaraLaringeaRetiro" value="mm" rendered="#{registrarControlViaAereaBean.selectlaringuea}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectlaringuea}">
                <t:message for="mnuMinutosRetiro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup id="panelTextTipoDispositivo">
            <h:outputText value="Tipo de dispositivo utilizado" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkOtroDispositivo" immediate="true" styleClass="css-checkbox" binding="#{registrarControlViaAereaBean.checkOtroDispositivo}"
                                       value="#{registrarControlViaAereaBean.selectotrodispositivo}" valueChangeListener="#{registrarControlViaAereaBean.setSelectotrodispositivo}">
                <a4j:support id="supportcheckOtroDispositivo" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeOtroDispositivo}"
                             reRender="panelInputTipoDispositivo,panelTextTipoDispositivo,panelTextFechaColocacionOtro,panelTextHoraColocacionOtro                                ,panelTextFechaRetitoOtro,panelTextHoraRetiroOtro,panelFechaColocacionOtro,panelHoraColocacionOtro,panelHoraRetiroOtro                                ,panelFechaRetiroOtro,horaOtroDisp,minOtroDisp,horaOtroDispRetiro,minOtroDispRetiro">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputLabel value="Otro dispositivo supra glótico" for="checkOtroDispositivo" styleClass="css-label"/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputTipoDispositivo">
            <h:inputText id="itTipoDispositivo" maxlength="50" required="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                         value="#{registrarControlViaAereaBean.viaaerea.hvacotrodispos}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
              <t:message for="itTipoDispositivo" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <h:panelGroup id="panelTextFechaColocacionOtro">
            <h:outputText value="Fecha Colocación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextHoraColocacionOtro">
            <h:outputText value="Hora Colocación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextFechaRetitoOtro">
            <h:outputText value="Fecha Retiro" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextHoraRetiroOtro">
            <h:outputText value="Hora Retiro" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
          </h:panelGroup>
          <h:panelGroup id="panelFechaColocacionOtro">
            <t:inputCalendar id="fechaColocacionOtro" onkeydown="return blockEnter(event);" styleClass="input-small" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{registrarControlViaAereaBean.viaaerea.hvadhoracolotr}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
              <t:message for="fechaColocacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelHoraColocacionOtro">
            <h:panelGroup>
              <h:selectOneMenu id="mnuHoraColocacionOtro" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                               value="#{registrarControlViaAereaBean.horacolocacionotro}">
                <f:selectItems value="#{registrarControlViaAereaBean.listHora}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="horaOtroDisp" value="HH" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
                <t:message for="mnuHoraColocacionOtro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=" : " rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMinutosColocacionOtro" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                               value="#{registrarControlViaAereaBean.minutocolocacionotro}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstMinutos}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="minOtroDisp" value="mm" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
                <t:message for="mnuMinutosColocacionOtro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup id="panelFechaRetiroOtro">
            <t:inputCalendar id="fechaRetiroOtro" onkeydown="return blockEnter(event);" styleClass="input-small" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{registrarControlViaAereaBean.viaaerea.hvadhoraretotr}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
              <t:message for="fechaRetiroOtro" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelHoraRetiroOtro">
            <h:panelGroup>
              <h:selectOneMenu id="mnuHoraRetiroOtro" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                               value="#{registrarControlViaAereaBean.horaretirootro}">
                <f:selectItems value="#{registrarControlViaAereaBean.listHora}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="horaOtroDispRetiro" value="HH" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
                <t:message for="mnuHoraRetiroOtro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=" : " rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMinutosRetiroOtro" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"
                               value="#{registrarControlViaAereaBean.minutoretirootro}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstMinutos}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="minOtroDispRetiro" value="mm" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectotrodispositivo}">
                <t:message for="mnuMinutosRetiroOtro" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:outputText value="Intubación"/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkIntubacion" immediate="true" styleClass="css-checkbox" binding="#{registrarControlViaAereaBean.checkIntubacion}"
                                       valueChangeListener="#{registrarControlViaAereaBean.setSelectIntubacion}" value="#{registrarControlViaAereaBean.selectIntubacion}">
                <a4j:support id="supportcheckIntubacion" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeIntubacion}"
                             reRender="panelTextOrotraqueal,panelTextNasotraqueal,panelTextLaringoscopia,panelTextFechaIntubacion,panelTextHoraIntubacion,                                panelTextFechaExtubacion,panelTextHoraExtubacion,panelFechaIntubacion,panelHoraIntubacion,panelFechaExtubacion,panelHoraExtubacion,                                panelInputOrotraqueal,panelInputNasotraqueal,panelTextMenuLaringoscopia,horaExtuba,minutoExtuba,horaExtuba1,minutoExtuba1">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputLabel value="Intubación" for="checkIntubacion" styleClass="css-label"/>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <h:panelGroup id="panelTextOrotraqueal">
            <h:outputText value="Orotraqueal" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextNasotraqueal">
            <h:outputText value="Nasotraqueal" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextLaringoscopia">
            <h:outputText value="Vista laringoscopica" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup id="panelInputOrotraqueal">
            <h:inputText id="itOrotraqueal" maxlength="3" style="width:50px" required="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                         value="#{registrarControlViaAereaBean.viaaerea.hvanintuborotr}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
              <t:message for="itOrotraqueal" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelInputNasotraqueal">
            <h:inputText id="itNasotraqueal" maxlength="3" style="width:50px" required="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                         value="#{registrarControlViaAereaBean.viaaerea.hvanintubnasot}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
              <t:message for="itNasotraqueal" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelTextMenuLaringoscopia">
            <h:selectOneMenu id="mnuLaringoscopia" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                             value="#{registrarControlViaAereaBean.viaaerea.hvacvistalarin}">
              <f:selectItems value="#{registrarControlViaAereaBean.lstVistaLaringoscopia}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
              <t:message for="mnuLaringoscopia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup id="panelTextFechaIntubacion">
            <h:outputText value="Fecha Intubación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextHoraIntubacion">
            <h:outputText value="Hora Intubación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextFechaExtubacion">
            <h:outputText value="Fecha Extubación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextHoraExtubacion">
            <h:outputText value="Hora Extubación" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
          </h:panelGroup>
          <h:panelGroup id="panelFechaIntubacion">
            <t:inputCalendar id="fechaIntubacion" onkeydown="return blockEnter(event);" styleClass="input-small" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{registrarControlViaAereaBean.viaaerea.hvadhoraintuba}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
              <t:message for="fechaIntubacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelHoraIntubacion">
            <h:panelGroup>
              <h:selectOneMenu id="mnuHoraIntubacion" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                               value="#{registrarControlViaAereaBean.horaintubacion}">
                <f:selectItems value="#{registrarControlViaAereaBean.listHora}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="horaExtuba1" value="HH" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
                <t:message for="mnuHoraIntubacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=" : " rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMinutosIntubacion" required="true" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                               value="#{registrarControlViaAereaBean.minutointubacion}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstMinutos}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="minutoExtuba1" value="mm" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
                <t:message for="mnuMinutosIntubacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:panelGroup id="panelFechaExtubacion">
            <t:inputCalendar id="fechaExtubacion" onkeydown="return blockEnter(event);" styleClass="input-small" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{registrarControlViaAereaBean.viaaerea.hvadhoraextuba}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top"></t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
              <t:message for="fechaExtubacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelHoraExtubacion">
            <h:panelGroup>
              <h:selectOneMenu id="mnuHoraExtubacion" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                               value="#{registrarControlViaAereaBean.horaextubacion}">
                <f:selectItems value="#{registrarControlViaAereaBean.listHora}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="horaExtuba" value="HH" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
                <t:message for="mnuHoraExtubacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=" : " rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
            <h:panelGroup>
              <h:selectOneMenu id="mnuMinutosExtubacion" styleClass="input-mini mainselection" rendered="#{registrarControlViaAereaBean.selectIntubacion}"
                               value="#{registrarControlViaAereaBean.minutoextubacion}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstMinutos}"/>
              </h:selectOneMenu>
              <h:panelGroup>
                <h:outputText id="minutoExtuba" value="mm" rendered="#{registrarControlViaAereaBean.selectIntubacion}"/>
              </h:panelGroup>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
                <t:message for="mnuMinutosExtubacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup id="panelTextOtro">
            <h:outputText value="Cuál?" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.selectotro}"/>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectBooleanCheckbox id="checkOtro" immediate="true" styleClass="css-checkbox" valueChangeListener="#{registrarControlViaAereaBean.setSelectotro}"
                                       binding="#{registrarControlViaAereaBean.checkOtro}" value="#{registrarControlViaAereaBean.selectotro}">
                <a4j:support id="supportcheckOtraDescripcion" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeOtraDescripcion}"
                             reRender="panelInputOtro,panelTextOtro">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputLabel value="Otro" for="checkOtro" styleClass="css-label"/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputOtro">
            <h:inputText id="itOtraDescripcion" maxlength="200" style="width:200px" required="true" rendered="#{registrarControlViaAereaBean.selectotro}"
                         value="#{registrarControlViaAereaBean.viaaerea.hvacmetoconvia}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.selectIntubacion}">
              <t:message for="itOtraDescripcion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText/>
          <h:outputText/>
        </h:panelGrid>
        <s:fieldset legend="Modo de Ventilación" id="fieldModoVentilacion" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelModoVentilacion" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Modo de Ventilación" styleClass="labelTextOblig"/>
            <h:panelGroup id="panelTextFrecuenciaRespiratoria">
              <h:outputText value="Frecuencia respiratoria en ventilaciones por minuto " styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextVolumen">
              <h:outputText value="Volumen corriente en mililitros " styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}"/>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="mnuModoVentilacion" immediate="true" required="true" binding="#{registrarControlViaAereaBean.mnuModoVentilacion}"
                                  valueChangeListener="#{registrarControlViaAereaBean.setHvacmodoventil}" value="#{registrarControlViaAereaBean.viaaerea.hvacmodoventil}">
                  <f:selectItems value="#{registrarControlViaAereaBean.lstModoVentilacion}"/>
                  <a4j:support id="supportModoVentilacion" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeModoVentilacion}"
                               reRender="panelTextFrecuenciaRespiratoria,panelTextVolumen,panelInputFrecuenciaRespiratoria,panelInputVolumen,panelTextVentilador,panelInputVentilador">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuModoVentilacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </a4j:region>
            <h:panelGroup id="panelInputFrecuenciaRespiratoria">
              <h:inputText id="itFrecuenciaRespiratoria" style="width:50px" maxlength="2" required="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}"
                           value="#{registrarControlViaAereaBean.viaaerea.hvanmecanfrecu}"/>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}">
                <t:message for="itFrecuenciaRespiratoria" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputVolumen">
              <h:inputText id="itVolumen" maxlength="4" style="width:50px" required="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}"
                           value="#{registrarControlViaAereaBean.viaaerea.hvanmecanvolum}"/>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}">
                <t:message for="itVolumen" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelTextVentilador">
              <h:outputText value="Ventilador " styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}"/>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
            <h:panelGroup id="panelInputVentilador">
              <h:inputText id="itVentilador" style="width:300px" maxlength="50" required="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}"
                           value="#{registrarControlViaAereaBean.viaaerea.hvacmecanventi}"/>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}">
                <t:message for="itVentilador" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText/>
            <h:outputText/>
          </h:panelGrid>
        </s:fieldset>
      </s:fieldset>
      <s:fieldset legend="Circuito de Administración de Oxígeno " id="fieldCapnografia" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAdministracionOxigeno" rowClasses="labelText,labelTextInfo">
          <h:outputText id="itCircuito" styleClass="labelTextOblig" value="Circuito de administración de Oxígeno"/>
          <h:panelGroup id="panelTextTipoOxigeno">
            <h:outputText id="itTipoOxigenoDirecto" value="Tipo Oxigeno" styleClass="labelTextOblig"
                          rendered="#{registrarControlViaAereaBean.mostraroxigeno && !registrarControlViaAereaBean.mostrarotro}"/>
            <h:outputText id="itCualCircuito" value="Cual?" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.mostrarotro && !registrarControlViaAereaBean.mostraroxigeno }"/>
          </h:panelGroup>
          <h:panelGroup id="panelTextMascaraOxigeno">
            <h:outputText id="itTipoMascaraOxigeno" styleClass="labelTextOblig" value="Máscara de Oxigeno" rendered="#{registrarControlViaAereaBean.mostrarmascara}"/>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneMenu id="mnuCircuitoAdministracion" immediate="true" required="true" styleClass="mainselection" value="#{registrarControlViaAereaBean.viaaerea.hvaccircuoxige}"
                               valueChangeListener="#{registrarControlViaAereaBean.setHvaccircuoxige}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstCircuito}" id="mainselection"/>
                <a4j:support id="supportFonendoscopio" event="onchange" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeCircuitoAdministracion}"
                             reRender="panelTextTipoOxigeno,panelTextMascaraOxigeno,panelMenuTipoOxigeno,panelMnuTipoMascara">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCircuitoAdministracion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneMenu>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup id="panelMenuTipoOxigeno">
              <h:panelGroup>
                <h:selectOneRadio id="mnuTipoOxigeno" immediate="true" required="true" rendered="#{registrarControlViaAereaBean.mostraroxigeno}"
                                  value="#{registrarControlViaAereaBean.viaaerea.hvactipooxigen}" valueChangeListener="#{registrarControlViaAereaBean.setHvactipooxigen}">
                  <f:selectItems value="#{registrarControlViaAereaBean.lstTipoOxigenoDirecto}"/>
                  <a4j:support id="supportTipoOxigeno" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeTipoOxigeno}"
                               reRender="panelTextMascaraOxigeno,panelMnuTipoMascara">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostraroxigeno}">
                    <t:message for="mnuCircuitoAdministracion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:selectOneRadio>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itOtroCircuito" style="width:200px" maxlength="50" required="true" rendered="#{registrarControlViaAereaBean.mostrarotro}"
                             value="#{registrarControlViaAereaBean.viaaerea.hvacotrooxigen}"/>
                <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarotro}">
                  <t:message for="itOtroCircuito" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelMnuTipoMascara">
            <h:selectOneRadio id="mnuTipoMascara" required="true" rendered="#{registrarControlViaAereaBean.mostrarmascara}" value="#{registrarControlViaAereaBean.viaaerea.hvactipomascar}">
              <f:selectItems value="#{registrarControlViaAereaBean.lstTipoMascara}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarmascara}">
              <t:message for="mnuTipoMascara" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Control de la vía aérea " id="fieldControlViaAerea" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelControlViaAerea" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Control de la vía aérea" styleClass="labelTextOblig"/>
          <h:panelGroup id="panelTextDificultades">
            <h:outputText value="Dificultades de control de la vía aérea" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.mostrardificultades}"/>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuControlViaAerea" immediate="true" layout="pageDirection" valueChangeListener="#{registrarControlViaAereaBean.setHvaccontviarea}"
                                value="#{registrarControlViaAereaBean.viaaerea.hvaccontviarea}">
                <f:selectItems value="#{registrarControlViaAereaBean.lstTipoControl}"/>
                <a4j:support id="supportControlViaAerea" event="onclick" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeControlViaAerea}"
                             reRender="panelTextDificultades,panelInputDificultades">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}">
                <t:message for="mnuControlViaAerea" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputDificultades">
            <h:inputTextarea id="itDificultades" style="width:400px" required="true" rendered="#{registrarControlViaAereaBean.mostrardificultades}"
                             value="#{registrarControlViaAereaBean.viaaerea.hvacviadificil}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarventilacionmecanica}">
              <t:message for="itDificultades" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value="Verificación vía aérea" styleClass="labelTextOblig"/>
          <h:panelGroup id="panelTextOtraVerificacion">
            <h:outputText value="Cual?" styleClass="labelTextOblig" rendered="#{registrarControlViaAereaBean.mostrarotraverificacion}"/>
          </h:panelGroup>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectManyCheckbox required="true" immediate="true" id="mnuVerificacion" value="#{registrarControlViaAereaBean.lstVerifica}"
                                    valueChangeListener="#{registrarControlViaAereaBean.setLstVerifica}" layout="pageDirection">
                <f:selectItem itemValue="C" itemLabel="Capnografía"/>
                <f:selectItem itemValue="A" itemLabel="Auscultación"/>
                <f:selectItem itemValue="O" itemLabel="Otra"/>
                <a4j:support id="supportVerificacion" event="onchange" ignoreDupResponses="true" immediate="true" action="#{registrarControlViaAereaBean.changeVerifica}"
                             reRender="panelInputOtraVerificacion,panelTextOtraVerificacion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectManyCheckbox>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuVerificacion" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputOtraVerificacion">
            <h:inputText id="itOtraVerificacion" maxlength="50" style="width:300px" required="true" rendered="#{registrarControlViaAereaBean.mostrarotraverificacion}"
                         value="#{registrarControlViaAereaBean.viaaerea.hvacotraverifi}"/>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarControlViaAereaBean.mostrarotraverificacion}">
              <t:message for="itOtraVerificacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelObservaciones" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Observaciones"/>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
            <a4j:region renderRegionOnly="false">
              <a4j:commandLink action="#{registrarControlViaAereaBean.mostrarBuscadorPlantilla}" reRender="panelGridControlViaAereaTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputTextarea id="itObservaciones" onkeydown="return blockEnter(event);" binding="#{registrarControlViaAereaBean.itDescripcion}"
                               value="#{registrarControlViaAereaBean.viaaerea.hvacobserviare}" style="width:350px;height:70px"/>
            </a4j:region>
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itObservaciones" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantilla" label="Buscar Plantillas" rendered="#{registrarControlViaAereaBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantilla" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantilla">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantilla" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantilla" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar" columnClasses="panelGridBotones">
    <h:panelGroup>
      <h:commandButton value="Siguiente" styleClass="btn btn btn-info" action="#{registrarControlViaAereaBean.RegistrarViaAerea}">
        <a4j:support event="onclick" status="statusButton"/>
      </h:commandButton>
    </h:panelGroup>
  </h:panelGrid>
  <h:panelGrid>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>