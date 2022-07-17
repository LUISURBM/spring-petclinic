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
    <t:panelTab id="panelTabAntecedentesGinecologicos" label="Antecedentes Ginecologicos">
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf1" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsAntecedentes">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Embarazos" id="fieldAntecedentes" styleClass="fieldset">
            <a4j:region id="regionAntecedentes" renderRegionOnly="false">
              <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAntecedentes" rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesgest" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Gestaciones" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <h:inputText id="itNumGesta" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumGesta}" required="false"
                                   title="Numero de Gestaciones" maxlength="2" style="width:30px" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumgesta}"
                                   valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroGestaciones}">
                        <a4j:support id="supportNumGesta" event="onchange" oncomplete="jsFunction()" action="#{antecedentesGinecologicosUsuarioBean.changeNumeroGestaciones}"
                                     reRender="panelInputPartos,panelInputAbortos,panelInputCesareas,panelInputVivos,panelInputEctopicos,panelInputMuertos,panelInputMortinatos,panelCursor,panelInputParto,panelInputHijosNacidosVivos">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itNumGesta" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panelInputPartos">
                  <h:panelGrid columns="1" id="panelDatosAntecedentesPar" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Partos" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <h:panelGroup>
                        <h:inputText id="itNumPartos" onkeydown="return blockEnter(event);" binding="#{antecedentesGinecologicosUsuarioBean.itNumPartos}" required="false" title="Numero de Partos"
                                     immediate="true" 
                                     disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumparto}"
                                     maxlength="2" style="width:30px">
                          <a4j:support id="supportPart" event="onchange" 
                          action="#{antecedentesGinecologicosUsuarioBean.changeNumeroPartos}" 
                          reRender="panelGroupFechaAbort">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:inputText>
                      </h:panelGroup>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesAbor" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Abortos" styleClass="labelTextOblig"/>
                    <h:panelGroup id="panelInputAbortos">
                      <h:panelGroup>
                        <h:inputText id="itNumAbortos" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumAbortos}" required="false"
                                     title="Numero de Abortos" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                     value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumaborto}" valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setAbortosPrevios}">
                          <a4j:support id="supportEmbprev" event="onchange" action="#{antecedentesGinecologicosUsuarioBean.changeNumeroAbortoPrevios}"
                                       reRender="panelEmbarazosespon,panelAbortoInducidos,panelAborSeguidos,panelGroupFechaAbort">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:inputText>
                      </h:panelGroup>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesCes" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Cesareas" styleClass="labelTextOblig"/>
                    <h:panelGroup id="panelInputCesareas">
                      <h:inputText id="itNumcesareas" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumcesareas}" required="false"
                                   title="Numero de Cesareas" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                   valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroCesarias}" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumcesare}">
                        <a4j:support id="supportNumCesareas" event="onchange" action="#{antecedentesGinecologicosUsuarioBean.changeNumeroCesarias}" reRender="panelInputCesareas">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itNumcesareas" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesNV" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Hijos Nacidos Vivos" styleClass="labelTextOblig"/>
                    <h:panelGroup id="panelInputHijosNacidosVivos">
                      <h:inputText id="itNumHijoNacidoVivo" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumNacidosVivos}" required="false"
                                   title="Numero de Hijos Nacidos Vivos" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnacivivo}"></h:inputText>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itNumHijoNacidoVivo" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesHV" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Hijos Vivos " styleClass="labelTextOblig"/>
                    <h:panelGroup id="panelInputVivos">
                      <h:panelGroup>
                        <h:inputText id="itNumHijosVivos" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumHijosVivos}" required="false"
                                     title="Numero de Hijos Vivos" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                     value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumvivo}"></h:inputText>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="itNumHijosVivos" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesEC" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Ectopicos   " styleClass="labelTextOblig" rendered="#{antecedentesGinecologicosUsuarioBean.renderEctopicos}"/>
                    <h:panelGroup id="panelInputEctopicos" rendered="#{antecedentesGinecologicosUsuarioBean.renderEctopicos}">
                      <h:panelGroup>
                        <h:inputText id="itNumEctopicos" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumEctopicos}" required="false"
                                     title="Numero de Ectopicos" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                     valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroEctopicos}" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnectopico}">
                          <a4j:support id="supportNumEctopicos" event="onchange" action="#{antecedentesGinecologicosUsuarioBean.changeNumeroEctopicos}" reRender="panelInputEctopicos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:inputText>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="itNumEctopicos" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesMT" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Mortinatos  " styleClass="labelTextOblig" rendered="#{antecedentesGinecologicosUsuarioBean.renderMortinatos}"/>
                    <h:panelGroup id="panelInputMortinatos" rendered="#{antecedentesGinecologicosUsuarioBean.renderMortinatos}">
                      <h:panelGroup>
                        <h:inputText id="itNumHijosMortinatos" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumHijosMortinatos}"
                                     required="false" title="Numero de Mortinatos" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                     valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroMortinatos}" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnmortina}">
                          <a4j:support id="supportNumMortinatos" event="onchange" action="#{antecedentesGinecologicosUsuarioBean.changeNumeroMortinatos}" reRender="panelInputMortinatos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:inputText>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="itNumHijosMortinatos" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelDatosAntecedentesMO" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Molas       " styleClass="labelTextOblig" rendered="#{antecedentesGinecologicosUsuarioBean.renderMolas}"/>
                    <h:panelGroup id="panelInputMuertos" rendered="#{antecedentesGinecologicosUsuarioBean.renderMolas}">
                      <h:panelGroup>
                        <h:inputText id="itNumHijosMuertos" onkeydown="return blockEnter(event);" immediate="true" binding="#{antecedentesGinecologicosUsuarioBean.itNumHijosMuertos}" required="false"
                                     title="Numero de Hijos Muertos" maxlength="2" style="width:30px" disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                     valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroMolas}" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnmuerto}">
                          <a4j:support id="supportNumMolas" event="onchange" action="#{antecedentesGinecologicosUsuarioBean.changeNumeroMolas}" reRender="panelInputMuertos">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                          </a4j:support>
                        </h:inputText>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="itNumHijosMuertos" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <s:fieldset legend="Paridad" id="fieldParidad" styleClass="fieldset">
            <a4j:region id="regionAntecedentesParidad" renderRegionOnly="false">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosAntecedentesParidad" rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Embarazo actual planeado" styleClass="labelTextOblig"/>
                  <h:selectOneRadio id="mnuParidad" immediate="true" 
                  onkeydown="return blockEnter(event);" 
                  value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcembplan}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                  </h:selectOneRadio>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" id="panelEmbarazosmul">
                    <h:outputText value="Embarazos m�ltiples" styleClass="labelTextOblig"/>
                    <h:inputText id="itdatEmbMulti" title="Numero embarazos Multiples" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumembmulti}"
                                 style="width:30px" maxlength="1"/>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panelGroupFechaAbort">
                  <h:panelGrid columns="1" id="panelFechaAbort" rendered="#{antecedentesGinecologicosUsuarioBean.renderedfechaAbortparto}">
                    <h:outputText value="Fecha de �ltimo parto/Aborto" styleClass="labelTextOblig"/>
                    <t:inputCalendar id="calendarfechaAbort" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                     binding="#{antecedentesGinecologicosUsuarioBean.itFechaAbortoParto}" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                     value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfecultabopar}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true" align="top" required="false">
                      <f:validator validatorId="dateMenorIgualValidator"/>
                    </t:inputCalendar>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="calendarfechaAbort" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panelEmbarazosespon">
                  <h:panelGrid columns="1" id="panelDatosAntecedentesAborEs" 
                  rowClasses="labelText,labelTextInfo" 
                  rendered="#{antecedentesGinecologicosUsuarioBean.renderedAbortsprevios}">
                    <h:outputText value="N�mero de abortos espont�neos" styleClass="labelTextOblig"/>
                    <h:inputText id="itdatEmbespon" title="N�mero de abortos espont�neos" onkeydown="return blockEnter(event);"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnabortesponta}" 
                                 style="width:30px" maxlength="1"/>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panelAbortoInducidos">
                  <h:panelGrid columns="1" id="panelDatosAntecedentesAborIn" rowClasses="labelText,labelTextInfo" rendered="#{antecedentesGinecologicosUsuarioBean.renderedAbortsprevios}">
                    <h:outputText value="Abortos Inducidos" styleClass="labelTextOblig"/>
                    <h:inputText id="itdatAboIndu" title="N�mero de abortos inducidos" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnabortinduc}"
                                 style="width:30px" maxlength="1"/>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panelAborSeguidos">
                  <h:panelGrid columns="1" id="panelAborSeguidosG" rendered="#{antecedentesGinecologicosUsuarioBean.renderedAbortspreviosTres}">
                    <h:outputText value="3 o m�s abortos seguidos" styleClass="labelTextOblig"/>
                    <h:selectOneRadio id="mnuAbortoSeguidos" immediate="true" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcabortseguido}">
                      <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                    </h:selectOneRadio>
                  </h:panelGrid>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <s:fieldset legend="Ciclos" id="fieldAntecedentesCiclos" styleClass="fieldset" rendered="#{antecedentesGinecologicosUsuarioBean.renderCiclos}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosTieneCiclos" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tipo de ciclo" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="radioTipoCiclo" immediate="true" required="false" value="#{antecedentesGinecologicosUsuarioBean.tipoCiclo}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setTipoCiclo}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstTipoCiclo}"/>
                  <a4j:support id="support" event="onchange" immediate="true" oncomplete="ciclosJs()" action="#{antecedentesGinecologicosUsuarioBean.changeTipo}" reRender="panelAntecedentesCiclos">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="radioTipoCiclo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGrid>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="panelDatosAntecedentesCiclos"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Frecuencia" rendered="#{!antecedentesGinecologicosUsuarioBean.cicloiregular}"
                              styleClass="labelTextOblig"/>
                <h:inputText id="itFrecuencia" onkeydown="return blockEnter(event);" required="false" maxlength="3"
                             value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnfreciclo}"
                             rendered="#{!antecedentesGinecologicosUsuarioBean.cicloiregular}" style="width:30px"/>
                <h:outputText value="Duraci�n" rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                              styleClass="labelTextOblig"/>
                <h:inputText id="itDuracion" onkeydown="return blockEnter(event);" required="false" maxlength="2"
                             rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                             value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagndurciclo}"
                             style="width:30px"/>
                <h:outputText value="Edad Menarquia" styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo || antecedentesGinecologicosUsuarioBean.renderMenarquia}"/>
                <h:inputText id="itEdadMenarquia" onkeydown="return blockEnter(event);" title="Edad Menarquia"
                             required="false" maxlength="2"
                             value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnmenarquia}"
                             rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo || antecedentesGinecologicosUsuarioBean.renderMenarquia}"
                             style="width:30px"/>
                 <h:panelGroup id="conoceFu">             
                <h:outputText value="�Conoce la fecha de la �ltima menstruaci�n?" styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderConocefun}"/>
                </h:panelGroup>
              <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuConoceFUM" immediate="true" onkeydown="return blockEnter(event);"  rendered="#{antecedentesGinecologicosUsuarioBean.renderConocefun}"
                                  value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcconoceufm}"
                                  valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcconoceufm}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supportConoceFUM" event="onclick" immediate="true"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeConoceFUM}"
                                   reRender="panelfurn,panelfurr">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuConoceFUM" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                </h:selectOneRadio>
                </a4j:region>
           </h:panelGroup>
                
                <h:panelGroup id="panelfurn">
                <h:outputText value="F.U.R Normal"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderMenarquia}"
                              title="Fecha Ultima Regla" styleClass="labelTextOblig"/>
                  </h:panelGroup>
               <h:panelGroup id="panelfurr">
                <t:inputCalendar id="calendarUltimaRegla" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.renderMenarquia}"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itFechaRegla}"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfur}"
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="false">
                  <f:validator validatorId="dateMenorIgualValidator"/>
                </t:inputCalendar>
                </h:panelGroup>
                
                <h:panelGroup>
                
                  <h:outputText value="Ciclos" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="D�a del Ciclo" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:panelGroup>
                  <h:inputText id="itCiclos" onkeydown="return blockEnter(event);" required="true" maxlength="10"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcciclos}"
                               rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}" style="width:100px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCiclos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itDiaCiclo" onkeydown="return blockEnter(event);" required="true" maxlength="2"
                               rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagndiacic}"
                               style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiaCiclo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:outputText value="Fecha Pen�ltima Regla"
                                rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                title="Fecha Pen�ltima Regla"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Fecha Antepen�ltima Regla"
                                rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                title="Fecha Antepen�ltima Regla"/>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:panelGroup>
                  <t:inputCalendar id="calendarPenultimaRegla" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                   binding="#{antecedentesGinecologicosUsuarioBean.itPenFechaRegla}"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfpur}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarPenultimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarAntepenultimaRegla" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                   binding="#{antecedentesGinecologicosUsuarioBean.itAntFechaRegla}"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfaur}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarAntepenultimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="Edad primera relaci�n"/>
                <h:panelGroup>
                  <h:outputText value="Fecha Ultimo Parto o Aborto"
                                rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"/>
                </h:panelGroup>
                <h:panelGroup id="inputPanelParto">
                  <h:outputText value="FUP � Aborto" title="Fecha Ultimo Parto"
                                rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaFUP}"/>
                </h:panelGroup>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itEdadPrimeraRelacion" onkeydown="return blockEnter(event);" maxlength="2"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnedadrelac}"
                               valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagnedadrelac}"
                               style="width:30px">
                    <a4j:support id="supportEdadPrimeraRelacion" event="onchange"
                                 action="#{antecedentesGinecologicosUsuarioBean.changeEdadPrimeraRelacion}"
                                 reRender="itEdadPrimeraRelacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itEdadPrimeraRelacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:selectOneRadio id="mnuTemperatura" immediate="true" required="true"
                                      value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcnoaplica}"
                                      rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"
                                      valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcnoaplica}">
                      <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                      <a4j:support id="supportTemperatura" event="onclick" immediate="true"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeFecha}"
                                   reRender="panelInputParto,inputPanelParto">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuTemperatura" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:selectOneRadio>
                  </a4j:region>
                </h:panelGroup>
                <h:panelGroup id="panelInputParto">
                  <t:inputCalendar id="calendarUltimoParto" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" immediate="true"
                                   disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfup}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" binding="#{antecedentesGinecologicosUsuarioBean.itFechaParto}"
                                   maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaFUP}">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimoParto" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText value="F.U.Citologia" title="Fecha Ultima Citologia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelResultadoCitologia">
                  <h:outputText value="Resultado" styleClass="labelTextOblig"
                                rendered="#{antecedentesGinecologicosUsuarioBean.renderResultado}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextHallazgos">
                  <h:outputText value="Cual? " rendered="#{antecedentesGinecologicosUsuarioBean.renderOtroResultado}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuUltimaCitologia" required="false" immediate="true"
                                     onkeydown="return blockEnter(event);"
                                     binding="#{antecedentesGinecologicosUsuarioBean.mnuUltima}"
                                     value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcultcitolo}"
                                     valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcultcitolo}">
                      <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstUltimaCitologia}"/>
                      <a4j:support id="supportUltimaCitologia" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeUltimaCitologia}"
                                   reRender="panelResultadoCitologia,panelMenuResul,panelTextHallazgos,panelInputHallazgos"
                                   immediate="true">
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
                    <h:selectOneMenu id="mnuResultadoGineco" required="false" immediate="true"
                                     onkeydown="return blockEnter(event);"
                                     rendered="#{antecedentesGinecologicosUsuarioBean.renderResultado}"
                                     binding="#{antecedentesGinecologicosUsuarioBean.mnuResultado}"
                                     value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcresulcitol}"
                                     valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcresulcitol}">
                      <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstResultado}"/>
                      <a4j:support id="supportResultadoUltimaCitologia" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeResultado}"
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
                  <h:inputText id="itOtrosHallazgos" maxlength="100" required="false"
                               onkeydown="return blockEnter(event);"
                               rendered="#{antecedentesGinecologicosUsuarioBean.renderOtroResultado}"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcotroresul}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itOtrosHallazgos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText value="Lactancia exclusiva actual?" styleClass="labelTextOblig"/>
                <h:outputText value="Ha tenido relaciones sexuales en los �ltimos 15 d�as?" styleClass="labelTextOblig"
                              rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve}"/>
                <h:outputText value=" " rendered="#{antecedentesGinecologicosUsuarioBean.esIlve}"/>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuLactancia" onkeydown="return blockEnter(event);"
                                    value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagclactaexclu}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuLactancia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve}">
                  <h:selectOneRadio id="mnuRelacionesSexuales" onkeydown="return blockEnter(event);"
                                    value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcrelacsexua}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuRelacionesSexuales" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" " rendered="#{antecedentesGinecologicosUsuarioBean.esIlve}"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Relaciones por Semana?" styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="A�os de Infertilidad" styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value=" " rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value=" " rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:panelGroup rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}">
                  <h:inputText id="itRelSemana" onkeydown="return blockEnter(event);" required="true" maxlength="10"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcrelsem}"
                               style="width:100px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itRelSemana" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}">
                  <h:inputText id="itAnoinf" onkeydown="return blockEnter(event);" required="true" maxlength="2"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnanoinf}"
                               style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itAnoinf" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" " rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value=" " rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value=" Planea embarazo en el lapso de este pr�ximo a�o? " styleClass="labelTextOblig"
                              rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve}"/>
                <h:outputText/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMetodoPlanificacionAnterior" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelPlaneaEmbarazo">
                  <h:selectOneRadio id="mnuPlaneaEmbarazo" rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve}"
                                    immediate="true" onkeydown="return blockEnter(event);" required="false"
                                    value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcplanemba}"
                                    valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcplanemba}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supporPlaneaEmbarazo" event="onchange" immediate="true"
                                 action="#{antecedentesGinecologicosUsuarioBean.changePlaneaEmbarazo}"
                                 reRender="panelPlaneaEmbarazo">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <h:outputText value="#{antecedentesGinecologicosUsuarioBean.msgplaneaembarazo}" style="color:blue"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPlaneaEmbarazo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="M�todo de Planificaci�n Actual"
                              rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"/>
                <h:panelGroup id="panelTextMetodo">
                  <h:outputText value="Cual? " rendered="#{antecedentesGinecologicosUsuarioBean.mostrarMetodo}"/>
                  <h:outputText value="Verifica uso correcto del m�todo?"
                                rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildoras}"/>
                  <h:outputText value="Fecha de la �ltima aplicaci�n"
                                rendered="#{antecedentesGinecologicosUsuarioBean.mostrarInyectable}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextPildoras">
                  <h:outputText value="Aclaraci�n Pildoras"
                                rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildorasSi}"/>
                  <h:outputText rendered="#{!antecedentesGinecologicosUsuarioBean.mostrarPildorasSi}"/>
                </h:panelGroup>
                <h:outputText/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMetodoPlanificacion" immediate="true"
                                   rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcmetodoplan}"
                                   onkeydown="return blockEnter(event);"
                                   valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcmetodoplan}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstMetodo}"/>
                    <a4j:support id="supporMetodoPlanificacion" event="onchange" immediate="true"
                                 action="#{antecedentesGinecologicosUsuarioBean.ChangeMetodo}"
                                 reRender="panelInputMetodo,panelTextMetodo,panelTextPildoras,panelInputPildoras">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup id="panelInputMetodo">
                  <h:inputText id="inputOtroMetodo" maxlength="50" onkeydown="return blockEnter(event);"
                               required="false" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarMetodo}"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcotrometodo}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtroMetodo" styleClass="errorMessage"
                               rendered="#{antecedentesGinecologicosUsuarioBean.mostrarMetodo}"/>
                  </a4j:outputPanel>
                  <h:selectOneRadio id="mnuMetodoPildoras" immediate="true" onkeydown="return blockEnter(event);"
                                    required="true" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildoras}"
                                    valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcpildouso}"
                                    value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcpildouso}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supporMetodoPildoras" event="onchange" immediate="true"
                                 action="#{antecedentesGinecologicosUsuarioBean.ChangePildoras}"
                                 reRender="panelTextPildoras,panelInputPildoras">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMetodoPildoras" styleClass="errorMessage"
                               rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildoras}"/>
                  </a4j:outputPanel>
                  <t:inputCalendar id="inputFechaMetodo" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" immediate="true"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" popupTodayString="Hoy" popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.mostrarInyectable}"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfeultiapl}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputFechaMetodo" styleClass="errorMessage"
                               rendered="#{antecedentesGinecologicosUsuarioBean.mostrarInyectable}"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelInputPildoras">
                  <h:inputTextarea id="inputMetodoPildoras" onkeydown="return blockEnter(event);" required="false"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildorasSi}"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcpildoobser}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtroMetodo" styleClass="errorMessage"
                               rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildorasSi}"/>
                  </a4j:outputPanel>
                  <h:outputText rendered="#{!antecedentesGinecologicosUsuarioBean.mostrarPildorasSi}"/>
                </h:panelGroup>
                <h:outputText/>
              </h:panelGrid>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="IVE " id="fieldMetodoPlanIVE" styleClass="fieldset" rendered="#{antecedentesGinecologicosUsuarioBean.renderedInterrupcion}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelMetodoPlan" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Al enterarse de este embarazo, �estaba usando alg�n m�todo para evitar el embarazo?"/>
              <a4j:region id="regionPlanIVE" renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuIVE" immediate="true" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcevitemba}"
                                    valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcevitemba}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                    <a4j:support id="supporIVE" event="onchange" immediate="true" action="#{antecedentesGinecologicosUsuarioBean.ChangeEvitaEmbarazo}"
                                 reRender="panelMetodoPlanIVE,panelVerificacion,panelAclaracion,panelMetodoPlanOtro,panelMetodoInyectable,panelMetodoPlanInyectable">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuIVE" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGrid columns="1">
              <h:panelGroup id="panelMetodoPlanIVE">
                <h:selectOneMenu id="mnuMetodoPlanificacionIVE" immediate="true" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcmetoevitemba}" onkeydown="return blockEnter(event);"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.metodoevitaEmbarazo}" valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcmetoevitemba}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstMetodo}"/>
                  <a4j:support id="supporMetodoPlanificacionIVE" event="onchange" immediate="true" action="#{antecedentesGinecologicosUsuarioBean.ChangeMetodoIve}"
                               reRender="panelMetodoPlanOtro,panelMetodoPlanInyectable,panelMetodoInyectable">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMetodoPlanificacionIVE" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              
              <h:panelGroup id="panelMetodoPlanOtro" >
             
                <h:outputText id="txtCualOtroMet" value="Cual?" rendered="#{antecedentesGinecologicosUsuarioBean.renderedMetodo}"/>
                <h:panelGroup rendered="#{antecedentesGinecologicosUsuarioBean.renderedMetodo}">
                  <h:inputText id="textOtroMetodo" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcevitotro}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textOtroMetodo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:panelGroup id="panelMetodoInyectable">
                <h:outputText id="txtFecultapl" value="Fecha de Ultima aplicaci�n"  rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaInyectable}"/>
               <t:inputCalendar id="inputFechaMetodoInyec" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" immediate="true"                                 
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"                                 
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="false"  
                                 rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaInyectable}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfeultiapl}"/>
                             
                 <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputFechaMetodoInyec" styleClass="errorMessage" 
                            rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaInyectable}"/>
                </a4j:outputPanel>
             </h:panelGroup>
              <h:panelGroup id="panelMetodoPlanInyectable" >
                <h:outputText id="txtAclaraMet" value="Aclaracion"  rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaInyectable}"/>
                <h:panelGroup>
                  <h:inputTextarea id="textOtroMetodoInyectable" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcevitotro}"  rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaInyectable}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textOtroMetodoInyectable" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              </h:panelGrid>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Observaciones" id="fieldObservacion" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosObservacion" rowClasses="labelText">
              <h:outputText value="Observaciones"/>
              <h:panelGroup>
                <h:inputTextarea id="textObservaciones" onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcobservacio}" style="width:600px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textObservaciones" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </s:fieldset>
        </a4j:region>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInf" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificarGinecologicos" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{antecedentesGinecologicosUsuarioBean.aceptar}">
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