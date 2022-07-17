<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

   <s:fieldset legend="Disponibilidad Salas de Cirugia" id="fieldDatosDisponibilidadSala" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%" id="tableContentTabsDisponibilidadSala" columnClasses="labelText,labelTextInfo">
                        
            <h:outputText value="Fecha: "/>
            <h:outputText value=" "/>
            <t:inputCalendar id="fechaDisponibilidad" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" currentDayCellClass="currentDayCell" styleClass="input-small"
                             popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{buscadorDisponibilidadSalaBean.fechaActual}" popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                             readonly="false" disabled="false" maxlength="11" size="11" immediate="true" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" valueChangeListener="#{buscadorDisponibilidadSalaBean.setFechaActual}">
               <a4j:support id="supportmnuLis" event="onchange" immediate="true" action="#{buscadorDisponibilidadSalaBean.changeAgendaCirugia}" 
                                reRender="fieldSetDisponibilidadSalas">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
            
            <h:outputText value=" "/>
            
          </h:panelGrid>
        </s:fieldset>

<s:fieldset legend="Programación Salas " id="fieldSetDisponibilidadSalas" styleClass="fieldset_dataTable">
  <h:panelGrid columns="1" id="panelGridDisponibilidadSalas" rendered="#{!buscadorDisponibilidadSalaBean.existeCirugia}">
    <h:outputText value="#{buscadorDisponibilidadSalaBean.msg_sin_registros}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsDisponibilidadSalas"
               rendered="#{buscadorDisponibilidadSalaBean.existeCirugia}" styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   value="#{buscadorDisponibilidadSalaBean.lstCirugias}" rows="10" styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtSalas">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Numero Sala"/>
          </f:facet>
          <h:outputText value="#{item.hcpnsalainterv}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Hora Inicio"/>
          </f:facet>
          <h:outputText value="#{item.hcpdfechacirug}">
            <f:convertDateTime pattern="h.mm a"/>
          </h:outputText>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Hora Fin"/>
          </f:facet>
          <h:outputText value="#{item.hcpdfechfincir}">
             <f:convertDateTime pattern="h.mm a"/>
          </h:outputText>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_Salas" for="dtSalas" fastStep="10" pageCountVar="pageCount"
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