<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="ajax"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarMiPresupuestoGrupoBody.jsp -->
<a4j:form id="infoTipoServicioForm">
  <a4j:region id="bodyRegionTipoServicio">
    <a4j:status>
      <f:facet name="start">
        <t:div id="chargindTipoServicio" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarTipoServicio" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabRegistrarTipoServicio" label="Tipo de Servicio">
        <s:fieldset legend="Datos de la Clase" id="fieldSetInfoTipoServicio" styleClass="fieldset">
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelRegionTipoServicio" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Tipo de Servicio"/>
            <h:outputText value=" "/>
                    
                    
            <h:inputText id = "itDescripcion" value = "#{registrarTipoServicioBean.tipoServicio.htscdescripc}">
              <f:converter converterId="util.ConverterMayuscula"/>
            </h:inputText>
            
                <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itDescripcion" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                    
          </h:panelGrid>
        </s:fieldset>
        
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonTipoServico" 
          columnClasses="panelGridBotones">
          <h:commandButton value="Guardar" styleClass="btn btn btn-success" 
                             action="#{registrarTipoServicioBean.adicionarTipoServicio}"/>
        </h:panelGrid>
        
        



  <s:fieldset legend="Lista Tipo Servicio" id="fieldListaTipoPresupuesto" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridListaTipoServicio"
                       rendered="#{empty registrarTipoServicioBean.lstTipoServicio}">
            <h:outputText value="No existen Tipos de Servicio"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGruposTableTipoServicio" styleClass="tabContainer"
                       rendered="#{not empty registrarTipoServicioBean.lstTipoServicio}">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" binding="#{registrarTipoServicioBean.dtTipoServicio}"
                           cellspacing="0" value="#{registrarTipoServicioBean.lstTipoServicio}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtTipoServicio">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo"/>
                  </f:facet>
                  <h:outputText value="#{item.htsncodigo}"/>
                </h:column>
                
                   <h:column>
                  <f:facet name="header">
                    <h:outputText value="Descripción"/>
                  </f:facet>
                  <h:outputText value="#{item.htscdescripc}"/>
                </h:column>
                
                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estado"/>
                  </f:facet>
                  <h:outputText value="#{item.htscdescestado}"/>
                </h:column>
          
          
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cambiar Estado"/>
                  </f:facet>
                  <t:commandLink id="cambiarEstado"
                                 action="#{registrarTipoServicioBean.cambiarEstado}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/actualizar.gif"/>
                  </t:commandLink>
                </h:column>
           
            
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Adicionar Servicio"/>
                  </f:facet>
                  <t:commandLink id="asignarTipoServicio"
                                 action="#{registrarTipoServicioBean.adicionarServicio}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </t:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_TipoServicio" for="dtTipoServicio" fastStep="10"
                                pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator"
                                renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
        
     
        
      
        <h:panelGrid>
          <t:commandLink action="#{registrarTipoServicioBean.volver}" immediate="true">
            <t:graphicImage border="0" url="/comun/imagenes/volver.gif"/>
          </t:commandLink>
        </h:panelGrid>
      </t:panelTab>
    </t:panelTabbedPane>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>