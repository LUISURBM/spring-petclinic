<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarIndicador.jsp -->
<a4j:form id="infoIndicadorForm">
  <a4j:region id="bodyRegionIndicador">
    <a4j:status for="bodyRegionIndicador">
      <f:facet name="start">
        <t:div id="chargindIndicador" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarIndicador" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
          <t:panelTab id="panelTabRegistrarIndicador" label="Indicadores">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Registrar Indicador" id="fieldSetInfoIndicador" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionIndicador"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tema" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText value="Descripción Indicador" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText id="mnuTema"  
                        value="#{registrarIndicadorBean.temaObject.hptcdescripcio}">
                </h:outputText>
             <h:outputText/>
              <h:inputTextarea id="itDescripcionIndicador" style="width:400px;height:50px" 
                            value="#{registrarIndicadorBean.indicadorAdd.hpicdescripcio}">
                       <f:validateLength maximum="200"/>     
                </h:inputTextarea>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDescripcionIndicador" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarIndicador" columnClasses="panelGridBotones">
              <h:commandButton value="Agregar" styleClass="boton"
                                 action="#{registrarIndicadorBean.agregarIndicador}"/>
            </h:panelGrid>
          </s:fieldset>
          
              <s:fieldset legend="Lista Indicadores" id="fieldListaIndicadores" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridListaIndicadores" 
            rendered="#{empty registrarIndicadorBean.lstIndicador}">
              <h:outputText value="No existen Indicadores"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelIndicadoresTable"
                         styleClass="tabContainer" rendered="#{not empty registrarIndicadorBean.lstIndicador}">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" 
                binding="#{registrarIndicadorBean.dtIndicador}"
                             cellspacing="0" value="#{registrarIndicadorBean.lstIndicador}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtIndicador">
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo Indicador"/>
                    </f:facet>
                    <h:outputText value="#{item.id.hpincodigo}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción Indicador"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:250px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hpicdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha de Registro"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hpidfecregistr}"/>
                    </h:panelGrid>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Grabado por"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hpicoperador}"/>
                    </h:panelGrid>
                  </h:column>
                  
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Preguntas"/>
                    </f:facet>
                    <t:commandLink id="editarPregunta" action="#{registrarIndicadorBean.registrarPregunta}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                    </t:commandLink>
                  </h:column>
                  
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Editar"/>
                    </f:facet>
                    <t:commandLink id="editarIndicador" action="#{registrarIndicadorBean.editarIndicador}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </t:commandLink>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>                    
                        <t:commandButton id="eliminarIndicador"  value="Eliminar" 
                        action="#{registrarIndicadorBean.eliminarIndicador}"
                                     onclick="return confirmar('Realmente desea eliminar el Indicador?')" image="/comun/imagenes/eliminarObj.gif">                      
                        </t:commandButton>                    
                  </h:column>
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hpicestado}"/>
                    </h:panelGrid>
                  </h:column>
                  
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Indicador" for="dtIndicador" fastStep="10" pageCountVar="pageCount"
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
        <h:panelGrid>
          <t:commandLink action="#{registrarIndicadorBean.volverTemas}" immediate="true">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
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