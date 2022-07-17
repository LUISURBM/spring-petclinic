<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formReservaSangre">
  <a4j:region id="regionReservaSangre" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionReservaSangre">
      <f:facet name="start">
        <t:div id="chargingReservaSangre" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridReservaSangreTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReservaSangre"
                         selectedIndex="#{solicitudReservaSangreBean.selectedIndex}"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReservaSangre" label="Reserva de Sangre"
                    disabled="#{solicitudReservaSangreBean.mostrarCie10 || solicitudReservaSangreBean.mostrarCirugias}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridReservaSangre"
                       styleClass="tabContainer">
            <s:fieldset legend="Diagnostico" id="fieldDiagnostico"
                        styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelDiagnostico"
                           rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Diagnostico Seleccionado"
                                styleClass="labelTextOblig"/>
                  <a4j:commandLink styleClass="boton_fieldset"
                                   rendered="#{!solicitudReservaSangreBean.modoconsulta}"
                                   action="#{solicitudReservaSangreBean.mostrarDiagnostico}"
                                   reRender="panelGridReservaSangreTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itDiagPrin" 
                                 immediate="true" styleClass="textmayuscula"
                                 disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                 onkeydown="return blockEnter(event);"
                                 binding="#{solicitudReservaSangreBean.itDiagnostico}"
                                 value="#{solicitudReservaSangreBean.reserva.hrscdiagprin}"
                                 valueChangeListener="#{solicitudReservaSangreBean.setHrscdiagprin}"
                                 style="width:50px" maxlength="4">
                                  <f:converter converterId="cadena.stringUpperCaseConverter"/>
                      <a4j:support id="supportitDiagPrin" event="onchange"
                                   immediate="true" ignoreDupResponses="true"
                                   action="#{solicitudReservaSangreBean.changeDiagnostico}"
                                   reRender="panelGridReservaSangreTab">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                       
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDiagPrin" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id="panelDiagnosticoPrincipal">
                    <h:outputText value=" #{solicitudReservaSangreBean.diagnosticoPrincipal}"
                                  styleClass="buscador"/>
                  </h:panelGroup>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Cirugias Programadas" id="fieldCirugias"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelCirugias"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Buscar Cirugias"/>
                <h:outputText/>
                <a4j:commandLink value="" immediate="true"
                                 rendered="#{!solicitudReservaSangreBean.modoconsulta}"
                                 title="Seleccionar Cirugias"
                                 action="#{solicitudReservaSangreBean.consultarCirugias}"
                                 reRender="panelGridReservaSangreTab"
                                 styleClass="boton_fieldset" id="idButt">
                  <t:graphicImage id="imagelupa" border="0"  alt="" 
                                  url="/comun/imagenes/lupa.gif"/>
                </a4j:commandLink>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="imagelupa" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGrid columns="1" id="panelGridNoCirugias"
                           rendered="#{empty solicitudReservaSangreBean.lstExamenesCirugias}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           rendered="#{not empty solicitudReservaSangreBean.lstExamenesCirugias}"
                           cellspacing="0" width="100%"
                           id="tableContentTabsBucar" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               binding="#{solicitudReservaSangreBean.dtCirugia}"
                               value="#{solicitudReservaSangreBean.lstExamenesCirugias}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion"
                               id="dtBucarCirugiasReserva">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.csvccodigo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcnombre}"/>
                    </h:column>
                    <h:column rendered="#{!solicitudReservaSangreBean.modoconsulta}">
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <a4j:commandLink id="aceptarCirugias" immediate="true"
                                       rendered="#{!solicitudReservaSangreBean.modoconsulta}"
                                       reRender="fieldCirugias"
                                       action="#{solicitudReservaSangreBean.eliminarCirugia}">
                        <t:graphicImage alt=""  border="0"
                                        url="/comun/imagenes/adicionar.gif"/>
                      </a4j:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtBucarCirugiasReserva"
                                    fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Reserva de Sangre" id="fieldReserva"
                        styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelReservaSangre"
                           rowClasses="labelText,labelTextInfo">
                <h:panelGroup>
                  <h:outputText value="Condiciones M�dicas Alteran Autodonaci�n "
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Fecha Programada"/>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuCondicionesAlteran"
                                    disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                    value="#{solicitudReservaSangreBean.reserva.hrseconmedalta}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{solicitudReservaSangreBean.lstOpciones}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuCondicionesAlteran"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="itCalendarFechaProgramada">
                  <t:inputCalendar id="fechaProgramada"
                                   disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                   title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);"
                                   monthYearRowClass="yearMonthHeader"
                                   weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{solicitudReservaSangreBean.reserva.hrsdcirugiapro}"
                                   popupTodayString="Hoy"
                                   popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false"
                                   maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="fechaProgramada" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup/>
                <h:panelGroup>
                  <h:outputText value="Tipo de Reserva"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Componente a Reservar"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Unidades" styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuTipoReserva"
                                    disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                    value="#{solicitudReservaSangreBean.reserva.hrsetiporeserv}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{solicitudReservaSangreBean.lstTipoReserva}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuTipoReserva" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuComponenteReserva"
                                    disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                    value="#{solicitudReservaSangreBean.reserva.hrsecompreserv}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{solicitudReservaSangreBean.lstComponente}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuComponenteReserva"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itCantidad"
                               disabled="#{solicitudReservaSangreBean.modoconsulta}"
                               maxlength="1" style="width:40px"
                               value="#{solicitudReservaSangreBean.reserva.hrsncantidadre}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCantidad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Otros componentes sanguineos"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="outputCuales">
                  <h:outputText value="Cuales" styleClass="labelTextOblig"
                                rendered="#{solicitudReservaSangreBean.mostrarComponentes}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value="Solicitud al Banco de Sangre"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:selectOneRadio id="mnuOtrosComponentes"
                                    disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                    value="#{solicitudReservaSangreBean.reserva.hrseotrcompsan}"
                                    valueChangeListener="#{solicitudReservaSangreBean.setHrseotrcompsan}"
                                    styleClass="labelRadio">
                    <f:selectItems value="#{solicitudReservaSangreBean.lstOpciones}"/>
                    <a4j:support id="supportitComponente" event="onclick"
                                 ignoreDupResponses="true"
                                 action="#{solicitudReservaSangreBean.changeComponentes}"
                                 reRender="outputCuales,inputCuales">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuOtrosComponentes"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="inputCuales">
                  <h:inputText id="itCuales" maxlength="80" style="width:200px"
                               rendered="#{solicitudReservaSangreBean.mostrarComponentes}"
                               disabled="#{solicitudReservaSangreBean.modoconsulta}"
                               value="#{solicitudReservaSangreBean.reserva.hrsccuales}"/>
                  <a4j:outputPanel ajaxRendered="true"  rendered="#{solicitudReservaSangreBean.mostrarComponentes}">
                    <t:message for="itCuales" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itSolicitudBanco" maxlength="80"
                               style="width:200px"
                               disabled="#{solicitudReservaSangreBean.modoconsulta}"
                               value="#{solicitudReservaSangreBean.reserva.hrscsolbancsan}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itSolicitudBanco"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionReservaSangreMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgReservaSangreMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
            <f:subview id="generarCirugia"
                       rendered="#{solicitudReservaSangreBean.generoReserva}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
              </f:verbatim>
            </f:subview>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelBotonesOrden"
                       columnClasses="panelGridBotones">
            <h:panelGroup>
              <a4j:commandButton value="Generar Reserva de Sangre"
                                 disabled="#{solicitudReservaSangreBean.modoconsulta}"
                                 styleClass="boton_fieldset"
                                 reRender="formReservaSangre"
                                 action="#{solicitudReservaSangreBean.aceptar}"/>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelTabBuscadorCie10" label="Bucar Diagnosticos"
                    rendered="#{solicitudReservaSangreBean.mostrarCie10}">
          <a4j:region id="regionCie10" renderRegionOnly="false">
            <a4j:status for="regionCie10">
              <f:facet name="start">
                <t:div id="chargingCie10" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0"
                               border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <s:fieldset legend="Cie10" id="fieldSetCie10" styleClass="fieldset">
              <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp"
                           flush="true"/>
              <h:panelGrid id="panelGridCie10Botones" width="100%"
                           columnClasses="columnaBotonesCentrados" dir="RTL">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCie10Botones1">
                  <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{solicitudReservaSangreBean.aceptarDiagnostico}"
                                     reRender="panelGridReservaSangreTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </a4j:region>
        </t:panelTab>
        <t:panelTab id="panelTabCirugias" label="Bucar Cirugias"
                    rendered="#{solicitudReservaSangreBean.mostrarCirugias}">
          <a4j:region id="regionCirugias" renderRegionOnly="false">
            <a4j:status for="regionCirugias">
              <f:facet name="start">
                <t:div id="chargingCirugias" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0"
                               border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <s:fieldset legend="Cirugias" id="fieldSetCirugias"
                        styleClass="fieldset">
              <jsp:include page="/pages/clinico/registro/buscadorCirugiasReserva.jsp"
                           flush="true"/>
              <h:panelGrid id="panelGridCirugia0Botones" width="100%"
                           columnClasses="columnaBotonesCentrados" dir="RTL">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCirugiaBotones1">
                  <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{solicitudReservaSangreBean.aceptarCirugia}"
                                     reRender="panelGridReservaSangreTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>