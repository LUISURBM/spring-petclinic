<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
             id="panelGridFormularLiquidosTab" styleClass="tabContainer">
 <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                     serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneFormulaLiquidos"
                     styleClass="tabbedPane" activeTabStyleClass="activeTab"
                     inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab"
                     activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub"
                     tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPrescripcionLiquidos" label="Prescripción Liquidos">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                   width="100%" id="panelGridFormulaLiquidos"
                   styleClass="tabContainer">
        <s:fieldset legend="Liquidos Formulados" id="fieldFormulados"
                    styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableLiquidosFormuladosNoDatos"
                       rendered="#{empty formulaLiquidosBean.lstLiquidosFormulados}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableLiquidosFormulados"
                       rendered="#{not empty formulaLiquidosBean.lstLiquidosFormulados}"
                       styleClass="tabContainer">
            <t:buffer into="#{table_formulados}">
              <h:dataTable var="item1" border="1" cellpadding="0"
                           cellspacing="0"
                           binding="#{formulaLiquidosBean.dtLiquidosFormulados}"
                           value="#{formulaLiquidosBean.lstLiquidosFormulados}"
                           rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtLiquidosFormulados">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Liquido"/>
                  </f:facet>
                  <h:outputText value="#{item1.hflcdesctipoli}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cantidad (mL)"/>
                  </f:facet>
                  <h:outputText value="#{item1.hflncantidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Otro"/>
                  </f:facet>
                  <h:outputText value=""/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Suspender"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="checkSuspenderLiquido"
                                           disabled="#{!item1.hflbrendersusp}"
                                           onkeydown="return blockEnter(event);"
                                           value="#{item1.hflbsuspender}"></h:selectBooleanCheckbox>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_formulados}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_9" for="dtLiquidosFormulados"
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
        <s:fieldset legend="Liquidos Formulados Consulta Externa"
                    id="fieldFormuladosConsultaExterna" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%"
                       id="tableLiquidosFormuladosNoDatosConsultaExterna"
                       rendered="#{empty formulaLiquidosBean.lstFormuladosExterna}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="tableLiquidosConsultaExterna"
                       rendered="#{not empty formulaLiquidosBean.lstFormuladosExterna}"
                       styleClass="tabContainer">
            <t:buffer into="#{table_formulados}">
              <h:dataTable var="item1" border="1" cellpadding="0"
                           cellspacing="0"
                           value="#{formulaLiquidosBean.lstFormuladosExterna}"
                           rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtLiquidosExterna">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Liquido"/>
                  </f:facet>
                  <h:outputText value="#{item1.hflcdesctipoli}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cantidad (mL)"/>
                  </f:facet>
                  <h:outputText value="#{item1.hflncantidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Otro"/>
                  </f:facet>
                  <h:outputText value=""/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Suspender"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="checkSuspenderLiquidoExterno"
                                           disabled="#{!item1.hflbrendersusp}"
                                           onkeydown="return blockEnter(event);"
                                           value="#{item1.hflbsuspender}"></h:selectBooleanCheckbox>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_formulados_externa}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Externa" for="dtLiquidosExterna"
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
        <s:fieldset legend="Prescripción Liquidos" id="fieldFormulaLiquidos"
                    styleClass="fieldset">
          <a4j:region id="regionFormulaLiquidos" renderRegionOnly="false">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelDatosFormulaLiquidos"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Nombre del líquido o componente sanguíneo formulado"
                            styleClass="labelTextOblig"/>
              <h:panelGroup>
                <h:outputText value="Liquido" styleClass="labelTextOblig"
                              rendered="#{formulaLiquidosBean.renderOtro}"/>
              </h:panelGroup>
              <h:outputText value="Cantidad en mililitros (ml)."
                            styleClass="labelTextOblig"/>
              <h:outputText value=""/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneMenu id="mnuNombreLiquido" immediate="true"
                                   value="#{formulaLiquidosBean.liquidos.hflcnombreliqu}"
                                   valueChangeListener="#{formulaLiquidosBean.setHflcnombreliqu}">
                    <f:selectItems value="#{formulaLiquidosBean.lstLiquidoParentales}"/>
                    <a4j:support id="supportMnuNombreLiquido" event="onchange"
                                 immediate="true"
                                 action="#{formulaLiquidosBean.ChangeSangre}"
                                 reRender="panelDatosFormulaLiquidos">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuNombreLiquido"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:panelGroup id="panelLiquido">
                <h:inputText id="itLiquido" required="false" alt="Otro Liquido"
                             style="width:100px"
                             rendered="#{formulaLiquidosBean.renderOtro}"
                             value="#{formulaLiquidosBean.liquidos.hflcotroliquid}"/>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{formulaLiquidosBean.renderOtro}">
                  <t:message for="itLiquido" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:inputText id="itCantidad" required="false"
                             alt="Cantidad en mililitros (ml)"
                             style="width:40px" maxlength="4"
                             value="#{formulaLiquidosBean.liquidos.hflncantidad}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCantidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:outputText value="Via de administración"/>
              <h:panelGroup id="outputFormaAdministracion">
                <h:outputText value="Forma de Administración"
                              rendered="#{formulaLiquidosBean.mostrarAdministracion}"
                              styleClass="labelTextOblig"/>
              </h:panelGroup>
              <h:panelGroup id="panelVelocidad">
                <h:outputText value="Velocidad de administración (ml/hora)"
                              styleClass="labelTextOblig"
                              rendered="#{formulaLiquidosBean.mostrarFormaAdmin}"/>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup>
                <a4j:region renderRegionOnly="false">
                  <h:selectOneRadio id="mnuVia" required="false"
                                    immediate="true"
                                    value="#{formulaLiquidosBean.liquidos.hflcviadminist}"
                                    valueChangeListener="#{formulaLiquidosBean.setViaAdministracion}">
                    <f:selectItems value="#{formulaLiquidosBean.lstVia}"/>
                    <a4j:support id="supportmnuVia" event="onclick"
                                 action="#{formulaLiquidosBean.ChangeViaAdministracion}"
                                 reRender="outputFormaAdministracion,inputmnuFormaAdministracion">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                </a4j:region>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuVia" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup id="inputmnuFormaAdministracion">
                <h:selectOneMenu id="mnuFormaAdministracion"
                                 rendered="#{formulaLiquidosBean.mostrarAdministracion}"
                                 value="#{formulaLiquidosBean.liquidos.hflcformadmins}"
                                 valueChangeListener="#{formulaLiquidosBean.setFormaAdministracion}">
                  <f:selectItems value="#{formulaLiquidosBean.lstFormaAdministracion}"/>
                  <a4j:support id="supportmnuFormaAdmin" event="onclick"
                               action="#{formulaLiquidosBean.ChangeFormaAdmin}"
                               reRender="panelVelocidad,panelVelocidadMili">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="mnuFormaAdministracion"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:panelGroup id="panelVelocidadMili">
                  <h:inputText id="itVelocidad" style="width:40px" maxlength="4"
                               rendered="#{formulaLiquidosBean.mostrarFormaAdmin}"
                               alt="Velocidad en mililitros por hora. (ml/hora)."
                               value="#{formulaLiquidosBean.liquidos.hflnvelocidadm}"
                               required="false"/>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itVelocidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:outputText value=""/>
              <h:panelGroup id="panelTextClaseSangre">
                <h:outputText value="Clase de Sangre"
                              rendered="#{formulaLiquidosBean.renderSangre}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextGrupoSangre">
                <h:outputText value="Grupo Sanguineo"
                              rendered="#{formulaLiquidosBean.renderSangre}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextFactorSangre">
                <h:outputText value="Factor RH"
                              rendered="#{formulaLiquidosBean.renderSangre}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:panelGroup id="panelMnuClaseSangre">
                <h:selectOneMenu id="mnuClaseSangre"
                                 rendered="#{formulaLiquidosBean.renderSangre}"
                                 value="#{formulaLiquidosBean.liquidos.hflctiposangre}">
                  <f:selectItems value="#{formulaLiquidosBean.lstClaseSangre}"/>
                </h:selectOneMenu>
              </h:panelGroup>
              <h:panelGroup id="panelMnuGrupoSangre">
                <h:selectOneRadio id="mnuGrupoSangre"
                                  rendered="#{formulaLiquidosBean.renderSangre}"
                                  value="#{formulaLiquidosBean.liquidos.hflcgrupsangre}">
                  <f:selectItems value="#{formulaLiquidosBean.lstGrupoSangre}"/>
                </h:selectOneRadio>
              </h:panelGroup>
              <h:panelGroup id="panelMenuFactorSangre">
                <h:selectOneRadio id="mnuFactorSangre"
                                  rendered="#{formulaLiquidosBean.renderSangre}"
                                  value="#{formulaLiquidosBean.liquidos.hflcfactosangre}">
                  <f:selectItems value="#{formulaLiquidosBean.lstFactorSangre}"/>
                </h:selectOneRadio>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:panelGroup id="panelTextNumeroUnidad">
                <h:outputText value="Número de la Unidad"
                              rendered="#{formulaLiquidosBean.renderSangre}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextSelloCalidad">
                <h:outputText value="Sello de Calidad"
                              rendered="#{formulaLiquidosBean.renderSangre}"/>
              </h:panelGroup>
              <h:panelGroup id="panelTextFechaVencimiento">
                <h:outputText value="Fecha Vencimiento"
                              rendered="#{formulaLiquidosBean.renderSangre}"/>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
              <h:panelGroup id="panelInputNumeroUnidad">
                <h:inputText id="itNumeroUnidad" style="width:80px"
                             maxlength="9"
                             rendered="#{formulaLiquidosBean.renderSangre}"
                             value="#{formulaLiquidosBean.liquidos.hflnunidasangr}"/>
              </h:panelGroup>
              <h:panelGroup id="panelInputSelloUnidad">
                <h:inputText id="itSelloUnidad" style="width:80px" maxlength="9"
                             rendered="#{formulaLiquidosBean.renderSangre}"
                             value="#{formulaLiquidosBean.liquidos.hflnsellocalid}"/>
              </h:panelGroup>
              <h:panelGroup id="panelCalendarVencimientoSangre">
                <t:inputCalendar id="calendarVencimientoSangre"
                                 title="Formato: dd/mm/yyyy"
                                 onkeydown="return blockEnter(event);"
                                 rendered="#{formulaLiquidosBean.renderSangre}"
                                 monthYearRowClass="yearMonthHeader"
                                 weekRowClass="weekHeader"
                                 currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy"
                                 renderAsPopup="true"
                                 value="#{formulaLiquidosBean.liquidos.hfldsangrvenci}"
                                 popupTodayString="Hoy" popupWeekString="Semana"
                                 popupButtonString="Fecha" readonly="false"
                                 maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top"
                                 required="false"></t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true"
                                 rendered="#{formulaLiquidosBean.renderSangre}">
                  <t:message for="calendarVencimientoSangre"
                             styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
              <h:panelGroup>
                <h:outputText value=""/>
              </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonAgregarFormula"
                         columnClasses="columnaBotones">
              <h:panelGroup>
                <t:htmlTag value="br"/>
                <a4j:commandButton value="Agregar"
                                   styleClass="btn btn btn-success"
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
                           cellspacing="0" width="100%" id="panelLiquidosTable"
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
                      <h:outputText value="#{item.hflcdesctipoli} (#{item.hflcotroliquid})"/>
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
                                        url="/comun/imagenes/Delete.png"/>
                      </a4j:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtLiquidos" fastStep="10"
                                    pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
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
                        <t:graphicImage alt="" url="/comun/imagenes/atras.gif"
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
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0"
                       width="100%" id="panelBotonModificar"
                       columnClasses="panelGridBotones">
            <h:commandButton value="Generar Formula Liquidos"
                             styleClass="btn btn btn-success"
                             action="#{formulaLiquidosBean.generarFormulaLiquidos}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGrid>
        </a4j:region>
        <h:panelGrid>
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionFormulaLiquidosMsg"
                             ajaxRendered="true">
              <t:messages id="msgFormulaLiquidosMsg" showSummary="true"
                          errorClass="error" globalOnly="true" layout="table"
                          infoClass="informacion"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>