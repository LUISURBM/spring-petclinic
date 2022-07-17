<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formCuestionarioPreanestesia">
 <a4j:region id="regionCuestionarioPreanestesia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionCuestionarioPreanestesia">
      <f:facet name="start">
        <t:div id="chargingCuestionarioPreanestesia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>




  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridCuestionarioPreanestesiaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneCuestionarioPreanestesia"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
     <t:panelTab id="panelTabAntecedentesGenerales" label="Cuestionario">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="tableContentTabsAntecedentesGenerales"
                 styleClass="tabContainer">      
                 <a4j:region renderRegionOnly="false">
                       <h:panelGrid columns="5">
                                <h:outputText value="[ "/>
                                <a4j:commandLink  value=" Todos SI"  immediate="true"  action="#{cuestionarioPreanestesiaBean.changeTodosSi}" reRender="tableContentTabsAntecedentesGenerales"/>
                                <h:outputText value=" | "/>
                                <a4j:commandLink  value="Todos NO " immediate="true"  action="#{cuestionarioPreanestesiaBean.changeTodosNo}" reRender="tableContentTabsAntecedentesGenerales" />
                                <h:outputText value=" ]"/>
                            </h:panelGrid>
                            </a4j:region>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="tableContentTabs"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"  
                               binding="#{cuestionarioPreanestesiaBean.dtCuestionario}"
                               value="#{cuestionarioPreanestesiaBean.lstPreguntasAnestesia}"
                               rows="30" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtAntecedentes">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripcion Pregunta"/>
                      </f:facet>
                      <h:outputText value="#{item.hpacdescripcio}" />
                    </h:column>
                    
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Respuesta"/>
                      </f:facet>
                    <h:selectOneRadio id="mnuRespuesta" immediate="true" 
                                valueChangeListener="#{item.setHpacrespuesta}"
                                 value="#{item.hpacrespuesta}">
                  <f:selectItems value="#{cuestionarioPreanestesiaBean.lstOpciones}"/>
                   <a4j:support id="supportmnuRespuesta" event="onclick"
                                 immediate="true"
                                 action="#{item.changeFumar}"
                                 reRender="panelGridCuestionarioPreanestesiaTab">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                            <a4j:outputPanel ajaxRendered="true">
                             <t:message for="mnuRespuesta" styleClass="errorMessage"/>
                            </a4j:outputPanel>
               </h:selectOneRadio>
               <h:panelGrid columns="2">
               <h:outputText value = "¿Cuantos al día?  " rendered="#{item.mostrarFumar}"/>
             
               <h:inputText id = "itFumaDia" value = "#{cuestionarioPreanestesiaBean.fumadia}" style="width:50px" rendered="#{item.mostrarFumar}"  maxlength="2" required="true"/>
    
              
               </h:panelGrid>
                    </h:column>
                   
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Anotación"/>
                      </f:facet>
                      <h:inputTextarea value="#{item.hpacanotacion}" style="width:300px"/>
                    </h:column>
                   
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtAntecedentes"
                                    fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                 
                  </h:panelGrid>
                </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>
            
      <h:panelGrid>

        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInf" showSummary="true" errorClass="error"
                        globalOnly="true" layout="table"
                        infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
        <s:fieldset legend="Observaciones" id="fieldMotivo1"
                  styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     width="100%" id="panelObservaciones"
                     rowClasses="labelText,labelTextInfo">
                    <h:outputText value = "Observaciones Adicionales"/> 
                    <h:inputTextarea id="itObservaciones" value = "#{cuestionarioPreanestesiaBean.observacion}" style="width:800px"/>
        </h:panelGrid>
    </s:fieldset>
    </h:panelGrid>
          
    </t:panelTab>
     <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Guardar"
                                  styleClass="boton_fieldset"
                                  action="#{cuestionarioPreanestesiaBean.aceptar}">
                    <a4j:support event="onclick" status="statusButton"/>              
                </h:commandButton>

              </h:panelGroup>
            </h:panelGrid>
    
    
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>