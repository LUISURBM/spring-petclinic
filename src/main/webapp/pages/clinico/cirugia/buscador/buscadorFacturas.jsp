<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoUsuario"
                  styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelRegionUsuario"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Fecha Inicial "/>
          <h:outputText value=" Fecha Final "/>
         
         
          <h:panelGrid columns="2">
                <t:inputCalendar id="fechaInicial" monthYearRowClass="yearMonthHeader" 
                                 title="Formato: dd/mm/yyyy"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{buscadorFacturasBean.fechaInicial}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top">
                  <f:validator validatorId="dateMenorIgualValidator"/>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaInicial" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              
              
               <h:panelGrid columns="2">
                <t:inputCalendar id="fechaFinal" monthYearRowClass="yearMonthHeader" 
                                 title="Formato: dd/mm/yyyy"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                 value="#{buscadorFacturasBean.fechaFinal}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11"
                                 size="11" popupButtonImageUrl="/comun/imagenes/32.png"
                                 renderPopupButtonAsImage="true" align="top">
                  <f:validator validatorId="dateMenorIgualValidator"/>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaFinal" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>

        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelBuscarFacturas"
                     columnClasses="columnaBotonesCentrados">
          <h:panelGroup>
            <a4j:outputPanel id="consultarFacturas" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:message for="idButtonUsuarioConsultarFacturas" id="msgInformationConsultarFacturas"
                         styleClass="errorMessage" infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <t:htmlTag value="br"/>
          <a4j:commandButton value="Buscar"
                             action="#{buscadorFacturasBean.consultarFacturas}"
                             reRender="fieldFacturasVigentes"
                             styleClass="btn btn btn-success" id="idButtonUsuarioConsultarFacturas"/>
        </h:panelGrid>
      </s:fieldset>

<s:fieldset legend="Lista Facturas Vigentes" id="fieldFacturasVigentes" styleClass="fieldset">
  <h:panelGrid columns="1" id="panelGridNoFacturasNoSeleccionados"
               rendered="#{empty buscadorFacturasBean.lstExamenesCirugias}">
    <h:outputText value="#{msg.msg_sin_consultar}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFacturasVigentesTable"
               styleClass="tabContainer" rendered="#{not empty buscadorFacturasBean.lstExamenesCirugias}">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="0" cellpadding="0" binding="#{buscadorFacturasBean.dtServicios}" cellspacing="0"
                   value="#{buscadorFacturasBean.lstExamenesCirugias}" rows="10" styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtServicios">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Fecha"/>
          </f:facet>
          <h:outputText value="#{item.ccodfecreg}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Factura"/>
          </f:facet>
         
            <h:panelGrid>
              <h:outputText value="#{item.ccontipdoc.ctdcdescri} #{item.cconnumdoc}"/>
            </h:panelGrid>
         
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Clinica"/>
          </f:facet>
          
            <h:panelGrid>
              <h:outputText value="#{item.cconclinic}"/>
            </h:panelGrid>
        
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Servicio"/>
          </f:facet>
        
            <h:panelGrid>
              <h:outputText value="#{item.ccocservic.csvccodigo} #{item.ccocservic.csvcnombre}"/>
            </h:panelGrid>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Seleccione"/>
          </f:facet>
          <a4j:commandLink id="aceptarFacturas" action="#{buscadorFacturasBean.aceptarFacturas}"
                           reRender="fieldSetFacturaSeleccionada">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_Plantillas" for="dtServicios" fastStep="10" pageCountVar="pageCount"
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
<s:fieldset legend="Factura Seleccionada" id="fieldSetFacturaSeleccionada" styleClass="fieldset_dataTable">
  <h:outputText value="#{buscadorFacturasBean.consultaObject.ccontipdoc.ctdcdescri} #{buscadorFacturasBean.consultaObject.cconnumdoc}"/>
</s:fieldset>