<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridLiquidosAnestesiaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosAnestesiologo.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneLiquidosAnestesia" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabPrescripcionHospitalizacion" label="Balance de Liquidos">
     
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridLiquidosAnestesia"
                   styleClass="tabContainer">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Prescripci�n Liquidos" id="fieldFormulaLiquidos" styleClass="fieldset">
            <a4j:region id="regionFormulaLiquidos" renderRegionOnly="false">
              <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosFormulaLiquidos" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Nombre del l�quido o componente sangu�neo formulado" styleClass="labelTextOblig"/>
                <h:panelGroup>
                  <h:outputText value="Liquido" styleClass="labelTextOblig"
                                rendered="#{registrarLiquidosAnestesiaBean.renderOtro}"/>
                </h:panelGroup>
                <h:outputText value="Cantidad (mL)" styleClass="labelTextOblig"/>
                <h:outputText value=""/>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneMenu id="mnuNombreLiquido" immediate="true"
                                     value="#{registrarLiquidosAnestesiaBean.liquidos.hclctipoliquid}"
                                     valueChangeListener="#{registrarLiquidosAnestesiaBean.setHclctipoliquid}">
                      <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstLiquidoParentales}"/>
                      <a4j:support id="supportMnuNombreLiquido" event="onchange" immediate="true"
                                   action="#{registrarLiquidosAnestesiaBean.ChangeSangre}"
                                   reRender="panelDatosFormulaLiquidos">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuNombreLiquido" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
                <h:panelGroup id="panelLiquido">
                  <h:inputText id="itLiquido" required="false" alt="Otro Liquido" style="width:100px"
                               rendered="#{registrarLiquidosAnestesiaBean.renderOtro}"
                               value="#{registrarLiquidosAnestesiaBean.liquidos.hclcotroliquid}"/>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderOtro}">
                    <t:message for="itLiquido" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:inputText id="itCantidad" required="false" alt="Cantidad (mL)" style="width:40px"
                               maxlength="4" value="#{registrarLiquidosAnestesiaBean.liquidos.hclncantidad}"/>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itCantidad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:outputText value="Via de administraci�n"/>
                <h:panelGroup id="outputFormaAdministracion">
                  <h:outputText value="Forma de Administraci�n"
                                rendered="#{registrarLiquidosAnestesiaBean.mostrarAdministracion}"
                                styleClass="labelTextOblig"/>
                </h:panelGroup>
                <h:panelGroup id="panelVelocidad">
                  <h:outputText value="Velocidad de administraci�n (mL/hora)" styleClass="labelTextOblig"
                                rendered="#{registrarLiquidosAnestesiaBean.mostrarFormaAdmin}"/>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:selectOneRadio id="mnuVia" required="false" immediate="true"
                                      value="#{registrarLiquidosAnestesiaBean.liquidos.hclcvialiquido}"
                                      valueChangeListener="#{registrarLiquidosAnestesiaBean.setViaAdministracion}">
                      <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstVia}"/>
                      <a4j:support id="supportmnuVia" event="onclick"
                                   action="#{registrarLiquidosAnestesiaBean.ChangeViaAdministracion}"
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
                  <h:selectOneRadio id="mnuFormaAdministracion" required="false" layout="pageDirection"
                                    rendered="#{registrarLiquidosAnestesiaBean.mostrarAdministracion}"
                                    value="#{registrarLiquidosAnestesiaBean.liquidos.hclcformadmins}"
                                    valueChangeListener="#{registrarLiquidosAnestesiaBean.setFormaAdministracion}">
                    <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstFormaAdministracion}"/>
                    <a4j:support id="supportmnuFormaAdmin" event="onclick"
                                 action="#{registrarLiquidosAnestesiaBean.ChangeFormaAdmin}"
                                 reRender="panelVelocidad,panelVelocidadMili">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuFormaAdministracion" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:panelGroup id="panelVelocidadMili">
                    <h:inputText id="itVelocidad" style="width:40px" maxlength="4"
                                 rendered="#{registrarLiquidosAnestesiaBean.mostrarFormaAdmin}"
                                 alt="Velocidad (mL/hora)."
                                 value="#{registrarLiquidosAnestesiaBean.liquidos.hclnvelocidadm}" required="false"/>
                  </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itVelocidad" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:outputText value=""/>
                <h:panelGroup id="panelTextClaseSangre">
                  <h:outputText value="Clase de Sangre" styleClass="labelTextOblig"
                                rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextGrupoSangre">
                  <h:outputText value="Grupo Sanguineo" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFactorSangre">
                  <h:outputText value="Factor RH" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value=""/>
                </h:panelGroup>
                <h:panelGroup id="panelMnuClaseSangre">
                  <h:selectOneMenu id="mnuClaseSangre" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"
                                   value="#{registrarLiquidosAnestesiaBean.liquidos.hclctiposangre}">
                    <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstClaseSangre}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuClaseSangre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMnuGrupoSangre">
                  <h:selectOneRadio id="mnuGrupoSangre" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"
                                    value="#{registrarLiquidosAnestesiaBean.liquidos.hclcgrupsangre}">
                    <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstGrupoSangre}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuGrupoSangre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup id="panelMenuFactorSangre">
                  <h:selectOneRadio id="mnuFactorSangre" styleClass=""
                                    rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"
                                    value="#{registrarLiquidosAnestesiaBean.liquidos.hclcfactosangre}">
                    <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstFactorSangre}"/>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuFactorSangre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value=""/>
                </h:panelGroup>
                <h:panelGroup id="panelTextNumeroUnidad">
                  <h:outputText value="N�mero de la Unidad" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextSelloCalidad">
                  <h:outputText value="Sello de Calidad" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"/>
                </h:panelGroup>
                <h:panelGroup id="panelTextFechaVencimiento">
                  <h:outputText value="Fecha Vencimiento" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"/>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value=""/>
                </h:panelGroup>
                <h:panelGroup id="panelInputNumeroUnidad">
                  <h:inputText id="itNumeroUnidad" style="width:80px" maxlength="9"
                               rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"
                               value="#{registrarLiquidosAnestesiaBean.liquidos.hclnunidasangr}"/>
                </h:panelGroup>
                <h:panelGroup id="panelInputSelloUnidad">
                  <h:inputText id="itSelloUnidad" style="width:80px" maxlength="9"
                               rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"
                               value="#{registrarLiquidosAnestesiaBean.liquidos.hclnsellocalid}"/>
                </h:panelGroup>
                <h:panelGroup id="panelCalendarVencimientoSangre">
                  <t:inputCalendar id="calendarVencimientoSangre" title="Formato: dd/mm/yyyy"
                                   onkeydown="return blockEnter(event);"
                                   rendered="#{registrarLiquidosAnestesiaBean.renderSangre}"
                                   monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                                   currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                                   renderAsPopup="true"
                                   value="#{registrarLiquidosAnestesiaBean.liquidos.hcldsangrvenci}"
                                   popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                   readonly="false" maxlength="11" size="11"
                                   popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                   renderPopupButtonAsImage="true" align="top" required="false"></t:inputCalendar>
                  <a4j:outputPanel ajaxRendered="true" rendered="#{registrarLiquidosAnestesiaBean.renderSangre}">
                    <t:message for="calendarVencimientoSangre" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                <h:panelGroup>
                  <h:outputText value=""/>
                </h:panelGroup>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelBotonAgregarFormula" columnClasses="columnaBotones">
                <t:htmlTag value="br"/>
                <h:commandButton value="Agregar" styleClass="btn btn btn-success"
                                 action="#{registrarLiquidosAnestesiaBean.agregarLiquidos}"/>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
        </a4j:region>
      </h:panelGrid>
      <s:fieldset legend="Historial Liquidos Administrados" id="fieldLiquidosAdministracion" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosAdministrados"
                     rendered="#{not empty registrarLiquidosAnestesiaBean.lstLiquidosAdministradosAnestesia}"
                     styleClass="tabContainer">
          <t:buffer into="#{table_administrados}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{registrarLiquidosAnestesiaBean.lstLiquidosAdministradosAnestesia}" rows="5"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtLiquidosAdministrados">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora  Inicio"/>
                </f:facet>
                <h:outputText value="#{item.hcldhoraactivi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora  Fin"/>
                </f:facet>
                <h:outputText value="#{item.hcldhoraactfin}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Liquido"/>
                </f:facet>
                <h:outputText value="#{item.hclcdesctipoli}"/>
                <h:outputText value="#{item.hclctipoliqadm}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad Formulada (mL)"/>
                </f:facet>
                <h:outputText value="#{item.hclncantidad}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad Suministrada (mL)"/>
                </f:facet>
                <h:outputText value="#{item.hclncantisumin}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Estado"/>
                </f:facet>
                <h:outputText value="#{item.hclcetapa}"/>
              </h:column>
            </h:dataTable>
            <t:htmlTag value="br"/>
            <h:panelGrid style="text-align:right" columns="1" id="panelTotalAdmin" border="0" cellpadding="0"
                         cellspacing="0" width="90%">
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:outputText value="Total Liquidos Administrados (#{registrarLiquidosAnestesiaBean.totalLiqAdmin} mL)"
                              styleClass="labelTextUnderLine"/>
              </h:panelGroup>
            </h:panelGrid>
          </t:buffer>
          <t:buffer into="#{tableScroller_administrados}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_4" for="dtLiquidosAdministrados" fastStep="10" pageCountVar="pageCount"
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
          <h:outputText value="#{tableScroller_administrados}" escape="false"/>
          <h:outputText value="#{table_administrados}" escape="false"/>
          <h:outputText value="#{tableScroller_administrados}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Historial Liquidos Eliminados " id="fieldLiquidosEliminacion" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosEliminadosAnteriormenteSinDatos"
                     rendered="#{empty registrarLiquidosAnestesiaBean.lstHistorialLiquidosEliminados}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosEliminadosAnteriormente"
                     rendered="#{not empty registrarLiquidosAnestesiaBean.lstHistorialLiquidosEliminados}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{registrarLiquidosAnestesiaBean.lstHistorialLiquidosEliminados}" rows="5"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtHistorialLiquidosEliminados">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora  Registro"/>
                </f:facet>
                <h:outputText value="#{item.hcldhoraactivi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Diuresis "/>
                </f:facet>
                <h:outputText value="#{item.desTipoDiuresis}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad Diuresis"/>
                </f:facet>
                <h:outputText value="#{item.cantidadDiuresis}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad  Deposiciones)"/>
                </f:facet>
                <h:outputText value="#{item.cantidadDeposiciones}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Drenaje"/>
                </f:facet>
                <h:outputText value="#{item.desTipoDrenaje}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad Drenaje"/>
                </f:facet>
                <h:outputText value="#{item.cantidadDrenaje}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="�mesis"/>
                </f:facet>
                <h:outputText value="#{(item.hclcemesis == \'S\') ? \'SI\' : \'NO\'}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad �mesis"/>
                </f:facet>
                <h:outputText value="#{item.hclnemecan}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Observaciones"/>
                </f:facet>
                <h:outputText value="#{item.hclcobsliqelim}"/>
              </h:column>
            </h:dataTable>
            <t:htmlTag value="br"/>
            <h:panelGrid style="text-align:right" columns="1" id="panelTotalElim" border="0" cellpadding="0"
                         cellspacing="0" width="90%">
              <h:outputText value=" "/>
              <h:panelGroup>
                <h:outputText value="Total Liquidos Eliminados (#{registrarLiquidosAnestesiaBean.totalLiqElim} mL)"
                              styleClass="labelTextUnderLine"/>
              </h:panelGroup>
            </h:panelGrid>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_9" for="dtHistorialLiquidosEliminados" fastStep="10" pageCountVar="pageCount"
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
    
      <s:fieldset legend="Liquidos Formulados (Medico)" id="fieldLiquidosFormuladosAnestesia" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosConsultaExterna"
                     rendered="#{empty registrarLiquidosAnestesiaBean.lstLiquidosAdministrar}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosFormuladosConsultaExterna"
                     rendered="#{not empty registrarLiquidosAnestesiaBean.lstLiquidosAdministrar}"
                     styleClass="tabContainer">
          <t:buffer into="#{table_formulados_externa}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarLiquidosAnestesiaBean.dtLiquidosFormuladosAnestesia}"
                         value="#{registrarLiquidosAnestesiaBean.lstLiquidosAdministrar}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtLiquidosFormuladosExterna">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Liquido"/>
                </f:facet>
                <h:outputText value="#{item.hclcdesctipoli}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad (mL)"/>
                </f:facet>
                <h:outputText value="#{item.hclncantidad}"/>
              </h:column>
             
              <h:column>
                <f:facet name="header">
                  <h:outputText value="M�dico"/>
                </f:facet>
                <h:outputText value="#{item.nombreOperador}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Iniciar"/>
                </f:facet>
                <a4j:commandLink id="administrarFormuladosExterna" immediate="true"
                                 onclick="if(!confirm(\' Desea Iniciar este Liquido ? \')){ return false;}"
                                 action="#{registrarLiquidosAnestesiaBean.administrarLiquidoFormulado}"
                                 reRender="fieldLiquidosEnAdministracionAnestesia,fieldLiquidosFormuladosAnestesia">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientMale.png"/>
                </a4j:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller_formulados_externa}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_ConsultaExterna" for="dtLiquidosFormuladosExterna" fastStep="10"
                              pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                              immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator"
                              renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
          <h:outputText value="#{tableScroller_formulados_externa}" escape="false"/>
          <h:outputText value="#{table_formulados_externa}" escape="false"/>
          <h:outputText value="#{tableScroller_formulados_externa}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Liquidos en Administraci�n" id="fieldLiquidosEnAdministracionAnestesia" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosParcialesAnestesiaSinDatos"
                     rendered="#{empty registrarLiquidosAnestesiaBean.lstLiquidosParciales}" styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosEnAdministracion"
                     rendered="#{not empty registrarLiquidosAnestesiaBean.lstLiquidosParciales}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                        binding="#{registrarLiquidosAnestesiaBean.dtLiquidosEnAdministracion}"
                         value="#{registrarLiquidosAnestesiaBean.lstLiquidosParciales}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtLiquidosEnAdministracion">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora  Administracion"/>
                </f:facet>
                <h:outputText value="#{item.hcldhoraactivi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Liquido"/>
                </f:facet>
                <h:outputText value="#{item.hclcdesctipoli}"/>
                <h:outputText value="#{item.hclctipoliqadm}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad (mL)"/>
                </f:facet>
                <h:outputText value="#{item.hclncantidad}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Iniciado"/>
                </f:facet>
                <h:outputText value="#{item.hclcmoduladmin}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Estado Administraci�n"/>
                </f:facet>
                <a4j:commandLink id="administrar" immediate="true"
                                 action="#{registrarLiquidosAnestesiaBean.administrarControlLiquidoIniciado}"
                                 reRender="fieldControlLiquidosAnestesia,fieldLiquidosFormuladosAnestesia">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/TestTubes.png"/>
                </a4j:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_5" for="dtLiquidosEnAdministracion" fastStep="10" pageCountVar="pageCount"
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
      <s:fieldset legend="Control Liquidos" id="fieldControlLiquidosAnestesia" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableLiquidosControlAnestesiaSinDatos"
                     rendered="#{empty registrarLiquidosAnestesiaBean.lstLiquidosParcialesIniciado}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEnControl"
                     rendered="#{not empty registrarLiquidosAnestesiaBean.lstLiquidosParcialesIniciado}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" 
                         binding="#{registrarLiquidosAnestesiaBean.dtLiquidosEnAdministracionAnestesia}"
                         value="#{registrarLiquidosAnestesiaBean.lstLiquidosParcialesIniciado}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtLiquidosEnControl">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora  Administracion"/>
                </f:facet>
                <h:outputText value="#{item.hcldhoraactivi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo Liquido"/>
                </f:facet>
                <h:outputText value="#{item.hclcdesctipoli}"/>
                <h:outputText value="#{item.hclctipoliqadm}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad (mL)"/>
                </f:facet>
                <h:outputText value="#{item.hclncantidad}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Estado de Control del liquido"/>
                </f:facet>
                <a4j:region renderRegionOnly="false">
                  <h:panelGroup>
                    <h:selectOneRadio id="mnuLiquido" required="true"
                                      value="#{registrarLiquidosAnestesiaBean.opcionLiquido}" styleClass="labelRadio">
                      <f:selectItems value="#{registrarLiquidosAnestesiaBean.lstOpcionesLiquidos}"/>
                      <a4j:support id="supportmnuLiquido" event="onclick"
                                   action="#{registrarLiquidosAnestesiaBean.ChangeOpcionLiquido}"
                                   reRender="panelTextCantidad,panelInputCantidad">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                      </a4j:support>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="mnuLiquido" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGroup>
                </a4j:region>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:panelGroup id="panelTextCantidad">
                    <h:outputText value="Cantidad Suministrada"
                                  rendered="#{registrarLiquidosAnestesiaBean.esSuspencion}"/>
                  </h:panelGroup>
                </f:facet>
                <h:panelGroup id="panelInputCantidad">
                  <h:inputText immediate="true" value="#{registrarLiquidosAnestesiaBean.cantidadSumin}" rendered="#{registrarLiquidosAnestesiaBean.esSuspencion}" >
                  <a4j:outputPanel ajaxRendered="true">
                      <t:message for="panelInputCantidad" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:inputText>
                </h:panelGroup>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Seleccionar"/>
                </f:facet>
                <a4j:commandLink value="Guardar" reRender="fieldLiquidosAdministracion,fieldLiquidosEnAdministracionAnestesia,fieldControlLiquidosAnestesia"
                                 action="#{registrarLiquidosAnestesiaBean.administrarLiquidos}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/Select.png"/>
                </a4j:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_6" for="dtLiquidosEnControl" fastStep="10" pageCountVar="pageCount"
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
      <h:panelGrid>
         <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true"
               displayAtDistanceX="-155" displayAtDistanceY="10">
        <h:commandLink id="imprimirReporteLiquidos" immediate="true" value="Visualizar Liquidos"
                       action="#{registrarLiquidosAnestesiaBean.generarReporte}">
          <t:graphicImage title="Reporte Liquidos" alt="" border="0" url="/comun/imagenes/pdfIcon.png"/>
        </h:commandLink>
        <f:facet name="popup">
          <h:panelGroup>
            <h:panelGrid columns="2" style="text-align:left;">
              <h:outputText value="Reporte Liquidos"/>
            </h:panelGrid>
          </h:panelGroup>
        </f:facet>
      </t:popup>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
      <f:subview id="generarControlLiquidosAnestesia" rendered="#{registrarLiquidosAnestesiaBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </t:panelTab>
    <t:panelTab id="panelTabEliminarLiquidos" label="Liquidos Eliminados">
      <jsp:include page="/pages/clinico/cirugia/registro/anestesia/comun/eliminarLiquidosAnestesia.jsp" flush="true"/>
    </t:panelTab>
  </t:panelTabbedPane>
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
               columnClasses="panelGridBotones">
    <h:panelGroup>
      <h:commandButton value="Siguiente" styleClass="btn btn btn-info"
                       action="#{registrarLiquidosAnestesiaBean.Siguiente}">
        <a4j:support event="onclick" status="statusButton"/>
      </h:commandButton>
    </h:panelGroup>
  </h:panelGrid>
  
</h:panelGrid>