<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
<a4j:form id="reporteActividadesEducativasForm">
  <a4j:region id="bodyRegionReporteActividadesEducativas">
    <a4j:status id="statusButton" for="bodyRegionReporteActividadesEducativas">
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
     <a4j:outputPanel id="ajaxRegionRegistrarEpicrisisMsg" ajaxRendered="true">
            <t:messages id="msgInformationRegistrarEpicrisisMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
    <h:panelGrid columns="1" border="0" id="tableParamCorreosTabs" cellpadding="0" cellspacing="0" width="100%" 
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneReporteActividadesEducativas" selectedIndex="#{parametrizacionCorreosBean.selectedIndex}" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabReporteActividadesEducativas"  disabled="#{parametrizacionCorreosBean.renderBuscador}" label="Gesti�n de Correos">
          <h:panelGrid columns="1" border="0" cellpadding="0"  cellspacing="0" width="100%"
                       id="panelGridReporteActividadesEducativas">
            <s:fieldset legend="Agregar Correo" id="fieldCorreo" styleClass="fieldset">
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="70%"
                           id="panelContrato" rowClasses="labelText,labelTextInfo">
                             <h:outputText value="N�mero Contrato" styleClass="labelTextOblig"/>
                           </h:panelGrid>
             <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                                         columnClasses="labelTextInfo">
                                <a4j:commandLink action="#{parametrizacionCorreosBean.mostrarBuscadorContratos}"
                                                 reRender="tableParamCorreosTabs"   
                                                 immediate="true" >
                                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                                </a4j:commandLink>
                                <h:inputText id="idtipopruebasRapidas" maxlength="15" style="width:80px"
                                             immediate="true" value="#{parametrizacionCorreosBean.correo.hcncontrato}"
                                           binding="#{parametrizacionCorreosBean.IDescripcion}" 
                                           valueChangeListener="#{parametrizacionCorreosBean.setDescriCorreo}"
                                             onkeydown="return blockEnter(event);">
                                    <a4j:support id="supportNumUsuariopruebasRapidas" event="onchange"
                                                 ignoreDupResponses="true" immediate="true"
                                                    reRender="tableParamCorreosTabs"
                                                       action="#{parametrizacionCorreosBean.changeDescripcion}"
                                    >
                                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                                    </a4j:support>
                                </h:inputText>
                                <a4j:outputPanel ajaxRendered="true">
                                    <t:message for="idtipopruebasRapidas" styleClass="errorMessage"/>
                                </a4j:outputPanel>
                                   <h:panelGroup>
                    <h:outputText id="txtDescripcion" value="#{parametrizacionCorreosBean.descripcion}" />
                      <a4j:outputPanel ajaxRendered="true">
                      <t:message for="txtDescripcion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                                
                            </h:panelGrid>
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="70%"
                           id="panelDatosReporteActividadesEducativas" rowClasses="labelText,labelTextInfo">
              
               
                <h:outputText value="Correo Electr�nico" styleClass="labelTextOblig"/>
                <h:outputText value="Documentos" styleClass="labelTextOblig"/>
                <h:outputText value="Estado" styleClass="labelTextOblig"/>
               
                 
                      <h:panelGroup>
                  <h:inputText id="txtCorreo" value="#{parametrizacionCorreosBean.correo.hcccorreo}" required="true" maxlength="150"/>
                   <a4j:outputPanel ajaxRendered="true">
                      <t:message for="txtCorreo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                      <h:panelGroup>
                  <h:selectOneMenu id="txtDocumentos" value="#{parametrizacionCorreosBean.correo.hccdocum}" required="true" >
                    <f:selectItems value="#{parametrizacionCorreosBean.latDocumentos}"/>
                  </h:selectOneMenu>
                   <a4j:outputPanel ajaxRendered="true">
                      <t:message for="txtDocumentos" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
                      <h:panelGroup>
                   <h:selectOneMenu id="lstEstados" value="#{parametrizacionCorreosBean.correo.hccestado}" required="true" >
                    <f:selectItems value="#{parametrizacionCorreosBean.lstEstados}"/>
                  </h:selectOneMenu>
                   <a4j:outputPanel ajaxRendered="true">
                      <t:message for="lstEstados" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    </h:panelGroup>
            
          
                 <a4j:commandLink id="agregarAnestesiologo"  action="#{parametrizacionCorreosBean.guardarCorreo}"
                                 value="Agregar" reRender="tableCorreos,fieldCorreo">
                  <t:graphicImage border="0" url="/comun/imagenes/fnd_boton_agregar.gif" alt="Agregar"/>
                </a4j:commandLink>
              
              
           
              </h:panelGrid>     
            </s:fieldset>
            <s:fieldset legend ="Lista de Correos" styleClass="fieldset" >
                  <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableCorreos" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item"  border="1" cellpadding="0" cellspacing="0"
               styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                binding="#{parametrizacionCorreosBean.dtcorreo}"
                           rendered="#{not empty parametrizacionCorreosBean.lstcorreo}"
                           value="#{parametrizacionCorreosBean.lstcorreo}" rows="5"
                           id="dtAnestesiologo">
  
             
               <h:column>
                  <f:facet name="header">
                    <h:outputText value="N�mero Contrato"/>
                  </f:facet>
                  <h:outputText value="#{item.hcncontrato}"/>
                  </h:column>

              <h:column>              
                  <f:facet name="header">
                    <h:outputText value="Descripci�n"/>                   
                  </f:facet>
                    <h:outputText value="#{item.descripcion}"/>
                  </h:column>
                 
            <h:column>
                  <f:facet name="header">
                    <h:outputText value="Correo Electr�nico"/>
                  </f:facet>
                   <h:outputText value="#{item.hcccorreo}"/>
                   </h:column>
                    <h:column>
                  <f:facet name="header">
                    <h:outputText value="Documentos"/>
                  </f:facet>                    
                        <h:outputText value="#{item.documento}" />
                   </h:column>
                     <h:column>              
                  <f:facet name="header">
                    <h:outputText value="Estado"/>                   
                  </f:facet>
                     <h:outputText id="estado" value="#{item.estado}"/>
                  </h:column>
                         
        <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cambiar Estado"/>
                  </f:facet>
                  <h:panelGrid columns="2" >
                  <h:commandButton value="Activo" immediate="true"  styleClass="btn btn btn-success"                             
                                   action="#{parametrizacionCorreosBean.cambiarEstadoCorreoActivo}"
                                   >
                  </h:commandButton>
                   <h:commandButton value="Inactivo" immediate="true"   styleClass="btn btn btn-danger"                             
                                   action="#{parametrizacionCorreosBean.cambiarEstadoCorreoInactivo}"
                                   >
                  </h:commandButton>
                  </h:panelGrid>
                  </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll" for="dtAnestesiologo" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage url="/comun/imagenes/primero.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage url="/comun/imagenes/ultimo.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage url="/comun/imagenes/anterior.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage url="/comun/imagenes/siguiente.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage url="/comun/imagenes/adelante.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage url="/comun/imagenes/atras.gif" alt="" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
          </a4j:region>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
         <t:panelTab id="panelpruebasRapidas" label="Buscar Contratos"
                            rendered="#{parametrizacionCorreosBean.renderBuscador}">
                    <a4j:region id="regionBuscadorUsupruebasRapidas" renderRegionOnly="false">
                        <a4j:status for="regionBuscadorUsupruebasRapidas">
                            <f:facet name="start">
                                <t:div id="chargingBuscUsuMedico" styleClass="loading">
                                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                                        <h:outputText value="Procesando..."/>
                                        <h:outputText value="Por favor espere."/>
                                    </h:panelGrid>
                                </t:div>
                            </f:facet>
                            <f:facet name="stop"/>
                        </a4j:status>
                        <jsp:include page="/pages/clinico/comunes/buscador/buscadorContratos.jsp" flush="true"/>
                        <h:panelGrid id="panelGridBusUsuaBotpruebasRapidas" width="100%"
                                     columnClasses="columnaBotonesCentrados" dir="RTL">
                            <t:htmlTag value="br"/>
                            <h:panelGroup id="panelGroupBusUsuBotpruebasRapidas">
                               <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{parametrizacionCorreosBean.aceptarContrato}"
                                     reRender="tableParamCorreosTabs">
                            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                           </a4j:commandButton>
                            </h:panelGroup>
                        </h:panelGrid>
                    </a4j:region>
                </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>