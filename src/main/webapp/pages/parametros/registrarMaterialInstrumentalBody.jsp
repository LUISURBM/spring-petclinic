<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarRegistrarMaterialInstrumental.jsp -->
<a4j:form id="infoRegistrarMaterialInstrumentalForm">
  <a4j:region id="bodyRegionRegistrarMaterialInstrumental">
    <a4j:status for="bodyRegionRegistrarMaterialInstrumental">
      <f:facet name="start">
        <t:div id="chargindRegistrarMaterialInstrumental" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarRegistrarMaterialInstrumental" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
          <t:panelTab id="panelTabRegistrarRegistrarMaterialInstrumental" label="Registrar Material Instrumental">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Registrar Material Instrumental" id="fieldSetInfoRegistrarMaterialInstrumental" styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionRegistrarMaterialInstrumental"
                         rowClasses="labelText,labelTextInfo">
             
              <h:outputText value="Descripción Material" styleClass="labelTextOblig"/>
              <h:outputText/>
            
              <h:inputText id="itDescripcionRegistrarMaterialInstrumental"  style="width:500px" required="true"
              maxlength="50"  value="#{registrarMaterialInstrumentalBean.materialAdd.hmicdescripcio}"/>
                          
          
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDescripcionRegistrarMaterialInstrumental" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarRegistrarMaterialInstrumental" columnClasses="panelGridBotones">
              <h:commandButton value="Agregar" styleClass="btn btn btn-warning"
                                 action="#{registrarMaterialInstrumentalBean.agregarMaterial}"/>
            </h:panelGrid>
          </s:fieldset>
          
            <s:fieldset legend="Lista Material Instrumental" id="fieldListaRegistrarMaterialInstrumental" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridListaRegistrarMaterialInstrumental" 
            rendered="#{empty registrarMaterialInstrumentalBean.lstMaterial}">
              <h:outputText value="No existe Material Instrumental"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelRegistrarMaterialInstrumentalTable"
                         styleClass="tabContainer" rendered="#{not empty registrarMaterialInstrumentalBean.lstMaterial}">
             
                <h:dataTable var="item" border="0" cellpadding="0" 
                binding="#{registrarMaterialInstrumentalBean.dtMaterial}"
                             cellspacing="0" value="#{registrarMaterialInstrumentalBean.lstMaterial}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtMaterial">
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo Material"/>
                    </f:facet>
                    <h:outputText value="#{item.hmincodigo}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción Material"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:250px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hmicdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha de Registro"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hmidfecregistr}"/>
                    </h:panelGrid>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Grabado por"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hmicoperador}"/>
                    </h:panelGrid>
                  </h:column>                                
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Editar"/>
                    </f:facet>
                     <a4j:region renderRegionOnly="false">
                    <t:commandLink id="editarRegistrarMaterialInstrumental" immediate="true"
                            action="#{registrarMaterialInstrumentalBean.editarMaterial}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </t:commandLink>
                    </a4j:region>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>      
                    <a4j:region renderRegionOnly="false">
                        <t:commandButton id="eliminarRegistrarMaterialInstrumental"  
                            value="Eliminar"  immediate="true" styleClass="btn btn bnt-danger"
                        action="#{registrarMaterialInstrumentalBean.eliminarMaterial}"
                                     onclick="return confirmar('Realmente desea eliminar el Material Instrumental?')" image="/comun/imagenes/eliminarObj.gif">                      
                        </t:commandButton>               
                        </a4j:region>
                  </h:column>
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hmicestado}"/>
                    </h:panelGrid>
                  </h:column>
                </h:dataTable>
             
          
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                
                  <t:dataScroller id="scroll_RegistrarMaterialInstrumental" for="dtMaterial" fastStep="10" pageCountVar="pageCount"
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
              
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          
          
          
        </a4j:region>
        <h:panelGrid>
          <t:commandLink action="#{registrarMaterialInstrumentalBean.volver}" immediate="true">
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