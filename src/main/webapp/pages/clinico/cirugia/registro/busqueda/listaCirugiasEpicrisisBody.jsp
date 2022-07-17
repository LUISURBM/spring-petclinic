<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="listaEpicrisisForm">
  <a4j:region id="bodyRegionListaEpicrisis">
    <a4j:status for="bodyRegionListaEpicrisis">
      <f:facet name="start">
        <t:div id="chargindListaRegistrosEpicrisis" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridListaEpicrisisTab" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneListaEpicrisis" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabListaRegistrosEpicrisis" label="Epicrisis ">
          <h:panelGrid id="panelDatosListaEpicrisis" columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" styleClass="tabContainer">
                       
                       
   <s:fieldset legend="Busqueda Cirugia" id="fieldBuscarCirugiaDia" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsListaEpicrisis" columnClasses="labelText,labelTextInfo">
            
            <h:outputText value="Doctor(a): "/>
            <h:outputText id="otnomDoctor" value="#{listaCirugiaEpicrisisBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>          
            
            
            <h:outputText value="Fecha Cirugia: "/>
            <a4j:region renderRegionOnly="false">
            <t:inputCalendar id="fechaConsultaDiaEpicrisis" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{listaCirugiaEpicrisisBean.fechaHoy}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" valueChangeListener="#{listaCirugiaEpicrisisBean.setFechaHoy}" required="true">
              <a4j:support id="supportmnuLisDiaEpicrisis" event="onchange" 
              action="#{listaCirugiaEpicrisisBean.changeCirugia}" reRender="fieldSetEpicrisis">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
            </a4j:region>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            
          </h:panelGrid>
        </s:fieldset>
                       
            <s:fieldset legend="Usuarios" id="fieldSetEpicrisis" styleClass="fieldset_dataTable">
              <h:panelGrid columns="1" id="panelGridEpicrisis"
                           rendered="#{empty listaCirugiaEpicrisisBean.lstCirugiasIngresadas}">
                <h:outputText value="#{msg.msg_sin_consultar}"/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="tableContentTabsEpicrisis"
                           rendered="#{not empty listaCirugiaEpicrisisBean.lstCirugiasIngresadas}"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{listaCirugiaEpicrisisBean.dtCirugia}"
                               value="#{listaCirugiaEpicrisisBean.lstCirugiasIngresadas}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtBucarEpicrisis">
                               
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
                     <h:column rendered="#{item.chdescrquiru != null}">
                      <f:facet name="header">
                        <h:outputText value="Registrar Epicrisis"/>
                      </f:facet>
                      <h:commandLink id="registrarEpicrisis" 
                            action="#{listaCirugiaEpicrisisBean.registrarEpicrisis}">
                        <t:graphicImage border="0" alt="Registrar Epicrisis " url="/comun/imagenes/DoctorMale.png"/>
                      </h:commandLink>
                    </h:column>
                    <h:column rendered="#{item.chdescrquiru == null}">
                      <f:facet name="header">
                        <h:outputText value="Registrar Epicrisis"/>
                      </f:facet>
                      <a4j:commandLink id="registrarEpicrisisAlert"
                            onclick="if(!confirm(\' Usuario sin descripción quirúrgica en sistema ¿desea continuar? \')){ return false; }"
                            action="#{listaCirugiaEpicrisisBean.registrarEpicrisis}">
                        <t:graphicImage border="0" alt="Registrar Epicrisis " url="/comun/imagenes/DoctorMale.png"/>
                      </a4j:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_epicrisis" for="dtBucarEpicrisis" fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
      <h:panelGroup id="msgModificarListaEpicrisis">
        <a4j:outputPanel id="ajaxRegionMessagesListaEpicrisis" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsListaEpicrisis" showSummary="true" errorClass="error"
                      globalOnly="true" layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>