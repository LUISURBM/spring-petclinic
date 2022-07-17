<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
             id="panelGridRegistrarUsuarioAsesoriaTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuarioAsesoria.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
                     selectedIndex="#{registrarAsesoriaAviseBean.selectedIndex}"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosUsuario" label="Asesoría en Opciones">
      <a4j:outputPanel id="ajaxRegionMessage" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformation" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                    infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
        <t:htmlTag value="br"/>
      </a4j:outputPanel>
      <s:fieldset legend="Conocimiento del programa " id="fieldSetConocimientoPrograma" styleClass="fieldset">
        <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionConcocimientoPrograma" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Conocimiento del programa " styleClass="labelTextOblig"/>
          <h:outputText/>
          <h:panelGroup id="panelTextCualProgramaAvise">
            <h:outputText value="Cuál? " styleClass="labelTextOblig" 
                          rendered="#{registrarAsesoriaAviseBean.renderProgramaAvise}"/>
          </h:panelGroup>
          <h:outputText/>
           <h:outputText value = "Fecha Asesoría"/>
          <h:outputText/>
          <h:outputText/>
          <h:outputText/>
          <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="menuConocimientoAvise" required="true" immediate="true"
                             value="#{registrarAsesoriaAviseBean.asesoria.havnconavs}"
                             valueChangeListener="#{registrarAsesoriaAviseBean.setHavnconavs}"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{registrarAsesoriaAviseBean.listConocimientoAvise}"/>
              <a4j:support id="supportConocimientoAvise" event="onchange" immediate="true"
                           action="#{registrarAsesoriaAviseBean.changeConocimientoAvise}"
                           reRender="panelTextCualProgramaAvise,panelInputCualProgramaAvise">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneMenu>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuConocimientoAvise" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id="panelInputCualProgramaAvise">
            <h:inputText id="itCualProgramaAvise" onkeydown="return blockEnter(event);" maxlength="50" required="true"
                         rendered="#{registrarAsesoriaAviseBean.renderProgramaAvise}"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcotrcon}"></h:inputText>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itCualProgramaAvise" styleClass="errorMessage"/>
          </a4j:outputPanel>
                 <t:inputCalendar id="fechaAsesoria" 
                           monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" 
                           title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                           renderAsPopup="true" disabled="false"
                           value="#{registrarAsesoriaAviseBean.asesoria.id.havdfecase}"
                           popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                           maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                           renderPopupButtonAsImage="true" align="top" >
            <f:validator validatorId="dateMenorActualValidator"/>
          </t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Datos Asesoria " id="fieldSetInformacionAsesoria" styleClass="fieldset">
        <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionInformacionAsesoria" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Intervención en Asesoria" styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:outputText value=""/>
          <h:outputText value=" "/>
          <h:panelGroup id="panelTextDetalleAsesoria">
            <h:outputText value="Tipo de Intervención " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderDetalle}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <a4j:region renderRegionOnly="false">
            <h:selectOneMenu id="menuIntervencionAsesoria" required="true" immediate="true"
                             value="#{registrarAsesoriaAviseBean.asesoria.havnintase}"
                             valueChangeListener="#{registrarAsesoriaAviseBean.setHavnintase}"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{registrarAsesoriaAviseBean.listIntervencionAsesoria}"/>
              <a4j:support id="supportIntervencionAsesoria" event="onchange"
                           action="#{registrarAsesoriaAviseBean.changeAsesoria}" reRender="fieldSetInformacionAsesoria">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneMenu>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuIntervencionAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:panelGroup id="panelMenuDetalleAsesoria">
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="menuDetalleIntervencion" required="true" immediate="true"
                               value="#{registrarAsesoriaAviseBean.asesoria.havndetint}"
                               binding="#{registrarAsesoriaAviseBean.menuDetalleIntervencion}"
                               valueChangeListener="#{registrarAsesoriaAviseBean.setHavndetint}"
                               rendered="#{registrarAsesoriaAviseBean.renderDetalle}"
                               onkeydown="return blockEnter(event);">
                <f:selectItems value="#{registrarAsesoriaAviseBean.lstDetalleIntervencion}"/>
                <a4j:support id="supportDetalleAsesoria" event="onchange"
                             action="#{registrarAsesoriaAviseBean.changeDetalleAsesoria}"
                             reRender="fieldSetInformacionAsesoria">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
            </a4j:region>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuDetalleIntervencion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value=" "/>
          <h:outputText value=" "/>
          <h:panelGroup>
            <h:outputText value="Agresor/a conocido " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup id="textRelacionAgresor">
            <h:outputText value="Relación " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup id="textParentescoFamiliar">
            <h:outputText value="Parentesco " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle  && registrarAsesoriaAviseBean.renderRelacionFamiliar && !registrarAsesoriaAviseBean.renderRelacionOtra}"/>
            <h:outputText value="Cual Relación? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle  && !registrarAsesoriaAviseBean.renderRelacionFamiliar && registrarAsesoriaAviseBean.renderRelacionOtra}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup id="textCualParentesco">
            <h:outputText value="Cual Parentesco ?" styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle && registrarAsesoriaAviseBean.renderRelacionFamiliar &&  registrarAsesoriaAviseBean.renderOtroParentesco}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="menuAgresorConocido" required="true" immediate="true"
                                rendered="#{registrarAsesoriaAviseBean.renderAgresor  && registrarAsesoriaAviseBean.renderDetalle}"
                                value="#{registrarAsesoriaAviseBean.asesoria.havcagrcon}"
                                valueChangeListener="#{registrarAsesoriaAviseBean.setHavcagrcon}"
                                onkeydown="return blockEnter(event);">
                <f:selectItems value="#{registrarAsesoriaAviseBean.listOpciones}"/>
                <a4j:support id="supportMenuAgresorConocido" event="onclick"
                             action="#{registrarAsesoriaAviseBean.changeAgresorConocido}"
                             reRender="textRelacionAgresor,panelMenuRelacionConocido,msgRelacionAgresor,panelMenuParentescoFamiliar,msgParentescoFamiliar,textParentescoFamiliar,textCualParentesco,paenlInputCualParentesco,msgCualParentesco">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
            </a4j:region>
          </h:panelGroup>
          <h:panelGroup>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor  && registrarAsesoriaAviseBean.renderDetalle}">
              <t:message for="menuAgresorConocido" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelMenuRelacionConocido">
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="menuRelacionConocido" required="true" immediate="true"
                               rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle}"
                               value="#{registrarAsesoriaAviseBean.asesoria.havnrelagr}"
                               valueChangeListener="#{registrarAsesoriaAviseBean.setHavnrelagr}"
                               onkeydown="return blockEnter(event);">
                <f:selectItems value="#{registrarAsesoriaAviseBean.listRelacionAvise}"/>
                <a4j:support id="supportMenuRelacionConocido" event="onchange"
                             action="#{registrarAsesoriaAviseBean.changeRelacionConocido}"
                             reRender="panelMenuParentescoFamiliar,msgParentescoFamiliar,textParentescoFamiliar,textCualParentesco,paenlInputCualParentesco,msgCualParentesco">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
            </a4j:region>
          </h:panelGroup>
          <h:panelGroup id="msgRelacionAgresor">
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle}">
              <t:message for="menuRelacionConocido" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="panelMenuParentescoFamiliar">
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="menuParentescoFamiliar" required="true" immediate="true"
                               rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle  && registrarAsesoriaAviseBean.renderRelacionFamiliar && !registrarAsesoriaAviseBean.renderRelacionOtra}"
                               value="#{registrarAsesoriaAviseBean.asesoria.havnparagr}"
                               valueChangeListener="#{registrarAsesoriaAviseBean.setHavnparagr}"
                               onkeydown="return blockEnter(event);">
                <f:selectItems value="#{registrarAsesoriaAviseBean.listParentescoFamiliar}"/>
                <a4j:support id="supportMenuParentescoFamiliar" event="onchange"
                             action="#{registrarAsesoriaAviseBean.changeParentescoFamiliar}"
                             reRender="textCualParentesco,paenlInputCualParentesco,msgCualParentesco">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
              <h:inputText id="itCualTipoRelacion" onkeydown="return blockEnter(event);" maxlength="12" required="true"
                           rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle  && !registrarAsesoriaAviseBean.renderRelacionFamiliar && registrarAsesoriaAviseBean.renderRelacionOtra}"
                           value="#{registrarAsesoriaAviseBean.asesoria.havcotrrel}"></h:inputText>
            </a4j:region>
          </h:panelGroup>
          <h:panelGroup id="msgParentescoFamiliar">
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle  && registrarAsesoriaAviseBean.renderRelacionFamiliar}">
              <t:message for="menuParentescoFamiliar" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle  && !registrarAsesoriaAviseBean.renderRelacionFamiliar && registrarAsesoriaAviseBean.renderRelacionOtra}">
              <t:message for="itCualTipoRelacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="paenlInputCualParentesco">
            <h:inputText id="itCualParentesco" onkeydown="return blockEnter(event);" maxlength="12" required="true"
                         rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle && registrarAsesoriaAviseBean.renderRelacionFamiliar &&  registrarAsesoriaAviseBean.renderOtroParentesco}"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcotrpar}"></h:inputText>
          </h:panelGroup>
          <h:panelGroup id="msgCualParentesco">
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroAgresor  && registrarAsesoriaAviseBean.renderDetalle}">
              <t:message for="itCualParentesco" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <h:outputText value="Lugar de los hehos " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup id="textCualLugar">
            <h:outputText value="Cúal ?" styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroLugar  && registrarAsesoriaAviseBean.renderDetalle}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup>
            <h:outputText value="Tiempo de ocurrencia del evento " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup id="textCuantosDias">
            <h:outputText value="Cuantos (Días) " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle && registrarAsesoriaAviseBean.renderCuantosDias}"/>
          </h:panelGroup>
          <h:outputText value=" "/>
          <h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="menuLugarHechos" required="true" immediate="true"
                               rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}"
                               value="#{registrarAsesoriaAviseBean.asesoria.havnlugech}"
                               valueChangeListener="#{registrarAsesoriaAviseBean.setHavnlugech}"
                               onkeydown="return blockEnter(event);">
                <f:selectItems value="#{registrarAsesoriaAviseBean.listLugarHechos}"/>
                <a4j:support id="supportMenuLugarHechos" event="onchange"
                             action="#{registrarAsesoriaAviseBean.changeLugarHechos}"
                             reRender="textCualLugar,inputCualLugar,msgCualLugar">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
            </a4j:region>
          </h:panelGroup>
          <h:panelGroup>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}">
              <t:message for="menuLugarHechos" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="inputCualLugar">
            <h:inputText id="itCualLugar" immediate="true"
                         rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroLugar && registrarAsesoriaAviseBean.renderDetalle}"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcotrlug}"></h:inputText>
          </h:panelGroup>
          <h:panelGroup id="msgCualLugar">
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderOtroLugar && registrarAsesoriaAviseBean.renderDetalle}">
              <t:message for="itCualLugar" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="menuTiempoOcurrencia" required="true" immediate="true"
                               rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}"
                               value="#{registrarAsesoriaAviseBean.asesoria.havntieocu}"
                               valueChangeListener="#{registrarAsesoriaAviseBean.setHavntieocu}"
                               onkeydown="return blockEnter(event);">
                <f:selectItems value="#{registrarAsesoriaAviseBean.listTiempoLugarHechos}"/>
                <a4j:support id="supportMenuTiempoOcurrencia" event="onchange"
                             action="#{registrarAsesoriaAviseBean.changeTiempoOcurrencia}"
                             reRender="inputCuantosDias,msgCuantosDias,textCuantosDias">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
            </a4j:region>
          </h:panelGroup>
          <h:panelGroup>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}">
              <t:message for="menuTiempoOcurrencia" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:panelGroup id="inputCuantosDias">
            <h:inputText id="itCuantosDias" immediate="true"
                         rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle && registrarAsesoriaAviseBean.renderCuantosDias}"
                         onkeydown="return blockEnter(event);" maxlength="4" required="true" style="width:40px"
                         value="#{registrarAsesoriaAviseBean.asesoria.havndiaeve}"></h:inputText>
          </h:panelGroup>
          <h:panelGroup id="msgCuantosDias">
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle && registrarAsesoriaAviseBean.renderCuantosDias}">
              <t:message for="itCuantosDias" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionEstablecioAcciones" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Acciones previas " styleClass="labelTextOblig"
                        rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}"/>
         
          <h:outputText value=""/>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelRegionAccionesPrevias"
                       rendered="#{registrarAsesoriaAviseBean.renderAgresor && registrarAsesoriaAviseBean.renderDetalle}">
            <h:panelGroup style="border-style:none;font-size:10px">
              <a4j:region renderRegionOnly="false">
                <h:selectBooleanCheckbox id="checkNingunaAccion" immediate="true" onkeydown="return blockEnter(event);"
                                         valueChangeListener="#{registrarAsesoriaAviseBean.setRenderNingunaAccion}"
                                         value="#{registrarAsesoriaAviseBean.renderNingunaAccion}">
                  <a4j:support id="supportNingunaAccion" event="onclick"
                               action="#{registrarAsesoriaAviseBean.changeNingunaAccion}"
                               reRender="panelRegionEstablecioAcciones">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectBooleanCheckbox>
              </a4j:region>
              <h:outputText value="  Ninguna  "/>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="checkNingunaAccion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkDenunciaAccion" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunaAccion}"
                                       value="#{registrarAsesoriaAviseBean.renderDenunciaAccion}"/>
              <h:outputText value="  Denuncia Penal  "/>
            </h:panelGroup>
            <h:outputText/>
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkBuscoAtencion" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunaAccion}"
                                       value="#{registrarAsesoriaAviseBean.renderAtencionMedica}"/>
              <h:outputText value=" Buscó atención médica"/>
            </h:panelGroup>
            <h:outputText/>
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkBuscoApoyo" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunaAccion}"
                                       value="#{registrarAsesoriaAviseBean.renderApoyoAccion}"/>
              <h:outputText value=" Buscó apoyo de otra persona "/>
            </h:panelGroup>
            <h:outputText/>
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkAnticoncepcionEmergencia" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunaAccion}"
                                       value="#{registrarAsesoriaAviseBean.renderAnticoncepcion}"/>
              <h:outputText value=" Usó anticoncepción emergencia "/>
            </h:panelGroup>
            <h:outputText/>
            <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkOtraAccion" onkeydown="return blockEnter(event);"
                                       binding="#{registrarAsesoriaAviseBean.checkOtraAccion}" 
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunaAccion}"
                                       value="#{registrarAsesoriaAviseBean.renderOtroAccion}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderOtroAccion}" >
                    <a4j:support id="supportOtraAccion" event="onclick"
                               reRender="panelTextOtraAccion">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                                       
                </h:selectBooleanCheckbox>
              <h:outputText value=" Otro "/>
            </h:panelGroup>
            </a4j:region>
            <h:panelGrid id="panelTextOtraAccion" columns="1">
            <h:outputText value="Cual Acción previa? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderOtroAccion}"/>
            <h:inputText id="itOtraAccion" rendered="#{registrarAsesoriaAviseBean.renderOtroAccion}"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true" immediate="true"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcotracc}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarAsesoriaAviseBean.renderNingunaAccion}">
              <t:message for="itOtraAccion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          </h:panelGrid>
        </h:panelGrid>
      </s:fieldset>
         <s:fieldset legend="Documentos Presentados " id="fieldSetDocumentoPresentados" styleClass="fieldset">
        <h:panelGrid columns="10" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionDocumentoPresentado" styleClass="labelTextInfo">
          <h:panelGroup style="border-style:none;font-size:10px">
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkNingunDocumento" onkeydown="return blockEnter(event);" immediate="true"
                                       value="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderNingunDocumento}">
                <a4j:support id="supportNingunDocumento" event="onclick"
                             action="#{registrarAsesoriaAviseBean.changeNingunDocumento}"
                             reRender="panelRegionDocumentoPresentado">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:outputText value="  Ninguno  "/>
          </h:panelGroup>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="checkNingunDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup style="border-style:none;font-size:10px">
            <h:selectBooleanCheckbox id="checkDenuncia" onkeydown="return blockEnter(event);"
                                     disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                     value="#{registrarAsesoriaAviseBean.renderDenuncia}"/>
            <h:outputText value="  Denuncia  "/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <h:selectBooleanCheckbox id="checkPruebaEmbarazo" onkeydown="return blockEnter(event);"
                                     disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                     value="#{registrarAsesoriaAviseBean.renderPrueba}"/>
            <h:outputText value=" Prueba de Embarazo"/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <h:selectBooleanCheckbox id="checkValoracionPsiquica" onkeydown="return blockEnter(event);"
                                     disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                     value="#{registrarAsesoriaAviseBean.renderPsiquica}"/>
            <h:outputText value=" Valoración psicológica "/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <h:selectBooleanCheckbox id="checkCertificadoMedico" onkeydown="return blockEnter(event);"
                                     disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                     value="#{registrarAsesoriaAviseBean.renderCertMedico}"/>
            <h:outputText value=" Certificado médico "/>
          </h:panelGroup>
          <h:outputText/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkEcografia" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                       value="#{registrarAsesoriaAviseBean.renderEcografia}"/>
            </a4j:region>
            <h:outputText value="  Ecografía  "/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkRemisionOtraInstitucion" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                       value="#{registrarAsesoriaAviseBean.renderRemisionOtra}">
                <a4j:support id="supportCheckRemision" event="onclick"
                             reRender="panelTextCualInstitucion,panelInputCualInstitucion">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:outputText value=" Remision de otra institución "/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:panelGrid id="panelTextCualInstitucion" columns="1">
            <h:outputText value="Cuál Institución? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderRemisionOtra}"/>
            <h:inputText id="itCualInstitucion" rendered="#{registrarAsesoriaAviseBean.renderRemisionOtra}"
                         disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}" immediate="true"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcrecnom}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarAsesoriaAviseBean.renderRemisionOtra}">
              <t:message for="itCualInstitucion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <h:outputText value=""/>
          <h:panelGroup style="border-style:none;font-size:10px">
            <a4j:region renderRegionOnly="false">
              <h:selectBooleanCheckbox id="checkOtroDocumento" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                                       value="#{registrarAsesoriaAviseBean.renderOtroDocumento}">
                <a4j:support id="supportCheckOtroDocumento" event="onclick"
                             reRender="panelTextCual,panelInputCualDocumento,panelMsgCualDocumento">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
            </a4j:region>
            <h:outputText value=" Otro "/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:panelGrid id="panelTextCual" columns="1">
            <h:outputText value="Cuál? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderOtroDocumento}"/>
            <h:inputText id="itCualOtro" rendered="#{registrarAsesoriaAviseBean.renderOtroDocumento}"
                         disabled="#{registrarAsesoriaAviseBean.renderNingunDocumento}"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcnomdoc}"></h:inputText>
          </h:panelGrid>
          <h:panelGroup id="panelMsgCualDocumento">
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarAsesoriaAviseBean.renderOtroDocumento}">
              <t:message for="itCualOtro" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      
      <s:fieldset legend="Valoración estado psicoemocional de la usuaria por esferas"
                  id="fieldAreaAfectivaAreaSomaticoPsicoemocional" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="920px"
                     id="panelAreaAfectivaSomaticaPsicoemocional" rowClasses="labelText,labelTextInfo">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="230px"
                       id="panelAreaAfecSomaticatPsicoemocional" rowClasses="standardTable_Row7,standardTable_Row7"
                       style="border-color:#3f3e23;">
            <h:outputText value="Área Afectivo" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:selectManyCheckbox required="true" style="border-style:none;height:300px;" immediate="true"
                                    id="mnuAreaAfectivaPsicoemocional"
                                    value="#{registrarAsesoriaAviseBean.lstAreaAfectivaSelect}" layout="pageDirection">
                <f:selectItems value="#{registrarAsesoriaAviseBean.lstAreaAfectiva}"/>
              </h:selectManyCheckbox>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAreaAfectivaPsicoemocional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="230px"
                       id="panelAreaSomaticoPsicoemocional" rowClasses="standardTable_Row8,standardTable_Row8"
                       style="border-color:#3f3e23;">
            <h:outputText value="Área Somático" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectManyCheckbox required="true" style="border-style:none;height:300px;" immediate="true"
                                      id="mnuAreaSomaticoPsicoemocional"
                                      value="#{registrarAsesoriaAviseBean.lstAreaSomaticoSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{registrarAsesoriaAviseBean.lstAreaSomatico}"/>
                </h:selectManyCheckbox>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAreaSomaticoPsicoemocional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="230px"
                       id="panelAreaRelacionalPsicoemocional" rowClasses="standardTable_Row7,standardTable_Row7"
                       style="border-color:#3f3e23;">
            <h:outputText value="Área Relacional" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <h:selectManyCheckbox required="true" style="border-style:none;height:300px;" immediate="true"
                                    id="mnuAreaRelacionalPsicoemocional"
                                    value="#{registrarAsesoriaAviseBean.lstAreaRelacionalSelect}"
                                    layout="pageDirection">
                <f:selectItems value="#{registrarAsesoriaAviseBean.lstAreaRelacional}"/>
              </h:selectManyCheckbox>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAreaRelacionalPsicoemocional" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" width="230px" id="panelAreaCognitiva"
                       rowClasses="standardTable_Row8,standardTable_Row8" style="border-color:#3f3e23;">
            <h:outputText value="Área Cognitiva" styleClass="labelTextOblig"/>
            <h:panelGroup>
              <a4j:region renderRegionOnly="false">
                <h:selectManyCheckbox required="true" style="border-style:none;height:300px;" id="mnuAreaCognitiva"
                                      immediate="true" value="#{registrarAsesoriaAviseBean.lstAreaCognitivaSelect}"
                                      layout="pageDirection">
                  <f:selectItems value="#{registrarAsesoriaAviseBean.lstAreaCognitiva}"/>
                </h:selectManyCheckbox>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuAreaCognitiva" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup/>
          </h:panelGrid>
        </h:panelGrid>
      </s:fieldset>
   
      <s:fieldset legend="Hallazgos " id="fieldSetHallazgos" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionHallazgos"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Hallazgos " styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:inputTextarea id="textAreaHallazgos" required="true" immediate="true"
                           value="#{registrarAsesoriaAviseBean.asesoria.havcconclu}" 
                           style="width:650px;height:70px">
            <f:validateLength maximum="4000"/>
          </h:inputTextarea>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textAreaHallazgos" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          </h:panelGrid>
          
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
          id="panelRegionConceptoPsocologico"
                     rowClasses="labelText,labelTextInfo">
        
          
          <h:outputText value="Concepto Psicologico " styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                       
                                <a4j:commandLink action="#{registrarAsesoriaAviseBean.mostrarBuscadorPlantilla}"
                                                 immediate="true" reRender="panelGridRegistrarUsuarioAsesoriaTab">
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputTextarea id="textAreaConceptoPsicologico" required="true"
                                             style="width:650px;height:80px" immediate="true" 
                                             value="#{registrarAsesoriaAviseBean.asesoria.havcconpsi}"
                                             binding="#{registrarAsesoriaAviseBean.itConceptoPsicologico}"
                                             >
                                </h:inputTextarea>
                               
                             </h:panelGrid>
                             
          
     
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="textAreaConceptoPsicologico" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          
          <h:outputText value="Se realizo intervencion en crisis " styleClass="labelTextOblig"/>
          <h:outputText value=" "/>
          <h:selectOneRadio id="menuRealizoIntervencion" required="true" immediate="true"
                            value="#{registrarAsesoriaAviseBean.asesoria.havcintcri}"
                            onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarAsesoriaAviseBean.listOpciones}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuRealizoIntervencion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:selectOneRadio>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Acción " id="fieldSetConductaAsegir" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConductaASeguir"
                     styleClass="labelTextInfo">
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkRemitirConsultaIlve" onkeydown="return blockEnter(event);"
              disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderRemitirIlve}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderRemitirIlve}">
                <a4j:support id="supportCheckRemitirConsultaIlve" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Opta IVE Institucional  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkIndecision" onkeydown="return blockEnter(event);"
                                      disabled="#{registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderIndecision}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderIndecision}">
                <a4j:support id="supportCheckIndecision" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Indecisión  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkCostoAlto" onkeydown="return blockEnter(event);"
                                    disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderCostoAlto}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderCostoAlto}">
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
                                       disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderEps}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderEps}">
                <a4j:support id="supportCheckUsaEPS" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Va a usar EPS  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkOtraIps" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderOtraIps}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderOtraIps}">
                <a4j:support id="supportCheckOtraIps" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Va a usar otra IPS  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkEmbarazoMayor" onkeydown="return blockEnter(event);"
                                       value="#{registrarAsesoriaAviseBean.renderEmbarazoMayor}"
                                        disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderEmbarazoMayor}">
                <a4j:support id="supportCheckEmbarazoMayor" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Remisión por edad gestacional  "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextEdadGestacional" columns="1">
            <h:outputText value="Cuántas Semanas? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderEmbarazoMayor}"/>
            <h:inputText id="itEdadGestacional" rendered="#{registrarAsesoriaAviseBean.renderEmbarazoMayor}"
                         onkeydown="return blockEnter(event);" maxlength="2" required="true" style="width:40px"
                         value="#{registrarAsesoriaAviseBean.asesoria.havnedages}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarAsesoriaAviseBean.renderEmbarazoMayor}">
              <t:message for="itEdadGestacional" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkNoAplicaCausal" onkeydown="return blockEnter(event);"
                                       disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderAplicaCausal}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderAplicaCausal}">
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
                                       disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderRemitirIlve || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderOtraConducta}"
                                       value="#{registrarAsesoriaAviseBean.renderContinuaEmbarazo}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderContinuaEmbarazo}">
                <a4j:support id="supportcheckContinuaEmbarazo" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Desea continuar embarazo  "/>
            </h:panelGroup>
          </a4j:region>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkAplazaDecision" onkeydown="return blockEnter(event);"
                                       value="#{registrarAsesoriaAviseBean.renderAplazaDecision}"
                                         disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderRemitirIlve  || registrarAsesoriaAviseBean.renderContinuaEmbarazo ||  registrarAsesoriaAviseBean.renderOtraConducta}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderAplazaDecision}">
                <a4j:support id="supportCheckAplazaDecision" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value=" Aplaza la decisión "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextAplazaDecision" columns="1">
            <h:outputText value="Motivo? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderAplazaDecision}"/>
            <h:inputText id="itMotivoDecision" rendered="#{registrarAsesoriaAviseBean.renderAplazaDecision}"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcremmot}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarAsesoriaAviseBean.renderAplazaDecision}">
              <t:message for="itMotivoDecision" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <h:panelGroup style="border-style:none;font-size:10px">
              <h:selectBooleanCheckbox id="checkOtraConducta" onkeydown="return blockEnter(event);"
                                       value="#{registrarAsesoriaAviseBean.renderOtraConducta}"
                                         disabled="#{registrarAsesoriaAviseBean.renderIndecision || registrarAsesoriaAviseBean.renderCostoAlto || registrarAsesoriaAviseBean.renderEps || registrarAsesoriaAviseBean.renderOtraIps || registrarAsesoriaAviseBean.renderEmbarazoMayor || registrarAsesoriaAviseBean.renderAplicaCausal || registrarAsesoriaAviseBean.renderAplazaDecision  || registrarAsesoriaAviseBean.renderContinuaEmbarazo || registrarAsesoriaAviseBean.renderAplazaDecision || registrarAsesoriaAviseBean.renderRemitirIlve}"
                                       valueChangeListener="#{registrarAsesoriaAviseBean.setRenderOtraConducta}">
                <a4j:support id="supportCheckOtraConducta" event="onclick" reRender="panelGridConductaASeguir">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectBooleanCheckbox>
              <h:outputText value="  Otro "/>
            </h:panelGroup>
          </a4j:region>
          <h:panelGrid id="panelTextCualConducta" columns="1">
            <h:outputText value="Cuál acción? " styleClass="labelTextOblig"
                          rendered="#{registrarAsesoriaAviseBean.renderOtraConducta}"/>
            <h:inputText id="itCualConducta" rendered="#{registrarAsesoriaAviseBean.renderOtraConducta}"
                         onkeydown="return blockEnter(event);" maxlength="30" required="true"
                         value="#{registrarAsesoriaAviseBean.asesoria.havcnmbotr}"></h:inputText>
            <a4j:outputPanel ajaxRendered="true" rendered="#{registrarAsesoriaAviseBean.renderRemisionOtra}">
              <t:message for="itCualConducta" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </h:panelGrid>
        <t:htmlTag value="br"/>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                           action="#{registrarAsesoriaAviseBean.guardarAsesoria}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
     <t:panelTab id="panelBuscadorPlantillaAsesoria" label="Buscar Plantillas" 
        rendered="#{registrarAsesoriaAviseBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaAsesoria" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaAsesoria">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaAsesoria" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillas.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaAsesoria" width="100%" 
        columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
          <h:panelGroup id="panelGroupBuscadorBotonesPlantillaAsesoria">
            <a4j:commandButton value="Aceptar" styleClass="boton_fieldset" 
              action="#{registrarAsesoriaAviseBean.aceptarPlantilla}" 
                reRender="panelGridRegistrarUsuarioAsesoriaTab">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </a4j:region>
    </t:panelTab>
    
    
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid> 