<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAntecedentesGinecologicos" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAntecedentesGinecologicospre" label="Antecedentes Ginecologicos Prenatal">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentes">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Ciclos" id="fieldAntecedentesCiclos" styleClass="fieldset" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderCiclos}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosTieneCiclos" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tipo de ciclo" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="radioTipoCiclo" immediate="true" required="false" value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tipoCiclo}"
                                 valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setTipoCiclo}">
                  <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstTipoCiclo}"/>
                  <a4j:support id="support" event="onchange" immediate="true" oncomplete="ciclosJs()" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.changeTipo}"
                               reRender="panelAntecedentesCiclos">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="radioTipoCiclo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Frecuencia" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo}" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Duración" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo}" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itFrecuencia" onkeydown="return blockEnter(event);" required="false" maxlength="3"
                                 value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagnfreciclo}" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuencia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="-" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.cicloiregular}"/>
                  <h:panelGroup>
                    <h:inputText id="itFrecuenciaFinal" onkeydown="return blockEnter(event);" required="false" maxlength="3"
                                 rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.cicloiregular && antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo}"
                                 value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagnfinfreciclo}" style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuenciaFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itDuracion" onkeydown="return blockEnter(event);" required="false" maxlength="2" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo}"
                                 value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagndurciclo}" style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDuracion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="-" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.cicloiregular}"/>
                  <h:panelGroup>
                    <h:inputText id="itDuracionFinal" onkeydown="return blockEnter(event);" required="false" maxlength="2"
                                 rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.cicloiregular && antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo}"
                                 value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagnfindurciclo}" style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDuracionFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Ciclos" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Día del Ciclo" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"/>
                <h:panelGroup>
                  <h:inputText id="itCiclos" onkeydown="return blockEnter(event);" required="true" maxlength="10" value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcciclos}"
                               rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}" style="width:100px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCiclos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itDiaCiclo" onkeydown="return blockEnter(event);" required="true" maxlength="2" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"
                               value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagndiacic}" style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiaCiclo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"/>
                <h:panelGroup>
                  <h:outputText value="Edad Menarquia" styleClass="labelTextOblig"
                                rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo || antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderMenarquia}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Fecha Ultima Regla"
                                rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo || antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderMenarquia}"
                                title="Fecha Ultima Regla" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Fecha Penultima Regla"
                                rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo || antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderMenarquia}"
                                title="Fecha Penultima Regla" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itEdadMenarquia" onkeydown="return blockEnter(event);" title="Edad Menarquia" required="false" maxlength="2"
                               value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagnmenarquia}"
                               rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo || antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderMenarquia}" style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itEdadMenarquia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaRegla" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo || antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderMenarquia}"
                                   binding="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.itFechaRegla}" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagdfur}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarPenultimaRegla" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.tieneCiclo || antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderMenarquia}"
                                   binding="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.itPenFechaRegla}" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagdfpr}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarPenultimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.esFertilidad}"/>
                <h:outputText/>
                <h:outputText value="F.U.Citologia" title="Fecha Ultima Citologia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelResultadoCitologia">
                  <h:outputText value="Resultado" styleClass="labelTextOblig" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderResultado}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextHallazgos">
                  <h:outputText value="Cual? " rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderOtroResultado}" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup >
                    <h:selectOneMenu id="mnuUltimaCitologia" required="false" immediate="true" onkeydown="return blockEnter(event);"
                                     binding="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mnuUltima}" value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcultcitolo}"
                                     valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagcultcitolo}">
                      <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstUltimaCitologia}"/>
                      <a4j:support id="supportUltimaCitologia" event="onchange" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.changeUltimaCitologia}"
                                   reRender="panelResultadoCitologia,panelMenuResul,panelTextHallazgos,panelInputHallazgos" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuUltimaCitologia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup id="panelMenuResul">
                    <h:selectOneMenu id="mnuResultadoGineco" required="false" immediate="true" onkeydown="return blockEnter(event);"
                                     rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderResultado}" binding="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mnuResultado}"
                                     value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcresulcitol}"
                                     valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagcresulcitol}">
                      <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstResultado}"/>
                      <a4j:support id="supportResultadoUltimaCitologia" event="onchange" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.changeResultado}"
                                   reRender="panelTextHallazgos,panelInputHallazgos" immediate="true">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuResultadoGineco" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelInputHallazgos">
                  <h:inputText id="itOtrosHallazgos" maxlength="100" required="false" onkeydown="return blockEnter(event);"
                               rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderOtroResultado}"
                               value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcotroresul}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOtrosHallazgos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText value="Método de Planificación Actual " styleClass="labelText"  />
                <h:panelGroup id="panelTextCual" styleClass="labelText">
                  <h:outputText value="Cual? " rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarMetodo}"/>
                  <h:outputText value="Verifica uso correcto del método?" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildoras}"/>
                 <h:outputText value="Fecha de la última aplicación " rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarInyectable}"/>
                </h:panelGroup>
                  <h:panelGroup id="panelTextSusAnti">
                  <h:outputText  styleClass="labelText" value="Fecha de suspension método anticonceptivo" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarSuspencionAnticonceptivo}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextPildoras">
                  <h:outputText value="Aclaración Pildoras"  styleClass="labelText" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildorasSi}"/>
                  <h:outputText rendered="#{!antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildorasSi}"/>
                </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMetodoPlanificacion" immediate="true" value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcmetodoplan}"
                                   onkeydown="return blockEnter(event);" valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagcmetodoplan}">
                    <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstMetodo}"/>
                    <a4j:support id="supporMetodoPlanificacion" event="onchange" immediate="true" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.ChangeMetodo}"
                                 reRender="panelInputMetodo,panelTextPildoras,panelInputPildoras,panelTextCual,panelTextSusAnti,panelInputFechsuspMetodo">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                </h:panelGroup>
                </a4j:region>
                
                <h:panelGroup id="panelInputMetodo">
                  <h:inputText id="inputOtroMetodo" maxlength="50" onkeydown="return blockEnter(event);" required="false" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarMetodo}"
                               value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcotrometodo}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtroMetodo" styleClass="errorMessage" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarMetodo}"/>
                  </a4j:outputPanel>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuMetodoPildoras" immediate="true" onkeydown="return blockEnter(event);" required="true"
                                    rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildoras}"
                                    valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagcpildouso}"
                                    value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcpildouso}">
                    <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supporMetodoPildoras" event="onchange" immediate="true" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.ChangePildoras}"
                                 reRender="panelTextPildoras,panelInputPildoras">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMetodoPildoras" styleClass="errorMessage" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildoras}"/>
                  </a4j:outputPanel>
                  </a4j:region>
                  
                   <h:panelGroup id="panelInputFechaMetodo">
                  <t:inputCalendar id="inputFechaMetodo" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);" immediate="true" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true" popupTodayString="Hoy" popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                   align="top" required="false" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarInyectable}"
                                   value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagdfecultaplmet}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputFechaMetodo" styleClass="errorMessage" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarInyectable}"/>
                  </a4j:outputPanel>
                  </h:panelGroup>
                   
                </h:panelGroup>
                
                <h:panelGroup id="panelInputFechsuspMetodo">
                  <t:inputCalendar id="inputFechsuspMetodo" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);" immediate="true" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true" popupTodayString="Hoy" popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                                   align="top" required="false" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarSuspencionAnticonceptivo}"
                                   value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagdfecfinmetodoplan}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputFechaMetodo" styleClass="errorMessage" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarInyectable}"/>
                  </a4j:outputPanel>
                  </h:panelGroup>
                
                <h:panelGroup id="panelInputPildoras">
                  <h:inputTextarea id="inputMetodoPildoras" onkeydown="return blockEnter(event);" required="false" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildorasSi}"
                                   value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcpildoobser}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputFechsuspMetodo" styleClass="errorMessage" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildorasSi}"/>
                  </a4j:outputPanel>
                  <h:outputText rendered="#{!antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarPildorasSi}"/>
                </h:panelGroup>
                <h:outputText/>
              </h:panelGrid>
            </h:panelGrid>
            <h:outputText/>

          
            
          </s:fieldset>
        </a4j:region>
           <s:fieldset legend="Antecedentes" id="fieldAntecedentesPrenatal" styleClass="fieldset" >
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentAntecedentesPrenatal">
         <a4j:region renderRegionOnly="false">
            <h:panelGroup id="panelFlujoVaginal">
              <h:outputText value="Flujo Vaginal"  styleClass="labelText"/>
              <h:selectOneRadio id="mnuFlujoVaginal" immediate="true" onkeydown="return blockEnter(event);" required="true"
                                valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagcfluvag}"
                                value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcfluvag}">
                <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstOpciones}"/>
                <a4j:support id="supporFlujoVaginal" event="onchange" immediate="true" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.ChangeFlujoVaginal}"
                             reRender="panelFlujoVaginal,mnuFlujoVaginal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuFlujoVaginal" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              <h:outputText value="Cual? " rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarFlujoVaginal}"  styleClass="labelText"/>
              
              <h:inputTextarea id="textFlujoVaginal" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcobsfluvag}" style="width:600px"
                               rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarFlujoVaginal}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textFlujoVaginal" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            </a4j:region>
            
         
            
      
                       <h:outputText value="Colposcopia"  styleClass="labelTextOblig"/>
           
             <h:panelGroup>
            <h:selectOneRadio id="mnuColposcopia" immediate="true" required="true"
                              value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagccolposcopi}"
                              valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagccolposcopi}">
                        
              <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportmnuColposcopia" event="onchange" immediate="true" 
                action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.chanheColposcopia}"
                             reRender="panelTextResultadoColposcopia,panelInputResultadoColposcopia">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuColposcopia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          
          <h:panelGroup id = "panelTextResultadoColposcopia">
           <h:outputText value="Resultado Colposcopia"  rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderColposcopia}"
                    styleClass="labelTextOblig"/>
         </h:panelGroup>
          <h:panelGroup id = "panelInputResultadoColposcopia">
                <h:inputText rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.renderColposcopia}" maxlength="1000" required="true"
                  value = "#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcresulcolpo}"/>
           </h:panelGroup>
       
        
      
       
              <h:outputText value="Tratamiento Fertilidad"  styleClass="labelText"/>
              <h:selectOneRadio id="mnuTrataInferti" immediate="true" onkeydown="return blockEnter(event);" required="true"
                                valueChangeListener="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.setHagctratainfert}"
                                value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagctratainfert}">
                <f:selectItems value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportTrataInferti" event="onchange" immediate="true" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.ChangeTratmientoFertilidad}"
                             reRender="panelTrataInferti,panelInputTrataInferti">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTrataInferti" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
              <h:panelGroup id = "panelTrataInferti">
              <h:outputText value="Cual? "  styleClass="labelText" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarTratamientoInfertilidad}"/>
              </h:panelGroup>
                      <h:panelGroup id = "panelInputTrataInferti">
              <h:inputTextarea id="textTrataInferti" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.antecedente.hagcobstratainfert}"
                               style="width:600px" rendered="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.mostrarTratamientoInfertilidad}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="textTrataInferti" styleClass="errorMessage"/>
              </a4j:outputPanel>
       </h:panelGroup>
         
         </h:panelGrid>
        </s:fieldset>
        
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
            
            <t:messages id="msgInf" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarGinecologicos" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{antecedentesGinecologicosNuevoPrenatalUsuarioBean.aceptar}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>