<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="listaRegistrosMedicosForm">
  <a4j:region id="bodyRegionListaRegistrosMedicos">
    <a4j:status for="bodyRegionListaRegistrosMedicos">
      <f:facet name="start">
        <t:div id="chargindListaRegistrosMedicos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridListaRegistrosMedicosTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneListaRegistrosMedicos" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaRegistrosMedicos" label="Registros Médicos ">
          <h:panelGrid id="panelDatosListaRegistrosMedicos" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabContainer">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelActualizarMedicos" columnClasses="panelGridBotones" style="margin-right:5cm;">
              <h:panelGroup>
                <a4j:commandButton value="Actualizar Pacientes" styleClass="btn btn btn-info" action="#{listaCirugiasMedicoBean.cargarCirugias}" status="statusButton"
                                   reRender="panelDatosListaRegistrosMedicos">
                  <a4j:support event="onclick" status="statusButton"/>
                </a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
            <s:fieldset legend="Busqueda Cirugia" id="fieldBuscarCirugiaDia" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsListaCirugiaDia" columnClasses="labelText,labelTextInfo">
                <h:outputText value="Doctor(a): "/>
                <h:outputText id="otnomDoctor" value="#{listaCirugiasMedicoBean.usuarioSystem.curcnombre}"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Consulta: "/>
                <a4j:region renderRegionOnly="false">
                  <t:inputCalendar id="fechaConsultaDia" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{listaCirugiasMedicoBean.fechaCirugia}" popupTodayString="Hoy" popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" valueChangeListener="#{listaCirugiasMedicoBean.setFechaCirugia}" required="true">
                    <a4j:support id="supportmnuLisDia" event="onchange" action="#{listaCirugiasMedicoBean.changeCirugia}"
                                 reRender="fieldSetUsuariosQuirofano,fieldSetUsuarios,fieldSetUsuariosRecuperacion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                </a4j:region>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
              </h:panelGrid>
            </s:fieldset>
            <!-- codigo de cirugias lista para quirofano las cuales estan pendiente para quirofano -->
            <s:fieldset legend="Usuarios en Quirofano" id="fieldSetUsuariosQuirofano" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarQuirofano" rendered="#{empty listaCirugiasMedicoBean.lstCirugiasPendienteQuirofano}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarQuirofano"
                           rendered="#{not empty listaCirugiasMedicoBean.lstCirugiasPendienteQuirofano}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{listaCirugiasMedicoBean.dtCirugiaQuirofano}"
                               value="#{listaCirugiasMedicoBean.lstCirugiasPendienteQuirofano}" rows="10" styleClass="standard_table" rowClasses="standardTable_Row3,standardTable_Row4"
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
                    <h:column rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                      <f:facet name="header">
                        <h:outputText value="Seguimiento" rendered="#{listaCirugiasMedicoBean.esEvolucion}"/>
                      </f:facet>
                      <h:commandLink id="consultarSeguimientoQuirofano" action="#{listaCirugiasMedicoBean.registrarEvolucionQuirofano}" rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                        <t:graphicImage border="0" alt="Registrar Evolución" style="text-align:center" url="/comun/imagenes/Vial-Pills.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esIngresoMedico}">
                      <f:facet name="header">
                        <h:outputText value="Ingreso" rendered="#{listaCirugiasMedicoBean.esIngresoMedico}"/>
                      </f:facet>
                      <h:commandLink id="ingresoSeguimientoQuirofano" action="#{listaCirugiasMedicoBean.registrarIngresoQuirofano}" rendered="#{listaCirugiasMedicoBean.esIngresoMedico}">
                        <t:graphicImage border="0" alt="Registrar Evolución" style="text-align:center" url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esRegistroAnestesia}">
                      <f:facet name="header">
                        <h:outputText value="Registrar Anestesia"/>
                      </f:facet>
                      <h:commandLink id="registrarAnestesiaQuirofano" action="#{listaCirugiasMedicoBean.registrarAnestesiaQuirofano}">
                        <t:graphicImage border="0" alt="Registrar Anestesia " url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_2" for="dtBucarUsuariosQuirofano" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
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
            <!-- codigo de cirugias que estan en ingreso de enfermeria -->
            <s:fieldset legend="Usuarios Pendientes Quirofano" id="fieldSetUsuarios" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultar" rendered="#{empty listaCirugiasMedicoBean.lstCirugiasIngresoEnfermeria}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultar"
                           rendered="#{not empty listaCirugiasMedicoBean.lstCirugiasIngresoEnfermeria}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{listaCirugiasMedicoBean.dtCirugia}" value="#{listaCirugiasMedicoBean.lstCirugiasIngresoEnfermeria}"
                               rows="10" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtBucarUsuarios">
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
                    <h:column rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                      <f:facet name="header">
                        <h:outputText value="Seguimiento" rendered="#{listaCirugiasMedicoBean.esEvolucion}"/>
                      </f:facet>
                      <h:commandLink id="consultarSeguimiento" action="#{listaCirugiasMedicoBean.registrarEvolucion}" rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                        <t:graphicImage border="0" alt="Registrar Evolución" style="text-align:center" url="/comun/imagenes/Vial-Pills.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esIngresoMedico}">
                      <f:facet name="header">
                        <h:outputText value="Ingreso" rendered="#{listaCirugiasMedicoBean.esIngresoMedico}"/>
                      </f:facet>
                      <h:commandLink id="ingresoSeguimiento" action="#{listaCirugiasMedicoBean.registrarIngreso}" rendered="#{listaCirugiasMedicoBean.esIngresoMedico}">
                        <t:graphicImage border="0" alt="Registrar Evolución" style="text-align:center" url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esRegistroAnestesia}">
                      <f:facet name="header">
                        <h:outputText value="Registrar Anestesia"/>
                      </f:facet>
                      <h:commandLink id="registrarAnestesia" action="#{listaCirugiasMedicoBean.registrarAnestesia}">
                        <t:graphicImage border="0" alt="Registrar Anestesia " url="/comun/imagenes/DoctorMale.png"/>
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
            <!-- codigo de cirugias que estan en ingreso de enfermeria -->
            <s:fieldset legend="Usuarios En Recuperación" id="fieldSetUsuariosRecuperacion" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarRecuperacion" rendered="#{empty listaCirugiasMedicoBean.lstCirugiasEnRecuperacion}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarRecuperacion"
                           rendered="#{not empty listaCirugiasMedicoBean.lstCirugiasEnRecuperacion}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{listaCirugiasMedicoBean.dtCirugiaRecuperacion}"
                               value="#{listaCirugiasMedicoBean.lstCirugiasEnRecuperacion}" rows="10" styleClass="standard_table" rowClasses="standardTable_Row5,standardTable_Row4"
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
                    <h:column rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                      <f:facet name="header">
                        <h:outputText value="Seguimiento" rendered="#{listaCirugiasMedicoBean.esEvolucion}"/>
                      </f:facet>
                      <h:commandLink id="consultarSeguimientoRecuperacion" action="#{listaCirugiasMedicoBean.registrarEvolucionRecuperacion}" rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                        <t:graphicImage border="0" alt="Registrar Evolución" style="text-align:center" url="/comun/imagenes/Vial-Pills.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esEvolucion}">
                      <f:facet name="header">
                        <h:outputText value="Tiene Salida" rendered="#{listaCirugiasMedicoBean.esEvolucion}"/>
                      </f:facet>
                      <h:commandLink id="salidaMedicaQuirofano" rendered="#{item.cerrarCirugia}" action="">
                        <t:graphicImage border="0" alt="Salida Medica" url="/comun/imagenes/icon_success_sml.gif"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esIngresoMedico}">
                      <f:facet name="header">
                        <h:outputText value="Ingreso" rendered="#{listaCirugiasMedicoBean.esIngresoMedico}"/>
                      </f:facet>
                      <h:commandLink id="ingresoSeguimientoRecuperacion" action="#{listaCirugiasMedicoBean.registrarIngresoRecuperacion}" rendered="#{listaCirugiasMedicoBean.esIngresoMedico}">
                        <t:graphicImage border="0" alt="Registrar Evolución" style="text-align:center" url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{listaCirugiasMedicoBean.esRegistroAnestesia}">
                      <f:facet name="header">
                        <h:outputText value="Registrar Anestesia"/>
                      </f:facet>
                      <h:commandLink id="registrarAnestesiaRecuperacion" action="#{listaCirugiasMedicoBean.registrarAnestesiaRecuperacion}">
                        <t:graphicImage border="0" alt="Registrar Anestesia " url="/comun/imagenes/DoctorMale.png"/>
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
      <h:panelGroup id="msgModificarListaRegistrosMedicos">
        <a4j:outputPanel id="ajaxRegionMessagesListaRegistrosMedicos" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsListaRegistrosMedicos" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>