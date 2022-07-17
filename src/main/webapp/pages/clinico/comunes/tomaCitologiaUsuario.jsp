<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTomaCitologiaTab" styleClass="tabContainer">
<jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPanelTomaCitologia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionTomaCitologiaMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationTomaCitologiaMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
        <t:panelTab id="panelTabTomaCitologia" label="Toma">
           <s:fieldset legend="Informaci�n General Usuario(a) " id="fieldAsesoriaTomaCitologia" styleClass="fieldset">
  
    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioTomaCitologia" rowClasses="labelText,labelTextInfo">
      <h:outputText value="C�digo"/>
      <h:outputText value="Identificaci�n"/>
      <h:outputText value="Nombre"/>
    
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huslnumero}"/>
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.husetipoiden} #{datosBasicosUsuarioBean.usuario.husanumeiden}"/>
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huscprimernomb} #{datosBasicosUsuarioBean.usuario.huscsegundnomb} #{datosBasicosUsuarioBean.usuario.huscprimerapel} #{datosBasicosUsuarioBean.usuario.huscsegundapel}"/>
    </h:panelGrid>
    
    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioII" rowClasses="labelText,labelTextInfo">
      <h:outputText value="Edad"/>
      <h:outputText value="Sexo"/>
      <h:outputText value="Estado Civil"/>
        <h:outputText value="#{datosBasicosUsuarioBean.usuario.edad}" />
   
      <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioBean.usuario.husesexo}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioBean.listSexos}"/>
      </h:selectOneMenu>
      <h:selectOneMenu id="radioEstadoCivil"  onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioBean.usuario.huseestadcivil}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioBean.listEstadoCivil}"/>
      </h:selectOneMenu>
         <h:outputText value="Direcci�n"/>
      <h:outputText value="Correo Electr�nico"/>
      <h:outputText value = "Aseguradora"/>
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huscdireccion}"/>
      <h:outputText value="#{ (datosBasicosUsuarioBean.usuario.husccorreoelec == null || datosBasicosUsuarioBean.usuario.husccorreoelec == '') ? 'Sin Registrar' : datosBasicosUsuarioBean.usuario.husccorreoelec }"/>
       <h:selectOneMenu id="radioAseguradora" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioBean.usuario.huscentidadadm}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioBean.listEntidadAdm}"/>
      </h:selectOneMenu>
      
      <h:outputText value="Telefono Contacto" />
      <h:outputText value="Telefono Celular" />
       <h:outputText value="" />
        
       <h:outputText value="#{datosBasicosUsuarioBean.usuario.husctelefono}" />
       <h:outputText value="#{datosBasicosUsuarioBean.usuario.husccelular}" />
        <h:outputText value="" />
    </h:panelGrid>
  </s:fieldset>
            <a4j:region renderRegionOnly="false">
             <a4j:commandLink action="#{tomaCitologiaBean.cargarDatos}" 
                reRender="panelGridTomaCitologiaTab" immediate="true" title="Obtener Datos">
            <t:graphicImage alt="Obtener Datos" title="Obtener Datos" border="0" url="/comun/imagenes/cargar_datos.jpg" />
          </a4j:commandLink>
          </a4j:region>
          <t:htmlTag value="br"/>
          
          
              <s:fieldset legend="Datos Policia" id="fieldSetInfoDatosPolicia" styleClass="fieldset"   rendered="#{tomaCitologiaBean.esPolicia}" >
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                     rendered="#{tomaCitologiaBean.esPolicia}" id="panelGridDatosPolicia"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo de Usuario" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:outputText value="# Remision" styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:selectOneMenu id="menuTipoUsuario" onkeydown="return blockEnter(event);" required="true"
                           disabled="#{tomaCitologiaBean.modoConsulta}" 
                           value="#{tomaCitologiaBean.toma.ctmctipusu}">
            <f:selectItems value="#{tomaCitologiaBean.lstTipoUsuario}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuTipoUsuario" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="itRemision" onkeydown="return blockEnter(event);" required="true" title="Numero de Remision"
                       maxlength="20" style="width:120px" disabled="#{tomaCitologiaBean.modoConsulta}"
                       value="#{tomaCitologiaBean.toma.ctmcnumrem}"></h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itRemision" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
          
          
          <s:fieldset legend="Datos Toma" id="fieldSetInfoProcedimientosCitologia" styleClass="fieldset">
        
            <h:panelGrid columns="5" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridGinecologicoCitologia" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Esquema Citologia" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelTextCualEsquema">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                    rendered="#{tomaCitologiaBean.mostrarOtroEsquema}"/>
              </h:panelGroup>
             <h:outputText value="Esquema Tipificacion de Vph" styleClass="labelTextOblig"/>
              <h:panelGroup id="panelTextCualEsquemaVph">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                    rendered="#{tomaCitologiaBean.mostrarOtroEsquemaVph}"/>
              </h:panelGroup>
              <h:outputText/>
             <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneMenu id="menuEsquemaCitologia" onkeydown="return blockEnter(event);" required="true" disabled="#{tomaCitologiaBean.modoConsulta}"
                                 immediate="true" value="#{tomaCitologiaBean.toma.ctmcesquem}"
                                 valueChangeListener="#{tomaCitologiaBean.setCtmcesquem}">
                  <f:selectItems value="#{tomaCitologiaBean.lstEsquema}"/>
                  <a4j:support id="supportEsquema" event="onchange"
                                 action="#{tomaCitologiaBean.changeEsquema}"
                                 reRender="panelTextCualEsquema,panelInputCualEsquema" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuEsquemaCitologia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              </a4j:region>
             <h:panelGroup id="panelInputCualEsquema">
                <h:inputText id="itCualEsq"  onkeydown="return blockEnter(event);" 
                            required="true" maxlength="60" disabled="#{tomaCitologiaBean.modoConsulta}"
                             rendered="#{tomaCitologiaBean.mostrarOtroEsquema}"
                             value="#{tomaCitologiaBean.toma.ctmcotresq}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualEsq" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
                 <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneMenu id="menuEsquemaVph" onkeydown="return blockEnter(event);" required="true" disabled="#{tomaCitologiaBean.modoConsulta}"
                                 immediate="true" value="#{tomaCitologiaBean.toma.ctmcesqvph}"
                                 valueChangeListener="#{tomaCitologiaBean.setCtmcesqVph}">
                  <f:selectItems value="#{tomaCitologiaBean.lstEsquemaVph}"/>
                  <a4j:support id="supportEsquemaVph" event="onchange"
                                 action="#{tomaCitologiaBean.changeEsquemaVph}"
                                 reRender="panelTextCualEsquemaVph,panelInputCualEsquemaVph" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuEsquemaVph" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              </a4j:region>
             <h:panelGroup id="panelInputCualEsquemaVph">
                <h:inputText id="itCualEsqVph"  onkeydown="return blockEnter(event);" 
                            required="true" maxlength="60" disabled="#{tomaCitologiaBean.modoConsulta}"
                             rendered="#{tomaCitologiaBean.mostrarOtroEsquemaVph}"
                             value="#{tomaCitologiaBean.toma.ctmcotresqvph}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCualEsqVph" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
               <h:outputText value="M�todo Planificaci�n " styleClass="labelTextOblig"/>
               <h:panelGroup id="panelTextTiempoUso">
                <h:outputText value = "Tiempo de uso (a�os)"  styleClass="labelTextOblig"
                    rendered="#{tomaCitologiaBean.renderTiempoUso}"/>
              </h:panelGroup>
              
              <h:panelGroup id="panelTextCualMetodo">
                <h:outputText value="Cual" styleClass="labelTextOblig"
                    rendered="#{tomaCitologiaBean.mostrarotrometodo}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="menuMetodosPlanificacion" onkeydown="return blockEnter(event);" required="true" immediate="true"
                                   disabled="#{tomaCitologiaBean.modoConsulta}"
                                   valueChangeListener="#{tomaCitologiaBean.setCtmcmetpla}"
                                   value="#{tomaCitologiaBean.toma.ctmcmetpla}">
                    <f:selectItems value="#{tomaCitologiaBean.lstMetodos}"/>
                    <a4j:support id="supportMetodoPlanificacion" event="onchange"
                                 action="#{tomaCitologiaBean.changeMetodo}"
                                 reRender="panelTextCualMetodo,panelInputCualMetodo,panelTextTiempoUso,panelInputTiempoUso" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuMetodosPlanificacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>

               <h:panelGroup id = "panelInputTiempoUso">
                    <h:inputText id="itTiempoUso" 
                             required ="true" onkeydown="return blockEnter(event);"
                             disabled="#{tomaCitologiaBean.modoConsulta}"
                             rendered="#{tomaCitologiaBean.renderTiempoUso}" title="Tiempo de uso del m�todo en a�os"
                             value="#{tomaCitologiaBean.toma.ctmntiemet}" style="width:50px" maxlength="4">
                             <f:validator validatorId="validateTiempoMetodo"/>
                           </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTiempoUso" styleClass="errorMessage"/>
                </a4j:outputPanel>
               </h:panelGroup>
            <h:panelGroup id="panelInputCualMetodo">
                <h:inputText id="itCual"  onkeydown="return blockEnter(event);" 
                            required="true" maxlength="60" disabled="#{tomaCitologiaBean.modoConsulta}"
                             rendered="#{tomaCitologiaBean.mostrarotrometodo}"
                             value="#{tomaCitologiaBean.toma.ctmcotrmet}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            <h:outputText/>
                <h:outputText/>
              <h:outputText value="Gestaci�n " styleClass="labelTextOblig"/>
              <h:outputText value="Partos " styleClass="labelTextOblig"/>
              <h:outputText value="Abortos " styleClass="labelTextOblig"/>
             <h:outputText value = "Consecutivo"/>
             <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:inputText id="mnuNumGestacion" immediate="true" 
                               disabled="#{tomaCitologiaBean.modoConsulta}"
                               onkeydown="return blockEnter(event);"
                               required="true" title="Numero de Gestaciones"
                               maxlength="2" style="width:30px"
                               valueChangeListener="#{tomaCitologiaBean.setNumeroGestaciones}"
                               value="#{tomaCitologiaBean.toma.ctmngestac}">
                                 <a4j:support id="supportNumGestacion"  immediate="true"  event="onchange"
                                 action="#{tomaCitologiaBean.changeNumeroGestaciones}"
                                 reRender="panelCalendarFechaParto,panelNumAbortos,panelNumPartos,itNumPartos,itNumAbortos,supportNumPartos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                 </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuNumGestacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
               <a4j:region renderRegionOnly="false">
              <h:panelGroup id="panelNumPartos">
                  <h:inputText id="itNumPartos" onkeydown="return blockEnter(event);"
                                binding="#{tomaCitologiaBean.itNumPartos}"
                               immediate="true"
                               required="#{!tomaCitologiaBean.esCeroPartos}"
                               title="Numero de Partos" 
                               disabled="#{tomaCitologiaBean.esCeroGestaciones || tomaCitologiaBean.modoConsulta}"
                               value="#{tomaCitologiaBean.toma.ctmnpartos}" 
                               valueChangeListener="#{tomaCitologiaBean.setCtmnpartos}"
                               maxlength="2" style="width:30px">
                                <a4j:support id="supportNumPartos"  immediate="true"  event="onchange"
                                 action="#{tomaCitologiaBean.changeNumeroPartos}"
                                 reRender="panelCalendarFechaParto">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumPartos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelNumAbortos">
                <h:panelGroup>
                  <h:inputText id="itNumAbortos" onkeydown="return blockEnter(event);" required="true"
                               title="Numero de Abortos" maxlength="2" style="width:30px"
                               disabled="#{tomaCitologiaBean.esCeroGestaciones || tomaCitologiaBean.modoConsulta}"
                               value="#{tomaCitologiaBean.toma.ctmnaborto}"></h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumAbortos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
                <h:outputText value = "#{tomaCitologiaBean.consecCitologia}"/>
              <h:outputText/>
              <h:outputText value="Fecha �ltima Menstruaci�n " styleClass="labelTextOblig"/>
              <h:outputText value="Fecha �ltimo Parto " styleClass="labelTextOblig"/>
              <h:outputText value="Edad Relaciones " styleClass="labelTextOblig"/>
              <h:outputText value="�Esta Usted Embarazada? " styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:panelGroup id = "panelTextDateRegla">
                <t:inputCalendar id="calendarUltimaRegla" disabled="#{tomaCitologiaBean.modoConsulta}"
                                 title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{tomaCitologiaBean.toma.ctmdultmen}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true">
                                 <f:validator validatorId="dateMenorIgualValidator"/>        
                        </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarUltimaRegla" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="panelCalendarFechaParto">
                <t:inputCalendar id="calendarUltimoParto" title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);" 
                                 disabled="#{tomaCitologiaBean.esCeroGestaciones || tomaCitologiaBean.modoConsulta || tomaCitologiaBean.esCeroPartos}"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{tomaCitologiaBean.toma.ctmdultpar}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                 renderPopupButtonAsImage="true" align="top" required="#{!tomaCitologiaBean.esCeroPartos}">
                                 <f:validator validatorId="dateMenorIgualValidator"/>        
                            </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarUltimoParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itEdadPrimeraRelacion" required="true" 
                             onkeydown="return blockEnter(event);"
                             disabled="#{tomaCitologiaBean.modoConsulta}" maxlength="2"
                             value="#{tomaCitologiaBean.toma.ctmnedarel}" style="width:30px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEdadPrimeraRelacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneRadio id="mnuEmbarazada" onkeydown="return blockEnter(event);" required="true" disabled="#{tomaCitologiaBean.modoConsulta}"
                                  value="#{tomaCitologiaBean.toma.ctmcembara}">
                  <f:selectItems value="#{tomaCitologiaBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEmbarazada" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup/>
             <h:outputText value="Fecha �ltima Citolog�a"/>
             <h:panelGroup id="panelResultadoCitologia">
                <h:outputText value="Resultado" styleClass="labelTextOblig" rendered="#{tomaCitologiaBean.mostrarResultado}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextHallazgos">
                <h:outputText value="Cuales?" styleClass="labelTextOblig"
                              rendered="#{tomaCitologiaBean.mostrarhallazgos}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaCitologia" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" immediate="true" value="#{tomaCitologiaBean.toma.ctmdultcit}"
                                   valueChangeListener="#{tomaCitologiaBean.setCtmdultcit}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                    <a4j:support id="supportUltimaRegla" event="onchange" immediate="true"
                                 reRender="panelResultadoCitologia,panelMenuResul,panelTextHallazgos,panelInputHallazgos"
                                 action="#{tomaCitologiaBean.ChangeFechaCitologia}" oncomplete="jsFunctionCitologia()">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimaCitologia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMenuResul">
                  <h:selectOneMenu id="mnuResultado" required="true" immediate="true"
                                   onkeydown="return blockEnter(event);"
                                   rendered="#{tomaCitologiaBean.mostrarResultado}"
                                   binding="#{tomaCitologiaBean.mnuResultado}"
                                   value="#{tomaCitologiaBean.toma.ctmcultres}"
                                   valueChangeListener="#{tomaCitologiaBean.setCtmcultres}"
                                   disabled="#{tomaCitologiaBean.modoConsulta}">
                    <f:selectItems value="#{tomaCitologiaBean.lstResultado}"/>
                    <a4j:support id="supportUltimaRegla11" event="onchange"
                                 action="#{tomaCitologiaBean.changeResultado}"
                                 reRender="panelTextHallazgos,panelInputHallazgos" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultado" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelInputHallazgos">
                <h:inputText id="itOtrosHallazgos" maxlength="100" required="true"
                             onkeydown="return blockEnter(event);"
                             disabled="#{tomaCitologiaBean.modoConsulta}"
                             rendered="#{tomaCitologiaBean.mostrarhallazgos}"
                             value="#{tomaCitologiaBean.toma.ctmcotrhal}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOtrosHallazgos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
                <h:outputText value="Fecha �ltima Tipificaci�n" />
             <h:panelGroup id="panelTextResultadoTipificacion">
                <h:outputText value="Resultado" styleClass="labelTextOblig" rendered="#{tomaCitologiaBean.mostrarResultTipificacion}"/>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaTipificacion" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" immediate="true" value="#{tomaCitologiaBean.toma.ctmdtipifi}"
                                   valueChangeListener="#{tomaCitologiaBean.setCtmdtipifi}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                    <a4j:support id="supportUltimaTipificacion" event="onchange" immediate="true"
                                 reRender="panelTextResultadoTipificacion,panelResultadoTipificacion"
                                 action="#{tomaCitologiaBean.changeFechaTipifiacion}" oncomplete="jsFunctionCitologia()">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimaTipificacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelResultadoTipificacion">
                <h:selectOneRadio id="mnuTipificacion" onkeydown="return blockEnter(event);" required="true" disabled="#{tomaCitologiaBean.modoConsulta}"
                                  rendered="#{tomaCitologiaBean.mostrarResultTipificacion}"
                                  value="#{tomaCitologiaBean.toma.ctmctipifi}">
                  <f:selectItems value="#{tomaCitologiaBean.lstResultTipificacion}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTipificacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText/>
              <h:outputText/>
              <h:outputText value="Completo esquema vacuna VPH " styleClass="labelTextOblig"/>
              <h:panelGroup id="panelTextDosisAdmin">
              <h:outputText value = "N�mero de Dosis Administradas" rendered="#{tomaCitologiaBean.mostrarNumDosisAdmini}" styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:outputText value = "Lactancia Actual"/>
              <h:outputText/>
              <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup>
              <h:selectOneRadio id="mnuVph" required="true" value="#{tomaCitologiaBean.toma.ctmccomvph}"
                                onkeydown="return blockEnter(event);" disabled="#{tomaCitologiaBean.modoConsulta}"
                                immediate="true" valueChangeListener="#{tomaCitologiaBean.setCtmccomvph}">
                <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                <a4j:support id="supportVph" event="onchange" action="#{tomaCitologiaBean.changeVacVph}"
                             reRender="panelTextDosisAdmin,panelInputDosisAdmin" immediate="true">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuVph" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </a4j:region>
          <h:panelGroup id="panelInputDosisAdmin">
            <h:inputText id="idNumDosisAdm" required="true" immediate="true" onkeydown="return blockEnter(event);"
                         rendered="#{tomaCitologiaBean.mostrarNumDosisAdmini}"
                         disabled="#{tomaCitologiaBean.modoConsulta}" maxlength="2"
                         value="#{tomaCitologiaBean.toma.ctmnnudoad}" style="width:30px"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="idNumDosisAdm" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
                <h:selectOneRadio id = "mnuLactancia" required="true"
                        disabled="#{tomaCitologiaBean.modoConsulta}"
                        value = "#{tomaCitologiaBean.toma.ctmclactan}">
                    <f:selectItems value = "#{tomaCitologiaBean.lstOpcionesvph}"/>    
                   </h:selectOneRadio>     
                         <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuLactancia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                 <h:outputText value = ""/>
              <h:outputText/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Procedimientos Anteriores en el Cuello Uterino" id="fieldSetInfoProcedimientosConsultorio"
                      styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelRegionInfoConsulta" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiene Procedimientos Anteriores" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                
                  <h:selectOneRadio id="mnuProcedimientos" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{tomaCitologiaBean.toma.ctmcpningu}"
                                    disabled="#{tomaCitologiaBean.modoConsulta}"
                                    valueChangeListener="#{tomaCitologiaBean.setCtmcpningu}">
                    <f:selectItems value="#{tomaCitologiaBean.lstOpcionesInvertido}"/>
                    <a4j:support id="supportProcedimientos" event="onclick"
                                 action="#{tomaCitologiaBean.changeProcedimiento}"
                                 reRender="panelProcedimientosRealizados">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuProcedimientos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:selectOneRadio>
                </h:panelGroup>
              </a4j:region>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
            </h:panelGrid>
            <h:panelGrid id="panelProcedimientosRealizados" border="0" cellpadding="0" cellspacing="0" width="100%"
                         columns="1">
              <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0"
                           rendered="#{tomaCitologiaBean.mostrarProcedimiento}" width="100%" id="panelProcedimientos"
                           rowClasses="labelText,labelTextInfo">
                           
                           <h:outputText value="Cauterizaci�n" styleClass="labelTextOblig"/>
                           
                            <h:panelGroup id="panelTextFechaCauterizacion">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaCauterizacion}"/>
                </h:panelGroup>
                
                
                <h:outputText value="Histerectomia" styleClass="labelTextOblig"/>
                
                
                 <h:panelGroup id="panelTextFechaHisterectomia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaHisterectomia}"/>
                </h:panelGroup>
                
                 <h:outputText value="Conizaci�n" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaConizacion">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaConizacion}"/>
                </h:panelGroup>
                
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCauterizacion" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      binding="#{tomaCitologiaBean.mnuCauterizacion}"
                                      value="#{tomaCitologiaBean.toma.ctmcpcaute}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpcaute}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportCauterizacion" event="onclick"
                                   action="#{tomaCitologiaBean.changeCauterizacion}"
                                   reRender="panelTextFechaCauterizacion,panelFechaCauterizacion">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCauterizacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaCauterizacion">
                  <t:inputCalendar id="calendarCauterizacion" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" disabled="#{tomaCitologiaBean.modoConsulta}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpcaute}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaCauterizacion}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarCauterizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHistectomia" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      value="#{tomaCitologiaBean.toma.ctmcphiste}"
                                      binding="#{tomaCitologiaBean.mnuHistectomia}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcphiste}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportHistecrectomia" event="onclick"
                                   action="#{tomaCitologiaBean.changeHisterectomia}"
                                   reRender="panelTextFechaHisterectomia,panelFechaHisterectomia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHistectomia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaHisterectomia">
                  <t:inputCalendar id="calendarHistectomia" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" disabled="#{tomaCitologiaBean.modoConsulta}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdphiste}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaHisterectomia}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                        </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarHistectomia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                 <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuConizacion" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      value="#{tomaCitologiaBean.toma.ctmcpconiz}"
                                      binding="#{tomaCitologiaBean.mnuConizacion}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpconiz}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportConizacion" event="onclick"
                                   action="#{tomaCitologiaBean.changeConizacion}"
                                   reRender="panelTextFechaConizacion,panelFechaConizacion">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuConizacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaConizacion">
                  <t:inputCalendar id="calendarConizacion" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpconiz}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaConizacion}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                    </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarConizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                
                <h:outputText value="Radioterapia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaRadioterapia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaRadioterapia}"/>
                </h:panelGroup>
                
                
                
                 <h:outputText value="Biopsia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaBiopsia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaBiopsia}"/>
                </h:panelGroup>
                <h:outputText value="Crioterapia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaCrioterapia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaCrioterapia}"/>
                </h:panelGroup>
                
                
                
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuRadioterapia" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      value="#{tomaCitologiaBean.toma.ctmcpradio}"
                                      binding="#{tomaCitologiaBean.mnuRadioterapia}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpradio}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportRadioterapia" event="onclick"
                                   action="#{tomaCitologiaBean.changeRadioterapia}"
                                   reRender="panelTextFechaRadioterapia,panelFechaRadioTerapia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuRadioterapia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaRadioTerapia">
                  <t:inputCalendar id="calendarRadioTerapia" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpradio}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaRadioterapia}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarRadioTerapia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                 <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuBiopsia" required="true" value="#{tomaCitologiaBean.toma.ctmcpbiops}"
                                      onkeydown="return blockEnter(event);"
                                      immediate="true" disabled="#{tomaCitologiaBean.modoConsulta}"
                                      binding="#{tomaCitologiaBean.mnuBiopsia}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpbiops}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportBiopsia" event="onclick"
                                   action="#{tomaCitologiaBean.changeBiopsia}"
                                   reRender="panelTextFechaBiopsia,panelFechaBiopsia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuBiopsia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaBiopsia">
                  <t:inputCalendar id="calendarBiopsia" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);" disabled="#{tomaCitologiaBean.modoConsulta}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpbiops}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaBiopsia}" required="false">
                        <f:validator validatorId="dateMenorIgualValidator"/>        
                    </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarBiopsia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCrioterapia" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      binding="#{tomaCitologiaBean.mnuCrioterapia}"
                                      value="#{tomaCitologiaBean.toma.ctmcpcriot}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpcriot}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportCrioterapia" event="onclick"
                                   action="#{tomaCitologiaBean.changeCrioterapia}"
                                   reRender="panelTextFechaCrioterapia,panelFechaCrioterapia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCrioterapia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaCrioterapia">
                  <t:inputCalendar id="calendarCrioterapia" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpcriot}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   rendered="#{tomaCitologiaBean.mostrarFechaCrioterapia}"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                        </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarCrioterapia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                <h:outputText value="ATA" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaATA">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaATA}"/>
                </h:panelGroup>
                <h:outputText value="Vaporizaci�n" styleClass="labelTextOblig"/>
                 <h:panelGroup id="panelTextFechaVaporizacion">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaVaporizacion}"/>
                </h:panelGroup>
                 <h:outputText value="Tratamiento Hormonal" styleClass="labelTextOblig"/>
                 <h:panelGroup id="panelTextFechaHormonal">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaHormonal}"/>
                </h:panelGroup>
                
                 <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuATA" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}" binding="#{tomaCitologiaBean.mnuATA}"
                                      value="#{tomaCitologiaBean.toma.ctmcpata}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpata}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportAta" event="onclick"
                                   action="#{tomaCitologiaBean.changeATA}" reRender="panelTextFechaATA,panelFechaATA">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuATA" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaATA">
                  <t:inputCalendar id="calendarATA" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpata}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaATA}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarATA" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuVaporizacion" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}" 
                                      binding="#{tomaCitologiaBean.mnuVaporizacion}"
                                      value="#{tomaCitologiaBean.toma.ctmcpvapor}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpvapor}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportVaporizacion" event="onclick"
                                   action="#{tomaCitologiaBean.changeVaporizacion}" 
                                   reRender="panelTextFechaVaporizacion,panelFechaVaporizacion">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuVaporizacion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaVaporizacion">
                  <t:inputCalendar id="calendarVaporizacion" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" 
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdpvapor}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaVaporizacion}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarVaporizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

               <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHormonal" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}" 
                                      binding="#{tomaCitologiaBean.mnuHormonal}"
                                      value="#{tomaCitologiaBean.toma.ctmcphormo}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcphormo}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportHormonal" event="onclick" 
                                   action="#{tomaCitologiaBean.changeHormonal}" 
                                   reRender="panelFechaHormonal,panelTextFechaHormonal">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHormonal" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaHormonal">
                  <t:inputCalendar id="calendarHormonal" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" 
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaCitologiaBean.toma.ctmdphormo}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaHormonal}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarHormonal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

                <h:outputText value="Colposcopia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextColpos">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaColpos}"/>
                </h:panelGroup>
                <h:outputText value="Otro" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaOtro">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaOtro}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextCualOtro">
                  <h:outputText value="Cual" styleClass="labelTextOblig"
                                rendered="#{tomaCitologiaBean.mostrarFechaOtro}"/>
                </h:panelGroup>
              
                <h:outputText value=""/>
                
                                    <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuColpos" required="true" immediate="true" 
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      binding="#{tomaCitologiaBean.mnuColpos}" value="#{tomaCitologiaBean.toma.ctmcpcolpo}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpcolpo}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportColpos" event="onclick"
                                   action="#{tomaCitologiaBean.changeFechaColposcopia}"
                                   reRender="panelTextColpos,panelFechaColpos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuColpos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaColpos">
                  <t:inputCalendar id="calendarColpos" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{tomaCitologiaBean.toma.ctmdpcolpo}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaColpos}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                                </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarColpos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                    <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuOtro" required="true" immediate="true" 
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      binding="#{tomaCitologiaBean.mnuOtro}" value="#{tomaCitologiaBean.toma.ctmcpotro}"
                                      valueChangeListener="#{tomaCitologiaBean.setCtmcpotro}">
                      <f:selectItems value="#{tomaCitologiaBean.lstOpcionesvph}"/>
                      <a4j:support id="supportOtros" event="onclick"
                                   action="#{tomaCitologiaBean.changeOtroProcedimiento}"
                                   reRender="panelTextFechaOtro,panelTextCualOtro,panelFechaOtro,panelCualOtro">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuOtro" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaOtro">
                  <t:inputCalendar id="calendarOtro" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                                   disabled="#{tomaCitologiaBean.modoConsulta}" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{tomaCitologiaBean.toma.ctmdpotro}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaCitologiaBean.mostrarFechaOtro}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                                </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarOtro" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelCualOtro">
                  <h:inputText id="inputOtro" rendered="#{tomaCitologiaBean.mostrarFechaOtro}" 
                               onkeydown="return blockEnter(event);"
                               disabled="#{tomaCitologiaBean.modoConsulta}" 
                               value="#{tomaCitologiaBean.toma.ctmcpdotro}"
                               maxlength="20"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtro" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                
 
              </h:panelGrid>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Informaci�n" id="fieldSetInfoAspectodelCuello" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAspectoCuello"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Aspecto Cuello" styleClass="labelTextOblig"
                            rendered="#{!tomaCitologiaBean.temporal}"/>
              <h:outputText value="Tomada por" styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:selectManyCheckbox id="mnuCuello" required="true" immediate="true" layout="pageDirection"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaCitologiaBean.modoConsulta}"
                                      rendered="#{!tomaCitologiaBean.temporal}"
                                      value="#{tomaCitologiaBean.lstAspectoSelect}">
                  <f:selectItems value="#{tomaCitologiaBean.lstAspecto}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCuello" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:selectOneMenu id="mnuTomada" onkeydown="return blockEnter(event);"
                      required="true" disabled="#{tomaCitologiaBean.modoConsulta}"
                      value="#{tomaCitologiaBean.toma.ctmctomada}">
                  <f:selectItems value="#{tomaCitologiaBean.lstTomada}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuTomada" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridObservaciones"
                         rowClasses="labelText,labelTextInfo">
              <h:panelGroup>
                <h:outputText value="Observaciones"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputTextarea id="itObservacionesToma" style="width:600px" onkeydown="return blockEnter(event);"
                                 disabled="#{tomaCitologiaBean.modoConsulta}"
                                 value="#{tomaCitologiaBean.toma.ctmcobstom}">
                            <f:validator validatorId="cadena.stringValidatorNoPuntuacion"/>
                            <f:validateLength maximum="600"/>     
                      </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itObservacionesToma" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
           </s:fieldset>
           <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonGenerarReporteTomaCitologia">
            <a4j:commandLink id="mostrarImpresion" action="#{tomaCitologiaBean.generarPDF}"
                           rendered="#{tomaCitologiaBean.modoConsulta}"
                             reRender="panelGridTomaCitologiaTab" immediate="true"
                             title="Imprimir Toma">
              <t:graphicImage alt="Imprimir Toma" title="Imprimir Toma" border="0"
                              url="/comun/imagenes/print_Spa.gif"/>
            </a4j:commandLink>
            <a4j:commandLink id="mostrarImpresionCodigo" action="#{tomaCitologiaBean.generarReporteCodigoQR}"
                             rendered="#{tomaCitologiaBean.imprimirCodigoQRvph}"
                             reRender="panelGridTomaCitologiaTab" immediate="true"
                             title="Imprimir Codigo QR">
              <h:outputText value="Generar CodigoQR"/>
            </a4j:commandLink>
            </h:panelGrid>
        </t:panelTab>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonAceptarTomaCitologia" columnClasses="panelGridBotones">
        <h:panelGroup>
          <a4j:commandButton value="Guardar" styleClass="boton_fieldset" reRender="panelGridTomaCitologiaTab"
            disabled="#{tomaCitologiaBean.modoConsulta}"
                             action="#{tomaCitologiaBean.aceptar}"></a4j:commandButton>
        </h:panelGroup>
        <f:subview id="generarCitologia" rendered="#{tomaCitologiaBean.generoCitologia}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
      
         <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionTomaCitologiaMsg2"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationTomaCitologiaMsg2" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
 
 <h:panelGrid>
      <h:commandLink action="#{tomaCitologiaBean.volverConsulta}" immediate="true">
        <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
    </h:panelGrid>
        
      </t:panelTabbedPane>
      
       <script type="text/javascript">
  document.forms['body:formTomaProcedimientoCitologia'].elements[6].focus(); 
  </script>
</h:panelGrid>