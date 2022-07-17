<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarPregunta.jsp -->
<a4j:form id="infoPreguntaForm">
  <a4j:region id="bodyRegionPregunta">
    <a4j:status for="bodyRegionPregunta">
      <f:facet name="start">
        <t:div id="chargindPregunta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarPregunta" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
          <t:panelTab id="panelTabRegistrarPregunta" label="Registrar Pregunta">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Registrar Pregunta" id="fieldSetInfoPregunta" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionPregunta"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Indicador" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText value="Descripción Pregunta" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText id="mnuTema"  
                        value="#{registrarPreguntaBean.indicadorObject.hpicdescripcio}">
                </h:outputText>
             <h:outputText/>
              <h:inputTextarea id="itDescripcionPregunta"  style="width:400px;height:50px" 
                            value="#{registrarPreguntaBean.preguntaAdd.hppcdescripcio}">
                           <f:validateLength maximum="500" />
                </h:inputTextarea>  
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDescripcionPregunta" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelBotonAgregarPregunta" columnClasses="panelGridBotones">
              <h:commandButton value="Agregar" styleClass="boton"
                                 action="#{registrarPreguntaBean.agregarPregunta}"/>
            </h:panelGrid>
          </s:fieldset>
          
            <s:fieldset legend="Lista Preguntas" id="fieldListaPregunta" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridListaPregunta" 
            rendered="#{empty registrarPreguntaBean.lstPregunta}">
              <h:outputText value="No existen Pregunta"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
            id="panelPreguntaTable"
                         styleClass="tabContainer" rendered="#{not empty registrarPreguntaBean.lstPregunta}">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" 
                binding="#{registrarPreguntaBean.dtPregunta}"
                             cellspacing="0" value="#{registrarPreguntaBean.lstPregunta}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtPregunta">
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Codigo Pregunta"/>
                    </f:facet>
                    <h:outputText value="#{item.id.hppncodigo}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripción Pregunta"/>
                    </f:facet>
                    <t:div style="overflow:auto;width:250px;height:50px;">
                      <h:panelGrid>
                        <h:outputText value="#{item.hppcdescripcio}"/>
                      </h:panelGrid>
                    </t:div>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Fecha de Registro"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hppdfecregistr}"/>
                    </h:panelGrid>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Grabado por"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hppcoperador}"/>
                    </h:panelGrid>
                  </h:column>                                
                  
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Editar"/>
                    </f:facet>
                    <t:commandLink id="editarPregunta" action="#{registrarPreguntaBean.editarPregunta}">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                    </t:commandLink>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Eliminar"/>
                    </f:facet>                    
                        <t:commandButton id="eliminarPregunta"  value="Eliminar" 
                        action="#{registrarPreguntaBean.eliminarPregunta}"
                                     onclick="return confirmar('Realmente desea eliminar el Pregunta?')" image="/comun/imagenes/eliminarObj.gif">                      
                        </t:commandButton>                    
                  </h:column>
                 <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:panelGrid>
                      <h:outputText value="#{item.hppcestado}"/>
                    </h:panelGrid>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Pregunta" for="dtPregunta" fastStep="10" pageCountVar="pageCount"
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
          <t:commandLink action="#{registrarPreguntaBean.volverIndicadores}" immediate="true">
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