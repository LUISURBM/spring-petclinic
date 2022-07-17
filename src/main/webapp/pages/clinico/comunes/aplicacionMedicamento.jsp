<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAplicacionMedicamentoTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneNotaEnfermeria" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex="#{aplicacionMedicamentoBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabNotaEnfermeria" label="Registro Medicamentos/Vacunacion"
                disabled="#{aplicacionMedicamentoBean.renderPlantilla}">
      <s:fieldset legend="Administración/Entrega de Medicamentos" id="fieldSetActividadMedicamentos"
                  styleClass="fieldset">
        <h:dataTable id="tdatosInsumos2" var="item3" border="0" cellpadding="0" cellspacing="4"
                     binding="#{aplicacionMedicamentoBean.dtMedicamentosAtender}"
                     value="#{aplicacionMedicamentoBean.lstMedicamentoAtender}" rows="30" styleClass="standard_table"
                     rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion">
          <h:column>
            <f:facet name="header">
              <h:outputText value="Servicio"/>
            </f:facet>
            <h:outputText value="#{item3.hmecmedicament}"></h:outputText>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="Actividad a Registrar"/>
            </f:facet>
            <a4j:region renderRegionOnly="false">
              <h:selectOneMenu id="radioActividadOpc" immediate="true" required="false" value="#{item3.hmelcregiacti}"
                               valueChangeListener="#{aplicacionMedicamentoBean.setActividad}">
                <f:selectItems value="#{aplicacionMedicamentoBean.lstOpcionesActiv}"/>
                <a4j:support id="supportop" event="onchange" immediate="true"
                             action="#{aplicacionMedicamentoBean.changeActividadRegistra}"
                             reRender="fieldSetActividadMedicamentos">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneMenu>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="radioActividadOpc" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </a4j:region>
          </h:column>
          <h:column rendered="#{item3.selectObs}">
            <f:facet name="header">
              <h:outputText value="Medicamento" rendered="#{item3.selectObs}"/>
            </f:facet>
            <h:panelGroup id="panelGroupMedicamento">
              <h:panelGrid columns="2">
                <h:panelGroup>
                  <h:panelGrid columns="1">
                    <h:outputText value="Presentación" rendered="#{item3.aplicacion}" styleClass="labelTextOblig"/>
                    <a4j:region renderRegionOnly="false">
                      <h:panelGroup>
                        <h:selectOneMenu id="textPresentacion" immediate="true" value="#{item3.hmecpresentaci}"
                                         rendered="#{item3.aplicacion}"
                                         valueChangeListener="#{aplicacionMedicamentoBean.setPresentacion}">
                          <f:selectItems value="#{aplicacionMedicamentoBean.lstFormaFarmaceutica}"/>
                        </h:selectOneMenu>
                      </h:panelGroup>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="textPresentacion" styleClass="errorMessage" rendered="#{item3.aplicacion}"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1">
                    <h:outputText value="Dosis" styleClass="labelTextOblig" rendered="#{item3.vacunacion}"/>
                    <h:panelGroup>
                      <h:panelGrid columns="2">
                        <a4j:region renderRegionOnly="false">
                          <h:selectOneMenu id="mnuDosis" immediate="true" onkeydown="return blockEnter(event);"
                                           required="true" value="#{item3.hmennumervacun}"
                                           rendered="#{item3.vacunacion}"
                                           valueChangeListener="#{aplicacionMedicamentoBean.setDosis}">
                            <f:selectItems value="#{aplicacionMedicamentoBean.lstNumeroDosis}"/>
                          </h:selectOneMenu>
                        </a4j:region>
                      </h:panelGrid>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1">
                    <h:outputText value="Lote" styleClass="labelTextOblig" rendered="#{item3.aplicacion}"/>
                    <a4j:region renderRegionOnly="false">
                      <h:inputText id="textLote" immediate="true" value="#{item3.hmeclotemedic}" required="true"
                                   style="width:200px" rendered="#{item3.aplicacion}" maxlength="50"
                                   valueChangeListener="#{aplicacionMedicamentoBean.setLote}"/>
                    </a4j:region>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="textLote" styleClass="errorMessage" rendered="#{item3.aplicacion}"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1">
                    <h:outputText value="Fecha de Vencimiento" styleClass="labelTextOblig"
                                  rendered="#{item3.aplicacion}"/>
                    <a4j:region renderRegionOnly="false">
                      <h:panelGroup>
                        <t:inputCalendar id="fechaVencimiento" immediate="true" title="Formato: dd/mm/yyyy"
                                         rendered="#{item3.aplicacion}" monthYearRowClass="yearMonthHeader"
                                         weekRowClass="weekHeader" onkeydown="return blockEnter(event);"
                                         currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                         renderAsPopup="true" value="#{item3.hmedfechavenci}"
                                         valueChangeListener="#{aplicacionMedicamentoBean.setFechaVenci}"
                                         popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                         readonly="false" maxlength="11" size="11"
                                         popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                         renderPopupButtonAsImage="true" align="top" required="true"/>
                        <a4j:outputPanel ajaxRendered="true">
                          <t:message for="fechaVencimiento" styleClass="errorMessage" rendered="#{item3.aplicacion}"/>
                        </a4j:outputPanel>
                      </h:panelGroup>
                    </a4j:region>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1" rendered="#{item3.aplicacion}">
                    <h:outputText value="Via Administracion" styleClass="labelTextOblig"/>
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneMenu id="mnuViaAdministracion" immediate="true" onkeydown="return blockEnter(event);"
                                       required="true" rendered="#{item3.vacunacion}" value="#{item3.hmecviadministr}"
                                       valueChangeListener="#{aplicacionMedicamentoBean.setViaAdmi}">
                        <f:selectItems value="#{aplicacionMedicamentoBean.lstVia}"/>
                      </h:selectOneMenu>
                    </a4j:region>
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneMenu id="mnuViaAdministracionMedicamento" immediate="true"
                                       onkeydown="return blockEnter(event);" required="true"
                                       rendered="#{!item3.vacunacion}" value="#{item3.hmecviadministr}"
                                       valueChangeListener="#{aplicacionMedicamentoBean.setViaAdmi}">
                        <f:selectItems value="#{aplicacionMedicamentoBean.lstViaMedicamentos}"/>
                      </h:selectOneMenu>
                    </a4j:region>
                    <h:panelGroup>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuViaAdministracion" styleClass="errorMessage" rendered="#{item3.aplicacion}"/>
                      </a4j:outputPanel>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuViaAdministracionMedicamento" styleClass="errorMessage"
                                   rendered="#{item3.aplicacion}"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGrid columns="1">
                    <h:outputText value="Sitio Aplicacion" styleClass="labelTextOblig" rendered="#{item3.aplicacion}"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectOneMenu id="mnuSitioAdministracion" immediate="true"
                                         onkeydown="return blockEnter(event);"
                                         valueChangeListener="#{aplicacionMedicamentoBean.setSitioApli}" required="true"
                                         value="#{item3.hmecsitioaplic}" rendered="#{item3.aplicacion}">
                          <f:selectItems value="#{aplicacionMedicamentoBean.lstSitioAplicacion}"/>
                        </h:selectOneMenu>
                      </a4j:region>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuSitioAdministracion" styleClass="errorMessage"
                                   rendered="#{item3.aplicacion}"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup rendered="#{item3.vacunacion}">
                  <h:panelGrid columns="1">
                    <h:outputText value="Grupo Sanguineo" styleClass="labelTextOblig"/>
                    <a4j:region renderRegionOnly="false">
                      <h:selectOneMenu id="mnuGrupSang" immediate="true" onkeydown="return blockEnter(event);"
                                       required="true" value="#{item3.hmelcgrusangu}"
                                       valueChangeListener="#{aplicacionMedicamentoBean.setGrupoSang}">
                        <f:selectItems value="#{aplicacionMedicamentoBean.lstGrupoSanguineo}"/>
                      </h:selectOneMenu>
                    </a4j:region>
                  </h:panelGrid>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGrupSang" styleClass="errorMessage" rendered="#{item3.aplicacion}"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup rendered="#{item3.vacunacion}">
                  <h:panelGrid columns="1">
                    <h:outputText value="RH" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:selectOneRadio id="mnuRh" immediate="true" required="true" value="#{item3.hmelcrh}"
                                          valueChangeListener="#{aplicacionMedicamentoBean.setRh}">
                          <f:selectItems value="#{aplicacionMedicamentoBean.lstRh}"/>
                        </h:selectOneRadio>
                      </a4j:region>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuRh" styleClass="errorMessage" rendered="#{item3.aplicacion}"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup rendered="#{item3.vacunacion}">
                  <h:panelGrid columns="1">
                    <h:outputText value="Nombre Laboratorio" styleClass="labelTextOblig"/>
                    <h:panelGroup>
                      <a4j:region renderRegionOnly="false">
                        <h:inputText id="textNombreLaboratorio" immediate="true" value="#{item3.hmecnomblabo}"
                                     required="true" style="width:200px" maxlength="20"
                                     valueChangeListener="#{aplicacionMedicamentoBean.setLaboratorio}"/>
                      </a4j:region>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="textNombreLaboratorio" styleClass="errorMessage"
                                   rendered="#{item3.aplicacion}"/>
                      </a4j:outputPanel>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:panelGrid>
            </h:panelGroup>
            <h:outputText value="Nota de enfermeria" rendered="#{item3.selectObs}" styleClass="labelTextOblig"/>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="80%">
              <a4j:commandLink title="" action="#{aplicacionMedicamentoBean.mostrarBuscadorPlantilla}" immediate="true"
                               reRender="panelGridAplicacionMedicamentoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <a4j:region renderRegionOnly="false">
                <h:inputTextarea id="textObservaciones" onkeydown="return blockEnter(event);" immediate="true"
                                 valueChangeListener="#{aplicacionMedicamentoBean.setNotaEnfer}" styleClass="align:left"
                                 binding="#{aplicacionMedicamentoBean.itDescripcion}" required="true"
                                 rendered="#{item3.selectObs}" value="#{item3.hmecobservac}"
                                 style="width:130%;height:100px"/>
              </a4j:region>
            </h:panelGrid>
          </h:column>
        </h:dataTable>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonesAdministrarMedicamento" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Aceptar" rendered="#{not empty aplicacionMedicamentoBean.lstMedicamentoAtender}"
                           styleClass="boton_fieldset" action="#{aplicacionMedicamentoBean.guardar}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    <t:panelTab id="panelBuscadorPlantillaNotaEnfermeria" label="Buscar Plantillas"
                rendered="#{aplicacionMedicamentoBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaNotaEnfermeria" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaNotaEnfermeria">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaNotaEnfermeria" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
        <h:panelGrid id="panelGridBuscadorBotonesPlantillaNotaEnfermeria" width="100%"
                     columnClasses="columnaBotonesCentrados" dir="RTL">
          <t:htmlTag value="br"/>
        </h:panelGrid>
       
      </a4j:region>
       <a4j:region id="regionVolver" renderRegionOnly="false">
       <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonesVolverAdministrarMedicamentoPlant" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Volver" immediate="true"
                           styleClass="boton_fieldset" action="#{aplicacionMedicamentoBean.volverMedicamentos}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
       </h:panelGroup>
       </h:panelGrid>
    </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <h:panelGroup>
    <a4j:outputPanel id="ajaxRegionMedicamentosMsg" ajaxRendered="true">
      <t:htmlTag value="br"/>
      <t:messages id="msgInformationMedicamentoMsg" showSummary="false" errorClass="error" globalOnly="true"
                  layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
      <t:htmlTag value="br"/>
    </a4j:outputPanel>
  </h:panelGroup>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>