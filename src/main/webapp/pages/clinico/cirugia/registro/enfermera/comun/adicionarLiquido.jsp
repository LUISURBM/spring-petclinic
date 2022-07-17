<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoLiquidosTab" styleClass="tabContainer">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridIngresoLiquidos" styleClass="tabContainer">
    <s:fieldset legend="#{controlLiquidosBean.legendServicio}" id="fieldCirugiasIngreso" styleClass="fieldset">
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugiasLiquidos" rowClasses="labelText,labelTextInfo">
        <h:outputText value="#{registrarNotaEnfermeriaBean.legendTablaServicio}" styleClass="labelTextOblig"/>
        <h:outputText/>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty controlLiquidosBean.lstCirugias}" cellspacing="0" width="100%" id="tableCirugiasProgramadasLiquidos"
                   styleClass="tabContainer">
        <t:buffer into="#{table}">
          <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{controlLiquidosBean.dtCirugias}" value="#{controlLiquidosBean.lstCirugias}" rows="10"
                       styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtCirugiasProgramadasLiquidos">
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
            <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasLiquidos" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                            paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
    <s:fieldset legend="Historial Liquidos Administrados" id="fieldLiquidosAdministracion" styleClass="fieldset">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosAdministrados" rendered="#{not empty controlLiquidosBean.lstLiquidosAdministrados}"
                   styleClass="tabContainer">
        <t:buffer into="#{table_administrados}">
          <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{controlLiquidosBean.lstLiquidosAdministrados}" rows="5" styleClass="standard_table"
                       rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtLiquidosAdministrados">
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
              <h:outputText value="#{item.hclcotroliqvo}"/>
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
          <h:panelGrid style="text-align:right" columns="1" id="panelTotalAdmin" border="0" cellpadding="0" cellspacing="0" width="90%">
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:outputText value="Total Liquidos Administrados (#{controlLiquidosBean.totalLiqAdmin} mL)" styleClass="labelTextUnderLine"/>
            </h:panelGroup>
          </h:panelGrid>
        </t:buffer>
        <t:buffer into="#{tableScroller_administrados}">
          <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
            <t:dataScroller id="scroll_4" for="dtLiquidosAdministrados" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                            paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminadosAnteriormenteSinDatos"
                   rendered="#{empty controlLiquidosBean.lstHistorialLiquidosEliminados}" styleClass="tabContainer">
        <h:outputText value="#{msg.msg_sin_Datos}"/>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminadosAnteriormente"
                   rendered="#{not empty controlLiquidosBean.lstHistorialLiquidosEliminados}" styleClass="tabContainer">
        <t:buffer into="#{table}">
          <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{controlLiquidosBean.lstHistorialLiquidosEliminados}" rows="5" styleClass="standard_table"
                       rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtHistorialLiquidosEliminados">
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
          <h:panelGrid columns="1" id="panelTotalElim" border="0" cellpadding="0" cellspacing="0" width="90%" style="text-align:right">
            <h:outputText value=" "/>
            <h:panelGroup>
              <h:outputText value="Total Liquidos Eliminados (#{controlLiquidosBean.totalLiqElim} mL)" styleClass="labelTextUnderLine"/>
            </h:panelGroup>
          </h:panelGrid>
        </t:buffer>
        <t:buffer into="#{tableScroller}">
          <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
            <t:dataScroller id="scroll_9" for="dtHistorialLiquidosEliminados" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                            paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelActualizarMedicamentos" columnClasses="panelGridBotones">
      <h:panelGroup>
        <a4j:commandButton value="Actualizar Liquidos" styleClass="btn btn btn-info" action="#{controlLiquidosBean.actualizarDatos}" status="statusButton" reRender="fieldLiquidosFormulados">
          <a4j:support event="onclick" status="statusButton"/>
        </a4j:commandButton>
      </h:panelGroup>
    </h:panelGrid>
    <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true" displayAtDistanceX="-155" displayAtDistanceY="10">
      <h:commandLink id="imprimirReporteLiquidos" immediate="true" value="Visualizar Liquidos" action="#{controlLiquidosBean.generarReporte}">
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
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="panelTabbedPaneIngresoLiquidos" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabIngresoLiquidos" label="Administrar Liquidos">
        <s:fieldset legend="Liquidos Formulados (M�dico)" id="fieldLiquidosFormulados" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosFormuladosNoDatos" rendered="#{empty controlLiquidosBean.lstLiquidosFormulados}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosFormulados" rendered="#{not empty controlLiquidosBean.lstLiquidosFormulados}"
                       styleClass="tabContainer">
            <t:buffer into="#{table_formulados}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{controlLiquidosBean.dtLiquidosFormulados}" value="#{controlLiquidosBean.lstLiquidosFormulados}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtLiquidosFormulados">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Liquido"/>
                  </f:facet>
                  <h:outputText value="#{item.hflcdesctipoli}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cantidad (mL)"/>
                  </f:facet>
                  <h:outputText value="#{item.hflncantidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Velocidad Adm"/>
                  </f:facet>
                  <h:outputText value="#{item.hflnvelocidadm}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Iniciar"/>
                  </f:facet>
                  <a4j:commandLink id="administrarFormulados" immediate="true" onclick="if(!confirm(\' Desea Iniciar este Liquido ? \')){ return false;}"
                                   action="#{controlLiquidosBean.administrarLiquidoFormulado}" reRender="fieldLiquidosFormulados,fieldLiquidosEnAdministracion">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientMale.png"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_formulados}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_9" for="dtLiquidosFormulados" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
            <h:outputText value="#{tableScroller_formulados}" escape="false"/>
            <h:outputText value="#{table_formulados}" escape="false"/>
            <h:outputText value="#{tableScroller_formulados}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Liquidos Formulados (Consulta Externa)" id="fieldLiquidosFormuladosConsultaExterna" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosConsultaExterna" rendered="#{empty controlLiquidosBean.lstLiquidosFormuladosExterna}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosFormuladosConsultaExterna"
                       rendered="#{not empty controlLiquidosBean.lstLiquidosFormuladosExterna}" styleClass="tabContainer">
            <t:buffer into="#{table_formulados_externa}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{controlLiquidosBean.dtLiquidosFormuladosExterna}"
                           value="#{controlLiquidosBean.lstLiquidosFormuladosExterna}" rows="10" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="dtLiquidosFormuladosExterna">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Tipo Liquido"/>
                  </f:facet>
                  <h:outputText value="#{item.hflcdesctipoli}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Cantidad (mL)"/>
                  </f:facet>
                  <h:outputText value="#{item.hflncantidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Velocidad Adm"/>
                  </f:facet>
                  <h:outputText value="#{item.hflnvelocidadm}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Iniciar"/>
                  </f:facet>
                  <a4j:commandLink id="administrarFormuladosExterna" immediate="true" onclick="if(!confirm(\' Desea Iniciar este Liquido ? \')){ return false;}"
                                   action="#{controlLiquidosBean.administrarLiquidoFormuladoExterna}"
                                   reRender="fieldLiquidosFormulados,fieldIniciarLiquidos,fieldLiquidosEnAdministracion,fieldLiquidosFormuladosConsultaExterna">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientMale.png"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_formulados_externa}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ConsultaExterna" for="dtLiquidosFormuladosExterna" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
        <s:fieldset legend="Liquidos Formulados (Anestesia)" id="fieldLiquidosFormuladosEnAnestesia" styleClass="fieldset" rendered="#{!registrarNotaEnfermeriaBean.notaEnfeProce}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEnAnestesia" rendered="#{empty controlLiquidosBean.lstLiquidosAdministrar}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosFormuladosAnestesia" rendered="#{not empty controlLiquidosBean.lstLiquidosAdministrar}"
                       styleClass="tabContainer">
            <t:buffer into="#{table_formulados_anestesia}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{controlLiquidosBean.dtLiquidosFormuladosAnestesia}" value="#{controlLiquidosBean.lstLiquidosAdministrar}"
                           rows="10" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtLiquidosFormuladosAnestesia">
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
                    <h:outputText value="Iniciar"/>
                  </f:facet>
                  <a4j:commandLink id="administrarFormuladosAnestesia" immediate="true" onclick="if(!confirm(\' Desea Iniciar este Liquido ? \')){ return false;}"
                                   action="#{controlLiquidosBean.administrarLiquidoFormuladoAnestesia}"
                                   reRender="fieldLiquidosFormulados,fieldIniciarLiquidos,fieldLiquidosEnAdministracion,fieldLiquidosFormuladosConsultaExterna,fieldLiquidosFormuladosEnAnestesia">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientMale.png"/>
                  </a4j:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_formulados_Anestesia}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_ConsultaAnestesia" for="dtLiquidosFormuladosAnestesia" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
            <h:outputText value="#{tableScroller_formulados_Anestesia}" escape="false"/>
            <h:outputText value="#{table_formulados_anestesia}" escape="false"/>
            <h:outputText value="#{tableScroller_formulados_Anestesia}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
        <!-- Liquidos Via Oral -->
        <s:fieldset legend="Liquidos Via Oral" id="fieldLiquidosViaOral" styleClass="fieldset">
          <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" id="panelLiquidosViaOral" width="100%">
            <!-- bloque 1 titulos Liquidos Via Oral-->
            <h:outputText value="Registrar Liquidos Via Oral" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:panelGroup id="panelTextListaLiquidosViaOral">
              <h:outputText value="Tipo de Liquido" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderLiquidosViaOral}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:panelGroup id="panelTextCualLiquidosViaOral">
              <h:outputText id="outputTextLabel" value="Cual?" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderLiquidosViaOralOtro}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <!-- Bloque 1 datos Liquidos Via Oral -->
            <a4j:region renderRegionOnly="false">
              <h:panelGroup>
                <h:selectOneRadio id="menuSeleccionLiquidosViaOral" required="true" immediate="true" onkeydown="return blockEnter(event);"
                                  valueChangeListener="#{controlLiquidosBean.listenLiquidosViaOral}">
                  <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
                  <a4j:support id="supportCancela" event="onclick" action="#{controlLiquidosBean.muestraLiquidosViaOral}" reRender="panelLiquidosViaOral">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneRadio>
              </h:panelGroup>
            </a4j:region>
              <t:message for="menuSeleccionLiquidosViaOral" styleClass="errorMessage"/>
            <a4j:region renderRegionOnly="false">
              <h:panelGroup id="panelGridListaLiquidosViaOral">
                <h:selectOneMenu id="mnuMotivoCancelar" required="true" rendered="#{controlLiquidosBean.renderLiquidosViaOral}" value="#{controlLiquidosBean.liquidoViaOral.hclctipoliquid}"
                                 valueChangeListener="#{controlLiquidosBean.setHclctipoliquid}" immediate="true">
                  <f:selectItem itemValue="" itemLabel="Seleccione una opci�n"/>
                  <f:selectItem itemValue="09" itemLabel="Jugo"/>
                  <f:selectItem itemValue="10" itemLabel="Agua"/>
                  <f:selectItem itemValue="11" itemLabel="Sopa"/>
                  <f:selectItem itemValue="12" itemLabel="Caldo"/>
                  <f:selectItem itemValue="0" itemLabel="Otro"/>
                  <a4j:support id="supportOtro" event="onchange" action="#{controlLiquidosBean.muestraLiquidosViaOralOtro}" reRender="panelTextCualLiquidosViaOral,panelInputTextCualLiquidosViaOral">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
                </h:selectOneMenu>
              </h:panelGroup>
            </a4j:region>
              <t:message for="panelGridListaLiquidosViaOral" styleClass="errorMessage"/>
            <h:panelGroup id="panelInputTextCualLiquidosViaOral">
              <h:inputText id="inputTextOtroViaOral" value="#{controlLiquidosBean.liquidoViaOral.hclcotroliqvo}" rendered="#{controlLiquidosBean.renderLiquidosViaOralOtro}"/>
            </h:panelGroup>
              <t:message for="inputTextOtroViaOral" styleClass="errorMessage"/>
            <!-- bloque 2 titulos Liquidos Via Oral-->
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:panelGroup id="panelTextCantidadLiquidosViaOral">
              <h:outputText value="Cantidad en mililitros(ml)." styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderLiquidosViaOral}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:panelGroup id="panelTextObservacionesLiquidosViaOral">
              <h:outputText value="Observaciones" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderLiquidosViaOral}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <!-- bloque 2 datos Liquidos Via Oral-->
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:inputText id="inputTextCantidadViaOral" value="#{controlLiquidosBean.liquidoViaOral.hclncantidad}" rendered="#{controlLiquidosBean.renderLiquidosViaOral}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="inputTextCantidadViaOral" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputTextarea id="itAreaObservacionesViaOral" onkeydown="return blockEnter(event);" style="width:200px" rendered="#{controlLiquidosBean.renderLiquidosViaOral}"
                             value="#{controlLiquidosBean.liquidoViaOral.hclcoobsliqvo}">
              <f:validateLength maximum="4000"/>
            </h:inputTextarea>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itAreaObservacionesViaOral" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <!-- Boton guardar -->
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:commandButton value="Guardar" styleClass="btn btn btn-success" onclick="if (!confirm(\'�Esta seguro de Registrar Liquido Via Oral \')) return false"
                             rendered="#{controlLiquidosBean.renderLiquidosViaOral}" action="#{controlLiquidosBean.guardarLiquidoViaOral}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGrid>
        </s:fieldset>
        <!-- fin Liquidos Via Oral -->
        <s:fieldset legend="Liquidos en Administraci�n" id="fieldLiquidosEnAdministracion" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosParcialesSinDatos" rendered="#{empty controlLiquidosBean.lstLiquidosParciales}"
                       styleClass="tabContainer">
            <h:outputText value="#{msg.msg_sin_Datos}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEnAdministracion" rendered="#{not empty controlLiquidosBean.lstLiquidosParciales}"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{controlLiquidosBean.dtLiquidosParciales}" value="#{controlLiquidosBean.lstLiquidosParciales}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtLiquidosEnAdministracionAdicionar">
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
                    <h:outputText value="Velocidad Adm.)"/>
                  </f:facet>
                  <h:outputText value="#{item.hclnvelocidadm}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Iniciado"/>
                  </f:facet>
                  <h:outputText value="#{item.nombreOperador}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estado Administraci�n"/>
                  </f:facet>
                  <h:commandLink id="administrar" immediate="true" action="#{controlLiquidosBean.administrarLiquido}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/TestTubes.png"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_lq" for="dtLiquidosEnAdministracionAdicionar" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
      </t:panelTab>
      <t:panelTab id="panelTabEliminarLiquidos" label="Liquidos Eliminados">
        <jsp:include page="/pages/clinico/cirugia/registro/enfermera/eliminarLiquidos.jsp" flush="true"/>
      </t:panelTab>
      <h:commandLink action="#{controlLiquidosBean.volver}" immediate="true" rendered="#{!controlLiquidosBean.esIngreso}">
        <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
    </t:panelTabbedPane>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelSiguienteLiquidos" columnClasses="panelGridBotones" rendered="#{controlLiquidosBean.esIngreso}">
      <h:panelGroup>
        <h:commandButton value="Siguiente" styleClass="btn btn btn-success" immediate="true" action="#{controlLiquidosBean.siguiente}">
          <a4j:support event="onclick" status="statusButton"/>
        </h:commandButton>
      </h:panelGroup>
    </h:panelGrid>
  </h:panelGrid>
  <h:panelGrid>
    <f:subview id="generarLiquidosEnfermeria" rendered="#{controlLiquidosBean.generoReporte}">
      <f:subview id="generarReporteLiquidosEnfermeria" rendered="#{controlLiquidosBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </f:subview>
    <h:panelGroup>
      <a4j:outputPanel id="ajaxRegionIngresoLiquidosMsg" ajaxRendered="true">
        <t:messages id="msgIngresoLiquidosMsg" showSummary="true" errorClass="error" globalOnly="true" layout="table" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
  </h:panelGrid>
</h:panelGrid>