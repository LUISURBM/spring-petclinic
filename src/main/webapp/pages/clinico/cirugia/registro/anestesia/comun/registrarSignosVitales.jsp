<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarSignosVitalesTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneRegistrarSignosVitales" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
   
    <t:panelTab id="panelTabRegistrarSignosVitales" label="Registrar Signos Vitales ">
    
      <h:panelGrid>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionCanalizacionMsg1" ajaxRendered="true">
        <t:messages id="msgInformationCanalizacionMsg1" showSummary="true" errorClass="error" globalOnly="true"
                    layout="table" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
  
  
    <s:fieldset legend="Hora Ingreso" id="fieldAntecedentesMama" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridSignosVitalesAnestesiaHoraIngreso" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Fecha Inicio Actividades" styleClass="labelTextOblig"/>
            <h:outputText value="Hora Inicio Actividades" styleClass="labelTextOblig"/>
            <h:panelGroup>
            <h:outputText value="Desea cambiar la hora de Inicio Actividades" styleClass="labelTextOblig"
                    rendered="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"/>
            </h:panelGroup>
            <h:panelGroup id="panelFechaActividad">
              <t:inputCalendar id="fechaActividad" onkeydown="return blockEnter(event);"
                               disabled="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"
                               monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" immediate="true"
                               title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                               popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{registrarSignosVitalesAnestesiaBean.fechaInicio}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top" required="true"></t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaActividad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelHoraActividad">
              <h:panelGroup>
                <h:selectOneMenu id="mnuHoraCirugia1" required="true" style="width:60px"
                                 disabled="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"
                                 immediate="true" value="#{registrarSignosVitalesAnestesiaBean.horaSelect}">
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.listHora}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuHoraCirugia1" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Horas" />
              </h:panelGroup>
              <h:outputText value=" : "/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuMinutosCirugia1" required="true" style="width:60px"
                                 disabled="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"
                                 immediate="true" value="#{registrarSignosVitalesAnestesiaBean.minutoSelect}">
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstMinutos}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMinutosCirugia1" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Minutos" />
              </h:panelGroup>
            </h:panelGroup>
            
              <h:panelGroup>
              <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id = "menuCambiarHora" 
                                    value = "#{registrarSignosVitalesAnestesiaBean.modificarHoraInicial}"
                                   rendered="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"
                                  immediate="true"
                                  valueChangeListener="#{registrarSignosVitalesAnestesiaBean.setModificarHoraInicial}">
                                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstOpciones}"/>
                  <a4j:support id="supportMenuCambiarHora" event="onclick"
                               action="#{registrarSignosVitalesAnestesiaBean.changeHoraSignos}"
                               reRender="panelInputHoraNueva,panelTextHoraNueva,panelBotonCambiar">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                  </h:selectOneRadio>
                  </a4j:region>
            </h:panelGroup>
            
             <h:outputText/>
            <h:panelGroup id = "panelTextHoraNueva">
            <h:outputText value="Nueva Hora Inicio Actividades" styleClass="labelTextOblig"
            rendered="#{registrarSignosVitalesAnestesiaBean.renderHoraNueva}"/>
            </h:panelGroup>
             <h:outputText/>
             
              <h:outputText/>
              <h:panelGroup id = "panelInputHoraNueva">
               
                 <h:panelGroup>
                <h:selectOneMenu id="mnuNuevaHoraCirugia" required="true" style="width:60px" immediate="true"
                                  rendered="#{registrarSignosVitalesAnestesiaBean.renderHoraNueva}"
                                   value="#{registrarSignosVitalesAnestesiaBean.horaNuevaSelect}"
                                   valueChangeListener="#{registrarSignosVitalesAnestesiaBean.setHoraNuevaSelect}">
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.listHora}"/>
                  <a4j:support id="supportNuevaHora" event="onclick">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuNuevaHoraCirugia" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Horas"  rendered="#{registrarSignosVitalesAnestesiaBean.renderHoraNueva}" />
              </h:panelGroup>
              <h:outputText value=" : "/>
              <h:panelGroup>
                <h:selectOneMenu id="mnuNuevoMinutos" required="true" style="width:60px"  immediate="true"
                                value="#{registrarSignosVitalesAnestesiaBean.minutoNuevoSelect}"
                                 rendered="#{registrarSignosVitalesAnestesiaBean.renderHoraNueva}"
                                 valueChangeListener="#{registrarSignosVitalesAnestesiaBean.setMinutoNuevoSelect}"
                                 >
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstMinutos}"/>
                   <a4j:support id="supportNuevosMinutos" event="onclick">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuNuevoMinutos" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Minutos"  rendered="#{registrarSignosVitalesAnestesiaBean.renderHoraNueva}"/>
              </h:panelGroup>
                  </h:panelGroup>
                
                <h:panelGroup id = "panelBotonCambiar">
                <a4j:region renderRegionOnly="false">
                     <a4j:commandButton id="commandModificar" value="Modificar Hora" 
                               styleClass="btn btn btn-info" immediate="true"
                               rendered="#{registrarSignosVitalesAnestesiaBean.renderHoraNueva}"
                               reRender="panelTabRegistrarSignosVitales"
                                onclick="if(!confirm(\'Esta seguro de Modificar la hora de Inicio, esta modificara la hora de todos los registros de Signos Vitales?\')){ return false; }"
                               action="#{registrarSignosVitalesAnestesiaBean.modificarHora}"/>
                            </a4j:region>
              </h:panelGroup>
  
          </h:panelGrid>
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridIntervalosSignosVitales" rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Intervalo" styleClass="labelTextOblig"
                            rendered="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"/>
            </h:panelGroup>
            <h:panelGroup id="itPanelTextTiempoIntervalo">
              <h:outputText value="Tiempo Intervalo"
                            rendered="#{registrarSignosVitalesAnestesiaBean.mostrarIntervalo}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:panelGroup id="mnuRadioIntervalo">
              <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuIntervalo" required="true" layout="lineDirection"
                                  value="#{registrarSignosVitalesAnestesiaBean.intervaloselect}"
                                  rendered="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}"
                                  immediate="true"
                                  valueChangeListener="#{registrarSignosVitalesAnestesiaBean.setIntervaloselect}">
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstIntervalo}"/>
                  <a4j:support id="supportmnuIntervalo" event="onclick"
                               action="#{registrarSignosVitalesAnestesiaBean.ChangeTipoIntervalo}"
                               reRender="panelmnuTiempoIntervalo,itPanelTextTiempoIntervalo">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuIntervalo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </a4j:region>
            </h:panelGroup>
            <h:panelGroup id="panelmnuTiempoIntervalo">
              <h:selectOneRadio id="mnuTiempoIntervalo" required="true" layout="lineDirection"
                               rendered="#{registrarSignosVitalesAnestesiaBean.mostrarIntervalo}"
                               value="#{registrarSignosVitalesAnestesiaBean.tiempointervalo}">
                <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstTiempoIntervalo}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTiempoIntervalo" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
              <h:outputText value=" Minutos" rendered="#{registrarSignosVitalesAnestesiaBean.mostrarIntervalo}"/>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
  
  
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonSignosVitalesAnestesia" columnClasses="columnaBotonesCentrados">
                   
                   
      
        
     <s:fieldset legend="Vista Clasica" id="fieldSetSignosVistaClasica" styleClass="fieldset" >
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                       id="panelGridVistaClasica" rowClasses="standardTable_Row2,standardTable_Row1">
                       
     <h:outputText value="Tipo de Vista" styleClass="labelTextOblig"/>
         <a4j:region renderRegionOnly="false">
          <h:selectOneRadio id = "selectVistaClasica" 
                value="#{registrarSignosVitalesAnestesiaBean.vistaClasica}" 
                valueChangeListener="#{registrarSignosVitalesAnestesiaBean.setVistaClasica}">
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstTipoVista}"/>
                <a4j:support id="supportmnuVistaClasica" event="onclick"
                               action="#{registrarSignosVitalesAnestesiaBean.ChangeVistaClasica}"
                               reRender="panelBotonSignosVitalesAnestesia">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
              
            </h:selectOneRadio>
            </a4j:region>
            </h:panelGrid>
        </s:fieldset>
        
        
          <s:fieldset legend="Registrar Signos Vitales" id="fieldSetSignosVitalesAnestesiaNuevo" styleClass="fieldset" rendered= "#{!registrarSignosVitalesAnestesiaBean.renderVistaClasica}">
          <h:panelGrid columns="13" border="1" cellpadding="0" cellspacing="0" width="100%" id="tableSignosVitales" styleClass="tabContainer"
                                             rendered="#{!registrarSignosVitalesAnestesiaBean.renderVistaClasica}">
          
          <h:outputText value ="P.A. Sistolica (mmHg)"/>
          <h:outputText value = ""/>
          
          <h:outputText value ="P.A. diastólica (mmHg)"/>
          <h:outputText value = ""/>
          
          <h:outputText value ="F.C (l.p.m.)"/>
          <h:outputText value = ""/>
          
         <h:outputText value ="PEC02 mmHg"/>
          <h:outputText value = ""/>
          
          <h:outputText value ="% Saturación O2"/>
          <h:outputText value = ""/>
          
          <h:outputText value ="Tipo de Respiración"/>
          <h:outputText value = ""/>
          
          
          <h:outputText value ="Agregar"/>
          
          
          
          <h:inputText value = "#{registrarSignosVitalesAnestesiaBean.sistolicaNuevo}" 
            id = "sistolicaNuevo" style="width:40px" maxlength="3"/>
          <h:outputText value = ""/>
          
          <h:inputText value = "#{registrarSignosVitalesAnestesiaBean.diastolicaNuevo}" id = "diastolicaNuevo"    style="width:40px" maxlength="3"/>
          <h:outputText value = ""/>
          
          
          
          <h:inputText value = "#{registrarSignosVitalesAnestesiaBean.frecuenciaCardiacaNuevo}" id = "frecuenciaNuevo"  style="width:50px"/>
          <h:outputText value = ""/>
          
          <h:inputText value = "#{registrarSignosVitalesAnestesiaBean.pecoNuevo}" id = "pecoNuevo"  style="width:40px" maxlength="3"/>
          <h:outputText value = ""  />
          
          <h:inputText value = "#{registrarSignosVitalesAnestesiaBean.saturacionNuevo}" id = "pecoSaturacion"   style="width:40px" maxlength="3"/>
          <h:outputText value = ""/>
          
            <h:selectOneMenu id = "mnuTipoRespiracionNuevo" 
                    value = "#{registrarSignosVitalesAnestesiaBean.respiracionNuevo}"  styleClass="mainselection">
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstTipoRespiracion}"/>
           </h:selectOneMenu>
          <h:outputText value = ""/>
          
             <h:commandLink id="Agregar" action="#{registrarSignosVitalesAnestesiaBean.adicionarSignoVitalNuevo}">
                  <t:graphicImage border="0" alt="" url="/comun/imagenes/editar.gif"/>
                </h:commandLink>
          
  
          
                                </h:panelGrid>
                    </s:fieldset>
        
        
        <s:fieldset legend="Signos Vitales (Seleccione una Opción)" id="fieldSetSignosVitalesAnestesia" styleClass="fieldset" rendered= "#{registrarSignosVitalesAnestesiaBean.renderVistaClasica}">
          <h:panelGrid columns="24" border="0" cellpadding="0" cellspacing="0" width="100%" 
                       id="panelGridSignosVitalesAnestesia" rowClasses="standardTable_Row2,standardTable_Row1">
          
            <h:outputLabel value="Signo" style="font-weight:bold; font-size:8.0pt;" />
            <h:outputLabel value="0" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="10" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="20" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="30" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="40" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="50" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="60" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="70" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="80" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="90" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="100" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="110" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="120" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="130" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="140" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="150" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="160" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="170" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="180" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="190" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="200" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="210" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="Digito" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="F.C (l.p.m.) "/>
         
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC0"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia0}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC1"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia10}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC2"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia20}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC3"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia30}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC4"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia40}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC5"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia50}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC6"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia60}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC7"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia70}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC8"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia80}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC9"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia90}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC10"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia100}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC11"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia110}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC12"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia120}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC13"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia130}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC14"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia140}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC15"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia150}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC16"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia160}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC17"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia170}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC18"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia180}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC19"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia190}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC20"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia200}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxFC21"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectFrecuencia210}"/>
            <h:selectOneMenu value="#{registrarSignosVitalesAnestesiaBean.digitoFC}" style="width:60px" >
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstDigitos}"/>
            </h:selectOneMenu>
            <h:outputLabel value="Signo" style="font-weight:bold; font-size:8.0pt;" />
            <h:outputLabel value="0" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="10" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="20" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="30" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="40" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="50" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="60" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="70" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="80" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="90" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="100" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="110" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="120" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="130" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="140" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="150" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="160" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="170" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="180" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="190" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="200" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="210" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="Digito" style="font-weight: bold; font-size:8.0pt;"/>
         
            <h:outputLabel value="P.A. Sistolica (mmHg)"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS0"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole0}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS1"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole10}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS2"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole20}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS3"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole30}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS4"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole40}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS5"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole50}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS6"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole60}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS7"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole70}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS8"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole80}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS9"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole90}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS10"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole100}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS11"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole110}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS12"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole120}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS13"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole130}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS14"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole140}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS15"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole150}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS16"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole160}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS17"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole170}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS18"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole180}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS19"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole190}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS20"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole200}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAS21"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionSistole210}"/>
            <h:selectOneMenu value="#{registrarSignosVitalesAnestesiaBean.digitoSistolica}" style="width:60px" >
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstDigitos}"/>
            </h:selectOneMenu>
            <h:outputLabel value="Signo" style="font-weight:bold; font-size:8.0pt;" />
            <h:outputLabel value="0" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="10" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="20" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="30" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="40" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="50" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="60" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="70" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="80" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="90" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="100" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="110" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="120" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="130" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="140" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="150" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="160" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="170" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="180" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="190" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="200" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="210" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="Digito" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="P.A. diastólica (mmHg)"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD0"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole0}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD1"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole10}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD2"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole20}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD3"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole30}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD4"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole40}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD5"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole50}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD6"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole60}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD7"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole70}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD8"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole80}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD9"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole90}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD10"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole100}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD11"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole110}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD12"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole120}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD13"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole130}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD14"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole140}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD15"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole150}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD16"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole160}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD17"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole170}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD18"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole180}"/>
             <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD19"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole190}"/>                         
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD20"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole200}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPAD21"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPresionDiastole210}"/>
            <h:selectOneMenu value="#{registrarSignosVitalesAnestesiaBean.digitoDiastolica}" style="width:60px" >
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstDigitos}"/>
            </h:selectOneMenu>
            
            <h:outputLabel value="Signo" style="font-weight:bold; font-size:8.0pt;" />
            
            <h:outputLabel value="10" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="20" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="30" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="40" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="Digito" style="font-weight: bold; font-size:8.0pt;"/>
            
            
            <h:outputLabel value="PEC02 mmHg"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPEC1" 
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPeco10}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPEC2" 
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPeco20}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPEC3"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPeco30}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxPEC4"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectPeco40}"/>
            <h:outputText style="border-style:none;" id="checkBoxPEC5"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC6"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC7"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC8"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC9"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC10"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC11"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC12"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC13"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC14"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC15"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC16"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC17"
                                     value=""/>
             <h:outputText style="border-style:none;" id="checkBoxPEC18"
                                     value=""/>                         
            <h:outputText style="border-style:none;" id="checkBoxPEC19"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC20"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC21" value=""/>
            <h:outputText style="border-style:none;" id="checkBoxPEC22" value=""/>
            <h:selectOneMenu value="#{registrarSignosVitalesAnestesiaBean.digitoPeco}" style="width:60px" >
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstDigitos}"/>
            </h:selectOneMenu>
            <h:outputLabel value="Signo" style="font-weight:bold; font-size:8.0pt;" />
            <h:outputLabel value="0" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="10" style="font-weight: bold; font-size:8.0pt;" />
            <h:outputLabel value="20" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="30" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="40" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="50" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="60" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="70" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="80" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="90" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="100" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value="Digito" style="font-weight: bold; font-size:8.0pt;"/>
            <h:outputLabel value=" % Saturación O2"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion0"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion0}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion1"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion10}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion2"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion20}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion3"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion30}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion4"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion40}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion5"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion50}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion6"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion60}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion7"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion70}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion8"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion80}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion9"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion90}"/>
            <h:selectBooleanCheckbox style="border-style:none;" id="checkBoxSaturacion10"
                                     value="#{registrarSignosVitalesAnestesiaBean.selectSaturacion100}"/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion11"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion12"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion13"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion14"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion15"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion16"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion17"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion18"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion19"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion20"
                                     value=""/>
            <h:outputText style="border-style:none;" id="checkBoxSaturacion21"
                                     value=""/>
            <h:selectOneMenu value="#{registrarSignosVitalesAnestesiaBean.digitoSaturacion}"  style="width:60px">
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstDigitos}"/>
            </h:selectOneMenu>
          </h:panelGrid>
          <t:htmlTag value="br"/>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTipoRespiracion"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Tipo de Respiración"/>
            <h:outputText value=""/>
            <h:selectOneRadio value="#{registrarSignosVitalesAnestesiaBean.tipoRespiracion}" layout="lineDirection">
              <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstTipoRespiracion}"/>
            </h:selectOneRadio>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelBotonAdicionarSignoVital" columnClasses="panelGridBotones">
            <a4j:commandButton id="commandAdicionar" value="Agregar" styleClass="btn btn btn-success"
                               reRender="panelTabRegistrarSignosVitales"
                               action="#{registrarSignosVitalesAnestesiaBean.adicionarSignoVital}"/>
          </h:panelGrid>
          <t:htmlTag value="br"/>
        </s:fieldset>
      </h:panelGrid>
      <t:htmlTag value="br"/>
      <s:fieldset legend="Signos Vitales" id="fieldSetTableAnestesiaSignosVitales" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridNoSignosVitales"
                     rendered="#{empty registrarSignosVitalesAnestesiaBean.lstSignoVital}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0"
                     rendered="#{not empty registrarSignosVitalesAnestesiaBean.lstSignoVital}" cellspacing="0"
                     width="100%" id="tableSignosVitalesAnestesia" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{registrarSignosVitalesAnestesiaBean.lstSignoVital}" rows="30"
                         binding="#{registrarSignosVitalesAnestesiaBean.dtSignosVitales}" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                         id="dtSignosVitalesAnestesia">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha Actividad"/>
                </f:facet>
                <h:outputText value="#{item.hsvdfechaactiv}">
                  <f:convertDateTime pattern="dd/MM/yyyy hh:mm"/>
                </h:outputText>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Presión Arterial"/>
                </f:facet>
                <h:inputText value="#{item.hsvnpresart1}" style="width:30px" maxlength="3"/>
                <h:outputText value="/"/>
                <h:inputText value="#{item.hsvnpresart2}" style="width:30px" maxlength="3"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Cardiaca"/>
                </f:facet>
                <h:inputText value="#{item.hsvnfreccard}" style="width:30px" maxlength="3"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Saturación de Oxígeno"/>
                </f:facet>
                <h:inputText value="#{item.hsvnsatuoxihe}" style="width:30px" maxlength="3"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Presión Dióxido de Carbono "/>
                </f:facet>
                <h:inputText value="#{item.hsvnpresioxido}" style="width:30px" maxlength="3"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo de Respiración "/>
                </f:facet>
                <h:selectOneMenu value="#{item.hsvctiporespir}" styleClass="mainselection">
                  <f:selectItems value="#{registrarSignosVitalesAnestesiaBean.lstTipoRespiracion}"/>
                </h:selectOneMenu>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Modificar"/>
                </f:facet>
                <h:commandLink id="guardar" action="#{registrarSignosVitalesAnestesiaBean.guardarSignoVital}">
                  <t:graphicImage border="0" alt="" url="/comun/imagenes/editar.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_AnestesiaSignosVitales" for="dtSignosVitalesAnestesia" fastStep="10"
                              pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                              immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator"
                              renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      
       <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
               columnClasses="panelGridBotones">
    <h:panelGroup>
      <h:commandButton value="Siguiente" styleClass="btn btn btn-info"
                       action="#{registrarSignosVitalesAnestesiaBean.nextPage}">
        <a4j:support event="onclick" status="statusButton"/>
      </h:commandButton>
    </h:panelGroup>
  </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
  <h:panelGrid>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionCanalizacionMsg" ajaxRendered="true">
        <t:messages id="msgInformationCanalizacionMsg" showSummary="true" errorClass="error" globalOnly="true"
                    layout="table" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>