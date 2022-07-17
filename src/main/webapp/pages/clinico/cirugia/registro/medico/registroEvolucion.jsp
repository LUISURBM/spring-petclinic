<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEvolucionTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneEvolucion" styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                     selectedIndex="#{evolucionBean.selectedIndex}"
                     activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub" 
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabEvolucion" label="Evolución">
    
         <s:fieldset legend="Cirugia(s) Programada(s)" id="fieldCirugiasNotaEnfermeria" styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelCirugiasNotaEnfermeria" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervención(es)"/>
                <h:outputText/>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           rendered="#{not empty evolucionBean.lstCirugias}" cellspacing="0" width="100%"
                           id="tableCirugiasProgramadasNotaEnfermeria" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               binding="#{evolucionBean.dtCirugias}"
                               value="#{evolucionBean.lstCirugias}" rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                               id="dtCirugiasProgramadasNotasEnfermeria">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo"/>
                      </f:facet>
                      <h:outputText value="#{item.csvccodigo}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcnombre}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Estado"/>
                      </f:facet>
                      <h:outputText value="#{item.csvcestado}"/>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasNotasEnfermeria" fastStep="10"
                                    pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                    paginator="true" immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
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
    
       <s:fieldset legend="Datos Evolucion" id="fieldExamenFisico" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridEvolucion"
                     rowClasses="labelText,labelTextInfo">
                     
                     
                     
                     
                        <!-- COMIENZA ESCALA DE DOLOR -->
          <s:fieldset legend="Escala de Dolor" id="fieldEscalaDolor" styleClass="fieldset">
            <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEscalaDolor"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Refiere dolor" styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <h:panelGroup id="panelEscala" >
                <h:outputText value="Escala de Dolor" styleClass="labelTextOblig" 
                        rendered="#{evolucionBean.renderDolor}"/>
              </h:panelGroup>
              <h:outputText value=""/>
            <h:panelGroup id = "itTextDuracionDolor">
               <h:outputText value="Duración del dolor"  rendered="#{evolucionBean.renderDolor}"
               styleClass="labelTextOblig"/>
               </h:panelGroup>
                  <h:panelGroup id = "itTextUnidadMedida">
               <h:outputText value="Unidad de Medida"  rendered="#{evolucionBean.renderDolor}"
               styleClass="labelTextOblig"/>
               </h:panelGroup>

              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="radioEscalaDolor" required="true" immediate="true"
                                    onkeydown="return blockEnter(event);"
                                    value="#{evolucionBean.evolucion.hevcrefiedolor}"
                                    valueChangeListener="#{evolucionBean.listenDolorCirugia}">
                    <f:selectItems value="#{evolucionBean.lstOpciones}"/>
                    <a4j:support id="supportradioEscalaDolor" event="onclick" reRender="panelEscalaDolor">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </h:panelGroup>
              </a4j:region>
              <h:outputText value=""/>
              <h:panelGroup id="panelRenderDolor" rendered="#{evolucionBean.renderDolor}">
                <h:selectOneRadio id="selectEscalaDolor" layout="lineDirection" value="#{evolucionBean.evolucion.hevnescaladolo}" style="margin-left:55px; width:580px">
                                <f:selectItems value="#{evolucionBean.listEscala}"/>
                                  <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneRadio>
                <h:graphicImage url="/comun/imagenes/escalaDolor2.png" style="width:650px"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="selectEscalaDolor" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
             
             
             
             <h:panelGroup>
                <h:inputText id="menuDuraDolor" maxlength="2" size="2" style="width:30px" immediate="true"
                             rendered="#{evolucionBean.renderDolor}"
                             value="#{evolucionBean.evolucion.hevnduradolor}"
                             onkeypress="return justNumbers(event);">
                              <a4j:support event="onchange" status="statusButton"/>
                             </h:inputText>
                             
               <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuDuraDolor" styleClass="errorMessage"/>
              </a4j:outputPanel>
           </h:panelGroup>
            
            <h:panelGroup>
                            <h:selectOneMenu id="menuTiempo3" styleClass="input-small labelTextOblig"
                rendered="#{evolucionBean.renderDolor}" immediate="true"
                value="#{evolucionBean.evolucion.hevcdudointen}">
                    <f:selectItem itemLabel="Seleccione una opción ..." itemValue=""/>
                    <f:selectItem itemLabel="Minuto(s)" itemValue="MI"/>
                    <f:selectItem itemLabel="Hora(s)" itemValue="H"/>
                    <f:selectItem itemLabel="Día(s)" itemValue="D"/>
                    <f:selectItem itemLabel="Semana(s)" itemValue="S"/>
                     <a4j:support event="onchange" status="statusButton"/>
                </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                <t:message for="menuTiempo3" styleClass="errorMessage"/>
              </a4j:outputPanel>

              </h:panelGroup>
           
            </h:panelGrid>
          </s:fieldset>
          <!--FIN DE LA ESCALA DE DOLOR -->
                     
                     
                     
          <h:outputText value="Notas sobre lo que refiere el paciente" styleClass="labelTextOblig"/>
             <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
                  <a4j:commandLink action="#{evolucionBean.mostrarBuscadorPlantilla}" 
                  immediate="true"
                                   reRender="panelGridEvolucionTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                         <h:inputTextarea id="textEvolucion" 
                         value="#{evolucionBean.evolucion.hevcnotapacien}"
                         binding="#{evolucionBean.itEvolucion}"
                         required="true"
                             style="width:800px;height:40px"/>
                           <a4j:outputPanel ajaxRendered="true">
                           <t:message for="textEvolucion" styleClass="errorMessage"/>
                      </a4j:outputPanel>


                </h:panelGrid>

          
          
          
          <h:panelGroup>
          </h:panelGroup>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesEvolucion"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success" action="#{evolucionBean.aceptar}"/>
        </h:panelGroup>
      </h:panelGrid>
      <h:panelGrid></h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionEvolucionMsg" ajaxRendered="true">
            <t:messages id="msgInformationEvolucionMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
    
        <t:panelTab id="panelBuscadorPlantillaEvolucion" label="Buscar Plantillas" 
        rendered="#{evolucionBean.renderPlantilla}">
      <a4j:region id="regionBuscadorPlantillaEvolucion" renderRegionOnly="false">
        <a4j:status for="regionBuscadorPlantillaEvolucion">
          <f:facet name="start">
            <t:div id="chargingBuscadorPlantillaEvolucion" styleClass="loading">
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:outputText value="Procesando..."/>
                <h:outputText value="Por favor espere."/>
              </h:panelGrid>
            </t:div>
          </f:facet>
          <f:facet name="stop"/>
        </a4j:status>
        <jsp:include page="/pages/clinico/comunes/buscador/buscadorPlantillasCirugia.jsp" flush="true"/>
      </a4j:region>
    </t:panelTab> 
  </t:panelTabbedPane>
</h:panelGrid>