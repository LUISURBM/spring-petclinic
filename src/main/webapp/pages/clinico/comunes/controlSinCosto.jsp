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
    <t:panelTab id="panelTabControlSinCosto" label="Control"
                rendered="#{not controlSinCostoUsuarioBean.mostrarControles}">
        
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControl"
                   styleClass="tabContainer">
        <s:fieldset legend="Control" id="fieldControlAdi" styleClass="fieldset">
            
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelControlAdi"
                    rendered="#{empty controlSinCostoUsuarioBean.lstControles}"
                    rowClasses="labelText,labelTextInfo">
            <h:outputText value="Controles Propuestos" styleClass="labelText"/>
            <h:outputText/>
            
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2"
                    rendered="false" >
                <h:outputText value="Buscar Servicios" styleClass="labelText"/>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="0%"
                    rowClasses="labelText,labelTextInfo">

                    <a4j:commandLink value="" immediate="true" title="Seleccionar Servicios"
                            rendered="#{true or !controlSinCostoUsuarioBean.modoconsulta}"
                            reRender="panelGridControlSinCostoTab"
                            action="#{controlSinCostoUsuarioBean.consultarControles}"
                            id="idButt">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
                    </a4j:commandLink>
                    
                    <h:inputText id="itDiagPrin" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                            value="#{controlSinCostoUsuarioBean.controlServicio.csvccodigo}"
                            valueChangeListener="#{controlSinCostoUsuarioBean.setCsvccodigo}"
                            style="width:50px"
                            maxlength="12">
                        <a4j:support id="supportitDiagPrin" event="onchange"
                                action="#{controlSinCostoUsuarioBean.findControlServicio}"
                                reRender="panelBotonConsulta">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                    </h:inputText>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itDiagPrin" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                </h:panelGrid>
            </h:panelGrid>
            

            <s:fieldset legend="Seleccionar Control" id="fieldSeleccionarControl" styleClass="fieldset">
              <a4j:region id="regionSeleccionarControl" renderRegionOnly="false">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" 
                id="panelDatosSeleccionarControl"  rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Servicio de Control" styleClass="labelTextOblig"/>
                  <h:outputText value=" "/>
                  <h:outputText value="Descripci�n " styleClass="labelTextOblig"/>
                  <h:outputText value=" "/>
                  <h:selectOneMenu id="mnuServicioControl" required="true"  value="#{controlSinCostoUsuarioBean.codigoControlServicio}" onkeydown="return blockEnter(event);">

                    <f:selectItems value="#{controlSinCostoUsuarioBean.lstServiciosConsulta99}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuServicioControl" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:inputTextarea id="inputDescripcionConsulta" onkeydown="return blockEnter(event);"
                    required="true" value="#{controlSinCostoUsuarioBean.observaciones}" style="width:350px"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputDescripcionConsulta" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarInterconsulta" columnClasses="panelGridBotones">
                  <h:panelGroup>
                    <t:htmlTag value="br"/>
                    <a4j:commandButton value="Agregar" styleClass="btn btn btn-success" action="#{controlSinCostoUsuarioBean.aceptarControlesServicio}"
                                       reRender="panelGridControlSinCostoTab"/>
                  </h:panelGroup>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
            
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta">
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelNombreControlServicio"
                             rendered= "false">
                    <h:outputText value="Descripci�n Control" styleClass="labelText"/>
                    <h:outputText value="#{controlSinCostoUsuarioBean.controlServicio.csvcnombre}" styleClass="buscador"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelObservacionControlServicio"
                             rendered= "false" >
                    <h:outputText value="Observaci�n Control" styleClass="labelTextOblig"/>
                    <h:inputText value="#{controlSinCostoUsuarioBean.controlServicio.observaciones}" required="true" maxlength="40"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelAgregarControlServicio"
                rendered="false">
                    <h:outputText value="Agregar" styleClass="labelText"/>
                    <a4j:commandLink styleClass="btn btn btn-success"
                                 action="#{controlSinCostoUsuarioBean.agregarControlServicio}"
                                 reRender="panelGridControlSinCostoTab">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/adicionar.gif"/>
                    </a4j:commandLink>
                </h:panelGrid>
                <a4j:outputPanel ajaxRendered="true">
                    <t:message for="idButt" styleClass="errorMessage"/>
                </a4j:outputPanel>              
            </h:panelGrid>
            
          </h:panelGrid>
          
          <h:panelGrid columns="1" border="0" cellpadding="0"
                       rendered="#{not empty controlSinCostoUsuarioBean.lstControles}" cellspacing="0" width="100%"
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
        
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionControlSinCostoMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgControlSinCostoMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
            <a4j:region renderRegionOnly="false">
                <a4j:commandButton value="Generar Control"
                    reRender="panelGridControl, panelBotonBotonesControl" styleClass="btn btn btn-success" 
                                 action="#{controlSinCostoUsuarioBean.printControlAdicional}"/>
            </a4j:region>
            <f:subview id="generarControl" rendered="#{controlSinCostoUsuarioBean.generoContol}">
                <f:verbatim>
                    <script type="text/javascript" language="JavaScript">
                        window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                    </script>
                </f:verbatim>
            </f:subview>
        </h:panelGrid>
        
    </h:panelGrid>
    


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
                                 action="#{controlSinCostoUsuarioBean.aceptarControlesServicio}"
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