<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="regCuestionarioTemaForm">
  <a4j:region id="bodyRegionCuestionarioTema">
    <a4j:status for="bodyRegionCuestionarioTema">
      <f:facet name="start">
        <t:div id="chargindCuestionarioTema" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarCuestionarioTema" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabRegistrarCuestionarioTema" label="Registrar CuestionarioTema">
        <a4j:region renderRegionOnly="false">
                 
          <s:fieldset legend="Lista Cuestionario Temas" id="fieldListaCuestionarioTema" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridListaCuestionarioTemas" 
          rendered="#{empty cuestionarioTemaBean.lstTema}">
            <h:outputText value="No existen Grupos"/>
          </h:panelGrid>
          <a4j:region renderRegionOnly="false">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCuestionarioTemasTable"
                         styleClass="tabContainer" rendered="#{not empty cuestionarioTemaBean.lstTema}">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" 
                            binding="#{cuestionarioTemaBean.dtTema}" cellspacing="0"
                             value="#{cuestionarioTemaBean.lstTema}" rows="10" styleClass="standard_table"
                             rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtTema">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo CuestionarioTema"/>
                    </f:facet>
                    <h:outputText value="#{item.hptncodigo}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripci?n CuestionarioTema"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:250px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hptcdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Registro"/>
                    </f:facet>
                      <h:panelGrid rendered="#{!item.renderTema}">
                         <h:graphicImage url="/comun/imagenes/Delete.png"/>
                      </h:panelGrid>  
                      <h:panelGrid rendered="#{item.renderTema}">
                         <h:graphicImage url="/comun/imagenes/Select.png"/>
                      </h:panelGrid> 
                      
             </h:column>
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Indicadores"/>
                    </f:facet>
                    <t:commandLink id="verSubGrupo" action="#{cuestionarioTemaBean.irIndicadores}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/fnd_boton_agregar.gif"/>
                    </t:commandLink>
                  </h:column>
            
               
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Grupo" for="dtTema" fastStep="10" pageCountVar="pageCount"
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
          </a4j:region>
        </s:fieldset>
          
          
        </a4j:region>
   
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