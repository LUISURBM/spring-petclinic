<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="listaDetalleRegistrarInstrumentalForm">
  <a4j:region id="bodyRegionListaDetalleRegistrarInstrumental">
    <a4j:status for="bodyRegionListaDetalleRegistrarInstrumental">
      <f:facet name="start">
        <t:div id="chargindListaDetalleRegistrarInstrumental" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridDetalleRegistrarInstrumentalTab" styleClass="tabContainer">
                   <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneListaDetalleRegistrarInstrumental" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaDetalleRegistrarInstrumental" label="Hoja de Instrumentadora ">
        
          <h:panelGroup id="msgInstrumentalRegistro">
            <a4j:outputPanel id="ajaxRegionMessagesInstrumentalRegistro" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgInformationAndErrorsInstrumentalRegistro" showSummary="true" errorClass="error"
                          globalOnly="true" layout="table" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <s:fieldset legend="Registrar Instrumental Paquetes" id="fieldSetInfoRegistrarInstrumental"
                      styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelRegionRegistrarInstrumental" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Se utilizaron paquetes estériles de ropa o instrumental?"
                            styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuUtilizaronPaquetes" required="true" immediate="true"
                                value="#{registrarInstrumentalBean.instrumental.hincpaqueester}"
                                valueChangeListener="#{registrarInstrumentalBean.setHincpaqueester}">
                <f:selectItems value="#{registrarInstrumentalBean.lstOpciones}"/>
                <a4j:support id="supportmnuUtilizacionPaquetes" event="onclick"
                             action="#{registrarInstrumentalBean.changeUtilizaronPaquetes}"
                             reRender="panelGridDetalleRegistrarInstrumentalTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuUtilizaronPaquetes" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:outputText value=""/>
              <h:outputText value=""/>
            </h:panelGrid>
            <s:fieldset legend="Control Esterilización" id="fieldSetInfoControlEsterilizacion"
                        rendered="#{registrarInstrumentalBean.renderPaquetes}" styleClass="fieldset_hijo">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionControlEsterilizacion" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Contenido de paquetes" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value="Tipo de esterilización" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:selectOneMenu id="mnuContenido" value="#{registrarInstrumentalBean.itemPaquete.id.hipncodigpaque}">
                    <f:selectItems value="#{registrarInstrumentalBean.lstPaqueteInstrumental}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuContenido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:selectOneMenu id="mnuTipoEsterelizacion" immediate="true"
                                   value="#{registrarInstrumentalBean.itemPaquete.hipctipoester}"
                                   valueChangeListener="#{registrarInstrumentalBean.setHipctipoester}">
                    <f:selectItems value="#{registrarInstrumentalBean.lstTipoEsterilizacion}"/>
                    <a4j:support id="supportmnuTipoEsterelizacion" event="onclick" immediate="true"
                                 action="#{registrarInstrumentalBean.changeTipoEsterilizacion}"
                                 reRender="panelTextNumeroCarga,panelTextNumeroAutoclave,panelInputNumeroCarga,panelMsgNumeroCarga,panelInputNumeroAutoclave,panelMsgNumeroAutoclave,panelTextIndicadorQuimico,panelMnuIndicadorQuimico,panelMsgIndicadorQuimico">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuTipoEsterelizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="Fecha de esterilización" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value="Fecha de vencimiento" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <t:inputCalendar id="fechaEsterilizacion" monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader" title="Formato: dd/mm/yyyy"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true" disabled="false"
                                   value="#{registrarInstrumentalBean.itemPaquete.hipdfechaester}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top">
                    <f:validator validatorId="dateMenorActualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaEsterilizacion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <t:inputCalendar id="fechaVencimiento" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true" disabled="false"
                                   value="#{registrarInstrumentalBean.itemPaquete.hipdfechavenci}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top">
                    <f:validator validatorId="dateMenorActualValidator"/>
                  </t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaVencimiento" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:panelGroup id="panelTextNumeroCarga">
                    <h:outputText value="Número de carga" styleClass="labelTextOblig"
                                  rendered="#{registrarInstrumentalBean.renderCalorHumedo}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelTextNumeroAutoclave">
                    <h:outputText value="Número de autoclave" styleClass="labelTextOblig"
                                  rendered="#{registrarInstrumentalBean.renderCalorHumedo}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelInputNumeroCarga">
                    <h:inputText id="itNumeroCarga" value="#{registrarInstrumentalBean.itemPaquete.hipnnumercarga}"
                                 rendered="#{registrarInstrumentalBean.renderCalorHumedo}" maxlength="2"
                                 style="width:50px"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelMsgNumeroCarga">
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarInstrumentalBean.renderCalorHumedo}">
                      <t:message for="itNumeroCarga" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id="panelInputNumeroAutoclave">
                    <h:inputText id="itNumeroAutoclave" value="#{registrarInstrumentalBean.itemPaquete.hipnnumerauto}"
                                 rendered="#{registrarInstrumentalBean.renderCalorHumedo}" maxlength="1"
                                 style="width:50px"/>
                  </h:panelGroup>
                  <h:panelGroup id="panelMsgNumeroAutoclave">
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarInstrumentalBean.renderCalorHumedo}">
                      <t:message for="itNumeroAutoclave" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id = "panelTextIndicadorQuimico">
                    <h:outputText value="Indicador químico " styleClass="labelTextOblig"
                                  rendered="#{registrarInstrumentalBean.renderCalorHumedo}"/>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                  <h:panelGroup id="panelMnuIndicadorQuimico">
                    <h:selectOneRadio id="mnuIndicadorQuimico" rendered="#{registrarInstrumentalBean.renderCalorHumedo}"
                                      value="#{registrarInstrumentalBean.itemPaquete.hipcindicquimi}">
                      <f:selectItems value="#{registrarInstrumentalBean.lstOpciones}"/>
                    </h:selectOneRadio>
                  </h:panelGroup>
                  <h:panelGroup id = "panelMsgIndicadorQuimico">
                    <a4j:outputPanel ajaxRendered="true" rendered="#{registrarInstrumentalBean.renderCalorHumedo}">
                      <t:message for="mnuIndicadorQuimico" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value=""/>
                  <h:outputText value=""/>
                </h:panelGrid>
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelGridBotonesAgregarPaquete" styleClass="tabContainer">
                  <a4j:commandButton value="Agregar Paquete" styleClass="btn btn btn-success"
                                     action="#{registrarInstrumentalBean.adicionarPaquete}"
                                     reRender="panelTabListaDetalleRegistrarInstrumental"/>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
            <s:fieldset legend="Lista Paquetes " id="fieldSetListaPaquetes"
                        rendered="#{not empty registrarInstrumentalBean.lstItemPaquete && registrarInstrumentalBean.renderPaquetes}"
                        styleClass="fieldset_hijo">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableListaPaqueteInstrumental" styleClass="tabContainer">
                  <a4j:region renderRegionOnly="false">
                    <a4j:region renderRegionOnly="false">
                      <h:dataTable var="item" border="0" cellpadding="0" cellspacing="4"
                                   value="#{registrarInstrumentalBean.lstItemPaquete}" rows="15"
                                   styleClass="standard_table" binding="#{registrarInstrumentalBean.dtPaquete}"
                                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                   rendered="#{not empty registrarInstrumentalBean.lstItemPaquete}" id="dtPaquete">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Paquetes"/>
                          </f:facet>
                          <h:selectOneMenu id="mnuPaqueteTabla" disabled="true" value="#{item.id.hipncodigpaque}">
                            <f:selectItems value="#{registrarInstrumentalBean.lstPaqueteInstrumental}"/>
                          </h:selectOneMenu>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Tipo de esterilización"/>
                          </f:facet>
                          <h:selectOneMenu id="mnuTipoEsterelizacionTabla" disabled="true"
                                           value="#{item.hipctipoester}">
                            <f:selectItems value="#{registrarInstrumentalBean.lstTipoEsterilizacion}"/>
                          </h:selectOneMenu>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Fecha esterilización"/>
                          </f:facet>
                          <h:outputText value="#{item.hipdfechaester}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Fecha vencimiento"/>
                          </f:facet>
                          <h:outputText value="#{item.hipdfechavenci}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Número de Carga"/>
                          </f:facet>
                          <h:outputText value="#{item.hipnnumercarga}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Número de autoclave"/>
                          </f:facet>
                          <h:outputText value="#{item.hipnnumerauto}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Indicador Quimico"/>
                          </f:facet>
                          <h:outputText value="#{item.descrindicquimi}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Editar"/>
                          </f:facet>
                          <a4j:commandLink id="editarPaquete" action="#{registrarInstrumentalBean.editarPaquete}"
                                           reRender="panelTabListaDetalleRegistrarInstrumental">
                            <t:graphicImage id="imageEditarPaquete" alt="editarPaquete" border="0"
                                            url="/comun/imagenes/editar.gif"/>
                          </a4j:commandLink>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminarPaquete" action="#{registrarInstrumentalBean.eliminarPaquete}"
                                           onclick="if (!confirm(\'¿Esta seguro de Eliminar el Paquete Instrumental \')) return false"
                                           reRender="panelTabListaDetalleRegistrarInstrumental">
                            <t:graphicImage id="imageEliminarPaquete" border="0" url="/comun/imagenes/eliminarObj.gif"
                                            alt="EliminarPaquete"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </a4j:region>
                  </a4j:region>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
          </s:fieldset>
          <s:fieldset legend="Registrar Instrumental Materiales" id="fieldSetInfoRegistrarInstrumentalMaterial"
                      rendered="#{registrarInstrumentalBean.renderPaquetes}" styleClass="fieldset">
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelRegionRegistrarConteoMateriales" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Se realizó conteo inicial y final de materiales?" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                <h:selectOneRadio id="mnuConteoMateriales" required="true" immediate="true"
                                  value="#{registrarInstrumentalBean.instrumental.hincrealiconte}"
                                  valueChangeListener="#{registrarInstrumentalBean.setHincrealiconte}">
                  <f:selectItems value="#{registrarInstrumentalBean.lstOpciones}"/>
                  <a4j:support id="supportmnuConteoMateriales" event="onclick"
                               action="#{registrarInstrumentalBean.changeConteoMateriales}"
                               reRender="panelGridDetalleRegistrarInstrumentalTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuConteoMateriales" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:outputText value=""/>
                <h:outputText value=""/>
              </h:panelGrid>
            </a4j:region>
            <s:fieldset legend=" Conteo de materiales" id="fieldSetInfoConteoMateriales" styleClass="fieldset_hijo"
                        rendered="#{registrarInstrumentalBean.renderMateriales}">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionConteoMateriales" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Material" styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value="Conteo inicial: " styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value="Adiciones durante el procedimiento: " styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:outputText value="Conteo final: " styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:selectOneMenu id="mnuMaterial" value="#{registrarInstrumentalBean.itemMaterial.id.himncodigmater}">
                    <f:selectItems value="#{registrarInstrumentalBean.lstMaterialInstrumental}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMaterial" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:inputText id="itConteoInicial" value="#{registrarInstrumentalBean.itemMaterial.himnprimeconte}"
                               maxlength="3" style="width:50px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itConteoInicial" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:inputText id="itAdiciones" value="#{registrarInstrumentalBean.itemMaterial.himnadiciones}"
                               maxlength="3" style="width:50px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itAdiciones" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:inputText id="itConteoFinal" value="#{registrarInstrumentalBean.itemMaterial.himnsegunconte}"
                               maxlength="3" style="width:50px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itConteoFinal" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionObservacionesConteoMateriales" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Observaciones: " styleClass="labelTextOblig"/>
                  <h:outputText value=""/>
                  <h:inputText id="itObservacionesConteoMaterial"
                               value="#{registrarInstrumentalBean.itemMaterial.himcobservacio}" maxlength="100"
                               style="width:750px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itObservacionesConteoMaterial" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelGridBotonesAgregarMaterial" styleClass="tabContainer">
                  <a4j:commandButton value="Agregar Material" styleClass="btn btn btn-success"
                                     rendered="#{registrarInstrumentalBean.renderMateriales}"
                                     action="#{registrarInstrumentalBean.adicionarMaterial}"
                                     reRender="panelTabListaDetalleRegistrarInstrumental"/>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
            <s:fieldset legend=" Lista de materiales" id="fieldSetInfoListaMateriales" styleClass="fieldset_hijo"
                        rendered="#{not empty registrarInstrumentalBean.lstItemMaterial && registrarInstrumentalBean.renderPaquetes && registrarInstrumentalBean.renderMateriales}">
              <a4j:region renderRegionOnly="false">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="tableMaterialInstrumental" styleClass="tabContainer">
                  <a4j:region renderRegionOnly="false">
                    <h:dataTable var="item" border="0" cellpadding="0" cellspacing="4"
                                 value="#{registrarInstrumentalBean.lstItemMaterial}" rows="15"
                                 styleClass="standard_table" binding="#{registrarInstrumentalBean.dtMaterial}"
                                 rendered="#{not empty registrarInstrumentalBean.lstItemMaterial}"
                                 rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                                 id="dtMaterial">
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Material"/>
                        </f:facet>
                        <h:selectOneMenu id="mnuMaterialTabla" disabled="true" value="#{item.id.himncodigmater}">
                          <f:selectItems value="#{registrarInstrumentalBean.lstMaterialInstrumental}"/>
                        </h:selectOneMenu>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Conteo Inicial"/>
                        </f:facet>
                        <h:outputText value="#{item.himnprimeconte}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Adiciones"/>
                        </f:facet>
                        <h:outputText value="#{item.himnadiciones}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Conteo Final"/>
                        </f:facet>
                        <h:outputText value="#{item.himnsegunconte}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Observaciones"/>
                        </f:facet>
                        <h:outputText value="#{item.himcobservacio}"/>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Editar"/>
                        </f:facet>
                        <a4j:commandLink id="editar" action="#{registrarInstrumentalBean.editarMaterial}"
                                         reRender="panelTabListaDetalleRegistrarInstrumental">
                          <t:graphicImage id="imageEditarMaterial" alt="editarMaterial" border="0"
                                          url="/comun/imagenes/editar.gif"/>
                        </a4j:commandLink>
                      </h:column>
                      <h:column>
                        <f:facet name="header">
                          <h:outputText value="Eliminar"/>
                        </f:facet>
                        <a4j:commandLink id="eliminar" action="#{registrarInstrumentalBean.eliminarMaterial}"
                                         onclick="if (!confirm(\'¿Esta seguro de Eliminar el Material Instrumental \')) return false"
                                         reRender="panelTabListaDetalleRegistrarInstrumental">
                          <t:graphicImage id="imageEliminarPaquete" border="0" alt="EliminarMaterial"
                                          url="/comun/imagenes/eliminarObj.gif"/>
                        </a4j:commandLink>
                      </h:column>
                    </h:dataTable>
                  </a4j:region>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
          </s:fieldset>
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonGuardarInstrumental" columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                 action="#{registrarInstrumentalBean.guardarInstrumental}">
                  <a4j:support event="onclick" status="statusButton"/>
                </h:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
        <h:commandLink action="#{registrarInstrumentalBean.volver}" immediate="true">
          <t:graphicImage id="imageVolver" alt="volver" border="0" url="/comun/imagenes/volver.gif"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarListaDetalleRegistrarInstrumental">
        <a4j:outputPanel id="ajaxRegionMessagesListaDetalleRegistrarInstrumental" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsDetalleRegistrarInstrumental" showSummary="true" errorClass="error"
                      globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>