<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="AdministrarConsentimientoForm">
  <a4j:region id="bodyRegionAdministrarConsentimiento">
    <a4j:status  id = "statusButton" for="bodyRegionAdministrarConsentimiento">
      <f:facet name="start">
        <t:div id="charginAdministrarConsentimiento" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAdministrarConsentimientosTab" styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneAdministrarConsentimientos" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAdministrarConsentimientos" label=" Gestión consentimientos informados">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAdministrarConsentimiento">
        <s:fieldset legend="Agregar  Consentimiento " id="fieldSetOrigen" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelDatosOrigen" rowClasses="labelText,labelTextInfo">
              <h:outputText id ="codigoIsolucion" value = "Código Isolución"  styleClass="labelTextOblig"/>          
              <h:outputText/>
               <h:outputText id ="nombreConsentimiento" value = "Nombre del consentimiento"  styleClass="labelTextOblig"/>
               <h:outputText/>
               <h:outputText id ="estado" value = "Estado"  styleClass="labelTextOblig"/>
                <h:outputText/>
              <h:inputText id ="itCodigoIsolucion" required="true"
                  value = "#{consentimientoInformadoBean.consentimiento.hpciccodigo}" style="width:300px"/>           
              <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCodigoIsolucion" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
               <h:inputText id ="itNombreConsen" required="true"
                  value = "#{consentimientoInformadoBean.consentimiento.hpcicnombre}" style="width:300px"/>           
              <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreConsen" styleClass="errorMessage"/>
              </a4j:outputPanel>
              
               <h:selectOneMenu id="menuEstado" onkeydown="return blockEnter(event);"
                                     value="#{consentimientoInformadoBean.consentimiento.hpcicestado}">
                        <f:selectItems value="#{consentimientoInformadoBean.lstEstado}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="menuEstado" styleClass="errorMessage"/>
                    </a4j:outputPanel>
              
          </h:panelGrid>
          
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarConsentimiento" columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar" styleClass="boton_fieldset"
                                   action="#{consentimientoInformadoBean.agregarConsentimiento}"
                                   reRender="panelGridAdministrarConsentimientosTab"/>
              </h:panelGroup>
            </h:panelGrid>
        </s:fieldset>
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Lista de Consentimientos" id="fieldConsentimientos" styleClass="fieldset">
        <h:panelGrid columns="1" id="panelGridNoConsentimientosSeleccionados" 
             rendered="#{empty consentimientoInformadoBean.lstConsentimientos}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
      
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelConsentimientosTable" styleClass="tabContainer" 
              rendered="#{not empty consentimientoInformadoBean.lstConsentimientos}">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="0" cellpadding="0" 
                               binding="#{consentimientoInformadoBean.dtConsentimiento}"  cellspacing="0" 
                               value="#{consentimientoInformadoBean.lstConsentimientos}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" 
                               footerClass="paginacion" id="dtConsentimiento">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Código Isolución"/>
                      </f:facet>
                      <h:outputText value="#{item.hpciccodigo}"/>
                    </h:column>
                    
                              
                    
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre del consentimiento"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:300px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hpcicnombre}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  <h:column>
                      <f:facet name="header">
                        <h:outputText value="Estado"/>
                      </f:facet>
                     <h:panelGrid>
                        <h:outputText value="#{item.hpcicestado}"/>
                      </h:panelGrid>
                    </h:column>
                   
                            <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cambiar Estado"/>
                  </f:facet>
                  <h:panelGrid columns="2" >
                  <h:commandButton value="Activo" immediate="true"  styleClass="btn btn btn-success"                             
                                  action="#{consentimientoInformadoBean.activarConsentimiento}"
                                   >
                  </h:commandButton>
                   <h:commandButton value="Inactivo" immediate="true"   styleClass="btn btn btn-danger"                          
                                   action="#{consentimientoInformadoBean.inactivarConsentimiento}"
                                   >
                  </h:commandButton>
                  </h:panelGrid>
                  </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_Consentimientos" for="dtConsentimiento" fastStep="10" 
                          pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                          immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" 
                          renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
          <a4j:outputPanel id="ajaxRegionAdministrarConsentimientoMsg" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAdministrarConsentimientoMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                        warnClass="advertencia"/>
            <t:htmlTag value="br"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </a4j:region>
      </h:panelGrid>
    </t:panelTab>
       <h:commandLink action="#{consentimientoInformadoBean.volverInicio}" immediate="true">
          <t:graphicImage alt=""  border="0" url="/comun/imagenes/volver.gif" align="Volver"/>
        </h:commandLink>     
  </t:panelTabbedPane>
  </h:panelGrid>
  </a4j:region>
</a4j:form>