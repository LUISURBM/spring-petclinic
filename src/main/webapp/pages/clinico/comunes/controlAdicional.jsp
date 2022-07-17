<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControlSinCostoTab" 
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" 
                     activePanelTabVar="true" width="100%" id="panelTabbedPaneControlSinCosto" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" 
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" 
                     inactiveSubStyleClass="inactiveSub" selectedIndex="#{controlSinCostoUsuarioBean.selectedIndex}"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabControlSinCosto" label="Control Adicional"
                rendered="#{not controlSinCostoUsuarioBean.mostrarControles}">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControl"
                   styleClass="tabContainer">
        <s:fieldset legend="Control Adicional" id="fieldControlAdi" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelControlAdi"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Servicios Propuestos" styleClass="labelTextOblig"/>
            <h:outputText/>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta">
            <a4j:commandLink value="" immediate="true" title="Seleccionar Servicios"
                    rendered="#{true or !controlSinCostoUsuarioBean.modoconsulta}"
                    reRender="panelGridControlSinCostoTab"
                    action="#{controlSinCostoUsuarioBean.consultarControles}"
                    id="idButt">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
            </a4j:commandLink>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="idButt" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </h:panelGrid>
          
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty controlSinCostoUsuarioBean.lstServicios}" cellspacing="0" width="100%"
                       id="tableContentTabsBucar" styleClass="tabContainer">
              
            <t:buffer into="#{table}">
            
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{controlSinCostoUsuarioBean.dtServicios}"
                           value="#{controlSinCostoUsuarioBean.lstControles}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtControl">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="C�digo"/>
                  </f:facet>
                  <h:outputText value="#{item.csvccodigo}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.csvcnombre}"/>
                </h:column>
                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Observaci�n Control"/>
                  </f:facet>
                  <h:outputText value="#{item.observaciones}"/>
                </h:column>
                
                <h:column rendered="#{!controlSinCostoUsuarioBean.modoconsulta}">
                  <f:facet name="header">
                    <h:outputText value="Eliminar"/>
                  </f:facet>
                  <h:commandLink id="aceptarControles" immediate="true"
                                 action="#{controlSinCostoUsuarioBean.eliminarControl}">
                    <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
                  </h:commandLink>
                </h:column>
                
              </h:dataTable>
              
            </t:buffer>
            
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  
                <t:dataScroller id="scroll_1" for="dtControl" fastStep="10" pageCountVar="pageCount"
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
        
        <s:fieldset legend="Datos Control" id="fieldControl" styleClass="fieldset" rendered="#{false}">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" 
                         id="panelDatosControl" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Fecha Proximo Control " styleClass="labelTextOblig"/>
              <h:outputText value="Hora  Proximo Control " styleClass="labelTextOblig"/>
              <h:panelGroup>
                <t:inputCalendar id="fechaControl" title="Formato: dd/mm/yyyy" disabled="#{controlSinCostoUsuarioBean.modoconsulta}" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true" value="#{controlSinCostoUsuarioBean.fechaControl}" popupTodayString="Hoy"
                                 popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario.gif"
                                 renderPopupButtonAsImage="true" align="top" required="true"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaControl" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHora" required="true" disabled="#{controlSinCostoUsuarioBean.modoconsulta}" value="#{controlSinCostoUsuarioBean.horaSelect}">
                    <f:selectItems value="#{controlSinCostoUsuarioBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHora" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutos" required="true" disabled="#{controlSinCostoUsuarioBean.modoconsulta}" value="#{controlSinCostoUsuarioBean.minutoSelect}">
                    <f:selectItems value="#{controlSinCostoUsuarioBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutos" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </h:panelGroup>
            </h:panelGrid>
          
        </s:fieldset>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionControlSinCostoMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgControlSinCostoMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
          <h:commandButton value="Generar Control Adicional" styleClass="boton_fieldset" disabled="#{false and controlSinCostoUsuarioBean.modoconsulta}" 
                             action="#{controlSinCostoUsuarioBean.generarControlAdicional}"/>
        </h:panelGrid>
             </h:panelGrid>
              <f:subview id="generarControl" rendered="#{controlSinCostoUsuarioBean.generoContol}">
          <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
          </f:verbatim>
        </f:subview>

    </t:panelTab>
            
    <t:panelTab id="panelTabBuscadorControles" label="Buscar Controles"
                rendered="#{controlSinCostoUsuarioBean.mostrarControles}">
      <a4j:region id="regionControles" renderRegionOnly="false">
        <a4j:status id="statusButton" for="regionControles">
          <f:facet name="start">
            <t:div id="chargingControles" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <s:fieldset legend="Controles" id="fieldSetControles" styleClass="fieldset">
          <jsp:include page="/pages/clinico/registro/buscadorControles.jsp" flush="true"/>
          <h:panelGrid id="panelGridControles0Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupControlesBotones1">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{controlSinCostoUsuarioBean.aceptarControles}"
                                 reRender="panelGridControlSinCostoTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
    </t:panelTab>
    
  </t:panelTabbedPane>
</h:panelGrid>