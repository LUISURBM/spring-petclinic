<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formFormulaLiquidos">
  <a4j:region id="regionFormulaLiquidos" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionFormulaLiquidos">
      <f:facet name="start">
        <t:div id="chargingFormulaLiquidos" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                 width="100%" id="panelGridFormulaLiquidosTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                         serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneFormulaLiquidos"
                         styleClass="tabbedPane" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabPrescripcionLiquidos"
                    label="Prescripción Liquidos">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelGridFormulaLiquidos"
                       styleClass="tabContainer">
            <s:fieldset legend="Prescripción Liquidos" id="fieldFormulaLiquidos"
                        styleClass="fieldset">
              <a4j:region id="regionFormulaLiquidos" renderRegionOnly="false">
                <h:panelGrid columns="3" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelDatosFormulaLiquidos"
                             rowClasses="labelText">
                  <h:outputText value="Nombre del líquido o componente sanguíneo formulado "
                                styleClass="labelTextOblig"/>
                  <h:outputText value="Cantidad en mililitros (ml)."
                                styleClass="labelTextOblig"/>
                  <h:outputText value="Velocidad de administración"
                                styleClass="labelTextOblig"/>
                  <h:panelGroup>
                    <h:inputTextarea id="itNombreLiquido" required="true"
                                     value="#{formulaLiquidosBean.nombreLiquido}"
                                     style="width:300px"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itNombreLiquido"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itCantidad" required="true"
                                 alt="Cantidad en mililitros (ml)"
                                 style="width:40px" maxlength="4"
                                 value="#{formulaLiquidosBean.cantidad}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itCantidad" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:inputText id="itVelocidad" style="width:40px"
                                 maxlength="4"
                                 alt="Velocidad en mililitros por hora. (ml/hora)."
                                 value="#{formulaLiquidosBean.velocidad}"
                                 required="true"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itVelocidad" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:outputText value="Via de administración"
                                styleClass="labelTextOblig"/>
                  <h:panelGroup id="outputFormaAdministracion">
                    <h:outputText value="Forma de Administración"
                                  rendered="#{formulaLiquidosBean.mostrarAdministracion}"
                                  styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup id="outputTiempoAdministracion">
                    <h:outputText value="Tiempo de administración en minutos"
                                  rendered="#{formulaLiquidosBean.mostrarAdministracion}"
                                  styleClass="labelTextOblig"/>
                  </h:panelGroup>
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuVia" required="true"
                                     immediate="true"
                                     value="#{formulaLiquidosBean.viaAdministracion}"
                                     valueChangeListener="#{formulaLiquidosBean.setViaAdministracion}">
                      <f:selectItems value="#{formulaLiquidosBean.lstVia}"/>
                      <a4j:support id="supportmnuVia" event="onclick"
                                   immediate="true"
                                   action="#{formulaLiquidosBean.ChangeViaAdministracion}"
                                   reRender="outputFormaAdministracion,outputTiempoAdministracion,inputmnuFormaAdministracion,inputTiempo">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuVia" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id="inputmnuFormaAdministracion">
                    <h:selectOneMenu id="mnuFormaAdministracion" required="true"
                                     rendered="#{formulaLiquidosBean.mostrarAdministracion}"
                                     value="#{formulaLiquidosBean.formaAdministracion}">
                      <f:selectItems value="#{formulaLiquidosBean.lstFormaAdministracion}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuFormaAdministracion"
                                 styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                  <h:panelGroup id="inputTiempo">
                    <h:inputText id="itTiempo" required="true"
                                 alt="Tiempo de administración en minutos"
                                 rendered="#{formulaLiquidosBean.mostrarAdministracion}"
                                 style="width:40px" maxlength="4"
                                 value="#{formulaLiquidosBean.tiempoAdministracion}"/>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="itTiempo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </h:panelGrid>
                <h:panelGrid columns="2" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelBotonAgregarFormula"
                             columnClasses="columnaBotones">
                  <h:panelGroup>
                    <t:htmlTag value="br"/>
                    <a4j:commandButton value="Agregar"
                                       styleClass="boton_fieldset_Naranja"
                                       action="#{formulaLiquidosBean.agregarLiquidos}"
                                       reRender="panelGridFormulaLiquidos"/>
                  </h:panelGroup>
                </h:panelGrid>
              </a4j:region>
              <a4j:region renderRegionOnly="false">
                <s:fieldset legend="Formula Liquidos" id="fieldLiquidosLista"
                            rendered="#{not empty formulaLiquidosBean.lstLiquidos}"
                            styleClass="fieldset">
                  <h:panelGrid columns="1" border="0" cellpadding="0"
                               cellspacing="0" width="100%"
                               id="panelLiquidosTable"
                               styleClass="tabContainer">
                    <t:buffer into="#{table}">
                      <h:dataTable var="item" border="1" cellpadding="0"
                                   binding="#{formulaLiquidosBean.dtLiquidos}"
                                   cellspacing="0"
                                   value="#{formulaLiquidosBean.lstLiquidos}"
                                   rows="10" styleClass="standard_table"
                                   rowClasses="standardTable_Row1,standardTable_Row2"
                                   footerClass="paginacion" id="dtLiquidos">
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Liquidos"/>
                          </f:facet>
                          <h:outputText value="#{item.hflcnombreliqu}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Dosis"/>
                          </f:facet>
                          <h:outputText value="#{item.hflncantidad}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Via"/>
                          </f:facet>
                          <h:outputText value="#{item.hflcviadminist}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Forma"/>
                          </f:facet>
                          <h:outputText value="#{item.wdescforma}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Velocidad Adm."/>
                          </f:facet>
                          <h:outputText value="#{item.hflnvelocidadm}"/>
                        </h:column>
                        <h:column>
                          <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                          </f:facet>
                          <a4j:commandLink id="eliminar" immediate="true"
                                           onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                                           reRender="panelGridFormulaLiquidos"
                                           action="#{formulaLiquidosBean.eliminarFormula}">
                            <t:graphicImage alt="" border="0"
                                            url="/comun/imagenes/editar.gif"/>
                          </a4j:commandLink>
                        </h:column>
                      </h:dataTable>
                    </t:buffer>
                    <t:buffer into="#{tableScroller}">
                      <h:panelGrid columns="1"
                                   rowClasses="labelTextInfo,labelTextInfo">
                        <t:dataScroller id="scroll_1" for="dtLiquidos"
                                        fastStep="10" pageCountVar="pageCount"
                                        pageIndexVar="pageIndex"
                                        styleClass="scroller" paginator="true"
                                        immediate="true" paginatorMaxPages="9"
                                        paginatorTableClass="paginator"
                                        renderFacetsIfSinglePage="false"
                                        paginatorActiveColumnStyle="font-weight:bold;">
                          <f:facet name="first">
                            <t:graphicImage alt=""
                                            url="/comun/imagenes/primero.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="last">
                            <t:graphicImage alt=""
                                            url="/comun/imagenes/ultimo.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="previous">
                            <t:graphicImage alt=""
                                            url="/comun/imagenes/anterior.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="next">
                            <t:graphicImage alt=""
                                            url="/comun/imagenes/siguiente.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="fastforward">
                            <t:graphicImage alt=""
                                            url="/comun/imagenes/adelante.gif"
                                            border="0"/>
                          </f:facet>
                          <f:facet name="fastrewind">
                            <t:graphicImage alt=""
                                            url="/comun/imagenes/atras.gif"
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
              </a4j:region>
            </s:fieldset>
            <a4j:region renderRegionOnly="false">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelBotonModificar"
                           columnClasses="panelGridBotones">
                <a4j:commandButton value="Generar Formula Liquidos"
                                   reRender="panelGridFormulaLiquidos"
                                   styleClass="boton_fieldset"
                                   action="#{formulaLiquidosBean.generarFormulaLiquidos}"/>
              </h:panelGrid>
            </a4j:region>
            <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionFormulaLiquidosMsg"
                                 ajaxRendered="true">
                  <t:messages id="msgFormulaLiquidosMsg" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>