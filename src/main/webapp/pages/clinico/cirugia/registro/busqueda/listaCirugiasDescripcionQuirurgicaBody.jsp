<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="listaDescripcionQuirurgicaForm">
  <a4j:region id="bodyRegionListaDescripcionQuirurgica">
    <a4j:status for="bodyRegionListaDescripcionQuirurgica">
      <f:facet name="start">
        <t:div id="chargindListaDescripcionQuirurgica" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridDescripcionQuirurgicaTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneListaDescripcionQuirurgica"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaDescripcionQuirurgica" label="Descripción Quirurgica ">
          <h:panelGrid id="panelDatosListaDescripcionQuirurgica" columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabContainer">
            <s:fieldset legend="Busqueda Cirugia" id="fieldBuscarCirugiaDia" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsListaCirugiaDia" columnClasses="labelText,labelTextInfo">
                <h:outputText value="Doctor(a): "/>
                <h:outputText id="otnomDoctor" value="#{listaCirugiaDescripcionQuirurgicaBean.usuarioSystem.curcnombre}"/>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Consulta: "/>
                <a4j:region renderRegionOnly="false">
                  <t:inputCalendar id="fechaConsultaDia" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                   popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{listaCirugiaDescripcionQuirurgicaBean.fechaHoy}" popupTodayString="Hoy" popupWeekString="Semana"
                                   popupButtonString="Fecha" readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" valueChangeListener="#{listaCirugiaDescripcionQuirurgicaBean.setFechaHoy}" required="true">
                    <a4j:support id="supportmnuLisDiaDescripcionQx" event="onchange" action="#{listaCirugiaDescripcionQuirurgicaBean.changeCirugia}"
                                 reRender="fieldSetDescripcionQuirurgica,fieldSetDescripcionQuirurgicaRecuperacion,fieldSetDescripcionPendienteQuirofano">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </t:inputCalendar>
                </a4j:region>
                <h:outputText value=" "/>
                <h:outputText value=" "/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Usuarios en Quirofano" id="fieldSetDescripcionQuirurgica" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarDescripcionQuirurgica" rendered="#{empty listaCirugiaDescripcionQuirurgicaBean.lstCirugiasIngresadas}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarDescripcionQuirurgica"
                           rendered="#{not empty listaCirugiaDescripcionQuirurgicaBean.lstCirugiasIngresadas}" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{listaCirugiaDescripcionQuirurgicaBean.dtCirugia}"
                               value="#{listaCirugiaDescripcionQuirurgicaBean.lstCirugiasIngresadas}" rows="30" styleClass="standard_table" rowClasses="standardTable_Row3,standardTable_Row4"
                               footerClass="paginacion" id="dtBucarDescripcionQuirurgica">
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
                        <h:outputText value="Descripción Qx"/>
                      </f:facet>
                      <h:commandLink id="registrarDescripcion" action="#{listaCirugiaDescripcionQuirurgicaBean.seleccionarDescripcion}">
                        <t:graphicImage border="0" alt="Registrar Descripción Quirurgica" url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_DescripcionQuirurgica" for="dtBucarDescripcionQuirurgica" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                    paginator="true" immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
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
            <s:fieldset legend="Usuarios pendiente de Quirofano" id="fieldSetDescripcionPendienteQuirofano" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarDescripcionPendientesQuirofano" rendered="#{empty listaCirugiaDescripcionQuirurgicaBean.lstCirugiasPendientes}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarPendientes"
                           rendered="#{not empty listaCirugiaDescripcionQuirurgicaBean.lstCirugiasPendientes}" styleClass="tabContainer">
                <t:buffer into="#{table_Pendiente}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{listaCirugiaDescripcionQuirurgicaBean.dtCirugiaPendientes}"
                               value="#{listaCirugiaDescripcionQuirurgicaBean.lstCirugiasPendientes}" rows="30" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtBucarDescripcionPendiente">
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
                        <h:outputText value="Descripción Qx"/>
                      </f:facet>
                      <h:commandLink id="registrarDescripcionPendiente" action="#{listaCirugiaDescripcionQuirurgicaBean.seleccionarDescripcionPendientes}">
                        <t:graphicImage border="0" alt="Registrar Descripción Quirurgica" url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller_Pendiente}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Pendiente" for="dtBucarDescripcionPendiente" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
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
                <h:outputText value="#{tableScroller_Pendiente}" escape="false"/>
                <h:outputText value="#{table_Pendiente}" escape="false"/>
                <h:outputText value="#{tableScroller_Pendiente}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
            <s:fieldset legend="Usuarios en Recuperación" id="fieldSetDescripcionQuirurgicaRecuperacion" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridConsultarDescripcionQuirurgicaRecuperacion" rendered="#{empty listaCirugiaDescripcionQuirurgicaBean.lstCirugiasRecuperacion}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsConsultarDescripcionQuirurgicaRecuperacion"
                           rendered="#{not empty listaCirugiaDescripcionQuirurgicaBean.lstCirugiasRecuperacion}" styleClass="tabContainer">
                <t:buffer into="#{table_Recuperacion}">
                  <h:dataTable var="itemrecu" border="1" cellpadding="0" cellspacing="0" binding="#{listaCirugiaDescripcionQuirurgicaBean.dtCirugiaRecuperacion}"
                               value="#{listaCirugiaDescripcionQuirurgicaBean.lstCirugiasRecuperacion}" rows="30" styleClass="standard_table" rowClasses="standardTable_Row5,standardTable_Row4"
                               footerClass="paginacion" id="dtBucarDescripcionRecuperacion">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Procedimiento"/>
                      </f:facet>
                      <h:outputText value="#{itemrecu.nombreServicio}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Identificación"/>
                      </f:facet>
                      <h:outputText value="#{itemrecu.hcplusuario.husetipoiden} #{itemrecu.hcplusuario.husanumeiden}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Usuario"/>
                      </f:facet>
                      <h:outputText value="#{itemrecu.hcplusuario.huscprimernomb} #{itemrecu.hcplusuario.huscsegundnomb} #{itemrecu.hcplusuario.huscprimerapel} #{itemrecu.hcplusuario.huscsegundapel}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hora programación"/>
                      </f:facet>
                      <h:outputText value="#{itemrecu.hcpchoradurac} : #{itemrecu.hcpcminutdurac} "/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripción Qx"/>
                      </f:facet>
                      <h:commandLink id="registrarDescripcionRecuperacion" action="#{listaCirugiaDescripcionQuirurgicaBean.seleccionarDescripcionRecuperacion}">
                        <t:graphicImage border="0" alt="Consultar Descripción Quirurgica" url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller_Recuperacion}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Recuperacion" for="dtBucarDescripcionRecuperacion" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
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
                <h:outputText value="#{tableScroller_Recuperacion}" escape="false"/>
                <h:outputText value="#{table_Recuperacion}" escape="false"/>
                <h:outputText value="#{tableScroller_Recuperacion}" escape="false"/>
              </h:panelGrid>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid>
      <h:panelGroup id="msgModificarListaDescripcionQuirurgica">
        <a4j:outputPanel id="ajaxRegionMessagesListaDescripcionQuirurgica" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsDescripcionQuirurgica" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>