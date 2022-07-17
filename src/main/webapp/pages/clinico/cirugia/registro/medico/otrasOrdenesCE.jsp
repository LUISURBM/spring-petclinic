<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAntecedentesGeneralesTab"
             styleClass="tabContainer">
 <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
 <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneAntecedentes"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabAntecedentes" label="Otras Ordenes C�rugia ">
   
           <s:fieldset legend="Historial Otras Ordenes" id="fieldFormulados"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableLiquidosFormuladosNoDatos"
                       rendered="#{empty otrasOrdenesCEBean.lstHistoricoOrdenes}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableLiquidosFormulados"
                       rendered="#{not empty otrasOrdenesCEBean.lstHistoricoOrdenes}"
                       styleClass="tabContainer">
            <t:buffer into="#{table_formulados}">
              <h:dataTable var="item1" border="1" cellpadding="0"
                           cellspacing="0"
                           binding="#{otrasOrdenesCEBean.dtHistoriasOtrasOrdenes}"
                           value="#{otrasOrdenesCEBean.lstHistoricoOrdenes}"
                           rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtHistoriasOtrasOrdenes">
                <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre de la Orden"/>
                      </f:facet>
                      <h:outputText value="#{item1.nombreTipo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripci�n "/>
                      </f:facet>
                      <h:outputText value="#{item1.hcocordenenvi}"/>
                    </h:column>
                      <h:column>
                  <f:facet name="header">
                    <h:outputText value="Suspender"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="checkSuspenderLiquido"
                                           disabled="#{!item1.hcobrendersusp}"
                                           onkeydown="return blockEnter(event);"
                                           value="#{item1.hcobsuspender}"></h:selectBooleanCheckbox>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_formulados}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_9" for="dtHistoriasOtrasOrdenes"
                                fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller"
                                paginator="true" immediate="true"
                                paginatorMaxPages="9"
                                paginatorTableClass="paginator"
                                renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage alt="" url="/comun/imagenes/primero.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage alt="" url="/comun/imagenes/anterior.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage alt="" url="/comun/imagenes/adelante.gif"
                                    border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage alt="" url="/comun/imagenes/atras.gif"
                                    border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller_formulados}" escape="false"/>
            <h:outputText value="#{table_formulados}" escape="false"/>
            <h:outputText value="#{tableScroller_formulados}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        
        
        
        
        
        
              <s:fieldset legend="Otras Ordenes" id="fieldAntecedentes"
                      styleClass="fieldset">
                      
        
            
              
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelAntecedentes"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Tiene Ordenes Nuevas"
                            styleClass="labelTextOblig"/>
             <a4j:region renderRegionOnly="false">
              <h:selectOneRadio id="mnuAntecedentes" immediate="true"
                                required="true" onkeydown="return blockEnter(event);"
                                value="#{otrasOrdenesCEBean.nuevasOrdenes}"
                                valueChangeListener="#{otrasOrdenesCEBean.setNuevasOrdenes}">
                <f:selectItems value="#{paraclinicosUsuarioBean.lstOpciones}"/>
                <a4j:support id="supportmnuAntecedentes" event="onclick"
                             action="#{otrasOrdenesCEBean.changeOtrasOrdenes}"
                             reRender="tableContentTabsAntecedentes">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuAntecedentes" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:selectOneRadio>
              </a4j:region>
            </h:panelGrid>
          </s:fieldset>
        

          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableContentTabsAntecedentes"
                       styleClass="tabContainer">
                       
         <s:fieldset legend="Seleccion de Otras Ordenes" id="fieldAntecedentesSeleccion"
                      styleClass="fieldset"   rendered="#{otrasOrdenesCEBean.mostrarOrden}">
            <a4j:region id="regionAntece" renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%"
                           id="panelDatosAntecedentes"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre de la orden"
                              styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                
                <h:panelGroup>
                  <h:selectOneMenu id="itNombreParaclinicoAnt"  value="#{otrasOrdenesCEBean.nombreOrden}">
                   <f:selectItem itemLabel="Seleccione.." itemValue="L"/>
                     <f:selectItems value="#{otrasOrdenesCEBean.lstaTipoOrden}" />
                     <a4j:support id="supportTipoOrden" event="onchange"
                             action="#{otrasOrdenesCEBean.changeTipoOrden}"
                             reRender="panelInputDescr,panelDatosAntecedentes,panelInputDescrOx">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                </h:selectOneMenu>
                   
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itNombreParaclinicoAnt" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                 <h:outputText value=""/>
                 <h:outputText value=""/>
                <h:panelGroup id="panelInputDescr" rendered="#{otrasOrdenesCEBean.renderedTipoOrden}">
                 <h:outputText id="outDescr" value="Descripci�n" styleClass="labelTextOblig" />
                  <h:inputTextarea id="textAnt"
                                   value="#{otrasOrdenesCEBean.observacionesOrden}"
                                   style="width:600px">
                    <f:validateLength maximum="4000" minimum = "3"/>
                </h:inputTextarea>        
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="outDescr" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup >
                <h:panelGrid columns="1" id="panelInputDescrOx" rendered="#{otrasOrdenesCEBean.renderedTipoOrdenOxigeno}">
                 <h:outputText id="outDescOxr" value="Sistema de oxigenaci�n" styleClass="labelTextOblig" />
                 <h:selectOneMenu id="itNombreParaclinicoAntOx" value="#{otrasOrdenesCEBean.controOrden.hcocsistoxige}">
                      <f:selectItems id = "menuOxigeno" value="#{otrasOrdenesCEBean.lstaTipoOrdenOxigeno}"/>
                <a4j:support id="supportOxigenoSuspender" event="onchange" 
                             reRender="panelInputDescrOx">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                   </a4j:support>
                     <a4j:outputPanel ajaxRendered="true">
                    <t:message for="menuOxigeno" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  </h:selectOneMenu>   
                  
                  <h:outputText id="outCantidadOxr" value="Cantidad Litros /minutos " styleClass="labelTextOblig" />
                  <h:panelGrid columns="2">
                  <h:panelGroup>
                 <h:panelGrid columns="1">
                 <h:outputText id="outCantidadLOxr" value="Litros "/>
                   <h:inputText id="textCantiLOx"
                                   value="#{otrasOrdenesCEBean.controOrden.hcoccantlitros}"
                                   style="width:60px">
                    <f:validateLongRange maximum="3" minimum = "1"/>
                     </h:inputText>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textCantiLOx" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                 <h:panelGrid columns="1">
                 <h:outputText id="outCantidadMOxr" value="Minutos" />
                  <h:inputText id="textCantiMOx" 
                                   value="#{otrasOrdenesCEBean.controOrden.hcoccantminutos}"
                                   style="width:60px">
                    <f:validateLength maximum="3" minimum = "1"/>
                </h:inputText> 
                   <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textCantiMOx" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  </h:panelGrid>
                  </h:panelGroup>
                  </h:panelGrid>
                  <h:outputText id="outDuracion" value="Duraci�n "/>
                   <h:inputTextarea id="textDuracionOx"
                                   value="#{otrasOrdenesCEBean.observacionesOrden}"
                                   style="width:500px">
                   </h:inputTextarea>
                 <a4j:outputPanel ajaxRendered="true">
                    <t:message for="textDuracionOx" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
                
                </h:panelGroup>
                <h:outputText value=""/>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonAgregar"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                      <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                                     action="#{otrasOrdenesCEBean.agregarOtrasOrdenes}"
                                     reRender="tableContentTabsAntecedentes"/>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
            
            
            
            <s:fieldset legend="Lista Otras Ordenes" id="fieldAntecedentesLista"   rendered="#{not empty otrasOrdenesCEBean.lstOtrasOrdenes}"
                        styleClass="fieldset">
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           
                           cellspacing="0" width="100%" id="tableContentTabs"
                           styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               binding="#{otrasOrdenesCEBean.dtOtrasOrdenes}"
                               cellspacing="0"
                                value="#{otrasOrdenesCEBean.lstOtrasOrdenes}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtOtrasOrdenes">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre de la Orden"/>
                      </f:facet>
                      <h:outputText value="#{item.nombreTipo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripci�n "/>
                      </f:facet>
                      <h:outputText value="#{item.hcocordenenvi}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <h:commandLink id="eliminar" immediate="true"
                                     action="#{otrasOrdenesCEBean.eliminarOtrasOrdenes}">
                        <t:graphicImage border="0" alt="" 
                                        url="/comun/imagenes/editar.gif"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtOtrasOrdenes"
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
            </s:fieldset>
   
              </s:fieldset>
                <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonModificar"
                           columnClasses="panelGridBotones">
                <h:panelGroup>
                  <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                   action="#{otrasOrdenesCEBean.aceptar}">
                </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </h:panelGrid>
          <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
                   <t:messages id="msgInf" showSummary="true" errorClass="error"
                              globalOnly="true" layout="table"
                              infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
        <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid>