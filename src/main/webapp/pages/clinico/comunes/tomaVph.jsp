<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridTomaVphTab" styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPanelTomaVph" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionTomaVphMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationTomaVphMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
        <t:panelTab id="panelTabTomaVph" label="Toma Vph">
           <s:fieldset legend="Informaci�n General Usuaria " id="fieldAsesoriaTomaVph" styleClass="fieldset">
  
    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioTomaVph" rowClasses="labelText,labelTextInfo">
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
             <a4j:commandLink action="#{tomaVphBean.cargarDatos}" 
                reRender="panelGridTomaVphTab" immediate="true" title="Obtener Datos">
            <t:graphicImage alt="Obtener Datos" title="Obtener Datos" border="0" url="/comun/imagenes/cargar_datos.jpg" />
          </a4j:commandLink>
          </a4j:region>
          <t:htmlTag value="br"/>
          
          
             
          <s:fieldset legend="Datos Toma VPH" id="fieldSetInfoProcedimientosCitologia" styleClass="fieldset">
        
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridGinecologicoCitologia" rowClasses="labelText,labelTextInfo">
                
              <h:outputText value="Esquema Tipificaci�n" styleClass="labelTextOblig"/>
              <h:outputText value="M�todo Planificaci�n " styleClass="labelTextOblig"/>
               <h:panelGroup id="panelTextTiempoUso">
                <h:outputText value = "Tiempo de uso (a�os)"  styleClass="labelTextOblig"
                    rendered="#{tomaVphBean.renderTiempoUso}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextCualMetodo">
                <h:outputText value="�Cu�l otro M�todo?" styleClass="labelTextOblig"
                    rendered="#{tomaVphBean.mostrarotrometodo}"/>
              </h:panelGroup>
             
              <h:panelGroup>
                <h:selectOneMenu id="menuEsquemaVPH" onkeydown="return blockEnter(event);" 
                                 required="true" disabled="#{tomaVphBean.modoConsulta}"
                                 immediate="true" value="#{tomaVphBean.toma.hvtcesquem}">
                  <f:selectItems value="#{tomaVphBean.lstEsquema}"/>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuEsquemaVPH" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="menuMetodosPlanificacion" onkeydown="return blockEnter(event);" required="true" immediate="true"
                                   disabled="#{tomaVphBean.modoConsulta}"
                                   valueChangeListener="#{tomaVphBean.setHvtcmetpla}"
                                   value="#{tomaVphBean.toma.hvtcmetpla}">
                    <f:selectItems value="#{tomaVphBean.lstMetodos}"/>
                    <a4j:support id="supportMetodoPlanificacion" event="onchange"
                                 action="#{tomaVphBean.changeMetodo}"
                                 reRender="panelTextCualMetodo,panelInputCualMetodo,panelTextTiempoUso,panelInputTiempoUso" 
                                 immediate="true">
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
                             disabled="#{tomaVphBean.modoConsulta}"
                             rendered="#{tomaVphBean.renderTiempoUso}" title="Tiempo de uso del m�todo en a�os"
                             value="#{tomaVphBean.toma.hvtntiemet}" style="width:50px" maxlength="4">
                             <f:validator validatorId="validateTiempoMetodo"/>
                           </h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itTiempoUso" styleClass="errorMessage"/>
                </a4j:outputPanel>
               </h:panelGroup>
            <h:panelGroup id="panelInputCualMetodo">
                <h:inputText id="itCual"  onkeydown="return blockEnter(event);" 
                            required="true" maxlength="60" disabled="#{tomaVphBean.modoConsulta}"
                            rendered="#{tomaVphBean.mostrarotrometodo}"
                            value="#{tomaVphBean.toma.hvtcotrmet}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCual" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
               
              <h:outputText value="Gestaci�n " styleClass="labelTextOblig"/>
              <h:outputText value="Partos " styleClass="labelTextOblig"/>
              <h:outputText value="Abortos " styleClass="labelTextOblig"/>
              <h:outputText value = "Consecutivo VPH"/>
             
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:inputText id="mnuNumGestacion" immediate="true" 
                                disabled="#{tomaVphBean.modoConsulta}"
                               onkeydown="return blockEnter(event);"
                               required="true" title="Numero de Gestaciones"
                               maxlength="2" style="width:30px" 
                               value="#{tomaVphBean.toma.hvtngestac}">
                 </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuNumGestacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
               <a4j:region renderRegionOnly="false">
              <h:panelGroup id="panelNumPartos">
                <h:panelGroup>
                  <h:inputText id="itNumPartos" onkeydown="return blockEnter(event);" 
                               immediate="true"
                               required="#{!tomaVphBean.esCeroPartos}"
                               title="Numero de Partos" 
                               disabled="#{tomaVphBean.modoConsulta}"
                               value="#{tomaVphBean.toma.hvtnpartos}" 
                               valueChangeListener="#{tomaVphBean.setHvtnpartos}"
                               maxlength="2" style="width:30px">
                                <a4j:support id="supportNumPartos"  immediate="true"  event="onchange"
                                 action="#{tomaVphBean.changeNumeroPartos}"
                                 reRender="panelCalendarFechaParto">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumPartos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelNumAbortos">
                <h:panelGroup>
                    <h:inputText id="itNumAbortos" onkeydown="return blockEnter(event);" required="true"
                               title="Numero de Abortos" maxlength="2" style="width:30px"
                               disabled="#{tomaVphBean.modoConsulta}"
                               value="#{tomaVphBean.toma.hvtnaborto}">
                    </h:inputText>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumAbortos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText value = "#{tomaVphBean.consecCitologia}"/>
              
              <h:outputText value="F.U.M " styleClass="labelTextOblig"/>
              <h:outputText value="F.U.P " styleClass="labelTextOblig"/>
              <h:outputText value="Edad Relaciones " styleClass="labelTextOblig"/>
              <h:outputText value=""/>

              <h:panelGroup id = "panelTextDateRegla">
                  <t:inputCalendar id="calendarUltimaRegla" disabled="#{tomaVphBean.modoConsulta}"
                                 title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{tomaVphBean.toma.hvtdultmen}" popupTodayString="Hoy"
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
                                 disabled="#{tomaVphBean.esCeroGestaciones || tomaVphBean.modoConsulta || tomaVphBean.esCeroPartos}"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{tomaVphBean.toma.hvtdultpar}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                 renderPopupButtonAsImage="true" align="top" required="#{!tomaVphBean.esCeroPartos}">
                                 <f:validator validatorId="dateMenorIgualValidator"/>        
                            </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="calendarUltimoParto" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itEdadPrimeraRelacion" required="true" 
                             onkeydown="return blockEnter(event);"
                             disabled="#{tomaVphBean.modoConsulta}" maxlength="2"
                             value="#{tomaVphBean.toma.hvtnedarel}" style="width:30px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itEdadPrimeraRelacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
              
              <h:outputText value="�Esta Usted Embarazada? " styleClass="labelTextOblig"/>
              <h:outputText value="�Planea Embarazo antes de un a�o? " styleClass="labelTextOblig"/>
              <h:outputText value="Complet� esquema vacuna VPH " styleClass="labelTextOblig"/>
              <h:outputText value = "Lactancia Actual"/>
              
              <h:panelGroup>
                <h:selectOneRadio id="mnuEmbarazada" onkeydown="return blockEnter(event);" required="true" 
                                  disabled="#{tomaVphBean.modoConsulta}"
                                  value="#{tomaVphBean.toma.hvtcembara}">
                  <f:selectItems value="#{tomaVphBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuEmbarazada" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                  <h:selectOneRadio id="mnuPlaneaEmbarazo" onkeydown="return blockEnter(event);" required="true" 
                                    disabled="#{tomaVphBean.modoConsulta}"
                                    value="#{tomaVphBean.toma.hvtcplaemb}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuPlaneaEmbarazo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
              </h:panelGroup>
              <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                      <h:selectOneRadio id="mnuVph" required="true" 
                                        value="#{tomaVphBean.toma.hvtccomvph}"
                                        onkeydown="return blockEnter(event);"
                                        disabled="#{tomaVphBean.modoConsulta}" immediate="true">
                          <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      </h:selectOneRadio>
                      <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuVph" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                  </h:panelGroup>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                      <h:selectOneRadio id = "mnuLactancia" required="true"
                                        disabled="#{tomaVphBean.modoConsulta}"
                                        value = "#{tomaVphBean.toma.hvtclactan}">
                          <f:selectItems value = "#{tomaVphBean.lstOpcionesvph}"/>
                      </h:selectOneRadio>     
                      <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuLactancia" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                  </h:panelGroup>
              </a4j:region>
              
              <h:outputText value="F.U.C"/>
              <h:panelGroup id="panelResultadoCitologia">
                <h:outputText value="Resultado Citolog�a" styleClass="labelTextOblig" rendered="#{tomaVphBean.mostrarResultado}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextHallazgos">
                <h:outputText value="�Cuales Otros Hallazgos?" styleClass="labelTextOblig"
                              rendered="#{tomaVphBean.mostrarhallazgos}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaCitologia" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaVphBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" immediate="true" value="#{tomaVphBean.toma.hvtdultcit}"
                                   valueChangeListener="#{tomaVphBean.setHvtdultcit}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                    <a4j:support id="supportUltimaCitologia" event="onchange" immediate="true"
                                 reRender="panelResultadoCitologia,panelMenuResul,panelTextHallazgos,panelInputHallazgos"
                                 action="#{tomaVphBean.ChangeFechaCitologia}" oncomplete="jsFunctionCitologia()">
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
                                   rendered="#{tomaVphBean.mostrarResultado}"
                                   binding="#{tomaVphBean.mnuResultado}"
                                   value="#{tomaVphBean.toma.hvtcultres}"
                                   valueChangeListener="#{tomaVphBean.setHvtcultres}"
                                   disabled="#{tomaVphBean.modoConsulta}">
                    <f:selectItems value="#{tomaVphBean.lstResultado}"/>
                    <a4j:support id="supportResultado" event="onchange"
                                 action="#{tomaVphBean.changeResultado}"
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
                             disabled="#{tomaVphBean.modoConsulta}"
                             rendered="#{tomaVphBean.mostrarhallazgos}"
                             value="#{tomaVphBean.toma.hvtcotrhal}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itOtrosHallazgos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
                
              <h:outputText value = "F.U.T"/>
              <h:panelGroup id="panelResultadoTipificacion">
                <h:outputText value="Resultado Tipificaci�n" styleClass="labelTextOblig" rendered="#{tomaVphBean.mostrarVphResultado}"/>
                <h:outputText value=" " rendered="#{!tomaVphBean.mostrarVphResultado}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value=""/>
              
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <t:inputCalendar id="calendarUltimaTipificacion" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaVphBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" immediate="true" value="#{tomaVphBean.toma.hvtdtipifi}"
                                   valueChangeListener="#{tomaVphBean.setHvtdtipifi}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top">
                                   <f:validator validatorId="dateMenorIgualValidator"/>      
                    <a4j:support id="supportUltimaTipificacion" event="onchange" immediate="true"
                                 reRender="panelResultadoTipificacion, panelMenuResulTipificacion"
                                 action="#{tomaVphBean.ChangeFechaTipificacion}" oncomplete="jsFunctionTipificacion()">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarUltimaTipificacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup id="panelMenuResulTipificacion">
                  <h:selectOneMenu id="mnuResultadoTipificacion" required="true" immediate="true"
                                   onkeydown="return blockEnter(event);"
                                   rendered="#{tomaVphBean.mostrarVphResultado}"
                                   value="#{tomaVphBean.toma.hvtcvphresul}"
                                   disabled="#{tomaVphBean.modoConsulta}">
                    <f:selectItems value="#{tomaVphBean.lstVphResultado}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuResultadoTipificacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:outputText value=""/>
              <h:outputText value=""/>
              
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
                                    value="#{tomaVphBean.toma.hvtcpningu}"
                                    disabled="#{tomaVphBean.modoConsulta}"
                                    valueChangeListener="#{tomaVphBean.setHvtcpningu}">
                    <f:selectItems value="#{tomaVphBean.lstOpcionesInvertido}"/>
                    <a4j:support id="supportProcedimientos" event="onclick"
                                 action="#{tomaVphBean.changeProcedimiento}"
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
                           rendered="#{tomaVphBean.mostrarProcedimiento}" width="100%" id="panelProcedimientos"
                           rowClasses="labelText,labelTextInfo">
                           
                           <h:outputText value="Cauterizaci�n" styleClass="labelTextOblig"/>
                            <h:panelGroup id="panelTextFechaCauterizacion">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaCauterizacion}"/>
                </h:panelGroup>
                
                <h:outputText value="Histerectomia" styleClass="labelTextOblig"/>
                 <h:panelGroup id="panelTextFechaHisterectomia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaHisterectomia}"/>
                </h:panelGroup>
                
                 <h:outputText value="Conizaci�n" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaConizacion">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaConizacion}"/>
                </h:panelGroup>
                
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuCauterizacion" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      binding="#{tomaVphBean.mnuCauterizacion}"
                                      value="#{tomaVphBean.toma.hvtcpcaute}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpcaute}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportCauterizacion" event="onclick"
                                   action="#{tomaVphBean.changeCauterizacion}"
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
                                   onkeydown="return blockEnter(event);" disabled="#{tomaVphBean.modoConsulta}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpcaute}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaCauterizacion}" required="false">
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
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      value="#{tomaVphBean.toma.hvtcphiste}"
                                      binding="#{tomaVphBean.mnuHistectomia}"
                                      valueChangeListener="#{tomaVphBean.setHvtcphiste}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportHistecrectomia" event="onclick"
                                   action="#{tomaVphBean.changeHisterectomia}"
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
                                   onkeydown="return blockEnter(event);" disabled="#{tomaVphBean.modoConsulta}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdphiste}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaHisterectomia}" required="false">
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
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      value="#{tomaVphBean.toma.hvtcpconiz}"
                                      binding="#{tomaVphBean.mnuConizacion}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpconiz}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportConizacion" event="onclick"
                                   action="#{tomaVphBean.changeConizacion}"
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
                                   disabled="#{tomaVphBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpconiz}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaConizacion}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                    </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarConizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                <h:outputText value="Radioterapia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaRadioterapia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaRadioterapia}"/>
                </h:panelGroup>
                
                 <h:outputText value="Biopsia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaBiopsia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaBiopsia}"/>
                </h:panelGroup>
                
                <h:outputText value="Crioterapia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaCrioterapia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaCrioterapia}"/>
                </h:panelGroup>
                
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuRadioterapia" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      value="#{tomaVphBean.toma.hvtcpradio}"
                                      binding="#{tomaVphBean.mnuRadioterapia}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpradio}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportRadioterapia" event="onclick"
                                   action="#{tomaVphBean.changeRadioterapia}"
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
                                   disabled="#{tomaVphBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpradio}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaRadioterapia}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarRadioTerapia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                 <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuBiopsia" required="true" value="#{tomaVphBean.toma.hvtcpbiops}"
                                      onkeydown="return blockEnter(event);"
                                      immediate="true" disabled="#{tomaVphBean.modoConsulta}"
                                      binding="#{tomaVphBean.mnuBiopsia}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpbiops}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportBiopsia" event="onclick"
                                   action="#{tomaVphBean.changeBiopsia}"
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
                                   onkeydown="return blockEnter(event);" disabled="#{tomaVphBean.modoConsulta}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpbiops}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaBiopsia}" required="false">
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
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      binding="#{tomaVphBean.mnuCrioterapia}"
                                      value="#{tomaVphBean.toma.hvtcpcriot}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpcriot}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportCrioterapia" event="onclick"
                                   action="#{tomaVphBean.changeCrioterapia}"
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
                                   disabled="#{tomaVphBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpcriot}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   rendered="#{tomaVphBean.mostrarFechaCrioterapia}"
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
                                rendered="#{tomaVphBean.mostrarFechaATA}"/>
                </h:panelGroup>
                
                <h:outputText value="Colposcopia" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaColposcopia">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaVaporizacion}"/>
                </h:panelGroup>
                
                <h:outputText value="Vaporizaci�n" styleClass="labelTextOblig"/>
                 <h:panelGroup id="panelTextFechaVaporizacion">
                  <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaVaporizacion}"/>
                </h:panelGroup>
                
                 <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuATA" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}" binding="#{tomaVphBean.mnuATA}"
                                      value="#{tomaVphBean.toma.hvtcpata}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpata}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportAta" event="onclick"
                                   action="#{tomaVphBean.changeATA}" reRender="panelTextFechaATA,panelFechaATA">
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
                                   disabled="#{tomaVphBean.modoConsulta}" onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpata}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaATA}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarATA" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuColposcopia" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}" 
                                      binding="#{tomaVphBean.mnuColposcopia}"
                                      value="#{tomaVphBean.toma.hvtcpcolpo}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpcolpo}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportColposcopia" event="onclick"
                                   action="#{tomaVphBean.changeColposcopia}" 
                                   reRender="panelTextFechaColposcopia,panelFechaColposcopia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuColposcopia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelFechaColposcopia">
                  <t:inputCalendar id="calendarColposcopia" title="Formato: dd/mm/yyyy"
                                   disabled="#{tomaVphBean.modoConsulta}" 
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpcolpo}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaColposcopia}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarColposcopia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuVaporizacion" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}" 
                                      binding="#{tomaVphBean.mnuVaporizacion}"
                                      value="#{tomaVphBean.toma.hvtcpvapor}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpvapor}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportVaporizacion" event="onclick"
                                   action="#{tomaVphBean.changeVaporizacion}" 
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
                                   disabled="#{tomaVphBean.modoConsulta}" 
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdpvapor}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaVaporizacion}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarVaporizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

                 <h:outputText value="Tratamiento Hormonal" styleClass="labelTextOblig"/>
                 <h:panelGroup id="panelTextFechaHormonal">
                     <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaHormonal}"/>
                </h:panelGroup>

                <h:outputText value="Otro Procedimiento" styleClass="labelTextOblig"/>
                <h:panelGroup id="panelTextFechaOtro">
                    <h:outputText value="Fecha" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaOtro}"/>
                </h:panelGroup>
                
                <h:panelGroup id="panelTextCualOtro">
                    <h:outputText value="Cu�l Otro Procedimiento?" styleClass="labelTextOblig"
                                rendered="#{tomaVphBean.mostrarFechaOtro}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                
               <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuHormonal" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}" 
                                      binding="#{tomaVphBean.mnuHormonal}"
                                      value="#{tomaVphBean.toma.hvtcphormo}"
                                      valueChangeListener="#{tomaVphBean.setHvtcphormo}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportHormonal" event="onclick" 
                                   action="#{tomaVphBean.changeHormonal}" 
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
                                   disabled="#{tomaVphBean.modoConsulta}" 
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" value="#{tomaVphBean.toma.hvtdphormo}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaHormonal}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>
                            </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarHormonal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>

                    <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuOtro" required="true" immediate="true" 
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      binding="#{tomaVphBean.mnuOtro}" value="#{tomaVphBean.toma.hvtcpotro}"
                                      valueChangeListener="#{tomaVphBean.setHvtcpotro}">
                      <f:selectItems value="#{tomaVphBean.lstOpcionesvph}"/>
                      <a4j:support id="supportOtros" event="onclick"
                                   action="#{tomaVphBean.changeOtroProcedimiento}"
                                   reRender="panelTextFechaOtro,panelTextCualOtro,panelFechaOtro,panelCualOtroProcedimiento">
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
                                   disabled="#{tomaVphBean.modoConsulta}" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{tomaVphBean.toma.hvtdpotro}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                   renderPopupButtonAsImage="true" align="top"
                                   rendered="#{tomaVphBean.mostrarFechaOtro}" required="false">
                                   <f:validator validatorId="dateMenorIgualValidator"/>        
                                </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="calendarOtro" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                <h:panelGroup id="panelCualOtroProcedimiento">
                  <h:inputText id="inputOtro" rendered="#{tomaVphBean.mostrarFechaOtro}" 
                               onkeydown="return blockEnter(event);"
                               disabled="#{tomaVphBean.modoConsulta}" 
                               value="#{tomaVphBean.toma.hvtcpdotro}"
                               maxlength="20"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputOtro" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                
              </h:panelGrid>
            </h:panelGrid>
          </s:fieldset>
          
          <s:fieldset legend="Informaci�n Citologia" id="fieldSetInfoAspectodelCuello" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAspectoCuello"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Aspecto Cuello" styleClass="labelTextOblig"
                            rendered="#{!tomaVphBean.temporal}"/>
              <h:outputText value="Tomada por" styleClass="labelTextOblig" rendered="#{false}"/>
              <h:panelGroup>
                <h:selectManyCheckbox id="mnuCuello" required="true" immediate="true" layout="pageDirection"
                                      onkeydown="return blockEnter(event);"
                                      disabled="#{tomaVphBean.modoConsulta}"
                                      rendered="#{!tomaVphBean.temporal}"
                                      value="#{tomaVphBean.lstAspectoSelect}">
                  <f:selectItems value="#{tomaVphBean.lstAspecto}"/>
                </h:selectManyCheckbox>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuCuello" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup  rendered="#{false}">
                <h:selectOneMenu id="mnuTomada" onkeydown="return blockEnter(event);"
                      required="true" disabled="#{tomaVphBean.modoConsulta}"
                      value="#{tomaVphBean.toma.hvtctomada}">
                  <f:selectItems value="#{tomaVphBean.lstTomada}"/>
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
                                 disabled="#{tomaVphBean.modoConsulta}"
                                 value="#{tomaVphBean.toma.hvtcobstom}">
                            <f:validator validatorId="cadena.stringValidatorNoPuntuacion"/>
                            <f:validateLength maximum="600"/>     
                      </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itObservacionesToma" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
           </s:fieldset>
          
          
            <a4j:commandLink id="mostrarImpresion" action="#{tomaVphBean.generarPDF}"
                           rendered="#{tomaVphBean.modoConsulta}"
                             reRender="panelGridTomaVphTab" immediate="true"
                             title="Imprimir Toma Citologia">
              <t:graphicImage alt="Imprimir Toma Citologia" title="Imprimir Toma Citologia" border="0"
                              url="/comun/imagenes/print_Spa.gif"/>
            </a4j:commandLink>
        </t:panelTab>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonAceptarTomaVph" columnClasses="panelGridBotones">
        <h:panelGroup>
          <a4j:commandButton value="Guardar" styleClass="boton_fieldset" reRender="panelGridTomaVphTab"
            disabled="#{tomaVphBean.modoConsulta}"
                             action="#{tomaVphBean.aceptar}"></a4j:commandButton>
        </h:panelGroup>
        <f:subview id="generarVph" rendered="#{tomaVphBean.generoVph}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
          </f:verbatim>
        </f:subview>
      </h:panelGrid>
      
         <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionTomaVphMsg2"
                                 ajaxRendered="true">
                  <t:messages id="msgInformationTomaVphMsg2" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
 
 <h:panelGrid>
      <h:commandLink action="#{tomaVphBean.volverConsulta}" immediate="true">
        <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
    </h:panelGrid>
        
      </t:panelTabbedPane>
      
       <script type="text/javascript">
  document.forms['body:formTomaProcedimientoCitologia'].elements[6].focus(); 
  </script>
</h:panelGrid>