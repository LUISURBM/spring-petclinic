<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>

 
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAntecedentesGinecologicos" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    
    <t:panelTab id="panelTabAntecedentesGinecologicos" label="Antecedentes Ginecologicos">
    <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajes1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInf1" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="tableContentTabsAntecedentes">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Embarazos" id="fieldAntecedentes" styleClass="fieldset">
            <a4j:region id="regionAntecedentes" renderRegionOnly="false">
              <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosAntecedentes" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Gestaciones" styleClass="labelTextOblig"/>
                <h:outputText value="Partos" styleClass="labelTextOblig"/>
                <h:outputText value="Abortos" styleClass="labelTextOblig"/>
                <h:outputText value="Cesareas" styleClass="labelTextOblig"/>
                <h:outputText value="Hijos Nacidos Vivos" styleClass="labelTextOblig"/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:inputText id="itNumGesta" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumGesta}"
                                 required="false"
                                 title="Numero de Gestaciones" maxlength="2" style="width:30px"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumgesta}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroGestaciones}">
                      <a4j:support id="supportNumGesta" event="onchange" oncomplete="jsFunction()"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeNumeroGestaciones}"
                                   reRender="panelInputPartos,panelInputAbortos,panelInputCesareas,panelInputVivos,panelInputEctopicos,panelInputMuertos,panelInputMortinatos,panelCursor,panelInputParto,panelInputHijosNacidosVivos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumGesta" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                  <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelInputPartos">
                  <h:panelGroup>
                    <h:inputText id="itNumPartos" onkeydown="return blockEnter(event);"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumPartos}"
                                 required="false"
                                 title="Numero de Partos" immediate="true"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumparto}"
                                 maxlength="2"
                                 style="width:30px">
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumPartos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
               
                </a4j:region>
                <h:panelGroup id="panelInputAbortos">
                  <h:panelGroup>
                    <h:inputText id="itNumAbortos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumAbortos}"
                                 required="false"
                                 title="Numero de Abortos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumaborto}">
                     
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumAbortos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputCesareas">
                  <h:panelGroup>
                    <h:inputText id="itNumcesareas" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumcesareas}"
                                 required="false"
                                 title="Numero de Cesareas" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroCesarias}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumcesare}">
                                 
                                 <a4j:support id="supportNumCesareas" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeNumeroCesarias}"
                                   reRender="panelInputCesareas">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                      </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumcesareas" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                     
                     
                <h:panelGroup id="panelInputHijosNacidosVivos">
                  <h:panelGroup>
                    <h:inputText id="itNumHijoNacidoVivo" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumNacidosVivos}"
                                 required="false"
                                 title="Numero de Hijos Nacidos Vivos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnacivivo}"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijoNacidoVivo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:outputText value="Hijos Vivos " styleClass="labelTextOblig"/>
                <h:outputText value="Ectopicos   " styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderEctopicos}"/>
                <h:outputText value="Mortinatos  " styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderMortinatos}"/>
                <h:outputText value="Molas       " styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderMolas}"/>
                <h:outputText/>
                <h:outputText value="  " rendered="#{!antecedentesGinecologicosUsuarioBean.renderEctopicos}"/>
                <h:outputText value="  " rendered="#{!antecedentesGinecologicosUsuarioBean.renderMortinatos}"/>
                <h:outputText value="  " rendered="#{!antecedentesGinecologicosUsuarioBean.renderMolas}"/>
                <h:panelGroup id="panelInputVivos">
                  <h:panelGroup>
                    <h:inputText id="itNumHijosVivos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumHijosVivos}"
                                 required="false"
                                 title="Numero de Hijos Vivos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumvivo}"></h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijosVivos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputEctopicos"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderEctopicos}">
                  <h:panelGroup>
                    <h:inputText id="itNumEctopicos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumEctopicos}" required="false"
                                 title="Numero de Ectopicos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroEctopicos}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnectopico}">
                      <a4j:support id="supportNumEctopicos" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeNumeroEctopicos}"
                                   reRender="panelInputEctopicos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumEctopicos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputMortinatos"
                              rendered="#{antecedentesGinecologicosUsuarioBean.renderMortinatos}">
                  <h:panelGroup>
                    <h:inputText id="itNumHijosMortinatos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumHijosMortinatos}" required="false"
                                 title="Numero de Mortinatos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroMortinatos}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnmortina}">
                      <a4j:support id="supportNumMortinatos" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeNumeroMortinatos}"
                                   reRender="panelInputMortinatos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijosMortinatos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup id="panelInputMuertos" rendered="#{antecedentesGinecologicosUsuarioBean.renderMolas}">
                  <h:panelGroup>
                    <h:inputText id="itNumHijosMuertos" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itNumHijosMuertos}" required="false"
                                 title="Numero de Hijos Muertos" maxlength="2" style="width:30px"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setNumeroMolas}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnmuerto}">
                      <a4j:support id="supportNumMolas" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeNumeroMolas}"
                                   reRender="panelInputMuertos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNumHijosMuertos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                  <h:outputText/>
               
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
         
         
           <s:fieldset legend="Paridad" id="fieldParidad" styleClass ="fieldset" rendered="#{antecedentesGinecologicosUsuarioBean.renderedInterrupcion}" >
           <a4j:region id="regionAntecedentesParidad" renderRegionOnly="false">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosAntecedentesParidad" rowClasses="labelText,labelTextInfo">
                  <h:panelGroup>
                 <h:outputText value="Embarazo actual planeado" styleClass="labelTextOblig"/>
                     
                 <h:selectOneRadio id="mnuParidad"
                                immediate="true"
                                onkeydown="return blockEnter(event);"
                                value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcembplan}">
                   <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                 
                </h:selectOneRadio>
                 </h:panelGroup>
                 
                  <h:panelGroup>
                  <h:panelGrid columns="1" id="panelEmbarazosmul">
                     <h:outputText value="Embarazos múltiples" styleClass="labelTextOblig"/>
                     
                     <h:inputText id="itdatEmbMulti" title="Numero embarazos Multiples"
                             onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnnumembmulti}"
                             style="width:30px" maxlength="1"/>
                  </h:panelGrid>
                </h:panelGroup>
               
                 <h:panelGroup>
                  <h:panelGrid columns="1" id="panelEmbarazosprev">
           
                     <h:outputText value="Número de Abortos Previos" styleClass="labelTextOblig"/>
                     <a4j:region renderRegionOnly="false">
                     <h:inputText id="itdatEmbprev" onkeydown="return blockEnter(event);" immediate="true"
                                 binding="#{antecedentesGinecologicosUsuarioBean.itAbortosPrevios}"
                                 required="false"
                                 title="Abortos Previos" maxlength="1" style="width:30px"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnabortoprevio}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setAbortosPrevios}">
                      <a4j:support id="supportEmbprev" event="onchange"
                                   action="#{antecedentesGinecologicosUsuarioBean.changeNumeroAbortoPrevios}"
                                   reRender="panelEmbarazosespon,panelAbortoInducidos,panelAborSeguidos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:inputText>
                   
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itdatEmbprev" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </h:panelGroup>
               
                <h:panelGroup id="panelEmbarazosespon">
                  <h:panelGrid columns="1" id="panelEmbespon"  rendered="#{antecedentesGinecologicosUsuarioBean.renderedAbortsprevios}">
                     <h:outputText value="Número de abortos espontáneos" styleClass="labelTextOblig"/>
                     
                     <h:inputText id="itdatEmbespon" title="Número de abortos espontáneos"
                             onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnabortesponta}"
                             style="width:30px" maxlength="1"/>
                  </h:panelGrid>
                </h:panelGroup>
               
                <h:panelGroup id="panelAbortoInducidos" >
                  <h:panelGrid columns="1" id="panelAbortoIndu" rendered="#{antecedentesGinecologicosUsuarioBean.renderedAbortsprevios}">
                     <h:outputText value="Número de abortos inducidos" styleClass="labelTextOblig"/>
                     
                     <h:inputText id="itdatAboIndu" title="Número de abortos inducidos"
                             onkeydown="return blockEnter(event);" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnabortinduc}"
                             style="width:30px" maxlength="1"/>
                  </h:panelGrid>
                </h:panelGroup>
               
                 <h:panelGroup id="panelAborSeguidos">
                  <h:panelGrid columns="1" id="panelAborSeguidosG" rendered="#{antecedentesGinecologicosUsuarioBean.renderedAbortspreviosTres}">
                     <h:outputText value="3 o más abortos seguidos" styleClass="labelTextOblig"/>
                     
                      <h:selectOneRadio id="mnuAbortoSeguidos"
                                immediate="true"
                                onkeydown="return blockEnter(event);"
                                value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcabortseguido}">
                   <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                 
                </h:selectOneRadio>
                    </h:panelGrid>
                </h:panelGroup>
               
                <h:panelGroup>
                    <h:panelGrid columns="4" id="fechapartoAborto">
                        <h:panelGroup>
                            <h:outputText value="Fecha de último parto o aborto" styleClass="labelTextOblig"/>
                            <h:selectOneRadio id="mnuFechaAborto" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                  valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcfechaabopar}"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcfeabopar}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                  <a4j:support id="suppoFechaAborto" event="onchange" immediate="true"
                               action="#{antecedentesGinecologicosUsuarioBean.ChangeFechaAborParto}"
                               reRender="panelGroupFechaAbort,panelAborPart">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                        </h:panelGroup>
                       
                    </h:panelGrid>
                    </h:panelGroup>
               
                 <h:panelGroup id="panelGroupFechaAbort">
                 <h:panelGrid columns="1" id="panelFechaAbort" rendered="#{antecedentesGinecologicosUsuarioBean.renderedfechaAbortparto}">
                 <h:outputText value="Fecha de último parto/Aborto" styleClass="labelTextOblig"/>
                  <t:inputCalendar id="calendarfechaAbort" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   binding="#{antecedentesGinecologicosUsuarioBean.itFechaAbortoParto}"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfecultabopar}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarfechaAbort" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  </h:panelGrid>
                </h:panelGroup>
               
                <h:panelGroup id="panelAborPart">
                <h:panelGrid columns="1" id="panelGAbortoParto" rendered="#{antecedentesGinecologicosUsuarioBean.renderedfechaAbortparto}">
                <h:outputText value="Peso RN" styleClass="labelTextOblig"/>
                <h:selectOneMenu id="mnuAbortoParto" immediate="true" required="false"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcpesorn}"
                                 onkeydown="return blockEnter(event);">
                      <f:selectItem itemLabel="No sabe" itemValue="No sabe"/>
                      <f:selectItem itemLabel="Menor de 2.500 g" itemValue="Menor de 2.500 g"/>
                      <f:selectItem itemLabel="2.500 a 4.000 g" itemValue="2.500 a 4.000 g"/>
                      <f:selectItem itemLabel="Mayor de 4.000 g" itemValue="Mayor de 4.000 g"/>
                 </h:selectOneMenu>
                 </h:panelGrid>
                </h:panelGroup>
            </h:panelGrid>
      </a4j:region>      
      </s:fieldset>
           
           
          <s:fieldset legend="Ciclos" id="fieldAntecedentesCiclos" styleClass="fieldset"
                      rendered="#{antecedentesGinecologicosUsuarioBean.renderCiclos}">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosTieneCiclos"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tipo de ciclo" styleClass="labelTextOblig"/>
              <a4j:region renderRegionOnly="false">
                <h:selectOneMenu id="radioTipoCiclo" immediate="true"
                                 required="false"
                                 value="#{antecedentesGinecologicosUsuarioBean.tipoCiclo}"
                                 valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setTipoCiclo}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstTipoCiclo}"/>
                  <a4j:support id="support" event="onchange" immediate="true" oncomplete="ciclosJs()"
                               action="#{antecedentesGinecologicosUsuarioBean.changeTipo}"
                               reRender="panelAntecedentesCiclos">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="radioTipoCiclo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosAntecedentesCiclos" rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Frecuencia" rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Duración" rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itFrecuencia" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="3"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnfreciclo}"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo}" 
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuencia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="-" rendered="#{antecedentesGinecologicosUsuarioBean.cicloiregular}"/>
                  <h:panelGroup>
                    <h:inputText id="itFrecuenciaFinal" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="3"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.cicloiregular && antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnfrefincicl}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itFrecuenciaFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itDuracion" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="2"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagndurciclo}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDuracion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="-" rendered="#{antecedentesGinecologicosUsuarioBean.cicloiregular}"/>
                  <h:panelGroup>
                    <h:inputText id="itDuracionFinal" onkeydown="return blockEnter(event);"
                                 required="false" maxlength="2"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.cicloiregular && antecedentesGinecologicosUsuarioBean.tieneCiclo}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagndurfincicl}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDuracionFinal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
               
               
               
                <h:panelGroup>
                  <h:outputText value="Ciclos" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Día del Ciclo" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:panelGroup>
                    <h:inputText id="itCiclos" onkeydown="return blockEnter(event);"
                                 required="true" maxlength="10"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcciclos}"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}" style="width:100px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itCiclos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                    <h:inputText id="itDiaCiclo" onkeydown="return blockEnter(event);"
                                 required="true" maxlength="2"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagndiacic}"
                                 style="width:30px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDiaCiclo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>


               
                <h:panelGroup>
                  <h:outputText value="Edad Menarquia" styleClass="labelTextOblig"
                                rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo || antecedentesGinecologicosUsuarioBean.renderMenarquia}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="F.U.R Normal"
                                rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo || antecedentesGinecologicosUsuarioBean.renderMenarquia}"
                                title="Fecha Ultima Regla" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:panelGroup>
                  <h:inputText id="itEdadMenarquia" onkeydown="return blockEnter(event);" title="Edad Menarquia"
                               required="false" maxlength="2"
                               value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnmenarquia}"
                               rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo || antecedentesGinecologicosUsuarioBean.renderMenarquia}"
                               style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itEdadMenarquia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaRegla" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.tieneCiclo || antecedentesGinecologicosUsuarioBean.renderMenarquia}"
                                   binding="#{antecedentesGinecologicosUsuarioBean.itFechaRegla}"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfur}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>



                <h:panelGroup>
                  <h:outputText value="Fecha Penúltima Regla"
                                rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                title="Fecha Penúltima Regla"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Fecha Antepenúltima Regla"
                                rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                title="Fecha Antepenúltima Regla"/>
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
                                   renderPopupButtonAsImage="true" align="top"
                                   required="false">
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
                                   renderPopupButtonAsImage="true" align="top"
                                   required="false">
                    <f:validator validatorId="dateMenorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarAntepenultimaRegla" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
                <h:outputText value="" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>



               
              <h:outputText value="Edad primera relación"/>
           <h:panelGroup>
              <h:outputText value="Fecha Ultimo Parto o Aborto" rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"/>
            </h:panelGroup>
             
                 <h:panelGroup id="inputPanelParto">
              <h:outputText value="FUP ó Aborto" title="Fecha Ultimo Parto" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaFUP}"/>
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
     <h:panelGroup id="panelInputParto" >
                <t:inputCalendar id="calendarUltimoParto" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" immediate="true"
                                 disabled="#{antecedentesGinecologicosUsuarioBean.esCeroGestaciones}"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfup}"
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" binding="#{antecedentesGinecologicosUsuarioBean.itFechaParto}"
                                 maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="false" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarFechaFUP}">
                  <f:validator validatorId="dateMenorIgualValidator"/>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarUltimoParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
                <h:outputText/>
               
                <h:outputText value="F.U.Citologia" title="Fecha Ultima Citologia"/>
                <h:panelGroup id = "panelResultadoCitologia">
                <h:outputText value = "Resultado" styleClass="labelTextOblig" rendered="#{antecedentesGinecologicosUsuarioBean.renderResultado}"/>
                </h:panelGroup>
                <h:panelGroup id = "panelTextHallazgos">
                <h:outputText value="Cual? "  rendered="#{antecedentesGinecologicosUsuarioBean.renderOtroResultado}" styleClass="labelTextOblig" />
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
               <h:panelGroup>
              <h:outputText value = "Lactancia exclusiva actual?" rendered="#{!antecedentesGinecologicosUsuarioBean.esFertilidad}" styleClass="labelTextOblig"/>
               </h:panelGroup>
               <h:panelGroup>
               <h:outputText value = "Ha tenido relaciones sexuales en los últimos 15 días?" styleClass="labelTextOblig"
                             rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve && !antecedentesGinecologicosUsuarioBean.esFertilidad && !antecedentesGinecologicosUsuarioBean.esAnticoncepcionTemporal}" />
                </h:panelGroup>
               <h:outputText value = " " rendered="#{antecedentesGinecologicosUsuarioBean.esIlve}"/>
               <h:outputText/>
               <h:outputText/>
               
               <h:panelGroup>
                <h:selectOneRadio id="mnuLactancia" rendered="#{!antecedentesGinecologicosUsuarioBean.esFertilidad}"
                                  onkeydown="return blockEnter(event);"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagclactaexclu}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuLactancia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                </h:panelGroup>
               
               <h:panelGroup rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve}">
                  <h:selectOneRadio id="mnuRelacionesSexuales" rendered="#{!antecedentesGinecologicosUsuarioBean.esFertilidad && !antecedentesGinecologicosUsuarioBean.esAnticoncepcionTemporal}"
                                  onkeydown="return blockEnter(event);"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcrelacsexua}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuRelacionesSexuales" styleClass="errorMessage"/>
                </a4j:outputPanel>
                </h:panelGroup>
               <h:outputText value = " " rendered="#{antecedentesGinecologicosUsuarioBean.esIlve}"/>
                <h:outputText/>
                <h:outputText/>
     
     
     
              <h:outputText value = "Relaciones por Semana?" styleClass="labelTextOblig"
                            rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
              <h:outputText value = "Tiempo de Infertilidad" styleClass="labelTextOblig"
                            rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
            <h:outputText value = "Unidad de Medida" styleClass="labelTextOblig"
                            rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
              <h:outputText value = " " rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>               
              <h:panelGroup rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}" >
                 <h:inputText id="itRelSemana" onkeydown="return blockEnter(event);"
                            required="true" maxlength="10"
                            value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcrelsem}"
                            style="width:100px"/>
                 <a4j:outputPanel ajaxRendered="true">
                     <t:message for="itRelSemana" styleClass="errorMessage"/>
                 </a4j:outputPanel>
              </h:panelGroup>
               
           
                 <h:panelGroup>
                  <h:inputText id="itAnoinf" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"  onkeydown="return blockEnter(event);" required="true" maxlength="2" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagnanoinf}"
                               style="width:30px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itAnoinf" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                <h:selectOneMenu id="uniMed" rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}" immediate="true"  required="true" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcunimed}"
                                 >
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstUniMedFertilidad}"/>   
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="uniMed" styleClass="errorMessage"/>
                </a4j:outputPanel>
                </h:panelGroup>
              <h:outputText value = " " rendered="#{antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
               <h:outputText value = "Ha usado algún método de planificación familiar con anterioridad ?" styleClass="labelTextOblig"/>
               <h:outputText value = ""/>
               <h:panelGroup >
               <h:outputText value = " Planea embarazo en el lapso de este próximo año? "   styleClass="labelTextOblig"
                            rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve && !antecedentesGinecologicosUsuarioBean.esFertilidad}"/>
               </h:panelGroup>
               <h:outputText/>
               
               <h:panelGroup>
                <h:selectOneRadio id="mnuMetodoPlanificacionAnterior"
                                  onkeydown="return blockEnter(event);" required="false"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcmetodanter}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                </h:selectOneRadio>
                 
                </h:panelGroup>
               
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMetodoPlanificacionAnterior" styleClass="errorMessage"/>
                </a4j:outputPanel>
                 <h:panelGroup id = "panelPlaneaEmbarazo">
                <h:selectOneRadio id="mnuPlaneaEmbarazo"
                rendered="#{!antecedentesGinecologicosUsuarioBean.esIlve && !antecedentesGinecologicosUsuarioBean.esFertilidad}" immediate="true"
                                  onkeydown="return blockEnter(event);" required="false"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcplanemba}"
                                   valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcplanemba}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                     <a4j:support id="supporPlaneaEmbarazo" event="onchange" immediate="true"
                               action="#{antecedentesGinecologicosUsuarioBean.changePlaneaEmbarazo}"
                               reRender="panelPlaneaEmbarazo">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                 
                </h:selectOneRadio>
               <h:outputText value = "#{antecedentesGinecologicosUsuarioBean.msgplaneaembarazo}" style = "color:blue"/>
                </h:panelGroup>
               
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPlaneaEmbarazo" styleClass="errorMessage"/>
                </a4j:outputPanel>
             
             
               
                 <h:outputText value="Método de Planificación Actual" rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"/>
              <h:panelGroup id="panelTextMetodo">
                <h:outputText value="Cual? " rendered="#{antecedentesGinecologicosUsuarioBean.mostrarMetodo}"/>
                <h:outputText value="Verifica uso correcto del método?" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildoras}"/>
                <h:outputText value="Fecha de la última aplicación" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarInyectable}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextPildoras">
                 <h:outputText value="Aclaración Pildoras" rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildorasSi}"/>
               
              </h:panelGroup>
              <h:outputText/>
               
             
             
                <h:panelGroup>
                <h:selectOneMenu id="mnuMetodoPlanificacion" immediate="true" rendered="#{!antecedentesGinecologicosUsuarioBean.renderedInterrupcion}"
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
                             required="false"
                             rendered="#{antecedentesGinecologicosUsuarioBean.mostrarMetodo}"
                             value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcotrometodo}"/>
                             
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputOtroMetodo" styleClass="errorMessage"
                        rendered="#{antecedentesGinecologicosUsuarioBean.mostrarMetodo}"/>
                </a4j:outputPanel>

                <h:selectOneRadio id="mnuMetodoPildoras" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                  rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPildoras}"
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
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"                                
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="false"  
                                 rendered="#{antecedentesGinecologicosUsuarioBean.mostrarInyectable}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfeultiapl}"/>
                             
                              <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputFechaMetodo" styleClass="errorMessage"
                            rendered="#{antecedentesGinecologicosUsuarioBean.mostrarInyectable}"/>
                </a4j:outputPanel>
              </h:panelGroup>
             
              <h:panelGroup id="panelInputPildoras">
                <h:inputTextarea id="inputMetodoPildoras" onkeydown="return blockEnter(event);"
                             required="false"
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
         
           <s:fieldset legend="IVE " id="fieldMetodoPlanIVE" styleClass="fieldset"  rendered="#{antecedentesGinecologicosUsuarioBean.renderedInterrupcion}" >
           
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelMetodoPlan" rowClasses="labelText,labelTextInfo">
                           
                 <h:outputText value="Al enterarse de este embarazo, ¿estaba usando algún método para evitar el embarazo?" />
                  <a4j:region id="regionPlanIVE" renderRegionOnly="false">
                  <h:panelGroup>
                <h:selectOneRadio id="mnuIVE"
                                immediate="true"
                                onkeydown="return blockEnter(event);"
                                value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcevitemba}"
                                valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcevitemba}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supporIVE" event="onchange" immediate="true"
                               action="#{antecedentesGinecologicosUsuarioBean.ChangeEvitaEmbarazo}"
                               reRender="panelMetodoPlanIVE,panelVerificacion,panelAclaracion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuIVE" styleClass="errorMessage"/>
                </a4j:outputPanel>
                </h:panelGroup>
                </a4j:region>
             <h:panelGroup id="panelMetodoPlanIVE" >
                <h:selectOneMenu id="mnuMetodoPlanificacionIVE" immediate="true"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcmetoevitemba}"
                                 onkeydown="return blockEnter(event);"
                                 rendered="#{antecedentesGinecologicosUsuarioBean.metodoevitaEmbarazo}"
                                valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagcmetoevitemba}">
                   <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstMetodo}"/>
                  <a4j:support id="supporMetodoPlanificacionIVE" event="onchange" immediate="true"
                               action="#{antecedentesGinecologicosUsuarioBean.ChangeMetodoIve}"  
                               reRender="panelMetodoPlanOtro,panelVerificacion,panelAclaracion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                </h:panelGroup>
              <h:panelGroup id="panelMetodoPlanOtro" >  
              <h:outputText id="txtCualOtroMet" value="Cual?" rendered="#{antecedentesGinecologicosUsuarioBean.renderedMetodo}"/>
              <h:panelGroup>
                <h:inputText id="textOtroMetodo" onkeydown="return blockEnter(event);" rendered="#{antecedentesGinecologicosUsuarioBean.renderedMetodo}"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcevitotro}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textOtroMetodo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
           </h:panelGroup>
           <h:panelGroup id="panelVerificacion" >  
               <h:outputText value="verifica el uso correcto del método?" rendered="#{antecedentesGinecologicosUsuarioBean.renderedUsoCorrectoMetodoIve}" />
                <h:selectOneRadio id="mnuMetodoIVE" immediate="true"
                                  onkeydown="return blockEnter(event);" required="true"
                                   rendered="#{antecedentesGinecologicosUsuarioBean.renderedUsoCorrectoMetodoIve}"
                                  valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setHagceviembusomet}"
                                   value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagceviembusomet}">
                  <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                  <a4j:support id="supporMetodoIVE" event="onchange" immediate="true"
                               action="#{antecedentesGinecologicosUsuarioBean.ChangeVerificacion}"
                               reRender="panelAclaracion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <h:panelGroup id="panelAclaracion" >
                 <h:outputText id="panelTextAclaracion" value="Aclaración"  rendered="#{antecedentesGinecologicosUsuarioBean.renderedaclaracion}"/>
                <h:inputTextarea id="inputMetodoIVE" onkeydown="return blockEnter(event);"
                             required="false"
                             rendered="#{antecedentesGinecologicosUsuarioBean.renderedaclaracion}"
                             value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcbusometobs}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputMetodoIVE" styleClass="errorMessage"
                             rendered="#{antecedentesGinecologicosUsuarioBean.renderedaclaracion}"/>
                </a4j:outputPanel>
                </h:panelGroup>
             </h:panelGroup>
              </h:panelGrid>
         
          </s:fieldset>
              <s:fieldset rendered="#{antecedentesGinecologicosUsuarioBean.renderPruebaEmbarazo}" styleClass="fieldset" legend="PRUEBA DE EMBARAZO EN ORINA sensible a 10 mUI/mL de HCG" >
                <h:panelGrid columns="8">
 
 
                
                  <h:outputText value="Se realizo prueba de embarazo? " styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextPruebaEmb">
                    <h:outputText value="Fecha de la Toma" styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPruebaEmb}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextResPruebaEmb">
                    <h:outputText value="Resultado Prueba: " styleClass="labelTextOblig"
                              rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPruebaEmb}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuPruebaEmb" required="true" immediate="true"
                                  value="#{antecedentesGinecologicosUsuarioBean.pruebaEmbarazo}"
                                  binding="#{antecedentesGinecologicosUsuarioBean.pruebaEmb}"
                                  valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setPruebaEmbarazo}">
                     <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpciones}"/>
                     <a4j:support id="supportmnuPruebaEmb" event="onclick" immediate="true"
                                  action="#{antecedentesGinecologicosUsuarioBean.changePruebaEmb}"
                                  reRender="panelTextPruebaEmb,panelTextResPruebaEmb,panelTextFechaPrueba,panelTextResPrueba">
                       <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                     </a4j:support>
                  </h:selectOneRadio>
                  </a4j:region>
                  <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuPruebaEmb" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextFechaPrueba">
                  <h:panelGrid columns="2">
                    <t:inputCalendar id="fechaInicialPrueba" required="true" monthYearRowClass="yearMonthHeader"
                                     title="Formato: dd/mm/yyyy" styleClass="input-small" weekRowClass="weekHeader"
                                     currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                     renderAsPopup="true" value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagdfecpruemb}"
                                     valueChangeListener="#{antecedentesGinecologicosUsuarioBean.setFechaActual}"
                                     popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                     readonly="false" maxlength="11" size="11"
                                     popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                     renderPopupButtonAsImage="true" align="top"
                                     rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPruebaEmb}">
                      <f:validator validatorId="dateValidatorEmbarazoCirugia"/>
                      <a4j:support id="supportFechaInicialPrueba" event="onchange" reRender="panelTextFechaPrueba">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </t:inputCalendar>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="fechaInicialPrueba" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextResPrueba">
                  <h:selectOneRadio id="mnuResultadoPrueba" required="true" immediate="true"
                                    value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcrespruemb}"
                                    rendered="#{antecedentesGinecologicosUsuarioBean.mostrarPruebaEmb}">
                    <f:selectItems value="#{antecedentesGinecologicosUsuarioBean.lstOpcionesEmbarazo}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="supportmnuResultadoPrueba" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
              </s:fieldset>
          <s:fieldset legend="Observaciones" id="fieldObservacion" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosObservacion"
                         rowClasses="labelText">
              <h:outputText value="Observaciones"/>
              <h:panelGroup>
                <h:inputTextarea id="textObservaciones" onkeydown="return blockEnter(event);"
                                 value="#{antecedentesGinecologicosUsuarioBean.antecedente.hagcobservacio}"
                                 style="width:600px"/>
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
            <t:messages id="msgInf" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
     
      </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonModificarGinecologicos" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                             action="#{antecedentesGinecologicosUsuarioBean.aceptar}">
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