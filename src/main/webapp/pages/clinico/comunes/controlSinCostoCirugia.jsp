<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControlSinCostoTab" styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneControlSinCosto" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabControlSinCosto" label="Control">
    
    
    
       <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Controles Actuales" id="fieldControlesLista"
                    rendered="#{not empty controlSinCostoUsuarioBean.lstControlesConsulta}" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelControlTable"
                       rendered="#{controlSinCostoUsuarioBean.renderControl}" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0"
                           binding="#{controlSinCostoUsuarioBean.dtControl}" cellspacing="0"
                           value="#{controlSinCostoUsuarioBean.lstControlesConsulta}" rows="20"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtControles">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Fecha Reg."/>
                  </f:facet>
                    <h:outputText value="#{item.hcpdfecregistr}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Documento"/>
                  </f:facet>
                    <h:outputText value="#{item.tipoDocumento}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="N�mero Documento"/>
                  </f:facet>
                    <h:outputText value="#{item.hcpnnumdoc}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="C�digo"/>
                  </f:facet>
                    <h:outputText value="#{item.hcpcservicio}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"></h:outputText>
                  </f:facet>
                    <h:outputText value="#{item.nombreServicio}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Control en (d�as)"></h:outputText>
                  </f:facet>
                    <h:outputText value="#{item.hcpndiasate}" />
                </h:column>
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Seleccionar"/>
                  </f:facet>
                   <a4j:commandLink id="itemUsar"
                    action="#{controlSinCostoUsuarioBean.seleccionarRegistro}" reRender="dtControles,fieldControl">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/Select.png"/>
                    </a4j:commandLink>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itemUsar" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtControles" fastStep="10" pageCountVar="pageCount"
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
      </a4j:region>
 
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridControl"
       rendered="#{controlSinCostoUsuarioBean.renderControl}">
        <s:fieldset legend="Fecha Control" id="fieldControl" styleClass="fieldset">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosControl" rowClasses="labelText,labelTextInfo">
           
            <h:outputText value="Control de " styleClass="labelTextOblig"/>
            <h:outputText value="Control en (D�as) " styleClass="labelTextOblig"/>
            <h:outputText value="Observacion " styleClass="labelTextOblig"/>
            
            <h:panelGroup>
                <h:selectOneMenu id = "mnuServicioControl"  required="true" style="width:400px"
                    value = "#{controlSinCostoUsuarioBean.control.hcpcservicio}">
                   <f:selectItems value = "#{controlSinCostoUsuarioBean.lstServicios}"/>          
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuServicioControl" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGroup>
            
            <h:panelGroup>
                <h:inputText id = "itNumeroDias" required="true"
                    value = "#{controlSinCostoUsuarioBean.control.hcpndiasate}" maxlength="3" style="width:50px"/>
                <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNumeroDias" styleClass="errorMessage"/>
                </a4j:outputPanel>
            </h:panelGroup>

            <h:panelGroup>
                <h:inputTextarea id="itObserv" style="width:400px"
                               value="#{controlSinCostoUsuarioBean.control.hcpcobserv}"/>
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
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl" columnClasses="panelGridBotones">
          <a4j:commandButton value="Inicializar Control" styleClass="btn btn btn-success"  
                             reRender="panelGridControlSinCostoTab"
                             action="#{controlSinCostoUsuarioBean.limpiarControl}"/>
          <a4j:commandButton value="Generar Control" styleClass="btn btn btn-success"  
                             reRender="panelGridControlSinCostoTab"
                             action="#{controlSinCostoUsuarioBean.generarControl}"/>
        </h:panelGrid>
      </h:panelGrid>
      
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMensajeControl"
       rendered="#{!controlSinCostoUsuarioBean.renderControl}">
        <h:outputText value = "Para esta consulta no se puede generar controles sin costo" styleClass="errorMessage"/>
       
       </h:panelGrid>
       <f:subview id="generarControl"
               rendered="#{controlSinCostoUsuarioBean.generoContol}">
      <f:verbatim>
        <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
        </f:subview>
    </t:panelTab>
    
  </t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>