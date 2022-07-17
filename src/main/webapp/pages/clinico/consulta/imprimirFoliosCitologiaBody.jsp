<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="formImprimirCitologia">
  <a4j:region id="regionImprimirCitologia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionImprimirCitologia">
      <f:facet name="start">
        <t:div id="chargingImprimirCitologia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" id="tableInfoUbicationImprimirCitlogia" border="0" cellpadding="0" cellspacing="0"
                 width="100%" columnClasses="td_ubicador">
      <h:outputText value="HISTORIAS CLINICAS >> Citologia >> Imprimir Citologia " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableContentTabsImprimirCitologia" styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="tabbedPaneImprimirCitologia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <s:fieldset legend="Busqueda Citologias" id="fieldImprimirCitologia" styleClass="fieldset">
          <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="10" width="100%"
                       id="tableContentImprimirCitologia" columnClasses="labelText,labelTextInfo">
            <h:outputText value="Doctor(a): "/>
            <h:outputText id="otnomDoctorImpresionCitologia" value="#{imprimirCitologiaBean.usuarioSystem.curcnombre}"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value="Fecha Consulta: "/>
            <t:inputCalendar id="fechaCitologia" title="Formato: dd/MM/yyyy" monthYearRowClass="yearMonthHeader"
                             weekRowClass="weekHeader" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                             renderAsPopup="true" value="#{imprimirCitologiaBean.fechaActual}" popupTodayString="Hoy"
                             popupWeekString="Semana" popupButtonString="Fecha" readonly="false" disabled="false"
                             maxlength="11" size="11" immediate="true"
                             popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                             align="top" valueChangeListener="#{imprimirCitologiaBean.setFechaActual}" required="true">
              <a4j:support id="supportmnuLisCitologia" event="onchange" immediate="true"
                           action="#{imprimirCitologiaBean.changeCitologias}" reRender="formImprimirCitologia">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
          </h:panelGrid>
        </s:fieldset>
        
        
        
        <s:fieldset legend="Resultados Consulta" id="fieldSetImprimirCitologia" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridImprimirCitologia"
                     rendered="#{empty imprimirCitologiaBean.lstCitologia}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsImpCitologia"
                     rendered="#{not empty imprimirCitologiaBean.lstCitologia}" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{imprimirCitologiaBean.dtCitologia}"
                         value="#{imprimirCitologiaBean.lstCitologia}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" 
                         footerClass="paginacion" id="dtCitologiaFolios">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha"/>
                </f:facet>
                <h:outputText value="#{item.hcodfecregistr}"/>
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
                  <h:outputText value="Imprimir"/>
                </f:facet>
                 <t:commandLink id="imprimirCitlogia"
                                 action="#{imprimirCitologiaBean.ImprimirCitologia}">
                    <t:graphicImage alt=""  border="0"
                                    url="/comun/imagenes/pdf.gif"/>
                                    
                  </t:commandLink>
              </h:column>
              
              
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Citologias" for="dtCitologiaFolios" fastStep="10" pageCountVar="pageCount"
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
    
    </t:panelTabbedPane>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionImprimirCitologia" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgImprimirCitologia" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
      <f:subview id="generarCitologia" rendered="#{imprimirCitologiaBean.generoCitologia}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600","dependent=no,directories=no,menubar=no" );
    </script>
            </f:verbatim>
        </f:subview>
  
  </a4j:region>
   
     
</a4j:form>