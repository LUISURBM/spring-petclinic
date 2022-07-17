<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="ReporteConsultasAbiertasForm">
  <a4j:region id="bodyRegionReporteConsultasAbiertas">
    <a4j:status id="statusButton" for="bodyRegionReporteConsultasAbiertas">
      <f:facet name="start">
        <t:div id="charginReporteGestacion" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridReporteGestacionTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteConsultasAbiertas" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteConsultasAbiertas" label="Reporte Consultas sin Cerrar ">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridReporteConsultasAbiertas">
            <s:fieldset legend="Datos Busqueda" id="fieldReporteConsultasAbiertas" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosReporteConsultasAbiertas" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Fecha Inicial " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Fecha Final " styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <t:inputCalendar id="fechaInicialReporteConsultasAbiertas" title="Formato: dd/mm/yyyy"
                                 monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteConsultasAbiertasBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicialReporteConsultasAbiertas" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <t:inputCalendar id="fechaFinalReporteConsultasAbiertas" monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{reporteConsultasAbiertasBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinalReporteConsultasAbiertas" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
            </s:fieldset>
            
     <s:fieldset legend="Consultas sin cerrar" id="fieldSetInfoReporteConsultasAbiertas" styleClass="fieldset">
            <h:commandLink action="#{reporteConsultasAbiertasBean.generarReporteConsultasAbiertas}"
                              rendered="#{not empty reporteConsultasAbiertasBean.lstConsultasAbiertas}" 
                            immediate="true"
                             title="Imprimir Reporte">
              <t:graphicImage alt="Imprimir Reporte" title="Imprimir Reporte" border="0"
                              url="/comun/imagenes/print_Spa.gif"/>
            </h:commandLink>
        <h:panelGrid columns="1" id="panelGridInfoReporteConsultasAbiertas" 
                rendered="#{empty reporteConsultasAbiertasBean.lstConsultasAbiertas}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                       id="tableContentTabsReporteConsultasAbiertas"
                       rendered="#{not empty reporteConsultasAbiertasBean.lstConsultasAbiertas}" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{reporteConsultasAbiertasBean.lstConsultasAbiertas}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" 
                         binding="#{reporteConsultasAbiertasBean.dtConsultasAbiertas}"
                         footerClass="paginacion" id="dtConsultasAbiertas">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha"/>
                </f:facet>
                <h:outputText value="#{item.hcodfecregistr}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Consulta"/>
                </f:facet>
                <h:outputText value="#{item.hcolnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcolusuario.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcolusuario.huscprimernomb} #{item.hcolusuario.huscprimerapel}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Servicio"/>
                </f:facet>
                <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
              </h:column>    
              
               <h:column>
                <f:facet name="header">
                  <h:outputText value="Profesional"/>
                </f:facet>
                <h:outputText value="#{item.hcocoperador}"/>
              </h:column>
              
              
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Citologias" for="dtConsultasAbiertas" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionReporteConsultasAbiertas" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfReporteConsultasAbiertas" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonReporteConsultasAbiertas" columnClasses="panelGridBotones">
              <h:commandButton value="Generar Reporte" styleClass="boton_fieldset" 
                   action="#{reporteConsultasAbiertasBean.generarConsultasAbiertas}">
                     <a4j:support event="onclick" status="statusButton"/>
                   </h:commandButton>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
        <h:commandLink action="#{reporteConsultasAbiertasBean.volverInicio}" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
      <f:subview id="generarReporteConsultasAbiertas" rendered="#{reporteConsultasAbiertasBean.generoReporte}">
              <f:verbatim>
                <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
              </f:verbatim>
            </f:subview>
</a4j:form>