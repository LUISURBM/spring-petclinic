<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarRegistrarPaqueteInstrumental.jsp -->
<a4j:form id="infoRegistrarPaqueteInstrumentalForm">
  <a4j:region id="bodyRegionRegistrarPaqueteInstrumental">
    <a4j:status for="bodyRegionRegistrarPaqueteInstrumental">
      <f:facet name="start">
        <t:div id="chargindRegistrarPaqueteInstrumental" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarRegistrarPaqueteInstrumental" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
          <t:panelTab id="panelTabRegistrarRegistrarPaqueteInstrumental" label="Registrar Paquete Instrumental">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Registrar Paquete Instrumental" id="fieldSetInfoRegistrarPaqueteInstrumental" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionRegistrarPaqueteInstrumental"
                         rowClasses="labelText,labelTextInfo">
             
              <h:outputText value="Descripción Paquete" styleClass="labelTextOblig"/>
              <h:outputText/>
            
              <h:inputText id="itDescripcionRegistrarPaqueteInstrumental"  style="width:500px" required="true"
              maxlength="50"  value="#{registrarPaqueteInstrumentalBean.paqueteAdd.hpecdescripcio}"/>
                          
          
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDescripcionRegistrarPaqueteInstrumental" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarRegistrarPaqueteInstrumental" columnClasses="panelGridBotones">
              <h:commandButton value="Agregar" styleClass="btn btn btn-success"
                                 action="#{registrarPaqueteInstrumentalBean.agregarPaquete}"/>
            </h:panelGrid>
          </s:fieldset>
          
            <s:fieldset legend="Lista Paquete Instrumental" id="fieldListaRegistrarPaqueteInstrumental" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridListaRegistrarPaqueteInstrumental" 
            rendered="#{empty registrarPaqueteInstrumentalBean.lstPaquete}">
              <h:outputText value="No existe Paquete Instrumental"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelRegistrarPaqueteInstrumentalTable"
                         styleClass="tabContainer" rendered="#{not empty registrarPaqueteInstrumentalBean.lstPaquete}">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" 
                binding="#{registrarPaqueteInstrumentalBean.dtPaquete}"
                             cellspacing="0" value="#{registrarPaqueteInstrumentalBean.lstPaquete}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtPaquete">
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo Paquete"/>
                    </f:facet>
                    <h:outputText value="#{item.hpencodigo}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción Paquete"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:250px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hpecdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha de Registro"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hpedfecregistr}"/>
                    </h:panelGrid>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Grabado por"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hpecoperador}"/>
                    </h:panelGrid>
                  </h:column>                                
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Editar"/>
                    </f:facet>
                     <a4j:region renderRegionOnly="false">
                    <t:commandLink id="editarRegistrarPaqueteInstrumental" immediate="true"
                            action="#{registrarPaqueteInstrumentalBean.editarPaquete}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </t:commandLink>
                    </a4j:region>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>      
                    <a4j:region renderRegionOnly="false">
                        <t:commandButton id="eliminarRegistrarPaqueteInstrumental"  
                            value="Eliminar"  immediate="true"
                        action="#{registrarPaqueteInstrumentalBean.eliminarPaquete}"
                                     onclick="return confirmar('Realmente desea eliminar el Paquete Instrumental?')" image="/comun/imagenes/eliminarObj.gif">                      
                        </t:commandButton>               
                        </a4j:region>
                  </h:column>
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hpecestado}"/>
                    </h:panelGrid>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_RegistrarPaqueteInstrumental" for="dtPaquete" fastStep="10" pageCountVar="pageCount"
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
          <t:commandLink action="#{registrarPaqueteInstrumentalBean.volver}" immediate="true">
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