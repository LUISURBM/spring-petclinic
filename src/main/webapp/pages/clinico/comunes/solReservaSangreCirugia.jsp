<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReservaSangreTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneReservaSangre"
                     selectedIndex="#{reservaSangreUsuarioBean.selectedIndex}" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabReservaSangre" label="Reserva de Sangre"
                disabled="#{reservaSangreUsuarioBean.mostrarCie10 || reservaSangreUsuarioBean.mostrarCirugias}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReservaSangre"
                   styleClass="tabContainer">
        <s:fieldset legend="Diagnostico" id="fieldDiagnostico" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDiagnostico"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Seleccionado" styleClass="labelTextOblig"/>
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink rendered="#{!reservaSangreUsuarioBean.modoconsulta}"
                               action="#{reservaSangreUsuarioBean.mostrarDiagnostico}"
                               reRender="panelGridReservaSangreTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPrin" immediate="true" styleClass="textmayuscula"
                           disabled="#{reservaSangreUsuarioBean.modoconsulta}" onkeydown="return blockEnter(event);"
                           binding="#{reservaSangreUsuarioBean.itDiagnostico}"
                           value="#{reservaSangreUsuarioBean.reserva.hrscdiagprin}"
                           valueChangeListener="#{reservaSangreUsuarioBean.setHrscdiagprin}" style="width:50px"
                           maxlength="4">
                            <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPrin" event="onchange" immediate="true" ignoreDupResponses="true"
                             action="#{reservaSangreUsuarioBean.changeDiagnostico}"
                             reRender="panelGridReservaSangreTab">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPrin" styleClass="errorMessage"/>
              </a4j:outputPanel>
              <h:panelGroup id="panelDiagnosticoPrincipal">
                <h:outputText value=" #{reservaSangreUsuarioBean.diagnosticoPrincipal}" styleClass="buscador"/>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Cirugias Programadas" id="fieldCirugias" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugias"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Buscar Cirugias"/>
            <h:outputText/>
            <a4j:commandLink value="" immediate="true" rendered="#{!reservaSangreUsuarioBean.modoconsulta}"
                             title="Seleccionar Cirugias" action="#{reservaSangreUsuarioBean.consultarCirugias}"
                             reRender="panelGridReservaSangreTab" id="idButt">
              <t:graphicImage alt="" id="imagelupa" border="0" url="/comun/imagenes/lupa.gif"/>
            </a4j:commandLink>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="imagelupa" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
          <h:panelGrid columns="1" id="panelGridNoCirugias"
                       rendered="#{empty reservaSangreUsuarioBean.lstExamenesCirugias}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty reservaSangreUsuarioBean.lstExamenesCirugias}" cellspacing="0" width="100%"
                       id="tableContentTabsBucar" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                           binding="#{reservaSangreUsuarioBean.dtCirugia}"
                           value="#{reservaSangreUsuarioBean.lstExamenesCirugias}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
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
                <h:column rendered="#{!reservaSangreUsuarioBean.modoconsulta}">
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <a4j:commandLink id="aceptarCirugias" immediate="true"
                                   rendered="#{!reservaSangreUsuarioBean.modoconsulta}" reRender="fieldCirugias"
                                   action="#{reservaSangreUsuarioBean.eliminarCirugia}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtBucarCirugiasReserva" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
        </s:fieldset>
        <s:fieldset legend="Reserva de Sangre" id="fieldReserva" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelReservaSangre"
                       rowClasses="labelText,labelTextInfo">
            <h:panelGroup>
              <h:outputText value="Condiciones M�dicas Alteran Autodonaci�n " styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Fecha Programada"/>
            </h:panelGroup>
            <h:panelGroup/>
            <h:panelGroup>
              <h:selectOneRadio id="mnuCondicionesAlteran" disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                                value="#{reservaSangreUsuarioBean.reserva.hrseconmedalta}" styleClass="labelRadio"
                                onkeydown="return blockEnter(event);">
                <f:selectItems value="#{reservaSangreUsuarioBean.lstOpciones}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuCondicionesAlteran" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="itCalendarFechaProgramada">
              <t:inputCalendar id="fechaProgramada" disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                               title="Formato: dd/mm/yyyy" onkeydown="return blockEnter(event);"
                               monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                               currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                               value="#{reservaSangreUsuarioBean.reserva.hrsdcirugiapro}" popupTodayString="Hoy"
                               popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                               size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                               renderPopupButtonAsImage="true" align="top">
                <f:validator validatorId="dateMayorIgualValidator"/>
              </t:inputCalendar>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="fechaProgramada" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup/>
            <h:panelGroup>
              <h:outputText value="Tipo de Reserva" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Componente a Reservar" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Unidades" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuTipoReserva" disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                                onkeydown="return blockEnter(event);"
                                value="#{reservaSangreUsuarioBean.reserva.hrsetiporeserv}" styleClass="labelRadio">
                <f:selectItems value="#{reservaSangreUsuarioBean.lstTipoReserva}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuTipoReserva" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:selectOneRadio id="mnuComponenteReserva" disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                                value="#{reservaSangreUsuarioBean.reserva.hrsecompreserv}" styleClass="labelRadio"
                                onkeydown="return blockEnter(event);">
                <f:selectItems value="#{reservaSangreUsuarioBean.lstComponente}"/>
              </h:selectOneRadio>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuComponenteReserva" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:inputText id="itCantidad" onkeydown="return blockEnter(event);"
                           disabled="#{reservaSangreUsuarioBean.modoconsulta}" maxlength="1" style="width:40px"
                           value="#{reservaSangreUsuarioBean.reserva.hrsncantidadre}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCantidad" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Otros componentes sanguineos" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:panelGroup id="outputCuales">
              <h:outputText value="Cuales" styleClass="labelTextOblig"
                            rendered="#{reservaSangreUsuarioBean.mostrarComponentes}"/>
            </h:panelGroup>
            <h:panelGroup id="paneloutputCantidadOtros">
              <h:outputText value="Cantidad " styleClass="labelTextOblig"
                            rendered="#{reservaSangreUsuarioBean.mostrarComponentes}"/>
            </h:panelGroup>
            <h:panelGroup>
            <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuOtrosComponentes" onkeydown="return blockEnter(event);"
                                disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                                value="#{reservaSangreUsuarioBean.reserva.hrseotrcompsan}"
                                valueChangeListener="#{reservaSangreUsuarioBean.setHrseotrcompsan}"
                                styleClass="labelRadio">
                <f:selectItems value="#{reservaSangreUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportitComponente" event="onclick" ignoreDupResponses="true"
                             action="#{reservaSangreUsuarioBean.changeComponentes}"
                             reRender="outputCuales,inputCuales,panelInputCantidadOtros,paneloutputCantidadOtros">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:selectOneRadio>
              </a4j:region>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="mnuOtrosComponentes" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="inputCuales">
              <h:inputText id="itCuales" onkeydown="return blockEnter(event);" maxlength="80" style="width:200px"
                           rendered="#{reservaSangreUsuarioBean.mostrarComponentes}"
                           disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                           value="#{reservaSangreUsuarioBean.reserva.hrsccuales}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCuales" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup id="panelInputCantidadOtros">
              <h:inputText id="itCantidadOtros" onkeydown="return blockEnter(event);"
                           rendered="#{reservaSangreUsuarioBean.mostrarComponentes}"
                           disabled="#{reservaSangreUsuarioBean.modoconsulta}" maxlength="1" style="width:40px"
                           value="#{reservaSangreUsuarioBean.reserva.hrsncantiotros}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itCantidadOtros" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
              <h:outputText value="Solicitud al Banco de Sangre" styleClass="labelTextOblig"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup>
              <h:inputText id="itSolicitudBanco" onkeydown="return blockEnter(event);" maxlength="80"
                           style="width:200px" disabled="#{reservaSangreUsuarioBean.modoconsulta}"
                           value="#{reservaSangreUsuarioBean.reserva.hrscsolbancsan}"/>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itSolicitudBanco" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:outputText value=""/>
          </h:panelGrid>
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionReservaSangreMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgReservaSangreMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                        infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                     columnClasses="panelGridBotones">
          <a4j:commandButton value="Generar Reserva de Sangre" styleClass="btn btn btn-success"
                             reRender="panelGridReservaSangreTab" action="#{reservaSangreUsuarioBean.aceptar}"/>
        </h:panelGrid>
      </h:panelGrid>
      <f:subview id="generarCirugia" rendered="#{reservaSangreUsuarioBean.generoReserva}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </t:panelTab>
    <t:panelTab id="panelTabBuscadorCie10" label="Bucar Diagnosticos"
                rendered="#{reservaSangreUsuarioBean.mostrarCie10}">
      <a4j:region id="regionCie10" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionCie10">
          <f:facet name="start">
            <t:div id="chargingCie10" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <s:fieldset legend="Cie10" id="fieldSetCie10" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
          <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupCie10Botones1">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{reservaSangreUsuarioBean.aceptarDiagnostico}"
                                 reRender="panelGridReservaSangreTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
    <t:panelTab id="panelTabCirugias" label="Bucar Cirugias" rendered="#{reservaSangreUsuarioBean.mostrarCirugias}">
      <a4j:region id="regionCirugias" renderRegionOnly="false">
        <a4j:status for="regionCirugias">
          <f:facet name="start">
            <t:div id="chargingCirugias" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <s:fieldset legend="Cirugias" id="fieldSetCirugias" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorCirugiasReserva.jsp" flush="true"/>
          <h:panelGrid id="panelGridCirugia0Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupCirugiaBotones1">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{reservaSangreUsuarioBean.aceptarCirugia}"
                                 reRender="panelGridReservaSangreTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>