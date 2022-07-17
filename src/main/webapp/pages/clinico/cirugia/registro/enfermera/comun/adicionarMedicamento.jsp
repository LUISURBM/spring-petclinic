<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                   width="100%" id="panelTabbedPaneFormulaHospitalizacion" styleClass="tabbedPane"
                   activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                   disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                   inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
  <t:panelTab id="panelTabIngresoHospitalizacion" label="Control Medicamentos">
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="panelGridFormulaHospitalizacion" styleClass="tabContainer">
      <s:fieldset legend="#{registrarMedicamentosBean.legendServicio}" id="fieldCirugiasMedicamentos" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugiasMedicamentos"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="#{registrarMedicamentosBean.legendTablaServicio}"/>
          <h:outputText/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0"
                     rendered="#{not empty registrarMedicamentosBean.lstCirugias}" cellspacing="0" width="100%"
                     id="tableCirugiasProgramadasMedicamentos" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarMedicamentosBean.dtCirugias}"
                         value="#{registrarMedicamentosBean.lstCirugias}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                         id="dtCirugiasIngresoMedicamentos">
              <h:column id="col01">
                <f:facet name="header">
                  <h:outputText id="otCodigo" value="Codigo"/>
                </f:facet>
                <h:outputText id="itCodigo" value="#{item.csvccodigo}"/>
              </h:column>
              <h:column id="col02">
                <f:facet name="header">
                  <h:outputText id="otNombre" value="Nombre"/>
                </f:facet>
                <h:outputText id="itNombre" value="#{item.csvcnombre}"/>
              </h:column>
              <h:column id="col03">
                <f:facet name="header">
                  <h:outputText id="otEstado" value="Estado"/>
                </f:facet>
                <h:outputText id="itEstado" value="#{item.csvcestado}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_ingreso" for="dtCirugiasIngresoMedicamentos" fastStep="10"
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
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelActualizarMedicamentos"
                   columnClasses="panelGridBotones">
       
          <h:panelGroup>
            <a4j:commandButton value="Actualizar Medicamentos" styleClass="btn btn btn-info"
                             action="#{registrarMedicamentosBean.actualizarDatos}" 
                             status="statusButton" reRender="fieldHospitalizacionLista">
              <a4j:support event="onclick" status="statusButton"/>
             
            </a4j:commandButton>
          </h:panelGroup>
      
      </h:panelGrid>
      <s:fieldset legend="Médicamentos Suministrados en su Totalidad " id="fieldMedicamentosSuministrados"
                  styleClass="fieldset">
        <h:panelGrid columns="1" id="panelGridConsultarMedicamentosSuministrados"
                     rendered="#{empty registrarMedicamentosBean.lstMedicamentosTerminados}">
          <h:outputText value="#{msg.msg_sin_medicamentos_suministrados}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelMedicamentosSuministradosTable"
                     rendered="#{not empty registrarMedicamentosBean.lstMedicamentosTerminados}"
                     styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{registrarMedicamentosBean.lstMedicamentosTerminados}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                         footerClass="paginacion" id="dtFormulaSuministrado">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Medicamento"/>
                </f:facet>
                <h:outputText value="#{item.hcmcmedicament}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora Dosis"/>
                </f:facet>
                <h:outputText value="#{item.hcmdfechaanota}">
                  <f:convertDateTime pattern="dd/MM/yyyy h.mm a"/>
                </h:outputText>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Presentación"/>
                </f:facet>
                <h:outputText value="#{item.hcmcpresentaci}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Dosis"/>
                </f:facet>
                <h:outputText value="#{item.hcmcadosis} #{item.hcmcunidad}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia(Horas)"/>
                </f:facet>
                <h:outputText value="#{item.hcmnfrecuadmin}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Via"/>
                </f:facet>
                <h:outputText value="#{item.hcmcviadministr}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Forma"/>
                </f:facet>
                <h:outputText value="#{item.hcmcformaadmin}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller_medicamento}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Administrados" for="dtFormulaSuministrado" fastStep="10"
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
          <h:outputText value="#{tableScroller_medicamento}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller_medicamento}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
      
      
     
      
      
      
      <a4j:region renderRegionOnly="false">
        <s:fieldset legend="Médicamentos Formulados" id="fieldHospitalizacionLista" styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridConsultarMedicamentosFormulados"
                       rendered="#{empty registrarMedicamentosBean.lstPrescripciones}">
            <h:outputText value="#{msg.msg_sin_medicamentos_formulados}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelFormulacionTable"
                       rendered="#{not empty registrarMedicamentosBean.lstPrescripciones}" styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" binding="#{registrarMedicamentosBean.dtFormula}"
                           cellspacing="0" value="#{registrarMedicamentosBean.lstPrescripciones}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtFormula">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Medicamento"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcmedicament}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Presentación"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcpresentaci}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="No."/>
                  </f:facet>
                  <h:outputText value="#{item.hfhnconsmedic}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Dosis"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcadosis} #{item.hfhcunidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Frecuencia"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhnfrecuadmin} #{item.wdescunidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Via"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcviadministr}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Forma"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Médico"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcoperador}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Administrar Medicamentos"/>
                  </f:facet>
                  <h:commandLink id="administrar" immediate="true"
                                 action="#{registrarMedicamentosBean.administrarMedicamento}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtFormula" fastStep="10" pageCountVar="pageCount"
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
        <s:fieldset legend="Médicamentos Formulados (Consulta Externa)" id="fieldMedicamentoExterna"
                    styleClass="fieldset">
          <h:panelGrid columns="1" id="panelGridConsultarMedicamentosExterna"
                       rendered="#{empty registrarMedicamentosBean.lstPrescripcionesExterna}">
            <h:outputText value="#{msg.msg_sin_medicamentos_formulados}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelFormulacionTableExterna"
                       rendered="#{not empty registrarMedicamentosBean.lstPrescripcionesExterna}"
                       styleClass="tabContainer">
            <t:buffer into="#{table_Externa}">
              <h:dataTable var="item" border="1" cellpadding="0" binding="#{registrarMedicamentosBean.dtFormulaExterna}"
                           cellspacing="0" value="#{registrarMedicamentosBean.lstPrescripcionesExterna}" rows="10"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtFormulaExterna">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Medicamento"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcmedicament}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Presentación"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcpresentaci}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Dosis"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcadosis} #{item.hfhcunidad}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Frecuencia(Horas)"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhnfrecuadmin}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Via"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcviadministr}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Forma"/>
                  </f:facet>
                  <h:outputText value="#{item.wdesforma}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Médico"/>
                  </f:facet>
                  <h:outputText value="#{item.hfhcoperador}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Administrar Medicamentos"/>
                  </f:facet>
                  <h:commandLink id="administrarExterna" immediate="true"
                                 action="#{registrarMedicamentosBean.administrarMedicamentoExterna}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller_Externa}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_Externa" for="dtFormulaExterna" fastStep="10" pageCountVar="pageCount"
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
            <h:outputText id="outConExt1" value="#{tableScroller_Externa}" escape="false"/>
            <h:outputText id="outTableExte" value="#{table_Externa}" escape="false"/>
            <h:outputText id="outConExt2" value="#{tableScroller_Externa}" escape="false"/>
          </h:panelGrid>
        </s:fieldset>
      </a4j:region>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionFormulaHospitalizacionMsg" ajaxRendered="true">
            <t:messages id="msgFormulaHospitalizacionMsg" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </h:panelGrid>
  </t:panelTab>
   
  <h:panelGrid></h:panelGrid>
</t:panelTabbedPane>