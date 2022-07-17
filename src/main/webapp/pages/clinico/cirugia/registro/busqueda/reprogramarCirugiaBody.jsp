<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formModificarCirugia">
  <a4j:region id="regionModificarCirugia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionModificarCirugia">
      <f:facet name="start">
        <t:div id="chargingModificarCirugia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbicationModificacion" border="0" cellpadding="0" cellspacing="0" width="100%"
                 columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Cirugia >> Reprogramar Cirugía "
                    id="infoUbicationModificarreprogramar"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridModificarCirugiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneModificarCirugia" styleClass="tabbedPane"
                         selectedIndex="#{reprogramarCirugiaBean.selectedIndex}" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
                         
            
        <t:panelTab id="panelTabModificarCirugia" label="Reprogramar Cirugia(s)"
                    disabled="#{reprogramarCirugiaBean.renderDisponibilidad}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridModificarCirugia" styleClass="tabContainer">
            <s:fieldset legend="Información Paciente" id="fieldInformacionPacienteModificar" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tableFechasCirugiaModificar">
                <h:outputText value="Tipo Documento"/>
                <h:outputText value="Número Documento"/>
                <h:outputText value="Nombre del Paciente"/>
                <h:outputText value="#{reprogramarCirugiaBean.reprogramar.hcplusuario.husetipoiden}"/>
                <h:outputText value="#{reprogramarCirugiaBean.reprogramar.hcplusuario.husanumeiden}"/>
                <h:outputText value="#{reprogramarCirugiaBean.reprogramar.hcplusuario.huscprimernomb} #{reprogramarCirugiaBean.reprogramar.hcplusuario.huscprimerapel}"/>
                <h:outputText value="Entidad"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value="#{reprogramarCirugiaBean.entidad}"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </s:fieldset>
 
            <jsp:include page="/pages/clinico/cirugia/comun/mantenimientoCirugias.jsp" flush="true"/>
           
            <s:fieldset legend="Cancelar Cirugía" id="fieldCancela" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" id="panelBotonCacelar" width="50%">
                <h:outputText value="Desea Cancelar la Cirugía" styleClass="labelTextOblig"/>
                <h:outputText/>
                <h:panelGroup id="panelTextMotivoCancelacion">
                  <h:outputText value="Motivo Cancelación" styleClass="labelTextOblig"
                                rendered="#{reprogramarCirugiaBean.renderCancelar}"/>
                </h:panelGroup>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="menuCancela" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      value="{reprogramarCirugiaBean.radioCancelar}"
                                      valueChangeListener="#{reprogramarCirugiaBean.listenCancelaCirugia}">
                      <f:selectItems value="#{reprogramarCirugiaBean.lstOpciones}"/>
                      <a4j:support id="supportCancela" event="onclick"
                                   action="#{reprogramarCirugiaBean.muestraCancelar}"
                                   reRender="panelTabModificarCirugia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                  </h:panelGroup>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="menuCancela" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:panelGroup id="panelGridMotivoCancelar">
                  <h:selectOneMenu id="mnuMotivoCancelar" immediate="true"
                    value="#{reprogramarCirugiaBean.reprogramar.hcpcmotivanula}"
                                   required="true" rendered="#{reprogramarCirugiaBean.renderCancelar}">
                    <f:selectItem itemValue="" itemLabel="Seleccione una opción"/>
                    <f:selectItem itemValue="1" itemLabel="ATRIBUIBLE A LA INSTITUCION"/>
                    <f:selectItem itemValue="2" itemLabel="ATRIBUIBLE AL USUARIO"/>
                    <f:selectItem itemValue="3" itemLabel="POR ORDEN MEDICA"/>
                    <f:selectItem itemValue="4" itemLabel="ERROR DE DIGITACIÓN"/>
                     <a4j:support  event="onchange">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                  </h:selectOneMenu>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuMotivoCancelar" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value="Observaciones" styleClass="labelTextOblig"
                              rendered="#{reprogramarCirugiaBean.renderCancelar}"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:inputTextarea id="textAreaObservacionesCancelacion"  immediate="true"
                                 value="#{reprogramarCirugiaBean.reprogramar.hcpcobseranula}" style="width:400px"
                                 rendered="#{reprogramarCirugiaBean.renderCancelar}">
                  <f:validateLength maximum="200"/>
                     <a4j:support  event="onchange">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textAreaObservacionesCancelacion" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Desea Reprogramar la Cirugía" styleClass="labelTextOblig"
                              rendered="#{reprogramarCirugiaBean.renderCancelar}"/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="menuReprograma" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      value="{reprogramarCirugiaBean.radioCancelar}"
                                      valueChangeListener="#{reprogramarCirugiaBean.listenReprogramaCirugia}"
                                      rendered="#{reprogramarCirugiaBean.renderCancelar}">
                      <f:selectItems value="#{reprogramarCirugiaBean.lstOpciones}"/>
                      <a4j:support id="supportReprograma" event="onclick" immediate="true"
                                   reRender="panelTabModificarCirugia">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                  </h:panelGroup>
                  <h:outputText/>
                  <h:outputText/>
                  <h:outputText/>
                </a4j:region>
                <h:panelGroup>
                  <h:commandButton value="Cancelar Cirugía"
                                   onclick="if (!confirm(\'¿Realmente desea cancelar la cirugia \')) return false"
                                   rendered="#{reprogramarCirugiaBean.renderCancelar && reprogramarCirugiaBean.renderButton}"
                                   styleClass="btn btn btn-danger" action="#{reprogramarCirugiaBean.cancelarCirugia}"/>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            
             <s:fieldset legend="Cambiar Cirugia" id="fieldrecambiarCirugiaModificar" styleClass="fieldset"
                        rendered="#{reprogramarCirugiaBean.renderReprogramar}">
                        
                       <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tablepanelgridcambiarcirugia">   
                        
                        <h:outputText value = "Desea cambiar la Cirugia" styleClass="labelTextOblig"/>
                        <h:outputText />
                        
                        <a4j:region renderRegionOnly="false">
                      <h:selectOneRadio id="mnuCambiarCirugia" required="true" immediate="true"
                                        onkeydown="return blockEnter(event);"
                                         value="#{reprogramarCirugiaBean.cambiar}"
                                        valueChangeListener="#{reprogramarCirugiaBean.setCambiar}">
                        <f:selectItems value="#{reprogramarCirugiaBean.lstOpciones}"/>
                        <a4j:support id="supportCambiar" event="onclick"
                                     action="#{reprogramarCirugiaBean.changeCirugia}"
                                     reRender="panelGridModificarCirugiaTab">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuCambiarCirugia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                        
                        </h:panelGrid>
           
              </s:fieldset>
              
              
            <h:panelGroup  rendered="#{reprogramarCirugiaBean.renderCambiarCirugia}">
            <jsp:include page="/pages/clinico/cirugia/comun/cambiarCirugia.jsp" flush="true" />
            </h:panelGroup>
            
            
            <s:fieldset legend="Reprogramación Cirugía" id="fieldreprogramarCirugiaModificar" styleClass="fieldset"
                        rendered="#{reprogramarCirugiaBean.renderReprogramar}">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           rowClasses="labelText,labelTextInfo" id="tablereprogramarCirugiaModificar">
                <h:outputText value="No Sala" styleClass="labelTextOblig"/>
                <h:outputText value="Fecha Cirugia" styleClass="labelTextOblig"/>
                <h:outputText value="Hora Cirugia" styleClass="labelTextOblig"/>
                <h:outputText value="Duración Cirugia" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuSala" value="#{reprogramarCirugiaBean.reprogramar.hcpnsalainterv}"
                                   required="true" styleClass="dropdown-toggle, input-medium">
                    <f:selectItems value="#{reprogramarCirugiaBean.lstSalasCirugia}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuSala" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <a4j:commandLink action="#{reprogramarCirugiaBean.mostrarBuscador}" immediate="true"
                                   reRender="panelGridProgramarCirugiaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupita.png"/>
                  </a4j:commandLink>
                </h:panelGroup>
                <h:panelGrid columns="2">
                  <t:inputCalendar id="fechaCirugia" monthYearRowClass="yearMonthHeader" title="Formato: dd/mm/yyyy"
                                   weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                   value="#{reprogramarCirugiaBean.reprogramar.hcpdfechacirug}" popupTodayString="Hoy"
                                   popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                   size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" styleClass="input-small">
                    <f:validator validatorId="dateMayorIgualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaCirugia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuHoraCirugia1" value="#{reprogramarCirugiaBean.horaSelect}"
                                     styleClass="input-small">
                      <f:selectItems value="#{reprogramarCirugiaBean.listHora}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuHoraCirugia1" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas "/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuMinutosCirugia1" value="#{reprogramarCirugiaBean.minutoSelect}"
                                     required="true" styleClass="dropdown-toggle, input-small">
                      <f:selectItems value="#{reprogramarCirugiaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuMinutosCirugia1" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuTiempoHorasCirugia1"
                                     value="#{reprogramarCirugiaBean.reprogramar.hcpchoradurac}"
                                     styleClass="dropdown-toggle, input-small">
                      <f:selectItems value="#{reprogramarCirugiaBean.listHoraDuracion}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTiempoHorasCirugia1" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" : Horas "/>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuTiempoMinutosCirugia1"
                                     value="#{reprogramarCirugiaBean.reprogramar.hcpcminutdurac}"
                                     styleClass="dropdown-toggle, input-small">
                      <f:selectItems value="#{reprogramarCirugiaBean.lstMinutos}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuTiempoMinutosCirugia1" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=" Minutos"/>
                </h:panelGroup>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText/>
                <h:outputText value="Anestesia Solicitada " styleClass="labelTextOblig"/>
                <h:outputText value="Ayudantia" styleClass="labelTextOblig"/>
                <h:outputText value="Requiere estancia menor a 24 horas " styleClass="labelTextOblig"/>
                <h:panelGroup id="outputDiasInstanciaModificar">
                  <h:outputText value="Dias" styleClass="labelTextOblig"
                                rendered="#{reprogramarCirugiaBean.esHospitalaria}"/>
                </h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneRadio id="mnuAnestesiaModificar" required="true" immediate="true"
                                        onkeydown="return blockEnter(event);"
                                        binding="#{reprogramarCirugiaBean.mnuAnestesia}"
                                        value="#{reprogramarCirugiaBean.reprogramar.hcpctipoaneste}"
                                        valueChangeListener="#{reprogramarCirugiaBean.setHcpctipoaneste}">
                        <f:selectItems value="#{reprogramarCirugiaBean.lstTipoAnestesia}"/>
                        <a4j:support id="supportAnestesiaModificar" event="onclick"
                                     action="#{reprogramarCirugiaBean.changeAnestesia}"
                                     reRender="panelGridListaAnestesiologoModificar">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuAnestesiaModificar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGrid columns="2">
                  <a4j:region renderRegionOnly="false">
                    <h:selectOneRadio id="mnuAyudantiaModificar" required="true" immediate="true"
                                      onkeydown="return blockEnter(event);"
                                      binding="#{reprogramarCirugiaBean.mnuAyudantia}"
                                      value="#{reprogramarCirugiaBean.reprogramar.hcpctipoayudan}"
                                      valueChangeListener="#{reprogramarCirugiaBean.setHcpctipoayudan}">
                      <f:selectItems value="#{reprogramarCirugiaBean.ltsAyudantia}"/>
                      <a4j:support id="supportAyudantiaModificar" event="onclick"
                                   action="#{reprogramarCirugiaBean.changeAyudantia}"
                                   reRender="panelGridListaProfesionalesModificar">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                  </a4j:region>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAyudantiaModificar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                  <h:panelGrid columns="2">
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneRadio id="mnuEstanciaModificar" required="true" immediate="true"
                                        onkeydown="return blockEnter(event);"
                                        binding="#{reprogramarCirugiaBean.mnuEstancia}"
                                        value="#{reprogramarCirugiaBean.reprogramar.hcpctipoestanc}"
                                        valueChangeListener="#{reprogramarCirugiaBean.setEstanciaSelect}">
                        <f:selectItems value="#{reprogramarCirugiaBean.lstEstancia}"/>
                        <a4j:support id="supportEstanciaModificar" event="onclick"
                                     action="#{reprogramarCirugiaBean.changeEstancia}"
                                     reRender="inputTextDiasInstanciaModificar,outputDiasInstanciaModificar">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuEstanciaModificar" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </a4j:region>
                <h:panelGroup id="inputTextDiasInstanciaModificar">
                  <h:inputText id="itDiasEstanciaModificar" required="true" immediate="true" maxlength="2"
                               style="width:50px" binding="#{reprogramarCirugiaBean.inputDias}"
                               onkeydown="return blockEnter(event);"
                               value="#{reprogramarCirugiaBean.reprogramar.hcpndiasestanc}"
                               rendered="#{reprogramarCirugiaBean.esHospitalaria}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itDiasEstanciaModificar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                
                
              <h:outputText value="Reserva de sangre " styleClass="labelTextOblig"/>
              <h:panelGroup id="inputTextHemo">
                  <h:outputText value="Tipo de hemocomponente" styleClass="labelTextOblig"
                     rendered="#{reprogramarCirugiaBean.mostrarRessangre}"/>
              </h:panelGroup>
              <h:panelGroup id="inputNumUnidades">
                  <h:outputText value="Número de unidades " styleClass="labelTextOblig"
                     rendered="#{reprogramarCirugiaBean.mostrarRessangre}"/>
              </h:panelGroup>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1">
                  <h:selectOneRadio id="mnuSangre" onkeydown="return blockEnter(event);"
                                    binding="#{reprogramarCirugiaBean.mnuSangre}"
                                    value="#{reprogramarCirugiaBean.reprogramar.hcpcressangre}"
                                    valueChangeListener="#{reprogramarCirugiaBean.setHcpcressangre}">
                    <f:selectItems value="#{reprogramarCirugiaBean.lstOpciones}"/>
                    <a4j:support id="supportSangre" event="onclick" action="#{reprogramarCirugiaBean.changeRessangre}"
                                 reRender="inputTextHemo,inputNumUnidades,inputTipohemo,inputTextNumUnidad">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuSangre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </a4j:region>
                <h:panelGroup id="inputTipohemo">
                  <h:selectOneMenu id="mnuTipohemo" required="true"
                                    value="#{reprogramarCirugiaBean.reprogramar.hcpctipohemoco}"
                                    rendered="#{reprogramarCirugiaBean.mostrarRessangre}">
                    <f:selectItems value="#{reprogramarCirugiaBean.listTipoHemo}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuTipohemo" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              <h:panelGroup id="inputTextNumUnidad">
                <h:inputText id="itNumUnidad" maxlength="2" style="width:50px" required="true"
                             binding="#{reprogramarCirugiaBean.inputUnidades}" onkeydown="return blockEnter(event);"
                             value="#{reprogramarCirugiaBean.reprogramar.hcpnnumerounid}"
                             rendered="#{reprogramarCirugiaBean.mostrarRessangre}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itNumUnidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText value="Observaciones"/>
              <h:outputText/>
              <h:outputText/>
              <h:outputText/>
              <h:inputTextarea id="textAreaObservaciones"
                               value="#{reprogramarCirugiaBean.reprogramar.hcpcobserv}" style="width:400px">
                <f:validateLength maximum="4000"/>
              </h:inputTextarea>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="textAreaObservaciones" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText/>
                <h:outputText/>

                
                
                
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridListaAnestesiologoModificar" styleClass="tabContainer">
              <s:fieldset legend="Programación Anestesiologo(s)" id="fieldreprogramarAnestesiologoModificar"
                          styleClass="fieldset"
                          rendered="#{reprogramarCirugiaBean.renderReprogramar && reprogramarCirugiaBean.mostrarAnestesiologo}">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             rowClasses="labelText,labelTextInfo" id="tableAnestesiologosModificar">
                  <h:panelGroup>
                    <h:outputText id="otAnestesiologo" value="Anestesiologo(s)"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="otAnestesiologo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuModificarAnestesiologo"
                                         value="#{reprogramarCirugiaBean.anestesiologoSelect}">
                          <f:selectItems value="#{reprogramarCirugiaBean.lstAnestesiologo}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuModificarAnestesiologo" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                      <a4j:commandLink id="agregarAnestesiologoModificar"
                                       action="#{reprogramarCirugiaBean.agregarAnestesiologo}"
                                       reRender="tableAnestesiologosModificarSelect,tableAnestesiologosModificar">
                        <t:graphicImage border="0" url="/comun/imagenes/useradd.png" alt="Agregar"/>
                      </a4j:commandLink>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                             rendered="#{reprogramarCirugiaBean.mostrarAnestesiologo}" width="100%"
                             styleClass="tabContainer" id="tableAnestesiologosModificarSelect">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="tableAnestesiologosModificareleccionados"
                               rendered="#{not empty reprogramarCirugiaBean.lstAnestesiologosSelect}"
                               styleClass="tabContainer">
                    <t:buffer into="#{table}">
                      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                   binding="#{reprogramarCirugiaBean.dtAnestesiologo}"
                                   value="#{reprogramarCirugiaBean.lstAnestesiologosSelect}" rows="10"
                                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                                   footerClass="paginacion" id="dtAnestesiologoModificar">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Codigo"/>
                          </f:facet>
                          <h:outputText value="#{item.id.cpfncodigo}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Nombre"/>
                          </f:facet>
                          <h:outputText value="#{item.cpfcnombre}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminarModificar"
                                           onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                           immediate="true" action="#{reprogramarCirugiaBean.eliminarAnestesiologo}"
                                           reRender="fieldreprogramarAnestesiologoModificar">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/userdelete.png"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                        <t:dataScroller id="scroll_Modificar_3" for="dtAnestesiologoModificar" fastStep="10"
                                        pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                        paginator="true" immediate="true" paginatorMaxPages="9"
                                        paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                        paginatorActiveColumnStyle="font-weight:bold;">
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
                </h:panelGrid>
              </s:fieldset>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelGridListaProfesionalesModificar" styleClass="tabContainer">
              <s:fieldset legend="Programación Profesionales Ayudantes" id="fieldreprogramarProfesionalesModificar"
                          styleClass="fieldset"
                          rendered="#{reprogramarCirugiaBean.mostrarProfesionales && reprogramarCirugiaBean.renderReprogramar}">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             rowClasses="labelText,labelTextInfo" id="tableProfesionalesModificar">
                  <h:panelGroup>
                    <h:outputText id="otProfesionales" value="Profesionales"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="otProfesionales" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:panelGrid columns="2">
                      <h:panelGroup>
                        <h:selectOneMenu id="mnuModificarProfesionales"
                                         value="#{reprogramarCirugiaBean.profesionalSelect}">
                          <f:selectItems value="#{reprogramarCirugiaBean.lstProfesionales}"/>
                        </h:selectOneMenu>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="mnuModificarProfesionales" styleClass="errorMessage"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                      <a4j:commandLink id="agregarProfesionalModificar"
                                       action="#{reprogramarCirugiaBean.agregarProfesional}"
                                       reRender="tableProfesionalesModificarSelect,tableProfesionalesModificar">
                        <t:graphicImage border="0" url="/comun/imagenes/useradd.png" alt="Agregar"/>
                      </a4j:commandLink>
                    </h:panelGrid>
                  </a4j:region>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                             rendered="#{reprogramarCirugiaBean.mostrarProfesionales}" width="100%"
                             styleClass="tabContainer" id="tableProfesionalesModificarSelect">
                  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="tableProfesionalesModificareleccionados"
                               rendered="#{not empty reprogramarCirugiaBean.lstProfesionalesSelect}"
                               styleClass="tabContainer">
                    <t:buffer into="#{table}">
                      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                                   binding="#{reprogramarCirugiaBean.dtProfesional}"
                                   value="#{reprogramarCirugiaBean.lstProfesionalesSelect}" rows="10"
                                   styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                                   footerClass="paginacion" id="dtProfesionalModificar">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Codigo"/>
                          </f:facet>
                          <h:outputText value="#{item.id.cpfncodigo}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Nombre"/>
                          </f:facet>
                          <h:outputText value="#{item.cpfcnombre}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminarModificar"
                                           onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                           immediate="true" action="#{reprogramarCirugiaBean.eliminarProfesional}"
                                           reRender="fieldreprogramarProfesionalesModificar">
                            <t:graphicImage alt="" border="0" url="/comun/imagenes/userdelete.png"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                        <t:dataScroller id="scroll_Modificar" for="dtProfesionalModificar" fastStep="10"
                                        pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                        paginator="true" immediate="true" paginatorMaxPages="9"
                                        paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                        paginatorActiveColumnStyle="font-weight:bold;">
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
                </h:panelGrid>
              </s:fieldset>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Modificar"
                                 onclick="if (!confirm(\'¿Realmente desea Modificar la Programación de la Cirugia \')) return false"
                                 rendered="#{reprogramarCirugiaBean.renderReprogramar}"
                                 styleClass="btn btn btn-success" 
                                 action="#{reprogramarCirugiaBean.modificarCirugia}"/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid></h:panelGrid>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionModificarCirugiaMsg" ajaxRendered="true">
                  <t:messages id="msgModificarCirugiaMsg" showSummary="true" errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscadorModificar" label="Disponibilidad Salas"
                    rendered="#{reprogramarCirugiaBean.renderDisponibilidad}">
          <a4j:region id="regionDisponibilidadSalasModificar" renderRegionOnly="false">
            <a4j:status for="regionDisponibilidadSalasModificar">
              <f:facet name="start">
                <t:div id="chargingDisponibilidadSalasModificar" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorDisponibilidadSala.jsp" flush="true"/>
            <h:panelGrid id="panelGridDisponibilidadSalasBotonesModificar" width="100%"
                         columnClasses="columnaBotonesCentrados" dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupDisponibilidadSalasBotonesModificar">
                <a4j:commandButton value="Volver" styleClass="btn btn btn-successs" immediate="true"
                                   action="#{reprogramarCirugiaBean.volver}" reRender="panelGridModificarCirugiaTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>