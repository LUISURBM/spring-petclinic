<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="consultaFacturaCitologiaForm">
  <a4j:region id="bodyRegionReporteConsultaFacturaCitologia">
    <a4j:status id="statusButton" for="bodyRegionReporteConsultaFacturaCitologia">
      <f:facet name="start">
        <t:div id="charginConsultaFacturaCitologia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
      id="panelGridConsultaFacturaCitologiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneConsultaFacturaCitologia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabConsultaFacturaCitologia" label="Lectura Citologia">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridConsultaFacturaCitologia">
            <s:fieldset legend="Consultar Factura Citologia" id="fieldConsultaFacturaCitologia" styleClass="fieldset">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosConsultaFacturaCitologia" rowClasses="labelText,labelTextInfo">
                           
                 <h:outputText value = "Tipo Documento"/>
                 <h:outputText value = ""/>
                 <h:outputText value = "Número Documento"/>
                 <h:outputText value = ""/>
                 
                 <h:selectOneMenu id = "mnuTipoDocumento" value = "#{consultarFacturaCitologia.tipoSelect}">
                  <f:selectItems value = "#{consultarFacturaCitologia.lstTipoDocumento}"/>
                 </h:selectOneMenu>
                 
                    <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuTipoDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
                   
                   <h:inputText id= "itNumeroDocumento"  maxlength="9" style="width:150px"
                        value = "#{consultarFacturaCitologia.numeroDocumento}"/>
                        
             <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
            </a4j:outputPanel>
               
              </h:panelGrid>
            </s:fieldset>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionConsultaFacturaCitologia" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfConsultaFacturaCitologia" showSummary="false" errorClass="error" globalOnly="true"
                            layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                            warnClass="advertencia"/>
                <t:htmlTag value="br"/>
              </a4j:outputPanel>
            </h:panelGroup>
            
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
             id="panelBotonConsultaFacturaCitologia" columnClasses="panelGridBotones">
              <h:commandButton value="Buscar" styleClass="boton_fieldset" 
              action="#{consultarFacturaCitologia.buscarCitologias}"/>
                <a4j:support event="onclick" status="statusButton"/>
            </h:panelGrid>
          </h:panelGrid>
          
        <s:fieldset legend="Lista Citologias" id="fieldListaCitologia" styleClass="fieldset">

        <h:panelGrid columns="1" id="panelGridCitologias" rendered="#{empty consultarFacturaCitologia.lstFactura}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                         rendered="#{not empty consultarFacturaCitologia.lstFactura}"  styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                             binding="#{consultarFacturaCitologia.dtFacturasCitologia}" 
                             value="#{consultarFacturaCitologia.lstFactura}"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" rows="20" id="idDtConsultas">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Identificación"/>
                    </f:facet>
                    <h:outputText value="#{item.ccoctipide} #{item.ccoanumide}"/>
                  </h:column>
                  
                     <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocprinom} #{item.ccocsegnom} #{item.ccocpriape} #{item.ccocsegape}"/>
                  </h:column>
                  
                  
                     <h:column>
                    <f:facet name="header">
                      <h:outputText value="Servicio"/>
                    </f:facet>
                    <h:outputText value="#{item.ccocservic.csvcnombre}"/>
                  </h:column>
                  
                  
                <h:column>
                    <f:facet name="header">
                      <h:outputText value="Tipo Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.ccontipdoc.ctdcdescri}"/>
                  </h:column>
                  
                  
                     <h:column>
                    <f:facet name="header">
                      <h:outputText value="Número Documento"/>
                    </f:facet>
                    <h:outputText value="#{item.cconnumdoc}"/>
                  </h:column>
                  
                <h:column>
                    <f:facet name="header">
                      <h:outputText value="Atender"/>
                    </f:facet>
                    <h:commandLink id="atender" action="#{consultarFacturaCitologia.atenderUsuario}">
                      <t:graphicImage alt=""  border="0" url="/comun/imagenes/editar.gif"/>
                    </h:commandLink>
                  </h:column>

                </h:dataTable>
              </t:buffer>
              
             <t:buffer into="#{tableScroller}">
                                        <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                            <t:dataScroller id="scroll_1" for="idDtConsultas" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                                            immediate="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                                            <t:dataScroller id="scroll_2" for="idDtConsultas" immediate="true" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                                            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                                                <h:outputFormat value="Registros : Total {0}, mostrados {1} del {2} al {3}  Pagina {4} / {5}" styleClass="standard">
                                                    <f:param value="#{rowsCount}"/>
                                                    <f:param value="#{displayedRowsCountVar}"/>
                                                    <f:param value="#{firstRowIndex}"/>
                                                    <f:param value="#{lastRowIndex}"/>
                                                    <f:param value="#{pageIndex}"/>
                                                    <f:param value="#{pageCount}"/>
                                                </h:outputFormat>
                                            </t:dataScroller>
                                        </h:panelGrid>
                                    </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          
        </t:panelTab>
        <h:commandLink action="" immediate="true">
          <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>