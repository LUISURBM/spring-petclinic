<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
             id="panelGridRegistrarSeguimientoAsesoriaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuarioAsesoria.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneRegistrarSeguimiento" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabRegistrarSeguimiento" label="Seguimiento">
      <a4j:outputPanel id="ajaxRegionMessageSeguimiento" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformationSeguimiento" showSummary="false" errorClass="error" globalOnly="true"
                    layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
        <t:htmlTag value="br"/>
      </a4j:outputPanel>
      <s:fieldset legend="Ver Resumen Asesoria" styleClass="fieldset">
        <a4j:commandLink action="#{registrarSeguimientoAviseBean.generarResumenAsesoria}"
                         reRender="panelGridRegistrarSeguimientoAsesoriaTab" immediate="true" title="Resumen Asesoria">
          <t:graphicImage alt="Resumen Asesoria" title="Resumen Asesoria" border="0" 
                          url="/comun/imagenes/pdfIcon.png"/>
        </a4j:commandLink>
      </s:fieldset>
      <s:fieldset legend="Informaci�n" id="fieldSetRegistrarInformacion" styleClass="fieldset">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionRegistrarInformacion" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Semanas Estimadas " />
          <h:outputText value=""/>
          <h:outputText value=" Fecha Ecograf�a" />
          <h:outputText value=""/>
          <h:outputText value=" Semanas Ecograf�a" />
          <h:outputText value=""/>
          <h:inputText id="semanas" maxlength="3" value="#{registrarSeguimientoAviseBean.seguimiento.hsansemest}" style="width:30px"></h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="semanas" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <t:inputCalendar id="fechaEcografia" title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                           monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                           currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                           value="#{registrarSeguimientoAviseBean.seguimiento.hsadfececo}" popupTodayString="Hoy"
                           popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                           align="top"></t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaEcografia" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="semanasEco" maxlength="3" value="#{registrarSeguimientoAviseBean.seguimiento.hsansemeco}" style="width:30px"></h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="semanasEco" styleClass="errorMessage"/>
          </a4j:outputPanel>
           <h:outputText value="M�todo de Anticoncepci�n "/>
          <h:outputText value=""/>
          <h:outputText value=" "/>
          <h:outputText value=""/>   
          <h:outputText value=""/>
          <h:outputText value=""/>
           <a4j:region renderRegionOnly="false"  >
          <h:panelGroup>
          <h:selectOneMenu id="menuMetodo" onkeydown="return blockEnter(event);" immediate="true"
                           value="#{registrarSeguimientoAviseBean.seguimiento.hsacmetant}"
                           valueChangeListener="#{registrarSeguimientoAviseBean.setConfirmaMetodoSelect}">
            <f:selectItems value="#{registrarSeguimientoAviseBean.listMetodoPlanificacion}"/>
                   <a4j:support id="supportMetodo" action="#{registrarSeguimientoAviseBean.changeMetodo}"
                               reRender="panelConfirmaRadio" event="onchange"
                               immediate="true">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuMetodo" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGroup>
          </a4j:region>
          <h:outputText value=""/>
        
          <h:panelGroup id="panelConfirmaRadio">
            <h:outputText id="outputTextConfirma" value="Confirma Procedimiento Institucional" style="font-size:10px" 
                          rendered="#{registrarSeguimientoAviseBean.renderConfirmaMetodo}"/>
              <h:panelGrid columns="2" id="panelMenuAceptaProcedi">
                <h:selectOneRadio id="mnuAceptaProcedimientos"
                                  rendered="#{registrarSeguimientoAviseBean.renderConfirmaMetodo}" immediate="true"
                                  value="#{registrarSeguimientoAviseBean.seguimiento.hsaccousan}"
                                  valueChangeListener="#{registrarSeguimientoAviseBean.setConfirmaOtraInstiSelect}">
                  <f:selectItems value="#{registrarSeguimientoAviseBean.lstOpciones}"/>
                   <a4j:support id="supportConfirma" action="#{registrarSeguimientoAviseBean.changeInstitucion}"
                               reRender="panelTextCualInstitucion" event="onclick"
                               immediate="true">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAceptaProcedimientos" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </h:panelGroup>

         <h:panelGrid id="panelTextCualInstitucion" columns="1">
            <h:outputText value="Cu�l Instituci�n? " styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderConfirmaInstitucion}"/>
            <h:inputText id="itCualInstitu" rendered="#{registrarSeguimientoAviseBean.renderConfirmaInstitucion}"
                         onkeydown="return blockEnter(event);" maxlength="60" required="true"
                         value="#{registrarSeguimientoAviseBean.seguimiento.hsacotrins}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderConfirmaInstitucion}">
              <t:message for="itCualInstitu" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>




        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Seguimiento " id="fieldSetRegistrarSeguimiento" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionRegistrarSegumiento" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Seguimiento " styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:inputTextarea id="textAreaSeguimiento" required="true"
                           value="#{registrarSeguimientoAviseBean.seguimiento.hsacseguim}"
                           style="width:650px;height:70px"></h:inputTextarea>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textAreaSeguimiento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
        <f:subview id="generarResumenAsesoria" rendered="#{registrarSeguimientoAviseBean.generoReporte}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>
      </s:fieldset>
      <s:fieldset legend="Acci�n " id="fieldSetConductaAsegir" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConductaASeguir"
                     styleClass="labelTextInfo">
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkRemitirConsultaIlve" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       value="#{registrarSeguimientoAviseBean.renderRemitirIlve}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderRemitirIlve}">
                <a4j:support id="supportCheckRemitirConsultaIlve" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Opta Ilve Institucional  "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextServicio" columns="2">
            <h:outputText value="Tipo Servicio " styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderRemitirIlve}"/>
            <h:selectOneMenu id="menuIve" rendered="#{registrarSeguimientoAviseBean.renderRemitirIlve}"
                             onkeydown="return blockEnter(event);"
                             value="#{registrarSeguimientoAviseBean.seguimiento.hsacconduc}">
              <f:selectItems value="#{registrarSeguimientoAviseBean.listConductas}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderRemitirIlve}">
              <t:message for="menuIve" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkIndecision" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarSeguimientoAviseBean.renderRemitirIlve || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       value="#{registrarSeguimientoAviseBean.renderIndecision}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderIndecision}">
                <a4j:support id="supportCheckIndecision" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Indecisi�n  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkCostoAlto" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderRemitirIlve || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       value="#{registrarSeguimientoAviseBean.renderCostoAlto}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderCostoAlto}">
                <a4j:support id="supportCheckCostoAlto" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Capacidad de pago limitada  "/>
            </h:panelGroup>
          </a4j:region>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkUsaEPS" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderRemitirIlve || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       value="#{registrarSeguimientoAviseBean.renderEps}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderEps}">
                <a4j:support id="supportCheckUsaEPS" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Va a usar EPS  "/>
            </h:panelGroup>
          </a4j:region>
               <h:panelGrid id="panelTextCualEps" columns="1">
            <h:outputText value="Cu�l Eps? " styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderEps}"/>
            <h:selectOneMenu id="menuEps" required="true" rendered="#{registrarSeguimientoAviseBean.renderEps}"
                             onkeydown="return blockEnter(event);"
                             value="#{registrarSeguimientoAviseBean.seguimiento.hsaclugpro}">
              <f:selectItems value="#{registrarSeguimientoAviseBean.listEntidades}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderEps}">
              <t:message for="menuEps" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          
          <a4j:region renderRegionOnly="false">
            <h:outputText value=""/>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkEmbarazoMayor" onkeydown="return blockEnter(event);"
                                       value="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderRemitirIlve || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderEmbarazoMayor}">
                <a4j:support id="supportCheckEmbarazoMayor" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Remisi�n por edad gestacional � Condici�n Medica  "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextEdadGestacional" columns="9">
            <h:outputText value="Cuantas Semanas? " styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"/>
            <h:inputText id="itEdadGestacional" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"
                         onkeydown="return blockEnter(event);"  required="true" style="width:40px"
                         value="#{registrarSeguimientoAviseBean.seguimiento.hsanedages}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}">
              <t:message for="itEdadGestacional" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Nombre Instituci�n" styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"/>
            <h:inputText id="itNombreInstitucion" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"
                         onkeydown="return blockEnter(event);" required="true" style="width:100px"
                         value="#{registrarSeguimientoAviseBean.seguimiento.hsacinsrem}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}">
              <t:message for="itNombreInstitucion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Nombre de Contacto" styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"/>
            <h:inputText id="itContacto" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"
                         onkeydown="return blockEnter(event);" required="true" style="width:100px"
                         value="#{registrarSeguimientoAviseBean.seguimiento.hsaccontac}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}">
              <t:message for="itContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Telefono de Contacto" styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"/>
            <h:inputText id="itTelefonoContacto" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"
                         onkeydown="return blockEnter(event);" required="true" style="width:100px"
                         value="#{registrarSeguimientoAviseBean.seguimiento.hsantelcon}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}">
              <t:message for="itTelefonoContacto" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Confirma Procedimiento" styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}"/>
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" id="panelMenuAceptaProce">
                <h:selectOneRadio id="mnuAceptaProcedimiento"
                                  rendered="#{registrarSeguimientoAviseBean.renderEmbarazoMayor}" immediate="true"
                                  value="#{registrarSeguimientoAviseBean.seguimiento.hsacreapro}">
                  <f:selectItems value="#{registrarSeguimientoAviseBean.lstOpciones}"/>
                </h:selectOneRadio>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAceptaProcedimiento" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </a4j:region>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <h:outputText value=""/>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkNoAplicaCausal" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderRemitirIlve || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       value="#{registrarSeguimientoAviseBean.renderAplicaCausal}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderAplicaCausal}">
                <a4j:support id="supportcheckNoAplicaCausal" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  No aplica ninguna causal  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkContinuaEmbarazo" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderRemitirIlve || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderOtraConducta}"
                                       value="#{registrarSeguimientoAviseBean.renderContinuaEmbarazo}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderContinuaEmbarazo}">
                <a4j:support id="supportcheckContinuaEmbarazo" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Desea continuar embarazo  "/>
            </h:panelGroup>
          </a4j:region>
           <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkOtraConducta" onkeydown="return blockEnter(event);"
                                       value="#{registrarSeguimientoAviseBean.renderOtraConducta}"
                                       disabled="#{registrarSeguimientoAviseBean.renderIndecision || registrarSeguimientoAviseBean.renderCostoAlto || registrarSeguimientoAviseBean.renderEps || registrarSeguimientoAviseBean.renderOtraIps || registrarSeguimientoAviseBean.renderEmbarazoMayor || registrarSeguimientoAviseBean.renderAplicaCausal || registrarSeguimientoAviseBean.renderAplazaDecision  || registrarSeguimientoAviseBean.renderContinuaEmbarazo || registrarSeguimientoAviseBean.renderAplazaDecision || registrarSeguimientoAviseBean.renderRemitirIlve}"
                                       valueChangeListener="#{registrarSeguimientoAviseBean.setRenderOtraConducta}">
                <a4j:support id="supportCheckOtraConducta" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Otro "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextCualConducta" columns="1">
            <h:outputText value="Cu�l Acci�n? " styleClass="labelTextOblig"
                          rendered="#{registrarSeguimientoAviseBean.renderOtraConducta}"/>
            <h:inputText id="itCualConducta" rendered="#{registrarSeguimientoAviseBean.renderOtraConducta}"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarSeguimientoAviseBean.seguimiento.hsacnmbotr}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarSeguimientoAviseBean.renderRemisionOtra}">
              <t:message for="itCualConducta" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </h:panelGrid>
        <t:htmlTag value="br"/>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionRegistroSeguimiento" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsSeguimiento" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonRegistrarSeguimiento" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                           action="#{registrarSeguimientoAviseBean.registrarSeguimiento}">
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