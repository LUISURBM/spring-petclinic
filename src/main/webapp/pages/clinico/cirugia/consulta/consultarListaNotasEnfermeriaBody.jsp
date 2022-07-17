<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="actualizarPersonalForm">
  <a4j:region id="bodyRegionListaNotasEnfermeria">
    <a4j:status for="bodyRegionListaNotasEnfermeria">
      <f:facet name="start">
        <t:div id="chargindListaNotasEnfermeria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <rich:panel>
      <rich:dataGrid value="#{consultarListaNotasEnfermeria.lstCirugiasSiguiente}" var="cirugia" columns="4">
        <h:panelGrid columns="4" styleClass="label label-warning" border="0">
          <h:outputText value="Siguiente Paciente es:"/>
          <h:outputText value=""/>
          <h:outputText value="#{cirugia.hcplusuario.huscprimernomb} #{cirugia.hcplusuario.huscsegundnomb} #{cirugia.hcplusuario.huscprimerapel} #{cirugia.hcplusuario.huscsegundapel}"/>
          <h:outputText value=""/>
          <h:outputText value="Identificación:"/>
          <h:outputText value=""/>
          <h:outputText value="#{cirugia.hcplusuario.husetipoiden} #{cirugia.hcplusuario.husanumeiden}"/>
          <h:outputText value=""/>
          <h:outputText value="Procedimiento"/>
          <h:outputText value=""/>
          <h:outputText value="#{cirugia.nombreServicio}"/>
          <h:outputText value=""/>
        </h:panelGrid>
      </rich:dataGrid>
    </rich:panel>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridListaNotasEnfermeriaTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneListaNotasEnfermeria" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaNotasEnfermeria" label="Registro de enfermería">
          <h:panelGrid id="panelDatosListaNotasEnfermeria" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabContainer">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelActualizarMedicamentos" columnClasses="panelGridBotones" style="margin-right:5cm;">
              <h:panelGroup>
                <a4j:commandButton value="Actualizar Pacientes" styleClass="btn btn btn-info" action="#{consultarListaNotasEnfermeria.cargarCirugias}" status="statusButton"
                                   reRender="panelDatosListaNotasEnfermeria">
                  <a4j:support event="onclick" status="statusButton"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <s:fieldset legend="Busqueda Cirugia" id="fieldBuscarCirugiaDiaNota" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsListaCirugiaDiaNota" columnClasses="labelText,labelTextInfo">
                <h:outputText value="Doctor(a): "/>
                <h:outputText id="otnomDoctorNota" value="#{consultarListaNotasEnfermeria.usuarioSystem.curcnombre}"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Cirugia: "/>
                <a4j:region renderRegionOnly="false">
                  <t:inputCalendar id="fechaConsultaDiaNota" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{consultarListaNotasEnfermeria.fechaHoy}" popupTodayString="Hoy" popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" valueChangeListener="#{consultarListaNotasEnfermeria.setFechaHoy}" required="true">
                    <a4j:support id="supportmnuLisDiaNota" event="onchange" action="#{consultarListaNotasEnfermeria.changeCirugia}"
                                 reRender="fieldSetUsuariosQuirofano,fieldSetUsuarios,fieldSetUsuariosRecuperacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                </a4j:region>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Cirugias en Quirofano" id="fieldSetUsuariosQuirofano" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarQuirofano" rendered="#{empty consultarListaNotasEnfermeria.lstCirugiasIngresadasQuirofano}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarQuirofano"
                           rendered="#{not empty consultarListaNotasEnfermeria.lstCirugiasIngresadasQuirofano}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{consultarListaNotasEnfermeria.dtCirugiaQuirofano}"
                               value="#{consultarListaNotasEnfermeria.lstCirugiasIngresadasQuirofano}" rows="30" styleClass="standard_table" rowClasses="standardTable_Row3,standardTable_Row4"
                               footerClass="paginacion" id="dtBucarUsuariosQuirofano">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Procedimiento"/>
                      </f:facet>
                      <h:outputText value="#{item.nombreServicio}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Identificación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcplusuario.husetipoiden} #{item.hcplusuario.husanumeiden}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Usuario"/>
                      </f:facet>
                      <h:outputText value="#{item.hcplusuario.huscprimernomb} #{item.hcplusuario.huscsegundnomb} #{item.hcplusuario.huscprimerapel} #{item.hcplusuario.huscsegundapel}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hora programación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcpchoradurac} : #{item.hcpcminutdurac} "/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Notas"/>
                      </f:facet>
                      <h:commandLink id="consultarNotasEnfermeriaIngreso" action="#{consultarListaNotasEnfermeria.registrarNotasEnfermeriaQuirofano}">
                        <t:graphicImage border="0" alt="Registrar Notas de Enfermeria" url="/comun/imagenes/Prescription.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Dar de Alta"/>
                      </f:facet>
                      <h:commandLink id="salidaEnfermeriaQuirofano" rendered="#{item.cerrarCirugia}" action="#{consultarListaNotasEnfermeria.registrarSalidaEnfermeriaQuirofano}">
                        <t:graphicImage border="0" alt="Registrar Salida de Enfermeria" url="/comun/imagenes/salida.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_2" for="dtBucarUsuarios" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif" border="0" alt=""/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Cirugias Pendientes de Quirofano" id="fieldSetUsuarios" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultar" rendered="#{empty consultarListaNotasEnfermeria.lstCirugiasIngresadasEnfermeria}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultar"
                           rendered="#{not empty consultarListaNotasEnfermeria.lstCirugiasIngresadasEnfermeria}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{consultarListaNotasEnfermeria.dtCirugia}"
                               value="#{consultarListaNotasEnfermeria.lstCirugiasIngresadasEnfermeria}" rows="30" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtBucarUsuarios">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Procedimiento"/>
                      </f:facet>
                      <h:outputText value="#{item.nombreServicio}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Identificación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcplusuario.husetipoiden} #{item.hcplusuario.husanumeiden}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Usuario"/>
                      </f:facet>
                      <h:outputText value="#{item.hcplusuario.huscprimernomb} #{item.hcplusuario.huscsegundnomb} #{item.hcplusuario.huscprimerapel} #{item.hcplusuario.huscsegundapel}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hora programación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcpchoradurac} : #{item.hcpcminutdurac} "/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Notas"/>
                      </f:facet>
                      <h:commandLink id="consultarNotasEnfermeria" action="#{consultarListaNotasEnfermeria.registrarNotasEnfermeria}">
                        <t:graphicImage border="0" alt="Registrar Notas de Enfermeria" url="/comun/imagenes/Prescription.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Dar de Alta"/>
                      </f:facet>
                      <h:commandLink id="salidaEnfermeria" rendered="#{item.cerrarCirugia}" action="#{consultarListaNotasEnfermeria.registrarSalidaEnfermeria}">
                        <t:graphicImage border="0" alt="Registrar Salida de Enfermeria" url="/comun/imagenes/salida.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtBucarUsuarios" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif" border="0" alt=""/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Usuarios en Recuperación " id="fieldSetUsuariosRecuperacion" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarRecuperacion" rendered="#{empty consultarListaNotasEnfermeria.lstCirugiasEnRecuperacion}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarRecuperacion"
                           rendered="#{not empty consultarListaNotasEnfermeria.lstCirugiasEnRecuperacion}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{consultarListaNotasEnfermeria.dtCirugiaRecuperacion}"
                               value="#{consultarListaNotasEnfermeria.lstCirugiasEnRecuperacion}" rows="30" styleClass="standard_table" rowClasses="standardTable_Row5,standardTable_Row4"
                               footerClass="paginacion" id="dtBucarUsuariosRecuperacion">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Procedimiento"/>
                      </f:facet>
                      <h:outputText value="#{item.nombreServicio}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Identificación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcplusuario.husetipoiden} #{item.hcplusuario.husanumeiden}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Usuario"/>
                      </f:facet>
                      <h:outputText value="#{item.hcplusuario.huscprimernomb} #{item.hcplusuario.huscsegundnomb} #{item.hcplusuario.huscprimerapel} #{item.hcplusuario.huscsegundapel}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hora programación"/>
                      </f:facet>
                      <h:outputText value="#{item.hcpchoradurac} : #{item.hcpcminutdurac} "/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Notas"/>
                      </f:facet>
                      <h:commandLink id="consultarNotasEnfermeriaRecuperacion" action="#{consultarListaNotasEnfermeria.registrarNotasEnfermeriaRecuperacion}">
                        <t:graphicImage border="0" alt="Registrar Notas de Enfermeria" url="/comun/imagenes/Prescription.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Dar de Alta "/>
                      </f:facet>
                      <h:commandLink id="salidaEnfermeriaRecuperacion" rendered="#{item.cerrarCirugia}" 
                      action="#{consultarListaNotasEnfermeria.registrarSalidaEnfermeriaRecuperacion}">
                        <t:graphicImage border="0" alt="Registrar Salida de Enfermeria" url="/comun/imagenes/salida.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_3" for="dtBucarUsuariosRecuperacion" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage url="/comun/imagenes/primero.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage url="/comun/imagenes/anterior.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage url="/comun/imagenes/adelante.gif" border="0" alt=""/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage url="/comun/imagenes/atras.gif" border="0" alt=""/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarListaNotasEnfermeria">
        <a4j:outputPanel id="ajaxRegionMessagesListaNotasEnfermeria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsListaNotasEnfermeria" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    <!--<f:facet name="popup">
        <h:panelGroup>
          <h:panelGrid columns="2">
            <h:graphicImage url="/comun/imagenes/doctorPausaEnfermeria.jpg" alt="doctorPausaEnfermeria" width="600"
                            height="400"/>
          </h:panelGrid>
        </h:panelGroup>
      </f:facet>-->
  </a4j:region>
</a4j:form>